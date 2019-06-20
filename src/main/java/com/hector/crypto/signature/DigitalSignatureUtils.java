package com.hector.crypto.signature;


import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class DigitalSignatureUtils {
	
	
	public static final String ALGORITHM_SIGNATURE = "SHA256withRSA";
	
	
	/**
	 *  Metodo pra firmar datos digitalmente
	 * @param input Datos a encriptar
	 * @param privateKey Llave privada
	 * @return byte[] Datos firmados
	 * @throws Exception
	 */
	public static byte[] createDigitalSignature(byte[] input , PrivateKey privateKey) throws Exception {
		
		Signature sign = Signature.getInstance(ALGORITHM_SIGNATURE);
		sign.initSign(privateKey);
		sign.update(input);		
		return sign.sign();
	}
	
	/**
	 * Metodo para verificar firma digital
	 * @param input Datos originales
	 * @param signedData Datos firmados
	 * @param publicKey Llave publica
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean verifyDigitaSignature(byte[] input , byte[] signedData , PublicKey publicKey) throws Exception {
		
		Signature sign = Signature.getInstance(ALGORITHM_SIGNATURE);
		sign.initVerify(publicKey);
		sign.update(input);				
		return sign.verify(signedData);
	}
	

}
