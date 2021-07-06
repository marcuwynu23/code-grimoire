package com.github.peculiar.codeGrimoire.io; 


import java.nio.file.*;
import java.io.*;

public class FileBackup{
	private static FileBackup fileBackup;
	private FileBackup(){
		fileBackup = new FileBackup();
	}
	public static String readBackup(String fileBackupPath) throws IOException{
		return new String(Files.readAllBytes(Paths.get(fileBackupPath + ".backup")));
		
	}	

	public static void writeBackup(String content,String fileBackupPath) throws IOException{
		var mywriter = new FileWriter(fileBackupPath + ".backup");
		mywriter.write(content);
		mywriter.close();
	}
	public static FileBackup getFileBackupInstance(){
		return fileBackup;
	}
}