package com.it.piv.mms.repo;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

//import com.it.piv.issue.domain.PivAmount;
import com.it.piv.mms.domain.MmsTowermaintenance;
import com.it.piv.mms.domain.MmsTowermaintenancePK;
import com.it.piv.mms.domain.TowerModel;

@Transactional
@Repository
public class MmsTowermaintenanceDaoImpl implements MmsTowermaintenanceDao {
	
	@Autowired
	private EntityManager em;
	//@Resource
	//private PlatformTransactionManager txManager;

	@Override
	public String addTowerMaintananceData(MmsTowermaintenance towermaintenance) {
		em.persist(towermaintenance);
	 	return null;
	}

	@Override
	public List<MmsTowermaintenance> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsTowermaintenance> criteria = cb.createQuery(MmsTowermaintenance.class);
		Root<MmsTowermaintenance> towerMaintenance = criteria.from(MmsTowermaintenance.class);
		
		criteria.select(towerMaintenance).orderBy(cb.asc(towerMaintenance.get("id")));
		
		return em.createQuery(criteria).getResultList();
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<MmsTowermaintenance> findAllByArea(String area) {
		System.out.println("area :" + area);
		//CriteriaBuilder builder = em.getCriteriaBuilder();
		//CriteriaQuery<MmsTowermaintenance> criteria = builder
				//.createQuery(MmsTowermaintenance.class);
		//Root<MmsTowermaintenance> tm = criteria.from(MmsTowermaintenance.class);

		/*
		 * Swap criteria statements if you would like to try out type-safe
		 * criteria queries, a new feature in JPA 2.0
		 * criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		 */

		//criteria.select(tm).where(builder.equal(tm.get("area"), area));
		//return em.createQuery(criteria).getResultList();
		
		try {
        	String qryStr = "select p from MmsTowermaintenance p where p.area = :area";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			//query.setParameter("lineId", line);
			List<MmsTowermaintenance> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		
	}
	
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<MmsTowermaintenance> findAllByAreaLine(String area,String lineId) {
		System.out.println("area :" + area);
		//CriteriaBuilder builder = em.getCriteriaBuilder();
		//CriteriaQuery<MmsTowermaintenance> criteria = builder
				//.createQuery(MmsTowermaintenance.class);
		//Root<MmsTowermaintenance> tm = criteria.from(MmsTowermaintenance.class);

		/*
		 * Swap criteria statements if you would like to try out type-safe
		 * criteria queries, a new feature in JPA 2.0
		 * criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		 */

		//criteria.select(tm).where(builder.equal(tm.get("area"), area));
		//return em.createQuery(criteria).getResultList();
		
		try {
        	String qryStr = "select p from MmsTowermaintenance p where p.area = :area and p.lineId = :lineId";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", lineId);
			List<MmsTowermaintenance> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		
	}
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<TowerModel> findTowerMntByArea(String area) {
		// TODO Auto-generated method stub
		try {
        	String qryStr = "select a ,b.towerNo,b.area,b.csc,c.code  from MmsTowermaintenance a,MmsAddsupport b , MmsAddline c  where a.id.towerId = b.id and b.lineId = c.id and b.area =:area";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			
			List<TowerModel> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public String getTowerIDByTowerNo(String towerNo) {
		// TODO Auto-generated method stub
		try {
        	String qryStr = "select a.id.towerId  from MmsTowermaintenance a where a.towerNo = :towerNo";
        	System.out.println(qryStr + towerNo);
        	Query query = em.createQuery(qryStr);
			query.setParameter("towerNo", towerNo);
			String towerNumber ="";
			List<String> list=query.getResultList();
	    	if (list.size()!=0){
	    		towerNumber=query.getResultList().get(0).toString().trim();
	    		System.out.println(towerNumber);
	    		
	    	}
			return towerNumber;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public String update(MmsTowermaintenance towermaintenance) {
		em.merge(towermaintenance);
		return null;
	}

	@Override
	public MmsTowermaintenance findByID(MmsTowermaintenancePK id) {
		// TODO Auto-generated method stub
		return em.find(MmsTowermaintenance.class, id);
	}

}
