package com.it.piv.myceb.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the JOB_ASSIGN database table.
 * 
 */
@Entity
@Table(name="JOB_ASSIGN")
@NamedQuery(name="JobAssign.findAll", query="SELECT j FROM JobAssign j")
public class JobAssign implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	/*@SequenceGenerator(name="JOB_ASSIGN_ID_GENERATOR", sequenceName="CUSTOMER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JOB_ASSIGN_ID_GENERATOR")
	*/private long id;

	@Column(name="AREA_CODE")
	private String areaCode;

	@Column(name="ASSIGNED_BY")
	private String assignedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="ASSIGNED_DATE")
	private Date assignedDate;

	@Column(name="ASSIGNED_TIME")
	private String assignedTime;

	@Column(name="ASSIGNED_TO")
	private String assignedTo;

	private String bdid;

	@Column(name="CC_CODE")
	private String ccCode;

	@Column(name="COMMENT_A")
	private String commentA;

	@Temporal(TemporalType.DATE)
	@Column(name="COMP_DATE")
	private Date compDate;

	@Column(name="COMP_STATUS")
	private String compStatus;

	private String complaintid;

	private String contactnum;

	@Column(name="CUS_ADDRESS")
	private String cusAddress;

	@Column(name="DEPOT_CODE")
	private String depotCode;

	@Column(name="JOB_NO")
	private String jobNo;

	@Column(name="JOB_ORIGIN")
	private String jobOrigin;

	@Column(name="JOB_TYPE")
	private String jobType;

	private String latitute;

	private String longitute;

	@Column(name="NOW_ATTEND")
	private String nowAttend;

	@Column(name="PRINT_STATUS")
	private String printStatus;

	@Column(name="PRIORITY_CODE")
	private String priorityCode;

	@Column(name="PROV_CODE")
	private String provCode;

	@Column(name="TO_DO_CODE")
	private String toDoCode;

	@Column(name="TRANS_TO_WHOM")
	private String transToWhom;

	@Column(name="UNIT_CODE")
	private String unitCode;

	@Column(name="UNIT_NAME")
	private String unitName;

	@Column(name="USER_LOG")
	private String userLog;

	public JobAssign() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAssignedBy() {
		return this.assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	public Date getAssignedDate() {
		return this.assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public String getAssignedTime() {
		return this.assignedTime;
	}

	public void setAssignedTime(String assignedTime) {
		this.assignedTime = assignedTime;
	}

	public String getAssignedTo() {
		return this.assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getBdid() {
		return this.bdid;
	}

	public void setBdid(String bdid) {
		this.bdid = bdid;
	}

	public String getCcCode() {
		return this.ccCode;
	}

	public void setCcCode(String ccCode) {
		this.ccCode = ccCode;
	}

	public String getCommentA() {
		return this.commentA;
	}

	public void setCommentA(String commentA) {
		this.commentA = commentA;
	}

	public Date getCompDate() {
		return this.compDate;
	}

	public void setCompDate(Date compDate) {
		this.compDate = compDate;
	}

	public String getCompStatus() {
		return this.compStatus;
	}

	public void setCompStatus(String compStatus) {
		this.compStatus = compStatus;
	}

	public String getComplaintid() {
		return this.complaintid;
	}

	public void setComplaintid(String complaintid) {
		this.complaintid = complaintid;
	}

	public String getContactnum() {
		return this.contactnum;
	}

	public void setContactnum(String contactnum) {
		this.contactnum = contactnum;
	}

	public String getCusAddress() {
		return this.cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	public String getDepotCode() {
		return this.depotCode;
	}

	public void setDepotCode(String depotCode) {
		this.depotCode = depotCode;
	}

	public String getJobNo() {
		return this.jobNo;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public String getJobOrigin() {
		return this.jobOrigin;
	}

	public void setJobOrigin(String jobOrigin) {
		this.jobOrigin = jobOrigin;
	}

	public String getJobType() {
		return this.jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getLatitute() {
		return this.latitute;
	}

	public void setLatitute(String latitute) {
		this.latitute = latitute;
	}

	public String getLongitute() {
		return this.longitute;
	}

	public void setLongitute(String longitute) {
		this.longitute = longitute;
	}

	public String getNowAttend() {
		return this.nowAttend;
	}

	public void setNowAttend(String nowAttend) {
		this.nowAttend = nowAttend;
	}

	public String getPrintStatus() {
		return this.printStatus;
	}

	public void setPrintStatus(String printStatus) {
		this.printStatus = printStatus;
	}

	public String getPriorityCode() {
		return this.priorityCode;
	}

	public void setPriorityCode(String priorityCode) {
		this.priorityCode = priorityCode;
	}

	public String getProvCode() {
		return this.provCode;
	}

	public void setProvCode(String provCode) {
		this.provCode = provCode;
	}

	public String getToDoCode() {
		return this.toDoCode;
	}

	public void setToDoCode(String toDoCode) {
		this.toDoCode = toDoCode;
	}

	public String getTransToWhom() {
		return this.transToWhom;
	}

	public void setTransToWhom(String transToWhom) {
		this.transToWhom = transToWhom;
	}

	public String getUnitCode() {
		return this.unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUserLog() {
		return this.userLog;
	}

	public void setUserLog(String userLog) {
		this.userLog = userLog;
	}

}