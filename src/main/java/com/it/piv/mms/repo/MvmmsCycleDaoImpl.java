package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsTowertype;
import com.it.piv.mms.domain.MmsTxntowermaintenance;
import com.it.piv.mms.domain.MvmmsCycle;

@Transactional
@Repository
public class MvmmsCycleDaoImpl implements MvmmsCycleDao{
	
	@Autowired
	private EntityManager em;

	@Override
	public void addCycle(MvmmsCycle cycle) {
		// TODO Auto-generated method stub
		em.persist(cycle);
		//return null;
	}

	@Override
	public List<MvmmsCycle> findAllCycle(String dept_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MvmmsCycle> findAllCycle() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MvmmsCycle> criteria = cb.createQuery(MvmmsCycle.class);
		Root<MvmmsCycle> support = criteria.from(MvmmsCycle.class);
		
		criteria.select(support).orderBy(cb.asc(support.get("cycleOrder")));
		
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public void update(MvmmsCycle cycle) {
		// TODO Auto-generated method stub
		em.merge(cycle);
	}

	@Override
	public List<MvmmsCycle> findAllActiveCycle(String deptId) {
		try {
			String qryStr = "select a from MvmmsCycle a where a.id.deptId =:deptId and a.status = 1 order by a.cycleOrder";
			Query query = em.createQuery(qryStr);
			query.setParameter("deptId",deptId);
			return query.getResultList();
			//System.out.println("list : "+ list);
			//return list.get(0);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public String findLatestCycle() {
		String cycle="201801";
		try {
			String qryStr = "select a.id.cycleId from MvmmsCycle a where a.status = 1 and a.cycleOrder = 1 order by a.cycleOrder";
			Query query = em.createQuery(qryStr);
			if(query.getResultList() != null){
				cycle = query.getResultList().get(0).toString();
			}else{
				cycle = "201801";
			}
			return cycle;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}	
		
	}

	@Override
	public List<Long> findAllActiveCycleString() {
		try {
			String qryStr = "select a.id.cycleId from MvmmsCycle a where a.status = 1 and a.cycleName NOT LIKE '201801' order by a.cycleOrder";
			Query query = em.createQuery(qryStr);
			//query.setParameter("deptId",deptId);
			return (List<Long>)query.getResultList();
			//System.out.println("list : "+ list);
			//return list.get(0);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Long>  fineMntAvailCycle(String area) {
		// TODO Auto-generated method stub
		//select distinct visitid from MMS_TXNTOWERMAINTENANCE a , MMS_ADDSUPPORT b where a.TOWERID = b.id and b.status= 1 and b.area ='431.00' and (visitid like '201%' or visitid like '202%') and visitid <> '201' and visitid <> '202'
		try {
			String qryStr = "select a.id.visitid from MmsTxntowermaintenance a , MmsAddsupport b  where  a.id.towerid = b.id and b.status = 1 and b.area =:area "+
		    "and (a.id.visitid like '201%' or a.id.visitid like '202%') and a.id.visitid <> '201' and a.id.visitid <> '202' and a.status=1 order by a.insDate ASC";
			Query query = em.createQuery(qryStr);
			query.setParameter("area",area);
			return (List<Long>)query.getResultList();
			//System.out.println("list : "+ list);
			//return list.get(0);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}	}
	

	

}
