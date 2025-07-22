package com.it.piv.mms.repo;


import java.util.List;

import com.it.piv.mms.domain.MmsAddinsulatortype;
import com.it.piv.mms.domain.MmsAddline;
import com.it.piv.mms.domain.Summary;

public interface MmsAddLineDao {
	
	public String addLine(MmsAddline addLine);
	public String update(MmsAddline addLine);
	public List<MmsAddline> findAll();
	public MmsAddline findById(String id);
	public MmsAddline findById(long id);
	public String findIdByName(String name);
	public String findIdByCode(String code);
	public String getNameByCode(String code);
	public String getNameById(String id);
	
	public List<Summary> viewLineSummaryforArea(String area);
	public List<Summary> findLineSummary(String name);
	public List<Summary> findAreaSummary(String dept_id);
	public List<Summary> findDDSummary(String DD,String dept_id);
	public List<Object[]> findDDSummary(String province,String area,String line,String dept_id);
	public List<Object[]> findDDSummary(String province,String area,String line);
	
	public List<Summary> findDDSummaryOther(String DD);
	
	public Object lineSummary(String DD,String dept_id);
	public String findLineSummaryNew(String name);
	public List<MmsAddline> findLineByArea(String area);
	public List<MmsAddline> findLineByAreaList(String area);
	
	public List<MmsAddline> findLineByStatus(String status,String phmbranch);
	public List<MmsAddline> findLineByProvince(String province,String area);
	public List<Object[]> findLineByProvinceNew(String province,String area);
	public List<Object[]> findLineByProvinceNew(String province, String area,String line);
	public List<MmsAddline> findLineByAreaEdit(String area,String status,String phmbranch);
	public List<Summary> findLineSummaryForEst(String lineids);
	public List<MmsAddline> findLineByArea(String area,String deptID);
	public double getTotalofFlashSet(String area,String lineid,String cycle);
	public double getTotalofOnlyFlashSet(String area,String lineid,String cycle);
	public Object[] getTotalofDefectiveInsultorSetForColdLineEst(String area,String lineid,String cycle);
	public Object[] getTotalofDefectiveInsultorSetForColdLineEstHotPossible(String area,String lineid,String cycle);
	
	public Object[] getTotalofDefectiveInsultorSetForTTWTEst(String area,String lineid,String cycle);
	//public double getTotalofInstorSetForTTWTEst(String area,String lineid,String cycle);
	public double getTotalofTotalofSuspensionInsulatorSets(String area,String lineid,String cycle);
	public double getTotalFlashOverSet(String area,String lineid,String cycle);
	public double getTotalWpin(String area,String lineid,String cycle);
	public double getTotalEndFitting(String area,String lineid,String cycle);
	public double getCountTTWT(String area,String lineid,String cycle);
	public double getCountCL(String area,String lineid,String cycle);
	public double getCountCL1(String area,String lineid,String cycle);
	public double getCountCL2(String area,String lineid,String cycle);
	
	public Object[] getTotalCLSuspensionISets(String area,String lineid,String cycle);
	public Object[] getTotalCLTensionISets(String area,String lineid,String cycle);
	public List<MmsAddline> findLineByAreaStatus(String area,String status);
	
	public double getDefectiveInsulatorTower(String area,String lineid,String cycle);
	public double getDamageTower(String area,String cycle);
	public double getDefectiveInsulatorTower(String area,String cycle);
	
		
	
	
	
}
