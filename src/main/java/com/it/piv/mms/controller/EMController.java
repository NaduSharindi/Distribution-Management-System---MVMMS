package com.it.piv.mms.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.piv.mms.domain.MmsCompletion;
import com.it.piv.mms.domain.MmsCompletionPK;

import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;

import org.bouncycastle.asn1.x509.UserNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.issue.domain.ApprovalModel;
import com.it.piv.issue.domain.JobTransfer;
import com.it.piv.admin.domain.Sauserm;
import com.it.piv.admin.domain.SausermMm;
import com.it.piv.admin.repo.SecurityDao;
import com.it.piv.issue.domain.PivModel;
import com.it.piv.issue.repo.JasperDao;
import com.it.piv.mms.domain.Applicant;
import com.it.piv.mms.domain.ApprovalMm;
import com.it.piv.mms.domain.Glcompm;
import com.it.piv.mms.domain.Gldeptm;
import com.it.piv.mms.domain.MmsAddline;
import com.it.piv.mms.domain.MmsInspection;
import com.it.piv.mms.domain.MmsMetertesting;
import com.it.piv.mms.domain.MmsMetertestingPK;
import com.it.piv.mms.domain.PcbCondition;
import com.it.piv.mms.domain.PcbEquipment;
import com.it.piv.mms.domain.PcbLocation;
import com.it.piv.mms.domain.PcbModel;
import com.it.piv.mms.domain.PcbSample;
import com.it.piv.mms.domain.Pcestdmt;
import com.it.piv.mms.domain.Pcesthmt;
import com.it.piv.mms.domain.Summary;
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
import com.it.piv.mms.repo.MmsCompletionDao;
import com.it.piv.mms.repo.MmsCscDao;
import com.it.piv.mms.repo.MmsGantrylocDao;
import com.it.piv.mms.repo.MmsInspectionDao;
import com.it.piv.mms.repo.MmsMetertestingDao;
import com.it.piv.mms.repo.MmsSupportDao;
import com.it.piv.mms.repo.MmsTowermaintenanceDao;
import com.it.piv.mms.repo.MmsTxntowermaintenanceDao;
import com.it.piv.mms.repo.MmsTxntowermntcomplesionDao;
import com.it.piv.mms.repo.MsttowertypeDao;
import com.it.piv.mms.repo.MtrehttDao;
import com.it.piv.mms.repo.MvmmsCycleDao;
import com.it.piv.mms.repo.PcbConditionDao;
import com.it.piv.mms.repo.PcbDivisionDao;
import com.it.piv.mms.repo.PcbEquipmentDao;
import com.it.piv.mms.repo.PcbLocationDao;
import com.it.piv.mms.repo.PcbSampleDao;
import com.it.piv.mms.repo.PcestdmtDao;
import com.it.piv.mms.repo.PcestdttDao;
import com.it.piv.mms.repo.PcesthmtDao;
import com.it.piv.mms.repo.PcesthttDao;
import com.it.piv.mms.repo.PieChartDao;
import com.it.piv.mms.repo.ProvinceDao;
import com.it.piv.mms.repo.SpestedyConDao;
import com.it.piv.mms.repo.SpstdesthmtDao;
import com.it.piv.mms.repo.TrippingDataDao;
import com.it.piv.util.common.MailMail;
import com.it.piv.util.common.PathMMS;

@Controller
public class EMController {
	
	//edited anushka 2019-01-10 --------------------------------------------------------------------------------
	
	@Autowired
	private MmsMetertestingDao testingDao;
	
		@Autowired
		private MmsAddLineDao lineDao;
		
		@Autowired
		private MmsCompletionDao comDao;
		
		@Autowired
		private MmsInspectionDao insDao;
		
		
			//----------------------------------------------------------------------------------------------------------
		@Autowired
		private PieChartDao pieChartDao;
			
		@Autowired
		public TrippingDataDao tripDao; 
			
		
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
		private PcbConditionDao addCondition;

		@Autowired
		private PcbLocationDao addLocation;

		@Autowired
		private PcbEquipmentDao addEquipment;

		@Autowired
		private PcbDivisionDao divisionDao;
		
		@Autowired
		private GlcompmDao compDao;


		@Autowired
		private PcbSampleDao addSample;
		
		@Autowired
		private GlcompmDao glComDao;
		
		@Autowired
		private PcesthmtDao hmtDao;
		
		@Autowired
		private PcestdmtDao dmtDao;
		
		@Autowired
		private PcbEquipmentDao equipDao;
		
		
		
		private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		private static final DateFormat dateNow = new SimpleDateFormat("yyyy-MM-dd");
		
		@RequestMapping(value = "/addMake", method = RequestMethod.GET)
		public ModelAndView addMake() {

			return new ModelAndView("HelpDesk");
			
			
		}

		
		
		@RequestMapping(value = "/HelpDesk", method = RequestMethod.GET)
		public ModelAndView HelpDesk() {

			JobTransfer job = new JobTransfer();
			return new ModelAndView("HelpDesk","JobTransfer",job);
			
			
		}
		
		@RequestMapping(value = "/getUserDetails",method = RequestMethod.GET, produces = "application/json")
		 public ModelAndView getUserDetails(HttpServletRequest request){
			String deptId = request.getSession().getAttribute("deptId").toString();
			List<String> userList = new ArrayList<String>();
			userList.add("DEO");
			userList.add("ES");
			userList.add("EE");
			userList.add("CE");
			userList.add("DGM");
			List<Sauserm> user = secDao.getAllUserByRptUser(deptId, userList);
			System.out.println(user);
			//List<SausermMm> userMm = secDao.getAllUserByRptUserMMS(deptId, userList);
			
			ApprovalModel model = new ApprovalModel();
			model.setUserList(user);
			//model.setUserMm(userMm);
			
			return new ModelAndView("UserModification","model",model);
				
		 }
		
		
		/*@RequestMapping(value = "/ModifyUserRegistration", method = RequestMethod.GET)
		public ModelAndView ModifyUserRegistration(HttpServletRequest request,@RequestParam("userid") String userId) {
			
			Sauserm objUser = new Sauserm();
			
			ApprovalModel mm = new ApprovalModel();
			SausermMm obj = new SausermMm();
			ModelAndView mv = null;
			obj = secDao.getSausermMms(userId);
			objUser = secDao.getSauserm(userId);
			
			System.out.println("Hii: "+obj);
			
			if(obj != null && objUser != null){
				obj.setUserNm(objUser.getUserNm());
				mm.setUsermm(obj);
				
				mv = new ModelAndView("UserDetails","usermodel",mm);
				
			}else{
				SausermMm mmm = new SausermMm();
				mmm.setUserId(userId);
				//mmm.setUserNm(userName);
				//mmm.setUserLevel(role);
				mm.setUsermm(mmm);
				mv = new ModelAndView("UserDetails","usermodel",mm);
				 
			}
			return mv;
			
			
		}
		*/
		@RequestMapping(value = "/modifyUserRegistration", method = RequestMethod.GET)
		public ModelAndView modifyUserRegistration(HttpServletRequest request,@RequestParam("userid") String userId,ModelMap modelmap) {
			
			ApprovalModel mm = new ApprovalModel();
			Sauserm objUser = new Sauserm();
			
			
			SausermMm obj = new SausermMm();
			ModelAndView mv = null;
			obj = secDao.getSausermMms(userId);
			objUser = secDao.getSauserm(userId);
			
			System.out.println("Hii: "+obj);
			
			if(obj != null && objUser != null){
				obj.setUserNm(objUser.getUserNm());
				mm.setUsermm(obj);
				mm.setUser(objUser);
				modelmap.addAttribute("SUCCESS_MESSAGE", null);
				modelmap.addAttribute("ERROR_MESSAGE", null);
				
				mv = new ModelAndView("UserDetails","usermodel",mm);
				
			}else{
				SausermMm mmm = new SausermMm();
				mmm.setUserId(userId);
				mm.setUsermm(mmm);
				modelmap.addAttribute("SUCCESS_MESSAGE", null);
				modelmap.addAttribute("ERROR_MESSAGE", null);
				
				mv = new ModelAndView("UserDetails","usermodel",mm);
				 
			}
			return mv;
			
			
		}
		
		
		
		@RequestMapping(value = "/UserRegistration", method = RequestMethod.GET)
		public ModelAndView UserRegistration(HttpServletRequest request,@ModelAttribute("usermodel")  ApprovalModel mm,ModelMap modelmap) {
			String userId = (String) request.getSession().getAttribute("loggedUser");
			String userName = (String) request.getSession().getAttribute("userNameUser");
			String role = (String) request.getSession().getAttribute("loggedUserRole");
			String deptId = request.getSession().getAttribute("deptId").toString();
			
			Sauserm objUser = new Sauserm();
			
			
			SausermMm obj = new SausermMm();
			ModelAndView mv = null;
			obj = secDao.getSausermMms(userId);
			objUser = secDao.getSauserm(userId);
			
			System.out.println("Hii: "+obj);
			
			if(obj != null && objUser != null){
				System.out.println("Hii user model have mvmms login: ");
				
				obj.setUserNm(objUser.getUserNm());
				mm.setUsermm(obj);
				mm.setUser(objUser);
				modelmap.addAttribute("SUCCESS_MESSAGE", null);
				modelmap.addAttribute("ERROR_MESSAGE", null);
				
				mv = new ModelAndView("UserDetails","usermodel",mm);
				
			}else{
				System.out.println("Hii user model no mvmms login: ");
				
				SausermMm mmm = new SausermMm();
				mmm.setUserId(userId);
				mmm.setUserNm(userName);
				mmm.setUserLevel(role);
				mmm.setRptUser(deptId);
				mm.setUsermm(mmm);
				modelmap.addAttribute("SUCCESS_MESSAGE", null);
				modelmap.addAttribute("ERROR_MESSAGE", null);
				
				mv = new ModelAndView("UserDetails","usermodel",mm);
				 
			}
			return mv;
			
			
		}
		
		
		@RequestMapping(value = "/ViewUserInfo", method = RequestMethod.GET)
		public ModelAndView ViewUserInfo(HttpServletRequest request,@ModelAttribute("usermodel")  ApprovalModel mm,ModelMap modelmap) {
			String userId = (String) request.getSession().getAttribute("loggedUser");
			String userName = (String) request.getSession().getAttribute("userNameUser");
			String role = (String) request.getSession().getAttribute("loggedUserRole");
			
			Sauserm objUser = new Sauserm();
			
			
			SausermMm obj = new SausermMm();
			ModelAndView mv = null;
			obj = secDao.getSausermMms(userId.trim());
			objUser = secDao.getSauserm(userId.trim());
			
			System.out.println("Hii: "+obj);
			
			if(obj != null && objUser != null){
				obj.setUserNm(objUser.getUserNm());
				mm.setUsermm(obj);
				mm.setUser(objUser);
				modelmap.addAttribute("SUCCESS_MESSAGE", null);
				modelmap.addAttribute("ERROR_MESSAGE", null);
				
				mv = new ModelAndView("ViewUserDetails","usermodel",mm);
				
			}else{
				SausermMm mmm = new SausermMm();
				mmm.setUserId(userId);
				mmm.setUserNm(userName);
				mmm.setUserLevel(role);
				mm.setUsermm(mmm);
				modelmap.addAttribute("SUCCESS_MESSAGE", null);
				modelmap.addAttribute("ERROR_MESSAGE", null);
				
				mv = new ModelAndView("ViewUserDetails","usermodel",mm);
				 
			}
			return mv;
			
			
		}
		
		
		
		//updateUserDetail
		@RequestMapping(value = "/updateUserDetail", method = RequestMethod.POST)
		public ModelAndView updateUserDetail(HttpServletRequest request,@ModelAttribute("usermodel")  ApprovalModel mm,ModelMap modelmap) {
			
			SausermMm mmObj = secDao.getSausermMms(mm.getUsermm().getUserId());
			Sauserm mmObjSauserm = secDao.getSauserm(mm.getUsermm().getUserId());
			if(mmObj != null && mmObjSauserm !=null){
				mmObj.setUserNm(mm.getUser().getUserNm().trim());
				mmObj.setTelNo(mm.getUsermm().getTelNo());
				mmObj.setEmail(mm.getUsermm().getEmail());
				mmObj.setEpfNo(mm.getUsermm().getEpfNo());
				mmObjSauserm.setUserNm(mm.getUser().getUserNm());
				secDao.updateSauserMMS(mmObj);
				secDao.updateSauser(mmObjSauserm.getUserId(),mm.getUser().getUserNm());
				mm.setSuccess("Successfully Done !!!");
				
				
			}else {
				secDao.saveSauserMMS(mm.getUsermm());
				if(mmObjSauserm != null){
					secDao.updateSauser(mmObjSauserm.getUserId(),mmObjSauserm.getUserNm());
					mm.setSuccess("Successfully Done !!!");
					
				}else{
					mm.setError("Please send an email to mvmms.ceb.lk ");
					
				}
				
				
				System.out.println("test15");
				
			}
			mm.setUser(new Sauserm());
			
			mm.setUsermm(new SausermMm());
			modelmap.addAttribute("SUCCESS_MESSAGE", mm.getSuccess());
			modelmap.addAttribute("ERROR_MESSAGE", mm.getError());
			
			ModelAndView mv = new ModelAndView("UserDetails","usermodel",mm);
			return mv;
			
		}


		
		@RequestMapping(value = "/estApproval", method = RequestMethod.GET)
		public ModelAndView estApproval() {

			JobTransfer job = new JobTransfer();
			return new ModelAndView("approval/EstimateApproval");
			
			
		}
		
		
		
		@RequestMapping(value = "/mvplaning", method = RequestMethod.GET)
		public ModelAndView mvplaning() {

			JobTransfer job = new JobTransfer();
			return new ModelAndView("mvplan/mterplaning");
			
			
		}


		
		@RequestMapping(value = "/JobReopen", method = RequestMethod.POST)
		public ModelAndView JobReopen(@ModelAttribute("JobTransfer")  JobTransfer job,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) {
			System.out.println("job number:"+ job.getJobNumber());
			System.out.println("E cost Center:"+ job.getExsistingCostCenter());
			//System.out.println("N cost Center:"+ job.getNewCostCenter());
			String jobNumber = job.getJobNumber();
			String existingCostCenter = job.getExsistingCostCenter();
			//String newCostCenter = job.getNewCostCenter();
			
			List<Pcesthmt> listPcestHmt = hmtDao.findByCostCenterEstimateNo(existingCostCenter, jobNumber);
			if(listPcestHmt == null){
				job.setSuccessMsg("");
				job.setErrorMsg("Job Number Not Found ");
				
			}else{
				if(listPcestHmt.isEmpty()){
					job.setSuccessMsg("");
					job.setErrorMsg("Job Number Not Found ");
				}else if(listPcestHmt.size()>1){
					job.setSuccessMsg("");
					job.setErrorMsg("Job Number is Repeating ");
					
				}else if(listPcestHmt.size()==1){
					job.setSuccessMsg("OK");
					Pcesthmt obj = listPcestHmt.get(0);
					String estimateNo = obj.getId().getEstimateNo();
					hmtDao.jobReopen(existingCostCenter, jobNumber);
					//dmtDao.updatePcestdmt(existingCostCenter, estimateNo, newCostCenter);
					job.setSuccessMsg("Successfully Reopened !");
					
					
					
				}else{
					job.setErrorMsg("Error");
					
				}
			}
			return new ModelAndView("HelpDesk","JobTransfer",job);
			
		}

		@RequestMapping(value = "/JobTransfer", method = RequestMethod.POST)
		public ModelAndView JobTransfer(@ModelAttribute("JobTransfer")  JobTransfer job,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) {
			System.out.println("job number:"+ job.getJobNumber());
			System.out.println("E cost Center:"+ job.getExsistingCostCenter());
			System.out.println("N cost Center:"+ job.getNewCostCenter());
			String jobNumber = job.getJobNumber();
			String existingCostCenter = job.getExsistingCostCenter();
			String newCostCenter = job.getNewCostCenter();
			
			List<Pcesthmt> listPcestHmt = hmtDao.findByCostCenterEstimateNo(existingCostCenter, jobNumber);
			if(listPcestHmt == null){
				job.setSuccessMsg("");
				job.setErrorMsg("Job Number Not Found ");
				
			}else{
				if(listPcestHmt.isEmpty()){
					job.setSuccessMsg("");
					job.setErrorMsg("Job Number Not Found ");
				}else if(listPcestHmt.size()>1){
					job.setSuccessMsg("");
					job.setErrorMsg("Job Number is Repeating ");
					
				}else if(listPcestHmt.size()==1){
					job.setSuccessMsg("OK");
					Pcesthmt obj = listPcestHmt.get(0);
					String estimateNo = obj.getId().getEstimateNo();
					hmtDao.updatePcesthmt(existingCostCenter, jobNumber, newCostCenter);
					dmtDao.updatePcestdmt(existingCostCenter, estimateNo, newCostCenter);
					job.setSuccessMsg("Successfully Transferred !");
					
					
					
				}else{
					job.setErrorMsg("Error");
					
				}
			}
			return new ModelAndView("HelpDesk","JobTransfer",job);
			
		}

		
		@RequestMapping(value = "/NewTable", method = RequestMethod.GET)
		public ModelAndView NewTable() {

			ModelAndView model = new ModelAndView();
			model.setViewName("newtable");

			return model;

		}
		
		@RequestMapping(value = "/meterReport", method = RequestMethod.GET)
		public ModelAndView meterReport() {

			ModelAndView model = new ModelAndView();
			model.setViewName("meterReport");

			return model;

		}
		
		@RequestMapping(value = "/newMeterReport", method = RequestMethod.GET)
		public ModelAndView newMeterReport(HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			
			String deptId = request.getSession().getAttribute("deptId").toString();
			Map<String, String> esList = new LinkedHashMap<String, String>();
						PivModel model = new PivModel();
			
						Map<String,String> areaList = new LinkedHashMap<String,String>();
						Map<String,String> cscList = new LinkedHashMap<String,String>();
						Map<String,String> sinList = new LinkedHashMap<String,String>();
						Map<String,String> orderList = new LinkedHashMap<String,String>();
						
						String province = deptDao.getDD(deptId);
						System.out.println("province : "+province);
						Glcompm distDiv = glcompmDao.getDistDivision2(province);
						List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
						int depLoop = deptTm.size() - 1;
						for (int i = 0; i <= depLoop; i++) {
							System.out.println(i);
							Gldeptm ojb = (Gldeptm) deptTm.get(i);
							areaList.put(ojb.getDeptId(), ojb.getDeptNm());
						}
						
						List<ApprovalMm>  listOderCard =null;
						listOderCard = approvalMm.getPendingReqByES("EMTREQ", "12",deptId,userName);
				
						int orderCount = listOderCard.size() - 1;
						for (int i = 0; i <= orderCount; i++) {
							System.out.println(i);
							ApprovalMm ojb = (ApprovalMm) listOderCard.get(i);
							orderList.put(ojb.getApprovalId(), ojb.getApprovalId());
						}
						
						model.setCscList(cscList);
						model.setOrderList(orderList);
						model.setAreaList(areaList);
						model.setSinList(sinList);			
						ApprovalMm obj = new ApprovalMm();
						model.setMeter(obj);
			//model.setMode(mode);
			System.out.println("finish 22 "+ model.getMode());


			ModelAndView mo = new ModelAndView("MeterTR", "model",model);
			return mo;

		}


		@RequestMapping(value = "/createMeterReport", method = RequestMethod.GET)
		public ModelAndView createMeterReport(HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			
			String deptId = request.getSession().getAttribute("deptId").toString();
			Map<String, String> esList = new LinkedHashMap<String, String>();
						PivModel model = new PivModel();
			
						Map<String,String> areaList = new LinkedHashMap<String,String>();
						Map<String,String> cscList = new LinkedHashMap<String,String>();
						Map<String,String> sinList = new LinkedHashMap<String,String>();
						Map<String,String> orderList = new LinkedHashMap<String,String>();
						
						String province = deptDao.getDD(deptId);
						System.out.println("province : "+province);
						Glcompm distDiv = glcompmDao.getDistDivision2(province);
						List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
						int depLoop = deptTm.size() - 1;
						for (int i = 0; i <= depLoop; i++) {
							System.out.println(i);
							Gldeptm ojb = (Gldeptm) deptTm.get(i);
							areaList.put(ojb.getDeptId(), ojb.getDeptNm());
						}
						
						List<ApprovalMm>  listOderCard =null;
						listOderCard = approvalMm.getPendingReqByES("EMTREQ", "12",deptId,userName);
				
						int orderCount = listOderCard.size() - 1;
						for (int i = 0; i <= orderCount; i++) {
							System.out.println(i);
							ApprovalMm ojb = (ApprovalMm) listOderCard.get(i);
							orderList.put(ojb.getApprovalId(), ojb.getApprovalId());
						}
						
						model.setCscList(cscList);
						model.setOrderList(orderList);
						model.setAreaList(areaList);
						model.setSinList(sinList);			
						ApprovalMm obj = new ApprovalMm();
						model.setMeter(obj);
			//model.setMode(mode);
			System.out.println("finish 22 "+ model.getMode());


			ModelAndView mo = new ModelAndView("MeterTRNew", "model",model);
			return mo;

		}
		
		@RequestMapping(value = "/viewTransformer", method = RequestMethod.GET)
		public ModelAndView viewTransformer(
				@ModelAttribute("SaveSample") PcbModel pcbModel,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			Map<String, String> areaList = new LinkedHashMap<String, String>();
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			// get and set list of divisions
			//List<PCB_Division> divisionList = divisionDao.getAll();
			String province = deptDao.getDD(deptId);
			Glcompm distDiv = glcompmDao.getDistDivision2(province);
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
			int depLoop = deptTm.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				Gldeptm ojb = (Gldeptm) deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
				
			}
			
			pcbModel.setAreaList(areaList);
			
			List<PcbEquipment> list = equipDao.findEquiByAreaStatus(pcbModel.getPcbEquipment().getUnit(),"2");
			List<PcbModel> listPcbModel = new ArrayList<PcbModel>();
			//List<PcbEquipment> list = addEquipment.findEquipmentIdForMobile(division,branch,unit);
			
			if(list != null){
				int count = list.size();
				for(int i = 0 ; i < count -1 ; i ++){
					PcbModel modelObj = new PcbModel();
						PcbEquipment obj = list.get(i);
					String equipmentId = obj.getEquipmentId();
					PcbEquipment objEquipment = addEquipment.findEquipmentByEquipmentId(equipmentId);
					modelObj.setPcbEquipment(objEquipment);
					PcbSample objSample =  addSample.findSampleByEquipmentId(equipmentId);
					modelObj.setPcbSample(objSample);
					PcbCondition objCondition =  addCondition.findConditionByEquipmentId(equipmentId);
					modelObj.setPcbCondition(objCondition);
					PcbLocation objLocation =  addLocation.findLocationByEquipmentId(equipmentId);
					modelObj.setPcbLocation(objLocation);
					
					listPcbModel.add(modelObj);
				}
				
			}
						
			pcbModel.setListPcbModel(listPcbModel);
			ModelAndView mo = new ModelAndView("newtable","SaveSample", pcbModel);

			// add step type and success type to ModelAndView mo
			String success = "";
			String step = "step1";
			mo.addObject("step", step);
			mo.addObject("success", success);

			return mo;

		}
		
		@RequestMapping(value = "/viewCompletion", method = RequestMethod.GET)
		public ModelAndView viewCompletion(@RequestParam("mode") String mode,
				@ModelAttribute("SaveSample") PivModel pivModel,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			System.out.println("--> IN /addInformationReatedSample");
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			String deptId = (String) request.getSession().getAttribute("deptId");
			String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			String userName = (String) request.getSession().getAttribute("loggedUser").toString();
			
			String status ="";
			if(userLevel.equals("ES")){
				status="1";
			}else{
				status="2";
			}
			List<MmsInspection> list = null;
			if(userLevel.equals("ES")){
				
			if(mode.equals("HOTINS")){
				list = insDao.getInsListByTypeDeptIdEs("HOTINS", deptId,status,userName);
				
			}else if(mode.equals("HOTMNT")){
				list = insDao.getInsListByTypeDeptIdEs("HOTMNT", deptId,status,userName);
				
			}else if(mode.equals("COLMNT")){
				list = insDao.getInsListByTypeDeptIdEs("COLMNT", deptId,status,userName);
				
			}else if(mode.equals("COLMNT")){
				list = insDao.getInsListByTypeDeptIdEs("COLMNT", deptId,status,userName);
				
			}else if(mode.equals("COLMNT")){
				list = insDao.getInsListByTypeDeptIdEs("COLMNT", deptId,status,userName);
				
			}else{
				list = null;
			}
			}else{
				
				if(mode.equals("HOTINS")){
					list = insDao.getInsListByTypeDeptIdEE("HOTINS", deptId,status,userName);
					
				}else if(mode.equals("HOTMNT")){
					list = insDao.getInsListByTypeDeptIdEE("HOTMNT", deptId,status,userName);
					
				}else if(mode.equals("COLMNT")){
					list = insDao.getInsListByTypeDeptIdEE("COLMNT", deptId,status,userName);
					
				}else if(mode.equals("COLMNT")){
					list = insDao.getInsListByTypeDeptIdEE("COLMNT", deptId,status,userName);
					
				}else if(mode.equals("COLMNT")){
					list = insDao.getInsListByTypeDeptIdEE("COLMNT", deptId,status,userName);
					
				}else{
					list = null;
				}
				
				
				
				
			}
			pivModel.setInsList(list);
			
						ModelAndView mo = new ModelAndView("viewCompletion","SaveSample", pivModel);

			// add step type and success type to ModelAndView mo
			String success = "";
			String step = "step1";
			mo.addObject("step", step);
			mo.addObject("success", success);

			return mo;

		}

		
		
		@RequestMapping(value = "/viewTransformerS", method = RequestMethod.POST)
		public ModelAndView viewTransformerS(
				@ModelAttribute("SaveSample") PcbModel pcbModel,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			System.out.println("--> IN /addInformationReatedSample");
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			String deptId = (String) request.getSession().getAttribute("deptId");
			
			// get and set list of divisions
			//List<PCB_Division> divisionList = divisionDao.getAll();
			String province = deptDao.getDD(deptId);
			System.out.println("province : "+province);
			Glcompm distDiv = glcompmDao.getDistDivision2(province);
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
			int depLoop = deptTm.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				System.out.println(i);
				Gldeptm ojb = (Gldeptm) deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
				
			}
			
			pcbModel.setAreaList(areaList);
			
			List<PcbEquipment> list = equipDao.findEquiByAreaStatus(pcbModel.getPcbEquipment().getUnit(),"2");
			List<PcbModel> listPcbModel = new ArrayList<PcbModel>();
			//List<PcbEquipment> list = addEquipment.findEquipmentIdForMobile(division,branch,unit);
			System.out.println(" tttt: " + list );
			
			if(list != null){
				int count = list.size();
				for(int i = 0 ; i < count -1 ; i ++){
					PcbModel modelObj = new PcbModel();
						PcbEquipment obj = list.get(i);
					String equipmentId = obj.getEquipmentId();
					PcbEquipment objEquipment = addEquipment.findEquipmentByEquipmentId(equipmentId);
					modelObj.setPcbEquipment(objEquipment);
					PcbSample objSample =  addSample.findSampleByEquipmentId(equipmentId);
					modelObj.setPcbSample(objSample);
					PcbCondition objCondition =  addCondition.findConditionByEquipmentId(equipmentId);
					modelObj.setPcbCondition(objCondition);
					PcbLocation objLocation =  addLocation.findLocationByEquipmentId(equipmentId);
					modelObj.setPcbLocation(objLocation);
					
					listPcbModel.add(modelObj);
				}
				
			}
						
			pcbModel.setListPcbModel(listPcbModel);
			ModelAndView mo = new ModelAndView("newtable","SaveSample", pcbModel);

			// add step type and success type to ModelAndView mo
			String success = "";
			String step = "step1";
			mo.addObject("step", step);
			mo.addObject("success", success);

			return mo;

		}



		
		@RequestMapping(value = "/AddMeterDetails", method = RequestMethod.GET)
		public ModelAndView AddMeterDetails() {

			ModelAndView model = new ModelAndView();
			model.setViewName("MeterTestingData");

			return model;

		}
		
		@RequestMapping(value = "/AddMeterTestData", method = RequestMethod.GET)
		public ModelAndView MeterTestReport() {

			ModelAndView model = new ModelAndView();
			model.setViewName("MeterTestReport");

			return model;

		}

		
		@RequestMapping(value = "/AddMeterDetails2", method = RequestMethod.GET)
		public ModelAndView AddMeterDetails2() {

			ModelAndView model = new ModelAndView();
			model.setViewName("AddMeterDetails2");

			return model;

		}
		
		@RequestMapping(value = "/AddMeterDetails3", method = RequestMethod.GET)
		public ModelAndView AddMeterDetails3() {

			ModelAndView model = new ModelAndView();
			model.setViewName("AddMeterDetails3");

			return model;

		}


		
		@RequestMapping(value = "/LoginNew", method = RequestMethod.GET)
		public ModelAndView LoginNew() {

			ModelAndView model = new ModelAndView();
			model.setViewName("LoginNew");

			return model;

		}
		
		@RequestMapping(value = "/AddMeterDetails4", method = RequestMethod.GET)
		public ModelAndView AddMeterDetails4() {

			ModelAndView model = new ModelAndView();
			model.setViewName("DataRelatedMeter");

			return model;

		}
		
		@RequestMapping(value = "/dashboardEM", method = RequestMethod.GET)
		public ModelAndView dashboardEM(HttpServletRequest request,
				@ModelAttribute("pivModel") PivModel pivModel) {
			//System.out.println(" IN dashboard : ");
			PivModel pivModelNew = new PivModel();
			Map<String, String> lineList = new LinkedHashMap<String, String>();

			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			String province = deptDao.getDD(deptId);
			//System.out.println("province : "+province);
		Glcompm distDiv = glcompmDao.getDistDivision2(province);
			//provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
			//System.out.println("distDivnnnn : "+distDiv.getCompId());
			
			PivModel model = new PivModel();
			//List<Summary> summary = addLine.findDDSummary(distDiv.getCompId(), deptId);
			//System.out.println("distDivnnnnsize : "+summary.size());
			//List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
			/*int depLoop = deptTm.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				//System.out.println(i);
				Gldeptm ojb = (Gldeptm) deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
			}*/
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
			
			//System.out.println("test : "+ areaList.get(0));
			
				
			//
			
			
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
			
			//model.setMode(distDiv.getCompId());
			mo = new ModelAndView("MMS_dashboard_EM", "model", model);
			
			
			mo.addObject("province", distDiv.getCompId().trim());
			
			//List<String> areaListInt = deptDao.getAreaByProvinceNew(distDiv.getCompId().trim());
			//List<ApprovalMm>  listPendingIntReq = approvalMm.getAllInterruptionReqForProvince(areaListInt, "95", "INTREQ");
			
			
			List<ApprovalMm>  listPendingIntReq = null;
			List<ApprovalMm>  listApprovalUnread =null;
			
			if(userLevel.equals("ES")){
				listPendingIntReq = approvalMm.getPendingReqByES("EMTREQ", "12",deptId,userName);
				
			}else{
			listPendingIntReq = approvalMm.getPendingReqNew("EMTREQ", "11",deptId);
	
			}
			
			/*if(userLevel.equalsIgnoreCase("EEC")){
				listPendingIntReq = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","3");
				
			}else{
				listPendingIntReq = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","2");
			}
			*/
			
			//Long countEstimate = pcsstDao.getApprovalListCount(approveLevel, userName);
			
			/*Long countStdEstimate = spstdEstDao.getApprovalListCount(userName, approveLevel);
			
			
			Long countReviseEstimate = pchmtDao.getApprovalListCount(userName, approveLevel);
			
			Long countPSEstimate = cbpmtDao.getApprovalList(userName);
			
			
			Long countIVEstimate = inTrDao.getApprovalList(userName);
			
			Long countRQEstimate = RqDao.getApprovalList(userName);
			*/
			//System.out.println("eee: "+countStdEstimate.intValue());
			
			
			if(listPendingIntReq != null ){
				int countAllReq = listPendingIntReq.size();
				int countAll = listPendingIntReq.size();
				mo.addObject("intReq", listPendingIntReq.size());
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);
				
			}
			
/*			if(countEstimate != null){
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
				
				
			}*/



			return mo;

		}
		
		
		
		@RequestMapping(value = "/dashboardDMS", method = RequestMethod.GET)
		public ModelAndView dashboardDMS(HttpServletRequest request,
				@ModelAttribute("pivModel") PivModel pivModel) {
			System.out.println(" IN dashboard : ");
			PivModel pivModelNew = new PivModel();
			Map<String, String> lineList = new LinkedHashMap<String, String>();

			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			String province = deptDao.getDD(deptId);
			System.out.println("province : "+province);
			Glcompm distDiv = glcompmDao.getDistDivision2(province);
			provinceList.put(distDiv.getCompId(), distDiv.getCompNm());
			System.out.println("distDivnnnn : "+distDiv.getCompId());
			
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

			Map<String,String> cycle = new LinkedHashMap<String,String>();
			
			System.out.println("test : "+ areaList.get(0));
			
				
			
			ModelAndView mo = new ModelAndView();
			String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			model.setLineList(lineList);
			model.setSummaryList(summary);
			String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			String status = null;

			String phmBranch = (String) request.getSession().getAttribute("deptId");
			deptId = deptId.trim();
			
			//model.setMode(distDiv.getCompId());
			mo = new ModelAndView("MMS_dashboard_DMS", "model", model);
			
			
			mo.addObject("province", distDiv.getCompId().trim());
			
			List<String> areaListInt = deptDao.getAreaByProvinceNew(distDiv.getCompId().trim());
			//List<ApprovalMm>  listPendingIntReq = approvalMm.getAllInterruptionReqForProvince(areaListInt, "95", "INTREQ");
			
			
			List<ApprovalMm>  listPendingIntReq = null;
			List<ApprovalMm>  listApprovalUnread =null;
			listPendingIntReq = approvalMm.getPendingReqNew("EMTREQ", "11",deptId);
	
			
			
			/*if(userLevel.equalsIgnoreCase("EEC")){
				listPendingIntReq = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","3");
				
			}else{
				listPendingIntReq = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","2");
			}
			*/
			
			//Long countEstimate = pcsstDao.getApprovalListCount(approveLevel, userName);
			
			/*Long countStdEstimate = spstdEstDao.getApprovalListCount(userName, approveLevel);
			
			
			Long countReviseEstimate = pchmtDao.getApprovalListCount(userName, approveLevel);
			
			Long countPSEstimate = cbpmtDao.getApprovalList(userName);
			
			
			Long countIVEstimate = inTrDao.getApprovalList(userName);
			
			Long countRQEstimate = RqDao.getApprovalList(userName);
			*/
			//System.out.println("eee: "+countStdEstimate.intValue());
			
			
			if(listPendingIntReq != null ){
				int countAllReq = listPendingIntReq.size();
				int countAll = listPendingIntReq.size();
				mo.addObject("intReq", listPendingIntReq.size());
				mo.addObject("countAllReq", countAllReq);
				mo.addObject("countAll", countAll);
				
			}
			
/*			if(countEstimate != null){
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
				
				
			}*/



			return mo;

		}

		
		@RequestMapping(value = "/addMeterS", method = RequestMethod.POST)
		public ModelAndView MMSaddEquipmentnew(
		@ModelAttribute("SaveEquipment") PcbModel pcbModel,
		BindingResult bindingResult, HttpServletRequest request,
		HttpServletResponse response) throws Exception {

		
		PcbEquipment objEx = new PcbEquipment();
		String resultobjE = "";
		String resultobjS = "";
		String resultobjC = "";
		String resultobjL = "";
		String success = "";
		String submitType = "";
		PcbModel obj = new PcbModel();
		ModelAndView mo = new ModelAndView("MMS_addEquipment", "SaveEquipment",
		obj);

		// for add equipment
		// if (objEx == null) {
		System.out.println("--> IN ADD EQUIPMENT");
		try{
		String sequence = addEquipment.getNextEquipmentId("METER");
		System.out.println("equipmentId: "+ "METER" + "_" + sequence);

		String equipmentId = "METER"+"_"+sequence;
		
		pcbModel.getPcbEquipment().setEquipmentId(equipmentId);
		/*pcbModel.getPcbSample().setEquipmentId(equipmentId);
		pcbModel.getPcbCondition().setEquipmentId(equipmentId);
		pcbModel.getPcbLocation().setEquipmentId(equipmentId);
*/
		resultobjE = addEquipment.addEquipment(pcbModel.getPcbEquipment());
		success += "Equipment Added.. ";

		/*resultobjS = addSample.addSample(pcbModel.getPcbSample());
		success += "Sample Added.. ";

		resultobjC = addCondition.addCondition(pcbModel.getPcbCondition());
		success += "Condition Added.. ";

		resultobjL = addLocation.addLocation(pcbModel.getPcbLocation());
		success += "Location Added.. ";
*/		}catch(Exception e){
		System.out.println("error:" + e.getMessage());
		}
		mo = new ModelAndView("MMS_addMeter", "SaveEquipment", obj);
			mo.addObject("success", success);
		return mo;
		}

		
		
		@RequestMapping(value = "/addMeter", method = RequestMethod.GET)
		public ModelAndView addMeter(
				@ModelAttribute("SaveEquipment") PcbModel pcbModel,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			System.out.println("--> IN /addEquipment");

			pcbModel = new PcbModel();
			
	        List<Glcompm> compList = compDao.getDisDivision();
			
			//pcbModel.setDivisionList(divisionList);
			//pcbModel.setCompList(compList);
			Map<String,String> divListTem = new LinkedHashMap<String,String>();
			
			int depLoop = compList.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				Glcompm ojb = (Glcompm) compList.get(i);
				System.out.println(i + " " +ojb.getCompNm() );
				
				divListTem.put(ojb.getCompId(), ojb.getCompNm());
			}
			
			pcbModel.setDivList(divListTem);
			
			
			

			// get and set list of divisions
			//List<PCB_Division> divisionList = divisionDao.getAll();
			//pcbModel.setDivisionList(divisionList);

			return new ModelAndView("MMS_addMeter", "SaveEquipment", pcbModel);

		}
		
		@SuppressWarnings("unchecked")
		@RequestMapping(value ="/showAccountsDetails" ,method = RequestMethod.GET, produces = "application/json")
		  public @ResponseBody String showAccountsDetails() {
			System.out.println("countValueJournal");
			//String userName = request.getSession().getAttribute("loggedUser").toString();
			 
			String valueJurnal = null;
				try {
					RestTemplate restTemplate = new RestTemplate();
					System.out.println("countValueJournal1");	 
					
					//String url="http://10.128.1.126/ceb_ptl/api/ValueJournal/RecommendValueJournal?jnl_id="+journal+"&user="+userName.trim();    
					String url = "http://testiis1.ceb:5555/api/BulkDetail/GetBulkCustomerDetails?account_no=3570100448";
					
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
		
		@RequestMapping(value = "/MeterTestingRequest", method = RequestMethod.GET)
		public ModelAndView MeterTestingRequest(HttpServletRequest request,@RequestParam("mode") String mode) {
			String deptId = request.getSession().getAttribute("deptId").toString();
			Map<String, String> esList = new LinkedHashMap<String, String>();
						PivModel model = new PivModel();
			
			/*List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
			
			if(saUserList != null){
				int eeCount = saUserList.size()-1;
				for(int x=0;x<=eeCount;x++){
					Sauserm objUser = saUserList.get(x);
					System.out.println("objUser.getUserId() : "+objUser.getUserId());
					
					esList.put(objUser.getUserId(),objUser.getUserNm());
					System.out.println("esList : "+esList.size());
					
				}
			}
			
			List<Glcompm> compList = compDao.getDisDivision();
					
			Map<String,String> divListTem = new LinkedHashMap<String,String>();
			
			int depLoop = compList.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				Glcompm ojb = (Glcompm) compList.get(i);
				System.out.println(i + " " +ojb.getCompNm() );
				
				divListTem.put(ojb.getCompId(), ojb.getCompNm());
			}
			
			model.setDivList(divListTem);
			
			model.setEsList(esList);
			*/
						Map<String,String> areaList = new LinkedHashMap<String,String>();
						Map<String,String> cscList = new LinkedHashMap<String,String>();
						Map<String,String> sinList = new LinkedHashMap<String,String>();
						
						String province = deptDao.getDD(deptId);
						System.out.println("province : "+province);
						Glcompm distDiv = glcompmDao.getDistDivision2(province);
						List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
						int depLoop = deptTm.size() - 1;
						for (int i = 0; i <= depLoop; i++) {
							System.out.println(i);
							Gldeptm ojb = (Gldeptm) deptTm.get(i);
							areaList.put(ojb.getDeptId(), ojb.getDeptNm());
							
							/*List<Gldeptm> listGL =  gldeptDao.getCscByArea(deptTm.get(0).getDeptId());
							if(listGL != null){
								int countL = listGL.size();
								for(int x = 0;x<countL;x++){
									Gldeptm obj = listGL.get(i);
									cscList.put(obj.getDeptId(), obj.getDeptNm());
								}
						}*/
							
							
							
							
						}
						
						model.setCscList(cscList);

						model.setAreaList(areaList);
						model.setSinList(sinList);			
						
			model.setMode(mode);
			System.out.println("finish 22 "+ model.getMode());
			
			ModelAndView mo = new ModelAndView("MeterTestingRequest", "model",model);
			return mo;

		}
		
		@RequestMapping(value = "/MeterTestingRequestEdit", method = RequestMethod.GET)
		public ModelAndView MeterTestingRequestEdit(HttpServletRequest request,@RequestParam("mode") String mode) {
			String deptId = request.getSession().getAttribute("deptId").toString();
			Map<String, String> esList = new LinkedHashMap<String, String>();
						PivModel model = new PivModel();
			
						Map<String,String> areaList = new LinkedHashMap<String,String>();
						Map<String,String> cscList = new LinkedHashMap<String,String>();
						Map<String,String> sinList = new LinkedHashMap<String,String>();
						Map<String,String> orderList = new LinkedHashMap<String,String>();
						
						String province = deptDao.getDD(deptId);
						System.out.println("province : "+province);
						Glcompm distDiv = glcompmDao.getDistDivision2(province);
						List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
						int depLoop = deptTm.size() - 1;
						for (int i = 0; i <= depLoop; i++) {
							System.out.println(i);
							Gldeptm ojb = (Gldeptm) deptTm.get(i);
							areaList.put(ojb.getDeptId(), ojb.getDeptNm());
						}
						
						List<ApprovalMm>  listOderCard =null;
						listOderCard = approvalMm.getPendingReqNew("EMTREQ", "11",deptId);
				
						int orderCount = listOderCard.size() - 1;
						for (int i = 0; i <= orderCount; i++) {
							System.out.println(i);
							ApprovalMm ojb = (ApprovalMm) listOderCard.get(i);
							orderList.put(ojb.getApprovalId(), ojb.getApprovalId());
						}
						
						model.setCscList(cscList);
						model.setOrderList(orderList);
						model.setAreaList(areaList);
						model.setSinList(sinList);			
						ApprovalMm obj = new ApprovalMm();
						model.setMeter(obj);
			model.setMode(mode);
			System.out.println("finish 22 "+ model.getMode());
			
			ModelAndView mo = new ModelAndView("MeterTestingRequestEdit", "model",model);
			return mo;

		}
		
		
		
		@RequestMapping(value = "/CreateTR", method = RequestMethod.GET)
		public ModelAndView CreateTR(HttpServletRequest request) {
			String deptId = request.getSession().getAttribute("deptId").toString();
			Map<String, String> esList = new LinkedHashMap<String, String>();
						PivModel model = new PivModel();
						String userName = (String) request.getSession().getAttribute("loggedUser");
						
						Map<String,String> areaList = new LinkedHashMap<String,String>();
						Map<String,String> cscList = new LinkedHashMap<String,String>();
						Map<String,String> sinList = new LinkedHashMap<String,String>();
						Map<String,String> orderList = new LinkedHashMap<String,String>();
						
						String province = deptDao.getDD(deptId);
						System.out.println("province : "+province);
						Glcompm distDiv = glcompmDao.getDistDivision2(province);
						List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
						int depLoop = deptTm.size() - 1;
						for (int i = 0; i <= depLoop; i++) {
							System.out.println(i);
							Gldeptm ojb = (Gldeptm) deptTm.get(i);
							areaList.put(ojb.getDeptId(), ojb.getDeptNm());
						}
						
						List<ApprovalMm>  listOderCard =null;
						listOderCard = approvalMm.getPendingReqByES("EMTREQ", "12",deptId,userName);
				
						int orderCount = listOderCard.size() - 1;
						for (int i = 0; i <= orderCount; i++) {
							System.out.println(i);
							ApprovalMm ojb = (ApprovalMm) listOderCard.get(i);
							orderList.put(ojb.getApprovalId(), ojb.getApprovalId());
						}
						
						model.setCscList(cscList);
						model.setOrderList(orderList);
						model.setAreaList(areaList);
						model.setSinList(sinList);			
						ApprovalMm obj = new ApprovalMm();
						model.setMeter(obj);
			//model.setMode(mode);
			System.out.println("finish 22 "+ model.getMode());
			
			ModelAndView mo = new ModelAndView("MeterTR", "model",model);
			return mo;

		}

		
		
		
		
		
		
		@RequestMapping(value = "/MeterTestingRequestEditSS", method = RequestMethod.POST)
		public ModelAndView MeterTestingRequestEditSS(HttpServletRequest request,@RequestParam("file") MultipartFile file,@ModelAttribute("model") PivModel model,BindingResult bindingResult) throws Exception{
			ModelAndView mo = null;
			SausermMm userMm = null;
			
			
			/*String ordercardnumber = model.getOrdercard();
			System.out.println(ordercardnumber);
			ApprovalMm orderObj = approvalMm.findByID(ordercardnumber);
			
			model.setAdditionalwork(orderObj.getReason());
			model.setOrder(orderObj.getReq1());
			model.setLocationsin(orderObj.getFromto());
			model.setTariff(orderObj.getFilename2());
			model.setContact(orderObj.getFilename3());
			model.setSinnumber(orderObj.getFilename4());
			model.setDemand(orderObj.getFilename5());
			model.setArea(orderObj.getAreaCode());
			model.setCsc(orderObj.getCsc());
			model.setCtratio(orderObj.getPermitNo());
			
Map<String,String> orderList = new LinkedHashMap<String,String>();
			
			List<ApprovalMm>  listOderCard =null;
			listOderCard = approvalMm.getPendingReqNew("EMTREQ", "11",deptId);
	
			int orderCount = listOderCard.size() - 1;
			for (int i = 0; i <= orderCount; i++) {
				System.out.println(i);
				ApprovalMm ojb = (ApprovalMm) listOderCard.get(i);
				orderList.put(ojb.getApprovalId(), ojb.getApprovalId());
			}
			
			model.setOrderList(orderList);
	*/
			
			String deptId = request.getSession().getAttribute("deptId").toString();
			String es = ""; 
			if(model.getSausermEE() != null){
				es = model.getSausermEE().getUserId();
				userMm =secDao.getSausermMms(model.getSausermEE().getUserId());
			}
			String userName = request.getSession().getAttribute("loggedUser").toString();
			
			model.setPreparedBy(userName);
			
			
			Map<String, String> esList = new LinkedHashMap<String, String>();
			
			String path1 = PathMMS.getReportPath() + File.separator + "Reports";
    		File dir1 = new File(path1 + File.separator + "Reports");
    		if (!dir1.exists())
				dir1.mkdirs();
    		
    		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
    		File dir2 = new File(path1 + File.separator + "EmailAttachment");
    		if (!dir2.exists())
				dir2.mkdirs();
    		String stringOflineIds = "";
			File serverFile = null;
			File serverFile1 = null;
			File serverFile2 = null;
			File serverFile3 = null;
			File serverFile4 = null;
			System.out.println("finish 3 " );
			
			
			String branchName = gldeptDao.getName(deptId);
			HashMap<String, Object> param = new HashMap<String, Object>(3);
			param.put("0", model.getMailContent());
			param.put("1", model.getMailContent2());
			param.put("2", branchName);
			
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date newDate = new Date();
    		String dateString = format.format(newDate);
    		String ss =gldeptDao.getDD(deptId);
    		String province = glcompmDao.getProvince(ss);
    		if(province != null){
    			province.trim();
    		}
    		System.out.println("glcompmDao.getDistDivision " + province +"@");
    		String pre_approval_id = "";
    		if(deptId.equals("490.60")){
    			pre_approval_id = "DD2-CP2-EM-21-";
            	
    		}else if(deptId.equals("550.80")){
    			
    		}
    		String nextNumver = approvalMm.getNextAppIdEM(pre_approval_id);
    		System.out.println("nextNumver 5 "+ nextNumver );
			
    		String approval_id = pre_approval_id + nextNumver;
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

    		pdfFileName = generateReport("EMTREQ","Meter_Request",param,null,path1,path1,model,branchName,"",province,approval_id,serverFile);
    		
    		File pdfFile = new File(pdfFileName);
			
    					
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
			
			
			content = "\n\nThe Meter activity request is successfully created. You can view that by login into  https://mms.ceb.lk/MMS/WelcomeEM.";
			
			subject ="METER ACTIVITY REQUEST FROM "+branchName + " " + subject_str;
			sms_content ="The Meter activity request is successfully created. You can view that by login into  https://mms.ceb.lk/MMS/WelcomeEM";
			pre_approval_id_SMS = "SMSMVINSR-"+deptId;
			approveType = "EMTREQ";
				fromStatus = "1";
				toStatus = "11";
				success = "The Meter activity request is successfully created ";
				firstClouse ="Electrical Engineer";
				
			ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
			MailMail mm = (MailMail) context.getBean("mailMail");
			String url="";
			String urlCE="";
			String urlEE="";
			String[] emailListEM = new String[1];
			emailListEM[0] ="thilankawanninayake@gmail.com";
			//emailListEM[1] ="gchampika28@gmail.com";
			
			url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			mm.sendMailTo(firstClouse, content,"gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
			urlCE="http://smsgw.ceb/SMSPlatform.php?recipients=0718898892&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			urlEE="http://smsgw.ceb/SMSPlatform.php?recipients=713529368&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			
			mm.sendMailTo(firstClouse, content,"shihranaleer@gmail.com",emailListEM,subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
			
			//mm.sendMailTo(firstClouse, content,,subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
			
			System.out.println("finish 1 " );
			Date date = new Date();
			RestTemplate restTemplate = new RestTemplate();
			try {
				restTemplate.getForObject(url, String.class);
				restTemplate.getForObject(urlEE, String.class);
				restTemplate.getForObject(urlCE, String.class);
				
				System.out.println("sendSMS 77" );

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("sendSMS 78"+ e1.getMessage() );

				e1.printStackTrace();
			}
			
			String enterDate = sdf.format(date);
			
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
			appr.setReferenceNo(branchName);
			appr.setReason(model.getAdditionalwork());
			appr.setReq1(model.getOrder());
			appr.setReq2(model.getLocationsin());
			appr.setDeptId(deptId);
			appr.setPhmBranch(deptId);
			appr.setApprovalType(approveType);
			appr.setApprovedLevel(approveLevel);
			appr.setFromStatus(fromStatus);
			appr.setToStatus(toStatus);
			appr.setApprovedDate(date2);
			appr.setApprovedTime(timeString);
			appr.setApprovedBy(approvedBy);
			model.setMessage(success);
			appr.setFromto(model.getLocationsin());
			appr.setFilename2(model.getTariff());
			appr.setFilename3(model.getContact());
			if(model.getSinnumber().equals("NONE")){
				appr.setTotower(model.getAccountnumber());
				
			}else{
			    appr.setFilename4(model.getSinnumber());
			}
			
			appr.setFilename5(model.getDemand());
			appr.setAreaCode(model.getArea());
			appr.setCsc(model.getCsc());
			appr.setPermitNo(model.getCtratio());
			
			//appr.setMailContent(model.getTariff());
			//appr.setMailContent2(model.getContact());
			//appr.setFrom(model.getLocationsin());
			//appr.setTo(model.getSinnumber());
			
try {
				//approvalMm.addApproval(appr);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
			
			if(saUserList != null){
				int eeCount = saUserList.size()-1;
				for(int x=0;x<=eeCount;x++){
					Sauserm objUser = saUserList.get(x);
					System.out.println("objUser.getUserId() : "+objUser.getUserId());
					
					esList.put(objUser.getUserId(),objUser.getUserNm());
					System.out.println("esList : "+esList.size());
					
				}
			}
			model.setEsList(esList);
			
			ApprovalMm obj = new ApprovalMm();
			model.setAdditionalwork("");
			model.setOrder("");
			model.setLocationsin("");
			model.setLocationsin("");
			model.setTariff("");
			model.setContact("");
			model.setSinnumber("");
			model.setDemand("");
			model.setArea("");
			model.setCsc("");
			model.setCtratio("");
			
			Map<String,String> areaList = new LinkedHashMap<String,String>();
			Map<String,String> cscList = new LinkedHashMap<String,String>();
			Map<String,String> sinList = new LinkedHashMap<String,String>();
			
			String province1 = deptDao.getDD(deptId);
			System.out.println("province : "+province);
			Glcompm distDiv = glcompmDao.getDistDivision2(province1);
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
			int depLoop = deptTm.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				System.out.println(i);
				Gldeptm ojb = (Gldeptm) deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
				
				/*List<Gldeptm> listGL =  gldeptDao.getCscByArea(deptTm.get(0).getDeptId());
				if(listGL != null){
					int countL = listGL.size();
					for(int x = 0;x<countL;x++){
						Gldeptm obj = listGL.get(i);
						cscList.put(obj.getDeptId(), obj.getDeptNm());
					}
			}*/
				
				
				
				
			}
			
			model.setCscList(cscList);

			model.setAreaList(areaList);
			model.setSinList(sinList);			

			
			
			
			mo = new ModelAndView("MeterTestingRequest", "model",model);
			
			
			return mo;

		}

		
		@RequestMapping(value = "/MeterTestingRequestS", method = RequestMethod.POST)
		public ModelAndView MeterTestingRequestS(HttpServletRequest request,@RequestParam("file") MultipartFile file,@ModelAttribute("model") PivModel model,BindingResult bindingResult) throws Exception{
			ModelAndView mo = null;
			SausermMm userMm = null;
			
			String deptId = request.getSession().getAttribute("deptId").toString();
			String es = ""; 
			if(model.getSausermEE() != null){
				es = model.getSausermEE().getUserId();
				userMm =secDao.getSausermMms(model.getSausermEE().getUserId());
			}
			String userName = request.getSession().getAttribute("loggedUser").toString();
			
			model.setPreparedBy(userName);
			
			
			Map<String, String> esList = new LinkedHashMap<String, String>();
			
			String path1 = PathMMS.getReportPath() + File.separator + "Reports";
    		File dir1 = new File(path1 + File.separator + "Reports");
    		if (!dir1.exists())
				dir1.mkdirs();
    		
    		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
    		File dir2 = new File(path1 + File.separator + "EmailAttachment");
    		if (!dir2.exists())
				dir2.mkdirs();
    		String stringOflineIds = "";
			File serverFile = null;
			File serverFile1 = null;
			File serverFile2 = null;
			File serverFile3 = null;
			File serverFile4 = null;
			System.out.println("finish 3 " );
			
			
			String branchName = gldeptDao.getName(deptId);
			HashMap<String, Object> param = new HashMap<String, Object>(3);
			param.put("0", model.getMailContent());
			param.put("1", model.getMailContent2());
			param.put("2", branchName);
			
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date newDate = new Date();
    		String dateString = format.format(newDate);
    		String ss =gldeptDao.getDD(deptId);
    		String province = glcompmDao.getProvince(ss);
    		if(province != null){
    			province.trim();
    		}
    		System.out.println("glcompmDao.getDistDivision " + province +"@");
    		String pre_approval_id = "";
    		if(deptId.equals("490.60")){
    			pre_approval_id = "DD2-CP2-EM-21-";
            	
    		}else if(deptId.equals("550.80")){
    			pre_approval_id = "DD3-SBP-EM-21-";
            	
    		}else{
    			pre_approval_id = "DD2-CP2-EM-21-";
            	
    		}
    		String nextNumver = approvalMm.getNextAppIdEM(pre_approval_id);
    		System.out.println("nextNumver 5 "+ nextNumver );
			
    		String approval_id = pre_approval_id + nextNumver;
    		String pdfFileName = "";
    		
    		ApprovalMm appr = new ApprovalMm();
			
    		String path = PathMMS.getReportPath();
    		File dir = new File(path + File.separator + "InsMntRequest");
    		if (!dir.exists())
				dir.mkdirs();
    		
    		
    		// Create the file on server
			File serverFileOnServer = new File(dir.getAbsolutePath()+ File.separator + pdfFileName);
			String name ="";  		
    		if (!file.isEmpty()) {
				try {
					name = file.getOriginalFilename();
					
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

    		pdfFileName = generateReport("EMTREQ","Meter_Request",param,null,path1,path1,model,branchName,"",province,approval_id,serverFile);
    		
    		File pdfFile = new File(pdfFileName);
			
    					
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
			
			
			content = "\n\nThe Meter activity request is successfully created. You can view that by login into  https://mms.ceb.lk/MMS/WelcomeEM.";
			
			subject ="METER ACTIVITY REQUEST FROM "+branchName + " " + subject_str;
			sms_content ="The Meter activity request is successfully created. You can view that by login into  https://mms.ceb.lk/MMS/WelcomeEM";
			pre_approval_id_SMS = "SMSMVINSR-"+deptId;
			approveType = "EMTREQ";
				fromStatus = "1";
				toStatus = "11";
				success = "The Meter activity request is successfully created ";
				firstClouse ="Electrical Engineer";
				
			ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
			MailMail mm = (MailMail) context.getBean("mailMail");
			String url="";
			String urlCE="";
			String urlEE="";
			String[] emailListEM = new String[1];
			if(deptId.equals("490.60")){
				emailListEM[0] ="thilankawanninayake@gmail.com";
				
			}else if (deptId.equals("550.80")){
				emailListEM[0] ="ceemsbp.dd3@ceb.lk";
				
			}else{
				emailListEM[0] ="gchampika28@gmail.com";
				
			}
			//emailListEM[1] ="gchampika28@gmail.com";
			
			url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			mm.sendMailTo(firstClouse, content,"gchampika28@gmail.com",subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
			if(deptId.equals("490.60")){
				
			urlCE="http://smsgw.ceb/SMSPlatform.php?recipients=0718898892&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			urlEE="http://smsgw.ceb/SMSPlatform.php?recipients=713529368&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
			mm.sendMailTo(firstClouse, content,"shihranaleer@gmail.com",emailListEM,subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
			
			}else if (deptId.equals("550.80")){
				
				urlCE="http://smsgw.ceb/SMSPlatform.php?recipients=0714297760&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
				urlEE="http://smsgw.ceb/SMSPlatform.php?recipients=0716876681&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
				mm.sendMailTo(firstClouse, content,"eeemsbp.dd3@ceb.lk",emailListEM,subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
				
			}
			
			
			
			//mm.sendMailTo(firstClouse, content,,subject,serverFile,serverFile1,serverFile2,serverFile3,serverFile4,pdfFile);
			
			System.out.println("finish 1 " );
			Date date = new Date();
			RestTemplate restTemplate = new RestTemplate();
			try {
				restTemplate.getForObject(url, String.class);
				restTemplate.getForObject(urlEE, String.class);
				restTemplate.getForObject(urlCE, String.class);
				
				System.out.println("sendSMS 77" );

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("sendSMS 78"+ e1.getMessage() );

				e1.printStackTrace();
			}
			
			String enterDate = sdf.format(date);
			
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
			appr.setReferenceNo(branchName);
			appr.setReason(model.getAdditionalwork());
			appr.setReq1(model.getOrder());
			//appr.setReq2(model.getLocationsin());
			appr.setDeptId(deptId);
			appr.setPhmBranch(deptId);
			appr.setApprovalType(approveType);
			appr.setApprovedLevel(approveLevel);
			appr.setFromStatus(fromStatus);
			appr.setToStatus(toStatus);
			appr.setApprovedDate(date2);
			appr.setApprovedTime(timeString);
			appr.setApprovedBy(approvedBy);
			model.setMessage(success);
			appr.setFromto(model.getLocationsin());
			appr.setFilename2(model.getTariff());
			appr.setFilename3(model.getContact());
			if(model.getSinnumber().equals("NONE")){
				appr.setTotower(model.getAccountnumber());
				
			}else{
			    appr.setFilename4(model.getSinnumber());
			}
			
			appr.setFilename5(model.getDemand());
			appr.setFilename1(name);
			appr.setAreaCode(model.getArea());
			appr.setCsc(model.getCsc());
			appr.setPermitNo(model.getCtratio());
			
			//appr.setMailContent(model.getTariff());
			//appr.setMailContent2(model.getContact());
			//appr.setFrom(model.getLocationsin());
			//appr.setTo(model.getSinnumber());
			
try {
				approvalMm.addApproval(appr);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<Sauserm> saUserList = secDao.getAllUserByRptUser(deptId, "ES");
			
			if(saUserList != null){
				int eeCount = saUserList.size()-1;
				for(int x=0;x<=eeCount;x++){
					Sauserm objUser = saUserList.get(x);
					System.out.println("objUser.getUserId() : "+objUser.getUserId());
					
					esList.put(objUser.getUserId(),objUser.getUserNm());
					System.out.println("esList : "+esList.size());
					
				}
			}
			model.setEsList(esList);
			
			ApprovalMm obj = new ApprovalMm();
			model.setAdditionalwork("");
			model.setOrder("");
			model.setLocationsin("");
			model.setLocationsin("");
			model.setTariff("");
			model.setContact("");
			model.setSinnumber("");
			model.setDemand("");
			model.setArea("");
			model.setCsc("");
			model.setCtratio("");
			
			Map<String,String> areaList = new LinkedHashMap<String,String>();
			Map<String,String> cscList = new LinkedHashMap<String,String>();
			Map<String,String> sinList = new LinkedHashMap<String,String>();
			
			String province1 = deptDao.getDD(deptId);
			System.out.println("province : "+province);
			Glcompm distDiv = glcompmDao.getDistDivision2(province1);
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
			int depLoop = deptTm.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				System.out.println(i);
				Gldeptm ojb = (Gldeptm) deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
				
				/*List<Gldeptm> listGL =  gldeptDao.getCscByArea(deptTm.get(0).getDeptId());
				if(listGL != null){
					int countL = listGL.size();
					for(int x = 0;x<countL;x++){
						Gldeptm obj = listGL.get(i);
						cscList.put(obj.getDeptId(), obj.getDeptNm());
					}
			}*/
				
				
				
				
			}
			
			model.setCscList(cscList);

			model.setAreaList(areaList);
			model.setSinList(sinList);			

			
			
			
			mo = new ModelAndView("MeterTestingRequest", "model",model);
			
			
			return mo;

		}
		
		
		@RequestMapping(value = "/MeterRequestEdtS", method = RequestMethod.POST)
		public ModelAndView MeterRequestEdtS(HttpServletRequest request,@RequestParam("file") MultipartFile file,@ModelAttribute("model") PivModel model,BindingResult bindingResult) throws Exception{
			String success = "";
			
			 try {
				
				ApprovalMm orderObj = approvalMm.findByID(model.getMeter().getApprovalId());
				orderObj.setReason(model.getMeter().getReason());
				orderObj.setReq1(model.getMeter().getReq1());
				orderObj.setReq2(model.getMeter().getReq2());
				orderObj.setFromto(model.getMeter().getFromto());
				orderObj.setFilename2(model.getMeter().getFilename2());
				orderObj.setFilename3(model.getMeter().getFilename3());
				orderObj.setTotower(model.getMeter().getTotower());
				orderObj.setFilename4(model.getMeter().getFilename4());
				orderObj.setFilename5(model.getMeter().getFilename5());
				orderObj.setAreaCode(model.getMeter().getAreaCode());
				orderObj.setCsc(model.getMeter().getCsc());
				orderObj.setPermitNo(model.getMeter().getPermitNo());
				String path = PathMMS.getReportPath();
	    		
				File dir = new File(path + File.separator + "InsMntRequest");
	    		if (!dir.exists())
					dir.mkdirs();
	    		
				if (!file.isEmpty()) {
					try {
						String name = file.getOriginalFilename();
						
						String extension = Util.getSubStringFirstPart(name,".");
						
						System.out.println("extention :" +extension);
						
						name = model.getMeter().getApprovalId() + "IMG1" + extension;
						byte[] bytes = file.getBytes();
						orderObj.setFilename1(name);
						File serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
						BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
						
						stream.write(bytes);
						stream.close();
								
						
						
						}catch(Exception e){
						System.out.println("error :"+e);
					}
	    		}

				
				 approvalMm.updateApproval(orderObj);
				 success = "The Meter activity request is successfully updated";
					} catch (Exception e) {
						 // TODO Auto-generated catch block
						e.printStackTrace();
						success = "The Meter activity request is not updated";
						
					}
			 
			 String deptId = request.getSession().getAttribute("deptId").toString();
			 model.setMessage(success);
			 Map<String,String> orderList = new LinkedHashMap<String,String>();
				
				List<ApprovalMm>  listOderCard =null;
				listOderCard = approvalMm.getPendingReqNew("EMTREQ", "11",deptId);
		
				int orderCount = listOderCard.size() - 1;
				for (int i = 0; i <= orderCount; i++) {
					ApprovalMm ojb = (ApprovalMm) listOderCard.get(i);
					orderList.put(ojb.getApprovalId(), ojb.getApprovalId());
				}
				model.setOrderList(orderList);
				ApprovalMm obj = new ApprovalMm();
		        model.setMeter(obj);
				ModelAndView mo = new ModelAndView("MeterTestingRequestEdit", "model",model);
				
				
				return mo;

				
		}
		
		@RequestMapping(value = "/MeterTestingRequestEditS", method = RequestMethod.POST)
		public ModelAndView MeterTestingRequestEditS(HttpServletRequest request,@ModelAttribute("model") PivModel model,BindingResult bindingResult) throws Exception{
			ModelAndView mo = null;
			SausermMm userMm = null;
			System.out.println("reason :"+ model.getMeter().getReason());
			
			
			/*String ordercardnumber = model.getOrdercard();
			System.out.println(ordercardnumber);
			*/ApprovalMm orderObj = approvalMm.findByID(model.getMeter().getApprovalId());
			
            Map<String,String> areaList = new LinkedHashMap<String,String>();
			
			String deptId = request.getSession().getAttribute("deptId").toString();
			
			String province1 = deptDao.getDD(deptId);
			Glcompm distDiv = glcompmDao.getDistDivision2(province1);
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
			int depLoop = deptTm.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				Gldeptm ojb = (Gldeptm) deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
			}
			model.setAreaList(areaList);

			System.out.println("AreaCode:"+orderObj.getAreaCode());
			Map<String,String> orderList = new LinkedHashMap<String,String>();
			
			List<ApprovalMm>  listOderCard =null;
			listOderCard = approvalMm.getPendingReqNew("EMTREQ", "11",deptId);
	
			int orderCount = listOderCard.size() - 1;
			for (int i = 0; i <= orderCount; i++) {
				ApprovalMm ojb = (ApprovalMm) listOderCard.get(i);
				orderList.put(ojb.getApprovalId(), ojb.getApprovalId());
			}
			
			Map<String,String> cscList = new LinkedHashMap<String,String>();
			
			List<Gldeptm> cscListObj = deptDao.getCscByArea(orderObj.getAreaCode().trim());
			int cscCount = cscListObj.size() - 1;
			for (int i = 0; i <= cscCount; i++) {
				Gldeptm ojb = (Gldeptm) cscListObj.get(i);
				cscList.put(ojb.getDeptId(), ojb.getDeptNm());
			}
			
			Map<String,String> sinList = new LinkedHashMap<String,String>();
			
			List<PcbEquipment> sinListObj = equipDao.findEquiByAreaStatus(orderObj.getAreaCode().trim(),"2");
			int sinCount = sinListObj.size() - 1;
			for (int i = 0; i <= sinCount; i++) {
				PcbEquipment ojb = (PcbEquipment) sinListObj.get(i);
				sinList.put(ojb.getSinNo(), ojb.getSinNo());
			}
			
			model.setCscList(cscList);
			model.setSinList(sinList);
			model.setOrderList(orderList);
			model.setMeter(orderObj);
			model.setOrdercard(model.getMeter().getApprovalId());
			

            mo = new ModelAndView("MeterTestingRequestEdit", "model",model);
			
			
			return mo;

		}
		
		
		
		@RequestMapping(value = "/MeterTRS", method = RequestMethod.POST)
		public ModelAndView MeterTRS(HttpServletRequest request,@ModelAttribute("model") PivModel model,BindingResult bindingResult) throws Exception{
			ModelAndView mo = null;
			SausermMm userMm = null;
			//System.out.println("reason :"+ model.getMeter().getReason());
			String userName = (String) request.getSession().getAttribute("loggedUser");
			
		
			/*String ordercardnumber = model.getOrdercard();
			System.out.println(ordercardnumber);
			*/ApprovalMm orderObj = approvalMm.findByID(model.getMeter().getApprovalId());
			
            Map<String,String> areaList = new LinkedHashMap<String,String>();
			
			String deptId = request.getSession().getAttribute("deptId").toString();
			
			String province1 = deptDao.getDD(deptId);
			Glcompm distDiv = glcompmDao.getDistDivision2(province1);
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
			int depLoop = deptTm.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				Gldeptm ojb = (Gldeptm) deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
			}
			model.setAreaList(areaList);

			System.out.println("AreaCode:"+orderObj.getAreaCode());
			Map<String,String> orderList = new LinkedHashMap<String,String>();
			
			List<ApprovalMm>  listOderCard =null;
			listOderCard = approvalMm.getPendingReqByES("EMTREQ", "12",deptId,userName);
	
			int orderCount = listOderCard.size() - 1;
			for (int i = 0; i <= orderCount; i++) {
				ApprovalMm ojb = (ApprovalMm) listOderCard.get(i);
				orderList.put(ojb.getApprovalId(), ojb.getApprovalId());
			}
			
			Map<String,String> cscList = new LinkedHashMap<String,String>();
			
			List<Gldeptm> cscListObj = deptDao.getCscByArea(orderObj.getAreaCode().trim());
			int cscCount = cscListObj.size() - 1;
			for (int i = 0; i <= cscCount; i++) {
				Gldeptm ojb = (Gldeptm) cscListObj.get(i);
				cscList.put(ojb.getDeptId(), ojb.getDeptNm());
			}
			
			Map<String,String> sinList = new LinkedHashMap<String,String>();
			
			List<PcbEquipment> sinListObj = equipDao.findEquiByAreaStatus(orderObj.getAreaCode().trim(),"2");
			int sinCount = sinListObj.size() - 1;
			for (int i = 0; i <= sinCount; i++) {
				PcbEquipment ojb = (PcbEquipment) sinListObj.get(i);
				sinList.put(ojb.getSinNo(), ojb.getSinNo());
			}
			
			model.setCscList(cscList);
			model.setSinList(sinList);
			model.setOrderList(orderList);
			model.setMeter(orderObj);
			model.setOrdercard(model.getMeter().getApprovalId());
			String testingNo = "";
			model.setResult(null);
						            mo = new ModelAndView("MeterTRNew", "model",model);
			
			
			return mo;

		}
		
		
		
		
		
		
		@RequestMapping(value = "/MeterTRSave", method = RequestMethod.POST)
		public ModelAndView MeterTRSave(HttpServletRequest request,@ModelAttribute("model") PivModel model,BindingResult bindingResult) throws Exception{
				ModelAndView mo = null;
			SausermMm userMm = null;
			//System.out.println("reason :"+ model.getMeter().getReason());
			String userName = (String) request.getSession().getAttribute("loggedUser");
			
		    String ordercardnumber = model.getOrdercard();
			System.out.println(ordercardnumber);
			ApprovalMm orderObj = approvalMm.findByID(model.getMeter().getApprovalId());
			
            Map<String,String> areaList = new LinkedHashMap<String,String>();
			
			String deptId = request.getSession().getAttribute("deptId").toString();
			
			String province1 = deptDao.getDD(deptId);
			Glcompm distDiv = glcompmDao.getDistDivision2(province1);
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
			int depLoop = deptTm.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				Gldeptm ojb = (Gldeptm) deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
			}
			model.setAreaList(areaList);

			System.out.println("AreaCode:"+orderObj.getAreaCode());
			Map<String,String> orderList = new LinkedHashMap<String,String>();
			
			List<ApprovalMm>  listOderCard =null;
			listOderCard = approvalMm.getPendingReqByES("EMTREQ", "12",deptId,userName);
	
			int orderCount = listOderCard.size() - 1;
			for (int i = 0; i <= orderCount; i++) {
				ApprovalMm ojb = (ApprovalMm) listOderCard.get(i);
				orderList.put(ojb.getApprovalId(), ojb.getApprovalId());
			}
			
			Map<String,String> cscList = new LinkedHashMap<String,String>();
			
			List<Gldeptm> cscListObj = deptDao.getCscByArea(orderObj.getAreaCode().trim());
			int cscCount = cscListObj.size() - 1;
			for (int i = 0; i <= cscCount; i++) {
				Gldeptm ojb = (Gldeptm) cscListObj.get(i);
				cscList.put(ojb.getDeptId(), ojb.getDeptNm());
			}
			
			Map<String,String> sinList = new LinkedHashMap<String,String>();
			
			List<PcbEquipment> sinListObj = equipDao.findEquiByAreaStatus(orderObj.getAreaCode().trim(),"2");
			int sinCount = sinListObj.size() - 1;
			for (int i = 0; i <= sinCount; i++) {
				PcbEquipment ojb = (PcbEquipment) sinListObj.get(i);
				sinList.put(ojb.getSinNo(), ojb.getSinNo());
			}
			
			model.setCscList(cscList);
			model.setSinList(sinList);
			model.setOrderList(orderList);
			model.setMeter(orderObj);
			model.setOrdercard(model.getMeter().getApprovalId());
			String testingNo = "";
			model.setResult(null);
				System.out.println("prefix 1 :" + model.getConType());
				String prefix= model.getConType();
				Date date = new Date();
				Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Colombo"));
				cal.setTime(date);
				int year = cal.get(Calendar.YEAR);
				int day = cal.get(Calendar.DAY_OF_MONTH);
				String prefixNew = prefix +"-"+year+"-";
				System.out.println("prefix 2:" + prefixNew);
				
				testingNo = testingDao.getNextTestId(prefixNew,model.getMeter().getApprovalId());
				System.out.println("testingNo 1:" + testingNo);
				
				testingNo = prefixNew +testingNo;
				System.out.println("testingNo 2:" + testingNo);
				
				MmsMetertestingPK pk = new MmsMetertestingPK();
				pk.setOrderCardId(model.getMeter().getApprovalId());
				pk.setTestingId(testingNo);
				MmsMetertesting test = new MmsMetertesting();
				test.setId(pk);
				testingDao.add(test);
				System.out.println("xxxxxxx :" + testingNo);
				
				model.setResult("Successfully Created! Meter Test Number : " +testingNo );


				
			
			
			mo = new ModelAndView("MeterTRNew", "model",model);
			
			
			return mo;

		}

		
		
		
		


		
		/*@RequestMapping(value = "/MeterTestingRequestEditS", method = RequestMethod.POST)
		public ModelAndView MeterTestingRequestEditS(HttpServletRequest request,@RequestParam("file") MultipartFile file,@ModelAttribute("model") PivModel model,BindingResult bindingResult) throws Exception{
			ModelAndView mo = null;
			SausermMm userMm = null;
			System.out.println("reason :"+ model.getMeter().getReason());
			
			
			String ordercardnumber = model.getOrdercard();
			System.out.println(ordercardnumber);
			ApprovalMm orderObj = approvalMm.findByID(model.getMeter().getApprovalId());
			
			//ApprovalMm appr = new ApprovalMm();
			String success = "The Meter activity request is successfully updated ";
			Map<String,String> areaList = new LinkedHashMap<String,String>();
			
			String deptId = request.getSession().getAttribute("deptId").toString();
			
			String province1 = deptDao.getDD(deptId);
			Glcompm distDiv = glcompmDao.getDistDivision2(province1);
			List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(distDiv.getCompId());
			int depLoop = deptTm.size() - 1;
			for (int i = 0; i <= depLoop; i++) {
				Gldeptm ojb = (Gldeptm) deptTm.get(i);
				areaList.put(ojb.getDeptId(), ojb.getDeptNm());
			}
			model.setAreaList(areaList);

			System.out.println("AreaCode:"+orderObj.getAreaCode());
			Map<String,String> orderList = new LinkedHashMap<String,String>();
			
			List<ApprovalMm>  listOderCard =null;
			listOderCard = approvalMm.getPendingReqNew("EMTREQ", "11",deptId);
	
			int orderCount = listOderCard.size() - 1;
			for (int i = 0; i <= orderCount; i++) {
				ApprovalMm ojb = (ApprovalMm) listOderCard.get(i);
				orderList.put(ojb.getApprovalId(), ojb.getApprovalId());
			}
			
			Map<String,String> cscList = new LinkedHashMap<String,String>();
			
			List<Gldeptm> cscListObj = deptDao.getCscByArea(orderObj.getAreaCode().trim());
			int cscCount = cscListObj.size() - 1;
			for (int i = 0; i <= cscCount; i++) {
				Gldeptm ojb = (Gldeptm) cscListObj.get(i);
				cscList.put(ojb.getDeptId(), ojb.getDeptNm());
			}
			
			Map<String,String> sinList = new LinkedHashMap<String,String>();
			
			List<PcbEquipment> sinListObj = equipDao.findEquiByAreaStatus(orderObj.getAreaCode().trim(),"2");
			int sinCount = sinListObj.size() - 1;
			for (int i = 0; i <= sinCount; i++) {
				PcbEquipment ojb = (PcbEquipment) sinListObj.get(i);
				sinList.put(ojb.getSinNo(), ojb.getSinNo());
			}
			
			model.setCscList(cscList);
			model.setSinList(sinList);
			model.setOrderList(orderList);
			
			//model.setMeter(orderObj);
	        model.setOrdercard(ordercardnumber);
			
			model.setSinnumber(orderObj.getFilename4());
			model.setAccountnumber(orderObj.getTotower());
			model.setAdditionalwork(orderObj.getReason());
			model.setOrder(orderObj.getReq1());
			model.setLocationsin(orderObj.getReq2());
			model.setLocationsin(orderObj.getFromto());
			model.setTariff(orderObj.getFilename2());
			model.setContact(orderObj.getFilename3());
			model.setDemand(orderObj.getFilename5());
			model.setCtratio(orderObj.getPermitNo());
			
			
			model.getMeter().setApprovalId(orderObj.getApprovalId());
			model.getMeter().setReason(orderObj.getReason());
			model.getMeter().setReq1(orderObj.getReq1());
			model.getMeter().setReq2(orderObj.getReq2());
			model.getMeter().setFromto(orderObj.getFromto());
			model.getMeter().setFilename2(orderObj.getFilename2());
			model.getMeter().setFilename3(orderObj.getFilename3());
			model.getMeter().setTotower(orderObj.getTotower());
			model.getMeter().setFilename4(orderObj.getFilename4());
			model.getMeter().setFilename5(orderObj.getFilename5());
			model.getMeter().setAreaCode(orderObj.getAreaCode());
			model.getMeter().setCsc(orderObj.getCsc());
			model.getMeter().setPermitNo(orderObj.getPermitNo());
			model.getMeter().setReferenceNo(orderObj.getReferenceNo());
			
			
			model.getMeter().setDeptId(deptId);
			model.getMeter().setPhmBranch(deptId);
			model.getMeter().setApprovalType(orderObj.getApprovalType());
			model.getMeter().setApprovedLevel(orderObj.getApprovedLevel());
			model.getMeter().setFromStatus(orderObj.getFromStatus());
			model.getMeter().setToStatus(orderObj.getToStatus());
			model.getMeter().setApprovedDate(orderObj.getApprovedDate());
			model.getMeter().setApprovedTime(orderObj.getApprovedTime());
			model.getMeter().setApprovedBy(orderObj.getApprovedBy());
			
			
			
			if(orderObj.getAreaCode() == null){
				orderObj.setAreaCode(model.getMeter().getAreaCode());

			}else{
				orderObj.setAreaCode(model.getMeter().getAreaCode());
				
				
				if(!orderObj.getAreaCode().equals(model.getMeter().getAreaCode())){
					orderObj.setAreaCode(model.getMeter().getAreaCode());
					
				}else{
					model.getMeter().getAreaCode()
				}
			}
			
			
			
			if(orderObj.getCsc() == null){
				orderObj.setCsc(model.getMeter().getCsc());

			}else{
				if(!orderObj.getCsc().equals(model.getMeter().getCsc())){
					orderObj.setCsc(model.getMeter().getCsc());
				}
			}

			System.out.println("reason :"+ model.getMeter().getReason());
			if(orderObj.getReason() == null){
				orderObj.setReason(model.getMeter().getReason());
			}else{
				if(!orderObj.getReason().equals(model.getMeter().getReason())){
					orderObj.setReason(model.getMeter().getReason());
				}
				
			}
			
			
			
			
			 * 
			orderObj.setReq1(model.getOrder());
			orderObj.setReq2(model.getLocationsin());
			model.setMessage(success);
			orderObj.setFromto(model.getLocationsin());
			orderObj.setFilename2(model.getTariff());
			orderObj.setFilename3(model.getContact());
			orderObj.setTotower(model.getAccountnumber());
			orderObj.setFilename4(model.getSinnumber());
			
			orderObj.setFilename5(model.getDemand());
			orderObj.setAreaCode(model.getArea());
			orderObj.setCsc(model.getCsc());
			orderObj.setPermitNo(model.getCtratio());
			
			model.setMeter(model.getMeter());
			
       try {
			//	approvalMm.updateApproval(orderObj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			mo = new ModelAndView("MeterTestingRequestEdit", "model",model);
			
			
			return mo;

		}
*/
	    

		public String generateReport(String type,String reportName,HashMap<String, Object> param,Map<String, Object> session,String REPORT_DIRECTORY,String EXPORT_REPORT_DIRECTORY,PivModel model,String areaName,String lineNames,String province,String emailId,File imgFile){

			String pdfPath = "";
			//String reportFileName ="Inspection_Request";
			Connection conn = null;
			
			String area = gldeptDao.getName(model.getArea());
			String csc = gldeptDao.getName(model.getCsc());
			System.out.println("Joboxxxxxxxxxxxxxxxxxxxxxxxxxxxx dclose : "+ csc + model.getArea());
			System.out.println("Joboxxxxxxxxxxxxxxxxxxxxxxxxxxxx dclose : "+ area + model.getCsc());

			try {
				
				try {
					HashMap<String, Object> hmParams = new HashMap<String, Object>();
					hmParams.put("@coordinating","'"+areaName+"'");
					hmParams.put("@province","'"+province+"'");
					hmParams.put("@RequestNo","'"+emailId+"'");
					hmParams.put("@nameaddress","'"+model.getLocationsin()+"'");
					hmParams.put("@erquirement","'"+model.getAdditionalwork()+"'");
					
					hmParams.put("@sinaccountnumber","'"+model.getSinnumber()+"'");
					
					hmParams.put("@tariff","'"+model.getTariff()+"'");
					
					hmParams.put("@contact","'"+model.getContact()+"'");
					
					hmParams.put("@order","'"+model.getOrder()+"'");
					hmParams.put("@demamd","'"+model.getDemand()+"'");
					hmParams.put("@ctration","'"+model.getCtratio()+"'");
					hmParams.put("@accountnumber","'"+model.getAccountnumber()+"'");
					hmParams.put("area","'"+area+"'");
					hmParams.put("csc","'"+csc+"'");
					
					
					hmParams.put("@preparedby","'"+model.getPreparedBy()+"'");
					
					hmParams.put("@checkedby","'"+model.getCheckedBy()+"'");
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

		
		@ExceptionHandler(NullPointerException.class)
		public String handleNullException(NullPointerException ex) {

		//ModelAndView model = new ModelAndView();
		//model.setViewName("MMS_Login");

		//model.addObject("errMsg", "this is null Exception.class");
		System.out.println("Exception occured3.........");
		//return model;
		return "MMS_Login";
		} 

		
		@RequestMapping(value = "/viewMeterRequest")
		public ModelAndView viewMeterRequest(HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String userRole = (String) request.getSession().getAttribute("loggedUserRole");
			//String userLevel = (String) request.getSession().getAttribute("userLevel");
			
			String deptId = (String) request.getSession().getAttribute("deptId");
			PivModel model = new PivModel();
			Map<String, String> saList = new LinkedHashMap<String, String>();
			
			
			List<Sauserm> esList = secDao.getAllUserByRptUser(deptId, "ES");
			
			int loopSa = esList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
				//System.out.println(i);
				Sauserm ojb = esList.get(i);
				//System.out.println(ojb.getUserId());
				saList.put(ojb.getUserId(), ojb.getUserNm());

			}
			List<ApprovalMm>  listApprovalUnread =null;
			if(userRole.trim().equals("ES")){
				
				listApprovalUnread = approvalMm.getPendingReqByES("EMTREQ", "12",deptId,userName);
				
			}else{
			    listApprovalUnread = approvalMm.getPendingReqNew("EMTREQ", "11",deptId);
			}		
				
			
					
			
			ModelAndView mo = new ModelAndView();
			model.setEsList(saList);
			model.setUnReadInspectionReq(listApprovalUnread);
			mo = new ModelAndView("Meter_View", "model", model);
			return mo;
		}
		
		
		
		
		@RequestMapping(value = "/viewMeterRequestAttended")
		public ModelAndView viewMeterRequestAttended(HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String userRole = (String) request.getSession().getAttribute("loggedUserRole");
			//String userLevel = (String) request.getSession().getAttribute("userLevel");
			
			String deptId = (String) request.getSession().getAttribute("deptId");
			PivModel model = new PivModel();
			Map<String, String> saList = new LinkedHashMap<String, String>();
			
			
			List<Sauserm> esList = secDao.getAllUserByRptUser(deptId, "ES");
			
			int loopSa = esList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
				//System.out.println(i);
				Sauserm ojb = esList.get(i);
				//System.out.println(ojb.getUserId());
				saList.put(ojb.getUserId(), ojb.getUserNm());

			}
			List<ApprovalMm>  listApprovalUnread =null;
			if(userRole.trim().equals("ES")){
				
				listApprovalUnread = approvalMm.getPendingReqByES("EMTREQ", "15",deptId,userName);
				
			}else{
			    listApprovalUnread = approvalMm.getPendingReqNew("EMTREQ", "11",deptId);
			}		
				
			
					
			
			ModelAndView mo = new ModelAndView();
			model.setEsList(saList);
			model.setUnReadInspectionReq(listApprovalUnread);
			mo = new ModelAndView("Meter_View_Attended", "model", model);
			return mo;
		}

		
		
		@RequestMapping(value = "/esDeallocation")
		public ModelAndView esDeallocation(HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String userRole = (String) request.getSession().getAttribute("loggedUserRole");
			//String userLevel = (String) request.getSession().getAttribute("userLevel");
			
			String deptId = (String) request.getSession().getAttribute("deptId");
			PivModel model = new PivModel();
			Map<String, String> saList = new LinkedHashMap<String, String>();
			
			
			List<Sauserm> esList = secDao.getAllUserByRptUser(deptId, "ES");
			
			int loopSa = esList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
				//System.out.println(i);
				Sauserm ojb = esList.get(i);
				//System.out.println(ojb.getUserId());
				saList.put(ojb.getUserId(), ojb.getUserNm());

			}
			List<ApprovalMm>  listApprovalUnread =null;
			//if(userRole.trim().equals("ES")){
				
				listApprovalUnread = approvalMm.getPendingReqNew("EMTREQ", "12",deptId);
				
			/*}else{
			    listApprovalUnread = approvalMm.getPendingReqNew("EMTREQ", "11",deptId);
			}		
			*/	
			
					
			
			ModelAndView mo = new ModelAndView();
			model.setEsList(saList);
			model.setUnReadInspectionReq(listApprovalUnread);
			mo = new ModelAndView("Meter_ViewESDeallocation", "model", model);
			return mo;
		}

		
		
		 @RequestMapping(value = "/getEsMeterAll",method = RequestMethod.GET, produces = "application/json")
		 public @ResponseBody List<ApprovalMm> getEsMeterAll(HttpServletRequest request,@RequestParam("es") String es,@RequestParam("status") String status){
			 String deptId = (String) request.getSession().getAttribute("deptId");
				
			 return approvalMm.getPendingReqByES("EMTREQ", status,deptId,es);
		 }
		
		@RequestMapping(value = "/viewMeterRequestAll")
		public ModelAndView viewMeterRequestAll(HttpServletRequest request) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String userRole = (String) request.getSession().getAttribute("loggedUserRole");
			//String userLevel = (String) request.getSession().getAttribute("userLevel");
			
			String deptId = (String) request.getSession().getAttribute("deptId");
			PivModel model = new PivModel();
			Map<String, String> saList = new LinkedHashMap<String, String>();
			
			
			List<Sauserm> esList = secDao.getAllUserByRptUser(deptId, "ES");
			
			int loopSa = esList.size() - 1;
			for (int i = 0; i <= loopSa; i++) {
				//System.out.println(i);
				Sauserm ojb = esList.get(i);
				//System.out.println(ojb.getUserId());
				saList.put(ojb.getUserId(), ojb.getUserNm());

			}
			List<ApprovalMm>  listApprovalUnread =null;
			listApprovalUnread = approvalMm.getAllReqForEMBranch("EMTREQ", deptId);
				
			
					
			
			ModelAndView mo = new ModelAndView();
			model.setEsList(saList);
			model.setUnReadInspectionReq(listApprovalUnread);
			mo = new ModelAndView("Meter_View_All", "model", model);
			return mo;
		}


		@RequestMapping(value = "/findSinNoByArea/{area}", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<PcbEquipment> findSinNoByArea(@PathVariable("area") String area) {
			System.out.println("area :" + area);
			return equipDao.findEquiByAreaStatus(area.trim(),"2");
			
			
			
		}
		
		@RequestMapping(value = "/findPCBModelBySinNo/{sinNo}", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody Object findPCBModelBySinNo(@PathVariable("sinNo") String sinNo) {
			return equipDao.findPCBModelBySinNo(sinNo.trim());
		}
		
		@RequestMapping(value = "/findPCBModelByMeterRequestId/{id}", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody Object findPCBModelByMeterRequestId(@PathVariable("id") String id) {
			ApprovalMm obj = approvalMm.findByID(id);
			if(obj != null){
				return equipDao.findPCBModelBySinNo(obj.getFilename4());
				
			}else{
				return null;
			}
				
			}
		
		//completionLine
		
		@RequestMapping(value = "/completionLine", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody Object completionLine(HttpServletRequest request,@RequestParam("lineid") String id,@RequestParam("cycle") String cycle,@RequestParam("complesion") String complesion,@RequestParam("remarks") String remarks,@RequestParam("area") String area) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			
			
			System.out.println("id :" + id);
			System.out.println("cycle :" + cycle);
			System.out.println("complesion :" + complesion);
			System.out.println("remarks :" + remarks);
			System.out.println("area :" + area);
			
			
			MmsAddline obj = lineDao.findById(new Long(id));
			System.out.println("obj :" + obj);
			
			if(obj != null){
				MmsCompletion line = new MmsCompletion();
				MmsCompletionPK linePk = new MmsCompletionPK();
				linePk.setLineid(new Long(id));
				linePk.setCycle(cycle);
				
				
				MmsCompletion objLine = comDao.findById(linePk);
				System.out.println("objLine :" + objLine);

				if(objLine != null){
					//line.setId(linePk);
					objLine.setId(linePk);
					objLine.setRemarks(remarks);
					objLine.setComplesion(complesion);
					objLine.setCode(obj.getCode());
					objLine.setLineName(obj.getLineName());
					objLine.setStatus(new BigDecimal("2"));
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
					
		    		objLine.setCompletedDate(date2);
		    		objLine.setCompletedTime(timeString);
		    		objLine.setValidateBy(userName);
		    		objLine.setArea(area);
					
					comDao.update(objLine);
					System.out.println("success :");

				}else{
					
					line.setId(linePk);
					line.setRemarks(remarks);
					line.setComplesion(complesion);
					line.setCode(obj.getCode());
					line.setLineName(obj.getLineName());
					line.setStatus(new BigDecimal("2"));
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
					
		    		line.setCompletedDate(date2);
		    		line.setCompletedTime(timeString);
					line.setValidateBy(userName);
					line.setArea(area);
					
					comDao.add(line);
					System.out.println("success :");

					
				}
				
				
				line.setId(linePk);
				line.setRemarks(remarks);
				line.setComplesion(complesion);
				line.setCode(obj.getCode());
				line.setLineName(obj.getLineName());
				line.setStatus(new BigDecimal("2"));
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
				
	    		line.setCompletedDate(date2);
	    		line.setCompletedTime(timeString);
				line.setValidateBy(userName);
				line.setArea(area);
				comDao.add(line);
				System.out.println("success :");
				
			}else{
				return null;
			}
			return null;	
		}
		
		
		@RequestMapping(value = "/completionEst", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody Object completionEst(HttpServletRequest request,@RequestParam("id") String id,@RequestParam("complesion") String complesion,@RequestParam("remarks") String remarks) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			
			
			System.out.println("id :" + id);
			System.out.println("complesion :" + complesion);
			System.out.println("remarks :" + remarks);
			
			
			MmsInspection obj = insDao.findByID(id);
			System.out.println("obj :" + obj);
			String eeEmail="";
			String eeTelNo="";
			
			String esEmail="";
			String esTelNo="";
			
			
			if(obj != null){
				
				
				SausermMm userMm = null;
				SausermMm userEs = null;
					
						try {
							userMm =secDao.getSausermMms(obj.getEe());
							userEs =secDao.getSausermMms(obj.getInspectionBy());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(userMm != null){
					 	if(userMm.getEmail() != null){
					 		eeEmail = userMm.getEmail();
					 		esEmail = userEs.getEmail();
					 		
					 	}
					 	if(userMm.getTelNo() != null){
					 		eeTelNo = userMm.getTelNo();
					 		esTelNo = userEs.getTelNo();
					 		
					 	}
					 	}
					
			
				
				
				
				
				obj.setRemarks(remarks);
				obj.setCompletion(complesion);
				obj.setComStatus("2");
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
					String cycle="";
					if(obj.getCycle() != null){
						cycle=obj.getCycle().substring(0, 3) +"-"+obj.getCycle().substring(4, 5);
					}
					
					
					if(obj.getType().equals("HOTINS")){
						content = "\n\nTower Hot line inspection in "+obj.getDescription()+" is completed.You can view that by login into  https://mms.ceb.lk .\n\n Thank You";
						subject ="HOTLINE INSPECTION COMPLETION OF "+obj.getDescription() + " " + subject_str;
						sms_content ="Tower Hot line inspection in "+obj.getDescription()+" is completed.You can view that by login into  https://mms.ceb.lk ";
						
					}else if(obj.getType().equals("HOTMNT")){
						content = "\n\nTower Hot line maintenance of "+cycle+" in "+obj.getDescription()+" is completed.You can view that by login into  https://mms.ceb.lk .\n\n Thank You";
						subject ="HOTLINE MAINTENANCE COMPLETION OF "+obj.getDescription() + " " + subject_str;
						sms_content ="Tower Hot line maintenance in "+obj.getDescription()+" is completed.You can view that by login into  https://mms.ceb.lk";
						
					}else if(obj.getType().equals("COLMNT")){
						content = "\n\nTower Cold line maintenance of "+cycle+" in "+obj.getDescription()+" is completed.You can view that by login into  https://mms.ceb.lk .\n\n Thank You";
						subject ="COLDLINE MAINTENANCE COMPLETION OF "+obj.getDescription() + " " + subject_str;
						sms_content ="Tower cold line maintenance in "+obj.getDescription()+" is completed.You can view that by login into  https://mms.ceb.lk";
						
					}else if(obj.getType().equals("COLCIV")){
						content = "\n\nTower Cold line civil maintenance of "+cycle+" in "+obj.getDescription()+" is completed.You can view that by login into  https://mms.ceb.lk .\n\n Thank You";
						subject ="COLDLINE CIVIL MAINTENANCE COMPLETION OF "+obj.getDescription() + " " + subject_str;
						sms_content ="Tower cold line civil maintenance in "+obj.getDescription()+" is completed.You can view that by login into  https://mms.ceb.lk";
						
					}else{
						content = "\n\nTower line maintenance of "+cycle+" in "+obj.getDescription()+" is completed.You can view that by login into  https://mms.ceb.lk .\n\n Thank You";
						subject ="MAINTENANCE COMPLETION OF "+obj.getDescription() + " " + subject_str;
						sms_content ="Tower line maintenance in "+obj.getDescription()+" is completed.You can view that by login into  https://mms.ceb.lk";
						
					}
					
					firstClouse ="Electrical Engineer";
					SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");

		    		String timeString = format2.format(newDate);
		    		System.out.println("finish 3 " );
					
		    		obj.setComDate(date2);
		    		
					insDao.update(obj);
					System.out.println("success :");
					
					
					ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
					MailMail mm = (MailMail) context.getBean("mailMail");
					String url="";
					String urlCE="";
					String urlEE="";
					String[] emailListEM = new String[1];
					emailListEM[0] =esEmail;
					//emailListEM[1] =esEmail;
					urlEE="http://smsgw.ceb/SMSPlatform.php?recipients=0718716913&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					
					url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					mm.sendMailTo(firstClouse, content,"gchampika28@gmail.com",subject);
					mm.sendMailTo(firstClouse, content,eeEmail,emailListEM,subject);
					
					Date date = new Date();
					RestTemplate restTemplate = new RestTemplate();
					try {
						restTemplate.getForObject(url, String.class);
						restTemplate.getForObject(urlEE, String.class);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						System.out.println("sendSMS 78"+ e1.getMessage() );

						e1.printStackTrace();
					}

			}				
				

			return null;	
		}
		
		@RequestMapping(value = "/sendNortificationForCompletion", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody Object sendNortificationForCompletion(HttpServletRequest request,@RequestParam("cycle") String cycle,@RequestParam("area") String area) {
			String userName = (String) request.getSession().getAttribute("loggedUser");
			
			
			System.out.println("cycle :" + cycle);
			System.out.println("area :" + area);
			String areaEmail=Util.searchEmail(area);
			String areaTelNo=Util.searchTelNo(area);
			
			String eeEmail="";
			String eeTelNo="";
			
			
				SausermMm userMm = null;
				SausermMm userEs = null;
					
						try {
							userMm =secDao.getSausermMms(userName);
							} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(userMm != null){
					 	if(userMm.getEmail() != null){
					 		eeEmail = userMm.getEmail();
					 		
					 	}
					 	if(userMm.getTelNo() != null){
					 		eeTelNo = userMm.getTelNo();
					 		
					 	}
					 	}
					
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
					
					
					double insulator = lineDao.getDefectiveInsulatorTower(area, cycle);
					double damageTower = lineDao.getDamageTower(area, cycle);
					
					if(cycle != null){
						cycle=cycle.substring(0, 4) +"-"+cycle.substring(4, 6);
					}
					System.out.println("finish xxxxxxxxxxxxxxx " + cycle);
					
					System.out.println("insulator "+ insulator );

					String areaName= deptDao.getName(area);
					
					
					content = "\n\nThe Tower line maintenance of "+cycle+" in "+ areaName.trim().toLowerCase()+" is completed.\n\nThe Insulators were replaced in  "+ insulator +" towers ."
								+ "\n\n The damages of conductor, earth conductor, and jumper conductor of "+damageTower+" towers were rectified.\n\nYou can view that by login into  https://mms.ceb.lk .\n\n Thank You";
					subject ="COMPLETION OF TOWER LINE MAINTENANCE IN "+ areaName + " " + subject_str;
					sms_content ="The Tower line maintenance of "+cycle+" in "+ areaName.trim().toLowerCase()+" is completed.The Insulators were replaced in "+ insulator +" towers."
								+ "The damages of conductor, earth conductor, and jumper conductor of "+damageTower+" towers was rectified.You can view that by login into  https://mms.ceb.lk .\n\n Thank You";
						
					
					firstClouse ="Electrical Engineer";
					SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");

		    		String timeString = format2.format(newDate);
		    		System.out.println("finish 3 " );
					ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
					MailMail mm = (MailMail) context.getBean("mailMail");
					String url="";
					String urlCE="";
					String urlEE="";
					String[] emailListEM = new String[1];
					//emailListEM[0] =Util.cephmcp;
					//emailListEM[1] =eeEmail;
					emailListEM[0] =Util.cephmcp;
					urlEE="http://smsgw.ceb/SMSPlatform.php?recipients="+eeTelNo+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					urlCE="http://smsgw.ceb/SMSPlatform.php?recipients="+Util.telcephmcp+"&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					
					url="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+sms_content+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
					mm.sendMailTo(firstClouse, content,"gchampika28@gmail.com",subject);
					mm.sendMailTo(firstClouse, content,eeEmail,subject);
					
					Date date = new Date();
					RestTemplate restTemplate = new RestTemplate();
					try {
						restTemplate.getForObject(url, String.class);
						restTemplate.getForObject(urlEE, String.class);
						//restTemplate.getForObject(urlCE, String.class);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						System.out.println("sendSMS 78"+ e1.getMessage() );

						e1.printStackTrace();
					}
              return null;
			}				
				

			/*return null;	
		}
*/

		
		@RequestMapping(value = "/getNextTestingId", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody String getNextTestingId(@RequestParam("prefix") String prefix,@RequestParam("order") String order) {
			System.out.println("prefix :" + prefix);
			Date date = new Date();
			Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Colombo"));
			cal.setTime(date);
			int year = cal.get(Calendar.YEAR);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			String testingNo ="";
			String prefixNew = prefix +"-"+year+"-";
			System.out.println("prefix :" + prefixNew);
			
			testingNo = testingDao.getNextTestId(prefixNew,order);
			System.out.println("testingNo :" + testingNo);
			
			String result = prefixNew +testingNo;
			System.out.println("prefix :" + result);
					
			return prefix;
			
			
		}
		
		
		/*@RequestMapping(value = "/getAllUser", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody String getAllUser(HttpServletRequest request) {
			System.out.println("prefix :" + prefix);
			return testingDao.getNextTestId(prefix,order);
			
			
			
		}
		*/
		
		

}
