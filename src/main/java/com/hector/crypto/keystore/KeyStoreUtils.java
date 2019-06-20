package com.hector.crypto.keystore;

import java.security.KeyStore;
import java.security.KeyStoreException;

import javax.crypto.SecretKey;

public class KeyStoreUtils {
	
	
	private static String SECRET_KEY_KEYSTORE_TYPE = "JCEKS";
	
	public static KeyStore createPrivateKeyJavaKeyStore(String KeyStorePwd, String alias, SecretKey secretKey, String secretKeyPwd ) throws Exception {
		
		KeyStore keyStore = KeyStore.getInstance(SECRET_KEY_KEYSTORE_TYPE);
		keyStore.load(null,KeyStorePwd.toCharArray());
		
		KeyStore.ProtectionParameter  entryPWd =  new KeyStore.PasswordProtection(secretKeyPwd.toCharArray());
		KeyStore.SecretKeyEntry privateKeyEntry = new KeyStore.SecretKeyEntry(secretKey);
		
		keyStore.setEntry(alias, privateKeyEntry, entryPWd);
		
		return keyStore;
			
	} 
	

}
