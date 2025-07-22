<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="<c:url value="/resources/css/ebems.css"/>"/>
<title>Medium Voltage Maintenance Management System</title>
</head>
<center>
<div id="line">
<h2>Medium Voltage Maintenance Management System</h2>
</div>
</center>
<header align="middle" >
<img align="middle" style="width:100%;height:130px;"  src="<c:url value="/resources/images/Header.png"/>" />
</header>
<div id="line1">
</div>
<ul class="nav">
         <li class="nav li"><a href="<c:url value='/WelcomePage' />">Masters</a></li>
         
         
         
         
         <li class="nav li"><a href="<c:url value='/login' />">Login</a></li>
</ul>
<div id="line1">
</div>

<body onload='document.loginForm.username.focus();'>

<div id="login-box">
        <center>
		<h3>Login with Username and Password</h3>
        </center>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm'
		  action="<c:url value='j_spring_security_check' />" method='post'>

		  <table>
			<tr>
				<td><h4>User:</h4></td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td><h4>Password:</h4></td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="submit" /></td>
			</tr>
		  </table>

		  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		</form>
	</div>


<div id="footer" >
Copyright © CEB
</div>
</body>
</html>