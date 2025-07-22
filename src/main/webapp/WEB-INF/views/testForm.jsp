<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"-->
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>MV-MMS</title>
	
	<!-- bootstrap -->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>"/>
	
	<!-- RTL support - for demo only -->
	<script src="<c:url value="/resources/js/demo-rtl.js"/>">
	</script>
	<!-- 
	If you need RTL support just include here RTL CSS file <link rel="stylesheet" type="text/css" href="css/libs/bootstrap-rtl.min.css" />
	And add "rtl" class to <body> element - e.g. <body class="rtl"> 
	-->
	
	<!-- libraries -->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/libs/font-awesome.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/libs/nanoscroller.css"/>"/>

	<!-- global styles -->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/compiled/theme_styles.css"/>"/>

	<!-- this page specific styles -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/libs/fullcalendar.css"/>"/>
    <link rel="stylesheet" type="text/css" media="print" href="<c:url value="/resources/css/libs/fullcalendar.print.css" />"/>
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/resources/css/compiled/calendar.css" />"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/libs/morris.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/libs/daterangepicker.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/libs/jquery-jvectormap-1.2.2.css"/>"/>
	
	<!-- Favicon -->
	<link type="image/x-icon" href="favicon.png" rel="shortcut icon" />

	<!-- google font libraries -->
	<link href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700,300|Titillium+Web:200,300,400' rel='stylesheet' type='text/css'>

	<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<script src="js/respond.min.js"></script>
	<![endif]-->
	<script type="text/javascript">
	
	$(document).ready(function() {
 
		$('#submitForm').submit(function(e) {
			var frm = $('#submitForm');
			e.preventDefault();
 
		    var data = {}
		    var Form = this;
 
		    //Gather Data also remove undefined keys(buttons)
		    $.each(this, function(i, v){
		            var input = $(v);
		        data[input.attr("id")] = input.val();
		        delete data["undefined"];
		    });
        $.ajax({
            contentType : 'application/json; charset=utf-8',
            type: frm.attr('method'),
            url: frm.attr('action'),
            dataType : 'json',
            data : JSON.stringify(data),
            success : function(callback){
            	alert("Response: id: "+callback.id+"name: "+callback.name);
                $(this).html("Success!");
            },
            error : function(){
                $(this).html("Error!");
            }
        });
		});
	});
</script>
</head>
<body>
<div id="theme-wrapper">
		<header class="navbar" id="header-navbar">
			<div class="container">				
				<div class="clearfix">
				<button class="navbar-toggle" data-target=".navbar-ex1-collapse" data-toggle="collapse" type="button">
					<span class="sr-only">Toggle navigation</span>
					<span class="fa fa-bars"></span>
				</button>
				
				<div class="nav-no-collapse navbar-left pull-left hidden-sm hidden-xs">
					<ul class="nav navbar-nav pull-left">
						<li>
							<a class="btn" id="make-small-nav">
								<i class="fa fa-bars"></i>
							</a>
						</li>
					</ul>
				</div>

				<div class="nav-no-collapse pull-right" id="header-nav">
					<ul class="nav navbar-nav pull-right">
						<li class="mobile-search">
							<a class="btn">
								<i class="fa fa-search"></i>
							</a>

							<div class="drowdown-search">
								<form role="search">
									<div class="form-group">
										<input type="text" class="form-control" placeholder="Search...">
										<i class="fa fa-search nav-search-icon"></i>
									</div>
								</form>
							</div>

						<li class="hidden-xxs">
							<a class="btn" href="WelcomeMMS">
								<i class="fa fa-power-off"></i>
							</a>
						</li>
					</ul>
				</div>
				</div>
			</div>
		</header>
		<div id="page-wrapper" class="container">
			<div class="row">
				<div id="nav-col">
					<section id="col-left" class="col-left-nano">
						<div id="col-left-inner" class="col-left-nano-content">
							<div id="user-left-box" class="clearfix hidden-sm hidden-xs">
								<img alt="" src="<c:url value="/resources/img/samples/user.png"/>"/>
								<div class="user-box">
									<span class="name">
										Welcome<br/>
										User
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
											<i class="fa fa-pencil"></i>
											<span>Add Admin: Units</span>
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
											
											<li class="active">
												<a href="addCSC">
													Add CSC
												</a>
											</li>
										</ul>
									</li>
									
									<li>
										<a href="#" class="dropdown-toggle">
											<i class="fa fa-table"></i>
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
													Add Earth Con: type
												</a>
											</li>
											
											<li>
												<a href="addInsulatorType">
													Add Insulator type
												</a>
											</li>
											
											<li>
												<a href="addTowerConfig">
													Add Tower Config:
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
											<i class="fa fa-pencil"></i>
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
											<i class="fa fa-pencil"></i>
											<span>Add Mainten: Data</span>
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
										<a href="MMS_Map">
											<i class="fa fa-map-marker"></i>
											<span>View Map</span>
										</a>
									</li>
									
									<li>
										<a href="addUser">
											<i class="fa fa-user"></i>
											<span>Add User</span>
										</a>
									</li>
									
								</ul>
							</div>

						</div>
					</section>
				</div>
				<div id="content-wrapper">

					<div class="row">
						<div class="col-lg-6">
							<div class="main-box">
								<header class="main-box-header clearfix">
									<h2>Add CSC</h2>
								</header>

								<div class="main-box-body clearfix">
									<form:form role="form" commandName="user" action="submitForm.web" method="post" id="submitForm">
										
										<div class="form-group">
											<label for="txtId">ID :
											<form:input type="text" path="id" class="form-control" id="txtId" placeholder="Enter id"/></label>
										</div>
										
										<div class="form-group">
											<label for="txtCSCName">Name :
											<form:input type="text" path="name" class="form-control" id="txtCSCName" placeholder="Enter CSC"/>
											<span id="spnCSCName" class="label label-danger"></span></label>
										</div>
										
										<!--div class="form-group">
											<div class="pull-left">
												<input type="button" class="btn btn-success" onclick="saveData()">Save</button>
												<button type="button" class="btn btn-warning" onclick="clearForm()">Clear</button>
											</div>
										</div-->
										
										<fieldset style="width: 300px;">
											<input id="submitId" type="submit" value="Submit Form">
										</fieldset>
		
									</form:form>
								</div>
							</div>
						</div>

					</div>
					
					<div class="row">
								<div class="col-lg-12">
									<div class="main-box clearfix">
										<header class="main-box-header clearfix">
											<h2 class="pull-left">CSC List</h2>
										</header>
										
										<div class="main-box-body clearfix">
											<div class="table-responsive">
                            					<table class="table table-responsive" id="tblAdmin">
													<thead>
														<tr>
                                                                                                                         
															<th class="text-center">ID</th>
															<th class="text-center">Name</th>
															<th class="text-center">Area</th>
															<th class="text-center" data-orderable="false"></th>
															
														</tr>
													</thead>
													<tbody>
														
													</tbody>
												</table>
											</div>
											
										</div>
									</div>
								</div>
							</div>
					

					<footer id="footer-bar" class="row">
						<p id="footer-copyright" class="col-xs-12">
							&copy; 2017 CEB MV - MMS
						</p>
					</footer>
				</div>
			</div>
		</div>
	</div>

	<!-- global scripts -->
	<script src="<c:url value="/resources/js/demo-skin-changer.js"/>"> </script> <!-- only for demo -->
	
	<script src="<c:url value="/resources/js/jquery.js"/>"> </script>
	<script src="<c:url value="/resources/js/bootstrap.js"/>"> </script>
	<script src="<c:url value="/resources/js/jquery.nanoscroller.min.js"/>"> </script>
	
	<script src="<c:url value="/resources/js/demo.js"/>"> </script> <!-- only for demo -->
	
	<!-- this page specific scripts -->
	<script src="<c:url value="/resources/js/jquery-ui.custom.min.js"/>"> </script>
	<script src="<c:url value="/resources/js/fullcalendar.min.js"/>"> </script>
	<script src="<c:url value="/resources/js/jquery.slimscroll.min.js"/>"> </script>
	<script src="<c:url value="/resources/js/raphael-min.js"/>"> </script>
	<script src="<c:url value="/resources/js/morris.min.js"/>"> </script>
	<script src="<c:url value="/resources/js/moment.min.js"/>"> </script>
	<script src="<c:url value="/resources/js/daterangepicker.js"/>"> </script>
	<script src="<c:url value="/resources/js/jquery-jvectormap-1.2.2.min.js"/>"> </script>
	<script src="<c:url value="/resources/js/jquery-jvectormap-world-merc-en.js"/>"> </script>
	<script src="<c:url value="/resources/js/gdp-data.js"/>"> </script>
	<script src="<c:url value="/resources/js/flot/jquery.flot.js"/>"> </script>
	<script src="<c:url value="/resources/js/flot/jquery.flot.min.js"/>"> </script>
	<script src="<c:url value="/resources/js/flot/jquery.flot.pie.min.js"/>"> </script>
	<script src="<c:url value="/resources/js/flot/jquery.flot.stack.min.js"/>"> </script>
	<script src="<c:url value="/resources/js/flot/jquery.flot.resize.min.js"/>"> </script>
	<script src="<c:url value="/resources/js/flot/jquery.flot.time.min.js"/>"> </script>
	<script src="<c:url value="/resources/js/flot/jquery.flot.threshold.js"/>"> </script>
	<script src="<c:url value="/resources/js/jquery.countTo.js"/>"> </script>
	
	<!-- theme scripts -->
	<script src="<c:url value="/resources/js/scripts.js"/>"> </script>
	<script src="<c:url value="/resources/js/pace.min.js"/>"> </script>
	
	<!-- this page specific inline scripts -->
	<script>
	$(document).ready(function() {
		
		/* initialize the external events
		-----------------------------------------------------------------*/
	
		$('#external-events div.external-event').each(function() {
		
			// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
			// it doesn't need to have a start or end
			var eventObject = {
				title: $.trim($(this).text()) // use the element's text as the event title
			};
			
			// store the Event Object in the DOM element so we can get to it later
			$(this).data('eventObject', eventObject);
			
			// make the event draggable using jQuery UI
			$(this).draggable({
				zIndex: 999,
				revert: true,      // will cause the event to go back to its
				revertDuration: 0  //  original position after the drag
			});

		});
	</script>
	
</body>
</html>