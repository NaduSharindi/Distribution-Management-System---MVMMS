package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsAddlvfeeder;

public interface MmsAddlvfeederDao {
	
	public String addFeeder(MmsAddlvfeeder addFeeder);
	public String getNextFeerderId(String appIdPrefix);
	public String updateFeeder(MmsAddlvfeeder addFeeder);
	public List<MmsAddlvfeeder> findLvFeederByAreaStatus(String status,String area);
	

}
