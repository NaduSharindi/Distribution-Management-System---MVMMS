package com.it.piv.myceb.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.it.piv.myceb.domain.BdDetail;
import com.it.piv.myceb.repo.BdDetailDao;
import com.it.piv.util.common.Util;


@Controller
public class BdDetailController {
	
	@Autowired
	public BdDetailDao bdDao;
	
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static final DateFormat dateNow = new SimpleDateFormat("yyyy-MM-dd");
	
	
	@RequestMapping(value="saveComplaint/{acct_num}/{nature_code}/{cus_location}/{cus_telephone}/{cus_tele_other}/{recorded_user}/{comments}/{status}/{type_comp}/{priority_code}/{customer_type}/{bd_date}/{bd_time}/{caller_name}/{cr_cc_code}", method=RequestMethod.GET, produces="application/json")
   	public @ResponseBody String addComplain(@PathVariable("acct_num") String acct_num
   			,@PathVariable("nature_code") String nature_code
   			,@PathVariable("cus_location") String cus_location
   			,@PathVariable("cus_telephone") String cus_telephone
   			,@PathVariable("cus_tele_other") String cus_tele_other
   			,@PathVariable("recorded_user") String recorded_user
   			,@PathVariable("comments") String comments
   			,@PathVariable("status") String status
   			,@PathVariable("type_comp") String type_comp
   			,@PathVariable("priority_code") String priority_code
   			,@PathVariable("customer_type") String customer_type
   			,@PathVariable("bd_date") String bd_date
   			,@PathVariable("bd_time") String bd_time
   			,@PathVariable("caller_name") String caller_name
   			,@PathVariable("cr_cc_code") String cr_cc_code) {
		
		try {
			
			Date ddd = new Date();
	    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	    	SimpleDateFormat time = new SimpleDateFormat("hh-mm-ss");
	    	
	    	String startDate = sdf.format(ddd); 
			BdDetail obj = new BdDetail();
			obj.setComplaintNo(Util.COMPLAIN_CODE +startDate);
			obj.setAcctNum(acct_num);
			obj.setNatureCode(nature_code);
			obj.setCusLocation(cus_location);
			obj.setCusTelephone(cus_telephone);
			obj.setCusTeleOther(cus_tele_other);
			obj.setRecordedUser(recorded_user);
			obj.setComments(comments);
			obj.setStatus(status);
			obj.setTypeComp(type_comp);
			obj.setPriorityCode(priority_code);
			obj.setCustomerType(customer_type);
			Date dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(bd_date);
			obj.setBdDate(dateNow);
			obj.setBdTime(bd_time);
			obj.setCallerName(caller_name);
			obj.setCrCcCode(cr_cc_code);
			//obj.setSin("SIN1");
			//obj.setStatusCode("N");
			String result = bdDao.save(obj);
			//JobAssign obj = new JobAssign();
			//obj.setCcCode("12");
			return result;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "N";
		}
	}
	
	@RequestMapping(value="addCustomerLocation/{acct_num}", method=RequestMethod.GET, produces="application/json")
   	public @ResponseBody String getBDLocation(@PathVariable("acct_num") String acct_num){
		return null;
	}
	
	
}
