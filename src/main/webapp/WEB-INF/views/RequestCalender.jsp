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




</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
google.charts.load("current", {packages:["calendar"]});
google.charts.load('current', {'packages':['timeline']});

google.charts.setOnLoadCallback(drawChartTimeLine);

google.charts.setOnLoadCallback(drawChart);


function drawChartTimeLine() {
	
	
	
	$.ajax({
		type : 'GET',
		url : "/MMS/getInterruptionCalenderForRequested",
		data : {},
		contentType : "application/json; charset=utf-8",
		success : function(result) {
			var dataTable = new google.visualization.DataTable();
			dataTable.addColumn('string', 'Team');
			dataTable.addColumn('date', 'Working Date');
			dataTable.addColumn('date', 'Working Date 2');
		    
			
			//dataTable.addColumn({ type: 'date', id: 'Date' });
			//dataTable.addColumn({ type: 'number', id: 'Request Number' });
			//dataTable.addColumn({ 'type': 'string', 'role': 'tooltip', 'p': {'html': true} });
			   
		     for (var i = 0; i < result.length; i++) {
				var data = result[i];
				//var str = '<table><tr><td>Interruption No : </td></tr><tr><td> ' +data.approvalId +'</td></tr><tr><td> Area : '+ data.referenceNo + '</td></tr><tr><td> Location: ' +data.fromto +'</td></tr><tr><td> Interruption Cycle: ' +data.intCycle +'</td></tr></table>';
				if(data.workingDate){
				 	d = new Date(data.workingDate);
					dataTable.addRows([[data.referenceNo,new Date(d.getFullYear(),d.getMonth(),d.getDate()),new Date(d.getFullYear(),d.getMonth(),d.getDate())]]);
				}
				
				
				
				
		 	}
		 
		 
		     var options = {
		    	      height: 450,
		    	      timeline: {
		    	        groupByRowLabel: true
		    	      }
		    	    };

		    	    var chart = new google.visualization.Timeline(document.getElementById('chart_div'));

		    	    chart.draw(dataTable, options);
		}
	});	

}
	
	
	
	
	
	
	
	
	
	
	
	
	
    
function drawChart() {
	
	
	$.ajax({
			type : 'GET',
			url : "/MMS/getInterruptionCalender",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				var dataTable = new google.visualization.DataTable();
				dataTable.addColumn({ type: 'date', id: 'Date' });
				dataTable.addColumn({ type: 'number', id: 'Request Number' });
				dataTable.addColumn({ 'type': 'string', 'role': 'tooltip', 'p': {'html': true} });
				   
			     for (var i = 0; i < result.length; i++) {
					var data = result[i];
					var str = '<table><tr><td>Interruption No : </td></tr><tr><td> ' +data.approvalId +'</td></tr><tr><td> Area : '+ data.referenceNo + '</td></tr><tr><td> Location: ' +data.fromto +'</td></tr><tr><td> Interruption Cycle: ' +data.intCycle +'</td></tr></table>';
					if(data.workingDate){
					 	d = new Date(data.workingDate);
						dataTable.addRows([[new Date(d.getFullYear(),d.getMonth(),d.getDate()),1,str]]);
					}
			 	}
			 
			 
			 
			    
		    var chart = new google.visualization.Calendar(document.getElementById('calendar_basic'));

    		var options = {
      			title: "Recommended Interruption Schedule",
      			calendar: { cellSize: 15 },
				tooltip: {isHtml: true},
      	        trigger: 'both',
      	      height: 350,
      			 noDataPattern: {
      	           backgroundColor: '#76a7fa',
      	           color: '#a0c3ff'
      	         }
    		};

    		chart.draw(dataTable, options);
			}
		});
	
	
	$.ajax({
		type : 'GET',
		url : "/MMS/getInterruptionCalenderForRequested",
		data : {},
		contentType : "application/json; charset=utf-8",
		success : function(result) {
			var dataTable = new google.visualization.DataTable();
			dataTable.addColumn({ type: 'date', id: 'Date' });
			dataTable.addColumn({ type: 'number', id: 'Request Number' });
			dataTable.addColumn({ 'type': 'string', 'role': 'tooltip', 'p': {'html': true} });
			   
		     for (var i = 0; i < result.length; i++) {
				var data = result[i];
				var str = '<table><tr><td>Interruption No : </td></tr><tr><td> ' +data.approvalId +'</td></tr><tr><td> Area : '+ data.referenceNo + '</td></tr><tr><td> Location: ' +data.fromto +'</td></tr><tr><td> Interruption Cycle: ' +data.intCycle +'</td></tr></table>';
				if(data.workingDate){
				 	d = new Date(data.workingDate);
					dataTable.addRows([[new Date(d.getFullYear(),d.getMonth(),d.getDate()),1,str]]);
				}
		 	}
		 
		 
		 
		    
	    var chart = new google.visualization.Calendar(document.getElementById('calendar_basicrequested'));

		var options = {
  			title: "Requested Interruption  Calender",
  			calendar: { cellSize: 15 },
			tooltip: {isHtml: true},
  	        trigger: 'both',
  	      height: 350,
  			 noDataPattern: {
  	           backgroundColor: '#76a7fa',
  	           color: '#a0c3ff'
  	         }
		};

		chart.draw(dataTable, options);
		}
	});	
	
	
    		
}



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
			url : "/MMS/getRequestTypeCount",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				var datavaluepie = new google.visualization.DataTable();
				datavaluepie.addColumn('string', 'Request Type');
				datavaluepie.addColumn('number', 'No. Request');
				datavaluepie.addColumn('string', 'Type');
				
				for (var i = 0; i < result.length; i++) {
						var data = result[i];
						var type = requestType(data[1]);
						datavaluepie.addRows([[type,data[0],data[1]]]);
				}
				
				 
			     // Create a dashboard.
		        var dashboard = new google.visualization.Dashboard(
		            document.getElementById('dashboard_div'));

		        // Create a range slider, passing some options
		        var donutRangeSlider2 = new google.visualization.ControlWrapper({
		          'controlType': 'CategoryFilter',
		          'containerId': 'filter_div2',
		          'options': {
		        	'filterColumnLabel': 'Request Type'
		          }
		        });
		        
		     // Create a pie chart, passing some options
		        var pieChart = new google.visualization.ChartWrapper({
		          'chartType': 'PieChart',
		          'containerId': 'psapr_div',
		          'options': {
		            'width': 230,
		            'height': 210,
		            'is3D': true,
		            'pieSliceText': 'value',
		            'legend': 'right'
		          }
		        });
		        
		        

		        
		        var table = new google.visualization.ChartWrapper({
			          'chartType': 'Table',
			          'containerId': 'psaprtable_div',
			          'options': {
			            'width': 230,
			            'height': 210,
			            'pieSliceText': 'value',
			            'legend': 'right'
			          }
			        });
		        
		        dashboard.bind(donutRangeSlider2, pieChart);
		        
		        dashboard.bind(donutRangeSlider2, table);
		        
		        dashboard.draw(datavaluepie);
		        
		        google.visualization.events.addListener(table, 'select', selectHandler);
 		        function selectHandler() {
		          //alert("hiii");
		          var selectedItem = table.getChart().getSelection();
		          
		          if (selectedItem) {
		        	 // alert("hiii2");
		             var row = selectedItem[0].row;
   		         var type = table.getDataTable().getValue(row, 2);
   		        		            
   		    	    $.ajax({
			type : 'GET',
			url : "/MMS/getRequestStatusCountByType?type="+type,
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				var cbpmt = result[i];
				var datavaluepie = new google.visualization.DataTable();
				datavaluepie.addColumn('string', 'Status');
				datavaluepie.addColumn('number', 'Count');
				datavaluepie.addColumn('string', 'Type');
				datavaluepie.addColumn('string', 'To status');
				datavaluepie.addColumn('string', 'From status');
				
				for (var i = 0; i < result.length; i++) {
						var data = result[i];
						var status = searchStatus(data[2]);
						if(data[2]=="95"){
							if(data[3]=="1"){
								status ="Forwarded to Area Engineer";
							}else if(data[3]=="2"){
								status ="Forwarded to Planning CE";
							}else if(data[3]=="3"){
								status ="Forwarded to Control Center";
							}else{
								status ="Forwarded";
							}
							
						}
						datavaluepie.addRows([[status,data[0],data[1],data[2], data[3]]]);
				}
								
				 
			     // Create a dashboard.
		        var dashboard = new google.visualization.Dashboard(
		            document.getElementById('dashboard_div'));

		        // Create a range slider, passing some options
		        var donutRangeSlider2 = new google.visualization.ControlWrapper({
		          'controlType': 'CategoryFilter',
		          'containerId': 'filter_div3',
		          'options': {
		        	'filterColumnLabel': 'Status'
		          }
		        });
		        
		        
		       		        
		        var table = new google.visualization.ChartWrapper({
			          'chartType': 'Table',
			          'containerId': 'matdetail_div',
			          'options': {
			            'width': 230,
			            'height': 210,
			            'pieSliceText': 'value',
			            'legend': 'right'
			          }
			        });
		        
		        dashboard.bind(donutRangeSlider2, table);
		        dashboard.draw(datavaluepie);
		        
		        google.visualization.events.addListener(table, 'select', selectHandler);
		        
		        function selectHandler() {
		        	//alert("hiii");
		         var selectedItem = table.getChart().getSelection();
		         if(selectedItem){
		        	 var row = selectedItem[0].row;
		        	 var type = table.getDataTable().getValue(row, 2);
		        	 var tostatus = table.getDataTable().getValue(row, 3);
		        	 var fromstatus = table.getDataTable().getValue(row, 4);
	 		            
 		             
 		             
 		            $.ajax({
 		   			type : 'GET',
 		   			url : "/MMS/getRequestStatusCountByTypeDetail?type="+type+"&tostatus="+tostatus+"&fromstatus="+fromstatus,
 		   			data : {},
 		   			contentType : "application/json; charset=utf-8",
 		   			success : function(result) {
 		   				var cbpmt = result[i];
 		   				var datavaluepie = new google.visualization.DataTable();
 		   			datavaluepie.addColumn('string', 'Interruption No');
 		   		datavaluepie.addColumn('string', 'Status');
					
 					datavaluepie.addColumn('string', 'Area');
 					datavaluepie.addColumn('string', 'Section to be Interrupted');
 					datavaluepie.addColumn('string', 'Time Duration');
 					datavaluepie.addColumn('string', 'Requested EE/ES');
 					datavaluepie.addColumn('string', 'Field work');
 					//datavaluepie.addColumn('string', 'Status');
 					
 					 /* var calenderdata = new google.visualization.DataTable();
 					calenderdata.addColumn({ type: 'date', id: 'Interruption Date' });
 					calenderdata.addColumn({ type: 'number', id: 'Status' });
 					 */
 					//var jsonData = JSON.parse(result);
 					 for (var i = 0; i < result.length; i++) {
 							var data = result[i];
 							var dateCom = dataComparition(data.workingDate);
 							/* var status = searchStatus(data.toStatus);
 							if(data.toStatus=="95"){
 								if(data.fromStatus=="1"){
 									status ="Forwarded to Area Engineer";
 								}else if(data.fromStatus=="2"){
 									status ="Forwarded to Planning CE";
 								}else if(data.fromStatus=="3"){
 									status ="Forwarded to Control Center";
 								}else{
 									status ="Forwarded";
 								}
 								
 							} */
 							
 							//var type = requestType(data[1]);
 							datavaluepie.addRows([[data.approvalId,dateCom,data.referenceNo,data.fromto,data.timeduration,data.reason,data.req2]]);
 							//calenderdata.addRows([[new Date(data.workingDate),data.toStatus]]);
 					 }
 					 
 					 
 					/* var calender = new google.visualization.Calendar(document.getElementById('calendar_basic'));

	 			       var options = {
	 			         title: "Interruption Calender",
	 			         height: 350,
	 			       };

 			      	calender.draw(calenderdata, options);
 */ 									
 		   				 
 		   			     // Create a dashboard.
 		   		        var dashboard = new google.visualization.Dashboard(
 		   		            document.getElementById('dashboard_div'));

 		   		        // Create a range slider, passing some options
 		   		        var donutRangeSlider2 = new google.visualization.ControlWrapper({
 		   		          'controlType': 'CategoryFilter',
 		   		          'containerId': 'filter_div4',
 		   		          'options': {
 		   		        	'filterColumnLabel': 'Area'
 		   		          }
 		   		        });
 		   		        
 		   		        
 		   		       		        
 		   		        var table = new google.visualization.ChartWrapper({
 		   			          'chartType': 'Table',
 		   			          'containerId': 'matdetail_divdetail',
 		   			          'options': {
 		   			            'width': 1200,
 		   			            'height': 300,
 		   			            'pieSliceText': 'value',
 		   			            'legend': 'right'
 		   			          }
 		   			        });
 		   		        
 		   		        dashboard.bind(donutRangeSlider2, table);
 		   		        dashboard.draw(datavaluepie);
 		   		        
 		   		    function selectHandler() {
 			        	//alert("hiii");
 			         var selectedItem = table.getChart().getSelection();
 			         if(selectedItem){
 			        	var row = selectedItem[0].row;
 			        	var id = table.getDataTable().getValue(row, 0);
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
 			         }
 			        google.visualization.events.addListener(table, 'select', selectHandler);
 		   		        

 		   		}
 		   		});

 		             
 		             
 		             
		         }
		        }
		        
		        /* function selectHandler() {
		        	//alert("hiii");
		         var selectedItem = table.getChart().getSelection();
		         if(selectedItem){
		        	  
		        	 
		        	 var row = selectedItem[0].row;
		        	var docNo = table.getDataTable().getValue(row, 0);
 		            estimateNoGloble = docNo;
 		            costCenterNoGloble = costCenterNo;
 		            
 		            
 		            var url="downloadPaySlip?docno="+docNo;
 		    	    var width = 1100;
 		    	    var height = 700;
 		    	    var left = parseInt((screen.availWidth/2) - (width/2));
 		    	    var top = parseInt((screen.availHeight/2) - (height/2));
 		    	    var windowFeatures = "width=" + width + ",height=" + height + 
 		    	    ",status,resizable,left=" + left + ",top=" + top +
 		    	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
 		    	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
 		    	    
		         }
		         }
		        google.visualization.events.addListener(table, 'select', selectHandler); */
			}
			});    
   		    	    
		            
		            
		            
		          }
		         }

		        
		        
		        
		        	}
		});

	  
	  

	  
	      
     }
     
     function dataComparition(dateInt){
    	 var varDate = new Date(dateInt); //dd-mm-YYYY
    	 var today = new Date();
    	 today.setHours(0,0,0,0);
    	 if(varDate >= today) {
    	 //Do something..
    	 	return "Upcoming";
    	 }else if(varDate == today){
    		return "Active";
    	 }else{
    		 return "Past";
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


								<div class="col-sm-2" align="left">
									<div class="row">
										<div class="col-lg-12">

											</div>																	<!-- edited anushka 2019-01-11 -------------------------------------------------------------- -->
										
									</div>
								</div>

															
								<div class="col-sm-12" align="left">

									<div class="row">
									<div class="table-responsive" >
									

			   <div id="calendar_basic"></div>
			   <div id="calendar_basicrequested"></div>
			   <div id="chart_div"></div>
			   
									</div>
									</div>
								</div>
								
								
								
								
																
								

							</div>
						</div>
					</div>



					<div class="container">


						<div class="row">
							<div class="col-lg-12">

								<div class="row">
								
								
																						
									


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