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
<%@ include file="sections/dashboardCSS.jsp"%>


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
	// alert("hiiittt : "+strUser);
	
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
	
	//alert(division);
	
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
									<li class="active"><span>Information Reated to
											Sample</span></li>
								</ol>


							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="main-box">

								<div class="main-box-body clearfix">


									<!-- STEP 1 -->
									<c:if test="${step == 'step1'}">

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

										<form:form role="form" action="addPcbSampleStep2"
											method="post" modelAttribute="SaveSample">

											<!-- frist round selections ------------------------------------------------------------------------------->
											<table class="table table-striped table-bordered table-sm " id="tblSelections">
												<tbody>
													<tr>
												 <td width="30%" style="text-align: left">Division</td>
														<td width="70%" style="text-align: left">
														<form:select id="divison" path="pcbEquipment.divison"
																onchange="findProvinceByDivision()"
																style="width:100%; background-color: #FFFFF; border-radius: 5px;">
																<form:option value="NONE" label="DIVISION" />
																<form:options items="${SaveSample.divList}" />
															</form:select>
															</td>
														 <%-- 
														 <form:select
														    style="width:100%; background-color: #8187ff; border-radius: 5px;"
															path="category" class="form-control" onchange="findProvinceByDivision()"
															id="txtCategory" placeholder="<< Please select category >>">
															<form:option value="TR">Category 1-TR</form:option>
															
															<form:option value="GN">Category 1-GN</form:option>
															<form:option value="DD1">Category 2-DD1</form:option>
															<form:option value="DD2">Category 2-DD2</form:option>
															<form:option value="DD3">Category 2-DD3</form:option>
															<form:option value="DD4">Category 2-DD4</form:option>
															
															<form:option value="IDT">Category 3</form:option>
															<form:option value="3">Category 4</form:option>
														
														</form:select> <span id="spnCategory" class="label label-danger"></span></td>
														 --%> </tr>
														<tr>
														<td width="30%" style="text-align: left">Province</td>
														<td width="70%" style="text-align: left"><form:select id="province" path="pcbEquipment.branch"
																onchange="findArea()"
																style="width:100%; background-color: #FFFFF; border-radius: 5px;">
																<form:option value="NONE" label="PROVINCE" />
																<form:options items="${SaveSample.provinceList}" />
															</form:select>
															</td>
															</tr>
															
															<tr>
														<td width="30%" style="text-align: left">Area</td>
														<td width="70%" style="text-align: left"><form:select id="area" path="pcbEquipment.unit"
																style="width:100%; background-color: #FFFFF; border-radius: 5px;">
																<form:option value="ST" label="STORES" />
																<form:options items="${SaveSample.areaList}" />
															</form:select>
															</td>
															</tr>
														
														<%-- <form:select
																path="pcbEquipment.divison" class="form-control"
																id="txtDivison" placeholder="<< Select Category >>">

																<c:choose>

																	<c:when
																		test="${SaveSample.pcbEquipment.divison == null}">
																		<form:option value="-1" label="<< Select Division >>" />
																	</c:when>

																	<c:otherwise>
																		<c:forEach var="divisionList"
																			items="${SaveSample.divisionList}">
																			<c:if
																				test="${divisionList.id == SaveSample.pcbEquipment.divison}">
																				<option id="${divisionList.id}" selected="selected"
																					value="${divisionList.id}">${divisionList.name}</option>
																			</c:if>
																		</c:forEach>
																	</c:otherwise>

																</c:choose>

																<c:forEach var="divisionList"
																	items="${SaveSample.divisionList}">
																	<c:if
																		test="${divisionList.id != SaveSample.pcbEquipment.divison}">
																		<option id="${divisionList.id}"
																			value="${divisionList.id}">${divisionList.name}</option>
																	</c:if>
																</c:forEach>

															</form:select> <span id="spnDivison" class="label label-danger"></span></td>
 --%>														<%-- <td width="30%" style="text-align: left">Branch</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.branch" type="text"
																class="form-control" id="txtBranch"
																placeholder="Enter Branch" /> <span id="spnBranch"
															class="label label-danger"></span></td>
														 --%>
														<!-- </tr>
														 -->
													<tr>
													
													<%-- <td width="50%" style="text-align: left">Unit</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.unit" type="text"
																class="form-control" id="txtUnit"
																placeholder="Enter Unit" /> <span id="spnUnit"
															class="label label-danger"></span></td>
													 --%>	
														
														
														<%-- <form:select
																path="pcbEquipment.divison" class="form-control"
																id="txtDivison" placeholder="<< Select Category >>">

																<c:choose>

																	<c:when
																		test="${SaveSample.pcbEquipment.divison == null}">
																		<form:option value="-1" label="<< Select Division >>" />
																	</c:when>

																	<c:otherwise>
																		<c:forEach var="divisionList"
																			items="${SaveSample.divisionList}">
																			<c:if
																				test="${divisionList.id == SaveSample.pcbEquipment.divison}">
																				<option id="${divisionList.id}" selected="selected"
																					value="${divisionList.id}">${divisionList.name}</option>
																			</c:if>
																		</c:forEach>
																	</c:otherwise>

																</c:choose>

																<c:forEach var="divisionList"
																	items="${SaveSample.divisionList}">
																	<c:if
																		test="${divisionList.id != SaveSample.pcbEquipment.divison}">
																		<option id="${divisionList.id}"
																			value="${divisionList.id}">${divisionList.name}</option>
																	</c:if>
																</c:forEach>

															</form:select> <span id="spnDivison" class="label label-danger"></span></td>
 --%>														
														
													
													
													
																										
													
													<td width="30%" style="text-align: left">Manufacture LTL</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.manufactureLtl" class="form-control"
																id="txtManufactureLtl" placeholder="<< Yes / No >>">
																 <form:option value="-1"><< Yes / No >></form:option>
																 <form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnManufactureLtl" class="label label-danger"></span></td>
														</tr>
														<tr>	
															
														<td width="30%" style="text-align: left">Seal Type</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.seriaType" class="form-control"
																id="txtSeriaType" placeholder="<< Select Seal Type >>">
																 <form:option value="-1"><< Select Seal Type >></form:option>
																 <form:option value="seal">Seal 
																</form:option>
																<form:option value="None Seal">None-Seal</form:option>
															</form:select> <span id="spnSeriaType" class="label label-danger"></span></td>
											</tr>

													<tr>
														
														
														<%-- <td width="30%" style="text-align: left">Manufacture
																Year</td>
														<td width="70%" style="text-align: left"><form:select
																path="year" class="form-control"
																id="txtYear" placeholder="<< Select Manufacture Year >>">
																 <form:option value="-1"><< Select Manufacture Year >></form:option>
																 <form:option value="1">Before 1990 </form:option>
																<form:option value="2">After 1990 </form:option>
																<form:option value="3">After 2000 </form:option>
																
																</form:select> <span id="spnYear" class="label label-danger"></span></td>
																
														 --%>		
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

												</tbody>
											</table>

											<div class="form-group">
												<div class="pull-left">
													<input type="submit" Value="Go >>" class="btn btn-success" />
												</div>
											</div>

										</form:form>
									</c:if>



									<!-- STEP 2 -->
									<c:if test="${step == 'step2'}">

										<c:if test="${not empty errormsg}">
											<tr>
												<td colspan="2" class="msgSuccess" align="center">

													<div class="msgSuccess"
														style="color: red; font-weight: bold;">
														<c:out value="${errormsg}"></c:out>
													</div>
											</tr>
										</c:if>

										<form:form role="form" action="addPcbSampleStep2"
											method="post" modelAttribute="SaveSample">

											<table class="table table-striped table-bordered table-sm "id="tblSelections">
												<tbody>
																										<tr>
												 <td width="30%" style="text-align: left">Division</td>
														<td width="70%" style="text-align: left">
														<form:select id="divison" path="pcbEquipment.divison"
																onchange="findProvinceByDivision()"
																style="width:100%; background-color: #FFFFF; border-radius: 5px;">
																<form:option value="NONE" label="DIVISION" />
																<form:options items="${SaveSample.divList}" />
															</form:select>
															</td>
														 <%-- 
														 <form:select
														    style="width:100%; background-color: #8187ff; border-radius: 5px;"
															path="category" class="form-control" onchange="findProvinceByDivision()"
															id="txtCategory" placeholder="<< Please select category >>">
															<form:option value="TR">Category 1-TR</form:option>
															
															<form:option value="GN">Category 1-GN</form:option>
															<form:option value="DD1">Category 2-DD1</form:option>
															<form:option value="DD2">Category 2-DD2</form:option>
															<form:option value="DD3">Category 2-DD3</form:option>
															<form:option value="DD4">Category 2-DD4</form:option>
															
															<form:option value="IDT">Category 3</form:option>
															<form:option value="3">Category 4</form:option>
														
														</form:select> <span id="spnCategory" class="label label-danger"></span></td>
														 --%> </tr>
														<tr>
														<td width="30%" style="text-align: left">Province</td>
														<td width="70%" style="text-align: left"><form:select id="province" path="pcbEquipment.branch"
																onchange="findArea()"
																style="width:100%; background-color: #FFFFF; border-radius: 5px;">
																<form:option value="NONE" label="PROVINCE" />
																<form:options items="${SaveSample.provinceList}" />
															</form:select>
															</td>
															</tr>
															
															<tr>
														<td width="30%" style="text-align: left">Area</td>
														<td width="70%" style="text-align: left"><form:select id="area" path="pcbEquipment.unit"
																style="width:100%; background-color: #FFFFF; border-radius: 5px;">
																<form:option value="NONE" label="AREA" />
																<form:option value="ST" label="STORES" />
																
																<form:options items="${SaveSample.areaList}" />
															</form:select>
															</td>
															</tr>
														
														<%-- <form:select
																path="pcbEquipment.divison" class="form-control"
																id="txtDivison" placeholder="<< Select Category >>">

																<c:choose>

																	<c:when
																		test="${SaveSample.pcbEquipment.divison == null}">
																		<form:option value="-1" label="<< Select Division >>" />
																	</c:when>

																	<c:otherwise>
																		<c:forEach var="divisionList"
																			items="${SaveSample.divisionList}">
																			<c:if
																				test="${divisionList.id == SaveSample.pcbEquipment.divison}">
																				<option id="${divisionList.id}" selected="selected"
																					value="${divisionList.id}">${divisionList.name}</option>
																			</c:if>
																		</c:forEach>
																	</c:otherwise>

																</c:choose>

																<c:forEach var="divisionList"
																	items="${SaveSample.divisionList}">
																	<c:if
																		test="${divisionList.id != SaveSample.pcbEquipment.divison}">
																		<option id="${divisionList.id}"
																			value="${divisionList.id}">${divisionList.name}</option>
																	</c:if>
																</c:forEach>

															</form:select> <span id="spnDivison" class="label label-danger"></span></td>
 --%>														<%-- <td width="30%" style="text-align: left">Branch</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.branch" type="text"
																class="form-control" id="txtBranch"
																placeholder="Enter Branch" /> <span id="spnBranch"
															class="label label-danger"></span></td>
														 --%>
														<!-- </tr>
														 -->
													<tr>
													
													<%-- <td width="50%" style="text-align: left">Unit</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.unit" type="text"
																class="form-control" id="txtUnit"
																placeholder="Enter Unit" /> <span id="spnUnit"
															class="label label-danger"></span></td>
													 --%>	
														
														
														<%-- <form:select
																path="pcbEquipment.divison" class="form-control"
																id="txtDivison" placeholder="<< Select Category >>">

																<c:choose>

																	<c:when
																		test="${SaveSample.pcbEquipment.divison == null}">
																		<form:option value="-1" label="<< Select Division >>" />
																	</c:when>

																	<c:otherwise>
																		<c:forEach var="divisionList"
																			items="${SaveSample.divisionList}">
																			<c:if
																				test="${divisionList.id == SaveSample.pcbEquipment.divison}">
																				<option id="${divisionList.id}" selected="selected"
																					value="${divisionList.id}">${divisionList.name}</option>
																			</c:if>
																		</c:forEach>
																	</c:otherwise>

																</c:choose>

																<c:forEach var="divisionList"
																	items="${SaveSample.divisionList}">
																	<c:if
																		test="${divisionList.id != SaveSample.pcbEquipment.divison}">
																		<option id="${divisionList.id}"
																			value="${divisionList.id}">${divisionList.name}</option>
																	</c:if>
																</c:forEach>

															</form:select> <span id="spnDivison" class="label label-danger"></span></td>
 --%>														
														
													
													
													
																										
													
													<td width="30%" style="text-align: left">Manufacture LTL</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.manufactureLtl" class="form-control"
																id="txtManufactureLtl" placeholder="<< Yes / No >>">
																 <form:option value="-1"><< Yes / No >></form:option>
																 <form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnManufactureLtl" class="label label-danger"></span></td>
															
													</tr>
													<tr>		
														<td width="30%" style="text-align: left">Seal Type</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.seriaType" class="form-control"
																id="txtSeriaType" placeholder="<< Select Seal Type >>">
																 <form:option value="-1"><< Select Seal Type >></form:option>
																 <form:option value="seal">Seal 
																</form:option>
																<form:option value="None Seal">None-Seal</form:option>
															</form:select> <span id="spnSeriaType" class="label label-danger"></span></td>
											</tr>

													<tr>
														
														
														<%-- <td width="30%" style="text-align: left">Manufacture
																Year</td>
														<td width="70%" style="text-align: left"><form:select
																path="year" class="form-control"
																id="txtYear" placeholder="<< Select Manufacture Year >>">
																 <form:option value="-1"><< Select Manufacture Year >></form:option>
																 <form:option value="1">Before 1990 </form:option>
																<form:option value="2">After 1990 </form:option>
																<form:option value="3">After 2000 </form:option>
																
																</form:select> <span id="spnYear" class="label label-danger"></span></td>
														 --%>		
																
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
												</tbody>
											</table>


											<!-- equipment id ----------------------------------------------------------------------------------------->
											
											<div id="table-scroll" class="table-scroll"> 
                                                        <table class="table table-striped table-bordered table-sm " id="tblAdmin">

																<thead>
																	<tr>
																		<th></th>
																		<th class="text-center">Tr Number</th>
																		<th class="text-center">Serial Number</th>
																		<th class="text-center">Province</th>
																		<th class="text-center">Location Description</th>
																		<th class="text-center">SIN No</th>
									</tr>
									</thead>
									<tbody>
									<c:set var="count" value="0" scope="page" />
																
															<c:forEach var="pcbModel" items="${SaveSample.listPcbModel}"  varStatus="status">
															
																<tr>
																<td  style="text-align:center"   >${status.count}</td>
																<td class="text-center"><a href="<c:url value='/editEquipmentNew?equid=${pcbModel.pcbEquipment.referenceNo}' />" >${pcbModel.pcbEquipment.referenceNo}</a></td>
          														<%-- <td class="text-center"><a href="<c:url value='/editEquipmentNew?equid=${pcbModel.equipmentId}' />" >${pcbModel.referenceNo}</a></td>
          --%>
																	<%-- <td><a href="<c:url value='/editEquipmentNew?equid=${pcbModel.pcbEquipment.equipmentId}' />" ><input type="text" id="pid" value="${pcbModel.pcbEquipment.equipmentId}"
																		class="form-control" disabled></a></td>
 															         --%><td class="text-center"><input class="text-center" type="text" id="prefNo_${pcbModel.pcbEquipment.equipmentId}"	value="${pcbModel.pcbEquipment.equipmentId}" class="form-control" disabled></td>
																	 <td class="text-center"><input class="text-center" type="text" id="pbranch_${pcbModel.pcbEquipment.equipmentId}"
																		value="${pcbModel.pcbEquipment.divison}" class="form-control" disabled></td>
																		<td class="text-center"><input class="text-center" type="text" id="pblocdes_${pcbModel.pcbEquipment.equipmentId}"
																		value="${pcbModel.pcbLocation.locationDescription}" class="form-control" disabled></td>
																		<td class="text-center"><input class="text-center" type="text" id="pblocdes_${pcbModel.pcbEquipment.equipmentId}"
																		value="${pcbModel.pcbSample.pcbTestData}" class="form-control" disabled></td>
									
									</tr>
									</c:forEach>
									
											 <div class="form-group">
												<div class="pull-left">
													<input type="submit" Value="Go >>" class="btn btn-success" />
												</div>
											</div>
											</table>
											
 </div>
 									
										</form:form>
									</c:if>



									<!-- STEP 3 -->
									<c:if test="${step == 'step3'}">
										<form:form role="form" action="MMSaddSample" method="post"
											modelAttribute="SaveSample">

											<!-- frist round selections ------------------------------------------------------------------------------->
											<table class="table table-responsive" id="tblSelections">
												<tbody>
													<tr>
														<td width="50%" style="text-align: left">Category</td>
														<td width="70%" style="text-align: left">
														
														<form:select
															path="category" class="form-control"
															id="txtCategory" placeholder="<< Please select category >>">
															<form:option value="TR">Category 1-TR</form:option>
															
															<form:option value="GN">Category 1-GN</form:option>
															<form:option value="DD1">Category 2-DD1</form:option>
															<form:option value="DD2">Category 2-DD2</form:option>
															<form:option value="DD3">Category 2-DD3</form:option>
															<form:option value="DD4">Category 2-DD4</form:option>
															
															<form:option value="IDT">Category 3</form:option>
															<form:option value="3">Category 4</form:option>
														
														</form:select> <span id="spnCategory" class="label label-danger"></span></td>
														
														
														<%-- <form:select
																path="pcbEquipment.divison" class="form-control"
																id="txtDivison" placeholder="<< Select Category >>">

																<c:choose>

																	<c:when
																		test="${SaveSample.pcbEquipment.divison == null}">
																		<form:option value="-1" label="<< Select Division >>" />
																	</c:when>

																	<c:otherwise>
																		<c:forEach var="divisionList"
																			items="${SaveSample.divisionList}">
																			<c:if
																				test="${divisionList.id == SaveSample.pcbEquipment.divison}">
																				<option id="${divisionList.id}" selected="selected"
																					value="${divisionList.id}">${divisionList.name}</option>
																			</c:if>
																		</c:forEach>
																	</c:otherwise>

																</c:choose>

																<c:forEach var="divisionList"
																	items="${SaveSample.divisionList}">
																	<c:if
																		test="${divisionList.id != SaveSample.pcbEquipment.divison}">
																		<option id="${divisionList.id}"
																			value="${divisionList.id}">${divisionList.name}</option>
																	</c:if>
																</c:forEach>

															</form:select> <span id="spnDivison" class="label label-danger"></span></td>
 --%>														<td></td>
 
 <td width="50%" style="text-align: left">Branch</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.branch" type="text"
																class="form-control" id="txtBranch"
																placeholder="Enter Brnach" /> <span id="spnBranch"
															class="label label-danger"></span></td>
														<td></td>

														</tr>
														<tr>
													
													<td width="50%" style="text-align: left"><strong>Unit</strong></td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.unit" type="text"
																class="form-control" id="txtUnit"
																placeholder="Enter Unit" /> <span id="spnUnit"
															class="label label-danger"></span></td>
 

																										
													
														<td width="30%" style="text-align: left"><strong>Manufacture LTL</strong></td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.manufactureLtl" class="form-control"
																id="txtManufactureLtl" placeholder="<< Yes / No >>">
																 <form:option value="-1"><< Yes / No >></form:option>
																 <form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnManufactureLtl" class="label label-danger"></span></td>
													</tr>
													<tr>
														<td width="30%" style="text-align: left">Seal Type</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.seriaType" class="form-control"
																id="txtSeriaType" placeholder="<< Select Seal Type >>">
																 <form:option value="-1"><< Select Seal Type >></form:option>
																 <form:option value="seal">Seal 
																</form:option>
																<form:option value="None Seal">None-Seal</form:option>
															</form:select> <span id="spnSeriaType" class="label label-danger"></span></td>
														<td></td>

														<td width="30%" style="text-align: left"><strong>Manufacture
																Year</strong></td>
														<td width="70%" style="text-align: left"><form:select
																path="year" class="form-control"
																id="txtYear" placeholder="<< Select Manufacture Year >>">
																 <form:option value="-1"><< Select Manufacture Year >></form:option>
																 <form:option value="1">Before 1990 </form:option>
																<form:option value="2">After 1990 </form:option>
																<form:option value="3">After 2000 </form:option>
																
																</form:select> <span id="spnYear" class="label label-danger"></span></td>
														
													</tr>

												</tbody>
											</table>


											<!-- equipment id ----------------------------------------------------------------------------------------->
											<table class="table table-responsive" id="tblEquipmentId">
												<tbody>

													<tr>
														<td width="30%" style="text-align: left">Equipment ID</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.equipmentId" class="form-control"
																id="txtEquipmentId"
																placeholder="<< Select Equipment ID >>">

																<c:choose>

																	<c:when
																		test="${SaveSample.pcbEquipment.equipmentId == null}">
																		<form:option value="-1"
																			label="<< Select Equipment ID >>" />
																	</c:when>

																	<c:otherwise>
																		<c:forEach var="equipmentIdList"
																			items="${SaveSample.equipmentIdList}">
																			<c:if
																				test="${equipmentIdList == SaveSample.pcbEquipment.equipmentId}">
																				<option id="${equipmentIdList}" selected="selected"
																					value="${equipmentIdList}">${equipmentIdList}</option>
																			</c:if>
																		</c:forEach>
																	</c:otherwise>

																</c:choose>

																<c:forEach var="equipmentIdList"
																	items="${SaveSample.equipmentIdList}">
																	<c:if
																		test="${equipmentIdList != SaveSample.pcbEquipment.equipmentId}">
																		<option id="${equipmentIdList}"
																			value="${equipmentIdList}">${equipmentIdList}</option>
																	</c:if>
																</c:forEach>

															</form:select> <span id="spnEquipmentId" class="label label-danger"></span></td>

														<td></td>
													</tr>
												</tbody>
											</table>


											<!-- equipment data -------------------------------------------------------------------------------------->
											<br>
											<h2 class="pull-left">
												<strong>Equipment Data</strong>
											</h2>

											<table class="table table-responsive" id="tblEquipmentData">
												<tbody>

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
																placeholder="Enter Branch" /> <span id="spnBranch"
															class="label label-danger"></span></td>
														<td></td>

														<td width="30%" style="text-align: left"><strong>Unit</strong></td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.unit" type="text"
																class="form-control" id="txtUnit"
																placeholder="Enter Unit" /> <span id="spnUnit"
															class="label label-danger"></span></td>
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

														<td width="30%" style="text-align: left"><strong>Capacity</strong></td>
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
																placeholder="Enter Manufacture Barnd" /> <span
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
													</tr>

													<tr>
														<td width="30%" style="text-align: left">Primary Sub</td>
														<td width="70%" style="text-align: left"><form:select
																path="pcbEquipment.primarySub" class="form-control"
																id="txtPrimarySub" placeholder="<< Yes / No >>">
																<form:option value="-1"><< Yes / No >></form:option>
																<form:option value="Yes">Yes</form:option>
																<form:option value="No">No</form:option>
															</form:select> <span id="spnPrimarySub" class="label label-danger"></span></td>
														<td></td>

														<td width="30%" style="text-align: left"><strong>Manufacture
																Date</strong></td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbEquipment.manufactureDate" type="date"
																class="form-control" id="txtManufactureDate"
																placeholder="Select Manufacture Date" /> <span
															id="spnManufactureDate" class="label label-danger"></span></td>
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
																Mask</strong></td>
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
														<td width="30%" style="text-align: left">Sampling
															Port</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbSample.samplingPort" type="text"
																class="form-control" id="txtSamplingPort"
																placeholder="Enter Sampling Port" /> <span
															id="spnSamplingPort" class="label label-danger"></span></td>
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
																path="pcbSample.remarks" type="text"
																class="form-control" id="txtRemarks"
																placeholder="Enter Remark" /> <span id="spnRemarks"
															class="label label-danger"></span></td>
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
																<form:option value="None Seal">Outdoor</form:option>
															</form:select> <span id="spnTypeOfLocated" class="label label-danger"></span></td>
														<td></td>

														<td width="30%" style="text-align: left"><strong>GPS
																location (Longitude)</strong></td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbLocation.gpsLongitude" type="text"
																class="form-control" id="txtGpsLongitude"
																placeholder="Enter GPS location (Longitude)" /> <span
															id="spnGpsLongitude" class="label label-danger"></span></td>

													</tr>



													<tr>
														<td width="30%" style="text-align: left">GPS location
															(Latitude)</td>
														<td width="70%" style="text-align: left"><form:input
																path="pcbLocation.gpsLatitude" type="text"
																class="form-control" id="txtGpsLatitude"
																placeholder="Enter GPS location (Latitude)" /> <span
															id="spnGpsLatitude" class="label label-danger"></span></td>
													</tr>


												</tbody>
											</table>









											<div class="form-group">
												<div class="pull-left">

													<input type="submit" Value="Add" class="btn btn-success" />

												</div>
											</div>

										</form:form>
									</c:if>


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
