package com.innodynamics.codePS.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.innodynamics.codePS.model.vo.MemberVO;

public interface MemberDao {
	public void registerMember(MemberVO vo) throws SQLException;
	public Object emailCheck(String email) throws SQLException;
	public MemberVO login(MemberVO vo) throws SQLException;
	public void updateMember(MemberVO vo)throws SQLException;
	public List<MemberVO> getAllMember() throws SQLException;
}
