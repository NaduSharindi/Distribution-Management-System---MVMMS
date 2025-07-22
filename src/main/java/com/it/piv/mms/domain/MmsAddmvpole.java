package com.it.piv.mms.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the MMS_ADDMVPOLE database table.
 * 
 */
@Entity
@Table(name="MMS_ADDMVPOLE")
@NamedQuery(name="MmsAddmvpole.findAll", query="SELECT m FROM MmsAddmvpole m")
public class MmsAddmvpole implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqGen")
	@SequenceGenerator(name = "SeqGen", sequenceName = "POLEMV_SEQ", allocationSize = 1)
	private long id;

	private String area;

	@Column(name="CROSS_ARM")
	private BigDecimal crossArm;

	private String csc;

	@Column(name="EARTH_CONDUCTOR")
	private String earthConductor;

	@Column(name="FEEDER_NO")
	private String feederNo;
	
	@Column(name="FEEDERNO")
	private String feederno;


	public String getFeederno() {
		return feederno;
	}

	public void setFeederno(String feederno) {
		this.feederno = feederno;
	}

	@Column(name="GPS_LATITUDE")
	private BigDecimal gpsLatitude;

	@Column(name="GPS_LONGITUDE")
	private BigDecimal gpsLongitude;

	@Column(name="HV_LV_COMBINE_RUN")
	private BigDecimal hvLvCombineRun;

	@Column(name="KV11_CONDUCTOR_CCT_1")
	private BigDecimal kv11ConductorCct1;

	@Column(name="KV11_CONDUCTOR_CCT_2")
	private BigDecimal kv11ConductorCct2;

	@Column(name="KV11_CONDUCTOR_CCT_3")
	private BigDecimal kv11ConductorCct3;

	@Column(name="KV33_CCT_1_PH_1")
	private BigDecimal kv33Cct1Ph1;

	@Column(name="KV33_CCT_1_PH_2")
	private BigDecimal kv33Cct1Ph2;

	@Column(name="KV33_CCT_1_PH_3")
	private BigDecimal kv33Cct1Ph3;

	@Column(name="KV33_CCT_2_PH_1")
	private BigDecimal kv33Cct2Ph1;

	@Column(name="KV33_CCT_2_PH_2")
	private BigDecimal kv33Cct2Ph2;

	@Column(name="KV33_CCT_2_PH_3")
	private BigDecimal kv33Cct2Ph3;

	@Column(name="KV33_CCT_3_PH_1")
	private BigDecimal kv33Cct3Ph1;

	@Column(name="KV33_CCT_3_PH_2")
	private BigDecimal kv33Cct3Ph2;

	@Column(name="KV33_CCT_3_PH_3")
	private BigDecimal kv33Cct3Ph3;

	@Column(name="KV33_CONDUCTOR_CCT_1")
	private BigDecimal kv33ConductorCct1;

	@Column(name="KV33_CONDUCTOR_CCT_2")
	private BigDecimal kv33ConductorCct2;

	@Column(name="KV33_CONDUCTOR_CCT_3")
	private BigDecimal kv33ConductorCct3;

	@Column(name="LINE_END")
	private BigDecimal lineEnd;

	@Column(name="LV_CONDUCTOR_TYPE")
	private BigDecimal lvConductorType;

	@Column(name="MV_SWITCH")
	private BigDecimal mvSwitch;

	@Column(name="NO_OF_11_KVCIRCUITS")
	private BigDecimal noOf11Kvcircuits;

	@Column(name="NO_OF_33_KVCIRCUITS")
	private BigDecimal noOf33Kvcircuits;

	@Column(name="NO_OF_LV_CCT")
	private BigDecimal noOfLvCct;
	
	
	@Column(name="NO_OF_CCT")
	private BigDecimal noOfCct;


	public BigDecimal getNoOfCct() {
		return noOfCct;
	}

	public void setNoOfCct(BigDecimal noOfCct) {
		this.noOfCct = noOfCct;
	}

	@Column(name="PIN_SHACKLE")
	private BigDecimal pinShackle;

	@Column(name="POLE_HEIGHT")
	private BigDecimal poleHeight;

	@Column(name="POLE_NAME")
	private String poleName;

	@Column(name="POLE_NO")
	private String poleNo;

	@Column(name="POLE_TYPE")
	private BigDecimal poleType;

	private BigDecimal status;

	private BigDecimal stay;

	@Column(name="STREET_LIGHT")
	private BigDecimal streetLight;

	
	@Column(name="TRANSFORMER_CAPACITY")
	private BigDecimal transformerCapacity;

	@Column(name="TRANSFORMER_TYPE")
	private BigDecimal transformerType;

	@Column(name="WORKING_LOAD")
	private BigDecimal workingLoad;
	
	
	
	private BigDecimal strut;

	@Column(name="STRUT_HEIGHT")
	private BigDecimal strutHeight;

	public BigDecimal getStrutHeight() {
		return strutHeight;
	}

	public void setStrutHeight(BigDecimal strutHeight) {
		this.strutHeight = strutHeight;
	}

	@Column(name="STRUT_TYPE")
	private BigDecimal strutType;

	public BigDecimal getStrutType() {
		return strutType;
	}

	public void setStrutType(BigDecimal strutType) {
		this.strutType = strutType;
	}

	@Column(name="STRUT_WORKING_LOAD")
	private BigDecimal strutWorkingLoad;


	public BigDecimal getStrutWorkingLoad() {
		return strutWorkingLoad;
	}

	public void setStrutWorkingLoad(BigDecimal strutWorkingLoad) {
		this.strutWorkingLoad = strutWorkingLoad;
	}
	
	
	@Column(name="STAY_TYPE")
	private BigDecimal stayType;


	public BigDecimal getStayType() {
		return stayType;
	}

	public void setStayType(BigDecimal stayType) {
		this.stayType = stayType;
	}

	public MmsAddmvpole() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public BigDecimal getCrossArm() {
		return this.crossArm;
	}

	public void setCrossArm(BigDecimal crossArm) {
		this.crossArm = crossArm;
	}

	public String getCsc() {
		return this.csc;
	}

	public void setCsc(String csc) {
		this.csc = csc;
	}

	public String getEarthConductor() {
		return this.earthConductor;
	}

	public void setEarthConductor(String earthConductor) {
		this.earthConductor = earthConductor;
	}

	public String getFeederNo() {
		return this.feederNo;
	}

	public void setFeederNo(String feederNo) {
		this.feederNo = feederNo;
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

	public BigDecimal getHvLvCombineRun() {
		return this.hvLvCombineRun;
	}

	public void setHvLvCombineRun(BigDecimal hvLvCombineRun) {
		this.hvLvCombineRun = hvLvCombineRun;
	}

	public BigDecimal getKv11ConductorCct1() {
		return this.kv11ConductorCct1;
	}

	public void setKv11ConductorCct1(BigDecimal kv11ConductorCct1) {
		this.kv11ConductorCct1 = kv11ConductorCct1;
	}

	public BigDecimal getKv11ConductorCct2() {
		return this.kv11ConductorCct2;
	}

	public void setKv11ConductorCct2(BigDecimal kv11ConductorCct2) {
		this.kv11ConductorCct2 = kv11ConductorCct2;
	}

	public BigDecimal getKv11ConductorCct3() {
		return this.kv11ConductorCct3;
	}

	public void setKv11ConductorCct3(BigDecimal kv11ConductorCct3) {
		this.kv11ConductorCct3 = kv11ConductorCct3;
	}

	public BigDecimal getKv33Cct1Ph1() {
		return this.kv33Cct1Ph1;
	}

	public void setKv33Cct1Ph1(BigDecimal kv33Cct1Ph1) {
		this.kv33Cct1Ph1 = kv33Cct1Ph1;
	}

	public BigDecimal getKv33Cct1Ph2() {
		return this.kv33Cct1Ph2;
	}

	public void setKv33Cct1Ph2(BigDecimal kv33Cct1Ph2) {
		this.kv33Cct1Ph2 = kv33Cct1Ph2;
	}

	public BigDecimal getKv33Cct1Ph3() {
		return this.kv33Cct1Ph3;
	}

	public void setKv33Cct1Ph3(BigDecimal kv33Cct1Ph3) {
		this.kv33Cct1Ph3 = kv33Cct1Ph3;
	}

	public BigDecimal getKv33Cct2Ph1() {
		return this.kv33Cct2Ph1;
	}

	public void setKv33Cct2Ph1(BigDecimal kv33Cct2Ph1) {
		this.kv33Cct2Ph1 = kv33Cct2Ph1;
	}

	public BigDecimal getKv33Cct2Ph2() {
		return this.kv33Cct2Ph2;
	}

	public void setKv33Cct2Ph2(BigDecimal kv33Cct2Ph2) {
		this.kv33Cct2Ph2 = kv33Cct2Ph2;
	}

	public BigDecimal getKv33Cct2Ph3() {
		return this.kv33Cct2Ph3;
	}

	public void setKv33Cct2Ph3(BigDecimal kv33Cct2Ph3) {
		this.kv33Cct2Ph3 = kv33Cct2Ph3;
	}

	public BigDecimal getKv33Cct3Ph1() {
		return this.kv33Cct3Ph1;
	}

	public void setKv33Cct3Ph1(BigDecimal kv33Cct3Ph1) {
		this.kv33Cct3Ph1 = kv33Cct3Ph1;
	}

	public BigDecimal getKv33Cct3Ph2() {
		return this.kv33Cct3Ph2;
	}

	public void setKv33Cct3Ph2(BigDecimal kv33Cct3Ph2) {
		this.kv33Cct3Ph2 = kv33Cct3Ph2;
	}

	public BigDecimal getKv33Cct3Ph3() {
		return this.kv33Cct3Ph3;
	}

	public void setKv33Cct3Ph3(BigDecimal kv33Cct3Ph3) {
		this.kv33Cct3Ph3 = kv33Cct3Ph3;
	}

	public BigDecimal getKv33ConductorCct1() {
		return this.kv33ConductorCct1;
	}

	public void setKv33ConductorCct1(BigDecimal kv33ConductorCct1) {
		this.kv33ConductorCct1 = kv33ConductorCct1;
	}

	public BigDecimal getKv33ConductorCct2() {
		return this.kv33ConductorCct2;
	}

	public void setKv33ConductorCct2(BigDecimal kv33ConductorCct2) {
		this.kv33ConductorCct2 = kv33ConductorCct2;
	}

	public BigDecimal getKv33ConductorCct3() {
		return this.kv33ConductorCct3;
	}

	public void setKv33ConductorCct3(BigDecimal kv33ConductorCct3) {
		this.kv33ConductorCct3 = kv33ConductorCct3;
	}

	public BigDecimal getLineEnd() {
		return this.lineEnd;
	}

	public void setLineEnd(BigDecimal lineEnd) {
		this.lineEnd = lineEnd;
	}

	public BigDecimal getLvConductorType() {
		return this.lvConductorType;
	}

	public void setLvConductorType(BigDecimal lvConductorType) {
		this.lvConductorType = lvConductorType;
	}

	public BigDecimal getMvSwitch() {
		return this.mvSwitch;
	}

	public void setMvSwitch(BigDecimal mvSwitch) {
		this.mvSwitch = mvSwitch;
	}

	public BigDecimal getNoOf11Kvcircuits() {
		return this.noOf11Kvcircuits;
	}

	public void setNoOf11Kvcircuits(BigDecimal noOf11Kvcircuits) {
		this.noOf11Kvcircuits = noOf11Kvcircuits;
	}

	public BigDecimal getNoOf33Kvcircuits() {
		return this.noOf33Kvcircuits;
	}

	public void setNoOf33Kvcircuits(BigDecimal noOf33Kvcircuits) {
		this.noOf33Kvcircuits = noOf33Kvcircuits;
	}

	public BigDecimal getNoOfLvCct() {
		return this.noOfLvCct;
	}

	public void setNoOfLvCct(BigDecimal noOfLvCct) {
		this.noOfLvCct = noOfLvCct;
	}

	public BigDecimal getPinShackle() {
		return this.pinShackle;
	}

	public void setPinShackle(BigDecimal pinShackle) {
		this.pinShackle = pinShackle;
	}

	public BigDecimal getPoleHeight() {
		return this.poleHeight;
	}

	public void setPoleHeight(BigDecimal poleHeight) {
		this.poleHeight = poleHeight;
	}

	public String getPoleName() {
		return this.poleName;
	}

	public void setPoleName(String poleName) {
		this.poleName = poleName;
	}

	public String getPoleNo() {
		return this.poleNo;
	}

	public void setPoleNo(String poleNo) {
		this.poleNo = poleNo;
	}

	public BigDecimal getPoleType() {
		return this.poleType;
	}

	public void setPoleType(BigDecimal poleType) {
		this.poleType = poleType;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public BigDecimal getStay() {
		return this.stay;
	}

	public void setStay(BigDecimal stay) {
		this.stay = stay;
	}

	public BigDecimal getStreetLight() {
		return this.streetLight;
	}

	public void setStreetLight(BigDecimal streetLight) {
		this.streetLight = streetLight;
	}

	public BigDecimal getStrut() {
		return this.strut;
	}

	public void setStrut(BigDecimal strut) {
		this.strut = strut;
	}

	public BigDecimal getTransformerCapacity() {
		return this.transformerCapacity;
	}

	public void setTransformerCapacity(BigDecimal transformerCapacity) {
		this.transformerCapacity = transformerCapacity;
	}

	public BigDecimal getTransformerType() {
		return this.transformerType;
	}

	public void setTransformerType(BigDecimal transformerType) {
		this.transformerType = transformerType;
	}

	public BigDecimal getWorkingLoad() {
		return this.workingLoad;
	}

	public void setWorkingLoad(BigDecimal workingLoad) {
		this.workingLoad = workingLoad;
	}

}