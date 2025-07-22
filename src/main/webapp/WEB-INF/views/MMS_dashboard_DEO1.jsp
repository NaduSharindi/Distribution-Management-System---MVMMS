<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<style>
body {
    font-family: "Lato", sans-serif;
}

.sidenav {
    width: 130px;
    position: fixed;
    z-index: 1;
    top: 20px;
    left: 10px;
    background: #eee;
    overflow-x: hidden;
    padding: 8px 0;
}

.sidenav a {
    padding: 6px 8px 6px 16px;
    text-decoration: none;
    font-size: 25px;
    color: #2196F3;
    display: block;
}

.sidenav a:hover {
    color: #064579;
}

.main {
    margin-left: 140px; /* Same width as the sidebar + left position in px */
    font-size: 28px; /* Increased text to enable scrolling */
    padding: 0px 10px;
}

@media screen and (max-height: 450px) {
    .sidenav {padding-top: 15px;}
    .sidenav a {font-size: 18px;}
}
</style>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<%@ include file="sections/head.jsp" %>
		<%@ include file="sections/dashboardCSS.jsp" %>	
</head>
<body>
<div id="theme-wrapper">
		<%@ include file="sections/header.jsp" %>
		
		<div id="page-wrapper" class="container1">
			<div class="row">
				
				<div id="sidenav">
	<section id="col-left" class="col-left-nano">
		<div id="col-left-inner" class="col-left-nano-content">
			<div id="user-left-box" class="clearfix hidden-sm hidden-xs">
				<img alt="" src="<c:url value="/resources/img/samples/user.png"/>"/>
				<div class="user-box">
					<span class="name">
						<p class="myCSS"> Welcome User<br/>
						${sessionScope.loggedUser}</p>
					</span>
					<span class="status">
						<i class="fa fa-circle"></i> Online
					</span>
				</div>
			</div>
			<div class="collapse navbar-collapse navbar-ex1-collapse" id="sidebar-nav">	
				<ul class="nav nav-pills nav-stacked">
					<li>
						<a href="dashboard">
							<i class="fa fa-dashboard"></i>
							<span>Dashboard</span>
							<!--<span class="label label-info label-circle pull-right">28</span>-->
						</a>
					</li>
					
					<li>
						<a href="#" class="dropdown-toggle">
							<i class="fa fa-pencil-square-o"></i>
							<span>Add Administrative Units</span>
							<i class="fa fa-chevron-circle-right drop-icon"></i>
						</a>
						<ul class="submenu">
							<li>
								<a href="addProvince">
									Add Province
								</a>
							</li>
							
							<li>
								<a href="addArea">
									Add Area
								</a>
							</li>
							
							<li>
								<a href="addCSC">
									Add CSC
								</a>
							</li>
						</ul>
					</li>
					
					<li>
						<a href="#" class="dropdown-toggle">
							<i class="fa fa-sliders"></i>
							<span>Line Master Data</span>
							<i class="fa fa-chevron-circle-right drop-icon"></i>
						</a>
						<ul class="submenu">
					
							<li>
								<a href="addLineType">
									Add Line type
								</a>
							</li>
							
							<li>
								<a href="addSupportType">
									Add Support type
								</a>
							</li>
							
							<li>
								<a href="addConductorType">
									Add Conductor type
								</a>
							</li>
							
							<li>
								<a href="addEarthConType">
									Add Earth Conductor type
								</a>
							</li>
							
							<li>
								<a href="addInsulatorType">
									Add Insulator type
								</a>
							</li>
							
							<li>
								<a href="addTowerConfig">
									Add Tower Configuration
								</a>
							</li>
							
							<li>
								<a href="addTowerInsulator">
									Add Tower Insulator
								</a>
							</li>
							
							<li>
								<a href="addStatusType">
									Add Status Type
								</a>
							</li>
							
							<li>
								<a href="addStatus">
									Add Status
								</a>
							</li>

						</ul>
					</li>
					
					<li>
						<a href="#" class="dropdown-toggle">
							<i class="fa fa-tasks"></i>
							<span>Line & Support</span>
							<i class="fa fa-chevron-circle-right drop-icon"></i>
						</a>
						<ul class="submenu">
							<li>
								<a href="addLine">
									Add Line
								</a>
							</li>
							
							<li>
								<a href="addSupport">
									Add Support
								</a>
							</li>
						</ul>
					</li>
					
					<li>
						<a href="#" class="dropdown-toggle">
							<i class="fa fa-pencil-square"></i>
							<span>Add Maintenance Data</span>
							<i class="fa fa-chevron-circle-right drop-icon"></i>
						</a>
						<ul class="submenu">
							<li>
								<a href="towerMaintenance">
									Tower Maintenance
								</a>
							</li>
							
							<li>
								<a href="insulatorMaintenance">
									Insulator Maintenance
								</a>
							</li>
						</ul>
					</li>
						<li>
						<a href="#" class="dropdown-toggle">
							<i class="fa fa-retweet"></i>
							<span>View Line & Support</span>
							<i class="fa fa-chevron-circle-right drop-icon"></i>
						</a>
						<ul class="submenu">
							<li>
								<a href="viewLine">
									View Line
								</a>
							</li>
							
							<li>
								<a href="viewSupport">
									View Support
								</a>
							</li>
						</ul>
					</li>
					
					<!-- <li>
						<a href="MMS_Map">
							<i class="fa fa-map-marker"></i>
							<span>View Map</span>
						</a>
					</li>
					
					<li>
						<a href="GenerateReportNew">
							<i class="fa fa-table"></i>
							<span>Reports</span>
						</a>
					</li>-->
					
				</ul>
			</div>

		</div>
	</section>
</div>
				
				
				
				
				
				<div id="main">
				<div class="row">
				<div class="col-lg-12">		                                    
                    <div class="col-lg-9">
                        <ol class="breadcrumb">
                            <li><a href="#">Home</a></li>
                            <li class="active"><span>Dashboard</span></li>
                        </ol>



                        <h1>Dashboard - ${sessionScope.loggedUser} </h1>
                 </div>
                    
                    <%@ include file="sections/userDetails.jsp" %>
				                                	
					</div>
				</div>
				
				
              
				
				
				
			
			<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
<div class="container">    






                <div class="jumbotron">
                  <div class="row "style="background:#B0C4DE ";>
                  <br>
                      <div class="col-md-4 col-xs-12 col-sm-6 col-lg-4">
                          <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2800.42512224691!2d-75.68248158397887!3d45.42093097910055!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4cce050a6db98d73%3A0x1b0e6fa213d4aaeb!2sUniversity+Of+Ottawa!5e0!3m2!1sen!2sca!4v1452963363617" width="350px" height="280px" frameborder="4" style="border:3"marginheight="3px"  allowfullscreen></iframe> 
                      </div>
                     
                      <div class="col-md-8 col-xs-12 col-sm-6 col-lg-8">
                      	
                           <div class="col-md-4"style="background:#B0C4DE">
      <table align="right">
      <div style="overflow-x:auto;">
  <table class="table table-responsive">
    <tr>
      <th><i class="fa fa-bars" style="font-size:36px;color:red;"></i></th>
      <th>Lines</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      
    </tr>
    <tr >
      <td><i class="fa fa-calendar-o" style="font-size:36px;color:red;"></i></td>
      <td>length</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>57</td>
     
    </tr>
     <tr >
      <td><i class="fa fa-calendar-o" style="font-size:36px;color:red;"></i></td>
      <td>length</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      
    </tr>
    <tr >
      <td><i class="fa fa-cny" style="font-size:36px;color:black;"></i></td>
      <td>Towers</td>
      <td>94</td>
      <td>94</td>
      <td>94</td>
      <td>94</td>
      <td>94</td>
      <td>94</td>
      <td>94</td>
      <td>94</td>
      <td>94</td>
      
    </tr>
    <tr>
      <th><i class="fa fa-bars" style="font-size:36px;color:red;"></i></th>
      <th>Lines</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      
    </tr>
    
      
  </table>
</div>
</table>
</div> 
                          </div>
                           
                      </div>
                </div>

                
                
        							        <div class="row">
                            				<div class="col-lg-12">                                                                                                   
                                       		<div class="row">   
                                            <div class="col-lg-4 col-sm-6 col-xs-12">
                                                    <div class="wrimagecard wrimagecard-topimage">
                                                            <div class="wrimagecard-topimage_header" style="background-color: rgba(255,0,0,0.3)">
            												<center><i class = "fa fa-cubes" style="color:#DC143C"></i></center>
            												<h4><a href="addLineType"><center><strong>Divisional Information</strong></center></a></h4>
            										
          													</div>
          													<h4>My Web Page</h4>

<div id="piechart"></div>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
// Load google charts
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
function drawChart() {
  var data = google.visualization.arrayToDataTable([
  ['Task', 'Hours per Day'],
  ['Work', 8],
  ['Eat', 2],
  ['TV', 4],
  ['Gym', 2],
  ['Sleep', 8]
]);

  // Optional; add a title and set the width and height of the chart
  var options = {'title':'My Average Day', 'width':260, 'height':212, };

  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
  chart.draw(data, options);
}
</script>
          											<div class="wrimagecard-topimage_title">
            										<div class="pull-right badge" id="WrControls"></div>
         											 </div>
                            						</div>
                                            		</div>
                                            <div class="col-lg-4 col-sm-6 col-xs-12">
                                                    <div class="wrimagecard wrimagecard-topimage">
                                                            <div class="wrimagecard-topimage_header" style="background-color: #a9a9a9">
            												<center><i class = "fa fa-cubes" style="color:#008080"></i></center>
            												<h4><a href="addLineType"><center><strong>Divisional Information</strong></center></a></h4>
            										
          <h4>Responsive Table</h4>
          <div style="overflow-x:auto;">
  <table class="table table-responsive">
    <tr>
      <th>First Na</th>
      <th>Last Na</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
      <th>Points</th>
    </tr>
    <tr >
      <td>Jille</td>
      <td>Smith</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
      <td>50</td>
    </tr>
    <tr >
      <td>Eve</td>
      <td>Jackson</td>
      <td>94</td>
      <td>94</td>
      <td>94</td>
      <td>94</td>
      <td>94</td>
      <td>94</td>
      <td>94</td>
      <td>94</td>
      <td>94</td>
      <td>94</td>
      <td>94</td>
    </tr>
    <tr >
      <td>Adam</td>
      <td>Johnson</td>
      <td>67</td>
      <td>67</td>
      <td>67</td>
      <td>67</td>
      <td>67</td>
      <td>67</td>
      <td>67</td>
      <td>67</td>
      <td>67</td>
      <td>67</td>
      <td>67</td>
    </tr>
  </table>
</div>
          													</div>
          											<div class="wrimagecard-topimage_title">
            										<div class="pull-right badge" id="WrControls"></div>
         											 </div>
                                                            
                                                            
                                                    </div>
                                            </div>
                                            
                                             <div class="col-lg-4 col-sm-6 col-xs-12">
                                                    <div class="wrimagecard wrimagecard-topimage">
                                                            <div class="wrimagecard-topimage_header" style="background-color: rgba(0,255,0,0.3)">
            												<center><i class = "fa fa-cubes" style="color:	#B22222"></i></center>
            												<h4><a href="addLineType"><center><strong>Divisional Information</strong></center></a></h4>
            										
          													</div>
          											<div class="wrimagecard-topimage_title">
            										<div class="pull-right badge" id="WrControls"></div>
         											 </div>
                                                            
                                                            
                                                    </div>
                                            </div>
										
                                                            
                                                            
                                              
                                              
                                                    
                                            </div>
                                            
                                            
                                            </div>
                                            </div>
                                           
                                           
                                           
       <!--                                     <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-table  black-bg"></i>
                                                            <span class="headline"></span>
                                                            <span class="value">
                                                                <a href="viewDataMV">P&E Summary</a>
                                                            </span>
                                                    </div>
                                            </div>
                                                     
                                                     
                                                     <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-table  black-bg"></i>
                                                            <span class="headline"></span>
                                                            <span class="value">
                                                                <a href="viewTLMaintenance">Schedules and Reports</a>
                                                            </span>
                                                    </div>
                                            </div> -->                                           
                                           <!--  <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-cubes  emerald-bg"></i>
                                                            <span class="headline">View</span>
                                                            <span class="value">
                                                                <a href="viewDD">Units</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-table  black-bg"></i>
                                                            <span class="headline">View</span>
                                                            <span class="value">
                                                                <a href="viewDataMV">Data(MV)</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            
                                                
                                        </div>
                                        
                                </div>

                            </div>-->
                            
                            <!--  <div class="row">
                            <div class="col-lg-12">                                                                                                   
                                        <div class="row"> 
                                          <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-map-marker  red-bg"></i>
                                                            <span class="headline"></span>
                                                            <span class="value">
                                                                <a href="viewSupportByProvince">Map View</a>
                                                            </span>
                                                    </div>
                                            </div>-->
                                         <!--    <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-info-circle  emerald-bg"></i>
                                                            <span class="headline"></span>
                                                            <span class="value">
                                                                <a href="MMS_Map">Activity Request</a>
                                                            </span>
                                                    </div>
                                            </div>-->  
                                            
                                        <!--     <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-retweet  purple-bg"></i>
                                                            <span class="headline">View</span>
                                                            <span class="value">
                                                                <a href="viewLine">Tower Line</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-retweet  green-bg"></i>
                                                            <span class="headline">View</span>
                                                            <span class="value">
                                                                <a href="viewSupport">Support</a>
                                                            </span>
                                                    </div>
                                            </div>    
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline"></span>
                                                            <span class="value">
                                                                <a href="addLine">Add Line</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  green-bg"></i>
                                                            <span class="headline"></span>
                                                            <span class="value">
                                                                <a href="addSupport">Add Support</a>
                                                            </span>
                                                    </div>
                                            </div>   -->                                 
                                           <!--  <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-sliders  yellow-bg"></i>
                                                            <span class="headline">View Tower </span>
                                                            <span class="value">
                                                                <a href="viewTowerMaintenance">Maintenance</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square-o lightsteelblue-bg"></i>
                                                            <span class="headline">Create Maintenance</span>
                                                            <span class="value">
                                                                <a href="#">Estimate</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-map-marker  red-bg"></i>
                                                            <span class="headline">View Google </span>
                                                            <span class="value">
                                                                <a href="MMS_Map">Map</a>
                                                            </span>
                                                    </div>
                                            </div>-->
                                            
                                        </div>
                                        
                                </div>

                            </div>
                            
                            
                         <!--    <div class="row">
                            <div class="col-lg-12">                                                                                                   
                                        <div class="row"> 
                                          <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-map-marker  red-bg"></i>
                                                            <span class="headline"></span>
                                                            <span class="value">
                                                                <a href="viewSupportByProvince">Map View</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-info-circle  emerald-bg"></i>
                                                            <span class="headline"></span>
                                                            <span class="value">
                                                                <a href="MMS_Map">Activity Request</a>
                                                            </span>
                                                    </div>
                                            </div> --> 
                                            
                                                                             
                                           <!--  <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-sliders  yellow-bg"></i>
                                                            <span class="headline">View Tower </span>
                                                            <span class="value">
                                                                <a href="viewTowerMaintenance">Maintenance</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square-o lightsteelblue-bg"></i>
                                                            <span class="headline">Create Maintenance</span>
                                                            <span class="value">
                                                                <a href="#">Estimate</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-map-marker  red-bg"></i>
                                                            <span class="headline">View Google </span>
                                                            <span class="value">
                                                                <a href="MMS_Map">Map</a>
                                                            </span>
                                                    </div>
                                            </div>-->
                                            
                                        </div>
                                        
                                </div>

                            </div>
                            
                            
                        </div>
					
					
						</div>
					</div>
				</div>
				
				
			</div>
			
		<%@ include file="sections/global_scripts.jsp" %>
		
	</body>
</html>