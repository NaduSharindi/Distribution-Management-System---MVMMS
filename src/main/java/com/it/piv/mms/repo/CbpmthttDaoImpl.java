package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Cbpmthtt;

@Transactional
@Repository
public class CbpmthttDaoImpl implements CbpmthttDao{
	
	@Autowired
	private EntityManager em;

	@Override
	public Long getApprovalList(String userName) {
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			//"select * from cbpmthtt where apprv_uid1 ='DGMWPN' and status = 3"
			
			qryStr = "select count(c.id.docNo) from Cbpmthtt c where trim(c.apprvUid1)=:userName and c.status=3";
		    query = em.createQuery(qryStr);
		    query.setParameter("userName",userName);
			
			return (Long)query.getSingleResult();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
return null;

	}

	@Override
	public List<Object[]> getApprovalListDetail(String userName,String deptId,String doc_pf) {
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			//"select * from cbpmthtt where apprv_uid1 ='DGMWPN' and status = 3"
			
			qryStr = "select c.id.docNo,c.payee,(select b.deptNm from Gldeptm b  where b.deptId =c.id.deptId) from Cbpmthtt c where trim(c.apprvUid1)=:userName and c.status=3 and c.id.deptId=:deptId and trim(c.id.docPf)=:docPf  ORDER BY c.id.deptId";
		    query = em.createQuery(qryStr);
		    query.setParameter("userName",userName);
		    query.setParameter("deptId",deptId);
		    query.setParameter("docPf",doc_pf.trim());
			
			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
return null;

	}

	@Override
	public List<Object[]> getApprovalListCount(String userName) {
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			//"select * from cbpmthtt where apprv_uid1 ='DGMWPN' and status = 3"
			
			qryStr = "select count(c.id.docNo),(select b.deptNm from Gldeptm b  where b.deptId =c.id.deptId),c.id.deptId,c.id.docPf from Cbpmthtt c where trim(c.apprvUid1)=:userName and c.status=3 GROUP BY c.id.deptId,c.id.docPf";
		    query = em.createQuery(qryStr);
		    query.setParameter("userName",userName);
			
			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
return null;

	}

	@Override
	public List<Cbpmthtt> getApprovalListDetailCbpmt(String userName,
			String deptId) {
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			//"select * from cbpmthtt where apprv_uid1 ='DGMWPN' and status = 3"
			
			qryStr = "select c from Cbpmthtt c where trim(c.apprvUid1)=:userName and c.status=3 and c.id.deptId=:deptId ORDER BY c.id.deptId";
		    query = em.createQuery(qryStr);
		    query.setParameter("userName",userName);
		    query.setParameter("deptId",deptId);
			
			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
return null;

	}

	@Override
	public void updatePaySlip(String docNo) {
		System.out.println("updatePaySlipdocNo : " +docNo);
		// TODO Auto-generated method stub
		try {
	    	Query  query = em.createQuery("UPDATE Cbpmthtt mp set mp.status =2" + " WHERE trim(mp.id.docNo)=:id");
		    query.setParameter("id", docNo.trim());
		    query.executeUpdate();
	    } catch (Exception ex) {
	    	System.out.println("updatePaySlip : " +ex);
	    }

	}
	

}
