package com.innodynamics.codePS.util;

import java.util.Random;

public class GenerateCode {

	public String getTestCode() {
		String code = "";
		Random rand = new Random();
		for(int i=0;i<5;i++) {
		code+=rand.nextInt(9);
		}
		
		return code;
	}
	
	public String getAccessCode() {
		String code = "";
		char ch;
		Random rand = new Random();
		for(int i=0;i<5;i++) {
			ch= (char) (rand.nextInt(26)+65);
			code+=ch;
		}
		
		return code;
	}
	
	
	
	
	
}