/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hector.crypto.symmetric;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 *
 * @author Hector Zhiki
 */
public class SymmetricEncryptionUtils {
    
    private static final String AES = "AES";
    private static final String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
    
    public static SecretKey createAESKey() throws Exception{
        
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        keyGenerator.init(256, secureRandom);
        
        return keyGenerator.generateKey();
        
    }


    public static byte[] createInitVector(){

        byte[] initVector = new byte[16];
        SecureRandom sr = new SecureRandom();
        sr.nextBytes(initVector);

        return initVector;
    }
    
    public static byte[] performAESEncryption(String plainText, SecretKey secretKey, byte[] initVector) throws Exception {
    	
    	Cipher cipher =  Cipher.getInstance(AES_CIPHER_ALGORITHM);
    	IvParameterSpec ivParameterSpec = new IvParameterSpec(initVector);
    	cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
    	    	    	
    	return cipher.doFinal(plainText.getBytes());
    	
    }
    
    
    public static String performAESDecryption(byte[] cipherText, SecretKey secretKey, byte[] initVector) throws Exception {
    	
    	Cipher cipher =  Cipher.getInstance(AES_CIPHER_ALGORITHM);
    	IvParameterSpec ivParameterSpec = new IvParameterSpec(initVector);
    	cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
    	byte[] result = cipher.doFinal(cipherText);	
    	return new String(result);
    	
    }
    
    
}
