package com.it.piv.mms.repo;

import com.it.piv.mms.domain.SpestedyCon;

public interface SpestedyConDao {
	public String save(SpestedyCon obj);
	public String getNextAppointmentId(String dept_id);
	public String getWestimateNo(String referenceNo,String deptId);
}
