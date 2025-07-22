package com.it.piv.mms.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.admin.domain.SausermMm;
import com.it.piv.admin.repo.SecurityDao;
import com.it.piv.issue.domain.PivModel;
import com.it.piv.mms.domain.Application;
import com.it.piv.mms.domain.ApplicationPK;
import com.it.piv.mms.domain.Customer;
import com.it.piv.mms.domain.Glcompm;
import com.it.piv.mms.domain.Gldeptm;
import com.it.piv.mms.domain.MmsAddmvpole;
import com.it.piv.mms.domain.MmsAddsupport;
import com.it.piv.mms.domain.MmsTowermaintenance;
import com.it.piv.mms.domain.MmsTowermaintenancePK;
import com.it.piv.mms.domain.MmsTxntowermaintenance;
import com.it.piv.mms.domain.MmsTxntowermaintenancePK;
import com.it.piv.mms.domain.MmsAddline;
import com.it.piv.mms.domain.MvmmsCycle;
import com.it.piv.mms.domain.PcbCondition;
import com.it.piv.mms.domain.PcbEquipment;
import com.it.piv.mms.domain.PcbLocation;
import com.it.piv.mms.domain.PcbModel;
import com.it.piv.mms.domain.PcbSample;
import com.it.piv.mms.domain.UploadFile;
import com.it.piv.mms.repo.CustomerDao;
import com.it.piv.mms.repo.FileUploadDAO;
import com.it.piv.mms.repo.MmsAddmvpoleDao;
import com.it.piv.mms.repo.MmsSupportDao;
import com.it.piv.mms.repo.MmsAddLineDao;
import com.it.piv.mms.repo.MmsTxntowermaintenanceDao;
import com.it.piv.mms.repo.MvmmsCycleDao;
import com.it.piv.mms.repo.PcbConditionDao;
import com.it.piv.mms.repo.PcbDivisionDao;
import com.it.piv.mms.repo.PcbEquipmentDao;
import com.it.piv.mms.repo.PcbLocationDao;
import com.it.piv.mms.repo.PcbSampleDao;
import com.it.piv.util.common.MailMail;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


@Controller
public class WebPageController {
	
	
	@Autowired
	private SecurityDao  secDao;
	

	@Autowired
	private FileUploadDAO fileUploadDao;
	
	 @Autowired
 		private MmsTxntowermaintenanceDao towerTxtMaintenance;
	 @Autowired
	 	private MmsSupportDao addSupportDao;
	 @Autowired
	 	private MmsAddLineDao addLineDao;

	 @Autowired
		private MvmmsCycleDao cycleDao;	
	 
	 @Autowired
		private PcbConditionDao addCondition;

		@Autowired
		private PcbLocationDao addLocation;

		@Autowired
		private PcbEquipmentDao addEquipment;

		@Autowired
		private PcbDivisionDao divisionDao;

		@Autowired
		private PcbSampleDao addSample;
		
		@Autowired
		private MmsSupportDao supDao;
		
		@Autowired
		private MmsAddmvpoleDao mvPoleDao;

	//private String fileLocation = "F://CEB/MV-MMS/Data";
	
	/**@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;

	}*/

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("AdminPage");

		return model;

	}

	//Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("LoginPage");

		return model;

	}
	
	@RequestMapping(value = "/WelcomeMMS", method = RequestMethod.GET)
	public ModelAndView WelcomeMMS() {

		ModelAndView model = new ModelAndView();
		model.setViewName("MMS_Login");

		return model;

	}
	
	
	@RequestMapping(value = "/WelcomeDMS", method = RequestMethod.GET)
	public ModelAndView WelcomeDMS() {

		ModelAndView model = new ModelAndView();
		model.setViewName("DMSNEW_Login");

		return model;

	}
	
	@RequestMapping(value = "/InterruptionView", method = RequestMethod.GET)
	public ModelAndView InterruptinView() {

		ModelAndView model = new ModelAndView();
		model.setViewName("InterruptionView");
		//model.addObject("id", id);
		return model;

	}


	
	@RequestMapping(value = "/WelcomeEM", method = RequestMethod.GET)
	public ModelAndView WelcomeEM() {

		ModelAndView model = new ModelAndView();
		model.setViewName("EM_Login");

		return model;

	}

	
	@RequestMapping(value = "/Test", method = RequestMethod.GET)
	public ModelAndView Test() {

		ModelAndView model = new ModelAndView();
		model.setViewName("Test");

		return model;

	}

	
	@RequestMapping(value = "/MMS_Map", method = RequestMethod.GET)
	public ModelAndView MMS_Map() {
		ModelAndView model = new ModelAndView();
		model.setViewName("MMS_Map");

		return model;

	}
	
	
	
	
	
	
	@RequestMapping(value = "/CustomerMMS", method = RequestMethod.GET)
	public ModelAndView CustomerMMS() {

		ModelAndView model = new ModelAndView();
		model.setViewName("CustomerTest");

		return model;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/mmsdashboardNew", method = RequestMethod.GET)
	public ModelAndView mmsdashboardNew(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
		/**if(approveLevel.equalsIgnoreCase("DEO")){
			model.setViewName("MMS_dashboard_DEO");
		}else if(approveLevel.equalsIgnoreCase("ES")){
			model.setViewName("MMS_dashboard_ES");

		}else if(approveLevel.equalsIgnoreCase("EE")){
			model.setViewName("MMS_dashboard_EE");

		}else if(approveLevel.equalsIgnoreCase("CE")){
			model.setViewName("MMS_dashboard_CE");

		}else if(approveLevel.equalsIgnoreCase("DGM")){
			model.setViewName("MMS_dashboard_DGM");

		}else{
			
		}*/
		//ModelAndView model = new ModelAndView();
		model.setViewName("MMS_dashboard_New");

		return model;

	}
	
	
	/**@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView dashboard(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		String approveLevel = request.getSession().getAttribute("loggedUserRole").toString();
		if(approveLevel.equalsIgnoreCase("DEO")){
			model.setViewName("MMS_dashboard_DEO");
		}else if(approveLevel.equalsIgnoreCase("ES")){
			model.setViewName("MMS_dashboard_ES");

		}else if(approveLevel.equalsIgnoreCase("EE")){
			model.setViewName("MMS_dashboard_EE");

		}else if(approveLevel.equalsIgnoreCase("CE")){
			model.setViewName("MMS_dashboard_CE");

		}else if(approveLevel.equalsIgnoreCase("DGM")){
			model.setViewName("MMS_dashboard_DGM");

		}else{
			
		}
		//ModelAndView model = new ModelAndView();
		//model.setViewName("MMS_dashboard");

		return model;

	}*/
	
	
	
	@RequestMapping(value = "/dashboardDEO", method = RequestMethod.GET)
	public ModelAndView dashboardDEO() {

		ModelAndView model = new ModelAndView();
		model.setViewName("MMS_dashboard_DEO1");

		return model;

	}
	
	@RequestMapping(value = "/dashboardES", method = RequestMethod.GET)
	public ModelAndView dashboardES() {

		ModelAndView model = new ModelAndView();
		model.setViewName("MMS_dashboard_ES");

		return model;

	}
	
	@RequestMapping(value = "/dashboardEE", method = RequestMethod.GET)
	public ModelAndView dashboardEE() {

		ModelAndView model = new ModelAndView();
		model.setViewName("MMS_dashboard_EE");

		return model;

	}
	
	@RequestMapping(value = "/dashboardMMS", method = RequestMethod.GET)
	public ModelAndView dashboardMMS() {

		ModelAndView model = new ModelAndView();
		model.setViewName("MMS_dashboard_New");

		return model;

	}
	
	@RequestMapping(value = "/Customer", method = RequestMethod.GET)
	public ModelAndView Customer() {

		//ModelAndView model = new ModelAndView();
		Customer cus= new Customer();
		return new ModelAndView("Customer","Customer",cus);

		

	}

	@RequestMapping(value = "/addCustomerPost", method = RequestMethod.POST)
    public ModelAndView addCustomerPost(@ModelAttribute("Customer") Customer customer,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception 
    {
	  System.out.println("Full name : "+ customer.getCustomername());
	  System.out.println("First  name : "+ customer.getCustomername());
	  System.out.println("Last  name : "+ customer.getCustomername());
	  System.out.println("Sub line: "+ customer.getCustomername());
	  System.out.println("Cost Center Number : "+ customer.getCustomername());
	  
		//return nu
		//String resultobj = customerdao.add(Customer);
       Customer cus = new  Customer();
      return new ModelAndView("Customer", "Customer",cus);
      
    }
    

	
	/**@RequestMapping(value = "/dashboardAE", method = RequestMethod.GET)
	public ModelAndView dashboardAE() {

		ModelAndView model = new ModelAndView();
		model.setViewName("MMS_dashboard_AE");

		return model;

	}*/
	
	
	@RequestMapping(value = "/dashboardCE", method = RequestMethod.GET)
	public ModelAndView dashboardCE() {

		ModelAndView model = new ModelAndView();
		model.setViewName("MMS_dashboard_CE");

		return model;

	}
	@RequestMapping(value = "/dashboardDGM", method = RequestMethod.GET)
	public ModelAndView dashboardDGM() {

		ModelAndView model = new ModelAndView();
		model.setViewName("MMS_dashboard_DGM");

		return model;

	}
	@RequestMapping(value = "/dashboardAGM", method = RequestMethod.GET)
	public ModelAndView dashboardAGM() {

		ModelAndView model = new ModelAndView();
		model.setViewName("MMS_dashboard_AGM");

		return model;

	}
	@RequestMapping(value = "/dashboardGM", method = RequestMethod.GET)
	public ModelAndView dashboardGM() {

		ModelAndView model = new ModelAndView();
		model.setViewName("MMS_dashboard_GM");

		return model;

	}
	
	
	@RequestMapping(value = "/viewProvinces", method = RequestMethod.GET)
	public ModelAndView viewProvinces() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewProvinces");

		return model;

	}
	
	@RequestMapping(value = "/viewCSC", method = RequestMethod.GET)
	public ModelAndView viewCSC() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewCSC");

		return model;

	}
	
	@RequestMapping(value = "/viewLinetypes", method = RequestMethod.GET)
	public ModelAndView viewLinetypes() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewLineTypes");

		return model;

	}
	
	@RequestMapping(value = "/viewSupporttypes", method = RequestMethod.GET)
	public ModelAndView viewSupporttype() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewSupportTypes");

		return model;

	}
	
	@RequestMapping(value = "/viewConTypes", method = RequestMethod.GET)
	public ModelAndView viewConTypes() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewConductorType");

		return model;

	}
	
	@RequestMapping(value = "/viewEarthConTypes", method = RequestMethod.GET)
	public ModelAndView viewEarthConTypes() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewEarthConType");

		return model;

	}
	
	@RequestMapping(value = "/viewInsulators", method = RequestMethod.GET)
	public ModelAndView viewInsulators() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewInsulator");

		return model;

	}
	
	@RequestMapping(value = "/viewTowerConfigs", method = RequestMethod.GET)
	public ModelAndView viewTowerConfigs() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewTowerConfiguration");

		return model;

	}
	
	@RequestMapping(value = "/viewTowerInsulators", method = RequestMethod.GET)
	public ModelAndView viewTowerInsulators() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewTowerInsulator");

		return model;

	}
	
	@RequestMapping(value = "/viewStatusTypes", method = RequestMethod.GET)
	public ModelAndView viewStatusTypes() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewStatusType");

		return model;

	}
	
	@RequestMapping(value = "/viewStatus", method = RequestMethod.GET)
	public ModelAndView viewStatus() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewStatus");

		return model;

	}
	
	@RequestMapping(value = "/viewSupport", method = RequestMethod.GET)
	public ModelAndView viewSupport() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewAndApproveSupport");

		return model;

	}
	
	
	@RequestMapping(value = "/viewLine", method = RequestMethod.GET)
	public ModelAndView viewLine() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewLines");

		return model;

	}
	
	@RequestMapping(value = "/editLine", method = RequestMethod.GET)
	public ModelAndView editLine() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewLinesEdit");

		return model;

	}
	
	@RequestMapping(value = "/viewTowerMaintenance", method = RequestMethod.GET)
	public ModelAndView viewTowerMaintenance() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewAndApproveTowerMaintenance");

		return model;

	}
	
	@RequestMapping(value = "/editTowerMaintenance", method = RequestMethod.GET)
	public ModelAndView editTowerMaintenance() {

		ModelAndView model = new ModelAndView();
		model.setViewName("ViewAndApproveTowerMaintenanceEdit");

		return model;

	}
	
	@RequestMapping(value = "/CreateMaintenanceEst", method = RequestMethod.GET)
	public ModelAndView CreateTowerMaintenance() {

		ModelAndView model = new ModelAndView();
		model.setViewName("CreateMaintenanceEtimate");

		return model;

	}
	
	@RequestMapping(value = "/viewReports", method = RequestMethod.GET)
	public ModelAndView viewReports() {

		ModelAndView model = new ModelAndView();
		model.setViewName("CreateReport");

		return model;

	}
	
	

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public ModelAndView showUploadForm(HttpServletRequest request) {
		//return "upload";
		//ModelAndView modelV = new ModelAndView();
		PivModel model = new PivModel();
		//model.setViewName("UploadTowerMaintenance","model",model);
		ModelAndView mm = new ModelAndView("UploadTowerMaintenance" ,"model",model);
		
		return mm;
		//return "UploadTowerMaintenance";
	}
	
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
         
        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload){
                 
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                
                UploadFile uploadFile = new UploadFile();
                uploadFile.setFileName(aFile.getOriginalFilename());
                uploadFile.setData(aFile.getBytes());
                System.out.println("Upload file: " + uploadFile);
                fileUploadDao.save(uploadFile);                
            }
        }
 
        return "Success";
    }
    
    
   
    
    private Application createApplicationObject ()throws NumberFormatException {
		
		ApplicationPK id=new ApplicationPK();
		//id.setApplicationId(getApplicationId());
		//id.setDeptId(getCostCenterNo());
		//Calendar calendar = Calendar.getInstance();
		//setSubmitDate(calendar.getTime());
		//setConfirmDate(null);
		/**setConfirmTime(null);
		setAllocatedBy(null);
		setAllocatedTo(null);
		setAllocatedDate(null);
		setAllocatedTime(null);
		setUpdUser(null);
		setUpdDate(null);
		setUpdTime(null);
		setPreparedBy(getSessionKey("userName"));
		setLoggedInUserId(getSessionKey("userName"));
		setAddUser(getLoggedInUserId());
		setAddDate(calendar.getTime());
		setAddTime(getFormat().FormatTime());
		Application application=new Application();
		log.info("3");
		application.setId(id);
		application.setApplicationNo(null);
		
		application.setApplicationType(getSessionKey("smcType"));
		application.setApplicationSubType(applicationSubType);
		if(getDuration() != null){
			if(getDuration().equalsIgnoreCase("") ){
				log.info("3333333333333");
				setDuration("0");
			}else{
				log.info("444");
				application.setDuration(new BigDecimal(getDuration()));
			}
			
		}
		
		application.setIsLoanApp(isLoanApp);
		application.setSubmitDate(getSubmitDate());
		application.setIdNo(getIdNo());
		application.setPreparedBy(getPreparedBy());
		application.setConfirmedBy(getConfirmedBy());
		application.setConfirmedDate(null);
		application.setConfirmedTime(null);
		application.setAllocatedBy(null);
		application.setAllocatedTo(null);
		application.setAllocatedDate(null);
		application.setAllocatedTime(null);
		application.setStatus(getStatus());
		application.setAddUser(getLoggedInUserId());
		application.setAddDate(calendar.getTime());
		application.setAddTime(getFormat().FormatTime());
		application.setUpdUser(null);
		application.setUpdDate(null);
		application.setUpdTime(null);
		application.setDescription (getDescription());*/
				
		return null;
		
	}
  //  @RequestMapping("/uploadExcelFile", method = RequestMethod.POST)
    
    
    private String fileLocation;
    
  /**  @PostMapping("/uploadExcelFile")
    public String uploadFile(Model model, MultipartFile file) throws IOException {
        InputStream in = file.getInputStream();
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        fileLocation = path.substring(0, path.length() - 1) + file.getOriginalFilename();
        FileOutputStream f = new FileOutputStream(fileLocation);
        int ch = 0;
        while ((ch = in.read()) != -1) {
            f.write(ch);
        }
        f.flush();
        f.close();
        model.addAttribute("message", "File: " + file.getOriginalFilename() 
          + " has been uploaded successfully!");
        return "excel";
    }*/
    
    
    
    
    /**
	 * Upload single file using Spring Controller
	 *//*
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file,@ModelAttribute("pivModel") PivModel pivModel) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				
	            
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				FileInputStream fileExcel = new FileInputStream(serverFile);
	            
			    XSSFWorkbook workbook = new XSSFWorkbook(fileExcel);
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            
	            MmsTowermaintenance obj = new MmsTowermaintenance();
	    		MmsTowermaintenancePK objPK = new MmsTowermaintenancePK();
	    		Map<Integer,String> mntHashMap = new LinkedHashMap<Integer,String>();
	    		MmsTowermaintenance objExisting = null;
	    		Iterator<Row> rowIterator = sheet.iterator();
	            rowIterator.next();
	            while(rowIterator.hasNext())
	            {
	                Row row = rowIterator.next();
	                //For each row, iterate through each columns
	                Iterator<Cell> cellIterator = row.cellIterator();
	                int i=0;
	                while(cellIterator.hasNext())
	                {
	                    
	                	Cell cell = cellIterator.next();
	                    //This will change all Cell Types to String
	                    cell.setCellType(Cell.CELL_TYPE_STRING);
	                    switch(cell.getCellType()) 
	                    {
	                        case Cell.CELL_TYPE_BOOLEAN:
	                            System.out.println("boolean===>>>"+cell.getBooleanCellValue() + "\t");
	                            break;
	                        case Cell.CELL_TYPE_NUMERIC:

	                            break;
	                        case Cell.CELL_TYPE_STRING:
	                        	
	                        	System.out.println("hh : " + cell.getStringCellValue());
	                        	mntHashMap.put(i, cell.getStringCellValue());
	                        	i++;
	                        *//**	String towerID = towerTxtMaintenance.getTowerIDByTowerNo(towerNo);
	            	    		System.out.println("towerID true or false : " + towerID.equalsIgnoreCase(""));
	            	    		if(towerID.equalsIgnoreCase("")){
	            	    			System.out.println("towerID : " + towerID);
	            	    			return "1";
	            	    		}
	            	    		
	            	    		System.out.println("towerID " + towerID);
	            	    		objPK.setVisitId(Long.parseLong(visitId));
	            	    		objPK.setTowerId(towerID);
	            	    		obj.setId(objPK);
	            	    		
	            	    		objExisting = towerTxtMaintenance.findByID(objPK);
	            	    		
	            	    		
	            	    		obj.setTowerNo(towerNo);
	            	    		obj.setDeptId("600.41");
	            	    		obj.setTappings(new BigDecimal(numberOfTappings));
	            	    		obj.setMissingParts(new BigDecimal(numberOfMissingParts));
	            	    		obj.setFlashOverSets(new BigDecimal(numberOfFlashOverSets));
	            	    		obj.setWayLeaving(spinnerLeavingStatus);
	            	    		obj.setBaseConcrete(spinnerBaseConcreteStatus);
	            	    		obj.setAntiClimbing(spinnerAntiClimbingStatus);
	            	    		obj.setConductorCondition(spinnerConductorCondition);
	            	    		obj.setJumperCondition(spinnerJumperCondition);
	            	    		obj.setEarthConductorCondition(spinnerEarthConductorCondition);
	            	    		obj.setMaintainaceAttention(spinnerMaintainanceAttention);
	            	    		//obj.set(spinnerMaintainanceAttention);
	            	    		if(objExisting == null){
	            	    			System.out.println("new");
	            	    			String resultobj = towerMaintenance.addTowerMaintananceData(obj);
	            	    		}
	            	    		else{
	            	    			System.out.println("update");
	            	    			String resultobj1 = towerMaintenance.update(obj);
	            	    		}*//*
	                        	
	                        	
	                        	
	                        	
	                        	
	                        	
	                        	
	                        	
	                        //   list.add(cell.getStringCellValue());

	                                                     break;
	                    }
	                    
	                    	
	                    
        	    		


	                }
	                System.out.println("towerNo " + mntHashMap.get(0));
	                String towerNo = mntHashMap.get(0);
	                String tapping = mntHashMap.get(1);
	                String missing_part = mntHashMap.get(2);
	                String flashOverSet = mntHashMap.get(3);
	                String mainDate = mntHashMap.get(4);
	                String wayLeaving = mntHashMap.get(5);
	                
	                
	                String towerID = addSupportDao.getTowerIDByTowerNo(towerNo);
	                System.out.println("getCycle " + pivModel.getCycle());
	                System.out.println("towerID " + towerID);
	                System.out.println("tapping " + tapping);
	                System.out.println("missing_part" + missing_part);
	                System.out.println("flashOverSet" + flashOverSet);
	                System.out.println("mainDate" + mainDate);
	                System.out.println("wayLeaving" + wayLeaving);
			        
	                
	                objPK.setVisitId(Long.parseLong(pivModel.getCycle()));
    	    		objPK.setTowerId(towerID);
    	    		obj.setTappings(new BigDecimal(tapping));
    	    		obj.setMissingParts(new BigDecimal(missing_part));
    	    		obj.setFlashOverSets(new BigDecimal(flashOverSet));
    	    		//obj.setMaintenanceDate(new BigDecimal(mainDate));
    	    		obj.setWayLeaving(wayLeaving);
    	    		
    	    	*//**	System.out.println("towerID true or false : " + towerID.equalsIgnoreCase(""));
    	    		if(towerID.equalsIgnoreCase("")){
    	    			System.out.println("towerID : " + towerID);
    	    			return "1";
    	    		}
    	    		
    	    		System.out.println("towerID " + towerID);
    	    		objPK.setVisitId(Long.parseLong(visitId));
    	    		objPK.setTowerId(towerID);
    	    		obj.setId(objPK);
    	    		
    	    		objExisting = towerTxtMaintenance.findByID(objPK);
    	    		
    	    		
    	    		obj.setTowerNo(towerNo);
    	    		obj.setDeptId("600.41");
    	    		obj.setTappings(new BigDecimal(numberOfTappings));
    	    		obj.setMissingParts(new BigDecimal(numberOfMissingParts));
    	    		obj.setFlashOverSets(new BigDecimal(numberOfFlashOverSets));
    	    		obj.setWayLeaving(spinnerLeavingStatus);
    	    		obj.setBaseConcrete(spinnerBaseConcreteStatus);
    	    		obj.setAntiClimbing(spinnerAntiClimbingStatus);
    	    		obj.setConductorCondition(spinnerConductorCondition);
    	    		obj.setJumperCondition(spinnerJumperCondition);
    	    		obj.setEarthConductorCondition(spinnerEarthConductorCondition);
    	    		obj.setMaintainaceAttention(spinnerMaintainanceAttention);
    	    		//obj.set(spinnerMaintainanceAttention);
    	    		if(objExisting == null){
    	    			System.out.println("new");
    	    			String resultobj = towerMaintenance.addTowerMaintananceData(obj);
    	    		}
    	    		else{
    	    			System.out.println("update");
    	    			String resultobj1 = towerMaintenance.update(obj);
    	    		}**//*
	                   
	             

	            }
				
				
	            fileExcel.close();
				System.out.println("Server File Location="
						+ serverFile.getAbsolutePath());

				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}*/
    
    

    
    /**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String uploadFilenewHandler(HttpServletRequest request,@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file,@ModelAttribute("pivModel") PivModel pivModel) {

		String deptId = request.getSession().getAttribute("deptId").toString();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				
	            
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				FileInputStream fileExcel = new FileInputStream(serverFile);
	            
			    XSSFWorkbook workbook = new XSSFWorkbook(fileExcel);
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            
	            List<MmsAddline> objLineList = new ArrayList<MmsAddline>();
	            MmsAddline obj = new MmsAddline();
	    		//MmsTowermaintenancePK objPK = new MmsTowermaintenancePK();
	    		Map<Integer,String> lineHashMap = new LinkedHashMap<Integer,String>();
	    		MmsAddline objExisting = new MmsAddline();
	    		Iterator<Row> rowIterator = sheet.iterator();
	    		//rowIterator.
	            rowIterator.next();
	            while(rowIterator.hasNext())
	            {
	                Row row = rowIterator.next();
	                //For each row, iterate through each columns
	                Iterator<Cell> cellIterator = row.cellIterator();
	                int i=0;
	                while(cellIterator.hasNext())
	                {
	                    
	                	
	                	String code ="";
	                	String nameline ="";
	                	String lineType ="";
	                	String length ="";
	                	String area="";
	                	String noofpoles="";
	                	String nooftowers="";
	                	String comdate="";	                	
	                	
	                	
	                	
	                	Cell cell = cellIterator.next();
	                	
	                	//i++;
	                	
	                	//This will change all Cell Types to String
	                    cell.setCellType(Cell.CELL_TYPE_STRING);
	                    switch(cell.getCellType()) 
	                    {
	                        case Cell.CELL_TYPE_BOOLEAN:
	                            System.out.println("boolean===>>>"+cell.getBooleanCellValue() + "\t");
	                            break;
	                        case Cell.CELL_TYPE_NUMERIC:

	                            break;
	                        case Cell.CELL_TYPE_STRING:
	                        	
	                        	if(i==0){
	    	                		//code =  cell.getStringCellValue();
	    	                		//objExisting.setCode(code);
	    	                    	//System.out.println("hh : " + cell.getStringCellValue() + "code : " + code + " objE :" +objExisting.getCode() );
	    		                    
	    	                	}else if(i==1){
	    	                		code =  cell.getStringCellValue();
	    	                		objExisting.setCode(code);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "code : " + code + " objC :" +objExisting.getCode() );
	    		                    
	    	                	}
	    	                	else if(i==2){
	    	                		nameline =  cell.getStringCellValue();
	    	                		objExisting.setLineName(nameline);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "name : " + nameline + " objN :" +objExisting.getName() );
	    		                    
	    	                	}
	    	                	
	    	                	else if(i==3){
	    	                		lineType =  cell.getStringCellValue();
	    	                		objExisting.setLineType(lineType);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "lineType : " + lineType + " objNd :" +objExisting.getLineType() );
	    		                    
	    	                	}
	    	                	else if(i==4){
	    	                		length =  cell.getStringCellValue();
	    	                		objExisting.setLength(new BigDecimal(length));
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "length : " + length + " objNc :" +objExisting.getLength() );
	    		                    
	    	                	}
	    	                	else if(i==5){
	    	                		area =  cell.getStringCellValue();
	    	                		objExisting.setArea(area);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "area : " + area + " objNd :" +objExisting.getArea() );
	    		                    
	    	                	}
	    	                	else if(i==6){
	    	                		noofpoles =  cell.getStringCellValue();
	    	                		objExisting.setNoofpoles(new BigDecimal(noofpoles));
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "noofpoles : " + noofpoles + " objNd :" +objExisting.getNoofpoles() );
	    		                    
	    	                	}
	    	                	else if(i==7){
	    	                		nooftowers =  cell.getStringCellValue();
	    	                		objExisting.setNooftowers(new BigDecimal(nooftowers));
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "nooftowers : " + nooftowers + " objNd :" +objExisting.getNooftowers() );
	    		                    
	    	                	}
	    	                	else if(i==8){
	    	                		comdate =  cell.getStringCellValue();
	    	                		DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
	    	                		java.util.Date date = format.parse(comdate);

	    	                		objExisting.setComdate(date);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "comdate : " + comdate + " objNd :" +objExisting.getComdate() );
	    		                    
	    	                	}else{
	    	                		
	    	                	}
	                        	System.out.println("hh : " + cell.getStringCellValue());
	                        	lineHashMap.put(i, cell.getStringCellValue());
	                        	System.out.println("else end no : " + i);
	    	                	
	                        	i++;
	                        	System.out.println("else end no after : " + i);
	    	                	   
	                                                     break;
	                    }//end switch
	                    //addLineDao.addLine(objExisting);
		                
	                 }//end while cell iterator
	                //objLineList.add(objExisting);
	                objExisting.setPhmBranch(deptId);
	                objExisting.setStatus(new BigDecimal("2"));
	                addLineDao.addLine(objExisting);
	                objExisting = new MmsAddline();
	                System.out.println("save obj");
	               // try{
	                //}catch(Exception e){
	                	//System.out.println("end save obj : error "+ e);
		                
	                //}
	                System.out.println("end save obj");
	                
	            }
				fileExcel.close();
				System.out.println("Server File Location="
						+ serverFile.getAbsolutePath());

				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}
	
	
	
	
	@RequestMapping(value = "/uploadMvPoles", method = RequestMethod.POST)
	public @ResponseBody String uploadMvPoles(HttpServletRequest request,@RequestParam("file") MultipartFile file,@ModelAttribute("pivModel") PivModel pivModel) {
		String name ="";
		String deptId = request.getSession().getAttribute("deptId").toString();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				name = file.getOriginalFilename();
				
				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				FileInputStream fileExcel = new FileInputStream(serverFile);
	            
			    XSSFWorkbook workbook = new XSSFWorkbook(fileExcel);
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            
	            List<MmsAddmvpole> objMvPole = new ArrayList<MmsAddmvpole>();
	            MmsAddmvpole obj = new MmsAddmvpole();
	    		//MmsTowermaintenancePK objPK = new MmsTowermaintenancePK();
	    		//Map<Integer,String> lineHashMap = new LinkedHashMap<Integer,String>();
	            MmsAddmvpole objExisting = new MmsAddmvpole();
	            
	    		Iterator<Row> rowIterator = sheet.iterator();
	    		//rowIterator.
	            rowIterator.next();
	            while(rowIterator.hasNext())
	            {
	                Row row = rowIterator.next();
	                //For each row, iterate through each columns
	                Iterator<Cell> cellIterator = row.cellIterator();
	                int i=0;
	                while(cellIterator.hasNext())
	                {
	                    
	                	
	                	/*String poleName ="";
	                	String poleNo ="";
	                	String gps_longitude ="";
	                	String gps_latitude ="";
	                	String area="";
	                	String csc="";
	                	String poleHeight="";
	                	String poleType="";
	                	String workingLoad="";
	                	String status="";
	                	String grid="";
	                	String description="";
	                	String tessellate="";
	                	String StrutBad = "";
	                	String LVcct4Type ="";
	                	String Stayrequired ="";
	                	*/
	                	String poleHeight="";
	                	String poleType="";
	                	String workingLoad="";
	                	
	                	String gps_longitude ="";
	                    String gps_latitude ="";
	                    String gid="";
	                    String Name="";
	                    String description="";
	                    String tessellate="";
	                    String Strut_Bad="";
	                    String LVcct_4Type="";
	                    String Stayrequired="";
	                    String LVcct_1Type="";
	                    String LVcct_3Name="";
	                    String Polenumber="";
	                    String kV33Conductorcct_3="";
	                    String Strutrequired="";
	                    String LVCrackInsulators="";
	                    String Cct_43PService="";
	                    String Cct_13PService="";
	                    String Cct_21PService="";
	                    String HorizontalEarth="";
	                    String LVcct_1Name="";
	                    String SegmentID="";
	                    String Cct_11PService="";
	                    String ShakelPole="";
	                    String Cct_3_LVContype="";
	                    String PoleAlignment="";
	                    String Cct_5_LVContype="";
	                    String LVcct_5Name="";
	                    String Stay_Bad="";
	                    String HVBadInsulators="";
	                    String Stay="";
	                    String EarthDownconductor="";
	                    String NoofLVcct="";
	                    String kV33Conductorcct_2="";
	                    String kV33Conductorcct_1="";
	                    String PoleType="";
	                    String HVJumpTBCrimped="";
	                    String PoleCondition="";
	                    String PoleHeight="";
	                    String HVLVCombineRun="";
	                    String kV11Conductorcct_2="";
	                    String Cct_31PService="";
	                    String WorkingLoad="";
	                       String lvcct_5Type="";
	                    String kv33conductorcct_1="";
	                    String cct_4_lvcontype="";
	                    String cct_23pService="";
	                    String cct_33pService="";
	                    String cct_2_lvConType="";
	                    String lvspanTBCrimped="";
	                    String lvserviceTBCrimp="";
	                    String Cct_1_LVContype="";
	                    String HVBadInsulators2="";
	                    String Cct_41PService="";
	                    String kV11Conductorcct_3="";
	                    String StreetLight="";
	                    String LVJumpTBCrimped="";
	                    String FeederName="";
	                    String LVcct_2Type="";
	                    String LVcct_2Name="";
	                    String HVspanTBCrimped="";
	                    String LVcct_3Type="";
	                    String FeederNo="";
	                    String Noof33kVCircuits="";
	                    String Noof11kVCircuits="";
	                    String LVConductortype="";
	                    String LVcct_4Name="";
	                    String CrossArm="";
	                    String Strutavailable="";
	                    String Strut_Strp="";

	                	
	                	
	                	Cell cell = cellIterator.next();
	                	
	                	//i++;
	                	
	                	//This will change all Cell Types to String
	                    cell.setCellType(Cell.CELL_TYPE_STRING);
	                    switch(cell.getCellType()) 
	                    {
	                        case Cell.CELL_TYPE_BOOLEAN:
	                            System.out.println("boolean===>>>"+cell.getBooleanCellValue() + "\t");
	                            break;
	                        case Cell.CELL_TYPE_NUMERIC:

	                            break;
	                        case Cell.CELL_TYPE_STRING:
	                        	
	                        	 	if(i==0){
	                                 gps_latitude  =  cell.getStringCellValue();
	                                 obj.setGpsLongitude(new BigDecimal(gps_latitude));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "gps_latitude : " + gps_latitude);
	                                 /*if(gps_latitude.equalsIgnoreCase("")){
					    	            	break;
                                     }
	                                 */}
	                                
	                                 else if(i==1){
	                                 gps_longitude  =  cell.getStringCellValue();
	                                 obj.setGpsLatitude(new BigDecimal(gps_longitude));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "gps_longitude : " + gps_longitude);
	                                    
	                                 }
	                                 else if(i==2){
	                                 gid =  cell.getStringCellValue();
	                                 //obj.setGid(gid);
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "gid : " + gid);
	                                    
	                                 }
	                                 else if(i==3){
	                                 Name=  cell.getStringCellValue();
	                                 obj.setPoleName(Name);
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Name : " + Name);
	                                    
	                                 }
	                            
	                                 else if(i==4){
	                                 description =  cell.getStringCellValue();
	                                 //obj.setDescription(new BigDecimal(description));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "description : " + description);
	                                 }
	                                        
	                                 else if(i==5){
	                                 tessellate =  cell.getStringCellValue();
	                                 // obj.setTessellate(new BigDecimal(tessellate));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "tessellate : " + tessellate);
	                                 }
	                                 else if(i==6){
	                                 Strut_Bad =  cell.getStringCellValue();
	                                 //obj.setStrutBad(new BigDecimal(Strut_Bad));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Strut_Bad : " + Strut_Bad);
	                                 }
	                                 else if(i==7){
	                                 LVcct_4Type =  cell.getStringCellValue();
	                                 //obj.set);cct4Type(new BigDecimal(LVcct_4Type));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVcct_4Type : " + LVcct_4Type);
	                                 }
	                                 else if(i==8){
	                                 Stayrequired =  cell.getStringCellValue();
	                                 //obj.setStayRequired(new BigDecimal(Stayrequired));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Stayrequired : " + Stayrequired);
	                                 }
	                                 else if(i==9){
	                                 LVcct_1Type =  cell.getStringCellValue();
	                                 //obj.setLVcct1Type(new BigDecimal(LVcct_1Type));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVcct_1Type : " + LVcct_1Type);
	                                 }
	                                 else if(i==10){
	                                 LVcct_3Name =  cell.getStringCellValue();
	                                 //obj.setLVcct3Name(new BigDecimal(LVcct_3Name));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVcct_3Name: " + LVcct_3Name);
	                                 }
	                                 else if(i==11){
	                                 Polenumber =  cell.getStringCellValue();
	                                 obj.setPoleNo(Polenumber);
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Polenumber: " + Polenumber);
	                                 }
	                                 else if(i==12){
	                                 kV33Conductorcct_3 =  cell.getStringCellValue();
	                                 //obj.setKv33ConductorCct3(new BigDecimal(kV33Conductorcct_3));
	                                 //System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "33kVConductorcct_3 : " + 33kVConductorcct_3);
	                                 }
	                                 else if(i==13){
	                                 Strutrequired =  cell.getStringCellValue();
	                                 // obj.setStrutRequired(new BigDecimal(Strutrequired));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Strutrequired : " + Strutrequired);
	                                 }
	                                 else if(i==14){
	                                 LVCrackInsulators =  cell.getStringCellValue();
	                                 //obj.setLVCrackInsulators(new BigDecimal(LVCrackInsulators));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVCrackInsulators : " + LVCrackInsulators);
	                                 }
	                                 else if(i==15){
	                                 Cct_43PService =  cell.getStringCellValue();
	                                 //obj.setCct43PService (new BigDecimal(Cct_43PService));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Cct_43PService : " + Cct_43PService);
	                                 }      
	                                 else if(i==16){
	                                 Cct_13PService =  cell.getStringCellValue();
	                                 obj.setKv33Cct1Ph3(new BigDecimal(Cct_13PService));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Cct_13PService : " + Cct_13PService);
	                                 }    
	                                 else if(i==17){
	                                 Cct_21PService =  cell.getStringCellValue();
	                                 //obj.setKv33Cct2Ph1(new BigDecimal( Cct_21PService));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + " Cct_21PService : " +  Cct_21PService);
	                                 }
	                                 else if(i==18){
	                                 HorizontalEarth =  cell.getStringCellValue();
	                                 //obj.setLineEnd(new BigDecimal(HorizontalEarth));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "HorizontalEarth : " + HorizontalEarth);
	                                 }
	                                 else if(i==19){
	                                 LVcct_1Name =  cell.getStringCellValue();
	                                 //obj.setLVcct1Name(new BigDecimal(LVcct_1Name));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVcct_1Name : " + LVcct_1Name);
	                                 }
	                                 else if(i==20){
	                                 SegmentID=  cell.getStringCellValue();
	                                 //obj.setSegmentID(new BigDecimal(SegmentID));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "SegmentID : " + SegmentID);
	                                 }
	                                 else if(i==21){
	                                 Cct_11PService =  cell.getStringCellValue();
	                                 //obj.setCct11PService(new BigDecimal(Cct_11PService));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Cct_11PService : " + Cct_11PService);
	                                 }
	                                 else if(i==22){
	                                 ShakelPole =  cell.getStringCellValue();
	                                 //obj.setPinShackle(new BigDecimal(ShakelPole));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "ShakelPole : " + ShakelPole);
	                                 }
	                                 else if(i==23){
	                                 Cct_3_LVContype =  cell.getStringCellValue();
	                                 //obj.setCct3LVContype(new BigDecimal(Cct_3_LVContype));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Cct_3_LVContype : " + Cct_3_LVContype);
	                                 }
	                                 else if(i==24){
	                                 PoleAlignment =  cell.getStringCellValue();
	                                 //obj.setPoleAlignment(new BigDecimal(PoleAlignment));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "PoleAlignment : " + PoleAlignment);
	                                 }
	                                 else if(i==25){
	                                 Cct_5_LVContype =  cell.getStringCellValue();
	                                 //obj.setCct5LVContype(new BigDecimal(Cct_5_LVContype));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Cct_5_LVContype : " + Cct_5_LVContype);
	                                 }
	                                 else if(i==26){
	                                 LVcct_5Name =  cell.getStringCellValue();
	                                 //obj.setLVcct5Name(new BigDecimal(LVcct_5Name));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVcct_5Name : " + LVcct_5Name);
	                                 }
	                                 else if(i==27){
	                                 Stay_Bad =  cell.getStringCellValue();
	                                 //obj.setStayBad(new BigDecimal(Stay_Bad));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Stay_Bad : " + Stay_Bad);
	                                 }
	                                 else if(i==28){
	                                 HVBadInsulators =  cell.getStringCellValue();
	                                 //obj.setHVBadInsulators(new BigDecimal(HVBadInsulators));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "HVBadInsulators : " + HVBadInsulators);
	                                 }
	                                 else if(i==29){
	                                 Stay =  cell.getStringCellValue();
	                                 //obj.setStay(new BigDecimal(Stay));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Stay : " + Stay);
	                                 }
	                                 else if(i==30){
	                                 EarthDownconductor =  cell.getStringCellValue();
	                                 obj.setEarthConductor(EarthDownconductor);
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "EarthDownconductor : " + EarthDownconductor);
	                                 }
	                                 else if(i==31){
	                                 NoofLVcct =  cell.getStringCellValue();
	                                 System.out.println("NoofLVcct : "+NoofLVcct);
	                                 try {
										obj.setNoOfLvCct(new BigDecimal(NoofLVcct));
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "NoofLVcct : " + NoofLVcct);
	                                 }
	                                 else if(i==32){
	                                	 kV33Conductorcct_2 =  cell.getStringCellValue();
	                                	 System.out.println("kV33Conductorcct_2 : "+ kV33Conductorcct_2);
	                                	 if(kV33Conductorcct_2.equalsIgnoreCase("TLD")){
	                                		 kV33Conductorcct_2 = "1";
										 }else if(kV33Conductorcct_2.equalsIgnoreCase("Racoon")){
											 kV33Conductorcct_2 = "2";
										 }else if(kV33Conductorcct_2.equalsIgnoreCase("ELM")){
											 kV33Conductorcct_2 = "3";
										 }else if(kV33Conductorcct_2.equalsIgnoreCase("Tiger")){
											 kV33Conductorcct_2 = "4";
										 }else if(kV33Conductorcct_2.equalsIgnoreCase("Dog")){
											 kV33Conductorcct_2 = "5";
										 }else if(kV33Conductorcct_2.equalsIgnoreCase("Lynx")){
											 kV33Conductorcct_2 = "6";
										 }else if(kV33Conductorcct_2.equalsIgnoreCase("COPPER")){
											 kV33Conductorcct_2 = "7";
										 }else if(kV33Conductorcct_2.equalsIgnoreCase("cooper")){
											 kV33Conductorcct_2 = "7";
										 }else if(kV33Conductorcct_2.equalsIgnoreCase("cooperl")){
											 kV33Conductorcct_2 = "7";
										 }else if(kV33Conductorcct_2.equalsIgnoreCase("Catmion coper")){
											 kV33Conductorcct_2 = "8";
										 }else if(kV33Conductorcct_2.equalsIgnoreCase("Coyote")){
											 kV33Conductorcct_2 = "9";
										 }else if(kV33Conductorcct_2.equalsIgnoreCase("Weesal")){
											 kV33Conductorcct_2 = "10";
										 }else{
											 kV33Conductorcct_2 = "0";
										 }
										
	                                	 
	                                	 
	                                 obj.setKv33ConductorCct2(new BigDecimal(kV33Conductorcct_2));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "33kVConductorcct_2: " +kV33Conductorcct_2);
	                                 }
	                                 else if(i==33){
	                                 kV33Conductorcct_1 =  cell.getStringCellValue();
	                                 
	                                 
                                	 if(kV33Conductorcct_1.equalsIgnoreCase("TLD")){
                                		 kV33Conductorcct_1 = "1";
									 }else if(kV33Conductorcct_1.equalsIgnoreCase("Racoon")){
										 kV33Conductorcct_1 = "2";
									 }else if(kV33Conductorcct_1.equalsIgnoreCase("ELM")){
										 kV33Conductorcct_1 = "3";
									 }else if(kV33Conductorcct_1.equalsIgnoreCase("Tiger")){
										 kV33Conductorcct_1 = "4";
									 }else if(kV33Conductorcct_1.equalsIgnoreCase("Dog")){
										 kV33Conductorcct_1 = "5";
									 }else if(kV33Conductorcct_1.equalsIgnoreCase("Lynx")){
										 kV33Conductorcct_1 = "6";
									 }else if(kV33Conductorcct_1.equalsIgnoreCase("COPPER")){
										 kV33Conductorcct_1 = "7";
									 }else if(kV33Conductorcct_1.equalsIgnoreCase("cooper")){
										 kV33Conductorcct_1 = "7";
									 }else if(kV33Conductorcct_1.equalsIgnoreCase("cooperl")){
										 kV33Conductorcct_1 = "7";
									 }else if(kV33Conductorcct_1.equalsIgnoreCase("Catmion coper")){
										 kV33Conductorcct_1 = "8";
									 }else if(kV33Conductorcct_1.equalsIgnoreCase("Coyote")){
										 kV33Conductorcct_1 = "9";
									 }else if(kV33Conductorcct_1.equalsIgnoreCase("Weesal")){
										 kV33Conductorcct_1 = "10";
									 }else{
										 kV33Conductorcct_1 = "0";
									 }
									
                                	
	                                 obj.setKv33ConductorCct1(new BigDecimal(kV33Conductorcct_1));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "33kVConductorcct_1 : " + kV33Conductorcct_1);
	                                 }
	                                 else if(i==34){
	                                 BigDecimal poleTypeTy = new BigDecimal("0");
	                                 poleType =  cell.getStringCellValue();
	                                 if(poleType.equalsIgnoreCase("PS")){
	                                 poleTypeTy = new BigDecimal("7");
	                                 }else if(poleType.equalsIgnoreCase("Tubular")){
	                                 poleTypeTy = new BigDecimal("4");
	                                 }else if(poleType.equalsIgnoreCase("RC")){
	                                 poleTypeTy = new BigDecimal("6");
	                                 }else if(poleType.equalsIgnoreCase("Wood")){
	                                 poleTypeTy = new BigDecimal("1");
	                                 }else{
	                                 poleTypeTy = new BigDecimal("8");

	                                 }
	                                 obj.setPoleType(poleTypeTy);
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "poleTypeTy : " + poleTypeTy);
	                                 }
	                                 else if(i==35){
	                                 HVJumpTBCrimped =  cell.getStringCellValue();
	                                 //obj.setHVJumpTBCrimped(new BigDecimal(HVJumpTBCrimped));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "HVJumpTBCrimped : " + HVJumpTBCrimped);
	                                 }
	                                 else if(i==36){
	                                 PoleCondition =  cell.getStringCellValue();
	                                 //obj.setpPoleCondition(new BigDecimal(PoleCondition));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "PoleCondition : " + PoleCondition);
	                                 }
	                                 else if(i==37){
	                                 poleHeight =  cell.getStringCellValue();
	                                 BigDecimal poleH = new BigDecimal("0");
	                                 if(poleHeight.equalsIgnoreCase("9m")){
	                                 poleH = new BigDecimal("1");
	                                 }else if(poleHeight.equalsIgnoreCase("10m")){
	                                 poleH = new BigDecimal("2");
	                                 }else if(poleHeight.equalsIgnoreCase("11m")){
	                                 poleH = new BigDecimal("3");
	                                 }else if(poleHeight.equalsIgnoreCase("13m")){
	                                 poleH = new BigDecimal("4");
	                                 }else{
	                                 poleH = new BigDecimal("0");
	                                 }
	                                 obj.setPoleHeight(poleH);
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "poleH : " + poleH);
	                                 }
	                                 else if(i==38){
	                                 HVLVCombineRun =  cell.getStringCellValue();
	                                 BigDecimal HVLVCombineRunBig = new BigDecimal("0");
	                                 if(HVLVCombineRun.equalsIgnoreCase("No")){
	                                	 HVLVCombineRunBig = new BigDecimal("1");
	                                 }else if(poleHeight.equalsIgnoreCase("Yes")){
	                                	 HVLVCombineRunBig = new BigDecimal("2");
	                                 }else{
	                                	 
	                                 }
	                                 
	                                 obj.setHvLvCombineRun(HVLVCombineRunBig);
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "HVLVCombineRun : " + HVLVCombineRun);
	                                 }
	                                 else if(i==39){
	                                 kV11Conductorcct_2 =  cell.getStringCellValue();
	                                 if(kV11Conductorcct_2.equalsIgnoreCase("TLD")){
	                                	 kV11Conductorcct_2 = "1";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("Racoon")){
										 kV11Conductorcct_2 = "2";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("ELM")){
										 kV11Conductorcct_2 = "3";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("Tiger")){
										 kV11Conductorcct_2 = "4";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("Dog")){
										 kV11Conductorcct_2 = "5";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("Lynx")){
										 kV11Conductorcct_2 = "6";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("COPPER")){
										 kV11Conductorcct_2 = "7";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("cooper")){
										 kV11Conductorcct_2 = "7";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("cooperl")){
										 kV11Conductorcct_2 = "7";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("Catmion coper")){
										 kV11Conductorcct_2 = "8";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("Coyote")){
										 kV11Conductorcct_2 = "9";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("Weesal")){
										 kV11Conductorcct_2 = "10";
									 }else{
										 kV11Conductorcct_2 = "0";
									 }
									
	                                 
	                                 obj.setKv11ConductorCct2(new BigDecimal(kV11Conductorcct_2));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "11kVConductorcct_2 : " + kV11Conductorcct_2);
	                                 }
	                                 else if(i==40){
	                                 Cct_31PService =  cell.getStringCellValue();
	                                 obj.setKv33Cct3Ph1(new BigDecimal(Cct_31PService));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Cct_31PService: " + Cct_31PService);
	                                 }
	                                 else if(i==41){
	                                 workingLoad =  cell.getStringCellValue();
		    	                     BigDecimal poleWeight = new BigDecimal("0");
			    	                 workingLoad =  cell.getStringCellValue();
			    	                	if(workingLoad.equalsIgnoreCase("300 kg")){
			    	                			poleWeight = new BigDecimal("6");
			    	                		}else if(workingLoad.equalsIgnoreCase("1200 kg")){
			    	                			poleWeight = new BigDecimal("5");
			    	                		}else if(workingLoad.equalsIgnoreCase("225 kg")){
			    	                			poleWeight = new BigDecimal("1");
			    	                		}else if(workingLoad.equalsIgnoreCase("500 kg")){
			    	                			poleWeight = new BigDecimal("3");
			    	                		}else if(workingLoad.equalsIgnoreCase("850 kg")){
			    	                			poleWeight = new BigDecimal("4");
			    	                		}else if(workingLoad.equalsIgnoreCase("350 kg")){
			    	                			poleWeight = new BigDecimal("2");
			    	                		}else{
			    	                			poleWeight = new BigDecimal("0");

			    	                		}
			    	                		obj.setWorkingLoad(poleWeight);
			    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "poleWeight : " + poleWeight);
                                     }
	                                 else if(i==42){
	                                 //LVcct_5Type =  cell.getStringCellValue();
	                                 //obj.setLvConductorType(lvConductorType);cct5Type(new BigDecimal( LVcct_5Type));
	                                 //System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + " LVcct_5Type : " +  LVcct_5Type);
	                                 }
	                                 else if(i==43){
	                                 kV11Conductorcct_2 =  cell.getStringCellValue();
	                                 
	                                 if(kV11Conductorcct_2.equalsIgnoreCase("TLD")){
	                                	 kV11Conductorcct_2 = "1";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("Racoon")){
										 kV11Conductorcct_2 = "2";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("ELM")){
										 kV11Conductorcct_2 = "3";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("Tiger")){
										 kV11Conductorcct_2 = "4";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("Dog")){
										 kV11Conductorcct_2 = "5";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("Lynx")){
										 kV11Conductorcct_2 = "6";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("COPPER")){
										 kV11Conductorcct_2 = "7";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("cooper")){
										 kV11Conductorcct_2 = "7";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("cooperl")){
										 kV11Conductorcct_2 = "7";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("Catmion coper")){
										 kV11Conductorcct_2 = "8";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("Coyote")){
										 kV11Conductorcct_2 = "9";
									 }else if(kV11Conductorcct_2.equalsIgnoreCase("Weesal")){
										 kV11Conductorcct_2 = "10";
									 }else{
										 kV11Conductorcct_2 = "0";
									 }
									
	                                 //obj.setKv11ConductorCct2(new BigDecimal(kV11Conductorcct_2));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "11kVConductorcct_2 : " + kV11Conductorcct_2);
	                                 }
	                                 else if(i==44){
	                                 //Cct_4_lvcontype =  cell.getStringCellValue();
	                                 //obj.set Cct4lvcontype(new BigDecimal( Cct_4_lvcontype));
	                                 //System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + " Cct_4_lvcontype : " +  Cct_4_lvcontype);
	                                 }
	                                 else if(i==45){
	                                 //Cct_23pService =  cell.getStringCellValue();
	                                 //obj.setKv33Cct2Ph3(new BigDecimal(Cct_23pService));
	                                 //System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Cct_23pService : " + Cct_23pService);
	                                 }
	                                 else if(i==46){
	                                 //Cct_33pService =  cell.getStringCellValue();
	                                 //obj.setCct33pService(new BigDecimal(Cct_33pService));
	                                 //System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Cct_33pService : " + Cct_33pService);
	                                 }
	                                 else if(i==47){
	                                 //Cct_2_lvConType =  cell.getStringCellValue();
	                                 //obj.setCct2lvConType(new BigDecimal(Cct_2_lvConType));
	                                 //System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Cct_2_lvConType2 : " + Cct_2_lvConType);
	                                 }
	                                 else if(i==48){
	                                 //LVspanTBCrimped =  cell.getStringCellValue();
	                                 //obj.LVSpanTBCrimped(new BigDecimal(LVspanTBCrimped));
	                                 //System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVspanTBCrimped : " + LVspanTBCrimped);
	                                 }
	                                 else if(i==49){
                                     //LVserviceTBCrimp =  cell.getStringCellValue();
	                                 //obj.LVServiceTBCrimp(new BigDecimal( LVserviceTBCrimp));
	                                 //System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + " LVserviceTBCrimp : " +  LVserviceTBCrimp);
	                                 }
	                                 else if(i==50){
	                                 Cct_1_LVContype =  cell.getStringCellValue();
	                                 //obj.setCct1LVContype(new BigDecimal(Cct_1_LVContype));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Cct_1_LVContype: " + Cct_1_LVContype);
	                                 }
	                                 else if(i==51){
	                                 HVBadInsulators2 =  cell.getStringCellValue();
	                                 //obj.setHVBadInsulators2(new BigDecimal(HVBadInsulators2));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "HVBadInsulators2 : " + HVBadInsulators2);
	                                 }
	                                 else if(i==52){
	                                 Cct_41PService =  cell.getStringCellValue();
	                                 //obj.setCct41PService(new BigDecimal(Cct_41PService));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Cct_41PService : " + Cct_41PService);
	                                 }
	                                 else if(i==53){
	                                 kV11Conductorcct_3 =  cell.getStringCellValue();
	                                 
	                                 if(kV11Conductorcct_3.equalsIgnoreCase("TLD")){
	                                	 kV11Conductorcct_3 = "1";
									 }else if(kV11Conductorcct_3.equalsIgnoreCase("Racoon")){
										 kV11Conductorcct_3 = "2";
									 }else if(kV11Conductorcct_3.equalsIgnoreCase("ELM")){
										 kV11Conductorcct_3 = "3";
									 }else if(kV11Conductorcct_3.equalsIgnoreCase("Tiger")){
										 kV11Conductorcct_3 = "4";
									 }else if(kV11Conductorcct_3.equalsIgnoreCase("Dog")){
										 kV11Conductorcct_3 = "5";
									 }else if(kV11Conductorcct_3.equalsIgnoreCase("Lynx")){
										 kV11Conductorcct_3 = "6";
									 }else if(kV11Conductorcct_3.equalsIgnoreCase("COPPER")){
										 kV11Conductorcct_3 = "7";
									 }else if(kV11Conductorcct_3.equalsIgnoreCase("cooper")){
										 kV11Conductorcct_3 = "7";
									 }else if(kV11Conductorcct_3.equalsIgnoreCase("cooperl")){
										 kV11Conductorcct_3 = "7";
									 }else if(kV11Conductorcct_3.equalsIgnoreCase("Catmion coper")){
										 kV11Conductorcct_3 = "8";
									 }else if(kV11Conductorcct_3.equalsIgnoreCase("Coyote")){
										 kV11Conductorcct_3 = "9";
									 }else if(kV11Conductorcct_3.equalsIgnoreCase("Weesal")){
										 kV11Conductorcct_3 = "10";
									 }else{
										 kV11Conductorcct_3 = "0";
									 }
							
	                                 //obj.setKv11ConductorCct3(new BigDecimal(kV11Conductorcct_3));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "11kVConductorcct_3 : " + kV11Conductorcct_3);
	                                 }
	                                 else if(i==54){
	                                 StreetLight =  cell.getStringCellValue();
	                                 obj.setStreetLight(new BigDecimal(StreetLight));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "StreetLight: " + StreetLight);
	                                 }
	                                 else if(i==55){
	                                 LVJumpTBCrimped =  cell.getStringCellValue();
	                                 //obj.setLVJumpTBCrimped(new BigDecimal(LVJumpTBCrimped));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVJumpTBCrimped : " + LVJumpTBCrimped);
	                                 }
	                                 else if(i==56){
	                                 FeederName =  cell.getStringCellValue();
	                                 obj.setFeederNo(FeederName);
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "FeederName: " + FeederName);
	                                 }
	                                 else if(i==57){
	                                 LVcct_2Type =  cell.getStringCellValue();
	                                 //obj.setLVcct2Type(new BigDecimal(LVcct_2Type));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVcct_2Type : " + LVcct_2Type);
	                                 }
	                                 else if(i==58){
	                                 LVcct_2Name =  cell.getStringCellValue();
	                                 //obj.setLVcct2Name(new BigDecimal(LVcct_2Name));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVcct_2Name: " + LVcct_2Name);
	                                 }
	                                 else if(i==59){
	                                 //HVspanTBCrimped=  cell.getStringCellValue();
	                                 //obj.setHVspanTBCrimped(new BigDecimal(HVspanTBCrimped));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "HVspanTBCrimped : " + HVspanTBCrimped);
	                                 }
	                                 else if(i==60){
	                                 LVcct_3Type =  cell.getStringCellValue();
	                                 //obj.setLVcct3Type(new BigDecimal(LVcct_3Type));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVcct_3Type: " + LVcct_3Type);
	                                 }
	                                 else if(i==61){
	                                 FeederNo=  cell.getStringCellValue();
	                                 obj.setFeederno(FeederNo);
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "FeederNo : " + FeederNo);
	                                 }
	                                 else if(i==62){
	                                 Noof33kVCircuits =  cell.getStringCellValue();
	                                 obj.setNoOf33Kvcircuits(new BigDecimal(Noof33kVCircuits));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Noof33kVCircuits : " +Noof33kVCircuits);
	                                 }
	                                 else if(i==63){
	                                 Noof11kVCircuits =  cell.getStringCellValue();
	                                 obj.setNoOf11Kvcircuits(new BigDecimal(Noof11kVCircuits));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Noof11kVCircuits : " + Noof11kVCircuits);
	                                 }
	                                 else if(i==64){
	                                 LVConductortype =  cell.getStringCellValue();
	                                 
	                                 if(LVConductortype.equalsIgnoreCase("TLD")){
	                                	 LVConductortype = "1";
									 }else if(LVConductortype.equalsIgnoreCase("Racoon")){
										 LVConductortype = "2";
									 }else if(LVConductortype.equalsIgnoreCase("ELM")){
										 LVConductortype = "3";
									 }else if(LVConductortype.equalsIgnoreCase("Tiger")){
										 LVConductortype = "4";
									 }else if(LVConductortype.equalsIgnoreCase("Dog")){
										 LVConductortype = "5";
									 }else if(LVConductortype.equalsIgnoreCase("Lynx")){
										 LVConductortype = "6";
									 }else if(LVConductortype.equalsIgnoreCase("COPPER")){
										 LVConductortype = "7";
									 }else if(LVConductortype.equalsIgnoreCase("cooper")){
										 LVConductortype = "7";
									 }else if(LVConductortype.equalsIgnoreCase("cooperl")){
										 LVConductortype = "7";
									 }else if(LVConductortype.equalsIgnoreCase("Catmion coper")){
										 LVConductortype = "8";
									 }else if(LVConductortype.equalsIgnoreCase("Coyote")){
										 LVConductortype = "9";
									 }else if(LVConductortype.equalsIgnoreCase("Weesal")){
										 LVConductortype = "10";
									 }else{
										 LVConductortype = "0";
									 }
							
	                                 
	                                 obj.setLvConductorType(new BigDecimal(LVConductortype));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVConductortype : " + LVConductortype);
	                                 }
	                                 else if(i==65){
	                                 //LVcct_4Name =  cell.getStringCellValue();
	                                 //obj.setLVcct4Name(new BigDecimal(LVcct_4Name));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVcct_4Name : " + LVcct_4Name);
	                                 }
	                                 else if(i==66){
	                                 CrossArm =  cell.getStringCellValue();
	                                 if(CrossArm.equalsIgnoreCase("Good")){
	                                	 CrossArm = "1";
									 }else{
										 CrossArm = "0";
									 }
	                                 
	                                 
	                                 obj.setCrossArm(new BigDecimal( CrossArm));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + " CrossArm : " + CrossArm);
	                                 }
	                                 else if(i==67){
	                                 //Strutavailable =  cell.getStringCellValue();
	                                 //obj.setStrutAvailable(new BigDecimal(Strutavailable));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Strutavailable : " + Strutavailable);
	                                 }
	                                 else if(i==68){
	                                 Strut_Strp =  cell.getStringCellValue();
	                                 if(Strut_Strp.equalsIgnoreCase("Good")){
	                                	 Strut_Strp = "1";
									 }else{
										 Strut_Strp = "0";
									 }
	                                
	                                 
	                                 
	                                // obj.setStrutStrp(new BigDecimal(Strut_Strp));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Strut_Strp : " + Strut_Strp);
	                                 }
	                                 else{
	                                
	                                 }

	                        	
	                        	
	                        	
	                        	
	                        	
	                        	
	                        	/*if(i==0){
	                        		gps_longitude  =  cell.getStringCellValue();
	    	                		obj.setGpsLongitude(new BigDecimal(gps_longitude));
	    	                    	System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "gps_longitude : " + gps_longitude);
	    		                    
	                        		
	    	                	}else if(i==1){
	    	                		
	    	                		gps_latitude  =  cell.getStringCellValue();
	    	                		obj.setGpsLatitude(new BigDecimal(gps_latitude));
	    	                    	System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "gps_latitude : " + gps_latitude);
	    		                    
	    	                		poleNo  =  cell.getStringCellValue();
	    	                		obj.setPoleNo(poleNo);
	    	                    	System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "poleNo : " + poleNo );
	    		                    
	    	                	}
	    	                	else if(i==2){
	    	                		grid = cell.getStringCellValue();
	    	                		
	    	                	}
	    	                	
	    	                	else if(i==3){
	    	                		poleName =  cell.getStringCellValue();
	    	                		obj.setPoleName(poleName);
	    	                    	System.out.println("hh : " + cell.getStringCellValue() + " pole name : " + poleName );
	    		                    
	    	                	}
	    	                	else if(i==4){
	    	                		
	    	                		description = cell.getStringCellValue();
	    	                		//obj.setD
	    	                		area =  cell.getStringCellValue();
	    	                		obj.setArea(area);
	    	                    	System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "area : " + area );
	    		                    
	    	                	}
	    	                	else if(i==5){
	    	                		tessellate =  cell.getStringCellValue();
	    	                		//obj.setT
	    	                		csc =  cell.getStringCellValue();
	    	                		obj.setCsc(csc);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "csc : " + csc);
	    		                    
	    	                	}
	    	                	else if(i==6){
	    	                		StrutBad =  cell.getStringCellValue();
	    	                		obj.setStrut(new BigDecimal(StrutBad));
	    	                		
	    	                		poleHeight =  cell.getStringCellValue();
	    	                		BigDecimal poleH = new BigDecimal("0");
	    	                		if(poleHeight.equalsIgnoreCase("9m")){
	    	                			poleH = new BigDecimal("1");
	    	                		}else if(poleHeight.equalsIgnoreCase("10m")){
	    	                			poleH = new BigDecimal("2");
	    	                		}else if(poleHeight.equalsIgnoreCase("11m")){
	    	                			poleH = new BigDecimal("3");
	    	                		}else if(poleHeight.equalsIgnoreCase("13m")){
	    	                			poleH = new BigDecimal("4");
	    	                		}else{
	    	                			poleH = new BigDecimal("0");
	    	                		}
	    	                		obj.setPoleHeight(poleH);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "poleH : " + poleH);
	    		                    
	    	                	}
	    	                	else if(i==7){
	    	                		LVcct4Type = cell.getStringCellValue();
	    	                		//obj.set
	    	                		BigDecimal poleTypeTy = new BigDecimal("0");
	    	                		poleType =  cell.getStringCellValue();
	    	                		if(poleType.equalsIgnoreCase("PS")){
	    	                			poleTypeTy = new BigDecimal("7");
	    	                		}else if(poleType.equalsIgnoreCase("Tubular")){
	    	                			poleTypeTy = new BigDecimal("4");
	    	                		}else if(poleType.equalsIgnoreCase("RC")){
	    	                			poleTypeTy = new BigDecimal("6");
	    	                		}else if(poleType.equalsIgnoreCase("Wood")){
	    	                			poleTypeTy = new BigDecimal("1");
	    	                		}else{
	    	                			poleTypeTy = new BigDecimal("8");

	    	                		}
	    	                		obj.setPoleType(poleTypeTy);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "poleTypeTy : " + poleTypeTy);
	    		                    
	    	                	}
	    	                	else if(i==8){
	    	                		Stayrequired =  cell.getStringCellValue();
	    	                		//obj.setS
	    	                			    		                    
	    	                	}else if(i==9){
	    	                            workingLoad =  cell.getStringCellValue();
	    	                            BigDecimal poleWeight = new BigDecimal("0");
		    	                		workingLoad =  cell.getStringCellValue();
		    	                		if(workingLoad.equalsIgnoreCase("300 kg")){
		    	                			poleWeight = new BigDecimal("6");
		    	                		}else if(workingLoad.equalsIgnoreCase("1200 kg")){
		    	                			poleWeight = new BigDecimal("5");
		    	                		}else if(workingLoad.equalsIgnoreCase("225 kg")){
		    	                			poleWeight = new BigDecimal("1");
		    	                		}else if(workingLoad.equalsIgnoreCase("500 kg")){
		    	                			poleWeight = new BigDecimal("3");
		    	                		}else if(workingLoad.equalsIgnoreCase("850 kg")){
		    	                			poleWeight = new BigDecimal("4");
		    	                		}else if(workingLoad.equalsIgnoreCase("350 kg")){
		    	                			poleWeight = new BigDecimal("2");
		    	                		}else{
		    	                			poleWeight = new BigDecimal("0");

		    	                		}
		    	                		obj.setWorkingLoad(poleWeight);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "poleWeight : " + poleWeight);
                               }else if(i==10){
	    	                             status =  cell.getStringCellValue();
	    	                             obj.setStatus(new BigDecimal(status));
	    	                             System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "status : " + status);
	    	                        
	    	                                            
	    	                                         }
	    	                            
	    	                            else if(i==11){
	    	                             gid =  cell.getStringCellValue();
	    	                        obj.setgid(new BigDecimal(gid));
	    	                        System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "gid : " + gid);
	    	                            }
	    	                            
	    	                            else if(i==12){
	    	                             description =  cell.getStringCellValue();
	    	                        obj.setdescription(new BigDecimal(description));
	    	                        System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "description : " + description);
	    	                            }
	    	                            else if(i==13){
	    	                             tessellate =  cell.getStringCellValue();
	    	                        obj.settessellate(new BigDecimal(tessellate));
	    	                        System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "tessellate : " + tessellate);
	    	                            }
	    	                            
	    	                            else if(i==14){
	    	                             Strut_Bad =  cell.getStringCellValue();
	    	                        obj.setStrut_Bad(new BigDecimal(Strut_Bad));
	    	                        System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Strut_Bad : " + Strut_Bad);
	    	                            }
	    	                            
	    	                            else if(i==15){
	    	                             LVcct_4Type =  cell.getStringCellValue();
	    	                        obj.setLVcct_4Type(new BigDecimal(LVcct_4Type));
	    	                        System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVcct_4Type : " + LVcct_4Type);
	    	                            }
	    	                            
	    	                            else if(i==16){
	    	                             LVcct_4Type =  cell.getStringCellValue();
	    	                        obj.setLVcct_4Type(new BigDecimal(LVcct_4Type));
	    	                        System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVcct_4Type : " + LVcct_4Type);
	    	                            }
	    	                            else if(i==17){
	    	                             Stayrequired =  cell.getStringCellValue();
	    	                        obj.setStayrequired(new BigDecimal(Stayrequired));
	    	                        System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Stayrequired : " + Stayrequired);
	    	                            }
	    	                            
	    	                            else if(i==18){
	    	                             LVcct_1Type =  cell.getStringCellValue();
	    	                        obj.setLVcct_1Type(new BigDecimal(LVcct_1Type));
	    	                        System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVcct_1Type : " + LVcct_1Type);
	    	                            }
	    	                            else if(i==19){
	    	                             LVcct_3Name =  cell.getStringCellValue();
	    	                        obj.setLVcct_3Name(new BigDecimal(LVcct_3Name));
	    	                        System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVcct_3Name: " + LVcct_3Name);
	    	                            }
	    	                            else if(i==20){
	    	                             33kVConductorcct_3 =  cell.getStringCellValue();
	    	                        obj.set33kVConductorcct_3(new BigDecimal(33kVConductorcct_3));
	    	                        System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "33kVConductorcct_3 : " + 33kVConductorcct_3);
	    	                            }
	    	                            else if(i==21){
	    	                             Strutrequired =  cell.getStringCellValue();
	    	                        obj.setStrutrequired(new BigDecimal(Strutrequired));
	    	                        System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Strutrequired : " + Strutrequired);
	    	                            }
	    	                            else if(i==22){
	    	                             LVCrackInsulators =  cell.getStringCellValue();
	    	                        obj.setLVCrackInsulators(new BigDecimal(LVCrackInsulators));
	    	                        System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "LVCrackInsulators : " + LVCrackInsulators);
	    	                            }
	    	                             else if(i==23){
	    	                             Cct_43PServiCct_43PServicece =  cell.getStringCellValue();
	    	                        obj.setgid(new BigDecimal(Cct_43PService));
	    	                        System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Cct_43PService : " + Cct_43PService);
	    	                            }      
	    	                             else if(i==24){
	    	                             Cct_13PService =  cell.getStringCellValue();
	    	                        obj.setCct_13PService(new BigDecimal(Cct_13PService));
	    	                        System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Cct_13PService : " + Cct_13PService);
	    	                            }                
	    	                             else if(i==25){
	    	                             Cct_21PService =  cell.getStringCellValue();
	    	                        obj.setCct_21PService(new BigDecimal(Cct_21PService));
	    	                        System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Cct_21PService : " +Cct_21PService );
	    	                            }  else{
	    	                            }  
*/
	    	                          

	                        	System.out.println("hh : " + cell.getStringCellValue());
	                        	//lineHashMap.put(i, cell.getStringCellValue());
	                        	System.out.println("else end no : " + i);
	    	                	
	                        	i++;
	                        	System.out.println("else end no after : " + i);
	    	                	   
	                                                     break;
	                    }//end switch
	                    //addLineDao.addLine(objExisting);
	                    
	                 }//end while cell iterator
	                //objLineList.add(objExisting);
	                obj.setStatus(new BigDecimal("2"));
	                mvPoleDao.addPole(obj);
	                obj = new MmsAddmvpole();
	                System.out.println("save obj");
	               // try{
	                //}catch(Exception e){
	                	//System.out.println("end save obj : error "+ e);
		                
	                //}
	                System.out.println("end save obj");
	                
	            }
				fileExcel.close();
				System.out.println("Server File Location="
						+ serverFile.getAbsolutePath());

				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}

	
	
	
	
	
	
	@RequestMapping(value = "/uploadMvPolesNew", method = RequestMethod.POST)
	public @ResponseBody String uploadMvPolesNew(HttpServletRequest request,@RequestParam("file") MultipartFile file,@ModelAttribute("pivModel") PivModel pivModel) {
		String name ="";
		String deptId = request.getSession().getAttribute("deptId").toString();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				name = file.getOriginalFilename();
				
				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				FileInputStream fileExcel = new FileInputStream(serverFile);
	            
			    XSSFWorkbook workbook = new XSSFWorkbook(fileExcel);
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            
	            List<MmsAddmvpole> objMvPole = new ArrayList<MmsAddmvpole>();
	            MmsAddmvpole obj = new MmsAddmvpole();
	    		//MmsTowermaintenancePK objPK = new MmsTowermaintenancePK();
	    		//Map<Integer,String> lineHashMap = new LinkedHashMap<Integer,String>();
	            MmsAddmvpole objExisting = new MmsAddmvpole();
	            
	    		Iterator<Row> rowIterator = sheet.iterator();
	    		//rowIterator.
	            rowIterator.next();
	            while(rowIterator.hasNext())
	            {
	                Row row = rowIterator.next();
	                //For each row, iterate through each columns
	                Iterator<Cell> cellIterator = row.cellIterator();
	                int i=0;
	                while(cellIterator.hasNext())
	                {
	                    
	                	
	                	String poleName ="";
	                	String poleNo ="";
	                	String gps_longitude ="";
	                	String gps_latitude ="";
	                	String area="";
	                	String csc="";
	                	String poleHeight="";
	                	String poleType="";
	                	String workingLoad="";
	                	String status="";
	                	String grid="";
	                	String description="";
	                	String tessellate="";
	                	String StrutBad = "";
	                	String LVcct4Type ="";
	                	String Stayrequired ="";
	                	
	                		
	                	
	                	          	
	                	
	                	
	                	
	                	Cell cell = cellIterator.next();
	                	
	                	//i++;
	                	
	                	//This will change all Cell Types to String
	                    cell.setCellType(Cell.CELL_TYPE_STRING);
	                    switch(cell.getCellType()) 
	                    {
	                        case Cell.CELL_TYPE_BOOLEAN:
	                            System.out.println("boolean===>>>"+cell.getBooleanCellValue() + "\t");
	                            break;
	                        case Cell.CELL_TYPE_NUMERIC:

	                            break;
	                        case Cell.CELL_TYPE_STRING:
	                        	
	                        		 if(i==0){
	                                 poleNo  =  cell.getStringCellValue();
	                                 obj.setPoleNo(poleNo);
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "poleNo : " + gps_latitude);
	                                 }
	                                
	                                 else if(i==1){
	                                 gps_latitude  =  cell.getStringCellValue();
	                                 obj.setGpsLatitude(new BigDecimal(gps_latitude));
	                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "gps_latitude : " + gps_latitude);
	                                    
	                                 }else if(i==2){
		                             gps_longitude  =  cell.getStringCellValue();
		                             obj.setGpsLongitude(new BigDecimal(gps_longitude));
		                             System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "gps_longitude : " + gps_longitude);
		                                    
		                             }else if(i==3){
			                         area  =  cell.getStringCellValue();
			                         obj.setArea(area);
			                         System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "area : " + area);
			                                    
			                         }
		                             else if(i==4){
		                                 BigDecimal poleTypeTy = new BigDecimal("0");
		                                 poleType =  cell.getStringCellValue();
		                                 if(poleType.equalsIgnoreCase("PS")){
		                                 poleTypeTy = new BigDecimal("7");
		                                 }else if(poleType.equalsIgnoreCase("Tubular")){
		                                 poleTypeTy = new BigDecimal("4");
		                                 }else if(poleType.equalsIgnoreCase("RC")){
		                                 poleTypeTy = new BigDecimal("6");
		                                 }else if(poleType.equalsIgnoreCase("Wood")){
		                                 poleTypeTy = new BigDecimal("1");
		                                 }else{
		                                 poleTypeTy = new BigDecimal("8");

		                                 }
		                                 obj.setPoleType(poleTypeTy);
		                                 System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "poleTypeTy : " + poleTypeTy);
		                                 }
		                             else if(i==5){
		                            	 workingLoad =  cell.getStringCellValue();
			    	                     BigDecimal poleWeight = new BigDecimal("0");
				    	                 workingLoad =  cell.getStringCellValue();
				    	                	if(workingLoad.equalsIgnoreCase("10")){
				    	                			poleWeight = new BigDecimal("6");
				    	                		}else if(workingLoad.equalsIgnoreCase("11-850")){
				    	                			poleWeight = new BigDecimal("5");
				    	                		}else if(workingLoad.equalsIgnoreCase("11-500")){
				    	                			poleWeight = new BigDecimal("1");
				    	                		}else if(workingLoad.equalsIgnoreCase("11-350")){
				    	                			poleWeight = new BigDecimal("3");
				    	                		}else if(workingLoad.equalsIgnoreCase("10-225")){
				    	                			poleWeight = new BigDecimal("4");
				    	                		}else if(workingLoad.equalsIgnoreCase("11-350")){
				    	                			poleWeight = new BigDecimal("2");
				    	                			
				    	                			
				    	                		}else if(workingLoad.equalsIgnoreCase("9-115")){
				    	                			poleWeight = new BigDecimal("7");
				    	                			
				    	                		}else if(workingLoad.equalsIgnoreCase("13-850")){
				    	                			poleWeight = new BigDecimal("8");
				    	                			
				    	                			
				    	                		}else{
				    	                			poleWeight = new BigDecimal("0");

				    	                		}
				    	                		obj.setWorkingLoad(poleWeight);
				    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "poleWeight : " + poleWeight);

		                            	 
		                             } else if(i==6){
		                            	 obj.setFeederNo("F1");
			    	                	obj.setCsc("461.10");	
		                             }else{
		                            	 
		                             }

	                        	System.out.println("hh : " + cell.getStringCellValue());
	                        	//lineHashMap.put(i, cell.getStringCellValue());
	                        	System.out.println("else end no : " + i);
	    	                	
	                        	i++;
	                        	System.out.println("else end no after : " + i);
	    	                	   
	                                                     break;
	                    }//end switch
	                    //addLineDao.addLine(objExisting);
	                    
	                 }//end while cell iterator
	                //objLineList.add(objExisting);
	                obj.setStatus(new BigDecimal("2"));
	                mvPoleDao.addPole(obj);
	                obj = new MmsAddmvpole();
	                System.out.println("save obj");
	               // try{
	                //}catch(Exception e){
	                	//System.out.println("end save obj : error "+ e);
		                
	                //}
	                System.out.println("end save obj");
	                
	            }
				fileExcel.close();
				System.out.println("Server File Location="
						+ serverFile.getAbsolutePath());

				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}


	
	
	
	
	
	
	
	

	
	 @RequestMapping(value = "/readExcel", method = RequestMethod.GET)
		public void readExcel(){
	    	try {

	            FileInputStream file = new FileInputStream(new File("F://CEB/MV-MMS/Data/MNT.xlsx"));
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            
	            
	            Iterator<Row> rowIterator = sheet.iterator();
	            rowIterator.next();
	            while(rowIterator.hasNext())
	            {
	                Row row = rowIterator.next();
	                //For each row, iterate through each columns
	                Iterator<Cell> cellIterator = row.cellIterator();

	                while(cellIterator.hasNext())
	                {
	                    Cell cell = cellIterator.next();
	                    //This will change all Cell Types to String
	                    cell.setCellType(Cell.CELL_TYPE_STRING);
	                    switch(cell.getCellType()) 
	                    {
	                        case Cell.CELL_TYPE_BOOLEAN:
	                            System.out.println("boolean===>>>"+cell.getBooleanCellValue() + "\t");
	                            break;
	                        case Cell.CELL_TYPE_NUMERIC:

	                            break;
	                        case Cell.CELL_TYPE_STRING:
	                        	System.out.println("hh : " + cell.getStringCellValue());
	                        //   list.add(cell.getStringCellValue());

	                                                     break;
	                    }


	                }
	              //  name=row.getCell(0).getStringCellValue();
	              //  empid=row.getCell(1).getStringCellValue();
	              //  add=row.getCell(2).getStringCellValue();
	              //  mobile=row.getCell(3).getStringCellValue();
	              //  System.out.println(name+empid+add+mobile);
	              //  ex.InsertRowInDB(name,empid,add,mobile);
	             //   System.out.println("");


	            }
	            file.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	      }
	 
	 @RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
		public void sendEmail(HttpServletRequest request){
		 ApplicationContext context = 
		            new ClassPathXmlApplicationContext("Spring-Mail.xml");
		 //request.getSession().getServletContext().getRealPath("/jasper/Spring-Mail.xml");
				 MailMail mm = (MailMail) context.getBean("mailMail");
		        mm.sendMail("Mr. Eranga", "Please send me the dedails");
	      }
	 
	 
	  /**
		 * Upload single file using Spring Controller
		 */
		@RequestMapping(value = "/uploadLine", method = RequestMethod.POST)
		public ModelAndView  uploadFilenewHandler(HttpServletRequest request,@RequestParam("file") MultipartFile file,@ModelAttribute("pivModel") PivModel pivModel) {
			
			
			String name = ""; 
			String mode = "";
			String deptId = request.getSession().getAttribute("deptId").toString();
			if (!file.isEmpty()) {
				try {
					
					name = file.getOriginalFilename();
					byte[] bytes = file.getBytes();

					// Creating the directory to store file
					String rootPath = System.getProperty("catalina.home");
					File dir = new File(rootPath + File.separator + "tmpFiles");
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + name);
					
		            
					
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					FileInputStream fileExcel = new FileInputStream(serverFile);
		            
				    XSSFWorkbook workbook = new XSSFWorkbook(fileExcel);
		            XSSFSheet sheet = workbook.getSheetAt(0);
		            
		            List<MmsAddline> objLineList = new ArrayList<MmsAddline>();
		            MmsAddline obj = new MmsAddline();
		    		//MmsTowermaintenancePK objPK = new MmsTowermaintenancePK();
		    		Map<Integer,String> lineHashMap = new LinkedHashMap<Integer,String>();
		    		MmsAddline objExisting = new MmsAddline();
		    		Iterator<Row> rowIterator = sheet.iterator();
		    		//rowIterator.
		            rowIterator.next();
		            while(rowIterator.hasNext())
		            {
		                Row row = rowIterator.next();
		                //For each row, iterate through each columns
		                Iterator<Cell> cellIterator = row.cellIterator();
		                int i=0;
		                while(cellIterator.hasNext())
		                {
		                    
		                	
		                	String code ="";
		                	String nameline ="";
		                	String lineType ="";
		                	String length ="";
		                	String area="";
		                	String noofpoles="";
		                	String nooftowers="";
		                	String comdate="";	                	
		                	String cirType="";	                	
		                	String conType="";	
		                	String feeder="";	                	
		                	
		                	
		                	
		                	
		                	Cell cell = cellIterator.next();
		                	
		                	//i++;
		                	
		                	//This will change all Cell Types to String
		                    cell.setCellType(Cell.CELL_TYPE_STRING);
		                    switch(cell.getCellType()) 
		                    {
		                        case Cell.CELL_TYPE_BOOLEAN:
		                            System.out.println("boolean===>>>"+cell.getBooleanCellValue() + "\t");
		                            break;
		                        case Cell.CELL_TYPE_NUMERIC:

		                            break;
		                        case Cell.CELL_TYPE_STRING:
		                        	
		                        	if(i==0){
		    	                		code =  cell.getStringCellValue();
		    	                		code = code.replaceAll("/", "-");

		    	                		objExisting.setCode(code);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "code : " + code + " objC :" +objExisting.getCode() );
		    		                    
		    	                	}
		    	                	else if(i==1){
		    	                		nameline =  cell.getStringCellValue();
		    	                		objExisting.setLineName(nameline);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "name : " + nameline + " objN :" +objExisting.getName() );
		    		                    
		    	                	}
		    	                	
		    	                	else if(i==2){
		    	                		lineType =  cell.getStringCellValue();
		    	                		objExisting.setLineType(lineType);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "lineType : " + lineType + " objNd :" +objExisting.getLineType() );
		    		                    
		    	                	}
		    	                	else if(i==3){
		    	                		length =  cell.getStringCellValue();
		    	                		objExisting.setLength(new BigDecimal(length));
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "length : " + length + " objNc :" +objExisting.getLength() );
		    		                    
		    	                	}
		    	                	else if(i==4){
		    	                		area =  cell.getStringCellValue();
		    	                		area = area +".00";
		    	                		
		    	                		objExisting.setArea(area);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "area : " + area + " objNd :" +objExisting.getArea() );
		    		                    
		    	                	}
		    	                	else if(i==5){
		    	                		noofpoles =  cell.getStringCellValue();
		    	                		objExisting.setNoofpoles(new BigDecimal(noofpoles));
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "noofpoles : " + noofpoles + " objNd :" +objExisting.getNoofpoles() );
		    		                    
		    	                	}
		    	                	else if(i==6){
		    	                		nooftowers =  cell.getStringCellValue();
		    	                		try {
											objExisting.setNooftowers(new BigDecimal(nooftowers));
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
		    	                		//System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "nooftowers : " + nooftowers + " objNd :" +objExisting.getNooftowers() );
		    		                    
		    	                	}
		    	                	else if(i==7){
		    	                		/*System.out.println("comdate : "+ comdate);
		    	                		
		    	                		comdate =  cell.getStringCellValue();
		    	                		System.out.println("comdate : "+ comdate);
		    	                		DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
		    	                		java.util.Date date = format.parse(comdate);

		    	                		objExisting.setComdate(date);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "comdate : " + comdate + " objNd :" +objExisting.getComdate() );
		    	                		
		    	                		comdate =  cell.getStringCellValue();
		    	                		Date date1=new SimpleDateFormat("YYYY-MM-DD").parse(comdate); 
		    	                		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		    	                		String dateString = format.format(date1);
		    	                		Date   date2       = format.parse (dateString);    
*/
		    	                		
		    	                		
		    	                		
		    	                	}else if(i==8){
		    	                		cirType =  cell.getStringCellValue();
		    	                		objExisting.setCircuitType(new BigDecimal(cirType));
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "cirType : " + nooftowers + " objNd :" +objExisting.getCircuitType() );
		    		                    
		    	                	}
		    	                	else if(i==9){
		    	                		conType =  cell.getStringCellValue();
		    	                		objExisting.setConductorType(new Float(conType));
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "conType : " + nooftowers + " objNd :" +objExisting.getConductorType() );
		    		                    
		    	                	}
		    	                	else if(i==10){
		    	                		feeder =  cell.getStringCellValue();
		    	                		objExisting.setFeederIdentification(feeder);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "feeder : " + nooftowers + " objNd :" +objExisting.getConductorType() );
		    		                    
		    	                	}
		    	                	
		    	                	
		    	                	else{
		    	                		
		    	                	}
		                        	//System.out.println("hh : " + cell.getStringCellValue());
		                        	lineHashMap.put(i, cell.getStringCellValue());
		                        	//System.out.println("else end no : " + i);
		    	                	
		                        	i++;
		                        	//System.out.println("else end no after newwwww : " + i);
		    	                	   
		                                                     break;
		                    }//end switch
		                    //addLineDao.addLine(objExisting);
			                
		                 }//end while cell iterator
		                //objLineList.add(objExisting);
		                objExisting.setPhmBranch(deptId);
		                objExisting.setStatus(new BigDecimal("2"));
		                addLineDao.addLine(objExisting);
		                objExisting = new MmsAddline();
		                System.out.println("save obj");
		               // try{
		                //}catch(Exception e){
		                	//System.out.println("end save obj : error "+ e);
			                
		                //}
		                System.out.println("end save obj");
		                
		            }
					fileExcel.close();
				
					//JOptionPane.showMessageDialog(null,"successfully uploaded");
					
					System.out.println("Server File Location="
							+ serverFile.getAbsolutePath());
					
					mode ="You successfully uploaded file " + name;
					

					//return "You successfully uploaded file=" + name;
				} catch (Exception e) {
					mode ="You failed to upload " + name + " => " + e.getMessage();
				}
			} else {
				mode ="You failed to upload " + name + " because the file was empty.";
			}
			PivModel objpiv = new PivModel();
			objpiv.setMode(mode);
			return new ModelAndView("UploadLine" ,"model",objpiv);
		}
		
		
		@RequestMapping(value = "/uploadFormLine", method = RequestMethod.GET)
		public ModelAndView uploadFormLine(HttpServletRequest request) {
			//return "upload";
			//ModelAndView modelV = new ModelAndView();
			PivModel model = new PivModel();
			//model.setViewName("UploadTowerMaintenance","model",model);
			ModelAndView mm = new ModelAndView("UploadLine" ,"model",model);
			
			return mm;
			//return "UploadTowerMaintenance";
		}
		
		@RequestMapping(value = "/uploadMNT", method = RequestMethod.POST)
		public ModelAndView uploadMNT(HttpServletRequest request,@RequestParam("file") MultipartFile file,@ModelAttribute("pivModel") PivModel pivModel){
			
			System.out.println("test");
			String name = ""; 
			String mode = "";
			String ss="";
			String cycle = pivModel.getCycleObj().getId().getCycleId();
			String deptId = request.getSession().getAttribute("deptId").toString();
			if (!file.isEmpty()) {
				try {
					name = file.getOriginalFilename();
					byte[] bytes = file.getBytes();

					// Creating the directory to store file
					String rootPath = System.getProperty("catalina.home");
					File dir = new File(rootPath + File.separator + "tmpFiles");
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + name);
					
					//System.out.println("test1");

	                String tNo="";
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					
					//System.out.println("test11");
					stream.write(bytes);
					stream.close();
					FileInputStream fileExcel = new FileInputStream(serverFile);
		            
				    XSSFWorkbook workbook = new XSSFWorkbook(fileExcel);
		            XSSFSheet sheet = workbook.getSheetAt(0);
		            List<MmsTxntowermaintenance> objLineList = new ArrayList<MmsTxntowermaintenance>();
		            MmsTxntowermaintenance obj = new MmsTxntowermaintenance();
		            MmsTxntowermaintenancePK objPK = new MmsTxntowermaintenancePK();
		    		//MmsTowermaintenancePK objPK = new MmsTowermaintenancePK();
		    		Map<Integer,String> lineHashMap = new LinkedHashMap<Integer,String>();
		    		MmsTxntowermaintenance objExisting = new MmsTxntowermaintenance();
		    		Iterator<Row> rowIterator = sheet.iterator();
		    		//rowIterator.
		            rowIterator.next();
		            while(rowIterator.hasNext())
		            {
		                Row row = rowIterator.next();
		                //For each row, iterate through each columns
		                Iterator<Cell> cellIterator = row.cellIterator();
		                int i=0;
		                while(cellIterator.hasNext())
		                {
		                    
		                	
		                	String towerNo ="";
		                	String tappings ="";
		                	String missingParts ="";
		                	String flashOverSets ="";
		                	String maintenanceDate="";
		                	String wayLeaving="";
		                	String baseConcrete="";
		                	String antiClimbing="";	                	
		                	String conductorCondition="";
		                	String jumperCondition="";
		                	String earthConductorCondition="";
		                	String maintainaceAttention="";
		                	String fungussSetno="";
		                	String wpinset="";
		                	String endfittingSet="";
		                	String towerspecial="";
		                	String legPainting="";
		                	
		                	Cell cell = cellIterator.next();
		                	
		                	//i++;
		                	
		                	//This will change all Cell Types to String
		                    cell.setCellType(Cell.CELL_TYPE_STRING);
		                    switch(cell.getCellType()) 
		                    {
		                        case Cell.CELL_TYPE_BOOLEAN:
		                            System.out.println("boolean===>>>"+cell.getBooleanCellValue() + "\t");
		                            break;
		                        case Cell.CELL_TYPE_NUMERIC:

		                            break;
		                        case Cell.CELL_TYPE_STRING:
		                        	
		                        	
		    	                	 if(i==0){
		    	                		towerNo =  cell.getStringCellValue();
		    	                		tNo=towerNo.trim();
		    	                		String towerId = addSupportDao.getTowerIDByTowerNo(towerNo);
		    	                		if(towerId.equals("N")){
		    	                			mode ="Tower number is not in the system " +towerNo ;
		    	                		}
			    	                	try{
			    	                		objPK.setTowerid(new Long(towerId));
			    	                	 }catch(Exception e){
			    	                		 mode ="Tower number is not in the system " +towerNo ;
			    	                	 }
			    	                	objPK.setVisitid(new Long(cycle));
			    	                	
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerNo : " + towerNo + " objC :"  );
		    		                    
		    	                	}
		    	                	else if(i==1){
		    	                		tappings =  cell.getStringCellValue();
		    	                		objExisting.setNooftappings(new BigDecimal(tappings));
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "tappings : " + tappings + " objN :" );
		    		                    
		    	                	}
		    	                	
		    	                	else if(i==2){
		    	                		missingParts =  cell.getStringCellValue();
		    	                		objExisting.setNoofmissingparts(new BigDecimal(missingParts));
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "missingParts : " + missingParts + " objNd :"  );
		    		                    
		    	                	}
		    	                	else if(i==3){
		    	                		flashOverSets =  cell.getStringCellValue();
		    	                		objExisting.setNofflashoversets(new BigDecimal(flashOverSets));
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "flashOverSets : " + flashOverSets + " objNc :" );
		    	                		System.out.println("hey");
		    	                	}
		    	                	else if(i==4){
		    	                		maintenanceDate =  cell.getStringCellValue();
		    	                		Date date1=new SimpleDateFormat("YYYY/MM/DD HH:MM:SS").parse(maintenanceDate); 
		    	                		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		    	                		String dateString = format.format(date1);
		    	                		Date   date2       = format.parse (dateString);    

		    	                		
		    	                		
		    	                		
		    	                		//DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
		    	                		//java.util.Date date = format.parse(maintenanceDate);

		    	                		objExisting.setMaintenancedate(date2);
		    	                		System.out.println("date : "  +i +"/"+ cell.getStringCellValue() + "maintenanceDate : " + maintenanceDate + " objNd :"  );
		    		                   
		    	                	}
		    	                	else if(i==5){
		    	                		wayLeaving =  cell.getStringCellValue();
		    	                		objExisting.setWayleavestatus(wayLeaving);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "wayLeaving : " + wayLeaving + " objNd :"  );
		    		                    
		    	                	}
		    	                	else if(i==6){
		    	                		baseConcrete =  cell.getStringCellValue();
		    	                		objExisting.setBaseconcretestatus(baseConcrete);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "baseConcrete : " + baseConcrete + " objNd :"  );
		    		                    
		    	                	}
		    	                	else if(i==7){
		    	                		antiClimbing =  cell.getStringCellValue();
		    	                		objExisting.setAnticlimbingstatus(antiClimbing);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "antiClimbing : " + antiClimbing + " objNd :"  );
		    		                    
		    	                	}
		    	                	else if(i==8){
		    	                		conductorCondition =  cell.getStringCellValue();
		    	                		objExisting.setConductorstatus(conductorCondition);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "conductorCondition : " + conductorCondition + " objNd :"  );
		    		                    
		    	                	}
		    	                	else if(i==9){
		    	                		jumperCondition =  cell.getStringCellValue();
		    	                		objExisting.setJumperstatus(jumperCondition);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "jumperCondition : " + jumperCondition + " objNd :" );
		    		                    
		    	                	}
		    	                	else if(i==10){
		    	                		earthConductorCondition =  cell.getStringCellValue();
		    	                		objExisting.setEarthconductorstatus(earthConductorCondition);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "earthConductorCondition : " + earthConductorCondition + " objNd :"  );
		    		                    
		    	                	}
		    	                	else if(i==11){
		    	                		maintainaceAttention =  cell.getStringCellValue();
		    	                		objExisting.setAttentionstatus(maintainaceAttention);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "maintainaceAttention : " + maintainaceAttention + " objNd :"  );
		    		                    
		    	                	}
		    	                	else if(i==12){
		    	                		fungussSetno =  cell.getStringCellValue();
		    	                		objExisting.setFungussetno(new BigDecimal(fungussSetno));
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "fungussSetno : " + fungussSetno + " objNd :"  );
		    		                    
		    	                	}
		    	                	else if(i==13){
		    	                		wpinset =  cell.getStringCellValue();
		    	                		objExisting.setWpinset(new BigDecimal(wpinset));
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "wpinset : " + wpinset + " objNd :" +objExisting.getWpinset() );
		    		                    
		    	                	}
		    	                	else if(i==14){
		    	                		endfittingSet =  cell.getStringCellValue();
		    	                		objExisting.setEndfittingset(new BigDecimal(endfittingSet));
		    	                	//	System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "endfittingSet : " + endfittingSet + " objNd :"  );
		    		                    
		    	                	}
		    	                	else if(i==15){
		    	                		towerspecial =  cell.getStringCellValue();
		    	                		if(towerspecial.equals("")){
		    	                			towerspecial ="None";
		    	                		}
		    	                		objExisting.setTowerspecial(towerspecial);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getTowerspecial() );
		    		                    
		    	                	}
		    	                	else if(i==16){
		    	                		legPainting =  cell.getStringCellValue();
		    	                		objExisting.setLegPainting(legPainting);;
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "legPainting : " + legPainting + " objNd :" +objExisting.getLegPainting() );
		    		                    
		    	                	}
		    	                	else if(i==17){
		    	                		String hotPossible =  cell.getStringCellValue();
		    	                		hotPossible = hotPossible.trim();
		    	                		if(hotPossible.compareTo("Possible")==0){
		    	                			System.out.println("Possible : ");
		    	                			objExisting.setHotpossible(new BigDecimal("1"));
		    	                		}else{
		    	                			System.out.println("IMPossible : ");
		    	                			
		    	                			objExisting.setHotpossible(new BigDecimal("0"));
		    	                			
		    	                		}
		    	                		//objExisting.setHotpossible(new BigDecimal(hotPossible));
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "setHotpossible : " + towerspecial + " objNd :" +objExisting.getHotpossible() );
		    		                    
		    	                	}else if(i==18){
		    	                		String noOfPinPole1 =  cell.getStringCellValue();
		    	                		objExisting.setPinpole1(new BigDecimal(noOfPinPole1));
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getLegPainting() );
		    		                    
		    	                	}else if(i==19){
		    	                		String typeOfSw1 =  cell.getStringCellValue();
		    	                		objExisting.setSwitchdev1(typeOfSw1);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getLegPainting() );
		    		                    
		    	                	}else if(i==20){
		    	                		String noOfPinPole2 =  cell.getStringCellValue();
		    	                		objExisting.setPinpole2(new BigDecimal(noOfPinPole2));
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getLegPainting() );
		    		                    
		    	                	}else if(i==21){
		    	                		String typeOfSw2 =  cell.getStringCellValue();
		    	                		objExisting.setSwitchdev2(typeOfSw2);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getLegPainting() );
		    		                    
		    	                	}else if(i==22){
		    	                		String noOfPinPole3 =  cell.getStringCellValue();
		    	                		objExisting.setPinpole3(new BigDecimal(noOfPinPole3));
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getLegPainting() );
		    		                    
		    	                	}else if(i==23){
		    	                		String typeOfSw3 =  cell.getStringCellValue();
		    	                		objExisting.setSwitchdev3(typeOfSw3);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getLegPainting() );
		    		                    
		    	                	}
		    	                	
		    	                	else{
		    	                		
		    	                	}
	                        	//System.out.println("hh : " + cell.getStringCellValue());
		                        	//lineHashMap.put(i, cell.getStringCellValue());
		                        	System.out.println("else end no : " + i);
		    	                	
		                        	i++;
		                        	System.out.println("else end no after : " + i);
		    	                	   
		                        	                                break;
		                        	                                
		                    }//end switch
		                   // MmsTowermaintenanceDao.towermaintenance(objExisting);
		                   
		                 }//end while cell iterator
		                
		                objExisting.setPhmBranch(deptId);
		                MmsTxntowermaintenance dd = towerTxtMaintenance.findByID(objPK);
		                
		                objExisting.setId(objPK);
		                objExisting.setStatus(new BigDecimal("2"));
		                objExisting.setApprovalLevel("60041ES1");
		                objExisting.setCycle(cycle);
		                
		                if(dd ==null){
		                	towerTxtMaintenance.addTowerMaintananceData(objExisting);
		                }else{
		                	//ss="Already in the System Tower No :" + tNo + " Tower ID :" +objExisting.getId().getTowerid() ;
		                	//ss ="/" + ss;
		                	towerTxtMaintenance.update(objExisting);
		                }
		               // towerTxtMaintenance.addTowerMaintananceData(objExisting);
		                objExisting = new MmsTxntowermaintenance();
		                System.out.println("save obj");
		                
		                //objLineList.add(objExisting);
		                System.out.println("test4");
		                //objExisting.setPhmBranch(deptId);
		                //objExisting.setStatus(new BigDecimal("2"));
		                System.out.println("end save obj1");
		               // MmsTowermaintenance.towermaintenance(objExisting);
		               // objExisting = new MmsTowermaintenance();
		                System.out.println("save obj2");
		               // try{
		                //}catch(Exception e){
		                	//System.out.println("end save obj : error "+ e);
			                
		                //}
		                System.out.println("end save obj");
		                
		            }
					fileExcel.close();
					System.out.println("Server File Location="
							+ serverFile.getAbsolutePath());
					
					mode ="You successfully uploaded file " + name;
					

					//return "You successfully uploaded file=" + name;
				} catch (Exception e) {
					mode ="You failed to upload " + name + " => " +ss + e.getMessage();
				}
			} else {
				mode ="You failed to upload " + name + " because the file was empty.";
			}
			PivModel objpiv = new PivModel();
			objpiv.setMode(mode);
			return new ModelAndView("MNTUpload" ,"model",objpiv);
		}
		
		
		@RequestMapping(value = "/upMNT", method = RequestMethod.GET)
		public ModelAndView upMNT(HttpServletRequest request) {
			//return "upload";
			//ModelAndView modelV = new ModelAndView();
			PivModel model = new PivModel();
			String deptId = request.getSession().getAttribute("deptId").toString();
			
			Map<String,String> cycle = new LinkedHashMap<String,String>();
			List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle(deptId);
			int cycleLisuCount = cycleList.size()-1;
			for(int i=0;i<=cycleLisuCount;i++){ 
				//System.out.println(i);
				MvmmsCycle ojb = cycleList.get(i);
				cycle.put(ojb.getId().getCycleId(), ojb.getCycleName());
		      
		    } 


	model.setCycleList(cycle);

			
			//model.setViewName("UploadTowerMaintenance","model",model);
			ModelAndView mm = new ModelAndView("MNTUpload" ,"model",model);
			
			return mm;
			
		}
		
		@RequestMapping(value = "/upSupport", method = RequestMethod.GET)
		public ModelAndView upSupport(HttpServletRequest request) {
			//return "upload";
			//ModelAndView modelV = new ModelAndView();
			PivModel model = new PivModel();
			//model.setViewName("UploadTowerMaintenance","model",model);
			ModelAndView mm = new ModelAndView("UploadSupport" ,"model",model);
			
			return mm;
			
		}
		
		@RequestMapping(value = "/upMvPole", method = RequestMethod.GET)
		public ModelAndView upMvPole(HttpServletRequest request) {
			//return "upload";
			//ModelAndView modelV = new ModelAndView();
			PivModel model = new PivModel();
			//model.setViewName("UploadTowerMaintenance","model",model);
			ModelAndView mm = new ModelAndView("UploadMVPole" ,"model",model);
			
			return mm;
			
		}
		
		
		
		@RequestMapping(value = "/uploadSupport", method = RequestMethod.POST)
		public ModelAndView uploadSupport(HttpServletRequest request,@RequestParam("file") MultipartFile file,@ModelAttribute("pivModel") PivModel pivModel){
			

			String name = ""; 
			String mode = "";
			String deptId = request.getSession().getAttribute("deptId").toString();
			if (!file.isEmpty()) {
				try {
					name = file.getOriginalFilename();
					byte[] bytes = file.getBytes();

					// Creating the directory to store file
					String rootPath = System.getProperty("catalina.home");
					File dir = new File(rootPath + File.separator + "tmpFiles");
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + name);
					
		            
					
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					FileInputStream fileExcel = new FileInputStream(serverFile);
		            
				    XSSFWorkbook workbook = new XSSFWorkbook(fileExcel);
		            XSSFSheet sheet = workbook.getSheetAt(0);
		            
		            List<MmsAddline> objLineList = new ArrayList<MmsAddline>();
		            MmsAddsupport obj = new MmsAddsupport();
		    		//MmsTowermaintenancePK objPK = new MmsTowermaintenancePK();
		    		Map<Integer,String> lineHashMap = new LinkedHashMap<Integer,String>();
		    		MmsAddsupport objExisting = new MmsAddsupport();
		    		Iterator<Row> rowIterator = sheet.iterator();
		    		//rowIterator.
		            rowIterator.next();
		            while(rowIterator.hasNext())
		            {
		                Row row = rowIterator.next();
		                //For each row, iterate through each columns
		                Iterator<Cell> cellIterator = row.cellIterator();
		                int i=0;
		                while(cellIterator.hasNext())
		                {
		                    
		                	
		                	String id ="";
		                	String nameline ="";
		                	String lineType ="";
		                	String length ="";
		                	String area="";
		                	String noofpoles="";
		                	String nooftowers="";
		                	String comdate="";	                	
		                	
		                	
		                	
		                	Cell cell = cellIterator.next();
		                	
		                	//i++;
		                	
		                	//This will change all Cell Types to String
		                    cell.setCellType(Cell.CELL_TYPE_STRING);
		                    switch(cell.getCellType()) 
		                    {
		                        case Cell.CELL_TYPE_BOOLEAN:
		                            System.out.println("boolean===>>>"+cell.getBooleanCellValue() + "\t");
		                            break;
		                        case Cell.CELL_TYPE_NUMERIC:

		                            break;
		                        case Cell.CELL_TYPE_STRING:
		                        	
		                        	if(i==0){
		    	                		String suType =  cell.getStringCellValue();
		    	                		objExisting.setSupportType(new BigDecimal(suType));
		    	                		System.out.println("hh : " + cell.getStringCellValue() + "code : " + suType + " objE :" +objExisting.getSupportType() );
		    		                    
		    	                	}else if(i==1){
		    	                		String towerNo =  cell.getStringCellValue();
		    	                		objExisting.setTowerNo(towerNo);
		    	                		 System.out.println("1");
		    	                	}
		    	                	else if(i==2){
		    	                		String areaNew =  cell.getStringCellValue();
		    	                		if(areaNew.length()== 6){
		    	                			objExisting.setArea(areaNew);
		    	                		}else{
		    	                			objExisting.setArea(areaNew+".00");
		    	                		}
		    	                		System.out.println("2");
		    	                	}
		    	                	
		    	                	else if(i==3){
		    	                		String conType =  cell.getStringCellValue();
		    	                		objExisting.setConductorType(new BigDecimal(conType));
		    	                		System.out.println("3");
		    	                	}
		    	                	else if(i==4){
		    	                		String eConTypee =  cell.getStringCellValue();
		    	                		objExisting.setEarthConductorType(new BigDecimal(eConTypee));
		    	                		System.out.println("4");
		    	                	}
		    	                	else if(i==5){
		    	                		String towerType =  cell.getStringCellValue();
		    	                		objExisting.setTowerType(new BigDecimal(towerType));
		    	                		System.out.println("5");
		    	                	}
		    	                	else if(i==6){
		    	                		String towerConf =  cell.getStringCellValue();
		    	                		objExisting.setTowerConfiguration(new BigDecimal(towerConf));
		    	                		System.out.println("6");
		    	                	}
		    	                	else if(i==7){
		    	                		String gpsLatitude =  cell.getStringCellValue();
		    	                		objExisting.setGpsLatitude(new BigDecimal(gpsLatitude));
		    	                		System.out.println("7");
		    	                	}
		    	                	else if(i==8){
		    	                		String gpsLongitude =  cell.getStringCellValue();
		    	                		objExisting.setGpsLongitude(new BigDecimal(gpsLongitude));
		    	                		System.out.println("8");
		    	                	}else if(i==9){
		    	                		String noOfCir =  cell.getStringCellValue();
		    	                		System.out.println("noOfCir :"+noOfCir);
		    			                
		    	                		objExisting.setNoOfCircuits(new BigDecimal(noOfCir));
		    	                		System.out.println("8");
		    	                	}else if(i==10){
		    	                		String boduExt =  cell.getStringCellValue();
		    	                		objExisting.setBodyExtension(boduExt);
		    	                		System.out.println("9");
		    	                	}else if(i==11){
		    	                		String lineID =  cell.getStringCellValue();
		    	                		objExisting.setLineId(new BigDecimal(lineID));
		    	                		System.out.println("10");
		    	                	}else if(i==12){
		    	                		String tapping =  cell.getStringCellValue();
		    	                		objExisting.setTapping(new BigDecimal(tapping));
		    	                		System.out.println("11");
		    	                	}else if(i==13){
		    	                		String mapid =  cell.getStringCellValue();
		    	                		objExisting.setMapId(new BigDecimal(mapid));
		    	                		System.out.println("12");
		    	                	}else if(i==14){
		    	                		String csc =  cell.getStringCellValue();
		    	                		objExisting.setCsc(csc);
		    	                		System.out.println("13");
		    	                	}else{
		    	                			    	                		
		    	                	}
		                        	System.out.println("14");
		                        	//System.out.println("hh : " + cell.getStringCellValue());
		                        	//lineHashMap.put(i, cell.getStringCellValue());
		                        	System.out.println("else end no : " + i);
		    	                	
		                        	i++;
		                        	System.out.println("else end no after : " + i);
		    	                	   
		                                                     break;
		                    }//end switch
		                    //addLineDao.addLine(objExisting);
			                
		                 }//end while cell iterator
		                //objLineList.add(objExisting);
		                objExisting.setPhmBranch(deptId);
		                objExisting.setStatus(new BigDecimal("2"));
		                try {
							addSupportDao.addSupport(objExisting);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		                objExisting = new MmsAddsupport();
		                System.out.println("save obj");
		               // try{
		                //}catch(Exception e){
		                	//System.out.println("end save obj : error "+ e);
		               
		                //}
		                System.out.println("end save obj");
		                
		            }
					fileExcel.close();
					//System.out.println("Server File Location="
						//	+ serverFile.getAbsolutePath());
					
					mode ="You successfully uploaded file " + name;
					

					//return "You successfully uploaded file=" + name;
				} catch (Exception e) {
					mode ="You failed to upload " + name + " => " + e.getMessage();
				}
			} else {
				mode ="You failed to upload " + name + " because the file was empty.";
			}
			PivModel objpiv = new PivModel();
			objpiv.setMode(mode);
			return new ModelAndView("UploadSupport" ,"model",objpiv);
		}
		
		
		@RequestMapping(value = "/WelcomePCB", method = RequestMethod.GET)
	    public ModelAndView WelcomePCB() {

	        ModelAndView model = new ModelAndView();
	        model.setViewName("PCB_Login");

	        return model;

	    }
		
		
		/**
		 * Upload single file using Spring Controller
		 */
		@RequestMapping(value = "/uploadEqui", method = RequestMethod.POST)
		public ModelAndView  uploadEqui(HttpServletRequest request,@RequestParam("file") MultipartFile file,@ModelAttribute("model") PcbModel pcbModelObj) {
			
			
			String name = ""; 
			String mode = "";
			List<PcbModel> listPcbModel = null;
			String deptId = request.getSession().getAttribute("deptId").toString();
			if (!file.isEmpty()) {
				try {
					
					name = file.getOriginalFilename();
					byte[] bytes = file.getBytes();

					// Creating the directory to store file
					String rootPath = System.getProperty("catalina.home");
					File dir = new File(rootPath + File.separator + "tmpFiles");
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + name);
					
		            
					
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					FileInputStream fileExcel = new FileInputStream(serverFile);
		            
				    XSSFWorkbook workbook = new XSSFWorkbook(fileExcel);
		            XSSFSheet sheet = workbook.getSheetAt(0);
		            
		            List<MmsAddline> objLineList = new ArrayList<MmsAddline>();
		            MmsAddline obj = new MmsAddline();
		    		//MmsTowermaintenancePK objPK = new MmsTowermaintenancePK();
		    		Map<Integer,String> lineHashMap = new LinkedHashMap<Integer,String>();
		    		PcbEquipment pcbEuipments = new PcbEquipment();
	    			PcbLocation pcbLocation = new PcbLocation();
	    			PcbCondition pcbCondition = new PcbCondition();
	    			PcbSample pcbSample = new PcbSample();
	    			//List<PcbModel> listPcbModel = new ArrayList<PcbModel>();
	    			Iterator<Row> rowIterator = sheet.iterator();
	    			int rowCount = sheet.getPhysicalNumberOfRows();
	    			listPcbModel = new ArrayList<PcbModel>(rowCount);
	    			
		    		//rowIterator.
		            rowIterator.next();
		            
		            while(rowIterator.hasNext())
		            {
		                Row row = rowIterator.next();
		                //For each row, iterate through each columns
		                Iterator<Cell> cellIterator = row.cellIterator();
		                int i=0;
		                while(cellIterator.hasNext())
		                {
		                    
		                	
		                	String reference ="";
		                	String division ="";
		                	String area ="";
		                	String branch ="";
		                	String unit="";
		                	String condition="";
		                	String GPSlocation_Longitude="";
		                	String GPSlocation_Latitude="";	                	
		                	String locationDescription="";
		                	String typeofLocated="";
		                	String mounting="";
		                	String yearofManufacture="";
		                	String type="";
		                	String manufactureLTL="";
		                	String primarySub="";
		                	String manufactureBarnd="";
		                	String samplingPort="";
		                	String extractedfromtop="";
		                	String samplingLogicSatisfied="";
		                	String sampleNo="";
		                	String samplDate="";
		                	String identificationNo="";
		                	String serialNo="";
		                	String voltage="";
		                	String capacity ="";
		                	String weightofTransformer="";
		                	String oilWeight ="";
		                	String volumeofOil ="";
		                	String photoTaken ="";
		                	String photoRef="";
		                	String oilLeaksPresent ="";
		                	String corrosion="";
		                	String burnMarks="";
		                	String terminalNeedattention="";
		                	String earthingConnection="";
		                	String breatherCondition ="";
		                	String overloaSignsPresent ="";
		                	String lightingArresters="";
		                	String remarks="";
		                	String EPFNumbersofthegroup="";
		                	String PCBTestResults="";
		                	String PCBTestdate="";
		                	String EPFNumbersoftheTestGroup="";  
		                	//String ITI
		                	
		                	
		                	
		                	Cell cell = cellIterator.next();
		                	
		                	//i++;
		                	
		                	//This will change all Cell Types to String
		                    cell.setCellType(Cell.CELL_TYPE_STRING);
		                    switch(cell.getCellType()) 
		                    {
		                        case Cell.CELL_TYPE_BOOLEAN:
		                            System.out.println("boolean===>>>"+cell.getBooleanCellValue() + "\t");
		                            break;
		                        case Cell.CELL_TYPE_NUMERIC:

		                            break;
		                        case Cell.CELL_TYPE_STRING:
		                        	
		                        	if(i==0){
		                        		reference =  cell.getStringCellValue();
		                        		pcbEuipments.setReferenceNo(reference);
			    	                	System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Reference : " + reference);
				    	            }

		    	                	else if(i==1){
		    	                		division =  cell.getStringCellValue();
		    	                		String div = pcbModelObj.getPcbEquipment().getDivison();
		    	                		pcbEuipments.setDivison(div);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Division : " + div);
		    	                	}
		    	                	
		    	                	else if(i==2){
		    	                		area  =  cell.getStringCellValue();
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Area : " + area);
		    		                    
		    	                	}
		                        	 
		    	                	else if(i==3){
		    	                		branch  =  cell.getStringCellValue();
		    	                		String brn = pcbModelObj.getPcbEquipment().getBranch();
		    	                		
		    	                		pcbEuipments.setBranch(brn);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Branch  : " + brn);
		    	                	}
		                        	 
		    	                	else if(i==4){
		    	                		unit =  cell.getStringCellValue();
		    	                		String un = pcbModelObj.getPcbEquipment().getUnit();
		    	                		
		    	                		pcbEuipments.setUnit(un);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Unit : " + un);
		    		                   
		    	                	}
		    	                	else if(i==5){
		    	                		condition =  cell.getStringCellValue();
		    	                		pcbEuipments.setCondition(condition);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Condition : " + condition);
		    		                    
		    	                	}
		    	                	else if(i==6){
		    	                		GPSlocation_Longitude =  cell.getStringCellValue();
		    	                		pcbLocation.setGpsLongitude(GPSlocation_Longitude);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "GPS location (Longitude) : " + GPSlocation_Longitude);
		    		                    
		    	                	}
		    	                	else if(i==7){
		    	                		GPSlocation_Latitude =  cell.getStringCellValue();
		    	                		pcbLocation.setGpsLatitude(GPSlocation_Latitude);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "GPS location (Latitude) : " + GPSlocation_Latitude);
		    		                    
		    	                	}
		    	                	else if(i==8){
		    	                		locationDescription =  cell.getStringCellValue();
		    	                		pcbLocation.setLocationDescription(locationDescription);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Location Description : " + locationDescription);
		    		                    
		    	                	} 

		    	                	else if(i==9){
		    	                		typeofLocated    =  cell.getStringCellValue();
		    	                		pcbLocation.setTypeOfLocated(typeofLocated);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Type of Located (Indoor/Outdoor) : " + typeofLocated);
		    		                    
		    	                	}
		    	                	else if(i==10){
		    	                		mounting =  cell.getStringCellValue();
		    	                		pcbLocation.setMounting(mounting);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Mounting (Pole/Plinth/Ground) : " + mounting);    
		    	                	
		    	                	}
		                        	 
		    	                	else if(i==11){
		    	                		yearofManufacture =  cell.getStringCellValue();
		    	                		if(!yearofManufacture.equals("") && (yearofManufacture.length() ==4) ){
		    	                		Date date1=new SimpleDateFormat("YYYY").parse(yearofManufacture); 
		    	                		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		    	                		//String dateString = format.format(date1);
		    	                		//Date   date2       = format.parse (dateString);    
		    	                
		    	                		//DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
		    	                		//java.util.Date date1 = format.parse(yearofManufacture);
		    	                		//java.sql.Date sqlStartDate1 = new java.sql.Date(date1.getTime());  
		    	                		pcbEuipments.setManufactureDate(date1);
		    	                		}
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Year of Manufacture : " + yearofManufacture);
		    	        
		    	                	}
		                        	 
		    	                	else if(i==12){
		    	                		type =  cell.getStringCellValue();
		    	                		pcbEuipments.setType(type);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Type: (Seal /None-Seal) : " + type);
		    		                    
		    	                	}
		    	                	else if(i==13){
		    	                		manufactureLTL =  cell.getStringCellValue();
		    	                		pcbEuipments.setManufactureLtl(manufactureLTL);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Manufacture LTL? : " + manufactureLTL);
		    		                    
		    	                	}
		                        	 
		    	                	else if(i==14){
		    	                		primarySub =  cell.getStringCellValue();
		    	                		pcbEuipments.setPrimarySub(primarySub);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Primary Sub : " + primarySub);
		    		                    
		    	                	}
		                        	 
		    	                	else if(i==15){
		    	                		manufactureBarnd =  cell.getStringCellValue();
		    	                		pcbEuipments.setManufactureBrand(manufactureBarnd);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Manufacture Barnd  : " + manufactureBarnd);
		    		                    
		    	                	}
		                        	 
		    	                	else if(i==16){
		    	                		samplingPort =  cell.getStringCellValue();
		    	                		pcbSample.setSamplingPort(samplingPort);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Sampling Port : " + samplingPort);
		    		                    
		    	                	}
		                        	 
		    	                	else if(i==17){
		    	                		extractedfromtop =  cell.getStringCellValue();
		    	                		pcbSample.setExtractedTop(extractedfromtop);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Extracted from top : " + extractedfromtop);
		    		                    
		    	                	}
		    	                	
		    	                	else if(i==18){
		    	                		samplingLogicSatisfied =  cell.getStringCellValue();
		    	                		pcbSample.setSampleSatisified(samplingLogicSatisfied);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Sampling Logic Satisfied : " + samplingLogicSatisfied);
		    		                    
		    	                	}
		    	                	else if(i==19){
		    	                		sampleNo =  cell.getStringCellValue();
		    	                		pcbSample.setSamplingNu(sampleNo);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Sample Number : " + sampleNo);
		    	                	}
		    	                		
		    	                	else if(i==20){
		    	                		samplDate =  cell.getStringCellValue();
		    	                		if(!samplDate.equals("") && (samplDate.length() ==10)){
		    	                		Date date1=new SimpleDateFormat("YYYY.MM.DD").parse(samplDate); 
		    	                		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		    	                		String dateString = format.format(date1);
		    	                		Date   date2       = format.parse (dateString);    
		    	                		pcbSample.setSampleDate(date2);
		    	                		}
		    	                	//	System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Sample Date : " + dateString);
		    		                   
		    	                		
		    	                	}
		    	                		
		    	                	else if(i==21){
		    	                		identificationNo =  cell.getStringCellValue();
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Identification  No.(SIN) : " + identificationNo);
		    		                    
		    	                	}
		    	                		
		    	                	else if(i==22){
		    	                		serialNo =  cell.getStringCellValue();
		    	                		pcbEuipments.setSerialNo(serialNo);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Serial No : " + serialNo);
		    		                    
		    	                	}
		    	                	
		    	                	else if(i==23){
		    	                		System.out.println("no : "+voltage + "/");
		    	                		voltage =  cell.getStringCellValue();
		    	                		if(voltage != null && !voltage.equals("")){
		    	                			pcbEuipments.setVoltage(new BigDecimal(voltage));
			    	                			
		    	                		}
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "(Primary/Secondary)  Voltage (kV) : " + voltage);
		    	                	}
		    	                	
		    	                	else if(i==24){
		    	                		capacity  =  cell.getStringCellValue();
		    	                		if(capacity != null && !capacity.equals("")){
		    	                			pcbEuipments.setCapacity(new BigDecimal(capacity));
			    	                			
		    	                		}
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Capacity (kVA) : " + capacity);
		    	                	}
		                        	
		    	                	else if(i==25){
		    	                		weightofTransformer =  cell.getStringCellValue();
		    	                		if(weightofTransformer != null && !weightofTransformer.equals("")){
		    	                			pcbEuipments.setWeightTransformer(new BigDecimal(weightofTransformer));
			    	                		
		    	                		}
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Weight of Transformer : " + weightofTransformer);
		    	                	}
		                        	 
		    	                	else if(i==26){
		    	                		oilWeight  =  cell.getStringCellValue();
		    	                		if(oilWeight != null && !oilWeight.equals("")){
		    	                			pcbEuipments.setOilWeight(new BigDecimal(oilWeight));
			    	                		
		    	                		}
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Oil Weight (Kg) : " + oilWeight);
		    	                	}
		                        	
		    	                	else if(i==27){
		    	                		volumeofOil   =  cell.getStringCellValue();
		    	                		pcbEuipments.setVolumeOfOil(volumeofOil);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Volume of Oil (L) : " + volumeofOil);
		    	                	}
		    	                	
		    	                	else if(i==28){
		    	                		photoTaken    =  cell.getStringCellValue();
		    	                		pcbEuipments.setPhotoTaken(photoTaken);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Photo Taken : " + photoTaken);
		    	                	}
		                        	
		    	                	else if(i==29){
		    	                		photoRef    =  cell.getStringCellValue();
		    	                		pcbEuipments.setPhotoRef(photoRef);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Photo Ref. : " + photoRef);
		    	                	}
		                        	
		    	                	else if(i==30){
		    	                		oilLeaksPresent = cell.getStringCellValue();
		    	                		pcbCondition.setOilLeaksPresent(oilLeaksPresent);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Oil Leaks Present (Yes/No) : " + oilLeaksPresent);
		    	                	}
		                        	
		    	                	else if(i==31){
		    	                		corrosion = cell.getStringCellValue();
		    	                		pcbCondition.setCorrosion(corrosion);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Corrosion (Yes/No) : " + corrosion);
		    	                	}
		                        	 
		    	                	else if(i==32){
		    	                		burnMarks = cell.getStringCellValue();
		    	                		pcbCondition.setBurnMask(burnMarks);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Burn Marks (Yes/No) : " + burnMarks);
		    	                	}
		                        	
		    	                	else if(i==33){
		    	                		terminalNeedattention = cell.getStringCellValue();
		    	                		pcbCondition.setTerminalAttention(terminalNeedattention);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Terminal / Connections Need attention (Yes/No) : " + terminalNeedattention);
		    	                	}
		                        	
		    	                	else if(i==34){
		    	                		earthingConnection = cell.getStringCellValue();
		    	                		pcbCondition.setEarthConnection(earthingConnection);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Earthing Connection is properly done (Yes/No) : " + earthingConnection);
		    	                	}
		                        	
		    	                	else if(i==35){
		    	                		breatherCondition  = cell.getStringCellValue();
		    	                		pcbCondition.setBreatherIsGoodConnection(breatherCondition);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Breather is in Good condition (Yes/No) : " + breatherCondition);
		    	                	}
		                        	
		    	                	else if(i==36){
		    	                		overloaSignsPresent   = cell.getStringCellValue();
		    	                		pcbCondition.setOverloadPresent(overloaSignsPresent);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Overload signs present (Yes/No) : " + overloaSignsPresent);
		    	                	}
		                        	
		    	                	else if(i==37){
		    	                		lightingArresters   = cell.getStringCellValue();
		    	                		pcbCondition.setLightingArrestersDone(lightingArresters);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Lighting arresters are properly done (Yes/No) : " + lightingArresters);
		    	                	}
		                        	
		    	                	else if(i==38){
		    	                		remarks   = cell.getStringCellValue();
		    	                		pcbSample.setRemarks(remarks);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Remarks : " + remarks);
		    	                	}
		                        	
		    	                	else if(i==39){
		    	                		EPFNumbersofthegroup   = cell.getStringCellValue();
		    	                		pcbSample.setEpfNoGroup(EPFNumbersofthegroup);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "EPF Numbers of the group : " + EPFNumbersofthegroup);
		    	                	}
		                        	
		    	                	else if(i==40){
		    	                		PCBTestResults   = cell.getStringCellValue();
		    	                		pcbSample.setPcbTestResults(PCBTestResults);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "PCB Test Results : " + PCBTestResults);
		    	                	}
		                        	
		    	                	else if(i==41){
		    	                		PCBTestdate   = cell.getStringCellValue();
		    	                		if(!PCBTestdate.equals("") && (PCBTestdate.length() == 10)){
		    	                		Date date1=new SimpleDateFormat("YYYY.MM.DD").parse(PCBTestdate); 
		    	                		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		    	                		String dateString = format.format(date1);
		    	                		Date   date2       = format.parse (dateString);    
		    	                		pcbSample.setPcbTestDate(date2);
		    	                		}
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "PCB Test date : " + PCBTestdate);
		    	                	}
		                        	
		    	                	else if(i==42){
		    	                		EPFNumbersoftheTestGroup   = cell.getStringCellValue();
		    	                		pcbSample.setEpfNoTestGroup(EPFNumbersoftheTestGroup);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "EPF Numbers of the Test Group : " + EPFNumbersoftheTestGroup);
		    	                	}

		    	                	else{
		    	                	}
		                        	
		                        	
		                        	
		    	                	/*else if(i==1){
		    	                		nameline =  cell.getStringCellValue();
		    	                		objExisting.setLineName(nameline);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "name : " + nameline + " objN :" +objExisting.getName() );
		    		                    
		    	                	}
		    	                	
		    	                	else if(i==2){
		    	                		lineType =  cell.getStringCellValue();
		    	                		objExisting.setLineType(lineType);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "lineType : " + lineType + " objNd :" +objExisting.getLineType() );
		    		                    
		    	                	}
		    	                	else if(i==3){
		    	                		length =  cell.getStringCellValue();
		    	                		objExisting.setLength(new BigDecimal(length));
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "length : " + length + " objNc :" +objExisting.getLength() );
		    		                    
		    	                	}
		    	                	else if(i==4){
		    	                		area =  cell.getStringCellValue();
		    	                		objExisting.setArea(area);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "area : " + area + " objNd :" +objExisting.getArea() );
		    		                    
		    	                	}
		    	                	else if(i==5){
		    	                		noofpoles =  cell.getStringCellValue();
		    	                		objExisting.setNoofpoles(new BigDecimal(noofpoles));
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "noofpoles : " + noofpoles + " objNd :" +objExisting.getNoofpoles() );
		    		                    
		    	                	}
		    	                	else if(i==6){
		    	                		nooftowers =  cell.getStringCellValue();
		    	                		objExisting.setNooftowers(new BigDecimal(nooftowers));
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "nooftowers : " + nooftowers + " objNd :" +objExisting.getNooftowers() );
		    		                    
		    	                	}
		    	                	else if(i==7){
		    	                		comdate =  cell.getStringCellValue();
		    	                		DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
		    	                		java.util.Date date = format.parse(comdate);

		    	                		objExisting.setComdate(date);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "comdate : " + comdate + " objNd :" +objExisting.getComdate() );
		    		                    
		    	                	}else{
		    	                		
		    	                	}*/
		                        	System.out.println("hh : " + cell.getStringCellValue());
		                        	System.out.println("else end no : " + i);
		    	                	
		                        	i++;
		                        	System.out.println("else end no after : " + i);
		    	                	   
		                                                     break;
		                    }//end switch
		                    //addLineDao.addLine(objExisting);
			                
		                 }//end while cell iterator
		                
		                String sequence = addEquipment.getNextEquipmentId("TR");

	        			System.out.println("------------------>  " +"TR" + "_"
	        					+ sequence);

	        			String div = pcbModelObj.getPcbEquipment().getDivison();
                		
	        			
	        			String equiID = div + "_" + sequence;
	        			
	        			PcbModel pcbModel = new PcbModel();

	        			pcbEuipments.setEquipmentId(equiID);
	        			pcbEuipments.setDivison(pcbModelObj.getPcbEquipment().getDivison());
	        			pcbEuipments.setBranch(pcbModelObj.getPcbEquipment().getBranch());
	        			pcbEuipments.setUnit(pcbModelObj.getPcbEquipment().getUnit());
	        			
	        			pcbEuipments.setStatus(new BigDecimal(Util.IN_BULK));
	        			pcbCondition.setEquipmentId(equiID);
	        			pcbLocation.setEquipmentId(equiID);
	        			pcbSample.setEquipmentId(equiID);
	        			
	        			
	                    addEquipment.addEquipment(pcbEuipments);
	                    addCondition.addCondition(pcbCondition);
	                    addLocation.addLocation(pcbLocation);
	                    addSample.addSample(pcbSample);
	                    pcbModel.setPcbEquipment(pcbEuipments);
	                    pcbModel.setPcbCondition(pcbCondition);
	                    pcbModel.setPcbLocation(pcbLocation);
	                    pcbModel.setPcbSample(pcbSample);
	                    
	                    listPcbModel.add(pcbModel);
		                System.out.println("end save obj" + equiID);
		                
		            }
					fileExcel.close();
				
					//JOptionPane.showMessageDialog(null,"successfully uploaded");
					
					System.out.println("Server File Location="
							+ serverFile.getAbsolutePath());
					
					mode ="You successfully uploaded file " + name;
					

					//return "You successfully uploaded file=" + name;
				} catch (Exception e) {
					mode ="You failed to upload " + name + " => " + e.getMessage();
				}
			} else {
				mode ="You failed to upload " + name + " because the file was empty.";
			}
			PcbModel objPcb = new PcbModel();
			objPcb.setMode(mode);
			objPcb.setListPcbModel(listPcbModel);
			return new ModelAndView("uploadEquipment" ,"model",objPcb);
		}
		
		
		
		/***********************************************************************************
		 
		Input :

    		**Current location lat lon
    		**radius(distance)
    		**list of nearby lat lon

		Required Output:

    		**List of lat lon which come under the provided radius(distance) from my current location.
    		
		 ***********************************************************************************/
		
		@RequestMapping(value = "/getNearByTower", method = RequestMethod.GET)
		public @ResponseBody List<MmsAddsupport> getNearByTower(@RequestParam("lat") String lat, @RequestParam("lon") String lon, HttpServletRequest request){

		System.out.println("Starting of the getNearByTower method");

		PivModel model = new PivModel();

		int minDistance = 200;//in meters

		List<MmsAddsupport> addSup = supDao.findAll();

		System.out.println("unfiltered");
		System.out.println(addSup);

		double latCurr = Double.parseDouble(lat);
		double lngCurr = Double.parseDouble(lon);
		int Loop = addSup.size() - 1;
		
		List<MmsAddsupport>  nearTowerListNew = new ArrayList<MmsAddsupport>();
			for (int i = 0; i <= Loop; i++) {
				System.out.println("Starting of loop1");
				MmsAddsupport obj = addSup.get(i);
		
				double lat2 = Double.valueOf(obj.getGpsLatitude().toString()).doubleValue();
				double lng2 = Double.valueOf(obj.getGpsLongitude().toString()).doubleValue();
				System.out.println("distance : "+distance(latCurr, lngCurr, lat2, lng2) + " Tower No : "+obj.getTowerNo()  );
							
				
		
				if (distance(latCurr, lngCurr, lat2, lng2) <= minDistance) { // if distance <= 100 meters we take locations as equal
					nearTowerListNew.add(obj);
		
				}
		
			}
			
			return nearTowerListNew;
		
		}
		
		
		
		
		@RequestMapping(value = "/getNearByTowerTesting", method = RequestMethod.GET)
		public @ResponseBody List<MmsAddsupport> getNearByTowerTesting(@RequestParam("lat") String lat, @RequestParam("lon") String lon, HttpServletRequest request){

		System.out.println("Starting of the getNearByTower method");

		PivModel model = new PivModel();

		int minDistance = 12000;//in meters

		List<MmsAddsupport> addSup = supDao.findAll();

		System.out.println("unfiltered");
		System.out.println(addSup);

		double latCurr = Double.parseDouble(lat);
		double lngCurr = Double.parseDouble(lon);
		int Loop = addSup.size() - 1;
		
		List<MmsAddsupport>  nearTowerListNew = new ArrayList<MmsAddsupport>();
			for (int i = 0; i <= Loop; i++) {
				System.out.println("Starting of loop1");
				MmsAddsupport obj = addSup.get(i);
		
				double lat2 = Double.valueOf(obj.getGpsLatitude().toString()).doubleValue();
				double lng2 = Double.valueOf(obj.getGpsLongitude().toString()).doubleValue();
				System.out.println("distance : "+distance(latCurr, lngCurr, lat2, lng2) + " Tower No : "+obj.getTowerNo()  );
							
				
		
				if (distance(latCurr, lngCurr, lat2, lng2) <= minDistance) { // if distance <= 100 meters we take locations as equal
					nearTowerListNew.add(obj);
		
				}
		
			}
			
			return nearTowerListNew;
		
		}




		
		/** calculates the distance between two locations in meters **/
		public double distance(double lat1, double lng1, double lat2, double lng2) {

		   	 double theta = lng1 - lng2;
		     double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		     dist = Math.acos(dist);
		     dist = rad2deg(dist);
		     dist = (dist * 60 * 1.1515);
		     dist = dist * 1000;
		     return (dist);
		}

		/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
		   /*::  This function converts decimal degrees to radians             :*/
		   /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
		   private double deg2rad(double deg) {
		     return (deg * Math.PI / 180.0);
		   }

		   /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
		   /*::  This function converts radians to decimal degrees             :*/
		   /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
		   private double rad2deg(double rad) {
		     return (rad * 180.0 / Math.PI);
		   }
		
		
/*
		   @ExceptionHandler(NullPointerException.class)
		   public String handleNullException(NullPointerException ex) {

		   //ModelAndView model = new ModelAndView("admin/index");
		   //model.addObject("errMsg", "this is null Exception.class");
		   //System.out.println("Exception occured3.........");
		   //return model;
		   return "redirect:../admin/index";
		   //ModelAndView model = new ModelAndView();
		   //model.setViewName("MMS_Login");

		   
		   
		   } 
*/		   
		   
		   @RequestMapping(value = "/getHelp", method = RequestMethod.GET)
			public String getHelp(){
			   System.out.println("help");
			   return "/resources/MMS_Help.html";
		   }
		   
		   
		  /* @ExceptionHandler(NullPointerException.class)
		   public String handleNullException(NullPointerException ex) {

		   ModelAndView model = new ModelAndView();
		   model.setViewName("MMS_Login");

		   //model.addObject("errMsg", "this is null Exception.class");
		   System.out.println("Exception occured3.........");
		   //return model;
		   return "redirect:../MMS_Login";
		   } 

*/		   
		   
		   			
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
