<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="<c:url value="/resources/css/ebems.css"/>"/>
<title>Electricity Breakdown Evaluation Management System</title>
</head>
<header>
<img class="imgceb" src="<c:url value="/resources/images/HomeEbem.png"/>"  />
<h1>Electricity Breakdown Evaluation Management System</h1>
<c:if test="${pageContext.request.userPrincipal.name == null}">
		<h2 class="headalign">
			Welcome :  | <a href="<c:url value='/login' />"> Login</a>
		</h2>
</c:if>
</header>
<body  onload='document.loginForm.username.focus();'>
	<div id="login-box">
		<h2 class="headalign">Login with Username and Password</h2>

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
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
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

</body>
</html>