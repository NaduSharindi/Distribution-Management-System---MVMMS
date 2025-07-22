package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsAddswitch;
import com.it.piv.mms.domain.MmsAddswitchPK;

@Transactional
@Repository
public class MmsAddSwitchDaoImpl implements MmsAddSwitchDao{

	
	@Autowired
	private EntityManager em;
	
	@Override
	public String addSwitch(MmsAddswitch addSwitch) {
		em.persist(addSwitch);
	  		return null;
	}

	
	
	public String getNextSwitchId(String appIdPrefix) {
		//getEntityManager(webAppName);
    	String sequence=null;
    	String like=appIdPrefix+"%";
    	String strQuery="select a.id.switchId from MmsAddswitch a " +
    			"where a.id.switchId like :like ORDER BY 1 DESC";
    	System.out.println("Hii" + strQuery);
    	Query query=em.createQuery(strQuery);//SELECT MIS.TEST4_SEQ.NEXTVAL() FROM DUAL
    	query.setParameter("like", like);
    	List<String> list=query.getResultList();
    	if (list.size()!=0){
    		sequence=query.getResultList().get(0).toString().trim();
    		System.out.println(sequence);
    		//sequence=sequence.substring(16);//total 20 chars   year 2012
    		sequence=sequence.substring(2);//total 18 chars  year 12 
    		Integer i=Integer.parseInt(sequence)+1;
    		sequence=i.toString();
    		System.out.println(sequence);
    		System.out.println("Hii" + sequence);
    	}else{
    		sequence="0001";
    		System.out.println("HIIII : "+ sequence);
    	}
    	if(sequence.length()==1)
    		return "000"+sequence;
    	else if (sequence.length()==2)
    		return "00"+sequence;
    	else if (sequence.length()==3)
    		return "0"+sequence;
    	else return sequence;
	}



	@Override
	public List<MmsAddswitch> getSwitchData(String switchId) {
		// TODO Auto-generated method stubtry {
		try{
		String sql = "select a from MmsAddswitch a where a.id.switchId= :switchId";
		System.out.println("sql : "+ sql);
		Query query = em.createQuery(sql);
		query.setParameter("switchId",switchId);
		
		
		return query.getResultList();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}



	@Override
	public List<MmsAddswitch> getSwitchByFeederId(String feederId,String switchType) {
		// TODO Auto-generated method stub
		try {
			String sql = "select a from MmsAddswitch a where a.id.feederId= :feederId and a.switchType= :switchType and a.status = 1";
			System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			query.setParameter("feederId",feederId);
			query.setParameter("switchType", new BigDecimal(switchType));
			
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public String updateSwitch(MmsAddswitch addSwitch) {
		em.merge(addSwitch);
		return null;
	}



	@Override
	public MmsAddswitch findById(MmsAddswitchPK id) {
		// TODO Auto-generated method stub
		em.find(MmsAddswitch.class, id);
		return null;
	}



	@Override
	public List<MmsAddswitch> findSwitchByStatus(String status,String phmBranch) {
		try {
			//System.out.println("status : "+status);
			String qryStr = "select p from MmsAddswitch p where p.status =:status and p.phmBranch =:phmBranch ORDER BY p.id.switchId ";
			Query query = em.createQuery(qryStr);
			query.setParameter("status", new BigDecimal(status));
			query.setParameter("phmBranch", phmBranch);
			
			List<MmsAddswitch> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}



	@Override
	public List<MmsAddswitch> findSwitchByswitchTypeStatus(String status,String switchType, String phmBranch) {
		try {
			System.out.println("status : "+status);
			String qryStr = "select p from MmsAddswitch p where p.status =:status and p.switchType =:switchType ORDER BY p.id.switchId ";
			Query query = em.createQuery(qryStr);
			query.setParameter("status", new BigDecimal(status));
			query.setParameter("switchType", new BigDecimal(switchType));
			List<MmsAddswitch> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}



	@Override
	public MmsAddswitch findById(String id) {
		try {
			String sql = "select a from MmsAddswitch a where trim(a.id.switchId)= :switchId";
			System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			query.setParameter("switchId",id);
			MmsAddswitch obj = (MmsAddswitch) query.getSingleResult();
			return obj;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}



	@Override
	public List<MmsAddswitch> getSwitchByGantryId(String gantryId) {
		try {
			String sql = "select a from MmsAddswitch a , MmsAddfeeder b where trim(a.id.feederId)= b.id.feederId and b.status = 1 and trim(a.id.gantryId)= :feederId and a.status = 1";
			System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			query.setParameter("feederId",gantryId);
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public List<MmsAddswitch> getSwitchByFeederId(String feederId,
			String switchType, String status) {
		// TODO Auto-generated method stub
				try {
					String sql = "select a from MmsAddswitch a where a.id.feederId= :feederId and a.switchType= :switchType and a.status =:status";
					System.out.println("sql : "+ sql);
					Query query = em.createQuery(sql);
					query.setParameter("feederId",feederId);
					query.setParameter("switchType", new BigDecimal(switchType));
					query.setParameter("status", new BigDecimal(status));
					
					
					return query.getResultList();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return null;
	}

}
