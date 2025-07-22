package com.it.piv.myceb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@RequestMapping(value = "/WelcomePNG", method = RequestMethod.GET)
	public ModelAndView WelcomeMMS() {

		ModelAndView model = new ModelAndView();
		model.setViewName("PNG_Login");

		return model;

	}
	
	

}
