package com.it.piv.mms.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the MMS_ADDSUPPORT database table.
 * 
 */
/**
 * The persistent class for the MMS_ADDSUPPORT database table.
 * 
 */
@Entity
@Table(name="MMS_ADDSUPPORT")
@NamedQuery(name="MmsAddsupport.findAll", query="SELECT m FROM MmsAddsupport m")
public class MmsAddsupport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqGen")
	@SequenceGenerator(name = "SeqGen", sequenceName = "SUPPORT1_INSTALL_SEQ", allocationSize = 1)
	private long id;

	@Column(name="APPROVAL_LEVEL")
	private String approvalLevel;

	@Column(name="APPROVED_BY")
	private String approvedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="APPROVED_DATE")
	private Date approvedDate;

	@Column(name="APPROVED_TIME")
	private String approvedTime;

	private String area;

	@Column(name="BODY_EXTENSION")
	private String bodyExtension;

	@Column(name="CONDUCTOR_TYPE")
	private BigDecimal conductorType;

	private String csc;

	@Column(name="EARTH_CONDUCTOR_TYPE")
	private BigDecimal earthConductorType;

	@Column(name="ENT_BY")
	private String entBy;

	@Temporal(TemporalType.DATE)
	@Column(name="ENT_DATE")
	private Date entDate;

	@Column(name="ENT_TIME")
	private String entTime;

	@Column(name="FEEDER_IDENTIFICATION")
	private String feederIdentification;

	private String filepath;

	@Column(name="GANTRY_ID")
	private BigDecimal gantryId;

	@Column(name="GPS_LATITUDE")
	private BigDecimal gpsLatitude;

	@Column(name="GPS_LONGITUDE")
	private BigDecimal gpsLongitude;

	@Lob
	private byte[] image;

	@Column(name="LINE_ID")
	private BigDecimal lineId;

	@Column(name="LINE_NAME")
	private String lineName;

	@Column(name="MAP_ID")
	private BigDecimal mapId;

	@Column(name="NO_OF_CIRCUITS")
	private BigDecimal noOfCircuits;

	@Column(name="PHM_BRANCH")
	private String phmBranch;

	private BigDecimal status;

	@Column(name="SUPPORT_TYPE")
	private BigDecimal supportType;

	private BigDecimal tapping;

	@Column(name="TOWER_CONFIGURATION")
	private BigDecimal towerConfiguration;

	@Column(name="TOWER_NO")
	private String towerNo;

	@Column(name="TOWER_TYPE")
	private BigDecimal towerType;

	@Column(name="VALIDATE_BY")
	private String validateBy;

	@Temporal(TemporalType.DATE)
	@Column(name="VALIDATE_DATE")
	private Date validateDate;

	@Column(name="VALIDATE_TIME")
	private String validateTime;
	
	@Temporal(TemporalType.DATE)
	@Column(name="INTERRUPTED_DATE")
	private Date interruptedDate;

	@Column(name="RESPONSIBLE_AREA")
	private String responsibleArea;

	@Column(name="SECTION_ID")
	private String sectionId;

	@Column(name="SECTION_ID_TO")
	private String sectionIdTo;

	public Date getInterruptedDate() {
		return interruptedDate;
	}

	public void setInterruptedDate(Date interruptedDate) {
		this.interruptedDate = interruptedDate;
	}

	@Column(name="INTERRUPTED_YES")
	private BigDecimal interruptedYes;

	public BigDecimal getInterruptedYes() {
		return interruptedYes;
	}

	public void setInterruptedYes(BigDecimal interruptedYes) {
		this.interruptedYes = interruptedYes;
	}

	@Column(name="INTERRUPTION_NO")
	private String interruptionNo;


	public String getInterruptionNo() {
		return interruptionNo;
	}

	public void setInterruptionNo(String interruptionNo) {
		this.interruptionNo = interruptionNo;
	}

	public MmsAddsupport() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApprovalLevel() {
		return this.approvalLevel;
	}

	public void setApprovalLevel(String approvalLevel) {
		this.approvalLevel = approvalLevel;
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

	public String getBodyExtension() {
		return this.bodyExtension;
	}

	public void setBodyExtension(String bodyExtension) {
		this.bodyExtension = bodyExtension;
	}

	public BigDecimal getConductorType() {
		return this.conductorType;
	}

	public void setConductorType(BigDecimal conductorType) {
		this.conductorType = conductorType;
	}

	public String getCsc() {
		return this.csc;
	}

	public void setCsc(String csc) {
		this.csc = csc;
	}

	public BigDecimal getEarthConductorType() {
		return this.earthConductorType;
	}

	public void setEarthConductorType(BigDecimal earthConductorType) {
		this.earthConductorType = earthConductorType;
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

	public String getFeederIdentification() {
		return this.feederIdentification;
	}

	public void setFeederIdentification(String feederIdentification) {
		this.feederIdentification = feederIdentification;
	}

	public String getFilepath() {
		return this.filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public BigDecimal getGantryId() {
		return this.gantryId;
	}

	public void setGantryId(BigDecimal gantryId) {
		this.gantryId = gantryId;
	}

	public BigDecimal getGpsLatitude() {
		return this.gpsLatitude;
	}

	public void setGpsLatitude(BigDecimal gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}

	public BigDecimal getGpsLongitude() {
		return this.gpsLongitude;
	}

	public void setGpsLongitude(BigDecimal gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public BigDecimal getLineId() {
		return this.lineId;
	}

	public void setLineId(BigDecimal lineId) {
		this.lineId = lineId;
	}

	public String getLineName() {
		return this.lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public BigDecimal getMapId() {
		return this.mapId;
	}

	public void setMapId(BigDecimal mapId) {
		this.mapId = mapId;
	}

	public BigDecimal getNoOfCircuits() {
		return this.noOfCircuits;
	}

	public void setNoOfCircuits(BigDecimal noOfCircuits) {
		this.noOfCircuits = noOfCircuits;
	}

	public String getPhmBranch() {
		return this.phmBranch;
	}

	public void setPhmBranch(String phmBranch) {
		this.phmBranch = phmBranch;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public BigDecimal getSupportType() {
		return this.supportType;
	}

	public void setSupportType(BigDecimal supportType) {
		this.supportType = supportType;
	}

	public BigDecimal getTapping() {
		return this.tapping;
	}

	public void setTapping(BigDecimal tapping) {
		this.tapping = tapping;
	}

	public BigDecimal getTowerConfiguration() {
		return this.towerConfiguration;
	}

	public void setTowerConfiguration(BigDecimal towerConfiguration) {
		this.towerConfiguration = towerConfiguration;
	}

	public String getTowerNo() {
		return this.towerNo;
	}

	public void setTowerNo(String towerNo) {
		this.towerNo = towerNo;
	}

	public BigDecimal getTowerType() {
		return this.towerType;
	}

	public void setTowerType(BigDecimal towerType) {
		this.towerType = towerType;
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
	
	public String getResponsibleArea() {
		return this.responsibleArea;
	}

	public void setResponsibleArea(String responsibleArea) {
		this.responsibleArea = responsibleArea;
	}

	public String getSectionId() {
		return this.sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionIdTo() {
		return this.sectionIdTo;
	}

	public void setSectionIdTo(String sectionIdTo) {
		this.sectionIdTo = sectionIdTo;
	}

	@Override
	public String toString() {
		return "MmsAddsupport [id=" + id + ", approvalLevel=" + approvalLevel
				+ ", approvedBy=" + approvedBy + ", approvedDate="
				+ approvedDate + ", approvedTime=" + approvedTime + ", area="
				+ area + ", bodyExtension=" + bodyExtension
				+ ", conductorType=" + conductorType + ", csc=" + csc
				+ ", earthConductorType=" + earthConductorType + ", entBy="
				+ entBy + ", entDate=" + entDate + ", entTime=" + entTime
				+ ", feederIdentification=" + feederIdentification
				+ ", filepath=" + filepath + ", gantryId=" + gantryId
				+ ", gpsLatitude=" + gpsLatitude + ", gpsLongitude="
				+ gpsLongitude + ", image=" + Arrays.toString(image)
				+ ", lineId=" + lineId + ", lineName=" + lineName + ", mapId="
				+ mapId + ", noOfCircuits=" + noOfCircuits + ", phmBranch="
				+ phmBranch + ", status=" + status + ", supportType="
				+ supportType + ", tapping=" + tapping
				+ ", towerConfiguration=" + towerConfiguration + ", towerNo="
				+ towerNo + ", towerType=" + towerType + ", validateBy="
				+ validateBy + ", validateDate=" + validateDate
				+ ", validateTime=" + validateTime + ", interruptedDate="
				+ interruptedDate + ", responsibleArea=" + responsibleArea
				+ ", sectionId=" + sectionId + ", sectionIdTo=" + sectionIdTo
				+ ", interruptedYes=" + interruptedYes + ", interruptionNo="
				+ interruptionNo + "]";
	}


	
	
	
	
	
	

}