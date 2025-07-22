package com.it.piv.mms.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.piv.mms.domain.MmsMntplan;

import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;

import org.apache.cxf.helpers.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.it.piv.admin.domain.Sauserm;
import com.it.piv.admin.domain.SausermMm;
import com.it.piv.admin.repo.SecurityDao;
import com.it.piv.issue.domain.ApprovalModel;
import com.it.piv.issue.domain.PcesthttModel;
import com.it.piv.issue.domain.PivModel;
import com.it.piv.issue.repo.JasperDao;
import com.it.piv.mms.domain.Appestlim;
import com.it.piv.mms.domain.Application;
import com.it.piv.mms.domain.ApplicationPK;
import com.it.piv.mms.domain.Approval;
import com.it.piv.mms.domain.ApprovalMm;
import com.it.piv.mms.domain.Cbpmthtt;
import com.it.piv.mms.domain.Glcompm;
import com.it.piv.mms.domain.Gldeptm;
import com.it.piv.mms.domain.MmsAddline;
import com.it.piv.mms.domain.MmsAddsupport;
import com.it.piv.mms.domain.MmsAddsupporttype;
import com.it.piv.mms.domain.MmsCompletion;
import com.it.piv.mms.domain.MmsTxntowermaintenance;
import com.it.piv.mms.domain.MmsTxntowermaintenancePK;
import com.it.piv.mms.domain.MmsTxntowermntcomplesion;
import com.it.piv.mms.domain.MmsTxntowermntcomplesionPK;
import com.it.piv.mms.domain.MvmmsCycle;
import com.it.piv.mms.domain.PCB_Division;
import com.it.piv.mms.domain.PcbCondition;
import com.it.piv.mms.domain.PcbEquipment;
import com.it.piv.mms.domain.PcbLocation;
import com.it.piv.mms.domain.PcbModel;
import com.it.piv.mms.domain.PcbSample;
import com.it.piv.mms.domain.Pcesthtt;
import com.it.piv.mms.domain.PcesthttPK;
import com.it.piv.mms.domain.Speststd;
import com.it.piv.mms.domain.SpeststdPK;
import com.it.piv.mms.domain.Spstdesthmt;
import com.it.piv.mms.domain.SpstdesthmtPK;
import com.it.piv.mms.domain.Summary;
import com.it.piv.mms.domain.TrippingData;
import com.it.piv.mms.repo.AppestlimDao;
import com.it.piv.mms.repo.ApplicantDao;
import com.it.piv.mms.repo.ApplicationDao;
import com.it.piv.mms.repo.ApprovalDao;
import com.it.piv.mms.repo.ApprovalMmDao;
import com.it.piv.mms.repo.CbpmthttDao;
import com.it.piv.mms.repo.GlcompmDao;
import com.it.piv.mms.repo.GldeptmDao;
import com.it.piv.mms.repo.IntrhmtDao;
import com.it.piv.mms.repo.InwrhmapDao;
import com.it.piv.mms.repo.LoginDao;
import com.it.piv.mms.repo.MMSAddgantryDao;
import com.it.piv.mms.repo.MmsAddLineDao;
import com.it.piv.mms.repo.MmsAddLineTypeDao;
import com.it.piv.mms.repo.MmsAddSupportTypeDao;
import com.it.piv.mms.repo.MmsAreaDao;
import com.it.piv.mms.repo.MmsCompletionDao;
import com.it.piv.mms.repo.MmsMntplanDao;
import com.it.piv.mms.repo.MmsSupportDao;
import com.it.piv.mms.repo.MmsTowermaintenanceDao;
import com.it.piv.mms.repo.MmsTxntowermaintenanceDao;
import com.it.piv.mms.repo.MmsTxntowermntcomplesionDao;
import com.it.piv.mms.repo.MsttowertypeDao;
import com.it.piv.mms.repo.MtrehttDao;
import com.it.piv.mms.repo.MvmmsCycleDao;
import com.it.piv.mms.repo.PcestdttDao;
import com.it.piv.mms.repo.PcesthttDao;
import com.it.piv.mms.repo.ProvinceDao;
import com.it.piv.mms.repo.SpestedyConDao;
//import com.it.piv.mms.repo.SpestedyDao;
import com.it.piv.mms.repo.SpeststdDao;
import com.it.piv.mms.repo.SpstdesthmtDao;
import com.it.piv.mms.repo.TrippingDataDao;
import com.it.piv.util.common.EstimateStatus;
import com.it.piv.util.common.Format;
import com.it.piv.util.common.MailMail;
import com.it.piv.util.common.PathMMS;
import com.it.piv.util.common.StandardEstimateStatus;

@Controller
public class TMController {
	
	@Autowired
	private JasperDao jasperDao;
	
	@Autowired
	private MmsMntplanDao mntPlanDao;
	
	
	@Autowired
	private MmsCompletionDao comDao;
	
	
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
	private LoginDao login;
	@Autowired
	private MsttowertypeDao towerDao;
	@Autowired
	private ProvinceDao provinceDao;
	@Autowired
	private MmsAreaDao areaDao;
	@Autowired
	private GldeptmDao deptDao;
	@Autowired
	private GlcompmDao glcompmDao;
	@Autowired
	private MmsTowermaintenanceDao towerMaintenance;
	
	@Autowired
	private MmsTxntowermaintenanceDao towerTxtMaintenance;
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
	private MvmmsCycleDao cycleDao;
	
	
	@Autowired
	private GldeptmDao gldeptDao;
	
	@Autowired
	public MmsAddLineDao lineDao;
	
	@Autowired
	public PcesthttDao pcestDao;
	
	@Autowired
	public SpstdesthmtDao stdEstDao;
	
	@Autowired
	public AppestlimDao appEstLimDao; 
	
	@Autowired
	public SpeststdDao spestDao; 
	
	@Autowired
	public CbpmthttDao cbpmtDao; 
	
	
	@Autowired
	public InwrhmapDao inwrhDao; 
	
	@Autowired
	public TrippingDataDao tripDao; 
	
	@Autowired
	public  IntrhmtDao intrDao; 
	
	@Autowired
	public  MtrehttDao RqDao; 
	
	@Autowired
	public  MMSAddgantryDao gantryDao; 
	
	
	
	@Autowired
	private MmsTxntowermntcomplesionDao complesionMaintenanceDao;
	
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static final DateFormat dateNow = new SimpleDateFormat("yyyy-MM-dd");
	
	@RequestMapping(value = "/viewTMnewApprove", method = RequestMethod.GET)
	public ModelAndView viewTMnewApprove(HttpServletRequest request) {
		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		Map<String,String> cycle = new LinkedHashMap<String,String>();
		
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		String province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			//System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		model.setCycleList(cycle);
		return new ModelAndView("viewTMnew","model",model);
	}
	
	
	
	
	@RequestMapping(value = "/viewTMnewApproveOther", method = RequestMethod.GET)
	public ModelAndView viewTMnewApproveOther(HttpServletRequest request) {
		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		Map<String,String> cycle = new LinkedHashMap<String,String>();
		
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		String province = deptDao.getDD(deptId);
/*		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle();
		
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			//System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		*/
		
		
		Glcompm distDiv = glcompmDao.getDistDivision2(province);
		provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
		System.out.println("distDivnnnn : "+distDiv.getCompId());
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		
		PivModel model = new PivModel();
		List<Summary> summary = addLine.findDDSummary(distDiv.getCompId(), deptId);
		System.out.println("distDivnnnnsize : "+summary.size());
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
		int depLoop = deptTm.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			System.out.println(i);
			Gldeptm ojb = (Gldeptm) deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		}
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		model.setCycleList(cycle);
		return new ModelAndView("viewTMnewOther","model",model);
	}

	
	@RequestMapping("/viewTMnewSApproveOther")
	public ModelAndView viewTMnewSApproveOther(HttpServletRequest request,@ModelAttribute("model") PivModel model) {

		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		String status ="";
		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVE;
		}
	 
		String area = model.getGldeptobj().getDeptId();
		String line = String.valueOf(model.getLine().getCode());
		String id ="";
		if(line.equalsIgnoreCase("NONE")){
			id ="NONE";
		}else{
			id = addLine.findIdByCode(line.trim());
		}
		System.out.println("id :" + id);  
		String province = model.getGlcompmobj().getCompId();
		//String cycle=model.getCycle();
		String cycle=model.getCycleObj().getId().getCycleId();
		
		System.out.println("editTMnewS : " +area + id+province+cycle);
		
		List<MmsTxntowermaintenance> TowerMaintance = towerTxtMaintenance.findAllTMByStatusNew( area, id, cycle,deptId);
		System.out.println("editTMnewS : 1" );
		if(TowerMaintance != null){
			System.out.println("editTMnewS : 2" );
			int supSize = TowerMaintance.size() - 1;
			System.out.println("editTMnewS : 3" );
			for (int i = 0; i <= supSize; i++) {
				System.out.println("editTMnewS : 4" +supSize );
				MmsTxntowermaintenance obj = TowerMaintance.get(i);
				System.out.println("editTMnewS : 5" );
				MmsAddsupport objSupport =   addSupport.findById(obj.getId().getTowerid());
				System.out.println("editTMnewS : 6" );
				if(objSupport != null){
					System.out.println("editTMnewS : 7" );
					TowerMaintance.get(i).setHotLineMnt(objSupport.getTowerNo());
					System.out.println("editTMnewS : 8" );
				}
				
				
			}
			
		}
		
		
		
		System.out.println("editTMnewS : 9" );
		
		
		//System.out.println("editTMnewS :"+TowerMaintance.size());
		//String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		//List<LinkedHashMap> Support=restTemplate.getForObject(url, List.class);
	//	model.setTowerMaintance(TowerMaintance);
		//pivModel.setProvinceList(pivModel.getProvinceList());


		Map<String,String> cycleL = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
	///		String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		/* String */ province = deptDao.getDD(deptId);
		Glcompm distDiv = glcompmDao.getDistDivision2(province);
		provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
		System.out.println("distDivnnnn : "+distDiv.getCompId());
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		
		////PivModel model = new PivModel();
		//List<Summary> summary = addLine.findDDSummary(distDiv.getCompId(), deptId);
		//System.out.println("distDivnnnnsize : "+summary.size());
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
		int depLoop = deptTm.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			System.out.println(i);
			Gldeptm ojb = (Gldeptm) deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		}
		//List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle();
		
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycleL.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		model.setCycleList(cycleL);
		model.setMmsTxtMntList(TowerMaintance);
		
		System.out.println("end editTMnewS :");
		return new ModelAndView("viewTMnewOther","model",model);
	}
	
	
	
	@RequestMapping("/viewTMnewSApprove")
	public ModelAndView viewTMnewSApprove(HttpServletRequest request,@ModelAttribute("model") PivModel model) {

		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		String status ="";
		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVE;
		}
	 
		String area = model.getGldeptobj().getDeptId();
		String line = String.valueOf(model.getLine().getCode());
		String id ="";
		if(line.equalsIgnoreCase("NONE")){
			id ="NONE";
		}else{
			id = addLine.findIdByCode(line.trim());
		}
		System.out.println("id :" + id);  
		String province = model.getGlcompmobj().getCompId();
		//String cycle=model.getCycle();
		String cycle=model.getCycleObj().getId().getCycleId();
		
		System.out.println("editTMnewS : " +area + id+province+cycle);
		
		List<MmsTxntowermaintenance> TowerMaintance = towerTxtMaintenance.findAllTMByStatusNew( area, id, cycle,deptId);
		System.out.println("editTMnewS : 1" );
		if(TowerMaintance != null){
			System.out.println("editTMnewS : 2" );
			int supSize = TowerMaintance.size() - 1;
			System.out.println("editTMnewS : 3" );
			for (int i = 0; i <= supSize; i++) {
				System.out.println("editTMnewS : 4" +supSize );
				MmsTxntowermaintenance obj = TowerMaintance.get(i);
				System.out.println("editTMnewS : 5" );
				MmsAddsupport objSupport =   addSupport.findById(obj.getId().getTowerid());
				System.out.println("editTMnewS : 6" );
				if(objSupport != null){
					System.out.println("editTMnewS : 7" );
					TowerMaintance.get(i).setHotLineMnt(objSupport.getTowerNo());
					System.out.println("editTMnewS : 8" );
				}
				
				
			}
			
		}
		
		
		
		System.out.println("editTMnewS : 9" );
		
		
		//System.out.println("editTMnewS :"+TowerMaintance.size());
		//String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		//List<LinkedHashMap> Support=restTemplate.getForObject(url, List.class);
	//	model.setTowerMaintance(TowerMaintance);
		//pivModel.setProvinceList(pivModel.getProvinceList());


		Map<String,String> cycleL = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
	///		String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		/* String */ province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
	///		PivModel model = new PivModel();
		List<Glcompm> line1 = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		
		List<String> provinces = new ArrayList<String>();
		
		
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycleL.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 
		
		
		int loop = line1.size()-1;
		for(int i=0;i<=loop;i++){ 
		//	System.out.println(i);
		  Glcompm ojb = line1.get(i);
		  
		  //System.out.println(ojb.getCompNm());
		  provinces.add(ojb.getCompNm());
		  provinceList.put(ojb.getCompId(), ojb.getCompNm());
		  
		} 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
		  
		} 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		} 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		} 
		//model.setCycle(cycle);
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		model.setCycleList(cycleL);
		model.setMmsTxtMntList(TowerMaintance);
		
		System.out.println("end editTMnewS :");
		return new ModelAndView("viewTMnew","model",model);
	}
	
	
	
	@RequestMapping(value = "/editTMnewApprove", method = RequestMethod.GET)
	public ModelAndView editTMnewApprove(HttpServletRequest request) {
		
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
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			//System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		Map<String,String> cycle = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 


model.setCycleList(cycle);
		
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		//model.setMode(mode);
		return new ModelAndView("editTMnewApprove","model",model);
	}
	
	
	@RequestMapping("/editTMnewSApprove")
	public ModelAndView editTMnewSApprove(HttpServletRequest request,@ModelAttribute("model") PivModel model) {

		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		String status ="";
		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVE;
		}
		status = Util.APPROVE;
		String area = model.getGldeptobj().getDeptId();
		String line = String.valueOf(model.getLine().getCode());
		String id ="";
		if(line.equalsIgnoreCase("NONE")){
			id ="NONE";
		}else{
			id = addLine.findIdByCode(line.trim());
		}
		System.out.println("id :" + id);  
		String province = model.getGlcompmobj().getCompId();
		//String cycle=model.getCycle();
		String cycle=model.getCycleObj().getId().getCycleId();
		System.out.println("editTMnewS : " +area + id+province+cycle);
		
		List<MmsTxntowermaintenance> TowerMaintance = towerTxtMaintenance.findAllByAreaLineCycle(area, id, cycle,status);
		
		System.out.println("editTMnewS :"+TowerMaintance.size());
		//String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		//List<LinkedHashMap> Support=restTemplate.getForObject(url, List.class);
	//	model.setTowerMaintance(TowerMaintance);
		//pivModel.setProvinceList(pivModel.getProvinceList());



		Map<String,String> lineList = new LinkedHashMap<String,String>();
		System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
	///		String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		/* String */ province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
	///		PivModel model = new PivModel();
		List<Glcompm> line1 = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(model.getGlcompmobj().getCompId());
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findLineByArea(model.getGldeptobj().getDeptId());
		List<String> provinces = new ArrayList<String>();
		int loop = line1.size()-1;
		for(int i=0;i<=loop;i++){ 
		//	System.out.println(i);
		  Glcompm ojb = line1.get(i);
		  
		  //System.out.println(ojb.getCompNm());
		  provinces.add(ojb.getCompNm());
		  provinceList.put(ojb.getCompId(), ojb.getCompNm());
		  
		} 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
		  
		} 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		} 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		} 
		
		Map<String,String> cycle1 = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle1.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 


model.setCycleList(cycle1);
		model.setCycle(cycle);
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		model.setMmsTxtMntList(TowerMaintance);
		
		// edit anushka 2019-01-08
				// ------------------------------------------------------------------------------------------------------------
				int supSize = TowerMaintance.size() - 1;
				String stringOfMaintenance = "";

				for (int i = 0; i <= supSize; i++) {
					MmsTxntowermaintenance obj = TowerMaintance.get(i);
					MmsAddsupport objSupport =   addSupport.findById(obj.getId().getTowerid());
					if(objSupport != null){
						TowerMaintance.get(i).setHotLineMnt(objSupport.getTowerNo());
						
					}
					
					if (i != 0) {
						stringOfMaintenance = stringOfMaintenance + ","
								+ Long.toString(obj.getId().getTowerid());
					} else {
						stringOfMaintenance = Long.toString(obj.getId().getTowerid());
					}
				}
				System.out.println("-------------------> stringOfMaintainance: "
						+ stringOfMaintenance);

				model.setStringOfMaintenance(stringOfMaintenance);
				// -------------------------------------------------------------------------------------------------------
		
		
		System.out.println("end editTMnewS :");
		return new ModelAndView("editTMnewApprove","model",model);
	}
	
	
	@RequestMapping(value = "/editTMnewComNew", method = RequestMethod.GET)
	public ModelAndView editTMnewComNew(HttpServletRequest request,@ModelAttribute("model") PivModel model) {
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		/*List<Sauserm> saUserList = null;
		Map<String, String> saList = new LinkedHashMap<String, String>();
		if (userLevel.equals("DEO")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "DEO");

		} else if (userLevel.equals("ES")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "ES");

		} else if (userLevel.equals("EE")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "EE");

		}
	 
*/		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		Map<Long,String> lineListLo = new LinkedHashMap<Long,String>();
		
		//System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		//String deptId =(String)request.getSession().getAttribute("deptId");
		//System.out.println("hi1 : " + deptId);
		String province = deptDao.getDD(deptId);
		//System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		//System.out.println("hi3 : " + distDiv);
		//PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		//List<Gldeptm> deptTm = gldeptDao.getArea(province);
		//List<MmsAddsupporttype> supType = supTypeDao.findAll();
		//List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			//System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  //System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		/*int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			MmsAddline ojb = lineObj.get(i);
			System.out.println(i +"hhh : "+ojb.getId());
			
			lineListLo.put(ojb.getId(), ojb.getLineName());
	    } 
		*/
		
		Map<String,String> cycle = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 
		model.setCycleList(cycle);
		//model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineListLong(lineListLo);
		/*int loopSa = saUserList.size() - 1;
		for (int i = 0; i <= loopSa; i++) {
			//System.out.println(i);
			Sauserm ojb = saUserList.get(i);
			//System.out.println(ojb.getUserId());
			saList.put(ojb.getUserId(), ojb.getUserNm());

		}
		model.setSaList(saList);
*/
		model.setMode("S");
		//String canGo = "1";
		
		ModelAndView mo = new ModelAndView("editTMnewComNew","model",model);
		//mo.addObject("canGO", canGo);
		return mo;
		
		
		
	}
	
	@RequestMapping(value = "/editTMnew", method = RequestMethod.GET)
	public ModelAndView editTMnew(HttpServletRequest request,@ModelAttribute("model") PivModel model) {
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		/*List<Sauserm> saUserList = null;
		Map<String, String> saList = new LinkedHashMap<String, String>();
		if (userLevel.equals("DEO")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "DEO");

		} else if (userLevel.equals("ES")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "ES");

		} else if (userLevel.equals("EE")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "EE");

		}
	 
*/		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		Map<Long,String> lineListLo = new LinkedHashMap<Long,String>();
		
		//System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		//String deptId =(String)request.getSession().getAttribute("deptId");
		//System.out.println("hi1 : " + deptId);
		String province = deptDao.getDD(deptId);
		//System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		//System.out.println("hi3 : " + distDiv);
		//PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		//List<Gldeptm> deptTm = gldeptDao.getArea(province);
		//List<MmsAddsupporttype> supType = supTypeDao.findAll();
		//List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			//System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  //System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		/*int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			MmsAddline ojb = lineObj.get(i);
			System.out.println(i +"hhh : "+ojb.getId());
			
			lineListLo.put(ojb.getId(), ojb.getLineName());
	    } 
		*/
		
		Map<String,String> cycle = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 
		model.setCycleList(cycle);
		//model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineListLong(lineListLo);
		/*int loopSa = saUserList.size() - 1;
		for (int i = 0; i <= loopSa; i++) {
			//System.out.println(i);
			Sauserm ojb = saUserList.get(i);
			//System.out.println(ojb.getUserId());
			saList.put(ojb.getUserId(), ojb.getUserNm());

		}
		model.setSaList(saList);
*/
		model.setMode("S");
		//String canGo = "1";
		
		ModelAndView mo = new ModelAndView("editTMnew","model",model);
		//mo.addObject("canGO", canGo);
		return mo;
		
		
		
	}
	
	
	
	@RequestMapping(value = "/editTMnewComp", method = RequestMethod.GET)
	public ModelAndView editTMnewComp(HttpServletRequest request,@ModelAttribute("model") PivModel model) {
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		/*List<Sauserm> saUserList = null;
		Map<String, String> saList = new LinkedHashMap<String, String>();
		if (userLevel.equals("DEO")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "DEO");

		} else if (userLevel.equals("ES")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "ES");

		} else if (userLevel.equals("EE")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "EE");

		}
	 
*/		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		Map<Long,String> lineListLo = new LinkedHashMap<Long,String>();
		
		//System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		//String deptId =(String)request.getSession().getAttribute("deptId");
		//System.out.println("hi1 : " + deptId);
		String province = deptDao.getDD(deptId);
		//System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		//System.out.println("hi3 : " + distDiv);
		//PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		//List<Gldeptm> deptTm = gldeptDao.getArea(province);
		//List<MmsAddsupporttype> supType = supTypeDao.findAll();
		//List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			//System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  //System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		/*int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			MmsAddline ojb = lineObj.get(i);
			System.out.println(i +"hhh : "+ojb.getId());
			
			lineListLo.put(ojb.getId(), ojb.getLineName());
	    } 
		*/
		
		Map<String,String> cycle = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 
		model.setCycleList(cycle);
		//model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineListLong(lineListLo);
		/*int loopSa = saUserList.size() - 1;
		for (int i = 0; i <= loopSa; i++) {
			//System.out.println(i);
			Sauserm ojb = saUserList.get(i);
			//System.out.println(ojb.getUserId());
			saList.put(ojb.getUserId(), ojb.getUserNm());

		}
		model.setSaList(saList);
*/
		model.setMode("S");
		//String canGo = "1";
		
		ModelAndView mo = new ModelAndView("complesion","model",model);
		//mo.addObject("canGO", canGo);
		return mo;
		
		
		
	}
	
	
	@RequestMapping(value = "/CompletionEE", method = RequestMethod.GET)
	public ModelAndView CompletionEE(HttpServletRequest request,@ModelAttribute("model") PivModel model) {
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		/*List<Sauserm> saUserList = null;
		Map<String, String> saList = new LinkedHashMap<String, String>();
		if (userLevel.equals("DEO")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "DEO");

		} else if (userLevel.equals("ES")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "ES");

		} else if (userLevel.equals("EE")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "EE");

		}
	 
*/		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		Map<Long,String> lineListLo = new LinkedHashMap<Long,String>();
		
		//System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		//String deptId =(String)request.getSession().getAttribute("deptId");
		//System.out.println("hi1 : " + deptId);
		String province = deptDao.getDD(deptId);
		//System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		//System.out.println("hi3 : " + distDiv);
		//PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		//List<Gldeptm> deptTm = gldeptDao.getArea(province);
		//List<MmsAddsupporttype> supType = supTypeDao.findAll();
		//List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			//System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  //System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		/*int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			MmsAddline ojb = lineObj.get(i);
			System.out.println(i +"hhh : "+ojb.getId());
			
			lineListLo.put(ojb.getId(), ojb.getLineName());
	    } 
		*/
		
		Map<String,String> cycle = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 
		model.setCycleList(cycle);
		//model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineListLong(lineListLo);
		/*int loopSa = saUserList.size() - 1;
		for (int i = 0; i <= loopSa; i++) {
			//System.out.println(i);
			Sauserm ojb = saUserList.get(i);
			//System.out.println(ojb.getUserId());
			saList.put(ojb.getUserId(), ojb.getUserNm());

		}
		model.setSaList(saList);
*/
		model.setMode("S");
		//String canGo = "1";
		
		ModelAndView mo = new ModelAndView("complesionEE","model",model);
		//mo.addObject("canGO", canGo);
		return mo;
		
		
		
	}


	@RequestMapping(value = "/complesionS", method = RequestMethod.POST)
	public ModelAndView complesionS(HttpServletRequest request,@ModelAttribute("model") PivModel model) {
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		/*List<Sauserm> saUserList = null;
		Map<String, String> saList = new LinkedHashMap<String, String>();
		if (userLevel.equals("DEO")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "DEO");

		} else if (userLevel.equals("ES")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "ES");

		} else if (userLevel.equals("EE")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "EE");

		}
	 
*/		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		Map<Long,String> lineListLo = new LinkedHashMap<Long,String>();
		
		//System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		//String deptId =(String)request.getSession().getAttribute("deptId");
		//System.out.println("hi1 : " + deptId);
		String province = deptDao.getDD(deptId);
		//System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		//System.out.println("hi3 : " + distDiv);
		//PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		//List<MmsAddsupporttype> supType = supTypeDao.findAll();
		//List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			//System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  //System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(model.getGlcompmobj().getCompId());
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		
		/*int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			MmsAddline ojb = lineObj.get(i);
			System.out.println(i +"hhh : "+ojb.getId());
			
			lineListLo.put(ojb.getId(), ojb.getLineName());
	    } 
		*/
		System.out.println("hhh : "+model.getGldeptobj().getDeptId());
		
		List<MmsAddline> lineObj = addLine.findLineByArea(model.getGldeptobj().getDeptId());
		
		/*int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			MmsAddline ojb = lineObj.get(i);
			System.out.println(i +"hhh : "+ojb.getId());
			
			lineListLo.put(ojb.getId(), ojb.getLineName());
	    } 
		*/
		System.out.println("hhhhhhhhh : "+model.getLineListEdit());
		
		
		Map<String,String> cycle = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 
		model.setCycleList(cycle);
		//model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		//model.setLineListLong(lineListLo);
		model.setLineListEdit(lineObj);
		//model.setGlcompmobj.compId
		/*int loopSa = saUserList.size() - 1;
		for (int i = 0; i <= loopSa; i++) {
			//System.out.println(i);
			Sauserm ojb = saUserList.get(i);
			//System.out.println(ojb.getUserId());
			saList.put(ojb.getUserId(), ojb.getUserNm());

		}
		model.setSaList(saList);
*/
		model.setMode("S");
		//String canGo = "1";
		
		ModelAndView mo = new ModelAndView("complesion","model",model);
		//mo.addObject("canGO", canGo);
		return mo;
		
		
		
	}
	
	
	@RequestMapping(value = "/complesionSEE", method = RequestMethod.POST)
	public ModelAndView complesionSEE(HttpServletRequest request,@ModelAttribute("model") PivModel model) {
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		/*List<Sauserm> saUserList = null;
		Map<String, String> saList = new LinkedHashMap<String, String>();
		if (userLevel.equals("DEO")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "DEO");

		} else if (userLevel.equals("ES")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "ES");

		} else if (userLevel.equals("EE")) {
			saUserList = secDao.getAllUserByRptUser(deptId, "EE");

		}
	 
*/		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		Map<Long,String> lineListLo = new LinkedHashMap<Long,String>();
		
		//System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		//String deptId =(String)request.getSession().getAttribute("deptId");
		//System.out.println("hi1 : " + deptId);
		String province = deptDao.getDD(deptId);
		//System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		//System.out.println("hi3 : " + distDiv);
		//PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		//List<MmsAddsupporttype> supType = supTypeDao.findAll();
		//List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			//System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  //System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(model.getGlcompmobj().getCompId());
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		
		/*int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			MmsAddline ojb = lineObj.get(i);
			System.out.println(i +"hhh : "+ojb.getId());
			
			lineListLo.put(ojb.getId(), ojb.getLineName());
	    } 
		*/
		System.out.println("hhh : "+model.getGldeptobj().getDeptId());
		
		//List<MmsAddline> lineObj = addLine.findLineByArea(model.getGldeptobj().getDeptId());
		List<MmsCompletion> comList = comDao.findByAreaCycle(model.getGldeptobj().getDeptId(), model.getCycleObj().getId().getCycleId());
		
		/*int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			MmsAddline ojb = lineObj.get(i);
			System.out.println(i +"hhh : "+ojb.getId());
			
			lineListLo.put(ojb.getId(), ojb.getLineName());
	    } 
		*/
		System.out.println("hhhhhhhhh : "+model.getLineListEdit());
		
		
		Map<String,String> cycle = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 
		model.setCycleList(cycle);
		//model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setComList(comList);
		//model.setLineListLong(lineListLo);
		//model.setLineListEdit(lineObj);
		//model.setGlcompmobj.compId
		/*int loopSa = saUserList.size() - 1;
		for (int i = 0; i <= loopSa; i++) {
			//System.out.println(i);
			Sauserm ojb = saUserList.get(i);
			//System.out.println(ojb.getUserId());
			saList.put(ojb.getUserId(), ojb.getUserNm());

		}
		model.setSaList(saList);
*/
		model.setMode("S");
		//String canGo = "1";
		
		ModelAndView mo = new ModelAndView("complesionEE","model",model);
		//mo.addObject("canGO", canGo);
		return mo;
		
		
		
	}

	
	
	
	@RequestMapping(value = "/complesionSubmit", method = RequestMethod.POST)
	public ModelAndView complesionSubmit(HttpServletRequest request,@ModelAttribute("model") PivModel model) {
		
		System.out.print("ssss:"+model.getLineListEdit().size());		
		ModelAndView mo = new ModelAndView("complesion","model",model);
		return mo;
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/editTMnewS")
	public ModelAndView editTMnewS(HttpServletRequest request,@ModelAttribute("model") PivModel model) {

		
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		
		String status ="";
		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVAL_EE;
		}
		
		String line_name="";
		String area_name="";
		List<MmsTxntowermaintenance> TowerMaintance = null;
		String deptId = request.getSession().getAttribute("deptId").toString();
		//System.out.println("id :" + model.getLine().getId());  
		
		String area = model.getGldeptobj().getDeptId();
		area_name = gldeptDao.getName(area);
		//System.out.println("area_name" + area_name);  
		
		String line = String.valueOf(model.getLine().getId());
		String id ="";
		if(line.equalsIgnoreCase("-1")){
			id ="NONE";
		}else{
			id = line;
			line_name = addLine.getNameById(id);
			System.out.println("area_name" + area_name);  
			
		}
		String province = model.getGlcompmobj().getCompId();
		String cycle=model.getCycleObj().getId().getCycleId();
		System.out.println("editTMnewS : " +area + id+province+cycle+status);
		TowerMaintance = towerTxtMaintenance.findAllByAreaLineCycle(area, id, cycle,status);
		//System.out.println("TowerMaintance : " +TowerMaintance.size());
		
		/*if(TowerMaintance.size() != 0){
			System.out.println("TowerMaintance modeA   : " +TowerMaintance);
			
			model.setMode("A");
		}else{
			System.out.println("TowerMaintance modeS : " +TowerMaintance);
			
			model.setMode("S");
		}
		
		*/model.setMmsTxtMntList(TowerMaintance);
		model.setError("");	
				
		//System.out.println("end editTMnewS :");
		/*if(TowerMaintance !=null){
			model.setMode("A");
		}
		*///return new ModelAndView("editTMnew","model",model);
	/*	}else if(model.getMode().equalsIgnoreCase("A")){
			
			System.out.println("updateTMStatus2xxxxxxxxxxxxxkkkkkkuuuuu" + model.getMmsTxtMntList());
			TowerMaintance = towerTxtMaintenance.findAllByAreaLineCycleDeptId(area, id, cycle,status,deptId);
			System.out.println("updateTMStatus2xxxxxxxxxxxxxkkkk" + TowerMaintance);
			
			//String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			String updateStatus = "";
			
			if (userLevel.equals("DEO")) {
				updateStatus = Util.VALIDATION_ES;
			} else if (userLevel.equals("ES")) {
				updateStatus = Util.APPROVAL_EE;
			} else if (userLevel.equals("EE")) {
				updateStatus = Util.APPROVE;
			}
			
			
			if (TowerMaintance != null) {
				for (int i = 0; i < TowerMaintance.size(); i++) {
					MmsTxntowermaintenance obj = TowerMaintance.get(i);
					//System.out.println("updateTMStatus2" + obj.getStatus());
					obj.setStatus(new BigDecimal(updateStatus));
					System.out.println("addTM6: " );
					towerTxtMaintenance.update(obj);
					System.out.println("addTM5: " );
					
				}
				
				//try{
					
					if (userLevel.equals("EE")) {
						try {
							
							String email="";
							String telNo="";
							
							if(area.compareTo("471.00")==0){
								//Dambulla
								email ="lahiruhimal@gmail.com";
								telNo ="0711257255";
							}else if(area.compareTo("434.00")==0){
								//KandyCity
								email ="abeyeedm@yahoo.com";
								telNo ="0714215522";
								
							}else if(area.compareTo("470.00")==0){
								//Galagedara
								email ="smkumaraky@gmail.com";
								telNo ="0711478578";
								
							}else if(area.compareTo("435.00")==0){
								//Katugasthota
								email ="shbabeysinghe@gmail.com";
								telNo ="0713860343";
								
							}else if(area.compareTo("431.00")==0){
								//Nawalapitiya
								email ="sanjayabothota@gmail.com";
								telNo ="0719621988";
								
							}else if(area.compareTo("472.00")==0){
								//Mawanelle
								email ="ashoka.kulasinghe@gmail.com";
								telNo ="0711902667";
								
							}else if(area.compareTo("437.00")==0){
								//Kundasale
								email ="chamilmsk@gmail.com";
								telNo ="0716883167";
								
							}else if(area.compareTo("433.00")==0){
								//Peradeniya
								email ="sachithra@gmail.com";
								telNo ="0719875846";
								
							}else if(area.compareTo("439.00")==0){
								//Kegalle
								email ="hiranthajayathilaka@gmail.com";
								telNo ="0718502077";
								
							}else if(area.compareTo("436.00")==0){
								//Mathale
								email ="gihan.gihan@gmail.com";
								telNo ="0713183582";
								
								
							}else if(area.compareTo("463.00")==0){
								//Ampara
								email ="ceampara@ceb.lk";
								telNo ="0715322820";
								
								
							}else if(area.compareTo("461.00")==0){
								//Trinkomalee
								email ="theepan252@gmail.com";
								telNo ="0716867514";
								
								
							}else if(area.compareTo("462.00")==0){
								//Baticallow
								email ="vtanitha@yahoo.com";
								telNo ="0716867182";
								
							}else if(area.compareTo("446.00")==0){
								//Divalapitiya
								email ="eedivulapitiya@ceb.lk";
								telNo ="0716874502";
								
							}else if(area.compareTo("445.00")==0){
								//Ja ela
								email ="cejaela@ceb.lk";
								telNo ="0714066350";
							}else if(area.compareTo("441.00")==0){
								//Kelaniya
								email ="cekelaniya@ceb.lk";
								telNo ="0714066320";
							}else if(area.compareTo("442.00")==0){
								//Negambo
								email ="eenegombo@ceb.lk";
								telNo ="0714066340";
							}else if(area.compareTo("443.00")==0){
								//Gampaha
								email ="cegampaha@ceb.lk";
								telNo ="0714066350";
							}else if(area.compareTo("444.00")==0){
								//Veyangoda
								email ="ceveyangoda@gmail.com";
								telNo ="0714066340";
							}else if(area.compareTo("556.00")==0){
								//Ginigathhena
								email ="pushpikadissa@gmail.com";
								telNo ="0714297773";
							}else if(area.compareTo("432.00")==0){
								//NuwaraEliya
								email ="kamaldayananda@gmail.com";
								telNo ="0711257290";
							}else if(area.compareTo("464.00")==0){
								//Kalmunai
								email ="eekalmunai@ceb.lk";
								telNo ="0716867520";
							}else {
								email ="eranga.bogahakumbura@gmail.com";
								telNo ="0718716913";
							}
							
							//email ="gchampika28@gmail.com";
							//telNo ="0714537313";
							
							System.out.println("email 1 " +email  + telNo);
							
							String content ="" + "\n" + "Way Leave Status of the "+line_name+ " 33kV tower line is inspected by PHM-DD2 branch & you" + "\n" + "can see the status by Login in to your MV-MMS account using "+ "\n" + "http://mvmms.ceb.lk:9090/MMS/WelcomeMMS " +"\n"+ "(Phrase '33kV Tower Line' is inserted)";
							String subject ="Way leave status of the "+line_name;
							ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
							MailMail mm = (MailMail) context.getBean("mailMail");
							//mm.sendMail("Mr. Eranga", "Maintenance data is approved in area " + area);
							mm.sendMailTo(area_name.trim(), content ,email,subject);
							System.out.println("finish 1 " );
							Date date = new Date();
							
							
							String sms_content ="You can see the Way Leave Status of the "+line_name+ " by login into http://mvmms.ceb.lk:9090/MMS/WelcomeMMS";
							
							RestTemplate restTemplate = new RestTemplate();
							System.out.println("sendSMS 2" );

							String url="http://smsgw.ceb/SMSPlatform.php?recipients="+telNo+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
							System.out.println("sendSMS 3" );

							restTemplate.getForObject(url, String.class);
							System.out.println("sendSMS 4" );

					
						
					
					
				}catch(Exception e){
					
				}
					}
				
				model.setError("Tower Maintenance Data succesfully approved...");	
				
				model.setMode("S");
				model.setMmsTxtMntList(TowerMaintance);
				
				
			}else{
				model.setError("");	
				
				model.setMode("S");
				model.setMmsTxtMntList(TowerMaintance);
				
				
			}
*/
			
			
			
			
			//if()
			
		/*	System.out.println("else1222222 :");
			//return new ModelAndView("editTMnew","model",model);
		}else{
			model.setMode("S");
			
		}
		*/
		
		//System.out.println("editTMnewS :"+TowerMaintance.size());
		//String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		//List<LinkedHashMap> Support=restTemplate.getForObject(url, List.class);
	//	model.setTowerMaintance(TowerMaintance);
		//pivModel.setProvinceList(pivModel.getProvinceList());
		Map<Long,String> lineListLo = new LinkedHashMap<Long,String>();
		


		Map<String,String> lineList = new LinkedHashMap<String,String>();
		System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
	///		String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		/* String */ province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
	///		PivModel model = new PivModel();
		List<Glcompm> line1 = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(model.getGlcompmobj().getCompId());
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findLineByArea(model.getGldeptobj().getDeptId());
		List<String> provinces = new ArrayList<String>();
		int loop = line1.size()-1;
		for(int i=0;i<=loop;i++){ 
		//	System.out.println(i);
		  Glcompm ojb = line1.get(i);
		  
		  //System.out.println(ojb.getCompNm());
		  provinces.add(ojb.getCompNm());
		  provinceList.put(ojb.getCompId(), ojb.getCompNm());
		  
		} 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
		  
		} 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		} 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineListLo.put(ojb.getId(), ojb.getLineName());
		} 
		
		Map<String,String> cycle1 = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle1.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 


        model.setCycleList(cycle1);
		
		model.setCycle(cycle);
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineListLong(lineListLo);
		
		// edit anushka 2019-01-08
				// ------------------------------------------------------------------------------------------------------------
		if(TowerMaintance != null){		
		int supSize = TowerMaintance.size() - 1;
				String stringOfMaintenance = "";

				for (int i = 0; i <= supSize; i++) {
					MmsTxntowermaintenance obj = TowerMaintance.get(i);
					MmsAddsupport objSupport =   addSupport.findById(obj.getId().getTowerid());
					if(objSupport != null){
						TowerMaintance.get(i).setHotLineMnt(objSupport.getTowerNo());
						
					}
					
					if (i != 0) {
						stringOfMaintenance = stringOfMaintenance + ","
								+ Long.toString(obj.getId().getTowerid());
					} else {
						stringOfMaintenance = Long.toString(obj.getId().getTowerid());
					}
				}
			//	System.out.println("-------------------> stringOfMaintainance: "
				//		+ stringOfMaintenance);

				model.setStringOfMaintenance(stringOfMaintenance);
				// -------------------------------------------------------------------------------------------------------
		}
				model.setMmsTxtMntList(TowerMaintance);
				
				return new ModelAndView("editTMnew","model",model);

		
	}
	
	
/**	@RequestMapping(value = "/updateTMStatus/{area}/{cycle}/{towerno}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateTMStatus(HttpServletRequest request,@PathVariable("area") String area,
			@PathVariable("cycle") String cycle,
			@PathVariable("towerno") String towerno) {

		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		String phmBranch = (String) request.getSession().getAttribute("deptId");
		

		try {
			String status = null;
			String updateStatus = null;

			if (userLevel.equals("DEO")) {
				status = Util.IN_BULK;
				updateStatus = Util.VALIDATION_ES;
			} else if (userLevel.equals("ES")) {
				status = Util.VALIDATION_ES;
				updateStatus = Util.APPROVAL_EE;
			} else if (userLevel.equals("EE")) {
				status = Util.APPROVAL_EE;
				updateStatus = Util.APPROVE;
			}
			
			List<MmsTxntowermaintenance> TowerMaintance = towerTxtMaintenance.findAllByAreaLineCycle( area, id, cycle,status);
			

			List<MmsAddsupport> Support = addSupport.findBySupportStatus(area,
					String.valueOf(id), province, deptId, status);
			System.out.println("Support :" + Support.size());

			if (Support != null) {
				for (int i = 0; i < Support.size(); i++) {
					MmsAddsupport obj = Support.get(i);
					System.out
							.println("updateSupportStatus2" + obj.getStatus());
					obj.setStatus(new BigDecimal(updateStatus));
					System.out.println("addSupport6: " );
					addSupport.update(obj);
					System.out.println("addSupport5: " );
				}
			}
			System.out.println("addSupport4: " );
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}*/
	
	@RequestMapping(value = "/findTmByAreaLineCycle/{area}/{lineId}/{cycle}/{status}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsTxntowermaintenance> towerMaintenanceByAreaCycle(@PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("cycle") String cycle,@PathVariable("status") String status) {
		System.out.println("area line:" + area);
		System.out.println("line:" + lineId);
		System.out.println("cycle:" + cycle);
		List<MmsTxntowermaintenance> mnt = towerTxtMaintenance.findAllByAreaLineCycle(area, lineId,cycle,status);
		
		/**if(mnt != null){
			int length = mnt.size();
			
			for(int i = 0; i < length ;i++){
				MmsTxntowermaintenance obj = (MmsTxntowermaintenance)mnt.get(i);
				
			}
		}*/
		
		return mnt;
	}
	
	
	@RequestMapping(value = "/findTmByAreaLineCycleNew/{area}/{lineId}/{cycle}/{status}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> towerMaintenanceByAreaCycleNew(@PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("cycle") String cycle,@PathVariable("status") String status) {
		System.out.println("area line:" + area);
		System.out.println("line:" + lineId);
		System.out.println("cycle:" + cycle);
		List<Object[]> mnt = towerTxtMaintenance.findAllByAreaLineCycleNew(area, lineId,cycle,status);
		
		/**if(mnt != null){
			int length = mnt.size();
			
			for(int i = 0; i < length ;i++){
				MmsTxntowermaintenance obj = (MmsTxntowermaintenance)mnt.get(i);
				
			}
		}*/
		
		return mnt;
	}
	
	@RequestMapping(value = "/updateTMStatus/{province}/{area}/{line}/{cycle}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateTMStatus(HttpServletRequest request,
			@PathVariable("province") String province,
			@PathVariable("area") String area, @PathVariable("line") String line,@PathVariable("cycle") String cycle) {
		
		String userLevel ="";
		String deptId = "";
		String area_name ="";
		try {
			deptId = request.getSession().getAttribute("deptId").toString();
			userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			String phmBranch = (String) request.getSession().getAttribute("deptId");
			area_name = gldeptDao.getName(area);
			} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String id = "";
		String line_name ="";
		if (line.equalsIgnoreCase("-1")) {
			id = "NONE";
		} else {
			id = line;
			line_name = addLine.getNameById(line);
		}
		try {
			String status = null;
			String updateStatus = null;
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date today = Calendar.getInstance().getTime();        
			String reportDate = df.format(today);
			Date dateNowNew=null;
			
			DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
			Date insTimeDate=null;
			dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);
			SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
		    String time = localDateFormat.format(new Date());
		    if (userLevel.equals("DEO")) {
				status = Util.IN_BULK;
				updateStatus = Util.VALIDATION_ES;
			} else if (userLevel.equals("ES")) {
				status = Util.VALIDATION_ES;
				updateStatus = Util.APPROVAL_EE;
			} else if (userLevel.equals("EE")) {
				status = Util.APPROVAL_EE;
				updateStatus = Util.APPROVE;
			}
			
			List<MmsTxntowermaintenance> TowerMaintance = towerTxtMaintenance.findAllByAreaLineCycle(area, id, cycle,status);
			if (TowerMaintance != null) {
				for (int i = 0; i < TowerMaintance.size(); i++) {
					MmsTxntowermaintenance obj = TowerMaintance.get(i);
					if(userLevel.equals("EE")){
						getCompletionObject(obj);
					}
					
					if (userLevel.equals("DEO")) {
						//status = Util.IN_BULK;
						//updateStatus = Util.VALIDATION_ES;
					} else if (userLevel.equals("ES")) {
						//obj.setValidateBy(userName);
						obj.setValidateDate(dateNowNew);
						obj.setValidateTime(time);
					} else if (userLevel.equals("EE")) {
						//obj.setApprovedBy(userName);
						obj.setApprovedDate(dateNowNew);
						obj.setApprovedTime(time);

					}
			obj.setStatus(new BigDecimal(updateStatus));
			towerTxtMaintenance.update(obj);
			sendNotification(request, province, area_name, line_name, cycle);			
			}
			}
		
			System.out.println("addTM4: " );
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/sendNotification/{province}/{area}/{line}/{cycle}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void sendNotification(HttpServletRequest request,
			@PathVariable("province") String province,
			@PathVariable("area") String area, @PathVariable("line") String line,@PathVariable("cycle") String cycle) {
		
		String userLevel ="";
		String deptId = "";
		String area_name ="";
		try {
			deptId = request.getSession().getAttribute("deptId").toString();
			//System.out.println("updateLineStatus" + province + area + deptId	+ line);
				
			userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			//System.out.println("updateLineStatus 1" + request.getSession());
			
			//String userName = request.getSession().getAttribute("userName").toString();
			//System.out.println("updateLineStatus 2");
			
			String phmBranch = (String) request.getSession().getAttribute("deptId");
			//System.out.println("updateLineStatus 3");
			
			System.out.println("updateLineStatus" + province + area + phmBranch	+ line);
			//System.out.println("updateLineStatus 4");
			
			area_name = gldeptDao.getName(area);
			//System.out.println("updateLineStatus 5" + area_name);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String id = "";
		String line_name ="";
		if (line.equalsIgnoreCase("-1")) {
			id = "NONE";
		} else {
			//id = addLine.findIdByCode(line.trim());
			id = line;
			line_name = addLine.getNameById(line);
		}
		//System.out.println("id :" + id);
		
		
		

		try {
			String status = null;
			String updateStatus = null;
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date today = Calendar.getInstance().getTime();        
			String reportDate = df.format(today);
			//System.out.println("equipment : 1 ");
			Date dateNowNew=null;
			
			DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
			//String insTime = df2.format(today);
			Date insTimeDate=null;
			//System.out.println("equipment : 2 ");
			
			//insTimeDate = new SimpleDateFormat("HH-MM-SS").parse(insTime);
			dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);
			
			
		       SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
		        String time = localDateFormat.format(new Date());
		        if (userLevel.equals("EE")) {
				try {
					
					String email="";
					String telNo="";
					
					String emailcedm="";
					String telNocddm="";
					String contentcedm="";
					
					
					String emaildgm=Util.searchEmailProvinceDGM(province);
					String telNodgm=Util.searchTelNoProvinceDGM(province);
					
					
					email = Util.searchEmail(area.trim());
					telNo = Util.searchTelNo(area.trim());
					
					String dgmcontent;
					if(province.equalsIgnoreCase("EP")){
						emailcedm = "razvi.evr@gmail.com";
						telNocddm = "0718693230";
						contentcedm = "Chief Engineer ";
					}
					
					
					String userLoged = request.getSession().getAttribute("loggedUser").toString();
					SausermMm userMm = null;
					String userName ="";
					if(userLoged != null){
						try {
							
							userMm =secDao.getSausermMms(userLoged.trim());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
					/*if(userMm != null){
						userName = userMm.getUserNm();
					}
					*/
					String emailCE = "";
					String telNoCE = "";
					
					if(deptId.equalsIgnoreCase("600.41")){
						emailCE = Util.cephmcp;
						telNoCE = Util.telcephmcp;
					}else if(deptId.equalsIgnoreCase("600.42")){
						emailCE = Util.cephmcpsub;
						telNoCE = Util.telcephmcpsub;
					}else if(deptId.equalsIgnoreCase("780.00")){
						emailCE = Util.cephmdd3;
						telNoCE = Util.telcephmdd3;
					}else if(deptId.equalsIgnoreCase("596.00")){
						emailCE = Util.cephmdd1;
						telNoCE = Util.telcephmdd1;
					}else{
						emailCE = "gchampika28@gmail.com";
						telNoCE = "0714537313";
					}

					
					
					String emailphmee =userMm.getEmail();
					String telNophmee =userMm.getTelNo();
							
					//String emailphmce ="alagodas1@gmail.com";
					//String telNophmce ="0713841267";
					//String contentPhm ="" + "\n" + "Inspection completion of 33kV tower lines in "+area_name.trim().toLowerCase()+" is successfully sent to Area Engineer ("+ area_name.trim()+")";
					String content ="" + "" + "\nWay Leaves/Electrical Works On Poles/Missing Parts Status of 33kV tower lines in your area are inspected by PHM branch. & \n\nYou can see the status by login in to your MV-MMS account using https://mms.ceb.lk \n\n Thank You";
					
					DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date todayxxx = new Date();
								String subject_str = subject_str_fm.format(todayxxx);

					//String subject_phm ="Way Leave/Electrical Works On Poles/Missing Parts Status of the "+area_name.trim() + " " + subject_str;
					String subject_area = " Inspection completion of 33kv tower line in  " + area_name.trim().toLowerCase() +"-" + subject_str;
					ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
					MailMail mm = (MailMail) context.getBean("mailMail");
					//mm.sendMail("Mr. Eranga", "Maintenance data is approved in area " + area);
					
					//today
					//Util.trustEveryone();
					String[] emailList = new String[4];
					//phm ee
					emailList[0] = emailphmee;
					emailList[1] = emailCE;
					emailList[2] = emaildgm;
					emailList[3] = emailcedm;
					//emailList[4] = "gchampika28@gmail.com";
					//emailList[5] = email;
					
					mm.sendMailTo(area_name, content ,email,emailList,subject_area);
					
					/*mm.sendMailTo(area_name.trim(), content ,email,subject_area);
					mm.sendMailTo(dgmcontent, content ,emaildgm,subject_area);
					mm.sendMailTo("Cheif Engineer / Maintenance Engineer PHM", contentPhm ,emailphmee,subject_phm);
					mm.sendMailTo("Cheif Engineer / Maintenance Engineer PHM", contentPhm ,emailphmce,subject_phm);
					*/
					
					
					
					//System.out.println("finish 1 " );
					Date date = new Date();
					String sms_content_phm ="Way Leave Status of the "+line_name+ " 33kV tower line is successfully sent to "+ area_name;
					//String sms_content_phm = "Way Leave/Electrical Works On Poles/Missing Parts Status of 33kV tower lines in "+area_name.trim()+" is successfully sent to Area Engineer ("+ area_name.trim() +")";
					
					//String sms_content ="You can see the Way Leave Status of the "+line_name+ " by login into http://mvmms.ceb.lk:9090/MMS/WelcomeMMS";
					String sms_content ="You can see the Way Leave/Electrical Works On Poles/Missing Parts Status of 33kV tower lines in "+area_name.trim().toLowerCase()+" by login into https://mms.ceb.lk";
					RestTemplate restTemplate = new RestTemplate();
					//System.out.println("sendSMS 2" );

					String url="http://smsgw.ceb/SMSPlatform.php?recipients="+telNo+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					//System.out.println("sendSMS 3" );
					String urldgm="http://smsgw.ceb/SMSPlatform.php?recipients="+telNodgm+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					String urlcedm="http://smsgw.ceb/SMSPlatform.php?recipients="+telNodgm+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					
					String urlphmee="http://smsgw.ceb/SMSPlatform.php?recipients="+telNophmee+"&smsbody="+sms_content_phm+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					String urlphmce="http://smsgw.ceb/SMSPlatform.php?recipients="+telNoCE+"&smsbody="+sms_content_phm+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					String urlphmmy="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content_phm+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					
					
					//Util.trustEveryone();
					
					restTemplate.getForObject(url, String.class);
					restTemplate.getForObject(urldgm, String.class);
					restTemplate.getForObject(urlphmee, String.class);
					restTemplate.getForObject(urlphmce, String.class);
					restTemplate.getForObject(urlphmmy, String.class);
					restTemplate.getForObject(urlcedm, String.class);
					
					//System.out.println("sendSMS 4" );

				/*	String sms_content_phm = "Way Leave Status of 33kV tower lines in "+area_name+" is successfully sent to Area Engineer ("+ area_name +")";
					Date date = new Date();
					
					mm.sendMailTo("Cheif Engineer / Maintenance Engineer PHM-DD2", contentPhm ,"gchampika28@gmail.com",subject_phm);
					String url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content_phm+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					RestTemplate restTemplate = new RestTemplate();
					
					restTemplate.getForObject(url, String.class);
				*/	
					/*String sequence=null;
			    	
					Integer i=Integer.parseInt(id);
		    		sequence=i.toString();
		    		
					
					if(sequence.length()==1){
						sequence = "00"+sequence;
					}
			    	else if(sequence.length()==2){
			    		sequence = "0"+sequence;
			    	}
			    	else if (sequence.length()==3){
			    		sequence = sequence;
			    	}
			    	*/	
					
					String pre_approval_id = Util.WAYLEAVE_APPROVAL_ID+"-"+area;
					
					//String pre_approval_id_SMS = "SMSMV-"+area+"-"+sequence;
					
					
					String enterDate = sdf.format(date);
					String nextNumver = approvalMm.getNextAppId(pre_approval_id);
					
					String approval_id = pre_approval_id +"-" + nextNumver;
					
					//String approval_id_SMS = pre_approval_id_SMS + "-" + nextNumver;
					
					String refrence = area_name;
					String approveType = Util.WAYLEAVE_TYPE_ID;
					String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
					String fromStatus = "1";
					String toStatus = "6";
					//System.out.println("finish 2 " );
					
					String approvedBy = request.getSession().getAttribute("loggedUser").toString();
					
					
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            		String dateString = format.format(date);
            		Date   date2       = format.parse (dateString);    

            		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");

            		String timeString = format2.format(date);
            		//System.out.println("finish 3 " );
					
					
					
					ApprovalMm appr = new ApprovalMm();
					appr.setApprovalId(approval_id);
					//System.out.println("finish 6 " +approval_id);
					appr.setReferenceNo(area_name);
					//System.out.println("finish 7 " + refrence);
					String reason = "Way Leave/Electrical Works On Poles/Missing Parts Status of " + area_name;
					appr.setReason(reason);
					//System.out.println("finish 8 " +reason);
					appr.setPhmBranch(deptId);
					appr.setAreaCode(area.trim());
					appr.setDeptId(deptId);
					//System.out.println("finish 9 "+ deptId );
					
					appr.setApprovalType(approveType);
					//System.out.println("finish 10 " +approveType);
					
					appr.setApprovedLevel(approveLevel);
					//System.out.println("finish 11 "+ approveType );
					
					appr.setFromStatus(fromStatus);
					//System.out.println("finish 12 "+ fromStatus);
					
					appr.setToStatus(toStatus);
					//System.out.println("finish 13 "+ toStatus );
					
					appr.setApprovedDate(date2);
					//System.out.println("finish 14 " + dateString);
					
					appr.setApprovedTime(timeString);
					//System.out.println("finish 15 "+ timeString );
					
					appr.setApprovedBy(approvedBy);
					//System.out.println("finish 16 "+ approvedBy);
					
					approvalMm.addApproval(appr);
					
					/*appr.setApprovalId(approval_id_SMS);
					appr.setApprovalType("SMS");
					appr.setToStatus("5");
					
					approval.addApproval(appr);
					*/
					
					//System.out.println("finish 4 " );
					
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			}
		
			System.out.println("addTM4: " );
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}

	
	
	
	
	@RequestMapping(value = "/updateTMStatusCompletion/{province}/{area}/{line}/{cycle}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateTMStatusCompletion(HttpServletRequest request,
			@PathVariable("province") String province,
			@PathVariable("area") String area, @PathVariable("line") String line,@PathVariable("cycle") String cycle) {

		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		String phmBranch = (String) request.getSession().getAttribute("deptId");
		System.out.println("updateLineStatus" + province + area + phmBranch	+ line);
		String area_name = gldeptDao.getName(area);
		String id = "";
		String line_name ="";
		if (line.equalsIgnoreCase("NONE")) {
			id = "NONE";
		} else {
			id = addLine.findIdByCode(line.trim());
			line_name = addLine.getNameByCode(line.trim());
		}
		System.out.println("id :" + id);

		try {
			String status = null;
			String updateStatus = null;
			
			
			
			//String currentDate = dateNow.format(date);
			
			
			
			
			

			if (userLevel.equals("DEO")) {
				status = Util.IN_BULK;
				updateStatus = Util.VALIDATION_ES;
			} else if (userLevel.equals("ES")) {
				status = Util.APPROVE;
				updateStatus = "11";
			} else if (userLevel.equals("EE")) {
				status = "11";
				updateStatus = Util.COMPLETED_DATA_APPROVAL;
			}
			
			List<MmsTxntowermntcomplesion> TowerMaintance = complesionMaintenanceDao.findAllByAreaLineCycle( area, id, cycle,status);
				System.out.println("TowerMaintance :" + TowerMaintance.size());

			if (TowerMaintance != null) {
				for (int i = 0; i < TowerMaintance.size(); i++) {
					MmsTxntowermntcomplesion obj = TowerMaintance.get(i);
					System.out.println("updateTMStatus2" + obj.getStatus());
					obj.setStatus(new BigDecimal(updateStatus));
					System.out.println("addTM6: " );
					complesionMaintenanceDao.update(obj);
					System.out.println("addTM5: " );
				}
			}
			
			/*if (userLevel.equals("EE")) {
				try {
					String content ="" + "\n" + "Way Leave Status of the "+line_name+ " is inspected by PHM-DD2 branch & you" + "\n" + "can see the status by Login in to your MV-MMS account using "+ "\n" + "http://mvmms.ceb.lk:9090/MMS/WelcomeMMS";
					String subject ="Way leave status of the "+line_name;
					ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
					MailMail mm = (MailMail) context.getBean("mailMail");
					//mm.sendMail("Mr. Eranga", "Maintenance data is approved in area " + area);
					mm.sendMailTo(area_name.trim(), content ,"eranga.bogahakumbura@gmail.com",subject);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			}*/
			
			System.out.println("addTM4: " );
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}

	
	@RequestMapping("/displayAllMnt")
    public ModelAndView displayAllMnt(HttpServletRequest request) {

        PivModel model = new PivModel();
        String deptId = request.getSession().getAttribute("deptId").toString();
        String userLevel = request.getSession().getAttribute("loggedUserRole")
                .toString();
        String status = "";
        if (userLevel.equals("DEO")) {
            status = Util.IN_BULK;
        } else if (userLevel.equals("ES")) {
            status = Util.VALIDATION_ES;
        } else if (userLevel.equals("EE")) {
            status = Util.APPROVAL_EE;
        }


        List<MmsTxntowermaintenance> TowerMaintance = towerTxtMaintenance.findAllByStatus(status,deptId);

        System.out.println("editTMnewS :" + TowerMaintance.size());


        Map<String, String> lineList = new LinkedHashMap<String, String>();
        System.out.println("hi");
        Map<String, String> areaList = new LinkedHashMap<String, String>();
        Map<String, String> provinceList = new LinkedHashMap<String, String>();
        Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
        String userName = (String) request.getSession().getAttribute(
                "loggedUser");

        List<MmsAddsupporttype> supType = supTypeDao.findAll();
        List<MmsAddline> lineObj = addLine.findAll();
        List<String> provinces = new ArrayList<String>();

        int supLoop = supType.size() - 1;
        for (int i = 0; i <= supLoop; i++) {
            // System.out.println(i);
            MmsAddsupporttype ojb = supType.get(i);
            supportTypeList.put(ojb.getId(), ojb.getSupportType());

        }

        int lineLoop = lineObj.size() - 1;
        for (int i = 0; i <= lineLoop; i++) {
            // System.out.println(i);
            MmsAddline ojb = lineObj.get(i);
            lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
        }

        model.setSupTypeList(supportTypeList);
        model.setProvinceList(provinceList);
        model.setAreaList(areaList);
        model.setLineList(lineList);
        model.setMmsTxtMntList(TowerMaintance);

        // edit anushka 2019-01-08
        // ------------------------------------------------------------------------------------------------------------
        int supSize = TowerMaintance.size() - 1;
        String stringOfMaintenance = "";

        for (int i = 0; i <= supSize; i++) {
            MmsTxntowermaintenance obj = TowerMaintance.get(i);
            //MmsTxntowermaintenance obj = TowerMaintance.get(i);
			MmsAddsupport objSupport =   addSupport.findById(obj.getId().getTowerid());
			if(objSupport != null){
				TowerMaintance.get(i).setHotLineMnt(objSupport.getTowerNo());
				
			}
            
            
            if (i != 0) {
                stringOfMaintenance = stringOfMaintenance + ","
                        + Long.toString(obj.getId().getTowerid());
            } else {
                stringOfMaintenance = Long.toString(obj.getId().getTowerid());
            }
        }
        System.out.println("-------------------> stringOfMaintainance: "
                + stringOfMaintenance);

        model.setStringOfMaintenance(stringOfMaintenance);
        // -------------------------------------------------------------------------------------------------------

        System.out.println("end displayAllMnt :");
        return new ModelAndView("displayAllMnt", "model", model);
    }
	
	
	@RequestMapping(value = "/addTowerMntMobile", method = RequestMethod.POST)
	public @ResponseBody String addTowerMntMobile(@RequestBody MmsTxntowermaintenance towerObj,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		MmsTxntowermaintenance objExisting = null;
		objExisting = towerTxtMaintenance.findByID(towerObj.getId());
		if(objExisting == null){
			System.out.println("new");
			String resultobj = towerTxtMaintenance.addTowerMaintananceData(towerObj);
			return "NEW";
		}
		else{
			System.out.println("update");
			String resultobj1 = towerTxtMaintenance.update(towerObj);
			return "UPDATE";
		}
		
		//return null;
	}
	
	
	
	@RequestMapping(value = "/addComplesionMntMobile", method = RequestMethod.POST)
	public @ResponseBody String addComplesionMntMobile(@RequestBody MmsTxntowermntcomplesion towerObj,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		MmsTxntowermntcomplesion objExisting = null;
		objExisting = complesionMaintenanceDao.findByID(towerObj.getId());
		if(objExisting == null){
			System.out.println("new");
			String resultobj = complesionMaintenanceDao.addTowerMaintananceData(towerObj);
			return "NEW";
		}
		else{
			System.out.println("update");
			String resultobj1 = complesionMaintenanceDao.update(towerObj);
			return "UPDATE";
		}
		
		//return null;
	}
	
	
	@RequestMapping(value = "/getMntData/{towerNo}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody MmsTxntowermaintenance getMntData(@PathVariable("towerNo") String towerNo) {
		System.out.println("update");
		MmsTxntowermaintenancePK pkMnt= new MmsTxntowermaintenancePK();
		pkMnt.setTowerid(2628);
		pkMnt.setVisitid(132);
		MmsTxntowermaintenance mnt = towerTxtMaintenance.findByID(pkMnt);
		
		return mnt;
	}
	
	
	@RequestMapping(value = "/mntCompletion", method = RequestMethod.GET)
	public ModelAndView mntCompletion(HttpServletRequest request,@ModelAttribute("model") PivModel model) {
		
		
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
		//PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			//System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		
		
		Map<String,String> cycle = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 
		model.setCycleList(cycle);
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		//String canGO = "";
		
		//model.setMode(mode);
		
		
		
		//model.setMode(mode);
		ModelAndView mo = new ModelAndView("editTMnewCompletion","model",model);
		
		//mo.addObject("canGO", canGO);
		
		return mo;
		
		
		
	}
	
	
	@RequestMapping(value = "/mntViewCompletion", method = RequestMethod.GET)
	public ModelAndView mntViewCompletion(HttpServletRequest request,@ModelAttribute("model") PivModel model) {
		
		
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
		//PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			//System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		
		
		Map<String,String> cycle = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 
		model.setCycleList(cycle);
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		//String canGO = "";
		
		//model.setMode(mode);
		
		
		
		//model.setMode(mode);
		ModelAndView mo = new ModelAndView("editTMnewCompletionView","model",model);
		
		//mo.addObject("canGO", canGO);
		
		return mo;
		
		
		
	}

	
	
	
	@RequestMapping("/mntCompletionS")
	public ModelAndView mntCompletionS(HttpServletRequest request,@ModelAttribute("model") PivModel model) {

				
		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		String status ="";
		
		System.out.println("model.getMode() :" + model.getMode());  
		
		
		if (userLevel.equals("ES")) {
			status = Util.APPROVE;
		} else if(userLevel.equals("EE")){
			status = "11";
		}
	//}
			//else if (userLevel.equals("ES")) {
//			status = Util.VALIDATION_ES;
//		} else if (userLevel.equals("EE")) {
//			status = Util.APPROVAL_EE;
//		}
	 
		String area = model.getGldeptobj().getDeptId();
		String line = String.valueOf(model.getLine().getCode());
		String id ="";
		if(line.equalsIgnoreCase("NONE")){
			id ="NONE";
		}else{
			id = addLine.findIdByCode(line.trim());
		}
		System.out.println("id :" + id);  
		String province = model.getGlcompmobj().getCompId();
		//String cycle=model.getCycle();
		String cycle=model.getCycleObj().getId().getCycleId();
		System.out.println("editTMnewS : " +area + id+province+cycle);
		
		//List<MmsTxntowermaintenance> TowerMaintance = towerTxtMaintenance.findAllByAreaLineCycle( area, id, cycle,status);
		//List<MmsTxntowermaintenance> TowerMaintance = null;
		List<MmsTxntowermntcomplesion> towerMaintanceCompletion = null;
		
		//if(userLevel.equals("ES")){
			//TowerMaintance = towerTxtMaintenance.findAllByAreaLineCycle( area, id, cycle,status);
			
		//}
		
		//if(userLevel.equals("EE")){
			towerMaintanceCompletion = complesionMaintenanceDao.findAllByAreaLineCycle( area, id, cycle,status);
			
		//}
		System.out.println("editTMnewS :"+towerMaintanceCompletion.size());
		//String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		//List<LinkedHashMap> Support=restTemplate.getForObject(url, List.class);
	//	model.setTowerMaintance(TowerMaintance);
		//pivModel.setProvinceList(pivModel.getProvinceList());



		Map<String,String> lineList = new LinkedHashMap<String,String>();
		System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
	///		String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		/* String */ province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
	///		PivModel model = new PivModel();
		List<Glcompm> line1 = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(model.getGlcompmobj().getCompId());
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findLineByArea(model.getGldeptobj().getDeptId());
		List<String> provinces = new ArrayList<String>();
		int loop = line1.size()-1;
		for(int i=0;i<=loop;i++){ 
		//	System.out.println(i);
		  Glcompm ojb = line1.get(i);
		  
		  //System.out.println(ojb.getCompNm());
		  provinces.add(ojb.getCompNm());
		  provinceList.put(ojb.getCompId(), ojb.getCompNm());
		  
		} 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
		  
		} 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		} 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		} 
		
		Map<String,String> cycle1 = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle1.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 


        model.setCycleList(cycle1);
		
		model.setCycle(cycle);
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		
		// edit anushka 2019-01-08
				// ------------------------------------------------------------------------------------------------------------
				int supSize = towerMaintanceCompletion.size() - 1;
				String stringOfMaintenance = "";

				for (int i = 0; i <= supSize; i++) {
					MmsTxntowermntcomplesion obj = towerMaintanceCompletion.get(i);
					//complesionMaintenanceDao.addTowerMaintananceData(towermaintenance);
					
					MmsAddsupport objSupport =   addSupport.findById(obj.getId().getTowerid());
					if(objSupport != null){
						towerMaintanceCompletion.get(i).setHotLineMnt(objSupport.getTowerNo());
						
					}
					
					if (i != 0) {
						stringOfMaintenance = stringOfMaintenance + ","
								+ Long.toString(obj.getId().getTowerid());
					} else {
						stringOfMaintenance = Long.toString(obj.getId().getTowerid());
					}
				}
				System.out.println("-------------------> stringOfMaintainance: "
						+ stringOfMaintenance);

				model.setStringOfMaintenance(stringOfMaintenance);
				// -------------------------------------------------------------------------------------------------------
		
		
				
				model.setMmsTxtCompletionList(towerMaintanceCompletion);
				
				
				
				
				
		System.out.println("end editTMnewS :");
		return new ModelAndView("editTMnewCompletion","model",model);
	}
	
	
	@RequestMapping("/mntViewCompletionS")
	public ModelAndView mntViewCompletionS(HttpServletRequest request,@ModelAttribute("model") PivModel model) {

				
		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		String status ="";
		
		System.out.println("model.getMode() :" + model.getMode());  
		
		
			status = Util.APPROVE;
		
	//}
			//else if (userLevel.equals("ES")) {
//			status = Util.VALIDATION_ES;
//		} else if (userLevel.equals("EE")) {
//			status = Util.APPROVAL_EE;
//		}
	 
		String area = model.getGldeptobj().getDeptId();
		String line = String.valueOf(model.getLine().getCode());
		String id ="";
		if(line.equalsIgnoreCase("NONE")){
			id ="NONE";
		}else{
			id = addLine.findIdByCode(line.trim());
		}
		System.out.println("id :" + id);  
		String province = model.getGlcompmobj().getCompId();
		//String cycle=model.getCycle();
		String cycle=model.getCycleObj().getId().getCycleId();
		System.out.println("editTMnewS : " +area + id+province+cycle);
		
		//List<MmsTxntowermaintenance> TowerMaintance = towerTxtMaintenance.findAllByAreaLineCycle( area, id, cycle,status);
		//List<MmsTxntowermaintenance> TowerMaintance = null;
		List<MmsTxntowermntcomplesion> towerMaintanceCompletion = null;
		
		//if(userLevel.equals("ES")){
			//TowerMaintance = towerTxtMaintenance.findAllByAreaLineCycle( area, id, cycle,status);
			
		//}
		
		//if(userLevel.equals("EE")){
			towerMaintanceCompletion = complesionMaintenanceDao.findAllByAreaLineCycle( area, id, cycle,status);
			
		//}
		System.out.println("editTMnewS :"+towerMaintanceCompletion.size());
		//String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		//List<LinkedHashMap> Support=restTemplate.getForObject(url, List.class);
	//	model.setTowerMaintance(TowerMaintance);
		//pivModel.setProvinceList(pivModel.getProvinceList());



		Map<String,String> lineList = new LinkedHashMap<String,String>();
		System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
	///		String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		/* String */ province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
	///		PivModel model = new PivModel();
		List<Glcompm> line1 = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(model.getGlcompmobj().getCompId());
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findLineByArea(model.getGldeptobj().getDeptId());
		List<String> provinces = new ArrayList<String>();
		int loop = line1.size()-1;
		for(int i=0;i<=loop;i++){ 
		//	System.out.println(i);
		  Glcompm ojb = line1.get(i);
		  
		  //System.out.println(ojb.getCompNm());
		  provinces.add(ojb.getCompNm());
		  provinceList.put(ojb.getCompId(), ojb.getCompNm());
		  
		} 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
		  
		} 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		} 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		} 
		
		Map<String,String> cycle1 = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle1.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 


        model.setCycleList(cycle1);
		
		model.setCycle(cycle);
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		
		// edit anushka 2019-01-08
				// ------------------------------------------------------------------------------------------------------------
				int supSize = towerMaintanceCompletion.size() - 1;
				String stringOfMaintenance = "";

				for (int i = 0; i <= supSize; i++) {
					MmsTxntowermntcomplesion obj = towerMaintanceCompletion.get(i);
					//complesionMaintenanceDao.addTowerMaintananceData(towermaintenance);
					
					MmsAddsupport objSupport =   addSupport.findById(obj.getId().getTowerid());
					if(objSupport != null){
						towerMaintanceCompletion.get(i).setHotLineMnt(objSupport.getTowerNo());
						
					}
					
					if (i != 0) {
						stringOfMaintenance = stringOfMaintenance + ","
								+ Long.toString(obj.getId().getTowerid());
					} else {
						stringOfMaintenance = Long.toString(obj.getId().getTowerid());
					}
				}
				System.out.println("-------------------> stringOfMaintainance: "
						+ stringOfMaintenance);

				model.setStringOfMaintenance(stringOfMaintenance);
				// -------------------------------------------------------------------------------------------------------
		
		
				
				model.setMmsTxtCompletionList(towerMaintanceCompletion);
				
				
				
				
				
		System.out.println("end editTMnewS :");
		return new ModelAndView("editTMnewCompletionView","model",model);
	}

	
	@RequestMapping(value = "/mntCompletionApproval", method = RequestMethod.GET)
	public ModelAndView mntCompletionApproval(HttpServletRequest request,@ModelAttribute("model") PivModel model) {
		
		
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
		//PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			//System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		
		
		Map<String,String> cycle = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 
		model.setCycleList(cycle);
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		//String canGO = "";
		
		
		
		
		
		//model.setMode(mode);
		ModelAndView mo = new ModelAndView("editTMnewCompletionApproval","model",model);
		
		//mo.addObject("canGO", canGO);
		
		return mo;
		
		
		
	}
	
	
	@RequestMapping("/mntCompletionSApproval")
	public ModelAndView mntCompletionSApproval(HttpServletRequest request,@ModelAttribute("model") PivModel model) {

			
		
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		String status ="";
		if (userLevel.equals("ES")) {
			status = Util.APPROVE;
		} 
			//else if (userLevel.equals("ES")) {
//			status = Util.VALIDATION_ES;
//		} else if (userLevel.equals("EE")) {
//			status = Util.APPROVAL_EE;
//		}
	 
		String area = model.getGldeptobj().getDeptId();
		String line = String.valueOf(model.getLine().getCode());
		String id ="";
		if(line.equalsIgnoreCase("NONE")){
			id ="NONE";
		}else{
			id = addLine.findIdByCode(line.trim());
		}
		System.out.println("id :" + id);  
		String province = model.getGlcompmobj().getCompId();
		//String cycle=model.getCycle();
		String cycle=model.getCycleObj().getId().getCycleId();
		System.out.println("editTMnewS : " +area + id+province+cycle);
		
		//List<MmsTxntowermaintenance> TowerMaintance = towerTxtMaintenance.findAllByAreaLineCycle( area, id, cycle,status);
		List<MmsTxntowermaintenance> TowerMaintance = null;
		List<MmsTxntowermntcomplesion> towerMaintanceCompletion = null;
		
		/*if(userLevel.equals("ES")){
			TowerMaintance = towerTxtMaintenance.findAllByAreaLineCycle( area, id, cycle,status);
			
		}
		
		if(userLevel.equals("EE")){
		*/	towerMaintanceCompletion = complesionMaintenanceDao.findAllByAreaLineCycle( area, id, cycle,status);
			
		//}
		System.out.println("editTMnewS :"+TowerMaintance.size());
		//String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		//List<LinkedHashMap> Support=restTemplate.getForObject(url, List.class);
	//	model.setTowerMaintance(TowerMaintance);
		//pivModel.setProvinceList(pivModel.getProvinceList());



		Map<String,String> lineList = new LinkedHashMap<String,String>();
		System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
	///		String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		/* String */ province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
	///		PivModel model = new PivModel();
		List<Glcompm> line1 = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line1.size()-1;
		for(int i=0;i<=loop;i++){ 
		//	System.out.println(i);
		  Glcompm ojb = line1.get(i);
		  
		  //System.out.println(ojb.getCompNm());
		  provinces.add(ojb.getCompNm());
		  provinceList.put(ojb.getCompId(), ojb.getCompNm());
		  
		} 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
		  
		} 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		} 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		} 
		
		Map<String,String> cycle1 = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle1.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 


        model.setCycleList(cycle1);
		
		model.setCycle(cycle);
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		
		// edit anushka 2019-01-08
				// ------------------------------------------------------------------------------------------------------------
				int supSize = TowerMaintance.size() - 1;
				String stringOfMaintenance = "";

				for (int i = 0; i <= supSize; i++) {
					MmsTxntowermaintenance obj = TowerMaintance.get(i);
					//complesionMaintenanceDao.addTowerMaintananceData(towermaintenance);
					
					MmsAddsupport objSupport =   addSupport.findById(obj.getId().getTowerid());
					if(objSupport != null){
						TowerMaintance.get(i).setHotLineMnt(objSupport.getTowerNo());
						
					}
					
					if (i != 0) {
						stringOfMaintenance = stringOfMaintenance + ","
								+ Long.toString(obj.getId().getTowerid());
					} else {
						stringOfMaintenance = Long.toString(obj.getId().getTowerid());
					}
				}
				System.out.println("-------------------> stringOfMaintainance: "
						+ stringOfMaintenance);

				model.setStringOfMaintenance(stringOfMaintenance);
				// -------------------------------------------------------------------------------------------------------
		
		
				
				model.setMmsTxtMntList(TowerMaintance);
				
				
				
				
				
		System.out.println("end editTMnewS :");
		return new ModelAndView("editTMnewCompletionApproval","model",model);
	}

	

	
	
	@RequestMapping(value = "/updateTMComplesion", method = RequestMethod.GET)
	 public ModelAndView updateTMComplesion(@ModelAttribute("model")  PivModel model,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception{
		String message = "Welcome to Spring 4.0 !";
		String deptId =(String)request.getSession().getAttribute("deptId");
		
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		Map<String,String> cycle = new LinkedHashMap<String,String>();
		
		int cycleLisuCount = cycleList.size()-1;
				for(int i=0;i<=cycleLisuCount;i++){ 
					//System.out.println(i);
					MvmmsCycle ojb = cycleList.get(i);
					cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
			      
	    } 
				

		model.setCycleList(cycle);
		return new ModelAndView("MMS_TMCompletion", "model", model);
				
	}
	
	
	@RequestMapping(value = "/goToUpdateeditCompletionData", method = RequestMethod.POST)
	public ModelAndView goToUpdateEquipment(@ModelAttribute("model") PivModel pivModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("--> IN /goToUpdateeditCompletionData");
		String deptId = request.getSession().getAttribute("deptId").toString();
		
		String success = "";
		String errormsg = "";
		String submitType = "search";
		//String deptId =(String)request.getSession().getAttribute("deptId");
		
		
		MmsTxntowermaintenance obj = new MmsTxntowermaintenance();
		MmsTxntowermaintenancePK objOK = new MmsTxntowermaintenancePK();
		System.out.println("--> IN /goToUpdateeditCompletionData 1" + pivModel.getTxtMntObj().getId().getTowerid());
		System.out.println("--> IN /goToUpdateeditCompletionData 2" + pivModel.getCycleObj().getId().getCycleId());
		long towerId = pivModel.getTxtMntObj().getId().getTowerid();
		String cycleID = pivModel.getCycleObj().getId().getCycleId();
		objOK.setTowerid(pivModel.getTxtMntObj().getId().getTowerid());
		objOK.setVisitid(new Long(cycleID));
		obj = towerTxtMaintenance.findByTowerIdCycle(towerId,cycleID);
		
		
		System.out.println("obj :"+ "" +obj );
		
		
		ModelAndView mo = null;
		
		if(obj != null){
			submitType = "update";
			pivModel.setTxtMntObj(obj);
				
			Map<String,String> cycle1 = new LinkedHashMap<String,String>();
			List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
			int cycleLisuCount = cycleList.size()-1;
			for(int i=0;i<=cycleLisuCount;i++){ 
				//System.out.println(i);
				MvmmsCycle ojb = cycleList.get(i);
				cycle1.put(ojb.getId().getCycleId(), ojb.getCycleName());
		      
		    } 


			pivModel.setCycleList(cycle1);

			
		}
		else{
			
			
			Map<String,String> cycle1 = new LinkedHashMap<String,String>();
			List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
			int cycleLisuCount = cycleList.size()-1;
			for(int i=0;i<=cycleLisuCount;i++){ 
				//System.out.println(i);
				MvmmsCycle ojb = cycleList.get(i);
				cycle1.put(ojb.getId().getCycleId(), ojb.getCycleName());
		      
		    } 


			pivModel.setCycleList(cycle1);


			//pivModel.setTxtMntObj(pivModel.getTxtMntObj());
			errormsg = "No Maintenance data found for this ID.. ";
			
		
		}
		
		

		/*String equipmentId = pcbModel.getPcbEquipment().getEquipmentId();

		PcbEquipment pcbEquipment = addEquipment
				.findEquipmentByEquipmentId(equipmentId);
		PcbSample pcbSample = addSample.findSampleByEquipmentId(equipmentId);
		PcbCondition pcbCondition = addCondition
				.findConditionByEquipmentId(equipmentId);
		PcbLocation pcbLocation = addLocation
				.findLocationByEquipmentId(equipmentId);

		if (pcbEquipment != null) {
			pcbModel.setPcbEquipment(pcbEquipment);

			System.out.println("dateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee: "
					+ pcbModel.getPcbEquipment().getManufactureDate());

			if (pcbSample != null) {
				pcbModel.setPcbSample(pcbSample);
			}
			if (pcbCondition != null) {
				pcbModel.setPcbCondition(pcbCondition);
			}
			if (pcbLocation != null) {
				pcbModel.setPcbLocation(pcbLocation);
			}

			// get and set list of divisions
			List<PCB_Division> divisionList = divisionDao.getAll();
			pcbModel.setDivisionList(divisionList);

			submitType = "update";
			mo = new ModelAndView("editCompletionData", "model", pcbModel);
		} else {
			errormsg = "Invalid Equipment ID.. ";
		}*/

		
		
		mo = new ModelAndView("editCompletionData", "model", pivModel);
		mo.addObject("submitType", submitType);
		mo.addObject("success", success);
		mo.addObject("errormsg", errormsg);
		
		return mo;
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/editCompletionData", method = RequestMethod.GET)
	public ModelAndView editCompletionData(@RequestParam("towerNo") long towerNo,@RequestParam("test") String test,@ModelAttribute("model") PivModel pivModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		

		ModelAndView mo = null;
		try {
			System.out.println("--> IN /editEquipment" +towerNo );

			String submitType = "search";
			pivModel = new PivModel();
			System.out.println("--> IN /editEquipment 1"+ "" +towerNo );
			
			
			Map<String,String> cycle1 = new LinkedHashMap<String,String>();
			List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
			int cycleLisuCount = cycleList.size()-1;
			for(int i=0;i<=cycleLisuCount;i++){ 
				//System.out.println(i);
				MvmmsCycle ojb = cycleList.get(i);
				cycle1.put(ojb.getId().getCycleId(), ojb.getCycleName());
		      
		    } 


			pivModel.setCycleList(cycle1);


			MmsTxntowermaintenance mntObj = new MmsTxntowermaintenance();
			MmsTxntowermaintenancePK mntObjPK = new MmsTxntowermaintenancePK();
			mntObjPK.setTowerid(towerNo);
			pivModel.setTxtMntObj(mntObj);
			pivModel.getTxtMntObj().setId(mntObjPK);
			System.out.println("--> IN /editEquipment 2"+ "" +towerNo );

			mo = new ModelAndView("editCompletionData", "model",pivModel);

			mo.addObject("submitType", submitType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mo;
	}

	
	
	@RequestMapping(value = "/sendSMS", method = RequestMethod.GET)
	public void sendSMS() throws Exception {
		System.out.println("sendSMS" );

		try {
			System.out.println("sendSMS 1" );

			RestTemplate restTemplate = new RestTemplate();
			System.out.println("sendSMS 2" );

			String url="http://smsgw.ceb/SMSPlatform.php?recipients=714537313&smsbody=SMS_Test&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			System.out.println("sendSMS 3" );
			//Util.trustEveryone();
			
			restTemplate.getForObject(url, String.class);
			System.out.println("sendSMS 4" );
						
			
			/*restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
			restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
            String uri = new String(url);
            restTemplate.postForObject(uri, String.class, String.class, "");
*/
			
			

		} catch (Exception e) {
			System.out.println("sendSMS 5" + e );
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	private MmsTxntowermntcomplesion getCompletionObject(MmsTxntowermaintenance obj){
		MmsTxntowermntcomplesion objComplesion = new MmsTxntowermntcomplesion();
		
		MmsTxntowermntcomplesionPK objComplesionPk = new MmsTxntowermntcomplesionPK();
		
		objComplesionPk.setTowerid(obj.getId().getTowerid());
		objComplesionPk.setVisitid(obj.getId().getVisitid());
		
		
		
		objComplesion.setId(objComplesionPk);
		
		
		objComplesion.setNooftappings(obj.getNooftappings());
		objComplesion.setPinpole1(obj.getPinpole1());
	    // System.out.println("hiiiiii66664");
	     objComplesion.setSwitchdev1(obj.getSwitchdev1());
	 	//System.out.println("hiiiiii66665");
	 	objComplesion.setPinpole2(obj.getPinpole2());
	 	//System.out.println("hiiiiii66666");
	 	objComplesion.setSwitchdev2(obj.getSwitchdev2());
	 	//System.out.println("hiiiiii66667");
	 	objComplesion.setPinpole3(obj.getPinpole3());
	 	//System.out.println("hiiiiii66668");
	 	objComplesion.setSwitchdev3(obj.getSwitchdev3());
	 	//System.out.println("hiiiiii66669");
	 	objComplesion.setNoofmissingparts(obj.getNoofmissingparts());
	 	//System.out.println("hiiiiii666610");
	 	objComplesion.setNofflashoversets(obj.getNofflashoversets());
	 	//System.out.println("hiiiiii666611");
	 	objComplesion.setWayleavestatus(obj.getWayleavestatus());
	 	//System.out.println("hiiiiii666612");
	 	objComplesion.setBaseconcretestatus(obj.getBaseconcretestatus());
	 	//System.out.println("hiiiiii666613");
	 	objComplesion.setAnticlimbingstatus(obj.getAnticlimbingstatus());
	 	//System.out.println("hiiiiii666614");
	 	objComplesion.setConductorstatus(obj.getConductorstatus());
	 	//System.out.println("hiiiiii666615");
	 	objComplesion.setJumperstatus(obj.getJumperstatus());
	 	//System.out.println("hiiiiii666616");
	 	objComplesion.setEarthconductorstatus(obj.getEarthconductorstatus());
	 	//System.out.println("hiiiiii666617");
	 	objComplesion.setAttentionstatus(obj.getAttentionstatus());
	 	//System.out.println("hiiiiii666618");
	 	objComplesion.setFungussetno(obj.getFungussetno());
	 	//System.out.println("hiiiiii666619");
	 	objComplesion.setWpinset(obj.getWpinset());
	 	//System.out.println("hiiiiii666620");
	 	objComplesion.setEndfittingset(obj.getEndfittingset());
	 	//System.out.println("hiiiiii666621");
	 	objComplesion.setTowerspecial(obj.getTowerspecial());
	 	objComplesion.setHotpossible(obj.getHotpossible());
	 	//System.out.println("hiiiiii666622");
	 	//obj.setLudt(new Date(ludt));
	 	//Date dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(ludt);
	 	
	 	//obj.setMaintenancedate(new Date(maintenancedate));
	 	//Date dateNow1 = new SimpleDateFormat("yyyy-MM-dd").parse(maintenancedate);
	 	//System.out.println("hiiiiii666623status : "+ status);
	 	objComplesion.setStatus(obj.getStatus());
	 	//System.out.println("hiiiiii666623");
	 	objComplesion.setApprovalLevel(obj.getApprovalLevel());
	 	//System.out.println("hiiiiii666624");
	 	objComplesion.setLudt(obj.getLudt());
	 	//System.out.println("hiiiiii666625");
	 	objComplesion.setMaintenancedate(obj.getMaintenancedate());
	 	objComplesion.setLegPainting(obj.getLegPainting());
	 	objComplesion.setCycle(obj.getCycle());
	 	//System.out.println("hiiiiii666626");
	 
		
	 	MmsTxntowermntcomplesion objComplesionExis = new MmsTxntowermntcomplesion();
		
	 	objComplesionExis = complesionMaintenanceDao.findByID(objComplesion.getId());
		if(objComplesionExis != null){
			complesionMaintenanceDao.update(objComplesion);
			
		}else{
			complesionMaintenanceDao.addTowerMaintananceData(objComplesion);
			
		}
		return null;
	}
	
	
	@RequestMapping(value = "/updateTapping", method = RequestMethod.GET)
	public ModelAndView updateTapping(HttpServletRequest request) {
		
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
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			//System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		Map<String,String> cycle = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 


		model.setCycleList(cycle);
		
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		//model.setMode(mode);
		return new ModelAndView("updateTapping","model",model);
	}
	
	@RequestMapping("/updateTappingS")
	public ModelAndView updateTappingS(HttpServletRequest request,@ModelAttribute("model") PivModel model) {

		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		String status ="";
		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVE;
		}
	 
		String area = model.getGldeptobj().getDeptId();
		String line = String.valueOf(model.getLine().getCode());
		String id ="";
		if(line.equalsIgnoreCase("NONE")){
			id ="NONE";
		}else{
			id = addLine.findIdByCode(line.trim());
		}
		System.out.println("id :" + id);  
		String province = model.getGlcompmobj().getCompId();
		//String cycle=model.getCycle();
		String cycle=model.getCycleObj().getId().getCycleId();
		System.out.println("editTMnewS : " +area + id+province+cycle);
		
		List<MmsTxntowermaintenance> TowerMaintance = towerTxtMaintenance.findAllByAreaLineCycle( area, id, cycle,status);
		
		System.out.println("editTMnewS :"+TowerMaintance.size());
		//String url=Util.STR_SER+"findAllSupportByStatus?status=2";
		//List<LinkedHashMap> Support=restTemplate.getForObject(url, List.class);
	//	model.setTowerMaintance(TowerMaintance);
		//pivModel.setProvinceList(pivModel.getProvinceList());



		Map<String,String> lineList = new LinkedHashMap<String,String>();
		System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
	///		String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		/* String */ province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
	///		PivModel model = new PivModel();
		List<Glcompm> line1 = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line1.size()-1;
		for(int i=0;i<=loop;i++){ 
		//	System.out.println(i);
		  Glcompm ojb = line1.get(i);
		  
		  //System.out.println(ojb.getCompNm());
		  provinces.add(ojb.getCompNm());
		  provinceList.put(ojb.getCompId(), ojb.getCompNm());
		  
		} 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
		  
		} 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			//System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		} 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			//System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		} 
		
		Map<String,String> cycle1 = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle1.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 


model.setCycleList(cycle1);
		model.setCycle(cycle);
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		model.setMmsTxtMntList(TowerMaintance);
		
		// edit anushka 2019-01-08
				// ------------------------------------------------------------------------------------------------------------
				int supSize = TowerMaintance.size() - 1;
				String stringOfMaintenance = "";

				for (int i = 0; i <= supSize; i++) {
					MmsTxntowermaintenance obj = TowerMaintance.get(i);
					MmsAddsupport objSupport =   addSupport.findById(obj.getId().getTowerid());
					if(objSupport != null){
						TowerMaintance.get(i).setHotLineMnt(objSupport.getTowerNo());
						
					}
					
					if (i != 0) {
						stringOfMaintenance = stringOfMaintenance + ","
								+ Long.toString(obj.getId().getTowerid());
					} else {
						stringOfMaintenance = Long.toString(obj.getId().getTowerid());
					}
				}
				System.out.println("-------------------> stringOfMaintainance: "
						+ stringOfMaintenance);

				model.setStringOfMaintenance(stringOfMaintenance);
				// -------------------------------------------------------------------------------------------------------
		
		
		System.out.println("end editTMnewS :");
		return new ModelAndView("updateTapping","model",model);
	}
	
	
	
	@RequestMapping(value = "/MMSAddMntMobile", method = RequestMethod.POST)
	public @ResponseBody String MMSAddMntMobile(@RequestBody MmsTxntowermaintenance tower,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//System.out.println("equipment : " + equipment.getCode());
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date today = Calendar.getInstance().getTime();        
			String reportDate = df.format(today);
			System.out.println("equipment : 1 ");
			Date dateNowNew=null;
			
			DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
			//String insTime = df2.format(today);
			Date insTimeDate=null;
			System.out.println("equipment : 2 ");
			
			//insTimeDate = new SimpleDateFormat("HH-MM-SS").parse(insTime);
			dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);
			
			
		       SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
		        String time = localDateFormat.format(new Date());
		        System.out.println(time);

			
			
			System.out.println("equipment : 3 ");
			
			
			tower.setInsDate(dateNowNew);
			System.out.println("equipment : 4 ");
			
			tower.setInsTime(time);
			System.out.println("equipment : 5 ");
			
			MmsTxntowermaintenance objExisting = towerTxtMaintenance.findByID(tower.getId());
			
			
			if(objExisting == null){
				System.out.println("new");
				String resultobj = towerTxtMaintenance.addTowerMaintananceData(tower);
				//return "Y";
			}
			else{
				System.out.println("update");
				String resultobj1 = towerTxtMaintenance.update(tower);
				//return "Y";
			}
			
			if(tower != null){
				if(tower.getId() != null){
					MmsAddsupport obj =  addSupport.findById(tower.getId().getTowerid());
					if(obj != null){
						obj.setTapping(tower.getNooftappings());
						addSupport.update(obj);
					}
					
				}
				
			}
			
			
			
			////towerTxtMaintenance.addTowerMaintananceData(tower);
			return "Y";
		} catch (Exception e) {
			System.out.println("error :" + e.getMessage());
			return "N";
		}

	}



	@RequestMapping(value = "/sendRequestToES/{emailId}/{es}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void sendRequestToES(HttpServletRequest request,@PathVariable("emailId") String emailId,
			@PathVariable("es") String es) {
		System.out.println("sendRequestToES :hhhhh" );
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("sendRequestToES :" + deptId );
		
		ApprovalMm obj = approvalMm.findByID(emailId);
		obj.setApprovedBy(es);
		obj.setEs(es);
		
		obj.setToStatus("99");
		System.out.println("sendRequestToES 1:" );
		
		approvalMm.update(obj);
		System.out.println("sendRequestToES 2:" );
		
		SausermMm userMm = null;
		if(es != null){
			try {
				
				userMm =secDao.getSausermMms(es);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("model.getSausermEE().getUserId() "+ es);
			
		}
		
		String content = "";
		String subject = "";
		String sms_content ="";
		String firstClouse="";
		
		DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
		String subject_str = subject_str_fm.format(today);

if(obj.getApprovalType().equalsIgnoreCase("INTREQ")){
		content = "\n\nInspection request is sent by Maintenance Engineer - PHM. Please check.\n\nThank You";
		
		subject ="Inspection request " + obj.getApprovalId() + " " + subject_str;
		sms_content ="Inspection request is sent by Maintenance Engineer - PHM . Please check.Thank You";
		firstClouse =userMm.getUserNm();
}else{
	content = "\n\nMaintenance request is sent by Maintenance Engineer - PHM. Please check.\n\nThank You";
	
	subject ="Maintenance request " + obj.getApprovalId() + " " + subject_str;
	sms_content ="Maintenance request is sent by Maintenance Engineer - PHM . Please check . Thank You";
	firstClouse =userMm.getUserNm();
}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");
		String url="";
		String urlCC="";
		
		if(userMm != null){
			if(userMm.getTelNo() != null){
				System.out.println("userMm.getTelNo() " + userMm.getTelNo());
				
				url="http://smsgw.ceb/SMSPlatform.php?recipients="+userMm.getTelNo().trim()+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
				urlCC="http://smsgw.ceb/SMSPlatform.php?recipients=0714565970&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			}else{
				url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+userMm.getUserId()+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
				
			}
		}
		if(userMm != null){
			if(userMm.getEmail() != null){
				System.out.println("userMm.getEmail() "+ userMm.getEmail());
				
				mm.sendMailTo(firstClouse, content ,userMm.getEmail(),subject);
		        //mm.sendMailTo(firstClouse, content ,"gchampika28@gmail.com",subject);
		        //mm.sendMailTo(firstClouse, content ,"eranga.bogahakumbura@gmail.com",subject);
				
				mm.sendMailTo(firstClouse, content ,userMm.getEmail(),"mnmnihaj@gmail.com",subject,null,null,null,null,null,null);

				}else{
				mm.sendMailTo(firstClouse, content+ userMm.getUserId() ,"gchampika28@gmail.com",subject);
				
			}
			
		}







		
		
		
		
	}
	
	
	@RequestMapping(value = "/sendReplyToArea", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void sendReplyToArea(HttpServletRequest request,@RequestParam("id") String emailId,
			@RequestParam("remarks") String remarks) {
		System.out.println("sendRequestToES :hhhhh" );
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("sendRequestToES :" + deptId );
		
		ApprovalMm obj = approvalMm.findByID(emailId);
		//obj.setToStatus("21");
		System.out.println("sendRequestToES 1:" );
		
		approvalMm.update(obj);
		System.out.println("remarks 2:" + remarks);
		
		String area = obj.getDeptId().trim();
		String area_name = gldeptDao.getName(area);
		
		
		String email="";
		String telNo="";
		
		String emailcedm="";
		String telNocddm="";
		String contentcedm="";
		
		/*String areaName = gldeptDao.getDD(area);	
		String province = glcompmDao.getProvince(areaName);
		*/
		/*String emaildgm=Util.searchEmailProvinceDGM(province);
		String telNodgm=Util.searchTelNoProvinceDGM(province);
		
		*/
		email = Util.searchEmail(area.trim());
		telNo = Util.searchTelNo(area.trim());

		/*if(province.equalsIgnoreCase("EP")){
			emailcedm = "razvi.evr@gmail.com";
			telNocddm = "0718693230";
			contentcedm = "Chief Engineer ";
		}
		*/
		String userLoged = request.getSession().getAttribute("loggedUser").toString();
		SausermMm userMm = null;
		String userName ="";
		if(userLoged != null){
			try {
				
				userMm =secDao.getSausermMms(userLoged.trim());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date todayxxx = new Date();
		String subject_str = subject_str_fm.format(todayxxx);

		/*String emailCE = "";
		String telNoCE = "";
		
		if(deptId.equalsIgnoreCase("600.41")){
			emailCE = Util.cephmcp;
			telNoCE = Util.telcephmcp;
		}else if(deptId.equalsIgnoreCase("600.42")){
			emailCE = Util.cephmcpsub;
			telNoCE = Util.telcephmcpsub;
		}else if(deptId.equalsIgnoreCase("780.00")){
			emailCE = Util.cephmdd3;
			telNoCE = Util.telcephmdd3;
		}else if(deptId.equalsIgnoreCase("596.00")){
			emailCE = Util.cephmdd1;
			telNoCE = Util.telcephmdd1;
		}else{
			emailCE = "gchampika28@gmail.com";
			telNoCE = "0714537313";
		}*/
		String emailphmee =userMm.getEmail();
		String telNophmee =userMm.getTelNo();
		
		String subject = " Reply to inspection/maintenance request number :" + emailId;
		String content = "\n\n"+ remarks   + "\n\nThank You";
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");
		String[] emailList = new String[1];
		/*emailList[0] = "eranga.bogahakumbura@gmail.com";
		emailList[1] = "gchampika28@gmail.com";
		*/
		//phm ee
		emailList[0] = emailphmee;
		/*emailList[1] = emailCE;
		emailList[2] = emaildgm;
		emailList[3] = emailcedm;
		emailList[4] = "gchampika28@gmail.com";
		*///emailList[5] = email;
		
		mm.sendMailTo(area_name, content ,email,emailList,subject);
		
		//mm.sendMailTo(area_name, content ,"gchampika28@gmail.com",subject);
		
		
		
		/*String Util.searchEmail(obj.getDeptId());
		String content = "";
		String subject = "";
		String sms_content ="";
		String firstClouse="";
		
		DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
		String subject_str = subject_str_fm.format(today);

if(obj.getApprovalType().equalsIgnoreCase("INTREQ")){
		content = "\n\nInspection request is sent by Maintenance Engineer - PHM. Please check.\n\nThank You";
		
		subject ="Inspection request " + obj.getApprovalId() + " " + subject_str;
		sms_content ="Inspection request is sent by Maintenance Engineer - PHM . Please check.Thank You";
		firstClouse =userMm.getUserNm();
}else{
	content = "\n\nMaintenance request is sent by Maintenance Engineer - PHM. Please check.\n\nThank You";
	
	subject ="Maintenance request " + obj.getApprovalId() + " " + subject_str;
	sms_content ="Maintenance request is sent by Maintenance Engineer - PHM . Please check . Thank You";
	firstClouse =userMm.getUserNm();
}
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");
		String url="";
		String urlCC="";
		
		if(userMm != null){
			if(userMm.getTelNo() != null){
				System.out.println("userMm.getTelNo() " + userMm.getTelNo());
				
				url="http://smsgw.ceb/SMSPlatform.php?recipients="+userMm.getTelNo().trim()+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
				urlCC="http://smsgw.ceb/SMSPlatform.php?recipients=0713841267&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			}else{
				url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+userMm.getUserId()+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
				
			}
		}
		if(userMm != null){
			if(userMm.getEmail() != null){
				System.out.println("userMm.getEmail() "+ userMm.getEmail());
				
				mm.sendMailTo(firstClouse, content ,userMm.getEmail(),subject);
		        //mm.sendMailTo(firstClouse, content ,"gchampika28@gmail.com",subject);
		        //mm.sendMailTo(firstClouse, content ,"eranga.bogahakumbura@gmail.com",subject);
				
				mm.sendMailTo(firstClouse, content ,userMm.getEmail(),"alagodas1@gmail.com",subject,null,null,null,null,null,null);

				}else{
				mm.sendMailTo(firstClouse, content+ userMm.getUserId() ,"gchampika28@gmail.com",subject);
				
			}
			
		}
*/






		
		
		
		
	}

	
	
	
	
	
	@RequestMapping(value = "/removeMeterRequest/{emailId}/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void removeMeterRequest(HttpServletRequest request,@PathVariable("emailId") String emailId) {
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("sendRequestToES :" + deptId );
		
		ApprovalMm obj = approvalMm.findByID(emailId);
		//obj.setApprovedBy(es);
		obj.setToStatus("13");
		Date date = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		String timeString = "";
		Date date2 = null;
		try {
			String dateString1 = format1.format(date);
			date2 = format1.parse (dateString1);
			System.out.println("forwarded date :" + date2);
			
			timeString = format2.format(date);
			System.out.println("forwarded time :" + timeString);
			

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    

		obj.setForwardDate(date2);
		obj.setForwardedTime(timeString);
		
		
		System.out.println("sendRequestToES 1:" );
		
		approvalMm.update(obj);
		System.out.println("sendRequestToES 2:" );
	}
	
	
	@RequestMapping(value = "/sendMeterRequestToES/{emailId}/{es}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void sendMeterRequestToES(HttpServletRequest request,@PathVariable("emailId") String emailId,
			@PathVariable("es") String es) {
		System.out.println("sendRequestToES :hhhhh"  + es);
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("sendRequestToES :" + deptId );
		
		ApprovalMm obj = approvalMm.findByID(emailId);
		//obj.setApprovedBy(es);
		obj.setToStatus("12");
		obj.setEs(es);
		Date date = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		String timeString = "";
		Date date2 = null;
		try {
			String dateString1 = format1.format(date);
			date2 = format1.parse (dateString1);
			System.out.println("forwarded date :" + date2);
			
			timeString = format2.format(date);
			System.out.println("forwarded time :" + timeString);
			

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    

		obj.setForwardDate(date2);
		obj.setForwardedTime(timeString);
		
		
		System.out.println("sendRequestToES 1:" );
		
		approvalMm.update(obj);
		System.out.println("sendRequestToES 2:" );
		
		String email="";
		String telNo="";
		
		SausermMm esObj = secDao.getSausermMms(es);
		
		if(esObj != null ){
			email =esObj.getEmail();
			telNo =esObj.getTelNo();
		}
		
		if(es.equals("49060ES1")){
			email ="ruwanrkeng@yahoo.com";
			telNo ="0711022350";
		}else if(es.equals("49060ES2")){
			email ="rmswritigala@gmail.com";
			telNo ="0714960386";
		
		}
		else if(es.equals("49060ES3")){
			email ="asanka.dkalu@gmail.com";
			telNo ="0715340068";
		
			
		}else{
			if(esObj != null ){
				email =esObj.getEmail();
				telNo =esObj.getTelNo();
			}
			
		}
		
		String content = "";
		String subject = "";
		String sms_content ="";
		String approveType = "";
		
		
		DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
		String subject_str = subject_str_fm.format(today);

		String[] emailListEM = new String[3];
		emailListEM[0] ="thilankawanninayake@gmail.com";
		emailListEM[1] ="gchampika28@gmail.com";
		emailListEM[2] ="shihranaleer@gmail.com";
	    content = "\nMeter Testing Order Card("+emailId+") is sent by Electrical Engineer. You can view that by login into  https://mms.ceb.lk/MMS/WelcomeEM \n\nThank You";
		subject = "METER TESTING ORDER CARD("+emailId+")" + subject_str;
		sms_content ="\nThe Meter testing order card("+emailId+") is sent by Electrical Engineer. You can view that by login into  https://mms.ceb.lk/MMS/WelcomeEM";
		

        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");

		try {
			mm.sendMailTo("Electrical Superintendent", content ,email,emailListEM,subject,null,null,null,null,null,null);
			//mm.sendMailTo("Electrical Superintendent", content ,"gchampika28@gmail.com",subject,null,null,null,null,null,null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("sendSMS 2" );
		String url="http://smsgw.ceb/SMSPlatform.php?recipients="+telNo+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		//String url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		try {
			restTemplate.getForObject(url, String.class);
			
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("sendSMS 4" );

		
		
		
		
		
		
		
		
	}
	
	
	@RequestMapping(value = "/deallocateMeterRequestToES/{emailId}/{es}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void deallocateMeterRequestToES(HttpServletRequest request,@PathVariable("emailId") String emailId,
			@PathVariable("es") String es) {
		System.out.println("sendRequestToES :hhhhh"  + es);
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("sendRequestToES :" + deptId );
		
		ApprovalMm obj = approvalMm.findByID(emailId);
		//obj.setApprovedBy(es);
		//obj.setToStatus("12");
		obj.setEs(es);
		Date date = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		String timeString = "";
		Date date2 = null;
		try {
			String dateString1 = format1.format(date);
			date2 = format1.parse (dateString1);
			System.out.println("forwarded date :" + date2);
			
			timeString = format2.format(date);
			System.out.println("forwarded time :" + timeString);
			

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    

		//obj.setForwardDate(date2);
		//obj.setForwardedTime(timeString);
		
		
		System.out.println("sendRequestToES 1:" );
		
		approvalMm.update(obj);
		System.out.println("sendRequestToES 2:" );
		
		/*String email="";
		String telNo="";
		if(es.equals("49060ES1")){
			email ="ruwanrkeng@yahoo.com";
			telNo ="0711022350";
		}else if(es.equals("49060ES2")){
			email ="rmswritigala@gmail.com";
			telNo ="0714960386";
		
		}
		else if(es.equals("49060ES3")){
			email ="asanka.dkalu@gmail.com";
			telNo ="0715340068";
		
			
		}else{
			
		}
		
		String content = "";
		String subject = "";
		String sms_content ="";
		String approveType = "";
		
		
		DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
		String subject_str = subject_str_fm.format(today);

		String[] emailListEM = new String[3];
		emailListEM[0] ="thilankawanninayake@gmail.com";
		emailListEM[1] ="gchampika28@gmail.com";
		emailListEM[2] ="shihranaleer@gmail.com";
	    content = "\nMeter Testing Order Card("+emailId+") is sent by Electrical Engineer. You can view that by login into  https://mms.ceb.lk/MMS/WelcomeEM \n\nThank You";
		subject = "METER TESTING ORDER CARD("+emailId+")" + subject_str;
		sms_content ="\nThe Meter testing order card("+emailId+") is sent by Electrical Engineer. You can view that by login into  https://mms.ceb.lk/MMS/WelcomeEM";
		

        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");

		try {
			mm.sendMailTo("Electrical Superintendent", content ,email,emailListEM,subject,null,null,null,null,null,null);
			//mm.sendMailTo("Electrical Superintendent", content ,"gchampika28@gmail.com",subject,null,null,null,null,null,null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("sendSMS 2" );
		String url="http://smsgw.ceb/SMSPlatform.php?recipients="+telNo+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		//String url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		try {
			restTemplate.getForObject(url, String.class);
			
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("sendSMS 4" );

		
		
*/		
		
		
		
		
		
	}

	
	
	@RequestMapping(value = "/complete/{emailId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void sendMeterRequestToES(HttpServletRequest request,@PathVariable("emailId") String emailId) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		ApprovalMm obj = approvalMm.findByID(emailId);
		obj.setToStatus("15");
		Date date = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		String timeString = "";
		Date date2 = null;
		try {
			String dateString1 = format1.format(date);
			date2 = format1.parse (dateString1);
			System.out.println("forwarded date :" + date2);
			
			timeString = format2.format(date);
			System.out.println("forwarded time :" + timeString);
			

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    

		obj.setActionDate(date2);
		obj.setActionTime(timeString);
		
		
		System.out.println("sendRequestToES 1:" );
		
		approvalMm.update(obj);
		System.out.println("sendRequestToES 2:" );
		
		String email="";
		String telNo="";
		String es = "";
		if(obj != null){
			es = obj.getEs().trim();
			if(es.equals("49060ES1")){
				email ="ruwanrkeng@yahoo.com";
				telNo ="0711022350";
			}else if(es.equals("49060ES2")){
				email ="rmswritigala@gmail.com";
				telNo ="0714960386";
			
			}
			else if(es.equals("49060ES3")){
				email ="asanka.dkalu@gmail.com";
				telNo ="0715340068";
			
				
			}else{
				email ="gchampika28@gmail.com";
				telNo ="0714537313";
			
			}
			
		}
		
		String content = "";
		String subject = "";
		String sms_content ="";
		String approveType = "";
		
		
		DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
		String subject_str = subject_str_fm.format(today);

		String[] emailListEM = new String[3];
		emailListEM[0] ="thilankawanninayake@gmail.com";
		emailListEM[1] ="gchampika28@gmail.com";
		emailListEM[2] =email;
	    content = "\nMeter Testing Order Card("+emailId+") was attended by "+es+" . You can view that by login into  https://mms.ceb.lk/MMS/WelcomeEM \n\nThank You";
		subject = "ATTENDED METER TESTING ORDER CARD("+emailId+")" + subject_str;
		sms_content ="\nThe Meter testing order card("+emailId+") was attended by "+es+". You can view that by login into  https://mms.ceb.lk/MMS/WelcomeEM";
		
		String urlCE="http://smsgw.ceb/SMSPlatform.php?recipients=0718898892&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlEE="http://smsgw.ceb/SMSPlatform.php?recipients=713529368&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");

		try {
			mm.sendMailTo("Electrical Engineer", content ,"shihranaleer@gmail.com",emailListEM,subject,null,null,null,null,null,null);
			//mm.sendMailTo("Electrical Superintendent", content ,"gchampika28@gmail.com",subject,null,null,null,null,null,null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("sendSMS 2" );
		String url="http://smsgw.ceb/SMSPlatform.php?recipients="+telNo+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		//String url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		try {
			restTemplate.getForObject(url, String.class);
			restTemplate.getForObject(urlEE, String.class);
			restTemplate.getForObject(urlCE, String.class);
			
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("sendSMS 4" );

		
		
		
		
		
		
		
		
	}

	
	
	@RequestMapping(value = "/sendRequestToArea/{emailId}/{es}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void sendRequestToArea(HttpServletRequest request,@PathVariable("emailId") String emailId,
			@PathVariable("es") String es) {
		System.out.println("sendRequestToES :hhhhh"  + es);
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("sendRequestToES :" + deptId );
		
		ApprovalMm obj = approvalMm.findByID(emailId);
		//obj.setApprovedBy(es);
		obj.setToStatus("95");
		obj.setFromStatus(es);
		Date date = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		String timeString = "";
		Date date2 = null;
		try {
			String dateString1 = format1.format(date);
			date2 = format1.parse (dateString1);
			System.out.println("forwarded date :" + date2);
			
			timeString = format2.format(date);
			System.out.println("forwarded time :" + timeString);
			

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    

		obj.setForwardDate(date2);
		obj.setForwardedTime(timeString);
		
		
		System.out.println("sendRequestToES 1:" );
		
		approvalMm.update(obj);
		System.out.println("sendRequestToES 2:" );
		
		String content = "";
		String subject = "";
		String sms_content ="";
		String approveType = "";
		
		String content_success = "";
		String subject_success = "";
		String sms_content_success ="";
		String approveType_success = "";
		
		
		DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
					String subject_str = subject_str_fm.format(today);

		
	    String areaName = obj.getReferenceNo();
		//areaName = areaName.toLowerCase();
		content = "\nInterruption request is sent by PHM branch in "+areaName+". You can view that by login into  https://mms.ceb.lk";
		subject = "Interruption request for "+areaName + " " + obj.getWorkingDate();
		sms_content ="Interruption request is sent by PHM branch in "+areaName+". You can view that by login into  https://mms.ceb.lk";
		approveType = "INTREQ";
		
		content_success = "\nInterruption request is successfully sent to "+areaName;
		subject_success = "Interruption request for "+areaName + " " + obj.getWorkingDate();
		sms_content_success ="Interruption request is successfully sent to "+areaName;
		
		
		String email="";
		String telNo="";
		
		String emaildgm="";
		String telNodgm="";
		String area = obj.getAreaCode().trim();
		area = area.trim();
		System.out.println("area" +area+ "test");
		
		email = Util.searchEmail(area.trim());
		telNo = Util.searchTelNo(area.trim());
		
		String compId = gldeptDao.getDD(area);
		String province = glcompmDao.getProvince(compId);
		String pdceemail = "";
		String pdce2email = "";
		String telNopdcee = "";
		String cephm="";
		String eephm="";
		
		String dmtel ="";
		String dmemail ="";
		String dear = "";
		System.out.println("province" +province+ "test");
		province = province.trim();
		if(province.equalsIgnoreCase("CP")){
			System.out.println("provinceCP" +province+ "test");
			cephm="";
			pdceemail = "cepdcp.dd2@ceb.lk";
			//pdce2email = "nakumari@gmail.com";
			telNopdcee = "0714520624";
			dmtel = "0719387070";
			dmemail="amiladananjaya@gmail.com";
			dear ="Chief Engineer";
		}else if(province.equalsIgnoreCase("CP2")){
			System.out.println("provinceCP" +province+ "test");
			cephm="";
			pdceemail = "cepdcp.dd2@ceb.lk";
			//pdce2email = "nakumari@gmail.com";
			telNopdcee = "0714520624";
			dmtel = "0719387070";
			dmemail="amiladananjaya@gmail.com";
			dear ="Chief Engineer";
		}else if(province.equalsIgnoreCase("WPN")){
			System.out.println("provinceWPN" +province+ "test");
			pdceemail = "cepdwpn.dd2@ceb.lk";
			//cppdce2email = "nakumari@gmail.com";
			telNopdcee = "0714066301";
			dmtel = "0718692150";
			dmemail="eeowpn@gmail.com";
			dear ="Chief Engineer";
		}else if(province.equalsIgnoreCase("EP")){
			System.out.println("provinceEP" +province+ "test");
			
			pdceemail = "Ofcceplnep.dd2@ceb.lk";
			//pdce2email = "fedrena@hotmail.com";
			telNopdcee = "0714527831";
			dmtel = "0714527831";
			dmemail="eedevep.dd2@ceb.lk";
			dear ="Chief Engineer";
		}else if(province.equalsIgnoreCase("WPSII")){
			System.out.println("provinceEP" +province+ "test");
			
			pdceemail = "cepndwps2.dd3@ceb.lk";
			//pdce2email = "";
			telNopdcee = "0714297792";
			dmtel = "0716867844";
			dmemail="eedccccwps2.dd3@ceb.lk";
			dear ="Chief Engineer";
		}else if(province.equalsIgnoreCase("UVAP")){
			System.out.println("provinceEP" +province+ "test");
			
			pdceemail = "ee1dmuva.dd3@ceb.lk";
			//pdce2email = "fedrena@hotmail.com";
			telNopdcee = "0714297727";
			dmtel = "0706990331";
			dmemail="eecontcentuva.dd3@ceb.lk";
			dear ="Chief Engineer";
		}else if(province.equalsIgnoreCase("SABP")){
			System.out.println("provinceEP" +province+ "test");
			
			pdceemail = "cepdsbp.dd3@ceb.lk";
			//pdce2email = "fedrena@hotmail.com";
			telNopdcee = "0716969933";
			dmtel = "0716983444";
			dmemail="eeplnsbp.dd3@ceb.lk";
			dear ="Chief Engineer";
		}else{
			
		}

		String emailCE = "";
		String telNoCE = "";
		
		if(deptId.equalsIgnoreCase("600.41")){
			emailCE = Util.cephmcp;
			telNoCE = Util.telcephmcp;
		}else if(deptId.equalsIgnoreCase("600.42")){
			emailCE = Util.cephmcpsub;
			telNoCE = Util.telcephmcpsub;
		}else if(deptId.equalsIgnoreCase("780.00")){
			emailCE = Util.cephmdd3;
			telNoCE = Util.telcephmdd3;
		}else{
			emailCE = "gchampika28@gmail.com";
			telNoCE = "0714537313";
		}

        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");
		//mm.sendMail("Mr. Eranga", "Maintenance data is approved in area " + area);
		//mm.sendMailTo("", content ,"eranga.bogahakumbura@gmail.com ",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4);
		
		//mm.sendMailTo("PHM DD2", content ,"gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
		//Util.trustEveryone();
		Util objUtil = null;
		
		String[] emailListArea = new String[5];
		ArrayList<String> emailListSuccess = new ArrayList<String>();
		
		try {
			System.out.println("2000000 rrr " + email);
			
			//mm.sendMailTo(areaName, content ,email,subject);
			//mm.sendMailTo(areaName, content ,"gchampika28@gmail.com",subject);
			System.out.println("2000000 " );
			
			//mm.sendMailTo(dear, content ,pdceemail,subject);
			emailListArea[0] =pdceemail;
			System.out.println("2000001 " );
			
			//mm.sendMailTo(dear, content ,pdce2email,subject);
			System.out.println("2000002 " );
			
			
			//mm.sendMailTo(dear, content ,dmemail,subject);
			emailListArea[1] = dmemail;
			
			//emailListArea[2] ="eranga.bogahakumbura@gmail.com";
			emailListArea[2] =getEmail(obj.getEe());
			emailListArea[3] =emailCE;
			//emailListArea[5] ="gchampika28@gmail.com";
			emailListArea[4] =email;
			//emailListArea[5] ="gchampika28@gmail.com";
			
			
			String path = PathMMS.getReportPath() + File.separator + "Reports";
			File file = new File(path + "/"+emailId+".pdf" );

			/*if(file != null){
				mm.sendMailTo(areaName, content ,getEmail(obj.getEe()),emailListArea,"Testing",null,null,null,null,null,file);
			}
			*/
			if(obj.getFromStatus().equalsIgnoreCase("1")){
				if(file != null){
					mm.sendMailTo(areaName, content ,email,emailListArea,subject,null,null,null,null,null,file);
				}
				else{
					mm.sendMailTo(areaName, content ,email,emailListArea,subject);
				}
			}else if(obj.getFromStatus().equalsIgnoreCase("2")){
				if(file != null){
					mm.sendMailTo(dear, content ,pdceemail,emailListArea,subject,null,null,null,null,null,file);
					
				}else{
					mm.sendMailTo(dear, content ,pdceemail,emailListArea,subject);
					
				}
			}else{
				if(file != null){
					mm.sendMailTo(dear, content ,dmemail,emailListArea,subject,null,null,null,null,null,file);
					
				}else{
				
				    mm.sendMailTo(dear, content ,dmemail,emailListArea,subject);
				}
			}
			System.out.println("2000003 " );
			
			//mm.sendMailTo(dear, content_success ,getEmail(obj.getEe()),subject);
			
			//mm.sendMailTo(dear, content_success ,Util.eephmcp1,subject);
			//mm.sendMailTo(dear, content_success ,"gchampika28@gmail.com",subject);
			
			//mm.sendMailTo(dear, content_success ,Util.cephmcp,subject);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("finish 1 " );
		//Date date = new Date();
		
		
		
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("sendSMS 2" );

		//String url="http://smsgw.ceb/SMSPlatform.php?recipients=0718716913&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		
		String url="http://smsgw.ceb/SMSPlatform.php?recipients="+getTelNo(obj.getEe())+"&smsbody="+sms_content_success+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlCE="http://smsgw.ceb/SMSPlatform.php?recipients="+telNoCE+"&smsbody="+sms_content_success+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		String urlEE="http://smsgw.ceb/SMSPlatform.php?recipients="+telNo+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		String urlCEPD="http://smsgw.ceb/SMSPlatform.php?recipients="+telNopdcee+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlDM="http://smsgw.ceb/SMSPlatform.php?recipients="+dmtel+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		
		System.out.println("sendSMS 3");

		try {
			//Util.trustEveryone();
			
			restTemplate.getForObject(url, String.class);
			
			restTemplate.getForObject(urlEE, String.class);
			restTemplate.getForObject(urlCEPD, String.class);
			restTemplate.getForObject(urlDM, String.class);
			restTemplate.getForObject(urlCE, String.class);
			
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("sendSMS 4" );

	}
	
	
	
	
	@RequestMapping(value = "/sendNotificationTrriping", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void sendNotificationTrriping(HttpServletRequest request,@RequestParam("province") String province) {
		System.out.println("sendNotificationTrriping");
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		String content = "";
		String subject = "";
		String sms_content ="";
		String approveType = "";
		
		DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
					String subject_str = subject_str_fm.format(today);

	    //areaName = areaName.toLowerCase();
		content = "\nHere with I have attached the “Feeder Tripping Report”.";
		subject = "Feeder Tripping Summary Report " + subject_str;
		sms_content ="Feeder Tripping Report is sent by control center engineer.You can view that by login into  https://mms.ceb.lk";
		
		String email="";
		String telNo="";
		
		String emaildgm="";
		String telNodgm="";
		String pdceemail = "";
		String pdce2email = "";
		String telNopdcee = "";
		String dmtel ="";
		String dmemail ="";
		String dear = ""; 
		String emailphmee ="";
		String emailphmce ="";
		if(province.equalsIgnoreCase("CP")){
			emailphmee ="eranga.bogahakumbura@gmail.com";
			String telNophmee ="0718716913";
					
			emailphmce ="mnmnihaj@gmail.com";
			String telNophmce ="0714565970";
            dear ="Cheif Engineer / Maintenance Engineer PHM";
		}else if(province.equalsIgnoreCase("CP2")){
			emailphmee ="eranga.bogahakumbura@gmail.com";
			String telNophmee ="0718716913";
					
			emailphmce ="mnmnihaj@gmail.com";
			String telNophmce ="0714565970";
            dear ="Cheif Engineer / Maintenance Engineer PHM";
		}else if(province.equalsIgnoreCase("WPN")){
			
		}else if(province.equalsIgnoreCase("EP")){
		}else{
			
		}
		
		
		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
		String pdfPath ="";
		String pdfName = "";
		Connection conn = null;
		File pdfFile =null;
		try {
			
			try {
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				conn = jasperDao.getConnection();
				File file = new File(path1 + "/" + "TRIPPING_SUM" + ".jrxml" );
			        
			        if(!file.exists())
			            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

			    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "TRIPPING_SUM" + ".jrxml");
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
 				JRPdfExporter pdf = new JRPdfExporter();

				Calendar calendar = Calendar.getInstance();
				 
				pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
				
				pdfPath = "FEEDER FAILURE REPORT.pdf";
				
				pdfFile = new File(path2 + File.separator + pdfPath);
				System.out.println("pdfPath" +pdfPath );
				pdf.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
			    pdf.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, path2 + File.separator + pdfPath);
			    pdf.exportReport();

				
				} catch (Exception ex) {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose"+ ex);
				throw new Exception("Database Connection Error !!");
			} finally {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose");
				if(conn!=null){
					conn.close();
				}
	            System.out.println("Joboxxxxxxxxx conn.close() tttttttttttttttttt;xxxxx dclose");
	        }
			


		} catch (Exception e) {
			e.printStackTrace();


		}

		
		
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");
		/*mm.sendMailTo(dear, content ,pdceemail,subject);
		mm.sendMailTo(dear, content ,pdce2email,subject);
		mm.sendMailTo(dear, content ,dmemail,subject);
		
		*/
		//Util.trustEveryone();
		mm.sendMailTo(dear, content ,emailphmee,emailphmce,subject,null,null,null,null,null,pdfFile);
		
		
		System.out.println("finish 1 " );
		//Date date = new Date();
		
		
		
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("sendSMS 2" );

		//String url="http://smsgw.ceb/SMSPlatform.php?recipients=0718716913&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		
		/*String url="http://smsgw.ceb/SMSPlatform.php?recipients=0718716913&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlEE="http://smsgw.ceb/SMSPlatform.php?recipients="+telNo+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		String urlCEPD="http://smsgw.ceb/SMSPlatform.php?recipients="+telNopdcee+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlDM="http://smsgw.ceb/SMSPlatform.php?recipients="+dmtel+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		
		System.out.println("sendSMS 3" );

		try {
			restTemplate.getForObject(url, String.class);
			
			restTemplate.getForObject(urlEE, String.class);
			restTemplate.getForObject(urlCEPD, String.class);
			restTemplate.getForObject(urlDM, String.class);
			
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		System.out.println("sendSMS 4" );

	}

	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/sendIntReqSumReportArea", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void sendIntReqSumReportArea(HttpServletResponse response,HttpServletRequest request,@RequestParam("area") String area,@RequestParam("from") String from,@RequestParam("to") String to) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		
		String userName =(String)request.getSession().getAttribute("loggedUser");

		System.out.println("area : "+area);
		System.out.println("from : "+from);
		System.out.println("to : "+to);
		
        List<String> strList = new LinkedList<String>();
		String sss = "";
		String[] stringList = area.split(",");
		System.out.println("oooooooooo stringList"+stringList);
		
		for (String value : stringList) {
			strList.add(value);
			sss +="'"+value+"',";
		}
		sss = sss.substring(0, sss.length()-1);
		
		System.out.println("oooooooooo stringList2"+sss);
		
		System.out.println("oooooooooo stringList1"+strList);
		
		System.out.println("sss"+sss);
		
		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
		String pdfPath ="";
		String pdfName = "";
		Connection conn = null;
		File pdfFile =null;
		try {
			
			try {
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				conn = jasperDao.getConnection();
				hmParams.put("@area", ""+sss+"");
				hmParams.put("@fromDate", "'"+from+"'");
				hmParams.put("@toDate", "'"+to+"'");
				hmParams.put("@ee", "'"+userName.trim()+"'");

				File file = new File(path1 + "/" + "INT_REQ_SUM_AREA" + ".jrxml" );
			        
			        if(!file.exists())
			            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

			    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "INT_REQ_SUM_AREA" + ".jrxml");
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
 				JRPdfExporter pdf = new JRPdfExporter();

				Calendar calendar = Calendar.getInstance();
				 
				pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
				
				pdfPath = path2 + "/INTERRUPTION REQUEST SUMMARY-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ ".pdf";
						
				pdfPath = "INTERRUPTION REQUEST SUMMARY-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ ".pdf";
				
				pdfFile = new File(path2 + File.separator + pdfPath);
				System.out.println("pdfPath" +pdfPath );
				pdf.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
			    pdf.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, path2 + File.separator + pdfPath);
			    pdf.exportReport();

				
				} catch (Exception ex) {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose"+ ex);
				throw new Exception("Database Connection Error !!");
			} finally {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose");
				if(conn!=null){
					conn.close();
				}
	            System.out.println("Joboxxxxxxxxx conn.close() tttttttttttttttttt;xxxxx dclose");
	        }
			


		} catch (Exception e) {
			e.printStackTrace();


		}
		DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
		String subject_str = subject_str_fm.format(today);


		String content = "Interruption Request Summary Report is sent by PHM branch.You can view that by login into https://mms.ceb.lk";
		String subject = "Interruption Request Summary Report " + subject_str;
		String sms_content ="Interruption Request Summary Report is sent by PHM branch.You can view that by login into https://mms.ceb.lk";
		
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");
		
		for (String value : stringList) {
			
			String areaname = gldeptDao.getName(value);
			String success_content = "Interruption Request Summary Report of "+areaname+" is forwarded.";
			String success_subject = "Interruption Request Summary Reports of "+areaname+" - " + subject_str;
			String success_sms_content ="Interruption Request Summary Report of "+areaname+" is forwarded.";
			//Phm engineer
			//mm.sendMailTo("Engineer", success_content ,getEmail(userName),"alagodas1@gmail.com",success_subject,null,null,null,null,null,pdfFile);
			//mm.sendMailTo("Engineer", success_content ,"gchampika28@gmail.com","gchampika28@gmail.com",success_subject,null,null,null,null,null,pdfFile);
			
			//String urlEE="http://smsgw.ceb/SMSPlatform.php?recipients="+Util.searchTelNo(value)+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			String urlEE="http://smsgw.ceb/SMSPlatform.php?recipients="+getTelNo(userName)+"&smsbody="+success_sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			String urlCE="http://smsgw.ceb/SMSPlatform.php?recipients="+Util.telcephmcp+"&smsbody="+success_sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			String urlAE="http://smsgw.ceb/SMSPlatform.php?recipients="+Util.searchTelNo(value)+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			
			String compId = gldeptDao.getDD(value);
			String province = glcompmDao.getProvince(compId);
			String pdceemail = "";
			String pdce2email = "";
			String telNopdcee = "";
			String dmtel ="";
			String dmemail ="";
			String dear = "";
			System.out.println("province" +province+ "test");
			province = province.trim();
			if(province.equalsIgnoreCase("CP")){
				System.out.println("provinceCP" +province+ "test");
				pdceemail = "cepdcp.dd2@ceb.lk";
				//pdce2email = "nakumari@gmail.com";
				telNopdcee = "0714520624";
				dmtel = "0719387070";
				dmemail="amiladananjaya@gmail.com";
				dear ="Chief Engineer";
			}else if(province.equalsIgnoreCase("CP2")){
				System.out.println("provinceCP" +province+ "test");
				pdceemail = "cepdcp.dd2@ceb.lk";
				//pdce2email = "nakumari@gmail.com";
				telNopdcee = "0714520624";
				dmtel = "0719387070";
				dmemail="amiladananjaya@gmail.com";
				dear ="Chief Engineer";
			}else if(province.equalsIgnoreCase("WPN")){
				System.out.println("provinceWPN" +province+ "test");
				pdceemail = "cepdwpn.dd2@ceb.lk";
				//cppdce2email = "nakumari@gmail.com";
				telNopdcee = "0714066301";
				dmtel = "0718692150";
				dmemail="eeowpn@gmail.com";
				dear ="Chief Engineer";
			}else if(province.equalsIgnoreCase("EP")){
				System.out.println("provinceEP" +province+ "test");
				
				pdceemail = "Ofcceplnep.dd2@ceb.lk";
				//pdce2email = "fedrena@hotmail.com";
				telNopdcee = "0714527831";
				dmtel = "0714527831";
				dmemail="eedevep.dd2@ceb.lk";
				dear ="Chief Engineer";
			}else{
				
			}
			
			
			String[] emailListArea = new String[4];
			emailListArea[0] = getEmail(userName);
			emailListArea[1] = Util.cephmcp;
			emailListArea[2] =pdceemail;
			emailListArea[3] = dmemail;
			//emailListArea[4] ="eranga.bogahakumbura@gmail.com";
			//emailListArea[5] ="gchampika28@gmail.com";
			//emailListArea[6] ="mgrisd@ceb.lk";
			
			
			
			//area engineer
			mm.sendMailTo(areaname, content ,Util.searchEmail(value),emailListArea,subject,null,null,null,null,null,pdfFile);
			
			
			
			
			
			
			
			
			

			//mm.sendMailTo(dear, content ,pdceemail,"eranga.bogahakumbura@gmail.com",subject,null,null,null,null,null,pdfFile);
			//mm.sendMailTo(dear, content ,dmemail,"eranga.bogahakumbura@gmail.com",subject,null,null,null,null,null,pdfFile);
			//mm.sendMailTo(dear, content ,"gchampika28@gmail.com","gchampika28@gmail.com",subject,null,null,null,null,null,pdfFile);
			
			
			String urlCEPD="http://smsgw.ceb/SMSPlatform.php?recipients="+telNopdcee+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			String urlDM="http://smsgw.ceb/SMSPlatform.php?recipients="+dmtel+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			
			RestTemplate restTemplate = new RestTemplate();
			
			try {
				//Util.trustEveryone();
				
				restTemplate.getForObject(urlEE, String.class);
				restTemplate.getForObject(urlCEPD, String.class);
				restTemplate.getForObject(urlDM, String.class);
				restTemplate.getForObject(urlCE, String.class);
				restTemplate.getForObject(urlAE, String.class);
				
				
			} catch (RestClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
		
	}
	
	
	
	
	@RequestMapping(value = "/sendIntReqSumReportPhm", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void sendIntReqSumReportPhm(HttpServletResponse response,HttpServletRequest request,@RequestParam("area") String area,@RequestParam("from") String from,@RequestParam("to") String to) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		
		String userName =(String)request.getSession().getAttribute("loggedUser");

		System.out.println("area : "+area);
		System.out.println("from : "+from);
		System.out.println("to : "+to);
		
        List<String> strList = new LinkedList<String>();
		String sss = "";
		String[] stringList = area.split(",");
		System.out.println("oooooooooo stringList"+stringList);
		
		for (String value : stringList) {
			strList.add(value);
			sss +="'"+value+"',";
		}
		sss = sss.substring(0, sss.length()-1);
		
		System.out.println("oooooooooo stringList2"+sss);
		
		System.out.println("oooooooooo stringList1"+strList);
		
		System.out.println("sss"+sss);
		
		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
		String pdfPath ="";
		String pdfName = "";
		Connection conn = null;
		File pdfFile =null;
		try {
			
			try {
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				conn = jasperDao.getConnection();
				hmParams.put("@area", ""+sss+"");
				hmParams.put("@fromDate", "'"+from+"'");
				hmParams.put("@toDate", "'"+to+"'");
				hmParams.put("@ee", "'"+userName.trim()+"'");

				File file = new File(path1 + "/" + "INT_REQ_SUM_CCR" + ".jrxml" );
			        
			        if(!file.exists())
			            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

			    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "INT_REQ_SUM_CCR" + ".jrxml");
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
 				JRPdfExporter pdf = new JRPdfExporter();

				Calendar calendar = Calendar.getInstance();
				 
				pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
				
				pdfPath = path2 + "/INTERRUPTION REQUEST SUMMARY-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ ".pdf";
						
				pdfPath = "INTERRUPTION REQUEST SUMMARY-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ ".pdf";
				
				pdfFile = new File(path2 + File.separator + pdfPath);
				System.out.println("pdfPath" +pdfPath );
				pdf.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
			    pdf.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, path2 + File.separator + pdfPath);
			    pdf.exportReport();

				
				} catch (Exception ex) {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose"+ ex);
				throw new Exception("Database Connection Error !!");
			} finally {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose");
				if(conn!=null){
					conn.close();
				}
	            System.out.println("Joboxxxxxxxxx conn.close() tttttttttttttttttt;xxxxx dclose");
	        }
			


		} catch (Exception e) {
			e.printStackTrace();


		}
		DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
		String subject_str = subject_str_fm.format(today);


		String content = "\nInterruption Request Summary Report is sent by Control Center.You can view that by login into https://mms.ceb.lk\n\nThank You";
		String subject = "Interruption Request Summary Report " + subject_str;
		String sms_content ="Interruption Request Summary Report is sent by Control Center.You can view that by login into https://mms.ceb.lk";
		
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");
		
		for (String value : stringList) {
			
			String areaname = gldeptDao.getName(value);
			String success_content = "Interruption Request Summary Report of "+areaname+" is forwarded.";
			String success_subject = "Interruption Request Summary Reports of "+areaname+" - " + subject_str;
			String success_sms_content ="Interruption Request Summary Report of "+areaname+" is forwarded.";
			//Phm engineer
			//mm.sendMailTo("Engineer", success_content ,getEmail(userName),"alagodas1@gmail.com",success_subject,null,null,null,null,null,pdfFile);
			//mm.sendMailTo("Engineer", success_content ,"gchampika28@gmail.com","gchampika28@gmail.com",success_subject,null,null,null,null,null,pdfFile);
			
			//String urlEE="http://smsgw.ceb/SMSPlatform.php?recipients="+Util.searchTelNo(value)+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			String urlEE="http://smsgw.ceb/SMSPlatform.php?recipients="+getTelNo(userName)+"&smsbody="+success_sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			String urlCE="http://smsgw.ceb/SMSPlatform.php?recipients="+Util.telcephmcp+"&smsbody="+success_sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			String urlAE="http://smsgw.ceb/SMSPlatform.php?recipients="+Util.searchTelNo(value)+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			
			String compId = gldeptDao.getDD(value);
			String province = glcompmDao.getProvince(compId);
			String pdceemail = "";
			String pdce2email = "";
			String telNopdcee = "";
			String dmtel ="";
			String dmemail ="";
			String dear = "";
			System.out.println("province" +province+ "test");
			province = province.trim();
			if(province.equalsIgnoreCase("CP")){
				System.out.println("provinceCP" +province+ "test");
				pdceemail = "cepdcp.dd2@ceb.lk";
				//pdce2email = "nakumari@gmail.com";
				telNopdcee = "0714520624";
				dmtel = "0719387070";
				dmemail="amiladananjaya@gmail.com";
				dear ="Chief Engineer";
			}else if(province.equalsIgnoreCase("CP2")){
				System.out.println("provinceCP" +province+ "test");
				pdceemail = "cepdcp.dd2@ceb.lk";
				//pdce2email = "nakumari@gmail.com";
				telNopdcee = "0714520624";
				dmtel = "0719387070";
				dmemail="amiladananjaya@gmail.com";
				dear ="Chief Engineer";
			}else if(province.equalsIgnoreCase("WPN")){
				System.out.println("provinceWPN" +province+ "test");
				pdceemail = "cepdwpn.dd2@ceb.lk";
				//cppdce2email = "nakumari@gmail.com";
				telNopdcee = "0714066301";
				dmtel = "0718692150";
				dmemail="eeowpn@gmail.com";
				dear ="Chief Engineer";
			}else if(province.equalsIgnoreCase("EP")){
				System.out.println("provinceEP" +province+ "test");
				pdceemail = "Ofcceplnep.dd2@ceb.lk";
				//pdce2email = "fedrena@hotmail.com";
				telNopdcee = "0714527831";
				dmtel = "0714527831";
				dmemail="eedevep.dd2@ceb.lk";
				dear ="Chief Engineer";
			}else{
				
			}
			
			
			String[] emailListArea = new String[4];
			emailListArea[0] = getEmail(userName);
			emailListArea[1] = Util.cephmcp;
			emailListArea[2] =pdceemail;
			emailListArea[3] = dmemail;
			//emailListArea[4] ="eranga.bogahakumbura@gmail.com";
			//emailListArea[5] ="gchampika28@gmail.com";
			//emailListArea[6] ="mgrisd@ceb.lk";
			
			
			
			//area engineer
			mm.sendMailTo("All", content ,Util.searchEmail(value),emailListArea,subject,null,null,null,null,null,pdfFile);
			
			
			
			
			
			
			
			
			

			//mm.sendMailTo(dear, content ,pdceemail,"eranga.bogahakumbura@gmail.com",subject,null,null,null,null,null,pdfFile);
			//mm.sendMailTo(dear, content ,dmemail,"eranga.bogahakumbura@gmail.com",subject,null,null,null,null,null,pdfFile);
			//mm.sendMailTo(dear, content ,"gchampika28@gmail.com","gchampika28@gmail.com",subject,null,null,null,null,null,pdfFile);
			
			
			String urlCEPD="http://smsgw.ceb/SMSPlatform.php?recipients="+telNopdcee+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			String urlDM="http://smsgw.ceb/SMSPlatform.php?recipients="+dmtel+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			
			RestTemplate restTemplate = new RestTemplate();
			
			try {
				//Util.trustEveryone();
				
				restTemplate.getForObject(urlEE, String.class);
				restTemplate.getForObject(urlCEPD, String.class);
				restTemplate.getForObject(urlDM, String.class);
				restTemplate.getForObject(urlCE, String.class);
				restTemplate.getForObject(urlAE, String.class);
				
				
			} catch (RestClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/removeRequest/{emailId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void removeRequest(HttpServletRequest request,@PathVariable("emailId") String emailId) {
		System.out.println("removeRequest :hhhhh" + emailId);
		
		ApprovalMm obj = approvalMm.findByID(emailId);
		obj.setToStatus("20");
		approvalMm.update(obj);
		
	}

	@RequestMapping(value = "/updateIntteruption", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateIntteruption(HttpServletRequest request,@RequestParam("id") String id,@RequestParam("csc") String csc,@RequestParam("grid") String grid,@RequestParam("altsup") String altsup,@RequestParam("remarks") String remarks,@RequestParam("announcement") String announcement,@RequestParam("incharge") String incharge,@RequestParam("cycle") String cycle,@RequestParam("action") String action) {
		System.out.println("sendRequestToES :hhhhh" );
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("sendRequestToES :" + deptId );
		
		
        ApprovalMm obj = approvalMm.findByID(id);
      //  csc.replaceAll("and", "\\&");
        obj.setCsc(csc);
      //  grid.replaceAll("and", "\\&");
        
        obj.setGrid(grid);
      //  altsup.replaceAll("and", "\\&");
        
        obj.setAltSupArrangement(altsup);
     //   remarks.replaceAll("and", "\\&");
        
        obj.setRemarks(remarks);
        obj.setAnnouncement(announcement);
        //obj.setCcApprovalUser(incharge);
        obj.setIntCycle(cycle);
        if(action.equalsIgnoreCase("4")){
        	
        }else{
        	obj.setToStatus("77");
        }
        approvalMm.update(obj);

	}
	
	
	@RequestMapping(value = "/sendForIntteruption", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void sendForIntteruption(HttpServletRequest request,@RequestParam("id") String id,@RequestParam("csc") String csc,@RequestParam("grid") String grid,@RequestParam("altsup") String altsup,@RequestParam("remarks") String remarks,@RequestParam("announcement") String announcement,@RequestParam("incharge") String incharge,@RequestParam("cycle") String cycle,@RequestParam("action") String action) {
		System.out.println("sendRequestToES :hhhhh" );
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		
		System.out.println("sendRequestToES :" + deptId );
		
		
		
		
        ApprovalMm obj = approvalMm.findByID(id);
        obj.setCsc(csc);
        obj.setGrid(grid);
        obj.setAltSupArrangement(altsup);
        obj.setRemarks(remarks);
        obj.setAnnouncement(announcement);
        obj.setCcApprovalUser(incharge);
        System.out.println("userLevel.equalsIgnoreCase() :" + userLevel.equalsIgnoreCase("DEO") );
		
        if(userLevel.equalsIgnoreCase("DEO")){
        	obj.setToStatus("21");
        }else if(userLevel.equalsIgnoreCase("ES")){
        	obj.setToStatus("31");
        }else if(userLevel.equalsIgnoreCase("EEC") || userLevel.equalsIgnoreCase("EE") || userLevel.equalsIgnoreCase("PE")){
        	obj.setToStatus("41");
        }else if(userLevel.equalsIgnoreCase("PCE") || userLevel.equalsIgnoreCase("CE")){
        	obj.setToStatus("51");
        }else if(userLevel.equalsIgnoreCase("DGM")){
        	obj.setToStatus("61");
        }
        //obj.setToStatus("86");
        obj.setIntCycle(cycle);
        if(action.equalsIgnoreCase("4")){
        	
        }else{
        	obj.setToStatus("77");
        }
        
        
        
        approvalMm.update(obj);
        /*String userName =(String)request.getSession().getAttribute("loggedUser");
		//String userLevel =(String)request.getSession().getAttribute("loggedUser");
		
		String status = "";
		if(userLevel.equalsIgnoreCase("ES")){
			status ="31";
        }else if(userLevel.equalsIgnoreCase("EEC") || userLevel.equalsIgnoreCase("EE") || userLevel.equalsIgnoreCase("PE")){
        	status ="41";
        }else if(userLevel.equalsIgnoreCase("PCE") || userLevel.equalsIgnoreCase("CE")){
        	status ="51";
        }else if(userLevel.equalsIgnoreCase("DGM")){
        	status ="61";
        }
        
		if(userLevel.equalsIgnoreCase("EEC") || userLevel.equalsIgnoreCase("EE") || userLevel.equalsIgnoreCase("PE") ||userLevel.equalsIgnoreCase("PCE") || userLevel.equalsIgnoreCase("CE") || userLevel.equalsIgnoreCase("DGM")){
	        
		
        List<String> strList = new LinkedList<String>();
		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
		String pdfPath ="";
		String pdfName = "";
		Connection conn = null;
		File pdfFile = null;
		
		try {
			
			try {
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				conn = jasperDao.getConnection();
				
				System.out.println(status+"/"+userName+"/"+cycle);
				hmParams.put("@status", "'"+status+"'");
				hmParams.put("@user", "'DGMCP'");
				hmParams.put("@cycle", "'"+cycle.trim()+"'");
				
				
				File file = new File(path1 + "/" + "INT_REQ_SUM_CCR_FINAL" + ".jrxml" );
			        
			        if(!file.exists())
			            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

			    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "INT_REQ_SUM_CCR_FINAL" + ".jrxml");
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
 				JRPdfExporter pdf = new JRPdfExporter();

				Calendar calendar = Calendar.getInstance();
				 
				pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
				
				pdfPath = path2 + "/INTERRUPTION REQUEST SUMMARY-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ ".pdf";
						
				pdfPath = "Recommended Interruption Schedule - " + cycle+ ".pdf";
				
				pdfFile = new File(path2 + File.separator + pdfPath);
				System.out.println("pdfPath" +pdfPath );
				pdf.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
			    pdf.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, path2 + File.separator + pdfPath);
			    pdf.exportReport();

				
				if (pdfFile.exists())
		        {
		            try {
		            	response.setContentType("application/pdf");
		            	//response.addHeader("Content-Disposition", "attachment; filename="+pdfPath);
		                 
		            	InputStream inputStream = new FileInputStream(new File( path2 + File.separator + pdfPath)); //load the file
						IOUtils.copy(inputStream, response.getOutputStream());
						response.flushBuffer();
						System.out.println("pdfPath" +pdfPath );
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	
		        	

		        }

				

				System.out.println("Joboxxxxxxxxxxxxxxxxxxxxxxxxxxxx dclose");

				 

			} catch (Exception ex) {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose"+ ex);
				throw new Exception("Database Connection Error !!");
			} finally {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose");
				if(conn!=null){
					conn.close();
				}
	            System.out.println("Joboxxxxxxxxx conn.close() tttttttttttttttttt;xxxxx dclose");
	        }
			


		} catch (Exception e) {
			e.printStackTrace();


		}

			
		try {
			DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date today = new Date();
			String subject_str = subject_str_fm.format(today);


			String content = "\nTesting - Interruption Schedule in "+cycle+" is recommended by CE-Planning and forwarded to DGM Province.You can view that by login into https://mms.ceb.lk \n\n Thank You";
			String subject = "Testing - Recommended Interruption Schedule " + cycle ;
			String sms_content ="Testing - Recommended Interruption Schedule in "+cycle+" is sent by Control Center.You can view that by login into https://mms.ceb.lk";

			String pdceemail = "cepdcp.dd2@ceb.lk";
			//pdce2email = "nakumari@gmail.com";
			String telNopdcee = "0714520624";
			String dmtel = "0719387070";
			String dmemail="amiladananjaya@gmail.com";
			String dear ="Chief Engineer/Area Engineer";
			String phmce = Util.cephmcp ;
			String phmcetel = Util.telcephmcp ;
			String phmee = Util.eephmcp1  ;
			String phmeetel = Util.teleephmcp1  ;
			
			String[] emailListArea = new String[4];
			emailListArea[0] = pdceemail;
			emailListArea[1] = dmemail;
			emailListArea[2] ="eranga.bogahakumbura@gmail.com";
			emailListArea[3] ="gchampika28@gmail.com";
			
			String[] emailListArea = new String[4];
			emailListArea[0] = "gchampika28@gmail.com";
			emailListArea[1] = "gchampika28@gmail.com";
			emailListArea[2] ="eranga.bogahakumbura@gmail.com";
			emailListArea[3] ="gchampika28@gmail.com";
			
			
			ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
			MailMail mm = (MailMail) context.getBean("mailMail");

			
			mm.sendMailTo(dear, content ,"gchampika28@gmail.com",emailListArea,subject,null,null,null,null,null,pdfFile);
			
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
		
		//String urlCEPD="http://smsgw.ceb/SMSPlatform.php?recipients="+telNopdcee+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlDM="http://smsgw.ceb/SMSPlatform.php?recipients="+dmtel+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			//Util.trustEveryone();
			
			restTemplate.getForObject(urlEE, String.class);
			restTemplate.getForObject(urlCEPD, String.class);
			restTemplate.getForObject(urlDM, String.class);
			restTemplate.getForObject(urlCE, String.class);
			restTemplate.getForObject(urlAE, String.class);
			
			
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        
        
        
*/        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

	}
	
	
	
	
	
	
	@RequestMapping(value = "/sendNotificationIntScheduleEE", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void sendNotificationIntScheduleEE(HttpServletRequest request,@RequestParam("cycle") String cycle) {
		System.out.println("sendRequestToES :hhhhh" );
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		
		System.out.println("sendRequestToES :" + deptId );
		String userName =(String)request.getSession().getAttribute("loggedUser");
		//String userLevel =(String)request.getSession().getAttribute("loggedUser");
		
		String status = "";
		/*if(userLevel.equalsIgnoreCase("ES")){
			status ="31";
        }else if(userLevel.equalsIgnoreCase("EEC") || userLevel.equalsIgnoreCase("EE") || userLevel.equalsIgnoreCase("PE")){
        	status ="41";
        }else if(userLevel.equalsIgnoreCase("PCE") || userLevel.equalsIgnoreCase("CE")){
        	status ="51";
        }else if(userLevel.equalsIgnoreCase("DGM")){
        	status ="61";
        }
        */
		
		status ="41";
		    
		
        List<String> strList = new LinkedList<String>();
		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
		String pdfPath ="";
		String pdfName = "";
		Connection conn = null;
		File pdfFile = null;
		
		try {
			
			try {
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				conn = jasperDao.getConnection();
				
				System.out.println(status+"/"+userName+"/"+cycle);
				hmParams.put("@status", "'"+status+"'");
				//hmParams.put("@user", "'DGMCP'");
				hmParams.put("@cycle", "'"+cycle.trim()+"'");
				
				
				File file = new File(path1 + "/" + "INT_REQ_SUM_CCR_FINAL" + ".jrxml" );
			        
			        if(!file.exists())
			            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

			    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "INT_REQ_SUM_CCR_FINAL" + ".jrxml");
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
 				JRPdfExporter pdf = new JRPdfExporter();

				Calendar calendar = Calendar.getInstance();
				 
				pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
				
				pdfPath = path2 + "/INTERRUPTION REQUEST SUMMARY-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ ".pdf";
						
				pdfPath = "Recommended Interruption Schedule - " + cycle+ ".pdf";
				
				pdfFile = new File(path2 + File.separator + pdfPath);
				System.out.println("pdfPath" +pdfPath );
				pdf.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
			    pdf.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, path2 + File.separator + pdfPath);
			    pdf.exportReport();

				
				/*if (pdfFile.exists())
		        {
		            try {
		            	response.setContentType("application/pdf");
		            	//response.addHeader("Content-Disposition", "attachment; filename="+pdfPath);
		                 
		            	InputStream inputStream = new FileInputStream(new File( path2 + File.separator + pdfPath)); //load the file
						IOUtils.copy(inputStream, response.getOutputStream());
						response.flushBuffer();
						System.out.println("pdfPath" +pdfPath );
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	
		        	

		        }
*/
				

				System.out.println("Joboxxxxxxxxxxxxxxxxxxxxxxxxxxxx dclose");

				 

			} catch (Exception ex) {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose"+ ex);
				throw new Exception("Database Connection Error !!");
			} finally {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose");
				if(conn!=null){
					conn.close();
				}
	            System.out.println("Joboxxxxxxxxx conn.close() tttttttttttttttttt;xxxxx dclose");
	        }
			


		} catch (Exception e) {
			e.printStackTrace();


		}

			
		try {
			DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date today = new Date();
			String subject_str = subject_str_fm.format(today);


			String content = "\nTesting  - Interruption Schedule in "+cycle+" is recommended by EE-Planning and forwarded to CE-Planning.You can view that by login into https://mms.ceb.lk \n\n Thank You";
			String subject = "Testing  - Recommended Interruption Schedule " + cycle ;
			String sms_content ="Testing - Recommended Interruption Schedule in "+cycle+" is sent by Control Center.You can view that by login into https://mms.ceb.lk";

			String pdceemail = "cepdcp.dd2@ceb.lk";
			//pdce2email = "nakumari@gmail.com";
			String telNopdcee = "0714520624";
			String dmtel = "0719387070";
			String dmemail="amiladananjaya@gmail.com";
			String dear ="Chief Engineer/Area Engineer";
			String phmce = Util.cephmcp ;
			String phmcetel = Util.telcephmcp ;
			String phmee = Util.eephmcp1  ;
			String phmeetel = Util.teleephmcp1  ;
			
			String[] emailListArea = new String[4];
			emailListArea[0] = pdceemail;
			emailListArea[1] = dmemail;
			emailListArea[2] ="eranga.bogahakumbura@gmail.com";
			emailListArea[3] ="gchampika28@gmail.com";
			
			/*String[] emailListArea = new String[4];
			emailListArea[0] = "gchampika28@gmail.com";
			emailListArea[1] = "gchampika28@gmail.com";
			emailListArea[2] ="eranga.bogahakumbura@gmail.com";
			emailListArea[3] ="gchampika28@gmail.com";
			*/
			
			ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
			MailMail mm = (MailMail) context.getBean("mailMail");

			
			mm.sendMailTo(dear, content ,phmce,emailListArea,subject,null,null,null,null,null,pdfFile);
			
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		/*//String urlCEPD="http://smsgw.ceb/SMSPlatform.php?recipients="+telNopdcee+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlDM="http://smsgw.ceb/SMSPlatform.php?recipients="+dmtel+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			//Util.trustEveryone();
			
			restTemplate.getForObject(urlEE, String.class);
			restTemplate.getForObject(urlCEPD, String.class);
			restTemplate.getForObject(urlDM, String.class);
			restTemplate.getForObject(urlCE, String.class);
			restTemplate.getForObject(urlAE, String.class);
			
			
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
        
   
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/sendNotificationIntSchedule", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void sendNotificationIntSchedule(HttpServletRequest request,@RequestParam("cycle") String cycle) {
		System.out.println("sendRequestToES :hhhhh" );
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole")
				.toString();
		
		System.out.println("sendRequestToES :" + deptId );
		String userName =(String)request.getSession().getAttribute("loggedUser");
		//String userLevel =(String)request.getSession().getAttribute("loggedUser");
		
		String status = "";
		/*if(userLevel.equalsIgnoreCase("ES")){
			status ="31";
        }else if(userLevel.equalsIgnoreCase("EEC") || userLevel.equalsIgnoreCase("EE") || userLevel.equalsIgnoreCase("PE")){
        	status ="41";
        }else if(userLevel.equalsIgnoreCase("PCE") || userLevel.equalsIgnoreCase("CE")){
        	status ="51";
        }else if(userLevel.equalsIgnoreCase("DGM")){
        	status ="61";
        }
        */
		
		status ="51";
		if(userLevel.equalsIgnoreCase("EEC") || userLevel.equalsIgnoreCase("EE") || userLevel.equalsIgnoreCase("PE") ||userLevel.equalsIgnoreCase("PCE") || userLevel.equalsIgnoreCase("CE") || userLevel.equalsIgnoreCase("DGM")){
	        
		
        List<String> strList = new LinkedList<String>();
		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
		String pdfPath ="";
		String pdfName = "";
		Connection conn = null;
		File pdfFile = null;
		
		try {
			
			try {
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				conn = jasperDao.getConnection();
				
				System.out.println(status+"/"+userName+"/"+cycle);
				hmParams.put("@status", "'"+status+"'");
				//hmParams.put("@user", "'DGMCP'");
				hmParams.put("@cycle", "'"+cycle.trim()+"'");
				
				
				File file = new File(path1 + "/" + "INT_REQ_SUM_CCR_FINAL" + ".jrxml" );
			        
			        if(!file.exists())
			            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

			    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "INT_REQ_SUM_CCR_FINAL" + ".jrxml");
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
 				JRPdfExporter pdf = new JRPdfExporter();

				Calendar calendar = Calendar.getInstance();
				 
				pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
				
				pdfPath = path2 + "/INTERRUPTION REQUEST SUMMARY-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ ".pdf";
						
				pdfPath = "Recommended Interruption Schedule - " + cycle+ ".pdf";
				
				pdfFile = new File(path2 + File.separator + pdfPath);
				System.out.println("pdfPath" +pdfPath );
				pdf.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
			    pdf.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, path2 + File.separator + pdfPath);
			    pdf.exportReport();

				
				/*if (pdfFile.exists())
		        {
		            try {
		            	response.setContentType("application/pdf");
		            	//response.addHeader("Content-Disposition", "attachment; filename="+pdfPath);
		                 
		            	InputStream inputStream = new FileInputStream(new File( path2 + File.separator + pdfPath)); //load the file
						IOUtils.copy(inputStream, response.getOutputStream());
						response.flushBuffer();
						System.out.println("pdfPath" +pdfPath );
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	
		        	

		        }
*/
				

				System.out.println("Joboxxxxxxxxxxxxxxxxxxxxxxxxxxxx dclose");

				 

			} catch (Exception ex) {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose"+ ex);
				throw new Exception("Database Connection Error !!");
			} finally {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose");
				if(conn!=null){
					conn.close();
				}
	            System.out.println("Joboxxxxxxxxx conn.close() tttttttttttttttttt;xxxxx dclose");
	        }
			


		} catch (Exception e) {
			e.printStackTrace();


		}

			
		try {
			DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date today = new Date();
			String subject_str = subject_str_fm.format(today);


			String content = "\nTesting  - Interruption Schedule in "+cycle+" is recommended by CE-Planning and forwarded to DGM Province.You can view that by login into https://mms.ceb.lk \n\n Thank You";
			String subject = "Testing - Recommended Interruption Schedule " + cycle ;
			String sms_content ="Testing  - Recommended Interruption Schedule in "+cycle+" is sent by Control Center.You can view that by login into https://mms.ceb.lk";

			String pdceemail = "cepdcp.dd2@ceb.lk";
			//pdce2email = "nakumari@gmail.com";
			String telNopdcee = "0714520624";
			String dmtel = "0719387070";
			String dmemail="amiladananjaya@gmail.com";
			String dear ="Chief Engineer/Area Engineer";
			String phmce = Util.cephmcp ;
			String phmcetel = Util.telcephmcp ;
			String phmee = Util.eephmcp1  ;
			String phmeetel = Util.teleephmcp1  ;
			
			String[] emailListArea = new String[4];
			emailListArea[0] = pdceemail;
			emailListArea[1] = dmemail;
			emailListArea[2] ="eranga.bogahakumbura@gmail.com";
			emailListArea[3] ="gchampika28@gmail.com";
			
			/*String[] emailListArea = new String[4];
			emailListArea[0] = "gchampika28@gmail.com";
			emailListArea[1] = "gchampika28@gmail.com";
			emailListArea[2] ="eranga.bogahakumbura@gmail.com";
			emailListArea[3] ="gchampika28@gmail.com";
			*/
			
			ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
			MailMail mm = (MailMail) context.getBean("mailMail");

			
			mm.sendMailTo(dear, content ,phmce,emailListArea,subject,null,null,null,null,null,pdfFile);
			
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
		
		/*//String urlCEPD="http://smsgw.ceb/SMSPlatform.php?recipients="+telNopdcee+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlDM="http://smsgw.ceb/SMSPlatform.php?recipients="+dmtel+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			//Util.trustEveryone();
			
			restTemplate.getForObject(urlEE, String.class);
			restTemplate.getForObject(urlCEPD, String.class);
			restTemplate.getForObject(urlDM, String.class);
			restTemplate.getForObject(urlCE, String.class);
			restTemplate.getForObject(urlAE, String.class);
			
			
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
        
   
	}


	

	//@RequestMapping(value = "/confirmRequest/{emailId}/{permitNo}/{es}/{altsup}", method = RequestMethod.GET, produces = "application/json")
	@RequestMapping(value = "/confirmRequest", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void confirmRequest(HttpServletRequest request,@RequestParam("emailId") String emailId,@RequestParam("permitNo") String permitNo,@RequestParam("es") String es,@RequestParam("altsup") String altsup) {
		System.out.println("sendRequestToES :hhhhh" );
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("sendRequestToES :" + deptId );
		
		
        ApprovalMm obj = approvalMm.findByID(emailId);
        String compId = gldeptDao.getDD(obj.getAreaCode());
        String province = glcompmDao.getProvince(compId);
        System.out.println("province : "+province );

        File serverFile1 = null;
        String attaPath = PathMMS.getReportPath();
		File dir = new File(attaPath + File.separator + "IntRequest");
		
        
       /* if(attacheFile != null){
		if (!attacheFile.isEmpty()) {
			try {
				String name = attacheFile.getOriginalFilename();
				String extension = Util.getSubStringFirstPart(name,".");
				
				System.out.println("extention :" +extension);
				
				name = emailId + "IMG1" + extension;
				
				byte[] bytes = attacheFile.getBytes();

				serverFile1 = new File(dir.getAbsolutePath()+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile1));
				
				stream.write(bytes);
				stream.close();
									
				
				}catch(Exception e){
				System.out.println("error :"+e);
			}
		}
        }
*/
        
        
        System.out.println("getFromtowerId 1:" + obj.getFromtowerId() );
        if(obj.getFromtowerId()!=null){
        	System.out.println("getFromtowerId:" + obj.getFromtowerId() );
        	MmsAddsupport objSup = addSupport.findById(new Long(obj.getFromtowerId().toString()));
        	objSup.setInterruptedYes(new BigDecimal("1"));
        	objSup.setInterruptedDate(obj.getApprovedDate());
        	objSup.setInterruptionNo(obj.getApprovalId());
        	addSupport.update(objSup);
        	
        }
        
        if(obj.getTotowerId()!=null){
        	System.out.println("getTotowerId:" + obj.getTotowerId() );
        	
        	MmsAddsupport objSup = addSupport.findById(new Long(obj.getTotowerId().toString()));
        	
        	objSup.setInterruptedYes(new BigDecimal("1"));
        	objSup.setInterruptedDate(obj.getApprovedDate());
        	objSup.setInterruptionNo(obj.getApprovalId());
        	addSupport.update(objSup);
        	
        }
        
        
		
		
		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		System.out.println("sendRequestToES1" + path1);

		
		String pdfPath = "";
		//String reportFileName ="Inspection_Request";
		Connection conn = null;
		String ref_no ="test";

		try {
			
			try {
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				hmParams.put("@province", "'"+province+"'");
				
				hmParams.put("@REFERENCE_NO", "'"+emailId+"'");
				hmParams.put("@workingDate","'" +obj.getWorkingDate() +"'");
				hmParams.put("@TimeDur","'"+obj.getTimeduration()+"'");
				hmParams.put("@Location","'"+obj.getFromto() + "'");
				hmParams.put("@TS","'" +obj.getFromtower() +"'");
				hmParams.put("@TE","'" +obj.getTotower() +"'");
				System.out.println("sendRequestToES2");

				MmsAddline line = lineDao.findById(obj.getLineid());
				if(line != null){
					System.out.println("model.getLine().getName() : " + line.getName());

				hmParams.put("@LineName","'" +line.getLineName() +"'");
				}
				System.out.println("sendRequestToES3" + path1);

				
				hmParams.put("@FieldWork","'"+obj.getReq2()+"'");
				
				Sauserm user = secDao.getSauserm(obj.getEs().trim());
				System.out.println("sendRequestToES3-1" + path1);

				Sauserm userEE = secDao.getSauserm(obj.getEe().trim());
				System.out.println("sendRequestToES3-2" + path1);
				String resEEES = "";
				String strESName = "";
				if(user !=null){
					strESName = user.getUserNm();
				}
				if(userEE !=null && user !=null){
					resEEES = "EE : " + userEE.getUserNm() + " ES : " + user.getUserNm();
					
				}
				System.out.println("sendRequestToES3-2" + path1);

				hmParams.put("@ESName","'"+resEEES+"'");
				System.out.println("sendRequestToES4" + path1);

				String requBra = "PHM";
				hmParams.put("@RequestBr","'"+requBra+"'");
				
		        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date today = Calendar.getInstance().getTime();        
				String reportDate = df.format(today);
				System.out.println("sendRequestToES5" + path1);

				String generatedDate = df.format(obj.getApprovedDate());
				hmParams.put("@Date1","'"+generatedDate+"'");
				String reschedule = "Recommended";
				hmParams.put("@approve","'"+reschedule+"'");
				System.out.println("sendRequestToES6" + path1);
				hmParams.put("@permit","'"+permitNo+"'");
				hmParams.put("@incharge","'"+es+"'");
				hmParams.put("@altsup","'"+altsup+"'");
				
				hmParams.put("@actionDate","'"+reportDate+"'");
				
				conn = jasperDao.getConnection();
				System.out.println("sendRequestToES7" + path1);

				String path = PathMMS.getReportPath() + File.separator + "Reports";
				String fileName;
				if(obj.getType() != null){
					if(obj.getType().equalsIgnoreCase("OTHER")){
						fileName = "PTWOTHER.jrxml";
					}else{
						fileName = "PTW.jrxml";
					}
					
				}else{
					fileName = "PTW.jrxml";
				}
				
				File file = new File(path + "/"+fileName );
				    
			        if(!file.exists())
			            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

			    JasperReport jasperReport =  JasperCompileManager.compileReport(path  + "/"+ fileName);
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
 				JRPdfExporter pdf = new JRPdfExporter();

				Calendar calendar = Calendar.getInstance();
				 
				pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");

				pdfPath = path + "/" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
				+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
				+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + "R.pdf";
				
				pdfPath = path + "/" +"INTERRUPTION"+ "-"+ calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + ".pdf";
						
				
				pdfPath = path + "/"+emailId+"_2" + ".pdf";
				pdf.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
				pdf.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, pdfPath);
				pdf.exportReport();


				System.out.println("Joboxxxxxxxxxxxxxxxxxxxxxxxxxxxx dclose");
				 

			} catch (Exception ex) {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose"+ ex);
				throw new Exception("Database Connection Error !!");
			} finally {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose");
				if(conn!=null){
					conn.close();
				}
	            System.out.println("Joboxxxxxxxxx conn.close() tttttttttttttttttt;xxxxx dclose");
	        }
			


		} catch (Exception e) {
			e.printStackTrace();


		}

		File pdfFile = new File(pdfPath);
		
		//obj.setApprovedBy(es);
		obj.setToStatus("96");
		obj.setInchargeEs(es);
		obj.setPermitNo(permitNo);
		obj.setAltSupArrangement(altsup);
		System.out.println("sendRequestToES 1:" );
		
		
		Date date = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		String timeString = "";
		Date date2 = null;
		try {
			String dateString1 = format1.format(date);
			date2 = format1.parse (dateString1);
			timeString = format2.format(date);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    

		obj.setActionDate(date2);
		obj.setActionTime(timeString);
		approvalMm.update(obj);
		System.out.println("sendRequestToES 2:" );
		String content = "";
		String subject = "";
		String sms_content ="";
		String success_content = "";
		String success_subject = "";
		String success_sms_content ="";
		
		String approveType = "";
		
		DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
		String subject_str = subject_str_fm.format(today);
		
		
		String pdceemail = "";
		String pdce2email = "";
		String telNopdcee = "";
		String cephm="";
		String eephm="";
		String emailAreaEngineer=Util.searchEmail(deptId);
		String telAreaEngineer=Util.searchTelNo(deptId);;
		
		
		String dmtel ="";
		String dmemail ="";
		String dear = "";
		String dgmemail="";
		String dgmtelNo="";
		System.out.println("province" +province+ "test");
		province = province.trim();
		if(province.equalsIgnoreCase("CP")){
			System.out.println("provinceCP" +province+ "test");
			cephm="";
			pdceemail = "cepdcp.dd2@ceb.lk";
			//pdce2email = "nakumari@gmail.com";
			telNopdcee = "0714520624";
			dmtel = "0719387070";
			dmemail="amiladananjaya@gmail.com";
			dear ="Chief Engineer";
			dgmemail  = Util.searchEmailProvinceDGM(province);
			dgmtelNo  = Util.searchTelNoProvinceDGM(province);
		}else if(province.equalsIgnoreCase("CP2")){
			System.out.println("provinceCP" +province+ "test");
			cephm="";
			pdceemail = "cepdcp.dd2@ceb.lk";
			//pdce2email = "nakumari@gmail.com";
			telNopdcee = "0714520624";
			dmtel = "0719387070";
			dmemail="amiladananjaya@gmail.com";
			dear ="Chief Engineer";
			dgmemail  = Util.searchEmailProvinceDGM(province);
			dgmtelNo  = Util.searchTelNoProvinceDGM(province);
		}else if(province.equalsIgnoreCase("WPN")){
			System.out.println("provinceWPN" +province+ "test");
			pdceemail = "cepdwpn.dd2@ceb.lk";
			//cppdce2email = "nakumari@gmail.com";
			telNopdcee = "0714066301";
			dmtel = "0718692150";
			dmemail="eeowpn@gmail.com";
			dear ="Chief Engineer";
			dgmemail  = Util.searchEmailProvinceDGM(province);
			dgmtelNo  = Util.searchTelNoProvinceDGM(province);
		}else if(province.equalsIgnoreCase("EP")){
			System.out.println("provinceEP" +province+ "test");
			
			pdceemail = "Ofcceplnep.dd2@ceb.lk";
			//pdce2email = "fedrena@hotmail.com";
			telNopdcee = "0714527831";
			dmtel = "0714527831";
			dmemail="eedevep.dd2@ceb.lk";
			dear ="Chief Engineer";dgmemail  = Util.searchEmailProvinceDGM(province);
			dgmtelNo  = Util.searchTelNoProvinceDGM(province);
		}else if(province.equalsIgnoreCase("WPSII")){
			System.out.println("provinceEP" +province+ "test");
			
			pdceemail = "cepndwps2.dd3@ceb.lk";
			//pdce2email = "";
			telNopdcee = "0714297792";
			dmtel = "0716867844";
			dmemail="eedccccwps2.dd3@ceb.lk";
			dear ="Chief Engineer";
			dgmemail  = Util.searchEmailProvinceDGM(province);
			dgmtelNo  = Util.searchTelNoProvinceDGM(province);
		}else if(province.equalsIgnoreCase("UVAP")){
			System.out.println("provinceEP" +province+ "test");
			
			pdceemail = "ee1dmuva.dd3@ceb.lk";
			//pdce2email = "fedrena@hotmail.com";
			telNopdcee = "0714297727";
			dmtel = "0706990331";
			dmemail="eecontcentuva.dd3@ceb.lk";
			dear ="Chief Engineer";
			dgmemail  = Util.searchEmailProvinceDGM(province);
			dgmtelNo  = Util.searchTelNoProvinceDGM(province);
		}else if(province.equalsIgnoreCase("SABP")){
			System.out.println("provinceEP" +province+ "test");
			
			pdceemail = "cepdsbp.dd3@ceb.lk";
			//pdce2email = "fedrena@hotmail.com";
			telNopdcee = "0716969933";
			dmtel = "0716983444";
			dmemail="eeplnsbp.dd3@ceb.lk";
			dear ="Chief Engineer";
			dgmemail  = Util.searchEmailProvinceDGM(province);
			dgmtelNo  = Util.searchTelNoProvinceDGM(province);
		}else{
			
		}

		
		String emailCE = "";
		String telNoCE = "";
		
		if(obj.getDeptId().trim().equalsIgnoreCase("600.41")){
			emailCE = Util.cephmcp;
			telNoCE = Util.telcephmcp;
		}else if(obj.getDeptId().trim().equalsIgnoreCase("600.42")){
			emailCE = Util.cephmcpsub;
			telNoCE = Util.telcephmcpsub;
		}else if(obj.getDeptId().trim().equalsIgnoreCase("780.00")){
			emailCE = Util.cephmdd3;
			telNoCE = Util.telcephmdd3;
		}else{
			emailCE = Util.cephmcp;
			telNoCE = Util.telcephmcp;
		}


		
	    String areaName = obj.getReferenceNo();
		//areaName = areaName.toLowerCase();
		content = "\nInterruption request("+emailId+") is recommended by "+areaName;
		subject = "Recommendation of interruption request from "+areaName + " " + obj.getWorkingDate();
		sms_content ="Interruption request("+emailId+") is recommended by "+areaName;
		approveType = "INTREQ";
		
		success_content = "\nRecommendation of interruption request("+emailId+") is successfully sent to P&HM";
		success_subject = "Recommendation of interruption request "+emailId;
		success_sms_content ="Recommendation of interruption request("+emailId+") is successfully sent to P&HM";
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");
		
		String[] emailListArea = new String[5];
		emailListArea[0] = emailCE;
		emailListArea[1] =pdceemail;
		emailListArea[2] = dmemail;
		//emailListArea[3] ="gchampika28@gmail.com";
		emailListArea[3] =dgmemail;
		emailListArea[4] =emailAreaEngineer;
		//emailListArea[5] ="gchampika28@gmail.com";
		
		
		
		
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"eranga.bogahakumbura@gmail.com",subject);
		//Util.trustEveryone();
		mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,getEmail(obj.getEe()),emailListArea,subject,serverFile1,null,null,null,null,pdfFile);
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,pdceemail,getEmail(obj.getEe()),subject,serverFile1,null,null,null,null,pdfFile);
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,dmemail,getEmail(obj.getEe()),subject,serverFile1,null,null,null,null,pdfFile);
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", success_content ,Util.searchEmail(obj.getAreaCode()),"eranga.bogahakumbura@gmail.com",success_subject,serverFile1,null,null,null,null,pdfFile);
		
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"eranga.bogahakumbura@gmail.com","alagodas1@gmail.com",subject,serverFile1,null,null,null,null,pdfFile);
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"gchampika28@gmail.com","gchampika28@gmail.com",subject,serverFile1,null,null,null,null,pdfFile);
		
		//Date date = new Date();
		RestTemplate restTemplate = new RestTemplate();
		//String url="http://smsgw.ceb/SMSPlatform.php?recipients=0718716913&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlEE="http://smsgw.ceb/SMSPlatform.php?recipients="+getTelNo(obj.getEe())+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlCE="http://smsgw.ceb/SMSPlatform.php?recipients="+telNoCE+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		String urlAE="http://smsgw.ceb/SMSPlatform.php?recipients="+Util.searchTelNo(obj.getAreaCode())+"&smsbody="+success_sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlCEP="http://smsgw.ceb/SMSPlatform.php?recipients="+telNopdcee+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlCCE="http://smsgw.ceb/SMSPlatform.php?recipients="+dmtel+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlDGM="http://smsgw.ceb/SMSPlatform.php?recipients="+dgmtelNo+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlArea="http://smsgw.ceb/SMSPlatform.php?recipients="+dgmtelNo+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		try {
			//Util.trustEveryone();
			
			//restTemplate.getForObject(url, String.class);
			restTemplate.getForObject(urlEE, String.class);
			restTemplate.getForObject(urlCE, String.class);
			
			restTemplate.getForObject(urlAE, String.class);
			restTemplate.getForObject(urlCEP, String.class);
			restTemplate.getForObject(urlCCE, String.class);
			restTemplate.getForObject(urlDGM, String.class);
			restTemplate.getForObject(urlArea, String.class);
		} catch (RestClientException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	

	//@RequestMapping(value = "/reScheduleRequest/{emailId}/{reScheduledate}/{permitNo}/{es}/{altsup}", method = RequestMethod.GET, produces = "application/json")
	@RequestMapping(value = "/reScheduleRequest", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody void reScheduleRequest(HttpServletRequest request,@RequestParam("emailId") String emailId,@RequestParam("reScheduledate") String reScheduledate,@RequestParam("permitNo") String permitNo,@RequestParam("es") String es,@RequestParam("altsup") String altsup) {
		System.out.println("sendRequestToES :hhhhh" );
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("sendRequestToES :" + deptId );
		Date dateNowNew = null;
		try {
			dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reScheduledate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("sendRequestToES1");

		
		ApprovalMm obj = approvalMm.findByID(emailId);
		String compId = gldeptDao.getDD(obj.getAreaCode());
        String province = glcompmDao.getProvince(compId);
        System.out.println("province : "+province );

		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		System.out.println("sendRequestToES1" + path1);

		
		String pdfPath = "";
		//String reportFileName ="Inspection_Request";
		Connection conn = null;
		String ref_no ="test";

		try {
			
			try {
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				hmParams.put("@province", "'"+province+"'");
				
				hmParams.put("@REFERENCE_NO", "'"+emailId+"'");
				hmParams.put("@workingDate","'" +obj.getWorkingDate() +"'");
				hmParams.put("@TimeDur","'"+obj.getTimeduration()+"'");
				hmParams.put("@Location","'"+obj.getFromto() + "'");
				hmParams.put("@TS","'" +obj.getFromtower() +"'");
				hmParams.put("@TE","'" +obj.getTotower() +"'");
				System.out.println("sendRequestToES2");

				MmsAddline line = lineDao.findById(obj.getLineid());
				if(line != null){
					System.out.println("model.getLine().getName() : " + line.getName());

				hmParams.put("@LineName","'" +line.getLineName() +"'");
				}
				System.out.println("sendRequestToES3" + path1);

				
				hmParams.put("@FieldWork","'"+obj.getReq2()+"'");
				
				Sauserm user = secDao.getSauserm(obj.getEs().trim());
				System.out.println("sendRequestToES3-1" + path1);

				Sauserm userEE = secDao.getSauserm(obj.getEe().trim());
				System.out.println("sendRequestToES3-2" + path1);
				String resEEES = "";
				if(userEE !=null && user !=null){
					resEEES = "EE : " + userEE.getUserNm() + " ES : " + user.getUserNm();
					
				}
				System.out.println("sendRequestToES3-2" + path1);

				hmParams.put("@ESName","'"+resEEES+"'");
				System.out.println("sendRequestToES4" + path1);

				String requBra = "PHM";
				hmParams.put("@RequestBr","'"+requBra+"'");
				
		        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date today = Calendar.getInstance().getTime();        
				String reportDate = df.format(today);
				System.out.println("sendRequestToES5" + path1);

				String generatedDate = df.format(obj.getApprovedDate());
				hmParams.put("@Date1","'"+generatedDate+"'");
String reschedule = "Rescheduled : " + reScheduledate;
				hmParams.put("@approve","'"+reschedule+"'");
				System.out.println("sendRequestToES6" + path1);

				hmParams.put("@permit","'"+permitNo+"'");
				hmParams.put("@incharge","'"+es+"'");
				hmParams.put("@altsup","'"+altsup+"'");
				hmParams.put("@actionDate","'"+reportDate+"'");
				
				conn = jasperDao.getConnection();
				System.out.println("sendRequestToES7" + path1);

				String path = PathMMS.getReportPath() + File.separator + "Reports";
				String fileName;
				if(obj.getType() != null){
					if(obj.getType().equalsIgnoreCase("OTHER")){
						fileName = "PTWOTHER.jrxml";
					}else{
						fileName = "PTW.jrxml";
					}
					
				}else{
					fileName = "PTW.jrxml";
				}
				
				
				File file = new File(path + "/" + fileName);
				    
			        if(!file.exists())
			            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

			    JasperReport jasperReport =  JasperCompileManager.compileReport(path  + "/" + fileName);
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
 				JRPdfExporter pdf = new JRPdfExporter();

				Calendar calendar = Calendar.getInstance();
				 
				pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");

				pdfPath = path + "/" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
				+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
				+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + "R.pdf";
				
				pdfPath = path + "/" +"INTERRUPTION"+ "-"+ calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + ".pdf";
						
				
				pdfPath = path + "/"+emailId+"_1" + ".pdf";
				pdf.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
				pdf.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, pdfPath);
				pdf.exportReport();


				System.out.println("Joboxxxxxxxxxxxxxxxxxxxxxxxxxxxx dclose");
				 

			} catch (Exception ex) {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose"+ ex);
				throw new Exception("Database Connection Error !!");
			} finally {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose");
				if(conn!=null){
					conn.close();
				}
	            System.out.println("Joboxxxxxxxxx conn.close() tttttttttttttttttt;xxxxx dclose");
	        }
			


		} catch (Exception e) {
			e.printStackTrace();


		}

		File pdfFile = new File(pdfPath);
		
		//obj.setApprovedBy(es);
		obj.setToStatus("80");
		obj.setRescheduleDate(dateNowNew);
		obj.setAltSupArrangement(altsup);
		
		System.out.println("sendRequestToES 1:" );
		Date date = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		String timeString = "";
		Date date2 = null;
		try {
			String dateString1 = format1.format(date);
			date2 = format1.parse (dateString1);
			timeString = format2.format(date);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    

		obj.setActionDate(date2);
		obj.setActionTime(timeString);

		
		approvalMm.update(obj);
		System.out.println("sendRequestToES 2:" );
		
		String content = "";
		String subject = "";
		String sms_content ="";
		String approveType = "";
		DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
					String subject_str = subject_str_fm.format(today);
					
					String pdceemail = "";
					String pdce2email = "";
					String telNopdcee = "";
					String cephm="";
					String eephm="";
					
					String dmtel ="";
					String dmemail ="";
					String dear = "";
					String emailAreaEngineer=Util.searchEmail(deptId);
					String telAreaEngineer=Util.searchTelNo(deptId);;
					
					System.out.println("province" +province+ "test");
					province = province.trim();
					if(province.equalsIgnoreCase("CP")){
						System.out.println("provinceCP" +province+ "test");
						cephm="";
						pdceemail = "cepdcp.dd2@ceb.lk";
						//pdce2email = "nakumari@gmail.com";
						telNopdcee = "0714520624";
						dmtel = "0719387070";
						dmemail="amiladananjaya@gmail.com";
						dear ="Chief Engineer";
					}else if(province.equalsIgnoreCase("CP2")){
						System.out.println("provinceCP" +province+ "test");
						cephm="";
						pdceemail = "cepdcp.dd2@ceb.lk";
						//pdce2email = "nakumari@gmail.com";
						telNopdcee = "0714520624";
						dmtel = "0719387070";
						dmemail="amiladananjaya@gmail.com";
						dear ="Chief Engineer";
					}else if(province.equalsIgnoreCase("WPN")){
						System.out.println("provinceWPN" +province+ "test");
						pdceemail = "cepdwpn.dd2@ceb.lk";
						//cppdce2email = "nakumari@gmail.com";
						telNopdcee = "0714066301";
						dmtel = "0718692150";
						dmemail="eeowpn@gmail.com";
						dear ="Chief Engineer";
					}else if(province.equalsIgnoreCase("EP")){
						System.out.println("provinceEP" +province+ "test");
						
						pdceemail = "Ofcceplnep.dd2@ceb.lk";
						//pdce2email = "fedrena@hotmail.com";
						telNopdcee = "0714527831";
						dmtel = "0714527831";
						dmemail="eedevep.dd2@ceb.lk";
						dear ="Chief Engineer";
					}else if(province.equalsIgnoreCase("WPSII")){
						System.out.println("provinceEP" +province+ "test");
						
						pdceemail = "cepndwps2.dd3@ceb.lk";
						//pdce2email = "";
						telNopdcee = "0714297792";
						dmtel = "0716867844";
						dmemail="eedccccwps2.dd3@ceb.lk";
						dear ="Chief Engineer";
					}else if(province.equalsIgnoreCase("UVAP")){
						System.out.println("provinceEP" +province+ "test");
						
						pdceemail = "ee1dmuva.dd3@ceb.lk";
						//pdce2email = "fedrena@hotmail.com";
						telNopdcee = "0714297727";
						dmtel = "0706990331";
						dmemail="eecontcentuva.dd3@ceb.lk";
						dear ="Chief Engineer";
					}else if(province.equalsIgnoreCase("SABP")){
						System.out.println("provinceEP" +province+ "test");
						
						pdceemail = "cepdsbp.dd3@ceb.lk";
						//pdce2email = "fedrena@hotmail.com";
						telNopdcee = "0716969933";
						dmtel = "0716983444";
						dmemail="eeplnsbp.dd3@ceb.lk";
						dear ="Chief Engineer";
					}else{
						
					}
					
					String emailCE = "";
					String telNoCE = "";
					
					if(obj.getDeptId().trim().equalsIgnoreCase("600.41")){
						emailCE = Util.cephmcp;
						telNoCE = Util.telcephmcp;
					}else if(obj.getDeptId().trim().equalsIgnoreCase("600.42")){
						emailCE = Util.cephmcpsub;
						telNoCE = Util.telcephmcpsub;
					}else if(obj.getDeptId().trim().equalsIgnoreCase("780.00")){
						emailCE = Util.cephmdd3;
						telNoCE = Util.telcephmdd3;
					}else{
						emailCE = Util.cephmcp;
						telNoCE = Util.telcephmcp;
					}




					String[] emailListArea = new String[4];
					emailListArea[0] = emailCE;
					emailListArea[1] = pdceemail;
					emailListArea[2] = dmemail;
					emailListArea[3] =emailAreaEngineer;
					//emailListArea[4] ="gchampika28@gmail.com";
					//emailListArea[5] ="mgrisd@ceb.lk";
					
					
					
	    String areaName = obj.getReferenceNo();
		//areaName = areaName.toLowerCase();
		content = "\nInterruption request("+emailId+") is rescheduled to "+reScheduledate+" by "+areaName;
		subject = "Interruption request is rescheduled to "+reScheduledate+"  by "+areaName;
		sms_content ="Interruption request("+emailId+") is rescheduled by "+areaName;
		approveType = "INTREQ";
		
		String success_content = "\nRescheduling  of interruption request("+emailId+") is successfully sent to P&HM DD2";
		String success_subject = "Rescheduling  of interruption request "+emailId;
		String success_sms_content ="Rescheduling  of interruption request("+emailId+") is successfully sent to P&HM DD2";

		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");
		
		//public void sendMailTo(String dear, String content,String to,String cc,String subject,File file,File file1,File file2,File file3,File file4,File pdfFile) {
			
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"eranga.bogahakumbura@gmail.com",subject);
		//Util.trustEveryone();
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"eranga.bogahakumbura@gmail.com","alagodas1@gmail.com",subject,null,null,null,null,null,pdfFile);
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"gchampika28@gmail.com","gchampika28@gmail.com",subject,null,null,null,null,null,pdfFile);
		
		mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,getEmail(obj.getEe()),emailListArea,subject,null,null,null,null,null,pdfFile);
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,pdceemail,getEmail(obj.getEe()),subject,null,null,null,null,null,pdfFile);
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,dmemail,getEmail(obj.getEe()),subject,null,null,null,null,null,pdfFile);
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", success_content ,Util.searchEmail(obj.getAreaCode()),"eranga.bogahakumbura@gmail.com",success_subject,null,null,null,null,null,pdfFile);
		
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"eranga.bogahakumbura@gmail.com","alagodas1@gmail.com",subject,null,null,null,null,null,pdfFile);
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"gchampika28@gmail.com","gchampika28@gmail.com",subject,null,null,null,null,null,pdfFile);

		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", success_content ,Util.searchEmail(obj.getAreaCode()),"gchampika28@gmail.com",success_subject,null,null,null,null,null,pdfFile);
		
		
		//Date date = new Date();
		RestTemplate restTemplate = new RestTemplate();
		//String url="http://smsgw.ceb/SMSPlatform.php?recipients=0718716913&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		//String url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlEE="http://smsgw.ceb/SMSPlatform.php?recipients="+getTelNo(obj.getEe())+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlCE="http://smsgw.ceb/SMSPlatform.php?recipients="+telNoCE+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		String urlAE="http://smsgw.ceb/SMSPlatform.php?recipients="+Util.searchTelNo(obj.getAreaCode())+"&smsbody="+success_sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlCEP="http://smsgw.ceb/SMSPlatform.php?recipients="+telNopdcee+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlCCE="http://smsgw.ceb/SMSPlatform.php?recipients="+dmtel+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlArea="http://smsgw.ceb/SMSPlatform.php?recipients="+telAreaEngineer+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		try {
			//restTemplate.getForObject(url, String.class);
			restTemplate.getForObject(urlEE, String.class);
			restTemplate.getForObject(urlCE, String.class);
			
			restTemplate.getForObject(urlAE, String.class);
			restTemplate.getForObject(urlCEP, String.class);
			restTemplate.getForObject(urlCCE, String.class);
			restTemplate.getForObject(urlArea, String.class);

		} catch (RestClientException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	
	
	@RequestMapping(value = "/forwardedToEsRequest/{emailId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void forwardedToEsRequest(HttpServletRequest request,@PathVariable("emailId") String emailId) {
		System.out.println("sendRequestToES :hhhhh" );
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("sendRequestToES :" + deptId );
		
		ApprovalMm obj = approvalMm.findByID(emailId);
		//obj.setApprovedBy(es);
		obj.setToStatus("80");
		System.out.println("sendRequestToES 1:" );
		
		approvalMm.update(obj);
		System.out.println("sendRequestToES 2:" );
		
		String content = "";
		String subject = "";
		String sms_content ="";
		String approveType = "";
		DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
					String subject_str = subject_str_fm.format(today);

		
	    String areaName = obj.getReferenceNo();
		//areaName = areaName.toLowerCase();
		content = "\nInterruption request("+emailId+") is approved by "+areaName;
		subject = "Confirmation of interruption request from "+areaName + " "+ subject_str;
		sms_content ="Interruption request("+emailId+") is approved by "+areaName;
		approveType = "INTREQ";
		
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");
		//Util.trustEveryone();
		mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"eranga.bogahakumbura@gmail.com",subject);
		
		Date date = new Date();
		RestTemplate restTemplate = new RestTemplate();
		String url="http://smsgw.ceb/SMSPlatform.php?recipients=0718716913&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		try {
			//Util.trustEveryone();
			
			restTemplate.getForObject(url, String.class);
		} catch (RestClientException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@RequestMapping(value = "/forwardRequest/{emailId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void forwardRequest(HttpServletRequest request,@PathVariable("emailId") String emailId) {
		System.out.println("sendRequestToES :hhhhh" );
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("sendRequestToES :" + deptId );
		
		/*ApprovalMm obj = approvalMm.findByID(emailId);
		//obj.setApprovedBy(es);
		obj.setToStatus("97");
		System.out.println("sendRequestToES 1:" );
		
		approvalMm.update(obj);
		System.out.println("sendRequestToES 2:" );
		*/
		
        ApprovalMm obj = approvalMm.findByID(emailId);
	}
	
	
	
	
	
	@RequestMapping(value = "/notConfirmRequest/{emailId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void notConfirmRequest(HttpServletRequest request,@PathVariable("emailId") String emailId) {
		System.out.println("sendRequestToES :hhhhh" );
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("sendRequestToES :" + deptId );
		
		/*ApprovalMm obj = approvalMm.findByID(emailId);
		//obj.setApprovedBy(es);
		obj.setToStatus("97");
		System.out.println("sendRequestToES 1:" );
		
		approvalMm.update(obj);
		System.out.println("sendRequestToES 2:" );
		*/
		
ApprovalMm obj = approvalMm.findByID(emailId);
String compId = gldeptDao.getDD(obj.getAreaCode());
String province = glcompmDao.getProvince(compId);
System.out.println("province : "+province );

		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		System.out.println("sendRequestToES1" + path1);

		
		String pdfPath = "";
		//String reportFileName ="Inspection_Request";
		Connection conn = null;
		String ref_no ="test";

		try {
			
			try {
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				hmParams.put("@province", "'"+province+"'");

				hmParams.put("@REFERENCE_NO", "'"+emailId+"'");
				hmParams.put("@workingDate","'" +obj.getWorkingDate() +"'");
				hmParams.put("@TimeDur","'"+obj.getTimeduration()+"'");
				hmParams.put("@Location","'"+obj.getFromto() + "'");
				hmParams.put("@TS","'" +obj.getFromtower() +"'");
				hmParams.put("@TE","'" +obj.getTotower() +"'");
				System.out.println("sendRequestToES2");

				MmsAddline line = lineDao.findById(obj.getLineid());
				if(line != null){
					System.out.println("model.getLine().getName() : " + line.getName());

				hmParams.put("@LineName","'" +line.getLineName() +"'");
				}
				System.out.println("sendRequestToES3" + path1);

				
				hmParams.put("@FieldWork","'"+obj.getReq2()+"'");
				
				Sauserm user = secDao.getSauserm(obj.getEs().trim());
				System.out.println("sendRequestToES3-1" + path1);

				Sauserm userEE = secDao.getSauserm(obj.getEe().trim());
				System.out.println("sendRequestToES3-2" + path1);
				String resEEES = "";
				if(userEE !=null && user !=null){
					resEEES = "EE : " + userEE.getUserNm() + " ES : " + user.getUserNm();
					
				}
				System.out.println("sendRequestToES3-2" + path1);

				hmParams.put("@ESName","'"+resEEES+"'");
				System.out.println("sendRequestToES4" + path1);

				String requBra = "PHM";
				hmParams.put("@RequestBr","'"+requBra+"'");
				
		        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date today = Calendar.getInstance().getTime();        
				String reportDate = df.format(today);
				System.out.println("sendRequestToES5" + path1);

				String generatedDate = df.format(obj.getApprovedDate());
				hmParams.put("@Date1","'"+generatedDate+"'");
                String reschedule = "Not Approved";
				hmParams.put("@approve","'"+reschedule+"'");
				System.out.println("sendRequestToES6" + path1);
				//hmParams.put("@permit","'"+permitNo+"'");
				//hmParams.put("@incharge","'"+es+"'");
				
				hmParams.put("@actionDate","'"+reportDate+"'");
				
				conn = jasperDao.getConnection();
				System.out.println("sendRequestToES7" + path1);

				String path = PathMMS.getReportPath() + File.separator + "Reports";
				String fileName;
				if(obj.getType() != null){
					if(obj.getType().equalsIgnoreCase("OTHER")){
						fileName = "PTWOTHER.jrxml";
					}else{
						fileName = "PTW.jrxml";
					}
					
				}else{
					fileName = "PTW.jrxml";
				}
				
				
				File file = new File(path + "/" + fileName );
				    
			        if(!file.exists())
			            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

			    JasperReport jasperReport =  JasperCompileManager.compileReport(path  + "/" + fileName);
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
 				JRPdfExporter pdf = new JRPdfExporter();

				Calendar calendar = Calendar.getInstance();
				 
				pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");

				pdfPath = path + "/" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
				+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
				+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + "R.pdf";
				
				pdfPath = path + "/" +"INTERRUPTION"+ "-"+ calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + ".pdf";
						
				
				pdfPath = path + "/"+emailId+"_3" + ".pdf";
				pdf.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
				pdf.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, pdfPath);
				pdf.exportReport();


				System.out.println("Joboxxxxxxxxxxxxxxxxxxxxxxxxxxxx dclose");
				 

			} catch (Exception ex) {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose"+ ex);
				throw new Exception("Database Connection Error !!");
			} finally {
				System.out.println("Joboxxxxxxxxx conn.close();xxxxx dclose");
				if(conn!=null){
					conn.close();
				}
	            System.out.println("Joboxxxxxxxxx conn.close() tttttttttttttttttt;xxxxx dclose");
	        }
			


		} catch (Exception e) {
			e.printStackTrace();


		}

		File pdfFile = new File(pdfPath);
		
		//obj.setApprovedBy(es);
		obj.setToStatus("97");
		//obj.setInchargeEs(es);
		//obj.setPermitNo(permitNo);
		System.out.println("sendRequestToES 1:" );
		
		Date date = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
		String timeString = "";
		Date date2 = null;
		try {
			String dateString1 = format1.format(date);
			date2 = format1.parse (dateString1);
			timeString = format2.format(date);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    

		obj.setActionDate(date2);
		obj.setActionTime(timeString);

		String pdceemail = "";
		String pdce2email = "";
		String telNopdcee = "";
		String cephm="";
		String eephm="";
		
		String dmtel ="";
		String dmemail ="";
		String dear = "";
		System.out.println("province" +province+ "test");
		province = province.trim();
		if(province.equalsIgnoreCase("CP")){
			System.out.println("provinceCP" +province+ "test");
			cephm="";
			pdceemail = "cepdcp.dd2@ceb.lk";
			//pdce2email = "nakumari@gmail.com";
			telNopdcee = "0714520624";
			dmtel = "0719387070";
			dmemail="amiladananjaya@gmail.com";
			dear ="Chief Engineer";
		}else if(province.equalsIgnoreCase("CP2")){
			System.out.println("provinceCP" +province+ "test");
			cephm="";
			pdceemail = "cepdcp.dd2@ceb.lk";
			//pdce2email = "nakumari@gmail.com";
			telNopdcee = "0714520624";
			dmtel = "0719387070";
			dmemail="amiladananjaya@gmail.com";
			dear ="Chief Engineer";
		}else if(province.equalsIgnoreCase("WPN")){
			System.out.println("provinceWPN" +province+ "test");
			pdceemail = "cepdwpn.dd2@ceb.lk";
			//cppdce2email = "nakumari@gmail.com";
			telNopdcee = "0714066301";
			dmtel = "0718692150";
			dmemail="eeowpn@gmail.com";
			dear ="Chief Engineer";
		}else if(province.equalsIgnoreCase("EP")){
			System.out.println("provinceEP" +province+ "test");
			pdceemail = "Ofcceplnep.dd2@ceb.lk";
			//pdce2email = "fedrena@hotmail.com";
			telNopdcee = "0714527831";
			dmtel = "0714527831";
			dmemail="eedevep.dd2@ceb.lk";
			dear ="Chief Engineer";
		}else if(province.equalsIgnoreCase("WPSII")){
			System.out.println("provinceEP" +province+ "test");
			
			pdceemail = "cepndwps2.dd3@ceb.lk";
			//pdce2email = "";
			telNopdcee = "0714297792";
			dmtel = "0716867844";
			dmemail="eedccccwps2.dd3@ceb.lk";
			dear ="Chief Engineer";
		}else if(province.equalsIgnoreCase("UVAP")){
			System.out.println("provinceEP" +province+ "test");
			
			pdceemail = "ee1dmuva.dd3@ceb.lk";
			//pdce2email = "fedrena@hotmail.com";
			telNopdcee = "0714297727";
			dmtel = "0706990331";
			dmemail="eecontcentuva.dd3@ceb.lk";
			dear ="Chief Engineer";
		}else if(province.equalsIgnoreCase("SABP")){
			System.out.println("provinceEP" +province+ "test");
			
			pdceemail = "cepdsbp.dd3@ceb.lk";
			//pdce2email = "fedrena@hotmail.com";
			telNopdcee = "0716969933";
			dmtel = "0716983444";
			dmemail="eeplnsbp.dd3@ceb.lk";
			dear ="Chief Engineer";
		}else{
			
		}

		
		String emailCE = "";
		String telNoCE = "";
		
		if(obj.getDeptId().trim().equalsIgnoreCase("600.41")){
			emailCE = Util.cephmcp;
			telNoCE = Util.telcephmcp;
		}else if(obj.getDeptId().trim().equalsIgnoreCase("600.42")){
			emailCE = Util.cephmcpsub;
			telNoCE = Util.telcephmcpsub;
		}else if(obj.getDeptId().trim().equalsIgnoreCase("780.00")){
			emailCE = Util.cephmdd3;
			telNoCE = Util.telcephmdd3;
		}else{
			emailCE = Util.cephmcp;
			telNoCE = Util.telcephmcp;
		}



		
		
		approvalMm.update(obj);
		System.out.println("sendRequestToES 2:" );

		String content = "";
		String subject = "";
		String sms_content ="";
		String approveType = "";
		
		String success_content = "";
		String success_subject = "";
		String success_sms_content ="";
		
		
		DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
					String subject_str = subject_str_fm.format(today);

		
	    String areaName = obj.getReferenceNo();
		//areaName = areaName.toLowerCase();
		content = "\nInterruption request("+emailId+") is Not Recommended by "+areaName;
		subject = "Rejection of interruption request from "+areaName + " "+ subject_str;
		sms_content ="Interruption request("+emailId+") is Not Recommended by "+areaName ;
		approveType = "INTREQ";
		
		success_content = "\nRejection of interruption request("+emailId+") is successfully sent to P&HM DD2";
		success_subject = "Rejection of interruption request "+emailId;
		success_sms_content ="Rejection of interruption request("+emailId+") is successfully sent to P&HM DD2";

		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");
		String[] emailListArea = new String[3];
		//emailListArea[0] = getEmail(userName);
		emailListArea[0] = emailCE;
		emailListArea[1] =pdceemail;
		emailListArea[2] = dmemail;
		//emailListArea[3] ="eranga.bogahakumbura@gmail.com";
		//emailListArea[4] ="gchampika28@gmail.com";
		//emailListArea[5] ="mgrisd@ceb.lk";
		
		
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"eranga.bogahakumbura@gmail.com",subject);
		//Util.trustEveryone();
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"eranga.bogahakumbura@gmail.com","alagodas1@gmail.com",subject,null,null,null,null,null,pdfFile);
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"gchampika28@gmail.com","gchampika28@gmail.com",subject,null,null,null,null,null,pdfFile);
		mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,getEmail(obj.getEe()),emailListArea,subject,null,null,null,null,null,pdfFile);
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,pdceemail,getEmail(obj.getEe()),subject,null,null,null,null,null,pdfFile);
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,dmemail,getEmail(obj.getEe()),subject,null,null,null,null,null,pdfFile);
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", success_content ,Util.searchEmail(obj.getAreaCode()),"eranga.bogahakumbura@gmail.com",success_subject,null,null,null,null,null,pdfFile);
		
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"eranga.bogahakumbura@gmail.com","alagodas1@gmail.com",subject,null,null,null,null,null,pdfFile);
		//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"gchampika28@gmail.com","gchampika28@gmail.com",subject,null,null,null,null,null,pdfFile);

		
		
		//Date date = new Date();
		RestTemplate restTemplate = new RestTemplate();
		//String url="http://smsgw.ceb/SMSPlatform.php?recipients=0718716913&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlEE="http://smsgw.ceb/SMSPlatform.php?recipients="+getTelNo(obj.getEe())+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlAE="http://smsgw.ceb/SMSPlatform.php?recipients="+Util.searchTelNo(obj.getAreaCode())+"&smsbody="+success_sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlCEP="http://smsgw.ceb/SMSPlatform.php?recipients="+telNoCE+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		String urlCCE="http://smsgw.ceb/SMSPlatform.php?recipients="+dmtel+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
		
		
		
		
		try {
			//restTemplate.getForObject(url, String.class);
			restTemplate.getForObject(urlEE, String.class);
			restTemplate.getForObject(urlAE, String.class);
			restTemplate.getForObject(urlCEP, String.class);
			restTemplate.getForObject(urlCCE, String.class);
		} catch (RestClientException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}


	
	
	
	//Application application = createApplicationObject(deptId,userName,model);
	//westimateNo = appDao.saveSPS(deptId,userName,allocated_To,application, model);
	//model.setMode(westimateNo);

	
	@RequestMapping(value = "/generateEstimate/{emailId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void generateEstimate(HttpServletRequest request,@PathVariable("emailId") String emailId) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("sendRequestToES :" + deptId );
		
		Approval obj = approval.findByID(emailId);
		PivModel model = new PivModel();
		Application application = createApplicationObject(deptId,obj.getApprovedBy(),model);
		System.out.println("sendRequestToES : 1" + deptId );
		
		String westimateNo = appDao.saveSPS(deptId,obj.getApprovedBy(),obj.getApprovedBy(),application, model);
		System.out.println("sendRequestToES : 2" + deptId );
		
		
		obj.setReferenceNo(westimateNo);
		obj.setToStatus("98");
		System.out.println("sendRequestToES 1:"  + westimateNo);
		
		approval.update(obj);
		System.out.println("sendRequestToES 2:" );
		
	}
	
	
	 private Application createApplicationObject(String deptId,String userId,PivModel model){
			
		 	DateFormat df = new SimpleDateFormat("yy");
			String formattedDate = df.format(Calendar.getInstance().getTime());
			System.out.println(formattedDate);
			
			String appPrefix =deptId + "/APH/" + formattedDate +"/";
		
		 
		 
			ApplicationPK id=new ApplicationPK();
			//String appPrefix = "600.41/APH/18/";
			String sequence = appDao.getNextAppId(appPrefix);
			System.out.println(appPrefix +sequence );
			id.setApplicationId(appPrefix +sequence );
			id.setDeptId(deptId);
			Application application=new Application();
			application.setId(id);
			application.setApplicationNo(null);
			application.setApplicationType("PH");
			application.setApplicationSubType("PM");
			application.setDuration(new BigDecimal(0));
			application.setIsLoanApp("N");
			Calendar calendar = Calendar.getInstance();
			application.setSubmitDate(calendar.getTime());
			application.setIdNo(model.getApplicant().getIdNo());
			application.setPreparedBy(userId);
			application.setConfirmedBy(userId);
			application.setConfirmedDate(calendar.getTime());
			application.setConfirmedTime(null);
			application.setAllocatedBy(null);
			application.setAllocatedTo(null);
			application.setAllocatedDate(null);
			application.setAllocatedTime(null);
			application.setStatus("A");
			application.setAddUser(userId);
			application.setAddDate(calendar.getTime());
			application.setAddTime(null);
			application.setUpdUser(null);
			application.setUpdDate(null);
			application.setUpdTime(null);
			application.setDescription ("");
			//appDao.save(application);
			System.out.println("hii hii" );
			return application;
			
		}
	 
	 
	 @SuppressWarnings("deprecation")
	 @RequestMapping(value = "/updateTowerMaintence/{visitid}/{towerid}/{nooftappings}/{pinpole1}/{switchdev1}/{pinpole2}/{switchdev2}/{pinpole3}/{switchdev3}/{noofmissingparts}/{nofflashoversets}/{wayleavestatus}/{baseconcretestatus}/{anticlimbingstatus}/{conductorstatus}/{jumperstatus}/{earthconductorstatus}/{attentionstatus}/{fungussetno}/{wpinset}/{endfittingset}/{towerspecial}/{ludt}/{maintenancedate}/{status}/{approvalLevel}/{hotpossible}/{legPainting}",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody void updateTowerMaintence(HttpServletRequest request,@PathVariable("visitid") String visitid,@PathVariable("towerid") String towerid,@PathVariable("nooftappings") String nooftappings,@PathVariable("pinpole1") String pinpole1,@PathVariable("switchdev1") String switchdev1,
	 		@PathVariable("pinpole2") String pinpole2,@PathVariable("switchdev2") String switchdev2,@PathVariable("pinpole3") String pinpole3,
	 		@PathVariable("switchdev3") String switchdev3,@PathVariable("noofmissingparts") String noofmissingparts,@PathVariable("nofflashoversets") String nofflashoversets,@PathVariable("wayleavestatus") String wayleavestatus,@PathVariable("baseconcretestatus") String baseconcretestatus,@PathVariable("anticlimbingstatus") String anticlimbingstatus,@PathVariable("conductorstatus") String conductorstatus,@PathVariable("jumperstatus")
	 		String jumperstatus,@PathVariable("earthconductorstatus") String earthconductorstatus,@PathVariable("attentionstatus") String attentionstatus,@PathVariable("fungussetno") String fungussetno,
	 		@PathVariable("wpinset") String wpinset,@PathVariable("endfittingset") String endfittingset,@PathVariable("towerspecial") String towerspecial,@PathVariable("ludt") String ludt,@PathVariable("maintenancedate") String maintenancedate,@PathVariable("status") String status,@PathVariable("approvalLevel") String approvalLevel,@PathVariable("hotpossible") String hotpossible,@PathVariable("legPainting") String legPainting) {

	 	try{
	 	
	 	String deptId = (String) request.getSession().getAttribute("deptId");
	 	MmsTxntowermaintenance obj = new MmsTxntowermaintenance();
	 	MmsTxntowermaintenancePK objPK = new MmsTxntowermaintenancePK();
	 	if(visitid.trim().equalsIgnoreCase("201801")){
	 		
	 	}
	 	objPK.setVisitid(Long.valueOf(visitid));
	 	objPK.setTowerid (Long.valueOf(towerid));
	 	obj = towerTxtMaintenance.findByID(objPK);
	 	obj.setId(objPK);
	 	obj.setNooftappings(new BigDecimal(nooftappings));
	 	obj.setPinpole1(new BigDecimal(pinpole1));
	     //System.out.println("hiiiiii66664");
	 	obj.setSwitchdev1(switchdev1);
	 	//System.out.println("hiiiiii66665");
	 	obj.setPinpole2(new BigDecimal(pinpole2));
	 	///System.out.println("hiiiiii66666");
	 	obj.setSwitchdev2(switchdev2);
	 	//System.out.println("hiiiiii66667");
	 	obj.setPinpole3(new BigDecimal(pinpole3));
	 	//System.out.println("hiiiiii66668");
	 	obj.setSwitchdev3(switchdev3);
	 	//System.out.println("hiiiiii66669");
	 	obj.setNoofmissingparts(new BigDecimal(noofmissingparts));
	 	//System.out.println("hiiiiii666610");
	 	obj.setNofflashoversets(new BigDecimal(nofflashoversets));
	 	//System.out.println("hiiiiii666611");
	 	obj.setWayleavestatus(wayleavestatus);
	 	//System.out.println("hiiiiii666612");
	 	obj.setBaseconcretestatus(baseconcretestatus);
	 	//System.out.println("hiiiiii666613");
	 	obj.setAnticlimbingstatus(anticlimbingstatus);
	 	//System.out.println("hiiiiii666614");
	 	obj.setConductorstatus(conductorstatus);
	 	//System.out.println("hiiiiii666615");
	 	obj.setJumperstatus(jumperstatus);
	 	//System.out.println("hiiiiii666616");
	 	obj.setEarthconductorstatus(earthconductorstatus);
	 	//System.out.println("hiiiiii666617");
	 	obj.setAttentionstatus(attentionstatus);
	 	//System.out.println("hiiiiii666618");
	 	obj.setFungussetno(new BigDecimal(fungussetno));
	 	//System.out.println("hiiiiii666619");
	 	obj.setWpinset(new BigDecimal(wpinset));
	 	//System.out.println("hiiiiii666620");
	 	obj.setEndfittingset(new BigDecimal(endfittingset));
	 	//System.out.println("hiiiiii666621");
	 	obj.setTowerspecial(towerspecial);
	 	obj.setHotpossible(new BigDecimal(hotpossible));
	 	//System.out.println("hiiiiii666622");
	 	//obj.setLudt(new Date(ludt));
	 	Date dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(ludt);
	 	
	 	//obj.setMaintenancedate(new Date(maintenancedate));
	 	Date dateNow1 = new SimpleDateFormat("yyyy-MM-dd").parse(maintenancedate);
	 	//System.out.println("hiiiiii666623status : "+ status);
	 	obj.setStatus(new BigDecimal(status));
	 	//System.out.println("hiiiiii666623");
	 	obj.setApprovalLevel(approvalLevel);
	 	//System.out.println("hiiiiii666624");
	 	obj.setLudt(dateNow);
	 	//System.out.println("hiiiiii666625");
	 	obj.setInsDate(dateNow1);
	 	
	 	obj.setPhmBranch(deptId);
	 	obj.setLegPainting(legPainting);
	 	//System.out.println("hiiiiii666626");
	 	
	 	towerTxtMaintenance.update(obj);
	 	
	 	}catch(Exception e){
	 		
	 	}
	 }
	 
	 
	 
	 
	 
	 @SuppressWarnings("deprecation")
	 @RequestMapping(value = "/updateTowerMaintenceN",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody void updateTowerMaintenceN(@RequestParam("visitid") String visitid,@RequestParam("towerid") String towerid,@RequestParam("nooftappings") String nooftappings,@RequestParam("pinpole1") String pinpole1,@RequestParam("switchdev1") String switchdev1,
			 @RequestParam("pinpole2") String pinpole2,@RequestParam("switchdev2") String switchdev2,@RequestParam("pinpole3") String pinpole3,
			 @RequestParam("switchdev3") String switchdev3,@RequestParam("noofmissingparts") String noofmissingparts,@RequestParam("nofflashoversets") String nofflashoversets,@RequestParam("wayleavestatus") String wayleavestatus,@RequestParam("baseconcretestatus") String baseconcretestatus,@RequestParam("anticlimbingstatus") String anticlimbingstatus,@RequestParam("conductorstatus") String conductorstatus,@RequestParam("jumperstatus")
	 		String jumperstatus,@RequestParam("earthconductorstatus") String earthconductorstatus,@RequestParam("attentionstatus") String attentionstatus,@RequestParam("fungussetno") String fungussetno,
	 		@RequestParam("wpinset") String wpinset,@RequestParam("endfittingset") String endfittingset,@RequestParam("towerspecial") String towerspecial,@RequestParam("ludt") String ludt,@RequestParam("maintenancedate") String maintenancedate,@RequestParam("status") String status,@RequestParam("approvalLevel") String approvalLevel,@RequestParam("hotpossible") String hotpossible,@RequestParam("legPainting") String legPainting) {
		 System.out.println("hiiiiii66664");
		 	
	 	try{
	 	
	 	//String deptId = (String) request.getSession().getAttribute("deptId");
	 	MmsTxntowermaintenance obj = new MmsTxntowermaintenance();
	 	MmsTxntowermaintenancePK objPK = new MmsTxntowermaintenancePK();
	 	if(visitid.trim().equalsIgnoreCase("201801")){
	 		
	 	}
	 	objPK.setVisitid(Long.valueOf(visitid));
	 	objPK.setTowerid (Long.valueOf(towerid));
	 	obj = towerTxtMaintenance.findByID(objPK);
	 	obj.setId(objPK);
	 	obj.setNooftappings(new BigDecimal(nooftappings));
	 	obj.setPinpole1(new BigDecimal(pinpole1));
	     System.out.println("hiiiiii66664");
	 	obj.setSwitchdev1(switchdev1);
	 	System.out.println("hiiiiii66665");
	 	obj.setPinpole2(new BigDecimal(pinpole2));
	 	System.out.println("hiiiiii66666");
	 	obj.setSwitchdev2(switchdev2);
	 	System.out.println("hiiiiii66667");
	 	obj.setPinpole3(new BigDecimal(pinpole3));
	 	System.out.println("hiiiiii66668");
	 	obj.setSwitchdev3(switchdev3);
	 	System.out.println("hiiiiii66669");
	 	obj.setNoofmissingparts(new BigDecimal(noofmissingparts));
	 	System.out.println("hiiiiii666610");
	 	obj.setNofflashoversets(new BigDecimal(nofflashoversets));
	 	System.out.println("hiiiiii666611");
	 	obj.setWayleavestatus(wayleavestatus);
	 	System.out.println("hiiiiii666612");
	 	obj.setBaseconcretestatus(baseconcretestatus);
	 	System.out.println("hiiiiii666613");
	 	obj.setAnticlimbingstatus(anticlimbingstatus);
	 	System.out.println("hiiiiii666614");
	 	obj.setConductorstatus(conductorstatus);
	 	System.out.println("hiiiiii666615");
	 	obj.setJumperstatus(jumperstatus);
	 	System.out.println("hiiiiii666616");
	 	obj.setEarthconductorstatus(earthconductorstatus);
	 	System.out.println("hiiiiii666617");
	 	obj.setAttentionstatus(attentionstatus);
	 	System.out.println("hiiiiii666618");
	 	obj.setFungussetno(new BigDecimal(fungussetno));
	 	System.out.println("hiiiiii666619");
	 	obj.setWpinset(new BigDecimal(wpinset));
	 	System.out.println("hiiiiii666620");
	 	obj.setEndfittingset(new BigDecimal(endfittingset));
	 	System.out.println("hiiiiii666621");
	 	obj.setTowerspecial(towerspecial);
	 	obj.setHotpossible(new BigDecimal(hotpossible));
	 	System.out.println("hiiiiii666622");
	 	//obj.setLudt(new Date(ludt));
	 	Date dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(ludt);
	 	
	 	//obj.setMaintenancedate(new Date(maintenancedate));
	 	Date dateNow1 = new SimpleDateFormat("yyyy-MM-dd").parse(maintenancedate);
	 	System.out.println("hiiiiii666623status : "+ status);
	 	obj.setStatus(new BigDecimal(status));
	 	System.out.println("hiiiiii666623");
	 	obj.setApprovalLevel(approvalLevel);
	 	System.out.println("hiiiiii666624");
	 	obj.setLudt(dateNow);
	 	System.out.println("hiiiiii666625");
	 	obj.setInsDate(dateNow1);
	 	
	 	//obj.setPhmBranch(deptId);
	 	obj.setLegPainting(legPainting);
	 	System.out.println("hiiiiii666626" +wayleavestatus);
	 	
	 	towerTxtMaintenance.update(obj);
	 	
	 	}catch(Exception e){
	 		
	 	}
	 }

	 
	 
	 @SuppressWarnings("deprecation")
	 @RequestMapping(value = "/updateTowerMaintenceNew",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody void updateTowerMaintenceNew(HttpServletRequest request,@RequestParam("visitid") String visitid,@RequestParam("towerid") String towerid,@RequestParam("nooftappings") String nooftappings,@RequestParam("pinpole1") String pinpole1,@RequestParam("switchdev1") String switchdev1,
			 @RequestParam("pinpole2") String pinpole2,@RequestParam("switchdev2") String switchdev2,@RequestParam("pinpole3") String pinpole3,
			 @RequestParam("switchdev3") String switchdev3,@RequestParam("noofmissingparts") String noofmissingparts,@RequestParam("nofflashoversets") String nofflashoversets,@RequestParam("wayleavestatus") String wayleavestatus,@RequestParam("baseconcretestatus") String baseconcretestatus,@RequestParam("anticlimbingstatus") String anticlimbingstatus,@RequestParam("conductorstatus") String conductorstatus,@RequestParam("jumperstatus")
	 		String jumperstatus,@RequestParam("earthconductorstatus") String earthconductorstatus,@RequestParam("attentionstatus") String attentionstatus,@RequestParam("fungussetno") String fungussetno,
	 		@RequestParam("wpinset") String wpinset,@RequestParam("endfittingset") String endfittingset,@RequestParam("towerspecial") String towerspecial,@RequestParam("ludt") String ludt,@RequestParam("maintenancedate") String maintenancedate,@RequestParam("status") String status,@RequestParam("approvalLevel") String approvalLevel,@RequestParam("hotpossible") String hotpossible,@RequestParam("legPainting") String legPainting) {

	 	try{
	 	
	 	String deptId = (String) request.getSession().getAttribute("deptId");
	 	MmsTxntowermaintenance obj = new MmsTxntowermaintenance();
	 	MmsTxntowermaintenancePK objPK = new MmsTxntowermaintenancePK();
	 	if(visitid.trim().equalsIgnoreCase("201801")){
	 		
	 	}
	 	objPK.setVisitid(Long.valueOf(visitid));
	 	objPK.setTowerid (Long.valueOf(towerid));
	 	obj = towerTxtMaintenance.findByID(objPK);
	 	obj.setId(objPK);
	 	obj.setNooftappings(new BigDecimal(nooftappings));
	 	obj.setPinpole1(new BigDecimal(pinpole1));
	     //System.out.println("hiiiiii66664");
	 	obj.setSwitchdev1(switchdev1);
	 	//System.out.println("hiiiiii66665");
	 	obj.setPinpole2(new BigDecimal(pinpole2));
	 	///System.out.println("hiiiiii66666");
	 	obj.setSwitchdev2(switchdev2);
	 	//System.out.println("hiiiiii66667");
	 	obj.setPinpole3(new BigDecimal(pinpole3));
	 	//System.out.println("hiiiiii66668");
	 	obj.setSwitchdev3(switchdev3);
	 	//System.out.println("hiiiiii66669");
	 	obj.setNoofmissingparts(new BigDecimal(noofmissingparts));
	 	//System.out.println("hiiiiii666610");
	 	obj.setNofflashoversets(new BigDecimal(nofflashoversets));
	 	//System.out.println("hiiiiii666611");
	 	obj.setWayleavestatus(wayleavestatus);
	 	//System.out.println("hiiiiii666612");
	 	obj.setBaseconcretestatus(baseconcretestatus);
	 	//System.out.println("hiiiiii666613");
	 	obj.setAnticlimbingstatus(anticlimbingstatus);
	 	//System.out.println("hiiiiii666614");
	 	obj.setConductorstatus(conductorstatus);
	 	//System.out.println("hiiiiii666615");
	 	obj.setJumperstatus(jumperstatus);
	 	//System.out.println("hiiiiii666616");
	 	obj.setEarthconductorstatus(earthconductorstatus);
	 	//System.out.println("hiiiiii666617");
	 	obj.setAttentionstatus(attentionstatus);
	 	//System.out.println("hiiiiii666618");
	 	obj.setFungussetno(new BigDecimal(fungussetno));
	 	//System.out.println("hiiiiii666619");
	 	obj.setWpinset(new BigDecimal(wpinset));
	 	//System.out.println("hiiiiii666620");
	 	obj.setEndfittingset(new BigDecimal(endfittingset));
	 	//System.out.println("hiiiiii666621");
	 	obj.setTowerspecial(towerspecial);
	 	obj.setHotpossible(new BigDecimal(hotpossible));
	 	//System.out.println("hiiiiii666622");
	 	//obj.setLudt(new Date(ludt));
	 	Date dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(ludt);
	 	
	 	//obj.setMaintenancedate(new Date(maintenancedate));
	 	Date dateNow1 = new SimpleDateFormat("yyyy-MM-dd").parse(maintenancedate);
	 	//System.out.println("hiiiiii666623status : "+ status);
	 	obj.setStatus(new BigDecimal(status));
	 	//System.out.println("hiiiiii666623");
	 	obj.setApprovalLevel(approvalLevel);
	 	//System.out.println("hiiiiii666624");
	 	obj.setLudt(dateNow);
	 	//System.out.println("hiiiiii666625");
	 	obj.setInsDate(dateNow1);
	 	
	 	obj.setPhmBranch(deptId);
	 	obj.setLegPainting(legPainting);
	 	//System.out.println("hiiiiii666626");
	 	
	 	towerTxtMaintenance.update(obj);
	 	
	 	}catch(Exception e){
	 		
	 	}
	 }

	 
	 
	 @RequestMapping(value = "/getTapping/{area}/{lineid}/{frommapid}/{tomapid}/",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<MmsAddsupport> getTapping(@PathVariable("area") String area,@PathVariable("lineid") String lineid,@PathVariable("frommapid") String frommapid,@PathVariable("tomapid") String tomapid){
		 return addSupport.getTappings(area, lineid, "", frommapid, "", tomapid);
	 }
	 
	 
	 @RequestMapping(value = "/getApprovalList",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getApprovalList(){
		 System.out.println("getApprovalList");
		 	
		 return pcestDao.getApprovalList();
	 }
	 
	 @RequestMapping(value = "/getApprovalListNew",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getApprovalListNew(HttpServletRequest request){
		 String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 
		 return pcestDao.getApprovalList(usrRole.trim(),usrName.trim());
	 }
	 
	 
	 @RequestMapping(value = "/getApprovalListNewAE",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getApprovalListNewAE(HttpServletRequest request){
		 String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 
		 return pcestDao.getApprovalListAE(usrRole.trim(),usrName.trim());
	 }
	
	 @RequestMapping(value = "/getApprovalListByCostCenter/{dept_id}",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getApprovalListByCostCenter(HttpServletRequest request,@PathVariable("dept_id") String dept_id){
		String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 
		 return pcestDao.getApprovalList(usrRole.trim(),usrName.trim(),dept_id.trim());
	 }
	 
	 @RequestMapping(value = "/getApprovalListByCostCenterAE/{dept_id}",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getApprovalListByCostCenterAE(HttpServletRequest request,@PathVariable("dept_id") String dept_id){
		String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 
		 return pcestDao.getApprovalListAE(usrRole.trim(),usrName.trim(),dept_id.trim());
	 }
	
	
	 
	 
	 @RequestMapping(value = "/getApprovalListDetail",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getApprovalListDetail(HttpServletRequest request){
		 String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 
		 return pcestDao.getApprovalListDetail(usrRole.trim(),usrName.trim());
	 }
	 
	 @RequestMapping(value = "/getApprovalListAll",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getApprovalListAll(HttpServletRequest request){
		 String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 
		 return pcestDao.getApprovalListDetailAll(usrRole.trim(),usrName.trim());
	 }
	 
	 
	 @RequestMapping(value = "/getApprovalListStdEst",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getApprovalListStdEst(HttpServletRequest request){
		 String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 
		 return stdEstDao.getApprovalList(usrName.trim(),usrRole.trim());
	 }
	
	
	
	 
	 @RequestMapping(value = "/getApprovalStdDetail/{type}",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getApprovalStdDetail(HttpServletRequest request,@PathVariable("type") String type){
		 String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 
		 return stdEstDao.getApprovalDetailList(usrName.trim(),usrRole.trim(),type);
	 }
	 
	 @RequestMapping(value = "/getEstimateDetail/{deptId}/{status}",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getEstimateDetail(HttpServletRequest request,@PathVariable("deptId") String deptId,@PathVariable("status") String status){
		 return pcestDao.getApprovalListAllDataSet(deptId, status);
	 }
	 
	 @RequestMapping(value = "/getEstimateDetailAll",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getEstimateDetailAll(HttpServletRequest request,@RequestParam("estimateNo") String estimateNo,@RequestParam("deptid") String deptid){
		 return pcestDao.getDetailList(estimateNo.trim(),deptid.trim());
	 }
	 
	 @RequestMapping(value = "/getStdEstimateDetailAll",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getStdEstimateDetailAll(HttpServletRequest request,@RequestParam("appNo") String appNo,@RequestParam("deptid") String deptid){
		 return stdEstDao.getApprovalDetailListDmt(appNo, deptid);
	 }
	 
	 @RequestMapping(value = "/getStdEstimateDetailAllStr",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getStdEstimateDetailAllStr(HttpServletRequest request,@RequestParam("appNo") String appNo,@RequestParam("deptid") String deptid){
		 return stdEstDao.getApprovalDetailListDmt(appNo, deptid);
	 }
	
	
	
	
	 
	 
	 
	 @RequestMapping(value = "/approveStdEstimate",method = RequestMethod.POST, produces = "application/json")
	 public @ResponseBody ModelAndView approveStdEstimate(HttpServletRequest request,@ModelAttribute("model") ApprovalModel apModel){
		 
		 String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 String deptId = (String) request.getSession().getAttribute("deptId");
		 String rptUser = (String) request.getSession().getAttribute("deptId");
		 String estNumber = (String) request.getSession().getAttribute("estimateNo");
		 String result="";
		 String estimateNo =apModel.getEstimateNumber();
		 String costCenter =apModel.getCostCenter();
		 String comment =apModel.getComment();
		 String rejectedReason =apModel.getRejectReason();
			
		 Appestlim appestlim = null;
		 if(estimateNo.contains("RE")){
			 appestlim = appEstLimDao.findAppEstLimits(deptId, "SES", "RE", usrRole);
		 }else if(estimateNo.contains("RI")){
			 appestlim = appEstLimDao.findAppEstLimits(deptId, "SES", "RI", usrRole);
			 
		 }else if(estimateNo.contains("PL")){
			 appestlim = appEstLimDao.findAppEstLimits(deptId, "SES", "PL", usrRole);
			 
		 }else if(estimateNo.contains("LN")){
			 appestlim = appEstLimDao.findAppEstLimits(deptId, "SES", "LN", usrRole);
			 
		 }else{
			 appestlim = appEstLimDao.findAppEstLimits(deptId, "SES", "BS", usrRole);
			 
		 } 
		if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					estimateNo=estimateNo.trim();
					SpstdesthmtPK pk = new SpstdesthmtPK();
					pk.setAppNo(estimateNo.trim());
					pk.setDeptId(deptId.trim());
					pk.setStdNo(estimateNo.trim());
					Spstdesthmt spstdobj = null;
					try {
						spstdobj = stdEstDao.selectStdNoDeptId(estimateNo,deptId);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(totalCost!=null){
						totalCost = spstdobj.getTotalCost();
					}
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						String sequence = approval.getNextAppIdEstimate(estimateNo);
						approvalObj.setApprovalId(estimateNo+"-"+sequence);
	            		approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(deptId);
						approvalObj.setApprovalType("SES_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setStandardCost(totalCost);
						approvalObj.setReason(comment);
							
						if(apModel.getApprove()!= null && apModel.getApprove().equals("Approve")){
							if(spstdobj!= null){
								spstdobj.setStatus(new BigDecimal("50"));
								
							}
							double val = 0;
								approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus("50");
			        			result= "Successfully Approved";
			        				
						}else if(apModel.getReject()!= null && apModel.getReject().equals("Reject")) {
							if(spstdobj!= null){
								spstdobj.setStatus(new BigDecimal("5"));
								
							}
							double val = 0;
								approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus("5");
			        			result= "Successfully Rejected";
			        			
						}else if(apModel.getRecommend()!= null && apModel.getRecommend().equals("Recommend")) {
							if(spstdobj!= null){
								spstdobj.setStatus(new BigDecimal(statusTo));
								
							}
							double val = 0;
								approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			result= "Successfully Recommended";
			        			
						}
			        			try {
									stdEstDao.update(spstdobj);
									approval.addApproval(approvalObj);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
			        			
			        		
						
								
			 }else{
				 result ="There is no approval limits for your user Level,Please contact IT Branch";
			 }
		ApprovalModel model = new ApprovalModel();
		 List<Spstdesthmt>  pcesthttList =null;
		 
		 List<Spstdesthmt>  pcesthttListNew =null;
		 
		 List<PcesthttModel>  pcesthttModelListNew =null;
		 
		 
		 pcesthttList= stdEstDao.getApprovalListSPS(usrName.trim(), usrRole.trim());
		 	
		 if(pcesthttList != null){
			 int count = pcesthttList.size();
			 pcesthttListNew = new ArrayList<Spstdesthmt>(count);
			 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
			 for(int i=0 ; i < count ; i ++){
				 Spstdesthmt obj = pcesthttList.get(i);
				 PcesthttModel pcmodel = new PcesthttModel();
				 DecimalFormat df2 = new DecimalFormat("###,###,###.##");
				 String ss = df2.format(obj.getToconpay().doubleValue());
				 if(usrRole.equals("DGM")){
					 if(obj.getToconpay().doubleValue() > 50000000){
						 //recommend
						 obj.setBalCapacity(new BigDecimal("1"));
					 }else{
						 obj.setBalCapacity(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("CE")){
					 if(obj.getToconpay().doubleValue() > 25000000){
						 //recommend
						 obj.setBalCapacity(new BigDecimal("1"));
					 }else{
						 obj.setBalCapacity(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("EE")){
					 if(obj.getToconpay().doubleValue() > 5000000){
						 //recommend
						 obj.setBalCapacity(new BigDecimal("1"));
					 }else{
						 obj.setBalCapacity(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("AGM")){
					 	 obj.setBalCapacity(new BigDecimal("0"));
					 
				 }else if(usrRole.equals("PE") && estimateNo.contains("PL")){
					 if(obj.getToconpay().doubleValue() > 5000000){
						 //recommend
						 obj.setBalCapacity(new BigDecimal("1"));
					 }else{
						 obj.setBalCapacity(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("PE") && !estimateNo.contains("PL")){
					 	 obj.setBalCapacity(new BigDecimal("1"));
					 
				 }else if(usrRole.equals("PCE") && estimateNo.contains("PL")){
					 if(obj.getToconpay().doubleValue() > 25000000){
						 //recommend
						 obj.setBalCapacity(new BigDecimal("1"));
					 }else{
						 obj.setBalCapacity(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("PCE") && !estimateNo.contains("PL")){
					 	 obj.setBalCapacity(new BigDecimal("1"));
					 
				 }else{
					 obj.setBalCapacity(new BigDecimal("0"));
				 }
				 
				 pcmodel.setEstimateNo(obj.getId().getAppNo());
				 pcmodel.setDeptId(obj.getId().getDeptId());
				 pcmodel.setStdCost(ss);
				 pcmodel.setDescr(obj.getDescription());
				 pcmodel.setNormDefault(obj.getBalCapacity());


				 pcesthttModelListNew.add(i, pcmodel);

				 pcesthttListNew.add(i, obj);		
			 }
		 }
		 
		 
		 
		 model.setListPcesthttModel(pcesthttModelListNew);
		 
			
		 model.setStdList(pcesthttListNew);
		 model.setResult(result);
		 return new ModelAndView("estApprovalCom", "model", model);
	 }
	 
	 
	 @RequestMapping(value = "/rejectStdEstimate",method = RequestMethod.POST, produces = "application/json")
	 public @ResponseBody ModelAndView rejectStdEstimate(HttpServletRequest request,@ModelAttribute("model") ApprovalModel apModel){
		 
		 
		 String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 String deptId = (String) request.getSession().getAttribute("deptId");
		 String rptUser = (String) request.getSession().getAttribute("deptId");
		 String estNumber = (String) request.getSession().getAttribute("estimateNo");
		 String result="";
		 String estimateNo =apModel.getEstimateNumber();
		 String costCenter =apModel.getCostCenter();
		 Appestlim appestlim = null;
		 if(estimateNo.contains("RE")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 appestlim = appEstLimDao.findAppEstLimits(deptId, "SES", "RE", usrRole);
		 }else if(estimateNo.contains("RI")){
			 appestlim = appEstLimDao.findAppEstLimits(deptId, "SES", "RI", usrRole);
			 
		 }else if(estimateNo.contains("PL")){
			 appestlim = appEstLimDao.findAppEstLimits(deptId, "SES", "PL", usrRole);
			 
		 }else if(estimateNo.contains("LN")){
			 appestlim = appEstLimDao.findAppEstLimits(deptId, "SES", "LN", usrRole);
			 
		 }else{
			 appestlim = appEstLimDao.findAppEstLimits(deptId, "SES", "BS", usrRole);
			 
		 } 
		if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					//BigDecimal totalCostDetailCost = new BigDecimal("0");
					estimateNo=estimateNo.trim();
					SpstdesthmtPK pk = new SpstdesthmtPK();
					pk.setAppNo(estimateNo.trim());
					pk.setDeptId(deptId.trim());
					pk.setStdNo(estimateNo.trim());
					System.out.println("estimateNo : "+estimateNo);
    				
					System.out.println("deptId : "+deptId);
    				
					Spstdesthmt spstdobj = null;
					try {
						spstdobj = stdEstDao.selectStdNoDeptId(estimateNo,deptId);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("spstdobjkkk : "+spstdobj);
    				
					if(totalCost!=null){
						totalCost = spstdobj.getTotalCost();
					}
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(estimateNo);
	            		approvalObj.setApprovalId(estimateNo+"-"+sequence);
	            		System.out.println("next number : "+estimateNo+"-"+sequence);
	            		System.out.println("spstdobj : "+spstdobj);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(deptId);
						approvalObj.setApprovalType("SES_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						if (usrRole.equals("EE") || usrRole.equals("CE") || usrRole.equals("DGM")|| usrRole.equals("AGM")){
							System.out.println("statusTo : "+statusTo);
							System.out.println("statusFrom : "+statusFrom);
							if(spstdobj!= null){
								spstdobj.setStatus(new BigDecimal("5"));
								
							}
							double val = 0;
							//spstdobj.setBalCapacity(val);
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus("5");
			        			try {
									stdEstDao.update(spstdobj);
									approval.addApproval(approvalObj);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
			        			System.out.println("successfully forwarded to next level");
			        			result = "Successfully Rejected";
			        			
			        		
						
						}else{
							result ="The estimate total cost can not be empty,Please contact IT Branch";
						}
								
			 }else{
				 result ="There is no approval limits for your user Level,Please contact IT Branch";
			 }
		 
		ApprovalModel model = new ApprovalModel();
		 List<Spstdesthmt>  pcesthttList =null;
		 
		 List<Spstdesthmt>  pcesthttListNew =null;
		 
		 List<PcesthttModel>  pcesthttModelListNew =null;
		 
		 
		 pcesthttList= stdEstDao.getApprovalListSPS(usrName.trim(), usrRole.trim());
		 	
		 if(pcesthttList != null){
			 int count = pcesthttList.size();
			 pcesthttListNew = new ArrayList<Spstdesthmt>(count);
			 pcesthttModelListNew = new ArrayList<PcesthttModel>(count);
			 for(int i=0 ; i < count ; i ++){
				 Spstdesthmt obj = pcesthttList.get(i);
				 PcesthttModel pcmodel = new PcesthttModel();
				 DecimalFormat df2 = new DecimalFormat("###,###,###.##");
				 String ss = df2.format(obj.getToconpay().doubleValue());
				 if(usrRole.equals("DGM")){
					 if(obj.getToconpay().doubleValue() > 50000000){
						 //recommend
						 obj.setBalCapacity(new BigDecimal("1"));
					 }else{
						 obj.setBalCapacity(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("CE")){
					 if(obj.getToconpay().doubleValue() > 25000000){
						 //recommend
						 obj.setBalCapacity(new BigDecimal("1"));
					 }else{
						 obj.setBalCapacity(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("EE")){
					 if(obj.getToconpay().doubleValue() > 5000000){
						 //recommend
						 obj.setBalCapacity(new BigDecimal("1"));
					 }else{
						 obj.setBalCapacity(new BigDecimal("0"));
					 }
				 }else if(usrRole.equals("AGM")){
					 	 obj.setBalCapacity(new BigDecimal("0"));
					 
				 }
				 pcmodel.setEstimateNo(obj.getId().getAppNo());
				 pcmodel.setDeptId(obj.getId().getDeptId());
				 pcmodel.setStdCost(ss);
				 pcmodel.setDescr(obj.getDescription());
				 pcmodel.setNormDefault(obj.getBalCapacity());


				 pcesthttModelListNew.add(i, pcmodel);

				 pcesthttListNew.add(i, obj);		
			 }
		 }
		 
		 
		 
		 model.setListPcesthttModel(pcesthttModelListNew);
		 
			
		 model.setStdList(pcesthttListNew);
		 model.setResult(result);
		 return new ModelAndView("estApprovalCom", "model", model);	
		 }

	 
	 
	 
	 @RequestMapping(value = "/approveEstimate",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody String approveEstimate(HttpServletRequest request,@RequestParam("estimateNo") String estimateNo,@RequestParam("deptId") String deptId){
		 
		 
		 String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 String rptUser = (String) request.getSession().getAttribute("deptId");
		 	
		 String result="";
		 
		 if(estimateNo.contains("ENC")||estimateNo.contains("ETC")||estimateNo.contains("ECR")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(deptId, "EST", "NC", usrRole);
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "EST", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("510.20", "EST", "NC", usrRole);
					 
				 }
			 }
			 
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(deptId);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthtt pcesthtt = pcestDao.findById(pk);
					
					SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(deptId);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(deptId);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
						if (usrRole.equals("EE") || usrRole.equals("CE")|| usrRole.equals("PCE") || usrRole.equals("DGM")|| usrRole.equals("AGM")){
			        		if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "successfully approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			return "Successfully Forwarded to next level";
			        			
			        		}else{
			        			result ="Can not Approve this";
			        		}
						}else{
							result ="User Role is not matched";
						}
						
						}else{
							result ="Total cost can not be empty";
						}
						}else{
							result ="Total cost can not be empty";
						}
			
						
						
						
					}else{
						result ="Estimate can not be found";
					}
								
			 }else{
				 result ="There is no approve limits for your user Level";
			 }

			 
		 


		 }else if(estimateNo.contains("ELS")||estimateNo.contains("EMT")||estimateNo.contains("EAM")||estimateNo.contains("ESA")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(deptId, "EST", "NC", usrRole);
			 
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "EST", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("510.20", "EST", "NC", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(deptId);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthtt pcesthtt = pcestDao.findById(pk);
					
					/*SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(deptId);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					*/
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						/*if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						*/
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(deptId);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
						if (usrRole.equals("EE") || usrRole.equals("CE") || usrRole.equals("DGM")|| usrRole.equals("AGM")){
			        		if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "successfully approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			return "successfully forwarded to next level";
			        			
			        		}else{
			        			result ="Can not Approve this";
			        		}
						}else{
							result ="User Role is not matched";
						}
						
						}else{
							result ="Total cost can not be empty";
						}
						}else{
							result ="Total cost can not be empty";
						}
			
						
						
						
					}else{
						result ="Estimate can not be found";
					}
								
			 }else{
				 result ="There is no approve limits for your user Level";
			 }

		 }else{
			 //String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
			 //String usrName = request.getSession().getAttribute("loggedUser").toString();
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(deptId, "DES", "DE", usrRole);
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "DES", "DE", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("510.20", "DES", "DE", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					 
					BigDecimal totalCost = new BigDecimal("0");
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(deptId);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("2"));
					
					Pcesthtt pcesthtt = pcestDao.findById(pk);
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(deptId);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
						if (usrRole.equals("EE") || usrRole.equals("CE") || usrRole.equals("DGM")|| usrRole.equals("AGM")){
			        		if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "Successfully Approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			return "successfully forwarded to next level";
			        			
			        		}else{
			        			result ="Estimate can not approved.Please contact IT Branch";
			        		}
						}else{
							result ="User Role is not matched.Please contact IT Branch";
						}
						
						}else{
							result ="Total cost can not be empty.Please contact IT Branch";
						}
						}else{
							result ="Total cost can not be empty.Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="Estimate can not be found.Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approve limits for your user Level.Please contact IT Branch";
			 }

			 
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 		 
		 return result;
	 }
	 
	 
	 
	 
	 
	 
	 
	 @RequestMapping(value = "/recommendEstimate",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody String recommendEstimate(HttpServletRequest request,@RequestParam("estimateNo") String estimateNo,@RequestParam("deptId") String deptId){
		 
		 
		 String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 String rptUser = (String) request.getSession().getAttribute("deptId");
		 	
		 String result="";
		 
		 if(estimateNo.contains("ENC")||estimateNo.contains("ETC")||estimateNo.contains("ECR")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(deptId, "EST", "NC", usrRole);
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "EST", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("510.20", "EST", "NC", usrRole);
					 
				 }
			 }
			 
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(deptId);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthtt pcesthtt = pcestDao.findById(pk);
					
					SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(deptId);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(deptId);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
						if (usrRole.equals("EE") || usrRole.equals("CE") || usrRole.equals("DGM")|| usrRole.equals("AGM")){
			        		/*if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "successfully approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
*/			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			return "successfully forwarded to next level";
			        			
			        		/*}else{
			        			result ="Can not Approve this";
			        		}*/
						}else{
							result ="User Role is not matched";
						}
						
						}else{
							result ="Total cost can not be empty";
						}
						}else{
							result ="Total cost can not be empty";
						}
			
						
						
						
					}else{
						result ="Estimate can not be found";
					}
								
			 }else{
				 result ="There is no approve limits for your user Level";
			 }

			 
		 


		 }else if(estimateNo.contains("ELS")||estimateNo.contains("EMT")||estimateNo.contains("EAM")||estimateNo.contains("ESA")){
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(deptId, "EST", "NC", usrRole);
			 
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "EST", "NC", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("510.20", "EST", "NC", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					
					BigDecimal totalCost = new BigDecimal("0");
					BigDecimal totalCostDetailCost = new BigDecimal("0");
					
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(deptId);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("1"));
					
					Pcesthtt pcesthtt = pcestDao.findById(pk);
					
					/*SpeststdPK stdPk = new SpeststdPK();
					stdPk.setEstimateNo(estimateNo);
					stdPk.setDeptId(deptId);
					Speststd stdObj = spestDao.findById(stdPk);
					if(stdObj!= null){
						totalCostDetailCost = stdObj.getTotalCost();
						
					}
					*/
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						/*if(totalCost.doubleValue() > totalCostDetailCost.doubleValue() ){
							totalCost = totalCost;
						}else{
							totalCost = totalCostDetailCost;
						}
						*/
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(deptId);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
						if (usrRole.equals("EE") || usrRole.equals("CE") || usrRole.equals("DGM")|| usrRole.equals("AGM")){
			        		/*if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "successfully approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
*/			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			return "successfully forwarded to next level";
			        			
			        		/*}else{
			        			result ="Can not Approve this";
			        		}*/
						}else{
							result ="User Role is not matched";
						}
						
						}else{
							result ="Total cost can not be empty";
						}
						}else{
							result ="Total cost can not be empty";
						}
			
						
						
						
					}else{
						result ="Estimate can not be found";
					}
								
			 }else{
				 result ="There is no approve limits for your user Level";
			 }

		 }else{
			 //String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
			 //String usrName = request.getSession().getAttribute("loggedUser").toString();
			 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
			 Appestlim appestlim = appEstLimDao.findAppEstLimits(deptId, "DES", "DE", usrRole);
			 if(appestlim == null){
				 appestlim = appEstLimDao.findAppEstLimits(rptUser, "DES", "DE", usrRole);
				 if(appestlim == null){
					 appestlim = appEstLimDao.findAppEstLimits("510.20", "DES", "DE", usrRole);
					 
				 }
			 }
			
			 if (appestlim!=null){
					Double limitFrom=Double.parseDouble(String.valueOf(appestlim.getId().getLimitFrom()));
					Double limitTo=Double.parseDouble(String.valueOf(appestlim.getId().getLimitTo()));
					String statusFrom=String.valueOf(appestlim.getId().getStatusFrom());
					String statusTo=String.valueOf(appestlim.getId().getStatusTo());
					System.out.println("limitFrom : "+limitFrom +" limitTo : "+limitTo +" statusFrom : "+statusFrom +" statusTo : "+statusTo);
					 
					BigDecimal totalCost = new BigDecimal("0");
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(deptId);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("2"));
					
					Pcesthtt pcesthtt = pcestDao.findById(pk);
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						//approvalObj.setApprovalId(null);
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(deptId);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						if(totalCost != null){
						if(totalCost.doubleValue() != 0 ){
						if (usrRole.equals("EE") || usrRole.equals("CE") || usrRole.equals("DGM")|| usrRole.equals("AGM")){
			        		/*if (totalCost.doubleValue() <= limitTo ){
			        			pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_POSTED));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(EstimateStatus.EST_POSTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully approved");
			    				
			        			return "Successfully Approved";

			        		}else if(totalCost.doubleValue() > limitTo ){
*/			        			pcesthtt.setStatus(new BigDecimal(statusTo));
			        			approvalObj.setFromStatus(statusFrom);
			        			approvalObj.setToStatus(statusTo);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully forwarded to next level");
			        			return "successfully forwarded to next level";
			        			
			        		/*}else{
			        			result ="Estimate can not approved.Please contact IT Branch";
			        		}*/
						}else{
							result ="User Role is not matched.Please contact IT Branch";
						}
						
						}else{
							result ="Total cost can not be empty.Please contact IT Branch";
						}
						}else{
							result ="Total cost can not be empty.Please contact IT Branch";
						}
			
						
						
						
					}else{
						result ="Estimate can not be found.Please contact IT Branch";
					}
								
			 }else{
				 result ="There is no approve limits for your user Level.Please contact IT Branch";
			 }

			 
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 		 
		 return result;
	 }


	 
	 
	 
	 @RequestMapping(value = "/rejectEstimate",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody String rejectEstimate(HttpServletRequest request,@RequestParam("estimateNo") String estimateNo,@RequestParam("deptId") String deptId,@RequestParam("reason") String reason){
		 
		 
		 String  usrRole = request.getSession().getAttribute("loggedUserRole").toString();
		 String usrName = request.getSession().getAttribute("loggedUser").toString();
		 String result="Error Occured";
		 
		 	 System.out.println("usrRole : "+usrRole +" usrName : "+usrName);
					BigDecimal totalCost = new BigDecimal("0");
					PcesthttPK pk = new PcesthttPK();
					pk.setDeptId(deptId);
					pk.setEstimateNo(estimateNo);
					pk.setRevNo(new Long("2"));
					
					Pcesthtt pcesthtt = pcestDao.findById(pk);
					if(pcesthtt != null){
						totalCost = pcesthtt.getStdCost();
						
						//Approvals
						Calendar calendar = Calendar.getInstance();
						Format format=new Format();
						Approval approvalObj=new Approval();
						
						String sequence = approval.getNextAppIdEstimate(pcesthtt.getId().getEstimateNo().trim());
	            		approvalObj.setApprovalId(pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	            		System.out.println("next number : "+pcesthtt.getId().getEstimateNo().trim()+"-"+sequence);
	    				
						approvalObj.setReferenceNo(estimateNo.trim());
						approvalObj.setDeptId(deptId);
						approvalObj.setApprovalType("EST_APRV");
						approvalObj.setApprovedLevel(usrRole);
						approvalObj.setApprovedBy(usrName);
						approvalObj.setApprovedDate(calendar.getTime());
						approvalObj.setApprovedTime(format.FormatTime());
						approvalObj.setDetailedCost(totalCost);
						if (usrRole.equals("EE") || usrRole.equals("CE") || usrRole.equals("DGM")|| usrRole.equals("AGM")){
			        			
							    approvalObj.setFromStatus(pcesthtt.getStatus().toString());
		        			    pcesthtt.setStatus(new BigDecimal(EstimateStatus.EST_REJECTED));
		        			    pcesthtt.setRejectReason(reason);
			        			approvalObj.setToStatus(EstimateStatus.EST_REJECTED);
			        			pcestDao.update(pcesthtt);
			        			approval.addApproval(approvalObj);
			        			System.out.println("successfully Rejected");
			    				
			        			result = "Successfully Rejected";
						}else{
							result ="User Role is not matched";
						}
						
								
					}else{
						result ="Estimate can not be found";
					}
								
			  
		 		 
		 return result;
	 }
	 
	 
	 
	 @RequestMapping(value = "/getWareHouse",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getWareHouse(HttpServletRequest request){
		 String  deptId = request.getSession().getAttribute("deptId").toString();
		 
		 return inwrhDao.getWareHouse(deptId.trim());
	 }
	 
	 @RequestMapping(value = "/getWareHouseDetails",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getWareHouseDetails(HttpServletRequest request,@RequestParam("deptId") String deptId){
		 return inwrhDao.getWareHouseDetails(deptId);
	 }
	 
	 @RequestMapping(value = "/getPSDetails",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getPSDetails(HttpServletRequest request,@RequestParam("deptId") String deptId,@RequestParam("doc_pf") String doc_pf){
		 String  userName = request.getSession().getAttribute("loggedUser").toString();
		 
		 return cbpmtDao.getApprovalListDetail(userName,deptId,doc_pf);
	 }
	
	 
	 @RequestMapping(value = "/getPSDetailsCount",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getPSDetailsCount(HttpServletRequest request){
		 String  userName = request.getSession().getAttribute("loggedUser").toString();
		 
		 return cbpmtDao.getApprovalListCount(userName);
	 }
	 
	 @RequestMapping(value = "/getIVDetailsCount",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getIVDetailsCount(HttpServletRequest request){
		 String  userName = request.getSession().getAttribute("loggedUser").toString();
		 
		 return intrDao.getApprovalListCount(userName);
	 }
	 
	 @RequestMapping(value = "/getIVDetails",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getIVDetails(HttpServletRequest request){
		 String  userName = request.getSession().getAttribute("loggedUser").toString();
		 
		 return intrDao.getApprovalListDetail(userName);
	 }
	 
	 
	 @RequestMapping(value = "/getRQDetailsCount",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getRQDetailsCount(HttpServletRequest request){
		 String  userName = request.getSession().getAttribute("loggedUser").toString();
		 
		 return RqDao.getApprovalListCount(userName);
	 }
	 
	 @RequestMapping(value = "/getRQDetails",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<Object[]> getRQDetails(HttpServletRequest request){
		 String  userName = request.getSession().getAttribute("loggedUser").toString();
		 
		 return RqDao.getApprovalListDetail(userName);
	 }
	
	
	
	 
	 
	 
	 @RequestMapping(value = "/TrippingDataRequest", method = RequestMethod.GET)
	 public ModelAndView TrippingDataRequest(HttpServletRequest request,@ModelAttribute("model") PivModel model) {
			
			String deptId = request.getSession().getAttribute("deptId").toString();
			String stringOflineIds = "";
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			//PivModel model = new PivModel();
			
			String province = deptDao.getDD(deptId);
			System.out.println("province : "+province);
			Glcompm distDiv = glcompmDao.getDistDivision2(province);
			provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
			
			model.setProvinceList(provinceList);
			ModelAndView mo = new ModelAndView("TrippingDataRequest", "model",model);
			
			return mo;

		}

	 
	    @RequestMapping(value = "/saveTripingDataNew" , method = RequestMethod.POST)
		public ModelAndView saveTripingDataNew(BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,@ModelAttribute("model") PivModel model) throws Exception{
	    	if(bindingResult.hasErrors()){
	    		System.out.println("saveTripingData Error: ");
				
	    	}else{
	    		System.out.println("saveTripingData NotError: ");
	    	}
	    	/*System.out.println("saveTripingData : " + model.getObjTripping());
			
		    tripDao.save(model.getObjTripping());
			String deptId = request.getSession().getAttribute("deptId").toString();
			String stringOflineIds = "";
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			PivModel modelObj = new PivModel();
			
			String province = deptDao.getDD(deptId);
			System.out.println("province : "+province);
			Glcompm distDiv = glcompmDao.getDistDivision2(province);
			provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
			
			modelObj.setProvinceList(provinceList);
			*/ModelAndView mo = new ModelAndView("TrippingDataRequest", "model",model);
			
			return mo;

		}
	    
	    @RequestMapping(value = "/getTrippingData",method = RequestMethod.GET, produces = "application/json")
		 public @ResponseBody List<TrippingData> getTrippingData(HttpServletRequest request){
			 return tripDao.findAll();
		 }
		

	    @RequestMapping(value = "/updateTrippingData",method = RequestMethod.GET, produces = "application/json")
		 public @ResponseBody void updateTrippingData(HttpServletRequest request,@RequestParam("id") String id){
	    	System.out.println("updateTrippingData : " + id);
			 
	    	tripDao.inactiveRecord(id);
		 }
	    
	    @RequestMapping(value = "/approvePSData",method = RequestMethod.GET, produces = "application/json")
		 public @ResponseBody void approvePSData(HttpServletRequest request,@RequestParam("docno") String id){
	    	System.out.println("updateTrippingData : " + id);
			 
	    	cbpmtDao.updatePaySlip(id);
		 }
		
		
	
	    @RequestMapping(value = "/getRequestTypeCount",method = RequestMethod.GET, produces = "application/json")
		 public @ResponseBody List<Object[]> getRequestTypeCount(){
	    	System.out.println("getRequestTypeCount : ");
			return approvalMm.getRequestTypeCount();
		 }
		 
		 @RequestMapping(value = "/getRequestStatusCountByTypeES",method = RequestMethod.GET, produces = "application/json")
		 public @ResponseBody List<Object[]> getRequestStatusCountByTypeES(){
	    	System.out.println("getRequestTypeCount : ");
			return approvalMm.getRequestStatusCountByTypeES("EMTREQ");
		 }
		
	
		 @RequestMapping(value = "/getRequestStatusCountByType",method = RequestMethod.GET, produces = "application/json")
		 public @ResponseBody List<Object[]> getRequestStatusCountByType(HttpServletRequest request,@RequestParam("type") String type){
	    	System.out.println("getRequestStatusCountByType : ");
	    	String  deptId = request.getSession().getAttribute("deptId").toString();
			 
			return approvalMm.getRequestStatusCountByTypeDeptID(type,deptId);
		 }
		 
		 @RequestMapping(value = "/getRequestStatusCountByTypeDetail",method = RequestMethod.GET, produces = "application/json")
		 public @ResponseBody List<ApprovalMm> getRequestStatusCountByTypeDetail(HttpServletRequest request,@RequestParam("type") String type,@RequestParam("tostatus") String tostatus,@RequestParam("fromstatus") String fromstatus){
	    	System.out.println("getRequestStatusCountByType : ");
			return approvalMm.getRequestStatusCountByTypeDetail(type, tostatus, fromstatus);
		 }
		 
		 @RequestMapping(value = "/getInterruptionCalender",method = RequestMethod.GET, produces = "application/json")
		 public @ResponseBody List<ApprovalMm> getInterruptionCalender(HttpServletRequest request){
	    	System.out.println("getRequestStatusCountByType : ");
			return approvalMm.getAllInterruptionForCalender("", "");
		 }
		 
		 @RequestMapping(value = "/getInterruptionCalenderForRequested",method = RequestMethod.GET, produces = "application/json")
		 public @ResponseBody List<ApprovalMm> getInterruptionCalenderForRequested(HttpServletRequest request){
	    	System.out.println("getRequestStatusCountByType : ");
	    	List<String> statusNew = new ArrayList<String>(1);
			statusNew.add("95");
			statusNew.add("86");
			
	    	
			return approvalMm.getAllInterruptionForCalenderByStatus("95", "");
		 }
		 
		 @RequestMapping(value = "/getInterruptionCalenderForRequestedArea",method = RequestMethod.GET, produces = "application/json")
		 public @ResponseBody List<ApprovalMm> getInterruptionCalenderForRequestedArea(HttpServletRequest request){
	    	System.out.println("getRequestStatusCountByType : ");
	    	String deptId = request.getSession().getAttribute("deptId").toString();
			
	    	List<String> statusNew = new ArrayList<String>(1);
			statusNew.add("95");
			statusNew.add("86");
			
	    	
			return approvalMm.getAllInterruptionForCalenderByArea("95", deptId);
		 }
		
		
		
		
		 
		 @RequestMapping(value = "/getIntApprovalDetail",method = RequestMethod.GET, produces = "application/json")
		 public @ResponseBody List<ApprovalMm> getApprovalDetail(HttpServletRequest request,@RequestParam("type") String type,@RequestParam("tostatus") String tostatus,@RequestParam("fromstatus") String fromstatus){
			 List<String> statusNew = new ArrayList<String>(1);
				statusNew.add("86");
				String  userName = request.getSession().getAttribute("loggedUser").toString();
				 
			 System.out.println("getRequestStatusCountByType : ");
			return approvalMm.getApprovalIntteruption(statusNew, "INTREQ","3",userName);
		 }
		
		
		
		 private String getEmail(String ee){
				SausermMm userMm = null;
				String email ="";
				if(ee != null){
					try {
						
						userMm =secDao.getSausermMms(ee);
						if(userMm != null){
							if(userMm.getEmail()!= null){
								email = userMm.getEmail();
							}else{
								email=Util.eephmcp1;
							}
						}else{
							email=Util.eephmcp1;
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("model.getSausermEE().getUserId() "+ ee);
					
				}
				return email;
				
				
			}
			
			
			
			private String getTelNo(String ee){
				SausermMm userMm = null;
				String telNo ="";
				if(ee != null){
					try {
						
						userMm =secDao.getSausermMms(ee);
						if(userMm != null){
							if(userMm.getTelNo()!= null){
								telNo = userMm.getTelNo();
							}else{
								telNo=Util.teleephmcp1;
							}
						}else{
							telNo=Util.teleephmcp1;
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("model.getSausermEE().getUserId() "+ ee);
					
				}
				return telNo;
				
				
			}
			
			
			@RequestMapping(value = "/createIntScheduleViewPhm")
			public ModelAndView createIntScheduleViewPhm(@RequestParam("mode") String mode ,@RequestParam("type") String type ,HttpServletRequest request,@ModelAttribute("model") PivModel modelObj) {
				String userName = (String) request.getSession().getAttribute("loggedUser");
				String userLevelLogin = (String) request.getSession().getAttribute("userLevel");
				String province = "";
				String deptId = (String) request.getSession().getAttribute("deptId");
				PivModel model = new PivModel();
				List<ApprovalMm>  listApprovalUnread =null;
				Map<String, String> saList = new LinkedHashMap<String, String>();
				List<String> userList = new LinkedList<String>();
				List<String> statusList = new LinkedList<String>();
				
				
				String userLevel = "";
				if(userName != null){
					userLevel = secDao.getAuthorizedLevel(userName);
					
				}
				System.out.println("else" + userLevel +"/");
				if(userLevel != null){
					userLevel = userLevel.trim();
					
				}
				//String cycle= model.getCycleObj().getId().getCycleId();
				
				String statusto="";
				String statusto2="";
				
				
				 if(userLevel.equalsIgnoreCase("ES")){
					 statusto = "21";
					 statusto2="31";
			        }else if(userLevel.equalsIgnoreCase("EEC") || userLevel.equalsIgnoreCase("EE") || userLevel.equalsIgnoreCase("PE")){
			        	statusto = "31";
			        	//statusto2="41";
			        }else if(userLevel.equalsIgnoreCase("PCE") || userLevel.equalsIgnoreCase("CE")){
			        	statusto = "41";
			        }else if(userLevel.equalsIgnoreCase("DGM")){
			        	statusto = "51";
			        }
				
				
				Map<String,String> cycle = new LinkedHashMap<String,String>();
				
				
				List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
				int cycleLisuCount = cycleList.size()-1;
				for(int i=0;i<=cycleLisuCount;i++){ 
					//System.out.println(i);
					MvmmsCycle ojb = cycleList.get(i);
					cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
			      
			    } 
				
				String intcycle="";
				//if(model.getCycleObj() != null){
				intcycle= modelObj.getCycle();
				//}
				
				System.out.println("intcycle :"+ intcycle);
				

				
				if(userLevel.equalsIgnoreCase("DEO")){
					userList.add("ES");
					//userList.add("EE");
					userList.add("PE");
					userList.add("EEC");
				}else if(userLevel.equalsIgnoreCase("ES")){
					userList.add("ES");
					//userList.add("EE");
					userList.add("PE");
					userList.add("DEO");
					userList.add("EEC");
				}else if(userLevel.equalsIgnoreCase("ES")){
					userList.add("ES");
					//userList.add("EE");
					userList.add("PE");
					userList.add("DEO");
					
					userList.add("EEC");
				}else if(userLevel.equalsIgnoreCase("EEC") ||userLevel.equalsIgnoreCase("EE") || userLevel.equalsIgnoreCase("PE")){
					//userList.add("ES");
					//userList.add("EE");
					userList.add("PE");
					userList.add("EEC");
					userList.add("PCE");

				}else if(userLevel.equalsIgnoreCase("CE")){
					userList.add("DGM");
					
				}else if(userLevel.equalsIgnoreCase("PCE")){
					userList.add("DGM");
					
				}else{
					
				}
				
				
				
				
				List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, userList);
				Map<String,String> areaList = new LinkedHashMap<String,String>();

				int loopSa = saUserList.size() - 1;
				for (int i = 0; i <= loopSa; i++) {
					//System.out.println(i);
					Sauserm ojb = saUserList.get(i);
					//System.out.println(ojb.getUserId());
					saList.put(ojb.getUserId(), ojb.getUserNm());

				}
				
				System.out.println("eeee : " +modelObj.getFrom());

				if(mode.equalsIgnoreCase("INS")){
					listApprovalUnread = approvalMm.getPendingReqByArea(deptId, "6", "INSREQ");
				}else if(mode.equalsIgnoreCase("INT")){
					listApprovalUnread = approvalMm.getAllInterruptionReqNew(deptId, "95", "INTREQ","1");
				}else if(mode.equalsIgnoreCase("MNT")){
					listApprovalUnread = approvalMm.getPendingReqByArea(deptId, "6", "MNTREQ");
				}else if(mode.equalsIgnoreCase("WAY")){
					listApprovalUnread = approvalMm.getAllInterruptionReq(deptId, "6", "WAYREQ");
				}else {
					
					/*if(deptId.equalsIgnoreCase("440.00")){
						mode = "NWP";
					}else if (deptId.equalsIgnoreCase("430.00")){
						mode = "CP";
					}else if (deptId.equalsIgnoreCase("460.00")){
						mode = "EP";
					}else{
						
					}
					System.out.println(i);
					*/
					System.out.println("getFromDate" + modelObj.getFromDate() +"/");
					System.out.println("getToDate" + modelObj.getToDate() +"/");
					
					province = deptDao.getDD(deptId);
					
					if(province != null){
						province = province.trim();
					}
					System.out.println("else" + mode +"/");
					if(mode != null){
						mode=mode.trim();
					}
					List<String> areaListInt = null;
					if(modelObj.getType().equalsIgnoreCase("VIEW")){
						System.out.println("modelObj.getType()" + modelObj.getType() +"/");
						
						if(modelObj.getFrom() != null){
						if(!modelObj.getFrom().equalsIgnoreCase("")){
							
							List<String> strList = new LinkedList<String>();
							String sss = "";
							String[] stringList = modelObj.getFrom().split(",");
							System.out.println("oooooooooo stringList"+stringList);
							
							for (String value : stringList) {
								strList.add(value);
								sss +="'"+value+"',";
							}
							areaListInt = strList;
							
						}else{
							//areaListInt = deptDao.getAreaByProvinceNew(province);
							areaListInt = new LinkedList<String>();
							
						}
					}
					else{
						//areaListInt = deptDao.getAreaByProvinceNew(province);
						areaListInt = new LinkedList<String>();
						
					}
					}else{
						/*List<String> statusNew = new ArrayList<String>(1);
						statusNew.add("86");
						System.out.println("oooooooooo statusNew");
						
						listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, statusNew, "INTREQ","3",userName);
						*/
					}
					
					System.out.println("elseuserLevel" + userLevel +"/");
					List<String> status = new ArrayList<String>(2);
					status.add("80");
					status.add("96");
					status.add("95");
					status.add("97");
					status.add("97");
					status.add("21");
					status.add("31");
					status.add("41");
					status.add("51");
					status.add("61");
					
					
					
					
					
					
					//status.add("77");
					
					if(modelObj.getType().equalsIgnoreCase("VIEW")){
						System.out.println("getFromDate" + modelObj.getFromDate() +"/");
						System.out.println("getToDate" + modelObj.getToDate() +"/");
						if(modelObj.getFromDate() != null || modelObj.getToDate() != null ){
							
							listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, status, "INTREQ","3",modelObj.getFromDate(),modelObj.getToDate());
							
							/*System.out.println("getToDatennnnn");
							if(type.equalsIgnoreCase("EDIT") || type.equalsIgnoreCase("SFVDEO")){
								System.out.println("getToDatennnnnEDIT");
								
								
							}else if(type.equalsIgnoreCase("SFVES")){
								System.out.println("getToDatennnnnSFVES");
								
								List<String> statusNew = new ArrayList<String>(1);
								statusNew.add("86");
								
								listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, statusNew, "INTREQ","3",userName);
								
							}*/
							
						}
						
						modelObj.setSelectedLine(model.getFrom());
						
					}
					
					/*if(modelObj.getType().equalsIgnoreCase("EDIT")){
						System.out.println("getFromDate" + modelObj.getFromDate() +"/");
						System.out.println("getToDate" + modelObj.getToDate() +"/");
						if(modelObj.getFromDate() != null || modelObj.getToDate() != null ){
							System.out.println("getToDatennnnn");
							if(type.equalsIgnoreCase("EDIT")){
								System.out.println("getToDatennnnnEDIT");
								
								listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, status, "INTREQ","3",modelObj.getFromDate(),modelObj.getToDate());
								
							}else if(type.equalsIgnoreCase("SFVES")){
								System.out.println("getToDatennnnnSFVES");
								
								List<String> statusNew = new ArrayList<String>(1);
								statusNew.add("86");
								
								listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, statusNew, "INTREQ","3",userName);
								
							}
							
						}
						
						modelObj.setSelectedLine(model.getFrom());
						
					}*/else{
						//listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","2");
					}
					
				}
				
				ModelAndView mo = new ModelAndView();
				
				System.out.println("getToDatennnnn1");
				
				model.setUnReadInspectionReq(listApprovalUnread);
				model.setSaList(saList);
				
				System.out.println("getToDatennnnn2");
				if(listApprovalUnread != null){
					System.out.println("listApprovalUnread :" +listApprovalUnread.size() );
					
				int supSize = listApprovalUnread.size() - 1;
				String stringOfLineIds = "";

				for (int i = 0; i <= supSize; i++) {
					ApprovalMm obj = listApprovalUnread.get(i);
					if (i != 0) {
						stringOfLineIds = stringOfLineIds + "," + obj.getApprovalId();
					} else {
						stringOfLineIds = obj.getApprovalId();
					}
				}
				
				System.out.println("-------------------> stringOfLineIds: " + stringOfLineIds);

				model.setStringOfLineIds(stringOfLineIds);

				
				}
				
				//String dd = glcompmDao.getDistDivision(province);
				List<Gldeptm> deptTm = gldeptDao.getArea(deptId);
				int depLoop = deptTm.size()-1;
				for(int i=0;i<=depLoop;i++){ 
					System.out.println(i);
					Gldeptm ojb = (Gldeptm)deptTm.get(i);
					areaList.put(ojb.getDeptId(), ojb.getDeptNm());
			    }
				model.setCycleList(cycle);
				if(modelObj.getCycle()!= null){
					model.setCycle(modelObj.getCycle());
				}
	            model.setAreaList(areaList);
	            model.setType(type);
				model.setFrom(modelObj.getFrom());
				model.setFromDate(modelObj.getFromDate());
				model.setToDate(modelObj.getToDate());
				mo = new ModelAndView("CreateIntScheduleViewPhm", "model", model);
				if(mode.equalsIgnoreCase("INS")){
				  mo.addObject("submitType","Inspection");
				}else if(mode.equalsIgnoreCase("INT")){
					mo.addObject("submitType","Interruption");
				}else if(mode.equalsIgnoreCase("MNT")){
					mo.addObject("submitType","Maintenance");
				}else if(mode.equalsIgnoreCase("WAY")){
					mo.addObject("submitType","WayLeave");
				}else{
					mo.addObject("submitType","Interruption");
					
				}
				mo.addObject("province",province);
				mo.addObject("type",type);

				return mo;
			}
			
			
			@RequestMapping(value = "/createIntScheduleRecommended")
			public ModelAndView createIntScheduleRecommended(@RequestParam("mode") String mode ,@RequestParam("type") String type ,HttpServletRequest request,@ModelAttribute("model") PivModel modelObj) {
				String userName = (String) request.getSession().getAttribute("loggedUser");
				String userLevelLogin = (String) request.getSession().getAttribute("userLevel");
				String province = "";
				String deptId = (String) request.getSession().getAttribute("deptId");
				PivModel model = new PivModel();
				List<ApprovalMm>  listApprovalUnread =null;
				Map<String, String> saList = new LinkedHashMap<String, String>();
				List<String> userList = new LinkedList<String>();
				List<String> statusList = new LinkedList<String>();
				
				
				String userLevel = "";
				if(userName != null){
					userLevel = secDao.getAuthorizedLevel(userName);
					
				}
				System.out.println("else" + userLevel +"/");
				if(userLevel != null){
					userLevel = userLevel.trim();
					
				}
				//String cycle= model.getCycleObj().getId().getCycleId();
				
				String statusto="";
				String statusto2="";
				
				
				 if(userLevel.equalsIgnoreCase("ES")){
					 statusto = "21";
					 statusto2="31";
			        }else if(userLevel.equalsIgnoreCase("EEC") || userLevel.equalsIgnoreCase("EE") || userLevel.equalsIgnoreCase("PE")){
			        	statusto = "31";
			        	//statusto2="41";
			        }else if(userLevel.equalsIgnoreCase("PCE") || userLevel.equalsIgnoreCase("CE")){
			        	statusto = "41";
			        }else if(userLevel.equalsIgnoreCase("DGM")){
			        	statusto = "51";
			        }
				
				
				Map<String,String> cycle = new LinkedHashMap<String,String>();
				
				
				List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle("430.00");
				int cycleLisuCount = cycleList.size()-1;
				for(int i=0;i<=cycleLisuCount;i++){ 
					//System.out.println(i);
					MvmmsCycle ojb = cycleList.get(i);
					cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
			      
			    } 
				
				String intcycle="";
				//if(model.getCycleObj() != null){
				intcycle= modelObj.getCycle();
				//}
				
				System.out.println("intcycle :"+ intcycle);
				

				
				if(userLevel.equalsIgnoreCase("DEO")){
					userList.add("ES");
					//userList.add("EE");
					userList.add("PE");
					userList.add("EEC");
				}else if(userLevel.equalsIgnoreCase("ES")){
					userList.add("ES");
					//userList.add("EE");
					userList.add("PE");
					userList.add("DEO");
					userList.add("EEC");
				}else if(userLevel.equalsIgnoreCase("ES")){
					userList.add("ES");
					//userList.add("EE");
					userList.add("PE");
					userList.add("DEO");
					
					userList.add("EEC");
				}else if(userLevel.equalsIgnoreCase("EEC") ||userLevel.equalsIgnoreCase("EE") || userLevel.equalsIgnoreCase("PE")){
					//userList.add("ES");
					//userList.add("EE");
					userList.add("PE");
					userList.add("EEC");
					userList.add("PCE");

				}else if(userLevel.equalsIgnoreCase("CE")){
					userList.add("DGM");
					
				}else if(userLevel.equalsIgnoreCase("PCE")){
					userList.add("DGM");
					
				}else{
					
				}
				
				
				
				
				List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, userList);
				Map<String,String> areaList = new LinkedHashMap<String,String>();

				int loopSa = saUserList.size() - 1;
				for (int i = 0; i <= loopSa; i++) {
					//System.out.println(i);
					Sauserm ojb = saUserList.get(i);
					//System.out.println(ojb.getUserId());
					saList.put(ojb.getUserId(), ojb.getUserNm());

				}
				
				System.out.println("eeee : " +modelObj.getFrom());

				if(mode.equalsIgnoreCase("INS")){
					listApprovalUnread = approvalMm.getPendingReqByArea(deptId, "6", "INSREQ");
				}else if(mode.equalsIgnoreCase("INT")){
					listApprovalUnread = approvalMm.getAllInterruptionReqNew(deptId, "95", "INTREQ","1");
				}else if(mode.equalsIgnoreCase("MNT")){
					listApprovalUnread = approvalMm.getPendingReqByArea(deptId, "6", "MNTREQ");
				}else if(mode.equalsIgnoreCase("WAY")){
					listApprovalUnread = approvalMm.getAllInterruptionReq(deptId, "6", "WAYREQ");
				}else {
					
					/*if(deptId.equalsIgnoreCase("440.00")){
						mode = "NWP";
					}else if (deptId.equalsIgnoreCase("430.00")){
						mode = "CP";
					}else if (deptId.equalsIgnoreCase("460.00")){
						mode = "EP";
					}else{
						
					}
					System.out.println(i);
					*/
					System.out.println("getFromDate" + modelObj.getFromDate() +"/");
					System.out.println("getToDate" + modelObj.getToDate() +"/");
					
					province = deptDao.getDD(deptId);
					
					if(province != null){
						province = province.trim();
					}
					System.out.println("else" + mode +"/");
					if(mode != null){
						mode=mode.trim();
					}
					List<String> areaListInt = null;
					if(modelObj.getType().equalsIgnoreCase("VIEW")){
						System.out.println("modelObj.getType()" + modelObj.getType() +"/");
						
						if(modelObj.getFrom() != null){
						if(!modelObj.getFrom().equalsIgnoreCase("")){
							
							List<String> strList = new LinkedList<String>();
							String sss = "";
							String[] stringList = modelObj.getFrom().split(",");
							System.out.println("oooooooooo stringList"+stringList);
							
							for (String value : stringList) {
								strList.add(value);
								sss +="'"+value+"',";
							}
							areaListInt = strList;
							
						}else{
							//areaListInt = deptDao.getAreaByProvinceNew(province);
							areaListInt = new LinkedList<String>();
							
						}
					}
					else{
						//areaListInt = deptDao.getAreaByProvinceNew(province);
						areaListInt = new LinkedList<String>();
						
					}
					}else{
						/*List<String> statusNew = new ArrayList<String>(1);
						statusNew.add("86");
						System.out.println("oooooooooo statusNew");
						
						listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, statusNew, "INTREQ","3",userName);
						*/
					}
					
					System.out.println("elseuserLevel" + userLevel +"/");
					List<String> status = new ArrayList<String>(2);
					status.add("80");
					status.add("96");
					status.add("95");
					status.add("97");
					status.add("97");
					status.add("21");
					status.add("31");
					status.add("41");
					status.add("51");
					status.add("61");
					
					
					
					
					
					
					//status.add("77");
					
					if(modelObj.getType().equalsIgnoreCase("VIEW")){
						List<String> statusNew = new ArrayList<String>(1);
						statusNew.add("51");
						
						
						listApprovalUnread = approvalMm.getAllInterruptionRecommendedList(areaListInt, statusNew, "INTREQ","3",intcycle);
						
						/*System.out.println("getFromDate" + modelObj.getFromDate() +"/");
						System.out.println("getToDate" + modelObj.getToDate() +"/");
						if(modelObj.getFromDate() != null || modelObj.getToDate() != null ){
							
							listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, status, "INTREQ","3",modelObj.getFromDate(),modelObj.getToDate());
							
							System.out.println("getToDatennnnn");
							if(type.equalsIgnoreCase("EDIT") || type.equalsIgnoreCase("SFVDEO")){
								System.out.println("getToDatennnnnEDIT");
								
								
							}else if(type.equalsIgnoreCase("SFVES")){
								System.out.println("getToDatennnnnSFVES");
								
								List<String> statusNew = new ArrayList<String>(1);
								statusNew.add("86");
								
								listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, statusNew, "INTREQ","3",userName);
								
							}
							
						}
						*/
						modelObj.setSelectedLine(model.getFrom());
						
					}
					
					/*if(modelObj.getType().equalsIgnoreCase("EDIT")){
						System.out.println("getFromDate" + modelObj.getFromDate() +"/");
						System.out.println("getToDate" + modelObj.getToDate() +"/");
						if(modelObj.getFromDate() != null || modelObj.getToDate() != null ){
							System.out.println("getToDatennnnn");
							if(type.equalsIgnoreCase("EDIT")){
								System.out.println("getToDatennnnnEDIT");
								
								listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, status, "INTREQ","3",modelObj.getFromDate(),modelObj.getToDate());
								
							}else if(type.equalsIgnoreCase("SFVES")){
								System.out.println("getToDatennnnnSFVES");
								
								List<String> statusNew = new ArrayList<String>(1);
								statusNew.add("86");
								
								listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, statusNew, "INTREQ","3",userName);
								
							}
							
						}
						
						modelObj.setSelectedLine(model.getFrom());
						
					}*/else{
						//listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","2");
					}
					
				}
				
				ModelAndView mo = new ModelAndView();
				
				System.out.println("getToDatennnnn1");
				
				model.setUnReadInspectionReq(listApprovalUnread);
				model.setSaList(saList);
				
				System.out.println("getToDatennnnn2");
				if(listApprovalUnread != null){
					System.out.println("listApprovalUnread :" +listApprovalUnread.size() );
					
				int supSize = listApprovalUnread.size() - 1;
				String stringOfLineIds = "";

				for (int i = 0; i <= supSize; i++) {
					ApprovalMm obj = listApprovalUnread.get(i);
					if (i != 0) {
						stringOfLineIds = stringOfLineIds + "," + obj.getApprovalId();
					} else {
						stringOfLineIds = obj.getApprovalId();
					}
				}
				
				System.out.println("-------------------> stringOfLineIds: " + stringOfLineIds);

				model.setStringOfLineIds(stringOfLineIds);

				
				}
				
				//String dd = glcompmDao.getDistDivision(province);
				List<Gldeptm> deptTm = gldeptDao.getArea(deptId);
				int depLoop = deptTm.size()-1;
				for(int i=0;i<=depLoop;i++){ 
					System.out.println(i);
					Gldeptm ojb = (Gldeptm)deptTm.get(i);
					areaList.put(ojb.getDeptId(), ojb.getDeptNm());
			    }
				model.setCycleList(cycle);
				if(modelObj.getCycle()!= null){
					model.setCycle(modelObj.getCycle());
				}
	            model.setAreaList(areaList);
	            model.setType(type);
				model.setFrom(modelObj.getFrom());
				model.setFromDate(modelObj.getFromDate());
				model.setToDate(modelObj.getToDate());
				mo = new ModelAndView("CreateIntScheduleRecommended", "model", model);
				if(mode.equalsIgnoreCase("INS")){
				  mo.addObject("submitType","Inspection");
				}else if(mode.equalsIgnoreCase("INT")){
					mo.addObject("submitType","Interruption");
				}else if(mode.equalsIgnoreCase("MNT")){
					mo.addObject("submitType","Maintenance");
				}else if(mode.equalsIgnoreCase("WAY")){
					mo.addObject("submitType","WayLeave");
				}else{
					mo.addObject("submitType","Interruption");
					
				}
				mo.addObject("province",province);
				mo.addObject("type",type);

				return mo;
			}
			
			
			@RequestMapping(value = "/SubstationView", method = RequestMethod.GET)
			public ModelAndView SubstationView(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
				System.out.println("SubstationView : ");
				PivModel pivModelNew = new PivModel();
				ModelAndView mo = new ModelAndView();
				mo = new ModelAndView("SubstationView", "model", pivModelNew);
				return mo;

			}
			
			@RequestMapping(value = "/ESMeterView", method = RequestMethod.GET)
			public ModelAndView ESMeterView(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
				System.out.println("SubstationView : ");
				PivModel pivModelNew = new PivModel();
				ModelAndView mo = new ModelAndView();
				mo = new ModelAndView("SubstationView", "model", pivModelNew);
				return mo;

			}

			
			
			@RequestMapping(value = "/getGantryAll",method = RequestMethod.GET, produces = "application/json")
			 public @ResponseBody List<Object[]> getGantryAll(HttpServletRequest request){
				 
				 return gantryDao.getGantryByProvince();
			 }
			 
			
			 
			 @RequestMapping(value = "/getGantryByProvince",method = RequestMethod.GET, produces = "application/json")
			 public @ResponseBody List<Object[]> getGantryByProvince(HttpServletRequest request,@RequestParam("province") String province){
				 
				 return gantryDao.getGantryByProvinceByArea(province);
			 }
			 
			 @RequestMapping(value = "/getFeederIdentification1",method = RequestMethod.GET, produces = "application/json")
			 public @ResponseBody MmsAddsupport getFeederIdentification1(HttpServletRequest request,@RequestParam("feederId") String feederId){
				 
				 return addSupport.getFeederIdentification1(feederId);
			 }
			 
			 @RequestMapping(value = "/getFeederIdentification2",method = RequestMethod.GET, produces = "application/json")
			 public @ResponseBody MmsAddsupport getFeederIdentification2(HttpServletRequest request,@RequestParam("feederId") String feederId){
				 
				 return addSupport.getFeederIdentification2(feederId);
			 }
			
			
			 @RequestMapping(value = "/addPlan", method = RequestMethod.GET)
				public ModelAndView addPlan(HttpServletRequest request,@ModelAttribute("SaveGeneral") PivModel newmodel) {
					Map<String, String> lineList = new LinkedHashMap<String, String>();
		            Map<String, String> areaList = new LinkedHashMap<String, String>();
					Map<String, String> provinceList = new LinkedHashMap<String, String>();
					String userName = (String) request.getSession().getAttribute("loggedUser");
					String deptId = (String) request.getSession().getAttribute("deptId");
					String province = deptDao.getDD(deptId);
					String distDiv = glcompmDao.getDistDivision(province);
					PivModel model = new PivModel();
					List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
					
					//List<Glcompm> province1 = glcompmDao.get(distDiv);
					
					model.setGlcompm(province1);
					
					List<String> provinces = new ArrayList<String>();
					int loop = province1.size() - 1;
					for (int i = 0; i <= loop; i++) {
						System.out.println(i);
						Glcompm ojb = province1.get(i);

						System.out.println(ojb.getCompNm());
						provinces.add(ojb.getCompNm());
						provinceList.put(ojb.getCompId(), ojb.getCompNm());

					}
					
					Map<String, String> eeList = new LinkedHashMap<String, String>();
					List<Sauserm> eeUserList = secDao.getAllUserByRptUser(deptId, "EE");
		int loopEe = eeUserList.size() - 1;
		for (int i = 0; i <= loopEe; i++) {
			//System.out.println(i);
			Sauserm ojb = eeUserList.get(i);
			//System.out.println(ojb.getUserId());
			eeList.put(ojb.getUserId(), ojb.getUserNm());

		}
		model.setEeList(eeList);
model.setListEE(eeUserList);
		Map<String, String> esList = new LinkedHashMap<String, String>();
		List<Sauserm> esUserList = secDao.getAllUserByRptUser(deptId, "ES");
int loopEs = eeUserList.size() - 1;
for (int i = 0; i <= loopEe; i++) {
//System.out.println(i);
Sauserm ojb = esUserList.get(i);
//System.out.println(ojb.getUserId());
esList.put(ojb.getUserId(), ojb.getUserNm());

}
model.setEsList(esList);
model.setListES(esUserList);

	
					// ModelAndView model = new ModelAndView();
					model.setProvinceList(provinceList);
					model.setAreaList(areaList);
					model.setLineList(lineList);
					model.setObjMntPlan(new MmsMntplan());
					String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
					String status = null;

					String phmBranch = (String) request.getSession().getAttribute("deptId");
					deptId = deptId.trim();
					
					List<MmsMntplan> listPlan = mntPlanDao.getActiveList("", "");
					model.setObjMntPlanList(listPlan);
					int supSize = listPlan.size() - 1;
					String stringOfSupportIds = "";
					
					for (int i = 0; i <= supSize; i++) {
						MmsMntplan obj = listPlan.get(i);
						if(i != 0){
							stringOfSupportIds = stringOfSupportIds + "," + Long.toString(obj.getId());
						}else{
							stringOfSupportIds = Long.toString(obj.getId());
						}
					}
					System.out.println("-------------------> stringOfSupportIds: "+stringOfSupportIds);
					
					model.setStringOfSupportIds(stringOfSupportIds);
					
					
					//return new ModelAndView("MMS_MntPlan", "SaveGeneral", model);
					return new ModelAndView("Mnt_Plan", "SaveGeneral", model);
			

				}
			 
			 @RequestMapping(value = "/addPlanS", method = RequestMethod.POST)
				//public ModelAndView addPlanS(HttpServletRequest request,@ModelAttribute("SaveGeneral") PivModel newmodel,ModelMap modelmap) {
			 public ModelAndView addGeneral(@ModelAttribute("SaveGeneral")  PivModel newmodel,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
							
			        Map<String, String> lineList = new LinkedHashMap<String, String>();
		            Map<String, String> areaList = new LinkedHashMap<String, String>();
					Map<String, String> provinceList = new LinkedHashMap<String, String>();
					String userName = (String) request.getSession().getAttribute("loggedUser");
					String deptId = (String) request.getSession().getAttribute("deptId");
					String province = deptDao.getDD(deptId);
					String distDiv = glcompmDao.getDistDivision(province);
					PivModel model = new PivModel();
					System.out.println("test"+newmodel.getFromDate());
					System.out.println("test1"+newmodel.getToDate());
					
					
					
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
					Date startDate;
					Date endDate;
					try {
					    startDate = df.parse(newmodel.getFromDate());
					    endDate = df.parse(newmodel.getToDate());
					    
					    newmodel.getObjMntPlan().setFromDate(startDate);
						newmodel.getObjMntPlan().setToDate(endDate);
					} catch (ParseException e) {
					    e.printStackTrace();
					}
					
									
					List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
					newmodel.getObjMntPlan().setDd(province);
					
					newmodel.getObjMntPlan().setPhmBranch(deptId);
					mntPlanDao.save(newmodel.getObjMntPlan());
					List<String> provinces = new ArrayList<String>();
					int loop = province1.size() - 1;
					for (int i = 0; i <= loop; i++) {
						System.out.println(i);
						Glcompm ojb = province1.get(i);

						System.out.println(ojb.getCompNm());
						provinces.add(ojb.getCompNm());
						provinceList.put(ojb.getCompId(), ojb.getCompNm());

					}
					
					Map<String, String> eeList = new LinkedHashMap<String, String>();
					List<Sauserm> eeUserList = secDao.getAllUserByRptUser(deptId, "EE");
		int loopEe = eeUserList.size() - 1;
		for (int i = 0; i <= loopEe; i++) {
			//System.out.println(i);
			Sauserm ojb = eeUserList.get(i);
			//System.out.println(ojb.getUserId());
			eeList.put(ojb.getUserId(), ojb.getUserNm());

		}
		model.setEeList(eeList);

		Map<String, String> esList = new LinkedHashMap<String, String>();
		List<Sauserm> esUserList = secDao.getAllUserByRptUser(deptId, "ES");
int loopEs = eeUserList.size() - 1;
for (int i = 0; i <= loopEe; i++) {
//System.out.println(i);
Sauserm ojb = esUserList.get(i);
//System.out.println(ojb.getUserId());
esList.put(ojb.getUserId(), ojb.getUserNm());

}
model.setEsList(esList);

	
					// ModelAndView model = new ModelAndView();
					model.setProvinceList(provinceList);
					model.setAreaList(areaList);
					model.setLineList(lineList);
					model.setObjMntPlan(new MmsMntplan());
					String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
					String status = null;

					String phmBranch = (String) request.getSession().getAttribute("deptId");
					deptId = deptId.trim();
					
					List<MmsMntplan> listPlan = mntPlanDao.getActiveList("", "");
					model.setObjMntPlanList(listPlan);
					int supSize = listPlan.size() - 1;
					String stringOfSupportIds = "";
					
					for (int i = 0; i <= supSize; i++) {
						MmsMntplan obj = listPlan.get(i);
						if(i != 0){
							stringOfSupportIds = stringOfSupportIds + "," + Long.toString(obj.getId());
						}else{
							stringOfSupportIds = Long.toString(obj.getId());
						}
					}
					System.out.println("-------------------> stringOfSupportIds: "+stringOfSupportIds);
					
					model.setStringOfSupportIds(stringOfSupportIds);
					
					model.setGlcompm(province1);
					model.setListEE(eeUserList);

					model.setListES(esUserList);

					modelmap.addAttribute("SUCCESS_MESSAGE", "Saved Successfully");
					
					return new ModelAndView("MMS_MntPlan", "SaveGeneral", model);
					

				}
			 
			 @RequestMapping(value = "/getPlanDetails",method = RequestMethod.GET, produces = "application/json")
			 public @ResponseBody List<MmsMntplan> getPlanDetails(HttpServletRequest request){
				 return mntPlanDao.getActiveList("", "");
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
			