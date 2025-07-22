package com.it.piv.issue.repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.issue.domain.Pcmilesumary;
import com.it.piv.issue.domain.PcmilesumaryPK;

@Transactional
@Repository
public class PcmilesumaryDaoImpl implements PcmilesumaryDao{

	@Autowired
	private EntityManager em;
	
	
	@Override
	public void add(Pcmilesumary progress) {
		em.persist(progress);
		
	}

	@Override
	public void update(Pcmilesumary progress) {
		em.merge(progress);
	}

	@Override
	public void findByID(PcmilesumaryPK pk) {
		em.find(Pcmilesumary.class, pk);
		
	}

}
