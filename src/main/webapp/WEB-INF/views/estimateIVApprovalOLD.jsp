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
function drawDashboard() {
	 // alert("hii");
   	  $.ajax({
			type : 'GET',
			url : "/MMS/getIVDetailsCount",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				var datavaluepie = new google.visualization.DataTable();
				datavaluepie.addColumn('string', 'DOC PF');
				datavaluepie.addColumn('number', 'DOC COUNT');
				datavaluepie.addColumn('string', 'ISSUE TO');
				datavaluepie.addColumn('string', 'UNIT NAME');
				datavaluepie.addColumn('string', 'DEPT ID');
				
				for (var i = 0; i < result.length; i++) {
						var data = result[i];
						var isseTo = issueTo(data[4]);
						datavaluepie.addRows([[data[3],data[0],isseTo,data[1], data[2]]]);
				}
				
				 
			     // Create a dashboard.
		        var dashboard = new google.visualization.Dashboard(
		            document.getElementById('dashboard_div'));

		        // Create a range slider, passing some options
		        var donutRangeSlider3 = new google.visualization.ControlWrapper({
		          'controlType': 'CategoryFilter',
		          'containerId': 'filter_div4',
		          'options': {
		        	'filterColumnLabel': 'ISSUE TO'
		          }
		        });
		        
		        var donutRangeSlider2 = new google.visualization.ControlWrapper({
			          'controlType': 'CategoryFilter',
			          'containerId': 'filter_div2',
			          'options': {
			        	'filterColumnLabel': 'DOC PF'
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
 dashboard.bind(donutRangeSlider3, pieChart);
		        
		        dashboard.bind(donutRangeSlider3, table);
		       
		        
		        dashboard.draw(datavaluepie);
		        
		        google.visualization.events.addListener(table, 'select', selectHandler);
 		        function selectHandler() {
		          //alert("hiii");
		          var selectedItem = table.getChart().getSelection();
		          
		          if (selectedItem) {
		        	 // alert("hiii2");
		             var row = selectedItem[0].row;
   		         var costCenterNo = table.getDataTable().getValue(row, 3);
   		        		            
   		    	    $.ajax({
			type : 'GET',
			url : "/MMS/getIVDetails",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				var datavaluepie = new google.visualization.DataTable();
				datavaluepie.addColumn('string', 'DOC NO');
				datavaluepie.addColumn('string', 'ISSUE TO');
				datavaluepie.addColumn('string', 'DOC PF');
				
				datavaluepie.addColumn('string', 'UNIT NAME');
				datavaluepie.addColumn('string', 'DEPT ID');
				
				for (var i = 0; i < result.length; i++) {
						var data = result[i];
						var isseTo = issueTo(data[4]);
						datavaluepie.addRows([[data[0],isseTo,data[3],data[1], data[2]]]);
				}
				
				
				 
			     // Create a dashboard.
		        var dashboard1 = new google.visualization.Dashboard(
		            document.getElementById('dashboard_div1'));

		        // Create a range slider, passing some options
		        var donutRangeSlider4 = new google.visualization.ControlWrapper({
		          'controlType': 'CategoryFilter',
		          'containerId': 'filter_div3',
		          'options': {
		        	'filterColumnLabel': 'DOC NO'
		          }
		        });
		        
		        
		       		        
		        var table = new google.visualization.ChartWrapper({
			          'chartType': 'Table',
			          'containerId': 'matdetail_div',
			          'options': {
			            'width': 1000,
			            'height': 300,
			            'pieSliceText': 'value',
			            'legend': 'right'
			          }
			        });
		        
		        dashboard1.bind(donutRangeSlider4, table);
		        dashboard1.draw(datavaluepie);
		        
		        
		        function selectHandler() {
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
		        google.visualization.events.addListener(table, 'select', selectHandler);
			}
			});    
   		    	    
		            
		            
		            
		          }
		         }

		        
		        
		        
		        	}
		});

	  
	  

	  
	      
     }
     
     
function issueTo(key){
	  switch (key) {
	case 1:
		return "Projects";			 
	case 2:
		return "Cost Center";			 
	case 3:
		return "Ware House";	
	case 4:
		return "Purchase Contract";	
	case 5:
		return "My Project";
	case 6:
		return "Section";	
	default:
		return "Other";
		 
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


								<div class="col-sm-2" align="left">
									<div class="row">
										<div class="col-sm-12" align="left">

									<div class="row">

										<div id="filter_div3"></div>
      
									</div>
								</div>
								
																
																
								<div class="col-sm-12" align="left">

									<div id="dashboard_div1">
      <!--Divs that will hold each control and chart-->
      <div id="matdetail_div"></div>

												</div>
								</div>
								
																
								<div class="form-group">
<div class="pull-left">
<table>
<tr>
<td>
<input type="submit" id ="btnApprove" Value="Approve" class="btn btn-success" onClick="approve()"/></td>
<td><input type="text" id ="txtReason" Value="Reason" class="form-control"/></td>

<td><input type="submit" id ="btnReject" Value="Reject" class="btn btn-success" onClick="reject()" /></td>
</tr>
</table>
</div>
</div>
				<br><br>				
								<div class="col-sm-12" align="left">

									<div class="row">

										<div id="filter_div2"></div>
      
									</div>
								</div>
								
								<div class="col-sm-12" align="left">

									<div class="row">

										<div id="filter_div4"></div>
      
									</div>
								</div>
								
								
								
																
								

							</div>
						</div>
					</div>



					<div class="container">


						<div class="row">
							<div class="col-lg-12">

								<div class="row">
								
								
									
									<div class="col-lg-4 col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
												<center>
													<i class="fa fa-cubes" style="color: #008080"></i>
												</center>
												<h4>
													  						
															<strong>Inventory Approval Summary</strong>
																				
														
												</h4>
												<div style="height: 220px">
													<div id="dashboard_div">
      <!--Divs that will hold each control and chart-->
      <div id="psapr_div"></div>

												</div>
												
											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div>
</div>

<div class="col-lg-4 col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
												<center>
													<i class="fa fa-cubes" style="color: #008080"></i>
												</center>
												<h4>
													  						
															<strong>Inventory Approval Summary</strong>
																				
														
												</h4>
												<div style="height: 220px">
													<div id="dashboard_div">
      <!--Divs that will hold each control and chart-->
      <div id="psaprtable_div"></div>

												</div>
												
											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div>
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