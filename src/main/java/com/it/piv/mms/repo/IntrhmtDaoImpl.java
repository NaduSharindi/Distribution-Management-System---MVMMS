package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository

public class IntrhmtDaoImpl implements IntrhmtDao {
	@Autowired
	private EntityManager em;


	@Override
	public Long getApprovalList(String userName) {
		
		
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			qryStr = "select count(c.id.docNo) from Intrhmt c where trim(c.apprvUid1)=:userName and c.status=3 GROUP BY c.id.deptId,c.id.docPf";
		    query = em.createQuery(qryStr);
		    query.setParameter("userName",userName);
			
			return (Long)query.getSingleResult();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
return null;
	}


	@Override
	public List<Object[]> getApprovalListCount(String userName) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			qryStr = "select count(c.id.docNo),(select b.deptNm from Gldeptm b  where b.deptId =c.id.deptId),c.id.deptId,c.id.docPf,c.issueTo from Intrhmt c where trim(c.apprvUid1)=:userName and c.status=3 GROUP BY c.id.deptId,c.id.docPf,c.issueTo";
		    query = em.createQuery(qryStr);
		    query.setParameter("userName",userName);
			
			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
return null;

	}


	@Override
	public List<Object[]> getApprovalListDetail(String userName) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			qryStr = "select c.id.docNo,(select b.deptNm from Gldeptm b  where b.deptId =c.id.deptId),c.id.deptId,c.id.docPf,c.issueTo from Intrhmt c where trim(c.apprvUid1)=:userName and c.status=3 ORDER BY c.id.deptId,c.id.docPf,c.issueTo";
		    query = em.createQuery(qryStr);
		    query.setParameter("userName",userName);
			
			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
return null;

	}

}
