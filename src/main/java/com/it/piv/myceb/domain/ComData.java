package com.it.piv.myceb.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the COM_DATA database table.
 * 
 */
@Entity
@Table(name="COM_DATA")
@NamedQuery(name="ComData.findAll", query="SELECT c FROM ComData c")
public class ComData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COMPLAINT_NO")
	private String complaintNo;

	@Column(name="ACCT_NUM")
	private String acctNum;

	private String address;

	@Column(name="AREA_CODE")
	private String areaCode;

	@Temporal(TemporalType.DATE)
	@Column(name="BD_DATE")
	private Date bdDate;

	@Temporal(TemporalType.DATE)
	@Column(name="BD_TIME")
	private Date bdTime;

	private String comments;

	@Column(name="DATE_TIME")
	private String dateTime;

	@Column(name="ID_NUMBER")
	private String idNumber;

	private String latitude;

	private String longitute;

	private String status;

	public ComData() {
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Date getBdTime() {
		return this.bdTime;
	}

	public void setBdTime(Date bdTime) {
		this.bdTime = bdTime;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitute() {
		return this.longitute;
	}

	public void setLongitute(String longitute) {
		this.longitute = longitute;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}