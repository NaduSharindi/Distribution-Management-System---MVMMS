<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>



<head>
<%@ include file="sections/head.jsp"%>



<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/datepicker.css"/>" />


 <script type="text/javascript" src="<c:url value="/resources/js/datepicker.js"/>"></script>


<script type="text/javascript">

function findArea() {
	//var categoryId = $(this).val();
	//alert("hiii");
	var strUser = province.options[province.selectedIndex].value;
	/* if(strUser == "DD1"){
		strUser = "DISCO1";
	}else if(strUser == "DD2"){
		strUser = "DISCO2";
	}*/
	 alert("hiiittt : "+strUser);
	
	$.ajax({
				type : 'GET',
				url : "/PCB/findAllAreaByProvinceNew/" + strUser,
				data : {},
				contentType : "application/json; charset=utf-8",
				success : function(data) {
					var slctSubcat = $('#area'), option = "<option value='NONE'>AREA</option><option value='ST'>STORES</option>";
					slctSubcat.empty();
					for (var i = 0; i < data.length; i++) {
						option = option
								+ "<option value='"+data[i].deptId + "'>"
								+ data[i].deptNm + "</option>";
					}
					slctSubcat.append(option);

					//alert("response.towerNo" + data);	
				}
			});

}

function findProvinceByDivision() {
	//var categoryId = $(this).val();
//	alert("hiii");
	var division = divison.options[divison.selectedIndex].value;
	/* if(division == "DD1"){
		division = "DISCO1";
	}else if(division == "DD2"){
		division = "DISCO2";
	}else if(division == "DD3"){
		division = "DISCO3";
	}
	else if(division == "DD4"){
		division = "DISCO4";
	}
	 */
	
	alert(division);
	
	//alert("hiiittt : "+strUser);
	//findAllAreaByProvinceNew

	$.ajax({
				type : 'GET',
				url : "/PCB/findAllProvincsPCB/" + division+"/",
				data : {},
				contentType : "application/json; charset=utf-8",
				success : function(data) {
					var slctSubcat = $('#province'), option = "<option value='NONE'>PROVINCE</option>";
					slctSubcat.empty();
					for (var i = 0; i < data.length; i++) {
						option = option
								+ "<option value='"+data[i].compId + "'>"
								+ data[i].compNm + "</option>";
					}
					slctSubcat.append(option);

					//alert("response.towerNo" + data);	
				}
			});

}

function viewLTL(){
	
	
	var strUser = txtManufactureLtl.options[txtManufactureLtl.selectedIndex].value;
	if(strUser=="Yes"){
		document.getElementById("txtManufactureBrand").value = "LTL";
	}else{
		document.getElementById("txtManufactureBrand").value = "";
	}
	
	//alert("hiiii");
}


function cal1(){

	if(document.getElementById("txtOilWeight").value != null){

	var wei = document.getElementById("txtOilWeight").value;
	var vol = wei / 0.86;
	var vol2 = vol.toFixed(2);
	alert("Volume of Oil : " + vol2);
	document.getElementById("txtVolumeOfOil").value=vol2;

	}
	}

	function cal2(){

	if(document.getElementById("txtVolumeOfOil").value != null){

	var volum =  document.getElementById("txtVolumeOfOil").value;
	var weig = volum * 0.86;
	var weig2 = weig.toFixed(2);
	alert("Oil Weight : " + weig2);
	document.getElementById("txtOilWeight").value=weig2;

	}

	}



	function viewResult(){

	var pcbRes =document.getElementById("txtPcbTestResults").value;
	var res = ((pcbRes * pcbRes ) * (-0.0004)) + ((3.4523 * pcbRes) - 9.2363);
	//var a1 = (pcbRes * pcbRes);
	//var a2 = a1 * -0.0004;
	//var a3 = 3.4523 * pcbRes;
	//var a4 = a3 - 9.2363;
	//var res = a2 + a4;
	var res2 = res.toFixed(2);
	//var res = pcbRes;
	alert("PCB Screening Result Aroclor 1260 : " + res2);
	document.getElementById("txtPcbAroclor").value=res2;

	}

	
</script>
</head>
<body onload="">
	<div id="theme-wrapper">
		<%@ include file="sections/header.jsp"%>

		<div id="page-wrapper" class="container">
			<div class="row">
				<%@ include file="sections/userLevels.jsp"%>

				<div id="content-wrapper">

					<div class="row">
						<div class="col-lg-12">
							<div class="col-lg-9">
								<ol class="breadcrumb">
									<li><a href="#">Home</a></li>
									<c:if test="${submitType == 'search'}">
										<li class="active"><span>Edit Equipment</span></li>
									</c:if>
									<c:if test="${submitType == 'update'}">
										<li class="active"><span>Update Equipment</span></li>
									</c:if>
								</ol>


							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="main-box">

								<div class="main-box-body clearfix">


									<c:if test="${submitType == 'search'}">

										<c:if test="${not empty success}">
											<tr>
												<td colspan="2" class="msgSuccess" align="center">

													<div class="msgSuccess"
														style="color: green; font-weight: bold;">
														<c:out value="${success}"></c:out>
													</div>
											</tr>
										</c:if>

										<c:if test="${not empty errormsg}">
											<tr>
												<td colspan="2" class="msgSuccess" align="center">

													<div class="msgSuccess"
														style="color: red; font-weight: bold;">
														<c:out value="${errormsg}"></c:out>
													</div>
											</tr>
										</c:if>

										<form:form role="form" action="goToUpdateEquipmentSampleNo"
											method="post" modelAttribute="EditEquipment">
											<h2 class="pull-left">
												<strong>Equipment Data</strong>
											</h2>

											<table class="table table-responsive" id="tblEquipment">
												<tbody>

<%-- 													<tr>
														<td width="50%" style="text-align: left">Reference No</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.referenceNo" type="text"
																class="form-control" id="txtEquipmentId" style="background-color: #fff981; border-radius: 5px;"
																placeholder="Enter Reference No" /> <span
															id="spnEquipmentId" class="label label-danger"></span></td>
														<td></td>

														<td>
															<div class="form-group">
																<div class="pull-left">
																	<input type="submit" Value="Search"
																		class="btn btn-success" />
																</div>
															</div>
														</td>

													</tr> --%>
													 <tr>
														<td width="50%" style="text-align: left">Sample No</td>
														<td width="70%" style="text-align: left"><form:input
															path="sampleNo" type="text" style="background-color: #94cb71; border-radius: 5px;"
															class="form-control" id="txtSamplingNu"
															placeholder="Enter Sampling Number" /> <span
														id="spnSamplingNu" class="label label-danger"></span></td>
													<td></td>

														<td>
															<div class="form-group">
																<div class="pull-left">
																	<input type="submit" Value="Search"
																		class="btn btn-success" />
																</div>
															</div>
														</td>

													</tr>

 													

												</tbody>
											</table>


											


										</form:form>
									</c:if>



									<c:if test="${submitType == 'update'}">

										<c:if test="${not empty success}">
											<tr>
												<td colspan="2" class="msgSuccess" align="center">

													<div class="msgSuccess"
														style="color: green; font-weight: bold;">
														<c:out value="${success}"></c:out>
													</div>
											</tr>
										</c:if>

										<form:form role="form" action="MMSaddEquipmentSamleNo" method="post"
											modelAttribute="EditEquipment">

											<table class="table table-responsive" id="tblEquipment">
												<tbody>
												
												<tr>
												 <td width="30%" style="text-align: left">Division</td>
														<td width="70%" style="text-align: left">
														<form:select id="divison" path="pcbEquipment.divison"
																onchange="findProvinceByDivision()"
																style="width:100%; background-color: #8187ff; border-radius: 5px;">
																<form:option value="NONE" label="DIVISION" />
																<form:options items="${EditEquipment.divList}" />
															</form:select>
															</td>
													</tr>
<tr>
														<td width="30%" style="text-align: left">Province</td>
														<td width="70%" style="text-align: left"><form:select id="province" path="pcbEquipment.branch"
																onchange="findArea()"
																style="width:100%; background-color: #8187ff; border-radius: 5px;">
																<form:option value="NONE" label="PROVINCE" />
																<form:options items="${EditEquipment.provinceList}" />
															</form:select>
															</td>
															</tr>
														<tr>
														<td width="30%" style="text-align: left">Area</td>
														<td width="70%" style="text-align: left"><form:select id="area" path="pcbEquipment.unit"
																style="width:100%; background-color: #8187ff; border-radius: 5px;">
																<form:option value="NONE" label="AREA" />
																
																<form:option value="ST" label="STORES" />
																<form:options items="${EditEquipment.areaList}" />
															</form:select>
															</td>
															</tr>

													<%-- <tr>
														<td width="50%" style="text-align: left">Reference No</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.referenceNo" type="text" style="background-color: #fff981; border-radius: 5px;"
																class="form-control" id="txtEquipmentId"
																placeholder="Enter Reference No" readonly="true" /> <span
															id="spnEquipmentId" class="label label-danger"></span></td>
														<td></td>
														<!--  <td>
															<div class="form-group">
																<div class="pull-left">
																	<input type="submit" Value=">>"
																		class="btn btn-success" />
																</div>
															</div>
														</td>
														 --> 

														<td>
															<div class="form-group">
																<div class="pull-left">
																	<input type="submit" Value="Update"
																		class="btn btn-success" />
																</div>
															</div>
														</td>

														<td>
															<div class="pull-left">
																<button type="button" class="btn btn-success"
																	onclick="window.location.href='editEquipment'">Back</button>
															</div>
														</td>
													</tr>
 --%>													 <tr>
														<td width="50%" style="text-align: left">Sample No</td>
														<td width="70%" style="text-align: left"><form:input
															path="sampleNo" type="text" style="background-color: #94cb71; border-radius: 5px;"
															class="form-control" id="txtSamplingNu"
															placeholder="Enter Sampling Number" /> <span
														id="spnSamplingNu" class="label label-danger"></span></td>
													<td></td>
														<!--  <td>
															<div class="form-group">
																<div class="pull-left">
																	<input type="submit" Value=">>"
																		class="btn btn-success" />
																</div>
															</div>
														</td>
														 --> 

														<td>
															<div class="form-group">
																<div class="pull-left">
																	<input type="submit" Value="Update"
																		class="btn btn-success" />
																</div>
															</div>
														</td>

														<td>
															<div class="pull-left">
																<button type="button" class="btn btn-success"
																	onclick="window.location.href='editEquipmentSampleNo'">Back</button>
															</div>
														</td>
													</tr>
 													
													<br>

													<tr>
														<td width="50%" style="text-align: left">Equipment Id</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.equipmentId" type="text"
																class="form-control" id="txtreferenceNo" style="background-color: #fff981; border-radius: 5px;"
																
																placeholder="Enter Equipment Id" /> <span
															id="spnReferenceNo" class="label label-danger"></span></td>
														<td></td>

														<td width="30%" style="text-align: left"><strong>Type</strong></td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.type" class="form-control" style="background-color: #fff981; border-radius: 5px;"
																
																id="txtType" placeholder="<< Select Type >>">
																<form:option value="-1"><< Select Type >></form:option>
																<form:option value="TR">Transformer</form:option>
																<form:option value="SB">Single Barrel</form:option>
																<form:option value="BL">Barrel Lot</form:option>
															</form:select> <span id="spnType" class="label label-danger"></span></td>

													</tr>

													<%-- <tr>
														<td width="30%" style="text-align: left">Branch</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.branch" type="text" style="background-color: #fff981; border-radius: 5px;"
																
																class="form-control" id="txtBranch"
																placeholder="Enter Brnach" /> <span id="spnBranch"
															class="label label-danger"></span></td>
														<td></td>

														<td width="30%" style="text-align: left"><strong>Unit</strong></td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.unit" type="text" style="background-color: #fff981; border-radius: 5px;"
																
																class="form-control" id="txtUnit"
																placeholder="Enter Unit" /> <span id="spnUnit"
															class="label label-danger"></span></td>
													</tr>
 --%>
													<tr>
														<td width="30%" style="text-align: left">Condition</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.condition" class="form-control" style="background-color: #fff981; border-radius: 5px;"
																
																id="txtStatus" placeholder="<< Select Condition >>">
																<form:option value="In Use">In Use</form:option>
																<form:option value="Abandoned">Abandoned</form:option>
																<form:option value="Spare">Spare</form:option>
															
															</form:select> <span id="spnStatus" class="label label-danger"></span></td>
														<td></td>
														<td width="30%" style="text-align: left">Status</td>
													<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.status" class="form-control" style="background-color: #8187ff; border-radius: 5px;"
																id="txtSampleSatisified" placeholder="<< Yes / No >>">
																<form:option value="2">Active</form:option>
															<form:option value="3">In Active</form:option>
															</form:select> <span id="spnSampleSatisified" class="label label-danger"></span></td>
															<td></td>
												
														</tr>
														<tr>
														<td width="30%" style="text-align: left">Sin No</td>
													<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.sinNo" type="text" style="background-color: #fff981; border-radius: 5px;"
																class="form-control" id="txtSinNo"/> <span
															id="spnSinNo" class="label label-danger"></span></td>
															<td></td>
												
														</tr>
												
														<tr>
														<td width="50%" style="text-align: left">Reference No</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.referenceNo" type="text" style="background-color: #fff981; border-radius: 5px;"
																class="form-control" id="txtReferenceNo"
																placeholder="Enter Reference No"/> <span
															id="spnReferenceNo" class="label label-danger"></span></td>
														<td></td>
													</tr>
														 </tbody>
														</table>
														
														
														<!-- Location Details data -------------------------------------------------------------------------------------->
											<br>
											<h2 class="pull-left">
												<strong>Location Details</strong>
											</h2>

											<table class="table table-responsive" id="tblPcbLocation">
												<tbody>
													<tr>
														<td width="30%" style="text-align: left">Location
															Description</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbLocation.locationDescription" type="text" style="background-color: #94cb71; border-radius: 5px;"
																class="form-control" id="txtLocationDescription"
																placeholder="Enter Location Description" /> <span
															id="spnLocationDescription" class="label label-danger"></span></td>
														
														<td width="30%" style="text-align: left"><strong>Mounting (Pole/Plinth/Ground)</strong></td>
														<%-- <td width="70%" style="text-align: left"><form:input
																path="pcbLocation.mounting" type="text"
																class="form-control" id="txtMounting"
																placeholder="Enter Mounting" /> <span id="spnMounting"
															class="label label-danger"></span></td>
													 --%>
													 <td width="70%" style="text-align: left"><form:select
																path="pcbLocation.mounting" class="form-control" style="background-color: #94cb71; border-radius: 5px;"
																id="txtSampleSatisified" placeholder="<< Pole / Plinth / Ground >>">
																<form:option value="-1"><< Pole / Plinth / Ground >></form:option>
																<form:option value="Pole">Pole</form:option>
																<form:option value="Plinth">Plinth</form:option>
																<form:option value="Ground">Ground</form:option>
															</form:select> <span id="spnSampleSatisified" class="label label-danger"></span></td>
													
													 
													 </tr>
													<tr>
													<td width="30%" style="text-align: left">GPS location
															(Latitude)</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbLocation.gpsLatitude" type="text" style="background-color: #94cb71; border-radius: 5px;"
																class="form-control" id="txtGpsLatitude"
																placeholder="Enter GPS location (Latitude)" /> <span
															id="spnGpsLatitude" class="label label-danger"></span></td>
													
														
														<td width="30%" style="text-align: left"><strong>GPS
																location (Longitude)</strong></td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbLocation.gpsLongitude" type="text" style="background-color: #94cb71; border-radius: 5px;"
																class="form-control" id="txtGpsLongitude"
																placeholder="Enter GPS location (Longitude)" /> <span
															id="spnGpsLongitude" class="label label-danger"></span></td>

													</tr>



													<tr>
														<td width="30%" style="text-align: left">Type of
															Located</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbLocation.typeOfLocated" class="form-control" style="background-color: #94cb71; border-radius: 5px;"
																id="txtTypeOfLocated"
																placeholder="<< Select Seal Type >>">
																<form:option value="-1"><< Select Type of Located  >></form:option>
																<form:option value="Indoor">Indoor</form:option>
																<form:option value="Outdoor">Outdoor</form:option>
															</form:select> <span id="spnTypeOfLocated" class="label label-danger"></span></td>
														</tr>


												</tbody>
											</table>
											<br>
											<h2 class="pull-left">
												<strong>Information Related to Sampling</strong>
											</h2>
												<table class="table table-responsive" id="tblEquipment5">
												<tbody>
												
												<tr>
												<td width="30%" style="text-align: left">Manufacture
															Year</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.year" type="text" style="background-color: #fff981; border-radius: 5px;"
																
																class="form-control" id="txtManufactureDate"
																placeholder="Select Manufacture Year" /> <span
															id="spnManufactureDate" class="label label-danger"></span></td>
														
												</tr>
												<tr>
													
													<td width="30%" style="text-align: left">Manufacturer
															LTL ?</td>
														<td width="70%" style="text-align: left"><form:select onchange="viewLTL()"
																path="pcbEquipment.manufactureLtl" class="form-control" style="background-color: #fff981; border-radius: 5px;"
																
																id="txtManufactureLtl" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnManufactureLtl" class="label label-danger"></span></td>
														<td></td>
													
														<td width="30%" style="text-align: left">Manufacture
															Brand</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.manufactureBrand" type="text" style="background-color: #fff981; border-radius: 5px;"
																
																class="form-control" id="txtManufactureBrand"
																placeholder="Enter Manufacture Barnd" /> <span
															id="spnManufactureBrand" class="label label-danger"></span></td>
														<td></td>

														
														<%-- <td width="70%" style="text-align: left"><form:input
															path="photoTaken" type="text" class="form-control"
															id="txtPhotoTaken" placeholder="Enter Photo Taken" /> <span
														id="spnPhotoTaken" class="label label-danger"></span></td> --%>
													</tr>
												<tr>
												<td width="30%" style="text-align: left"><strong>Seal
																Type</strong></td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.seriaType" class="form-control" style="background-color: #fff981; border-radius: 5px;"
																
																id="txtSeriaType" placeholder="<< Select Seal Type >>">
																<form:option value="-1"><< Select Seal Type >></form:option>
																<form:option value="Seal">Seal</form:option>
																<form:option value="None-Seal">None-Seal</form:option>
															</form:select> <span id="spnSeriaType" class="label label-danger"></span></td>
												<td></td>
												<td width="30%" style="text-align: left"><strong>Primary
																Sub</strong></td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.primarySub" class="form-control" style="background-color: #fff981; border-radius: 5px;"
																
																id="txtPrimarySub" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnPrimarySub" class="label label-danger"></span></td>
													
												
												</tr>
												
												<tr>
												<td width="30%" style="text-align: left">Sampling Port</td>
													<%-- <td width="70%" style="text-align: left"><form:input
															path="pcbSample.samplingPort" type="text"
															class="form-control" id="txtSamplingPort"
															placeholder="Enter Sampling Port" /> <span
														id="spnSamplingPort" class="label label-danger"></span></td> --%>

													<td width="70%" style="text-align: left"><form:select
															path="pcbSample.samplingPort" class="form-control" style="background-color: #94cb71; border-radius: 5px;"
															id="txtSamplingPort" placeholder="<< Top / Bottom >>">
															<form:option value="-1"><< Top / Bottom >></form:option>
															<form:option value="Top">Top</form:option>
															<form:option value="Bottom">Bottom</form:option>
														</form:select> <span id="spnSamplingPort" class="label label-danger"></span></td>
												<td></td>
												
												<td width="30%" style="text-align: left"><strong>Extracted
															from top</strong></td>
													<td width="70%" style="text-align: left"><form:select
																path="pcbSample.extractedTop" class="form-control" style="background-color: #94cb71; border-radius: 5px;"
																id="txtextractedTop" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Top / Bottom >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnExtractedTop" class="label label-danger"></span></td>
												
												</tr>
												<tr>
												<td width="30%" style="text-align: left"><strong>Sampling
														Logic Satisfied</strong></td>
													<td width="70%" style="text-align: left"><form:select
																path="pcbSample.sampleSatisified" class="form-control" style="background-color: #94cb71; border-radius: 5px;"
																id="txtSampleSatisified" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnSampleSatisified" class="label label-danger"></span></td>
														<td></td>
											
												</tr>
												
												<tr>
													<td width="30%" style="text-align: left">Sampling
														Number</td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbSample.samplingNu" type="text" style="background-color: #94cb71; border-radius: 5px;"
															class="form-control" id="txtSamplingNu"
															placeholder="Enter Sampling Number" /> <span
														id="spnSamplingNu" class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Sample
															Date </strong></td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbSample.sampleDate"  maxlength="10"  style="background-color: #94cb71; border-radius: 5px;"
															class="form-control" id="txtSampleDate"
															placeholder="Enter Sample date" /> <span
														id="spnSampleDate" class="label label-danger"></span></td>
												</tr>
												
												
												
											</tbody>
											</table>
											
														
														<br>
											<h2 class="pull-left">
												<strong>Additional Details</strong>
											</h2>
														
														
														
														<table class="table table-responsive" id="tblEquipment1">
												<tbody>
											
														<tr>
														<td width="30%" style="text-align: left"><strong>Photo
																Taken</strong></td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.photoTaken" class="form-control" style="background-color: #fff981; border-radius: 5px;"
																
																id="txtPhotoTaken" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnPhotoTaken" class="label label-danger"></span></td>
														<td></td>

														<td width="30%" style="text-align: left"><strong>Photo
																Ref 1</strong></td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.photoRef" type="text" style="background-color: #fff981; border-radius: 5px;"
																
																class="form-control" id="txtName"
																placeholder="Enter Photo Ref." /> <span id="spnName"
															class="label label-danger"></span></td>
													</tr>
													<tr>
													<td width="30%" style="text-align: left"><strong>Photo
																Ref 2</strong></td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.photoRef2" type="text" style="background-color: #fff981; border-radius: 5px;"
																
																class="form-control" id="txtName"
																placeholder="Enter Photo Ref." /> <span id="spnName"
															class="label label-danger"></span></td>
															<td></td>
															
															<td width="30%" style="text-align: left"><strong>Photo
																Ref 3</strong></td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.photoRef3" type="text" style="background-color: #fff981; border-radius: 5px;"
																
																class="form-control" id="txtName"
																placeholder="Enter Photo Ref." /> <span id="spnName"
															class="label label-danger"></span></td>
													
													
													</tr>

													<tr>
														<td width="30%" style="text-align: left"><strong>Weight of
															Transformer (Kg)</strong></td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.weightTransformer" type="number" style="background-color: #fff981; border-radius: 5px;"
																
																class="form-control" id="txtWeightTransformer"
																placeholder="Enter Weight" /> <span
															id="spnWeightTransformer" class="label label-danger"></span></td>
														<td></td>

														<td width="30%" style="text-align: left"><strong>Volume
of Oil (L)</strong></td>
<td width="70%" style="text-align: left"><form:input
path="pcbEquipment.volOil" type="number" step="any" onchange="cal2()"  style="background-color: #fff981; border-radius: 5px;"

class="form-control" id="txtVolumeOfOil"
placeholder="Enter Volume of Oil" /> <span
id="spnVolumeOfOil" class="label label-danger"></span></td>
</tr>

													
													<tr>
														<td width="30%" style="text-align: left">Oil Weight(Kg)</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.oilWeight" type="number" step="any" onchange="cal1()" style="background-color: #fff981; border-radius: 5px;"
																
																class="form-control" id="txtOilWeight"
																placeholder="Enter Oil Weight" /> <span
															id="spnOilWeight" class="label label-danger"></span></td>
														<td></td>

														<td width="30%" style="text-align: left"><strong>Capacity (kVA)</strong></td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.capacity" type="number" style="background-color: #fff981; border-radius: 5px;"
																
																class="form-control" id="txtCapacity"
																placeholder="Enter Capacity" /> <span id="spnCapacity"
															class="label label-danger"></span></td>
													</tr>

													<tr>
														<td width="30%" style="text-align: left">(Primary/Secondary)  Voltage (kV)</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.voltage" class="form-control" style="background-color: #fff981; border-radius: 5px;"
																
																id="txtVoltage" placeholder="<< Please select>>">
																<form:option value="-1"><< Please select >></form:option>
																<form:option value="220">220</form:option>
																<form:option value="132">132</form:option>
																<form:option value="33">33</form:option>
																<form:option value="11">11</form:option>
																
															</form:select> <span id="spnVoltage" class="label label-danger"></span></td>
																												<td></td>

														<td width="30%" style="text-align: left"><strong>Serial
																Number</strong></td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.serialNo" type="text" style="background-color: #fff981; border-radius: 5px;"
																
																class="form-control" id="txtSerialNo"
																placeholder="Enter Serial Number" /> <span
															id="spnSerialNo" class="label label-danger"></span></td>
													</tr>

													
													<!-- <tr>
													 -->	<%-- <td width="50%" style="text-align: left">Category</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.divison" class="form-control" style="background-color: #fff981; border-radius: 5px;"
																
																id="txtDivison" placeholder="<< Select Division >>">


																<c:choose>

																	<c:when
																		test="${EditEquipment.pcbEquipment.divison == null}">
																		<form:option value="-1" label="<< Select Division >>" />
																	</c:when>

																	<c:otherwise>
																		<c:forEach var="divisionList"
																			items="${EditEquipment.divisionList}">
																			<c:if
																				test="${divisionList.id == EditEquipment.pcbEquipment.divison}">
																				<option id="${divisionList.id}" selected="selected"
																					value="${divisionList.id}">${divisionList.name}</option>
																			</c:if>
																		</c:forEach>
																	</c:otherwise>

																</c:choose>

																<c:forEach var="divisionList"
																	items="${EditEquipment.divisionList}">
																	<c:if
																		test="${divisionList.id != EditEquipment.pcbEquipment.divison}">
																		<option id="${divisionList.id}"
																			value="${divisionList.id}">${divisionList.name}</option>
																	</c:if>
																</c:forEach>


															</form:select> <span id="spnDivison" class="label label-danger"></span></td>
 --%>														<!-- <td></td>
 -->
														<%-- <td width="30%" style="text-align: left"><strong>Primary
																Sub</strong></td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.primarySub" class="form-control" style="background-color: #fff981; border-radius: 5px;"
																
																id="txtPrimarySub" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnPrimarySub" class="label label-danger"></span></td>
													</tr>

 --%>													<tr>
 
  
														<td></td>
													
														
													</tr>

																									</tbody>
											</table>


											<!-- pcb condition data -------------------------------------------------------------------------------------->
											<br>
											<h2 class="pull-left">
												<strong>Condition of the Transformer</strong>
											</h2>

											<table class="table table-responsive" id="tblConditionData">
												<tbody>

													<tr>
													
													<td width="30%" style="text-align: left"><strong>Oil
																Leaks Present</strong></td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbCondition.oilLeaksPresent" class="form-control" style="background-color: #8187ff; border-radius: 5px;"
																id="txtOilLeaksPresent" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnOilLeaksPresent" class="label label-danger"></span></td>
												<td></td>
												<td width="30%" style="text-align: left">Corrosion</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbCondition.corrosion" class="form-control" style="background-color: #8187ff; border-radius: 5px;"
																id="txtCorrosion" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnCorrosion" class="label label-danger"></span></td>
												</tr>
												<tr>
														
														
														<td width="30%" style="text-align: left"><strong>Burn
																Marks</strong></td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbCondition.burnMask" class="form-control" style="background-color: #8187ff; border-radius: 5px;"
																id="txtBurnMask" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnBurnMask" class="label label-danger"></span></td>
														<td></td>
														
														<td width="30%" style="text-align: left"><strong>Terminal/Connection
																Attention</strong></td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbCondition.terminalAttention"
																class="form-control" id="txtTerminalAttention" style="background-color: #8187ff; border-radius: 5px;"
																placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnTerminalAttention"
															class="label label-danger"></span></td>
													</tr>
													<tr>
													
													
													<td width="30%" style="text-align: left">Overloaded Signs
															Present</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbCondition.overloadPresent" class="form-control" style="background-color: #8187ff; border-radius: 5px;"
																id="txtOverloadPresent" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnOverloadPresent" class="label label-danger"></span></td>
														<td></td>
													<td width="30%" style="text-align: left"><strong>Earth
																Connection is properly done</strong></td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbCondition.earthConnection" class="form-control" style="background-color: #8187ff; border-radius: 5px;"
																id="txtEarthConnection" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnEarthConnection" class="label label-danger"></span></td>
												
															</tr>

													
													<tr>
														<td width="30%" style="text-align: left">Lighting
															Arresters are properly done</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbCondition.lightingArrestersDone" style="background-color: #8187ff; border-radius: 5px;"
																class="form-control" id="txtLightingArrestersDone"
																placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnLightingArrestersDone"
															class="label label-danger"></span></td>
														<td></td>
<td width="30%" style="text-align: left">Breather is in Good Condition</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbCondition.breatherIsGoodConnection" style="background-color: #8187ff; border-radius: 5px;"
																
																class="form-control" id="txtBreatherIsGoodConnection"
																placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnBreatherIsGoodConnection"
															class="label label-danger"></span></td>
													
													
															</tr>

													
												</tbody>
											</table>



											<!-- pcb sample data -------------------------------------------------------------------------------------->
										<br>
										<h2 class="pull-left">
											<strong>Pcb Sample Data</strong>
										</h2>

										<table class="table table-responsive" id="tblPcbSample">
											<tbody>
												
												<tr>
<td width="30%" style="text-align: left">PCB Screening Instrument Reading</td>
<td width="70%" style="text-align: left"><form:input
path="pcbSample.pcbTestData" type="number" step="any" style="background-color: #94cb71; border-radius: 5px;"
class="form-control" id="txtPcbTestResults" onchange="viewResult()"
placeholder="Enter PCB Test Results" /> <span
id="spnPcbTestResults" class="label label-danger"></span></td>

<td></td>

<td width="30%" style="text-align: left"><strong>PCB Screening Result Aroclor 1260</strong></td>
<td width="70%" style="text-align: left"><form:input
path="pcbSample.pcbTestDataAroclor" type="number" step="any" style="background-color: #94cb71; border-radius: 5px;"
class="form-control" id="txtPcbAroclor"
placeholder="Enter PCB Test Results" /> <span
id="spnPcbTestResults" class="label label-danger"></span></td>


</tr>

												
												<tr>
													<td width="30%" style="text-align: left">EPF Numbers
														of the Test Group</td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbSample.epfNoTestGroup" type="text" style="background-color: #94cb71; border-radius: 5px;"
															class="form-control" id="txtEpfNoTestGroup"
															placeholder="Enter EPF Number" /> <span
														id="spnEpfNoTestGroup" class="label label-danger"></span></td>
													<td></td>
<td width="30%" style="text-align: left"><strong>EPF
															Numbers of the Group</strong></td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbSample.epfNoGroup" type="text" style="background-color: #94cb71; border-radius: 5px;"
															class="form-control" id="txtEpfNoGroup"
															placeholder="Enter EPF Number" /> <span
														id="spnEpfNoGroup" class="label label-danger"></span></td>
												
													</tr>

																								<tr>
																								
																								<td width="30%" style="text-align: left"><strong>PCB
															Test date</strong></td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbSample.pcbTestDate" 
															maxlength="10"
															style="background-color: #94cb71; border-radius: 5px;"
															class="form-control" id="txtPcbTestDate"
															placeholder="Enter PCB Test date" /> <span
														id="spnPcbTestDate" class="label label-danger"></span></td>
<td></td>

																								
														</tr>
												
												<tr>
													<td width="30%" style="text-align: left">Remarks</td>
													<td width="70%" style="text-align: left"><form:textarea rows="5" cols="60"
															path="pcbSample.remarks" type="text" class="form-control" style="background-color: #94cb71; border-radius: 5px;"
															id="txtRemarks" placeholder="Enter Remark" /> <span
														id="spnRemarks" class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Test
															Remarks</strong></td>
													<td width="70%" style="text-align: left"><form:textarea rows="5" cols="60"
															path="pcbSample.testRemarks" type="text" style="background-color: #94cb71; border-radius: 5px;"
															class="form-control" id="txtTestRemarks"
															placeholder="Enter Remark" /> <span id="spnTestRemarks"
														class="label label-danger"></span></td>
												</tr>

												

											</tbody>
										</table>


											

																						
										<!-- ITI data -------------------------------------------------------------------------------------->
										<br>
										<h2 class="pull-left">
											<strong>ITI</strong>
										</h2>

										<table class="table table-responsive" id="tblPcbSample">
											<tbody>
												<tr>
													<%-- <td width="30%" style="text-align: left">Sent to
														ITI</td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbEquipment.sentToIti" type="text" style="background-color: #8187ff; border-radius: 5px;"
															class="form-control" id="txtSamplingNu"
															placeholder="Enter ITI" /> <span
														id="spnSamplingNu" class="label label-danger"></span></td>
													 --%>
													
													<td width="30%" style="text-align: left">Sent to ITI</td>
													<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.sentToIti" class="form-control" style="background-color: #8187ff; border-radius: 5px;"
																id="txtSampleSatisified" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnSamplingNu" class="label label-danger"></span></td>
															<td></td>
																									<td width="30%" style="text-align: left"><strong>ITI
															Results</strong></td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbEquipment.itiResults" type="text" style="background-color: #8187ff; border-radius: 5px;"
															class="form-control" id="txtEpfNoGroup"
															placeholder="Enter ITI Results" /> <span
														id="spnEpfNoGroup" class="label label-danger"></span></td>
												</tr>

												<tr>
													
													<td width="30%" style="text-align: left">ITI confirmed
														Positive</td>
													<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.itiConfPositive" class="form-control" style="background-color: #8187ff; border-radius: 5px;"
																id="txtSampleSatisified" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnSamplingNu" class="label label-danger"></span></td>
													
													
													
													
													<%-- <td width="30%" style="text-align: left">ITI confirmed
														Positive</td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbEquipment.itiConfPositive" type="text" style="background-color: #8187ff; border-radius: 5px;"
															class="form-control" id="txtPcbTestResults"
															placeholder="Enter ITI Status" /> <span
														id="spnPcbTestResults" class="label label-danger"></span></td>
 --%>
													<td></td>

												</tr>
												
												<tr>
												<td width="30%" style="text-align: left">Completed</td>
													<td width="70%" style="text-align: left"><form:select
																path="pcbSample.completed" class="form-control" style="background-color: #8187ff; border-radius: 5px;"
																id="txtSampleSatisified" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnSampleSatisified" class="label label-danger"></span></td>
															<td></td>
														
														<td width="30%" style="text-align: left">Test Lab</td>
												
														<td width="70%" style="text-align: left"><form:select
																path="pcbSample.testLab" class="form-control" style="background-color: #8187ff; border-radius: 5px;"
																id="txtSampleSatisified" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Colombo / Kandy >></form:option>
																<form:option value="Colombo">Colombo</form:option>
																<form:option value="Kandy">Kandy</form:option>
															</form:select> <span id="spnSampleSatisified" class="label label-danger"></span></td>
														
													<%-- <td width="30%" style="text-align: left"><strong>Test Lab</strong></td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbSample.testLab" type="text" style="background-color: #8187ff; border-radius: 5px;"
															class="form-control" id="txtPcbTestDate"
															placeholder="Enter Test Lab" /> <span
														id="spnPcbTestDate" class="label label-danger"></span></td>
													 --%>
												</tr>
												
											</tbody>
										</table>
										
										<!---------------------------------------------------------------->
											

										</form:form>
									</c:if>
									<!-- <div class="form-group">
											<div class="pull-left">
											
												<input type="submit" Value="Add" class="btn btn-success" />
												
												<button type="button" class="btn btn-warning" onclick="window.location.href='displayLine'">Edit</button>
											</div>
										</div> -->


								</div>
							</div>
						</div>

					</div>



				</div>
			</div>
		</div>
	</div>
	<%@ include file="sections/footer.jsp"%>
	<%@ include file="sections/global_scripts.jsp"%>
	
	<script>
$(document).ready(function() {
$('#sampleDate').datepicker({
format: "yyyy-mm-dd",
//startDate: new Date(), //to disable past dates
endDate: new Date() //to disable future dates
});
});
</body>
</html>
