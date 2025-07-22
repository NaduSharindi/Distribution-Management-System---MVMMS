package com.it.piv.mms.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MMS_ADDGANTRY database table.
 * 
 */
@Entity
@Table(name="MMS_ADDGANTRY")
@NamedQuery(name="MmsAddgantry.findAll", query="SELECT m FROM MmsAddgantry m")
public class MmsAddgantry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqGen")
	@SequenceGenerator(name = "SeqGen", sequenceName = "GANTRY_SEQ", allocationSize = 1)
	private long id;

	@Column(name="APPROVAL_LEVEL")
	private String approvalLevel;

	@Column(name="APPROVED_BY")
	private String approvedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="APPROVED_DATE")
	private Date approvedDate;

	@Column(name="APPROVED_TIME")
	private String approvedTime;

	private String area;

	@Column(name="BUS_BAR_ABS")
	private BigDecimal busBarAbs;

	@Column(name="BUS_BAR_CONDUTOER")
	private BigDecimal busBarCondutoer;

	@Column(name="BUS_BAR_DDLO")
	private BigDecimal busBarDdlo;

	@Column(name="BUS_BAR_INSULATOR")
	private BigDecimal busBarInsulator;

	@Column(name="BUS_BAR_LBS")
	private BigDecimal busBarLbs;

	@Column(name="BUS_BAR_NO_TRANFORMER")
	private BigDecimal busBarNoTranformer;

	@Column(name="BUS_BAR_SA")
	private BigDecimal busBarSa;

	private String code;

	private String csc;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_COMM")
	private Date dateOfComm;

	@Column(name="EARTH_FAULT_CURNT_CAPACITY")
	private BigDecimal earthFaultCurntCapacity;

	@Column(name="ENT_BY")
	private String entBy;

	@Temporal(TemporalType.DATE)
	@Column(name="ENT_DATE")
	private Date entDate;

	@Column(name="ENT_TIME")
	private String entTime;

	@Column(name="GANTRY_ELE_TYPE")
	private BigDecimal gantryEleType;

	@Column(name="GANTRY_TYPE")
	private BigDecimal gantryType;

	@Column(name="GPS_LATITUDE")
	private BigDecimal gpsLatitude;

	@Column(name="GPS_LONGITUDE")
	private BigDecimal gpsLongitude;

	@Column(name="LINE_ID")
	private BigDecimal lineId;

	@Column(name="MAP_ID")
	private BigDecimal mapId;

	private String name;

	@Column(name="NO_ABS")
	private BigDecimal noAbs;

	@Column(name="NO_AR")
	private BigDecimal noAr;

	@Column(name="NO_BUS_BAR")
	private BigDecimal noBusBar;

	@Column(name="NO_BUS_SEC")
	private BigDecimal noBusSec;

	@Column(name="NO_DDLO_FUSES")
	private BigDecimal noDdloFuses;

	@Column(name="NO_DDLO_LINKS")
	private BigDecimal noDdloLinks;

	@Column(name="NO_IN_BAYS")
	private BigDecimal noInBays;

	@Column(name="NO_INCOMING_FEEDER")
	private BigDecimal noIncomingFeeder;

	@Column(name="NO_LBS")
	private BigDecimal noLbs;

	@Column(name="NO_OUT_BAYS")
	private BigDecimal noOutBays;

	@Column(name="NO_OUTGOING_FEEDER")
	private BigDecimal noOutgoingFeeder;

	@Column(name="NO_SA")
	private BigDecimal noSa;

	@Column(name="PHM_BRANCH")
	private String phmBranch;

	@Column(name="PICTURE_1")
	private String picture1;

	@Column(name="PICTURE_2")
	private String picture2;

	@Column(name="PICTURE_3")
	private String picture3;

	@Column(name="PICTURE_4")
	private String picture4;

	@Column(name="PICTURE_5")
	private String picture5;

	private String province;

	@Column(name="SE_CU_CON_RES")
	private BigDecimal seCuConRes;

	@Column(name="SE_GROUNG_RES")
	private BigDecimal seGroungRes;

	@Column(name="SE_NO_POLES")
	private BigDecimal seNoPoles;

	@Column(name="SE_OVERHEAD_EARTHING")
	private String seOverheadEarthing;

	@Column(name="SHORT_CCT_CURNT_CAPACITY")
	private BigDecimal shortCctCurntCapacity;

	@Column(name="TOTAL_LAND_AREA")
	private BigDecimal totalLandArea;

	@Column(name="VALIDATE_BY")
	private String validateBy;

	@Temporal(TemporalType.DATE)
	@Column(name="VALIDATE_DATE")
	private Date validateDate;

	@Column(name="VALIDATE_TIME")
	private String validateTime;

	public MmsAddgantry() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApprovalLevel() {
		return this.approvalLevel;
	}

	public void setApprovalLevel(String approvalLevel) {
		this.approvalLevel = approvalLevel;
	}

	public String getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getApprovedDate() {
		return this.approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getApprovedTime() {
		return this.approvedTime;
	}

	public void setApprovedTime(String approvedTime) {
		this.approvedTime = approvedTime;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public BigDecimal getBusBarAbs() {
		return this.busBarAbs;
	}

	public void setBusBarAbs(BigDecimal busBarAbs) {
		this.busBarAbs = busBarAbs;
	}

	public BigDecimal getBusBarCondutoer() {
		return this.busBarCondutoer;
	}

	public void setBusBarCondutoer(BigDecimal busBarCondutoer) {
		this.busBarCondutoer = busBarCondutoer;
	}

	public BigDecimal getBusBarDdlo() {
		return this.busBarDdlo;
	}

	public void setBusBarDdlo(BigDecimal busBarDdlo) {
		this.busBarDdlo = busBarDdlo;
	}

	public BigDecimal getBusBarInsulator() {
		return this.busBarInsulator;
	}

	public void setBusBarInsulator(BigDecimal busBarInsulator) {
		this.busBarInsulator = busBarInsulator;
	}

	public BigDecimal getBusBarLbs() {
		return this.busBarLbs;
	}

	public void setBusBarLbs(BigDecimal busBarLbs) {
		this.busBarLbs = busBarLbs;
	}

	public BigDecimal getBusBarNoTranformer() {
		return this.busBarNoTranformer;
	}

	public void setBusBarNoTranformer(BigDecimal busBarNoTranformer) {
		this.busBarNoTranformer = busBarNoTranformer;
	}

	public BigDecimal getBusBarSa() {
		return this.busBarSa;
	}

	public void setBusBarSa(BigDecimal busBarSa) {
		this.busBarSa = busBarSa;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCsc() {
		return this.csc;
	}

	public void setCsc(String csc) {
		this.csc = csc;
	}

	public Date getDateOfComm() {
		return this.dateOfComm;
	}

	public void setDateOfComm(Date dateOfComm) {
		this.dateOfComm = dateOfComm;
	}

	public BigDecimal getEarthFaultCurntCapacity() {
		return this.earthFaultCurntCapacity;
	}

	public void setEarthFaultCurntCapacity(BigDecimal earthFaultCurntCapacity) {
		this.earthFaultCurntCapacity = earthFaultCurntCapacity;
	}

	public String getEntBy() {
		return this.entBy;
	}

	public void setEntBy(String entBy) {
		this.entBy = entBy;
	}

	public Date getEntDate() {
		return this.entDate;
	}

	public void setEntDate(Date entDate) {
		this.entDate = entDate;
	}

	public String getEntTime() {
		return this.entTime;
	}

	public void setEntTime(String entTime) {
		this.entTime = entTime;
	}

	public BigDecimal getGantryEleType() {
		return this.gantryEleType;
	}

	public void setGantryEleType(BigDecimal gantryEleType) {
		this.gantryEleType = gantryEleType;
	}

	public BigDecimal getGantryType() {
		return this.gantryType;
	}

	public void setGantryType(BigDecimal gantryType) {
		this.gantryType = gantryType;
	}

	public BigDecimal getGpsLatitude() {
		return this.gpsLatitude;
	}

	public void setGpsLatitude(BigDecimal gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}

	public BigDecimal getGpsLongitude() {
		return this.gpsLongitude;
	}

	public void setGpsLongitude(BigDecimal gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}

	public BigDecimal getLineId() {
		return this.lineId;
	}

	public void setLineId(BigDecimal lineId) {
		this.lineId = lineId;
	}

	public BigDecimal getMapId() {
		return this.mapId;
	}

	public void setMapId(BigDecimal mapId) {
		this.mapId = mapId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getNoAbs() {
		return this.noAbs;
	}

	public void setNoAbs(BigDecimal noAbs) {
		this.noAbs = noAbs;
	}

	public BigDecimal getNoAr() {
		return this.noAr;
	}

	public void setNoAr(BigDecimal noAr) {
		this.noAr = noAr;
	}

	public BigDecimal getNoBusBar() {
		return this.noBusBar;
	}

	public void setNoBusBar(BigDecimal noBusBar) {
		this.noBusBar = noBusBar;
	}

	public BigDecimal getNoBusSec() {
		return this.noBusSec;
	}

	public void setNoBusSec(BigDecimal noBusSec) {
		this.noBusSec = noBusSec;
	}

	public BigDecimal getNoDdloFuses() {
		return this.noDdloFuses;
	}

	public void setNoDdloFuses(BigDecimal noDdloFuses) {
		this.noDdloFuses = noDdloFuses;
	}

	public BigDecimal getNoDdloLinks() {
		return this.noDdloLinks;
	}

	public void setNoDdloLinks(BigDecimal noDdloLinks) {
		this.noDdloLinks = noDdloLinks;
	}

	public BigDecimal getNoInBays() {
		return this.noInBays;
	}

	public void setNoInBays(BigDecimal noInBays) {
		this.noInBays = noInBays;
	}

	public BigDecimal getNoIncomingFeeder() {
		return this.noIncomingFeeder;
	}

	public void setNoIncomingFeeder(BigDecimal noIncomingFeeder) {
		this.noIncomingFeeder = noIncomingFeeder;
	}

	public BigDecimal getNoLbs() {
		return this.noLbs;
	}

	public void setNoLbs(BigDecimal noLbs) {
		this.noLbs = noLbs;
	}

	public BigDecimal getNoOutBays() {
		return this.noOutBays;
	}

	public void setNoOutBays(BigDecimal noOutBays) {
		this.noOutBays = noOutBays;
	}

	public BigDecimal getNoOutgoingFeeder() {
		return this.noOutgoingFeeder;
	}

	public void setNoOutgoingFeeder(BigDecimal noOutgoingFeeder) {
		this.noOutgoingFeeder = noOutgoingFeeder;
	}

	public BigDecimal getNoSa() {
		return this.noSa;
	}

	public void setNoSa(BigDecimal noSa) {
		this.noSa = noSa;
	}

	public String getPhmBranch() {
		return this.phmBranch;
	}

	public void setPhmBranch(String phmBranch) {
		this.phmBranch = phmBranch;
	}

	public String getPicture1() {
		return this.picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}

	public String getPicture2() {
		return this.picture2;
	}

	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}

	public String getPicture3() {
		return this.picture3;
	}

	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}

	public String getPicture4() {
		return this.picture4;
	}

	public void setPicture4(String picture4) {
		this.picture4 = picture4;
	}

	public String getPicture5() {
		return this.picture5;
	}

	public void setPicture5(String picture5) {
		this.picture5 = picture5;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public BigDecimal getSeCuConRes() {
		return this.seCuConRes;
	}

	public void setSeCuConRes(BigDecimal seCuConRes) {
		this.seCuConRes = seCuConRes;
	}

	public BigDecimal getSeGroungRes() {
		return this.seGroungRes;
	}

	public void setSeGroungRes(BigDecimal seGroungRes) {
		this.seGroungRes = seGroungRes;
	}

	public BigDecimal getSeNoPoles() {
		return this.seNoPoles;
	}

	public void setSeNoPoles(BigDecimal seNoPoles) {
		this.seNoPoles = seNoPoles;
	}

	public String getSeOverheadEarthing() {
		return this.seOverheadEarthing;
	}

	public void setSeOverheadEarthing(String seOverheadEarthing) {
		this.seOverheadEarthing = seOverheadEarthing;
	}

	public BigDecimal getShortCctCurntCapacity() {
		return this.shortCctCurntCapacity;
	}

	public void setShortCctCurntCapacity(BigDecimal shortCctCurntCapacity) {
		this.shortCctCurntCapacity = shortCctCurntCapacity;
	}

	public BigDecimal getTotalLandArea() {
		return this.totalLandArea;
	}

	public void setTotalLandArea(BigDecimal totalLandArea) {
		this.totalLandArea = totalLandArea;
	}

	public String getValidateBy() {
		return this.validateBy;
	}

	public void setValidateBy(String validateBy) {
		this.validateBy = validateBy;
	}

	public Date getValidateDate() {
		return this.validateDate;
	}

	public void setValidateDate(Date validateDate) {
		this.validateDate = validateDate;
	}

	public String getValidateTime() {
		return this.validateTime;
	}

	public void setValidateTime(String validateTime) {
		this.validateTime = validateTime;
	}
	
	private BigDecimal status;

	public BigDecimal getStatus() {
	return this.status;
	}

	public void setStatus(BigDecimal status) {
	this.status = status;
	}


}