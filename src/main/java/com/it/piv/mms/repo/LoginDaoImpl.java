package com.it.piv.mms.repo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it.piv.admin.domain.Sauserm;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
    private EntityManager em;
	
	@Override
	public Boolean validateLogin(String userName, String password)throws Exception {
		//System.out.println("Username : "+userName);
		//System.out.println("Password : "+password);
		return validate(userName.trim().toUpperCase(),password);
	}
	
	private  Boolean validate(String userName, String password) throws Exception {

		Boolean valiity = false;

		Double M_PS = 0d;
		Double M_PU = 0d;
		Double M_P = 0d;
		
		String m_User = CheckPass(userName);
		
		//System.out.println("LoginDaoImpl userName :"+userName);
		//System.out.println("LoginDaoImpl m_User :"+m_User);

		if (!(m_User.trim().equals(""))) {
			
			//System.out.println("Test CheckPass(password)");
			
			String m_Pass = CheckPass(password);
			
			if (!(m_Pass.trim().equals(""))) {
				M_PS = Double.parseDouble(m_Pass);
				M_PU = Double.parseDouble(m_User);
				
				//System.out.println("LoginDaoImpl M_PS :"+M_PS);
				//System.out.println("LoginDaoImpl M_PU :"+M_PU);

				M_P = ((M_PU + M_PS) / 100005600000.9987);
				//System.out.println("LoginDaoImpl M_P :"+M_P);

				if (chkPassworEquality(M_P.toString(), userName)) {
					//System.out.println("Check Password Equ");
					valiity = true;
				}

			}
		}

		return valiity;
	}
	
	
	private String CheckPass(String literal) {
		
		//System.out.println("LoginDaoImpl CheckPass function:"+literal);

		Integer PAS_LEN = 1;
		String M_PASS = "";
		String M_PASS1 = "";

		char[] cArray = literal.trim().toCharArray();
		//System.out.println("LoginDaoImpl CheckPass cArray : "+cArray);

		ArrayList<String> strList = new ArrayList<String>();
		//System.out.println("LoginDaoImpl CheckPass strList :"+strList);

		for (int i = 0; i < cArray.length; i++) {
			strList.add(Character.toString(cArray[i]));
			
			//System.out.println("LoginDaoImpl CheckPass strList.add(Character.toString(cArray[i])); : "+(cArray[i]));
		}

		int cArrayLength = cArray.length;

		Long LEN_TOT = 0l;

		while (PAS_LEN <= 10) {
			//System.out.println("LoginDaoImpl Test While loop "+PAS_LEN);
			Long PAS_CHAR = 0l;
			Long POS_CHAR = 0l;

			if (cArrayLength < PAS_LEN) {
				if (PAS_LEN == 0) {
					PAS_CHAR = 9999l;
					//System.out.println("LoginDaoImpl Test While loop PAS_CHAR "+PAS_CHAR);
				} else {
					PAS_CHAR = LEN_TOT;
				}
			} else {
				PAS_CHAR = decrypt(strList.get(PAS_LEN - 1));
				//System.out.println("LoginDaoImpl Test While loop PAS_CHAR "+PAS_CHAR);
			}
			if (PAS_CHAR.equals(0)) {
				M_PASS = "";
				M_PASS1 = M_PASS;
				break;
			}

			POS_CHAR = decrypt(PAS_LEN.toString());
			//System.out.println("LoginDaoImpl Test While loop POS_CHAR ---------->>> "+POS_CHAR);

			Long ENC_CHAR = PAS_CHAR + POS_CHAR;
			LEN_TOT = LEN_TOT + ENC_CHAR;

			if (M_PASS.equals("")) {
				M_PASS = ENC_CHAR.toString();
				//System.out.println("LoginDaoImpl Test While loop M_PASS if ---------->>>>>>>> "+POS_CHAR);
			} else {
				M_PASS = M_PASS.concat(ENC_CHAR.toString());
				//System.out.println("LoginDaoImpl Test While loop M_PASS else ---------->>>>>>>> "+POS_CHAR);
			}
			PAS_LEN = PAS_LEN + 1;
			
		}

		M_PASS1 = M_PASS;
		//System.out.println("LoginDaoImpl Test While loop M_PASS1 ---------->>>>>>>> "+M_PASS1);

		return M_PASS1;

	}
	
	private boolean chkPassworEquality(String M_P, String userName)
			throws Exception {
		String password = getPassword(userName);

		//System.out.println("LoginDaoImpl chkPassworEquality check "+password);
		
		boolean result = false;
		
		if (password!=null) 
		{
			//System.out.println(password);
			Double dbVal = Double.parseDouble(password);
			Double enteredVal = Double.parseDouble(M_P);

			//System.out.println("dbVal ---------> "+dbVal);
			//System.out.println("enteredVal-----------> "+enteredVal);
			Double roundUp = 0d;

			DecimalFormat twoDForm = new DecimalFormat("#.########");
			roundUp = Double.valueOf(twoDForm.format(enteredVal / dbVal));

			if (roundUp.equals(1.00000000)) {
				result = true;
				
			}

		}
		

		return result;
	}
	
	private Long decrypt(String IN_STR) {

		Long OUT_CHAR = 0l;

		if (IN_STR.equals("A"))
			OUT_CHAR = 2457l;
		else if (IN_STR.equals("B"))
			OUT_CHAR = 2459l;
		else if (IN_STR.equals("C"))
			OUT_CHAR = 2460l;
		else if (IN_STR.equals("D"))
			OUT_CHAR = 2461l;
		else if (IN_STR.equals("E"))
			OUT_CHAR = 2462l;
		else if (IN_STR.equals("F"))
			OUT_CHAR = 2463l;
		else if (IN_STR.equals("G"))
			OUT_CHAR = 2464l;
		else if (IN_STR.equals("H"))
			OUT_CHAR = 2465l;
		else if (IN_STR.equals("I"))
			OUT_CHAR = 2466l;
		else if (IN_STR.equals("J"))
			OUT_CHAR = 2468l;
		else if (IN_STR.equals("K"))
			OUT_CHAR = 2469l;
		else if (IN_STR.equals("L"))
			OUT_CHAR = 2470l;
		else if (IN_STR.equals("M"))
			OUT_CHAR = 2471l;
		else if (IN_STR.equals("N"))
			OUT_CHAR = 2472l;
		else if (IN_STR.equals("O"))
			OUT_CHAR = 2472l;
		else if (IN_STR.equals("P"))
			OUT_CHAR = 2473l;
		else if (IN_STR.equals("Q"))
			OUT_CHAR = 2473l;
		else if (IN_STR.equals("R"))
			OUT_CHAR = 2474l;
		else if (IN_STR.equals("S"))
			OUT_CHAR = 2475l;
		else if (IN_STR.equals("T"))
			OUT_CHAR = 2476l;
		else if (IN_STR.equals("U"))
			OUT_CHAR = 2478l;
		else if (IN_STR.equals("V"))
			OUT_CHAR = 2478l;
		else if (IN_STR.equals("W"))
			OUT_CHAR = 2479l;
		else if (IN_STR.equals("X"))
			OUT_CHAR = 2481l;
		else if (IN_STR.equals("Y"))
			OUT_CHAR = 2482l;
		else if (IN_STR.equals("Z"))
			OUT_CHAR = 2483l;
		else if (IN_STR.equals("a"))
			OUT_CHAR = 4055l;
		else if (IN_STR.equals("b"))
			OUT_CHAR = 4056l;
		else if (IN_STR.equals("c"))
			OUT_CHAR = 4057l;
		else if (IN_STR.equals("d"))
			OUT_CHAR = 4060l;
		else if (IN_STR.equals("e"))
			OUT_CHAR = 4061l;
		else if (IN_STR.equals("f"))
			OUT_CHAR = 4063l;
		else if (IN_STR.equals("g"))
			OUT_CHAR = 4064l;
		else if (IN_STR.equals("h"))
			OUT_CHAR = 4065l;
		else if (IN_STR.equals("i"))
			OUT_CHAR = 4066l;
		else if (IN_STR.equals("j"))
			OUT_CHAR = 4068l;
		else if (IN_STR.equals("k"))
			OUT_CHAR = 4069l;
		else if (IN_STR.equals("l"))
			OUT_CHAR = 5470l;
		else if (IN_STR.equals("m"))
			OUT_CHAR = 5471l;
		else if (IN_STR.equals("n"))
			OUT_CHAR = 5472l;
		else if (IN_STR.equals("o"))
			OUT_CHAR = 5472l;
		else if (IN_STR.equals("p"))
			OUT_CHAR = 5473l;
		else if (IN_STR.equals("q"))
			OUT_CHAR = 5473l;
		else if (IN_STR.equals("r"))
			OUT_CHAR = 5474l;
		else if (IN_STR.equals("s"))
			OUT_CHAR = 5475l;
		else if (IN_STR.equals("t"))
			OUT_CHAR = 5476l;
		else if (IN_STR.equals("u"))
			OUT_CHAR = 5478l;
		else if (IN_STR.equals("v"))
			OUT_CHAR = 5478l;
		else if (IN_STR.equals("w"))
			OUT_CHAR = 5479l;
		else if (IN_STR.equals("x"))
			OUT_CHAR = 5481l;
		else if (IN_STR.equals("y"))
			OUT_CHAR = 5482l;
		else if (IN_STR.equals("z"))
			OUT_CHAR = 9999l;
		else if (IN_STR.equals("0"))
			OUT_CHAR = 2502l;
		else if (IN_STR.equals("1"))
			OUT_CHAR = 2503l;
		else if (IN_STR.equals("2"))
			OUT_CHAR = 2504l;
		else if (IN_STR.equals("3"))
			OUT_CHAR = 2505l;
		else if (IN_STR.equals("4"))
			OUT_CHAR = 2506l;
		else if (IN_STR.equals("5"))
			OUT_CHAR = 2507l;
		else if (IN_STR.equals("6"))
			OUT_CHAR = 2508l;
		else if (IN_STR.equals("7"))
			OUT_CHAR = 2509l;
		else if (IN_STR.equals("8"))
			OUT_CHAR = 2561l;
		else if (IN_STR.equals("9"))
			OUT_CHAR = 2562l;
		else if (IN_STR.equals("10"))
			OUT_CHAR = 2563l;
		else
			OUT_CHAR = 0l;
		
		//System.out.println("OUT_CHAR ---------->>> "+OUT_CHAR);

		return OUT_CHAR;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Sauserm getSauserm(String userName) {
		String qryStr = "SELECT s FROM Sauserm s WHERE TRIM(s.userId)=:userNm";
		Query query = em.createQuery(qryStr);
		query.setParameter("userNm", userName.toUpperCase());
		List<Sauserm> list = query.getResultList();
		if (list.isEmpty())
			return null;
        else if (list.size() == 1)
        	return list.get(0);
        throw new NonUniqueResultException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getPassword(String userName) {
		String qryStr = "SELECT s.pswrd FROM Sauserm s WHERE TRIM(s.userId)=:userNm";
		Query query = em.createQuery(qryStr);
		System.out.println("userNm : " + userName);
		query.setParameter("userNm", userName.toUpperCase().trim());
		List<String> list = query.getResultList();
		//System.out.println(list);
		if (list.isEmpty())
			return null;
        else if (list.size() == 1)
        	return list.get(0);
        throw new NonUniqueResultException();
	}
	
	@Override
	public Boolean validateLoginOMS(String userName, String password)
			throws Exception {
		// TODO Auto-generated method stub
	    return validatePng(userName.trim().toUpperCase(),password);
	}
	
	private Boolean validatePng(String userName, String password){
		String passwordDB=getPassword(userName);
		System.out.println("passwordDB " + passwordDB);
		return password.equals(passwordDB);
	}

}
