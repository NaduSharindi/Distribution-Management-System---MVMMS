package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SPSTDESTHMT database table.
 * 
 */
@Entity
@NamedQuery(name="Spstdesthmt.findAll", query="SELECT s FROM Spstdesthmt s")
public class Spstdesthmt implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SpstdesthmtPK id;

	@Column(name="APPROVED_BY")
	private String approvedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="APPROVED_DATE")
	private Date approvedDate;

	private String assignedto;

	@Column(name="BAL_CAPACITY")
	private BigDecimal balCapacity;

	private BigDecimal cebcost;

	@Column(name="COMMENT_CE")
	private String commentCe;

	@Column(name="COMMENT_DGM")
	private String commentDgm;

	@Column(name="COMMENT_EE")
	private String commentEe;

	@Column(name="COMMENT_ES")
	private String commentEs;

	@Column(name="COMMENT_PCE")
	private String commentPce;

	@Column(name="COMMENT_PE")
	private String commentPe;

	@Column(name="CON_COST")
	private BigDecimal conCost;

	private String contingency;

	private String description;

	@Column(name="ENTRY_BY")
	private String entryBy;

	@Temporal(TemporalType.DATE)
	@Column(name="ENTRY_DATE")
	private Date entryDate;

	@Column(name="EX_CAPACITY")
	private BigDecimal exCapacity;

	private String jobname;

	@Column(name="LINE_LENGTH")
	private BigDecimal lineLength;

	private BigDecimal nbtcost;

	private BigDecimal nbtpercentage;

	@Column(name="NEW_CAPACITY")
	private BigDecimal newCapacity;

	@Column(name="PLANING_BY")
	private String planingBy;

	@Temporal(TemporalType.DATE)
	@Column(name="PLANING_DATE")
	private Date planingDate;

	@Column(name="POST_DEPTID")
	private String postDeptid;

	private String projecttype;

	@Column(name="REBATE_COST")
	private BigDecimal rebateCost;

	@Column(name="REJ_REASON_EE")
	private String rejReasonEe;

	@Column(name="REJ_RESON_CE")
	private String rejResonCe;

	@Column(name="REJ_RESON_PE")
	private String rejResonPe;

	@Column(name="REJECTED_BY")
	private String rejectedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="REJECTED_DATE")
	private Date rejectedDate;

	private BigDecimal secdeposit;

	private String sinno;

	private String sinno1;

	private String sinno2;

	private String sinno3;

	private String sinno4;

	private BigDecimal status;

	private BigDecimal toconpay;

	@Column(name="TOTAL_COST")
	private BigDecimal totalCost;

	@Column(name="VALIDATE_BY_CE")
	private String validateByCe;

	@Column(name="VALIDATE_BY_EE")
	private String validateByEe;

	@Temporal(TemporalType.DATE)
	@Column(name="VALIDATE_DATE_CE")
	private Date validateDateCe;

	@Temporal(TemporalType.DATE)
	@Column(name="VALIDATE_DATE_EE")
	private Date validateDateEe;

	private BigDecimal vat;

	private BigDecimal vatcost;

	public Spstdesthmt() {
	}

	public SpstdesthmtPK getId() {
		return this.id;
	}

	public void setId(SpstdesthmtPK id) {
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

	public BigDecimal getCebcost() {
		return this.cebcost;
	}

	public void setCebcost(BigDecimal cebcost) {
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

	public BigDecimal getNbtcost() {
		return this.nbtcost;
	}

	public void setNbtcost(BigDecimal nbtcost) {
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

	public BigDecimal getRebateCost() {
		return this.rebateCost;
	}

	public void setRebateCost(BigDecimal rebateCost) {
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

	public BigDecimal getSecdeposit() {
		return this.secdeposit;
	}

	public void setSecdeposit(BigDecimal secdeposit) {
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

	public BigDecimal getToconpay() {
		return this.toconpay;
	}

	public void setToconpay(BigDecimal toconpay) {
		this.toconpay = toconpay;
	}

	public BigDecimal getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
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

	public BigDecimal getVat() {
		return this.vat;
	}

	public void setVat(BigDecimal vat) {
		this.vat = vat;
	}

	public BigDecimal getVatcost() {
		return this.vatcost;
	}

	public void setVatcost(BigDecimal vatcost) {
		this.vatcost = vatcost;
	}

}