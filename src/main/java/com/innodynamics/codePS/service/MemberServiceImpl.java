package com.innodynamics.codePS.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innodynamics.codePS.model.dao.MemberDao;
import com.innodynamics.codePS.model.vo.MemberVO;

@Repository
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void registerMember(MemberVO vo) throws SQLException {
		// TODO Auto-generated method stub
		memberDao.registerMember(vo);
	}

	@Override
	public boolean idCheck(String email) throws SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
		if(memberDao.emailCheck(email)!=null) result = true;
		return result;
	}

	@Override
	public MemberVO login(MemberVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return memberDao.login(vo);
	}

	@Override
	public void updateMember(MemberVO vo) throws SQLException {
		// TODO Auto-generated method stub
		memberDao.updateMember(vo);
	}

	@Override
	public List<MemberVO> getAllMember() throws SQLException {
		// TODO Auto-generated method stub
		return memberDao.getAllMember();
	}

}
