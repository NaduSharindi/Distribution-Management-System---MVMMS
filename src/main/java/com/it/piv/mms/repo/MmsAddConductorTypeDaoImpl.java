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

import com.it.piv.mms.domain.MmsAddconductortype;
import com.it.piv.mms.domain.MmsCsc;

@Transactional
@Repository
public class MmsAddConductorTypeDaoImpl implements MmsAddConductorTypeDao {
	
	@Autowired
	private EntityManager em;
	@Resource
	private PlatformTransactionManager txManager;

	@Override
	public String addConductorType(MmsAddconductortype conductorType) {
		//DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	    //TransactionStatus status = txManager.getTransaction(def);
	    //def.setName("SomeTxName");
	    //def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	   // try {
	    	em.persist(conductorType);
	   // } catch (Exception ex) {
	    	//System.out.println(ex);
	       // txManager.rollback(status);
	    //}
	   // txManager.commit(status);
	   

	    //em.persist(conductorType);
		return null;
	}

	@Override
	public List<MmsAddconductortype> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsAddconductortype> criteria = cb.createQuery(MmsAddconductortype.class);
		Root<MmsAddconductortype> conductorType = criteria.from(MmsAddconductortype.class);
		
		criteria.select(conductorType).orderBy(cb.asc(conductorType.get("id")));
		
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public List<MmsAddconductortype> findActiveConductorTypes() {
		String status = "1";
		TypedQuery<MmsAddconductortype> query =
				em.createQuery
				("SELECT cd "
				+ "FROM MmsAddconductortype cd "
				+ "WHERE cd.status= :status", MmsAddconductortype.class) ;
					 query.setParameter("status",status.trim()); 
					 System.out.print(query);
					return query.getResultList();
	}
	
	//edit anushka 2019-01-01---------------------------------------------------------------------------------------------------------------------
	@Override
	public void updateConductorType(MmsAddconductortype obj) {
		em.merge(obj);		
	}
	//--------------------------------------------------------------------------------------------------------------------------------------------
}
