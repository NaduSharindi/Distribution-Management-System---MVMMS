package com.it.piv.mms.domain;

import java.util.List;

public class ResponseObject {
	
	private String responseCode;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	
	private String responseValue;

	public String getResponseValue() {
		return responseValue;
	}

	public void setResponseValue(String responseValue) {
		this.responseValue = responseValue;
	}
	
	private List<InterruptionObject> interruptionList;

	public List<InterruptionObject> getInterruptionList() {
		return interruptionList;
	}

	public void setInterruptionList(List<InterruptionObject> interruptionList) {
		this.interruptionList = interruptionList;
	}

		
	

}
