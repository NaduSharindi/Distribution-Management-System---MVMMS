package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MMS_COMPLETION database table.
 * 
 */
@Entity
@Table(name="MMS_COMPLETION")
@NamedQuery(name="MmsCompletion.findAll", query="SELECT m FROM MmsCompletion m")
public class MmsCompletion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MmsCompletionPK id;

	@Column(name="APPROVED_BY")
	private String approvedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="APPROVED_DATE")
	private Date approvedDate;

	@Column(name="APPROVED_TIME")
	private String approvedTime;

	private String code;

	private String complesion;

	@Temporal(TemporalType.DATE)
	@Column(name="COMPLETED_DATE")
	private Date completedDate;

	@Column(name="COMPLETED_TIME")
	private String completedTime;

	@Column(name="LINE_NAME")
	private String lineName;

	private String remarks;

	private BigDecimal status;

	@Column(name="VALIDATE_BY")
	private String validateBy;

	@Temporal(TemporalType.DATE)
	@Column(name="VALIDATE_DATE")
	private Date validateDate;

	@Column(name="VALIDATE_TIME")
	private String validateTime;

	public MmsCompletion() {
	}

	public MmsCompletionPK getId() {
		return this.id;
	}

	public void setId(MmsCompletionPK id) {
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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getComplesion() {
		return this.complesion;
	}

	public void setComplesion(String complesion) {
		this.complesion = complesion;
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

	public String getLineName() {
		return this.lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
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