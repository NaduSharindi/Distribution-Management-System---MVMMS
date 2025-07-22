package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.MmsAddpoletype;

public interface MmsAddPoleTypeDao {
	public String addPoleType(MmsAddpoletype poleType);
	public List<MmsAddpoletype> findAll();
	public List<MmsAddpoletype> findActiveTypes();
	
	
	public void updatePoleType (MmsAddpoletype obj);

}
