package com.it.piv.mms.repo;

import com.it.piv.mms.domain.WiringLandDetail;
import com.it.piv.mms.domain.WiringLandDetailCon;

public interface WiringLandDetailDao {
	public String save(WiringLandDetail obj);
	public WiringLandDetail selectStdNoDeptId(String appNo, String deptid);
}
