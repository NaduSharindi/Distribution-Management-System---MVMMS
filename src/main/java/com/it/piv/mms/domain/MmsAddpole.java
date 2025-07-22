package com.it.piv.mms.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the MMS_ADDPOLE database table.
 * 
 */
@Entity
@Table(name="MMS_ADDPOLE")
@NamedQuery(name="MmsAddpole.findAll", query="SELECT m FROM MmsAddpole m")

public class MmsAddpole implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqGen")
	@SequenceGenerator(name = "SeqGen", sequenceName = "POLE_SEQ", allocationSize = 1)
	private long id;

	@Column(name="APPROVAL_LEVEL")
	private String approvalLevel;

	private String area;

	@Column(name="CONDUCTOR_TYPE")
	private BigDecimal conductorType;

	private String csc;

	@Column(name="DPET_ID")
	private String dpetId;

	@Column(name="FEEDER_IDENTIFICATION")
	private String feederIdentification;

	private String filepath;

	@Column(name="GPS_LATITUDE")
	private BigDecimal gpsLatitude;

	@Column(name="GPS_LONGITUDE")
	private BigDecimal gpsLongitude;

	@Lob
	private byte[] image;

	@Column(name="LINE_FEERDER_ID")
	private BigDecimal lineFeerderId;

	@Column(name="MAP_ID")
	private BigDecimal mapId;

	@Column(name="NO_OF_CONSUMERS_1PH")
	private BigDecimal noOfConsumers1ph;
	
	@Column(name="NO_OF_CONSUMERS_3PH")
	private BigDecimal noOfConsumers3ph;


	public BigDecimal getNoOfConsumers3ph() {
		return noOfConsumers3ph;
	}

	public void setNoOfConsumers3ph(BigDecimal noOfConsumers3ph) {
		this.noOfConsumers3ph = noOfConsumers3ph;
	}

	@Column(name="NO_OF_STAY")
	private BigDecimal noOfStay;

	@Column(name="NO_OF_STRUTS")
	private BigDecimal noOfStruts;

	@Column(name="POLE_NAME")
	private String poleName;

	@Column(name="POLE_NO")
	private String poleNo;

	@Column(name="POLE_TYPE")
	private BigDecimal poleType;

	private BigDecimal status;

	@Column(name="TRANSFORMER_ID")
	private String transformerId;

	public MmsAddpole() {
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

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public BigDecimal getConductorType() {
		return this.conductorType;
	}

	public void setConductorType(BigDecimal conductorType) {
		this.conductorType = conductorType;
	}

	public String getCsc() {
		return this.csc;
	}

	public void setCsc(String csc) {
		this.csc = csc;
	}

	public String getDpetId() {
		return this.dpetId;
	}

	public void setDpetId(String dpetId) {
		this.dpetId = dpetId;
	}

	public String getFeederIdentification() {
		return this.feederIdentification;
	}

	public void setFeederIdentification(String feederIdentification) {
		this.feederIdentification = feederIdentification;
	}

	public String getFilepath() {
		return this.filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
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

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public BigDecimal getLineFeerderId() {
		return this.lineFeerderId;
	}

	public void setLineFeerderId(BigDecimal lineFeerderId) {
		this.lineFeerderId = lineFeerderId;
	}

	public BigDecimal getMapId() {
		return this.mapId;
	}

	public void setMapId(BigDecimal mapId) {
		this.mapId = mapId;
	}

//	public BigDecimal getNoOfConsumers() {
//		return this.noOfConsumers1ph;
//	}

	public BigDecimal getNoOfConsumers1ph() {
		return noOfConsumers1ph;
	}

	public void setNoOfConsumers1ph(BigDecimal noOfConsumers1ph) {
		this.noOfConsumers1ph = noOfConsumers1ph;
	}

	/*public void setNoOfConsumers(BigDecimal noOfConsumers) {
		this.noOfConsumers1ph = noOfConsumers;
	}*/

	public BigDecimal getNoOfStay() {
		return this.noOfStay;
	}

	public void setNoOfStay(BigDecimal noOfStay) {
		this.noOfStay = noOfStay;
	}

	public BigDecimal getNoOfStruts() {
		return this.noOfStruts;
	}

	public void setNoOfStruts(BigDecimal noOfStruts) {
		this.noOfStruts = noOfStruts;
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

	public String getTransformerId() {
		return this.transformerId;
	}

	public void setTransformerId(String transformerId) {
		this.transformerId = transformerId;
	}

}
