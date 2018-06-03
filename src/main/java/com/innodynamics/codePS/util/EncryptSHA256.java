package com.innodynamics.codePS.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;


public class EncryptSHA256{
	 public String encrypt(String plainText) throws NoSuchAlgorithmException {
	        
	            MessageDigest md = MessageDigest.getInstance("SHA-256"); // �� �κ��� SHA-256, MD5�θ� �ٲ��ָ� �ȴ�.
	            md.update(plainText.getBytes()); // "������123"�� SHA-1���� ��ȯ�� ����!
	 
	            byte byteData[] = md.digest();
	 
	            StringBuffer sb = new StringBuffer(); 
	            for(int i=0; i<byteData.length; i++) {
	                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
	            }
	 
	            String retVal = sb.toString();
	            
	        
			return retVal; // ��ȣȭ�� ������� ��ȯ��. 
	    }


}
