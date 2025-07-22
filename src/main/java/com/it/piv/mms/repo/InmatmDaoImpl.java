package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository

public class InmatmDaoImpl implements InmatmDao{
	
	@Autowired
	private EntityManager em;


	@Override
	public String getName(String code) {
		try {
			
			String qryStr ="";
			Query query = null;
			
			qryStr = "select a.matNm from Inmatm a where trim(a.matCd) =:code";
		    query = em.createQuery(qryStr);
		    query.setParameter("code",code.trim());
			
			return (String)query.getResultList().get(0);


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
return null;
	}

}
