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
	
	function getConductorTypes()
	{			
			 $.ajax
             ({
                     type: 'GET',
                     url: '/MMS/findActiveConductorTypes/',
                     data: {},
                     contentType: "application/json; charset=utf-8",
                     success: function(response) 
                     {
                    	 $('#conductor').empty();
                         
                         //Insert item from the response
                         for (var i = 0; i < response.length; i++) {
                             var item = response[i];
                             $('#conductor').append($('<option>').text(item.type).attr('value', item.id));
                         }
                     }
              });		
	}

	
	var arrayDataToSave = [];

	function LoadlvpoleToEdit(pid) {
		
		enable(pid);

		arrayDataToSave.push(pid);

	}

	function editAll(stringIDs) {

		alert("You are going to edit that all lines.. \n" + stringIDs);
		var arrayAllIds = stringIDs.split(",");

		var len = arrayAllIds.length

		for (var count = 0; count < len; count++) {
			LoadlvpoleToEdit(arrayAllIds[count]);
		}

	}
	function LoadProvincesToEdit(pid) {
		enable(pid);
		
	}
	
	function disable(pid) {
		
		document.getElementById("poleno_"+pid).disabled = true;
		document.getElementById("polematerial_" + pid).disabled = true;
		document.getElementById("polearea_" + pid).disabled = true;
		document.getElementById("polecsc_" + pid).disabled = true;
		document.getElementById("polenoofstay_" + pid).disabled = true;
		document.getElementById("polenoofstruts_" + pid).disabled = true;
		document.getElementById("conType_" + pid).disabled = true;
		document.getElementById("polenoofconsumers1ph_" + pid).disabled = true;
		document.getElementById("polenoofconsumers3ph_" + pid).disabled = true;
		document.getElementById("polegpsLatitude_" + pid).disabled = true;
		document.getElementById("polegpsLongitude_" + pid).disabled = true;
		document.getElementById("pstatus_" + pid).disabled = true;
		
	}

	function enable(pid) {
		
		document.getElementById("poleno_"+pid).disabled = false;
		document.getElementById("polematerial_" + pid).disabled = false;
		document.getElementById("polearea_" + pid).disabled = false;
		document.getElementById("polecsc_" + pid).disabled = false;
		document.getElementById("polenoofstay_" + pid).disabled = false;
		document.getElementById("polenoofstruts_" + pid).disabled = false;
		document.getElementById("conType_" + pid).disabled = false;
		document.getElementById("polenoofconsumers1ph_" + pid).disabled = false;
		document.getElementById("polenoofconsumers3ph_" + pid).disabled = false;
		document.getElementById("polegpsLatitude_" + pid).disabled = false;
		document.getElementById("polegpsLongitude_" + pid).disabled = false;
		document.getElementById("pstatus_" + pid).disabled = false;
		
	}
	
	function save(pid) {
		
		   var poleNo = document.getElementById("poleno_"+pid).value;
		   var poleType = document.getElementById("polematerial_"+pid).value;
		   var poleArea = document.getElementById("polearea_"+pid).value;
		   var poleCSC = document.getElementById("polecsc_"+pid).value;
		   var noOfStay = document.getElementById("polenoofstay_"+pid).value;
		   var noOfStruts = document.getElementById("polenoofstruts_"+pid).value;
		   var conductorType = document.getElementById("conType_"+pid).value;
		   var noOfConsumers1ph = document.getElementById("polenoofconsumers1ph_"+pid).value;
		   var noOfConsumers3ph = document.getElementById("polenoofconsumers3ph_"+pid).value;
		   var gpsLatitude = document.getElementById("polegpsLatitude_"+pid).value;
		   var gpsLongitude = document.getElementById("polegpsLongitude_"+pid).value;
		   var status = document.getElementById("pstatus_"+pid).value;
		
		
		   var url = "/MMS/updatePole/"+pid+"/"+poleNo+"/"+poleType+"/"+poleArea+"/"+poleCSC+"/"+noOfStay+"/"+noOfStruts+"/"+conductorType+"/"+noOfConsumers1ph+"/"+noOfConsumers3ph+"/"+gpsLatitude+"/"+gpsLongitude+"/"+status+"/";
		   



		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				alert("Pole updated succesfully...");
				console.log(response);
				window.location.reload();
				disable(pid);
			}
		});

	}
	function saveAll() {
		var len = arrayDataToSave.length

		for (var count = 0; count < len; count++) {
			var pid = arrayDataToSave[count];
			   var poleNo = document.getElementById("poleno_"+pid).value;
			   var poleType = document.getElementById("polematerial_"+pid).value;
			   var poleArea = document.getElementById("polearea_"+pid).value;
			   var poleCSC = document.getElementById("polecsc_"+pid).value;
			   var noOfStay = document.getElementById("polenoofstay_"+pid).value;
			   var noOfStruts = document.getElementById("polenoofstruts_"+pid).value;
			   var conductorType = document.getElementById("conType_"+pid).value;
			   var noOfConsumers1ph = document.getElementById("polenoofconsumers1ph_"+pid).value;
			   var noOfConsumers3ph = document.getElementById("polenoofconsumers3ph_"+pid).value;
			   var gpsLatitude = document.getElementById("polegpsLatitude_"+pid).value;
			   var gpsLongitude = document.getElementById("polegpsLongitude_"+pid).value;
			   var status = document.getElementById("pstatus_"+pid).value;
			
			
			   var url = "/MMS/updatePole/"+pid+"/"+poleNo+"/"+poleType+"/"+poleArea+"/"+poleCSC+"/"+noOfStay+"/"+noOfStruts+"/"+conductorType+"/"+noOfConsumers1ph+"/"+noOfConsumers3ph+"/"+gpsLatitude+"/"+gpsLongitude+"/"+status+"/";
			   


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
		alert("Poles updated succesfully... ");
	}
	function sendForValidation() {
		//alert("dfg");
		
        var url = "/MMS/updateLvPoleStatus/";
		
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
									<li class="active"><span>Edit Lv Pole </span></li>
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
												<form:form method="post" action="displaymvpoleNewS" modelAttribute="model">
													
													
													<table class="main-table" id="tblAdmin">

														<thead>
															<tr>
															    
													    		<th class="text-center">Pole Id</th>
																<th class="text-center">Pole No</th>
																<th class="text-center">Pole Material</th>
																<th class="text-center">Pole Area</th>
																<th class="text-center">CSC</th>
																<th class="text-center">No of Stay </th>
																<th class="text-center">No of Strut</th>
																<th class="text-center">Line Details</th>
																<th class="text-center">No of Consumers(1ph)</th>
																<th class="text-center">No of Consumers(3ph)</th>
																<th class="text-center">Gps Latitude</th>
																<th class="text-center">Gps Longtitude</th>
																<th class="text-center">Status</th>
																<th></th>
																<th class="text-center">Edit</th>
																<th class="text-center">Save</th>

															</tr>
														</thead>
														<tbody>
															<c:forEach var="pole" items="${model.poleListEdit}">
																<tr>
																	<th><input type="text" id="pid_${pole.id}"
																		value="${pole.id}" class="form-control" disabled></th>
																	
																	
																	<td><input type="text" id="poleno_${pole.id}"
																		value="${pole.poleNo}" class="form-control" disabled></td>
															
																	
																	<td><select id="polematerial_${pole.id}"
																		class="form-control" disabled>

																			<c:forEach var="poletype" items="${model.poletype}">

																				<c:choose>
																					<c:when
																						test="${poletype.id != pole.poleType}">
																						<option value="${poletype.id}">${poletype.poleType}</option>
																					</c:when>
																				</c:choose>

																			</c:forEach>

																			<c:forEach var="poletype" items="${model.poletype}">
																				<c:choose>
																					<c:when
																						test="${poletype.id == pole.poleType}">
																						<option value="${poletype.id}" selected="selected">${poletype.poleType}</option>
																					</c:when>
																				</c:choose>
																			</c:forEach>
																	</select></td>
																	
																	<td><input type="text" id="polearea_${pole.id}"
																		value="${pole.area}" class="form-control" disabled></td>
																		
																	<td><input type="text" id="polecsc_${pole.id}"
																		value="${pole.csc}" class="form-control" disabled></td>
																		
																	<td><input type="text" id="polenoofstay_${pole.id}"
																		value="${pole.noOfStay}" class="form-control" disabled></td>
																	<td><input type="text" id="polenoofstruts_${pole.id}"
																		value="${pole.noOfStruts}" class="form-control" disabled></td>
														


																	
																	<td><select id="conType_${pole.id}"
																		class="form-control" disabled>

																			<c:forEach var="conType" items="${model.conTypeList}">

																				<c:choose>
																					<c:when
																						test="${conType.id != pole.conductorType}">
																						<option value="${conType.id}">${conType.type}</option>
																					</c:when>
																				</c:choose>

																			</c:forEach>

																			<c:forEach var="conType" items="${model.conTypeList}">
																				<c:choose>
																					<c:when
																						test="${conType.id == pole.conductorType}">
																						<option value="${conType.id}" selected="selected">${conType.type}</option>
																					</c:when>
																				</c:choose>
																			</c:forEach>
																	</select></td>
																	
																	<td><input type="text" id="polenoofconsumers1ph_${pole.id}"
																		value="${pole.noOfConsumers1ph}" class="form-control" disabled></td>
																		
																	<td><input type="text" id="polenoofconsumers3ph_${pole.id}"
																		value="${pole.noOfConsumers3ph}" class="form-control" disabled></td>
																		
																	<td><input type="text" id="polegpsLatitude_${pole.id}"
																		value="${pole.gpsLatitude}" class="form-control" disabled></td>
																	<td><input type="text" id="polegpsLongitude_${pole.id}"
																		value="${pole.gpsLongitude}" class="form-control" disabled></td>
																	
																	<td><select id="pstatus_${pole.id}"
																		class="form-control" disabled>
																			<c:choose>
																				<c:when test="${sessionScope.loggedUserRole=='DEO'}">
																					<option value="${pole.status}" selected="selected">In
																						Bulk</option>
																					<option value="3">Send for Validation</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='ES'}">
																					<option value="${pole.status}" selected="selected">Pending</option>
																					<option value="4">Send for Approval</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='EE'}">
																					<option value="${pole.status}" selected="selected">Pending</option>
																					<option value="1">Approve</option>
																					<option value="2">Keep in Bulk</option>
																					<option value="0">Inactive</option>
																				</c:when>



																				<c:otherwise>
																					<option value="${pole.status}" selected="selected">Not
																						Allowed</option>

																				</c:otherwise>

																			</c:choose>


																	</select></td>
																    <td></td>
																	


																	<td><button type='button' class='btn btn-warning'
																			onClick='LoadlvpoleToEdit("${pole.id}")'>Edit</button></td>
																	<td><button type='button' class='btn btn-success'
																			onClick='javascript:save("${pole.id}")'>Save</button></td>
																</tr>

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
							<table class="table-responsive" align="center">
							<tbody>
							<tr style="text-align:center">

														
														<td style="padding-right:10px;">
															<button type='button' class='btn btn-warning'
																onClick='javascript:editAll("${model.stringOfPoleIds}")'>Edit
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
													</div>

					<%@ include file="sections/footer.jsp"%>

				</div>
			</div>
		</div>
	</div>

	<%@ include file="sections/global_scripts.jsp"%>

</body>
</html>