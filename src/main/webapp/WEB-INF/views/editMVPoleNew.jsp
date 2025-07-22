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


table, th, td {
	border: 0px solid black;
	align: left;
	text-align: left;
}


	.scroll {
	    border-spacing: 0;
	    border: 0px solid black;
	}

	.scroll tbody,
	.scroll thead { 
	display: block;
	width: 100%;
	}
	
	thead tr th { 
	    height: 30px;
	    line-height: 30px;
	    
	}
	
	.scroll tbody {
	    height: 250px;
	    overflow-y: auto;
	    overflow-x: hidden;
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
Collapse


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

	function LoadProvincesToEdit(pid) {
		//if(document.getElementById("pstatus_"+pid).value == 0 || document.getElementById("pstatus_"+pid).value == 1 || document.getElementById("pstatus_"+pid).value == 4){
		//alert("This item is sent for approving or active item or inactive item. You cann't edit this");
		//}
		//else{
		enable(pid);
		//}
	}

	function disable(pid) {
		document.getElementById("poleNo_" + pid).disabled = true;
		document.getElementById("poleName_" + pid).disabled = true;
		document.getElementById("poleType_" + pid).disabled = true;
		document.getElementById("poleHeight_" + pid).disabled = true;
		document.getElementById("workingLoad_" + pid).disabled = true;
		document.getElementById("pstatus_" + pid).disabled = true;
		
		
		
	}
	function enable(pid) {
		document.getElementById("poleNo_" + pid).disabled = false;
		document.getElementById("poleName_" + pid).disabled = false;
		document.getElementById("poleType_" + pid).disabled = false;
		document.getElementById("poleHeight_" + pid).disabled = false;
		document.getElementById("workingLoad_" + pid).disabled = false;
		document.getElementById("pstatus_" + pid).disabled = false;
		
	}

	function save(pid) {
		//  alert('hiiiii');
		var poleNo = document.getElementById("poleNo_" + pid).value;
		pcode = pcode.replace(/\//g,'-');

		//   alert('hiiiii	1' +pcode);
		var poleName = document.getElementById("poleName_" + pid).value;
		pname = pname.replace(/\//g,'-');

		//   alert('hiiiii	2'+pname);
		var poleType = document.getElementById("poleType_" + pid).value;
		//   alert('hiiiii	3'+ptype);
		var poleHeight = document.getElementById("poleHeight_" + pid).value;
		//   alert('hiiiii	4'+plegnth);
		var workingLoad = document.getElementById("workingLoad_" + pid).value;
		//   alert('hiiiii	5' +parea);
		var pstatus = document.getElementById("pstatus_" + pid).value;
		//  alert('hiiiii	6' +ppoles);
				
		
		var url = "/MMS/updateLine/" + pid + "/" + pcode + "/" + pname + "/"
				+ ptype + "/" + plegnth + "/" + parea + "/" + ppoles + "/"
				+ ptowers + "/" + pcomdate + "/" + pstatus + "/" +pcirType+ "/" +pconType+"/"+feeder+"/";

		// alert('hiiiii' +url);

		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				alert("Line updated succesfully...");
				console.log(response);
				window.location.reload();
				disable(pid);
			}
		});

	}

	function sendForValidation() {

		//var province = $( '#province' ).find( ":selected" ).attr( "value" );	
		var area = $('#area').find(":selected").attr("value");
		//var line = $( '#line' ).find( ":selected" ).attr( "value" );

		//alert("province: " + province + ",  area: " + area + "  ,line: " + line);

		var url = "/MMS/updateLineStatusNew/" + area + "/";
		//alert(url);
		//alert("province: " + province + ",  area: " + area + "  ,line: " + line);
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



	//edited anushka 2019-01-08 -----------------------------------------------------------------------------------
	function saveAll() {
		var len = arrayDataToSave.length

		for (var count = 0; count < len; count++) {
			var pid = arrayDataToSave[count];

			var poleNo = document.getElementById("poleNo_" + pid).value;
			pcode = pcode.replace(/\//g,'-');

			//   alert('hiiiii	1' +pcode);
			var poleName = document.getElementById("poleName_" + pid).value;
			pname = pname.replace(/\//g,'-');

			//   alert('hiiiii	2'+pname);
			var poleType = document.getElementById("poleType_" + pid).value;
			//   alert('hiiiii	3'+ptype);
			var poleHeight = document.getElementById("poleHeight_" + pid).value;
			//   alert('hiiiii	4'+plegnth);
			var workingLoad = document.getElementById("workingLoad_" + pid).value;
			//   alert('hiiiii	5' +parea);
			var pstatus = document.getElementById("pstatus_" + pid).value;
			//  alert('hiiiii	6' +ppoles);
			
			var url = "/MMS/updateLine/" + pid + "/" + pcode + "/" + pname
					+ "/" + ptype + "/" + plegnth + "/" + parea + "/" + ppoles
					+ "/" + ptowers + "/" + pcomdate + "/" + pstatus + "/" +pcirType+"/"+pconType+"/"+feeder+"/";

			// alert('hiiiii' +url);

			$.ajax({
				type : "GET",
				url : url,
				success : function(response) {
					//alert("Line updated succesfully...");
					console.log(response);
					window.location.reload();
					disable(pid);
				}
			});
		}
		alert("Lines updated succesfully... ");
	}
	//-------------------------------------------------------------------------------------------------------------
	
	
	

	var arrayDataToSave = [];

	function LoadLinesToEdit(pid) {
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

		alert("You are going to edit that all lines.. \n" + stringIDs);
		var arrayAllIds = stringIDs.split(",");

		var len = arrayAllIds.length

		for (var count = 0; count < len; count++) {
			LoadLinesToEdit(arrayAllIds[count]);
		}

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
									<li class="active"><span>Edit MV Pole </span></li>
								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="main-box clearfix">
								
								<div class="main-box-body clearfix">
									<div class="table-responsive">
										<table class="table table-responsive" id="tblProvinces">

											<thead>

											</thead>
											<tbody>
												<form:form method="post" action="displayMVPoleNewS"
													modelAttribute="model">
													<table class="table table-responsive" id="tblProvinces">

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
														<%-- <tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">LINE</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="line" path="line.code" onchange="">

																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.lineList}" />
																</form:select></td>
														</tr> --%>
														<tr>
															<td style="text-align: left"><a href=""> <input
																	class="btn btn-info" type="submit" name="actionButton"
																	value="GO"></input></a></td>


														</tr>
													</table>
													<div id="table-scroll" class="table-scroll"> 
                                                        <table class="main-table" id="tblAdmin">

														<thead>
															<tr>
															<th class="text-center">Pole Number</th>
																
																<th class="text-center">Pole Name</th>
																<th class="text-center">Pole Type</th>
																<th class="text-center">Pole Heigth</th>
																<th class="text-center">Working Load</th>
																<!-- <th class="text-center">Area</th>
																<th class="text-center">No of Poles</th>
																<th class="text-center">No of Towers</th>
																<th class="text-center">COM Date</th>
																<th class="text-center">Conductor Type</th>
																<th class="text-center">Circuit Type</th>
																<th class="text-center">Feeder</th>
																 -->
																<th class="text-center">Status</th>
																<th class="text-center"></th>
																<th class="text-center"></th>

															</tr>
														</thead>
														<tbody>
															<c:forEach var="line" items="${model.mvPoleList}">
																<tr>
																	<th><input type="text" id="poleNo_${line.id}"
																		value="${line.poleNo}" class="form-control" disabled></th>
																	<td><input type="text" id="poleName_${line.id}"
																		value="${line.poleName}" class="form-control" disabled></td>
																	<td>
																	<select id="poleType_${line.id}"
																		class="form-control" disabled>
																			<c:choose>
																				<c:when test="${line.poleType==7}">
																					<option value="${line.poleType}" selected="selected">PS</option>
																					<option value="4">Tubular</option>
																					<option value="6">RC</option>
																					<option value="1">Wood</option>
																				</c:when>
																				<c:when test="${line.poleType==4}">
																					<option value="${line.poleType}" selected="selected">Tabular</option>
																					<option value="7">PS</option>
																					<option value="6">RC</option>
																					<option value="1">Wood</option>
																				</c:when>
																				<c:when test="${line.poleType==6}">
																					<option value="${line.poleType}" selected="selected">RC</option>
																					<option value="7">PS</option>
																					<option value="4">Tabular</option>
																					<option value="1">Wood</option>
																				</c:when>
																				<c:when test="${line.poleType==1}">
																					<option value="${line.poleType}" selected="selected">Wood</option>
																					<option value="7">PS</option>
																					<option value="4">Tabular</option>
																					<option value="6">RC</option>
																				</c:when>
																				<c:otherwise>
																					<option value="${line.poleType}" selected="selected">NONE</option>
																					<option value="7">PS</option>
																					<option value="4">Tabular</option>
																					<option value="6">RC</option>
																				<option value="1">Wood</option>
																				</c:otherwise>
																	</c:choose>
																	</select>
																	
																	
																	
																	</td>
																	<td>
																	<select id="poleHeight_${line.id}"
																		class="form-control" disabled>
																			<c:choose>
																				<c:when test="${line.poleHeight==1}">
																					<option value="${line.poleHeight}" selected="selected">9m</option>
																					<option value="2">10m</option>
																					<option value="3">11m</option>
																					<option value="4">13m</option>
																					
																				</c:when>
																				<c:when test="${line.poleHeight==2}">
																					<option value="${line.poleHeight}" selected="selected">10m</option>
																					<option value="1">9m</option>
																					<option value="3">11m</option>
																					<option value="4">13m</option>
																					
																				</c:when>
																				<c:when test="${line.poleHeight==3}">
																					<option value="${line.poleHeight}" selected="selected">11m</option>
																					<option value="1">9m</option>
																					<option value="2">10m</option>
																					<option value="4">13m</option>
																																									</c:when>
																				<c:when test="${line.poleHeight==4}">
																					<option value="${line.poleHeight}" selected="selected">13m</option>
																					<option value="1">9m</option>
																					<option value="2">10m</option>
																					<option value="3">11m</option>
																					
																				</c:when>
																				<c:otherwise>
																					<option value="${line.workingLoad}" selected="selected">NONE</option>
																					<option value="1">9m</option>
																					<option value="2">10m</option>
																					<option value="3">11m</option>
																					<option value="4">13m</option>
																					
																				</c:otherwise>
																				
																	</c:choose>
																	</select>
																	</td>
																	<td>
																	<select id="workingLoad_${line.id}"
																		class="form-control" disabled>
																			<c:choose>
																				<c:when test="${line.workingLoad==6}">
																					<option value="${line.workingLoad}" selected="selected">300 kg</option>
																					<option value="5">1200 kg</option>
																					<option value="1">225 kg</option>
																					<option value="3">500 kg</option>
																					<option value="4">850 kg</option>
																					<option value="2">350 kg</option>
																				</c:when>
																				<c:when test="${line.workingLoad==5}">
																					<option value="${line.workingLoad}" selected="selected">1200 kg</option>
																					<option value="6">300 kg</option>
																					<option value="1">225 kg</option>
																					<option value="3">500 kg</option>
																					<option value="4">850 kg</option>
																					<option value="2">350 kg</option>
																				</c:when>
																				<c:when test="${line.workingLoad==1}">
																					<option value="${line.workingLoad}" selected="selected">225 kg</option>
																					<option value="6">300 kg</option>
																					<option value="5">1200 kg</option>
																					<option value="3">500 kg</option>
																					<option value="4">850 kg</option>
																					<option value="2">350 kg</option>																				</c:when>
																				<c:when test="${line.workingLoad==3}">
																					<option value="${line.workingLoad}" selected="selected">500 kg</option>
																					<option value="6">300 kg</option>
																					<option value="5">1200 kg</option>
																					<option value="1">225 kg</option>
																					<option value="4">850 kg</option>
																					<option value="2">350 kg</option>
																				</c:when>
																				<c:when test="${line.workingLoad==4}">
																					<option value="${line.workingLoad}" selected="selected">850 kg</option>
																					<option value="6">300 kg</option>
																					<option value="5">1200 kg</option>
																					<option value="1">225 kg</option>
																					<option value="3">500 kg</option>
																					<option value="2">350 kg</option>
																				</c:when>
																				<c:when test="${line.workingLoad==2}">
																					<option value="${line.workingLoad}" selected="selected">350 kg</option>
																					<option value="6">300 kg</option>
																					<option value="5">1200 kg</option>
																					<option value="1">225 kg</option>
																					<option value="3">500 kg</option>
																					<option value="4">850 kg</option>
																				</c:when>
																				
																				<c:otherwise>
																					<option value="${line.workingLoad}" selected="selected">NONE</option>
																					<option value="6">300 kg</option>
																					<option value="5">1200 kg</option>
																					<option value="1">225 kg</option>
																					<option value="3">500 kg</option>
																					<option value="4">850 kg</option>
																					<option value="2">350 kg</option>
																				</c:otherwise>
																				
																	</c:choose>
																	</select></td>
																	
																	<td><select id="pstatus_${line.id}"
																		class="form-control" disabled>
																			<c:choose>
																				<c:when test="${sessionScope.loggedUserRole=='DEO'}">
																					<option value="${line.status}" selected="selected">In Bulk</option>
																					<option value="3">Send for Validation</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='ES'}">
																					<option value="${line.status}" selected="selected">Pending</option>
																					<option value="2">In Bulk</option>
																					<option value="4">Send for Approval</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='EE'}">
																					<option value="${line.status}" selected="selected">Pending</option>
																					<option value="1">Approve</option>
																					<option value="2">In Bulk</option>
																					<option value="0">Inactive</option>
																				</c:when>



																				<c:otherwise>
																					<option value="${line.status}" selected="selected">Not Allowed</option>

																				</c:otherwise>

																			</c:choose>


																	</select></td>
																	
																	
																	
																	
<%-- 																	<td><input type="text" id="pid" value="${line.id}"
																		class="form-control" disabled></td>

																	<td><input type="text" id="pname_${line.id}"
																		value="${line.lineName}" class="form-control" disabled></td>
																	<td><select id="ptype_${line.id}"
																		class="form-control" disabled>
																			<c:choose>
																				<c:when test="${line.lineType==1}">
																					<option value="${line.lineType}"
																						selected="selected">Backbone</option>
																					<option value="2">Distributor</option>
																				</c:when>
																				<c:otherwise>
																					<option value="${line.lineType}"
																						selected="selected">Distributor</option>
																					<option value="1">Backbone</option>

																				</c:otherwise>

																			</c:choose>
																	</select></td>
																	
																	<td><select id="ptype_${line.id}" class="form-control" disabled>

																			<c:forEach var="linetype" items="${model.linetype}">

																				<c:choose>
																					<c:when
																						test="${linetype.id != line.lineType}">
																						<option value="${linetype.id}">${linetype.lineType}</option>
																					</c:when>
																				</c:choose>

																			</c:forEach>

																			<c:forEach var="linetype" items="${model.linetype}">
																				<c:choose>
																					<c:when
																						test="${linetype.id == line.lineType}">
																						<option value="${linetype.id}" selected="selected">${linetype.lineType}</option>
																					</c:when>
																				</c:choose>
																			</c:forEach>
																	</select></td>
																	<td><input type="text" id="plegnth_${line.id}"
																		value="${line.length}" class="form-control" disabled></td>
																	<td><input type="text" id="parea_${line.id}"
																		value="${line.area}" class="form-control" disabled></td>
																	<td><input type="text" id="ppoles_${line.id}"
																		value="${line.noofpoles}" class="form-control"
																		disabled></td>
																	<td><input type="text" id="ptowers_${line.id}"
																		value="${line.nooftowers}" class="form-control"
																		disabled></td>
																	<td><input type="text" id="pcomdate_${line.id}"
																		value="${line.comdate }" class="form-control" disabled></td>


																	
																	<td><select id="conType_${line.id}"
																		class="form-control" disabled>

																			<c:forEach var="conType" items="${model.conTypeList}">

																				<c:choose>
																					<c:when
																						test="${conType.id != line.conductorType}">
																						<option value="${conType.id}">${conType.type}</option>
																					</c:when>
																				</c:choose>

																			</c:forEach>

																			<c:forEach var="conType" items="${model.conTypeList}">
																				<c:choose>
																					<c:when
																						test="${conType.id == line.conductorType}">
																						<option value="${conType.id}" selected="selected">${conType.type}</option>
																					</c:when>
																				</c:choose>
																			</c:forEach>
																	</select></td>
																	
																	
																	
																	
																	
  <td><select id="noofCircuit_${line.id}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${line.circuitType=='1'}">
																					<option value="${line.circuitType}"
																						selected="selected">Single</option>
																					<option value="2">Double</option>
																					<option value="3">Both</option>
																				</c:when>

																				<c:when test="${line.circuitType=='2'}">
																					<option value="${line.circuitType}"
																						selected="selected">Double</option>
																					<option value="1">Single</option>
																					<option value="3">Both</option>
																				</c:when>

																				<c:when test="${line.circuitType=='3'}">
																					<option value="${line.circuitType}"
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
																	<td><input type="text" id="pfeeiden_${line.id}"
																		value="${line.feederIdentification }" class="form-control" disabled></td>
																	
																	
																	<td><select id="pstatus_${line.id}"
																		class="form-control" disabled>
																			<c:choose>
																				<c:when test="${sessionScope.loggedUserRole=='DEO'}">
																					<option value="${line.status}" selected="selected">In
																						Bulk</option>
																					<option value="3">Send for Validation</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='ES'}">
																					<option value="${line.status}" selected="selected">Pending</option>
																					<option value="4">Send for Approval</option>
																				</c:when>

																				<c:when test="${sessionScope.loggedUserRole=='EE'}">
																					<option value="${line.status}" selected="selected">Pending</option>
																					<option value="1">Approve</option>
																					<option value="2">Keep in Bulk</option>
																					<option value="0">Inactive</option>
																				</c:when>



																				<c:otherwise>
																					<option value="${line.status}" selected="selected">Not
																						Allowed</option>

																				</c:otherwise>

																			</c:choose>


																	</select></td>

																	<td><select id="n14_${line.id}"
																		class="form-control" disabled>
																			<option value="" selected="selected"></option>
																			<option value="ES1COMWPS2">ES1COMWPS2</option>
																			<option value="ESPHM1">ESPHM1</option>
																	</select></td>
 --%>

																	<td><button type='button' class='btn btn-warning'
																			onClick='LoadProvincesToEdit("${line.id}")'>Edit</button></td>
																	<td><button type='button' class='btn btn-success'
																			onClick='javascript:save("${line.id}")'>Save</button></td>
																</tr>

															</c:forEach>
														</tbody>
													</table>
													</div>
													<tr>
													
													<!-- edited anushka 2019-01-08 -------------------------------------- -->
														<td>
															<button type='button' class='btn btn-warning'
																onClick='javascript:editAll("${model.stringOfLineIds}")'>Edit
																All</button>
														</td>

														<td>
															<button type='button' class='btn btn-success'
																onClick='javascript:saveAll()'>Update All</button>
														</td>
														<!-- ----------------------------------------------------------------- -->

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





												</form:form>

											</tbody>
										</table>

									</div>

								</div>
							</div>
						</div>
					</div>

					<%@ include file="sections/footer.jsp"%>

				</div>
			</div>
		</div>
	</div>

	<%@ include file="sections/global_scripts.jsp"%>

</body>
</html>