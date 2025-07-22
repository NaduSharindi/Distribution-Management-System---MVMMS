package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Inmatm;
@Transactional
@Repository
public class InwrhmapDaoImpl implements InwrhmapDao {
	@Autowired
	private EntityManager em;


	@Override
	public List<Object[]> getWareHouse(String dept_id) {
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			
			qryStr = "select (select b.deptNm from Gldeptm b  where b.deptId =a.id.wrhDept), a.id.wrhDept from Inwrhmap a where trim(a.id.deptId) =:deptId";
		    query = em.createQuery(qryStr);
		    query.setParameter("deptId",dept_id.trim());
			
			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
return null;

	}


	@Override
	public List<Object[]> getWareHouseDetails(String dept_id) {
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			
			qryStr = "select a.id.matCd,b.matNm,a.id.gradeCd,b.majUom,a.qtyAlocatd,sum(a.qtyOnHand),a.unitPrice,sum(a.unitPrice * a.qtyOnHand),a.id.wrhCd from Inwrhmtm a , Inmatm b where  a.id.matCd =  b.matCd and trim(a.id.deptId) =:deptId and a.status=2 "+
			"GROUP BY a.id.matCd , a.id.wrhCd , b.matNm, a.id.gradeCd, b.majUom , a.qtyOnHand, a.unitPrice, a.matCost, a.qtyAlocatd "+
			"ORDER by a.id.matCd , a.id.wrhCd";
		    query = em.createQuery(qryStr);
		    query.setParameter("deptId",dept_id.trim());
			
			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
      return null;
	}


	@Override
	public List<Inmatm> getIsulatorList(String dept_id) {
		List<Object[]> list = null;
		try {
			
			String qryStr ="";
			Query query = null;
			
			qryStr = "select b from Inmatm b where b.matCd like 'C%' and b.status=2 ORDER by b.matCd";
		    query = em.createQuery(qryStr);
		    //query.setParameter("deptId",dept_id.trim());
			
			return query.getResultList();


			
		}catch(Exception e ){
			System.out.println("e :"+e);
		}
      return null;

	}

}
