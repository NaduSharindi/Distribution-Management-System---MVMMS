package com.it.piv.issue.repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.issue.domain.Pcmiledate;
import com.it.piv.mms.domain.Pcmilem;
import com.it.piv.mms.domain.PcmilemPK;


@Transactional
@Repository

public class PcmilemDaoImpl implements  PcmilemDao{

	@Autowired
	private EntityManager em;
	
	@Override
	public void add(Pcmilem progress) {
		em.persist(progress);
	}

	@Override
	public void update(Pcmilem progress) {
		em.merge(progress);
	}

	@Override
	public void findByID(PcmilemPK pk) {
		em.find(Pcmilem.class, pk);
	}

	@Override
	public Pcmiledate findByPercentage(String percentage, String deptId) {
		// TODO Auto-generated method stub
		return null;
	}

}
