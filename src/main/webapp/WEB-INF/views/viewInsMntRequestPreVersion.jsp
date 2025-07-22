<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- libraries -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/font-awesome.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/nanoscroller.css"/>" />

<!-- global styles -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/compiled/theme_styles.css"/>" />

<!-- this page specific styles -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/fullcalendar.css"/>" />
<link rel="stylesheet" type="text/css" media="print"
	href="<c:url value="/resources/css/libs/fullcalendar.print.css" />" />
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="/resources/css/compiled/calendar.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/morris.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/daterangepicker.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/jquery-jvectormap-1.2.2.css"/>" />

<!-- Favicon -->
<link type="image/x-icon" href="favicon.png" rel="shortcut icon" />

<!-- google font libraries -->
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700,300|Titillium+Web:200,300,400'
	rel='stylesheet' type='text/css'>


<style type="text/css">
div#map_container {
	width: 100%;
	height: 500px;
	border-radius: 5px;
}

table, th, td {
	border: 0px solid black;
	align: left;
	text-align: left;
}

thead tr th { 
	        height: 30px;
	    line-height: 30px;
	    color:white;
	    background-color:#008ae6;
	}
	
	
	tbody { border-top: 0px solid black; }
	
	tbody td, thead th {
	    border-right: 0px solid black;
	}
	
	tbody td:last-child, thead th:last-child {
	    border-right: none;
	}
 
		
	/* tr:nth-child(even) {background-color: #E4DFDE;}
	 */
	
	

	
	 .table-scroll {
  position: relative;
  width:100%;
  z-index: 1;
  margin: auto;
  overflow: auto;
  height: 800px;
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
.table-scroll th{
padding: 5px 10px;
  border: 0px solid #000;
  background: #008ae6;
  vertical-align: top;
}
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
}  /* testing links*/

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
	//edited anushka 2019-01-08 ---------------------------------------------------------------------
	var arrayDataToSave = [];
	//---------------------------------------------------------------------------------------------------

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
	
	
function sendReply(id){
		//alert(id);
		//var strUser = userIdES.options[userIdES.selectedIndex].value;
		var remarks = document.getElementById("remarks").value;
		//alert(strUser);
		//if(strUser != "NONE"){
			//var strUser = "60041ES1";
			//alert(id);
		 $.ajax({
			type : 'GET',
			url : "/MMS/sendReplyToArea?id="+id+"&remarks="+remarks,
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				alert("Succesfully forwarded...");
				window.location.reload();
				
			}
		});
		 //}else{
			//alert("Please select the Electrical Superintendent");
			
		//}
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

	//edited anushka 2019-01-08 ----------------------------------------------------------------
	function LoadLinesToEdit(pid) {
		//if(document.getElementById("pstatus_"+pid).value == 0 || document.getElementById("pstatus_"+pid).value == 1 || document.getElementById("pstatus_"+pid).value == 4){
		//alert("This item is sent for approving or active item or inactive item. You cann't edit this");
		//}
		//else{
		enable(pid);
		arrayDataToSave.push(pid);

		//}
	}

	function editAll(stringIDs) {

		alert("You are going to edit that all lines.. \n" + stringIDs);
		var arrayAllIds = stringIDs.split(",");

		var len = arrayAllIds.length

		for (var count = 0; count < len; count++) {
			LoadLinesToEdit(arrayAllIds[count]);
		}

	}

	function disable(pid) {
		document.getElementById("pcode_" + pid).disabled = true;
		document.getElementById("pname_" + pid).disabled = true;
		document.getElementById("ptype_" + pid).disabled = true;
		document.getElementById("plegnth_" + pid).disabled = true;
		document.getElementById("parea_" + pid).disabled = true;
		document.getElementById("ppoles_" + pid).disabled = true;
		document.getElementById("ptowers_" + pid).disabled = true;
		document.getElementById("pcomdate_" + pid).disabled = true;
		document.getElementById("pstatus_" + pid).disabled = true;

		arrayDataToSave = [];
	}

	//-------------------------------------------------------------------------------------------

	function enable(pid) {
		document.getElementById("pcode_" + pid).disabled = false;
		document.getElementById("pname_" + pid).disabled = false;
		document.getElementById("ptype_" + pid).disabled = false;
		document.getElementById("plegnth_" + pid).disabled = false;
		document.getElementById("parea_" + pid).disabled = false;
		document.getElementById("ppoles_" + pid).disabled = false;
		document.getElementById("ptowers_" + pid).disabled = false;
		document.getElementById("pcomdate_" + pid).disabled = false;
		document.getElementById("pstatus_" + pid).disabled = false;
	}

	//edited anushka 2019-01-08 -----------------------------------------------------------------------------------
	function saveAll() {
		var len = arrayDataToSave.length
		alert('hiiiii ' + len);
		for (var count = 0; count < len; count++) {
			var pid = arrayDataToSave[count];

			//  alert('hiiiii');
			var pcode = document.getElementById("pcode_" + pid).value;
			//   alert('hiiiii	1' +pcode);
			var pname = document.getElementById("pname_" + pid).value;
			//   alert('hiiiii	2'+pname);
			var ptype = document.getElementById("ptype_" + pid).value;
			//   alert('hiiiii	3'+ptype);
			var plegnth = document.getElementById("plegnth_" + pid).value;
			//   alert('hiiiii	4'+plegnth);
			var parea = document.getElementById("parea_" + pid).value;
			//   alert('hiiiii	5' +parea);
			var ppoles = document.getElementById("ppoles_" + pid).value;
			//  alert('hiiiii	6' +ppoles);
			var ptowers = document.getElementById("ptowers_" + pid).value;
			//   alert('hiiiii	7' +ptowers);
			var pcomdate = document.getElementById("pcomdate_" + pid).value;
			//   alert('hiiiii	8' +pcomdate);
			var pstatus = document.getElementById("pstatus_" + pid).value;
			//   alert('hiiiii	9' +pstatus);
			//   alert('hiiiii');
			var url = "/MMS/updateLine/" + pid + "/" + pcode + "/" + pname
					+ "/" + ptype + "/" + plegnth + "/" + parea + "/" + ppoles
					+ "/" + ptowers + "/" + pcomdate + "/" + pstatus + "/";

			alert('hiiiii' +url);

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

	function save(pid) {
		//  alert('hiiiii');
		var pcode = document.getElementById("pcode_" + pid).value;
		//   alert('hiiiii	1' +pcode);
		var pname = document.getElementById("pname_" + pid).value;
		//   alert('hiiiii	2'+pname);
		var ptype = document.getElementById("ptype_" + pid).value;
		//   alert('hiiiii	3'+ptype);
		var plegnth = document.getElementById("plegnth_" + pid).value;
		//   alert('hiiiii	4'+plegnth);
		var parea = document.getElementById("parea_" + pid).value;
		//   alert('hiiiii	5' +parea);
		var ppoles = document.getElementById("ppoles_" + pid).value;
		//  alert('hiiiii	6' +ppoles);
		var ptowers = document.getElementById("ptowers_" + pid).value;
		//   alert('hiiiii	7' +ptowers);
		var pcomdate = document.getElementById("pcomdate_" + pid).value;
		//   alert('hiiiii	8' +pcomdate);
		var pstatus = document.getElementById("pstatus_" + pid).value;
		//   alert('hiiiii	9' +pstatus);
		//   alert('hiiiii');
		var url = "/MMS/updateLine/" + pid + "/" + pcode + "/" + pname + "/"
				+ ptype + "/" + plegnth + "/" + parea + "/" + ppoles + "/"
				+ ptowers + "/" + pcomdate + "/" + pstatus + "/";

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

	function MarkasRead(emailid) {

		var url = "/MMS/MarkasRead/" + emailid + "/" +"8"+"/";
		//alert(url);
		//alert("province: " + province + ",  area: " + area + "  ,line: " + line);
		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				alert("Succesfully Mark as Read...");
				console.log(response);
				window.location.reload();
				//disable( id );
			}
		});
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
	
	function searchStatus(key){
  	  switch (key) {
		case 20:
			return "Removed";			 
		case 6:
			return "Pending";			 
		case 95:
			return "Forwarded";	
		case 96:
			return "Recommend";	
		case 97:
			return "Not Recommend";
		case 99:
			return "Forwarded to ES";
		case 98:
			return "Estimate Generated";
		default:
  			return "Other";
  			 
  		

      }
	}
  	  
  	function openPopupSubmit(id)
  	{
  	      
  		//alert(id);
  		var url="downloadInterruptionReq?id="+id;
  	    var width = 1100;
  	    var height = 700;
  	    var left = parseInt((screen.availWidth/2) - (width/2));
  	    var top = parseInt((screen.availHeight/2) - (height/2));
  	    var windowFeatures = "width=" + width + ",height=" + height + 
  	    ",status,resizable,left=" + left + ",top=" + top +
  	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
  	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
  	           
  	}
  	
  	function openPopupRec(id)
  	{
  	      
  		//alert(id);
  		var url="downloadRecommendationLetter?id="+id;
  	    var width = 1100;
  	    var height = 700;
  	    var left = parseInt((screen.availWidth/2) - (width/2));
  	    var top = parseInt((screen.availHeight/2) - (height/2));
  	    var windowFeatures = "width=" + width + ",height=" + height + 
  	    ",status,resizable,left=" + left + ",top=" + top +
  	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
  	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
  	           
  	}
  	
  	function openPopupSubmitImg1(id)
  	{
  	      
  		//alert(id);
  		var url="downloadIntImgReq?id="+id+"&seq=1";
  	    var width = 1100;
  	    var height = 700;
  	    var left = parseInt((screen.availWidth/2) - (width/2));
  	    var top = parseInt((screen.availHeight/2) - (height/2));
  	    var windowFeatures = "width=" + width + ",height=" + height + 
  	    ",status,resizable,left=" + left + ",top=" + top +
  	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
  	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
  	           
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
									<li class="active"><span>${submitType} Status</span></li>
								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>
					
										<%-- <div class="container">
<div class="main">
<div class="upnew">
            	<div class="wrapper">
			<div class = "form">
													<form:form method="post" action=""	modelAttribute="model">


				<br>
				<br>
				<tr>
												 <td width="30%" style="text-align: left">Area</td>
														<td width="70%" style="text-align: left">
														<form:select id="unit" path="pcbEquipment.unit"
																onchange="this.form.submit()"
																style="width:100%; background-color: #FFFFF; border-radius: 5px;">
																<form:option value="NONE" label="Area" />
																<form:options items="${SaveSample.areaList}" />
															</form:select>
															</td>
															</tr>

<center>
<button type="submit" class="button button2" ><b>View<b></button> 
</center>
    <div class="table-responsive">
    <table id= "myTable" class="display table" width="100%">
        <thead>  
          <c:choose>
																<c:when test="${submitType=='Inspection'}">
															<tr>
															<th>Inspection Request No</th>
															<th>Status</th>
															
															<th>Area</th>
															
															<th>Requirement</th>
															<th>Requesting section/s to be inspected</th>
															
															<th>Date </th>
															<th>Time</th>
															<th>Estimate No</th>
															<c:if test="${sessionScope.loggedUserRole=='EE'}">
	
															<th>Send Reply</th>
															</c:if>	
																
															</tr>
															
														</c:when>
														<c:when test="${submitType=='Maintenance'}">
																<tr>
															<th>Inspection Request No</th>
															<th>Status</th>
															
															<th>Area</th>
															
															<th>Requirement</th>
															<th>Requesting section/s to be inspected</th>
															
															<th>Date </th>
															<th>Time</th>
															<th>Estimate No</th>
															<c:if test="${sessionScope.loggedUserRole=='EE'}">
	
															<th>Send Reply</th>
															</c:if>
																
																
															</tr>
															
														</c:when>
														<c:when test="${submitType=='Interruption'}">
																<tr>
															<th>Interruption Request No</th>
															<th>Status</th>
															
															<th>Area</th>
														    <th>Tower No From - To</th>
														    <th>Time Duration</th>
															<th>Requested EE/ES</th>
															
															
															<th>Field Work</th>
															<th>Generated Date & Time </th>
															<th>Forwarded Date & Time </th>
															<th>Interruption Request No</th>
															
																<th></th>
																<th></th>
																<th></th>
																
																<th></th>
																<th></th>
																<th></th>
																<th></th>
																
															</tr>
														</c:when>
														
														</c:choose>
														
														</thead>
														<tbody>
															<c:forEach var="email" items="${model.unReadInspectionReq}">
																<c:choose>
																<c:when test="${submitType=='Inspection'}">
														
																<tr>
																<td>${email.approvalId}<input type="text" id="" value="${email.approvalId}"  disabled></td>
																<td>
																   
																   <c:choose>
																  <c:when test="${email.toStatus=='6'}">Pending
																 <!--  <input type="text" id="" value="Pending" disabled>
																  --> </c:when>
																  <c:when test="${email.toStatus=='99'}">Forwarded to ES
																  <!-- <input type="text" id="" value="Forwarded to ES" disabled>
																   --></c:when>
																  <c:when test="${email.toStatus=='98'}">Estimate Generated
																 <!--  <input type="text" id="" value="Estimate Generated" disabled>
																  --> 
																  </c:when>
																   <c:when test="${email.toStatus=='20'}">Removed
																  <!-- <input type="text" id="" value="Removed"  disabled>
																   -->
																  </c:when>
																  <c:when test="${email.toStatus=='21'}">Reply Sent
																  </c:when>
																 
																  
																  </c:choose>
																  
																   
																   </td> 
																  
																<td>${email.referenceNo}</td>
																<td>${email.req1}</td>
																<td>${email.req2}</td>
																<td>${email.approvedDate}</td>
																<td>${email.approvedTime}</td>
																<td>${email.systemBy}</td>
			<c:if test="${sessionScope.loggedUserRole=='EE'}">
	
			<td><button type ='button' class='btn' title='Send'   onClick='sendReply("${email.approvalId}")'><i class="fa fa-check"></i></button>
																</td>
			</c:if>
			
</c:when>
<c:when test="${submitType=='Maintenance'}">
														
																<tr>
																<td>${email.approvalId}</td>
																<td>
																   
																   <c:choose>
																  <c:when test="${email.toStatus=='6'}">Pending
																  </c:when>
																  <c:when test="${email.toStatus=='99'}">Forwarded to ES
																  </c:when>
																  <c:when test="${email.toStatus=='98'}">Estimate Generated
																  </c:when>
																  <c:when test="${email.toStatus=='20'}">Removed
																  </c:when>
																   <c:when test="${email.toStatus=='21'}">Reply Sent
																  </c:when>
																 
																  </c:choose>
																  
																   
																   </td> 
																  
																<td>${email.referenceNo}</td>
																<td>${email.req1}</td>
																<td>${email.req2}</td>
																<td>${email.approvedDate}</td>
																<td>${email.approvedTime}</td>
																    <td>${email.systemBy}</td><c:if test="${sessionScope.loggedUserRole=='EE'}">
	
																    
			<td><button type ='button' class='btn' title='Send'   onClick='sendReply("${email.approvalId}")'><i class="fa fa-check"></i></button>
																</td>
			</c:if>
			</tr>
			
			
</c:when>
<c:when test="${submitType=='Interruption'}">
														
																<tr>
																<td>${email.approvalId}</td>
																<td>
																   
																   <c:choose>
																  <c:when test="${email.toStatus=='6'}">Sent by ES PHM/Pending at EE PHM
																  </c:when>
																  <c:when test="${email.toStatus=='95' && email.fromStatus=='1'}">Sent by EE PHM/Pending at Area Engineer
																  
																 <!--  <textarea style="text-align:left" id="" class="form-control" disabled>Sent by EE PHM/Pending at Area Engineer</textarea>
																  --> </c:when>
																  <c:when test="${email.toStatus=='95' && email.fromStatus=='2'}">Sent by EE PHM/Pending at Planning CE
																  
																 <!--  <textarea style="text-align:left" id="" class="form-control" disabled>Sent by EE PHM/Pending at Planning CE</textarea>
																  --> </c:when>
																   <c:when test="${email.toStatus=='95' && email.fromStatus=='3'}">Sent by EE PHM/Pending at Control Center EE
																  
																  <!-- <textarea style="text-align:left" id="" class="form-control" disabled>Sent by EE PHM/Pending at Control Center EE</textarea>
																   --></c:when>
																 
																  <c:when test="${email.toStatus=='96' && email.fromStatus=='1' }">Recommended by Area Engineer/Pending at Control Center
																  <!-- <textarea style="text-align:left" id="" class="form-control" disabled>Recommended by Area Engineer/Pending at Control Center</textarea>
																   --></c:when>
																  <c:when test="${email.toStatus=='96' && email.fromStatus=='2' }">Recommended by Planning CE/Pending at Control Center
																  <!-- <textarea style="text-align:left" id="" class="form-control" disabled>Recommended by Planning CE/Pending at Control Center</textarea>
																   --></c:when>
																   <c:when test="${email.toStatus=='96' && email.fromStatus=='3' }">Recommended by Control Center EE/Pending at Control Center
																  <!-- <textarea style="text-align:left" id="" class="form-control" disabled>Recommended by Control Center EE/Pending at Control Center</textarea>
																   --></c:when>
																 
																  <c:when test="${email.toStatus=='97'}">Not Recommended
																 <!--  <input style="text-align:left" type="text" id="" value="Not Recommended" class="form-control" disabled>
																  --> </c:when>
																  <c:when test="${email.toStatus=='20'}">Removed
																 <!--  <input style="text-align:left" type="text" id="" value="Removed" class="form-control" disabled>
																  --> </c:when>
																  
																  
																  </c:choose>
																  
																   
																   </td> 
																<td>${email.referenceNo}</td>
																
																<td>${email.fromto}</td>
																<td>${email.timeduration}</td>
																<td>${email.reason}</td>
																
																<td>${email.req2}</td>
																<td>${email.approvedDate} ${email.approvedTime}</td>
																<td>${email.forwardDate} ${email.forwardedTime}</td>
																	<td>${email.approvalId}</td>
															
																<td><button type='button' class='btn btn-success' onClick='openPopupSubmit("${email.approvalId}")'>Request Letter</button></td>
																<td><button type='button' class='btn btn-success' onClick='openPopupRec("${email.approvalId}")'>Recommendation Letter</button></td>
																<c:if test="${email.filename1 != null}">
  																	<td><button type='button' class='btn btn-success' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'">Image 1</button></td>
																</c:if>
																<c:if test="${email.filename2 != null}">
  																	<td><button type='button' class='btn btn-success' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'">Image 2</button></td>
																</c:if>
																<c:if test="${email.filename3 != null}">
  																	<td><button type='button' class='btn btn-success' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'">Image 3</button></td>
																</c:if>
																<c:if test="${email.filename4 != null}">
  																	<td><button type='button' class='btn btn-success' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'">Image 4</button></td>
																</c:if>
																<c:if test="${email.filename5 != null}">
  																	<td><button type='button' class='btn btn-success' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'">Image 5</button></td>
																</c:if>
</tr>
</c:when>

</c:choose>
			
			
																
																   
 </c:forEach>
 
                  </tbody>  
    </table>
    </div>
</form:form>
</div>
</div>
</div>
</div>
					</div>
					
 --%>					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					

<div class="row">
<div class="col-lg-12">
<div class="table-responsive">
<div class="table-scroll">
								
								
  	<div id="newst">
  	
  	<script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("example");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>
  	 <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for request no.." title="Type in a request no">
  <!-- <input type="text" id="remarks" placeholder="Enter remarks here.." title="Type remarks">
   -->
 <form:form method="post" action=""	modelAttribute="model">
													<c:set var="myVar" value="${model.mode}" />
																 	
 
  <table class="table table-striped table-bordered table-sm" id="example">
 
        
														<thead>
															
															
															
															<c:choose>
																<c:when test="${submitType=='Inspection'}">
															<tr>
															<th>Inspection Request No</th>
															<th>Status</th>
															
															<th>Area</th>
															
															<th>Requirement</th>
															<th>Requesting section/s to be inspected</th>
															
															<th>Date </th>
															<th>Time</th>
															<th>Estimate No</th>
															<c:if test="${sessionScope.loggedUserRole=='EE'}">
	
															<th>Send Reply</th>
															</c:if>	
																
															</tr>
															
														</c:when>
														<c:when test="${submitType=='Maintenance'}">
																<tr>
															<th>Inspection Request No</th>
															<th>Status</th>
															
															<th>Area</th>
															
															<th>Requirement</th>
															<th>Requesting section/s to be inspected</th>
															
															<th>Date </th>
															<th>Time</th>
															<th>Estimate No</th>
															<c:if test="${sessionScope.loggedUserRole=='EE'}">
	
															<th>Send Reply</th>
															</c:if>
																
																
															</tr>
															
														</c:when>
														<c:when test="${submitType=='Interruption'}">
																<tr>
															<th>Interruption Request No</th>
															<th>Status</th>
															
															<th>Area</th>
														    <th>Tower No From - To</th>
														    <th>Time Duration</th>
															<th>Requested EE/ES</th>
															
															
															<th>Field Work</th>
															<th>Generated Date & Time </th>
															<th>Forwarded Date & Time </th>
															<th>Interruption Request No</th>
															
																<th></th>
																<th></th>
																<th></th>
																
																<th></th>
																<th></th>
																<th></th>
																<th></th>
																
															</tr>
														</c:when>
														
														</c:choose>
														
														</thead>
														<tbody>
															<c:forEach var="email" items="${model.unReadInspectionReq}">
																<c:choose>
																<c:when test="${submitType=='Inspection'}">
														
																<tr>
																<td>${email.approvalId}<input type="text" id="" value="${email.approvalId}"  disabled></td>
																<td>
																   
																   <c:choose>
																  <c:when test="${email.toStatus=='6'}">Pending
																 <!--  <input type="text" id="" value="Pending" disabled>
																  --> </c:when>
																  <c:when test="${email.toStatus=='99'}">Forwarded to ES
																  <!-- <input type="text" id="" value="Forwarded to ES" disabled>
																   --></c:when>
																  <c:when test="${email.toStatus=='98'}">Estimate Generated
																 <!--  <input type="text" id="" value="Estimate Generated" disabled>
																  --> 
																  </c:when>
																   <c:when test="${email.toStatus=='20'}">Removed
																  <!-- <input type="text" id="" value="Removed"  disabled>
																   -->
																  </c:when>
																  <c:when test="${email.toStatus=='21'}">Reply Sent
																  </c:when>
																 
																  
																  </c:choose>
																  
																   
																   </td> 
																  
																<td>${email.referenceNo}</td>
																<td>${email.req1}</td>
																<td>${email.req2}</td>
																<td>${email.approvedDate}</td>
																<td>${email.approvedTime}</td>
																<td>${email.systemBy}</td>
			<c:if test="${sessionScope.loggedUserRole=='EE'}">
	
			<td><button type ='button' class='btn' title='Send'   onClick='sendReply("${email.approvalId}")'><i class="fa fa-check"></i></button>
																</td>
			</c:if>
			
</c:when>
<c:when test="${submitType=='Maintenance'}">
														
																<tr>
																<td>${email.approvalId}</td>
																<td>
																   
																   <c:choose>
																  <c:when test="${email.toStatus=='6'}">Pending
																  </c:when>
																  <c:when test="${email.toStatus=='99'}">Forwarded to ES
																  </c:when>
																  <c:when test="${email.toStatus=='98'}">Estimate Generated
																  </c:when>
																  <c:when test="${email.toStatus=='20'}">Removed
																  </c:when>
																   <c:when test="${email.toStatus=='21'}">Reply Sent
																  </c:when>
																 
																  </c:choose>
																  
																   
																   </td> 
																  
																<td>${email.referenceNo}</td>
																<td>${email.req1}</td>
																<td>${email.req2}</td>
																<td>${email.approvedDate}</td>
																<td>${email.approvedTime}</td>
																    <td>${email.systemBy}</td><c:if test="${sessionScope.loggedUserRole=='EE'}">
	
																    
			<td><button type ='button' class='btn' title='Send'   onClick='sendReply("${email.approvalId}")'><i class="fa fa-check"></i></button>
																</td>
			</c:if>
			</tr>
			
			
</c:when>
<c:when test="${submitType=='Interruption'}">
														
																<tr>
																<th>${email.approvalId}</th>
																<td>
																   
																   <c:choose>
																  <c:when test="${email.toStatus=='6'}">Sent by ES PHM/Pending at EE PHM
																  </c:when>
																  <c:when test="${email.toStatus=='95' && email.fromStatus=='1'}">Sent by EE PHM/Pending at Area Engineer
																  
																 <!--  <textarea style="text-align:left" id="" class="form-control" disabled>Sent by EE PHM/Pending at Area Engineer</textarea>
																  --> </c:when>
																  <c:when test="${email.toStatus=='95' && email.fromStatus=='2'}">Sent by EE PHM/Pending at Planning CE
																  
																 <!--  <textarea style="text-align:left" id="" class="form-control" disabled>Sent by EE PHM/Pending at Planning CE</textarea>
																  --> </c:when>
																   <c:when test="${email.toStatus=='95' && email.fromStatus=='3'}">Sent by EE PHM/Pending at Control Center EE
																  
																  <!-- <textarea style="text-align:left" id="" class="form-control" disabled>Sent by EE PHM/Pending at Control Center EE</textarea>
																   --></c:when>
																 
																  <c:when test="${email.toStatus=='96' && email.fromStatus=='1' }">Recommended by Area Engineer/Pending at Control Center
																  <!-- <textarea style="text-align:left" id="" class="form-control" disabled>Recommended by Area Engineer/Pending at Control Center</textarea>
																   --></c:when>
																  <c:when test="${email.toStatus=='96' && email.fromStatus=='2' }">Recommended by Planning CE/Pending at Control Center
																  <!-- <textarea style="text-align:left" id="" class="form-control" disabled>Recommended by Planning CE/Pending at Control Center</textarea>
																   --></c:when>
																   <c:when test="${email.toStatus=='96' && email.fromStatus=='3' }">Recommended by Control Center EE/Pending at Control Center
																  <!-- <textarea style="text-align:left" id="" class="form-control" disabled>Recommended by Control Center EE/Pending at Control Center</textarea>
																   --></c:when>
																 
																  <c:when test="${email.toStatus=='97'}">Not Recommended
																 <!--  <input style="text-align:left" type="text" id="" value="Not Recommended" class="form-control" disabled>
																  --> </c:when>
																  <c:when test="${email.toStatus=='20'}">Removed
																 <!--  <input style="text-align:left" type="text" id="" value="Removed" class="form-control" disabled>
																  --> </c:when>
																  
																  
																  </c:choose>
																  
																   
																   </td> 
																<td>${email.referenceNo}</td>
																
																<td>${email.fromto}</td>
																<td>${email.timeduration}</td>
																<td>${email.reason}</td>
																
																<td>${email.req2}</td>
																<td>${email.approvedDate} ${email.approvedTime}</td>
																<td>${email.forwardDate} ${email.forwardedTime}</td>
																	<td>${email.approvalId}</td>
															
																<td><button type='button' class='btn btn-success' onClick='openPopupSubmit("${email.approvalId}")'>Request Letter</button></td>
																<td><button type='button' class='btn btn-success' onClick='openPopupRec("${email.approvalId}")'>Recommendation Letter</button></td>
																<c:if test="${email.filename1 != null}">
  																	<td><button type='button' class='btn btn-success' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'">Image 1</button></td>
																</c:if>
																<c:if test="${email.filename2 != null}">
  																	<td><button type='button' class='btn btn-success' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'">Image 2</button></td>
																</c:if>
																<c:if test="${email.filename3 != null}">
  																	<td><button type='button' class='btn btn-success' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'">Image 3</button></td>
																</c:if>
																<c:if test="${email.filename4 != null}">
  																	<td><button type='button' class='btn btn-success' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'">Image 4</button></td>
																</c:if>
																<c:if test="${email.filename5 != null}">
  																	<td><button type='button' class='btn btn-success' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'">Image 5</button></td>
																</c:if>
</tr>
</c:when>

</c:choose>
			
			
																
																   
 </c:forEach>
 
 
 					

											</tbody>
										</table>
										
 </form:form>
				 	
 
  </div>
  
 	
		
	
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
					

					 <%@ include file="sections/footer.jsp"%>
 
				</div>
			</div>
		</div>
	</div>

	<%@ include file="sections/global_scripts.jsp"%>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
      <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
      
      
      <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
      <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
	
      <script>
           $('#myTable').DataTable();
      </script>
		

</body>
</html>