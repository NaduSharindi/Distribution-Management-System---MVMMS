package com.it.piv.mms.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.it.piv.issue.domain.PivModel;
import com.it.piv.issue.repo.JasperDao;
import com.it.piv.mms.domain.Glcompm;
import com.it.piv.mms.domain.Gldeptm;
import com.it.piv.mms.domain.MmsAddline;
import com.it.piv.mms.domain.MmsTxntowermaintenance;
import com.it.piv.mms.domain.MmsTxntowermaintenancePK;
import com.it.piv.mms.domain.PCB_Division;
import com.it.piv.mms.domain.PcbCondition;
import com.it.piv.mms.domain.PcbEquipment;
import com.it.piv.mms.domain.PcbLocation;
import com.it.piv.mms.domain.PcbModel;
import com.it.piv.mms.domain.PcbSample;
import com.it.piv.mms.repo.GlcompmDao;
import com.it.piv.mms.repo.GldeptmDao;
import com.it.piv.mms.repo.PcbDivisionDao;
import com.it.piv.mms.repo.PcbEquipmentDao;
import com.it.piv.mms.repo.PcbLocationDao;
import com.it.piv.mms.repo.PcbSampleDao;
import com.it.piv.mms.repo.PcbConditionDao;
import com.it.piv.util.common.PathMMS;

import org.apache.cxf.helpers.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
@Controller
public class PCBController {

	@Autowired
	private PcbConditionDao addCondition;

	@Autowired
	private PcbLocationDao addLocation;

	@Autowired
	private PcbEquipmentDao addEquipment;

	@Autowired
	private PcbDivisionDao divisionDao;
	
	@Autowired
	private GlcompmDao compDao;


	@Autowired
	private PcbSampleDao addSample;
	
	@Autowired
	private GlcompmDao glComDao;
	
	@Autowired
	private GldeptmDao gldeptDao;
	@Autowired
	private JasperDao jasperDao;
	
	
	@Autowired
	private GldeptmDao deptDao;
	
	@Autowired
	private GlcompmDao glcompmDao;
	
	


	/*
	 * //edited anushka 2019-01-23
	 * ----------------------------------------------
	 * --------------------------------------------------------
	 * 
	 * @RequestMapping(value =
	 * "addEquipmentDB/{equipmentId}/{branch}/{capacity}/{condition}/{divison}/{manufactureBrand}/{manufactureDate}/{manufactureLtl}/{oilWeight}/{photoRef}/{photoTaken}/{primarySub}/{referenceNo}/{seriaType}/{serialNo}/{type}/{unit}/{voltage}/{volumeOfOil}/{weightTransformer}"
	 * , method = RequestMethod.GET, produces = "application/json") public
	 * 
	 * @ResponseBody String addEquipmentDB(@PathVariable("code") String code,
	 * 
	 * @PathVariable("area") String area,
	 * 
	 * @PathVariable("name") String name,
	 * 
	 * @PathVariable("type") String type,
	 * 
	 * @PathVariable("length") String length,
	 * 
	 * @PathVariable("noofpoles") String noofpoles,
	 * 
	 * @PathVariable("nooftowers") String nooftowers,
	 * 
	 * @PathVariable("phmbranch") String phmbranch,
	 * 
	 * @PathVariable("comdate") String comdate) {
	 * 
	 * try { System.out.println("code " + code); System.out.println("area " +
	 * area); System.out.println("name " + name); System.out.println("type " +
	 * type); System.out.println("length " + length);
	 * System.out.println("noofpoles " + noofpoles); MmsAddline obj = new
	 * MmsAddline(); obj.setCode(code); obj.setArea(area);
	 * obj.setLineName(name); obj.setLineType(type); obj.setLength(new
	 * BigDecimal(length)); obj.setNoofpoles(new BigDecimal(noofpoles));
	 * obj.setNooftowers(new BigDecimal(nooftowers)); obj.setStatus(new
	 * BigDecimal("2")); obj.setPhmBranch(phmbranch); Date dateNow = new
	 * SimpleDateFormat("yyyy-MM-dd").parse(comdate); // String currentDate =
	 * dateNow.format(date);
	 * 
	 * obj.setComdate(dateNow); System.out.println("addLine"); String resultobj
	 * = addLine.addLine(obj); return "Y"; } catch (Exception e) { return "N"; }
	 * }
	 * //----------------------------------------------------------------------
	 * ----------------------------------------------------------
	 */

	// edited ransarani 2019-01-22
	// ----------------------------------------------------------------------------------------------
	/*
	 * @RequestMapping(value = "/MMSaddEquipment", method = RequestMethod.POST)
	 * public ModelAndView Equipment(
	 * 
	 * @ModelAttribute("SaveEquipment") PcbEquipment equipment, BindingResult
	 * bindingResult, HttpServletRequest request, HttpServletResponse response)
	 * throws Exception { // System.out.println("equipment : " +
	 * equipment.getCode());
	 * 
	 * System.out.println(" referenceNo: " + equipment.getReferenceNo());
	 * System.out.println(" divison: " + equipment.getDivison());
	 * System.out.println(" branch: " + equipment.getBranch());
	 * System.out.println(" unit: " + equipment.getUnit());
	 * System.out.println(" condition: " + equipment.getCondition());
	 * System.out.println(" photoRef: " + equipment.getPhotoRef());
	 * System.out.println(" weightTransformer: " +
	 * equipment.getWeightTransformer()); System.out.println(" volumeOfOil: " +
	 * equipment.getVolumeOfOil()); System.out.println(" oilWeight: " +
	 * equipment.getOilWeight()); System.out.println(" capacity: " +
	 * equipment.getCapacity()); System.out.println(" voltage: " +
	 * equipment.getVoltage()); System.out.println(" serialNo: " +
	 * equipment.getSerialNo()); System.out.println(" manufactureBrand: " +
	 * equipment.getManufactureBrand()); System.out.println(" photoTaken: " +
	 * equipment.getPhotoTaken()); System.out.println(" equipmentId: " +
	 * equipment.getEquipmentId()); System.out.println(" primarySub: " +
	 * equipment.getPrimarySub()); System.out.println(" manufactureLtl: " +
	 * equipment.getManufactureLtl()); System.out.println(" type: " +
	 * equipment.getType()); System.out.println(" seriaType: " +
	 * equipment.getSeriaType()); System.out.println(" manufactureDate: " +
	 * equipment.getManufactureDate());
	 * 
	 * String message = "Welcome to Spring 4.0 !"; // equipment.setStatus(new
	 * BigDecimal("2")); String sequence =
	 * addEquipment.getNextEquipmentId(equipment.getType());
	 * 
	 * System.out.println("------------------>  " + equipment.getType() + "_" +
	 * sequence);
	 * 
	 * equipment.setEquipmentId(equipment.getType() +"_" +sequence); String
	 * resultobj = addEquipment.addEquipment(equipment);
	 * 
	 * String success = "Successfully Added";
	 * 
	 * 
	 * PcbEquipment obj = new PcbEquipment();
	 * //obj.setName("Successfully Added"); ModelAndView mo = new
	 * ModelAndView("MMS_addEquipment", "SaveEquipment", obj);
	 * mo.addObject("success", success); return mo; }
	 */

	@RequestMapping(value = "/MMSaddEquipmentMobile", method = RequestMethod.POST)
	public @ResponseBody String AddEquipment(@RequestBody PcbEquipment equi,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// System.out.println("equipment : " + equipment.getCode());
		try {
			System.out.println(" referenceNo: " + equi.getReferenceNo());
			System.out.println(" divison: " + equi.getDivison());
			System.out.println(" branch: " + equi.getBranch());
			System.out.println(" unit: " + equi.getUnit());
			System.out.println(" condition: " + equi.getCondition());
			System.out.println(" photoRef: " + equi.getPhotoRef());
			System.out.println(" weightTransformer: "
					+ equi.getWeightTransformer());
			System.out.println(" volumeOfOil: " + equi.getVolumeOfOil());
			System.out.println(" oilWeight: " + equi.getOilWeight());
			System.out.println(" capacity: " + equi.getCapacity());
			System.out.println(" voltage: " + equi.getVoltage());
			System.out.println(" serialNo: " + equi.getSerialNo());
			System.out.println(" manufactureBrand: "
					+ equi.getManufactureBrand());
			System.out.println(" photoTaken: " + equi.getPhotoTaken());
			System.out.println(" equipmentId: " + equi.getEquipmentId());
			System.out.println(" primarySub: " + equi.getPrimarySub());
			System.out.println(" manufactureLtl: " + equi.getManufactureLtl());
			System.out.println(" type: " + equi.getType());
			System.out.println(" seriaType: " + equi.getSeriaType());
			System.out
					.println(" manufactureDate: " + equi.getManufactureDate());

			String message = "Welcome to Spring 4.0 !";
			// equipment.setStatus(new BigDecimal("2"));
			String sequence = addEquipment.getNextEquipmentId(equi.getType());

			System.out.println("------------------>  " + equi.getType() + "_"
					+ sequence);

			String equiID = equi.getType() + "_" + sequence;

			equi.setEquipmentId(equi.getType() + "_" + sequence);

			PcbEquipment objExisting = addEquipment
					.findEquipmentByEquipmentId(equiID);
			String resultobj = "";
			if (objExisting == null) {
				resultobj = addEquipment.addEquipment(equi);
			} else {
				// resultobj = addEquipment.(equi);
			}

			String success = "Successfully Added";

			/*
			 * PcbEquipment obj = new PcbEquipment();
			 * //obj.setName("Successfully Added"); ModelAndView mo = new
			 * ModelAndView("MMS_addEquipment", "SaveEquipment", obj);
			 * mo.addObject("success", success);
			 */return "Y";
		} catch (Exception e) {
			System.out.println("error :" + e.getMessage());
			return "N";
		}

	}

	/*
	 * @RequestMapping(value = "/manageEquipmentMobile", method =
	 * RequestMethod.POST) public @ResponseBody String
	 * manageEquipmentMobile(@RequestBody PcbModel equi, BindingResult
	 * bindingResult, HttpServletRequest request, HttpServletResponse response)
	 * throws Exception { // System.out.println("equipment : " +
	 * equipment.getCode()); try{ System.out.println(" referenceNo: " +
	 * equi.getPcbEquipment().getReferenceNo()); System.out.println(" divison: "
	 * + equi.getDivison()); System.out.println(" branch: " + equi.getBranch());
	 * System.out.println(" unit: " + equi.getUnit());
	 * System.out.println(" condition: " + equi.getCondition());
	 * System.out.println(" photoRef: " + equi.getPhotoRef());
	 * System.out.println(" weightTransformer: " + equi.getWeightTransformer());
	 * System.out.println(" volumeOfOil: " + equi.getVolumeOfOil());
	 * System.out.println(" oilWeight: " + equi.getOilWeight());
	 * System.out.println(" capacity: " + equi.getCapacity());
	 * System.out.println(" voltage: " + equi.getVoltage());
	 * System.out.println(" serialNo: " + equi.getSerialNo());
	 * System.out.println(" manufactureBrand: " + equi.getManufactureBrand());
	 * System.out.println(" photoTaken: " + equi.getPhotoTaken());
	 * System.out.println(" equipmentId: " + equi.getEquipmentId());
	 * System.out.println(" primarySub: " + equi.getPrimarySub());
	 * System.out.println(" manufactureLtl: " + equi.getManufactureLtl());
	 * System.out.println(" type: " + equi.getType());
	 * System.out.println(" seriaType: " + equi.getSeriaType());
	 * System.out.println(" manufactureDate: " + equi.getManufactureDate());
	 * 
	 * String message = "Welcome to Spring 4.0 !"; // equipment.setStatus(new
	 * BigDecimal("2")); String sequence =
	 * addEquipment.getNextEquipmentId(equi.getType());
	 * 
	 * System.out.println("------------------>  " + equi.getType() + "_" +
	 * sequence);
	 * 
	 * String equiID = equi.getType() +"_" +sequence;
	 * 
	 * equi.setEquipmentId(equi.getType() +"_" +sequence);
	 * 
	 * PcbEquipment objExisting =
	 * addEquipment.findEquipmentByEquipmentId(equiID); String resultobj ="";
	 * if(objExisting == null){ resultobj = addEquipment.addEquipment(equi);
	 * }else{ //resultobj = addEquipment.(equi); }
	 * 
	 * 
	 * String success = "Successfully Added";
	 * 
	 * 
	 * PcbEquipment obj = new PcbEquipment();
	 * //obj.setName("Successfully Added"); ModelAndView mo = new
	 * ModelAndView("MMS_addEquipment", "SaveEquipment", obj);
	 * mo.addObject("success", success); return "Y"; }catch(Exception e){
	 * System.out.println("error :" + e.getMessage()); return "N"; }
	 * 
	 * }
	 */

	@RequestMapping(value = "/GetEquipmentMobile", method = RequestMethod.GET)
	public @ResponseBody PcbEquipment GetEquipment(
			@PathVariable("equiId") String id) {
		return addEquipment.findEquipmentByEquipmentId(id);
	}

	@RequestMapping(value = "/MMSaddSample", method = RequestMethod.POST)
	public ModelAndView MMSaddSample(
			@ModelAttribute("SaveSample") PcbModel pcbModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("--> IN /MMSaddSample");

		String success = "";
		String message = "Welcome to Spring 4.0 !";
		String equipmentId = pcbModel.getPcbEquipment().getEquipmentId();
		PcbSample findAvailablePcbSample = addSample
				.findSampleByEquipmentId(equipmentId);
		PcbCondition findAvailablePcbCondition = addCondition
				.findConditionByEquipmentId(equipmentId);
		PcbLocation findAvailablePcbLocation = addLocation
				.findLocationByEquipmentId(equipmentId);

		// SET equipmentId for PcbSample, PcbCondition and PcbLocation
		pcbModel.getPcbSample().setEquipmentId(equipmentId);
		pcbModel.getPcbCondition().setEquipmentId(equipmentId);
		pcbModel.getPcbLocation().setEquipmentId(equipmentId);
		String resultobjE;
		String resultobjS;
		String resultobjC;
		String resultobjL;

		// UPDATE PcbEquipment
		if (pcbModel.getPcbEquipment() != null) {
			resultobjE = addEquipment.updateEquipment(pcbModel
					.getPcbEquipment());
			success += "Equipment Updated.. ";
		}

		// ADD PcbSample
		if (findAvailablePcbSample == null) {
			resultobjS = addSample.addSample(pcbModel.getPcbSample());
			success += "Sample Added.. ";
		}
		// UPDATE PcbSample
		else {
			resultobjS = addSample.updateSample(pcbModel.getPcbSample());
			success += "Sample Updated.. ";
		}

		// ADD PcbCondition
		if (findAvailablePcbCondition == null) {
			resultobjC = addCondition.addCondition(pcbModel.getPcbCondition());
			success += "Condition Added.. ";
		}
		// UPDATE PcbCondition
		else {
			resultobjC = addCondition.updateCondition(pcbModel
					.getPcbCondition());
			success += "Condition Updated.. ";
		}

		// ADD PcbLocation
		if (findAvailablePcbLocation == null) {
			resultobjL = addLocation.addLocation(pcbModel.getPcbLocation());
			success += "Location Added.. ";
		}
		// UPDATE PcbLocation
		else {
			resultobjL = addLocation.updateLocation(pcbModel.getPcbLocation());
			success += "Location Updated.. ";
		}
		System.out.println(success);

		// create and set new PcbModel
		PcbModel model = new PcbModel();
		model.setPcbEquipment(new PcbEquipment());
		model.setPcbSample(new PcbSample());
		model.setPcbCondition(new PcbCondition());
		model.setPcbLocation(new PcbLocation());

		// get and set the divisionList to PcbModel
		List<PCB_Division> divisionList = divisionDao.getAll();
		model.setDivisionList(divisionList);

		ModelAndView mo = new ModelAndView("MMS_addInformationReatedSample",
				"SaveSample", model);

		// add step type and success type to ModelAndView mo
		String step = "step1";
		mo.addObject("step", step);
		mo.addObject("success", success);

		return mo;
	}

	@RequestMapping(value = "/MMSaddSearchInfo", method = RequestMethod.POST)
	public ModelAndView MMSaddSearchInfo(
			@ModelAttribute("SaveSample") PcbModel pcbModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("--> IN /MMSaddSearchInfo");

		String success = "";
		String message = "Welcome to Spring 4.0 !";
		String equipmentId = pcbModel.getPcbEquipment().getEquipmentId();
		PcbSample findAvailablePcbSample = addSample
				.findSampleByEquipmentId(equipmentId);
		PcbCondition findAvailablePcbCondition = addCondition
				.findConditionByEquipmentId(equipmentId);
		PcbLocation findAvailablePcbLocation = addLocation
				.findLocationByEquipmentId(equipmentId);

		// SET equipmentId for PcbSample, PcbCondition and PcbLocation
		pcbModel.getPcbSample().setEquipmentId(equipmentId);
		pcbModel.getPcbCondition().setEquipmentId(equipmentId);
		pcbModel.getPcbLocation().setEquipmentId(equipmentId);
		String resultobjE;
		String resultobjS;
		String resultobjC;
		String resultobjL;

		// UPDATE PcbEquipment
		if (pcbModel.getPcbEquipment() != null) {
			resultobjE = addEquipment.updateEquipment(pcbModel
					.getPcbEquipment());
			success += "Equipment Updated.. ";
		}

		// ADD PcbSample
		if (findAvailablePcbSample == null) {
			resultobjS = addSample.addSample(pcbModel.getPcbSample());
			success += "Sample Added.. ";
		}
		// UPDATE PcbSample
		else {
			resultobjS = addSample.updateSample(pcbModel.getPcbSample());
			success += "Sample Updated.. ";
		}

		// ADD PcbCondition
		if (findAvailablePcbCondition == null) {
			resultobjC = addCondition.addCondition(pcbModel.getPcbCondition());
			success += "Condition Added.. ";
		}
		// UPDATE PcbCondition
		else {
			resultobjC = addCondition.updateCondition(pcbModel
					.getPcbCondition());
			success += "Condition Updated.. ";
		}

		// ADD PcbLocation
		if (findAvailablePcbLocation == null) {
			resultobjL = addLocation.addLocation(pcbModel.getPcbLocation());
			success += "Location Added.. ";
		}
		// UPDATE PcbLocation
		else {
			resultobjL = addLocation.updateLocation(pcbModel.getPcbLocation());
			success += "Location Updated.. ";
		}
		System.out.println(success);

		// create and set new PcbModel
		PcbModel model = new PcbModel();
		model.setPcbEquipment(new PcbEquipment());
		model.setPcbSample(new PcbSample());
		model.setPcbCondition(new PcbCondition());
		model.setPcbLocation(new PcbLocation());

		// get and set the divisionList to PcbModel
		List<PCB_Division> divisionList = divisionDao.getAll();
		model.setDivisionList(divisionList);

		ModelAndView mo = new ModelAndView("PCB_searchEquipmentInfoByDate",
				"SaveSample", model);

		// add step type and success type to ModelAndView mo
		String step = "step1";
		mo.addObject("step", step);
		mo.addObject("success", success);

		return mo;
	}

	@RequestMapping(value = "/searchInfoStep3", method = RequestMethod.POST)
	public ModelAndView searchInfoStep3(
			@ModelAttribute("SaveSample") PcbModel pcbModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("--> IN /searchInfoStep3");

		ModelAndView mo = new ModelAndView("PCB_searchEquipmentInfoByDate",
				"SaveSample", pcbModel);
		String errormsg = "";

		// get and print data from pcbModel.getPcbEquipment()
		Date startDate = pcbModel.getStartDate();
		Date endDate = pcbModel.getEndDate();
		String equipmentId = pcbModel.getPcbEquipment().getEquipmentId();
		System.out.println(" startDate:   " + startDate + "\n endDate:     "
				+ endDate);
		System.out.println(" equipmentId: " + equipmentId);

		// get list of divisions
		List<PCB_Division> divisionList = divisionDao.getAll();
		System.out.println("divisionList: " + divisionList);
		pcbModel.setDivisionList(divisionList);

		// get and set list of equipment ids
		List<String> equipmentIdList = addEquipment.findEquipmentIdsByDate(
				startDate, endDate);
		System.out.println("equipmentIdList: " + equipmentIdList);
		if (equipmentIdList != null) {

			// get and set list of PcbEquipment
			List<PcbEquipment> equipmentList = addEquipment
					.findEquipmentList(equipmentIdList);

			pcbModel.setEquipmentIdList(equipmentIdList);
			pcbModel.setEquipmentList(equipmentList);
		}


		// validations fail
		if (equipmentId.equalsIgnoreCase("-1")) {
			System.out.println("IN ERROR");

			pcbModel.getPcbEquipment().setEquipmentId(null);

			mo = new ModelAndView("PCB_searchEquipmentInfoByDate",
					"SaveSample", pcbModel);

			// add step type to ModelAndView mo
			String step = "step2";
			errormsg += "Please Select Equipment Id.. ";
			mo.addObject("errormsg", errormsg);
			mo.addObject("step", step);

		}

		// validations pass
		else {
			System.out.println("IN NO ERROR");

			// search PcbEquipment, PcbSample, PcbCondition and PcbLocation for
			// selected equipmentId
			PcbEquipment pcbEquipment = addEquipment
					.findEquipmentByEquipmentId(equipmentId);
			PcbSample pcbSample = addSample
					.findSampleByEquipmentId(equipmentId);
			PcbCondition pcbCondition = addCondition
					.findConditionByEquipmentId(equipmentId);
			PcbLocation pcbLocation = addLocation
					.findLocationByEquipmentId(equipmentId);

			// set pcbEquipment, pcbSample, pcbCondition and PcbLocation to
			// pcbModel
			if (pcbEquipment != null) {
				pcbModel.setPcbEquipment(pcbEquipment);

				if (pcbSample != null) {
					System.out.println("--> IN set pcbSample");
					pcbModel.setPcbSample(pcbSample);
				} else {
					System.out.println("--> IN set new pcbSample");
					pcbModel.setPcbSample(new PcbSample());
				}

				if (pcbCondition != null) {
					System.out.println("--> IN set pcbCondition");
					pcbModel.setPcbCondition(pcbCondition);
				} else {
					System.out.println("--> IN set new pcbCondition");
					pcbModel.setPcbCondition(new PcbCondition());
				}

				if (pcbLocation != null) {
					System.out.println("--> IN set pcbLocation");
					pcbModel.setPcbLocation(pcbLocation);
				} else {
					System.out.println("--> IN set new pcbLocation");
					pcbModel.setPcbLocation(new PcbLocation());
				}
			}

			mo = new ModelAndView("PCB_searchEquipmentInfoByDate",
					"SaveSample", pcbModel);

			// add step type to ModelAndView mo
			String step = "step3";
			mo.addObject("step", step);

		}

		return mo;

	}

	@RequestMapping(value = "/addPcbSampleStep3", method = RequestMethod.POST)
	public ModelAndView PcbSample3(
			@ModelAttribute("SaveSample") PcbModel pcbModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("--> IN /addPcbSampleStep3");

		ModelAndView mo = new ModelAndView("MMS_addInformationReatedSample",
				"SaveSample", pcbModel);
		String errormsg = "";

		// get and print data from pcbModel.getPcbEquipment()
		String division = pcbModel.getPcbEquipment().getDivison();
		String manufactureLtl = pcbModel.getPcbEquipment().getManufactureLtl();
		String seriaType = pcbModel.getPcbEquipment().getSeriaType();
		Date manufactureDate = pcbModel.getPcbEquipment().getManufactureDate();
		String equipmentId = pcbModel.getPcbEquipment().getEquipmentId();
		String year = pcbModel.getYear();
		System.out.println(" divison: " + division + "\n manufactureLtl: "
				+ manufactureLtl + "\n seriaType: " + seriaType
				+ "\n manufactureDate: " + manufactureDate);
		System.out.println("  equipmentId: " + equipmentId);

		// get list of divisions
		List<PCB_Division> divisionList = divisionDao.getAll();
		System.out.println("divisionList: " + divisionList);
		pcbModel.setDivisionList(divisionList);

		// get and set list of equipment ids
		List<String> equipmentIdList = addEquipment
				.findEquipmentIdsForPcbSample(division, manufactureLtl,
						seriaType, year);

		System.out.println("equipmentIdList: " + equipmentIdList);
		if (equipmentIdList != null) {

			// get and set list of PcbEquipment
			List<PcbEquipment> equipmentList = addEquipment
					.findEquipmentList(equipmentIdList);

			pcbModel.setEquipmentIdList(equipmentIdList);
			pcbModel.setEquipmentList(equipmentList);
		}

		// validations fail
		if (equipmentId.equalsIgnoreCase("-1")) {
			System.out.println("IN ERROR");

			pcbModel.getPcbEquipment().setEquipmentId(null);

			mo = new ModelAndView("MMS_addInformationReatedSample",
					"SaveSample", pcbModel);

			// add step type to ModelAndView mo
			String step = "step2";
			errormsg += "Please Select Equipment Id.. ";
			mo.addObject("errormsg", errormsg);
			mo.addObject("step", step);

		}

		// validations pass
		else {
			System.out.println("IN NO ERROR");

			// search PcbEquipment, PcbSample, PcbCondition and PcbLocation for
			// selected equipmentId
			PcbEquipment pcbEquipment = addEquipment
					.findEquipmentByEquipmentId(equipmentId);
			PcbSample pcbSample = addSample
					.findSampleByEquipmentId(equipmentId);
			PcbCondition pcbCondition = addCondition
					.findConditionByEquipmentId(equipmentId);
			PcbLocation pcbLocation = addLocation
					.findLocationByEquipmentId(equipmentId);

			// set pcbEquipment, pcbSample, pcbCondition and PcbLocation to
			// pcbModel
			if (pcbEquipment != null) {
				pcbModel.setPcbEquipment(pcbEquipment);

				if (pcbSample != null) {
					System.out.println("--> IN set pcbSample");
					pcbModel.setPcbSample(pcbSample);
				} else {
					System.out.println("--> IN set new pcbSample");
					pcbModel.setPcbSample(new PcbSample());
				}

				if (pcbCondition != null) {
					System.out.println("--> IN set pcbCondition");
					pcbModel.setPcbCondition(pcbCondition);
				} else {
					System.out.println("--> IN set new pcbCondition");
					pcbModel.setPcbCondition(new PcbCondition());
				}

				if (pcbLocation != null) {
					System.out.println("--> IN set pcbLocation");
					pcbModel.setPcbLocation(pcbLocation);
				} else {
					System.out.println("--> IN set new pcbLocation");
					pcbModel.setPcbLocation(new PcbLocation());
				}
			}

			mo = new ModelAndView("MMS_addInformationReatedSample",
					"SaveSample", pcbModel);

			// add step type to ModelAndView mo
			String step = "step3";
			mo.addObject("step", step);

		}

		return mo;

	}

	@RequestMapping(value = "/addPcbSampleStep2", method = RequestMethod.POST)
	public ModelAndView PcbSample2(@ModelAttribute("SaveSample") PcbModel pcbModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		String deptId = request.getSession().getAttribute("deptId").toString();
		
		System.out.println("--> IN /addPcbSampleStep2");

		String errormsg = "";

		ModelAndView mo = null;

		// get and print data from pcbModel.getPcbEquipment()
		String division = pcbModel.getPcbEquipment().getDivison();
		System.out.println(" divison: " + division);
		String branch = pcbModel.getPcbEquipment().getBranch();
		System.out.println(" branch: " + branch);
		String unit = pcbModel.getPcbEquipment().getUnit();
		System.out.println(" unit: " + unit);
				

		
		String manufactureLtl = pcbModel.getPcbEquipment().getManufactureLtl();
		String seriaType = pcbModel.getPcbEquipment().getSeriaType();
		String year = pcbModel.getYear();
		String type = pcbModel.getPcbEquipment().getType();
		System.out.println(" divison: " + division + "\n manufactureLtl: "
				+ manufactureLtl + "\n seriaType: " + seriaType
				+ "\n type: " + type);

		// validations
		boolean isError = false;
		
		
		
		
		/*if(division.compareTo("TR") == 0){
			List<PcbEquipment> equipmentList = addEquipment.findEquipmenListsForCategoryDivUnit(division, manufactureLtl, seriaType, year,deptId,unit,branch);
			if (equipmentList != null) {
				pcbModel.setEquipmentList(equipmentList);
			}
			mo = new ModelAndView("MMS_addInformationReatedSample","SaveSample", pcbModel);

			// add step type to ModelAndView mo
			String step = "step2";
			mo.addObject("step", step);

		}else if(division.compareTo("GN") == 0){
			List<PcbEquipment> equipmentList = addEquipment.findEquipmenListsForCategory(division, manufactureLtl, seriaType, year,deptId);
			if (equipmentList != null) {
				pcbModel.setEquipmentList(equipmentList);
			}
			mo = new ModelAndView("MMS_addInformationReatedSample","SaveSample", pcbModel);

			// add step type to ModelAndView mo
			String step = "step2";
			mo.addObject("step", step);

		}
		
		else if (division.compareTo("DD1")== 0 || division.compareTo("DD2")== 0 || division.compareTo("DD3")== 0 || division.compareTo("DD4")== 0){
			//LTL Yes
			if(manufactureLtl.compareTo("Yes") == 0){
				//Seal Type seal
				if(seriaType.compareTo("seal") == 0){
					//year before 1990
					if(Integer.valueOf(year) == 1){
						List<PcbEquipment> equipmentList = addEquipment.findEquipmenListsForCategory(division, manufactureLtl, seriaType, year,deptId);
						if (equipmentList != null) {
							pcbModel.setEquipmentList(equipmentList);
						}
						mo = new ModelAndView("MMS_addInformationReatedSample","SaveSample", pcbModel);

						// add step type to ModelAndView mo
						String step = "step2";
						mo.addObject("step", step);

					}
					//year after 1990 no sampling
					else{
						
					}
				}
				//Seal Type non seal
				else{
					List<PcbEquipment> equipmentList = addEquipment.findEquipmenListsForCategory(division, manufactureLtl, seriaType, year,deptId);
					if (equipmentList != null) {
						pcbModel.setEquipmentList(equipmentList);
					}
					mo = new ModelAndView("MMS_addInformationReatedSample","SaveSample", pcbModel);

					// add step type to ModelAndView mo
					String step = "step2";
					mo.addObject("step", step);
		
					
				}
			//LTL No other transformers	
			}else{
				if(seriaType.compareTo("seal") == 0){
					//year before 1990
					if(Integer.valueOf(year) == 1){
						List<PcbEquipment> equipmentList = addEquipment.findEquipmenListsForCategory(division, manufactureLtl, seriaType, year,deptId);
						if (equipmentList != null) {
							pcbModel.setEquipmentList(equipmentList);
						}
						mo = new ModelAndView("MMS_addInformationReatedSample","SaveSample", pcbModel);

						// add step type to ModelAndView mo
						String step = "step2";
						mo.addObject("step", step);

					}
					//year after 1990 no sampling
					else{
						
					}

				}
				//Seal Type non seal
				else{
					List<PcbEquipment> equipmentList = addEquipment.findEquipmenListsForCategory(division, manufactureLtl, seriaType, year,deptId);
					if (equipmentList != null) {
						pcbModel.setEquipmentList(equipmentList);
					}
					mo = new ModelAndView("MMS_addInformationReatedSample","SaveSample", pcbModel);

					// add step type to ModelAndView mo
					String step = "step2";
					mo.addObject("step", step);
		
					
				}	
				
			}
		}
		
		else{
			
		}
		
*/		
		/*else if(division.equalsIgnoreCase("1") && manufactureLtl.equalsIgnoreCase("-1") &&  seriaType.equalsIgnoreCase("-1") &&  year.equalsIgnoreCase("-1")){
			List<PcbEquipment> equipmentList = addEquipment.findEquipmenListsForCategory1(division, manufactureLtl, seriaType, year,deptId);
			if (equipmentList != null) {
				pcbModel.setEquipmentList(equipmentList);
			}
			mo = new ModelAndView("MMS_addInformationReatedSample","SaveSample", pcbModel);

			// add step type to ModelAndView mo
			String step = "step2";
			mo.addObject("step", step);

		}
		else{
		
		if (division.equalsIgnoreCase("-1")) {
			isError = true;
			errormsg += "Select Division.. ";
			pcbModel.getPcbEquipment().setDivison(null);
		}
		if (manufactureLtl.equalsIgnoreCase("-1")) {
			isError = true;
			errormsg += "Select Manufacture Ltl.. ";
		}
		if (seriaType.equalsIgnoreCase("-1")) {
			isError = true;
			errormsg += "Select Seria Type.. ";
		}if (year.equalsIgnoreCase("-1")) {
			isError = true;
			errormsg += "Select Year.. ";
		}
		
		// validation fail
		if (isError) {
			System.out.println("IN ERROR");
			mo = new ModelAndView("MMS_addInformationReatedSample","SaveSample", pcbModel);

			// add step type and success type to ModelAndView mo
			String success = "";
			String step = "step1";
			mo.addObject("step", step);
			mo.addObject("errormsg", errormsg);
			mo.addObject("success", success);
		}

		// validation pass
		else {
			
			
			List<PcbEquipment> equipmentList = addEquipment.findEquipmenListsForCategory(division, manufactureLtl, seriaType, year,deptId);
			if (equipmentList != null) {
				pcbModel.setEquipmentList(equipmentList);
			}
			mo = new ModelAndView("MMS_addInformationReatedSample","SaveSample", pcbModel);

			// add step type to ModelAndView mo
			String step = "step2";
			mo.addObject("step", step);
		}
*/		
		
		//}
		
		
		
		
		
		//List
		
		
		

		List<PcbEquipment> equipmentList = addEquipment.findEquipmentIdsForDivBraUnit(division,branch,unit,manufactureLtl.trim(),seriaType.trim(),type.trim());
		System.out.println("IN equipmentList : "+ equipmentList);
		
		
		if (equipmentList != null) {
			pcbModel.setEquipmentList(equipmentList);
		}
		
		Map<String, String> divStrList = new LinkedHashMap<String, String>();
		Map<String, String> proStrList = new LinkedHashMap<String, String>();
		Map<String, String> areaList = new LinkedHashMap<String, String>();
		
		List<Glcompm>  divList = glComDao.getDisDivision();
		System.out.print("hiii");
		int divListCount = divList.size() - 1;
		for (int i = 0; i <= divListCount; i++) {
			System.out.println(i);
			Glcompm ojb = divList.get(i);
			divStrList.put(ojb.getCompId(), ojb.getCompNm());

		}
		String divStr = pcbModel.getPcbEquipment().getDivison();
		System.out.println("divStr" + divStr);
		
		List<Glcompm>  proList = glComDao.getProvincesPCB(divStr);
		int proListCount = proList.size() - 1;
		for (int i = 0; i <= proListCount; i++) {
			System.out.println(i);
			Glcompm ojb = proList.get(i);
			proStrList.put(ojb.getCompId(), ojb.getCompNm());

		}
		String provinceStr = pcbModel.getPcbEquipment().getBranch();
		System.out.println("provinceStr" + provinceStr);
		
		List<Gldeptm>  arList = gldeptDao.getAreaByProvince(provinceStr);
		int areListCount = arList.size() - 1;
		for (int i = 0; i <= areListCount; i++) {
			System.out.println(i);
			Gldeptm ojb = arList.get(i);
			areaList.put(ojb.getDeptId(), ojb.getDeptNm());

		}

		pcbModel.setDivList(divStrList);
		pcbModel.setProvinceList(proStrList);
		pcbModel.setAreaList(areaList);
		

		
		
		List<PcbModel> listPcbModel = new ArrayList<PcbModel>();
		List<PcbEquipment> list = addEquipment.findEquipmentIdForMobile(division,branch,unit);
		
		if(list != null){
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
		
		
		pcbModel.setListPcbModel(listPcbModel);
		
	
		
		
		
		
		mo = new ModelAndView("MMS_addInformationReatedSample","SaveSample", pcbModel);

		// add step type to ModelAndView mo
		String step = "step2";
		mo.addObject("step", step);


		return mo;

	}

	@RequestMapping(value = "/searchInfoStep2", method = RequestMethod.POST)
	public ModelAndView searchInfoStep2(
			@ModelAttribute("SaveSample") PcbModel pcbModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("--> IN /searchInfoStep2");

		String errormsg = "";

		ModelAndView mo;

		// get and print data from pcbModel.getPcbEquipment()
		Date startDate = pcbModel.getStartDate();
		Date endDate = pcbModel.getEndDate();
		System.out.println(" startDate: " + startDate + "\n endDate:   "
				+ endDate);

		// validations
		boolean isError = false;
		if (startDate == null) {
			System.out.println("startDate.equals(null)");
			isError = true;
			errormsg += "Start Date Required.. ";
		}
		if (endDate == null) {
			System.out.println("endDate.equals(null)");
			isError = true;
			errormsg += "End Date Required.. ";
		}

		// validation fail
		if (isError) {
			System.out.println("IN ERROR");

			// get and set list of divisions
			List<PCB_Division> divisionList = divisionDao.getAll();
			pcbModel.setDivisionList(divisionList);

			mo = new ModelAndView("PCB_searchEquipmentInfoByDate",
					"SaveSample", pcbModel);

			// add step type and success type to ModelAndView mo
			String success = "";
			String step = "step1";
			mo.addObject("step", step);
			mo.addObject("errormsg", errormsg);
			mo.addObject("success", success);
		}

		// validation pass
		else {
			System.out.println("IN NO ERROR");

			// get and set list of divisions
			List<PCB_Division> divisionList = divisionDao.getAll();
			System.out.println("divisionList: " + divisionList);
			pcbModel.setDivisionList(divisionList);

			// get and set list of equipment ids
			List<String> equipmentIdList = addEquipment.findEquipmentIdsByDate(
					startDate, endDate);
			System.out.println("equipmentIdList: " + equipmentIdList);
			if (equipmentIdList != null) {

				// get and set list of PcbEquipment
				List<PcbEquipment> equipmentList = addEquipment
						.findEquipmentList(equipmentIdList);

				pcbModel.setEquipmentIdList(equipmentIdList);
				pcbModel.setEquipmentList(equipmentList);
			}

			mo = new ModelAndView("PCB_searchEquipmentInfoByDate",
					"SaveSample", pcbModel);

			// add step type to ModelAndView mo
			String step = "step2";
			mo.addObject("step", step);
		}

		return mo;

	}

	@RequestMapping(value = "/searchInfoByDate", method = RequestMethod.GET)
	public ModelAndView searchInfoByDate(
			@ModelAttribute("SaveSample") PcbModel pcbModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("--> IN /searchInfoByDate");

		// get and set list of divisions
		List<PCB_Division> divisionList = divisionDao.getAll();
		pcbModel.setDivisionList(divisionList);

		ModelAndView mo = new ModelAndView("PCB_searchEquipmentInfoByDate",
				"SaveSample", pcbModel);

		// add step type and success type to ModelAndView mo
		String success = "";
		String step = "step1";
		mo.addObject("step", step);
		mo.addObject("success", success);

		return mo;

	}

	@RequestMapping(value = "/addInformationReatedSample", method = RequestMethod.GET)
	public ModelAndView InformationReatedSample(
			@ModelAttribute("SaveSample") PcbModel pcbModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("--> IN /addInformationReatedSample");

		// get and set list of divisions
		//List<PCB_Division> divisionList = divisionDao.getAll();
		List<Glcompm> compList = compDao.getDisDivision();
		
		//pcbModel.setDivisionList(divisionList);
		//pcbModel.setCompList(compList);
		Map<String,String> divListTem = new LinkedHashMap<String,String>();
		
		int depLoop = compList.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			Glcompm ojb = (Glcompm) compList.get(i);
			System.out.println(i + " " +ojb.getCompNm() );
			
			divListTem.put(ojb.getCompId(), ojb.getCompNm());
		}
		
		pcbModel.setDivList(divListTem);
		ModelAndView mo = new ModelAndView("MMS_addInformationReatedSample","SaveSample", pcbModel);

		// add step type and success type to ModelAndView mo
		String success = "";
		String step = "step1";
		mo.addObject("step", step);
		mo.addObject("success", success);

		return mo;

	}
	
	
	@RequestMapping(value = "/editEquipmentNew", method = RequestMethod.GET)
	public ModelAndView editEquipment(
			@ModelAttribute("EditEquipment") PcbModel pcbModel,@RequestParam("equid") String equId,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("--> IN /editEquipment");

		ModelAndView mo = null;;
		try {
			String submitType = "search";
			pcbModel = new PcbModel();
			
			pcbModel.getPcbEquipment().setReferenceNo(equId);

			mo = new ModelAndView("editEquipment", "EditEquipment",
					pcbModel);

			mo.addObject("submitType", submitType);
			mo.addObject("equiid", equId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mo;
	}
	
	

	@RequestMapping(value = "/editEquipment", method = RequestMethod.GET)
	public ModelAndView editEquipment(
			@ModelAttribute("EditEquipment") PcbModel pcbModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("--> IN /editEquipment");

		String submitType = "search";
		pcbModel = new PcbModel();

		ModelAndView mo = new ModelAndView("editEquipment", "EditEquipment",
				pcbModel);

		mo.addObject("submitType", submitType);
		return mo;
	}
	
	
	@RequestMapping(value = "/editEquipmentSampleNo", method = RequestMethod.GET)
	public ModelAndView editEquipmentSampleNo(
			@ModelAttribute("EditEquipment") PcbModel pcbModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("--> IN /editEquipment");

		String submitType = "search";
		pcbModel = new PcbModel();

		ModelAndView mo = new ModelAndView("editEquipmentSampleNo", "EditEquipment",
				pcbModel);

		mo.addObject("submitType", submitType);
		return mo;
	}



	@RequestMapping(value = "/editEquipmentSample", method = RequestMethod.GET)
	public ModelAndView editEquipmentSample(
			@RequestParam("equipmentId") String equipmentId,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		System.out.println("--> IN /editEquipmentSample");

		String submitType = "search";
		PcbModel pcbModel = new PcbModel();
		System.out.println("equipmentId: " + equipmentId);
		PcbEquipment pcbEquipment = new PcbEquipment();
		pcbEquipment.setEquipmentId(equipmentId);
		pcbModel.setPcbEquipment(pcbEquipment);
		System.out.println("equipmentId: "
				+ pcbModel.getPcbEquipment().getEquipmentId());

		ModelAndView mo = new ModelAndView("editEquipment", "EditEquipment",
				pcbModel);

		mo.addObject("submitType", submitType);
		return mo;
	}

	@RequestMapping(value = "/goToUpdateEquipment", method = RequestMethod.POST)
	public ModelAndView goToUpdateEquipment(
			@ModelAttribute("EditEquipment") PcbModel pcbModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mo =null;
		try {
			System.out.println("--> IN /goToUpdateEquipment");

			String success = "";
			String errormsg = "";
			String submitType = "search";
			mo = new ModelAndView("editEquipment", "EditEquipment",pcbModel);
			String sampleNo = "";
			String equipmentId = "";
			String referenceNo = pcbModel.getPcbEquipment().getReferenceNo();
			//sampleNo = pcbModel.getPcbSample().getSamplingNu();
			equipmentId = addEquipment.getEquipmentIdByReferenceNo(referenceNo);
			
			/*System.out.println("referenceNo : " + referenceNo);
			if(!referenceNo.equalsIgnoreCase("")){
				
				System.out.println("sampleNo" + sampleNo);
				
			}
			
			if(!sampleNo.equalsIgnoreCase("")){
				
				System.out.println("sampleNo" + sampleNo);
				equipmentId = addEquipment.getEquipmentIdBySampleNo(sampleNo);
				referenceNo = addEquipment.getReferenceNoByEquipmentId(equipmentId);
				pcbModel.getPcbEquipment().setReferenceNo(referenceNo);
			}
			*/
			
			//System.out.println("divStr :" + divStr);
			//System.out.println("dddd: "+pcbEquipment);
			
			if(pcbModel.getPcbSample()!=null){
			BigDecimal c = pcbModel.getPcbSample().getPcbTestData();
			if(c!=null){
			int n = 2;
			BigDecimal a1 = c.pow(n);
			BigDecimal a2 = new BigDecimal("-0.0004");
			BigDecimal a3 = a2.multiply(a1);
			BigDecimal a4 = new BigDecimal("3.4523");
			BigDecimal a5 = a4.multiply(c);
			BigDecimal a6 = new BigDecimal("9.2363");
			BigDecimal a7 = a5.subtract(a6);
			BigDecimal a8 = a3.add(a7);

			BigDecimal aroclor = a8;
			pcbModel.getPcbSample().setPcbTestDataAroclor(aroclor);
			}
			}
			if(pcbModel.getPcbEquipment()!=null){
				BigDecimal c = pcbModel.getPcbEquipment().getOilWeight();
				if(c!=null){
					BigDecimal a = new BigDecimal("0.86");
					BigDecimal result = c.divide(a);
					pcbModel.getPcbEquipment().setVolOil(result);
				}else{
					BigDecimal c1 = pcbModel.getPcbEquipment().getVolOil();
					if(c1!=null){
						BigDecimal a = new BigDecimal("0.86");
						BigDecimal result = c1.multiply(a);
						pcbModel.getPcbEquipment().setOilWeight(result);
					}
				}
			}
			
			

					
			PcbEquipment pcbEquipment = addEquipment.findEquipmentByEquipmentId(equipmentId);
			//pcbEquipment.setReferenceNo(referenceNo);
			System.out.println("goToUpdateEquipment goToUpdateEquipment: "+pcbEquipment);
			PcbSample pcbSample = addSample.findSampleByEquipmentId(equipmentId);
			PcbCondition pcbCondition = addCondition
					.findConditionByEquipmentId(equipmentId);
			PcbLocation pcbLocation = addLocation
					.findLocationByEquipmentId(equipmentId);

			if (pcbEquipment != null) {
				pcbModel.setPcbEquipment(pcbEquipment);

				System.out.println("dateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee: "
						+ pcbModel.getPcbEquipment().getManufactureDate());

				if (pcbSample != null) {
					System.out.println("sampleDate: "
							+pcbSample.getSampleDate() );

					pcbModel.setPcbSample(pcbSample);
				}
				if (pcbCondition != null) {
					pcbModel.setPcbCondition(pcbCondition);
				}
				if (pcbLocation != null) {
					pcbModel.setPcbLocation(pcbLocation);
				}

				// get and set list of divisions
				//List<PCB_Division> divisionList = divisionDao.getAll();
				//pcbModel.setDivisionList(divisionList);

				submitType = "update";
				Map<String, String> divStrList = new LinkedHashMap<String, String>();
				Map<String, String> proStrList = new LinkedHashMap<String, String>();
				Map<String, String> areaList = new LinkedHashMap<String, String>();
				
				List<Glcompm>  divList = glComDao.getDisDivision();
				System.out.print("hiii");
				int divListCount = divList.size() - 1;
				for (int i = 0; i <= divListCount; i++) {
					System.out.println(i);
					Glcompm ojb = divList.get(i);
					divStrList.put(ojb.getCompId(), ojb.getCompNm());

				}
				String divStr = pcbModel.getPcbEquipment().getDivison();
				
				List<Glcompm>  proList = glComDao.getProvincesPCB(divStr);
				int proListCount = proList.size() - 1;
				for (int i = 0; i <= proListCount; i++) {
					System.out.println(i);
					Glcompm ojb = proList.get(i);
					proStrList.put(ojb.getCompId(), ojb.getCompNm());

				}
				String provinceStr = pcbModel.getPcbEquipment().getBranch();
				
				List<Gldeptm>  arList = gldeptDao.getAreaByProvince(provinceStr);
						int areListCount = arList.size() - 1;
				for (int i = 0; i <= areListCount; i++) {
					System.out.println(i);
					Gldeptm ojb = arList.get(i);
					areaList.put(ojb.getDeptId(), ojb.getDeptNm());

				}


				pcbModel.setDivList(divStrList);
				pcbModel.setProvinceList(proStrList);
				pcbModel.setAreaList(areaList);
				
				mo = new ModelAndView("editEquipment", "EditEquipment", pcbModel);
			} else {
				errormsg = "Invalid Equipment ID.. ";
			}

			mo.addObject("submitType", submitType);
			mo.addObject("success", success);
			mo.addObject("errormsg", errormsg);
			return mo;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mo;
	}
	
	@RequestMapping(value = "/ViewTransformerData", method = RequestMethod.GET)
	public ModelAndView ViewTransformerData(@RequestParam("referenceNo") String refeenceNo) throws Exception {
		ModelAndView mo =null;
		PcbModel pcbModel = new PcbModel();
		try {
			String success = "";
			String errormsg = "";
			String submitType = "search";
			String sampleNo = "";
			String equipmentId = "";
			String referenceNo = refeenceNo;
			equipmentId = addEquipment.getEquipmentIdByReferenceNo(referenceNo);
			
			PcbEquipment pcbEquipment = addEquipment.findEquipmentByEquipmentId(equipmentId);
			PcbSample pcbSample = addSample.findSampleByEquipmentId(equipmentId);
			PcbCondition pcbCondition = addCondition
					.findConditionByEquipmentId(equipmentId);
			PcbLocation pcbLocation = addLocation
					.findLocationByEquipmentId(equipmentId);

			if (pcbEquipment != null) {
				pcbModel.setPcbEquipment(pcbEquipment);
				if (pcbSample != null) {
					pcbModel.setPcbSample(pcbSample);
				}
				if (pcbCondition != null) {
					pcbModel.setPcbCondition(pcbCondition);
				}
				if (pcbLocation != null) {
					pcbModel.setPcbLocation(pcbLocation);
				}

				submitType = "update";
				/*Map<String, String> divStrList = new LinkedHashMap<String, String>();
				Map<String, String> proStrList = new LinkedHashMap<String, String>();
				Map<String, String> areaList = new LinkedHashMap<String, String>();
				
				List<Glcompm>  divList = glComDao.getDisDivision();
				int divListCount = divList.size() - 1;
				for (int i = 0; i <= divListCount; i++) {
					Glcompm ojb = divList.get(i);
					divStrList.put(ojb.getCompId(), ojb.getCompNm());

				}
				String divStr = pcbModel.getPcbEquipment().getDivison();
				
				List<Glcompm>  proList = glComDao.getProvincesPCB(divStr);
				int proListCount = proList.size() - 1;
				for (int i = 0; i <= proListCount; i++) {
					Glcompm ojb = proList.get(i);
					proStrList.put(ojb.getCompId(), ojb.getCompNm());

				}
				String provinceStr = pcbModel.getPcbEquipment().getBranch();
				
				List<Gldeptm>  arList = gldeptDao.getAreaByProvince(provinceStr);
						int areListCount = arList.size() - 1;
				for (int i = 0; i <= areListCount; i++) {
					Gldeptm ojb = arList.get(i);
					areaList.put(ojb.getDeptId(), ojb.getDeptNm());

				}


				pcbModel.setDivList(divStrList);
				pcbModel.setProvinceList(proStrList);
				pcbModel.setAreaList(areaList);
*/				
				mo = new ModelAndView("Transformer", "SaveEquipment", pcbModel);
			} else {
				errormsg = "Invalid Equipment ID.. ";
			}

			mo.addObject("submitType", submitType);
			mo.addObject("success", success);
			mo.addObject("errormsg", errormsg);
			return mo;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mo;
	}

	
	
	
	
	
	@RequestMapping(value = "/goToUpdateEquipmentSampleNo", method = RequestMethod.POST)
	public ModelAndView goToUpdateEquipmentSampleNo(
			@ModelAttribute("EditEquipment") PcbModel pcbModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mo =null;
		try {
			System.out.println("--> IN /goToUpdateEquipmentSampleNo");

			String success = "";
			String errormsg = "";
			String submitType = "search";
			mo = new ModelAndView("editEquipmentSampleNo", "EditEquipment",pcbModel);
			String sampleNo = "";
			String equipmentId = "";
			//String referenceNo = pcbModel.getPcbEquipment().getReferenceNo();
			sampleNo = pcbModel.getSampleNo();
			//equipmentId = addEquipment.getEquipmentIdByReferenceNo(referenceNo);
			equipmentId = addEquipment.getEquipmentIdBySampleNo(sampleNo);
			System.out.println("sampleNo : " + sampleNo);
			System.out.println("equipmentId : " + equipmentId);
			
			if(pcbModel.getPcbSample()!=null){
			BigDecimal c = pcbModel.getPcbSample().getPcbTestData();
			if(c!=null){
			int n = 2;
			BigDecimal a1 = c.pow(n);
			BigDecimal a2 = new BigDecimal("-0.0004");
			BigDecimal a3 = a2.multiply(a1);
			BigDecimal a4 = new BigDecimal("3.4523");
			BigDecimal a5 = a4.multiply(c);
			BigDecimal a6 = new BigDecimal("9.2363");
			BigDecimal a7 = a5.subtract(a6);
			BigDecimal a8 = a3.add(a7);

			BigDecimal aroclor = a8;
			pcbModel.getPcbSample().setPcbTestDataAroclor(aroclor);
			}
			}
			if(pcbModel.getPcbEquipment()!=null){
				BigDecimal c = pcbModel.getPcbEquipment().getOilWeight();
				if(c!=null){
					BigDecimal a = new BigDecimal("0.86");
					BigDecimal result = c.divide(a);
					pcbModel.getPcbEquipment().setVolOil(result);
				}else{
					BigDecimal c1 = pcbModel.getPcbEquipment().getVolOil();
					if(c1!=null){
						BigDecimal a = new BigDecimal("0.86");
						BigDecimal result = c1.multiply(a);
						pcbModel.getPcbEquipment().setOilWeight(result);
					}
				}
			}
			
			
			equipmentId =equipmentId.trim();
					
			PcbEquipment pcbEquipment = addEquipment.findEquipmentByEquipmentId(equipmentId);
			//pcbEquipment.setReferenceNo(referenceNo);
			System.out.println("goToUpdateEquipment goToUpdateEquipment: "+pcbEquipment);
			PcbSample pcbSample = addSample.findSampleByEquipmentId(equipmentId);
			PcbCondition pcbCondition = addCondition
					.findConditionByEquipmentId(equipmentId);
			PcbLocation pcbLocation = addLocation
					.findLocationByEquipmentId(equipmentId);

			if (pcbEquipment != null) {
				pcbModel.setPcbEquipment(pcbEquipment);
				System.out.println("Reference No: "
						+ pcbEquipment.getReferenceNo());

				System.out.println("dateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee: "
						+ pcbModel.getPcbEquipment().getManufactureDate());

				if (pcbSample != null) {
					System.out.println("sampleDate: "
							+pcbSample.getSampleDate() );

					pcbModel.setPcbSample(pcbSample);
				}
				if (pcbCondition != null) {
					pcbModel.setPcbCondition(pcbCondition);
				}
				if (pcbLocation != null) {
					pcbModel.setPcbLocation(pcbLocation);
				}

				// get and set list of divisions
				//List<PCB_Division> divisionList = divisionDao.getAll();
				//pcbModel.setDivisionList(divisionList);

				submitType = "update";
				Map<String, String> divStrList = new LinkedHashMap<String, String>();
				Map<String, String> proStrList = new LinkedHashMap<String, String>();
				Map<String, String> areaList = new LinkedHashMap<String, String>();
				
				List<Glcompm>  divList = glComDao.getDisDivision();
				System.out.print("hiii");
				int divListCount = divList.size() - 1;
				for (int i = 0; i <= divListCount; i++) {
					System.out.println(i);
					Glcompm ojb = divList.get(i);
					divStrList.put(ojb.getCompId(), ojb.getCompNm());

				}
				String divStr = pcbModel.getPcbEquipment().getDivison();
				
				List<Glcompm>  proList = glComDao.getProvincesPCB(divStr);
				int proListCount = proList.size() - 1;
				for (int i = 0; i <= proListCount; i++) {
					System.out.println(i);
					Glcompm ojb = proList.get(i);
					proStrList.put(ojb.getCompId(), ojb.getCompNm());

				}
				String provinceStr = pcbModel.getPcbEquipment().getBranch();
				
				List<Gldeptm>  arList = gldeptDao.getAreaByProvince(provinceStr);
						int areListCount = arList.size() - 1;
				for (int i = 0; i <= areListCount; i++) {
					System.out.println(i);
					Gldeptm ojb = arList.get(i);
					areaList.put(ojb.getDeptId(), ojb.getDeptNm());

				}


				pcbModel.setDivList(divStrList);
				pcbModel.setProvinceList(proStrList);
				pcbModel.setAreaList(areaList);
				
				mo = new ModelAndView("editEquipmentSampleNo", "EditEquipment", pcbModel);
			} else {
				errormsg = "Invalid Sample No.. ";
			}

			mo.addObject("submitType", submitType);
			mo.addObject("success", success);
			mo.addObject("errormsg", errormsg);
			return mo;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mo;
	}

	

	@RequestMapping(value = "/MMSaddEquipment", method = RequestMethod.POST)
	public ModelAndView Equipment(
			@ModelAttribute("SaveEquipment") PcbModel pcbModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("--> IN /MMSaddEquipment");

		System.out.println(" referenceNo: "
				+ pcbModel.getPcbEquipment().getReferenceNo());
		System.out.println(" divison: "
				+ pcbModel.getPcbEquipment().getDivison());
		System.out
				.println(" branch: " + pcbModel.getPcbEquipment().getBranch());
		System.out.println(" unit: " + pcbModel.getPcbEquipment().getUnit());
		System.out.println(" condition: "
				+ pcbModel.getPcbEquipment().getCondition());
		System.out.println(" photoRef: "
				+ pcbModel.getPcbEquipment().getPhotoRef());
		System.out.println(" weightTransformer: "
				+ pcbModel.getPcbEquipment().getWeightTransformer());
		System.out.println(" volumeOfOil: "
				+ pcbModel.getPcbEquipment().getVolumeOfOil());
		System.out.println(" oilWeight: "
				+ pcbModel.getPcbEquipment().getOilWeight());
		System.out.println(" capacity: "
				+ pcbModel.getPcbEquipment().getCapacity());
		System.out.println(" voltage: "
				+ pcbModel.getPcbEquipment().getVoltage());
		System.out.println(" serialNo: "
				+ pcbModel.getPcbEquipment().getSerialNo());
		System.out.println(" manufactureBrand: "
				+ pcbModel.getPcbEquipment().getManufactureBrand());
		System.out.println(" photoTaken: "
				+ pcbModel.getPcbEquipment().getPhotoTaken());
		System.out.println(" equipmentId: "
				+ pcbModel.getPcbEquipment().getEquipmentId());
		System.out.println(" primarySub: "
				+ pcbModel.getPcbEquipment().getPrimarySub());
		System.out.println(" manufactureLtl: "
				+ pcbModel.getPcbEquipment().getManufactureLtl());
		System.out.println(" type: " + pcbModel.getPcbEquipment().getType());
		System.out.println(" seriaType: "
				+ pcbModel.getPcbEquipment().getSeriaType());
		System.out.println(" manufactureDate: "
				+ pcbModel.getPcbEquipment().getManufactureDate());

		String message = "Welcome to Spring 4.0 !";

		PcbEquipment objEx = new PcbEquipment();
		if (pcbModel.getPcbEquipment().getReferenceNo() == null) {
			objEx = null;
		} else {
			String refNo = pcbModel.getPcbEquipment().getReferenceNo();
			String equipmentId = addEquipment.getEquipmentIdByReferenceNo(refNo);
			objEx = addEquipment.findEquipmentByEquipmentId(equipmentId);
		}

		String resultobjE = "";
		String resultobjS = "";
		String resultobjC = "";
		String resultobjL = "";
		String success = "";
		String submitType = "";
		PcbModel obj = new PcbModel();
		ModelAndView mo = new ModelAndView("MMS_addEquipment", "SaveEquipment",
				obj);

		// for add equipment
		if (objEx == null) {
			System.out.println("--> IN ADD EQUIPMENT");

			String sequence = addEquipment.getNextEquipmentId(pcbModel
					.getPcbEquipment().getType());
			System.out.println("equipmentId: "
					+ pcbModel.getPcbEquipment().getType() + "_" + sequence);

			String equipmentId = pcbModel.getPcbEquipment().getType() + "_"
					+ sequence;
			pcbModel.getPcbEquipment().setEquipmentId(equipmentId);
			pcbModel.getPcbSample().setEquipmentId(equipmentId);
			pcbModel.getPcbCondition().setEquipmentId(equipmentId);
			pcbModel.getPcbLocation().setEquipmentId(equipmentId);

			resultobjE = addEquipment.addEquipment(pcbModel.getPcbEquipment());
			success += "Equipment Added.. ";

			resultobjS = addSample.addSample(pcbModel.getPcbSample());
			success += "Sample Added.. ";

			resultobjC = addCondition.addCondition(pcbModel.getPcbCondition());
			success += "Condition Added.. ";

			resultobjL = addLocation.addLocation(pcbModel.getPcbLocation());
			success += "Location Added.. ";

			mo = new ModelAndView("MMS_addEquipment", "SaveEquipment", obj);
		}

		// for update equipment
		else {
			System.out.println("--> IN EDIT EQUIPMENT");

			//String equipmentId = pcbModel.getPcbEquipment().getEquipmentId();
			
			String refNo = pcbModel.getPcbEquipment().getReferenceNo();
			String equipmentId = addEquipment.getEquipmentIdByReferenceNo(refNo);
			
			System.out.println("--> IN EDIT EQUIPMENT 1");

			PcbSample findAvailablePcbSample = addSample
					.findSampleByEquipmentId(equipmentId);
			PcbCondition findAvailablePcbCondition = addCondition
					.findConditionByEquipmentId(equipmentId);
			PcbLocation findAvailablePcbLocation = addLocation
					.findLocationByEquipmentId(equipmentId);
			System.out.println("--> IN EDIT EQUIPMENT 2");


			// SET equipmentId for PcbSample, PcbCondition and PcbLocation
			pcbModel.getPcbSample().setEquipmentId(equipmentId);
			pcbModel.getPcbCondition().setEquipmentId(equipmentId);
			pcbModel.getPcbLocation().setEquipmentId(equipmentId);
			System.out.println("--> IN EDIT EQUIPMENT 3");

			// UPDATE PcbEquipment
			if (pcbModel.getPcbEquipment() != null) {
				System.out.println("--> IN EDIT EQUIPMENT 3.1");

				try {
					
					//pcbModel.getPcbEquipment().setEquipmentId(equipmentId);
					resultobjE = addEquipment.updateEquipment(pcbModel.getPcbEquipment());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				success += "Equipment Updated.. ";
			}
			System.out.println("--> IN EDIT EQUIPMENT 4");

			// ADD PcbSample
			if (findAvailablePcbSample == null) {
				resultobjS = addSample.addSample(pcbModel.getPcbSample());
				success += "Sample Added.. ";
			}
			// UPDATE PcbSample
			else {
				resultobjS = addSample.updateSample(pcbModel.getPcbSample());
				success += "Sample Updated.. ";
			}
			System.out.println("--> IN EDIT EQUIPMENT 5");

			// ADD PcbCondition
			if (findAvailablePcbCondition == null) {
				resultobjC = addCondition.addCondition(pcbModel
						.getPcbCondition());
				success += "Condition Added.. ";
			}
			// UPDATE PcbCondition
			else {
				resultobjC = addCondition.updateCondition(pcbModel
						.getPcbCondition());
				success += "Condition Updated.. ";
			}

			// ADD PcbLocation
			if (findAvailablePcbLocation == null) {
				resultobjL = addLocation.addLocation(pcbModel.getPcbLocation());
				success += "Location Added.. ";
			}
			// UPDATE PcbLocation
			else {
				resultobjL = addLocation.updateLocation(pcbModel
						.getPcbLocation());
				success += "Location Updated.. ";
			}
			System.out.println("--> IN EDIT EQUIPMENT 6");

			System.out.println(success);
			
			String refNoNext = pcbModel.getPcbEquipment().getReferenceNo();
			int seq = 0;
			try {
				seq = refNoNext.indexOf("-");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("char:1 " + seq);
			
			refNoNext = refNoNext.substring(seq+1);

			System.out.println("sequence1: " + refNoNext);

			Integer i = new Integer(0);

			i = Integer.parseInt(refNoNext) + 1;

			refNoNext = i.toString();

			System.out.println("refNo: " + refNoNext);
			
			if (refNoNext.length() == 1){
				System.out.println("sequence3: " + refNoNext);
				refNoNext ="0000" + refNoNext;
			}
			else if (refNoNext.length() == 2){
				System.out.println("sequence4: " + refNoNext);
				refNoNext = "000" + refNoNext;
			}
			else if (refNoNext.length() == 3){
				System.out.println("sequence5: " + refNoNext);
				refNoNext = "00" + refNoNext;
			}
			else if (refNoNext.length() == 4){
				System.out.println("sequence6: " + refNoNext);
				refNoNext = "0" + refNoNext;
			}
			else{
				refNoNext = refNoNext;
			}
			
			String firstPart = pcbModel.getPcbEquipment().getReferenceNo().substring(0, seq+1);
		
			System.out.println("firstPart: " + firstPart);
			
			String nextRefNo = firstPart + refNoNext;
			
			System.out.println("nextRefNo: " + nextRefNo);
			
			obj.getPcbEquipment().setReferenceNo(nextRefNo);
			
			

			mo = new ModelAndView("editEquipment", "EditEquipment", obj);
			submitType = "search";
			mo.addObject("submitType", submitType);
		}

		mo.addObject("success", success);
		return mo;
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/MMSaddEquipmentSamleNo", method = RequestMethod.POST)
	public ModelAndView MMSaddEquipmentSamleNo(
			@ModelAttribute("EditEquipment") PcbModel pcbModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("--> IN /MMSaddEquipment");

		System.out.println(" referenceNo: "
				+ pcbModel.getPcbEquipment().getReferenceNo());
		System.out.println(" divison: "
				+ pcbModel.getPcbEquipment().getDivison());
		System.out
				.println(" branch: " + pcbModel.getPcbEquipment().getBranch());
		System.out.println(" unit: " + pcbModel.getPcbEquipment().getUnit());
		System.out.println(" condition: "
				+ pcbModel.getPcbEquipment().getCondition());
		System.out.println(" photoRef: "
				+ pcbModel.getPcbEquipment().getPhotoRef());
		System.out.println(" weightTransformer: "
				+ pcbModel.getPcbEquipment().getWeightTransformer());
		System.out.println(" volumeOfOil: "
				+ pcbModel.getPcbEquipment().getVolumeOfOil());
		System.out.println(" oilWeight: "
				+ pcbModel.getPcbEquipment().getOilWeight());
		System.out.println(" capacity: "
				+ pcbModel.getPcbEquipment().getCapacity());
		System.out.println(" voltage: "
				+ pcbModel.getPcbEquipment().getVoltage());
		System.out.println(" serialNo: "
				+ pcbModel.getPcbEquipment().getSerialNo());
		System.out.println(" manufactureBrand: "
				+ pcbModel.getPcbEquipment().getManufactureBrand());
		System.out.println(" photoTaken: "
				+ pcbModel.getPcbEquipment().getPhotoTaken());
		System.out.println(" equipmentId: "
				+ pcbModel.getPcbEquipment().getEquipmentId());
		System.out.println(" primarySub: "
				+ pcbModel.getPcbEquipment().getPrimarySub());
		System.out.println(" manufactureLtl: "
				+ pcbModel.getPcbEquipment().getManufactureLtl());
		System.out.println(" type: " + pcbModel.getPcbEquipment().getType());
		System.out.println(" seriaType: "
				+ pcbModel.getPcbEquipment().getSeriaType());
		System.out.println(" manufactureDate: "
				+ pcbModel.getPcbEquipment().getManufactureDate());

		String message = "Welcome to Spring 4.0 !";

		PcbEquipment objEx = new PcbEquipment();
		
		if (pcbModel.getPcbSample().getSamplingNu() == null) {
			objEx = null;
		} else {
			System.out.println("test test " + pcbModel.getPcbSample().getSamplingNu());

			String equId = addEquipment.getEquipmentIdBySampleNo(pcbModel.getPcbSample().getSamplingNu());
			System.out.println("test test 1 " + equId);

			objEx = addEquipment.findEquipmentByEquipmentId(equId);
			System.out.println("test test 2 " + objEx);

			
		}

		String resultobjE = "";
		String resultobjS = "";
		String resultobjC = "";
		String resultobjL = "";
		String success = "";
		String submitType = "";
		PcbModel obj = new PcbModel();
		ModelAndView mo = new ModelAndView("editEquipmentSampleNo", "EditEquipment",
				obj);

		// for add equipment
		if (objEx == null) {
			System.out.println("--> IN ADD EQUIPMENT");

			String sequence = addEquipment.getNextEquipmentId(pcbModel
					.getPcbEquipment().getType());
			System.out.println("equipmentId: "
					+ pcbModel.getPcbEquipment().getType() + "_" + sequence);

			String equipmentId = pcbModel.getPcbEquipment().getType() + "_"
					+ sequence;
			pcbModel.getPcbEquipment().setEquipmentId(equipmentId);
			pcbModel.getPcbSample().setEquipmentId(equipmentId);
			pcbModel.getPcbCondition().setEquipmentId(equipmentId);
			pcbModel.getPcbLocation().setEquipmentId(equipmentId);

			resultobjE = addEquipment.addEquipment(pcbModel.getPcbEquipment());
			success += "Equipment Added.. ";

			resultobjS = addSample.addSample(pcbModel.getPcbSample());
			success += "Sample Added.. ";

			resultobjC = addCondition.addCondition(pcbModel.getPcbCondition());
			success += "Condition Added.. ";

			resultobjL = addLocation.addLocation(pcbModel.getPcbLocation());
			success += "Location Added.. ";

			mo = new ModelAndView("editEquipmentSampleNo", "EditEquipment", obj);
		}

		// for update equipment
		else {
			System.out.println("--> IN EDIT EQUIPMENT");

			String equipmentId = pcbModel.getPcbEquipment().getEquipmentId();
			System.out.println("--> IN EDIT EQUIPMENTequipmentId" +equipmentId );

			PcbSample findAvailablePcbSample = addSample
					.findSampleByEquipmentId(equipmentId);
			PcbCondition findAvailablePcbCondition = addCondition
					.findConditionByEquipmentId(equipmentId);
			PcbLocation findAvailablePcbLocation = addLocation
					.findLocationByEquipmentId(equipmentId);

			// SET equipmentId for PcbSample, PcbCondition and PcbLocation
			pcbModel.getPcbSample().setEquipmentId(equipmentId);
			pcbModel.getPcbCondition().setEquipmentId(equipmentId);
			pcbModel.getPcbLocation().setEquipmentId(equipmentId);

			// UPDATE PcbEquipment
			if (pcbModel.getPcbEquipment() != null) {
				resultobjE = addEquipment.updateEquipment(pcbModel
						.getPcbEquipment());
				success += "Equipment Updated.. ";
			}

			// ADD PcbSample
			if (findAvailablePcbSample == null) {
				resultobjS = addSample.addSample(pcbModel.getPcbSample());
				success += "Sample Added.. ";
			}
			// UPDATE PcbSample
			else {
				resultobjS = addSample.updateSample(pcbModel.getPcbSample());
				success += "Sample Updated.. ";
			}

			// ADD PcbCondition
			if (findAvailablePcbCondition == null) {
				resultobjC = addCondition.addCondition(pcbModel
						.getPcbCondition());
				success += "Condition Added.. ";
			}
			// UPDATE PcbCondition
			else {
				resultobjC = addCondition.updateCondition(pcbModel
						.getPcbCondition());
				success += "Condition Updated.. ";
			}

			// ADD PcbLocation
			if (findAvailablePcbLocation == null) {
				resultobjL = addLocation.addLocation(pcbModel.getPcbLocation());
				success += "Location Added.. ";
			}
			// UPDATE PcbLocation
			else {
				resultobjL = addLocation.updateLocation(pcbModel
						.getPcbLocation());
				success += "Location Updated.. ";
			}
			System.out.println(success);
			
			
			

			mo = new ModelAndView("editEquipmentSampleNo", "EditEquipment", obj);
			submitType = "search";
			mo.addObject("submitType", submitType);
		}

		mo.addObject("success", success);
		return mo;
	}

	
	
	
	@RequestMapping(value = "/addPCBMobile", method = RequestMethod.POST)
	public ModelAndView addPCBMobile(
			@RequestBody PcbModel pcbModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("--> IN /MMSaddEquipment");

		System.out.println(" referenceNo: "
				+ pcbModel.getPcbEquipment().getReferenceNo());
		System.out.println(" divison: "
				+ pcbModel.getPcbEquipment().getDivison());
		System.out
				.println(" branch: " + pcbModel.getPcbEquipment().getBranch());
		System.out.println(" unit: " + pcbModel.getPcbEquipment().getUnit());
		System.out.println(" condition: "
				+ pcbModel.getPcbEquipment().getCondition());
		System.out.println(" photoRef: "
				+ pcbModel.getPcbEquipment().getPhotoRef());
		System.out.println(" weightTransformer: "
				+ pcbModel.getPcbEquipment().getWeightTransformer());
		System.out.println(" volumeOfOil: "
				+ pcbModel.getPcbEquipment().getVolumeOfOil());
		System.out.println(" oilWeight: "
				+ pcbModel.getPcbEquipment().getOilWeight());
		System.out.println(" capacity: "
				+ pcbModel.getPcbEquipment().getCapacity());
		System.out.println(" voltage: "
				+ pcbModel.getPcbEquipment().getVoltage());
		System.out.println(" serialNo: "
				+ pcbModel.getPcbEquipment().getSerialNo());
		System.out.println(" manufactureBrand: "
				+ pcbModel.getPcbEquipment().getManufactureBrand());
		System.out.println(" photoTaken: "
				+ pcbModel.getPcbEquipment().getPhotoTaken());
		System.out.println(" equipmentId: "
				+ pcbModel.getPcbEquipment().getEquipmentId());
		System.out.println(" primarySub: "
				+ pcbModel.getPcbEquipment().getPrimarySub());
		System.out.println(" manufactureLtl: "
				+ pcbModel.getPcbEquipment().getManufactureLtl());
		System.out.println(" type: " + pcbModel.getPcbEquipment().getType());
		System.out.println(" seriaType: "
				+ pcbModel.getPcbEquipment().getSeriaType());
		System.out.println(" manufactureDate: "
				+ pcbModel.getPcbEquipment().getManufactureDate());

		String message = "Welcome to Spring 4.0 !";

		PcbEquipment objEx = new PcbEquipment();
		if (pcbModel.getPcbEquipment().getEquipmentId() == null) {
			objEx = null;
		} else {
			objEx = addEquipment.findEquipmentByEquipmentId(pcbModel
					.getPcbEquipment().getEquipmentId());
		}

		String resultobjE = "";
		String resultobjS = "";
		String resultobjC = "";
		String resultobjL = "";
		String success = "";
		String submitType = "";
		PcbModel obj = new PcbModel();
		ModelAndView mo = new ModelAndView("MMS_addEquipment", "SaveEquipment",
				obj);

		// for add equipment
		if (objEx == null) {
			System.out.println("--> IN ADD EQUIPMENT");

			String sequence = addEquipment.getNextEquipmentId(pcbModel
					.getPcbEquipment().getType());
			System.out.println("equipmentId: "
					+ pcbModel.getPcbEquipment().getType() + "_" + sequence);

			String equipmentId = pcbModel.getPcbEquipment().getType() + "_"
					+ sequence;
			pcbModel.getPcbEquipment().setEquipmentId(equipmentId);
			pcbModel.getPcbSample().setEquipmentId(equipmentId);
			pcbModel.getPcbCondition().setEquipmentId(equipmentId);
			pcbModel.getPcbLocation().setEquipmentId(equipmentId);

			resultobjE = addEquipment.addEquipment(pcbModel.getPcbEquipment());
			success += "Equipment Added.. ";

			resultobjS = addSample.addSample(pcbModel.getPcbSample());
			success += "Sample Added.. ";

			resultobjC = addCondition.addCondition(pcbModel.getPcbCondition());
			success += "Condition Added.. ";

			resultobjL = addLocation.addLocation(pcbModel.getPcbLocation());
			success += "Location Added.. ";

			mo = new ModelAndView("MMS_addEquipment", "SaveEquipment", obj);
		}

		// for update equipment
		else {
			System.out.println("--> IN EDIT EQUIPMENT");

			String equipmentId = pcbModel.getPcbEquipment().getEquipmentId();
			PcbSample findAvailablePcbSample = addSample
					.findSampleByEquipmentId(equipmentId);
			PcbCondition findAvailablePcbCondition = addCondition
					.findConditionByEquipmentId(equipmentId);
			PcbLocation findAvailablePcbLocation = addLocation
					.findLocationByEquipmentId(equipmentId);

			// SET equipmentId for PcbSample, PcbCondition and PcbLocation
			pcbModel.getPcbSample().setEquipmentId(equipmentId);
			pcbModel.getPcbCondition().setEquipmentId(equipmentId);
			pcbModel.getPcbLocation().setEquipmentId(equipmentId);

			// UPDATE PcbEquipment
			if (pcbModel.getPcbEquipment() != null) {
				resultobjE = addEquipment.updateEquipment(pcbModel
						.getPcbEquipment());
				success += "Equipment Updated.. ";
			}

			// ADD PcbSample
			if (findAvailablePcbSample == null) {
				resultobjS = addSample.addSample(pcbModel.getPcbSample());
				success += "Sample Added.. ";
			}
			// UPDATE PcbSample
			else {
				resultobjS = addSample.updateSample(pcbModel.getPcbSample());
				success += "Sample Updated.. ";
			}

			// ADD PcbCondition
			if (findAvailablePcbCondition == null) {
				resultobjC = addCondition.addCondition(pcbModel
						.getPcbCondition());
				success += "Condition Added.. ";
			}
			// UPDATE PcbCondition
			else {
				resultobjC = addCondition.updateCondition(pcbModel
						.getPcbCondition());
				success += "Condition Updated.. ";
			}

			// ADD PcbLocation
			if (findAvailablePcbLocation == null) {
				resultobjL = addLocation.addLocation(pcbModel.getPcbLocation());
				success += "Location Added.. ";
			}
			// UPDATE PcbLocation
			else {
				resultobjL = addLocation.updateLocation(pcbModel
						.getPcbLocation());
				success += "Location Updated.. ";
			}
			System.out.println(success);

			mo = new ModelAndView("editEquipment", "EditEquipment", obj);
			submitType = "search";
			mo.addObject("submitType", submitType);
		}

		mo.addObject("success", success);
		return mo;
	}

	
	@RequestMapping(value = "/addEquipment", method = RequestMethod.GET)
	public ModelAndView MMSaddEquipment(
			@ModelAttribute("SaveEquipment") PcbModel pcbModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("--> IN /addEquipment");

		pcbModel = new PcbModel();
		
        List<Glcompm> compList = compDao.getDisDivision();
		
		//pcbModel.setDivisionList(divisionList);
		//pcbModel.setCompList(compList);
		Map<String,String> divListTem = new LinkedHashMap<String,String>();
		
		int depLoop = compList.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			Glcompm ojb = (Glcompm) compList.get(i);
			System.out.println(i + " " +ojb.getCompNm() );
			
			divListTem.put(ojb.getCompId(), ojb.getCompNm());
		}
		
		pcbModel.setDivList(divListTem);
		
		
		

		// get and set list of divisions
		//List<PCB_Division> divisionList = divisionDao.getAll();
		//pcbModel.setDivisionList(divisionList);

		return new ModelAndView("MMS_addEquipment", "SaveEquipment", pcbModel);

	}

	@RequestMapping(value = "/getAllDivision", method = RequestMethod.GET)
	public @ResponseBody List<PCB_Division> getAllDivision() throws Exception {
		return divisionDao.getAll();

	}
	
	/*@RequestMapping(value = "/uploadFormLine", method = RequestMethod.GET)
	public ModelAndView uploadFormLine(HttpServletRequest request) {
		//return "upload";
		//ModelAndView modelV = new ModelAndView();
		PivModel model = new PivModel();
		//model.setViewName("UploadTowerMaintenance","model",model);
		ModelAndView mm = new ModelAndView("UploadLine" ,"model",model);
		
		return mm;
		//return "UploadTowerMaintenance";
	}
	
	@RequestMapping(value = "/uploadMNT", method = RequestMethod.POST)
	public ModelAndView uploadMNT(HttpServletRequest request,@RequestParam("file") MultipartFile file,@ModelAttribute("pivModel") PivModel pivModel){
		
		System.out.println("test");
		String name = ""; 
		String mode = "";
		String ss="";
		String cycle =pivModel.getCycle();
		String deptId = request.getSession().getAttribute("deptId").toString();
		if (!file.isEmpty()) {
			try {
				name = file.getOriginalFilename();
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				
				//System.out.println("test1");

                String tNo="";
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				
				//System.out.println("test11");
				stream.write(bytes);
				stream.close();
				FileInputStream fileExcel = new FileInputStream(serverFile);
	            
			    XSSFWorkbook workbook = new XSSFWorkbook(fileExcel);
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            List<MmsTxntowermaintenance> objLineList = new ArrayList<MmsTxntowermaintenance>();
	            MmsTxntowermaintenance obj = new MmsTxntowermaintenance();
	            MmsTxntowermaintenancePK objPK = new MmsTxntowermaintenancePK();
	    		//MmsTowermaintenancePK objPK = new MmsTowermaintenancePK();
	    		Map<Integer,String> lineHashMap = new LinkedHashMap<Integer,String>();
	    		MmsTxntowermaintenance objExisting = new MmsTxntowermaintenance();
	    		Iterator<Row> rowIterator = sheet.iterator();
	    		//rowIterator.
	            rowIterator.next();
	            while(rowIterator.hasNext())
	            {
	                Row row = rowIterator.next();
	                //For each row, iterate through each columns
	                Iterator<Cell> cellIterator = row.cellIterator();
	                int i=0;
	                while(cellIterator.hasNext())
	                {
	                    
	                	
	                	String towerNo ="";
	                	String tappings ="";
	                	String missingParts ="";
	                	String flashOverSets ="";
	                	String maintenanceDate="";
	                	String wayLeaving="";
	                	String baseConcrete="";
	                	String antiClimbing="";	                	
	                	String conductorCondition="";
	                	String jumperCondition="";
	                	String earthConductorCondition="";
	                	String maintainaceAttention="";
	                	String fungussSetno="";
	                	String wpinset="";
	                	String endfittingSet="";
	                	String towerspecial="";
	                	String legPainting="";
	                	
	                	Cell cell = cellIterator.next();
	                	
	                	//i++;
	                	
	                	//This will change all Cell Types to String
	                    cell.setCellType(Cell.CELL_TYPE_STRING);
	                    switch(cell.getCellType()) 
	                    {
	                        case Cell.CELL_TYPE_BOOLEAN:
	                            System.out.println("boolean===>>>"+cell.getBooleanCellValue() + "\t");
	                            break;
	                        case Cell.CELL_TYPE_NUMERIC:

	                            break;
	                        case Cell.CELL_TYPE_STRING:
	                        	
	                        	
	    	                	 if(i==0){
	    	                		towerNo =  cell.getStringCellValue();
	    	                		tNo=towerNo;
	    	                		String towerId = addSupportDao.getTowerIDByTowerNo(towerNo);
	    	                		if(towerId.equals("N")){
	    	                			mode ="Tower number is not in the system " +towerNo ;
	    	                		}
		    	                	try{
		    	                		objPK.setTowerid(new Long(towerId));
		    	                	 }catch(Exception e){
		    	                		 mode ="Tower number is not in the system " +towerNo ;
		    	                	 }
		    	                		objPK.setVisitid(new Long(cycle));
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerNo : " + towerNo + " objC :"  );
	    		                    
	    	                	}
	    	                	else if(i==1){
	    	                		tappings =  cell.getStringCellValue();
	    	                		objExisting.setNooftappings(new BigDecimal(tappings));
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "tappings : " + tappings + " objN :" );
	    		                    
	    	                	}
	    	                	
	    	                	else if(i==2){
	    	                		missingParts =  cell.getStringCellValue();
	    	                		objExisting.setNoofmissingparts(new BigDecimal(missingParts));
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "missingParts : " + missingParts + " objNd :"  );
	    		                    
	    	                	}
	    	                	else if(i==3){
	    	                		flashOverSets =  cell.getStringCellValue();
	    	                		objExisting.setNofflashoversets(new BigDecimal(flashOverSets));
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "flashOverSets : " + flashOverSets + " objNc :" );
	    	                		System.out.println("hey");
	    	                	}
	    	                	else if(i==4){
	    	                		maintenanceDate =  cell.getStringCellValue();
	    	                		DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
	    	                		java.util.Date date = format.parse(maintenanceDate);

	    	                		objExisting.setMaintenancedate(date);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "maintenanceDate : " + maintenanceDate + " objNd :"  );
	    		                   
	    	                	}
	    	                	else if(i==5){
	    	                		wayLeaving =  cell.getStringCellValue();
	    	                		objExisting.setWayleavestatus(wayLeaving);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "wayLeaving : " + wayLeaving + " objNd :"  );
	    		                    
	    	                	}
	    	                	else if(i==6){
	    	                		baseConcrete =  cell.getStringCellValue();
	    	                		objExisting.setBaseconcretestatus(baseConcrete);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "baseConcrete : " + baseConcrete + " objNd :"  );
	    		                    
	    	                	}
	    	                	else if(i==7){
	    	                		antiClimbing =  cell.getStringCellValue();
	    	                		objExisting.setAnticlimbingstatus(antiClimbing);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "antiClimbing : " + antiClimbing + " objNd :"  );
	    		                    
	    	                	}
	    	                	else if(i==8){
	    	                		conductorCondition =  cell.getStringCellValue();
	    	                		objExisting.setConductorstatus(conductorCondition);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "conductorCondition : " + conductorCondition + " objNd :"  );
	    		                    
	    	                	}
	    	                	else if(i==9){
	    	                		jumperCondition =  cell.getStringCellValue();
	    	                		objExisting.setJumperstatus(jumperCondition);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "jumperCondition : " + jumperCondition + " objNd :" );
	    		                    
	    	                	}
	    	                	else if(i==10){
	    	                		earthConductorCondition =  cell.getStringCellValue();
	    	                		objExisting.setEarthconductorstatus(earthConductorCondition);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "earthConductorCondition : " + earthConductorCondition + " objNd :"  );
	    		                    
	    	                	}
	    	                	else if(i==11){
	    	                		maintainaceAttention =  cell.getStringCellValue();
	    	                		objExisting.setAttentionstatus(maintainaceAttention);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "maintainaceAttention : " + maintainaceAttention + " objNd :"  );
	    		                    
	    	                	}
	    	                	else if(i==12){
	    	                		fungussSetno =  cell.getStringCellValue();
	    	                		objExisting.setFungussetno(new BigDecimal(fungussSetno));
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "fungussSetno : " + fungussSetno + " objNd :"  );
	    		                    
	    	                	}
	    	                	else if(i==13){
	    	                		wpinset =  cell.getStringCellValue();
	    	                		objExisting.setWpinset(new BigDecimal(wpinset));
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "wpinset : " + wpinset + " objNd :" +objExisting.getWpinset() );
	    		                    
	    	                	}
	    	                	else if(i==14){
	    	                		endfittingSet =  cell.getStringCellValue();
	    	                		objExisting.setEndfittingset(new BigDecimal(endfittingSet));
	    	                	//	System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "endfittingSet : " + endfittingSet + " objNd :"  );
	    		                    
	    	                	}
	    	                	else if(i==15){
	    	                		towerspecial =  cell.getStringCellValue();
	    	                		objExisting.setTowerspecial(towerspecial);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getTowerspecial() );
	    		                    
	    	                	}
	    	                	else if(i==16){
	    	                		legPainting =  cell.getStringCellValue();
	    	                		objExisting.setLegPainting(legPainting);;
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getLegPainting() );
	    		                    
	    	                	}
	    	                	else if(i==17){
	    	                		String hotPossible =  cell.getStringCellValue();
	    	                		hotPossible = hotPossible.trim();
	    	                		if(hotPossible.equals("Possible")){
	    	                			obj.setHotpossible(new BigDecimal("1"));
	    	                		}else{
	    	                			obj.setHotpossible(new BigDecimal("0"));
	    	                			
	    	                		}
	    	                		//objExisting.setHotpossible(new BigDecimal(hotPossible));
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getLegPainting() );
	    		                    
	    	                	}else if(i==18){
	    	                		String noOfPinPole1 =  cell.getStringCellValue();
	    	                		objExisting.setPinpole1(new BigDecimal(noOfPinPole1));
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getLegPainting() );
	    		                    
	    	                	}else if(i==19){
	    	                		String typeOfSw1 =  cell.getStringCellValue();
	    	                		objExisting.setSwitchdev1(typeOfSw1);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getLegPainting() );
	    		                    
	    	                	}else if(i==20){
	    	                		String noOfPinPole2 =  cell.getStringCellValue();
	    	                		objExisting.setPinpole2(new BigDecimal(noOfPinPole2));
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getLegPainting() );
	    		                    
	    	                	}else if(i==21){
	    	                		String typeOfSw2 =  cell.getStringCellValue();
	    	                		objExisting.setSwitchdev2(typeOfSw2);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getLegPainting() );
	    		                    
	    	                	}else if(i==22){
	    	                		String noOfPinPole3 =  cell.getStringCellValue();
	    	                		objExisting.setPinpole3(new BigDecimal(noOfPinPole3));
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getLegPainting() );
	    		                    
	    	                	}else if(i==23){
	    	                		String typeOfSw3 =  cell.getStringCellValue();
	    	                		objExisting.setSwitchdev3(typeOfSw3);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "towerspecial : " + towerspecial + " objNd :" +objExisting.getLegPainting() );
	    		                    
	    	                	}
	    	                	
	    	                	else{
	    	                		
	    	                	}
	                        	//System.out.println("hh : " + cell.getStringCellValue());
	                        	//lineHashMap.put(i, cell.getStringCellValue());
	                        	System.out.println("else end no : " + i);
	    	                	
	                        	i++;
	                        	System.out.println("else end no after : " + i);
	    	                	   
	                        	                                break;
	                        	                                
	                    }//end switch
	                   // MmsTowermaintenanceDao.towermaintenance(objExisting);
	                   
	                 }//end while cell iterator
	                
	                //objExisting.setPhmBranch(deptId);
	                MmsTxntowermaintenance dd = towerTxtMaintenance.findByID(objPK);
	                
	                objExisting.setId(objPK);
	                objExisting.setStatus(new BigDecimal("2"));
	                
	                if(dd ==null){
	                	towerTxtMaintenance.addTowerMaintananceData(objExisting);
	                }else{
	                	//ss="Already in the System Tower No :" + tNo + " Tower ID :" +objExisting.getId().getTowerid() ;
	                	//ss ="/" + ss;
	                	towerTxtMaintenance.update(objExisting);
	                }
	               // towerTxtMaintenance.addTowerMaintananceData(objExisting);
	                objExisting = new MmsTxntowermaintenance();
	                System.out.println("save obj");
	                
	                //objLineList.add(objExisting);
	                System.out.println("test4");
	                //objExisting.setPhmBranch(deptId);
	                //objExisting.setStatus(new BigDecimal("2"));
	                System.out.println("end save obj1");
	               // MmsTowermaintenance.towermaintenance(objExisting);
	               // objExisting = new MmsTowermaintenance();
	                System.out.println("save obj2");
	               // try{
	                //}catch(Exception e){
	                	//System.out.println("end save obj : error "+ e);
		                
	                //}
	                System.out.println("end save obj");
	                
	            }
				fileExcel.close();
				System.out.println("Server File Location="
						+ serverFile.getAbsolutePath());
				
				mode ="You successfully uploaded file " + name;
				

				//return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				mode ="You failed to upload " + name + " => " +ss + e.getMessage();
			}
		} else {
			mode ="You failed to upload " + name + " because the file was empty.";
		}
		PivModel objpiv = new PivModel();
		objpiv.setMode(mode);
		return new ModelAndView("MNTUpload" ,"model",objpiv);
	}
*/
	
	
	@RequestMapping(value = "/uploadEquipment", method = RequestMethod.GET)
	public ModelAndView uploadEquipment(HttpServletRequest request) {
		//return "upload";
		//ModelAndView modelV = new ModelAndView();
		PcbModel model = new PcbModel();
		
        List<Glcompm> compList = compDao.getDisDivision();
		
		//pcbModel.setDivisionList(divisionList);
		//pcbModel.setCompList(compList);
		Map<String,String> divListTem = new LinkedHashMap<String,String>();
		
		int depLoop = compList.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			Glcompm ojb = (Glcompm) compList.get(i);
			System.out.println(i + " " +ojb.getCompNm() );
			
			divListTem.put(ojb.getCompId(), ojb.getCompNm());
		}
		
		model.setDivList(divListTem);
		
		//model.setViewName("UploadTowerMaintenance","model",model);
		ModelAndView mm = new ModelAndView("uploadEquipment" ,"model",model);
		
		return mm;
		//return "UploadTowerMaintenance";
	}
	
	@RequestMapping(value = "/uploadEquipmentGPS", method = RequestMethod.GET)
	public ModelAndView uploadEquipmentGPS(HttpServletRequest request) {
		//return "upload";
		//ModelAndView modelV = new ModelAndView();
		PcbModel model = new PcbModel();
		
        List<Glcompm> compList = compDao.getDisDivision();
		
		//pcbModel.setDivisionList(divisionList);
		//pcbModel.setCompList(compList);
		Map<String,String> divListTem = new LinkedHashMap<String,String>();
		
		int depLoop = compList.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			Glcompm ojb = (Glcompm) compList.get(i);
			System.out.println(i + " " +ojb.getCompNm() );
			
			divListTem.put(ojb.getCompId(), ojb.getCompNm());
		}
		
		model.setDivList(divListTem);
		
		//model.setViewName("UploadTowerMaintenance","model",model);
		ModelAndView mm = new ModelAndView("uploadEquipmentGPS" ,"model",model);
		
		return mm;
		//return "UploadTowerMaintenance";
	}
	
	
	@RequestMapping(value = "/uploadEquipmentSINNO", method = RequestMethod.GET)
	public ModelAndView uploadEquipmentSINNO(HttpServletRequest request) {
		//return "upload";
		//ModelAndView modelV = new ModelAndView();
		PcbModel model = new PcbModel();
		
        List<Glcompm> compList = compDao.getDisDivision();
		
		//pcbModel.setDivisionList(divisionList);
		//pcbModel.setCompList(compList);
		Map<String,String> divListTem = new LinkedHashMap<String,String>();
		
		int depLoop = compList.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			Glcompm ojb = (Glcompm) compList.get(i);
			System.out.println(i + " " +ojb.getCompNm() );
			
			divListTem.put(ojb.getCompId(), ojb.getCompNm());
		}
		
		model.setDivList(divListTem);
		
		//model.setViewName("UploadTowerMaintenance","model",model);
		ModelAndView mm = new ModelAndView("uploadEquipmentSinNo" ,"model",model);
		
		return mm;
		//return "UploadTowerMaintenance";
	}
	
	
	
	@RequestMapping(value = "/saveExcelDataEquipment", method = RequestMethod.POST)
	public ModelAndView saveExcelDataEquipment(HttpServletRequest request,@RequestParam("file") MultipartFile file,@ModelAttribute("pcbModel") PcbModel pcbModel){
		
		System.out.println("test");
		String name = ""; 
		String mode = "";
		String ss="";
		
		String deptId = request.getSession().getAttribute("deptId").toString();
		if (!file.isEmpty()) {
			try {
				name = file.getOriginalFilename();
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				
				//System.out.println("test1");

                String tNo="";
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				
				//System.out.println("test11");
				stream.write(bytes);
				stream.close();
				FileInputStream fileExcel = new FileInputStream(serverFile);
	            
			    XSSFWorkbook workbook = new XSSFWorkbook(fileExcel);
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            
	            List<PcbModel> objEquipmentList = new ArrayList<PcbModel>();
	            PcbModel obj = new PcbModel();
	           
	    		Map<Integer,String> lineHashMap = new LinkedHashMap<Integer,String>();
	    		Iterator<Row> rowIterator = sheet.iterator();
	    		
	    			PcbEquipment pcbEuipments = new PcbEquipment();
	    			PcbLocation pcbLocation = new PcbLocation();
	    			PcbCondition pcbCondition = new PcbCondition();
	    			PcbSample pcbSample = new PcbSample();
            	
	    		//rowIterator.
	            rowIterator.next();
	            while(rowIterator.hasNext())
	            {
	                Row row = rowIterator.next();
	                //For each row, iterate through each columns
	                Iterator<Cell> cellIterator = row.cellIterator();
	                int i=0;
	                while(cellIterator.hasNext())
	                {
	                 
	                	String reference ="";
	                	String division ="";
	                	String area ="";
	                	String branch ="";
	                	String unit="";
	                	String condition="";
	                	String GPSlocation_Longitude="";
	                	String GPSlocation_Latitude="";	                	
	                	String locationDescription="";
	                	String typeofLocated="";
	                	String mounting="";
	                	String yearofManufacture="";
	                	String type="";
	                	String manufactureLTL="";
	                	String primarySub="";
	                	String manufactureBarnd="";
	                	String samplingPort="";
	                	String extractedfromtop="";
	                	String samplingLogicSatisfied="";
	                	String sampleNo="";
	                	String samplDate="";
	                	String identificationNo="";
	                	String serialNo="";
	                	String voltage="";
	                	String capacity ="";
	                	String weightofTransformer="";
	                	String oilWeight ="";
	                	String volumeofOil ="";
	                	String photoTaken ="";
	                	String photoRef="";
	                	String oilLeaksPresent ="";
	                	String corrosion="";
	                	String burnMarks="";
	                	String terminalNeedattention="";
	                	String earthingConnection="";
	                	String breatherCondition ="";
	                	String overloaSignsPresent ="";
	                	String lightingArresters="";
	                	String remarks="";
	                	String EPFNumbersofthegroup="";
	                	String PCBTestResults="";
	                	String PCBTestdate="";
	                	String EPFNumbersoftheTestGroup="";
	                	
	                	Cell cell = cellIterator.next();
	                
	                	//Area
	                	//identification No
	                
	                	//This will change all Cell Types to String
	                    cell.setCellType(Cell.CELL_TYPE_STRING);
	                    switch(cell.getCellType()) 
	                    {
	                        case Cell.CELL_TYPE_BOOLEAN:
	                            System.out.println("boolean===>>>"+cell.getBooleanCellValue() + "\t");
	                            break;
	                        case Cell.CELL_TYPE_NUMERIC:

	                            break;
	                        case Cell.CELL_TYPE_STRING:
	                        	
	                        	
	                        	if(i==0){
	                        		reference =  cell.getStringCellValue();
	                        		pcbEuipments.setReferenceNo(reference);
		    	                	System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Reference : " + reference);
			    	            }

	    	                	else if(i==1){
	    	                		division =  cell.getStringCellValue();	  
	    	                		pcbEuipments.setDivison(division);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Division : " + division);
	    	                	}
	    	                	
	    	                	else if(i==2){
	    	                		area  =  cell.getStringCellValue();
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Area : " + area);
	    		                    
	    	                	}
	                        	 
	    	                	else if(i==3){
	    	                		branch  =  cell.getStringCellValue();
	    	                		pcbEuipments.setBranch(branch);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Branch  : " + branch);
	    	                	}
	                        	 
	    	                	else if(i==4){
	    	                		unit =  cell.getStringCellValue();
	    	                		pcbEuipments.setUnit(unit);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Unit : " + unit);
	    		                   
	    	                	}
	    	                	else if(i==5){
	    	                		condition =  cell.getStringCellValue();
	    	                		pcbEuipments.setCondition(condition);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Condition : " + condition);
	    		                    
	    	                	}
	    	                	else if(i==6){
	    	                		GPSlocation_Longitude =  cell.getStringCellValue();
	    	                		pcbLocation.setGpsLongitude(GPSlocation_Longitude);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "GPS location (Longitude) : " + GPSlocation_Longitude);
	    		                    
	    	                	}
	    	                	else if(i==7){
	    	                		GPSlocation_Latitude =  cell.getStringCellValue();
	    	                		pcbLocation.setGpsLatitude(GPSlocation_Latitude);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "GPS location (Latitude) : " + GPSlocation_Latitude);
	    		                    
	    	                	}
	    	                	else if(i==8){
	    	                		locationDescription =  cell.getStringCellValue();
	    	                		pcbLocation.setLocationDescription(locationDescription);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Location Description : " + locationDescription);
	    		                    
	    	                	} 

	    	                	else if(i==9){
	    	                		typeofLocated    =  cell.getStringCellValue();
	    	                		pcbLocation.setTypeOfLocated(typeofLocated);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Type of Located (Indoor/Outdoor) : " + typeofLocated);
	    		                    
	    	                	}
	    	                	else if(i==10){
	    	                		mounting =  cell.getStringCellValue();
	    	                		pcbLocation.setMounting(mounting);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Mounting (Pole/Plinth/Ground) : " + mounting);    
	    	                	
	    	                	}
	                        	 
	    	                	else if(i==11){
	    	                		yearofManufacture =  cell.getStringCellValue();
	    	                		//DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
	    	                		//java.util.Date date1 = format.parse(yearofManufacture);
	    	                		//java.sql.Date sqlStartDate1 = new java.sql.Date(date1.getTime());  
	    	                		//pcbEuipments.setManufactureDate(date1);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Year of Manufacture : " + yearofManufacture);
	    	        
	    	                	}
	                        	 
	    	                	else if(i==12){
	    	                		type =  cell.getStringCellValue();
	    	                		pcbEuipments.setType(type);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Type: (Seal /None-Seal) : " + type);
	    		                    
	    	                	}
	                        	 
	    	                	else if(i==13){
	    	                		manufactureLTL =  cell.getStringCellValue();
	    	                		pcbEuipments.setManufactureLtl(manufactureLTL);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Manufacture LTL? : " + manufactureLTL);
	    		                    
	    	                	}
	                        	 
	    	                	else if(i==14){
	    	                		primarySub =  cell.getStringCellValue();
	    	                		pcbEuipments.setPrimarySub(primarySub);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Primary Sub : " + primarySub);
	    		                    
	    	                	}
	                        	 
	    	                	else if(i==15){
	    	                		manufactureBarnd =  cell.getStringCellValue();
	    	                		pcbEuipments.setManufactureBrand(manufactureBarnd);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Manufacture Barnd  : " + manufactureBarnd);
	    		                    
	    	                	}
	                        	 
	    	                	else if(i==16){
	    	                		samplingPort =  cell.getStringCellValue();
	    	                		pcbSample.setSamplingPort(samplingPort);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Sampling Port : " + samplingPort);
	    		                    
	    	                	}
	                        	 
	    	                	else if(i==17){
	    	                		extractedfromtop =  cell.getStringCellValue();
	    	                		pcbSample.setExtractedTop(extractedfromtop);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Extracted from top : " + extractedfromtop);
	    		                    
	    	                	}
	    	                	
	    	                	else if(i==18){
	    	                		samplingLogicSatisfied =  cell.getStringCellValue();
	    	                		pcbSample.setSampleSatisified(samplingLogicSatisfied);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Sampling Logic Satisfied : " + samplingLogicSatisfied);
	    		                    
	    	                	}
	    	                	else if(i==19){
	    	                		sampleNo =  cell.getStringCellValue();
	    	                		pcbSample.setSamplingNu(sampleNo);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Sample Number : " + sampleNo);
	    	                	}
	    	                		
	    	                	else if(i==20){
	    	                		samplDate =  cell.getStringCellValue();	    	                		
	    	                		//DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
	    	                		//java.util.Date date2 = format.parse(samplDate);
	    	                		//pcbSample.setSampleDate(date2);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Sample Date : " + samplDate);
	    		                    
	    	                	}
	    	                		
	    	                	else if(i==21){
	    	                		identificationNo =  cell.getStringCellValue();
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Identification  No.(SIN) : " + identificationNo);
	    		                    
	    	                	}
	    	                		
	    	                	else if(i==22){
	    	                		serialNo =  cell.getStringCellValue();
	    	                		pcbEuipments.setSerialNo(serialNo);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Serial No : " + serialNo);
	    		                    
	    	                	}
	    	                	
	    	                	else if(i==23){
	    	                		voltage =  cell.getStringCellValue();
	    	                		pcbEuipments.setVoltage(new BigDecimal(voltage));
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "(Primary/Secondary)  Voltage (kV) : " + voltage);
	    	                	}
	    	                	
	    	                	else if(i==24){
	    	                		capacity  =  cell.getStringCellValue();
	    	                		pcbEuipments.setCapacity(new BigDecimal(capacity));
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Capacity (kVA) : " + capacity);
	    	                	}
	                        	
	    	                	else if(i==25){
	    	                		weightofTransformer =  cell.getStringCellValue();
	    	                		pcbEuipments.setWeightTransformer(new BigDecimal(weightofTransformer));
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Weight of Transformer : " + weightofTransformer);
	    	                	}
	                        	 
	    	                	else if(i==26){
	    	                		oilWeight  =  cell.getStringCellValue();
	    	                		pcbEuipments.setOilWeight(new BigDecimal(oilWeight));
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Oil Weight (Kg) : " + oilWeight);
	    	                	}
	                        	
	    	                	else if(i==27){
	    	                		volumeofOil   =  cell.getStringCellValue();
	    	                		pcbEuipments.setVolumeOfOil(volumeofOil);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Volume of Oil (L) : " + volumeofOil);
	    	                	}
	    	                	
	    	                	else if(i==28){
	    	                		photoTaken    =  cell.getStringCellValue();
	    	                		pcbEuipments.setPhotoTaken(photoTaken);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Photo Taken : " + photoTaken);
	    	                	}
	                        	
	    	                	else if(i==29){
	    	                		photoRef    =  cell.getStringCellValue();
	    	                		pcbEuipments.setPhotoRef(photoRef);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Photo Ref. : " + photoRef);
	    	                	}
	                        	
	    	                	else if(i==30){
	    	                		oilLeaksPresent = cell.getStringCellValue();
	    	                		pcbCondition.setOilLeaksPresent(oilLeaksPresent);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Oil Leaks Present (Yes/No) : " + oilLeaksPresent);
	    	                	}
	                        	
	    	                	else if(i==31){
	    	                		corrosion = cell.getStringCellValue();
	    	                		pcbCondition.setCorrosion(corrosion);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Corrosion (Yes/No) : " + corrosion);
	    	                	}
	                        	 
	    	                	else if(i==32){
	    	                		burnMarks = cell.getStringCellValue();
	    	                		pcbCondition.setBurnMask(burnMarks);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Burn Marks (Yes/No) : " + burnMarks);
	    	                	}
	                        	
	    	                	else if(i==33){
	    	                		terminalNeedattention = cell.getStringCellValue();
	    	                		pcbCondition.setTerminalAttention(terminalNeedattention);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Terminal / Connections Need attention (Yes/No) : " + terminalNeedattention);
	    	                	}
	                        	
	    	                	else if(i==34){
	    	                		earthingConnection = cell.getStringCellValue();
	    	                		pcbCondition.setEarthConnection(earthingConnection);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Earthing Connection is properly done (Yes/No) : " + earthingConnection);
	    	                	}
	                        	
	    	                	else if(i==35){
	    	                		breatherCondition  = cell.getStringCellValue();
	    	                		pcbCondition.setBreatherIsGoodConnection(breatherCondition);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Breather is in Good condition (Yes/No) : " + breatherCondition);
	    	                	}
	                        	
	    	                	else if(i==36){
	    	                		overloaSignsPresent   = cell.getStringCellValue();
	    	                		pcbCondition.setOverloadPresent(overloaSignsPresent);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Overload signs present (Yes/No) : " + overloaSignsPresent);
	    	                	}
	                        	
	    	                	else if(i==37){
	    	                		lightingArresters   = cell.getStringCellValue();
	    	                		pcbCondition.setLightingArrestersDone(lightingArresters);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Lighting arresters are properly done (Yes/No) : " + lightingArresters);
	    	                	}
	                        	
	    	                	else if(i==38){
	    	                		remarks   = cell.getStringCellValue();
	    	                		pcbSample.setRemarks(remarks);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "Remarks : " + remarks);
	    	                	}
	                        	
	    	                	else if(i==39){
	    	                		EPFNumbersofthegroup   = cell.getStringCellValue();
	    	                		pcbSample.setEpfNoGroup(EPFNumbersofthegroup);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "EPF Numbers of the group : " + EPFNumbersofthegroup);
	    	                	}
	                        	
	    	                	else if(i==40){
	    	                		PCBTestResults   = cell.getStringCellValue();
	    	                		pcbSample.setPcbTestResults(PCBTestResults);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "PCB Test Results : " + PCBTestResults);
	    	                	}
	                        	
	    	                	else if(i==41){
	    	                		PCBTestdate   = cell.getStringCellValue();
	    	                		//DateFormat format = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH);
	    	                		//java.util.Date date3 = format.parse(PCBTestdate);
	    	                		//pcbSample.setPcbTestDate(date3);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "PCB Test date : " + PCBTestdate);
	    	                	}
	                        	
	    	                	else if(i==42){
	    	                		EPFNumbersoftheTestGroup   = cell.getStringCellValue();
	    	                		pcbSample.setEpfNoTestGroup(EPFNumbersoftheTestGroup);
	    	                		System.out.println("no : "  +i +"/"+ cell.getStringCellValue() + "EPF Numbers of the Test Group : " + EPFNumbersoftheTestGroup);
	    	                	}

	    	                	else{
	    	                	}
	                        	
	                        	System.out.println("else end no : " + i);
	                        	i++;
	                        	System.out.println("else end no after : " + i);
	    	                	   
	                        	                                break;
	                        	                                
	                    }//end switch
	                    
	                 }//end while cell iterator
	                
	                
                   /* String sequence = addEquipment.getNextEquipmentId("TR");

        			System.out.println("------------------>  " +"TR" + "_"
        					+ sequence);

        			String equiID = "TR" + "_" + sequence;

        			pcbEuipments.setEquipmentId(equiID);
        			pcbCondition.setEquipmentId(equiID);
        			pcbLocation.setEquipmentId(equiID);
        			pcbSample.setEquipmentId(equiID);
        			
        			
                    addEquipment.addEquipment(pcbEuipments);
                    addCondition.addCondition(pcbCondition);
                    addLocation.addLocation(pcbLocation);
                    addSample.addSample(pcbSample);*/
	                
	                
  
	            }
				fileExcel.close();
				System.out.println("Server File Location="
						+ serverFile.getAbsolutePath());
				
				mode ="You successfully uploaded file " + name;
				
			} catch (Exception e) {
				mode ="You failed to upload " + name + " => " +ss + e.getMessage();
			}
		} else {
			mode ="You failed to upload " + name + " because the file was empty.";
		}
		PcbModel objModel = new PcbModel();
		objModel.setMode(mode);
		return new ModelAndView("uploadEquipment" ,"model",objModel);
	}
	
	
	@RequestMapping(value = "/GetLocationByArea/{area}", method = RequestMethod.GET)
	public @ResponseBody List<PcbLocation> GetLocationByArea(@PathVariable("area") String area) {
		return addLocation.findLocationByArea(area);
	}
	
	
	
	@RequestMapping(value = "/addUpdatePcbMobile", method = RequestMethod.POST)
	public @ResponseBody String addPcbMobile(@RequestBody PcbModel pcbModel,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// System.out.println("equipment : " + equipment.getCode());
		try {
			System.out.println("--> IN /MMSaddEquipment");

			System.out.println(" referenceNo: "
					+ pcbModel.getPcbEquipment().getReferenceNo());
			System.out.println(" divison: "
					+ pcbModel.getPcbEquipment().getDivison());
			System.out
					.println(" branch: " + pcbModel.getPcbEquipment().getBranch());
			System.out.println(" unit: " + pcbModel.getPcbEquipment().getUnit());
			System.out.println(" condition: "
					+ pcbModel.getPcbEquipment().getCondition());
			System.out.println(" photoRef: "
					+ pcbModel.getPcbEquipment().getPhotoRef());
			System.out.println(" weightTransformer: "
					+ pcbModel.getPcbEquipment().getWeightTransformer());
			System.out.println(" volumeOfOil: "
					+ pcbModel.getPcbEquipment().getVolumeOfOil());
			System.out.println(" oilWeight: "
					+ pcbModel.getPcbEquipment().getOilWeight());
			System.out.println(" capacity: "
					+ pcbModel.getPcbEquipment().getCapacity());
			System.out.println(" voltage: "
					+ pcbModel.getPcbEquipment().getVoltage());
			System.out.println(" serialNo: "
					+ pcbModel.getPcbEquipment().getSerialNo());
			System.out.println(" manufactureBrand: "
					+ pcbModel.getPcbEquipment().getManufactureBrand());
			System.out.println(" photoTaken: "
					+ pcbModel.getPcbEquipment().getPhotoTaken());
			System.out.println(" equipmentId: "
					+ pcbModel.getPcbEquipment().getEquipmentId());
			System.out.println(" primarySub: "
					+ pcbModel.getPcbEquipment().getPrimarySub());
			System.out.println(" manufactureLtl: "
					+ pcbModel.getPcbEquipment().getManufactureLtl());
			System.out.println(" type: " + pcbModel.getPcbEquipment().getType());
			System.out.println(" seriaType: "
					+ pcbModel.getPcbEquipment().getSeriaType());
			System.out.println(" manufactureDate: "
					+ pcbModel.getPcbEquipment().getManufactureDate());

			String message = "Welcome to Spring 4.0 !";

			/*PcbEquipment objEx = new PcbEquipment();
			if (pcbModel.getPcbEquipment().getEquipmentId() == null) {
				objEx = null;
			} else {
				objEx = addEquipment.findEquipmentByEquipmentId(pcbModel
						.getPcbEquipment().getEquipmentId());
			}

			String resultobjE = "";
			String resultobjS = "";
			String resultobjC = "";
			String resultobjL = "";
			String success = "";
			String submitType = "";
			PcbModel obj = new PcbModel();
			//ModelAndView mo = new ModelAndView("MMS_addEquipment", "SaveEquipment",
				//obj);

			// for add equipment
			if (objEx == null) {
				System.out.println("--> IN ADD EQUIPMENT");

				String sequence = addEquipment.getNextEquipmentId(pcbModel
						.getPcbEquipment().getBranch());
				System.out.println("equipmentId: "
						+ pcbModel.getPcbEquipment().getBranch() + "_" + sequence);

				String equipmentId = pcbModel.getPcbEquipment().getBranch() + "_"
						+ sequence;
				pcbModel.getPcbEquipment().setEquipmentId(equipmentId);
				pcbModel.getPcbSample().setEquipmentId(equipmentId);
				pcbModel.getPcbCondition().setEquipmentId(equipmentId);
				pcbModel.getPcbLocation().setEquipmentId(equipmentId);

				resultobjE = addEquipment.addEquipment(pcbModel.getPcbEquipment());
				success += "Equipment Added.. ";

				resultobjS = addSample.addSample(pcbModel.getPcbSample());
				success += "Sample Added.. ";

				resultobjC = addCondition.addCondition(pcbModel.getPcbCondition());
				success += "Condition Added.. ";

				resultobjL = addLocation.addLocation(pcbModel.getPcbLocation());
				success += "Location Added.. ";

				//mo = new ModelAndView("MMS_addEquipment", "SaveEquipment", obj);
			}

			// for update equipment
			else {
				System.out.println("--> IN EDIT EQUIPMENT");

				String equipmentId = pcbModel.getPcbEquipment().getEquipmentId();
				PcbSample findAvailablePcbSample = addSample
						.findSampleByEquipmentId(equipmentId);
				PcbCondition findAvailablePcbCondition = addCondition
						.findConditionByEquipmentId(equipmentId);
				PcbLocation findAvailablePcbLocation = addLocation
						.findLocationByEquipmentId(equipmentId);

				// SET equipmentId for PcbSample, PcbCondition and PcbLocation
				pcbModel.getPcbSample().setEquipmentId(equipmentId);
				pcbModel.getPcbCondition().setEquipmentId(equipmentId);
				pcbModel.getPcbLocation().setEquipmentId(equipmentId);

				// UPDATE PcbEquipment
				if (pcbModel.getPcbEquipment() != null) {
					resultobjE = addEquipment.updateEquipment(pcbModel
							.getPcbEquipment());
					success += "Equipment Updated.. ";
				}

				// ADD PcbSample
				if (findAvailablePcbSample == null) {
					resultobjS = addSample.addSample(pcbModel.getPcbSample());
					success += "Sample Added.. ";
				}
				// UPDATE PcbSample
				else {
					resultobjS = addSample.updateSample(pcbModel.getPcbSample());
					success += "Sample Updated.. ";
				}

				// ADD PcbCondition
				if (findAvailablePcbCondition == null) {
					resultobjC = addCondition.addCondition(pcbModel
							.getPcbCondition());
					success += "Condition Added.. ";
				}
				// UPDATE PcbCondition
				else {
					resultobjC = addCondition.updateCondition(pcbModel
							.getPcbCondition());
					success += "Condition Updated.. ";
				}

				// ADD PcbLocation
				if (findAvailablePcbLocation == null) {
					resultobjL = addLocation.addLocation(pcbModel.getPcbLocation());
					success += "Location Added.. ";
				}
				// UPDATE PcbLocation
				else {
					resultobjL = addLocation.updateLocation(pcbModel
							.getPcbLocation());
					success += "Location Updated.. ";
				}
				System.out.println(success);

			//String success = "Successfully Added";

			
			 * PcbEquipment obj = new PcbEquipment();
			 * //obj.setName("Successfully Added"); ModelAndView mo = new
			 * ModelAndView("MMS_addEquipment", "SaveEquipment", obj);
			 * mo.addObject("success", success);
			 
			}
			
				
			
*/
			
			String sequence = addEquipment.getNextEquipmentId(pcbModel.getPcbEquipment().getDivison());
			System.out.println("equipmentId: "+ pcbModel.getPcbEquipment().getDivison() + "_" + sequence);

			String equiID = pcbModel.getPcbEquipment().getDivison() + "_"+ sequence;

			
			String existingEquiId = addEquipment.getEquipmentIdByReferenceNo(pcbModel.getPcbEquipment().getReferenceNo());
			System.out.println("existingEquiId : "+ existingEquiId);
			
			
			/*pcbEuipments.setEquipmentId(equiID);
			pcbEuipments.setStatus(new BigDecimal(Util.IN_BULK));
			pcbCondition.setEquipmentId(equiID);
			pcbLocation.setEquipmentId(equiID);
			pcbSample.setEquipmentId(equiID);
			*/
			
			
			if(existingEquiId == null ){
				
				pcbModel.getPcbEquipment().setEquipmentId(equiID);
				pcbModel.getPcbEquipment().setStatus(new BigDecimal(Util.IN_BULK));
				pcbModel.getPcbLocation().setEquipmentId(equiID);
				pcbModel.getPcbSample().setEquipmentId(equiID);
				pcbModel.getPcbCondition().setEquipmentId(equiID);
    			
				addEquipment.addEquipment(pcbModel.getPcbEquipment());
                addCondition.addCondition(pcbModel.getPcbCondition());
                addLocation.addLocation(pcbModel.getPcbLocation());
                addSample.addSample(pcbModel.getPcbSample());

			}else{
				
				pcbModel.getPcbEquipment().setEquipmentId(existingEquiId);
				pcbModel.getPcbEquipment().setStatus(new BigDecimal(Util.IN_BULK));
				pcbModel.getPcbLocation().setEquipmentId(existingEquiId);
				pcbModel.getPcbSample().setEquipmentId(existingEquiId);
				pcbModel.getPcbCondition().setEquipmentId(existingEquiId);
    			
				addEquipment.updateEquipment(pcbModel.getPcbEquipment());
                addCondition.updateCondition(pcbModel.getPcbCondition());
                addLocation.updateLocation(pcbModel.getPcbLocation());
                addSample.updateSample(pcbModel.getPcbSample());

			}
			

			
			
			return "Y";
		} catch (Exception e) {
			System.out.println("error :" + e.getMessage());
			return "N";
		}

	}
	
	
	@RequestMapping(value = "/MapNewPCB/{div}/{pro}/{area}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapNewPCB(HttpServletRequest request, @PathVariable("div") String div,@PathVariable("pro") String pro,@PathVariable("area") String area) {
		System.out.println("div :" + div);
		System.out.println("pro :" + pro);
		System.out.println("area :" + area);
		return addEquipment.findLocationIdsForDivBraUnit(div.trim(), pro.trim(), area.trim());
	}
	
	@RequestMapping(value = "/MapNewPCBMMS/{pro}/{area}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapNewPCBMMS(HttpServletRequest request,@PathVariable("pro") String pro,@PathVariable("area") String area) {
		//System.out.println("div :" + div);
		System.out.println("pro :" + pro);
		System.out.println("area :" + area);
		return addEquipment.findLocationIdsForBraUnit(pro.trim(), area.trim());
	}
	
	
	@RequestMapping(value = "/MapNewPCBArea/{area}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> MapNewPCBArea(HttpServletRequest request,@PathVariable("area") String area) {
		System.out.println("area :" + area);
		return addEquipment.findLocationIdsForArea( area.trim());
	}
	
	


	/* 
	* to get the version no
	  
	@RequestMapping(value = "/getVersion", method = RequestMethod.GET,  produces = "application/json")
	public @ResponseBody String getVersion(BindingResult bindingResult, HttpServletRequest request,
										HttpServletResponse response) throws Exception {
			return "2019.10.15.1";

	}
*/
	/*
	*to get PcbEquipment
	
	@RequestMapping(value = "/getPcbEquipment/{referenceNo}", method = RequestMethod.GET,  produces = "application/json")
	public @ResponseBody PcbEquipment getPcbEquipment (@PathVariable("referenceNo") String referenceNo,BindingResult bindingResult, HttpServletRequest request,
	HttpServletResponse response) throws Exception {
		System.out.println("getPcbEquipment");
		return addEquipment.getEquipmentByReferenceNo(referenceNo);
	
	}
*/
	/*
	*to get PcbSample
	*/
	@RequestMapping(value = "/getPcbSample ", method = RequestMethod.GET)
	public @ResponseBody PcbSample getPcbSample (@RequestBody String equipmentId,BindingResult bindingResult, HttpServletRequest request,
													HttpServletResponse response) throws Exception {
		return addSample.findSampleByEquipmentId(equipmentId);
	}


	/*
	*to get PcbCondition
	*/
	@RequestMapping(value = "/getPcbCondition ", method = RequestMethod.GET)
	public @ResponseBody PcbCondition getPcbCondition (@RequestBody String equipmentId,BindingResult bindingResult, HttpServletRequest request,
														HttpServletResponse response) throws Exception {
		return addCondition.findConditionByEquipmentId(equipmentId);
		
	}

	/*
	*to get PcbLocation
	*/
	@RequestMapping(value = "/getPcbLocation ", method = RequestMethod.GET)
	public @ResponseBody PcbLocation getPcbLocation (@RequestBody String equipmentId,BindingResult bindingResult, HttpServletRequest request,
														HttpServletResponse response) throws Exception {
		return addLocation.findLocationByEquipmentId(equipmentId);
	}

	/*
	*add PcbEquipment
	*/
	@RequestMapping(value = "/addPcbEquipment", method = RequestMethod.POST)
	public @ResponseBody String getPcbEquipment (@RequestBody PcbEquipment pcbEquipment,BindingResult bindingResult, HttpServletRequest request,
	HttpServletResponse response) throws Exception {
	try {
		addEquipment.addEquipment(pcbEquipment);
		return "Y";

	} catch (Exception e) {
		System.out.println("error :" + e.getMessage());
		return "N";
	}

	}

	/*
	*to get PcbEquipment
	*/
	@RequestMapping(value = "/addPcbSample ", method = RequestMethod.POST)
	public @ResponseBody String  getPcbSample (@RequestBody PcbSample pcbSample,BindingResult bindingResult, HttpServletRequest request,
	HttpServletResponse response) throws Exception {

	try {
		addSample.addSample(pcbSample);//add code
	return "Y";

	} catch (Exception e) {
		System.out.println("error :" + e.getMessage());
		return "N";
	}

	}


	/*
	*to add PcbCondition
	*/
	@RequestMapping(value = "/addPcbCondition ", method = RequestMethod.POST)
	public @ResponseBody String  getPcbCondition (@RequestBody PcbCondition pcbCondition,BindingResult bindingResult, HttpServletRequest request,
	HttpServletResponse response) throws Exception {

	try {
		addCondition.addCondition(pcbCondition);//add code
	return "Y";

	} catch (Exception e) {
		System.out.println("error :" + e.getMessage());
		return "N";
	}

	}

	/*
	*to add PcbLocation
	*/
	@RequestMapping(value = "/addPcbLocation ", method = RequestMethod.POST)
	public @ResponseBody String getPcbSample (@RequestBody PcbLocation pcbLocation,BindingResult bindingResult, HttpServletRequest request,
	HttpServletResponse response) throws Exception {

	try {
		addLocation.addLocation(pcbLocation);//add code
		return "Y";

	} catch (Exception e) {
		System.out.println("error :" + e.getMessage());
		return "N";
	}

	}

	/*
	*to get PcbModel
	
	@RequestMapping(value = "/getPcbModel ", method = RequestMethod.GET)
	public @ResponseBody PcbModel getPcbModel (@RequestBody String equipmentId,BindingResult bindingResult, HttpServletRequest request,
	HttpServletResponse response) throws Exception {
		//get code
		PcbEquipment objEqui = addEquipment.findEquipmentByEquipmentId(equipmentId);
		PcbSample objSample= addSample.findSampleByEquipmentId(equipmentId);
		PcbCondition objCondition = addCondition.findConditionByEquipmentId(equipmentId);
		PcbLocation objLoc = addLocation.findLocationByEquipmentId(equipmentId);
		
		PcbModel model = new PcbModel();
		model.setPcbEquipment(objEqui);
		model.setPcbSample(objSample);
		model.setPcbCondition(objCondition);
		model.setPcbLocation(objLoc);
		return model;
 
	}
*/

	
	@RequestMapping(value = "/MMSaddEquipmentnew", method = RequestMethod.POST)
	public ModelAndView MMSaddEquipmentnew(
	@ModelAttribute("SaveEquipment") PcbModel pcbModel,
	BindingResult bindingResult, HttpServletRequest request,
	HttpServletResponse response) throws Exception {

	System.out.println("--> IN /MMSaddEquipment");

	System.out.println(" referenceNo: "
	+ pcbModel.getPcbEquipment().getReferenceNo());
	System.out.println(" divison: "
	+ pcbModel.getPcbEquipment().getDivison());
	System.out
	.println(" branch: " + pcbModel.getPcbEquipment().getBranch());
	System.out.println(" unit: " + pcbModel.getPcbEquipment().getUnit());
	System.out.println(" condition: "
	+ pcbModel.getPcbEquipment().getCondition());
	System.out.println(" photoRef: "
	+ pcbModel.getPcbEquipment().getPhotoRef());
	System.out.println(" weightTransformer: "
	+ pcbModel.getPcbEquipment().getWeightTransformer());
	System.out.println(" volumeOfOil: "
	+ pcbModel.getPcbEquipment().getVolumeOfOil());
	System.out.println(" oilWeight: "
	+ pcbModel.getPcbEquipment().getOilWeight());
	System.out.println(" capacity: "
	+ pcbModel.getPcbEquipment().getCapacity());
	System.out.println(" voltage: "
	+ pcbModel.getPcbEquipment().getVoltage());
	System.out.println(" serialNo: "
	+ pcbModel.getPcbEquipment().getSerialNo());
	System.out.println(" manufactureBrand: "
	+ pcbModel.getPcbEquipment().getManufactureBrand());
	System.out.println(" photoTaken: "
	+ pcbModel.getPcbEquipment().getPhotoTaken());
	System.out.println(" equipmentId: "
	+ pcbModel.getPcbEquipment().getEquipmentId());
	System.out.println(" primarySub: "
	+ pcbModel.getPcbEquipment().getPrimarySub());
	System.out.println(" manufactureLtl: "
	+ pcbModel.getPcbEquipment().getManufactureLtl());
	System.out.println(" type: " + pcbModel.getPcbEquipment().getType());
	System.out.println(" seriaType: "
	+ pcbModel.getPcbEquipment().getSeriaType());
	System.out.println(" manufactureDate: "
	+ pcbModel.getPcbEquipment().getManufactureDate());

	String message = "Welcome to Spring 4.0 !";

	PcbEquipment objEx = new PcbEquipment();
	String resultobjE = "";
	String resultobjS = "";
	String resultobjC = "";
	String resultobjL = "";
	String success = "";
	String submitType = "";
	PcbModel obj = new PcbModel();
	ModelAndView mo = new ModelAndView("MMS_addEquipment", "SaveEquipment",
	obj);

	// for add equipment
	// if (objEx == null) {
	System.out.println("--> IN ADD EQUIPMENT");
	try{


	//-0.0004 x C^2 + 3.4523 x C - 9.2363


	/*BigDecimal c = pcbModel.getPcbSample().getPcbTestData();

	int n = 2;
	BigDecimal a1 = c.pow(n);
	BigDecimal a2 = new BigDecimal("-0.0004");
	BigDecimal a3 = a2.multiply(a1);
	BigDecimal a4 = new BigDecimal("3.4523");
	BigDecimal a5 = a4.multiply(c);
	BigDecimal a6 = new BigDecimal("9.2363");
	BigDecimal a7 = a5.subtract(a6);
	BigDecimal a8 = a3.add(a7);

	BigDecimal aroclor = a8;
	pcbModel.getPcbSample().setPcbTestDataAroclor(aroclor);
*/
		
		
		try {
			if(pcbModel.getPcbSample()!=null){
				BigDecimal c = pcbModel.getPcbSample().getPcbTestData();
				if(c!=null){
				int n = 2;
				BigDecimal a1 = c.pow(n);
				BigDecimal a2 = new BigDecimal("-0.0004");
				BigDecimal a3 = a2.multiply(a1);
				BigDecimal a4 = new BigDecimal("3.4523");
				BigDecimal a5 = a4.multiply(c);
				BigDecimal a6 = new BigDecimal("9.2363");
				BigDecimal a7 = a5.subtract(a6);
				BigDecimal a8 = a3.add(a7);

				BigDecimal aroclor = a8;
				pcbModel.getPcbSample().setPcbTestDataAroclor(aroclor);
				}
				}
				if(pcbModel.getPcbEquipment()!=null){
					BigDecimal c = pcbModel.getPcbEquipment().getOilWeight();
					if(c!=null){
						BigDecimal a = new BigDecimal("0.86");
						BigDecimal result = c.divide(a);
						pcbModel.getPcbEquipment().setVolOil(result);
					}else{
						BigDecimal c1 = pcbModel.getPcbEquipment().getVolOil();
						if(c1!=null){
							BigDecimal a = new BigDecimal("0.86");
							BigDecimal result = c1.multiply(a);
							pcbModel.getPcbEquipment().setOilWeight(result);
						}
					}
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	String sequence = addEquipment.getNextEquipmentId(pcbModel
	.getPcbEquipment().getDivison());
	System.out.println("equipmentId: "
	+ pcbModel.getPcbEquipment().getDivison() + "_" + sequence);

	String equipmentId = pcbModel.getPcbEquipment().getDivison() + "_"
	+ sequence;
	pcbModel.getPcbEquipment().setEquipmentId(equipmentId);
	pcbModel.getPcbSample().setEquipmentId(equipmentId);
	pcbModel.getPcbCondition().setEquipmentId(equipmentId);
	pcbModel.getPcbLocation().setEquipmentId(equipmentId);

	resultobjE = addEquipment.addEquipment(pcbModel.getPcbEquipment());
	success += "Equipment Added.. ";

	resultobjS = addSample.addSample(pcbModel.getPcbSample());
	success += "Sample Added.. ";

	resultobjC = addCondition.addCondition(pcbModel.getPcbCondition());
	success += "Condition Added.. ";

	resultobjL = addLocation.addLocation(pcbModel.getPcbLocation());
	success += "Location Added.. ";
	}catch(Exception e){
	System.out.println("error:" + e.getMessage());
	}
	mo = new ModelAndView("MMS_addEquipment", "SaveEquipment", obj);
		mo.addObject("success", success);
	return mo;
	}

	
	
	@RequestMapping("/downloadPcbReport")
    public String downloadPcbReport( HttpServletRequest request,@ModelAttribute("pcbReport") PcbModel pcbModel,
                                     HttpServletResponse response)
    {
        
		
		
		String downloadReportName="";
		
		String reportFileName ="";
		if(pcbModel.getMode().equalsIgnoreCase("IOTI")){
			reportFileName ="Inventory_of_Transformers1";
			downloadReportName="Inventory_of_Transformers_1";
			System.out.println("reportFileName : " + reportFileName);
		}else if(pcbModel.getMode().equalsIgnoreCase("IOTII")){
			reportFileName ="Inventory_of_Transformers2";
			downloadReportName="Inventory_of_Transformers_2";
			
		}else if(pcbModel.getMode().equalsIgnoreCase("IOTIIV")){
			reportFileName ="Inventory_of_Transformers4";
			downloadReportName="Inventory_of_Transformers_4";
			
		}else if(pcbModel.getMode().equalsIgnoreCase("IOTIV")){
			reportFileName ="Inventory_of_Transformers5";
			downloadReportName="Inventory_of_Transformers_5";
			
		}else if(pcbModel.getMode().equalsIgnoreCase("STORE")){
			reportFileName ="Inventory_of_Transformers10";
			downloadReportName="Inventory_of_Transformers_10";
			
		}else if(pcbModel.getMode().equalsIgnoreCase("SUMMARY")){
			reportFileName ="Inventory_of_Transformers7";
			downloadReportName="Inventory_of_Transformers_7";
			
		}else if(pcbModel.getMode().equalsIgnoreCase("DEVSUMMARY")){
			reportFileName ="Inventory_of_Transformers8";
			downloadReportName="Inventory_of_Transformers_8";
			
		}else if(pcbModel.getMode().equalsIgnoreCase("PROSUMMARY")){
			reportFileName ="Inventory_of_Transformers9";
			downloadReportName="Inventory_of_Transformers_9";
			
		}else if(pcbModel.getMode().equalsIgnoreCase("PROSUMMARYNEW")){
			reportFileName ="Inventory_of_Transformers14";
			downloadReportName="Inventory_of_Transformers_14";
			
		}else {
			reportFileName ="Inventory_of_Transformers3";
			downloadReportName="Inventory_of_Transformers_3";
		}	
		
		
		Connection conn = null;

		try {
			conn = jasperDao.getConnection();
			
			String rptFormat = "pdf";
			String noy = "9";

			
			HashMap<String, Object> hmParams = new HashMap<String, Object>();
			String div = pcbModel.getPcbEquipment().getDivison();
			div=div.trim();
			String pro = pcbModel.getPcbEquipment().getBranch();
			pro = pro.trim();
			String area = pcbModel.getPcbEquipment().getUnit();
			area = area.trim();
			
			BigDecimal level = pcbModel.getPcbSample().getPcbTestDataAroclor();
			System.out.println("level " + level);
			
			if(div.equalsIgnoreCase("NONE")){
				hmParams.put("@Division","''");
			}else{
				
				hmParams.put("@Division","'" +div.trim() +"'");
			}
			
			if(pro.equalsIgnoreCase("NONE")){
				hmParams.put("@Branch","''");
				
			}else{
				hmParams.put("@Branch","'" +pro.trim() +"'");
				
			}
			if(area.equalsIgnoreCase("NONE")){
				hmParams.put("@Unit","''");
				
			}else{
				hmParams.put("@Unit","'"+area.trim()+"'");
				
			}
			
			hmParams.put("@level",level);
			
			System.out.println("Division " + div);
			System.out.println("Branch " + pro);
			System.out.println("Unit " + area);
			JasperReport jasperReport = jasperDao.getCompiledFileMVMMS(reportFileName,request);
			Calendar calendar = Calendar.getInstance();
			
			String reportName = downloadReportName +"-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH ) + 1)+ "-" 
					+ calendar.get(Calendar.DATE)+ "-" + calendar.get(Calendar.HOUR) + "-" + calendar.get(Calendar.MINUTE)+ "-" 
					+ calendar.get(Calendar.SECOND)+ "-" + calendar.get(Calendar.MILLISECOND)   + ".pdf";
					
			
			if (rptFormat.equalsIgnoreCase("html")) {

				JasperPrint jasperPrint = JasperFillManager.fillReport(
						jasperReport, hmParams, conn);
				jasperDao.generateReportHtml(jasperPrint, request, response); // For
																			// HTML
																			// report

			}

			else if (rptFormat.equalsIgnoreCase("pdf")) {

				jasperDao.generateReportPDFWithName(response, hmParams, jasperReport, conn,reportName); // For
																					// PDF
																					// report

			}
			
				} catch (Exception sqlExp) {
			System.out.println("Exception::" + sqlExp.toString());
		} finally {
			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		return null;

		
		
		
		
		
		
		/*System.out.println("download APK");
		String path1 = PathMMS.getReportPath() + File.separator + "Reports" +File.separator+ "MVMMS.apk" ;
		File dir1 = new File(path1 + File.separator + "Reports");
		if (!dir1.exists())
			dir1.mkdirs();
		String fileName = "MVMMS.apk";
		System.out.println("download APK");
		
		File file = new File(path1);
		if (file.exists())
        {
        	
        	
        	
            try {
            	response.setContentType("application/apk");
            	 response.addHeader("Content-Disposition", "attachment; filename="+fileName);
                 
            	InputStream inputStream = new FileInputStream(new File(path1)); //load the file
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        }*/
    }
	
	
	@RequestMapping(value = "/viewReportsPCB", method = RequestMethod.GET)
	public ModelAndView viewReportsPCB(@RequestParam("mode") String mode,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		PcbModel pcbModel =new PcbModel();
		System.out.println("--> IN /viewReports");
		List<Glcompm> compList = compDao.getDisDivision();
		Map<String,String> divListTem = new LinkedHashMap<String,String>();
		
		int depLoop = compList.size() - 1;
		for (int i = 0; i <= depLoop; i++) {
			Glcompm ojb = (Glcompm) compList.get(i);
			System.out.println(i + " " +ojb.getCompNm() );
			
			divListTem.put(ojb.getCompId(), ojb.getCompNm());
		}
		
		pcbModel.setDivList(divListTem);
		pcbModel.setMode(mode);
		ModelAndView mo = new ModelAndView("pcbReports","pcbReport", pcbModel);

		// add step type and success type to ModelAndView mo
		String success = "";
		String step = "step1";
		mo.addObject("step", step);
		mo.addObject("success", success);

		return mo;

	}
	
	
	
	@RequestMapping("/downloadAPKPCB")
    public void downloadPDFResource( HttpServletRequest request,
                                     HttpServletResponse response)
    {
        
		System.out.println("download APK");
		//If user is not authorized - he should be thrown out from here itself
         
        //Authorized user will download the file
		
		String path1 = PathMMS.getReportPath() + File.separator + "Reports" +File.separator+ "PCB.apk" ;
		File dir1 = new File(path1 + File.separator + "Reports");
		if (!dir1.exists())
			dir1.mkdirs();
		String fileName = "PCB.apk";
		System.out.println("download APK");
		
		File file = new File(path1);
		
		
        //String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/MVMMS.apk");
		// dataDirectory = request.getSession().getServletContext().getRealPath("/jasper/");
        //Path file = Paths.get(dataDirectory, fileName);
        //System.out.println("download APK 1" +path1 );
		
        if (file.exists())
        {
        	
        	
        	
            try {
            	response.setContentType("application/apk");
            	 response.addHeader("Content-Disposition", "attachment; filename="+fileName);
                 
            	InputStream inputStream = new FileInputStream(new File(path1)); //load the file
				IOUtils.copy(inputStream, response.getOutputStream());
				response.flushBuffer();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	/*byte[] bytesArray = new byte[(int) file.length()];
        	System.out.println("download APK 2");
        	response.reset();
        	response.resetBuffer();
        	response.setContentType("application/apk");
        	response.setContentLength(bytesArray.length);
    		
            //response.setContentType("application/apk");
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            System.out.println("download APK 3");
    		
            try
            {
            	ServletOutputStream ouputStream = response.getOutputStream();
            	//ouputStream.
    			ouputStream.write(bytesArray, 0, bytesArray.length);
    			ouputStream.flush();
    			ouputStream.close();
    			
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }*/

        }
    }
	
	
	@RequestMapping(value = "/divisionalSummary", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> divisionalSummary() {
		 System.out.println("divisionalSummary");
 		
		return addEquipment.getSummaryTransformer();
		
	}


	@RequestMapping(value = "/divisionalSummarySample", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> divisionalSummarySample() {
		 System.out.println("divisionalSummary");
 		
		return addEquipment.getSummaryTransformerSampled();
		
	}
	
	
	@RequestMapping(value = "/divisionalSummaryScreening", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> divisionalSummaryScreening() {
		 System.out.println("divisionalSummary");
 		
		return addEquipment.getSummaryTransformerScreening();
		
	}
	
	@RequestMapping(value = "/divisionalSummaryItiPositive", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> divisionalSummaryItiPositive() {
		 System.out.println("divisionalSummary");
 		
		return addEquipment.getSummaryTransformerItiConf();
		
	}
	
	
	@RequestMapping(value = "/divisionalSummaryDPA/{div}/{pro}/{area}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> divisionalSummaryDPA(HttpServletRequest request, @PathVariable("div") String div,@PathVariable("pro") String pro,@PathVariable("area") String area) {
		System.out.println("div :" + div);
		System.out.println("pro :" + pro);
		System.out.println("area :" + area);
		return addEquipment.getSummaryTransformerDPA(div.trim(), pro.trim(), area.trim());
	}
	
	@RequestMapping(value = "/divisionalSummaryDPAArea/{div}/{pro}/{area}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> divisionalSummaryDPAArea(HttpServletRequest request, @PathVariable("div") String div,@PathVariable("pro") String pro,@PathVariable("area") String area) {
		System.out.println("div :" + div);
		System.out.println("pro :" + pro);
		System.out.println("area :" + area);
		String deptId = request.getSession().getAttribute("deptId").toString();
		String provinceStr = deptDao.getDD(deptId);
		System.out.print("MapNewSummaryOtherDD"+ provinceStr);
		
		String provi = glcompmDao.getDistDivision(provinceStr);
		
		String dist = glcompmDao.getDistDivision(provi);
		
		System.out.print("MapNewSummaryOtherPro"+ provi);
		
		System.out.print("MapNewSummaryOtherDD"+ dist);
		
		return addEquipment.getSummaryTransformerDPA(dist.trim(), provi.trim(), area.trim());
	}
	
	@RequestMapping(value = "/divisionalSummaryDPAProvince/{div}/{pro}/{area}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> divisionalSummaryDPAProvince(HttpServletRequest request, @PathVariable("div") String div,@PathVariable("pro") String pro,@PathVariable("area") String area) {
		System.out.println("div :" + div);
		System.out.println("pro :" + pro);
		System.out.println("area :" + area);
		String deptId = request.getSession().getAttribute("deptId").toString();
		String provinceStr = deptDao.getDD(deptId);
		System.out.print("MapNewSummaryOtherDD"+ provinceStr);
		
		String distDiv = glcompmDao.getDistDivision(provinceStr);
		
		
		System.out.print("MapNewSummaryOther"+ distDiv);
		
		
		return addEquipment.getSummaryTransformerDPA(distDiv.trim(), pro.trim(), area.trim());
	}
	
	
	
	@RequestMapping(value = "/divisionalSummarySampleDPA/{div}/{pro}/{area}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> divisionalSummarySampleDPA(HttpServletRequest request, @PathVariable("div") String div,@PathVariable("pro") String pro,@PathVariable("area") String area) {
		System.out.println("div :" + div);
		System.out.println("pro :" + pro);
		System.out.println("area :" + area);
		return addEquipment.getSummaryTransformerSampledDPA(div.trim(), pro.trim(), area.trim());
	}
	
	@RequestMapping(value = "/getSummaryTransformerScreeningDPA/{div}/{pro}/{area}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> getSummaryTransformerScreeningDPA(HttpServletRequest request, @PathVariable("div") String div,@PathVariable("pro") String pro,@PathVariable("area") String area) {
		System.out.println("div :" + div);
		System.out.println("pro :" + pro);
		System.out.println("area :" + area);
		return addEquipment.getSummaryTransformerScreeningDPA(div.trim(), pro.trim(), area.trim());
	}
	
	@RequestMapping(value = "/getSummaryTransformerOilDPA/{div}/{pro}/{area}",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Object[]> getSummaryTransformerOilDPA(HttpServletRequest request, @PathVariable("div") String div,@PathVariable("pro") String pro,@PathVariable("area") String area) {
		System.out.println("div :" + div);
		System.out.println("pro :" + pro);
		System.out.println("area :" + area);
		return addEquipment.getSummaryTransformerOilWeight(div.trim(), pro.trim(), area.trim());
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
