package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.Gldeptm;

public interface GldeptmDao {
	
	public String getDD(String deptId);
	public List<Gldeptm> getArea(String deptId);
	public List<Gldeptm> getAreaByProvince(String province);
	public List<String> getAreaByProvinceNew(String province);
	public List<String> getAreaByProvinceNewCC(String province);
	public List<String> getAreaByProvinceNewCP2(String province);
	
	public List<Gldeptm> getAreaByDisDiv(String dist);
	public List<Gldeptm> getCscByArea(String dist);
	public List<Gldeptm> getDeptIdByCompId(String phmunit);
	
	public String getName(String deptId);
	
	

}
