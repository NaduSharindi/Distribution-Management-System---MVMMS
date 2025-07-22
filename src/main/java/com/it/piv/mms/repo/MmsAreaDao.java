package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsArea;

public interface MmsAreaDao {
	public String addArea(MmsArea area);
	public List<MmsArea> findAll();
	public List<MmsArea> findActiveAreas();
	public void updateArea (String id,String province, String area, String status);
}
