package com.innodynamics.codePS.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.innodynamics.codePS.model.vo.TestSettingVO;
import com.innodynamics.codePS.model.vo.TestVO;
import com.innodynamics.codePS.service.TestService;
import com.innodynamics.codePS.util.Compile;
import com.innodynamics.codePS.util.GenerateCode;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/makeTestStarter")
	public ModelAndView testSetting(HttpSession session, ModelAndView mav) {
		GenerateCode gc = new GenerateCode();

		String testCode = gc.getTestCode();
		String accessCode = gc.getAccessCode();
		mav.addObject("testCode", testCode);
		mav.addObject("accessCode", accessCode);
		session.setAttribute("testCode", testCode);
		session.setAttribute("accessCode", accessCode);
		mav.setViewName("makeTestStarter");
		
		return mav;
	}
	@RequestMapping("/makeTest")
	public ModelAndView makeTest(HttpSession session, TestSettingVO svo, ModelAndView mav) throws SQLException {			
		//mav.addObject("testTime", testTime);
		
		testService.registerTestSetting(svo);
		System.out.println("settingVO:"+svo.toString());
		mav.addObject("title",svo.getTitle());
		session.setAttribute("count", svo.getCount());
		mav.setViewName("makeTest");		
		return mav;
	}
	
	@RequestMapping("/takeTestStarter")
	public ModelAndView takeTestStarter() {
		return new ModelAndView("takeTestStarter");		
	}
	
	@RequestMapping("/takeTest")
	public ModelAndView takeTest(String testCode, String language,HttpSession session,ModelAndView mav) throws SQLException {
		List<TestVO> testList = testService.getTest(testCode);
		TestSettingVO testSetting = testService.getTestSetting(testCode);
		//System.out.println(testList);
		if(!testList.isEmpty()) {
		System.out.println("testCode:"+testCode+", "+"language:"+language);
		//Ensure compatibility between FE & Database "ENTER VALUE"
	//	String enterProblem="";
	/*	String enterInput="";
		String enterOutput="";
		String enterExInput="";
		String enterExOutput="";
		
		for(int i=0;i<testList.size();i++) {
			System.out.println(testList.get(i).getExInput());
			TestVO pvo = new TestVO();
			pvo = testList.get(i);
			
			if(testList.get(i).getProblem()!= null)	 pvo.setProblem(testList.get(i).getProblem().replace("\\r\\n", "<br>"));
			if(testList.get(i).getInput()!= null) pvo.setInput(testList.get(i).getInput().replace("\\r\\n", "<br>"));
			if(testList.get(i).getOutput()!= null) pvo.setOutput(testList.get(i).getOutput().replace("\\r\\n", "<br>"));
			if(testList.get(i).getExInput()!= null) pvo.setExInput(testList.get(i).getExInput().replaceAll(System.getProperty("line.separator"), "<br>"));
			if(testList.get(i).getExOutput()!= null) pvo.setExOutput(testList.get(i).getExOutput().replace("\\r\\n", "<br>"));
			
			System.out.println("pvo!!!!"+pvo);
			testList.set(i, pvo);
			//testList.get(i).setInput(enterInput);
			//testList.get(i).setOutput(enterOutput);
			//testList.get(i).setExInput(enterExInput);
			//testList.get(i).setExOutput(enterExOutput);	
			//System.out.println("수정"+testList.get(i).getExInput());
		}*/
		//END
		System.out.println("enter replace test:"+testList.get(0).getExInput());
		mav.addObject("questionCount", testList.size());
		mav.addObject("testList", testList);
		mav.addObject("title",testSetting.getTitle());
		mav.addObject("testCode",testCode);
		mav.setViewName("takeTest");
		}else {
			System.out.println("잘못된 테스트 코드 입력!!!");
			mav.addObject("data","시험코드를 다시 확인해주세요");
			mav.setViewName("takeTestStarter");
		}

		
		return mav;
		
	}
	
	@RequestMapping(value="/submitCode", produces="text/plain;charset=UTF-8")
	public @ResponseBody String submitCode(TestVO vo, HttpSession session) {
		String email = (String) session.getAttribute("email");
		vo.setEmail(email);
		String msg ="제출되었습니다.";
		System.out.println(vo.toString());
		try {
			testService.submitCode(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = "제출에 실패하였습니다.";
		}
		
		
		
		return msg;
		
	}
	
	@RequestMapping(value="/getCompileRlt", produces="text/plain;charset=UTF-8")//requestbody 한글깨짐 처리
	public @ResponseBody String getCompileRlt(String userCode) throws IOException, InterruptedException {
		System.out.println(userCode);
		Compile engine = new Compile();
		String rlt = engine.compile(userCode);
		//URLDecoder u = new URLDecoder();
		
		
		//System.out.println("!!!!!!반환 컴파일 결과 : "+rlt);
		return rlt;
		
	}
	
	@RequestMapping("/registerTest")
	public ModelAndView registerTest(TestVO vo, String count, String questionNo, ModelAndView mav) throws SQLException {
		vo.setQuestionNo(questionNo);
		mav.addObject("vo",vo);
		mav.addObject("count",count);
		mav.setViewName("makeTest");
		System.out.println(vo.toString());
		testService.registerTest(vo);
		System.out.println(vo.getProblem());
		
		return mav;
	}
	
	@RequestMapping("/main")
	public ModelAndView main() {
		return new ModelAndView("main");
	}
	
}
