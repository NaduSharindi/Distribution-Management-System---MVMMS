package com.it.piv.issue.domain;

import java.math.BigDecimal;

import javax.persistence.Column;

import org.springframework.format.annotation.NumberFormat;

import com.it.piv.mms.domain.PcestdttPK;

public class PcestdttModel {
	
	private String resName;

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	private String resCd;

	
	public String getResCd() {
		return resCd;
	}

	public void setResCd(String resCd) {
		this.resCd = resCd;
	}
	
	private String rebateCost;

	public String getRebateCost() {
		return rebateCost;
	}

	public void setRebateCost(String rebateCost) {
		this.rebateCost = rebateCost;
	}
	private BigDecimal offChargeQty;

	
	public BigDecimal getOffChargeQty() {
		return offChargeQty;
	}

	public void setOffChargeQty(BigDecimal offChargeQty) {
		this.offChargeQty = offChargeQty;
	}

	private BigDecimal reusableQty;

	public BigDecimal getReusableQty() {
		return reusableQty;
	}

	public void setReusableQty(BigDecimal reusableQty) {
		this.reusableQty = reusableQty;
	}

	private BigDecimal rebateQty;


	public BigDecimal getRebateQty() {
		return rebateQty;
	}

	public void setRebateQty(BigDecimal rebateQty) {
		this.rebateQty = rebateQty;
	}

	private BigDecimal approvedCost;

	private BigDecimal approvedQty;

	private BigDecimal commitedCost;

	private BigDecimal commitedQty;

	private BigDecimal customerQty;

	private BigDecimal damageQty;

	private String estimateCost;

	private BigDecimal estimateQty;

	private BigDecimal fundQty;

	private String genRes;

	private BigDecimal issuedCost;

	private BigDecimal issuedQty;

	private BigDecimal mntQty;

	private String normDefault;

	private BigDecimal requestedCost;

	private BigDecimal requestedQty;

	private BigDecimal resCat;

	private String resType;

	private BigDecimal returnedCost;

	private BigDecimal returnedQty;

	private BigDecimal tolerance;

	private BigDecimal unitPrice;

	private String uom;

	
	public BigDecimal getApprovedCost() {
		return this.approvedCost;
	}

	public void setApprovedCost(BigDecimal approvedCost) {
		this.approvedCost = approvedCost;
	}

	public BigDecimal getApprovedQty() {
		return this.approvedQty;
	}

	public void setApprovedQty(BigDecimal approvedQty) {
		this.approvedQty = approvedQty;
	}

	public BigDecimal getCommitedCost() {
		return this.commitedCost;
	}

	public void setCommitedCost(BigDecimal commitedCost) {
		this.commitedCost = commitedCost;
	}

	public BigDecimal getCommitedQty() {
		return this.commitedQty;
	}

	public void setCommitedQty(BigDecimal commitedQty) {
		this.commitedQty = commitedQty;
	}

	public BigDecimal getCustomerQty() {
		return this.customerQty;
	}

	public void setCustomerQty(BigDecimal customerQty) {
		this.customerQty = customerQty;
	}

	public BigDecimal getDamageQty() {
		return this.damageQty;
	}

	public void setDamageQty(BigDecimal damageQty) {
		this.damageQty = damageQty;
	}

	public String getEstimateCost() {
		return this.estimateCost;
	}

	public void setEstimateCost(String estimateCost) {
		this.estimateCost = estimateCost;
	}

	public BigDecimal getEstimateQty() {
		return this.estimateQty;
	}

	public void setEstimateQty(BigDecimal estimateQty) {
		this.estimateQty = estimateQty;
	}

	public BigDecimal getFundQty() {
		return this.fundQty;
	}

	public void setFundQty(BigDecimal fundQty) {
		this.fundQty = fundQty;
	}

	public String getGenRes() {
		return this.genRes;
	}

	public void setGenRes(String genRes) {
		this.genRes = genRes;
	}

	public BigDecimal getIssuedCost() {
		return this.issuedCost;
	}

	public void setIssuedCost(BigDecimal issuedCost) {
		this.issuedCost = issuedCost;
	}

	public BigDecimal getIssuedQty() {
		return this.issuedQty;
	}

	public void setIssuedQty(BigDecimal issuedQty) {
		this.issuedQty = issuedQty;
	}

	public BigDecimal getMntQty() {
		return this.mntQty;
	}

	public void setMntQty(BigDecimal mntQty) {
		this.mntQty = mntQty;
	}

	public String getNormDefault() {
		return this.normDefault;
	}

	public void setNormDefault(String normDefault) {
		this.normDefault = normDefault;
	}

	public BigDecimal getRequestedCost() {
		return this.requestedCost;
	}

	public void setRequestedCost(BigDecimal requestedCost) {
		this.requestedCost = requestedCost;
	}

	public BigDecimal getRequestedQty() {
		return this.requestedQty;
	}

	public void setRequestedQty(BigDecimal requestedQty) {
		this.requestedQty = requestedQty;
	}

	public BigDecimal getResCat() {
		return this.resCat;
	}

	public void setResCat(BigDecimal resCat) {
		this.resCat = resCat;
	}

	public String getResType() {
		return this.resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public BigDecimal getReturnedCost() {
		return this.returnedCost;
	}

	public void setReturnedCost(BigDecimal returnedCost) {
		this.returnedCost = returnedCost;
	}

	public BigDecimal getReturnedQty() {
		return this.returnedQty;
	}

	public void setReturnedQty(BigDecimal returnedQty) {
		this.returnedQty = returnedQty;
	}

	public BigDecimal getTolerance() {
		return this.tolerance;
	}

	public void setTolerance(BigDecimal tolerance) {
		this.tolerance = tolerance;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}


}
