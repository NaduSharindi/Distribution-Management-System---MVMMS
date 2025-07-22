package com.it.piv.myceb.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.myceb.domain.DmCustomerlocation;
import com.it.piv.myceb.domain.DmCustomerlocationPK;
import com.it.piv.myceb.domain.DmUseraccount;
import com.it.piv.myceb.domain.DmUseraccountPK;
import com.it.piv.myceb.domain.DmUserprofile;
import com.it.piv.myceb.repo.CustomerLocationDao;
import com.it.piv.myceb.repo.DmUserTransactionDao;
import com.it.piv.myceb.repo.DmUseraccountDao;
import com.it.piv.myceb.repo.DmUserprofileDao;
import com.it.piv.myceb.repo.LocationUpdateDao;
import com.it.piv.util.common.Util;
import com.it.piv.myceb.domain.LocationUpdate;


@Controller
public class LocationController {
	
	
	@Autowired
	public CustomerLocationDao locationDao;
	
	@Autowired
	public LocationUpdateDao MobileLocatioDao;
	
	
	@RequestMapping(value = "/saveCustomerLocation/{acct_num}/{longitude}/{latitude}/", method = RequestMethod.GET) 
	 public @ResponseBody String saveCustomerLocation(@PathVariable("acct_num") String acct_num,@PathVariable("longitude") String longitude,@PathVariable("latitude") String latitude) { 
		try {
			 
			DmCustomerlocation obj = new DmCustomerlocation();
			DmCustomerlocationPK objPk = new DmCustomerlocationPK();
			objPk.setAcctnumber(acct_num);
			objPk.setLocationLon(longitude);
			objPk.setLocationLat(latitude);
			obj.setId(objPk);
			locationDao.save(obj);
			return "Y";
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "N";
		}
		
	 }
	
	
	 @RequestMapping(value = "/getAllLocation", method = RequestMethod.GET) 
	 public @ResponseBody List<LocationUpdate> getAllLocation() {
		 System.out.println("hiiii");
	  List<LocationUpdate> location = null;  
	  try {  
		  location = MobileLocatioDao.getAll();  
	  
	  } catch (Exception e) {  
	   e.printStackTrace();  
	  }  
	  return location;  
	 }  
	
	

}
