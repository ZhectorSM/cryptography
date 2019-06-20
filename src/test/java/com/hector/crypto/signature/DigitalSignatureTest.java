package com.hector.crypto.signature;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyPair;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

import com.hector.crypto.asymmetric.AsymmetricEncryptionUtils;
import com.hector.crypto.hash.HashUtils;

public class DigitalSignatureTest {

	@Test
	public void testCreateDigitaSignature() throws Exception {
		
		URL url = this.getClass().getClassLoader().getResource("demo.txt");		
		Path path = Paths.get(url.toURI());				
		byte[] data =  Files.readAllBytes(path);
		
		KeyPair keyPair = AsymmetricEncryptionUtils.createRSAKeyPair();		
		byte[] dataSigned = DigitalSignatureUtils.createDigitalSignature(data, keyPair.getPrivate());
		
		
		assertNotNull(dataSigned);
		System.out.println(DatatypeConverter.printHexBinary(dataSigned));
		
//		KeyPair keyPair2 = AsymmetricEncryptionUtils.createRSAKeyPair();		
//		assertTrue(DigitalSignatureUtils.verifyDigitaSignature(data, data, keyPair2.getPublic()));
		
	}

	@Test
	public void testVerifyDigitaSignature() throws Exception {
		
		URL url = this.getClass().getClassLoader().getResource("demo.txt");		
		Path path = Paths.get(url.toURI());				
		byte[] data =  Files.readAllBytes(path);
		
		KeyPair keyPair = AsymmetricEncryptionUtils.createRSAKeyPair();		
		byte[] dataSigned = DigitalSignatureUtils.createDigitalSignature(data, keyPair.getPrivate());
				
//		KeyPair keyPair2 = AsymmetricEncryptionUtils.createRSAKeyPair();	
		
		assertTrue(DigitalSignatureUtils.verifyDigitaSignature(data, dataSigned, keyPair.getPublic()));
		
	}
	

}
