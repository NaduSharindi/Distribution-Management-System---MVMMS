package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsAddstatus;

public interface MmsAddStatusDao {
	public String addStatus(MmsAddstatus addStatus);
	public List<MmsAddstatus> findAll();
	
	//edit anushka 2019-01-02------------------------------------------------------------------------------------------------------------
	public void updateStatus(MmsAddstatus obj);
	//-----------------------------------------------------------------------------------------------------------------------------------
}
