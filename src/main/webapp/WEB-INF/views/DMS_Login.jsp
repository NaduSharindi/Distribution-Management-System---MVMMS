<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta charset="UTF-8" />

<style type="text/css">
a:link {
  color: blue;
}

.btnnw{
  background-color: #e8cc3f;
  border: none;
  color: #5e0303;
  padding: 11px 120px;
  text-align: center;
  font-weight : bold;
  border-radius : 4px;
  text-decoration: none;
  display: inline-block;
  font-size: 17px;
  margin: 4px 2px;
  cursor: pointer;
}

.btnnw:hover{
  background-color: #5e0303;
  color : white;
  }


</style>

<title>MMS Login</title>
	
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

	<!-- google font libraries -->
	<link rel='stylesheet' type='text/css' href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700,300|Titillium+Web:200,300,400'>
	
	<!-- Favicon -->
	<link type="image/x-icon" rel="shortcut icon" href="favicon.png" />

	<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<script src="js/respond.min.js"></script>
	<![endif]-->
	
	<script type="text/javascript">
		function formSubmit()
		{
			document.loginForm.submit();
			
			//document.getElementById("un").innerHTML = ${message};
            //ScrollToElement("un");
		}
	</script>
</head>

<body id="login-page-full">
	<div id="login-full-wrapper">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div id="login-box">
						<div id="login-box-holder">
							<div class="row">
								<div class="col-xs-12">
									<header id="login-header">
										<div id="login-logo">
											<img src="<c:url value="/resources/img/CEBImages/CEB_Logo.png"/>"/>
											<p>MAINTENANCE MANAGEMENT SYSTEM</p>
											
										</div>
									</header>
									<div id="login-box-inner">
										<form:form role="form" name="loginForm" id="loginForm" method="POST" action="login">
											<center>
<div class="form-group">
<input name="loginUser" class="form-control" type="text" placeholder="User Name">
<span class="label label-danger">${errUser}</span>

</div>
<div class="form-group">
<input name="password" type="password" class="form-control" placeholder="Password">
<span class="label label-danger">${errPassword}</span>
</div>
</center>
<div id="remember-me-wrapper">
												<div class="row">
													<div class="col-xs-6">
														<div class="checkbox-nice">
															<input type="checkbox" id="remember-me" checked="checked" />
															<label for="remember-me">
																Remember me
															</label>
														</div>
													</div>
													<a href="http://help.mms.ceb/" id="login-forget-link" class="col-xs-6">
														Need Help?
													</a>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-12">
													<button type="submit" class="btn btnnw col-xs-12" href="javascript:formSubmit()">Login</button>
												</div>
												
											</div>
											
										</form:form>
									</div>
								</div>
							</div>
						</div>
						
						 <!-- <div id="login-box-footer">
							<div class="row">
								<div class="col-xs-12">
									 
									<a href="http://help.mms.ceb/">
										Help
									</a>
								</div>
							</div>
						</div> --> 
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="config-tool" class="closed">
		<a id="config-tool-cog">
			<i class="fa fa-cog"></i>
		</a>
		
		<div id="config-tool-options">
			<h4>Layout Options</h4>
			<ul>
				<li>
					<div class="checkbox-nice">
						<input type="checkbox" id="config-fixed-header" />
						<label for="config-fixed-header">
							Fixed Header
						</label>
					</div>
				</li>
				<li>
					<div class="checkbox-nice">
						<input type="checkbox" id="config-fixed-sidebar" />
						<label for="config-fixed-sidebar">
							Fixed Left Menu
						</label>
					</div>
				</li>
				<li>
					<div class="checkbox-nice">
						<input type="checkbox" id="config-fixed-footer" />
						<label for="config-fixed-footer">
							Fixed Footer
						</label>
					</div>
				</li>
				<li>
					<div class="checkbox-nice">
						<input type="checkbox" id="config-boxed-layout" />
						<label for="config-boxed-layout">
							Boxed Layout
						</label>
					</div>
				</li>
				<li>
					<div class="checkbox-nice">
						<input type="checkbox" id="config-rtl-layout" />
						<label for="config-rtl-layout">
							Right-to-Left
						</label>
					</div>
				</li>
			</ul>
			<br/>
			<h4>Skin Color</h4>
			<ul id="skin-colors" class="clearfix">
				<li>
					<a class="skin-changer" data-skin="" data-toggle="tooltip" title="Default" style="background-color: #34495e;">
					</a>
				</li>
				<li>
					<a class="skin-changer" data-skin="theme-white" data-toggle="tooltip" title="White/Green" style="background-color: #2ecc71;">
					</a>
				</li>
				<li>
					<a class="skin-changer blue-gradient" data-skin="theme-blue-gradient" data-toggle="tooltip" title="Gradient">
					</a>
				</li>
				<li>
					<a class="skin-changer" data-skin="theme-turquoise" data-toggle="tooltip" title="Green Sea" style="background-color: #1abc9c;">
					</a>
				</li>
				<li>
					<a class="skin-changer" data-skin="theme-amethyst" data-toggle="tooltip" title="Amethyst" style="background-color: #9b59b6;">
					</a>
				</li>
				<li>
					<a class="skin-changer" data-skin="theme-blue" data-toggle="tooltip" title="Blue" style="background-color: #2980b9;">
					</a>
				</li>
				<li>
					<a class="skin-changer" data-skin="theme-red" data-toggle="tooltip" title="Red" style="background-color: #e74c3c;">
					</a>
				</li>
				<li>
					<a class="skin-changer" data-skin="theme-whbl" data-toggle="tooltip" title="White/Blue" style="background-color: #3498db;">
					</a>
				</li>
			</ul>
		</div>
	</div>
	
	<!-- global scripts -->
	<script src="<c:url value="/resources/js/demo-skin-changer.js"/>"> </script> <!-- only for demo -->
	
	<script src="<c:url value="/resources/js/jquery.js"/>"> </script>
	<script src="<c:url value="/resources/js/bootstrap.js"/>"> </script>
	<script src="<c:url value="/resources/js/jquery.nanoscroller.min.js"/>"> </script>
	
	<script src="<c:url value="/resources/js/demo.js"/>"> </script> <!-- only for demo -->
	
	<!-- this page specific scripts -->

	
	<!-- theme scripts -->
	<script src="<c:url value="/resources/js/scripts.js"/>"></script>
	
	<!-- this page specific inline scripts -->

</body>
</html>