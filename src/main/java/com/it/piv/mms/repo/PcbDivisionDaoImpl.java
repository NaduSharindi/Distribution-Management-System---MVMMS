package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsAddsupport;
import com.it.piv.mms.domain.PCB_Division;

@Transactional
@Repository
public class PcbDivisionDaoImpl implements PcbDivisionDao{
	
	@Autowired
	private EntityManager em;


	@Override
	public List<PCB_Division> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PCB_Division> criteria = cb.createQuery(PCB_Division.class);
		Root<PCB_Division> support = criteria.from(PCB_Division.class);
		
		criteria.select(support).orderBy(cb.asc(support.get("id")));
		
		return em.createQuery(criteria).getResultList();
	}
	
	

}
