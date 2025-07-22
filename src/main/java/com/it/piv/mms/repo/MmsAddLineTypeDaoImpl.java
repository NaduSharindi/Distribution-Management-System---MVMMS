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

import com.it.piv.mms.domain.MmsAddlinetype;

@Transactional
@Repository
public class MmsAddLineTypeDaoImpl implements MmsAddLineTypeDao {

	@Autowired
	private EntityManager em;
	@Resource
	private PlatformTransactionManager txManager;

	@Override
	@Transactional
	public String addLineType(MmsAddlinetype lineType) {
		try {
			System.out.println("add line type");
			em.persist(lineType);
			// em.flush();
		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return null;
	}

	@Override
	public List<MmsAddlinetype> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsAddlinetype> criteria = cb
				.createQuery(MmsAddlinetype.class);
		Root<MmsAddlinetype> lineType = criteria.from(MmsAddlinetype.class);

		criteria.select(lineType).orderBy(cb.asc(lineType.get("id")));

		return em.createQuery(criteria).getResultList();
	}

	@Override
	public List<MmsAddlinetype> findActiveTypes() {
		String status = "1";
		TypedQuery<MmsAddlinetype> query = em.createQuery("SELECT cd "
				+ "FROM MmsAddlinetype cd " + "WHERE cd.status= :status",
				MmsAddlinetype.class);
		query.setParameter("status", status.trim());
		System.out.print(query);
		return query.getResultList();
	}

	//edit anushka 2018-12-31---------------------------------------------------------------------------------------------------------------------
	@Override
	public void updateLineType(MmsAddlinetype obj) {
		em.merge(obj);
	}
	//--------------------------------------------------------------------------------------------------------------------------------------------
}
