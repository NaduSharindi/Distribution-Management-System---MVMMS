package com.it.piv.mms.domain;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the PCB_SAMPLE database table.
 * 
 */
@Entity
@Table(name="PCB_SAMPLE")
@NamedQuery(name="PcbSample.findAll", query="SELECT p FROM PcbSample p")
public class PcbSample implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EQUIPMENT_ID")
	private String equipmentId;
	
	@Column(name="ENTERED_DATE")
	private Date enteredDate;

	@Column(name="EPF_NO_GROUP")
	private String epfNoGroup;

	@Column(name="EPF_NO_TEST_GROUP")
	private String epfNoTestGroup;

	@Column(name="EXTRACTED_TOP")
	private String extractedTop;

	/*@Temporal(TemporalType.DATE)
	@Column(name="PCB_TEST_DATE")
	private Date pcbTestDate;*/
	@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern="yyyy-mm-dd")
	@Column(name="PCB_TEST_DATE")
	private Date pcbTestDate;

	@Column(name="PCB_TEST_RESULTS")
	private String pcbTestResults;

	private String remarks;

	/*@Temporal(TemporalType.DATE)
	@Column(name="SAMPLE_DATE")
	private Date sampleDate;*/
	@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern="yyyy-mm-dd")
	@Column(name="SAMPLE_DATE")
	private Date sampleDate;

	@Column(name="SAMPLE_SATISIFIED")
	private String sampleSatisified;

	@Column(name="SAMPLING_NU")
	private String samplingNu;

	@Column(name="SAMPLING_PORT")
	private String samplingPort;

	@Column(name="TEST_REMARKS")
	private String testRemarks;
	
	@Column(name="UPDATED_DATE")
	private Date updatedDate;
	
	@Column(name="PCB_TEST_DATA")
	private BigDecimal pcbTestData;
	
	
	@Column(name="PCB_TEST_DATA_AROCLOR")
	private BigDecimal pcbTestDataAroclor;
	
	@Column(name="TEST_LAB")
	private String testLab;
	
	
	@Column(name="COMPLETED")
	private String completed;
	

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	public String getTestLab() {
		return testLab;
	}

	public void setTestLab(String testLab) {
		this.testLab = testLab;
	}

	public BigDecimal getPcbTestDataAroclor() {
		return pcbTestDataAroclor;
	}

	public void setPcbTestDataAroclor(BigDecimal pcbTestDataAroclor) {
		this.pcbTestDataAroclor = pcbTestDataAroclor;
	}

	public BigDecimal getPcbTestData() {
		return pcbTestData;
	}

	public void setPcbTestData(BigDecimal pcbTestData) {
		this.pcbTestData = pcbTestData;
	}

	public PcbSample() {
	}

	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEpfNoGroup() {
		return this.epfNoGroup;
	}

	public void setEpfNoGroup(String epfNoGroup) {
		this.epfNoGroup = epfNoGroup;
	}

	public String getEpfNoTestGroup() {
		return this.epfNoTestGroup;
	}

	public void setEpfNoTestGroup(String epfNoTestGroup) {
		this.epfNoTestGroup = epfNoTestGroup;
	}

	public String getExtractedTop() {
		return this.extractedTop;
	}

	public void setExtractedTop(String extractedTop) {
		this.extractedTop = extractedTop;
	}

	public Date getPcbTestDate() {
		return this.pcbTestDate;
	}

	public void setPcbTestDate(Date pcbTestDate) {
		this.pcbTestDate = pcbTestDate;
	}

	public String getPcbTestResults() {
		return this.pcbTestResults;
	}

	public void setPcbTestResults(String pcbTestResults) {
		this.pcbTestResults = pcbTestResults;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getSampleDate() {
		return this.sampleDate;
	}

	public void setSampleDate(Date sampleDate) {
		this.sampleDate = sampleDate;
	}

	public String getSampleSatisified() {
		return this.sampleSatisified;
	}

	public void setSampleSatisified(String sampleSatisified) {
		this.sampleSatisified = sampleSatisified;
	}

	public String getSamplingNu() {
		return this.samplingNu;
	}

	public void setSamplingNu(String samplingNu) {
		this.samplingNu = samplingNu;
	}

	public String getSamplingPort() {
		return this.samplingPort;
	}

	public void setSamplingPort(String samplingPort) {
		this.samplingPort = samplingPort;
	}

	public String getTestRemarks() {
		return this.testRemarks;
	}

	public void setTestRemarks(String testRemarks) {
		this.testRemarks = testRemarks;
	}

	@Override
	public String toString() {
		return "PcbSample [equipmentId=" + equipmentId + ", enteredDate="
				+ enteredDate + ", epfNoGroup=" + epfNoGroup
				+ ", epfNoTestGroup=" + epfNoTestGroup + ", extractedTop="
				+ extractedTop + ", pcbTestDate=" + pcbTestDate
				+ ", pcbTestResults=" + pcbTestResults + ", remarks=" + remarks
				+ ", sampleDate=" + sampleDate + ", sampleSatisified="
				+ sampleSatisified + ", samplingNu=" + samplingNu
				+ ", samplingPort=" + samplingPort + ", testRemarks="
				+ testRemarks + ", updatedDate=" + updatedDate
				+ ", pcbTestData=" + pcbTestData + "]";
	}
	
	

}