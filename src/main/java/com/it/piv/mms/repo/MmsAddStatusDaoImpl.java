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

import com.it.piv.mms.domain.MmsAddstatus;

@Transactional
@Repository
public class MmsAddStatusDaoImpl implements MmsAddStatusDao{
	
	@Autowired
	private EntityManager em;
	@Resource
	private PlatformTransactionManager txManager;
	
	@Override
	public String addStatus(MmsAddstatus addStatus) {
		//DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	   // TransactionStatus status = txManager.getTransaction(def);
	   // def.setName("SomeTxName");
	   // def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	   // try {
	    	em.persist(addStatus);
	   // } catch (Exception ex) {
	    	//System.out.println(ex);
	       // txManager.rollback(status);
	    //}
	   // txManager.commit(status);
	   

	   // em.persist(addStatus);
		return null;
	}

	@Override
	public List<MmsAddstatus> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsAddstatus> criteria = cb.createQuery(MmsAddstatus.class);
		Root<MmsAddstatus> status = criteria.from(MmsAddstatus.class);
		
		criteria.select(status).orderBy(cb.asc(status.get("id")));
		
		return em.createQuery(criteria).getResultList();
	}

	//edit anushka 2019-01-02-------------------------------------------------------------------------------------------------------------------------------------
	public void updateStatus(MmsAddstatus obj) {
		em.merge(obj);		
		
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
}
