package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsAddsurgearrestor;
import com.it.piv.mms.domain.MmsAddsurgearrestorPK;

public interface MmsAddsurgearrestorDao {
	
	public String addSurgeArrestor(MmsAddsurgearrestor obj);
	public String updateSurgeArrestor(MmsAddsurgearrestor obj);
	public MmsAddsurgearrestor findById(MmsAddsurgearrestorPK ojb);
	public List<MmsAddsurgearrestor> findByGantryId(String gantryId);
	public String getNextSurgeArrestorId(String appIdPrefix);
	


}
