package com.it.piv.issue.domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.constraints.NotBlank;

import com.it.piv.admin.domain.Sauserm;
import com.it.piv.mms.domain.Applicant;
import com.it.piv.mms.domain.Approval;
import com.it.piv.mms.domain.ApprovalMm;
import com.it.piv.mms.domain.Glcompm;
import com.it.piv.mms.domain.Gldeptm;
import com.it.piv.mms.domain.MmsAddconductortype;
import com.it.piv.mms.domain.MmsAddearthconductortype;
import com.it.piv.mms.domain.MmsAddfeeder;
import com.it.piv.mms.domain.MmsAddgantry;
import com.it.piv.mms.domain.MmsAddline;
import com.it.piv.mms.domain.MmsAddlinetype;
import com.it.piv.mms.domain.MmsAddmvpole;
import com.it.piv.mms.domain.MmsAddpole;
import com.it.piv.mms.domain.MmsAddpoletype;
import com.it.piv.mms.domain.MmsAddsupport;
import com.it.piv.mms.domain.MmsAddsupporttype;
import com.it.piv.mms.domain.MmsAddswitch;
import com.it.piv.mms.domain.MmsAddtowerconfiguration;
import com.it.piv.mms.domain.MmsArea;
import com.it.piv.mms.domain.MmsCompletion;
import com.it.piv.mms.domain.MmsCsc;
import com.it.piv.mms.domain.MmsInspection;
import com.it.piv.mms.domain.MmsMntplan;
import com.it.piv.mms.domain.MmsProvince;
import com.it.piv.mms.domain.MmsTowertype;
import com.it.piv.mms.domain.MmsTxntowermaintenance;
import com.it.piv.mms.domain.MmsTxntowermntcomplesion;
import com.it.piv.mms.domain.Msttowertype;
import com.it.piv.mms.domain.MvmmsCycle;
import com.it.piv.mms.domain.PcbEquipment;
import com.it.piv.mms.domain.PcbModel;
import com.it.piv.mms.domain.Pcesthmt;
import com.it.piv.mms.domain.Summary;
import com.it.piv.mms.domain.TrippingData;
import com.it.piv.myceb.domain.BdDetail;
import com.it.piv.myceb.domain.MobUser;


//import com.it.piv.MyTest.Dbtest;

@SuppressWarnings("serial")
public class PivModel implements Serializable {
	//private PivDetail pivDetail;
	//private PivApplicant pivApplicant;
	//Map<String,String> pivTypeList;
	//private List<PivAmountGrid> amountList;
	
	private long gantryid = 0;
	public long getGantryid() {
		return gantryid;
	}

	public void setGantryid(long gantryid) {
		this.gantryid = gantryid;
	}

	@NotBlank(message = "Name may not be blank")
	private String mailContent;
	@NotBlank(message = "Name may not be blank")
	private String mailContent2;
	
	private String area;
	
	private List<MmsInspection> insList;
	
	private String result;
	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<MmsInspection> getInsList() {
		return insList;
	}

	public void setInsList(List<MmsInspection> insList) {
		this.insList = insList;
	}

	private List<MmsCompletion> comList;
	
	public List<MmsCompletion> getComList() {
		return comList;
	}

	public void setComList(List<MmsCompletion> comList) {
		this.comList = comList;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	private String csc;
	

	public String getCsc() {
		return csc;
	}

	public void setCsc(String csc) {
		this.csc = csc;
	}
	
	private String demand;

	public String getDemand() {
		return demand;
	}

	public void setDemand(String demand) {
		this.demand = demand;
	}
	
	private String ctratio;
	

	public String getCtratio() {
		return ctratio;
	}

	public void setCtratio(String ctratio) {
		this.ctratio = ctratio;
	}

	private String releventBranch;
	
	private String locationsin;
	
	public String getLocationsin() {
		return locationsin;
	}

	public void setLocationsin(String locationsin) {
		this.locationsin = locationsin;
	}
	
	private String sinnumber;

	public String getSinnumber() {
		return sinnumber;
	}

	public void setSinnumber(String sinnumber) {
		this.sinnumber = sinnumber;
	}
    private String tariff;
    
    
	public String getTariff() {
		return tariff;
	}

	public void setTariff(String tariff) {
		this.tariff = tariff;
	}

	private String contact;
	
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	private String order;

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	private List<PcbModel>  listPcbModel;
	public List<PcbModel> getListPcbModel() {
		return listPcbModel;
	}

	public void setListPcbModel(List<PcbModel> listPcbModel) {
		this.listPcbModel = listPcbModel;
	}
	
	private PcbEquipment pcbEquipment = new PcbEquipment();
	
private String preparedBy;

	
	public String getPreparedBy() {
	return preparedBy;
}

public void setPreparedBy(String preparedBy) {
	this.preparedBy = preparedBy;
}

private String checkedBy;

	public String getCheckedBy() {
	return checkedBy;
}

public void setCheckedBy(String checkedBy) {
	this.checkedBy = checkedBy;
}

	public PcbEquipment getPcbEquipment() {
		return pcbEquipment;
	}

	public void setPcbEquipment(PcbEquipment pcbEquipment) {
		this.pcbEquipment = pcbEquipment;
	}

	private String additionalwork;

	public String getAdditionalwork() {
		return additionalwork;
	}

	public void setAdditionalwork(String additionalwork) {
		this.additionalwork = additionalwork;
	}

	private MmsMntplan objMntPlan;
	
	private List<MmsMntplan> objMntPlanList;
	
	
	
	public List<MmsMntplan> getObjMntPlanList() {
		return objMntPlanList;
	}

	public void setObjMntPlanList(List<MmsMntplan> objMntPlanList) {
		this.objMntPlanList = objMntPlanList;
	}

	public MmsMntplan getObjMntPlan() {
		return objMntPlan;
	}

	public void setObjMntPlan(MmsMntplan objMntPlan) {
		this.objMntPlan = objMntPlan;
	}

	public String getReleventBranch() {
		return releventBranch;
	}

	public void setReleventBranch(String releventBranch) {
		this.releventBranch = releventBranch;
	}

	Map<String, String> divList = new LinkedHashMap<String, String>();
	
	
	public Map<String, String> getDivList() {
		return divList;
	}

	public void setDivList(Map<String, String> divList) {
		this.divList = divList;
	}

	private String spsdescription;
	
	
	public String getSpsdescription() {
		return spsdescription;
	}

	public void setSpsdescription(String spsdescription) {
		this.spsdescription = spsdescription;
	}

	private String selectedLine;
	
	public String getSelectedLine() {
		return selectedLine;
	}

	public void setSelectedLine(String selectedLine) {
		this.selectedLine = selectedLine;
	}

	private String lineNameNew;
	
	private String filename_1;
	
	public String getFilename_1() {
		return filename_1;
	}

	public void setFilename_1(String filename_1) {
		this.filename_1 = filename_1;
	}
	
	private String filename_2;
	

	public String getFilename_2() {
		return filename_2;
	}

	public void setFilename_2(String filename_2) {
		this.filename_2 = filename_2;
	}
	
	private String filename_3;
	

	public String getFilename_3() {
		return filename_3;
	}

	public void setFilename_3(String filename_3) {
		this.filename_3 = filename_3;
	}
	
	private String filename_4;
	

	public String getFilename_4() {
		return filename_4;
	}

	public void setFilename_4(String filename_4) {
		this.filename_4 = filename_4;
	}
	
	private String filename_5;
	

	public String getFilename_5() {
		return filename_5;
	}

	public void setFilename_5(String filename_5) {
		this.filename_5 = filename_5;
	}

	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	private String idNo;

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	private String otherInterruption;
	
	
	public String getOtherInterruption() {
		return otherInterruption;
	}

	public void setOtherInterruption(String otherInterruption) {
		this.otherInterruption = otherInterruption;
	}

	public String getLineNameNew() {
		return lineNameNew;
	}

	public void setLineNameNew(String lineNameNew) {
		this.lineNameNew = lineNameNew;
	}

	private Date trippingDate;
	
	public Date getTrippingDate() {
		return trippingDate;
	}

	public void setTrippingDate(Date trippingDate) {
		this.trippingDate = trippingDate;
	}
	
	private String fromtime;
	

	public String getFromtime() {
		return fromtime;
	}

	public void setFromtime(String fromtime) {
		this.fromtime = fromtime;
		
		
	}
	
	private String timeduration;
	

	public String getTimeduration() {
		return timeduration;
	}

	public void setTimeduration(String timeduration) {
		this.timeduration = timeduration;
	}

	private String totime;
	
	public String getTotime() {
		return totime;
	}

	public void setTotime(String totime) {
		this.totime = totime;
	}
	private String causeoftripping;
	
	
	public String getCauseoftripping() {
		return causeoftripping;
	}

	public void setCauseoftripping(String causeoftripping) {
		this.causeoftripping = causeoftripping;
	}

	private String trippingType;
	

	public String getTrippingType() {
		return trippingType;
	}

	public void setTrippingType(String trippingType) {
		this.trippingType = trippingType;
	}

	private TrippingData objTripping = new TrippingData();
	
	public TrippingData getObjTripping() {
		return objTripping;
	}

	public void setObjTripping(TrippingData objTripping) {
		this.objTripping = objTripping;
	}

	private String fromDate;
	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	private String toDate;
	
	
	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	private List<MmsAddmvpole> mvPoleList;
	
	

	public List<MmsAddmvpole> getMvPoleList() {
		return mvPoleList;
	}

	public void setMvPoleList(List<MmsAddmvpole> mvPoleList) {
		this.mvPoleList = mvPoleList;
	}

	private MmsAddmvpole mvpole;
	
	public MmsAddmvpole getMvpole() {
		return mvpole;
	}

	public void setMvpole(MmsAddmvpole mvpole) {
		this.mvpole = mvpole;
	}

	Map<Long,String> lineListNew;
	
	
	public Map<Long, String> getLineListNew() {
		return lineListNew;
	}

	public void setLineListNew(Map<Long, String> lineListNew) {
		this.lineListNew = lineListNew;
	}

	private String totowerid;
	public String getTotowerid() {
		return totowerid;
	}

	public void setTotowerid(String totowerid) {
		this.totowerid = totowerid;
	}

	private String fromtowerid;
	public String getFromtowerid() {
		return fromtowerid;
	}

	public void setFromtowerid(String fromtowerid) {
		this.fromtowerid = fromtowerid;
	}

	private String totowermapid;
	public String getTotowermapid() {
		return totowermapid;
	}

	public void setTotowermapid(String totowermapid) {
		this.totowermapid = totowermapid;
	}

	private String fromtowermapid;
	
	public String getFromtowermapid() {
		return fromtowermapid;
	}

	public void setFromtowermapid(String fromtowermapid) {
		this.fromtowermapid = fromtowermapid;
	}

	private String mapId;
	public String getMapId() {
		return mapId;
	}

	public void setMapId(String mapId) {
		this.mapId = mapId;
	}

	private String stringOfPoleIds;
	
	private String stringOfGantryIds;

	public String getStringOfGantryIds() {
		return stringOfGantryIds;
	}

	public void setStringOfGantryIds(String stringOfGantryIds) {
		this.stringOfGantryIds = stringOfGantryIds;
	}

	private List<MmsAddgantry> gantryListEdit;


	public List<MmsAddgantry> getGantryListEdit() {
		return gantryListEdit;
	}

	public void setGantryListEdit(List<MmsAddgantry> gantryListEdit) {
		this.gantryListEdit = gantryListEdit;
	}

	public String getStringOfPoleIds() {
		return stringOfPoleIds;
	}

	public void setStringOfPoleIds(String stringOfPoleIds) {
		this.stringOfPoleIds = stringOfPoleIds;
	}

	private List<MmsAddpoletype> poletype;

	public List<MmsAddpoletype> getPoletype() {
		return poletype;
	}

	public void setPoletype(List<MmsAddpoletype> poletype) {
		this.poletype = poletype;
	}

	private List<MmsAddpole> poleListEdit;

	
	
	
	public List<MmsAddpole> getPoleListEdit() {
		return poleListEdit;
	}

	public void setPoleListEdit(List<MmsAddpole> poleListEdit) {
		this.poleListEdit = poleListEdit;
	}

	private MmsAddfeeder feeder = new MmsAddfeeder();
	
	public MmsAddfeeder getFeeder() {
		return feeder;
	}

	public void setFeeder(MmsAddfeeder addFeeder) {
		this.feeder = feeder;
	}
	
	private String from;
	
	private String to;
	
	private String timeDuration2;
	

	public String getTimeDuration2() {
		return timeDuration2;
	}

	public void setTimeDuration2(String timeDuration2) {
		this.timeDuration2 = timeDuration2;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	private String error;
	private String error1;
	private String error2;
	private String error3;
	private String error4;
	private String error5;
	private String error6;
	public String getError6() {
		return error6;
	}

	public void setError6(String error6) {
		this.error6 = error6;
	}

	private String error7;
	
	
	
	public String getError7() {
		return error7;
	}

	public void setError7(String error7) {
		this.error7 = error7;
	}
	
	private String error8;
	

	public String getError8() {
		return error8;
	}

	public void setError8(String error8) {
		this.error8 = error8;
	}

	private String dateOfWork;
	
	private String timeDuration;

	private MmsAddswitch switches; 
	public MmsAddswitch getSwitches() {
		return switches;
	}

	public void setSwitches(MmsAddswitch switches) {
		this.switches = switches;
	}

	private MmsAddgantry gantry;
	
public MmsAddgantry getGantry() {
		return gantry;
	}

	public void setGantry(MmsAddgantry gantry) {
		this.gantry = gantry;
	}

public String getTimeDuration() {
		return timeDuration;
	}

	public void setTimeDuration(String timeDuration) {
		this.timeDuration = timeDuration;
	}

public String getDateOfWork() {
		return dateOfWork;
	}

	public void setDateOfWork(String dateOfWork) {
		this.dateOfWork = dateOfWork;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError1() {
		return error1;
	}

	public void setError1(String error) {
		this.error1 = error;
	}
	
	public String getError2() {
		return error2;
	}

	public void setError2(String error) {
		this.error2 = error;
	}
	
	public String getError3() {
		return error3;
	}

	public void setError3(String error) {
		this.error3 = error;
	}
	
	public String getError4() {
		return error4;
	}

	public void setError4(String error) {
		this.error4 = error;
	}
	
	public String getError5() {
		return error5;
	}

	public void setError5(String error) {
		this.error5 = error;
	}

public String getMailContent2() {
		return mailContent2;
	}

	public void setMailContent2(String mailContent2) {
		this.mailContent2 = mailContent2;
	}

public String getMailContent() {
		return mailContent;
	}

	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	private List<ApprovalMm> unReadInspectionReq = new ArrayList<ApprovalMm>();;

	private ApprovalMm intRequestObj;
	
	private ApprovalMm meter;
	
	
	public ApprovalMm getMeter() {
		return meter;
	}

	public void setMeter(ApprovalMm meter) {
		this.meter = meter;
	}

	private String estimateType;
	


public String getEstimateType() {
		return estimateType;
	}

	public void setEstimateType(String estimateType) {
		this.estimateType = estimateType;
	}

public ApprovalMm getIntRequestObj() {
		return intRequestObj;
	}

	public void setIntRequestObj(ApprovalMm intRequestObj) {
		this.intRequestObj = intRequestObj;
	}

public List<ApprovalMm> getUnReadInspectionReq() {
		return unReadInspectionReq;
	}

	public void setUnReadInspectionReq(List<ApprovalMm> unReadInspectionReq) {
		this.unReadInspectionReq = unReadInspectionReq;
	}

private List<Approval> unReadEmailList;
	
	
	public List<Approval> getUnReadEmailList() {
	return unReadEmailList;
}

public void setUnReadEmailList(List<Approval> unReadEmailList) {
	this.unReadEmailList = unReadEmailList;
}

	
	
	
	private MvmmsCycle cycleObj;

	public MvmmsCycle getCycleObj() {
		return cycleObj;
	}
	public void setCycleObj(MvmmsCycle cycleObj) {
		this.cycleObj = cycleObj;
	}

	private String mode;
	private String priority;
	private List<Object[]> mntList; 
	public List<Object[]> getMntList() {
		return mntList;
	}
	public void setMntList(List<Object[]> mntList) {
		this.mntList = mntList;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}

	private List<MobUser> mobUser;
	
	private MobUser mobUserObj;
	
	

	public MobUser getMobUserObj() {
		return mobUserObj;
	}
	public void setMobUserObj(MobUser mobUserObj) {
		this.mobUserObj = mobUserObj;
	}
	public List<MobUser> getMobUser() {
		return mobUser;
	}
	public void setMobUser(List<MobUser> mobUser) {
		this.mobUser = mobUser;
	}

	//private List<String> pivNoList;
	List<Glcompm> glcompm;
	
	List<Sauserm> listEE;
	List<Sauserm> listES;
	
	public List<Sauserm> getListES() {
		return listES;
	}

	public void setListES(List<Sauserm> listES) {
		this.listES = listES;
	}

	public List<Sauserm> getListEE() {
		return listEE;
	}

	public void setListEE(List<Sauserm> listEE) {
		this.listEE = listEE;
	}

	private String circuteType;
	public String getCircuteType() {
		return circuteType;
	}
	public void setCircuteType(String circuteType) {
		this.circuteType = circuteType;
	}

	private MmsAddsupporttype supportType;
	private Glcompm glcompmobj;
	private Gldeptm gldeptobj;
	private MmsAddline line;
	private MmsAddconductortype mmsConTypePE;
	public MmsAddconductortype getMmsConTypePE() {
		return mmsConTypePE;
	}
	public void setMmsConTypePE(MmsAddconductortype mmsConTypePE) {
		this.mmsConTypePE = mmsConTypePE;
	}

	private Sauserm sauserm;
	private Sauserm sausermEE;
	
	public Sauserm getSausermEE() {
		return sausermEE;
	}

	public void setSausermEE(Sauserm sausermEE) {
		this.sausermEE = sausermEE;
	}




	private Applicant applicant;
	private MmsAddlinetype lineType;
	private MmsTxntowermaintenance mmsTxtMnt ;
	private String lineName;
	private String cycle;
	private List<Summary> summaryList;
	
	//edited anushka 2019-01-03------------------------------------------------------------------------------------------------------
		private String stringOfSupportIds;
		//----------------------------------------
		private String stringOfLineIds;
		
		public String getStringOfLineIds() {
			return stringOfLineIds;
		}
		public void setStringOfLineIds(String stringOfLineIds) {
			this.stringOfLineIds = stringOfLineIds;
		}

		private String stringOfMaintenance;
		
		public String getStringOfMaintenance() {
			return stringOfMaintenance;
		}
		public void setStringOfMaintenance(String stringOfMaintenance) {
			this.stringOfMaintenance = stringOfMaintenance;
		}
		public String getStringOfSupportIds() {
			return stringOfSupportIds;
		}
		public void setStringOfSupportIds(String stringOfSupportIds) {
			this.stringOfSupportIds = stringOfSupportIds;
		}

	//edited anushka 2018-12-28------------------------------------------------------------------------------------------------------
	private List<Summary> areaSummaryList;
	//-------------------------------------------------------------------------------------------------------------------------------
	
	private List<MmsTxntowermaintenance> mmsTxtMntList;
	
	private List<MmsTxntowermntcomplesion> mmsTxtCompletionList;
	
	
	public List<MmsTxntowermntcomplesion> getMmsTxtCompletionList() {
		return mmsTxtCompletionList;
	}
	public void setMmsTxtCompletionList(
			List<MmsTxntowermntcomplesion> mmsTxtCompletionList) {
		this.mmsTxtCompletionList = mmsTxtCompletionList;
	}

	private List<MmsAddearthconductortype> erthConTypeList;
	
	public List<MmsAddearthconductortype> getErthConTypeList() {
		return erthConTypeList;
	}
	public void setErthConTypeList(List<MmsAddearthconductortype> erthConTypeList) {
		this.erthConTypeList = erthConTypeList;
	}

	List<MmsAddsupporttype> sTypeList;
	private List<MmsAddlinetype> linetype;
	


	public List<MmsAddlinetype> getLinetype() {
		return linetype;
	}
	public void setLinetype(List<MmsAddlinetype> linetype) {
		this.linetype = linetype;
	}
	public List<MmsAddsupporttype> getsTypeList() {
		return sTypeList;
	}
	public void setsTypeList(List<MmsAddsupporttype> sTypeList) {
		this.sTypeList = sTypeList;
	}

	private List<MmsAddconductortype> conTypeList;
	
	
	public List<MmsAddconductortype> getConTypeList() {
		return conTypeList;
	}
	public void setConTypeList(List<MmsAddconductortype> conTypeList) {
		this.conTypeList = conTypeList;
	}




	private List<MmsAddtowerconfiguration> activeConfigurations;
	private List<MmsTowertype> towerType;
	
	public List<MmsTowertype> getTowerType() {
		return towerType;
	}
	public void setTowerType(List<MmsTowertype> towerType) {
		this.towerType = towerType;
	}
	public List<MmsAddtowerconfiguration> getActiveConfigurations() {
	        return activeConfigurations;
	    }
	    public void setActiveConfigurations(List<MmsAddtowerconfiguration> activeConfigurations) {
	        this.activeConfigurations = activeConfigurations;
	    }
	
	
	
	
	private List<MmsAddline> lineListEdit;
	
	public List<MmsAddline> getLineListEdit() {
		return lineListEdit;
	}
	public void setLineListEdit(List<MmsAddline> lineListEdit) {
		this.lineListEdit = lineListEdit;
	}
	public List<MmsTxntowermaintenance> getMmsTxtMntList() {
		return mmsTxtMntList;
	}
	public void setMmsTxtMntList(List<MmsTxntowermaintenance> mmsTxtMntList) {
		this.mmsTxtMntList = mmsTxtMntList;
	}
	public List<Summary> getSummaryList() {
		return summaryList;
	}
	public void setSummaryList(List<Summary> summaryList) {
		this.summaryList = summaryList;
	}
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	private List<MmsAddsupport> support;
	private MmsInspection inspection;
	private List<Sauserm> sausermList;
	
	Map<String,String> intRequest = new LinkedHashMap<String,String>();
	
	
	
	public Map<String, String> getIntRequest() {
		return intRequest;
	}

	public void setIntRequest(Map<String, String> intRequest) {
		this.intRequest = intRequest;
	}

	Map<String,String> saList = new LinkedHashMap<String,String>();
	Map<String,String> appList = new LinkedHashMap<String,String>();
	
	Map<String,String> eeList = new LinkedHashMap<String,String>();
	
	public Map<String, String> getEeList() {
		return eeList;
	}

	public void setEeList(Map<String, String> eeList) {
		this.eeList = eeList;
	}
	
	Map<String, String> esList = new LinkedHashMap<String, String>();
	
	Map<String, String> orderList = new LinkedHashMap<String, String>();
	
public Map<String, String> getOrderList() {
		return orderList;
	}

	public void setOrderList(Map<String, String> orderList) {
		this.orderList = orderList;
	}

private String ordercard;


	public String getOrdercard() {
	return ordercard;
}

public void setOrdercard(String ordercard) {
	this.ordercard = ordercard;
}

	public Map<String, String> getEsList() {
		return esList;
	}

	public void setEsList(Map<String, String> esList) {
		this.esList = esList;
	}
	
	private List<Pcesthmt> pcesthmtList;
	
	public List<Pcesthmt> getPcesthmtList() {
		return pcesthmtList;
	}

	public void setPcesthmtList(List<Pcesthmt> pcesthmtList) {
		this.pcesthmtList = pcesthmtList;
	}

	private String accountnumber;
	
	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	Map<String,String> sinList = new LinkedHashMap<String,String>();
	

	public Map<String, String> getSinList() {
		return sinList;
	}

	public void setSinList(Map<String, String> sinList) {
		this.sinList = sinList;
	}

	Map<String,String> cscList = new LinkedHashMap<String,String>();
	
	public Map<String, String> getCscList() {
		return cscList;
	}
	public void setCscList(Map<String, String> cscList) {
		this.cscList = cscList;
	}

	Map<String,String> supportList = new LinkedHashMap<String,String>();
	
	public Map<String, String> getSupportList() {
		return supportList;
	}

	public void setSupportList(Map<String, String> supportList) {
		this.supportList = supportList;
	}

	Map<String,String> provinceList = new LinkedHashMap<String,String>();
	Map<String,String> supTypeList = new LinkedHashMap<String,String>();
	Map<String,String> areaList = new LinkedHashMap<String,String>();
	Map<String,String> lineList = new LinkedHashMap<String,String>();
	Map<String,String> lineTypeList = new LinkedHashMap<String,String>();
	Map<Long,String> lineLongList = new LinkedHashMap<Long,String>();
	Map<String,String> conTypeListforPE = new LinkedHashMap<String,String>();
	Map<String,String> circuteTypeListforPE = new LinkedHashMap<String,String>();
	Map<String,String> cycleList = new LinkedHashMap<String,String>();
	
	Map<Long,String> lineListLong = new LinkedHashMap<Long,String>();
	
	
	public Map<Long, String> getLineListLong() {
		return lineListLong;
	}

	public void setLineListLong(Map<Long, String> lineListLong) {
		this.lineListLong = lineListLong;
	}

	public Map<String, String> getCycleList() {
		return cycleList;
	}
	public void setCycleList(Map<String, String> cycleList) {
		this.cycleList = cycleList;
	}
	public Map<String, String> getCircuteTypeListforPE() {
		return circuteTypeListforPE;
	}
	public void setCircuteTypeListforPE(Map<String, String> circuteTypeListforPE) {
		this.circuteTypeListforPE = circuteTypeListforPE;
	}
	public Map<String, String> getConTypeListforPE() {
		return conTypeListforPE;
	}
	public void setConTypeListforPE(Map<String, String> conTypeListforPE) {
		this.conTypeListforPE = conTypeListforPE;
	}

	private String message;
	private String messageType;
	private List<String> provinces;
	private MmsAddsupport supportObj;
	private MmsTxntowermaintenance txtMntObj = new MmsTxntowermaintenance();
	
	
	
	

	
	public MmsTxntowermaintenance getTxtMntObj() {
		return txtMntObj;
	}
	public void setTxtMntObj(MmsTxntowermaintenance txtMntObj) {
		this.txtMntObj = txtMntObj;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public MmsAddsupport getSupportObj() {
		return supportObj;
	}
	public void setSupportObj(MmsAddsupport supportObj) {
		this.supportObj = supportObj;
	}
	public MmsTxntowermaintenance getMmsTxtMnt() {
		return mmsTxtMnt;
	}
	public void setMmsTxtMnt(MmsTxntowermaintenance mmsTxtMnt) {
		this.mmsTxtMnt = mmsTxtMnt;
	}
	public Map<Long, String> getLineLongList() {
		return lineLongList;
	}
	public void setLineLongList(Map<Long, String> lineLongList) {
		this.lineLongList = lineLongList;
	}
	
	public MmsAddlinetype getLineType() {
		return lineType;
	}
	public void setLineType(MmsAddlinetype lineType) {
		this.lineType = lineType;
	}
	
	public Map<String, String> getLineTypeList() {
		return lineTypeList;
	}
	public void setLineTypeList(Map<String, String> lineTypeList) {
		this.lineTypeList = lineTypeList;
	}
	
	public Map<String, String> getAppList() {
		return appList;
	}
	public void setAppList(Map<String, String> appList) {
		this.appList = appList;
	}
	public Applicant getApplicant() {
		return applicant;
	}
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	public Map<String, String> getSaList() {
		return saList;
	}
	public void setSaList(Map<String, String> saList) {
		this.saList = saList;
	}

	public Sauserm getSauserm() {
		return sauserm;
	}
	public void setSauserm(Sauserm sauserm) {
		this.sauserm = sauserm;
	}
	
	public List<Sauserm> getSausermList() {
		return sausermList;
	}
	public void setSausermList(List<Sauserm> sausermList) {
		this.sausermList = sausermList;
	}

	
	public MmsInspection getInspection() {
		return inspection;
	}
	public void setInspection(MmsInspection inspection) {
		this.inspection = inspection;
	}
	
	public List<MmsAddsupport> getSupport() {
		return support;
	}
	public void setSupport(List<MmsAddsupport> support) {
		this.support = support;
	}
	
	public Map<String, String> getLineList() {
		return lineList;
	}
	public void setLineList(Map<String, String> lineList) {
		this.lineList = lineList;
	}
	
	public MmsAddline getLine() {
		return line;
	}
	public void setLine(MmsAddline line) {
		this.line = line;
	}
	
	public Gldeptm getGldeptobj() {
		return gldeptobj;
	}
	public void setGldeptobj(Gldeptm gldeptobj) {
		this.gldeptobj = gldeptobj;
	}
	
	
	public Map<String, String> getAreaList() {
		return areaList;
	}
	public void setAreaList(Map<String, String> areaList) {
		this.areaList = areaList;
	}
	
	public MmsAddsupporttype getSupportType() {
		return supportType;
	}
	public void setSupportType(MmsAddsupporttype supportType) {
		this.supportType = supportType;
	}
	
	public Map<String, String> getSupTypeList() {
		return supTypeList;
	}
	public void setSupTypeList(Map<String, String> supTypeList) {
		this.supTypeList = supTypeList;
	}
	
	public Map<String, String> getProvinceList() {
		return provinceList;
	}
	public void setProvinceList(Map<String, String> provinceList) {
		this.provinceList = provinceList;
	}
	public List<Glcompm> getGlcompm() {
		return glcompm;
	}
	public void setGlcompm(List<Glcompm> glcompm) {
		this.glcompm = glcompm;
	}
	
	public Glcompm getGlcompmobj() {
		return glcompmobj;
	}
	public void setGlcompmobj(Glcompm glcompmobj) {
		this.glcompmobj = glcompmobj;
	}
	public List<String> getProvinces() {
		return provinces;
	}
	public void setProvinces(List<String> provinces) {
		this.provinces = provinces;
	}
	Map<String,String> selectPivList;
	//private String pivDetail;

	
	//public Map<String, String> getPivTypeList() {
		//return pivTypeList;
	//}
	//public void setPivTypeList(Map<String, String> pivTypeList) {
		//this.pivTypeList = pivTypeList;
	//}
	//public PivDetail getPivDetail() {
		//return pivDetail;
	//}
	//public void setPivDetail(PivDetail pivDetail) {
	//	this.pivDetail = pivDetail;
	//}
	//public PivApplicant getPivApplicant() {
		//return pivApplicant;
	//}
	//public void setPivApplicant(PivApplicant pivApplicant) {
		//this.pivApplicant = pivApplicant;
	//}
	//public List<PivAmountGrid> getAmountList() {
		//return amountList;
	//}
	//public void setAmountList(List<PivAmountGrid> amountList) {
		//this.amountList = amountList;
	//}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	//public List<String> getPivNoList() {
		//return pivNoList;
	//}
	//public void setPivNoList(List<String> pivNoList) {
		//this.pivNoList = pivNoList;
	//}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	
	//edited anushka 2018-12-28------------------------------------------------------------------------------------------------------
	public List<Summary> getAreaSummaryList() {
		return areaSummaryList;
	}
	public void setAreaSummaryList(List<Summary> areaSummaryList) {
		this.areaSummaryList = areaSummaryList;
	}
	//-------------------------------------------------------------------------------------------------------------------------------

	
	/*public List<PivAmountGrid> getContacts() {
		return contacts;
	}
	public void setContacts(List<PivAmountGrid> contacts) {
		this.contacts = contacts;
	}*/
	
	private MmsProvince provincePng;
	public MmsProvince getProvincePng() {
		return provincePng;
	}
	public void setProvincePng(MmsProvince provincePng) {
		this.provincePng = provincePng;
	}
	private MmsArea areaPng;
	public MmsArea getAreaPng() {
		return areaPng;
	}
	public void setAreaPng(MmsArea areaPng) {
		this.areaPng = areaPng;
	}
	
	private MmsCsc cscPng;
	public MmsCsc getCscPng() {
		return cscPng;
	}
	public void setCscPng(MmsCsc cscPng) {
		this.cscPng = cscPng;
	}
	
	private List<BdDetail> bdDetailList;
	public List<BdDetail> getBdDetailList() {
		return bdDetailList;
	}
	public void setBdDetailList(List<BdDetail> bdDetailList) {
		this.bdDetailList = bdDetailList;
	}
	
	public List<Long> getListOfLines() {
		return listOfLines;
	}
	public void setListOfLines(List<Long> listOfLines) {
		this.listOfLines = listOfLines;
	}

		//edited anushka 2019-01-18 --------------------------------------------------------------------------------------------------------
		private List<Long> listOfLines;
		//----------------------------------------------------------------------------------------------------------------------------------

		public List<Long> getSelectedLines() {
			return selectedLines;
		}

		public void setSelectedLines(List<Long> selectedLines) {
			this.selectedLines = selectedLines;
		}

		private List<Long> selectedLines;
		
		private List<Long> selectedLinesNew;

		private String conType;
		
		public String getConType() {
			return conType;
		}

		public void setConType(String conType) {
			this.conType = conType;
		}

		private String Save;
	

public String getSave() {
			return Save;
		}

		public void setSave(String save) {
			Save = save;
		}

public List<Long> getSelectedLinesNew() {
			return selectedLinesNew;
		}

		public void setSelectedLinesNew(List<Long> selectedLinesNew) {
			this.selectedLinesNew = selectedLinesNew;
		}

private String stringOfSwitchIds;

public String getStringOfSwitchIds() {
	return stringOfSwitchIds;
}

public void setStringOfSwitchIds(String stringOfSwitchIds) {
	this.stringOfSwitchIds = stringOfSwitchIds;
}

private String stringOfarSwitchIds;

public String getStringOfarSwitchIds() {
	return stringOfarSwitchIds;
}

public void setStringOfarSwitchIds(String stringOfarSwitchIds) {
	this.stringOfarSwitchIds = stringOfarSwitchIds;
}

private String stringOflbsSwitchIds;

public String getStringOflbsSwitchIds() {
	return stringOflbsSwitchIds;
}

public void setStringOflbsSwitchIds(String stringOflbsSwitchIds) {
	this.stringOflbsSwitchIds = stringOflbsSwitchIds;
}

private String stringOfabsSwitchIds;

public String getStringOfabsSwitchIds() {
	return stringOfabsSwitchIds;
}

public void setStringOfabsSwitchIds(String stringOfabsSwitchIds) {
	this.stringOfabsSwitchIds = stringOfabsSwitchIds;
}

private String stringOfddloSwitchIds;

public String getStringOfddloSwitchIds() {
	return stringOfddloSwitchIds;
}

public void setStringOfddloSwitchIds(String stringOfddloSwitchIds) {
	this.stringOfddloSwitchIds = stringOfddloSwitchIds;
}

private List<MmsAddswitch> arListEdit;

public List<MmsAddswitch> getArListEdit() {
	return arListEdit;
}

public void setArListEdit(List<MmsAddswitch> arListEdit) {
	this.arListEdit = arListEdit;
}

private List<MmsAddswitch> switchListEdit;

public List<MmsAddswitch> getSwitchListEdit() {
	return switchListEdit;
}

public void setSwitchListEdit(List<MmsAddswitch> switchListEdit) {
	this.switchListEdit = switchListEdit;
}

private List<MmsAddswitch> lbsListEdit;

public List<MmsAddswitch> getLbsListEdit() {
	return lbsListEdit;
}

public void setLbsListEdit(List<MmsAddswitch> lbsListEdit) {
	this.lbsListEdit = lbsListEdit;
}

private List<MmsAddswitch> absListEdit;

public List<MmsAddswitch> getAbsListEdit() {
	return absListEdit;
}

public void setAbsListEdit(List<MmsAddswitch> absListEdit) {
	this.absListEdit = absListEdit;
}

private List<MmsAddswitch> ddloListEdit;

public List<MmsAddswitch> getDdloListEdit() {
	return ddloListEdit;
}

public void setDdloListEdit(List<MmsAddswitch> ddloListEdit) {
	this.ddloListEdit = ddloListEdit;
}

private List<MmsAddfeeder> feederListEdit;

public List<MmsAddfeeder> getFeederListEdit() {
	return feederListEdit;
}

public void setFeederListEdit(List<MmsAddfeeder> feederListEdit) {
	this.feederListEdit = feederListEdit;
	
	
}


private String stringOfFeederIds;

public String getStringOfFeederIds() {
	return stringOfFeederIds;
}

public void setStringOfFeederIds(String stringOfFeederIds) {
	this.stringOfFeederIds = stringOfFeederIds;
}


	
	
	


	


	
}
