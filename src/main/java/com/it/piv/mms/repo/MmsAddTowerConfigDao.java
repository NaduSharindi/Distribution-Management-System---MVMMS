package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsAddtowerconfiguration;

public interface MmsAddTowerConfigDao {
	public String addTowerConfiguration(MmsAddtowerconfiguration towerConfiguration);
	public List<MmsAddtowerconfiguration> findAll();
	public List<MmsAddtowerconfiguration> findActiveConfigurations();
	
	//edit anushka 2019-01-01---------------------------------------------------------------------------
	public void updateTowerConfigurationType(MmsAddtowerconfiguration obj);
	//--------------------------------------------------------------------------------------------------
}
