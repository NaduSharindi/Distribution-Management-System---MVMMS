<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@ include file="sections/head.jsp"%>

<script type="text/javascript">
	
</script>
</head>
<body onload="">
	<div id="theme-wrapper">
		<%@ include file="sections/PCBheader.jsp"%>

		<div id="page-wrapper" class="container">
			<div class="row">
				<%@ include file="sections/PCBuserLevels.jsp"%>

				<div id="content-wrapper">

					<div class="row">
						<div class="col-lg-12">
							<div class="col-lg-9">
								<ol class="breadcrumb">
									<li><a href="#">Home</a></li>
									<li class="active"><span>Add Equipment</span></li>
								</ol>


							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="main-box">

								<div class="main-box-body clearfix">

									<c:if test="${not empty success}">
										<tr>
											<td colspan="2" class="msgSuccess" align="center">

												<div class="msgSuccess"
													style="color: green; font-weight: bold;">
													<c:out value="${success}"></c:out>
												</div>
										</tr>
									</c:if>


									<form:form role="form" action="MMSaddEquipment" method="post"
										modelAttribute="SaveEquipment">

										<table class="table table-responsive" id="tblEquipment">
											<tbody>
												<h2 class="pull-left">
													<strong>Equipment Data</strong>
												</h2>

												<tr>
													<td width="50%" style="text-align: left">Reference
														Number</td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbEquipment.referenceNo" type="text"
															class="form-control" id="txtreferenceNo"
															placeholder="Enter Reference Number" /> <span
														id="spnReferenceNo" class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Type</strong></td>
													<td width="70%" style="text-align: left"><form:select
															path="pcbEquipment.type" class="form-control"
															id="txtType" placeholder="<< Select Type >>">
															<form:option value="-1"><< Select Type >></form:option>
															<form:option value="TR">Transformer</form:option>
															<form:option value="SB">Single Barrel</form:option>
															<form:option value="BL">Barrel Lot</form:option>
														</form:select> <span id="spnType" class="label label-danger"></span></td>

												</tr>

												<tr>
													<td width="30%" style="text-align: left">Branch</td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbEquipment.branch" type="text"
															class="form-control" id="txtBranch"
															placeholder="Enter Brnach" /> <span id="spnBranch"
														class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Unit</strong></td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbEquipment.unit" type="text" class="form-control"
															id="txtUnit" placeholder="Enter Unit" /> <span
														id="spnUnit" class="label label-danger"></span></td>
												</tr>

												<tr>
													<td width="30%" style="text-align: left">Condition</td>
													<td width="70%" style="text-align: left"><form:select
															path="pcbEquipment.condition" class="form-control"
															id="txtStatus" placeholder="<< Select Condition >>">
															<form:option value="-1"><< Select Condition >></form:option>
															<form:option value="2">In Use</form:option>
															<form:option value="0">Abandoned</form:option>
														</form:select> <span id="spnStatus" class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Photo
															Ref.</strong></td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbEquipment.photoRef" type="text"
															class="form-control" id="txtName"
															placeholder="Enter Photo Ref." /> <span id="spnName"
														class="label label-danger"></span></td>
												</tr>

												<tr>
													<td width="30%" style="text-align: left">Weight of
														Transformer</td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbEquipment.weightTransformer" type="number"
															class="form-control" id="txtWeightTransformer"
															placeholder="Enter Weight" /> <span
														id="spnWeightTransformer" class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Volume
															of Oil</strong></td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbEquipment.volumeOfOil" type="number"
															class="form-control" id="txtVolumeOfOil"
															placeholder="Enter Volume of Oil" /> <span
														id="spnVolumeOfOil" class="label label-danger"></span></td>
												</tr>

												<tr>
													<td width="30%" style="text-align: left">Oil Weight</td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbEquipment.oilWeight" type="number"
															class="form-control" id="txtOilWeight"
															placeholder="Enter Oil Weight" /> <span
														id="spnOilWeight" class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Capacity
															(kVA Rating)</strong></td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbEquipment.capacity" type="number"
															class="form-control" id="txtCapacity"
															placeholder="Enter Capacity" /> <span id="spnCapacity"
														class="label label-danger"></span></td>
												</tr>

												<tr>
													<td width="30%" style="text-align: left">Voltage</td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbEquipment.voltage" type="number"
															class="form-control" id="txtVoltage"
															placeholder="Enter Voltage" /> <span id="spnVoltage"
														class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Serial
															Number</strong></td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbEquipment.serialNo" type="text"
															class="form-control" id="txtSerialNo"
															placeholder="Enter Serial Number" /> <span
														id="spnSerialNo" class="label label-danger"></span></td>
												</tr>

												<tr>
													<td width="30%" style="text-align: left">Manufacture
														Barnd</td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbEquipment.manufactureBrand" type="text"
															class="form-control" id="txtManufactureBrand"
															placeholder="Enter Manufacture Brand" /> <span
														id="spnManufactureBrand" class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Photo
															Taken</strong></td>
													<td width="70%" style="text-align: left"><form:select
															path="pcbEquipment.photoTaken" class="form-control"
															id="txtPhotoTaken" placeholder="<< Yes / No >>">
															<form:option value="-1"><< Yes / No >></form:option>
															<form:option value="Yes">Yes</form:option>
															<form:option value="No">No</form:option>
														</form:select> <span id="spnPhotoTaken" class="label label-danger"></span></td>

													<%-- <td width="70%" style="text-align: left"><form:input
															path="photoTaken" type="text" class="form-control"
															id="txtPhotoTaken" placeholder="Enter Photo Taken" /> <span
														id="spnPhotoTaken" class="label label-danger"></span></td> --%>
												</tr>

												<tr>
													<td width="50%" style="text-align: left">Category</td>
													<td width="70%" style="text-align: left"><form:select
															path="pcbEquipment.divison" class="form-control"
															id="txtDivison" placeholder="<< Select Category >>">


															<c:choose>

																<c:when
																	test="${SaveEquipment.pcbEquipment.divison == null}">
																	<form:option value="-1" label="<< Select Category >>" />
																</c:when>

																<c:otherwise>
																	<c:forEach var="divisionList"
																		items="${SaveEquipment.divisionList}">
																		<c:if
																			test="${divisionList.id == SaveEquipment.pcbEquipment.divison}">
																			<option id="${divisionList.id}" selected="selected"
																				value="${divisionList.id}">${divisionList.name}</option>
																		</c:if>
																	</c:forEach>
																</c:otherwise>

															</c:choose>

															<c:forEach var="divisionList"
																items="${SaveEquipment.divisionList}">
																<c:if
																	test="${divisionList.id != SaveEquipment.pcbEquipment.divison}">
																	<option id="${divisionList.id}"
																		value="${divisionList.id}">${divisionList.name}</option>
																</c:if>
															</c:forEach>


														</form:select> <span id="spnDivison" class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Primary
															Sub</strong></td>
													<td width="70%" style="text-align: left"><form:select
															path="pcbEquipment.primarySub" class="form-control"
															id="txtPrimarySub" placeholder="<< Yes / No >>">
															<form:option value="-1"><< Yes / No >></form:option>
															<form:option value="Yes">Yes</form:option>
															<form:option value="No">No</form:option>
														</form:select> <span id="spnPrimarySub" class="label label-danger"></span></td>
												</tr>

												<tr>
													<td width="30%" style="text-align: left">Manufacture
														LTL</td>
													<td width="70%" style="text-align: left"><form:select
															path="pcbEquipment.manufactureLtl" class="form-control"
															id="txtManufactureLtl" placeholder="<< Yes / No >>">
															<form:option value="-1"><< Yes / No >></form:option>
															<form:option value="Yes">Yes</form:option>
															<form:option value="No">No</form:option>
														</form:select> <span id="spnManufactureLtl" class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Seal
															Type</strong></td>
													<td width="70%" style="text-align: left"><form:select
															path="pcbEquipment.seriaType" class="form-control"
															id="txtSeriaType" placeholder="<< Select Seal Type >>">
															<form:option value="-1"><< Select Seal Type >></form:option>
															<form:option value="Seal">Seal 
																</form:option>
															<form:option value="None-Seal">None-Seal</form:option>
														</form:select> <span id="spnSeriaType" class="label label-danger"></span></td>

												</tr>

												<tr>
													<td width="30%" style="text-align: left">Manufacture
														Date</td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbEquipment.manufactureDate" type="date"
															class="form-control" id="txtManufactureDate"
															placeholder="Select Manufacture Date" /> <span
														id="spnManufactureDate" class="label label-danger"></span></td>
													<td></td>

												</tr>

											</tbody>
										</table>



										<!-- pcb condition data -------------------------------------------------------------------------------------->
										<br>
										<h2 class="pull-left">
											<strong>Pcb Condition Data</strong>
										</h2>

										<table class="table table-responsive" id="tblConditionData">
											<tbody>

												<tr>
													<td width="30%" style="text-align: left">Breather Is
														Good Connection</td>
													<td width="70%" style="text-align: left"><form:select
															path="pcbCondition.breatherIsGoodConnection"
															class="form-control" id="txtBreatherIsGoodConnection"
															placeholder="<< Yes / No >>">
															<form:option value="-1"><< Yes / No >></form:option>
															<form:option value="Yes">Yes</form:option>
															<form:option value="No">No</form:option>
														</form:select> <span id="spnBreatherIsGoodConnection"
														class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Burn
															Mark</strong></td>
													<td width="70%" style="text-align: left"><form:select
															path="pcbCondition.burnMask" class="form-control"
															id="txtBurnMask" placeholder="<< Yes / No >>">
															<form:option value="-1"><< Yes / No >></form:option>
															<form:option value="Yes">Yes</form:option>
															<form:option value="No">No</form:option>
														</form:select> <span id="spnBurnMask" class="label label-danger"></span></td>
												</tr>

												<tr>
													<td width="30%" style="text-align: left">Corrosion</td>
													<td width="70%" style="text-align: left"><form:select
															path="pcbCondition.corrosion" class="form-control"
															id="txtCorrosion" placeholder="<< Yes / No >>">
															<form:option value="-1"><< Yes / No >></form:option>
															<form:option value="Yes">Yes</form:option>
															<form:option value="No">No</form:option>
														</form:select> <span id="spnCorrosion" class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Earth
															Connection</strong></td>
													<td width="70%" style="text-align: left"><form:select
															path="pcbCondition.earthConnection" class="form-control"
															id="txtEarthConnection" placeholder="<< Yes / No >>">
															<form:option value="-1"><< Yes / No >></form:option>
															<form:option value="Yes">Yes</form:option>
															<form:option value="No">No</form:option>
														</form:select> <span id="spnEarthConnection" class="label label-danger"></span></td>
												</tr>

												<tr>
													<td width="30%" style="text-align: left">Lighting
														Arresters Done</td>
													<td width="70%" style="text-align: left"><form:select
															path="pcbCondition.lightingArrestersDone"
															class="form-control" id="txtLightingArrestersDone"
															placeholder="<< Yes / No >>">
															<form:option value="-1"><< Yes / No >></form:option>
															<form:option value="Yes">Yes</form:option>
															<form:option value="No">No</form:option>
														</form:select> <span id="spnLightingArrestersDone"
														class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Oil
															Leaks Present</strong></td>
													<td width="70%" style="text-align: left"><form:select
															path="pcbCondition.oilLeaksPresent" class="form-control"
															id="txtOilLeaksPresent" placeholder="<< Yes / No >>">
															<form:option value="-1"><< Yes / No >></form:option>
															<form:option value="Yes">Yes</form:option>
															<form:option value="No">No</form:option>
														</form:select> <span id="spnOilLeaksPresent" class="label label-danger"></span></td>
												</tr>

												<tr>
													<td width="30%" style="text-align: left">Overload
														Present</td>
													<td width="70%" style="text-align: left"><form:select
															path="pcbCondition.overloadPresent" class="form-control"
															id="txtOverloadPresent" placeholder="<< Yes / No >>">
															<form:option value="-1"><< Yes / No >></form:option>
															<form:option value="Yes">Yes</form:option>
															<form:option value="No">No</form:option>
														</form:select> <span id="spnOverloadPresent" class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Terminal
															Attention</strong></td>
													<td width="70%" style="text-align: left"><form:select
															path="pcbCondition.terminalAttention"
															class="form-control" id="txtTerminalAttention"
															placeholder="<< Yes / No >>">
															<form:option value="-1"><< Yes / No >></form:option>
															<form:option value="Yes">Yes</form:option>
															<form:option value="No">No</form:option>
														</form:select> <span id="spnTerminalAttention"
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
													<td width="30%" style="text-align: left">Sampling
														Number</td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbSample.samplingNu" type="text"
															class="form-control" id="txtSamplingNu"
															placeholder="Enter Sampling Number" /> <span
														id="spnSamplingNu" class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Sample
															Date</strong></td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbSample.sampleDate" type="date"
															class="form-control" id="txtSampleDate"
															placeholder="Enter Sample date" /> <span
														id="spnSampleDate" class="label label-danger"></span></td>
												</tr>

												<tr>
													<td width="30%" style="text-align: left">PCB Test
														Results</td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbSample.pcbTestResults" type="text"
															class="form-control" id="txtPcbTestResults"
															placeholder="Enter PCB Test Results" /> <span
														id="spnPcbTestResults" class="label label-danger"></span></td>

													<td></td>

													<td width="30%" style="text-align: left"><strong>PCB
															Test date</strong></td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbSample.pcbTestDate" type="date"
															class="form-control" id="txtPcbTestDate"
															placeholder="Enter PCB Test date" /> <span
														id="spnPcbTestDate" class="label label-danger"></span></td>

												</tr>

												<tr>
													<td width="30%" style="text-align: left">Sampling Port</td>
													<%-- <td width="70%" style="text-align: left"><form:input
															path="pcbSample.samplingPort" type="text"
															class="form-control" id="txtSamplingPort"
															placeholder="Enter Sampling Port" /> <span
														id="spnSamplingPort" class="label label-danger"></span></td> --%>

													<td width="70%" style="text-align: left"><form:select
															path="pcbSample.samplingPort" class="form-control"
															id="txtSamplingPort" placeholder="<< Top / Bottom >>">
															<form:option value="-1"><< Top / Bottom >></form:option>
															<form:option value="Top">Top</form:option>
															<form:option value="Bottom">Bottom</form:option>
														</form:select> <span id="spnSamplingPort" class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>EPF
															Numbers of the Group</strong></td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbSample.epfNoGroup" type="text"
															class="form-control" id="txtEpfNoGroup"
															placeholder="Enter EPF Number" /> <span
														id="spnEpfNoGroup" class="label label-danger"></span></td>
												</tr>

												<tr>
													<td width="30%" style="text-align: left">EPF Numbers
														of the Test Group</td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbSample.epfNoTestGroup" type="text"
															class="form-control" id="txtEpfNoTestGroup"
															placeholder="Enter EPF Number" /> <span
														id="spnEpfNoTestGroup" class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Extracted
															from top</strong></td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbSample.extractedTop" type="text"
															class="form-control" id="txtExtractedTop"
															placeholder="Enter Extracted from top" /> <span
														id="spnExtractedTop" class="label label-danger"></span></td>
												</tr>

												<tr>
													<td width="30%" style="text-align: left">Remarks</td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbSample.remarks" type="text" class="form-control"
															id="txtRemarks" placeholder="Enter Remark" /> <span
														id="spnRemarks" class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Test
															Remarks</strong></td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbSample.testRemarks" type="text"
															class="form-control" id="txtTestRemarks"
															placeholder="Enter Remark" /> <span id="spnTestRemarks"
														class="label label-danger"></span></td>
												</tr>

												<tr>
													<td width="30%" style="text-align: left">Sampling
														Logic Satisfied</td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbSample.sampleSatisified" type="text"
															class="form-control" id="txtSampleSatisified"
															placeholder="Enter Sampling Logic Satisfied" /> <span
														id="spnSampleSatisified" class="label label-danger"></span></td>
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
															path="pcbLocation.locationDescription" type="text"
															class="form-control" id="txtLocationDescription"
															placeholder="Enter Location Description" /> <span
														id="spnLocationDescription" class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>Mounting
													</strong></td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbLocation.mounting" type="text"
															class="form-control" id="txtMounting"
															placeholder="Enter Mounting" /> <span id="spnMounting"
														class="label label-danger"></span></td>
												</tr>
												<tr>
													<td width="30%" style="text-align: left">Type of
														Located</td>
													<td width="70%" style="text-align: left"><form:select
															path="pcbLocation.typeOfLocated" class="form-control"
															id="txtTypeOfLocated"
															placeholder="<< Select Seal Type >>">
															<form:option value="-1"><< Select Type of Located  >></form:option>
															<form:option value="Seal">Indoor </form:option>
															<form:option value="None-Seal">Outdoor</form:option>
														</form:select> <span id="spnTypeOfLocated" class="label label-danger"></span></td>
													<td></td>

													<td width="30%" style="text-align: left"><strong>GPS
															location (Longitude)</strong></td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbLocation.gpsLongitude" type="number"
															class="form-control" id="txtGpsLongitude"
															placeholder="Enter GPS location (Longitude)" /> <span
														id="spnGpsLongitude" class="label label-danger"></span></td>

												</tr>



												<tr>
													<td width="30%" style="text-align: left">GPS location
														(Latitude)</td>
													<td width="70%" style="text-align: left"><form:input
															path="pcbLocation.gpsLatitude" type="number"
															class="form-control" id="txtGpsLatitude"
															placeholder="Enter GPS location (Latitude)" /> <span
														id="spnGpsLatitude" class="label label-danger"></span></td>
												</tr>


											</tbody>
										</table>





										<div class="form-group">
											<div class="pull-left">

												<input type="submit" Value="Add" class="btn btn-success" />

												<button type="button" class="btn btn-warning"
													onclick="window.location.href='editEquipment'">Edit
													>></button>
											</div>
										</div>



									</form:form>
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
</body>
</html>
