package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.Spstdestdmt;
import com.it.piv.mms.domain.Spstdesthmt;
@Transactional
@Repository
public class SpstdestdmtDaoImpl  implements SpstdestdmtDao{
	
	@Autowired
	private EntityManager em;
	

	@Override
	public List<Spstdestdmt> selectStdNoDeptId(String appNo, String deptid) {
		Query query = null;
		String qryStr ="";
		try {
			qryStr = "select a from Spstdestdmt a where trim(a.id.appNo) =:appNo and trim(a.deptId) =:deptid ";
			query = em.createQuery(qryStr);
			query.setParameter("appNo", appNo.trim());
			query.setParameter("deptid", deptid.trim());
			
			return query.getResultList();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
		
	}

}
