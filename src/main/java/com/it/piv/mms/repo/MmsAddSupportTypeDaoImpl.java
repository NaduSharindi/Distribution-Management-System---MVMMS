package com.it.piv.mms.repo;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
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

import com.it.piv.mms.domain.MmsAddlinetype;
import com.it.piv.mms.domain.MmsAddsupporttype;


@Transactional
@Repository
public class MmsAddSupportTypeDaoImpl implements MmsAddSupportTypeDao{
	
	@Autowired
	private EntityManager em;
	@Resource
	private PlatformTransactionManager txManager;

	@Override
	public String addSupportType(MmsAddsupporttype supportType) {
		//DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	    //TransactionStatus status = txManager.getTransaction(def);
	    //def.setName("SomeTxName");
	    //def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	    //try {
	    	em.persist(supportType);
	    //} catch (Exception ex) {
	    	//System.out.println(ex);
	       // txManager.rollback(status);
	    //}
	   // txManager.commit(status);
	   

	    //em.persist(supportType);
		
		return null;
	}

	@Override
	public List<MmsAddsupporttype> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsAddsupporttype> criteria = cb.createQuery(MmsAddsupporttype.class);
		Root<MmsAddsupporttype> supportType = criteria.from(MmsAddsupporttype.class);
		
		criteria.select(supportType).orderBy(cb.asc(supportType.get("id")));
		
		return em.createQuery(criteria).getResultList();
	}
	
	//edit anushka 2019-01-01---------------------------------------------------------------------------------------------------------------------
	@Override
	public void updateSupportType(MmsAddsupporttype obj) {
		em.merge(obj);		
	}
	//--------------------------------------------------------------------------------------------------------------------------------------------

}
