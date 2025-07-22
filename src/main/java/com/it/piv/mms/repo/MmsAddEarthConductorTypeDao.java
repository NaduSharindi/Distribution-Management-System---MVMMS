package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsAddearthconductortype;

public interface MmsAddEarthConductorTypeDao {
	public String addEarthConType(MmsAddearthconductortype earthConType);
	public List<MmsAddearthconductortype> findAll();
	public List<MmsAddearthconductortype> findActiveEarth();
	
	//edit anushka 2019-01-01-------------------------------------------------------------------------------------------------
	public void updateEarthConductorType(MmsAddearthconductortype obj);
	//------------------------------------------------------------------------------------------------------------------------
}
