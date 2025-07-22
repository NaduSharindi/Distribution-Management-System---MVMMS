package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MMS_ADDLVLINE database table.
 * 
 */
@Entity
@Table(name="MMS_ADDLVLINE")
@NamedQuery(name="MmsAddlvline.findAll", query="SELECT m FROM MmsAddlvline m")
public class MmsAddlvline implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="APPROVED_BY")
	private String approvedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="APPROVED_DATE")
	private Date approvedDate;

	@Column(name="APPROVED_TIME")
	private String approvedTime;

	private String area;

	@Column(name="CIRCUIT_TYPE")
	private BigDecimal circuitType;

	private String code;

	@Temporal(TemporalType.DATE)
	private Date comdate;

	@Column(name="CONDUCTOR_TYPE")
	private double conductorType;

	private String csc;

	@Column(name="ENT_BY")
	private String entBy;

	@Temporal(TemporalType.DATE)
	@Column(name="ENT_DATE")
	private Date entDate;

	@Column(name="ENT_TIME")
	private String entTime;

	@Column(name="FEEDER_IDENTIFICATION")
	private String feederIdentification;

	private String feeder2;

	@Column(name="\"LENGTH\"")
	private BigDecimal length;

	@Column(name="LINE_NAME")
	private String lineName;

	@Column(name="LINE_TYPE")
	private String lineType;

	private String name;

	private BigDecimal noofpoles;

	private BigDecimal nooftowers;

	@Column(name="PHM_BRANCH")
	private String phmBranch;

	@Column(name="SIN_NO")
	private String sinNo;

	private BigDecimal status;

	@Column(name="\"TYPE\"")
	private BigDecimal type;

	@Column(name="VALIDATE_BY")
	private String validateBy;

	@Temporal(TemporalType.DATE)
	@Column(name="VALIDATE_DATE")
	private Date validateDate;

	@Column(name="VALIDATE_TIME")
	private String validateTime;

	public MmsAddlvline() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	public BigDecimal getCircuitType() {
		return this.circuitType;
	}

	public void setCircuitType(BigDecimal circuitType) {
		this.circuitType = circuitType;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getComdate() {
		return this.comdate;
	}

	public void setComdate(Date comdate) {
		this.comdate = comdate;
	}

	public double getConductorType() {
		return this.conductorType;
	}

	public void setConductorType(double conductorType) {
		this.conductorType = conductorType;
	}

	public String getCsc() {
		return this.csc;
	}

	public void setCsc(String csc) {
		this.csc = csc;
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

	public String getFeederIdentification() {
		return this.feederIdentification;
	}

	public void setFeederIdentification(String feederIdentification) {
		this.feederIdentification = feederIdentification;
	}

	public String getFeeder2() {
		return this.feeder2;
	}

	public void setFeeder2(String feeder2) {
		this.feeder2 = feeder2;
	}

	public BigDecimal getLength() {
		return this.length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public String getLineName() {
		return this.lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getLineType() {
		return this.lineType;
	}

	public void setLineType(String lineType) {
		this.lineType = lineType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getNoofpoles() {
		return this.noofpoles;
	}

	public void setNoofpoles(BigDecimal noofpoles) {
		this.noofpoles = noofpoles;
	}

	public BigDecimal getNooftowers() {
		return this.nooftowers;
	}

	public void setNooftowers(BigDecimal nooftowers) {
		this.nooftowers = nooftowers;
	}

	public String getPhmBranch() {
		return this.phmBranch;
	}

	public void setPhmBranch(String phmBranch) {
		this.phmBranch = phmBranch;
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

	public BigDecimal getType() {
		return this.type;
	}

	public void setType(BigDecimal type) {
		this.type = type;
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

}