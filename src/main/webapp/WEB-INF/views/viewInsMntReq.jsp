<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<%@ include file="sections/head.jsp"%>
<%@ include file="sections/dashboardCSS.jsp"%>

<!-- meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"-->
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<!-- bootstrap -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">

<!-- RTL support - for demo only -->
<script src="<c:url value="/resources/js/demo-rtl.js"/>">
	
</script>
<!-- 
	If you need RTL support just include here RTL CSS file <link rel="stylesheet" type="text/css" href="css/libs/bootstrap-rtl.min.css" />
	And add "rtl" class to <body> element - e.g. <body class="rtl"> 
	-->

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

.modal-title {
	margin: 0;
	line-height: 1.428571429;
	text-align: center;
}


.dropbtn1 {
	background-color: #eee;
	color: black;
	padding: 16px;
	font-size: 16px;
	border: none;
	width: 100%;
	height: 40px;
}

.dropbtn {
	background-color: #eee;
	color: black;
	padding: 16px;
	font-size: 16px;
	border: none;
	width: 100%;
	height: 50px;
	
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
	width: 100%;
	text-align: left;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #66CDAA;
}



/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 280px;
  top: 175px;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 10px;
  border: 1px solid #888;
  width: 25%;
  
}
.p1{
    font-size: 14px;
}

/* The Close Button */
.close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}

/* .google-visualization-table-td {
text-align: center !important;
}

.google-visualization-table-th {
text-align: center !important;
}
 */
 
 /* Table view header */
.google-visualization-table-table .gradient,
.google-visualization-table-div-page .gradient {
	background: #F4F4F4 !important;
	color:#444444;
}

/* selected/hovered row in a TABLE view */
.google-visualization-table-tr-sel td,
.google-visualization-table-tr-over td {
	background-color: #ffd6cc!important;
}

/*** Configuration of FILTERS ***/

/** Labels of filters **/
.google-visualization-controls-label {
	color:#333;
}

/** StringFilter **/
.google-visualization-controls-stringfilter INPUT {
	border:1px solid #d9d9d9!important;
	color:#222;
}
.google-visualization-controls-stringfilter INPUT:hover {
	border:1px solid #b9b9b9;
	border-top:1px solid #a0a0a0;
}
.google-visualization-controls-stringfilter INPUT:focus {
	border:1px solid #4d90fe;
}

/** CategoryFilter **/
.google-visualization-controls-categoryfilter .charts-menu-button,
.google-visualization-controls-categoryfilter .charts-menu-button.charts-menu-button-hover,
.google-visualization-controls-categoryfilter .charts-menu-button.charts-menu-button-active {
	color:#444;
	border:1px solid rgba(0,0,0,0.1);
	background:none;
	background:#f5f5f5;
}
.google-visualization-controls-categoryfilter LI{
	background-color:#D2D8E6!important;
}

/* CategoryFilter & csvFilter hovered item in the dropdown */
.charts-menuitem-highlight {
	background-color:#FFFFCC!important;
	border-color:#FFFFCC!important;
}

/** NumberRangeFilter **/
/* slider thumbs */
.google-visualization-controls-slider-horizontal .google-visualization-controls-slider-thumb,
.google-visualization-controls-slider-vertical .google-visualization-controls-slider-thumb {
	background-color: #6D6E6E;
	border: 1px solid #444444;
}
/* label showing the current thumb value */
.google-visualization-controls-rangefilter-thumblabel {
	color:#444444!important;
}
 
.google-visualization-controls-label {
	color:#333;
}
#sidebar{
	width:80%!important;
	margin-left:0px!important;
}

html, body {
    max-width: 100%;
    overflow-x: hidden;
}


div.main{
  margin: 20px 10px -100px 10px;
}

#drop{
  padding: 2px 20px;
  cursor: pointer;
  font-size: 12px;
  color: #595656;
}

/*.input_field{
  margin-left: 460px;
}*/

.button {
  border: none;
  color: white;
  padding: 14px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}

.button2{
  width: 110px;
  height: 40px;
  padding: 5px 8px;
  font-size: 14px;
  font-family: sans-serif;
  font-weight: 600;
  background-color: #ffb6c1; 
  color: black; 
  cursor: pointer;
  border: 1px solid rgba255,255,255,0.3;
  box-shadow: 1px 1px 5px rgba(0,0,0,0.3);
  border-radius: 12px;
}

.button2:hover {
  background-color: #fc94af;
  color: white;
  border: 2px solid none;
  font-size: 15px;
}

h2{
	text-align: center;
	padding: 5px;
  margin-bottom: 0px;
  text-align: center;
}

td{
  font-size: 13.5px;
}

th{
  font-size: 14px;
}

h4{
  padding-left: 79px;
  font-size: 18px;
  margin-top: 50px;
}

#mainnw2{
	margin: 150px;
}

div.register{
	background-color: rgba(0,0,0,0.5);
	width: 100%;
	font-size: 16px;
	border-radius: 10px;
}

.heading{
  background-color: #9f0e31;
  color: white;
}

form#register{
	margin: 80px;
}

label{
	font-size: 13px;
}


.wrapper .form .input_field{
	margin-bottom: 10px;
	display: flex;
	align-items: center;
}

.wrapper .form .input_field label{
	width: 170px;
}


input#name{
	width: 250px;
	outline: 0;
	padding: 3px;
}

input#name2{
  width: 50px;

  border-radius: 3px;
  outline: 0;
  padding: 3px;
  background-color: #fff;
}

#btn{
	width: 75px;
	padding: 1px 8px;
	font-size: 13px;
	background-color: #9c9797;
	color: black;
	cursor: pointer;
}

input#btn:hover{
	background-color: black;
	font-size: 13px;
  color: white;
}

.up{
	position: relative;
	bottom: 62px;
}

.upnew{
	position: relative;
	bottom: 58px;
}

.button1{
  height: 10px;
  position: relative;
  margin-left: 20px;
}

.center {
  margin: 0;
  position: absolute;
  top: -1100%;
  left: 20%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-20%, -130%);
}

 .rowt1 {
        transition: all .2s ease-in;
        cursor: pointer;
        font-size: 10px;
    }

  .rowt {
        transition: all .2s ease-in;
        cursor: pointer;
        font-size: 10px;
    }


	#headert {
        background-color: #16a085;
        color: #fff;
    }
    
    .rowt:hover {
        background-color: #f5f5f5;
        transform: scale(1.02);
    }

     .rowt1:hover {
        background-color: #f5f5f5;
        transform: scale(1.02);
    }
    
    @media only screen and (max-width: 768px) {
        table {
            width: 90%;
        }
    }
 
 





</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
google.charts.load('current', {'packages':['corechart', 'controls']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawDashboard);



var estimateNoGloble;
var costCenterNoGloble;

function requestType(key){
	  switch (key) {
	case "MNTREQ":
		return "Maintenance Request ";			 
	case "INTREQ":
		return "Interruption Request";			 
	case "INSREQ":
		return "Inspection Request";	
	default:
		return "Other";
		 
	}

}

function searchStatus(key){
	  switch (key) {
		case "20":
			return "Removed";			 
		case "6":
			return "Pending";			 
		case "95":
			return "Forwarded";	
		case "96":
			return "Recommend";	
		case "97":
			return "Not Recommend";
		case "99":
			return "Forwarded to ES";
		case "98":
			return "Estimate Generated";
		default:
			return "Other";
			 
		

    }
}




function drawDashboard() {
	 // alert("hii");
   	  $.ajax({
			type : 'GET',
			url : "/MMS/ActionOnInIntReq?mode=INT",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				var datavaluepie = new google.visualization.DataTable();
				datavaluepie.addColumn('string', 'Interruption No');
				datavaluepie.addColumn('string', 'Area');
				datavaluepie.addColumn('string', 'Section to be Interrupted');
				datavaluepie.addColumn('string', 'Time Duration');
				datavaluepie.addColumn('string', 'Requested EE/ES');
				datavaluepie.addColumn('string', 'Field work');
				//var jsonData = JSON.parse(result);
				 for (var i = 0; i < result.length; i++) {
						var data = result[i];
						//var type = requestType(data[1]);
						datavaluepie.addRows([[data.approvalId,data.referenceNo,data.fromto,data.timeduration,data.reason,data.req2]]);
				}
				 
				 
			     // Create a dashboard.
		        var dashboard = new google.visualization.Dashboard(
		            document.getElementById('dashboard_div'));

		        // Create a range slider, passing some options
		        var donutRangeSlider2 = new google.visualization.ControlWrapper({
		          'controlType': 'CategoryFilter',
		          'containerId': 'filter_div2',
		          'options': {
		        	'filterColumnLabel': 'Interruption No'
		          }
		        });
		        
		        
		        

		        
		        var table = new google.visualization.ChartWrapper({
			          'chartType': 'Table',
			          'containerId': 'psaprtable_div',
			          'options': {
			            'width': 1300,
			            'height': 300,
			            'pieSliceText': 'value',
			            'legend': 'right'
			          }
			        });
		        
		        
		        dashboard.bind(donutRangeSlider2, table);
		        
		        dashboard.draw(datavaluepie);
		       // google.visualization.events.addListener(chart, 'ready', selectHandler);

		        google.visualization.events.addListener(table, 'select', selectHandler);
 		        function selectHandler() {
		          //alert("hiii");
		          var selectedItem = table.getChart().getSelection();
		          
		          if (selectedItem) {
		        	 // alert("hiii2");
		             var row = selectedItem[0].row;
   		         	 var type = table.getDataTable().getValue(row, 0);
   		         	document.getElementById("txtEstNo").value = type;
   		           // table.getChart().setSelection([{row: row}]);
   		    	     		   		        

 		   		}
 		   		 		             
		         }
		        }
		        
		        		});

	  
	  

	  
	      
     }
     
function viewLetter(){
	
	var intNo = document.getElementById("txtEstNo").value;
		if(intNo !="Request No to be Forwarded"){
			 var url="downloadInterruptionReq?id="+intNo;
    	    var width = 1100;
    	    var height = 700;
    	    var left = parseInt((screen.availWidth/2) - (width/2));
    	    var top = parseInt((screen.availHeight/2) - (height/2));
    	    var windowFeatures = "width=" + width + ",height=" + height + 
    	    ",status,resizable,left=" + left + ",top=" + top +
    	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
    	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
    	   
			
			
		}else{
			alert("Please select the Interruption Request Number");
		}
		
	}
	
function forwardRequest(){
	
	var pname = document.getElementById("forwaded").value;
	var approvedNo = document.getElementById("txtApproved").value;
	
	//alert(pname);
	var strUser = "60041ES1";
		
		var id = document.getElementById("txtEstNo").value;
		//alert(id);
		if(!approvedNo){
			
		if(id !="Request No to be Forwarded"){
			
		 $.ajax({
			type : 'GET',
			url : "/MMS/sendRequestToArea/" +id+ "/"+ pname + "/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				document.getElementById("txtApproved").value = id;
				
				alert("Succesfully forwarded...Email-SMS is succesfully sent to relevent Area Engineer ");
				drawDashboard();
				
			}
		});
	 	}else{
			alert("Please select the Interruption Request Number");
		}
		}else{
			alert("You have already forwarded this Interruption Request");
		}
}


function removeRequest(id){

	var pname = document.getElementById("forwaded").value;
	var approvedNo = document.getElementById("txtApproved").value;
	var strUser = "60041ES1";
		
		var id = document.getElementById("txtEstNo").value;
		if(!approvedNo){
		if(id !="Request No to be Forwarded"){
			 $.ajax({
			type : 'GET',
			url : "/MMS/removeRequest/" +id +"/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				document.getElementById("txtApproved").value = id;
				alert("Succesfully removed...");
				drawDashboard();
				
			}
		}); 
		}else{
			alert("Please select the Interruption Request Number");
		}
		
		}else{
			alert("You have already removed this Interruption Request");
		}
		
}


     
     
     

</script>








<!-- <script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&libraries=geometry">
	
</script>
 -->
<!-- <script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap&libraries=geometry"></script>
 -->
<script type="text/javascript">




	
	
	
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
									<li class="active"><span>Dashboard</span></li>
								</ol>

								
							</div>

							<%@ include file="sections/userDetails.jsp"%>

						</div>

					</div>

					<link rel="stylesheet"
						href="https://use.fontawesome.com/releases/v5.0.10/css/all.css"
						integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg"
						crossorigin="anonymous">



					<div class="container">
<div class="main">
<div class="upnew">
            	<div class="wrapper">
			<div class = "form">
													<form:form method="post" action=""	modelAttribute="model">
													<c:set var="myVar" value="${model.mode}" />


				<br>
				<br>
				<tr>
												<td> <input type="text" id="remarks" placeholder="Enter remarks here.." title="Type remarks">
  			</td>
  			</tr>

<%-- <center>
<button type="submit" class="button button2" ><b>View<b></button> 
</center>
 --%>    <div class="table-responsive">
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
																<td>${email.approvalId}<%-- <input type="text" id="" value="${email.approvalId}"  disabled> --%></td>
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






				</div>
			</div>
		</div>
	</div>
	<%@ include file="sections/footer.jsp"%>
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