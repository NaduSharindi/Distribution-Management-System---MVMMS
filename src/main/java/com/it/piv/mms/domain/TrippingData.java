package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TRIPPING_DATA database table.
 * 
 */
@Entity
@Table(name="TRIPPING_DATA")
@NamedQuery(name="TrippingData.findAll", query="SELECT t FROM TrippingData t")
public class TrippingData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqGen")
	@SequenceGenerator(name = "SeqGen", sequenceName = "TRIPPING_INSTALL_SEQ", allocationSize = 1)	@Column(name="TRIPPING_ID")
	private long trippingId;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTION_DATE")
	private Date actionDate;

	@Column(name="ACTION_TIME")
	private String actionTime;

	@Column(name="APPROVAL_TYPE")
	private String approvalType;

	@Column(name="APPROVED_BY")
	private String approvedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="APPROVED_DATE")
	private Date approvedDate;

	@Column(name="APPROVED_LEVEL")
	private String approvedLevel;

	@Column(name="APPROVED_TIME")
	private String approvedTime;

	@Column(name="AREA_CODE")
	private String areaCode;

	@Column(name="AREA_EFFECTED")
	private String areaEffected;

	@Column(name="DEPT_ID")
	private String deptId;

	@Column(name="DETAILED_COST")
	private BigDecimal detailedCost;

	private String duration;

	private String ee;

	private String es;

	@Column(name="ES_NAME")
	private String esName;

	private String feeder;

	@Temporal(TemporalType.DATE)
	@Column(name="FORWARD_DATE")
	private Date forwardDate;

	@Column(name="FORWARDED_TIME")
	private String forwardedTime;

	@Column(name="FROM_STATUS")
	private String fromStatus;

	private String fromtime;

	private String fromto;

	private String fromtower;

	@Column(name="FROMTOWER_ID")
	private BigDecimal fromtowerId;

	@Column(name="FROMTOWER_MAPID")
	private BigDecimal fromtowerMapid;

	@Column(name="GSS_NAME")
	private String gssName;

	@Column(name="INCHARGE_ES")
	private String inchargeEs;

	@Column(name="LINE_ID")
	private BigDecimal lineId;

	private String lineid;

	@Column(name="\"LOAD\"")
	private BigDecimal load;

	@Column(name="NO_OF_CONSUMER")
	private BigDecimal noOfConsumer;

	@Column(name="PERMIT_NO")
	private String permitNo;

	@Column(name="PHM_BRANCH")
	private String phmBranch;

	private String reason;

	@Column(name="REFERENCE_NO")
	private String referenceNo;

	private String remarks;

	private String req1;

	private String req2;

	@Column(name="REQUEST_TYPE")
	private String requestType;

	@Temporal(TemporalType.DATE)
	@Column(name="RESCHEDULE_DATE")
	private Date rescheduleDate;

	@Column(name="STANDARD_COST")
	private BigDecimal standardCost;

	@Column(name="SYSTEM_BY")
	private String systemBy;

	private String timeduration;

	@Column(name="TO_STATUS")
	private String toStatus;

	private String totime;

	private String totower;

	@Column(name="TOTOWER_ID")
	private BigDecimal totowerId;

	@Column(name="TOTOWER_MAPID")
	private BigDecimal totowerMapid;

	@Temporal(TemporalType.DATE)
	@Column(name="TRIPPING_DATE")
	private Date trippingDate;

	@Column(name="TRIPPING_TYPE")
	private String trippingType;

	@Column(name="WORKING_DATE")
	private String workingDate;

	public TrippingData() {
	}

	public long getTrippingId() {
		return this.trippingId;
	}

	public void setTrippingId(long trippingId) {
		this.trippingId = trippingId;
	}

	public Date getActionDate() {
		return this.actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public String getActionTime() {
		return this.actionTime;
	}

	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}

	public String getApprovalType() {
		return this.approvalType;
	}

	public void setApprovalType(String approvalType) {
		this.approvalType = approvalType;
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

	public String getApprovedLevel() {
		return this.approvedLevel;
	}

	public void setApprovedLevel(String approvedLevel) {
		this.approvedLevel = approvedLevel;
	}

	public String getApprovedTime() {
		return this.approvedTime;
	}

	public void setApprovedTime(String approvedTime) {
		this.approvedTime = approvedTime;
	}

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaEffected() {
		return this.areaEffected;
	}

	public void setAreaEffected(String areaEffected) {
		this.areaEffected = areaEffected;
	}

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public BigDecimal getDetailedCost() {
		return this.detailedCost;
	}

	public void setDetailedCost(BigDecimal detailedCost) {
		this.detailedCost = detailedCost;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getEe() {
		return this.ee;
	}

	public void setEe(String ee) {
		this.ee = ee;
	}

	public String getEs() {
		return this.es;
	}

	public void setEs(String es) {
		this.es = es;
	}

	public String getEsName() {
		return this.esName;
	}

	public void setEsName(String esName) {
		this.esName = esName;
	}

	public String getFeeder() {
		return this.feeder;
	}

	public void setFeeder(String feeder) {
		this.feeder = feeder;
	}

	public Date getForwardDate() {
		return this.forwardDate;
	}

	public void setForwardDate(Date forwardDate) {
		this.forwardDate = forwardDate;
	}

	public String getForwardedTime() {
		return this.forwardedTime;
	}

	public void setForwardedTime(String forwardedTime) {
		this.forwardedTime = forwardedTime;
	}

	public String getFromStatus() {
		return this.fromStatus;
	}

	public void setFromStatus(String fromStatus) {
		this.fromStatus = fromStatus;
	}

	public String getFromtime() {
		return this.fromtime;
	}

	public void setFromtime(String fromtime) {
		this.fromtime = fromtime;
	}

	public String getFromto() {
		return this.fromto;
	}

	public void setFromto(String fromto) {
		this.fromto = fromto;
	}

	public String getFromtower() {
		return this.fromtower;
	}

	public void setFromtower(String fromtower) {
		this.fromtower = fromtower;
	}

	public BigDecimal getFromtowerId() {
		return this.fromtowerId;
	}

	public void setFromtowerId(BigDecimal fromtowerId) {
		this.fromtowerId = fromtowerId;
	}

	public BigDecimal getFromtowerMapid() {
		return this.fromtowerMapid;
	}

	public void setFromtowerMapid(BigDecimal fromtowerMapid) {
		this.fromtowerMapid = fromtowerMapid;
	}

	public String getGssName() {
		return this.gssName;
	}

	public void setGssName(String gssName) {
		this.gssName = gssName;
	}

	public String getInchargeEs() {
		return this.inchargeEs;
	}

	public void setInchargeEs(String inchargeEs) {
		this.inchargeEs = inchargeEs;
	}

	public BigDecimal getLineId() {
		return this.lineId;
	}

	public void setLineId(BigDecimal lineId) {
		this.lineId = lineId;
	}

	public String getLineid() {
		return this.lineid;
	}

	public void setLineid(String lineid) {
		this.lineid = lineid;
	}

	public BigDecimal getLoad() {
		return this.load;
	}

	public void setLoad(BigDecimal load) {
		this.load = load;
	}

	public BigDecimal getNoOfConsumer() {
		return this.noOfConsumer;
	}

	public void setNoOfConsumer(BigDecimal noOfConsumer) {
		this.noOfConsumer = noOfConsumer;
	}

	public String getPermitNo() {
		return this.permitNo;
	}

	public void setPermitNo(String permitNo) {
		this.permitNo = permitNo;
	}

	public String getPhmBranch() {
		return this.phmBranch;
	}

	public void setPhmBranch(String phmBranch) {
		this.phmBranch = phmBranch;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReferenceNo() {
		return this.referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getReq1() {
		return this.req1;
	}

	public void setReq1(String req1) {
		this.req1 = req1;
	}

	public String getReq2() {
		return this.req2;
	}

	public void setReq2(String req2) {
		this.req2 = req2;
	}

	public String getRequestType() {
		return this.requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public Date getRescheduleDate() {
		return this.rescheduleDate;
	}

	public void setRescheduleDate(Date rescheduleDate) {
		this.rescheduleDate = rescheduleDate;
	}

	public BigDecimal getStandardCost() {
		return this.standardCost;
	}

	public void setStandardCost(BigDecimal standardCost) {
		this.standardCost = standardCost;
	}

	public String getSystemBy() {
		return this.systemBy;
	}

	public void setSystemBy(String systemBy) {
		this.systemBy = systemBy;
	}

	public String getTimeduration() {
		return this.timeduration;
	}

	public void setTimeduration(String timeduration) {
		this.timeduration = timeduration;
	}

	public String getToStatus() {
		return this.toStatus;
	}

	public void setToStatus(String toStatus) {
		this.toStatus = toStatus;
	}

	public String getTotime() {
		return this.totime;
	}

	public void setTotime(String totime) {
		this.totime = totime;
	}

	public String getTotower() {
		return this.totower;
	}

	public void setTotower(String totower) {
		this.totower = totower;
	}

	public BigDecimal getTotowerId() {
		return this.totowerId;
	}

	public void setTotowerId(BigDecimal totowerId) {
		this.totowerId = totowerId;
	}

	public BigDecimal getTotowerMapid() {
		return this.totowerMapid;
	}

	public void setTotowerMapid(BigDecimal totowerMapid) {
		this.totowerMapid = totowerMapid;
	}

	public Date getTrippingDate() {
		return this.trippingDate;
	}

	public void setTrippingDate(Date trippingDate) {
		this.trippingDate = trippingDate;
	}

	public String getTrippingType() {
		return this.trippingType;
	}

	public void setTrippingType(String trippingType) {
		this.trippingType = trippingType;
	}

	public String getWorkingDate() {
		return this.workingDate;
	}

	public void setWorkingDate(String workingDate) {
		this.workingDate = workingDate;
	}

}