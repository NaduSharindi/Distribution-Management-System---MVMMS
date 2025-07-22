package com.it.piv.mms.controller;

/*
 * DBManager.java
 *
 * Created on September 24, 2008, 8:07 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gayani
 */
public class DBManager {
    
    /** Creates a new instance of DBManager */
    public DBManager() {
    }
    
    public static synchronized Connection getConnection() {
        try{
            //Class.forName("com.informix.jdbc.IfxDriver");
            //System.out.println("got connection");
            //return DriverManager.getConnection("jdbc:informix-sqli://10.128.0.113:1526/mispre:informixserver=cebwps2db","wpsdev", "wpsdev123");  
           // return DriverManager.getConnection("jdbc:informix-sqli://10.128.0.112:1526/misd4:informixserver=cebd4db","misd4", "poweR4");
            //return DriverManager.getConnection("jdbc:informix-sqli://10.128.0.112:1526/misr1:informixserver=cebd4db","misr1", "wahara123");  
            //return DriverManager.getConnection("jdbc:informix-sqli://10.128.0.113:1526/miswps2:informixserver=cebwps2db","miswps2", "tRansP3");
            
            //return DriverManager.getConnection("jdbc:informix-sqli://10.128.0.22:1526/wpnmis:informixserver=cebwpndb2","uniface", "uniface");
            
            Class.forName("com.sun.sql.jdbc.oracle.OracleDriver");

            //return DriverManager.getConnection("jdbc:sun:oracle://10.128.0.55:1521;SID=HQORADEV","misdev","misdevp");
            //return DriverManager.getConnection("jdbc:sun:oracle://10.128.0.165:1522;SID=HQORADB1","r1prod","r1prodn");
            //return DriverManager.getConnection("jdbc:sun:oracle://pr34.ceb:1521;SID=CEBR4","r4prod","r4prodn");
            //return DriverManager.getConnection("jdbc:sun:oracle://oracluster.ceb:1521;SID=hqorap1","prodmis","prodmisn");
              return DriverManager.getConnection("jdbc:oracle:thin://10.128.0.163:1521;SID=hqorap1","prodmis","prodmisn");
            
            //return DriverManager.getConnection("jdbc:sun:oracle://10.128.0.56:1521;SID=HQORAD1","dacons12","dacons12");
            //return DriverManager.getConnection("jdbc:sun:oracle://10.128.0.165:1522;SID=HQORADB1","r2prod","r2prodn");


        }catch(Exception e){
            return null;
        }
   }
    
    
}
