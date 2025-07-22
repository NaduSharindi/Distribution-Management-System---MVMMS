package com.it.piv.mms.repo;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsCompletion;
import com.it.piv.mms.domain.MmsCompletionPK;

public interface MmsCompletionDao {
	
	public String add(MmsCompletion addLine);
	public String update(MmsCompletion addLine);
	public MmsCompletion findById(MmsCompletionPK comPK);
	public List<MmsCompletion> findByAreaCycle(String area,String cycle);
	

}
