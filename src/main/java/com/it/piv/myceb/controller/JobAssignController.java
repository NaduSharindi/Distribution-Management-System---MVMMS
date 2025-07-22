package com.it.piv.myceb.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;



//import org.hibernate.validator.util.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.issue.domain.PivModel;
import com.it.piv.myceb.domain.CusData;
import com.it.piv.myceb.domain.JobAssign;
import com.it.piv.myceb.domain.JobStatusOmsNew;
import com.it.piv.myceb.repo.BdDetailDao;
import com.it.piv.myceb.repo.CustomerDao;
import com.it.piv.myceb.repo.JobAssignDao;
import com.it.piv.myceb.repo.MobileUserDao;
import com.it.piv.myceb.domain.BdDetail;



@Controller
public class JobAssignController {
	
	@Autowired
	private JobAssignDao jobDao;
	
	@Autowired
	private BdDetailDao bdDetailDao;
	
	@Autowired
	private MobileUserDao mobUserDao;
	@Autowired
	private CustomerDao customerDao;
	
	
	
	@RequestMapping(value = "/JobAssign",method = RequestMethod.GET)
	public String displaySortedCustomer(Model model) {
		model.addAttribute("action", "AddCustomer");
		model.addAttribute("newCustomer", new CusData());
		//model.addAttribute("applicants", BdDetaildao.FindAllByFirstname());

		return "JobAssign";
	}
	
	@RequestMapping(value = "/getComplains/{userLog}", method = RequestMethod.GET) 
	 public @ResponseBody List<JobAssign> getLocation(@PathVariable("userLog") String userLog) {  
		List<JobAssign> complain = null;  
	  try {  
		  complain = jobDao.findComByAcCd(userLog);
		  	  
	  } catch (Exception e) {  
	   e.printStackTrace();  
	  }  
	  return complain;  
	 } 
	
	@RequestMapping(value = "/getJobs/{jobnumber}", method = RequestMethod.GET) 
	 public @ResponseBody List<JobAssign> getJobByJobNum(@PathVariable("jobnumber") String jobnumber) {  
		List<JobAssign> job = null;  
	  try {  
		  job = jobDao.findJobByJobNum(jobnumber);
		  	  
	  } catch (Exception e) {  
	   e.printStackTrace();  
	  }  
	  return job;  
	 } 
	
	
	
	@RequestMapping(value = "/getBreakDown/{userLog}/{status}", method = RequestMethod.GET) 
	 public @ResponseBody List<JobAssign> getBreakDownByStatus(@PathVariable("userLog") String userLog,@PathVariable("status") String status) {  
		List<JobAssign> complain = null;  
	  try {  
		  complain = jobDao.findComByStatus(userLog, status);
		  	  
	  } catch (Exception e) {  
	   e.printStackTrace();  
	  }  
	  return complain;  
	 } 
	
	//@RequestMapping(value = "/AddComment",method = RequestMethod.POST)
	
	@RequestMapping(value="AddComment/{comid}/{comment}", method=RequestMethod.GET, produces="application/json")
   	public @ResponseBody String addComment(@PathVariable("comid") String comid,@PathVariable("comment") String comment) {
		
		jobDao.addCommet(comid,comment);
		//JobAssign obj = new JobAssign();
		//obj.setCcCode("12");
		return "hiii";
	}
	
	@RequestMapping(value="updateStatus/{comid}/{status}", method=RequestMethod.GET, produces="application/json")
   	public @ResponseBody String statusUpdate(@PathVariable("comid") String comid,@PathVariable("status") String status) {
		jobDao.updateStatus(comid,status);
		//JobAssign obj = new JobAssign();
		//obj.setCcCode("12");
		return "hiii";
	}
	
	
	/**private static final Logger logger = LoggerFactory.make();
	@RequestMapping(value = "AddComment/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JobAssign updateCustomer(@PathVariable("id") String id, @RequestBody JobAssign jobAssign) {
		jobDao.addCommet(jobAssign);
	
        return new JobAssign();
    }*/
	
	@RequestMapping(value="statusUpdate/{refno}/{userlog}/{status_from}/{status_to}/{comment}/{exTime}", method=RequestMethod.GET, produces="application/json")
   	public @ResponseBody String statusUpdateForBD(@PathVariable("refno") String refNo,@PathVariable("userlog") String userlog,@PathVariable("status_from") String status_from,@PathVariable("status_to") String status_to,@PathVariable("comment") String comment,@PathVariable("exTime") String exTime) {
		
		jobDao.statusUpdateForBD(refNo, userlog, status_from, status_to, comment,exTime);
		//JobAssign obj = new JobAssign();
		//obj.setCcCode("12");
		return "hiii";
	}

	
	
	
	@RequestMapping(value="updateFailureCause/{refno}/{userlog}/{action}/{cause}/{detail}/{type}/{comment}", method=RequestMethod.GET, produces="application/json")
   	public @ResponseBody String updateFailureCause(@PathVariable("refno") String refNo,@PathVariable("userlog") String userlog,@PathVariable("action") String action,@PathVariable("cause") String cause,@PathVariable("detail") String detail,@PathVariable("type") String type,@PathVariable("comment") String comment) {
		
		jobDao.updateFailureCause(refNo, userlog, action, cause, detail,type,comment);
		//JobAssign obj = new JobAssign();
		//obj.setCcCode("12");
		return "hiii";
	}
	
	
	@RequestMapping(value = "/listJobAssign", method = RequestMethod.GET) 
	 public @ResponseBody List<JobAssign> listCoustomer() {  
		List<JobAssign> customer = null;  
	  try {  
		  customer = jobDao.getAll();
		  	  
	  } catch (Exception e) {  
	   e.printStackTrace();  
	  }  
	  return customer;  
	 } 
	
	@RequestMapping("/dispJobAssign")
   public ModelAndView listCustomer() { 
		 RestTemplate restTemplate = new RestTemplate();
		 String url=Util.STR_SER+"listJobAssign";    List<LinkedHashMap> users=restTemplate.getForObject(url, List.class);
        return new ModelAndView("ViewJobAssign", "users", users);
   }
	
	@RequestMapping(value = "/listJobAssignStatus", method = RequestMethod.GET) 
	 public @ResponseBody List<JobStatusOmsNew> listJobAssignStatus() {  
		List<JobStatusOmsNew> customer = null;  
	  try {  
		  customer = jobDao.getAllBreakDownStatus();
		  	  
	  } catch (Exception e) {  
	   e.printStackTrace();  
	  }  
	  return customer;  
	 } 
	
	@RequestMapping("/dispJobAssignStatus")
  public ModelAndView dispJobAssignStatus() { 
		 RestTemplate restTemplate = new RestTemplate();
		 String url=Util.STR_SER+"listJobAssignStatus";    List<LinkedHashMap> users=restTemplate.getForObject(url, List.class);
       return new ModelAndView("ViewJobAssignStatus", "users", users);
  }
	
	@RequestMapping(value="jobAssign/{objAssign}", method=RequestMethod.GET, produces="application/json")
   	public @ResponseBody String statusUpdateForBD(@PathVariable("objAssign") JobAssign objAssign) {
		
		jobDao.assignJob(objAssign);
		//JobAssign obj = new JobAssign();
		//obj.setCcCode("12");
		return "hiii";
	}
	
	@RequestMapping(value="addComToVehicle/{comNo}/{lon}/{lat}/{userlog}/{priority}/{comment}/{areaCode}", method=RequestMethod.GET, produces="application/json")
   	public @ResponseBody String addComToVehicle(@PathVariable("comNo") String comNo,@PathVariable("lon") String lon,@PathVariable("lat") String lat,@PathVariable("userlog") String userlog,@PathVariable("priority") String priority,@PathVariable("comment") String comment,@PathVariable("areaCode") String areaCode) {
		
		jobDao.addComToVehicle(comNo, lon, lat, userlog, priority, comment, areaCode);
		//JobAssign obj = new JobAssign();
		//obj.setCcCode("12");
		return "Successfully Added";
	}
	
	@RequestMapping("/jobAssign")
	  public ModelAndView jobAssign() {
		
			PivModel model = new PivModel();
			List<BdDetail> bdDetailList = bdDetailDao.findByStatus("Pending");
		
			model.setBdDetailList(bdDetailList);
			return new ModelAndView("JobAssign" ,"model", model);
	  }
	
	@RequestMapping("/jobAssignS")
	  public ModelAndView jobAssign(HttpServletRequest request,@ModelAttribute("model") PivModel model) {
		System.out.print("test : ");
		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		String loggedUser = request.getSession().getAttribute("loggedUser").toString();
		//List<BdDetail> bdDetailList = bdDetailDao.findByStatus("Pending");
		System.out.print("test1 : ");
		List<BdDetail> bdDetailList = model.getBdDetailList();
		System.out.print("test2 : ");
			int count = bdDetailList.size();
			for(int i = 0 ; i < count ;i++){
				BdDetail a = bdDetailList.get(i);
				JobAssign obj = new JobAssign();
				try {
			    	//System.out.print("test : ");
			    	//List<String> objStr = getNextVal();
			    	Date ddd = new Date();
			    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
			    	SimpleDateFormat time = new SimpleDateFormat("hh-mm-ss");
			    	
			    	String startDate = sdf.format(ddd); 
			    	//System.out.print("test : "+objStr);
			        //String.valueOf(sss);
			    	//obj.setId(String.valueOf(getNextVal()));
			        obj.setBdid("JOB-" +startDate);
			    	obj.setComplaintid(a.getComplaintNo());
			    	System.out.print("test5 : ");
			    	obj.setAreaCode(customerDao.getAreaCodeByAccNo(a.getAcctNum()));
			    	//obj.setStatusFrom(status_from);
			    	obj.setUserLog(loggedUser);
			    	obj.setJobNo("JOB-" +startDate);
			    	obj.setPriorityCode(model.getPriority());
			    	obj.setCompStatus("N");
			    	obj.setCommentA(a.getComments());
			    	//obj.setLatitute(lat);
			    	//obj.setLongitute(lon);
			    	obj.setAssignedTo(model.getMobUserObj().getAccessCode());
			    	//telephone number
			    	obj.setUnitName("+94722290071");
			    	obj.setContactnum("+94722290071");
			    	a.setStatus("Assigned");
			    	//obj.setCommentDes(comment);
			    	if(model.getMobUserObj().getAccessCode().equalsIgnoreCase("NONE")){
			    		
			    	}else{
			    		jobDao.assignJob(obj);
			    		bdDetailDao.save(a);
			    	}
			    	System.out.print("test1 : ");
			    	//em.persist(obj);
			    } catch (Exception ex) {
			    	 System.out.print("test : "+ex);
			        //txManager.rollback(status);
			    }
				
			}
			
			/*if(bdDetailList != null){
				int count = bdDetailList.size() -1;
				for (int i=0 ; i < count;i++){
					
				}
				
			}*/
			//mobUserDao.findByArea(area);
			List<BdDetail> bdDetailList1 = bdDetailDao.findByStatus("Pending");
			model.setBdDetailList(bdDetailList1);
			return new ModelAndView("JobAssign" ,"model", model);
	  }

}
