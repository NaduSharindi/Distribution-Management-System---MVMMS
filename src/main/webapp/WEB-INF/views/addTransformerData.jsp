<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>



	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>MV-MMS</title>
	
	<!-- bootstrap -->
	<link rel="stylesheet" type="text/css" href="/MMS/resources/css/bootstrap/bootstrap.min.css"/>
	
	<!-- RTL support - for demo only -->
	<script src="/MMS/resources/js/demo-rtl.js">
	</script>
	<!-- 
	If you need RTL support just include here RTL CSS file <link rel="stylesheet" type="text/css" href="css/libs/bootstrap-rtl.min.css" />
	And add "rtl" class to <body> element - e.g. <body class="rtl"> 
	-->
	
	<!-- libraries -->
	<link rel="stylesheet" type="text/css" href="/MMS/resources/css/libs/font-awesome.css"/>
	<link rel="stylesheet" type="text/css" href="/MMS/resources/css/libs/nanoscroller.css"/>

	<!-- global styles -->
	<link rel="stylesheet" type="text/css" href="/MMS/resources/css/compiled/theme_styles.css"/>

	<!-- this page specific styles -->
    <link rel="stylesheet" type="text/css" href="/MMS/resources/css/libs/fullcalendar.css"/>
    <link rel="stylesheet" type="text/css" media="print" href="/MMS/resources/css/libs/fullcalendar.print.css"/>
    <link rel="stylesheet" type="text/css" media="screen" href="/MMS/resources/css/compiled/calendar.css"/>
	<link rel="stylesheet" type="text/css" href="/MMS/resources/css/libs/morris.css"/>
	<link rel="stylesheet" type="text/css" href="/MMS/resources/css/libs/daterangepicker.css"/>
	<link rel="stylesheet" type="text/css" href="/MMS/resources/css/libs/jquery-jvectormap-1.2.2.css"/>
	
	<!-- Favicon -->
	<link type="image/x-icon" href="favicon.png" rel="shortcut icon" />

	<!-- google font libraries -->
	<link href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700,300|Titillium+Web:200,300,400' rel='stylesheet' type='text/css'>
	
	<style type="text/css">
		.table-responsive {
		    overflow-x: auto;
		    min-height: 0.01%;
		    text-align: center;
		}
		
		.table tbody > tr > td:first-child {
		    font-size: 1.05em;
		    font-weight: 600;
		}
		
		.myCSS{
	 		text-align: right;
 		    font-style: italic;
		    font-family: Comic Sans MS;
		    font-weight: 800;
		    color: #114e9df5;
	 	}
	</style>
<style type="text/css">
.collapsible {
  background-color: #777;
  color: white;
  cursor: pointer;
  padding: 10px;
  margin-bottom:2px;
  width: 100%;
  border: none;
  text-align: left;
  outline: none;
  font-size: 15px;
}
.normal {
  background-color: #777;
  color: white;
  cursor: pointer;
  padding: 18px;
  width: 100%;
  border: none;
  text-align: left;
  outline: none;
  font-size: 15px;
}

.active, .collapsible:hover {
  background-color: #555;
}
.content {
  padding: 0 18px;
  display: none;
  overflow: hidden;
  background-color: #f1f1f1;
}
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	border: 1px solid #ddd;
}

https: //www.w3schools.com /
th, td {
	text-align: left;
	padding: 16px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

.drop-down-padding {
	padding-top: 10px;
	padding-right: 20px;
	padding-bottom: 10px;
	padding-left: 20px;
}

.theme-whbl a {
	color: #2919a3;
}

.infographic-box .value {
	font-size: 1.5em;
	font-weight: 600;
	margin-top: -5px;
	display: block;
	text-align: -webkit-right;
}

.infographic-box .headline {
	display: block;
	font-size: 0.5em font-weight: 400;
	text-align: right;
}

h1 {
	clear: both;
	color: #3498db;
	margin: 0 0 20px 0;
	padding-left: 14px;
	font-size: 2em;
	font-weight: 900;
}

.lightsteelblue-bg {
	background-color: #B0C4DE !important;
}

.black-bg {
	background-color: #000000 !important;
}

.wrimagecard {
	margin-top: 0rem;
	margin-bottom: 1.5rem;
	margin-left: 5.5rem;
	margin-left: 5.5rem;
	text-align: center;
	position: relative;
	background: #5F9EA0";
	box-shadow: 12px 15px 20px 0px rgba(46, 61, 73, 0.15);
	border-radius: 6px;
	padding: 2px 16px;
	transition: all 0.3s ease;
	width: 300px;
	margin-gap: 60px;
}

.wrimagecardNew {
	margin-top: 5;
	margin-bottom: 1.5rem;
	margin-left: 3.5rem;
	text-align: left;
	position: relative;
	background: #00800;
	box-shadow: 12px 15px 20px 0px rgba(46, 61, 73, 0.15);
	border-radius: 4px;
	transition: all 0.3s ease;
	width: 500px;
}

.wrimagecardNew1 {
	margin-top: 5;
	margin-bottom: 1.5rem;
	margin-left: 0rem;
	text-align: left;
	position: relative;
	background: #b2beb5;
	box-shadow: 12px 15px 20px 0px rgba(46, 61, 73, 0.15);
	border-radius: 4px;
	transition: all 0.3s ease;
	width: 100%;
	overflow-x: auto;
}

.wrimagecardNew2 {
	margin-top: 5;
	margin-bottom: 1.5rem;
	margin-left: 0rem;
	text-align: left;
	position: relative;
	background: #FFFFF;
	box-shadow: 12px 15px 20px 0px rgba(46, 61, 73, 0.15);
	border-radius: 4px;
	transition: all 0.3s ease;
	width: 100%;
	overflow-x: auto;
}



.wrimagecard .fa {
	position: relative;
	font-size: 70px;
}

.wrimagecard-topimage_header {
	padding: 20px;
	width: 100%;
}

.wrimagecard-topimage_header1 {
	padding: 0px;
	width: 100%;
}

/* .wrimagecard-topimage_headernew {
	padding: 20px;
	width: 100%;
}
 */

a.wrimagecard:hover, .wrimagecard-topimage:hover {
	box-shadow: 2px 4px 8px 0px rgba(46, 61, 73, 0.2);
}

.wrimagecard-topimage1 a {
	height: 20%;
	display: block;
}

.wrimagecard-topimage a {
	width: 100%;
	height: 30%;
	display: block;
}

.wrimagecard-topimage_title {
	margin-top: 0;
	margin-left: 2.5rem;
	text-align: left;
	padding: 20px 24px;
	height: 30px;
	width: 200%;
	padding-bottom: 0.75rem;
	position: relative;
}

.wrimagecard-topimage a {
	border-bottom: none;
	text-decoration: none;
	color: #525c65;
	transition: color 0.3s ease;
}

.details li {
	list-style: none;
}

li {
	margin-bottom: 10px;
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



</style>



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

.google-visualization-table-td {
text-align: center !important;
}

.container{
	max-width: 100%;
    
}

/* html, body {
    max-width: 100%;
    overflow-x: hidden;
}
 */


</style>

<script
src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap&libraries=geometry"></script>



<script type="text/javascript">


function handlePermission() {
	//alert('hiiii');
	  navigator.permissions.query({name:'geolocation'}).then(function(result) {
	    if (result.state == 'granted') {
	    	//alert('hiiii 1');
	    	
	      report(result.state);
	      geoBtn.style.display = 'none';
	    } else if (result.state == 'prompt') {
	    	//alert('hiiii 2');
	    	
	      report(result.state);
	      geoBtn.style.display = 'none';
	      navigator.geolocation.getCurrentPosition(revealPosition,positionDenied,geoSettings);
	    } else if (result.state == 'denied') {
	    	//alert('hiiii 3');
	    	
	      report(result.state);
	      geoBtn.style.display = 'inline';
	    }
	    result.onchange = function() {
	      report(result.state);
	    }
	  });
	}

	function report(state) {
	  console.log('Permission ' + state);
	}

	


function myMap(LatLng, zoom) {
	var map = new google.maps.Map(document.getElementById("map_container"),
			{
				//center: new google.maps.LatLng(7.2665013,80.541458),
				center : LatLng,
				zoom : zoom,
				gestureHandling : 'greedy',
				mapTypeId : google.maps.MapTypeId.ROADMAP
			});
	
	
			
		 var infoWindow = new google.maps.InfoWindow;
			handlePermission();

       if (navigator.geolocation) {
           navigator.geolocation.getCurrentPosition(function(position) {
             var pos = {
               lat: position.coords.latitude,
               lng: position.coords.longitude
             };
             
             
             document.getElementById("txtGpsLatitude").value = position.coords.latitude;
             document.getElementById("txtGpsLongitude").value = position.coords.longitude;
             infoWindow.setPosition(pos);
             infoWindow.setContent('Location found.' + position.coords.latitude + " " + position.coords.longitude);
             infoWindow.open(map);
             map.setCenter(pos);
             var marker = new google.maps.Marker({
					position: pos,
					map: map,
					icon: '/MMS/resources/img/CEBImages/mylocation.png',
					title: "You are here !!!"
				});
		        
             
             
             
           }, function() {
             handleLocationError(true, infoWindow, map.getCenter());
           });
         } else {
           // Browser doesn't support Geolocation
           handleLocationError(false, infoWindow, map.getCenter());
         }
      // }

       function handleLocationError(browserHasGeolocation, infoWindow, pos) {
         infoWindow.setPosition(pos);
         infoWindow.setContent(browserHasGeolocation ?
                               'Error: The Geolocation service failed.' :
                               'Error: Your browser doesn\'t support geolocation.');
         infoWindow.open(map);
       } 
       
       map.addListener('click', function(mapsMouseEvent) {
	          // Close the current InfoWindow.
	          infoWindow.close();
	          
	         var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
	       "<tr><td><input type='button' id='myBtn' value='Get Location' onClick='saveFeederLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'></button></td></tr> "+
	           "</table></div>";


	          // Create a new InfoWindow.
	          infoWindow = new google.maps.InfoWindow({position: mapsMouseEvent.latLng});
	          infoWindow.setContent(insDetailTable);
	          infoWindow.open(map);
	        });


       



}

function saveFeederLoc(id){
	//var strFeeder = feeder.options[feeder.selectedIndex].value;
	
	//alert(strFeeder);
	// var y = document.getElementById("feederobj").value;
	//alert(y);			
	//alert(id);
	var n = id.indexOf(",");
	var length = id.length;
	var latitude = id.substring(1, n);
	var longitude = id.substring(n+1, length-1);
	
	document.getElementById("txtGpsLatitude").value = latitude;
    document.getElementById("txtGpsLongitude").value = longitude;
    
}




function findArea() {
	//var categoryId = $(this).val();
	//alert("hiii");
	var strUser = province.options[province.selectedIndex].value;
	/* if(strUser == "DD1"){
		strUser = "DISCO1";
	}else if(strUser == "DD2"){
		strUser = "DISCO2";
	}
	 *///alert("hiiittt : "+strUser);
	//findAllAreaByProvinceNew

	$.ajax({
				type : 'GET',
				url : "/MMS/findAllAreaByProvinceNew/" + strUser,
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
	//alert("hiii");
	var division = divison.options[divison.selectedIndex].value;
	
	//alert(division);
	
	//alert("hiiittt : "+strUser);
	//findAllAreaByProvinceNew

	$.ajax({
				type : 'GET',
				url : "/MMS/findAllProvincs/" + division,
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

function viewLTL(){
	
	
	var strUser = txtManufactureLtl.options[txtManufactureLtl.selectedIndex].value;
	if(strUser=="Yes"){
		document.getElementById("txtManufactureBrand").value = "LTL";
	}else{
		document.getElementById("txtManufactureBrand").value = "";
	}
	
	//alert("hiiii");
}

function cal1(){

	if(document.getElementById("txtOilWeight").value != null){

	var wei = document.getElementById("txtOilWeight").value;
	var vol = wei / 0.86;
	var vol2 = vol.toFixed(2);
	alert("Volume of Oil : " + vol2);
	document.getElementById("txtVolumeOfOil").value=vol2;

	}
	}

	function cal2(){

	if(document.getElementById("txtVolumeOfOil").value != null){

	var volum =  document.getElementById("txtVolumeOfOil").value;
	var weig = volum * 0.86;
	var weig2 = weig.toFixed(2);
	alert("Oil Weight : " + weig2);
	document.getElementById("txtOilWeight").value=weig2;

	}

	}


	function viewResult(){

	var pcbRes =document.getElementById("txtPcbTestResults").value;
	var res = ((pcbRes * pcbRes ) * (-0.0004)) + ((3.4523 * pcbRes) - 9.2363);
	//var a1 = (pcbRes * pcbRes);
	//var a2 = a1 * -0.0004;
	//var a3 = 3.4523 * pcbRes;
	//var a4 = a3 - 9.2363;
	//var res = a2 + a4;
	var res2 = res.toFixed(2);
	//var res = pcbRes;
	alert("PCB Screening Result Aroclor 1260 : " + res2);
	document.getElementById("txtPcbAroclor").value=res2;

	}


	
</script>
</head>
<body onload="myMap(new google.maps.LatLng(7.475214, 80.744077), 7);">
	<div id="theme-wrapper">
		


<head>

<style>


.dropdown {
  position: static;
  display: inline;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #3e8e41;}
</style>
</head>


<header class="navbar" id="header-navbar">
	<div class="container" style="position: fixed">
		<div class="clearfix">
			<button class="navbar-toggle" data-target=".navbar-ex1-collapse" style="left: 0;position: absolute;"
				data-toggle="collapse" type="button">
				<span class="sr-only">Toggle navigation</span> <span
					class="fa fa-bars"></span>
			</button>
			<!-- <button class="navbar-toggle" data-target=".navbar-ex1-collapse" style="left: 0;position: absolute;"
				data-toggle="collapse" type="button">
				<span class="sr-only">Toggle navigation</span> <span
					class="fa fa-bars"></span>
			</button>
			 -->
			 <!-- <div class='page-header'>
  <div class='btn-toolbar pull-right'>
    <div class='btn-group'>
      <button type='button' class='btn btn-primary'>Button Text</button>
    </div>
  </div>
  <h2>Header Text</h2>
</div> -->
			 

			<div
				class="nav-no-collapse navbar-left pull-left hidden-sm hidden-xs">
				<ul class="nav navbar-nav pull-left">
					<li><a class="btn" id="make-small-nav"> <i
							class="fa fa-bars"></i>
					</a></li>
				</ul>
			</div>
			
			

			<div class="nav-no-collapse pull-right" id="header-nav">
				<ul class="nav navbar-nav pull-right">
				
				<li class="hidden-xxs"><a class="btn" href="RequestCalender"> <i
								class="fa fa-calendar"></i> 
						</a></li>

					<li class="mobile-search"><a class="btn"> <i
							class="fa fa-search"></i>
					</a>

						<div class="drowdown-search">
							<form role="search">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Search...">
									<i class="fa fa-search nav-search-icon"></i>
								</div>
							</form>
						</div></li>

					
					
					
						<li class="hidden-xxs"><a class="btn" href=""> <i
								class="fa fa-bell"></i> <span class="badge" 
								></span>
						</a>
						 <div class="dropdown-content">
                    <!--  <a href="#">Line</a>
                     --> <a href="displayAllLines">Line(<span class="num" style="color:red; font-weight:bold;"></span>)</a>
                        <a href="displayAllSupports">Support(<span class="num" style="color:red; font-weight:bold;"></span>)</a>
                            <a href="displayAllMnt">Maintenance Data(<span class="num" style="color:red; font-weight:bold;"></span>)</a>
                                                                                            
                     <!-- <a href="#">Support</a>
                        <a href="#">Maintenance Data</a>
                      -->   
                                                            
                        
                         </div>
                       
                      
						
						
						
						
						
						</li>
						
						
						<!-- <a href="#" class="notification">
  <span>Inbox</span>
  <span class="badge">3</span>
</a> -->
						
						
						
					
					
					
					<li class="hidden-xxs">
					<a class="btn" href="WelcomeEM">
						<i class="fa fa-power-off"></i>
					</a>
				</li>
	
		
		
 
			<!-- <li class="hidden-xxs">
					<a class="btn" href="WelcomeMMS">
						<i class="fa fa-power-off"></i>
					</a>
				</li>		
			 -->		
						
				</ul>
			</div>
		</div>
	</div>
</header>

		<div id="page-wrapper" class="container">
			<div class="row">
				



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		<div id="nav-col" style="height:700px;position:fixed;overflow-y: auto;overflow-x: hidden;">
	<section id="col-left" class="col-left-nano">
		<div id="col-left-inner" class="col-left-nano-content">
			<div id="user-left-box" class="clearfix hidden-sm hidden-xs">
				<div class="user-box">
					<span class="name">
						<p style="font-family:verdana;font-size:15px"><strong>Welcome DATA ENTRY OPERA OPERATOR - 1</strong></p>
					</span>
					<span class="status">
						<i class="fa fa-circle"></i> Online
					</span>
				</div>
			</div>
			<div class="collapse navbar-collapse navbar-ex1-collapse" id="sidebar-nav">	
				<ul class="nav nav-pills nav-stacked">
					<li>
						<a href="dashboardEM">
							<i class="fa fa-dashboard"></i>
							<span>Dashboard</span>
							<!--<span class="label label-info label-circle pull-right">28</span>-->
						</a>
					</li>
					
					<li>
						<a href="#" class="dropdown-toggle">
							<i class="fa fa-retweet"></i>
							<span>Asset Information</span>
							<i class="fa fa-chevron-circle-right drop-icon"></i>
						</a>
						<ul class="submenu">
							<li>
								<a href="dashboardAll">
									Tower Lines - All Division
								</a>
							</li>
							
							<li>
								<a href="PCBdashboard">
									Distribution Transformer - All Division
								</a>
							</li>
							<li>
								<a href="SubstationView">
									View Substation Details
								</a>
							</li>
							
							
						</ul>
					</li>
					
					<!-- <li>
						<a href="#" class="dropdown-toggle">
							<i class="fa fa-retweet"></i>
							<span>Master Data</span>
							<i class="fa fa-chevron-circle-right drop-icon"></i>
						</a>
						<ul class="submenu">
							<li>
								<a href="">
									Manufacturer
								</a>
							</li>
							
							<li>
								<a href="">
									Meter Model
								</a>
							</li>
							
							
						</ul>
					</li>
					 -->
				
					
									
				
						<li>
							
							<a href="#" class="dropdown-toggle">
							<i class="fa fa-retweet"></i>
							<span>Meter Data</span>
							<i class="fa fa-chevron-circle-right drop-icon"></i>
						</a>
						<ul class="submenu">
							<li>
								<a href="addMeter">
									Add
								</a>
							</li>
							
							<li>
								<a href="AddMeterDetails">
									Add Meter
								</a>
							</li>
							<li>
								<a href="AddMeterTestData">
									Add Meter Test
								</a>
							</li>
							
							<li>
								<a href="meterReport">
									Meter Test Report
								</a>
							</li>
							
							
							</ul>
							</li>
							
							
							<li><a href="#" class="dropdown-toggle"> <i
							class="fa fa-sliders"></i> <span>Transformer Data</span> <i
							class="fa fa-chevron-circle-right drop-icon"></i>
					</a>
						<ul class="submenu">

							<li><a href="addEquipment"> Add </a></li>

							<li><a href="editEquipment"> Edit</a></li>
																<li><a href="viewTransformer">View
									</a></li>
							</ul>
						
						
						
						</li>
							
							
							
						  	 
					 
					 	
					<li><a href="#" class="dropdown-toggle"> <i class="fa fa-retweet"></i>
					 <span>Meter Testing Request</span> <i
							class="fa fa-chevron-circle-right drop-icon"></i>
					</a>
						<ul class="submenu">
					
				    
					
					<li>
						
						<a href="MeterTestingRequest?mode=EMT"><i class="fa fa-retweet"></i>
							
							<span>Create</span>
							<!--<span class="label label-info label-circle pull-right">28</span>-->
						</a>
						
					</li>
					<li>
						
						<a href="MeterTestingRequestEdit?mode=EMT"><i class="fa fa-retweet"></i>
							
							<span>Edit</span>
							<!--<span class="label label-info label-circle pull-right">28</span>-->
						</a>
						
					</li>
					
					
					
					
						
						
						 
						 <li>
						<a href="viewMeterRequest"><i class="fa fa-retweet"></i>
							<span>View</span>
							<!--<span class="label label-info label-circle pull-right">28</span>-->
						</a>
						</li>
						
						
						
						
							
					
					</ul>
					</li>	 			
						
														
							
						
								
					<li>
						<a href="WelcomeMMS">
							<i class="fa fa-power-off"></i>
							<span>Log Out</span>
							<!--<span class="label label-info label-circle pull-right">28</span>-->
						</a>
					</li>
					<br>
					
					 
								
						
			</div>

		</div>
	</section>
</div>

				<div id="content-wrapper">

					<div class="row">
						<div class="col-lg-12">
							<div class="col-lg-9">
								<ol class="breadcrumb">
									<li><a href="#">Home</a></li>
									<li class="active"><span>Add Equipment</span></li>
								</ol>


							</div>

							
<div class="col-lg-3">                                      
	   
	                                
</div> 
						</div>
					</div>

					<div class="row">
						<div class="col-lg-8">
							<div class="main-box">

								<div class="main-box-body clearfix">

									


									<form id="SaveEquipment" role="form" action="MMSaddEquipmentnew" method="post">
                                      <button type="button" class="normal">Equipment Data</button>
										<table class="table table-striped table-bordered table-sm " id="tblEquipment">
											<tbody>
                                             <tr>
												 <td width="30%" style="text-align: left">Division</td>
														<td width="70%" style="text-align: left">
														<select id="divison" name="pcbEquipment.divison" class="form-control" onchange="findProvinceByDivision()">
																<option value="NONE">DIVISION</option>
																<option value="TRANS ">TRANSMISSION GROUP                                          </option><option value="GENE  ">GENERATION GROUP                                            </option><option value="CONSER">CONSUMER SERVICES                                           </option><option value="DISPLN">DISTRIBUTION PLANNING                                       </option><option value="DISFIN">DISTRIBUTION - FINANCE BRANCH                               </option><option value="COMBCY">COMBINED CYCLE POWER PLANT                                  </option><option value="DISCO4">DISTRIBUTION DIVISION 4                                     </option><option value="DISCO2">DISTRIBUTION DIVISION 2                                     </option><option value="DISCO3">DISTRIBUTION DIVISION 3                                     </option><option value="DISCO1">DISTRIBUTION DIVISION 1                                     </option><option value="AGMPRJ">ADDITIONAL GENERAL MANAGER - PROJECTS                       </option><option value="AFMHQ ">HEADQUARTERS                                                </option><option value="AGMAM ">ASSET MANAGEMENT                                            </option>
															</select>
															</td>
													</tr>
<tr>
														<td width="30%" style="text-align: left">Province</td>
														<td width="70%" style="text-align: left"><select id="province" name="pcbEquipment.branch" class="form-control" onchange="findArea()">
																<option value="NONE">PROVINCE</option>
																
															</select>
															</td>
															</tr>
														<tr>
														<td width="30%" style="text-align: left">Area</td>
														<td width="70%" style="text-align: left"><select id="area" name="pcbEquipment.unit" class="form-control">
																<option value="NONE">AREA</option>
																
																<option value="ST">STORES</option>
																
															</select>
															</td>
															</tr>
<tr>
														<td width="50%" style="text-align: left">Reference No</td>
														<td width="70%" style="text-align: left"><input id="txtEquipmentId" name="pcbEquipment.referenceNo" placeholder="Enter Reference No" class="form-control" type="text" value=""/> <span
															id="spnEquipmentId" class="label label-danger"></span></td>
													
													</tr>
													<tr>	
														<td width="30%" style="text-align: left">Type</td>
														<td width="70%" style="text-align: left"><select id="txtType" name="pcbEquipment.type" placeholder="&lt;&lt; Select Type &gt;&gt;" class="form-control">
																<option value="-1"><< Select Type >></option>
																<option value="TR">Transformer</option>
																<option value="SB">Single Barrel</option>
																<option value="BL">Barrel Lot</option>
															</select> <span id="spnType" class="label label-danger"></span></td>

													</tr>

													
													<tr>
														<td width="30%" style="text-align: left">Condition</td>
														<td width="70%" style="text-align: left"><select id="txtStatus" name="pcbEquipment.condition" style="background-color: #FFFFF; border-radius: 5px;" placeholder="&lt;&lt; Select Condition &gt;&gt;" class="form-control">
																<option value="In Use">In Use</option>
																<option value="Abandoned">Abandoned</option>
																<option value="Spare">Spare</option>
															
															</select> <span id="spnStatus" class="label label-danger"></span></td>
															</tr>
															<tr>
														<td width="30%" style="text-align: left">Status</td>
													<td width="70%" style="text-align: left"><select id="txtSampleSatisified" name="pcbEquipment.status" style="background-color: #FFFFF; border-radius: 5px;" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control">
																<option value="2">Active</option>
															<option value="3">In Active</option>
															</select> <span id="spnSampleSatisified" class="label label-danger"></span></td>
															
														</tr>
														<tr>
														<td width="30%" style="text-align: left">Sin No</td>
													<td width="70%" style="text-align: left"><input id="txtSinNo" name="pcbEquipment.sinNo" class="form-control" type="text" value=""/> <span
															id="spnSinNo" class="label label-danger"></span></td>
															
														</tr>
												
														</tbody>
														</table>
														
														
														
														<!-- Location Details data -------------------------------------------------------------------------------------->
											<br>
											<!-- <h2 class="pull-left">
												<strong>Location Details</strong>
											</h2>
 -->
                                           <button type="button" class="normal">Location Details</button>
                                               
											<table class="table table-striped table-bordered table-sm " id="tblPcbLocation">
												<tbody>
												
													<tr>
														<td width="30%" style="text-align: left">Location
															Description</td>
														<td width="70%" style="text-align: left"><input id="txtLocationDescription" name="pcbLocation.locationDescription" placeholder="Enter Location Description" class="form-control" type="text" value=""/> <span
															id="spnLocationDescription" class="label label-danger"></span></td>
														
														<td width="30%" style="text-align: left">Mounting (Pole/Plinth/Ground)</td>
														
													 <td width="70%" style="text-align: left"><select id="txtSampleSatisified" name="pcbLocation.mounting" placeholder="&lt;&lt; Pole / Plinth / Ground &gt;&gt;" class="form-control">
																<option value="-1"><< Pole / Plinth / Ground >></option>
																<option value="Pole">Pole</option>
																<option value="Plinth">Plinth</option>
																<option value="Ground">Ground</option>
															</select> <span id="spnSampleSatisified" class="label label-danger"></span></td>
													
													 
													 </tr>
													<tr>
													<td width="30%" style="text-align: left">GPS location
															(Latitude)</td>
														<td width="70%" style="text-align: left"><input id="txtGpsLatitude" name="pcbLocation.gpsLatitude" placeholder="Enter GPS location (Latitude)" class="form-control" type="text" value=""/> <span
															id="spnGpsLatitude" class="label label-danger"></span></td>
													
														
														<td width="30%" style="text-align: left">GPS
																location (Longitude)</td>
														<td width="70%" style="text-align: left"><input id="txtGpsLongitude" name="pcbLocation.gpsLongitude" placeholder="Enter GPS location (Longitude)" class="form-control" type="text" value=""/> <span
															id="spnGpsLongitude" class="label label-danger"></span></td>

													</tr>



													<tr>
														<td width="30%" style="text-align: left">Type of
															Located</td>
														<td width="70%" style="text-align: left"><select id="txtTypeOfLocated" name="pcbLocation.typeOfLocated" placeholder="&lt;&lt; Select Seal Type &gt;&gt;" class="form-control">
																<option value="-1"><< Select Type of Located  >></option>
																<option value="Indoor">Indoor</option>
																<option value="Outdoor">Outdoor</option>
															</select> <span id="spnTypeOfLocated" class="label label-danger"></span></td>
														</tr>


												</tbody>
											</table>
											<br>
											<!-- <h2 class="pull-left">
												<strong>Information Related to Sampling</strong>
											</h2>
											
											 --><button type="button" class="collapsible">Information Related to Sampling</button>
                                                <div class="content">
                                                <table class="table table-striped table-bordered table-sm " id="tblEquipment5">
												<tbody>
												<tr>
												<td width="30%" style="text-align: left">Manufacture
															Year</td>
														<td width="70%" style="text-align: left"><input id="txtManufactureDate" name="pcbEquipment.year" placeholder="Select Manufacture Year" class="form-control" type="text" value=""/> <span
															id="spnManufactureDate" class="label label-danger"></span></td>
														
												</tr>
												<tr>
													
													<td width="30%" style="text-align: left">Manufacturer
															LTL ?</td>
														<td width="70%" style="text-align: left"><select id="txtManufactureLtl" name="pcbEquipment.manufactureLtl" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control" onchange="viewLTL()">
																<option value="-1"><< Yes / No >></option>
																<option value="Yes">Yes</option>
																<option value="No">No</option>
															</select> <span id="spnManufactureLtl" class="label label-danger"></span></td>
														
														<td width="30%" style="text-align: left">Manufacture
															Brand</td>
														<td width="70%" style="text-align: left"><input id="txtManufactureBrand" name="pcbEquipment.manufactureBrand" placeholder="Enter Manufacture Barnd" class="form-control" type="text" value=""/> <span
															id="spnManufactureBrand" class="label label-danger"></span></td>
														
														
														
													</tr>
												<tr>
												<td width="30%" style="text-align: left">Seal
																Type</td>
														<td width="70%" style="text-align: left"><select id="txtSeriaType" name="pcbEquipment.seriaType" placeholder="&lt;&lt; Select Seal Type &gt;&gt;" class="form-control">
																<option value="-1"><< Select Seal Type >></option>
																<option value="Seal">Seal</option>
																<option value="None-Seal">None-Seal</option>
															</select> <span id="spnSeriaType" class="label label-danger"></span></td>
												
												<td width="30%" style="text-align: left">Primary
																Sub</td>
														<td width="70%" style="text-align: left"><select id="txtPrimarySub" name="pcbEquipment.primarySub" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control">
																<option value="-1"><< Yes / No >></option>
																<option value="Yes">Yes</option>
																<option value="No">No</option>
															</select> <span id="spnPrimarySub" class="label label-danger"></span></td>
													
												
												</tr>
												
												<tr>
												<td width="30%" style="text-align: left">Sampling Port</td>
													

													<td width="70%" style="text-align: left"><select id="txtSamplingPort" name="pcbSample.samplingPort" placeholder="&lt;&lt; Top / Bottom &gt;&gt;" class="form-control">
															<option value="-1"><< Top / Bottom >></option>
															<option value="Top">Top</option>
															<option value="Bottom">Bottom</option>
														</select> <span id="spnSamplingPort" class="label label-danger"></span></td>
												
												
												<td width="30%" style="text-align: left">Extracted
															from top</td>
													<td width="70%" style="text-align: left"><select id="txtextractedTop" name="pcbSample.extractedTop" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control">
																<option value="-1"><< Yes / No >></option>
																<option value="Yes">Yes</option>
																<option value="No">No</option>
															</select> <span id="spnExtractedTop" class="label label-danger"></span></td>
												
												</tr>
												<tr>
												<td width="30%" style="text-align: left">Sampling
														Logic Satisfied</td>
													<td width="70%" style="text-align: left"><select id="txtSampleSatisified" name="pcbSample.sampleSatisified" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control">
																<option value="-1"><< Yes / No >></option>
																<option value="Yes">Yes</option>
																<option value="No">No</option>
															</select> <span id="spnSampleSatisified" class="label label-danger"></span></td>
														
											
												</tr>
												
												<tr>
													<td width="30%" style="text-align: left">Sampling
														Number</td>
													<td width="70%" style="text-align: left"><input id="txtSamplingNu" name="pcbSample.samplingNu" placeholder="Enter Sampling Number" class="form-control" type="text" value=""/> <span
														id="spnSamplingNu" class="label label-danger"></span></td>
													

													<td width="30%" style="text-align: left">Sample
															Date</td>
													<td width="70%" style="text-align: left"><input id="txtSampleDate" name="pcbSample.sampleDate" placeholder="Enter Sample date" class="form-control" type="text" value="" maxlength="10"/> <span
														id="spnSampleDate" class="label label-danger"></span></td>
												</tr>
												
												
												
											</tbody>
											</table>
											</div>
											
														
														<br>
											<!-- <h2 class="pull-left">
												<strong>Additional Details</strong>
											</h2>
											 -->			
														
												<button type="button" class="collapsible">Additional Details</button>
                                                <div class="content">		
														<table class="table table-striped table-bordered table-sm " id="tblEquipment1">
												<tbody>
												
											
														<tr>
														<td width="30%" style="text-align: left">Photo
																Taken</td>
														<td width="70%" style="text-align: left"><select id="txtPhotoTaken" name="pcbEquipment.photoTaken" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control">
																<option value="-1"><< Yes / No >></option>
																<option value="Yes">Yes</option>
																<option value="No">No</option>
															</select> <span id="spnPhotoTaken" class="label label-danger"></span></td>
														

														<td width="30%" style="text-align: left">Photo
																Ref 1</td>
														<td width="70%" style="text-align: left"><input id="txtName" name="pcbEquipment.photoRef" placeholder="Enter Photo Ref." class="form-control" type="text" value=""/> <span id="spnName"
															class="label label-danger"></span></td>
													</tr>
													<tr>
													<td width="30%" style="text-align: left">Photo
																Ref 2</td>
														<td width="70%" style="text-align: left"><input id="txtName" name="pcbEquipment.photoRef2" placeholder="Enter Photo Ref." class="form-control" type="text" value=""/> <span id="spnName"
															class="label label-danger"></span></td>
															
															
															<td width="30%" style="text-align: left">Photo
																Ref 3</td>
														<td width="70%" style="text-align: left"><input id="txtName" name="pcbEquipment.photoRef3" placeholder="Enter Photo Ref." class="form-control" type="text" value=""/> <span id="spnName"
															class="label label-danger"></span></td>
													
													
													</tr>

													<tr>
														<td width="30%" style="text-align: left">Weight of
															Transformer (Kg)</td>
														<td width="70%" style="text-align: left"><input id="txtWeightTransformer" name="pcbEquipment.weightTransformer" placeholder="Enter Weight" class="form-control" type="number" value=""/> <span
															id="spnWeightTransformer" class="label label-danger"></span></td>
														

														<td width="30%" style="text-align: left">Volume
																of Oil (L)</td>
														<td width="70%" style="text-align: left"><input id="txtVolumeOfOil" name="pcbEquipment.volOil" placeholder="Enter Volume of Oil" class="form-control" type="number" step="any" onchange="cal2()" value=""/> <span
															id="spnVolumeOfOil" class="label label-danger"></span></td>
													</tr>

													<tr>
														<td width="30%" style="text-align: left">Oil Weight(Kg)</td>
														<td width="70%" style="text-align: left"><input id="txtOilWeight" name="pcbEquipment.oilWeight" placeholder="Enter Oil Weight" class="form-control" type="number" step="any" onchange="cal1()" value=""/> <span
															id="spnOilWeight" class="label label-danger"></span></td>
														

														<td width="30%" style="text-align: left">Capacity (kVA)</td>
														<td width="70%" style="text-align: left"><input id="txtCapacity" name="pcbEquipment.capacity" placeholder="Enter Capacity" class="form-control" type="number" value=""/> <span id="spnCapacity"
															class="label label-danger"></span></td>
													</tr>

													<tr>
														<td width="30%" style="text-align: left">(Primary/Secondary)  Voltage (kV)</td>
														<td width="70%" style="text-align: left"><select id="txtVoltage" name="pcbEquipment.voltage" placeholder="&lt;&lt; Please select&gt;&gt;" class="form-control">
																<option value="-1"><< Please select >></option>
																<option value="220">220</option>
																<option value="132">132</option>
																<option value="33">33</option>
																<option value="20">20</option>
																<option value="15">15</option>
																<option value="12">12</option>
																<option value="11">11</option>
																<option value="6">6</option>
																
															</select> <span id="spnVoltage" class="label label-danger"></span></td>
																												

														<td width="30%" style="text-align: left">Serial
																Number</td>
														<td width="70%" style="text-align: left"><input id="txtSerialNo" name="pcbEquipment.serialNo" placeholder="Enter Serial Number" class="form-control" type="text" value=""/> <span
															id="spnSerialNo" class="label label-danger"></span></td>
													</tr>

													
													<!-- <tr>
													 -->															<!-- <td></td>
 -->
																											<tr>
 
  
														
														
													</tr>

																									</tbody>
											</table>
											</div>


											<!-- pcb condition data -------------------------------------------------------------------------------------->
											<br>
											<!-- <h2 class="pull-left">
												<strong>Condition of the Transformer</strong>
											</h2>
 -->                                   <button type="button" class="collapsible">Condition of the Transformer</button>
                                       <div class="content">
											<table class="table table-striped table-bordered table-sm " id="tblConditionData">
												<tbody>

																										<tr>
													
													<td width="30%" style="text-align: left">Oil
																Leaks Present</td>
														<td width="70%" style="text-align: left"><select id="txtOilLeaksPresent" name="pcbCondition.oilLeaksPresent" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control">
																<option value="-1"><< Yes / No >></option>
																<option value="Yes">Yes</option>
																<option value="No">No</option>
															</select> <span id="spnOilLeaksPresent" class="label label-danger"></span></td>
												
												<td width="30%" style="text-align: left">Corrosion</td>
														<td width="70%" style="text-align: left"><select id="txtCorrosion" name="pcbCondition.corrosion" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control">
																<option value="-1"><< Yes / No >></option>
																<option value="Yes">Yes</option>
																<option value="No">No</option>
															</select> <span id="spnCorrosion" class="label label-danger"></span></td>
												</tr>
												<tr>
														
														
														<td width="30%" style="text-align: left">Burn
																Marks</td>
														<td width="70%" style="text-align: left"><select id="txtBurnMask" name="pcbCondition.burnMask" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control">
																<option value="-1"><< Yes / No >></option>
																<option value="Yes">Yes</option>
																<option value="No">No</option>
															</select> <span id="spnBurnMask" class="label label-danger"></span></td>
														
														
														<td width="30%" style="text-align: left">Terminal/Connection
																Attention</td>
														<td width="70%" style="text-align: left"><select id="txtTerminalAttention" name="pcbCondition.terminalAttention" style="background-color: #FFFFF; border-radius: 5px;" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control">
																<option value="-1"><< Yes / No >></option>
																<option value="Yes">Yes</option>
																<option value="No">No</option>
															</select> <span id="spnTerminalAttention"
															class="label label-danger"></span></td>
													</tr>
													<tr>
													
													
													<td width="30%" style="text-align: left">Overloaded Signs
															Present</td>
														<td width="70%" style="text-align: left"><select id="txtOverloadPresent" name="pcbCondition.overloadPresent" style="background-color: #FFFFF; border-radius: 5px;" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control">
																<option value="-1"><< Yes / No >></option>
																<option value="Yes">Yes</option>
																<option value="No">No</option>
															</select> <span id="spnOverloadPresent" class="label label-danger"></span></td>
														
													<td width="30%" style="text-align: left">Earth
																Connection is properly done</td>
														<td width="70%" style="text-align: left"><select id="txtEarthConnection" name="pcbCondition.earthConnection" style="background-color: #FFFFF; border-radius: 5px;" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control">
																<option value="-1"><< Yes / No >></option>
																<option value="Yes">Yes</option>
																<option value="No">No</option>
															</select> <span id="spnEarthConnection" class="label label-danger"></span></td>
												
															</tr>

													
													<tr>
														<td width="30%" style="text-align: left">Lighting
															Arresters are properly done</td>
														<td width="70%" style="text-align: left"><select id="txtLightingArrestersDone" name="pcbCondition.lightingArrestersDone" style="background-color: #FFFFF; border-radius: 5px;" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control">
																<option value="-1"><< Yes / No >></option>
																<option value="Yes">Yes</option>
																<option value="No">No</option>
															</select> <span id="spnLightingArrestersDone"
															class="label label-danger"></span></td>
														
<td width="30%" style="text-align: left">Breather is in Good Condition</td>
														<td width="70%" style="text-align: left"><select id="txtBreatherIsGoodConnection" name="pcbCondition.breatherIsGoodConnection" style="background-color: #FFFFF; border-radius: 5px;" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control">
																<option value="-1"><< Yes / No >></option>
																<option value="Yes">Yes</option>
																<option value="No">No</option>
															</select> <span id="spnBreatherIsGoodConnection"
															class="label label-danger"></span></td>
													
													
															</tr>
												</tbody>
											</table>
											</div>



											<!-- pcb sample data -------------------------------------------------------------------------------------->
										<br>
										<!-- <h2 class="pull-left">
											<strong>Pcb Sample Data</strong>
										</h2>
 -->
                                      <button type="button" class="collapsible">Pcb Sample Data</button>
                                       <div class="content">
										<table class="table table-striped table-bordered table-sm " id="tblPcbSample">
											<tbody>
												
												<tr>
<td width="30%" style="text-align: left">PCB Screening Instrument Reading</td>
<td width="70%" style="text-align: left"><input id="txtPcbTestResults" name="pcbSample.pcbTestData" style="background-color: #FFFFF; border-radius: 5px;" placeholder="Enter PCB Test Results" class="form-control" type="number" step="any" onchange="viewResult()" value=""/> <span
id="spnPcbTestResults" class="label label-danger"></span></td>



<td width="30%" style="text-align: left">PCB Screening Result Aroclor 1260</td>
<td width="70%" style="text-align: left"><input id="txtPcbAroclor" name="pcbSample.pcbTestDataAroclor" style="background-color: #FFFFF; border-radius: 5px;" placeholder="Enter PCB Test Results" class="form-control" type="number" step="any" value=""/> <span
id="spnPcbTestResults" class="label label-danger"></span></td>


</tr>

												
												<tr>
													<td width="30%" style="text-align: left">EPF Numbers
														of the Test Group</td>
													<td width="70%" style="text-align: left"><input id="txtEpfNoTestGroup" name="pcbSample.epfNoTestGroup" style="background-color: #FFFFF; border-radius: 5px;" placeholder="Enter EPF Number" class="form-control" type="text" value=""/> <span
														id="spnEpfNoTestGroup" class="label label-danger"></span></td>
													
<td width="30%" style="text-align: left">EPF
															Numbers of the Group</td>
													<td width="70%" style="text-align: left"><input id="txtEpfNoGroup" name="pcbSample.epfNoGroup" style="background-color: #FFFFF; border-radius: 5px;" placeholder="Enter EPF Number" class="form-control" type="text" value=""/> <span
														id="spnEpfNoGroup" class="label label-danger"></span></td>
												
													</tr>

																								<tr>
																								
																								<td width="30%" style="text-align: left">PCB
															Test date</td>
													<td width="70%" style="text-align: left"><input id="txtPcbTestDate" name="pcbSample.pcbTestDate" style="background-color: #FFFFF; border-radius: 5px;" placeholder="Enter PCB Test date" class="form-control" type="text" value="" maxlength="10"/> <span
														id="spnPcbTestDate" class="label label-danger"></span></td>


																								
														</tr>
												
												<tr>
													<td width="30%" style="text-align: left">Remarks</td>
													<td width="70%" style="text-align: left"><textarea id="txtRemarks" name="pcbSample.remarks" style="background-color: #FFFFF; border-radius: 5px;" placeholder="Enter Remark" class="form-control" type="text" rows="5" cols="60"></textarea> <span
														id="spnRemarks" class="label label-danger"></span></td>
													

													<td width="30%" style="text-align: left">Test
															Remarks</td>
													<td width="70%" style="text-align: left"><textarea id="txtTestRemarks" name="pcbSample.testRemarks" style="background-color: #FFFFF; border-radius: 5px;" placeholder="Enter Remark" class="form-control" type="text" rows="5" cols="60"></textarea> <span id="spnTestRemarks"
														class="label label-danger"></span></td>
												</tr>

												

											</tbody>
										</table>
										</div>


											

																						
										<!-- ITI data -------------------------------------------------------------------------------------->
										<br>
										<!-- <h2 class="pull-left">
											<strong>ITI</strong>
										</h2>
										
 -->
                                       <button type="button" class="collapsible">ITI</button>
                                       <div class="content">
										<table class="table table-striped table-bordered table-sm " id="tblPcbSample">
											<tbody>
												<tr>
													<td width="30%" style="text-align: left">Sent to ITI</td>
													<td width="70%" style="text-align: left"><select id="txtSampleSatisified" name="pcbEquipment.sentToIti" style="background-color: #FFFFF; border-radius: 5px;" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control">
																<option value="-1"><< Yes / No >></option>
																<option value="Yes">Yes</option>
																<option value="No">No</option>
															</select> <span id="spnSamplingNu" class="label label-danger"></span></td>
													

													<td width="30%" style="text-align: left">ITI
															Results</td>
													<td width="70%" style="text-align: left"><input id="txtEpfNoGroup" name="pcbEquipment.itiResults" style="background-color: #FFFFF; border-radius: 5px;" placeholder="Enter ITI Results" class="form-control" type="text" value=""/> <span
														id="spnEpfNoGroup" class="label label-danger"></span></td>
												</tr>

												<tr>
													<td width="30%" style="text-align: left">ITI confirmed
														Positive</td>
													<td width="70%" style="text-align: left"><select id="txtSampleSatisified" name="pcbEquipment.itiConfPositive" style="background-color: #FFFFF; border-radius: 5px;" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control">
																<option value="-1"><< Yes / No >></option>
																<option value="Yes">Yes</option>
																<option value="No">No</option>
															</select> <span id="spnSamplingNu" class="label label-danger"></span></td>
																										

												</tr>
												
												<tr>
												<td width="30%" style="text-align: left">Completed</td>
													<td width="70%" style="text-align: left"><select id="txtSampleSatisified" name="pcbSample.completed" style="background-color: #FFFFF; border-radius: 5px;" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control">
																<option value="-1"><< Yes / No >></option>
																<option value="Yes">Yes</option>
																<option value="No">No</option>
															</select> <span id="spnSampleSatisified" class="label label-danger"></span></td>
															
													<td width="30%" style="text-align: left">Test Lab</td>
														
													<td width="70%" style="text-align: left"><select id="txtSampleSatisified" name="pcbSample.testLab" style="background-color: #FFFFF; border-radius: 5px;" placeholder="&lt;&lt; Yes / No &gt;&gt;" class="form-control">
																<option value="-1"><< Colombo / Kandy >></option>
																<option value="Colombo">Colombo</option>
																<option value="Kandy">Kandy</option>
															</select> <span id="spnSampleSatisified" class="label label-danger"></span></td>
														
												</tr>
												

											</tbody>
										</table>
										</div>
										
										<!---------------------------------------------------------------->





										<div class="form-group">
											<div class="pull-left">

												<input type="submit" Value="Add" class="btn btn-success" />

												<button type="button" class="btn btn-warning"
													onclick="window.location.href='editEquipment'">Edit
													</button>
											</div>
										</div>
										
										
<div class="col-sm-12" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
								</div>



									</form>
									<!-- <div class="form-group">
											<div class="pull-left">
											
												<input type="submit" Value="Add" class="btn btn-success" />
												
												<button type="button" class="btn btn-warning" onclick="window.location.href='displayLine'">Edit</button>
											</div>
										</div> -->


								</div>
							</div>
						</div>

					</div>



				</div>
			</div>
		</div>
	</div>
	<footer id="footer-bar" class="row" style="position:fixed">
	<p id="footer-copyright" class="col-xs-12">
		&copy;@ Ceylon Electricity Board - IT Branch - Version 1.8.1
	</p>
	
</footer>
	<!-- global scripts -->	
<script src="/MMS/resources/js/demo-skin-changer.js"> </script> <!-- only for demo -->

<script src="/MMS/resources/js/jquery.js"> </script>
<script src="/MMS/resources/js/bootstrap.js"> </script>
<script src="/MMS/resources/js/jquery.nanoscroller.min.js"> </script>
<script src="/MMS/resources/js/functions.js"> </script>

<script src="/MMS/resources/js/demo.js"> </script> <!-- only for demo -->

<!-- this page specific scripts -->
<script src="/MMS/resources/js/jquery-ui.custom.min.js"> </script>
<script src="/MMS/resources/js/fullcalendar.min.js"> </script>
<script src="/MMS/resources/js/jquery.slimscroll.min.js"> </script>
<script src="/MMS/resources/js/raphael-min.js"> </script>
<script src="/MMS/resources/js/morris.min.js"> </script>
<script src="/MMS/resources/js/moment.min.js"> </script>
<script src="/MMS/resources/js/daterangepicker.js"> </script>
<script src="/MMS/resources/js/jquery-jvectormap-1.2.2.min.js"> </script>
<script src="/MMS/resources/js/jquery-jvectormap-world-merc-en.js"> </script>
<script src="/MMS/resources/js/gdp-data.js"> </script>
<script src="/MMS/resources/js/flot/jquery.flot.js"> </script>
<script src="/MMS/resources/js/flot/jquery.flot.min.js"> </script>
<script src="/MMS/resources/js/flot/jquery.flot.pie.min.js"> </script>
<script src="/MMS/resources/js/flot/jquery.flot.stack.min.js"> </script>
<script src="/MMS/resources/js/flot/jquery.flot.resize.min.js"> </script>
<script src="/MMS/resources/js/flot/jquery.flot.time.min.js"> </script>
<script src="/MMS/resources/js/flot/jquery.flot.threshold.js"> </script>
<script src="/MMS/resources/js/jquery.countTo.js"> </script>

<!-- theme scripts -->
<script src="/MMS/resources/js/scripts.js"> </script>
<script src="/MMS/resources/js/pace.min.js"> </script>
<script>
var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}
</script>
</body>
</html>