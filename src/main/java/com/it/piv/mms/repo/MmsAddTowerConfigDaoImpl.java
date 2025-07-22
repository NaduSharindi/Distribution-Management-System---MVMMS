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

import com.it.piv.mms.domain.MmsAddtowerconfiguration;

@Transactional
@Repository
public class MmsAddTowerConfigDaoImpl implements MmsAddTowerConfigDao{
	
	@Autowired
	private EntityManager em;
	@Resource
	private PlatformTransactionManager txManager;

	@Override
	public String addTowerConfiguration(MmsAddtowerconfiguration towerConfiguration) {
		//DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	   // TransactionStatus status = txManager.getTransaction(def);
	   // def.setName("SomeTxName");
	  //  def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	  //  try {
	    	em.persist(towerConfiguration);
	  //  } catch (Exception ex) {
	    //	System.out.println(ex);
	     //   txManager.rollback(status);
	  //  }
	  //  txManager.commit(status);
	   

	//em.persist(towerConfiguration);
		
		return null;
	}

	@Override
	public List<MmsAddtowerconfiguration> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsAddtowerconfiguration> criteria = cb.createQuery(MmsAddtowerconfiguration.class);
		Root<MmsAddtowerconfiguration> towerConfiguration = criteria.from(MmsAddtowerconfiguration.class);
		
		criteria.select(towerConfiguration).orderBy(cb.asc(towerConfiguration.get("id")));
		
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public List<MmsAddtowerconfiguration> findActiveConfigurations() {
		String status = "1";
		TypedQuery<MmsAddtowerconfiguration> query =
				em.createQuery
				("SELECT cd "
				+ "FROM MmsAddtowerconfiguration cd "
				+ "WHERE cd.status= :status", MmsAddtowerconfiguration.class) ;
					 query.setParameter("status",status.trim()); 
					 System.out.print(query);
					return query.getResultList();
	}

	//edit anushka 2019-01-01--------------------------------------------------------------------------------------------------
	@Override
	public void updateTowerConfigurationType(MmsAddtowerconfiguration obj) {
		em.merge(obj);		
		
	}
	//-------------------------------------------------------------------------------------------------------------------------
}
