package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.WiringLandDetail;
import com.it.piv.mms.domain.WiringLandDetailCon;


@Transactional
@Repository
public class WiringLandDetailDaoImpl implements WiringLandDetailDao {
	@Autowired
	private EntityManager em;
	@Override
	public String save(WiringLandDetail obj) {
		// TODO Auto-generated method stub
		em.persist(obj);
		return null;
	}
	
	@Override
	public WiringLandDetail selectStdNoDeptId(String appNo, String deptid) {
		Query query = null;
		String qryStr ="";
		try {
			qryStr = "select a from WiringLandDetail a where trim(a.id.applicationId) =:appNo and trim(a.id.deptId) =:deptid ";
			query = em.createQuery(qryStr);
			query.setParameter("appNo", appNo.trim());
			query.setParameter("deptid", deptid.trim());
			
			List<WiringLandDetail> list = query.getResultList();
			
			
			if(list.size()==0){
				return null;
			}else{
				return list.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
		
	}


}
