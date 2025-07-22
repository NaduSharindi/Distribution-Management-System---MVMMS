package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Applicant;

@Transactional
@Repository
public class ApplicantDaoImpl implements ApplicantDao {
	@Autowired
	private EntityManager em;
	
	@Override
	public List<Applicant> getAllApplicantBydeptId(String deptId) {
		String qryStr = "SELECT s FROM Applicant s WHERE TRIM(s.deptId)=:deptId";
		Query query = em.createQuery(qryStr);
		query.setParameter("deptId", deptId);
		return query.getResultList();
	}

	@Override
	public Applicant findById(String id) {
		// TODO Auto-generated method stub
		return em.find(Applicant.class, id);
	}
	
	
	

}
