package com.it.piv.mms.repo;

import java.util.ArrayList;
import java.util.List;

import com.it.piv.mms.domain.PieChartModel.KeyValue;

public interface PieChartDao {
	
	public List<KeyValue> getPieChartData();
}
