<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('600.42')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('600.42')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('600.42')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('600.42')}">
		<%@ include file="user-levels/userES.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('600.42')}">
		<%@ include file="user-levels/userDEO.jsp" %>
	</c:when>
	
	<%-- <c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('600.42')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
		
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('600.42')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('600.42')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('600.42')}">
		<%@ include file="user-levels/userES.jsp" %>
	</c:when>
	 --%><c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('600.42')}">
		<%@ include file="user-levels/userDEOSUB.jsp" %>
	</c:when>
	
	
	
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('780.00')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('780.00')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('780.00')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('780.00')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('780.00')}">
		<%@ include file="user-levels/userES.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('780.00')}">
		<%@ include file="user-levels/userDEO.jsp" %>
	</c:when>
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('780.00')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('780.00')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('596.00')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('596.00')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('596.00')}">
		<%@ include file="user-levels/userES.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('596.00')}">
		<%@ include file="user-levels/userDEO.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('596.00')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	
	
	<c:otherwise>
		<%@ include file="user-levels/userAE.jsp" %>
	</c:otherwise>	
</c:choose>	