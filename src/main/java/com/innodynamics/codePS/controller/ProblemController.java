package com.innodynamics.codePS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProblemController {
	@RequestMapping("/makeProblem")
	public ModelAndView makeProblem() {
		return new ModelAndView("makeProblem");		
	}
	@RequestMapping("/takeProblem")
	public ModelAndView takeProblem() {
		return new ModelAndView("takeProblem");		
	}
}
