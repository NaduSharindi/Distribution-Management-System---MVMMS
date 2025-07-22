package com.it.piv.mms.repo;

import com.it.piv.mms.domain.Appestlim;

public interface AppestlimDao {
	public Appestlim findAppEstLimits(String costCenterNo,String approvalType, String applicationType, String userLevel);

}
