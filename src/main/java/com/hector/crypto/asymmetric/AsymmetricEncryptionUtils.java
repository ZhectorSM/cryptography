package com.hector.crypto.asymmetric;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

import javax.crypto.Cipher;

public class AsymmetricEncryptionUtils {

	
	private static final String RSA = "RSA";
    
	/**
	 * Metodo para crear par de llaves (privada y publica)
	 * @return Key Pair Llave
	 * @throws Exception
	 */
    
    public static KeyPair createRSAKeyPair() throws Exception{
        
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance(RSA);
        keyGenerator.initialize(4096,secureRandom);
        
        return keyGenerator.generateKeyPair();
        
    }
    
    
    /**
     * Metodo para encriptar datos con RSA 
     * @param plainText Texto a encriptar
     * @param privateKey Llave privada
     * @return byte[] Datos Encriptados
     * @throws Exception
     */
	
    public static byte[] performRSAEncryption(String plainText, PrivateKey privateKey) throws Exception{
    	
    	Cipher cipher =  Cipher.getInstance(RSA);
    	cipher.init(Cipher.ENCRYPT_MODE, privateKey);    	
    	
    	return cipher.doFinal(plainText.getBytes());   	
    	
    }
    
    /**
     * Metodo para desencriptar datos RSA
     * @param cipherText Texto encriptado
     * @param publicKey Llave publica
     * @return String Texto Desencriptado
     * @throws Exception
     */
    
    public static String performRSADecryption(byte[] cipherText, PublicKey publicKey) throws Exception{
    	
    	Cipher cipher =  Cipher.getInstance(RSA);
    	cipher.init(Cipher.DECRYPT_MODE, publicKey);  	
    	byte[] result = cipher.doFinal(cipherText);	
    	return new String(result);
    }
    
    
    
	
}
