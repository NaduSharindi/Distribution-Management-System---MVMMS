package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import com.it.piv.mms.domain.MmsAddsupport;

public interface MmsSupportDao {
	public String addSupport(MmsAddsupport support);
	public MmsAddsupport getTowerByTowerNo(String towerNo);
	public List<MmsAddsupport> getTowerByTowerNoNew(String towerNo);
	public List<MmsAddsupport> getTappings(String area,String lineid,String fromTowerId,String fromMapId,String toTowerId,String toMapId);
	
	public List<MmsAddsupport> findAll();
	public List<MmsAddsupport> findByAreaLineStatus(String area,String line,String status);
	
	public List<MmsAddsupport> findByArea(String area,String line);
	public List<MmsAddsupport> findByArea(String area,String line,String province,String dept_id);
	public List<MmsAddsupport> findByAreaOther(String area,String line,String province);
	public List<Object[]> findByAreaForNewMapWayAnalysis(String area,String line,String province,String dept_id,String status);
	
	public List<Object[]> findByAreaEngineerForNewMapWayAnalysis(String area,String line,String deptId);
	public List<Object[]> findByAreaEngineerForNewMapWayAnalysisNew(String area,String line,String deptId);
	
	
	public List<Object[]> findByAreaForNewMap(String area,String line,String province,String dept_id);
	public List<Object[]> findByAreaForNewMapProvince(String area,String line,String province);
	
	public void updateSupport(String mapid,String id,String lat,String lon,String supType);
	public MmsAddsupport findById(long id);
	public List<MmsAddsupport> getTowerMaintenanceData(String towerNo,String deptId);
	public List<MmsAddsupport> getTowerMaintenanceData();
	public void updateSupport(String towerNo,String sType,String id,String area,String csc,String cType,String ecType,String tType,
			String tConfig,String gpsLat,String gpsLon,String nofCir,String bExten,String tapping,String mapid,String status,String appLevel,String res,String from,String to);
	public List<MmsAddsupport> findES1COMWPS2(String level);
	public List<MmsAddsupport> findByStatus(String status);
	public List<MmsAddsupport> findByStatus(String status,String dept_id);
	public List<MmsAddsupport> getIntteruptedList();
		
	
	
	public String getTowerIDByTowerNo(String towerNo);
	public List<Object[]> findSupportForAE(String area,String line);
	public List<Object[]> findByAreaForNewMap(String area,String line,String province);
	public List<Object[]> findByAreaForNewMap(String area,String line);
	
	public String update(MmsAddsupport addSupport);
	public List<MmsAddsupport> findBySupportStatus(String area,String line,String province,String dept_id,String status);
	public List<Object[]> findByAreaForNewMap(String area,String line,String province,String dept_id,String status);
	public List<Object[]> findByAreaForNewMapWOMNT(String area,String line,String province,String dept_id,String status);
	public List<Object[]> findByAreaForNewMapWOMNTAE(String area, String line,String dept_id, String status);
	public void updateSupportTapping(String towerNo,String sType,String id,String area,String csc,String cType,String ecType,String tType,
			String tConfig,String gpsLat,String gpsLon,String nofCir,String bExten,String tapping,String mapid,String status,String appLevel);
	public List<Object[]> findByAreaForNewMapOther(String area,String line,String province,String status);
	public List<Object[]> findByAreaForNewMapAll(String area,String line,String province,String division,String status);
	public List<Object[]> findByAreaForNewMapComview(String area,String line,String province,String division,String status);
	
	public List<Object[]> findByAreaForNewMapSummary(String area,String line,String province,String division,String status);
	
	public List<Object[]> findByAreaForNewMapWOMNTGantry(String area, String line,String province, String dept_id, String status);
	
	public MmsAddsupport getFeederIdentification1(String feederId);
	public MmsAddsupport getFeederIdentification2(String feederId);
	
	
	
	
	

}
