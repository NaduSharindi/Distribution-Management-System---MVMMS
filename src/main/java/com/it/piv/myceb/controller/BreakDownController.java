package com.it.piv.myceb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.it.piv.myceb.domain.BdDetail;
import com.it.piv.myceb.domain.ComData;
import com.it.piv.myceb.repo.BdDetailDao;


@Controller
public class BreakDownController {
	
	@Autowired
	private BdDetailDao bdDao;
	
	@RequestMapping(value = "/getBreakDown/{accNo}", method = RequestMethod.GET) 
	 public @ResponseBody List<BdDetail> getBreakDownLocation(@PathVariable("accNo") String accNo) {  
		System.out.print("BdDetail");
		List<BdDetail> objBd = null;  
	  try {  
		  System.out.print("BdDetail 1");
		  objBd = bdDao.findByAccNo(accNo);
		  System.out.print("BdDetail 2");
	  
	  } catch (Exception e) {  
	   e.printStackTrace();  
	  }  
	  return objBd;  
	 } 
	
	@RequestMapping(value = "/BDLocation/{id}", method = RequestMethod.GET) 
	 public @ResponseBody ComData getLocation(@PathVariable("id") String id) {  
		System.out.print("ComplData");
		ComData location = null;  
	  try {  
		  location = bdDao.findById(id.trim());
		  	  
	  } catch (Exception e) {  
	   e.printStackTrace();  
	  }  
	  return location;  
	 } 
	 
	
	
	
	
}
