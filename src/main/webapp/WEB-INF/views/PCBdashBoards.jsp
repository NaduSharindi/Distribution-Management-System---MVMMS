<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>

	<c:when test="${sessionScope.deptId.equals('600.41')}">
		<c:redirect url="PCBdashboard"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('600.42')}">
		<c:redirect url="PCBdashboard"/>		
	</c:when>
	<c:otherwise>
		<c:redirect url="PCBdashboard"/>
	</c:otherwise>	
		
</c:choose>	