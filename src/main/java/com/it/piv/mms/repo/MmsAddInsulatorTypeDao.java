package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsAddinsulatortype;

public interface MmsAddInsulatorTypeDao {
	public String addInsulatorType(MmsAddinsulatortype insulatorType);
	public List<MmsAddinsulatortype> findAll();
	
	//edit anushka 2019-01-01-------------------------------------------------------------------------------------------------------------------
	public void updateInsulatorType(MmsAddinsulatortype obj);
	//------------------------------------------------------------------------------------------------------------------------------------------
}
