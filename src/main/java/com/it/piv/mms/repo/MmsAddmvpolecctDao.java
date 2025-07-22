package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsAddmvpolecct;

public interface MmsAddmvpolecctDao {
	
	public String addCct(MmsAddmvpolecct addCct);
	public String update(MmsAddmvpolecct addCct);
	public String getNextPoleId(String appIdPrefix);
	public List<MmsAddmvpolecct> findByPoleId(long poleId);
	

}
