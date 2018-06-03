package com.innodynamics.codePS.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innodynamics.codePS.model.vo.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSession sqlSession;
	@Override
	public void registerMember(MemberVO vo) throws SQLException {
		// TODO Auto-generated method stub
		sqlSession.insert("memberSql.registerMember",vo);
	}

	@Override
	public Object emailCheck(String email) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("memberSql.idCheck",email);
	}

	@Override
	public MemberVO login(MemberVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("memberSql.login",vo);
	}

	@Override
	public void updateMember(MemberVO vo) throws SQLException {
		// TODO Auto-generated method stub
		sqlSession.update("memberSql.updateMamber",vo);
	}

	@Override
	public List<MemberVO> getAllMember() throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectList("memberSql.getAllMember");
	}

}
