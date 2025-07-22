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

	
	function LoadfeederToEdit(pid) {
		enable(pid);
		arrayDataToSave.push(pid);

		
	}

	function editAll(stringIDs) {

		alert("You are going to edit that all feeders.. \n");
		var arrayAllIds = stringIDs.split(",");

		var len = arrayAllIds.length

		for (var count = 0; count < len; count++) {
			LoadfeederToEdit(arrayAllIds[count]);
		}

	}

	function disable(pid) {
		    
			
			document.getElementById("type_" + pid).disabled = true;
			document.getElementById("code_" + pid).disabled = true;
			document.getElementById("name_" + pid).disabled = true;
			document.getElementById("feedertype_" + pid).disabled = true;
			document.getElementById("conductor_" + pid).disabled = true;
			document.getElementById("noAr_" + pid).disabled = true;
			document.getElementById("noLbs_" + pid).disabled = true;
			document.getElementById("noAbs_" + pid).disabled = true;
			document.getElementById("noSa_" + pid).disabled = true;
			document.getElementById("status_" + pid).disabled = true;
			
		arrayDataToSave = [];
	}

	
	function enable(pid) {
		
		
		document.getElementById("type_" + pid).disabled = false;
		document.getElementById("code_" + pid).disabled = false;
		document.getElementById("name_" + pid).disabled = false;
		document.getElementById("feedertype_" + pid).disabled = false;
		document.getElementById("conductor_" + pid).disabled = false;
		document.getElementById("noAr_" + pid).disabled = false;
		document.getElementById("noLbs_" + pid).disabled = false;
		document.getElementById("noAbs_" + pid).disabled = false;
		document.getElementById("noSa_" + pid).disabled = false;
		document.getElementById("status_" + pid).disabled = false;
		
		
		
	}

	
	function saveAll() {
		
		var len = arrayDataToSave.length
		for (var count = 0; count < len; count++) {
			var pid = arrayDataToSave[count];
			
			var gantryId = document.getElementById("gantryId_" + pid).value;
			var type = document.getElementById("type_" + pid).value;
			var code = document.getElementById("code_" + pid).value;
			var name = document.getElementById("name_" + pid).value;
			var feedertype = document.getElementById("feedertype_" + pid).value;
			var conductor = document.getElementById("conductor_" + pid).value;
			var noAr = document.getElementById("noAr_" + pid).value;
			var noLbs = document.getElementById("noLbs_" + pid).value;
			var noAbs = document.getElementById("noAbs_" + pid).value;
			var noSa = document.getElementById("noSa_" + pid).value;
			var status = document.getElementById("status_" + pid).value;
				
			var url = "/MMS/updateFeeder/" + pid + "/" +gantryId+"/"+ type + "/" + code + "/"+ name + "/" + feedertype + "/" + conductor + "/" + noAr + "/"
					+ noLbs + "/" + noAbs + "/" + noSa + "/" + status + "/";

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
		alert("Feeders updated succesfully... ");
		
	}
	

	function save(pid) {
	
		var gantryId = document.getElementById("gantryId_" + pid).value;
		alert(gantryId);
		var type = document.getElementById("type_" + pid).value;
		var code = document.getElementById("code_" + pid).value;
		var name = document.getElementById("name_" + pid).value;
		var feedertype = document.getElementById("feedertype_" + pid).value;
		var conductor = document.getElementById("conductor_" + pid).value;
		var noAr = document.getElementById("noAr_" + pid).value;
		var noLbs = document.getElementById("noLbs_" + pid).value;
		var noAbs = document.getElementById("noAbs_" + pid).value;
		var noSa = document.getElementById("noSa_" + pid).value;
		var status = document.getElementById("status_" + pid).value;
			
		var url = "/MMS/updateFeeder/" + pid + "/" +gantryId+"/"+ type + "/" + code + "/"+ name + "/" + feedertype + "/" + conductor + "/" + noAr + "/"
				+ noLbs + "/" + noAbs + "/" + noSa + "/" + status + "/";
		//alert(url);

		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				alert("feeder updated succesfully...");
				console.log(response);
				window.location.reload();
				disable(pid);
			}
		});

	}

	function sendForValidation() {
		//alert("dfg");
		
        var url = "/MMS/updateFeederStatusNew/";
		
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
									<li class="active"><span>Edit Feeder </span></li>
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
												<form:form method="post" action="displayfeederNewS" modelAttribute="model">
													
													
													<table class="main-table" id="tblAdmin">

														<thead>
															<tr>
															    
															    <th class="text-center">Gantry</th>
																<th class="text-center">Type</th>
																<th class="text-center">Bay Number</th>
																<th class="text-center">Description</th>
																<th class="text-center">Feeder Type</th>
																<th class="text-center">Conductor Type</th>
																<th class="text-center">No Of AutoRecloser</th>
																<th class="text-center">No Of LBS</th>
																<th class="text-center">No Of ABS</th>
																<th class="text-center">No Of Surge Arrestors</th>
																<th class="text-center">Status</th>
																<th></th>
																<!-- <th class="text-center">Edit</th>
																<th class="text-center">Save</th> -->

															</tr>
														</thead>
														<tbody>
															<c:forEach var="feeder" items="${model.feederListEdit}">
																<tr>
																	
																    
																	<th><input type="text" id="gantryId_${feeder.id.feederId}"
																		value="${feeder.id.gantryId}" class="form-control" disabled></th> 
																	
																	<td><select id="type_${feeder.id.feederId}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${feeder.typeInOut=='1'}">
																					<option value="${feeder.typeInOut}"
																						selected="selected">Incoming</option>
																					<option value="2">Outgoing</option>
																					
																				</c:when>

																				<c:when test="${feeder.typeInOut=='2'}">
																					<option value="${feeder.typeInOut}"
																						selected="selected">Outgoing</option>
																					<option value="1">Incoming</option>
																				</c:when>

																			</c:choose>
																	</select></td>

																	<td><input type="text" id="code_${feeder.id.feederId}"
																		value="${feeder.code}" class="form-control" disabled></td>
																	
																	
																	<td><input type="text" id="name_${feeder.id.feederId}"
																		value="${feeder.name}" class="form-control" disabled></td>
															
																	<td><select id="feedertype_${feeder.id.feederId}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${feeder.feederType=='1'}">
																					<option value="${feeder.feederType}"
																						selected="selected">Overhead</option>
																					<option value="2">Underground</option>
																					
																				</c:when>

																				<c:when test="${feeder.feederType=='2'}">
																					<option value="${feeder.feederType}"
																						selected="selected">Underground</option>
																					<option value="1">Overhead</option>
																				</c:when>

																			</c:choose>
																	</select></td>	
																	
									
																	<td><select id="conductor_${feeder.id.feederId}"
																		class="form-control" disabled>

																			<c:forEach var="conType" items="${model.conTypeList}">

																				<c:choose>
																					<c:when
																						test="${conType.id != feeder.conductor}">
																						<option value="${conType.id}">${conType.type}</option>
																					</c:when>
																				</c:choose>

																			</c:forEach>

																			<c:forEach var="conType" items="${model.conTypeList}">
																				<c:choose>
																					<c:when
																						test="${conType.id == feeder.conductor}">
																						<option value="${conType.id}" selected="selected">${conType.type}</option>
																					</c:when>
																				</c:choose>
																			</c:forEach>
																	</select></td>


																	
																	<td><input type="text" id="noAr_${feeder.id.feederId}"
																		value="${feeder.noAr}" class="form-control" disabled></td>
																	<td><input type="text" id="noLbs_${feeder.id.feederId}"
																		value="${feeder.noLbs}" class="form-control"
																		disabled></td>
																	<td><input type="text" id="noAbs_${feeder.id.feederId}"
																		value="${feeder.noAbs}" class="form-control" disabled></td>
																	 <td><input type="text" id="noSa_${feeder.id.feederId}"
																		value="${feeder.noSa}" class="form-control" disabled></td>
																	

																	<td><select id="status_${feeder.id.feederId}"
																		class="form-control" disabled>
																			<c:choose>
																				<c:when test="${sessionScope.loggedUserRole=='DEO'}">
																					<option value="${feeder.status}" selected="selected">In
																						Bulk</option>
																					<option value="3">Send for Validation</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='ES'}">
																					<option value="${feeder.status}" selected="selected">Pending</option>
																					<option value="4">Send for Approval</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='EE'}">
																					<option value="${feeder.status}" selected="selected">Pending</option>
																					<option value="1">Approve</option>
																					<option value="2">Keep in Bulk</option>
																					<option value="0">Inactive</option>
																				</c:when>



																				<c:otherwise>
																					<option value="${feeder.status}" selected="selected">Not
																						Allowed</option>

																				</c:otherwise>

																			</c:choose>


																	</select></td>
                                                                    
                                                                    
                                                                    <td></td>
																	


																	<%-- <td><button type='button' class='btn btn-warning'
																			onClick='LoadfeederToEdit("${feeder.id.feederId}")'>Edit</button></td>
																	<td><button type='button' class='btn btn-success'
																			onClick='javascript:save("${feeder.id.feederId}")'>Save</button></td>
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
																onClick='javascript:editAll("${model.stringOfFeederIds}")'>Edit
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