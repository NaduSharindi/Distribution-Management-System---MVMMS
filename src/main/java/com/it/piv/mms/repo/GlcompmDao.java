package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.Glcompm;


public interface GlcompmDao {
	public List<Glcompm> getDistributionDivision();
	public List<Glcompm> getProvinces(String ddivision);
	public List<Glcompm> getArea(String province);
	
	public String getDistDivision(String province);
	public Glcompm getDistDivision2(String compId);
	public String getProvince(String compID);
	
	public Glcompm getGlcompmByProvince(String compID);
	public List<Glcompm> getDisDivision();
	public List<Glcompm> getProvincesPCB(String ddivision);
	
	
}
