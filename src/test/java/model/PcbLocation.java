package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PCB_LOCATION database table.
 * 
 */
@Entity
@Table(name="PCB_LOCATION")
@NamedQuery(name="PcbLocation.findAll", query="SELECT p FROM PcbLocation p")
public class PcbLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EQUIPMENT_ID")
	private String equipmentId;

	@Column(name="ACCOUNT_NUMBER")
	private String accountNumber;

	@Column(name="CONTRACT_DEMAND")
	private String contractDemand;

	@Column(name="CUS_ADDRESS")
	private String cusAddress;

	@Column(name="CUS_AREA")
	private String cusArea;

	@Column(name="CUS_CSC")
	private String cusCsc;

	@Column(name="CUS_LOCATION")
	private String cusLocation;

	@Column(name="CUS_NAME")
	private String cusName;

	@Column(name="CUS_SIN_NUMBER")
	private String cusSinNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="ENTERED_DATE")
	private Date enteredDate;

	@Column(name="GPS_LATITUDE")
	private BigDecimal gpsLatitude;

	@Column(name="GPS_LONGITUDE")
	private BigDecimal gpsLongitude;

	@Column(name="LOCATION_DESCRIPTION")
	private String locationDescription;

	private String mounting;

	private String tariff;

	@Column(name="TYPE_OF_LOCATED")
	private String typeOfLocated;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	public PcbLocation() {
	}

	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getContractDemand() {
		return this.contractDemand;
	}

	public void setContractDemand(String contractDemand) {
		this.contractDemand = contractDemand;
	}

	public String getCusAddress() {
		return this.cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	public String getCusArea() {
		return this.cusArea;
	}

	public void setCusArea(String cusArea) {
		this.cusArea = cusArea;
	}

	public String getCusCsc() {
		return this.cusCsc;
	}

	public void setCusCsc(String cusCsc) {
		this.cusCsc = cusCsc;
	}

	public String getCusLocation() {
		return this.cusLocation;
	}

	public void setCusLocation(String cusLocation) {
		this.cusLocation = cusLocation;
	}

	public String getCusName() {
		return this.cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusSinNumber() {
		return this.cusSinNumber;
	}

	public void setCusSinNumber(String cusSinNumber) {
		this.cusSinNumber = cusSinNumber;
	}

	public Date getEnteredDate() {
		return this.enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
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

	public String getLocationDescription() {
		return this.locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public String getMounting() {
		return this.mounting;
	}

	public void setMounting(String mounting) {
		this.mounting = mounting;
	}

	public String getTariff() {
		return this.tariff;
	}

	public void setTariff(String tariff) {
		this.tariff = tariff;
	}

	public String getTypeOfLocated() {
		return this.typeOfLocated;
	}

	public void setTypeOfLocated(String typeOfLocated) {
		this.typeOfLocated = typeOfLocated;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}