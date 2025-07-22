package com.it.piv.mms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.admin.domain.Sauserm;
import com.it.piv.mms.repo.GlcompmDao;
import com.it.piv.mms.repo.GldeptmDao;
import com.it.piv.mms.repo.LoginDao;
import com.it.piv.mms.repo.ProvinceBranchDao;
import com.it.piv.util.common.PathMMS;

@Controller
public class LoginMMSController {
	
	@Autowired
	private LoginDao login;
	@Autowired
	private GlcompmDao glcompmDao;
	@Autowired
	private GldeptmDao gldeptDao;
	
	@Autowired
	private ProvinceBranchDao provinceDao;
	
	
	@RequestMapping(value = "login", method = RequestMethod.POST)	
	public ModelAndView login(@RequestParam Map<String,String> requestParams,HttpServletRequest request) throws Exception{
		   String userName=requestParams.get("loginUser");
		   String password=requestParams.get("password");
		  // System.out.println("loginUser = "+userName);
		  // System.out.println("password = "+password);
		   
		   //String user = "50120DEO1";
		   //String user =  login.getSauserm(userName).getUserId();
		   //System.out.println("user------------------------->>>>>>>>>>>>>>>>>>>> "+user);

//		   if(userName != user){
//			   
//			   return new ModelAndView("MMS_Login","errUser","Invalid User name or Password");
//		   }
//		   
//		   else{	
			   
			   boolean isValidLogin = login.validateLogin(userName, password);
			   
			   if(isValidLogin)
			   { 
				   	//System.out.println("ValidLogin: "+login.getSauserm(userName));
					request.getSession().setAttribute("loggedUser", userName.toUpperCase());
					request.getSession().setAttribute("loggedUserRole", login.getSauserm(userName).getUserLevel());
					request.getSession().setAttribute("deptId", login.getSauserm(userName).getRptUser().trim());
					request.getSession().setAttribute("userNameUser", login.getSauserm(userName).getUserNm().trim());
					request.getSession().setAttribute("reportpath", PathMMS.getReportPath());
					
					String deptid = login.getSauserm(userName).getRptUser().trim();
			//		System.out.println("ffff:" +deptid);
					String deptName = gldeptDao.getName(login.getSauserm(userName).getRptUser().trim());
				//	System.out.println("ffff1:" +deptName);
					request.getSession().setAttribute("deptName",deptName );
					
					String branchCode = provinceDao.getBranchCode(deptid);
					//System.out.println("branchCode:" +branchCode);
					
					request.getSession().setAttribute("branchCode",branchCode );
					
					
					
					//String dept_id = login.getSauserm(userName).getRptUser().trim();
					//String province = gldeptDao.getDD(dept_id);
					//System.out.println("province" +province);
					//String dd = glcompmDao.getDistDivision(province);
					//request.getSession().setAttribute("DistDiv", dd);
					
					//request.getSession().setAttribute("headerName", "Dash Board");
					
					
					//String dept = request.getSession().getAttribute("deptId").toString();
					//String UN = request.getSession().getAttribute("loggedUser").toString();
					//String user = login.getSauserm(userName).getUserLevel();
					
					//count = pivDetailDao.findNewPivCount(dept, "N");
					
						ModelAndView mv = new ModelAndView("dashBoards","success","Login Success");
						
						
						
						return mv;
					
					
					//mv.addObject("UserName",UN);
					//mv.addObject("dept", dept);
					
					
			   }
			   
			   else
			   {
//				   if(userName != user){
//					   
//					   return new ModelAndView("MMS_Login","errUser","Invalid User name or Password");
//				   }
				   //else{
					   return new ModelAndView("MMS_Login","errPassword","Invalid User name or Password");
				   
				  // }
			   }
//		   }
		}
	
	
	@RequestMapping(value = "pngLogin", method = RequestMethod.POST)	
	public ModelAndView loginPNG(@RequestParam Map<String,String> requestParams,HttpServletRequest request) throws Exception{
		   
		System.out.println("loginPNG-------------->>>>>>>>>>>>>>>>>>>> ");

		
		String userName=requestParams.get("loginUser");
		   String password=requestParams.get("password");
		   System.out.println("loginUser = "+userName);
		   System.out.println("password = "+password);
		   
		   //String user = "50120DEO1";
		   //String user =  login.getSauserm(userName).getUserId();
		   //System.out.println("user------------------------->>>>>>>>>>>>>>>>>>>> "+user);

//		   if(userName != user){
//			   
//			   return new ModelAndView("MMS_Login","errUser","Invalid User name or Password");
//		   }
//		   
//		   else{	
			   
			   boolean isValidLogin = login.validateLoginOMS(userName, password);
			   
			   if(isValidLogin)
			   { 
				   	//System.out.println("ValidLogin: "+login.getSauserm(userName));
					request.getSession().setAttribute("loggedUser", userName.toUpperCase());
					request.getSession().setAttribute("loggedUserRole", login.getSauserm(userName).getUserLevel());
					request.getSession().setAttribute("deptId", login.getSauserm(userName).getRptUser().trim());
					String deptid = login.getSauserm(userName).getRptUser().trim();
					System.out.println("ffff:" +deptid);
					//String deptName = gldeptDao.getName(login.getSauserm(userName).getRptUser().trim());
					//String deptName = gldeptDao.getName(deptid);
					
					//System.out.println("ffff1:" +deptName);
					request.getSession().setAttribute("deptName","Papua New Guinea");
					
					
					//String dept_id = login.getSauserm(userName).getRptUser().trim();
					//String province = gldeptDao.getDD(dept_id);
					//System.out.println("province" +province);
					//String dd = glcompmDao.getDistDivision(province);
					//request.getSession().setAttribute("DistDiv", dd);
					
					//request.getSession().setAttribute("headerName", "Dash Board");
					
					
					//String dept = request.getSession().getAttribute("deptId").toString();
					//String UN = request.getSession().getAttribute("loggedUser").toString();
					//String user = login.getSauserm(userName).getUserLevel();
					
					//count = pivDetailDao.findNewPivCount(dept, "N");
					
						ModelAndView mv = new ModelAndView("PNGdashBoards","success","Login Success");
						
						
						
						return mv;
					
					
					//mv.addObject("UserName",UN);
					//mv.addObject("dept", dept);
					
					
			   }
			   
			   else
			   {
//				   if(userName != user){
//					   
//					   return new ModelAndView("MMS_Login","errUser","Invalid User name or Password");
//				   }
				   //else{
					   return new ModelAndView("PNG_Login","errPassword","Invalid User name or Password");
				   
				  // }
			   }
//		   }
		}
	
	
	
	@RequestMapping(value = "/loginnew", method = RequestMethod.GET , produces = "application/json")	
	public @ResponseBody String loginnew(@RequestParam("userName") String userName,@RequestParam("password") String password) throws Exception
	{
		   System.out.println("loginUser = "+userName);
		   System.out.println("password = "+password);
		   boolean isValied = login.validateLogin(userName, password);
		   if(isValied){
			   Sauserm ojbSauserm = login.getSauserm(userName);
			   return ojbSauserm.getRptUser();
			   
		   }else{
			   return "N";
		   }
			   
			 
	}
	
	
	@RequestMapping(value = "loginPCB", method = RequestMethod.POST)    
    public ModelAndView loginPCB(@RequestParam Map<String,String> requestParams,HttpServletRequest request) throws Exception{
           String userName=requestParams.get("loginUser");
           String password=requestParams.get("password");
           System.out.println("loginUser = "+userName);
           System.out.println("password = "+password);
          
           //String user = "50120DEO1";
           //String user =  login.getSauserm(userName).getUserId();
           //System.out.println("user------------------------->>>>>>>>>>>>>>>>>>>> "+user);

//           if(userName != user){
//              
//               return new ModelAndView("MMS_Login","errUser","Invalid User name or Password");
//           }
//          
//           else{    
              
               boolean isValidLogin = login.validateLogin(userName, password);
              
               if(isValidLogin)
               {
                       //System.out.println("ValidLogin: "+login.getSauserm(userName));
                    request.getSession().setAttribute("loggedUser", userName.toUpperCase());
                    request.getSession().setAttribute("loggedUserRole", login.getSauserm(userName).getUserLevel());
                    request.getSession().setAttribute("deptId", login.getSauserm(userName).getRptUser().trim());
                    String deptid = login.getSauserm(userName).getRptUser().trim();
                    System.out.println("ffff:" +deptid);
                    String deptName = gldeptDao.getName(login.getSauserm(userName).getRptUser().trim());
                    System.out.println("ffff1:" +deptName);
                    request.getSession().setAttribute("deptName",deptName );
                    
                    
                    
                    
                    
                    //String dept_id = login.getSauserm(userName).getRptUser().trim();
                    //String province = gldeptDao.getDD(dept_id);
                    //System.out.println("province" +province);
                    //String dd = glcompmDao.getDistDivision(province);
                    //request.getSession().setAttribute("DistDiv", dd);
                    
                    //request.getSession().setAttribute("headerName", "Dash Board");
                    
                    
                    //String dept = request.getSession().getAttribute("deptId").toString();
                    //String UN = request.getSession().getAttribute("loggedUser").toString();
                    //String user = login.getSauserm(userName).getUserLevel();
                    
                    //count = pivDetailDao.findNewPivCount(dept, "N");
                    
                        ModelAndView mv = new ModelAndView("PCBdashBoards","success","Login Success");
                        
                        
                        
                        return mv;
                    
                    
                    //mv.addObject("UserName",UN);
                    //mv.addObject("dept", dept);
                    
                    
               }
              
               else
               {
//                   if(userName != user){
//                      
//                       return new ModelAndView("MMS_Login","errUser","Invalid User name or Password");
//                   }
                   //else{
                       return new ModelAndView("PCB_Login","errPassword","Invalid User name or Password");
                  
                  // }
               }
//           }
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
