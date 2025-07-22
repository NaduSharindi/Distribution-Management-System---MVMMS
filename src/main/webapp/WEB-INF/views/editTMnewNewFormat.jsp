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
#buttons{
margin-left:465px;
}
.table-scroll {
  position: relative;
  width:100%;
  z-index: 1;
  margin-top: 2px;
  overflow: auto;
  height: 400px;
}

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

.button5{
  width: 200px;
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

.button5:hover {
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
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap&libraries=geometry"></script>

<script type="text/javascript">



function showLocation(position) {
   var latitude = position.coords.latitude;
   var longitude = position.coords.longitude;
   alert("Latitude : " + latitude + " Longitude: " + longitude);
}

function errorHandler(err) {
   if(err.code == 1) {
      alert("Error: Access is denied!");
   } else if( err.code == 2) {
      alert("Error: Position is unavailable!");
   }
}
	
function getLocation() {

   if(navigator.geolocation) {
      
      // timeout at 60000 milliseconds (60 seconds)
      var options = {timeout:60000};
      navigator.geolocation.getCurrentPosition(showLocation, errorHandler, options);
   } else {
      alert("Sorry, browser does not support geolocation!");
   }
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
		//getLocation();
		/**  if(!!navigator.geolocation) {
					//alert('Support');
										
					navigator.geolocation.getCurrentPosition(function(position) {
					var pos = {
			              lat: position.coords.latitude,
			              lng: position.coords.longitude
			        };
					map.setCenter(pos);
			        var marker = new google.maps.Marker({
						position: pos,
						map: map,
						icon: '<c:url value="/resources/img/CEBImages/mylocation.png"/>',
						title: "You are here !!!"
					});
			        });
				}
				else {
					//alert('No Support');
				} */
				
 		var infoWindow = new google.maps.InfoWindow;

	       if (navigator.geolocation) {
	           navigator.geolocation.getCurrentPosition(function(position) {
	             var pos = {
	               lat: position.coords.latitude,
	               lng: position.coords.longitude
	             };

	             infoWindow.setPosition(pos);
	             infoWindow.setContent('Location found.');
	             infoWindow.open(map);
	             map.setCenter(pos);
	             var marker = new google.maps.Marker({
						position: pos,
						map: map,
						icon: '<c:url value="/resources/img/CEBImages/mylocation.png"/>',
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
		

	}

	function viewMapByMode(){
		var viewMode = mode.options[mode.selectedIndex].value;
		//alert(viewMode);
    	
		if(viewMode=='MAP'){
			loadMap();
		}else if(viewMode=='MAP2'){
			loadMapWithoutMnt();
		}else if(viewMode=='WAYLEAVE'){
			loadMap();
		}else if(viewMode=='BASECON'){
			loadMapBaseCon();
		}else if(viewMode=='CONDUCTOR'){
			loadMapConductor();
		}else if(viewMode=='JUMPER'){
			loadMapJumper();
		}else if(viewMode=='MISSING'){
			loadMapMissing();
		}else{
			loadNetwork();
		}
		
	}
	
	
	
	function loadMapMissing() {
		//alert('hiii');
		var map = new google.maps.Map(document.getElementById("map_container"), {
          //center: new google.maps.LatLng(7.2665013,80.541458),
          center: new google.maps.LatLng(7.873054,80.771797),
          zoom: 12,
          gestureHandling: 'greedy',
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });

		var infoWindow = new google.maps.InfoWindow();
		var strArea = area.options[area.selectedIndex].value;
		var strLine = line.options[line.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
		
		//variables for get the move location
		
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + bounds );
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNewProvince/" + strArea +"/" + strLine + "/" +strProvince,
                 data: {},
                contentType: "application/json; charset=utf-8",
                success : function(json){
                	//alert(json.length);
                	
                		for (var i = 0, length = json.length; i < length; i++) {
        					var data = json[i],
        						latLng = new google.maps.LatLng(data[0].gpsLatitude, data[0].gpsLongitude);
        						//alert('huuuuuuu');
        						bounds.extend(latLng);
        						//alert('huuuuuuu4');
        						var image = {
        						    url: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
        						    // This marker is 20 pixels wide by 32 pixels high.
        						    size: new google.maps.Size(20, 32),
        						    // The origin for this image is (0, 0).
        						    origin: new google.maps.Point(0, 0),
        						    // The anchor for this image is the base of the flagpole at (0, 32).
        						    anchor: new google.maps.Point(0, 32)
        						  };
        						  // Shapes define the clickable region of the icon. The type defines an HTML
        						  // <area> element 'poly' which traces out a polygon as a series of X,Y points.
        						  // The final coordinate closes the poly by connecting to the first coordinate.
        						  var shape = {
        						    coords: [1, 1, 1, 20, 18, 20, 18, 1],
        						    type: 'poly'
        						 };
        						  
        						  
        						 
        						  if(data[1].noofmissingparts<=2){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Green.png"/>',
                  						title: "Click here to view details of Tower No "+data[0].towerNo + "Weightage :" + data[1].noofmissingparts,
                  						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
                  					});
      								
             						 }
             						 else if(data[1].noofmissingparts<=5){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Blue.png"/>',
                  						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + data[1].noofmissingparts,
                  						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
                  					});
      								
             						 }
             						
             						 else if(data[1].noofmissingparts<=8){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Orange.png"/>',
                  						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + data[1].noofmissingparts,
                  						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
                  					});
      								
             						 }
             						 else{
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/Way_Red.png"/>',
                  						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + data[1].noofmissingparts,
                  						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
                  					});
      								
             						 }



        					// Creating a closure to retain the correct data, notice how I pass the current data in the loop into the closure (marker, data)
        					(function(marker, data) {
									
								var supType;
								if(data[0].supportType == 1){
									supType = 'Tower';
								}else if(data[0].supportType == 2){
									supType = 'Pole';
								}else if(data[0].supportType == 3){
									supType = 'Gantry Bay';
								}else if(data[0].supportType == 4){
									supType = 'GSS Bay';
								}else if(data[0].supportType == 5){
									supType = 'Line Gantry';
								}else if(data[0].supportType == 6){
									supType = 'Lattice Pole';
								}else if(data[0].supportType == 7){
									supType = 'Switch';
								}else{
									supType = 'NONE';
								} 
								       						       
																
								var lineid =data[0].towerNo;
								var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
								data[0].towerNo+"</td></tr><tr><td>Area : </td><td>"+
								data[0].area+"</td></tr><tr><td>Support type :  </td><td>"+
								supType+"</td></tr><tr><td>Tower Conf :  </td><td>"+
								data[5]+"</td></tr><tr><td>Latitude :  </td><td>"+
								data[0].gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data[0].gpsLongitude+"</td></tr><tr> </tr><tr><th>Technical Detail</th></tr>"+
								"<tr><td>Conductor Type :  </td><td>"+data[2]+"</td></tr>"+
								"<tr><td>Tappings :  </td><td>"+data[1].nooftappings+"</td></tr>"+
								"<tr><td>Tower type :  </td><td>"+data[3]+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Inspection Detail</th></tr>"+
								"<tr><td>Latest Inspection Date :  </td><td>"+data[1].insDate+"</td></tr>"+
								"<tr><td>Wayleaves :  </td><td>"+data[1].wayleavestatus+"</td></tr>"+
								"<tr><td>Base Concrete :  </td><td>"+data[1].baseconcretestatus+"</td></tr>"+
								"<tr><td>Conductor Status : </td><td>"+data[1].conductorstatus+"</td></tr>"+
								"<tr><td>Jumper Status :  </td><td>"+data[1].jumperstatus+"</td></tr>"+
								"<tr><td>Missing Parts :  </td><td>"+data[1].noofmissingparts+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td><button type='button' id='myBtn' data-toggle=modal data-target=#myModal onClick='view(\"" + data[0].id + "\")'>View</button></td></tr> "+
								"</table></div>";
								

	
        						google.maps.event.addListener(marker, "click", function(e) {

            						            							infoWindow.setContent(insDetailTable);
        									infoWindow.open(map, marker);
        						});


        					})(marker, data);

        				}
                		
                		
                		  

                		map.fitBounds(bounds);

                		
        				
                }
                
                
         });
		
	}


	
	
	function loadMapConductor() {
		//alert('hiii');
		var map = new google.maps.Map(document.getElementById("map_container"), {
          //center: new google.maps.LatLng(7.2665013,80.541458),
          center: new google.maps.LatLng(7.873054,80.771797),
          zoom: 12,
          gestureHandling: 'greedy',
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });

		var infoWindow = new google.maps.InfoWindow();
		var strArea = area.options[area.selectedIndex].value;
		var strLine = line.options[line.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
		
		//variables for get the move location
		
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + bounds );
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNewProvince/" + strArea +"/" + strLine + "/" +strProvince,
                  data: {},
                contentType: "application/json; charset=utf-8",
                success : function(json){
                	//alert(json.length);
                	
                		for (var i = 0, length = json.length; i < length; i++) {
        					var data = json[i],
        						latLng = new google.maps.LatLng(data[0].gpsLatitude, data[0].gpsLongitude);
        						//alert('huuuuuuu');
        						bounds.extend(latLng);
        						//alert('huuuuuuu4');
        						var image = {
        						    url: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
        						    // This marker is 20 pixels wide by 32 pixels high.
        						    size: new google.maps.Size(20, 32),
        						    // The origin for this image is (0, 0).
        						    origin: new google.maps.Point(0, 0),
        						    // The anchor for this image is the base of the flagpole at (0, 32).
        						    anchor: new google.maps.Point(0, 32)
        						  };
        						  // Shapes define the clickable region of the icon. The type defines an HTML
        						  // <area> element 'poly' which traces out a polygon as a series of X,Y points.
        						  // The final coordinate closes the poly by connecting to the first coordinate.
        						  var shape = {
        						    coords: [1, 1, 1, 20, 18, 20, 18, 1],
        						    type: 'poly'
        						 };
        						  
        						  
 var count = 0;
        						  
        						  
        						  if(data[1].conductorstatus.indexOf('Good')== 0){
       							   	   var countGood = 0;
       							       count = count + countGood;
       							       //alert(count);
       						  	  }
        						  if(data[1].conductorstatus.indexOf('Ground clearance not enough')== 0){
      							   	   var countGood = 2;
      							       count = count + countGood;
      							       //alert(count);
      						  	  }
        						  if(data[1].conductorstatus.indexOf('Damaged')== 0){
     							   	   var countGood = 3;
     							       count = count + countGood;
     							       //alert(count);
     						  	  }
        						  if(data[1].conductorstatus.indexOf('Danger')== 0){
    							   	   var countGood = 4;
    							       count = count + countGood;
    							       //alert(count);
    						  	  }
        						  if((data[1].conductorstatus.indexOf('Good')== -1) && (data[1].conductorstatus.indexOf('Danger')== -1) && (data[1].conductorstatus.indexOf('Damaged')== -1) && (data[1].conductorstatus.indexOf('Ground clearance not enough')== -1) ){
   							   	   var countGood = 1;
   							       count = count + countGood;
   							       //alert(count);
   						  	      } 
        						  
        						  
        						  
        						  if(count<=1){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Green.png"/>',
                  						title: "Click here to view details of Tower No "+data[0].towerNo + "Weightage :" + count,
                  						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
                  					});
      								
             						 }
             						 else if(count<=3){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Blue.png"/>',
                  						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
                  						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
                  					});
      								
             						 }
             						
             						 else if(count<=5){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Orange.png"/>',
                  						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
                  						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
                  					});
      								
             						 }
             						 else{
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/Way_Red.png"/>',
                  						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
                  						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
                  					});
      								
             						 }
              					
         						  
        						  
        					// Creating a closure to retain the correct data, notice how I pass the current data in the loop into the closure (marker, data)
        					(function(marker, data) {
								var supType;
								if(data[0].supportType == 1){
									supType = 'Tower';
								}else if(data[0].supportType == 2){
									supType = 'Pole';
								}else if(data[0].supportType == 3){
									supType = 'Gantry Bay';
								}else if(data[0].supportType == 4){
									supType = 'GSS Bay';
								}else if(data[0].supportType == 5){
									supType = 'Line Gantry';
								}else if(data[0].supportType == 6){
									supType = 'Lattice Pole';
								}else if(data[0].supportType == 7){
									supType = 'Switch';
								}else{
									supType = 'NONE';
								} 
								       						       
																
								var lineid =data[0].towerNo;
								var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
								data[0].towerNo+"</td></tr><tr><td>Area : </td><td>"+
								data[0].area+"</td></tr><tr><td>Support type :  </td><td>"+
								supType+"</td></tr><tr><td>Tower Conf :  </td><td>"+
								data[5]+"</td></tr><tr><td>Latitude :  </td><td>"+
								data[0].gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data[0].gpsLongitude+"</td></tr><tr> </tr><tr><th>Technical Detail</th></tr>"+
								"<tr><td>Conductor Type :  </td><td>"+data[2]+"</td></tr>"+
								"<tr><td>Tappings :  </td><td>"+data[1].nooftappings+"</td></tr>"+
								"<tr><td>Tower type :  </td><td>"+data[3]+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Inspection Detail</th></tr>"+
								"<tr><td>Latest Inspection Date :  </td><td>"+data[1].insDate+"</td></tr>"+
								"<tr><td>Wayleaves :  </td><td>"+data[1].wayleavestatus+"</td></tr>"+
								"<tr><td>Base Concrete :  </td><td>"+data[1].baseconcretestatus+"</td></tr>"+
								"<tr><td>Conductor Status : </td><td>"+data[1].conductorstatus+"</td></tr>"+
								"<tr><td>Jumper Status :  </td><td>"+data[1].jumperstatus+"</td></tr>"+
								"<tr><td>Missing Parts :  </td><td>"+data[1].noofmissingparts+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td><button type='button' id='myBtn' data-toggle=modal data-target=#myModal onClick='view(\"" + data[0].id + "\")'>View</button></td></tr> "+
								"</table></div>";
								

	
        						google.maps.event.addListener(marker, "click", function(e) {
	            							
	            							infoWindow.setContent(insDetailTable);
        									infoWindow.open(map, marker);
        						});


        					})(marker, data);

        				}
                		
                		map.fitBounds(bounds);

                		
        				
                }
                
                
         });
		
	}

	
	
	
	function loadMapBaseCon() {
		//alert('hiii');
		var map = new google.maps.Map(document.getElementById("map_container"), {
          //center: new google.maps.LatLng(7.2665013,80.541458),
          center: new google.maps.LatLng(7.873054,80.771797),
          zoom: 12,
          gestureHandling: 'greedy',
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });

		var infoWindow = new google.maps.InfoWindow();
		var strArea = area.options[area.selectedIndex].value;
		var strLine = line.options[line.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
		
		//variables for get the move location
		
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + bounds );
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNewProvince/" + strArea +"/" + strLine + "/" +strProvince,
                 data: {},
                contentType: "application/json; charset=utf-8",
                success : function(json){
                	//alert(json.length);
                	
                		for (var i = 0, length = json.length; i < length; i++) {
        					var data = json[i],
        						latLng = new google.maps.LatLng(data[0].gpsLatitude, data[0].gpsLongitude);
        						//alert('huuuuuuu');
        						bounds.extend(latLng);
        						//alert('huuuuuuu4');
        						var image = {
        						    url: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
        						    // This marker is 20 pixels wide by 32 pixels high.
        						    size: new google.maps.Size(20, 32),
        						    // The origin for this image is (0, 0).
        						    origin: new google.maps.Point(0, 0),
        						    // The anchor for this image is the base of the flagpole at (0, 32).
        						    anchor: new google.maps.Point(0, 32)
        						  };
        						  // Shapes define the clickable region of the icon. The type defines an HTML
        						  // <area> element 'poly' which traces out a polygon as a series of X,Y points.
        						  // The final coordinate closes the poly by connecting to the first coordinate.
        						  var shape = {
        						    coords: [1, 1, 1, 20, 18, 20, 18, 1],
        						    type: 'poly'
        						 };
        						  
        						  
        					var count = 0;
        					 if(data[1].baseconcretestatus.indexOf('GOOD')== 0){
       							   var countGood = 0;
       							   count = countGood;
       							   //alert(count);
       						  }
       						  if(data[1].baseconcretestatus.indexOf('Good')== 0){
      							   	   var countGood = 0;
      							       count = count + countGood;
      							       //alert(count);
      						  	  }
       						  if(data[1].baseconcretestatus.indexOf('BACKFILLING')== 0){
     							   	   var countGood = 1;
     							       count = count + countGood;
     							       //alert(count);
     						  	  }
       						  if(data[1].baseconcretestatus.indexOf('CORRODED')== 0){
    							   	   var countGood = 2;
    							       count = count + countGood;
    							       //alert(count);
    						  	  }
       						  if(data[1].baseconcretestatus.indexOf('M_DAMAGE')== 0){
   							   	   var countGood = 2;
   							       count = count + countGood;
   							       //alert(count);
   						  	  }
       						  if(data[1].baseconcretestatus.indexOf('COVERED')== 0){
  							   	   var countGood = 3;
  							       count = count + countGood;
  							       //alert(count);
  						  	      }
       						  if(data[1].baseconcretestatus.indexOf('WATER_LODGE')== 0){
     							   	   var countGood = 3;
     							       count = count + countGood;
     							       //alert(count);
     						  	  }
       						  if(data[1].baseconcretestatus.indexOf('DANGER')== 0){
    							   	   var countGood = 4;
    							       count = count + countGood;
    							       //alert(count);
    						  	  }
       						  
       						  
       						if(count<=2){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Green.png"/>',
            						title: "Click here to view details of Tower No "+data[0].towerNo + "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }
       						 else if(count<=5){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Blue.png"/>',
            						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }
       						
       						 else if(count<=8){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Orange.png"/>',
            						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }
       						 else{
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/Way_Red.png"/>',
            						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }






       						  
       						  
       						  
       						  
       						  
        					(function(marker, data) {
									
								var supType;
								if(data[0].supportType == 1){
									supType = 'Tower';
								}else if(data[0].supportType == 2){
									supType = 'Pole';
								}else if(data[0].supportType == 3){
									supType = 'Gantry Bay';
								}else if(data[0].supportType == 4){
									supType = 'GSS Bay';
								}else if(data[0].supportType == 5){
									supType = 'Line Gantry';
								}else if(data[0].supportType == 6){
									supType = 'Lattice Pole';
								}else if(data[0].supportType == 7){
									supType = 'Switch';
								}else{
									supType = 'NONE';
								} 
								       						       
								var lineid =data[0].towerNo;
								var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
								data[0].towerNo+"</td></tr><tr><td>Area : </td><td>"+
								data[0].area+"</td></tr><tr><td>Support type :  </td><td>"+
								supType+"</td></tr><tr><td>Tower Conf :  </td><td>"+
								data[5]+"</td></tr><tr><td>Latitude :  </td><td>"+
								data[0].gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data[0].gpsLongitude+"</td></tr><tr> </tr><tr><th>Technical Detail</th></tr>"+
								"<tr><td>Conductor Type :  </td><td>"+data[2]+"</td></tr>"+
								"<tr><td>Tappings :  </td><td>"+data[1].nooftappings+"</td></tr>"+
								"<tr><td>Tower type :  </td><td>"+data[3]+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Inspection Detail</th></tr>"+
								"<tr><td>Latest Inspection Date :  </td><td>"+data[1].insDate+"</td></tr>"+
								"<tr><td>Wayleaves :  </td><td>"+data[1].wayleavestatus+"</td></tr>"+
								"<tr><td>Base Concrete :  </td><td>"+data[1].baseconcretestatus+"</td></tr>"+
								"<tr><td>Conductor Status : </td><td>"+data[1].conductorstatus+"</td></tr>"+
								"<tr><td>Jumper Status :  </td><td>"+data[1].jumperstatus+"</td></tr>"+
								"<tr><td>Missing Parts :  </td><td>"+data[1].noofmissingparts+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td><button type='button' id='myBtn' data-toggle=modal data-target=#myModal onClick='view(\"" + data[0].id + "\")'>View</button></td></tr> "+
								"</table></div>";
								

	
        						google.maps.event.addListener(marker, "click", function(e) {
	            							
	            							infoWindow.setContent(insDetailTable);
        									infoWindow.open(map, marker);
        						});


        					})(marker, data);

        				}
                		
                		map.fitBounds(bounds);

                		
        				
                }
                
                
         });
		
	}


	function loadMap() {
		//alert('hiii');
		var map = new google.maps.Map(document.getElementById("map_container"), {
          //center: new google.maps.LatLng(7.2665013,80.541458),
          center: new google.maps.LatLng(7.873054,80.771797),
          zoom: 12,
          gestureHandling: 'greedy',
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });

		var infoWindow = new google.maps.InfoWindow();
		var strArea = area.options[area.selectedIndex].value;
		var strLine = line.options[line.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
		
		//variables for get the move location
		
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + bounds );
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNewProvince/" + strArea +"/" + strLine + "/" +strProvince,
                 data: {},
                contentType: "application/json; charset=utf-8",
                success : function(json){
                	//alert(json.length);
                	
                		for (var i = 0, length = json.length; i < length; i++) {
        					var data = json[i],
        						latLng = new google.maps.LatLng(data[0].gpsLatitude, data[0].gpsLongitude);
        						//alert('huuuuuuu');
        						bounds.extend(latLng);
        						//alert('huuuuuuu4');
        						var image = {
        						    url: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
        						    // This marker is 20 pixels wide by 32 pixels high.
        						    size: new google.maps.Size(20, 32),
        						    // The origin for this image is (0, 0).
        						    origin: new google.maps.Point(0, 0),
        						    // The anchor for this image is the base of the flagpole at (0, 32).
        						    anchor: new google.maps.Point(0, 32)
        						  };
        						  // Shapes define the clickable region of the icon. The type defines an HTML
        						  // <area> element 'poly' which traces out a polygon as a series of X,Y points.
        						  // The final coordinate closes the poly by connecting to the first coordinate.
        						  var shape = {
        						    coords: [1, 1, 1, 20, 18, 20, 18, 1],
        						    type: 'poly'
        						  };
 var count = 0;
        						  
        						  
        						  if(data[1].wayleavestatus.indexOf('GOOD')== 0){
        							   var countGood = 0;
        							   count = countGood;
        							   //alert(count);
        						  }
        						  if(data[1].wayleavestatus.indexOf('Good')== 0){
       							   	   var countGood = 0;
       							       count = count + countGood;
       							       //alert(count);
       						  	  }
        						  if(data[1].wayleavestatus.indexOf('ARROUND')== 0){
      							   	   var countGood = 1;
      							       count = count + countGood;
      							       //alert(count);
      						  	  }
        						  if(data[1].wayleavestatus.indexOf('Along')== 0){
     							   	   var countGood = 2;
     							       count = count + countGood;
     							       //alert(count);
     						  	  }
        						  if(data[1].wayleavestatus.indexOf('ALONG')== 0){
    							   	   var countGood = 2;
    							       count = count + countGood;
    							       //alert(count);
    						  	  }
        						  if(data[1].wayleavestatus.indexOf('Close')== 0){
   							   	   var countGood = 3;
   							       count = count + countGood;
   							       //alert(count);
   						  	      }
        						  if(data[1].wayleavestatus.indexOf('CLOSE')== 0){
      							   	   var countGood = 3;
      							       count = count + countGood;
      							       //alert(count);
      						  	  }
        						  if(data[1].wayleavestatus.indexOf('DANGER')== 0){
     							   	   var countGood = 4;
     							       count = count + countGood;
     							       //alert(count);
     						  	  }
        						  if(data[1].wayleavestatus.indexOf('TOUCH')== 0){
     							   	   var countGood = 5;
     							       count = count + countGood;
     							       //alert(count);
     						  	  }
        						  if(data[1].wayleavestatus.indexOf('Tough')== 0){
    							   	   var countGood = 5;
    							       count = count + countGood;
    							       //alert(count);
    						  	  }
      						 
      						 
       						 if(count<=2){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Green.png"/>',
            						title: "Click here to view details of Tower No "+data[0].towerNo + "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }
       						 else if(count<=5){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Blue.png"/>',
            						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }
       						
       						 else if(count<=8){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Orange.png"/>',
            						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }
       						 else{
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/Way_Red.png"/>',
            						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }
        					// Creating a closure to retain the correct data, notice how I pass the current data in the loop into the closure (marker, data)
        					(function(marker, data) {
									
								
//alert('' + data[0].supportType);
								var supType;
								if(data[0].supportType == 1){
									supType = 'Tower';
								}else if(data[0].supportType == 2){
									supType = 'Pole';
								}else if(data[0].supportType == 3){
									supType = 'Gantry Bay';
								}else if(data[0].supportType == 4){
									supType = 'GSS Bay';
								}else if(data[0].supportType == 5){
									supType = 'Line Gantry';
								}else if(data[0].supportType == 6){
									supType = 'Lattice Pole';
								}else if(data[0].supportType == 7){
									supType = 'Switch';
								}else{
									supType = 'NONE';
								} 
								       						       
								//var contentString = "<div style='float:left'><img src='<c:url value="/resources/img/CEBImages/Tower1.png"/>'></div>";
								//var genInformation ="<div style='float:right; padding: 10px;'><b></b><br/><b>Tower Number:  </b>"+
								//data[0].towerNo+"</br>"+"<b>Area : </b>"+
								//data[0].area+"</br>"+"<b>Support type : </b>"+
    							//supType+"</br>"+"<b>Latitude : </b>"+
    							//data[0].gpsLatitude+"</br>"+"<b>Longitude :</b>"+
    							//data[0].gpsLongitude+"</br></div>";

    							//var techDetail ="<div style='float:right; padding: 10px;'><b>Technical Detail </b><br/><br/><b>Conductor Type:  </b>"+
								//data[2]+"</br>"+"<b>Tappings : </b>"+
								//data[1].nooftappings+"</br>"+"<b>Tower type : </b>"+
								//data[3]+"</br></div>";

								//var insDetail ="<div style='float:right; padding: 10px;'><b>Inspection Detail </b><br/><br/><b>Conductor Type:  </b>"+
								//data[2]+"</br>"+"<b>Tappings : </b>"+
								//data[1].nooftappings+"</br>"+"<b>Tower type : </b>"+
								//data[3]+"</br></div>";
								
								var lineid =data[0].towerNo;
								var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
								data[0].towerNo+"</td></tr><tr><td>Area : </td><td>"+
								data[0].area+"</td></tr><tr><td>Support type :  </td><td>"+
								supType+"</td></tr><tr><td>Tower Conf :  </td><td>"+
								data[5]+"</td></tr><tr><td>Latitude :  </td><td>"+
								data[0].gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data[0].gpsLongitude+"</td></tr><tr> </tr><tr><th>Technical Detail</th></tr>"+
								"<tr><td>Conductor Type :  </td><td>"+data[2]+"</td></tr>"+
								"<tr><td>Tappings :  </td><td>"+data[1].nooftappings+"</td></tr>"+
								"<tr><td>Tower type :  </td><td>"+data[3]+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Inspection Detail</th></tr>"+
								"<tr><td>Latest Inspection Date :  </td><td></td></tr>"+
								"<tr><td>Wayleaves :  </td><td>"+data[1].wayleavestatus+"</td></tr>"+
								"<tr><td>Base Concrete :  </td><td>"+data[1].baseconcretestatus+"</td></tr>"+
								"<tr><td>Conductor Status : </td><td>"+data[1].conductorstatus+"</td></tr>"+
								"<tr><td>Jumper Status :  </td><td>"+data[1].jumperstatus+"</td></tr>"+
								"<tr><td>Missing Parts :  </td><td>"+data[1].noofmissingparts+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td>Last Maintenance Date :  </td><td></td></tr>"+
								"<tr><td>Hot line maintenance details (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"<tr><td>Cold line maintence details  (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"<tr><td><a href=# class=btn btn-lg btn-success data-toggle=modal data-target=#basicModal>Click to view Tower</br> Maintenance Data</a></tr>"								
								"<tr><td><a href='<c:url value="/addSupportNew?id=49"/>'>Add New Support</a></td><td></td></tr>"+
								"</table></div>";
								

	
        						google.maps.event.addListener(marker, "click", function(e) {

            						

        							//infoWindow.setContent("<b>Tower Number:  </b>"+
        								//	data[0].towerNo+"</br>"+"<b>Area : </b>"+
        								//	data[0].area+"</br>"+"<b>Support type : </b>"+
	            						//	supType+"</br>"+"<b>Latitude : </b>"+
	            						//	data[0].gpsLatitude+"</br>"+"<b>Longitude :</b>"+
	            						//	data[0].gpsLongitude+"</br>"+"<b>Conductor Type :</b>"+
	            						//	conType+"</br>"+"<b>Tappings : </b>"+
	            							//data[1].nooftappings+"</br>"+"<b>Tower Type : </b>"+
	            							//data[0].towerType+"</br>"+"<b>Latest Inspection Data : </b>"+
	            							//data[0].towerType+"</br>"+"<b>WayLeaves: </b>"+
	            							//data[1].wayleavestatus+"</br>"+"<b>Base Concrete : </b>"+
	            							//data[1].baseconcretestatus+"</br>"+"<b>Conductor Status : </b>"+
	            							//data[1].conductorstatus+"</br>"+"<b>Jumper Status : </b>"+
	            							//data[1].jumperstatus+"</br>"+"<b>Missing Parts : </b>"+
	            							//data[1].noofmissingparts+
	            							
	            							
	            							//"</br>"+"" +contentString + insDetailTable );
	            							
	            							infoWindow.setContent(insDetailTable);
        									infoWindow.open(map, marker);
        						});


        					})(marker, data);

        				}

                		map.fitBounds(bounds);

                		
                		//var polyline = new GPolyline([
    					                       //       new GLatLng(7.3171376, 80.5608933),
    					                           //   new GLatLng(7.3205831, 80.5581145)],
    					                           //   "#ff0000", 50);
    					                         //   map.addOverlay(polyline);

        				
                }
                
                
         });
		
	}

	

	function loadMapWithoutMnt() {
		//alert('hiii');
		var map = new google.maps.Map(document.getElementById("map_container"), {
          //center: new google.maps.LatLng(7.2665013,80.541458),
          center: new google.maps.LatLng(7.873054,80.771797),
          zoom: 12,
          gestureHandling: 'greedy',
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });

		var infoWindow = new google.maps.InfoWindow();
		var strArea = area.options[area.selectedIndex].value;
		var strLine = line.options[line.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
		
		//variables for get the move location
		
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + bounds );
		$.ajax
        ({
        	type: 'GET',
            url: "/MMS/MapNewOther/" + strArea +"/" + strLine + "/" +strProvince,
             data: {},
            contentType: "application/json; charset=utf-8",
            success : function(json){
            	//alert(json.length);
            	
            		for (var i = 0, length = json.length; i < length; i++) {
    					var data = json[i],
    						latLng = new google.maps.LatLng(data[0].gpsLatitude, data[0].gpsLongitude);
    						//alert('huuuuuuu');
        						bounds.extend(latLng);
        						//alert('huuuuuuu4');
        						var image = {
        						    url: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
        						    // This marker is 20 pixels wide by 32 pixels high.
        						    size: new google.maps.Size(20, 32),
        						    // The origin for this image is (0, 0).
        						    origin: new google.maps.Point(0, 0),
        						    // The anchor for this image is the base of the flagpole at (0, 32).
        						    anchor: new google.maps.Point(0, 32)
        						  };
        						  // Shapes define the clickable region of the icon. The type defines an HTML
        						  // <area> element 'poly' which traces out a polygon as a series of X,Y points.
        						  // The final coordinate closes the poly by connecting to the first coordinate.
        						  var shape = {
        						    coords: [1, 1, 1, 20, 18, 20, 18, 1],
        						    type: 'poly'
        						  };
								  if(data[0].supportType == 1){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkere.png"/>',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower No "+data[0].towerNo
    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
    	            					});
										 
									  }
								  else if(data[0].supportType == 2){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
    	            						icon: '<c:url value="/resources/img/CEBImages/polemarkere.png"/>',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower No "+data[0].towerNo
    	            						//label: { color: '#5DADE2', fontWeight: 'bold', fontSize: '12px', text: 'P' }
    	            					});
									  }
								  else if(data[0].supportType == 3){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_yellow.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GB' }
    	            					});
								  }else if(data[0].supportType == 4){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GSSB' }
    	            					});
								  }else if(data[0].supportType == 5){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_green.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'LG' }
    	            					});
								  }else if(data[0].supportType == 6){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_blue.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'LP' }
    	            					});
								  }else if(data[0].supportType == 7){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'SW' }
    	            					});
								  }else{
										//alert("test13 : "+ data.area);
	            					var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	            						title: "Click here to view details of Tower No "+data[0].towerNo,
	            						label: { color: '#FAF8F8', fontWeight: 'bold', fontSize: '14px', text: '' }
	            					});
								  }
								  
								  
								  if(!!navigator.geolocation) {
										//alert('Support');
															
										navigator.geolocation.getCurrentPosition(function(position) {
										var pos = {
								              lat: position.coords.latitude,
								              lng: position.coords.longitude
								        };
										map.setCenter(pos);
								        var marker = new google.maps.Marker({
											position: pos,
											map: map,
											icon: '<c:url value="/resources/img/CEBImages/mylocation.png"/>',
											title: "You are here !!!"
										});
								        });
									}
									else {
										//alert('No Support');
									}
							
        					//data.gpsLatitude, data.gpsLongitude
        					
        					// var flightPlanCoordinates = [
        					                       //       {lat: json[i].gpsLatitude, lng: json[i].gpsLongitude},
        					                       //       {lat: json[i+1].gpsLatitude, lng: json[i+1].gpsLongitude}
        					                              
        					                         //   ];
        					                          //  var flightPath = new google.maps.Polyline({
        					                             // path: flightPlanCoordinates,
        					                             // geodesic: true,
        					                              //strokeColor: '#FF0000',
        					                              //strokeOpacity: 1.0,
        					                             // strokeWeight: 2
        					                           // });

        					                           // flightPath.setMap(map);
        					
							
        				//var flightPlanCoordinates = [{lat: data.gpsLatitude , lng: data.gpsLongitude}];
        				//var point =latLng;
        				//flightPlanCoordinates.push(point); 
        				//var flightPath = new google.maps.Polyline({
        			   // path: flightPlanCoordinates,
        				        //  geodesic: true,
        				        //  strokeColor: '#FF0000',
        				         // strokeOpacity: 1.0,
        				         // strokeWeight: 2
        				       // });

        				      // flightPath.setMap(map);

        					// Creating a closure to retain the correct data, notice how I pass the current data in the loop into the closure (marker, data)
        					
        					
        					var firstObj = json[i];
	        				var secondObj = json[i+1]; 
	        				
        					
        					(function(marker, data) {

        						
	        					
							/*  if(firstObj[0].lineId == secondObj[0].lineId){
								//var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
        						var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
        						var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
   							 	var distance = calcDistance(p1, p2);
   							    totalLength = distance + distance;
   							 	alert("hiiii2" + totalLength );
   							 	//var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
   							 	//alert("hiiii2 : " + calcDistance(p1, p2));
   							 	/* function calcDistance(p1, p2){
   								  alert("hiiii5");
   								  return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
   							 	} 

		   							
   							 }  */

							/* function calcDistance(p1, p2){
   								if(firstObj[0].lineId == secondObj[0].lineId){
        							var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
        							var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
        						}
 								  //alert("hiiii5");
 								  return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
 							} */
//alert(i);
        						function calcDistance(){
        							//alert("hiiii2 : " + i + secondObj[0]);
            						//if(!secondObj[0]){
            						
            						if(secondObj){
       								if(firstObj[0].lineId == secondObj[0].lineId){
            							var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
            							var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
            							// return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
            							return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2)).toFixed(2);
                 						  
                						}
       								else{
           								return '0';
           								}
            						}else{
           								return '0';
       								}
     								  //alert("hiiii5");
     								  // }
     							}

            					
        						//alert("hiiii3 : " + i + calcDistance());	
								
//alert('' + data[0].supportType);
								var supType;
								if(data[0].supportType == 1){
									supType = 'Tower';
								}else if(data[0].supportType == 2){
									supType = 'Pole';
								}else if(data[0].supportType == 3){
									supType = 'Gantry Bay';
								}else if(data[0].supportType == 4){
									supType = 'GSS Bay';
								}else if(data[0].supportType == 5){
									supType = 'Line Gantry';
								}else if(data[0].supportType == 6){
									supType = 'Lattice Pole';
								}else if(data[0].supportType == 7){
									supType = 'Switch';
								}else{
									supType = 'NONE';
								} 
								       						       
								//var contentString = "<div style='float:left'><img src='<c:url value="/resources/img/CEBImages/Tower1.png"/>'></div>";
								//var genInformation ="<div style='float:right; padding: 10px;'><b></b><br/><b>Tower Number:  </b>"+
								//data[0].towerNo+"</br>"+"<b>Area : </b>"+
								//data[0].area+"</br>"+"<b>Support type : </b>"+
    							//supType+"</br>"+"<b>Latitude : </b>"+
    							//data[0].gpsLatitude+"</br>"+"<b>Longitude :</b>"+
    							//data[0].gpsLongitude+"</br></div>";

    							//var techDetail ="<div style='float:right; padding: 10px;'><b>Technical Detail </b><br/><br/><b>Conductor Type:  </b>"+
								//data[2]+"</br>"+"<b>Tappings : </b>"+
								//data[1].nooftappings+"</br>"+"<b>Tower type : </b>"+
								//data[3]+"</br></div>";

								//var insDetail ="<div style='float:right; padding: 10px;'><b>Inspection Detail </b><br/><br/><b>Conductor Type:  </b>"+
								//data[2]+"</br>"+"<b>Tappings : </b>"+
								//data[1].nooftappings+"</br>"+"<b>Tower type : </b>"+
								//data[3]+"</br></div>";
								
								var lineid =data[0].towerNo;
						/* 		var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
								data[0].towerNo+"</td></tr><tr><td>Distance to next tower (m) :</td><td>"+
								calcDistance()+"</td></tr><tr><td>Area : </td><td>"+
								
								data[0].area+"</td></tr><tr><td>Support type :  </td><td>"+
								supType+"</td></tr><tr><td>Tower Conf :  </td><td>"+
								data[5]+"</td></tr><tr><td>Latitude :  </td><td>"+
								data[0].gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data[0].gpsLongitude+"</td></tr><tr> </tr><tr><th>Technical Detail</th></tr>"+
								"<tr><td>Conductor Type :  </td><td>"+data[2]+"</td></tr>"+
								"<tr><td>Tappings :  </td><td>"+data[1].nooftappings+"</td></tr>"+
								"<tr><td>Tower type :  </td><td>"+data[3]+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Inspection Detail</th></tr>"+
								"<tr><td>Latest Inspection Date :  </td><td></td></tr>"+
								"<tr><td>Wayleaves :  </td><td>"+data[1].wayleavestatus+"</td></tr>"+
								"<tr><td>Base Concrete :  </td><td>"+data[1].baseconcretestatus+"</td></tr>"+
								"<tr><td>Conductor Status : </td><td>"+data[1].conductorstatus+"</td></tr>"+
								"<tr><td>Jumper Status :  </td><td>"+data[1].jumperstatus+"</td></tr>"+
								"<tr><td>Missing Parts :  </td><td>"+data[1].noofmissingparts+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td>Last Maintenance Date :  </td><td></td></tr>"+
								"<tr><td>Hot line maintenance details (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"<tr><td>Cold line maintence details  (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"</table></div>"; */
								var towerNO =  data[0].towerNo;
								
								 var urll = 'http://localhost:9090/MMS/editCompletionData?towerNo='+data[0].id +'&test=test';
								 
								// var url2 = 'http://localhost:9090/MMS/editCompletionData?towerNo='+data[0].id +'&test=test';
									
								 /* var url = '<div id="content">'+
							      '<div id="siteNotice">'+
							      '</div>'+
							      '<p><a href='+urll+'>'+
							      'Add Completion Data'+
							      '</p>'+
							      '</div>'+
							      '</div>';
 */
								
								var lineType;
								
								if(data[3].lineType == 1){
									lineType = 'Backbone';
								}else{
									lineType = 'Distributor';
								}
								
								
								var noOfCiur;
								
								if(data[0].noOfCircuits == 1){
									noOfCiur = 'Single';
								}else if (data[0].noOfCircuits == 2){
									noOfCiur = 'Double';
								}else{
									noOfCiur = 'Both';
								}
								
								
								var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
								data[0].towerNo+"</td></tr><tr><td>Distance to next tower (m) :</td><td>"+
								calcDistance()+"</td></tr><tr><td>Latitude :  </td><td>"+
								data[0].gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data[0].gpsLongitude+"</td></tr><tr><td>Line Name : </td><td>"+
								
								data[3].lineName+"</td></tr><tr><td>Line Length(km) : </td><td>"+
								
								data[3].length+"</td></tr><tr><td>Line Type : </td><td>"+
								
								lineType+"</td></tr><tr><td>No. of Towers : </td><td>"+
								
								data[3].nooftowers+"</td></tr><tr><td>No. of Poles : </td><td>"+
								
								data[3].noofpoles+"</td></tr><tr><td>Area : </td><td>"+
								
								data[5]+"</td></tr><tr><th>Technical Detail</th></tr>"+
								"</tr><tr><td>Support type :  </td><td>"+
								supType+"</td></tr>"+
								"<tr><td>Tower type :  </td><td>"+data[2]+"</td></tr>"+
								"<tr><td>Conductor Type :  </td><td>"+data[1]+"</td></tr>"+
								"<tr><td>No. of Circuits :  </td><td>"+noOfCiur+"</td></tr>"+
								"<tr><td>Tower Conf :  </td><td>"+								
								data[4]+"</td></tr>"+
								"<tr><td>Tappings :</td><td>"+data[0].tapping+"</td></tr>"+
								/* "<tr><td><button type='button' onclick='window.location.href='addProvince''>Back</button></td></tr> "+
								 *//* "<tr><td><a href='<c:url value="/editCompletionData"> <c:param name='towerNo'>${towerNO}</c:param></c:url>'>Add Completion Data</a></td><td></td></tr>"+
								 */"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								/* "<tr><td>Last Maintenance Date :  </td><td></td></tr>"+
								 */"<tr><td><button type='button' id='myBtn' onClick='view(\"" + data[0].id + "\")'>View</button></td></tr> "+
								/* "<tr><td>Hot line maintenance details (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"<tr><td>Cold line maintence details  (ES validated maintenance work summary) :  </td><td></td></tr>"+
								 */"</table></div>";

								/* function showMore(id) {
					                  alert('my id is ' + id);
					            }
								 function showShops() {
								 var  content=document.createElement('div'),
					              button;
					              content.innerHTML='some text<br/>';
					              button=content.appendChild(document.createElement('input'));
					              button.type='button';
					              button.value='click me!'
					              google.maps.event.addDomListener(button,'click', function(){
					                                                                 showMore('1');})
								
								 }
	 */
        						google.maps.event.addListener(marker, "click", function(e) {
        							 

        							//infoWindow.setContent("<b>Tower Number:  </b>"+
        								//	data[0].towerNo+"</br>"+"<b>Area : </b>"+
        								//	data[0].area+"</br>"+"<b>Support type : </b>"+
	            						//	supType+"</br>"+"<b>Latitude : </b>"+
	            						//	data[0].gpsLatitude+"</br>"+"<b>Longitude :</b>"+
	            						//	data[0].gpsLongitude+"</br>"+"<b>Conductor Type :</b>"+
	            						//	conType+"</br>"+"<b>Tappings : </b>"+
	            							//data[1].nooftappings+"</br>"+"<b>Tower Type : </b>"+
	            							//data[0].towerType+"</br>"+"<b>Latest Inspection Data : </b>"+
	            							//data[0].towerType+"</br>"+"<b>WayLeaves: </b>"+
	            							//data[1].wayleavestatus+"</br>"+"<b>Base Concrete : </b>"+
	            							//data[1].baseconcretestatus+"</br>"+"<b>Conductor Status : </b>"+
	            							//data[1].conductorstatus+"</br>"+"<b>Jumper Status : </b>"+
	            							//data[1].jumperstatus+"</br>"+"<b>Missing Parts : </b>"+
	            							//data[1].noofmissingparts+
	            							
	            							
	            							//"</br>"+"" +contentString + insDetailTable );
	            							
	            							infoWindow.setContent(insDetailTable);
        									infoWindow.open(map, marker);
        						});


        					})(marker, data);

        				}

                		map.fitBounds(bounds);

                		
                		//var polyline = new GPolyline([
    					                       //       new GLatLng(7.3171376, 80.5608933),
    					                           //   new GLatLng(7.3205831, 80.5581145)],
    					                           //   "#ff0000", 50);
    					                         //   map.addOverlay(polyline);

        				
                }
                
                
         });
		
	}

	


	
	
	function moveCam(moveLatLng, map){
		if(moveLatLng == null){
			alert("Are you sure?" + moveLatLng);
		}else{
			
		}
	}
	
	function viewTowerByTowerNo() {
		
		//alert("gantryloc");
		var map = new google.maps.Map(document.getElementById("map_container"), {
	          //center: new google.maps.LatLng(7.2665013,80.541458),
	          center: new google.maps.LatLng(7.873054,80.771797),
	          zoom: 12,
	          gestureHandling: 'greedy',
	          mapTypeId: google.maps.MapTypeId.ROADMAP
	        });
		
		var search = document.getElementById("search").value;
		var infoWindow = new google.maps.InfoWindow();
		
		//var strGantry = gantry.options[gantry.selectedIndex].value;
		//alert(search);
		var bounds = new google.maps.LatLngBounds();
		$.ajax({
					type : 'GET',
					url : "/MMS/getTower/" + search + "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						 //alert("success");
						 		//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
								latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
	         					bounds.extend(latLng);
	         					
	         					if(data.supportType == 1){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						icon: '<c:url value="/resources/img/CEBImages/towermarkere.png"/>',
	            						title: "Click here to view details of Tower No "+data.towerNo
	            						
	            					});
									 
								  }
							  else if(data.supportType == 2){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						icon: '<c:url value="/resources/img/CEBImages/polemarkere.png"/>',
	            						title: "Click here to view details of Tower No "+data.towerNo
	            						});
								  }
							  else if(data.supportType == 3){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_yellow.png',
	            						title: "Click here to view details of Tower No "+data.towerNo
	            						
	            					});
							  }else if(data[0].supportType == 4){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
	            						title: "Click here to view details of Tower No "+data.towerNo
	            						            					});
							  }else if(data[0].supportType == 5){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            					    icon: 'http://labs.google.com/ridefinder/images/mm_20_green.png',
	            						title: "Click here to view details of Tower No "+data.towerNo
	            						
	            					});
							  }else if(data[0].supportType == 6){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_blue.png',
	            						title: "Click here to view details of Tower No "+data.towerNo
	            						
	            					});
							  }else if(data[0].supportType == 7){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
	            						title: "Click here to view details of Tower No "+data.towerNo
	            						
	            					});
							  }else{
									
	        					var marker = new google.maps.Marker({
	        						position: latLng,
	        						map: map,
	        						icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	        						title: "Click here to view details of Tower No "+data.towerNo
	        						
	        					});
							  }
	         					
	         					var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
								data.towerNo+"</td></tr><tr><td>Latitude :  </td><td>"+
								data.gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data.gpsLongitude+"</td></tr>"+
								"<tr><td>Tappings :</td><td>"+data.tapping+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td><button type='button' id='myBtn' data-toggle=modal data-target=#myModal onClick='view(\"" + data.id + "\")'>View</button></td></tr> "+
								"</table></div>";
								
								google.maps.event.addListener(marker, "click", function(e) {

	    							infoWindow.setContent(insDetailTable);
									infoWindow.open(map, marker);
	    						});

		
	         					       			
						map.fitBounds(bounds);
					}
				});

	}

	function loadNetwork() {
		//alert('hiii');
		var map = new google.maps.Map(document.getElementById("map_container"), {
          //center: new google.maps.LatLng(7.2665013,80.541458),
          center: new google.maps.LatLng(7.873054,80.771797),
          zoom: 12,
          gestureHandling: 'greedy',
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });

		var infoWindow = new google.maps.InfoWindow();
		var strArea = area.options[area.selectedIndex].value;
		var strLine = line.options[line.selectedIndex].value;
		var selectedValues = $("#line").val();
		
		var strProvince = province.options[province.selectedIndex].value;
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + strArea + strLine );
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNewOther/" + strArea +"/" + strLine +"/"+strProvince,
                 data: {},
                contentType: "application/json; charset=utf-8",
                success : function(json){

                	
                	
                		for (var i = 0, length = json.length; i < length; i++) {
        					var data = json[i],

        					
        						latLng = new google.maps.LatLng(data[0].gpsLatitude, data[0].gpsLongitude);
         					bounds.extend(latLng);
    						

    						var image = {
        						    url: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
        						    // This marker is 20 pixels wide by 32 pixels high.
        						    size: new google.maps.Size(20, 32),
        						    // The origin for this image is (0, 0).
        						    origin: new google.maps.Point(0, 0),
        						    // The anchor for this image is the base of the flagpole at (0, 32).
        						    anchor: new google.maps.Point(0, 32)
        						  };
        						  // Shapes define the clickable region of the icon. The type defines an HTML
        						  // <area> element 'poly' which traces out a polygon as a series of X,Y points.
        						  // The final coordinate closes the poly by connecting to the first coordinate.
        						  var shape = {
        						    coords: [1, 1, 1, 20, 18, 20, 18, 1],
        						    type: 'poly'
        						  };

								//	var marker = new google.maps.Marker({
            					//	position: latLng,
            						//map: map,
            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
            						//marker.setIcon(zoomIcons[map.getZoom()]);
            						//icon: 'http://maps.google.com/mapfiles/ms/icons/purple-dot.png',
            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
            						//title: "Click here to view details of Tower ID "+data.towerNo
            					//});
							
							
								//alert("data.tapping : "+ data.tapping);
							if(data[0].tapping > 0 ){


								if(data[0].supportType == 3){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_yellow.png',
	            						//icon: {
    					         // path: google.maps.SymbolPath.CIRCLE,
    					         // scale: 1
    					   // },
	            						title: "Click here to view details of Tower No "+data[0].towerNo,
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GB' }
	            					});
							  }else if(data[0].supportType == 4){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
	            						//icon: {
    					         // path: google.maps.SymbolPath.CIRCLE,
    					         // scale: 1
    					   // },
	            						title: "Click here to view details of Tower No "+data[0].towerNo,
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GSSB' }
	            					});
							  }else if(data[0].supportType == 7){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
	            						//icon: {
    					         // path: google.maps.SymbolPath.CIRCLE,
    					         // scale: 1
    					   // },
	            						title: "Click here to view details of Tower No "+data[0].towerNo,
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'SW' }
	            					});
							  }else{
								//alert("data.tapping");
								if(data[0].interruptedYes == 1){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: '<c:url value="/resources/img/CEBImages/int.png"/>',
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].interruptedDate +'-'+data[0].interruptionNo },
	            						title: "Click here to view details of Tower No "+data[0].towerNo + " INT NO" + data[0].interruptionNo
	            					});
								}else{
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://www.google.com/mapfiles/topbar.png',
	            						title: "Click here to view details of Tower No "+data[0].towerNo + " ID " + data[0].id
	            					});
							  }
							  }



								

								

								
        						
							}else{


								if(data[0].supportType == 3){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_yellow.png',
	            						//icon: {
    					         // path: google.maps.SymbolPath.CIRCLE,
    					         // scale: 1
    					   // },
	            						title: "Click here to view details of Tower No "+data[0].towerNo,
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GB' }
	            					});
							  }else if(data[0].supportType == 4){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
	            						//icon: {
    					         // path: google.maps.SymbolPath.CIRCLE,
    					         // scale: 1
    					   // },
	            						title: "Click here to view details of Tower No "+data[0].towerNo,
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GSSB' }
	            					});
							  }else if(data[0].supportType == 7){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
	            						//icon: {
    					         // path: google.maps.SymbolPath.CIRCLE,
    					         // scale: 1
    					   // },
	            						title: "Click here to view details of Tower No "+data[0].towerNo,
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'SW' }
	            					});
							  }else{
								  var marker = new google.maps.Marker({
		        						position: latLng,
		        						map: map,
		        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
		        						//marker.setIcon(zoomIcons[map.getZoom()]);
		        						//icon: 'http://www.google.com/mapfiles/dsliderbarshadow.png',
		        						title: "Click here to view details of Tower No "+data[0].towerNo + " ID " + data[0].id,
		        						icon: {
		        					          path: google.maps.SymbolPath.CIRCLE,
		        					          scale: 1
		        					    }
		        					});
							  }




								
        						
                		}
        					//data.gpsLatitude, data.gpsLongitude
        					//	alert('ID : ' + json[i].id +'next id: ' + json[i+1].id);
        					
        					var towerid = data[0].id;
        					var lineid = data[0].lineId;
        					//alert('towerid:' +towerid + 'line id: '+ lineid);
        					var firstObj = json[i];
        					var secondObj = json[i+1];

        					if(secondObj){
   								
        					if(firstObj[0].lineId == secondObj[0].lineId){
        						
        						
        						 var flightPlanCoordinates = [
            					                              {lat: firstObj[0].gpsLatitude, lng: firstObj[0].gpsLongitude},
            					                              {lat: secondObj[0].gpsLatitude, lng: secondObj[0].gpsLongitude}
            					                              
            					                            ];
        						 var flightPath = new google.maps.Polyline({
		                              path: flightPlanCoordinates,
		                              geodesic: true,
		                              strokeColor: '#FF0000',
		                              strokeOpacity: 2.0,
		                              strokeWeight: 4
		                            });
           						flightPath.setMap(map);

		                            
            				}
        					}
        					
        					

        					                            
							
        				//var flightPlanCoordinates = [{lat: data.gpsLatitude , lng: data.gpsLongitude}];
        				//var point =latLng;
        				//flightPlanCoordinates.push(point); 
        				//var flightPath = new google.maps.Polyline({
        			   // path: flightPlanCoordinates,
        				        //  geodesic: true,
        				        //  strokeColor: '#FF0000',
        				         // strokeOpacity: 1.0,
        				         // strokeWeight: 2
        				       // });

        				      // flightPath.setMap(map);

        					// Creating a closure to retain the correct data, notice how I pass the current data in the loop into the closure (marker, data)
        					(function(marker, data) {


        						/* if(firstObj[0].lineId == secondObj[0].lineId){

        							var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
        							alert("hiiii2");
        							var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
        							alert("hiiii2 : " + calcDistance(p1, p2));
        							function calcDistance(p1, p2){
        								  alert("hiiii5");
        								  return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
        							}
        							
        						} */
        						
        						
        						function calcDistance(){
        							//alert("hiiii2 : " + i + secondObj[0]);
            						//if(!secondObj[0]){
            						
            						if(secondObj){
       								if(firstObj[0].lineId == secondObj[0].lineId){
            							var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
            							var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
            							// return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
            							return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2)).toFixed(2);
                 						  
                						}
       								else{
           								return '0';
           								}
            						}else{
           								return '0';
       								}
     								  //alert("hiiii5");
     								  // }
     							}

        						var supType;
								if(data[0].supportType == 1){
									supType = 'Tower';
								}else if(data[0].supportType == 2){
									supType = 'Pole';
								}else if(data[0].supportType == 3){
									supType = 'Gantry Bay';
								}else if(data[0].supportType == 4){
									supType = 'GSS Bay';
								}else if(data[0].supportType == 5){
									supType = 'Line Gantry';
								}else if(data[0].supportType == 6){
									supType = 'Lattice Pole';
								}else if(data[0].supportType == 7){
									supType = 'Switch';
								}else{
									supType = 'NONE';
								} 
								
        						
        						
									
								
var lineType;
								
								if(data[3].lineType == 1){
									lineType = 'Backbone';
								}else{
									lineType = 'Distributor';
								}
								
								
								var noOfCiur;
								
								if(data[0].noOfCircuits == 1){
									noOfCiur = 'Single';
								}else if (data[0].noOfCircuits == 2){
									noOfCiur = 'Double';
								}else{
									noOfCiur = 'Both';
								}
								
								
								var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
								data[0].towerNo+"</td></tr><tr><td>Distance to next tower (m) :</td><td>"+
								calcDistance()+"</td></tr><tr><td>Latitude :  </td><td>"+
								data[0].gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data[0].gpsLongitude+"</td></tr><tr><td>Line Name : </td><td>"+
								
								data[3].lineName+"</td></tr><tr><td>Line Length(km) : </td><td>"+
								
								data[3].length+"</td></tr><tr><td>Line Type : </td><td>"+
								
								lineType+"</td></tr><tr><td>No. of Towers : </td><td>"+
								
								data[3].nooftowers+"</td></tr><tr><td>No. of Poles : </td><td>"+
								
								data[3].noofpoles+"</td></tr><tr><td>Area : </td><td>"+
								
								data[5]+"</td></tr><tr><th>Technical Detail</th></tr>"+
								"</tr><tr><td>Support type :  </td><td>"+
								supType+"</td></tr>"+
								"<tr><td>Tower type :  </td><td>"+data[2]+"</td></tr>"+
								"<tr><td>Conductor Type :  </td><td>"+data[1]+"</td></tr>"+
								"<tr><td>No. of Circuits :  </td><td>"+noOfCiur+"</td></tr>"+
								"<tr><td>Tower Conf :  </td><td>"+								
								data[4]+"</td></tr>"+
								"<tr><td>Tappings :</td><td>"+data[0].tapping+"</td></tr>"+
								/* "<tr><td><button type='button' onclick='window.location.href='addProvince''>Back</button></td></tr> "+
								 *//* "<tr><td><a href='<c:url value="/editCompletionData"> <c:param name='towerNo'>${towerNO}</c:param></c:url>'>Add Completion Data</a></td><td></td></tr>"+
								 */"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td>Last Maintenance Date :  </td><td></td></tr>"+
								"<tr><td>Hot line maintenance details (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"<tr><td>Cold line maintence details  (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"</table></div>";

	
        						google.maps.event.addListener(marker, "click", function(e) {

        							infoWindow.setContent(insDetailTable);
									infoWindow.open(map, marker);
        						});


        					})(marker, data);

        				}
                		map.fitBounds(bounds);

                		//var polyline = new GPolyline([
    					                       //       new GLatLng(7.3171376, 80.5608933),
    					                           //   new GLatLng(7.3205831, 80.5581145)],
    					                           //   "#ff0000", 50);
    					                         //   map.addOverlay(polyline);

        				
                }
                
         });
	}



	function getLine() {
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = area.options[area.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$.ajax({
					type : 'GET',
					url : "/MMS/findLineByArea/" + strUser + "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#line'), option = "<option value='NONE'>LINE</option>";
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

	function findArea() {
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = province.options[province.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$.ajax({
					type : 'GET',
					url : "/MMS/findAllAreaByProvinceNew/" + strUser,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#area'), option = "<option value='NONE'>AREA</option>";
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

	// the smooth zoom function
	function smoothZoom(map, max, cnt) {
		if (cnt >= max) {
			return;
		} else {
			z = google.maps.event.addListener(map, 'zoom_changed', function(
					event) {
				google.maps.event.removeListener(z);
				smoothZoom(map, max, cnt + 1);
			});
			setTimeout(function() {
				map.setZoom(cnt)
			}, 80); // 80ms is what I found to work well on my system -- it might not work well on all systems
		}
	}
	
	function view(id){	
		
	     var strUser = id;
			
				$.ajax({
						type : 'GET',
						url : "/MMS/getLatestMaintenance/" + strUser,
						data : {},
						contentType : "application/json; charset=utf-8",
						success : function(data) {
							
			
							 var x = document.getElementById("anticlimbingstatus");
							 var y = document.getElementById("attentionstatus");
							 var z = document.getElementById("conductorstatus");
							 var w = document.getElementById("earthconductorstatus");
							 var v = document.getElementById("wayleavestatus");
							 
				              
					            if (x.innerHTML === "anticlimbingstatus") { 
					                x.innerHTML = data.anticlimbingstatus; 
					            }
					            if(y.innerHTML === "attentionstatus"){
					            	y.innerHTML = data.attentionstatus;
					            }
					            if(z.innerHTML === "conductorstatus"){
					            	z.innerHTML = data.conductorstatus;
					            }
					            if(w.innerHTML === "earthconductorstatus"){
					            	w.innerHTML = data.earthconductorstatus;
					            }
					            if(v.innerHTML === "wayleavestatus"){
					            	v.innerHTML = data.wayleavestatus;
					            }
					            
							
							 
							// Get the modal
							 var modal = document.getElementById("myModal");
							 modal.style.display = "block";
							 // Get the button that opens the modal
							 var btn = document.getElementById("myBtn");

							 // Get the <span> element that closes the modal
							 var span = document.getElementsByClassName("close")[0];

							 // When the user clicks the button, open the modal 
							 btn.onclick = function() {
							   modal.style.display = "block";
							   //alert("success");
							 }

							 // When the user clicks on <span> (x), close the modal
							 span.onclick = function() {
							   modal.style.display = "none";
							 }

							 // When the user clicks anywhere outside of the modal, close it
							 window.onclick = function(event) {
							   if (event.target == modal) {
							     modal.style.display = "none";
							   }
							 }				
						}
					});
		}
	
	 function approve(){
   		if(estimateNoGloble){
   			
   			var r = confirm("You are going to approve document number :" + estimateNoGloble);
   			if (r == true) {
   				$.ajax({
   					type : 'GET',
   					url : "/MMS/approvePSData?docno="+ estimateNoGloble,
   					data : {},
   					contentType : "application/json; charset=utf-8",
   					success : function(data) {
   						//drawDashboard();
   						
   					}
   				});
   				//
   				drawDashboard();
   				alert("Successfully Done!!");	
   				//drawDashboard();
   				
   			} else {
   	  			
   			}
   		}else{
   			alert("Please select estimate number");
   		}
   		
   	}
       
       
       function reject(){
     		if(estimateNoGloble){
     			
     			var r = confirm("You are going to approve estimate number :" + estimateNoGloble);
     			if (r == true) {
     				$.ajax({
     					type : 'GET',
     					url : "/MMS/rejectEstimate?estimateNo="+ estimateNoGloble +"&deptId="+costCenterNoGloble,
     					data : {},
     					contentType : "application/json; charset=utf-8",
     					success : function(data) {
     						//drawDashboard();
     						
     					}
     				});
     				//
     				drawDashboardRefreash();
     				alert("Successfully Done!!");	
     				//drawDashboard();
     				
     			} else {
     	  			
     			}
     		}else{
     			alert("Please select estimate number");
     		}
     		
     	}
       var arrayDataToSave = [];

       function editAll(stringIDs) {

       	alert("You are going to edit that all Maintenance.. \n" );
       	var arrayAllIds = stringIDs.split(",");
       	
       	var len = arrayAllIds.length

       	for (var count = 0; count < len; count++) {
       		LoadLineToEdit(arrayAllIds[count]);
       	}

       }

       //edited anushka 2019-01-08------------------------------------------------------------------------------------------------------------------------
       function saveAll() {
       	var len = arrayDataToSave.length

       	for (var count = 0; count < len; count++) {
       		var id = arrayDataToSave[count];

       		
       	//	var conceptCycle = $('#cycle').find(":selected").text();
       	//	var conceptCycleValue = $('#cycle').find(":selected").attr("value");

               var conceptCycleValue = document.getElementById("cycleno_"+id).value;
           		
       		var nooftappings = document.getElementById("nooftappings_" + id).value;
       		var pinpole1 = document.getElementById("pinpole1_" + id).value;
       		var switchdev1 = document.getElementById("switchdev1_" + id).value;
       		var pinpole2 = document.getElementById("pinpole2_" + id).value;
       		var switchdev2 = document.getElementById("switchdev2_" + id).value;
       		var pinpole3 = document.getElementById("pinpole3_" + id).value;
       		var switchdev3 = document.getElementById("switchdev3_" + id).value;
       		var noofmissingparts = document
       				.getElementById("noofmissingparts_" + id).value;
       		var nofflashoversets = document
       				.getElementById("nofflashoversets_" + id).value;
       		var wayleavestatus = document.getElementById("wayleavestatus_" + id).value;
       		var baseconcretestatus = document.getElementById("baseconcretestatus_"
       				+ id).value;
       		var anticlimbingstatus = document.getElementById("anticlimbingstatus_"
       				+ id).value;
       		var conductorstatus = document.getElementById("conductorstatus_" + id).value;
       		var jumperstatus = document.getElementById("jumperstatus_" + id).value;
       		var earthconductorstatus = document
       				.getElementById("earthconductorstatus_" + id).value;
       		var attentionstatus = document.getElementById("attentionstatus_" + id).value;
       		var fungussetno = document.getElementById("fungussetno_" + id).value;
       		var wpinset = document.getElementById("wpinset_" + id).value;
       		var endfittingset = document.getElementById("endfittingset_" + id).value;
       		var towerspecial = document.getElementById("towerspecial_" + id).value;
       		//var ludt = document.getElementById("ludt_" + id).value;
       		var ludt = '2019-02-25';
               		
       		var maintenancedate = document.getElementById("maintenancedate_" + id).value;
       		var status = document.getElementById("status_" + id).value;
       		var approvalLevel = document.getElementById("approvalLevel_" + id).value;
       		var hotPossible = document.getElementById("hotpossible_" + id).value;
       		var legpainting = document.getElementById("legpainting_" + id).value;
       		//var status = document.getElementById("status_" + id).value;
       		
       		/* var url = "/MMS/updateTowerMaintence/" + conceptCycleValue + "/" + id
       				+ "/" + nooftappings + "/" + pinpole1 + "/" + switchdev1 + "/"
       				+ pinpole2 + "/" + switchdev2 + "/" + pinpole3 + "/"
       				+ switchdev3 + "/" + noofmissingparts + "/" + nofflashoversets
       				+ "/" + wayleavestatus + "/" + baseconcretestatus + "/"
       				+ anticlimbingstatus + "/" + conductorstatus + "/"
       				+ jumperstatus + "/" + earthconductorstatus + "/"
       				+ attentionstatus + "/" + fungussetno + "/" + wpinset + "/"
       				+ endfittingset + "/" + towerspecial + "/" + ludt + "/"
       				+ maintenancedate + "/" + status + "/" + approvalLevel + "/" + hotPossible + "/" +legpainting+"/";
        */
        
       //@RequestMapping(value = "/updateTowerMaintence/{visitid}/{towerid}/{nooftappings}/{pinpole1}/{switchdev1}/{pinpole2}
       	///{switchdev2}/{pinpole3}/{switchdev3}/{noofmissingparts}/{nofflashoversets}/
       	//{wayleavestatus}/{baseconcretestatus}/{anticlimbingstatus}/{conductorstatus}/{jumperstatus}/{earthconductorstatus}/{attentionstatus}
       	///{fungussetno}/{wpinset}/{endfittingset}/{towerspecial}/{ludt}/{maintenancedate}/{status}/{approvalLevel}/
       	//{hotpossible}/{legPainting}",method = RequestMethod.GET, produces = "application/json")
       	
       	
        
        var url = "/MMS/updateTowerMaintenceN?visitid=" + conceptCycleValue + "&towerid=" + id
       	+ "&nooftappings=" + encodeURIComponent(nooftappings) + "&pinpole1=" + encodeURIComponent(pinpole1) + "&switchdev1=" + encodeURIComponent(switchdev1) + "&pinpole2="
       	+ encodeURIComponent(pinpole2) + "&switchdev2=" + encodeURIComponent(switchdev2) + "&pinpole3=" + encodeURIComponent(pinpole3) + "&switchdev3="
       	+ encodeURIComponent(switchdev3) + "&noofmissingparts=" + encodeURIComponent(noofmissingparts) + "&nofflashoversets=" + encodeURIComponent(nofflashoversets)
       	+ "&wayleavestatus=" + encodeURIComponent(wayleavestatus) + "&baseconcretestatus=" + encodeURIComponent(baseconcretestatus) + "&anticlimbingstatus="
       	+ encodeURIComponent(anticlimbingstatus) + "&conductorstatus=" + encodeURIComponent(conductorstatus) + "&jumperstatus="
       	+ encodeURIComponent(jumperstatus) + "&earthconductorstatus=" + encodeURIComponent(earthconductorstatus) + "&attentionstatus="
       	+ encodeURIComponent(attentionstatus) + "&fungussetno=" + encodeURIComponent(fungussetno) + "&wpinset=" + encodeURIComponent(wpinset) + "&endfittingset="
       	+ encodeURIComponent(endfittingset) + "&towerspecial=" + encodeURIComponent(towerspecial) + "&ludt=" + encodeURIComponent(ludt) + "&maintenancedate="
       	+ encodeURIComponent(maintenancedate) + "&status=" +status + "&approvalLevel="+ encodeURIComponent(approvalLevel) + "&hotpossible=" + encodeURIComponent(hotPossible) + "&legPainting=" +encodeURIComponent(legpainting);


        
        //alert('hiiiii456' + url);
       		
       		$.ajax({
       			type : "GET",
       			url : url,
       			success : function(response) {
       				console.log(response);
       				//window.location.reload();
       							}
       		});
       		
       		disable(id);

       	}
       	alert("Tower maintenance updated succesfully...");
       }
       //-----------------------------------------------------------------------------------------------------------------------------------------------

       function approveAllDEO(stringIDs) {
       	
       	//alert('DEO');
       	
       	var arrayAllIds = stringIDs.split(",");
       	
       	var len = arrayAllIds.length

       	for (var count = 0; count < len; count++) {
       		//LoadLineToEdit(arrayAllIds[count]);
       		arrayDataToSave.push(id);
       	}

       	
       	var len = arrayDataToSave.length

       	for (var count = 0; count < len; count++) {
       		
       		//alert('DEO' );
       		
       		var id = arrayDataToSave[count];

       		
       	//	var conceptCycle = $('#cycle').find(":selected").text();
       	//	var conceptCycleValue = $('#cycle').find(":selected").attr("value");

       		var conceptCycleValue = document.getElementById("cycleno_"+id).value;
           		
       		var nooftappings = document.getElementById("nooftappings_" + id).value;
       		var pinpole1 = document.getElementById("pinpole1_" + id).value;
       		var switchdev1 = document.getElementById("switchdev1_" + id).value;
       		var pinpole2 = document.getElementById("pinpole2_" + id).value;
       		var switchdev2 = document.getElementById("switchdev2_" + id).value;
       		var pinpole3 = document.getElementById("pinpole3_" + id).value;
       		var switchdev3 = document.getElementById("switchdev3_" + id).value;
       		var noofmissingparts = document
       				.getElementById("noofmissingparts_" + id).value;
       		var nofflashoversets = document
       				.getElementById("nofflashoversets_" + id).value;
       		var wayleavestatus = document.getElementById("wayleavestatus_" + id).value;
       		var baseconcretestatus = document.getElementById("baseconcretestatus_"
       				+ id).value;
       		var anticlimbingstatus = document.getElementById("anticlimbingstatus_"
       				+ id).value;
       		var conductorstatus = document.getElementById("conductorstatus_" + id).value;
       		var jumperstatus = document.getElementById("jumperstatus_" + id).value;
       		var earthconductorstatus = document
       				.getElementById("earthconductorstatus_" + id).value;
       		var attentionstatus = document.getElementById("attentionstatus_" + id).value;
       		var fungussetno = document.getElementById("fungussetno_" + id).value;
       		var wpinset = document.getElementById("wpinset_" + id).value;
       		var endfittingset = document.getElementById("endfittingset_" + id).value;
       		var towerspecial = document.getElementById("towerspecial_" + id).value;
       		//var ludt = document.getElementById("ludt_" + id).value;
       		var ludt = '2019-02-25';
               		
       		var maintenancedate = document.getElementById("maintenancedate_" + id).value;
       		var status = document.getElementById("status_" + id).value;
       		var approvalLevel = document.getElementById("approvalLevel_" + id).value;
       		var hotPossible = document.getElementById("hotpossible_" + id).value;
       		var legpainting = document.getElementById("legpainting_" + id).value;
       		//@RequestMapping(value = "/updateTowerMaintence/{visitid}/{towerid}/{nooftappings}/{pinpole1}/{switchdev1}/{pinpole2}
       		///{switchdev2}/{pinpole3}/{switchdev3}/{noofmissingparts}/{nofflashoversets}/
       		//{wayleavestatus}/{baseconcretestatus}/{anticlimbingstatus}/{conductorstatus}/{jumperstatus}/{earthconductorstatus}/{attentionstatus}
       		///{fungussetno}/{wpinset}/{endfittingset}/{towerspecial}/{ludt}/{maintenancedate}/{status}/{approvalLevel}/{hotpossible}/{legPainting}",method = RequestMethod.GET, produces = "application/json")
       		 
       		/* var url = "/MMS/updateTowerMaintenceN?visitid=" + conceptCycleValue + "&towerid=" + id
       				+ "&nooftappings=" + nooftappings + "&pinpole1=" + pinpole1 + "&switchdev1=" + switchdev1 + "&pinpole2="
       				+ pinpole2 + "&switchdev2=" + switchdev2 + "&pinpole3=" + pinpole3 + "&switchdev3="
       				+ switchdev3 + "&noofmissingparts=" + noofmissingparts + "&nofflashoversets=" + nofflashoversets
       				+ "&wayleavestatus=" + wayleavestatus + "&baseconcretestatus=" + baseconcretestatus + "&anticlimbingstatus="
       				+ anticlimbingstatus + "&conductorstatus=" + conductorstatus + "&jumperstatus="
       				+ jumperstatus + "&earthconductorstatus=" + earthconductorstatus + "&attentionstatus="
       				+ attentionstatus + "&fungussetno=" + fungussetno + "&wpinset=" + wpinset + "&endfittingset="
       				+ endfittingset + "&towerspecial=" + towerspecial + "&ludt=" + ludt + "&maintenancedate="
       				+ maintenancedate + "/3/" + approvalLevel + "/" + hotPossible + "/" +legpainting+"/";
        */
       		//alert('hiiiii456' + url);
        
        var url = "/MMS/updateTowerMaintenceN?visitid=" + conceptCycleValue + "&towerid=" + id
       	+ "&nooftappings=" + encodeURIComponent(nooftappings) + "&pinpole1=" + encodeURIComponent(pinpole1) + "&switchdev1=" + encodeURIComponent(switchdev1) + "&pinpole2="
       	+ encodeURIComponent(pinpole2) + "&switchdev2=" + encodeURIComponent(switchdev2) + "&pinpole3=" + encodeURIComponent(pinpole3) + "&switchdev3="
       	+ encodeURIComponent(switchdev3) + "&noofmissingparts=" + encodeURIComponent(noofmissingparts) + "&nofflashoversets=" + encodeURIComponent(nofflashoversets)
       	+ "&wayleavestatus=" + encodeURIComponent(wayleavestatus) + "&baseconcretestatus=" + encodeURIComponent(baseconcretestatus) + "&anticlimbingstatus="
       	+ encodeURIComponent(anticlimbingstatus) + "&conductorstatus=" + encodeURIComponent(conductorstatus) + "&jumperstatus="
       	+ encodeURIComponent(jumperstatus) + "&earthconductorstatus=" + encodeURIComponent(earthconductorstatus) + "&attentionstatus="
       	+ encodeURIComponent(attentionstatus) + "&fungussetno=" + encodeURIComponent(fungussetno) + "&wpinset=" + encodeURIComponent(wpinset) + "&endfittingset="
       	+ encodeURIComponent(endfittingset) + "&towerspecial=" + encodeURIComponent(towerspecial) + "&ludt=" + encodeURIComponent(ludt) + "&maintenancedate="
       	+ encodeURIComponent(maintenancedate) + "&status=" +status + "&approvalLevel="+ encodeURIComponent(approvalLevel) + "&hotpossible=" + encodeURIComponent(hotPossible) + "&legPainting=" +encodeURIComponent(legpainting);


       		$.ajax({
       			type : "GET",
       			url : url,
       			success : function(response) {
       				console.log(response);
       				window.location.reload();
       				disable(id);
       			}
       		});
       	}
       	alert("Tower Maintenance updated succesfully...");
       }
       	
       	
       function approveAllDEO(stringIDs) {
       	
       	//alert('DEO');
       	
       	var arrayAllIds = stringIDs.split(",");
       	
       	var len = arrayAllIds.length

       	for (var count = 0; count < len; count++) {
       		//LoadLineToEdit(arrayAllIds[count]);
       		arrayDataToSave.push(id);
       	}

       	
       	var len = arrayDataToSave.length

       	for (var count = 0; count < len; count++) {
       		
       		//alert('DEO' );
       		
       		var id = arrayDataToSave[count];

       		
       	//	var conceptCycle = $('#cycle').find(":selected").text();
       	//	var conceptCycleValue = $('#cycle').find(":selected").attr("value");

       		var conceptCycleValue = document.getElementById("cycleno_"+id).value;
           		
       		var nooftappings = document.getElementById("nooftappings_" + id).value;
       		var pinpole1 = document.getElementById("pinpole1_" + id).value;
       		var switchdev1 = document.getElementById("switchdev1_" + id).value;
       		var pinpole2 = document.getElementById("pinpole2_" + id).value;
       		var switchdev2 = document.getElementById("switchdev2_" + id).value;
       		var pinpole3 = document.getElementById("pinpole3_" + id).value;
       		var switchdev3 = document.getElementById("switchdev3_" + id).value;
       		var noofmissingparts = document
       				.getElementById("noofmissingparts_" + id).value;
       		var nofflashoversets = document
       				.getElementById("nofflashoversets_" + id).value;
       		var wayleavestatus = document.getElementById("wayleavestatus_" + id).value;
       		var baseconcretestatus = document.getElementById("baseconcretestatus_"
       				+ id).value;
       		var anticlimbingstatus = document.getElementById("anticlimbingstatus_"
       				+ id).value;
       		var conductorstatus = document.getElementById("conductorstatus_" + id).value;
       		var jumperstatus = document.getElementById("jumperstatus_" + id).value;
       		var earthconductorstatus = document
       				.getElementById("earthconductorstatus_" + id).value;
       		var attentionstatus = document.getElementById("attentionstatus_" + id).value;
       		var fungussetno = document.getElementById("fungussetno_" + id).value;
       		var wpinset = document.getElementById("wpinset_" + id).value;
       		var endfittingset = document.getElementById("endfittingset_" + id).value;
       		var towerspecial = document.getElementById("towerspecial_" + id).value;
       		//var ludt = document.getElementById("ludt_" + id).value;
       		var ludt = '2019-02-25';
               		
       		var maintenancedate = document.getElementById("maintenancedate_" + id).value;
       		var status = document.getElementById("status_" + id).value;
       		var approvalLevel = document.getElementById("approvalLevel_" + id).value;
       		var hotPossible = document.getElementById("hotpossible_" + id).value;
       		var legpainting = document.getElementById("legpainting_" + id).value;
       		
       		var url = "/MMS/updateTowerMaintence/" + conceptCycleValue + "/" + id
       				+ "/" + nooftappings + "/" + pinpole1 + "/" + switchdev1 + "/"
       				+ pinpole2 + "/" + switchdev2 + "/" + pinpole3 + "/"
       				+ switchdev3 + "/" + noofmissingparts + "/" + nofflashoversets
       				+ "/" + wayleavestatus + "/" + baseconcretestatus + "/"
       				+ anticlimbingstatus + "/" + conductorstatus + "/"
       				+ jumperstatus + "/" + earthconductorstatus + "/"
       				+ attentionstatus + "/" + fungussetno + "/" + wpinset + "/"
       				+ endfittingset + "/" + towerspecial + "/" + ludt + "/"
       				+ maintenancedate + "/4/" + approvalLevel + "/" + hotPossible + "/" +legpainting+"/";

       		//alert('hiiiii456' + url);

       		$.ajax({
       			type : "GET",
       			url : url,
       			success : function(response) {
       				console.log(response);
       				window.location.reload();
       				disable(id);
       			}
       		});
       	}
       	alert("Tower Maintenance updated succesfully...");
       }
       	
       	function approveAllEE() {
       		var arrayAllIds = stringIDs.split(",");
       		
       		var len = arrayAllIds.length

       		for (var count = 0; count < len; count++) {
       			//LoadLineToEdit(arrayAllIds[count]);
       			arrayDataToSave.push(id);
       		}

       		
       		
       		var len = arrayDataToSave.length

       		for (var count = 0; count < len; count++) {
       			var id = arrayDataToSave[count];

       			
       		//	var conceptCycle = $('#cycle').find(":selected").text();
       		//	var conceptCycleValue = $('#cycle').find(":selected").attr("value");

       	var conceptCycleValue = document.getElementById("cycleno_"+id).value;
       	    		
       			var nooftappings = document.getElementById("nooftappings_" + id).value;
       			var pinpole1 = document.getElementById("pinpole1_" + id).value;
       			var switchdev1 = document.getElementById("switchdev1_" + id).value;
       			var pinpole2 = document.getElementById("pinpole2_" + id).value;
       			var switchdev2 = document.getElementById("switchdev2_" + id).value;
       			var pinpole3 = document.getElementById("pinpole3_" + id).value;
       			var switchdev3 = document.getElementById("switchdev3_" + id).value;
       			var noofmissingparts = document
       					.getElementById("noofmissingparts_" + id).value;
       			var nofflashoversets = document
       					.getElementById("nofflashoversets_" + id).value;
       			var wayleavestatus = document.getElementById("wayleavestatus_" + id).value;
       			var baseconcretestatus = document.getElementById("baseconcretestatus_"
       					+ id).value;
       			var anticlimbingstatus = document.getElementById("anticlimbingstatus_"
       					+ id).value;
       			var conductorstatus = document.getElementById("conductorstatus_" + id).value;
       			var jumperstatus = document.getElementById("jumperstatus_" + id).value;
       			var earthconductorstatus = document
       					.getElementById("earthconductorstatus_" + id).value;
       			var attentionstatus = document.getElementById("attentionstatus_" + id).value;
       			var fungussetno = document.getElementById("fungussetno_" + id).value;
       			var wpinset = document.getElementById("wpinset_" + id).value;
       			var endfittingset = document.getElementById("endfittingset_" + id).value;
       			var towerspecial = document.getElementById("towerspecial_" + id).value;
       			//var ludt = document.getElementById("ludt_" + id).value;
       			var ludt = '2019-02-25';
       	        		
       			var maintenancedate = document.getElementById("maintenancedate_" + id).value;
       			var status = document.getElementById("status_" + id).value;
       			var approvalLevel = document.getElementById("approvalLevel_" + id).value;
       			var hotPossible = document.getElementById("hotpossible_" + id).value;
       			var legpainting = document.getElementById("legpainting_" + id).value;
       			
       			var url = "/MMS/updateTowerMaintence/" + conceptCycleValue + "/" + id
       					+ "/" + nooftappings + "/" + pinpole1 + "/" + switchdev1 + "/"
       					+ pinpole2 + "/" + switchdev2 + "/" + pinpole3 + "/"
       					+ switchdev3 + "/" + noofmissingparts + "/" + nofflashoversets
       					+ "/" + wayleavestatus + "/" + baseconcretestatus + "/"
       					+ anticlimbingstatus + "/" + conductorstatus + "/"
       					+ jumperstatus + "/" + earthconductorstatus + "/"
       					+ attentionstatus + "/" + fungussetno + "/" + wpinset + "/"
       					+ endfittingset + "/" + towerspecial + "/" + ludt + "/"
       					+ maintenancedate + "/1/" + approvalLevel + "/" + hotPossible + "/" +legpainting+"/";

       			//alert('hiiiii456' + url);

       			$.ajax({
       				type : "GET",
       				url : url,
       				success : function(response) {
       					console.log(response);
       					window.location.reload();
       					disable(id);
       				}
       			});
       		}
       		alert("Tower Maintenance updated succesfully...");
       	}







       		function LoadLineToEdit(id)
       	
       		{
       			//alert("id:"+id); 
       			/* System.out.println("id:"+id); */
       		//if(document.getElementById("status_"+id).value == 0 || document.getElementById("status_"+id).value == 1 || document.getElementById("status_"+id).value == 4){
       				//alert("This item is sent for approving or active item or inactive item. You cann't edit this");
       			//}
       			//else{
       				enable(id);
       				arrayDataToSave.push(id);
       			//}
       		}
       		
               function disable(id)
               {
               	//alert('hiiiii'); 
           		document.getElementById("nooftappings_"+id).disabled = true;
           		document.getElementById("pinpole1_"+id).disabled = true;
           		document.getElementById("switchdev1_"+id).disabled = true;
           		document.getElementById("pinpole2_"+id).disabled = true;
           		document.getElementById("switchdev2_"+id).disabled = true;
           		document.getElementById("pinpole3_"+id).disabled = true;
           		document.getElementById("switchdev3_"+id).disabled = true;
           		document.getElementById("noofmissingparts_"+id).disabled = true;
           		document.getElementById("nofflashoversets_"+id).disabled = true;
           		document.getElementById("wayleavestatus_"+id).disabled = true;
           		document.getElementById("baseconcretestatus_"+id).disabled = true;
           		document.getElementById("anticlimbingstatus_"+id).disabled = true;
           		document.getElementById("conductorstatus_"+id).disabled = true;
           		document.getElementById("jumperstatus_"+id).disabled = true;
           		document.getElementById("earthconductorstatus_"+id).disabled = true;
           		document.getElementById("attentionstatus_"+id).disabled = true;
           		document.getElementById("fungussetno_"+id).disabled = true;
           		document.getElementById("wpinset_"+id).disabled = true;
           		document.getElementById("endfittingset_"+id).disabled = true;
           		document.getElementById("towerspecial_"+id).disabled = true;
           		//document.getElementById("ludt_"+id).disabled = true;
           		document.getElementById("maintenancedate_"+id).disabled = true; 
           		document.getElementById("status_"+id).disabled = true;
           		document.getElementById("approvalLevel_"+id).disabled = true;
           		document.getElementById("hotpossible_"+id).disabled = true;
           		
           		document.getElementById("legpainting_"+id).disabled = true;
               }
               function enable(id)
               {
               	//alert('hiiiii'); 
               	document.getElementById("nooftappings_"+id).disabled =false;
           		document.getElementById("pinpole1_"+id).disabled = false;
           		document.getElementById("switchdev1_"+id).disabled = false;
           		document.getElementById("pinpole2_"+id).disabled = false;
           		document.getElementById("switchdev2_"+id).disabled = false;
           		document.getElementById("pinpole3_"+id).disabled = false;
           		document.getElementById("switchdev3_"+id).disabled = false;
           		document.getElementById("noofmissingparts_"+id).disabled = false;
           		document.getElementById("nofflashoversets_"+id).disabled = false;
           		document.getElementById("wayleavestatus_"+id).disabled = false;
           		document.getElementById("baseconcretestatus_"+id).disabled = false;
           		document.getElementById("anticlimbingstatus_"+id).disabled = false;
           		document.getElementById("conductorstatus_"+id).disabled = false;
           		document.getElementById("jumperstatus_"+id).disabled = false;
           		document.getElementById("earthconductorstatus_"+id).disabled = false;
           		document.getElementById("attentionstatus_"+id).disabled = false;
           		document.getElementById("fungussetno_"+id).disabled = false;
           		document.getElementById("wpinset_"+id).disabled = false;
           		document.getElementById("endfittingset_"+id).disabled = false;
           		document.getElementById("towerspecial_"+id).disabled = false;
           		//document.getElementById("ludt_"+id).disabled = false;
           		document.getElementById("maintenancedate_"+id).disabled = false; 
           		document.getElementById("status_"+id).disabled = false;
           		document.getElementById("approvalLevel_"+id).disabled = false;
           		document.getElementById("hotpossible_"+id).disabled = false;
           		document.getElementById("legpainting_"+id).disabled = false;
           		
               }
               
              function save(id) 
               {
           	 // alert('hiiiii'); 
           	  
           	//var conceptCycle = $('#cycle').find(":selected").text();
         		//var conceptCycleValue = $('#cycle').find(":selected").attr("value");
           	  var conceptCycleValue = document.getElementById("cycleno_"+id).value;
           		
         		//alert('hiiiii'+conceptCycle);
        		//alert('hiiiii'+conceptCycleValue);

         	     
       		 
           	  var nooftappings = document.getElementById("nooftappings_"+id).value;
           	// alert('hiiiii'+nooftappings);
           	 var pinpole1 = document.getElementById("pinpole1_"+id).value;
             		//alert('hiiiii'+pinpole1); 
           	 var switchdev1 = document.getElementById("switchdev1_"+id).value;
           	 // alert('hiiiii'+switchdev1); 
           	 var pinpole2 = document.getElementById("pinpole2_"+id).value;
           	  // alert('hiiiii'+pinpole2); 
           	 var switchdev2 = document.getElementById("switchdev2_"+id).value;
           	  // alert('hiiiii'+switchdev2); 
           	 var pinpole3 = document.getElementById("pinpole3_"+id).value;
           	 //  alert('hiiiii'+pinpole3); 
           	 var switchdev3 = document.getElementById("switchdev3_"+id).value;
           	 //  alert('hiiiii'+switchdev3);
           	 var noofmissingparts = document.getElementById("noofmissingparts_"+id).value;
           	  //alert('hiiiii'+noofmissingparts); 
           	 var nofflashoversets = document.getElementById("nofflashoversets_"+id).value;
           	 // alert('hiiiii'+nofflashoversets); 
           	 var wayleavestatus = document.getElementById("wayleavestatus_"+id).value;
           	 // alert('hiiiii'+wayleavestatus); 
           	 var baseconcretestatus = document.getElementById("baseconcretestatus_"+id).value;
           	 // alert('hiiiii'+baseconcretestatus); 
           	 var anticlimbingstatus = document.getElementById("anticlimbingstatus_"+id).value;
           	 // alert('hiiiii'+anticlimbingstatus); 
           	 var conductorstatus = document.getElementById("conductorstatus_"+id).value;
           	 // alert('hiiiii'+conductorstatus);
           	 var jumperstatus = document.getElementById("jumperstatus_"+id).value;
           	  //alert('hiiiii'+jumperstatus);
           	 var earthconductorstatus = document.getElementById("earthconductorstatus_"+id).value;
           	  //alert('hiiiii'+earthconductorstatus);
           	 var attentionstatus = document.getElementById("attentionstatus_"+id).value;
           	  //alert('hiiiii'+attentionstatus); 
           	 var fungussetno = document.getElementById("fungussetno_"+id).value;
           	 // alert('hiiiii'+fungussetno);
           	 var wpinset = document.getElementById("wpinset_"+id).value;
           	 // alert('hiiiii'+wpinset); 
           	 var endfittingset = document.getElementById("endfittingset_"+id).value;
           	 // alert('hiiiii'+endfittingset); 
           	 var towerspecial = document.getElementById("towerspecial_"+id).value;
           	  //alert('hiiiii'+towerspecial);
               // var ludt = document.getElementById("ludt_"+id).value;
               var ludt = '2019-02-25';
               
           	  //alert('hiiiii'+ludt); 
           	 var maintenancedate = document.getElementById("maintenancedate_"+id).value;
           	  //alert('hiiiii'+maintenancedate); 
           	 var status = document.getElementById("status_"+id).value;
           	 // alert('hiiiiii' +status); 
           	 var approvalLevel = document.getElementById("approvalLevel_"+id).value;
           	  // alert('hiiiiii' +approvalLevel);  
           	   var hotPossible = document.getElementById("hotpossible_"+id).value;
           	   var legpainting = document.getElementById("legpainting_" + id).value;
       			
           	  /*  alert( "id: " + id + " / nooftappings: " + nooftappings + " / pinpole1: " + pinpole1 + " / switchdev1: " + switchdev1 +
           			   " / pinpole2: " +pinpole2 + " / switchdev2: " + switchdev2 + " / pinpole3: " + pinpole3 + " / switchdev3: " + switchdev3 +
           			   " / noofmissingparts: " + noofmissingparts + " / nofflashoversets: " + nofflashoversets + " / wayleavestatus: " + wayleavestatus + 
           			   " / baseconcretestatus: " + baseconcretestatus + " / anticlimbingstatus: " + anticlimbingstatus + " / conductorstatus: " + conductorstatus + " / jumperstatus: " + jumperstatus
           			   + " / earthconductorstatus: " + earthconductorstatus+ " / attentionstatus: " + attentionstatus+ " / fungussetno: " + fungussetno+ " / wpinset: " + wpinset+ " / endfittingset: " + endfittingset
           			   + " / towerspecial: " + towerspecial+ " / ludt: " + ludt+ " / maintenancedate: " + maintenancedate+ " / status: " + status); */
            	 
            /*  var url = "/MMS/updateTowerMaintence/"+conceptCycleValue+"/"+id+"/"+nooftappings+"/"+pinpole1+"/"+switchdev1+"/"+pinpole2+"/"+
           	   switchdev2+"/"+pinpole3+"/"+switchdev3+"/"+noofmissingparts+"/"+nofflashoversets+"/"+wayleavestatus+"/"+baseconcretestatus+"/"+
           	   anticlimbingstatus+"/"+conductorstatus+"/"+jumperstatus+"/"+earthconductorstatus+"/"+
           	   attentionstatus+"/"+ fungussetno+"/"+ wpinset+"/"+ endfittingset+"/"+towerspecial+"/"+ludt+"/"
           	   +maintenancedate+"/"+status+"/"+approvalLevel+"/"+ hotPossible + "/" +legpainting+"/";
            */			  
            	
            
            var url = "/MMS/updateTowerMaintenceN?visitid=" + conceptCycleValue + "&towerid=" + id
        	+ "&nooftappings=" + encodeURIComponent(nooftappings) + "&pinpole1=" + encodeURIComponent(pinpole1) + "&switchdev1=" + encodeURIComponent(switchdev1) + "&pinpole2="
        	+ encodeURIComponent(pinpole2) + "&switchdev2=" + encodeURIComponent(switchdev2) + "&pinpole3=" + encodeURIComponent(pinpole3) + "&switchdev3="
        	+ encodeURIComponent(switchdev3) + "&noofmissingparts=" + encodeURIComponent(noofmissingparts) + "&nofflashoversets=" + encodeURIComponent(nofflashoversets)
        	+ "&wayleavestatus=" + encodeURIComponent(wayleavestatus) + "&baseconcretestatus=" + encodeURIComponent(baseconcretestatus) + "&anticlimbingstatus="
        	+ encodeURIComponent(anticlimbingstatus) + "&conductorstatus=" + encodeURIComponent(conductorstatus) + "&jumperstatus="
        	+ encodeURIComponent(jumperstatus) + "&earthconductorstatus=" + encodeURIComponent(earthconductorstatus) + "&attentionstatus="
        	+ encodeURIComponent(attentionstatus) + "&fungussetno=" + encodeURIComponent(fungussetno) + "&wpinset=" + encodeURIComponent(wpinset) + "&endfittingset="
        	+ encodeURIComponent(endfittingset) + "&towerspecial=" + encodeURIComponent(towerspecial) + "&ludt=" + encodeURIComponent(ludt) + "&maintenancedate="
        	+ encodeURIComponent(maintenancedate) + "&status=" +encodeURIComponent(status) + "&approvalLevel="+ encodeURIComponent(approvalLevel) + "&hotpossible=" + encodeURIComponent(hotPossible) + "&legPainting=" +encodeURIComponent(legpainting);

           			 
            
           // public @ResponseBody void updateTowerMaintenceN(HttpServletRequest request,@RequestParam("visitid") String visitid,@RequestParam("towerid") String towerid,@RequestParam("nooftappings") String nooftappings,@RequestParam("pinpole1") String pinpole1,@RequestParam("switchdev1") String switchdev1,
       	//		 @RequestParam("pinpole2") String pinpole2,@RequestParam("switchdev2") String switchdev2,@RequestParam("pinpole3") String pinpole3,
       	//		 @RequestParam("switchdev3") String switchdev3,@RequestParam("noofmissingparts") String noofmissingparts,@RequestParam("nofflashoversets") String nofflashoversets,@RequestParam("wayleavestatus") String wayleavestatus,@RequestParam("baseconcretestatus") String baseconcretestatus,@RequestParam("anticlimbingstatus") String anticlimbingstatus,@RequestParam("conductorstatus") String conductorstatus,@RequestParam("jumperstatus")
       	// 		String jumperstatus,@RequestParam("earthconductorstatus") String earthconductorstatus,@RequestParam("attentionstatus") String attentionstatus,@RequestParam("fungussetno") String fungussetno,
       	// 		@RequestParam("wpinset") String wpinset,@RequestParam("endfittingset") String endfittingset,@RequestParam("towerspecial") String towerspecial,@RequestParam("ludt") String ludt,@RequestParam("maintenancedate") String maintenancedate,@PathVariable("status") String status,@RequestParam("approvalLevel") String approvalLevel,@RequestParam("hotpossible") String hotpossible,@RequestParam("legPainting") String legPainting) {


            	  //alert('hiiiii456' +url);
           	   
                   $.ajax({
                   	type: "GET",
                       url : url,
                       success : function(response) {
                           alert("Tower Maintence updated succesfully...");
                           console.log(response);
                           window.location.reload();
                           disable(id);
                       } 
                });
           
       			
       		}
               
       	
       	function ConfirmActivate(comid) {

       		alert("hiiii");
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
       						var slctSubcat = $('#line'), option = "<option value='-1'>ALL</option>";
       						slctSubcat.empty();
       						for (var i = 0; i < data.length; i++) {
       							option = option
       									+ "<option value='"+data[i].id + "'>"
       									+ data[i].lineName + "</option>";
       						}
       						slctSubcat.append(option);

       						//alert("response.towerNo" + data);	
       					}
       				});

       	}
       	
       	 function sendForValidation()
       	    {
       	       
       			var province = $( '#province' ).find( ":selected" ).attr( "value" );	
       	        var area = $( '#area' ).find( ":selected" ).attr( "value" );
       			var line = $( '#line' ).find( ":selected" ).attr( "value" );
       			var conceptCycleValue = $('#cycle').find(":selected").attr("value");
       			
       			//alert("cycle: " + conceptCycleValue + "province: " + province + ",  area: " + area + "  ,line: " + line);
       			
       	        var url = "/MMS/updateTMStatus/" + province + "/" + area + "/" + line +"/" + conceptCycleValue +"/";

       			//alert("url :"+url );
       	        $.ajax( {
       	            type: "GET",
       	            url: url,
       	            data : {},
       				contentType : "application/json; charset=utf-8",
       				success: function(data)
       	            {
       	                alert( "Succesfully approved" );
       	                console.log( data );
       	                window.location.reload();
       	                //disable( id );
       	            }
       	        } );
       	        alert("Tower Maintenance succesfully approved...");
       	    }

       	
       	 function sendNotification()
       	    {
       	       
       			var province = $( '#province' ).find( ":selected" ).attr( "value" );	
       	        var area = $( '#area' ).find( ":selected" ).attr( "value" );
       			var line = $( '#line' ).find( ":selected" ).attr( "value" );
       			var conceptCycleValue = $('#cycle').find(":selected").attr("value");
       			
       			//alert("cycle: " + conceptCycleValue + "province: " + province + ",  area: " + area + "  ,line: " + line);
       			
       	        var url = "/MMS/sendNotification/" + province + "/" + area + "/" + line +"/" + conceptCycleValue +"/";

       			//alert("url :"+url );
       	        $.ajax( {
       	            type: "GET",
       	            url: url,
       	            data : {},
       				contentType : "application/json; charset=utf-8",
       				success: function(data)
       	            {
       	                alert("Email-SMS is succesfully sent to relevent Area Engineer " );
       	                console.log( data );
       	                //window.location.reload();
       	                //disable( id );
       	            }
       	        } );
       	        //alert("Tower Maintenance succesfully approved...");
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
					<div class="table-responsive">
										<table class="table table-responsive" id="tblProvinces">

											<thead>

											</thead>
											<tbody>
												<form:form method="post" action="editTMnewS"
													modelAttribute="model">
													<input type="hidden" name="mode" value="${model.mode}" />
													
													<c:if test="${not empty model.error}">
										<tr>
										<td colspan="2" class="msgSuccess" align="center">
										
									<div class="msgSuccess">
										<c:out value="${model.error}"></c:out>
									</div>
								
						</tr>	
						</c:if>
													<%-- <c:out value="${model.mode}"></c:out>
													 --%><table class="table table-responsive" id="tblProvinces">

														<tr>
															<td width="30%" style="text-align: left">Province</td>
															<td width="70%" style="text-align: left"><form:select
																	id="province" path="glcompmobj.compId"
																	onchange="findArea()" 
																	style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.provinceList}" />
															</form:select></td>

														</tr>
														<tr>
															<td width="30%" style="text-align: left">Area</td>
															<td width="70%" style="text-align: left"><form:select
																	id="area" path="gldeptobj.deptId" onchange="getLine()" 
																	style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.areaList}" />
																</form:select></td>

														</tr>
														<tr>
															<td width="30%" style="text-align: left">Line</td>
															<td width="70%" style="text-align: left"><form:select
																	id="line" path="line.id" onchange="" 
																	style="width:50%; background-color: #FFFFF; border-radius: 5px;">

																	<form:option value="-1" label="ALL" />
																	<form:options items="${model.lineListLong}" />
																</form:select></td>
														</tr>
														
														
														
														<td width="30%" style="text-align: left">Cycle</td>
															<td width="70%" style="text-align: left"><form:select
																	id="cycle" path="cycleObj.id.cycleId" onchange="" style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.cycleList}" />

																	
																</form:select></td>
														</tr>
														
														
														
														
														
														
        														
        												
														<tr>
														<td style="text-align: left"><a
																href="">
																<input
																	class="button2" type="submit"
																	name="actionButton" value="GO"></input>
																
												
														</a>
														</td>
														
														
														
														
															
													
														</tr>
														
													</table>
													
													
													
													
                                                      <!--   <div id="table-scroll" class="table-scroll"> 
                                                        
													  </div> -->
													  
													  
													  
													<tr>
<!-- edited anushka 2019-01-08--------------------------------------------------------------------------------------- -->
														<td>
															<!--<button type='button' class='button2'
																onClick='javascript:editAll("${model.stringOfMaintenance}")'>Edit
																All</button>-->
														</td>

														<td>
															<!--<button type='button' class='button2' class='btn btn-success' onClick='javascript:saveAll()'>Update All</button>-->
														</td>
														
														</form:form>
												
														
														
														
 												
												
											
					
	<!--  divide-->				
<div class="main">
<div class="upnew">
            	<div class="wrapper">
			<div class = "form">
			<form id = "register" method="post">
    <div class="table-responsive" >
    <div class="table-scroll">
    <table id= "myTable" class="display table" width="100%">
        <thead>  
          <tr style="width:2%" class="heading">  
            <th class="text-center">No</th>
                                                             <th>Cycle No</th>
															
															<th>Missing Parts</th>
															<th>Flash Over Sets</th>
															<th>Way leaving Status</th>
															<th>Base Concrete Status</th>
															<th>Anti Climbing Status</th>
															<th>Conductor Condition</th>
															<th>Jumper Condition</th>
															<th>Earth Conductor Condition</th>
															<th>Maintenance Attention</th>
															<th>Funguss Set No</th>
															<th>WPIN set</th>
															<th>End Fitting set</th>
															<th>Special Observations</th>
															<!-- <th class="text-center">LUTD</th>
															 --><th>Inspected Date</th>
															<th>Hot Possible</th>
															<th>Leg Painting</th>
															<th>Tappings</th>
															<th>No Of Pinpoles 1 </th>
															<th>Switching Device 1</th>
															<th>No Of Pinpoles 2 </th>
															<th>Switching Device 2</th>
															<th>No Of Pinpoles 3 </th>
															<th>Switching Device 3</th>
															
															<th>Status</th>
															<th>Approval Level</th>
 															<th>Edit</th>
                                                            <th>Save</th> 
          </tr>  
        </thead>  
        <tbody>  
        <c:set var="count" value="0" scope="page" />
															
											           <c:forEach var="mmsTxtMnt" items="${model.mmsTxtMntList}"  varStatus="status">
														<tr>
														  <%-- <td  style="text-align:center"   >${status.count}</td> --%>
														  <th><input type="text" name = "hotLineMnt" id="hotLineMnt_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.hotLineMnt}" class="form-control" disabled></th>
														    <td><input type="text" name = "" id="cycleno_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.id.visitid}" class="form-control" disabled></td>
														    
															<td><input type="number" id="noofmissingparts_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.noofmissingparts}" class="form-control" disabled></td>
                                                            <td><input type="number" id="nofflashoversets_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.nofflashoversets}" class="form-control" disabled></td>
                                                            <td><input type="text" id="wayleavestatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.wayleavestatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="baseconcretestatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.baseconcretestatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="anticlimbingstatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.anticlimbingstatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="conductorstatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.conductorstatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="jumperstatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.jumperstatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="earthconductorstatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.earthconductorstatus}" class="form-control" disabled></td>
                                                            <td><input type="text" id="attentionstatus_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.attentionstatus}" class="form-control" disabled></td>
                                                            <td><input type="number" id="fungussetno_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.fungussetno}" class="form-control" disabled></td>
                                                            <td><input type="number" id="wpinset_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.wpinset}" class="form-control" disabled></td>
                                                            <td><input type="number" id="endfittingset_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.endfittingset}" class="form-control" disabled></td>
                                                            <td><input type="text" id="towerspecial_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.towerspecial}" class="form-control" disabled></td>
                                                           <%--  <td><input type="text" id="ludt_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.ludt}" class="form-control" disabled></td>
                                                            --%> <td><input type="text" id="maintenancedate_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.insDate}" class="form-control" disabled></td>
														<%-- <td><input type="number" id="hotpossible_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.hotpossible}" class="form-control" disabled></td>
														 --%><td><select id="hotpossible_${mmsTxtMnt.id.towerid}" class="form-control"  disabled>
                                                                                <c:choose>
                                                                                <c:when test="${mmsTxtMnt.hotpossible==1}">
                                                                                        <option value="${mmsTxtMnt.hotpossible}" selected="selected">Possible</option>
                                                                                             <option value="0">Impossible</option>
                                                                                    </c:when>
                                                                                
                                                                                <c:otherwise>
                                                                                       <option value="${mmsTxtMnt.hotpossible}" selected="selected">Impossible</option>
                                                                                             <option value="1">Possible</option>
                                                                                        
                                                                                    </c:otherwise>
                                                                                
                                                                                
                                                                                
                                                                                
                                                               </c:choose>
                                                                                
                                                                                <%-- <option value="${mmsTxtMnt.hotpossible}" selected="selected">${mmsTxtMnt.hotpossible}</option>
                                                                                <option value="1">Possible</option>
                                                                                <option value="0">Impossible</option> --%>
                                                                            </select>
                                                            </td>
                                                             <td><select id="legpainting_${mmsTxtMnt.id.towerid}" class="form-control"  disabled>
                                                                                <c:choose>
                                                                                <c:when test="${mmsTxtMnt.legPainting=='Yes'}">
                                                                                        <option value="${mmsTxtMnt.legPainting}" selected="selected">Yes</option>
                                                                                             <option value="No">No</option>
                                                                                             
                                                                                    </c:when>
                                                                                
                                                                                <c:otherwise>
                                                                                       <option value="${mmsTxtMnt.legPainting}" selected="selected">No</option>
                                                                                             <option value="Yes">Yes</option>
                                                                                        
                                                                                    </c:otherwise>
                                                                                
                                                                                
                                                                                
                                                                                
                                                               </c:choose>
                                                                                
                                                                                <%-- <option value="${mmsTxtMnt.hotpossible}" selected="selected">${mmsTxtMnt.hotpossible}</option>
                                                                                <option value="1">Possible</option>
                                                                                <option value="0">Impossible</option> --%>
                                                                            </select>
                                                            </td>
														 
                                                            
                                                            <td><input type="number" id="nooftappings_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.nooftappings}" class="form-control" disabled></td>
														    
													
														   <td><input type="number" id="pinpole1_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.pinpole1}" class="form-control" disabled></td>
														   
														   		
														   <td><input type="text" id="switchdev1_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.switchdev1}" class="form-control" disabled></td>
                                                           <td><input type="number" id="pinpole2_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.pinpole2}" class="form-control" disabled></td>
                                                           <td><input type="text" id="switchdev2_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.switchdev2}" class="form-control" disabled></td>
                                                       		<td><input type="number" id="pinpole3_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.pinpole3}" class="form-control" disabled></td>
                                                            <td><input type="text" id="switchdev3_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.switchdev3}" class="form-control" disabled></td>
                                                      
														  <td><select id="status_${mmsTxtMnt.id.towerid}" class="form-control" disabled>
											                   <c:choose>
                                                                                    <c:when test="${sessionScope.loggedUserRole=='DEO'}">
                                                                                        <option value="${mmsTxtMnt.status}"
                                                                                            selected="selected">In Bulk</option>
                                                                                             <option value="3">Send for Validation</option>
                                                                                             <option value="0">Inactive</option>
											                			
                                                                                    </c:when>

                                                                                    <c:when test="${sessionScope.loggedUserRole=='ES'}">
                                                                                        <option value="${mmsTxtMnt.status}"
                                                                                            selected="selected">Pending</option>
                                                                                             <option value="4">Send for Approval</option>
                                                                                             <option value="0">Inactive</option>
											                			
                                                                                    </c:when>

                                                                                    <c:when test="${sessionScope.loggedUserRole=='EE'}">
                                                                                          <option value="${mmsTxtMnt.status}"
                                                                                            selected="selected">Pending</option>
                                                                                             <option value="1">Approve</option>
                                                                                             <option value="0">Inactive</option>
											                								<option value="2">Keep in Bulk</option>
                                                                                    </c:when>


                                                                                    <c:otherwise>
                                                                                        <option value="${mmsTxtMnt.status}"
                                                                                            selected="selected">Not Allowed</option>
                                                                                      
                                                                                    </c:otherwise>

                                                                                </c:choose>
											                </select ></td>  
											                <%-- <td><input type="text" id="approvalLevel_${mmsTxtMnt.id.towerid}" value="${mmsTxtMnt.approvalLevel}" class="form-control" disabled></td> --%>
											            <td><select id="approvalLevel_${mmsTxtMnt.id.towerid}" class="form-control"
                                                                                disabled>
                                                                                <option value="${mmsTxtMnt.approvalLevel}" selected="selected">${mmsTxtMnt.approvalLevel}</option>
                                                                                <option value="60041ES1">60041ES1</option>
                                                                                <option value="60041ES2">60041ES2</option>
                                                                            </select>
                                                                        </td>
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
														
														  <td><button type='button' class='btn btn-warning' onClick='LoadLineToEdit("${mmsTxtMnt.id.towerid}")'>Edit</button></td>  
														
														
											                 <td><button type='button' class='btn btn-success' onClick='javascript:save("${mmsTxtMnt.id.towerid}")'>Save</button></td> 
														
														</tr>
														
												 </c:forEach>
          
        </tbody>  
    </table>
    </div>
    </div>
</form>
</div>
</div>
</div>
</div>
<td colspan="2"><c:if test="${userType =='DEO'}">

															</c:if> <input type="hidden" name="actionButton" value="" /> <c:choose>
																<c:when test="${sessionScope.loggedUserRole=='DEO'}">
																	<input id="pivFormBtn" class="btn btn-success"
																		type="submit" name="actionButton"
																		value="Send All for Validation"
																		onclick="sendForValidation()"></input>

																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='EE'}">
																	<input id="pivFormBtn" class="btn btn-success"
																		type="submit" name="actionButton" value="Approve"
																		onclick="sendForValidation()"></input>
																		<input id="pivFormBtn" class="btn btn-success"
																		type="submit" name="actionButton" value="Send Notification"
																		onclick="sendNotification()"></input>
																		

																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='ES'}">
																	<input id="pivFormBtn" class="button5"
																		type="submit" name="actionButton"
																		value="Send All for Approval"
																		onclick="sendForValidation()"></input>

																</c:when>
																<c:otherwise>

																</c:otherwise>
															</c:choose></td>
</tbody>
										</table>
					</div>




<div id ="buttons">
<button type='button' class='button2'
onClick='javascript:editAll("${model.stringOfMaintenance}")'>Edit All</button>
<button type='button' class='button2' class='btn btn-success' onClick='javascript:saveAll()'>Update All</button></div>
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
           $('#myTable').DataTable({
               searching : false,        	
        	   lengthMenu : [[100,150,200,250,-1],[100,150,200,250,"All"]]
           });
           

      </script>
		
	
	
	
</body>
</html>