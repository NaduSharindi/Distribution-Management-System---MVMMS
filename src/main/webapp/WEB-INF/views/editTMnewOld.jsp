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
									<li class="active"><span>Edit Tower Maintenance </span></li>
								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="main-box clearfix">
								<header class="main-box-header clearfix">
									<h2 class="pull-left">Edit Tower Maintenance</h2>
								</header>

								<div class="main-box-body clearfix">
									<div class="table-responsive">
										<table class="table table-responsive" id="tblProvinces">

											<thead>

											</thead>
											<tbody>
												<form:form method="post" action="editTMnewS"
													modelAttribute="model">
													<table class="table table-responsive" id="tblProvinces">

														<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">PROVINCE</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="province" path="glcompmobj.compId"
																	onchange="findArea()">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.provinceList}" />
															</form:select></td>

														</tr>
														<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">AREA</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="area" path="gldeptobj.deptId" onchange="getLine()">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.areaList}" />
																</form:select></td>

														</tr>
														<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">LINE</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="line" path="line.code" onchange="">

																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.lineList}" />
																</form:select></td>
														</tr>
														<tr>
														
														
														<td width="30%" style="text-align: left"><form:label
																	path="">CYCLE</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="cycle" path="cycle" onchange="">
																	<option value="201801"> 201801 </option>
													<option value="201802"> 201802 </option>
													<option value="201901"> 201901 </option>
													<option value="201902"> 201902 </option>
													<option value="202001"> 202001 </option>
													<option value="202002"> 202002 </option>

																	
																</form:select></td>
														</tr>
												
																										
															<!--	<td width="30%" style="text-align:left">
                												<form:label path="">LINE TYPE</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																
																     </td>  
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">CONDUCTOR TYPE</form:label>
																</td>
																<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																</td> 
																    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">CIRCUIT TYPE</form:label>
																</td>
																<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																
																    </td> 
        														</tr>
        														<tr>
                												<td width="30%" style="text-align:left">
                												<form:label path="">SUPPORT TYPE</form:label>
                												</td>
                												<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.supTypeList}"/>
																</form:select>
																
																   </td>  
        														</tr>
        														
        														
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												
                												<form:label path="">TOWER CONFIGURATION</form:label>
																</td>
																<td width="70%" style="text-align:left">
                												
																<form:select  path ="" onchange="">
																<form:option value="NONE" label="ALL" />
																 <form:options items="${model.provinceList}"/>
																</form:select>
																
																  </td>   
        														</tr>-->
														<tr>
															<td style="text-align: left"><a
																href=""> <input
																	class="btn btn-info" type="submit"
																	name="actionButton" value="GO"></input></a></td>
														
													
														</tr>
													</table>
													
													
													
													
                                                        <table class="table table-responsive" id="tblAdmin">

                                                            <thead>
                                                                <tr>
                                                             <th class="text-center">No</th>
															<th class="text-center">Tappings</th>
															<th class="text-center">No Of Pinpoles 1 </th>
															<th class="text-center">Switching Device 1</th>
															<th class="text-center">No Of Pinpoles 2 </th>
															<th class="text-center">Switching Device 2</th>
															<th class="text-center">No Of Pinpoles 3 </th>
															<th class="text-center">Switching Device 3</th>
															<th class="text-center">Missing Parts</th>
															<th class="text-center">Flash Over Sets</th>
															<th class="text-center">Way leaving Status</th>
															<th class="text-center">Base Concrete Status</th>
															<th class="text-center">Anti Climbing Status</th>
															<th class="text-center">Conductor Condition</th>
															<th class="text-center">Jumper Condition</th>
															<th class="text-center">Earth Conductor Condition</th>
															<th class="text-center">Maintenance Attention</th>
															<th class="text-center">Funguss Set No</th>
															<th class="text-center">WPIN set</th>
															<th class="text-center">End Fitting set</th>
															<th class="text-center">Special Observations</th>
															<th class="text-center">LUTD</th>
															<th class="text-center">Maintenance Date</th>
															<th class="text-center">Status</th>
															<th class="text-center">Approval Level</th>
 															<th class="text-center">Edit</th>
                                                            <th class="text-center">Save</th>

                                                                </tr>
                                                            </thead>
                                                            
                                                            <tbody>
                                                            <c:set var="count" value="0" scope="page" />
																
											           <c:forEach var="mmsTxtMnt" items="${model.mmsTxtMntList}"  varStatus="status">
														<tr>
														<td  style="text-align:center"   >${status.count}</td>
														<td><input type="number" id="nooftappings_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.nooftappings}" class="form-control" disabled></td>
														</tr>
														
														 <%-- <td><input type="number" id="id" value="${mmsTxtMnt.id.towerid}" class="form-control" disabled></td> 
														
														 <td><input type="text" id="pinpole1_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.pinpole1}" class="form-control" disabled></td>--%>
														 
														<!-- <td><input type="number" id="nooftappings_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.nooftappings}" class="form-control" disabled></td>

														   <td><input type="text" id="pinpole1_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.pinpole1}" class="form-control" disabled></td>
														   <td><input type="text" id="switchdev1_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.switchdev1}" class="form-control" disabled></td>
                                                           <td><input type="text" id="pinpole2_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.pinpole2}" class="form-control" disabled></td>
                                                           <td><input type="text" id="switchdev2_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.switchdev2}" class="form-control" disabled></td>
                                                       		<td><input type="text" id="pinpole3_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.pinpole3}" class="form-control" disabled></td>
                                                            <td><input type="text" id="switchdev3_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.switchdev3}" class="form-control" disabled></td>
                                                            <td><input type="text" id="noofmissingparts_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.noofmissingparts}" class="form-control" disabled></td>
                                                            <td><input type="text" id="nofflashoversets_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.flashoversetno}" class="form-control" disabled></td>
                                                            <td><input type="text" id="wayleavestatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.wayleavestatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="baseconcretestatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.baseconcretestatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="anticlimbingstatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.anticlimbingstatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="conductorstatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.conductorstatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="jumperstatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.jumperstatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="earthconductorstatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.earthconductorstatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="attentionstatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.attentionstatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="fungussetno_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.fungussetno}" class="form-control" disabled></td>
                                                            <td><input type="text" id="wpinset_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.wpinset}" class="form-control" disabled></td>
                                                            <td><input type="text" id="endfittingset_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.endfittingset}" class="form-control" disabled></td>
                                                            <td><input type="text" id="towerspecial_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.towerspecial}" class="form-control" disabled></td>
                                                            <td><input type="text" id="ludt_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.ludt}" class="form-control" disabled></td>
                                                            <td><input type="text" id="maintenancedate_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.maintenancedate}" class="form-control" disabled></td>
 --%>

                                                        <!--     </tr>    -->     
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
					</div>

					<%@ include file="sections/footer.jsp"%>

				</div>
			</div>
		</div>
	</div>

	<%@ include file="sections/global_scripts.jsp"%>

</body>
</html>