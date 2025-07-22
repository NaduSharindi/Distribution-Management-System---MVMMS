package com.it.piv.mms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.mms.repo.SpstdesthmtDao;

@Controller
public class TestFormController {
	
	@Autowired
	public SpstdesthmtDao spdao;
	
	/*@RequestMapping(value = "/helloWorld.web", method = RequestMethod.GET)
	public ModelAndView printWelcome(@ModelAttribute("user") TestForm user) {
 
		ModelAndView mav = new ModelAndView("testForm");
		mav.addObject("message", "Hello World!!!");
		return mav;
 
	}
 
	@RequestMapping(value="/submitForm.web", method = RequestMethod.POST)
    public @ResponseBody TestForm  submittedFromData(@RequestBody TestForm user, HttpServletRequest request) {	
		return user;
	}
*/	
	@RequestMapping(value="getServiceDetail", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Object[]> getServiceDetail(@RequestParam("appNo") String appNo,@RequestParam("deptId") String deptId){
		return spdao.getApprovalListDetail(appNo,deptId);
	}
	
	

}
