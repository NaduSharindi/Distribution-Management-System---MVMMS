package com.it.piv.mms.repo;

import com.it.piv.mms.domain.WiringLandDetailCon;

public interface WiringLandDetailConDao {
	public String save(WiringLandDetailCon obj);
	public WiringLandDetailCon selectStdNoDeptId(String appNo, String deptid);
}
