package com.gordon.app;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

/**
 * Encrypt file application.
 * 
 * Need to specify random keys. 
 * Input folders, output folders.
 * @author adanb
 *
 */
public class Encryptor {
	
	static Logger logger = Logger.getLogger(Encryptor.class);
	public static void main(String[]args) throws NoSuchAlgorithmException, NoSuchPaddingException, IOException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		
		logger.info("Getting cipher..");
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128,new SecureRandom("".getBytes())); //here need to update.
		SecretKey secretKey = kgen.generateKey();
		byte[]enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		File folder = new File("...");
		if(folder.exists())
		{
			logger.info("Encrypting files..");
			
			for(File file:folder.listFiles())
			{
				if(file.isDirectory())
				{
					
				}
				logger.info("Encrypting file： " + file.getName());
				byte[] byteContent = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
				byte[] result = cipher.doFinal(byteContent);
				
			}
		}
		
		else
		{
			logger.error("Folder not exist.");
		}
	}

}
