package com.it.piv.issue.domain;

public class JobTransfer {
	
	private String jobNumber;
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	private String exsistingCostCenter;
	public String getExsistingCostCenter() {
		return exsistingCostCenter;
	}
	public void setExsistingCostCenter(String exsistingCostCenter) {
		this.exsistingCostCenter = exsistingCostCenter;
	}
	private String newCostCenter;
	public String getNewCostCenter() {
		return newCostCenter;
	}
	public void setNewCostCenter(String newCostCenter) {
		this.newCostCenter = newCostCenter;
	}
	private String errorMsg;
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	private String successMsg;
	public String getSuccessMsg() {
		return successMsg;
	}
	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
	
	
	

}
