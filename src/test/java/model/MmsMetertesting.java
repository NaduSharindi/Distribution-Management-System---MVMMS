package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the MMS_METERTESTING database table.
 * 
 */
@Entity
@Table(name="MMS_METERTESTING")
@NamedQuery(name="MmsMetertesting.findAll", query="SELECT m FROM MmsMetertesting m")
public class MmsMetertesting implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MmsMetertestingPK id;

	@Column(name="APPROVED_BY")
	private String approvedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="APPROVED_DATE")
	private Date approvedDate;

	@Temporal(TemporalType.DATE)
	@Column(name="APPROVED_TIME")
	private Date approvedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="COMPLETED_DATE")
	private Date completedDate;

	@Temporal(TemporalType.DATE)
	@Column(name="COMPLETED_TIME")
	private Date completedTime;

	@Column(name="ENT_BY")
	private String entBy;

	@Temporal(TemporalType.DATE)
	@Column(name="ENT_DATE")
	private Date entDate;

	@Temporal(TemporalType.DATE)
	@Column(name="ENT_TIME")
	private Date entTime;

	@Column(name="VALIDATE_BY")
	private String validateBy;

	@Temporal(TemporalType.DATE)
	@Column(name="VALIDATE_DATE")
	private Date validateDate;

	@Temporal(TemporalType.DATE)
	@Column(name="VALIDATE_TIME")
	private Date validateTime;

	public MmsMetertesting() {
	}

	public MmsMetertestingPK getId() {
		return this.id;
	}

	public void setId(MmsMetertestingPK id) {
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

	public Date getApprovedTime() {
		return this.approvedTime;
	}

	public void setApprovedTime(Date approvedTime) {
		this.approvedTime = approvedTime;
	}

	public Date getCompletedDate() {
		return this.completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public Date getCompletedTime() {
		return this.completedTime;
	}

	public void setCompletedTime(Date completedTime) {
		this.completedTime = completedTime;
	}

	public String getEntBy() {
		return this.entBy;
	}

	public void setEntBy(String entBy) {
		this.entBy = entBy;
	}

	public Date getEntDate() {
		return this.entDate;
	}

	public void setEntDate(Date entDate) {
		this.entDate = entDate;
	}

	public Date getEntTime() {
		return this.entTime;
	}

	public void setEntTime(Date entTime) {
		this.entTime = entTime;
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

	public Date getValidateTime() {
		return this.validateTime;
	}

	public void setValidateTime(Date validateTime) {
		this.validateTime = validateTime;
	}

}