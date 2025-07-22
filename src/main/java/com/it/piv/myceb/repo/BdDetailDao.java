package com.it.piv.myceb.repo;

import java.util.List;

import com.it.piv.myceb.domain.BdDetail;
import com.it.piv.myceb.domain.ComData;
import com.it.piv.myceb.domain.OMSModel;


public interface BdDetailDao {
	public String save(BdDetail obj);
	public List<Object[]> getPendingBD(String status);
	public void addComplaint(BdDetail applicant);
	public List<BdDetail> findByAccNo(String accNo);
	public List<BdDetail> findByStatus(String statu);
	
	public ComData findById(String id);
}
