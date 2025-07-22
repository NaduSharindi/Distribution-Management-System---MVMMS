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

                        <h1>Dashboard - DEO</h1>
                    </div>
                    
                    <%@ include file="sections/userDetails.jsp" %>
				                                	
					</div>
					<div class="row">
                            <div class="col-lg-12">                                                                                                   
                                        <div class="row">                                           
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square-o  yellow-bg"></i>
                                                            <span class="headline">Add Administrative</span>
                                                            <span class="value">
                                                                <a href="addProvince">Units</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-sliders  black-bg"></i>
                                                            <span class="headline">Add Line Master</span>
                                                            <span class="value">
                                                                <a href="addLineType">Data</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline">Add Line</span>
                                                            <span class="value">
                                                                <a href="addLine">Data</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  green-bg"></i>
                                                            <span class="headline">Add Support</span>
                                                            <span class="value">
                                                                <a href="addSupport">Data</a>
                                                            </span>
                                                    </div>
                                            </div>
                                                
                                        </div>
                                        
                                </div>

                            </div>
                            
                            <div class="row">
                            <div class="col-lg-12">                                                                                                   
                                        <div class="row">                                           
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square  lightsteelblue-bg"></i>
                                                            <span class="headline">Add Tower</span>
                                                            <span class="value">
                                                                <a href="towerMaintenance">Maintenance</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-map-marker  red-bg"></i>
                                                            <span class="headline">View Google</span>
                                                            <span class="value">
                                                                <a href="MMS_Map">Map</a>
                                                            </span>
                                                    </div>
                                            </div>

                                                
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