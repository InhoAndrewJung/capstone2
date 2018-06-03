package com.innodynamics.codePS.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public class CompileMarker{
	final static String PATH="C:\\test\\";
	
	public String compile(String email, String userCode, String gradeInput, String gradeOutput) throws IOException, InterruptedException {
		String compileRlt="";
		String compileError="";
		String finalRlt="";
		String resultD="";
		
		//preprocess for enter value
		gradeInput = gradeInput.replace("\n", "\r\n");
		gradeOutput = gradeOutput.replace("\n", "\r\n");
		
		//end

		File gradeInputFile = new File(PATH+"gradeInput.txt");
		File gradeOutputFile = new File(PATH+"gradeOutput.txt");
		FileWriter fwGradeInput = new FileWriter(gradeInputFile);
		fwGradeInput.write(gradeInput);
		fwGradeInput.close();
		FileWriter fwGradeOutput = new FileWriter(gradeOutputFile); 
		fwGradeOutput.write(gradeOutput);
		fwGradeOutput.close();
		
		System.out.println("채점데이터 인풋: "+gradeInput);
		System.out.println("채점데이터 아웃풋: "+gradeOutput);
		
		
		
		createFile(userCode);		
		runPython();
		
		File result = new File(PATH+"resultMark.txt");
		File error = new File(PATH+"errorMark.txt");
		
		//wait for creating result.txt and error.txt files
		while(!result.exists()) {
			//wait
			//System.out.println("result create waiting...");
		}
		while(!error.exists()) {
			//System.out.println("error create waiting...");

		}

		//Thread.sleep(200);
		Scanner scanResult = new Scanner(result,"euc-kr");
		Scanner scanError = new Scanner(error,"euc-kr");
		long dummy=0;
		//wait until result and error's file size is over 0
		while(result.length()==0 && error.length()==0 ) {
			//System.out.println("waiting for compile");
			dummy += 1;
			//System.out.println(dummy);
			if(dummy > 30000L) break;
			
		}
		while(scanResult.hasNext()) {
			compileRlt += scanResult.nextLine()+"\r\n";
		}
		while(scanError.hasNext()) {
			compileError += scanError.nextLine()+"\r\n";
		}
		System.out.println("resultMark:"+compileRlt);
		System.out.println("errorMark:"+compileError);
		
		if(compileError == "") {
			finalRlt = compileRlt;
		}else {
			finalRlt = compileError;
		}

		scanError.close();
		scanResult.close();
	
		Thread.sleep(200);
		result.delete();
		error.delete();
		
		//Marking Decision Logic
		String target = finalRlt.substring(0, finalRlt.length()-2); // remove new line charactre at the End of File

		if(gradeOutput.equals(target)) {
			System.out.println(email+"은 맞았습니다");
			resultD="맞았습니다";
		}else {
			System.out.println(email+"은 틀렸습니다");
			resultD="틀렸습니다";
		}
		
		return resultD;
		
	}

	private void runPython() throws IOException, InterruptedException {
		File batch = new File(PATH+"runPython3Mark.bat");
		System.out.println("runPython In");
		Desktop desk = Desktop.getDesktop();
		desk.open(batch);
		
		//Thread.sleep(200);
		
		
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
