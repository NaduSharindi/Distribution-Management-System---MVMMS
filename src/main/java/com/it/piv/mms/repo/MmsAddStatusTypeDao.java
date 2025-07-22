package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsAddstatustype;

public interface MmsAddStatusTypeDao {
	public String addStatusType(MmsAddstatustype statusType);
	public List<MmsAddstatustype> findAll();
	public List<MmsAddstatustype> findActiveStatusTypes();
	
	//edit anushka 2019-01-01-----------------------------------------------------------------------------------------------
	public void updateStatusType(MmsAddstatustype obj);
	//----------------------------------------------------------------------------------------------------------------------
}
