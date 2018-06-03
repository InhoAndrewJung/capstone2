package com.innodynamics.codePS.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public class Compile{
	final static String PATH="C:\\test\\";
	
	public String compile(String userCode) throws IOException, InterruptedException {
		String compileRlt="";
		String compileError="";
		String finalRlt="";
		
		createFile(userCode);		
		runPython();
		
		File result = new File(PATH+"result.txt");
		File error = new File(PATH+"error.txt");
		
		//wait for creating result.txt and error.txt files
		while(!result.exists()) {
			//wait
			System.out.println("result create waiting...");
		}
		while(!error.exists()) {
			System.out.println("error create waiting...");

		}

		//Thread.sleep(200);
		Scanner scanResult = new Scanner(result,"euc-kr");
		Scanner scanError = new Scanner(error,"euc-kr");
		long dummy=0;
		//wait until result and error's file size is over 0
		while(result.length()==0 && error.length()==0 ) {
			System.out.println("waiting for compile");
			
				dummy += 1;
			
			//set Time out
			if(dummy > 30000L) break;
		}
		//preventing Infinity loop
		Thread.sleep(10);
		Runtime.getRuntime().exec("taskkill /F /IM python.exe");
		
		
		while(scanResult.hasNext()) {
			compileRlt += scanResult.nextLine()+"\r\n";
		}
		while(scanError.hasNext()) {
			compileError += scanError.nextLine()+"\r\n";
		}
		Thread.sleep(100);
		//System.out.println("result:"+compileRlt);
		//System.out.println("error:"+compileError);
		
		if(compileError == "") {
			finalRlt = compileRlt;
		}else {
			finalRlt = compileError;
		}

		scanError.close();
		scanResult.close();
	
		
		result.delete();
		error.delete();
		
		
		
		return finalRlt;
		
	}

	private void runPython() throws IOException, InterruptedException {
		File batch = new File(PATH+"runPython3.bat");
		System.out.println("runPython In");
		Desktop desk = Desktop.getDesktop();
		desk.open(batch);
		
		Thread.sleep(200);
		
		
	}

	private void createFile(String userCode) throws IOException {
		System.out.println("source In");
		System.out.println("sorce:"+userCode);
		
		File code = new File(PATH+"userCode.py");
		FileWriter fw = new FileWriter(code);
		fw.write(userCode);
		fw.close();
		
	}
	
}
