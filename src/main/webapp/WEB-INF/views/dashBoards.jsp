<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>

	<c:when test="${sessionScope.deptId.equals('600.41')}">
		<c:redirect url="dashboard"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('972.30')}">
		<c:redirect url="dashboard"/>		
	</c:when>
	
	<c:when test="${sessionScope.deptId.equals('780.00')}">
		<c:redirect url="dashboard"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('596.00')}">
		<c:redirect url="dashboard"/>		
	</c:when>
	
	<c:when test="${sessionScope.deptId.equals('597.00')}">
		<c:redirect url="dashboardSUB"/>		
	</c:when>
	
	<%-- <c:when test="${sessionScope.deptId.equals('600.42')}">
		<c:redirect url="dashboard"/>		
	</c:when>
	 --%><%-- <c:when test="${sessionScope.deptId.equals('597.00')}">
		<c:redirect url="dashboard"/>		
	</c:when> --%>
	<c:when test="${sessionScope.deptId.equals('490.60')}">
		<c:redirect url="dashboardEM"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('550.80')}">
		<c:redirect url="dashboardEM"/>		
	</c:when>
	
	<c:when test="${sessionScope.deptId.equals('490.00')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	
	<c:when test="${sessionScope.deptId.equals('460.23')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('430.00')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('430.20')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('430.30')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	
	
	<c:when test="${sessionScope.deptId.equals('490.00')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('490.20')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('490.30')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	
	
	<c:when test="${sessionScope.deptId.equals('440.00')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('440.30')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('440.20')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	
	<c:when test="${sessionScope.deptId.equals('480.00')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('480.30')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('480.20')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('450.00')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('450.30')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('450.20')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	
	<c:when test="${sessionScope.deptId.equals('530.00')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('530.20')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('530.30')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	
	<c:when test="${sessionScope.deptId.equals('440.20')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('440.30')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	
	
	<c:when test="${sessionScope.deptId.equals('501.00')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('550.00')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('550.20')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	
	<c:when test="${sessionScope.deptId.equals('550.30')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('420.30')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('420.20')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('420.00')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	
	
	
	<c:when test="${sessionScope.deptId.equals('520.00')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('520.30')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	
	<c:when test="${sessionScope.deptId.equals('520.20')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	
	
	<c:when test="${sessionScope.deptId.equals('510.00')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('510.20')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('510.30')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	
	<c:when test="${sessionScope.deptId.equals('440.30')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('501.30')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('501.00')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	
	
	<c:when test="${sessionScope.deptId.equals('430.00')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('430.30')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	
	<c:when test="${sessionScope.deptId.equals('460.00')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('460.22')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('460.23')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	
	<c:when test="${sessionScope.deptId.equals('460.30')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('600.42')}">
		<c:redirect url="dashboardSUB"/>		
	</c:when>
	<c:when test="${sessionScope.deptId.equals('972.30')}">
		<c:redirect url="dashboardSUB"/>		
	</c:when>
	
	
	<c:when test="${sessionScope.deptId.equals('597.00')}">
		<c:redirect url="dashboardSUB"/>		
	</c:when>
	
	<c:when test="${sessionScope.deptId.equals('600.00')}">
		<c:redirect url="dashboardAgm"/>		
	</c:when>
	
	<c:when test="${sessionScope.deptId.equals('970.00')}">
		<c:redirect url="dashboardAgm"/>		
	</c:when>
	
	<c:when test="${sessionScope.deptId.equals('400.00')}">
		<c:redirect url="dashboardAgm"/>		
	</c:when>
	
	<c:when test="${sessionScope.deptId.equals('120.00')}">
		<c:redirect url="dashboardAdmin"/>		
	</c:when>
	
	<c:when test="${sessionScope.branchCode.equals('CONSTRUCTION')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<c:when test="${sessionScope.branchCode.equals('DM')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	<%-- <c:when test="${sessionScope.branchCode.equals('EM')}">
		<c:redirect url="dashboardEM"/>		
	</c:when>
	 --%><c:when test="${sessionScope.branchCode.equals('COMMERCIAL')}">
		<c:redirect url="dashboardOther"/>		
	</c:when>
	
	
	<c:otherwise>
		<c:redirect url="dashboardAE"/>
	</c:otherwise>	
		
</c:choose>	