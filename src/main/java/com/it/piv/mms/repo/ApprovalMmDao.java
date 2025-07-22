package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.ApprovalMm;

public interface ApprovalMmDao {
	
	public void addApproval(ApprovalMm app);
	public void updateApproval(ApprovalMm app);
	
	public String getNextAppId(String appIdPrefix);
	public String getNextAppIdEM(String appIdPrefix);
	public String getNextTestIdEM(String appIdPrefix);
	
	public List<ApprovalMm> getNotReadEmail(String userid,String dept_id);
	public List<ApprovalMm> getNotReadEmailArea(String area);
	public ApprovalMm findByID(String emailid);
	public void update(ApprovalMm app);
	public List<ApprovalMm> getPendingReq(String area,String status);
	public List<ApprovalMm> getPendingReqByArea(String area,String status,String type);
	
	public List<ApprovalMm> getPendingReq(String area,String status,String deptId);
	public  List<ApprovalMm> getAllRequest(String type);
	public  List<ApprovalMm> getAllIntRequestByarea(String area,String type);
	
	public  List<ApprovalMm> getAllRequestByarea(String area,String type);
	public List<ApprovalMm> getPendingReqNew(String area,String status,String phmBranch);
	public List<ApprovalMm> getPendingReqByEE(String type,String status,String phmBranch,String ee);
	public List<ApprovalMm> getPendingReqByES(String type,String status,String phmBranch,String ee);
	public List<ApprovalMm> getPendingReqByESAll(String type,String phmBranch,String ee);
	
	
	public List<ApprovalMm> getPendingReqByESNew(String type,String status,String ee);
	
	
	
	public List<ApprovalMm> getPendingReqByEEAll(String type,String phmBranch,String ee);
	
	public List<ApprovalMm> getAllReqForPhmBranch(String type,String phmBranch);
	public List<ApprovalMm> getAllReqForEMBranch(String type,String phmBranch);
	
	
	public List<ApprovalMm> getAllInterruptionReq(String area,String status,String type);
	public List<ApprovalMm> getAllInterruptionReqNew(String area,String status,String type,String category);
	public List<ApprovalMm> getAllInterruptionReqNew(List<String> areaList,String status,String type,String category);
	
	public List<ApprovalMm> getAllInterruptionReqForProvince(List<String> areaList,String status,String type);
	
	public List<ApprovalMm> getAllInterruptionReqForProvinceNew(List<String> areaList,String status,String type,String category);
	public List<ApprovalMm> getAllInterruptionReqForProvinceNew(List<String> areaList,List<String> status,String type,String category,String fromdate,String todate);
	public List<ApprovalMm> getAllInterruptionReqForProvinceNew(List<String> areaList,List<String> status,String type,String category,String fromdate,String todate,String responsibleUser);
	public List<ApprovalMm> getAllInterruptionReqForProvinceNewCycle(List<String> areaList,List<String> status,String type,String category,String responsibleUser,String cycle);
	public List<ApprovalMm> getAllInterruptionForCalender(String status,String type);
	
	public List<ApprovalMm> getAllInterruptionForCalenderByStatus(String status,String type);
	
	public List<ApprovalMm> getAllInterruptionForCalenderByArea(String status,String type);
	
	public List<ApprovalMm> getAllInterruptionReqForProvinceNew(List<String> areaList,List<String> status,String type,String category,String responsibleUser);
	public List<ApprovalMm> getApprovalIntteruption(List<String> status,String type,String category,String responsibleUser);
	
	public List<ApprovalMm> getAllIntProvince(List<String> areaList,String type);
	public String findWorkingDate(String inttruptionNo);
	public List<Object[]> getRequestTypeCount();
	public List<Object[]> getRequestStatusCountByType(String type);
	public List<Object[]> getRequestStatusCountByTypeDeptID(String type,String deptId);
	
	public List<Object[]> getRequestStatusCountByTypeES(String type);
	
	public List<ApprovalMm> getRequestStatusCountByTypeDetail(String type,String toStatus,String fromStatus);
	
	public List<ApprovalMm> getAllInterruptionRecommendedList(List<String> areaList,List<String> status,String type,String category,String cycle);
	
	public List<ApprovalMm> getHistory(String referenceNo);
	
	
	
	
	
	

}
