package com.it.piv.issue.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.it.piv.mms.domain.SpstdestdmtPK;
import com.it.piv.mms.domain.SpstdesthmtPK;

public class SpstdesthmtModel {
	
	
	private String appNo;

	public String getAppNo() {
		return appNo;
	}

	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}

	private String stdNo;

	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	private String deptId;
	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	private String approvedBy;

	private Date approvedDate;

	private String assignedto;

	private BigDecimal balCapacity;

	private String cebcost;

	private String commentCe;

	private String commentDgm;

	private String commentEe;

	private String commentEs;

	private String commentPce;

	private String commentPe;

	private BigDecimal conCost;

	private String contingency;

	private String description;

	private String entryBy;

	private Date entryDate;

	private BigDecimal exCapacity;

	private String jobname;

	private BigDecimal lineLength;

	private String nbtcost;

	private BigDecimal nbtpercentage;

	private BigDecimal newCapacity;

	private String planingBy;

	private Date planingDate;

	private String postDeptid;

	private String projecttype;

	private String rebateCost;

	private String rejReasonEe;

	private String rejResonCe;

	private String rejResonPe;

	private String rejectedBy;

	private Date rejectedDate;

	private String secdeposit;

	private String sinno;

	private String sinno1;

	private String sinno2;

	private String sinno3;

	private String sinno4;

	private BigDecimal status;

	private String toconpay;

	private String totalCost;

	private String validateByCe;

	private String validateByEe;

	private Date validateDateCe;

	private Date validateDateEe;

	private String vat;

	private String vatcost;

	
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

	public String getAssignedto() {
		return this.assignedto;
	}

	public void setAssignedto(String assignedto) {
		this.assignedto = assignedto;
	}

	public BigDecimal getBalCapacity() {
		return this.balCapacity;
	}

	public void setBalCapacity(BigDecimal balCapacity) {
		this.balCapacity = balCapacity;
	}

	public String getCebcost() {
		return this.cebcost;
	}

	public void setCebcost(String cebcost) {
		this.cebcost = cebcost;
	}

	public String getCommentCe() {
		return this.commentCe;
	}

	public void setCommentCe(String commentCe) {
		this.commentCe = commentCe;
	}

	public String getCommentDgm() {
		return this.commentDgm;
	}

	public void setCommentDgm(String commentDgm) {
		this.commentDgm = commentDgm;
	}

	public String getCommentEe() {
		return this.commentEe;
	}

	public void setCommentEe(String commentEe) {
		this.commentEe = commentEe;
	}

	public String getCommentEs() {
		return this.commentEs;
	}

	public void setCommentEs(String commentEs) {
		this.commentEs = commentEs;
	}

	public String getCommentPce() {
		return this.commentPce;
	}

	public void setCommentPce(String commentPce) {
		this.commentPce = commentPce;
	}

	public String getCommentPe() {
		return this.commentPe;
	}

	public void setCommentPe(String commentPe) {
		this.commentPe = commentPe;
	}

	public BigDecimal getConCost() {
		return this.conCost;
	}

	public void setConCost(BigDecimal conCost) {
		this.conCost = conCost;
	}

	public String getContingency() {
		return this.contingency;
	}

	public void setContingency(String contingency) {
		this.contingency = contingency;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEntryBy() {
		return this.entryBy;
	}

	public void setEntryBy(String entryBy) {
		this.entryBy = entryBy;
	}

	public Date getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public BigDecimal getExCapacity() {
		return this.exCapacity;
	}

	public void setExCapacity(BigDecimal exCapacity) {
		this.exCapacity = exCapacity;
	}

	public String getJobname() {
		return this.jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public BigDecimal getLineLength() {
		return this.lineLength;
	}

	public void setLineLength(BigDecimal lineLength) {
		this.lineLength = lineLength;
	}

	public String getNbtcost() {
		return this.nbtcost;
	}

	public void setNbtcost(String nbtcost) {
		this.nbtcost = nbtcost;
	}

	public BigDecimal getNbtpercentage() {
		return this.nbtpercentage;
	}

	public void setNbtpercentage(BigDecimal nbtpercentage) {
		this.nbtpercentage = nbtpercentage;
	}

	public BigDecimal getNewCapacity() {
		return this.newCapacity;
	}

	public void setNewCapacity(BigDecimal newCapacity) {
		this.newCapacity = newCapacity;
	}

	public String getPlaningBy() {
		return this.planingBy;
	}

	public void setPlaningBy(String planingBy) {
		this.planingBy = planingBy;
	}

	public Date getPlaningDate() {
		return this.planingDate;
	}

	public void setPlaningDate(Date planingDate) {
		this.planingDate = planingDate;
	}

	public String getPostDeptid() {
		return this.postDeptid;
	}

	public void setPostDeptid(String postDeptid) {
		this.postDeptid = postDeptid;
	}

	public String getProjecttype() {
		return this.projecttype;
	}

	public void setProjecttype(String projecttype) {
		this.projecttype = projecttype;
	}

	public String getRebateCost() {
		return this.rebateCost;
	}

	public void setRebateCost(String rebateCost) {
		this.rebateCost = rebateCost;
	}

	public String getRejReasonEe() {
		return this.rejReasonEe;
	}

	public void setRejReasonEe(String rejReasonEe) {
		this.rejReasonEe = rejReasonEe;
	}

	public String getRejResonCe() {
		return this.rejResonCe;
	}

	public void setRejResonCe(String rejResonCe) {
		this.rejResonCe = rejResonCe;
	}

	public String getRejResonPe() {
		return this.rejResonPe;
	}

	public void setRejResonPe(String rejResonPe) {
		this.rejResonPe = rejResonPe;
	}

	public String getRejectedBy() {
		return this.rejectedBy;
	}

	public void setRejectedBy(String rejectedBy) {
		this.rejectedBy = rejectedBy;
	}

	public Date getRejectedDate() {
		return this.rejectedDate;
	}

	public void setRejectedDate(Date rejectedDate) {
		this.rejectedDate = rejectedDate;
	}

	public String getSecdeposit() {
		return this.secdeposit;
	}

	public void setSecdeposit(String secdeposit) {
		this.secdeposit = secdeposit;
	}

	public String getSinno() {
		return this.sinno;
	}

	public void setSinno(String sinno) {
		this.sinno = sinno;
	}

	public String getSinno1() {
		return this.sinno1;
	}

	public void setSinno1(String sinno1) {
		this.sinno1 = sinno1;
	}

	public String getSinno2() {
		return this.sinno2;
	}

	public void setSinno2(String sinno2) {
		this.sinno2 = sinno2;
	}

	public String getSinno3() {
		return this.sinno3;
	}

	public void setSinno3(String sinno3) {
		this.sinno3 = sinno3;
	}

	public String getSinno4() {
		return this.sinno4;
	}

	public void setSinno4(String sinno4) {
		this.sinno4 = sinno4;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public String getToconpay() {
		return this.toconpay;
	}

	public void setToconpay(String toconpay) {
		this.toconpay = toconpay;
	}

	public String getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	public String getValidateByCe() {
		return this.validateByCe;
	}

	public void setValidateByCe(String validateByCe) {
		this.validateByCe = validateByCe;
	}

	public String getValidateByEe() {
		return this.validateByEe;
	}

	public void setValidateByEe(String validateByEe) {
		this.validateByEe = validateByEe;
	}

	public Date getValidateDateCe() {
		return this.validateDateCe;
	}

	public void setValidateDateCe(Date validateDateCe) {
		this.validateDateCe = validateDateCe;
	}

	public Date getValidateDateEe() {
		return this.validateDateEe;
	}

	public void setValidateDateEe(Date validateDateEe) {
		this.validateDateEe = validateDateEe;
	}

	public String getVat() {
		return this.vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public String getVatcost() {
		return this.vatcost;
	}

	public void setVatcost(String vatcost) {
		this.vatcost = vatcost;
	}


}
