package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsInspection;

public interface MmsInspectionDao {
	
	public String add(MmsInspection add);
	public String update(MmsInspection add);
	public String getNextINsEstimate(String appIdPrefix);
	public List<MmsInspection> getInsListByTypeDeptId(String type,String deptId,String status);
	public List<MmsInspection> getInsListByTypeDeptIdEs(String type,String deptId,String status,String es);
	public List<MmsInspection> getInsListByTypeDeptIdEE(String type,String deptId,String status,String es);
	
	public MmsInspection findByID(String id);

}
