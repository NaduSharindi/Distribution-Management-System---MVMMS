package com.it.piv.myceb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.myceb.domain.ComData;
import com.it.piv.myceb.domain.JobAssign;
import com.it.piv.myceb.domain.MobUser;
import com.it.piv.myceb.repo.CustomerDao;
import com.it.piv.myceb.repo.MobileUserDao;

@Controller
public class MobileUserController {
	
	@Autowired
	private MobileUserDao mobDao;
	@Autowired
	private CustomerDao cusDao;
	
	
		
	//@RequestMapping(value = "/checkUser/{username}/{password}", method = RequestMethod.GET) 
	// public @ResponseBody List<MobUser> checkUser(@PathVariable("username") String username,@PathVariable("password") String password) { 
		//return mobDao.findById(username, password);
	// } 
	
	@RequestMapping(value = "/getUser/{area}", method = RequestMethod.GET) 
	 public @ResponseBody List<MobUser> checkUser(@PathVariable("area") String area) { 
		return mobDao.findByArea(area);
	 }
	
	@RequestMapping(value = "/getMobUserByAccNo/{accountNo}", method = RequestMethod.GET) 
	 public @ResponseBody List<MobUser> getMobUserByAccNo(@PathVariable("accountNo") String accountNo) { 
		String areaCode = cusDao.getAreaCodeByAccNo(accountNo);
		System.out.print("areaCode : " + areaCode);
		return mobDao.findByArea(areaCode);
	 }
	
	@RequestMapping(value = "/getUserByDevice/{deviceID}", method = RequestMethod.GET) 
	 public @ResponseBody List<MobUser> getUserByDeviceID(@PathVariable("area") String area) { 
		return mobDao.findByArea(area);
	 }
	
	@RequestMapping(value = "/getAllMobileUser", method = RequestMethod.GET) 
	 public @ResponseBody List<MobUser> getAllMobileUser() { 
		return mobDao.getAll();
	 }
	
	@RequestMapping(value="updatelocation/{devId}/{lon}/{lat}", method=RequestMethod.GET, produces="application/json")
   	public @ResponseBody String addComment(@PathVariable("devId") String devId,@PathVariable("lon") String lon,@PathVariable("lat") String lat) {
		
		mobDao.updateLonLatForGivenID(devId, lat, lon);		//JobAssign obj = new JobAssign();
		//obj.setCcCode("12");
		return "hiii";
	}
	@RequestMapping("/viewMobileUserList/{area}")
    public ModelAndView viewMobileUserList(@PathVariable("area") String area) { 
		 RestTemplate restTemplate = new RestTemplate();
		 String url=Util.STR_SER+"getUser/{area}";
		 List users=restTemplate.getForObject(url, List.class,area);
        return new ModelAndView("viewMobileUser", "users", users);
    }
	
	
	@RequestMapping("/getUserList")
    public ModelAndView dispUser(@PathVariable("area") String areaName) { 
		 RestTemplate restTemplate = new RestTemplate();
		 String url=Util.STR_SER+"getUser/{area}";
		 List area=restTemplate.getForObject(url, List.class,areaName);
        return new ModelAndView("dispJobAssign", "area", area);
    }

}
