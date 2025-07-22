package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.Spstdestdmt;


public interface SpstdestdmtDao {
	public List<Spstdestdmt> selectStdNoDeptId(String appNo, String deptid);

}
