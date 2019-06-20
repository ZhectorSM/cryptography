package com.hector.crypto.hash;

import static org.junit.Assert.*;

import java.util.UUID;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

public class HashUtilsTest {

	@Test
	public void testGenerateRandomSalt() {
	
		byte[] salt = HashUtils.generateRandomSalt();
		assertNotNull(salt);
		System.out.println(DatatypeConverter.printHexBinary(salt));
		System.out.println("--------------------------------");
		
		
	}

	@Test
	public void testCreateSHA2Hash() throws Exception {
		
		byte[] salt = HashUtils.generateRandomSalt();
		String valueToHash = UUID.randomUUID().toString();
		
		byte[] hash1 =  HashUtils.createSHA2Hash(valueToHash, salt);
		assertNotNull(hash1);
		
//		valueToHash = UUID.randomUUID().toString();
		byte[] hash2 =  HashUtils.createSHA2Hash(valueToHash, salt);
		
		
		System.out.println(DatatypeConverter.printHexBinary(hash1));
		System.out.println(DatatypeConverter.printHexBinary(hash2));
		assertEquals(DatatypeConverter.printHexBinary(hash1),DatatypeConverter.printHexBinary(hash2));
		
		System.out.println("--------------------------------");
	}
	
	
	@Test
	public void testVerificarPasswprd() throws Exception {
		
		String secretPhrase = "Saca las panochas";
		String hashedPrase = HashUtils.hashPwd(secretPhrase);
		System.out.println("Hash -> " + hashedPrase);
		
		assertTrue(HashUtils.verifcaPwd(secretPhrase, hashedPrase));
		
	}

}
