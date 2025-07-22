package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.EstimateReferenceb;
import com.it.piv.mms.domain.Pcesthtt;

@Transactional
@Repository
public class EstimateReferencebDaoImpl implements EstimateReferencebDao {
	@Autowired
	private EntityManager em;
	

	@Override
	public String save(EstimateReferenceb obj) {
		// TODO Auto-generated method stub
		em.persist(obj);
		return null;
	}


	@Override
	public List<EstimateReferenceb> findByEstimateNo(String estimateNo,
			String costCenter) {
		try{
			Query query=null;
			BigDecimal totalCost = null;
			String status = null;
			Double dbTotalCost=0.0;
			String qryStr = "SELECT p FROM EstimateReferenceb p  WHERE TRIM(p.id.westimateNo;)=:estimateNo  AND TRIM(p.id.deptId;)= :deptId";
					
			query = em.createQuery(qryStr);
			query.setParameter("estimateNo", estimateNo.trim());
			query.setParameter("deptId", costCenter);
			return query.getResultList();
		
			}catch(Exception e){
				
			}
			
			return null;
		
	}

}
