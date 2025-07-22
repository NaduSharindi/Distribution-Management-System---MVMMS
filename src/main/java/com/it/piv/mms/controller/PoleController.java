package com.it.piv.mms.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.it.piv.issue.domain.PivModel;
import com.it.piv.mms.domain.Glcompm;
import com.it.piv.mms.domain.Gldeptm;
import com.it.piv.mms.domain.MmsAddconductortype;
import com.it.piv.mms.domain.MmsAddfeeder;
import com.it.piv.mms.domain.MmsAddmvpole;
import com.it.piv.mms.domain.MmsAddmvpolecct;
import com.it.piv.mms.domain.MmsAddpole;
import com.it.piv.mms.domain.MmsAddpoletype;
import com.it.piv.mms.domain.MmsProvince;
import com.it.piv.mms.domain.MmsTxntowermaintenancemv;
import com.it.piv.mms.repo.GlcompmDao;
import com.it.piv.mms.repo.GldeptmDao;
import com.it.piv.mms.repo.MmsAddConductorTypeDao;
import com.it.piv.mms.repo.MmsAddPoleDao;
import com.it.piv.mms.repo.MmsAddPoleTypeDao;
import com.it.piv.mms.repo.MmsAddmvpoleDao;
import com.it.piv.mms.repo.MmsAddmvpolecctDao;



@Controller
public class PoleController {
	
	@Autowired
	private GldeptmDao deptDao;
	@Autowired
	private GlcompmDao glcompmDao;
	@Autowired
	public MmsAddPoleDao poleDao;
	@Autowired
	private GldeptmDao gldeptDao;
	@Autowired
	private MmsAddPoleTypeDao poleTypeDao;
	@Autowired
	private MmsAddConductorTypeDao conTypeDao;
	@Autowired
	private MmsAddmvpoleDao mvPoleDao;
	@Autowired
	private MmsAddmvpolecctDao mvPoleCctDao;
	
	
	
	
	
	@RequestMapping(value = "/addPole", method = RequestMethod.GET)
	public ModelAndView MMSaddPole(@ModelAttribute("SavePole")  MmsAddpole pole,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception{
				 String message = "Welcome to Spring 4.0 !";
				 return new ModelAndView("MMS_addPole", "message", message);
						
	}
			
	@RequestMapping(value = "/findActivePoleTypes", method = RequestMethod.GET, produces = "application/json")
			public @ResponseBody List<MmsAddpoletype> getActivePoletypes() {
				return poleTypeDao.findActiveTypes();
	}
			
			
	//add pole
			
	@RequestMapping(value = "/MMSaddPole", method = RequestMethod.POST)
			 public ModelAndView addPole(@ModelAttribute("SavePole")  MmsAddpole pole,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,ModelMap modelmap ) throws Exception {
				System.out.println("pole : MMSaddPole " );
				String deptId = request.getSession().getAttribute("deptId").toString();
                pole.setStatus(new BigDecimal("2"));
				try{
					String resultobj = poleDao.addPole(pole);
				}
				catch(Exception e){
					System.out.println("error");
				}
				
				MmsAddpole obj = new MmsAddpole();
				modelmap.addAttribute("SUCCESS_MESSAGE", "Saved Successfully");
				return new ModelAndView("MMS_addPole", "SavePole", obj);
				
	}
	
    //update Pole
		
	@RequestMapping(value = "/updatePole/{id}/{poleNo}/{poleType}/{poleArea}/{noOfStay}/{noOfStruts}/{conductorType}/{noOfConsumers1ph}/{noOfConsumers3ph}/{gpsLatitude}/{gpsLongitude}/{status}",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody void updatePole(@PathVariable("id") String id,@PathVariable("poleNo") String poleNo,@PathVariable("poleType") String poleType,@PathVariable("poleArea") String poleArea,
				@PathVariable("noOfStay") String noOfStay,@PathVariable("noOfStruts") String noOfStruts,@PathVariable("conductorType") String conductorType,
				@PathVariable("noOfConsumers1ph") String noOfConsumers1ph,@PathVariable("noOfConsumers3ph") String noOfConsumers3ph,@PathVariable("gpsLatitude") String gpsLatitude,@PathVariable("gpsLongitude") String gpsLongitude,@PathVariable("status") String status) {
			
			try{
			
			System.out.println("update");
			MmsAddpole obj = new MmsAddpole();
			obj = poleDao.findById(Long.valueOf(id));
			obj.setId(Long.valueOf(id));
			obj.setPoleNo(poleNo);
			obj.setPoleType(new BigDecimal(poleType));
			obj.setArea(poleArea);
			obj.setNoOfStay(new BigDecimal(noOfStay));
			obj.setNoOfStruts(new BigDecimal(noOfStruts));
			obj.setConductorType(new BigDecimal(conductorType));
			obj.setNoOfConsumers1ph(new BigDecimal(noOfConsumers1ph));
			obj.setNoOfConsumers3ph(new BigDecimal(noOfConsumers3ph));
			obj.setGpsLatitude(new BigDecimal(gpsLatitude));
			obj.setGpsLongitude(new BigDecimal(gpsLongitude));
			obj.setStatus(new BigDecimal(status));
			
			poleDao.update(obj);
			}catch(Exception e){
				
			}
	}
	
	
	@RequestMapping(value = "/displayPoleNew", method = RequestMethod.GET)
	public ModelAndView displayPoleNew(HttpServletRequest request) {

		
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		
		String userName = (String) request.getSession().getAttribute("loggedUser");
		String deptId = (String) request.getSession().getAttribute("deptId");
		String province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		PivModel model = new PivModel();
		List<Glcompm> pole = glcompmDao.getProvinces(distDiv);
		List<String> provinces = new ArrayList<String>();
		int loop = pole.size() - 1;
		for (int i = 0; i <= loop; i++) {
			Glcompm ojb = pole.get(i);
			provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}

		
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		
		return new ModelAndView("editPole", "model", model);

	}
	
	
	@RequestMapping(value = "/displayPoleNewS")
	public ModelAndView displayPoleNewS(HttpServletRequest request,
			@ModelAttribute("model") PivModel model) {
		String deptId = request.getSession().getAttribute("deptId").toString();
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		String area = model.getGldeptobj().getDeptId();
		String province = model.getGlcompmobj().getCompId();
		String status = null;

		if (userLevel.equals("DEO")) {
			status = Util.IN_BULK;
		} else if (userLevel.equals("ES")) {
			status = Util.VALIDATION_ES;
		} else if (userLevel.equals("EE")) {
			status = Util.APPROVAL_EE;
		}

		List<MmsAddpole> poleListEdit = poleDao.findPoleByAreaEdit(area,status);
		System.out.println("dddduuuu :" + poleListEdit.size());
		model.setPoleListEdit(poleListEdit);
		Map<String, String> poleList = new LinkedHashMap<String, String>();
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		Map<String, String> provinceList = new LinkedHashMap<String, String>();
		Map<String, String> supportTypeList = new LinkedHashMap<String, String>();
		String userName = (String) request.getSession().getAttribute("loggedUser");
		province = deptDao.getDD(deptId);
		String distDiv = glcompmDao.getDistDivision(province);
		List<Glcompm> pole1 = glcompmDao.getProvinces(distDiv);
		List<Gldeptm> deptTm = gldeptDao.getAreaByProvince(model.getGlcompmobj().getCompId());
		
		List<String> provinces = new ArrayList<String>();
		int loop = pole1.size() - 1;
		for (int i = 0; i <= loop; i++) {
			Glcompm ojb = pole1.get(i);
            provinces.add(ojb.getCompNm());
			provinceList.put(ojb.getCompId(), ojb.getCompNm());

		}

		
		
		int depLoop = deptTm.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			Gldeptm ojb = (Gldeptm) deptTm.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());
		}

		
		
		model.setProvinceList(provinceList);
		model.setAreaList(areaList);
		
				int supSize = poleListEdit.size() - 1;
				String stringOfPoleIds = "";

				for (int i = 0; i <= supSize; i++) {
					MmsAddpole obj = poleListEdit.get(i);
					if (i != 0) {
						stringOfPoleIds = stringOfPoleIds + "," + Long.toString(obj.getId());
					} else {
						stringOfPoleIds = Long.toString(obj.getId());
					}
				}
				System.out.println("-------------------> stringOfPoleIds: " + stringOfPoleIds);

				model.setStringOfPoleIds(stringOfPoleIds);
				
		
				List<MmsAddpoletype> poleType = poleTypeDao.findActiveTypes();
		        model.setPoletype(poleType);
		        List<MmsAddconductortype> conType = conTypeDao.findAll();
		        model.setConTypeList(conType);
		 	       
  		return new ModelAndView("editPole", "model", model);
	
	
	}
	
	@RequestMapping("/displayPole")
	public ModelAndView displayPole() {
		List<MmsAddpole> Pole = poleDao.findAll();
		List<MmsAddpoletype> poleType = poleTypeDao.findActiveTypes();
        
		return new ModelAndView("displayPole", "Pole", Pole);
	}
	
	@RequestMapping(value = "/updatePoleStatusNew/{area}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updatePoleStatusNew(HttpServletRequest request,@PathVariable("area") String area) {
		System.out.println("updatePoleStatusNew");
		//String deptId = request.getSession().getAttribute("deptId").toString();
		System.out.println("updatePoleStatusNew1");
		String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
		System.out.println("updatePoleStatusNew2");
		
		try {
			String status = null;
			String updateStatus = null;

			if (userLevel.equals("DEO")) {
				status = Util.IN_BULK;
				updateStatus = Util.VALIDATION_ES;
			} else if (userLevel.equals("ES")) {
				status = Util.VALIDATION_ES;
				updateStatus = Util.APPROVAL_EE;
			} else if (userLevel.equals("EE")) {
				status = Util.APPROVAL_EE;
				updateStatus = Util.APPROVE;
			}
			System.out.println("updatePoleStatusNew3");
			List<MmsAddpole> pole = poleDao.findPoleByAreaEdit(area, status);
			System.out.println("Support :" + pole.size());

			if (pole != null) {
				for (int i = 0; i < pole.size(); i++) {
					MmsAddpole obj = pole.get(i);
					System.out.println("updateSPoleStatus2" + obj.getStatus());
					obj.setStatus(new BigDecimal(updateStatus));
					
					poleDao.update(obj);
					
				}
			}
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
	
	@RequestMapping(value = "/findPoleByArea/{area}/{status}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddpole> findPoleByArea(@PathVariable("area") String area,@PathVariable("status") String status) {
		List<MmsAddpole> pole = poleDao.findPoleByAreaEdit(area, status);
		return pole;
	}
	
	@RequestMapping(value = "/findMvPoleById/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody MmsAddmvpole findMvPoleById(@PathVariable("id") String id) {
		return mvPoleDao.findById(new Long(id));
		
	}
	
	@RequestMapping(value = "/findPoleById/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody MmsAddpole findPoleById(@PathVariable("id") String id) {
		return poleDao.findById(new Long(id));
		
	}
	
	
	
	@RequestMapping(value = "/addPoleType", method = RequestMethod.GET)
    	public ModelAndView MMSAddPoleType(@ModelAttribute("MmsAddpoletype") MmsAddpoletype newPoleType,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception {
		String message = "Welcome to Spring 4.0 !";
		return new ModelAndView("MMS_addPoleType", "message", message);
	}
	
	
	//add pole type
	@RequestMapping(value = "/MMSAddPoletype", method = RequestMethod.POST)
    	public ModelAndView AddPoleType(@ModelAttribute("MmsAddpoletype") MmsAddpoletype newPoleType,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) throws Exception {
	    	String message = "Welcome to Spring 4.0 !";
		    if (!bindingResult.hasErrors()) {

			String resultobj = poleTypeDao.addPoleType(newPoleType);

			return new ModelAndView("MMS_addPoleType", "message", message);
		} else {

			return new ModelAndView("MMS_addPoleType", "message", message);
		}
	}
	
	@RequestMapping(value = "/findAllPoleTypes", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<MmsAddpoletype> getPoletypes() {
		return poleTypeDao.findAll();
	}
	
	
    	//edit pole type
			@RequestMapping("/editPoleType")
			public ModelAndView editPoleType() {
				List<MmsAddpoletype> PoleType = poleTypeDao.findAll();
				return new ModelAndView("editPoleType", "PoleType", PoleType);
		}
		
		
		
		//update pole type
		
		@RequestMapping(value = "/updatePoleType/{name}/{id}/{status}", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody void updatePoleType(@PathVariable("name") String name,@PathVariable("id") String id, @PathVariable("status") String status) {
			MmsAddpoletype obj = new MmsAddpoletype();
			obj.setPoleType(name);
			obj.setId(id);
			obj.setStatus(status);
			poleTypeDao.updatePoleType(obj);
		}
		
		//MV poles
		
		/*@RequestMapping(value = "/addMVPole", method = RequestMethod.GET)
		public ModelAndView MMSaddMVPole(HttpServletRequest request,@ModelAttribute("SaveMVPole") PivModel newmodel) {
			Map<String, String> lineList = new LinkedHashMap<String, String>();
            Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			String userName = (String) request.getSession().getAttribute("loggedUser");
			String deptId = (String) request.getSession().getAttribute("deptId");
			String province = deptDao.getDD(deptId);
			String distDiv = glcompmDao.getDistDivision(province);
			PivModel model = new PivModel();
			List<Glcompm> province1 = glcompmDao.getProvinces(distDiv);
			
			
			List<String> provinces = new ArrayList<String>();
			int loop = province1.size() - 1;
			for (int i = 0; i <= loop; i++) {
				System.out.println(i);
				Glcompm ojb = province1.get(i);

				System.out.println(ojb.getCompNm());
				provinces.add(ojb.getCompNm());
				provinceList.put(ojb.getCompId(), ojb.getCompNm());

			}
			
			// ModelAndView model = new ModelAndView();
			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
			model.setLineList(lineList);
			
			String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			String status = null;

			String phmBranch = (String) request.getSession().getAttribute("deptId");
			deptId = deptId.trim();
			
			return new ModelAndView("MMS_addMVPole", "SaveMVPole", model);
			

		}
*/
		
		@RequestMapping(value = "/findMvPoleByFeederArea/{area}/{feederNo}", method = RequestMethod.GET)
		public @ResponseBody List<MmsAddmvpole> findFeederyById(@PathVariable("area") String area,@PathVariable("feederNo") String feederNo){
			return mvPoleDao.getPoleByAreaFeeder(area,feederNo);
				
        }
		

		@RequestMapping(value = "/updateLvPoleMobile", method = RequestMethod.POST)
		public @ResponseBody String MMSUpdatePoleMntMVMobile(@RequestBody MmsAddpole pole,
				BindingResult bindingResult, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			try {
				poleDao.update(pole);
				
				return "Y";
			} catch (Exception e) {
				System.out.println("error :" + e.getMessage());
				return "N";
			}

		}
		
		
		@RequestMapping(value = "/displayAllLvPole", method = RequestMethod.GET)
		public ModelAndView displayAllLvPole(HttpServletRequest request) {

			PivModel model = new PivModel();
			String deptId = request.getSession().getAttribute("deptId").toString();
			String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
          String status = null;
			if (userLevel.equals("DEO")) {
				status = Util.IN_BULK;
			} else if (userLevel.equals("ES")) {
				status = Util.VALIDATION_ES;
			} else if (userLevel.equals("EE")) {
				status = Util.APPROVAL_EE;
			}
			String phmBranch = (String) request.getSession().getAttribute("deptId");
			System.out.println("phmbranch "+phmBranch);
			List<MmsAddpole> poleListEdit = poleDao.findLVPoleByStatus(status, phmBranch);
			model.setPoleListEdit(poleListEdit);
			List<MmsAddconductortype> conTypeList = conTypeDao.findAll();
		    model.setConTypeList(conTypeList);
		    List<MmsAddpoletype> poleType = poleTypeDao.findActiveTypes();
	        model.setPoletype(poleType);
			Map<String, String> lineList = new LinkedHashMap<String, String>();
			Map<String, String> areaList = new LinkedHashMap<String, String>();
			Map<String, String> provinceList = new LinkedHashMap<String, String>();
			String userName = (String) request.getSession().getAttribute("loggedUser");
			model.setProvinceList(provinceList);
			model.setAreaList(areaList);
          int supSize = poleListEdit.size() - 1;
			String stringOfPoleIds = "";

			for (int i = 0; i <= supSize; i++) {
				MmsAddpole obj = poleListEdit.get(i);
				if (i != 0) {
					stringOfPoleIds = stringOfPoleIds + "," + obj.getId();
				} else {
					stringOfPoleIds = Long.toString(obj.getId());
				}
			}
			System.out.println("-------------------> stringOfPoleIds: " + stringOfPoleIds);

			model.setStringOfPoleIds(stringOfPoleIds);
			
			return new ModelAndView("displayAllLvPole", "model", model);
		}
		
		
		
		@RequestMapping(value = "/updateLvPoleStatus/", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody void updateMvPoleStatusNew(HttpServletRequest request) {
			String deptId = request.getSession().getAttribute("deptId").toString();
			String userLevel = request.getSession().getAttribute("loggedUserRole").toString();
			try {
				String status = null;
				String updateStatus = null;

				if (userLevel.equals("DEO")) {
					status = Util.IN_BULK;
					updateStatus = Util.VALIDATION_ES;
				} else if (userLevel.equals("ES")) {
					status = Util.VALIDATION_ES;
					updateStatus = Util.APPROVAL_EE;
				} else if (userLevel.equals("EE")) {
					status = Util.APPROVAL_EE;
					updateStatus = Util.APPROVE;
				}
				
				List<MmsAddpole> polelist = poleDao.findLVPoleByStatus(status, deptId);
				System.out.println("Pole :" + polelist.size());

				if (polelist != null) {
					for (int i = 0; i < polelist.size(); i++) {
						MmsAddpole obj = polelist.get(i);
						System.out.println("updatestatus" + obj.getStatus());
						obj.setStatus(new BigDecimal(updateStatus));
						poleDao.update(obj);
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		
		@RequestMapping(value = "/findMvPoleByArea/{area}/",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<MmsAddmvpole> findMvPoleByArea(@PathVariable("area") String area) {
			System.out.println("area ------>>>>>>> "+area);
			return mvPoleDao.getMvPoleByArea(area);
	    }
		
		@RequestMapping(value = "/findPoleByArea/{area}/",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<MmsAddpole> findPoleByArea(@PathVariable("area") String area) {
			System.out.println("area ------>>>>>>> "+area);
			return poleDao.getPoleByArea(area);
	    }
		@RequestMapping(value = "/findCctByPoleId/{poleId}/",method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<MmsAddmvpolecct> findCctByPoleId(@PathVariable("poleId") String poleId) {
			return mvPoleCctDao.findByPoleId(new Long(poleId));
	    }

		@ExceptionHandler(NullPointerException.class)
		public String handleNullException(NullPointerException ex) {

		//ModelAndView model = new ModelAndView();
		//model.setViewName("MMS_Login");

		//model.addObject("errMsg", "this is null Exception.class");
		System.out.println("Exception occured3.........");
		//return model;
		return "MMS_Login";
		} 



}
