package com.it.piv.mms.repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.PcbCondition;

@Transactional
@Repository
public class PcbConditionDaoImpl implements PcbConditionDao {

	@Autowired
	private EntityManager em;

	@Override
	public PcbCondition findConditionByEquipmentId(String equipmentId) {
		return em.find(PcbCondition.class, equipmentId);
	}

	@Override
	public String addCondition(PcbCondition pcbCondition) {
		em.persist(pcbCondition);
		return null;
	}

	@Override
	public String updateCondition(PcbCondition pcbCondition) {
		em.merge(pcbCondition);
		return null;
	}

}