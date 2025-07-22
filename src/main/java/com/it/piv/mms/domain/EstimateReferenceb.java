package com.it.piv.mms.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ESTIMATE_REFERENCEBS database table.
 * 
 */
@Entity
@Table(name="ESTIMATE_REFERENCEBS")
@NamedQuery(name="EstimateReferenceb.findAll", query="SELECT e FROM EstimateReferenceb e")
public class EstimateReferenceb implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EstimateReferencebPK id;

	@Column(name="ENTRY_BY")
	private String entryBy;

	@Column(name="FILE_REF")
	private String fileRef;

	@Column(name="ID_NO")
	private String idNo;

	@Column(name="POSTED_BY")
	private String postedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="POSTED_DATE")
	private Date postedDate;

	@Column(name="POSTED_TIME")
	private String postedTime;

	private String projectno;

	private String status;

	public EstimateReferenceb() {
	}

	public EstimateReferencebPK getId() {
		return this.id;
	}

	public void setId(EstimateReferencebPK id) {
		this.id = id;
	}

	public String getEntryBy() {
		return this.entryBy;
	}

	public void setEntryBy(String entryBy) {
		this.entryBy = entryBy;
	}

	public String getFileRef() {
		return this.fileRef;
	}

	public void setFileRef(String fileRef) {
		this.fileRef = fileRef;
	}

	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getPostedBy() {
		return this.postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public Date getPostedDate() {
		return this.postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public String getPostedTime() {
		return this.postedTime;
	}

	public void setPostedTime(String postedTime) {
		this.postedTime = postedTime;
	}

	public String getProjectno() {
		return this.projectno;
	}

	public void setProjectno(String projectno) {
		this.projectno = projectno;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}