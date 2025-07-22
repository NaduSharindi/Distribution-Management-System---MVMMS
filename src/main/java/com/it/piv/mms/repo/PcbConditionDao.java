package com.it.piv.mms.repo;

import com.it.piv.mms.domain.PcbCondition;

;

public interface PcbConditionDao {

	public PcbCondition findConditionByEquipmentId(String equipmentId);

	public String addCondition(PcbCondition pcbCondition);

	public String updateCondition(PcbCondition pcbCondition);
}