package com.zee.zee5app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.zee.zee5app.Exception.LocationNotFoundException;
@Component
public class FileUtils {
	public byte[] readFile(File file) throws IOException{
		FileInputStream fileInputStream=new FileInputStream(file);
		byte[] allBytes=new byte[(int)file.length()];
		fileInputStream.read(allBytes);
		return allBytes;
	}
	public String writeFile(byte[] allBytes,String fileName) throws IOException {
		
		FileOutputStream fileOutputStream;
		try {
		fileOutputStream = new FileOutputStream(fileName);
		 fileOutputStream.write(allBytes);
		 return "success";
		}catch(FileNotFoundException e) {
			return "fail";
		}
		
	}
}
