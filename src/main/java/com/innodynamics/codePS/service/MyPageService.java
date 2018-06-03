package com.innodynamics.codePS.service;

import java.sql.SQLException;
import java.util.List;

import com.innodynamics.codePS.model.vo.TestSettingVO;
import com.innodynamics.codePS.model.vo.TestVO;

public interface MyPageService {

	public List<TestSettingVO> getMakeTest(String email) throws SQLException;
	public List<TestSettingVO> getTakeTest(String email) throws SQLException;
	public List<TestVO> getAnswerList(String testCode, String accessCode) throws SQLException;
	public List<TestVO> getDataList(String testCode) throws SQLException;
	public String getSourceCode(TestVO vo)throws SQLException;
}
