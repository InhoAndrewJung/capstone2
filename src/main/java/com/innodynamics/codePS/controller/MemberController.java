package com.innodynamics.codePS.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.innodynamics.codePS.model.vo.MemberVO;
import com.innodynamics.codePS.service.MemberService;
import com.innodynamics.codePS.util.EncryptSHA256;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	@RequestMapping("/")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav ;
		
	}
	@RequestMapping("/signin")
	public ModelAndView signIn(HttpServletRequest request, HttpServletResponse response, HttpSession session, MemberVO vo) throws SQLException, NoSuchAlgorithmException {
		String path = "index_signfail";
		//password encrypt
		EncryptSHA256 enc = new EncryptSHA256();
		vo.setPassword(enc.encrypt(vo.getPassword()));
		MemberVO rvo = memberService.login(vo);
		int sessionTime = session.getMaxInactiveInterval();
		if(rvo !=null) {
			request.getSession().setAttribute("vo", rvo);
			request.setAttribute("sessionTime", sessionTime);
			session.setAttribute("email", rvo.getEmail());
			session.setAttribute("name", rvo.getName());
			
			path = "main";
		}			
		return new ModelAndView(path);//�α��� ������ ���ǿ� ���ε��߱� ������ ������ ��ȯ�� ����		
	}
	@RequestMapping("/signout")
	public ModelAndView signout(HttpServletRequest request, HttpServletResponse response)throws SQLException{
		HttpSession session = request.getSession();
		if(session.getAttribute("vo") != null) {
			session.invalidate();			
		}		
		return new ModelAndView("index");		
	}
	
	@RequestMapping("signup")
	public ModelAndView signUp(HttpSession session, HttpServletRequest request, MemberVO vo) throws SQLException, NoSuchAlgorithmException{
		String path = "index_registerfail";
		//password encrytion
		EncryptSHA256 enc = new EncryptSHA256();
		vo.setPassword(enc.encrypt(vo.getPassword()));
		
		memberService.registerMember(vo);
		MemberVO rvo = memberService.login(vo);
		int sessionTime = session.getMaxInactiveInterval();
		if(rvo !=null) {
			request.getSession().setAttribute("vo", vo);
			request.getSession().setAttribute("vo", rvo);
			request.setAttribute("sessionTime", sessionTime);
			session.setAttribute("email", rvo.getEmail());
			session.setAttribute("name", rvo.getName());
			path = "main";
		}	
		return new ModelAndView(path);
	}
	
	@RequestMapping("idCheck")
	public ModelAndView idcheck(String email) throws SQLException{
		boolean flag = memberService.idCheck(email);
		return new ModelAndView();
		
	}
}

