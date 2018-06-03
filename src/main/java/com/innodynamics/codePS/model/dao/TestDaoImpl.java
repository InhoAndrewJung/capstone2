package com.innodynamics.codePS.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innodynamics.codePS.model.vo.TestSettingVO;
import com.innodynamics.codePS.model.vo.TestVO;

@Repository
public class TestDaoImpl implements TestDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void registerTest(TestVO vo) throws SQLException {
		sqlSession.insert("testSql.registerTest",vo);
	}
	@Override
	public List<TestVO> getTest(String testCode) throws SQLException {
		
		return sqlSession.selectList("testSql.getTest", testCode);
	}
	@Override
	public void updateTest(TestVO vo) throws SQLException {
		sqlSession.update("testSql.updateTest",vo);
		
	}
	@Override
	public TestVO getProblem(TestVO vo) throws SQLException {
		return sqlSession.selectOne("testSql.getProblem",vo);
	}
	@Override
	public void registerTestSetting(TestSettingVO vo) throws SQLException {
		sqlSession.insert("testSettingSql.registerTestSetting",vo);
	}
	@Override
	public TestSettingVO getTestSetting(String testCode) throws SQLException {
		return sqlSession.selectOne("testSettingSql.getTestSetting",testCode);
	}
	@Override
	public void submitCode(TestVO vo) throws SQLException {
		sqlSession.insert("testSql.submitCode",vo);
	}
	@Override
	public TestVO getSubmittedCode(TestVO vo) throws SQLException {
		return sqlSession.selectOne("testSql.getSubmittedCode", vo);
	}
	@Override
	public void updateCode(TestVO vo) throws SQLException {
		sqlSession.update("testSql.updateCode",vo);
	}
	@Override
	public TestVO getTestResult(TestVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("testSql.getTestResult", vo);
	}
	@Override
	public void registerTestResult(TestVO vo) throws SQLException {
		// TODO Auto-generated method stub
		sqlSession.insert("testSql.registerTestResult",vo);
	}
	@Override
	public void updateTestResult(TestVO vo) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(vo.toString());
		sqlSession.update("testSql.updateTestResult",vo);
	}


}
