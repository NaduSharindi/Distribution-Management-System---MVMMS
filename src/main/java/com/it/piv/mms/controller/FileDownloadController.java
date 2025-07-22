package com.it.piv.mms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//import org.apache.commons.io;





import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleHtmlReportConfiguration;

import org.apache.cxf.helpers.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.it.piv.issue.domain.PivModel;
import com.it.piv.issue.repo.JasperDao;
import com.it.piv.mms.domain.ApprovalMm;
import com.it.piv.mms.domain.MmsAddfeeder;
import com.it.piv.mms.domain.MmsAddgantry;
import com.it.piv.mms.domain.MmsAddsupport;
import com.it.piv.mms.domain.MmsAddswitch;
import com.it.piv.mms.domain.MmsTxntowermaintenance;
import com.it.piv.mms.domain.MmsTxntowermaintenancePK;
import com.it.piv.mms.repo.ApprovalMmDao;
import com.it.piv.mms.repo.GldeptmDao;
import com.it.piv.mms.repo.MMSAddgantryDao;
import com.it.piv.mms.repo.MmsAddFeederDao;
import com.it.piv.mms.repo.MmsAddSwitchDao;
import com.it.piv.mms.repo.MmsSupportDao;
import com.it.piv.mms.repo.MmsTxntowermaintenanceDao;
import com.it.piv.util.common.PathMMS;

@Controller
public class FileDownloadController {
	
	
	@Autowired
	private GldeptmDao gldeptDao;
	
	
	@Autowired
	private JasperDao jasperDao;
	
	@Autowired
	private ApprovalMmDao appDao;
	
	@Autowired
	private MMSAddgantryDao gantryDao;
	
	
	@Autowired
	private MmsAddFeederDao feederDao;
	
	@Autowired
	private MmsAddSwitchDao switchDao;
	
	
	@Autowired
	private MmsSupportDao supportDao;
	
	@Autowired
	private MmsTxntowermaintenanceDao towerTxtMaintenance;
	
	
	@RequestMapping("/downloadAPK")
    public void downloadPDFResource( HttpServletRequest request,
                                     HttpServletResponse response)
    {
        
		System.out.println("download APK");
		//If user is not authorized - he should be thrown out from here itself
         
        //Authorized user will download the file
		
		String path1 = PathMMS.getReportPath() + File.separator + "Reports" +File.separator+ "MVMMS.apk" ;
		File dir1 = new File(path1 + File.separator + "Reports");
		if (!dir1.exists())
			dir1.mkdirs();
		String fileName = "MVMMS.apk";
		System.out.println("download APK");
		
		File file = new File(path1);
		
		
        //String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/MVMMS.apk");
		// dataDirectory = request.getSession().getServletContext().getRealPath("/jasper/");
        //Path file = Paths.get(dataDirectory, fileName);
        //System.out.println("download APK 1" +path1 );
		
        if (file.exists())
        {
        	
        	
        	
            try {
            	response.setContentType("application/apk");
            	 response.addHeader("Content-Disposition", "attachment; filename="+fileName);
                 
            	InputStream inputStream = new FileInputStream(new File(path1)); //load the file
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	/*byte[] bytesArray = new byte[(int) file.length()];
        	System.out.println("download APK 2");
        	response.reset();
        	response.resetBuffer();
        	response.setContentType("application/apk");
        	response.setContentLength(bytesArray.length);
    		
            //response.setContentType("application/apk");
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            System.out.println("download APK 3");
    		
            try
            {
            	ServletOutputStream ouputStream = response.getOutputStream();
            	//ouputStream.
    			ouputStream.write(bytesArray, 0, bytesArray.length);
    			ouputStream.flush();
    			ouputStream.close();
    			
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }*/

        }
    }
	
	
	
	@RequestMapping("/downloadIntSum")
    public void downloadIntSum( HttpServletRequest request,
                                     HttpServletResponse response)
    {
        
		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
		String pdfPath ="";
		String pdfName = "";
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
				
				/*pdfPath = path2 + "/INTTERUPTION REQUEST SUMMARY-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ ".pdf";
				*/		
				pdfPath = "INTERRUPTION REQUEST SUMMARY-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ ".pdf";
				
				File pdfFile = new File(path2 + File.separator + pdfPath);
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

		
 }
	
	
	
	
	@RequestMapping("/downloadIntSumReport")
    public void downloadIntSumReport( HttpServletRequest request,
                                     HttpServletResponse response,@RequestParam("area") String area,@RequestParam("from") String from,@RequestParam("to") String to )
    {
        
		System.out.println("area : "+area);
		System.out.println("from : "+from);
		System.out.println("to : "+to);
		String userName =(String)request.getSession().getAttribute("loggedUser");
		
		
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
				
				File pdfFile = new File(path2 + File.separator + pdfPath);
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

		
 }
	
	
	@RequestMapping("/downloadIntSumReportCC")
    public void downloadIntSumReportCC( HttpServletRequest request,
                                     HttpServletResponse response,@RequestParam("area") String area,@RequestParam("from") String from,@RequestParam("to") String to )
    {
        
		System.out.println("area : "+area);
		System.out.println("from : "+from);
		System.out.println("to : "+to);
		String userName =(String)request.getSession().getAttribute("loggedUser");
		
		
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
				
				File pdfFile = new File(path2 + File.separator + pdfPath);
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

		
 }
	
	
	
	@RequestMapping("/downloadIntSumReportCCNew")
    public void downloadIntSumReportCCNew( HttpServletRequest request,HttpServletResponse response,@RequestParam("cycle") String cycle )
    {
        
		String userName =(String)request.getSession().getAttribute("loggedUser");
		//String userLevel =(String)request.getSession().getAttribute("loggedUser");
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		 
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
        
		
		
        List<String> strList = new LinkedList<String>();
		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
		String pdfPath ="";
		String pdfName = "";
		Connection conn = null;
		
		try {
			
			try {
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				conn = jasperDao.getConnection();
				hmParams.put("@status", "'"+status+"'");
				hmParams.put("@cycle", "'"+userName.trim()+"'");
				
				
				File file = new File(path1 + "/" + "INT_REQ_SUM_CCR_COMMON" + ".jrxml" );
			        
			        if(!file.exists())
			            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

			    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "INT_REQ_SUM_CCR_COMMON" + ".jrxml");
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
				
				File pdfFile = new File(path2 + File.separator + pdfPath);
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

		
 }
	
	
	
	
	@RequestMapping("/downloadSingleLineDiagram")
    public void downloadSingleLineDiagram( HttpServletRequest request,HttpServletResponse response,@RequestParam("id") String id )
    {
        
		String userName =(String)request.getSession().getAttribute("loggedUser");
		//String userLevel =(String)request.getSession().getAttribute("loggedUser");
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		HashMap<String, Object> hmParams = new HashMap<String, Object>();
		System.out.println("id"+ id);
		String gantryName = "";
		MmsAddgantry  gantry =  gantryDao.findById(Long.valueOf(id));
		if(gantry != null){
			gantryName = gantry.getName();
			hmParams.put("name", "'"+gantryName+"'");
			List<MmsAddfeeder> feederList = feederDao.getFeederByGantryIdType(id,"1");
			System.out.println("feeder id : "+ id);
			
			if(feederList != null){
				int x = feederList.size();
				System.out.println("feeder size : "+ x);
				
				if(x>0){
					for(int i = 0 ; i < x ;i++){
						System.out.println("feeder i : "+ i);
						
						MmsAddfeeder feeder =  feederList.get(i);
							
							if(i==0){
								System.out.println(" in feeder name 1 : "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming1",feeder.getCode());
								//hmParams.put("InComingFeeder1", "'"+request.getSession().getAttribute("feederincoming1") +"'");
								hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() +"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("InComingFeeder1LBS", "'"+sDetails+"'");
									
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									//String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode();
											//sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
										//hmParams.put("InComingFeeder2LBS", "'"+sDetails+"'");
										
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode();
										}
									}
								}
								
								
									
								hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + switchDetail +   "'");
									
									
									
									
								}
								
							
							if(i==1){
								System.out.println("in in feeder name 2: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming2",feeder.getCode());
								
								//hmParams.put("InComingFeeder2", "'"+request.getSession().getAttribute("feederincoming2")+"'");
								hmParams.put("InComingFeeder2", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();

										}
									}
									hmParams.put("InComingFeeder2LBS", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode();
										}
									}
								}
								
								
									
								hmParams.put("InComingFeeder2", "'"+feeder.getCode()+"\n"+feeder.getName() + switchDetail +   "'");
							
								
							}if(i==2){
								System.out.println("in feeder name 3: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming3",feeder.getCode());
								
								//hmParams.put("InComingFeeder3", "'"+request.getSession().getAttribute("feederincoming3")+"'");
								hmParams.put("InComingFeeder3", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode();
										}
									}
								}
								
								
									
								hmParams.put("InComingFeeder3", "'"+feeder.getCode()+"\n"+feeder.getName() + switchDetail +   "'");
							
								
							}if(i==3){
								System.out.println("in feeder name 4: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming4",feeder.getCode());
								
								//hmParams.put("InComingFeeder4", "'"+request.getSession().getAttribute("feederincoming4")+"'");
								hmParams.put("InComingFeeder4", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode();
										}
									}
								}
								
								
									
								hmParams.put("InComingFeeder4", "'"+feeder.getCode()+"\n"+feeder.getName() + switchDetail +   "'");
							
								
								
							}if(i==4){
								System.out.println("in feeder name 5: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming5",feeder.getCode());
								
								//hmParams.put("InComingFeeder5", "'"+request.getSession().getAttribute("feederincoming5")+"'");
								hmParams.put("InComingFeeder5", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode();
										}
									}
								}
								
								
									
								hmParams.put("InComingFeeder5", "'"+feeder.getCode()+"\n"+feeder.getName() + switchDetail +   "'");
							
								
								
							}if(i==5){
								System.out.println(" in feeder name 6: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming6",feeder.getCode());
								hmParams.put("InComingFeeder6", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								
								//hmParams.put("InComingFeeder6", "'"+request.getSession().getAttribute("feederincoming6")+"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode();
										}
									}
								}
								
								
									
								hmParams.put("InComingFeeder6", "'"+feeder.getCode()+"\n"+feeder.getName() + switchDetail +   "'");
							
								
							}
							
							
					}
				}
			}
							
						
			
			
			
			List<MmsAddfeeder> feederListOutgoing = feederDao.getFeederByGantryIdType(id,"2");
			System.out.println("feeder id : "+ id);
			
			if(feederListOutgoing != null){
				int x = feederListOutgoing.size();
				System.out.println("feeder size : "+ x);
				
				if(x>0){
					for(int i = 0 ; i < x ;i++){
						System.out.println("feeder i : "+ i);
						
						MmsAddfeeder feeder =  feederListOutgoing.get(i);
						
						 	
							if(i==0){
								System.out.println("feeder name 1 : "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming1",feeder.getCode());
								//hmParams.put("InComingFeeder1", "'"+request.getSession().getAttribute("feederincoming1") +"'");
								hmParams.put("parameter1", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetail="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode();
											sDetail= sDetail + "\n " + obj.getSwitchCode();
										}
									}
									
									hmParams.put("parameter1AR", "'"+ sDetail+  "'");
									
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetail="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode();
											sDetail= sDetail + "\n " + obj.getSwitchCode();
										}
									}
									hmParams.put("parameter1ABS", "'"+ sDetail+  "'");
									
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetail="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode();
											sDetail= sDetail + "\n " + obj.getSwitchCode();

										}
									}
									hmParams.put("parameter1DDLO", "'"+ sDetail+  "'");
									
								}
								
								
									
								hmParams.put("parameter1", "'"+feeder.getCode()+"\n"+feeder.getName() + switchDetail +   "'");
							
								
							}
							if(i==1){
								System.out.println("feeder name 2: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming2",feeder.getCode());
								
								//hmParams.put("InComingFeeder2", "'"+request.getSession().getAttribute("feederincoming2")+"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter2AR", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter2ABS", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter2DDLO", "'"+sDetails+"'");
								}
								
								
									
								hmParams.put("parameter2", "'"+feeder.getCode()+"\n"+feeder.getName() + switchDetail +   "'");
							
							}if(i==2){
								System.out.println("feeder name 3: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming3",feeder.getCode());
								
								//hmParams.put("InComingFeeder3", "'"+request.getSession().getAttribute("feederincoming3")+"'");
								//hmParams.put("parameter3", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter3AR", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter3ABS", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter3DDLO", "'"+sDetails+"'");
								}
								
								
									
								hmParams.put("parameter3", "'"+feeder.getCode()+"\n"+feeder.getName() + switchDetail +   "'");
							
								
							}if(i==3){
								System.out.println("feeder name 4: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming4",feeder.getCode());
								
								//hmParams.put("InComingFeeder4", "'"+request.getSession().getAttribute("feederincoming4")+"'");
								//hmParams.put("parameter4", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();

										}
									}
									hmParams.put("parameter4AR", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter4ABS", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter4DDLO", "'"+sDetails+"'");

								}
								
								
									
								hmParams.put("parameter4", "'"+feeder.getCode()+"\n"+feeder.getName() + switchDetail +   "'");
							
								
							}if(i==4){
								System.out.println("feeder name 5: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming5",feeder.getCode());
								
								//hmParams.put("InComingFeeder5", "'"+request.getSession().getAttribute("feederincoming5")+"'");
								//hmParams.put("parameter5", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR: " + obj.getSwitchCode();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter5AR", "'"+sDetails+"'");

								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter5ABS", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter5DDLO", "'"+sDetails+"'");
								}
								
								
									
								hmParams.put("parameter5", "'"+feeder.getCode()+"\n"+feeder.getName() + switchDetail +   "'");
							
								
							}if(i==5){
								System.out.println("feeder name 6: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming6",feeder.getCode());
								//hmParams.put("outgoingfeeder6", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								
								//hmParams.put("InComingFeeder6", "'"+request.getSession().getAttribute("feederincoming6")+"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter6ABS", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter6ABS", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter6DDLO", "'"+sDetails+"'");
								}
								
								
									
								hmParams.put("outgoingfeeder6", "'"+feeder.getCode()+"\n"+feeder.getName() + switchDetail +   "'");
							
							}
							
							
							
							
						
					
						
					}
				}
				
				
			}
			
		}
		
        List<String> strList = new LinkedList<String>();
		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
		String pdfPath ="";
		String pdfName = "";
		Connection conn = null;
		
		try {
			
			try {
				conn = jasperDao.getConnection();
				//hmParams.put("@status", "'"+status+"'");
				//hmParams.put("@cycle", "'"+userName.trim()+"'");
				
				
				File file = new File(path1 + "/" + "GANTRYSINGLELINE" + ".jrxml" );
			        
			        if(!file.exists())
			            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

			    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "GANTRYSINGLELINE" + ".jrxml");
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
 				JRPdfExporter pdf = new JRPdfExporter();

				Calendar calendar = Calendar.getInstance();
				 
				pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
				
				/*pdfPath = path2 + "/INTERRUPTION REQUEST SUMMARY-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ ".pdf";
						
				pdfPath = "INTERRUPTION REQUEST SUMMARY-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ ".pdf";
				*/
				
				pdfPath ="Single_Line_Diagram.pdf";
				File pdfFile = new File(path2 + File.separator + pdfPath);
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

		
 }
	
	
	
	
	@RequestMapping("/downloadSingleLineDiagramWithId")
    public void downloadSingleLineDiagramWithId( HttpServletRequest request,HttpServletResponse response,@RequestParam("id") String id )
    {
        
		String userName =(String)request.getSession().getAttribute("loggedUser");
		//String userLevel =(String)request.getSession().getAttribute("loggedUser");
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		HashMap<String, Object> hmParams = new HashMap<String, Object>();
		System.out.println("id"+ id);
		String gantryName = "";
		MmsAddgantry  gantry =  gantryDao.findById(Long.valueOf(id));
		if(gantry != null){
			gantryName = gantry.getName();
			hmParams.put("name", "'"+gantryName + " ID : " +gantry.getId()+"'");
			List<MmsAddfeeder> feederList = feederDao.getFeederByGantryIdType(id,"1");
			System.out.println("feeder id : "+ id);
			
			if(feederList != null){
				int x = feederList.size();
				System.out.println("feeder size : "+ x);
				
				if(x>0){
					for(int i = 0 ; i < x ;i++){
						System.out.println("feeder i : "+ i);
						
						MmsAddfeeder feeder =  feederList.get(i);
							
							if(i==0){
								System.out.println(" in feeder name 1 : "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming1",feeder.getCode());
								//hmParams.put("InComingFeeder1", "'"+request.getSession().getAttribute("feederincoming1") +"'");
								hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() +"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode() + " ID:" + obj.getId().getSwitchId();
											sDetails = sDetails + "\n " +  obj.getSwitchCode() + " ID:" + obj.getId().getSwitchId();
										}
									}
									hmParams.put("InComingFeeder1LBS", "'"+sDetails+"'");
									
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									//String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode() + " ID:" + obj.getId().getSwitchId();
											//sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
										//hmParams.put("InComingFeeder2LBS", "'"+sDetails+"'");
										
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								
									
								hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " ID : " + feeder.getId().getFeederId() + switchDetail +   "'");
									
									
									
									
								}
								
							
							if(i==1){
								System.out.println("in in feeder name 2: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming2",feeder.getCode());
								
								//hmParams.put("InComingFeeder2", "'"+request.getSession().getAttribute("feederincoming2")+"'");
								hmParams.put("InComingFeeder2", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode() + " ID:" + obj.getId().getSwitchId();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();

										}
									}
									hmParams.put("InComingFeeder2LBS", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								
									
								hmParams.put("InComingFeeder2", "'"+feeder.getCode()+"\n"+feeder.getName() + " ID :"+ feeder.getId().getFeederId() + switchDetail +   "'");
							
								
							}if(i==2){
								System.out.println("in feeder name 3: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming3",feeder.getCode());
								
								//hmParams.put("InComingFeeder3", "'"+request.getSession().getAttribute("feederincoming3")+"'");
								hmParams.put("InComingFeeder3", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								
									
								hmParams.put("InComingFeeder3", "'"+feeder.getCode()+"\n"+feeder.getName() + " ID : " + feeder.getId().getFeederId() + switchDetail +   "'");
							
								
							}if(i==3){
								System.out.println("in feeder name 4: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming4",feeder.getCode());
								
								//hmParams.put("InComingFeeder4", "'"+request.getSession().getAttribute("feederincoming4")+"'");
								hmParams.put("InComingFeeder4", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								
									
								hmParams.put("InComingFeeder4", "'"+feeder.getCode()+"\n"+feeder.getName() + " ID : " + feeder.getId().getFeederId() + switchDetail +   "'");
							
								
								
							}if(i==4){
								System.out.println("in feeder name 5: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming5",feeder.getCode());
								
								//hmParams.put("InComingFeeder5", "'"+request.getSession().getAttribute("feederincoming5")+"'");
								hmParams.put("InComingFeeder5", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								
									
								hmParams.put("InComingFeeder5", "'"+feeder.getCode()+"\n"+feeder.getName() + "ID :" + feeder.getId().getFeederId()+ switchDetail +   "'");
							
								
								
							}if(i==5){
								System.out.println(" in feeder name 6: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming6",feeder.getCode());
								hmParams.put("InComingFeeder6", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								
								//hmParams.put("InComingFeeder6", "'"+request.getSession().getAttribute("feederincoming6")+"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								
									
								hmParams.put("InComingFeeder6", "'"+feeder.getCode()+"\n"+feeder.getName()+ " ID: "+ feeder.getId().getFeederId() + switchDetail +   "'");
							
								
							}
							
							
					}
				}
			}
							
						
			
			
			
			List<MmsAddfeeder> feederListOutgoing = feederDao.getFeederByGantryIdType(id,"2");
			System.out.println("feeder id : "+ id);
			
			if(feederListOutgoing != null){
				int x = feederListOutgoing.size();
				System.out.println("feeder size : "+ x);
				
				if(x>0){
					for(int i = 0 ; i < x ;i++){
						System.out.println("feeder i : "+ i);
						
						MmsAddfeeder feeder =  feederListOutgoing.get(i);
						
						 	
							if(i==0){
								System.out.println("feeder name 1 : "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming1",feeder.getCode());
								//hmParams.put("InComingFeeder1", "'"+request.getSession().getAttribute("feederincoming1") +"'");
								hmParams.put("parameter1", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetail="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetail= sDetail + "\n " + obj.getSwitchCode();
										}
									}
									
									hmParams.put("parameter1AR", "'"+ sDetail+  "'");
									
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetail="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetail= sDetail + "\n " + obj.getSwitchCode();
										}
									}
									hmParams.put("parameter1ABS", "'"+ sDetail+  "'");
									
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetail="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetail= sDetail + "\n " + obj.getSwitchCode();

										}
									}
									hmParams.put("parameter1DDLO", "'"+ sDetail+  "'");
									
								}
								
								
									
								hmParams.put("parameter1", "'"+feeder.getCode()+"\n"+feeder.getName() + " ID : " + feeder.getId().getFeederId() + switchDetail +   "'");
							
								
							}
							if(i==1){
								System.out.println("feeder name 2: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming2",feeder.getCode());
								
								//hmParams.put("InComingFeeder2", "'"+request.getSession().getAttribute("feederincoming2")+"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter2AR", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter2ABS", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter2DDLO", "'"+sDetails+"'");
								}
								
								
									
								hmParams.put("parameter2", "'"+feeder.getCode()+"\n"+feeder.getName() + " ID :"+ feeder.getName() + switchDetail +   "'");
							
							}if(i==2){
								System.out.println("feeder name 3: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming3",feeder.getCode());
								
								//hmParams.put("InComingFeeder3", "'"+request.getSession().getAttribute("feederincoming3")+"'");
								//hmParams.put("parameter3", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter3AR", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter3ABS", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter3DDLO", "'"+sDetails+"'");
								}
								
								
									
								hmParams.put("parameter3", "'"+feeder.getCode()+"\n"+feeder.getName() +" ID :" + feeder.getId().getFeederId() + switchDetail +   "'");
							
								
							}if(i==3){
								System.out.println("feeder name 4: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming4",feeder.getCode());
								
								//hmParams.put("InComingFeeder4", "'"+request.getSession().getAttribute("feederincoming4")+"'");
								//hmParams.put("parameter4", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();

										}
									}
									hmParams.put("parameter4AR", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter4ABS", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter4DDLO", "'"+sDetails+"'");

								}
								
								
									
								hmParams.put("parameter4", "'"+feeder.getCode()+"\n"+feeder.getName() + " ID : "+ feeder.getId().getFeederId() + switchDetail +   "'");
							
								
							}if(i==4){
								System.out.println("feeder name 5: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming5",feeder.getCode());
								
								//hmParams.put("InComingFeeder5", "'"+request.getSession().getAttribute("feederincoming5")+"'");
								//hmParams.put("parameter5", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR: " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter5AR", "'"+sDetails+"'");

								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter5ABS", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter5DDLO", "'"+sDetails+"'");
								}
								
								
									
								hmParams.put("parameter5", "'"+feeder.getCode()+"\n"+feeder.getName() + "ID : "+ feeder.getId().getFeederId() + switchDetail +   "'");
							
								
							}if(i==5){
								System.out.println("feeder name 6: "+ feeder.getCode());
								//request.getSession().setAttribute("feederincoming6",feeder.getCode());
								//hmParams.put("outgoingfeeder6", "'"+feeder.getCode() +"\n"+feeder.getName() +"'");
								
								//hmParams.put("InComingFeeder6", "'"+request.getSession().getAttribute("feederincoming6")+"'");
								String switchDetail="";
								List<MmsAddswitch> swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "2", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n LBS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
										}
									}
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "1", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n AR : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter6ABS", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "3", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n ABS : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter6ABS", "'"+sDetails+"'");
								}
								
								swithObj = switchDao.getSwitchByFeederId(feeder.getId().getFeederId(), "4", "1");
								if(swithObj!= null){
									int y = swithObj.size();
									System.out.println("swithObj size : "+ y);
									String sDetails ="";
									
									if(x>0){
										for(int a = 0 ; a < y ;a++){
											System.out.println("swithObj a : "+ a);
											MmsAddswitch obj =  swithObj.get(a);
											//hmParams.put("InComingFeeder1", "'"+feeder.getCode()+"\n"+feeder.getName() + " \n LBS : " + obj.getSwitchCode() +   "'");
											switchDetail = switchDetail +"\n DDLO : " + obj.getSwitchCode()+ " ID:" + obj.getId().getSwitchId();
											sDetails = sDetails + "\n " +  obj.getSwitchCode();
										}
									}
									hmParams.put("parameter6DDLO", "'"+sDetails+"'");
								}
								
								
									
								hmParams.put("outgoingfeeder6", "'"+feeder.getCode()+"\n"+feeder.getName() + "ID : "+ feeder.getId().getFeederId() + switchDetail +   "'");
							
							}
							
							
							
							
						
					
						
					}
				}
				
				
			}
			
		}
		
        List<String> strList = new LinkedList<String>();
		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
		String pdfPath ="";
		String pdfName = "";
		Connection conn = null;
		
		try {
			
			try {
				conn = jasperDao.getConnection();
				//hmParams.put("@status", "'"+status+"'");
				//hmParams.put("@cycle", "'"+userName.trim()+"'");
				
				
				File file = new File(path1 + "/" + "GANTRYSINGLELINE" + ".jrxml" );
			        
			        if(!file.exists())
			            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

			    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "GANTRYSINGLELINE" + ".jrxml");
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
 				JRPdfExporter pdf = new JRPdfExporter();

				Calendar calendar = Calendar.getInstance();
				 
				pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
				
				/*pdfPath = path2 + "/INTERRUPTION REQUEST SUMMARY-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ ".pdf";
						
				pdfPath = "INTERRUPTION REQUEST SUMMARY-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ ".pdf";
				*/
				
				pdfPath ="Single_Line_Diagram.pdf";
				File pdfFile = new File(path2 + File.separator + pdfPath);
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

		
 }


	
	
	@RequestMapping("/downloadIntSumReportCCNewPhm")
    public void downloadIntSumReportCCNewPhm( HttpServletRequest request,HttpServletResponse response,@RequestParam("cycle") String cycle )
    {
        
		String userName =(String)request.getSession().getAttribute("loggedUser");
		//String userLevel =(String)request.getSession().getAttribute("loggedUser");
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		 
		String status = "51";
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
		
		
        List<String> strList = new LinkedList<String>();
		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
		String pdfPath ="";
		String pdfName = "";
		Connection conn = null;
		
		try {
			
			try {
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				conn = jasperDao.getConnection();
				hmParams.put("@status", "'"+status+"'");
				hmParams.put("@cycle", "'"+cycle.trim()+"'");
				
				
				File file = new File(path1 + "/" + "INT_REQ_SUM_CCR_COMMON" + ".jrxml" );
			        
			        if(!file.exists())
			            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

			    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "INT_REQ_SUM_CCR_COMMON" + ".jrxml");
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
 				JRPdfExporter pdf = new JRPdfExporter();

				Calendar calendar = Calendar.getInstance();
				 
				pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
				
				/*pdfPath = path2 + "/INTERRUPTION REQUEST SUMMARY-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ ".pdf";
						
				pdfPath = "View-Interruption-Schedule-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ ".pdf";
				*/
				
				pdfPath = "View-Interruption-Schedule-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ ".pdf";
				
				
				String excelPath ="View-Interruption-Schedule.pdf";
				
				File pdfFile = new File(path2 + File.separator + pdfPath);
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

		
 }
	
	
	
	
	
	
	
	
	
	@RequestMapping("/downloadIntSumReportCCNewPhmExcel")
    public void downloadIntSumReportCCNewPhmExcel( HttpServletRequest request,HttpServletResponse response,@RequestParam("cycle") String cycle )
    {
        
		String userName =(String)request.getSession().getAttribute("loggedUser");
		//String userLevel =(String)request.getSession().getAttribute("loggedUser");
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		 
		String status = "51";
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
		
		
        List<String> strList = new LinkedList<String>();
		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
		String pdfPath ="";
		String pdfName = "";
		Connection conn = null;
		
		try {
			
			try {
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				conn = jasperDao.getConnection();
				hmParams.put("@status", "'"+status+"'");
				hmParams.put("@cycle", "'"+cycle.trim()+"'");
				
				
				File file = new File(path1 + "/" + "INT_REQ_SUM_CCR_COMMON" + ".jrxml" );
			        
			        if(!file.exists())
			            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

			    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "INT_REQ_SUM_CCR_COMMON" + ".jrxml");
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
 				//JRPdfExporter pdf = new JRPdfExporter();

				Calendar calendar = Calendar.getInstance();
				 
				//pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
				String excelPath = "View-Interruption-Schedule-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ ".xlsx";
				
				
				//String excelPath ="View-Interruption-Schedule.xls";
				
			    File excelFile = new File(path2 + File.separator + excelPath);
				System.out.println("excelPath" +excelPath );
				
			    
				JRXlsxExporter Xlsxexporter = new JRXlsxExporter();

				Xlsxexporter.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
							
				Xlsxexporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	            Xlsxexporter.setParameter(JRExporterParameter.OUTPUT_FILE, excelFile);
	            Xlsxexporter.exportReport();//File is generated Correctly

				
				if (excelFile.exists())
		        {
		            try {
		            	//response.setContentType("application/pdf");
		            	response.setContentType("application/vnd.ms-excel");

		            	response.setHeader("Content-Disposition", "attachment; filename=View_Interruption_Schedule.xlsx"); //This is downloaded as .xhtml
		                 
		            	InputStream inputStream = new FileInputStream(excelFile); //load the file
						IOUtils.copy(inputStream, response.getOutputStream());
						response.flushBuffer();
						
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

		
 }



	
	
	@RequestMapping("/downloadIntSumReportCCExcel")
    public void downloadIntSumReportCCExcel( HttpServletRequest request,
                                     HttpServletResponse response,@RequestParam("area") String area,@RequestParam("from") String from,@RequestParam("to") String to )
    {
        
		System.out.println("area : "+area);
		System.out.println("from : "+from);
		System.out.println("to : "+to);
		String userName =(String)request.getSession().getAttribute("loggedUser");
		
		
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
		String excelPath ="INT_SCHEDULE.xlsx";
		Connection conn = null;
		
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
 				//JRPdfExporter pdf = new JRPdfExporter();
 	            JRXlsxExporter Xlsxexporter = new JRXlsxExporter();

 	            

				Calendar calendar = Calendar.getInstance();
				 
				//Xlsxexporter.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
				
				
				File excelFile = new File(path2 + File.separator + excelPath);
				System.out.println("excelPath" +excelPath );
				
				Xlsxexporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	            Xlsxexporter.setParameter(JRExporterParameter.OUTPUT_FILE, excelFile);
	            Xlsxexporter.exportReport();//File is generated Correctly
				if (excelFile.exists())
		        {
		            try {
		            	//response.setContentType("application/pdf");
		            	response.setContentType("application/vnd.ms-excel");

		            	response.setHeader("Content-Disposition", "attachment; filename=INT_SCHEDULE.xlsx"); //This is downloaded as .xhtml
		                 
		            	InputStream inputStream = new FileInputStream(excelFile); //load the file
						IOUtils.copy(inputStream, response.getOutputStream());
						response.flushBuffer();
						
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

		
 }
	
	@RequestMapping("/downloadIntSumReportCCExcelAdd")
    public void downloadIntSumReportCCExcelAdd( HttpServletRequest request,
                                     HttpServletResponse response,@RequestParam("area") String area,@RequestParam("from") String from,@RequestParam("to") String to )
    {
        
		System.out.println("area : "+area);
		System.out.println("from : "+from);
		System.out.println("to : "+to);
		String userName =(String)request.getSession().getAttribute("loggedUser");
		
		
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
		String excelPath ="INT_SCHEDULE.xlsx";
		Connection conn = null;
		
		try {
			
			try {
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				conn = jasperDao.getConnection();
				hmParams.put("@area", ""+sss+"");
				hmParams.put("@fromDate", "'"+from+"'");
				hmParams.put("@toDate", "'"+to+"'");
				hmParams.put("@ee", "'"+userName.trim()+"'");
				
				
				File file = new File(path1 + "/" + "INT_REQ_SUM_ADD" + ".jrxml" );
			        
			        if(!file.exists())
			            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

			    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "INT_REQ_SUM_ADD" + ".jrxml");
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
 				//JRPdfExporter pdf = new JRPdfExporter();
 	            JRXlsxExporter Xlsxexporter = new JRXlsxExporter();

 	            

				Calendar calendar = Calendar.getInstance();
				 
				//Xlsxexporter.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
				
				
				File excelFile = new File(path2 + File.separator + excelPath);
				System.out.println("excelPath" +excelPath );
				
				Xlsxexporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	            Xlsxexporter.setParameter(JRExporterParameter.OUTPUT_FILE, excelFile);
	            Xlsxexporter.exportReport();//File is generated Correctly
				if (excelFile.exists())
		        {
		            try {
		            	//response.setContentType("application/pdf");
		            	response.setContentType("application/vnd.ms-excel");

		            	response.setHeader("Content-Disposition", "attachment; filename=INT_SCHEDULE.xlsx"); //This is downloaded as .xhtml
		                 
		            	InputStream inputStream = new FileInputStream(excelFile); //load the file
						IOUtils.copy(inputStream, response.getOutputStream());
						response.flushBuffer();
						
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

		
 }




	

	
	
	
	@RequestMapping("/maintenancePlan2021")
    public void maintenancePlan2021( HttpServletRequest request,
                                     HttpServletResponse response)
    {
		String deptid =(String)request.getSession().getAttribute("deptId");
		
		String fileName ="";
		if(deptid.equalsIgnoreCase("600.41")){
			fileName = "Plan2020DD2.xlsx";
		}else if (deptid.equalsIgnoreCase("596.00")){
		    fileName = "Plan2021DD1.pdf";
		}
		System.out.println("fileName : "+ fileName);
		
		
		String path1 = PathMMS.getReportPath() + File.separator + "Reports" +File.separator+ fileName ;
		File dir1 = new File(path1 + File.separator + "Reports");
		if (!dir1.exists())
			dir1.mkdirs();
		File file = new File(path1);
		if (file.exists())
        {
           try {
            	response.setContentType("application/octet-stream");
            	response.addHeader("Content-Disposition", "attachment; filename="+fileName);
                 
            	InputStream inputStream = new FileInputStream(new File(path1)); //load the file
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
	@RequestMapping("/downloadPlan")
    public void downloadPlan( HttpServletRequest request,
                                     HttpServletResponse response)
    {
		String deptid =(String)request.getSession().getAttribute("deptId");
		
		String fileName ="";
		if(deptid.equalsIgnoreCase("600.41")){
			fileName = "Plan2020DD2.xlsx";
		}else if (deptid.equalsIgnoreCase("596.00")){
		    fileName = "Plan2020DD1.pdf";
		}
		System.out.println("fileName : "+ fileName);
		
		
		String path1 = PathMMS.getReportPath() + File.separator + "Reports" +File.separator+ fileName ;
		File dir1 = new File(path1 + File.separator + "Reports");
		if (!dir1.exists())
			dir1.mkdirs();
		File file = new File(path1);
		if (file.exists())
        {
           try {
            	response.setContentType("application/octet-stream");
            	response.addHeader("Content-Disposition", "attachment; filename="+fileName);
                 
            	InputStream inputStream = new FileInputStream(new File(path1)); //load the file
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }


	
	
	
	@RequestMapping("/downloadInterruptionReq")
    public void downloadInterruptionReq(@RequestParam("id") String id ,HttpServletRequest request,
                                     HttpServletResponse response)
    {
        
		System.out.println("download APK");
		//If user is not authorized - he should be thrown out from here itself
		
        //Authorized user will download the file
		
		String path1 = PathMMS.getReportPath() + File.separator + "Reports" +File.separator+ id + ".pdf" ;
		File dir1 = new File(path1 + File.separator + "Reports");
		if (!dir1.exists())
			dir1.mkdirs();
		String fileName = id +".pdf";
		System.out.println("download APK");
		
		File file = new File(path1);
		if (file.exists())
        {
        	
        	
        	
            try {
            	response.setContentType("application/pdf");
            	//response.addHeader("Content-Disposition", "attachment; filename="+fileName);
                 
            	InputStream inputStream = new FileInputStream(new File(path1)); //load the file
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
	
	@RequestMapping("/downloadOrderCard")
    public void downloadOrderCard(@RequestParam("id") String id ,HttpServletRequest request,
                                     HttpServletResponse response)
    {
        
		System.out.println("download APK");
		//If user is not authorized - he should be thrown out from here itself
		String deptId = request.getSession().getAttribute("deptId").toString();
		String userName = (String) request.getSession().getAttribute("loggedUser");
		
		String branchName = gldeptDao.getName(deptId);
		
        //Authorized user will download the file
		
			
		String path1 = PathMMS.getReportPath() + File.separator + "Reports" +File.separator+ id + ".pdf" ;
		File dir1 = new File(path1 + File.separator + "Reports");
		if (!dir1.exists())
			dir1.mkdirs();
		String fileName = id +".pdf";
		System.out.println("download APK");
		
		File file = new File(path1);
		if (file.exists())
        {
        	
        	
        	
            try {
            	response.setContentType("application/pdf");
            	//response.addHeader("Content-Disposition", "attachment; filename="+fileName);
                 
            	InputStream inputStream = new FileInputStream(new File(path1)); //load the file
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
	
	
	@RequestMapping("/viewSupportImage")
    public void viewSupportImage(@RequestParam("id") String id ,@RequestParam("cycle") String cycle,HttpServletRequest request,
                                     HttpServletResponse response)
    {
        
		System.out.println("download APK");
		//If user is not authorized - he should be thrown out from here itself
		//MmsAddsupport obj =  supportDao.findById(Long.valueOf(id));
		String name="";
		//if(obj != null){
			//name = obj.getFilepath();
		//}
        //Authorized user will download the file
		System.out.println("id :"+id);
		System.out.println("cycle :"+cycle);
		
		MmsTxntowermaintenancePK objMntPK = new MmsTxntowermaintenancePK();
		objMntPK.setTowerid(new Long(id));
		objMntPK.setVisitid(new Long(cycle));
		MmsTxntowermaintenance objMnt = towerTxtMaintenance.findByID(objMntPK);
		System.out.println("objMnt :"+objMnt);
		if(objMnt != null){
			name = objMnt.getFlashoversetno();
			//towerTxtMaintenance.update(objMnt);
		}
		
		
		String path1 = PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ name;
		File dir1 = new File(path1 + File.separator + "EmailAttachment");
		if (!dir1.exists())
			dir1.mkdirs();
		String fileName = id;
		System.out.println("download APK : " + id);
		
		File file = new File(path1);
		if (file.exists())
        {
        	
        	
        	
            try {
            	//response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            	response.setContentType("application/octet-stream");
                response.addHeader("Content-Disposition", "attachment; filename="+fileName);
                 
            	InputStream inputStream = new FileInputStream(new File(path1)); //load the file
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
	
	
	
	@RequestMapping("/downloadRecommendationLetter")
    public void downloadRecommendaitonLetter(@RequestParam("id") String id ,HttpServletRequest request,
                                     HttpServletResponse response)
    {
        
		System.out.println("download APK");
		//If user is not authorized - he should be thrown out from here itself
        
        //Authorized user will download the file
		ApprovalMm obj = appDao.findByID(id);
		String path1 = "";
		if(obj.getToStatus().equalsIgnoreCase("80")){
			path1  = PathMMS.getReportPath() + File.separator + "Reports" +File.separator+ id + "_1.pdf" ;
		}else if(obj.getToStatus().equalsIgnoreCase("96")){
			path1  = PathMMS.getReportPath() + File.separator + "Reports" +File.separator+ id + "_2.pdf" ;
			
		}else if (obj.getToStatus().equalsIgnoreCase("97")){
			path1  = PathMMS.getReportPath() + File.separator + "Reports" +File.separator+ id + "_3.pdf" ;
			
		}else{
			
		}
		
		//String path1 = PathMMS.getReportPath() + File.separator + "Reports" +File.separator+ id + ".pdf" ;
		File dir1 = new File(path1 + File.separator + "Reports");
		if (!dir1.exists())
			dir1.mkdirs();
		String fileName = id +".pdf";
		System.out.println("download APK");
		
		File file = new File(path1);
		if (file.exists())
        {
        	
        	
        	
            try {
            	response.setContentType("application/pdf");
            	//response.addHeader("Content-Disposition", "attachment; filename="+fileName);
                 
            	InputStream inputStream = new FileInputStream(new File(path1)); //load the file
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
	
	
	@RequestMapping("/downloadSLDGantry")
    public void downloadSLDGantry(@RequestParam("id") String id ,HttpServletRequest request,
                                     HttpServletResponse response)
    {
        
		System.out.println("download APK");
		//If user is not authorized - he should be thrown out from here itself
         
        //Authorized user will download the file
		
		String path1 = PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ id + "_1.pdf" ;
		String fileName = id +"_1.pdf";
		File file = new File(path1);
		if (file.exists())
        {
        	
        	
        	
            try {
            	response.setContentType("application/pdf");
            	//response.addHeader("Content-Disposition", "attachment; filename="+fileName);
                 
            	InputStream inputStream = new FileInputStream(new File(path1)); //load the file
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
	
	
	
	
	
	
	
	
	@RequestMapping("/downloadIntImgReq")
    public void downloadIntImgReq(@RequestParam("id") String id ,@RequestParam("seq") String seq ,HttpServletRequest request,
                                     HttpServletResponse response)
    {
        
		System.out.println("email id" +id+"");
		
		System.out.println("download APK" +seq+"/");
		//If user is not authorized - he should b/e thrown out from here itself
         
        //Authorized user will download the file 
		String path1 ="";
		
		path1 =PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ id;
		
		/*if(seq.equalsIgnoreCase("1")){
			System.out.println("seq 1");
			
			
			path1 =PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ id + "_1.png" ;
			
		}else if(seq.equalsIgnoreCase("2")){
			System.out.println("seq 2");
			
			path1 =PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ id + "_2.png" ;
			
		}else if(seq.equalsIgnoreCase("3")){
			System.out.println("seq 3");
			
			path1 =PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ id + "_3.png" ;
			
		}else if(seq.equalsIgnoreCase("4")){
			System.out.println("seq 4");
			
			path1 =PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ id + "_4.png" ;
			
		}else if(seq.equalsIgnoreCase("5")){
			System.out.println("seq 5");
			
			path1 =PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ id + "_5.png" ;
			
		}else{
			
		}
		*/
		
		File file = new File(path1);
		
		if (file.exists())
        {
        	
        	
        	
            try {
            	response.setContentType("application/octet-stream");
            	response.addHeader("Content-Disposition", "attachment; filename="+id);
                 
            	InputStream inputStream = new FileInputStream(new File(path1)); //load the file
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
	
	@RequestMapping("/downloadEMReport")
    public void downloadEMReport(@RequestParam("id") String id ,@RequestParam("seq") String seq ,HttpServletRequest request,
                                     HttpServletResponse response)
    {
        
		System.out.println("email id" +id+"");
		
		System.out.println("download APK" +seq+"/");
		//If user is not authorized - he should b/e thrown out from here itself
         
        //Authorized user will download the file 
		String path1 ="";
		
		path1 =PathMMS.getReportPath() + File.separator + "InsMntRequest" +File.separator+ id;
		
		/*if(seq.equalsIgnoreCase("1")){
			System.out.println("seq 1");
			
			
			path1 =PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ id + "_1.png" ;
			
		}else if(seq.equalsIgnoreCase("2")){
			System.out.println("seq 2");
			
			path1 =PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ id + "_2.png" ;
			
		}else if(seq.equalsIgnoreCase("3")){
			System.out.println("seq 3");
			
			path1 =PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ id + "_3.png" ;
			
		}else if(seq.equalsIgnoreCase("4")){
			System.out.println("seq 4");
			
			path1 =PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ id + "_4.png" ;
			
		}else if(seq.equalsIgnoreCase("5")){
			System.out.println("seq 5");
			
			path1 =PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ id + "_5.png" ;
			
		}else{
			
		}
		*/
		
		File file = new File(path1);
		
		if (file.exists())
        {
        	
        	
        	
            try {
            	response.setContentType("application/octet-stream");
            	response.addHeader("Content-Disposition", "attachment; filename="+id);
                 
            	InputStream inputStream = new FileInputStream(new File(path1)); //load the file
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
	
	
	
	
	@RequestMapping("/downloadGntryDoc")
    public void downloadGntryDoc(@RequestParam("id") String id ,@RequestParam("seq") String seq ,HttpServletRequest request,
                                     HttpServletResponse response)
    {
        
		System.out.println("email id" +id+"");
		
		System.out.println("download APK" +seq+"/");
		//If user is not authorized - he should b/e thrown out from here itself
         
        //Authorized user will download the file 
		String path1 ="";
		if(seq.equalsIgnoreCase("1")){
			System.out.println("seq 1");
			
			
			path1 =PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ id + "_1.pdf" ;
			
		}else if(seq.equalsIgnoreCase("2")){
			System.out.println("seq 2");
			
			path1 =PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ id + "_2.pdf" ;
			
		}else if(seq.equalsIgnoreCase("3")){
			System.out.println("seq 3");
			
			path1 =PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ id + "_3.pdf" ;
			
		}else if(seq.equalsIgnoreCase("4")){
			System.out.println("seq 4");
			
			path1 =PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ id + "_4.pdf" ;
			
		}else if(seq.equalsIgnoreCase("5")){
			System.out.println("seq 5");
			
			path1 =PathMMS.getReportPath() + File.separator + "EmailAttachment" +File.separator+ id + "_5.pdf" ;
			
		}else{
			
		}
		
		
		System.out.println("path : " + path1);
		
		 File dir1 = new File(path1 + File.separator + "Reports");
		if (!dir1.exists())
			dir1.mkdirs();
		String fileName = id +".pdf";
		System.out.println("download APK");
		
		File file = new File(path1);
		if (file.exists())
        {
        	
        	
        	
            try {
            	response.setContentType("application/pdf");
            	//response.addHeader("Content-Disposition", "attachment; filename="+fileName);
                 
            	InputStream inputStream = new FileInputStream(new File(path1)); //load the file
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }



	
	
	
	
	
	@RequestMapping("/downloadTestingAPK")
    public void downloadTestingAPK( HttpServletRequest request,
                                     HttpServletResponse response)
    {
        
		System.out.println("download APK");
		//If user is not authorized - he should be thrown out from here itself
         
        //Authorized user will download the file
		
		String path1 = PathMMS.getReportPath() + File.separator + "Reports" +File.separator+ "MVMMSTESTING.apk" ;
		File dir1 = new File(path1 + File.separator + "Reports");
		if (!dir1.exists())
			dir1.mkdirs();
		String fileName = "MVMMSTESTING.apk";
		System.out.println("download APK");
		
		File file = new File(path1);
		
		
        //String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/MVMMS.apk");
		// dataDirectory = request.getSession().getServletContext().getRealPath("/jasper/");
        //Path file = Paths.get(dataDirectory, fileName);
        //System.out.println("download APK 1" +path1 );
		
        if (file.exists())
        {
        	
        	
        	
            try {
            	response.setContentType("application/apk");
            	 response.addHeader("Content-Disposition", "attachment; filename="+fileName);
                 
            	InputStream inputStream = new FileInputStream(new File(path1)); //load the file
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	/*byte[] bytesArray = new byte[(int) file.length()];
        	System.out.println("download APK 2");
        	response.reset();
        	response.resetBuffer();
        	response.setContentType("application/apk");
        	response.setContentLength(bytesArray.length);
    		
            //response.setContentType("application/apk");
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            System.out.println("download APK 3");
    		
            try
            {
            	ServletOutputStream ouputStream = response.getOutputStream();
            	//ouputStream.
    			ouputStream.write(bytesArray, 0, bytesArray.length);
    			ouputStream.flush();
    			ouputStream.close();
    			
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }*/

        }
    }

	
	
	/*@RequestMapping(value = "/files/{file_name}", method = RequestMethod.GET)
	public void getFile(
	    @PathVariable("file_name") String fileName, 
	    HttpServletResponse response) {
	    try {
	      // get your file as InputStream
	      InputStream is = ...;
	      // copy it to response's OutputStream
	      org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
	      response.flushBuffer();
	    } catch (IOException ex) {
	      log.info("Error writing file to output stream. Filename was '{}'", fileName, ex);
	      throw new RuntimeException("IOError writing file to output stream");
	    }

	}
*/
	@RequestMapping("/downloadAttachment")
    public void downloadAttachment(HttpServletRequest request,
                                     HttpServletResponse response,@RequestParam("name") String name)
    {
        
		System.out.println("downloadAttachment");
		String path1 = PathMMS.getReportPath() + File.separator + "SPSAttachment";
		String pdfPath ="";
		String pdfName = "";
		Connection conn = null;
		File file = new File( path1 + File.separator + name);
		if (file.exists())
        {
            try {
            	//response.setContentType("application/xhtml+xml");
            	response.setContentType("application/octet-stream");
            	
            	//response.setContentType("application/pdf");
            	response.addHeader("Content-Disposition", "attachment; filename="+file.getName());
                 
            	InputStream inputStream = new FileInputStream(file); //load the file
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	

        }

    }
	
	@RequestMapping("/downloadEstimate")
    public void downloadEstimate(HttpServletRequest request,
                                     HttpServletResponse response,@RequestParam("estimateNo") String estimateNo,@RequestParam("costCenter") String costCenter)
    {
        
		System.out.println("downloadEstimate");
		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		String path3 = PathMMS.getReportPath() + "/Reports/";
		
		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
		String pdfPath ="";
		String pdfName = "";
		Connection conn = null;
		
		try {
			
			try {
				
				if(estimateNo.contains("ENC")||estimateNo.contains("ETC")||estimateNo.contains("ECR")){
					System.out.println("ENC");
					
					HashMap<String, Object> hmParams = new HashMap<String, Object>();
					hmParams.put("estNo", ""+estimateNo.trim()+"");
					hmParams.put("SUBREPORT_DIR", path3);
					System.out.println("path3" + path3);
					
					conn = jasperDao.getConnection();
					File file = new File(path1 + "/" + "R0034" + ".jrxml" );
				        
				        if(!file.exists())
				            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

				    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "R0034" + ".jrxml");
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
	 				JRPdfExporter pdf = new JRPdfExporter();
	 				//HtmlExporter exporter=new HtmlExporter();
	 				//List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
	 				 //jasperPrintList.add(jasperPrint);
	 				// exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
	 				 ////exporter.setExporterOutput( new SimpleHtmlExporterOutput(response.getWriter()));
	 				// SimpleHtmlReportConfiguration configuration =new SimpleHtmlReportConfiguration();
	 				// exporter.setConfiguration(configuration);
	 				// exporter.exportReport();

					Calendar calendar = Calendar.getInstance();
					 
					pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
					estimateNo = estimateNo.replaceAll("/", ".");
					pdfPath = estimateNo+ ".pdf";
					
					File pdfFile = new File(path2 + File.separator + pdfPath);
					System.out.println("pdfPath" +pdfPath );
					pdf.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
				    pdf.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, path2 + File.separator + pdfPath);
				    pdf.exportReport();

					
					if (pdfFile.exists())
			        {
			            try {
			            	//response.setContentType("application/xhtml+xml");

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

					
					
					
					
					
				}else if(estimateNo.contains("ELS")||estimateNo.contains("EMT")||estimateNo.contains("EAM")||estimateNo.contains("ESA")){
					
                    System.out.println("EAM");
					
					HashMap<String, Object> hmParams = new HashMap<String, Object>();
					hmParams.put("estNo", ""+estimateNo.trim()+"");
					String path4 = PathMMS.getReportPath() + "/Reports/";
					
					//hmParams.put("@estimateNo", "'"+estimateNo.trim()+"'");
					hmParams.put("SUBREPORT_DIR", path4);
					
					//hmParams.put("@costctr","'" +costCenter.trim() +"'");
					System.out.println("downloadEstimateestimateNo" + estimateNo);
					System.out.println("downloadEstimatecostCenter" + costCenter);
					System.out.println("path1" + path4);
					
					
					conn = jasperDao.getConnection();
					File file = new File(path1 + "/" + "EstimateMNT" + ".jrxml" );
				        
				        if(!file.exists())
				            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

				    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "EstimateMNT" + ".jrxml");
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
	 				JRPdfExporter pdf = new JRPdfExporter();
	 				/*HtmlExporter exporter=new HtmlExporter();
	 				List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
	 				 jasperPrintList.add(jasperPrint);
	 				 exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
	 				 exporter.setExporterOutput( new SimpleHtmlExporterOutput(response.getWriter()));
	 				 SimpleHtmlReportConfiguration configuration =new SimpleHtmlReportConfiguration();
	 				 exporter.setConfiguration(configuration);
	 				 exporter.exportReport();
*/

					Calendar calendar = Calendar.getInstance();
					 
					pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
					estimateNo = estimateNo.replaceAll("/", ".");
					pdfPath = estimateNo+ ".pdf";
					
					File pdfFile = new File(path2 + File.separator + pdfPath);
					System.out.println("pdfPath" +pdfPath );
					pdf.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
				    pdf.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, path2 + File.separator + pdfPath);
				    pdf.exportReport();

					
					if (pdfFile.exists())
			        {
			            try {
			            	//response.setContentType("application/xhtml+xml");

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

				
				}else{
					
					HashMap<String, Object> hmParams = new HashMap<String, Object>();
					hmParams.put("@project_no", "'"+estimateNo.trim()+"'");
					hmParams.put("@costctr","'" +costCenter.trim() +"'");
					System.out.println("downloadEstimateestimateNo" + estimateNo);
					System.out.println("downloadEstimatecostCenter" + costCenter);
					System.out.println("path1" + path1);
					
					conn = jasperDao.getConnection();
					File file = new File(path1 + "/" + "EstimateGalle" + ".jrxml" );
				        
				        if(!file.exists())
				            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

				    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "EstimateGalle" + ".jrxml");
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
	 				JRPdfExporter pdf = new JRPdfExporter();
	 				/*HtmlExporter exporter=new HtmlExporter();
	 				List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
	 				 jasperPrintList.add(jasperPrint);
	 				 exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
	 				 exporter.setExporterOutput( new SimpleHtmlExporterOutput(response.getWriter()));
	 				 SimpleHtmlReportConfiguration configuration =new SimpleHtmlReportConfiguration();
	 				 exporter.setConfiguration(configuration);
	 				 exporter.exportReport();
*/

					Calendar calendar = Calendar.getInstance();
					 
					//pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
					estimateNo = estimateNo.replaceAll("/", ".");
					pdfPath = estimateNo+ ".pdf";
					
					File pdfFile = new File(path2 + File.separator + pdfPath);
					System.out.println("pdfPath" +pdfPath );
					pdf.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
				    pdf.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, path2 + File.separator + pdfPath);
				    pdf.exportReport();

					
					if (pdfFile.exists())
			        {
			            try {
			            	//response.setContentType("application/xhtml+xml");

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

		
 }
	
	
	
	
	@RequestMapping("/downloadEstimateRevise")
    public void downloadEstimateRevise(HttpServletRequest request,
                                     HttpServletResponse response,@RequestParam("estimateNo") String estimateNo,@RequestParam("costCenter") String costCenter)
    {
        
		System.out.println("downloadEstimate");
		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		String path3 = PathMMS.getReportPath() + "/Reports/";
		
		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
		String pdfPath ="";
		String pdfName = "";
		Connection conn = null;
		
		try {
			
			try {
				

					
					HashMap<String, Object> hmParams = new HashMap<String, Object>();
					hmParams.put("@project_no", "'"+estimateNo.trim()+"'");
					hmParams.put("@costctr","'" +costCenter.trim() +"'");
					System.out.println("downloadEstimateestimateNo" + estimateNo);
					System.out.println("downloadEstimatecostCenter" + costCenter);
					System.out.println("path1" + path1);
					
					conn = jasperDao.getConnection();
					File file = new File(path1 + "/" + "ReviseEstimateGalle" + ".jrxml" );
				        
				        if(!file.exists())
				            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

				    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "ReviseEstimateGalle" + ".jrxml");
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
	 				JRPdfExporter pdf = new JRPdfExporter();
	 				/*HtmlExporter exporter=new HtmlExporter();
	 				List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
	 				 jasperPrintList.add(jasperPrint);
	 				 exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
	 				 exporter.setExporterOutput( new SimpleHtmlExporterOutput(response.getWriter()));
	 				 SimpleHtmlReportConfiguration configuration =new SimpleHtmlReportConfiguration();
	 				 exporter.setConfiguration(configuration);
	 				 exporter.exportReport();
*/

					Calendar calendar = Calendar.getInstance();
					 
					//pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
					estimateNo = estimateNo.replaceAll("/", ".");
					pdfPath = estimateNo+ ".pdf";
					
					File pdfFile = new File(path2 + File.separator + pdfPath);
					System.out.println("pdfPath" +pdfPath );
					pdf.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
				    pdf.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, path2 + File.separator + pdfPath);
				    pdf.exportReport();

					
					if (pdfFile.exists())
			        {
			            try {
			            	//response.setContentType("application/xhtml+xml");

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

		
 }

	
	
	
	
	
	
	
	
	@RequestMapping("/downloadEstimateStdReport")
    public void downloadEstimateStdReport(HttpServletRequest request,
                                     HttpServletResponse response,@RequestParam("estimateNo") String estimateNo,@RequestParam("costCenter") String costCenter)
    {
        
		System.out.println("downloadEstimate");
		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
		String pdfPath ="";
		String pdfName = "";
		Connection conn = null;
		
		try {
			
			try {
				
				if(estimateNo.contains("RE")||estimateNo.contains("RI")){
					System.out.println("RE");
					
					HashMap<String, Object> hmParams = new HashMap<String, Object>();
					hmParams.put("@appNo", "'"+estimateNo.trim()+"'");
					hmParams.put("@costctr", "'"+costCenter.trim()+"'");
					
					//hmParams.put("@costctr","'" +costCenter.trim() +"'");
					System.out.println("downloadEstimateestimateNo" + estimateNo);
					System.out.println("downloadEstimatecostCenter" + costCenter);
					
					conn = jasperDao.getConnection();
					File file = new File(path1 + "/" + "job_QuotationRE" + ".jrxml" );
				        
				        if(!file.exists())
				            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

				    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "job_QuotationRE" + ".jrxml");
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
	 				JRPdfExporter pdf = new JRPdfExporter();

					Calendar calendar = Calendar.getInstance();
					 
					pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
					estimateNo = estimateNo.replaceAll("/", ".");
					pdfPath = estimateNo+ ".pdf";
					
					File pdfFile = new File(path2 + File.separator + pdfPath);
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

					
					
					
					
					
				}else if(estimateNo.contains("PL")){
					
                    System.out.println("PL");
					
					HashMap<String, Object> hmParams = new HashMap<String, Object>();
					hmParams.put("@appNo", "'"+estimateNo.trim()+"'");
					hmParams.put("@costctr", "'"+costCenter.trim()+"'");
					
					//hmParams.put("@costctr","'" +costCenter.trim() +"'");
					System.out.println("downloadEstimateestimateNo" + estimateNo);
					System.out.println("downloadEstimatecostCenter" + costCenter);
					
					conn = jasperDao.getConnection();
					File file = new File(path1 + "/" + "STD_Estimate_Planing" + ".jrxml" );
				        
				        if(!file.exists())
				            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

				    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "STD_Estimate_Planing" + ".jrxml");
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
	 				JRPdfExporter pdf = new JRPdfExporter();

					Calendar calendar = Calendar.getInstance();
					 
					pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
					estimateNo = estimateNo.replaceAll("/", ".");
					pdfPath = estimateNo+ ".pdf";
					
					File pdfFile = new File(path2 + File.separator + pdfPath);
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

				
				}else{
					
					HashMap<String, Object> hmParams = new HashMap<String, Object>();
					hmParams.put("@appNo", "'"+estimateNo.trim()+"'");
					hmParams.put("@costctr", "'"+costCenter.trim()+"'");
					System.out.println("downloadEstimateestimateNo" + estimateNo);
					System.out.println("downloadEstimatecostCenter" + costCenter);
					
					conn = jasperDao.getConnection();
					File file = new File(path1 + "/" + "job_Quotation" + ".jrxml" );
				        
				        if(!file.exists())
				            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

				    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "job_Quotation" + ".jrxml");
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
	 				JRPdfExporter pdf = new JRPdfExporter();

					Calendar calendar = Calendar.getInstance();
					 
					pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
					estimateNo = estimateNo.replaceAll("/", ".");
					pdfPath = estimateNo+ ".pdf";
					
					File pdfFile = new File(path2 + File.separator + pdfPath);
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

		
 }
	
	
	
	@RequestMapping("/downloadQtyOnHandReport")
    public void downloadQtyOnHandReport(HttpServletRequest request,
                                     HttpServletResponse response,@RequestParam("costCenter") String costCenter)
    {
        
		System.out.println("downloadEstimate");
		String path1 = PathMMS.getReportPath() + File.separator + "Reports";
		String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
		String pdfPath ="";
		String pdfName = "";
		Connection conn = null;
		
		try {
			
			try {
				
					
					HashMap<String, Object> hmParams = new HashMap<String, Object>();
					hmParams.put("@matcode", "''");
					hmParams.put("@costctr", "'"+costCenter.trim()+"'");
					
					//hmParams.put("@costctr","'" +costCenter.trim() +"'");
					System.out.println("downloadEstimatecostCenter" + costCenter);
					
					conn = jasperDao.getConnection();
					File file = new File(path1 + "/" + "qty_OnHand" + ".jrxml" );
				        
				        if(!file.exists())
				            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

				    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "qty_OnHand" + ".jrxml");
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
	 				JRPdfExporter pdf = new JRPdfExporter();

					Calendar calendar = Calendar.getInstance();
					 
					pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
					pdfPath = costCenter+ ".pdf";
					
					File pdfFile = new File(path2 + File.separator + pdfPath);
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
		
    }
		
		@RequestMapping("/downloadFeederReport")
	    public void downloadFeederReport(HttpServletRequest request,
	                                     HttpServletResponse response)
	    {
	        
			System.out.println("downloadEstimate");
			String path1 = PathMMS.getReportPath() + File.separator + "Reports";
			String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
			String pdfPath ="";
			String pdfName = "";
			Connection conn = null;
			
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
						pdfPath = "TRIPPING_SUMMARY.pdf";
						
						File pdfFile = new File(path2 + File.separator + pdfPath);
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


		
 }
		
		
		@RequestMapping("/downloadPaySlip")
	    public void downloadPaySlip(HttpServletRequest request,
	                                     HttpServletResponse response,@RequestParam("docno") String docno)
	    {
	        
			System.out.println("downloadPaySlip" + docno);
			String path1 = PathMMS.getReportPath() + File.separator + "Reports";
			String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
			String pdfPath ="";
			String pdfName = "";
			Connection conn = null;
			
			try {
				
				try {
					
						
						HashMap<String, Object> hmParams = new HashMap<String, Object>();
						conn = jasperDao.getConnection();
						File file = new File(path1 + "/" + "Pay_Slip_New" + ".jrxml" );
						hmParams.put("@paySlip", "'"+docno.trim()+"'");
						 
					        if(!file.exists())
					            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

					    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "PaySlip" + ".jrxml");
						JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
		 				JRPdfExporter pdf = new JRPdfExporter();
		 				HtmlExporter exporter=new HtmlExporter();
		 				List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
		 				 jasperPrintList.add(jasperPrint);
		 				 exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
		 				 exporter.setExporterOutput( new SimpleHtmlExporterOutput(response.getWriter()));
		 				 SimpleHtmlReportConfiguration configuration =new SimpleHtmlReportConfiguration();
		 				 exporter.setConfiguration(configuration);
		 				 exporter.exportReport();


						Calendar calendar = Calendar.getInstance();
						 
						pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
						docno = docno.replaceAll("/", ".");
						
						pdfPath = docno + ".html";
						
						File pdfFile = new File(path2 + File.separator + pdfPath);
						System.out.println("pdfPath" +pdfPath );
						System.out.println("pdfPathpdfFile" +pdfFile.getAbsolutePath() );
						
						pdf.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
					    pdf.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, path2 + File.separator + pdfPath);
					    pdf.exportReport();

						
						if (pdfFile.exists())
				        {
				            try {
				            	response.setContentType("application/xhtml+xml");
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



/*
		public String generateReport(String brachName,String id,String userName){

			String pdfPath = "";
			//String reportFileName ="Inspection_Request";
			Connection conn = null;

			try {
				
				try {
					HashMap<String, Object> hmParams = new HashMap<String, Object>();
					hmParams.put("@coordinating","'"+brachName+"'");
					hmParams.put("@@orderNumber","'"+id+"'");
					
					
					hmParams.put("@preparedby","''");
					
					hmParams.put("@checkedby","''");
					conn = jasperDao.getConnection();
					File file = new File(REPORT_DIRECTORY + "/Meter_Request_New.jrxml" );
				        
				        if(!file.exists())
				            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");
	
				    JasperReport jasperReport =  JasperCompileManager.compileReport(EXPORT_REPORT_DIRECTORY  + "/" + reportName + ".jrxml");
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
	 				JRPdfExporter pdf = new JRPdfExporter();

					Calendar calendar = Calendar.getInstance();
					 
					pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");

					pdfPath = EXPORT_REPORT_DIRECTORY + "/" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
					+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
					+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + "R.pdf";
					
					pdfPath = EXPORT_REPORT_DIRECTORY + "/" +emailId+ "-"+ calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
							+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
							+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + ".pdf";
							
					
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
		}*/

	
		@RequestMapping("/downloadOder")
	    public void downloadOder(HttpServletRequest request,
	                                     HttpServletResponse response,@RequestParam("id") String id)
	    {
	        
			System.out.println("downloadEstimate");
			String path1 = PathMMS.getReportPath() + File.separator + "Reports";
			String path2 = PathMMS.getReportPath() + File.separator + "EmailAttachment";
			String pdfPath ="";
			String pdfName = "";
			Connection conn = null;
			String deptId = request.getSession().getAttribute("deptId").toString();
			String userName = (String) request.getSession().getAttribute("loggedUser");
			
			String branchName = gldeptDao.getName(deptId);
			
			try {
				
				try {
					
						
						HashMap<String, Object> hmParams = new HashMap<String, Object>();
						hmParams.put("@coordinating","'"+branchName.trim()+"'");
						hmParams.put("@orderNumber",id);
						
						
						hmParams.put("@preparedby","''");
						
						hmParams.put("@checkedby","''");
						
						conn = jasperDao.getConnection();
						File file = new File(path1 + "/" + "Meter_Request_New" + ".jrxml" );
					        
					        if(!file.exists())
					            throw new JRRuntimeException("File " + file + " not found. The report design must be compiled first.");

					    JasperReport jasperReport =  JasperCompileManager.compileReport(path1  + "/" +  "Meter_Request_New" + ".jrxml");
						JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
		 				JRPdfExporter pdf = new JRPdfExporter();

						Calendar calendar = Calendar.getInstance();
						 
						pdf.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
						pdfPath = id+ ".pdf";
						
						File pdfFile = new File(path2 + File.separator + pdfPath);
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
			
	    }

	
	
}
