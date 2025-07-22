package com.it.piv.mms.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.admin.repo.SecurityDao;
import com.it.piv.issue.domain.PivModel;
import com.it.piv.issue.repo.JasperDao;
import com.it.piv.mms.domain.Glcompm;
import com.it.piv.mms.domain.Gldeptm;
import com.it.piv.mms.domain.MmsAddline;
import com.it.piv.mms.domain.MmsAddsupporttype;
import com.it.piv.mms.domain.MvmmsCycle;
import com.it.piv.mms.repo.ApplicantDao;
import com.it.piv.mms.repo.ApplicationDao;
import com.it.piv.mms.repo.ApprovalDao;
import com.it.piv.mms.repo.ApprovalMmDao;
import com.it.piv.mms.repo.CbpmthttDao;
import com.it.piv.mms.repo.GlcompmDao;
import com.it.piv.mms.repo.GldeptmDao;
import com.it.piv.mms.repo.IntrhmtDao;
import com.it.piv.mms.repo.LoginDao;
import com.it.piv.mms.repo.MMSAddgantryDao;
import com.it.piv.mms.repo.MmsAddConductorTypeDao;
import com.it.piv.mms.repo.MmsAddFeederDao;
import com.it.piv.mms.repo.MmsAddLineDao;
import com.it.piv.mms.repo.MmsAddLineTypeDao;
import com.it.piv.mms.repo.MmsAddSupportTypeDao;
import com.it.piv.mms.repo.MmsAddSwitchDao;
import com.it.piv.mms.repo.MmsAddsurgearrestorDao;
import com.it.piv.mms.repo.MmsAddtransformerDao;
import com.it.piv.mms.repo.MmsAreaDao;
import com.it.piv.mms.repo.MmsCscDao;
import com.it.piv.mms.repo.MmsGantrylocDao;
import com.it.piv.mms.repo.MmsInspectionDao;
import com.it.piv.mms.repo.MmsSupportDao;
import com.it.piv.mms.repo.MmsTowermaintenanceDao;
import com.it.piv.mms.repo.MmsTxntowermaintenanceDao;
import com.it.piv.mms.repo.MmsTxntowermntcomplesionDao;
import com.it.piv.mms.repo.MsttowertypeDao;
import com.it.piv.mms.repo.MtrehttDao;
import com.it.piv.mms.repo.MvmmsCycleDao;
import com.it.piv.mms.repo.PcestdttDao;
import com.it.piv.mms.repo.PcesthmtDao;
import com.it.piv.mms.repo.PcesthttDao;
import com.it.piv.mms.repo.PieChartDao;
import com.it.piv.mms.repo.ProvinceDao;
import com.it.piv.mms.repo.SpestedyConDao;
import com.it.piv.mms.repo.SpstdesthmtDao;
import com.it.piv.mms.repo.TrippingDataDao;

@Controller
public class ScheduleAndReportController {
	
	
	@Autowired
	public MmsAddLineDao lineDao;
		//----------------------------------------------------------------------------------------------------------
	@Autowired
	private PieChartDao pieChartDao;
		
		@Autowired
		public TrippingDataDao tripDao; 
		
		@Autowired
		public MmsInspectionDao insDao; 
		
	
	@Autowired
	private JasperDao jasperDao;
	@Autowired
	private MmsAddLineTypeDao mmsLineTypeDao;
	@Autowired
	private ApplicantDao applicantDao;
	@Autowired
	private SecurityDao secDao;
	@Autowired
	private SpestedyConDao spEstDao;
	@Autowired
	private ApplicationDao appDao;
	@Autowired
	private PcestdttDao pcdttDao;
	@Autowired
	private PcesthttDao pcsstDao;
	
	@Autowired
	private PcesthmtDao pchmtDao;
	
	@Autowired
	private LoginDao login;
	@Autowired
	private MsttowertypeDao towerDao;
	@Autowired
	private ProvinceDao provinceDao;
	@Autowired
	private MmsAreaDao areaDao;
	@Autowired
	private MmsCscDao cscDao;
	@Autowired
	private GldeptmDao deptDao;
	@Autowired
	private GlcompmDao glcompmDao;
	@Autowired
	private MmsTowermaintenanceDao towerMaintenance;
	
	@Autowired
	private MmsTxntowermaintenanceDao towerTxtMaintenance;
	
	@Autowired
	private MmsTxntowermntcomplesionDao towerTxtMaintenanceCompletion;
	
	@Autowired
	private MmsAddLineDao addLine;
	@Autowired
	private MmsSupportDao addSupport;
	
	@Autowired
	private ApprovalDao approval;
	
	@Autowired
	private ApprovalMmDao approvalMm;
	
	@Autowired
	private MmsAddSupportTypeDao supTypeDao;
	
	
	@Autowired
	private GldeptmDao gldeptDao;
	
	@Autowired
	private MmsAddConductorTypeDao conTpePeDao;
	@Autowired
	private MvmmsCycleDao cycleDao;
	
	@Autowired
	private MMSAddgantryDao addGantry;
	
	@Autowired
	private MmsAddFeederDao addFeeder;
	
	@Autowired
	private MmsAddSwitchDao  addSwitch;
	
	@Autowired
	private MmsAddsurgearrestorDao  saDao;
	
	@Autowired
	private MmsAddtransformerDao  trDao;
	
	@Autowired
	private MmsGantrylocDao  gantryLocDao;
	
	@Autowired
	private SpstdesthmtDao  spstdEstDao;
	
	@Autowired
	private CbpmthttDao  cbpmtDao;
	
	@Autowired
	private IntrhmtDao  inTrDao;
	
	@Autowired
	private MtrehttDao  RqDao;
	
	
	
	/*@RequestMapping(value = "/ViewScheduleAndReport", method = RequestMethod.GET)
	public ModelAndView ViewScheduleAndReport(HttpServletRequest request,@RequestParam("mode") String mode) {
		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		String province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		//List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		//List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		System.out.println("xxxx");
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    }
		//glcompmobj
		System.out.println("yyyy :"+model.getGlcompmobj());
		
		List<Gldeptm> deptTm1 = null;
		if(model.getGlcompmobj()!= null){
		if(model.getGlcompmobj().getCompId() != null){
			deptTm1 = gldeptDao.getAreaByProvince(model.getGlcompmobj().getCompId());
			int depLoop = deptTm1.size()-1;
			for(int i=0;i<=depLoop;i++){ 
				System.out.println(i);
				Gldeptm ojb = (Gldeptm)deptTm1.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		    }
			
			
			
		}
		}
		
		System.out.println("llll");

		List<MmsAddline> lineObj = null;
		if(model.getGlcompmobj()!= null){
				
		if(model.getGldeptobj().getDeptId() != null){
			lineObj = addLine.findLineByArea(model.getGldeptobj().getDeptId());
			int lineLoop = lineObj.size()-1;
			for(int i=0;i<=lineLoop;i++){ 
				System.out.println(i);
				MmsAddline ojb = lineObj.get(i);
				lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
			
			
		    }
		}
		}
		System.out.println("ppppp");

		
		if(model.getCycleObj().getId().getCycleId() != null){
			
		}
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
//		int lineLoop = lineObj.size()-1;
//		for(int i=0;i<=lineLoop;i++){ 
//			System.out.println(i);
//			MmsAddline ojb = lineObj.get(i);
//			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		
		
//	    } 
		
		Map<String,String> cycle = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 
		
		if(mode.equalsIgnoreCase("INTSUM")){
			List<Gldeptm> deptTm = gldeptDao.getArea(deptId);
			int depLoop = deptTm.size()-1;
			for(int i=0;i<=depLoop;i++){ 
				System.out.println(i);
				Gldeptm ojb = (Gldeptm)deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		    }
		}


		model.setCycleList(cycle);
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		model.setMode(mode);
		
		
		
		return new ModelAndView("schedule/ViewScheduleAndReport","model",model);
		
		
		
		
		
		
		
		
		
		
		//return new ModelAndView("ViewHotlineMaintenance");
		

	}
*/

}
