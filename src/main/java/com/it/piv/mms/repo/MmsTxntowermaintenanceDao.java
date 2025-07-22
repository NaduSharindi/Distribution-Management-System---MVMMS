package com.it.piv.mms.repo;

import java.util.List;




import com.it.piv.mms.domain.MmsTxntowermaintenancePK;
import com.it.piv.mms.domain.MmsTxntowermaintenance;
import com.it.piv.mms.domain.TowerModel;

public interface MmsTxntowermaintenanceDao {
	public String addTowerMaintananceData(MmsTxntowermaintenance towermaintenance);
	public String update(MmsTxntowermaintenance towermaintenance);
	public List<MmsTxntowermaintenance> findAll();
	public MmsTxntowermaintenance findByID(MmsTxntowermaintenancePK id);
	public List<MmsTxntowermaintenance> findAllByAreaLine(String area,String line);
	public List<MmsTxntowermaintenance> findAllByAreaLineCycle(String area,String line,String cycle);
	public List<MmsTxntowermaintenance> findAllByAreaLineCycle(String area,String line,String cycle,String status);
	public List<MmsTxntowermaintenance> findAllByAreaLineCycleDeptId(String area,String line,String cycle,String status,String deptID);
	
	public List<MmsTxntowermaintenance> findAllTMByStatus(String area,String line, String cycle);
	public List<MmsTxntowermaintenance> findAllTMByStatusNew(String area,String line, String cycle,String deptId);
	
	public List<TowerModel> findTowerMntByArea(String area);
	public List<MmsTxntowermaintenance> findAllByArea(String area);
	public String getTowerIDByTowerNo(String towerNo);
	public List<MmsTxntowermaintenance> getMNTByStatus(String status);
	public List<MmsTxntowermaintenance> findAllByStatus(String status);
	public List<MmsTxntowermaintenance> findAllByStatus(String status,String dept_id);
	
	public List<Object[]> findAllByAreaLineCycleNew(String area,String line,String cycle,String status);
	public MmsTxntowermaintenance findByTowerIdCycle(long towerId,String cycle);
	public MmsTxntowermaintenance findByTowerId(long towerId);
	
		
	//public MmsTxntowermaintenance findByCo(MmsTxntowermaintenancePK id);
	
	

}
