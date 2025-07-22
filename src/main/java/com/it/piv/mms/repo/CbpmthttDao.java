package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.Cbpmthtt;

public interface CbpmthttDao {
	public Long getApprovalList(String userName);
	public List<Object[]> getApprovalListCount(String userName);
	
	public List<Object[]> getApprovalListDetail(String userName,String deptId,String doc_pf);
		
	public List<Cbpmthtt> getApprovalListDetailCbpmt(String userName,String deptId);
	
	public void updatePaySlip(String docNo);
	
	

}
