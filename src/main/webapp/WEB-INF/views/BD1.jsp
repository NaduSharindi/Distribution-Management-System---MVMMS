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
<!-- meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"-->
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>MV-MMS</title>
<%@ include file="sections/headEdit.jsp"%>


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
	
	
	function forwardRequest(id){
		
		var strUser = userId.options[userId.selectedIndex].value;
		if(strUser != "NONE"){
		$.ajax({
			type : 'GET',
			url : "/MMS/sendRequestToES/" +id+ "/"+ strUser + "/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				alert("Succesfully forwarded...");
				window.location.reload();
				
			}
		});
		}else{
			alert("Please select the Electrical Superintendent");
			
		}
	}
	
	
	function viewMore(id) {
		//var x = document.getElementById("myNumber").value;
		var x = 5;
		var c="<img src='<c:url value="/resources/img/CEBImages/Tower1.png"/>'>";
		    
		  var arr = [];
		  for (var i = 0; i < x; i++) {
			 // alert(c);
			  arr.push(c);
		  
		  document.getElementById("demo").innerHTML = arr.join("");

		}
	}
	
	
	//generateEstimate
	
	function generateEstimate(id) {
		//alert(id);
		var strUser = appId.options[appId.selectedIndex].value;
		if(strUser != "NONE"){
		$.ajax({
			type : 'GET',
			url : "/MMS/generateEstimate/" +id+ "/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				alert("Succesfully Generated...");
				window.location.reload();
				
			}
		});
		}else{
			alert("Please select the applicant");
			
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
									<li class="active"><span>${submitType}</span></li>
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

											<thead>

											</thead>
											<tbody>
												<form:form method="post" action="displaySupportNewS"
													modelAttribute="model">


													<!-- edited 1 anushka open 2018-11-30 -->
													<c:set var="userType"
														value="${sessionScope.loggedUserRole}" />
													<!-- edited 1 anushka close 2018-11-30 -->

													 <table class="table table-responsive" id="tblProvinces">

																												
														
														<c:choose>
																<c:when test="${sessionScope.loggedUserRole=='EE'}">
																	<%-- <tr style="align:center">
														<td width="30%"></td>
															<td style="align:center"><strong>Electrical
																	Superintendent</strong></td>
															<td style="align:center"><form:select
																	id="userId" path="sauserm.userId" onchange=""  style="width:50%; background-color: #8187ff; border-radius: 5px;">
																	
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.saList}" />
																</form:select></td>

														</tr>
 --%>
																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='ES'}">
																	<tr style="align:center">
														<td width="30%"></td>
															<td style="align:center"><strong>Applicant</strong></td>
															<td style="align:center"><form:select
																	id="appId" path="applicant.idNo" onchange="" style="width:50%; background-color: #94cb71; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.appList}" />
																</form:select></td>

														</tr>

																</c:when>
																<c:otherwise>

																</c:otherwise>
															</c:choose>
														
														
														
														
														
														
														
														
														
														
														
														
														<%-- <tr>
															<td width="30%" style="text-align: left"><strong>Applicant</strong></td>
															<td width="70%" style="text-align: left"><form:select
																	id="userId" path="applicant.idNo" onchange="" style="width:50%; background-color: #94cb71; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.appList}" />
																</form:select></td>

														</tr>
 --%>


													</table> 

                                                       
													    <table class="main-table" id="tblAdmin">
 
														<thead>
															<tr>
															<th class="text-center">Inspection Request No</th>
															<th class="text-center">Area</th>
															
															<th class="text-center">Requirement</th>
															<th class="text-center">Requesting section/s to be inspected</th>
															
															<th class="text-center">Date </th>
															<th class="text-center">Time</th>
															<th class="text-center">Electrical Superintendent</th>
															
															<th></th>
																
															</tr>

														</thead>
														<tbody>
															<c:forEach var="email" items="${model.unReadInspectionReq}">
																<tr>
																 <th style="text-align:center; width:200 ">${email.approvalId}</th>
																 <td style="text-align:left">${email.referenceNo}</td>
																 
																 <td style="text-align:left">${email.req1}</td>
																 <td style="text-align:left">${email.req2}</td>
																 <td style="text-align:center; width:150">${email.approvedDate}</td>
																 <td style="text-align:center; width:150">${email.approvedTime}</td>
																 <td style="align:center"><form:select
																	id="userId" path="sauserm.userId" onchange=""  style="width:50%; background-color: #8187ff; border-radius: 5px;">
																	
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.saList}" />
																</form:select></td>
																 
																 <td ><button type='button' class='btn btn-warning'
																			onClick='viewMore("${email.approvalId}")'>More Info</button></td>
																 																
			<c:choose>
																<c:when test="${sessionScope.loggedUserRole=='EE'}">
																	
																			<td><button type='button' class='btn btn-warning'
																			onClick='forwardRequest("${email.approvalId}")'>Forward Request</button></td>
																	
																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='ES'}">
																	
																			<td><button type='button' class='btn btn-warning'
																			onClick='generateEstimate("${email.approvalId}")'>Generate Estimate</button></td>
																																	</c:when>
																<c:otherwise>

																</c:otherwise>
															</c:choose>
																			
																			
																			
																			
																			
																			
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
							<tbody style="text-align:center">
								<!-- edited 2 anushka open 2018-11-30 -->
<p id="demo"></p>
										
													<!-- edited 2 anushka close 2018-11-30 -->
							</tbody>
						</table>
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
