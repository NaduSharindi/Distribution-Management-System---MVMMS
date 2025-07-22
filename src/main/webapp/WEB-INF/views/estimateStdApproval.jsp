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

.google-visualization-controls-categoryfilter-selected li {
  background-color: #e65100;
  border: 1px solid #ff9800;
  color: #ffffff;
  padding: 6px;
}

.goog-link-button {
  cursor: pointer;
  float: right;
  margin-left: 4px;
}

.google-visualization-controls-slider-horizontal {
  width: 800px;
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
google.charts.load('current', {'packages':['corechart', 'controls']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawDashboard);



      var estimateNoGloble;
      var costCenterNoGloble;
      var approveEstimateNo;

      var costcenterForList;


function drawDashboard() {
	
	document.getElementById("btnApprove").disabled = true;
	document.getElementById("txtReason").disabled = true;
	document.getElementById("btnReject").disabled = true;
	document.getElementById("btnViewMore").disabled = true;
	
	document.getElementById("btnViewPrint").disabled = true;
	
    	  
	    	  $.ajax({
    			type : 'GET',
    			url : "/MMS/getApprovalListStdEst",
    			data : {},
    			contentType : "application/json; charset=utf-8",
    			success : function(result) {
    				var datavaluepie = new google.visualization.DataTable();
    				datavaluepie.addColumn('string', 'Type');
    				datavaluepie.addColumn('number', 'No. Estimate');
    				datavaluepie.addColumn('string', 'Dept Id');
    				
    				for (var i = 0; i < result.length; i++) {
    						var data = result[i];
    						datavaluepie.addRows([[data[3], data[0],data[2]]]);
    				}
    				
    				 
    			     // Create a dashboard.
    		        var dashboard = new google.visualization.Dashboard(
    		            document.getElementById('dashboard_div'));

    		        // Create a range slider, passing some options
    		        var donutRangeSlider2 = new google.visualization.ControlWrapper({
    		          'controlType': 'CategoryFilter',
    		          'containerId': 'filter_div2',
    		          'options': {
    		        	'filterColumnLabel': 'Type'
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
    		        dashboard.bind(donutRangeSlider2, pieChart);
    		        dashboard.draw(datavaluepie);
    		        
    		        google.visualization.events.addListener(table, 'select', selectHandler);
      		        function selectHandler() {
    		          //alert("hiii");
    		          var selectedItem = table.getChart().getSelection();
    		          
    		          if (selectedItem) {
    		        	 // alert("hiii2");
    		        var row = selectedItem[0].row;

	    			          //var deptId=table.getDataTable().getValue(row, 3); 

	    		        	var value = table.getDataTable().getValue(row, 0);
	 
	    		        	costcenterForList = value;
    		           // var value = datavaluepie.getValue(selectedItem.row, 0);
    		           // alert('The user selected ' + value);
    		            
    		            $.ajax({
    		    			type : 'GET',
    		    			url : "/MMS/getApprovalStdDetail/" +value+"/" ,
    		    			data : {},
    		    			contentType : "application/json; charset=utf-8",
    		    			success : function(result) {
    		    				var datavalue = new google.visualization.DataTable();
    		    				//datavalue.addColumn('string', 'Approve');
    		    				
    		    				datavalue.addColumn('string', 'Estimate No');
    		    				datavalue.addColumn('string', 'Dept Id');
    		    				datavalue.addColumn('string', 'Description');
    		    				datavalue.addColumn('string', 'Address');
    		    				
    		    				datavalue.addColumn('number', 'Consumer Payable');
    		    				datavalue.addColumn('number', 'Security Deposit');
    		    				datavalue.addColumn('number', 'Nbt Cost');
    		    				datavalue.addColumn('number', 'Ceb Cost');
    		    				
    		    				datavalue.addColumn('number', 'Rebate Cost');
    		    				datavalue.addColumn('number', 'Vat Cost');
    		    				
    		    				for (var i = 0; i < result.length; i++) {
    		    						var data = result[i];
    		    						//datavalue.addRows([['<a href="LINK">Approve</a>'],[data[0], data[1],data[2]]]);
    		    						datavalue.addRows([[data[0], data[1],data[9],data[2],data[6],data[5],data[3],data[8],data[4],data[7]]]);
    				    				
    		    				}
    		    				 
    		    			     // Create a dashboard.
    		    		        var dashboard = new google.visualization.Dashboard(
    		    		            document.getElementById('dashboard_div'));

    		    		        // Create a range slider, passing some options
    		    		        var donutRangeSlider3 = new google.visualization.ControlWrapper({
    		    		          'controlType': 'CategoryFilter',
    		    		          'containerId': 'filter_div3',
    		    		          'options': {
    		    		        	'filterColumnLabel': 'Estimate No'
    		    		          }
    		    		        });

    		    		        
    		    		        var table = new google.visualization.ChartWrapper({
    		    			          'chartType': 'Table',
    		    			          'containerId': 'estaprtabledetail_div',
    		    			          'options': {
    		    			            'width': 1300,
    		    			            'height': 300,
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
    		    		          var selectedItem = table.getChart().getSelection();
    		    		          
    		    		          if (selectedItem) {
    		    		        	//  alert("hiii2");
    		    		        	
    		    		        	document.getElementById("btnApprove").disabled = false;
    		    				document.getElementById("txtReason").disabled = false;
    		    				document.getElementById("btnReject").disabled = false;
    		    				document.getElementById("btnViewMore").disabled = false;
    		    				
    		    				document.getElementById("btnViewPrint").disabled = false;
    		    				
    		    		        	
    		    		        	var row = selectedItem[0].row;

	    			                //var deptId=table.getDataTable().getValue(row, 3); 

	    		        			var estimateNo = table.getDataTable().getValue(row, 0);
	    		        			var costCenterNo = table.getDataTable().getValue(row, 1);
	    		        			estimateNoGloble = estimateNo;
	     		    		        costCenterNoGloble = costCenterNo;
	     		    		           
	     		    		       document.getElementById("txtEstNo").value = estimateNo;
	     		    		          document.getElementById("txtCostCenter").value = costCenterNo;
	     		    		         viewMore();
	     		    		        viewPrint()
    		    		           // var estimateNo = datavalue.getValue(selectedItem.row, 0);
    		    		           // var costCenterNo = datavalue.getValue(selectedItem.row, 1);
    		    		            
    		    		            //alert('This will open the pdf file later ' + estimateNo + " : " + costCenterNo);
    		    		           // alert('costCenterNo ' + costCenterNo);
    		    		            
    		    		             
    		    		            
    		    		          }
    		    		        }
    		    		        google.visualization.events.addListener(table, 'select', selectHandler);


    		    		        
    		    			}
    		    		});

    		            
    		            
    		            
    		            
    		          }
    		         }

    		        
    		        
    		        
  		        	}
    		});
 
    	  
    	  
    
    	  
    	      
          }
          
          
          
function refreashTable(){
	$.ajax({
		type : 'GET',
		url : "/MMS/getApprovalStdDetail/" +costcenterForList+"/" ,
		data : {},
		contentType : "application/json; charset=utf-8",
		success : function(result) {
			var datavalue = new google.visualization.DataTable();
			//datavalue.addColumn('string', 'Approve');
			
			datavalue.addColumn('string', 'Estimate No');
			datavalue.addColumn('string', 'Dept Id');
			datavalue.addColumn('string', 'Description');
			datavalue.addColumn('string', 'Address');
			
			datavalue.addColumn('number', 'Consumer Payable');
			datavalue.addColumn('number', 'Security Deposit');
			datavalue.addColumn('number', 'Nbt Cost');
			datavalue.addColumn('number', 'Ceb Cost');
			
			datavalue.addColumn('number', 'Rebate Cost');
			datavalue.addColumn('number', 'Vat Cost');
			
			for (var i = 0; i < result.length; i++) {
					var data = result[i];
					//datavalue.addRows([['<a href="LINK">Approve</a>'],[data[0], data[1],data[2]]]);
					datavalue.addRows([[data[0], data[1],data[9],data[2],data[6],data[5],data[3],data[8],data[4],data[7]]]);
    				
			}
			 
		     // Create a dashboard.
	        var dashboard = new google.visualization.Dashboard(
	            document.getElementById('dashboard_div'));

	        // Create a range slider, passing some options
	        var donutRangeSlider3 = new google.visualization.ControlWrapper({
	          'controlType': 'CategoryFilter',
	          'containerId': 'filter_div3',
	          'options': {
	        	'filterColumnLabel': 'Estimate No'
	          }
	        });

	        
	        var table = new google.visualization.ChartWrapper({
		          'chartType': 'Table',
		          'containerId': 'estaprtabledetail_div',
		          'options': {
		            'width': 1300,
		            'height': 300,
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
		}
		});
	
	
}
          
          
          
function viewMore(){
	if(estimateNoGloble){
		$.ajax({
			type : 'GET',
			url : "/MMS/getStdEstimateDetailAll?appNo=" +estimateNoGloble+"&deptid="+costCenterNoGloble,
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				
				var datavalue = new google.visualization.DataTable();
				//datavalue.addColumn('string', 'Approve');
				
				datavalue.addColumn('string', 'Code');
				//datavalue.addColumn('string', 'Approve');
				
				datavalue.addColumn('string', 'Line Type');
				datavalue.addColumn('number', 'Quantity');
				datavalue.addColumn('string', 'Uom');
				
				datavalue.addColumn('number', 'Unit Cost');
				datavalue.addColumn('number', 'Estimate Cost');
				
				
				for (var i = 0; i < result.length; i++) {
						var data = result[i];
						//datavalue.addRows([['<a href="LINK">Approve</a>'],[data[0], data[1],data[2]]]);
						//datavalue.addRows([[data[0],'<button>Approve</button>', data[1]]]);
						datavalue.addRows([[data[0],data[1],data[2],data[4],data[3],data[5]]]);
	    				
				}
				datavalue.setColumnProperty(1, {allowHtml: true});
				
				
				 
			     // Create a dashboard.
		        var dashboard = new google.visualization.Dashboard(
		            document.getElementById('dashboard_div'));

		        // Create a range slider, passing some options
		        var donutRangeSlider3 = new google.visualization.ControlWrapper({
		          'controlType': 'CategoryFilter',
		          'containerId': 'filter_div8',
		          'options': {
		        	'filterColumnLabel': 'Code'
		          }
		        });

		        
		        var table = new google.visualization.ChartWrapper({
			          'chartType': 'Table',
			          'containerId': 'estdetail_div',
			          'options': {
			            'width': 1000,
			            'height': 300,
			            'allowHtml': true,
			            'pieSliceText': 'value',
			            'legend': 'right',
			            'series': {
			                '1': {
			                    // set the color to change to
			                    'color': '#d04200',
			                    // don't show this in the legend
			                    'visibleInLegend': false
			                }
			            }
			            
			          }
			        });
		       // table.getChart().hideColumns([1]);

		        // Establish dependencies, declaring that 'filter' drives 'pieChart',
		        // so that the pie chart will only display entries that are let through
		        // given the chosen slider range.
		        dashboard.bind(donutRangeSlider3, table);

		        // Draw the dashboard.
		        dashboard.draw(datavalue, {allowHtml: true});
		        
			}
		});
		
	}else{
		alert("Please select estimate number");
	}
	
}

          
function viewPrint(){
		if(estimateNoGloble){
			var url="downloadEstimateStdReport?estimateNo="+estimateNoGloble+"&costCenter="+costCenterNoGloble;
    	    var width = 1100;
    	    var height = 700;
    	    var left = parseInt((screen.availWidth/2) - (width/2));
    	    var top = parseInt((screen.availHeight/2) - (height/2));
    	    var windowFeatures = "width=" + width + ",height=" + height + 
    	    ",status,resizable,left=" + left + ",top=" + top +
    	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
    	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
    	    //myWindow.document.write("<p>This is 'MsgWindow'. I am 200px wide and 100px tall!</p>");

			
		}else{
			alert("Please select estimate number");
		}
		
	}


          
          
function approve(){
	if(approveEstimateNo != estimateNoGloble){

		if(estimateNoGloble){
			
			var r = confirm("You are going to approve estimate number :" + estimateNoGloble);
			if (r == true) {
				$.ajax({
					type : 'GET',
					url : "/MMS/approveStdEstimate?estimateNo="+ estimateNoGloble +"&deptId="+costCenterNoGloble,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						//drawDashboard();
						
					}
				});
				//
				//drawDashboardRefreash();
				approveEstimateNo=estimateNoGloble;
				
				alert("Successfully Done!!");	
				drawDashboard();
				refreashTable();
			} else {
	  			
			}
		}else{
			alert("Please select estimate number");
		}
	}else{
		alert("Estimate number is already approved");
	}
		
	}
  
  
  function reject(){
	  if(approveEstimateNo != estimateNoGloble){

		if(estimateNoGloble){
			
			var r = confirm("You are going to reject estimate number :" + estimateNoGloble);
			if (r == true) {
				$.ajax({
					type : 'GET',
					url : "/MMS/rejectStdEstimate?estimateNo="+ estimateNoGloble +"&deptId="+costCenterNoGloble,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						//drawDashboard();
						
					}
				});
				//
				//drawDashboardRefreash();
				approveEstimateNo=estimateNoGloble;
			
				alert("Successfully Done!!");	
				drawDashboard();
				refreashTable();
			} else {
	  			
			}
		}else{
			alert("Please select estimate number");
		}
	  }else{
			alert("Estimate number is already rejected");
		}
		
		
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


								
								<!-- <div class="col-sm-10" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
								</div>
 -->								
								<!-- <div class="col-sm-12" align="left">

									<div class="row">

										<div id="filter_div"></div>
      
									</div>
								</div>
 -->																
																
								 								
								
								<!-- <div class="col-sm-12" align="left">
																
								<div class="form-group">
<div class="pull-left">
<table>
<tr>
<td><input type="text" id ="txtEstNo" style="background-color:#FCA2A8;" Value="Estimate No to be Approved" class="form-control" disabled/></td>
<td><input type="hidden" id ="txtCostCenter" Value="Estimate No to be Approved" class="form-control" disabled/></td>

</tr>
<tr>
<td><input type="submit" id ="btnApprove" Value="Approve" class="btn btn-success" onClick="approve()"/></td>
<td><input type="text" id ="txtReason" Value="Reason" class="form-control"/></td>

<td><input type="submit" id ="btnReject" Value="Reject" class="btn btn-success" onClick="reject()" /></td>
<td><input type="submit" id ="btnViewMore" Value="View More" class="btn btn-warning" onClick="viewMore()" /></td>
<td><input type="submit" id ="btnViewPrint" Value="View Estimate Print Out" class="btn btn-success" onClick="viewPrint()" /></td>

</tr>
</table>
</div>
</div>
</div>

 -->
													
								
								
								

						<!-- 	</div>
						</div>
					</div> -->



					<div class="container">

<div class="col-sm-12" align="left">

									<div class="row">

										<div id="filter_div2"></div>
      
									</div>
								</div>

						<div class="row">
							<div class="col-lg-12">

								<div class="row">
									
									
									<div class="col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
												<center>
													<i class="fa fa-cubes" style="color: #008080"></i>
												</center>
												<h4>
													  						
															<strong>Est. Approval Summary</strong>
																				
														
												</h4>
												<div style="height: 220px">
													<div id="dashboard_div">
      <!--Divs that will hold each control and chart-->
      <div id="estapr_div"></div>

												</div>
												
											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div>
</div>

<div class="col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
												<center>
													<i class="fa fa-cubes" style="color: #008080"></i>
												</center>
												<h4>
													  						
															<strong>Est. Approval Info</strong>
																				
														
												</h4>
												<div style="height: 220px">
													<div id="dashboard_div">
      <!--Divs that will hold each control and chart-->
      <div id="estaprtable_div"></div>

												</div>
												
											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div>
</div>

<%-- <div class="col-lg-4 col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
												<center>
													<i class="fa fa-cubes" style="color: #008080"></i>
												</center>
												<h4>
													  						
															<strong>Approval Detail</strong>
																				
														
												</h4>
												<div style="height: 220px">
													<div id="dashboard_div">
      <!--Divs that will hold each control and chart-->
      <div id="estaprtabledetail_div"></div>
<button style=" width: 90px; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px;background-color: #F1948A; border-radius: 5px;" value="Approve" onClick="approve()"> Approve</button>
												<button style=" width: 90px; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px;background-color: #F1948A; border-radius: 5px;"  value="Reject" onClick="reject()">Reject</button> 
												
												</div>
												
											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div>
</div>
 --%>
									
								

						</div>
							</div>
						</div>
						
						
						<div class="col-sm-12" align="left">
						
						
									<div class="row">

										<div id="filter_div3"></div>
      
									</div>
								

									<div id="dashboard_div">
      <!--Divs that will hold each control and chart-->
      <div id="estaprtabledetail_div"></div>
      <input type="text" id ="txtEstNo" style="background-color:#FCA2A8;" Value="Estimate Number to be Approved" class="form-control" disabled/>
<input type="hidden" id ="txtCostCenter" Value="Estimate No to be Approved" class="form-control" disabled/>
<input type="submit" id ="btnApprove" Value="Approve" class="btn btn-success" onClick="approve()"/>
<input type="text" id ="txtReason" Value="Reason" class="form-control"/>
<input type="submit" id ="btnReject" Value="Reject" class="btn btn-success" onClick="reject()" />
<!-- <input type="submit" id ="btnViewMore" Value="View More" class="btn btn-warning" onClick="viewMore()" />
<input type="submit" id ="btnViewPrint" Value="View Estimate Print Out" class="btn btn-success" onClick="viewPrint()" />
 -->      

												</div>
								</div>
								
								<div class="col-sm-12" align="left">

									<div class="row">

										<div id="filter_div8"></div>
      
									</div>
								</div>
								
								<div class="col-sm-12" align="left">

									<div id="dashboard_div">
      <div id="estdetail_div"></div>

												</div>
								</div>
								
						
					</div>



				</div>
			</div>
		</div>
	</div>
	<%@ include file="sections/footer.jsp"%>
	<%@ include file="sections/global_scripts.jsp"%>
	
	
	
	
	
</body>
</html>