package com.it.piv.mms.domain;
import java.io.Serializable;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MMS_INSPECTION database table.
 * 
 */
@Entity
@Table(name="MMS_INSPECTION")
@NamedQuery(name="MmsInspection.findAll", query="SELECT m FROM MmsInspection m")
public class MmsInspection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INSPECTION_ID")
	private String inspectionId;

	@Temporal(TemporalType.DATE)
	@Column(name="APPROVED_DATE")
	private Date approvedDate;

	
	@Temporal(TemporalType.DATE)
	@Column(name="COM_DATE")
	private Date comDate;

	public Date getComDate() {
		return comDate;
	}

private String ee;


	public String getEe() {
	return ee;
}



public void setEe(String ee) {
	this.ee = ee;
}



	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}

	private String area;
	
	private String remarks;
	
	private String completion;
	
	public String getCompletion() {
		return completion;
	}



	public void setCompletion(String completion) {
		this.completion = completion;
	}



	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	private String type;
	
	private String cycle;
	private String line;
	
	
	public String getLine() {
		return line;
	}



	public void setLine(String line) {
		this.line = line;
	}



	public String getCycle() {
		return cycle;
	}



	public void setCycle(String cycle) {
		this.cycle = cycle;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}

	private BigDecimal status;
	
	public BigDecimal getStatus() {
		return status;
	}



	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	private String description;

	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="HOT_LINE_ALLOWANCES" , precision=20, scale=2)
	@NumberFormat(pattern = "#,###,###,###.##")
	private BigDecimal hotLineAllowances;

	@Temporal(TemporalType.DATE)
	@Column(name="INS_CREATED_DATE")
	private Date insCreatedDate;

	@Column(name="INSPECTION_BY")
	private String inspectionBy;
	
	@Column(name="COM_STATUS")
	private String comStatus;


	public String getComStatus() {
		return comStatus;
	}



	public void setComStatus(String comStatus) {
		this.comStatus = comStatus;
	}

	@Column(name="LABOUR_HOURS_FOR_EST" , precision=20, scale=2)
	@NumberFormat(style = Style.NUMBER, pattern = "####.##")
	private BigDecimal labourHoursForEst;

	@Column(name="LABOUR_VALUE_FOR_EST" , precision=20, scale=2)
	@NumberFormat(pattern = "#,###,###,###.##")
	private BigDecimal labourValueForEst;

	@Column(name="NO_DAYS_FOR_THE_INS" , precision=20, scale=2)
	@NumberFormat(style = Style.NUMBER, pattern = "####.##")
	private BigDecimal noDaysForTheIns;

	@Column(name="PHM_BRANCH")
	private String phmBranch;

	@NumberFormat(pattern = "#,###,###,###.##")
	private BigDecimal subsistance;

	@Column(name="TATAL_COST" , precision=20, scale=2)
	@NumberFormat(pattern = "#,###,###,###.##")
	private BigDecimal tatalCost;

	@Column(name="TEMPORARY_SITE_COST" , precision=20, scale=2)
	@NumberFormat(pattern = "#,###,###,###.##")
	private BigDecimal temporarySiteCost;

	@Column(name="TOTAL_LINE_LENGTH" , precision=20, scale=2)
	@NumberFormat(style = Style.NUMBER, pattern = "####.##")
	private BigDecimal totalLineLength;

	@Column(name="TOTAL_NO_TOWERS" , precision=20)
	@NumberFormat(style = Style.NUMBER, pattern = "####.##")
	private BigDecimal totalNoTowers;

	@NumberFormat(pattern = "#,###,###,###.##")
	private BigDecimal transport;

	@Column(name="TRANSPORT_MANUAL" , precision=20, scale=2)
	@NumberFormat(style = Style.NUMBER, pattern = "####.##")
	private BigDecimal transportManual;

	@Column(name="VALIDATED_BY")
	private String validatedBy;

	@Column(name="WESTIMATE_NO")
	private String westimateNo;

	
	@Column(name="MAT_C0138")
	//@Column(name="MAT_C0138" , precision=20, scale=2)
	@NumberFormat(pattern = "#,###,###,###.##")
	private BigDecimal matC0138;
	
	
	
	@Column(name="MAT_C0143")
	@NumberFormat(pattern = "#,###,###,###.##")
	private BigDecimal matC0143;

	@Column(name="MAT_C0180")
	@NumberFormat(pattern = "#,###,###,###.##")
	private BigDecimal matC0180;

	@Column(name="MAT_C0190")
	@NumberFormat(pattern = "#,###,###,###.##")
	private BigDecimal matC0190;
	
	@Column(name="MAT_C0140")
	@NumberFormat(pattern = "#,###,###,###.##")
	private BigDecimal matC0140;
	
	@Column(name="MAT_W1246")
	@NumberFormat(pattern = "#,###,###,###.##")
	private BigDecimal matW1246;

	public BigDecimal getMatW1246() {
		return matW1246;
	}



	public void setMatW1246(BigDecimal matW1246) {
		this.matW1246 = matW1246;
	}



	public BigDecimal getMatC0140() {
		return matC0140;
	}



	public void setMatC0140(BigDecimal matC0140) {
		this.matC0140 = matC0140;
	}



	public MmsInspection() {
	}
	
	

	public BigDecimal getMatC0143() {
		return this.matC0143;
	}

	public void setMatC0143(BigDecimal matC0143) {
		this.matC0143 = matC0143;
	}

	public BigDecimal getMatC0180() {
		return this.matC0180;
	}

	public void setMatC0180(BigDecimal matC0180) {
		this.matC0180 = matC0180;
	}

	public BigDecimal getMatC0190() {
		return this.matC0190;
	}

	public void setMatC0190(BigDecimal matC0190) {
		this.matC0190 = matC0190;
	}

	public String getInspectionId() {
		return this.inspectionId;
	}

	public void setInspectionId(String inspectionId) {
		this.inspectionId = inspectionId;
	}

	public Date getApprovedDate() {
		return this.approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public BigDecimal getHotLineAllowances() {
		return this.hotLineAllowances;
	}

	public void setHotLineAllowances(BigDecimal hotLineAllowances) {
		this.hotLineAllowances = hotLineAllowances;
	}

	public Date getInsCreatedDate() {
		return this.insCreatedDate;
	}

	public void setInsCreatedDate(Date insCreatedDate) {
		this.insCreatedDate = insCreatedDate;
	}

	public String getInspectionBy() {
		return this.inspectionBy;
	}

	public void setInspectionBy(String inspectionBy) {
		this.inspectionBy = inspectionBy;
	}

	public BigDecimal getLabourHoursForEst() {
		return this.labourHoursForEst;
	}

	public void setLabourHoursForEst(BigDecimal labourHoursForEst) {
		this.labourHoursForEst = labourHoursForEst;
	}

	public BigDecimal getLabourValueForEst() {
		return this.labourValueForEst;
	}

	public void setLabourValueForEst(BigDecimal labourValueForEst) {
		this.labourValueForEst = labourValueForEst;
	}

	public BigDecimal getNoDaysForTheIns() {
		return this.noDaysForTheIns;
	}

	public void setNoDaysForTheIns(BigDecimal noDaysForTheIns) {
		this.noDaysForTheIns = noDaysForTheIns;
	}

	public String getPhmBranch() {
		return this.phmBranch;
	}

	public void setPhmBranch(String phmBranch) {
		this.phmBranch = phmBranch;
	}

	public BigDecimal getSubsistance() {
		return this.subsistance;
	}

	public void setSubsistance(BigDecimal subsistance) {
		this.subsistance = subsistance;
	}

	public BigDecimal getTatalCost() {
		return this.tatalCost;
	}

	public void setTatalCost(BigDecimal tatalCost) {
		this.tatalCost = tatalCost;
	}

	public BigDecimal getTemporarySiteCost() {
		return this.temporarySiteCost;
	}

	public void setTemporarySiteCost(BigDecimal temporarySiteCost) {
		this.temporarySiteCost = temporarySiteCost;
	}

	public BigDecimal getTotalLineLength() {
		return this.totalLineLength;
	}

	public void setTotalLineLength(BigDecimal totalLineLength) {
		this.totalLineLength = totalLineLength;
	}

	public BigDecimal getTotalNoTowers() {
		return this.totalNoTowers;
	}

	public void setTotalNoTowers(BigDecimal totalNoTowers) {
		this.totalNoTowers = totalNoTowers;
	}

	public BigDecimal getTransport() {
		return this.transport;
	}

	public void setTransport(BigDecimal transport) {
		this.transport = transport;
	}

	public BigDecimal getTransportManual() {
		return this.transportManual;
	}

	public void setTransportManual(BigDecimal transportManual) {
		this.transportManual = transportManual;
	}

	public String getValidatedBy() {
		return this.validatedBy;
	}

	public void setValidatedBy(String validatedBy) {
		this.validatedBy = validatedBy;
	}

	public String getWestimateNo() {
		return this.westimateNo;
	}

	public void setWestimateNo(String westimateNo) {
		this.westimateNo = westimateNo;
	}
	
	public BigDecimal getMatC0138() {
		return this.matC0138;
	}

	public void setMatC0138(BigDecimal matC0138) {
		this.matC0138 = matC0138;
	}

}