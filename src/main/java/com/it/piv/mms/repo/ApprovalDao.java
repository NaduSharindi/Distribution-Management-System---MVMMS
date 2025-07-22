package com.it.piv.mms.repo;


import java.util.List;

import com.it.piv.mms.domain.Approval;


public interface ApprovalDao {
	
	public void addApproval(Approval app);
	public String getNextAppId(String appIdPrefix);
	
	public String getNextAppIdEstimate(String appIdPrefix);
	public List<Approval> getHistory(String referenceNo);
	
	
	
	public List<Approval> getNotReadEmail(String userid,String dept_id);
	public List<Approval> getNotReadEmailArea(String area);
	public Approval findByID(String emailid);
	public void update(Approval app);
	public List<Approval> getPendingReq(String area,String status);
	public List<Approval> getPendingReq(String area,String status,String deptId);
	
	
	
	
	
	
	
	
	
		
}
