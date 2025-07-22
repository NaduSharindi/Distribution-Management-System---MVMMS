package com.it.piv.mms.domain;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * The persistent class for the APPROVAL_MMS database table.
 * 
 */
@Entity
@Table(name="APPROVAL_MMS")
@NamedQuery(name="ApprovalMm.findAll", query="SELECT a FROM ApprovalMm a")
public class ApprovalMm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="APPROVAL_ID")
	private String approvalId;
	
	@Column(name="FILENAME_1")
	private String filename1;
	
	@Column(name="INT_CYCLE")
	private String intCycle;
	
	
	public String getIntCycle() {
		return intCycle;
	}

	public void setIntCycle(String intCycle) {
		this.intCycle = intCycle;
	}

	private String remarks;
	
	private String announcement;

	/*private Map<String, String> cscList = new LinkedHashMap<String, String>();
	
	public Map<String, String> getCscList() {
		return cscList;
	}

	public void setCscList(Map<String, String> cscList) {
		this.cscList = cscList;
	}
*/
	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getFilename1() {
		return filename1;
	}

	public void setFilename1(String filename1) {
		this.filename1 = filename1;
	}

	@Column(name="FILENAME_2")
	private String filename2;

	public String getFilename2() {
		return filename2;
	}

	public void setFilename2(String filename2) {
		this.filename2 = filename2;
	}

	@Column(name="FILENAME_3")
	private String filename3;

	public String getFilename3() {
		return filename3;
	}

	public void setFilename3(String filename3) {
		this.filename3 = filename3;
	}

	@Column(name="FILENAME_4")
	private String filename4;

	public String getFilename4() {
		return filename4;
	}

	public void setFilename4(String filename4) {
		this.filename4 = filename4;
	}

	@Column(name="FILENAME_5")
	private String filename5;
	
	@Column(name="\"TYPE\"")
	private String type;


	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFilename5() {
		return filename5;
	}

	public void setFilename5(String filename5) {
		this.filename5 = filename5;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="FORWARD_DATE")
	private Date forwardDate;

	public Date getForwardDate() {
		return forwardDate;
	}

	public void setForwardDate(Date forwardDate) {
		this.forwardDate = forwardDate;
	}

	@Column(name="FORWARDED_TIME")
	private String forwardedTime;

public String getForwardedTime() {
		return forwardedTime;
	}

	public void setForwardedTime(String forwardedTime) {
		this.forwardedTime = forwardedTime;
	}

	
	
	
@Override
	public String toString() {
		return "ApprovalMm [approvalId=" + approvalId + ", forwardDate="
				+ forwardDate + ", forwardedTime=" + forwardedTime
				+ ", actionDate=" + actionDate + ", actionTime=" + actionTime
				+ ", approvalType=" + approvalType + ", approvedBy="
				+ approvedBy + ", approvedDate=" + approvedDate
				+ ", approvedLevel=" + approvedLevel + ", approvedTime="
				+ approvedTime + ", areaCode=" + areaCode + ", deptId="
				+ deptId + ", detailedCost=" + detailedCost + ", esName="
				+ esName + ", fromStatus=" + fromStatus + ", fromto=" + fromto
				+ ", phmBranch=" + phmBranch + ", reason=" + reason
				+ ", referenceNo=" + referenceNo + ", req1=" + req1 + ", req2="
				+ req2 + ", standardCost=" + standardCost + ", systemBy="
				+ systemBy + ", timeduration=" + timeduration + ", toStatus="
				+ toStatus + ", rescheduleDate=" + rescheduleDate
				+ ", inchargeEs=" + inchargeEs + ", totower=" + totower
				+ ", fromtower=" + fromtower + ", totime=" + totime + ", es="
				+ es + ", ee=" + ee + ", totowerId=" + totowerId
				+ ", totowerMapid=" + totowerMapid + ", fromtowerId="
				+ fromtowerId + ", fromtowerMapid=" + fromtowerMapid
				+ ", lineid=" + lineid + ", fromtime=" + fromtime
				+ ", workingDate=" + workingDate + ", permitNo=" + permitNo
				+ "]";
	}

@Temporal(TemporalType.DATE)
	@Column(name="ACTION_DATE")
	private Date actionDate;

	public Date getActionDate() {
	return actionDate;
}

public void setActionDate(Date actionDate) {
	this.actionDate = actionDate;
}

	@Column(name="ACTION_TIME")
	private String actionTime;


	public String getActionTime() {
		return actionTime;
	}

	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}

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

	@Column(name="DEPT_ID")
	private String deptId;

	@Column(name="DETAILED_COST")
	private BigDecimal detailedCost;

	@Column(name="ES_NAME")
	private String esName;

	@Column(name="FROM_STATUS")
	private String fromStatus;

	private String fromto;

	@Column(name="PHM_BRANCH")
	private String phmBranch;

	private String reason;

	@Column(name="REFERENCE_NO")
	private String referenceNo;

	private String req1;

	private String req2;

	@Column(name="STANDARD_COST")
	private BigDecimal standardCost;

	@Column(name="SYSTEM_BY")
	private String systemBy;

	private String timeduration;

	@Column(name="TO_STATUS")
	private String toStatus;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="RESCHEDULE_DATE")
	@DateTimeFormat(pattern="YYYY-MM-DD")
    private Date rescheduleDate;
	
	@Column(name="INCHARGE_ES")
	private String inchargeEs;
	
	@Column(name="ALT_SUP_ARRANGEMENT")
	private String altSupArrangement;

	
	public String getAltSupArrangement() {
		return altSupArrangement;
	}

	public void setAltSupArrangement(String altSupArrangement) {
		this.altSupArrangement = altSupArrangement;
	}

	private String totower;
	
	private String fromtower;
	
	private String totime;
	
	private String es;
	
	private String ee;
	
	
	@Column(name="TOTOWER_ID")
	private BigDecimal totowerId;

	public BigDecimal getTotowerId() {
		return totowerId;
	}

	public void setTotowerId(BigDecimal totowerId) {
		this.totowerId = totowerId;
	}

	@Column(name="TOTOWER_MAPID")
	private BigDecimal totowerMapid;

	public BigDecimal getTotowerMapid() {
		return totowerMapid;
	}

	public void setTotowerMapid(BigDecimal totowerMapid) {
		this.totowerMapid = totowerMapid;
	}

	@Column(name="FROMTOWER_ID")
	private BigDecimal fromtowerId;

	public BigDecimal getFromtowerId() {
		return fromtowerId;
	}

	public void setFromtowerId(BigDecimal fromtowerId) {
		this.fromtowerId = fromtowerId;
	}

	@Column(name="FROMTOWER_MAPID")
	private BigDecimal fromtowerMapid;

	
	
	public BigDecimal getFromtowerMapid() {
		return fromtowerMapid;
	}

	public void setFromtowerMapid(BigDecimal fromtowerMapid) {
		this.fromtowerMapid = fromtowerMapid;
	}

	public String getEe() {
		return ee;
	}

	public void setEe(String ee) {
		this.ee = ee;
	}

	public String getEs() {
		return es;
	}

	public void setEs(String es) {
		this.es = es;
	}

	public String getTotime() {
		return totime;
	}

	public void setTotime(String totime) {
		this.totime = totime;
	}
	
	private long lineid;

	public long getLineid() {
		return lineid;
	}

	public void setLineid(long lineid) {
		this.lineid = lineid;
	}

	private String fromtime;
	

	public String getFromtime() {
		return fromtime;
	}

	public void setFromtime(String fromtime) {
		this.fromtime = fromtime;
	}

	public String getFromtower() {
		return fromtower;
	}

	public void setFromtower(String fromtower) {
		this.fromtower = fromtower;
	}

	public String getTotower() {
		return totower;
	}

	public void setTotower(String totower) {
		this.totower = totower;
	}

	@Column(name="WORKING_DATE")
	//@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern="YYYY-MM-DD")
    private String workingDate;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="YYYY-MM-DD")
	private Date workingdatenew;
	
	@Column(name="CC_APPROVAL_USER")
	private String ccApprovalUser;

	public String getCcApprovalUser() {
		return ccApprovalUser;
	}

	public void setCcApprovalUser(String ccApprovalUser) {
		this.ccApprovalUser = ccApprovalUser;
	}

	private String csc;

	public String getCsc() {
		return csc;
	}

	public void setCsc(String csc) {
		this.csc = csc;
	}

	private String grid;




	public String getGrid() {
		return grid;
	}

	public void setGrid(String grid) {
		this.grid = grid;
	}

	public Date getWorkingdatenew() {
		return workingdatenew;
	}

	public void setWorkingdatenew(Date workingdatenew) {
		this.workingdatenew = workingdatenew;
	}

	public String getWorkingDate() {
		return workingDate;
	}

	public void setWorkingDate(String workingDate) {
		this.workingDate = workingDate;
	}

	public String getInchargeEs() {
		return inchargeEs;
	}

	public void setInchargeEs(String inchargeEs) {
		this.inchargeEs = inchargeEs;
	}

	@Column(name="PERMIT_NO")
	private String permitNo;




	public String getPermitNo() {
		return permitNo;
	}

	public void setPermitNo(String permitNo) {
		this.permitNo = permitNo;
	}

	public Date getRescheduleDate() {
		return rescheduleDate;
	}

	public void setRescheduleDate(Date rescheduleDate) {
		this.rescheduleDate = rescheduleDate;
	}

	public ApprovalMm() {
	}

	public String getApprovalId() {
		return this.approvalId;
	}

	public void setApprovalId(String approvalId) {
		this.approvalId = approvalId;
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

	public String getEsName() {
		return this.esName;
	}

	public void setEsName(String esName) {
		this.esName = esName;
	}

	public String getFromStatus() {
		return this.fromStatus;
	}

	public void setFromStatus(String fromStatus) {
		this.fromStatus = fromStatus;
	}

	public String getFromto() {
		return this.fromto;
	}

	public void setFromto(String fromto) {
		this.fromto = fromto;
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

}