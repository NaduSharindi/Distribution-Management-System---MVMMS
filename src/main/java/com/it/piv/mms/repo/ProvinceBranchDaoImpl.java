package com.it.piv.mms.repo;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ProvinceBranchDaoImpl implements ProvinceBranchDao{
	
	@Autowired
	private EntityManager em;


	@Override
	public String getBranchCode(String dept_id) {
		try {
			String qryStr = "SELECT s.id.branchCode FROM ProvinceBranch s WHERE TRIM(s.id.deptId)=:dept_id";
			Query query = em.createQuery(qryStr);
			query.setParameter("dept_id", dept_id.trim());
			System.out.println((String)query.getSingleResult());
			return (String)query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
