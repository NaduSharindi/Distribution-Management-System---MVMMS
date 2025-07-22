package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsTowermaintenance;
import com.it.piv.mms.domain.MmsTowermaintenancePK;
import com.it.piv.mms.domain.TowerModel;

public interface MmsTowermaintenanceDao {
	public String addTowerMaintananceData(MmsTowermaintenance towermaintenance);
	public String update(MmsTowermaintenance towermaintenance);
	public List<MmsTowermaintenance> findAll();
	public MmsTowermaintenance findByID(MmsTowermaintenancePK id);
	public List<MmsTowermaintenance> findAllByAreaLine(String area,String line);
	public List<TowerModel> findTowerMntByArea(String area);
	public List<MmsTowermaintenance> findAllByArea(String area);
	public String getTowerIDByTowerNo(String towerNo);
	
}
