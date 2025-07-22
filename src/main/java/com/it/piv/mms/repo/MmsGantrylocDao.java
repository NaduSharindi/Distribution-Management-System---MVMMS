package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsGantryloc;
import com.it.piv.mms.domain.MmsGantrylocPK;

public interface MmsGantrylocDao {
	
	public String addGantyLoc(MmsGantryloc gantryLoc);
	public MmsGantryloc findById(MmsGantrylocPK id);
	public String updateGantyLoc(MmsGantryloc gantryLoc);
	public List<MmsGantryloc> getGantryLoc(String gantryid);
	public List<MmsGantryloc> getGantryLocArea(String area);
	
	

}
