package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the "MMS_LineCompletion" database table.
 * 
 */
@Entity
@Table(name="\"MMS_LineCompletion\"")
@NamedQuery(name="MMS_LineCompletion.findAll", query="SELECT m FROM MMS_LineCompletion m")
public class MMS_LineCompletion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MMS_LineCompletionPK id;

	@Column(name="APPROVED_BY")
	private String approvedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="APPROVED_DATE")
	private Date approvedDate;

	@Column(name="APPROVED_TIME")
	private String approvedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="COMPLETED_DATE")
	private Date completedDate;

	@Column(name="COMPLETED_TIME")
	private String completedTime;

	private String remarks;

	private BigDecimal status;

	@Column(name="VALIDATE_BY")
	private String validateBy;

	@Temporal(TemporalType.DATE)
	@Column(name="VALIDATE_DATE")
	private Date validateDate;

	@Column(name="VALIDATE_TIME")
	private String validateTime;

	public MMS_LineCompletion() {
	}

	public MMS_LineCompletionPK getId() {
		return this.id;
	}

	public void setId(MMS_LineCompletionPK id) {
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

	public Date getCompletedDate() {
		return this.completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public String getCompletedTime() {
		return this.completedTime;
	}

	public void setCompletedTime(String completedTime) {
		this.completedTime = completedTime;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
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