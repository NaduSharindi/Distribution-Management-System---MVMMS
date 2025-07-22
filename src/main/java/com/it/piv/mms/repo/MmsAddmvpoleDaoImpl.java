package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsAddmvpole;
import com.it.piv.mms.domain.MmsAddpole;

@Transactional
@Repository
public class MmsAddmvpoleDaoImpl implements  MmsAddmvpoleDao {
	
	@Autowired
	private EntityManager em;
	

	@Override
	public String addPole(MmsAddmvpole addPole) {
		em.persist(addPole);
		String id = String.valueOf(addPole.getId());
		
		return id;
	}

	@Override
	public String update(MmsAddmvpole addPole) {
		em.merge(addPole);
		return null;
	}

	@Override
	public List<MmsAddmvpole> getPoleByAreaFeeder(String area, String feeder) {
		try {
			area = area.trim();
        	
			String qryStr = "select p from MmsAddmvpole p where p.area =:area and p.feederNo=:feederNo ORDER BY p.poleNo ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("feederNo", feeder);
			List<MmsAddmvpole> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

	@Override
	public MmsAddmvpole findById(long id) {
		// TODO Auto-generated method stub
		return em.find(MmsAddmvpole.class, id);
	}
	
	
	@Override
	public List<MmsAddmvpole> findMVPoleByStatus(String status, String phmBranch) {
		try {
			System.out.println("status : "+status);
			String qryStr = "select p from MmsAddmvpole p where p.status =:status ORDER BY p.id ";
			Query query = em.createQuery(qryStr);
			query.setParameter("status", new BigDecimal(status));
			//query.setParameter("phmbranch", phmBranch);
			List<MmsAddmvpole> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public MmsAddmvpole findById(String id) {
		try {
			String sql = "select a from MmsAddmvpole a where a.id= :id";
			System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			query.setParameter("id",new Long(id));
			MmsAddmvpole obj = (MmsAddmvpole) query.getSingleResult();
			return obj;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<MmsAddmvpole> getMvPoleByFeederId(String feederId) {
		try {
			
			String qryStr = "select p from MmsAddmvpole p where p.feederNo =:feederId ORDER BY p.id ";
			Query query = em.createQuery(qryStr);
			query.setParameter("feederId", feederId);
			List<MmsAddmvpole> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	@Override
	public List<MmsAddmvpole> getMvPoleByArea(String area) {
      try {
			String qryStr = "select p from MmsAddmvpole p where p.status= 2 and p.area=:area and p.gpsLatitude IS NOT NULL and p.gpsLatitude != 0  ORDER BY p.id ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			List<MmsAddmvpole> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public MmsAddmvpole findByPoleNo(String poleNo) {
		try {
			String qryStr = "select p from MmsAddmvpole p where p.poleNo=:poleNo";
			Query query = em.createQuery(qryStr);
			query.setParameter("poleNo", poleNo);
			MmsAddmvpole list = (MmsAddmvpole)query.getResultList().get(0);
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Object[]> findMVPoleByPoleClass() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
