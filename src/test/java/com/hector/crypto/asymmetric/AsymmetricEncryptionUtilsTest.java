package com.hector.crypto.asymmetric;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

public class AsymmetricEncryptionUtilsTest {

	@Test
	public void testCreateRSAKeyPair() throws Exception {
		
		KeyPair keypair = AsymmetricEncryptionUtils.createRSAKeyPair();
		assertNotNull(keypair);
		assertNotNull(keypair.getPrivate());
		assertNotNull(keypair.getPublic());
		
		System.out.println("Private key -> " + DatatypeConverter.printHexBinary(keypair.getPrivate().getEncoded()));
		System.out.println("Public key -> " + DatatypeConverter.printHexBinary(keypair.getPublic().getEncoded()));
		System.out.println("--------------------------------------");
	}
	
	
	/**
     * Asymmetric encryption.  Private key & Public key
     * @throws Exception
     */
    @Test 
    public void testCodecRSA() throws Exception {
    	
    	String plainText =  "zhiky  encrypted";
    	KeyPair KeyPair = AsymmetricEncryptionUtils.createRSAKeyPair();
    	PrivateKey privateKey = KeyPair.getPrivate();
    	PublicKey publicKey = KeyPair.getPublic();
    	

    	byte[] cipherText = AsymmetricEncryptionUtils.performRSAEncryption(plainText,privateKey);
    	
    	assertNotNull(cipherText);
    	
    	System.out.println(DatatypeConverter.printHexBinary(cipherText));
    	
    	
    	String decryptedrTxt = AsymmetricEncryptionUtils.performRSADecryption(cipherText , publicKey);
    	System.out.println(decryptedrTxt);
    	assertEquals(plainText, decryptedrTxt);
    	
    	System.out.println("--------------------------------------");
    	
    }

}
