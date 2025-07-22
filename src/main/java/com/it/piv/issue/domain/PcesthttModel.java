package com.it.piv.issue.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.it.piv.admin.domain.Sauserm;
import com.it.piv.mms.domain.Approval;
import com.it.piv.mms.domain.PcesthttPK;

public class PcesthttModel {
	private String deptId;
	
	private String ee;
	private String eeName;
	private String strStatus;
	
	
	public String getStrStatus() {
		return strStatus;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	public String getEeName() {
		return eeName;
	}

	public void setEeName(String eeName) {
		this.eeName = eeName;
	}

	public String getEe() {
		return ee;
	}

	public void setEe(String ee) {
		this.ee = ee;
	}

	private List<Sauserm> eeList;
	
	
	
	public List<Sauserm> getEeList() {
		return eeList;
	}

	public void setEeList(List<Sauserm> eeList) {
		this.eeList = eeList;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	private String estimateNo;
	
	public String getEstimateNo() {
		return estimateNo;
	}

	public void setEstimateNo(String estimateNo) {
		this.estimateNo = estimateNo;
	}

	private BigDecimal actualUnits;

	private BigDecimal allocPaid;

	private BigDecimal allocSettle;

	private Date aprDt1;

	private Date aprDt2;

	private Date aprDt3;

	private Date aprDt4;

	private Date aprDt5;

	private String aprUid1;

	private String aprUid2;

	private String aprUid3;

	private String aprUid4;

	private String aprUid5;

	private String catCd;

	private String clientNm;

	private String confBy;

	@Column(name="CONF_DT")
	private Date confDt;

	private String contNo;

	private String controlled;

	private BigDecimal custContrib;

	private String descr;

	private String entBy;

	private Date entDt;

	private String estType;

	private String estimatedYear;

	private String estimatedyear;

	private Date etimateDt;

	private BigDecimal fundContrib;

	private BigDecimal fundCost;

	private String fundId;

	private String fundSource;

	private String label1;

	private String label10;

	private String label2;

	private String label3;

	private String label4;

	private String label5;

	private String label6;

	private String label7;

	private String label8;

	private String label9;

	private String lbRateYear;

	private BigDecimal logId;

	private BigDecimal normDefault;

	private String omsRefNo;

	private BigDecimal paidAmt;

	private BigDecimal partPcnt;

	private String partialAmt;

	private String partialPmt;

	private BigDecimal priority;

	private Date prjAssDt;

	private String projectNo;

	private Date rejctDt;

	private String rejctUid;

	private String rejectReason;

	private String revReason;

	private Date reviseDt;

	private BigDecimal reviseEst;

	private String reviseUid;

	private BigDecimal settledAmt;

	private BigDecimal status;

	private String stdCost;
	private String stdCostInitial;
	private String percentage;



	
	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getStdCostInitial() {
		return stdCostInitial;
	}

	public void setStdCostInitial(String stdCostInitial) {
		this.stdCostInitial = stdCostInitial;
	}

	private String subCont;

	private String supCd;

	private BigDecimal taxAmt;

	private BigDecimal taxPcnt;

	private String tmplId;

	public BigDecimal getActualUnits() {
		return this.actualUnits;
	}

	public void setActualUnits(BigDecimal actualUnits) {
		this.actualUnits = actualUnits;
	}

	public BigDecimal getAllocPaid() {
		return this.allocPaid;
	}

	public void setAllocPaid(BigDecimal allocPaid) {
		this.allocPaid = allocPaid;
	}

	public BigDecimal getAllocSettle() {
		return this.allocSettle;
	}

	public void setAllocSettle(BigDecimal allocSettle) {
		this.allocSettle = allocSettle;
	}

	public Date getAprDt1() {
		return this.aprDt1;
	}

	public void setAprDt1(Date aprDt1) {
		this.aprDt1 = aprDt1;
	}

	public Date getAprDt2() {
		return this.aprDt2;
	}

	public void setAprDt2(Date aprDt2) {
		this.aprDt2 = aprDt2;
	}

	public Date getAprDt3() {
		return this.aprDt3;
	}

	public void setAprDt3(Date aprDt3) {
		this.aprDt3 = aprDt3;
	}

	public Date getAprDt4() {
		return this.aprDt4;
	}

	public void setAprDt4(Date aprDt4) {
		this.aprDt4 = aprDt4;
	}

	public Date getAprDt5() {
		return this.aprDt5;
	}

	public void setAprDt5(Date aprDt5) {
		this.aprDt5 = aprDt5;
	}

	public String getAprUid1() {
		return this.aprUid1;
	}

	public void setAprUid1(String aprUid1) {
		this.aprUid1 = aprUid1;
	}

	public String getAprUid2() {
		return this.aprUid2;
	}

	public void setAprUid2(String aprUid2) {
		this.aprUid2 = aprUid2;
	}

	public String getAprUid3() {
		return this.aprUid3;
	}

	public void setAprUid3(String aprUid3) {
		this.aprUid3 = aprUid3;
	}

	public String getAprUid4() {
		return this.aprUid4;
	}

	public void setAprUid4(String aprUid4) {
		this.aprUid4 = aprUid4;
	}

	public String getAprUid5() {
		return this.aprUid5;
	}

	public void setAprUid5(String aprUid5) {
		this.aprUid5 = aprUid5;
	}

	public String getCatCd() {
		return this.catCd;
	}

	public void setCatCd(String catCd) {
		this.catCd = catCd;
	}

	public String getClientNm() {
		return this.clientNm;
	}

	public void setClientNm(String clientNm) {
		this.clientNm = clientNm;
	}

	public String getConfBy() {
		return this.confBy;
	}

	public void setConfBy(String confBy) {
		this.confBy = confBy;
	}

	public Date getConfDt() {
		return this.confDt;
	}

	public void setConfDt(Date confDt) {
		this.confDt = confDt;
	}

	public String getContNo() {
		return this.contNo;
	}

	public void setContNo(String contNo) {
		this.contNo = contNo;
	}

	public String getControlled() {
		return this.controlled;
	}

	public void setControlled(String controlled) {
		this.controlled = controlled;
	}

	public BigDecimal getCustContrib() {
		return this.custContrib;
	}

	public void setCustContrib(BigDecimal custContrib) {
		this.custContrib = custContrib;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getEntBy() {
		return this.entBy;
	}

	public void setEntBy(String entBy) {
		this.entBy = entBy;
	}

	public Date getEntDt() {
		return this.entDt;
	}

	public void setEntDt(Date entDt) {
		this.entDt = entDt;
	}

	public String getEstType() {
		return this.estType;
	}

	public void setEstType(String estType) {
		this.estType = estType;
	}

	public String getEstimatedYear() {
		return this.estimatedYear;
	}

	public void setEstimatedYear(String estimatedYear) {
		this.estimatedYear = estimatedYear;
	}

	public String getEstimatedyear() {
		return this.estimatedyear;
	}

	public void setEstimatedyear(String estimatedyear) {
		this.estimatedyear = estimatedyear;
	}

	public Date getEtimateDt() {
		return this.etimateDt;
	}

	public void setEtimateDt(Date etimateDt) {
		this.etimateDt = etimateDt;
	}

	public BigDecimal getFundContrib() {
		return this.fundContrib;
	}

	public void setFundContrib(BigDecimal fundContrib) {
		this.fundContrib = fundContrib;
	}

	public BigDecimal getFundCost() {
		return this.fundCost;
	}

	public void setFundCost(BigDecimal fundCost) {
		this.fundCost = fundCost;
	}

	public String getFundId() {
		return this.fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public String getFundSource() {
		return this.fundSource;
	}

	public void setFundSource(String fundSource) {
		this.fundSource = fundSource;
	}

	public String getLabel1() {
		return this.label1;
	}

	public void setLabel1(String label1) {
		this.label1 = label1;
	}

	public String getLabel10() {
		return this.label10;
	}

	public void setLabel10(String label10) {
		this.label10 = label10;
	}

	public String getLabel2() {
		return this.label2;
	}

	public void setLabel2(String label2) {
		this.label2 = label2;
	}

	public String getLabel3() {
		return this.label3;
	}

	public void setLabel3(String label3) {
		this.label3 = label3;
	}

	public String getLabel4() {
		return this.label4;
	}

	public void setLabel4(String label4) {
		this.label4 = label4;
	}

	public String getLabel5() {
		return this.label5;
	}

	public void setLabel5(String label5) {
		this.label5 = label5;
	}

	public String getLabel6() {
		return this.label6;
	}

	public void setLabel6(String label6) {
		this.label6 = label6;
	}

	public String getLabel7() {
		return this.label7;
	}

	public void setLabel7(String label7) {
		this.label7 = label7;
	}

	public String getLabel8() {
		return this.label8;
	}

	public void setLabel8(String label8) {
		this.label8 = label8;
	}

	public String getLabel9() {
		return this.label9;
	}

	public void setLabel9(String label9) {
		this.label9 = label9;
	}

	public String getLbRateYear() {
		return this.lbRateYear;
	}

	public void setLbRateYear(String lbRateYear) {
		this.lbRateYear = lbRateYear;
	}

	public BigDecimal getLogId() {
		return this.logId;
	}

	public void setLogId(BigDecimal logId) {
		this.logId = logId;
	}

	public BigDecimal getNormDefault() {
		return this.normDefault;
	}

	public void setNormDefault(BigDecimal normDefault) {
		this.normDefault = normDefault;
	}

	public String getOmsRefNo() {
		return this.omsRefNo;
	}

	public void setOmsRefNo(String omsRefNo) {
		this.omsRefNo = omsRefNo;
	}

	public BigDecimal getPaidAmt() {
		return this.paidAmt;
	}

	public void setPaidAmt(BigDecimal paidAmt) {
		this.paidAmt = paidAmt;
	}

	public BigDecimal getPartPcnt() {
		return this.partPcnt;
	}

	public void setPartPcnt(BigDecimal partPcnt) {
		this.partPcnt = partPcnt;
	}

	public String getPartialAmt() {
		return this.partialAmt;
	}

	public void setPartialAmt(String partialAmt) {
		this.partialAmt = partialAmt;
	}

	public String getPartialPmt() {
		return this.partialPmt;
	}

	public void setPartialPmt(String partialPmt) {
		this.partialPmt = partialPmt;
	}

	public BigDecimal getPriority() {
		return this.priority;
	}

	public void setPriority(BigDecimal priority) {
		this.priority = priority;
	}

	public Date getPrjAssDt() {
		return this.prjAssDt;
	}

	public void setPrjAssDt(Date prjAssDt) {
		this.prjAssDt = prjAssDt;
	}

	public String getProjectNo() {
		return this.projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public Date getRejctDt() {
		return this.rejctDt;
	}

	public void setRejctDt(Date rejctDt) {
		this.rejctDt = rejctDt;
	}

	public String getRejctUid() {
		return this.rejctUid;
	}

	public void setRejctUid(String rejctUid) {
		this.rejctUid = rejctUid;
	}

	public String getRejectReason() {
		return this.rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public String getRevReason() {
		return this.revReason;
	}

	public void setRevReason(String revReason) {
		this.revReason = revReason;
	}

	public Date getReviseDt() {
		return this.reviseDt;
	}

	public void setReviseDt(Date reviseDt) {
		this.reviseDt = reviseDt;
	}

	public BigDecimal getReviseEst() {
		return this.reviseEst;
	}

	public void setReviseEst(BigDecimal reviseEst) {
		this.reviseEst = reviseEst;
	}

	public String getReviseUid() {
		return this.reviseUid;
	}

	public void setReviseUid(String reviseUid) {
		this.reviseUid = reviseUid;
	}

	public BigDecimal getSettledAmt() {
		return this.settledAmt;
	}

	public void setSettledAmt(BigDecimal settledAmt) {
		this.settledAmt = settledAmt;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public String getStdCost() {
		return this.stdCost;
	}

	public void setStdCost(String stdCost) {
		this.stdCost = stdCost;
	}

	public String getSubCont() {
		return this.subCont;
	}

	public void setSubCont(String subCont) {
		this.subCont = subCont;
	}

	public String getSupCd() {
		return this.supCd;
	}

	public void setSupCd(String supCd) {
		this.supCd = supCd;
	}

	public BigDecimal getTaxAmt() {
		return this.taxAmt;
	}

	public void setTaxAmt(BigDecimal taxAmt) {
		this.taxAmt = taxAmt;
	}

	public BigDecimal getTaxPcnt() {
		return this.taxPcnt;
	}

	public void setTaxPcnt(BigDecimal taxPcnt) {
		this.taxPcnt = taxPcnt;
	}

	public String getTmplId() {
		return this.tmplId;
	}

	public void setTmplId(String tmplId) {
		this.tmplId = tmplId;
	}


}
