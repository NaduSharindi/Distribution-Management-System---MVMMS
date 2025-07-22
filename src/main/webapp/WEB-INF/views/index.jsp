<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login!!!</title>


<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/login_style.css"/>" />

<script type="text/javascript">
function formSubmit()
{
	document.loginForm.submit();
}
</script>
</head>

<body>
	<body>
		<div class="tblInner">
			<div class="tblHeader">
				<img src="<c:url value="/resources/image/header.jpg"/>" />
			</div>
		</div>
		<div class="loginTblBody">
			<div class="body-screen">
				<div class="login">
					<div class="login-screen">
						<div class="app-title">
							<h1>Login</h1>
							<form:form name="loginForm" id="loginForm" method="POST"
								action="admin/login">
								<div class="login-form">
									<div class="control-group">
										<input name="loginUser" type="text" class="login-field"
											value="" placeholder="username" id="login-name"> <label
											class="login-field-icon fui-user" for="login-name"></label>
									</div>

									<div class="control-group">
										<input name="password" type="password" class="login-field"
											value="" placeholder="password" id="login-pass"> <label
											class="login-field-icon fui-lock" for="login-pass"></label>
									</div>

									<a class="btn btn-primary btn-large btn-block"
										href="javascript:formSubmit()">login</a>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="tblFooter">
			<div class="footer-screen">Coyright 2016. All right reserved.
				Ceylon Electricity Board - IT Branch</div>
		</div>
	</body>
</body>
</html>
