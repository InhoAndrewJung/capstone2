package com.innodynamics.codePS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GradeController {

	@RequestMapping("/checkGrade")
	public ModelAndView checkGrade() {
		return new ModelAndView("checkGrade");
	}
}
