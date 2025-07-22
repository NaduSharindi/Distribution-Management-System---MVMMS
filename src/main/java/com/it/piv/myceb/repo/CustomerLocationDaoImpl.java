package com.it.piv.myceb.repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.myceb.domain.DmCustomerlocation;

@Transactional
@Repository
public class CustomerLocationDaoImpl implements CustomerLocationDao{
	
	@Autowired
	private EntityManager em;

	@Override
	public String save(DmCustomerlocation obj) {
		em.persist(obj);
		return null;
	}

}
