package com.hector.crypto.keyStore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.security.KeyStore;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

import com.hector.crypto.keystore.KeyStoreUtils;
import com.hector.crypto.symmetric.SymmetricEncryptionUtils;

public class KeyStoreUtilsTest {

	@Test
	public void testCreatePrivateKeyJavaKeyStore() throws Exception {
		
		SecretKey secretKey = SymmetricEncryptionUtils.createAESKey();
		String secretKeyHex =  DatatypeConverter.printHexBinary(secretKey.getEncoded());
		KeyStore keyStore = KeyStoreUtils.createPrivateKeyJavaKeyStore("kesStorePwd", "foo", secretKey, "keyPwd");
		
		assertNotNull(keyStore);
		
		keyStore.load(null);
		KeyStore.ProtectionParameter  entryPWd =  new KeyStore.PasswordProtection("keyPwd".toCharArray());
		KeyStore.SecretKeyEntry resultEntry =  (KeyStore.SecretKeyEntry) keyStore.getEntry("foo", entryPWd);
		SecretKey result = resultEntry.getSecretKey();  
		String resultKeyHex =  DatatypeConverter.printHexBinary(result.getEncoded());
		
		assertEquals(secretKeyHex, resultKeyHex);
		
		
		
	}

}
