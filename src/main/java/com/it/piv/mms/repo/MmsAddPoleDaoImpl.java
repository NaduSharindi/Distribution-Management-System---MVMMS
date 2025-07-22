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

import com.it.piv.mms.domain.MmsAddpole;

@Transactional
@Repository
public class MmsAddPoleDaoImpl implements MmsAddPoleDao{
	
	@Autowired
	private EntityManager em;
	
	@Override
	public String addPole(MmsAddpole addPole) {
		em.persist(addPole);
        String id = String.valueOf(addPole.getId());
		
		return id;
	}
	
	@Override
	public List<MmsAddpole> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsAddpole> criteria = cb.createQuery(MmsAddpole.class);
		Root<MmsAddpole> insulatorType = criteria.from(MmsAddpole.class);
		
		criteria.select(insulatorType).orderBy(cb.asc(insulatorType.get("area")));
		
		return em.createQuery(criteria).getResultList();
	}
	@Override
	public List<MmsAddpole> findPoleByAreaEdit(String area, String status) {
		try {
			area = area.trim();
        	
			String qryStr = "select p from MmsAddpole p where p.area =:area and p.status=:status ORDER BY p.poleNo ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("status", new BigDecimal (status));
			List<MmsAddpole> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public MmsAddpole findById(long id) {
		return em.find(MmsAddpole.class, id);
	}
	@Override
	public String update(MmsAddpole addPole) {
		System.out.println("update");
		em.merge(addPole);
		return null;
	}
	
	
	@Override
	public List<MmsAddpole> findLVPoleByStatus(String status, String phmBranch) {
	try {
	System.out.println("status : "+status);
	String qryStr = "select p from MmsAddpole p where p.status =:status ORDER BY p.id ";
	Query query = em.createQuery(qryStr);
	query.setParameter("status", new BigDecimal(status));
	//query.setParameter("phmbranch", phmBranch);
	List<MmsAddpole> list = query.getResultList();
	return list;
	        } catch (Exception ex) {
	ex.printStackTrace();
	return null;
	}
	}

	@Override
	public List<MmsAddpole> getPoleByArea(String area) {
		 try {
				String qryStr = "select p from MmsAddpole p where p.area =:area ORDER BY p.id ";
				Query query = em.createQuery(qryStr);
				query.setParameter("area", area);
				List<MmsAddpole> list = query.getResultList();
				return list;
	        } catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}
	


}
	
	


