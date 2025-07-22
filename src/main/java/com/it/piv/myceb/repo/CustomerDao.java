package com.it.piv.myceb.repo;

import java.util.List;

import com.it.piv.myceb.domain.CusData;

public interface CustomerDao {
	
	public String findByAccountNo(String acct);
	public String addCustomer(CusData customer);
	public void updateCustomer(CusData customer);
	public CusData findById(String id);
	public List<CusData> findByAccNo(String id);
	public CusData findByIdNo(String id);
	public List<CusData> getAll();
	public String getAreaCodeByAccNo(String accNo);

}
