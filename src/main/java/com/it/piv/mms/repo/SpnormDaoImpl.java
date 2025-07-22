package com.it.piv.mms.repo;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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

import com.it.piv.mms.domain.Spnorm;

@Transactional
@Repository
public class SpnormDaoImpl implements SpnormDao{

	@Autowired
	private EntityManager em;
	//@Resource
	//private PlatformTransactionManager txManager; 
	
	@Override
	public String saveForm(Spnorm spnorm) {
		//DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	    //TransactionStatus status = txManager.getTransaction(def);
	    //def.setName("SomeTxName");
	    //def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	    //try {
	    	em.persist(spnorm);
	   // } catch (Exception ex) {
	    	//System.out.println(ex);
	       // txManager.rollback(status);
	   // }
	  //  txManager.commit(status);
	   

	  //  em.persist(spnorm);
		return null;
	}

	@Override
	public List<Spnorm> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Spnorm> criteria = cb.createQuery(Spnorm.class);
		Root<Spnorm> spnorm = criteria.from(Spnorm.class);
		
		criteria.select(spnorm).orderBy(cb.asc(spnorm.get("linesectiontypeid")));
		
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public void updateSPNORM(String linesectiontypeid, String uom,double standardcost, String description, String lineparentid) {
		System.out.println("Spnorm Dao Impl");
		//DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	   // TransactionStatus sta = txManager.getTransaction(def);
	    //def.setName("SomeTxName");
	   // def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	    try {
	    	Query  query = em.createQuery("UPDATE Spnorm sp set sp.uom =:uom,sp.standardcost =:standardcost,sp.description =:description,sp.lineparentid =:lineparentid "+" WHERE sp.linesectiontypeid = :linesectiontypeid");
		    query.setParameter("linesectiontypeid", linesectiontypeid);
		    query.setParameter("uom", uom);
		    query.setParameter("standardcost", standardcost);
		    query.setParameter("description", description);
		    query.setParameter("lineparentid", lineparentid);
		    System.out.print(query);
		    query.executeUpdate();
		    System.out.println("Spnorm Dao Impl 1");
	    } catch (Exception ex) {
	    	
	    	System.out.println("Spnorm Dao Impl" +ex);
	      //  txManager.rollback(sta);
	    }
	  //  txManager.commit(sta);
		
	}

}
