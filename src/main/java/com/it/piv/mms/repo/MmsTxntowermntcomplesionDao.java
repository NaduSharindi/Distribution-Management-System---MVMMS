package com.it.piv.mms.repo;

import java.util.List;






import com.it.piv.mms.domain.MmsTxntowermntcomplesion;
import com.it.piv.mms.domain.MmsTxntowermntcomplesionPK;
import com.it.piv.mms.domain.TowerModel;

public interface MmsTxntowermntcomplesionDao {
	public String addTowerMaintananceData(MmsTxntowermntcomplesion towermaintenance);
	public String update(MmsTxntowermntcomplesion towermaintenance);
	public List<MmsTxntowermntcomplesion> findAll();
	public MmsTxntowermntcomplesion findByID(MmsTxntowermntcomplesionPK id);
	public List<MmsTxntowermntcomplesion> findAllByAreaLine(String area,String line);
	public List<MmsTxntowermntcomplesion> findAllByAreaLineCycle(String area,String line,String cycle);
	public List<MmsTxntowermntcomplesion> findAllByAreaLineCycle(String area,String line,String cycle,String status);
	public List<MmsTxntowermntcomplesion> findAllTMByStatus(String area,String line, String cycle);
	public List<TowerModel> findTowerMntByArea(String area);
	public List<MmsTxntowermntcomplesion> findAllByArea(String area);
	public String getTowerIDByTowerNo(String towerNo);
	public List<MmsTxntowermntcomplesion> getMNTByStatus(String status);
	public List<MmsTxntowermntcomplesion> findAllByStatus(String status);
	public List<Object[]> findAllByAreaLineCycleNew(String area,String line,String cycle,String status);
	
		
	//public MmsTxntowermaintenance findByCo(MmsTxntowermaintenancePK id);
	
	

}
