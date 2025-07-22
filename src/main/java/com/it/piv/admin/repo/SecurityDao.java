package com.it.piv.admin.repo;

import java.util.List;

import com.it.piv.admin.domain.Sauserm;
import com.it.piv.admin.domain.SausermMm;


//import com.mis.security.domain.LoginDetail;
public interface SecurityDao {
	String getPassword(String userName);
	List<String> getAuthorizedCostCenters(String userName);
	Boolean validateLogin(String userName, String password) throws Exception;
	Boolean validateLoginPNG(String userName, String password) throws Exception;
	String getCostCenter(String userName);
	String getAuthorizedLevel(String userName);
	List<String> getUserList(String deptId, String userLevel);
	void updateUserLevel(String deptId,String userId, String userLevel);
	//void createAutoIdLoginDetail(LoginDetail loginDetail, String webAppName);
	//void createLoginDetail(LoginDetail loginDetail, String webAppName);
	String getNextLogId(String logIdPrefix);
	Sauserm getSauserm(String userName);  
	SausermMm getSausermMms(String userName); 
	List<SausermMm> getUserList(String userLevel); 
	
	
	public List<SausermMm> getAllUserByRptUserMMS(String rpt_user,List<String> user_leve);
	List<Sauserm> getAllUserByRptUser(String rpt_user,String user_leve);
	List<SausermMm> getAllUserByRptUserMMS(String rpt_user,String user_leve);
	
	List<Sauserm> getAllUserByRptUser(String rpt_user,List<String> user_leve);
	List<Sauserm> getAllUserByRptUserCC(String rpt_user,List<String> user_leve,String loginUserLevel);
	public void updateSauserMMS(SausermMm mm);
	public void saveSauserMMS(SausermMm mm);
	
	
	public void updateSauser(String userId,String userName);
	public void saveSauser(Sauserm mm);
	
}
