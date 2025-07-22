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
	//edit anushka 2019-01-02-------------------------------------------------------------------------------------------------------------
	var arrayDataToSave = [];

	function LoadSupportToEdit(pid) {
		// if ( document.getElementById( "pstatus_" + pid ).value == 0 || document.getElementById( "pstatus_" + pid ).value == 1 || document.getElementById( "pstatus_" + pid ).value == 4 )
		// {
		// alert( "This item is sent for approving or active item or inactive item. You cann't edit this" );
		// }
		// else
		// {
		enable(pid);

		arrayDataToSave.push(pid);

		// }
	}

	function editAll(stringIDs) {

		//alert("You are going to edit that all supports.. \n" + stringIDs);
		var arrayAllIds = stringIDs.split(",");

		var len = arrayAllIds.length

		for (var count = 0; count < len; count++) {
			LoadSupportToEdit(arrayAllIds[count]);
		}

	}

	function disable(pid) {
		document.getElementById("a1_" + pid).disabled = true;
		document.getElementById("j10_" + pid).disabled = true;
		document.getElementById("k11_" + pid).disabled = true;
		document.getElementById("t12_" + pid).disabled = true;

		document.getElementById("c3_" + pid).disabled = true;
		document.getElementById("d4_" + pid).disabled = true;
		document.getElementById("e5_" + pid).disabled = true;
		document.getElementById("f6_" + pid).disabled = true;
		document.getElementById("g7_" + pid).disabled = true;
		document.getElementById("h8_" + pid).disabled = true;
		document.getElementById("i9_" + pid).disabled = true;
		document.getElementById("l12_" + pid).disabled = true;
		document.getElementById("m13_" + pid).disabled = true;
		//               document.getElementById( "t11_" + pid ).disabled = true;
		document.getElementById("pstatus_" + pid).disabled = true;
		document.getElementById("n14_" + pid).disabled = true;

		arrayDataToSave = [];
	}
	//------------------------------------------------------------------------------------------------------------------------------------

	function enable(pid) {
		document.getElementById("a1_" + pid).disabled = false;
		document.getElementById("j10_" + pid).disabled = false;
		document.getElementById("k11_" + pid).disabled = false;
		document.getElementById("t12_" + pid).disabled = false;

		document.getElementById("c3_" + pid).disabled = false;
		document.getElementById("d4_" + pid).disabled = false;
		document.getElementById("e5_" + pid).disabled = false;
		document.getElementById("f6_" + pid).disabled = false;
		document.getElementById("g7_" + pid).disabled = false;
		document.getElementById("h8_" + pid).disabled = false;
		document.getElementById("i9_" + pid).disabled = false;
		document.getElementById("l12_" + pid).disabled = false;
		document.getElementById("m13_" + pid).disabled = false;
		//                document.getElementById( "t11_" + pid ).disabled = false;
		document.getElementById("t12_" + pid).disabled = false;

		document.getElementById("pstatus_" + pid).disabled = false;
		document.getElementById("n14_" + pid).disabled = false;

	}

	//edited anushka 2019-01-02------------------------------------------------------------------------------------------------------------------------
	function saveAll() {
		var len = arrayDataToSave.length

		for (var count = 0; count < len; count++) {
			var pid = arrayDataToSave[count];

			var a = document.getElementById("a1_" + pid).value;
			var j = document.getElementById("j10_" + pid).value;
			var k = document.getElementById("k11_" + pid).value;
			var x = document.getElementById("t12_" + pid).value;
			var c = document.getElementById("c3_" + pid).value;
			var d = document.getElementById("d4_" + pid).value;
			var e = document.getElementById("e5_" + pid).value;
			var f = document.getElementById("f6_" + pid).value;
			var g = document.getElementById("g7_" + pid).value;
			var h = document.getElementById("h8_" + pid).value;
			var i = document.getElementById("i9_" + pid).value;
			var l = document.getElementById("l12_" + pid).value;
			var m = document.getElementById("m13_" + pid).value;

			var status = document.getElementById("pstatus_" + pid).value;
			var n = 'PHMR2ES1';
			var url = "/MMS/updateSupport/" + c + "/" + a + "/" + pid + "/" + d
					+ "/" + e + "/" + f + "/" + g + "/" + h + "/" + i + "/" + j
					+ "/" + k + "/" + l + "/" + m + "/" + "0" + "/" + x + "/"
					+ status + "/" + n;

			$.ajax({
				type : "GET",
				url : url,
				success : function(response) {
					//alert("Support updated succesfully... id: "+ pid + response);
					console.log(response);
					window.location.reload();
					disable(pid);
				}
			});
		}
		alert("Supports updated succesfully... ");
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------

	function save(pid) {
		//alert("called");
		var a = document.getElementById("a1_" + pid).value;
		var j = document.getElementById("j10_" + pid).value;
		var k = document.getElementById("k11_" + pid).value;
		var x = document.getElementById("t12_" + pid).value;
		var c = document.getElementById("c3_" + pid).value;
		var d = document.getElementById("d4_" + pid).value;
		var e = document.getElementById("e5_" + pid).value;
		var f = document.getElementById("f6_" + pid).value;
		var g = document.getElementById("g7_" + pid).value;
		var h = document.getElementById("h8_" + pid).value;
		var i = document.getElementById("i9_" + pid).value;
		var l = document.getElementById("l12_" + pid).value;
		var m = document.getElementById("m13_" + pid).value;
		//                var t = document.getElementById( "t11_" + pid ).value;
		// 

		var status = document.getElementById("pstatus_" + pid).value;
		// var n = document.getElementById("n14_"+pid).value;
		var n = 'PHMR2ES1';
		// alert( "sType: " + a + " / id: " + pid + " / area: " + d + " / csc: " + e + " / cType: " + f + " / ecType: " + g + " / tType: " + h + " / tConfig: " + i + " / gpsLat: " + j + " / gpsLon: " + k + " / nofCir: " + l + " / bExten: " + m + " / tapping: " + t + " / mapId: " + x + " / status: " + status + " / appLevel: " + n );
		//alert( "sType: " + a + " / id: " + pid + " / area: " + d + " / csc: " + e + " / cType: " + f + " / ecType: " + g + " / tType: " + h + " / tConfig: " + i + " / gpsLat: " + j + " / gpsLon: " + k + " / nofCir: " + l + " / bExten: " + m + " / mapId: " + x + " / status: " + status + " / appLevel: " + n );
		//alert(url);
		var url = "/MMS/updateSupport/" + c + "/" + a + "/" + pid + "/" + d
				+ "/" + e + "/" + f + "/" + g + "/" + h + "/" + i + "/" + j
				+ "/" + k + "/" + l + "/" + m + "/" + "0" + "/" + x + "/"
				+ status + "/" + n;

		//alert(url);

		/*    alert(a);
		   alert(b);
		   alert(c);
		   alert(d);
		   alert(e);
		   alert(f);
		   alert(g);
		   alert(h);
		   alert(i);
		   alert(j);
		   alert(k);
		   alert(l);
		   alert(m);
		   alert(n);
		   alert(pid);
		   alert(status); */

		//var url = "/MMS/updateSupport/" + x + "/" + pid + "/" + j + "/" + k + "/" + a + "/" + d + "/" + e + "/" + f + "/" + g + "/" + h + "/" + i + "/" + l + "/" + m + "/" + status + "/" + n;
		//var url = "/MMS/updateSupport/" + x + "/" + pid + "/" + j + "/" + k + "/" + a + "/" + d + "/" + e + "/" + f + "/" + g + "/" + h + "/" + i + "/" + l + "/" + m + "/" + t + "/" + status + "/" + n;
		//var url = "/MMS/MapIdUpdate/" + x + "/" + pid + "/" + j + "/" + k + "/" + a + "/" + d;
		// alert(url);
		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				alert("Support updated succesfully... " + response);
				console.log(response);
				window.location.reload();
				disable(pid);
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

	function sendForValidation() {


		var url = "/MMS/updateSupportAllApprove";

		
		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				alert("Succesfully approved...");
				console.log(response);
				window.location.reload();
				//disable( id );
			}
		});
	}
</script>
</head>

<body>
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
									<li class="active"><span>Edit Support </span></li>
								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="main-box clearfix">
								<header class="main-box-header clearfix">
								<h2 class="pull-left">Edit Support</h2>
								</header>

								<div class="main-box-body clearfix">
									<div class="table-responsive">
										<table class="table table-responsive" id="tblProvinces">

											<thead>

											</thead>
											<tbody>
												<form:form method="post" action="displaySupportNewS"
													modelAttribute="model">


													<!-- edited 1 anushka open 2018-11-30 -->
													<c:set var="userType"
														value="${sessionScope.loggedUserRole}" />
													<!-- edited 1 anushka close 2018-11-30 -->

													<%-- <table class="table table-responsive" id="tblProvinces">

														<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">PROVINCE</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="province" path="glcompmobj.compId"
																	onchange="findArea()"
																	style="width:50%; background-color: #8187ff; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.provinceList}" />
																</form:select></td>
														</tr>

														<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">AREA</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="area" path="gldeptobj.deptId" onchange="getLine()"
																	style="width:50%; background-color: #94cb71; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.areaList}" />
																</form:select></td>
														</tr>

														<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">LINE</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="line" path="line.code" onchange=""
																	style="width:50%; background-color: #dac698; border-radius: 5px;">

																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.lineList}" />
																</form:select></td>
														</tr>

														<tr>
															<td style="text-align: left"><a
																href="../MMS/GenerateReportTM?area=431&line=49"> <input
																	class="btn btn-success" type="submit"
																	name="actionButton" value="GO"></input></a></td>
														</tr>

													</table> --%>









													<table class="table table-responsive" id="tblAdmin">

														<thead>
															<tr>
																<th class="text-center">ID</th>
																<th class="text-center">Map Id</th>
																<th class="text-center">Support Type</th>
																<th class="text-center">GPS-Latitude</th>
																<th class="text-center">GPS-Longitude</th>
																<th class="text-center">Tower No</th>
																<th class="text-center">Area</th>
																<th class="text-center">CSC</th>
																<th class="text-center">Conductor Type</th>
																<th class="text-center">Earth Con: Type</th>
																<th class="text-center">Tower Type</th>
																<th class="text-center">Tower Config:</th>
																<th class="text-center">Circuits</th>
																<th class="text-center">Body Extension</th>
																<!-- <th class="text-center">Tapping</th> -->
																<th class="text-center">Status</th>
																<th class="text-center">Approval Level</th>
																<th class="text-center">Edit</th>
																<th class="text-center">Save</th>


															</tr>
														</thead>
														<tbody>
															<c:forEach var="Support" items="${model.support}">
																<tr>

																	<td><input type="text" id="id"
																		value="${Support.id}" class="form-control" disabled></td>
																	<td><input type="text" id="t12_${Support.id}"
																		value="${Support.mapId}" class="form-control" disabled></td>

																	<td><select id="a1_${Support.id}"
																		class="form-control" disabled>

																			<c:forEach var="supType" items="${model.sTypeList}">

																				<c:choose>
																					<c:when test="${supType.id != Support.supportType}">
																						<option value="${supType.id}">${supType.supportType}</option>
																					</c:when>
																				</c:choose>

																			</c:forEach>

																			<c:forEach var="supType" items="${model.sTypeList}">
																				<c:choose>
																					<c:when test="${supType.id == Support.supportType}">
																						<option value="${supType.id}" selected="selected">${supType.supportType}</option>
																					</c:when>
																				</c:choose>
																			</c:forEach>
																	</select></td>
																	<td><input type="text" id="j10_${Support.id}"
																		value="${Support.gpsLatitude}" class="form-control"
																		disabled></td>

																	<td><input type="text" id="k11_${Support.id}"
																		value="${Support.gpsLongitude}" class="form-control"
																		disabled></td>

																	<td><input type="text" id="c3_${Support.id}"
																		value="${Support.towerNo}" class="form-control"
																		disabled></td>

																	<td><input type="text" id="d4_${Support.id}"
																		value="${Support.area}" class="form-control" disabled></td>

																	<td><input type="text" id="e5_${Support.id}"
																		value="${Support.csc}" class="form-control" disabled></td>

																	<%--  <td><input type="text" id="f6_${Support.id}"
                                                                                value="${Support.conductorType}" class="form-control"
                                                                                disabled></td> --%>

																	<td><select id="f6_${Support.id}"
																		class="form-control" disabled>

																			<c:forEach var="conType" items="${model.conTypeList}">

																				<c:choose>
																					<c:when
																						test="${conType.id != Support.conductorType}">
																						<option value="${conType.id}">${conType.type}</option>
																					</c:when>
																				</c:choose>

																			</c:forEach>

																			<c:forEach var="conType" items="${model.conTypeList}">
																				<c:choose>
																					<c:when
																						test="${conType.id == Support.conductorType}">
																						<option value="${conType.id}" selected="selected">${conType.type}</option>
																					</c:when>
																				</c:choose>
																			</c:forEach>
																	</select></td>

																	<%--  <td><input type="text" id="g7_${Support.id}"
                                                                                value="${Support.earthConductorType}"
                                                                                class="form-control" disabled></td> --%>
																	<td><select id="g7_${Support.id}"
																		class="form-control" disabled>

																			<c:forEach var="earthConType"
																				items="${model.erthConTypeList}">

																				<c:choose>
																					<c:when
																						test="${earthConType.id != Support.earthConductorType}">
																						<option value="${earthConType.id}">${earthConType.type}</option>
																					</c:when>
																				</c:choose>

																			</c:forEach>

																			<c:forEach var="earthConType"
																				items="${model.erthConTypeList}">
																				<c:choose>
																					<c:when
																						test="${earthConType.id == Support.earthConductorType}">
																						<option value="${earthConType.id}"
																							selected="selected">${earthConType.type}</option>
																					</c:when>
																				</c:choose>
																			</c:forEach>
																	</select></td>



																	<%-- <td><input type="text" id="h8_${Support.id}"
                                                                                value="${Support.towerType}" class="form-control"
                                                                                disabled></td> --%>

																	<td><select id="h8_${Support.id}"
																		class="form-control" disabled>

																			<c:forEach var="towerType" items="${model.towerType}">

																				<c:choose>
																					<c:when test="${towerType.id != Support.towerType}">
																						<option value="${towerType.id}">${towerType.name}</option>
																					</c:when>
																				</c:choose>

																			</c:forEach>

																			<c:forEach var="towerType" items="${model.towerType}">
																				<c:choose>
																					<c:when test="${towerType.id == Support.towerType}">
																						<option value="${towerType.id}"
																							selected="selected">${towerType.name}</option>
																					</c:when>
																				</c:choose>
																			</c:forEach>
																	</select></td>

																	<%--  <td><input type="text" id="i9_${Support.id}"
                                                                                value="${Support.towerConfiguration}"
                                                                                class="form-control" disabled></td> --%>

																	<td><select id="i9_${Support.id}"
																		class="form-control" disabled>

																			<c:forEach var="activeConfigurations"
																				items="${model.activeConfigurations}">

																				<c:choose>
																					<c:when
																						test="${activeConfigurations.id != Support.towerConfiguration}">
																						<option value="${activeConfigurations.id}">${activeConfigurations.name}</option>
																					</c:when>
																				</c:choose>

																			</c:forEach>

																			<c:forEach var="activeConfigurations"
																				items="${model.activeConfigurations}">
																				<c:choose>
																					<c:when
																						test="${activeConfigurations.id == Support.towerConfiguration}">
																						<option value="${activeConfigurations.id}"
																							selected="selected">${activeConfigurations.name}</option>
																					</c:when>
																				</c:choose>
																			</c:forEach>
																	</select></td>


																	<!--  <td><input type="text" id="l12_${Support.id}"
                                                                                value="${Support.noOfCircuits}" class="form-control"
                                                                                disabled></td> -->

																	<td><select id="l12_${Support.id}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${Support.noOfCircuits=='1'}">
																					<option value="${Support.noOfCircuits}"
																						selected="selected">Single</option>
																					<option value="2">Double</option>
																					<option value="3">Both</option>
																				</c:when>

																				<c:when test="${Support.noOfCircuits=='2'}">
																					<option value="${Support.noOfCircuits}"
																						selected="selected">Double</option>
																					<option value="1">Single</option>
																					<option value="3">Both</option>
																				</c:when>

																				<c:when test="${Support.noOfCircuits=='3'}">
																					<option value="${Support.noOfCircuits}"
																						selected="selected">Both</option>
																					<option value="1">Single</option>
																					<option value="2">Double</option>
																				</c:when>

																				<c:otherwise>
																					<option value="1">Single</option>
																					<option value="2">Double</option>
																					<option value="3">Both</option>
																				</c:otherwise>

																			</c:choose>
																	</select></td>
																	<td><select id="m13_${Support.id}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${Support.bodyExtension=='0'}">
																					<option value="${Support.bodyExtension}"
																						selected="selected">0</option>
																					<option value="3">3+</option>
																					<option value="5">5+</option>
																					<option value="6">6+</option>
																				</c:when>

																				<c:when test="${Support.bodyExtension=='3'}">
																					<option value="${Support.bodyExtension}"
																						selected="selected">3+</option>
																					<option value="0">0</option>
																					<option value="5">5+</option>
																					<option value="6">6+</option>
																				</c:when>

																				<c:when test="${Support.bodyExtension=='5'}">
																					<option value="${Support.bodyExtension}"
																						selected="selected">5+</option>
																					<option value="0">0</option>
																					<option value="3">3+</option>
																					<option value="6">6+</option>
																				</c:when>

																				<c:when test="${Support.bodyExtension=='6'}">
																					<option value="${Support.bodyExtension}"
																						selected="selected">6+</option>
																					<option value="0">0</option>
																					<option value="3">3+</option>
																					<option value="5">5+</option>
																				</c:when>

																				<c:otherwise>
																					<option value="0">0</option>
																					<option value="3">3+</option>
																					<option value="5">5+</option>
																					<option value="6">6+</option>
																				</c:otherwise>

																			</c:choose>
																	</select></td>



																	<!--     <td><input type="text" id="m13_${Support.id}"
                                                                                value="${Support.bodyExtension}" class="form-control"
                                                                                disabled></td> -->

																	<%-- <td><input type="text" id="t11_${Support.id}"
                                                                                value="${Support.tapping}" class="form-control"
                                                                                disabled></td> --%>



																	<td><select id="pstatus_${Support.id}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${sessionScope.loggedUserRole=='DEO'}">
																					<option value="${Support.status}"
																						selected="selected">In Bulk</option>
																					<option value="3">Send for Validation</option>
																					<option value="0">Inactive</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='ES'}">
																					<option value="${Support.status}"
																						selected="selected">Pending</option>
																					<option value="4">Send for Approval</option>
																					<option value="0">Inactive</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='EE'}">
																					<option value="${Support.status}"
																						selected="selected">Pending</option>
																					<option value="1">Approve</option>
																					<option value="0">Inactive</option>
																				</c:when>


																				<c:otherwise>
																					<option value="${Support.status}"
																						selected="selected">Not Allowed</option>

																				</c:otherwise>

																			</c:choose>

																			<%-- <c:choose>
                                                                                    <c:when test="${Support.status==0}">
                                                                                        <option value="${Support.status}"
                                                                                            selected="selected">Pending</option>
                                                                                    </c:when>

                                                                                    <c:when test="${Support.status==1}">
                                                                                        <option value="${Support.status}"
                                                                                            selected="selected">Active</option>
                                                                                    </c:when>

                                                                                    <c:when test="${Support.status==2}">
                                                                                        <option value="${Support.status}"
                                                                                            selected="selected">In
                                                                                            bulk</option>
                                                                                        <option value="3">Send for Approval</option>
                                                                                    </c:when>

                                                                                    <c:when test="${Support.status==4}">
                                                                                        <option value="${Support.status}"
                                                                                            selected="selected">Inactive</option>
                                                                                    </c:when>

                                                                                    <c:otherwise>
                                                                                        <option value="${Support.status}"
                                                                                            selected="selected">Rejected</option>
                                                                                        <option value="3">Send
                                                                                            for Approval</option>
                                                                                        <option value="2">Keep
                                                                                            in bulk</option>
                                                                                    </c:otherwise>

                                                                                </c:choose> --%>
																	</select></td>

																	<td><select id="n14_${Support.id}"
																		class="form-control" disabled>
																			<option value="" selected="selected">${Support.approvalLevel}</option>
																			<option value="ES1COMWPS2">ES1COMWPS2</option>
																			<option value="ESPHM1">ESPHM1</option>
																	</select></td>

																	<td><button type='button' class='btn btn-warning'
																			onClick='LoadSupportToEdit("${Support.id}")'>Edit</button>
																	</td>
																	<td><button type='button' class='btn btn-success'
																			onClick='javascript:save("${Support.id}")'>Update</button>
																	</td>
																</tr>

															</c:forEach>
														</tbody>
													</table>


													<!-- edited 2 anushka open 2018-11-30 -->
													<tr>

														<!-- edited anushka 2019-01-02----------------------------------------------------------------------------------------->
														<td>
															<button type='button' class='btn btn-warning'
																onClick='javascript:editAll("${model.stringOfSupportIds}")'>Edit
																All</button>
														</td>

														<td>
															<button type='button' class='btn btn-success'
																onClick='javascript:saveAll()'>Update All</button>
														</td>
														<!--------------------------------------------------------------------------------------------------------------------->

														<td colspan="2"><c:if test="${userType =='DEO'}">

															</c:if> <input type="hidden" name="actionButton" value="" /> <c:choose>
																<c:when test="${sessionScope.loggedUserRole=='DEO'}">
																	<input id="pivFormBtn" class="btn btn-success"
																		type="submit" name="actionButton"
																		value="Send For Validation"
																		onclick="sendForValidation()"></input>

																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='EE'}">
																	<input id="pivFormBtn" class="btn btn-success"
																		type="submit" name="actionButton" value="Approve"
																		onclick="sendForValidation()"></input>

																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='ES'}">
																	<input id="pivFormBtn" class="btn btn-success"
																		type="submit" name="actionButton"
																		value="Send For Approval"
																		onclick="sendForValidation()"></input>

																</c:when>
																<c:otherwise>

																</c:otherwise>
															</c:choose></td>
													</tr>
													<!-- edited 2 anushka close 2018-11-30 -->


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
