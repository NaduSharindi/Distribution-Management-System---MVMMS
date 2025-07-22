package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsAddsupport;
import com.it.piv.mms.domain.MmsMntplan;

@Transactional
@Repository
public class MmsMntplanDaoImpl implements MmsMntplanDao{

	@Autowired
	private EntityManager em;
	
	@Override
	public String save(MmsMntplan obj) {
		// TODO Auto-generated method stub
		em.persist(obj);
		return null;
	}

	@Override
	public List<MmsMntplan> getActiveList(String year,String deptId) {
		try {
			String qryStr = "select s from MmsMntplan s where s.status=2 order by s.area";
		//	String qryStr = "select * from MmsAddsupport s, MmsTowermaintenance t where s.towerNo=t.id.towerId";
			Query query = em.createQuery(qryStr);
			//query.setParameter("year", year);
			//query.setParameter("deptId", deptId);
			List<MmsMntplan> list = query.getResultList();
			return list;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
