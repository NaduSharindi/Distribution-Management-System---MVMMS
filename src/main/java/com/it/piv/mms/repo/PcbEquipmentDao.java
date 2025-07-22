package com.it.piv.mms.repo;
import java.util.Date;
import java.util.List;

import org.jfree.data.time.Year;

import com.it.piv.mms.domain.PcbEquipment;
import com.it.piv.mms.domain.PcbLocation;
import com.it.piv.mms.domain.PcbModel;

public interface PcbEquipmentDao{
	public String addEquipment(PcbEquipment pcbEquipment);
	public String getNextEquipmentId(String applicationNoPrefix);
	public PcbEquipment findEquipmentByEquipmentId(String equipmentId);
	public String updateEquipment(PcbEquipment equipment);
	public List<String> findEquipmentIdsForPcbSample(String division, String manufactureLtl, String seriaType, String year);
	public List<String> findEquipmentIdsForPcbSample1(String division, String manufactureLtl, String seriaType, Year year);
	public List<String> findEquipmentIdsByDate(Date startDate, Date endDate);
	public List<PcbEquipment> findEquipmentList(List<String> equipmentIdList);
	public List<PcbEquipment> findEquiByAreaStatus(String area, String status);
	public List<String> findEquipmentIdsForCategory1(String division, String manufactureLtl, String seriaType, String year);
	public List<PcbEquipment> findEquipmenListsForCategory1(String division, String manufactureLtl, String seriaType, String year,String area);
	public List<PcbEquipment> findEquipmenListsForCategory(String division, String manufactureLtl, String seriaType, String year,String area);
	public String getEquipmentIdByReferenceNo(String equipmentId);
	public String getReferenceNoByEquipmentId(String ReferenceNo);
	
	public String getEquipmentIdBySampleNo(String sampleNo);
	
	public List<PcbEquipment> findEquipmenListsForCategoryDivUnit(String division, String manufactureLtl, String seriaType, String year,String area,String unit,String branch);
	public List<PcbEquipment> findEquipmentIdsForDivBraUnit(String division,String branch,String unit, String manufactureLtl, String seriaType, String year);
	
	public List<Object[]> findLocationIdsForDivBraUnit(String division,String branch,String unit);
	public List<Object[]> findLocationIdsForBraUnit(String branch,String unit);
	
	public List<Object[]> findLocationIdsForArea(String unit);
	
	public Object findPCBModelBySinNo(String sinNo);
	
	
	public PcbEquipment getEquipmentByReferenceNo(String equipmentId);
	
	public List<PcbEquipment> findEquipmentIdForMobile(String division,String branch,String unit);
	
	public List<Object[]> getSummaryTransformerSampled();
	
	public List<Object[]> getSummaryTransformer();
	public List<Object[]> getSummaryTransformerScreening();
	public List<Object[]> getSummaryTransformerItiConf();
	
	
public List<Object[]> getSummaryTransformerSampledDPA(String div,String pro,String Area);
	
	public List<Object[]> getSummaryTransformerDPA(String div,String pro,String Area);
	public List<Object[]> getSummaryTransformerScreeningDPA(String div,String pro,String Area);
	public List<Object[]> getSummaryTransformerItiConfDPA(String div,String pro,String Area);
	public List<Object[]> getSummaryTransformerOilWeight(String div,String pro,String Area);
	

}