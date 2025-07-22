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

import com.it.piv.mms.domain.MmsTowertype;


@Transactional
@Repository
public class MsttowertypeImpl implements MsttowertypeDao{
	
	@Autowired
	private EntityManager em;
	//@Resource
	//private PlatformTransactionManager txManager; 
	
	

	@Override
	public String addTowerTypw(MmsTowertype towerType) {
		// TODO Auto-generated method stub
		System.out.println("Test2" + towerType.getId());
		System.out.println("Test2" + towerType.getName());
		    
		// DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		  //  TransactionStatus status = txManager.getTransaction(def);
		  //  def.setName("SomeTxName");
		 //   def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		  //  try {
		    	em.persist(towerType);
		 //   } catch (Exception ex) {
		    //	System.out.println(ex);
		      //  txManager.rollback(status);
		   // }
		  //  txManager.commit(status);
		   

		//em.persist(towerType);
		return null;
	}



	@Override
	public List<MmsTowertype> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsTowertype> criteria = cb.createQuery(MmsTowertype.class);
		Root<MmsTowertype> support = criteria.from(MmsTowertype.class);
		
		criteria.select(support).orderBy(cb.asc(support.get("id")));
		
		return em.createQuery(criteria).getResultList();
	}
	

}
