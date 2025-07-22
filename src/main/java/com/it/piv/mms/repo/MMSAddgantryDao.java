package com.it.piv.mms.repo;


import java.util.List;

import com.it.piv.mms.domain.MmsAddgantry;
import com.it.piv.mms.domain.MmsGantryloc;

public interface MMSAddgantryDao {
	public String addGantry(MmsAddgantry addLine);
	public List<MmsAddgantry> getGantryByLineArea(String line,String area);
	public MmsAddgantry findById(long id);
	public String updateGantry(MmsAddgantry addLine);
	public List<MmsAddgantry> getGantryData(String code);
	public String addGantryLoc(MmsGantryloc addGantryLoc);
	public List<MmsGantryloc> getGantryLocData(String gantryId);
	public String getNextGantryId(String appIdPrefix);
public List<MmsAddgantry> getGantryByArea(String area);
public List<MmsAddgantry> getGantryByAreaNew(String area);
public List<MmsAddgantry> getGantryByAreaNewAll(String province,String area);
public List<MmsAddgantry> getGantryByAreaNewAllDivision(String province,String area,String division);

public List<MmsAddgantry> getGantryByAreaStatus(String area,String status);

public List<Object[]> getSummaryGantry(String deptId);


public List<MmsAddgantry> findGantryByStatus(String status,String phmbranch);
public List<Object[]> getGantryByProvince();

public List<Object[]> getGantryByProvinceByArea(String area);




	
	

}
