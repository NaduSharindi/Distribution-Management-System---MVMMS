package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsAddfeeder;
@Transactional
@Repository
public class MmsAddFeederDaoImpl implements MmsAddFeederDao{
	
	@Autowired
	private EntityManager em;
	
	@Override
	public String addFeeder(MmsAddfeeder addFeeder) {
		em.persist(addFeeder);
	  		return null;
	}
	
	
	public String getNextFeerderId(String appIdPrefix) {
		//getEntityManager(webAppName);
    	String sequence=null;
    	String like=appIdPrefix+"%";
    	String strQuery="select a.id.feederId from MmsAddfeeder a " +
    			"where a.id.feederId like :like ORDER BY 1 DESC";
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
	public List<MmsAddfeeder> getFeederByGantryId(String gantryId) {
		try {
			String sql = "select a from MmsAddfeeder a where a.id.gantryId= :gantryId and a.status=1 order by a.typeInOut,a.mapId";
			System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			query.setParameter("gantryId",new Long(gantryId));
			
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public List<MmsAddfeeder> getFeederByGantryId(String gantryId,String status) {
		try {
			String sql = "select a from MmsAddfeeder a where a.id.gantryId= :gantryId and a.status =:status";
			System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			query.setParameter("gantryId",new Long(gantryId));
			query.setParameter("status",new BigDecimal(status));
			
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public List<Object[]> getFeederByGantryIdNew(String gantryId) {
		try {
			String sql = "select a.name from MmsAddfeeder a where a.id.gantryId= :gantryId";
			System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			query.setParameter("gantryId",new Long(gantryId));
			
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public List<MmsAddfeeder> getFeederData(String feederId) {
		// TODO Auto-generated method stub
		try {
			String sql = "select a from MmsAddfeeder a where a.id.feederId= :feederId";
			System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			query.setParameter("feederId",feederId);
			
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public String updateFeeder(MmsAddfeeder addFeeder) {
		// TODO Auto-generated method stub
		em.merge(addFeeder);
		return null;
	}


	@Override
	public MmsAddfeeder getFeederByFeederId(String feederId) {
		// TODO Auto-generated method stub
		try {
			String sql = "select a from MmsAddfeeder a where a.id.feederId= :feederId";
			System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			query.setParameter("feederId",feederId);
			if(query.getResultList()!=null){
				return (MmsAddfeeder)query.getResultList().get(0);
				
			}else{
				return null;
			}
				
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public List<MmsAddfeeder> findFeederByStatus(String status, String phmBranch) {
		try {
			//System.out.println("status : "+status);
			String qryStr = "select p from MmsAddfeeder p  where p.status =:status and p.phmBranch =:phmBranch ORDER BY p.id.feederId ";
			Query query = em.createQuery(qryStr);
			query.setParameter("status", new BigDecimal(status));
			query.setParameter("phmBranch", phmBranch);
			
			List<MmsAddfeeder> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	@Override
	public MmsAddfeeder findById(String feederId) {
		try {
			String sql = "select a from MmsAddfeeder a where trim(a.id.feederId)= :feederId";
			System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			query.setParameter("feederId",feederId);
			MmsAddfeeder obj = (MmsAddfeeder) query.getSingleResult();
			return obj;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	@Override
	public List<MmsAddfeeder> getFeederByArea(String area) {
		try {
			
			//String authorizedCostCenter ="(select s.id.deptId from Sausrdpm s where s.id.userId ='"+usrName+"')";
			//qryStr = "select count(a.id.estimateNo) from Pcesthtt a where a.id.revNo IN (1,2) and a.aprUid5 =:usrId and  a.status =:statusnew and a.id.deptId IN "+authorizedCostCenter;
			
			System.out.println("area : "+area);
			
			String qryStr1 = "(select a.id from MmsAddgantry a  where a.area ='"+area+"' and a.status =1)";
			
			String qryStr = "select p from MmsAddfeeder p  where p.status =1 and p.id.gantryId IN "+qryStr1+"  ORDER BY p.id.feederId ";
			Query query = em.createQuery(qryStr);
			//query.setParameter("status", new BigDecimal(status));
			List<MmsAddfeeder> list = query.getResultList();
			
			System.out.println("sql : "+qryStr);
			System.out.println("query : "+query.toString());
			
			if(list != null){
				System.out.println("list : "+list.size());
			}
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	@Override
	public List<MmsAddfeeder> getFeederByGantryIdType(String gantryId,String type) {
		try {
			String sql = "select a from MmsAddfeeder a where a.id.gantryId= :gantryId and a.status =1 and a.typeInOut =:type order by a.typeInOut,a.mapId";
			System.out.println("sql : "+ sql);
			Query query = em.createQuery(sql);
			query.setParameter("gantryId",new Long(gantryId));
			query.setParameter("type",new BigDecimal(type));
			
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}


	
	
	

}
