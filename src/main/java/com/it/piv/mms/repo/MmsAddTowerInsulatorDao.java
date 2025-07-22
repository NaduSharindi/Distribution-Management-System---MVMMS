package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsAddtowerinsulator;

public interface MmsAddTowerInsulatorDao {
	public String addTowerInsulator(MmsAddtowerinsulator towerInsulator);
	public List<MmsAddtowerinsulator> findAll();
	
	//edit anushka 2019-01-01------------------------------------------------------------------------------------------
	public void updateTowerInsulatorType(MmsAddtowerinsulator obj);
	//-----------------------------------------------------------------------------------------------------------------
}
