<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<script >

$(document).ready(function () {
	  $('#dtBasicExample').DataTable();
	  $('.dataTables_length').addClass('bs-select');
	});
<!--

//-->
</script>

  <style>
*{
	margin: 0;
	padding: 0;
}

body{
	background: url("images/light4.jpg");
	background-size: 280%;
	background-position: -400px 0px;
}

div.main{
  margin: 20px 10px -100px 10px;
}

#drop{
  padding: 2px 20px;
  cursor: pointer;
  font-size: 12px;
  color: #595656;
}

/*.input_field{
  margin-left: 460px;
}*/

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
  font-size: 14px;
  font-family: sans-serif;
  font-weight: 600;
  background-color: #ffb6c1; 
  color: black; 
  cursor: pointer;
  border: 1px solid rgba255,255,255,0.3;
  box-shadow: 1px 1px 5px rgba(0,0,0,0.3);
  border-radius: 12px;
}

.button2:hover {
  background-color: #fc94af;
  color: white;
  border: 2px solid none;
  font-size: 15px;
}

h2{
	text-align: center;
	padding: 5px;
  margin-bottom: 0px;
  text-align: center;
}

td{
  font-size: 13.5px;
}

th{
  font-size: 14px;
}

h4{
  padding-left: 79px;
  font-size: 18px;
  margin-top: 50px;
}

#mainnw2{
	margin: 150px;
}

div.register{
	background-color: rgba(0,0,0,0.5);
	width: 100%;
	font-size: 16px;
	border-radius: 10px;
}

.heading{
  background-color: #9f0e31;
  color: white;
}

form#register{
	margin: 80px;
}

label{
	font-size: 13px;
}


.wrapper .form .input_field{
	margin-bottom: 10px;
	display: flex;
	align-items: center;
}

.wrapper .form .input_field label{
	width: 170px;
}


input#name{
	width: 250px;
	outline: 0;
	padding: 3px;
}

input#name2{
  width: 50px;

  border-radius: 3px;
  outline: 0;
  padding: 3px;
  background-color: #fff;
}

#btn{
	width: 75px;
	padding: 1px 8px;
	font-size: 13px;
	background-color: #9c9797;
	color: black;
	cursor: pointer;
}

input#btn:hover{
	background-color: black;
	font-size: 13px;
  color: white;
}

.up{
	position: relative;
	bottom: 62px;
}

.upnew{
	position: relative;
	bottom: 58px;
}

.button1{
  height: 10px;
  position: relative;
  margin-left: 20px;
}

.center {
  margin: 0;
  position: absolute;
  top: -1100%;
  left: 20%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-20%, -130%);
}

 .rowt1 {
        transition: all .2s ease-in;
        cursor: pointer;
        font-size: 10px;
    }

  .rowt {
        transition: all .2s ease-in;
        cursor: pointer;
        font-size: 10px;
    }


	#headert {
        background-color: #16a085;
        color: #fff;
    }
    
    .rowt:hover {
        background-color: #f5f5f5;
        transform: scale(1.02);
    }

     .rowt1:hover {
        background-color: #f5f5f5;
        transform: scale(1.02);
    }
    
    @media only screen and (max-width: 768px) {
        table {
            width: 90%;
        }
    }
</style>

<html>
<head>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">

<!--  
<link href="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table.min.css" rel="stylesheet"> 
-->

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/bootstrap-3.3.7-dist/css/bootstrapNew.css"/>" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/newstyles.css"/>" />

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/dataTables.bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>" />
	 <link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/bootstrap-3.3.7-dist/css/dataTables.bootstrap.min.css"/>" />
	
 
  
  
  <link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/font-awesome.css"/>" />
 
 <link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/font-awesome.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/nanoscroller.css"/>" />

<!-- global styles -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/compiled/theme_styles.css"/>" />

<!-- this page specific styles -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/fullcalendar.css"/>" />
<link rel="stylesheet" type="text/css" media="print"
	href="<c:url value="/resources/css/libs/fullcalendar.print.css" />" />
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="/resources/css/compiled/calendar.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/morris.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/daterangepicker.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/jquery-jvectormap-1.2.2.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/jquery-jvectormap-1.2.2.css"/>" />

<!-- Favicon -->
<link type="image/x-icon" href="favicon.png" rel="shortcut icon" />

<!-- google font libraries -->
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700,300|Titillium+Web:200,300,400'
	rel='stylesheet' type='text/css'>
  <!--  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <link rel="stylesheet" href="https://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">-->
  
 
 <!-- <script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
  --> 
<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script type = "text/javascript" charset="utf8" src="/resources/js/jquery.dataTables.js"> </script>

 <script src="<c:url value="/resources/js/jquery.dataTables.min.js"/>"></script>
 
 

<%@ include file="sections/head.jsp"%>
<%@ include file="sections/dashboardCSS.jsp"%>

</head>
<body>



<script src="https://unpkg.com/tableexport.jquery.plugin/tableExport.min.js"></script>
<script src="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table.min.js"></script>
<script src="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table-locale-all.min.js"></script>
<script src="https://unpkg.com/bootstrap-table@1.18.3/dist/extensions/export/bootstrap-table-export.min.js"></script>


<script src="/resources/js/bootstrap.min.js"></script>
	<script src="/resources/js/dataTables.bootstrap.min.js"></script>
	<script src="/resources/js/jquery.js"></script>
	<script src="/resources/js/jquery.dataTables.min.js"></script>
	
	<div id="theme-wrapper">

		<%@ include file="sections/header.jsp"%>

		<div id="page-wrapper" class="container">
			<div class="row">

				<%@ include file="sections/userLevels.jsp"%>

				<div id="content-wrapper">

					<div class="row">
						<div class="col-lg-12">
							<div class="col-lg-9">
								
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>
					
					<!-- <div class="container">
					 --><div class="row">
						<div class="col-lg-12">
					
					
 					</div>
  					</div>
  					
<div class="main">
<div class="upnew">
            	<div class="wrapper">
			<div class = "form">
			<form id = "register" method="post">

				<div class = "input_field">
				<label> GSS Code: </label>
				<input type="text" name="cost" id="name">
  				
  				</div>
               

				<div class = "input_field">
				<label> Distribution License: </label>
				   <select name ="area" id="drop">
                    <option value="a"> DD1 </option>
                    <option value="a"> DD2 </option>
                    <option value="a"> DD3 </option>
                   </select>
				</div>
             

				<div class = "input_field">
				<label> GSS Name: </label>
				<input type="text" name="cost" id="name">
  				</div>
              

				<div class = "input_field">
				<label> Remark:</label>
				<textarea id="w3review" name="w3review" rows="3" cols="32" placeholder="Text">
  				</textarea>
				</div>

<center>

<button class="button button2" onclick="alert('Details are added')"><b>Update<b></button> 
&nbsp;&nbsp;&nbsp;&nbsp;
<button class="button button2" onclick="alert('Cleared all the details')" ><b>Clear<b></button>

</center>
    <div class="table-responsive">
    <table id="myTable" class="display table" width="100%">
        <thead>  
          <tr style="width:2%" class="heading">  
            <th>No</th>  
            <th>License</th>  
            <th>GSS Name</th>  
            <th>GSS Code</th>
	         <th>Edit</th> 
          </tr>  
        </thead>  
        <tbody>  
          <tr>  
            <td>1</td>  
            <td>DD1</td>  
            <td>Bolawatte</td>  
            <td>R1.7</td>
	    <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td>  
          </tr>  
          <tr>  
            <td>2</td>  
            <td>DD1</td>  
            <td>Chillaw</td>  
            <td>R1.6</td>  
	    <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td>  
          </tr>  
          <tr>  
            <td>3</td>  
            <td>DD1</td>  
            <td>Chuannakam</td>  
            <td>R1.14</td>
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td>  
          </tr>  
           <tr>  
            <td>4</td>  
            <td>DD1</td>  
            <td>Chunnakam & Stand-alone Genarators</td>  
            <td>R1.15</td> 
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
          <tr> 
            <td>5</td>  
            <td>DD1</td>  
            <td>Habarana</td>  
            <td>R1.3</td> 
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
	  <tr>  
            <td>6</td>  
            <td>DD1</td>  
            <td>Kalanitissa</td>  
            <td>R1.12</td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
<tr>  
            <td>7</td>  
            <td>DD1</td>  
            <td>Kilinochchi</td>  
            <td>R1.13</td>
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td>   
          </tr>  
<tr>  
            <td>8</td>  
            <td>DD1</td>  
            <td>Kolonnawa</td>  
            <td>R1.11</td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
<tr>  
            <td>9</td>  
            <td>DD1</td>  
            <td>Kurunegala</td>  
            <td>R1.9</td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
<tr>  
            <td>10</td>  
            <td>DD1</td>  
            <td>Maho</td>  
            <td>R1.16</td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
<tr>  
            <td>11</td>  
            <td>DD1</td>  
            <td>Kandy</td>  
            <td>R1.11</td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
<tr>  
            <td>12</td>  
            <td>DD1</td>  
            <td>Negambo</td>  
            <td>R1.9</td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
<tr>  
            <td>13</td>  
            <td>DD1</td>  
            <td>Anuradhapura</td>  
            <td>R1.16</td>  
            <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td> 
          </tr>  
        </tbody>  
    </table>
    </div>
</form>
</div>
</div>
</div>
</div>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script type="text/javascript"  src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript"  src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

   <script>
   $(document).ready(function(){
   $('#myTable').dataTable();
   });
   </script>
  				
					
					<%@ include file="sections/footer.jsp"%>
					</div>
					</div>
					 </div>
					 </div>
				

	<%@ include file="sections/global_scripts.jsp"%>


</body>
</html>