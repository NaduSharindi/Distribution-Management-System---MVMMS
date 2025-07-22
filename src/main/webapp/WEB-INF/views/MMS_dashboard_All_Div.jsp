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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
google.charts.load('current', {'packages':['corechart', 'controls']});

//google.load('visualization', '1.0', {'packages':['corechart'], 'callback': drawDashboard});

      // Set a callback to run when the Google Visualization API is loaded.
     google.charts.setOnLoadCallback(drawDashboard);





function drawDashboard() {
    	  
	var strArea = $("#area").val();
	var strLine = $("#line").val();
	var strProvince = $("#province").val();
	var strDiv = $("#divison").val();
	//alert(strProvince);
	if(strLine === '-1'){
		strLine = 'NONE';
	}
	
    	  
    	  $.ajax({
  			type : 'GET',
  			url : "/MMS/MapNewSummary/" + strArea +"/" + strLine + "/" +strProvince +"/" +strDiv,
  			data : {},
  			contentType : "application/json; charset=utf-8",
  			success : function(result) {
  				
  				var datavaluefortable = new google.visualization.DataTable();
				datavaluefortable.addColumn('string', 'Name');
				
				datavaluefortable.addColumn('number', 'Tower');
				datavaluefortable.addColumn('number', 'Pole');
				datavaluefortable.addColumn('number', 'Gantry Bay');
				datavaluefortable.addColumn('number', 'GSS Bay');
				datavaluefortable.addColumn('number', 'Line Gantry');
				datavaluefortable.addColumn('number', 'Lattice Pole');
				datavaluefortable.addColumn('number', 'Switch');
				
				
				for (var i = 0; i < result.length; i++) {
						var data = result[i];
						//alert(data[3]);
						datavaluefortable.addRows([[data[3],data[4], data[5], data[6], data[7], data[8], data[9], data[10]]]);
						
				}
				
				
				
				/* var datavaluefortablenew = new google.visualization.DataTable();
				datavaluefortablenew.addColumn('string', 'Name');
				
				datavaluefortablenew.addColumn('number', 'Tower');
				datavaluefortablenew.addColumn('number', 'Pole');
				datavaluefortablenew.addColumn('number', 'Gantry Bay');
				datavaluefortablenew.addColumn('number', 'GSS Bay');
				datavaluefortablenew.addColumn('number', 'Line Gantry');
				datavaluefortablenew.addColumn('number', 'Lattice Pole');
				datavaluefortablenew.addColumn('number', 'Switch');
				datavaluefortablenew.addColumn('number', 'Line Length(Km)');
				
				
				for (var i = 0; i < result.length; i++) {
						var data = result[i];
						//alert(data[3]);
						datavaluefortablenew.addRows([[data[3],data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[1]]]);
						
				}
				 */
				
				
				
  				var datavalue = new google.visualization.DataTable();
  				datavalue.addColumn('string', 'Name');
  				datavalue.addColumn('number', 'Tower');
  				
  				for (var i = 0; i < result.length; i++) {
  						var data = result[i];
  						datavalue.addRows([[data[3], data[4]]]);
  				}
  				
  				/* var datavaluelength = new google.visualization.DataTable();
  				datavaluelength.addColumn('string', 'Name');
  				datavaluelength.addColumn('number', 'Line Length');
  				
  				for (var i = 0; i < result.length; i++) {
  						var data = result[i];
  						datavaluelength.addRows([[data[3], data[1]]]);
  				}
  				 */
  				
  				 
  			     // Create a dashboard.
  		        var dashboard = new google.visualization.Dashboard(
  		            document.getElementById('dashboard_div'));
 
  		         // Create a range slider, passing some options
  		        var donutRangeSlider = new google.visualization.ControlWrapper({
  		          'controlType': 'NumberRangeFilter',
  		          'containerId': 'filter_div',
  		          'options': {
  		        	'filterColumnLabel': 'Tower'
  		          }
  		        });
  		         

  		       /*  // Create a pie chart, passing some options
  		        var pieChart = new google.visualization.ChartWrapper({
  		          'chartType': 'PieChart',
  		          'containerId': 'chart_div',
  		          'options': {
  		            'height': 400,
  		            'pieSliceText': 'value',
  		            'legend': 'right'
  		          }
  		        });
  		        */ 
  		       var table = new google.visualization.ChartWrapper({
		          'chartType': 'Table',
		          'containerId': 'table_div',
		          'options': {
		        	  "title": "Competencies",

		            'height': 400,
		            'pieSliceText': 'value',
		            'legend': 'right'
		          }
		        });
 
  		    /* var bar = new google.visualization.ChartWrapper({
		          'chartType': 'ColumnChart',
		          'containerId': 'bar_div',
		          'options': {
		            'height': 400,
		            'pieSliceText': 'value',
		            'legend': 'right'
		          }
		        });
 */

  		        
  		      

  		        // Establish dependencies, declaring that 'filter' drives 'pieChart',
  		        // so that the pie chart will only display entries that are let through
  		        // given the chosen slider range.
  		        /* dashboard.bind(donutRangeSlider, pieChart);
  		      dashboard.bind(donutRangeSlider, table);
  		    dashboard.bind(donutRangeSlider, bar);
		     
  		        // Draw the dashboard.
  		        dashboard.draw(datavalue);
  		      dashboard.draw(datavaluefortable);
  		      */  
  		    dashboard.bind(donutRangeSlider, table);
  		    dashboard.draw(datavaluefortable);
  		    
  		    var options = {
			             title: 'Number of Towers in Tower Lines',
			             is3D : true,
			             pieSliceText: 'label',
			             tooltip :  {showColorCode: true},
					     'height' : 400
			         };
  		    
  		 /*  var optionslength = {
		             title: 'Line Length in Tower Line(Km)',
		             is3D : true,
		             pieSliceText: 'label',
		             tooltip :  {showColorCode: true},
				     'height' : 400
		         };
	     */
  		    
  		  /* var options1 = {
		             title: 'Number of Equipment in Tower Lines',
		             is3D : true,
		             pieSliceText: 'label',
		             tooltip :  {showColorCode: true},
				     'height' : 400
		         };
		 */
			     
			     		     
			    var chart = new google.visualization.PieChart(document.getElementById('pie_div1'));
			    chart.draw(datavalue, options);
			    
			    /* var chart = new google.visualization.PieChart(document.getElementById('pie_div2'));
			    chart.draw(datavaluelength, optionslength);
			     */
			    
			    var optionsnore = {
 			             title: 'Number of Equipment in Tower Line ',
 			             is3D : true,
 			             pieSliceText: 'label',
 			             tooltip :  {showColorCode: true},
 					     'height' : 400
 			         };
 			     
 			     		     
 			    var chart = new google.visualization.ColumnChart(document.getElementById('column_div1'));
 			    chart.draw(datavaluefortable, optionsnore);
 			    
 			   //var chart = new google.visualization.Table(document.getElementById('table_div1'));
			    //chart.draw(datavaluefortable, optionsnore);
			    
			    /* var chart1 = new google.visualization.Table(document.getElementById('table_div1'));
			    chart1.draw(datavaluefortable, options1);
			     */
			    /* var chart1 = new google.visualization.ColumnChart(document.getElementById('bar_div1'));
			    chart1.draw(datavaluefortable, options1);
			     */
  			    
  			}
  		});
    	  
    	  
    	  
    	  
    	  
    	 /*  $.ajax({
    			type : 'GET',
    			url : "/MMS/getApprovalListNew",
    			data : {},
    			contentType : "application/json; charset=utf-8",
    			success : function(result) {
    				var datavaluepie = new google.visualization.DataTable();
    				datavaluepie.addColumn('string', 'Unit Name');
    				datavaluepie.addColumn('number', 'No. Estimate');
    				datavaluepie.addColumn('string', 'Dept Id');
    				
    				for (var i = 0; i < result.length; i++) {
    						var data = result[i];
    						datavaluepie.addRows([[data[1], data[0],data[2]]]);
    				}
    				
    				 
    			     // Create a dashboard.
    		        var dashboard = new google.visualization.Dashboard(
    		            document.getElementById('dashboard_div'));

    		        // Create a range slider, passing some options
    		        var donutRangeSlider2 = new google.visualization.ControlWrapper({
    		          'controlType': 'CategoryFilter',
    		          'containerId': 'filter_div2',
    		          'options': {
    		        	'filterColumnLabel': 'Unit Name'
    		          }
    		        });

    		        // Create a pie chart, passing some options
    		        var pieChart = new google.visualization.ChartWrapper({
    		          'chartType': 'PieChart',
    		          'containerId': 'estapr_div',
    		          'options': {
    		            'width': 230,
    		            'height': 210,
    		            'is3D': true,
    		            'pieSliceText': 'value',
    		            'legend': 'right'
    		          }
    		        });
    		        
    		        dashboard.bind(donutRangeSlider2, pieChart);
    		        dashboard.draw(datavaluepie);
  		        	}
    		});
 
    	  
    	  
    	 $.ajax({
  			type : 'GET',
  			url : "/MMS/getApprovalListNew",
  			data : {},
  			contentType : "application/json; charset=utf-8",
  			success : function(result) {
  				var datavaluetable = new google.visualization.DataTable();
  				datavaluetable.addColumn('number', 'No. Estimate');
  				datavaluetable.addColumn('string', 'Unit Name');
  				datavaluetable.addColumn('string', 'Dept Id');
  				
  				for (var i = 0; i < result.length; i++) {
  						var data = result[i];
  						datavaluetable.addRows([[data[0], data[1],data[2]]]);
  				}
  				
  				// Create a dashboard.
  		        var dashboard = new google.visualization.Dashboard(
  		            document.getElementById('dashboard_div'));

  		        // Create a range slider, passing some options
  		        var donutRangeSlider2 = new google.visualization.ControlWrapper({
  		          'controlType': 'CategoryFilter',
  		          'containerId': 'filter_div2',
  		          'options': {
  		        	'filterColumnLabel': 'Unit Name'
  		          }
  		        });

  		        
  		        var table = new google.visualization.ChartWrapper({
  			          'chartType': 'Table',
  			          'containerId': 'estaprtable_div',
  			          'options': {
  			            'width': 230,
  			            'height': 210,
  			            'pieSliceText': 'value',
  			            'legend': 'right'
  			          }
  			        });
		        
  		        dashboard.bind(donutRangeSlider2, table);
  		        dashboard.draw(datavaluetable);
		        
  		        // Draw the dashboard.
  		         
  		        google.visualization.events.addListener(table, 'select', selectHandler);
  		        function selectHandler() {
		          //alert("hiii");
		          var selectedItem = table.getChart().getSelection()[0];
		          
		          if (selectedItem) {
		        	 // alert("hiii2");
		            var value = datavaluetable.getValue(selectedItem.row, 2);
		           // alert('The user selected ' + value);
		            
		            $.ajax({
		    			type : 'GET',
		    			url : "/MMS/getApprovalListByCostCenter/" +value+"/" ,
		    			data : {},
		    			contentType : "application/json; charset=utf-8",
		    			success : function(result) {
		    				var datavalue = new google.visualization.DataTable();
		    				datavalue.addColumn('string', 'Approve');
		    				
		    				datavalue.addColumn('string', 'Estimate No');
		    				datavalue.addColumn('string', 'Description');
		    				datavalue.addColumn('string', 'Dept Id');
		    				
		    				for (var i = 0; i < result.length; i++) {
		    						var data = result[i];
		    						datavalue.addRows([['<a href="LINK">Approve</a>'],[data[0], data[1],data[2]]]);
		    				}
		    				 
		    			     // Create a dashboard.
		    		        var dashboard = new google.visualization.Dashboard(
		    		            document.getElementById('dashboard_div'));

		    		        // Create a range slider, passing some options
		    		        var donutRangeSlider3 = new google.visualization.ControlWrapper({
		    		          'controlType': 'CategoryFilter',
		    		          'containerId': 'filter_div3',
		    		          'options': {
		    		        	'filterColumnLabel': 'Description'
		    		          }
		    		        });

		    		        
		    		        var table = new google.visualization.ChartWrapper({
		    			          'chartType': 'Table',
		    			          'containerId': 'estaprtabledetail_div',
		    			          'options': {
		    			            'width': 230,
		    			            'height': 210,
		    			            'allowHtml': true,
		    			            'pieSliceText': 'value',
		    			            'legend': 'right'
		    			          }
		    			        });


		    		        // Establish dependencies, declaring that 'filter' drives 'pieChart',
		    		        // so that the pie chart will only display entries that are let through
		    		        // given the chosen slider range.
		    		        dashboard.bind(donutRangeSlider3, table);

		    		        // Draw the dashboard.
		    		        dashboard.draw(datavalue);
		    		        
		    		        // The select handler. Call the chart's getSelection() method
		    		        function selectHandler() {
		    		        	//alert("hiii");
		    		          var selectedItem = table.getChart().getSelection()[0];
		    		          
		    		          if (selectedItem) {
		    		        	//  alert("hiii2");
		    		            var estimateNo = datavalue.getValue(selectedItem.row, 0);
		    		            var costCenterNo = datavalue.getValue(selectedItem.row, 2);
		    		            
		    		            //alert('This will open the pdf file later ' + estimateNo + " : " + costCenterNo);
		    		           // alert('costCenterNo ' + costCenterNo);
		    		            
		    		             
		    		            var url="downloadEstimate?estimateNo="+estimateNo+"&costCenter="+costCenterNo;
		    		    	    var width = 1100;
		    		    	    var height = 700;
		    		    	    var left = parseInt((screen.availWidth/2) - (width/2));
		    		    	    var top = parseInt((screen.availHeight/2) - (height/2));
		    		    	    var windowFeatures = "width=" + width + ",height=" + height + 
		    		    	    ",status,resizable,left=" + left + ",top=" + top +
		    		    	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
		    		    	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
		    		    	    //myWindow.document.write("<p>This is 'MsgWindow'. I am 200px wide and 100px tall!</p>");

		    		          }
		    		        }
		    		        google.visualization.events.addListener(table, 'select', selectHandler);


		    		        
		    			}
		    		});

		            
		            
		            
		            
		          }
		         }


  			    
  			    
  			}
  		});
 */    	  
    	  
    	  /* $.ajax({
    			type : 'GET',
    			url : "/MMS/getApprovalListDetail",
    			data : {},
    			contentType : "application/json; charset=utf-8",
    			success : function(result) {
    				var datavalue = new google.visualization.DataTable();
    				datavalue.addColumn('string', 'Estimate No');
    				datavalue.addColumn('string', 'Unit Name');
    				datavalue.addColumn('string', 'Dept Id');
    				
    				for (var i = 0; i < result.length; i++) {
    						var data = result[i];
    						datavalue.addRows([[data[0], data[1],data[2]]]);
    				}
    				 
    			     // Create a dashboard.
    		        var dashboard = new google.visualization.Dashboard(
    		            document.getElementById('dashboard_div'));

    		        // Create a range slider, passing some options
    		        var donutRangeSlider3 = new google.visualization.ControlWrapper({
    		          'controlType': 'CategoryFilter',
    		          'containerId': 'filter_div3',
    		          'options': {
    		        	'filterColumnLabel': 'Unit Name'
    		          }
    		        });

    		        
    		        var table = new google.visualization.ChartWrapper({
    			          'chartType': 'Table',
    			          'containerId': 'estaprtabledetail_div',
    			          'options': {
    			            'width': 230,
    			            'height': 210,
    			            'pieSliceText': 'value',
    			            'legend': 'right'
    			          }
    			        });


    		        // Establish dependencies, declaring that 'filter' drives 'pieChart',
    		        // so that the pie chart will only display entries that are let through
    		        // given the chosen slider range.
    		        dashboard.bind(donutRangeSlider3, table);

    		        // Draw the dashboard.
    		        dashboard.draw(datavalue);
    		        
    		        // The select handler. Call the chart's getSelection() method
    		        function selectHandler() {
    		        	alert("hiii");
    		          var selectedItem = table.getChart().getSelection()[0];
    		          
    		          if (selectedItem) {
    		        	  alert("hiii2");
    		            var value = datavalue.getValue(selectedItem.row, 0);
    		            alert('The user selected ' + value);
    		          }
    		        }

    		        
    		        
    		        
    		        google.visualization.events.addListener(table, 'select', selectHandler);


    		        
    			}
    		});
 */

    	  
    	      
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
		
		//var selectedValues = $("#mode").val();
		//alert(selectedValues);
		
		
		if(viewMode=='MAP'){
			allView();
		}else if(viewMode=='MAP2'){
			loadMapWithoutMnt();
		}/* else if(viewMode=='ALLASSET'){
			allAsset();
		} */else if(viewMode=='SUBSTATION'){
			substation();
		}else if(viewMode=='TRANSFORMER'){
			loadMapTransformer();
		}else if(viewMode=='MAP2SUBSTATION'){
			mvTowerLineSubstation();
		}else if(viewMode=='MAP2TRANSFORMER'){
			mvTowerLineTransformer();
		}else if(viewMode=='SUBSTATIONTRANSFORMER'){
			substationTransformer();
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
		}else if(viewMode=='MVPOLE'){
			loadmvPole();
		}else if(viewMode=='LVPOLE'){
			loadlvPole();
		}else if(viewMode=='INTVIEW'){
			loadIntView();
		}else{
			loadNetwork();
		}
		
	}
	
	function loadMapTransformer() {
		//alert('hiiiloadMap');
		var map = new google.maps.Map(document.getElementById("map_container"), {
          //center: new google.maps.LatLng(7.2665013,80.541458),
          center: new google.maps.LatLng(7.873054,80.771797),
          zoom: 12,
          gestureHandling: 'greedy',
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });

		var infoWindow = new google.maps.InfoWindow();
		var strArea = area.options[area.selectedIndex].value;
		var strDiv = divison.options[divison.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
		
		//variables for get the move location
		//alert('hiii: ' + strDiv + strProvince +strArea );
		
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + bounds );
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNewPCB/" + strDiv +"/" +strProvince+ "/" +strArea+ "/",
                data: {},
                contentType: "application/json; charset=utf-8",
                success : function(json){
                	//alert(json.length);
                	
                		for (var i = 0, length = json.length; i < length; i++) {
        					var data = json[i],
        						latLng = new google.maps.LatLng(data[1].gpsLatitude, data[1].gpsLongitude);
        						//alert('huuuuuuu'+ data[1].gpsLatitude);
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
								  /* if(data[0].supportType == 1){
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
    	            						title: "Click here to view details of Tower ID "+data[0].id
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
    	            						title: "Click here to view details of Tower ID "+data[0].id
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
    	            						title: "Click here to view details of Tower ID "+data[0].id,
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
    	            						title: "Click here to view details of Tower ID "+data[0].id,
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
    	            						title: "Click here to view details of Tower ID "+data[0].id,
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
										*/
								  if(data[2].pcbTestDataAroclor > 50){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						icon: '<c:url value="/resources/img/CEBImages/trred.png"/>',
    	            						
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    	            					});
								  }else{
										//alert("test13 : "+ data.area);
	            			 			var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_green.png'
	            						icon: '<c:url value="/resources/img/CEBImages/trgreen.png"/>'
    	            						
	            						//title: "Click here to view details of Tower ID "+data.equipmentId,
	            						//label: { color: '#FAF8F8', fontWeight: 'bold', fontSize: '14px', text: '' }
	            					});
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
        					(function(marker, data) {
									
								
//alert('' + data[0].supportType);
							/* 	var supType;
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
								"</table></div>";
 */								

	
        						google.maps.event.addListener(marker, "click", function(e) {

            						

        							infoWindow.setContent("<b>Tr number:  </b>"+
        								data[0].referenceNo+"</br>"+"<b>Location Description:</b>"+
        								data[1].locationDescription+"</br>"+"<b>SIN number : </b>"+
	            						data[0].referenceNo+"</br>"+"<b>Serial Number : </b>"+
	            						data[0].serialNo+"</br>"+"<b>kVA Rating :</b>"+
	            						data[0].capacity+"</br>");
	            							
	            							//infoWindow.setContent(data[0].referenceNo);
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
        
	function loadmvPole(){
		//alert("loadmvPole");
		var map = new google.maps.Map(document.getElementById("map_container"), {
	          //center: new google.maps.LatLng(7.2665013,80.541458),
	          center: new google.maps.LatLng(7.873054,80.771797),
	          zoom: 12,
	          gestureHandling: 'greedy',
	          mapTypeId: google.maps.MapTypeId.ROADMAP
	        });
		
		
		//var strArea = area.options[area.selectedIndex].value;
		var strArea = '440.00';
	    //alert("loadmvPole");
	    var infoWindow = new google.maps.InfoWindow();
		var bounds = new google.maps.LatLngBounds();
		$.ajax({
					type : 'GET',
					url : "/MMS/findMvPoleByArea/" + strArea + "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(json) {
						 //alert("success");
						 for (var i = 0, length = json.length; i < length; i++) {
								var data = json[i];
								
								//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
								latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
	         					bounds.extend(latLng);
	         					
	         					var marker = new google.maps.Marker({
	        						position: latLng,
	        						map: map,
	        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	        						//marker.setIcon(zoomIcons[map.getZoom()]);
	        						icon: '<c:url value="/resources/img/CEBImages/polemarkere.png"/>',
    	            				title: "Pole Name "+data.poleName + " Pole Number " + data.poleNo
	        					});
	         					
	         					(function(marker, data) {
	         						
	         						
	         						
	         						var poleTypeNew;
									if(data.poleType == 7){
										poleTypeNew = 'PS';
									}else if(data.poleType == 4){
										poleTypeNew = 'Tubular';
									}else if(data.poleType == 6){
										poleTypeNew = 'RC';
									}else if(data.poleType == 1){
										poleTypeNew = 'Wood';
									}else{
										poleTypeNew = 'NONE';
									} 
									
									
									
									var poleHeightNew;
									if(data.poleHeight == 1){
										poleHeightNew = '9m';
									}else if(data.poleHeight == 2){
										poleHeightNew = '10m';
									}else if(data.poleHeight == 3){
										poleHeightNew = '11m';
									}else if(data.poleHeight == 4){
										poleHeightNew = '13m';
									}else{
										poleHeightNew = 'NONE';
									} 
									
									
									var workingLoadNew;
									if(data.workingLoad == 6){
										workingLoadNew = '300 kg';
									}else if(data.workingLoad == 5){
										workingLoadNew = '1200 kg';
									}else if(data.workingLoad == 1){
										workingLoadNew = '225 kg';
									}else if(data.workingLoad == 3){
										workingLoadNew = '500 kg';
									}else if(data.workingLoad == 4){
										workingLoadNew = '850 kg';
									}else if(data.workingLoad == 2){
										workingLoadNew = '350 kg';
									}else{
										workingLoadNew = 'NONE';
									} 
									
									
									       						       
									

									var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='mvpolemodel'><tr></tr><tr><th>MV Pole Info</th></tr><tr><td>Pole Number : </td><td>"+
									data.poleNo+"</td></tr><tr><td>Pole Name : </td><td>"+
									data.poleName+"</td></tr><tr><td>Latitude :</td><td>"+
									data.gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
									data.gpsLongitude+"</td></tr><tr><td>Pole Height :  </td><td>"+
									poleHeightNew+"</td></tr><tr><td>Pole Type : </td><td>"+
									poleTypeNew+"</td></tr><tr><td>Working Load : </td><td>"+
									workingLoadNew+"</td></tr><tr><td>HV LV Combine Run : </td><td>"+
									data.hvLvCombineRun+"</td></tr><tr><td>No of 33KV Circuits : </td><td>"+
									data.noOf33Kvcircuits+"</td></tr><tr><td>No of 11KV Circuits : </td><td>"+
									data.noOf11Kvcircuits+"</td></tr><tr><td>No of LV cct : </td><td>"+
									
									data.noOfLvCct+"</td></tr><tr><td>33 KV Conductor cct - 1 :  </td><td>"+
									data.kv33ConductorCct1+"</td></tr><tr><td>33 KV Conductor cct - 2 : </td><td>"+
									data.kv33ConductorCct2+"</td></tr><tr><td>33 KV Conductor cct - 3 : </td><td>"+
									data.kv33ConductorCct3+"</td></tr><tr><td>11 KV Conductor cct - 1 : </td><td>"+
									data.kv11ConductorCct1+"</td></tr><tr><td>11 KV Conductor cct - 2 : </td><td>"+
									data.kv11ConductorCct2+"</td></tr><tr><td>11 KV Conductor cct - 3 : </td><td>"+
									data.kv11ConductorCct3+"</td></tr><tr><td>LV Conductor Type : </td><td>"+
									
									data.lvConductorType+"</td></tr><tr><td>Pin / Shackle :  </td><td>"+
									data.pinShackle+"</td></tr><tr><td>Street Light : </td><td>"+
									data.streetLight+"</td></tr><tr><td>No of Stay : </td><td>"+
									data.stay+"</td></tr><tr><td>No of Strut : </td><td>"+
									data.strut+"</td></tr><tr><td>Cross Arm : </td><td>"+
									data.crossArm+"</td></tr><tr><td>Earth Conductor : </td><td>"+
									data.earthConductor+"</td></tr><tr><td>Line End : </td><td>"+
									
									data.lineEnd+"</td></tr><tr><td>33 KV CCT 1 ph 1 :  </td><td>"+
									data.kv33Cct1Ph1+"</td></tr><tr><td>33 KV CCT 1 ph 2 : </td><td>"+
									data.kv33Cct1Ph2+"</td></tr><tr><td>33 KV CCT 1 ph 3 : </td><td>"+
									data.kv33Cct1Ph3+"</td></tr><tr><td>33 KV CCT 2 ph 1 : </td><td>"+
									data.kv33Cct2Ph1+"</td></tr><tr><td>33 KV CCT 2 ph 2 : </td><td>"+
									data.kv33Cct2Ph2+"</td></tr><tr><td>33 KV CCT 2 ph 3 : </td><td>"+
									data.kv33Cct2Ph3+"</td></tr><tr><td>33 KV CCT 3 ph 1 : </td><td>"+
									data.kv33Cct3Ph1+"</td></tr><tr><td>33 KV CCT 3 ph 2 : </td><td>"+
									data.kv33Cct3Ph2+"</td></tr><tr><td>33 KV CCT 3 ph 3 : </td><td>"+
									
									data.kv33Cct3Ph3+"</td></tr><tr><td>MV Switch : </td><td>"+
									data.mvSwitch+"</td></tr><tr><td>Transformer Type : </td><td>"+
									data.transformerType+"</td></tr><tr><td>Transformer Capacity : </td><td>"+
								    data.transformerCapacity+"</td></tr><tr><td></td><td>"+
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


	
	
	function substation(){
		//alert("gantryloc");
		var map = new google.maps.Map(document.getElementById("map_container"), {
	          //center: new google.maps.LatLng(7.2665013,80.541458),
	          center: new google.maps.LatLng(7.873054,80.771797),
	          zoom: 12,
	          gestureHandling: 'greedy',
	          mapTypeId: google.maps.MapTypeId.ROADMAP
	        });
		
		
		//var strArea = area.options[area.selectedIndex].value;
		var strArea = area.options[area.selectedIndex].value;
		//var strLine = line.options[line.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
		var strDiv = divison.options[divison.selectedIndex].value;
		
		
		
	    //alert("loadlvPole");
	    var infoWindow = new google.maps.InfoWindow();
		var bounds = new google.maps.LatLngBounds();
		$.ajax({
					type : 'GET',
					url : "/MMS/findGantryByAreaNewAllWithDivision/" + strProvince + "/" + strArea +"/" + strDiv,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(json) {
						 //alert("success");
						 for (var i = 0, length = json.length; i < length; i++) {
								var data = json[i];
								
								//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
								latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
	         					bounds.extend(latLng);
	         					
	         					var marker = new google.maps.Marker({
	        						position: latLng,
	        						map: map,
	        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	        						//marker.setIcon(zoomIcons[map.getZoom()]);
	        						icon: '<c:url value="/resources/img/CEBImages/gantry_blue.png"/>',
            						title: "ID "+data.id 
	        					});
	         					
var noOfCiur;
								
	         					
	         					(function(marker, data) {
	         						
	         						var eleType;
									if(data.gantryEleType == 1){
										eleType = 'SBB';
									}else {
										eleType = 'DBB';
									}
									
									var noOfSec = data.noOutBays / 2 ;
									
									var two ="2";
									var three ="3";
									var four = "4";
									var five = "5";
									
									var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
									"<tr><th>Gantry Info</th></tr>"+
									"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit(\"" + data.id + "\")'>Single Line Diagram</button></td></tr> "+
									"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg1(\"" + data.id + "\")'>DOC II</button></td></tr>"+
									"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg2(\"" + data.id + "\")'>DOC III</button></td></tr>"+
									"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg3(\"" + data.id + "\")'>DOC IV</button></td></tr>"+
									"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg4(\"" + data.id + "\")'>DOC V</button></td></tr>"+
									
									"<tr><td><button type='button' id='myBtn'  onClick='loadFeederNew(\"" + data.id + "\")'>Feeder Diagram</button></td></tr> "+
									
									"<tr><td>Name : </td><td>"+
									data.name+"</td></tr><tr><td>Code :</td><td>"+
									data.code+"</td></tr><tr><td>Electrical Type :  </td><td>"+
									eleType+"</td></tr><tr><td>No of sections :  </td><td>"+
									noOfSec+"</td></tr>"+
									"<tr><td><button type='button' id='myBtnGantry' data-toggle=modal data-target=#myModalGantry onClick='viewGantry(\"" + data.id + "\")'>More Info</button></td></tr> "+
									
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

	
	function substationTransformer(){
		//alert("gantryloc");
		var map = new google.maps.Map(document.getElementById("map_container"), {
	          //center: new google.maps.LatLng(7.2665013,80.541458),
	          center: new google.maps.LatLng(7.873054,80.771797),
	          zoom: 12,
	          gestureHandling: 'greedy',
	          mapTypeId: google.maps.MapTypeId.ROADMAP
	        });
		
		
		//var strArea = area.options[area.selectedIndex].value;
		var strArea = area.options[area.selectedIndex].value;
		//var strLine = line.options[line.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
		var strDiv = divison.options[divison.selectedIndex].value;
		
		
		
	    //alert("loadlvPole");
	    var infoWindow = new google.maps.InfoWindow();
		var bounds = new google.maps.LatLngBounds();
		$.ajax({
					type : 'GET',
					url : "/MMS/findGantryByAreaNewAllWithDivision/" + strProvince + "/" + strArea +"/" + strDiv,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(json) {
						 //alert("success");
						 for (var i = 0, length = json.length; i < length; i++) {
								var data = json[i];
								
								//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
								latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
	         					bounds.extend(latLng);
	         					
	         					var marker = new google.maps.Marker({
	        						position: latLng,
	        						map: map,
	        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	        						//marker.setIcon(zoomIcons[map.getZoom()]);
	        						icon: '<c:url value="/resources/img/CEBImages/gantry_blue.png"/>',
            						title: "ID "+data.id 
	        					});
	         					
var noOfCiur;
								
	         					
	         					(function(marker, data) {
	         						
	         						var eleType;
									if(data.gantryEleType == 1){
										eleType = 'SBB';
									}else {
										eleType = 'DBB';
									}
									
									var noOfSec = data.noOutBays / 2 ;
									
									var two ="2";
									var three ="3";
									var four = "4";
									var five = "5";
									
									var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
									"<tr><th>Gantry Info</th></tr>"+
									"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit(\"" + data.id + "\")'>Single Line Diagram</button></td></tr> "+
									"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg1(\"" + data.id + "\")'>DOC II</button></td></tr>"+
									"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg2(\"" + data.id + "\")'>DOC III</button></td></tr>"+
									"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg3(\"" + data.id + "\")'>DOC IV</button></td></tr>"+
									"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg4(\"" + data.id + "\")'>DOC V</button></td></tr>"+
									
									"<tr><td><button type='button' id='myBtn'  onClick='loadFeederNew(\"" + data.id + "\")'>Feeder Diagram</button></td></tr> "+
									
									"<tr><td>Name : </td><td>"+
									data.name+"</td></tr><tr><td>Code :</td><td>"+
									data.code+"</td></tr><tr><td>Electrical Type :  </td><td>"+
									eleType+"</td></tr><tr><td>No of sections :  </td><td>"+
									noOfSec+"</td></tr>"+
									"<tr><td><button type='button' id='myBtnGantry' data-toggle=modal data-target=#myModalGantry onClick='viewGantry(\"" + data.id + "\")'>More Info</button></td></tr> "+
									
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
		
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNewPCB/" + strDiv +"/" +strProvince+ "/" +strArea+ "/",
                data: {},
                contentType: "application/json; charset=utf-8",
                success : function(json){
                	//alert(json.length);
                	
                		for (var i = 0, length = json.length; i < length; i++) {
        					var data = json[i],
        						latLng = new google.maps.LatLng(data[1].gpsLatitude, data[1].gpsLongitude);
        						//alert('huuuuuuu'+ data[1].gpsLatitude);
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
								  /* if(data[0].supportType == 1){
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
    	            						title: "Click here to view details of Tower ID "+data[0].id
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
    	            						title: "Click here to view details of Tower ID "+data[0].id
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
    	            						title: "Click here to view details of Tower ID "+data[0].id,
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
    	            						title: "Click here to view details of Tower ID "+data[0].id,
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
    	            						title: "Click here to view details of Tower ID "+data[0].id,
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
										*/
								  if(data[2].pcbTestDataAroclor > 50){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						icon: '<c:url value="/resources/img/CEBImages/trred.png"/>',
    	            						
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    	            					});
								  }else{
										//alert("test13 : "+ data.area);
	            			 			var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_green.png'
	            						icon: '<c:url value="/resources/img/CEBImages/trgreen.png"/>'
    	            						
	            						//title: "Click here to view details of Tower ID "+data.equipmentId,
	            						//label: { color: '#FAF8F8', fontWeight: 'bold', fontSize: '14px', text: '' }
	            					});
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
        					(function(marker, data) {
									
								
//alert('' + data[0].supportType);
							/* 	var supType;
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
								"</table></div>";
 */								

	
        						google.maps.event.addListener(marker, "click", function(e) {

            						

        							infoWindow.setContent("<b>Tr number:  </b>"+
        								data[0].referenceNo+"</br>"+"<b>Location Description:</b>"+
        								data[1].locationDescription+"</br>"+"<b>SIN number : </b>"+
	            						data[0].referenceNo+"</br>"+"<b>Serial Number : </b>"+
	            						data[0].serialNo+"</br>"+"<b>kVA Rating :</b>"+
	            						data[0].capacity+"</br>");
	            							
	            							//infoWindow.setContent(data[0].referenceNo);
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

	
	function loadmvPole(){
		//alert("loadmvPole");
		var map = new google.maps.Map(document.getElementById("map_container"), {
	          //center: new google.maps.LatLng(7.2665013,80.541458),
	          center: new google.maps.LatLng(7.873054,80.771797),
	          zoom: 12,
	          gestureHandling: 'greedy',
	          mapTypeId: google.maps.MapTypeId.ROADMAP
	        });
		
		
		//var strArea = area.options[area.selectedIndex].value;
		var strArea = '440.00';
	    //alert("loadmvPole");
	    var infoWindow = new google.maps.InfoWindow();
		var bounds = new google.maps.LatLngBounds();
		$.ajax({
					type : 'GET',
					url : "/MMS/findMvPoleByArea/" + strArea + "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(json) {
						 //alert("success");
						 for (var i = 0, length = json.length; i < length; i++) {
								var data = json[i];
								
								//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
								latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
	         					bounds.extend(latLng);
	         					
	         					var marker = new google.maps.Marker({
	        						position: latLng,
	        						map: map,
	        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	        						//marker.setIcon(zoomIcons[map.getZoom()]);
	        						icon: '<c:url value="/resources/img/CEBImages/polemarkere.png"/>',
    	            				title: "Pole Name "+data.poleName + " Pole Number " + data.poleNo
	        					});
	         					
	         					(function(marker, data) {
	         						
	         						
	         						
	         						var poleTypeNew;
									if(data.poleType == 7){
										poleTypeNew = 'PS';
									}else if(data.poleType == 4){
										poleTypeNew = 'Tubular';
									}else if(data.poleType == 6){
										poleTypeNew = 'RC';
									}else if(data.poleType == 1){
										poleTypeNew = 'Wood';
									}else{
										poleTypeNew = 'NONE';
									} 
									
									
									
									var poleHeightNew;
									if(data.poleHeight == 1){
										poleHeightNew = '9m';
									}else if(data.poleHeight == 2){
										poleHeightNew = '10m';
									}else if(data.poleHeight == 3){
										poleHeightNew = '11m';
									}else if(data.poleHeight == 4){
										poleHeightNew = '13m';
									}else{
										poleHeightNew = 'NONE';
									} 
									
									
									var workingLoadNew;
									if(data.workingLoad == 6){
										workingLoadNew = '300 kg';
									}else if(data.workingLoad == 5){
										workingLoadNew = '1200 kg';
									}else if(data.workingLoad == 1){
										workingLoadNew = '225 kg';
									}else if(data.workingLoad == 3){
										workingLoadNew = '500 kg';
									}else if(data.workingLoad == 4){
										workingLoadNew = '850 kg';
									}else if(data.workingLoad == 2){
										workingLoadNew = '350 kg';
									}else{
										workingLoadNew = 'NONE';
									} 
									
									
									       						       
									

									var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='mvpolemodel'><tr></tr><tr><th>MV Pole Info</th></tr><tr><td>Pole Number : </td><td>"+
									data.poleNo+"</td></tr><tr><td>Pole Name : </td><td>"+
									data.poleName+"</td></tr><tr><td>Latitude :</td><td>"+
									data.gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
									data.gpsLongitude+"</td></tr><tr><td>Pole Height :  </td><td>"+
									poleHeightNew+"</td></tr><tr><td>Pole Type : </td><td>"+
									poleTypeNew+"</td></tr><tr><td>Working Load : </td><td>"+
									workingLoadNew+"</td></tr><tr><td>HV LV Combine Run : </td><td>"+
									data.hvLvCombineRun+"</td></tr><tr><td>No of 33KV Circuits : </td><td>"+
									data.noOf33Kvcircuits+"</td></tr><tr><td>No of 11KV Circuits : </td><td>"+
									data.noOf11Kvcircuits+"</td></tr><tr><td>No of LV cct : </td><td>"+
									
									data.noOfLvCct+"</td></tr><tr><td>33 KV Conductor cct - 1 :  </td><td>"+
									data.kv33ConductorCct1+"</td></tr><tr><td>33 KV Conductor cct - 2 : </td><td>"+
									data.kv33ConductorCct2+"</td></tr><tr><td>33 KV Conductor cct - 3 : </td><td>"+
									data.kv33ConductorCct3+"</td></tr><tr><td>11 KV Conductor cct - 1 : </td><td>"+
									data.kv11ConductorCct1+"</td></tr><tr><td>11 KV Conductor cct - 2 : </td><td>"+
									data.kv11ConductorCct2+"</td></tr><tr><td>11 KV Conductor cct - 3 : </td><td>"+
									data.kv11ConductorCct3+"</td></tr><tr><td>LV Conductor Type : </td><td>"+
									
									data.lvConductorType+"</td></tr><tr><td>Pin / Shackle :  </td><td>"+
									data.pinShackle+"</td></tr><tr><td>Street Light : </td><td>"+
									data.streetLight+"</td></tr><tr><td>No of Stay : </td><td>"+
									data.stay+"</td></tr><tr><td>No of Strut : </td><td>"+
									data.strut+"</td></tr><tr><td>Cross Arm : </td><td>"+
									data.crossArm+"</td></tr><tr><td>Earth Conductor : </td><td>"+
									data.earthConductor+"</td></tr><tr><td>Line End : </td><td>"+
									
									data.lineEnd+"</td></tr><tr><td>33 KV CCT 1 ph 1 :  </td><td>"+
									data.kv33Cct1Ph1+"</td></tr><tr><td>33 KV CCT 1 ph 2 : </td><td>"+
									data.kv33Cct1Ph2+"</td></tr><tr><td>33 KV CCT 1 ph 3 : </td><td>"+
									data.kv33Cct1Ph3+"</td></tr><tr><td>33 KV CCT 2 ph 1 : </td><td>"+
									data.kv33Cct2Ph1+"</td></tr><tr><td>33 KV CCT 2 ph 2 : </td><td>"+
									data.kv33Cct2Ph2+"</td></tr><tr><td>33 KV CCT 2 ph 3 : </td><td>"+
									data.kv33Cct2Ph3+"</td></tr><tr><td>33 KV CCT 3 ph 1 : </td><td>"+
									data.kv33Cct3Ph1+"</td></tr><tr><td>33 KV CCT 3 ph 2 : </td><td>"+
									data.kv33Cct3Ph2+"</td></tr><tr><td>33 KV CCT 3 ph 3 : </td><td>"+
									
									data.kv33Cct3Ph3+"</td></tr><tr><td>MV Switch : </td><td>"+
									data.mvSwitch+"</td></tr><tr><td>Transformer Type : </td><td>"+
									data.transformerType+"</td></tr><tr><td>Transformer Capacity : </td><td>"+
								    data.transformerCapacity+"</td></tr><tr><td></td><td>"+
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
		var strDiv = divison.options[divison.selectedIndex].value;
		//alert(strDiv);
		if(strLine === '-1'){
			strLine = 'NONE';
		}
		//variables for get the move location
		
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + bounds );
		$.ajax
        ({
        	type: 'GET',
            url: "/MMS/MapNewAll/" + strArea +"/" + strLine + "/" +strProvince +"/" + strDiv,
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
        						  
        						 /*  var markerImage = new google.maps.MarkerImage(
        								    '<c:url value="/resources/img/CEBImages/towermarkere.png"/>',
        								    new google.maps.Size(12,12), //size
        								    null, //origin
        								    null, //anchor
        								    new google.maps.Size(12,12) //scale
        								);
        						 */  
								  if(data[0].supportType == 1){
									  if(data[0].phmBranch == '600.41'){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkereLb.png"/>',
    	            						//icon: markerImage,
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower No "+data[0].towerNo
    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
    	            					});
										 
									  }else if(data[0].phmBranch == '596.00'){
										  var marker = new google.maps.Marker({
	    	            						position: latLng,
	    	            						map: map,
	    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkereYellow.png"/>',
	    	            						//icon: markerImage,
	    	            						//icon: {
	        					         // path: google.maps.SymbolPath.CIRCLE,
	        					         // scale: 1
	        					   // },
	    	            						title: "Click here to view details of Tower No "+data[0].towerNo
	    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
	    	            					});
										 
									  }
									  else if(data[0].phmBranch == '780.00'){
										  var marker = new google.maps.Marker({
	    	            						position: latLng,
	    	            						map: map,
	    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkereDg.png"/>',
	    	            						//icon: markerImage,
	    	            						//icon: {
	        					         // path: google.maps.SymbolPath.CIRCLE,
	        					         // scale: 1
	        					   // },
	    	            						title: "Click here to view details of Tower No "+data[0].towerNo
	    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
	    	            					});
										 
									  }
									  
									  else {
										  var marker = new google.maps.Marker({
	    	            						position: latLng,
	    	            						map: map,
	    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkereOrange.png"/>',
	    	            						//icon: markerImage,
	    	            						//icon: {
	        					         // path: google.maps.SymbolPath.CIRCLE,
	        					         // scale: 1
	        					   // },
	    	            						title: "Click here to view details of Tower No "+data[0].towerNo
	    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
	    	            					});
										 
									  }
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
								  
								  
								  /* if(!!navigator.geolocation) {
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
	 
        						/* google.maps.event.addListener(map, 'zoom_changed', function() {
        						    //zoomLevel = map.getZoom();
        						    //this is where you will do your icon height and width change. 

        							var pixelSizeAtZoom0 = 2; //the size of the icon at zoom level 0
        						    var maxPixelSize = 350; //restricts the maximum size of the icon, otherwise the browser will choke at higher zoom levels trying to scale an image to millions of pixels

        						    var zoom = map.getZoom();
        						    var relativePixelSize = Math.round(pixelSizeAtZoom0*Math.pow(2,zoom)); // use 2 to the power of current zoom to calculate relative pixel size.  Base of exponent is 2 because relative size should double every time you zoom in

        						    if(relativePixelSize > maxPixelSize) //restrict the maximum size of the icon
        						        relativePixelSize = maxPixelSize;

        						    //change the size of the icon
        						    marker.setIcon(
        						        new google.maps.MarkerImage(
        						            marker.getIcon().url, //marker's same icon graphic
        						            null,//size
        						            null,//origin
        						            null, //anchor
        						            new google.maps.Size(relativePixelSize, relativePixelSize) //changes the scale
        						        )
        						    );        
        						});
 */

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
	
	
	function mvTowerLineSubstation() {
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
		var strDiv = divison.options[divison.selectedIndex].value;
		//alert(strDiv);
		if(strLine === '-1'){
			strLine = 'NONE';
		}
		//variables for get the move location
		
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + bounds );
		$.ajax
        ({
        	type: 'GET',
            url: "/MMS/MapNewAll/" + strArea +"/" + strLine + "/" +strProvince +"/" + strDiv,
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
        						  
        						 /*  var markerImage = new google.maps.MarkerImage(
        								    '<c:url value="/resources/img/CEBImages/towermarkere.png"/>',
        								    new google.maps.Size(12,12), //size
        								    null, //origin
        								    null, //anchor
        								    new google.maps.Size(12,12) //scale
        								);
        						 */  
								  if(data[0].supportType == 1){
									  if(data[0].phmBranch == '600.41'){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkereLb.png"/>',
    	            						//icon: markerImage,
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower No "+data[0].towerNo
    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
    	            					});
										 
									  }else if(data[0].phmBranch == '596.00'){
										  var marker = new google.maps.Marker({
	    	            						position: latLng,
	    	            						map: map,
	    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkereYellow.png"/>',
	    	            						//icon: markerImage,
	    	            						//icon: {
	        					         // path: google.maps.SymbolPath.CIRCLE,
	        					         // scale: 1
	        					   // },
	    	            						title: "Click here to view details of Tower No "+data[0].towerNo
	    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
	    	            					});
										 
									  }
									  else if(data[0].phmBranch == '780.00'){
										  var marker = new google.maps.Marker({
	    	            						position: latLng,
	    	            						map: map,
	    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkereDg.png"/>',
	    	            						//icon: markerImage,
	    	            						//icon: {
	        					         // path: google.maps.SymbolPath.CIRCLE,
	        					         // scale: 1
	        					   // },
	    	            						title: "Click here to view details of Tower No "+data[0].towerNo
	    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
	    	            					});
										 
									  }
									  
									  else {
										  var marker = new google.maps.Marker({
	    	            						position: latLng,
	    	            						map: map,
	    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkereOrange.png"/>',
	    	            						//icon: markerImage,
	    	            						//icon: {
	        					         // path: google.maps.SymbolPath.CIRCLE,
	        					         // scale: 1
	        					   // },
	    	            						title: "Click here to view details of Tower No "+data[0].towerNo
	    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
	    	            					});
										 
									  }
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
								  
								  
								  /* if(!!navigator.geolocation) {
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
	 
        						/* google.maps.event.addListener(map, 'zoom_changed', function() {
        						    //zoomLevel = map.getZoom();
        						    //this is where you will do your icon height and width change. 

        							var pixelSizeAtZoom0 = 2; //the size of the icon at zoom level 0
        						    var maxPixelSize = 350; //restricts the maximum size of the icon, otherwise the browser will choke at higher zoom levels trying to scale an image to millions of pixels

        						    var zoom = map.getZoom();
        						    var relativePixelSize = Math.round(pixelSizeAtZoom0*Math.pow(2,zoom)); // use 2 to the power of current zoom to calculate relative pixel size.  Base of exponent is 2 because relative size should double every time you zoom in

        						    if(relativePixelSize > maxPixelSize) //restrict the maximum size of the icon
        						        relativePixelSize = maxPixelSize;

        						    //change the size of the icon
        						    marker.setIcon(
        						        new google.maps.MarkerImage(
        						            marker.getIcon().url, //marker's same icon graphic
        						            null,//size
        						            null,//origin
        						            null, //anchor
        						            new google.maps.Size(relativePixelSize, relativePixelSize) //changes the scale
        						        )
        						    );        
        						});
 */

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
		
		
		$.ajax({
			type : 'GET',
			url : "/MMS/findGantryByAreaNewAllWithDivision/" + strProvince + "/" + strArea +"/" + strDiv,
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(json) {
				 //alert("success");
				 for (var i = 0, length = json.length; i < length; i++) {
						var data = json[i];
						
						//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
						latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
     					bounds.extend(latLng);
     					
     					var marker = new google.maps.Marker({
    						position: latLng,
    						map: map,
    						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    						//marker.setIcon(zoomIcons[map.getZoom()]);
    						icon: '<c:url value="/resources/img/CEBImages/gantry_red.png"/>',
    						title: "ID "+data.id 
    					});
     					
var noOfCiur;
						
     					
     					(function(marker, data) {
     						
     						var eleType;
							if(data.gantryEleType == 1){
								eleType = 'SBB';
							}else {
								eleType = 'DBB';
							}
							
							var noOfSec = data.noOutBays / 2 ;
							
							var two ="2";
							var three ="3";
							var four = "4";
							var five = "5";
							
							var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
							"<tr><th>Gantry Info</th></tr>"+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit(\"" + data.id + "\")'>Single Line Diagram</button></td></tr> "+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg1(\"" + data.id + "\")'>DOC II</button></td></tr>"+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg2(\"" + data.id + "\")'>DOC III</button></td></tr>"+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg3(\"" + data.id + "\")'>DOC IV</button></td></tr>"+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg4(\"" + data.id + "\")'>DOC V</button></td></tr>"+
							
							"<tr><td><button type='button' id='myBtn'  onClick='loadFeederNew(\"" + data.id + "\")'>Feeder Diagram</button></td></tr> "+
							
							"<tr><td>Name : </td><td>"+
							data.name+"</td></tr><tr><td>Code :</td><td>"+
							data.code+"</td></tr><tr><td>Electrical Type :  </td><td>"+
							eleType+"</td></tr><tr><td>No of sections :  </td><td>"+
							noOfSec+"</td></tr>"+
							"<tr><td><button type='button' id='myBtnGantry' data-toggle=modal data-target=#myModalGantry onClick='viewGantry(\"" + data.id + "\")'>More Info</button></td></tr> "+
							
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

	
	
	function allView() {
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
		var strDiv = divison.options[divison.selectedIndex].value;
		//alert(strDiv);
		if(strLine === '-1'){
			strLine = 'NONE';
		}
		//variables for get the move location
		
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + bounds );
		$.ajax
        ({
        	type: 'GET',
            url: "/MMS/MapNewAll/" + strArea +"/" + strLine + "/" +strProvince +"/" + strDiv,
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
        						  
        						 /*  var markerImage = new google.maps.MarkerImage(
        								    '<c:url value="/resources/img/CEBImages/towermarkere.png"/>',
        								    new google.maps.Size(12,12), //size
        								    null, //origin
        								    null, //anchor
        								    new google.maps.Size(12,12) //scale
        								);
        						 */  
								  if(data[0].supportType == 1){
									  if(data[0].phmBranch == '600.41'){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkereLb.png"/>',
    	            						//icon: markerImage,
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower No "+data[0].towerNo
    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
    	            					});
										 
									  }else if(data[0].phmBranch == '596.00'){
										  var marker = new google.maps.Marker({
	    	            						position: latLng,
	    	            						map: map,
	    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkereYellow.png"/>',
	    	            						//icon: markerImage,
	    	            						//icon: {
	        					         // path: google.maps.SymbolPath.CIRCLE,
	        					         // scale: 1
	        					   // },
	    	            						title: "Click here to view details of Tower No "+data[0].towerNo
	    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
	    	            					});
										 
									  }
									  else if(data[0].phmBranch == '780.00'){
										  var marker = new google.maps.Marker({
	    	            						position: latLng,
	    	            						map: map,
	    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkereDg.png"/>',
	    	            						//icon: markerImage,
	    	            						//icon: {
	        					         // path: google.maps.SymbolPath.CIRCLE,
	        					         // scale: 1
	        					   // },
	    	            						title: "Click here to view details of Tower No "+data[0].towerNo
	    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
	    	            					});
										 
									  }
									  
									  else {
										  var marker = new google.maps.Marker({
	    	            						position: latLng,
	    	            						map: map,
	    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkereOrange.png"/>',
	    	            						//icon: markerImage,
	    	            						//icon: {
	        					         // path: google.maps.SymbolPath.CIRCLE,
	        					         // scale: 1
	        					   // },
	    	            						title: "Click here to view details of Tower No "+data[0].towerNo
	    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
	    	            					});
										 
									  }
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
								  
								  
								  /* if(!!navigator.geolocation) {
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
	 
        						/* google.maps.event.addListener(map, 'zoom_changed', function() {
        						    //zoomLevel = map.getZoom();
        						    //this is where you will do your icon height and width change. 

        							var pixelSizeAtZoom0 = 2; //the size of the icon at zoom level 0
        						    var maxPixelSize = 350; //restricts the maximum size of the icon, otherwise the browser will choke at higher zoom levels trying to scale an image to millions of pixels

        						    var zoom = map.getZoom();
        						    var relativePixelSize = Math.round(pixelSizeAtZoom0*Math.pow(2,zoom)); // use 2 to the power of current zoom to calculate relative pixel size.  Base of exponent is 2 because relative size should double every time you zoom in

        						    if(relativePixelSize > maxPixelSize) //restrict the maximum size of the icon
        						        relativePixelSize = maxPixelSize;

        						    //change the size of the icon
        						    marker.setIcon(
        						        new google.maps.MarkerImage(
        						            marker.getIcon().url, //marker's same icon graphic
        						            null,//size
        						            null,//origin
        						            null, //anchor
        						            new google.maps.Size(relativePixelSize, relativePixelSize) //changes the scale
        						        )
        						    );        
        						});
 */

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
		
		
		$.ajax({
			type : 'GET',
			url : "/MMS/findGantryByAreaNewAllWithDivision/" + strProvince + "/" + strArea +"/" + strDiv,
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(json) {
				 //alert("success");
				 for (var i = 0, length = json.length; i < length; i++) {
						var data = json[i];
						
						//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
						latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
     					bounds.extend(latLng);
     					
     					var marker = new google.maps.Marker({
    						position: latLng,
    						map: map,
    						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    						//marker.setIcon(zoomIcons[map.getZoom()]);
    						icon: '<c:url value="/resources/img/CEBImages/gantry_red.png"/>',
    						title: "ID "+data.id 
    					});
     					
var noOfCiur;
						
     					
     					(function(marker, data) {
     						
     						var eleType;
							if(data.gantryEleType == 1){
								eleType = 'SBB';
							}else {
								eleType = 'DBB';
							}
							
							var noOfSec = data.noOutBays / 2 ;
							
							var two ="2";
							var three ="3";
							var four = "4";
							var five = "5";
							
							var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
							"<tr><th>Gantry Info</th></tr>"+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit(\"" + data.id + "\")'>Single Line Diagram</button></td></tr> "+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg1(\"" + data.id + "\")'>DOC II</button></td></tr>"+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg2(\"" + data.id + "\")'>DOC III</button></td></tr>"+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg3(\"" + data.id + "\")'>DOC IV</button></td></tr>"+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg4(\"" + data.id + "\")'>DOC V</button></td></tr>"+
							
							"<tr><td><button type='button' id='myBtn'  onClick='loadFeederNew(\"" + data.id + "\")'>Feeder Diagram</button></td></tr> "+
							
							"<tr><td>Name : </td><td>"+
							data.name+"</td></tr><tr><td>Code :</td><td>"+
							data.code+"</td></tr><tr><td>Electrical Type :  </td><td>"+
							eleType+"</td></tr><tr><td>No of sections :  </td><td>"+
							noOfSec+"</td></tr>"+
							"<tr><td><button type='button' id='myBtnGantry' data-toggle=modal data-target=#myModalGantry onClick='viewGantry(\"" + data.id + "\")'>More Info</button></td></tr> "+
							
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
		
		
		
		
		var strArea = '440.00';
	    //alert("loadmvPole");
	   // var infoWindow = new google.maps.InfoWindow();
	//	var bounds = new google.maps.LatLngBounds();
		$.ajax({
					type : 'GET',
					url : "/MMS/findMvPoleByArea/" + strArea + "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(json) {
						 //alert("success");
						 for (var i = 0, length = json.length; i < length; i++) {
								var data = json[i];
								
								//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
								latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
	         					bounds.extend(latLng);
	         					
	         					var marker = new google.maps.Marker({
	        						position: latLng,
	        						map: map,
	        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	        						//marker.setIcon(zoomIcons[map.getZoom()]);
	        						icon: '<c:url value="/resources/img/CEBImages/polemarkere.png"/>',
    	            				title: "Pole Name "+data.poleName + " Pole Number " + data.poleNo
	        					});
	         					
	         					(function(marker, data) {
	         						
	         						
	         						
	         						var poleTypeNew;
									if(data.poleType == 7){
										poleTypeNew = 'PS';
									}else if(data.poleType == 4){
										poleTypeNew = 'Tubular';
									}else if(data.poleType == 6){
										poleTypeNew = 'RC';
									}else if(data.poleType == 1){
										poleTypeNew = 'Wood';
									}else{
										poleTypeNew = 'NONE';
									} 
									
									
									
									var poleHeightNew;
									if(data.poleHeight == 1){
										poleHeightNew = '9m';
									}else if(data.poleHeight == 2){
										poleHeightNew = '10m';
									}else if(data.poleHeight == 3){
										poleHeightNew = '11m';
									}else if(data.poleHeight == 4){
										poleHeightNew = '13m';
									}else{
										poleHeightNew = 'NONE';
									} 
									
									
									var workingLoadNew;
									if(data.workingLoad == 6){
										workingLoadNew = '300 kg';
									}else if(data.workingLoad == 5){
										workingLoadNew = '1200 kg';
									}else if(data.workingLoad == 1){
										workingLoadNew = '225 kg';
									}else if(data.workingLoad == 3){
										workingLoadNew = '500 kg';
									}else if(data.workingLoad == 4){
										workingLoadNew = '850 kg';
									}else if(data.workingLoad == 2){
										workingLoadNew = '350 kg';
									}else{
										workingLoadNew = 'NONE';
									} 
									
									
									       						       
									

									var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='mvpolemodel'><tr></tr><tr><th>MV Pole Info</th></tr><tr><td>Pole Number : </td><td>"+
									data.poleNo+"</td></tr><tr><td>Pole Name : </td><td>"+
									data.poleName+"</td></tr><tr><td>Latitude :</td><td>"+
									data.gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
									data.gpsLongitude+"</td></tr><tr><td>Pole Height :  </td><td>"+
									poleHeightNew+"</td></tr><tr><td>Pole Type : </td><td>"+
									poleTypeNew+"</td></tr><tr><td>Working Load : </td><td>"+
									workingLoadNew+"</td></tr><tr><td>HV LV Combine Run : </td><td>"+
									data.hvLvCombineRun+"</td></tr><tr><td>No of 33KV Circuits : </td><td>"+
									data.noOf33Kvcircuits+"</td></tr><tr><td>No of 11KV Circuits : </td><td>"+
									data.noOf11Kvcircuits+"</td></tr><tr><td>No of LV cct : </td><td>"+
									
									data.noOfLvCct+"</td></tr><tr><td>33 KV Conductor cct - 1 :  </td><td>"+
									data.kv33ConductorCct1+"</td></tr><tr><td>33 KV Conductor cct - 2 : </td><td>"+
									data.kv33ConductorCct2+"</td></tr><tr><td>33 KV Conductor cct - 3 : </td><td>"+
									data.kv33ConductorCct3+"</td></tr><tr><td>11 KV Conductor cct - 1 : </td><td>"+
									data.kv11ConductorCct1+"</td></tr><tr><td>11 KV Conductor cct - 2 : </td><td>"+
									data.kv11ConductorCct2+"</td></tr><tr><td>11 KV Conductor cct - 3 : </td><td>"+
									data.kv11ConductorCct3+"</td></tr><tr><td>LV Conductor Type : </td><td>"+
									
									data.lvConductorType+"</td></tr><tr><td>Pin / Shackle :  </td><td>"+
									data.pinShackle+"</td></tr><tr><td>Street Light : </td><td>"+
									data.streetLight+"</td></tr><tr><td>No of Stay : </td><td>"+
									data.stay+"</td></tr><tr><td>No of Strut : </td><td>"+
									data.strut+"</td></tr><tr><td>Cross Arm : </td><td>"+
									data.crossArm+"</td></tr><tr><td>Earth Conductor : </td><td>"+
									data.earthConductor+"</td></tr><tr><td>Line End : </td><td>"+
									
									data.lineEnd+"</td></tr><tr><td>33 KV CCT 1 ph 1 :  </td><td>"+
									data.kv33Cct1Ph1+"</td></tr><tr><td>33 KV CCT 1 ph 2 : </td><td>"+
									data.kv33Cct1Ph2+"</td></tr><tr><td>33 KV CCT 1 ph 3 : </td><td>"+
									data.kv33Cct1Ph3+"</td></tr><tr><td>33 KV CCT 2 ph 1 : </td><td>"+
									data.kv33Cct2Ph1+"</td></tr><tr><td>33 KV CCT 2 ph 2 : </td><td>"+
									data.kv33Cct2Ph2+"</td></tr><tr><td>33 KV CCT 2 ph 3 : </td><td>"+
									data.kv33Cct2Ph3+"</td></tr><tr><td>33 KV CCT 3 ph 1 : </td><td>"+
									data.kv33Cct3Ph1+"</td></tr><tr><td>33 KV CCT 3 ph 2 : </td><td>"+
									data.kv33Cct3Ph2+"</td></tr><tr><td>33 KV CCT 3 ph 3 : </td><td>"+
									
									data.kv33Cct3Ph3+"</td></tr><tr><td>MV Switch : </td><td>"+
									data.mvSwitch+"</td></tr><tr><td>Transformer Type : </td><td>"+
									data.transformerType+"</td></tr><tr><td>Transformer Capacity : </td><td>"+
								    data.transformerCapacity+"</td></tr><tr><td></td><td>"+
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
		
		
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNewPCB/" + strDiv +"/" +strProvince+ "/" +strArea+ "/",
                data: {},
                contentType: "application/json; charset=utf-8",
                success : function(json){
                	//alert(json.length);
                	
                		for (var i = 0, length = json.length; i < length; i++) {
        					var data = json[i],
        						latLng = new google.maps.LatLng(data[1].gpsLatitude, data[1].gpsLongitude);
        						//alert('huuuuuuu'+ data[1].gpsLatitude);
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
								  /* if(data[0].supportType == 1){
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
    	            						title: "Click here to view details of Tower ID "+data[0].id
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
    	            						title: "Click here to view details of Tower ID "+data[0].id
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
    	            						title: "Click here to view details of Tower ID "+data[0].id,
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
    	            						title: "Click here to view details of Tower ID "+data[0].id,
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
    	            						title: "Click here to view details of Tower ID "+data[0].id,
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
										*/
								  if(data[2].pcbTestDataAroclor > 50){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						icon: '<c:url value="/resources/img/CEBImages/trred.png"/>',
    	            						
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    	            					});
								  }else{
										//alert("test13 : "+ data.area);
	            			 			var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_green.png'
	            						icon: '<c:url value="/resources/img/CEBImages/trgreen.png"/>'
    	            						
	            						//title: "Click here to view details of Tower ID "+data.equipmentId,
	            						//label: { color: '#FAF8F8', fontWeight: 'bold', fontSize: '14px', text: '' }
	            					});
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
        					(function(marker, data) {
									
								
//alert('' + data[0].supportType);
							/* 	var supType;
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
								"</table></div>";
 */								

	
        						google.maps.event.addListener(marker, "click", function(e) {

            						

        							infoWindow.setContent("<b>Tr number:  </b>"+
        								data[0].referenceNo+"</br>"+"<b>Location Description:</b>"+
        								data[1].locationDescription+"</br>"+"<b>SIN number : </b>"+
	            						data[0].referenceNo+"</br>"+"<b>Serial Number : </b>"+
	            						data[0].serialNo+"</br>"+"<b>kVA Rating :</b>"+
	            						data[0].capacity+"</br>");
	            							
	            							//infoWindow.setContent(data[0].referenceNo);
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
	
	
	function mvTowerLineTransformer() {
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
		var strDiv = divison.options[divison.selectedIndex].value;
		//alert(strDiv);
		if(strLine === '-1'){
			strLine = 'NONE';
		}
		//variables for get the move location
		
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + bounds );
		$.ajax
        ({
        	type: 'GET',
            url: "/MMS/MapNewAll/" + strArea +"/" + strLine + "/" +strProvince +"/" + strDiv,
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
        						  
        						 /*  var markerImage = new google.maps.MarkerImage(
        								    '<c:url value="/resources/img/CEBImages/towermarkere.png"/>',
        								    new google.maps.Size(12,12), //size
        								    null, //origin
        								    null, //anchor
        								    new google.maps.Size(12,12) //scale
        								);
        						 */  
								  if(data[0].supportType == 1){
									  if(data[0].phmBranch == '600.41'){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkereLb.png"/>',
    	            						//icon: markerImage,
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower No "+data[0].towerNo
    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
    	            					});
										 
									  }else if(data[0].phmBranch == '596.00'){
										  var marker = new google.maps.Marker({
	    	            						position: latLng,
	    	            						map: map,
	    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkereYellow.png"/>',
	    	            						//icon: markerImage,
	    	            						//icon: {
	        					         // path: google.maps.SymbolPath.CIRCLE,
	        					         // scale: 1
	        					   // },
	    	            						title: "Click here to view details of Tower No "+data[0].towerNo
	    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
	    	            					});
										 
									  }
									  else if(data[0].phmBranch == '780.00'){
										  var marker = new google.maps.Marker({
	    	            						position: latLng,
	    	            						map: map,
	    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkereDg.png"/>',
	    	            						//icon: markerImage,
	    	            						//icon: {
	        					         // path: google.maps.SymbolPath.CIRCLE,
	        					         // scale: 1
	        					   // },
	    	            						title: "Click here to view details of Tower No "+data[0].towerNo
	    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
	    	            					});
										 
									  }
									  
									  else {
										  var marker = new google.maps.Marker({
	    	            						position: latLng,
	    	            						map: map,
	    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkereOrange.png"/>',
	    	            						//icon: markerImage,
	    	            						//icon: {
	        					         // path: google.maps.SymbolPath.CIRCLE,
	        					         // scale: 1
	        					   // },
	    	            						title: "Click here to view details of Tower No "+data[0].towerNo
	    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
	    	            					});
										 
									  }
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
								  
								  
								  /* if(!!navigator.geolocation) {
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
	 
        						/* google.maps.event.addListener(map, 'zoom_changed', function() {
        						    //zoomLevel = map.getZoom();
        						    //this is where you will do your icon height and width change. 

        							var pixelSizeAtZoom0 = 2; //the size of the icon at zoom level 0
        						    var maxPixelSize = 350; //restricts the maximum size of the icon, otherwise the browser will choke at higher zoom levels trying to scale an image to millions of pixels

        						    var zoom = map.getZoom();
        						    var relativePixelSize = Math.round(pixelSizeAtZoom0*Math.pow(2,zoom)); // use 2 to the power of current zoom to calculate relative pixel size.  Base of exponent is 2 because relative size should double every time you zoom in

        						    if(relativePixelSize > maxPixelSize) //restrict the maximum size of the icon
        						        relativePixelSize = maxPixelSize;

        						    //change the size of the icon
        						    marker.setIcon(
        						        new google.maps.MarkerImage(
        						            marker.getIcon().url, //marker's same icon graphic
        						            null,//size
        						            null,//origin
        						            null, //anchor
        						            new google.maps.Size(relativePixelSize, relativePixelSize) //changes the scale
        						        )
        						    );        
        						});
 */

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
		
		
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNewPCB/" + strDiv +"/" +strProvince+ "/" +strArea+ "/",
                data: {},
                contentType: "application/json; charset=utf-8",
                success : function(json){
                	//alert(json.length);
                	
                		for (var i = 0, length = json.length; i < length; i++) {
        					var data = json[i],
        						latLng = new google.maps.LatLng(data[1].gpsLatitude, data[1].gpsLongitude);
        						//alert('huuuuuuu'+ data[1].gpsLatitude);
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
								  /* if(data[0].supportType == 1){
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
    	            						title: "Click here to view details of Tower ID "+data[0].id
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
    	            						title: "Click here to view details of Tower ID "+data[0].id
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
    	            						title: "Click here to view details of Tower ID "+data[0].id,
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
    	            						title: "Click here to view details of Tower ID "+data[0].id,
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
    	            						title: "Click here to view details of Tower ID "+data[0].id,
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
										*/
								  if(data[2].pcbTestDataAroclor > 50){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						icon: '<c:url value="/resources/img/CEBImages/trred.png"/>',
    	            						
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    	            					});
								  }else{
										//alert("test13 : "+ data.area);
	            			 			var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_green.png'
	            						icon: '<c:url value="/resources/img/CEBImages/trgreen.png"/>'
    	            						
	            						//title: "Click here to view details of Tower ID "+data.equipmentId,
	            						//label: { color: '#FAF8F8', fontWeight: 'bold', fontSize: '14px', text: '' }
	            					});
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
        					(function(marker, data) {
									
								
//alert('' + data[0].supportType);
							/* 	var supType;
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
								"</table></div>";
 */								

	
        						google.maps.event.addListener(marker, "click", function(e) {

            						

        							infoWindow.setContent("<b>Tr number:  </b>"+
        								data[0].referenceNo+"</br>"+"<b>Location Description:</b>"+
        								data[1].locationDescription+"</br>"+"<b>SIN number : </b>"+
	            						data[0].referenceNo+"</br>"+"<b>Serial Number : </b>"+
	            						data[0].serialNo+"</br>"+"<b>kVA Rating :</b>"+
	            						data[0].capacity+"</br>");
	            							
	            							//infoWindow.setContent(data[0].referenceNo);
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
		
		var strDiv = divison.options[divison.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
		
        var selectedLineValues = $("#line").val();
        
		var selectedDivValues = $("#divison").val();
		
		var selectedProValues = $("#province").val();
		var selectedAreaValues = $("#area").val();
		
		
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + strArea + strLine );
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNewComView/" + selectedAreaValues +"/" + selectedLineValues + "/" +selectedProValues +"/" + selectedDivValues,
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
	            						title: "Click here to view details of Tower No "+data[0].towerNo
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
		        						title: "Click here to view details of Tower No "+data[0].towerNo,
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
		var selectedAreaValues = $("#area").val();
				$.ajax({
					type : 'GET',
					url : "/MMS/findLineByAreaList/" + selectedAreaValues + "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#line'), option = "<option value='-1'>LINE</option>";
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
	
	
	/* function getVJCount() {
		var strUser = area.options[area.selectedIndex].value;
		$.ajax({
					type : 'GET',
					url : "/MMS/countValueJournal",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						document.getElementById("txtValiuJurnel").value = data.vj_approval_count;	
					}
				});

	}
 */

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
	
	function AddTrippingData(){
	    var myTable= "<table><tr><td style='width: 100px; color: red;'>Col Head 1</td>";
	    myTable+= "<td style='width: 100px; color: red; text-align: right;'>Col Head 2</td>";
	    myTable+="<td style='width: 100px; color: red; text-align: right;'>Col Head 3</td></tr>";

	    myTable+="<tr><td style='width: 100px;                   '>---------------</td>";
	    myTable+="<td     style='width: 100px; text-align: right;'>---------------</td>";
	    myTable+="<td     style='width: 100px; text-align: right;'>---------------</td></tr></table>";
	    document.write( myTable);
	}
	
	
	function findProvinceByDivision() {
		var division = divison.options[divison.selectedIndex].value;
				$.ajax({
					type : 'GET',
					url : "/MMS/findAllProvincsPCB/" + division+"/",
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
	
	/* function myFunction() {
		  var x = document.getElementById("test");
		  var elem = document.getElementById("showBtn");
		  
		  if (x.style.display === "none") {
		    x.style.display = "block";
		    
		  } else {
		    x.style.display = "none";
		  }
		  
		    if (elem.value=="Hide Options") elem.value = "Show Options";
		    else elem.value = "Hide Options";
		}


	function closeall() {
		 var x = document.getElementById("test");
		 
		 //var y = document.getElementById("filter_div");
		 
		 x.style.display = "none";
		 //y.style.display = "none";
	    return;
	}
 */

	
	
</script>

</head>

<body onload="myMap(new google.maps.LatLng(7.475214, 80.744077), 7);">
	<div id="theme-wrapper">
		<%@ include file="sections/header.jsp"%>

		<div id="page-wrapper" class="container">
			<div class="row">

				<%@ include file="sections/userLevels.jsp"%>

				<div id="content-wrapper">
					<div class="row">
<!-- The Modal -->
                         <div id="myModal" class="modal">



	

                              <!-- Modal content -->
                              <div class="modal-content">
                             <span class="close">&times;</span>
                                <label>Maintenance Details</label><br>
                                <p1>Anticlimbing status : <label id="anticlimbingstatus">anticlimbingstatus</label></p1><br>
                                <p1>Attention status : <label id="attentionstatus">attentionstatus</label></p1><br>
                                <p1>Conductor status : <label id="conductorstatus">conductorstatus</label></p1><br>
                                <p1>Earth conductor status : <label id="earthconductorstatus">earthconductorstatus</label></p1><br>
                                <p1>Way leave status : <label id="wayleavestatus">wayleavestatus</label></p1><br>
                                
                             </div>

                        </div>


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

						<div class="jumbotron">

							<div class="row ">
							
							
							<!-- <div class="col-sm-12" align="left">
									<div class="row">
									
									

										<input id ='showBtn' type='button' class='btn btn-success' value='Show Options' onClick='myFunction()'></input>

									</div>
								</div>
							
 -->

								<div class="col-sm-12" align="left">
									<div class="row">
										<form:form method="post" action="viewSupportByProvince"
											modelAttribute="model">

											<div class="col-lg-12">
											<div class="row">
													<div class="col-sm-6">
                                            		<form:select multiple="true" id="divison" path=""
																onchange="findProvinceByDivision()"
																style="width:100%; background-color: #FFFFFF; border-radius: 5px;">
																 <form:options items="${model.divList}" />
															</form:select>
														</div>
													
												

												<div class="col-sm-6">
                                            			<form:select multiple="true" id="province" path="glcompmobj.compId"
																onchange="findArea()"
																style="width:100%; background-color: #FFFFFF; border-radius: 5px;">
																<form:options items="${model.provinceList}" />
															</form:select>
														</div>
													
											</div>
											<div class="row">
												

												<div class="col-sm-6">
                                            			<form:select multiple="true" id="area" path="gldeptobj.deptId"
																onchange="getLine()"
																style="width:100%; background-color: #FFFFFF; border-radius: 5px;">
																<form:options items="${model.areaList}" />
															</form:select>
														</div>
													
												<div class="col-sm-6">
                                            			<form:select multiple="true" id="line" path="line.id" onchange=""
																style="width:100%; background-color: #FFFFFF; border-radius: 5px;">
																<form:options items="${model.lineList}" />
															</form:select>
														</div>
												</div>	
<div class="row">
											
												<div class="col-sm-6">
                                            			<form:select id="mode" path="" onchange=""
																style="width:100%; background-color: #FFFFFF; border-radius: 5px;">
																<%-- <form:option value="MAP" label="MAP VIEW" />
																 --%>	<form:option value="NETWORK" label="Network View" />



															</form:select>
														</div>
													

												<div class="col-sm-6">
                                            		<div align="right" style="padding-right: 10px">
															<form:button type='button' class='btn btn-success'
																onClick='viewMapByMode()'>View</form:button>
														</div>
													</div>
												
											</div>
											
										</form:form>
																		</div>
								</div>

								<div class="col-sm-12" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
								</div>
								
								<br>
													
															
																
								

							</div>
						</div>
					</div>

<div class="container">

						<div class="jumbotron">

							<div class="row ">

<div class="col-sm-12">

								<div class="row">
								
								<br>
								<!-- <div class="table-responsive" >
								 --><div class="wrimagecardNew1 wrimagecard-topimage">
								
								<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
													<div align="center" id="dashboard_div">
      												<!--Divs that will hold each control and chart-->
      												 
      												 <div align="center" id="pie_div1"></div>
      												<br>
      												<!-- <div align="center" id="pie_div2"></div>
      												<br>
													 --> 
													 <!-- <div align="center" id="chart_div"></div>
													 <br> -->
													 <div align="center" id="column_div1"></div>
													 
													<br>
													 
													 <div align="center" id="table_div"></div>
 <div align="center"  id="filter_div"></div>
       												
												</div>
												
											
											
										</div>
								</div>
								</div>
					<!-- </div>
					 --></div>
</div>
</div>
</div>
					


				</div>
			</div>
		</div>
	</div>
	<%@ include file="sections/footer.jsp"%>
	<%@ include file="sections/global_scripts.jsp"%>
	
	<div class="modal fade" id="basicModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h4 class="modal-title" id="myModalLabel">View Tower Maintenance Data</h4>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">×</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <h6><b>Visit ID</b> : 002</h6>
		        <h6><b>Tower ID</b> : 002A</h6>
		        <h6><b>Dept ID</b> : 501.00</h6>
		        <h6><b>Tappings</b> : 04</h6>
		        <h6><b>Missing Parts</b> : 06</h6>
		        <h6><b>Flash Over Sets</b> : 04</h6>
		        <h6><b>Way leaving Status</b> : Good</h6>
		        <h6><b>Base Concrete Status</b> : Bad</h6>
		        <h6><b>Anti Climbing Status</b> : Lost</h6>
		        <h6><b>Conductor Condition</b> : Danger</h6>
		        <h6><b>Jumper Condition</b> : Good</h6>
		        <h6><b>Earth Conductor Condition</b> : Damage</h6>
		        <h6><b>Maintenance Attention</b> : Urgent</h6>
		        <h6><b>Funguss Set No</b> : 07</h6>
		        <h6><b>WPIN set</b> : 02</h6>
		        <h6><b>End Fitting set</b> : 08</h6>
		        <h6><b>Special Observations</b> : No Observations</h6>
		        <h6><b>LUTD</b> : 2018-03-06T09:23</h6>
		        <h6><b>Maintenance Date</b> : 2018-03-06</h6>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		

	
	
	
</body>
</html>