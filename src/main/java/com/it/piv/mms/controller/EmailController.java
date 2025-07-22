package com.it.piv.mms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.util.common.MailMail;

@Controller
public class EmailController {
	
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private SimpleMailMessage simpleMailMessage;

	static String emailToRecipient, emailSubject, emailMessage;
	static final String emailFromRecipient = "<!-- Source Email Address -->";

	static ModelAndView modelViewObj;

	// @Autowired
	// private JavaMailSender mailSenderObj;

	//@RequestMapping(value = { "/", "emailForm" }, method = RequestMethod.GET)
	//public ModelAndView showEmailForm(ModelMap model) {
		//modelViewObj = new ModelAndView("emailForm");
		//return modelViewObj;
	//}

	@RequestMapping(value = { "/sendMail/{dear}/{content}" }, method = RequestMethod.GET)
	public String sendMail(@PathVariable("dear") String dear, @PathVariable("content") String content) {

		System.out.println("\nIN Controller, BEFORE mm.sendMail();");
		
		 
		 //set the mailSender to the MailMail class
		
		
		MailMail mm = new MailMail();
		mm.setMailSender(mailSender);
		mm.setSimpleMailMessage(simpleMailMessage);
		mm.sendMail(dear, content);

		System.out.println("IN Controller, AFTER mm.sendMail();");

		return null;
	}
}
