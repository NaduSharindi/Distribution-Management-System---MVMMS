package com.it.piv.myceb.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the JOB_STATUS_OMS database table.
 * 
 */
@Entity
@Table(name="JOB_STATUS_OMS")
@NamedQuery(name="JobStatusOm.findAll", query="SELECT j FROM JobStatusOm j")
public class JobStatusOm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="JOB_STATUS_OMS_ID_GENERATOR", sequenceName="CUSTOMER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JOB_STATUS_OMS_ID_GENERATOR")
	private String id;

	@Column(name="ASSIGNED_TO_WHOM")
	private String assignedToWhom;

	@Column(name="COM_LOG_BY")
	private String comLogBy;

	@Column(name="COMMENT_DES")
	private String commentDes;

	@Temporal(TemporalType.DATE)
	@Column(name="OPERATION_DATE")
	private Date operationDate;

	@Column(name="OPERATION_TIME")
	private String operationTime;

	@Column(name="REFFERENCE_NO")
	private String refferenceNo;

	@Column(name="STATUS_FROM")
	private String statusFrom;

	@Column(name="STATUS_TO")
	private String statusTo;

	@Column(name="USER_LOG")
	private String userLog;

	public JobStatusOm() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAssignedToWhom() {
		return this.assignedToWhom;
	}

	public void setAssignedToWhom(String assignedToWhom) {
		this.assignedToWhom = assignedToWhom;
	}

	public String getComLogBy() {
		return this.comLogBy;
	}

	public void setComLogBy(String comLogBy) {
		this.comLogBy = comLogBy;
	}

	public String getCommentDes() {
		return this.commentDes;
	}

	public void setCommentDes(String commentDes) {
		this.commentDes = commentDes;
	}

	public Date getOperationDate() {
		return this.operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public String getOperationTime() {
		return this.operationTime;
	}

	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}

	public String getRefferenceNo() {
		return this.refferenceNo;
	}

	public void setRefferenceNo(String refferenceNo) {
		this.refferenceNo = refferenceNo;
	}

	public String getStatusFrom() {
		return this.statusFrom;
	}

	public void setStatusFrom(String statusFrom) {
		this.statusFrom = statusFrom;
	}

	public String getStatusTo() {
		return this.statusTo;
	}

	public void setStatusTo(String statusTo) {
		this.statusTo = statusTo;
	}

	public String getUserLog() {
		return this.userLog;
	}

	public void setUserLog(String userLog) {
		this.userLog = userLog;
	}

}