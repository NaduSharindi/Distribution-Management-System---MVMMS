package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.MmsAddsupport;
import com.it.piv.mms.domain.MmsTxntowermntcomplesion;
import com.it.piv.mms.domain.MmsTxntowermntcomplesionPK;
import com.it.piv.mms.domain.TowerModel;

@Transactional
@Repository
public class MmsTxntowermntcomplesionDaoImpl implements MmsTxntowermntcomplesionDao {

	
	@Autowired
	private EntityManager em;
	@Override
	public String addTowerMaintananceData(
			MmsTxntowermntcomplesion towermaintenance) {
		// TODO Auto-generated method stub
		em.persist(towermaintenance);
		return null;
	}

	@Override
	public String update(MmsTxntowermntcomplesion towermaintenance) {
		// TODO Auto-generated method stub
		em.merge(towermaintenance);
		return null;
	}

	@Override
	public List<MmsTxntowermntcomplesion> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MmsTxntowermntcomplesion> criteria = cb.createQuery(MmsTxntowermntcomplesion.class);
		Root<MmsTxntowermntcomplesion> towerMaintenance = criteria.from(MmsTxntowermntcomplesion.class);
		
		criteria.select(towerMaintenance).orderBy(cb.asc(towerMaintenance.get("id")));
		
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public MmsTxntowermntcomplesion findByID(MmsTxntowermntcomplesionPK id) {
		return em.find(MmsTxntowermntcomplesion.class, id);
	}

	@Override
	public List<MmsTxntowermntcomplesion> findAllByAreaLine(String area,String line) {
		try {
			System.out.println("area :" + area +"line : " + line);
        	String qryStr = "select p,b.towerNo from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id and  b.area = :area and b.lineId = :lineId";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(line));
			List<MmsTxntowermntcomplesion> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<TowerModel> findTowerMntByArea(String area) {
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
	public List<MmsTxntowermntcomplesion> findAllByArea(String area) {
		try {
        	String qryStr = "select p from MmsTxntowermntcomplesion p where p.area = :area";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			//query.setParameter("lineId", line);
			List<MmsTxntowermntcomplesion> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public String getTowerIDByTowerNo(String towerNo) {
		try {
        	String qryStr = "select a.id.towerid  from MmsTxntowermntcomplesion a where a.towerNo = :towerNo";
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
	public List<MmsTxntowermntcomplesion> findAllByAreaLineCycle(String area,String line, String cycle) {
		
		try {
			System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
        	String qryStr = "select p,b.towerNo from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id and  b.area = :area and b.lineId = :lineId and p.id.visitid=:visitid ";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("lineId", new BigDecimal(line));
			query.setParameter("visitid", new Long(cycle));
			List<MmsTxntowermntcomplesion> list = query.getResultList();
			return list;
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		// TODO Auto-generated method stub
		//return null;
	}

/*	@Override
	public List<MmsTxntowermaintenance> findAllByAreaLineCycle(String area,String line, String cycle, String status) {
		try {
			if(cycle.equals("201801")){
				System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
	        	String qryStr = "select p from MmsTxntowermaintenance p ,MmsAddsupport b where p.id.towerid=b.id and  b.area = :area and b.lineId = :lineId and p.id.visitid NOT IN ('201802','201901','201902','202001','202002') and p.status=:status ";
				Query query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				//query.setParameter("visitid", new Long(cycle));
				query.setParameter("status", new BigDecimal(status));
				List<MmsTxntowermaintenance> list = query.getResultList();
				System.out.println("area :" + qryStr);
	        	
				return list;
			}else{
				System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
	        	String qryStr = "select p from MmsTxntowermaintenance p ,MmsAddsupport b where p.id.towerid=b.id and  b.area = :area and b.lineId = :lineId and p.id.visitid=:visitid and p.status=:status ";
				Query query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				query.setParameter("visitid", new Long(cycle));
				query.setParameter("status", new BigDecimal(status));
				List<MmsTxntowermaintenance> list = query.getResultList();
				System.out.println("area2 :" + qryStr);
				return list;
				
			}
			
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}*/
	
	@Override
	public List<MmsTxntowermntcomplesion> findAllByAreaLineCycle(String area,String line, String cycle, String status) {
		try {
			if(cycle.equals("NONE") && line.equals("NONE")  && area.equals("NONE")){
				System.out.println("cccc cycle.equals(NONE) && line.equals(NONE)  && area.equals(NONE)" );
				System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
	        	//String qryStr = "select p,b.towerNo from MmsTxntowermaintenance p ,MmsAddsupport b where p.id.towerid=b.id";
				String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id and p.status=:status order by b.lineId ,b.mapId ,p.id.visitid";
				
				
				Query query = em.createQuery(qryStr);
				//query.setParameter("area", area);
				//query.setParameter("lineId", new BigDecimal(line));
				//query.setParameter("visitid", new Long(cycle));
				query.setParameter("status", new BigDecimal(status));
				List<MmsTxntowermntcomplesion> list = query.getResultList();
				return list;
			}else if(cycle.equals("NONE") && !line.equals("NONE")  && !area.equals("NONE")){
				System.out.println("cccc cycle.equals(NONE) && !line.equals(NONE)  && !area.equals(NONE)" );
				
				System.out.println("cccc");
				System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
	        	String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id  and  b.area = :area and b.lineId = :lineId  and p.status=:status order by b.lineId ,b.mapId ,p.id.visitid";
				Query query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				//query.setParameter("visitid", new Long(cycle));
				query.setParameter("status", new BigDecimal(status));
				List<MmsTxntowermntcomplesion> list = query.getResultList();
				return list;
			}else if(cycle.equals("NONE") && line.equals("NONE")  && !area.equals("NONE")){
				System.out.println("cccc cycle.equals(NONE) && line.equals(NONE)  && !area.equals(NONE)" );
				
				System.out.println("cccc");
				System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
	        	String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id  and  b.area = :area  and p.status=:status order by b.lineId ,b.mapId ,p.id.visitid";
				Query query = em.createQuery(qryStr);
				query.setParameter("area", area);
				//query.setParameter("lineId", new BigDecimal(line));
				//query.setParameter("visitid", new Long(cycle));
				query.setParameter("status", new BigDecimal(status));
				List<MmsTxntowermntcomplesion> list = query.getResultList();
				return list;
			}else if(!cycle.equals("NONE") && line.equals("NONE")  && area.equals("NONE")){
				System.out.println("cccc !cycle.equals(NONE) && !line.equals(NONE)  && area.equals(NONE)" );
				
				List<MmsTxntowermntcomplesion> list = null;
				if(cycle.equals("201801")){
					System.out.println("dddd");
					System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
		        	String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id and  p.id.visitid NOT IN ('201802','201901','201902','202001','202002') and p.status=:status order by b.lineId ,b.mapId ,p.id.visitid";
					Query query = em.createQuery(qryStr);
					//query.setParameter("area", area);
					//query.setParameter("lineId", new BigDecimal(line));
					//query.setParameter("visitid", new Long(cycle));
					query.setParameter("status", new BigDecimal(status));
					list = query.getResultList();
					
				}else{
					System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
		        	String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id  and p.id.visitid=:visitid  and p.status=:status order by b.lineId ,b.mapId ,p.id.visitid";
					Query query = em.createQuery(qryStr);
					//query.setParameter("area", area);
					//query.setParameter("lineId", new BigDecimal(line));
					query.setParameter("visitid", new Long(cycle));
					query.setParameter("status", new BigDecimal(status));
					list = query.getResultList();
					
				}
				return list;	
				
			}else if(!cycle.equals("NONE") && line.equals("NONE")  && !area.equals("NONE")){
				System.out.println("cccc !cycle.equals(NONE) && line.equals(NONE)  && !area.equals(NONE)" );
				
				List<MmsTxntowermntcomplesion> list = null;
				if(cycle.equals("201801")){
					System.out.println("dddd");
					System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
		        	String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id and  p.id.visitid NOT IN ('201802','201901','201902','202001','202002') and p.status=:status and  b.area = :area order by b.lineId ,b.mapId ,p.id.visitid";
					Query query = em.createQuery(qryStr);
					query.setParameter("area", area);
					//query.setParameter("lineId", new BigDecimal(line));
					//query.setParameter("visitid", new Long(cycle));
					query.setParameter("status", new BigDecimal(status));
					list = query.getResultList();
					
				}else{
					System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle + " status : " + status);
		        	String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id  and p.id.visitid=:visitid  and p.status=:status and  b.area = :area order by b.lineId ,b.mapId ,p.id.visitid ";
					Query query = em.createQuery(qryStr);
					query.setParameter("area", area);
					//query.setParameter("lineId", new BigDecimal(line));
					query.setParameter("visitid", new Long(cycle));
					query.setParameter("status", new BigDecimal(status));
					list = query.getResultList();
					
				}
				return list;	
				
			}
			
			
			
			else if(!cycle.equals("NONE") && !line.equals("NONE")  && area.equals("NONE")){
				System.out.println("cccc !cycle.equals(NONE) && !line.equals(NONE)  && area.equals(NONE)" );
				
				List<MmsTxntowermntcomplesion> list = null;
				if(cycle.equals("201801")){
					System.out.println("dddd");
					System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
		        	String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id and  p.id.visitid NOT IN ('201802','201901','201902','202001','202002') and b.lineId = :lineId and p.status=:status order by b.lineId ,b.mapId ,p.id.visitid";
					Query query = em.createQuery(qryStr);
					//query.setParameter("area", area);
					query.setParameter("lineId", new BigDecimal(line));
					//query.setParameter("visitid", new Long(cycle));
					query.setParameter("status", new BigDecimal(status));
					list = query.getResultList();
					
				}else{
					System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle + "status : " + status);
					String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id  and  and p.id.visitid=:visitid  and b.lineId = :lineId and p.status=:status order by b.lineId ,b.mapId ,p.id.visitid ";
					Query query = em.createQuery(qryStr);
					//query.setParameter("area", area);
					query.setParameter("lineId", new BigDecimal(line));
					query.setParameter("visitid", new Long(cycle));
					query.setParameter("status", new BigDecimal(status));
					list = query.getResultList();
					
				}
				return list;	
				
				
				
				
				
				/*System.out.println("cccc");
				System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
	        	String qryStr = "select p,b.towerNo from MmsTxntowermaintenance p ,MmsAddsupport b where p.id.towerid=b.id  and  and p.id.visitid=:visitid  and b.lineId = :lineId ";
				Query query = em.createQuery(qryStr);
				//query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				query.setParameter("visitid", new Long(cycle));
				//query.setParameter("status", new BigDecimal(status));
				List<MmsTxntowermaintenance> list = query.getResultList();
				return list;*/
		}else if(!cycle.equals("NONE") && !line.equals("NONE")  && !area.equals("NONE")){
			System.out.println("cccc !cycle.equals(NONE) && !line.equals(NONE)  && !area.equals(NONE)" );
			
				List<MmsTxntowermntcomplesion> list = null;
				if(cycle.equals("201801")){
					System.out.println("dddd");
					System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
		        	String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id and  p.id.visitid NOT IN ('201802','201901','201902','202001','202002') and b.lineId = :lineId and  b.area = :area and p.status=:status order by b.lineId ,b.mapId ,p.id.visitid ";
		        	System.out.println("dddd1");
		        	Query query = em.createQuery(qryStr);
		        	System.out.println("dddd2");
					query.setParameter("area", area);
					System.out.println("dddd3");
					query.setParameter("lineId", new BigDecimal(line));
					System.out.println("dddd4");
					//query.setParameter("visitid", new Long(cycle));
					query.setParameter("status", new BigDecimal(status));
					list = query.getResultList();
					System.out.println("dddd5");
					
				}else{
					try {
						System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle +"status "+ status);
						System.out.println("arrrrrr");
						
						
						String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id  and  p.id.visitid=:visitid  and b.lineId = :lineId and  b.area = :area and p.status=:status order by b.lineId ,b.mapId ,p.id.visitid ";
						Query query = em.createQuery(qryStr);
						query.setParameter("area", area);
						query.setParameter("lineId", new BigDecimal(line));
						query.setParameter("visitid", new Long(cycle));
						query.setParameter("status", new BigDecimal(status));
						list = query.getResultList();
						System.out.println("arrrrrrlist : " +list.size());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				System.out.println("dddd6");
				return list;	
				
				
				
				
				
				/*System.out.println("cccc");
				System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
	        	String qryStr = "select p,b.towerNo from MmsTxntowermaintenance p ,MmsAddsupport b where p.id.towerid=b.id  and  and p.id.visitid=:visitid  and b.lineId = :lineId ";
				Query query = em.createQuery(qryStr);
				//query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				query.setParameter("visitid", new Long(cycle));
				//query.setParameter("status", new BigDecimal(status));
				List<MmsTxntowermaintenance> list = query.getResultList();
				return list;*/
			}
			else{
				System.out.println("eeee");
				System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
	        	String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id and  b.area = :area and b.lineId = :lineId and p.id.visitid=:visitid and p.status=:status order by b.lineId ,b.mapId ,p.id.visitid ";
				Query query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				query.setParameter("visitid", new Long(cycle));
				query.setParameter("status", new BigDecimal(status));
				List<MmsTxntowermntcomplesion> list = query.getResultList();
				return list;
				
			}
			
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public List<MmsTxntowermntcomplesion> findAllTMByStatus(String area,String line, String cycle) {
		
		
		try {
			if(cycle.equals("NONE") && line.equals("NONE")  && area.equals("NONE")){
				System.out.println("cccc cycle.equals(NONE) && line.equals(NONE)  && area.equals(NONE)" );
				System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
	        	//String qryStr = "select p,b.towerNo from MmsTxntowermaintenance p ,MmsAddsupport b where p.id.towerid=b.id";
				String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id";
				
				
				Query query = em.createQuery(qryStr);
				//query.setParameter("area", area);
				//query.setParameter("lineId", new BigDecimal(line));
				//query.setParameter("visitid", new Long(cycle));
				//query.setParameter("status", new BigDecimal(status));
				List<MmsTxntowermntcomplesion> list = query.getResultList();
				return list;
			}else if(cycle.equals("NONE") && !line.equals("NONE")  && !area.equals("NONE")){
				System.out.println("cccc cycle.equals(NONE) && !line.equals(NONE)  && !area.equals(NONE)" );
				
				System.out.println("cccc");
				System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
	        	String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id  and  b.area = :area and b.lineId = :lineId";
				Query query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				//query.setParameter("visitid", new Long(cycle));
				//query.setParameter("status", new BigDecimal(status));
				List<MmsTxntowermntcomplesion> list = query.getResultList();
				return list;
			}else if(cycle.equals("NONE") && line.equals("NONE")  && !area.equals("NONE")){
				System.out.println("cccc cycle.equals(NONE) && line.equals(NONE)  && !area.equals(NONE)" );
				
				System.out.println("cccc");
				System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
	        	String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id  and  b.area = :area";
				Query query = em.createQuery(qryStr);
				query.setParameter("area", area);
				//query.setParameter("lineId", new BigDecimal(line));
				//query.setParameter("visitid", new Long(cycle));
				//query.setParameter("status", new BigDecimal(status));
				List<MmsTxntowermntcomplesion> list = query.getResultList();
				return list;
			}else if(!cycle.equals("NONE") && line.equals("NONE")  && area.equals("NONE")){
				System.out.println("cccc !cycle.equals(NONE) && !line.equals(NONE)  && area.equals(NONE)" );
				
				List<MmsTxntowermntcomplesion> list = null;
				if(cycle.equals("201801")){
					System.out.println("dddd");
					System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
		        	String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id and  p.id.visitid NOT IN ('201802','201901','201902','202001','202002')";
					Query query = em.createQuery(qryStr);
					//query.setParameter("area", area);
					//query.setParameter("lineId", new BigDecimal(line));
					//query.setParameter("visitid", new Long(cycle));
					//query.setParameter("status", new BigDecimal(status));
					list = query.getResultList();
					
				}else{
					System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
		        	String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id  and  and p.id.visitid=:visitid";
					Query query = em.createQuery(qryStr);
					//query.setParameter("area", area);
					//query.setParameter("lineId", new BigDecimal(line));
					query.setParameter("visitid", new Long(cycle));
					//query.setParameter("status", new BigDecimal(status));
					list = query.getResultList();
					
				}
				return list;	
				
			}else if(!cycle.equals("NONE") && !line.equals("NONE")  && area.equals("NONE")){
				System.out.println("cccc !cycle.equals(NONE) && !line.equals(NONE)  && area.equals(NONE)" );
				
				List<MmsTxntowermntcomplesion> list = null;
				if(cycle.equals("201801")){
					System.out.println("dddd");
					System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
		        	String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id and  p.id.visitid NOT IN ('201802','201901','201902','202001','202002') and b.lineId = :lineId";
					Query query = em.createQuery(qryStr);
					//query.setParameter("area", area);
					query.setParameter("lineId", new BigDecimal(line));
					//query.setParameter("visitid", new Long(cycle));
					//query.setParameter("status", new BigDecimal(status));
					list = query.getResultList();
					
				}else{
					System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
					String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id  and  and p.id.visitid=:visitid  and b.lineId = :lineId ";
					Query query = em.createQuery(qryStr);
					//query.setParameter("area", area);
					query.setParameter("lineId", new BigDecimal(line));
					query.setParameter("visitid", new Long(cycle));
					//query.setParameter("status", new BigDecimal(status));
					list = query.getResultList();
					
				}
				return list;	
				
				
				
				
				
				/*System.out.println("cccc");
				System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
	        	String qryStr = "select p,b.towerNo from MmsTxntowermaintenance p ,MmsAddsupport b where p.id.towerid=b.id  and  and p.id.visitid=:visitid  and b.lineId = :lineId ";
				Query query = em.createQuery(qryStr);
				//query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				query.setParameter("visitid", new Long(cycle));
				//query.setParameter("status", new BigDecimal(status));
				List<MmsTxntowermaintenance> list = query.getResultList();
				return list;*/
		}else if(!cycle.equals("NONE") && !line.equals("NONE")  && !area.equals("NONE")){
			System.out.println("cccc !cycle.equals(NONE) && !line.equals(NONE)  && !area.equals(NONE)" );
			
				List<MmsTxntowermntcomplesion> list = null;
				if(cycle.equals("201801")){
					System.out.println("dddd");
					System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
		        	String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id and  p.id.visitid NOT IN ('201802','201901','201902','202001','202002') and b.lineId = :lineId and  b.area = :area";
		        	System.out.println("dddd1");
		        	Query query = em.createQuery(qryStr);
		        	System.out.println("dddd2");
					query.setParameter("area", area);
					System.out.println("dddd3");
					query.setParameter("lineId", new BigDecimal(line));
					System.out.println("dddd4");
					//query.setParameter("visitid", new Long(cycle));
					//query.setParameter("status", new BigDecimal(status));
					list = query.getResultList();
					System.out.println("dddd5");
					
				}else{
					System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
							
							
							
							String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id  and  p.id.visitid=:visitid  and b.lineId = :lineId and  b.area = :area ";
					Query query = em.createQuery(qryStr);
					query.setParameter("area", area);
					query.setParameter("lineId", new BigDecimal(line));
					query.setParameter("visitid", new Long(cycle));
					//query.setParameter("status", new BigDecimal(status));
					list = query.getResultList();
					
				}
				System.out.println("dddd6");
				return list;	
				
				
				
				
				
				/*System.out.println("cccc");
				System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
	        	String qryStr = "select p,b.towerNo from MmsTxntowermaintenance p ,MmsAddsupport b where p.id.towerid=b.id  and  and p.id.visitid=:visitid  and b.lineId = :lineId ";
				Query query = em.createQuery(qryStr);
				//query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				query.setParameter("visitid", new Long(cycle));
				//query.setParameter("status", new BigDecimal(status));
				List<MmsTxntowermaintenance> list = query.getResultList();
				return list;*/
			}
			else{
				System.out.println("eeee");
				System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
	        	String qryStr = "select p from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id and  b.area = :area and b.lineId = :lineId and p.id.visitid=:visitid";
				Query query = em.createQuery(qryStr);
				query.setParameter("area", area);
				query.setParameter("lineId", new BigDecimal(line));
				query.setParameter("visitid", new Long(cycle));
				//query.setParameter("status", new BigDecimal(status));
				List<MmsTxntowermntcomplesion> list = query.getResultList();
				return list;
				
			}
			
        } catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<MmsTxntowermntcomplesion> getMNTByStatus(String status) {
		TypedQuery<MmsTxntowermntcomplesion> query =
				em.createQuery
				("SELECT cd "
				+ "FROM MmsTxntowermaintenance cd "
				+ "WHERE cd.status= :status", MmsTxntowermntcomplesion.class) ;
					 query.setParameter("status",new BigDecimal(status));
					 //query.setParameter("status2","2");
					// query.setParameter("Level",approvalLevel.trim());
					 System.out.print(query);
					return query.getResultList();
	}
	
	//edited anushka 2019-01-11 ---------------------------------------------------------------------------------------------------
		public List<MmsTxntowermntcomplesion> findAllByStatus(String status) {
			TypedQuery<MmsTxntowermntcomplesion> query =
	                em.createQuery
	                ("SELECT cd "
	                + "FROM MmsTxntowermntcomplesion cd "
	                + "WHERE cd.status= :status", MmsTxntowermntcomplesion.class) ;
	                     query.setParameter("status",new BigDecimal(status));
	                     //query.setParameter("status2","2");
	                    // query.setParameter("Level",approvalLevel.trim());
	                     System.out.print(query);
	                    return query.getResultList();
		}
		//-----------------------------------------------------------------------------------------------------------------------------

		@Override
		public List<Object[]> findAllByAreaLineCycleNew(String area,
				String line, String cycle, String status) {
			try {
				if(cycle.equals("201801")){
					System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
		        	String qryStr = "select p,b.towerNo from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id and  b.area = :area and b.lineId = :lineId and p.id.visitid NOT IN ('201802','201901','201902','202001','202002')";
					Query query = em.createQuery(qryStr);
					query.setParameter("area", area);
					query.setParameter("lineId", new BigDecimal(line));
					//query.setParameter("visitid", new Long(cycle));
					//query.setParameter("status", new BigDecimal(status));
					List<Object[]> list = query.getResultList();
					return list;
				}else{
					System.out.println("area :" + area +"line : " + line+ "cycle : " + cycle);
		        	String qryStr = "select p,b.towerNo from MmsTxntowermntcomplesion p ,MmsAddsupport b where p.id.towerid=b.id and  b.area = :area and b.lineId = :lineId and p.id.visitid=:visitid";
					Query query = em.createQuery(qryStr);
					query.setParameter("area", area);
					query.setParameter("lineId", new BigDecimal(line));
					query.setParameter("visitid", new Long(cycle));
					//query.setParameter("status", new BigDecimal(status));
					List<Object[]> list = query.getResultList();
					return list;
					
				}
				
	        } catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}

}
