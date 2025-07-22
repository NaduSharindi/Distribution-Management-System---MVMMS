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

 
 



/* Style the tab */
.tab {
  float: left;
  border: 1px solid maroon;
  background-color: #f1f1f1;
  width: 25%;
  height: 2000px;
}

/* Style the buttons inside the tab */
.tab button {
  display: block;
  background-color: inherit;
  color: black;
  padding: 22px 16px;
  width: 100%;
  border: none;
  outline: none;
  text-align: left;
  cursor: pointer;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current "tab button" class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  float: left;
  padding: 0px 12px;
  border: 1px solid maroon;
  width: 70%;
  border-left: none;
  height: 2000px;
    
    }
.user-details .input-box input{
  height: 45px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
.user-details .input-box input:focus,
.user-details .input-box input:valid{
  border-color: maroon;
  border-bottom-width: medium;
} 
 .user-details{
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  margin: 20px 0 12px 0;
}
    
    
    
    <!-- ------------ -->
    .container{
  width: 1000px;
  height: 1200px;
  padding: 25px 30px;
  border-radius: 5px;
  box-shadow: 0 5px 10px rgba(0,0,0,0.15);
}
    
.container .title{
  font-size: 25px;
  font-weight: 500;
  position: relative;
}
.container .title::before{
  content: "";
  position: absolute;
  left: 0;
  bottom: 0;
  height: 3px;
  width: 50px;
  border-radius: 5px;
  background: linear-gradient(135deg, #dfe302, #871b00);
}  
content form .user-details{
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  margin: 20px 0 12px 0;
}
form .user-details .input-box{
  margin-bottom: 15px;
  width: calc(100% / 2 - 20px);
}
    
form .input-box span.details{
  display: block;
  font-weight: 500;
  margin-bottom: 5px;
}
form .category{
   display: flex;
   width: 80%;
   margin: 14px 0 ;
   justify-content: space-between;
 }
    

.user-details .input-box select{
  height: 45px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
.user-details .input-box select:focus,
.user-details .input-box select:valid{
    
  border-bottom-width: medium;
}
    form .button input{
   height: 30px;
   width: 100px;
   border-radius: 5px;
   border: none;
   color: #fff;
   font-size: 18px;
   font-weight: 500;
   letter-spacing: 1px;
   cursor: pointer;
   transition: all 0.3s ease;
   background: linear-gradient(135deg, #871b00, #dfe302);
 }
 form .button input:hover{
  /* transform: scale(0.99); */
  background: linear-gradient(135deg, #dfe302, #871b00);
  }
    h2{
        margin-left: 60px;
    }
    img{
       flex-wrap: wrap; 
       margin-left: 130px;
        margin-top: 5px;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  
<script type="text/javascript" src="https://www.google.com/jsapi"></script>








<!-- <script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&libraries=geometry">
	
</script>
 -->
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap&libraries=geometry"></script>



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
									<li><a href="#">Data Related To Meter Constant</a></li>
									<li class="active"><span>${submitType} Status</span></li>
								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>

						</div>

					</div>
					<div class="tab">
   <!--   <img  src="resources/img/CEBImages/CEB_Logo.png" width="80" height="80"> -->
    <h2></h2>
   
   <button class="tablinks" onclick="openCity(event, 'Paris')" id="defaultOpen">New meter details</button> 
  <button class="tablinks" onclick="openCity(event, 'London')" >Substation Data </button>
  <button class="tablinks" onclick="openCity(event, 'Newyork')" >Meter & CT Asset Data</button>
  <!--  <button class="tablinks" onclick="openCity(event, 'Tokyo')">New CT details</button>-->
</div> 

<div id="London" class="tabcontent">
    
<div class="container">
  <div class="title">Subsstation Data</div>
    <div class="content">
      <form action="#">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Transformer Size</span>
              
            <select class ="drop-down">
                <option value="a"> None </option>
                    <option value="a"> 75kVA </option>
                    <option value="a"> 95 kVA </option>
                    <option value="a"> 100kVA/ </option>
                    <option value="a"> 160 kVA </option>
                    <option value="a"> 250kVA </option>
                    <option value="a"> 400kVA </option>
                    <option value="a"> 800 kVA </option>
                    <option value="a"> 1000 kVA </option>
                    <option value="a"> Other... </option>
            </select>
          </div>
          <div class="input-box">
          <span class="details">Transformer Size</span>
            <input type="text" placeholder="If other" required>
          </div>
          <div class="input-box">
            <span class="details">SIN Number</span>
            <input type="number" placeholder="____________________" required>
          </div>
          
          <div class="input-box">
            <span class="details">Location</span>
            <input type="Text" placeholder="____________________" required>
          </div>
            
        </div>
          <div class="button">
          <input type="submit" value="Register">
        </div>
        </form>
      </div>
    </div> 
    
</div>
 
    
    
    
    
    

<div id="Paris" class="tabcontent">
    
     <div class="container">
    <div class="title">Customer Location details</div>
    <div class="content">
      <form action="#">
          
          <div class="user-details" >  
          <!-- 1 -->
          <div class="input-box">
            <span class="details">Area</span>
            <select class ="drop-down">
                <option value="AAA"></option>
                <option value="BBB"></option>
                 <option value="CCC"></option>
                    <option value="DDD"></option>
            </select>  
          </div>
          <!-- 2 -->
          <div class="input-box">
            <span class="details">CSC</span>
            <select class ="drop-down">
                <option value="AAA"></option>
                <option value="BBB"></option>
                 <option value="CCC"></option>
                    <option value="DDD"></option>
            </select>  
          </div>  <!-- 3 -->
          <div class="input-box">
            <span class="details">Account Number</span>
            <input type="number" placeholder="____________________" required>
          </div><!-- 4 -->
          <div class="input-box">
            <span class="details">Customer Name</span>
            <input type="text" placeholder="____________________"  required>
          </div><!-- 5 -->
          <div class="input-box">
            <span class="details">Contact Number</span>
            <input type="text" placeholder="____________________"  required>
          </div>
          <!-- 6 -->
          <div class="input-box">
            <span class="details">Customer Address</span>
            <input type="text" placeholder="____________________"  required>
          </div>
          <!-- 7 -->
          <div class="input-box">
            <span class="details">Customer Location</span>
            <input type="text" placeholder="____________________"  required>
          </div>
          <!-- 8 -->
          <div class="input-box">
            <span class="details">Connection Type</span>
            <select class ="drop-down">
                <option value="a"> </option>
                <option value="a"> MHP </option>
                <option value="a"> HS </option>
                <option value="a"> LT Bulk </option>
                <option value="a"> 3 ph 30A </option>
                <option value="a"> 3 ph 60 A </option>
                <option value="a"> 1 ph </option>
            </select>  
          </div>
          <!-- 9 -->
          <div class="input-box">
            <span class="details">Contract Demand</span>
            <select class ="drop-down">
                <option value="a"> </option>
                    <option value="a"> None </option>
                    <option value="a"> 75kVA </option>
                    <option value="a"> 95 kVA </option>
                    <option value="a"> 100kVA/ </option>
                    <option value="a"> 160 kVA </option>
                    <option value="a"> 250kVA </option>
                    <option value="a"> 400kVA </option>
                    <option value="a"> 800 kVA </option>
                    <option value="a"> 1000 kVA </option>
                    <option value="a"> Other... </option>
            </select>  
          </div>
          <!-- 10 -->
          <div class="input-box">
            <span class="details">Contract Demand (If Others)</span>
            <input type="text" placeholder="____________________"  required>
          </div>
          <!-- 11 -->
          <div class="input-box">
            <span class="details">Tarif</span>
            <select class ="drop-down">
              <option value="a"> </option>
                    <option value="a"> I1 </option>
                    <option value="a"> I2 </option>
                    <option value="a"> I3 </option>
                    <option value="a"> H1 </option>
                    <option value="a"> H2 </option>
                    <option value="a"> H3 </option>
                    <option value="a"> GP1 </option>
                    <option value="a"> GP2 </option>
                    <option value="a"> GP3 </option>
                    <option value="a"> D1 </option>
                    <option value="a"> D2 </option>
                    <option value="a"> D3 </option>
                    <option value="a"> R1 </option>
                    <option value="a"> R2 </option>
                    <option value="a"> R3 </option>
                    <option value="a"> GV1 </option>
                    <option value="a"> GV2 </option>
                    <option value="a"> GV3 </option>
            </select>  
          </div>
              
        </div>
          <div class="button">
          <input type="submit" value="Register">
        </div>
        </form>
        
         </div>
    </div>
    
    
</div>
    
<div id="Newyork" class="tabcontent">
    
<div class="container">
  <div class="title">Meter & CT Asset Data</div>
    <div class="content">
      <form action="#">
          <div class="user-details" >   
          <div class="input-box">
            <span class="details">Make</span>
            <input type="text" placeholder="____________________" required>
          </div>
          <div class="input-box">
            <span class="details">CEB Serial No</span>
            <input type="text" placeholder="____________________"  required>
          </div>
          <div class="input-box">
            <span class="details">Manufacture serial No</span>
            <input type="text" placeholder="____________________"  required>
          </div>
          <div class="input-box">
            <span class="details">Meter CT Ratio</span>
            <select class ="drop-down">
                <option value="AAA">200/5</option>
                <option value="BBB"> 400/5</option>
                 <option value="CCC">800/5</option>
                    <option value="DDD">1000/5</option>
            </select>  
          </div>
          <div class="input-box">
            <span class="details">Meter VT Ratio</span>
            <select class ="drop-down">
                <option value="AAA">1/1</option>
                    <option value="DDD">5 Other - text enter</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Meter Constant Active</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Meter Constant Reactive</span>
            <input type="number" placeholder="Enter number" required>
          </div>
           <div class="input-box">
            <span class="details">Scaling Factor</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Multification Factor</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Accuracy Class - Active</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Accuracy Class - Reactive</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Year of Manufacture</span>
            <input type="year" placeholder="Enter manufacture year" required>
          </div>
          <div class="title">New CT details</div>
            <div class="user-details">
          <div class="input-box">
            <span class="details">R</span>
            <input type="text" placeholder="____________________" required>
          </div>
          
          <div class="input-box">
            <span class="details">Y</span>
            <input type="text" placeholder="____________________" required>
          </div>
          <div class="input-box">
            <span class="details">B</span>
            <input type="text" placeholder="____________________" required>
          </div><script>
function myFunction() {
  var checkBox = document.getElementById("myCheck");
  var text = document.getElementById("text");
  if (checkBox.checked == true){
    text.style.display = "block";
  } else {
     text.style.display = "none";
  }
}
</script>

<label for="myCheck">Do you have two meters? &nbsp Yes</label>
<input type="checkbox" id="myCheck" onclick="myFunction()"> 
<div class = "form" id="text" style="display:none">
                 	<form id = "register1" method="post">
<br><br>
                 		<div class="user-details" >   
          <div class="input-box">
            <span class="details">Make</span>
            <input type="text" placeholder="____________________" required>
          </div>
          <div class="input-box">
            <span class="details">CEB Serial No</span>
            <input type="text" placeholder="____________________"  required>
          </div>
          <div class="input-box">
            <span class="details">Manufacture serial No</span>
            <input type="text" placeholder="____________________"  required>
          </div>
          <div class="input-box">
            <span class="details">Meter CT Ratio</span>
            <select class ="drop-down">
                <option value="AAA">200/5</option>
                <option value="BBB"> 400/5</option>
                 <option value="CCC">800/5</option>
                    <option value="DDD">1000/5</option>
            </select>  
          </div>
          <div class="input-box">
            <span class="details">Meter VT Ratio</span>
            <select class ="drop-down">
                <option value="AAA">1/1</option>
                    <option value="DDD">5 Other - text enter</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Meter Constant Active</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Meter Constant Reactive</span>
            <input type="number" placeholder="Enter number" required>
          </div>
           <div class="input-box">
            <span class="details">Scaling Factor</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Multification Factor</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Accuracy Class - Active</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Accuracy Class - Reactive</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Year of Manufacture</span>
            <input type="year" placeholder="Enter manufacture year" required>
          </div>
          <div class="title">New CT details</div>
            <div class="user-details">
          <div class="input-box">
            <span class="details">R</span>
            <input type="text" placeholder="____________________" required>
          </div>
          
          <div class="input-box">
            <span class="details">Y</span>
            <input type="text" placeholder="____________________" required>
          </div>
          <div class="input-box">
            <span class="details">B</span>
            <input type="text" placeholder="____________________" required>
          </div>
          </div>
          </div>
          </form>
</div>
          
        </div>
              
        
          <div class="button">
          <input type="submit" value="Register">
        </div>
        </form>
      </div>
    </div> 
    
</div>    
    
    
    
    

<div id="Tokyo" class="tabcontent">
    
    <div class="container">
    <div class="title">New CT details</div>
    <div class="content">
      <form action="#">
    <div class="user-details">
          <div class="input-box">
            <span class="details">R</span>
            <input type="text" placeholder="____________________" required>
          </div>
          
          <div class="input-box">
            <span class="details">Y</span>
            <input type="text" placeholder="____________________" required>
          </div>
          <div class="input-box">
            <span class="details">B</span>
            <input type="text" placeholder="____________________" required>
          </div>
        </div>
        <script>
function myFunction() {
  var checkBox = document.getElementById("myCheck");
  var text = document.getElementById("text");
  if (checkBox.checked == true){
    text.style.display = "block";
  } else {
     text.style.display = "none";
  }
}
</script>


          <div class="button">
          <input type="submit" value="Register">
        </div>
        </form>
        </div>
    </div>

					<link rel="stylesheet"
						href="https://use.fontawesome.com/releases/v5.0.10/css/all.css"
						integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg"
						crossorigin="anonymous">



					




				</div>
			</div>
		</div>
	</div>
	<%@ include file="sections/footer.jsp"%>
	<script>
function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>
	<%@ include file="sections/global_scripts.jsp"%>
	
	
		

	
	
	
</body>
</html>