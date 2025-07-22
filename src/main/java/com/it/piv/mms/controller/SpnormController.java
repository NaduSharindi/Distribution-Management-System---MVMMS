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

import com.it.piv.mms.domain.Inmatm;
import com.it.piv.mms.domain.Spnorm;
import com.it.piv.mms.repo.InwrhmapDao;
import com.it.piv.mms.repo.SpnormDao;

@Controller
public class SpnormController {
	
	@Autowired
	private SpnormDao spnormDao;
	
	@Autowired
	private InwrhmapDao inWrhDao;
	
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	 public ModelAndView AddSPNORM(@ModelAttribute("SaveSPNORAM")  Spnorm spnorm,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception{
		 String message = "Welcome to Spring 4.0 !";
				return new ModelAndView("SPNORMS", "message", message);
				
	}
	
	@RequestMapping(value = "/AddSPNORAM", method = RequestMethod.POST)
	 public ModelAndView AddSpnorm(@ModelAttribute("SaveSPNORAM")  Spnorm spnorm,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception {
		 String message = "Welcome to Spring 4.0 !";
		 if (!bindingResult.hasErrors()) {
			    
				String resultobj = spnormDao.saveForm(spnorm);
				 
				return new ModelAndView("SPNORMS", "message", message);
			} else {
				 
				return new ModelAndView("SPNORMS", "message", message);
			}
	
		   //return "AddTowerType";
	}
	
		@RequestMapping(value = "/findAllSPNORMS",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<Spnorm> getSPNORMS() {
			return spnormDao.findAll();
		}
		
		@RequestMapping("/displaySPNORMS")
		  public ModelAndView displaySPNORMS() {
				 RestTemplate restTemplate = new RestTemplate();
				 String url=Util.STR_SER+"findAllSPNORMS";    List<LinkedHashMap> Spnorms = restTemplate.getForObject(url, List.class);
		       return new ModelAndView("editSpnorms", "Spnorms", Spnorms);
		}
		
		@RequestMapping(value = "/updateSPNORMS/{linesectiontypeid}/{uom}/{standardcost}/{description}/{lineparentid}",method = RequestMethod.GET, produces = "application/json")
			public @ResponseBody void updateSPNORMS(@PathVariable("linesectiontypeid") String linesectiontypeid,@PathVariable("uom") String uom,@PathVariable("standardcost") double standardcost,@PathVariable("description") String description,@PathVariable("lineparentid") String lineparentid) {
			System.out.println("Spnorm Controller");	
			spnormDao.updateSPNORM(linesectiontypeid, uom, standardcost, description, lineparentid);
		}
		
		
		@RequestMapping(value = "/getInsulatorList",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<Inmatm> getInsulatorList(HttpServletRequest request) {
			System.out.println("getInsulatorList");
			String deptId =(String)request.getSession().getAttribute("deptId");
			return inWrhDao.getIsulatorList(deptId);
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
