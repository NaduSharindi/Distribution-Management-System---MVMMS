package com.it.piv.mms.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.it.piv.admin.domain.SausermMm;
import com.it.piv.admin.repo.SecurityDao;
import com.it.piv.mms.domain.ApprovalMm;
import com.it.piv.mms.domain.MmsTxntowermaintenance;
import com.it.piv.mms.domain.MmsTxntowermntcomplesion;
import com.it.piv.mms.repo.ApprovalMmDao;
import com.it.piv.mms.repo.MmsTxntowermntcomplesionDao;
import com.it.piv.util.common.PathMMS;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;




public class Util {
	@Autowired
	private static ApprovalMmDao approvalMm; 
	
	public Util(){
		
	}

	//public static final String STR_SER ="http://10.137.20.22:9090/eBEMS/";
	//public static final String STR_SER ="http://10.130.9.212:9090/eBEMS/";
	public static final String STR_SER ="http://localhost:9090/MMS/";
//	public static final String STR_SER ="http://67.222.153.158:9090/eBEMS/";
	//public static final String STR_SER ="http://122.255.9.155:9090/eBEMS/";
	
public static final Double EE_APPROVE_LIMIT_MAX =5000000D;
	
	public static final Double CE_APPROVE_LIMIT_MAX =25000000D;
	
	public static final Double DGM_APPROVE_LIMIT_MAX =50000000D;
	
	
	   public static String IN_BULK="2";
	   public static String VALIDATION_ES="3";
	   public static String APPROVAL_EE="4";
	   public static String APPROVAL_CE="5";
	   public static String APPROVAL_DGM="6";
	   public static String APPROVE="1";
	   
	   public static String COMPLETED="7";
	   public static String NOT_COMPLETED="8";
	   public static String SEND_COMPLETED_DATA_ES="10";
	   public static String SEND_COMPLETED_DATA_EE="11";
	   public static String SEND_COMPLETED_DATA_APPROVAL="12";
	   public static String COMPLETED_DATA_APPROVAL="20";
	   
	   public static String INSPECTION_APPROVAL_ID="INS";
	   
	   public static String MAINTENANCE_APPROVAL_ID="MNT";
	   
	   public static String WAYLEAVE_APPROVAL_ID="WAY";
	   
	   public static String EM_APPROVAL_ID="EMT";
		  
	   
	   public static String WAYLEAVE_TYPE_ID="WAYREQ";
	   
	   
	   
	   public static double CO180=2896;
	   public static double CO138=9891;
	   public static double CO190=4014;
	   public static double CO143=14824;
	   public static double CO140=7731;
	   public static double W1246=447;
	   
	   public static double LABOUR=491;
	   
	   public static String cephmcp ="mnmnihaj@gmail.com";
	   public static String cephmdd3 ="cehlcmphm.dd3@ceb.lk";
	   public static String cephmdd1 ="saprasadcs@gmail.com";
	   
	   public static String cephmcpsub ="cesubphm.dd2@ceb.lk";
	   
	   public static String eephmcp1 ="eranga.bogahakumbura@gmail.com";
		
	   public static String telcephmcp ="0714565970";
	   public static String telcephmdd3 ="0718693225";
	   public static String telcephmdd1 ="0714163423";
		  
	   public static String telcephmcpsub ="071405390";
	   
	   public static String teleephmcp1 ="0718716913";
		
		
			public static String getSubStringFirstPart(String str,String sub){
				String result ="";
				System.out.println("String " + str);
				
				int seq = 0;
				try {
					seq = str.indexOf(sub);
					System.out.println("index " + seq);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				result = str.substring(seq,str.length());
				System.out.println("result " + result);
				return result;
				}
			
			public static String getSubStringLastPart(String str,String sub){
				String result ="";
				System.out.println("String " + str);
				
				int seq = 0;
				try {
					seq = str.lastIndexOf(sub);
					System.out.println("index " + seq);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				result = str.substring(seq,str.length());
				System.out.println("result " + result);
				return result;
				}
		
		
			public static String  getMonthForInt(int num) {
			    String month = "wrong";
			    DateFormatSymbols dfs = new DateFormatSymbols();
			    String[] months = dfs.getMonths();
			    if (num >= 0 && num <= 11 ) {
			        month = months[num];
			    }
			    return month;
			}

		
		


public static String searchEmail(String key){
	  switch (key) {
		case "471.00":
			return "lahiruhimal@gmail.com";			 
		case "434.00":
			return "abeyeedm@yahoo.com";			 
		case "470.00":
			return "smkumaraky@gmail.com";	
		case "435.00":
			return "gihan.gihan@gmail.com";	
		case "431.00":
			return "sanjayabothota@gmail.com";
		case "491.00":
			return "sanjayabothota@gmail.com";
		case "472.00":
			return "ashoka.kulasinghe@gmail.com";
		case "494.00":
			return "ashoka.kulasinghe@gmail.com";	
		case "437.00":
			return "shbabeysinghe@gmail.com";	
		case "433.00":
			return "ceperadeniya@ceb.lk";
		case "496.00":
			return "ceperadeniya@ceb.lk";	
		
		case "439.00":
			return "ashoka.kulasinghe@gmail.com";
		case "493.00":
			return "ashoka.kulasinghe@gmail.com";		 
		
		case "436.00":
			return "dhanu.nb@gmail.com";			 
		case "463.00":
			return "ceampara@ceb.lk";			 
		case "461.00":
			return "fedrena@hotmail.com";			 
		case "462.00":
			return "vtanitha@yahoo.com";
		case "446.00":
			return "eedivulapitiya@ceb.lk";
		case "445.00":
			return "cejaela@ceb.lk";
		case "441.00":
			return "cekelaniya@ceb.lk";
		case "442.00":
			return "cenegombo@ceb.lk";
		case "443.00":
			return "cegampaha@ceb.lk";
		case "444.00":
			return "ceveyangoda@gmail.com";
		case "556.00":
			return "kamaldayananda@gmail.com";
		case "495.00":
			return "kamaldayananda@gmail.com";
		case "432.00":
			return "amilasamarakoon@gmail.com";
		case "492.00":
			return "amilasamarakoon@gmail.com";	
		case "464.00":
			return "eekalmunai@ceb.lk";
		case "513.00":
			return "cesjp@ceb.lk";
		case "518.00":
			return "eebandaragama@ceb.lk";
		case "512.00":
			return "eeavissawella@ceb.lk";
		case "516.00":
			return "eehomagama@ceb.lk";
		case "517.00":
			return "eehorana@ceb.lk";
		case "537.00":
			return "eemahiyanganaya@ceb.lk";
		case "534.00":
			return "eebadulla@ceb.lk";
		case "535.00":
			return "eediyatalawa@ceb.lk";
		case "536.00":
			return "eemonaragala@ceb.lk";
		case "551.00":
			return "eeratnapura@ceb.lk";
		case "553.00":
			return "eekahawatta@ceb.lk";
		case "554.00":
			return "eeruwanwella@ceb.lk";
		case "557.00":
			return "eeeheliyagoda@ceb.lk";
		case "558.00":
			return "eeembilipitiya@ceb.lk";
		case "451.00":
			return "nilupulsri@gmail.com";
		case "454.00":
			return "chandanaweerasekara@yahoo.com";
		case "452.00":
			return "palitha02@gmail.com";
		case "456.00":
			return "chamaradilruksha@gmail.com";
		case "457.00":
			return "amiladilhandias@yahoo.com";
		case "455.00":
			return "npprasadap@gmail.com";
		
		
		
		
				default:
			return "eranga.bogahakumbura@gmail.com";
			 
		}

  }
	
	public static String searchTelNo(String key){
	  	  switch (key) {
			case "471.00":
				return "0711257255";			 
			case "434.00":
				return "0714215522";			 
			case "470.00":
				return "0711478578";	
			case "435.00":
				return "0713183582";	
			case "431.00":
				return "0719621988";
			case "491.00":
				return "0719621988";
			case "472.00":
				return "0711902667";
			case "494.00":
				return "0711902667";	
			case "437.00":
				return "0713860343";	
			case "433.00":
				return "0714297773";
			case "496.00":
				return "0714297773";	
			
			case "439.00":
				return "0711902667";
			case "493.00":
				return "0711902667";		 
			
			case "436.00":
				return "0719444914";			 
			case "463.00":
				return "0716867520";			 
			case "461.00":
				return "0716868387";			 
			case "462.00":
				return "0716867182";
			case "446.00":
				return "0716874502";
			case "445.00":
				return "0714066350";
			case "441.00":
				return "0714066320";
			case "442.00":
				return "0714066340";
			case "443.00":
				return "0714066350";
			case "444.00":
				return "0715212334";
			case "556.00":
				return "0716836301";
			case "495.00":
				return "0716836301";
			case "432.00":
				return "0711257290";
			case "492.00":
				return "0711257290";	
			case "464.00":
				return "0715322820";
			case "513.00":
				return "0714297696";
			case "518.00":
				return "0711422023";
			case "512.00":
				return "0719835242";
			case "516.00":
				return "0719819085";
			case "517.00":
				return "0713034383";
			case "537.00":
				return "0711095430";
			case "534.00":
				return "0714527823";
			case "535.00":
				return "0714297833";
			case "536.00":
				return "0716862724";
			case "551.00":
				return "0716856882";
			case "553.00":
				return "0719621910";
			case "554.00":
				return "0712075120";
			case "557.00":
				return "0714297780";
			case "558.00":
				return "0713988872";
			case "451.00":
				return "0714298948";
			case "454.00":
				return "0718550916";
			case "452.00":
				return "0716836305";
			case "456.00":
				return "0715304661";
			case "457.00":
				return "0714302218";
			case "455.00":
				return "0711902674";
			
			
			
			
					default:
				return "0714537313";
				 
			}

	    }
	
	
	
	public static String searchAreaName(String key){
	  	  switch (key) {
			case "471.00":
				return "Dambulla";
			case "474.00":
				return "Hasalaka";	 
			
			case "434.00":
				return "Kandy City";
			case "470.00":
				return "Galagedara";	
			case "435.00":
				return "Katugasthota";	
			case "431.00":
				return "Nawalapility";
			case "472.00":
				return "Mawanella";
			case "437.00":
				return "Kundasale";	
			case "433.00":
				return "Peradeniya";
			
			case "439.00":
				return "Kegalle";
			
			case "436.00":
				return "Matale";			 
			
			case "556.00":
				return "Ginigathhena";
			
			case "432.00":
				return "Nuwara Eliya";
			
			
			
			
			
					default:
				return key;
				 
			}

	    }

	
	
	public static String searchEmailProvinceDGM(String key){
		  switch (key) {
			case "CP":
				return "dgmcp@ceb.lk";
			case "CP2":
				return "dgmcp2@ceb.lk";			 
			case "WPN":
				return "dgmwpn@ceb.lk";			 
			case "EP":
				return "alagodas1@gmail.com";	
			case "WPSII":
				return "dgmwps2@ceb.lk";	
			case "UVAP":
				return "dgmuva@ceb.lk";
			case "SABP":
				return "dgmsbp@ceb.lk";
			case "NWP":
				return "gchampika28@gmail.com";
			case "NWP2":
				return "gchampika28@gmail.com";
			case "NP":
				return "gchampika28@gmail.com";
			case "NCP":
				return "gchampika28@gmail.com";
						
			
			
			
					default:
				return "gchampika28@gmail.com";
				 
			}

	  }
	
	
	
	
	public static String searchTelNoProvinceDGM(String key){
		  switch (key) {
			case "CP":
				return "0714053907";	
			case "CP2":
				return "0714053907";			 
			case "WPN":
				return "0714066300";			 
			case "EP":
				return "0713841267";	
			case "WPSII":
				return "0714150730";	
			case "UVAP":
				return "0714298934";
			case "SABP":
				return "0714537313";
			case "NWP":
				return "0714537313";
			case "NWP2":
				return "0714537313";
			case "NP":
				return "0714537313";
			case "NCP":
				return "0714537313";
			
						
			
			
					default:
				return "0714537313";
				 
			}

	  }


	
	
	
	
	public static void trustEveryone() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new X509TrustManager[]{new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] chain,
                                               String authType) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(
                    context.getSocketFactory());
        } catch (Exception e) { // should never happen
            e.printStackTrace();
        }
    }
	
	public static String searchStatus(int key){
		  switch (key) {
		case 75:
			return "Any Modification can  be done to the estimate";			 
		case 23:
			return "Saved Estimate";			 
		case 44:
			return "To be Approved by ES";	
		case 45:
			return "To be Approved by EA";	
		case 46:
			return "To be Approved by EE";
		case 47:
			return "To be Approved by CE";	
		case 48:
			return "To be Approved by DGM";	
		case 49:
			return "To be Approved by AGM";	
		case 31:
			return "This estimate has rejected";		 
		case 30:
			return "This estimate has approved (PIV II can issue for this estimate)";			 
		case 33:
			return "PIV II Confirmed but Job number has not generated";			 
		case 22:
			return "to be Generated Job number";			 
		case 1:
			return "Ongoing Job - Job transfered to MITFIN for issue materials to the contractor";
		case 5:
			return "This job is to be revised";
		case 25:
			return "Any Modification can  be done to the revised estimate";
		case 55:
			return "Job revised. Revised Estimate to be Approved by ES";
		case 50:
			return "To be Recommend by Planning CE";
		case 51:
			return "To be Recommend by Commercial CE";
		case 56:
			return "Job revised. Revised Estimate to be Approved by EA";
		case 57:
			return "Job revised. Revised Estimate to be Approved by EE";
		case 61:
			return "Job revised. Revised Estimate to be Approved by CE";	
		case 58:
			return "Job revised. Revised Estimate to be Approved by DGM";
		case 59:
			return "Job revised. Revised Estimate to be Approved by AGM";
		case 60:
			return "This job has approved";
		case 41:
			return "This job has rejected";
		case 4:
			return "Soft Closed Job";
		case 3:
			return "Hard Closed Job";
		case 6:
			return "Exported Job";
		case 80:
			return "This estimate has opened through SPS System !!!!";

		default:
			return "Other";
			 
		}

	}
	
	public static String searchStatusAuthority(int key){
		  switch (key) {
		case 75:
			return "ES-Modify";			 
		case 23:
			return "Saved Estimate";			 
		case 44:
			return "ES";	
		case 45:
			return "EA";	
		case 46:
			return "EE";
		case 47:
			return "CE";	
		case 48:
			return "DGM";	
		case 49:
			return "AGM";	
		case 31:
			return "Rejected";		 
		case 30:
			return "This estimate has approved (PIV II can issue for this estimate)";			 
		case 33:
			return "PIV II Confirmed but Job number has not generated";			 
		case 22:
			return "to be Generated Job number";			 
		case 1:
			return "Job transfered to MITFIN for issue materials to the contractor";
		case 5:
			return "This job is to be revised";
		case 25:
			return "Any Modification can  be done to the revised estimate";
		case 55:
			return "Job revised. Revised Estimate to be Approved by ES";
		case 50:
			return "To be Recommend by Planning CE";
		case 51:
			return "To be Recommend by Commercial CE";
		case 56:
			return "Job revised. Revised Estimate to be Approved by EA";
		case 57:
			return "Job revised. Revised Estimate to be Approved by EE";
		case 61:
			return "Job revised. Revised Estimate to be Approved by CE";	
		case 58:
			return "Job revised. Revised Estimate to be Approved by DGM";
		case 59:
			return "Job revised. Revised Estimate to be Approved by AGM";
		case 60:
			return "This job has approved";
		case 41:
			return "This job has rejected";
		case 4:
			return "Soft Closed Job";
		case 3:
			return "Hard Closed Job";
		case 6:
			return "Exported Job";
		case 80:
			return "This estimate has opened through SPS System !!!!";

		default:
			return "Other";
			 
		}

	}

	
	public static String searchStatusStd(int key){
		  switch (key) {
		case 2:
			return "Any Modification can  be done to the estimate";			 
		case 1:
			return "Saved Estimate";			 
		case 8:
			return "To be Approved by ES";	
		case 45:
			return "To be Approved by EA";	
		case 10:
			return "To be Approved by EE";
		case 20:
			return "To be Approved by PE";
		case 30:
			return "To be Approved by CE";
		case 35:
			return "To be Approved by CE";	
		case 40:
			return "To be Approved by DGM";	
		case 49:
			return "To be Approved by AGM";	
		case 5:
			return "This estimate has rejected";		 
		case 50:
			return "Approved Estimate";			 
		case 60:
			return "PIV II Confirmed/Ready to Send for Construction/Maintenance/Area";
		case 70:
			return "Ready to create the work estimate from Construction/Maintenance/Area   ";
		case 90:
			return "Cancelled";
		case 80:
			return "Work Estimate is Prepared by Construction/Maintenance/Area";
		case 61:
			return "Job revised. Revised Estimate to be Approved by CE";	
		case 58:
			return "Job revised. Revised Estimate to be Approved by DGM";
		case 59:
			return "Job revised. Revised Estimate to be Approved by AGM";
		case 41:
			return "This job has rejected";
		case 4:
			return "Soft Closed Job";
		case 3:
			return "Hard Closed Job";
		case 6:
			return "Exported Job";
		
		default:
			return "Other";
			 
		}

	}

	
	
	public static String getFromattedValue(BigDecimal bigDecimal){
		DecimalFormat df2 = new DecimalFormat("###,###,###.##");
		String ss ="";
		if(bigDecimal != null){
        ss = df2.format(bigDecimal.doubleValue());
		}
		return ss;
	}
	public static String getFromattedValue(double bigDecimal){
		DecimalFormat df2 = new DecimalFormat("###,###,###.##");
		String ss ="";
		ss = df2.format(bigDecimal);
		return ss;
	}




}




