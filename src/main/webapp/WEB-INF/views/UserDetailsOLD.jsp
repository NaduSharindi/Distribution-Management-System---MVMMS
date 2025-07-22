<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	background-image: url(elecuser.jpg);
	background-size: cover;
	font-family: sans-serif;
}

.userform-block {
	width: 100vw;
	margin-top: 50px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.form {
	position: relative;
	width: 100%;
	max-width: 380px;
	padding: 60px 40px 40px;
	background: rgba(0, 0, 0, 0.7);
	border-radius: 10px;
	color: #fff;
	box-shadow: 0 15px 25px rgba(0, 0, 0, 0.5);
}

.form::before {
	content: '';
	position: absolute;
	top: 0;
	left: 0;
	width: 50%;
	height: 100%;
	background: rgba(255, 255, 255, 0.08);
	transform: skewX(-26deg);
	transform-origin: bottom left;
	border-radius: 10px;
	pointer-events: none;
}

.form img {
	position: absolute;
	top: -50px;
	left: calc(50% - 50px);
	width: 100px;
	background: rgba(255, 255, 255, 0.8);
	border-radius: 50%;
}

.form h2 {
	text-align: center;
	letter-spacing: 1px;
	margin-bottom: 2rem;
	font-family: sans-serif;
	color: yellow;
}

.form .input-group {
	position: relative;
}

.form .input-group input {
	width: 100%;
	padding: 10px 0;
	font-size: 1rem;
	letter-spacing: 1px;
	margin-bottom: 30px;
	border: none;
	border-bottom: 1px solid #fff;
	outline: none;
	background-color: transparent;
	color: inherit;
}

.form .input-group label {
	position: absolute;
	top: 0;
	left: 0;
	padding: 10px 0;
	font-size: 1rem;
	pointer-events: none;
	transition: .3s ease-out;
}

.form .input-group input:focus+label, .form .input-group input:valid+label
	{
	transform: translateY(-18px);
	color: yellow;
	font-size: .8rem;
}

.submit-btn {
	display: block;
	margin-left: auto;
	border: none;
	outline: none;
	background: maroon;
	font-size: 1rem;
	text-transform: uppercase;
	letter-spacing: 1px;
	padding: 10px 20px;
	border-radius: 5px;
	cursor: pointer;
}

.close {
	position: absolute;
	right: 1.5rem;
	top: 0.5rem;
	font-size: 2rem;
	font-weight: 900;
	text-decoration: none;
	color: inherit;
}

.u_button {
	border-radius: 5px;
	border: none;
	color: white;
	padding: 14px 30px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px
}

.u_buttonadd {
	margin-top: 10px;
	margin-bottom: 10px;
	background-color: #00008B;
}

.u_buttonupdate {
	background-color: #437C17;
}

.u_buttonadd:hover {
	background: #2554C7;
}

.u_buttonupdate:hover {
	background: #3CB371;
}

.u_tableheading {
	color: white;
	border-radius: 10px;
	height: 40px;
}

.u_tablebody {
	background-color: #454545;
	color: white;
	height: 40px;
}

.user_form {
	align-items: center;
}

.search_bar {
	float: right;
	padding: 6px 10px;
	margin-bottom: 8px;
	margin-right: 16px;
	background: #454545;
	font-size: 17px;
	border: none;
	border-radius: 10px;
	cursor: pointer;
	height: 40px;
	box-shadow: 1px 2px 5px rgba(0, 0, 0, .31);
}

.search_bar button {
	background-color: #999999;
}

.search_bar button:hover {
	background: #ccc;
	margin-bottom: 5px;
}

.u_table-responsive {
	padding: 20px;
	opacity: 0.8;
}

.button {
  border: none;
  color: white;
  padding: 14px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}

.button2{
  width: 110px;
  height: 40px;
  padding: 5px 8px;
  font-size: 16px;
  font-family: serif;
  font-weight: 800;
  background-color: yellow; 
  color: black; 
  cursor: pointer;
  border: 1px solid rgba255,255,255,0.3;
  box-shadow: 1px 1px 5px rgba(0,0,0,0.3);
  border-radius: 12px;
}

</style>
</head>
<body style="overflow-y: scroll; height: 100%;">
	<div class="userform-block">
		<form:form action="updateUserDetail" class="form" method="post" modelAttribute="usermodel">
					<h2>User Details</h2>
			<div class="input-group">
				<form:input path="user.userId" type="text" name="user_id" id="u_id" readonly="readonly"/> 
				<label for="u_labelid">User ID</label>
			</div>
			<div class="input-group">
				<form:input  path = "user.userNm" type="text" name="user_name" id="u_name" /> 
				<label for="u_labelname">User Name</label>
			</div>
			<div class="input-group">
				<form:input  path = "user.rptUser" type="text" name="rpt_name" id="u_name" />
				<label for="u_labelname">Registered Cost Center</label>
			</div>
			
			<div class="input-group">
				<form:input path="user.userLevel"  type="text" name="user_level" id="u_level" />
				<label for="u_labellvl">User Level</label>
			</div>
			<div class="input-group">
				<form:input path="usermm.telNo" type="tel" name="user_telno" id="u_telno" /> <label
					for="u_labeltel">Telephone Number</label>
			</div>
			<div class="input-group">
				<form:input path="usermm.email" type="email" name="user_email" id="u_email" />
				<label for="u_labelemail">Email</label>
			</div>
			<div class="input-group">
				<form:input path="usermm.epfNo"  type="text" name="user_epf" id="u_epf" /> <label
					for="u_labelepf">EPF Number</label>
			</div>
				<c:if test="${SUCCESS_MESSAGE != null}">
                     <div class="alert alert-success" id="success-alert">
                     <strong>Success! </strong>${SUCCESS_MESSAGE}
                </div>
        
                </c:if>
                                    
                <c:if test="${ERROR_MESSAGE != null}">
                     <div class="alert alert-warning" id="warning-alert">
                     <strong>Warning! </strong>${ERROR_MESSAGE}
                </div>
                </c:if>
                                   
<center>
				
				<button class="button button2">
					<b>Update<b></b></b>
				</button>


			</center>

		</form:form>


	</div>

	<%-- <div class="u_table-responsive">
		<div class="search_bar">
			<input type="text" placeholder="Search.." name="search">
			<button type="submit">Search</button>
		</div>
	
		<table id="u_userDetailsTable" class="u_display u_table" width="100%">

			<thead style="background-color: #000000">
				<tr style="width: 2%" class="u_tableheading">
					<th>User ID</th>
					<th style="width: 320px">User Name</th>
					<th style="width: 220px">User Level</th>
					<th style="width: 200px">Telephone Number</th>
					<th>Email</th>
					<th>EPF Number</th>
				</tr>

			</thead>

			<tbody>
		
				<tr class="u_tablebody">
					<td>${userid}</td>
					<td>${username}</td>
					<td>${userlevel}</td>
					<td>${telephonenumber}</td>
					<td>${email}</td>
					<td>${epfnumber}</td>
				</tr>
				
			</tbody>
		</table>
		

	</div> --%>
</body>
</html>