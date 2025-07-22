<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('600.41')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('440.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('440.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('440.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('440.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && sessionScope.deptId.equals('440.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && sessionScope.deptId.equals('440.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('440.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('440.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EEC') && sessionScope.deptId.equals('440.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('440.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && (sessionScope.deptId.equals('440.20') || sessionScope.deptId.equals('440.30'))}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && (sessionScope.deptId.equals('440.20') || sessionScope.deptId.equals('440.30'))}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && (sessionScope.deptId.equals('440.20') || sessionScope.deptId.equals('440.30'))}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && (sessionScope.deptId.equals('440.20') || sessionScope.deptId.equals('440.30'))}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && (sessionScope.deptId.equals('440.20') || sessionScope.deptId.equals('440.30'))}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && (sessionScope.deptId.equals('440.20') || sessionScope.deptId.equals('440.30'))}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DEO') && (sessionScope.deptId.equals('440.20') || sessionScope.deptId.equals('440.30'))}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EEC') && (sessionScope.deptId.equals('440.20') || sessionScope.deptId.equals('440.30'))}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	
	
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('501.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('501.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('501.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('501.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && sessionScope.deptId.equals('501.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && sessionScope.deptId.equals('501.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('501.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EEC') && sessionScope.deptId.equals('501.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	
	
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('490.60')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('490.60')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('490.60')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('490.60')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && sessionScope.deptId.equals('490.60')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && sessionScope.deptId.equals('490.60')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('490.60')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('490.60')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EEC') && sessionScope.deptId.equals('490.60')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('550.80')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('550.80')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('550.80')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('550.80')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && sessionScope.deptId.equals('550.80')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && sessionScope.deptId.equals('550.80')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('550.80')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('550.80')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EEC') && sessionScope.deptId.equals('550.80')}">
		<%@ include file="user-levels/userEM.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('460.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('460.23')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('460.23')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('460.23')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('460.23')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && sessionScope.deptId.equals('460.23')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && sessionScope.deptId.equals('460.23')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('460.23')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EEC') && sessionScope.deptId.equals('460.23')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('501.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('501.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('501.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('501.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && sessionScope.deptId.equals('501.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && sessionScope.deptId.equals('501.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('501.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('501.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('501.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('501.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('501.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && sessionScope.deptId.equals('501.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && sessionScope.deptId.equals('501.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('501.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('480.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('480.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('480.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('480.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && sessionScope.deptId.equals('480.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && sessionScope.deptId.equals('480.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('480.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('480.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('480.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('480.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('480.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && sessionScope.deptId.equals('480.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && sessionScope.deptId.equals('480.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('480.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('510.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('510.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('510.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('510.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && sessionScope.deptId.equals('510.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && sessionScope.deptId.equals('510.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('510.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('430.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('430.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('430.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('430.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && sessionScope.deptId.equals('430.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && sessionScope.deptId.equals('430.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('430.30')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('430.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('430.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('430.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('430.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && sessionScope.deptId.equals('430.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && sessionScope.deptId.equals('430.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('430.20')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('430.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('430.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('430.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('430.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('430.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && sessionScope.deptId.equals('430.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && sessionScope.deptId.equals('430.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('430.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('430.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('460.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('460.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('460.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('460.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && sessionScope.deptId.equals('460.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && sessionScope.deptId.equals('460.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('460.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EEC') && sessionScope.deptId.equals('460.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EEC') && sessionScope.deptId.equals('440.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('440.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('440.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('EEC') && sessionScope.deptId.equals('430.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('530.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('530.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('530.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('530.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && sessionScope.deptId.equals('530.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && sessionScope.deptId.equals('530.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('530.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EEC') && sessionScope.deptId.equals('530.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	
	
	
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('600.41')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('600.41')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('600.41')}">
		<%@ include file="user-levels/userES.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('600.41')}">
		<%@ include file="user-levels/userDEO.jsp" %>
	</c:when>
	
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('972.30')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('972.30')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('972.30')}">
		<%@ include file="user-levels/userEE.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('972.30')}">
		<%@ include file="user-levels/userES.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('972.30')}">
		<%@ include file="user-levels/userDEO.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('972.20')}">
		<%@ include file="user-levels/userDEOSUB.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('972.20')}">
		<%@ include file="user-levels/userDEOSUB.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('972.20')}">
		<%@ include file="user-levels/userDEOSUB.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('972.20')}">
		<%@ include file="user-levels/userDEOSUB.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('972.20')}">
		<%@ include file="user-levels/userDEOSUB.jsp" %>
	</c:when>
	
	
	
	
	
	 <c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('600.42')}">
		<%@ include file="user-levels/userDEOSUB.jsp" %>
	</c:when>
		
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('600.42')}">
		<%@ include file="user-levels/userDEOSUB.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('600.42')}">
		<%@ include file="user-levels/userDEOSUB.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('600.42')}">
		<%@ include file="user-levels/userDEOSUB.jsp" %>
	</c:when>
	 <c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('600.42')}">
		<%@ include file="user-levels/userDEOSUB.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('597.00')}">
		<%@ include file="user-levels/userDEOSUB.jsp" %>
	</c:when>
		
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('597.00')}">
		<%@ include file="user-levels/userDEOSUB.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('597.00')}">
		<%@ include file="user-levels/userDEOSUB.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('597.00')}">
		<%@ include file="user-levels/userDEOSUB.jsp" %>
	</c:when>
	 <c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('597.00')}">
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
	<c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('600.42')}">
		<%@ include file="user-levels/userDEOSUB.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('AGM')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ADMIN')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	
	 <c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('490.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('490.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('490.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('490.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && sessionScope.deptId.equals('490.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && sessionScope.deptId.equals('490.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('490.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('490.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EEC') && sessionScope.deptId.equals('490.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	 <c:when test="${sessionScope.loggedUserRole.equals('DGM') && sessionScope.deptId.equals('480.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('480.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('EE') && sessionScope.deptId.equals('480.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('CE') && sessionScope.deptId.equals('480.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('PE') && sessionScope.deptId.equals('480.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('PCE') && sessionScope.deptId.equals('480.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('ES') && sessionScope.deptId.equals('480.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	<c:when test="${sessionScope.loggedUserRole.equals('DEO') && sessionScope.deptId.equals('480.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('EEC') && sessionScope.deptId.equals('480.00')}">
		<%@ include file="user-levels/userOther.jsp" %>
	</c:when>
	
	 
	
	<%-- <c:when test="${sessionScope.branchCode.equals('CONSTRUCTION')}">
		<c:redirect url="user-levels/userOther.jsp"/>		
	</c:when>
	<c:when test="${sessionScope.branchCode.equals('DM')}">
		<c:redirect url="user-levels/userOther.jsp"/>		
	</c:when>
	<c:when test="${sessionScope.branchCode.equals('EM')}">
		<c:redirect url="user-levels/userEM.jsp"/>		
	</c:when>
	<c:when test="${sessionScope.branchCode.equals('COMMERCIAL')}">
		<c:redirect url="user-levels/userOther.jsp"/>		
	</c:when>
	
	<c:when test="${sessionScope.loggedUserRole.equals('TECH') ||  sessionScope.loggedUserRole.equals('ADMIN')}">
		<%@ include file="user-levels/userAdmin.jsp" %>
	</c:when>
	 --%>
	
	
	
	
	
	
	<c:otherwise>
		<%@ include file="user-levels/userAE.jsp" %>
	</c:otherwise>	
</c:choose>	