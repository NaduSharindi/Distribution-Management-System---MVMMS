package com.it.piv.myceb.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bd_details database table.
 * 
 */
@Entity
@Table(name="bd_details")
@NamedQuery(name="BdDetail.findAll", query="SELECT b FROM BdDetail b")
public class BdDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COMPLAINT_NO")
	private String complaintNo;

	@Column(name="ACCT_NUM")
	private String acctNum;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ACTUAL_DATE")
	private Date actualDate;

	@Column(name="ACTUAL_TIME")
	private String actualTime;

	private String address1;

	private String address2;

	private String address3;

	@Column(name="AREA_CODE")
	private String areaCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="BD_DATE")
	private Date bdDate;

	@Column(name="BD_TIME")
	private String bdTime;

	private String bdid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="BDID_DATE")
	private Date bdidDate;

	@Column(name="BDID_TIME")
	private String bdidTime;

	@Column(name="CALLER_NAME")
	private String callerName;

	@Column(name="CC_CODE")
	private String ccCode;

	private String comments;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="COMPLETED_DATE")
	private Date completedDate;

	@Column(name="COMPLETED_TIME")
	private String completedTime;

	@Column(name="CR_CC_CODE")
	private String crCcCode;

	@Column(name="CUS_ADDRESS")
	private String cusAddress;

	@Column(name="CUS_LOCATION")
	private String cusLocation;

	@Column(name="CUS_NAME")
	private String cusName;

	@Column(name="CUS_TELE_OTHER")
	private String cusTeleOther;

	@Column(name="CUS_TELEPHONE")
	private String cusTelephone;

	@Column(name="CUSTOMER_TYPE")
	private String customerType;

	private String depot;

	private String feeder;

	@Column(name="GRID_SUB")
	private String gridSub;

	@Column(name="ID_NUMBER")
	private String idNumber;

	@Column(name="NATURE_CODE")
	private String natureCode;

	private String pack;

	@Column(name="PREMISSES_ID")
	private String premissesId;

	@Column(name="PRIMARY_SUB")
	private String primarySub;

	@Column(name="PRIORITY_CODE")
	private String priorityCode;

	@Column(name="READER_CODE")
	private String readerCode;

	@Column(name="RECORDED_USER")
	private String recordedUser;

	@Column(name="REF_NO")
	private String refNo;

	private String status;

	@Column(name="SUB_NAME")
	private String subName;

	private String transformer;

	@Column(name="TYPE_COMP")
	private String typeComp;

	public BdDetail() {
	}

	public String getComplaintNo() {
		return this.complaintNo;
	}

	public void setComplaintNo(String complaintNo) {
		this.complaintNo = complaintNo;
	}

	public String getAcctNum() {
		return this.acctNum;
	}

	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

	public Date getActualDate() {
		return this.actualDate;
	}

	public void setActualDate(Date actualDate) {
		this.actualDate = actualDate;
	}

	public String getActualTime() {
		return this.actualTime;
	}

	public void setActualTime(String actualTime) {
		this.actualTime = actualTime;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public Date getBdDate() {
		return this.bdDate;
	}

	public void setBdDate(Date bdDate) {
		this.bdDate = bdDate;
	}

	public String getBdTime() {
		return this.bdTime;
	}

	public void setBdTime(String bdTime) {
		this.bdTime = bdTime;
	}

	public String getBdid() {
		return this.bdid;
	}

	public void setBdid(String bdid) {
		this.bdid = bdid;
	}

	public Date getBdidDate() {
		return this.bdidDate;
	}

	public void setBdidDate(Date bdidDate) {
		this.bdidDate = bdidDate;
	}

	public String getBdidTime() {
		return this.bdidTime;
	}

	public void setBdidTime(String bdidTime) {
		this.bdidTime = bdidTime;
	}

	public String getCallerName() {
		return this.callerName;
	}

	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}

	public String getCcCode() {
		return this.ccCode;
	}

	public void setCcCode(String ccCode) {
		this.ccCode = ccCode;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public String getCrCcCode() {
		return this.crCcCode;
	}

	public void setCrCcCode(String crCcCode) {
		this.crCcCode = crCcCode;
	}

	public String getCusAddress() {
		return this.cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
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

	public String getCusTeleOther() {
		return this.cusTeleOther;
	}

	public void setCusTeleOther(String cusTeleOther) {
		this.cusTeleOther = cusTeleOther;
	}

	public String getCusTelephone() {
		return this.cusTelephone;
	}

	public void setCusTelephone(String cusTelephone) {
		this.cusTelephone = cusTelephone;
	}

	public String getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getDepot() {
		return this.depot;
	}

	public void setDepot(String depot) {
		this.depot = depot;
	}

	public String getFeeder() {
		return this.feeder;
	}

	public void setFeeder(String feeder) {
		this.feeder = feeder;
	}

	public String getGridSub() {
		return this.gridSub;
	}

	public void setGridSub(String gridSub) {
		this.gridSub = gridSub;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getNatureCode() {
		return this.natureCode;
	}

	public void setNatureCode(String natureCode) {
		this.natureCode = natureCode;
	}

	public String getPack() {
		return this.pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public String getPremissesId() {
		return this.premissesId;
	}

	public void setPremissesId(String premissesId) {
		this.premissesId = premissesId;
	}

	public String getPrimarySub() {
		return this.primarySub;
	}

	public void setPrimarySub(String primarySub) {
		this.primarySub = primarySub;
	}

	public String getPriorityCode() {
		return this.priorityCode;
	}

	public void setPriorityCode(String priorityCode) {
		this.priorityCode = priorityCode;
	}

	public String getReaderCode() {
		return this.readerCode;
	}

	public void setReaderCode(String readerCode) {
		this.readerCode = readerCode;
	}

	public String getRecordedUser() {
		return this.recordedUser;
	}

	public void setRecordedUser(String recordedUser) {
		this.recordedUser = recordedUser;
	}

	public String getRefNo() {
		return this.refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubName() {
		return this.subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getTransformer() {
		return this.transformer;
	}

	public void setTransformer(String transformer) {
		this.transformer = transformer;
	}

	public String getTypeComp() {
		return this.typeComp;
	}

	public void setTypeComp(String typeComp) {
		this.typeComp = typeComp;
	}
	
	
	
	
	
	
	

}