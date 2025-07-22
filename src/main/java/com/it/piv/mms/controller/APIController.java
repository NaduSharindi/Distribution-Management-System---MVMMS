package com.it.piv.mms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.admin.repo.SecurityDao;
import com.it.piv.mms.domain.ApprovalMm;
import com.it.piv.mms.domain.InterruptionObject;
import com.it.piv.mms.domain.RequestObject;
import com.it.piv.mms.domain.ResponseObject;
import com.it.piv.mms.domain.UserObject;
import com.it.piv.mms.repo.ApprovalMmDao;
import com.it.piv.mms.repo.GldeptmDao;

@Controller
public class APIController {
	
	@Autowired
	private ApprovalMmDao approvalMm;
	
	@Autowired
	private GldeptmDao deptDao;
	
	@Autowired
	private SecurityDao secDao;
	
   @RequestMapping(method= RequestMethod.GET,value="/mms-api/interruption/viewInterruption",  produces = "application/json",  consumes = "application/json")
   public @ResponseBody ResponseObject viewInterruption(@RequestParam("CebAssist_UserId") String userId){

	       List<InterruptionObject> resObj= null;
	       ResponseObject obj = new ResponseObject();
           String resCode = "500";
           String resValue = "Unsuccessful.";
           System.out.println("@@viewInterruption service@@");
           
       	   try

           {
                  if(userId!=null)
                  {
                	List<ApprovalMm>  listApprovalUnread =null;
          			listApprovalUnread = approvalMm.getAllInterruptionReqNew("431.00", "95", "INTREQ","1");
          			String province = deptDao.getDD(userId);
          			if(province != null){
          					province = province.trim();
          			}
          			List<String> areaListInt = deptDao.getAreaByProvinceNew(province);
          			String userLevel = "";
          			if(userId != null){
          			    userLevel = secDao.getAuthorizedLevel(userId);
          			
          			if(userLevel != null){
          				    userLevel = userLevel.trim();
          				if(userLevel.equalsIgnoreCase("EEC")){
          					listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","3");
          				}else{
          					listApprovalUnread = approvalMm.getAllInterruptionReqForProvinceNew(areaListInt, "95", "INTREQ","2");
          				}
          			}
          			}
          			resCode = "200";
          			resValue = "Successful.";
                    if(listApprovalUnread != null){
                    	  int x = listApprovalUnread.size();
                    	  resObj = new ArrayList<InterruptionObject>(x-1);
                    	  for(int i=0;i<x;i++){
                    		  ApprovalMm objApp= (ApprovalMm)listApprovalUnread.get(i);
                    		  InterruptionObject objIntObj = new InterruptionObject();
                    		  objIntObj.setInterruptionId(objApp.getApprovalId());
                    		  objIntObj.setInterruptionDate(objApp.getWorkingDate());
                    		  objIntObj.setSectionInterrupted(objApp.getReq2());
                    		  resObj.add(i, objIntObj);
                    	  }
                    	  
                    	  	  
                    }

                  }

          

           }

           catch(Exception e)

           {

                  resCode = "500";

                  resValue = "Service error.";

                  e.printStackTrace();

           }

           obj.setResponseCode(resCode);

           obj.setResponseValue(resValue);
           
           obj.setInterruptionList(resObj);

           return obj;

    }
   
   @RequestMapping(value="/Test1", method = RequestMethod.GET)
	public ModelAndView viewTest1(){
		ModelAndView model = new ModelAndView();
		model.setViewName("NewDash");

		return model;
}



}
