package com.innodynamics.codePS.service;

import java.sql.SQLException;
import java.util.List;

import com.innodynamics.codePS.model.vo.MemberVO;

public interface MemberService {
	public void registerMember(MemberVO vo) throws SQLException;
	public boolean idCheck(String email) throws SQLException;
	public MemberVO login(MemberVO vo) throws SQLException;
	public void updateMember(MemberVO vo) throws SQLException;
	public List<MemberVO> getAllMember() throws SQLException;
}
