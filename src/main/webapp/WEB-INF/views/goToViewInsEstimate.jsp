<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style type="text/css">
table, th, td {
	border: 0px solid black;
	align: left;
	text-align: left;
}
</style>

<html>

<head>
<!-- meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"-->
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>MV-MMS</title>
<%@ include file="sections/headEdit.jsp"%>

<style type="text/css">
.form-control {
	display: inline-block;
	width: -webkit-fill-available;
	height: 34px;
	font-size: 12px;
	color: #0f1893;
	border-color: #095f9f;
	background-color: #fff;
	font-weight: 800;
	border-radius: 4px;
}
</style>

<script type="text/javascript">
	var checkBoxSelected = [];

	function addCheckedToArray(id) {
		var checkBox = document.getElementById("cb_" + id);
		if (checkBox.checked == true) {
			checkBoxSelected.push(id);
		} else {
			checkBoxSelected = arrayRemove(checkBoxSelected, id);
		}
		alert(checkBoxSelected);
	}

	function arrayRemove(arr, value) {

		return arr.filter(function(ele) {
			return ele != value;
		});

	}

	function goToEstimate() {

		var str = "";
		for (var i = 0; i < checkBoxSelected.length; i++) {
			if (i != 0) {
				str = str + "," + checkBoxSelected[i];
			} else {
				str = checkBoxSelected[0];
			}
		}
		alert(str);

		$.ajax({
			type : "GET",
			url : "/MMS/goToEstimate/" + str,
			success : function(response) {
				alert(response);
				console.log(response);
			}
		});
	}

	function ConfirmActivate(comid) {

		//alert("hiiii");
		$.ajax({

			type : 'GET',
			url : "/MMS/viewProvinceNew/" + comid,
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(response) {
				alert(response);

			}
		});
	}

	function showProvinces() {

		$
				.ajax({
					type : 'GET',
					url : '/MMS/findAllProvinces/',
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(response) {
						$("#tblProvinces > tbody:last").children().remove();

						//Insert item from the response
						for (var i = 0; i < response.length; i++) {
							var item = response[i];
							var comid = item.compId;

							tr = $('<tr/>');
							tr.append("<td> " + item.compNm + "</td>");
							tr
									.append("<td>"
											+ "<button type='button' class='btn btn-info' onClick=ConfirmActivate('"
											+ comid + "')>Go</button>"
											+ "</td>");

							$('#tblProvinces').append(tr);
						}

						$('#tblProvinces').dataTable({
							'info' : false,
							'pageLength' : 10,
							retrieve : true
						});
					}
				});
	}

	function findArea() {
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = province.options[province.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$
				.ajax({
					type : 'GET',
					url : "/MMS/findAllAreaByProvinceNew/" + strUser,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#area'), option = "<option value='NONE'>ALL</option>";
						slctSubcat.empty();
						for (var i = 0; i < data.length; i++) {
							option = option
									+ "<option value='" + data[ i ].deptId + "'>"
									+ data[i].deptNm + "</option>";
						}
						slctSubcat.append(option);

						//alert("response.towerNo" + data);	
					}
				});
	}

	function getLine() {
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = area.options[area.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$
				.ajax({
					type : 'GET',
					url : "/MMS/findLineByArea/" + strUser + "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#line'), option = "<option value='NONE'>ALL</option>";
						slctSubcat.empty();
						for (var i = 0; i < data.length; i++) {
							option = option
									+ "<option value='" + data[ i ].code + "'>"
									+ data[i].lineName + "</option>";
						}
						slctSubcat.append(option);

						//alert("response.towerNo" + data);	
					}
				});
	}

	function ConfirmActivate(comid) {

		alert("hiiii");
		$.ajax({

			type : 'GET',
			url : "/MMS/viewProvinceNew/" + comid,
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(response) {
				alert(response);

			}
		});

	}

	function showProvinces() {

		$
				.ajax({
					type : 'GET',
					url : '/MMS/findAllProvinces/',
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(response) {
						$("#tblProvinces > tbody:last").children().remove();

						//Insert item from the response
						for (var i = 0; i < response.length; i++) {
							var item = response[i];
							var comid = item.compId;

							tr = $('<tr/>');
							tr.append("<td> " + item.compNm + "</td>");
							tr
									.append("<td>"
											+ "<button type='button' class='btn btn-info' onClick=ConfirmActivate('"
											+ comid + "')>Go</button>"
											+ "</td>");

							$('#tblProvinces').append(tr);
						}

						$('#tblProvinces').dataTable({
							'info' : false,
							'pageLength' : 10,
							retrieve : true
						});
					}
				});
	}

	function findArea() {
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = province.options[province.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$
				.ajax({
					type : 'GET',
					url : "/MMS/findAllAreaByProvinceNew/" + strUser,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#area'), option = "<option value='NONE'>ALL</option>";
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

	function getLine() {
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = area.options[area.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$
				.ajax({
					type : 'GET',
					url : "/MMS/findLineByArea/" + strUser + "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#line'), option = "<option value='NONE'>ALL</option>";
						slctSubcat.empty();
						for (var i = 0; i < data.length; i++) {
							option = option
									+ "<option value='"+data[i].code + "'>"
									+ data[i].lineName + "</option>";
						}
						slctSubcat.append(option);

						//alert("response.towerNo" + data);	
					}
				});

	}
</script>
</head>

<body>
	<div id="theme-wrapper">

		<%@ include file="sections/header.jsp"%>
		<%@ include file="sections/dashboardCSS.jsp"%>
		

		<div id="page-wrapper" class="container">
			<div class="row">

				<%@ include file="sections/userLevels.jsp"%>

				<div id="content-wrapper">


					<div class="row">
						<div class="col-lg-12">

							<div class="col-lg-9">
								<ol class="breadcrumb">
									<li><a href="#">Home</a></li>
									<li class="active"><span>INSPECTION</span></li>
								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="main-box clearfix">
								<header class="main-box-header clearfix">
								<!-- <h2 class="pull-left">
									<strong>INSPECTION ESTIMATE</strong>
								</h2> -->
								</header>

								<div class="main-box-body clearfix">
									<div class="table-responsive">
										<table class="table table-responsive" id="tblProvinces">

											<thead>

											</thead>
											<tbody>
												<form:form method="post" action="goToViewInsEstimateS?mode=${type}"
													modelAttribute="model">
													
													<c:if test="${not empty model.mode}">
										<tr>
										<td colspan="2" class="msgSuccess" align="center">
										
									<div class="msgSuccess">
										<c:out value="${model.mode}"></c:out>
									</div>
								
						</tr>
					</c:if>


													<table class="table table-striped table-bordered table-sm " id="tblProvinces">

														<tr>
															<td width="30%" style="text-align: left">Province</td>
															<td width="70%" style="text-align: left"><form:select
																	id="province" path="glcompmobj.compId"
																	onchange="findArea()"
																	style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.provinceList}" />
																</form:select></td>
														</tr>

														<tr>
															<td width="30%" style="text-align: left">Area</td>
															<td width="70%" style="text-align: left"><form:select
																	id="area" path="gldeptobj.deptId" onchange="getLine()"
																	style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.areaList}" />
																</form:select></td>
														</tr>

														<tr>
															<td width="30%" style="text-align: left">Electrical
																	Superintendent</td>
															<td width="70%" style="text-align: left"><form:select
																	id="userId" path="sauserm.userId" onchange=""  style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																	
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.saList}" />
																</form:select></td>

														</tr>
														<tr>
															<td width="30%" style="text-align: left">Applicant</td>
															<td width="70%" style="text-align: left"><form:select
																	id="userId" path="applicant.idNo" onchange="" style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.appList}" />
																</form:select></td>

														</tr>


														<!-- <tr>
															<td style="text-align: left"><a
																href="../MMS/GenerateReportTM?area=431&line=49"> <input
																	class="btn btn-success" type="submit"
																	name="actionButton" value="GO"></input></a></td>
														</tr> -->

													</table>







													<c:if test="${canGO !='1'}">
														<table class="table table-striped table-bordered table-sm " id="tblAdmin">
															<thead>
															<tr>
															<td>Select Lines To Estimate</td>
															</tr>
																<tr>
																	<th class="text-center">Select</th>
																	<th class="text-center">Line Code</th>
																	<th class="text-center">Line Name</th>
																	<th class="text-center">Line Length</th>
																	<th class="text-center">No Of Poles</th>
																	<th class="text-center">No Of Towers</th>
																</tr>
															</thead>
															<tbody>

																<%-- <tr>
																	<td><form:label path="">line</form:label></td>

																	<td><form:checkboxes items="${model.listOfLines}"
																			path="selectedLines" /></td>
																	<td></td>
																</tr> --%>


																<c:forEach var="Line" items="${model.lineListEdit}">
																	<tr>
																		<td><form:checkbox id="cb_${Line.id}" onclick=""
																				path="selectedLines" value="${Line.id}" /></td>
																		
																		<td><input type="text" id="code_${Line.id}"
																			value="${Line.code}" class="form-control" disabled></td>
																		
																		<td><input type="text" id="na_${Line.id}"
																			value="${Line.lineName}" class="form-control"
																			disabled></td>
																		<td><input type="text" id="ll_${Line.id}"
																			value="${Line.length}" class="form-control" disabled></td>
																		<td><input type="text" id="np_${Line.id}"
																			value="${Line.noofpoles}" class="form-control"
																			disabled></td>
																		<td><input type="text" id="nt_${Line.id}"
																			value="${Line.nooftowers}" class="form-control"
																			disabled></td>
																	</tr>
																</c:forEach>
															</tbody>
														</table>
													</c:if>





													<c:if test="${canGO =='3'}">
														<br>
														<br>
														<table class="table table-striped table-bordered table-sm " id="tblAdmin">
															<tbody>
															<tr>
															<td>INSPECTION ESTIMATE FOR ${model.cycle}</td>
															</tr>
																<tr>

																	<td width="40%" style="text-align: left">Total
																		Line Length</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.totalLineLength"
																			value="${inspection.totalLineLength}" readonly="true"></form:input>

																	</td>
																</tr>
																<tr>
																	<td width="40%" style="text-align: left">Total
																		Number of Towers/Poles</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.totalNoTowers"
																			value="${inspection.totalNoTowers}" readonly="true"></form:input>

																	</td>
																</tr>
																<tr>
																	<td width="40%" style="text-align: left">Number of
																		days for the Inspection (C)</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.noDaysForTheIns"
																			value="${inspection.noDaysForTheIns}" readonly="true"></form:input>

																	</td>
																</tr>
																<tr>
																	<td width="40%" style="text-align: left">Labour
																		Hours for the Estimate (D 1)</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.labourHoursForEst"
																			value="${inspection.labourHoursForEst}"
																			readonly="true"></form:input></td>
																</tr>
																<tr>
																	<td width="40%" style="text-align: left">Labour
																		value for the Estimate (D) LKR</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.labourValueForEst"
																			value="${inspection.labourValueForEst}"
																			readonly="true"></form:input></td>
																</tr>
																<tr>
																	<td width="40%" style="text-align: left">Subsistance
																		(E) LKR</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.subsistance"
																			value="${inspection.subsistance}" readonly="true"></form:input>

																	</td>
																</tr>
																<tr>
																	<td width="40%" style="text-align: left">Hot line
																		Allowance (F) LKR</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.hotLineAllowances"
																			value="${inspection.hotLineAllowances}"
																			readonly="true"></form:input></td>
																</tr>
																<tr>
																	<td width="40%" style="text-align: left">Temporarly
																		site cost LKR (minimum 30,000)</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.temporarySiteCost"
																			value="${inspection.temporarySiteCost}"
																			readonly="true"></form:input></td>
																</tr>

																<tr>
																	<td width="40%" style="text-align: left">Transport
																		Cost</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.transport"
																			value="${inspection.transport}" readonly="true"></form:input>

																	</td>
																</tr>
																<tr>
																	<td width="40%" style="text-align: left">Total
																		Inspection Estimate</td>
																	<td width="60%" style="text-align: left"><form:input
																			path="inspection.tatalCost"
																			value="${inspection.tatalCost}" readonly="true"></form:input>

																	</td>
																</tr>


																<!-- <tr>
															<td style="text-align: left"><input
																class="btn btn-success" type="submit"
																name="actionButton" value="Save"></input></td>
														</tr> -->

															</tbody>
														</table>
														
																													
														
														
													</c:if>

													<c:if test="${canGO =='1'}">
														<tr>
															<td style="text-align: left"><a
																href="../MMS/GenerateReportTM?area=431&line=49"> <input
																	class="btn btn-success" type="submit"
																	name="actionButton" value="Go"></input></a></td>
														</tr>
													</c:if>
													<c:if test="${canGO =='2'}">
														<tr>
															<td style="text-align: left"><a
																href="../MMS/GenerateReportTM?area=431&line=49"> <input
																	class="btn btn-success" type="submit"
																	name="actionButton" value="Go To Estimate"></input></a></td>
														</tr>
													</c:if>
													 <c:if test="${canGO =='3'}">
													 <table class="table table-striped table-bordered table-sm ">
														<tr>
															<td style="text-align: left"><a
																href="../MMS/GenerateReportTM?area=431&line=49"> <input
																	class="btn btn-success" type="submit"
																	name="actionButton" value="Save"></input></a></td>
														</tr>
														
														
<!-- 			<tr>
			<td>Inception Estimate for the Area</td>
			
			</tr>																									
 <tr>
    <td>Total Line Length in Area</td>
    <td>A</td>
   
  </tr>
  <tr>
    <td>Total Number of Towers in Area</td>
    <td>B</td>
    
  </tr>
  <tr>
    <td>Number of days for the Inspection(C)</td>
    <td>B/27</td>
    
  </tr>
  <tr>
    <td>Labour Hours for the Estimate(D1)</td>
    <td>9*C*9</td>
 
  </tr>
  <tr>
    <td>Labour value for the Estimate(D)LKR</td>
    <td></td>
    
  </tr>
  <tr>
    <td>Subsistance(E)LKR</td>
    <td>D1*400/9*(30/22)</td>
   
  </tr>
  <tr>
    <td>Hot line Allowance(f)LKR</td>
    <td>16000*C</td>
   
  </tr>
  <tr>
    <td>Hot line Allowance(f)LKR</td>
    <td>16000*C</td>
   
  </tr>
  <tr>
    <td>Transport (Manual input -province -"X")(g)  </td>
    <td>B*"X"</td>
   </tr>
   <tr>
    <td>Transport Cost  </td>
    <td>G*45+G*55</td>
   </tr>
   <tr>
    <td>Temporarly site cost LKR(Minimum 30,000)  </td>
    <td>B*"X"</td>
   </tr>
   <tr>
    <td>Total Inspection Estimate   </td>
    <td></td>
   </tr> -->
  
</table>
<!-- <br>
<table class="table table-striped table-bordered table-sm ">
  <tr>
    <th>Province</th>
    <th>Km</th>
  </tr>
  <tr>
    <td>WPN</td>
    <td>4</td>
  </tr>
   <tr>
    <td>CP</td>
    <td>8</td>
  </tr>
   <tr>
    <td>EP</td>
    <td>8</td>
  </tr>
  <br>
  <tr>
    <td>27 Towers/Day will be inspected</td>
  </tr>
  <tr>
    <td>3 people per group and 3 Group will be there</td>
  </tr>
   <tr>
    <td>9 Hours per day will be working.</td>
  </tr>
</table>
 -->														
														
														
														</c:if>

														
														
													
													<%-- <c:if test="${canGO =='true'}">
														<tr>
															<td colspan="2"><button type="button"
																	class="btn btn-success"
																	onclick="window.location.href=<c:url value='/ViewInsEstDetail?nooftower=${summary[4]}&lineLength=${summary[3]}&id=${summary[0]}&dd=${dd}&province=${province}&area=${summary[1]}' />">Go
																	To Estimate</button></td>
														</tr>
														<!-- <tr>
															<td colspan="2"><button type="button"
																	class="btn btn-success"
																	onclick="window.location.href='ViewInsEstDetailNew'">Go
																	To Estimate</button></td>
														</tr> -->
														
													</c:if> --%>

												</form:form>

											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>








					<!-- <div class="row">
                            <div class="col-lg-12">

                                 <header class="main-box-header clearfix">
                                    <h2 class="pull-left">List of Support</h2>
                                </header>

                                
                            </div>
                        </div> -->


					<%@ include file="sections/footer.jsp"%>

				</div>
			</div>
		</div>
	</div>

	<%@ include file="sections/global_scripts.jsp"%>


</body>

</html>
