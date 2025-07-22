package com.it.piv.mms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;

import org.apache.cxf.helpers.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.it.piv.admin.domain.SausermMm;
import com.it.piv.admin.repo.SecurityDao;
import com.it.piv.issue.repo.JasperDao;
import com.it.piv.mms.domain.ApprovalMm;
import com.it.piv.mms.domain.MmsAddsupport;
import com.it.piv.mms.repo.ApprovalMmDao;
import com.it.piv.mms.repo.MmsSupportDao;
import com.it.piv.mms.repo.PcesthttDao;
import com.it.piv.util.common.MailMail;
import com.it.piv.util.common.PathMMS;

public class MyBean {
	
	@Autowired
	private ApprovalMmDao approvalMm;
	
	@Autowired
	private JasperDao jasperDao;
	
	@Autowired
	private MmsSupportDao supportDao;
	
	@Autowired
	private SecurityDao securityDao;
	
	@Autowired
	private PcesthttDao pcesthttDao;
	
	
	//@Scheduled(fixedRate = 1000)
	@Scheduled(cron = "0 25 13 * * ?")
	   public void runTask () {
	       System.out.printf("Running scheduled task " +
	                                   " thread: %s, time: %s%n",
	                         Thread.currentThread().getName(),
	                         new Date());
	       
	       
	       SimpleDateFormat subject_str_fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	       Date todayxx = new Date();
	       String subject_str = subject_str_fm.format(todayxx);

	       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	       String dateString = format.format(new Date());
		   Date today = null;
		try {
			today = format.parse (dateString);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}    

	       
	       try {
	    	   ApprovalMm objMm = null;
	    	   
	    	   List<ApprovalMm>  listPendingIntWay = approvalMm.getPendingReq("WAYREQ","6");
	    	   if(listPendingIntWay != null){
	    		   int size = listPendingIntWay.size();
	    		   for(int i =0 ; i < size ; i++) {
	    			   objMm = listPendingIntWay.get(i);
	    			   Date sendDate = objMm.getApprovedDate();
	    			   System.out.printf("sendDate " + sendDate);

	    			   Calendar cal = null;
					   try {
						   cal = new GregorianCalendar();
						   cal.setTime(sendDate);
						   cal.add(Calendar.DAY_OF_MONTH, 30);
						   System.out.printf("done ");

					   } catch (Exception e) {
						   System.out.printf("error " + e.getMessage());

						// TODO Auto-generated catch block
						e.printStackTrace();
					   }
	    			   Date today30 = cal.getTime();
	    			   String dateStringToday30 = format.format(today30);
	    			   today30 = format.parse (dateStringToday30);
	    			   System.out.printf("today30 " + today30);
	    			   

	    			   if (sendDate.compareTo(today) < 0) {
	    				   System.out.printf("OK");

	    		            if(today.compareTo(today30)==0){
	    		            	System.out.printf("OK2");
	    		            		String a =objMm.getReferenceNo();
		    		            	String b = "\nMaintenance Data of the Cycle 201901 were sent to you on " + objMm.getApprovedDate() +"\nPlease confirm the clearance of Way leaves, Maintenance of intermediate poles & action on Missing parts on towers";
		    		            	ApplicationContext context1 = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		    						MailMail mm = (MailMail) context1.getBean("mailMail");
		    						//Util.trustEveryone();
		    						//mm.sendMailTo(a, b,"gchampika28@gmail.com","Confirm the clearance of Way leaves, Maintenance of intermediate poles & action on Missing parts " + subject_str);
		    						//objMm.setToStatus("10");
		    						//approvalMm.update(objMm);

	    		            	}
	    		            	
	    		            
	    			   }
	    			   
	    			   
	    		   }
	    	   }
	    	   
	    	   List<MmsAddsupport> supportList = supportDao.getIntteruptedList();
	    	   if(supportList != null){
	    		   int size = supportList.size();
	    		   MmsAddsupport support = null;
	    		   for(int i =0 ; i < size ; i++) {
	    			   support = supportList.get(i);
	    			   if(support.getInterruptedDate().compareTo(today) < 0){
	    				   support.setInterruptedYes(new BigDecimal("3"));
	    				   System.out.println("sssssssss:"+support.getInterruptedYes());
   						
	    				   supportDao.update(support);
	    			   }
	    		   }
	    	   }
	    	   
	    	   
	    			   
	    			  /* String path1 = PathMMS.getReportPath() + File.separator + "Reports";
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
	    						pdfPath = "INTTERUPTION REQUEST SUMMARY-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
	    								+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
	    								+ calendar.get(Calendar.SECOND)+ ".pdf";
	    						
	    						File pdfFile = new File(path2 + File.separator + pdfPath);
	    						pdf.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
	    					    pdf.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, path2 + File.separator + pdfPath);
	    					    pdf.exportReport();

	    						System.out.println("pdfPath" +pdfPath );
	    						
	    						
	    						if(pdfFile.exists()){
	    							System.out.println("pdfFile  exixt"  );
		    						
	    							String b = "\nHerewith, Interruption request summary report of "+Util.getMonthForInt(calendar.get(Calendar.MONTH ))+" is attached.";
	    							//String b = "\nHerewith, Interruption request summary report of is attached.";
	    							
	    							System.out.println("pdfFile  exixt : " + b );
		    						
	    							ApplicationContext context1 = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		    						MailMail mm = (MailMail) context1.getBean("mailMail");
		    					    //mm.sendMailTo("Chief Engineer / Maintenance Engineer PHM DD2", b,"gchampika28@gmail.com","Confirm the clearance of Way leaves, Maintenance of intermediate poles & action on Missing parts");
		    					   // mm.sendMailTo("Chief Engineer / Maintenance Engineer PHM DD2", b ,"eranga.bogahakumbura@gmail.com","alagodas1@gmail.com","Interruption request summary report",null,null,null,null,null,pdfFile);
		    					    //mm.sendMailTo("Chief Engineer / Maintenance Engineer PHM DD2", b ,"eelm.ceb@gmail.com","alagodas1@gmail.com","Interruption request summary report",null,null,null,null,null,pdfFile);
		    						
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


	    				}*/

	    		   //}
	    		   
	    	   //}
/*	    	  ApplicationContext context1 = new ClassPathXmlApplicationContext("Spring-Mail.xml");
			   MailMail mm = (MailMail) context1.getBean("mailMail");
			   List<SausermMm> userList = securityDao.getUserList("DGM");
			   if(userList != null){
				   if(!userList.isEmpty()){
					   for(int i=0;i<userList.size();i++){
						   SausermMm obj = userList.get(i); 
						   if(obj.getEmail() != null){
							   Long count = pcesthttDao.getApprovalListCount("DGM", obj.getUserId());
							   if(count > 0){
								   
							   String[] email = new String[2];
							   email[0] = "mgrisd@ceb.lk";
							   email[1] = "gchampika28@gmail.com";
							   String b = "\nYou have "+count+" estimates to approve.\nYou can view that by login into  https://mms.ceb.lk.  For any issues,Please contact Manager(ISD)-0714150600\n\nThank You,\nIT Branch-CEB";
							   
							   //Util.trustEveryone();
							   mm.sendMailTo(obj.getUserId().trim(), b,obj.getEmail(),email,"Estimate Approval Status " + subject_str);
							   //mm.sendMailTo(obj.getUserId(), b,"gchampika28@gmail.com","Approval Status " + subject_str);
							   
							   RestTemplate restTemplate = new RestTemplate();
							   String url= "";
							   url="http://smsgw.ceb/SMSPlatform.php?recipients=0714150600&smsbody="+b+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
							   String url1= "";
							   url1="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+b+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
							   String urlUser= "";
							   urlUser="http://smsgw.ceb/SMSPlatform.php?recipients="+obj.getTelNo()+"&smsbody="+b+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
							   //System.out.println("obj.getTelNo() : " + obj.getTelNo() + );
							   try {
								    restTemplate.getForObject(urlUser, String.class);
									restTemplate.getForObject(url, String.class);
									restTemplate.getForObject(url1, String.class);
								} catch (RestClientException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							   }
								
						   }
						   
						   
					   }
					   
				   }
				   
			   }*/
	    	   System.out.println("obj.getUserId() : ");
			   
			   ApplicationContext context1 = new ClassPathXmlApplicationContext("Spring-Mail.xml");
			   MailMail mm = (MailMail) context1.getBean("mailMail");
			   List<SausermMm> userList = securityDao.getAllUserByRptUserMMS("600.41","CE");
			   if(userList != null){
				   if(!userList.isEmpty()){
					   for(int i=0;i<userList.size();i++){
						   SausermMm obj = userList.get(i); 
						   if(obj.getEmail() != null){
							   System.out.println("obj.getUserId() : " + obj.getUserId());
							   Long count = pcesthttDao.getApprovalListCount("CE", obj.getUserId());
							   if(count > 0){
								   System.out.println("obj.getUserId() : " + obj.getUserId());
									   
							   String[] email = new String[1];
							   //email[0] = "mgrisd@ceb.lk";
							   email[0] = "gchampika28@gmail.com";
							   String b = "\nYou have "+count+" estimates to approve.\nYou can view that by login into  https://mms.ceb.lk.  For any issues,please send an email to mvmms@ceb.lk \n\nThank You,\nIT Branch-CEB";
							   
							   //Util.trustEveryone();
							   //mm.sendMailTo(obj.getUserId().trim(), b,obj.getEmail(),email,"Estimate Approval Status :" + subject_str.toUpperCase());
							   mm.sendMailTo(obj.getUserId(), b,"gchampika28@gmail.com","Estimate Approval Status " + subject_str);
							   
							   RestTemplate restTemplate = new RestTemplate();
							   String url= "";
							   //url="http://smsgw.ceb/SMSPlatform.php?recipients=0714150600&smsbody="+b+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
							   String url1= "";
							   url1="http://smsgw.ceb/SMSPlatform.php?recipients=0714537313&smsbody="+b+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
							   String urlUser= "";
							   //urlUser="http://smsgw.ceb/SMSPlatform.php?recipients="+obj.getTelNo()+"&smsbody="+b+"&appref=ABC123&username=dumindu&password=DuMinDU927&alias=CEB&division=DD1&province=NP&accountNo=1234567890&application=TEST";
							   //System.out.println("obj.getTelNo() : " + obj.getTelNo() + );
							   try {
								    //restTemplate.getForObject(urlUser, String.class);
									//restTemplate.getForObject(url, String.class);
									//restTemplate.getForObject(url1, String.class);
								} catch (RestClientException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							   }
								
						   }
						   //
						   
					   }
					   
				   }
				   
			   }
		   
			   
			   
			System.out.printf("Email sent");

	       }catch (Exception e) {
				     e.printStackTrace();
		}  


	       try {
	           Thread.sleep(500);
	       } catch (InterruptedException e) {
	       }
	   }

}
