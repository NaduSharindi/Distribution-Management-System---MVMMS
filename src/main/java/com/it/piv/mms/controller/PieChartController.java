package com.it.piv.mms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.it.piv.mms.repo.PieChartDao;
import com.it.piv.mms.domain.PieChartModel.KeyValue;

@Controller
public class PieChartController {
	
	@Autowired
	private PieChartDao pieChartDao;
	
	@RequestMapping(value = "/piechart", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<KeyValue> piechart() {
		
		
		return pieChartDao.getPieChartData();
		//modelMap.addAttribute("pieDataList", pieDataList);
		//return "index";
	}

}
