package com.it.piv.mms.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.mms.domain.MmsCsc;
import com.it.piv.mms.repo.MmsCscDao;

@Controller
public class MmsCscController {
	
	@Autowired
	private MmsCscDao cscDao;
	
	@RequestMapping(value = "/addCSC", method = RequestMethod.GET)
	 public ModelAndView MMSCsc(@ModelAttribute("CscSave")  MmsCsc newCsc,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception{
		 String message = "Welcome to Spring 4.0 !";
		 return new ModelAndView("MMS_addCSC", "message", message);
				
	}
	
	@RequestMapping(value = "/MMSAddCSC", method = RequestMethod.POST)
	 public ModelAndView AddCSC(@ModelAttribute("CscSave")  MmsCsc newCsc,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception {
		 String message = "Welcome to Spring 4.0 !";
		 if (!bindingResult.hasErrors()) {
			    
				String resultobj = cscDao.addCsc(newCsc);
				 
				return new ModelAndView("MMS_addCSC", "message", message);
			} else {
				 
				return new ModelAndView("MMS_addCSC", "message", message);
			}
	
	}
	
	@RequestMapping(value = "/findAllCSC",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsCsc> getCSC() {
		return cscDao.findall();
	}
	
	@RequestMapping(value = "/findActiveCSC",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsCsc> getActiveCSC() {
		return cscDao.findActiveCSC();
	}
	
	@RequestMapping("/displayCSC")
	  public ModelAndView displayCSC() {
			 RestTemplate restTemplate = new RestTemplate();
			 String url=Util.STR_SER+"findAllCSC"; List<LinkedHashMap> CSC=restTemplate.getForObject(url, List.class);
			 return new ModelAndView("editCSC", "CSC", CSC);
	}
	
	@RequestMapping(value = "/updateCSC/{id}/{csc}/{area}/{status}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateCSC(@PathVariable("id") String id,@PathVariable("csc") String csc,@PathVariable("area") String area,@PathVariable("status") String status) {
		cscDao.updateCSC(id,csc,area,status);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullException(NullPointerException ex) {

	//ModelAndView model = new ModelAndView();
	//model.setViewName("MMS_Login");

	//model.addObject("errMsg", "this is null Exception.class");
	System.out.println("Exception occured3.........");
	//return model;
	return "MMS_Login";
	} 


}
