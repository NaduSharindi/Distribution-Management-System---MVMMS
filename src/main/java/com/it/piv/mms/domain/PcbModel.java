package com.it.piv.mms.domain;
import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



public class PcbModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	Map<String,String> divList = new LinkedHashMap<String,String>();
	Map<String,String> provinceList = new LinkedHashMap<String,String>();
	public Map<String, String> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(Map<String, String> provinceList) {
		this.provinceList = provinceList;
	}

	Map<String,String> areaList = new LinkedHashMap<String,String>();
	
	
	public Map<String, String> getAreaList() {
		return areaList;
	}

	public void setAreaList(Map<String, String> areaList) {
		this.areaList = areaList;
	}

	public Map<String, String> getDivList() {
		return divList;
	}

	public void setDivList(Map<String, String> divList) {
		this.divList = divList;
	}

	private List<Glcompm> compList;
	
	
	public List<Glcompm> getCompList() {
		return compList;
	}

	public void setCompList(List<Glcompm> compList) {
		this.compList = compList;
	}

	private List<PcbModel>  listPcbModel;
	public List<PcbModel> getListPcbModel() {
		return listPcbModel;
	}

	public void setListPcbModel(List<PcbModel> listPcbModel) {
		this.listPcbModel = listPcbModel;
	}

	private String mode;
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	private PcbEquipment pcbEquipment = new PcbEquipment();
	private PcbSample pcbSample = new PcbSample();;
	private PcbCondition pcbCondition;
	private PcbLocation pcbLocation;
	private List<PCB_Division> divisionList;
	private List<String> equipmentIdList;
	private List<PcbEquipment> equipmentList;
	/*private List<PcbSample> sampleList;
	private List<PcbCondition> conditionList;
	private List<PcbLocation> locationList;
	
	public List<PcbLocation> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<PcbLocation> locationList) {
		this.locationList = locationList;
	}

	public List<PcbCondition> getConditionList() {
		return conditionList;
	}

	public void setConditionList(List<PcbCondition> conditionList) {
		this.conditionList = conditionList;
	}

	public List<PcbSample> getSampleList() {
		return sampleList;
	}

	public void setSampleList(List<PcbSample> sampleList) {
		this.sampleList = sampleList;
	}
*/
	
	private String sampleNo;
	public String getSampleNo() {
		return sampleNo;
	}

	public void setSampleNo(String sampleNo) {
		this.sampleNo = sampleNo;
	}

	private Date startDate;
	private Date endDate;
	private String year;
	private String category;
	private String yearMnf;

	public String getYearMnf() {
		return yearMnf;
	}

	public void setYearMnf(String yearMnf) {
		this.yearMnf = yearMnf;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public PcbEquipment getPcbEquipment() {
		return pcbEquipment;
	}

	public void setPcbEquipment(PcbEquipment pcbEquipment) {
		this.pcbEquipment = pcbEquipment;
	}

	public PcbSample getPcbSample() {
		return pcbSample;
	}

	public void setPcbSample(PcbSample pcbSample) {
		this.pcbSample = pcbSample;
	}

	public PcbCondition getPcbCondition() {
		return pcbCondition;
	}

	public void setPcbCondition(PcbCondition pcbCondition) {
		this.pcbCondition = pcbCondition;
	}

	public PcbLocation getPcbLocation() {
		return pcbLocation;
	}

	public void setPcbLocation(PcbLocation pcbLocation) {
		this.pcbLocation = pcbLocation;
	}

	public List<PCB_Division> getDivisionList() {
		return divisionList;
	}

	public void setDivisionList(List<PCB_Division> divisionList) {
		this.divisionList = divisionList;
	}

	public List<String> getEquipmentIdList() {
		return equipmentIdList;
	}

	public void setEquipmentIdList(List<String> equipmentIdList) {
		this.equipmentIdList = equipmentIdList;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<PcbEquipment> getEquipmentList() {
		return equipmentList;
	}

	public void setEquipmentList(List<PcbEquipment> equipmentList) {
		this.equipmentList = equipmentList;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
}