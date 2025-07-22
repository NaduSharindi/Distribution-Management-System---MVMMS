package com.it.piv.mms.domain;

public class InterruptionObject {
	private String interruptionId;

	public String getInterruptionId() {
		return interruptionId;
	}

	public void setInterruptionId(String interruptionId) {
		this.interruptionId = interruptionId;
	}
	
	private String interruptionDate;

	public String getInterruptionDate() {
		return interruptionDate;
	}

	public void setInterruptionDate(String interruptionDate) {
		this.interruptionDate = interruptionDate;
	}
	
	private String sectionInterrupted;

	public String getSectionInterrupted() {
		return sectionInterrupted;
	}

	public void setSectionInterrupted(String sectionInterrupted) {
		this.sectionInterrupted = sectionInterrupted;
	}

	@Override
	public String toString() {
		return "InterruptionObject [interruptionId=" + interruptionId
				+ ", interruptionDate=" + interruptionDate
				+ ", sectionInterrupted=" + sectionInterrupted + "]";
	}
	
	
	

	
	

}
