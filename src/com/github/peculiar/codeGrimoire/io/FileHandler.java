package com.github.peculiar.codeGrimoire.io; 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import com.github.peculiar.codeGrimoire.model.ContentData;

public class FileHandler {

	public static void createObjectFile(ContentData data, String filePath) {
		try {
			var objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(filePath)));
			objectOutputStream.writeObject((Object)data);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static ContentData readObjectFile(String filePath) {
		ContentData obj;
		try {
			var objectInputStream = new ObjectInputStream(new FileInputStream(new File(filePath)));
			obj = (ContentData) objectInputStream.readObject();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
