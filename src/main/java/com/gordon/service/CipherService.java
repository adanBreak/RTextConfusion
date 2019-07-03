package com.gordon.service;

import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

/**
 * Central management for getting cipher.
 * @author adanb
 *
 */
public class CipherService {
	
	static Logger logger = Logger.getLogger(CipherService.class);
	public static Cipher getCipher(int mode) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException
	{
		logger.info("Getting cipher..please make sure code is well configured.");
		/*
		 * String code = "123456"; byte[] raw = code.getBytes(Charset.forName("UTF-8"));
		 * SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		 */


		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128,new SecureRandom("123456".getBytes())); //here need to update.
		SecretKey secretKey = kgen.generateKey();
		byte[]enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(mode, key, new IvParameterSpec(new byte[16]));
		return cipher;
	}
	
	
}
