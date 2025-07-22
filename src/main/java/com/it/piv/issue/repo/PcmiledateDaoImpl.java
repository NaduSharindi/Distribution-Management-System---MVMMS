package com.it.piv.issue.repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.issue.domain.Pcmiledate;
import com.it.piv.issue.domain.PcmiledatePK;

@Transactional
@Repository
public class PcmiledateDaoImpl implements PcmiledateDao{

	
	@Autowired
	private EntityManager em;
	
	@Override
	public void add(Pcmiledate progress) {
		em.persist(progress);
		
	}

	@Override
	public void update(Pcmiledate progress) {
		em.merge(progress);
	}

	@Override
	public void findByID(PcmiledatePK pk) {
		em.find(Pcmiledate.class, pk);
		
	}

	
}
