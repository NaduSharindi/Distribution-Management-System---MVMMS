package com.it.piv.mms.repo;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.it.piv.mms.domain.MmsAddearthconductortype;

@Transactional
@Repository
public class MmsAddEarthConductorTypeDaoImpl implements MmsAddEarthConductorTypeDao {

	@Autowired
	private EntityManager em;
	@Resource
	private PlatformTransactionManager txManager;
	
	@Override
	public String addEarthConType(MmsAddearthconductortype earthConType) {
		//DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	    //TransactionStatus status = txManager.getTransaction(def);
	    //def.setName("SomeTxName");
	    //def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	    //try {
	    	em.persist(earthConType);
	    //} catch (Exception ex) {
	    	//System.out.println(ex);
	       // txManager.rollback(status);
	   // }
	   // txManager.commit(status);
	   

	//em.persist(earthConType);
		return null;
	}

	@Override
	public List<MmsAddearthconductortype> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsAddearthconductortype> criteria = cb.createQuery(MmsAddearthconductortype.class);
		Root<MmsAddearthconductortype> earthConType = criteria.from(MmsAddearthconductortype.class);
		
		criteria.select(earthConType).orderBy(cb.asc(earthConType.get("id")));
		
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public List<MmsAddearthconductortype> findActiveEarth() {
		String status = "1";
		TypedQuery<MmsAddearthconductortype> query =
				em.createQuery
				("SELECT cd "
				+ "FROM MmsAddearthconductortype cd "
				+ "WHERE cd.status= :status", MmsAddearthconductortype.class) ;
					 query.setParameter("status",status.trim()); 
					 System.out.print(query);
					return query.getResultList();
	}

	//edit anushka 2019-01-01--------------------------------------------------------------------------------------------------------------------------
	@Override
	public void updateEarthConductorType(MmsAddearthconductortype obj) {
		em.merge(obj);		
	}
	//-------------------------------------------------------------------------------------------------------------------------------------------------
}
