package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MMS_MNTPLAN database table.
 * 
 */
@Entity
@Table(name="MMS_MNTPLAN")
@NamedQuery(name="MmsMntplan.findAll", query="SELECT m FROM MmsMntplan m")
public class MmsMntplan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="APPROVED_BY")
	private String approvedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="APPROVED_DATE")
	private Date approvedDate;

	@Column(name="APPROVED_TIME")
	private String approvedTime;

	private String area;

	private String csc;

	private String dd;

	@Column(name="EE_NAME")
	private String eeName;

	@Column(name="ENT_BY")
	private String entBy;

	@Temporal(TemporalType.DATE)
	@Column(name="ENT_DATE")
	private Date entDate;

	@Column(name="ENT_TIME")
	private String entTime;

	@Column(name="ES_NAME")
	private String esName;

	@Temporal(TemporalType.DATE)
	@Column(name="FROM_DATE")
	private Date fromDate;

	@Column(name="\"LENGTH\"")
	private BigDecimal length;

	@Column(name="LINE_ID")
	private double lineId;

	private BigDecimal noofpoles;

	private BigDecimal nooftowers;

	@Column(name="PHM_BRANCH")
	private String phmBranch;

	@Column(name="PLAN_TYPE")
	private String planType;

	private String province;

	@Column(name="SERIAL_NO")
	private String serialNo;

	private BigDecimal status;

	@Temporal(TemporalType.DATE)
	@Column(name="TO_DATE")
	private Date toDate;

	@Column(name="VALIDATE_BY")
	private String validateBy;

	@Temporal(TemporalType.DATE)
	@Column(name="VALIDATE_DATE")
	private Date validateDate;

	@Column(name="VALIDATE_TIME")
	private String validateTime;

	@Column(name="\"YEAR\"")
	private String year;

	public MmsMntplan() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
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

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCsc() {
		return this.csc;
	}

	public void setCsc(String csc) {
		this.csc = csc;
	}

	public String getDd() {
		return this.dd;
	}

	public void setDd(String dd) {
		this.dd = dd;
	}

	public String getEeName() {
		return this.eeName;
	}

	public void setEeName(String eeName) {
		this.eeName = eeName;
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

	public String getEntTime() {
		return this.entTime;
	}

	public void setEntTime(String entTime) {
		this.entTime = entTime;
	}

	public String getEsName() {
		return this.esName;
	}

	public void setEsName(String esName) {
		this.esName = esName;
	}

	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public BigDecimal getLength() {
		return this.length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public double getLineId() {
		return this.lineId;
	}

	public void setLineId(double lineId) {
		this.lineId = lineId;
	}

	public BigDecimal getNoofpoles() {
		return this.noofpoles;
	}

	public void setNoofpoles(BigDecimal noofpoles) {
		this.noofpoles = noofpoles;
	}

	public BigDecimal getNooftowers() {
		return this.nooftowers;
	}

	public void setNooftowers(BigDecimal nooftowers) {
		this.nooftowers = nooftowers;
	}

	public String getPhmBranch() {
		return this.phmBranch;
	}

	public void setPhmBranch(String phmBranch) {
		this.phmBranch = phmBranch;
	}

	public String getPlanType() {
		return this.planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
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

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}