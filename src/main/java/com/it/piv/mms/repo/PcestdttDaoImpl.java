package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Pcestdtt;
import com.it.piv.mms.domain.Pcesthtt;

@Transactional
@Repository
public class PcestdttDaoImpl implements PcestdttDao{
	@Autowired
	private EntityManager em;
	
	@Override
	public void save(Pcestdtt obj) {
		// TODO Auto-generated method stub
		em.persist(obj);
		
	}
	
	@Override
	public List<Pcestdtt> getPcestdtt(String estimateNo, String deptId) {
		// TODO Auto-generated method stub
		try{
		Query query=null;
		BigDecimal totalCost = null;
		String status = null;
		Double dbTotalCost=0.0;
		String qryStr = "SELECT p FROM Pcestdtt p  WHERE TRIM(p.id.estimateNo)=:estimateNo  AND p.id.deptId= :deptId";
				
		query = em.createQuery(qryStr);
		query.setParameter("estimateNo", estimateNo.trim());
		query.setParameter("deptId", deptId);
		return query.getResultList();
	
		}catch(Exception e){
			
		}
		
		return null;
	}
	
	
	@Override
	public List<Object[]> getPcestdttNew(String estimateNo, String deptId) {
		// TODO Auto-generated method stub
		try{
		Query query=null;
		BigDecimal totalCost = null;
		String status = null;
		Double dbTotalCost=0.0;
		String qryStr = "SELECT p,(select a.matNm from Inwrhmap a where trim(a.matCd) = p.resCd) FROM Pcestdtt p  WHERE TRIM(p.id.estimateNo)=:estimateNo  AND TRIM(p.id.deptId)= :deptId";
				
		query = em.createQuery(qryStr);
		query.setParameter("estimateNo", estimateNo.trim());
		query.setParameter("deptId", deptId);
		return query.getResultList();
	
		}catch(Exception e){
			
		}
		
		return null;
	}

	
	

	@Override
	public void save(List<Pcestdtt> obj) {
		if(obj !=null){
			for(int i = 0 ; i <obj.size() ;i++){
				
			}
			
		}
		// TODO Auto-generated method stub
		
	}

	/**@Override
	public String save(List<Pcestdtt> obj) {
		// TODO Auto-generated method stub
		int length = obj.size();
		if(int i =0;)
		return null;
	}*/

}
