package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsProvince;

public interface ProvinceDao {
	
	public String addProvince(MmsProvince province);
	public List<MmsProvince> findAll();
	public void updateProvince (String province, String id, String status);
	public List<MmsProvince> findActiveProvince();
	
}
