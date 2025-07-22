package com.it.piv.mms.repo;

import java.util.List;

import com.it.piv.mms.domain.TrippingData;

public interface TrippingDataDao {
	public void save(TrippingData obj);
	public void update(TrippingData obj);
	public void inactiveRecord(String id);
	
	public List<TrippingData> findAll();
	public List<Object[]> findAllTrippingDataByLine(String lineID);
}
