package com.innodynamics.codePS.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innodynamics.codePS.model.dao.TestDao;
import com.innodynamics.codePS.model.vo.TestSettingVO;
import com.innodynamics.codePS.model.vo.TestVO;

@Repository
public class TestServiceImpl implements TestService{

	@Autowired
	private TestDao testDao;

	@Override
	public void registerTest(TestVO vo) throws SQLException {
		if(testDao.getProblem(vo) == null) {
			
		testDao.registerTest(vo);
		}else {
			
			testDao.updateTest(vo);
		}
		
	}

	@Override
	public List<TestVO> getTest(String testCode) throws SQLException {
		
		return testDao.getTest(testCode);
	}

	@Override
	public void updateTest(TestVO vo) throws SQLException {
		testDao.updateTest(vo);
	}

	@Override
	public TestVO getProblem(TestVO vo) throws SQLException {
		return testDao.getProblem(vo);
	}

	@Override
	public void registerTestSetting(TestSettingVO vo) throws SQLException {
		testDao.registerTestSetting(vo);
	}

	@Override
	public TestSettingVO getTestSetting(String testCode) throws SQLException {
		return testDao.getTestSetting(testCode);
	}

	@Override
	public void submitCode(TestVO vo) throws SQLException {
		if(testDao.getSubmittedCode(vo) == null) {
			System.out.println(testDao.getSubmittedCode(vo));
			testDao.submitCode(vo);
		}else {
			testDao.updateCode(vo);
		}
		
	}

	@Override
	public TestVO getSubmittedCode(TestVO vo) throws SQLException {
		return testDao.getSubmittedCode(vo);
	}

	@Override
	public void updateTestResult(TestVO vo) throws SQLException {
		/*if(testDao.getTestResult(vo).equals("채점 전")) {
		testDao.registerTestResult(vo);
		}else {
			testDao.updateTestResult(vo);
		}*/
		System.out.println("서비스 진입!!!");
		System.out.println(vo.toString());
		testDao.updateTestResult(vo);
		
	}


	
}
