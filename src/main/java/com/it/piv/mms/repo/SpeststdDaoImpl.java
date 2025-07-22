package com.it.piv.mms.repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


//import com.it.piv.mms.domain.Spestedy;
//import com.it.piv.mms.domain.SpestedyPK;
import com.it.piv.mms.domain.Speststd;
import com.it.piv.mms.domain.SpeststdPK;

@Transactional
@Repository
public class SpeststdDaoImpl implements SpeststdDao  {

	@Autowired
	private EntityManager em;

	@Override
	public Speststd findById(SpeststdPK pk) {
		// TODO Auto-generated method stub
		return em.find(Speststd.class, pk);
	}

}
