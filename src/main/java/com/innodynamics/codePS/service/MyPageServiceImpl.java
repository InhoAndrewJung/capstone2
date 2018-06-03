package com.innodynamics.codePS.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innodynamics.codePS.model.dao.MyPageDao;
import com.innodynamics.codePS.model.vo.TestSettingVO;
import com.innodynamics.codePS.model.vo.TestVO;
@Repository
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private MyPageDao myPageDao;
	
	@Override
	public List<TestSettingVO> getMakeTest(String email) throws SQLException {
		// TODO Auto-generated method stub
		return myPageDao.getMakeTest(email);
	}

	@Override
	public List<TestSettingVO> getTakeTest(String email) throws SQLException {
		// TODO Auto-generated method stub
		return myPageDao.getTakeTest(email);
	}

	@Override
	public List<TestVO> getAnswerList(String testCode, String accessCode) throws SQLException {
		// TODO Auto-generated method stub
		return myPageDao.getAnswerList(testCode, accessCode);
	}

	@Override
	public List<TestVO> getDataList(String testCode) throws SQLException {
		// TODO Auto-generated method stub
		return myPageDao.getDataList(testCode);
	}

	@Override
	public String getSourceCode(TestVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return myPageDao.getSourceCode(vo);
	}

	
}
