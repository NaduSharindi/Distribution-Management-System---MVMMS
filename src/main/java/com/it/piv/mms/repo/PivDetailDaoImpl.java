package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Pcesthtt;
import com.it.piv.mms.domain.PivDetail;

@Transactional
@Repository
public class PivDetailDaoImpl implements PivDetailDao{
	
	@Autowired
	private EntityManager em;
	

	@Override
	public List<PivDetail> findByReferenceNo(String referenceNo, String deptId) {
		try{
			Query query=null;
			BigDecimal totalCost = null;
			String status = null;
			Double dbTotalCost=0.0;
			String qryStr = "SELECT p FROM PivDetail p  WHERE p.referenceNo=:estimateNo AND p.id.deptId= :deptId ";
					
			query = em.createQuery(qryStr);
			query.setParameter("estimateNo", referenceNo.trim());
			query.setParameter("deptId", deptId);
			return query.getResultList();
		
			}catch(Exception e){
				System.out.println("test : "+e);
			}
			
			return null;
	}
	
}
