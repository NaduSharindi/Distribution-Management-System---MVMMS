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

				<%@ include file="sections/userLevelsOther.jsp"%>

				<div id="content-wrapper">

					<div class="row">
						<div class="col-lg-12">
							<div class="col-lg-9">
								<ol class="breadcrumb">
									<li><a href="#">Home</a></li>
									<c:choose>
																	<c:when test="${model.mode=='HOTLINE'}">
																	<li class="active"><span>Hot Line Maintenance</span></li>
																	</c:when>
																	<c:when test="${model.mode=='TTWT'}">
																	<li class="active"><span>Tension Tower Without Tapping</span></li>
																	</c:when>
																	<c:when test="${model.mode=='CLE'}">
																	<li class="active"><span>Cold Line Electrical</span></li>
																	</c:when>
																	<c:when test="${model.mode=='CLC'}">
																	<li class="active"><span>Cold Line Civil</span></li>
																	</c:when>
																	<c:when test="${model.mode=='MW'}">
																	<li class="active"><span>Miscellaneous Works</span></li>
																	</c:when>
																	<c:when test="${model.mode=='EWOP'}">
																	<li class="active"><span>Electrical Works On Poles</span></li>
																	</c:when>
																	<c:when test="${model.mode=='VR'}">
																	<li class="active"><span>Vegetation Schedule</span></li>
																	</c:when>
																	<c:when test="${model.mode=='TP'}">
																	<li class="active"><span>Tapping Detail Report</span></li>
																	</c:when>
																	<c:when test="${model.mode=='MPL'}">
																	<li class="active"><span>Missing Parts Report</span></li>
																	</c:when>
																	
																	<c:when test="${model.mode=='HAR'}">
																	<li class="active"><span>Cycle Wise Data Storage</span></li>
																	</c:when>
																	<c:when test="${model.mode=='HAR2'}">
																	<li class="active"><span>Cycle Wise Data Storage</span></li>
																	</c:when>
																	
																	<c:when test="${model.mode=='CANCEL'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton" value="Reject"></input>

																	</c:when>
																	
																																		

																	<c:otherwise>

																	</c:otherwise>
																</c:choose> 

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
												<form:form method="post" action="GenerateScheduleAndReport"
													modelAttribute="model">

													<table class="table table-responsive" id="tblProvinces">
														<form:hidden path="mode" />
														<c:set var="myVar" value="${model.mode}" />


														 <tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">Province</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="province" path="glcompmobj.compId"
																	onchange="findArea()"
																	style="width:50%; background-color: #8187ff; border-radius: 5px;">
																	<form:options items="${model.provinceList}" />
																</form:select></td>

														</tr> 
														<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">Area</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="area" path="gldeptobj.deptId" onchange="getLine()"
																	style="width:50%; background-color: #94cb71; border-radius: 5px;">
																	 <form:option value="NONE" label="ALL" />
																	 <form:options items="${model.areaList}" />
																</form:select></td>

														</tr>
														<c:if test="${model.mode !='HAR' && model.mode !='HAR2'}">
														
														<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">Line</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="line" path="line.code" onchange=""
																	style="width:50%; background-color: #dac698; border-radius: 5px;">

																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.lineList}" />
																</form:select></td>
														</tr>
<tr>
														
														
														<td width="30%" style="text-align: left"><form:label
																	path="">Cycle</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="cycle" path="cycleObj.id.cycleId" onchange="" style="width:50%; background-color: #94cb71; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.cycleList}" />

																	
																</form:select></td>
														</tr>
														
</c:if>

														<%-- <tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">Cycle</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="method" path="cycle" onchange="">

																	<form:option value="" label="ALL " />
																	<form:option value="201901" label="201901" />
																	<form:option value="201801" label="201801" />
																
																</form:select></td>
														</tr> --%>
														<!-- 	<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="" for="txtLUTD">From Date :
											</form:label></td>
															<td width="70%" style="text-align: left"><form:input
																	path="" type="datetime-local" class="form-control"
																	id="txtLUTD" placeholder="Date and Time" /> <span
																id="spnLUTD" class="label label-danger"></span></td>
														</tr>

														<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="" for="txtLUTD">To Date :
											</form:label></td>
															<td width="70%" style="text-align: left"><form:input
																	path="" type="datetime-local" class="form-control"
																	id="txtLUTD" placeholder="Date and Time" /> <span
																id="spnLUTD" class="label label-danger"></span></td>
														</tr>
														<tr>-->
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

															<td colspan="2"><c:if test="${myVar =='HOTLINE'}">

																</c:if> <input type="hidden" name="actionButton" value="" /> <c:choose>
																	<c:when test="${model.mode=='HOTLINE'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Hot Line Maintenance "></input>
																			
																	</c:when>
																	<c:when test="${model.mode=='TTWT'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Tension Tower Without Tapping"></input>

																	</c:when>
																	<c:when test="${model.mode=='CLE'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Cold Line Electrical"></input>

																	</c:when>
																	<c:when test="${model.mode=='CLC'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Cold Line Civil"></input>

																	</c:when>
																	<c:when test="${model.mode=='MW'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Miscellaneous Works"></input>

																	</c:when>
																	<c:when test="${model.mode=='EWOP'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Electrical Works On Poles"></input>

																	</c:when>
																	<c:when test="${model.mode=='VR'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Vegetation Schedule"></input>

																	</c:when>
																	<c:when test="${model.mode=='TP'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Tapping Detail Report"></input>

																	</c:when>
																	<c:when test="${model.mode=='MPL'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Missing Parts Report"></input>

																	</c:when>
																	<c:when test="${model.mode=='HAR'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Cycle Wise Data Storage"></input>

																	</c:when>
																	<c:when test="${model.mode=='HAR2'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton"
																			value="View Cycle Wise Data Storage"></input>

																	</c:when>
																	
																	
																	<c:when test="${model.mode=='CANCEL'}">
																		<input id="pivFormBtn" class="btn btn-success"
																			type="submit" name="actionButton" value="Reject"></input>

																	</c:when>

																	<c:otherwise>

																	</c:otherwise>
																</c:choose> <input id="pivFormBtn" class="btn btn-success"
																type="submit" name="actionButton" value="Exit"></input></td>
														</tr>


														<!-- <tr>
        														<td  style="text-align:left"   ><a href="../MMS/GenerateReportTM?area=431&line=49">
        														<input class="button" type="submit" name="actionButton"	value="View"></input></a> 
        														</td>
        														</tr>-->
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