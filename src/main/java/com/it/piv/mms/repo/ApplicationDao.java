package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.issue.domain.PivModel;
import com.it.piv.mms.domain.Application;
import com.it.piv.mms.domain.ApplicationPK;
import com.it.piv.mms.domain.Pcestdtt;
import com.it.piv.mms.domain.Pcesthtt;

public interface ApplicationDao {
	
	public String save(Application obj);
	public Application findById(ApplicationPK objPk);
	public Application findByAppDeptId(String appNo, String deptid);

	public String getNextAppId(String appIdPrefix);
	public String updateApplication(Application application);
	public String saveSPS(String deptId,String userName,String allocatedTo,Application application,PivModel pimmodel);
	public String saveSPSBreakDown(String deptId,String userName,String allocatedTo,Application application,PivModel pimmodel);

}
