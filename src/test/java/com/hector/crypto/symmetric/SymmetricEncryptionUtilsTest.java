/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hector.crypto.symmetric;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

/**
 *
 * @author Hector Zhiki
 */
public class SymmetricEncryptionUtilsTest {
    
    public SymmetricEncryptionUtilsTest() {
    }
    
    /**
     * Test of createAESKey method, of class SymmetricEncryptionUtils.
     * Shared Key
     */
    @Test
    public void testCreateAESKey() throws Exception {
        
        System.out.println("createAESKey");        
        SecretKey skey = SymmetricEncryptionUtils.createAESKey();
        assertNotNull(skey);
        System.out.println("Key -> " + DatatypeConverter.printHexBinary(skey.getEncoded()));
        System.out.println("--------------------------------------");
    }
    
    /**
     * Symetric encryption.  Same key
     * @throws Exception
     */
    @Test 
    public void testCodecAES() throws Exception {
    	
    	String plainText =  "zhiky  encrypted";
    	SecretKey secretKey = SymmetricEncryptionUtils.createAESKey();
    	byte[] initVector = SymmetricEncryptionUtils.createInitVector(); 
    	
    	
    	byte[] cipherText = SymmetricEncryptionUtils.performAESEncryption(plainText
    			                                    , secretKey
    			                                    , initVector);
    	
    	assertNotNull(cipherText);
    	
    	System.out.println(DatatypeConverter.printHexBinary(cipherText));
    	
    	
    	String decryptedrTxt = SymmetricEncryptionUtils.performAESDecryption(cipherText
															, secretKey
															, initVector);
    	System.out.println(decryptedrTxt);
    	assertEquals(plainText, decryptedrTxt);
    	
    	System.out.println("--------------------------------------");
    	
    }
    
    
}
