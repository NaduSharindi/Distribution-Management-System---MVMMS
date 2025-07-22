package com.it.piv.issue.repo;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;


public interface JasperDao {

	public Connection getConnection() throws SQLException;
	
	public JasperReport getCompiledFile(String fileName, HttpServletRequest request) throws JRException;

	public void generateReportHtml( JasperPrint jasperPrint, HttpServletRequest req, HttpServletResponse resp) throws IOException, JRException;
 
	public void generateReportPDF (HttpServletResponse resp, Map parameters, JasperReport jasperReport, Connection conn)throws JRException, NamingException, SQLException, IOException ;

	
	public void generateReportPDFWithName(HttpServletResponse resp, Map parameters, JasperReport jasperReport, Connection conn,String name)throws JRException, NamingException, SQLException, IOException ;

	public JasperReport getCompiledFileMVMMS(String fileName, HttpServletRequest request) throws JRException;
	
	public void generateReportPDFToFolder(HttpServletResponse resp, Map parameters, JasperReport jasperReport, Connection conn)throws JRException, NamingException, SQLException, IOException ;

	
	public void generateReportAPKWithName(HttpServletResponse resp, Map parameters, File file, Connection conn,String name)throws JRException, NamingException, SQLException, IOException ;

	

}