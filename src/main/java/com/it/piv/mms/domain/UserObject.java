package com.it.piv.mms.domain;

public class UserObject {
	
	private String deptId;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "RequestObject [deptId=" + deptId + ", userId=" + userId + "]";
	}
	
	

}
