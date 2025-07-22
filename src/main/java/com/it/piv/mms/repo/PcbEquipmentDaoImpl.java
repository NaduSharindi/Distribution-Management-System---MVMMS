package com.it.piv.mms.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jfree.data.time.Year;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.mms.domain.PcbCondition;
import com.it.piv.mms.domain.PcbEquipment;
import com.it.piv.mms.domain.PcbLocation;
import com.it.piv.mms.domain.PcbModel;
import com.it.piv.mms.domain.PcbSample;


@Transactional
@Repository
public class PcbEquipmentDaoImpl implements PcbEquipmentDao {

	@Autowired
	private EntityManager em;
	
	

	@Override
	public String addEquipment(PcbEquipment pcbEquipment) {
		em.persist(pcbEquipment);
		return null;
	}

	@Override
	public String getNextEquipmentId(String applicationNoPrefix) {
		String sequence = null;
		System.out.println("getNextEquipmentId");
		String like = applicationNoPrefix + "%";

		String strQuery = "select equipment_Id from PCB_EQUIPMENT where equipment_Id like '"
				+ like + "' ORDER BY 1 DESC";

		Query query = em.createNativeQuery(strQuery);// SELECT
														// MIS.TEST4_SEQ.NEXTVAL()
														// FROM DUAL
		List<String> list = query.getResultList();

		if (list.size() != 0) {

			sequence = query.getResultList().get(0).toString().trim();

			System.out.println( "getNextEquipmentId : " +  sequence);

			// sequence=sequence.substring(16);//total 20
			// sequence=sequence.substring(14);//total 18
			// sequence=sequence.substring(13);//total 18
			// 430.25/CNT/13/0073
			System.out.println("char: ");
			char deptStr = ' ';
			/*
			 * try{ deptStr = sequence.charAt(3); }catch(Exception e){
			 * System.out.println("char: " + e); } System.out.println("char: " +
			 * deptStr); System.out.println("char: " + sequence);
			 */
			/*
			 * if(deptStr == '/'){ sequence=sequence.substring(14); }else{
			 * System.out.println("charddd: "); sequence=sequence.substring(13);
			 * }
			 */
			//sequence = sequence.substring(3);
			
			int seq = 0;
			try {
				seq = sequence.indexOf("_");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("char:1 " + seq);
			
			sequence = sequence.substring(seq+1);

			System.out.println("sequence1: " + sequence);

			Integer i = new Integer(0);

			i = Integer.parseInt(sequence) + 1;

			sequence = i.toString();
			System.out.println("sequence2: " + sequence);


		} else {
			sequence = "00001";
			System.out.println(sequence);
		}
		System.out.println("getNextApplicationNo : " + sequence);

		if (sequence.length() == 1){
			System.out.println("sequence3: " + sequence);
			return "0000" + sequence;
		}
		else if (sequence.length() == 2){
			System.out.println("sequence4: " + sequence);
			return "000" + sequence;
		}
		else if (sequence.length() == 3){
			System.out.println("sequence5: " + sequence);
			return "00" + sequence;
		}
		else if (sequence.length() == 4){
			System.out.println("sequence6: " + sequence);
			return "0" + sequence;
		}
		else
			return sequence;
	}

	public PcbEquipment findEquipmentByEquipmentId(String equipmentId) {
		return em.find(PcbEquipment.class, equipmentId);
	}

	@Override
	public String updateEquipment(PcbEquipment equipment) {
		em.merge(equipment);
		return null;
	}

	@Override
	public List<String> findEquipmentIdsForPcbSample(String division,
			String manufactureLtl, String seriaType, String year) {
		try {
			// String qryStr =
			// "select p from MmsAddline p where p.status =:status and p.phmBranch=:phmbranch ORDER BY p.lineName ";
			String qryStr = "select a.equipmentId from PcbEquipment a  where a.divison =:division and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType ORDER BY a.equipmentId";
			//String qryStr = "select a.equipmentId from PcbEquipment a  where a.divison =:division and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType and ('EXTRACT(YEAR FROM ?)', a.manufactureDate) AS YEAR =:year ORDER BY a.equipmentId";
			Query query = em.createQuery(qryStr);
			query.setParameter("division", division);
			query.setParameter("manufactureLtl", manufactureLtl);
			query.setParameter("seriaType", seriaType);
			//query.setParameter("year", year);
			List<String> list = query.getResultList();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<String> findEquipmentIdsByDate(Date startDate, Date endDate) {
		try {
			String qryStr = "select a.equipmentId from PcbEquipment a where a.manufactureDate between :startDate and :endDate ORDER BY a.equipmentId";
			Query query = em.createQuery(qryStr);
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			List<String> list = query.getResultList();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<PcbEquipment> findEquipmentList(List<String> equipmentIdList) {
		List<PcbEquipment> equipmentList = new ArrayList<PcbEquipment>();

		for (int i = 0; i < equipmentIdList.size(); i++) {
			equipmentList
					.add(findEquipmentByEquipmentId(equipmentIdList.get(i)));
		}
		return equipmentList;
	}

	@Override
	public List<String> findEquipmentIdsForPcbSample1(String division,String manufactureLtl, String seriaType, Year year) {
		try {
			// String qryStr =
			// "select p from MmsAddline p where p.status =:status and p.phmBranch=:phmbranch ORDER BY p.lineName ";
			// String qryStr =
			// "select a.equipmentId from PcbEquipment a  where a.divison =:division and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType ORDER BY a.equipmentId";
			String qryStr = "select a.equipmentId from PcbEquipment a  where a.divison =:division and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType and ('EXTRACT(YEAR FROM ?)', a.manufactureDate) AS YEAR =:year ORDER BY a.equipmentId";
			Query query = em.createQuery(qryStr);
			query.setParameter("division", division);
			query.setParameter("manufactureLtl", manufactureLtl);
			query.setParameter("seriaType", seriaType);
			query.setParameter("year", year);
			List<String> list = query.getResultList();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<PcbEquipment> findEquiByAreaStatus(String area, String status) {
		try {
			String qryStr = "select a from PcbEquipment a  where trim(a.unit) =:area and a.status=:status ORDER BY a.equipmentId";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area.trim());
			query.setParameter("status", new BigDecimal(status));
			List<PcbEquipment> list = query.getResultList();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}	
	}

	@Override
	public List<String> findEquipmentIdsForCategory1(String division,String manufactureLtl, String seriaType, String year) {
		try {
			// String qryStr =
			// "select p from MmsAddline p where p.status =:status and p.phmBranch=:phmbranch ORDER BY p.lineName ";
			// String qryStr =
			// "select a.equipmentId from PcbEquipment a  where a.divison =:division and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType ORDER BY a.equipmentId";
			String qryStr = "select a.equipmentId from PcbEquipment a  where a.divison IN ('TDT','GDT') ORDER BY a.equipmentId";
			Query query = em.createQuery(qryStr);
			List<String> list = query.getResultList();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<PcbEquipment> findEquipmenListsForCategory1(String division,String manufactureLtl, String seriaType, String year,String area) {
		try {
			// String qryStr =
			// "select p from MmsAddline p where p.status =:status and p.phmBranch=:phmbranch ORDER BY p.lineName ";
			// String qryStr =
			// "select a.equipmentId from PcbEquipment a  where a.divison =:division and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType ORDER BY a.equipmentId";
			String qryStr = "select a from PcbEquipment a  where a.divison IN ('TDT','GDT') and a.area =:area  ORDER BY a.equipmentId";
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			
			List<PcbEquipment> list = query.getResultList();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<PcbEquipment> findEquipmenListsForCategoryDivUnit(String division,String manufactureLtl, String sealType, String year,String area,String unit,String branch) {
		try {
			
			
			String qryStr = "";
			int yearInt = Integer.valueOf(year); 
			//Category 1 Transmission transformers test all
			if(division.compareTo("TR")== 0){
				qryStr = "select a from PcbEquipment a  where a.divison =:division and a.branch =:branch and a.unit =:unit ORDER BY a.equipmentId";
				System.out.println("qryStr : " +qryStr);
				Query query = em.createQuery(qryStr);
				//query.setParameter("area", area);
				//query.setParameter("seriaType", seriaType);
				//query.setParameter("manufactureLtl", manufactureLtl);
				query.setParameter("division", division);
				query.setParameter("branch", branch);
				query.setParameter("unit", unit);
				
				List<PcbEquipment> list = query.getResultList();
				return list;
				
			}
			//Category 1 Generation transformers test all
			else if(division.compareTo("GN")== 0){
				qryStr = "select a from PcbEquipment a  where a.divison =:division and a.branch =:branch and a.unit =:unit ORDER BY a.equipmentId";
				System.out.println("qryStr : " +qryStr);
				Query query = em.createQuery(qryStr);
				//query.setParameter("area", area);
				//query.setParameter("seriaType", seriaType);
				//query.setParameter("manufactureLtl", manufactureLtl);
				query.setParameter("division", division);
				query.setParameter("branch", branch);
				query.setParameter("unit", unit);
				
				List<PcbEquipment> list = query.getResultList();
				return list;
				
			}
			//Category 2 Distribution transformers			
			else if (division.compareTo("DD1")== 0 || division.compareTo("DD2")== 0 || division.compareTo("DD3")== 0 || division.compareTo("DD4")== 0){
				//LTL Yes
				if(manufactureLtl.compareTo("Yes") == 0){
					//Seal Type seal
					if(sealType.compareTo("seal") == 0){
						//year before 1990
						if(yearInt == 1){
							qryStr = "select a from PcbEquipment a  where a.divison =:division and a.branch =:branch and a.unit =:unit and a.manufactureBrand=:manufactureLtl and a.type =:seriaType and a.manufactureDate < to_date('1990-01-01','YYYY-MM-DD') ORDER BY a.equipmentId";
							System.out.println("qryStr : " +qryStr);
							Query query = em.createQuery(qryStr);
							//query.setParameter("area", area);
							query.setParameter("seriaType", "Yes");
							query.setParameter("manufactureLtl", "LTL");
							query.setParameter("division", division);
							query.setParameter("branch", branch);
							query.setParameter("unit", unit);
							
							List<PcbEquipment> list = query.getResultList();
							return list;
						}
						//year after 1990 no sampling
						else{
							
						}
					}
					//Seal Type non seal
					else{
						qryStr = "select a from PcbEquipment a  where a.divison =:division and a.branch =:branch and a.unit =:unit and a.manufactureBrand=:manufactureLtl and a.type NOT LIKE 'Yes%' ORDER BY a.equipmentId";
						System.out.println("qryStr : " +qryStr);
						Query query = em.createQuery(qryStr);
						//query.setParameter("area", area);
						//query.setParameter("seriaType", "Yes");
						query.setParameter("manufactureLtl", "LTL");
						query.setParameter("division", division);
						query.setParameter("branch", branch);
						query.setParameter("unit", unit);
						
						List<PcbEquipment> list = query.getResultList();
						return list;
		
						
					}
				//LTL No other transformers	
				}else{
					if(sealType.compareTo("seal") == 0){
						//year before 1990
						if(yearInt < 1990){
							qryStr = "select a from PcbEquipment a  where a.divison =:division and a.branch =:branch and a.unit =:unit and a.manufactureBrand NOT LIKE 'LTL%' and a.type =:seriaType and a.manufactureDate < to_date('1990-01-01','YYYY-MM-DD') ORDER BY a.equipmentId";
							System.out.println("qryStr : " +qryStr);
							Query query = em.createQuery(qryStr);
							//query.setParameter("area", area);
							query.setParameter("seriaType", "Yes");
							//query.setParameter("manufactureLtl", "LTL");
							query.setParameter("division", division);
							query.setParameter("branch", branch);
							query.setParameter("unit", unit);
							
							List<PcbEquipment> list = query.getResultList();
							return list;
						}
						//year after 1990 no sampling
						else{
							
						}
					}
					//Seal Type non seal
					else{
						qryStr = "select a from PcbEquipment a  where a.divison =:division and a.branch =:branch and a.unit =:unit and a.manufactureBrand NOT LIKE 'LTL%' and a.type NOT LIKE 'Yes%' ORDER BY a.equipmentId";
						System.out.println("qryStr : " +qryStr);
						Query query = em.createQuery(qryStr);
						//query.setParameter("area", area);
						//query.setParameter("seriaType", "Yes");
						//query.setParameter("manufactureLtl", "LTL");
						query.setParameter("division", division);
						query.setParameter("branch", branch);
						query.setParameter("unit", unit);
						
						List<PcbEquipment> list = query.getResultList();
						return list;
				
						
					}	
					
				}
			}
			
			else{
				
			}
			
			
			
			
			/*if(year.equalsIgnoreCase("1")){
				qryStr = "select a from PcbEquipment a  where a.divison =:division and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType and a.area =:area and a.year < 1990 ORDER BY a.equipmentId";
				
			}if(year.equalsIgnoreCase("2")){
				qryStr = "select a from PcbEquipment a  where a.divison =:division and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType and a.area =:area and a.year > 1990 ORDER BY a.equipmentId";
				
			}
			if(year.equalsIgnoreCase("3")){
				qryStr = "select a from PcbEquipment a  where a.divison =:division and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType and a.area =:area and a.year > 2000 ORDER BY a.equipmentId";
				
			}
			
			System.out.println("qryStr : " +qryStr);
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("seriaType", seriaType);
			query.setParameter("manufactureLtl", manufactureLtl);
			query.setParameter("division", division);
			
			List<PcbEquipment> list = query.getResultList();
			return list;*/
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return null;
	}
	
	@Override
	public List<PcbEquipment> findEquipmenListsForCategory(String division,String manufactureLtl, String sealType, String year,String area) {
		try {
			
			
			String qryStr = "";
			int yearInt = Integer.valueOf(year); 
			//Category 1 Transmission transformers test all
			if(division.compareTo("TR")== 0){
				qryStr = "select a from PcbEquipment a  where a.divison =:division ORDER BY a.equipmentId";
				System.out.println("qryStr : " +qryStr);
				Query query = em.createQuery(qryStr);
				//query.setParameter("area", area);
				//query.setParameter("seriaType", seriaType);
				//query.setParameter("manufactureLtl", manufactureLtl);
				query.setParameter("division", division);
				
				List<PcbEquipment> list = query.getResultList();
				return list;
				
			}
			//Category 1 Generation transformers test all
			else if(division.compareTo("GN")== 0){
				qryStr = "select a from PcbEquipment a  where a.divison =:division ORDER BY a.equipmentId";
				System.out.println("qryStr : " +qryStr);
				Query query = em.createQuery(qryStr);
				//query.setParameter("area", area);
				//query.setParameter("seriaType", seriaType);
				//query.setParameter("manufactureLtl", manufactureLtl);
				query.setParameter("division", division);
				
				List<PcbEquipment> list = query.getResultList();
				return list;
				
			}
			//Category 2 Distribution transformers			
			else if (division.compareTo("DD1")== 0 || division.compareTo("DD2")== 0 || division.compareTo("DD3")== 0 || division.compareTo("DD4")== 0){
				//LTL Yes
				if(manufactureLtl.compareTo("Yes") == 0){
					//Seal Type seal
					if(sealType.compareTo("seal") == 0){
						//year before 1990
						if(yearInt == 1){
							qryStr = "select a from PcbEquipment a  where a.divison =:division and a.manufactureBrand=:manufactureLtl and a.type =:seriaType and a.manufactureDate < to_date('1990-01-01','YYYY-MM-DD') ORDER BY a.equipmentId";
							System.out.println("qryStr : " +qryStr);
							Query query = em.createQuery(qryStr);
							//query.setParameter("area", area);
							query.setParameter("seriaType", "Yes");
							query.setParameter("manufactureLtl", "LTL");
							query.setParameter("division", division);
							
							List<PcbEquipment> list = query.getResultList();
							return list;
						}
						//year after 1990 no sampling
						else{
							
						}
					}
					//Seal Type non seal
					else{
						qryStr = "select a from PcbEquipment a  where a.divison =:division and a.manufactureBrand=:manufactureLtl and a.type NOT LIKE 'Yes%' ORDER BY a.equipmentId";
						System.out.println("qryStr : " +qryStr);
						Query query = em.createQuery(qryStr);
						//query.setParameter("area", area);
						//query.setParameter("seriaType", "Yes");
						query.setParameter("manufactureLtl", "LTL");
						query.setParameter("division", division);
						
						List<PcbEquipment> list = query.getResultList();
						return list;
		
						
					}
				//LTL No other transformers	
				}else{
					if(sealType.compareTo("seal") == 0){
						//year before 1990
						if(yearInt < 1990){
							qryStr = "select a from PcbEquipment a  where a.divison =:division and a.manufactureBrand NOT LIKE 'LTL%' and a.type =:seriaType and a.manufactureDate < to_date('1990-01-01','YYYY-MM-DD') ORDER BY a.equipmentId";
							System.out.println("qryStr : " +qryStr);
							Query query = em.createQuery(qryStr);
							//query.setParameter("area", area);
							query.setParameter("seriaType", "Yes");
							//query.setParameter("manufactureLtl", "LTL");
							query.setParameter("division", division);
							
							List<PcbEquipment> list = query.getResultList();
							return list;
						}
						//year after 1990 no sampling
						else{
							
						}
					}
					//Seal Type non seal
					else{
						qryStr = "select a from PcbEquipment a  where a.divison =:division and a.manufactureBrand NOT LIKE 'LTL%' and a.type NOT LIKE 'Yes%' ORDER BY a.equipmentId";
						System.out.println("qryStr : " +qryStr);
						Query query = em.createQuery(qryStr);
						//query.setParameter("area", area);
						//query.setParameter("seriaType", "Yes");
						//query.setParameter("manufactureLtl", "LTL");
						query.setParameter("division", division);
						
						List<PcbEquipment> list = query.getResultList();
						return list;
				
						
					}	
					
				}
			}
			
			else{
				
			}
			
			
			
			
			/*if(year.equalsIgnoreCase("1")){
				qryStr = "select a from PcbEquipment a  where a.divison =:division and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType and a.area =:area and a.year < 1990 ORDER BY a.equipmentId";
				
			}if(year.equalsIgnoreCase("2")){
				qryStr = "select a from PcbEquipment a  where a.divison =:division and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType and a.area =:area and a.year > 1990 ORDER BY a.equipmentId";
				
			}
			if(year.equalsIgnoreCase("3")){
				qryStr = "select a from PcbEquipment a  where a.divison =:division and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType and a.area =:area and a.year > 2000 ORDER BY a.equipmentId";
				
			}
			
			System.out.println("qryStr : " +qryStr);
			Query query = em.createQuery(qryStr);
			query.setParameter("area", area);
			query.setParameter("seriaType", seriaType);
			query.setParameter("manufactureLtl", manufactureLtl);
			query.setParameter("division", division);
			
			List<PcbEquipment> list = query.getResultList();
			return list;*/
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return null;
	}


	@Override
	public String getEquipmentIdByReferenceNo(String equipmentId) {
		try {
			// String qryStr =
			// "select p from MmsAddline p where p.status =:status and p.phmBranch=:phmbranch ORDER BY p.lineName ";
			System.out.println("equipmentId : " +equipmentId);
			
			
			String qryStr = "select a.equipmentId from PcbEquipment a  where a.referenceNo =:referenceNo";
			//String qryStr = "select a.equipmentId from PcbEquipment a  where a.divison =:division and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType and ('EXTRACT(YEAR FROM ?)', a.manufactureDate) AS YEAR =:year ORDER BY a.equipmentId";
			Query query = em.createQuery(qryStr);
			query.setParameter("referenceNo", equipmentId);
			//query.setParameter("year", year);
			List<String> list = query.getResultList();
			System.out.println("list : " +list);
			
			if(list != null && list.size() != 0){
				return list.get(0);
				
			}else{
				return "";
			}
			
			
			//return list.get(0);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}}

	@Override
	public List<PcbEquipment> findEquipmentIdsForDivBraUnit(String division,
			String branch, String unit, String manufactureLtl,
			String seriaType, String type) {
		//String qryStr = "select a from PcbEquipment a  where a.divison =:division and a.branch =:branch and a.unit =:unit and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType and ('EXTRACT(YEAR FROM ?)', a.manufactureDate) AS YEAR =:year ORDER BY a.equipmentId ORDER BY a.equipmentId";
		//String qryStr = "select a from PcbEquipment a  where a.divison =:division and a.branch =:branch  and a.unit =:unit and a.manufactureLtl=:manufactureLtl ORDER BY a.equipmentId";
		String qryStr = "";
		Query query = null;
		
		System.out.println("manufactureLtl : " +manufactureLtl +" seriaType :" + seriaType + " type : " + type);
		
		if(!manufactureLtl.equalsIgnoreCase("-1") && !seriaType.equalsIgnoreCase("-1") && !type.equalsIgnoreCase("-1") ){
			qryStr = "select a from PcbEquipment a  where a.divison =:division and a.branch =:branch  and a.unit =:unit and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType  and a.type =:type ORDER BY a.equipmentId";
			System.out.println("1 : " +qryStr);
			query = em.createQuery(qryStr);
			query.setParameter("type", type);
			query.setParameter("seriaType", seriaType);
			query.setParameter("manufactureLtl", manufactureLtl);
			query.setParameter("division", division);
			query.setParameter("branch", branch);
			query.setParameter("unit", unit);
			
		}else if(manufactureLtl.equalsIgnoreCase("-1") && !seriaType.equalsIgnoreCase("-1") && !type.equalsIgnoreCase("-1")){
			qryStr = "select a from PcbEquipment a  where a.divison =:division and a.branch =:branch  and a.unit =:unit and a.seriaType =:seriaType  and a.type =:type ORDER BY a.equipmentId";
			System.out.println("2 : " +qryStr);
			query = em.createQuery(qryStr);
			query.setParameter("type", type);
			query.setParameter("seriaType", seriaType);
			//query.setParameter("manufactureLtl", manufactureLtl);
			query.setParameter("division", division);
			query.setParameter("branch", branch);
			query.setParameter("unit", unit);
			
		}else if(manufactureLtl.equalsIgnoreCase("-1") && seriaType.equalsIgnoreCase("-1") && !type.equalsIgnoreCase("-1")){
			qryStr = "select a from PcbEquipment a  where a.divison =:division and a.branch =:branch  and a.unit =:unit and a.type =:type ORDER BY a.equipmentId";
			System.out.println("3 : " +qryStr);
			query = em.createQuery(qryStr);
			query.setParameter("type", type);
			//query.setParameter("seriaType", seriaType);
			//query.setParameter("manufactureLtl", manufactureLtl);
			query.setParameter("division", division);
			query.setParameter("branch", branch);
			query.setParameter("unit", unit);
			
		}/*else if(manufactureLtl.equalsIgnoreCase("-1") && seriaType.equalsIgnoreCase("-1") && type.equalsIgnoreCase("-1")){
			qryStr = "select a from PcbEquipment a  where a.divison =:division and a.branch =:branch  and a.unit =:unit and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType  and a.type =:type ORDER BY a.equipmentId";
			System.out.println("4 : " +qryStr);
			query = em.createQuery(qryStr);
			query.setParameter("type", type);
			query.setParameter("seriaType", seriaType);
			query.setParameter("manufactureLtl", manufactureLtl);
			query.setParameter("division", division);
			query.setParameter("branch", branch);
			query.setParameter("unit", unit);
			
		}*/else if(!manufactureLtl.equalsIgnoreCase("-1") && !seriaType.equalsIgnoreCase("-1") && type.equalsIgnoreCase("-1")){
			qryStr = "select a from PcbEquipment a  where a.divison =:division and a.branch =:branch  and a.unit =:unit and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType ORDER BY a.equipmentId";
			System.out.println("5 : " +qryStr);
			query = em.createQuery(qryStr);
			//query.setParameter("type", type);
			query.setParameter("seriaType", seriaType);
			query.setParameter("manufactureLtl", manufactureLtl);
			query.setParameter("division", division);
			query.setParameter("branch", branch);
			query.setParameter("unit", unit);
			
		}else if(!manufactureLtl.equalsIgnoreCase("-1") && seriaType.equalsIgnoreCase("-1") && type.equalsIgnoreCase("-1")){
			qryStr = "select a from PcbEquipment a  where a.divison =:division and a.branch =:branch  and a.unit =:unit and a.manufactureLtl=:manufactureLtl ORDER BY a.equipmentId";
			System.out.println("6 : " +qryStr);
			query = em.createQuery(qryStr);
			//query.setParameter("type", type);
			//query.setParameter("seriaType", seriaType);
			query.setParameter("manufactureLtl", manufactureLtl);	
			query.setParameter("division", division);
			query.setParameter("branch", branch);
			query.setParameter("unit", unit);
			
		}else if(!manufactureLtl.equalsIgnoreCase("-1") && seriaType.equalsIgnoreCase("-1") && !type.equalsIgnoreCase("-1")){
			qryStr = "select a from PcbEquipment a  where a.divison =:division and a.branch =:branch  and a.unit =:unit and a.seriaType =:seriaType ORDER BY a.equipmentId";
			System.out.println("7 : " +qryStr);
			query = em.createQuery(qryStr);
			//query.setParameter("type", type);
			query.setParameter("seriaType", seriaType);
			//query.setParameter("manufactureLtl", manufactureLtl);	
			query.setParameter("division", division);
			query.setParameter("branch", branch);
			query.setParameter("unit", unit);
			
		}else{
			qryStr = "select a from PcbEquipment a  where a.divison =:division and a.branch =:branch  and a.unit =:unit ORDER BY a.equipmentId";
			System.out.println("8 : " +qryStr);
			query = em.createQuery(qryStr);
			//query.setParameter("type", type);
			//query.setParameter("seriaType", seriaType);
			//query.setParameter("manufactureLtl", manufactureLtl);	
			query.setParameter("division", division);
			query.setParameter("branch", branch);
			query.setParameter("unit", unit);
		}
		
		
		
		
		
		List<PcbEquipment> list = query.getResultList();
		return list;
		
	}

	@Override
	public List<Object[]> findLocationIdsForArea(String unit) {
		// TODO Auto-generated method stub
		
		String qryStr = "";
		Query query = null;
			qryStr = "select a,b,s from PcbEquipment a,PcbLocation b, PcbSample s where a.equipmentId=s.equipmentId and a.equipmentId=b.equipmentId and trim(a.unit) =:unit and b.gpsLatitude IS NOT NULL and b.gpsLatitude != 0 ORDER BY a.equipmentId";
			System.out.println("8 : " +qryStr);
			query = em.createQuery(qryStr);
			query.setParameter("unit", unit);
		
		List<Object[]> list = query.getResultList();
		return list;
			}

	
	@Override
	public List<Object[]> findLocationIdsForDivBraUnit(String division,String branch, String unit) {
		// TODO Auto-generated method stub
		
		String qryStr = "";
		Query query = null;
		if(division.equalsIgnoreCase("NONE") && branch.equalsIgnoreCase("NONE") && unit.equalsIgnoreCase("NONE")){
			qryStr = "select a,b,s from PcbEquipment a,PcbLocation b, PcbSample s where a.equipmentId=s.equipmentId and a.equipmentId=b.equipmentId and a.status = 2 and b.gpsLatitude IS NOT NULL and b.gpsLatitude != 0 ORDER BY a.equipmentId";
			System.out.println("8 : " +qryStr);
			query = em.createQuery(qryStr);
			//query.setParameter("division", division);
			//query.setParameter("branch", branch);
			//query.setParameter("unit", unit);
		
		}else if(!division.equalsIgnoreCase("NONE") && branch.equalsIgnoreCase("NONE") && unit.equalsIgnoreCase("NONE")){
			qryStr = "select a,b,s from PcbEquipment a,PcbLocation b, PcbSample s where a.equipmentId=s.equipmentId and a.equipmentId=b.equipmentId and a.status = 2 and trim(a.divison) =:division and b.gpsLatitude IS NOT NULL and b.gpsLatitude != 0 ORDER BY a.equipmentId";
			System.out.println("8 : " +qryStr);
			query = em.createQuery(qryStr);
			query.setParameter("division", division);
			//query.setParameter("branch", branch);
			//query.setParameter("unit", unit);
		
		}else if(!division.equalsIgnoreCase("NONE") && !branch.equalsIgnoreCase("NONE") && unit.equalsIgnoreCase("NONE")){
			qryStr = "select a,b,s from PcbEquipment a,PcbLocation b, PcbSample s where a.equipmentId=s.equipmentId and a.equipmentId=b.equipmentId and a.status = 2 and trim(a.divison) =:division and trim(a.branch) =:branch and b.gpsLatitude IS NOT NULL and b.gpsLatitude != 0 ORDER BY a.equipmentId";
			System.out.println("8 : " +qryStr);
			query = em.createQuery(qryStr);
			query.setParameter("division", division);
			query.setParameter("branch", branch);
			//query.setParameter("unit", unit);
		
		}else{
			qryStr = "select a,b,s from PcbEquipment a,PcbLocation b, PcbSample s where a.equipmentId=s.equipmentId and a.equipmentId=b.equipmentId and a.status = 2 and trim(a.divison) =:division and trim(a.branch) =:branch  and trim(a.unit) =:unit and b.gpsLatitude IS NOT NULL and b.gpsLatitude != 0 ORDER BY a.equipmentId";
			System.out.println("8 : " +qryStr);
			query = em.createQuery(qryStr);
			query.setParameter("division", division);
			query.setParameter("branch", branch);
			query.setParameter("unit", unit);
		}
		List<Object[]> list = query.getResultList();
		return list;
			}
	
	
	@Override
	public List<Object[]> findLocationIdsForBraUnit(String branch, String unit) {
		// TODO Auto-generated method stub
		
		String qryStr = "";
		Query query = null;
		if(branch.equalsIgnoreCase("NONE") && unit.equalsIgnoreCase("NONE")){
			qryStr = "select a,b,s from PcbEquipment a,PcbLocation b, PcbSample s where a.equipmentId=s.equipmentId and a.equipmentId=b.equipmentId and a.status = 2 and b.gpsLatitude IS NOT NULL and b.gpsLatitude != 0 ORDER BY a.equipmentId";
			System.out.println("8 : " +qryStr);
			query = em.createQuery(qryStr);
			//query.setParameter("division", division);
			//query.setParameter("branch", branch);
			//query.setParameter("unit", unit);
		
		}else if(!branch.equalsIgnoreCase("NONE") && unit.equalsIgnoreCase("NONE")){
			qryStr = "select a,b,s from PcbEquipment a,PcbLocation b, PcbSample s where a.equipmentId=s.equipmentId and a.equipmentId=b.equipmentId and a.status = 2  and trim(a.branch) =:branch and b.gpsLatitude IS NOT NULL and b.gpsLatitude != 0 ORDER BY a.equipmentId";
			System.out.println("8 : " +qryStr);
			query = em.createQuery(qryStr);
			//query.setParameter("division", division);
			query.setParameter("branch", branch);
			//query.setParameter("unit", unit);
		
		}else{
			qryStr = "select a,b,s from PcbEquipment a,PcbLocation b, PcbSample s where a.equipmentId=s.equipmentId and a.equipmentId=b.equipmentId and a.status = 2 and trim(a.branch) =:branch  and trim(a.unit) =:unit and b.gpsLatitude IS NOT NULL and b.gpsLatitude != 0 ORDER BY a.equipmentId";
			System.out.println("8 : " +qryStr);
			query = em.createQuery(qryStr);
			//query.setParameter("division", division);
			query.setParameter("branch", branch);
			query.setParameter("unit", unit);
		}
		List<Object[]> list = query.getResultList();
		return list;
			}


	@Override
	public PcbEquipment getEquipmentByReferenceNo(String equipmentId) {
		try {
			String qryStr = "select a from PcbEquipment a  where a.referenceNo =:referenceNo";
			Query query = em.createQuery(qryStr);
			query.setParameter("referenceNo", equipmentId);
			PcbEquipment objEquip = null;
			if(query.getResultList() != null){
				objEquip = (PcbEquipment)query.getResultList().get(0);
			}
			
			
			return objEquip;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<PcbEquipment> findEquipmentIdForMobile(String division,String branch, String unit) {
		PcbModel model = new PcbModel();
		List<PcbModel> listPcbModel = new ArrayList<PcbModel>();
		System.out.println("division "+division +" branch "+branch +" unit"+ unit);
		String qryStr = "";
		Query query = null;
		qryStr = "select a from PcbEquipment a  where trim(a.divison) =:division and trim(a.branch) =:branch  and trim(a.unit) =:unit ORDER BY a.equipmentId";
		System.out.println("8 : " +qryStr);
		query = em.createQuery(qryStr);
		//query.setParameter("type", type);
		//query.setParameter("seriaType", seriaType);
		//query.setParameter("manufactureLtl", manufactureLtl);	
		query.setParameter("division", division.trim());
		query.setParameter("branch", branch.trim());
		query.setParameter("unit", unit.trim());
		List<PcbEquipment> list = query.getResultList();
		return list;
		/*if(list != null){
			int count = list.size();
			for(int i = 0 ; i < count -1 ; i ++){
				PcbModel modelObj = new PcbModel();
				
				PcbEquipment obj = list.get(i);
				String equipmentId = obj.getEquipmentId();
				PcbEquipment objEquipment = addEquipment.findEquipmentByEquipmentId(equipmentId);
				modelObj.setPcbEquipment(objEquipment);
				PcbSample objSample =  addSample.findSampleByEquipmentId(equipmentId);
				modelObj.setPcbSample(objSample);
				PcbCondition objCondition =  addCondition.findConditionByEquipmentId(equipmentId);
				modelObj.setPcbCondition(objCondition);
				PcbLocation objLocation =  addLocation.findLocationByEquipmentId(equipmentId);
				modelObj.setPcbLocation(objLocation);
				
				listPcbModel.add(modelObj);
			}
			
		}
		
		return listPcbModel;
		*/}

	@Override
	public String getEquipmentIdBySampleNo(String sampleNo) {
		try {
			// String qryStr =
			// "select p from MmsAddline p where p.status =:status and p.phmBranch=:phmbranch ORDER BY p.lineName ";
			System.out.println("equipmentId : " +sampleNo);
			
			
			String qryStr = "select a.equipmentId from PcbSample a  where trim(a.samplingNu) =trim(:referenceNo)";
			//String qryStr = "select a.equipmentId from PcbEquipment a  where a.divison =:division and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType and ('EXTRACT(YEAR FROM ?)', a.manufactureDate) AS YEAR =:year ORDER BY a.equipmentId";
			Query query = em.createQuery(qryStr);
			query.setParameter("referenceNo", sampleNo);
			//query.setParameter("year", year);
			List<String> list = query.getResultList();
			System.out.println("list : " +list);
			
			if(list != null && list.size() != 0){
				return list.get(0);
				
			}else{
				return "";
			}
			
			
			//return list.get(0);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public String getReferenceNoByEquipmentId(String ReferenceNo) {
		try {
			// String qryStr =
			// "select p from MmsAddline p where p.status =:status and p.phmBranch=:phmbranch ORDER BY p.lineName ";
			System.out.println("equipmentId : " +ReferenceNo);
			
			
			String qryStr = "select a.referenceNo from PcbSample a  where a.equipmentId =:referenceNo";
			//String qryStr = "select a.equipmentId from PcbEquipment a  where a.divison =:division and a.manufactureLtl=:manufactureLtl and a.seriaType =:seriaType and ('EXTRACT(YEAR FROM ?)', a.manufactureDate) AS YEAR =:year ORDER BY a.equipmentId";
			Query query = em.createQuery(qryStr);
			query.setParameter("referenceNo", ReferenceNo);
			//query.setParameter("year", year);
			List<String> list = query.getResultList();
			System.out.println("list : " +list);
			
			if(list != null && list.size() != 0){
				return list.get(0);
				
			}else{
				return "";
			}
			
			
			//return list.get(0);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Object[]> getSummaryTransformer() {
		String qryStr = "";
		Query query = null;
		//select count(*),(select b.compNm from GLCOMPM b  where b.compId =a.DIVISON) from PCB_EQUIPMENT a  where status = 2 group by DIVISON


		List<Object[]> list = null;
		try {
			qryStr = "select count(a),(select b.compNm from Glcompm b  where b.compId =a.divison) from PcbEquipment a,Glcompm b where trim(b.compId) =trim(a.divison) and a.status=2 GROUP BY a.divison";
			//System.out.println("8 : " +qryStr);
			query = em.createQuery(qryStr);
			
			list = query.getResultList();
		} catch (Exception   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> getSummaryTransformerSampled() {
		String qryStr = "";
		Query query = null;
		//select count(*),(select b.compNm from GLCOMPM b  where b.compId =a.DIVISON) from PCB_EQUIPMENT a  where status = 2 group by DIVISON


		List<Object[]> list = null;
		try {
			qryStr = "select count(a),(select b.compNm from Glcompm b  where b.compId =a.divison) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.completed like 'Y%' and trim(b.compId) =trim(a.divison) and a.status=2 GROUP BY a.divison";
			//System.out.println("8 : " +qryStr);
			query = em.createQuery(qryStr);
			
			list = query.getResultList();
		} catch (Exception   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<Object[]> getSummaryTransformerScreening() {
		String qryStr = "";
		Query query = null;
		//select count(*),(select b.compNm from GLCOMPM b  where b.compId =a.DIVISON) from PCB_EQUIPMENT a  where status = 2 group by DIVISON


		List<Object[]> list = null;
		try {
			qryStr = "select count(a),(select b.compNm from Glcompm b  where b.compId =a.divison) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.pcbTestDataAroclor >= 50 and trim(b.compId) =trim(a.divison) and a.status=2 GROUP BY a.divison";
			//System.out.println("8 : " +qryStr);
			query = em.createQuery(qryStr);
			
			list = query.getResultList();
		} catch (Exception   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<Object[]> getSummaryTransformerItiConf() {
		String qryStr = "";
		Query query = null;
		//select count(*),(select b.compNm from GLCOMPM b  where b.compId =a.DIVISON) from PCB_EQUIPMENT a  where status = 2 group by DIVISON


		List<Object[]> list = null;
		try {
			qryStr = "select count(a),(select b.compNm from Glcompm b  where b.compId =a.divison) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and a.itiConfPositive like 'Y%' and trim(b.compId) =trim(a.divison) and a.status=2 GROUP BY a.divison";
			//System.out.println("8 : " +qryStr);
			query = em.createQuery(qryStr);
			
			list = query.getResultList();
		} catch (Exception   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<Object[]> getSummaryTransformerSampledDPA(String div,String pro,String area) {
		String qryStr = "";
		Query query = null;
		//select count(*),(select b.compNm from GLCOMPM b  where b.compId =a.DIVISON) from PCB_EQUIPMENT a  where status = 2 group by DIVISON


		List<Object[]> list = null;
		try {
			
			if(div.equalsIgnoreCase("NONE") && pro.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE")){
				qryStr = "select count(a),(select b.compNm from Glcompm b  where b.compId =a.divison) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.sampleSatisified like 'Y%' and trim(b.compId) =trim(a.divison) and a.status=2 GROUP BY a.divison";
				//System.out.println("8 : " +qryStr);
				query = em.createQuery(qryStr);
				list = query.getResultList();
			
			}else if(!div.equalsIgnoreCase("NONE") && pro.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE")){
				qryStr = "select count(a),(select b.compNm from Glcompm b  where b.compId =a.branch) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.sampleSatisified like 'Y%' and trim(b.compId) =trim(a.divison) and a.status=2 and trim(a.divison) =:division GROUP BY a.branch";
				//System.out.println("8 : " +qryStr);
				query = em.createQuery(qryStr);
				query.setParameter("division", div);
				
				list = query.getResultList();
			
			
			}else if(!div.equalsIgnoreCase("NONE") && !pro.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE")){
				qryStr = "select count(a),(select b.deptNm from Gldeptm b  where b.deptId =a.unit) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.sampleSatisified like 'Y%' and trim(b.compId) =trim(a.divison) and a.status=2 and trim(a.divison) =:division and trim(a.branch) =:branch GROUP BY a.unit";
				
				
				//qryStr = "select count(a),(select b.deptNm from Gldeptm b  where b.deptId =a.unit) from PcbEquipment a,Glcompm b where trim(b.compId) =trim(a.divison) and a.status=2 and trim(a.divison) =:division and trim(a.branch) =:branch GROUP BY a.unit";
				//System.out.println("8 : " +qryStr);
				query = em.createQuery(qryStr);
				query.setParameter("division", div);
				query.setParameter("branch", pro);
				
				list = query.getResultList();			
			}
			
			else{
			
			qryStr = "select count(a),(select b.deptNm from Gldeptm b  where b.deptId =a.unit) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.sampleSatisified like 'Y%' and trim(b.compId) =trim(a.divison) and a.status=2 and trim(a.divison) =:division and trim(a.branch) =:branch  and trim(a.unit) =:unit GROUP BY a.divison , a.branch ,a.unit";
			//System.out.println("8 : " +qryStr);
			query = em.createQuery(qryStr);
			query.setParameter("division", div);
			query.setParameter("branch", pro);
			query.setParameter("unit", area);
			list = query.getResultList();
			}
		} catch (Exception   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<Object[]> getSummaryTransformerDPA(String div,String pro,String area) {
		String qryStr = "";
		Query query = null;
		//select count(*),(select b.compNm from GLCOMPM b  where b.compId =a.DIVISON) from PCB_EQUIPMENT a  where status = 2 group by DIVISON


		List<Object[]> list = null;
		try {
			
			if(div.equalsIgnoreCase("NONE") && pro.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE")){
				qryStr = "select count(a),(select b.compNm from Glcompm b  where b.compId =a.divison) from PcbEquipment a,Glcompm b where trim(b.compId) =trim(a.divison) and a.status=2 GROUP BY a.divison";
				//System.out.println("8 : " +qryStr);
				query = em.createQuery(qryStr);
				list = query.getResultList();
			
			}else if(!div.equalsIgnoreCase("NONE") && pro.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE")){
				qryStr = "select count(a),(select b.compNm from Glcompm b  where b.compId =a.branch) from PcbEquipment a,Glcompm b where trim(b.compId) =trim(a.divison) and a.status=2 and trim(a.divison) =:division GROUP BY a.branch";
				//System.out.println("8 : " +qryStr);
				query = em.createQuery(qryStr);
				query.setParameter("division", div);
				
				list = query.getResultList();
			
			
			}else if(!div.equalsIgnoreCase("NONE") && !pro.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE")){
				qryStr = "select count(a),(select b.deptNm from Gldeptm b  where b.deptId =a.unit) from PcbEquipment a,Glcompm b where trim(b.compId) =trim(a.divison) and a.status=2 and trim(a.divison) =:division and trim(a.branch) =:branch GROUP BY a.unit";
				//System.out.println("8 : " +qryStr);
				query = em.createQuery(qryStr);
				query.setParameter("division", div);
				query.setParameter("branch", pro);
				
				list = query.getResultList();			
			}
			
			else{
			
			qryStr = "select count(a),(select b.deptNm from Gldeptm b  where b.deptId =a.unit) from PcbEquipment a,Glcompm b where trim(b.compId) =trim(a.divison) and a.status=2 and trim(a.divison) =:division and trim(a.branch) =:branch  and trim(a.unit) =:unit GROUP BY a.divison , a.branch ,a.unit";
			//System.out.println("8 : " +qryStr);
			query = em.createQuery(qryStr);
			query.setParameter("division", div);
			query.setParameter("branch", pro);
			query.setParameter("unit", area);
			list = query.getResultList();
			}
		} catch (Exception   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<Object[]> getSummaryTransformerScreeningDPA(String div,String pro,String area) {
		String qryStr = "";
		Query query = null;
		//select count(*),(select b.compNm from GLCOMPM b  where b.compId =a.DIVISON) from PCB_EQUIPMENT a  where status = 2 group by DIVISON


		List<Object[]> list = null;
		try {
			
			if(div.equalsIgnoreCase("NONE") && pro.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE")){
				
				//qryStr = "select count(a),(select b.compNm from Glcompm b  where b.compId =a.divison) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.pcbTestDataAroclor >= 50 and trim(b.compId) =trim(a.divison) and a.status=2 GROUP BY a.divison";
				
				
				qryStr = "select count(a),(select b.compNm from Glcompm b  where b.compId =a.divison) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.pcbTestDataAroclor >= 50 and trim(b.compId) =trim(a.divison) and a.status=2 GROUP BY a.divison";
				//System.out.println("8 : " +qryStr);
				query = em.createQuery(qryStr);
				list = query.getResultList();
			
			}else if(!div.equalsIgnoreCase("NONE") && pro.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE")){
				
				//qryStr = "select count(a),(select b.compNm from Glcompm b  where b.compId =a.divison) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.pcbTestDataAroclor >= 50 and trim(b.compId) =trim(a.divison) and a.status=2 GROUP BY a.divison";
				
				qryStr = "select count(a),(select b.compNm from Glcompm b  where b.compId =a.branch) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.pcbTestDataAroclor >= 50 and trim(b.compId) =trim(a.divison) and a.status=2 and trim(a.divison) =:division GROUP BY a.branch";
				//System.out.println("8 : " +qryStr);
				query = em.createQuery(qryStr);
				query.setParameter("division", div);
				
				list = query.getResultList();
			
			
			}else if(!div.equalsIgnoreCase("NONE") && !pro.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE")){
				//qryStr = "select count(a),(select b.compNm from Glcompm b  where b.compId =a.branch) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.pcbTestDataAroclor >= 50 and trim(b.compId) =trim(a.divison) and a.status=2 and trim(a.divison) =:division GROUP BY a.branch";
				
				
				qryStr = "select count(a),(select b.deptNm from Gldeptm b  where b.deptId =a.unit) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.pcbTestDataAroclor >= 50 and trim(b.compId) =trim(a.divison) and a.status=2 and trim(a.divison) =:division and trim(a.branch) =:branch GROUP BY a.unit";
				//System.out.println("8 : " +qryStr);
				query = em.createQuery(qryStr);
				query.setParameter("division", div);
				query.setParameter("branch", pro);
				
				list = query.getResultList();			
			}
			
			else{
		   // qryStr = "select count(a),(select b.deptNm from Gldeptm b  where b.deptId =a.unit) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.pcbTestDataAroclor >= 50 and trim(b.compId) =trim(a.divison) and a.status=2 and trim(a.divison) =:division and trim(a.branch) =:branch GROUP BY a.unit";
				
			qryStr = "select count(a),(select b.deptNm from Gldeptm b  where b.deptId =a.unit) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.pcbTestDataAroclor >= 50 and trim(b.compId) =trim(a.divison) and a.status=2 and trim(a.divison) =:division and trim(a.branch) =:branch  and trim(a.unit) =:unit GROUP BY a.divison , a.branch ,a.unit";
			//System.out.println("8 : " +qryStr);
			query = em.createQuery(qryStr);
			query.setParameter("division", div);
			query.setParameter("branch", pro);
			query.setParameter("unit", area);
			list = query.getResultList();
			}
		} catch (Exception   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;


	}

	@Override
	public List<Object[]> getSummaryTransformerItiConfDPA(String div,String pro,String Area) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> getSummaryTransformerOilWeight(String div,String pro, String area) {
		String qryStr = "";
		Query query = null;
		//select count(*),(select b.compNm from GLCOMPM b  where b.compId =a.DIVISON) from PCB_EQUIPMENT a  where status = 2 group by DIVISON


		List<Object[]> list = null;
		try {
			
			if(div.equalsIgnoreCase("NONE") && pro.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE")){
				
				//qryStr = "select count(a),(select b.compNm from Glcompm b  where b.compId =a.divison) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.pcbTestDataAroclor >= 50 and trim(b.compId) =trim(a.divison) and a.status=2 GROUP BY a.divison";
				
				
				qryStr = "select count(a),sum(a.weightTransformer),sum(a.oilWeight),(select b.compNm from Glcompm b  where b.compId =a.divison) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.pcbTestDataAroclor >= 50 and trim(b.compId) =trim(a.divison) and a.status=2 GROUP BY a.divison";
				//System.out.println("8 : " +qryStr);
				query = em.createQuery(qryStr);
				list = query.getResultList();
			
			}else if(!div.equalsIgnoreCase("NONE") && pro.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE")){
				
				//qryStr = "select count(a),(select b.compNm from Glcompm b  where b.compId =a.divison) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.pcbTestDataAroclor >= 50 and trim(b.compId) =trim(a.divison) and a.status=2 GROUP BY a.divison";
				
				qryStr = "select count(a),sum(a.weightTransformer),sum(a.oilWeight),(select b.compNm from Glcompm b  where b.compId =a.branch) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.pcbTestDataAroclor >= 50 and trim(b.compId) =trim(a.divison) and a.status=2 and trim(a.divison) =:division GROUP BY a.branch";
				//System.out.println("8 : " +qryStr);
				query = em.createQuery(qryStr);
				query.setParameter("division", div);
				
				list = query.getResultList();
			
			
			}else if(!div.equalsIgnoreCase("NONE") && !pro.equalsIgnoreCase("NONE") && area.equalsIgnoreCase("NONE")){
				//qryStr = "select count(a),(select b.compNm from Glcompm b  where b.compId =a.branch) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.pcbTestDataAroclor >= 50 and trim(b.compId) =trim(a.divison) and a.status=2 and trim(a.divison) =:division GROUP BY a.branch";
				
				
				qryStr = "select count(a),sum(a.weightTransformer),sum(a.oilWeight),(select b.deptNm from Gldeptm b  where b.deptId =a.unit) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.pcbTestDataAroclor >= 50 and trim(b.compId) =trim(a.divison) and a.status=2 and trim(a.divison) =:division and trim(a.branch) =:branch GROUP BY a.unit";
				//System.out.println("8 : " +qryStr);
				query = em.createQuery(qryStr);
				query.setParameter("division", div);
				query.setParameter("branch", pro);
				
				list = query.getResultList();			
			}
			
			else{
		   // qryStr = "select count(a),(select b.deptNm from Gldeptm b  where b.deptId =a.unit) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.pcbTestDataAroclor >= 50 and trim(b.compId) =trim(a.divison) and a.status=2 and trim(a.divison) =:division and trim(a.branch) =:branch GROUP BY a.unit";
				
			qryStr = "select count(a),sum(a.weightTransformer),sum(a.oilWeight),(select b.deptNm from Gldeptm b  where b.deptId =a.unit) from PcbEquipment a,Glcompm b , PcbSample s where s.equipmentId=a.equipmentId and s.pcbTestDataAroclor >= 50 and trim(b.compId) =trim(a.divison) and a.status=2 and trim(a.divison) =:division and trim(a.branch) =:branch  and trim(a.unit) =:unit GROUP BY a.divison , a.branch ,a.unit";
			//System.out.println("8 : " +qryStr);
			query = em.createQuery(qryStr);
			query.setParameter("division", div);
			query.setParameter("branch", pro);
			query.setParameter("unit", area);
			list = query.getResultList();
			}
		} catch (Exception   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public Object findPCBModelBySinNo(String sinNo) {
		// TODO Auto-generated method stub
		//select b.LOCATION_DESCRIPTION from PCB_EQUIPMENT a ,PCB_LOCATION b where a.EQUIPMENT_ID= b.EQUIPMENT_ID and a.sin_No='MKT005'
		Object list =null;		
		try {
					//String qryStr = "select b.locationDescription,b.gpsLongitude,b.gpsLatitude from PcbEquipment a,PcbLocation b  where a.equipmentId= b.equipmentId and a.sinNo=:sinNo";
					String qryStr = "select a,b from PcbEquipment a,PcbLocation b  where a.equipmentId= b.equipmentId and a.sinNo=:sinNo";
					
					Query query = em.createQuery(qryStr);
					query.setParameter("sinNo", sinNo);
					
					if(query.getResultList() != null){
						list = query.getResultList().get(0);
					}
					 
					return list;
				} catch (Exception ex) {
					ex.printStackTrace();
					return null;
				}
		
		//return null;
	}

}