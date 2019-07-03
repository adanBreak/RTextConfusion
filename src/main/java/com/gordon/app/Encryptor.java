package com.gordon.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

import org.apache.commons.io.FileUtils;
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
		kgen.init(128,new SecureRandom("123456".getBytes())); //here need to update.
		SecretKey secretKey = kgen.generateKey();
		byte[]enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		File inputFolder = new File("d:\\novels1"); //here need to upate.
		File outputFolder = new File("d:\\novels2");
		
		if(!inputFolder.exists() || !outputFolder.exists())
		{
			logger.error("Folders you specify doesn't exist.");
			throw new FileNotFoundException("Folders you specify doesn't exist.");
		}
		
		if(!inputFolder.isDirectory() || !outputFolder.isDirectory())
		{
			logger.error("Folders you specify should be a directory.");
			throw new FileNotFoundException("Folders you specify should be a directory.");
		}
		
		logger.info("Encrypting files..");
		
		for(File originalfile:inputFolder.listFiles())
		{
			String fileName = originalfile.getName();
			if(originalfile.isFile() && fileName.endsWith(".txt"))
			{
				logger.info("Encrypting file： " + originalfile.getName());
				byte[] byteContent = Files.readAllBytes(Paths.get(originalfile.getAbsolutePath()));
				byte[] result = cipher.doFinal(byteContent);
				File outputFile = new File(outputFolder, fileName);
				FileUtils.writeByteArrayToFile(outputFile, result);
			}
			
			
		}
		
		logger.info("Done.");
		
	}

}
