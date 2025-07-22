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
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>" />

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

div#map_container2 {
	width: 100%;
	height: 500px;
	border-radius: 5px;
}


div#map {
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

.google-visualization-table-td {
text-align: center !important;
}

.container{
	max-width: 100%;
	overflow-x: hidden;
	
    
}


/* Style the dropdown content (hidden by default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

/* Style the links inside the dropdown */
.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

/* Add a dark background on topnav links and the dropdown button on hover */
.topnav a:hover, .dropdown:hover .dropbtn {
  background-color: #555;
  color: white;
}

/* Add a grey background to dropdown links on hover */
.dropdown-content a:hover {
  background-color: #ddd;
  color: black;
}

/* Show the dropdown menu when the user moves the mouse over the dropdown button */
.dropdown:hover .dropdown-content {
  display: block;
}



#theme-wrapper {
  box-shadow: 0 0 53px 0 rgba(0, 0, 0, 0.55);
  width: 100%;
}

#page-wrapper {
  background-color: #2c3e50;
}

.container {
  margin: 0;
  width: 100%;
}

/* .container2 {
  margin: 0;
  max-width: 1920px;
  width: 100%;
}
 */


.map-container-3{
overflow:hidden;
padding-bottom:56.25%;
position:relative;
height:0;
}
.map-container-3 iframe{
left:0;
top:0;
height:100%;
width:100%;
position:absolute;
}

.infographic-box .headline {
  display: block;
  font-weight: 300;
  text-align: right;
  font-family: "Open Sans", sans-serif;
  font-size: 16px;
	
}



   
/* html, body {
    max-width: 100%;
    }
 */ 


</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  
<script type="text/javascript" src="https://www.google.com/jsapi"></script>


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
									<li class="active"><span>SPS Dashboard</span></li>
								</ol>

								
							</div>

							<%@ include file="sections/userDetails.jsp"%>

						</div>

					</div>

					<link rel="stylesheet"
						href="https://use.fontawesome.com/releases/v5.0.10/css/all.css"
						integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg"
						crossorigin="anonymous">

										<c:if
													test="${sessionScope.loggedUserRole =='AGM' || sessionScope.loggedUserRole =='DGM' || sessionScope.loggedUserRole =='CE'}">
													
										<div class="row">
                            <div class="col-lg-12">                                                                                                   
                                        <div class="row">                                           
                                            <div class="col-sm-4">
                                                          <div class="main-box infographic-box">
                                                            <a href="estApprovalNew"><i class="fa fa-tasks  green-bg"></i></a>
                                                            <span class="headline">Estimate Approval</span>
                                                            <span class="headline">
                                                                <a href="estApprovalNew"><span class="num" style="color:red; font-weight:bold;">${countEstApprove}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-sm-4">
                                                          <div class="main-box infographic-box">
                                                           <a href="reviseApprovalNewAE"> <i class="fa fa-tasks  yellow-bg"></i></a>
                                                            <span class="headline">Revise Job Approval</span>
                                                            <span class="headline">
                                                                <a href="reviseApprovalNewAE"><span class="num" style="color:red; font-weight:bold;">${countRevEstApprove}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                             <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <a href="estApprovalCommercial"><i class="fa fa-tasks  green-bg"></i></a>
                                                            <span class="headline">Commercial/Planning Estimate Approval</span>
                                                            <span class="headline">
                                                                <a href="estApprovalCommercial"><span class="num" style="color:red; font-weight:bold;">${countStdEstApprove}</span></a>
                                                            </span>
                                                    </div>
                                            </div> 
                                        
                                        
                                            
                                            <div class="col-sm-4">
                                                    <div class="main-box infographic-box">
                                                           <a href="estApprovalNewESDA"> <i class="fa fa-pencil-square-o  yellow-bg"></i></a>
                                                            <span class="headline">Estimate - Reallocate the Responsible EE</span>
                                                           <!--  <span class="headline">
                                                                <a href="estApprovalNewESDA">Re-Allocate</a>
                                                                                                                       </span>
                                                     -->
                                                            
                                                    </div>
                                            </div>
                                            
                                             <div class="col-sm-4">
                                                    <div class="main-box infographic-box">
                                                           <a href="estApprovalNewStatus"> <i class="fa fa-pencil-square-o  yellow-bg"></i></a>
                                                            <span class="headline">Estimate - Status</span>
                                                           <!--  <a href="estApprovalNewStatus"><i class="glyphicon glyphicon-circle-arrow-right" style="color:blue"></i></a>
                                                                
                                                            --> 
                                                    </div>
                                            </div>
                                           
                                            
                                                                                   </div>
                                        
                                </div>

                            </div>
                            
                                                        
                            
                            </c:if>


										<c:if
													test="${sessionScope.loggedUserRole =='EE'}">
													
										<div class="row">
                            <div class="col-lg-12">                                                                                                   
                                        <div class="row">                                           
                                            
                                            
                                             <div class="col-sm-4">
                                                         <div class="main-box infographic-box">
                                                            <a href="estApprovalNew"><i class="fa fa-pencil-square-o  yellow-bg"></i></a>
                                                            <span class="headline">Estimate Approval</span>
                                                            <span class="headline">
                                                                <a href="estApprovalNew"><span class="num" style="color:red; font-weight:bold;">${countEstApprove}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-sm-4">
                                                          <div class="main-box infographic-box">
                                                            <a href="reviseApprovalNewAE"> <i class="fa fa-pencil-square-o  yellow-bg"></i></a>
                                                           <span class="headline">Revise Job Approval</span>
                                                             <span class="headline">
                                                                <a href="reviseApprovalNewAE"><span class="num" style="color:red; font-weight:bold;">${countRevEstApprove}</span></a>
                                                            </span> 
                                                    </div>
                                            </div>
                                            
                                            
                                         <div class="col-sm-4">
                                                    <div class="main-box infographic-box">
                                                            <a href="estApprovalNewESDA"> <i class="fa fa-pencil-square-o  yellow-bg"></i></a>
                                                           <span class="headline">Estimate - Reallocate the Responsible EE</span>
                                                            <!-- <span class="headline">
                                                                <a href="estApprovalNewESDA">Re-Allocate</a>
                                                                                                                       </span>
                                                     -->
                                                            
                                                    </div>
                                            </div>
                                            
                                            <div class="col-sm-4">
                                                    <div class="main-box infographic-box">
                                                            <a href="estApprovalNewStatus"> <i class="fa fa-pencil-square-o  yellow-bg"></i></a>
                                                           <span class="headline">Estimate - Status</span>
                                                            <!-- <span class="headline">
                                                                <a href="estApprovalNewStatus">Status</a>
                                                                                                                       </span>
                                                     -->
                                                            
                                                    </div>
                                            </div>
                                            
                                            <div class="col-sm-4">
                                                    <div class="main-box infographic-box">
                                                            <a href="reviseApprovalNewAEStatus"> <i class="fa fa-pencil-square-o  yellow-bg"></i></a>
                                                           <span class="headline">Job - Status</span>
                                                               <!--  <a href="reviseApprovalNewAEStatus">Status</a>
                                                                                                                       </span>
                                                     -->
                                                            
                                                    </div>
                                            </div>
                                            
                                            <!-- <div class="col-sm-4">
                                                    <div class="main-box infographic-box">
                                                            <a href="estApprovalNewESDA"> <i class="fa fa-pencil-square-o  yellow-bg"></i></a>
                                                           <span class="headline">Estimate - Reallocate the Responsible ES</span>
                                                            <span class="headline">
                                                                <a href="estApprovalNewESDA">Re-Allocate</a>
                                                                                                                       </span>
                                                    
                                                            
                                                    </div>
                                            </div>
                                          -->
                                                                    </div>
                                        
                                </div>

                            </div>
                            
                                                        
                            
                            </c:if>
                            
                            
                            <c:if
													test="${sessionScope.loggedUserRole =='ES'}">
													
										<div class="row">
                            <div class="col-lg-12">                                                                                                   
                                        <div class="row">                                           
                                            <div class="col-sm-4">
                                                    <div class="main-box infographic-box">
                                                           <a href="estApprovalNewES"> <i class="fa fa-pencil-square-o  yellow-bg"></i></a>
                                                            <span class="headline">Estimate - Send for Approval</span>
                                                             <!-- <a href="estApprovalNewES"><i class="glyphicon glyphicon-circle-arrow-right" style="color:blue"></i></a>
                                                              -->  
                                                            
                                                    </div>
                                            </div>
                                            
                                            <div class="col-sm-4">
                                                    <div class="main-box infographic-box">
                                                            <a href="reviseApprovalNewAE"><i class="fa fa-pencil-square-o  yellow-bg"></i></a>
                                                            <span class="headline">Revise Job - Send for Approval</span>
                                                                <!-- <a href="reviseApprovalNewAE"><i class="glyphicon glyphicon-circle-arrow-right" style="color:blue"></i></a>
                                                                 -->                                                       
                                                            
                                                    </div>
                                            </div>
                                            
                                            
                                             <div class="col-sm-4">
                                                    <div class="main-box infographic-box">
                                                            <a href="estApprovalNewESDA"> <i class="fa fa-pencil-square-o  yellow-bg"></i></a>
                                                            <span class="headline">Estimate - Reallocate the Responsible EE</span>
                                                                <!-- <a href="estApprovalNewESDA"><i class="glyphicon glyphicon-circle-arrow-right" style="color:blue"></i></a>
                                                                  -->                                                      
                                                    
                                                            
                                                    </div>
                                            </div>
                                            
                                             <div class="col-sm-4">
                                                    <div class="main-box infographic-box">
                                                           <a href="estApprovalNewStatus"> <i class="fa fa-pencil-square-o  yellow-bg"></i></a>
                                                            <span class="headline">Estimate - Status</span>
                                                            <!-- <a href="estApprovalNewStatus"><i class="glyphicon glyphicon-circle-arrow-right" style="color:blue"></i></a>
                                                             -->    
                                                            
                                                    </div>
                                            </div>
                                           
                                           </div> 
                                           <br>
                                           <br>
                                           <div class="row">                                           
                                            </div>
                                </div>

                            </div>
                            
                                                        
                            
                            </c:if>
                            
                            
                            
                            
                            
                            
                            
                            
    

										</div>
	</div>
	</div>
	</div>
	<%@ include file="sections/footer.jsp"%>
	<%@ include file="sections/global_scripts.jsp"%>
	
	
		

	
	
	
	
</body>
</html>