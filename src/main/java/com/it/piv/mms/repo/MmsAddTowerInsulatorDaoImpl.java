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

import com.it.piv.mms.domain.MmsAddtowerinsulator;

@Transactional
@Repository
public class MmsAddTowerInsulatorDaoImpl implements MmsAddTowerInsulatorDao{

	@Autowired
	private EntityManager em;
	@Resource
	private PlatformTransactionManager txManager;
	
	@Override
	public String addTowerInsulator(MmsAddtowerinsulator towerInsulator) {
		//DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	   // TransactionStatus status = txManager.getTransaction(def);
	  //  def.setName("SomeTxName");
	   // def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	   // try {
	    	em.persist(towerInsulator);
	   // } catch (Exception ex) {
	    //	System.out.println(ex);
	      //  txManager.rollback(status);
	    //}
	   // txManager.commit(status);
	   

	   // em.persist(towerInsulator);
	
		return null;
	}

	@Override
	public List<MmsAddtowerinsulator> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsAddtowerinsulator> criteria = cb.createQuery(MmsAddtowerinsulator.class);
		Root<MmsAddtowerinsulator> towerInsulator = criteria.from(MmsAddtowerinsulator.class);
		
		criteria.select(towerInsulator).orderBy(cb.asc(towerInsulator.get("id")));
		
		return em.createQuery(criteria).getResultList();
	}

	//edit anushka 2019-01-01-----------------------------------------------------------------------------------------------
	@Override
	public void updateTowerInsulatorType(MmsAddtowerinsulator obj) {
		em.merge(obj);		
		
	}
	//----------------------------------------------------------------------------------------------------------------------
}
