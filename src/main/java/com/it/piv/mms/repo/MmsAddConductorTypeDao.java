package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsAddconductortype;

public interface MmsAddConductorTypeDao {
	public String addConductorType(MmsAddconductortype conductorType);
	public List<MmsAddconductortype> findAll();
	public List<MmsAddconductortype> findActiveConductorTypes();
	
	//edit anushka 2019-01-01------------------------------------------------------------------------------
	public void updateConductorType(MmsAddconductortype obj);
	//-----------------------------------------------------------------------------------------------------
}
