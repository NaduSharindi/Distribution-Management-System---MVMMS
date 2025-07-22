package com.it.piv.mms.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;







import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.admin.domain.Sauserm;
import com.it.piv.admin.repo.SecurityDao;
import com.it.piv.issue.domain.PivModel;
import com.it.piv.issue.repo.JasperDao;
import com.it.piv.mms.domain.Applicant;
import com.it.piv.mms.domain.Glcompm;
import com.it.piv.mms.domain.Gldeptm;
import com.it.piv.mms.domain.MmsAddline;
import com.it.piv.mms.domain.MmsAddsupporttype;
import com.it.piv.mms.domain.MvmmsCycle;
import com.it.piv.mms.repo.ApplicantDao;
import com.it.piv.mms.repo.GlcompmDao;
import com.it.piv.mms.repo.GldeptmDao;
import com.it.piv.mms.repo.MmsAddLineDao;
import com.it.piv.mms.repo.MvmmsCycleDao;

@Controller
public class UserManagerController {
	
	@Autowired
	private JasperDao jasperDao;
	@Autowired
	private MvmmsCycleDao cycleDao;
	
	@Autowired
	private MmsAddLineDao lineDao;
	
	@Autowired
	private SecurityDao securityDao;
	
	@Autowired
	private ApplicantDao appDao;
	
	@Autowired
	private GldeptmDao glDeptDao;
	
	@Autowired
	private GlcompmDao glCompDao;
	
	
	@Autowired
	private GldeptmDao deptDao;
	@Autowired
	private GlcompmDao glcompmDao;
	
	/*@Autowired
	private MmsAddLineDao lineDao;
	*/
	
	@RequestMapping(value = "/getAllUserByDeptIdAndUL", method = RequestMethod.GET)
	public @ResponseBody List<Sauserm> getAllUserByDeptIdAndUL(@RequestParam("rpt_user") String rpt_user,@RequestParam("user_level") String user_level) {
		return securityDao.getAllUserByRptUser("600.41", "ES");
		
	}
	
	@RequestMapping(value = "/getApprovalUsers/{deptid}/{level}", method = RequestMethod.GET)
	public @ResponseBody List<Sauserm> getApprovalUsers(@PathVariable("deptid") String deptid,@PathVariable("level") String level) {
		return securityDao.getAllUserByRptUser(deptid, level);
		
	}
	
	
	@RequestMapping(value = "/getApplicant", method = RequestMethod.GET)
	public @ResponseBody List<Applicant> getApplicant(@RequestParam("dept_id") String dept_id) {
		return appDao.getAllApplicantBydeptId("600.41");
		
	}
	
	//gayani piv printing
	
		@RequestMapping(value = "/GenerateReport", method = RequestMethod.GET)
		public String generateReport(@RequestParam("pivno") String pivno,Model model, HttpServletRequest request,
				HttpServletResponse response) throws JRException, IOException,
				NamingException {

			/**if (result.hasErrors()) {
				System.out.println("validation error occured in jasper input form");
				return "loadJasper";


			}*/
			String deptId = (String)request.getSession().getAttribute("deptId");
			String reportFileName ="ToewrlDetails";
			Connection conn = null;

			try {
				System.out.println("yyy ttt uuu iiii ooo");
				//conn = jasperDao.getConnection();
				conn = jasperDao.getConnection();
				//String rptFormat = jasperInputForm.getRptFmt();
				//String noy = jasperInputForm.getNoofYears();
				
				String rptFormat = "pdf";
				String noy = "9";


				System.out.println("rpt format " + rptFormat);
				System.out.println("no of years " + noy);

				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				
				//String pivNo = "PIV/423.10/ANC/2011/0795";
				String pivNo = pivno;
				String cc = "423.10";
				//hmParams.put("noy", new Integer(noy));
				hmParams.put("@pivNo","'" +pivNo +"'");
				hmParams.put("@costCtr","'"+cc+"'");

				//hmParams.put("Title", "Employees working more than " + noy
					//	+ " Years");

				//JasperReport jasperReport = jasperDao.getCompiledFile(reportFileName,
						//request);
				JasperReport jasperReport = jasperDao.getCompiledFile(reportFileName,request);
				if (rptFormat.equalsIgnoreCase("html")) {

					JasperPrint jasperPrint = JasperFillManager.fillReport(
							jasperReport, hmParams, conn);
					jasperDao.generateReportHtml(jasperPrint, request, response); // For
																				// HTML
																				// report

				}

				else if (rptFormat.equalsIgnoreCase("pdf")) {

					jasperDao.generateReportPDF(response, hmParams, jasperReport, conn); // For
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

		}
		
		@RequestMapping(value = "/GenerateReportTM", method = RequestMethod.GET)
		public String generateReportTM(@RequestParam("area") String area,@RequestParam("line") String line,Model model, HttpServletRequest request,
				HttpServletResponse response) throws JRException, IOException,
				NamingException {
			System.out.println("report::");
			System.out.println("report::" + area +  "kkk" + line);
			String deptId = (String)request.getSession().getAttribute("deptId");
			String reportFileName ="ToewrlDetails_new";
			Connection conn = null;

			try {
				conn = jasperDao.getConnection();
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				hmParams.put("@area","'" +area +"'");
				hmParams.put("@line","'"+line+"'");
                JasperReport jasperReport = jasperDao.getCompiledFile(reportFileName,request);
                String rptFormat = "pdf";
				if (rptFormat.equalsIgnoreCase("html")) {
                         JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hmParams, conn);
					     jasperDao.generateReportHtml(jasperPrint, request, response); // For
				}

				else if (rptFormat.equalsIgnoreCase("pdf")) {
                         jasperDao.generateReportPDF(response, hmParams, jasperReport, conn); // For
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

		}
		
		@RequestMapping(value = "/GenerateReportNew", method = RequestMethod.GET)
		public String generateReport(Model model, HttpServletRequest request,
				HttpServletResponse response) throws JRException, IOException,
				NamingException {

			/**if (result.hasErrors()) {
				System.out.println("validation error occured in jasper input form");
				return "loadJasper";


			}*/
			String deptId = (String)request.getSession().getAttribute("deptId");
			String reportFileName ="ToewrlDetails";
			Connection conn = null;

			try {
				System.out.println("yyy ttt uuu iiii ooo");
				//conn = jasperDao.getConnection();
				conn = jasperDao.getConnection();
				//String rptFormat = jasperInputForm.getRptFmt();
				//String noy = jasperInputForm.getNoofYears();
				
				String rptFormat = "pdf";
				String noy = "9";


				System.out.println("rpt format " + rptFormat);
				System.out.println("no of years " + noy);

				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				
				//String pivNo = "PIV/423.10/ANC/2011/0795";
				//String pivNo = pivno;
				String cc = "423.10";
				//hmParams.put("noy", new Integer(noy));
				//hmParams.put("@pivNo","'" +pivNo +"'");
				hmParams.put("@costCtr","'"+cc+"'");

				//hmParams.put("Title", "Employees working more than " + noy
					//	+ " Years");

				//JasperReport jasperReport = jasperDao.getCompiledFile(reportFileName,
						//request);
				JasperReport jasperReport = jasperDao.getCompiledFile(reportFileName,request);
				if (rptFormat.equalsIgnoreCase("html")) {

					JasperPrint jasperPrint = JasperFillManager.fillReport(
							jasperReport, hmParams, conn);
					jasperDao.generateReportHtml(jasperPrint, request, response); // For
																				// HTML
																				// report

				}

				else if (rptFormat.equalsIgnoreCase("pdf")) {

					jasperDao.generateReportPDF(response, hmParams, jasperReport, conn); // For
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

		}
		
		
		@RequestMapping(value = "/GenerateScheduleAndReport", method = RequestMethod.POST)
		public void GenerateScheduleAndReport(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel,
				HttpServletResponse response) throws JRException, IOException,
				NamingException {
			//String cycle = pivModel.getCycle();
			
			String cycle= "";
			if(pivModel.getCycleObj() != null){
				cycle=pivModel.getCycleObj().getId().getCycleId();
				
			}
			String downloadReportName="";
			System.out.println("cycle : " + cycle);
			String deptId = (String)request.getSession().getAttribute("deptId");
			
			String reportFileName ="";
			if(pivModel.getMode().equalsIgnoreCase("HOTLINE")){
				reportFileName ="HLM";
				downloadReportName="Hot_Line_Report";
				System.out.println("reportFileName : " + reportFileName);
			}else if(pivModel.getMode().equalsIgnoreCase("TTWT")){
				reportFileName ="TTWT";
				downloadReportName="Towers_without_Tappings_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("CLE")){
				reportFileName ="CLEM";
				downloadReportName="Cold_Line_Electrical_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("CLC")){
				reportFileName ="CLC";
				downloadReportName="Cold_Line_Civil_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("MW")){
				reportFileName ="MW";
				downloadReportName="Miscellaneous_Works_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("EWOP")){
				reportFileName ="EWOPP";
				downloadReportName="Electrical_Works_on_Poles";
				
			}else if(pivModel.getMode().equalsIgnoreCase("VR")){
				reportFileName ="VR";
				downloadReportName="Vegetation_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("TP")){
				reportFileName ="Tapping";
				downloadReportName="Tower_Tapping_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("MPL")){
				reportFileName ="MPL";
				downloadReportName="Missing_Part_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("PELT")){
				reportFileName ="PESummary";
				downloadReportName="Line _Type";
				
			}else if(pivModel.getMode().equalsIgnoreCase("PECONT")){
				reportFileName ="PE__Conductor_Summay";
				downloadReportName="Conductor_Type";
				
			}else if(pivModel.getMode().equalsIgnoreCase("PECIRT")){
				reportFileName ="PE_Circuit_Summary";
				downloadReportName="Circuit_Type";
				
			}else if(pivModel.getMode().equalsIgnoreCase("PECIRCONT")){
				reportFileName ="PE__Conductor_circuit_Summay";
				downloadReportName="Circuit_Conductor_Type";
				
			}else if(pivModel.getMode().equalsIgnoreCase("HAR")){
				reportFileName ="TLDS";
				//downloadReportName="Miscellaneous_Works_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("HAR2")){
				reportFileName ="TSS";
				//downloadReportName="Miscellaneous_Works_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("INTSUM")){
				reportFileName ="INT_REQ_SUM_AREA";
				downloadReportName="INT_SUM_Report";
				
			}else{
				
			}
			 
			Connection conn = null;

			try {
				System.out.println("yyy ttt uuu iiii ooo");
				//conn = jasperDao.getConnection();
				conn = jasperDao.getConnection();
				//String rptFormat = jasperInputForm.getRptFmt();
				//String noy = jasperInputForm.getNoofYears();
				
				String rptFormat = "pdf";
				String noy = "9";

				/*System.out.println("province " + pivModel.getGlcompmobj().getCompId());
				System.out.println("area " + pivModel.getGldeptobj().getDeptId());
				System.out.println("line " + pivModel.getLine().getCode());
				System.out.println("cycle " + pivModel.getCycle());
*/
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				String province = pivModel.getGlcompmobj().getCompId();
				String code = "";
				if(pivModel.getLine() != null){
					code = pivModel.getLine().getCode();
					
				}
				
				
				
				
				String id = lineDao.findIdByCode(code.trim());
				System.out.println("id " + id);
				String area = pivModel.getGldeptobj().getDeptId();
				if(area.equalsIgnoreCase("NONE")){
					area = "";
				}
				
				if(cycle.equalsIgnoreCase("NONE")){
					cycle = "";
				}
				
				
				if(code.equalsIgnoreCase("NONE")){
					id = "";
				}
				if(province.equalsIgnoreCase("NONE")){
					province = "";
				}
				System.out.println("test 2::");
				
				
				hmParams.put("@province","'" +province +"'");
				hmParams.put("@area","'" +area +"'");
				hmParams.put("@line_id","'"+id+"'");
				hmParams.put("@cycle","'"+cycle+"'");
				
				System.out.println("province " + province);
				System.out.println("area " + area);
				System.out.println("line " + id);
				System.out.println("cycle " + cycle);


				//hmParams.put("Title", "Employees working more than " + noy
					//	+ " Years");

				//JasperReport jasperReport = jasperDao.getCompiledFile(reportFileName,
						//request);
				JasperReport jasperReport = jasperDao.getCompiledFileMVMMS(reportFileName,request);
				System.out.println("test 3::");
				
				//JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
				Calendar calendar = Calendar.getInstance();
				
				String reportName = downloadReportName +"-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + ".pdf";
						
				
				if (rptFormat.equalsIgnoreCase("html")) {

					JasperPrint jasperPrint = JasperFillManager.fillReport(
							jasperReport, hmParams, conn);
					jasperDao.generateReportHtml(jasperPrint, request, response); // For
																				// HTML
																				// report

				}

				else if (rptFormat.equalsIgnoreCase("pdf")) {

					jasperDao.generateReportPDFWithName(response, hmParams, jasperReport, conn,reportName); // For
																						// PDF
																						// report

				}
				
					} catch (Exception sqlExp) {
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



		}
		
		
		
		@RequestMapping(value = "/GenerateSR", method = RequestMethod.GET)
		public String GenerateSR(HttpServletRequest request,@RequestParam("mode") String mode,@RequestParam("cycle") String cycle,@RequestParam("province") String province,
				@RequestParam("area") String area,@RequestParam("line") String line,HttpServletResponse response) throws JRException, IOException,
				NamingException {
			//String cycle = pivModel.getCycle();
			
			String downloadReportName="";
			System.out.println("cycle : " + cycle);
			String deptId = (String)request.getSession().getAttribute("deptId");
			
			String reportFileName ="";
			if(mode.equalsIgnoreCase("HOTLINE")){
				reportFileName ="HLM";
				downloadReportName="Hot_Line_Report";
				System.out.println("reportFileName : " + reportFileName);
			}else if(mode.equalsIgnoreCase("TTWT")){
				reportFileName ="TTWT";
				downloadReportName="Towers_without_Tappings_Report";
				
			}else if(mode.equalsIgnoreCase("CLE")){
				reportFileName ="CLEM";
				downloadReportName="Cold_Line_Electrical_Report";
				
			}else if(mode.equalsIgnoreCase("CLC")){
				reportFileName ="CLC";
				downloadReportName="Cold_Line_Civil_Report";
				
			}else if(mode.equalsIgnoreCase("MW")){
				reportFileName ="MW";
				downloadReportName="Miscellaneous_Works_Report";
				
			}else if(mode.equalsIgnoreCase("EWOP")){
				reportFileName ="EWOPP";
				downloadReportName="Electrical_Works_on_Poles";
				
			}else if(mode.equalsIgnoreCase("VR")){
				reportFileName ="VR";
				downloadReportName="Vegetation_Report";
				
			}else if(mode.equalsIgnoreCase("TP")){
				reportFileName ="Tapping";
				downloadReportName="Tower_Tapping_Report";
				
			}else if(mode.equalsIgnoreCase("MPL")){
				reportFileName ="MPL";
				downloadReportName="Missing_Part_Report";
				
			}else if(mode.equalsIgnoreCase("PELT")){
				reportFileName ="PESummary";
				downloadReportName="Line _Type";
				
			}else if(mode.equalsIgnoreCase("PECONT")){
				reportFileName ="PE__Conductor_Summay";
				downloadReportName="Conductor_Type";
				
			}else if(mode.equalsIgnoreCase("PECIRT")){
				reportFileName ="PE_Circuit_Summary";
				downloadReportName="Circuit_Type";
				
			}else if(mode.equalsIgnoreCase("PECIRCONT")){
				reportFileName ="PE__Conductor_circuit_Summay";
				downloadReportName="Circuit_Conductor_Type";
				
			}else if(mode.equalsIgnoreCase("HAR")){
				reportFileName ="TLDS";
				//downloadReportName="Miscellaneous_Works_Report";
				
			}else if(mode.equalsIgnoreCase("HAR2")){
				reportFileName ="TSS";
				//downloadReportName="Miscellaneous_Works_Report";
				
			}else if(mode.equalsIgnoreCase("INTSUM")){
				reportFileName ="INT_REQ_SUM_AREA";
				downloadReportName="INT_SUM_Report";
				
			}else{
				
			}
			 
			Connection conn = null;

			try {
				System.out.println("yyy ttt uuu iiii ooo");
				//conn = jasperDao.getConnection();
				conn = jasperDao.getConnection();
				//String rptFormat = jasperInputForm.getRptFmt();
				//String noy = jasperInputForm.getNoofYears();
				
				String rptFormat = "pdf";
				String noy = "9";

				
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				//String code = "";
				
				
				
				
				//String id = lineDao.findIdByCode(code.trim());
				//System.out.println("id " + id);
				if(area.equalsIgnoreCase("NONE")){
					area = "";
				}
				
				if(cycle.equalsIgnoreCase("NONE")){
					cycle = "";
				}
				
				
				if(line.equalsIgnoreCase("-1")){
					line = "";
				}
				if(province.equalsIgnoreCase("NONE")){
					province = "";
				}
				System.out.println("test 2::");
				
				
				hmParams.put("@province","'" +province +"'");
				hmParams.put("@area","'" +area +"'");
				hmParams.put("@line_id","'"+line+"'");
				hmParams.put("@cycle","'"+cycle+"'");
				
				System.out.println("province " + province);
				System.out.println("area " + area);
				System.out.println("line " + line);
				System.out.println("cycle " + cycle);


				//hmParams.put("Title", "Employees working more than " + noy
					//	+ " Years");

				//JasperReport jasperReport = jasperDao.getCompiledFile(reportFileName,
						//request);
				JasperReport jasperReport = jasperDao.getCompiledFileMVMMS(reportFileName,request);
				System.out.println("test 3::");
				
				//JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
				Calendar calendar = Calendar.getInstance();
				
				String reportName = downloadReportName +"-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + ".pdf";
						
				
				if (rptFormat.equalsIgnoreCase("html")) {

					JasperPrint jasperPrint = JasperFillManager.fillReport(
							jasperReport, hmParams, conn);
					jasperDao.generateReportHtml(jasperPrint, request, response); // For
																				// HTML
																				// report

				}

				else if (rptFormat.equalsIgnoreCase("pdf")) {

					jasperDao.generateReportPDFWithName(response, hmParams, jasperReport, conn,reportName); // For
																						// PDF
																						// report

				}
				
					} catch (Exception sqlExp) {
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

		}

		
		
		@RequestMapping(value = "/intSumReportsCCS", method = RequestMethod.POST)
		public String intSumReportsCCS(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel,
				HttpServletResponse response) throws JRException, IOException,
				NamingException {
			//String cycle = pivModel.getCycle();
			System.out.println("fromdate : " + pivModel.getFromDate());
			System.out.println("fromdate : " + pivModel.getToDate());
			System.out.println("from : " + pivModel.getFrom());
			
			String cycle= "";
			if(pivModel.getCycleObj() != null){
				cycle=pivModel.getCycleObj().getId().getCycleId();
				
			}
			String downloadReportName="";
			System.out.println("cycle : " + cycle);
			String deptId = (String)request.getSession().getAttribute("deptId");
			
			String reportFileName ="";
			if(pivModel.getMode().equalsIgnoreCase("HOTLINE")){
				reportFileName ="HLM";
				downloadReportName="Hot_Line_Report";
				System.out.println("reportFileName : " + reportFileName);
			}else if(pivModel.getMode().equalsIgnoreCase("TTWT")){
				reportFileName ="TTWT";
				downloadReportName="Towers_without_Tappings_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("CLE")){
				reportFileName ="CLEM";
				downloadReportName="Cold_Line_Electrical_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("CLC")){
				reportFileName ="CLC";
				downloadReportName="Cold_Line_Civil_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("MW")){
				reportFileName ="MW";
				downloadReportName="Miscellaneous_Works_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("EWOP")){
				reportFileName ="EWOPP";
				downloadReportName="Electrical_Works_on_Poles";
				
			}else if(pivModel.getMode().equalsIgnoreCase("VR")){
				reportFileName ="VR";
				downloadReportName="Vegetation_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("TP")){
				reportFileName ="Tapping";
				downloadReportName="Tower_Tapping_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("MPL")){
				reportFileName ="MPL";
				downloadReportName="Missing_Part_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("PELT")){
				reportFileName ="PESummary";
				downloadReportName="Line _Type";
				
			}else if(pivModel.getMode().equalsIgnoreCase("PECONT")){
				reportFileName ="PE__Conductor_Summay";
				downloadReportName="Conductor_Type";
				
			}else if(pivModel.getMode().equalsIgnoreCase("PECIRT")){
				reportFileName ="PE_Circuit_Summary";
				downloadReportName="Circuit_Type";
				
			}else if(pivModel.getMode().equalsIgnoreCase("PECIRCONT")){
				reportFileName ="PE__Conductor_circuit_Summay";
				downloadReportName="Circuit_Conductor_Type";
				
			}else if(pivModel.getMode().equalsIgnoreCase("HAR")){
				reportFileName ="TLDS";
				//downloadReportName="Miscellaneous_Works_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("HAR2")){
				reportFileName ="TSS";
				//downloadReportName="Miscellaneous_Works_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("INTSUM")){
				reportFileName ="INT_REQ_SUM_AREA";
				downloadReportName="INT_SUM_Report";
				
			}else{
				
			}
			 
			Connection conn = null;

			try {
				System.out.println("yyy ttt uuu iiii ooo");
				//conn = jasperDao.getConnection();
				conn = jasperDao.getConnection();
				//String rptFormat = jasperInputForm.getRptFmt();
				//String noy = jasperInputForm.getNoofYears();
				
				String rptFormat = "pdf";
				String noy = "9";

				/*System.out.println("province " + pivModel.getGlcompmobj().getCompId());
				System.out.println("area " + pivModel.getGldeptobj().getDeptId());
				System.out.println("line " + pivModel.getLine().getCode());
				System.out.println("cycle " + pivModel.getCycle());
*/
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				String province = pivModel.getGlcompmobj().getCompId();
				String code = "";
				if(pivModel.getLine() != null){
					code = pivModel.getLine().getCode();
					
				}
				
				
				
				
				String id = lineDao.findIdByCode(code.trim());
				System.out.println("id " + id);
				String area = pivModel.getGldeptobj().getDeptId();
				if(area.equalsIgnoreCase("NONE")){
					area = "";
				}
				
				if(cycle.equalsIgnoreCase("NONE")){
					cycle = "";
				}
				
				
				if(code.equalsIgnoreCase("NONE")){
					id = "";
				}
				if(province.equalsIgnoreCase("NONE")){
					province = "";
				}
				System.out.println("test 2::");
				
				
				hmParams.put("@province","'" +province +"'");
				hmParams.put("@area","'" +area +"'");
				hmParams.put("@line_id","'"+id+"'");
				hmParams.put("@cycle","'"+cycle+"'");
				
				System.out.println("province " + province);
				System.out.println("area " + area);
				System.out.println("line " + id);
				System.out.println("cycle " + cycle);


				//hmParams.put("Title", "Employees working more than " + noy
					//	+ " Years");

				//JasperReport jasperReport = jasperDao.getCompiledFile(reportFileName,
						//request);
				JasperReport jasperReport = jasperDao.getCompiledFileMVMMS(reportFileName,request);
				System.out.println("test 3::");
				
				//JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
				Calendar calendar = Calendar.getInstance();
				
				String reportName = downloadReportName +"-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + ".pdf";
						
				
				if (rptFormat.equalsIgnoreCase("html")) {

					JasperPrint jasperPrint = JasperFillManager.fillReport(
							jasperReport, hmParams, conn);
					jasperDao.generateReportHtml(jasperPrint, request, response); // For
																				// HTML
																				// report

				}

				else if (rptFormat.equalsIgnoreCase("pdf")) {

					jasperDao.generateReportPDFWithName(response, hmParams, jasperReport, conn,reportName); // For
																						// PDF
																						// report

				}
				
					} catch (Exception sqlExp) {
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

		}

		
		
		
		
		
		
		
		
		@RequestMapping(value = "/GenerateProvincialScheduleAE", method = RequestMethod.POST)
		public String GenerateProvincialScheduleAE(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel,
				HttpServletResponse response) throws JRException, IOException,
				NamingException {
			//String cycle = pivModel.getCycle();
			String cycle= "";
			if(pivModel.getCycleObj() != null){
				cycle=pivModel.getCycleObj().getId().getCycleId();
				
			}
			
			System.out.println("cycle : " + cycle);
			String deptId = (String)request.getSession().getAttribute("deptId");
			String comp_id = glDeptDao.getDD(deptId);
			System.out.println("comp_id : " + comp_id);
			
			String province1  = glCompDao.getProvince(comp_id);
			province1 = province1.trim();
			System.out.println("province : " + province1);
			
			String reportFileName ="";
			String downloadReportName ="";
			if(pivModel.getMode().equalsIgnoreCase("HOTLINE")){
				reportFileName ="HLM";
				downloadReportName="Hot_Line_Report";
				System.out.println("reportFileName : " + reportFileName);
			}else if(pivModel.getMode().equalsIgnoreCase("TTWT")){
				reportFileName ="TTWT";
				downloadReportName="Towers_without_Tappings_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("CLE")){
				reportFileName ="CLEM";
				downloadReportName="Cold_Line_Electrical_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("CLC")){
				reportFileName ="CLC";
				downloadReportName="Cold_Line_Civil_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("MW")){
				reportFileName ="MW";
				downloadReportName="Miscellaneous_Works_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("EWOP")){
				reportFileName ="EWOPP";
				downloadReportName="Electrical_Works_on_Poles";
				
			}else if(pivModel.getMode().equalsIgnoreCase("VR")){
				reportFileName ="VR";
				downloadReportName="Vegetation_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("TP")){
				reportFileName ="Tapping";
				downloadReportName="Tower_Tapping_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("MPL")){
				reportFileName ="MPL";
				downloadReportName="Missing_Part_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("PELT")){
				reportFileName ="PESummary";
				downloadReportName="Line _Type";
				
			}else if(pivModel.getMode().equalsIgnoreCase("PECONT")){
				reportFileName ="PE__Conductor_Summay";
				downloadReportName="Conductor_Type";
				
			}else if(pivModel.getMode().equalsIgnoreCase("PECIRT")){
				reportFileName ="PE_Circuit_Summary";
				downloadReportName="Circuit_Type";
				
			}else if(pivModel.getMode().equalsIgnoreCase("PECIRCONT")){
				reportFileName ="PE__Conductor_circuit_Summay";
				downloadReportName="Circuit_Conductor_Type";
				
			}else if(pivModel.getMode().equalsIgnoreCase("HAR")){
				reportFileName ="TLDS";
				//downloadReportName="Miscellaneous_Works_Report";
				
			}else if(pivModel.getMode().equalsIgnoreCase("HAR2")){
				reportFileName ="TSS";
				//downloadReportName="Miscellaneous_Works_Report";
				
			}else{
				
			}
			 
			Connection conn = null;

			try {
				System.out.println("yyy ttt uuu iiii ooo");
				//conn = jasperDao.getConnection();
				conn = jasperDao.getConnection();
				//String rptFormat = jasperInputForm.getRptFmt();
				//String noy = jasperInputForm.getNoofYears();
				
				String rptFormat = "pdf";
				String noy = "9";

				//System.out.println("province " + pivModel.getGlcompmobj().getCompId());
			//	System.out.println("area " + pivModel.getGldeptobj().getDeptId());
			////	System.out.println("line " + pivModel.getLine().getCode());
			//	System.out.println("cycle " + pivModel.getCycle());
				System.out.println("province  ffff ");
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				//String province = pivModel.getGlcompmobj().getCompId();
				String code = "";
				if(pivModel.getLine() != null){
					code = String.valueOf(pivModel.getLine().getId());
				}
				System.out.println("province  ffff 1 ");
				
				//String code = pivModel.getLine().getCode();
				//String id = lineDao.findIdByCode(code.trim());
				String id = code;
				System.out.println("id " + id);
				String area = pivModel.getGldeptobj().getDeptId();
				if(area.equalsIgnoreCase("NONE")){
					area = "";
				}
				
				if(code.equalsIgnoreCase("-1")){
					id = "";
				}
				if(cycle.equalsIgnoreCase("NONE")){
					cycle = "";
				}
				System.out.println("province  ffff 3 ");
				
				//if(province.equalsIgnoreCase("NONE")){
					//province = "";
				//}
				
				
				
				hmParams.put("@province","'" +province1 +"'");
				hmParams.put("@area","'" +area +"'");
				hmParams.put("@line_id","'"+id+"'");
				hmParams.put("@cycle","'"+cycle+"'");
				System.out.println("province  ffff 5");
				
				System.out.println("province " + province1);
				System.out.println("area " + area);
				System.out.println("line " + id);
				System.out.println("cycle " + cycle);


				//hmParams.put("Title", "Employees working more than " + noy
					//	+ " Years");

				//JasperReport jasperReport = jasperDao.getCompiledFile(reportFileName,
						//request);
				//JasperReport jasperReport = jasperDao.getCompiledFile(reportFileName,request);
				JasperReport jasperReport = jasperDao.getCompiledFileMVMMS(reportFileName,request);
				//JasperPrint jasperPrint1 = JasperFillManager.fillReport(jasperReport, hmParams, conn);  
				System.out.println("province  ffff 7");
				
				Calendar calendar = Calendar.getInstance();
				
				String reportName = downloadReportName +"-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + ".pdf";
						
				System.out.println("province  ffff 10");
				
				if (rptFormat.equalsIgnoreCase("html")) {

					JasperPrint jasperPrint = JasperFillManager.fillReport(
							jasperReport, hmParams, conn);
					jasperDao.generateReportHtml(jasperPrint, request, response); // For
																				// HTML
																				// report

				}

				else if (rptFormat.equalsIgnoreCase("pdf")) {
					System.out.println("province  ffff 4");
					
					jasperDao.generateReportPDFWithName(response, hmParams, jasperReport, conn,reportName); // For
					System.out.println("province  ffff 5 ");
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

		}
		
		
		
		@RequestMapping(value = "/Tensiontowerswithouttapping", method = RequestMethod.POST)
		public String tensionTowersWithoutTapping(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel,
				HttpServletResponse response) throws JRException, IOException,
				NamingException {

			String deptId = (String)request.getSession().getAttribute("deptId");
			String reportFileName ="MaintenanceScheduleTension";
			Connection conn = null;

			try {
				System.out.println("yyy ttt uuu iiii ooo");
				//conn = jasperDao.getConnection();
				conn = jasperDao.getConnection();
				//String rptFormat = jasperInputForm.getRptFmt();
				//String noy = jasperInputForm.getNoofYears();
				
				String rptFormat = "pdf";
				String noy = "9";


				System.out.println("area " + pivModel.getGldeptobj().getDeptId());
				System.out.println("line " + pivModel.getLine().getCode());

				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				String code = pivModel.getLine().getCode();
				String id = lineDao.findIdByCode(code.trim());
				System.out.println("id " + id);

				hmParams.put("@area","'" +pivModel.getGldeptobj().getDeptId() +"'");
				hmParams.put("@line_id","'"+id+"'");
				JasperReport jasperReport = jasperDao.getCompiledFile(reportFileName,request);
				if (rptFormat.equalsIgnoreCase("html")) {

					JasperPrint jasperPrint = JasperFillManager.fillReport(
							jasperReport, hmParams, conn);
					jasperDao.generateReportHtml(jasperPrint, request, response); // For
																				// HTML
																				// report

				}

				else if (rptFormat.equalsIgnoreCase("pdf")) {

					jasperDao.generateReportPDF(response, hmParams, jasperReport, conn); // For
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

		}
		
		
		
		
		@RequestMapping(value = "/PESummary", method = RequestMethod.POST)
		public String PESummary(HttpServletRequest request,@ModelAttribute("model") PivModel pivModel,
				HttpServletResponse response) throws JRException, IOException,
				NamingException {
			System.out.println("PESummaryPESummary");
			
			String province = "";
			if(pivModel.getGlcompmobj() != null){
		       province = pivModel.getGlcompmobj().getCompId();
				
			}
			String area = pivModel.getGldeptobj().getDeptId();
			String lineobj = pivModel.getLine().getCode();
			String lineType ="";
			if(pivModel.getLineType() != null){
				lineType = pivModel.getLineType().getId();
			}
			
			String deptId = (String)request.getSession().getAttribute("deptId");
			String conTypeId = "";
			if(pivModel.getMmsConTypePE() != null){
				conTypeId = pivModel.getMmsConTypePE().getId();
			}
			String cirType = "";
			if(pivModel.getCircuteType() != null){
				cirType = pivModel.getCircuteType();
			}
			String reportFileName ="";
			Connection conn = null;

			try {
				System.out.println("area: "+area);
				System.out.println("line: "+lineobj);
				System.out.println("lineType: "+lineType);
				
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				
				//System.out.println("lineType: "+lineType);
				//lineType ="Backbone";
				//conn = jasperDao.getConnection();
				conn = jasperDao.getConnection();
				
if(pivModel.getGlcompmobj() != null){
				System.out.println("province " + pivModel.getGlcompmobj().getCompId());
}
				System.out.println("area " + pivModel.getGldeptobj().getDeptId());
				System.out.println("line " + pivModel.getLine().getCode());

				//String province = pivModel.getGlcompmobj().getCompId();
				String code = pivModel.getLine().getCode();
				String id = lineDao.findIdByCode(code.trim());
				System.out.println("id " + id);
				//String area = pivModel.getGldeptobj().getDeptId();
				if(area.equalsIgnoreCase("NONE")){
					area = "";
				}
				
				if(code.equalsIgnoreCase("NONE")){
					id = "";
				}
				if(province.equalsIgnoreCase("NONE")){
					province = "";
				}
				if(conTypeId.equalsIgnoreCase("NONE")){
					conTypeId = "";
				}
				if(cirType.equalsIgnoreCase("NONE")){
					cirType = "";
				}
				
				System.out.println("cirType " + cirType);
				System.out.println("conTypeId " + conTypeId);
				
				if(lineType.equalsIgnoreCase("NONE")){
					lineType = "";
				}
				else if(lineType.equalsIgnoreCase("1")){
					lineType ="Backbone";
				}else if (lineType.equalsIgnoreCase("2")){
					lineType ="Distributor";
				}else{
					lineType ="Both";
				}
				System.out.println("lineType " + lineType);
				
				
				
				System.out.println("pivModel.getMode(dddd) " + pivModel.getMode());
				//String rptFormat = jasperInputForm.getRptFmt();
				//String noy = jasperInputForm.getNoofYears();
				
				String downLoadedFileName = "";
				if(pivModel.getMode().equalsIgnoreCase("PELT")){
					System.out.println("pivModel.getMode() " + pivModel.getMode());
					reportFileName ="PESummary";
					hmParams.put("@line_type","'"+lineType+"'");
					hmParams.put("@province","'" +province +"'");
					hmParams.put("@area","'" +area +"'");
					downLoadedFileName = "Line_Type";
					
				}else if(pivModel.getMode().equalsIgnoreCase("PECONT")){
					System.out.println("pivModel.getMode() " + pivModel.getMode());
					reportFileName ="PE__Conductor_Summay";
					hmParams.put("@conductor_type","'"+conTypeId+"'");
					hmParams.put("@province","'" +province +"'");
					hmParams.put("@area","'" +area +"'");
					
					downLoadedFileName = "Conductor_Type";
					
				}else if(pivModel.getMode().equalsIgnoreCase("PECIRT")){
					System.out.println("pivModel.getMode() " + pivModel.getMode());
					reportFileName ="PE_Circuit_Summary";
					hmParams.put("@circuit_type","'"+cirType+"'");
					hmParams.put("@province","'" +province +"'");
					hmParams.put("@area","'" +area +"'");
					downLoadedFileName = "Circuit_Type";
					
				}else if(pivModel.getMode().equalsIgnoreCase("PECIRCONT")){
					System.out.println("pivModel.getMode() " + pivModel.getMode());
					reportFileName ="PE__Conductor_circuit_Summay";
					hmParams.put("@circuit_type","'"+cirType+"'");
					hmParams.put("@conductor_type","'"+conTypeId+"'");
					hmParams.put("@province","'" +province +"'");
					hmParams.put("@area","'" +area +"'");
					downLoadedFileName = "Circuit_Conductor_Type";
					
				}else{
					
				}
				
				String rptFormat = "pdf";
				String noy = "9";
				Calendar calendar = Calendar.getInstance();
				

				String reportName = downLoadedFileName +"-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + ".pdf";
				
				//hmParams.put("@area","'" +area+"'");
				/*hmParams.put("@line_type","'"+lineType+"'");
				hmParams.put("@province","'" +province +"'");
				hmParams.put("@area","'" +area +"'");
				hmParams.put("@conType","'" +conTypeId +"'");
				hmParams.put("@cirType","'" +cirType +"'");*/
				//hmParams.put("@line_id","'"+id+"'");
				
				//hmParams.put("@line_type","'"+lineType+"'");
				JasperReport jasperReport = jasperDao.getCompiledFileMVMMS(reportFileName,request);
				if (rptFormat.equalsIgnoreCase("html")) {

					JasperPrint jasperPrint = JasperFillManager.fillReport(
							jasperReport, hmParams, conn);
					jasperDao.generateReportHtml(jasperPrint, request, response); // For
																				// HTML
																				// report

				}

				else if (rptFormat.equalsIgnoreCase("pdf")) {

					jasperDao.generateReportPDFWithName(response, hmParams, jasperReport, conn,reportName); // For
																						// PDF
																						// report

				}

			} catch (Exception sqlExp) {
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

		}
		
		
		
		
		@RequestMapping(value = "/PESummaryNew", method = RequestMethod.GET)
		public String PESummaryNew(HttpServletRequest request,@RequestParam("province") String province,@RequestParam("area") String area,HttpServletResponse response) throws JRException, IOException,
				NamingException {
			System.out.println("PESummaryPESummary");
			String deptId = (String)request.getSession().getAttribute("deptId");
			String reportFileName ="";
			Connection conn = null;

			try {
				System.out.println("area: "+area);
				//System.out.println("lineType: "+lineType);
				
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				conn = jasperDao.getConnection();
				//System.out.println("id " + id);
				//String area = pivModel.getGldeptobj().getDeptId();
				if(area.equalsIgnoreCase("NONE")){
					area = "";
				}
				
				if(province.equalsIgnoreCase("NONE")){
					province = "";
				}
				String conTypeId = "";
				String cirType = "";
				
				System.out.println("cirType " + cirType);
				System.out.println("conTypeId " + conTypeId);
				
				/*if(lineType.equalsIgnoreCase("NONE")){
					lineType = "";
				}
				else if(lineType.equalsIgnoreCase("1")){
					lineType ="Backbone";
				}else if (lineType.equalsIgnoreCase("2")){
					lineType ="Distributor";
				}else{
					lineType ="Both";
				}
				*/
				String downLoadedFileName ="";
				//System.out.println("lineType " + lineType);
					reportFileName ="PE__Conductor_circuit_Summay";
					hmParams.put("@circuit_type","'"+cirType+"'");
					hmParams.put("@conductor_type","'"+conTypeId+"'");
					hmParams.put("@province","'" +province +"'");
					hmParams.put("@area","'" +area +"'");
					downLoadedFileName = "Circuit_Conductor_Type";
					
				
				String rptFormat = "pdf";
				String noy = "9";
				Calendar calendar = Calendar.getInstance();
				

				String reportName = downLoadedFileName +"-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + ".pdf";
				
				JasperReport jasperReport = jasperDao.getCompiledFileMVMMS(reportFileName,request);
				if (rptFormat.equalsIgnoreCase("html")) {

					JasperPrint jasperPrint = JasperFillManager.fillReport(
							jasperReport, hmParams, conn);
					jasperDao.generateReportHtml(jasperPrint, request, response); // For
																				// HTML
																				// report

				}

				else if (rptFormat.equalsIgnoreCase("pdf")) {

					jasperDao.generateReportPDFWithName(response, hmParams, jasperReport, conn,reportName); // For
																						// PDF
																						// report

				}

			} catch (Exception sqlExp) {
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

		}
		
		
		@RequestMapping(value = "/PESummaryNewArea", method = RequestMethod.GET)
		public String PESummaryNewArea(HttpServletRequest request,@RequestParam("area") String area,HttpServletResponse response) throws JRException, IOException,
				NamingException {
			System.out.println("PESummaryPESummary");
			String deptId = (String)request.getSession().getAttribute("deptId");
			String reportFileName ="";
			Connection conn = null;

			try {
				System.out.println("area: "+area);
				//System.out.println("lineType: "+lineType);
				
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				conn = jasperDao.getConnection();
				//System.out.println("id " + id);
				//String area = pivModel.getGldeptobj().getDeptId();
				if(area.equalsIgnoreCase("NONE")){
					area = "";
				}
				
				String province = "";
				String conTypeId = "";
				String cirType = "";
				
				System.out.println("cirType " + cirType);
				System.out.println("conTypeId " + conTypeId);
				
				/*if(lineType.equalsIgnoreCase("NONE")){
					lineType = "";
				}
				else if(lineType.equalsIgnoreCase("1")){
					lineType ="Backbone";
				}else if (lineType.equalsIgnoreCase("2")){
					lineType ="Distributor";
				}else{
					lineType ="Both";
				}
				*/
				String downLoadedFileName ="";
				//System.out.println("lineType " + lineType);
					reportFileName ="PE_Summary_Area";
					hmParams.put("@circuit_type","'"+cirType+"'");
					hmParams.put("@conductor_type","'"+conTypeId+"'");
					hmParams.put("@province","'" +province +"'");
					hmParams.put("@area","'" +area +"'");
					downLoadedFileName = "Circuit_Conductor_Type";
					
				
				String rptFormat = "pdf";
				String noy = "9";
				Calendar calendar = Calendar.getInstance();
				

				String reportName = downLoadedFileName +"-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + ".pdf";
				
				JasperReport jasperReport = jasperDao.getCompiledFileMVMMS(reportFileName,request);
				if (rptFormat.equalsIgnoreCase("html")) {

					JasperPrint jasperPrint = JasperFillManager.fillReport(
							jasperReport, hmParams, conn);
					jasperDao.generateReportHtml(jasperPrint, request, response); // For
																				// HTML
																				// report

				}

				else if (rptFormat.equalsIgnoreCase("pdf")) {

					jasperDao.generateReportPDFWithName(response, hmParams, jasperReport, conn,reportName); // For
																						// PDF
																						// report

				}

			} catch (Exception sqlExp) {
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

		}



		
		
		
		
		
		
		
		
		
		@RequestMapping(value = "/PESummaryAE", method = RequestMethod.POST)
		public String PESummaryAE(HttpServletRequest request,@ModelAttribute("model") PivModel pivModel,
				HttpServletResponse response) throws JRException, IOException,
				NamingException {
			
			System.out.println("PESummaryPESummary1000000");
			
			System.out.println("PESummaryPESummary");
			
			String province = "";
			if(pivModel.getGlcompmobj() != null){
			    province = pivModel.getGlcompmobj().getCompId();
				
			}
			String area = pivModel.getGldeptobj().getDeptId();
			String lineobj = pivModel.getLine().getCode();
			String lineType ="";
			if(pivModel.getLineType() != null){
				lineType = pivModel.getLineType().getId();
			}
			
			String deptId = (String)request.getSession().getAttribute("deptId");
			String conTypeId = "";
			if(pivModel.getMmsConTypePE() != null){
				conTypeId = pivModel.getMmsConTypePE().getId();
			}
			String cirType = "";
			if(pivModel.getCircuteType() != null){
				cirType = pivModel.getCircuteType();
			}
			String reportFileName ="";
			Connection conn = null;

			try {
				System.out.println("area: "+area);
				System.out.println("line: "+lineobj);
				System.out.println("lineType: "+lineType);
				
				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				
				//System.out.println("lineType: "+lineType);
				//lineType ="Backbone";
				//conn = jasperDao.getConnection();
				conn = jasperDao.getConnection();
				

				System.out.println("province " + pivModel.getGlcompmobj().getCompId());
				System.out.println("area " + pivModel.getGldeptobj().getDeptId());
				System.out.println("line " + pivModel.getLine().getCode());

				//String province = pivModel.getGlcompmobj().getCompId();
				String code = pivModel.getLine().getCode();
				String id = lineDao.findIdByCode(code.trim());
				System.out.println("id " + id);
				//String area = pivModel.getGldeptobj().getDeptId();
				if(area.equalsIgnoreCase("NONE")){
					area = "";
				}
				
				if(code.equalsIgnoreCase("NONE")){
					id = "";
				}
				if(province.equalsIgnoreCase("NONE")){
					province = "";
				}
				if(conTypeId.equalsIgnoreCase("NONE")){
					conTypeId = "";
				}
				if(cirType.equalsIgnoreCase("NONE")){
					cirType = "";
				}
				
				System.out.println("cirType " + cirType);
				System.out.println("conTypeId " + conTypeId);
				
				if(lineType.equalsIgnoreCase("NONE")){
					lineType = "";
				}
				else if(lineType.equalsIgnoreCase("1")){
					lineType ="Backbone";
				}else if (lineType.equalsIgnoreCase("2")){
					lineType ="Distributor";
				}else{
					lineType ="Both";
				}
				System.out.println("lineType " + lineType);
				
				
				
				System.out.println("pivModel.getMode(dddd) " + pivModel.getMode());
				//String rptFormat = jasperInputForm.getRptFmt();
				//String noy = jasperInputForm.getNoofYears();
				
				String downLoadedFileName = "";
				if(pivModel.getMode().equalsIgnoreCase("PELT")){
					System.out.println("pivModel.getMode() " + pivModel.getMode());
					reportFileName ="PESummary";
					hmParams.put("@line_type","'"+lineType+"'");
					hmParams.put("@province","'" +province +"'");
					hmParams.put("@area","'" +area +"'");
					downLoadedFileName = "Line_Type";
					
				}else if(pivModel.getMode().equalsIgnoreCase("PECONT")){
					System.out.println("pivModel.getMode() " + pivModel.getMode());
					reportFileName ="PE__Conductor_Summay";
					hmParams.put("@conductor_type","'"+conTypeId+"'");
					hmParams.put("@province","'" +province +"'");
					hmParams.put("@area","'" +area +"'");
					
					downLoadedFileName = "Conductor_Type";
					
				}else if(pivModel.getMode().equalsIgnoreCase("PECIRT")){
					System.out.println("pivModel.getMode() " + pivModel.getMode());
					reportFileName ="PE_Circuit_Summary";
					hmParams.put("@circuit_type","'"+cirType+"'");
					hmParams.put("@province","'" +province +"'");
					hmParams.put("@area","'" +area +"'");
					downLoadedFileName = "Circuit_Type";
					
				}else if(pivModel.getMode().equalsIgnoreCase("PECIRCONT")){
					System.out.println("pivModel.getMode() " + pivModel.getMode());
					reportFileName ="PE__Conductor_circuit_Summay";
					hmParams.put("@circuit_type","'"+cirType+"'");
					hmParams.put("@conductor_type","'"+conTypeId+"'");
					hmParams.put("@province","'" +province +"'");
					hmParams.put("@area","'" +area +"'");
					downLoadedFileName = "Circuit_Conductor_Type";
					
				}else{
					
				}
				
				String rptFormat = "pdf";
				String noy = "9";
				Calendar calendar = Calendar.getInstance();
				

				String reportName = downLoadedFileName +"-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
						+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
						+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + ".pdf";
				
				//hmParams.put("@area","'" +area+"'");
				/*hmParams.put("@line_type","'"+lineType+"'");
				hmParams.put("@province","'" +province +"'");
				hmParams.put("@area","'" +area +"'");
				hmParams.put("@conType","'" +conTypeId +"'");
				hmParams.put("@cirType","'" +cirType +"'");*/
				//hmParams.put("@line_id","'"+id+"'");
				
				//hmParams.put("@line_type","'"+lineType+"'");
				JasperReport jasperReport = jasperDao.getCompiledFileMVMMS(reportFileName,request);
				if (rptFormat.equalsIgnoreCase("html")) {

					JasperPrint jasperPrint = JasperFillManager.fillReport(
							jasperReport, hmParams, conn);
					jasperDao.generateReportHtml(jasperPrint, request, response); // For
																				// HTML
																				// report

				}

				else if (rptFormat.equalsIgnoreCase("pdf")) {

					jasperDao.generateReportPDFWithName(response, hmParams, jasperReport, conn,reportName); // For
																						// PDF
																						// report

				}

			} catch (Exception sqlExp) {
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

		}

		
		@RequestMapping(value = "/ColdlineElectrical", method = RequestMethod.POST)
		public String coldlineElectrical(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel,
				HttpServletResponse response) throws JRException, IOException,
				NamingException {

			String deptId = (String)request.getSession().getAttribute("deptId");
			String reportFileName ="ColdLineElectrialMaintenance";
			Connection conn = null;

			try {
				System.out.println("yyy ttt uuu iiii ooo");
				//conn = jasperDao.getConnection();
				conn = jasperDao.getConnection();
				//String rptFormat = jasperInputForm.getRptFmt();
				//String noy = jasperInputForm.getNoofYears();
				
				String rptFormat = "pdf";
				String noy = "9";


				System.out.println("rpt format " + rptFormat);
				System.out.println("no of years " + noy);

				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				
				//String pivNo = "PIV/423.10/ANC/2011/0795";
				//String pivNo = pivno;
				String cc = "423.10";
				//hmParams.put("noy", new Integer(noy));
				//hmParams.put("@pivNo","'" +pivNo +"'");
				//hmParams.put("@costCtr","'"+cc+"'");

				//hmParams.put("Title", "Employees working more than " + noy
					//	+ " Years");

				//JasperReport jasperReport = jasperDao.getCompiledFile(reportFileName,
						//request);
				JasperReport jasperReport = jasperDao.getCompiledFile(reportFileName,request);
				if (rptFormat.equalsIgnoreCase("html")) {

					JasperPrint jasperPrint = JasperFillManager.fillReport(
							jasperReport, hmParams, conn);
					jasperDao.generateReportHtml(jasperPrint, request, response); // For
																				// HTML
																				// report

				}

				else if (rptFormat.equalsIgnoreCase("pdf")) {

					jasperDao.generateReportPDF(response, hmParams, jasperReport, conn); // For
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

		}
		
		
		@RequestMapping(value = "/ColdlineCivil", method = RequestMethod.POST)
		public String ColdlineCivil(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel,
				HttpServletResponse response) throws JRException, IOException,
				NamingException {

			String deptId = (String)request.getSession().getAttribute("deptId");
			String reportFileName ="ColdLineCivillMaintenance";
			Connection conn = null;

			try {
				System.out.println("yyy ttt uuu iiii ooo");
				//conn = jasperDao.getConnection();
				conn = jasperDao.getConnection();
				//String rptFormat = jasperInputForm.getRptFmt();
				//String noy = jasperInputForm.getNoofYears();
				
				String rptFormat = "pdf";
				String noy = "9";


				System.out.println("rpt format " + rptFormat);
				System.out.println("no of years " + noy);

				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				
				//String pivNo = "PIV/423.10/ANC/2011/0795";
				//String pivNo = pivno;
				String cc = "423.10";
				//hmParams.put("noy", new Integer(noy));
				//hmParams.put("@pivNo","'" +pivNo +"'");
				//hmParams.put("@costCtr","'"+cc+"'");

				//hmParams.put("Title", "Employees working more than " + noy
					//	+ " Years");

				//JasperReport jasperReport = jasperDao.getCompiledFile(reportFileName,
						//request);
				JasperReport jasperReport = jasperDao.getCompiledFile(reportFileName,request);
				if (rptFormat.equalsIgnoreCase("html")) {

					JasperPrint jasperPrint = JasperFillManager.fillReport(
							jasperReport, hmParams, conn);
					jasperDao.generateReportHtml(jasperPrint, request, response); // For
																				// HTML
																				// report

				}

				else if (rptFormat.equalsIgnoreCase("pdf")) {

					jasperDao.generateReportPDF(response, hmParams, jasperReport, conn); // For
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

		}
		
		@RequestMapping(value = "/spObservation", method = RequestMethod.POST)
		public String spObservation(HttpServletRequest request,@ModelAttribute("pivModel") PivModel pivModel,
				HttpServletResponse response) throws JRException, IOException,
				NamingException {

			String deptId = (String)request.getSession().getAttribute("deptId");
			String reportFileName ="HotLineMaintenanceNew";
			Connection conn = null;

			try {
				System.out.println("yyy ttt uuu iiii ooo");
				//conn = jasperDao.getConnection();
				conn = jasperDao.getConnection();
				//String rptFormat = jasperInputForm.getRptFmt();
				//String noy = jasperInputForm.getNoofYears();
				
				String rptFormat = "pdf";
				String noy = "9";


				System.out.println("rpt format " + rptFormat);
				System.out.println("no of years " + noy);

				HashMap<String, Object> hmParams = new HashMap<String, Object>();
				
				//String pivNo = "PIV/423.10/ANC/2011/0795";
				//String pivNo = pivno;
				String cc = "423.10";
				//hmParams.put("noy", new Integer(noy));
				//hmParams.put("@pivNo","'" +pivNo +"'");
				//hmParams.put("@costCtr","'"+cc+"'");

				//hmParams.put("Title", "Employees working more than " + noy
					//	+ " Years");

				//JasperReport jasperReport = jasperDao.getCompiledFile(reportFileName,
						//request);
				JasperReport jasperReport = jasperDao.getCompiledFile(reportFileName,request);
				if (rptFormat.equalsIgnoreCase("html")) {

					JasperPrint jasperPrint = JasperFillManager.fillReport(
							jasperReport, hmParams, conn);
					jasperDao.generateReportHtml(jasperPrint, request, response); // For
																				// HTML
																				// report

				}

				else if (rptFormat.equalsIgnoreCase("pdf")) {

					jasperDao.generateReportPDF(response, hmParams, jasperReport, conn); // For
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
