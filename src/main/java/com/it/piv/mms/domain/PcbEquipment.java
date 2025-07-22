package com.it.piv.mms.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PCB_EQUIPMENT database table.
 * 
 */
@Entity
@Table(name="PCB_EQUIPMENT")
@NamedQuery(name="PcbEquipment.findAll", query="SELECT p FROM PcbEquipment p")
public class PcbEquipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EQUIPMENT_ID")
	private String equipmentId;

	@Column(name="A_CLASS_ACTIVE")
	private String aClassActive;

	@Column(name="A_CLASS_REACTIVE")
	private String aClassReactive;

	private String area;

	private String branch;

	private BigDecimal capacity;

	private String condition;

	private String divison;

	//@Temporal(TemporalType.DATE)
	@Column(name="ENTERED_DATE")
	private Date enteredDate;

	@Column(name="ITI_CONF_POSITIVE")
	private String itiConfPositive;

	@Column(name="ITI_RESULTS")
	private String itiResults;

	@Column(name="M_CONSTANT_ACTIVE")
	private String mConstantActive;

	@Column(name="M_CONSTANT_REACTIVE")
	private String mConstantReactive;

	@Column(name="M_CT_RATIO")
	private String mCtRatio;

	@Column(name="M_SERIAL_NO")
	private String mSerialNo;

	@Column(name="M_VT_RATIO")
	private String mVtRatio;

	@Column(name="MANUFACTURE_BRAND")
	private String manufactureBrand;

	@Temporal(TemporalType.DATE)
	@Column(name="MANUFACTURE_DATE")
	@DateTimeFormat(pattern="YYYY")
    private Date manufactureDate;

	@Column(name="MANUFACTURE_LTL")
	private String manufactureLtl;

	@Column(name="METER_MAKE")
	private String meterMake;

	@Column(name="MULTIFICATION_FACTOR")
	private String multificationFactor;

	@Column(name="OIL_WEIGHT")
	private BigDecimal oilWeight;

	@Column(name="PHOTO_REF")
	private String photoRef;

	@Column(name="PHOTO_REF_2")
	private String photoRef2;

	@Column(name="PHOTO_REF_3")
	private String photoRef3;

	@Column(name="PHOTO_TAKEN")
	private String photoTaken;

	@Column(name="PRIMARY_SUB")
	private String primarySub;

	@Column(name="REFERENCE_NO")
	private String referenceNo;

	@Column(name="SCALING_FACTOR")
	private String scalingFactor;

	@Column(name="SENT_TO_ITI")
	private String sentToIti;

	@Column(name="SERIA_TYPE")
	private String seriaType;

	@Column(name="SERIAL_NO")
	private String serialNo;

	@Column(name="SIN_NO")
	private String sinNo;

	private BigDecimal status;

	@Column(name="\"TYPE\"")
	private String type;

	private String unit;

	//@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	@Column(name="VOL_OIL")
	private BigDecimal volOil;

	private BigDecimal voltage;

	@Column(name="VOLTAGE_STR")
	private String voltageStr;

	@Column(name="VOLUME_OF_OIL")
	private String volumeOfOil;

	@Column(name="WEIGHT_TRANSFORMER")
	private BigDecimal weightTransformer;

	@Column(name="\"YEAR\"")
	private BigDecimal year;

	public PcbEquipment() {
	}

	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getAClassActive() {
		return this.aClassActive;
	}

	public void setAClassActive(String aClassActive) {
		this.aClassActive = aClassActive;
	}

	public String getAClassReactive() {
		return this.aClassReactive;
	}

	public void setAClassReactive(String aClassReactive) {
		this.aClassReactive = aClassReactive;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getBranch() {
		return this.branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public BigDecimal getCapacity() {
		return this.capacity;
	}

	public void setCapacity(BigDecimal capacity) {
		this.capacity = capacity;
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getDivison() {
		return this.divison;
	}

	public void setDivison(String divison) {
		this.divison = divison;
	}

	public Date getEnteredDate() {
		return this.enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}

	public String getItiConfPositive() {
		return this.itiConfPositive;
	}

	public void setItiConfPositive(String itiConfPositive) {
		this.itiConfPositive = itiConfPositive;
	}

	public String getItiResults() {
		return this.itiResults;
	}

	public void setItiResults(String itiResults) {
		this.itiResults = itiResults;
	}

	public String getMConstantActive() {
		return this.mConstantActive;
	}

	public void setMConstantActive(String mConstantActive) {
		this.mConstantActive = mConstantActive;
	}

	public String getMConstantReactive() {
		return this.mConstantReactive;
	}

	public void setMConstantReactive(String mConstantReactive) {
		this.mConstantReactive = mConstantReactive;
	}

	public String getMCtRatio() {
		return this.mCtRatio;
	}

	public void setMCtRatio(String mCtRatio) {
		this.mCtRatio = mCtRatio;
	}

	public String getMSerialNo() {
		return this.mSerialNo;
	}

	public void setMSerialNo(String mSerialNo) {
		this.mSerialNo = mSerialNo;
	}

	public String getMVtRatio() {
		return this.mVtRatio;
	}

	public void setMVtRatio(String mVtRatio) {
		this.mVtRatio = mVtRatio;
	}

	public String getManufactureBrand() {
		return this.manufactureBrand;
	}

	public void setManufactureBrand(String manufactureBrand) {
		this.manufactureBrand = manufactureBrand;
	}

	public Date getManufactureDate() {
		return this.manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getManufactureLtl() {
		return this.manufactureLtl;
	}

	public void setManufactureLtl(String manufactureLtl) {
		this.manufactureLtl = manufactureLtl;
	}

	public String getMeterMake() {
		return this.meterMake;
	}

	public void setMeterMake(String meterMake) {
		this.meterMake = meterMake;
	}

	public String getMultificationFactor() {
		return this.multificationFactor;
	}

	public void setMultificationFactor(String multificationFactor) {
		this.multificationFactor = multificationFactor;
	}

	public BigDecimal getOilWeight() {
		return this.oilWeight;
	}

	public void setOilWeight(BigDecimal oilWeight) {
		this.oilWeight = oilWeight;
	}

	public String getPhotoRef() {
		return this.photoRef;
	}

	public void setPhotoRef(String photoRef) {
		this.photoRef = photoRef;
	}

	public String getPhotoRef2() {
		return this.photoRef2;
	}

	public void setPhotoRef2(String photoRef2) {
		this.photoRef2 = photoRef2;
	}

	public String getPhotoRef3() {
		return this.photoRef3;
	}

	public void setPhotoRef3(String photoRef3) {
		this.photoRef3 = photoRef3;
	}

	public String getPhotoTaken() {
		return this.photoTaken;
	}

	public void setPhotoTaken(String photoTaken) {
		this.photoTaken = photoTaken;
	}

	public String getPrimarySub() {
		return this.primarySub;
	}

	public void setPrimarySub(String primarySub) {
		this.primarySub = primarySub;
	}

	public String getReferenceNo() {
		return this.referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getScalingFactor() {
		return this.scalingFactor;
	}

	public void setScalingFactor(String scalingFactor) {
		this.scalingFactor = scalingFactor;
	}

	public String getSentToIti() {
		return this.sentToIti;
	}

	public void setSentToIti(String sentToIti) {
		this.sentToIti = sentToIti;
	}

	public String getSeriaType() {
		return this.seriaType;
	}

	public void setSeriaType(String seriaType) {
		this.seriaType = seriaType;
	}

	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getSinNo() {
		return this.sinNo;
	}

	public void setSinNo(String sinNo) {
		this.sinNo = sinNo;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public BigDecimal getVolOil() {
		return this.volOil;
	}

	public void setVolOil(BigDecimal volOil) {
		this.volOil = volOil;
	}

	public BigDecimal getVoltage() {
		return this.voltage;
	}

	public void setVoltage(BigDecimal voltage) {
		this.voltage = voltage;
	}

	public String getVoltageStr() {
		return this.voltageStr;
	}

	public void setVoltageStr(String voltageStr) {
		this.voltageStr = voltageStr;
	}

	public String getVolumeOfOil() {
		return this.volumeOfOil;
	}

	public void setVolumeOfOil(String volumeOfOil) {
		this.volumeOfOil = volumeOfOil;
	}

	public BigDecimal getWeightTransformer() {
		return this.weightTransformer;
	}

	public void setWeightTransformer(BigDecimal weightTransformer) {
		this.weightTransformer = weightTransformer;
	}

	public BigDecimal getYear() {
		return this.year;
	}

	public void setYear(BigDecimal year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "PcbEquipment [equipmentId=" + equipmentId + ", aClassActive="
				+ aClassActive + ", aClassReactive=" + aClassReactive
				+ ", area=" + area + ", branch=" + branch + ", capacity="
				+ capacity + ", condition=" + condition + ", divison="
				+ divison + ", enteredDate=" + enteredDate
				+ ", itiConfPositive=" + itiConfPositive + ", itiResults="
				+ itiResults + ", mConstantActive=" + mConstantActive
				+ ", mConstantReactive=" + mConstantReactive + ", mCtRatio="
				+ mCtRatio + ", mSerialNo=" + mSerialNo + ", mVtRatio="
				+ mVtRatio + ", manufactureBrand=" + manufactureBrand
				+ ", manufactureDate=" + manufactureDate + ", manufactureLtl="
				+ manufactureLtl + ", meterMake=" + meterMake
				+ ", multificationFactor=" + multificationFactor
				+ ", oilWeight=" + oilWeight + ", photoRef=" + photoRef
				+ ", photoRef2=" + photoRef2 + ", photoRef3=" + photoRef3
				+ ", photoTaken=" + photoTaken + ", primarySub=" + primarySub
				+ ", referenceNo=" + referenceNo + ", scalingFactor="
				+ scalingFactor + ", sentToIti=" + sentToIti + ", seriaType="
				+ seriaType + ", serialNo=" + serialNo + ", sinNo=" + sinNo
				+ ", status=" + status + ", type=" + type + ", unit=" + unit
				+ ", updatedDate=" + updatedDate + ", volOil=" + volOil
				+ ", voltage=" + voltage + ", voltageStr=" + voltageStr
				+ ", volumeOfOil=" + volumeOfOil + ", weightTransformer="
				+ weightTransformer + ", year=" + year + "]";
	}
	
	

}