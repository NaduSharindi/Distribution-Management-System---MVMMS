package com.it.piv.mms.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MMS_ADDSWITCHES database table.
 * 
 */
@Entity
@Table(name="MMS_ADDSWITCHES")
@NamedQuery(name="MmsAddswitch.findAll", query="SELECT m FROM MmsAddswitch m")
public class MmsAddswitch implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MmsAddswitchPK id;
	
	@Column(name="PHM_BRANCH")
	private String phmBranch;

	public String getPhmBranch() {
		return phmBranch;
	}

	public void setPhmBranch(String phmBranch) {
		this.phmBranch = phmBranch;
	}

	@Column(name="CP_BATTERY_VALTAGE")
	private BigDecimal cpBatteryValtage;


	public BigDecimal getCpBatteryValtage() {
		return cpBatteryValtage;
	}

	public void setCpBatteryValtage(BigDecimal cpBatteryValtage) {
		this.cpBatteryValtage = cpBatteryValtage;
	}

	@Column(name="BRAND_NAME")
	private BigDecimal brandName;
	
	@Column(name="LINE_ID")
	private String lineId;

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	private BigDecimal location;


	public BigDecimal getLocation() {
		return location;
	}

	public void setLocation(BigDecimal location) {
		this.location = location;
	}
	
	@Column(name="GPS_LATITUDE")
	private BigDecimal gpsLatitude;

	public BigDecimal getGpsLatitude() {
		return gpsLatitude;
	}

	public void setGpsLatitude(BigDecimal gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}

	@Column(name="GPS_LONGITUDE")
	private BigDecimal gpsLongitude;


	public BigDecimal getGpsLongitude() {
		return gpsLongitude;
	}

	public void setGpsLongitude(BigDecimal gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}

	@Column(name="CARRIER_TYPE")
	private String carrierType;

	@Column(name="CP_BATTERY_CAPACITY")
	private BigDecimal cpBatteryCapacity;

	@Temporal(TemporalType.DATE)
	@Column(name="CP_DATE_COMMITIONING")
	private Date cpDateCommitioning;

	@Temporal(TemporalType.DATE)
	@Column(name="CP_DATE_MANUFATURE")
	private Date cpDateManufature;

	@Column(name="CP_MODEL_NUMBER")
	private String cpModelNumber;

	@Column(name="CP_NO_OF_BATTERIES")
	private BigDecimal cpNoOfBatteries;

	@Column(name="CP_REMOTE_OPERATION")
	private String cpRemoteOperation;

	@Column(name="CP_SERIAL_NO")
	private String cpSerialNo;

	private BigDecimal mounting;

	@Column(name="OPERATION_DIRECTION")
	private String operationDirection;

	@Column(name="\"POSITION\"")
	private String position;

	private BigDecimal quantity;

	@Column(name="SG_ARRANGEMENT")
	private String sgArrangement;

	@Temporal(TemporalType.DATE)
	@Column(name="SG_DATE_COMMITIONING")
	private Date sgDateCommitioning;

	@Temporal(TemporalType.DATE)
	@Column(name="SG_DATE_MANUFATURE")
	private Date sgDateManufature;

	@Column(name="SG_INSULATION_MEDIUM")
	private String sgInsulationMedium;

	@Column(name="SG_MODEL_NUMBER")
	private String sgModelNumber;

	@Column(name="SG_RATING")
	private BigDecimal sgRating;

	@Column(name="SG_SCC_LEVEL_OF_EQUIPMENT")
	private BigDecimal sgSccLevelOfEquipment;

	@Column(name="SG_SERIAL_NO")
	private String sgSerialNo;

	@Column(name="SWITCH_CODE")
	private String switchCode;

	@Column(name="SWITCH_NAME")
	private String switchName;

	@Column(name="SWITCH_TYPE")
	private BigDecimal switchType;
	
	
	@Column(name="CONNECTED_BUS")
	private BigDecimal connectedBus;

public BigDecimal getConnectedBus() {
		return connectedBus;
	}

	public void setConnectedBus(BigDecimal connectedBus) {
		this.connectedBus = connectedBus;
	}

@Column(name="AUXILIRY_DC_VOLATGE")
	private BigDecimal auxiliryDcVolatge;

public BigDecimal getAuxiliryDcVolatge() {
	return auxiliryDcVolatge;
}

public void setAuxiliryDcVolatge(BigDecimal auxiliryDcVolatge) {
	this.auxiliryDcVolatge = auxiliryDcVolatge;
}

@Column(name="ONE_BATTERY_VOLTAGE")
	private BigDecimal oneBatteryVoltage;


	public BigDecimal getOneBatteryVoltage() {
	return oneBatteryVoltage;
}

public void setOneBatteryVoltage(BigDecimal oneBatteryVoltage) {
	this.oneBatteryVoltage = oneBatteryVoltage;
}

private BigDecimal voltage;


	public BigDecimal getVoltage() {
	return voltage;
}

public void setVoltage(BigDecimal voltage) {
	this.voltage = voltage;
}

	public MmsAddswitch() {
	}

	public MmsAddswitchPK getId() {
		return this.id;
	}

	public void setId(MmsAddswitchPK id) {
		this.id = id;
	}

	public BigDecimal getBrandName() {
		return this.brandName;
	}

	public void setBrandName(BigDecimal brandName) {
		this.brandName = brandName;
	}

	public String getCarrierType() {
		return this.carrierType;
	}

	public void setCarrierType(String carrierType) {
		this.carrierType = carrierType;
	}

	public BigDecimal getCpBatteryCapacity() {
		return this.cpBatteryCapacity;
	}

	public void setCpBatteryCapacity(BigDecimal cpBatteryCapacity) {
		this.cpBatteryCapacity = cpBatteryCapacity;
	}

	public Date getCpDateCommitioning() {
		return this.cpDateCommitioning;
	}

	public void setCpDateCommitioning(Date cpDateCommitioning) {
		this.cpDateCommitioning = cpDateCommitioning;
	}

	public Date getCpDateManufature() {
		return this.cpDateManufature;
	}

	public void setCpDateManufature(Date cpDateManufature) {
		this.cpDateManufature = cpDateManufature;
	}

	public String getCpModelNumber() {
		return this.cpModelNumber;
	}

	public void setCpModelNumber(String cpModelNumber) {
		this.cpModelNumber = cpModelNumber;
	}

	public BigDecimal getCpNoOfBatteries() {
		return this.cpNoOfBatteries;
	}

	public void setCpNoOfBatteries(BigDecimal cpNoOfBatteries) {
		this.cpNoOfBatteries = cpNoOfBatteries;
	}

	public String getCpRemoteOperation() {
		return this.cpRemoteOperation;
	}

	public void setCpRemoteOperation(String cpRemoteOperation) {
		this.cpRemoteOperation = cpRemoteOperation;
	}

	public String getCpSerialNo() {
		return this.cpSerialNo;
	}

	public void setCpSerialNo(String cpSerialNo) {
		this.cpSerialNo = cpSerialNo;
	}

	public BigDecimal getMounting() {
		return this.mounting;
	}

	public void setMounting(BigDecimal mounting) {
		this.mounting = mounting;
	}

	public String getOperationDirection() {
		return this.operationDirection;
	}

	public void setOperationDirection(String operationDirection) {
		this.operationDirection = operationDirection;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getSgArrangement() {
		return this.sgArrangement;
	}

	public void setSgArrangement(String sgArrangement) {
		this.sgArrangement = sgArrangement;
	}

	public Date getSgDateCommitioning() {
		return this.sgDateCommitioning;
	}

	public void setSgDateCommitioning(Date sgDateCommitioning) {
		this.sgDateCommitioning = sgDateCommitioning;
	}

	public Date getSgDateManufature() {
		return this.sgDateManufature;
	}

	public void setSgDateManufature(Date sgDateManufature) {
		this.sgDateManufature = sgDateManufature;
	}

	public String getSgInsulationMedium() {
		return this.sgInsulationMedium;
	}

	public void setSgInsulationMedium(String sgInsulationMedium) {
		this.sgInsulationMedium = sgInsulationMedium;
	}

	public String getSgModelNumber() {
		return this.sgModelNumber;
	}

	public void setSgModelNumber(String sgModelNumber) {
		this.sgModelNumber = sgModelNumber;
	}

	public BigDecimal getSgRating() {
		return this.sgRating;
	}

	public void setSgRating(BigDecimal sgRating) {
		this.sgRating = sgRating;
	}

	public BigDecimal getSgSccLevelOfEquipment() {
		return this.sgSccLevelOfEquipment;
	}

	public void setSgSccLevelOfEquipment(BigDecimal sgSccLevelOfEquipment) {
		this.sgSccLevelOfEquipment = sgSccLevelOfEquipment;
	}

	public String getSgSerialNo() {
		return this.sgSerialNo;
	}

	public void setSgSerialNo(String sgSerialNo) {
		this.sgSerialNo = sgSerialNo;
	}

	public String getSwitchCode() {
		return this.switchCode;
	}

	public void setSwitchCode(String switchCode) {
		this.switchCode = switchCode;
	}

	public String getSwitchName() {
		return this.switchName;
	}

	public void setSwitchName(String switchName) {
		this.switchName = switchName;
	}

	public BigDecimal getSwitchType() {
		return this.switchType;
	}

	public void setSwitchType(BigDecimal switchType) {
		this.switchType = switchType;
	}
	
	private BigDecimal status;

	public BigDecimal getStatus() {
	return this.status;
	}

	public void setStatus(BigDecimal status) {
	this.status = status;
	}

	
	



}