<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@ include file="sections/head.jsp" %>
		<%@ include file="sections/dashboardCSS.jsp" %>	
</head>
<body>
<div id="theme-wrapper">
		<%@ include file="sections/header.jsp" %>
		
		<div id="page-wrapper" class="container">
			<div class="row">
				
				<%@ include file="sections/userLevels.jsp" %>
				
				<div id="content-wrapper">
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
					<div class="row">
                            <div class="col-lg-12">                                                                                                   
                                        <div class="row">   
                                        <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-cubes  emerald-bg"></i>
                                                            <span class="headline"></span>
                                                            <span class="value">
                                                                <a href="viewDD">Divisional Information</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
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
                                            </div>                                            
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
                                            </div>-->
                                            
                                            
                                                
                                        </div>
                                        
                                </div>

                            </div>
                            
                            <div class="row">
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
                                            </div>  
                                            
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
                            
                            
                            <div class="row">
                            <div class="col-lg-12">                                                                                                   
                                        <div class="row"> 
                                         <!-- <div class="col-lg-3 col-sm-6 col-xs-12">
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
                                            
                                           <!--     <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline">Add</span>
                                                            <span class="value">
                                                                <a href="addLine">Tower Line</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  green-bg"></i>
                                                            <span class="headline">Add</span>
                                                            <span class="value">
                                                                <a href="addSupport">Support</a>
                                                            </span>
                                                    </div>
                                            </div>  
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
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
                            
                            
                        </div>
					

					<%@ include file="sections/footer.jsp" %>

						</div>
					</div>
				</div>
			</div>
			
		<%@ include file="sections/global_scripts.jsp" %>
		
	</body>
</html>