
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="<c:url value="/resources/css/NewCss.css"/>"/>
<title>Insert title here</title>
</head>
<body>

<form:form method="post"  modelAttribute="Province" id="reg"	action="MMSAddProvince" >
	
	<table class ="tableWelcome" border="0">
		    
			<tr>
				<td width="198" align="left">ID</td>
				<td width="19"><div align="left">:</div></td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td align="left">Province</td>
				<td><div align="left">:</div></td>
				<td><form:input path="province" /></td>
			</tr>
						<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>
					<div align="left">
						<input type="submit" Value="Add" />
					</div>
				</td>
			</tr>
		</table>


	</form:form>



</body>
</html>
