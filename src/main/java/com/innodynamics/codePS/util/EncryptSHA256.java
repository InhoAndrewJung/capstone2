package com.innodynamics.codePS.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;


public class EncryptSHA256{
	 public String encrypt(String plainText) throws NoSuchAlgorithmException {
	        
	            MessageDigest md = MessageDigest.getInstance("SHA-256"); // 이 부분을 SHA-256, MD5로만 바꿔주면 된다.
	            md.update(plainText.getBytes()); // "세이프123"을 SHA-1으로 변환할 예정!
	 
	            byte byteData[] = md.digest();
	 
	            StringBuffer sb = new StringBuffer(); 
	            for(int i=0; i<byteData.length; i++) {
	                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
	            }
	 
	            String retVal = sb.toString();
	            
	        
			return retVal; // 암호화된 결과물이 반환됨. 
	    }


}
