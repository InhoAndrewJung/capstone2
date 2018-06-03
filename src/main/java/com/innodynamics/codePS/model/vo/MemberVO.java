package com.innodynamics.codePS.model.vo;

import org.apache.ibatis.type.Alias;

@Alias("memberVO")
public class MemberVO {
	private String email;
	private String password;
	private String studentNo;
	private String name;
	
	public MemberVO() {
		super();
	}
	public MemberVO(String email, String password, String studentNo, String name) {
		super();
		this.email = email;
		this.password = password;
		this.studentNo = studentNo;
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "MemberVO [email=" + email + ", password=" + password + ", studentNo=" + studentNo + ", name=" + name
				+ "]";
	}	
}