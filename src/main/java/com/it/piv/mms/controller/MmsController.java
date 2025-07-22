package com.it.piv.mms.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.it.piv.issue.domain.PivModel;
import com.it.piv.issue.repo.JasperDao;
import com.it.piv.mms.domain.Applicant;
import com.it.piv.mms.domain.Application;
import com.it.piv.mms.domain.ApplicationObject;
import com.it.piv.mms.domain.ApplicationPK;
import com.it.piv.mms.domain.Approval;
import com.it.piv.mms.domain.ApprovalMm;
import com.it.piv.mms.domain.Glcompm;
import com.it.piv.mms.domain.Gldeptm;
import com.it.piv.mms.domain.MmsAddconductortype;
import com.it.piv.mms.domain.MmsAddfeeder;
import com.it.piv.mms.domain.MmsAddfeederPK;
import com.it.piv.mms.domain.MmsAddgantry;
import com.it.piv.mms.domain.MmsAddline;
import com.it.piv.mms.domain.MmsAddlinetype;
import com.it.piv.mms.domain.MmsAddsupport;
import com.it.piv.mms.domain.MmsAddsupporttype;
import com.it.piv.mms.domain.MmsAddswitch;
import com.it.piv.mms.domain.MmsAddswitchPK;
import com.it.piv.mms.domain.MmsArea;
import com.it.piv.mms.domain.MmsCsc;
import com.it.piv.mms.domain.MmsGantryloc;
import com.it.piv.mms.domain.MmsGantrylocPK;
import com.it.piv.mms.domain.MmsInspection;
import com.it.piv.mms.domain.MmsTowermaintenance;
import com.it.piv.mms.domain.MmsTowermaintenancePK;
import com.it.piv.mms.domain.MmsTowertype;
import com.it.piv.mms.domain.MmsTxntowermaintenance;
import com.it.piv.mms.domain.MmsTxntowermaintenancePK;
import com.it.piv.mms.domain.MmsTxntowermntcomplesion;
import com.it.piv.mms.domain.MmsTxntowermntcomplesionPK;
import com.it.piv.mms.domain.Msttowertype;
import com.it.piv.mms.domain.MvmmsCycle;
import com.it.piv.mms.domain.PcbModel;
import com.it.piv.mms.domain.Pcestdtt;
import com.it.piv.mms.domain.PcestdttPK;
import com.it.piv.mms.domain.Pcesthtt;
import com.it.piv.mms.domain.PcesthttPK;
import com.it.piv.mms.domain.RequestObject;
import com.it.piv.mms.domain.ResponseObject;
import com.it.piv.mms.domain.Summary;
import com.it.piv.mms.domain.TowerModel;
import com.it.piv.mms.domain.TrippingData;
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
import com.it.piv.mms.repo.SpestedyConDao;
import com.it.piv.mms.repo.SpstdesthmtDao;
import com.it.piv.mms.repo.TrippingDataDao;
import com.it.piv.mms.domain.MmsProvince;
import com.it.piv.mms.repo.ProvinceDao;
import com.it.piv.util.common.Format;
import com.it.piv.util.common.MailMail;
import com.it.piv.util.common.PathMMS;
import com.it.piv.mms.domain.SpestedyCon;
import com.it.piv.mms.domain.SpestedyConPK;
import com.it.piv.mms.domain.PieChartModel.KeyValue;
import com.it.piv.mms.domain.ApplicationObject;

@Controller
public class MmsController {
	
	//edited anushka 2019-01-10 --------------------------------------------------------------------------------
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
	
	
	@Autowired
	private ApprovalMmDao  mmDao;
	
	
	
	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static final DateFormat dateNow = new SimpleDateFormat("yyyy-MM-dd");
	
	/**@RequestMapping(value = "/AddComplain",method = RequestMethod.POST)
	public String registerNewCustomer(@Valid @ModelAttribute("newComplain") ComData newComplain,BindingResult result, Model model) {
		//model.addAttribute("action", "AddCustomer");
		if (!result.hasErrors()) {
			String resultobj = objComplainDao.addComplain(newComplain);
			return "redirect:/Complain";
		} else {
			//model.addAttribute("applicants", applicantdao.FindAllByFirstname());
			return "Complain";
		}
		
	}*/
	
	
	/**@RequestMapping(value = "/MMSSaveLineNew/{mmsAddline}", method = RequestMethod.POST)
	 public String MMSSaveLine(@PathVariable("mmsAddline") MmsAddline mmsAddline) throws Exception{
		 System.out.println("Test2 ");    
		addLine.addLine(mmsAddline);
		    return "null";
	}*/
	
	@RequestMapping(value="addTowerMntTest/{towerNo}/{numberOfTappings}", method=RequestMethod.GET, produces="application/json")
   	public @ResponseBody String addTowerMnt(@PathVariable("towerNo") String towerNo,@PathVariable("numberOfTappings") String numberOfTappings) {
		System.out.println("towerNo " + towerNo);
		System.out.println("NumberOfTappings " + numberOfTappings);
		//System.out.println("NumberOfMissingParts " + numberOfMissingParts);
		//System.out.println("NumberOfFlashOverSets " + numberOfFlashOverSets);
		//System.out.println("SpinnerLeavingStatus " + spinnerLeavingStatus);
		//System.out.println("SpinnerBaseConcreteStatus " + spinnerBaseConcreteStatus);
		//System.out.println("SpinnerAntiClimbingStatus " + spinnerAntiClimbingStatus);
		//System.out.println("SpinnerConductorCondition " + spinnerConductorCondition);
		//System.out.println("SpinnerJumperCondition " + spinnerJumperCondition);
		//System.out.println("SpinnerEarthConductorCondition " + spinnerEarthConductorCondition);
		//System.out.println("SpinnerMaintainanceAttention " + spinnerMaintainanceAttention);
		//System.out.println("SpinnerLegPainting " + spinnerLegPainting);
		//System.out.println("SpinnerHotLineMaintenance " + spinnerHotLineMaintenance);
		//System.out.println("FungusSet " + fungusSet);
		//System.out.println("wPinSet " + wPinSet);
		//System.out.println("EndFittingSet " + endFittingSet);
		//System.out.println("specialObservations " + specialObservations);
		
		 /**NumberOfTappings = (EditText) findViewById(R.id.etNumberOFTappings);
	        NumberOfMissingParts =  (EditText) findViewById(R.id.etMissingParts);
	        NumberOfFlashOverSets=  (Spinner) findViewById(R.id.etFlashOverSets);
	        SpinnerLeavingStatus =  (Spinner) findViewById(R.id.SpinnerLeavingStatus);
	        SpinnerBaseConcreteStatus =  (Spinner) findViewById(R.id.SpinnerBaseConcreteStatus1);
	        SpinnerAntiClimbingStatus =  (Spinner) findViewById(R.id.SpinnerAntiClimbingStatus1);
	        SpinnerConductorCondition =  (Spinner) findViewById(R.id.SpinnerConductorCondition);
	        SpinnerJumperCondition =  (Spinner) findViewById(R.id.SpinnerJumperCondition1);
	        SpinnerEarthConductorCondition =  (Spinner) findViewById(R.id.SpinnerEarthConductorCondition1);
	        SpinnerJumperCondition =  (Spinner) findViewById(R.id.SpinnerJumperCondition1);
	        SpinnerMaintainanceAttention =  (Spinner) findViewById(R.id.SpinnerMaintainanceAttention1);
	        SpinnerSpObservaion =  (Spinner) findViewById(R.id.spinnerSpecialObserve);
	        SpinnerLegPainting = (Spinner) findViewById(R.id.spinnerLegPainting);
	        SpinnerHotLineMaintenance = (Spinner) findViewById(R.id.spinnerHotLineMain);
	         //FlashOverSetNumber = (EditText) findViewById(R.id.etFlashOverSetNo);
	        FungusSet = (Spinner)findViewById(R.id.etFungusSet);
	        WPinSet = (Spinner)findViewById(R.id.etWPinSet);
	        EndFittingSet = (Spinner)findViewById(R.id.etEndFittingSet);
	        SpecialObservations = (EditText) findViewById(R.id.etSpecialObserve);*/
        
		//objComplainDao.addComplainByCustomer(acctno, complain, longitute, latitute);
		//JobAssign obj = new JobAssign();
		//obj.setCcCode("12");
		return "hiii";
	}
	
	@RequestMapping(value="addSupportDB/{area}/{bodyExtension}/{conductorType}/{deptId}/{earthConductorType}/{gpsLatitude}/{gpsLongitude}/{lineId}/{supportType}/{towerConfiguration}/{towerNo}/{towerType}/{numberOfCercuite}/{phmBranch}/", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody String addSupportDB(@PathVariable("area") String area,@PathVariable("bodyExtension") String bodyExtension,@PathVariable("conductorType") String conductorType,
   			@PathVariable("deptId") String deptId,@PathVariable("earthConductorType") String earthConductorType,
   			@PathVariable("gpsLatitude") String gpsLatitude,@PathVariable("gpsLongitude") String gpsLongitude,
   			@PathVariable("lineId") String lineId,@PathVariable("supportType") String supportType,
   			@PathVariable("towerConfiguration") String towerConfiguration,@PathVariable("towerNo") String towerNo,
   			@PathVariable("towerType") String towerType,@PathVariable("numberOfCercuite") String numberOfCercuite,@PathVariable("phmBranch") String phmBranch) {
		try{
		System.out.println("area " + area);
		area = area.substring(0, 3);
		System.out.println("area1 " + area);
		System.out.println("towerNo " + towerNo);
		System.out.println("bodyExtension " + bodyExtension);
		System.out.println("conductorType " + conductorType);
		conductorType = conductorType.substring(0, 1);
		System.out.println("conductorType2 " + conductorType);
		System.out.println("deptId " + deptId);
		deptId = deptId.substring(0, 6);
		System.out.println("deptId1 " + deptId);
		System.out.println("earthConductorType " + earthConductorType);
		System.out.println("gpsLatitude " + gpsLatitude);
		System.out.println("gpsLongitude " + gpsLongitude);
		System.out.println("lineId " + lineId);
		System.out.println("supportType " + supportType);
		
		/*if(supportType.equalsIgnoreCase("Tower")){
			supportType = "1";
		}else{
			supportType = "2";
		}*/
		System.out.println("towerConfiguration " + towerConfiguration);
		//towerConfiguration = towerConfiguration.substring(0, 1);
		System.out.println("towerNo " + towerNo);
		System.out.println("towerType " + towerType);
		//towerType = towerType.substring(0, 1);
		MmsAddsupport obj = new MmsAddsupport();
		obj.setArea(area+".00");
		obj.setTowerNo(towerNo);
		obj.setBodyExtension(bodyExtension);
		obj.setConductorType(new BigDecimal(conductorType));
		obj.setPhmBranch(deptId);
		obj.setEarthConductorType(new BigDecimal("1"));
		obj.setGpsLatitude(new BigDecimal(gpsLatitude));
		obj.setGpsLongitude(new BigDecimal(gpsLongitude));		
		//String id = addLine.findIdByName(lineId);
		obj.setLineId(new BigDecimal(lineId));
		obj.setSupportType(new BigDecimal(supportType));
		obj.setTowerConfiguration(new BigDecimal(towerConfiguration));
		obj.setTowerType(new BigDecimal(towerType));
		obj.setNoOfCircuits(new BigDecimal(numberOfCercuite));
		obj.setPhmBranch(phmBranch);
		obj.setStatus(new BigDecimal("2"));
		System.out.println("addSupport");
		String resultobj = addSupport.addSupport(obj);
		return "Y";
	}catch(Exception e){
		return "N";
	}
	}
	
	
	
	@RequestMapping(value="addSupportDBNew/{area}/{bodyExtension}/{conductorType}/{deptId}/{earthConductorType}/{gpsLatitude}/{gpsLongitude}/{lineId}/{supportType}/{towerConfiguration}/{towerNo}/{towerType}/{numberOfCercuite}/{phmBranch}/{image}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody String addSupportDBNew(@PathVariable("area") String area,@PathVariable("bodyExtension") String bodyExtension,@PathVariable("conductorType") String conductorType,
   			@PathVariable("deptId") String deptId,@PathVariable("earthConductorType") String earthConductorType,
   			@PathVariable("gpsLatitude") String gpsLatitude,@PathVariable("gpsLongitude") String gpsLongitude,
   			@PathVariable("lineId") String lineId,@PathVariable("supportType") String supportType,
   			@PathVariable("towerConfiguration") String towerConfiguration,@PathVariable("towerNo") String towerNo,
   			@PathVariable("towerType") String towerType,@PathVariable("numberOfCercuite") String numberOfCercuite,@PathVariable("phmBranch") String phmBranch,@PathVariable("image") String image) {
		try{
		System.out.println("area " + area);
		area = area.substring(0, 3);
		System.out.println("area1 " + area);
		System.out.println("towerNo " + towerNo);
		System.out.println("bodyExtension " + bodyExtension);
		System.out.println("conductorType " + conductorType);
		conductorType = conductorType.substring(0, 1);
		System.out.println("conductorType2 " + conductorType);
		System.out.println("deptId " + deptId);
		deptId = deptId.substring(0, 6);
		System.out.println("deptId1 " + deptId);
		System.out.println("earthConductorType " + earthConductorType);
		System.out.println("gpsLatitude " + gpsLatitude);
		System.out.println("gpsLongitude " + gpsLongitude);
		System.out.println("lineId " + lineId);
		System.out.println("supportType " + supportType);
		
		/*if(supportType.equalsIgnoreCase("Tower")){
			supportType = "1";
		}else{
			supportType = "2";
		}*/
		System.out.println("towerConfiguration " + towerConfiguration);
		//towerConfiguration = towerConfiguration.substring(0, 1);
		System.out.println("towerNo " + towerNo);
		System.out.println("towerType " + towerType);
		//towerType = towerType.substring(0, 1);
		MmsAddsupport obj = new MmsAddsupport();
		obj.setArea(area+".00");
		obj.setTowerNo(towerNo);
		obj.setBodyExtension(bodyExtension);
		obj.setConductorType(new BigDecimal(conductorType));
		obj.setPhmBranch(deptId);
		obj.setEarthConductorType(new BigDecimal("1"));
		obj.setGpsLatitude(new BigDecimal(gpsLatitude));
		obj.setGpsLongitude(new BigDecimal(gpsLongitude));		
		//String id = addLine.findIdByName(lineId);
		obj.setLineId(new BigDecimal(lineId));
		obj.setSupportType(new BigDecimal(supportType));
		obj.setTowerConfiguration(new BigDecimal(towerConfiguration));
		obj.setTowerType(new BigDecimal(towerType));
		obj.setNoOfCircuits(new BigDecimal(numberOfCercuite));
		obj.setPhmBranch(phmBranch);
		obj.setStatus(new BigDecimal("2"));
		obj.setFilepath(image);
		System.out.println("addSupport");
	/*	Blob blob = new javax.sql.rowset.serial.SerialBlob(image.getBytes());
		InputStream inputStream = blob.getBinaryStream();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}
		
		byte[] imageBytes = outputStream.toByteArray();
		String base64Image = DatatypeConverter.printBase64Binary(imageBytes);
		//String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		
		inputStream.close();
		outputStream.close();
		*//********************************************//*
		
		obj.setBase64Image(base64Image);  //to set image in web page
		
	*/	
		
		
		String resultobj = addSupport.addSupport(obj);
		return "Y";
	}catch(Exception e){
		return "N";
	}
	}
	
	
	
	
	@RequestMapping(value="addLineDB/{code}/{area}/{name}/{type}/{length}/{noofpoles}/{nooftowers}/{phmbranch}/{comdate}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody String addLineDB(@PathVariable("code") String code,@PathVariable("area") String area,@PathVariable("name") String name,@PathVariable("type") String type,@PathVariable("length") String length,@PathVariable("noofpoles") String noofpoles,@PathVariable("nooftowers") String nooftowers,@PathVariable("phmbranch") String phmbranch,@PathVariable("comdate") String comdate) {
		
		try{
		System.out.println("code " + code);
		System.out.println("area " + area);
		System.out.println("name " + name);
		System.out.println("type " + type);
		System.out.println("length " + length);
		System.out.println("noofpoles " + noofpoles);
		MmsAddline obj = new MmsAddline();
		obj.setCode(code);
		obj.setArea(area);
		obj.setLineName(name);
		obj.setLineType(type);
		obj.setLength(new BigDecimal(length));
		obj.setNoofpoles(new BigDecimal(noofpoles));
		obj.setNooftowers(new BigDecimal(nooftowers));
		obj.setStatus(new BigDecimal("2"));
		obj.setPhmBranch(phmbranch);
		//obj.setConductorType(new BigDecimal(conductorType));
		//obj.setCircuitType(new BigDecimal(circuitType));
		
		Date dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(comdate);
		//String currentDate = dateNow.format(date);
		
		obj.setComdate(dateNow);System.out.println("addLine");
		String resultobj = addLine.addLine(obj);		
		return "Y";
		}catch(Exception e){
			return "N";
		}
	}
	
	
	
	
	@RequestMapping(value="addLineDBNew/{code}/{area}/{name}/{type}/{length}/{noofpoles}/{nooftowers}/{phmbranch}/{comdate}/{conductorType}/{circuitType}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody String addLineDBNew(@PathVariable("code") String code,@PathVariable("area") String area,@PathVariable("name") String name,@PathVariable("type") String type,@PathVariable("length") String length,@PathVariable("noofpoles") String noofpoles,@PathVariable("nooftowers") String nooftowers,@PathVariable("phmbranch") String phmbranch,@PathVariable("comdate") String comdate,@PathVariable("conductorType") String conductorType,@PathVariable("circuitType") String circuitType) {
		
		try{
		System.out.println("code " + code);
		System.out.println("area " + area);
		System.out.println("name " + name);
		System.out.println("type " + type);
		System.out.println("length " + length);
		System.out.println("noofpoles " + noofpoles);
		MmsAddline obj = new MmsAddline();
		obj.setCode(code);
		obj.setArea(area);
		obj.setLineName(name);
		obj.setLineType(type);
		obj.setLength(new BigDecimal(length));
		obj.setNoofpoles(new BigDecimal(noofpoles));
		obj.setNooftowers(new BigDecimal(nooftowers));
		obj.setStatus(new BigDecimal("2"));
		obj.setPhmBranch(phmbranch);
		obj.setConductorType(new Float(conductorType));
		obj.setCircuitType(new BigDecimal(circuitType));
		
		Date dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(comdate);
		//String currentDate = dateNow.format(date);
		
		obj.setComdate(dateNow);System.out.println("addLine");
		String resultobj = addLine.addLine(obj);		
		return "Y";
		}catch(Exception e){
			return "N";
		}
	}
	
	
	
	@RequestMapping(value="addLineDBNewNew/{code}/{area}/{name}/{type}/{length}/{noofpoles}/{nooftowers}/{phmbranch}/{comdate}/{conductorType}/{circuitType}/{feeder}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody String addLineDBNewNew(@PathVariable("code") String code,@PathVariable("area") String area,@PathVariable("name") String name,@PathVariable("type") String type,@PathVariable("length") String length,@PathVariable("noofpoles") String noofpoles,@PathVariable("nooftowers") String nooftowers,@PathVariable("phmbranch") String phmbranch,@PathVariable("comdate") String comdate,@PathVariable("conductorType") String conductorType,@PathVariable("circuitType") String circuitType,@PathVariable("feeder") String feeder) {
		
		try{
		System.out.println("code " + code);
		System.out.println("area " + area);
		System.out.println("name " + name);
		System.out.println("type " + type);
		System.out.println("length " + length);
		System.out.println("noofpoles " + noofpoles);
		MmsAddline obj = new MmsAddline();
		obj.setCode(code);
		obj.setArea(area);
		obj.setLineName(name);
		obj.setLineType(type);
		obj.setLength(new BigDecimal(length));
		obj.setNoofpoles(new BigDecimal(noofpoles));
		obj.setNooftowers(new BigDecimal(nooftowers));
		obj.setStatus(new BigDecimal("2"));
		obj.setPhmBranch(phmbranch);
		obj.setConductorType(new Float(conductorType));
		obj.setCircuitType(new BigDecimal(circuitType));
		obj.setFeederIdentification(feeder);
		Date dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(comdate);
		//String currentDate = dateNow.format(date);
		
		obj.setComdate(dateNow);System.out.println("addLine");
		String resultobj = addLine.addLine(obj);		
		return "Y";
		}catch(Exception e){
			return "N";
		}
	}
	
	
	
	@RequestMapping(value="getTowerMntData", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody MmsTxntowermaintenance getTowerMntData(@RequestParam("visitid") Long visitid,@RequestParam("towerid") Long towerid){
		MmsTxntowermaintenancePK obj = new MmsTxntowermaintenancePK();
		System.out.print("hiiii");
		obj.setVisitid(visitid);
		obj.setTowerid(towerid);
		return towerTxtMaintenance.findByID(obj);
	}
	
	
	@RequestMapping(value="getTowerMntDataForLatestCycle", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody ModelAndView getTowerMntDataForLatestCycle(@RequestParam("towerid") Long towerid,@RequestParam("area") String area){
		MmsTxntowermaintenancePK obj = new MmsTxntowermaintenancePK();
		System.out.print("hiiii");
		List<Long> cycleList = cycleDao.fineMntAvailCycle(area);
		System.out.print("cycle :"+String.valueOf(cycleList.get(0)));
		MmsAddsupport support = addSupport.findById(towerid);
		MmsAddline line = null;
		if(support != null){
			line = addLine.findById(support.getLineId().longValue());
		}
		ApprovalModel model = new ApprovalModel();
		obj.setVisitid(cycleList.get(0));
		obj.setTowerid(towerid);
		MmsTxntowermaintenance mnt = towerTxtMaintenance.findByID(obj);
		model.setMnt(mnt);
		model.setSupport(support);
		model.setLine(line);
		return new ModelAndView("TowerCondition", "model", model);
		
	}
	
	
	
	@RequestMapping(value="getRequestDetail", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody ModelAndView getRequestDetail(@RequestParam("id") String id){
		ApprovalMm obj = new ApprovalMm();
		obj= mmDao.findByID(id);
		System.out.println("obj : " + obj);
		ApprovalModel model = new ApprovalModel();
		model.setApprovalMmObj(obj);
		return new ModelAndView("RequestCondition", "model", model);
		
	}
	
	
	
	@RequestMapping(value="addTowerMnt/{visitId}/{towerNo}/{numberOfTappings}/{numberOfMissingParts}/{numberOfFlashOverSets}/{spinnerLeavingStatus}/{spinnerBaseConcreteStatus}/{spinnerAntiClimbingStatus}/{spinnerConductorCondition}/{spinnerJumperCondition}/{spinnerEarthConductorCondition}/{spinnerMaintainanceAttention}/{spinnerLegPainting}/{spinnerHotLineMaintenance}/{fungusSet}/{wPinSet}/{endFittingSet}/{specialObservations}/{area}/{line}/{noofpinpole1}/{swd1}/{noofpinpole2}/{swd2}/{noofpinpole3}/{swd3}", method=RequestMethod.GET, produces="application/json")
   	public @ResponseBody String addTowerMnt(@PathVariable("visitId") String visitId,@PathVariable("towerNo") String towerNo,@PathVariable("numberOfTappings") String numberOfTappings,
   			@PathVariable("numberOfMissingParts") String numberOfMissingParts,@PathVariable("numberOfFlashOverSets") String numberOfFlashOverSets,
   			@PathVariable("spinnerLeavingStatus") String spinnerLeavingStatus,@PathVariable("spinnerBaseConcreteStatus") String spinnerBaseConcreteStatus,
   			@PathVariable("spinnerAntiClimbingStatus") String spinnerAntiClimbingStatus,@PathVariable("spinnerConductorCondition") String spinnerConductorCondition,
   			@PathVariable("spinnerJumperCondition") String spinnerJumperCondition,@PathVariable("spinnerEarthConductorCondition") String spinnerEarthConductorCondition,
   			@PathVariable("spinnerMaintainanceAttention") String spinnerMaintainanceAttention,@PathVariable("spinnerLegPainting") String spinnerLegPainting,
   			@PathVariable("spinnerHotLineMaintenance") String spinnerHotLineMaintenance,
   			@PathVariable("fungusSet") String fungusSet,@PathVariable("wPinSet") String wPinSet,@PathVariable("endFittingSet") String endFittingSet,
   			@PathVariable("specialObservations") String specialObservations,@PathVariable("area") String area,@PathVariable("line") String line,
   			@PathVariable("noofpinpole1") String noofpinpole1,@PathVariable("swd1") String swd1,
   			@PathVariable("noofpinpole2") String noofpinpole2,@PathVariable("swd2") String swd2,
   			@PathVariable("noofpinpole3") String noofpinpole3,@PathVariable("swd3") String swd3) {
		System.out.println("visitId " + visitId);
		System.out.println("towerNo " + towerNo);
		System.out.println("NumberOfTappings " + numberOfTappings);
		System.out.println("NumberOfMissingParts " + numberOfMissingParts);
		System.out.println("NumberOfFlashOverSets " + numberOfFlashOverSets);
		System.out.println("SpinnerLeavingStatus " + spinnerLeavingStatus);
		System.out.println("SpinnerBaseConcreteStatus " + spinnerBaseConcreteStatus);
		System.out.println("SpinnerAntiClimbingStatus " + spinnerAntiClimbingStatus);
		System.out.println("SpinnerConductorCondition " + spinnerConductorCondition);
		System.out.println("SpinnerJumperCondition " + spinnerJumperCondition);
		System.out.println("SpinnerEarthConductorCondition " + spinnerEarthConductorCondition);
		System.out.println("SpinnerMaintainanceAttention " + spinnerMaintainanceAttention);
		System.out.println("SpinnerLegPainting " + spinnerLegPainting);
		System.out.println("SpinnerHotLineMaintenance " + spinnerHotLineMaintenance);
		System.out.println("FungusSet " + fungusSet);
		System.out.println("wPinSet " + wPinSet);
		System.out.println("EndFittingSet " + endFittingSet);
		System.out.println("specialObservations " + specialObservations);
		System.out.println("area " + area);
		System.out.println("line " + line);
		try {
		MmsTxntowermaintenance obj = new MmsTxntowermaintenance();
		MmsTxntowermaintenancePK objPK = new MmsTxntowermaintenancePK();
		MmsTxntowermaintenance objExisting = null;
		
		
		String towerID = addSupport.getTowerIDByTowerNo(towerNo);
		System.out.println("towerID true or false : " + towerID.equalsIgnoreCase(""));
		if(towerID.equalsIgnoreCase("")){
			System.out.println("towerID : " + towerID);
			return "1";
		}
		
		System.out.println("towerID " + towerID);
		objPK.setVisitid(Long.parseLong(visitId));
		objPK.setTowerid(Long.parseLong(towerID));
		obj.setId(objPK);
		
		objExisting = towerTxtMaintenance.findByID(objPK);
		
		
		//obj.setTowerNo(towerNo);
		//obj.setDeptId("600.41");
		obj.setNooftappings(new BigDecimal(numberOfTappings));
		obj.setNoofmissingparts(new BigDecimal(numberOfMissingParts));
		//obj.setFlashoversetno(numberOfFlashOverSets);
		obj.setNofflashoversets(new BigDecimal(numberOfFlashOverSets));
		
		obj.setWayleavestatus(spinnerLeavingStatus);
		obj.setBaseconcretestatus(spinnerBaseConcreteStatus);
		obj.setAnticlimbingstatus(spinnerAntiClimbingStatus);
		obj.setConductorstatus(spinnerConductorCondition);
		obj.setJumperstatus(spinnerJumperCondition);
		obj.setEarthconductorstatus(spinnerEarthConductorCondition);
		obj.setAttentionstatus(spinnerMaintainanceAttention);
		obj.setComments(specialObservations);
		obj.setEndfittingset(new BigDecimal(endFittingSet));
		obj.setFungussetno(new BigDecimal(fungusSet));
		spinnerHotLineMaintenance =spinnerHotLineMaintenance.trim();
		if(spinnerHotLineMaintenance.equals("Possible")){
			obj.setHotpossible(new BigDecimal("1"));
		}else{
			obj.setHotpossible(new BigDecimal("0"));
			
		}
		//obj.setHotLineMnt(spinnerHotLineMaintenance);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Calendar.getInstance().getTime();        
		String reportDate = df.format(today);
		Date dateNow=null;
		
		dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);
		
		//String currentDate = dateNow.format(date);
		
		obj.setInsDate(dateNow);
		obj.setLegPainting(spinnerLegPainting);
		//obj.setLudt(dateNow);
		obj.setMaintenancedate(dateNow);
		obj.setPinpole1(new BigDecimal(noofpinpole1));
		obj.setPinpole2(new BigDecimal(noofpinpole2));
		obj.setPinpole3(new BigDecimal(noofpinpole3));
		obj.setSwitchdev1(swd1);
		obj.setSwitchdev2(swd2);
		obj.setSwitchdev3(swd3);
		obj.setPinpole2(new BigDecimal(noofpinpole2));
		obj.setWpinset(new BigDecimal(wPinSet));
		obj.setTowerspecial(specialObservations);
		obj.setStatus(new BigDecimal(Util.IN_BULK));
		obj.setApprovalLevel("60041ES1");
		obj.setCycle(visitId);
		//obj.setPinpole3(new BigDecimal(noofpinpole3));
		//obj.set(spinnerMaintainanceAttention);
		if(objExisting == null){
			System.out.println("new");
			String resultobj = towerTxtMaintenance.addTowerMaintananceData(obj);
			return "NEW";
		}
		else{
			System.out.println("update");
			String resultobj1 = towerTxtMaintenance.update(obj);
			return "UPDATE";
		}
		
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error ; " + e.getMessage());
			
		}
		return "hiii";
	}
	
	
	

	
	
	@RequestMapping(value="addTowerMntNew/{visitId}/{towerNo}/{numberOfTappings}/{numberOfMissingParts}/{numberOfFlashOverSets}/{spinnerLeavingStatus}/{spinnerBaseConcreteStatus}/{spinnerAntiClimbingStatus}/{spinnerConductorCondition}/{spinnerJumperCondition}/{spinnerEarthConductorCondition}/{spinnerMaintainanceAttention}/{spinnerLegPainting}/{spinnerHotLineMaintenance}/{fungusSet}/{wPinSet}/{endFittingSet}/{specialObservations}/{area}/{line}/{noofpinpole1}/{swd1}/{noofpinpole2}/{swd2}/{noofpinpole3}/{swd3}/{deptid}", method=RequestMethod.GET, produces="application/json")
   	public @ResponseBody String addTowerMntNew(@PathVariable("visitId") String visitId,@PathVariable("towerNo") String towerNo,@PathVariable("numberOfTappings") String numberOfTappings,
   			@PathVariable("numberOfMissingParts") String numberOfMissingParts,@PathVariable("numberOfFlashOverSets") String numberOfFlashOverSets,
   			@PathVariable("spinnerLeavingStatus") String spinnerLeavingStatus,@PathVariable("spinnerBaseConcreteStatus") String spinnerBaseConcreteStatus,
   			@PathVariable("spinnerAntiClimbingStatus") String spinnerAntiClimbingStatus,@PathVariable("spinnerConductorCondition") String spinnerConductorCondition,
   			@PathVariable("spinnerJumperCondition") String spinnerJumperCondition,@PathVariable("spinnerEarthConductorCondition") String spinnerEarthConductorCondition,
   			@PathVariable("spinnerMaintainanceAttention") String spinnerMaintainanceAttention,@PathVariable("spinnerLegPainting") String spinnerLegPainting,
   			@PathVariable("spinnerHotLineMaintenance") String spinnerHotLineMaintenance,
   			@PathVariable("fungusSet") String fungusSet,@PathVariable("wPinSet") String wPinSet,@PathVariable("endFittingSet") String endFittingSet,
   			@PathVariable("specialObservations") String specialObservations,@PathVariable("area") String area,@PathVariable("line") String line,
   			@PathVariable("noofpinpole1") String noofpinpole1,@PathVariable("swd1") String swd1,
   			@PathVariable("noofpinpole2") String noofpinpole2,@PathVariable("swd2") String swd2,
   			@PathVariable("noofpinpole3") String noofpinpole3,@PathVariable("swd3") String swd3,@PathVariable("deptid") String deptid) {
		System.out.println("visitId " + visitId);
		System.out.println("towerNo " + towerNo);
		System.out.println("NumberOfTappings " + numberOfTappings);
		System.out.println("NumberOfMissingParts " + numberOfMissingParts);
		System.out.println("NumberOfFlashOverSets " + numberOfFlashOverSets);
		System.out.println("SpinnerLeavingStatus " + spinnerLeavingStatus);
		System.out.println("SpinnerBaseConcreteStatus " + spinnerBaseConcreteStatus);
		System.out.println("SpinnerAntiClimbingStatus " + spinnerAntiClimbingStatus);
		System.out.println("SpinnerConductorCondition " + spinnerConductorCondition);
		System.out.println("SpinnerJumperCondition " + spinnerJumperCondition);
		System.out.println("SpinnerEarthConductorCondition " + spinnerEarthConductorCondition);
		System.out.println("SpinnerMaintainanceAttention " + spinnerMaintainanceAttention);
		System.out.println("SpinnerLegPainting " + spinnerLegPainting);
		System.out.println("SpinnerHotLineMaintenance " + spinnerHotLineMaintenance);
		System.out.println("FungusSet " + fungusSet);
		System.out.println("wPinSet " + wPinSet);
		System.out.println("EndFittingSet " + endFittingSet);
		System.out.println("specialObservations " + specialObservations);
		System.out.println("area " + area);
		System.out.println("line " + line);
		try {
		MmsTxntowermaintenance obj = new MmsTxntowermaintenance();
		MmsTxntowermaintenancePK objPK = new MmsTxntowermaintenancePK();
		MmsTxntowermaintenance objExisting = null;
		
		
		String towerID = addSupport.getTowerIDByTowerNo(towerNo);
		System.out.println("towerID true or false : " + towerID.equalsIgnoreCase(""));
		if(towerID.equalsIgnoreCase("")){
			System.out.println("towerID : " + towerID);
			return "1";
		}
		
		System.out.println("towerID " + towerID);
		objPK.setVisitid(Long.parseLong(visitId));
		objPK.setTowerid(Long.parseLong(towerID));
		obj.setId(objPK);
		
		objExisting = towerTxtMaintenance.findByID(objPK);
		
		
		//obj.setTowerNo(towerNo);
		obj.setPhmBranch(deptid);
		obj.setNooftappings(new BigDecimal(numberOfTappings));
		obj.setNoofmissingparts(new BigDecimal(numberOfMissingParts));
		//obj.setFlashoversetno(numberOfFlashOverSets);
		obj.setNofflashoversets(new BigDecimal(numberOfFlashOverSets));
		
		obj.setWayleavestatus(spinnerLeavingStatus);
		obj.setBaseconcretestatus(spinnerBaseConcreteStatus);
		obj.setAnticlimbingstatus(spinnerAntiClimbingStatus);
		obj.setConductorstatus(spinnerConductorCondition);
		obj.setJumperstatus(spinnerJumperCondition);
		obj.setEarthconductorstatus(spinnerEarthConductorCondition);
		obj.setAttentionstatus(spinnerMaintainanceAttention);
		obj.setComments(specialObservations);
		obj.setEndfittingset(new BigDecimal(endFittingSet));
		obj.setFungussetno(new BigDecimal(fungusSet));
		spinnerHotLineMaintenance =spinnerHotLineMaintenance.trim();
		if(spinnerHotLineMaintenance.equals("Possible")){
			obj.setHotpossible(new BigDecimal("1"));
		}else{
			obj.setHotpossible(new BigDecimal("0"));
			
		}
		//obj.setHotLineMnt(spinnerHotLineMaintenance);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Calendar.getInstance().getTime();        
		String reportDate = df.format(today);
		Date dateNow=null;
		
		DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
		String insTime = df2.format(today);
		Date insTimeDate=null;
		
		insTimeDate = new SimpleDateFormat("HH-MM-SS").parse(insTime);
		dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);
		
		//String currentDate = dateNow.format(date);
		
		obj.setInsDate(dateNow);
		//obj.setInsTime(insTimeDate);
		obj.setLegPainting(spinnerLegPainting);
		//obj.setLudt(dateNow);
		obj.setMaintenancedate(dateNow);
		obj.setPinpole1(new BigDecimal(noofpinpole1));
		obj.setPinpole2(new BigDecimal(noofpinpole2));
		obj.setPinpole3(new BigDecimal(noofpinpole3));
		obj.setSwitchdev1(swd1);
		obj.setSwitchdev2(swd2);
		obj.setSwitchdev3(swd3);
		obj.setPinpole2(new BigDecimal(noofpinpole2));
		obj.setWpinset(new BigDecimal(wPinSet));
		obj.setTowerspecial(specialObservations);
		obj.setStatus(new BigDecimal(Util.IN_BULK));
		obj.setApprovalLevel("60041ES1");
		obj.setCycle(visitId);
		//obj.setPinpole3(new BigDecimal(noofpinpole3));
		//obj.set(spinnerMaintainanceAttention);
		if(objExisting == null){
			System.out.println("new");
			String resultobj = towerTxtMaintenance.addTowerMaintananceData(obj);
			return "NEW";
		}
		else{
			System.out.println("update");
			String resultobj1 = towerTxtMaintenance.update(obj);
			return "UPDATE";
		}
		
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error ; " + e.getMessage());
			
		}
		return "hiii";
	}
	
	
	@RequestMapping(value="addComplain/{acctno}", method=RequestMethod.GET, produces="application/json")
   	public @ResponseBody String addComplain(@PathVariable("acctno") MmsAddline acctno) {
		System.out.println("acctno " + acctno); 
		//objComplainDao.addComplainByCustomer(acctno, complain, longitute, latitute);
		//JobAssign obj = new JobAssign();
		//obj.setCcCode("12");
		return "hiii";
	}
	
	
	@RequestMapping(value = "/MMSSaveLine/{mmsAddline}", method=RequestMethod.GET, produces="application/json" )
	 public @ResponseBody String MMSSaveLine(@PathVariable("mmsAddline") MmsAddline mmsAddline) throws Exception{
		 System.out.println("mmsAddline.getArea() " + mmsAddline);    
		 addLine.addLine(mmsAddline);
		 return "hi";
	}
	
	@RequestMapping(value = "/MMSAddLine", method = RequestMethod.GET)
	 public String MMSAddLine() {
		    
		    return "AddLine";
	}
	
	
	@RequestMapping(value = "/MMSAddTowerType", method = RequestMethod.GET)
	 public ModelAndView MMSAddLine(@ModelAttribute("AddTowerType")  Msttowertype newTowerType,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception{
		 String message = "Welcome to Spring 4.0 !";
				//String resultobj = lineDao.addTowerTypw(newTowerType);
		 
				return new ModelAndView("AddTowerType", "message", message);
				//			return new ModelAndView("AddTowerType", "message", message);
			//}
	
		   //return "AddTowerType";
	}
	
	
	@RequestMapping(value = "/MMSAddToType", method = RequestMethod.POST)
	 public ModelAndView MMSAddTowerType(@ModelAttribute("AddTowerType")  MmsTowertype newTowerType,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception {
		 String message = "Welcome to Spring 4.0 !";
		 System.out.println("Test1");
		 if (!bindingResult.hasErrors()) {
			 System.out.println("Test2" + newTowerType.getId());
			 System.out.println("Test2" + newTowerType.getName());
			    
				String resultobj = towerDao.addTowerTypw(newTowerType);
				System.out.println("Test3");
				 
				return new ModelAndView("AddTowerType", "message", message);
			} else {
				System.out.println("Test4");
				 
				return new ModelAndView("AddTowerType", "message", message);
			}
	
		   //return "AddTowerType";
	}
	
	
	@RequestMapping(value = "/addProvince", method = RequestMethod.GET)
	 public ModelAndView MMSAddProvince(@ModelAttribute("ProvinceSave")  MmsProvince newProvince,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception{
		 String message = "Welcome to Spring 4.0 !";
				return new ModelAndView("MMS_addProvince", "message", message);
				
	}
	
	@RequestMapping(value = "/addTripping", method = RequestMethod.GET)
	 public ModelAndView addTripping(@ModelAttribute("model")  PivModel model,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception{
		 String message = "Welcome to Spring 4.0 !";
		 String deptId = request.getSession().getAttribute("deptId").toString();
		 System.out.println("deptId : "+deptId);
		 PivModel models = new PivModel();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			
			String province = deptDao.getDD(deptId);
			System.out.println("province : "+province);
			Glcompm distDiv = glcompmDao.getDistDivision2(province);
			System.out.println("province : "+distDiv.getCompId() +  distDiv.getCompNm());
			TrippingData objTripping = new TrippingData();
			provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
			models.setProvinceList(provinceList);
			models.setObjTripping(objTripping);
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId().trim());
			int depLoop = deptTm.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				System.out.println("Area :" + i);
				Gldeptm ojb = (Gldeptm) deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
			}
			models.setAreaList(areaList);
			
			return new ModelAndView("MMS_addTripping", "model", models);
				
	}
	
	@RequestMapping(value = "/getTowerInfo",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody MmsAddsupport getTowerInfo(@RequestParam("id") long id) {

	MmsAddsupport obj = new MmsAddsupport();
	obj = addSupport.findById(id);
	return obj;
	}

	@RequestMapping(value = "/saveTripping", method = RequestMethod.POST)
	 public ModelAndView saveTripping(@ModelAttribute("model")  PivModel model,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception {
		 String message = "Welcome to Spring 4.0 !";
		 System.out.println("saveTripping" +model.getObjTripping().getAreaEffected());
		 System.out.println("saveTripping1" +model.getObjTripping().getAreaEffected());
		 String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		 String deptId = request.getSession().getAttribute("deptId").toString();
			
		 	 try {
		 		 
		 		model.getObjTripping().setApprovalType("test");
		 		model.getObjTripping().setApprovedLevel(userLevel);
				model.getObjTripping().setAreaCode(model.getGldeptobj().getDeptId());
				model.getObjTripping().setLineId(new BigDecimal(model.getLine().getId()));
				model.getObjTripping().setDeptId(deptId);
				model.getObjTripping().setToStatus("2");
				model.getObjTripping().setLineid(lineDao.getNameById(String.valueOf(model.getLine().getId())));
				tripDao.save(model.getObjTripping());
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
		 	 
		 	System.out.println("deptId : "+deptId);
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			
			String province = deptDao.getDD(deptId);
			System.out.println("province : "+province);
			Glcompm distDiv = glcompmDao.getDistDivision2(province);
			System.out.println("province : "+distDiv.getCompId() +  distDiv.getCompNm());
			provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
			model.setProvinceList(provinceList);
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId().trim());
			int depLoop = deptTm.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				System.out.println("Area :" + i);
				Gldeptm ojb = (Gldeptm) deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
			}
			model.setAreaList(areaList);
			TrippingData objTripping = new TrippingData();
			model.setObjTripping(objTripping);
			return new ModelAndView("MMS_addTripping", "model", model);
	}
	
	
	
	
	@RequestMapping(value = "/MMSAddProvince", method = RequestMethod.POST)
	 public ModelAndView AddProvince(@ModelAttribute("ProvinceSave")  MmsProvince newProvince,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception {
		 String message = "Welcome to Spring 4.0 !";
		 if (!bindingResult.hasErrors()) {
			    
				String resultobj = provinceDao.addProvince(newProvince);
				 
				return new ModelAndView("MMS_addProvince", "message", message);
			} else {
				 
				return new ModelAndView("MMS_addProvince", "message", message);
			}
	
		   //return "AddTowerType";
	}
	
	@RequestMapping(value = "/findAll",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsProvince> getProvinces() {
		return provinceDao.findAll();
	}
	
	@RequestMapping(value = "/findActiveProvince",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsProvince> getActiveProvinces() {
		return provinceDao.findActiveProvince();
	}
	
	@RequestMapping("/displayProvince")
	  public ModelAndView displayProvince() {
			 RestTemplate restTemplate = new RestTemplate();
			 String url=Util.STR_SER+"findAll";    
			 List<LinkedHashMap> Province=restTemplate.getForObject(url, List.class);
	       return new ModelAndView("displayProvince", "Province", Province);
	}
	
	@RequestMapping("/displayLine")
	  public ModelAndView displayLine() {
			 RestTemplate restTemplate = new RestTemplate();
			 String url=Util.STR_SER+"findAllLine";    
			 List<LinkedHashMap> line=restTemplate.getForObject(url, List.class);
	       return new ModelAndView("displayLine", "line", line);
	}
	
	

    /*JSONObject jsonObject = new JSONObject(jsonString);
    JSONObject myResponse = jsonObject.getJSONObject("MyResponse");
    JSONArray tsmresponse = (JSONArray) myResponse.get("listTsm");

    ArrayList<String> list = new ArrayList<String>();

    for(int i=0; i<tsmresponse.length(); i++){
        list.add(tsmresponse.getJSONObject(i).getString("name"));
    }

    System.out.println(list);
*/
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value ="/countValueJournal" ,method = RequestMethod.GET, produces = "application/json")
	  public @ResponseBody String countValueJournal(HttpServletRequest request) {
		System.out.println("countValueJournal");
		String userName = request.getSession().getAttribute("loggedUser").toString();
		 
		String valueJurnal = null;
			try {
				RestTemplate restTemplate = new RestTemplate();
				System.out.println("countValueJournal1");	 
				
				String url="http://10.128.1.126/ceb_ptl/api/MitfinUser/GetApprovalCountByMitfinUser?user="+userName.trim();    
				System.out.println("countValueJournal2");	 
				
				valueJurnal = restTemplate.getForObject(url, String.class);
				//System.out.println("countValueJournal : "+ valueJurnal.);
				//JSONObject jsonObject = new JSONObject(jsonString);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return valueJurnal;
	       
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value ="/rejectValueJournal" ,method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String rejectValueJournal(HttpServletRequest request,@RequestParam("jnl_id") String journal) {
		System.out.println("countValueJournal");
		String userName = request.getSession().getAttribute("loggedUser").toString();
		 
		String valueJurnal = null;
			try {
				RestTemplate restTemplate = new RestTemplate();
				System.out.println("countValueJournal1");	 
				
				String url="http://10.128.1.126/ceb_ptl/api/ValueJournal/RecommendValueJournal?jnl_id="+journal+"&user="+userName.trim();    
				System.out.println("countValueJournal2");	 
				
				valueJurnal = restTemplate.getForObject(url, String.class);
				//System.out.println("countValueJournal : "+ valueJurnal.);
				//JSONObject jsonObject = new JSONObject(jsonString);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return valueJurnal;
	       
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value ="/recommendedValueJournal" ,method = RequestMethod.GET, produces = "application/json")
	  public @ResponseBody String recommendedValueJournal(HttpServletRequest request,@RequestParam("jnl_id") String journal) {
		System.out.println("countValueJournal");
		String userName = request.getSession().getAttribute("loggedUser").toString();
		 
		String valueJurnal = null;
			try {
				RestTemplate restTemplate = new RestTemplate();
				System.out.println("countValueJournal1");	 
				
				String url="http://10.128.1.126/ceb_ptl/api/ValueJournal/RecommendValueJournal?jnl_id="+journal+"&user="+userName.trim();    
				System.out.println("countValueJournal2");	 
				
				valueJurnal = restTemplate.getForObject(url, String.class);
				//System.out.println("countValueJournal : "+ valueJurnal.);
				//JSONObject jsonObject = new JSONObject(jsonString);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return valueJurnal;
	       
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value ="/getAccountNoDetail" ,method = RequestMethod.GET, produces = "application/json")
	  public @ResponseBody String getAccountNoDetail(@RequestParam("account_no") String account_no) {
		String valueJurnal = null;
			try {
				RestTemplate restTemplate = new RestTemplate();
				System.out.println("countValueJournal1");	 
				
				String url="http://testiis1.ceb/MRMSServices/api/BulkDetail/GetBulkCustomerDetails?account_no="+account_no;    
				System.out.println("countValueJournal2");	 
				
				valueJurnal = restTemplate.getForObject(url, String.class);
				//System.out.println("countValueJournal : "+ valueJurnal.);
				//JSONObject jsonObject = new JSONObject(jsonString);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return valueJurnal;
	       
	}
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value ="/bulkCustomer" ,method = RequestMethod.POST, produces = "application/json")
	  public @ResponseBody String bulkCustomer(HttpServletRequest request) {
		System.out.println("bulkCustomer");
		String userName = request.getSession().getAttribute("loggedUser").toString();
		ApplicationObject appObj= null;
		String valueJurnal = null;
		
		ApplicationPK appPK = new ApplicationPK();
		//appPK.
			try {
				RestTemplate restTemplate = new RestTemplate();
				System.out.println("bulkCustomer");	
				appObj = new ApplicationObject();
				
				appObj.setAddress_l1("g11");
				appObj.setAddress_l2("g12");
				appObj.setCity("gcity");
				appObj.setCust_type("1");
				appObj.setName("gayani");
				appObj.setTariff("12");
				String url="http://10.128.1.126/NewConnectionSMC/HSBapi/SMC/NewCustomerData";    
				System.out.println("countValueJournal2");	 
				
				valueJurnal = restTemplate.postForObject(url, appObj, String.class);
				//System.out.println("countValueJournal : "+ valueJurnal.);
				//JSONObject jsonObject = new JSONObject(jsonString);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return valueJurnal;
	       
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value ="/approveValueJournal" ,method = RequestMethod.GET, produces = "application/json")
	  public @ResponseBody String approveValueJournal(HttpServletRequest request,@RequestParam("jnl_id") String journal) {
		System.out.println("countValueJournal");
		String userName = request.getSession().getAttribute("loggedUser").toString();
		 
		String valueJurnal = null;
			try {
				RestTemplate restTemplate = new RestTemplate();
				System.out.println("countValueJournal1");	 
				
				String url="http://10.128.1.126/ceb_ptl/api/ValueJournal/ApproveValueJournal?jnl_id="+journal+"&user="+userName.trim();    
				System.out.println("countValueJournal2");	 
				
				valueJurnal = restTemplate.getForObject(url, String.class);
				//System.out.println("countValueJournal : "+ valueJurnal.);
				//JSONObject jsonObject = new JSONObject(jsonString);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return valueJurnal;
	       
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value ="/countValueJournalDetail" ,method = RequestMethod.GET, produces = "application/json")
	  public @ResponseBody String countValueJournalDetail(HttpServletRequest request,@RequestParam("deptId") String deptId) {
		System.out.println("countValueJournal");
		String userName = request.getSession().getAttribute("loggedUser").toString();
		 
		String valueJurnal = null;
			try {
				RestTemplate restTemplate = new RestTemplate();
				System.out.println("countValueJournal1");	 
				
				String url="http://10.128.1.126/ceb_ptl/api/MitfinUser/GetVJApprovalSummaryByMitfinUser?user="+userName+"&dept_id="+deptId.trim();    
				System.out.println("countValueJournal2");	 
				
				valueJurnal = restTemplate.getForObject(url, String.class);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return valueJurnal;
	       
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value ="/countValueJournalDetailCount" ,method = RequestMethod.GET, produces = "application/json")
	  public @ResponseBody String countValueJournalDetailCount(HttpServletRequest request) {
		System.out.println("countValueJournal");
		String userName = request.getSession().getAttribute("loggedUser").toString();
		 
		String valueJurnal = null;
			try {
				RestTemplate restTemplate = new RestTemplate();
				System.out.println("countValueJournal1");	 
				
				String url="http://10.128.1.126/CeB_PTL/api/MitfinUser/GetVJBreakdownSummaryByMitfinUser?user="+userName;    
				System.out.println("countValueJournal2");	 
				
				valueJurnal = restTemplate.getForObject(url, String.class);
				System.out.println("countValueJournal : "+ valueJurnal);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return valueJurnal;
	       
	}
	
	
	
	
	
	
	@RequestMapping("/validateLine")
	  public ModelAndView validateLine() {
			 RestTemplate restTemplate = new RestTemplate();
			 String url=Util.STR_SER+"findAllLine";    
			 List<LinkedHashMap> line=restTemplate.getForObject(url, List.class);
	       return new ModelAndView("validateLine", "line", line);
	}
	
	/**@RequestMapping("/displaySupport")
	  public ModelAndView displaySupport() {
			 RestTemplate restTemplate = new RestTemplate();
			 String url=Util.STR_SER+"findAllLine";    
			 List<LinkedHashMap> line=restTemplate.getForObject(url, List.class);
	       return new ModelAndView("displayLine", "line", line);
	}*/
	
	
	@RequestMapping(value = "/updateProvince/{province}/{id}/{status}",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody void updateProvince(@PathVariable("province") String province,@PathVariable("id") String id,@PathVariable("status") String status) {
			provinceDao.updateProvince(province,id,status);
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/updateLine/{id}/{code}/{lineName}/{lineType}/{length}/{area}/{noofpoles}/{nooftowers}/{comdate}/{status}/{cirtype}/{contype}/{feeder}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateLine(@PathVariable("id") String id,@PathVariable("code") String code,@PathVariable("lineName") String name,
			@PathVariable("lineType") String lineType,@PathVariable("length") String legnth,@PathVariable("area") String area,
			@PathVariable("noofpoles") String poles,@PathVariable("nooftowers") String towers,@PathVariable("comdate") String comdate,@PathVariable("status") String status,@PathVariable("cirtype") String cirtype,@PathVariable("contype") String contype,@PathVariable("feeder") String feeder) {
		//provinceDao.updateProvince(province,id,status);
		try{
		
		System.out.println("hiiiiii66666");
		MmsAddline obj = new MmsAddline();
		obj = addLine.findById(Long.valueOf(id));
		obj.setId(Long.valueOf(id));
		obj.setCode(code);
		obj.setLineName(name);
		obj.setLineType(lineType);
		obj.setLength(new BigDecimal(legnth));
		obj.setArea(area);
		obj.setNoofpoles(new BigDecimal(poles));
		obj.setNooftowers(new BigDecimal(towers));
		obj.setStatus(new BigDecimal(status));
		obj.setConductorType(new Float(contype));
		obj.setCircuitType(new BigDecimal(cirtype));
		obj.setFeederIdentification(feeder);
		Date dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(comdate);
		//String currentDate = dateNow.format(date);
		
		obj.setComdate(dateNow);
		addLine.update(obj);
		}catch(Exception e){
			
		}
}
	
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/updateLineApprove/{id}/{code}/{lineName}/{lineType}/{length}/{area}/{noofpoles}/{nooftowers}/{comdate}/{status}/{cirtype}/{contype}/{feeder}/{gss}/{feeder2}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateLineApprove(@PathVariable("id") String id,@PathVariable("code") String code,@PathVariable("lineName") String name,
			@PathVariable("lineType") String lineType,@PathVariable("length") String legnth,@PathVariable("area") String area,
			@PathVariable("noofpoles") String poles,@PathVariable("nooftowers") String towers,@PathVariable("comdate") String comdate,@PathVariable("status") String status,@PathVariable("cirtype") String cirtype,@PathVariable("contype") String contype,@PathVariable("feeder") String feeder,@PathVariable("gss") String gss,@PathVariable("feeder2") String feeder2) {
		//provinceDao.updateProvince(province,id,status);
		try{
		
		System.out.println("hiiiiii66666");
		MmsAddline obj = new MmsAddline();
		obj = addLine.findById(Long.valueOf(id));
		obj.setId(Long.valueOf(id));
		obj.setCode(code);
		obj.setLineName(name);
		obj.setLineType(lineType);
		obj.setLength(new BigDecimal(legnth));
		obj.setArea(area);
		obj.setNoofpoles(new BigDecimal(poles));
		obj.setNooftowers(new BigDecimal(towers));
		obj.setStatus(new BigDecimal(status));
		obj.setConductorType(new Float(contype));
		obj.setCircuitType(new BigDecimal(cirtype));
		obj.setFeederIdentification(feeder);
		obj.setName(gss);
		obj.setFeeder2(feeder2);
		Date dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(comdate);
		//String currentDate = dateNow.format(date);
		
		obj.setComdate(dateNow);
		addLine.update(obj);
		}catch(Exception e){
			
		}
}
	
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/updateLineApproveNew",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateLineApproveNew(@RequestParam("id") String id,@RequestParam("code") String code,@RequestParam("lineName") String name,
			@RequestParam("lineType") String lineType,@RequestParam("length") String legnth,@RequestParam("area") String area,
			@RequestParam("noofpoles") String poles,@RequestParam("nooftowers") String towers,@RequestParam("comdate") String comdate,@RequestParam("status") String status,@RequestParam("cirtype") String cirtype,@RequestParam("contype") String contype,@RequestParam("feeder") String feeder,@RequestParam("gss") String gss,@RequestParam("feeder2") String feeder2) {
		//provinceDao.updateProvince(province,id,status);
		try{
		
		System.out.println("hiiiiii66666");
		MmsAddline obj = new MmsAddline();
		
		
		obj = addLine.findById(Long.valueOf(id));
		System.out.println("hiiiiii66666 : " + obj);
		
		//obj.setId(Long.valueOf(id));
		obj.setCode(code);
		obj.setLineName(name);
		obj.setLineType(lineType);
		obj.setLength(new BigDecimal(legnth));
		obj.setArea(area);
		obj.setNoofpoles(new BigDecimal(poles));
		obj.setNooftowers(new BigDecimal(towers));
		obj.setStatus(new BigDecimal(status));
		obj.setConductorType(new Float(contype));
		obj.setCircuitType(new BigDecimal(cirtype));
		obj.setFeederIdentification(feeder);
		//obj.set
		obj.setName(gss);
		obj.setFeeder2(feeder2);
		Date dateNow = null;
		if(!comdate.equalsIgnoreCase("")){
			dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(comdate);
		}
		//String currentDate = dateNow.format(date);
		
		obj.setComdate(dateNow);
		addLine.update(obj);
		}catch(Exception e){
			
			System.out.println("hiiiiii66666 : " + e);
			
			
		}
}


	
	
	
	
	//addArea
	@RequestMapping(value = "/addArea", method = RequestMethod.GET)
	 public ModelAndView MMSAddArea(@ModelAttribute("SaveArea")  MmsArea newArea,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception{
		 String message = "Welcome to Spring 4.0 !";
				return new ModelAndView("MMS_addArea", "message", message);
				
	}
	
	
	@RequestMapping(value = "/MMSAddArea", method = RequestMethod.POST)
	 public ModelAndView AddArea(@ModelAttribute("SaveArea")  MmsArea newArea,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception {
		 String message = "Welcome to Spring 4.0 !";
		 if (!bindingResult.hasErrors()) {
			    
				String resultobj = areaDao.addArea(newArea);
				
				 
				return new ModelAndView("MMS_addArea", "message", message);
			} else {
				 
				return new ModelAndView("MMS_addArea", "message", message);
			}

	}
	
	@RequestMapping(value = "/findAllAreas",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsArea> getAreas() {
		System.out.print("eeeee");
		return areaDao.findAll();
	}
	
	
	
	@RequestMapping(value = "/findActiveAreas",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsArea> Areas() {
		return areaDao.findActiveAreas();
	}
	  
	@RequestMapping("/displayAreas")
	  public ModelAndView displayAreas() {
			 RestTemplate restTemplate = new RestTemplate();
			 String url=Util.STR_SER+"findAllAreas"; List<LinkedHashMap> Area=restTemplate.getForObject(url, List.class);
			 return new ModelAndView("editAreas", "Area", Area);
	}
	
	@RequestMapping(value = "/updateAreas/{id}/{province}/{area}/{status}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateArea(@PathVariable("id") String id,@PathVariable("province") String province,@PathVariable("area") String area,@PathVariable("status") String status) {
		areaDao.updateArea(id, province, area, status);
	}
	
	//add tower maintenance data
	
	@RequestMapping(value = "/towerMaintenance", method = RequestMethod.GET)
	 public ModelAndView MMStowerMaintenance(@ModelAttribute("SaveTowermaintenanceData")  MmsTxntowermaintenance towermaintenance,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception{
		 String message = "Welcome to Spring 4.0 !";
				return new ModelAndView("MMS_towerMaintenance", "message", message);
				
	}
	
	
	@RequestMapping(value = "/MmsTxtMobile", method = RequestMethod.GET)
	 public @ResponseBody String MmsTxtMobile(@RequestParam("SaveTowermaintenanceData")  MmsTowermaintenance towermaintenance) throws Exception {
		try {
			towerMaintenance.addTowerMaintananceData(towermaintenance);
			return "Y";
		}catch(Exception e){
			return "N";
		}
			
			
		

	}
	
	
	
	@RequestMapping(value = "/MMStowerMaintenance", method = RequestMethod.POST)
	 public ModelAndView towerMaintenance(@ModelAttribute("SaveTowermaintenanceData")  MmsTowermaintenance towermaintenance,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception {
		 String message = "Welcome to Spring 4.0 !";
		 if (!bindingResult.hasErrors()) {
			    
			String resultobj = towerMaintenance.addTowerMaintananceData(towermaintenance);
			
			Date date = new Date();
			String enterDate = sdf.format(date);
			
			String id = "TOWER-MAIN-ENT-"+enterDate;
			String refrence = towermaintenance.getId().getTowerId();
			String deptId = request.getSession().getAttribute("deptId").toString();
			String approveType = "TOWER-MAIN-ENT";
			String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
			String fromStatus = towermaintenance.getStatus();
			String approvedBy = request.getSession().getAttribute("loggedUser").toString();
					
			Approval appr = new Approval();
			appr.setApprovalId(id);
			appr.setReferenceNo(refrence);
			appr.setDeptId(deptId);
			appr.setApprovalType(approveType);
			appr.setApprovedLevel(approveLevel);
			appr.setFromStatus(fromStatus);
			appr.setApprovedBy(approvedBy);
				
			approval.addApproval(appr);
			 
			return new ModelAndView("MMS_towerMaintenance", "message", message);
		} else { 
			return new ModelAndView("MMS_towerMaintenance", "message", message);
		}

	}
	
	@RequestMapping(value = "/findTowerMaintenance",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsTowermaintenance> towerMaintenance() {
		return towerMaintenance.findAll();
	}
	
	@RequestMapping(value = "/findTowerMntByAreaLine/{area}/{lineId}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsTxntowermaintenance> towerMaintenanceByArea(@PathVariable("area") String area,@PathVariable("lineId") String lineId) {
		System.out.println("area line:" + area);
		System.out.println("line:" + lineId);
		return towerTxtMaintenance.findAllByAreaLine(area, lineId);
	}
	
	@RequestMapping(value = "/findTowerMnByArea/{area}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsTowermaintenance> towerMnByArea(@PathVariable("area") String area) {
		System.out.println("area :" + area);
		return towerMaintenance.findAllByArea(area);
	}
	
	@RequestMapping(value = "/findTMByArea/{area}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<TowerModel> towerMainByArea(@PathVariable("area") String area) {
		System.out.println("area :" + area);
		return towerMaintenance.findTowerMntByArea(area);
	}

	//add Line
	@RequestMapping(value = "/addLine", method = RequestMethod.GET)
	 public ModelAndView MMSaddLine(@ModelAttribute("SaveLine")  MmsAddline line,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception{
		 String message = "Welcome to Spring 4.0 !";
		 return new ModelAndView("MMS_addLine", "message", message);
				
	}
	
	
	@RequestMapping(value = "/newAddLine", method = RequestMethod.GET)
	 public ModelAndView newAddLine(@RequestParam("mode") String mode,@ModelAttribute("SaveLine")  MmsAddline line,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception{
		 String message = "Welcome to Spring 4.0 !";
		 ModelAndView mm = new ModelAndView("MMS_addLine_new", "message", message);
		 mm.addObject("mode", mode);
		return mm;	
	}
	
	
	@RequestMapping(value = "/modifyAddLine", method = RequestMethod.GET)
	 public ModelAndView newAddLine(@RequestParam("mode") String mode,@RequestParam("lineid") long lineid,@ModelAttribute("SaveLine")  MmsAddline line,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("mode : " +mode);
		System.out.println("lineid : " +lineid);
		MmsAddline obj;
		obj = addLine.findById(lineid);
		System.out.println("line : " + obj.getCode());
		 ModelAndView mm = new ModelAndView("MMS_addLine_new", "SaveLine", obj);
		 mm.addObject("mode", mode);
		return mm;	
	}
	
	
	
	@RequestMapping(value = "/NewMMSaddLine", method = RequestMethod.POST)
	 public ModelAndView NewMMSaddLine(@ModelAttribute("SaveLine")  MmsAddline line,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception {
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("line : " + line.getCode());
		String message = "Welcome to Spring 4.0 !";
		line.setPhmBranch(deptId);
		line.setStatus(new BigDecimal("2"));
		String resultobj = addLine.addLine(line);
		MmsAddline obj = new MmsAddline();
		obj.setName("Successfully Added");
		return new ModelAndView("MMS_addLine", "SaveLine", obj);
		
		//if (!bindingResult.hasErrors()) {
			//System.out.println("line1 : " + line.getCode());
			//String resultobj = addLine.addLine(line);
			 
			//return new ModelAndView("MMS_addLine", "message", "Successfully Added");
		//} else { 
			//System.out.println("line2: " + line.getCode());
			//return new ModelAndView("MMS_addLine", "message", message);
		//}

	}
	
	
	
	@RequestMapping(value = "/MMSaddLine", method = RequestMethod.POST)
	 public ModelAndView addLine(@ModelAttribute("SaveLine")  MmsAddline line,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("line : MMSaddLine " );
		
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("line : " + line.getCode() + "comdate :" + line.getComdate());
		String message = "Welcome to Spring 4.0 !";
		line.setPhmBranch(deptId);
		line.setStatus(new BigDecimal("2"));
		String resultobj = addLine.addLine(line);
		MmsAddline obj = new MmsAddline();
		obj.setName("Successfully Added");
		return new ModelAndView("MMS_addLine", "SaveLine", obj);
		
		//if (!bindingResult.hasErrors()) {
			//System.out.println("line1 : " + line.getCode());
			//String resultobj = addLine.addLine(line);
			 
			//return new ModelAndView("MMS_addLine", "message", "Successfully Added");
		//} else { 
			//System.out.println("line2: " + line.getCode());
			//return new ModelAndView("MMS_addLine", "message", message);
		//}

	}
	
	//add support
	
	@RequestMapping(value = "/addSupport", method = RequestMethod.GET)
	 public ModelAndView MMSaddSupport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PivModel model = new PivModel();
		String deptId = request.getSession().getAttribute("deptId").toString();
		String loggedUserRole = request.getSession().getAttribute("loggedUserRole").toString();
		List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId,loggedUserRole);
		Map<String,String> saList = new LinkedHashMap<String,String>();
		
		
		int loopSa = saUserList.size()-1;
		for(int i=0;i<=loopSa;i++){ 
		  System.out.println(i);
		  Sauserm ojb = saUserList.get(i);
		  System.out.println(ojb.getUserId());
		  saList.put(ojb.getUserId(), ojb.getUserNm());
	      
	    } 
		model.setSaList(saList);
		System.out.println("addSupport: "+deptId);
		//model.getSupportObj().setPhmBranch(deptId);
		ModelAndView mm = new ModelAndView("MMS_addSupport", "pivModel",model);
		
		//String message = "Welcome to Spring 4.0 !";
		//ModelAndView mv = new ModelAndView("MMS_addSupport", "message", message);
		//mv.addObject("deptid", deptId);
		//mv.addObject("loggedUserRole", loggedUserRole);
		return mm;
				
	}
	
	
	@RequestMapping(value = "/addSupportNew", method = RequestMethod.GET)
	 public ModelAndView addSupportNew(@RequestParam("id") long id, HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		
		MmsAddsupport obj = new MmsAddsupport();
		obj = addSupport.findById(id);
		PivModel model = new PivModel();
		model.setSupportObj(obj);
		String deptId = request.getSession().getAttribute("deptId").toString();
		String loggedUserRole = request.getSession().getAttribute("loggedUserRole").toString();
		List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId,loggedUserRole);
		Map<String,String> saList = new LinkedHashMap<String,String>();
		
		
		int loopSa = saUserList.size()-1;
		for(int i=0;i<=loopSa;i++){ 
		  System.out.println(i);
		  Sauserm ojb = saUserList.get(i);
		  System.out.println(ojb.getUserId());
		  saList.put(ojb.getUserId(), ojb.getUserNm());
	      
	    } 
		model.setSaList(saList);
		System.out.println("addSupport: "+deptId);
		//model.getSupportObj().setPhmBranch(deptId);
		ModelAndView mm = new ModelAndView("MMS_addSupport", "pivModel",model);
		
		//String message = "Welcome to Spring 4.0 !";
		//ModelAndView mv = new ModelAndView("MMS_addSupport", "message", message);
		//mv.addObject("deptid", deptId);
		//mv.addObject("loggedUserRole", loggedUserRole);
		return mm;
				
	}
	
	
	@RequestMapping(value = "/MMSaddSupportMobile/{support}", method = RequestMethod.POST)
	 public ModelAndView MMSaddSupportMobile(@RequestParam("support")  MmsAddsupport support) throws Exception {
		 String message = "Welcome to Spring 4.0 !";
		 System.out.println("*************************************" + support.getTowerNo());
			
		 String resultobj = addSupport.addSupport(support);
		 return null;
	}
	
	@RequestMapping(value = "/MMSaddSupport", method = RequestMethod.POST)
	 public ModelAndView addSupport(@ModelAttribute("pivModel")  PivModel pivModel,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception {
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("ddd: "+deptId);
		pivModel.getSupportObj().setPhmBranch(deptId);
		
		
		String message = "Welcome to Spring 4.0 !";
		 System.out.println("*************************************" + pivModel.getSupportObj().getTowerNo());
			
		 String resultobj = addSupport.addSupport(pivModel.getSupportObj());
		 
		 PivModel obj = new PivModel();
		 obj.setMessage("Successfully Added");
		 return new ModelAndView("MMS_addSupport", "pivModel", obj);
		 /**if (!bindingResult.hasErrors()) {
			    
			String resultobj = addSupport.addSupport(support);
			
			Date date = new Date();
			String approvedDate = sdf.format(date);
			
			String id = "SUP-ENT-"+approvedDate;
			String refrence = support.getTowerNo();
			String deptId = request.getSession().getAttribute("deptId").toString();
			String approveType = "SUP-ENT";
			String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
			BigDecimal fromStatus = support.getStatus();
			String approvedBy = request.getSession().getAttribute("loggedUser").toString();
			
			System.out.println("*******************************************************"+id);
			System.out.println("*******************************************************"+refrence);
			System.out.println("*******************************************************"+deptId);
			System.out.println("*******************************************************"+approveType);
			System.out.println("*******************************************************"+approveLevel);
			System.out.println("*******************************************************"+fromStatus);
			System.out.println("*******************************************************"+approvedBy);
			System.out.println("*******************************************************"+approvedDate);
			
			
			Approval appr = new Approval();
			appr.setApprovalId(id);
			appr.setReferenceNo(refrence);
			appr.setDeptId(deptId);
			appr.setApprovalType(approveType);
			appr.setApprovedLevel(approveLevel);
			appr.setFromStatus(fromStatus.toString());
			appr.setApprovedBy(approvedBy);
				
			approval.addApproval(appr);
			
			 
			return new ModelAndView("MMS_addSupport", "message", message);
		} else { 
			return new ModelAndView("MMS_addSupport", "message", message);
		}*/

	}
	
	@RequestMapping(value = "/saveApprove/{towerNo}/{deptId}/{approveLevel}/{approveBy}/{toStatus}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void saveApprove(@PathVariable("towerNo") String towerNo,@PathVariable("deptId") String deptId,
			@PathVariable("approveLevel") String approveLevel,@PathVariable("approveBy") String approveBy,@PathVariable("toStatus") String toStatus) {
		
			Date date = new Date();
			String approvedDate = sdf.format(date);
			
			Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");	        
	        String currenttime = sd.format(cal.getTime());
	        System.out.println(currenttime);
	        
	        String currentDate = dateNow.format(date);
			
			String id = "SUP-ENT-APPROVE"+approvedDate;
			String approveType = "SUP-ENT-APPROVE";
			
			Approval appr = new Approval();
			appr.setApprovalId(id);
			appr.setReferenceNo(towerNo);
			appr.setDeptId(deptId);
			appr.setApprovalType(approveType);
			appr.setApprovedLevel(approveLevel);
			appr.setToStatus(toStatus);
			appr.setApprovedBy(approveBy);
			//appr.setApprovedDate(currentDate);
			appr.setApprovedTime(currenttime);
			
			approval.addApproval(appr);
	}
	
	@RequestMapping(value = "/findAllSupport",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddsupport> getSupport() {
		return addSupport.findAll(); 
	}
	
	@RequestMapping(value = "/MapIdUpdate/{id}/{x}/{j}/{k}/{a}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void MapIdUpdate(@PathVariable("id") String id,@PathVariable("x") String mapId,@PathVariable("j") String gpsLat,@PathVariable("k") String gpsLon,@PathVariable("a") String sType) {
		
		addSupport.updateSupport(mapId, id,gpsLat,gpsLon,sType);
	}
	
	@RequestMapping(value = "/updateSupport/{c}/{a}/{id}/{d}/{e}/{f}/{g}/{h}/{i}/{j}/{k}/{l}/{m}/{t}/{x}/{status}/{n}/{res}/{from}/{to}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateSupport(@PathVariable("c") String towerNo,@PathVariable("a") String sType,@PathVariable("id") String id,
			@PathVariable("d") String area,@PathVariable("e") String csc,@PathVariable("f") String cType,@PathVariable("g") String ecType,
			@PathVariable("h") String tType,@PathVariable("i") String tConfig,@PathVariable("j") String gpsLat,@PathVariable("k") String gpsLon,@PathVariable("l") String nofCir,@PathVariable("m") String bExten,@PathVariable("t") String tapping,@PathVariable("x") String mapId,@PathVariable("status") String status,@PathVariable("n") String appLevel,@PathVariable("res") String res,@PathVariable("from") String from,@PathVariable("to") String to) {
		
		addSupport.updateSupport(towerNo,sType, id, area, csc, cType, ecType, tType, tConfig, gpsLat, gpsLon, nofCir, bExten,tapping,mapId, status, appLevel,res,from,to);
	}
	
	@RequestMapping(value = "/updateSupportNew",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateSupportNew(@RequestParam("c") String towerNo,@RequestParam("a") String sType,@RequestParam("id") String id,
			@RequestParam("d") String area,@RequestParam("e") String csc,@RequestParam("f") String cType,@RequestParam("g") String ecType,
			@RequestParam("h") String tType,@RequestParam("i") String tConfig,@RequestParam("j") String gpsLat,@RequestParam("k") String gpsLon,@RequestParam("l") String nofCir,@RequestParam("m") String bExten,@RequestParam("t") String tapping,@RequestParam("x") String mapId,@RequestParam("status") String status,@RequestParam("n") String appLevel,@RequestParam("res") String res,@RequestParam("from") String from,@RequestParam("to") String to) {
		
		addSupport.updateSupport(towerNo,sType, id, area, csc, cType, ecType, tType, tConfig, gpsLat, gpsLon, nofCir, bExten,tapping,mapId, status, appLevel,res,from,to);
	}
	
	
	@RequestMapping(value = "/updateSupportTapping/{c}/{a}/{id}/{d}/{e}/{f}/{g}/{h}/{i}/{j}/{k}/{l}/{m}/{t}/{x}/{status}/{n}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateSupportTapping(@PathVariable("c") String towerNo,@PathVariable("a") String sType,@PathVariable("id") String id,
			@PathVariable("d") String area,@PathVariable("e") String csc,@PathVariable("f") String cType,@PathVariable("g") String ecType,
			@PathVariable("h") String tType,@PathVariable("i") String tConfig,@PathVariable("j") String gpsLat,@PathVariable("k") String gpsLon,@PathVariable("l") String nofCir,@PathVariable("m") String bExten,@PathVariable("t") String tapping,@PathVariable("x") String mapId,@PathVariable("status") String status,@PathVariable("n") String appLevel) {
		
		addSupport.updateSupportTapping(towerNo,sType, id, area, csc, cType, ecType, tType, tConfig, gpsLat, gpsLon, nofCir, bExten,tapping,mapId, status, appLevel);
	}
	
	
	
	/*@RequestMapping(value = "/updateSupportNew/{c}/{a}/{id}/{d}/{e}/{f}/{g}/{h}/{i}/{j}/{k}/{l}/{m}/{t}/{x}/{status}/{n}/{z}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateSupport(@PathVariable("c") String towerNo,@PathVariable("a") String sType,@PathVariable("id") String id,
			@PathVariable("d") String area,@PathVariable("e") String csc,@PathVariable("f") String cType,@PathVariable("g") String ecType,
			@PathVariable("h") String tType,@PathVariable("i") String tConfig,@PathVariable("j") String gpsLat,@PathVariable("k") String gpsLon,@PathVariable("l") String nofCir,@PathVariable("m") String bExten,@PathVariable("t") String tapping,@PathVariable("x") String mapId,@PathVariable("status") String status,@PathVariable("n") String appLevel,@PathVariable("z") Str) {
		
		addSupport.updateSupport(towerNo,sType, id, area, csc, cType, ecType, tType, tConfig, gpsLat, gpsLon, nofCir, bExten,tapping,mapId, status, appLevel);
	}
	*/
	
	@RequestMapping(value = "/findAllSupportByStatus",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddsupport> getSupport(@RequestParam("status") String status) {
		return addSupport.findByStatus(status); 
	}
	
	
	
	
	@RequestMapping("/displaySupport")
	  public ModelAndView displaySupport(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		
		RestTemplate restTemplate = new RestTemplate();
			// String url=Util.STR_SER+"findAllSupport"; 
			 String area = pivModel.getGldeptobj().getDeptId();
			 String line = String.valueOf(pivModel.getLine().getCode());
			 String id ="";
				if(line.equalsIgnoreCase("NONE")){
					id ="NONE";
				}else{
					id = addLine.findIdByCode(line.trim());
				}
				System.out.println("id :" + id);
			 
			 
			 String province = pivModel.getGlcompmobj().getCompId();
			 System.out.println("DisplaySupport : " +area + id+province);
			 List<MmsAddsupport> Support = addSupport.findByArea(area, String.valueOf(id), province,deptId);
			 System.out.println("dddduuuu :"+Support.size());
			 //String url=Util.STR_SER+"findAllSupportByStatus?status=2";
			 //List<LinkedHashMap> Support=restTemplate.getForObject(url, List.class);
	       return new ModelAndView("editSupport", "Support", Support);
	}
	
	@RequestMapping(value = "/getTowerDetailsToMap/{towerNo}/{deptId}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void getTowerDetail(@PathVariable("towerNo") String towerNo,@PathVariable("deptId") String deptId) {
		System.out.println("Tower No -------------------------------------------->>>>>>> "+towerNo);
		System.out.println("Dept ID --------------------------------------------->>>>>>> "+deptId);
		addSupport.getTowerMaintenanceData(towerNo, "501.20");
	}
	
	@RequestMapping(value = "/getTowerDetailsToMap",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddsupport> getTowerDetails() {
		return addSupport.getTowerMaintenanceData();
	}
	
	@RequestMapping(value = "/findApprovingSupports/{level}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddsupport> getSupportES(@PathVariable("level") String level) {
		return addSupport.findES1COMWPS2(level);
	}
	
	@RequestMapping("/approveSupport")
	  public ModelAndView approveSupport(HttpServletRequest request) {
			 RestTemplate restTemplate = new RestTemplate();
			 String approveLevel = request.getSession().getAttribute("loggedUser").toString(); 
			 String url=Util.STR_SER+"findApprovingSupports/"+approveLevel;
			 List<LinkedHashMap> Support=restTemplate.getForObject(url, List.class);
	       return new ModelAndView("approveSupport", "Support", Support);
	}
																																												
	@RequestMapping(value = "/getSupport/{area}/{lineId}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddsupport> getSupport(@PathVariable("area") String area,@PathVariable("lineId") String lineId) {
		System.out.println("area :" + area + "line: " + lineId);
		return addSupport.findByArea(area,lineId);
	}
	
	@RequestMapping(value = "/findSupportByArea/{area}/{lineId}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddsupport> supportByArea(@PathVariable("area") String area,@PathVariable("lineId") String lineId) {
		System.out.println("area :" + area);
		return addSupport.findByArea(area,lineId);
	}
	
	@RequestMapping(value = "/findSupportByAreaForMap/{area}/{lineId}/{province}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddsupport> supportByAreaForMap(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("province") String province) {
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("area :" + area);
		System.out.println("lineId :" + lineId);
		System.out.println("province :" + province);
		String id ="";
		if(lineId.equalsIgnoreCase("NONE")){
			id ="NONE";
		}else{
			id = addLine.findIdByCode(lineId.trim());
		}
		System.out.println("id :" + id);
		return addSupport.findByArea(area,id,province,deptId);
	}
	
	@RequestMapping(value = "/newMpView/{area}/{lineId}/{province}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> newMpView(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("province") String province) {
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("area :" + area);
		System.out.println("lineId :" + lineId);
		System.out.println("province :" + province);
		//String id ="";
		//if(lineId.equalsIgnoreCase("NONE")){
			//id ="NONE";
		//}else{
			//id = addLine.findIdByCode(lineId.trim());
		//}
		//System.out.println("id :" + id);
		return addSupport.findByAreaForNewMap(area,lineId,province,deptId);
	}
	
	
	@RequestMapping(value = "/MapNew/{area}/{lineId}/{province}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> newMp(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("province") String province) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("area :" + area);
		System.out.println("lineId :" + lineId);
		System.out.println("province :" + province);
		String id ="";
		System.out.println("id :" + id);
		return addSupport.findByAreaForNewMap(area,lineId,province,deptId,"1");
	}
	
	
	
	@RequestMapping(value = "/MapNewWayAna/{area}/{lineId}/{province}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapNewWayAna(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("province") String province) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("area :" + area);
		System.out.println("lineId :" + lineId);
		System.out.println("province :" + province);
		String id ="";
		System.out.println("id :" + id);
		return addSupport.findByAreaForNewMapWayAnalysis(area,lineId,province,deptId,"1");
	}
	
	
	
	@RequestMapping(value = "/MapNewProvince/{area}/{lineId}/{province}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapNewProvince(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("province") String province) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("area :" + area);
		System.out.println("lineId :" + lineId);
		System.out.println("province :" + province);
		String id ="";
		System.out.println("id :" + id);
		//String id ="";
		if(lineId.equalsIgnoreCase("NONE")){
			id ="NONE";
		}else{
			id = addLine.findIdByCode(lineId.trim());
		}
		
		
		
		
		return addSupport.findByAreaForNewMapProvince(area,id,province);
	}
	
	
	
	@RequestMapping(value = "/MapNewAE/{area}/{lineId}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapNewAE(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId) {
		if(lineId.equalsIgnoreCase("-1")){
			lineId = "NONE";
			
		}
		return addSupport.findByAreaForNewMap(area,lineId);
	}
	
	@RequestMapping(value = "/MapNewAENew/{area}/{lineId}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapNewAENew(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.print("way leave :"+lineId);
		if(lineId.equalsIgnoreCase("-1")){
			lineId = "NONE";
			
		}
		return addSupport.findByAreaEngineerForNewMapWayAnalysis(area,lineId,deptId);
	}
	
	@RequestMapping(value = "/MapNewAENewNew/{area}/{lineId}/{cycle}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapNewAENewNew(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("cycle") String cycle) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.print("way leave :"+lineId);
		if(lineId.equalsIgnoreCase("-1")){
			lineId = "NONE";
			
		}
		return addSupport.findByAreaEngineerForNewMapWayAnalysisNew(area,lineId,cycle);
	}
	
	
	
	@RequestMapping(value = "/MapNewOtherNewNew/{area}/{lineId}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapNewOtherNewNew(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		
		String id ="";
		/*if(lineId.equalsIgnoreCase("-1")){
			lineId = "NONE";
			
		}
		*/
		if(lineId.equalsIgnoreCase("NONE")){
			id ="NONE";
		}else{
			id = addLine.findIdByCode(lineId.trim());
		}
		
		
		List<Long> cycleList = cycleDao.fineMntAvailCycle(area);
		System.out.print("cycle :"+String.valueOf(cycleList.get(0)));
		
		return addSupport.findByAreaEngineerForNewMapWayAnalysisNew(area,id,String.valueOf(cycleList.get(0)));
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/MapNewOther/{area}/{lineId}/{province}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapNewOther(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("province") String province) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("area :" + area);
		System.out.println("lineId :" + lineId);
		System.out.println("province :" + province);
		String id ="";
		if(lineId.equalsIgnoreCase("NONE")){
			id ="NONE";
		}else{
			id = addLine.findIdByCode(lineId.trim());
		}
		System.out.println("id :" + id);
		return addSupport.findByAreaForNewMapOther(area,id,province,"1");
	}
	
	
	@RequestMapping(value = "/MapNewInt/{area}/{lineId}/{province}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapNewInt(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("province") String province) {
		return addSupport.findByAreaForNewMapOther(area,lineId,province,"1");
	}
	
	@RequestMapping(value = "/MapNewAll/{area}/{lineId}/{province}/{division}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapNewAll(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("province") String province,@PathVariable("division") String division) {
		return addSupport.findByAreaForNewMapAll(area,lineId,province,division,"1");
	}
	
	@RequestMapping(value = "/MapNewComView/{area}/{lineId}/{province}/{division}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapNewComView(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("province") String province,@PathVariable("division") String division) {
		return addSupport.findByAreaForNewMapComview(area,lineId,province,division,"1");
	}
	
	
	@RequestMapping(value = "/MapSubAll/{area}/{lineId}/{province}/{division}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapSubAll(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("province") String province,@PathVariable("division") String division) {
		return addSupport.findByAreaForNewMapAll(area,lineId,province,division,"1");
	}
	
	
	
	@RequestMapping(value = "/MapNewSummary/{area}/{lineId}/{province}/{division}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapNewSummary(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("province") String province,@PathVariable("division") String division) {
		return addSupport.findByAreaForNewMapSummary(area,lineId,province,division,"1");
	}
	
	@RequestMapping(value = "/MapNewSummaryOther/{area}/{lineId}/{province}/{division}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapNewSummaryOther(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("province") String province,@PathVariable("division") String division) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		String provinceStr = deptDao.getDD(deptId);
		
		String distDiv = glcompmDao.getDistDivision(provinceStr);
		//System.out.print("MapNewSummaryOther"+ distDiv);
		return addSupport.findByAreaForNewMapSummary(area,lineId,province,distDiv,"1");
	}
	
	
	
	
	@RequestMapping(value = "/MapNewMobile/{area}/{lineId}/{province}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddsupport> MapNewMobile(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("province") String province) {
		return addSupport.findByAreaOther(area,lineId, province);

	}
	
	
	@RequestMapping(value = "/MapNewWOMNT/{area}/{lineId}/{province}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapNewWOMNT(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("province") String province) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("area :" + area);
		System.out.println("lineId :" + lineId);
		System.out.println("province :" + province);
		String id ="";
		if(lineId.equalsIgnoreCase("NONE")){
			id ="NONE";
		}/*else{
			id = addLine.findIdByCode(lineId.trim());
		}
		*/System.out.println("id :" + id);
		return addSupport.findByAreaForNewMapWOMNT(area,lineId,province,deptId,"1");
	}
	
	
	
	
	
	@RequestMapping(value = "/MapNewWOMNTGANTRY/{area}/{lineId}/{province}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapNewWOMNTGANTRY(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("province") String province) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("area :" + area);
		System.out.println("lineId :" + lineId);
		System.out.println("province :" + province);
		String id ="";
		if(lineId.equalsIgnoreCase("NONE")){
			id ="NONE";
		}/*else{
			id = addLine.findIdByCode(lineId.trim());
		}
		*/System.out.println("id :" + id);
		return addSupport.findByAreaForNewMapWOMNTGantry(area,lineId,province,deptId,"1");
	}
	
	
	@RequestMapping(value = "/TestMapNewWOMNT/{area}/{lineId}/{province}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> TestMapNewWOMNT(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("province") String province) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("area :" + area);
		System.out.println("lineId :" + lineId);
		System.out.println("province :" + province);
		
		return addSupport.findByAreaForNewMapWOMNT(area,lineId,province,deptId,"1");
	}
	
	
	@RequestMapping(value = "/AEMapNew/{area}/{lineId}/",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> AEMapNew(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId) {
		//String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("area :" + area);
		System.out.println("lineId :" + lineId);
		
		String id ="";
		if(lineId.equalsIgnoreCase("NONE")){
			id ="NONE";
		}else{
			id = addLine.findIdByCode(lineId.trim());
		}
		System.out.println("id :" + id);
		return addSupport.findSupportForAE(area,id);
	}
	
	@RequestMapping(value = "/AEMapINTNew/{area}/{lineId}/",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> AEMapINTNew(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId) {
		//String deptId = request.getSession().getAttribute("deptId").toString();
		return addSupport.findSupportForAE(area,lineId);
	}
	
	@RequestMapping(value = "/NetWorkView",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> NetWorkView(HttpServletRequest request, @RequestParam("id") String id) {
		//String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("id:"+ id);
		ApprovalMm obj = approvalMm.findByID(id);
		System.out.println("obj:"+ obj);
		
		if(obj != null){
			System.out.println("obj.getAreaCode():"+ obj.getAreaCode());
			System.out.println("obj.getLineid():"+ obj.getLineid());
			
			return addSupport.findSupportForAE(obj.getAreaCode().trim(),"NONE");
		}
		return null;
	}
	
	
	
	
	
	@RequestMapping(value = "/findSupportForNetworkView/{area}/{lineId}/{province}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddsupport> findSupportForNetworkView(HttpServletRequest request,@PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("province") String province) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		
		System.out.println("area :" + area);
		System.out.println("lineId :" + lineId);
		System.out.println("province :" + province);
		String id ="";
		if(lineId.equalsIgnoreCase("NONE")){
			id ="NONE";
		}else{
			id = addLine.findIdByCode(lineId.trim());
		}
		System.out.println("id :" + id);
		return addSupport.findByArea(area,id,province,deptId);
	}
	
	@RequestMapping(value = "/findMaintenanceDataForMap/{visitid}/{towerid}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody MmsTxntowermaintenance findMaintenanceDataForMap(@PathVariable("visitid") String visitid,@PathVariable("towerid") String towerid) {
		MmsTxntowermaintenancePK obj = new MmsTxntowermaintenancePK();
		obj.setVisitid(Long.valueOf(visitid));
		obj.setTowerid(Long.valueOf(towerid));
		return towerTxtMaintenance.findByID(obj);
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings("unchecked")
	//GLCOMPM
	@RequestMapping(value = "/findAllDisDivision",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Glcompm> getDistDivision() {
		return glcompmDao.getDistributionDivision();
		
	}
	
	@RequestMapping(value = "/viewDD", method = RequestMethod.GET)
	public ModelAndView viewDD() {
		//System.out.println("viewProvinceNew" +parentId);
		List<Glcompm> dist  = glcompmDao.getDistributionDivision();
		System.out.println("viewProvinceNew1");
		return new ModelAndView("ViewDistDivNew", "dist", dist);
		

	}
	
	
	
	
	
	@RequestMapping(value = "/viewDistributionDivition", method = RequestMethod.GET)
	public ModelAndView viewDistDivision() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewDistDivision");

		return model;

	}
	
	@RequestMapping(value = "/findAllProvincs/{parentId}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Glcompm> getProvincesNew(@PathVariable("parentId") String parentId) {
		return glcompmDao.getProvinces(parentId);
		
	}
	
	@RequestMapping(value = "/findAllProvincs",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Glcompm> getProvincesNewNew(@RequestParam("parentId") String parentId) {
		return glcompmDao.getProvinces(parentId);
		
	}
	
	@RequestMapping(value = "/viewProvinceNew", method = RequestMethod.GET)
	public ModelAndView viewProvinces(HttpServletRequest request,@RequestParam("id") String id,@RequestParam("name") String name) {
		//System.out.println("viewProvinceNew" +parentId);
		List<Glcompm> province  = glcompmDao.getProvinces(id);
		
		//request.getSession().setAttribute("dd", id);
		
		System.out.println("viewProvinceNew1");
		ModelAndView mm = new ModelAndView("ViewProvincesNew", "province", province);
		mm.addObject("name", name);
		return mm;

	}
	
	
	@RequestMapping(value = "/findAllArea/{parentId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Glcompm> getAreas(@PathVariable("parentId") String parentId) {
		System.out.println("findAllArea");
		return glcompmDao.getArea(parentId);
		
	}
	
	@RequestMapping(value = "/findAllAreaNew", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Gldeptm> findAllAreaNew(HttpServletRequest request) {
		System.out.println("findAllArea");
		String deptId =(String)request.getSession().getAttribute("deptId");
		
		return gldeptDao.getArea(deptId);
		
	}
	
	@RequestMapping(value = "/findAllAreaNewMobile/{deptid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Gldeptm> findAllAreaNewMobile(HttpServletRequest request,@PathVariable("deptid") String deptid) {
		System.out.println("findAllArea");
		//String deptId =(String)request.getSession().getAttribute("deptId");
		
		return gldeptDao.getArea(deptid);
		
	}
	
	
	@RequestMapping(value = "/findAllProvincesNewMobile/{deptid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Glcompm> findAllProvincesNewMobile(HttpServletRequest request,@PathVariable("deptid") String deptid) {
		System.out.println("findAllArea");
		String province = deptDao.getDD(deptid.trim());
		System.out.println("findAllAreaprovince : " +province);
		
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("distDivdistDiv : " +distDiv);
		
		List<Glcompm> provinceList = glcompmDao.getProvinces(distDiv);
		return provinceList;
		
	}
	
	
	
	@RequestMapping(value = "/viewAreaNew/{parentId}", method = RequestMethod.GET)
	public ModelAndView viewAreaNew(@PathVariable("parentId") String parentId,HttpServletRequest request) {
		System.out.println("viewAreaNew" +parentId);
		List<Glcompm> province  = glcompmDao.getArea(parentId);
		request.getSession().setAttribute("dd", parentId);
		System.out.println("viewAreaNew");
		return new ModelAndView("ViewAreasNew", "province", province);
		

	}
	
	
	
	@RequestMapping(value = "/ViewDataAssetInfo", method = RequestMethod.GET)
	public ModelAndView ViewDataAssetInfo(HttpServletRequest request) {
		
		return new ModelAndView("ViewDataAssetInfo");
		

	}
	
	@RequestMapping(value = "/viewDataMV", method = RequestMethod.GET)
	public ModelAndView viewDataMV(HttpServletRequest request) {
		
		return new ModelAndView("ViewDataMV");
		

	}
	
	@RequestMapping(value = "/viewGantries", method = RequestMethod.GET)
	public ModelAndView viewGntries(HttpServletRequest request) {
		
		return new ModelAndView("ViewDataGantries");
		

	}
	
	@RequestMapping(value = "/viewSwitces", method = RequestMethod.GET)
	public ModelAndView viewSwitces(HttpServletRequest request) {
		
		return new ModelAndView("ViewSwitches");
		

	}
	
	@RequestMapping(value = "/ViewPESummaryReport", method = RequestMethod.GET)
	public ModelAndView ViewPESummaryReport(HttpServletRequest request,@RequestParam("mode") String mode) {
		//MmsAddline line = new MmsAddline();
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		Map<String,String> lineTypeList = new LinkedHashMap<String,String>();
		Map<String,String> conTypeListforPE = new LinkedHashMap<String,String>();
		
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		System.out.println("province" +province);
		String distDiv = glcompmDao.getDistDivision(province);
		List<Glcompm> line = new ArrayList<Glcompm>();
		if(distDiv.equals("")){
			String provinceAE = glcompmDao.getProvince(province);
			provinceAE= provinceAE.trim();
			System.out.println("provinceAE" +provinceAE);
			//Glcompm ojb =glcompmDao.getGlcompmByProvince(provinceAE);	
			//System.out.println("provinceAE1" +ojb.getCompId());
			Glcompm ojb =new Glcompm();	
			ojb.setCompId(provinceAE);
			if(provinceAE.equalsIgnoreCase("CP")){
				ojb.setCompNm("CENTRAL PROVINCE");
			}else if(provinceAE.equalsIgnoreCase("CP2")){
				ojb.setCompNm("CENTRAL PROVINCE");
			}else if(provinceAE.equalsIgnoreCase("EP")){
				ojb.setCompNm("EASTERN PROVINCE ");
			}else if(provinceAE.equalsIgnoreCase("WPN")){
				ojb.setCompNm("WESTERN PROVINCE NORTH ");
			}
			line.add(ojb);
		}else{
			line = glcompmDao.getProvinces(distDiv);
		}
		
		//List<Glcompm> line =
		
		System.out.println("distDiv" +distDiv);
		
		PivModel model = new PivModel();
		
		//List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		//List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		List<MmsAddlinetype> linetypes = mmsLineTypeDao.findActiveTypes();
		
		int loopTye = linetypes.size()-1;
		for(int i=0;i<=loopTye;i++){ 
			System.out.println(i);
			MmsAddlinetype ojb = linetypes.get(i);
			lineTypeList.put(ojb.getId(), ojb.getLineType());
	      
	    } 
		
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		List<MmsAddconductortype> conListPE =  conTpePeDao.findAll();
		int depLoop = conListPE.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			MmsAddconductortype ojb = (MmsAddconductortype)conListPE.get(i);
			conTypeListforPE.put(ojb.getId(), ojb.getType());
	    } 
		
//		int lineLoop = lineObj.size()-1;
//		for(int i=0;i<=lineLoop;i++){ 
//			System.out.println(i);
//			MmsAddline ojb = lineObj.get(i);
//			lineList.put(ojb.getCode(), ojb.getLineName());
//	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		model.setLineTypeList(lineTypeList);
		model.setConTypeListforPE(conTypeListforPE);
		System.out.println("mode : "+ mode);
		model.setMode(mode);
		return new ModelAndView("ViewTowerLines","model",model);
		

	}
	
	
	@RequestMapping(value = "/ViewPESummaryReportOther", method = RequestMethod.GET)
	public ModelAndView ViewPESummaryReportOther(HttpServletRequest request,@RequestParam("mode") String mode) {
		//MmsAddline line = new MmsAddline();
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		Map<String,String> lineTypeList = new LinkedHashMap<String,String>();
		Map<String,String> conTypeListforPE = new LinkedHashMap<String,String>();
		
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		System.out.println("province" +province);
		Glcompm distDiv = glcompmDao.getDistDivision2(province);
		provinceList.put(distDiv.getCompId(), distDiv.getCompNm());

		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
		int depLoop = deptTm.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			System.out.println(i);
			Gldeptm ojb = (Gldeptm) deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		}
		
		
		
		
		System.out.println("distDiv" +distDiv);
		
		PivModel model = new PivModel();
		
		//List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		//List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		List<MmsAddlinetype> linetypes = mmsLineTypeDao.findActiveTypes();
		
		int loopTye = linetypes.size()-1;
		for(int i=0;i<=loopTye;i++){ 
			System.out.println(i);
			MmsAddlinetype ojb = linetypes.get(i);
			lineTypeList.put(ojb.getId(), ojb.getLineType());
	      
	    } 
		
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		List<MmsAddconductortype> conListPE =  conTpePeDao.findAll();
		int depLoop1 = conListPE.size()-1;
		for(int i=0;i<=depLoop1;i++){ 
			System.out.println(i);
			MmsAddconductortype ojb = (MmsAddconductortype)conListPE.get(i);
			conTypeListforPE.put(ojb.getId(), ojb.getType());
	    } 
		
//		int lineLoop = lineObj.size()-1;
//		for(int i=0;i<=lineLoop;i++){ 
//			System.out.println(i);
//			MmsAddline ojb = lineObj.get(i);
//			lineList.put(ojb.getCode(), ojb.getLineName());
//	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		model.setLineTypeList(lineTypeList);
		model.setConTypeListforPE(conTypeListforPE);
		System.out.println("mode : "+ mode);
		model.setMode(mode);
		return new ModelAndView("ViewTowerLinesOther","model",model);
		

	}

	
	
	
	
	@RequestMapping(value = "/viewTowerLineAE", method = RequestMethod.GET)
	public ModelAndView viewTowerLineAE(HttpServletRequest request,@RequestParam("mode") String mode) {
		//MmsAddline line = new MmsAddline();
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		Map<String,String> lineTypeList = new LinkedHashMap<String,String>();
		Map<String,String> conTypeListforPE = new LinkedHashMap<String,String>();
		
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		System.out.println("province" +province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("distDivhhhhh" +distDiv);
		
		List<Glcompm> line = new ArrayList<Glcompm>();
		
		Glcompm ojb1 =new Glcompm();	
		ojb1.setCompId(distDiv);
		if(distDiv != null){
			distDiv = distDiv.trim();
		}
		if(distDiv.equalsIgnoreCase("CP")){
			System.out.println("distDivhhhhhjjjjj" +distDiv);
			
			ojb1.setCompNm("CENTRAL PROVINCE");
		}else if(distDiv.equalsIgnoreCase("CP2")){
			System.out.println("distDivhhhhhjjjjj" +distDiv);
			
			ojb1.setCompNm("CENTRAL PROVINCE 2");
		}else if(distDiv.equalsIgnoreCase("EP")){
			System.out.println("distDivhhhhhjjjjjhhhh" +distDiv);
			
			ojb1.setCompNm("EASTERN PROVINCE ");
		}else if(distDiv.equalsIgnoreCase("WPN")){
			ojb1.setCompNm("WESTERN PROVINCE NORTH ");
		}
		line.add(ojb1);
		
		
		if(distDiv.equals("")){
			String provinceAE = glcompmDao.getProvince(province);
			provinceAE= provinceAE.trim();
			System.out.println("provinceAE" +provinceAE);
			//Glcompm ojb =glcompmDao.getGlcompmByProvince(provinceAE);	
			//System.out.println("provinceAE1" +ojb.getCompId());
			Glcompm ojb =new Glcompm();	
			ojb.setCompId(provinceAE);
			if(provinceAE.equalsIgnoreCase("CP")){
				ojb.setCompNm("CENTRAL PROVINCE");
			}else if(provinceAE.equalsIgnoreCase("CP2")){
				ojb.setCompNm("CENTRAL PROVINCE 2");
			}else if(provinceAE.equalsIgnoreCase("EP")){
				ojb.setCompNm("EASTERN PROVINCE ");
			}else if(provinceAE.equalsIgnoreCase("WPN")){
				ojb.setCompNm("WESTERN PROVINCE NORTH ");
			}
			line.add(ojb);
		}
		
		//else{
		//	line = glcompmDao.getProvinces(distDiv);
		//}
		
		//List<Glcompm> line =
		
		System.out.println("distDiv" +distDiv);
		
		PivModel model = new PivModel();
		
		//List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findLineByArea(deptId);
		List<String> provinces = new ArrayList<String>();
		List<MmsAddlinetype> linetypes = mmsLineTypeDao.findActiveTypes();
		
		int loopTye = linetypes.size()-1;
		for(int i=0;i<=loopTye;i++){ 
			System.out.println(i);
			MmsAddlinetype ojb = linetypes.get(i);
			lineTypeList.put(ojb.getId(), ojb.getLineType());
	      
	    } 
		
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			System.out.println("province"+i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		List<MmsAddconductortype> conListPE =  conTpePeDao.findAll();
		int depLoop = conListPE.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			MmsAddconductortype ojb = (MmsAddconductortype)conListPE.get(i);
			conTypeListforPE.put(ojb.getId(), ojb.getType());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(ojb.getCode(), ojb.getLineName());
	    } 
		
		areaList.put(deptId, gldeptDao.getName(deptId));
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		model.setLineTypeList(lineTypeList);
		model.setConTypeListforPE(conTypeListforPE);
		System.out.println("mode : "+ mode);
		model.setMode(mode);
		return new ModelAndView("ViewTowerLinesAE","model",model);
		

	}
	
	
	
	
	
	@RequestMapping(value = "/viewMap", method = RequestMethod.GET)
	public ModelAndView viewMap(HttpServletRequest request) {
		//MmsAddline line = new MmsAddline();
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		return new ModelAndView("ViewMapNew","model",model);
		

	}
	
	
	@RequestMapping(value = "/viewTowerLineNew", method = RequestMethod.GET)
	public @ResponseBody Map<String,String> viewTowerLineNew(HttpServletRequest request) {
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId ="600.41";
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		//List<Glcompm> line glcompmDao.getProvinces(distDiv);
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	      
	    }  
		model.setProvinces(provinces);
		return provinceList;
		//return new ModelAndView("ViewTowerLines","line",line);
		

	}
	
	@RequestMapping(value = "/viewMaintenance", method = RequestMethod.GET)
	public ModelAndView viewMaintenance(HttpServletRequest request) {
		
		return new ModelAndView("ViewMaintenance");
		

	}
	
	@RequestMapping(value = "/viewTLMaintenance", method = RequestMethod.GET)
	public ModelAndView viewTLMaintenance(HttpServletRequest request) {
		
		return new ModelAndView("ViewTLMaintenance");
		

	}
	
	@RequestMapping(value = "/viewSchedule", method = RequestMethod.GET)
	public ModelAndView viewSchedule(HttpServletRequest request) {
		
		return new ModelAndView("ViewSchedules");
		

	}
	
	
	
	
	
	
	@RequestMapping(value = "/viewProvinceSchedules", method = RequestMethod.GET)
	public ModelAndView ViewProvinceSchedules(HttpServletRequest request) {
		
		return new ModelAndView("ViewProvinceSchedules");
		

	}
	
	@RequestMapping(value = "/viewPHMSchedule", method = RequestMethod.GET)
	public ModelAndView viewPHMSchedule(HttpServletRequest request) {
		
		return new ModelAndView("ViewPHMBranchchedules");
		

	}
	
	
	
	@RequestMapping(value = "/viewReport", method = RequestMethod.GET)
	public ModelAndView viewReport(HttpServletRequest request) {
		
		return new ModelAndView("ViewReports");
		

	}

	@RequestMapping(value = "/viewTowerLineSummary", method = RequestMethod.GET)
	public ModelAndView viewTowerLineSummary(HttpServletRequest request) {
		
		return new ModelAndView("ViewLineByAreaNew");
		

	}
	
	@RequestMapping(value = "/viewLineDetailNew", method = RequestMethod.GET)
	public ModelAndView viewLineDetailNew(HttpServletRequest request,@RequestParam("id") String id,@RequestParam("dd") String dd,@RequestParam("province") String province,@RequestParam("area") String area) {
		System.out.println("viewLineDetailNew" +id);
		System.out.println("viewLineDetailNewAfter" +id);
		List<MmsAddline> line  = addLine.findLineByArea(id);
		
		//request.getSession().setAttribute("dd", parentId);
		System.out.println("summary");
		ModelAndView mm = new ModelAndView("ViewLineByAreaDetail", "line", line);
		mm.addObject("dd", dd);
		mm.addObject("province", province);
		mm.addObject("area", area);
		return mm;
		
		

	}
	
	@RequestMapping(value = "/viewLineDetailAE", method = RequestMethod.GET)
	public ModelAndView viewLineDetailAE(HttpServletRequest request,@RequestParam("id") String id,@RequestParam("dd") String dd,@RequestParam("province") String province,@RequestParam("area") String area) {
		
		id = (String)request.getSession().getAttribute("deptId");
		
		System.out.println("viewLineDetailNewAfter" +id);
		List<MmsAddline> line  = addLine.findLineByArea(id);
		
		//request.getSession().setAttribute("dd", parentId);
		System.out.println("summary");
		ModelAndView mm = new ModelAndView("ViewLineByAreaDetail", "line", line);
		mm.addObject("dd", dd);
		mm.addObject("province", province);
		mm.addObject("area", area);
		return mm;
		
		

	}
	
	
	@RequestMapping(value = "/findLineByArea", method = RequestMethod.GET)
	public @ResponseBody List<MmsAddline>  findLineByArea(HttpServletRequest request) {
		String deptId =(String)request.getSession().getAttribute("deptId");
		String deptName =(String)request.getSession().getAttribute("deptName");
		return addLine.findLineByArea(deptId);
	}
	
	
	
	
	@RequestMapping(value = "/findLineSummary/{parentId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Summary> findLineSummary(@PathVariable("parentId") String parentId) {
		System.out.println("findAllArea");
		return addLine.findLineSummary(parentId);
		
	}
	
	@RequestMapping(value = "/findDDLineSummary/{parentId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Summary> findDDLineSummary(@PathVariable("parentId") String parentId,HttpServletRequest request) {
		System.out.println("findDDLineSummary");
		String deptId =(String)request.getSession().getAttribute("deptId");
		return addLine.findDDSummary(parentId,deptId);
		
	}
	
	
	@RequestMapping(value = "/lineSummary/{parentId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object lineSummary(@PathVariable("parentId") String parentId,HttpServletRequest request) {
		System.out.println("findDDLineSummary");
		String deptId =(String)request.getSession().getAttribute("deptId");
		return addLine.lineSummary(parentId,deptId);
		
	}
	
	@RequestMapping(value = "/summary/{parentId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Summary> summary(@PathVariable("parentId") String parentId) {
		System.out.println("findAllArea");
		return addLine.findLineSummary(parentId);
		
	}
	
	@RequestMapping(value = "/viewLineSummary", method = RequestMethod.GET)
	public ModelAndView viewLineSummary(@RequestParam("id") String parentId,@RequestParam("dd") String dd,@RequestParam("province") String province,HttpServletRequest request) {
		System.out.println("summary" +parentId);
		List<Summary> summary  = addLine.findLineSummary(parentId.trim());
		
		//request.getSession().setAttribute("dd", parentId);
		System.out.println("summary");
		ModelAndView mm = new ModelAndView("ViewLineSummary", "summary", summary);
		mm.addObject("dd", dd);
		mm.addObject("province", province);
		return mm;

	}
	
	@RequestMapping(value = "/areaViewLineSummary", method = RequestMethod.GET)
	public ModelAndView areaViewLineSummary(@RequestParam("area") String area,HttpServletRequest request) {
		
		List<Summary> summary  = addLine.findLineSummary(area);
		ModelAndView mm = new ModelAndView("ViewLineSummary", "summary", summary);
		mm.addObject("dd", "");
		mm.addObject("province", "");
		return mm;

	}
	
	
	
	
	@RequestMapping(value = "/findLineByArea/{area}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddline> findLineByArea(@PathVariable("area") String area) {
		System.out.println("findLineByAreaddd" +area );
		return addLine.findLineByArea(area);
		
	}
	
	
	@RequestMapping(value = "/findLineByAreaList/{area}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddline> findLineByAreaList(@PathVariable("area") String area) {
		System.out.println("findLineByAreaddd" +area );
		return addLine.findLineByAreaList(area);
		
	}
	
	
	
	
	
	@RequestMapping(value = "/findDD", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String findDD(@RequestParam("deptid") String deptid) {
		System.out.println("findDD" +deptid );
		return deptDao.getDD(deptid);
		
	}
	
	@RequestMapping(value = "/findDistDiv", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String findDistDiv(@RequestParam("province") String province) {
		System.out.println("findDD" +province );
		return glcompmDao.getDistDivision(province);
		
	}
	
	@RequestMapping(value = "/findAllProvincsBydeptid",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Glcompm> getProvincesBydeptId(@RequestParam("deptId") String deptId) {
		String province = deptDao.getDD(deptId);
		String dd = glcompmDao.getDistDivision(province);
		return glcompmDao.getProvinces(dd);
		
	}
	
	@RequestMapping(value = "/viewLineByProvince", method = RequestMethod.POST)
	public ModelAndView viewLineByProvince(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
		System.out.println("Province" +pivModel.getGlcompmobj().getCompId());
		String province = pivModel.getGlcompmobj().getCompId();
		String area = pivModel.getGldeptobj().getDeptId();
		String lineobj = pivModel.getLine().getCode();
		String lineType = pivModel.getLineType().getId();
		
		System.out.println("Province :" +province +"Area :" + area );
		List<Object[]> line  = addLine.findLineByProvinceNew(province,area,lineobj);
		//PivModel pivModelNew = new PivModel();
		//if(line != null){
		//	int linecount = line.size()-1;
			//for(int i=0;i<=linecount;i++){ 
			//	System.out.println(i);
			//	Object[] ojb = line.get(i);
				//pivModelNew.getLine().setCode((String)ojb[2]);
				//String id = String.valueOf(ojb[0]);
				//String lineid = String.valueOf(ojb[1]);
				//int lineequal = id.compareTo(lineid);
				//if(lineequal==)
				
				
				
				//System.out.println(ojb.getCompNm());
				//provinces.add(ojb.getCompNm());
		      
				//provinceList.put(ojb.getCompId(), ojb.getCompNm());
		      
		      
		    //}  
			
			
		
		//}
		
		
		ModelAndView mm = new ModelAndView("ViewLineByProvince", "line", line);
		//mm.addObject("dd", dd);
		if(province.trim().equalsIgnoreCase("NONE")){
			mm.addObject("province", "CP,EP,WPN");
		}else{
			mm.addObject("province", pivModel.getGlcompmobj().getCompId());
		}
		
		//mm.addObject("area", area);
		return mm;
		
		

	}
	
	
	@RequestMapping(value = "/viewNetWork", method = RequestMethod.GET)
	public ModelAndView viewNetWork(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
		//System.out.println("Province" +pivModel.getGlcompmobj().getCompId());
		//String province = pivModel.getGlcompmobj().getCompId();
		//String area = pivModel.getGldeptobj().getDeptId();
		//String line = String.valueOf(pivModel.getLine().getId());
		//List<MmsAddsupport> supportList = addSupport.findByArea(area, line);
		PivModel pivModelNew = new PivModel();
		//pivModelNew.setSupport(supportList);
		
		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		//Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		//List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		//int supLoop = supType.size()-1;
		//for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			//MmsAddsupporttype ojb = supType.get(i);
			//supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    //} 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		//model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		
		ModelAndView mm = new ModelAndView("MMS_NetWorkView" ,"model",model);
		if(province.trim().equalsIgnoreCase("NONE")){
			mm.addObject("province", "CP,EP,WPN");
		}else{
			//mm.addObject("province", pivModel.getGlcompmobj().getCompId());
		}
		return mm;
		
		

	}
	
	
	
	@RequestMapping(value = "/viewSupportByProvince", method = RequestMethod.GET)
	public ModelAndView viewSupportByProvince(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
		//System.out.println("Province" +pivModel.getGlcompmobj().getCompId());
		//String province = pivModel.getGlcompmobj().getCompId();
		//String area = pivModel.getGldeptobj().getDeptId();
		//String line = String.valueOf(pivModel.getLine().getId());
		//List<MmsAddsupport> supportList = addSupport.findByArea(area, line);
		PivModel pivModelNew = new PivModel();
		//pivModelNew.setSupport(supportList);
		
		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		//Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		//List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		//int supLoop = supType.size()-1;
		//for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			//MmsAddsupporttype ojb = supType.get(i);
			//supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    //} 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		//model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		
		ModelAndView mm = new ModelAndView("MMS_Map_New" ,"model",model);
		if(province.trim().equalsIgnoreCase("NONE")){
			mm.addObject("province", "CP,EP,WPN");
		}else{
			//mm.addObject("province", pivModel.getGlcompmobj().getCompId());
		}
		return mm;
		
		

	}
	
	
	@RequestMapping(value = "/viewNewMap", method = RequestMethod.GET)
	public ModelAndView viewNewMap(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
		//System.out.println("Province" +pivModel.getGlcompmobj().getCompId());
		//String province = pivModel.getGlcompmobj().getCompId();
		//String area = pivModel.getGldeptobj().getDeptId();
		//String line = String.valueOf(pivModel.getLine().getId());
		//List<MmsAddsupport> supportList = addSupport.findByArea(area, line);
		PivModel pivModelNew = new PivModel();
		//pivModelNew.setSupport(supportList);
		
		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		//Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		//List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		//int supLoop = supType.size()-1;
		//for(int i=0;i<=supLoop;i++){ 
			//System.out.println(i);
			//MmsAddsupporttype ojb = supType.get(i);
			//supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    //} 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		//model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		
		ModelAndView mm = new ModelAndView("MMS_Map_TM" ,"model",model);
		if(province.trim().equalsIgnoreCase("NONE")){
			mm.addObject("province", "CP,EP,WPN");
		}else{
			//mm.addObject("province", pivModel.getGlcompmobj().getCompId());
		}
		return mm;
		
		

	}
	
	
	
	
	@RequestMapping(value = "/findLineByProvinceNew",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> findLineByProvinceNew(@RequestParam("province") String province,@RequestParam("area") String area,@RequestParam("line") String line) {
		
		return addLine.findLineByProvinceNew(province, area, line);
	}
	
	
	
	
	@RequestMapping(value = "/editSupoortByAreaLine", method = RequestMethod.GET)
	public ModelAndView editSupoortByAreaLine(HttpServletRequest request) {
		
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
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		//model.setMode(mode);
		return new ModelAndView("editSupoortByAreaLine","model",model);
		
		
		
		
		
		
		
		
		
		
		//return new ModelAndView("ViewHotlineMaintenance");
		

	}
	
	@RequestMapping(value = "/editMaintenance", method = RequestMethod.GET)
	public ModelAndView editMaintenance(HttpServletRequest request) {
		
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
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		//model.setMode(mode);
		return new ModelAndView("EditTowerMaintenance","model",model);
		
		
		
		
		
		
		
		
		
		
		//return new ModelAndView("ViewHotlineMaintenance");
		

	}
	
	
	@RequestMapping(value = "/ViewScheduleAndReport", method = RequestMethod.GET)
	public ModelAndView ViewScheduleAndReport(HttpServletRequest request,@RequestParam("mode") String mode) {
		
		Map<Long,String> lineList = new LinkedHashMap<Long,String>();
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
				lineList.put(ojb.getId(), ojb.getLineName());
			
			
		    }
		}
		}
		System.out.println("ppppp");

		
		/*if(model.getCycleObj().getId().getCycleId() != null){
			
		}
		*/
		/*int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } */
		
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
		model.setLineListNew(lineList);
		model.setMode(mode);
		
		
		
		return new ModelAndView("ViewHotlineMaintenance","model",model);
		
		
		
		
		
		
		
		
		
		
		//return new ModelAndView("ViewHotlineMaintenance");
		

	}
	
	
	@RequestMapping(value = "/IntSumReportCC", method = RequestMethod.GET)
	public ModelAndView IntSumReportCC(HttpServletRequest request,@RequestParam("mode") String mode) {
		
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
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		/*int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } */
		
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
		return new ModelAndView("IntSumReportCC","model",model);
		
		
		
		
		
		
		
		
		
		
		//return new ModelAndView("ViewHotlineMaintenance");
		

	}

	
	
	@RequestMapping(value = "/ViewProvincialScheduleAE", method = RequestMethod.GET)
	public ModelAndView ViewProvincialScheduleAE(HttpServletRequest request,@RequestParam("mode") String mode) {
		
		Map<Long,String> lineList = new LinkedHashMap<Long,String>();
		System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		String deptId =(String)request.getSession().getAttribute("deptId");
		List<MmsAddline> lineObj = addLine.findLineByArea(deptId);
		
		String phmbranch="";
		String province = deptDao.getDD(deptId);
		System.out.println("hi1 : " + deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);
		
		if(distDiv.equalsIgnoreCase("CP")){
			phmbranch="600.41";
			
		}else if(distDiv.equalsIgnoreCase("CP2")){
			phmbranch="600.41";
			
		}else if(distDiv.equalsIgnoreCase("WPN")){
			phmbranch="600.41";
			
		}else if(distDiv.equalsIgnoreCase("EP")){
			phmbranch="600.41";
			
		}else if(distDiv.equalsIgnoreCase("NP")){
			phmbranch="596.00";
			
		}else if(distDiv.equalsIgnoreCase("NWP")){
			phmbranch="596.00";
			
		}else if(distDiv.equalsIgnoreCase("NWP2")){
			phmbranch="596.00";
			
		}else if(distDiv.equalsIgnoreCase("NCP")){
			phmbranch="596.00";
			
		}else if(distDiv.equalsIgnoreCase("UVAP")){
			phmbranch="780.00";
			
		}else if(distDiv.equalsIgnoreCase("SABP")){
			phmbranch="780.00";
			
		}else if(distDiv.equalsIgnoreCase("WPSII")){
			phmbranch="780.00";
			
		}else{
			phmbranch="600.41";
		}
		
		/*Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		String province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);*/
		PivModel model = new PivModel();
	/*	List<Glcompm> line = glcompmDao.getProvinces(distDiv);
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
	      
	    } */
		
	/*	int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } */
		
		/*int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } */
		
//		int lineLoop = lineObj.size()-1;
//		for(int i=0;i<=lineLoop;i++){ 
//			System.out.println(i);
//			MmsAddline ojb = lineObj.get(i);
//			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
//	    } 
		//model.setSupTypeList(supportTypeList);
		//model.setProvinceList(provinceList);
		
		areaList.put(deptId, gldeptDao.getName(deptId));
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(ojb.getId(), ojb.getLineName());
	    } 
		
		
		
		Map<String,String> cycle = new LinkedHashMap<String,String>();
		
		
		
		List<Long> cycleList = cycleDao.fineMntAvailCycle(deptId);
		
		//List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(phmbranch);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			Long ojb = cycleList.get(i);
			cycle.put(String.valueOf(ojb), String.valueOf(ojb));
	      
	    } 


		model.setCycleList(cycle);
		model.setAreaList(areaList);
		model.setLineListLong(lineList);
		model.setMode(mode);
		return new ModelAndView("ViewHotlineMaintenanceAE","model",model);
		
		
		
		
		
		
		
		
		
		
		//return new ModelAndView("ViewHotlineMaintenance");
		

	}
	
	@RequestMapping(value = "/ViewProvincialScheduleOther", method = RequestMethod.GET)
	public ModelAndView ViewProvincialScheduleOther(HttpServletRequest request,@RequestParam("mode") String mode) {
		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		System.out.println("hi");
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		String deptId =(String)request.getSession().getAttribute("deptId");
		//List<MmsAddline> lineObj = addLine.findLineByArea(deptId);
		
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		String province = deptDao.getDD(deptId);
		
		Glcompm distDiv = glcompmDao.getDistDivision2(province);
		provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
		
		
		/*if(province.equalsIgnoreCase("CP")){
			phmbranch="600.41";
			
		}else if(province.equalsIgnoreCase("CP2")){
			phmbranch="600.41";
			
		}else if(distDiv.equalsIgnoreCase("WPN")){
			phmbranch="600.41";
			
		}else if(distDiv.equalsIgnoreCase("EP")){
			phmbranch="600.41";
			
		}else if(distDiv.equalsIgnoreCase("NP")){
			phmbranch="596.00";
			
		}else if(distDiv.equalsIgnoreCase("NWP")){
			phmbranch="596.00";
			
		}else if(distDiv.equalsIgnoreCase("NWP2")){
			phmbranch="596.00";
			
		}else if(distDiv.equalsIgnoreCase("NCP")){
			phmbranch="596.00";
			
		}else if(distDiv.equalsIgnoreCase("UVAP")){
			phmbranch="780.00";
			
		}else if(distDiv.equalsIgnoreCase("SABP")){
			phmbranch="780.00";
			
		}else if(distDiv.equalsIgnoreCase("WPSII")){
			phmbranch="780.00";
			
		}else{
			phmbranch="600.41";
		}*/
		
		
		
		
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    }
		
		/*Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		System.out.println("hi1 : " + deptId);
		String province = deptDao.getDD(deptId);
		System.out.println("hi2 : " + province);
		String distDiv = glcompmDao.getDistDivision(province);
		System.out.println("hi3 : " + distDiv);*/
		PivModel model = new PivModel();
	/*	List<Glcompm> line = glcompmDao.getProvinces(distDiv);
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
	      
	    } */
		
	/*	int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } */
		
		/*int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } */
		
//		int lineLoop = lineObj.size()-1;
//		for(int i=0;i<=lineLoop;i++){ 
//			System.out.println(i);
//			MmsAddline ojb = lineObj.get(i);
//			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
//	    } 
		//model.setSupTypeList(supportTypeList);
		//model.setProvinceList(provinceList);
		
		//areaList.put(deptId, gldeptDao.getName(deptId));
		
		/*int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		*/
		
		Map<String,String> cycle = new LinkedHashMap<String,String>();
		List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle("600.41");
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			MvmmsCycle ojb = cycleList.get(i);
			cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
	      
	    } 

		
/*List<Long> cycleList = cycleDao.fineMntAvailCycle(deptId);
		
		//List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(phmbranch);
		int cycleLisuCount = cycleList.size()-1;
		for(int i=0;i<=cycleLisuCount;i++){ 
			//System.out.println(i);
			Long ojb = cycleList.get(i);
			cycle.put(String.valueOf(ojb), String.valueOf(ojb));
	      
	    } 
*/
        model.setProvinceList(provinceList);
		model.setCycleList(cycle);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		model.setMode(mode);
		return new ModelAndView("ViewHotlineMaintenanceOtherNew","model",model);
		
		
		
		
		
		
		
		
		
		
		//return new ModelAndView("ViewHotlineMaintenance");
		

	}

	
	
	@RequestMapping(value = "/viewElectricalWorksOnPoles", method = RequestMethod.GET)
	public ModelAndView ViewElectricalWorksOnPoles(HttpServletRequest request,@RequestParam("mode") String mode) {
		
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
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		model.setMode(mode);
		return new ModelAndView("ViewElectricalWorksOnPoles","model",model);
		
	}
	
	
	@RequestMapping(value = "/viewVegitationSchedule", method = RequestMethod.GET)
	public ModelAndView ViewVegitationSchedule(HttpServletRequest request,@RequestParam("mode") String mode) {
		
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
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		model.setMode(mode);
		return new ModelAndView("ViewVegitationSchedule","model",model);
		
	}
	
	
	@RequestMapping(value = "/viewMissingPartsSchedule", method = RequestMethod.GET)
	public ModelAndView ViewMissingPartsSchedule(HttpServletRequest request,@RequestParam("mode") String mode) {
		
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
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		model.setMode(mode);
		return new ModelAndView("ViewMissingPartsSchedule","model",model);
		
	}
	
	
	@RequestMapping(value = "/viewTTWTapping", method = RequestMethod.GET)
	public ModelAndView viewTTWTapping(HttpServletRequest request) {
		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		return new ModelAndView("ViewTensionTWT","model",model);
		
		
		
		
		
		
		
		
		
		
		//return new ModelAndView("ViewHotlineMaintenance");
		

	}
	
	@RequestMapping(value = "/viewColdLine", method = RequestMethod.GET)
	public ModelAndView viewColdLine(HttpServletRequest request) {
		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		return new ModelAndView("ViewColdLine","model",model);
		
		
		
		
		
		
		
		
		
		
		//return new ModelAndView("ViewHotlineMaintenance");
		

	}
	
	@RequestMapping(value = "/viewColdLineCivil", method = RequestMethod.GET)
	public ModelAndView viewColdLineCivil(HttpServletRequest request) {
		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		model.setEstimateType("CIVIL");
		return new ModelAndView("ViewColdLineCivil","model",model);
		
		
		
		
		
		
		
		
		
		
		//return new ModelAndView("ViewHotlineMaintenance");
		

	}
	
	
	
/**	@RequestMapping(value = "/viewHotlineMaintenance", method = RequestMethod.GET)
	public ModelAndView ViewHotlineMaintenance(HttpServletRequest request,@RequestParam("mode") String mode) {
		
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
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		model.setMode(mode);
		return new ModelAndView("ViewHotlineMaintenance","model",model);
		
		
		
		
		
		
		
		
		
		
		//return new ModelAndView("ViewHotlineMaintenance");
		

	}
	
	
	@RequestMapping(value = "/viewTTWTapping", method = RequestMethod.GET)
	public ModelAndView viewTTWTapping(HttpServletRequest request) {
		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		return new ModelAndView("ViewTensionTWT","model",model);
		
		
		
		
		
		
		
		
		
		
		//return new ModelAndView("ViewHotlineMaintenance");
		

	}
	
	@RequestMapping(value = "/viewColdLine", method = RequestMethod.GET)
	public ModelAndView viewColdLine(HttpServletRequest request) {
		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		return new ModelAndView("ViewColdLine","model",model);
		
		
		
		
		
		
		
		
		
		
		//return new ModelAndView("ViewHotlineMaintenance");
		

	}
	
	@RequestMapping(value = "/viewColdLineCivil", method = RequestMethod.GET)
	public ModelAndView viewColdLineCivil(HttpServletRequest request) {
		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		return new ModelAndView("ViewColdLineCivil","model",model);
		
		
		
		
		
		
		
		
		
		
		//return new ModelAndView("ViewHotlineMaintenance");
		

	}*/
	
	@RequestMapping(value = "/spObservation", method = RequestMethod.GET)
	public ModelAndView spObservation(HttpServletRequest request) {
		
		Map<String,String> lineList = new LinkedHashMap<String,String>();
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		PivModel model = new PivModel();
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(province);
		List<MmsAddsupporttype> supType = supTypeDao.findAll();
		List<MmsAddline> lineObj = addLine.findAll();
		List<String> provinces = new ArrayList<String>();
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
			System.out.println(i);
		  Glcompm ojb = line.get(i);
		  
		  System.out.println(ojb.getCompNm());
	      provinces.add(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int supLoop = supType.size()-1;
		for(int i=0;i<=supLoop;i++){ 
			System.out.println(i);
			MmsAddsupporttype ojb = supType.get(i);
			supportTypeList.put(ojb.getId(), ojb.getSupportType());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		int lineLoop = lineObj.size()-1;
		for(int i=0;i<=lineLoop;i++){ 
			System.out.println(i);
			MmsAddline ojb = lineObj.get(i);
			lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
	    } 
		model.setSupTypeList(supportTypeList);
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		return new ModelAndView("ViewSpecialObservation","model",model);
		
		
		
		
		
		
		
		
		
		
		//return new ModelAndView("ViewHotlineMaintenance");
		

	}
	
	@RequestMapping(value = "/createInsEstimate", method = RequestMethod.GET)
	public ModelAndView createInsEstimate(HttpServletRequest request) {
		
		//Map<String,String> lineList = new LinkedHashMap<String,String>();
		
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		//Map<String,String> provinceList = new LinkedHashMap<String,String>();
		//Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		//String distDiv = glcompmDao.getDistDivision(province);
		String dist = glcompmDao.getDistDivision(province);
		System.out.println(dist);
		PivModel model = new PivModel();
		//List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(dist);
			
	
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		
		model.setAreaList(areaList);
		
		return new ModelAndView("CreateInspectionEstimate","model",model);
		
		
		
		
		
		
		
		
		
		
		//return new ModelAndView("ViewHotlineMaintenance");
		

	}
	
	
	
	
	@RequestMapping(value = "/getAreaByDistDiv",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Gldeptm> getAreaByDistDiv(@RequestParam("dist") String dist) {
		
		return gldeptDao.getAreaByDisDiv(dist);
		
		
		
		
	}
	
	@RequestMapping(value = "/viewDDForInsEstimate", method = RequestMethod.GET)
	public ModelAndView viewDDForInsEstimate(HttpServletRequest request) {
		//System.out.println("viewProvinceNew" +parentId);
		String deptId =(String)request.getSession().getAttribute("deptId");
		//String 
		System.out.println("deptId" +deptId);
		String province = deptDao.getDD(deptId);
		System.out.println("province" +province);
		String dd = glcompmDao.getDistDivision(province);
		System.out.println("dd" +dd);
		List<Glcompm> dist  = glcompmDao.getProvinces(dd);
		System.out.println("ViewDistDivNewForInsEst");
		return new ModelAndView("ViewDistDivNewForInsEst", "dist", dist);
		

	}
	
	@RequestMapping(value = "/ViewSummaryForInsEst", method = RequestMethod.GET)
	public ModelAndView GenerateInsEst(@RequestParam("id") String parentId,@RequestParam("dd") String dd,@RequestParam("province") String province,HttpServletRequest request) {
		System.out.println("summary" +parentId);
		List<Summary> summary  = addLine.findLineSummary(parentId.trim());
		System.out.println("summary");
		ModelAndView mm = new ModelAndView("createInsEst", "summary", summary);
		mm.addObject("dd", dd);
		mm.addObject("province", province);
		return mm;

	}
	
	@RequestMapping(value = "/GenerteInsEstimate", method = RequestMethod.GET)
	public ModelAndView GenerteInsEstimate(@RequestParam("id") String parentId,@RequestParam("dd") String dd,@RequestParam("province") String province,HttpServletRequest request) {
		System.out.println("summary" +parentId);
		List<Summary> summary  = addLine.findLineSummary(parentId.trim());
		
		//request.getSession().setAttribute("dd", parentId);
		System.out.println("summary");
		ModelAndView mm = new ModelAndView("createInsEst", "summary", summary);
		mm.addObject("dd", dd);
		mm.addObject("province", province);
		return mm;

	}
	
	
	/**@RequestMapping(value = "/ViewInsEstDetail", method = RequestMethod.GET)
	public ModelAndView ViewInsEstDetail(@RequestParam("area") String area,@RequestParam("lineLength") String lineLength,@RequestParam("nooftower") String nooftower,@RequestParam("id") String parentId,@RequestParam("dd") String dd,@RequestParam("province") String province,HttpServletRequest request) {
		PivModel model = new PivModel();
		MmsInspection obj = new MmsInspection();
		obj.setTotalLineLength(new BigDecimal(lineLength));
		obj.setTotalNoTowers(new BigDecimal(nooftower));
		double no_tower =Double.valueOf(nooftower).doubleValue();
		double no_days_for_the_ins = no_tower/27;
		obj.setNoDaysForTheIns(new BigDecimal(no_days_for_the_ins));
		model.setInspection(obj);
		ModelAndView mm = new ModelAndView("ViewInsEstDetail", "model",model);
		mm.addObject("lineLength", lineLength);
		mm.addObject("nooftower", nooftower);
		//mm.addObject("nooftower", nooftower);
		mm.addObject("area", area);
		return mm;

	}*/
	
	@RequestMapping(value = "/saveSPS", method = RequestMethod.POST)
	public ModelAndView saveSPS(@ModelAttribute("pivModel") PivModel pivModel,HttpServletRequest request){
		System.out.println("hii new SPS");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String userName =(String)request.getSession().getAttribute("loggedUser");
		
		try{
			String allocated_To = pivModel.getSauserm().getUserId();
			System.out.println("allocated_To "+ allocated_To); 
			Application application = createApplicationObject(deptId,userName,pivModel);
			//SpestedyCon spCon = addAppointment(deptId,userName,)
			String estimateNo = appDao.saveSPS(deptId,userName,allocated_To,application, pivModel);
			PivModel model = new PivModel();
			ModelAndView mm = new ModelAndView("ViewInsEstDetail", "pivModel",model);
		
		
			SausermMm userMm = null;
			if(allocated_To != null){
				try {
					System.out.println("allocated_To "+ allocated_To); 
					
					userMm =secDao.getSausermMms(allocated_To.trim());
					ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
				 	MailMail mmemail = (MailMail) context.getBean("mailMail");
				    //mm.sendMail(userMm.getUserNm(), "Please send me the dedails");
				 	if(userMm != null){
				 	if(userMm.getEmail() != null){
				 		mmemail.sendMailTo(userMm.getUserNm(), "Inspection Estimate is created .Please check : "+ estimateNo + " \n\n Thank You" ,userMm.getEmail(),"Inspection Estimate : "+ estimateNo);
				 		mmemail.sendMailTo(userMm.getUserNm(), "Inspection Estimate is created .Please check : "+ estimateNo + " \n\n Thank You" ,"gchampika28@gmail.com","Inspection Estimate : "+ estimateNo);
					    
				 	}
				 	}
				 	
				 	String url="";
				 	String my="";
				 	if(userMm != null){
					 	
				 	if(userMm.getTelNo() != null){
					 	
				    url="http://smsgw.ceb/SMSPlatform.php?recipients="+userMm.getTelNo()+"&smsbody=Inspection Estimate is created .Please check : "+ estimateNo+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
				    my="http://smsgw.ceb/SMSPlatform.php?recipients=0174537313&smsbody=Inspection Estimate is created .Please check : "+ estimateNo+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
				 	
				 	}
				 	}
				    RestTemplate restTemplate = new RestTemplate();
					
					//Util.trustEveryone();
					
					restTemplate.getForObject(url, String.class);
					restTemplate.getForObject(my, String.class);
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		
		
		}catch(Exception e){
			System.out.println("hii new SPS e :"+ e); 
		}
		return null;
	}
	
	
	@RequestMapping(value = "/saveInspectionEstimate/{id}/", method = RequestMethod.GET)
	public @ResponseBody String saveInspectionEstimate(HttpServletRequest request,@PathVariable("id") String id){
		System.out.println("hii new SPS");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String userName =(String)request.getSession().getAttribute("loggedUser");
		PivModel pivModel =new PivModel();
		try{
			String allocated_To = userName;
			System.out.println("allocated_To "+ allocated_To); 
			Application application = createApplicationObject(deptId,userName,pivModel);
			System.out.println("allocated_To  1"); 
			ApprovalMm approval = approvalMm.findByID(id);
			pivModel.setIntRequestObj(approval);
			String description = "The estimated is created according to the request of "+approval.getReferenceNo().toLowerCase()+" through  MVMMS for request number " + approval.getApprovalId();
			pivModel.setSpsdescription(description);
			String estimateNo = appDao.saveSPSBreakDown(deptId,userName,allocated_To,application, pivModel);
			//PivModel model = new PivModel();
			System.out.println("estimateNo : "+ estimateNo); 
			System.out.println("id : "+ id); 
				
		approval = approvalMm.findByID(id);
		approval.setToStatus("98");
		approval.setSystemBy(estimateNo);
		approvalMm.update(approval);
		return estimateNo;
		
		}catch(Exception e){
			System.out.println("hii new SPS e :"+ e); 
		}
		return null;
	}
	
	@RequestMapping(value = "/saveColdLineCivilEstimate", method = RequestMethod.GET)
	public @ResponseBody String saveColdLineCivilEstimate(HttpServletRequest request,@RequestParam("area") String area,@RequestParam("cycle") String cycle,@RequestParam("allocatedTo") String allocatedTo,@RequestParam("idno") String idno){
		System.out.println("hii new SPS");
		String deptId =(String)request.getSession().getAttribute("deptId");
		String userName =(String)request.getSession().getAttribute("loggedUser");
		PivModel pivModel =new PivModel();
		try{
			String allocated_To = allocatedTo;
			System.out.println("allocated_To "+ allocated_To); 
			pivModel.setIdNo(idno);
			Application application = createApplicationObject(deptId,userName,pivModel);
			System.out.println("allocated_To  1"); 
			pivModel.setDescription("Cold Line Civil Electrical Maintenance of "+ area + "- Cycle " +cycle);
			pivModel.setType("CIVIL");
			pivModel.setEstimateType("CIVIL");
			
			String estimateNo = appDao.saveSPS(deptId,userName,allocated_To,application, pivModel);
			//PivModel model = new PivModel();
			
		/*ApprovalMm approval = approvalMm.findByID(id);
		approval.setToStatus("98");
		approval.setSystemBy(estimateNo);
		approvalMm.update(approval);
		*/return estimateNo;
		
		}catch(Exception e){
			System.out.println("hii new SPS e :"+ e); 
		}
		return null;
	}
	
	
	
	private Pcestdtt populatePcestdttsLabour(String costCenter,MmsInspection inspectionn){
		
	 	Long revNo = 2l;
        String genRes = "F";
        String normDefault = "F";
	       
		
        Pcestdtt pcestdtt = new Pcestdtt();
		PcestdttPK pcestdttPk = new PcestdttPK();
		pcestdttPk.setDeptId(costCenter);
		pcestdttPk.setEstimateNo("MVMMS");
		pcestdttPk.setResCd("LABOUR");
		pcestdttPk.setRevNo(revNo);
				
		pcestdtt.setId(pcestdttPk);
		pcestdtt.setResCat(new BigDecimal(2));
		pcestdtt.setEstimateCost(inspectionn.getLabourValueForEst());
		pcestdtt.setEstimateQty(inspectionn.getLabourHoursForEst());
		pcestdtt.setResType("LABOUR-COST");
		pcestdtt.setUom("NO");
		System.out.println("Hi unit price");
		pcestdtt.setUnitPrice(new BigDecimal(600));
		pcestdtt.setNormDefault(normDefault);
		pcestdtt.setGenRes(genRes);
		return null;
	}
	
private Pcestdtt populatePcestdttsTranport(String costCenter,MmsInspection inspectionn){
		
	 	Long revNo = 2l;
        String genRes = "F";
        String normDefault = "F";
	       
		
        Pcestdtt pcestdtt = new Pcestdtt();
		PcestdttPK pcestdttPk = new PcestdttPK();
		pcestdttPk.setDeptId(costCenter);
		pcestdttPk.setEstimateNo("MVMMS");
		pcestdttPk.setResCd("LABOUR");
		pcestdttPk.setRevNo(revNo);
				
		pcestdtt.setId(pcestdttPk);
		pcestdtt.setResCat(new BigDecimal(2));
		pcestdtt.setEstimateCost(inspectionn.getLabourValueForEst());
		pcestdtt.setEstimateQty(inspectionn.getLabourHoursForEst());
		pcestdtt.setResType("LABOUR-COST");
		pcestdtt.setUom("NO");
		System.out.println("Hi unit price");
		pcestdtt.setUnitPrice(new BigDecimal(600));
		pcestdtt.setNormDefault(normDefault);
		pcestdtt.setGenRes(genRes);
		return null;
	}
	
	
		
	

	@RequestMapping(value = "/ViewInsEstDetail", method = RequestMethod.GET)
	public ModelAndView ViewInsEstDetail(@ModelAttribute("pivModel") PivModel pivModel,@RequestParam("area") String area,@RequestParam("lineLength") String lineLength,@RequestParam("nooftower") String nooftower,@RequestParam("id") String parentId,@RequestParam("dd") String dd,@RequestParam("province") String province,HttpServletRequest request) {
		PivModel model = new PivModel();
		MmsInspection obj = new MmsInspection();
		obj.setTotalLineLength(new BigDecimal(lineLength));
		obj.setTotalNoTowers(new BigDecimal(nooftower));
		double no_tower =Double.valueOf(nooftower).doubleValue();
		double no_days_for_the_ins = no_tower/27;
		//Round.
		double labou_hours_for_the_estimate = 9*no_days_for_the_ins*9;
		double labou_value_for_the_estimate = 9*no_days_for_the_ins*9*Util.LABOUR;
		double subsistance = labou_hours_for_the_estimate*400/9*(30/22); 
		double hotlineallowance = 16000*no_days_for_the_ins;
		double temparary_site_cost = no_days_for_the_ins*(1/22)*30000;
		double transportManual = 0.0;
		System.out.println(province);
		if(province.equalsIgnoreCase("CENTRAL PROVINCE")){
			transportManual = no_tower*8;
		}else if(province.equalsIgnoreCase("WESTERN PROVINCE NORTH")){
			transportManual =no_tower*4;
		}else if(province.equalsIgnoreCase("EASTERN PROVINCE")){
			transportManual =no_tower*8;
		}else{
			 transportManual = 0.0;
		}
		double transport_cost = (transportManual *45) +(transportManual*55);
		
		System.out.println("no_days_for_the_ins :" +no_days_for_the_ins);
		
		System.out.println("no_days_for_the_ins :" +no_days_for_the_ins);
		obj.setTransport(new BigDecimal("0"));
		obj.setTransportManual(new BigDecimal(transportManual));
		obj.setNoDaysForTheIns(new BigDecimal(no_days_for_the_ins));
		obj.setLabourHoursForEst(new BigDecimal(labou_hours_for_the_estimate));
		obj.setLabourValueForEst(new BigDecimal(labou_value_for_the_estimate));
		obj.setSubsistance(new BigDecimal(subsistance));
		obj.setHotLineAllowances(new BigDecimal(hotlineallowance));
		if(temparary_site_cost <=30000){
			obj.setTemporarySiteCost(new BigDecimal(30000));
			
		}else{
			obj.setTemporarySiteCost(new BigDecimal(temparary_site_cost));
			
		}
		double total = labou_value_for_the_estimate + subsistance + hotlineallowance + temparary_site_cost+ transport_cost;
		obj.setTatalCost(new BigDecimal(total));
		model.setInspection(obj);
		Map<String,String> sauserList = new LinkedHashMap<String,String>();
		Map<String,String> areaList = new LinkedHashMap<String,String>();
		Map<String,String> provinceList = new LinkedHashMap<String,String>();
		Map<String,String> saList = new LinkedHashMap<String,String>();
		Map<String,String> appList = new LinkedHashMap<String,String>();
		
		String userName =(String)request.getSession().getAttribute("loggedUser");
		String deptId =(String)request.getSession().getAttribute("deptId");
		
		String provinceDD = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(provinceDD);
		List<Glcompm> line = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getArea(province);
		List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId,"ES");
		List<Applicant> appliList = applicantDao.getAllApplicantBydeptId(deptId);
		
		int loopApp = appliList.size()-1;
		for(int i=0;i<=loopApp;i++){ 
		  System.out.println(i);
		  Applicant ojb = appliList.get(i);
		  System.out.println(ojb.getIdNo());
		  appList.put(ojb.getIdNo(), ojb.getFullName());
	      
	    } 
		
		
		int loopSa = saUserList.size()-1;
		for(int i=0;i<=loopSa;i++){ 
		  System.out.println(i);
		  Sauserm ojb = saUserList.get(i);
		  System.out.println(ojb.getUserId());
		  saList.put(ojb.getUserId(), ojb.getUserNm());
	      
	    } 
		
		
		
		int loop = line.size()-1;
		for(int i=0;i<=loop;i++){ 
		  System.out.println(i);
		  Glcompm ojb = line.get(i);
		  System.out.println(ojb.getCompNm());
	      provinceList.put(ojb.getCompId(), ojb.getCompNm());
	      
	    } 
		
		int depLoop = deptTm.size()-1;
		for(int i=0;i<=depLoop;i++){ 
			System.out.println(i);
			Gldeptm ojb = (Gldeptm)deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
	    } 
		
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setSaList(saList);
		model.setAppList(appList);
		ModelAndView mm = new ModelAndView("ViewInsEstDetail", "pivModel",model);
		//mm.addObject("lineLength", lineLength);
		//mm.addObject("Total Number of Towers in Area", nooftower);
		//mm.addObject("nooftower", nooftower);
		mm.addObject("area", area);
		//mm.addObject("no_days_for_the_ins", no_days_for_the_ins);
		//mm.addObject("labour_hours_for_the_ins", labou_hours_for_the_estimate);
		//mm.addObject("labour_value_for_the_ins", labou_value_for_the_estimate);
		//mm.addObject("subsistance", subsistance);
		//mm.addObject("hotlineallowance", hotlineallowance);
		//mm.addObject("temparary_site_cost", temparary_site_cost);
		
		return mm;

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
			if(model.getApplicant()!=null){
				application.setIdNo(model.getApplicant().getIdNo());
			}else{
				application.setIdNo("d600160003");
					
			}
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
			if(model.getInspection() != null){
			application.setDescription ("Total Line Length : "+model.getInspection().getTotalLineLength() + " Total Number Of tower : " +model.getInspection().getTotalNoTowers() );
			}//appDao.save(application);
			System.out.println("hii hii" );
			return application;
			
		}
	 
	 
	 /*@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
		public ModelAndView dashboard(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
			
			//System.out.println("Province" +pivModel.getGlcompmobj().getCompId());
					//String province = pivModel.getGlcompmobj().getCompId();
					//String area = pivModel.getGldeptobj().getDeptId();
					//String line = String.valueOf(pivModel.getLine().getId());
					//List<MmsAddsupport> supportList = addSupport.findByArea(area, line);
					PivModel pivModelNew = new PivModel();
					//pivModelNew.setSupport(supportList);
					
					
					Map<String,String> lineList = new LinkedHashMap<String,String>();
					
					Map<String,String> areaList = new LinkedHashMap<String,String>();
					Map<String,String> provinceList = new LinkedHashMap<String,String>();
					//Map<String,String> supportTypeList = new LinkedHashMap<String,String>();
					String userName =(String)request.getSession().getAttribute("loggedUser");
					String deptId =(String)request.getSession().getAttribute("deptId");
					String province = deptDao.getDD(deptId);
					String distDiv = glcompmDao.getDistDivision(province);
					PivModel model = new PivModel();
					List<Glcompm> line = glcompmDao.getProvinces(distDiv);
					//List<Gldeptm> deptTm = gldeptDao.getArea(province);
					List<Summary> summary = addLine.findDDSummary("DISCO2", deptId);
					
					//edit anushka 2018-12-28-----------------------------------------------------------------------------------------------------
					List<Summary> areaSummary = addLine.findAreaSummary(deptId);
					//----------------------------------------------------------------------------------------------------------------------------
					
					//List<MmsAddsupporttype> supType = supTypeDao.findAll();
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
					//provinceList.put("NONE","ALL");
					
					//int supLoop = supType.size()-1;
					//for(int i=0;i<=supLoop;i++){ 
						//System.out.println(i);
						//MmsAddsupporttype ojb = supType.get(i);
						//supportTypeList.put(ojb.getId(), ojb.getSupportType());
				      
				    //} 
					
					int depLoop = deptTm.size()-1;
					for(int i=0;i<=depLoop;i++){ 
						System.out.println(i);
						Gldeptm ojb = (Gldeptm)deptTm.get(i);
						areaList.put(ojb.getDeptId(), ojb.getDeptNm());
				    } 
					areaList.put("NONE", "ALL");
					int lineLoop = lineObj.size()-1;
					for(int i=0;i<=lineLoop;i++){ 
						System.out.println(i);
						MmsAddline ojb = lineObj.get(i);
						lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
				    } 
					
					//lineList.put("NONE","ALL");
					//model.setSupTypeList(supportTypeList);
					model.setProvinceList(provinceList);
					model.setAreaList(areaList);
					model.setLineList(lineList);
					model.setSummaryList(summary);
					
					//edit anushka 2018-12-28-----------------------------------------------------------------------------------------------------
					model.setAreaSummaryList(areaSummary);
					//----------------------------------------------------------------------------------------------------------------------------
			
			ModelAndView mo = new ModelAndView();
			String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
			*//**if(approveLevel.equalsIgnoreCase("DEO")){
				mo = new ModelAndView("MMS_dashboard_DEO" ,"model",model);
			}else if(approveLevel.equalsIgnoreCase("ES")){
				mo.setViewName("MMS_dashboard_ES");

			}else if(approveLevel.equalsIgnoreCase("EE")){
				mo = new ModelAndView("MMS_dashboard_EE" ,"model",model);

			}else if(approveLevel.equalsIgnoreCase("CE")){
				mo.setViewName("MMS_dashboard_CE");

			}else if(approveLevel.equalsIgnoreCase("DGM")){
				mo.setViewName("MMS_dashboard_DGM");

			}else{
				
			}*//*
			//ModelAndView model = new ModelAndView();
			if(deptId.equals("600.41")){
				mo = new ModelAndView("MMS_dashboard_New" ,"model",model);
			}else{
				mo = new ModelAndView("MMS_dashboard_AE" ,"model",model);
			}
			
			return mo;

		}
*/	
	 
	 
	//edited anushka 2019-01-10 ------------------------------------------------------------------------------------------------
		@RequestMapping(value = "/dashboardOther", method = RequestMethod.GET)
		public ModelAndView dashboardOther(HttpServletRequest request,
				@ModelAttribute("pivModel") PivModel pivModel) {
			PivModel pivModelNew = new PivModel();
			Map<String, String> lineList = new LinkedHashMap<String, String>();

			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			String province = deptDao.getDD(deptId);
			Glcompm distDiv = glcompmDao.getDistDivision2(province);
			provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
			
			PivModel model = new PivModel();
			//List<Summary> summary = addLine.findDDSummary(distDiv.getCompId(), deptId);
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
			int depLoop = deptTm.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				Gldeptm ojb = (Gldeptm) deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
			}
			// edit anushka
			// 2018-12-28-----------------------------------------------------------------------------------------------------
			//List<Summary> areaSummary = addLine.findAreaSummary(deptId);
			// ----------------------------------------------------------------------------------------------------------------------------
			List<String> provinces = new ArrayList<String>();
			// edit anushka
			// 2018-12-28-----------------------------------------------------------------------------------------------------
			//model.setAreaSummaryList(summary);
			// ----------------------------------------------------------------------------------------------------------------------------

			Map<String,String> cycle = new LinkedHashMap<String,String>();
			
			ModelAndView mo = new ModelAndView();
			String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			model.setLineList(lineList);
			//model.setSummaryList(summary);
			String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			String status = null;

			String phmBranch = (String) request.getSession().getAttribute("deptId");
			deptId = deptId.trim();
			
			mo = new ModelAndView("MMS_dashboard_Other", "model", model);
			
			
			mo.addObject("province", distDiv.getCompId().trim());
			
			List<String> areaListInt = deptDao.getAreaByProvinceNew(distDiv.getCompId().trim());
			//List<ApprovalMm>  listPendingIntReq = approvalMm.getAllInterruptionReqForProvince(areaListInt, "95", "INTREQ");
			
			
			List<ApprovalMm>  listPendingIntReq = null;
			if(userLevel.equalsIgnoreCase("EEC")){
				listPendingIntReq = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","3");
				
			}else{
				listPendingIntReq = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","2");
			}
			
			
			Long countEstimate = pcsstDao.getApprovalListCount(approveLevel, userName);
			
			Long countStdEstimate = spstdEstDao.getApprovalListCount(userName, approveLevel);
			Long countReviseEstimate = pchmtDao.getApprovalListCount(userName, approveLevel);
			
			
			/*Long countReviseEstimate = pchmtDao.getApprovalListCount(userName, approveLevel);
			
			Long countPSEstimate = cbpmtDao.getApprovalList(userName);
			
			
			Long countIVEstimate = inTrDao.getApprovalList(userName);
			
			Long countRQEstimate = RqDao.getApprovalList(userName);
			*/
			//System.out.println("eee: "+countStdEstimate.intValue());
			
//Long countEstimate = new Long("0");
			
			//Long countStdEstimate = new Long("0");
			
			
			//Long countReviseEstimate = new Long("0");
			
			Long countPSEstimate = new Long("0");
			
			
			Long countIVEstimate = new Long("0");
			
			Long countRQEstimate = new Long("0");
			
			
			
			int countAllReq = 0;
			int countAllMnt = 0;
			int countEst = 0;
			int countStdEst = 0;
			int countRevEst = 0;
			
			int totalApproval = 0;
			int countPS=0;
			int countIV=0;
			int countRQ=0;
			
			int countAll = 0;
			
			if(listPendingIntReq != null ){
				countAllReq = listPendingIntReq.size();
				countAll = listPendingIntReq.size();
				mo.addObject("intReq", listPendingIntReq.size());
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);
				
			}
			
			if(countEstimate != null){
				countEst = countEstimate.intValue();
				countAll += countEst;
				totalApproval +=countEst;
				mo.addObject("countAll", countAll);
				mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				
				
				
				
			}
			
			if(countStdEstimate != null){
				countStdEst = countStdEstimate.intValue();
				countAll += countStdEst;
				totalApproval +=countStdEst;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countStdEstApprove", countStdEst);
				
				
			}
			
			if(countReviseEstimate != null){
				countRevEst = countReviseEstimate.intValue();
				countAll += countRevEst;
				totalApproval +=countRevEst;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countRevEstApprove", countRevEst);
				
				
			}
			
			
			if(countPSEstimate != null){
				countPS = countPSEstimate.intValue();
				countAll += countPS;
				totalApproval +=countPS;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countPSApprove", countPS);
				
				
			}

			if(countIVEstimate != null){
				countIV = countIVEstimate.intValue();
				countAll += countIV;
				totalApproval +=countIV;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countIVApprove", countIV);
				
				
			}
			if(countRQEstimate != null){
				countRQ = countRQEstimate.intValue();
				countAll += countRQ;
				totalApproval +=countRQ;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countRQApprove", countRQ);
				
				
			}



			return mo;

		}
		
		
		
		@RequestMapping(value = "/dashboardAgm", method = RequestMethod.GET)
		public ModelAndView dashboardAgm(HttpServletRequest request,
				@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println(" IN dashboard : ");
			PivModel pivModelNew = new PivModel();
			Map<String, String> lineList = new LinkedHashMap<String, String>();
			Map<String, String> divList = new LinkedHashMap<String, String>();
			
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			String province = deptDao.getDD(deptId);
			System.out.println("province : "+province);
			Glcompm distDiv = glcompmDao.getDistDivision2(province);
			provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
			divList.put(distDiv.getCompId(), distDiv.getCompNm());
			
			System.out.println("distDivnnnn : "+distDiv.getCompId());
			
			/*List<Glcompm>  divListStr = glcompmDao.getDisDivision();
			System.out.print("hiii");
			int divListCount = divListStr.size() - 1;
			for (int i = 0; i <= divListCount; i++) {
				System.out.println(i);
				Glcompm ojb = divListStr.get(i);
				divList.put(ojb.getCompId(), ojb.getCompNm());

			}

*/			
			
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
			// edit anushka
			// 2018-12-28-----------------------------------------------------------------------------------------------------
			List<Summary> areaSummary = addLine.findAreaSummary(deptId);
			// ----------------------------------------------------------------------------------------------------------------------------
			List<String> provinces = new ArrayList<String>();
			// edit anushka
			// 2018-12-28-----------------------------------------------------------------------------------------------------
			model.setAreaSummaryList(summary);
			// ----------------------------------------------------------------------------------------------------------------------------

			ModelAndView mo = new ModelAndView();
			String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			model.setLineList(lineList);
			model.setSummaryList(summary);
			model.setDivList(divList);
			String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			String status = null;

			String phmBranch = (String) request.getSession().getAttribute("deptId");
			deptId = deptId.trim();
			
			//model.setMode(distDiv.getCompId());
			mo = new ModelAndView("MMS_dashboard_AGMM", "model", model);
			
			
			mo.addObject("province", distDiv.getCompId().trim());
			
			List<String> areaListInt = deptDao.getAreaByProvinceNew(distDiv.getCompId().trim());
			//List<ApprovalMm>  listPendingIntReq = approvalMm.getAllInterruptionReqForProvince(areaListInt, "95", "INTREQ");
			
			
			List<ApprovalMm>  listPendingIntReq = null;
			if(userLevel.equalsIgnoreCase("EEC")){
				listPendingIntReq = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","3");
				
			}else{
				listPendingIntReq = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","2");
			}
			
			
			Long countEstimate = pcsstDao.getApprovalListCount(approveLevel, userName);
			
			/*Long countStdEstimate = spstdEstDao.getApprovalListCount(userName, approveLevel);
			
			
			Long countReviseEstimate = pchmtDao.getApprovalListCount(userName, approveLevel);
			
			Long countPSEstimate = cbpmtDao.getApprovalList(userName);
			
			
			Long countIVEstimate = inTrDao.getApprovalList(userName);
			
			Long countRQEstimate = RqDao.getApprovalList(userName);
			*/
			//System.out.println("eee: "+countStdEstimate.intValue());
			
//Long countEstimate = new Long("0");
			
			Long countStdEstimate = new Long("0");
			
			
			Long countReviseEstimate = new Long("0");
			
			Long countPSEstimate = new Long("0");
			
			
			Long countIVEstimate = new Long("0");
			
			Long countRQEstimate = new Long("0");
			
			
			
			int countAllReq = 0;
			int countAllMnt = 0;
			int countEst = 0;
			int countStdEst = 0;
			int countRevEst = 0;
			
			int totalApproval = 0;
			int countPS=0;
			int countIV=0;
			int countRQ=0;
			
			int countAll = 0;
			
			if(listPendingIntReq != null ){
				countAllReq = listPendingIntReq.size();
				countAll = listPendingIntReq.size();
				mo.addObject("intReq", listPendingIntReq.size());
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);
				
			}
			
			if(countEstimate != null){
				countEst = countEstimate.intValue();
				countAll += countEst;
				totalApproval +=countEst;
				mo.addObject("countAll", countAll);
				mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				
				
				
				
			}
			
			if(countStdEstimate != null){
				countStdEst = countStdEstimate.intValue();
				countAll += countStdEst;
				totalApproval +=countStdEst;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countStdEstApprove", countStdEst);
				
				
			}
			
			if(countReviseEstimate != null){
				countRevEst = countReviseEstimate.intValue();
				countAll += countRevEst;
				totalApproval +=countRevEst;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countRevEstApprove", countRevEst);
				
				
			}
			
			
			if(countPSEstimate != null){
				countPS = countPSEstimate.intValue();
				countAll += countPS;
				totalApproval +=countPS;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countPSApprove", countPS);
				
				
			}

			if(countIVEstimate != null){
				countIV = countIVEstimate.intValue();
				countAll += countIV;
				totalApproval +=countIV;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countIVApprove", countIV);
				
				
			}
			if(countRQEstimate != null){
				countRQ = countRQEstimate.intValue();
				countAll += countRQ;
				totalApproval +=countRQ;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countRQApprove", countRQ);
				
				
			}



			return mo;

		}
		
		
		
		@RequestMapping(value = "/dashboardAdmin", method = RequestMethod.GET)
		public ModelAndView dashboardAdmin(HttpServletRequest request,
				@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println(" IN dashboard : ");
			PivModel pivModelNew = new PivModel();
			Map<String, String> lineList = new LinkedHashMap<String, String>();
			Map<String, String> divList = new LinkedHashMap<String, String>();
			
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			String province = deptDao.getDD(deptId);
			System.out.println("province : "+province);
			Glcompm distDiv = glcompmDao.getDistDivision2(province);
			provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
			//divList.put(distDiv.getCompId(), distDiv.getCompNm());
			
			System.out.println("distDivnnnn : "+distDiv.getCompId());
			
			List<Glcompm>  divListStr = glcompmDao.getDisDivision();
			System.out.print("hiii");
			int divListCount = divListStr.size() - 1;
			for (int i = 0; i <= divListCount; i++) {
				System.out.println(i);
				Glcompm ojb = divListStr.get(i);
				divList.put(ojb.getCompId(), ojb.getCompNm());

			}

			
			
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
			// edit anushka
			// 2018-12-28-----------------------------------------------------------------------------------------------------
			List<Summary> areaSummary = addLine.findAreaSummary(deptId);
			// ----------------------------------------------------------------------------------------------------------------------------
			List<String> provinces = new ArrayList<String>();
			// edit anushka
			// 2018-12-28-----------------------------------------------------------------------------------------------------
			model.setAreaSummaryList(summary);
			// ----------------------------------------------------------------------------------------------------------------------------

			ModelAndView mo = new ModelAndView();
			String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			model.setLineList(lineList);
			model.setSummaryList(summary);
			model.setDivList(divList);
			String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			String status = null;

			String phmBranch = (String) request.getSession().getAttribute("deptId");
			deptId = deptId.trim();
			
			//model.setMode(distDiv.getCompId());
			mo = new ModelAndView("MMS_dashboard_Admin", "model", model);
			
			
			mo.addObject("province", distDiv.getCompId().trim());
			
			List<String> areaListInt = deptDao.getAreaByProvinceNew(distDiv.getCompId().trim());
			//List<ApprovalMm>  listPendingIntReq = approvalMm.getAllInterruptionReqForProvince(areaListInt, "95", "INTREQ");
			
			
			List<ApprovalMm>  listPendingIntReq = null;
			if(userLevel.equalsIgnoreCase("EEC")){
				listPendingIntReq = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","3");
				
			}else{
				listPendingIntReq = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","2");
			}
			
			
			Long countEstimate = pcsstDao.getApprovalListCount(approveLevel, userName);
			
			/*Long countStdEstimate = spstdEstDao.getApprovalListCount(userName, approveLevel);
			
			
			Long countReviseEstimate = pchmtDao.getApprovalListCount(userName, approveLevel);
			
			Long countPSEstimate = cbpmtDao.getApprovalList(userName);
			
			
			Long countIVEstimate = inTrDao.getApprovalList(userName);
			
			Long countRQEstimate = RqDao.getApprovalList(userName);
			*/
			//System.out.println("eee: "+countStdEstimate.intValue());
			
//Long countEstimate = new Long("0");
			
			Long countStdEstimate = new Long("0");
			
			
			Long countReviseEstimate = new Long("0");
			
			Long countPSEstimate = new Long("0");
			
			
			Long countIVEstimate = new Long("0");
			
			Long countRQEstimate = new Long("0");
			
			
			
			int countAllReq = 0;
			int countAllMnt = 0;
			int countEst = 0;
			int countStdEst = 0;
			int countRevEst = 0;
			
			int totalApproval = 0;
			int countPS=0;
			int countIV=0;
			int countRQ=0;
			
			int countAll = 0;
			
			if(listPendingIntReq != null ){
				countAllReq = listPendingIntReq.size();
				countAll = listPendingIntReq.size();
				mo.addObject("intReq", listPendingIntReq.size());
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);
				
			}
			
			if(countEstimate != null){
				countEst = countEstimate.intValue();
				countAll += countEst;
				totalApproval +=countEst;
				mo.addObject("countAll", countAll);
				mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				
				
				
				
			}
			
			if(countStdEstimate != null){
				countStdEst = countStdEstimate.intValue();
				countAll += countStdEst;
				totalApproval +=countStdEst;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countStdEstApprove", countStdEst);
				
				
			}
			
			if(countReviseEstimate != null){
				countRevEst = countReviseEstimate.intValue();
				countAll += countRevEst;
				totalApproval +=countRevEst;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countRevEstApprove", countRevEst);
				
				
			}
			
			
			if(countPSEstimate != null){
				countPS = countPSEstimate.intValue();
				countAll += countPS;
				totalApproval +=countPS;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countPSApprove", countPS);
				
				
			}

			if(countIVEstimate != null){
				countIV = countIVEstimate.intValue();
				countAll += countIV;
				totalApproval +=countIV;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countIVApprove", countIV);
				
				
			}
			if(countRQEstimate != null){
				countRQ = countRQEstimate.intValue();
				countAll += countRQ;
				totalApproval +=countRQ;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countRQApprove", countRQ);
				
				
			}



			return mo;

		}
		
		
		@RequestMapping(value = "/dashboardAll", method = RequestMethod.GET)
		public ModelAndView dashboardAll(HttpServletRequest request,
				@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println(" IN dashboard : ");
			PivModel pivModelNew = new PivModel();
			Map<String, String> lineList = new LinkedHashMap<String, String>();
			Map<String, String> divList = new LinkedHashMap<String, String>();
			
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			String province = deptDao.getDD(deptId);
			System.out.println("province : "+province);
			Glcompm distDiv = glcompmDao.getDistDivision2(province);
			provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
			//divList.put(distDiv.getCompId(), distDiv.getCompNm());
			
			System.out.println("distDivnnnn : "+distDiv.getCompId());
			
			List<Glcompm>  divListStr = glcompmDao.getDisDivision();
			System.out.print("hiii");
			int divListCount = divListStr.size() - 1;
			for (int i = 0; i <= divListCount; i++) {
				System.out.println(i);
				Glcompm ojb = divListStr.get(i);
				divList.put(ojb.getCompId(), ojb.getCompNm());

			}

			
			
			PivModel model = new PivModel();
			/*List<Summary> summary = addLine.findDDSummary(distDiv.getCompId(), deptId);
			System.out.println("distDivnnnnsize : "+summary.size());
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
			int depLoop = deptTm.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				System.out.println(i);
				Gldeptm ojb = (Gldeptm) deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
			}
			*/// edit anushka
			// 2018-12-28-----------------------------------------------------------------------------------------------------
			//List<Summary> areaSummary = addLine.findAreaSummary(deptId);
			// ----------------------------------------------------------------------------------------------------------------------------
			//List<String> provinces = new ArrayList<String>();
			// edit anushka
			// 2018-12-28-----------------------------------------------------------------------------------------------------
			//model.setAreaSummaryList(summary);
			// ----------------------------------------------------------------------------------------------------------------------------

			ModelAndView mo = new ModelAndView();
			/*String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			model.setLineList(lineList);
			model.setSummaryList(summary);*/
			model.setDivList(divList);
			/*String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			String status = null;

			String phmBranch = (String) request.getSession().getAttribute("deptId");
			deptId = deptId.trim();
*/			
			//model.setMode(distDiv.getCompId());
			mo = new ModelAndView("MMS_dashboard_PHM", "model", model);
			
			
			mo.addObject("province", distDiv.getCompId().trim());
			
			/*List<String> areaListInt = deptDao.getAreaByProvinceNew(distDiv.getCompId().trim());
			//List<ApprovalMm>  listPendingIntReq = approvalMm.getAllInterruptionReqForProvince(areaListInt, "95", "INTREQ");
			
			
			List<ApprovalMm>  listPendingIntReq = null;
			if(userLevel.equalsIgnoreCase("EEC")){
				listPendingIntReq = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","3");
				
			}else{
				listPendingIntReq = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","2");
			}
			
			
			Long countEstimate = pcsstDao.getApprovalListCount(approveLevel, userName);
			
			Long countStdEstimate = spstdEstDao.getApprovalListCount(userName, approveLevel);
			
			
			Long countReviseEstimate = pchmtDao.getApprovalListCount(userName, approveLevel);
			
			Long countPSEstimate = cbpmtDao.getApprovalList(userName);
			
			
			Long countIVEstimate = inTrDao.getApprovalList(userName);
			
			Long countRQEstimate = RqDao.getApprovalList(userName);
			
			//System.out.println("eee: "+countStdEstimate.intValue());
			
//Long countEstimate = new Long("0");
			
			Long countStdEstimate = new Long("0");
			
			
			Long countReviseEstimate = new Long("0");
			
			Long countPSEstimate = new Long("0");
			
			
			Long countIVEstimate = new Long("0");
			
			Long countRQEstimate = new Long("0");
			
			
			
			int countAllReq = 0;
			int countAllMnt = 0;
			int countEst = 0;
			int countStdEst = 0;
			int countRevEst = 0;
			
			int totalApproval = 0;
			int countPS=0;
			int countIV=0;
			int countRQ=0;
			
			int countAll = 0;
			
			if(listPendingIntReq != null ){
				countAllReq = listPendingIntReq.size();
				countAll = listPendingIntReq.size();
				mo.addObject("intReq", listPendingIntReq.size());
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);
				
			}
			
			if(countEstimate != null){
				countEst = countEstimate.intValue();
				countAll += countEst;
				totalApproval +=countEst;
				mo.addObject("countAll", countAll);
				mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				
				
				
				
			}
			
			if(countStdEstimate != null){
				countStdEst = countStdEstimate.intValue();
				countAll += countStdEst;
				totalApproval +=countStdEst;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countStdEstApprove", countStdEst);
				
				
			}
			
			if(countReviseEstimate != null){
				countRevEst = countReviseEstimate.intValue();
				countAll += countRevEst;
				totalApproval +=countRevEst;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countRevEstApprove", countRevEst);
				
				
			}
			
			
			if(countPSEstimate != null){
				countPS = countPSEstimate.intValue();
				countAll += countPS;
				totalApproval +=countPS;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countPSApprove", countPS);
				
				
			}

			if(countIVEstimate != null){
				countIV = countIVEstimate.intValue();
				countAll += countIV;
				totalApproval +=countIV;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countIVApprove", countIV);
				
				
			}
			if(countRQEstimate != null){
				countRQ = countRQEstimate.intValue();
				countAll += countRQ;
				totalApproval +=countRQ;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countRQApprove", countRQ);
				
				
			}
*/


			return mo;

		}
		
		
		
		@RequestMapping(value = "/dashboardCom", method = RequestMethod.GET)
		public ModelAndView dashboardCom(HttpServletRequest request,
				@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println(" IN dashboard : ");
			PivModel pivModelNew = new PivModel();
			Map<String, String> lineList = new LinkedHashMap<String, String>();
			Map<String, String> divList = new LinkedHashMap<String, String>();
			
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			String province = deptDao.getDD(deptId);
			System.out.println("province : "+province);
			Glcompm distDiv = glcompmDao.getDistDivision2(province);
			provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
			//divList.put(distDiv.getCompId(), distDiv.getCompNm());
			
			System.out.println("distDivnnnn : "+distDiv.getCompId());
			
			List<Glcompm>  divListStr = glcompmDao.getDisDivision();
			System.out.print("hiii");
			int divListCount = divListStr.size() - 1;
			for (int i = 0; i <= divListCount; i++) {
				System.out.println(i);
				Glcompm ojb = divListStr.get(i);
				divList.put(ojb.getCompId(), ojb.getCompNm());

			}

			
			
			PivModel model = new PivModel();
			/*List<Summary> summary = addLine.findDDSummary(distDiv.getCompId(), deptId);
			System.out.println("distDivnnnnsize : "+summary.size());
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
			int depLoop = deptTm.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				System.out.println(i);
				Gldeptm ojb = (Gldeptm) deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
			}
			*/// edit anushka
			// 2018-12-28-----------------------------------------------------------------------------------------------------
			//List<Summary> areaSummary = addLine.findAreaSummary(deptId);
			// ----------------------------------------------------------------------------------------------------------------------------
			//List<String> provinces = new ArrayList<String>();
			// edit anushka
			// 2018-12-28-----------------------------------------------------------------------------------------------------
			//model.setAreaSummaryList(summary);
			// ----------------------------------------------------------------------------------------------------------------------------

			ModelAndView mo = new ModelAndView();
			/*String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			model.setLineList(lineList);
			model.setSummaryList(summary);*/
			model.setDivList(divList);
			/*String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			String status = null;

			String phmBranch = (String) request.getSession().getAttribute("deptId");
			deptId = deptId.trim();
*/			
			//model.setMode(distDiv.getCompId());
			mo = new ModelAndView("MMS_dashboard_All_Div", "model", model);
			
			
			mo.addObject("province", distDiv.getCompId().trim());
			
			/*List<String> areaListInt = deptDao.getAreaByProvinceNew(distDiv.getCompId().trim());
			//List<ApprovalMm>  listPendingIntReq = approvalMm.getAllInterruptionReqForProvince(areaListInt, "95", "INTREQ");
			
			
			List<ApprovalMm>  listPendingIntReq = null;
			if(userLevel.equalsIgnoreCase("EEC")){
				listPendingIntReq = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","3");
				
			}else{
				listPendingIntReq = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","2");
			}
			
			
			Long countEstimate = pcsstDao.getApprovalListCount(approveLevel, userName);
			
			Long countStdEstimate = spstdEstDao.getApprovalListCount(userName, approveLevel);
			
			
			Long countReviseEstimate = pchmtDao.getApprovalListCount(userName, approveLevel);
			
			Long countPSEstimate = cbpmtDao.getApprovalList(userName);
			
			
			Long countIVEstimate = inTrDao.getApprovalList(userName);
			
			Long countRQEstimate = RqDao.getApprovalList(userName);
			
			//System.out.println("eee: "+countStdEstimate.intValue());
			
//Long countEstimate = new Long("0");
			
			Long countStdEstimate = new Long("0");
			
			
			Long countReviseEstimate = new Long("0");
			
			Long countPSEstimate = new Long("0");
			
			
			Long countIVEstimate = new Long("0");
			
			Long countRQEstimate = new Long("0");
			
			
			
			int countAllReq = 0;
			int countAllMnt = 0;
			int countEst = 0;
			int countStdEst = 0;
			int countRevEst = 0;
			
			int totalApproval = 0;
			int countPS=0;
			int countIV=0;
			int countRQ=0;
			
			int countAll = 0;
			
			if(listPendingIntReq != null ){
				countAllReq = listPendingIntReq.size();
				countAll = listPendingIntReq.size();
				mo.addObject("intReq", listPendingIntReq.size());
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);
				
			}
			
			if(countEstimate != null){
				countEst = countEstimate.intValue();
				countAll += countEst;
				totalApproval +=countEst;
				mo.addObject("countAll", countAll);
				mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				
				
				
				
			}
			
			if(countStdEstimate != null){
				countStdEst = countStdEstimate.intValue();
				countAll += countStdEst;
				totalApproval +=countStdEst;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countStdEstApprove", countStdEst);
				
				
			}
			
			if(countReviseEstimate != null){
				countRevEst = countReviseEstimate.intValue();
				countAll += countRevEst;
				totalApproval +=countRevEst;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countRevEstApprove", countRevEst);
				
				
			}
			
			
			if(countPSEstimate != null){
				countPS = countPSEstimate.intValue();
				countAll += countPS;
				totalApproval +=countPS;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countPSApprove", countPS);
				
				
			}

			if(countIVEstimate != null){
				countIV = countIVEstimate.intValue();
				countAll += countIV;
				totalApproval +=countIV;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countIVApprove", countIV);
				
				
			}
			if(countRQEstimate != null){
				countRQ = countRQEstimate.intValue();
				countAll += countRQ;
				totalApproval +=countRQ;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countRQApprove", countRQ);
				
				
			}
*/


			return mo;

		}




		
		@RequestMapping(value = "/forwardRequestInt", method = RequestMethod.GET)
		public ModelAndView forwardRequestInt(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println("forwardRequestInt : ");
			PivModel pivModelNew = new PivModel();
			ModelAndView mo = new ModelAndView();
			mo = new ModelAndView("ActionOnIntRequest", "model", pivModelNew);
			return mo;

		}

		
		
		@RequestMapping(value = "/estimateApproval", method = RequestMethod.GET)
		public ModelAndView estimateApproval(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println("estimateApproval : ");
			PivModel pivModelNew = new PivModel();
			ModelAndView mo = new ModelAndView();
			mo = new ModelAndView("estimateApproval", "model", pivModelNew);
			return mo;

		}
		
		@RequestMapping(value = "/estimateApprovalAE", method = RequestMethod.GET)
		public ModelAndView estimateApprovalAE(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println("estimateApproval : ");
			PivModel pivModelNew = new PivModel();
			ModelAndView mo = new ModelAndView();
			mo = new ModelAndView("estimateApprovalAE", "model", pivModelNew);
			return mo;

		}

		
		@RequestMapping(value = "/estimateStatus", method = RequestMethod.GET)
		public ModelAndView estimateStatus(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println("estimateApproval : ");
			PivModel pivModelNew = new PivModel();
			ModelAndView mo = new ModelAndView();
			mo = new ModelAndView("estimateStatus", "model", pivModelNew);
			return mo;

		}

		
		@RequestMapping(value = "/RequestStatus", method = RequestMethod.GET)
		public ModelAndView RequestStatus(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println("RequestTypeStatus : ");
			PivModel pivModelNew = new PivModel();
			ModelAndView mo = new ModelAndView();
			mo = new ModelAndView("RequestTypeStatus", "model", pivModelNew);
			return mo;

		}
		
		@RequestMapping(value = "/RequestStatusOther", method = RequestMethod.GET)
		public ModelAndView RequestStatusOther(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println("RequestTypeStatus : ");
			PivModel pivModelNew = new PivModel();
			ModelAndView mo = new ModelAndView();
			mo = new ModelAndView("RequestTypeStatusOther", "model", pivModelNew);
			return mo;

		}
		
		@RequestMapping(value = "/RequestStatusMeterES", method = RequestMethod.GET)
		public ModelAndView RequestStatusMeterES(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println("RequestTypeStatus : ");
			PivModel pivModelNew = new PivModel();
			ModelAndView mo = new ModelAndView();
			mo = new ModelAndView("meterStatusES", "model", pivModelNew);
			return mo;

		}
		
		@RequestMapping(value = "/RequestStatusMeterAll", method = RequestMethod.GET)
		public ModelAndView RequestStatusMeterAll(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println("RequestTypeStatus : ");
			PivModel pivModelNew = new PivModel();
			ModelAndView mo = new ModelAndView();
			mo = new ModelAndView("meterStatusESAll", "model", pivModelNew);
			return mo;

		}



		
		@RequestMapping(value = "/IntteruptionApproval", method = RequestMethod.GET)
		public ModelAndView IntteruptionApproval(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println("RequestTypeStatus : ");
			PivModel pivModelNew = new PivModel();
			ModelAndView mo = new ModelAndView();
			mo = new ModelAndView("IntApproval", "model", pivModelNew);
			return mo;

		}

		
		@RequestMapping(value = "/RequestCalender", method = RequestMethod.GET)
		public ModelAndView RequestCalender(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println("RequestTypeStatus : ");
			PivModel pivModelNew = new PivModel();
			ModelAndView mo = new ModelAndView();
			mo = new ModelAndView("RequestCalender", "model", pivModelNew);
			return mo;

		}


		
		@RequestMapping(value = "/estimatePSApproval", method = RequestMethod.GET)
		public ModelAndView estimatePSApproval(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println("estimatePSApproval : ");
			PivModel pivModelNew = new PivModel();
			ModelAndView mo = new ModelAndView();
			mo = new ModelAndView("estimatePSApproval", "model", pivModelNew);
			return mo;

		}
		
		@RequestMapping(value = "/estimateIVApproval", method = RequestMethod.GET)
		public ModelAndView estimateIVApproval(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println("estimatePSApproval : ");
			PivModel pivModelNew = new PivModel();
			ModelAndView mo = new ModelAndView();
			mo = new ModelAndView("estimateIVApproval", "model", pivModelNew);
			return mo;

		}
		
		@RequestMapping(value = "/estimateVJApproval", method = RequestMethod.GET)
		public ModelAndView estimateVJApproval(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println("estimatePSApproval : ");
			PivModel pivModelNew = new PivModel();
			ModelAndView mo = new ModelAndView();
			mo = new ModelAndView("estimateVJOUApproval", "model", pivModelNew);
			return mo;

		}

		
		@RequestMapping(value = "/estimateRQApproval", method = RequestMethod.GET)
		public ModelAndView estimateRQApproval(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println("estimatePSApproval : ");
			PivModel pivModelNew = new PivModel();
			ModelAndView mo = new ModelAndView();
			mo = new ModelAndView("estimateRQApproval", "model", pivModelNew);
			return mo;

		}



		
		@RequestMapping(value = "/estimateStdApproval", method = RequestMethod.GET)
		public ModelAndView estimateStdApproval(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println("estimateApproval : ");
			PivModel pivModelNew = new PivModel();
			ModelAndView mo = new ModelAndView();
			mo = new ModelAndView("estimateStdApproval", "model", pivModelNew);
			return mo;

		}
		
		@RequestMapping(value = "/estimateSPSReport", method = RequestMethod.GET)
		public ModelAndView estimateSPSReport(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println("estimateSPSReport : ");
			PivModel pivModelNew = new PivModel();
			ModelAndView mo = new ModelAndView();
			mo = new ModelAndView("estimateSPSReport", "model", pivModelNew);
			return mo;

		}



		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		@RequestMapping(value = "/dashboardSUB", method = RequestMethod.GET)
		public ModelAndView dashboardSUB(HttpServletRequest request,
				@ModelAttribute("pivModel") PivModel pivModel) {
			PivModel pivModelNew = new PivModel();
			Map<String, String> lineList = new LinkedHashMap<String, String>();
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			String province = deptDao.getDD(deptId);
			int countAll = 0;
			
			String distDiv = glcompmDao.getDistDivision(province);
			PivModel model = new PivModel();
			List<Glcompm> line = glcompmDao.getProvinces(distDiv);
			//List<Summary> summary = addLine.findDDSummaryOther(distDiv);

			// edit anushka
			// 2018-12-28-----------------------------------------------------------------------------------------------------
			//List<Summary> areaSummary = addLine.findAreaSummary(deptId);
			// ----------------------------------------------------------------------------------------------------------------------------
			List<String> provinces = new ArrayList<String>();
			int loop = line.size() - 1;
			for (int i = 0; i <= loop; i++) {
				//System.out.println(i);
				Glcompm ojb = line.get(i);

				//System.out.println(ojb.getCompNm());
				provinces.add(ojb.getCompNm());
				provinceList.put(ojb.getCompId(), ojb.getCompNm());

			}
			// edit anushka
			// 2018-12-28-----------------------------------------------------------------------------------------------------
			//model.setAreaSummaryList(areaSummary);
			// ----------------------------------------------------------------------------------------------------------------------------

			ModelAndView mo = new ModelAndView();
			String approveLevel = request.getSession()
					.getAttribute("loggedUserRole").toString();
			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			model.setLineList(lineList);
			//model.setSummaryList(summary);
			String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			String status = null;

			String phmBranch = (String) request.getSession().getAttribute("deptId");
			deptId = deptId.trim();
			
			if (deptId.equals("600.41") || deptId.equals("780.00")|| deptId.equals("596.00")) {
				mo = new ModelAndView("MMS_dashboard_New", "model", model);
			} else if (deptId.equals("600.42") || deptId.equals("597.00")){
				mo = new ModelAndView("MMS_dashboard_SUB", "model", model);
								
				
			}
			else {
			
				areaList.put(deptId, gldeptDao.getName(deptId));
				mo = new ModelAndView("MMS_dashboard_AE", "model", model);
			}
			
			
			//find all supports according to status
			if (userLevel.equals("DEO")) {
				status = Util.IN_BULK;
			} else if (userLevel.equals("ES")) {
				status = Util.VALIDATION_ES;
			} else if (userLevel.equals("EE")) {
				status = Util.APPROVAL_EE;
			}
			else if (userLevel.equals("CE")) {
					status = Util.APPROVAL_CE;
				}else if (userLevel.equals("DGM")) {
					status = Util.APPROVAL_DGM;
				}
			List<ApprovalMm>  listIns = approvalMm.getPendingReqNew("INSREQ", "6",deptId);
			List<ApprovalMm>  listMnt = approvalMm.getPendingReqNew("MNTREQ", "6",deptId);
			List<ApprovalMm>  listWay = approvalMm.getPendingReqNew("WAYREQ", "6",deptId);
			List<ApprovalMm>  listInt = approvalMm.getPendingReqNew("INTREQ", "6",deptId);
			
if(listIns !=null){
				
				mo.addObject("InsReq", listIns.size());
				
			}

if(listMnt !=null){
	
	mo.addObject("MntReq", listMnt.size());
	
}

if(listWay !=null){
	
	mo.addObject("WayReq", listMnt.size());
	
}

if(listInt !=null){
	
	mo.addObject("IntReq", listInt.size());
	
}

			
			
			
			
			int countAllReq = 0;
			if(listIns != null ){
				countAllReq = listIns.size();
				countAll = countAllReq;
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);

				
			}
			
			if(listMnt != null ){
				countAllReq = countAllReq +listMnt.size();
				countAll = countAll + countAllReq;
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);

				
			}
			
			
			if(listWay != null ){
				countAllReq = countAllReq +listWay.size();
				countAll = countAll + countAllReq;
				
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);

				
			}
			if(listInt != null ){
				countAllReq = countAllReq +listInt.size();
				countAll = countAll + countAllReq;
				
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);

				
			}
			
			
			List<MmsAddgantry> gantryListEdit = addGantry.findGantryByStatus(status, phmBranch);
			List<MmsAddfeeder> feederListEdit = addFeeder.findFeederByStatus(status, phmBranch);
			List<MmsAddswitch> switchListEdit = addSwitch.findSwitchByStatus(status, phmBranch);
			if(gantryListEdit != null){
				countAll = countAll + gantryListEdit.size();
				mo.addObject("countGantry",gantryListEdit.size());
				mo.addObject("countAll", countAll);
				//System.out.println("gantryListEdit " + gantryListEdit.size());
				//System.out.println("countAll " + countAll);
				
				
			}
			if(feederListEdit != null){
				countAll = countAll + feederListEdit.size();
				
				mo.addObject("countFeeder",feederListEdit.size());
				mo.addObject("countAll", countAll);
				System.out.println("countAll " + countAll);
				
			}
			if(switchListEdit != null){
				countAll = countAll + switchListEdit.size();
				
				mo.addObject("countSwitch",switchListEdit.size());
				mo.addObject("countAll", countAll);
				System.out.println("countAll " + countAll);
				
			}

			return mo;

		}

		
		
		
		
		
		
		
		@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
		public ModelAndView dashboard(HttpServletRequest request,
				@ModelAttribute("pivModel") PivModel pivModel) {
			PivModel pivModelNew = new PivModel();
			Map<String, String> lineList = new LinkedHashMap<String, String>();

			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			String province = deptDao.getDD(deptId);
			int countAll = 0;
			
			String distDiv = glcompmDao.getDistDivision(province);
			PivModel model = new PivModel();
			List<Glcompm> line = glcompmDao.getProvinces(distDiv);
			//List<Summary> summary = addLine.findDDSummary(distDiv, deptId);

			// edit anushka
			// 2018-12-28-----------------------------------------------------------------------------------------------------
			//List<Summary> areaSummary = addLine.findAreaSummary(deptId);
			// ----------------------------------------------------------------------------------------------------------------------------
			List<String> provinces = new ArrayList<String>();
			int loop = line.size() - 1;
			for (int i = 0; i <= loop; i++) {
				//System.out.println(i);
				Glcompm ojb = line.get(i);

				//System.out.println(ojb.getCompNm());
				provinces.add(ojb.getCompNm());
				provinceList.put(ojb.getCompId(), ojb.getCompNm());

			}
			model.setGlcompm(line);
			
			
			// edit anushka
			// 2018-12-28-----------------------------------------------------------------------------------------------------
			//model.setAreaSummaryList(areaSummary);
			// ----------------------------------------------------------------------------------------------------------------------------

			ModelAndView mo = new ModelAndView();
			String approveLevel = request.getSession()
					.getAttribute("loggedUserRole").toString();
			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			model.setLineList(lineList);
			//model.setSummaryList(summary);
			String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			String status = null;

			String phmBranch = (String) request.getSession().getAttribute("deptId");
			deptId = deptId.trim();
			
			
			//System.out.println("CE CE ");
			if (deptId.equals("600.41") || deptId.equals("780.00")|| deptId.equals("596.00")|| deptId.equals("972.30")) {
				//System.out.println("CE CE 10000");
				
				
				//List<KeyValue> pieDataList = pieChartDao.getPieChartData();
				//ModelMap modelMap = new ModelMap();
				
				mo = new ModelAndView("MMS_dashboard_New", "model", model);
				//modelMap.addAttribute("pieDataList", pieDataList);
				
			} else if (deptId.equals("600.42") || deptId.equals("597.00")|| deptId.equals("972.20")){
				mo = new ModelAndView("MMS_dashboard_SUB", "model", model);
				List<MmsAddgantry> gantryListEdit = addGantry.findGantryByStatus(status, phmBranch);
				List<MmsAddfeeder> feederListEdit = addFeeder.findFeederByStatus(status, phmBranch);
				List<MmsAddswitch> switchListEdit = addSwitch.findSwitchByStatus(status, phmBranch);
				if(gantryListEdit != null){
					countAll = countAll + gantryListEdit.size();
					mo.addObject("countGantry",gantryListEdit.size());
					mo.addObject("countAll", countAll);
					//System.out.println("gantryListEdit " + gantryListEdit.size());
					
					
				}
				if(feederListEdit != null){
					countAll = countAll + feederListEdit.size();
					
					mo.addObject("countFeeder",feederListEdit.size());
					mo.addObject("countAll", countAll);
					
				}
				if(switchListEdit != null){
					countAll = countAll + switchListEdit.size();
					
					mo.addObject("countSwitch",switchListEdit.size());
					mo.addObject("countAll", countAll);
					
				}

				
				
			}
			else {
			
				//System.out.println("CE CE 2");
				
				areaList.put(deptId, gldeptDao.getName(deptId));
				mo = new ModelAndView("MMS_dashboard_AE", "model", model);
			}
			
			
			//find all supports according to status
			if (userLevel.equals("DEO")) {
				status = Util.IN_BULK;
			} else if (userLevel.equals("ES")) {
				status = Util.VALIDATION_ES;
			} else if (userLevel.equals("EE")) {
				status = Util.APPROVAL_EE;
			}
			else if (userLevel.equals("CE")) {
					status = Util.APPROVAL_CE;
				}else if (userLevel.equals("DGM")) {
					status = Util.APPROVAL_DGM;
				}
			
			List<MmsAddsupport> Support =null;
			List<MmsAddline> lineListEdit =null;
			List<MmsTxntowermaintenance> TowerMaintance = null;
			//System.out.println("CE CE 2");
		//	List<MmsAddsupport> Support = addSupport.findByStatus(status,phmBranch);
			//System.out.println("CE CE 4");
		//	List<MmsAddline> lineListEdit = lineDao.findLineByStatus(status, phmBranch);
			//System.out.println("CE CE 5");
		//	List<MmsTxntowermaintenance> TowerMaintance = towerTxtMaintenance.findAllByStatus(status,phmBranch);
			//System.out.println("CE CE 6");
			//List<Approval>  listApprovalUnread = approval.getNotReadEmail(userName, deptId);
			//System.out.println("listApprovalUnread : "+ listApprovalUnread);
			List<Approval>  listApprovalUnread = null;
			//List<Approval>  listIns = null;
			//List<Approval>  listMnt = null;
			
			List<ApprovalMm>  listIns = null;
			List<ApprovalMm>  listMnt = null;
			List<ApprovalMm>  listWay = null;
			List<ApprovalMm>  listInt = null;
			//System.out.println("userLevel.equalsIgnoreCase : "+userLevel.equalsIgnoreCase("EE"));
			if(userLevel.equalsIgnoreCase("EE")){
			listIns = approvalMm.getPendingReqByEE("INSREQ", "6",deptId,userName);
			listMnt = approvalMm.getPendingReqByEE("MNTREQ", "6",deptId,userName);
			//listWay = approvalMm.getPendingReq("WAYREQ", "6",deptId.userName);
			listInt = approvalMm.getPendingReqByEE("INTREQ", "6",deptId,userName);
			}
			
			if(userLevel.equalsIgnoreCase("ES")){
				listIns = approvalMm.getPendingReqByESNew("INSREQ", "99",userName);
				listMnt = approvalMm.getPendingReqByESNew("MNTREQ", "99",userName);
				//listWay = approvalMm.getPendingReq("WAYREQ", "99",deptId);
				//listInt = approvalMm.getPendingReqByEE("INTREQ", "6",deptId,userName);
				}
				
			
			//System.out.println("listIns : "+ listIns);
			//System.out.println("listMnt : "+ listMnt);
			
if(listIns !=null){
				
				mo.addObject("InsReq", listIns.size());
				
			}

if(listMnt !=null){
	
	mo.addObject("MntReq", listMnt.size());
	
}

if(listWay !=null){
	
	mo.addObject("WayReq", listMnt.size());
	
}

if(listInt !=null){
	
	mo.addObject("IntReq", listInt.size());
	
}

			
			
			
			if(listApprovalUnread !=null){
				
				mo.addObject("unReadEmail", listApprovalUnread.size());
				
			}
			
			/*if(listIns != null && listMnt != null && listApprovalUnread != null ){
				int countAllReq = listIns.size() + listMnt.size() + listApprovalUnread.size();
				
				mo.addObject("countAllReq", countAllReq);
				
				
			}*/
			int countAllReq = 0;
			if(listIns != null ){
				countAllReq = listIns.size();
				countAll = countAllReq;
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);

				
			}
			
			if(listMnt != null ){
				countAllReq = countAllReq +listMnt.size();
				countAll = countAll + countAllReq;
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);

				
			}
			
			
			if(listWay != null ){
				countAllReq = countAllReq +listWay.size();
				countAll = countAll + countAllReq;
				
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);

				
			}
			if(listInt != null ){
				countAllReq = countAllReq +listInt.size();
				countAll = countAll + countAllReq;
				
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);

				
			}

			
			
			if(Support != null && lineListEdit != null && TowerMaintance != null){
				countAll = Support.size() + lineListEdit.size() + TowerMaintance.size();
				
				
				mo.addObject("countSupport", Support.size());
				mo.addObject("countLine", lineListEdit.size());
				mo.addObject("countMnt", TowerMaintance.size());
				mo.addObject("countAll", countAll);
				//mo.addObject("countAppoved",countAppoved);
				
			}
			
            Long countEstimate = pcsstDao.getApprovalListCount(approveLevel, userName);
            Long countReviseEstimate = pchmtDao.getApprovalListCount(userName, approveLevel);
			
          // Long countEstimate = new Long("0");
           //Long countReviseEstimate = null;
            Long countStdEstimate =new Long("0");
			/*if(!deptId.equalsIgnoreCase("600.41")){
			    countStdEstimate = spstdEstDao.getApprovalListCount(userName, approveLevel);
			}
*/
            int countEst = 0;
			int countStdEst = 0;
			int countRevEst = 0;
			int totalApproval = 0;

            if(countEstimate != null){
				countEst = countEstimate.intValue();
				countAll += countEst;
				mo.addObject("countAll", countAll);
				mo.addObject("countEstApprove", countEst);
				
				
				
				
			}
            
            if(countReviseEstimate != null){
				countRevEst = countReviseEstimate.intValue();
				countAll += countRevEst;
				totalApproval +=countRevEst;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countRevEstApprove", countRevEst);
				
				
			}
			
			
			if(countStdEstimate != null){
				countStdEst = countStdEstimate.intValue();
				countAll += countStdEst;
				mo.addObject("countAll", countAll);
				mo.addObject("countStdEstApprove", countStdEst);
				
				
			}

			
			
			
			
			
						//System.out.println("CE CE 3");
			
			
			
			
			

			return mo;

		}
		
		
		@RequestMapping(value = "/dashboardSPS", method = RequestMethod.GET)
		public ModelAndView dashboardSPS(HttpServletRequest request,
				@ModelAttribute("pivModel") PivModel pivModel) {
			PivModel pivModelNew = new PivModel();
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
						int countAll = 0;
				//	List<Summary> areaSummary = addLine.findAreaSummary(deptId);
						String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
ModelAndView mo = new ModelAndView();
PivModel model = new PivModel();

			String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			String status = null;

			String phmBranch = (String) request.getSession().getAttribute("deptId");
			deptId = deptId.trim();
			mo = new ModelAndView("MMS_dashboard_SPS", "model", model);
			
			//Long countEstimateES = pcsstDao.getApprovalListCount(approveLevel, userName);
            
						
            Long countEstimate = pcsstDao.getApprovalListCount(approveLevel, userName);
            Long countReviseEstimate = pchmtDao.getApprovalListCount(userName, approveLevel);
			
           // Long countEstimate = new Long("0");
            
            Long countStdEstimate =new Long("0");
			/*if(!deptId.equalsIgnoreCase("600.41")){
			    countStdEstimate = spstdEstDao.getApprovalListCount(userName, approveLevel);
			}
*/
            int countEst = 0;
			int countStdEst = 0;
			int countRevEst = 0;
			int totalApproval = 0;

            if(countEstimate != null){
				countEst = countEstimate.intValue();
				countAll += countEst;
				mo.addObject("countAll", countAll);
				mo.addObject("countEstApprove", countEst);
				
				
				
				
			}
            
            if(countReviseEstimate != null){
				countRevEst = countReviseEstimate.intValue();
				countAll += countRevEst;
				totalApproval +=countRevEst;
				mo.addObject("countAll", countAll);
				//mo.addObject("countEstApprove", countEst);
				mo.addObject("totalApproval", totalApproval);
				mo.addObject("countRevEstApprove", countRevEst);
				
				
			}
			
			
			if(countStdEstimate != null){
				countStdEst = countStdEstimate.intValue();
				countAll += countStdEst;
				mo.addObject("countAll", countAll);
				mo.addObject("countStdEstApprove", countStdEst);
				
				
			}
			
			return mo;

		}


		
		
		
		
		
		
		@RequestMapping(value = "/displayAllUnReadMsg")
		public ModelAndView displayAllUnReadMsg(HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			PivModel model = new PivModel();
			
			List<Approval>  listApprovalUnread =null;
			//if(mode.equalsIgnoreCase("WLS")){
				listApprovalUnread = approval.getNotReadEmail(userName, deptId);

			/*}else if(mode.equalsIgnoreCase("ISS")){
				listApprovalUnread = approval.getPendingReq("", "6");

			}else if(mode.equalsIgnoreCase("MRS")){
				listApprovalUnread = approval.getPendingReq("", "7");

			}
*/
			
			
			ModelAndView mo = new ModelAndView();
			model.setUnReadEmailList(listApprovalUnread);
			
			//if(mode.equalsIgnoreCase("WLS")){
				
			mo = new ModelAndView("displayAllUnreadEmail", "model", model);
			/*}else{
				mo = new ModelAndView("displayAllInMntReqAE", "model", model);
				
				if(mode.equalsIgnoreCase("ISS")){
					mo.addObject("submitType","Inspection");
				}else{
					mo.addObject("submitType","Maintenance");
				}
			
				
			}
			*/return mo;
		}
		
		
		@RequestMapping(value = "/displayAllINSReq")
		public ModelAndView displayAllINSReq(@RequestParam("mode") String mode,HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			PivModel model = new PivModel();
			Map<String, String> saList = new LinkedHashMap<String, String>();

			List<ApprovalMm>  listApprovalUnread =null;
			if(mode.equalsIgnoreCase("INS")){
				listApprovalUnread = approvalMm.getPendingReqNew("INSREQ", "6",deptId);
			}else if(mode.equalsIgnoreCase("INT")){
				listApprovalUnread = approvalMm.getPendingReqByEE("INTREQ", "6",deptId,userName);
				
			}else if(mode.equalsIgnoreCase("WAY")){
				listApprovalUnread = approvalMm.getPendingReqNew("WAYREQ", "6",deptId);
				
			}else{
				listApprovalUnread = approvalMm.getPendingReqNew("MNTREQ", "6",deptId);
				
			}
            System.out.println(listApprovalUnread.size());
            List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
			int loopSa = saUserList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
				//System.out.println(i);
				Sauserm ojb = saUserList.get(i);
				//System.out.println(ojb.getUserId());
				saList.put(ojb.getUserId(), ojb.getUserNm());

			}
	
			
			ModelAndView mo = new ModelAndView();
			model.setUnReadInspectionReq(listApprovalUnread);
			model.setSaList(saList);

				
			mo = new ModelAndView("displayInsMntRequest", "model", model);
			if(mode.equalsIgnoreCase("INS")){
			mo.addObject("submitType","Inspection");
			
			}else if(mode.equalsIgnoreCase("INT")){
				mo.addObject("submitType","Interruption");
				
			}else if(mode.equalsIgnoreCase("WAY")){
				mo.addObject("submitType","Way Leave");
				
			}else{
				mo.addObject("submitType","Maintenance");
					
			}
			return mo;
		}
		
		
		@RequestMapping(value = "/ActionOnInIntReq")
		public @ResponseBody List<ApprovalMm>  ActionOnInIntReq(@RequestParam("mode") String mode,HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			//ApprovalModel model = new ApprovalModel();
			Map<String, String> saList = new LinkedHashMap<String, String>();

			List<ApprovalMm>  listApprovalUnread =null;
			if(mode.equalsIgnoreCase("INS")){
				listApprovalUnread = approvalMm.getPendingReqNew("INSREQ", "6",deptId);
			}else if(mode.equalsIgnoreCase("INT")){
				listApprovalUnread = approvalMm.getPendingReqByEE("INTREQ", "6",deptId,userName);
				
			}else if(mode.equalsIgnoreCase("WAY")){
				listApprovalUnread = approvalMm.getPendingReqNew("WAYREQ", "6",deptId);
				
			}else{
				listApprovalUnread = approvalMm.getPendingReqNew("MNTREQ", "6",deptId);
				
			}
			//model.setApprovalList(listApprovalUnread);
			
			return listApprovalUnread;
            /*System.out.println(listApprovalUnread.size());
            List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
			int loopSa = saUserList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
				//System.out.println(i);
				Sauserm ojb = saUserList.get(i);
				//System.out.println(ojb.getUserId());
				saList.put(ojb.getUserId(), ojb.getUserNm());

			}
	
			
			ModelAndView mo = new ModelAndView();
			model.setUnReadInspectionReq(listApprovalUnread);
			model.setSaList(saList);

				
			mo = new ModelAndView("displayInsMntRequest", "model", model);
			if(mode.equalsIgnoreCase("INS")){
			mo.addObject("submitType","Inspection");
			
			}else if(mode.equalsIgnoreCase("INT")){
				mo.addObject("submitType","Interruption");
				
			}else if(mode.equalsIgnoreCase("WAY")){
				mo.addObject("submitType","Way Leave");
				
			}else{
				mo.addObject("submitType","Maintenance");
					
			}
			return mo;
*/		}

		
		
		
		@RequestMapping(value = "/maintenancePlan")
		public ModelAndView maintenancePlan(HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			PivModel model = new PivModel();
			/*Map<String, String> saList = new LinkedHashMap<String, String>();

			List<ApprovalMm>  listApprovalUnread =null;
			if(mode.equalsIgnoreCase("INS")){
				listApprovalUnread = approvalMm.getPendingReqNew("INSREQ", "6",deptId);
			}else if(mode.equalsIgnoreCase("INT")){
				listApprovalUnread = approvalMm.getPendingReqByEE("INTREQ", "6",deptId,userName);
				
			}else if(mode.equalsIgnoreCase("WAY")){
				listApprovalUnread = approvalMm.getPendingReqNew("WAYREQ", "6",deptId);
				
			}else{
				listApprovalUnread = approvalMm.getPendingReqNew("MNTREQ", "6",deptId);
				
			}
            System.out.println(listApprovalUnread.size());
            List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
			int loopSa = saUserList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
				//System.out.println(i);
				Sauserm ojb = saUserList.get(i);
				//System.out.println(ojb.getUserId());
				saList.put(ojb.getUserId(), ojb.getUserNm());

			}
*/	
			
			ModelAndView mo = new ModelAndView();
//			model.setUnReadInspectionReq(listApprovalUnread);
//			model.setSaList(saList);

				
			mo = new ModelAndView("displayInsMaintenancePlan", "model", model);
			/*if(mode.equalsIgnoreCase("INS")){
			mo.addObject("submitType","Inspection");
			
			}else if(mode.equalsIgnoreCase("INT")){
				mo.addObject("submitType","Interruption");
				
			}else if(mode.equalsIgnoreCase("WAY")){
				mo.addObject("submitType","Way Leave");
				
			}else{
				mo.addObject("submitType","Maintenance");
					
			}
			*/return mo;
		}

		
		
		@RequestMapping(value = "/viewAllInspectionMntRequest")
		public ModelAndView viewAllInspectionMntRequest(@RequestParam("mode") String mode,HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			String userLevel = (String) request.getSession().getAttribute("loggedUserRole");
			
			PivModel model = new PivModel();
			
			List<ApprovalMm>  listApprovalUnread =null;
			if(mode.equalsIgnoreCase("INS")){
				//listApprovalUnread = approvalMm.getAllReqForPhmBranch("INSREQ", deptId);
				if(userLevel.equals("ES")){
					listApprovalUnread = approvalMm.getPendingReqByESAll("INSREQ",  deptId, userName);
				}else if(userLevel.equals("EE")){
					listApprovalUnread = approvalMm.getPendingReqByEEAll("INSREQ",  deptId, userName);
				}else{
					listApprovalUnread = approvalMm.getAllReqForPhmBranch("INSREQ", deptId);
		            
				}
	            
			}else if(mode.equalsIgnoreCase("INT")){
				if(userLevel.equals("ES")){
					listApprovalUnread = approvalMm.getPendingReqByESAll("INTREQ",  deptId, userName);
				}else if(userLevel.equals("EE")){
					listApprovalUnread = approvalMm.getPendingReqByEEAll("INTREQ",  deptId, userName);
				}else{
					listApprovalUnread = approvalMm.getAllReqForPhmBranch("INTREQ", deptId);
		            
				}
			}else if(mode.equalsIgnoreCase("MNT")){
				if(userLevel.equals("ES")){
					listApprovalUnread = approvalMm.getPendingReqByESAll("MNTREQ",  deptId, userName);
				}else if(userLevel.equals("EE")){
					listApprovalUnread = approvalMm.getPendingReqByEEAll("MNTREQ",  deptId, userName);
				}else{
					listApprovalUnread = approvalMm.getAllReqForPhmBranch("MNTREQ", deptId);
		            
				}
			}else{
				
			}
			System.out.println(listApprovalUnread.size());
			ModelAndView mo = new ModelAndView();
			model.setUnReadInspectionReq(listApprovalUnread);
			mo = new ModelAndView("viewInsMntRequest", "model", model);
			//if(mode.equalsIgnoreCase("INS")){
			if(mode.equalsIgnoreCase("INS")){
					
			mo.addObject("submitType","Inspection");
			
			}else if(mode.equalsIgnoreCase("INT")){
				
		mo.addObject("submitType","Interruption");
		
		}else{
				mo.addObject("submitType","Maintenance");
				
			}
			return mo;
		}
		
		
		@RequestMapping(value = "/viewAllInspectionMntRequestSendReply")
		public ModelAndView viewAllInspectionMntRequestSendReply(@RequestParam("mode") String mode,HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			String userLevel = (String) request.getSession().getAttribute("loggedUserRole");
			
			Map<String,String> List = new LinkedHashMap<String,String>();
			
			PivModel model = new PivModel();
			
			List<ApprovalMm>  listApprovalUnread =null;
			if(mode.equalsIgnoreCase("INS")){
				//listApprovalUnread = approvalMm.getAllReqForPhmBranch("INSREQ", deptId);
				if(userLevel.equals("ES")){
					listApprovalUnread = approvalMm.getPendingReqByESAll("INSREQ",  deptId, userName);
				}else if(userLevel.equals("EE")){
					listApprovalUnread = approvalMm.getPendingReqByEEAll("INSREQ",  deptId, userName);
				}else{
					listApprovalUnread = approvalMm.getAllReqForPhmBranch("INSREQ", deptId);
		            
				}
	            
			}else if(mode.equalsIgnoreCase("INT")){
				if(userLevel.equals("ES")){
					listApprovalUnread = approvalMm.getPendingReqByESAll("INTREQ",  deptId, userName);
				}else if(userLevel.equals("EE")){
					listApprovalUnread = approvalMm.getPendingReqByEEAll("INTREQ",  deptId, userName);
				}else{
					listApprovalUnread = approvalMm.getAllReqForPhmBranch("INTREQ", deptId);
		            
				}
			}else if(mode.equalsIgnoreCase("MNT")){
				if(userLevel.equals("ES")){
					listApprovalUnread = approvalMm.getPendingReqByESAll("MNTREQ",  deptId, userName);
				}else if(userLevel.equals("EE")){
					listApprovalUnread = approvalMm.getPendingReqByEEAll("MNTREQ",  deptId, userName);
				}else{
					listApprovalUnread = approvalMm.getAllReqForPhmBranch("MNTREQ", deptId);
		            
				}
			}else{
				
			}
			System.out.println(listApprovalUnread.size());
			ModelAndView mo = new ModelAndView();
			model.setUnReadInspectionReq(listApprovalUnread);
			mo = new ModelAndView("viewInsMntRequestSendReply", "model", model);
			//if(mode.equalsIgnoreCase("INS")){
			if(mode.equalsIgnoreCase("INS")){
					
			mo.addObject("submitType","Inspection");
			
			}else if(mode.equalsIgnoreCase("INT")){
				
		mo.addObject("submitType","Interruption");
		
		}else{
				mo.addObject("submitType","Maintenance");
				
			}
			return mo;
		}
		
		
		
		@RequestMapping(value = "/viewAllInMntPHM")
		public ModelAndView viewAllInMntPHM(@RequestParam("mode") String mode,HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String userLevel = (String) request.getSession().getAttribute("loggedUserRole");
			
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			PivModel model = new PivModel();
			List<ApprovalMm>  listApprovalUnread =null;
			
			
			if(mode.equalsIgnoreCase("INS")){
				listApprovalUnread = approvalMm.getAllReqForPhmBranch("INSREQ", deptId);
	            
			}else if(mode.equalsIgnoreCase("INT")){
				if(userLevel.equals("ES")){
					listApprovalUnread = approvalMm.getPendingReqByESAll("INSREQ",  deptId, userName);
				}else if(userLevel.equals("EE")){
					listApprovalUnread = approvalMm.getPendingReqByEEAll("INSREQ",  deptId, userName);
				}else{
					listApprovalUnread = approvalMm.getAllReqForPhmBranch("INTREQ", deptId);
		            
				}
				
	            
			}else{
				listApprovalUnread = approvalMm.getAllReqForPhmBranch("MNTREQ",deptId);
	            
			}
			System.out.println(listApprovalUnread.size());
			ModelAndView mo = new ModelAndView();
			model.setUnReadInspectionReq(listApprovalUnread);
			mo = new ModelAndView("viewInsMntRequest", "model", model);
			//if(mode.equalsIgnoreCase("INS")){
			if(mode.equalsIgnoreCase("INS")){
					
			mo.addObject("submitType","Inspection");
			
			}else if(mode.equalsIgnoreCase("INT")){
				
		mo.addObject("submitType","Interruption");
		
		}else{
				mo.addObject("submitType","Maintenance");
				
			}
			return mo;
		}
		
		
		
		
		
		@RequestMapping(value = "/viewInspectionRequest")
		public ModelAndView viewInspectionRequest(@RequestParam("mode") String mode,HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			PivModel model = new PivModel();
			
			List<ApprovalMm>  listApprovalUnread =null;
			if(mode.equalsIgnoreCase("INS")){
				listApprovalUnread = approvalMm.getAllReqForPhmBranch("INSREQ", deptId);
	            
			}if(mode.equalsIgnoreCase("INT")){
				listApprovalUnread = approvalMm.getAllReqForPhmBranch("INTREQ", deptId);
	            
			}else{
				listApprovalUnread = approvalMm.getAllReqForPhmBranch("MNTREQ",deptId);
	            
			}
			System.out.println(listApprovalUnread.size());
			ModelAndView mo = new ModelAndView();
			model.setUnReadInspectionReq(listApprovalUnread);
			mo = new ModelAndView("viewInsMntRequestNew", "model", model);
			//if(mode.equalsIgnoreCase("INS")){
			if(mode.equalsIgnoreCase("INS")){
					
			mo.addObject("submitType","Inspection");
			
			}else if(mode.equalsIgnoreCase("INT")){
				
		mo.addObject("submitType","Interruption");
		
		}else{
				mo.addObject("submitType","Maintenance");
				
			}
			return mo;
		}


		
		
		@RequestMapping(value = "/viewAllInspectionMntRequestAE")
		public ModelAndView viewAllInspectionMntRequestAE(@RequestParam("mode") String mode ,HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			PivModel model = new PivModel();
			
			List<ApprovalMm>  listApprovalUnread =null;
			if(mode.equalsIgnoreCase("INS")){
				listApprovalUnread = approvalMm.getAllRequestByarea(deptId,"INSREQ");
	            
			}else if(mode.equalsIgnoreCase("INT")){
				listApprovalUnread = approvalMm.getAllIntRequestByarea(deptId,"INTREQ");
	            
			}else {
				listApprovalUnread = approvalMm.getAllRequestByarea(deptId,"MNTREQ");
	            
			}
			
			System.out.println(listApprovalUnread.size());
			ModelAndView mo = new ModelAndView();
			model.setUnReadInspectionReq(listApprovalUnread);
			mo = new ModelAndView("viewInsMntRequest", "model", model);
			if(mode.equalsIgnoreCase("INS")){
				mo.addObject("submitType","Inspection");
			}else if(mode.equalsIgnoreCase("INT")){
				mo.addObject("submitType","Interruption");
			}else{
				mo.addObject("submitType","Maintenance");
				
			}
			return mo;
		}
		
		@RequestMapping(value = "/viewAllInspectionMntRequestAEAE")
		public ModelAndView viewAllInspectionMntRequestAEAE(@RequestParam("mode") String mode ,HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			PivModel model = new PivModel();
			
			List<ApprovalMm>  listApprovalUnread =null;
			if(mode.equalsIgnoreCase("INS")){
				listApprovalUnread = approvalMm.getAllRequestByarea(deptId,"INSREQ");
	            
			}else if(mode.equalsIgnoreCase("INT")){
				listApprovalUnread = approvalMm.getAllIntRequestByarea(deptId,"INTREQ");
	            
			}else {
				listApprovalUnread = approvalMm.getAllRequestByarea(deptId,"MNTREQ");
	            
			}
			
			System.out.println(listApprovalUnread.size());
			ModelAndView mo = new ModelAndView();
			model.setUnReadInspectionReq(listApprovalUnread);
			mo = new ModelAndView("viewInsMntRequestAE", "model", model);
			if(mode.equalsIgnoreCase("INS")){
				mo.addObject("submitType","Inspection");
			}else if(mode.equalsIgnoreCase("INT")){
				mo.addObject("submitType","Interruption");
			}else{
				mo.addObject("submitType","Maintenance");
				
			}
			return mo;
		}
		
		
		
		
		@RequestMapping(value = "/viewAllIntProvince")
		public ModelAndView viewAllIntProvince(@RequestParam("mode") String mode ,HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			PivModel model = new PivModel();
			
			List<ApprovalMm>  listApprovalUnread =null;
			String province = deptDao.getDD(deptId);
			
			if(province != null){
				province = province.trim();
			}

			
			List<String> areaListInt = deptDao.getAreaByProvinceNew(province);
			/*if(province.equals("CP")){
				
			}

*/			listApprovalUnread = approvalMm.getAllIntProvince(areaListInt,"INTREQ");
	            
			
			
			System.out.println(listApprovalUnread.size());
			ModelAndView mo = new ModelAndView();
			model.setUnReadInspectionReq(listApprovalUnread);
			mo = new ModelAndView("viewInsMntRequestPreVersion", "model", model);
			mo.addObject("submitType","Interruption");
			return mo;
		}
		
		
		
		@RequestMapping(value = "/viewAllIntProvinceCC")
		public ModelAndView viewAllIntProvinceCC(@RequestParam("mode") String mode ,HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			PivModel model = new PivModel();
			
			List<ApprovalMm>  listApprovalUnread =null;
			String province = deptDao.getDD(deptId);
			
			if(province != null){
				province = province.trim();
			}

			
			List<String> areaListInt = deptDao.getAreaByProvinceNew(province);
			/*if(province.equals("CP")){
				
			}

*/			listApprovalUnread = approvalMm.getAllIntProvince(areaListInt,"INTREQ");
	            
			
			
			System.out.println(listApprovalUnread.size());
			ModelAndView mo = new ModelAndView();
			model.setUnReadInspectionReq(listApprovalUnread);
			mo = new ModelAndView("BDNewCC", "model", model);
			mo.addObject("submitType","Interruption");
			return mo;
		}



		@RequestMapping(value = "/viewAllIntProvinceCP1")
		public ModelAndView viewAllIntProvinceCP1(@RequestParam("mode") String mode ,HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			PivModel model = new PivModel();
			
			List<ApprovalMm>  listApprovalUnread =null;
			String province = deptDao.getDD(deptId);
			
			if(province != null){
				province = province.trim();
			}

			
			List<String> areaListInt = deptDao.getAreaByProvinceNewCC(province);
			if(province.equals("CP")){
				
			}

			listApprovalUnread = approvalMm.getAllIntProvince(areaListInt,"INTREQ");
	            
			
			
			System.out.println(listApprovalUnread.size());
			ModelAndView mo = new ModelAndView();
			model.setUnReadInspectionReq(listApprovalUnread);
			mo = new ModelAndView("viewInsMntRequestCP1", "model", model);
			mo.addObject("submitType","Interruption");
			return mo;
		}
		
		
		@RequestMapping(value = "/viewAllIntProvinceCP2")
		public ModelAndView viewAllIntProvinceCP2(@RequestParam("mode") String mode ,HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			PivModel model = new PivModel();
			
			List<ApprovalMm>  listApprovalUnread =null;
			String province = deptDao.getDD(deptId);
			
			if(province != null){
				province = province.trim();
			}

			
			List<String> areaListInt = deptDao.getAreaByProvinceNewCP2(province);
			if(province.equals("CP")){
				
			}

			listApprovalUnread = approvalMm.getAllIntProvince(areaListInt,"INTREQ");
	            
			
			
			System.out.println(listApprovalUnread.size());
			ModelAndView mo = new ModelAndView();
			model.setUnReadInspectionReq(listApprovalUnread);
			mo = new ModelAndView("viewInsMntRequestCP2", "model", model);
			mo.addObject("submitType","Interruption");
			return mo;
		}

		@RequestMapping(value = "/displayAllMNTReq")
		public ModelAndView displayAllMNTReq(HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			PivModel model = new PivModel();
			
			List<Approval>  listApprovalUnread =null;
			listApprovalUnread = approval.getPendingReq("", "7",deptId);

			//if(mode.equalsIgnoreCase("WLS")){
				//listApprovalUnread = approval.getNotReadEmail(userName, deptId);

			/*}else if(mode.equalsIgnoreCase("ISS")){
				listApprovalUnread = approval.getPendingReq("", "6");

			}else if(mode.equalsIgnoreCase("MRS")){
				listApprovalUnread = approval.getPendingReq("", "7");

			}
*/
			
			
			ModelAndView mo = new ModelAndView();
			model.setUnReadEmailList(listApprovalUnread);
			
			//if(mode.equalsIgnoreCase("WLS")){
				
			mo = new ModelAndView("displayInsMntRequest", "model", model);
			mo.addObject("submitType","Maintenance");
			
			/*}else{
				mo = new ModelAndView("displayAllInMntReqAE", "model", model);
				
				if(mode.equalsIgnoreCase("ISS")){
					mo.addObject("submitType","Inspection");
				}else{
					mo.addObject("submitType","Maintenance");
				}
			
				
			}
			*/return mo;
		}

		
		
		@RequestMapping(value = "/displayAllUnReadMsgAE")
		public ModelAndView displayAllUnReadMsgAE(HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			PivModel model = new PivModel();
			List<Approval>  listApprovalUnread =null;
				listApprovalUnread = approval.getNotReadEmailArea(deptId);
/*
			}else if(mode.equalsIgnoreCase("ISS")){
				listApprovalUnread = approval.getPendingReq("", "6");

			}else if(mode.equalsIgnoreCase("MRS")){
				listApprovalUnread = approval.getPendingReq("", "7");

			}
*/
			ModelAndView mo = new ModelAndView();
			model.setUnReadEmailList(listApprovalUnread);
			//model.setMode(mode);
			//if(mode.equalsIgnoreCase("WLS")){
				//System.out.println("CE CE 3 1" + mode);
							mo = new ModelAndView("displayAllUnreadEmailAE", "model", model);
			
			
			/*}else{
				mo = new ModelAndView("displayAllInMntReqAE", "model", model);
				
				if(mode.equalsIgnoreCase("ISS")){
					mo.addObject("submitType","Inspection");
				}else{
					mo.addObject("submitType","Maintenance");
				}
					
			}*/
			return mo;
		}
		
		
		
		@RequestMapping(value = "/displayAllInsRequestAENewView")
		public @ResponseBody List<ApprovalMm> displayAllInsRequestAENewView(@RequestParam("mode") String mode ,HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			PivModel model = new PivModel();
			List<ApprovalMm>  listApprovalUnread =null;
			if(mode.equalsIgnoreCase("INS")){
				listApprovalUnread = approvalMm.getPendingReqByArea(deptId, "6", "INSREQ");
			}else if(mode.equalsIgnoreCase("INT")){
				listApprovalUnread = approvalMm.getAllInterruptionReqNew(deptId, "95", "INTREQ","1");
			}else if(mode.equalsIgnoreCase("MNT")){
				listApprovalUnread = approvalMm.getPendingReqByArea(deptId, "6", "MNTREQ");
			}else if(mode.equalsIgnoreCase("WAY")){
				listApprovalUnread = approvalMm.getAllInterruptionReq(deptId, "6", "WAYREQ");
			}else{
				
				String province = deptDao.getDD(deptId);
				
				if(province != null){
					province = province.trim();
				}
				System.out.println("else" + mode +"/");
				if(mode != null){
					mode=mode.trim();
				}
				List<String> areaListInt = deptDao.getAreaByProvinceNew(province);
				String userLevel = "";
				if(userName != null){
					userLevel = secDao.getAuthorizedLevel(userName);
					
				}
				System.out.println("else" + userLevel +"/");
				if(userLevel != null){
					userLevel = userLevel.trim();
					
				}
				
				System.out.println("elseuserLevel" + userLevel +"/");
				
				if(userLevel.equalsIgnoreCase("EEC")){
					listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","3");
					
				}else{
					listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","2");
				}
				
			}
			return listApprovalUnread;
		}
		
		
		
		
		
		@RequestMapping(method= RequestMethod.GET,value="/displayInterruption",  produces = "application/json",  consumes = "application/json")
		 public @ResponseBody List<ApprovalMm> displayInterruption(@RequestParam("deptId") String deptId,@RequestParam("userName") String userName) {
			PivModel model = new PivModel();
			List<ApprovalMm>  listApprovalUnread =null;
			listApprovalUnread = approvalMm.getAllInterruptionReqNew(deptId, "95", "INTREQ","1");
			String province = deptDao.getDD(deptId);
			if(province != null){
					province = province.trim();
			}
			List<String> areaListInt = deptDao.getAreaByProvinceNew(province);
			String userLevel = "";
			if(userName != null){
			    userLevel = secDao.getAuthorizedLevel(userName);
			}
			if(userLevel != null){
				userLevel = userLevel.trim();
				if(userLevel.equalsIgnoreCase("EEC")){
					listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","3");
				}else{
					listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","2");
				}
			}
			return listApprovalUnread;
		}


		
		
		
		
		@RequestMapping(value = "/displayAllInsRequestAE")
		public ModelAndView displayAllInsRequestAE(@RequestParam("mode") String mode ,HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			//String userLevel = (String) request.getSession().getAttribute("userLevel");
			
			String deptId = (String) request.getSession().getAttribute("deptId");
			PivModel model = new PivModel();
			List<ApprovalMm>  listApprovalUnread =null;
			Map<String, String> saList = new LinkedHashMap<String, String>();
			List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
			int loopSa = saUserList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
				//System.out.println(i);
				Sauserm ojb = saUserList.get(i);
				//System.out.println(ojb.getUserId());
				saList.put(ojb.getUserId(), ojb.getUserNm());

			}

			if(mode.equalsIgnoreCase("INS")){
				listApprovalUnread = approvalMm.getPendingReqByArea(deptId, "6", "INSREQ");
			}else if(mode.equalsIgnoreCase("INT")){
				listApprovalUnread = approvalMm.getAllInterruptionReqNew(deptId, "95", "INTREQ","1");
			}else if(mode.equalsIgnoreCase("MNT")){
				listApprovalUnread = approvalMm.getPendingReqByArea(deptId, "6", "MNTREQ");
			}else if(mode.equalsIgnoreCase("WAY")){
				listApprovalUnread = approvalMm.getAllInterruptionReq(deptId, "6", "WAYREQ");
			}else{
				
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
				
				String province = deptDao.getDD(deptId);
				
				if(province != null){
					province = province.trim();
				}
				System.out.println("else" + mode +"/");
				if(mode != null){
					mode=mode.trim();
				}
				List<String> areaListInt = deptDao.getAreaByProvinceNew(province);
				String userLevel = "";
				if(userName != null){
					userLevel = secDao.getAuthorizedLevel(userName);
					
				}
				System.out.println("else" + userLevel +"/");
				if(userLevel != null){
					userLevel = userLevel.trim();
					
				}
				
				System.out.println("elseuserLevel" + userLevel +"/");
				
				if(userLevel.equalsIgnoreCase("EEC")){
					listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","3");
					
				}else{
					listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","2");
				}
				
			}
			ModelAndView mo = new ModelAndView();
			model.setUnReadInspectionReq(listApprovalUnread);
			model.setSaList(saList);
			
			mo = new ModelAndView("displayAllInMntReqAE", "model", model);
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
			return mo;
		}
		
		
		@RequestMapping(value = "/displayAllInsRequestAEIntNewView")
		public ModelAndView displayAllInsRequestAEIntNewView(@RequestParam("mode") String mode ,@RequestParam("id") String id) {
			//String userName = (String) request.getSession().getAttribute("loggedUser");
			//String userLevel = (String) request.getSession().getAttribute("userLevel");
			System.out.println("yyyyyyy");
			//String deptId = (String) request.getSession().getAttribute("deptId");
			PivModel model = new PivModel();
			List<ApprovalMm>  listApprovalUnread = new ArrayList<ApprovalMm>() ;
			System.out.println("yyyyyyy" + id);
			
			ApprovalMm obj = null;
			try {
				obj = approvalMm.findByID(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("eeeee" + id);
				
				e.printStackTrace();
			}
			if(obj != null){
				listApprovalUnread.add(obj);
			}
			System.out.println("xxxxxx" + id);
			
			/*Map<String, String> saList = new LinkedHashMap<String, String>();
			List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
			int loopSa = saUserList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
				//System.out.println(i);
				Sauserm ojb = saUserList.get(i);
				//System.out.println(ojb.getUserId());
				saList.put(ojb.getUserId(), ojb.getUserNm());

			}
*/
/*			if(mode.equalsIgnoreCase("INS")){
				listApprovalUnread = approvalMm.getPendingReqByArea(deptId, "6", "INSREQ");
			}else if(mode.equalsIgnoreCase("INT")){
				listApprovalUnread = approvalMm.getAllInterruptionReqNew(deptId, "95", "INTREQ","1");
			}else if(mode.equalsIgnoreCase("MNT")){
				listApprovalUnread = approvalMm.getPendingReqByArea(deptId, "6", "MNTREQ");
			}else if(mode.equalsIgnoreCase("WAY")){
				listApprovalUnread = approvalMm.getAllInterruptionReq(deptId, "6", "WAYREQ");
			}else{
				
				if(deptId.equalsIgnoreCase("440.00")){
					mode = "NWP";
				}else if (deptId.equalsIgnoreCase("430.00")){
					mode = "CP";
				}else if (deptId.equalsIgnoreCase("460.00")){
					mode = "EP";
				}else{
					
				}
				System.out.println(i);
				
				
				String province = deptDao.getDD(deptId);
				
				if(province != null){
					province = province.trim();
				}
				System.out.println("else" + mode +"/");
				if(mode != null){
					mode=mode.trim();
				}
				List<String> areaListInt = deptDao.getAreaByProvinceNew(province);
				String userLevel = "";
				if(userName != null){
					userLevel = secDao.getAuthorizedLevel(userName);
					
				}
				System.out.println("else" + userLevel +"/");
				if(userLevel != null){
					userLevel = userLevel.trim();
					
				}
				
				System.out.println("elseuserLevel" + userLevel +"/");
				
				if(userLevel.equalsIgnoreCase("EEC")){
					listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","3");
					
				}else{
					listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","2");
				}
				
			}*/
			ModelAndView mo = new ModelAndView();
			model.setUnReadInspectionReq(listApprovalUnread);
			//model.setSaList(saList);
			//model.setIntRequestObj(approvalMm.findByID("INT-600.42-0123"));
			mo = new ModelAndView("displayAllInMntReqAENewView", "model", model);
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
			return mo;
		}

		
		
		/*@RequestMapping(value = "/intScheduleEdit")
		public ModelAndView intScheduleEdit(HttpServletRequest request,@ModelAttribute("model") PivModel modelObj) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String userLevelLogin = (String) request.getSession().getAttribute("userLevel");
			String province = "";
			String deptId = (String) request.getSession().getAttribute("deptId");
			PivModel model = new PivModel();
			List<ApprovalMm>  listApprovalUnread =null;
			Map<String, String> saList = new LinkedHashMap<String, String>();
			List<String> userList = new LinkedList<String>();
			
			String userLevel = "";
			if(userName != null){
				userLevel = secDao.getAuthorizedLevel(userName);
				
			}
			System.out.println("else" + userLevel +"/");
			if(userLevel != null){
				userLevel = userLevel.trim();
				
			}
			
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
				userList.add("ES");
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
				
				if(deptId.equalsIgnoreCase("440.00")){
					mode = "NWP";
				}else if (deptId.equalsIgnoreCase("430.00")){
					mode = "CP";
				}else if (deptId.equalsIgnoreCase("460.00")){
					mode = "EP";
				}else{
					
				}
				System.out.println(i);
				
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
				if(modelObj.getType().equalsIgnoreCase("EDIT") || modelObj.getType().equalsIgnoreCase("SFVDEO")){
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
				}else if (modelObj.getType().equalsIgnoreCase("SFVES")){
					List<String> statusNew = new ArrayList<String>(1);
					statusNew.add("86");
					System.out.println("oooooooooo statusNew");
					
					listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, statusNew, "INTREQ","3",userName);
					
				}else{
					
				}
				
				System.out.println("elseuserLevel" + userLevel +"/");
				List<String> status = new ArrayList<String>(2);
				status.add("80");
				status.add("96");
				if(modelObj.getType().equalsIgnoreCase("EDIT") ||userLevel.equalsIgnoreCase("DEO")){
					System.out.println("getFromDate" + modelObj.getFromDate() +"/");
					System.out.println("getToDate" + modelObj.getToDate() +"/");
					if(modelObj.getFromDate() != null || modelObj.getToDate() != null ){
						System.out.println("getToDatennnnn");
						if(type.equalsIgnoreCase("EDIT") || type.equalsIgnoreCase("SFVDEO")){
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
					
				}else{
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
			
			
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(province);
			int depLoop = deptTm.size()-1;
			for(int i=0;i<=depLoop;i++){ 
				System.out.println(i);
				Gldeptm ojb = (Gldeptm)deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		    }
            model.setAreaList(areaList);
            model.setType(type);
			model.setFrom(modelObj.getFrom());
			model.setFromDate(modelObj.getFromDate());
			model.setToDate(modelObj.getToDate());
			mo = new ModelAndView("CreateIntSchedule", "model", model);
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
*/		
		
		
		
		@RequestMapping(value = "/createIntSchedule")
		public ModelAndView createIntSchedule(@RequestParam("mode") String mode ,@RequestParam("type") String type ,HttpServletRequest request,@ModelAttribute("model") PivModel modelObj) {
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
				//userList.add("PE");
				userList.add("EEC");
			}else if(userLevel.equalsIgnoreCase("ES")){
				userList.add("ES");
				//userList.add("EE");
				//userList.add("PE");
				userList.add("DEO");
				userList.add("EEC");
			}else if(userLevel.equalsIgnoreCase("ES")){
				userList.add("ES");
				//userList.add("EE");
				//userList.add("PE");
				userList.add("DEO");
				
				userList.add("EEC");
			}else if(userLevel.equalsIgnoreCase("EEC") ||userLevel.equalsIgnoreCase("EE") || userLevel.equalsIgnoreCase("PE")){
				//userList.add("ES");
				//userList.add("EE");
				//userList.add("PE");
				userList.add("EEC");
				userList.add("PCE");

			}else if(userLevel.equalsIgnoreCase("CE")){
				userList.add("DGM");
				
			}else if(userLevel.equalsIgnoreCase("PCE")){
				userList.add("DGM");
				
			}else{
				
			}
			
			
			
			
			List<Sauserm> saUserList = secDao.getAllUserByRptUserCC(deptId, userList,userLevel);
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
				if(modelObj.getType().equalsIgnoreCase("EDIT") || modelObj.getType().equalsIgnoreCase("SFVDEO")){
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
				}else if (modelObj.getType().equalsIgnoreCase("SFVES")){
					List<String> statusNew = new ArrayList<String>(2);
					statusNew.add(statusto);
					statusNew.add(statusto2);
					System.out.println("oooooooooo statusNew");
					
					listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNewCycle(areaListInt, statusNew, "INTREQ","3",userName,intcycle);
					
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
				status.add("77");
				
				if(modelObj.getType().equalsIgnoreCase("EDIT") ||userLevel.equalsIgnoreCase("DEO") ||userLevel.equalsIgnoreCase("SFVDEO")){
					System.out.println("getFromDate" + modelObj.getFromDate() +"/");
					System.out.println("getToDate" + modelObj.getToDate() +"/");
					if(modelObj.getFromDate() != null || modelObj.getToDate() != null ){
						System.out.println("getToDatennnnn");
						if(type.equalsIgnoreCase("EDIT") || type.equalsIgnoreCase("SFVDEO")){
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
				/*System.out.println("-------------------> getCsc: " + obj.getCsc());
				System.out.println("-------------------> getGrid: " + obj.getGrid());
				System.out.println("-------------------> getAltSupArrangement: " + obj.getAltSupArrangement());
				System.out.println("-------------------> getRemarks: " + obj.getRemarks());
				System.out.println("-------------------> getAnnouncement: " + obj.getAnnouncement());
				System.out.println("-------------------> getIntCycle: " + obj.getIntCycle());
				System.out.println("-------------------> setToStatus: " + obj.getToStatus());
				
	
				 obj.setCsc(obj.getCsc());
			        obj.setGrid(obj.getGrid());
			        obj.setAltSupArrangement(obj.getAltSupArrangement());
			        obj.setRemarks(obj.getRemarks());
			        obj.setAnnouncement(obj.getAnnouncement());
			        //obj.setCcApprovalUser(incharge);
			        obj.setIntCycle(obj.getIntCycle());
			        
			        if(obj.getToStatus().equalsIgnoreCase("77")){
			        	obj.setToStatus("77");
			        }
			        approvalMm.update(obj);
*/

				
				
			}
			
			System.out.println("-------------------> stringOfLineIds: " + stringOfLineIds);

			model.setStringOfLineIds(stringOfLineIds);

			
			}
			
			
			
			
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(province);
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
			mo = new ModelAndView("CreateIntSchedule", "model", model);
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
		
		
		
		@RequestMapping(value = "/createIntScheduleView")
		public ModelAndView createIntScheduleView(@RequestParam("mode") String mode ,@RequestParam("type") String type ,HttpServletRequest request,@ModelAttribute("model") PivModel modelObj) {
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
				//userList.add("PE");
				userList.add("EEC");
			}else if(userLevel.equalsIgnoreCase("ES")){
				userList.add("ES");
				//userList.add("EE");
			//	userList.add("PE");
				userList.add("DEO");
				userList.add("EEC");
			}else if(userLevel.equalsIgnoreCase("ES")){
				userList.add("ES");
				//userList.add("EE");
				//userList.add("PE");
				userList.add("DEO");
				
				userList.add("EEC");
			}else if(userLevel.equalsIgnoreCase("EEC") ||userLevel.equalsIgnoreCase("EE") || userLevel.equalsIgnoreCase("PE")){
				//userList.add("ES");
				//userList.add("EE");
				//userList.add("PE");
				userList.add("EEC");
				userList.add("PCE");

			}else if(userLevel.equalsIgnoreCase("CE")){
				userList.add("DGM");
				
			}else if(userLevel.equalsIgnoreCase("PCE")){
				userList.add("DGM");
				
			}else{
				
			}
			
			
			
			
			List<Sauserm> saUserList = secDao.getAllUserByRptUserCC(deptId, userList,userLevel);
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
			
			
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(province);
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
			mo = new ModelAndView("CreateIntScheduleView", "model", model);
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

		
		
		
		
		
		@RequestMapping(value = "/createIntScheduleAll")
		public ModelAndView createIntScheduleAll(@RequestParam("mode") String mode ,@RequestParam("type") String type ,HttpServletRequest request,@ModelAttribute("model") PivModel modelObj) {
			
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
				if(modelObj.getType().equalsIgnoreCase("EDIT") || modelObj.getType().equalsIgnoreCase("SFVDEO")){
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
				}else if (modelObj.getType().equalsIgnoreCase("SFVES")){
					List<String> statusNew = new ArrayList<String>(2);
					statusNew.add(statusto);
					statusNew.add(statusto2);
					System.out.println("oooooooooo statusNew");
					
					listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNewCycle(areaListInt, statusNew, "INTREQ","3",userName,intcycle);
					
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
				if(modelObj.getType().equalsIgnoreCase("EDIT") ||userLevel.equalsIgnoreCase("DEO") ||userLevel.equalsIgnoreCase("SFVDEO")){
					System.out.println("getFromDate" + modelObj.getFromDate() +"/");
					System.out.println("getToDate" + modelObj.getToDate() +"/");
					if(modelObj.getFromDate() != null || modelObj.getToDate() != null ){
						System.out.println("getToDatennnnn");
						if(type.equalsIgnoreCase("EDIT") || type.equalsIgnoreCase("SFVDEO")){
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
			
			
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(province);
			int depLoop = deptTm.size()-1;
			for(int i=0;i<=depLoop;i++){ 
				System.out.println(i);
				Gldeptm ojb = (Gldeptm)deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		    }
			model.setCycleList(cycle);
            model.setAreaList(areaList);
            model.setType(type);
			model.setFrom(modelObj.getFrom());
			model.setFromDate(modelObj.getFromDate());
			model.setToDate(modelObj.getToDate());
			mo = new ModelAndView("CreateIntScheduleAll", "model", model);
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


		
		
		
		@RequestMapping(value = "/createIntScheduleEdit")
		public ModelAndView createIntScheduleEdit(@RequestParam("mode") String mode ,@RequestParam("type") String type ,HttpServletRequest request,@ModelAttribute("model") PivModel modelObj) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String userLevelLogin = (String) request.getSession().getAttribute("userLevel");
			String province = "";
			String deptId = (String) request.getSession().getAttribute("deptId");
			PivModel model = new PivModel();
			List<ApprovalMm>  listApprovalUnread =null;
			Map<String, String> saList = new LinkedHashMap<String, String>();
			Map<String, String> cscList = new LinkedHashMap<String, String>();
			
			List<String> userList = new LinkedList<String>();
			
			String userLevel = "";
			if(userName != null){
				userLevel = secDao.getAuthorizedLevel(userName);
				
			}
			System.out.println("else" + userLevel +"/");
			if(userLevel != null){
				userLevel = userLevel.trim();
				
			}
			
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
				userList.add("ES");
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
				if(modelObj.getType().equalsIgnoreCase("EDIT")){
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
				}/*else if (modelObj.getType().equalsIgnoreCase("SFVES")){
					List<String> statusNew = new ArrayList<String>(1);
					statusNew.add("86");
					System.out.println("oooooooooo statusNew");
					
					listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, statusNew, "INTREQ","3",userName);
					
				}*/else{
					
				}
				
				System.out.println("elseuserLevel" + userLevel +"/");
				List<String> status = new ArrayList<String>(2);
				status.add("80");
				status.add("96");
				if(modelObj.getType().equalsIgnoreCase("EDIT")){
					System.out.println("getFromDate" + modelObj.getFromDate() +"/");
					System.out.println("getToDate" + modelObj.getToDate() +"/");
					if(modelObj.getFromDate() != null || modelObj.getToDate() != null ){
						System.out.println("getToDatennnnn");
						if(type.equalsIgnoreCase("EDIT") || type.equalsIgnoreCase("SFVDEO")){
							System.out.println("getToDatennnnnEDIT");
							
							listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, status, "INTREQ","3",modelObj.getFromDate(),modelObj.getToDate());
							
						/*if(listApprovalUnread != null){
							int count = listApprovalUnread.size();
							for(int i = 0 ; i < count ; i++){
								ApprovalMm appObj = listApprovalUnread.get(i);
								List<Gldeptm> listGL =  gldeptDao.getCscByArea(appObj.getAreaCode());
								if(listGL != null){
									int countL = listGL.size();
									for(int x = 0;x<countL;x++){
										Gldeptm ojb = listGL.get(i);
										cscList.put(ojb.getDeptId(), ojb.getDeptNm());
									}
									//appObj.setCscList(cscList);
								}
								
							}
							
						}*/
						
						
						
						
						}/*else if(type.equalsIgnoreCase("SFVES")){
							System.out.println("getToDatennnnnSFVES");
							
							List<String> statusNew = new ArrayList<String>(1);
							statusNew.add("86");
							
							listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, statusNew, "INTREQ","3",userName);
							
						}
						*/
					}
					
					modelObj.setSelectedLine(model.getFrom());
					
				}else{
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
			
			
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(province);
			int depLoop = deptTm.size()-1;
			for(int i=0;i<=depLoop;i++){ 
				System.out.println(i);
				Gldeptm ojb = (Gldeptm)deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		    }
            model.setAreaList(areaList);
            model.setType(type);
			model.setFrom(modelObj.getFrom());
			model.setFromDate(modelObj.getFromDate());
			model.setToDate(modelObj.getToDate());
			mo = new ModelAndView("CreateIntScheduleEdit", "model", model);
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


		
		//manageIntReqES.jsp
		
		
		@RequestMapping(value = "/manageIntRequestAE")
		public ModelAndView manageIntRequestAE(@RequestParam("mode") String mode ,HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			PivModel model = new PivModel();
			List<ApprovalMm>  listApprovalUnread =null;
			Map<String, String> saList = new LinkedHashMap<String, String>();
			
			List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
			int loopSa = saUserList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
				//System.out.println(i);
				Sauserm ojb = saUserList.get(i);
				//System.out.println(ojb.getUserId());
				saList.put(ojb.getUserId(), ojb.getUserNm());

			}

			if(mode.equalsIgnoreCase("VIW")){
				listApprovalUnread = approvalMm.getAllInterruptionReq(deptId, "95", "INTREQ");
			}else {
				List<String> areaListInt = deptDao.getAreaByProvinceNew(mode);
				
				listApprovalUnread = approvalMm.getAllInterruptionReqForProvince(areaListInt, "95", "INTREQ");
			}
			
			/*else if(mode.equalsIgnoreCase("MNT")){
				listApprovalUnread = approvalMm.getPendingReqByArea(deptId, "6", "MNTREQ");
			}else if(mode.equalsIgnoreCase("WAY")){
				listApprovalUnread = approvalMm.getAllInterruptionReq(deptId, "6", "WAYREQ");
			}else{
				List<String> areaListInt = deptDao.getAreaByProvinceNew(mode);
				listApprovalUnread = approvalMm.getAllInterruptionReqForProvince(areaListInt, "95", "INTREQ");

				
			}
*/			ModelAndView mo = new ModelAndView();
			model.setUnReadInspectionReq(listApprovalUnread);
			model.setSaList(saList);
			mo = new ModelAndView("manageIntReqES", "model", model);
			if(mode.equalsIgnoreCase("FWD")){
			  mo.addObject("submitType","FWD");
			}else if(mode.equalsIgnoreCase("APP")){
				mo.addObject("submitType","APP");
			}else if(mode.equalsIgnoreCase("NAP")){
				mo.addObject("submitType","NAP");
			}else if(mode.equalsIgnoreCase("RSD")){
				mo.addObject("submitType","RSD");
			}else if(mode.equalsIgnoreCase("VIW")){
				mo.addObject("submitType","VIW");
			}else{
				mo.addObject("submitType","PROVINCE");
				
			}
			return mo;
		}
		
		
		
		@RequestMapping(value = "/breakDownMNT")
		public ModelAndView breakDownMNT(@RequestParam("mode") String mode ,HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String userRole = (String) request.getSession().getAttribute("loggedUserRole");
			//String userLevel = (String) request.getSession().getAttribute("userLevel");
			
			String deptId = (String) request.getSession().getAttribute("deptId");
			PivModel model = new PivModel();
			Map<String, String> saList = new LinkedHashMap<String, String>();
			Map<String, String> appList = new LinkedHashMap<String, String>();

			
			List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
			List<Applicant> appliList = applicantDao.getAllApplicantBydeptId(deptId);
			int loopApp = appliList.size() - 1;
			for (int i = 0; i <= loopApp; i++) {
				//System.out.println(i);
				Applicant ojb = appliList.get(i);
				//System.out.println(ojb.getIdNo());
				appList.put(ojb.getIdNo(), ojb.getFullName());

			}

			int loopSa = saUserList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
				//System.out.println(i);
				Sauserm ojb = saUserList.get(i);
				//System.out.println(ojb.getUserId());
				saList.put(ojb.getUserId(), ojb.getUserNm());

			}
			List<ApprovalMm>  listApprovalUnread =null;
			System.out.println("mode.equalsIgnoreCase" + mode.equalsIgnoreCase("INS"));
			System.out.println("userRole.equalsIgnoreCase" + userRole.equalsIgnoreCase("ES"));
			
			if(mode.equalsIgnoreCase("INS")){
				if(userRole.equalsIgnoreCase("ES")){
					listApprovalUnread = approvalMm.getPendingReqByESNew("INSREQ", "99",userName);
					
				}else{
					listApprovalUnread = approvalMm.getPendingReqByEE("INSREQ", "6",deptId,userName);
					
				}
			}else{
				
				if(userRole.equalsIgnoreCase("ES")){
					listApprovalUnread = approvalMm.getPendingReqByESNew("MNTREQ", "99",userName);
					
				}else{
					listApprovalUnread = approvalMm.getPendingReqByEE("MNTREQ", "6",deptId,userName);
					
			}
				
				
			}
			/*int ins = listApprovalUnread.size() - 1;
			for (int i = 0; i <= ins; i++) {
				ApprovalMm ojb = listApprovalUnread.get(i);
				ojb.setSausermList(saUserList);
			}
*/
			
			
			ModelAndView mo = new ModelAndView();
			model.setSaList(saList);
			model.setAppList(appList);
			model.setSausermList(saUserList);
			model.setUnReadInspectionReq(listApprovalUnread);
			mo = new ModelAndView("BDNew", "model", model);
			if(mode.equalsIgnoreCase("INS")){
				if(userRole.equalsIgnoreCase("ES")){
					
				mo.addObject("submitType","Breakdown Estimate for Inspection Request");
				}else{
					mo.addObject("submitType","Forward Inspection Request");
						
				}
				mo.addObject("type","INS");
				
			}else{
				if(userRole.equalsIgnoreCase("ES")){
					
				mo.addObject("submitType","Breakdown Estimate for Maintenance Request");
				}else{
					mo.addObject("submitType","Forward Maintenance Request");
					
				}
				mo.addObject("type","MNT");
			}
			return mo;
		}
		
		
		@RequestMapping(value = "/breakDownMNTReply")
		public ModelAndView breakDownMNTReply(@RequestParam("mode") String mode ,HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String userRole = (String) request.getSession().getAttribute("loggedUserRole");
			//String userLevel = (String) request.getSession().getAttribute("userLevel");
			
			String deptId = (String) request.getSession().getAttribute("deptId");
			PivModel model = new PivModel();
			Map<String, String> saList = new LinkedHashMap<String, String>();
			Map<String, String> appList = new LinkedHashMap<String, String>();

			
			List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
			List<Applicant> appliList = applicantDao.getAllApplicantBydeptId(deptId);
			int loopApp = appliList.size() - 1;
			for (int i = 0; i <= loopApp; i++) {
				//System.out.println(i);
				Applicant ojb = appliList.get(i);
				//System.out.println(ojb.getIdNo());
				appList.put(ojb.getIdNo(), ojb.getFullName());

			}

			int loopSa = saUserList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
				//System.out.println(i);
				Sauserm ojb = saUserList.get(i);
				//System.out.println(ojb.getUserId());
				saList.put(ojb.getUserId(), ojb.getUserNm());

			}
			List<ApprovalMm>  listApprovalUnread =null;
			System.out.println("mode.equalsIgnoreCase" + mode.equalsIgnoreCase("INS"));
			System.out.println("userRole.equalsIgnoreCase" + userRole.equalsIgnoreCase("ES"));
			
			if(mode.equalsIgnoreCase("INS")){
				if(userRole.equalsIgnoreCase("ES")){
					listApprovalUnread = approvalMm.getPendingReqNew("INSREQ", "99",deptId);
					
				}else{
					listApprovalUnread = approvalMm.getPendingReqNew("INSREQ", "6",deptId);
					
				}
			}else{
				
				if(userRole.equalsIgnoreCase("ES")){
					listApprovalUnread = approvalMm.getPendingReqNew("MNTREQ", "99",deptId);
					
				}else{
					listApprovalUnread = approvalMm.getPendingReqNew("MNTREQ", "6",deptId);
					
			}
				
				
			}
			/*int ins = listApprovalUnread.size() - 1;
			for (int i = 0; i <= ins; i++) {
				ApprovalMm ojb = listApprovalUnread.get(i);
				ojb.setSausermList(saUserList);
			}
*/
			
			
			ModelAndView mo = new ModelAndView();
			model.setSaList(saList);
			model.setAppList(appList);
			model.setSausermList(saUserList);
			model.setUnReadInspectionReq(listApprovalUnread);
			mo = new ModelAndView("BDReply", "model", model);
			if(mode.equalsIgnoreCase("INS")){
				if(userRole.equalsIgnoreCase("ES")){
					
				mo.addObject("submitType","Breakdown Estimate for Inspection Request");
				}else{
					mo.addObject("submitType","Forward Inspection Request");
						
				}
				mo.addObject("type","INS");
				
			}else{
				if(userRole.equalsIgnoreCase("ES")){
					
				mo.addObject("submitType","Breakdown Estimate for Maintenance Request");
				}else{
					mo.addObject("submitType","Forward Maintenance Request");
					
				}
				mo.addObject("type","MNT");
			}
			return mo;
		}

		
		
		
		@RequestMapping(value = "/displayAllMNTREQUEST")
		public ModelAndView displayAllMNTREQUEST(HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			PivModel model = new PivModel();
			List<Approval>  listApprovalUnread =null;
			
			listApprovalUnread = approval.getPendingReq("", "7",deptId);

				//listApprovalUnread = approval.getNotReadEmailArea(deptId);
/*
			}else if(mode.equalsIgnoreCase("ISS")){
				listApprovalUnread = approval.getPendingReq("", "6");

			}else if(mode.equalsIgnoreCase("MRS")){
				listApprovalUnread = approval.getPendingReq("", "7");

			}
*/
			ModelAndView mo = new ModelAndView();
			model.setUnReadEmailList(listApprovalUnread);
			//model.setMode("INS");
			//if(mode.equalsIgnoreCase("WLS")){
				//System.out.println("CE CE 3 1" + mode);
							mo = new ModelAndView("displayAllInMntReqAE", "model", model);
							mo.addObject("submitType","Maintenance");
			
			/*}else{
				mo = new ModelAndView("displayAllInMntReqAE", "model", model);
				
				if(mode.equalsIgnoreCase("ISS")){
					mo.addObject("submitType","Inspection");
				}else{
					mo.addObject("submitType","Maintenance");
				}
					
			}*/
			return mo;
		}


		
		
		@RequestMapping(value = "/displayAllUnReadInsReqAE")
		public ModelAndView displayAllUnReadInsReqAE(HttpServletRequest request,@RequestParam("mode") String mode) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			PivModel model = new PivModel();
			List<Approval>  listApprovalUnread = approval.getNotReadEmailArea(deptId);
			ModelAndView mo = new ModelAndView();
			model.setUnReadEmailList(listApprovalUnread);
			model.setMode(mode);
			mo = new ModelAndView("displayAllUnreadEmailAE", "model", model);
			mo.addObject("type",mode);
			return mo;
		}
		
		
		
		@RequestMapping(value = "/MarkasRead/{emailid}/{status}", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody void updateLineStatusee(HttpServletRequest request,@PathVariable("emailid") String email,@PathVariable("status") String status) {

			
			try {
				String deptId = request.getSession().getAttribute("deptId").toString();
				String deptName = request.getSession().getAttribute("deptName").toString();
				
				Approval obj = approval.findByID(email) ;
				obj.setToStatus(status);
				approval.update(obj);
				Date date = new Date();
				String pre = email.substring(0, 16);
				String pre_approval_id = pre;
				System.out.println("pre 2 " + pre);
				
				String enterDate = sdf.format(date);
				String nextNumver = approval.getNextAppId(pre_approval_id);
				System.out.println("pre 2 " + nextNumver);
				
				String approval_id = pre_approval_id + nextNumver;
				String refrence = deptId;
				String approveType = "EMAILMAR";
				String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
				String fromStatus = "2";
				String toStatus = "3";
				System.out.println("finish 2 " );
				
				String approvedBy = request.getSession().getAttribute("loggedUser").toString();
				
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

				String dateString = format.format(date);
				Date   date2       = format.parse (dateString);    

				SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");

				String timeString = format2.format(date);
				System.out.println("finish 3 " );
				
				
				
				Approval appr = new Approval();
				appr.setApprovalId(approval_id);
				System.out.println("finish 6 " +approval_id);
				appr.setReferenceNo(refrence);
				System.out.println("finish 7 " + refrence);
				String reason = obj.getReason();
				appr.setReason(reason);
				System.out.println("finish 8 " +reason);
				
				appr.setDeptId(deptId);
				System.out.println("finish 9 "+ deptId );
				
				appr.setApprovalType(approveType);
				System.out.println("finish 10 " +approveType);
				
				appr.setApprovedLevel(approveLevel);
				System.out.println("finish 11 "+ approveType );
				
				appr.setFromStatus(fromStatus);
				System.out.println("finish 12 "+ fromStatus);
				
				appr.setToStatus(toStatus);
				System.out.println("finish 13 "+ toStatus );
				
				appr.setApprovedDate(date2);
				System.out.println("finish 14 " + dateString);
				
				appr.setApprovedTime(timeString);
				System.out.println("finish 15 "+ timeString );
				
				appr.setApprovedBy(approvedBy);
				System.out.println("finish 16 "+ approvedBy);
				
				approval.addApproval(appr);
				
				System.out.println("finish 4 " );
				
				DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date today = new Date();
				String subject_str = subject_str_fm.format(today);
				
				
				String content ="" + "\n" + ""+obj.getReason()+ " is seen by " +deptName ;
				String subject ="Confirmation Email from "+obj.getReason() + " " + subject_str;
				ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
				MailMail mm = (MailMail) context.getBean("mailMail");
				//mm.sendMail("Mr. Eranga", "Maintenance data is approved in area " + area);
				//Util.trustEveryone();
				mm.sendMailTo("PHM DD2", content ,"eranga.bogahakumbura@gmail.com",subject);
				
				
				
				
				
			} catch (BeansException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
						
		}

		
		
		//--------------------------------------------------------------------------------------------------------------------
		
	 
	 
	 @RequestMapping(value = "/dashboardPNG", method = RequestMethod.GET)
		public ModelAndView dashboardPNG(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
		 			Map<String,String> cscList = new LinkedHashMap<String,String>();
					Map<String,String> areaList = new LinkedHashMap<String,String>();
					Map<String,String> provinceList = new LinkedHashMap<String,String>();
					
					String userName =(String)request.getSession().getAttribute("loggedUser");
					String deptId =(String)request.getSession().getAttribute("deptId");
					PivModel model = new PivModel();
					List<MmsProvince> provinceListAll =provinceDao.findAll();
					List<MmsArea> areaListAll = areaDao.findAll();
					List<MmsCsc> cscListAll =cscDao.findall();
					int proLoop = provinceListAll.size()-1;
					for(int i=0;i<=proLoop;i++){ 
						System.out.println(i);
						MmsProvince ojb = provinceListAll.get(i);
					    provinceList.put(ojb.getId(), ojb.getProvince());
				      
				    } 
										
					int areaLoop = areaListAll.size()-1;
					for(int i=0;i<=areaLoop;i++){ 
						MmsArea ojb = areaListAll.get(i);
						areaList.put(ojb.getId(), ojb.getArea());
				    } 
					
					int cscLoop = cscListAll.size()-1;
					for(int i=0;i<=cscLoop;i++){ 
						MmsCsc ojb = cscListAll.get(i);
						cscList.put(String.valueOf(ojb.getId()), ojb.getCsc());
				    } 
					model.setProvinceList(provinceList);
					model.setAreaList(areaList);
					model.setCscList(cscList);
					
					ModelAndView mo = new ModelAndView();
					String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
					mo = new ModelAndView("MMS_dashboard_PNG" ,"model",model);
					return mo;

		}
	 
	 @RequestMapping(value = "/getName", method = RequestMethod.GET)
	 public String getName(HttpServletRequest request) {
		 String deptId =(String)request.getSession().getAttribute("deptId");
		 return deptDao.getName(deptId);
	 }
	 
	 
	 @RequestMapping(value = "/dashboardAE", method = RequestMethod.GET)
		public ModelAndView dashboardAE(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel) {
					Map<Long,String> lineList = new LinkedHashMap<Long,String>();
					Map<String,String> areaList = new LinkedHashMap<String,String>();
					String deptId =(String)request.getSession().getAttribute("deptId");
					String userName = (String) request.getSession().getAttribute("loggedUser");
					
					PivModel model = new PivModel();
					//List<Summary> summary = addLine.findAreaSummary(deptId);
					List<MmsAddline> lineObj = addLine.findLineByArea(deptId);
					
					//edit anushka 2018-12-28-----------------------------------------------------------------------------------------------------
					//List<Summary> areaSummary = addLine.findAreaSummary(deptId);
					
					areaList.put(deptId, gldeptDao.getName(deptId));
					
					int lineLoop = lineObj.size()-1;
					for(int i=0;i<=lineLoop;i++){ 
						//System.out.println(i);
						MmsAddline ojb = lineObj.get(i);
						lineList.put(ojb.getId(), ojb.getLineName());
				    } 
					model.setAreaList(areaList);
					model.setLineListNew(lineList);
					//model.setSummaryList(summary);
					
					//edit anushka 2018-12-28-----------------------------------------------------------------------------------------------------
					//model.setAreaSummaryList(areaSummary);
					//----------------------------------------------------------------------------------------------------------------------------
					Map<String,String> cycle = new LinkedHashMap<String,String>();
					
					//List<Long> cycleList = cycleDao.fineMntAvailCycle(deptId);
					
					/*int cycleLisuCount = cycleList.size()-1;
					for(int i=0;i<=cycleLisuCount;i++){ 
						//System.out.println(i);
						Long ojb = cycleList.get(i);
						cycle.put(String.valueOf(ojb), String.valueOf(ojb));
				      
				    } 


					model.setCycleList(cycle);
*/
			
			ModelAndView mo = new ModelAndView();
			String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
						mo = new ModelAndView("MMS_dashboard_AE" ,"model",model);
			
			//List<ApprovalMm>  listPendingIntWay = approvalMm.getAllInterruptionReq(deptId, "6", "WAYREQ");
						List<ApprovalMm>  listPendingIntWay = null;
			List<ApprovalMm>  listPendingInsReq = null;
			List<ApprovalMm>  listPendingMntReq = null;
			List<ApprovalMm>  listPendingIntReq = approvalMm.getAllInterruptionReq(deptId, "95", "INTREQ");
			
			
			int countAllReq = 0;
			int countAllMnt = 0;
			int countAllInt = 0;
			int countAllWay = 0;
			
			int countAll = 0;
			
			if(listPendingInsReq != null ){
				countAllReq = listPendingInsReq.size();
				countAll = listPendingInsReq.size();
				mo.addObject("insReq", listPendingInsReq.size());
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);
				
			}
			
			if(listPendingMntReq != null ){
				countAllMnt = listPendingMntReq.size();
				countAll = countAll + listPendingMntReq.size();
				mo.addObject("mntReq", listPendingMntReq.size());
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);
				
			}
			
			if(listPendingIntReq != null ){
				countAllInt = listPendingIntReq.size();
				countAll = countAll + listPendingIntReq.size();
				mo.addObject("intReq", listPendingIntReq.size());
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);
				
			}
			
			if(listPendingIntWay != null ){
				countAllWay = listPendingIntWay.size();
				countAll = countAll + listPendingIntWay.size();
				mo.addObject("intWay", listPendingIntWay.size());
				mo.addObject("countAllWay", countAllReq);
				mo.addObject("countAll", countAll);
				
			}
			
			
			List<Approval>  listApprovalUnread = null;
			Long countEstimate = pcsstDao.getApprovalListCountAE(approveLevel, userName);
				/*Long countStdEstimate = new Long("0");
			//Long countStdEstimate = spstdEstDao.getApprovalListCount(userName, approveLevel);
			Long countPSEstimate = cbpmtDao.getApprovalList(userName);
			Long countIVEstimate = inTrDao.getApprovalList(userName);
			Long countRQEstimate = RqDao.getApprovalList(userName);
*/

			
			//Long countEstimate = new Long("0");;
			Long countStdEstimate = new Long("0");
			//Long countStdEstimate = spstdEstDao.getApprovalListCount(userName, approveLevel);
			Long countPSEstimate = new Long("0");
			Long countIVEstimate = new Long("0");
			Long countRQEstimate = new Long("0");
	            int countEst = 0;
				int countStdEst = 0;
				int countPS=0;
				int countIV=0;
				int countRQ=0;
				
				

	            if(countEstimate != null){
					countEst = countEstimate.intValue();
					countAll += countEst;
					mo.addObject("countAll", countAll);
					mo.addObject("countEstApprove", countEst);
					
					
					
					
				}
				
				/*if(countStdEstimate != null){
					countStdEst = countStdEstimate.intValue();
					countAll += countStdEst;
					mo.addObject("countAll", countAll);
					mo.addObject("countStdEstApprove", countStdEst);
					
					
				}
				
				if(countPSEstimate != null){
					countPS = countPSEstimate.intValue();
					countAll += countPS;
					mo.addObject("countAll", countAll);
					mo.addObject("countPSApprove", countPS);
					
					
				}

				if(countIVEstimate != null){
					countIV = countIVEstimate.intValue();
					countAll += countIV;
					mo.addObject("countAll", countAll);
					mo.addObject("countIVApprove", countIV);
					
					
				}
				
				if(countRQEstimate != null){
					countRQ = countRQEstimate.intValue();
					countAll += countRQ;
					mo.addObject("countAll", countAll);
					mo.addObject("countRQApprove", countRQ);
					
					
				}
*/int countRevEst = 0;

	            Long countReviseEstimate = pchmtDao.getApprovalListCount(userName, approveLevel);
				if(countReviseEstimate != null){
					countRevEst = countReviseEstimate.intValue();
					countAll += countRevEst;
					mo.addObject("countAll", countAll);
					//mo.addObject("countEstApprove", countEst);
					mo.addObject("countRevEstApprove", countRevEst);
					
					
				}

			
			return mo;

		}
	 
	 
	 @RequestMapping(value = "/findTmByAreaLineCycle/{area}/{lineId}/{cycle}",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<MmsTxntowermaintenance> towerMaintenanceByAreaCycle(@PathVariable("area") String area,@PathVariable("lineId") String lineId,@PathVariable("cycle") String cycle) {
			System.out.println("area line:" + area);
			System.out.println("line:" + lineId);
			System.out.println("cycle:" + cycle);
			List<MmsTxntowermaintenance> mnt = towerTxtMaintenance.findAllByAreaLineCycle(area, lineId,cycle);
			
			/**if(mnt != null){
				int length = mnt.size();
				
				for(int i = 0; i < length ;i++){
					MmsTxntowermaintenance obj = (MmsTxntowermaintenance)mnt.get(i);
					
				}
			}*/
			
			return mnt;
		}
	 
	 
	 
	 @RequestMapping(value = "/findTMALL",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<MmsTxntowermaintenance> findTMALL() {
			return towerTxtMaintenance.findAll();
		}

	 

	/**	@SuppressWarnings("deprecation")
		@RequestMapping(value = "/updateTowerMaintence/{visitid}/{towerid}/{nooftappings}/{pinpole1}/{switchdev1}/{switchdev1}/{pinpole2}/{switchdev2}/{pinpole3}/{switchdev3}/{noofmissingparts}/{wayleavestatus}/{baseconcretestatus}/{anticlimbingstatus}/{conductorstatus}/{jumperstatus}/{earthconductorstatus}/{attentionstatus}/{fungussetno}/{wpinset}/{endfittingset}/{towerspecial}/{ludt}/{maintenancedate}",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody void updateTowerMaintence(@PathVariable("visitid") long visitid,@PathVariable("towerid") long towerid,@PathVariable("nooftappings") BigDecimal nooftappings,@PathVariable("pinpole1") BigDecimal pinpole1,@PathVariable("switchdev1") String switchdev1,
				@PathVariable("pinpole2") BigDecimal pinpole2,@PathVariable("switchdev2") String switchdev2,@PathVariable("pinpole3") BigDecimal pinpole3,
				@PathVariable("switchdev3") String switchdev3,@PathVariable("noofmissingparts") BigDecimal noofmissingparts,@PathVariable("wayleavestatus") String wayleavestatus,@PathVariable("baseconcretestatus") String baseconcretestatus,@PathVariable("anticlimbingstatus") String anticlimbingstatus,@PathVariable("conductorstatus") String conductorstatus,@PathVariable("jumperstatus") String jumperstatus,@PathVariable("earthconductorstatus") String earthconductorstatus,@PathVariable("attentionstatus") String attentionstatus,@PathVariable("fungussetno") BigDecimal fungussetno,
				@PathVariable("wpinset") BigDecimal wpinset,@PathVariable("endfittingset") BigDecimal endfittingset,@PathVariable("towerspecial") String towerspecial,@PathVariable("ludt") Date ludt,@PathVariable("maintenancedate") Date maintenancedate) {
			//provinceDao.updateProvince(province,id,status);
			
			
			MmsTxntowermaintenance obj = new MmsTxntowermaintenance();
			MmsTxntowermaintenancePK objPK = new MmsTxntowermaintenancePK();
			objPK.setVisitid(visitid);
			objPK.setTowerid(towerid);
			      towerTxtMaintenance.findByID(objPK);
			obj.setId(objPK);
			obj.setNooftappings(nooftappings);
			obj.setPinpole1(pinpole1);
			obj.setSwitchdev1(switchdev1);
			obj.setPinpole2(pinpole2);
			obj.setSwitchdev2(switchdev2);
			obj.setPinpole3(pinpole3);
			obj.setSwitchdev3(switchdev3);
			obj.setNoofmissingparts(noofmissingparts);
			obj.setWayleavestatus(wayleavestatus);
			obj.setBaseconcretestatus(baseconcretestatus);
			obj.setAnticlimbingstatus(anticlimbingstatus);
			obj.setConductorstatus(conductorstatus);
			obj.setJumperstatus(jumperstatus);
			obj.setEarthconductorstatus(earthconductorstatus);
			obj.setAttentionstatus(attentionstatus);
			obj.setFungussetno(fungussetno);
			obj.setWpinset(wpinset);
			obj.setEndfittingset(endfittingset);
			obj.setTowerspecial(towerspecial);
			obj.setLudt(ludt);
			obj.setMaintenancedate(maintenancedate);
			

			
			towerTxtMaintenance.update(obj);
			
			
		}*/
	 
		 
	 @SuppressWarnings("deprecation")
	 @RequestMapping(value = "/updateTapping/{visitid}/{towerid}/{nooftappings}/{pinpole1}/{switchdev1}/{pinpole2}/{switchdev2}/{pinpole3}/{switchdev3}/{noofmissingparts}/{nofflashoversets}/{wayleavestatus}/{baseconcretestatus}/{anticlimbingstatus}/{conductorstatus}/{jumperstatus}/{earthconductorstatus}/{attentionstatus}/{fungussetno}/{wpinset}/{endfittingset}/{towerspecial}/{ludt}/{maintenancedate}/{status}/{approvalLevel}/{hotpossible}",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody void updateTapping(@PathVariable("visitid") String visitid,@PathVariable("towerid") String towerid,@PathVariable("nooftappings") String nooftappings,@PathVariable("pinpole1") String pinpole1,@PathVariable("switchdev1") String switchdev1,
	 		@PathVariable("pinpole2") String pinpole2,@PathVariable("switchdev2") String switchdev2,@PathVariable("pinpole3") String pinpole3,
	 		@PathVariable("switchdev3") String switchdev3,@PathVariable("noofmissingparts") String noofmissingparts,@PathVariable("nofflashoversets") String nofflashoversets,@PathVariable("wayleavestatus") String wayleavestatus,@PathVariable("baseconcretestatus") String baseconcretestatus,@PathVariable("anticlimbingstatus") String anticlimbingstatus,@PathVariable("conductorstatus") String conductorstatus,@PathVariable("jumperstatus")
	 		String jumperstatus,@PathVariable("earthconductorstatus") String earthconductorstatus,@PathVariable("attentionstatus") String attentionstatus,@PathVariable("fungussetno") String fungussetno,
	 		@PathVariable("wpinset") String wpinset,@PathVariable("endfittingset") String endfittingset,@PathVariable("towerspecial") String towerspecial,@PathVariable("ludt") String ludt,@PathVariable("maintenancedate") String maintenancedate,@PathVariable("status") String status,@PathVariable("approvalLevel") String approvalLevel,@PathVariable("hotpossible") String hotpossible) {

	 	//provinceDao.updateProvince(province,id,status);
	 	try{
	 	System.out.println("hiiiiii66661");
	 	
	 	//String currentDate = dateNow.format(date);
	 	
	 	
	 	MmsTxntowermaintenance obj = new MmsTxntowermaintenance();
	 	MmsTxntowermaintenancePK objPK = new MmsTxntowermaintenancePK();
	 	if(visitid.trim().equalsIgnoreCase("201801")){
	 		
	 	}
	 	objPK.setVisitid(Long.valueOf(visitid));
	 	objPK.setTowerid (Long.valueOf(towerid));
	 	System.out.println("hiiiiii66662"+objPK);
	 	
	 	towerTxtMaintenance.findByID(objPK);
	 	obj.setId(objPK);
	 	System.out.println("hiiiiii666630"+objPK);
	 	
	 	obj.setNooftappings(new BigDecimal(nooftappings));
	 	/*System.out.println("hiiiiii66663"+nooftappings);
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
	 	obj.setMaintenancedate(dateNow1);
	 	System.out.println("hiiiiii666626");
	 	*/
	 	towerTxtMaintenance.update(obj);
	 	
	 	}catch(Exception e){
	 		
	 	}
	 }

	 
	 
	 @SuppressWarnings("deprecation")
	 @RequestMapping(value = "/updateTowerMaintenceCompletion/{visitid}/{towerid}/{nooftappings}/{pinpole1}/{switchdev1}/{pinpole2}/{switchdev2}/{pinpole3}/{switchdev3}/{noofmissingparts}/{nofflashoversets}/{wayleavestatus}/{baseconcretestatus}/{anticlimbingstatus}/{conductorstatus}/{jumperstatus}/{earthconductorstatus}/{attentionstatus}/{fungussetno}/{wpinset}/{endfittingset}/{towerspecial}/{ludt}/{maintenancedate}/{status}/{approvalLevel}/{hotpossible}",method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody void updateTowerMaintenceCompletion(@PathVariable("visitid") String visitid,@PathVariable("towerid") String towerid,@PathVariable("nooftappings") String nooftappings,@PathVariable("pinpole1") String pinpole1,@PathVariable("switchdev1") String switchdev1,
	 		@PathVariable("pinpole2") String pinpole2,@PathVariable("switchdev2") String switchdev2,@PathVariable("pinpole3") String pinpole3,
	 		@PathVariable("switchdev3") String switchdev3,@PathVariable("noofmissingparts") String noofmissingparts,@PathVariable("nofflashoversets") String nofflashoversets,@PathVariable("wayleavestatus") String wayleavestatus,@PathVariable("baseconcretestatus") String baseconcretestatus,@PathVariable("anticlimbingstatus") String anticlimbingstatus,@PathVariable("conductorstatus") String conductorstatus,@PathVariable("jumperstatus")
	 		String jumperstatus,@PathVariable("earthconductorstatus") String earthconductorstatus,@PathVariable("attentionstatus") String attentionstatus,@PathVariable("fungussetno") String fungussetno,
	 		@PathVariable("wpinset") String wpinset,@PathVariable("endfittingset") String endfittingset,@PathVariable("towerspecial") String towerspecial,@PathVariable("ludt") String ludt,@PathVariable("maintenancedate") String maintenancedate,@PathVariable("status") String status,@PathVariable("approvalLevel") String approvalLevel,@PathVariable("hotpossible") String hotpossible) {

	 	//provinceDao.updateProvince(province,id,status);
	 	try{
	 	System.out.println("hiiiiii66661 updateTowerMaintenceCompletion"  );
	 	
	 	//String currentDate = dateNow.format(date);
	 	
	 	
	 	MmsTxntowermaintenance obj = new MmsTxntowermaintenance();
	 	MmsTxntowermaintenancePK objPK = new MmsTxntowermaintenancePK();
	 	
	 	
	 	MmsTxntowermntcomplesion objComp = new MmsTxntowermntcomplesion();
	 	MmsTxntowermntcomplesionPK objCompPK = new MmsTxntowermntcomplesionPK();
	 	
	 	
	 	
	 	objPK.setVisitid(Long.valueOf(visitid));
	 	objPK.setTowerid(Long.valueOf(towerid));
	 	System.out.println("hiiiiii66662"+objPK + towerTxtMaintenanceCompletion);
	 	
	 	objCompPK.setVisitid(Long.valueOf(visitid));
	 	objCompPK.setTowerid (Long.valueOf(towerid));
	 	
	 	
	 	//towerTxtMaintenance.findByID(objPK);
	 	//obj.setId(objPK);
	 	
	 	objComp.setId(objCompPK);
	 	System.out.println("hiiiiii666630"+objPK);
	 	
	 	objComp.setNooftappings(new BigDecimal(nooftappings));
	 	System.out.println("hiiiiii66663"+nooftappings);
	 	objComp.setPinpole1(new BigDecimal(pinpole1));
	     System.out.println("hiiiiii66664");
	     objComp.setSwitchdev1(switchdev1);
	 	System.out.println("hiiiiii66665");
	 	objComp.setPinpole2(new BigDecimal(pinpole2));
	 	System.out.println("hiiiiii66666");
	 	objComp.setSwitchdev2(switchdev2);
	 	System.out.println("hiiiiii66667");
	 	objComp.setPinpole3(new BigDecimal(pinpole3));
	 	System.out.println("hiiiiii66668");
	 	objComp.setSwitchdev3(switchdev3);
	 	System.out.println("hiiiiii66669");
	 	objComp.setNoofmissingparts(new BigDecimal(noofmissingparts));
	 	System.out.println("hiiiiii666610");
	 	objComp.setNofflashoversets(new BigDecimal(nofflashoversets));
	 	System.out.println("hiiiiii666611");
	 	objComp.setWayleavestatus(wayleavestatus);
	 	System.out.println("hiiiiii666612");
	 	objComp.setBaseconcretestatus(baseconcretestatus);
	 	System.out.println("hiiiiii666613");
	 	objComp.setAnticlimbingstatus(anticlimbingstatus);
	 	System.out.println("hiiiiii666614");
	 	objComp.setConductorstatus(conductorstatus);
	 	System.out.println("hiiiiii666615");
	 	objComp.setJumperstatus(jumperstatus);
	 	System.out.println("hiiiiii666616");
	 	objComp.setEarthconductorstatus(earthconductorstatus);
	 	System.out.println("hiiiiii666617");
	 	objComp.setAttentionstatus(attentionstatus);
	 	System.out.println("hiiiiii666618");
	 	objComp.setFungussetno(new BigDecimal(fungussetno));
	 	System.out.println("hiiiiii666619");
	 	objComp.setWpinset(new BigDecimal(wpinset));
	 	System.out.println("hiiiiii666620");
	 	objComp.setEndfittingset(new BigDecimal(endfittingset));
	 	System.out.println("hiiiiii666621");
	 	objComp.setTowerspecial(towerspecial);
	 	objComp.setHotpossible(new BigDecimal(hotpossible));
	 	System.out.println("hiiiiii666622");
	 	//obj.setLudt(new Date(ludt));
	 	Date dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(ludt);
	 	
	 	//obj.setMaintenancedate(new Date(maintenancedate));
	 	Date dateNow1 = new SimpleDateFormat("yyyy-MM-dd").parse(maintenancedate);
	 	System.out.println("hiiiiii666623status : "+ status);
	 	objComp.setStatus(new BigDecimal(status));
	 	System.out.println("hiiiiii666623");
	 	objComp.setApprovalLevel(approvalLevel);
	 	System.out.println("hiiiiii666624");
	 	objComp.setLudt(dateNow);
	 	System.out.println("hiiiiii666625");
	 	objComp.setMaintenancedate(dateNow1);
	 	System.out.println("hiiiiii666626");
	 	
	 	
	 	MmsTxntowermntcomplesion objCompExiting = new MmsTxntowermntcomplesion();
	 	
	 	objCompExiting = towerTxtMaintenanceCompletion.findByID(objCompPK);
	 	
	 	
	 	if(objCompExiting == null){
	 		System.out.println("towerTxtMaintenanceCompletion addhiiiiii666626");
		 	
	 		towerTxtMaintenanceCompletion.addTowerMaintananceData(objComp);
		 	
	 	}else{
	 		
	 		System.out.println("towerTxtMaintenanceCompletionupdate addhiiiiii666626");
		 	
	 		towerTxtMaintenanceCompletion.update(objComp);
		 	
	 	}
	 	
	 	
	 	}catch(Exception e){
	 		System.out.println(e.getMessage());
	 	}
	 }

	 
	 
	 
	 
	 
	 
	 
	 
/*	 @RequestMapping(value = "/viewTowerLineAE", method = RequestMethod.GET)
		public ModelAndView viewTowerLineAE(HttpServletRequest request) {
			// MmsAddline line = new MmsAddline();
			Map<String, String> lineList = new LinkedHashMap<String, String>();

			Map<String, String> areaList = new LinkedHashMap<String, String>();
//			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
			Map<String, String> lineTypeList = new LinkedHashMap<String, String>();
			Map<String, String> conTypeListforPE = new LinkedHashMap<String, String>();

			String userName = (String) request.getSession().getAttribute(
					"loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			String province = deptDao.getDD(deptId);
			String distDiv = glcompmDao.getDistDivision(province);
			PivModel model = new PivModel();
			List<Glcompm> line = glcompmDao.getProvinces(distDiv);
			// List<Gldeptm> deptTm = gldeptDao.getArea(province);
			List<MmsAddsupporttype> supType = supTypeDao.findAll();
			// List<MmsAddline> lineObj = addLine.findAll();
			List<String> provinces = new ArrayList<String>();
			List<MmsAddlinetype> linetypes = mmsLineTypeDao.findActiveTypes();

			int loopTye = linetypes.size() - 1;
			for (int i = 0; i <= loopTye; i++) {
				System.out.println(i);
				MmsAddlinetype ojb = linetypes.get(i);
				lineTypeList.put(ojb.getId(), ojb.getLineType());

			}

			int loop = line.size() - 1;
			for (int i = 0; i <= loop; i++) {
				System.out.println(i);
				Glcompm ojb = line.get(i);

				System.out.println(ojb.getCompNm());
				provinces.add(ojb.getCompNm());
				provinceList.put(ojb.getCompId(), ojb.getCompNm());

			}
	
			
			int supLoop = supType.size() - 1;
			for (int i = 0; i <= supLoop; i++) {
				System.out.println(i);
				MmsAddsupporttype ojb = supType.get(i);
				supportTypeList.put(ojb.getId(), ojb.getSupportType());

			}
			List<MmsAddconductortype> conListPE = conTpePeDao.findAll();
			int depLoop = conListPE.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				System.out.println(i);
				MmsAddconductortype ojb = (MmsAddconductortype) conListPE.get(i);
				conTypeListforPE.put(ojb.getId(), ojb.getType());
			}

			areaList.put(deptId, gldeptDao.getName(deptId));
			// int lineLoop = lineObj.size()-1;
			// for(int i=0;i<=lineLoop;i++){
			// System.out.println(i);
			// MmsAddline ojb = lineObj.get(i);
			// lineList.put(ojb.getCode(), ojb.getLineName());
			// }
			model.setSupTypeList(supportTypeList);
//			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			model.setLineList(lineList);
			model.setLineTypeList(lineTypeList);
			model.setConTypeListforPE(conTypeListforPE);
			return new ModelAndView("ViewTowerLinesAE", "model", model);

		}*/
	 
	 

		// edit anushka 2019-01-16
		// ---------------------------------------------------------------------------------------------------
		@RequestMapping(value = "/goToEstimate/{str}", method = RequestMethod.GET, produces = "application/json")
		public ModelAndView goToEstimate(HttpServletRequest request,
				@ModelAttribute("pivModel") PivModel pivModel,
				@PathVariable("str") String lineIds) {

			List<String> lines = Arrays.asList(lineIds.split("\\s*,\\s*"));
			System.out.println(lines);

			String province = "CENTRAL PROVINCE";

			double totalLength = 0;
			double totalTowers = 0;
			String area = "";

			int idloop = lines.size();
			for (int i = 0; i < idloop; i++) {
				MmsAddline lineObj = lineDao.findById(Long.valueOf(lines.get(i)));
				totalLength = totalLength + lineObj.getLength().doubleValue();
				totalTowers = totalTowers + lineObj.getLength().doubleValue();
				area = lineObj.getArea();
			}

			PivModel model = new PivModel();

			MmsInspection obj = new MmsInspection();
			obj.setTotalLineLength(new BigDecimal(totalLength));
			obj.setTotalNoTowers(new BigDecimal(totalTowers));
			double no_tower = totalTowers;
			double no_days_for_the_ins = no_tower / 27;
			// Round.
			double labou_hours_for_the_estimate = 9 * no_days_for_the_ins * 9;
			double labou_value_for_the_estimate = 9 * no_days_for_the_ins * 9 * Util.LABOUR;
			double subsistance = labou_hours_for_the_estimate * 400 / 9 * (30 / 22);
			double hotlineallowance = 16000 * no_days_for_the_ins;
			double temparary_site_cost = no_days_for_the_ins * (1 / 22) * 30000;
			double transportManual = 0.0;
			System.out.println(province);
			if (province.equalsIgnoreCase("CENTRAL PROVINCE")) {
				transportManual = no_tower * 8;
			} else if (province.equalsIgnoreCase("WESTERN PROVINCE NORTH")) {
				transportManual = no_tower * 4;
			} else if (province.equalsIgnoreCase("EASTERN PROVINCE")) {
				transportManual = no_tower * 8;
			} else {
				transportManual = 0.0;
			}
			double transport_cost = (transportManual * 45) + (transportManual * 55);

			System.out.println("no_days_for_the_ins :" + no_days_for_the_ins);

			System.out.println("no_days_for_the_ins :" + no_days_for_the_ins);
			obj.setTransport(new BigDecimal("0"));
			obj.setTransportManual(new BigDecimal(transportManual));
			obj.setNoDaysForTheIns(new BigDecimal(no_days_for_the_ins));
			obj.setLabourHoursForEst(new BigDecimal(labou_hours_for_the_estimate));
			obj.setLabourValueForEst(new BigDecimal(labou_value_for_the_estimate));
			obj.setSubsistance(new BigDecimal(subsistance));
			obj.setHotLineAllowances(new BigDecimal(hotlineallowance));
			if (temparary_site_cost <= 30000) {
				obj.setTemporarySiteCost(new BigDecimal(30000));

			} else {
				obj.setTemporarySiteCost(new BigDecimal(temparary_site_cost));

			}
			double total = labou_value_for_the_estimate + subsistance
					+ hotlineallowance + temparary_site_cost + transport_cost;
			obj.setTatalCost(new BigDecimal(total));
			model.setInspection(obj);
			Map<String, String> sauserList = new LinkedHashMap<String, String>();
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			Map<String, String> saList = new LinkedHashMap<String, String>();
			Map<String, String> appList = new LinkedHashMap<String, String>();

			String userName = (String) request.getSession().getAttribute(
					"loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");

			String provinceDD = deptDao.getDD(deptId);
			String distDiv = glcompmDao.getDistDivision(provinceDD);
			List<Glcompm> line = glcompmDao.getProvinces(distDiv);
			List<Gldeptm> deptTm = gldeptDao.getArea(province);
			List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
			List<Applicant> appliList = applicantDao
					.getAllApplicantBydeptId(deptId);

			int loopApp = appliList.size() - 1;
			for (int i = 0; i <= loopApp; i++) {
				System.out.println(i);
				Applicant ojb = appliList.get(i);
				System.out.println(ojb.getIdNo());
				appList.put(ojb.getIdNo(), ojb.getFullName());

			}

			int loopSa = saUserList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
				System.out.println(i);
				Sauserm ojb = saUserList.get(i);
				System.out.println(ojb.getUserId());
				saList.put(ojb.getUserId(), ojb.getUserNm());

			}

			int loop = line.size() - 1;
			for (int i = 0; i <= loop; i++) {
				System.out.println(i);
				Glcompm ojb = line.get(i);
				System.out.println(ojb.getCompNm());
				provinceList.put(ojb.getCompId(), ojb.getCompNm());

			}

			int depLoop = deptTm.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				System.out.println(i);
				Gldeptm ojb = (Gldeptm) deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
			}

			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			model.setSaList(saList);
			model.setAppList(appList);
			ModelAndView mm = new ModelAndView("ViewInsEstDetailNew", "pivModel",model);
			// mm.addObject("lineLength", lineLength);
			// mm.addObject("Total Number of Towers in Area", nooftower);
			// mm.addObject("nooftower", nooftower);
			mm.addObject("area", area);
			// mm.addObject("no_days_for_the_ins", no_days_for_the_ins);
			// mm.addObject("labour_hours_for_the_ins",
			// labou_hours_for_the_estimate);
			// mm.addObject("labour_value_for_the_ins",
			// labou_value_for_the_estimate);
			// mm.addObject("subsistance", subsistance);
			// mm.addObject("hotlineallowance", hotlineallowance);
			// mm.addObject("temparary_site_cost", temparary_site_cost);

			return mm;
		}
		
		@RequestMapping(value = "/goToViewInsEstimateSHOT", method = RequestMethod.POST)
		public ModelAndView goToViewInsEstimateSHOT(HttpServletRequest request,
				@ModelAttribute("model") PivModel model) {
			/*Map<String, String> lineList = new LinkedHashMap<String, String>();
			String stringOflineIds = "";
			String deptId = (String) request.getSession().getAttribute("deptId");
			String westimateNo = "";
			String area = model.getGldeptobj().getDeptId();
			String province = model.getGlcompmobj().getCompId();
			String canGO = "3";
			List<Long> lines = model.getSelectedLines();
			System.out.println("line"+lines);
			System.out.println("province1 " + province);
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String allocated_To = model.getSauserm().getUserId();
			
			MmsInspection obj = new MmsInspection();
			
			obj.setTotalLineLength(new BigDecimal(0));
			obj.setTotalNoTowers(new BigDecimal(0));
								obj.setTransport(new BigDecimal(0));
			obj.setTransportManual(new BigDecimal(0));
			obj.setNoDaysForTheIns(new BigDecimal(0));
			obj.setLabourHoursForEst(new BigDecimal(
					0));
			obj.setLabourValueForEst(new BigDecimal(
					0));
			obj.setSubsistance(new BigDecimal(0));
			obj.setHotLineAllowances(new BigDecimal(0));
			obj.setTemporarySiteCost(new BigDecimal(0));
			double total = 0;
			obj.setTatalCost(new BigDecimal(total));
			model.setInspection(obj);
			model.setInspection(obj);
			model = loadProLineES(request,model);
			Application application = createApplicationObject(deptId,userName,model);
			westimateNo = appDao.saveSPS(deptId,userName,allocated_To,application, model);
			model.setMode(westimateNo);
			
					String newCycle = 
			ModelAndView mo = new ModelAndView("goToViewInsEstimateHOT", "model",model);
			mo.addObject("canGO", canGO);
			mo.addObject("stringOflineIds", stringOflineIds);
			mo.addObject("area", area);
			return mo;*/
			model.setEstimateType("HOT");
			Map<String, String> lineList = new LinkedHashMap<String, String>();
			String stringOflineIds = "";
			String deptId = (String) request.getSession().getAttribute("deptId");
			String newCycle = model.getCycleObj().getId().getCycleId();;
			String westimateNo = "";
			String area = model.getGldeptobj().getDeptId();
			String areaName = gldeptDao.getName(area.trim());
			
			String province = model.getGlcompmobj().getCompId();
			String canGO = "2";
			List<Long> lines = model.getSelectedLines();
			System.out.println("line"+lines);
			System.out.println("province1 " + province);
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String allocated_To = model.getSauserm().getUserId();
			
			/*if(model.getMode() == "3"){
				System.out.println("mmmmmm  " + model.getInspection().getTatalCost().doubleValue());
				if(model.getInspection().getTatalCost().doubleValue() != 0){
					Application application = createApplicationObject(deptId,userName,model);
					westimateNo = appDao.saveSPS(deptId,userName,allocated_To,application, model);
					model.setMode(westimateNo);
				}
			}
			*/
			double totalDefectiveInsulatorSets = 0;
			double totalFlashInsulatorSets = 0;
			double totalEndFitting = 0;
			if (lines != null) {
				System.out.println("province " + province);
				double totalLength = 0;
				double totalTowers = 0;
				//String area = "";
                String lineCode="";
                MmsInspection obj = new MmsInspection();

				int idloop = lines.size();
				model.setLineName(lines.toString());
				for (int i = 0; i < idloop; i++) {
					MmsAddline lineObj = lineDao.findById(lines.get(i));
					totalLength = totalLength + lineObj.getLength().doubleValue();
					totalTowers = totalTowers + lineObj.getNooftowers().doubleValue();
					area = lineObj.getArea();
					
					lineCode =  lineObj.getCode() +"," + lineCode;
					System.out.println("lineCode " + lineCode);
					obj.setDescription(lineCode);
					
					
					newCycle = model.getCycleObj().getId().getCycleId();
					model.setCycle(newCycle);
					
					System.out.println("model.getCycle() " + newCycle);
					double total = lineDao.getTotalofFlashSet(area, String.valueOf(lines.get(i)),newCycle);
					//System.out.println("totalDefectiveInsulatorSets " + area + "/" + String.valueOf(lines.get(i)));
					//System.out.println("totalDefectiveInsulatorSets " + i + "/" + total);
					totalDefectiveInsulatorSets = total + totalDefectiveInsulatorSets;
					//System.out.println("totalDefectiveInsulatorSets " + i + "/" + totalDefectiveInsulatorSets);
					double totalFset = lineDao.getTotalofOnlyFlashSet(area, String.valueOf(lines.get(i)),newCycle);
					//System.out.println("totalFset " +  i + totalFset);
					
					
					totalFlashInsulatorSets = totalFset + totalFlashInsulatorSets;
					double endFitting = lineDao.getTotalEndFitting(area, String.valueOf(lines.get(i)),newCycle);
					//System.out.println("endFitting " +  i +endFitting);
					
					totalEndFitting = endFitting + totalEndFitting;
				}
				
				System.out.println("totalFsetrrr " +  totalFlashInsulatorSets);
				
				model.setCycle(lineCode);
				request.getSession().setAttribute("selectedLine", lineCode);
                
				
				

					obj.setTotalLineLength(new BigDecimal(totalLength));
					obj.setTotalNoTowers(new BigDecimal(totalTowers));
					double no_tower = Double.valueOf(totalTowers).doubleValue();
					double mat_c0138 = 0;
					double mat_c0180 = 0;
					System.out.println("totalDefectiveInsulatorSets " + totalDefectiveInsulatorSets);
					System.out.println("totalFlashInsulatorSets " + totalFlashInsulatorSets);
					System.out.println("totalEndFitting " + totalEndFitting);
					
					double transportManual = 0.0;
					double p =0.0;
					double q =0.0;
					double r =0.0;
					double s =0.0;
					System.out.println(province);
					province = province.trim();
					if (province.equalsIgnoreCase("CP")) {
						transportManual = no_tower * 8;
						p = 162;
						q = 10;
						r = 350; 
						s = 0;
						System.out.println(no_tower +province + transportManual );
					} else if (province.equalsIgnoreCase("CP2")) {
						transportManual = no_tower * 8;
						p = 162;
						q = 10;
						r = 350; 
						s = 0;
						System.out.println(no_tower +province + transportManual );
					}else if (province.equalsIgnoreCase("WPN")) {
						transportManual = no_tower * 4;
						p = 162;
						q = 6;
						r = 100;
						s = 0;
						System.out.println(no_tower +province + transportManual );
					} else if (province.equalsIgnoreCase("EP")) {
						p = 243;
						q =10;
						r = 700;
						s = 500;
						transportManual = (no_tower * 8) + 700;
						System.out.println(no_tower +province + transportManual );
					} else {
						transportManual = 0.0;
						p=0;
						q=0;
						r=0;
						s = 0;
					}
					double labour_hours = 0;
					double labou_hours_for_the_estimate = 0;
					double labou_value_for_the_estimate = 0;
					double subsistance = 0;
					double hotlineallowance = 0;
					double temparary_site_cost = 0;
					double transport_manual_hot = 0;
					double transport_cost = 0;
					if(totalDefectiveInsulatorSets != 0){
						labour_hours = (totalDefectiveInsulatorSets * 8) + p;
						labou_hours_for_the_estimate = labour_hours;
						labou_value_for_the_estimate = labour_hours * Util.LABOUR;
						//400/9 30/22
						
						double n = labour_hours * 800; 
						subsistance = (n/9) * 30/22;
						hotlineallowance = 40000 * (labour_hours/81);
						temparary_site_cost = ((labour_hours/81) * 30000) /22;
						
						if (temparary_site_cost <= 30000) {
							temparary_site_cost = 30000;
							//obj.setTemporarySiteCost(new BigDecimal(30000));
						}
						
						
						System.out.println("temparary_site_cost "+ temparary_site_cost); 
						//double m = labour_hours/81;
						double m = totalDefectiveInsulatorSets;
						transport_manual_hot = (m * q) + r + s;
						System.out.println("transport_manual_hot "+ transport_manual_hot);
						transport_cost = (transport_manual_hot * 100);
						System.out.println("transport_cost "+ transport_cost);
						
						mat_c0180 = totalFlashInsulatorSets * Util.CO180 * 3;
						mat_c0138 = totalEndFitting * Util.CO138;
						System.out.println("mat_c0138 "+ mat_c0138);
						
						
					}
					obj.setMatC0138(new BigDecimal(mat_c0138));
					obj.setMatC0180(new BigDecimal(mat_c0180));
					obj.setTransport(new BigDecimal(transport_cost));
					obj.setTransportManual(new BigDecimal(transportManual));
					obj.setNoDaysForTheIns(new BigDecimal(0));
					obj.setLabourHoursForEst(new BigDecimal(
							labou_hours_for_the_estimate));
					obj.setLabourValueForEst(new BigDecimal(
							labou_value_for_the_estimate));
					obj.setSubsistance(new BigDecimal(subsistance));
					obj.setHotLineAllowances(new BigDecimal(hotlineallowance));
					obj.setTemporarySiteCost(new BigDecimal(temparary_site_cost));
					System.out.println("newCycle "+ newCycle); 
					
					obj.setCycle(model.getCycleObj().getId().getCycleId());
					System.out.println("lines "+ lines.toString()); 
					
					obj.setLine(lines.toString());
					//model.getInspection().setCycle(newCycle);
					//model.getInspection().setLine(lines.toString());

					/*if (temparary_site_cost <= 30000) {
						temparary_site_cost = 30000;
						obj.setTemporarySiteCost(new BigDecimal(30000));

					} else {
						obj.setTemporarySiteCost(new BigDecimal(temparary_site_cost));

					}
*/
					
					obj.setMatC0138(new BigDecimal(mat_c0138));
					/*if (temparary_site_cost <= 30000) {
						obj.setTemporarySiteCost(new BigDecimal(30000));

					} else {
						obj.setTemporarySiteCost(new BigDecimal(temparary_site_cost));

					}*/
					double total = labou_value_for_the_estimate + subsistance
							+ hotlineallowance + temparary_site_cost + transport_cost + mat_c0138 + mat_c0180;
					obj.setTatalCost(new BigDecimal(total));
					model.setInspection(obj);
					Map<String, String> sauserList = new LinkedHashMap<String, String>();
					model.setInspection(obj);
					System.out.println("allocated_To "+ allocated_To); 
					System.out.println("obj.getTatalCost().doubleValue() "+ obj.getTatalCost().doubleValue()); 
					List<MmsAddline> liness = addLine.findLineByArea(area);
					model.setLineListEdit(liness);
					int lineSize = liness.size() - 1;
					List<Long> lineListnew = new ArrayList<Long>(lineSize);
					for (int i = 0; i <= lineSize; i++) {
						MmsAddline obj1 = liness.get(i);
						lineListnew.add(obj1.getId());
						if (i != 0) { 
							stringOflineIds = stringOflineIds + "," + Long.toString(obj1.getId()); 
						} else { 
							stringOflineIds = Long.toString(obj1.getId()); 
						}
						 
					}
					System.out.println("-------------------> stringOflineIds: "+ stringOflineIds);
					model.setListOfLines(lineListnew);
					model = loadProLineES(request,model);
					canGO = "3";
					//model.setMode(canGO);
					model.setSelectedLines(null);
				
				
			}else{
				List<MmsAddline> liness = addLine.findLineByArea(area);
				model.setLineListEdit(liness);
				int lineSize = liness.size() - 1;
				List<Long> lineListnew = new ArrayList<Long>(lineSize);
				for (int i = 0; i <= lineSize; i++) {
					MmsAddline obj = liness.get(i);
					lineListnew.add(obj.getId());
					if (i != 0) { stringOflineIds = stringOflineIds + "," +
					  Long.toString(obj.getId()); } 
					else { stringOflineIds =
					  Long.toString(obj.getId()); }
					 
				}
				System.out.println("else -------------------> stringOflineIds: "+ stringOflineIds);
				model.setListOfLines(lineListnew);
				model = loadProLineES(request,model);
				if( model.getInspection() != null){
					String line = request.getSession().getAttribute("selectedLine").toString();
					//model.getInspection().setDescription(areaName.trim() + " for Lines : " +line);
					
					if(deptId.equals("596.00")){
						model.getInspection().setDescription(areaName.trim().toLowerCase() + " for Lines : " +line);
						
					}else{
					model.getInspection().setDescription(areaName.trim().toLowerCase());
					}
					
					
					System.out.println("model.getInspection().getDescription()"+ model.getInspection().getDescription());
					
				System.out.println("else model.getInspection().getTatalCost().doubleValue()"+ model.getInspection().getTatalCost().doubleValue());
				if(model.getInspection().getTatalCost().doubleValue() != 0){
					Application application = createApplicationObject(deptId,userName,model);
					System.out.println("els : " + model.getInspection().getMatC0138());
					westimateNo = appDao.saveSPS(deptId,userName,allocated_To,application, model);
					
					
					String pre_approval_id = "";
		    		pre_approval_id = deptId+"-HOTMNT-21-";
		        	String nextNumver = insDao.getNextINsEstimate(pre_approval_id);
		    		
					
					model.getInspection().setInspectionId(pre_approval_id+nextNumver);
					model.getInspection().setPhmBranch(deptId);
					model.getInspection().setArea(area);
					model.getInspection().setWestimateNo(westimateNo);
					model.getInspection().setInspectionBy(allocated_To);
					model.getInspection().setStatus(new BigDecimal("75"));
					
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date newDate = new Date();
		    		
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

		    		Date date2 = null;
					try {
						String dateString1 = format.format(newDate);
						date2 = format.parse (dateString1);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}    

		    		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");

		    		String timeString = format2.format(newDate);
		    		System.out.println("finish 3 " + newCycle);
					
		    		model.getInspection().setInsCreatedDate(date2);
		    		//model.getInspection().setCompletedTime(timeString);
		    		model.getInspection().setType("HOTMNT");
		    		model.getInspection().setCycle(newCycle);
		    		//model.getInspection().setLine(model.getLineName());
		    		System.out.println("finish 4 " );
					
					try {
						insDao.add(model.getInspection());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


					
					
					
					model.setMode(westimateNo);
					canGO = "1";
				}
				}
			
			}
			
			
			
			ModelAndView mo = new ModelAndView("goToViewInsEstimateHOT", "model",model);
			mo.addObject("canGO", canGO);
			mo.addObject("stringOflineIds", stringOflineIds);
			mo.addObject("area", area);
			mo.addObject("totalDefTotal", totalDefectiveInsulatorSets);
			mo.addObject("totalIndTotal", totalFlashInsulatorSets);
			
			

			return mo;
			
			
		}
		
		
		@RequestMapping(value = "/goToViewInsEstimateSCOLD", method = RequestMethod.POST)
		public ModelAndView goToViewInsEstimateSCOLD(HttpServletRequest request,
				@ModelAttribute("model") PivModel model) {
			/*Map<String, String> lineList = new LinkedHashMap<String, String>();
			String stringOflineIds = "";
			String deptId = (String) request.getSession().getAttribute("deptId");
			String westimateNo = "";
			String area = model.getGldeptobj().getDeptId();
			String province = model.getGlcompmobj().getCompId();
			String canGO = "3";
			List<Long> lines = model.getSelectedLines();
			System.out.println("line"+lines);
			System.out.println("province1 " + province);
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String allocated_To = model.getSauserm().getUserId();
			
			MmsInspection obj = new MmsInspection();
			
			obj.setTotalLineLength(new BigDecimal(0));
			obj.setTotalNoTowers(new BigDecimal(0));
								obj.setTransport(new BigDecimal(0));
			obj.setTransportManual(new BigDecimal(0));
			obj.setNoDaysForTheIns(new BigDecimal(0));
			obj.setLabourHoursForEst(new BigDecimal(
					0));
			obj.setLabourValueForEst(new BigDecimal(
					0));
			obj.setSubsistance(new BigDecimal(0));
			obj.setHotLineAllowances(new BigDecimal(0));
			obj.setTemporarySiteCost(new BigDecimal(0));
			double total = 0;
			obj.setTatalCost(new BigDecimal(total));
			model.setInspection(obj);
			model.setInspection(obj);
			model = loadProLineES(request,model);
			Application application = createApplicationObject(deptId,userName,model);
			westimateNo = appDao.saveSPS(deptId,userName,allocated_To,application, model);
			model.setMode(westimateNo);
			
					
			ModelAndView mo = new ModelAndView("goToViewInsEstimateHOT", "model",model);
			mo.addObject("canGO", canGO);
			mo.addObject("stringOflineIds", stringOflineIds);
			mo.addObject("area", area);
			return mo;
		*/	model.setEstimateType("COLD");
			Map<String, String> lineList = new LinkedHashMap<String, String>();
			String stringOflineIds = "";
			String deptId = (String) request.getSession().getAttribute("deptId");
		
			String westimateNo = "";
			String area = model.getGldeptobj().getDeptId();
			String areaName = gldeptDao.getName(area.trim());

			String province = model.getGlcompmobj().getCompId();
			String canGO = "2";
			List<Long> lines = model.getSelectedLines();
			System.out.println("line"+lines);
			System.out.println("province1 " + province);
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String allocated_To = model.getSauserm().getUserId();
			
			if(model.getMode() == "3"){
				System.out.println("mmmmmm  " + model.getInspection().getTatalCost().doubleValue());
								if(model.getInspection().getTatalCost().doubleValue() != 0){
					Application application = createApplicationObject(deptId,userName,model);
					westimateNo = appDao.saveSPS(deptId,userName,allocated_To,application, model);
					model.setMode(westimateNo);
				}
			}
		
			double totalDefectiveInsulatorSets = 0;
			double totalFlashInsulatorSets = 0;
			double totalFlashOver = 0;
			double totalFungus = 0;
			double totalWpin = 0;
			double totalEndFitting = 0;
			
			
			double totalWpinRacoon = 0;
			double totalWpinLynx = 0;
			
			
			double totalEndFittingRaccon = 0;
			double totalEndFittingLynx = 0;
			
			
			double totalFlashOverTTWT = 0;
			double totalFungusTTWT = 0;
			double totalWpinTTWT = 0;
			
			
			
			double totalEndFittingTTWT = 0;
			double totalCountCL = 0;
			double totalCountTTWT = 0;
			
			double totalEndFittingTTWTRaccon = 0;
			double totalEndFittingTTWTLynx = 0;
			
			
			double totalFlashOverTTWTRacoon = 0;
			double totalFlashOverTTWTLynx = 0;
			
			double totalWpinTTWTRacoon = 0;
			double totalWpinTTWTLynx = 0;
			
			
			double totalSusInsSetColdFlashOver = 0;
			double totalSusInsSetColdFungus = 0;
			double totalSusInsSetColdWpin = 0;
			double totalSusInsSetColdEndFitting=0;
			
			double totalTensionInsSetColdFlashOver = 0;
			double totalTensionInsSetColdFungus = 0;
			double totalTensionInsSetColdWpin = 0;
			double totalTensionInsSetColdEndFitting=0;
			
			
			double Q1= 0;
			double Q2= 0;
			double Q3= 0;
			double Q4= 0;
			double Q5= 0;
			double Q6= 0;
			
			double totalCLETower=0;
			String newCycle =model.getCycleObj().getId().getCycleId();
			if (lines != null) {
				System.out.println("province " + province);
				double totalLength = 0;
				double totalTowers = 0;
				//String area = "";
				String lineCode="";
				MmsInspection obj = new MmsInspection();

				int idloop = lines.size();
				
				for (int i = 0; i < idloop; i++) {
					MmsAddline lineObj = lineDao.findById(lines.get(i));
					totalLength = totalLength + lineObj.getLength().doubleValue();
					totalTowers = totalTowers + lineObj.getNooftowers().doubleValue();
					area = lineObj.getArea();
					newCycle = model.getCycleObj().getId().getCycleId();
					
					lineCode =  lineObj.getCode() +"," + lineCode;
					System.out.println("lineCode " + lineCode);
					obj.setDescription(lineCode);
					
					
					
					//System.out.println("model.getCycle() " + model.getCycle());
					Object[] defInsCold = lineDao.getTotalofDefectiveInsultorSetForColdLineEst(area, String.valueOf(lines.get(i)),newCycle);
					if(defInsCold[0] != null){
						double flashOver = Double.valueOf(defInsCold[0].toString()).doubleValue();
						System.out.println("ColdTotalflashOver" +flashOver);
						totalFlashOver = totalFlashOver + flashOver;
						
						
						/*if(lineObj.getConductorType() == 6){
							Q4 = Q4 + flashOver;
						}else{
							Q4 = Q4 + flashOver;
						}
						*/
						
					}
					if(defInsCold[1] != null){
						double fungusSet = Double.valueOf(defInsCold[1].toString()).doubleValue();
						System.out.println("ColdTotalfungusSet" +fungusSet);
						totalFungus = totalFungus + fungusSet;
					}
					if(defInsCold[2] != null){
						double wpin = Double.valueOf(defInsCold[2].toString()).doubleValue();
						System.out.println("ColdTotalwpin" +wpin);
						totalWpin = totalWpin + wpin;
						/*if(lineObj.getConductorType() == 6){
							Q4 = Q4 + wpin;
						}else{
							Q4 = Q4 + wpin;
						}
						*/
						
						
					}
					if(defInsCold[3] != null){
						double endFitting = Double.valueOf(defInsCold[3].toString()).doubleValue();
						System.out.println("ColdTotalendFitting" +endFitting);
						totalEndFitting = totalEndFitting + endFitting;
						System.out.println("lineObj.getConductorType() " +lineObj.getConductorType());
						
						if(lineObj.getConductorType() == 6){
							//totalEndFittingRaccon = totalEndFittingRaccon + (endFitting * Util.CO180 * 3) + Util.W1246;
							//totalEndFittingLynx = totalEndFittingLynx + endFitting;
							Q1 = Q1 + endFitting; 
						}
						else{
							//totalEndFittingLynx = totalEndFittingLynx + (endFitting * Util.CO138);
							//totalEndFittingRaccon = totalEndFittingRaccon + endFitting;
							Q4 = Q4 + endFitting;
							Q6 = Q6 + endFitting;
						}
					}
					
					
					
					Object[] defInsColdHot = lineDao.getTotalofDefectiveInsultorSetForColdLineEstHotPossible(area, String.valueOf(lines.get(i)),newCycle);
					if(defInsColdHot[0] != null){
						double flashOver = Double.valueOf(defInsColdHot[0].toString()).doubleValue();
						System.out.println("ColdTotalflashOver" +flashOver);
						totalFlashOver = totalFlashOver + flashOver;
						
						
						/*if(lineObj.getConductorType() == 6){
							Q4 = Q4 + flashOver;
						}else{
							Q4 = Q4 + flashOver;
						}
						*/
						
					}
					if(defInsColdHot[1] != null){
						double fungusSet = Double.valueOf(defInsColdHot[1].toString()).doubleValue();
						System.out.println("ColdTotalfungusSet" +fungusSet);
						totalFungus = totalFungus + fungusSet;
					}
					if(defInsColdHot[2] != null){
						double wpin = Double.valueOf(defInsColdHot[2].toString()).doubleValue();
						System.out.println("ColdTotalwpin" +wpin);
						totalWpin = totalWpin + wpin;
						/*if(lineObj.getConductorType() == 6){
							Q4 = Q4 + wpin;
						}else{
							Q4 = Q4 + wpin;
						}
						*/
						
						
					}
					if(defInsColdHot[3] != null){
						double endFitting = Double.valueOf(defInsColdHot[3].toString()).doubleValue();
						System.out.println("ColdTotalendFittingHot" +endFitting);
						totalEndFitting = totalEndFitting + endFitting;
						System.out.println("lineObj.getConductorType() " +lineObj.getConductorType());
						
						if(lineObj.getConductorType() == 6){
							//totalEndFittingRaccon = totalEndFittingRaccon + (endFitting * Util.CO180 * 3) + Util.W1246;
							//totalEndFittingLynx = totalEndFittingLynx + endFitting;
							Q1 = Q1 + endFitting; 
						}
						else{
							//totalEndFittingLynx = totalEndFittingLynx + (endFitting * Util.CO138);
							//totalEndFittingRaccon = totalEndFittingRaccon + endFitting;
							System.out.println("ColdTotalendFittingHotRaccon/" + i + " /"+endFitting);
							
							Q4 = Q4 + endFitting;
							Q6 = Q6 + endFitting;
						}
					}
					
					
					
					Object[] defInsTTWT = lineDao.getTotalofDefectiveInsultorSetForTTWTEst(area, String.valueOf(lines.get(i)),newCycle);
					
					if(defInsTTWT[0] != null){
						double flashOver = Double.valueOf(defInsTTWT[0].toString()).doubleValue();
						System.out.println("TTWTTotalflashOver" +flashOver);
						totalFlashOverTTWT = totalFlashOverTTWT + flashOver;
						
						if(lineObj.getConductorType() == 6){
							//totalFlashOverTTWTRacoon = totalEndFittingRaccon + (flashOver * Util.CO180 * 3) + Util.W1246;
							totalFlashOverTTWTRacoon = totalEndFittingRaccon + flashOver;
							Q5 = Q5 + flashOver;
						}
						else{
							//totalFlashOverTTWTLynx = totalEndFittingLynx + (endFitting * Util.CO138);
							totalFlashOverTTWTLynx = totalEndFittingLynx + flashOver;
							Q4 = Q4 + flashOver;
						}
						
						
						
					}
					if(defInsTTWT[1] != null){
						double fungusSet = Double.valueOf(defInsTTWT[1].toString()).doubleValue();
						System.out.println("TTWTTotalfungusSet" +fungusSet);
						totalFungusTTWT = totalFungusTTWT + fungusSet;
					}
					if(defInsTTWT[2] != null){
						double wpin = Double.valueOf(defInsTTWT[2].toString()).doubleValue();
						System.out.println("TTWTTotalwpin" +wpin);
						totalWpinTTWT = totalWpinTTWT + wpin;
						
						if(lineObj.getConductorType() == 6){
							//totalFlashOverTTWTRacoon = totalEndFittingRaccon + (flashOver * Util.CO180 * 3) + Util.W1246;
							totalWpinTTWTRacoon = totalWpinTTWTRacoon + wpin;
							Q5 = Q5 + wpin;
						}
						else{
							//totalFlashOverTTWTLynx = totalEndFittingLynx + (endFitting * Util.CO138);
							totalWpinTTWTLynx = totalWpinTTWTLynx + wpin;
							Q4 = Q4 + wpin;
						}
						
					}
					if(defInsTTWT[3] != null){
						double endFitting = Double.valueOf(defInsTTWT[3].toString()).doubleValue();
						System.out.println("TTWTTotalendFitting" +endFitting);
						totalEndFittingTTWT = totalEndFittingTTWT + endFitting;
						if(lineObj.getConductorType() == 6){
							//totalFlashOverTTWTRacoon = totalEndFittingRaccon + (flashOver * Util.CO180 * 3) + Util.W1246;
							//totalEndFittingTTWTRaccon = totalEndFittingTTWTRaccon + endFitting;
							Q3 = Q3+endFitting;
						}
						else{
							//totalFlashOverTTWTLynx = totalEndFittingLynx + (endFitting * Util.CO138);
							//totalEndFittingTTWTLynx = totalEndFittingTTWTLynx + endFitting;
							Q2 = Q2+endFitting;
						}
					}
					
					
					
					
					
					Object[] totalOfSuspentionInsulatorCold = lineDao.getTotalCLSuspensionISets(area, String.valueOf(lines.get(i)),newCycle);
					
					if(totalOfSuspentionInsulatorCold[0] != null){
						double flashOver = Double.valueOf(totalOfSuspentionInsulatorCold[0].toString()).doubleValue();
						System.out.println("SuspentionflashOver" +flashOver);
						totalSusInsSetColdFlashOver  = totalSusInsSetColdFlashOver  + flashOver;
					}
					if(totalOfSuspentionInsulatorCold[1] != null){
						double fungusSet = Double.valueOf(totalOfSuspentionInsulatorCold[1].toString()).doubleValue();
						System.out.println("SuspentionfungusSet" +fungusSet);
						totalSusInsSetColdFungus  = totalSusInsSetColdFungus  + fungusSet;
					}
					if(totalOfSuspentionInsulatorCold[2] != null){
						double wpin = Double.valueOf(totalOfSuspentionInsulatorCold[2].toString()).doubleValue();
						System.out.println("Suspentionwpin" +wpin);
						totalSusInsSetColdWpin  = totalSusInsSetColdWpin  + wpin;
					}
					if(totalOfSuspentionInsulatorCold[3] != null){
						double endFitting = Double.valueOf(totalOfSuspentionInsulatorCold[3].toString()).doubleValue();
						System.out.println("SuspentionendFitting" +endFitting);
						totalSusInsSetColdEndFitting = totalSusInsSetColdEndFitting + endFitting;
					}
					
					Object[] totalOfTentionInsulatorCold = lineDao.getTotalCLTensionISets(area, String.valueOf(lines.get(i)),newCycle);
					
					if(totalOfTentionInsulatorCold[0] != null){
						double flashOver = Double.valueOf(totalOfTentionInsulatorCold[0].toString()).doubleValue();
						System.out.println("TentionflashOver" +flashOver);
						totalTensionInsSetColdFlashOver  = totalTensionInsSetColdFlashOver  + flashOver;
					}
					if(totalOfTentionInsulatorCold[1] != null){
						double fungusSet = Double.valueOf(totalOfTentionInsulatorCold[1].toString()).doubleValue();
						System.out.println("TentionfungusSet" +fungusSet);
						totalTensionInsSetColdFungus= totalTensionInsSetColdFungus  + fungusSet;
					}
					if(totalOfTentionInsulatorCold[2] != null){
						double wpin = Double.valueOf(totalOfTentionInsulatorCold[2].toString()).doubleValue();
						System.out.println("Tentionwpin" +wpin);
						totalTensionInsSetColdWpin  = totalTensionInsSetColdWpin  + wpin;
					}
					if(totalOfTentionInsulatorCold[3] != null){
						double endFitting = Double.valueOf(totalOfTentionInsulatorCold[3].toString()).doubleValue();
						System.out.println("TentionendFitting" +endFitting);
						totalTensionInsSetColdEndFitting = totalTensionInsSetColdEndFitting + endFitting;
					}
					
					double countCL1 = lineDao.getCountCL1(area, String.valueOf(lines.get(i)),newCycle);
					totalCountCL = totalCountCL + countCL1;
					System.out.println("totalCountCL" +totalCountCL);
					double countCL2 = lineDao.getCountCL2(area, String.valueOf(lines.get(i)),newCycle);
					totalCountCL = totalCountCL + countCL2;
					
					
					
					double countTTWT = lineDao.getCountTTWT(area, String.valueOf(lines.get(i)),newCycle);
					totalCountTTWT = totalCountTTWT + countTTWT;
					System.out.println("totalCountTTWT" +totalCountTTWT);
					
					
					
				}
				
				request.getSession().setAttribute("selectedLine", lineCode);
				model.setCycle(lineCode);
				//model.getInspection().setCycle(newCycle);
				//model.getInspection().setLine(lines.toString());

				double a = totalFlashOver + totalFungus + totalWpin + totalEndFitting + totalFlashOverTTWT + totalFungusTTWT + totalWpinTTWT + totalEndFittingTTWT;
				System.out.println("totalFlashOver " +totalFlashOver +" " +  totalWpin + " "+ totalFlashOverTTWT +" "+ totalWpinTTWT);
				System.out.println("a  " +a);
				//double totalSIS = totalFlashOver + totalWpin + totalFlashOverTTWT + totalWpinTTWT;
				double totalSIS = totalFlashOver + totalWpin;
				//double totalSIS = totalSusInsSetColdFlashOver + totalSusInsSetColdWpin;
				double totalCostSIS = 0;
				//Total of Suspension Insulator Sets(Flash Over + WPIN )] *(Price of Material C 01 80)*3
				if(totalSIS > 0){
					totalCostSIS = totalSIS * Util.CO180 * 3;//28+26
					System.out.println("totalSIS  " +totalSIS);
					
				}
				
				System.out.println("Total of Suspension Insulator Sets(Flash Over + WPIN ) " +totalSIS);
				System.out.println("Total of Suspension Insulator Sets(Flash Over + WPIN ) COST  " +totalCostSIS);
				//double totalEF =  totalEndFitting + totalEndFittingTTWT;
				//double totalEF =  totalSusInsSetColdEndFitting;
				double totalEF =  totalEndFitting;
				
				double totalCostEF = 0;
				double totalCostEFRacoonC0180 = 0;
				double totalCostEFRacoonW1246 = 0;
				
				
				if(totalEF > 0){
					totalCostEF = totalEF * Util.CO138;//60
					System.out.println("totalEF  " +totalEF);
				}
				
				//Total of Suspension Insulator Sets(End Fitting )] *(Price of Material C 01 38) Lynx
				if(totalEndFittingLynx > 0){
					totalCostEF = totalEndFittingLynx * Util.CO138;
				}
				//Total of Suspension Insulator Sets(End Fitting )] *(Price of Material C 01 80*3) Raccon
				if(totalEndFittingRaccon > 0){
					totalCostEFRacoonC0180 = totalEndFittingRaccon * Util.CO180 *3;
				}
				//Total of Suspension Insulator Sets(End Fitting )] *(Price of Material W 12 46) Racoon
				if(totalEndFittingRaccon > 0){
					totalCostEFRacoonW1246 = totalEndFittingRaccon * Util.W1246;
				}
				
				System.out.println("Total of Suspension Insulator Sets(End Fitting   7) " +totalEF);
				System.out.println("Total of Suspension Insulator Sets(End Fitting )COST  " +totalEF);
				//double totalTIS = totalFlashOver + totalFlashOverTTWT + totalWpin + totalWpinTTWT;
				
				//double totalTIS = totalTensionInsSetColdFlashOver + totalFlashOverTTWT + totalTensionInsSetColdWpin + totalWpinTTWT;
				
				double totalTIS =  totalFlashOverTTWT + totalWpinTTWT;//37+4
				double totalTISLynx =  totalFlashOverTTWTLynx + totalWpinTTWTLynx;//37+4
				double totalTISRacoon =  totalFlashOverTTWTRacoon + totalWpinTTWTRacoon;//37+4
				
				double totalCostTIS = 0;
				double totalCostTISC0190 = 0;
				double totalCostTISC0180 = 0;
				//Total of Tension Insulator Sets(Flash Over Insulators + WPIN)] *(Price of Material C 01 90)*3 Lynx
				if(totalTISLynx > 0){
					totalCostTISC0190 = totalTISLynx * Util.CO190 * 3;
				}
				//Total of Tension Insulator Sets(Flash Over Insulators + WPIN)] *(Price of Material C 01 80)*3 Racoon
				if(totalTISRacoon >0){
					totalCostTISC0180 = totalTISRacoon * Util.CO180 * 3;
				}
				double totalCostTISC0143 = 0;
				double totalCostTISC0140 = 0;
				
				
				//Total of Tension Insulator Sets(End Fittings)] *(Price of Material C 01 43)
				if(totalEndFittingTTWTLynx > 0){
					totalCostTISC0143 = totalEndFittingTTWTLynx * Util.CO143;
				}
				if(totalEndFittingTTWTRaccon > 0){
					totalCostTISC0140 = totalEndFittingTTWTRaccon * Util.CO140;
					
				}
				
				if(totalTIS > 0){
					totalCostTIS = totalTIS *  Util.CO190 *3;
					System.out.println("totalTIS  " +totalTIS);
					
				}
				
				System.out.println("Total of Tension Insulator Sets(Flash Over Insulators + WPIN 1)  " +totalTIS);
				System.out.println("Total of Tension Insulator Sets(Flash Over Insulators + WPIN) cost  " +totalCostTIS);
				
				double totalCostEFI =0;
				
				
				if(totalEF > 0){
					totalCostEFI = totalEF * Util.CO143;
				}
				
				//double totalTISEF =totalEndFittingTTWT + totalTensionInsSetColdEndFitting;
				double totalTISEF =totalEndFittingTTWT;//32
				
				double totalTISEFLynx =totalEndFittingTTWTLynx;
				double totalTISEFLRacoon =totalEndFittingTTWTRaccon;
				
				double totalCostTISEFLynx =0;
				double totalCostTISEFLRacoon =0;
				
				
				if(totalTISEFLynx > 0){
					totalCostTISEFLynx = totalTISEFLynx * Util.CO143 ;
				}
				if(totalTISEFLRacoon > 0){
					totalCostTISEFLRacoon = totalTISEFLRacoon * Util.CO140 ;

				}
				
				if(totalTISEF > 0){
					totalCostEFI = totalTISEF * Util.CO143;
					System.out.println("totalTISEF  " +totalTISEF);
					
				}
				
				System.out.println("Total of Tension Insulator Sets(End Fittings 0)  " +totalTISEF);
				System.out.println("Total of Tension Insulator Sets(End Fittings) cost  " +totalCostEFI);
				
				
				
				//double b = totalCostSIS + totalCostEF + totalCostTIS + totalCostEFI ;
				//double b =0;
				double totalFungusC = (totalFungus + totalFungusTTWT) * 2;
				
				//double totalFungusC = totalFungus * 2;
				System.out.println("(Total Funguss*2) " +totalFungusC);
				
				//double totalFWEC = (totalFlashOver + totalFlashOverTTWT + totalEndFitting + totalEndFittingTTWT + totalWpin + totalWpinTTWT) * 3;
				double totalFWEC = (totalSusInsSetColdFlashOver + totalSusInsSetColdEndFitting + totalSusInsSetColdWpin) * 3;
				System.out.println("[Total of Suspension Insulator Sets(Flashover + WPIN + End Fittings)]*3} " +totalFWEC);
				
				
				
				double totalFWEC1 = (totalTensionInsSetColdFlashOver + totalFlashOverTTWT + totalTensionInsSetColdEndFitting + totalEndFittingTTWT + totalTensionInsSetColdWpin + totalWpinTTWT) * 6;
				System.out.println("[Total of Tension Insulator Sets(Flashover + WPIN + End Fittings)]*6 " +totalFWEC1);
				
				
				//double e = c * (400/9) * (30/22);
				
					obj.setTotalLineLength(new BigDecimal(totalLength));
					obj.setTotalNoTowers(new BigDecimal(totalTowers));
					double no_tower = Double.valueOf(totalTowers).doubleValue();
					double mat_c0138 = Q1 * Util.CO138;
					System.out.println("Q1" +Q1);
					System.out.println("Q1Cost" +mat_c0138);
					double mat_c0140 = Q2 * Util.CO140;
					System.out.println("Q2" +Q2);
					System.out.println("Q2Cost" +mat_c0140);
					double mat_c0143 = Q3 * Util.CO143;
					System.out.println("Q3" +Q3);
					System.out.println("Q3Cost" +mat_c0143);
					double Q4total = Q4+totalFlashOver+totalWpin;
					System.out.println("Q4total" +Q4total);
						
					double mat_c0180 = (Q4+totalFlashOver+totalWpin) * 3 * Util.CO180;
					System.out.println("Q4" +(Q4+totalFlashOver+totalWpin));
					System.out.println("Q4Cost" +mat_c0180);
					double mat_c0190 = Q5 * 3 * Util.CO190;
					System.out.println("Q5" +Q5);
					System.out.println("Q5Cost" +mat_c0190);
							
					double mat_cw1216 = Q6 * Util.W1246;
					System.out.println("Q6" +Q6);
					System.out.println("Q6Cost" +mat_cw1216);
					//double mat_c0143 = 0;
					System.out.println("totalDefectiveInsulatorSets " + totalDefectiveInsulatorSets);
					System.out.println("totalFlashInsulatorSets " + totalFlashInsulatorSets);
					
					double b = mat_c0138 + mat_c0140 + mat_c0143 + mat_c0180 + mat_c0190 + mat_cw1216;
					
					double transportManual = 0.0;
					double p =0.0;
					double q =0.0;
					double r =0.0;
					double s =0.0;
					System.out.println(province);
					province = province.trim();
					if (province.equalsIgnoreCase("CP")) {
						transportManual = no_tower * 8;
						p = 162;
						q = 80;
						r = 350; 
						s = 0;
						System.out.println(no_tower +province + transportManual );
					}else if (province.equalsIgnoreCase("CP2")) {
						transportManual = no_tower * 8;
						p = 162;
						q = 80;
						r = 350; 
						s = 0;
						System.out.println(no_tower +province + transportManual );
					} else if (province.equalsIgnoreCase("WPN")) {
						transportManual = no_tower * 4;
						p = 162;
						q = 80;
						r = 100;
						s = 0;
						System.out.println(no_tower +province + transportManual );
					} else if (province.equalsIgnoreCase("EP")) {
						p = 243;
						q =80;
						r = 700;
						s = 500;
						transportManual = (no_tower * 8) + 700;
						System.out.println(no_tower +province + transportManual );
					} else {
						transportManual = 0.0;
						p=0;
						q=0;
						r=0;
						s = 0;
					}
					
					
					
					//double c = totalFungusC + totalFWEC + totalFWEC1 + totalCountCL + totalCountTTWT + p;
					double totalFungusNew = (totalFungus + totalFungusTTWT) * 2;
					double totalCLC = (totalFlashOver + totalWpin + totalEndFitting) * 3;
					double totalTTWT = (totalFlashOverTTWT + totalWpinTTWT + totalEndFittingTTWT) * 6;
					
					
					double c = totalFungusNew  + totalCLC + totalTTWT + p + totalCountCL + totalCountTTWT ;
					
					System.out.println( "test 1:" + p + " / " + totalCountCL + " / "+ totalCountTTWT );
					System.out.println( "test 2:" + c + " / " + totalFungusNew + " / "+ totalCLC +"/"+ totalTTWT +"/"+totalCountCL+"/"+ totalCountTTWT);
					
					
					System.out.println(totalFungusC + " / " + totalFWEC + " / "+ totalFWEC1 + " / " + totalCountCL + " / " +totalCountTTWT + " / " + p );
					double d = 0;
					double e = 0;
					double e1 = 0;
					double e2 = 0;
					double e3 = 0;
					double e4 = 0;
					if(c > 0){
						d = c * Util.LABOUR;
						e1 = c * 800;
						e2 = e1 / 9;
						e3 = e2 * 30;
						e4 = e3 / 22;
								 
						e = e4;
					}
					
					
					double f1 = 0;
					double f2 = 0;
					double f = 0;
					double g1 = 0;
					double g2 = 0;
					double g = 0;
					double h1 = 0;
					double h2 = 0;
					double h =  0;
					double t = 0;
					
					if(c > 0){
						 f1 = c/81;
						 f2 = f1 * q;
						 f = f2 + r + s;
						 g1 = f * 45;
						 g2 = f * 55 * 2;
						 
						 
						 g = g1+g2;
						 h1 = c/81;
						 h2 = h1 * 30000;
						 h =  h2/22;
						 if (h <= 30000) {
								h = 30000;
								

						 } 
						 
						 
						 t = b + d + e + g + h;
						
					}
							
					
					
					double labour_hours = 0;
					double labou_hours_for_the_estimate = 0;
					double labou_value_for_the_estimate = 0;
					double subsistance = 0;
					double hotlineallowance = 0;
					double temparary_site_cost = 0;
					double transport_manual_hot = 0;
					double transport_cost = 0;
					if(c != 0){
						//labour_hours = (totalDefectiveInsulatorSets * 8) + p;
						labour_hours = c;
						labou_hours_for_the_estimate = labour_hours;
						labou_value_for_the_estimate = labour_hours * 433;
						//400/9 30/22
						subsistance = ((labour_hours * 800 )/9) * (30/22);
						hotlineallowance = 16000 * (labour_hours/81);
						temparary_site_cost = ((labour_hours/81) * 30000) /22;
						System.out.println("temparary_site_cost "+ temparary_site_cost); 
						double m =labour_hours/81;
						transport_manual_hot = (m * q) + r + s;
						System.out.println("transport_manual_hot "+ transport_manual_hot);
						transport_cost = transport_manual_hot * 155;
						System.out.println("transport_cost "+ transport_cost);
						//mat_c0138 = totalFlashInsulatorSets * 10210;
						
						System.out.println("mat_c0138 "+ mat_c0138);
						
						
					}
					obj.setTransport(new BigDecimal(g));
					obj.setTransportManual(new BigDecimal(f));
					obj.setNoDaysForTheIns(new BigDecimal(0));
					obj.setLabourHoursForEst(new BigDecimal(
							c));
					obj.setLabourValueForEst(new BigDecimal(
							d));
					obj.setSubsistance(new BigDecimal(e));
					obj.setHotLineAllowances(new BigDecimal(0));
					obj.setTemporarySiteCost(new BigDecimal(h));
					
					obj.setMatC0138(new BigDecimal(mat_c0138));
					obj.setMatC0143(new BigDecimal(mat_c0143));
					obj.setMatC0180(new BigDecimal(mat_c0180));
					obj.setMatC0190(new BigDecimal(mat_c0190));
					obj.setMatW1246(new BigDecimal(mat_cw1216));
					obj.setMatC0140(new BigDecimal(mat_c0140));
					if (h <= 30000) {
						h = 30000;
						obj.setTemporarySiteCost(new BigDecimal(30000));

					} else {
						obj.setTemporarySiteCost(new BigDecimal(h));

					}
					//double total = labou_value_for_the_estimate + subsistance
						//	+ hotlineallowance + temparary_site_cost + transport_cost + mat_c0138;
					obj.setTatalCost(new BigDecimal(t));
					model.setInspection(obj);
					Map<String, String> sauserList = new LinkedHashMap<String, String>();
					model.setInspection(obj);
					System.out.println("allocated_To "+ allocated_To); 
					System.out.println("obj.getTatalCost().doubleValue() "+ obj.getTatalCost().doubleValue()); 
					List<MmsAddline> liness = addLine.findLineByArea(area);
					model.setLineListEdit(liness);
					int lineSize = liness.size() - 1;
					List<Long> lineListnew = new ArrayList<Long>(lineSize);
					for (int i = 0; i <= lineSize; i++) {
						MmsAddline obj1 = liness.get(i);
						lineListnew.add(obj1.getId());
						if (i != 0) { 
							stringOflineIds = stringOflineIds + "," + Long.toString(obj1.getId()); 
						} else { 
							stringOflineIds = Long.toString(obj1.getId()); 
						}
						 
					}
					System.out.println("-------------------> stringOflineIds: "+ stringOflineIds);
					model.setListOfLines(lineListnew);
					model = loadProLineES(request,model);
					canGO = "3";
					//model.setMode(canGO);
					model.setSelectedLines(null);
				
				
			}else{
				List<MmsAddline> liness = addLine.findLineByArea(area);
				model.setLineListEdit(liness);
				int lineSize = liness.size() - 1;
				List<Long> lineListnew = new ArrayList<Long>(lineSize);
				for (int i = 0; i <= lineSize; i++) {
					MmsAddline obj = liness.get(i);
					lineListnew.add(obj.getId());
					if (i != 0) { stringOflineIds = stringOflineIds + "," +
					  Long.toString(obj.getId()); } 
					else { stringOflineIds =
					  Long.toString(obj.getId()); }
					 
				}
				System.out.println("else -------------------> stringOflineIds: "+ stringOflineIds);
				model.setListOfLines(lineListnew);
				model = loadProLineES(request,model);
				if( model.getInspection() != null){
					
					
						String line = request.getSession().getAttribute("selectedLine").toString();
						if(deptId.equals("596.00")){
							model.getInspection().setDescription(areaName.trim().toLowerCase() + " for Lines : " +line);
							
						}else{
						model.getInspection().setDescription(areaName.trim().toLowerCase());
						}
System.out.println("model.getInspection().getDescription()"+ model.getInspection().getDescription());

					
				System.out.println("else model.getInspection().getTatalCost().doubleValue()"+ model.getInspection().getTatalCost().doubleValue());
				if(model.getInspection().getTatalCost().doubleValue() != 0){
					Application application = createApplicationObject(deptId,userName,model);
					System.out.println("els : " + model.getInspection().getMatC0138());
					westimateNo = appDao.saveSPS(deptId,userName,allocated_To,application, model);
					
					

String pre_approval_id = "";
		    		pre_approval_id = deptId+"-COLMNT-21-";
		        	String nextNumver = insDao.getNextINsEstimate(pre_approval_id);
		    		
					
					model.getInspection().setInspectionId(pre_approval_id+nextNumver);
					model.getInspection().setPhmBranch(deptId);
					model.getInspection().setArea(area);
					model.getInspection().setWestimateNo(westimateNo);
					model.getInspection().setInspectionBy(allocated_To);
					model.getInspection().setStatus(new BigDecimal("75"));
					
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date newDate = new Date();
		    		
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

		    		Date date2 = null;
					try {
						String dateString1 = format.format(newDate);
						date2 = format.parse (dateString1);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}    

		    		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");

		    		String timeString = format2.format(newDate);
		    		System.out.println("finish 3 " );
					
		    		model.getInspection().setInsCreatedDate(date2);
		    		//model.getInspection().setCompletedTime(timeString);
		    		model.getInspection().setType("COLMNT");
		    		model.getInspection().setCycle(newCycle);
		    		//model.getInspection().setLine(model.getLineName());
		    		System.out.println("finish 4 " );
					
					try {
						insDao.add(model.getInspection());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


					
					
					


					
					
					
					model.setMode(westimateNo);
					canGO = "1";
				}
				}
			
			}
			
			
			
			ModelAndView mo = new ModelAndView("goToViewInsEstimateCOLD", "model",
					model);
			mo.addObject("canGO", canGO);
			mo.addObject("stringOflineIds", stringOflineIds);
			mo.addObject("area", area);
			mo.addObject("totalDefTotal", totalDefectiveInsulatorSets);
			mo.addObject("totalIndTotal", totalFlashInsulatorSets);
			
			

			return mo;
			
			
			
		}
		
		
		
		
		
		@RequestMapping(value = "/goToViewInsEstimateSCIVIL", method = RequestMethod.GET)
		public @ResponseBody String goToViewInsEstimateSCIVIL(HttpServletRequest request,@RequestParam("area") String area,@RequestParam("cycle") String cycle,@RequestParam("es") String es,@RequestParam("id") String id) {
		 PivModel model = new PivModel();
		  String deptId = (String) request.getSession().getAttribute("deptId");
		  String userName = (String) request.getSession().getAttribute("loggedUser");
		  String allocated_To = es;
		  model.setSpsdescription("This cold line civil estimate is generated through the MMS for "+ area + " of maintenace cycle :"+cycle);
		  Application application = createApplicationObject(deptId,userName,model);
		  model.setEstimateType("CIVIL");
		  String westimateNo = appDao.saveSPS(deptId,userName,allocated_To,application, model);
		  model.setMode(westimateNo);
		  
		  String pre_approval_id = "";
  		  pre_approval_id = deptId+"-COLCIV-21-";
      	  String nextNumver = insDao.getNextINsEstimate(pre_approval_id);
  		
			
			model.getInspection().setInspectionId(pre_approval_id+nextNumver);
			model.getInspection().setPhmBranch(deptId);
			model.getInspection().setArea(area);
			model.getInspection().setWestimateNo(westimateNo);
			model.getInspection().setInspectionBy(allocated_To);
			model.getInspection().setStatus(new BigDecimal("75"));
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date newDate = new Date();
  		
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

  		Date date2 = null;
			try {
				String dateString1 = format.format(newDate);
				date2 = format.parse (dateString1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    

  		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");

  		String timeString = format2.format(newDate);
  		System.out.println("finish 3 " );
  		String newCycle = null;
  		if(model.getCycleObj() != null){
  			newCycle = model.getCycleObj().getId().getCycleId();
  		}
  		
  		model.getInspection().setInsCreatedDate(date2);
  		//model.getInspection().setCompletedTime(timeString);
  		model.getInspection().setType("COLCIV");
  		model.getInspection().setCycle(newCycle);
  		//model.getInspection().setLine(lines.toString());

  		//model.getInspection().setCycle(model.getCycle());
  		//model.getInspection().setLine(model.getLineName());
  		System.out.println("finish 4 " );
			
			try {
				insDao.add(model.getInspection());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			

		  
		  
		  
		  
		  //ModelAndView mo = new ModelAndView("goToViewInsEstimateCIVIL", "model",model);
		  return westimateNo;
			
			
			
		}


		@RequestMapping(value = "/saveCIVIL", method = RequestMethod.POST)
		public ModelAndView saveCIVIL(HttpServletRequest request,@ModelAttribute("model") PivModel model) {
			 String deptId = (String) request.getSession().getAttribute("deptId");
			  String userName = (String) request.getSession().getAttribute("loggedUser");
			  //String allocated_To = es;
			  String allocated_To = model.getSauserm().getUserId();
			  String area = model.getGldeptobj().getDeptId();
			  String areaName = gldeptDao.getName(area);
				String province = model.getGlcompmobj().getCompId();
				String ss = "This estimate is created for the the Cold line civil Maintenance of "+ areaName + " for maintenance cycle :"+model.getCycle();
			  model.setSpsdescription(ss);
			  MmsInspection obj = new MmsInspection();
			  model.setInspection(obj);
			  model.getInspection().setDescription(ss);
			  Application application = createApplicationObject(deptId,userName,model);
			  model.setEstimateType("CIVIL");
			  String westimateNo = appDao.saveSPS(deptId,userName,allocated_To,application, model);
			  model.setMode(westimateNo);
			  String pre_approval_id = "";
	  		  pre_approval_id = deptId+"-COLCIV-21-";
	      	  String nextNumver = insDao.getNextINsEstimate(pre_approval_id);
	  		
				
				model.getInspection().setInspectionId(pre_approval_id+nextNumver);
				model.getInspection().setPhmBranch(deptId);
				model.getInspection().setArea(area);
				model.getInspection().setWestimateNo(westimateNo);
				model.getInspection().setInspectionBy(allocated_To);
				model.getInspection().setStatus(new BigDecimal("75"));
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date newDate = new Date();
	  		
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

	  		Date date2 = null;
				try {
					String dateString1 = format.format(newDate);
					date2 = format.parse (dateString1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}    

	  		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");

	  		String timeString = format2.format(newDate);
	  		System.out.println("finish 3 " );
	  		String newCycle ="";
	  		if(model.getCycleObj() != null){
	  			newCycle = model.getCycleObj().getId().getCycleId();
	  		}
	  		//String 

	  		model.getInspection().setInsCreatedDate(date2);
	  		//model.getInspection().setCompletedTime(timeString);
	  		model.getInspection().setType("COLCIV");
	  		model.getInspection().setCycle(newCycle);
	  		//model.getInspection().setLine(lines.toString());

	  		//model.getInspection().setCycle(model.getCycle());
	  		//model.getInspection().setLine(model.getLineName());
	  		System.out.println("finish 4 " );
				
				try {
					insDao.add(model.getInspection());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				

			  
			  
			  

			  
			  
			  
			  ModelAndView mo = new ModelAndView("goToViewInsEstimateCIVIL", "model",model);
			  //return westimateNo;
			
			return mo;
		}
		
		
		
		
	/*	@RequestMapping(value = "/goToViewInsEstimateSCOLD", method = RequestMethod.POST)
		public ModelAndView goToViewInsEstimateSCOLD(HttpServletRequest request,
				@ModelAttribute("model") PivModel model) {
				
			Map<String, String> lineList = new LinkedHashMap<String, String>();
			String stringOflineIds = "";
			String deptId = (String) request.getSession().getAttribute("deptId");
		
			String westimateNo = "";
			String area = model.getGldeptobj().getDeptId();
			String province = model.getGlcompmobj().getCompId();
			String canGO = "2";
			List<Long> lines = model.getSelectedLines();
			System.out.println("line"+lines);
			System.out.println("province1 " + province);
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String allocated_To = model.getSauserm().getUserId();
			double Q1= 0;
			double Q2= 0;
			double Q3= 0;
			double Q4= 0;
			double Q5= 0;
			double Q6= 0;
			
			
			
			if (lines != null) {
				System.out.println("province " + province);
				double totalLength = 0;
				double totalTowers = 0;
				//String area = "";

				int idloop = lines.size();
				
				for (int i = 0; i < idloop; i++) {
					MmsAddline lineObj = lineDao.findById(lines.get(i));
					totalLength = totalLength + lineObj.getLength().doubleValue();
					totalTowers = totalTowers + lineObj.getNooftowers().doubleValue();
					area = lineObj.getArea();
					String newCycle = model.getCycleObj().getId().getCycleId();
					
					
					
					
					//System.out.println("model.getCycle() " + model.getCycle());
					Object[] defInsCold = lineDao.getTotalofDefectiveInsultorSetForColdLineEst(area, String.valueOf(lines.get(i)),newCycle);
					if(defInsCold[0] != null){
						double flashOver = Double.valueOf(defInsCold[0].toString()).doubleValue();
						System.out.println("ColdTotalflashOver" +flashOver);
						if(lineObj.getConductorType() == 6){
							Q4 = Q4 + flashOver;
						}else{
							Q4 = Q4 + flashOver;
						}
						
						
					}
					if(defInsCold[1] != null){
						double fungusSet = Double.valueOf(defInsCold[1].toString()).doubleValue();
						System.out.println("ColdTotalfungusSet" +fungusSet);
						
					}
					if(defInsCold[2] != null){
						double wpin = Double.valueOf(defInsCold[2].toString()).doubleValue();
						System.out.println("ColdTotalwpin" +wpin);
						
						if(lineObj.getConductorType() == 6){
							Q4 = Q4 + wpin;
						}else{
							Q4 = Q4 + wpin;
						}
						
						
						
					}
					if(defInsCold[3] != null){
						double endFitting = Double.valueOf(defInsCold[3].toString()).doubleValue();
						System.out.println("ColdTotalendFitting" +endFitting);
						
						System.out.println("lineObj.getConductorType() " +lineObj.getConductorType());
						
						if(lineObj.getConductorType() == 6){
							//totalEndFittingRaccon = totalEndFittingRaccon + (endFitting * Util.CO180 * 3) + Util.W1246;
							//totalEndFittingLynx = totalEndFittingLynx + endFitting;
							Q1 = Q1 + endFitting; 
						}
						else{
							//totalEndFittingLynx = totalEndFittingLynx + (endFitting * Util.CO138);
							//totalEndFittingRaccon = totalEndFittingRaccon + endFitting;
							Q4 = Q4 + endFitting;
							Q6 = Q6 + endFitting;
						}
					}
					
					
					
					Object[] defInsTTWT = lineDao.getTotalofDefectiveInsultorSetForTTWTEst(area, String.valueOf(lines.get(i)),newCycle);
					
					if(defInsTTWT[0] != null){
						double flashOver = Double.valueOf(defInsTTWT[0].toString()).doubleValue();
						System.out.println("TTWTTotalflashOver" +flashOver);
						
						
						if(lineObj.getConductorType() == 6){
							Q5 = Q5 + flashOver;
						}
						else{
							Q4 = Q4 + flashOver;
						}
						
						
						
					}
					if(defInsTTWT[1] != null){
						double fungusSet = Double.valueOf(defInsTTWT[1].toString()).doubleValue();
						System.out.println("TTWTTotalfungusSet" +fungusSet);
					}
					if(defInsTTWT[2] != null){
						double wpin = Double.valueOf(defInsTTWT[2].toString()).doubleValue();
						System.out.println("TTWTTotalwpin" +wpin);
						
						if(lineObj.getConductorType() == 6){
							Q5 = Q5 + wpin;
						}
						else{
							Q4 = Q4 + wpin;
						}
						
					}
					if(defInsTTWT[3] != null){
						double endFitting = Double.valueOf(defInsTTWT[3].toString()).doubleValue();
						System.out.println("TTWTTotalendFitting" +endFitting);
						if(lineObj.getConductorType() == 6){
							Q3 = Q3+endFitting;
						}
						else{
							Q2 = Q2+endFitting;
						}
					}
					
					
						
				}
				
			}

			MmsInspection obj = new MmsInspection();
			double mat_c0138 = Q1 * Util.CO138;
			System.out.println("Q1" +Q1);
			System.out.println("Q1Cost" +mat_c0138);
			double mat_c0140 = Q2 * Util.CO140;
			System.out.println("Q2" +Q2);
			System.out.println("Q2Cost" +mat_c0140);
			double mat_c0143 = Q3 * Util.CO143;
			System.out.println("Q3" +Q3);
			System.out.println("Q3Cost" +mat_c0143);
					
			double mat_c0180 = Q4 * 3 * Util.CO180;
			System.out.println("Q4" +Q4);
			System.out.println("Q4Cost" +mat_c0180);
			double mat_c0190 = Q5 * 3 * Util.CO190;
			System.out.println("Q5" +Q5);
			System.out.println("Q5Cost" +mat_c0190);
					
			double mat_cw1216 = Q6 * Util.W1246;
			System.out.println("Q6" +Q6);
			System.out.println("Q6Cost" +mat_cw1216);
			
			
				    
			ModelAndView mo = new ModelAndView("goToViewInsEstimateCOLD", "model",model);
			return mo;
			
			
			
		}
*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		@RequestMapping(value = "/goToViewInsEstimateS", method = RequestMethod.POST)
		public ModelAndView goToViewInsEstimateS(HttpServletRequest request,
				@ModelAttribute("model") PivModel model) {
			
			/*if(mode.equalsIgnoreCase("INS")){
				mo.addObject("type", "INSPECTION ESTIMATE");
			}else if(mode.equalsIgnoreCase("HOT")){
				mo.addObject("type", "HOT LINE ESTIMATE");
			}else if(mode.equalsIgnoreCase("COLD")){
				mo.addObject("type", "COLD LINE ESTIMATE");
			}*/
			
			Map<String, String> lineList = new LinkedHashMap<String, String>();
			String stringOflineIds = "";
			String deptId = (String) request.getSession().getAttribute("deptId");
			model.setEstimateType("INS");
			
			String westimateNo = "";
			String area = model.getGldeptobj().getDeptId();
			String areaName = gldeptDao.getName(area.trim());
			
			String province = model.getGlcompmobj().getCompId();
			String canGO = "2";
			List<Long> lines = model.getSelectedLines();
			System.out.println("area"+area);
			
			System.out.println("line"+lines);
			System.out.println("province1 " + province);
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String allocated_To = "";
			if(model.getSauserm() != null){
				allocated_To = model.getSauserm().getUserId();
			}
			/*if(model.getMode() == "3"){
				System.out.println("mmmmmm  " + model.getInspection().getTatalCost().doubleValue());
				if(model.getInspection().getTatalCost().doubleValue() != 0){
					Application application = createApplicationObject(deptId,userName,model);
					westimateNo = appDao.saveSPS(deptId,userName,allocated_To,application, model);
					model.setMode(westimateNo);
				}
			}
			*/
			
			if (lines != null) {
				System.out.println("province " + province);
				double totalLength = 0;
				double totalTowers = 0;
				double totalPole = 0;
				//String area = "";
				String lineCode="";
				
				int idloop = lines.size();
				MmsInspection obj = new MmsInspection();
				   
				for (int i = 0; i < idloop; i++) {
					MmsAddline lineObj = lineDao.findById(lines.get(i));
					totalLength = totalLength + lineObj.getLength().doubleValue();
					totalTowers = totalTowers + lineObj.getNooftowers().doubleValue();
					totalPole = totalPole + lineObj.getNoofpoles().doubleValue();
					
					area = lineObj.getArea();
					lineCode =  lineObj.getCode() +"," + lineCode;
					System.out.println("lineCode " + lineCode);
					obj.setDescription(lineCode);
					
				}
				 request.getSession().setAttribute("selectedLine", lineCode);
                     //obj.setDescription(lineCode);
				    double totalTP = totalTowers + totalPole;
				    model.setCycle(lineCode);
					obj.setTotalLineLength(new BigDecimal(totalLength));
					obj.setTotalNoTowers(new BigDecimal(totalTP));
					double no_tower = Double.valueOf(totalTP).doubleValue();
					double no_days_for_the_ins = no_tower / 27;
					// Round.
					double labou_hours_for_the_estimate = 9 * no_days_for_the_ins * 9;
					double labou_value_for_the_estimate = 9 * no_days_for_the_ins * 9 * Util.LABOUR;
					System.out.println("labou_hours_for_the_estimate" + labou_hours_for_the_estimate);
					double subsistanceObj = 800 * labou_hours_for_the_estimate;
					double subsistanceObjObj = subsistanceObj / 9;
					System.out.println("subsistance1" + subsistanceObjObj);
					//obj.setDescription("test");
					
					double subsistance2 = 30 * subsistanceObjObj;
					double subsistance = subsistance2 / 22 ;
					System.out.println("subsistance" + subsistance);
					
					double hotlineallowance = 40000 * no_days_for_the_ins;
					double temparary_site_cost1 = no_days_for_the_ins *  30000;
					double temparary_site_cost = temparary_site_cost1 / 22;
					
					
					//double temparary_site_cost = no_days_for_the_ins * (1 / 22) * 30000;
					
					System.out.println("temparary_site_cost" + temparary_site_cost);
					//double temparary_site_cost = 0;
					
					/*if(temparary_site_cost < 30000){
						temparary_site_cost = 30000;
					}*/
					double transportManual = 0.0;
					System.out.println(province);
					province = province.trim();
					if (province.equalsIgnoreCase("CP")) {
						transportManual = no_tower * 8;
						System.out.println(no_tower +province + transportManual );
					}else if (province.equalsIgnoreCase("CP2")) {
						transportManual = no_tower * 8;
						System.out.println(no_tower +province + transportManual );
					} else if (province.equalsIgnoreCase("WPN")) {
						transportManual = no_tower * 4;
						System.out.println(no_tower +province + transportManual );
					} else if (province.equalsIgnoreCase("EP")) {
						transportManual = (no_tower * 8) + 700;
						System.out.println(no_tower +province + transportManual );
					} else {
						transportManual = 0.0;
					}
					System.out.println("transportManual " + transportManual);
					double transport_cost = (transportManual * 100);
						//	+ (transportManual * 55);
					System.out.println("transport_cost " + transport_cost);
					
					System.out.println("no_days_for_the_ins :" + no_days_for_the_ins);

					System.out.println("no_days_for_the_ins :" + no_days_for_the_ins);
					obj.setTransport(new BigDecimal(transport_cost));
					obj.setTransportManual(new BigDecimal(transportManual));
					obj.setNoDaysForTheIns(new BigDecimal(no_days_for_the_ins));
					obj.setLabourHoursForEst(new BigDecimal(
							labou_hours_for_the_estimate));
					obj.setLabourValueForEst(new BigDecimal(
							labou_value_for_the_estimate));
					obj.setSubsistance(new BigDecimal(subsistance));
					obj.setHotLineAllowances(new BigDecimal(hotlineallowance));
					obj.setTemporarySiteCost(new BigDecimal(0));
					if (temparary_site_cost <= 30000) {
						temparary_site_cost = 30000;
						obj.setTemporarySiteCost(new BigDecimal(30000));

					} else {
						obj.setTemporarySiteCost(new BigDecimal(temparary_site_cost));

					}
					double total = labou_value_for_the_estimate + subsistance
							+ hotlineallowance + temparary_site_cost + transport_cost;
					obj.setTatalCost(new BigDecimal(total));
					model.setInspection(obj);
					System.out.println("obj" + obj.getDescription());
					
					Map<String, String> sauserList = new LinkedHashMap<String, String>();
					
					//obj.
					model.setInspection(obj);
					
					
					System.out.println("allocated_To "+ allocated_To); 
					System.out.println("obj.getTatalCost().doubleValue() "+ obj.getTatalCost().doubleValue()); 
					
					System.out.println("obj.getDescription() "+ obj.getDescription()); 
					
					
					List<MmsAddline> liness = addLine.findLineByArea(area);
					model.setLineListEdit(liness);
					int lineSize = liness.size() - 1;
					List<Long> lineListnew = new ArrayList<Long>(lineSize);
					for (int i = 0; i <= lineSize; i++) {
						MmsAddline obj1 = liness.get(i);
						lineListnew.add(obj1.getId());
						if (i != 0) { stringOflineIds = stringOflineIds + "," +
						  Long.toString(obj1.getId()); } 
						else { stringOflineIds =
						  Long.toString(obj1.getId()); }
						 
					}
					System.out.println("-------------------> stringOflineIds: "+ stringOflineIds);
					model.setListOfLines(lineListnew);
					model = loadProLineES(request,model);
					canGO = "3";
					//model.setMode(canGO);
					//model.setSelectedLinesNew(lines);
					model.setSelectedLines(null);
				
				
			}else{
				List<MmsAddline> liness = addLine.findLineByArea(area);
				model.setLineListEdit(liness);
				int lineSize = liness.size() - 1;
				List<Long> lineListnew = new ArrayList<Long>(lineSize);
				for (int i = 0; i <= lineSize; i++) {
					MmsAddline obj = liness.get(i);
					lineListnew.add(obj.getId());
					if (i != 0) { stringOflineIds = stringOflineIds + "," +
					  Long.toString(obj.getId()); } 
					else { stringOflineIds =
					  Long.toString(obj.getId()); }
					 
				}
				
				/*System.out.println("model.getSelectedLinesNew() " + model.getSelectedLinesNew());
				
				if(model.getSelectedLinesNew()!= null){
				int idloop = lines.size();
				String lineCode ="";
				for (int i = 0; i < idloop; i++) {
					MmsAddline lineObj = lineDao.findById(lines.get(i));
					lineCode =  lineObj.getCode() +"," + lineCode;
					System.out.println("lineCode " + lineCode);
					if(model.getInspection() != null){
						model.getInspection().setDescription(lineCode);
						
					}
					
				}
				}

*/				
				
				
				System.out.println("else -------------------> stringOflineIds: "+ stringOflineIds);
				model.setListOfLines(lineListnew);
				model = loadProLineES(request,model);
				if( model.getInspection() != null){
					String line = request.getSession().getAttribute("selectedLine").toString();
					if(deptId.equals("596.00")){
						model.getInspection().setDescription(areaName.trim().toLowerCase() + " for Lines : " +line);
						
					}else{
					model.getInspection().setDescription(areaName.trim().toLowerCase());
					}
					System.out.println("model.getInspection().getDescription()"+ model.getInspection().getDescription());
					
				System.out.println("else model.getInspection().getTatalCost().doubleValue()"+ model.getInspection().getTatalCost().doubleValue());
				if(model.getInspection().getTatalCost().doubleValue() != 0){
					Application application = createApplicationObject(deptId,userName,model);
					System.out.println("cycle"+ model.getCycle());
					
					westimateNo = appDao.saveSPS(deptId,userName,allocated_To,application, model);
					String pre_approval_id = "";
		    		pre_approval_id = deptId+"-HOTINS-21-";
		        	String nextNumver = insDao.getNextINsEstimate(pre_approval_id);
		    		
					
					model.getInspection().setInspectionId(pre_approval_id+nextNumver);
					model.getInspection().setPhmBranch(deptId);
					model.getInspection().setArea(area);
					model.getInspection().setWestimateNo(westimateNo);
					model.getInspection().setInspectionBy(allocated_To);
					model.getInspection().setStatus(new BigDecimal("75"));
					
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date newDate = new Date();
		    		
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

		    		Date date2 = null;
					try {
						String dateString1 = format.format(newDate);
						date2 = format.parse (dateString1);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}    

		    		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");

		    		String timeString = format2.format(newDate);
		    		System.out.println("finish 3 " );
					
		    		model.getInspection().setInsCreatedDate(date2);
		    		//model.getInspection().setCompletedTime(timeString);
		    		model.getInspection().setType("HOTINS");
					insDao.add(model.getInspection());
					model.setMode(westimateNo);
					canGO = "1";
				}
				}
			
			}
			
			
			
			ModelAndView mo = new ModelAndView("goToViewInsEstimate", "model",model);
			mo.addObject("canGO", canGO);
			mo.addObject("stringOflineIds", stringOflineIds);
			mo.addObject("area", area);
			
			

			return mo;
			//}
			
		}
		
		/*if(obj.getTatalCost().doubleValue() != 0){
		Application application = createApplicationObject(deptId,userName,model);
		westimateNo = appDao.saveSPS(deptId,userName,allocated_To,application, model);
		model.setMode(westimateNo);
		canGO = "1";
	}*/
	
		
		@RequestMapping(value = "/goToViewInsEstimate", method = RequestMethod.GET)
		public ModelAndView goToViewInsEstimate(HttpServletRequest request) {
			String canGO = "1";

			PivModel model = new PivModel();
			model = loadProLineES(request,model);
			model.setEstimateType("INS");
			ModelAndView mo = new ModelAndView("goToViewInsEstimate", "model",model);
			
			mo.addObject("canGO", canGO);
			return mo;

		}
		
		@RequestMapping(value = "/goToViewInsEstimateHOT", method = RequestMethod.GET)
		public ModelAndView goToViewInsEstimateHOT(HttpServletRequest request) {
			String canGO = "1";

			PivModel model = new PivModel();
			model = loadProLineES(request,model);
			ModelAndView mo = new ModelAndView("goToViewInsEstimateHOT", "model",model);
			
			mo.addObject("canGO", canGO);
			return mo;

		}
		
		@RequestMapping(value = "/goToViewInsEstimateCOLD", method = RequestMethod.GET)
		public ModelAndView goToViewInsEstimateCOLD(HttpServletRequest request) {
			String canGO = "1";

			PivModel model = new PivModel();
			model = loadProLineES(request,model);
			ModelAndView mo = new ModelAndView("goToViewInsEstimateCOLD", "model",model);
			
			mo.addObject("canGO", canGO);
			return mo;

		}
		
		
		@RequestMapping(value = "/goToViewInsEstimateCIVIL", method = RequestMethod.GET)
		public ModelAndView goToViewInsEstimateCIVIL(HttpServletRequest request) {
			String canGO = "1";

			PivModel model = new PivModel();
			model = loadProLineES(request,model);
			model.setEstimateType("CIVIL");
			ModelAndView mo = new ModelAndView("goToViewInsEstimateCIVIL", "model",model);
			
			mo.addObject("canGO", canGO);
			return mo;

		}

		
		private PivModel loadProLineES(HttpServletRequest request,PivModel model){
			
			Map<String, String> saList = new LinkedHashMap<String, String>();
			Map<String, String> appList = new LinkedHashMap<String, String>();

			String deptId = (String) request.getSession().getAttribute("deptId");
			
			List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
			List<Applicant> appliList = applicantDao.getAllApplicantBydeptId(deptId);
			int loopApp = appliList.size() - 1;
			for (int i = 0; i <= loopApp; i++) {
				//System.out.println(i);
				Applicant ojb = appliList.get(i);
				//System.out.println(ojb.getIdNo());
				appList.put(ojb.getIdNo(), ojb.getFullName());

			}

			int loopSa = saUserList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
				//System.out.println(i);
				Sauserm ojb = saUserList.get(i);
				//System.out.println(ojb.getUserId());
				saList.put(ojb.getUserId(), ojb.getUserNm());

			}
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			
			//String deptId = (String) request.getSession().getAttribute("deptId");
			//System.out.println("hi1 : " + deptId);
			String province = deptDao.getDD(deptId);
			//System.out.println("hi2 : " + province);
			String distDiv = glcompmDao.getDistDivision(province);
			System.out.println("hi3 : " + distDiv);
			List<Glcompm> line = glcompmDao.getProvinces(distDiv);
			String pro = "";
			if(model.getGlcompmobj() != null){
				pro = model.getGlcompmobj().getCompId();
			}
			//String 
			System.out.println("province : " + province);

			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(pro);

			List<String> provinces = new ArrayList<String>();
			int loop = line.size() - 1;
			for (int i = 0; i <= loop; i++) {
				// System.out.println(i);
				Glcompm ojb = line.get(i);

				//System.out.println(ojb.getCompNm());
				provinces.add(ojb.getCompNm());
				provinceList.put(ojb.getCompId(), ojb.getCompNm());

			}

			int depLoop = deptTm.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				// System.out.println(i);
				Gldeptm ojb = (Gldeptm) deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
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

			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			model.setSaList(saList);
			model.setAppList(appList);
			
			return model;
			
			
			
			
			
			
		}
		
		
		/*@RequestMapping(value = "/PCBdashboard", method = RequestMethod.GET)
		public ModelAndView PCBdashboard(HttpServletRequest request,
				@ModelAttribute("pivModel") PivModel pivModel) {

			// System.out.println("Province" +pivModel.getGlcompmobj().getCompId());
			// String province = pivModel.getGlcompmobj().getCompId();
			// String area = pivModel.getGldeptobj().getDeptId();
			// String line = String.valueOf(pivModel.getLine().getId());
			// List<MmsAddsupport> supportList = addSupport.findByArea(area, line);
			PivModel pivModelNew = new PivModel();
			// pivModelNew.setSupport(supportList);

			Map<String, String> lineList = new LinkedHashMap<String, String>();

			Map<String, String> divList = new LinkedHashMap<String, String>();
			
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			// Map<String,String> supportTypeList = newF
			// LinkedHashMap<String,String>();
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			String province = deptDao.getDD(deptId);
			String distDiv = glcompmDao.getDistDivision(province);
			PivModel model = new PivModel();
			List<Glcompm> line = glcompmDao.getProvinces(distDiv);
			// List<Gldeptm> deptTm = gldeptDao.getArea(province);
			List<Summary> summary = addLine.findDDSummary("DISCO2", deptId);
			List<Summary> areaSummary = addLine.findAreaSummary(deptId);

			// List<MmsAddsupporttype> supType = supTypeDao.findAll();
			// List<MmsAddline> lineObj = addLine.findAll();
			List<String> provinces = new ArrayList<String>();
			int loop = line.size() - 1;
			for (int i = 0; i <= loop; i++) {
				System.out.println(i);
				Glcompm ojb = line.get(i);

				System.out.println(ojb.getCompNm());
				provinces.add(ojb.getCompNm());
				provinceList.put(ojb.getCompId(), ojb.getCompNm());

			}
			// provinceList.put("NONE","ALL");

			// int supLoop = supType.size()-1;
			// for(int i=0;i<=supLoop;i++){
			// System.out.println(i);
			// MmsAddsupporttype ojb = supType.get(i);
			// supportTypeList.put(ojb.getId(), ojb.getSupportType());

			// }

			
			 * int depLoop = deptTm.size()-1; for(int i=0;i<=depLoop;i++){
			 * System.out.println(i); Gldeptm ojb = (Gldeptm)deptTm.get(i);
			 * areaList.put(ojb.getDeptId(), ojb.getDeptNm()); }
			 
			
			 * areaList.put("NONE", "ALL"); int lineLoop = lineObj.size()-1; for(int
			 * i=0;i<=lineLoop;i++){ System.out.println(i); MmsAddline ojb =
			 * lineObj.get(i); lineList.put(String.valueOf(ojb.getCode()),
			 * ojb.getLineName()); }
			 

			// lineList.put("NONE","ALL");
			// model.setSupTypeList(supportTypeList);
			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			model.setLineList(lineList);
			model.setSummaryList(summary);
			model.setAreaSummaryList(areaSummary);

			ModelAndView mo = new ModelAndView();
			String approveLevel = request.getSession()
					.getAttribute("loggedUserRole").toString();
			*//**
			 * if(approveLevel.equalsIgnoreCase("DEO")){ mo = new
			 * ModelAndView("MMS_dashboard_DEO" ,"model",model); }else
			 * if(approveLevel.equalsIgnoreCase("ES")){
			 * mo.setViewName("MMS_dashboard_ES");
			 * 
			 * }else if(approveLevel.equalsIgnoreCase("EE")){ mo = new
			 * ModelAndView("MMS_dashboard_EE" ,"model",model);
			 * 
			 * }else if(approveLevel.equalsIgnoreCase("CE")){
			 * mo.setViewName("MMS_dashboard_CE");
			 * 
			 * }else if(approveLevel.equalsIgnoreCase("DGM")){
			 * mo.setViewName("MMS_dashboard_DGM");
			 * 
			 * }else{
			 * 
			 * }
			 *//*
			// ModelAndView model = new ModelAndView();
			
			
			
			if (deptId.equals("600.41")) {
				mo = new ModelAndView("PCB_dashboard", "model", model);
			} else {
				mo = new ModelAndView("PCB_dashboard_AE", "model", model);
			}

			mo = new ModelAndView("PCB_dashboard", "model", model);
			
			
			String userLevel = request.getSession().getAttribute("loggedUserRole")
					.toString();
			String status = null;

			String phmBranch = (String) request.getSession().getAttribute("deptId");

			// find all supports according to status
			if (userLevel.equals("DEO")) {
				status = Util.IN_BULK;
			} else if (userLevel.equals("ES")) {
				status = Util.VALIDATION_ES;
			} else if (userLevel.equals("EE")) {
				status = Util.APPROVAL_EE;
			}
			List<MmsAddsupport> Support = addSupport.findByStatus(status,phmBranch);
			List<MmsAddline> lineListEdit = lineDao.findLineByStatus(status,
					phmBranch);
			List<MmsTxntowermaintenance> TowerMaintance = towerTxtMaintenance
					.findAllByStatus(status);
			int countAll = Support.size() + lineListEdit.size()
					+ TowerMaintance.size();

			if (Support != null && lineListEdit != null && TowerMaintance != null) {
				mo.addObject("countSupport", Support.size());
				mo.addObject("countLine", lineListEdit.size());
				mo.addObject("countMnt", TowerMaintance.size());
				mo.addObject("countAll", countAll);
			}

			return mo;

		}
*/		// -----------------------------------------------------------------------------------------------------------------------------------------------------
		
		
		@RequestMapping(value = "/PCBdashboard", method = RequestMethod.GET)
		public ModelAndView PCBdashboard(HttpServletRequest request,
				@ModelAttribute("pivModel") PcbModel pivModel) {

			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> divStrList = new LinkedHashMap<String, String>();
			
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			
			PcbModel model = new PcbModel();
			
			List<Glcompm>  divList = glcompmDao.getDisDivision();
			System.out.print("hiii");
			int divListCount = divList.size() - 1;
			for (int i = 0; i <= divListCount; i++) {
				System.out.println(i);
				Glcompm ojb = divList.get(i);
				divStrList.put(ojb.getCompId(), ojb.getCompNm());

			}
			System.out.print("hiii2");
			
			//areaList.put(deptId, gldeptDao.getName(deptId));
			//model.setAreaList(areaList);
			model.setDivList(divStrList);
			ModelAndView mo = new ModelAndView();
			String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
			mo = new ModelAndView("PCB_dashboard", "model", model);
			
			
			return mo;

		}

		
		
		
		
		@RequestMapping(value = "/MapNewWOMNTAE/{area}/{lineId}",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<Object[]> MapNewWOMNTAE(HttpServletRequest request, @PathVariable("area") String area,@PathVariable("lineId") String lineId) {
			String deptId = request.getSession().getAttribute("deptId").toString();
			if(lineId.equalsIgnoreCase("-1")){
				lineId = "NONE";
			}
			return addSupport.findByAreaForNewMapWOMNTAE(area,lineId,deptId,"1");
		}
		
		
		@RequestMapping(value = "/goToInsMntRequest", method = RequestMethod.GET)
		public ModelAndView goToInsMntRequest(HttpServletRequest request,@RequestParam("mode") String mode) {
			String deptId = request.getSession().getAttribute("deptId").toString();
			String stringOflineIds = "";
			
			Map<String, String> eeList = new LinkedHashMap<String, String>();
			
			
			String canGO = "1";

			PivModel model = new PivModel();
			List<MmsAddline> liness = addLine.findLineByArea(deptId);
			Map<String,String> lineList = new LinkedHashMap<String,String>();

			int lineLoop = liness.size()-1;
			for(int i=0;i<=lineLoop;i++){ 
				System.out.println(i);
				MmsAddline ojb = liness.get(i);
				lineList.put(String.valueOf(ojb.getId()), ojb.getLineName());
		    }
			
			
			Map<String,String> areaList = new LinkedHashMap<String,String>();
			
			String name = deptDao.getDD(deptId);
			System.out.println("name xx : "+name);
			String province = glcompmDao.getProvince(name);
			System.out.println("province : " + province);
			String dd =glcompmDao.getDistDivision(province);
			System.out.println("dd : " + dd);
			if(dd.equals("DISCO2")){
				model.setMessageType("DD2");
				
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR2");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj.getDeptId(), "EE");
					
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
							System.out.println("eeList : "+eeList.size());
							
						}
					}
					
					
				}
			}
				
				
			}else if(dd.equals("DISCO3")){
				model.setMessageType("DD3");
				
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR3");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj.getDeptId(), "EE");
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
						}
					}
					
					
				}
			}
					
			}else if(dd.equals("DISCO1")){
				model.setMessageType("DD1");
				
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR1");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj.getDeptId(), "EE");
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
						}
					}
					
					
				}
				}
				
				
			}else if(dd.equals("DISCO4")){
				model.setMessageType("DD4");
				
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR4");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj.getDeptId(), "EE");
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
						}
					}
					
					
				}
			}
				
			}else{
				
			}
			
			//TrippingData objTripping = new TrippingData();
			//provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
			//models.setProvinceList(provinceList);
			//models.setObjTripping(objTripping);
			//List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId().trim());
			
			
			
			
			
			if(deptId.equalsIgnoreCase("600.41") || deptId.equalsIgnoreCase("780.00")){
				List<Gldeptm> area = gldeptDao.getArea(deptId);
				int areaListObj = area.size()-1;
				for(int i=0;i<=areaListObj;i++){ 
					System.out.println(i);
					Gldeptm obj = area.get(i);
					areaList.put(String.valueOf(obj.getDeptId()), obj.getDeptNm());
			    } 
				
				List<Sauserm> esUserList = secDao.getAllUserByRptUser(deptId, "ES");
				if(esUserList != null){
					int eeCount = esUserList.size()-1;
					for(int x=0;x<=eeCount;x++){
						Sauserm objUser = esUserList.get(x);
						System.out.println("objUser.getUserId() : "+objUser.getUserId());
						
						eeList.put(objUser.getUserId(),objUser.getUserNm());
						System.out.println("eeList : "+eeList.size());
						
					}
				}
				model.setEeList(eeList);
				
			}else{
			
				areaList.put(deptId, gldeptDao.getName(deptId));
				model.setEeList(eeList);
			}
			model.setAreaList(areaList);

			
			model.setLineList(lineList);
			
			
			/*Map<String, String> saList = new LinkedHashMap<String, String>();
			Map<String, String> appList = new LinkedHashMap<String, String>();

			
			List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
			List<Applicant> appliList = applicantDao.getAllApplicantBydeptId(deptId);
			int loopApp = appliList.size() - 1;
			for (int i = 0; i <= loopApp; i++) {
				//System.out.println(i);
				Applicant ojb = appliList.get(i);
				//System.out.println(ojb.getIdNo());
				appList.put(ojb.getIdNo(), ojb.getFullName());

			}

			int loopSa = saUserList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
				//System.out.println(i);
				Sauserm ojb = saUserList.get(i);
				//System.out.println(ojb.getUserId());
				saList.put(ojb.getUserId(), ojb.getUserNm());

			}


model.setSaList(saList);
model.setAppList(appList);
*/			
Map<String, String> provinceList = new LinkedHashMap<String, String>();


/*if(mode.equalsIgnoreCase("PHM")){
	String province = deptDao.getDD(deptId.trim());
	String distDiv = glcompmDao.getDistDivision(province);
	
				List<Glcompm> line = glcompmDao.getProvinces(distDiv);
				List<String> provinces = new ArrayList<String>();
				int loop = line.size() - 1;
				for (int i = 0; i <= loop; i++) {
					System.out.println(i);
					Glcompm ojb = line.get(i);

					System.out.println(ojb.getCompNm());
					provinces.add(ojb.getCompNm());
					provinceList.put(ojb.getCompId(), ojb.getCompNm());

				}
			}
model.setProvinceList(provinceList);
*/			model.setMode(mode);
			System.out.println("finish 22 "+ model.getMode());
			System.out.println("finish 23 "+ model.getMessageType());
			
			ModelAndView mo = new ModelAndView("InspectionMaintenanceRequest", "model",model);
			
			mo.addObject("canGO", canGO);
			mo.addObject("type", mode);
			
			return mo;

		}
		
		
		@RequestMapping(value = "/phmInsRequest", method = RequestMethod.GET)
		public ModelAndView phmInsRequest(HttpServletRequest request,@RequestParam("mode") String mode) {
			String deptId = request.getSession().getAttribute("deptId").toString();
			String stringOflineIds = "";
			
			Map<String, String> eeList = new LinkedHashMap<String, String>();
			
			
			String canGO = "1";

			PivModel model = new PivModel();
			List<MmsAddline> liness = addLine.findLineByArea(deptId);
			Map<String,String> lineList = new LinkedHashMap<String,String>();

			int lineLoop = liness.size()-1;
			for(int i=0;i<=lineLoop;i++){ 
				System.out.println(i);
				MmsAddline ojb = liness.get(i);
				lineList.put(String.valueOf(ojb.getId()), ojb.getLineName());
		    }
			
			
			Map<String,String> areaList = new LinkedHashMap<String,String>();
			
			String name = deptDao.getDD(deptId);
			System.out.println("name xx : "+name);
			String province = glcompmDao.getProvince(name);
			System.out.println("province : " + province);
			String dd =glcompmDao.getDistDivision(province);
			System.out.println("dd : " + dd);
			if(dd.equals("DISCO2")){
				model.setMessageType("DD2");
				
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR2");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj.getDeptId(), "EE");
					
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
							System.out.println("eeList : "+eeList.size());
							
						}
					}
					
					
				}
			}
				
				
			}else if(dd.equals("DISCO3")){
				model.setMessageType("DD3");
				
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR3");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj.getDeptId(), "EE");
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
						}
					}
					
					
				}
			}
					
			}else if(dd.equals("DISCO1")){
				model.setMessageType("DD1");
				
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR1");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj.getDeptId(), "EE");
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
						}
					}
					
					
				}
				}
				
				
			}else if(dd.equals("DISCO4")){
				model.setMessageType("DD4");
				
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR4");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj.getDeptId(), "EE");
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
						}
					}
					
					
				}
			}
				
			}else{
				
			}
			
			//TrippingData objTripping = new TrippingData();
			//provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
			//models.setProvinceList(provinceList);
			//models.setObjTripping(objTripping);
			//List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId().trim());
			
			
			
			
			
			if(deptId.equalsIgnoreCase("600.41") || deptId.equalsIgnoreCase("780.00")){
				List<Gldeptm> area = gldeptDao.getArea(deptId);
				int areaListObj = area.size()-1;
				for(int i=0;i<=areaListObj;i++){ 
					System.out.println(i);
					Gldeptm obj = area.get(i);
					areaList.put(String.valueOf(obj.getDeptId()), obj.getDeptNm());
			    } 
				
				List<Sauserm> esUserList = secDao.getAllUserByRptUser(deptId, "ES");
				if(esUserList != null){
					int eeCount = esUserList.size()-1;
					for(int x=0;x<=eeCount;x++){
						Sauserm objUser = esUserList.get(x);
						System.out.println("objUser.getUserId() : "+objUser.getUserId());
						
						eeList.put(objUser.getUserId(),objUser.getUserNm());
						System.out.println("eeList : "+eeList.size());
						
					}
				}
				model.setEeList(eeList);
				
			}else{
			
				areaList.put(deptId, gldeptDao.getName(deptId));
				model.setEeList(eeList);
			}
			model.setAreaList(areaList);

			
			model.setLineList(lineList);
			
			
			/*Map<String, String> saList = new LinkedHashMap<String, String>();
			Map<String, String> appList = new LinkedHashMap<String, String>();

			
			List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
			List<Applicant> appliList = applicantDao.getAllApplicantBydeptId(deptId);
			int loopApp = appliList.size() - 1;
			for (int i = 0; i <= loopApp; i++) {
				//System.out.println(i);
				Applicant ojb = appliList.get(i);
				//System.out.println(ojb.getIdNo());
				appList.put(ojb.getIdNo(), ojb.getFullName());

			}

			int loopSa = saUserList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
				//System.out.println(i);
				Sauserm ojb = saUserList.get(i);
				//System.out.println(ojb.getUserId());
				saList.put(ojb.getUserId(), ojb.getUserNm());

			}


model.setSaList(saList);
model.setAppList(appList);
*/			
Map<String, String> provinceList = new LinkedHashMap<String, String>();


/*if(mode.equalsIgnoreCase("PHM")){
	String province = deptDao.getDD(deptId.trim());
	String distDiv = glcompmDao.getDistDivision(province);
	
				List<Glcompm> line = glcompmDao.getProvinces(distDiv);
				List<String> provinces = new ArrayList<String>();
				int loop = line.size() - 1;
				for (int i = 0; i <= loop; i++) {
					System.out.println(i);
					Glcompm ojb = line.get(i);

					System.out.println(ojb.getCompNm());
					provinces.add(ojb.getCompNm());
					provinceList.put(ojb.getCompId(), ojb.getCompNm());

				}
			}
model.setProvinceList(provinceList);
*/			model.setMode(mode);
			System.out.println("finish 22 "+ model.getMode());
			System.out.println("finish 23 "+ model.getMessageType());
			
			ModelAndView mo = new ModelAndView("phmInsRequest", "model",model);
			
			mo.addObject("canGO", canGO);
			mo.addObject("type", mode);
			
			return mo;

		}

		
		
		
		@RequestMapping(value = "/goToInsMntRequestMntReq", method = RequestMethod.GET)
		public ModelAndView goToInsMntRequestMntReq(HttpServletRequest request,@RequestParam("mode") String mode) {
			String deptId = request.getSession().getAttribute("deptId").toString();
			String stringOflineIds = "";
			
			Map<String, String> eeList = new LinkedHashMap<String, String>();
			
			
			String canGO = "1";

			PivModel model = new PivModel();
			List<MmsAddline> liness = addLine.findLineByArea(deptId);
			Map<String,String> lineList = new LinkedHashMap<String,String>();

			int lineLoop = liness.size()-1;
			for(int i=0;i<=lineLoop;i++){ 
				System.out.println(i);
				MmsAddline ojb = liness.get(i);
				lineList.put(String.valueOf(ojb.getId()), ojb.getLineName());
		    }
			
			
			Map<String,String> areaList = new LinkedHashMap<String,String>();
			
			String name = deptDao.getDD(deptId);
			System.out.println("name xx : "+name);
			String province = glcompmDao.getProvince(name);
			System.out.println("province : " + province);
			String dd =glcompmDao.getDistDivision(province);
			System.out.println("dd : " + dd);
			if(dd.equals("DISCO2")){
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR2");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj.getDeptId(), "EE");
					
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
							System.out.println("eeList : "+eeList.size());
							
						}
					}
					
					
				}
			}
				
			}else if(dd.equals("DISCO3")){
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR3");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj.getDeptId(), "EE");
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
						}
					}
					
					
				}
			}
				
			}else if(dd.equals("DISCO1")){
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR1");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj.getDeptId(), "EE");
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
						}
					}
					
					
				}
				}
			}else if(dd.equals("DISCO4")){
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR4");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj.getDeptId(), "EE");
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
						}
					}
					
					
				}
			}
				
			}else{
				
			}
			
			//TrippingData objTripping = new TrippingData();
			//provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
			//models.setProvinceList(provinceList);
			//models.setObjTripping(objTripping);
			//List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId().trim());
			
			
			
			
			
			if(deptId.equalsIgnoreCase("600.41")){
				List<Gldeptm> area = gldeptDao.getArea(deptId);
				int areaListObj = area.size()-1;
				for(int i=0;i<=areaListObj;i++){ 
					System.out.println(i);
					Gldeptm obj = area.get(i);
					areaList.put(String.valueOf(obj.getDeptId()), obj.getDeptNm());
			    } 
				
				List<Sauserm> esUserList = secDao.getAllUserByRptUser(deptId, "ES");
				if(esUserList != null){
					int eeCount = esUserList.size()-1;
					for(int x=0;x<=eeCount;x++){
						Sauserm objUser = esUserList.get(x);
						System.out.println("objUser.getUserId() : "+objUser.getUserId());
						
						eeList.put(objUser.getUserId(),objUser.getUserNm());
						System.out.println("eeList : "+eeList.size());
						
					}
				}
				model.setEeList(eeList);
				
			}else if(deptId.equalsIgnoreCase("780.00")){
				List<Gldeptm> area = gldeptDao.getArea(deptId);
				int areaListObj = area.size()-1;
				for(int i=0;i<=areaListObj;i++){ 
					System.out.println(i);
					Gldeptm obj = area.get(i);
					areaList.put(String.valueOf(obj.getDeptId()), obj.getDeptNm());
			    } 
				
				List<Sauserm> esUserList = secDao.getAllUserByRptUser(deptId, "ES");
				if(esUserList != null){
					int eeCount = esUserList.size()-1;
					for(int x=0;x<=eeCount;x++){
						Sauserm objUser = esUserList.get(x);
						System.out.println("objUser.getUserId() : "+objUser.getUserId());
						
						eeList.put(objUser.getUserId(),objUser.getUserNm());
						System.out.println("eeList : "+eeList.size());
						
					}
				}
				model.setEeList(eeList);
				
			}else{
			
				areaList.put(deptId, gldeptDao.getName(deptId));
				model.setEeList(eeList);
			}
			model.setAreaList(areaList);

			
			model.setLineList(lineList);
			
			
			/*Map<String, String> saList = new LinkedHashMap<String, String>();
			Map<String, String> appList = new LinkedHashMap<String, String>();

			
			List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
			List<Applicant> appliList = applicantDao.getAllApplicantBydeptId(deptId);
			int loopApp = appliList.size() - 1;
			for (int i = 0; i <= loopApp; i++) {
				//System.out.println(i);
				Applicant ojb = appliList.get(i);
				//System.out.println(ojb.getIdNo());
				appList.put(ojb.getIdNo(), ojb.getFullName());

			}

			int loopSa = saUserList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
				//System.out.println(i);
				Sauserm ojb = saUserList.get(i);
				//System.out.println(ojb.getUserId());
				saList.put(ojb.getUserId(), ojb.getUserNm());

			}


model.setSaList(saList);
model.setAppList(appList);
*/			
Map<String, String> provinceList = new LinkedHashMap<String, String>();


/*if(mode.equalsIgnoreCase("PHM")){
	String province = deptDao.getDD(deptId.trim());
	String distDiv = glcompmDao.getDistDivision(province);
	
				List<Glcompm> line = glcompmDao.getProvinces(distDiv);
				List<String> provinces = new ArrayList<String>();
				int loop = line.size() - 1;
				for (int i = 0; i <= loop; i++) {
					System.out.println(i);
					Glcompm ojb = line.get(i);

					System.out.println(ojb.getCompNm());
					provinces.add(ojb.getCompNm());
					provinceList.put(ojb.getCompId(), ojb.getCompNm());

				}
			}
model.setProvinceList(provinceList);
*/			model.setMode(mode);
			System.out.println("finish 22 "+ model.getMode());
			
			ModelAndView mo = new ModelAndView("InspectionMaintenanceRequest", "model",model);
			
			mo.addObject("canGO", canGO);
			mo.addObject("type", mode);
			
			return mo;

		}

		
		
		@RequestMapping(value = "/goToInsMntRequestMNT", method = RequestMethod.GET)
		public ModelAndView goToInsMntRequestMNT(HttpServletRequest request,@RequestParam("mode") String mode) {
			String deptId = request.getSession().getAttribute("deptId").toString();
			String stringOflineIds = "";
			
			String canGO = "1";

			PivModel model = new PivModel();
			//model = loadProLineES(request,model);
			List<MmsAddline> liness = addLine.findLineByArea(deptId);
			/*model.setLineListEdit(liness);
			int lineSize = liness.size() - 1;
			List<Long> lineListnew = new ArrayList<Long>(lineSize);
			for (int i = 0; i <= lineSize; i++) {
				MmsAddline obj = liness.get(i);
				lineListnew.add(obj.getId());
				if (i != 0) { stringOflineIds = stringOflineIds + "," +
				  Long.toString(obj.getId()); } 
				else { stringOflineIds =
				  Long.toString(obj.getId()); }
				 
			}
			System.out.println("else -------------------> stringOflineIds: "+ stringOflineIds);
			model.setListOfLines(lineListnew);
			System.out.println("finish 22 "+ mode);
			*/
			Map<String,String> lineList = new LinkedHashMap<String,String>();

			int lineLoop = liness.size()-1;
			for(int i=0;i<=lineLoop;i++){ 
				System.out.println(i);
				MmsAddline ojb = liness.get(i);
				lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		    } 
			
			Map<String,String> areaList = new LinkedHashMap<String,String>();
			areaList.put(deptId, gldeptDao.getName(deptId));
			model.setAreaList(areaList);

			model.setLineList(lineList);

			model.setMode(mode);
			System.out.println("finish 22 "+ model.getMode());
			
			ModelAndView mo = new ModelAndView("MaintenanceRequest", "model",model);
			
			mo.addObject("canGO", canGO);
			mo.addObject("type", mode);
			
			return mo;

		}

		
	    @RequestMapping(value = "/goToInsMntRequestS", method = RequestMethod.POST)
		public ModelAndView goToInsMntRequestS(HttpServletRequest request,@RequestParam("file") MultipartFile file,@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2,@RequestParam("file3") MultipartFile file3,@RequestParam("file4") MultipartFile file4,@ModelAttribute("model") PivModel model,BindingResult bindingResult) throws Exception{
			ModelAndView mo = null;
			String canGO = "1";
			String deptId = request.getSession().getAttribute("deptId").toString();
			String userName = request.getSession().getAttribute("loggedUser").toString();
			
			String resPHMUnit="";
			System.out.println("resPHMUnit jjjjj" + model.getMessageType());
			String division="";
			String name1 = deptDao.getDD(deptId);
			System.out.println("name xx : "+name1);
			String province12= glcompmDao.getProvince(name1);
			System.out.println("province : " + province12);
			String ddd =glcompmDao.getDistDivision(province12);
			System.out.println("dd : " + ddd);
			if(ddd.equals("DISCO2")){
				division="DD2";
			}else if(ddd.equals("DISCO3")){
				division="DD3";
			}else if(ddd.equals("DISCO4")){
				division="DD4";
			}else if(ddd.equals("DISCO1")){
				division="DD1";				
			}else{
				division="DD2";
			}
			
			if(division!=null){
				if(division.equals("DD2")){
					resPHMUnit="600.41";
					
				}else if(division.equals("DD3")){
					resPHMUnit="780.00";
					
				}
			}else{
			}
			
			System.out.println("resPHMUnitiiiii "+resPHMUnit);
			
			String ee = ""; 
			if(model.getSausermEE() != null){
				ee = model.getSausermEE().getUserId();
				Sauserm sa = secDao.getSauserm(ee);
				if(sa != null){
					resPHMUnit = sa.getRptUser();
					
				}
			}
			
			Map<String, String> eeList = new LinkedHashMap<String, String>();
			Map<String,String> areaList = new LinkedHashMap<String,String>();
			
			System.out.println("resPHMUnit "+resPHMUnit);
			
			SausermMm userMm = null;
			if(model.getSausermEE() != null){
				try {
					
					userMm =secDao.getSausermMms(model.getSausermEE().getUserId());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("model.getSausermEE().getUserId() "+ model.getSausermEE().getUserId());
				
			}
			
			
			
			
			//String deptId = model.getReleventBranch();
			String path1 = PathMMS.getReportPath() + File.separator + "Reports";
    		File dir1 = new File(path1 + File.separator + "Reports");
    		if (!dir1.exists())
				dir1.mkdirs();
    		
    		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
    		File dir2 = new File(path1 + File.separator + "EmailAttachment");
    		if (!dir2.exists())
				dir2.mkdirs();
    			
			//System.out.println("finish 2 "+ model.getLine().getCode());
    		String id = "";
    		MmsAddline obj = null;
    		String line = "";
    		if(model.getLine()!= null){
    			//id = addLine.findIdByCode(model.getLine().getCode());
    			//id = model.getLine().getId();
    			obj =   addLine.findById(model.getLine().getId());
    			line =obj.getLineName();
    			
    		}
			//System.out.println("finish 3 "+line );
			
			//String deptId = request.getSession().getAttribute("deptId").toString();
			String stringOflineIds = "";
			File serverFile = null;
			File serverFile1 = null;
			File serverFile2 = null;
			File serverFile3 = null;
			File serverFile4 = null;
			System.out.println("finish 3 " );
			
			
			String areaName = gldeptDao.getName(deptId);
			if(areaName != null && !areaName.equalsIgnoreCase("")){
				areaName.trim();
			}
			
			HashMap<String, Object> param = new HashMap<String, Object>(3);
			param.put("0", model.getMailContent());
			param.put("1", model.getMailContent2());
			param.put("2", areaName);
			
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date newDate = new Date();
    		String dateString = format.format(newDate);
    		//List<Long> lines = model.getSelectedLines();
    		String lineName ="";
    		lineName = line;
    		String ss =gldeptDao.getDD(deptId);
    		String province = glcompmDao.getProvince(ss);
    		if(province != null){
    			province.trim();
    		}
    		System.out.println("glcompmDao.getDistDivision " + province +"@");
    		String pre_approval_id = "";
    		if(model.getMode().equalsIgnoreCase("INS")){
    			pre_approval_id = Util.INSPECTION_APPROVAL_ID +"-"+deptId;
    		}else if(model.getMode().equalsIgnoreCase("PHM")){
    			pre_approval_id = Util.INSPECTION_APPROVAL_ID +"-"+deptId;
    		}else if(model.getMode().equalsIgnoreCase("PMT")){
    			pre_approval_id = Util.MAINTENANCE_APPROVAL_ID +"-"+deptId;
    		}else{
    			pre_approval_id = Util.MAINTENANCE_APPROVAL_ID+"-"+deptId;
        		
    		}
			
    		String nextNumver = approvalMm.getNextAppId(pre_approval_id);
    		System.out.println("nextNumver 5 "+ nextNumver );
			
    		String approval_id = pre_approval_id + "-" + nextNumver;
    		String pdfFileName = "";
    		
    		ApprovalMm appr = new ApprovalMm();
			
    		String path = PathMMS.getReportPath();
    		File dir = new File(path + File.separator + "InsMntRequest");
    		if (!dir.exists())
				dir.mkdirs();
    		
    		
    		// Create the file on server
			File serverFileOnServer = new File(dir.getAbsolutePath()+ File.separator + pdfFileName);
			    		
    		if (!file.isEmpty()) {
				try {
					String name = file.getOriginalFilename();
					
					String extension = Util.getSubStringFirstPart(name,".");
					
					System.out.println("extention :" +extension);
					
					name = approval_id + "IMG1" + extension;
					byte[] bytes = file.getBytes();
					appr.setFilename1(name);
					serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					
					stream.write(bytes);
					stream.close();
							
					
					
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		System.out.println("finish 6 " );

    		
    		
    		
    		//model.setCycle(approval_id);
    		if(model.getMode().equalsIgnoreCase("INS")){
    			pdfFileName = generateReport("INSREQ","Inspection_Request",param,null,path1,path1,model.getMailContent(),model.getMailContent2(),areaName,lineName,province,approval_id,division,serverFile);
    			
    		}else if(model.getMode().equalsIgnoreCase("PHM")){
    			pdfFileName = generateReport("INSREQ","Inspection_Request",param,null,path1,path1,model.getMailContent(),model.getMailContent2(),areaName,lineName,province,approval_id,division,serverFile);
    			
    		}else if(model.getMode().equalsIgnoreCase("PMT")){
    			pdfFileName = generateReport("MNTREQ","Maintenance_Request",param,null,path1,path1,model.getMailContent(),model.getMailContent2(),areaName,lineName,province,approval_id,division,serverFile);
    			
    		}else{
    			pdfFileName = generateReport("MNTREQ","Maintenance_Request",param,null,path1,path1,model.getMailContent(),model.getMailContent2(),areaName,lineName,province,approval_id,division,serverFile);
    			
    		}
    		
    		File pdfFile = new File(pdfFileName);
			
    					
    		if (!file1.isEmpty()) {
				try {
					String name = file1.getOriginalFilename();
					String extension = Util.getSubStringFirstPart(name,".");
					
					System.out.println("extention :" +extension);
					
					name = approval_id + "IMG2" + extension;
					appr.setFilename2(name);
					
					byte[] bytes = file1.getBytes();

					serverFile1 = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile1));
					
					stream.write(bytes);
					stream.close();
										
					
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		System.out.println("finish 7 " );
			
    		
    		if (!file2.isEmpty()) {
				try {
					String name = file2.getOriginalFilename();
					String extension = Util.getSubStringFirstPart(name,".");
					
					System.out.println("extention :" +extension);
					
					name = approval_id + "IMG3" + extension;
					appr.setFilename3(name);
					
					byte[] bytes = file2.getBytes();

					serverFile2 = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile2));
					
					stream.write(bytes);
					stream.close();
					
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		System.out.println("finish 8 " );
			
    		if (!file3.isEmpty()) {
				try {
					String name = file3.getOriginalFilename();
					String extension = Util.getSubStringFirstPart(name,".");
					
					name = approval_id + "IMG4" + extension;
					appr.setFilename4(name);
					
					byte[] bytes = file3.getBytes();

					serverFile3 = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile3));
					
					stream.write(bytes);
					stream.close();
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		
    		if (!file4.isEmpty()) {
				try {
					String name = file4.getOriginalFilename();
					String extension = Util.getSubStringFirstPart(name,".");
					name = approval_id + "IMG5" + extension;
					appr.setFilename5(name);
					
					byte[] bytes = file4.getBytes();

					serverFile4 = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile4));
					
					stream.write(bytes);
					stream.close();
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		String content = "";
    		String subject = "";
    		String sms_content ="";
    		String pre_approval_id_SMS = "";
    		String approveType = "";
    		String fromStatus = "";
			String toStatus = "";
			String success ="";
			String firstClouse="";
			
			DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date today = new Date();
			String subject_str = subject_str_fm.format(today);
			System.out.println("finish xxxxxxxxxxxxxxx " );
			
			
			if(model.getMode().equalsIgnoreCase("INS")){
	    		
			content = "\n\nInspection request is sent by Area Engineer ("+areaName.trim()+"). Please find the attachments.";
			
			subject ="INSPECTION REQUEST FROM "+areaName + " " + subject_str;
			sms_content ="Inspection request is sent by Area Engineer ("+areaName.trim()+"). Please check your email";
			pre_approval_id_SMS = "SMSMVINSR-"+deptId;
			approveType = "INSREQ";
				fromStatus = "1";
				toStatus = "6";
				success = "Inspetion request successfully sent to PHM ";
				firstClouse ="Chief Engineer/Maintenance Engineer";
				
			}else if(model.getMode().equalsIgnoreCase("PHM")){
	    		
			content = "\n\nInspection request is sent by Maintenace Engineer - PHM. Please find the attachments.";
			
			subject ="Inspection request " + subject_str;
			sms_content ="Inspection request is sent by Maintenace Engineer - PHM . Please check your email";
			pre_approval_id_SMS = "SMSMVINSR-"+deptId;
			approveType = "INSREQ";
				fromStatus = "1";
				toStatus = "99";
				success = "Inspetion request successfully sent to Relevent ES";
				firstClouse =userMm.getUserNm();
				
				
			}else if(model.getMode().equalsIgnoreCase("PMT")){
	    		
				
				System.out.println("finish test MNT " );
				
			content = "\n\nMaintenance request is sent by Maintenace Engineer - PHM. Please find the attachments.";
			
			subject ="Maintenance request " + subject_str;
			sms_content ="Maintenance request is sent by Maintenace Engineer - PHM . Please check your email";
			pre_approval_id_SMS = "SMSMVINSR-"+deptId;
			approveType = "MNTREQ";
				fromStatus = "1";
				toStatus = "99";
				success = "Maintenance request successfully sent to Relevent ES";
				firstClouse =userMm.getUserNm();
				
				
			}
			
			else{
				content = "\n\nMaintenance  request is sent by Area Engineer ("+areaName.trim()+"). Please find the attachments.\n\nThank You.";
				
				subject ="MAINTENANCE REQUEST FROM "+areaName.trim() + " " + subject_str;
				sms_content ="Maintenance  request is sent by Area Engineer ("+areaName.trim()+"). Please check your email.Thank You";
				pre_approval_id_SMS = "SMSMVINSR-"+deptId;
				approveType = "MNTREQ";
					fromStatus = "1";
					toStatus = "6";
					success = "Maintenance request successfully sent to PHM Branch";
					firstClouse ="Chief Engineer/Maintenance Engineer";
					
				
			}
			
			System.out.println("finish yyyyyyyyyyyyyyyyyyyyyy " );
			
			ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
			MailMail mm = (MailMail) context.getBean("mailMail");
			String url="";
			String urlCC="";
			if(model.getMode().equalsIgnoreCase("INS") || model.getMode().equalsIgnoreCase("MNT")){
				
			if(userMm != null){
				if(userMm.getTelNo() != null){
					System.out.println("userMm.getTelNo() " + userMm.getTelNo());
					
					url="http://smsgw.ceb/SMSPlatform.php?recipients="+userMm.getTelNo().trim()+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					resPHMUnit = resPHMUnit.trim();
					
					if(resPHMUnit.equalsIgnoreCase("600.41")){
						urlCC="http://smsgw.ceb/SMSPlatform.php?recipients="+Util.telcephmcp+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
						
					}else if(resPHMUnit.equalsIgnoreCase("780.00")){
						urlCC="http://smsgw.ceb/SMSPlatform.php?recipients="+Util.telcephmdd3+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
						
					}else{
						
					}
				
				
				}else{
					//url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+userMm.getUserId()+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					
				}
				
			}else{
				//url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+userMm.getUserId()+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
				
			}
			
			}else{
				
				System.out.println("PHM MNT");
				
				SausermMm loggetedUser = null;
				if(userName != null){
					try {
						
						loggetedUser =secDao.getSausermMms(userName);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				System.out.println("PHM MNT loggetedUser:"+loggetedUser);
				
				SausermMm releventES = null;
				if(model.getSausermEE() != null){
					try {
						
						releventES =secDao.getSausermMms(model.getSausermEE().getUserId().trim());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				System.out.println("PHM MNT model.getSausermEE().getUserId().trim():"+model.getSausermEE().getUserId().trim());
				
				
				System.out.println("PHM MNT releventES:"+releventES);
				
				
				if(loggetedUser != null){
					if(loggetedUser.getTelNo() != null){
						url="http://smsgw.ceb/SMSPlatform.php?recipients="+loggetedUser.getTelNo().trim()+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
						if(releventES != null){
							if(releventES.getEmail()!= null){
								urlCC="http://smsgw.ceb/SMSPlatform.php?recipients="+releventES.getTelNo().trim()+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
								}
							else{
								//urlCC="http://smsgw.ceb/SMSPlatform.php?recipients="+releventES.getTelNo().trim()+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
								}
						}
					
					}else{
						//url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+loggetedUser.getUserId()+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
						
					}
					
				}else{
					//url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+loggetedUser.getUserId()+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					
				}
				
				
				
				
			}
			//PHM INS MNT
			
			if(model.getMode().equalsIgnoreCase("INS") || model.getMode().equalsIgnoreCase("MNT")){
				System.out.println("AREA MNT releventES:"+userMm.getEmail());
				
				if(userMm != null){
					if(userMm.getEmail() != null){
						
							String[] emailList = new String[3];
							emailList[0] =Util.searchEmail(deptId);
							System.out.println("AREA Email:"+Util.searchEmail(deptId));
							resPHMUnit = resPHMUnit.trim();
							if(resPHMUnit.equalsIgnoreCase("600.41")){
								
								//
								emailList[1] ="mnmnihaj@gmail.com";
							}else if(resPHMUnit.equalsIgnoreCase("780.00")){
								emailList[1] =Util.cephmdd3;

							}
							emailList[2] ="eranga.bogahakumbura@gmail.com";
							
							mm.sendMailTo(firstClouse, content ,"gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
							mm.sendMailTo(firstClouse, content ,userMm.getEmail(),emailList,subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);

						}
					}else{
						mm.sendMailTo(firstClouse, content+ userMm.getUserId() ,"gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
						
					}
					
						
			
			
			}else{
				
				SausermMm loggetedUser = null;
				if(userName != null){
					try {
						
						loggetedUser =secDao.getSausermMms(userName);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				SausermMm releventES = null;
				if(model.getSausermEE() != null){
					try {
						System.out.println("PHM MNT model.getSausermEE().getUserId().trim():"+model.getSausermEE().getUserId().trim());
						
						releventES =secDao.getSausermMms(model.getSausermEE().getUserId().trim());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				System.out.println("PHM MNT releventES:"+releventES.getEmail());
				System.out.println("loggetedUser:"+loggetedUser.getEmail());
				
				if(loggetedUser != null){
					if(loggetedUser.getEmail() != null){
						
							String[] emailList = new String[2];
							emailList[0] =loggetedUser.getEmail();
							
							emailList[1] ="gchampika28@gmail.com";
							
							mm.sendMailTo(firstClouse, content ,"gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
							//if(resPHMUnit.equalsIgnoreCase("600.41")){
							if(releventES != null){
								if(releventES.getEmail()!= null){
									mm.sendMailTo(firstClouse, content ,releventES.getEmail(),emailList,subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
								}
								else{
									//mm.sendMailTo(firstClouse, content ,releventES.getEmail(),emailList,subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
								}
							}
					}
					
						//}else if(resPHMUnit.equalsIgnoreCase("780.00")){
							//mm.sendMailTo(firstClouse, content ,userMm.getEmail(),emailList,subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);

						//}
					}else{
						//mm.sendMailTo(firstClouse, content+ userMm.getUserId() ,"gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
						
					}
					
				
			}
			
			
			
			
			
			
						
			/*
System.out.println("userMm.getTelNo() " + userMm.getTelNo());
					

			
			//Util.trustEveryone();
			mm.sendMailTo("Chief Engineer / Maintenance Engineer", content ,"gchampika28@gmail.com","gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
			//url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			
			
			mm.sendMailTo("Chief Engineer / Maintenance Engineer", content ,"eranga.bogahakumbura@gmail.com","alagodas1@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
//	       url="http://smsgw.ceb/SMSPlatform.php?recipients=0718716913&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
	//		urlCC="http://smsgw.ceb/SMSPlatform.php?recipients=0713841267&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			//url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
*/			
			System.out.println("finish 1 " );
			Date date = new Date();
			
			
			
			RestTemplate restTemplate = new RestTemplate();
			
			
			System.out.println("sendSMS 2" );

			
			//urlCC="http://smsgw.ceb/SMSPlatform.php?recipients=0713841267&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			//
			//String url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			
			System.out.println("sendSMS 3" );

			try {
				//Util.trustEveryone();
				restTemplate.getForObject(url, String.class);
				System.out.println("sendSMS 77" );

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("sendSMS 78"+ e1.getMessage() );

				e1.printStackTrace();
			}
			
			try {
				//Util.trustEveryone();
				if(!urlCC.equalsIgnoreCase("")){
					restTemplate.getForObject(urlCC, String.class);
					
				}
				System.out.println("sendSMS 99" );

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("sendSMS 99"+ e1.getMessage() );

				e1.printStackTrace();
			}

			System.out.println("sendSMS 4" );
			
			
			
			
			
			String enterDate = sdf.format(date);
			
			
			String approval_id_SMS = pre_approval_id_SMS + "-" + nextNumver;
			
			String refrence = areaName;
			String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
			System.out.println("finish 2 " );
			
			String approvedBy = request.getSession().getAttribute("loggedUser").toString();
			
			
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

    		Date date2 = null;
			try {
				String dateString1 = format.format(date);
				date2 = format.parse (dateString1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    

    		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");

    		String timeString = format2.format(date);
    		System.out.println("finish 3 " );
			
			
			
			appr.setApprovalId(approval_id);
			System.out.println("finish 6 " +approval_id);
			appr.setReferenceNo(refrence);
			String reason = "Requirement : "+ model.getMailContent2();
			System.out.println("reason " + reason);
			
			appr.setReason(reason);
			appr.setReq1(model.getMailContent());
			appr.setReq2(model.getMailContent2() + "From : "+ model.getFrom() +" To : "+ model.getTo());
			
			System.out.println("finish 8 " +reason);
			appr.setEsName(lineName);
			appr.setDeptId(deptId);
			System.out.println("finish 9 "+ deptId );
			appr.setPhmBranch(resPHMUnit);
			appr.setApprovalType(approveType);
			if(deptId.equalsIgnoreCase("600.41")){
				appr.setEs(ee);
				appr.setEe(userName);
			}else if(deptId.equalsIgnoreCase("780.00")){
				appr.setEs(ee);
				appr.setEe(userName);
			}else{
				appr.setEe(ee);
			}
			
			System.out.println("finish 10 " +approveType);
			
			appr.setApprovedLevel(approveLevel);
			System.out.println("finish 11 "+ approveType );
			
			appr.setFromStatus(fromStatus);
			System.out.println("finish 12 "+ fromStatus);
			
			appr.setToStatus(toStatus);
			System.out.println("finish 13 "+ toStatus );
			
			appr.setApprovedDate(date2);
			System.out.println("finish 14 " + dateString);
			
			appr.setApprovedTime(timeString);
			System.out.println("finish 15 "+ timeString );
			
			appr.setApprovedBy(approvedBy);
			System.out.println("finish 16 "+ approvedBy);
			
			
			try {
				
				/*if(model.getMode().equalsIgnoreCase("PHM")){
					System.out.println("finish 16 PHM");
					
					String userName = request.getSession().getAttribute("loggedUser").toString();
					String allocated_To =  model.getSauserm().getUserId();
					Application application = createApplicationObject(deptId,userName,model);
					System.out.println("allocated_To  1"); 
					String estimateNo = appDao.saveSPS(deptId,userName,allocated_To,application, model);
					appr.setToStatus("98");
					appr.setSystemBy(estimateNo);
				}
				*/
				approvalMm.addApproval(appr);
				
				
				
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<MmsAddline> liness = addLine.findLineByArea(deptId);
			Map<String,String> lineList = new LinkedHashMap<String,String>();

			int lineLoop = liness.size()-1;
			for(int i=0;i<=lineLoop;i++){ 
				System.out.println(i);
				MmsAddline ojb = liness.get(i);
				lineList.put(String.valueOf(ojb.getId()), ojb.getLineName());
		    } 
			
			
			
			
			String name = deptDao.getDD(deptId);
			System.out.println("name xx : "+name);
			String province1 = glcompmDao.getProvince(name);
			System.out.println("province : " + province);
			String dd =glcompmDao.getDistDivision(province1);
			System.out.println("dd : " + dd);
			if(dd.equals("DISCO2")){
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR2");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj1 = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj1.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj1.getDeptId(), "EE");
					
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
							System.out.println("eeList : "+eeList.size());
							
						}
					}
					
					
				}
			}
				
			}else if(dd.equals("DISCO3")){
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR3");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj1 = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj1.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj1.getDeptId(), "EE");
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
						}
					}
					
					
				}
			}
				
			}else if(dd.equals("DISCO1")){
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR1");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj1 = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj1.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj1.getDeptId(), "EE");
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
						}
					}
					
					
				}
				}
			}else if(dd.equals("DISCO4")){
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR4");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj1 = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj1.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj1.getDeptId(), "EE");
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
						}
					}
					
					
				}
			}
				
			}else{
				
			}
			
			//TrippingData objTripping = new TrippingData();
			//provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
			//models.setProvinceList(provinceList);
			//models.setObjTripping(objTripping);
			//List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId().trim());
			
			
			
			
			
			if(deptId.equalsIgnoreCase("600.41")){
				List<Gldeptm> area = gldeptDao.getAreaByProvince("CP");
				int areaListObj = area.size()-1;
				for(int i=0;i<=areaListObj;i++){ 
					System.out.println(i);
					Gldeptm obj1 = area.get(i);
					areaList.put(String.valueOf(obj1.getDeptId()), obj1.getDeptNm());
			    } 
				
				List<Sauserm> esUserList = secDao.getAllUserByRptUser(deptId, "ES");
				if(esUserList != null){
					int eeCount = esUserList.size()-1;
					for(int x=0;x<=eeCount;x++){
						Sauserm objUser = esUserList.get(x);
						System.out.println("objUser.getUserId() : "+objUser.getUserId());
						
						eeList.put(objUser.getUserId(),objUser.getUserNm());
						System.out.println("eeList : "+eeList.size());
						
					}
				}
				model.setEeList(eeList);
				
			}else{
			
				areaList.put(deptId, gldeptDao.getName(deptId));
				model.setEeList(eeList);
			}
			model.setAreaList(areaList);

			
			model.setLineList(lineList);


			model.setMessage(success);
			model.setMailContent("");
			model.setMailContent2("");
			model.setFrom("");
			model.setTo("");
			mo = new ModelAndView("InspectionMaintenanceRequest", "model",model);
			
			mo.addObject("canGO", canGO);
			if(model.getMode().equalsIgnoreCase("INS")){
				mo.addObject("type", "INS");
			}else if(model.getMode().equalsIgnoreCase("MNT")){
				mo.addObject("type", "MNT");
			}else if(model.getMode().equalsIgnoreCase("PMT")){
				mo.addObject("type", "PMT");
			}else{
				mo.addObject("type", "PHM");
			}
			
			return mo;

		}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    @RequestMapping(value = "/goToInsMntRequestMntS", method = RequestMethod.POST)
		public ModelAndView goToInsMntRequestMntS(HttpServletRequest request,@RequestParam("file") MultipartFile file,@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2,@RequestParam("file3") MultipartFile file3,@RequestParam("file4") MultipartFile file4,@ModelAttribute("model") PivModel model,BindingResult bindingResult) throws Exception{
			ModelAndView mo = null;
			String canGO = "1";
			String deptId = request.getSession().getAttribute("deptId").toString();
			String resPHMUnit="600.41";
			String ee = ""; 
			if(model.getSausermEE() != null){
				ee = model.getSausermEE().getUserId();
				Sauserm sa = secDao.getSauserm(ee);
				if(sa != null){
					resPHMUnit = sa.getRptUser();
					
				}
			}
			
			Map<String, String> eeList = new LinkedHashMap<String, String>();
			Map<String,String> areaList = new LinkedHashMap<String,String>();
			
			System.out.println("resPHMUnit "+resPHMUnit);
			
			SausermMm userMm = null;
			if(model.getSausermEE() != null){
				try {
					
					userMm =secDao.getSausermMms(model.getSausermEE().getUserId());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("model.getSausermEE().getUserId() "+ model.getSausermEE().getUserId());
				
			}
			
			
			//String deptId = model.getReleventBranch();
			String path1 = PathMMS.getReportPath() + File.separator + "Reports";
    		File dir1 = new File(path1 + File.separator + "Reports");
    		if (!dir1.exists())
				dir1.mkdirs();
    		
    		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
    		File dir2 = new File(path1 + File.separator + "EmailAttachment");
    		if (!dir2.exists())
				dir2.mkdirs();
    			
			//System.out.println("finish 2 "+ model.getLine().getCode());
    		String id = "";
    		MmsAddline obj = null;
    		String line = "";
    		if(model.getLine()!= null){
    			//id = addLine.findIdByCode(model.getLine().getCode());
    			//id = model.getLine().getId();
    			obj =   addLine.findById(model.getLine().getId());
    			line =obj.getLineName();
    			
    		}
			//System.out.println("finish 3 "+line );
			
			//String deptId = request.getSession().getAttribute("deptId").toString();
			String stringOflineIds = "";
			File serverFile = null;
			File serverFile1 = null;
			File serverFile2 = null;
			File serverFile3 = null;
			File serverFile4 = null;
			System.out.println("finish 3 " );
			
			
			String areaName = gldeptDao.getName(deptId);
			if(areaName != null && !areaName.equalsIgnoreCase("")){
				areaName.trim();
			}
			
			HashMap<String, Object> param = new HashMap<String, Object>(3);
			param.put("0", model.getMailContent());
			param.put("1", model.getMailContent2());
			param.put("2", areaName);
			
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date newDate = new Date();
    		String dateString = format.format(newDate);
    		//List<Long> lines = model.getSelectedLines();
    		String lineName ="";
    		lineName = line;
    		String ss =gldeptDao.getDD(deptId);
    		String province = glcompmDao.getProvince(ss);
    		if(province != null){
    			province.trim();
    		}
    		System.out.println("glcompmDao.getDistDivision " + province +"@");
    		String pre_approval_id = "";
    		if(model.getMode().equalsIgnoreCase("INS")){
    			pre_approval_id = Util.INSPECTION_APPROVAL_ID +"-"+deptId;
    		}else if(model.getMode().equalsIgnoreCase("PHM")){
    			pre_approval_id = Util.INSPECTION_APPROVAL_ID +"-"+deptId;
    		}else if(model.getMode().equalsIgnoreCase("PMT")){
    			pre_approval_id = Util.MAINTENANCE_APPROVAL_ID +"-"+deptId;
    		}else{
    			pre_approval_id = Util.MAINTENANCE_APPROVAL_ID+"-"+deptId;
        		
    		}
			
    		String nextNumver = approvalMm.getNextAppId(pre_approval_id);
    		System.out.println("nextNumver 5 "+ nextNumver );
			
    		String approval_id = pre_approval_id + "-" + nextNumver;
    		String pdfFileName = "";
    		
    		ApprovalMm appr = new ApprovalMm();
			
    		String path = PathMMS.getReportPath();
    		File dir = new File(path + File.separator + "InsMntRequest");
    		if (!dir.exists())
				dir.mkdirs();
    		
    		
    		// Create the file on server
			File serverFileOnServer = new File(dir.getAbsolutePath()+ File.separator + pdfFileName);
			    		
    		if (!file.isEmpty()) {
				try {
					String name = file.getOriginalFilename();
					
					String extension = Util.getSubStringFirstPart(name,".");
					
					System.out.println("extention :" +extension);
					
					name = approval_id + "IMG1" + extension;
					byte[] bytes = file.getBytes();
					appr.setFilename1(name);
					serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					
					stream.write(bytes);
					stream.close();
							
					
					
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		System.out.println("finish 6 " );

    		
    		
    		
    		//model.setCycle(approval_id);
    		if(model.getMode().equalsIgnoreCase("INS")){
    			pdfFileName = generateReport("INSREQ","Inspection_Request",param,null,path1,path1,model.getMailContent(),model.getMailContent2(),areaName,lineName,province,approval_id,"",serverFile);
    			
    		}else if(model.getMode().equalsIgnoreCase("PHM")){
    			pdfFileName = generateReport("INSREQ","Inspection_Request",param,null,path1,path1,model.getMailContent(),model.getMailContent2(),areaName,lineName,province,approval_id,"",serverFile);
    			
    		}else if(model.getMode().equalsIgnoreCase("PMT")){
    			pdfFileName = generateReport("MNTREQ","Maintenance_Request",param,null,path1,path1,model.getMailContent(),model.getMailContent2(),areaName,lineName,province,approval_id,"",serverFile);
    			
    		}else{
    			pdfFileName = generateReport("MNTREQ","Maintenance_Request",param,null,path1,path1,model.getMailContent(),model.getMailContent2(),areaName,lineName,province,approval_id,"",serverFile);
    			
    		}
    		
    		File pdfFile = new File(pdfFileName);
			
    					
    		if (!file1.isEmpty()) {
				try {
					String name = file1.getOriginalFilename();
					String extension = Util.getSubStringFirstPart(name,".");
					
					System.out.println("extention :" +extension);
					
					name = approval_id + "IMG2" + extension;
					appr.setFilename2(name);
					
					byte[] bytes = file1.getBytes();

					serverFile1 = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile1));
					
					stream.write(bytes);
					stream.close();
										
					
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		System.out.println("finish 7 " );
			
    		
    		if (!file2.isEmpty()) {
				try {
					String name = file2.getOriginalFilename();
					String extension = Util.getSubStringFirstPart(name,".");
					
					System.out.println("extention :" +extension);
					
					name = approval_id + "IMG3" + extension;
					appr.setFilename3(name);
					
					byte[] bytes = file2.getBytes();

					serverFile2 = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile2));
					
					stream.write(bytes);
					stream.close();
					
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		System.out.println("finish 8 " );
			
    		if (!file3.isEmpty()) {
				try {
					String name = file3.getOriginalFilename();
					String extension = Util.getSubStringFirstPart(name,".");
					
					name = approval_id + "IMG4" + extension;
					appr.setFilename4(name);
					
					byte[] bytes = file3.getBytes();

					serverFile3 = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile3));
					
					stream.write(bytes);
					stream.close();
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		
    		if (!file4.isEmpty()) {
				try {
					String name = file4.getOriginalFilename();
					String extension = Util.getSubStringFirstPart(name,".");
					name = approval_id + "IMG5" + extension;
					appr.setFilename5(name);
					
					byte[] bytes = file4.getBytes();

					serverFile4 = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile4));
					
					stream.write(bytes);
					stream.close();
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		String content = "";
    		String subject = "";
    		String sms_content ="";
    		String pre_approval_id_SMS = "";
    		String approveType = "";
    		String fromStatus = "";
			String toStatus = "";
			String success ="";
			String firstClouse="";
			
			DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date today = new Date();
			String subject_str = subject_str_fm.format(today);
			System.out.println("finish xxxxxxxxxxxxxxx " );
			
			
			if(model.getMode().equalsIgnoreCase("INS")){
	    		
			content = "\n\nInspection request is sent by Area Engineer ("+areaName.trim()+"). Please find the attachments.";
			
			subject ="INSPECTION REQUEST FROM "+areaName + " " + subject_str;
			sms_content ="Inspection request is sent by Area Engineer ("+areaName.trim()+"). Please check your email";
			pre_approval_id_SMS = "SMSMVINSR-"+deptId;
			approveType = "INSREQ";
				fromStatus = "1";
				toStatus = "6";
				success = "Inspetion request successfully sent to PHM ";
				firstClouse ="Chief Engineer/Maintenance Engineer";
				
			}else if(model.getMode().equalsIgnoreCase("PHM")){
	    		
			content = "\n\nInspection request is sent by Maintenace Engineer - PHM. Please find the attachments.";
			
			subject ="Inspection request " + subject_str;
			sms_content ="Inspection request is sent by Maintenace Engineer - PHM . Please check your email";
			pre_approval_id_SMS = "SMSMVINSR-"+deptId;
			approveType = "INSREQ";
				fromStatus = "1";
				toStatus = "99";
				success = "Inspetion request successfully sent to Relevent ES";
				firstClouse =userMm.getUserNm();
				
				
			}else if(model.getMode().equalsIgnoreCase("PMT")){
	    		
			content = "\n\nMaintenance request is sent by Maintenace Engineer - PHM. Please find the attachments.";
			
			subject ="Maintenance request " + subject_str;
			sms_content ="nMaintenance request is sent by Maintenace Engineer - PHM . Please check your email";
			pre_approval_id_SMS = "SMSMVINSR-"+deptId;
			approveType = "MNTREQ";
				fromStatus = "1";
				toStatus = "99";
				success = "Maintenance request successfully sent to Relevent ES";
				firstClouse =userMm.getUserNm();
				
				
			}
			
			else{
				content = "\n\nMaintenance  request is sent by Area Engineer ("+areaName.trim()+"). Please find the attachments.\n\nThank You.";
				
				subject ="MAINTENANCE REQUEST FROM "+areaName.trim() + " " + subject_str;
				sms_content ="Maintenance  request is sent by Area Engineer ("+areaName.trim()+"). Please check your email.Thank You";
				pre_approval_id_SMS = "SMSMVINSR-"+deptId;
				approveType = "MNTREQ";
					fromStatus = "1";
					toStatus = "6";
					success = "Maintenance request successfully sent to PHM Branch";
					firstClouse ="Chief Engineer/Maintenance Engineer";
					
				
			}
			
			System.out.println("finish yyyyyyyyyyyyyyyyyyyyyy " );
			
			ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
			MailMail mm = (MailMail) context.getBean("mailMail");
			String url="";
			String urlCC="";
			
			if(userMm != null){
				if(userMm.getTelNo() != null){
					System.out.println("userMm.getTelNo() " + userMm.getTelNo());
					
					url="http://smsgw.ceb/SMSPlatform.php?recipients="+userMm.getTelNo().trim()+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					if(resPHMUnit.equalsIgnoreCase("600.41")){
						urlCC="http://smsgw.ceb/SMSPlatform.php?recipients=0714565970&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
						
					}
				
				
				}else{
					url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+userMm.getUserId()+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					
				}
				
			}else{
				url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+userMm.getUserId()+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
				
			}
			
			if(userMm != null){
				if(userMm.getEmail() != null){
					System.out.println("userMm.getEmail() "+ userMm.getEmail());
					
					mm.sendMailTo(firstClouse, content ,userMm.getEmail(),subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
			        mm.sendMailTo(firstClouse, content ,"gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
					if(resPHMUnit.equalsIgnoreCase("600.41")){
						mm.sendMailTo(firstClouse, content ,userMm.getEmail(),"mnmnihaj@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);

					}
				}else{
					mm.sendMailTo(firstClouse, content+ userMm.getUserId() ,"gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
					
				}
				
			}else{
				mm.sendMailTo(firstClouse, content + userMm.getUserId() ,"gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
				
			}
			
			/*


			
			//Util.trustEveryone();
			mm.sendMailTo("Chief Engineer / Maintenance Engineer", content ,"gchampika28@gmail.com","gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
			//url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			
			
			mm.sendMailTo("Chief Engineer / Maintenance Engineer", content ,"eranga.bogahakumbura@gmail.com","alagodas1@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
//	       url="http://smsgw.ceb/SMSPlatform.php?recipients=0718716913&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
	//		urlCC="http://smsgw.ceb/SMSPlatform.php?recipients=0713841267&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			//url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
*/			
			System.out.println("finish 1 " );
			Date date = new Date();
			
			
			
			RestTemplate restTemplate = new RestTemplate();
			
			
			System.out.println("sendSMS 2" );

			
			//urlCC="http://smsgw.ceb/SMSPlatform.php?recipients=0713841267&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			//
			//String url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			
			System.out.println("sendSMS 3" );

			try {
				//Util.trustEveryone();
				restTemplate.getForObject(url, String.class);
				System.out.println("sendSMS 77" );

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("sendSMS 78"+ e1.getMessage() );

				e1.printStackTrace();
			}
			
			try {
				//Util.trustEveryone();
				if(!urlCC.equalsIgnoreCase("")){
					restTemplate.getForObject(urlCC, String.class);
					
				}
				System.out.println("sendSMS 99" );

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("sendSMS 99"+ e1.getMessage() );

				e1.printStackTrace();
			}

			System.out.println("sendSMS 4" );
			
			
			
			
			
			String enterDate = sdf.format(date);
			
			
			String approval_id_SMS = pre_approval_id_SMS + "-" + nextNumver;
			
			String refrence = areaName;
			String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
			System.out.println("finish 2 " );
			
			String approvedBy = request.getSession().getAttribute("loggedUser").toString();
			
			
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

    		Date date2 = null;
			try {
				String dateString1 = format.format(date);
				date2 = format.parse (dateString1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    

    		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");

    		String timeString = format2.format(date);
    		System.out.println("finish 3 " );
			
			
			
			appr.setApprovalId(approval_id);
			System.out.println("finish 6 " +approval_id);
			appr.setReferenceNo(refrence);
			String reason = "Requirement : "+ model.getMailContent2();
			System.out.println("reason " + reason);
			
			appr.setReason(reason);
			appr.setReq1(model.getMailContent());
			appr.setReq2(model.getMailContent2() + "From : "+ model.getFrom() +" To : "+ model.getTo());
			
			System.out.println("finish 8 " +reason);
			appr.setEsName(lineName);
			appr.setDeptId(deptId);
			System.out.println("finish 9 "+ deptId );
			appr.setPhmBranch(resPHMUnit);
			appr.setApprovalType(approveType);
			if(deptId.equalsIgnoreCase("600.41")){
				appr.setEs(ee);
			}else{
				appr.setEe(ee);
			}
			
			System.out.println("finish 10 " +approveType);
			
			appr.setApprovedLevel(approveLevel);
			System.out.println("finish 11 "+ approveType );
			
			appr.setFromStatus(fromStatus);
			System.out.println("finish 12 "+ fromStatus);
			
			appr.setToStatus(toStatus);
			System.out.println("finish 13 "+ toStatus );
			
			appr.setApprovedDate(date2);
			System.out.println("finish 14 " + dateString);
			
			appr.setApprovedTime(timeString);
			System.out.println("finish 15 "+ timeString );
			
			appr.setApprovedBy(approvedBy);
			System.out.println("finish 16 "+ approvedBy);
			
			
			try {
				
				/*if(model.getMode().equalsIgnoreCase("PHM")){
					System.out.println("finish 16 PHM");
					
					String userName = request.getSession().getAttribute("loggedUser").toString();
					String allocated_To =  model.getSauserm().getUserId();
					Application application = createApplicationObject(deptId,userName,model);
					System.out.println("allocated_To  1"); 
					String estimateNo = appDao.saveSPS(deptId,userName,allocated_To,application, model);
					appr.setToStatus("98");
					appr.setSystemBy(estimateNo);
				}
				*/
				approvalMm.addApproval(appr);
				
				
				
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<MmsAddline> liness = addLine.findLineByArea(deptId);
			Map<String,String> lineList = new LinkedHashMap<String,String>();

			int lineLoop = liness.size()-1;
			for(int i=0;i<=lineLoop;i++){ 
				System.out.println(i);
				MmsAddline ojb = liness.get(i);
				lineList.put(String.valueOf(ojb.getId()), ojb.getLineName());
		    } 
			
			
			
			
			String name = deptDao.getDD(deptId);
			System.out.println("name xx : "+name);
			String province1 = glcompmDao.getProvince(name);
			System.out.println("province : " + province);
			String dd =glcompmDao.getDistDivision(province1);
			System.out.println("dd : " + dd);
			if(dd.equals("DISCO2")){
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR2");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj1 = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj1.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj1.getDeptId(), "EE");
					
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
							System.out.println("eeList : "+eeList.size());
							
						}
					}
					
					
				}
			}
				
			}else if(dd.equals("DISCO3")){
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR3");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj1 = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj1.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj1.getDeptId(), "EE");
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
						}
					}
					
					
				}
			}
				
			}else if(dd.equals("DISCO1")){
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR1");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj1 = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj1.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj1.getDeptId(), "EE");
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
						}
					}
					
					
				}
				}
			}else if(dd.equals("DISCO4")){
				List<Gldeptm> deptTm = gldeptDao.getDeptIdByCompId("PHMR4");
				if(deptTm != null){
				int deptCount = deptTm.size()-1;
				for(int i=0;i<=deptCount;i++){
					
					Gldeptm obj1 = deptTm.get(i);
					System.out.println("obj.getDeptId() : "+obj1.getDeptId());
					
					List<Sauserm> saUserList = secDao.getAllUserByRptUser(obj1.getDeptId(), "EE");
					if(saUserList != null){
						int eeCount = saUserList.size()-1;
						for(int x=0;x<=eeCount;x++){
							Sauserm objUser = saUserList.get(x);
							System.out.println("objUser.getUserId() : "+objUser.getUserId());
							
							eeList.put(objUser.getUserId(),objUser.getUserNm());
						}
					}
					
					
				}
			}
				
			}else{
				
			}
			
			//TrippingData objTripping = new TrippingData();
			//provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
			//models.setProvinceList(provinceList);
			//models.setObjTripping(objTripping);
			//List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId().trim());
			
			
			
			
			
			if(deptId.equalsIgnoreCase("600.41")){
				List<Gldeptm> area = gldeptDao.getAreaByProvince("CP");
				int areaListObj = area.size()-1;
				for(int i=0;i<=areaListObj;i++){ 
					System.out.println(i);
					Gldeptm obj1 = area.get(i);
					areaList.put(String.valueOf(obj1.getDeptId()), obj1.getDeptNm());
			    } 
				
				List<Sauserm> esUserList = secDao.getAllUserByRptUser(deptId, "ES");
				if(esUserList != null){
					int eeCount = esUserList.size()-1;
					for(int x=0;x<=eeCount;x++){
						Sauserm objUser = esUserList.get(x);
						System.out.println("objUser.getUserId() : "+objUser.getUserId());
						
						eeList.put(objUser.getUserId(),objUser.getUserNm());
						System.out.println("eeList : "+eeList.size());
						
					}
				}
				model.setEeList(eeList);
				
			}else{
			
				areaList.put(deptId, gldeptDao.getName(deptId));
				model.setEeList(eeList);
			}
			model.setAreaList(areaList);

			
			model.setLineList(lineList);


			model.setMessage(success);
			model.setMailContent("");
			model.setMailContent2("");
			model.setFrom("");
			model.setTo("");
			mo = new ModelAndView("InspectionMaintenanceRequestMnt", "model",model);
			
			mo.addObject("canGO", canGO);
			if(model.getMode().equalsIgnoreCase("INS")){
				mo.addObject("type", "INS");
			}else if(model.getMode().equalsIgnoreCase("MNT")){
				mo.addObject("type", "MNT");
			}else if(model.getMode().equalsIgnoreCase("PMT")){
				mo.addObject("type", "PMT");
			}else{
				mo.addObject("type", "PHM");
			}
			
			return mo;

		}




		/*@RequestMapping(value = "/goToInsMntRequestSMNT", method = RequestMethod.POST)
		public ModelAndView goToInsMntRequestSMNT(HttpServletRequest request,@RequestParam("file") MultipartFile file,@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2,@RequestParam("file3") MultipartFile file3,@RequestParam("file4") MultipartFile file4,@ModelAttribute("model") PivModel model) {
			
			ModelAndView mo = null;
			String canGO = "1";
			String deptId = request.getSession().getAttribute("deptId").toString();
			
			if(model.getMailContent() == null || model.getMailContent().equals("")){
				List<MmsAddline> liness = addLine.findLineByArea(deptId);
				Map<String,String> lineList = new LinkedHashMap<String,String>();

				int lineLoop = liness.size()-1;
				for(int i=0;i<=lineLoop;i++){ 
					System.out.println(i);
					MmsAddline ojb = liness.get(i);
					lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
			    } 
				
				
				model.setLineList(lineList);
				Map<String,String> areaList = new LinkedHashMap<String,String>();
				areaList.put(deptId, gldeptDao.getName(deptId));
				model.setAreaList(areaList);


				
				
				model.setError("Requirement	may not be empty");
				
				mo = new ModelAndView("InspectionMaintenanceRequest", "model",model);
				
				mo.addObject("canGO", canGO);
				mo.addObject("type", "INS");
				
				//mo.addObject("success", "Inspetion request successfully sent to PHM DD2 ");
				
				return mo;
			}
			
			
			if(model.getMailContent2() == null || model.getMailContent2().equals("")){
				List<MmsAddline> liness = addLine.findLineByArea(deptId);
				Map<String,String> lineList = new LinkedHashMap<String,String>();

				int lineLoop = liness.size()-1;
				for(int i=0;i<=lineLoop;i++){ 
					System.out.println(i);
					MmsAddline ojb = liness.get(i);
					lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
			    } 
				
				
				model.setLineList(lineList);
				Map<String,String> areaList = new LinkedHashMap<String,String>();
				areaList.put(deptId, gldeptDao.getName(deptId));
				model.setAreaList(areaList);


				
				
				model.setError("Requesting section/s to be inspected may not be empty");
				
				mo = new ModelAndView("InspectionMaintenanceRequest", "model",model);
				
				mo.addObject("canGO", canGO);
				mo.addObject("type", "INS");
				
				//mo.addObject("success", "Inspetion request successfully sent to PHM DD2 ");
				
				return mo;
			}
			System.out.println("finish 2 "+ model.getLine().getCode());
    		
			if(model.getLine().getCode().equals("NONE")){
				List<MmsAddline> liness = addLine.findLineByArea(deptId);
				Map<String,String> lineList = new LinkedHashMap<String,String>();

				int lineLoop = liness.size()-1;
				for(int i=0;i<=lineLoop;i++){ 
					System.out.println(i);
					MmsAddline ojb = liness.get(i);
					lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
			    } 
				
				
				model.setLineList(lineList);
				Map<String,String> areaList = new LinkedHashMap<String,String>();
				areaList.put(deptId, gldeptDao.getName(deptId));
				model.setAreaList(areaList);


				
				
				model.setError("Please select the relevent line");
				
				mo = new ModelAndView("InspectionMaintenanceRequest", "model",model);
				
				mo.addObject("canGO", canGO);
				mo.addObject("type", "INS");
				
				//mo.addObject("success", "Inspetion request successfully sent to PHM DD2 ");
				
				return mo;
			}
			

			
			
			
			String path1 = PathMMS.getReportPath() + File.separator + "Reports";
    		File dir1 = new File(path1 + File.separator + "Reports");
    		if (!dir1.exists())
				dir1.mkdirs();
    		
    		
    		
    		System.out.println("finish 2 "+ model.getLine().getCode());
			String id = addLine.findIdByCode(model.getLine().getCode());
			MmsAddline obj =   addLine.findById(new Long(id));
			String line =obj.getLineName();
			System.out.println("finish 3 "+line );
			
    		
			
			
			//System.out.println("reportPath 2 "+ reportPath);
			
			//String deptId = request.getSession().getAttribute("deptId").toString();
			String stringOflineIds = "";
			File serverFile = null;
			File serverFile1 = null;
			File serverFile2 = null;
			File serverFile3 = null;
			File serverFile4 = null;
			System.out.println("finish 3 " );
			
			
			String areaName = gldeptDao.getName(deptId);
			if(areaName != null){
				areaName.trim();
			}
			
			HashMap<String, Object> param = new HashMap<String, Object>(3);
			param.put("0", model.getMailContent());
			param.put("1", model.getMailContent2());
			param.put("2", areaName);
			
						
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date newDate = new Date();
    		String dateString = format.format(newDate);
    		List<Long> lines = model.getSelectedLines();
    		String lineName ="";
    		System.out.println("finish 4 " );
			
    		if (lines != null) {
								int idloop = lines.size();
				
				for (int i = 0; i < idloop; i++) {
					MmsAddline lineObj = lineDao.findById(lines.get(i));
					lineName = lineObj.getLineName() +"\n"+lineName;
				}
    		}
    		
    		lineName = line;
    		
    		String ss =gldeptDao.getDD(deptId);
    		String province = glcompmDao.getProvince(ss);
    		if(province != null){
    			province.trim();
    			
    		}
    		
    		String pdfFileName = generateReport("MNTREQ","Maintenance_Request",param,null,path1,path1,model.getMailContent(),model.getMailContent2(),areaName,lineName,province,"",null);
			File pdfFile = new File(pdfFileName);
			
    		String path = PathMMS.getReportPath();
    		File dir = new File(path + File.separator + "EmailAttachment");
    		if (!dir.exists())
				dir.mkdirs();
    		

    		System.out.println("finish 5 "+ path );
    		
    		
			
    		
    		if (!file.isEmpty()) {
				try {
					String name = file.getOriginalFilename();
					byte[] bytes = file.getBytes();

					serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					
					stream.write(bytes);
					stream.close();
					
					
					
					
					
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		System.out.println("finish 6 " );
			
    		if (!file1.isEmpty()) {
				try {
					String name = file1.getOriginalFilename();
					byte[] bytes = file1.getBytes();

					serverFile1 = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile1));
					
					stream.write(bytes);
					stream.close();
										
					
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		System.out.println("finish 7 " );
			
    		
    		if (!file2.isEmpty()) {
				try {
					String name = file2.getOriginalFilename();
					byte[] bytes = file2.getBytes();

					serverFile2 = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile2));
					
					stream.write(bytes);
					stream.close();
					
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		System.out.println("finish 8 " );
			
    		if (!file3.isEmpty()) {
				try {
					String name = file3.getOriginalFilename();
					byte[] bytes = file3.getBytes();

					serverFile3 = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile3));
					
					stream.write(bytes);
					stream.close();
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		
    		if (!file4.isEmpty()) {
				try {
					String name = file4.getOriginalFilename();
					byte[] bytes = file4.getBytes();

					serverFile4 = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile4));
					
					stream.write(bytes);
					stream.close();
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		String content = "";
    		String subject = "";
    		String sms_content ="";
    		String pre_approval_id = "";
    		String pre_approval_id_SMS = "";
    		String approveType = "";
    		String fromStatus = "";
			String toStatus = "";
			String success ="";
			
			if(model.getMode().compareTo("INS")==0){
				content ="" + "\n" + "Office of Area Engineer (" +areaName.trim()+ ")" +
						"\n" + "Date :"+ dateString + "\n" +"\n"+ "Chief Engineer (Line Construction & Maintenance), P&HM-DD2" +
						"\n\n"+ "INSPECTION REQUEST" + "\n\n\n"+"You are kindly requested to inspect the following line. \n\n"+ lineName +
						"\n\n"+ "Requirement : " +model.getMailContent()  +" \n\n Requesting section/s to be inspected : "+model.getMailContent2();
				subject ="Inspection Request From "+areaName;
				sms_content ="Inspection Request from "+areaName + " Pls check your email";
				pre_approval_id = "EMAILINSR-"+deptId;
				pre_approval_id_SMS = "SMSMVINSR-"+deptId;
				approveType = "INSREQ";
				fromStatus = "1";
				toStatus = "6";
				success = "Inspetion request successfully sent to PHM DD2";
				
						
			}else{
				content ="" + "\n" + "Office of Area Engineer (" +areaName.trim()+ ")" +
						"\n" + "Date :"+ dateString + "\n" +"\n"+ "Chief Engineer (Line Construction & Maintenance), P&HM-DD2" +
						"\n\n"+ "MAINTENANCE REQUEST" + "\n\n\n"+"You are kindly requested to maintain the following line. \n\n"+ lineName +
						"\n\n"+ "Requirement : " +model.getMailContent()  +" \n\n Requesting section/s to be inspected : "+model.getMailContent2();
				
			    content = "\n\nPlease find the attachments\n\n\n" + areaName ;
				subject ="Maintenance Request from "+areaName;
				sms_content ="Maintenance Request from "+areaName + " Pls check your email";
				pre_approval_id = "EMAILMNTE-"+deptId;
				pre_approval_id_SMS = "SMSMVMNTE-"+deptId;
				approveType = "MNTREQ";
				fromStatus = "1";
				toStatus = "7";
				success ="Maintenance request successfully sent to PHM DD2";
				
						
		//	}
    		
    		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
			MailMail mm = (MailMail) context.getBean("mailMail");
			String url="";
			
			String urlCC="";
			
			if((deptId.compareTo("444.00")==0) || (deptId.compareTo("441.00")==0) || (deptId.compareTo("443.00")==0) || (deptId.compareTo("446.00")==0) || (deptId.compareTo("443.00")==0) || (deptId.compareTo("442.00")==0) || (deptId.compareTo("472.00")==0) || (deptId.compareTo("439.00")==0) || (deptId.compareTo("445.00")==0)){
				//mm.sendMailTo("PHM DD2", content ,"eranga.bogahakumbura@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
				Util.trustEveryone();
				mm.sendMailTo("PHM DD2", content ,"eelm.ceb@gmail.com","alagodas1@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
				url="http://smsgw.ceb/SMSPlatform.php?recipients=0714288817&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
				
			}else{
				Util.trustEveryone();
				mm.sendMailTo("PHM DD2", content ,"eranga.bogahakumbura@gmail.com","alagodas1@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
				url="http://smsgw.ceb/SMSPlatform.php?recipients=0718716913&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
				
				//mm.sendMailTo("PHM DD2", content ,"eelm.ceb@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
				
			}
			
			System.out.println("finish 1 " );
			Date date = new Date();
			
			
			
			RestTemplate restTemplate = new RestTemplate();
			System.out.println("sendSMS 2" );

			
			urlCC="http://smsgw.ceb/SMSPlatform.php?recipients=0713841267&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			//
			//String url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			
			System.out.println("sendSMS 3" );

			try {
				Util.trustEveryone();
				
				restTemplate.getForObject(url, String.class);
				System.out.println("sendSMS 77" );

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("sendSMS 78"+ e1.getMessage() );

				e1.printStackTrace();
			}
			
			try {
				Util.trustEveryone();
				
				restTemplate.getForObject(urlCC, String.class);
				System.out.println("sendSMS 99" );

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("sendSMS 99"+ e1.getMessage() );

				e1.printStackTrace();
			}
			System.out.println("sendSMS 4" );
			
			
			
			
			
			String enterDate = sdf.format(date);
			String nextNumver = approval.getNextAppId(pre_approval_id);
			
			String approval_id = pre_approval_id + "-" + nextNumver;
			
			String approval_id_SMS = pre_approval_id_SMS + "-" + nextNumver;
			
			String refrence = deptId;
			String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
			System.out.println("finish 2 " );
			
			String approvedBy = request.getSession().getAttribute("loggedUser").toString();
			
			
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

    		Date date2 = null;
			try {
				String dateString1 = format.format(date);
				date2 = format.parse (dateString1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    

    		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");

    		String timeString = format2.format(date);
    		System.out.println("finish 3 " );
			
			
			
			Approval appr = new Approval();
			appr.setApprovalId(approval_id);
			System.out.println("finish 6 " +approval_id);
			appr.setReferenceNo(refrence);
			System.out.println("finish 7 " + refrence);
			String reason = "Inspection request";
			appr.setReason(reason);
			System.out.println("finish 8 " +reason);
			
			appr.setDeptId(deptId);
			System.out.println("finish 9 "+ deptId );
			
			appr.setApprovalType(approveType);
			System.out.println("finish 10 " +approveType);
			
			appr.setApprovedLevel(approveLevel);
			System.out.println("finish 11 "+ approveType );
			
			appr.setFromStatus(fromStatus);
			System.out.println("finish 12 "+ fromStatus);
			
			appr.setToStatus(toStatus);
			System.out.println("finish 13 "+ toStatus );
			
			appr.setApprovedDate(date2);
			System.out.println("finish 14 " + dateString);
			
			appr.setApprovedTime(timeString);
			System.out.println("finish 15 "+ timeString );
			
			appr.setApprovedBy(approvedBy);
			System.out.println("finish 16 "+ approvedBy);
			
			approval.addApproval(appr);
			
			appr.setApprovalId(approval_id_SMS);
			appr.setApprovalType(approveType);
			appr.setToStatus(toStatus);
			
			approval.addApproval(appr);
			
			
			System.out.println("finish 4 " );


			
			
			
			//String canGO = "1";

			//PivModel model = new PivModel();
			//model = loadProLineES(request,model);
			List<MmsAddline> liness = addLine.findLineByArea(deptId);
			model.setLineListEdit(liness);
			int lineSize = liness.size() - 1;
			List<Long> lineListnew = new ArrayList<Long>(lineSize);
			for (int i = 0; i <= lineSize; i++) {
				MmsAddline obj = liness.get(i);
				lineListnew.add(obj.getId());
				if (i != 0) { stringOflineIds = stringOflineIds + "," +
				  Long.toString(obj.getId()); } 
				else { stringOflineIds =
				  Long.toString(obj.getId()); }
				 
			}
			System.out.println("else -------------------> stringOflineIds: "+ stringOflineIds);
			model.setListOfLines(lineListnew);
			
			List<MmsAddline> liness = addLine.findLineByArea(deptId);
			Map<String,String> lineList = new LinkedHashMap<String,String>();

			int lineLoop = liness.size()-1;
			for(int i=0;i<=lineLoop;i++){ 
				System.out.println(i);
				MmsAddline ojb = liness.get(i);
				lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		    } 
			
			
			model.setLineList(lineList);

			
			
			model.setMessage(success);
			mo = new ModelAndView("MaintenanceRequest", "model",model);
			
			mo.addObject("canGO", canGO);
			mo.addObject("type", "MNT");
			
			//mo.addObject("success", "Inspetion request successfully sent to PHM DD2 ");
			
			return mo;

		}
*/
/*		private File getLetter(String areaName,String requirement,String requesting,HttpServletRequest request,HttpServletResponse response){
			
			String reportFileName ="Inspection_Request";
			Connection conn = null;

			try {
				System.out.println("yyy ttt uuu iiii ooo");
				conn = jasperDao.getConnection();
				System.out.println("areaName " + areaName);
				System.out.println("requirement " + requirement);
				System.out.println("requesting " + requesting);
				
				

				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				
				hmParams.put("@erquirement", "'"+requirement+"'");
				hmParams.put("@requesting","'" +requesting +"'");
				hmParams.put("@coordinating","'"+areaName+"'");

				String rptFormat = "pdf";
				
				JasperReport jasperReport = null;
				try {
					jasperReport = jasperDao.getCompiledFileMVMMS(reportFileName,request);
					
					JRPdfExporter pdfExpo = new JRPdfExporter();
					JRPdfExporter pdf = new JRPdfExporter();

					Calendar calendar = Calendar.getInstance();
					 
					pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");

					
					String path = Path.getReportPath();
					File dir = new File(path + File.separator + "Reports");
					if (!dir.exists())
						dir.mkdirs();

					
					String pdfPath = path + File.separator +
					calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
					+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
					+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + "R.pdf";
					
					pdf.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
					pdf.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, pdfPath);
					pdf.exportReport();

					
					
					
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (rptFormat.equalsIgnoreCase("html")) {

					
				}

				else if (rptFormat.equalsIgnoreCase("pdf")) {

					try {
						jasperDao.generateReportPDF(response, hmParams, jasperReport, conn);
					} catch (JRException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NamingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} // For
																						// PDF
																						// report

				}

			} catch (SQLException sqlExp) {
				System.out.println("Exception::" + sqlExp.toString());
			} finally {
				if (conn != null) {
					try {
						conn.close();
						conn = null;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

			return null;

			
			
			
		}*/
		
		
		 
		public String generateReportInterruption(String type,String reportName,HashMap<String, Object> param,Map<String, Object> session,String REPORT_DIRECTORY,String EXPORT_REPORT_DIRECTORY,PivModel model,String areaName,File imgFile,File imgFile1,File imgFile2,File imgFile3,File imgFile4,String loggedUser){

			String pdfPath = "";
			//String reportFileName ="Inspection_Request";
			Connection conn = null;
			String ref_no ="test";
			System.out.println(model.getGlcompmobj().getCompId().trim());
	        

			try {
				
				try {
					HashMap<String, Object> hmParams = new HashMap<String, Object>();
					//System.out.println("model.getCycle() : " + model.getCycle());
					hmParams.put("@province", "'"+model.getGlcompmobj().getCompId()+"'");
					
					hmParams.put("@REFERENCE_NO", "'"+model.getCycle()+"'");
					hmParams.put("@workingDate","'" +model.getDateOfWork() +"'");
					if(model.getTimeDuration() == null || model.getTimeDuration().equalsIgnoreCase("") ){
						model.setTimeDuration("8:30am");
					}
					if(model.getTimeDuration2() == null || model.getTimeDuration2().equalsIgnoreCase("")){
						model.setTimeDuration2("5:00pm");
					}
					hmParams.put("@TimeDur","'"+model.getTimeDuration()+ " - "+model.getTimeDuration2()+"'");
					hmParams.put("@Location","'"+"From : " + model.getFrom() + " To : "+ model.getTo() + "'");
					hmParams.put("@TS","'" +model.getFrom() +"'");
					hmParams.put("@TE","'" +model.getTo() +"'");
					System.out.println("hhhhhhhhhh");
			        
					MmsAddline line = null;
					//if(model.getLine() != null){
					String grid ="";
					String feeder1="";
					String feeder2="";
					String xxx="";
					System.out.println("hhhhhhhhhh1");
			        
					if(model.getLineNameNew() == null){
						line = lineDao.findById(model.getLine().getId());
						if(line != null){
							System.out.println("hhhhhhhhhh3");
					        
							if(line.getName() != null){
								if(line.getName().equalsIgnoreCase("NONE")){
									grid="";
								}else{
									grid=line.getName();
									xxx = xxx.concat(grid +"-");
									
								}
								
							}else{
								/*grid=line.getName();
								xxx = xxx.concat(grid + "-");
								*/
							}
							System.out.println("hhhhhhhhhh4");
					        
							if(line.getFeederIdentification() != null){
								if(line.getFeederIdentification().equalsIgnoreCase("NONE")){
									feeder1=" ";
								}else{
									feeder1=line.getFeederIdentification();
									xxx = xxx.concat(feeder1 +"-");
									
								}
								
							}else{
								/*feeder1=line.getFeederIdentification();
								xxx = xxx.concat(feeder1 +"-");
								*/
							}
							System.out.println("hhhhhhhhhh5 :"+line.getFeeder2());
					        
							if(line.getFeeder2() != null){
								if(line.getFeeder2().equalsIgnoreCase("NONE")){
									feeder2="";
								}else{
									feeder2=line.getFeeder2();
									xxx = xxx.concat(feeder2);
									
								}
								
							}else{
								/*feeder2="";
								xxx = xxx.concat(feeder2);
								*/
							}
							
							System.out.println("hhhhhhhhhh6");
					        
							hmParams.put("@LineName","'" +line.getLineName() +"("+ xxx +")" +"'");
						}
					}else{
						System.out.println("hhhhhhhhhh7");
				        
						hmParams.put("@LineName","'" +model.getLineNameNew() +"'");
					}
					System.out.println("hhhhhhhhhh2");
			        
					//}
					//System.out.println("model.getLine().getId() : " + model.getLine().getId());

					/*if(line != null){
						System.out.println("model.getLine().getName() : " + line.getName());

					hmParams.put("@LineName","'" +line.getLineName() +"'");
					}
*/					String empty="";
					hmParams.put("@actionDate","'"+empty+"'");
					
					hmParams.put("@FieldWork","'"+model.getMailContent2()+"'");
					//String path1 =PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ model.get + "_2.png" ;
					//File file = new File(path1);
					if(imgFile != null){
					if (imgFile.exists())
			        {
						//InputStream inputStream = new FileInputStream(imgFile); //load the file
						System.out.println("Imgge : " + imgFile.getAbsolutePath());

						hmParams.put("@Imgge",imgFile.getAbsolutePath());
						
			        }
					}
					if(imgFile1 != null){
					if (imgFile1.exists())
			        {
						//InputStream inputStream = new FileInputStream(imgFile); //load the file
						System.out.println("img1 : " + imgFile1.getAbsolutePath());

						hmParams.put("@imgOne",imgFile1.getAbsolutePath());
						
			        }
					}
					if(imgFile2 != null){
					if (imgFile2.exists())
			        {
						//InputStream inputStream = new FileInputStream(imgFile); //load the file
						
						hmParams.put("@img2",imgFile2.getAbsolutePath());
						
			        }
					}
					if(imgFile3 != null){
					if (imgFile3.exists())
			        {
						//InputStream inputStream = new FileInputStream(imgFile); //load the file
						
						hmParams.put("@img3",imgFile3.getAbsolutePath());
						
			        }
					}
					if(imgFile4 != null){
					if (imgFile4.exists())
			        {
						//InputStream inputStream = new FileInputStream(imgFile); //load the file
						
						hmParams.put("@img4",imgFile4.getAbsolutePath());
						
			        }
					}
					
					
					
					
					Sauserm user = secDao.getSauserm(loggedUser);
					Sauserm userEE = secDao.getSauserm(model.getSausermEE().getUserId().trim());
					
					String resEEES = "";
					if(user != null && userEE != null){
						resEEES = "EE : " + userEE.getUserNm() + " ES : " + user.getUserNm();
						
					}
					hmParams.put("@ESName","'"+resEEES+"'");
					
					String requBra = "PHM";
					hmParams.put("@RequestBr","'"+requBra+"'");
					
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					Date today = Calendar.getInstance().getTime();        
					String reportDate = df.format(today);

					hmParams.put("@Date1","'"+reportDate+"'");


					conn = jasperDao.getConnection();
					File file = new File(REPORT_DIRECTORY + "/" + reportName + ".jrxml" );
				        
				        if(!file.exists())
				            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");
	
				    JasperReport jasperReport =  JasperCompileManager.compileReport(EXPORT_REPORT_DIRECTORY  + "/" + reportName + ".jrxml");
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
	 				JRPdfExporter pdf = new JRPdfExporter();

					Calendar calendar = Calendar.getInstance();
					 
					pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");

					/*pdfPath = EXPORT_REPORT_DIRECTORY + "/" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
					+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
					+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + "R.pdf";
					*/
					/*pdfPath = EXPORT_REPORT_DIRECTORY + "/" +"INTERRUPTION"+ "-"+ calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
							+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
							+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + ".pdf";
					*/		
					
					pdfPath = EXPORT_REPORT_DIRECTORY + "/"+model.getCycle()  + ".pdf";
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

			return pdfPath ;
		}
		
		
		
		
		
		
		public String generateIntteruptionSummary(){

			String path1 = PathMMS.getReportPath() + File.separator + "Reports";
			String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
    		String pdfPath ="";
    		Connection conn = null;
			
			try {
				
				try {
					HashMap<String, Object> hmParams = new HashMap<String, Object>();
					conn = jasperDao.getConnection();
					File file = new File(path1 + "/" + "INT_REQ_SUM" + ".jrxml" );
				        
				        if(!file.exists())
				            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");
	
				    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "INT_REQ_SUM" + ".jrxml");
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
	 				JRPdfExporter pdf = new JRPdfExporter();

					Calendar calendar = Calendar.getInstance();
					 
					pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
					
					pdfPath = path2 + "/INTERRUPTION REQUEST SUMMARY-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
							+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
							+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + ".pdf";
							
					
					File pdfFile = new File(pdfPath);
					
					
					
					
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

			return pdfPath ;
		}

		
		
		public String generateReport(String type,String reportName,HashMap<String, Object> param,Map<String, Object> session,String REPORT_DIRECTORY,String EXPORT_REPORT_DIRECTORY,String requ,String requeting,String areaName,String lineNames,String province,String emailId,String division,File imgFile){

			String pdfPath = "";
			//String reportFileName ="Inspection_Request";
			Connection conn = null;

			try {
				
				try {
					HashMap<String, Object> hmParams = new HashMap<String, Object>();
					
					if(type.equalsIgnoreCase("MNTREQ")){
						hmParams.put("@erquirement", "'"+requeting+"'");
						hmParams.put("@requesting","'" +emailId +"'");
						
												
					}else{
						hmParams.put("@erquirement", "'"+requ+"'");
						hmParams.put("@requesting","'" +requeting +"'");
						
					}
					hmParams.put("@coordinating","'"+areaName+"'");
					hmParams.put("@lineName","'"+lineNames+"'");
					hmParams.put("@province","'"+province+"'");
					hmParams.put("@RequestNo","'"+emailId+"'");
					hmParams.put("phmunit","'"+division+"'");
					
					if(imgFile != null){
						if (imgFile.exists())
				        {
							//InputStream inputStream = new FileInputStream(imgFile); //load the file
							System.out.println("Imgge : " + imgFile.getAbsolutePath());

							hmParams.put("@Imgge",imgFile.getAbsolutePath());
							
				        }
					}



					conn = jasperDao.getConnection();
					File file = new File(REPORT_DIRECTORY + "/" + reportName + ".jrxml" );
				        
				        if(!file.exists())
				            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");
	
				    JasperReport jasperReport =  JasperCompileManager.compileReport(EXPORT_REPORT_DIRECTORY  + "/" + reportName + ".jrxml");
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
	 				JRPdfExporter pdf = new JRPdfExporter();

					Calendar calendar = Calendar.getInstance();
					 
					pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");

					/*pdfPath = EXPORT_REPORT_DIRECTORY + "/" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
					+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
					+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + "R.pdf";
					*/
					/*pdfPath = EXPORT_REPORT_DIRECTORY + "/" +emailId+ "-"+ calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
							+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
							+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + ".pdf";
							
					*/
					pdfPath =EXPORT_REPORT_DIRECTORY + "/"+ emailId  + ".pdf";
					
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

			return pdfPath ;
		}

		
		
		
		@RequestMapping(value = "/goToInterruptionRequestS", method = RequestMethod.POST)
		public ModelAndView goToInterruptionRequestS(HttpServletRequest request,@RequestParam("file") MultipartFile file,@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2,@RequestParam("file3") MultipartFile file3,@RequestParam("file4") MultipartFile file4,@ModelAttribute("model") PivModel model) {
			
			System.out.println("mapId "+ model.getMapId() );
			System.out.println("tower "+ model.getFromtowerid());
			
			
			
			//Util.trustEveryone();
			ModelAndView mo = null;
			String canGO = "1";
			String deptId = request.getSession().getAttribute("deptId").toString();
			String userLoged = request.getSession().getAttribute("loggedUser").toString();
			SausermMm userMm = null;
			if(model.getSausermEE() != null){
				try {
					
					userMm =secDao.getSausermMms(model.getSausermEE().getUserId());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("model.getSausermEE().getUserId() "+ model.getSausermEE().getUserId());
				
			}
			
			
			SausermMm userMmEs = null;
			if(userLoged != null){
				try {
					
					userMmEs =secDao.getSausermMms(userLoged);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println("model.getSausermEE().getUserId() "+ model.getSausermEE().getUserId());
				
			}
			
			
			//System.out.println("userMm "+ userMm);
			
			String areaName = "";
			ApprovalMm appr = new ApprovalMm();
			
			
			if(!model.getGldeptobj().getDeptId().equals("AREA")){
				areaName = gldeptDao.getName(model.getGldeptobj().getDeptId());
			}
			
			String path1 = PathMMS.getReportPath() + File.separator + "Reports";
    		File dir1 = new File(path1 + File.separator + "Reports");
    		if (!dir1.exists())
				dir1.mkdirs();
    		File serverFile = null;
			File serverFile1 = null;
			File serverFile2 = null;
			File serverFile3 = null;
			File serverFile4 = null;
			
			String pre_approval_id = "INT" +"-"+deptId;;
    		String nextNumver = approvalMm.getNextAppId(pre_approval_id);
    		System.out.println("nextNumver 5 "+ nextNumver );
			
    		String approval_id = pre_approval_id + "-" + nextNumver;

			model.setCycle(approval_id);
			System.out.println("model.setCycle "+ model.getCycle() );
			
			model.getSauserm().setUserId(userLoged);
			
			
			String path = PathMMS.getReportPath();
    		File dir = new File(path + File.separator + "EmailAttachment");
    		if (!dir.exists())
				dir.mkdirs();
    		
			
    		if (!file.isEmpty()) {
				try {
					String name = file.getOriginalFilename();
					System.out.println("file name : "+ name );
					
					byte[] bytes = file.getBytes();
					String extension = Util.getSubStringLastPart(name,".");

					
					name = approval_id + "_1" +extension ;
					appr.setFilename1(name);

					serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					
					stream.write(bytes);
					stream.close();
								
					
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}

    		if (!file1.isEmpty()) {
				try {
					String name = file1.getOriginalFilename();
					System.out.println("file1 name : "+ name );
					String extension = Util.getSubStringLastPart(name,".");

					byte[] bytes = file1.getBytes();
					name = approval_id + "_2" + extension ;
					appr.setFilename2(name);

					serverFile1 = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile1));
					
					stream.write(bytes);
					stream.close();
										
					
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		System.out.println("finish 7 " );

			
    		if (!file2.isEmpty()) {
				try {
					String name = file2.getOriginalFilename();
					byte[] bytes = file2.getBytes();
					String extension = Util.getSubStringLastPart(name,".");

					name = approval_id + "_3" + extension ;
					appr.setFilename3(name);

					serverFile2 = new File(dir.getAbsolutePath()+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile2));
					
					stream.write(bytes);
					stream.close();
					
					}catch(Exception e){
					System.out.println("error :"+e);
				}
    		}
    		System.out.println("finish 8 " );
			

    		if (!file3.isEmpty()) {
	try {
		String name = file3.getOriginalFilename();
		byte[] bytes = file3.getBytes();
		String extension = Util.getSubStringLastPart(name,".");

		name = approval_id + "_4" + extension ;
		appr.setFilename4(name);

		serverFile3 = new File(dir.getAbsolutePath()+ File.separator + name);
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile3));
		
		stream.write(bytes);
		stream.close();
		}catch(Exception e){
		System.out.println("error :"+e);
	}
}

if (!file4.isEmpty()) {
	try {
		String name = file4.getOriginalFilename();
		byte[] bytes = file4.getBytes();
		String extension = Util.getSubStringLastPart(name,".");

		name = approval_id + "_5" + extension;
		appr.setFilename5(name);

		serverFile4 = new File(dir.getAbsolutePath()+ File.separator + name);
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile4));
		
		stream.write(bytes);
		stream.close();
		}catch(Exception e){
		System.out.println("error :"+e);
	}
}

		String pdfFileName = "";
			if(model.getOtherInterruption().equalsIgnoreCase("OTHER")){
				pdfFileName = generateReportInterruption("INTRUPREQ","PTWOTHER",null,null,path1,path1,model,areaName,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,userLoged);
			}
			else{
				pdfFileName = generateReportInterruption("INTRUPREQ","PTW",null,null,path1,path1,model,areaName,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,userLoged);
					
			}
			File pdfFile = new File(pdfFileName);
			
    		    		System.out.println("finish 6 " );
			
    					
    		    		
    		
    		String content = "";
    		String subject = "";
    		String sms_content ="";
    		String pre_approval_id_SMS = "";
    		String approveType = "";
    		String fromStatus = "";
			String toStatus = "";
			String success ="";
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd ");
			Date today = new Date();        
			String reportDate = df.format(today);
			
			DateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String subject_str = subject_str_fm.format(today);
			
			//System.out.println("equipment : 1 ");
			//Date dateNowNew=null;
			
		    String heading = "INSPECTION REQUEST";
		    areaName = areaName.trim();
			//areaName = areaName.toLowerCase();
			content = "\nInterruption request is sent by ES("+userLoged+") of PHM branch. You can view that by login into  https://mms.ceb.lk";
			subject = "Interruption request for "+areaName + " " + model.getDateOfWork();
			sms_content ="Interruption request is sent by ES PHM branch in "+areaName+". You can view that by login into  https://mms.ceb.lk";;
			approveType = "INTREQ";
			fromStatus = "1";
			toStatus = "6";
			success = "Interruption request is successfully sent to Maintenance Engineer";
			
    		
			ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
			MailMail mm = (MailMail) context.getBean("mailMail");
			Date date = new Date();
			RestTemplate restTemplate = new RestTemplate();
			String url= "";
			String urlCE="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";

			if(deptId.equalsIgnoreCase("600.41")){
				//System.out.println("userMm.getTelNo() " + userMm.getTelNo());
				if(userMm != null){
					if(userMm.getTelNo() != null){
						System.out.println("userMm.getTelNo() " + userMm.getTelNo());
						
						url="http://smsgw.ceb/SMSPlatform.php?recipients="+userMm.getTelNo().trim()+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					}else{
						url="http://smsgw.ceb/SMSPlatform.php?recipients=0718716913&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
						
					}
					
				}else{
					url="http://smsgw.ceb/SMSPlatform.php?recipients=0718716913&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					
				}
				
				if(userMmEs != null){
					if(userMmEs.getTelNo() != null){
						
						url="http://smsgw.ceb/SMSPlatform.php?recipients="+userMmEs.getTelNo().trim()+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					}else{
						url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
						
					}
					
				}else{
					url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					
				}
				//url="http://smsgw.ceb/SMSPlatform.php?recipients="+userMm.getTelNo()+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
				//urlCE="http://smsgw.ceb/SMSPlatform.php?recipients=0713841267&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					
			}else if(deptId.equalsIgnoreCase("600.42") || deptId.equals("597.00")|| deptId.equals("972.20")){
				//System.out.println("userMm.getTelNo() " + userMm.getTelNo());
				if(userMm != null){
					if(userMm.getTelNo() != null){
						System.out.println("userMm.getTelNo() " + userMm.getTelNo());
						
						url="http://smsgw.ceb/SMSPlatform.php?recipients="+userMm.getTelNo().trim()+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					}else{
						url="http://smsgw.ceb/SMSPlatform.php?recipients=0719673624&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
						
					}
					
				}else{
					url="http://smsgw.ceb/SMSPlatform.php?recipients=0719673624&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					
				}
				//url="http://smsgw.ceb/SMSPlatform.php?recipients="+userMm.getTelNo()+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
				//urlCE="http://smsgw.ceb/SMSPlatform.php?recipients=0713841267&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					
			}else if(deptId.equalsIgnoreCase("780.00")){
				
				if(userMm != null){
					if(userMm.getTelNo() != null){
						System.out.println("userMm.getTelNo() " + userMm.getTelNo());
						
						url="http://smsgw.ceb/SMSPlatform.php?recipients="+userMm.getTelNo().trim()+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					}else{
						url="http://smsgw.ceb/SMSPlatform.php?recipients=0718693225&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
						
					}
					
				}else{
					url="http://smsgw.ceb/SMSPlatform.php?recipients=0718693225&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					
				}
				
				if(userMmEs != null){
					if(userMmEs.getTelNo() != null){
						System.out.println("userMm.getTelNo() " + userMmEs.getTelNo());
						
						url="http://smsgw.ceb/SMSPlatform.php?recipients="+userMmEs.getTelNo().trim()+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					}else{
						url="http://smsgw.ceb/SMSPlatform.php?recipients=0718693225&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
						
					}
					
				}else{
					url="http://smsgw.ceb/SMSPlatform.php?recipients=0718693225&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					
				}
				
				
				
				
				//url="http://smsgw.ceb/SMSPlatform.php?recipients=0718693225&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
				urlCE="http://smsgw.ceb/SMSPlatform.php?recipients=0718693225&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";

			}else if(deptId.equalsIgnoreCase("596.00")){
				if(userMm != null){
					if(userMm.getTelNo() != null){
						System.out.println("userMm.getTelNo() " + userMm.getTelNo());
						
						url="http://smsgw.ceb/SMSPlatform.php?recipients="+userMm.getTelNo().trim()+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					}else{
						url="http://smsgw.ceb/SMSPlatform.php?recipients=0718070229&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
						
					}
					
				}else{
					url="http://smsgw.ceb/SMSPlatform.php?recipients=0718070229&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					
				}
				
				
				
				//url="http://smsgw.ceb/SMSPlatform.php?recipients=0718070229&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
				urlCE="http://smsgw.ceb/SMSPlatform.php?recipients=0718070229&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";

			}else{
				url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
				urlCE="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";

			}
				
			
            String enterDate = sdf.format(date);
			
			String refrence = areaName;
			String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
			System.out.println("finish 2 " );
			
			String approvedBy = request.getSession().getAttribute("loggedUser").toString();
			
			
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

    		Date date2 = null;
			try {
				String dateString1 = format1.format(date);
				date2 = format1.parse (dateString1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    

    		SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");

    		String timeString = format2.format(date);
    		System.out.println("finish 3 " );
			
			
			
			appr.setApprovalId(approval_id);
			System.out.println("finish 6 " +approval_id);
			System.out.println("appr:  "+ appr.getFilename1() );
			
			//appr.setFilename1(model.getFilename_1());
			System.out.println("model.getOtherInterruption():   "+ model.getOtherInterruption());
			if(model.getOtherInterruption().equalsIgnoreCase("OTHER")){
				appr.setType("OTHER");
				
			}else{
				appr.setType("NETWORK");
			}
			appr.setReferenceNo(refrence);
			System.out.println("finish 7 " + refrence);
			String reason = "";
			
			
			
			
			
			
			if(model.getSausermEE()!= null){
				
				Sauserm user = secDao.getSauserm(userLoged);
				Sauserm userEE = secDao.getSauserm(model.getSausermEE().getUserId().trim());
				
				String resEEES = "";
				if(user != null && userEE != null){
					resEEES = "Requested EE : " + userEE.getUserNm() + " Requested ES : " + user.getUserNm();
					
				}
				
				
				
				//reason = "Requested EE : "+ model.getSausermEE().getUserId() +"Requested ES : "+ userLoged;
				reason = resEEES;
				appr.setEe(model.getSausermEE().getUserId());
				appr.setEs(userLoged);
				appr.setReason(reason);
			}
			//System.out.println("line id  " + model.getLine().getId());
			MmsAddline lineObj = null;
			if(model.getLine() != null){
			if(model.getLine().getId() != -2){
				lineObj = lineDao.findById(model.getLine().getId());
			}
			}
			String lineName = "";
			if(lineObj != null){
				lineName = lineObj.getLineName();
			}
			if(model.getTimeDuration() == null || model.getTimeDuration().equalsIgnoreCase("")){
				model.setTimeDuration("8.30am");
			}
			if(model.getTimeDuration2() == null || model.getTimeDuration2().equalsIgnoreCase("")){
				model.setTimeDuration2("5.00pm");
			}
			if(model.getLineNameNew() != null){
				System.out.println("finish gggggggggggggggggggggg ");
				
				appr.setFromto(model.getLineNameNew() +" "+model.getFrom()  +" - "+model.getTo());
				
			}else{
				System.out.println("finish ggggggggggggggggggggggbbbbb ");
				appr.setFromto(lineName +" "+model.getFrom()  +" - "+model.getTo());
				
				
			}
			appr.setTotower(model.getTo());
			appr.setFromtower(model.getFrom());
			appr.setWorkingDate(model.getDateOfWork());
			appr.setWorkingdatenew(Format.StrToDate(model.getDateOfWork()));
			appr.setTimeduration(model.getDateOfWork() + " : " + model.getTimeDuration() + " - " +model.getTimeDuration2());
			appr.setFromtime(model.getTimeDuration());
			appr.setTotime(model.getTimeDuration2());
			if(model.getLineNameNew() != null){
				appr.setLineid(new Long("0"));
			}else{
				appr.setLineid(model.getLine().getId());
			}
			appr.setReq1(model.getMailContent());
			appr.setReq2(model.getMailContent2());
			try {
				appr.setFromtowerId(new BigDecimal(model.getFromtowerid()));
				appr.setFromtowerMapid(new BigDecimal(model.getFromtowermapid()));
				appr.setTotowerId(new BigDecimal(model.getTotowerid()));
				appr.setTotowerMapid(new BigDecimal(model.getTotowermapid()));
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("finish 8 " +reason);
			
			appr.setDeptId(deptId);
			System.out.println("finish 9 "+ deptId );
			appr.setPhmBranch(deptId);
			appr.setApprovalType(approveType);
			System.out.println("finish 10 " +approveType);
			
			appr.setApprovedLevel(approveLevel);
			System.out.println("finish 11 "+ approveType );
			appr.setAreaCode(model.getGldeptobj().getDeptId());
			appr.setFromStatus(fromStatus);
			System.out.println("finish 12 "+ fromStatus);
			
			appr.setToStatus(toStatus);
			System.out.println("finish 13 "+ toStatus );
			if(model.getLineNameNew() != null){
				appr.setLineid(new Long("0"));
			}else{
				appr.setLineid(model.getLine().getId());
			}
			
			appr.setApprovedDate(date2);
			//System.out.println("finish 14 " + dateString);
			
			appr.setApprovedTime(timeString);
			System.out.println("finish 15 "+ timeString );
			
			appr.setApprovedBy(approvedBy);
			System.out.println("finish 16 "+ approvedBy);
			
			
			
			
			try {
				approvalMm.addApproval(appr);
				
				if(deptId.equalsIgnoreCase("600.41")){
					//Util.trustEveryone();
					try {
						//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"eranga.bogahakumbura@gmail.com","eranga.bogahakumbura@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
						
						
						if(userMm != null){
							if(userMm.getEmail() != null){
								System.out.println("userMm.getEmail() "+ userMm.getEmail());
								
								if(userMmEs != null){
									if(userMmEs.getEmail() != null){
										mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,userMm.getEmail(),userMmEs.getEmail(),subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
									       
									}else{
										mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,userMm.getEmail(),subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
									       
									}
								}else{
									mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,userMm.getEmail(),subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
								       
								}
								//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,userMm.getEmail(),subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
						       // mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,userMm.getEmail(),subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
								//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"gchampika28@gmail.com","mgrisd@ceb.lk",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
								mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
								
							}else{
								mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"eranga.bogahakumbura@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
								
							}
							
						}else{
							mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"eranga.bogahakumbura@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
							
						}
						
						
						
						
						} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else if(deptId.equalsIgnoreCase("600.42")|| deptId.equals("597.00")|| deptId.equals("972.20")){
					//Util.trustEveryone();
					try {
						//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"eranga.bogahakumbura@gmail.com","eranga.bogahakumbura@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
						
						
						if(userMm != null){
							if(userMm.getEmail() != null){
								System.out.println("userMm.getEmail() "+ userMm.getEmail());
								mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,userMm.getEmail(),subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
						       // mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,userMm.getEmail(),subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
								//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"gchampika28@gmail.com","mgrisd@ceb.lk",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
								mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
								
							}else{
								mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"ruchirag1986@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
								
							}
							
						}else{
							mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"ruchirag1986@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
							
						}
						
						
						
						
						} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else if(deptId.equalsIgnoreCase("780.00")){
					//Util.trustEveryone();
					try {
						//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"eranga.bogahakumbura@gmail.com","eranga.bogahakumbura@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
						
						
						if(userMm != null){
							if(userMm.getEmail() != null){
								System.out.println("userMm.getEmail() "+ userMm.getEmail());
								if(userMmEs != null){
									if(userMmEs.getEmail() != null){
										
										String[] email = new String[2];
										email[0]= userMmEs.getEmail();
										email[1]= "cehlcmphm.dd3@ceb.lk";
										
										mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,userMm.getEmail(),email,subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
								        
									}else{
										mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,userMm.getEmail(),"cehlcmphm.dd3@ceb.lk",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
										//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"cehlcmphm.dd3@ceb.lk",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
										 
									}
									
								}else{
									mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,userMm.getEmail(),"cehlcmphm.dd3@ceb.lk",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
									//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"cehlcmphm.dd3@ceb.lk",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
									
								}
								
								//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,userMm.getEmail(),subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
						        //mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,userMm.getEmail(),subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
								//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"gchampika28@gmail.com","mgrisd@ceb.lk",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
								mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
								
							}else{
								mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"cehlcmphm.dd3@ceb.lk",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
								
							}
							
						}else{
							mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"cehlcmphm.dd3@ceb.lk",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
							
						}
						
						
						
						
						} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					
					//mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"widana1971@gmail.com","gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
					
				}else if(deptId.equalsIgnoreCase("596.00")){
					//Util.trustEveryone();
					mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"missaka231@yahoo.com","gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
					
				}else{
					//Util.trustEveryone();
					mm.sendMailTo("Chief Engineer/Maintenance Engineer", content ,"eranga.bogahakumbura@gmail.com","gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
					
				}
				try {
					//Util.trustEveryone();
					
					restTemplate.getForObject(url, String.class);
				} catch (RestClientException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					//Util.trustEveryone();
					
					//restTemplate.getForObject(urlCE, String.class);
				} catch (RestClientException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			} catch (Exception e) {
				System.out.println("finish 17 "+e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(appr.getFromtowerId()!=null){
	        	System.out.println("getFromtowerId:" + appr.getFromtowerId() );
	        	MmsAddsupport objSup = addSupport.findById(new Long(appr.getFromtowerId().toString()));
	        	objSup.setInterruptedYes(new BigDecimal("0"));
	        	objSup.setInterruptedDate(appr.getApprovedDate());
	        	objSup.setInterruptionNo(appr.getApprovalId());
	        	addSupport.update(objSup);
	        	
	        }
	        
	        if(appr.getTotowerId()!=null){
	        	System.out.println("getTotowerId:" + appr.getTotowerId() );
	        	
	        	MmsAddsupport objSup = addSupport.findById(new Long(appr.getTotowerId().toString()));
	        	
	        	objSup.setInterruptedYes(new BigDecimal("0"));
	        	objSup.setInterruptedDate(appr.getApprovedDate());
	        	objSup.setInterruptionNo(appr.getApprovalId());
	        	addSupport.update(objSup);
	        	
	        }
	        
	        
			

			PivModel modelNew = new PivModel();
			String stringOflineIds = "";
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			List<MmsAddline> liness = addLine.findLineByArea(deptId);
			String province = deptDao.getDD(deptId);
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			String distDiv = glcompmDao.getDistDivision(province);
			List<Glcompm> line = glcompmDao.getProvinces(distDiv);

			List<String> provinces = new ArrayList<String>();
			int loop = line.size() - 1;
			for (int i = 0; i <= loop; i++) {
			System.out.println(i);
			Glcompm ojb = line.get(i);
			System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());
			}
			Map<String, String> saList = new LinkedHashMap<String, String>();
			List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
			int loopSa = saUserList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
			Sauserm ojb = saUserList.get(i);
			saList.put(ojb.getUserId(), ojb.getUserNm());
			}
			modelNew.setSaList(saList);
			Map<String, String> eeList = new LinkedHashMap<String, String>();
			List<Sauserm> eeUserList = secDao.getAllUserByRptUser(deptId, "EE");
			int loopEe = eeUserList.size() - 1;
			for (int i = 0; i <= loopEe; i++) {
			Sauserm ojb = eeUserList.get(i);
			eeList.put(ojb.getUserId(), ojb.getUserNm());

			}
			modelNew.setEeList(eeList);
			Map<String,String> lineList = new LinkedHashMap<String,String>();

			modelNew.setProvinceList(provinceList);
			
			
			modelNew.setMessage(success);
			//modelNew.setMode(model.getMode());
			mo = new ModelAndView("InterruptionRequest", "model",modelNew);
			
			mo.addObject("canGO", canGO);
			mo.addObject("type", "INTERRUPTION");
			
			mo.addObject("success", success);
			
			return mo;

		}
		
		
		@RequestMapping(value = "/goToInterruptionRequest", method = RequestMethod.GET)
		public ModelAndView goToInterruptionRequest(HttpServletRequest request,@RequestParam("mode") String mode) {
			
			String deptId = request.getSession().getAttribute("deptId").toString();
			String stringOflineIds = "";
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			Map<String, String> intReqList = new LinkedHashMap<String, String>();
			
			List<ApprovalMm>  listPendingIntReq = approvalMm.getAllInterruptionReq(deptId, "95", "INTREQ");
			System.out.println("tttt :"+listPendingIntReq.size());
			
			int insReqList = listPendingIntReq.size() - 1;
			for (int i = 0; i <= insReqList; i++) {
				System.out.println(i);
				ApprovalMm ojb = listPendingIntReq.get(i);
				intReqList.put(ojb.getApprovalId(), ojb.getApprovalId());

			}

			String canGO = "1";

			PivModel model = new PivModel();
			//model = loadProLineES(request,model);
			List<MmsAddline> liness = addLine.findLineByArea(deptId);
			String province = deptDao.getDD(deptId);
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			
			
			String distDiv = glcompmDao.getDistDivision(province);
			System.out.println("province :" + province + "distDiv : "+ distDiv);
			if(mode.equalsIgnoreCase("INTERRUPTION")){
				List<Glcompm> line = glcompmDao.getProvinces(distDiv);
				List<String> provinces = new ArrayList<String>();
				int loop = line.size() - 1;
				for (int i = 0; i <= loop; i++) {
					System.out.println(i);
					Glcompm ojb = line.get(i);

					System.out.println(ojb.getCompNm());
					provinces.add(ojb.getCompNm());
					provinceList.put(ojb.getCompId(), ojb.getCompNm());

				}
			}else{
				System.out.println("province 11 :");
				
				Glcompm obj = glcompmDao.getGlcompmByProvince(distDiv);
				System.out.println("province 1 :" + obj);
				
				provinceList.put(obj.getCompId(), obj.getCompNm());

				areaList.put(deptId, gldeptDao.getName(deptId));
				model.setAreaList(areaList);

			}
			Map<String, String> saList = new LinkedHashMap<String, String>();
			List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
						int loopSa = saUserList.size() - 1;
						for (int i = 0; i <= loopSa; i++) {
							//System.out.println(i);
							Sauserm ojb = saUserList.get(i);
							//System.out.println(ojb.getUserId());
							saList.put(ojb.getUserId(), ojb.getUserNm());

						}
						model.setSaList(saList);


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

			
			
			Map<String,String> lineList = new LinkedHashMap<String,String>();

			int lineLoop = liness.size()-1;
			for(int i=0;i<=lineLoop;i++){ 
				System.out.println(i);
				MmsAddline ojb = liness.get(i);
				lineList.put(String.valueOf(ojb.getCode()), ojb.getLineName());
		    } 
			
			//Map<String,String> areaList = new LinkedHashMap<String,String>();
			//areaList.put(deptId, gldeptDao.getName(deptId));
			//model.setAreaList(areaList);

			//model.setLineList(lineList);
			model.setProvinceList(provinceList);
			model.setIntRequest(intReqList);
			model.setMode(mode);
			//model.setError(error);
			//System.out.println("finish 22 "+ model.getMode());
			
			ModelAndView mo = new ModelAndView("InterruptionRequest", "model",model);
			
			mo.addObject("canGO", canGO);
			mo.addObject("type", mode);
			
			return mo;

		}
		
		
		/*@RequestMapping(value = "/findAll",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<MmsProvince> getProvincesByDeptid() {
			return provinceDao.findAll();
		}
		*/
		
		
		@RequestMapping(value = "/addGantry", method = RequestMethod.GET)
		public ModelAndView MMSaddGantry(HttpServletRequest request,@ModelAttribute("SaveGantry") PivModel newmodel) {
					Map<String, String> lineList = new LinkedHashMap<String, String>();
		                        Map<String, String> areaList = new LinkedHashMap<String, String>();
					Map<String, String> provinceList = new LinkedHashMap<String, String>();
					String userName = (String) request.getSession().getAttribute("loggedUser");
					String deptId = (String) request.getSession().getAttribute("deptId");
					String province = deptDao.getDD(deptId);
					String distDiv = glcompmDao.getDistDivision(province);
					PivModel model = new PivModel();
					List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
					
					
					List<String> provinces = new ArrayList<String>();
					int loop = province1.size() - 1;
					for (int i = 0; i <= loop; i++) {
						System.out.println(i);
						Glcompm ojb = province1.get(i);

						System.out.println(ojb.getCompNm());
						provinces.add(ojb.getCompNm());
						provinceList.put(ojb.getCompId(), ojb.getCompNm());

					}
					
					// ModelAndView model = new ModelAndView();
					model.setProvinceList(provinceList);
					model.setAreaList(areaList);
					model.setLineList(lineList);
					
					String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
					String status = null;

					String phmBranch = (String) request.getSession().getAttribute("deptId");
					deptId = deptId.trim();
					
					return new ModelAndView("MMS_addGantry", "SaveGantry", model);
					

				}

		

		@RequestMapping(value = "/MMSaddGantry", method = RequestMethod.POST)
			 public ModelAndView addGantry(@ModelAttribute("SaveGantry")  PivModel model,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception {
				String deptId = (String) request.getSession().getAttribute("deptId");
				String userName = (String) request.getSession().getAttribute("loggedUser");
				String userRole = (String) request.getSession().getAttribute("loggedUserRole");
				String message = "Welcome to Spring 4.0 !";
				System.out.println("code " + model.getGantry().getCode());
				model.getGantry().setPhmBranch(deptId);
				model.getGantry().setEntBy(userName);
				model.getGantry().setApprovalLevel(userRole);
				try{
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					Date today = Calendar.getInstance().getTime();        
					String reportDate = df.format(today);
					Date dateNowNew=null;

					DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
					Date insTimeDate=null;
					dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);

					SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
					String time = localDateFormat.format(new Date());
					model.getGantry().setEntDate(dateNowNew);
					model.getGantry().setEntTime(time);
					
				}
				catch(Exception e){
					
				}
				
				Map<String, String> lineList = new LinkedHashMap<String, String>();
		        Map<String, String> areaList = new LinkedHashMap<String, String>();
				Map<String, String> provinceList = new LinkedHashMap<String, String>();
				String resultobj = addGantry.addGantry(model.getGantry());
				PivModel newModel = new PivModel();
				String province = deptDao.getDD(deptId);
				String distDiv = glcompmDao.getDistDivision(province);
				List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
				
				
				List<String> provinces = new ArrayList<String>();
				int loop = province1.size() - 1;
				for (int i = 0; i <= loop; i++) {
					System.out.println(i);
					Glcompm ojb = province1.get(i);

					System.out.println(ojb.getCompNm());
					provinces.add(ojb.getCompNm());
					provinceList.put(ojb.getCompId(), ojb.getCompNm());

				}
				
				// ModelAndView model = new ModelAndView();
				newModel.setProvinceList(provinceList);
				newModel.setAreaList(areaList);
				newModel.setLineList(lineList);
				System.out.println("success");
				return new ModelAndView("MMS_addGantry", "SaveGantry", newModel);
			}	
		
		//Gantry
		
		
		@RequestMapping(value = "/MMSaddGeneral", method = RequestMethod.POST)
		public ModelAndView addGeneral(@ModelAttribute("SaveGeneral")  PivModel model,@RequestParam("file") MultipartFile file,@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2,@RequestParam("file3") MultipartFile file3,@RequestParam("file4") MultipartFile file4,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
		String deptId = (String) request.getSession().getAttribute("deptId");
		String userName = (String) request.getSession().getAttribute("loggedUser");
		String userRole = (String) request.getSession().getAttribute("loggedUserRole");
		String message = "Welcome to Spring 4.0 !";
		/*System.out.println("gantry " + model.getGantry());
		
		System.out.println("name " + model.getGantry().getName());
		System.out.println("nameh " + model.getGantry().getCode());
		
		if(model.getGantry().getName() == null){
			modelmap.addAttribute("ERROR_MESSAGE", " Gantry name is required");
			return new ModelAndView("MMS_addGeneral", "SaveGeneral", model);
			
		}
		*/System.out.println("code " + model.getGantry().getCode());
		model.getGantry().setPhmBranch(deptId);
		model.getGantry().setEntBy(userName);
		model.getGantry().setApprovalLevel(userRole);
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
        String status = null;
		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVAL_EE;
		}
		
		model.getGantry().setStatus(new BigDecimal(status));
		try{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Calendar.getInstance().getTime();        
		String reportDate = df.format(today);
		Date dateNowNew=null;

		DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
		Date insTimeDate=null;
		dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);

		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
		String time = localDateFormat.format(new Date());
		model.getGantry().setEntDate(dateNowNew);
		model.getGantry().setEntTime(time);

		String resultobj = addGantry.addGantry(model.getGantry());
		System.out.println("id : " + resultobj);
		
		
		File serverFile = null;
		File serverFile1 = null;
		File serverFile2 = null;
		File serverFile3 = null;
		File serverFile4 = null;
		
				
		
		String path = PathMMS.getReportPath();
		File dir = new File(path + File.separator + "EmailAttachment");
		if (!dir.exists())
			dir.mkdirs();
		
		
		if (!file.isEmpty()) {
			try {
				String name = file.getOriginalFilename();
				System.out.println("file name : "+ name );
				
				byte[] bytes = file.getBytes();
				String extension = Util.getSubStringFirstPart(name,".");

				
				name = resultobj + "_1"  +extension ;

				serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				
				stream.write(bytes);
				stream.close();
				
				
				
				
				
				}catch(Exception e){
				System.out.println("error :"+e);
			}
		}

		if (!file1.isEmpty()) {
			try {
				String name = file1.getOriginalFilename();
				System.out.println("file1 name : "+ name );
				String extension = Util.getSubStringFirstPart(name,".");

				byte[] bytes = file1.getBytes();
				name = resultobj + "_2" + extension ;

				serverFile1 = new File(dir.getAbsolutePath()+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile1));
				
				stream.write(bytes);
				stream.close();
									
				
				}catch(Exception e){
				System.out.println("error :"+e);
			}
		}
		System.out.println("finish 7 " );

		
		if (!file2.isEmpty()) {
			try {
				String name = file2.getOriginalFilename();
				byte[] bytes = file2.getBytes();
				String extension = Util.getSubStringFirstPart(name,".");

				name = resultobj + "_3" + extension ;

				serverFile2 = new File(dir.getAbsolutePath()+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile2));
				
				stream.write(bytes);
				stream.close();
				
				}catch(Exception e){
				System.out.println("error :"+e);
			}
		}
		System.out.println("finish 8 " );
		

		if (!file3.isEmpty()) {
try {
	String name = file3.getOriginalFilename();
	byte[] bytes = file3.getBytes();
	String extension = Util.getSubStringFirstPart(name,".");

	name = resultobj + "_4" + extension ;

	serverFile3 = new File(dir.getAbsolutePath()+ File.separator + name);
	BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile3));
	
	stream.write(bytes);
	stream.close();
	}catch(Exception e){
	System.out.println("error :"+e);
}
}

if (!file4.isEmpty()) {
try {
	String name = file4.getOriginalFilename();
	byte[] bytes = file4.getBytes();
	String extension = Util.getSubStringFirstPart(name,".");

	name = resultobj + "_5" + extension;

	serverFile4 = new File(dir.getAbsolutePath()+ File.separator + name);
	BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile4));
	
	stream.write(bytes);
	stream.close();
	}catch(Exception e){
	System.out.println("error :"+e);
}
}


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*MmsAddsupport objSupport = new MmsAddsupport();
		objSupport.setLineId(model.getGantry().getLineId());
		objSupport.setStatus(new BigDecimal("1"));
		objSupport.setSupportType(new BigDecimal("3"));
		objSupport.setGpsLatitude(model.getGantry().getGpsLatitude());
		objSupport.setGpsLongitude(model.getGantry().getGpsLongitude());
		objSupport.setPhmBranch(model.getGantry().getPhmBranch());
		objSupport.setGantryId(new BigDecimal(resultobj));
		objSupport.setArea(model.getGantry().getArea());
		objSupport.setTowerNo(model.getGantry().getCode());
		objSupport.setConductorType(new BigDecimal("6"));
		objSupport.setEarthConductorType(new BigDecimal("1"));
		objSupport.setTowerType(new BigDecimal("1"));
		objSupport.setTowerConfiguration(new BigDecimal("1"));

		addSupport.addSupport(objSupport);
*/
		}
		catch(Exception e){
		System.out.println("id : " + e);

		}

		Map<String, String> lineList = new LinkedHashMap<String, String>();
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		PivModel newModel = new PivModel();
		//newModel.addAttribute("serverError", " saved Successfully !");
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);


		List<String> provinces = new ArrayList<String>();
		int loop = province1.size() - 1;
		for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}

		// ModelAndView model = new ModelAndView();
		newModel.setProvinceList(provinceList);
		newModel.setAreaList(areaList);
		newModel.setLineList(lineList);
		System.out.println("success");
		//redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE","saved_successfully");
		//newModel.addAttribute("error", "The id selected is out of Range, please select another id within range");
		modelmap.addAttribute("SUCCESS_MESSAGE", "Saved Successfully");
		return new ModelAndView("MMS_addGeneral", "SaveGeneral", newModel);
		} 
		
		
		//add feeder
		
		@RequestMapping(value = "/getNextFeederId", method = RequestMethod.GET)
		public @ResponseBody String getNextFeederId(){
			String nextId = addFeeder.getNextFeerderId("F_");
			System.out.println(nextId);
			String feederId = "F_"+nextId;
			return feederId;
		}
		
		
		@RequestMapping(value = "/getNextSaId", method = RequestMethod.GET)
		public @ResponseBody String getNextSaId(){
			String nextId = saDao.getNextSurgeArrestorId("R_");
			System.out.println(nextId);
			String feederId = "R_"+nextId;
			return feederId;
		}
		
		@RequestMapping(value = "/getNextTrId", method = RequestMethod.GET)
		public @ResponseBody String getNextTrId(){
			System.out.println("feeder");
			
			String nextId = trDao.getNextTransformerId("T_");
			System.out.println(nextId);
			String feederId = "T_"+nextId;
			return feederId;
		}
		
		@RequestMapping(value = "/getNextSwitchesId", method = RequestMethod.GET)
		public @ResponseBody String getNextSwitchesId(){
			String nextId = addSwitch.getNextSwitchId("S_");
			System.out.println(nextId);
			String feederId = "S_"+nextId;
			return feederId;
		}
		
		
		
		
		
		@RequestMapping(value = "/MMSaddFeeder", method = RequestMethod.POST)
		 public ModelAndView addFeeder(@ModelAttribute("SaveFeeder")  PivModel model,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
			String deptId = (String) request.getSession().getAttribute("deptId");
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String userRole = (String) request.getSession().getAttribute("loggedUserRole");
			String message = "Welcome to Spring 4.0 !";
			System.out.println("feeder");
			System.out.println("TYPE " + model.getFeeder().getFeederType());
			String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
	        String status = null;
			if (userLevel.equals("DEO")) {
				status = Util.IN_BULK;
			} else if (userLevel.equals("ES")) {
				status = Util.VALIDATION_ES;
			} else if (userLevel.equals("EE")) {
				status = Util.APPROVAL_EE;
			}
			model.getFeeder().setStatus(new BigDecimal(status));				
			Map<String, String> lineList = new LinkedHashMap<String, String>();
	        Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			try{
				MmsAddfeederPK feederPK = new MmsAddfeederPK();
				String nextId = addFeeder.getNextFeerderId("F_");
				System.out.println(nextId);
				String feederId = "F_"+nextId;
				System.out.println(feederId);
				feederPK.setFeederId(feederId);
				System.out.println("gantryid :" + model.getFeeder().getId().getGantryId());
				
				feederPK.setGantryId(model.getFeeder().getId().getGantryId());
				
				model.getFeeder().setId(feederPK);
				System.out.println("////////////////////////////////////"+ model.getFeeder().getGpsLatitude());
				String resultobj = addFeeder.addFeeder(model.getFeeder());
				
				System.out.println("success");
				modelmap.addAttribute("SUCCESS_MESSAGE", "Saved Successfully");
			}
			catch(Exception e)
			{   System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
				System.out.print(e.getMessage());
			}
			
			PivModel newModel = new PivModel();
			//newModel.addAttribute("serverError", " saved Successfully !"); 
			String province = deptDao.getDD(deptId);
			String distDiv = glcompmDao.getDistDivision(province);
			List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
			
			
			List<String> provinces = new ArrayList<String>();
			int loop = province1.size() - 1;
			for (int i = 0; i <= loop; i++) {
				System.out.println(i);
				Glcompm ojb = province1.get(i);

				System.out.println(ojb.getCompNm());
				provinces.add(ojb.getCompNm());
				provinceList.put(ojb.getCompId(), ojb.getCompNm());

			}
			
			// ModelAndView model = new ModelAndView();
			newModel.setProvinceList(provinceList);
			newModel.setAreaList(areaList);
			newModel.setLineList(lineList);
			
			
			
			return new ModelAndView("MMS_addFeeder", "SaveFeeder", newModel);
		}



			@RequestMapping(value = "/addGeneral", method = RequestMethod.GET)
			public ModelAndView MMSaddGeneral(HttpServletRequest request,@ModelAttribute("SaveGeneral") PivModel newmodel) {
				Map<String, String> lineList = new LinkedHashMap<String, String>();
	            Map<String, String> areaList = new LinkedHashMap<String, String>();
				Map<String, String> provinceList = new LinkedHashMap<String, String>();
				String userName = (String) request.getSession().getAttribute("loggedUser");
				String deptId = (String) request.getSession().getAttribute("deptId");
				String province = deptDao.getDD(deptId);
				String distDiv = glcompmDao.getDistDivision(province);
				PivModel model = new PivModel();
				List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
				
				
				List<String> provinces = new ArrayList<String>();
				int loop = province1.size() - 1;
				for (int i = 0; i <= loop; i++) {
					System.out.println(i);
					Glcompm ojb = province1.get(i);

					System.out.println(ojb.getCompNm());
					provinces.add(ojb.getCompNm());
					provinceList.put(ojb.getCompId(), ojb.getCompNm());

				}
				
				// ModelAndView model = new ModelAndView();
				model.setProvinceList(provinceList);
				model.setAreaList(areaList);
				model.setLineList(lineList);
				
				String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
				String status = null;

				String phmBranch = (String) request.getSession().getAttribute("deptId");
				deptId = deptId.trim();
				
				return new ModelAndView("MMS_addGeneral", "SaveGeneral", model);
				

			}	
			
			
			
			/*@RequestMapping(value = "/displayGeneralNew", method = RequestMethod.GET)
			public ModelAndView displayGeneralNew(HttpServletRequest request,@ModelAttribute("UpdateGeneral") PivModel newmodel) {
				Map<String, String> lineList = new LinkedHashMap<String, String>();
	            Map<String, String> areaList = new LinkedHashMap<String, String>();
				Map<String, String> provinceList = new LinkedHashMap<String, String>();
				String userName = (String) request.getSession().getAttribute("loggedUser");
				String deptId = (String) request.getSession().getAttribute("deptId");
				String province = deptDao.getDD(deptId);
				String distDiv = glcompmDao.getDistDivision(province);
				PivModel model = new PivModel();
				List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
				
				
				List<String> provinces = new ArrayList<String>();
				int loop = province1.size() - 1;
				for (int i = 0; i <= loop; i++) {
					System.out.println(i);
					Glcompm ojb = province1.get(i);

					System.out.println(ojb.getCompNm());
					provinces.add(ojb.getCompNm());
					provinceList.put(ojb.getCompId(), ojb.getCompNm());

				}
				
				// ModelAndView model = new ModelAndView();
				model.setProvinceList(provinceList);
				model.setAreaList(areaList);
				model.setLineList(lineList);
				
				String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
				String status = null;

				String phmBranch = (String) request.getSession().getAttribute("deptId");
				deptId = deptId.trim();
				
				return new ModelAndView("displayGeneralNew", "UpdateGeneral", model);
				

			}
*/


	@RequestMapping(value = "/addFeeder", method = RequestMethod.GET)
			public ModelAndView MMSaddFeeder(HttpServletRequest request,@ModelAttribute("SaveFeeder") PivModel newmodel) {
				Map<String, String> lineList = new LinkedHashMap<String, String>();
	            Map<String, String> areaList = new LinkedHashMap<String, String>();
				Map<String, String> provinceList = new LinkedHashMap<String, String>();
				String userName = (String) request.getSession().getAttribute("loggedUser");
				String deptId = (String) request.getSession().getAttribute("deptId");
				String province = deptDao.getDD(deptId);
				String distDiv = glcompmDao.getDistDivision(province);
				PivModel model = new PivModel();
				List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
				
				
				List<String> provinces = new ArrayList<String>();
				int loop = province1.size() - 1;
				for (int i = 0; i <= loop; i++) {
					System.out.println(i);
					Glcompm ojb = province1.get(i);

					System.out.println(ojb.getCompNm());
					provinces.add(ojb.getCompNm());
					provinceList.put(ojb.getCompId(), ojb.getCompNm());

				}
				
				// ModelAndView model = new ModelAndView();
				model.setProvinceList(provinceList);
				model.setAreaList(areaList);
				model.setLineList(lineList);
				
				String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
				String status = null;

				String phmBranch = (String) request.getSession().getAttribute("deptId");
				deptId = deptId.trim();
				
				return new ModelAndView("MMS_addFeeder", "SaveFeeder", model);
				

			}
			
						
			@RequestMapping(value = "/addSurgeArrestor", method = RequestMethod.GET)
			public ModelAndView SaveSurgeArrestor(HttpServletRequest request,@ModelAttribute("SaveSurgeArrestor") PivModel newmodel) {
				Map<String, String> lineList = new LinkedHashMap<String, String>();
	            Map<String, String> areaList = new LinkedHashMap<String, String>();
				Map<String, String> provinceList = new LinkedHashMap<String, String>();
				String userName = (String) request.getSession().getAttribute("loggedUser");
				String deptId = (String) request.getSession().getAttribute("deptId");
				String province = deptDao.getDD(deptId);
				String distDiv = glcompmDao.getDistDivision(province);
				PivModel model = new PivModel();
				List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
				
				
				List<String> provinces = new ArrayList<String>();
				int loop = province1.size() - 1;
				for (int i = 0; i <= loop; i++) {
					System.out.println(i);
					Glcompm ojb = province1.get(i);

					System.out.println(ojb.getCompNm());
					provinces.add(ojb.getCompNm());
					provinceList.put(ojb.getCompId(), ojb.getCompNm());

				}
				
				// ModelAndView model = new ModelAndView();
				model.setProvinceList(provinceList);
				model.setAreaList(areaList);
				model.setLineList(lineList);
				
				String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
				String status = null;

				String phmBranch = (String) request.getSession().getAttribute("deptId");
				deptId = deptId.trim();
				
				return new ModelAndView("MMS_addSurgeArrestor", "SaveSurgeArrestor", model);
				

			}
			
			@RequestMapping(value = "/addTransformer", method = RequestMethod.GET)
			public ModelAndView SaveTransformer(HttpServletRequest request,@ModelAttribute("SaveTransformer") PivModel newmodel) {
				Map<String, String> lineList = new LinkedHashMap<String, String>();
	            Map<String, String> areaList = new LinkedHashMap<String, String>();
				Map<String, String> provinceList = new LinkedHashMap<String, String>();
				String userName = (String) request.getSession().getAttribute("loggedUser");
				String deptId = (String) request.getSession().getAttribute("deptId");
				String province = deptDao.getDD(deptId);
				String distDiv = glcompmDao.getDistDivision(province);
				PivModel model = new PivModel();
				List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
				
				
				List<String> provinces = new ArrayList<String>();
				int loop = province1.size() - 1;
				for (int i = 0; i <= loop; i++) {
					System.out.println(i);
					Glcompm ojb = province1.get(i);

					System.out.println(ojb.getCompNm());
					provinces.add(ojb.getCompNm());
					provinceList.put(ojb.getCompId(), ojb.getCompNm());

				}
				
				// ModelAndView model = new ModelAndView();
				model.setProvinceList(provinceList);
				model.setAreaList(areaList);
				model.setLineList(lineList);
				
				String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
				String status = null;

				String phmBranch = (String) request.getSession().getAttribute("deptId");
				deptId = deptId.trim();
				
				return new ModelAndView("MMS_addTransformer", "SaveTransformer", model);
				

			}
			
			@RequestMapping(value = "/addSwitch", method = RequestMethod.GET)
			public ModelAndView SaveSwitch(HttpServletRequest request,@ModelAttribute("SaveSwitch") PivModel newmodel) {
				Map<String, String> lineList = new LinkedHashMap<String, String>();
	            Map<String, String> areaList = new LinkedHashMap<String, String>();
				Map<String, String> provinceList = new LinkedHashMap<String, String>();
				String userName = (String) request.getSession().getAttribute("loggedUser");
				String deptId = (String) request.getSession().getAttribute("deptId");
				String province = deptDao.getDD(deptId);
				String distDiv = glcompmDao.getDistDivision(province);
				PivModel model = new PivModel();
				List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
				
				
				List<String> provinces = new ArrayList<String>();
				int loop = province1.size() - 1;
				for (int i = 0; i <= loop; i++) {
					System.out.println(i);
					Glcompm ojb = province1.get(i);

					System.out.println(ojb.getCompNm());
					provinces.add(ojb.getCompNm());
					provinceList.put(ojb.getCompId(), ojb.getCompNm());

				}
				
				// ModelAndView model = new ModelAndView();
				model.setProvinceList(provinceList);
				model.setAreaList(areaList);
				model.setLineList(lineList);
				
				String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
				String status = null;

				String phmBranch = (String) request.getSession().getAttribute("deptId");
				deptId = deptId.trim();
				
				return new ModelAndView("MMS_addSwitch", "SaveSwitch", model);
				

			}
			
			
			@RequestMapping(value = "/MMSupdateGeneral", method = RequestMethod.POST)
			 public ModelAndView updateGeneral(@ModelAttribute("UpdateGeneral")  PivModel model,@RequestParam("file") MultipartFile file,@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2,@RequestParam("file3") MultipartFile file3,@RequestParam("file4") MultipartFile file4,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
				String deptId = (String) request.getSession().getAttribute("deptId");
				String userName = (String) request.getSession().getAttribute("loggedUser");
				String userRole = (String) request.getSession().getAttribute("loggedUserRole");
				String message = "Welcome to Spring 4.0 !";
				System.out.println("code " + model.getGantry().getCode());
				model.getGantry().setPhmBranch(deptId);
				model.getGantry().setEntBy(userName);
				model.getGantry().setApprovalLevel(userRole);
				String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		        String status = null;
				if (userLevel.equals("DEO")) {
					status = Util.IN_BULK;
				} else if (userLevel.equals("ES")) {
					status = Util.VALIDATION_ES;
				} else if (userLevel.equals("EE")) {
					status = Util.APPROVAL_EE;
				}
				model.getGantry().setStatus(new BigDecimal(status));
				try{
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					Date today = Calendar.getInstance().getTime();        
					String reportDate = df.format(today);
					Date dateNowNew=null;

					DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
					Date insTimeDate=null;
					dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);

					SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
					String time = localDateFormat.format(new Date());
					model.getGantry().setEntDate(dateNowNew);
					model.getGantry().setEntTime(time);
					String resultobj = addGantry.updateGantry(model.getGantry());
					
					File serverFile = null;
					File serverFile1 = null;
					File serverFile2 = null;
					File serverFile3 = null;
					File serverFile4 = null;
					
							
					
					String path = PathMMS.getReportPath();
					File dir = new File(path + File.separator + "EmailAttachment");
					if (!dir.exists())
						dir.mkdirs();
					
					
					if (!file.isEmpty()) {
						try {
							String name = file.getOriginalFilename();
							System.out.println("file name : "+ name );
							
							byte[] bytes = file.getBytes();
							String extension = Util.getSubStringFirstPart(name,".");

							
							name = model.getGantry().getId() + "_1"  +extension ;

							serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
							BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
							
							stream.write(bytes);
							stream.close();
							
							
							
							
							
							}catch(Exception e){
							System.out.println("error :"+e);
						}
					}

					if (!file1.isEmpty()) {
						try {
							String name = file1.getOriginalFilename();
							System.out.println("file1 name : "+ name );
							String extension = Util.getSubStringFirstPart(name,".");

							byte[] bytes = file1.getBytes();
							name = model.getGantry().getId() + "_2" + extension ;

							serverFile1 = new File(dir.getAbsolutePath()+ File.separator + name);
							BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile1));
							
							stream.write(bytes);
							stream.close();
												
							
							}catch(Exception e){
							System.out.println("error :"+e);
						}
					}
					System.out.println("finish 7 " );

					
					if (!file2.isEmpty()) {
						try {
							String name = file2.getOriginalFilename();
							byte[] bytes = file2.getBytes();
							String extension = Util.getSubStringFirstPart(name,".");

							name = model.getGantry().getId() + "_3" + extension ;

							serverFile2 = new File(dir.getAbsolutePath()+ File.separator + name);
							BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile2));
							
							stream.write(bytes);
							stream.close();
							
							}catch(Exception e){
							System.out.println("error :"+e);
						}
					}
					System.out.println("finish 8 " );
					

					if (!file3.isEmpty()) {
			try {
				String name = file3.getOriginalFilename();
				byte[] bytes = file3.getBytes();
				String extension = Util.getSubStringFirstPart(name,".");

				name = model.getGantry().getId() + "_4" + extension ;

				serverFile3 = new File(dir.getAbsolutePath()+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile3));
				
				stream.write(bytes);
				stream.close();
				}catch(Exception e){
				System.out.println("error :"+e);
			}
			}

			if (!file4.isEmpty()) {
			try {
				String name = file4.getOriginalFilename();
				byte[] bytes = file4.getBytes();
				String extension = Util.getSubStringFirstPart(name,".");

				name = model.getGantry().getId() + "_5" + extension;

				serverFile4 = new File(dir.getAbsolutePath()+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile4));
				
				stream.write(bytes);
				stream.close();
				}catch(Exception e){
				System.out.println("error :"+e);
			}
			}

					
					
					
					
					
					
					
					
					
					modelmap.addAttribute("SUCCESS_MESSAGE", "Update Successfully");
					
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
				
				Map<String, String> lineList = new LinkedHashMap<String, String>();
		        Map<String, String> areaList = new LinkedHashMap<String, String>();
				Map<String, String> provinceList = new LinkedHashMap<String, String>();
				
				
				PivModel newModel = new PivModel();
				//newModel.addAttribute("serverError", " saved Successfully !"); 
				String province = deptDao.getDD(deptId);
				String distDiv = glcompmDao.getDistDivision(province);
				List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
				
				
				List<String> provinces = new ArrayList<String>();
				int loop = province1.size() - 1;
				for (int i = 0; i <= loop; i++) {
					System.out.println(i);
					Glcompm ojb = province1.get(i);

					System.out.println(ojb.getCompNm());
					provinces.add(ojb.getCompNm());
					provinceList.put(ojb.getCompId(), ojb.getCompNm());

				}
				
				// ModelAndView model = new ModelAndView();
				newModel.setProvinceList(provinceList);
				newModel.setAreaList(areaList);
				newModel.setLineList(lineList);
				System.out.println("success");
				//redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE","saved_successfully");
				//newModel.addAttribute("error", "The id selected is out of Range, please select another id within range");
				
				return new ModelAndView("displayGeneralNew", "UpdateGeneral", newModel);
			}
			
			@RequestMapping(value = "/MMSupdateGeneralApproval", method = RequestMethod.POST)
			 public ModelAndView MMSupdateGeneralApproval(@ModelAttribute("UpdateGeneral")  PivModel model,@RequestParam("file") MultipartFile file,@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2,@RequestParam("file3") MultipartFile file3,@RequestParam("file4") MultipartFile file4,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
				String deptId = (String) request.getSession().getAttribute("deptId");
				String userName = (String) request.getSession().getAttribute("loggedUser");
				String userRole = (String) request.getSession().getAttribute("loggedUserRole");
				String message = "Welcome to Spring 4.0 !";
				System.out.println("code " + model.getGantry().getCode());
				model.getGantry().setPhmBranch(deptId);
				model.getGantry().setEntBy(userName);
				model.getGantry().setApprovalLevel(userRole);
				String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		        String status = null;
				if (userLevel.equals("DEO")) {
					status = Util.VALIDATION_ES;
				} else if (userLevel.equals("ES")) {
					status = Util.APPROVAL_EE;
				} else if (userLevel.equals("EE")) {
					System.out.println( "status : "+model.getFeeder().getStatus());
					
					status = String.valueOf(model.getFeeder().getStatus());
					//status = Util.APPROVE;
					
					
				}
				model.getGantry().setStatus(new BigDecimal(status));
				try{
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					Date today = Calendar.getInstance().getTime();        
					String reportDate = df.format(today);
					Date dateNowNew=null;

					DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
					Date insTimeDate=null;
					dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);

					SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
					String time = localDateFormat.format(new Date());
					model.getGantry().setEntDate(dateNowNew);
					model.getGantry().setEntTime(time);
					model.getGantry().setApprovedBy(userName);
					String resultobj = addGantry.updateGantry(model.getGantry());
					
					File serverFile = null;
					File serverFile1 = null;
					File serverFile2 = null;
					File serverFile3 = null;
					File serverFile4 = null;
					
							
					
					String path = PathMMS.getReportPath();
					File dir = new File(path + File.separator + "EmailAttachment");
					if (!dir.exists())
						dir.mkdirs();
					
					
					if (!file.isEmpty()) {
						try {
							String name = file.getOriginalFilename();
							System.out.println("file name : "+ name );
							
							byte[] bytes = file.getBytes();
							String extension = Util.getSubStringFirstPart(name,".");

							
							name = model.getGantry().getId() + "_1"  +extension ;

							serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
							BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
							
							stream.write(bytes);
							stream.close();
							
							
							
							
							
							}catch(Exception e){
							System.out.println("error :"+e);
						}
					}

					if (!file1.isEmpty()) {
						try {
							String name = file1.getOriginalFilename();
							System.out.println("file1 name : "+ name );
							String extension = Util.getSubStringFirstPart(name,".");

							byte[] bytes = file1.getBytes();
							name = model.getGantry().getId() + "_2" + extension ;

							serverFile1 = new File(dir.getAbsolutePath()+ File.separator + name);
							BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile1));
							
							stream.write(bytes);
							stream.close();
												
							
							}catch(Exception e){
							System.out.println("error :"+e);
						}
					}
					System.out.println("finish 7 " );

					
					if (!file2.isEmpty()) {
						try {
							String name = file2.getOriginalFilename();
							byte[] bytes = file2.getBytes();
							String extension = Util.getSubStringFirstPart(name,".");

							name = model.getGantry().getId() + "_3" + extension ;

							serverFile2 = new File(dir.getAbsolutePath()+ File.separator + name);
							BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile2));
							
							stream.write(bytes);
							stream.close();
							
							}catch(Exception e){
							System.out.println("error :"+e);
						}
					}
					System.out.println("finish 8 " );
					

					if (!file3.isEmpty()) {
			try {
				String name = file3.getOriginalFilename();
				byte[] bytes = file3.getBytes();
				String extension = Util.getSubStringFirstPart(name,".");

				name = model.getGantry().getId() + "_4" + extension ;

				serverFile3 = new File(dir.getAbsolutePath()+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile3));
				
				stream.write(bytes);
				stream.close();
				}catch(Exception e){
				System.out.println("error :"+e);
			}
			}

			if (!file4.isEmpty()) {
			try {
				String name = file4.getOriginalFilename();
				byte[] bytes = file4.getBytes();
				String extension = Util.getSubStringFirstPart(name,".");

				name = model.getGantry().getId() + "_5" + extension;

				serverFile4 = new File(dir.getAbsolutePath()+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile4));
				
				stream.write(bytes);
				stream.close();
				}catch(Exception e){
				System.out.println("error :"+e);
			}
			}

					
					
					
					
					
					
					
					
					
					modelmap.addAttribute("SUCCESS_MESSAGE", "Update Successfully");
					
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
				
				Map<String, String> lineList = new LinkedHashMap<String, String>();
		        Map<String, String> areaList = new LinkedHashMap<String, String>();
				Map<String, String> provinceList = new LinkedHashMap<String, String>();
				
				
				PivModel newModel = new PivModel();
				//newModel.addAttribute("serverError", " saved Successfully !"); 
				String province = deptDao.getDD(deptId);
				String distDiv = glcompmDao.getDistDivision(province);
				List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
				
				
				List<String> provinces = new ArrayList<String>();
				int loop = province1.size() - 1;
				for (int i = 0; i <= loop; i++) {
					System.out.println(i);
					Glcompm ojb = province1.get(i);

					System.out.println(ojb.getCompNm());
					provinces.add(ojb.getCompNm());
					provinceList.put(ojb.getCompId(), ojb.getCompNm());

				}
				
				// ModelAndView model = new ModelAndView();
				newModel.setProvinceList(provinceList);
				newModel.setAreaList(areaList);
				newModel.setLineList(lineList);
				System.out.println("success");
				//redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE","saved_successfully");
				//newModel.addAttribute("error", "The id selected is out of Range, please select another id within range");
				
				return new ModelAndView("displayGeneralApproval", "UpdateGeneral", newModel);
			}

			
			
			@RequestMapping(value = "/MMSupdateGeneralApprovedData", method = RequestMethod.POST)
			 public ModelAndView MMSupdateGeneralApprovedData(@ModelAttribute("UpdateGeneral")  PivModel model,@RequestParam("file") MultipartFile file,@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2,@RequestParam("file3") MultipartFile file3,@RequestParam("file4") MultipartFile file4,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
				String deptId = (String) request.getSession().getAttribute("deptId");
				String userName = (String) request.getSession().getAttribute("loggedUser");
				String userRole = (String) request.getSession().getAttribute("loggedUserRole");
				String message = "Welcome to Spring 4.0 !";
				System.out.println("code " + model.getGantry().getCode());
				model.getGantry().setPhmBranch(deptId);
				model.getGantry().setEntBy(userName);
				model.getGantry().setApprovalLevel(userRole);
				String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		        String status = null;
				if (userLevel.equals("DEO")) {
					status = Util.VALIDATION_ES;
				} else if (userLevel.equals("ES")) {
					status = Util.APPROVAL_EE;
				} else if (userLevel.equals("EE")) {
					System.out.println( "status : "+model.getFeeder().getStatus());
					
					status = String.valueOf(model.getFeeder().getStatus());
					
					//status = Util.APPROVE;
				}
				model.getGantry().setStatus(new BigDecimal(status));
				try{
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					Date today = Calendar.getInstance().getTime();        
					String reportDate = df.format(today);
					Date dateNowNew=null;

					DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
					Date insTimeDate=null;
					dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);

					SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
					String time = localDateFormat.format(new Date());
					model.getGantry().setEntDate(dateNowNew);
					model.getGantry().setEntTime(time);
					String resultobj = addGantry.updateGantry(model.getGantry());
					
					File serverFile = null;
					File serverFile1 = null;
					File serverFile2 = null;
					File serverFile3 = null;
					File serverFile4 = null;
					
							
					
					String path = PathMMS.getReportPath();
					File dir = new File(path + File.separator + "EmailAttachment");
					if (!dir.exists())
						dir.mkdirs();
					
					
					if (!file.isEmpty()) {
						try {
							String name = file.getOriginalFilename();
							System.out.println("file name : "+ name );
							
							byte[] bytes = file.getBytes();
							String extension = Util.getSubStringFirstPart(name,".");

							
							name = model.getGantry().getId() + "_1"  +extension ;

							serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
							BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
							
							stream.write(bytes);
							stream.close();
							
							
							
							
							
							}catch(Exception e){
							System.out.println("error :"+e);
						}
					}

					if (!file1.isEmpty()) {
						try {
							String name = file1.getOriginalFilename();
							System.out.println("file1 name : "+ name );
							String extension = Util.getSubStringFirstPart(name,".");

							byte[] bytes = file1.getBytes();
							name = model.getGantry().getId() + "_2" + extension ;

							serverFile1 = new File(dir.getAbsolutePath()+ File.separator + name);
							BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile1));
							
							stream.write(bytes);
							stream.close();
												
							
							}catch(Exception e){
							System.out.println("error :"+e);
						}
					}
					System.out.println("finish 7 " );

					
					if (!file2.isEmpty()) {
						try {
							String name = file2.getOriginalFilename();
							byte[] bytes = file2.getBytes();
							String extension = Util.getSubStringFirstPart(name,".");

							name = model.getGantry().getId() + "_3" + extension ;

							serverFile2 = new File(dir.getAbsolutePath()+ File.separator + name);
							BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile2));
							
							stream.write(bytes);
							stream.close();
							
							}catch(Exception e){
							System.out.println("error :"+e);
						}
					}
					System.out.println("finish 8 " );
					

					if (!file3.isEmpty()) {
			try {
				String name = file3.getOriginalFilename();
				byte[] bytes = file3.getBytes();
				String extension = Util.getSubStringFirstPart(name,".");

				name = model.getGantry().getId() + "_4" + extension ;

				serverFile3 = new File(dir.getAbsolutePath()+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile3));
				
				stream.write(bytes);
				stream.close();
				}catch(Exception e){
				System.out.println("error :"+e);
			}
			}

			if (!file4.isEmpty()) {
			try {
				String name = file4.getOriginalFilename();
				byte[] bytes = file4.getBytes();
				String extension = Util.getSubStringFirstPart(name,".");

				name = model.getGantry().getId() + "_5" + extension;

				serverFile4 = new File(dir.getAbsolutePath()+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile4));
				
				stream.write(bytes);
				stream.close();
				}catch(Exception e){
				System.out.println("error :"+e);
			}
			}

					
					
					
					
					
					
					
					
					
					modelmap.addAttribute("SUCCESS_MESSAGE", "Update Successfully");
					
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
				
				Map<String, String> lineList = new LinkedHashMap<String, String>();
		        Map<String, String> areaList = new LinkedHashMap<String, String>();
				Map<String, String> provinceList = new LinkedHashMap<String, String>();
				
				
				PivModel newModel = new PivModel();
				//newModel.addAttribute("serverError", " saved Successfully !"); 
				String province = deptDao.getDD(deptId);
				String distDiv = glcompmDao.getDistDivision(province);
				List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
				
				
				List<String> provinces = new ArrayList<String>();
				int loop = province1.size() - 1;
				for (int i = 0; i <= loop; i++) {
					System.out.println(i);
					Glcompm ojb = province1.get(i);

					System.out.println(ojb.getCompNm());
					provinces.add(ojb.getCompNm());
					provinceList.put(ojb.getCompId(), ojb.getCompNm());

				}
				
				// ModelAndView model = new ModelAndView();
				newModel.setProvinceList(provinceList);
				newModel.setAreaList(areaList);
				newModel.setLineList(lineList);
				System.out.println("success");
				//redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE","saved_successfully");
				//newModel.addAttribute("error", "The id selected is out of Range, please select another id within range");
				
				return new ModelAndView("displayGeneralApprovedData", "UpdateGeneral", newModel);
			}

		



			@RequestMapping(value = "/getGantry/{gantry_code}",method = RequestMethod.GET, produces = "application/json")
			public @ResponseBody List<MmsAddgantry> getGantry(@PathVariable("gantry_code") String code) {
				System.out.println("code --------------------------------------------->>>>>>> "+code);
				return addGantry.getGantryData(code);
				}
	


	@RequestMapping(value = "/displayGeneralNew", method = RequestMethod.GET)
			public ModelAndView displayGeneralNew(HttpServletRequest request,@ModelAttribute("UpdateGeneral") PivModel newmodel) {
				Map<String, String> lineList = new LinkedHashMap<String, String>();
	            Map<String, String> areaList = new LinkedHashMap<String, String>();
				Map<String, String> provinceList = new LinkedHashMap<String, String>();
				String userName = (String) request.getSession().getAttribute("loggedUser");
				String deptId = (String) request.getSession().getAttribute("deptId");
				String province = deptDao.getDD(deptId);
				String distDiv = glcompmDao.getDistDivision(province);
				PivModel model = new PivModel();
				List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
				
				
				List<String> provinces = new ArrayList<String>();
				int loop = province1.size() - 1;
				for (int i = 0; i <= loop; i++) {
					System.out.println(i);
					Glcompm ojb = province1.get(i);

					System.out.println(ojb.getCompNm());
					provinces.add(ojb.getCompNm());
					provinceList.put(ojb.getCompId(), ojb.getCompNm());

				}
				
				// ModelAndView model = new ModelAndView();
				model.setProvinceList(provinceList);
				model.setAreaList(areaList);
				model.setLineList(lineList);
				
				String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
				String status = null;

				String phmBranch = (String) request.getSession().getAttribute("deptId");
				deptId = deptId.trim();
				
				return new ModelAndView("displayGeneralNew", "UpdateGeneral", model);
				

			}
	
	
	@RequestMapping(value = "/displayGeneralNewApproval", method = RequestMethod.GET)
	public ModelAndView displayGeneralNewApproval(HttpServletRequest request,@ModelAttribute("UpdateGeneral") PivModel newmodel) {
		Map<String, String> lineList = new LinkedHashMap<String, String>();
        Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		String userName = (String) request.getSession().getAttribute("loggedUser");
		String deptId = (String) request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		PivModel model = new PivModel();
		List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
		
		
		List<String> provinces = new ArrayList<String>();
		int loop = province1.size() - 1;
		for (int i = 0; i <= loop; i++) {
			System.out.println(i);
			Glcompm ojb = province1.get(i);

			System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}
		
		// ModelAndView model = new ModelAndView();
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		String status = null;

		String phmBranch = (String) request.getSession().getAttribute("deptId");
		deptId = deptId.trim();
		
		return new ModelAndView("displayGeneralApproval", "UpdateGeneral", model);
		

	}
	
	
	
	@RequestMapping(value = "/displayGeneralNewApprovedData", method = RequestMethod.GET)
	public ModelAndView displayGeneralNewApprovedData(HttpServletRequest request,@ModelAttribute("UpdateGeneral") PivModel newmodel) {
		Map<String, String> lineList = new LinkedHashMap<String, String>();
        Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		String userName = (String) request.getSession().getAttribute("loggedUser");
		String deptId = (String) request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		PivModel model = new PivModel();
		List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
		
		
		List<String> provinces = new ArrayList<String>();
		int loop = province1.size() - 1;
		for (int i = 0; i <= loop; i++) {
			System.out.println(i);
			Glcompm ojb = province1.get(i);

			System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}
		
		// ModelAndView model = new ModelAndView();
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		model.setLineList(lineList);
		
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		String status = null;

		String phmBranch = (String) request.getSession().getAttribute("deptId");
		deptId = deptId.trim();
		
		return new ModelAndView("displayGeneralApprovedData", "UpdateGeneral", model);
		

	}


	
	
	@RequestMapping(value = "/MMSupdateFeeder", method = RequestMethod.POST)
	 public ModelAndView updateFeeder(@ModelAttribute("UpdateFeeder")  PivModel model,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
		String deptId = (String) request.getSession().getAttribute("deptId");
		String userName = (String) request.getSession().getAttribute("loggedUser");
		String userRole = (String) request.getSession().getAttribute("loggedUserRole");
		String message = "Welcome to Spring 4.0 !";
		System.out.println("feederID " + model.getFeeder().getId().getFeederId());
		System.out.println("gantryID "+ model.getFeeder().getId().getGantryId());
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
       String status = null;
		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVAL_EE;
		}
		model.getFeeder().setStatus(new BigDecimal(status));
		try{
			
			
			String resultobj = addFeeder.updateFeeder(model.getFeeder());
			System.out.println(model.getFeeder().getGpsLatitude());
			System.out.println(model.getFeeder().getGpsLongitude());
			modelmap.addAttribute("SUCCESS_MESSAGE", "Update Successfully");
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		Map<String, String> lineList = new LinkedHashMap<String, String>();
      Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		
		
		PivModel newModel = new PivModel();
		//newModel.addAttribute("serverError", " saved Successfully !"); 
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
		
		
		List<String> provinces = new ArrayList<String>();
		int loop = province1.size() - 1;
		for (int i = 0; i <= loop; i++) {
			System.out.println(i);
			Glcompm ojb = province1.get(i);

			System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}
		
		// ModelAndView model = new ModelAndView();
		newModel.setProvinceList(provinceList);
		newModel.setAreaList(areaList);
		newModel.setLineList(lineList);
		System.out.println("success");
		//redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE","saved_successfully");
		//newModel.addAttribute("error", "The id selected is out of Range, please select another id within range");
		
		return new ModelAndView("displayFeederNew", "UpdateFeeder", newModel);
	}
	
	@RequestMapping(value = "/MMSupdateFeederApprove", method = RequestMethod.POST)
	 public ModelAndView MMSupdateFeederApprove(@ModelAttribute("UpdateFeeder")  PivModel model,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
		String deptId = (String) request.getSession().getAttribute("deptId");
		String userName = (String) request.getSession().getAttribute("loggedUser");
		String userRole = (String) request.getSession().getAttribute("loggedUserRole");
		String message = "Welcome to Spring 4.0 !";
		System.out.println("feederID " + model.getFeeder().getId().getFeederId());
		System.out.println("gantryID "+ model.getFeeder().getId().getGantryId());
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
      String status = null;
		if (userLevel.equals("DEO")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("ES")) {
			status = Util.APPROVAL_EE;
		} else if (userLevel.equals("EE")) {
			//status = Util.APPROVE;
			System.out.println( "status : "+model.getFeeder().getStatus());
			
			status = String.valueOf(model.getFeeder().getStatus());
			
		}
		model.getFeeder().setStatus(new BigDecimal(status));
		try{
			
			String resultobj = addFeeder.updateFeeder(model.getFeeder());
			modelmap.addAttribute("SUCCESS_MESSAGE", "Update Successfully");
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		Map<String, String> lineList = new LinkedHashMap<String, String>();
     Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		
		
		PivModel newModel = new PivModel();
		//newModel.addAttribute("serverError", " saved Successfully !"); 
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
		
		
		List<String> provinces = new ArrayList<String>();
		int loop = province1.size() - 1;
		for (int i = 0; i <= loop; i++) {
			System.out.println(i);
			Glcompm ojb = province1.get(i);

			System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}
		
		// ModelAndView model = new ModelAndView();
		newModel.setProvinceList(provinceList);
		newModel.setAreaList(areaList);
		newModel.setLineList(lineList);
		System.out.println("success");
		//redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE","saved_successfully");
		//newModel.addAttribute("error", "The id selected is out of Range, please select another id within range");
		
		return new ModelAndView("displayFeederNewApprove", "UpdateFeeder", newModel);
	}
	
	
	
	@RequestMapping(value = "/MMSupdateFeederApprovedData", method = RequestMethod.POST)
	 public ModelAndView MMSupdateFeederApprovedData(@ModelAttribute("UpdateFeeder")  PivModel model,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
		String deptId = (String) request.getSession().getAttribute("deptId");
		String userName = (String) request.getSession().getAttribute("loggedUser");
		String userRole = (String) request.getSession().getAttribute("loggedUserRole");
		String message = "Welcome to Spring 4.0 !";
		System.out.println("feederID " + model.getFeeder().getId().getFeederId());
		System.out.println("gantryID "+ model.getFeeder().getId().getGantryId());
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
     String status = null;
		if (userLevel.equals("DEO")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("ES")) {
			status = Util.APPROVAL_EE;
		} else if (userLevel.equals("EE")) {
			System.out.println( "status : "+model.getFeeder().getStatus());
			
			status = String.valueOf(model.getFeeder().getStatus());
			
		}
		model.getFeeder().setStatus(new BigDecimal(status));
		try{
			System.out.println( "test : "+model.getFeeder().getGpsLatitude());
			System.out.println(model.getFeeder().getGpsLongitude());
			String resultobj = addFeeder.updateFeeder(model.getFeeder());
			modelmap.addAttribute("SUCCESS_MESSAGE", "Update Successfully");
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		Map<String, String> lineList = new LinkedHashMap<String, String>();
    Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		
		
		PivModel newModel = new PivModel();
		//newModel.addAttribute("serverError", " saved Successfully !"); 
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
		
		
		List<String> provinces = new ArrayList<String>();
		int loop = province1.size() - 1;
		for (int i = 0; i <= loop; i++) {
			System.out.println(i);
			Glcompm ojb = province1.get(i);

			System.out.println(ojb.getCompNm());
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}
		
		// ModelAndView model = new ModelAndView();
		newModel.setProvinceList(provinceList);
		newModel.setAreaList(areaList);
		newModel.setLineList(lineList);
		System.out.println("success");
		//redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE","saved_successfully");
		//newModel.addAttribute("error", "The id selected is out of Range, please select another id within range");
		
		return new ModelAndView("displayFeederNewApprovedData", "UpdateFeeder", newModel);
	}


	
	
	@RequestMapping(value = "/getFeeder/{feederId}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddfeeder> getFeeder(@PathVariable("feederId") String feederId) {
		System.out.println("FeederId --------------------------------------------->>>>>>> "+feederId);
		return addFeeder.getFeederData(feederId);
		}


@RequestMapping(value = "/findFeederByGantryId/{gantryId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddfeeder> findFeederByGantryId(@PathVariable("gantryId") String gantryId) {
	System.out.println("gantryId :" + gantryId);
	return addFeeder.getFeederByGantryId(gantryId);
	}

@RequestMapping(value = "/findFeederApproval/{gantryId}", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsAddfeeder> findFeederApproval(HttpServletRequest request,@PathVariable("gantryId") String gantryId) {
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
    
	String status = null;
	if (userLevel.equals("DEO")) {
		status = Util.IN_BULK;
	} else if (userLevel.equals("ES")) {
		status = Util.VALIDATION_ES;
	} else if (userLevel.equals("EE")) {
		status = Util.APPROVAL_EE;
	}
return addFeeder.getFeederByGantryId(gantryId,status);
}


@RequestMapping(value = "/findFeederByGantryIdStatus/{gantryId}/{status}", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsAddfeeder> findFeederByGantryId(@PathVariable("gantryId") String gantryId,@PathVariable("status") String status) {
System.out.println("gantryId :" + gantryId);
return addFeeder.getFeederByGantryId(gantryId,status);
}


@RequestMapping(value = "/findIncomingFeeder/{gantryId}/{type}", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsAddfeeder> findIncomingFeeder(@PathVariable("gantryId") String gantryId,@PathVariable("type") String type) {
System.out.println("gantryId :" + gantryId);
return addFeeder.getFeederByGantryIdType(gantryId, type);
}


@RequestMapping(value = "/findFeederByArea", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsAddfeeder> findFeederByArea(@RequestParam("area") String area) {
//System.out.println("gantryId :" + gantryId);
return addFeeder.getFeederByArea(area);
}



@RequestMapping(value = "/findSwitchByGantryId/{gantryId}/", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsAddswitch> findSwitchByGantryId(@PathVariable("gantryId") String gantryId) {
System.out.println("gantryId :" + gantryId);
return addSwitch.getSwitchByGantryId(gantryId);
}

@RequestMapping(value = "/findBusBarLocByGantryId/{gantryId}", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsGantryloc> findBusBarLocByGantryId(@PathVariable("gantryId") String gantryId) {
System.out.println("gantryId :" + gantryId);
return gantryLocDao.getGantryLoc(gantryId);
//return null;
}




@RequestMapping(value = "/findFeederByGantryIdNew/{gantryId}", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<Object[]> findFeederByGantryIdNew(@PathVariable("gantryId") String gantryId) {
System.out.println("gantryId :" + gantryId);
return addFeeder.getFeederByGantryIdNew(gantryId);
}


@RequestMapping(value = "/displayFeederNew", method = RequestMethod.GET)
public ModelAndView MMSupdateFeeder(HttpServletRequest request,@ModelAttribute("UpdateFeeder") PivModel newmodel) {
	Map<String, String> lineList = new LinkedHashMap<String, String>();
    Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String deptId = (String) request.getSession().getAttribute("deptId");
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	PivModel model = new PivModel();
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	model.setProvinceList(provinceList);
	model.setAreaList(areaList);
	model.setLineList(lineList);
	
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
	String status = null;

	String phmBranch = (String) request.getSession().getAttribute("deptId");
	deptId = deptId.trim();
	
	return new ModelAndView("displayFeederNew", "UpdateFeeder", model);
	

}


@RequestMapping(value = "/displayFeederNewApprove", method = RequestMethod.GET)
public ModelAndView displayFeederNewApprove(HttpServletRequest request,@ModelAttribute("UpdateFeeder") PivModel newmodel) {
	Map<String, String> lineList = new LinkedHashMap<String, String>();
    Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String deptId = (String) request.getSession().getAttribute("deptId");
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	PivModel model = new PivModel();
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	model.setProvinceList(provinceList);
	model.setAreaList(areaList);
	model.setLineList(lineList);
	
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
	String status = null;

	String phmBranch = (String) request.getSession().getAttribute("deptId");
	deptId = deptId.trim();
	
	return new ModelAndView("displayFeederNewApprove", "UpdateFeeder", model);
	

}


@RequestMapping(value = "/displayFeederNewApprovedData", method = RequestMethod.GET)
public ModelAndView displayFeederNewApprovedData(HttpServletRequest request,@ModelAttribute("UpdateFeeder") PivModel newmodel) {
	Map<String, String> lineList = new LinkedHashMap<String, String>();
    Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String deptId = (String) request.getSession().getAttribute("deptId");
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	PivModel model = new PivModel();
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	model.setProvinceList(provinceList);
	model.setAreaList(areaList);
	model.setLineList(lineList);
	
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
	String status = null;

	String phmBranch = (String) request.getSession().getAttribute("deptId");
	deptId = deptId.trim();
	
	return new ModelAndView("displayFeederNewApprovedData", "UpdateFeeder", model);
	

}




@RequestMapping(value = "/MMSaddSwitch", method = RequestMethod.POST)
public ModelAndView MMSaddSwitch(@ModelAttribute("SaveSwitch")  PivModel model,@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
	String deptId = (String) request.getSession().getAttribute("deptId");
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String userRole = (String) request.getSession().getAttribute("loggedUserRole");
	String message = "Welcome to Spring 4.0 !";
	System.out.println("AR");
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
   String status = null;
	if (userLevel.equals("DEO")) {
		status = Util.IN_BULK;
	} else if (userLevel.equals("ES")) {
		status = Util.VALIDATION_ES;
	} else if (userLevel.equals("EE")) {
		status = Util.APPROVAL_EE;
	}
	model.getSwitches().setStatus(new BigDecimal(status));
	Map<String, String> lineList = new LinkedHashMap<String, String>();
   Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	try{
		MmsAddswitchPK switchPK = new MmsAddswitchPK();
		String nextId = addSwitch.getNextSwitchId("S_");
		System.out.println(nextId);
		String switchId = "S_"+nextId;
		System.out.println(switchId);
		switchPK.setSwitchId(switchId);
		System.out.println("gantryid:" + model.getSwitches().getId().getGantryId());
		switchPK.setGantryId( model.getSwitches().getId().getGantryId());
		switchPK.setFeederId(model.getSwitches().getId().getFeederId());
		model.getSwitches().setId(switchPK);
		System.out.println("FeederId " + model.getSwitches().getId().getFeederId());
		System.out.println("GantryId " + model.getSwitches().getId().getGantryId());
		System.out.println("SwitchId " + model.getSwitches().getId().getSwitchId());
		System.out.println("Switch Type " + model.getSwitches().getSwitchType());
		System.out.println("////////////////////////////////////");
		String resultobj = addSwitch.addSwitch(model.getSwitches());
		System.out.println("success");
		modelmap.addAttribute("SUCCESS_MESSAGE", "Saved Successfully");
	}
	catch(Exception e)
	{   System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		System.out.print(e.getMessage());
	}
	
	File serverFile1 = null;
	File serverFile2 = null;
	
	String path = PathMMS.getReportPath();
	File dir = new File(path + File.separator + "EmailAttachment");
	if (!dir.exists())
		dir.mkdirs();
	
	
	if (!file1.isEmpty()) {
		try {
			String name = file1.getOriginalFilename();
			System.out.println("file name : "+ name );
			
			byte[] bytes = file1.getBytes();
			String extension = Util.getSubStringFirstPart(name,".");

			
			name = model.getSwitches().getId().getSwitchId() + "_1"  +extension ;

			serverFile1 = new File(dir.getAbsolutePath()+ File.separator + name);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile1));
			
			stream.write(bytes);
			stream.close();
			
			
			
			
			
			}catch(Exception e){
			System.out.println("error :"+e);
		}
	}
	
	if (!file2.isEmpty()) {
		try {
			String name = file2.getOriginalFilename();
			System.out.println("file name : "+ name );
			
			byte[] bytes = file2.getBytes();
			String extension = Util.getSubStringFirstPart(name,".");

			
			name = model.getSwitches().getId().getSwitchId() + "_2"  +extension ;

			serverFile2 = new File(dir.getAbsolutePath()+ File.separator + name);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile2));
			
			stream.write(bytes);
			stream.close();
			
			
			
			
			
			}catch(Exception e){
			System.out.println("error :"+e);
		}
	}



	
	
	
	
	PivModel newModel = new PivModel();
	//newModel.addAttribute("serverError", " saved Successfully !"); 
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	newModel.setProvinceList(provinceList);
	newModel.setAreaList(areaList);
	newModel.setLineList(lineList);
	
	
	
	return new ModelAndView("MMS_addSwitch", "SaveSwitch", newModel);
}


//update switches
@RequestMapping(value = "/MMSupdateSwitch", method = RequestMethod.POST)
public ModelAndView updateSwitch(@ModelAttribute("UpdateSwitch")  PivModel model,@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
	String deptId = (String) request.getSession().getAttribute("deptId");
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String userRole = (String) request.getSession().getAttribute("loggedUserRole");
	String message = "Welcome to Spring 4.0 !";
	System.out.println("feederID " + model.getSwitches().getId().getFeederId());
	System.out.println("gantryID "+ model.getSwitches().getId().getGantryId());
	System.out.println("SwitchID"+ model.getSwitches().getId().getSwitchId());
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
   String status = null;
	if (userLevel.equals("DEO")) {
		status = Util.IN_BULK;
	} else if (userLevel.equals("ES")) {
		status = Util.VALIDATION_ES;
	} else if (userLevel.equals("EE")) {
		status = Util.APPROVAL_EE;
	}
	model.getSwitches().setStatus(new BigDecimal(status));
	try{
		
		String resultobj = addSwitch.updateSwitch(model.getSwitches());
		modelmap.addAttribute("SUCCESS_MESSAGE", "Update Successfully");
		
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	
	File serverFile1 = null;
	File serverFile2 = null;
	String path = PathMMS.getReportPath();
	File dir = new File(path + File.separator + "EmailAttachment");
	if (!dir.exists())
		dir.mkdirs();
	
	
	if (!file1.isEmpty()) {
		try {
			String name = file1.getOriginalFilename();
			System.out.println("file name : "+ name );
			
			byte[] bytes = file1.getBytes();
			String extension = Util.getSubStringFirstPart(name,".");

			
			name = model.getSwitches().getId().getSwitchId() + "_1"  +extension ;

			serverFile1 = new File(dir.getAbsolutePath()+ File.separator + name);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile1));
			
			stream.write(bytes);
			stream.close();
			
			
			
			
			
			}catch(Exception e){
			System.out.println("error :"+e);
		}
	}

	if (!file2.isEmpty()) {
		try {
			String name = file2.getOriginalFilename();
			System.out.println("file name : "+ name );
			
			byte[] bytes = file2.getBytes();
			String extension = Util.getSubStringFirstPart(name,".");

			
			name = model.getSwitches().getId().getSwitchId() + "_2"  +extension ;

			serverFile2 = new File(dir.getAbsolutePath()+ File.separator + name);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile2));
			
			stream.write(bytes);
			stream.close();
			
			
			
			
			
			}catch(Exception e){
			System.out.println("error :"+e);
		}
	}

	
	
	
	
	Map<String, String> lineList = new LinkedHashMap<String, String>();
   Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	
	
	PivModel newModel = new PivModel();
	//newModel.addAttribute("serverError", " saved Successfully !"); 
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	newModel.setProvinceList(provinceList);
	newModel.setAreaList(areaList);
	newModel.setLineList(lineList);
	
	return new ModelAndView("displaySwitchesNew", "UpdateSwitch", newModel);
}




//update switches
@RequestMapping(value = "/MMSupdateSwitchApprove", method = RequestMethod.POST)
public ModelAndView MMSupdateSwitchApprove(@ModelAttribute("UpdateSwitch")  PivModel model,@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
	String deptId = (String) request.getSession().getAttribute("deptId");
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String userRole = (String) request.getSession().getAttribute("loggedUserRole");
	String message = "Welcome to Spring 4.0 !";
	System.out.println("feederID " + model.getSwitches().getId().getFeederId());
	System.out.println("gantryID "+ model.getSwitches().getId().getGantryId());
	System.out.println("SwitchID"+ model.getSwitches().getId().getSwitchId());
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
 String status = null;
	if (userLevel.equals("DEO")) {
		status = Util.VALIDATION_ES;
	} else if (userLevel.equals("ES")) {
		status = Util.APPROVAL_EE;
	} else if (userLevel.equals("EE")) {
		status = Util.APPROVE;
	}
	model.getSwitches().setStatus(new BigDecimal(status));
	try{
		
		String resultobj = addSwitch.updateSwitch(model.getSwitches());
		modelmap.addAttribute("SUCCESS_MESSAGE", "Update Successfully");
		
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	
	File serverFile1 = null;
	File serverFile2 = null;
	String path = PathMMS.getReportPath();
	File dir = new File(path + File.separator + "EmailAttachment");
	if (!dir.exists())
		dir.mkdirs();
	
	
	if (!file1.isEmpty()) {
		try {
			String name = file1.getOriginalFilename();
			System.out.println("file name : "+ name );
			
			byte[] bytes = file1.getBytes();
			String extension = Util.getSubStringFirstPart(name,".");

			
			name = model.getSwitches().getId().getSwitchId() + "_1"  +extension ;

			serverFile1 = new File(dir.getAbsolutePath()+ File.separator + name);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile1));
			
			stream.write(bytes);
			stream.close();
			
			
			
			
			
			}catch(Exception e){
			System.out.println("error :"+e);
		}
	}
	
	if (!file2.isEmpty()) {
		try {
			String name = file2.getOriginalFilename();
			System.out.println("file name : "+ name );
			
			byte[] bytes = file2.getBytes();
			String extension = Util.getSubStringFirstPart(name,".");

			
			name = model.getSwitches().getId().getSwitchId() + "_2"  +extension ;

			serverFile2 = new File(dir.getAbsolutePath()+ File.separator + name);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile2));
			
			stream.write(bytes);
			stream.close();
			
			
			
			
			
			}catch(Exception e){
			System.out.println("error :"+e);
		}
	}


	
	Map<String, String> lineList = new LinkedHashMap<String, String>();
 Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	
	
	PivModel newModel = new PivModel();
	//newModel.addAttribute("serverError", " saved Successfully !"); 
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	newModel.setProvinceList(provinceList);
	newModel.setAreaList(areaList);
	newModel.setLineList(lineList);
	
	return new ModelAndView("displaySwitchesNewApprove", "UpdateSwitch", newModel);
}



@RequestMapping(value = "/MMSupdateSwitchApprovedData", method = RequestMethod.POST)
public ModelAndView MMSupdateSwitchApprovedData(@ModelAttribute("UpdateSwitch")  PivModel model,@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
	String deptId = (String) request.getSession().getAttribute("deptId");
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String userRole = (String) request.getSession().getAttribute("loggedUserRole");
	String message = "Welcome to Spring 4.0 !";
	System.out.println("feederID " + model.getSwitches().getId().getFeederId());
	System.out.println("gantryID "+ model.getSwitches().getId().getGantryId());
	System.out.println("SwitchID"+ model.getSwitches().getId().getSwitchId());
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
 String status = null;
	if (userLevel.equals("DEO")) {
		status = Util.VALIDATION_ES;
	} else if (userLevel.equals("ES")) {
		status = Util.APPROVAL_EE;
	} else if (userLevel.equals("EE")) {
		status = Util.APPROVE;
	}
	model.getSwitches().setStatus(new BigDecimal(status));
	try{
		
		String resultobj = addSwitch.updateSwitch(model.getSwitches());
		modelmap.addAttribute("SUCCESS_MESSAGE", "Update Successfully");
		
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	
	File serverFile1 = null;
	File serverFile2 = null;
	String path = PathMMS.getReportPath();
	File dir = new File(path + File.separator + "EmailAttachment");
	if (!dir.exists())
		dir.mkdirs();
	
	
	if (!file1.isEmpty()) {
		try {
			String name = file1.getOriginalFilename();
			System.out.println("file name : "+ name );
			
			byte[] bytes = file1.getBytes();
			String extension = Util.getSubStringFirstPart(name,".");

			
			name = model.getSwitches().getId().getSwitchId() + "_1"  +extension ;

			serverFile1 = new File(dir.getAbsolutePath()+ File.separator + name);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile1));
			
			stream.write(bytes);
			stream.close();
			
			
			
			
			
			}catch(Exception e){
			System.out.println("error :"+e);
		}
	}
	
	if (!file2.isEmpty()) {
		try {
			String name = file2.getOriginalFilename();
			System.out.println("file name : "+ name );
			
			byte[] bytes = file2.getBytes();
			String extension = Util.getSubStringFirstPart(name,".");

			
			name = model.getSwitches().getId().getSwitchId() + "_2"  +extension ;

			serverFile2 = new File(dir.getAbsolutePath()+ File.separator + name);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile2));
			
			stream.write(bytes);
			stream.close();
			
			
			
			
			
			}catch(Exception e){
			System.out.println("error :"+e);
		}
	}


	
	Map<String, String> lineList = new LinkedHashMap<String, String>();
 Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	
	
	PivModel newModel = new PivModel();
	//newModel.addAttribute("serverError", " saved Successfully !"); 
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	newModel.setProvinceList(provinceList);
	newModel.setAreaList(areaList);
	newModel.setLineList(lineList);
	
	return new ModelAndView("displaySwitchesNewApprovedData", "UpdateSwitch", newModel);
}





@RequestMapping(value = "/displaySwitchNew", method = RequestMethod.GET)
public ModelAndView UpdateSwitch(HttpServletRequest request,@ModelAttribute("UpdateSwitch") PivModel newmodel) {
	Map<String, String> lineList = new LinkedHashMap<String, String>();
   Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String deptId = (String) request.getSession().getAttribute("deptId");
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	PivModel model = new PivModel();
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	model.setProvinceList(provinceList);
	model.setAreaList(areaList);
	model.setLineList(lineList);
	
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
	String status = null;

	String phmBranch = (String) request.getSession().getAttribute("deptId");
	deptId = deptId.trim();
	
	return new ModelAndView("displaySwitchesNew", "UpdateSwitch", model);
	

}

@RequestMapping(value = "/displaySwitchNewApprove", method = RequestMethod.GET)
public ModelAndView displaySwitchNewApprove(HttpServletRequest request,@ModelAttribute("UpdateSwitch") PivModel newmodel) {
	Map<String, String> lineList = new LinkedHashMap<String, String>();
   Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String deptId = (String) request.getSession().getAttribute("deptId");
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	PivModel model = new PivModel();
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	model.setProvinceList(provinceList);
	model.setAreaList(areaList);
	model.setLineList(lineList);
	
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
	String status = null;

	String phmBranch = (String) request.getSession().getAttribute("deptId");
	deptId = deptId.trim();
	
	return new ModelAndView("displaySwitchesNewApprove", "UpdateSwitch", model);
	

}


@RequestMapping(value = "/displaySwitchNewApprovedData", method = RequestMethod.GET)
public ModelAndView displaySwitchNewApprovedData(HttpServletRequest request,@ModelAttribute("UpdateSwitch") PivModel newmodel) {
	Map<String, String> lineList = new LinkedHashMap<String, String>();
   Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String deptId = (String) request.getSession().getAttribute("deptId");
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	PivModel model = new PivModel();
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	model.setProvinceList(provinceList);
	model.setAreaList(areaList);
	model.setLineList(lineList);
	
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
	String status = null;

	String phmBranch = (String) request.getSession().getAttribute("deptId");
	deptId = deptId.trim();
	
	return new ModelAndView("displaySwitchesNewApprovedData", "UpdateSwitch", model);
	

}



@RequestMapping(value = "/findSwitchByFeederIdApproval/{feederId}/{switchType}", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsAddswitch> findSwitchByFeederIdApproval(HttpServletRequest request,@PathVariable("feederId") String feederId,@PathVariable("switchType") String switchType) {
System.out.println("feederId :" + feederId);
System.out.println("switchType :" + switchType);
String userLevel = request.getSession().getAttribute("loggedUserRole").toString();

String status = null;
if (userLevel.equals("DEO")) {
	status = Util.IN_BULK;
} else if (userLevel.equals("ES")) {
	status = Util.VALIDATION_ES;
} else if (userLevel.equals("EE")) {
	status = Util.APPROVAL_EE;
}
return addSwitch.getSwitchByFeederId(feederId,switchType,status);
}



@RequestMapping(value = "/findSwitchByFeederId/{feederId}/{switchType}", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsAddswitch> findSwitchByFeederId(@PathVariable("feederId") String feederId,@PathVariable("switchType") String switchType) {
System.out.println("feederId :" + feederId);
System.out.println("switchType :" + switchType);
return addSwitch.getSwitchByFeederId(feederId,switchType);
}

@RequestMapping(value = "/getGantryLoc/{gantryId}",method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsGantryloc> getGantryLoc(@PathVariable("gantryId") String gantryId) {
	System.out.println("gantryId --------------------------------------------->>>>>>> "+gantryId);
	return addGantry.getGantryLocData(gantryId);
	}

@RequestMapping(value = "/getGantryLocArea",method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsGantryloc> getGantryLocArea(@RequestParam("area") String area) {
	System.out.println("gantryId --------------------------------------------->>>>>>> ");
	return gantryLocDao.getGantryLocArea(area);
	}



@RequestMapping(value = "/MMSaddBusbar", method = RequestMethod.POST)
public ModelAndView MMSaddBus(@ModelAttribute("SaveBusbar")  PivModel model,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
	String deptId = (String) request.getSession().getAttribute("deptId");
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String userRole = (String) request.getSession().getAttribute("loggedUserRole");
	String message = "Welcome to Spring 4.0 !";
	System.out.println("gantry Id " + model.getGantry().getId());
	model.getGantry().setPhmBranch(deptId);
	model.getGantry().setEntBy(userName);
	model.getGantry().setApprovalLevel(userRole);
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
   String status = null;
	if (userLevel.equals("DEO")) {
		status = Util.IN_BULK;
	} else if (userLevel.equals("ES")) {
		status = Util.VALIDATION_ES;
	} else if (userLevel.equals("EE")) {
		status = Util.APPROVAL_EE;
	}
	model.getGantry().setStatus(new BigDecimal(status));
	try{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Calendar.getInstance().getTime();        
		String reportDate = df.format(today);
		Date dateNowNew=null;

		DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
		Date insTimeDate=null;
		dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
		String time = localDateFormat.format(new Date());
		model.getGantry().setEntDate(dateNowNew);
		model.getGantry().setEntTime(time);
		
   
		MmsAddgantry obj = addGantry.findById(model.getGantry().getId());
		obj.setBusBarAbs(model.getGantry().getBusBarAbs());
		obj.setBusBarLbs(model.getGantry().getBusBarLbs());
		obj.setBusBarCondutoer(model.getGantry().getBusBarCondutoer());
		obj.setBusBarDdlo(model.getGantry().getBusBarDdlo());
		obj.setBusBarInsulator(model.getGantry().getBusBarInsulator());
		obj.setBusBarNoTranformer(model.getGantry().getBusBarNoTranformer());
		obj.setBusBarSa(model.getGantry().getBusBarSa());
		
		String resultobj = addGantry.updateGantry(obj);
		modelmap.addAttribute("SUCCESS_MESSAGE", "saved Successfully");
		
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	
	Map<String, String> lineList = new LinkedHashMap<String, String>();
   Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	
	
	PivModel newModel = new PivModel();
	//newModel.addAttribute("serverError", " saved Successfully !"); 
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	newModel.setProvinceList(provinceList);
	newModel.setAreaList(areaList);
	newModel.setLineList(lineList);
	System.out.println("success");
	//redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE","saved_successfully");
	//newModel.addAttribute("error", "The id selected is out of Range, please select another id within range");
	
	return new ModelAndView("MMS_addBusbar", "SaveBusbar", newModel);
}




//update Bus bar & Auxiliary System


@RequestMapping(value = "/MMSupdateBusbar", method = RequestMethod.POST)
public ModelAndView MMSupdateBusbar(@ModelAttribute("UpdateBusbar")  PivModel model,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
	String deptId = (String) request.getSession().getAttribute("deptId");
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String userRole = (String) request.getSession().getAttribute("loggedUserRole");
	String message = "Welcome to Spring 4.0 !";
	System.out.println("gantry Id " + model.getGantry().getId());
	model.getGantry().setPhmBranch(deptId);
	model.getGantry().setEntBy(userName);
	model.getGantry().setApprovalLevel(userRole);
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
   String status = null;
	if (userLevel.equals("DEO")) {
		status = Util.IN_BULK;
	} else if (userLevel.equals("ES")) {
		status = Util.VALIDATION_ES;
	} else if (userLevel.equals("EE")) {
		status = Util.APPROVAL_EE;
	}
	model.getGantry().setStatus(new BigDecimal(status));
	try{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Calendar.getInstance().getTime();        
		String reportDate = df.format(today);
		Date dateNowNew=null;

		DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
		Date insTimeDate=null;
		dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
		String time = localDateFormat.format(new Date());
		model.getGantry().setEntDate(dateNowNew);
		model.getGantry().setEntTime(time);
		
   
		MmsAddgantry obj = addGantry.findById(model.getGantry().getId());
		obj.setBusBarAbs(model.getGantry().getBusBarAbs());
		obj.setBusBarLbs(model.getGantry().getBusBarLbs());
		obj.setBusBarCondutoer(model.getGantry().getBusBarCondutoer());
		obj.setBusBarDdlo(model.getGantry().getBusBarDdlo());
		obj.setBusBarInsulator(model.getGantry().getBusBarInsulator());
		obj.setBusBarNoTranformer(model.getGantry().getBusBarNoTranformer());
		obj.setBusBarSa(model.getGantry().getBusBarSa());
		
		String resultobj = addGantry.updateGantry(obj);
		modelmap.addAttribute("SUCCESS_MESSAGE", "Update Successfully");
		
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	
	Map<String, String> lineList = new LinkedHashMap<String, String>();
   Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	
	
	PivModel newModel = new PivModel();
	//newModel.addAttribute("serverError", " saved Successfully !"); 
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	newModel.setProvinceList(provinceList);
	newModel.setAreaList(areaList);
	newModel.setLineList(lineList);
	System.out.println("success");
	//redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE","saved_successfully");
	//newModel.addAttribute("error", "The id selected is out of Range, please select another id within range");
	
	return new ModelAndView("displayBusbar", "UpdateBusbar", newModel);
}

@RequestMapping(value = "/displayBusbarNew", method = RequestMethod.GET)
public ModelAndView displayBusbar(HttpServletRequest request,@ModelAttribute("UpdateBusbar") PivModel newmodel) {
	Map<String, String> lineList = new LinkedHashMap<String, String>();
   Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String deptId = (String) request.getSession().getAttribute("deptId");
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	PivModel model = new PivModel();
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	model.setProvinceList(provinceList);
	model.setAreaList(areaList);
	model.setLineList(lineList);
	
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
	String status = null;

	String phmBranch = (String) request.getSession().getAttribute("deptId");
	deptId = deptId.trim();
	
	return new ModelAndView("displayBusbar", "UpdateBusbar", model);
	

}


@RequestMapping(value = "/addBusbar", method = RequestMethod.GET)
public ModelAndView SaveBusbar(HttpServletRequest request,@ModelAttribute("SaveBusbar") PivModel newmodel) {
	Map<String, String> lineList = new LinkedHashMap<String, String>();
   Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String deptId = (String) request.getSession().getAttribute("deptId");
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	PivModel model = new PivModel();
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	model.setProvinceList(provinceList);
	model.setAreaList(areaList);
	model.setLineList(lineList);
	
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
	String status = null;

	String phmBranch = (String) request.getSession().getAttribute("deptId");
	deptId = deptId.trim();
	
	return new ModelAndView("MMS_addBusbar", "SaveBusbar", model);
	

}




@RequestMapping(value = "/addStructural", method = RequestMethod.GET)
public ModelAndView SaveStructural(HttpServletRequest request,@ModelAttribute("SaveStructural") PivModel newmodel) {
	Map<String, String> lineList = new LinkedHashMap<String, String>();
    Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String deptId = (String) request.getSession().getAttribute("deptId");
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	PivModel model = new PivModel();
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	model.setProvinceList(provinceList);
	model.setAreaList(areaList);
	model.setLineList(lineList);
	
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
	String status = null;

	String phmBranch = (String) request.getSession().getAttribute("deptId");
	deptId = deptId.trim();
	
	return new ModelAndView("MMS_addStructural", "SaveStructural", model);
	

}


//add Structural & Earthing System


@RequestMapping(value = "/MMSaddStructural", method = RequestMethod.POST)
public ModelAndView MMSaddStructural(@ModelAttribute("SaveStructural")  PivModel model,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
	String deptId = (String) request.getSession().getAttribute("deptId");
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String userRole = (String) request.getSession().getAttribute("loggedUserRole");
	String message = "Welcome to Spring 4.0 !";
	System.out.println("gantry Id " + model.getGantry().getId());
	model.getGantry().setPhmBranch(deptId);
	model.getGantry().setEntBy(userName);
	model.getGantry().setApprovalLevel(userRole);
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
   String status = null;
	if (userLevel.equals("DEO")) {
		status = Util.IN_BULK;
	} else if (userLevel.equals("ES")) {
		status = Util.VALIDATION_ES;
	} else if (userLevel.equals("EE")) {
		status = Util.APPROVAL_EE;
	}
	model.getGantry().setStatus(new BigDecimal(status));
	try{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Calendar.getInstance().getTime();        
		String reportDate = df.format(today);
		Date dateNowNew=null;

		DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
		Date insTimeDate=null;
		dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
		String time = localDateFormat.format(new Date());
		model.getGantry().setEntDate(dateNowNew);
		model.getGantry().setEntTime(time);
		
   
		MmsAddgantry obj = addGantry.findById(model.getGantry().getId());
		obj.setSeCuConRes(model.getGantry().getSeCuConRes());
		obj.setSeGroungRes(model.getGantry().getSeGroungRes());
		obj.setSeNoPoles(model.getGantry().getSeNoPoles());
		obj.setSeOverheadEarthing(model.getGantry().getSeOverheadEarthing());
		
		
		String resultobj = addGantry.updateGantry(obj);
		modelmap.addAttribute("SUCCESS_MESSAGE", "saved Successfully");
		
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	
	Map<String, String> lineList = new LinkedHashMap<String, String>();
   Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	
	
	PivModel newModel = new PivModel();
	//newModel.addAttribute("serverError", " saved Successfully !"); 
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	newModel.setProvinceList(provinceList);
	newModel.setAreaList(areaList);
	newModel.setLineList(lineList);
	System.out.println("success");
	
	return new ModelAndView("MMS_addStructural", "SaveStructural", newModel);
}
//update Bus bar & Auxiliary System


@RequestMapping(value = "/MMSupdateStructural", method = RequestMethod.POST)
public ModelAndView MMSupdateStructural(@ModelAttribute("UpdateStructural")  PivModel model,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes, ModelMap modelmap ) throws Exception {
	String deptId = (String) request.getSession().getAttribute("deptId");
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String userRole = (String) request.getSession().getAttribute("loggedUserRole");
	String message = "Welcome to Spring 4.0 !";
	System.out.println("gantry Id " + model.getGantry().getId());
	model.getGantry().setPhmBranch(deptId);
	model.getGantry().setEntBy(userName);
	model.getGantry().setApprovalLevel(userRole);
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
   String status = null;
	if (userLevel.equals("DEO")) {
		status = Util.IN_BULK;
	} else if (userLevel.equals("ES")) {
		status = Util.VALIDATION_ES;
	} else if (userLevel.equals("EE")) {
		status = Util.APPROVAL_EE;
	}
	model.getGantry().setStatus(new BigDecimal(status));
	try{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Calendar.getInstance().getTime();        
		String reportDate = df.format(today);
		Date dateNowNew=null;

		DateFormat df2 = new SimpleDateFormat("HH-MM-SS");
		Date insTimeDate=null;
		dateNowNew = new SimpleDateFormat("yyyy-MM-dd").parse(reportDate);
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
		String time = localDateFormat.format(new Date());
		model.getGantry().setEntDate(dateNowNew);
		model.getGantry().setEntTime(time);
		
   
		MmsAddgantry obj = addGantry.findById(model.getGantry().getId());
		obj.setSeCuConRes(model.getGantry().getSeCuConRes());
		obj.setSeGroungRes(model.getGantry().getSeGroungRes());
		obj.setSeNoPoles(model.getGantry().getSeNoPoles());
		obj.setSeOverheadEarthing(model.getGantry().getSeOverheadEarthing());
		
		String resultobj = addGantry.updateGantry(obj);
		modelmap.addAttribute("SUCCESS_MESSAGE", "Update Successfully");
		
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	
	Map<String, String> lineList = new LinkedHashMap<String, String>();
   Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	
	
	PivModel newModel = new PivModel();
	//newModel.addAttribute("serverError", " saved Successfully !"); 
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	newModel.setProvinceList(provinceList);
	newModel.setAreaList(areaList);
	newModel.setLineList(lineList);
	System.out.println("success");
	//redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE","saved_successfully");
	//newModel.addAttribute("error", "The id selected is out of Range, please select another id within range");
	
	return new ModelAndView("displayStructural", "UpdateStructural", newModel);
}


@RequestMapping(value = "/displayStructuralNew", method = RequestMethod.GET)
public ModelAndView displayStructural(HttpServletRequest request,@ModelAttribute("UpdateStructural") PivModel newmodel) {
	Map<String, String> lineList = new LinkedHashMap<String, String>();
    Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	String userName = (String) request.getSession().getAttribute("loggedUser");
	String deptId = (String) request.getSession().getAttribute("deptId");
	String province = deptDao.getDD(deptId);
	String distDiv = glcompmDao.getDistDivision(province);
	PivModel model = new PivModel();
	List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
	
	
	List<String> provinces = new ArrayList<String>();
	int loop = province1.size() - 1;
	for (int i = 0; i <= loop; i++) {
		System.out.println(i);
		Glcompm ojb = province1.get(i);

		System.out.println(ojb.getCompNm());
		provinces.add(ojb.getCompNm());
		provinceList.put(ojb.getCompId(), ojb.getCompNm());

	}
	
	// ModelAndView model = new ModelAndView();
	model.setProvinceList(provinceList);
	model.setAreaList(areaList);
	model.setLineList(lineList);
	
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
	String status = null;

	String phmBranch = (String) request.getSession().getAttribute("deptId");
	deptId = deptId.trim();
	
	return new ModelAndView("displayStructural", "UpdateStructural", model);
	

}

@RequestMapping(value = "/findGantryByArea/{area}", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsAddgantry> findGantryByArea(@PathVariable("area") String area) {
  System.out.println("area :" + area);
  return addGantry.getGantryByArea(area);
}

@RequestMapping(value = "/findGantryForApproval/{area}", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsAddgantry> findGantryForApproval(@PathVariable("area") String area,HttpServletRequest request) {
    System.out.println("findGantryForApproval :" + area);
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
	String status = null;
	if (userLevel.equals("DEO")) {
		status = Util.IN_BULK;
	} else if (userLevel.equals("ES")) {
		status = Util.VALIDATION_ES;
	} else if (userLevel.equals("EE")) {
		status = Util.APPROVAL_EE;
	}

return addGantry.getGantryByAreaStatus(area, status);
}



@RequestMapping(value = "/findGantryByAreaNew/{area}", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsAddgantry> findGantryByAreaNew(@PathVariable("area") String area) {
System.out.println("area :" + area);
return addGantry.getGantryByAreaNew(area);
}

@RequestMapping(value = "/findGantryByAreaNewView", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsAddgantry> findGantryByAreaNewView(@RequestParam("area") String area) {
System.out.println("area :" + area);
return addGantry.getGantryByAreaNew(area);
}



@RequestMapping(value = "/findGantryByAreaNewAll/{province}/{area}", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsAddgantry> findGantryByAreaNewAll(@PathVariable("province") String province,@PathVariable("area") String area) {
System.out.println("area :" + area);
return addGantry.getGantryByAreaNewAll(province,area);
}

@RequestMapping(value = "/findGantryByAreaNewAllWithDivision/{province}/{area}/{division}", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsAddgantry> findGantryByAreaNewAllWithDivision(@PathVariable("province") String province,@PathVariable("area") String area,@PathVariable("division") String division) {
System.out.println("area :" + area);
return addGantry.getGantryByAreaNewAllDivision(province,area,division);
}







@RequestMapping(value = "/displayAllGantry", method = RequestMethod.GET)
public ModelAndView displayAllGantry(HttpServletRequest request,@ModelAttribute("model")PivModel modelGantry) {
	System.out.println("modelGantry.getGantryid()1"+modelGantry.getGantryid());
	
	if(modelGantry.getGantryid() > 0){
		System.out.println("modelGantry.getGantryid()2"+modelGantry.getGantryid());
	}
	PivModel model = new PivModel();
	String deptId = request.getSession().getAttribute("deptId").toString();
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
    String status = null;
	if (userLevel.equals("DEO")) {
		status = Util.IN_BULK;
	} else if (userLevel.equals("ES")) {
		status = Util.VALIDATION_ES;
	} else if (userLevel.equals("EE")) {
		status = Util.APPROVAL_EE;
	}
	String phmBranch = (String) request.getSession().getAttribute("deptId");
	List<MmsAddgantry> gantryListEdit = addGantry.findGantryByStatus(status, phmBranch);
	model.setGantryListEdit(gantryListEdit);
	return new ModelAndView("displayAllGantryNew", "model", model);
}



@RequestMapping(value = "/displayAllGantryApprove", method = RequestMethod.GET)
public ModelAndView displayAllGantryApprove(HttpServletRequest request) {

	PivModel model = new PivModel();
	String deptId = request.getSession().getAttribute("deptId").toString();
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
    String status = null;
	/*if (userLevel.equals("DEO")) {
		status = Util.IN_BULK;
	} else if (userLevel.equals("ES")) {
		status = Util.VALIDATION_ES;
	} else if (userLevel.equals("EE")) {
		status = Util.APPROVAL_EE;
	}
	*/
    
    status = Util.APPROVE;
    String phmBranch = (String) request.getSession().getAttribute("deptId");
	System.out.println("phmbranch "+phmBranch);
	List<MmsAddgantry> gantryListEdit = addGantry.findGantryByStatus(status, phmBranch);
	model.setGantryListEdit(gantryListEdit);
	Map<String, String> lineList = new LinkedHashMap<String, String>();
	Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	String userName = (String) request.getSession().getAttribute("loggedUser");
	model.setProvinceList(provinceList);
	model.setAreaList(areaList);
    int supSize = gantryListEdit.size() - 1;
	String stringOfGantryIds = "";

	for (int i = 0; i <= supSize; i++) {
		MmsAddgantry obj = gantryListEdit.get(i);
		if (i != 0) {
			stringOfGantryIds = stringOfGantryIds + "," + Long.toString(obj.getId());
		} else {
			stringOfGantryIds = Long.toString(obj.getId());
		}
	}
	System.out.println("-------------------> stringOfGantryIds: " + stringOfGantryIds);

	model.setStringOfGantryIds(stringOfGantryIds);
	
	return new ModelAndView("displayAllGantry", "model", model);
}


/*@RequestMapping(value = "/displayAllGantryApproveEE", method = RequestMethod.GET)
public ModelAndView displayAllGantryApproveEE(HttpServletRequest request) {

	PivModel model = new PivModel();
	String deptId = request.getSession().getAttribute("deptId").toString();
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
    String status = null;
	if (userLevel.equals("DEO")) {
		status = Util.IN_BULK;
	} else if (userLevel.equals("ES")) {
		status = Util.VALIDATION_ES;
	} else if (userLevel.equals("EE")) {
		status = Util.APPROVAL_EE;
	}
	
    
    status = Util.APPROVE;
    String phmBranch = (String) request.getSession().getAttribute("deptId");
	System.out.println("phmbranch "+phmBranch);
	List<MmsAddgantry> gantryListEdit = addGantry.findGantryByStatus(status, phmBranch);
	model.setGantryListEdit(gantryListEdit);
	Map<String, String> lineList = new LinkedHashMap<String, String>();
	Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	String userName = (String) request.getSession().getAttribute("loggedUser");
	model.setProvinceList(provinceList);
	model.setAreaList(areaList);
    int supSize = gantryListEdit.size() - 1;
	String stringOfGantryIds = "";

	for (int i = 0; i <= supSize; i++) {
		MmsAddgantry obj = gantryListEdit.get(i);
		if (i != 0) {
			stringOfGantryIds = stringOfGantryIds + "," + Long.toString(obj.getId());
		} else {
			stringOfGantryIds = Long.toString(obj.getId());
		}
	}
	System.out.println("-------------------> stringOfGantryIds: " + stringOfGantryIds);

	model.setStringOfGantryIds(stringOfGantryIds);
	
	return new ModelAndView("displayAllGantry", "model", model);
}
*/









@RequestMapping(value = "/updateGantry/{id}/{province}/{area}/{csc}/{code}/{name}/{shortcu}/{earth}/{date}/{gantryType}/{gantryEleType}/{noBusBar}/{noBusSec}/{noInb}/{noOutb}/{total}/{noAr}/{noLbs}/{noAbs}/{noSa}/{noddlol}/{noddlof}/{noInf}/{noOutf}/{gpsLatitude}/{gpsLongitude}/{status}/",method = RequestMethod.GET, produces = "application/json")
public @ResponseBody void updateGantry(@PathVariable("id") String id,@PathVariable("province") String province,@PathVariable("area") String area,@PathVariable("csc") String csc,@PathVariable("code") String code,@PathVariable("name") String name,
		@PathVariable("shortcu") String shortcu,@PathVariable("earth") String earth,@PathVariable("date") String date,@PathVariable("gantryType") String gantryType,@PathVariable("gantryEleType") String gantryEleType,@PathVariable("noBusBar") String noBusBar,@PathVariable("noBusSec") String noBusSec,
		@PathVariable("noInb") String noInb,@PathVariable("noOutb") String noOutb,@PathVariable("total") String total,@PathVariable("noAr") String noAr,@PathVariable("noLbs") String noLbs,@PathVariable("noAbs") String noAbs,@PathVariable("noSa") String noSa,@PathVariable("noddlol") String noddlol,@PathVariable("noddlof") String noddlof,
		@PathVariable("noInf") String noInf,@PathVariable("noOutf") String noOutf,@PathVariable("gpsLatitude") String gpsLatitude,@PathVariable("gpsLongitude") String gpsLongitude,@PathVariable("status") String status) {
	
	
	
//	System.out.println("id"+id+"province"+province+"/"+area+"/"+csc+"/"+code+"/"+name+"/"+shortcu+"/"+earth+"/"+date+"/"+gantryType+"/"+gantryEleType+"/"+noBusBar+"/"+noBusSec+"/"+noInb+"/"+noOutb+"/"+total+"/"+noAr+"/"+noAbs+"/"+noSa+"/"+noddlol+"/"+noddlof+"/"+noInf+"/"+noOutf+"/"+gpsLatitude+"/"+gpsLongitude+"/"+status);
//	System.out.print("noInf    "+noInf);
	MmsAddgantry obj = new MmsAddgantry();
	obj = addGantry.findById(Long.valueOf(id));
	obj.setId(new Long(id));
	obj.setProvince(province);
	obj.setArea(area);
	obj.setCsc(csc);
	obj.setCode(code);
	obj.setName(name);
	obj.setShortCctCurntCapacity(new BigDecimal(shortcu));
	obj.setEarthFaultCurntCapacity(new BigDecimal(earth));
	//obj.setDateOfComm(new Date(date));
	obj.setGantryType(new BigDecimal(gantryType));
	obj.setGantryEleType(new BigDecimal(gantryEleType));
	obj.setNoBusBar(new BigDecimal(noBusBar));
	obj.setNoBusSec(new BigDecimal(noBusSec));
	obj.setNoInBays(new BigDecimal(noInb));
	obj.setNoOutBays(new BigDecimal(noOutb));
	obj.setTotalLandArea(new BigDecimal(total));
	obj.setNoAr(new BigDecimal(noAr));
	obj.setNoAbs(new BigDecimal(noAbs));
	obj.setNoLbs(new BigDecimal(noLbs));
	obj.setNoSa(new BigDecimal(noSa));
	obj.setNoDdloLinks(new BigDecimal(noddlol));
	obj.setNoDdloFuses(new BigDecimal(noddlof));
	obj.setNoIncomingFeeder(new BigDecimal(noInf));
	obj.setNoOutgoingFeeder(new BigDecimal(noOutf));
	obj.setGpsLatitude(new BigDecimal(gpsLatitude));
	obj.setGpsLongitude(new BigDecimal(gpsLongitude));
	obj.setStatus(new BigDecimal(status));
	
	
	
	
	
	try{
	Date dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(date);
	//String currentDate = dateNow.format(date);
	
	obj.setDateOfComm(dateNow);
	
	addGantry.updateGantry(obj);
	
	
	
	
	
	
	}catch(Exception e){
		System.out.println("/////////////////////////");
		System.out.println(e.getMessage());
		
	}
}

@RequestMapping(value = "/updateGantryStatusNew", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody void updateLineStatusNew(HttpServletRequest request) {
	String deptId = request.getSession().getAttribute("deptId").toString();
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
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
		List<MmsAddgantry> gantry = addGantry.findGantryByStatus(status, deptId);
		System.out.println("//////////////////"+deptId);
		System.out.println("Support :" + gantry.size());

		if (gantry != null) {
			for (int i = 0; i < gantry.size(); i++) {
				MmsAddgantry obj = gantry.get(i);
				System.out.println("updatestatus" + obj.getStatus());
				obj.setStatus(new BigDecimal(updateStatus));
				addGantry.updateGantry(obj);
			}
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

@RequestMapping(value = "/findByInterruptionRequest/{RequestId}", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody ApprovalMm findByInterruptionRequest(@PathVariable("RequestId") String RequestId) {
	return approvalMm.findByID(RequestId);
}

@RequestMapping(value = "/getGantryObj/{id}",method = RequestMethod.GET, produces = "application/json")
public @ResponseBody MmsAddgantry findGantryById(@PathVariable("id") String id){
	return addGantry.findById(new Long(id));
		
}

@RequestMapping(value = "/getFeederObj/{id}",method = RequestMethod.GET, produces = "application/json")
public @ResponseBody MmsAddfeeder findById(@PathVariable("id") String id){
	return addFeeder.findById(id);
		
}

@RequestMapping(value = "/getSwitchObj/{id}",method = RequestMethod.GET, produces = "application/json")
public @ResponseBody MmsAddswitch findSwitchObjId(@PathVariable("id") String id){
	return addSwitch.findById(id);
		
}

@RequestMapping(value = "/getSwitch/{switchId}",method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsAddswitch> getSwitch(@PathVariable("switchId") String switchId) {
	System.out.println("switchId --------------------------------------------->>>>>>> "+switchId);
	return addSwitch.getSwitchData(switchId);
}

@RequestMapping(value = "/getLineObject",method = RequestMethod.GET, produces = "application/json")
public @ResponseBody MmsAddline getLineObject(@RequestParam("lineid") String lineid) {
	long dd = new Long(lineid);
	return addLine.findById(dd);
}




@RequestMapping(value = "/getSwitchByStatus/{status}/{switchType}/{phmbranch}", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsAddswitch> findSwitchByStatus(@PathVariable("status") String status,@PathVariable("switchType") String switchType,@PathVariable("phmbranch") String phmbranch) {
	System.out.println("switchType :" + switchType+" "+"status :" + status);
	return addSwitch.findSwitchByswitchTypeStatus(status,switchType,phmbranch);
}

@RequestMapping(value = "/getGantryByStatus/{status}/{phmBranch}/",method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<MmsAddgantry> getGantryByStatus(@PathVariable("status") String status,@PathVariable("phmBranch") String phmBranch) {
	System.out.println("phmBranch ------>>>>>>> "+phmBranch+"status ------>>>>>>> "+status);
	return addGantry.findGantryByStatus(status, phmBranch);
}



@RequestMapping(value = "/displayAllFeeder", method = RequestMethod.GET)
public ModelAndView displayAllFeeders(HttpServletRequest request) {

	PivModel model = new PivModel();
	String deptId = request.getSession().getAttribute("deptId").toString();
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
    String status = null;
	if (userLevel.equals("DEO")) {
		status = Util.IN_BULK;
	} else if (userLevel.equals("ES")) {
		status = Util.VALIDATION_ES;
	} else if (userLevel.equals("EE")) {
		status = Util.APPROVAL_EE;
	}
	String phmBranch = (String) request.getSession().getAttribute("deptId");
	System.out.println("phmbranch "+phmBranch);
	List<MmsAddfeeder> feederListEdit = addFeeder.findFeederByStatus(status, phmBranch);
	model.setFeederListEdit(feederListEdit);
	List<MmsAddgantry> gantryListEdit = addGantry.findGantryByStatus(status, phmBranch);
	model.setGantryListEdit(gantryListEdit);
	List<MmsAddconductortype> conType = conTpePeDao.findAll();
    model.setConTypeList(conType);
	Map<String, String> lineList = new LinkedHashMap<String, String>();
	Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	String userName = (String) request.getSession().getAttribute("loggedUser");
	model.setProvinceList(provinceList);
	model.setAreaList(areaList);
    int supSize = feederListEdit.size() - 1;
	String stringOfFeederIds = "";

	for (int i = 0; i <= supSize; i++) {
		MmsAddfeeder obj = feederListEdit.get(i);
		if (i != 0) {
			stringOfFeederIds = stringOfFeederIds + "," + obj.getId().getFeederId();
		} else {
			stringOfFeederIds = obj.getId().getFeederId();
		}
	}
	System.out.println("-------------------> stringOfFeederIds: " + stringOfFeederIds);

	model.setStringOfFeederIds(stringOfFeederIds);
	
	return new ModelAndView("displayAllFeeder", "model", model);
}


@RequestMapping(value = "/displayAllFeederApprove", method = RequestMethod.GET)
public ModelAndView displayAllFeederApprove(HttpServletRequest request) {

	PivModel model = new PivModel();
	String deptId = request.getSession().getAttribute("deptId").toString();
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
    String status = null;
	/*if (userLevel.equals("DEO")) {
		status = Util.IN_BULK;
	} else if (userLevel.equals("ES")) {
		status = Util.VALIDATION_ES;
	} else if (userLevel.equals("EE")) {
		status = Util.APPROVAL_EE;
	}
	*/
	status = Util.APPROVE;
	String phmBranch = (String) request.getSession().getAttribute("deptId");
	System.out.println("phmbranch "+phmBranch);
	List<MmsAddfeeder> feederListEdit = addFeeder.findFeederByStatus(status, phmBranch);
	model.setFeederListEdit(feederListEdit);
	List<MmsAddgantry> gantryListEdit = addGantry.findGantryByStatus(status, phmBranch);
	model.setGantryListEdit(gantryListEdit);
	List<MmsAddconductortype> conType = conTpePeDao.findAll();
    model.setConTypeList(conType);
	Map<String, String> lineList = new LinkedHashMap<String, String>();
	Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	String userName = (String) request.getSession().getAttribute("loggedUser");
	model.setProvinceList(provinceList);
	model.setAreaList(areaList);
    int supSize = feederListEdit.size() - 1;
	String stringOfFeederIds = "";

	for (int i = 0; i <= supSize; i++) {
		MmsAddfeeder obj = feederListEdit.get(i);
		if (i != 0) {
			stringOfFeederIds = stringOfFeederIds + "," + obj.getId().getFeederId();
		} else {
			stringOfFeederIds = obj.getId().getFeederId();
		}
	}
	System.out.println("-------------------> stringOfFeederIds: " + stringOfFeederIds);

	model.setStringOfFeederIds(stringOfFeederIds);
	
	return new ModelAndView("displayAllFeeder", "model", model);
}






 @RequestMapping(value = "/updateFeeder/{id}/{gantryId}/{type}/{code}/{name}/{feedertype}/{conductor}/{noAr}/{noLbs}/{noAbs}/{noSa}/{status}/",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateFeeder(@PathVariable("id") String id,@PathVariable("gantryId") String gantryId,@PathVariable("type") String type,@PathVariable("code") String code,@PathVariable("name") String name,@PathVariable("feedertype") String feedertype,@PathVariable("conductor") String conductor,@PathVariable("noAr") String noAr,
			@PathVariable("noLbs") String noLbs,@PathVariable("noAbs") String noAbs,@PathVariable("noSa") String noSa,@PathVariable("status") String status) {
		
		MmsAddfeeder obj = new MmsAddfeeder();
		
		obj = addFeeder.findById(id);
		obj.getId().setFeederId(id);
		obj.getId().setGantryId(new Long(gantryId));
		obj.setTypeInOut(new BigDecimal(type));
		obj.setCode(code);
		obj.setName(name);
		obj.setFeederType(new BigDecimal(feedertype));
		obj.setConductor(new BigDecimal(conductor));
		obj.setNoAr(new BigDecimal(noAr));
		obj.setNoLbs(new BigDecimal(noLbs));
		obj.setNoAbs(new BigDecimal(noAbs));
		obj.setNoSa(new BigDecimal(noSa));
		obj.setStatus(new BigDecimal(status));
		try{
		    addFeeder.updateFeeder(obj);
		    
		}catch(Exception e){
			System.out.println("/////////////////////////");
			System.out.println(e.getMessage());
			
		}
}
 
 
 @RequestMapping(value = "/updateFeederNew/{id}/{longitude}/{latitude}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String updateFeederNew(@PathVariable("id") String id,@PathVariable("longitude") String longitude,@PathVariable("latitude") String latitude) {
	    System.out.println("/////////////////////////" + id + longitude + latitude);
		
		MmsAddfeeder obj = new MmsAddfeeder();
		
		obj = addFeeder.findById(id);
		obj.setGpsLongitude(new BigDecimal(longitude));
		obj.setGpsLatitude(new BigDecimal(latitude));
		//obj.setGpsLongitude(longitude);
		//obj.setGpsLatitude(latitude);
		
		try{
		    addFeeder.updateFeeder(obj);
		    return "Y";
		}catch(Exception e){
			System.out.println("/////////////////////////");
			System.out.println(e.getMessage());
			
		}
		return "N";
}


@RequestMapping(value = "/updateFeederStatusNew", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateFeederStatusNew(HttpServletRequest request) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
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
			List<MmsAddfeeder> feeder = addFeeder.findFeederByStatus(status, deptId);
			System.out.println("//////////////////"+deptId);
			System.out.println("Support :" + feeder.size());

			if (feeder != null) {
				for (int i = 0; i < feeder.size(); i++) {
					MmsAddfeeder obj = feeder.get(i);
					System.out.println("updatestatus" + obj.getStatus());
					obj.setStatus(new BigDecimal(updateStatus));
					addFeeder.updateFeeder(obj);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}




@RequestMapping(value = "/displayAllSwitch", method = RequestMethod.GET)
public ModelAndView displayAllswitches(HttpServletRequest request) {

	PivModel model = new PivModel();
	String deptId = request.getSession().getAttribute("deptId").toString();
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
    String status = null;
	if (userLevel.equals("DEO")) {
		status = Util.IN_BULK;
	} else if (userLevel.equals("ES")) {
		status = Util.VALIDATION_ES;
	} else if (userLevel.equals("EE")) {
		status = Util.APPROVAL_EE;
	}
	String phmBranch = (String) request.getSession().getAttribute("deptId");
	System.out.println("phmbranch "+phmBranch);
	List<MmsAddswitch> arListEdit = addSwitch.findSwitchByswitchTypeStatus(status,"1",phmBranch);
	model.setArListEdit(arListEdit);
	List<MmsAddswitch> lbsListEdit = addSwitch.findSwitchByswitchTypeStatus(status,"2",phmBranch);
	model.setLbsListEdit(lbsListEdit);
	List<MmsAddswitch> absListEdit = addSwitch.findSwitchByswitchTypeStatus(status,"3",phmBranch);
	model.setAbsListEdit(absListEdit);
	List<MmsAddswitch> ddloListEdit = addSwitch.findSwitchByswitchTypeStatus(status,"4",phmBranch);
	model.setDdloListEdit(ddloListEdit);
	List<MmsAddconductortype> conType = conTpePeDao.findAll();
    model.setConTypeList(conType);
	Map<String, String> lineList = new LinkedHashMap<String, String>();
	Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	String userName = (String) request.getSession().getAttribute("loggedUser");
	model.setProvinceList(provinceList);
	model.setAreaList(areaList);
    int supSize1 = arListEdit.size() - 1;
	String stringOfarSwitchIds = "";

	for (int i = 0; i <= supSize1; i++) {
		MmsAddswitch obj = arListEdit.get(i);
		if (i != 0) {
			stringOfarSwitchIds = stringOfarSwitchIds + "," + obj.getId().getSwitchId();
		} else {
			stringOfarSwitchIds = obj.getId().getSwitchId();
		}
	}
	System.out.println("-------------------> stringOfarSwitchIds: " + stringOfarSwitchIds);

	model.setStringOfarSwitchIds(stringOfarSwitchIds);
	
    int supSize2 = lbsListEdit.size() - 1;
		String stringOflbsSwitchIds = "";

		for (int i = 0; i <= supSize2; i++) {
			MmsAddswitch obj = lbsListEdit.get(i);
			if (i != 0) {
				stringOflbsSwitchIds = stringOflbsSwitchIds + "," + obj.getId().getSwitchId();
			} else {
				stringOflbsSwitchIds = obj.getId().getSwitchId();
			}
		}
		System.out.println("-------------------> stringOflbsSwitchIds: " + stringOflbsSwitchIds);

		model.setStringOflbsSwitchIds(stringOflbsSwitchIds);
		
		 int supSize3 = absListEdit.size() - 1;
			String stringOfabsSwitchIds = "";

			for (int i = 0; i <= supSize3; i++) {
				MmsAddswitch obj = absListEdit.get(i);
				if (i != 0) {
					stringOfabsSwitchIds = stringOfabsSwitchIds + "," + obj.getId().getSwitchId();
				} else {
					stringOfabsSwitchIds = obj.getId().getSwitchId();
				}
			}
			System.out.println("-------------------> stringOfabsSwitchIds: " + stringOfabsSwitchIds);

			model.setStringOfabsSwitchIds(stringOfabsSwitchIds);
			
			 int supSize4 = ddloListEdit.size() - 1;
				String stringOfddloSwitchIds = "";

				for (int i = 0; i <= supSize4; i++) {
					MmsAddswitch obj = ddloListEdit.get(i);
					if (i != 0) {
						stringOfddloSwitchIds = stringOfddloSwitchIds + "," + obj.getId().getSwitchId();
					} else {
						stringOfddloSwitchIds = obj.getId().getSwitchId();
					}
				}
				System.out.println("-------------------> stringOfddloSwitchIds: " + stringOfddloSwitchIds);

				model.setStringOfddloSwitchIds(stringOfddloSwitchIds);
	
	return new ModelAndView("displayAllSwitch", "model", model);
}



@RequestMapping(value = "/displayAllSwitchApprove", method = RequestMethod.GET)
public ModelAndView displayAllSwitchApprove(HttpServletRequest request) {

	PivModel model = new PivModel();
	String deptId = request.getSession().getAttribute("deptId").toString();
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
    String status = null;
	/*if (userLevel.equals("DEO")) {
		status = Util.IN_BULK;
	} else if (userLevel.equals("ES")) {
		status = Util.VALIDATION_ES;
	} else if (userLevel.equals("EE")) {
		status = Util.APPROVAL_EE;
	}
	*/
	status = Util.APPROVE;
	
	String phmBranch = (String) request.getSession().getAttribute("deptId");
	System.out.println("phmbranch "+phmBranch);
	List<MmsAddswitch> arListEdit = addSwitch.findSwitchByswitchTypeStatus(status,"1",phmBranch);
	model.setArListEdit(arListEdit);
	List<MmsAddswitch> lbsListEdit = addSwitch.findSwitchByswitchTypeStatus(status,"2",phmBranch);
	model.setLbsListEdit(lbsListEdit);
	List<MmsAddswitch> absListEdit = addSwitch.findSwitchByswitchTypeStatus(status,"3",phmBranch);
	model.setAbsListEdit(absListEdit);
	List<MmsAddswitch> ddloListEdit = addSwitch.findSwitchByswitchTypeStatus(status,"4",phmBranch);
	model.setDdloListEdit(ddloListEdit);
	List<MmsAddconductortype> conType = conTpePeDao.findAll();
    model.setConTypeList(conType);
	Map<String, String> lineList = new LinkedHashMap<String, String>();
	Map<String, String> areaList = new LinkedHashMap<String, String>();
	Map<String, String> provinceList = new LinkedHashMap<String, String>();
	String userName = (String) request.getSession().getAttribute("loggedUser");
	model.setProvinceList(provinceList);
	model.setAreaList(areaList);
    int supSize1 = arListEdit.size() - 1;
	String stringOfarSwitchIds = "";

	for (int i = 0; i <= supSize1; i++) {
		MmsAddswitch obj = arListEdit.get(i);
		if (i != 0) {
			stringOfarSwitchIds = stringOfarSwitchIds + "," + obj.getId().getSwitchId();
		} else {
			stringOfarSwitchIds = obj.getId().getSwitchId();
		}
	}
	System.out.println("-------------------> stringOfarSwitchIds: " + stringOfarSwitchIds);

	model.setStringOfarSwitchIds(stringOfarSwitchIds);
	
    int supSize2 = lbsListEdit.size() - 1;
		String stringOflbsSwitchIds = "";

		for (int i = 0; i <= supSize2; i++) {
			MmsAddswitch obj = lbsListEdit.get(i);
			if (i != 0) {
				stringOflbsSwitchIds = stringOflbsSwitchIds + "," + obj.getId().getSwitchId();
			} else {
				stringOflbsSwitchIds = obj.getId().getSwitchId();
			}
		}
		System.out.println("-------------------> stringOflbsSwitchIds: " + stringOflbsSwitchIds);

		model.setStringOflbsSwitchIds(stringOflbsSwitchIds);
		
		 int supSize3 = absListEdit.size() - 1;
			String stringOfabsSwitchIds = "";

			for (int i = 0; i <= supSize3; i++) {
				MmsAddswitch obj = absListEdit.get(i);
				if (i != 0) {
					stringOfabsSwitchIds = stringOfabsSwitchIds + "," + obj.getId().getSwitchId();
				} else {
					stringOfabsSwitchIds = obj.getId().getSwitchId();
				}
			}
			System.out.println("-------------------> stringOfabsSwitchIds: " + stringOfabsSwitchIds);

			model.setStringOfabsSwitchIds(stringOfabsSwitchIds);
			
			 int supSize4 = ddloListEdit.size() - 1;
				String stringOfddloSwitchIds = "";

				for (int i = 0; i <= supSize4; i++) {
					MmsAddswitch obj = ddloListEdit.get(i);
					if (i != 0) {
						stringOfddloSwitchIds = stringOfddloSwitchIds + "," + obj.getId().getSwitchId();
					} else {
						stringOfddloSwitchIds = obj.getId().getSwitchId();
					}
				}
				System.out.println("-------------------> stringOfddloSwitchIds: " + stringOfddloSwitchIds);

				model.setStringOfddloSwitchIds(stringOfddloSwitchIds);
	
	return new ModelAndView("displayAllSwitch", "model", model);
}			





@RequestMapping(value = "/updateSwitch/{id}/{gantryId}/{feederId}/{code}/{name}/{mounting}/{brandname}/{date}/{datec}/{modelnumber}/{serialno}/{batteryCapacity}/{NoOfBatteries}/{RemoteOperation}/{Arrangement}/{date1}/{datec1}/{ModelNumber1}/{SerialNo1}/{rating}/{SccLevelOfEquipment}/{InsulationMedium}/{status}/",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateSwitch(@PathVariable("id") String id,@PathVariable("gantryId") String gantryId,@PathVariable("feederId") String feederId,@PathVariable("code") String code,@PathVariable("name") String name,@PathVariable("mounting") String mounting,@PathVariable("brandname") String brandname,@PathVariable("date") String date,@PathVariable("datec") String datec,@PathVariable("modelnumber") String modelnumber,@PathVariable("serialno") String serialno,
			@PathVariable("batteryCapacity") String batteryCapacity,@PathVariable("NoOfBatteries") String NoOfBatteries,@PathVariable("RemoteOperation") String RemoteOperation,@PathVariable("Arrangement") String Arrangement,
			@PathVariable("date1") String date1,@PathVariable("datec1") String datec1,@PathVariable("ModelNumber1") String ModelNumber1,@PathVariable("SerialNo1") String SerialNo1,@PathVariable("rating") String rating,@PathVariable("SccLevelOfEquipment") String SccLevelOfEquipment,@PathVariable("InsulationMedium") String InsulationMedium,@PathVariable("status") String status) {
		
		MmsAddswitch obj = new MmsAddswitch();
		
		obj = addSwitch.findById(id);
		obj.getId().setSwitchId(id);
		obj.getId().setFeederId(feederId);
		obj.getId().setGantryId(new Long(gantryId));
		obj.setSwitchCode(code);
		obj.setSwitchName(name);
		obj.setMounting(new BigDecimal(mounting));
		obj.setBrandName(new BigDecimal(brandname));
		obj.setCpModelNumber(modelnumber);
		obj.setCpSerialNo(serialno);
		obj.setCpBatteryCapacity(new BigDecimal(batteryCapacity));
		obj.setCpNoOfBatteries(new BigDecimal(NoOfBatteries));
		obj.setCpRemoteOperation(RemoteOperation);
		obj.setSgArrangement(Arrangement);
		obj.setSgModelNumber(ModelNumber1);
		obj.setSgSerialNo(SerialNo1);
		obj.setSgRating(new BigDecimal(rating));
		obj.setSgSccLevelOfEquipment(new BigDecimal(SccLevelOfEquipment));
		obj.setSgInsulationMedium(InsulationMedium);
		obj.setStatus(new BigDecimal(status));
		
		try{
			Date dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			Date dateNow1 = new SimpleDateFormat("yyyy-MM-dd").parse(datec);
			Date dateNow2 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
			Date dateNow3 = new SimpleDateFormat("yyyy-MM-dd").parse(datec1);
			
			obj.setCpDateManufature(dateNow);
			obj.setCpDateCommitioning(dateNow1);
			obj.setSgDateManufature(dateNow2);
			obj.setSgDateCommitioning(dateNow3);
			
			
		    addSwitch.updateSwitch(obj);
		    
		}catch(Exception e){
			System.out.println("/////////////////////////");
			System.out.println(e.getMessage());
			
		}
}

@RequestMapping(value = "/updateABSSwitch/{id}/{gantryId}/{feederId}/{code}/{name}/{brandname}/{date}/{datec}/{modelnumber}/{serialno}/{operationDirection}/{position}/{rating}/{SccLevelOfEquipment}/{status}/",method = RequestMethod.GET, produces = "application/json")
public @ResponseBody void updateABSSwitch(@PathVariable("id") String id,@PathVariable("gantryId") String gantryId,@PathVariable("feederId") String feederId,@PathVariable("code") String code,@PathVariable("name") String name,@PathVariable("brandname") String brandname,@PathVariable("date") String date,@PathVariable("datec") String datec,@PathVariable("modelnumber") String modelnumber,@PathVariable("serialno") String serialno,
		@PathVariable("operationDirection") String operationDirection,@PathVariable("position") String position,@PathVariable("rating") String rating,@PathVariable("SccLevelOfEquipment") String SccLevelOfEquipment,@PathVariable("status") String status) {
	
	MmsAddswitch obj = new MmsAddswitch();
	
	obj = addSwitch.findById(id);
	obj.getId().setSwitchId(id);
	obj.getId().setFeederId(feederId);
	obj.getId().setGantryId(new Long(gantryId));
	obj.setSwitchCode(code);
	obj.setSwitchName(name);
	obj.setBrandName(new BigDecimal(brandname));
	obj.setCpModelNumber(modelnumber);
	obj.setCpSerialNo(serialno);
	obj.setOperationDirection(operationDirection);
	obj.setPosition(position);
	obj.setSgRating(new BigDecimal(rating));
	obj.setSgSccLevelOfEquipment(new BigDecimal(SccLevelOfEquipment));
	obj.setStatus(new BigDecimal(status));
	
	try{
		Date dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		Date dateNow1 = new SimpleDateFormat("yyyy-MM-dd").parse(datec);
		
		obj.setCpDateManufature(dateNow);
		obj.setCpDateCommitioning(dateNow1);
		System.out.println("updateABS");
		
	    addSwitch.updateSwitch(obj);
	    
	}catch(Exception e){
		System.out.println("/////////////////////////");
		System.out.println(e.getMessage());
		
	}
}	

@RequestMapping(value = "/updateDDLOSwitch/{id}/{gantryId}/{feederId}/{code}/{name}/{position}/{quantity}/{carrierType}/{rating}/{status}/",method = RequestMethod.GET, produces = "application/json")
public @ResponseBody void updateDDLOSwitch(@PathVariable("id") String id,@PathVariable("gantryId") String gantryId,@PathVariable("feederId") String feederId,@PathVariable("code") String code,@PathVariable("name") String name,@PathVariable("position") String position,@PathVariable("quantity") String quantity,@PathVariable("carrierType") String carrierType,@PathVariable("rating") String rating,
	   @PathVariable("status") String status) {
	
	MmsAddswitch obj = new MmsAddswitch();
	
	obj = addSwitch.findById(id);
	obj.getId().setSwitchId(id);
	obj.getId().setFeederId(feederId);
	obj.getId().setGantryId(new Long(gantryId));
	obj.setSwitchCode(code);
	obj.setSwitchName(name);
	obj.setPosition(position);
	obj.setQuantity(new BigDecimal(quantity));
	obj.setCarrierType(carrierType);
	obj.setSgRating(new BigDecimal(rating));
	obj.setStatus(new BigDecimal(status));
	
	try{
		
		System.out.println("updateDDLO");
		
	    addSwitch.updateSwitch(obj);
	    
	}catch(Exception e){
		System.out.println("/////////////////////////");
		System.out.println(e.getMessage());
		
	}
}



@RequestMapping(value = "/updateSwitchNew/{id}/{longitude}/{latitude}",method = RequestMethod.GET, produces = "application/json")
public @ResponseBody void updateSwitchNew(@PathVariable("id") String id,@PathVariable("longitude") String longitude,@PathVariable("latitude") String latitude) {
	
	MmsAddswitch obj = new MmsAddswitch();
	
	obj = addSwitch.findById(id);
	obj.setGpsLatitude(new BigDecimal(latitude));
	obj.setGpsLongitude(new BigDecimal(longitude));
	
	try{
		
		System.out.println("updateDDLO");
		
	    addSwitch.updateSwitch(obj);
	    
	}catch(Exception e){
		System.out.println("/////////////////////////");
		System.out.println(e.getMessage());
		
	}
}


@RequestMapping(value = "/updateBusBarLoc1New/{id}/{longitude}/{latitude}/{pontid}",method = RequestMethod.GET, produces = "application/json")
public @ResponseBody void updateBusBarLoc1New(@PathVariable("id") String id,@PathVariable("longitude") String longitude,@PathVariable("latitude") String latitude,@PathVariable("pontid") String pontid) {
	
	MmsGantryloc obj = new MmsGantryloc();
	MmsGantrylocPK objPk = new MmsGantrylocPK();
	objPk.setGantryId(new Long(id));
	objPk.setPointId(new Long(pontid));
	
	obj = gantryLocDao.findById(objPk);
	try{
		
	if(obj == null){
		obj.setId(objPk);
		obj.setGpsLongitude(new BigDecimal(longitude));
		obj.setGpsLatitude(new BigDecimal(latitude));
		gantryLocDao.addGantyLoc(obj);
	}else{
		obj.setGpsLongitude(new BigDecimal(longitude));
		obj.setGpsLatitude(new BigDecimal(latitude));
		gantryLocDao.updateGantyLoc(obj);

	}
	}catch(Exception e){
		System.out.println("/////////////////////////");
		System.out.println(e.getMessage());
		
	}
}



@RequestMapping(value = "/updateSwitchStatusNew/{switchType}/", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody void updateSwitchStatusNew(HttpServletRequest request,@PathVariable("switchType") String switchType) {
	String deptId = request.getSession().getAttribute("deptId").toString();
	String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
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
		
		List<MmsAddswitch> switchlist = addSwitch.findSwitchByswitchTypeStatus(status,switchType,deptId);
		System.out.println("///////\\\\\\\\"+switchType);
		System.out.println("Support :" + switchlist.size());

		if (switchlist != null) {
			for (int i = 0; i < switchlist.size(); i++) {
				MmsAddswitch obj = switchlist.get(i);
				System.out.println("updatestatus" + obj.getStatus());
				obj.setStatus(new BigDecimal(updateStatus));
				addSwitch.updateSwitch(obj);
			}
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

@RequestMapping(value = "/findAllProvincsPCB/{parentId}/",method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<Glcompm> findAllProvincsPCB(@PathVariable("parentId") String parentId) {
	return glcompmDao.getProvincesPCB(parentId);
	
}


/*@SuppressWarnings("deprecation")
@RequestMapping(value = "/updateSupportNew",method = RequestMethod.GET, produces = "application/json")
public @ResponseBody void updateSupportNew(@RequestParam("id") String id,@RequestParam("towerno") String towerno,
        @RequestParam("mapid") String mapid,@RequestParam("suptype") String suptype,@RequestParam("gpslatitude") String gpslatitude,
        @RequestParam("gpslongitude") String gpslongitude,@RequestParam("area") String area,@RequestParam("csc") String csc,@RequestParam("contype") String contype,
        @RequestParam("earthcontype") String earthcontype,@RequestParam("towerconfig") String towerconfig,@RequestParam("noofcct") String noofcct,
        @RequestParam("bodyextension") String bodyextension,@RequestParam("pstatus") String pstatus,@RequestParam("approvalvl") String approvalvl,
        @RequestParam("res") String res,@RequestParam("from") String from,@RequestParam("to") String to)
{
	try{
	 MmsAddsupport obj = new MmsAddsupport();
	    obj = addSupport.findById(Long.valueOf(id));
		obj.setId(Long.valueOf(id));
	    obj.setTowerNo(towerno);
	    obj.setMapId(new BigDecimal(mapid));
	    obj.setSupportType(new BigDecimal(suptype));
	    obj.setGpsLatitude(new BigDecimal(gpslatitude));
	    obj.setGpsLongitude(new BigDecimal(gpslongitude));
	    obj.setArea(area);
	    obj.setCsc(csc);
	    obj.setConductorType(new BigDecimal(contype));
	    obj.setEarthConductorType(new BigDecimal(earthcontype));
	    obj.setTowerConfiguration(new BigDecimal(towerconfig));
	    obj.setNoOfCircuits(new BigDecimal(noofcct));
	    obj.setBodyExtension(bodyextension);
	    obj.setStatus(new BigDecimal(pstatus));
	    obj.setApprovalLevel(approvalvl);
	       
	    
	    addSupport.update(obj);

		addSupport.updateSupport(towerNo,sType, id, area, csc, cType, ecType, tType, tConfig, gpsLat, gpsLon, nofCir, bExten,tapping,mapId, status, appLevel,res,from,to);


}catch(Exception e){
	        
	    }
}
*/


@RequestMapping(value = "/getTapping",method = RequestMethod.GET, produces = "application/json")
public @ResponseBody String getTapping(@RequestParam("id") long id) {
	
	MmsAddsupport obj = new MmsAddsupport();
	obj = addSupport.findById(id);
	return String.valueOf(obj.getTapping());
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



@RequestMapping(method= RequestMethod.POST,value="/saveApplication",  produces = "application/json",  consumes = "application/json")

public @ResponseBody ResponseObject saveApplication(@RequestBody RequestObject applicationObj){

       ResponseObject obj = new ResponseObject();

      

       String resCode = "500";

       String resValue = "Unsuccessful.";

       System.out.println("@@saveApplication service@@");

       try

       {

              if(applicationObj!=null)

              {

                   /* Applicant applicant = new Applicant();

                    applicant.setIdNo(applicationObj.getId());

                    applicant.setIdType(applicationObj.getIdType());

                    applicant.setFirstName(applicationObj.getFirstName());

                    applicant.setLastName(applicationObj.getLastName());

                    applicant.setFullName(applicationObj.getFullName());

                    applicant.setSuburb(applicationObj.getAddressLine2());

                    applicant.setStreetAddress(applicationObj.getAddressLine1());

                    applicant.setCity(applicationObj.getAddressLine3());

                    applicant.setPreferredLanguage("SI");

                    //applicant.set(applicationObj.getId());

                   

                    ApplicationPK applicationPK = new ApplicationPK();

                    applicationPK.setDeptId(applicationObj.getCsc());

                    Application application = new Application();

                    application.setId(applicationPK);

                   

                    DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy HH:MM:ss");

                     application.setSubmitDate(dateFormat.parse(applicationObj.getApplicationDate()));

                    application.setIdNo(applicationObj.getId());

                    application.setPreparedBy("CIS");

                    application.setStatus("O");

                    application.setApplicationType(applicationObj.getApplicationType());

                    application.setApplicationSubType("PM");
*/
                    String applicationNo="";// = applicationTransaction.createNewApplication(applicant,application, "ENC");

                    resCode = "200";

                     resValue = applicationNo;

                   

              }

      

       }

       catch(Exception e)

       {

              resCode = "500";

              resValue = "Service error.";

              e.printStackTrace();

       }

       obj.setResponseCode(resCode);

       obj.setResponseValue(resValue);

       return obj;

}






		
}
