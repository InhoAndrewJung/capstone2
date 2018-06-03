package com.innodynamics.codePS.service;

import java.sql.SQLException;
import java.util.List;

import com.innodynamics.codePS.model.vo.TestSettingVO;
import com.innodynamics.codePS.model.vo.TestVO;

public interface TestService {
	
	public void registerTest(TestVO vo)throws SQLException;
	public void registerTestSetting(TestSettingVO vo)throws SQLException;
	public List<TestVO> getTest(String testCode)throws SQLException;
	public TestSettingVO getTestSetting(String testCode)throws SQLException;
	public void updateTest(TestVO vo)throws SQLException;
	public TestVO getProblem(TestVO vo)throws SQLException;
	public void submitCode(TestVO vo)throws SQLException;
	public TestVO getSubmittedCode(TestVO vo)throws SQLException;
	public void updateTestResult(TestVO vo)throws SQLException;
	

}
