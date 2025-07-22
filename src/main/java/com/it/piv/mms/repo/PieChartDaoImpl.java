package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.PieChartModel;
import com.it.piv.mms.domain.PieChartModel.KeyValue;

@Transactional
@Repository
public class PieChartDaoImpl implements PieChartDao{
	
	@Autowired
	private EntityManager em;
	

	@Override
	public List<KeyValue> getPieChartData() {
		// TODO Auto-generated method stub
		return PieChartModel.getPieDataList();
	}

}
