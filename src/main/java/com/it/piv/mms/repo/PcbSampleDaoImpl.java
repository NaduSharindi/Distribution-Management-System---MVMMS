package com.it.piv.mms.repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.PcbSample;

@Transactional
@Repository
public class PcbSampleDaoImpl implements PcbSampleDao {

	@Autowired
	private EntityManager em;

	@Override
	public String addInformationReatedSample(PcbSample pcbSample) {
		em.persist(pcbSample);
		return null;
	}

	@Override
	public PcbSample findSampleByEquipmentId(String equipmentId) {
		return em.find(PcbSample.class, equipmentId);
	}

	@Override
	public String addSample(PcbSample pcbSample) {
		em.persist(pcbSample);
		return null;
	}

	@Override
	public String updateSample(PcbSample pcbSample) {
		em.merge(pcbSample);
		return null;
	}

}
