<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style type="text/css">
table, th, td {
	border: 0px solid black;
	align: left;
	text-align: left;
}

thead tr th { 
	    height: 30px;
	    line-height: 30px;
	}
	
	
	tbody { border-top: 0px solid black; }
	
	tbody td, thead th {
	    border-right: 0px solid black;
	}
	
	tbody td:last-child, thead th:last-child {
	    border-right: none;
	}

	
	.table-scroll {
  position: relative;
  width:100%;
  z-index: 1;
  margin: auto;
  overflow: auto;
  height: 350px;
}
.table-scroll table {
  width: 100%;
  min-width: 1280px;
  margin: auto;
  border-collapse: separate;
  border-spacing: 0;
}
.table-wrap {
  position: relative;
}
.table-scroll th,
.table-scroll td {
  padding: 5px 10px;
  border: 0px solid #000;
  background: #f1f3f7;
  vertical-align: top;
}
.table-scroll thead th {
  
  position: -webkit-sticky;
  position: sticky;
  top: 0;
}
/* safari and ios need the tfoot itself to be position:sticky also */
.table-scroll tfoot,
.table-scroll tfoot th,
.table-scroll tfoot td {
  position: -webkit-sticky;
  position: sticky;
  bottom: 0;
  background: #666;
  color: #fff;
  z-index:4;
}

a:focus {
  background: red;
} /* testing links*/

th:first-child {
  position: -webkit-sticky;
  position: sticky;
  left: 0;
  z-index: 2;
  
}
thead th:first-child,
tfoot th:first-child {
  z-index: 5;
}
</style>
<html>
<head>
<%@ include file="sections/head.jsp"%>

<script type="text/javascript">
	
	var arrayDataToSave = [];
	

	function ConfirmActivate(comid) {

		//alert("hiiii");
		$.ajax({

			type : 'GET',
			url : "/MMS/viewProvinceNew/" + comid,
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(response) {
				//alert(response);

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
	function getAreas() {
		$.ajax({
			type : 'GET',
			url : '/MMS/findAllAreaNew/',
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(response) {
				//alert(response);
				$('#cmbSelectArea').empty();
				//Append "None" item
				$('#cmbSelectArea').append(
						$('<option>').text("<< Select Area >>").attr('value',
								""));

				//Insert item from the response
				for (var i = 0; i < response.length; i++) {
					var item = response[i];
					$('#cmbSelectArea').append(
							$('<option>').text(item.deptNm).attr('value',
									item.deptId));
				}
			}
		});
	}

	
	function LoadGantryToEdit(pid) {
		enable(pid);
		arrayDataToSave.push(pid);

		
	}

	function editAll(stringIDs) {

		alert("You are going to edit that all gantries.. \n" + stringIDs);
		var arrayAllIds = stringIDs.split(",");

		var len = arrayAllIds.length

		for (var count = 0; count < len; count++) {
			LoadGantryToEdit(arrayAllIds[count]);
		}

	}

	function disable(pid) {
		    
			document.getElementById("name_" + pid).disabled = true;
			document.getElementById("short_" + pid).disabled = true;
			document.getElementById("earth_" + pid).disabled = true;
			document.getElementById("date_" + pid).disabled = true;
			document.getElementById("code_" + pid).disabled = true;
			
			document.getElementById("gantryType_" + pid).disabled = true;
			document.getElementById("gantryEleType_" + pid).disabled = true;
			document.getElementById("noBusBar_" + pid).disabled = true;
			document.getElementById("noBusSec_" + pid).disabled = true;
			document.getElementById("noInBays_" + pid).disabled = true;
			document.getElementById("noOutBays_" + pid).disabled = true;
			document.getElementById("totalLandArea_" + pid).disabled = true;
			document.getElementById("noAr_" + pid).disabled = true;
			document.getElementById("noLbs_" + pid).disabled = true;
			document.getElementById("noAbs_" + pid).disabled = true;
			document.getElementById("noSa_" + pid).disabled = true;
			document.getElementById("noDdloLinks_" + pid).disabled = true;
			document.getElementById("noDdloFuses_" + pid).disabled = true;
			document.getElementById("noIncomingFeeder_" + pid).disabled = true;
			document.getElementById("noOutgoingFeeder_" + pid).disabled = true;
			document.getElementById("gpsLatitude_" + pid).disabled = true;
			document.getElementById("gpsLongitude_" + pid).disabled = true;
			document.getElementById("status_" + pid).disabled = true;

		arrayDataToSave = [];
	}

	
	function enable(pid) {
		
		document.getElementById("name_" + pid).disabled = false;
		document.getElementById("short_" + pid).disabled = false;
		document.getElementById("earth_" + pid).disabled = false;
		document.getElementById("code_" + pid).disabled = false;
		
		document.getElementById("date_" + pid).disabled = false;
		document.getElementById("gantryType_" + pid).disabled = false;
		document.getElementById("gantryEleType_" + pid).disabled = false;
		document.getElementById("noBusBar_" + pid).disabled = false;
		document.getElementById("noBusSec_" + pid).disabled = false;
		document.getElementById("noInBays_" + pid).disabled = false;
		document.getElementById("noOutBays_" + pid).disabled = false;
		document.getElementById("totalLandArea_" + pid).disabled = false;
		document.getElementById("noAr_" + pid).disabled = false;
		document.getElementById("noLbs_" + pid).disabled = false;
		document.getElementById("noAbs_" + pid).disabled = false;
		document.getElementById("noSa_" + pid).disabled = false;
		document.getElementById("noDdloLinks_" + pid).disabled = false;
		document.getElementById("noDdloFuses_" + pid).disabled = false;
		document.getElementById("noIncomingFeeder_" + pid).disabled = false;
		document.getElementById("noOutgoingFeeder_" + pid).disabled = false;
		document.getElementById("gpsLatitude_" + pid).disabled = false;
		document.getElementById("gpsLongitude_" + pid).disabled = false;
		document.getElementById("status_" + pid).disabled = false;
		
		
	}

	
	function saveAll() {
		
		var len = arrayDataToSave.length
		for (var count = 0; count < len; count++) {
			var pid = arrayDataToSave[count];
			
		    var province = document.getElementById("province_" + pid).value;
			var area = document.getElementById("area_" + pid).value;
			var csc = document.getElementById("csc_" + pid).value;
			var code = document.getElementById("code_" + pid).value;
		    var name = document.getElementById("name_" + pid).value;
			var shortcu = document.getElementById("short_" + pid).value;
			var earth = document.getElementById("earth_" + pid).value;
			var date = document.getElementById("date_" + pid).value;
			var gantryType = document.getElementById("gantryType_" + pid).value;
			var gantryEleType= document.getElementById("gantryEleType_" + pid).value;
			var noBusBar= document.getElementById("noBusBar_" + pid).value;
			var noBusSec= document.getElementById("noBusSec_" + pid).value;
			var noInb= document.getElementById("noInBays_" + pid).value;
			var noOutb= document.getElementById("noOutBays_" + pid).value;
			var total= document.getElementById("totalLandArea_" + pid).value;
			var noAr= document.getElementById("noAr_" + pid).value;
			var noLbs= document.getElementById("noLbs_" + pid).value;
			var noAbs= document.getElementById("noAbs_" + pid).value;
			var noSa= document.getElementById("noSa_" + pid).value;
			var noddlol= document.getElementById("noDdloLinks_" + pid).value;
			var noddlof= document.getElementById("noDdloFuses_" + pid).value;
			var noInf= document.getElementById("noIncomingFeeder_" + pid).value;
			var noOutf= document.getElementById("noOutgoingFeeder_" + pid).value;
			var gpsLatitude = document.getElementById("gpsLatitude_" + pid).value;
			var gpsLongitude = document.getElementById("gpsLongitude_" + pid).value;
			var status = document.getElementById("status_" + pid).value;
			
		var url = "/MMS/updateGantry/" + pid + "/" +province+"/"+ area + "/" + csc + "/"+ code + "/" + name + "/" + shortcu + "/" + earth + "/"
				+ date + "/" + gantryType + "/" + gantryEleType + "/" + noBusBar + "/"+ noBusSec + "/" + noInb + "/" + noOutb + "/"
				+ total + "/" + noAr + "/" + noLbs +"/"+ noAbs + "/" + noSa + "/" + noddlol + "/" + noddlof + "/"+ noInf + "/" + noOutf + "/"
				+ gpsLatitude + "/" + gpsLongitude + "/" + status + "/";

			$.ajax({
				type : "GET",
				url : url,
				success : function(response) {
					console.log(response);
					window.location.reload();
					disable(pid);
				}
			});
		}
		alert("Gantries updated succesfully... ");
		
	}
	

	function save(pid) {
		    var province = document.getElementById("province_" + pid).value;
			var area = document.getElementById("area_" + pid).value;
			var csc = document.getElementById("csc_" + pid).value;
			var code = document.getElementById("code_" + pid).value;
		    var name = document.getElementById("name_" + pid).value;
			var shortcu = document.getElementById("short_" + pid).value;
			var earth = document.getElementById("earth_" + pid).value;
			var date = document.getElementById("date_" + pid).value;
			var gantryType = document.getElementById("gantryType_" + pid).value;
			var gantryEleType= document.getElementById("gantryEleType_" + pid).value;
			var noBusBar= document.getElementById("noBusBar_" + pid).value;
			var noBusSec= document.getElementById("noBusSec_" + pid).value;
			var noInb= document.getElementById("noInBays_" + pid).value;
			var noOutb= document.getElementById("noOutBays_" + pid).value;
			var total= document.getElementById("totalLandArea_" + pid).value;
			var noAr= document.getElementById("noAr_" + pid).value;
			var noLbs= document.getElementById("noLbs_" + pid).value;
			var noAbs= document.getElementById("noAbs_" + pid).value;
			var noSa= document.getElementById("noSa_" + pid).value;
			var noddlol= document.getElementById("noDdloLinks_" + pid).value;
			var noddlof= document.getElementById("noDdloFuses_" + pid).value;
			var noInf= document.getElementById("noIncomingFeeder_" + pid).value;
			var noOutf= document.getElementById("noOutgoingFeeder_" + pid).value;
			var gpsLatitude = document.getElementById("gpsLatitude_" + pid).value;
			var gpsLongitude = document.getElementById("gpsLongitude_" + pid).value;
			var status = document.getElementById("status_" + pid).value;
			
		var url = "/MMS/updateGantry/" + pid + "/" +province+"/"+ area + "/" + csc + "/"+ code + "/" + name + "/" + shortcu + "/" + earth + "/"
				+ date + "/" + gantryType + "/" + gantryEleType + "/" + noBusBar + "/"+ noBusSec + "/" + noInb + "/" + noOutb + "/"
				+ total + "/" + noAr + "/" + noLbs +"/"+ noAbs + "/" + noSa + "/" + noddlol + "/" + noddlof + "/"+ noInf + "/" + noOutf + "/"
				+ gpsLatitude + "/" + gpsLongitude + "/" + status + "/";
		//alert(url);

		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				alert("Gantry updated succesfully...");
				console.log(response);
				window.location.reload();
				disable(pid);
			}
		});

	}

	function sendForValidation() {
		//alert("dfg");
		
        var url = "/MMS/updateGantryStatusNew/";
		
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
									<li class="active"><span>Edit Gantry </span></li>
								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="main-box clearfix">
								
								<div id="table-responsive" class="table-scroll">
									<div class="table-scroll">
										<table class="table table-responsive" id="tblProvinces">

											<tbody>
												<form:form method="post" action="displayGantryNewS" modelAttribute="model">
													
													
													<table class="main-table" id="tblAdmin">

														<thead>
															<tr>
															    <th class="text-center">Province</th>
															    <th class="text-center">Area</th>
															    <th class="text-center">Csc</th>
																<th class="text-center">Code</th>
																<th class="text-center">Name</th>
																<th class="text-center">Short circuit current capacity(kA)</th>
																<th class="text-center">Earth fault current capacity(kA)</th>
																<th class="text-center">Date of Commissing</th>
																<th class="text-center">Gantry Type</th>
																<th class="text-center">Gantry Electrcial Type</th>
																<th class="text-center">No of Bus bars</th>
																<th class="text-center">No of Bus sections</th>
																<th class="text-center">No of In bays</th>
																<th class="text-center">No of Out bays</th>
																<th class="text-center">Total Land Area (ph)</th>
																<th class="text-center">No Of AutoRecloser</th>
																<th class="text-center">No Of LBS</th>
																<th class="text-center">No Of ABS</th>
																<th class="text-center">No Of Surge Arrestors</th>
																<th class="text-center">No Of DDLO Links</th>
																<th class="text-center">No Of DDLO fuses</th>
																<th class="text-center">No Of Incoming Feeders</th>
																<th class="text-center">No Of Outgoing Feeders</th>
																<th class="text-center">GPS Latitude</th>
																<th class="text-center">GPS Longitude</th>
																<th class="text-center">Status</th>
																<th></th>
																 <!-- <th class="text-center">Edit</th>
																<th class="text-center">Save</th>
  -->
															</tr>
														</thead>
														<tbody>
															<c:forEach var="gantry" items="${model.gantryListEdit}">
																<tr>
																	
																    <th><input type="text" id="province_${gantry.id}"
																		value="${gantry.province}" class="form-control" disabled></th> 
																	<th><input type="text" id="area_${gantry.id}"
																		value="${gantry.area}" class="form-control" disabled></th>
																	<th><input type="text" id="csc_${gantry.id}"
																		value="${gantry.csc}" class="form-control" disabled></th>
																	
																	<th><input type="text" id="code_${gantry.id}"
																		value="${gantry.code}" class="form-control" disabled></th>
																

																	<td><input type="text" id="name_${gantry.id}"
																		value="${gantry.name}" class="form-control" disabled></td>
																	
																	
																	<td><input type="text" id="short_${gantry.id}"
																		value="${gantry.shortCctCurntCapacity}" class="form-control" disabled></td>
																	<td><input type="text" id="earth_${gantry.id}"
																		value="${gantry.earthFaultCurntCapacity}" class="form-control" disabled></td>
																	<td><input type="text" id="date_${gantry.id}"
																		value="${gantry.dateOfComm}" class="form-control"
																		disabled></td>
																	<%-- <td><input type="text" id="gantryType_${gantry.id}"
																		value="${gantry.gantryType}" class="form-control" disabled></td>
																	<td><input type="text" id="gantryEleType_${gantry.id}"
																		value="${gantry.gantryEleType}" class="form-control"
																		disabled></td> --%>
																	<td><select id="gantryType_${gantry.id}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${gantry.gantryType=='1'}">
																					<option value="${gantry.gantryType}"
																						selected="selected">Pole</option>
																					<option value="2">Structural</option>
																					
																				</c:when>

																				<c:when test="${gantry.gantryType=='2'}">
																					<option value="${gantry.gantryType}"
																						selected="selected">Structural</option>
																					<option value="1">Pole</option>
																				</c:when>

																			</c:choose>
																	</select></td>
																	<td><select id="gantryEleType_${gantry.id}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${gantry.gantryEleType=='1'}">
																					<option value="${gantry.gantryEleType}"
																						selected="selected">SBB</option>
																					<option value="2">DBB</option>
																					
																				</c:when>

																				<c:when test="${gantry.gantryEleType=='2'}">
																					<option value="${gantry.gantryEleType}"
																						selected="selected">DBB</option>
																					<option value="1">SBB</option>
																				</c:when>

																			</c:choose>
																	</select></td>
																		
																	<td><input type="text" id="noBusBar_${gantry.id}"
																		value="${gantry.noBusBar}" class="form-control" disabled></td>
																	 <td><input type="text" id="noBusSec_${gantry.id}"
																		value="${gantry.noBusSec}" class="form-control" disabled></td>
																	<td><input type="text" id="noInBays_${gantry.id}"
																		value="${gantry.noInBays}" class="form-control"
																		disabled></td>
																	<td><input type="text" id="noOutBays_${gantry.id}"
																		value="${gantry.noOutBays}" class="form-control"
																		disabled></td>
																	<td><input type="text" id="totalLandArea_${gantry.id}"
																		value="${gantry.totalLandArea}" class="form-control" disabled></td> 
																		
																	<td><input type="text" id="noAr_${gantry.id}"
																		value="${gantry.noAr}" class="form-control" disabled></td>
																	<td><input type="text" id="noLbs_${gantry.id}"
																		value="${gantry.noLbs}" class="form-control"
																		disabled></td>
																	<td><input type="text" id="noAbs_${gantry.id}"
																		value="${gantry.noAbs}" class="form-control"
																		disabled></td>
																	<td><input type="text" id="noSa_${gantry.id}"
																		value="${gantry.noSa}" class="form-control" disabled></td>
																		
																	<td><input type="text" id="noDdloLinks_${gantry.id}"
																		value="${gantry.noDdloLinks}" class="form-control" disabled></td>
																	 <td><input type="text" id="noDdloFuses_${gantry.id}"
																		value="${gantry.noDdloFuses}" class="form-control" disabled></td>
																	<td><input type="text" id="noIncomingFeeder_${gantry.id}"
																		value="${gantry.noIncomingFeeder}" class="form-control"
																		disabled></td>
																	<td><input type="text" id="noOutgoingFeeder_${gantry.id}"
																		value="${gantry.noOutgoingFeeder}" class="form-control"
																		disabled></td>
																	<td><input type="text" id="gpsLatitude_${gantry.id}"
																		value="${gantry.gpsLatitude}" class="form-control"
																		disabled></td>
																	<td><input type="text" id="gpsLongitude_${gantry.id}"
																		value="${gantry.gpsLongitude}" class="form-control"
																		disabled></td>

																	<td><select id="status_${gantry.id}"
																		class="form-control" disabled>
																			<c:choose>
																				<c:when test="${sessionScope.loggedUserRole=='DEO'}">
																					<option value="${gantry.status}" selected="selected">In
																						Bulk</option>
																					<option value="3">Send for Validation</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='ES'}">
																					<option value="${gantry.status}" selected="selected">Pending</option>
																					<option value="4">Send for Approval</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='EE'}">
																					<option value="${gantry.status}" selected="selected">Pending</option>
																					<option value="1">Approve</option>
																					<option value="2">Keep in Bulk</option>
																					<option value="0">Inactive</option>
																				</c:when>



																				<c:otherwise>
																					<option value="${gantry.status}" selected="selected">Not
																						Allowed</option>

																				</c:otherwise>

																			</c:choose>


																	</select></td>
                                                                    <td><input type="hidden" id="id_${gantry.id}"
																		value="${gantry.id}" class="form-control" disabled></td>

																	


																	<%--  <td><button type='button' class='btn btn-warning'
																			onClick='LoadGantryToEdit("${gantry.id}")'>Edit</button></td>
																	<td><button type='button' class='btn btn-success'
																			onClick='javascript:save("${gantry.id}")'>Save</button></td>
																  --%></tr>

															</c:forEach>
														</tbody>
													</table>
													
													





												</form:form>

											</tbody>
										</table>

									</div>

								
							</div>
							
							
						</div>
					</div>
					
					<div>
							<%-- <table class="table-responsive" align="center">
							<tbody>
							<tr style="text-align:center">

														
														<td style="padding-right:10px;">
															<button type='button' class='btn btn-warning'
																onClick='javascript:editAll("${model.stringOfGantryIds}")'>Edit
																All</button>
														</td>

														<td style="padding-right:10px;">
															<button type='button' class='btn btn-success'
																onClick='javascript:saveAll()'>Update All</button>
														</td>
														

														<td colspan="2" style="padding-right:10px;"><c:if test="${userType =='DEO'}">

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
													</tbody>
													</table> 
 --%>													</div>

					<%@ include file="sections/footer.jsp"%>

				</div>
			</div>
		</div>
	</div>

	<%@ include file="sections/global_scripts.jsp"%>

</body>
</html>