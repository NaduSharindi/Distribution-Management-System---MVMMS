package com.it.piv.mms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.mms.domain.Customer;
import com.it.piv.mms.repo.CustomerDao;

@Controller

public class TestController {
	
	@RequestMapping(value = "/TestController", method = RequestMethod.GET)
	public ModelAndView remarks() {

		ModelAndView model = new ModelAndView();
		model.setViewName("remarks");
        return model;
	}
		
	/*	@Autowired
		public CustomerDao customerDao;
		@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
		public ModelAndView addCustomer(@ModelAttribute("SaveNewTable")   Customer line,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception{
		Customer obj = new  Customer();
	    return new ModelAndView("Customer", "SaveNewTable", obj);
		}
	  

		@RequestMapping(value = "/addCustomerPost", method = RequestMethod.POST)
	    public ModelAndView addCustomerPost(@ModelAttribute("SaveNewTable") Customer table,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception 
	    {
		   String resultobj = customerDao.add(table);
	       Customer obj = new  Customer();
	      return new ModelAndView("Customer", "SaveNewTable", obj);
	    
	    

	     
	}*/
}
