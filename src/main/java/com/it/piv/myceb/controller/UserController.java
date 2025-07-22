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

import com.it.piv.myceb.domain.DmUseraccount;
import com.it.piv.myceb.domain.DmUseraccountPK;
import com.it.piv.myceb.domain.DmUserprofile;
import com.it.piv.myceb.repo.DmUserTransactionDao;
import com.it.piv.myceb.repo.DmUseraccountDao;
import com.it.piv.myceb.repo.DmUserprofileDao;
import com.it.piv.util.common.Util;


@Controller
public class UserController {
	
	@Autowired
	public DmUserprofileDao profileDao;
	
	@Autowired
	public DmUseraccountDao userAccDao;
	
	@Autowired
	public DmUserTransactionDao userTraAccDao;
	
	
	
	@RequestMapping(value = "/checkUser/{username}/{password}", method = RequestMethod.GET) 
	 public @ResponseBody List<String> checkUser(@PathVariable("username") String username,@PathVariable("password") String password) { 
		String  result = profileDao.findByUser(username, password);
		if(result.equalsIgnoreCase("Y")){
			return userAccDao.getAllAccountNumbersByUserName(username);
		}else{
			return null;
		}
		
	 } 
	
	@RequestMapping(value = "/updateUserProfile/{acct_num}/{mobile}/{homeNum}/{caller}/{userName}/{passWd}", method = RequestMethod.GET) 
	 public @ResponseBody String updateUserProfile(@PathVariable("acct_num") String acct_num,
			 @PathVariable("mobile") String mobile,@PathVariable("homeNum") String homeNum,
			 @PathVariable("caller") String caller,@PathVariable("userName") String userName,
			 @PathVariable("passWd") String passWd) {
		
			try {
				DmUserprofile obj= new DmUserprofile();

				obj.setUesrname(userName);
				obj.setUserpwd(passWd);
				obj.setUserstatus(Util.ACTIVE_USER);

				DmUseraccount objProfile =new DmUseraccount();
				DmUseraccountPK objProPk = new DmUseraccountPK();
				objProPk.setUsername(userName);
				objProPk.setAcctnumber(acct_num);
				
				objProfile.setMobiletel1(mobile);
				objProfile.setMobiletel2(homeNum);
				objProfile.setCallername(caller);
				objProfile.setId(objProPk);
				DmUseraccount objExits = userAccDao.findById(objProPk);
				if(objExits == null){
					userAccDao.save(objProfile);
					profileDao.update(obj);
				}else{
					userTraAccDao.update(objProfile,obj);
				}
				return "Y";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "N";
			}
			
	 }
	
	@RequestMapping(value = "/getUserAccountNumbers/{username}", method = RequestMethod.GET) 
	 public @ResponseBody List<String> getUserAccountNumbers(@PathVariable("username") String username) { 
		return userAccDao.getAllAccountNumbersByUserName(username);
	 }
	
	@RequestMapping(value = "/createNewAccount/{username}/{password}/{repassword}/{aacountnumber}/{email}", method = RequestMethod.GET) 
	 public @ResponseBody String createNewAccount(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("repassword") String repassword,@PathVariable("aacountnumber") String aacountnumber,@PathVariable("email") String email) { 
		
		
		try {
			DmUserprofile obj= new DmUserprofile();
			
			obj.setUesrname(username);
			obj.setUserpwd(password);
			obj.setUserstatus(Util.ACTIVE_USER);
			//profileDao.save(obj);
			DmUseraccount objProfile =new DmUseraccount();
			DmUseraccountPK objProPk = new DmUseraccountPK();
			objProPk.setUsername(username);
			objProPk.setAcctnumber(aacountnumber);
			objProfile.setId(objProPk);
			objProfile.setEmail(email);
			userTraAccDao.save(objProfile,obj);
			return "Y";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "N";
			
		}
	 }
	
	/*@RequestMapping(value = "/getAreaByAccountNumbers/{accNo}", method = RequestMethod.GET) 
	 public @ResponseBody String getAreaByAccountNumbers(@PathVariable("accNo") String accNo) { 
		return userAccDao.getAllAccountNumbersByUserName(username);
	 }*/
	
	

}
