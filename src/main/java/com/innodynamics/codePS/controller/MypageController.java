package com.innodynamics.codePS.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.innodynamics.codePS.model.vo.TestSettingVO;
import com.innodynamics.codePS.model.vo.TestVO;
import com.innodynamics.codePS.service.MyPageService;
import com.innodynamics.codePS.service.TestService;
import com.innodynamics.codePS.util.Compile;
import com.innodynamics.codePS.util.CompileMarker;

@Controller
public class MypageController {
	final static String PATH="C:\\test\\";

	@Autowired 
	private MyPageService myPageService;
	@Autowired
	private TestService testService;
	
	@RequestMapping("/myPage")
	public ModelAndView mypage(ModelAndView mav, HttpSession session) throws SQLException {
		String email = (String) session.getAttribute("email");
		//내가 출제한 시험 데이터 가져오기
		List<TestSettingVO> makeList =  myPageService.getMakeTest(email);
		//내가 응시한 시험 데이터 가져오기
		List<TestSettingVO> takeList = myPageService.getTakeTest(email);
		mav.addObject("makeList", makeList);
		mav.addObject("takeList", takeList);
		mav.setViewName("myPage");
		return mav;
	}
	
	@RequestMapping("/getSourceCode")
	public ModelAndView getSourceCode(TestVO vo, ModelAndView mav) throws SQLException{
		System.out.println(vo.toString());
		String sourceCode = myPageService.getSourceCode(vo).replace("\n", "<br>");
		System.out.println(sourceCode);
		mav.addObject("source", sourceCode);
		mav.setViewName("viewSource");
		return mav;
	}
	
	@RequestMapping(value="/requestMark", produces="text/plain;charset=UTF-8")
	public @ResponseBody String Mark(String testCode, String accessCode) throws SQLException, IOException, InterruptedException {
		System.out.println(testCode+" "+accessCode);
		List<TestVO> answerList = myPageService.getAnswerList(testCode, accessCode);
		List<TestVO> dataList = myPageService.getDataList(testCode);
		/*for(TestVO avo : answerList) {
			System.out.println("answerList"+avo);
			//File GradeInput = new File(PATH + "gradeInput.txt");
			//FileWriter fw = new FileWriter(GradeInput);
			//fw.write(avo.getGradeInput());
			//fw.close();
			for(TestVO dvo : dataList) {
				CompileMarker cm = new CompileMarker();
				cm.compile(dvo.getSourceCode(),avo.getGradeInput(),avo.getGradeOutput());
				
				
			}
			
		}*/
		
		int k=0;
		while(k<dataList.size()/answerList.size()) { //answerList.size() is used instead of counts of Question
			for(int i=0; i<answerList.size();i++,k++) {
				CompileMarker cm = new CompileMarker();
				String result = cm.compile(dataList.get(k).getEmail(),dataList.get(k).getSourceCode(), answerList.get(i).getGradeInput(), answerList.get(i).getGradeOutput());
				TestVO vo = new TestVO();
				vo.setEmail(dataList.get(k).getEmail()); 
				vo.setTestCode(testCode); 
				String no = i+1+"";
				System.out.println("no:::::::"+no);
				vo.setQuestionNo(no);
				vo.setTestResult(result);
				testService.updateTestResult(vo);
			}
		}
		return "채점이 완료되었습니다";
		
	}
	
}
