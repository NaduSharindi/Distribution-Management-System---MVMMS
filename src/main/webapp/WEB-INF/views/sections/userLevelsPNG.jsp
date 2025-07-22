<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${sessionScope.loggedUserRole.equals('DGM')}">
		<%@ include file="user-levels/userPNG.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('CE')}">
		<%@ include file="user-levels/userPNG.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EE')}">
		<%@ include file="user-levels/userPNG.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES')}">
		<%@ include file="user-levels/userPNG.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DEO')}">
		<%@ include file="user-levels/userPNGDEO.jsp" %>
	</c:when>
	
	
	<c:otherwise>
		<%@ include file="user-levels/userPNG.jsp" %>
	</c:otherwise>	
</c:choose>	