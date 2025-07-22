package com.it.piv.mms.repo;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
import com.it.piv.mms.domain.MmsAddpoletype;

@Transactional
@Repository
public class MmsAddPoleTypeDeoImpl implements MmsAddPoleTypeDao{
	@Autowired
	private EntityManager em;
	@Resource
	private PlatformTransactionManager txManager;

	@Override
	@Transactional
	public String addPoleType(MmsAddpoletype poleType) {
		try {
			System.out.println("add pole type");
			em.persist(poleType);
			// em.flush();
		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return null;
	}

	@Override
	public List<MmsAddpoletype> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsAddpoletype> criteria = cb
				.createQuery(MmsAddpoletype.class);
		Root<MmsAddpoletype> poleType = criteria.from(MmsAddpoletype.class);

		criteria.select(poleType).orderBy(cb.asc(poleType.get("id")));

		return em.createQuery(criteria).getResultList();
	}

	@Override
	public List<MmsAddpoletype> findActiveTypes() {
		String status = "1";
		TypedQuery<MmsAddpoletype> query = em.createQuery("SELECT cd "
				+ "FROM MmsAddpoletype cd " + "WHERE cd.status= :status",
				MmsAddpoletype.class);
		query.setParameter("status", status.trim());
		System.out.print(query);
		return query.getResultList();
	}

	
	@Override
	public void updatePoleType(MmsAddpoletype obj) {
		em.merge(obj);
	}
	
	

}
