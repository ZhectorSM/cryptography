package com.hector.crypto.hash;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.mindrot.jbcrypt.BCrypt;

public class HashUtils {
	
	
	private static String SHA2_ALGORITHM = "SHA-256";
	
	
	public static byte[] generateRandomSalt() {
		
		byte[] salt =  new byte[16];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(salt);
		
		return salt;		
	}
	
	public static byte[] createSHA2Hash(String input, byte[] salt) throws Exception {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(salt);
		baos.write(input.getBytes());
		
		byte[] valueTohash = baos.toByteArray();		
		MessageDigest msgDigest = MessageDigest.getInstance(SHA2_ALGORITHM);		
		
		return msgDigest.digest(valueTohash);
	}
	
	
	public static String hashPwd(String pwd) {
		
		return BCrypt.hashpw(pwd, BCrypt.gensalt());	
		
	}
	
	public static boolean verifcaPwd(String plaintext , String hashedPwd) {
		
		return BCrypt.checkpw(plaintext, hashedPwd);
		
	}
	
	
	

}
