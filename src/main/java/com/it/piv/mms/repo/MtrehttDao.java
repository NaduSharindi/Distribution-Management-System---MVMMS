package com.it.piv.mms.repo;

import java.util.List;

public interface MtrehttDao {
	
	public Long getApprovalList(String userName);
	public List<Object[]> getApprovalListCount(String userName);
	public List<Object[]> getApprovalListDetail(String userName);
	

}
