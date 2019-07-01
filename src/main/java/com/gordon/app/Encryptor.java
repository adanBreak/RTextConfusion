package com.gordon.app;

import java.io.File;

public class Encryptor {
	
	public static void main(String[]args)
	{
		File folder = new File("...");
		
		
		
		if(folder.exists())
		{
			System.out.println("Encrypting files..");
			
			for(File file:folder.listFiles())
			{
				System.out.println("Encrypting file： " + file.getName());
				
			}
		}
		
		else
		{
			System.out.println("Folder not exist.");
		}
	}

}
