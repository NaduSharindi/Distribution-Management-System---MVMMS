package com.it.piv.mms.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsAddsupport;
import com.it.piv.mms.domain.MmsGantryloc;
import com.it.piv.mms.domain.MmsGantrylocPK;


@Transactional
@Repository
public class MmsGantrylocDaoImpl implements MmsGantrylocDao {

	@Autowired
	private EntityManager em;
	
	
	@Override
	public String addGantyLoc(MmsGantryloc gantryLoc) {
		// TODO Auto-generated method stub
		em.persist(gantryLoc);
		return null;
	}


	@Override
	public MmsGantryloc findById(MmsGantrylocPK id) {
		// TODO Auto-generated method stub
		return em.find(MmsGantryloc.class, id);
	}


	@Override
	public String updateGantyLoc(MmsGantryloc gantryLoc) {
		em.merge(gantryLoc);
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<MmsGantryloc> getGantryLoc(String gantryid) {
		try {
			String sql = "select a from MmsGantryloc a where trim(a.id.gantryId)= :gantryid and a.id.pointId IN (1,2)";
			System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			query.setParameter("gantryid",gantryid);
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<MmsGantryloc> getGantryLocArea(String area) {
		// TODO Auto-generated method stub
		
		//select a.* from MMS_GANTRYLOC a,MMS_ADDGANTRY  b where  a.GANTRY_ID = b.ID and b.status = 1 and b.AREA ='443.00'
if(area.equalsIgnoreCase("NONE")){
	try {
		String sql = "select a from MmsGantryloc a , MmsAddgantry b where trim(a.id.gantryId)= b.id and b.status =1 order by a.id.pointId";
		System.out.println("sql : "+ sql);
		Query query = em.createQuery(sql);
		//query.setParameter("area",area);
		
		return query.getResultList();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}else{
		try {
			String sql = "select a from MmsGantryloc a , MmsAddgantry b where trim(a.id.gantryId)= b.id and b.status =1 and b.area = :area order by a.id.pointId";
			System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			query.setParameter("area",area);
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	return null;

}
}