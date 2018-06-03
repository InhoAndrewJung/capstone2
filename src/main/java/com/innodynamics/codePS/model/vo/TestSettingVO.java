package com.innodynamics.codePS.model.vo;

import org.apache.ibatis.type.Alias;

@Alias("TestSettingVO")
public class TestSettingVO {

	private String testCode;
	private String accessCode;
	private String title;
	private String testTime;
	private String count;
	private String email;
	private String questionNo;
	private String testResult;
	
	public TestSettingVO() {
		super();
	}

	

	public String getTestCode() {
		return testCode;
	}



	public void setTestCode(String testCode) {
		this.testCode = testCode;
	}



	public String getAccessCode() {
		return accessCode;
	}



	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getTestTime() {
		return testTime;
	}



	public void setTestTime(String testTime) {
		this.testTime = testTime;
	}



	public String getCount() {
		return count;
	}



	public void setCount(String count) {
		this.count = count;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getQuestionNo() {
		return questionNo;
	}



	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}



	public String getTestResult() {
		return testResult;
	}



	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}



	@Override
	public String toString() {
		return "TestSettingVO [testCode=" + testCode + ", accessCode=" + accessCode + ", title=" + title + ", testTime="
				+ testTime + ", count=" + count + ", email=" + email + ", questionNo=" + questionNo + "]";
	}


	
	
	
}
