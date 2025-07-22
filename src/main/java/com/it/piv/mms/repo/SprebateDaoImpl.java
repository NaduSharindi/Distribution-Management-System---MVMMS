package com.it.piv.mms.repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Sprebate;
import com.it.piv.mms.domain.SprebatePK;

@Transactional
@Repository

public class SprebateDaoImpl implements  SprebateDao{
	@Autowired
	private EntityManager em;
	

	@Override
	public Sprebate findById(SprebatePK pk) {
		// TODO Auto-generated method stub
		return em.find(Sprebate.class, pk);
	}

}
