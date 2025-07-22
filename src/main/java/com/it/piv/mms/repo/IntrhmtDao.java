package com.it.piv.mms.repo;

import java.util.List;

public interface IntrhmtDao {
	
	public Long getApprovalList(String userName);
	public List<Object[]> getApprovalListCount(String userName);
	public List<Object[]> getApprovalListDetail(String userName);
	

}
