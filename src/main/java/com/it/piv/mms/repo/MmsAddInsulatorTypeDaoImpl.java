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

import com.it.piv.mms.domain.MmsAddinsulatortype;

@Transactional
@Repository
public class MmsAddInsulatorTypeDaoImpl implements MmsAddInsulatorTypeDao{

	@Autowired
	private EntityManager em;
	@Resource
	private PlatformTransactionManager txManager;
	
	@Override
	public String addInsulatorType(MmsAddinsulatortype insulatorType) {
		//DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	    //TransactionStatus status = txManager.getTransaction(def);
	    //def.setName("SomeTxName");
	   // def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	    //try {
	    	em.persist(insulatorType);
	   // } catch (Exception ex) {
	    	//System.out.println(ex);
	       // txManager.rollback(status);
	   // }
	  //  txManager.commit(status);
	   

	   // em.persist(insulatorType);
		return null;
	}

	@Override
	public List<MmsAddinsulatortype> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsAddinsulatortype> criteria = cb.createQuery(MmsAddinsulatortype.class);
		Root<MmsAddinsulatortype> insulatorType = criteria.from(MmsAddinsulatortype.class);
		
		criteria.select(insulatorType).orderBy(cb.asc(insulatorType.get("id")));
		
		return em.createQuery(criteria).getResultList();
	}

	//edit anushka 2019-01-01-----------------------------------------------------------------------------------------------------
	@Override
	public void updateInsulatorType(MmsAddinsulatortype obj) {
		em.merge(obj);		
		
	}
	//----------------------------------------------------------------------------------------------------------------------------
}
