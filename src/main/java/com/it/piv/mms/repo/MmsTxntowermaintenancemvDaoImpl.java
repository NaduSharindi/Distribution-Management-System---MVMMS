package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsTxntowermaintenancemv;
import com.it.piv.mms.domain.MmsTxntowermaintenancemvPK;

@Transactional
@Repository
public class MmsTxntowermaintenancemvDaoImpl implements MmsTxntowermaintenancemvDao  {
	
	@Autowired
	private EntityManager em;
	

	@Override
	public String addTowerMaintananceData(
			MmsTxntowermaintenancemv towermaintenance) {
		em.persist(towermaintenance);
		return null;
	}

	@Override
	public String update(MmsTxntowermaintenancemv towermaintenance) {
		em.merge(towermaintenance);
		return null;
	}

	@Override
	public MmsTxntowermaintenancemv findById(
			MmsTxntowermaintenancemvPK towermaintenance) {
		// TODO Auto-generated method stub
		return em.find(MmsTxntowermaintenancemv.class, towermaintenance);
	}

	
}
