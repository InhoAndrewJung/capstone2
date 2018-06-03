package com.innodynamics.codePS.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innodynamics.codePS.model.vo.TestSettingVO;
import com.innodynamics.codePS.model.vo.TestVO;

@Repository
public class MyPageDaoImpl implements MyPageDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<TestSettingVO> getMakeTest(String email) throws SQLException {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList("myPageSql.getMakeTest", email);
	}

	@Override
	public List<TestSettingVO> getTakeTest(String email) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectList("myPageSql.getTakeTest", email);
	}

	@Override
	public List<TestVO> getAnswerList(String testCode, String accessCode) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectList("myPageSql.getAnswerList", testCode);
	}

	@Override
	public List<TestVO> getDataList(String testCode) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectList("myPageSql.getDataList", testCode);
	}

	@Override
	public String getSourceCode(TestVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("myPageSql.getSourceCode", vo);
	}

}
