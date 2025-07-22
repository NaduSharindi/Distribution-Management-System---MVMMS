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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.issue.domain.PivModel;
import com.it.piv.mms.domain.Application;
import com.it.piv.mms.domain.ApplicationPK;
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
import com.it.piv.mms.repo.FileUploadDAO;
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
	
	@RequestMapping(value = "/MMS_Map", method = RequestMethod.GET)
	public ModelAndView MMS_Map() {
		ModelAndView model = new ModelAndView();
		model.setViewName("MMS_Map");

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
		    	                		objExisting.setTowerspecial(towerspecial);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getTowerspecial() );
		    		                    
		    	                	}
		    	                	else if(i==16){
		    	                		legPainting =  cell.getStringCellValue();
		    	                		objExisting.setLegPainting(legPainting);;
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getLegPainting() );
		    		                    
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
		                
		                //objExisting.setPhmBranch(deptId);
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
			
			Map<String,String> cycle = new LinkedHashMap<String,String>();
			List<MvmmsCycle> cycleList = cycleDao.findAllActiveCycle();
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
		    	                    	//System.out.println("hh : " + cell.getStringCellValue() + "code : " + code + " objE :" +objExisting.getCode() );
		    		                    
		    	                	}else if(i==1){
		    	                		String towerNo =  cell.getStringCellValue();
		    	                		objExisting.setTowerNo(towerNo);
 
		    	                	}
		    	                	else if(i==2){
		    	                		String areaNew =  cell.getStringCellValue();
		    	                		objExisting.setArea(areaNew+".00");
		    	                	}
		    	                	
		    	                	else if(i==3){
		    	                		String conType =  cell.getStringCellValue();
		    	                		objExisting.setConductorType(new BigDecimal(conType));
		    	                	}
		    	                	else if(i==4){
		    	                		String eConTypee =  cell.getStringCellValue();
		    	                		objExisting.setEarthConductorType(new BigDecimal(eConTypee));
		    	                	}
		    	                	else if(i==5){
		    	                		String towerType =  cell.getStringCellValue();
		    	                		objExisting.setTowerType(new BigDecimal(towerType));
		    	                	}
		    	                	else if(i==6){
		    	                		String towerConf =  cell.getStringCellValue();
		    	                		objExisting.setTowerConfiguration(new BigDecimal(towerConf));
		    	                	}
		    	                	else if(i==7){
		    	                		String gpsLatitude =  cell.getStringCellValue();
		    	                		objExisting.setGpsLatitude(new BigDecimal(gpsLatitude));
		    	                	}
		    	                	else if(i==8){
		    	                		String gpsLongitude =  cell.getStringCellValue();
		    	                		objExisting.setGpsLongitude(new BigDecimal(gpsLongitude));
		    	                	}else if(i==8){
		    	                		String noOfCir =  cell.getStringCellValue();
		    	                		objExisting.setNoOfCircuits(new BigDecimal(noOfCir));
		    	                	}else if(i==10){
		    	                		String boduExt =  cell.getStringCellValue();
		    	                		objExisting.setBodyExtension(boduExt);
		    	                	}else if(i==11){
		    	                		String lineID =  cell.getStringCellValue();
		    	                		objExisting.setLineId(new BigDecimal(lineID));
		    	                	}else{
		    	                			    	                		
		    	                	}
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
		                addSupportDao.addSupport(objExisting);
		                objExisting = new MmsAddsupport();
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
		public ModelAndView  uploadEqui(HttpServletRequest request,@RequestParam("file") MultipartFile file,@ModelAttribute("pivModel") PivModel pivModel) {
			
			
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
		    	                		pcbEuipments.setDivison(division);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Division : " + division);
		    	                	}
		    	                	
		    	                	else if(i==2){
		    	                		area  =  cell.getStringCellValue();
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Area : " + area);
		    		                    
		    	                	}
		                        	 
		    	                	else if(i==3){
		    	                		branch  =  cell.getStringCellValue();
		    	                		pcbEuipments.setBranch(branch);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Branch  : " + branch);
		    	                	}
		                        	 
		    	                	else if(i==4){
		    	                		unit =  cell.getStringCellValue();
		    	                		pcbEuipments.setUnit(unit);
		    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Unit : " + unit);
		    		                   
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

	        			String equiID = "TR" + "_" + sequence;
	        			
	        			PcbModel pcbModel = new PcbModel();

	        			pcbEuipments.setEquipmentId(equiID);
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
		
		
		



}
