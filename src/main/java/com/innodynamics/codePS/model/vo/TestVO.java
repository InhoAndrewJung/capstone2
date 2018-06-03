package com.innodynamics.codePS.model.vo;

import org.apache.ibatis.type.Alias;

@Alias("testVO")
public class TestVO {
	private String testCode;
	private String accessCode;
	private String questionNo;
	private String title;
	private String problem;
	private String input;
	private String output;
	private String exInput;
	private String exOutput;
	private String gradeInput;
	private String gradeOutput;
	private String email;
	private String sourceCode;
	private String compileResult;
	private String testResult;
	private String name;
	
	public TestVO() {
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

	public String getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getExInput() {
		return exInput;
	}

	public void setExInput(String exInput) {
		this.exInput = exInput;
	}

	public String getExOutput() {
		return exOutput;
	}

	public void setExOutput(String exOutput) {
		this.exOutput = exOutput;
	}

	public String getGradeInput() {
		return gradeInput;
	}

	public void setGradeInput(String gradeInput) {
		this.gradeInput = gradeInput;
	}

	public String getGradeOutput() {
		return gradeOutput;
	}

	public void setGradeOutput(String gradeOutput) {
		this.gradeOutput = gradeOutput;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getCompileResult() {
		return compileResult;
	}

	public void setCompileResult(String compileResult) {
		this.compileResult = compileResult;
	}

	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}