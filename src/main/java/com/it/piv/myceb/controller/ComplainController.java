package com.it.piv.myceb.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.validation.Valid;

import org.h2.util.DbDriverActivator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.myceb.domain.ComData;
import com.it.piv.myceb.repo.BdDetailDao;
import com.it.piv.myceb.repo.ComplainDao;

@Controller
@RequestMapping(value = "/Complain")
public class ComplainController {
	
	@Autowired
	private ComplainDao objComplainDao;
	
	
	@Autowired
	private BdDetailDao bdDetailDao;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String displayComplin(Model model) {
		model.addAttribute("newComplain", new ComData());
		return "Complain";
	}
	
	@RequestMapping(value = "/AddComplain",method = RequestMethod.POST)
	public String registerNewCustomer(@Valid @ModelAttribute("newComplain") ComData newComplain,BindingResult result, Model model) {
		//model.addAttribute("action", "AddCustomer");
		if (!result.hasErrors()) {
			String resultobj = objComplainDao.addComplain(newComplain);
			return "redirect:/Complain";
		} else {
			//model.addAttribute("applicants", applicantdao.FindAllByFirstname());
			return "Complain";
		}
		
	}
	

	@RequestMapping(value="addComplain/{acctno}/{complain}/{longitute}/{latitute}", method=RequestMethod.GET, produces="application/json")
   	public @ResponseBody String addComplain(@PathVariable("acctno") String acctno,@PathVariable("complain") String complain,@PathVariable("longitute") String longitute,@PathVariable("latitute") String latitute) {
		
		objComplainDao.addComplainByCustomer(acctno, complain, longitute, latitute);
		//JobAssign obj = new JobAssign();
		//obj.setCcCode("12");
		return "hiii";
	}
	
	@RequestMapping(value = "/GetAll",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ComData> listAllApplicants() {
		return objComplainDao.getAll();
	}
	
	@RequestMapping(value = "/GetComplain/{comid}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ComData getComplain(@PathVariable("comid") String comid) {
		return objComplainDao.findById(comid);
	}
	
	 @RequestMapping("/listUsers")
     public ModelAndView listUsers() { 
		 RestTemplate restTemplate = new RestTemplate();
		 String url=Util.STR_SER+"Complain/GetAll";    List<LinkedHashMap> users=restTemplate.getForObject(url, List.class);
         return new ModelAndView("JobAssign", "users", users);
     }
	 
	 @RequestMapping("/dispUser/{comid}")
     public ModelAndView dispUser(@PathVariable("comid") String comid) { 
		 RestTemplate restTemplate = new RestTemplate();
		 String url=Util.STR_SER+"Complain/GetComplain/{comid}";
		 ComData user=restTemplate.getForObject(url, ComData.class,comid);
         return new ModelAndView("dispJobAssign", "user", user);
     }
	 
	 
	 @RequestMapping(value = "/GetComplainByStatus/{status}",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<ComData> GetComplainByStatus(@PathVariable("status") String status) {
			return objComplainDao.findByStatus(status);
		}
	 
	 @RequestMapping(value = "/updateStatusAceted/{comid}",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody void updateStatusAceted(@PathVariable("comid") String comid) {
			objComplainDao.updateStatus(comid);
		}
	 
	 
	 
	 
	 @RequestMapping(value = "/GetComByStatus/{status}",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<ComData> GetComByStatus(@PathVariable("status") String status) {
			return objComplainDao.findByStatus(status);
		}
	 
	 
	 @RequestMapping(value = "/getNewComaplin",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<Object[]> getNewComaplin() {
			System.out.println("getNewComaplin");
		 	String status = "Pending";
			return bdDetailDao.getPendingBD(status);
	}
		
		
	 
	 
	 
		

}
