package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsTxntowermaintenance;
import com.it.piv.mms.domain.PcbLocation;

@Transactional
@Repository
public class PcbLocationDaoImpl implements PcbLocationDao {

	@Autowired
	private EntityManager em;

	
	@Override
	public PcbLocation findLocationByEquipmentId(String equipmentId) {
		return em.find(PcbLocation.class, equipmentId);
	}

	@Override
	public String addLocation(PcbLocation pcbLocation) {
		em.persist(pcbLocation);
		return null;
	}

	@Override
	public String updateLocation(PcbLocation pcbLocation) {
		em.merge(pcbLocation);
		return null;
	}

	@Override
	public List<PcbLocation> findLocationByArea(String area) {
		try {
			System.out.println("area :" + area);
        	String qryStr = "select p from PcbLocation p , PcbEquipment b where p.equipmentId=b.equipmentId and  b.area = :area";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			List<PcbLocation> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
