package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

import com.it.piv.mms.domain.MmsAddline;
import com.it.piv.mms.domain.MmsAddsupport;
import com.it.piv.mms.domain.MmsArea;
import com.it.piv.mms.domain.MmsTowermaintenance;
import com.it.piv.mms.domain.MvmmsCycle;

@Transactional
@Repository
public class MmsSupportDaoImpl implements MmsSupportDao{

	@Autowired
	private EntityManager em;
	
	@Autowired
	private MvmmsCycleDao cycleDao;
	
	@Autowired
	private GldeptmDao deptDao;
	
	@Autowired
	private GlcompmDao glcompmDao;
	
	
	
	@Override
	public String addSupport(MmsAddsupport support) {
		//DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	   // TransactionStatus status = txManager.getTransaction(def);
	   // def.setName("SomeTxName");
	    //def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	    try {
		System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo---------");
		em.persist(support);
	   } catch (Exception ex) {
	    	System.out.println(ex);
	        //txManager.rollback(status);
	   }
	   // txManager.commit(status);
	   

	  //  em.persist(support);
		
		return null;
	}

	@Override
	public List<MmsAddsupport> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsAddsupport> criteria = cb.createQuery(MmsAddsupport.class);
		Root<MmsAddsupport> support = criteria.from(MmsAddsupport.class);
		
		criteria.select(support).orderBy(cb.asc(support.get("area")));
		
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public List<MmsAddsupport> getTowerMaintenanceData(String towerNo,String deptId) {
		try {
			String qryStr = "select s.area,s.bodyExtension,s.bodyExtension,s.conductorType,s.towerNo,t.id.towerId,t.wayLeaving,t.baseConcrete from MmsAddsupport s, MmsTowermaintenance t where s.towerNo = :towerNo and s.deptId = :deptId and t.id.towerId = :towerNo and s.towerNo=t.id.towerId";
		//	String qryStr = "select * from MmsAddsupport s, MmsTowermaintenance t where s.towerNo=t.id.towerId";
			Query query = em.createQuery(qryStr);
			System.out.println("Query tower No ---------------------------------" + towerNo);
			System.out.println("Query Dept Id ---------------------------------" + deptId);
			query.setParameter("towerNo", towerNo);
			query.setParameter("deptId", deptId);
			List<MmsAddsupport> list = query.getResultList();
			return list;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<MmsAddsupport> getTowerMaintenanceData() {
		try {
		//	String qryStr = "select s from MmsAddsupport s, MmsTowermaintenance t where s.towerNo = :towerNo and s.deptId = :deptId and t.id.towerId = :towerNo and s.towerNo=t.id.towerId";
			String qryStr = "select s.area,s.bodyExtension,s.gpsLatitude,s.gpsLongitude,s.conductorType,s.towerNo,t.id.towerId,t.wayLeaving,t.baseConcrete from MmsAddsupport s, MmsTowermaintenance t where s.towerNo=t.id.towerId";
			Query query = em.createQuery(qryStr);
		//	query.setParameter("deptId", deptId);
		//	query.setParameter("towerNo", towerNo);
			List<MmsAddsupport> list = query.getResultList();
			return list;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void updateSupport(String id,String mapid,String gpsLatitude, String gpsLongitude,String supportType) {
		
		//MmsAddsupport obj = new MmsAddsupport();
		//obj.setId(new Long(id));
		//obj.setMapId(new BigDecimal(mapid));
		//em.merge(obj);
		System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo---------"+mapid);
		System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo---------"+id);
		try {
	    	Query  query = em.createQuery("UPDATE MmsAddsupport mp set mp.mapId =:mapId ,mp.supportType =:supportType,mp.gpsLatitude =:gpsLatitude,mp.gpsLongitude =:gpsLongitude WHERE mp.id = :id");
		    query.setParameter("id", new Long(id));
		    query.setParameter("mapId", new BigDecimal(mapid));
		    query.setParameter("supportType", new BigDecimal(supportType));
		    query.setParameter("gpsLatitude", new BigDecimal(gpsLatitude));
		    query.setParameter("gpsLongitude", new BigDecimal(gpsLongitude));
			
		    query.executeUpdate();
		    System.out.println("oooooooooooooooooooooo");
			
	    } catch (Exception ex) {
	    	System.out.println("oooooooooooooooooooooo" + ex);
			
	    }
	   
		
	}

	
	
	@Override
	public void updateSupport(String towerno,String supportType, String id, String area, String csc, String conductorType, String earthConductorType, String towerType, String towerConfiguration, String gpsLatitude, String gpsLongitude, String noOfCircuits, String bodyExtension, String tapping, String mapId, String status, String approvalLevel,String res,String from ,String to) {
		
		System.out.println("---------supportType: " + supportType);
		System.out.println("---------id: " + id);
		System.out.println("---------area: " + area);
		System.out.println("---------csc: " + csc);
		System.out.println("---------conductorType: " + conductorType);
		System.out.println("---------earthConductorType: " + earthConductorType);
		System.out.println("---------towerType: " + towerType);
		System.out.println("---------towerConfiguration: " + towerConfiguration);
		System.out.println("---------gpsLatitude: " + gpsLatitude);
		System.out.println("---------gpsLongitude: " + gpsLongitude);
		System.out.println("---------noOfCircuits: " + noOfCircuits);
		System.out.println("---------bodyExtension: " + bodyExtension);
		System.out.println("---------tapping: " + tapping);
		System.out.println("---------mapId: " + mapId);
		System.out.println("---------status: " + status);
		System.out.println("---------approvalLevel: " + approvalLevel);
		System.out.println("---------res: " + res);
		System.out.println("---------from: " + from);
		System.out.println("---------to: " + to);
		
	//	DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	//  TransactionStatus sta = txManager.getTransaction(def);
	//  def.setName("SomeTxName");
	//  def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	    try {
	    	Query  query = em.createQuery("UPDATE MmsAddsupport mp set mp.towerNo =:tower_no,mp.tapping =:tapping,mp.mapId =:mapId,mp.supportType =:supportType,mp.area =:area,mp.csc =:csc,mp.conductorType =:conductorType,mp.earthConductorType =:earthConductorType,mp.towerType =:towerType,mp.towerConfiguration =:towerConfiguration,mp.gpsLatitude =:gpsLatitude,mp.gpsLongitude =:gpsLongitude,mp.noOfCircuits =:noOfCircuits,mp.bodyExtension =:bodyExtension,mp.status =:status,mp.approvalLevel =:approvalLevel,mp.responsibleArea =:res,mp.sectionId=:from,mp.sectionIdTo=:to WHERE mp.id = :id");
			query.setParameter("id", new Long(id));
		    query.setParameter("supportType", new BigDecimal(supportType));
		    query.setParameter("area", new String(area));
		    query.setParameter("csc", new String(csc));
		    query.setParameter("conductorType", new BigDecimal(conductorType));
		    query.setParameter("earthConductorType", new BigDecimal(earthConductorType));
		    query.setParameter("towerType", new BigDecimal(towerType));
		    query.setParameter("towerConfiguration", new BigDecimal(towerConfiguration));
		    query.setParameter("gpsLatitude", new BigDecimal(gpsLatitude));
		    query.setParameter("gpsLongitude", new BigDecimal(gpsLongitude));
		    query.setParameter("noOfCircuits", new BigDecimal(noOfCircuits));
		    query.setParameter("bodyExtension", new String(bodyExtension));
		    query.setParameter("tapping", new BigDecimal(tapping));
		    query.setParameter("mapId", new BigDecimal(mapId));
		    query.setParameter("status", new BigDecimal(status));
			query.setParameter("approvalLevel", new String(approvalLevel));
			query.setParameter("tower_no", towerno);
			query.setParameter("res", res);
			query.setParameter("from", from);
			query.setParameter("to", to);
			
			
			
		    System.out.print(query);
		    query.executeUpdate();
	    } catch (Exception ex) {
	    	System.out.println("---------Exception: " + ex);
	       // txManager.rollback(sta);
	    }
	   // txManager.commit(sta);
		
	}


/**	@Override
	public void updateSupport(String supportType, String id,
			String area, String csc, String conductorType, String earthConductorType,
			String towerType, String towerConfiguration, String gpsLatitude, String gpsLongitude,
			String noOfCircuits, String bodyExtension,String tapping,String mapid, String status, String approvalLevel) {
		
		System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo---------"+supportType);
		System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo---------"+id);
		//System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo---------"+towerNo);
		System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo---------"+area);
		System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo---------"+gpsLongitude);
		System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo---------"+conductorType);
		System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo---------"+bodyExtension);
		System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo---------"+status);
		System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo---------"+approvalLevel);
		
	//	DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	  //  TransactionStatus sta = txManager.getTransaction(def);
	   // def.setName("SomeTxName");
	  //  def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	    try {
	    	Query  query = em.createQuery("UPDATE MmsAddsupport mp set mp.tapping =:tapping,mp.mapId =:mapid,mp.supportType =:supportType,mp.area =:area,mp.csc =:csc,mp.conductorType =:conductorType,mp.earthConductorType =:earthConductorType,mp.towerType =:towerType,mp.towerConfiguration =:towerConfiguration,mp.gpsLatitude =:gpsLatitude,mp.gpsLongitude =:gpsLongitude,mp.noOfCircuits =:noOfCircuits,mp.bodyExtension =:bodyExtension,mp.status =:status,mp.approvalLevel =:approvalLevel" + " WHERE mp.id = :id");
		    query.setParameter("id", id);
		    query.setParameter("supportType", supportType);
		    //query.setParameter("lineName", lineName);
		    //query.setParameter("towerNo", towerNo);
		    query.setParameter("area", area);
		    query.setParameter("csc", csc);
		    query.setParameter("conductorType", conductorType);
		    query.setParameter("earthConductorType", earthConductorType);
		    query.setParameter("towerType", towerType);
		    query.setParameter("towerConfiguration", towerConfiguration);
		    query.setParameter("gpsLatitude", gpsLatitude);
		    query.setParameter("gpsLongitude", gpsLongitude);
		    query.setParameter("noOfCircuits", noOfCircuits);
		    query.setParameter("bodyExtension", bodyExtension);
		    query.setParameter("tapping", tapping);
		    query.setParameter("mapId", mapid);
		    
		    query.setParameter("status", status);
		    query.setParameter("approvalLevel", approvalLevel);
		    System.out.print(query);
		    query.executeUpdate();
	    } catch (Exception ex) {
	       // txManager.rollback(sta);
	    }
	   // txManager.commit(sta);
		
	}*/


	@Override
	public List<MmsAddsupport> findES1COMWPS2(String approvalLevel) {
		//String status = "0";
		TypedQuery<MmsAddsupport> query =
				em.createQuery
				("SELECT cd "
				+ "FROM MmsAddsupport cd "
				+ "WHERE cd.approvalLevel=:Level and cd.status= :status", MmsAddsupport.class) ;
					 query.setParameter("status","0");
					 //query.setParameter("status2","2");
					 query.setParameter("Level",approvalLevel.trim());
					 System.out.print(query);
					return query.getResultList();
	}
	
	
	
	

	@Override
	public MmsAddsupport findById(long id) {
		// TODO Auto-generated method stub
		return em.find(MmsAddsupport.class, id);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<MmsAddsupport> findByArea(String area , String lineId) {
		try {
			
			System.out.println("oooooooooo"+lineId);
			
        	String qryStr = "select p from MmsAddsupport p where p.area = :area and p.lineId = :lineId and p.status = 1 order by p.mapId";
			Query query = em.createQuery(qryStr);
			//System.out.println("ooooooooooooooooooooooooo"+new BigDecimal(area));
			//System.out.println("ooooooooooooo11111111111"+new BigDecimal(lineId));
			
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(lineId));
			List<MmsAddsupport> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<MmsAddsupport> findByStatus(String status) {
		TypedQuery<MmsAddsupport> query =
				em.createQuery
				("SELECT cd "
				+ "FROM MmsAddsupport cd "
				+ "WHERE cd.status= :status", MmsAddsupport.class) ;
					 query.setParameter("status",new BigDecimal(status));
					 //query.setParameter("status2","2");
					// query.setParameter("Level",approvalLevel.trim());
					 System.out.print(query);
					return query.getResultList();
	}

	@Override
	public List<MmsAddsupport> findByArea(String area, String line,String province,String dept_id) {
		try {
			
			System.out.println("area: "+area +" line : "+ line + "province : " + province );
			String qryStr ="";
			Query query =null;
			System.out.println("oooooooooo"+line);
			if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP") ){
				System.out.println("oooooooooo1");
				
				qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP2") ){
				System.out.println("oooooooooo1");
				
				qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP2') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("EP") ){
				System.out.println("oooooooooo2");
				
				qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("WPN") ){
				System.out.println("oooooooooo3");
				
				qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
				System.out.println("oooooooooo4");
				
				qryStr = "select p from MmsAddsupport p where p.phmBranch =:dept_id order by p.lineId ,p.mapId ";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
			}else if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
				System.out.println("oooooooooo6");
				qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("dept_id", dept_id);
			}else{
				System.out.println("oooooooooo5");
				
				//qryStr = "select p,a.nooftappings from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.lineId = :lineId order by p.lineId,p.mapId";
				qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				query.setParameter("dept_id", dept_id);
				
			}
			
			//System.out.println("ooooooooooooooooooooooooo"+new BigDecimal(area));
			//System.out.println("ooooooooooooo11111111111"+new BigDecimal(lineId));
			
			List<MmsAddsupport> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public List<MmsAddsupport> findByAreaOther(String area, String line,String province) {
		try {
			
			System.out.println("area: "+area +" line : "+ line + "province : " + province );
			String qryStr ="";
			Query query =null;
			System.out.println("oooooooooo"+line);
			if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP") ){
				System.out.println("oooooooooo1");
				
				qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status = 1 order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				//query.setParameter("dept_id", dept_id);
			}if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP2") ){
				System.out.println("oooooooooo1");
				
				qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP2') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status = 1 order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				//query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("EP") ){
				System.out.println("oooooooooo2");
				
				qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status = 1 order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				//query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("WPN") ){
				System.out.println("oooooooooo3");
				
				qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status = 1 order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				//query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
				System.out.println("oooooooooo4");
				
				qryStr = "select p from MmsAddsupport p where p.status = 1 order by p.lineId ,p.mapId ";
				query = em.createQuery(qryStr);
				//query.setParameter("dept_id", dept_id);
			}else if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
				System.out.println("oooooooooo6");
				qryStr = "select p from MmsAddsupport p where p.area = :area and p.status = 1 order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				//query.setParameter("dept_id", dept_id);
			}else{
				System.out.println("oooooooooo5");
				
				//qryStr = "select p,a.nooftappings from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.lineId = :lineId order by p.lineId,p.mapId";
				qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.status = 1 order by p.lineId ,p.mapId";
				
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				//query.setParameter("dept_id", dept_id);
				
			}
			
			//System.out.println("ooooooooooooooooooooooooo"+new BigDecimal(area));
			//System.out.println("ooooooooooooo11111111111"+new BigDecimal(lineId));
			
			List<MmsAddsupport> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	@Override
	public List<MmsAddsupport> findBySupportStatus(String area, String line,String province,String dept_id,String status) {
		try {
			
			System.out.println("area: "+area +" line : "+ line + "province : " + province +"status : "+status);
			String qryStr ="";
			Query query =null;
			System.out.println("oooooooooo"+line);
			if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP") ){
				System.out.println("oooooooooo1");
				
				qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId,p.towerNo";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal(status));
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP2") ){
				System.out.println("oooooooooo1");
				
				qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP2') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId,p.towerNo";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal(status));
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("EP") ){
				System.out.println("oooooooooo2");
				
				qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId,p.towerNo";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("WPN") ){
				System.out.println("oooooooooo3");
				
				qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId,p.towerNo";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
				System.out.println("oooooooooo4");
				
				qryStr = "select p from MmsAddsupport p where and p.phmBranch =:dept_id order by p.lineId ,p.mapId,p.towerNo ";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
			}else if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
				System.out.println("oooooooooo6");
				qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId,p.towerNo";
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal(status));
			}else if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("-1")){
				System.out.println("oooooooooo6");
				qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId,p.towerNo";
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal(status));
			}else{
				System.out.println("oooooooooo5");
				
				//qryStr = "select p,a.nooftappings from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.lineId = :lineId order by p.lineId,p.mapId";
				qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId,p.towerNo";
				
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal(status));
			}
			
			//System.out.println("ooooooooooooooooooooooooo"+new BigDecimal(area));
			//System.out.println("ooooooooooooo11111111111"+new BigDecimal(lineId));
			
			List<MmsAddsupport> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	
	@Override
	public List<Object[]> findByAreaForNewMap(String area, String line,String province,String dept_id) {
		try {
			
			System.out.println("area: "+area +" line : "+ line + "province : " + province );
			String qryStr ="";
			Query query =null;
			System.out.println("oooooooooo"+line);
			if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP") ){
				System.out.println("oooooooooo1");
				qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				
				//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP2") ){
				System.out.println("oooooooooo1");
				qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP2') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				
				//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("EP") ){
				System.out.println("oooooooooo2");
				//qryStr = "select p,a from MmsAddsupport p , MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				//qryStr = "select p,a,c.type,d.name from MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				
				//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("WPN") ){
				System.out.println("oooooooooo3");
				//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				
				//qryStr = "select p,a from MmsAddsupport p , ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
				System.out.println("oooooooooo4");
				//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p from MmsAddsupport p where and p.phmBranch =:dept_id order by p.lineId , p.mapId ";
				qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId ";
				
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
			}else if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
				System.out.println("oooooooooo6sss");
				//qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("dept_id", dept_id);
			}else{
				System.out.println("oooooooooo5sssaaaaaaa");
				
				qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				 
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				query.setParameter("dept_id", dept_id);
				
			}
			
			//System.out.println("ooooooooooooooooooooooooo"+new BigDecimal(area));
			//System.out.println("ooooooooooooo11111111111"+new BigDecimal(lineId));
			
			List<Object[]> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String getTowerIDByTowerNo(String towerNo) {
		try {
        	String qryStr = "select id  from MmsAddsupport a where a.towerNo = :towerNo";
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
			return "N";
		}
	}

	@Override
	public List<Object[]> findSupportForAE(String area,String line) {
		
		String qryStr ="";
		Query query =null;
	
		try {
			/*if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
				System.out.println("oooooooooo6");
				//qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				qryStr = "select p,a,c.type,d.name,s from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area order by p.lineId,p.mapId";
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				//query.setParameter("dept_id", dept_id);
			}else{
				System.out.println("oooooooooo5");
				
				qryStr = "select p,a,c.type,d.name,s from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId order by p.lineId,p.mapId";
				//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				//query.setParameter("dept_id", dept_id);
				
			}*/
			System.out.println("oooooooooo6" +line);
			
			if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
				System.out.println("oooooooooo6sss");
				//qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.status =:status order by p.lineId,p.mapId";
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				//query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal("1"));
			}else if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("-1")){
				System.out.println("oooooooooo6sss");
				//qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.status =:status order by p.lineId,p.mapId";
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				//query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal("1"));
			}else{
				System.out.println("oooooooooo5sssbbbbbb");
				
				qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.status =:status order by p.lineId,p.mapId";
				//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , MmsAddsupport p JOIN MmsTxntowermaintenance a where e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area  b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
				
				//qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e, MmsAddsupport p JOIN MmsTxntowermaintenance a where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				//qryStr = "select p,(select a.nooftappings from MmsTxntowermaintenance a where p.id= a.id.towerid),c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				//query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal("1"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("ooooooooooooooooooooooooo"+new BigDecimal(area));
		//System.out.println("ooooooooooooo11111111111"+new BigDecimal(lineId));
		
		List<Object[]> list = query.getResultList();
		return list;
		
	}

	@Override
	public List<Object[]> findByAreaForNewMap(String area, String line,	String province) {
try {
			
			System.out.println("area: "+area +" line : "+ line + "province : " + province );
			String qryStr ="";
			Query query =null;
			System.out.println("oooooooooo"+line);
			if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP") ){
				System.out.println("oooooooooo1");
				qryStr = "select p,a,c.type,d.name,s from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) order by p.lineId ,p.mapId";
				
				//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				//query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP2") ){
				System.out.println("oooooooooo1");
				qryStr = "select p,a,c.type,d.name,s from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP2') and b.lvlNo<60) and a.deptId like '%.00' ) order by p.lineId ,p.mapId";
				
				//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				//query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("EP") ){
				System.out.println("oooooooooo2");
				//qryStr = "select p,a from MmsAddsupport p , MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				//qryStr = "select p,a,c.type,d.name from MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				qryStr = "select p,a,c.type,d.name,s from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) order by p.lineId ,p.mapId";
				
				//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				query = em.createQuery(qryStr);
				//query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("WPN") ){
				System.out.println("oooooooooo3new");
				//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				
				//qryStr = "select p,a from MmsAddsupport p , ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				qryStr = "select p,a,c.type,d.name,s from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) order by p.lineId ,p.mapId";
				
				query = em.createQuery(qryStr);
				//query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
				System.out.println("oooooooooo4new");
				//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p from MmsAddsupport p where and p.phmBranch =:dept_id order by p.lineId , p.mapId ";
				qryStr = "select p,a,c.type,d.name,s from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid order by p.lineId,p.mapId ";
				
				query = em.createQuery(qryStr);
				//query.setParameter("dept_id", dept_id);
			}else if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
				System.out.println("oooooooooo6new");
				//qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				qryStr = "select p,a,c.type,d.name,s from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area order by p.lineId,p.mapId";
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				//query.setParameter("dept_id", dept_id);
			}else{
				System.out.println("oooooooooo5new");
				
				qryStr = "select p,a,c.type,d.name,s from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId order by p.lineId,p.mapId";
				//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				//query.setParameter("dept_id", dept_id);
				
			}
			
			//System.out.println("ooooooooooooooooooooooooo"+new BigDecimal(area));
			//System.out.println("ooooooooooooo11111111111"+new BigDecimal(lineId));
			
			List<Object[]> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public List<Object[]> findByAreaForNewMap(String area, String line) {
try {
			
			System.out.println("area: "+area +" line : "+ line );
			String qryStr ="";
			Query query =null;
			System.out.println("oooooooooo"+line);
			 if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
				System.out.println("oooooooooo6new");
				qryStr = "select p,a,c.type,d.name,s from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area order by p.lineId,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				
			}else{
				System.out.println("oooooooooo5new");
				qryStr = "select p,a,c.type,d.name,s from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId order by p.lineId,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
			}
			
			List<Object[]> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	@Override
	public String update(MmsAddsupport addSupport) {
		System.out.println("hi update..");
		em.merge(addSupport);
		return null;
	}
	
/**	@Override
	public List<MmsAddsupport> findBySupportStatus(String area, String line,String province,String dept_id,String status) {
		try {
			
			System.out.println("area: "+area +" line : "+ line + "province : " + province +"status : "+status);
			String qryStr ="";
			Query query =null;
			System.out.println("oooooooooo"+line);
			if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP") ){
				System.out.println("oooooooooo1");
				
				qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal(status));
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("EP") ){
				System.out.println("oooooooooo2");
				
				qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("WPN") ){
				System.out.println("oooooooooo3");
				
				qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
				System.out.println("oooooooooo4");
				
				qryStr = "select p from MmsAddsupport p where and p.phmBranch =:dept_id order by p.lineId ,p.mapId ";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
			}else if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
				System.out.println("oooooooooo6");
				qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal(status));
			}else{
				System.out.println("oooooooooo5");
				
				//qryStr = "select p,a.nooftappings from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.lineId = :lineId order by p.lineId,p.mapId";
				qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
				
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal(status));
			}
			
			//System.out.println("ooooooooooooooooooooooooo"+new BigDecimal(area));
			//System.out.println("ooooooooooooo11111111111"+new BigDecimal(lineId));
			
			List<MmsAddsupport> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}*/

	@Override
	public List<Object[]> findByAreaForNewMap(String area, String line,String province,String dept_id,String status) {
		try {
			
			System.out.println("area: "+area +" line : "+ line + "province : " + province );
			String qryStr ="";
			Query query =null;
			System.out.println("oooooooooo"+line);
			if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP") ){
				System.out.println("oooooooooo1");
				//SELECT a, b FROM Author a JOIN a.books b
				
				
				//qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
				qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , MmsAddsupport p JOIN MmsTxntowermaintenance a where e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
				
				//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal("1"));
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP2") ){
				System.out.println("oooooooooo1");
				//SELECT a, b FROM Author a JOIN a.books b
				
				
				//qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
				qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , MmsAddsupport p JOIN MmsTxntowermaintenance a where e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP2') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
				
				//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal("1"));
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("EP") ){
				System.out.println("oooooooooo2");
				//qryStr = "select p,a from MmsAddsupport p , MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				//qryStr = "select p,a,c.type,d.name from MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
				
				//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal("1"));
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("WPN") ){
				System.out.println("oooooooooo3");
				//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				
				//qryStr = "select p,a from MmsAddsupport p , ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
				qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
				
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal("1"));
			}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
				System.out.println("oooooooooo4");
				//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p from MmsAddsupport p where and p.phmBranch =:dept_id order by p.lineId , p.mapId ";
				qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId ";
				
				query = em.createQuery(qryStr);
				query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal("1"));
			}else if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
				System.out.println("oooooooooo6sss");
				//qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal("1"));
			}else{
				System.out.println("oooooooooo5sssyyyyyyyyyyyy");
				
				qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , MmsAddsupport p JOIN MmsTxntowermaintenance a where e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area  b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
				
				//qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e, MmsAddsupport p JOIN MmsTxntowermaintenance a where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				//qryStr = "select p,(select a.nooftappings from MmsTxntowermaintenance a where p.id= a.id.towerid),c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				query.setParameter("dept_id", dept_id);
				query.setParameter("status", new BigDecimal("1"));
			}
			
			//System.out.println("ooooooooooooooooooooooooo"+new BigDecimal(area));
			//System.out.println("ooooooooooooo11111111111"+new BigDecimal(lineId));
			
			List<Object[]> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

@Override
public List<Object[]> findByAreaForNewMapWOMNT(String area, String line,String province, String dept_id, String status) {
	try {
		System.out.println("cycleCode 4: ");
		
		//long cycleCode = 0;
		//List<MvmmsCycle>   cycleList = cycleDao.findAllActiveCycle();
		//System.out.println("cycleCode 5: ");
		
/*		if(cycleList != null){
			System.out.println("cycleCode 6: ");
			
			int count = cycleList.size() -1;
			for(int i = 0;i < count ; i++){
				System.out.println("cycleCode 7: ");
				
				
				MvmmsCycle cycle = cycleList.get(i);
				cycleCode = new Long(cycle.getId().getCycleId());
				System.out.println("cycleCode 1: "+cycleCode);
					
				String qryStr ="";
				Query query =null;
				
				qryStr = "select a from MmsTxntowermaintenance a ,MmsAddsupport p  where p.id= a.id.towerid and a.id.visitid =:cycle ";
				System.out.println("cycleCode 2: "+cycleCode);
					
				//qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , MmsAddsupport p JOIN MmsTxntowermaintenance a where e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area  b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
				
				//qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e, MmsAddsupport p JOIN MmsTxntowermaintenance a where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				//qryStr = "select p,(select a.nooftappings from MmsTxntowermaintenance a where p.id= a.id.towerid),c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				
				query = em.createQuery(qryStr);
				query.setParameter("cycle", cycleCode);
				List<Object[]> list = query.getResultList();
				if(list != null){
					System.out.println("cycleCode: "+cycleCode);
					
					break;
				}
				//return list;

			}
			
		}*/

		//System.out.println("cycleCode: "+cycleCode);
		
		
		System.out.println("area: "+area +" line : "+ line + "province : " + province );
		String qryStr ="";
		Query query =null;
		System.out.println("oooooooooo"+line);
		List<BigDecimal> bigDecimalList = new LinkedList<BigDecimal>();
		
		if(!line.equalsIgnoreCase("NONE")){
		String[] stringList = line.split(",");
		System.out.println("oooooooooo stringList"+stringList);
		
		for (String value : stringList) {
		    bigDecimalList.add(new BigDecimal(value));
		}
		}
		
		//String qryStr1 ="(select a.nooftappings from MmsTxntowermaintenance a , MmsAddsupport p where p.id= a.id.towerid and a.id.visitid ="+cycleCode+" )";
		
		
		if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP") ){
			System.out.println("oooooooooo1");
			
			
			//SELECT a, b FROM Author a JOIN a.books b
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP2") ){
			System.out.println("oooooooooo1");
			
			
			//SELECT a, b FROM Author a JOIN a.books b
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP2') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("EP") ){
			System.out.println("oooooooooo2");
			//qryStr = "select p,a from MmsAddsupport p , MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			//qryStr = "select p,a,c.type,d.name from MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			query = em.createQuery(qryStr);
			query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("WPN") ){
			System.out.println("oooooooooo3");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			
			//qryStr = "select p,a from MmsAddsupport p , ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
			
			query = em.createQuery(qryStr);
			query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && !province.equalsIgnoreCase("NONE") ){
			System.out.println("oooooooooo3");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			
			//qryStr = "select p,a from MmsAddsupport p , ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('"+province+"') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
			
			query = em.createQuery(qryStr);
			query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
			System.out.println("oooooooooo4");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where and p.phmBranch =:dept_id order by p.lineId , p.mapId ";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId ";
			
			query = em.createQuery(qryStr);
			query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
			System.out.println("oooooooooo6sss");
			//qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
			
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else{
			System.out.println("oooooooooo5ssscccccccc" );
			
			//qryStr = "select p,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p,(select a.nooftappings from MmsTxntowermaintenance a where p.id= a.id.towerid),c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
			
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId IN (:lineId) and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
			
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", bigDecimalList);
			query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}
		
		//System.out.println("ooooooooooooooooooooooooo"+new BigDecimal(area));
		//System.out.println("ooooooooooooo11111111111"+new BigDecimal(lineId));
		
		List<Object[]> list = query.getResultList();
		return list;
    } catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}
}


@Override
public List<Object[]> findByAreaForNewMapWOMNTAE(String area, String line,String dept_id, String status) {
	try {
		
		
		
		//System.out.println("area: "+area +" line : "+ line + "province : " + province );
		String qryStr ="";
		Query query =null;
		System.out.println("findByAreaForNewMapWOMNTAEoooooooooo"+line);
		if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
			System.out.println("oooooooooo6sss");
			//qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			qryStr = "select p,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.status =:status order by p.lineId,p.mapId";
			
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else{
			System.out.println("oooooooooo5sssfffffffffff");
			
			qryStr = "select p,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.status =:status order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p,(select a.nooftappings from MmsTxntowermaintenance a where p.id= a.id.towerid),c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
			
			
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(line));
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}
		
		//System.out.println("ooooooooooooooooooooooooo"+new BigDecimal(area));
		//System.out.println("ooooooooooooo11111111111"+new BigDecimal(lineId));
		
		List<Object[]> list = query.getResultList();
		return list;
    } catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}
}

@Override
public void updateSupportTapping(String towerno,String supportType, String id, String area, String csc, String conductorType, String earthConductorType, String towerType, String towerConfiguration, String gpsLatitude, String gpsLongitude, String noOfCircuits, String bodyExtension, String tapping, String mapId, String status, String approvalLevel) {
	
	System.out.println("---------supportType: " + supportType);
	System.out.println("---------id: " + id);
	System.out.println("---------area: " + area);
	System.out.println("---------csc: " + csc);
	System.out.println("---------conductorType: " + conductorType);
	System.out.println("---------earthConductorType: " + earthConductorType);
	System.out.println("---------towerType: " + towerType);
	System.out.println("---------towerConfiguration: " + towerConfiguration);
	System.out.println("---------gpsLatitude: " + gpsLatitude);
	System.out.println("---------gpsLongitude: " + gpsLongitude);
	System.out.println("---------noOfCircuits: " + noOfCircuits);
	System.out.println("---------bodyExtension: " + bodyExtension);
	System.out.println("---------tapping: " + tapping);
	System.out.println("---------mapId: " + mapId);
	System.out.println("---------status: " + status);
	System.out.println("---------approvalLevel: " + approvalLevel);
	
//	DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//  TransactionStatus sta = txManager.getTransaction(def);
//  def.setName("SomeTxName");
//  def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    try {
    	Query  query = em.createQuery("UPDATE MmsAddsupport mp set mp.tapping =:tapping WHERE mp.id = :id");
		query.setParameter("id", new Long(id));
	    query.setParameter("tapping", new BigDecimal(tapping));
	    
	    System.out.print(query);
	    query.executeUpdate();
    } catch (Exception ex) {
    	System.out.println("---------Exception: " + ex);
       // txManager.rollback(sta);
    }
   // txManager.commit(sta);
	
}

@Override
public List<Object[]> findByAreaForNewMapOther(String area, String line,String province, String status) {
	try {
		System.out.println("cycleCode 4: ");
		
		//long cycleCode = 0;
		//List<MvmmsCycle>   cycleList = cycleDao.findAllActiveCycle();
		//System.out.println("cycleCode 5: ");
		
/*		if(cycleList != null){
			System.out.println("cycleCode 6: ");
			
			int count = cycleList.size() -1;
			for(int i = 0;i < count ; i++){
				System.out.println("cycleCode 7: ");
				
				
				MvmmsCycle cycle = cycleList.get(i);
				cycleCode = new Long(cycle.getId().getCycleId());
				System.out.println("cycleCode 1: "+cycleCode);
					
				String qryStr ="";
				Query query =null;
				
				qryStr = "select a from MmsTxntowermaintenance a ,MmsAddsupport p  where p.id= a.id.towerid and a.id.visitid =:cycle ";
				System.out.println("cycleCode 2: "+cycleCode);
					
				//qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , MmsAddsupport p JOIN MmsTxntowermaintenance a where e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area  b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
				
				//qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e, MmsAddsupport p JOIN MmsTxntowermaintenance a where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				//qryStr = "select p,(select a.nooftappings from MmsTxntowermaintenance a where p.id= a.id.towerid),c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				
				query = em.createQuery(qryStr);
				query.setParameter("cycle", cycleCode);
				List<Object[]> list = query.getResultList();
				if(list != null){
					System.out.println("cycleCode: "+cycleCode);
					
					break;
				}
				//return list;

			}
			
		}*/

		//System.out.println("cycleCode: "+cycleCode);
		
		
		System.out.println("area: "+area +" line : "+ line + "province : " + province );
		String qryStr ="";
		Query query =null;
		System.out.println("oooooooooo"+line);
		
		
		//String qryStr1 ="(select a.nooftappings from MmsTxntowermaintenance a , MmsAddsupport p where p.id= a.id.towerid and a.id.visitid ="+cycleCode+" )";
		
		
		if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP") ){
			System.out.println("oooooooooo1");
			
			
			//SELECT a, b FROM Author a JOIN a.books b
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP2") ){
			System.out.println("oooooooooo1");
			
			
			//SELECT a, b FROM Author a JOIN a.books b
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP2') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP2") ){
			System.out.println("oooooooooo1");
			
			
			//SELECT a, b FROM Author a JOIN a.books b
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP2') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("EP") ){
			System.out.println("oooooooooo2");
			//qryStr = "select p,a from MmsAddsupport p , MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			//qryStr = "select p,a,c.type,d.name from MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("WPN") ){
			System.out.println("oooooooooo3");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			
			//qryStr = "select p,a from MmsAddsupport p , ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
			System.out.println("oooooooooo4");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where and p.phmBranch =:dept_id order by p.lineId , p.mapId ";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.status =:status order by p.lineId,p.mapId ";
			
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
			System.out.println("oooooooooo4");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where and p.phmBranch =:dept_id order by p.lineId , p.mapId ";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.status =:status order by p.lineId,p.mapId ";
			
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
			System.out.println("oooooooooo6sss");
			//qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.status =:status order by p.lineId,p.mapId";
			
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else{
			System.out.println("oooooooooo5yyyyyyysss");
			
			//qryStr = "select p,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p,(select a.nooftappings from MmsTxntowermaintenance a where p.id= a.id.towerid),c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
			
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.status =:status order by p.lineId,p.mapId";
			
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(line));
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}
		
		//System.out.println("ooooooooooooooooooooooooo"+new BigDecimal(area));
		//System.out.println("ooooooooooooo11111111111"+new BigDecimal(lineId));
		
		List<Object[]> list = query.getResultList();
		
		System.out.println("ooooooooooooo11111111111"+list.size());
		
		return list;
    } catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}


}

@Override
public List<Object[]> findByAreaForNewMapAll(String area, String line,String province,String division, String status) {
	try {
		System.out.println("cycleCode 4: ");
		
		//long cycleCode = 0;
		//List<MvmmsCycle>   cycleList = cycleDao.findAllActiveCycle();
		//System.out.println("cycleCode 5: ");
		
/*		if(cycleList != null){
			System.out.println("cycleCode 6: ");
			
			int count = cycleList.size() -1;
			for(int i = 0;i < count ; i++){
				System.out.println("cycleCode 7: ");
				
				
				MvmmsCycle cycle = cycleList.get(i);
				cycleCode = new Long(cycle.getId().getCycleId());
				System.out.println("cycleCode 1: "+cycleCode);
					
				String qryStr ="";
				Query query =null;
				
				qryStr = "select a from MmsTxntowermaintenance a ,MmsAddsupport p  where p.id= a.id.towerid and a.id.visitid =:cycle ";
				System.out.println("cycleCode 2: "+cycleCode);
					
				//qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , MmsAddsupport p JOIN MmsTxntowermaintenance a where e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area  b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
				
				//qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e, MmsAddsupport p JOIN MmsTxntowermaintenance a where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				//qryStr = "select p,(select a.nooftappings from MmsTxntowermaintenance a where p.id= a.id.towerid),c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				
				query = em.createQuery(qryStr);
				query.setParameter("cycle", cycleCode);
				List<Object[]> list = query.getResultList();
				if(list != null){
					System.out.println("cycleCode: "+cycleCode);
					
					break;
				}
				//return list;

			}
			
		}*/

		//System.out.println("cycleCode: "+cycleCode);
		
		
		System.out.println("area: "+area +" line : "+ line + "province : " + province );
		String qryStr ="";
		Query query =null;
		System.out.println("oooooooooo"+line);
		
		
		//String qryStr1 ="(select a.nooftappings from MmsTxntowermaintenance a , MmsAddsupport p where p.id= a.id.towerid and a.id.visitid ="+cycleCode+" )";
		
		if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") && division.equalsIgnoreCase("NONE") ){
			System.out.println("oooooooooo4");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where and p.phmBranch =:dept_id order by p.lineId , p.mapId ";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.status =:status order by p.lineId,p.mapId ";
			
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") && division.equalsIgnoreCase("DISCO2") ){
			System.out.println("oooooooooo1");
			
			
			//SELECT a, b FROM Author a JOIN a.books b
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP','CP2','WPN','EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") && division.equalsIgnoreCase("DISCO1") ){
			System.out.println("oooooooooo1");
			
			
			//SELECT a, b FROM Author a JOIN a.books b
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('NCP','CC','NWP','NP','NWP2') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") && division.equalsIgnoreCase("DISCO3") ){
			System.out.println("oooooooooo1");
			
			
			//SELECT a, b FROM Author a JOIN a.books b
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('UVAP','SABP','WPSII') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") && division.equalsIgnoreCase("DISCO4") ){
			System.out.println("oooooooooo1");
			
			
			//SELECT a, b FROM Author a JOIN a.books b
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPS1','SP','SP2') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}
		
		else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && !province.equalsIgnoreCase("NONE") ){
			System.out.println("oooooooooo1");
			
			
			//SELECT a, b FROM Author a JOIN a.books b
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('"+province+"') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}/*else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("EP") ){
			System.out.println("oooooooooo2");
			//qryStr = "select p,a from MmsAddsupport p , MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			//qryStr = "select p,a,c.type,d.name from MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("WPN") ){
			System.out.println("oooooooooo3");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			
			//qryStr = "select p,a from MmsAddsupport p , ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}*//*else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
			System.out.println("oooooooooo4");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where and p.phmBranch =:dept_id order by p.lineId , p.mapId ";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.status =:status order by p.lineId,p.mapId ";
			
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
			System.out.println("oooooooooo4");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where and p.phmBranch =:dept_id order by p.lineId , p.mapId ";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.status =:status order by p.lineId,p.mapId ";
			
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}*/else if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
			System.out.println("oooooooooo6sss");
			//qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.status =:status order by p.lineId,p.mapId";
			
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else{
			System.out.println("oooooooooo5yyyyyyysss");
			
			//qryStr = "select p,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p,(select a.nooftappings from MmsTxntowermaintenance a where p.id= a.id.towerid),c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
			
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.status =:status order by p.lineId,p.mapId";
			
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(line));
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}
		
		//System.out.println("ooooooooooooooooooooooooo"+new BigDecimal(area));
		//System.out.println("ooooooooooooo11111111111"+new BigDecimal(lineId));
		
		List<Object[]> list = query.getResultList();
		
		System.out.println("ooooooooooooo11111111111"+list.size());
		
		return list;
    } catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}


}

@Override
public List<Object[]> findByAreaForNewMapComview(String area, String line,String province,String division, String status) {
	try {
		System.out.println("cycleCode 4: ");
		
		//long cycleCode = 0;
		//List<MvmmsCycle>   cycleList = cycleDao.findAllActiveCycle();
		//System.out.println("cycleCode 5: ");
		
/*		if(cycleList != null){
			System.out.println("cycleCode 6: ");
			
			int count = cycleList.size() -1;
			for(int i = 0;i < count ; i++){
				System.out.println("cycleCode 7: ");
				
				
				MvmmsCycle cycle = cycleList.get(i);
				cycleCode = new Long(cycle.getId().getCycleId());
				System.out.println("cycleCode 1: "+cycleCode);
					
				String qryStr ="";
				Query query =null;
				
				qryStr = "select a from MmsTxntowermaintenance a ,MmsAddsupport p  where p.id= a.id.towerid and a.id.visitid =:cycle ";
				System.out.println("cycleCode 2: "+cycleCode);
					
				//qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , MmsAddsupport p JOIN MmsTxntowermaintenance a where e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area  b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
				
				//qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e, MmsAddsupport p JOIN MmsTxntowermaintenance a where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				//qryStr = "select p,(select a.nooftappings from MmsTxntowermaintenance a where p.id= a.id.towerid),c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				
				query = em.createQuery(qryStr);
				query.setParameter("cycle", cycleCode);
				List<Object[]> list = query.getResultList();
				if(list != null){
					System.out.println("cycleCode: "+cycleCode);
					
					break;
				}
				//return list;

			}
			
		}*/

		//System.out.println("cycleCode: "+cycleCode);
		
		
		System.out.println("area: "+area +" line : "+ line + "province : " + province );
		String qryStr ="";
		Query query =null;
		System.out.println("oooooooooo"+line);
		
		List<BigDecimal> bigDecimalList = new LinkedList<BigDecimal>();
		
		String[] stringList = line.split(",");
		System.out.println("oooooooooo stringList"+stringList);
		
		for (String value : stringList) {
		    bigDecimalList.add(new BigDecimal(value));
		}
		
List<String> areaList = new LinkedList<String>();
		
		String[] arList = area.split(",");
		
		for (String value : arList) {
			areaList.add(value);
		}
		
		

		
		
		//String qryStr1 ="(select a.nooftappings from MmsTxntowermaintenance a , MmsAddsupport p where p.id= a.id.towerid and a.id.visitid ="+cycleCode+" )";
		
		if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") && division.equalsIgnoreCase("NONE") ){
			System.out.println("oooooooooo4");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where and p.phmBranch =:dept_id order by p.lineId , p.mapId ";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.status =:status order by p.lineId,p.mapId ";
			
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") && division.equalsIgnoreCase("DISCO2") ){
			System.out.println("oooooooooo1");
			
			
			//SELECT a, b FROM Author a JOIN a.books b
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP','CP2','WPN','EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") && division.equalsIgnoreCase("DISCO1") ){
			System.out.println("oooooooooo1");
			
			
			//SELECT a, b FROM Author a JOIN a.books b
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('NCP','CC','NWP','NP','NWP2') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") && division.equalsIgnoreCase("DISCO3") ){
			System.out.println("oooooooooo1");
			
			
			//SELECT a, b FROM Author a JOIN a.books b
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('UVAP','SABP','WPSII') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") && division.equalsIgnoreCase("DISCO4") ){
			System.out.println("oooooooooo1");
			
			
			//SELECT a, b FROM Author a JOIN a.books b
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPS1','SP','SP2') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}
		
		else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && !province.equalsIgnoreCase("NONE") ){
			System.out.println("oooooooooo1");
			
			
			//SELECT a, b FROM Author a JOIN a.books b
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('"+province+"') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}/*else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("EP") ){
			System.out.println("oooooooooo2");
			//qryStr = "select p,a from MmsAddsupport p , MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			//qryStr = "select p,a,c.type,d.name from MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("WPN") ){
			System.out.println("oooooooooo3");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			
			//qryStr = "select p,a from MmsAddsupport p , ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}*//*else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
			System.out.println("oooooooooo4");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where and p.phmBranch =:dept_id order by p.lineId , p.mapId ";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.status =:status order by p.lineId,p.mapId ";
			
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
			System.out.println("oooooooooo4");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where and p.phmBranch =:dept_id order by p.lineId , p.mapId ";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.status =:status order by p.lineId,p.mapId ";
			
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}*/else if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
			System.out.println("oooooooooo6sss");
			//qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.status =:status order by p.lineId,p.mapId";
			
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else{
			System.out.println("oooooooooo5yyyyyyysss" + areaList.toString());
			
			//qryStr = "select p,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p,(select a.nooftappings from MmsTxntowermaintenance a where p.id= a.id.towerid),c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
			
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area IN (:area) and p.lineId IN (:lineId) and p.status =:status order by p.lineId,p.mapId";
			
			query = em.createQuery(qryStr);
			query.setParameter("area", areaList);
			query.setParameter("lineId", bigDecimalList);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}
		
		//System.out.println("ooooooooooooooooooooooooo"+new BigDecimal(area));
		//System.out.println("ooooooooooooo11111111111"+new BigDecimal(lineId));
		
		List<Object[]> list = query.getResultList();
		
		System.out.println("ooooooooooooo11111111111"+list.size());
		
		return list;
    } catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}


}



@Override
public List<Object[]> findByAreaForNewMapSummary(String area, String line,String province,String division, String status) {
	try {
		String qryStr ="";
		Query query =null;
		
		
		//String qryStr1 ="(select a.nooftappings from MmsTxntowermaintenance a , MmsAddsupport p where p.id= a.id.towerid and a.id.visitid ="+cycleCode+" )";
		
		if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") && division.equalsIgnoreCase("NONE") ){
			qryStr = "select  count(s.id),sum(s.length),c.grpComp,(select b.compNm from Glcompm b  where b.compId =c.grpComp), "+
					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=1)  as  Tower, "+
					
					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=2)  as  Pole, "+

					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=3)  as  GantryBay, "+

					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=4)  as  GSSBay, "+

					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=5)  as  LineGantry, "+
					
					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=6)  as  LatticePole, "+

					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=7)  as  Switch "+

					" from MmsAddline s, "+
					" MmsAddsupport p ,Gldeptm b,Glcompm c , MmsAddsupporttype f where f.id = p.supportType and p.lineId = s.id and s.status= 1 and p.status=1 "+
					" and b.deptId =p.area and c.compId = b.compId group by c.grpComp ";


			
			
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			//query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") && !division.equalsIgnoreCase("NONE") ){
			//System.out.println("oooooooooo1gggggg");
			
			
			qryStr = "select  count(s.id),sum(s.length),c.parentId,(select b.compNm from Glcompm b  where b.compId =c.parentId), "+
					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=1 and c1.parentId =c.parentId)  as  Tower, "+
					
					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=2 and c1.parentId =c.parentId)  as  Pole, "+

					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=3 and c1.parentId =c.parentId)  as  GantryBay, "+

					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=4 and c1.parentId =c.parentId)  as  GSSBay, "+

					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=5 and c1.parentId =c.parentId)  as  LineGantry, "+
					
					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=6 and c1.parentId =c.parentId)  as  LatticePole, "+

					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=7 and c1.parentId =c.parentId )  as  Switch,c.grpComp "+

					" from MmsAddline s, "+
					" MmsAddsupport p ,Gldeptm b,Glcompm c , MmsAddsupporttype f where f.id = p.supportType and p.lineId = s.id and s.status= 1 and p.status=1 "+
					" and b.deptId =p.area and c.compId = b.compId and c.grpComp=:division group by c.grpComp,c.parentId ";
			//System.out.println("oooooooooo1gggggg" +qryStr );
			

			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("division", division.trim());
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && !province.equalsIgnoreCase("NONE") && !division.equalsIgnoreCase("NONE") ){
			//System.out.println("oooooooooo1ggggggrrrrrrrrrrr");
			
			
			qryStr = "select  count(s.id),sum(s.length),c.compId,(select b.compNm from Glcompm b  where b.compId =c.compId), "+
					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=1 and c1.parentId =c.parentId and c1.compId =c.compId)  as  Tower, "+
					
					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=2 and c1.parentId =c.parentId and c1.compId =c.compId)  as  Pole, "+

					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=3 and c1.parentId =c.parentId and c1.compId =c.compId)  as  GantryBay, "+

					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=4 and c1.parentId =c.parentId and c1.compId =c.compId)  as  GSSBay, "+

					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=5 and c1.parentId =c.parentId and c1.compId =c.compId)  as  LineGantry, "+
					
					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=6 and c1.parentId =c.parentId and c1.compId =c.compId)  as  LatticePole, "+

					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=7 and c1.parentId =c.parentId and c1.compId =c.compId )  as  Switch,c.grpComp,c.parentId "+

					" from MmsAddline s, "+
					" MmsAddsupport p ,Gldeptm b,Glcompm c , MmsAddsupporttype f where f.id = p.supportType and p.lineId = s.id and s.status= 1 and p.status=1 "+
					" and b.deptId =p.area and c.compId = b.compId and trim(c.parentId)=:province group by c.grpComp,c.parentId,c.compId ";
			//System.out.println("oooooooooo1ggggggrrrrrrrrrrrrr" +qryStr );
			

			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			//query.setParameter("division", division.trim());
			query.setParameter("province", province.trim());
		}else if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && !province.equalsIgnoreCase("NONE") && !division.equalsIgnoreCase("NONE") ){
			//System.out.println("oooooooooo1ggggggrrrrrrrrrrrkkkk");
			
			
			qryStr = "select  count(s.id),sum(s.length),c.compId,s.lineName, "+
					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=1 and c1.parentId =c.parentId and c1.compId =c.compId and  s1.id= s.id and b1.deptId=b.deptId)  as  Tower, "+
					
					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=2 and c1.parentId =c.parentId and c1.compId =c.compId and  s1.id= s.id and b1.deptId=b.deptId)  as  Pole, "+

					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=3 and c1.parentId =c.parentId and c1.compId =c.compId and  s1.id= s.id and b1.deptId=b.deptId)  as  GantryBay, "+

					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=4 and c1.parentId =c.parentId and c1.compId =c.compId and  s1.id= s.id and b1.deptId=b.deptId)  as  GSSBay, "+

					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=5 and c1.parentId =c.parentId and c1.compId =c.compId and  s1.id= s.id and b1.deptId=b.deptId)  as  LineGantry, "+
					
					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=6 and c1.parentId =c.parentId and c1.compId =c.compId and  s1.id= s.id and b1.deptId=b.deptId)  as  LatticePole, "+

					"(select count(p1.supportType) from MmsAddline s1, "+ 
					" MmsAddsupport p1 ,Gldeptm b1,Glcompm c1 , MmsAddsupporttype f1 where f1.id = p1.supportType and p1.lineId = s1.id and s1.status= 1 and p1.status=1 "+ 
					" and b1.deptId =p1.area and c1.compId = b1.compId and c1.grpComp =c.grpComp and p1.supportType=7 and c1.parentId =c.parentId and c1.compId =c.compId and  s1.id= s.id and b1.deptId=b.deptId)  as  Switch,c.grpComp,c.parentId,b.deptId "+

					" from MmsAddline s, "+
					" MmsAddsupport p ,Gldeptm b,Glcompm c , MmsAddsupporttype f where f.id = p.supportType and p.lineId = s.id and s.status= 1 and p.status=1 "+
					" and b.deptId =p.area and c.compId = b.compId and b.deptId =:area group by c.grpComp,c.parentId,c.compId ,b.deptId,s.lineName,s.id";
					query = em.createQuery(qryStr);
			query.setParameter("area", area.trim());
		}else{
					}
		
		List<Object[]> list = query.getResultList();
		
		
		return list;
    } catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}


}



@Override
public List<MmsAddsupport> findByStatus(String status, String dept_id) {
	// TODO Auto-generated method stub
	TypedQuery<MmsAddsupport> query =
			em.createQuery
			("SELECT cd "
			+ "FROM MmsAddsupport cd "
			+ "WHERE cd.status= :status and cd.phmBranch =:dept_id", MmsAddsupport.class) ;
				 query.setParameter("status",new BigDecimal(status));
				 query.setParameter("dept_id",dept_id);
				// query.setParameter("Level",approvalLevel.trim());
				 System.out.print(query);
				return query.getResultList();


}


@Override
public List<Object[]> findByAreaForNewMapWOMNTGantry(String area, String line,String province, String dept_id, String status) {
	try {
		System.out.println("cycleCode 4: ");
		
		//long cycleCode = 0;
		//List<MvmmsCycle>   cycleList = cycleDao.findAllActiveCycle();
		//System.out.println("cycleCode 5: ");
		
/*		if(cycleList != null){
			System.out.println("cycleCode 6: ");
			
			int count = cycleList.size() -1;
			for(int i = 0;i < count ; i++){
				System.out.println("cycleCode 7: ");
				
				
				MvmmsCycle cycle = cycleList.get(i);
				cycleCode = new Long(cycle.getId().getCycleId());
				System.out.println("cycleCode 1: "+cycleCode);
					
				String qryStr ="";
				Query query =null;
				
				qryStr = "select a from MmsTxntowermaintenance a ,MmsAddsupport p  where p.id= a.id.towerid and a.id.visitid =:cycle ";
				System.out.println("cycleCode 2: "+cycleCode);
					
				//qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , MmsAddsupport p JOIN MmsTxntowermaintenance a where e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area  b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and p.status =:status order by p.lineId ,p.mapId";
				
				//qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e, MmsAddsupport p JOIN MmsTxntowermaintenance a where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				//qryStr = "select p,(select a.nooftappings from MmsTxntowermaintenance a where p.id= a.id.towerid),c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
				
				query = em.createQuery(qryStr);
				query.setParameter("cycle", cycleCode);
				List<Object[]> list = query.getResultList();
				if(list != null){
					System.out.println("cycleCode: "+cycleCode);
					
					break;
				}
				//return list;

			}
			
		}*/

		//System.out.println("cycleCode: "+cycleCode);
		
		
		System.out.println("area: "+area +" line : "+ line + "province : " + province );
		String qryStr ="";
		Query query =null;
		System.out.println("oooooooooo"+line);
		List<BigDecimal> bigDecimalList = new LinkedList<BigDecimal>();
		
		if(!line.equalsIgnoreCase("NONE")){
		String[] stringList = line.split(",");
		System.out.println("oooooooooo stringList"+stringList);
		
		for (String value : stringList) {
		    bigDecimalList.add(new BigDecimal(value));
		}
		}
		
		//String qryStr1 ="(select a.nooftappings from MmsTxntowermaintenance a , MmsAddsupport p where p.id= a.id.towerid and a.id.visitid ="+cycleCode+" )";
		
		
		if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP") ){
			System.out.println("oooooooooo1");
			
			
			//SELECT a, b FROM Author a JOIN a.books b
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP2") ){
			System.out.println("oooooooooo1");
			
			
			//SELECT a, b FROM Author a JOIN a.books b
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP2') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("EP") ){
			System.out.println("oooooooooo2");
			//qryStr = "select p,a from MmsAddsupport p , MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			//qryStr = "select p,a,c.type,d.name from MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.status =:status order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("WPN") ){
			System.out.println("oooooooooo3");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			
			//qryStr = "select p,a from MmsAddsupport p , ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' )  and p.status =:status order by p.lineId ,p.mapId";
			
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
			System.out.println("oooooooooo4");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where and p.phmBranch =:dept_id order by p.lineId , p.mapId ";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.status =:status order by p.lineId,p.mapId ";
			
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
			System.out.println("oooooooooo6sss");
			//qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e , Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.status =:status order by p.lineId,p.mapId";
			
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
		}else{
			System.out.println("oooooooooo5ssscccccccc" );
			
			//qryStr = "select p,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p,(select a.nooftappings from MmsTxntowermaintenance a where p.id= a.id.towerid),c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and p.status =:status order by p.lineId,p.mapId";
			
			qryStr = "select p,c.type,d.name,s,e.name,g.deptNm from MmsAddline s,MmsAddsupport p ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e ,Gldeptm g where g.deptId = s.area and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.area = :area and p.lineId IN (:lineId)  and p.status =:status order by p.lineId,p.mapId";
			
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", bigDecimalList);
			//query.setParameter("dept_id", dept_id);
			query.setParameter("status", new BigDecimal("1"));
			//query.setParameter("line",new BigDecimal(line));
		}
		
		//System.out.println("ooooooooooooooooooooooooo"+new BigDecimal(area));
		//System.out.println("ooooooooooooo11111111111"+new BigDecimal(lineId));
		
		List<Object[]> list = query.getResultList();
		return list;
    } catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}
}

@Override
public MmsAddsupport getTowerByTowerNo(String towerNo) {
	// TODO Auto-generated method stub
	String towerId = getTowerIDByTowerNo(towerNo);
	return findById(new Long(towerId));
	
}

@Override
public List<MmsAddsupport> findByAreaLineStatus(String area, String line,
		String status) {
	try {
		String qryStr = "select p from MmsAddsupport p where p.area = :area and p.lineId = :lineId and a.status = :status order by p.id";
		Query query = em.createQuery(qryStr);
		query.setParameter("area", area);
		query.setParameter("lineId", new BigDecimal(line));
		query.setParameter("status", new BigDecimal(status));
		
		List<MmsAddsupport> list = query.getResultList();
		return list;
    } catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}
}

@Override
public List<MmsAddsupport> getTowerByTowerNoNew(String towerNo) {
	try {
		String qryStr = "select p from MmsAddsupport p where p.towerNo like :towerNo  order by p.lineId,p.mapId";
		Query query = em.createQuery(qryStr);
		query.setParameter("towerNo", towerNo);
		List<MmsAddsupport> list = query.getResultList();
		return list;
    } catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}
}

@Override
public List<MmsAddsupport> getTappings(String area, String lineid,
		String fromTowerId, String fromMapId, String toTowerId, String toMapId) {
	System.out.println("area"+area+"lineid"+lineid+"fromMapId"+fromMapId+"toMapId"+toMapId +"end");
	
	
	String oldToMapId = toMapId;
	String oldFromMapId = fromMapId;
	
	Double	fromMapIdD = new BigDecimal(fromMapId).doubleValue();
	Double	toMapIdD = new BigDecimal(toMapId).doubleValue();
	if(fromMapIdD > toMapIdD){
		toMapId = oldFromMapId;
		fromMapId = oldToMapId;
	}
	
	try {
		String qryStr = "select p from MmsAddsupport p where p.tapping != 0 and p.area = :area and p.lineId = :lineId and p.mapId BETWEEN :fromMapId and :toMapId  order by p.lineId,p.mapId";
		
		//String qryStr = "select p from MmsAddsupport p where p.tapping != 0 and trim(p.area) = :area and p.lineId = :lineId and p.mapId >= :toMapId AND p.mapId <= :fromMapId  order by p.lineId,p.mapId";
		System.out.println("qryStr"+qryStr);
		
		Query query = em.createQuery(qryStr);
		query.setParameter("area", area.trim());
		query.setParameter("fromMapId", new BigDecimal(fromMapId));
		query.setParameter("toMapId", new BigDecimal(toMapId));
		query.setParameter("lineId", new BigDecimal(lineid));
		
		
		List<MmsAddsupport> list = query.getResultList();
		return list;
    } catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}
}

@Override
public List<Object[]> findByAreaForNewMapProvince(String area, String line,
		String province) {
	try {
		
		System.out.println("area: "+area +" line : "+ line + "province : " + province );
		String qryStr ="";
		Query query =null;
		System.out.println("oooooooooo"+line);
		if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP") ){
			System.out.println("oooooooooo1");
			qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP2") ){
			System.out.println("oooooooooo1");
			qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP2') and b.lvlNo<60) and a.deptId like '%.00' ) order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("EP") ){
			System.out.println("oooooooooo2");
			//qryStr = "select p,a from MmsAddsupport p , MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			//qryStr = "select p,a,c.type,d.name from MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' )  order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("WPN") ){
			System.out.println("oooooooooo3");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			
			//qryStr = "select p,a from MmsAddsupport p , ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' )  order by p.lineId ,p.mapId";
			
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
			System.out.println("oooooooooo4");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where and p.phmBranch =:dept_id order by p.lineId , p.mapId ";
			qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid  order by p.lineId,p.mapId ";
			
			query = em.createQuery(qryStr);
			//query.setParameter("dept_id", dept_id);
		}else if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
			System.out.println("oooooooooo6sss");
			//qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area  order by p.lineId,p.mapId";
			
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			//query.setParameter("dept_id", dept_id);
		}else{
			System.out.println("oooooooooo5sssaaaaaaa");
			
			qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId  order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			 
			
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(line));
			//query.setParameter("dept_id", dept_id);
			
		}
		
		//System.out.println("ooooooooooooooooooooooooo"+new BigDecimal(area));
		//System.out.println("ooooooooooooo11111111111"+new BigDecimal(lineId));
		
		List<Object[]> list = query.getResultList();
		return list;
    } catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}

}

@Override
public List<Object[]> findByAreaForNewMapWayAnalysis(String area, String line,
		String province, String dept_id,String status) {
	
	System.out.println("line : " + line);
	
	long cycleCode = 0;
	List<MvmmsCycle>   cycleList = cycleDao.findAllActiveCycle(dept_id);
	List<Long>   cycleListStr =cycleDao.findAllActiveCycleString();
	
	if(cycleList != null){
		System.out.println("cycleCode 6: ");
		
		int count = cycleList.size() -1;
		for(int i = 0;i < count ; i++){
			System.out.println("cycleCode 7: ");
			
			
			MvmmsCycle cycle = cycleList.get(i);
			cycleCode = new Long(cycle.getId().getCycleId());
			System.out.println("cycleCode 1: "+cycleCode);
				
			String qryStr ="";
			Query query =null;
			
			qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where a.status = 1 and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and a.id.visitid=:visitid  order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			 
			
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(line));
			query.setParameter("dept_id", dept_id);
			query.setParameter("visitid", cycleCode);
			List<Object[]> list = query.getResultList();
			if(list.isEmpty()){
				System.out.println("empty: "+cycleCode);
				cycleCode =201801;
				
				//break;
			}
			else{
				System.out.println("not empty: "+cycleCode);
				break;
			}
			//return list;

		}
		

}
	
	
	try {
		
		System.out.println("area: "+area +" line : "+ line + "province : " + province );
		String qryStr ="";
		Query query =null;
		System.out.println("oooooooooo"+line);
		if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP") ){
			System.out.println("oooooooooo1");
			qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and a.id.visitid=:visitid order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			query.setParameter("dept_id", dept_id);
			query.setParameter("visitid", cycleCode);
			
		}if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("CP2") ){
			System.out.println("oooooooooo1");
			qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and  d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP2') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and a.id.visitid=:visitid order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('CP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			query = em.createQuery(qryStr);
			query.setParameter("dept_id", dept_id);
			query.setParameter("visitid", cycleCode);
			
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("EP") ){
			System.out.println("oooooooooo2");
			//qryStr = "select p,a from MmsAddsupport p , MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			//qryStr = "select p,a,c.type,d.name from MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and a.id.visitid=:visitid order by p.lineId ,p.mapId";
			
			//qryStr = "select p from MmsAddsupport p where p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('EP') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			query = em.createQuery(qryStr);
			query.setParameter("dept_id", dept_id);
			query.setParameter("visitid", cycleCode);
			
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("WPN") ){
			System.out.println("oooooooooo3");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			
			//qryStr = "select p,a from MmsAddsupport p , ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id order by p.lineId ,p.mapId";
			qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area IN (select a from Gldeptm a where a.compId in (select b.compId from Glcompm b where b.parentId in ('WPN') and b.lvlNo<60) and a.deptId like '%.00' ) and p.phmBranch =:dept_id and a.id.visitid=:visitid order by p.lineId ,p.mapId";
			
			query = em.createQuery(qryStr);
			query.setParameter("dept_id", dept_id);
			query.setParameter("visitid", cycleCode);
			
		}else if(area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE") && province.equalsIgnoreCase("NONE") ){
			System.out.println("oooooooooo4");
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where and p.phmBranch =:dept_id order by p.lineId , p.mapId ";
			qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.phmBranch =:dept_id and a.id.visitid=:visitid order by p.lineId,p.mapId ";
			
			query = em.createQuery(qryStr);
			query.setParameter("dept_id", dept_id);
			query.setParameter("visitid", cycleCode);
			
		}else if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
			
			if(cycleCode == 201801){
				System.out.println("oooooooooo6sss");
				//qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where p.status = 1 and a.status = 1 and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id and  a.id.visitid NOT IN (202001,201901) order by p.lineId,p.mapId";
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("dept_id", dept_id);
				//query.setParameter("visitid", cycleCode);
				
				
			}else{
			System.out.println("oooooooooo6sss");
			//qryStr = "select p from MmsAddsupport p where p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			//qryStr = "select p,a from MmsAddsupport p ,MmsTxntowermaintenance a where  p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			qryStr = "select p,a,c.type,d.name,s,e.name from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where p.status = 1 and a.status = 1 and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.phmBranch =:dept_id and a.id.visitid=:visitid order by p.lineId,p.mapId";
			
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("dept_id", dept_id);
			query.setParameter("visitid", cycleCode);
			}
		}else{
			
			
			if(cycleCode == 201801){
				System.out.println("oooooooooo5sssaaaaaaa");
				
				qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where p.status = 1 and a.status = 1 and  e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and  a.id.visitid NOT IN (202001,201901)  order by p.lineId,p.mapId";
				//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
				 
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				query.setParameter("dept_id", dept_id);
				//query.setParameter("visitid", cycleCode);
				
			}
			
			else{
			
			
			System.out.println("oooooooooo5sssaaaaaaa");
			
			qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where p.status = 1 and a.status = 1 and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id and a.id.visitid=:visitid  order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			 
			
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(line));
			query.setParameter("dept_id", dept_id);
			query.setParameter("visitid", cycleCode);
		}
			
		}
		
		//System.out.println("ooooooooooooooooooooooooo"+new BigDecimal(area));
		//System.out.println("ooooooooooooo11111111111"+new BigDecimal(lineId));
		
		List<Object[]> list = query.getResultList();
		return list;
    } catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}

}

@Override
public List<Object[]> findByAreaEngineerForNewMapWayAnalysis(String area,
		String line,String deptId) {
	
	String provinceStr = deptDao.getDD(deptId);
	
	String distDiv = glcompmDao.getDistDivision(provinceStr);
	System.out.print("MapNewSummaryOther"+ distDiv);
	distDiv = distDiv.trim();
	if(distDiv.equalsIgnoreCase("CP") || distDiv.equalsIgnoreCase("CP2") || distDiv.equalsIgnoreCase("EP") || distDiv.equalsIgnoreCase("WPN")){
		deptId ="600.41";
	}else if(distDiv.equalsIgnoreCase("NP") || distDiv.equalsIgnoreCase("NWP2") || distDiv.equalsIgnoreCase("NWP") || distDiv.equalsIgnoreCase("NCP")){
		deptId ="596.00";
	}else if(distDiv.equalsIgnoreCase("UVAP") || distDiv.equalsIgnoreCase("SABP") || distDiv.equalsIgnoreCase("WPSII")){
		deptId ="780.00";
	}else{
		deptId ="600.41";
	}
	
	long cycleCode = 0;
	List<MvmmsCycle>   cycleList = cycleDao.findAllActiveCycle(deptId);
	
	List<Long>   cycleListStr =cycleDao.findAllActiveCycleString();
	System.out.println("cycleCode 6:cycleListStr " + cycleListStr.toString());
	
	if(cycleList != null){
		System.out.println("cycleCode 6: ");
		
		int count = cycleList.size() -1;
		for(int i = 0;i < count ; i++){
			System.out.println("cycleCode 7: " + count);
			
			
			MvmmsCycle cycle = cycleList.get(i);
			System.out.println("cycle 7: " + cycle);
			
			cycleCode = new Long(cycle.getId().getCycleId());
			System.out.println("cycleCode 7: " + count);
			
			
			System.out.println("cycleCode 1: "+cycleCode);
				
			String qryStr ="";
			Query query =null;
			
			
			qryStr = "select p,a,c.type,d.name,s,e.name  from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d ,MmsAddtowerconfiguration e where a.status = 1 and e.id=p.towerConfiguration and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId  and a.id.visitid=:visitid  order by p.lineId,p.mapId";
			//qryStr = "select p from MmsAddsupport p where  p.area = :area and p.lineId = :lineId and p.phmBranch =:dept_id order by p.lineId,p.mapId";
			 
			
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(line));
			//query.setParameter("dept_id", dept_id);
			query.setParameter("visitid", cycleCode);
			List<Object[]> list = query.getResultList();
		
			if(list.isEmpty()){
				System.out.println("empty: "+cycleCode);
				cycleCode =201801;
				
				//break;
			}
			else{
				System.out.println("not empty: "+cycleCode);
				break;
			}
			//return list;

		}
		

}
	
	try {
		
		System.out.println("area: "+area +" line : "+ line );
		String qryStr ="";
		Query query =null;
		System.out.println("oooooooooo"+line);
		 if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
			 
		    if(cycleCode == 201801){
		    	System.out.println("oooooooooo6newcycle");
				qryStr = "select p,a,c.type,d.name,s from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where a.status = 1 and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and a.id.visitid NOT IN (202001,201901) order by p.lineId,p.mapId";
				
				query = em.createQuery(qryStr);
				query.setParameter("area", area);
				//query.setParameter("visitid", cycleListStr);
				System.out.println("ooooooooooggggg"+qryStr.toString());
				
		    	
		    }else{
			 
			 
			 
			System.out.println("oooooooooo6new");
			qryStr = "select p,a,c.type,d.name,s from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where a.status = 1 and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and a.id.visitid=:visitid order by p.lineId,p.mapId";
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("visitid", cycleCode);
		    }
			
			
		}else{
			
			 if(cycleCode == 201801){
			    	System.out.println("oooooooooo6newcycle");
					qryStr = "select p,a,c.type,d.name,s from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where a.status = 1 and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and a.id.visitid NOT IN (202001,201901) order by p.lineId,p.mapId";
					query = em.createQuery(qryStr);
					query.setParameter("area", area);
					//query.setParameter("visitid", cycleListStr);
					query.setParameter("lineId", new BigDecimal(line));
					
			    	
			    }else{
				
			System.out.println("oooooooooo5new");
			qryStr = "select p,a,c.type,d.name,s from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where a.status = 1 and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and a.id.visitid=:visitid order by p.lineId,p.mapId";
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("visitid", cycleCode);
			
			query.setParameter("lineId", new BigDecimal(line));
			    }
		}
		
		List<Object[]> list = query.getResultList();
		return list;
    } catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}
	
}



@Override
public List<Object[]> findByAreaEngineerForNewMapWayAnalysisNew(String area,String line,String cycle) {
	
	
	try {
		
		System.out.println("area: "+area +" line : "+ line+"cycle:"+ cycle );
		String qryStr ="";
		Query query =null;
		System.out.println("oooooooooo"+line);
		
		
		 if(!area.equalsIgnoreCase("NONE") && line.equalsIgnoreCase("NONE")){
			 
		     
			 
			System.out.println("oooooooooo6new");
			qryStr = "select p,a,c.type,d.name,s from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where a.status = 1 and p.status = 1 and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and a.id.visitid=:visitid order by p.lineId,p.mapId";
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("visitid", new Long(cycle));
		    
			
			
		}else{
			
			 	
			System.out.println("oooooooooo5new");
			qryStr = "select p,a,c.type,d.name,s from MmsAddline s,MmsAddsupport p ,MmsTxntowermaintenance a ,MmsAddconductortype c ,MmsTowertype d where a.status = 1 and p.status = 1 and p.lineId = s.id and d.id= p.towerType and c.id=p.conductorType and p.id= a.id.towerid and p.area = :area and p.lineId = :lineId and a.id.visitid=:visitid order by p.lineId,p.mapId";
			query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("visitid", new Long(cycle));
			
			query.setParameter("lineId", new BigDecimal(line));
			    
		}
		
		List<Object[]> list = query.getResultList();
		return list;
    } catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}
	
}


@Override
public List<MmsAddsupport> getIntteruptedList() {
	try {
		String qryStr = "select s from MmsAddsupport s where s.interruptedYes IN (0,1)";
	//	String qryStr = "select * from MmsAddsupport s, MmsTowermaintenance t where s.towerNo=t.id.towerId";
		Query query = em.createQuery(qryStr);
		List<MmsAddsupport> list = query.getResultList();
		return list;
		
	} catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}

}

@Override
public MmsAddsupport getFeederIdentification1(String feederId) {
	try {
		String qryStr = "select s from MmsAddsupport s where s.status =1 and s.feederIdentification=:id ";
	//	String qryStr = "select * from MmsAddsupport s, MmsTowermaintenance t where s.towerNo=t.id.towerId";
		Query query = em.createQuery(qryStr);
		query.setParameter("id", feederId);
		
		List<MmsAddsupport> list = query.getResultList();
		if(list != null){
			return list.get(0);
			
		}
		else{
			return null;
		}
		//return list;
		
	} catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}
	}

@Override
public MmsAddsupport getFeederIdentification2(String feederId) {
	try {
		String qryStr = "select s from MmsAddsupport s where s.status =1 and trim(s.sectionId)=trim(:id) ";
	//	String qryStr = "select * from MmsAddsupport s, MmsTowermaintenance t where s.towerNo=t.id.towerId";
		Query query = em.createQuery(qryStr);
		query.setParameter("id", feederId);
		
		List<MmsAddsupport> list = query.getResultList();
		if(list != null){
			return list.get(0);
			
		}
		else{
			return null;
		}
		//return list;
		
	} catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}
	}



	
		
}

