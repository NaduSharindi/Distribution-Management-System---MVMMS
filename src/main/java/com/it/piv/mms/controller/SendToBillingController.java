package com.it.piv.mms.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.admin.domain.Sauserm;
import com.it.piv.issue.domain.ApprovalModel;
import com.it.piv.issue.domain.PivModel;
import com.it.piv.mms.domain.Applicant;
import com.it.piv.mms.domain.Approval;
import com.it.piv.mms.domain.ApprovalMm;
import com.it.piv.mms.domain.MmsProvince;
import com.it.piv.mms.domain.Pcesthmt;
import com.it.piv.mms.repo.PcestdmtDao;
import com.it.piv.mms.repo.PcesthmtDao;

@Controller
public class SendToBillingController {
	
	@Autowired
	private PcestdmtDao pcestdao;
	
	@Autowired
	private PcesthmtDao pcesthmtdao;
	
//	@RequestMapping(value = "/sendToBillingController", method = RequestMethod.GET)
//	public ModelAndView SendToBilling() {
//		
//		ModelAndView model = new ModelAndView();
//		model.setViewName("SendToBilling");
//		
//		
//		return model;
//	}
	
	@RequestMapping(value = "/getPcesthmtList", method = RequestMethod.GET,produces ="application/json")
	public @ResponseBody List<Pcesthmt> getPcesthmtList() {
		
		List<Pcesthmt> listHmt = pcesthmtdao.getJobNoByStatus("4", "501.20");
		
		
		return listHmt;
	}
	
	
	@RequestMapping(value = "/sendToBillingController")
	public ModelAndView getPcesthmtList(HttpServletRequest request) {
		ApprovalModel model = new ApprovalModel();
		
		List<Pcesthmt>  pcesthmtList =null;
		pcesthmtList = pcesthmtdao.getJobNoByStatus("4", "501.20");

		//ModelAndView pcesthmtList = new ModelAndView();
		model.setPcesthmtList(pcesthmtList);
		
		return new ModelAndView("STB", "model", model);
		
	
	}
	
	@RequestMapping(value = "/jobCompletion")
	public ModelAndView jobCompletion(HttpServletRequest request) {
		ApprovalModel model = new ApprovalModel();
		String deptId = request.getSession().getAttribute("deptId").toString();
		
		List<Pcesthmt>  pcesthmtList =null;
		pcesthmtList = pcesthmtdao.getJobNoByStatus("1", deptId);

		//ModelAndView pcesthmtList = new ModelAndView();
		model.setPcesthmtList(pcesthmtList);
		
		return new ModelAndView("JobCompletion", "model", model);
		
	
	}

	
}