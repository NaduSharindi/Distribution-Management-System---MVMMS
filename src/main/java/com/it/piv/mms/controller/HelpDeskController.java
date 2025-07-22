package com.it.piv.mms.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.it.piv.admin.repo.SecurityDao;
import com.it.piv.issue.domain.JobTransfer;
import com.it.piv.issue.domain.Pcmiledate;
import com.it.piv.issue.domain.PcmiledatePK;
import com.it.piv.issue.domain.PivModel;
import com.it.piv.mms.domain.MmsAddmvpole;
import com.it.piv.mms.repo.FileUploadDAO;
import com.it.piv.mms.repo.MmsAddLineDao;
import com.it.piv.mms.repo.MmsAddmvpoleDao;
import com.it.piv.mms.repo.MmsSupportDao;
import com.it.piv.mms.repo.MmsTxntowermaintenanceDao;
import com.it.piv.mms.repo.MvmmsCycleDao;
import com.it.piv.mms.repo.PcbConditionDao;
import com.it.piv.mms.repo.PcbDivisionDao;
import com.it.piv.mms.repo.PcbEquipmentDao;
import com.it.piv.mms.repo.PcbLocationDao;
import com.it.piv.mms.repo.PcbSampleDao;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



@Controller
public class HelpDeskController {
	
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

	
	@RequestMapping(value = "/uploadProgeass", method = RequestMethod.POST)
	public @ResponseBody String uploadProgeass(HttpServletRequest request,@RequestParam("file") MultipartFile file,@ModelAttribute("JobTransfer") JobTransfer pivModel) {
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
	            Pcmiledate pcmiledateObj = new Pcmiledate();
	            PcmiledatePK pcmiledateObjPk = new PcmiledatePK();
	    		
	            
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
	                    
	                	
	                	String prograss_id ="";
	                	String estimate_no ="";
	                	String current_percentage ="";
	                	String enter_date ="";
	                	String dept_id="";
	                	String prograss_name="";
	                	             		
	                	
	                	          	
	                	
	                	
	                	
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
	                        	
/*	                        		 if(i==0){
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

		                            	 */
		                             /*} else if(i==6){
		                            	 obj.setFeederNo("F1");
			    	                	obj.setCsc("461.10");	
		                             }else{
		                            	 
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


}
