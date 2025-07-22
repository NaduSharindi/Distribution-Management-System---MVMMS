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
	background: url("images/light3.jpg");
	background-size: 280%;
	background-position: -400px 0px;
}

div.main{
	width: 250px;
	margin: 10px auto 0px auto;
}

h4{
	text-align: center;
	padding-top: -120px;
	font-family: sans-serif;
}

#drop{
  padding: 4px 80px;
  border: 1px solid transparent;
  box-shadow: inset 1px 1px 5px rgba(0,0,0,0.3);
  cursor: pointer;
  user-select: none;
}

h1{
	text-align: center;
	font-size: 40px;
}

#topic{
	text-align: center;
	font-family: serif;
	font-size: 18px;
}

div.register{
	background-color: rgba(0,0,0,0.5);
	width: 80%;
	font-size: 16px;
	border-radius: 10px;
	border: 1px solid rgba(255,255,255,0.3);
	box-shadow: 2px 2px 15px rgba(0,0,0,0.3);
	color: #fff;
}

form#register{
	margin: 30px;
}

label{
	font-family: sans-serif;
	font-size: 13px;
}


.wrapper .form .input_field{
	margin-bottom: 5px;
	display: flex;
	align-items: center;
}

.wrapper .form .input_field label{
	width: 140px;
}

input#name{
	width: 250px;
	border: 1px solid #ddd;
	border-radius: 3px;
	outline: 0;
	padding: 7px;
	background-color: #fff;
	box-shadow: inset 1px 1px 5px rgba(0,0,0,0.3);
}

input#quantity{
	width: 250px;
	border: 1px solid #ddd;
	border-radius: 3px;
	outline: 0;
	padding: 7px;
	background-color: #fff;
	box-shadow: inset 1px 1px 5px rgba(0,0,0,0.3);
}

input#btn{
	width: 90px;
	padding: 8px 10px;
	font-size: 7px;
	font-family: sans-serif;
	font-weight: 600;
	border-radius: 4px;
	background-color: rgba(250,100,0,0.8);
	color: #fff;
	cursor: pointer;
	border: 1px solid rgba255,255,255,0.3;
	box-shadow: 1px 1px 5px rgba(0,0,0,0.3);
	border-radius: 3px;
}

input#btn:hover{
	background-color: #5e302c;
	border: 2px solid black;
	font-size: 13px;
  	color: white;
}

.up{
	position: relative;
	bottom: 339px;
	padding-left: 30px;
}

.up2{
	position: relative;
	bottom: 155px;
	padding-left: 2px;
}

.down{
	position: relative;
	bottom: -25px;
	padding-left: 30px;
}

label,span,h2{
	text-shadow: 1px 1px 5px rgba(0,0,0,0.3);
}
</style>

<html>
<head>

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
  					
  					<br><br>
	<center>
	<h1> Meter Testing Module </h1> 
	</center>
<table id="tablenew">
    
<div class="main">
		<div class="wrapper">
		<div class="main1">
           <tr>
            <td>

            	<!--Left Form-->
            	<div class="up2">
            	<div class="wrapper">
<br><br><br>
            		<h4 id="topic"> Customer & Location  data </h4>
			<div class = "form">
			<form id = "register" method="post">
<br>
				<div class = "input_field">
				<label> Area: </label>
                    <select name ="eno" id="drop">
                    <option value="a"></option>
                    <option value="a"></option>
                    <option value="a"></option>
             </select>
            	</div>
             <br>

             	<div class = "input_field">
				<label> CSC: </label>
				   <select name ="wareh" id="drop">
                    <option value="a"></option>
                    <option value="a"></option>
                    <option value="a"></option>
                   </select>
				</div>
             <br>

				<div class = "input_field">
				<label> Account Number: </label>
				<input type="number" name="quant" id="quantity"  required />
				</div>
            <br>

				<div class = "input_field">
				<label> Customer Name: </label>
				<input type="text" name="cname" id="name" >
				</div>
            <br>

		<div class = "input_field">
				<label> Contact Number: </label>
				<input type="text" name="cname" id="name" >
				</div>
            <br>

				<div class = "input_field">
				<label> Customer Address: </label>
				   <textarea id="w3review" name="w3review" rows="5" cols="34" placeholder="Text">
  				</textarea>
				</div>
                <br>

				<div class = "input_field">
				<label> Customer Location: </label>
				<input type="text" name="location" id="name">
  				</div>

             <br>

                <div class = "input_field">
				<label> Connection Type: </label>
                    <select name ="ctype" id="drop">
                    <option value="a"> </option>
                    <option value="a"> MHP </option>
                    <option value="a"> HS </option>
                    <option value="a"> LT Bulk </option>
                    <option value="a"> 3 ph 30A </option>
                    <option value="a"> 3 ph 60 A </option>
                    <option value="a"> 1 ph </option>
             </select>
            	</div>
             <br>
                
                <div class = "input_field">
				<label> Contract Demand: </label> 
                    <select name ="ctype" id="drop">
                    <option value="a"> </option>
                    <option value="a"> None </option>
                    <option value="a"> 75kVA </option>
                    <option value="a"> 95 kVA </option>
                    <option value="a"> 100kVA/ </option>
                    <option value="a"> 160 kVA </option>
                    <option value="a"> 250kVA </option>
                    <option value="a"> 400kVA </option>
                    <option value="a"> 800 kVA </option>
                    <option value="a"> 1000 kVA </option>
                    <option value="a"> Other... </option>
             </select>
            	</div>
             <br>

            <div class = "input_field">
				<label> Contract Demand: <br> (if chose 'Other') <br> &nbsp&nbsp *Optional </label>
				   <textarea id="w3review" name="w3review" rows="5" cols="34" placeholder="Describe yourself here...">
  				</textarea>
				</div>
            <br>
                
                <div class = "input_field">
				<label> Tariff: </label> 
                    <select name ="ctype" id="drop">
                    <option value="a"> </option>
                    <option value="a"> I1 </option>
                    <option value="a"> I2 </option>
                    <option value="a"> I3 </option>
                    <option value="a"> H1 </option>
                    <option value="a"> H2 </option>
                    <option value="a"> H3 </option>
                    <option value="a"> GP1 </option>
                    <option value="a"> GP2 </option>
                    <option value="a"> GP3 </option>
                    <option value="a"> D1 </option>
                    <option value="a"> D2 </option>
                    <option value="a"> D3 </option>
                    <option value="a"> R1 </option>
                    <option value="a"> R2 </option>
                    <option value="a"> R3 </option>
                    <option value="a"> GV1 </option>
                    <option value="a"> GV2 </option>
                    <option value="a"> GV3 </option>
             </select>
            	</div>
             <br>

			</form>
                </div>
        </div>        
      </div>
    </td>

            <!-- Right Form-->
            <td>
            	<div class="down">
        <div class="wrapper">
        	<h4 id="topic"> Meter & CT Asset Data </h4>
        	
      <div class = "form">
                 	<form id = "register" method="post">
<br>
                 		<div class = "input_field">
					<label><b> Existing CT Detail: </b></label>
						</div>
				<div class = "input_field">
					<br><br><br><br>
				<label> Make: </label>
                    <input type="text" name="make" id="name">
				</div>
                <br>
                
                <div class = "input_field">
				<label> CEB Serial No: </label>
                    <input type="text" name="cebserial" id="name">
				</div>
                <br>
                        
                <div class = "input_field">
				<label> Manufacture Serial No: </label>
                    <input type="text" name="manu" id="name">
				</div>
                <br>
                        
                <div class = "input_field">
				<label> Meter CT Ratio: </label> 
                    <select name ="ctype" id="drop">
                    <option value="a"> </option>
                    <option value="a"> 200/5 </option>
                    <option value="a"> 400/5 </option>
                    <option value="a"> 800/5 </option>
                    <option value="a"> 1000/5 </option>
                    <option value="a"> Other... </option>
             </select>
            	</div>
             <br>

				<div class = "input_field">
				<label> Meter VT Ratio: </label> 
                    <select name ="vtype" id="drop">
                    <option value="a"> </option> 
                    <option value="a"> 1/1 </option>
                    <option value="a"> Other... </option>
             </select>
            	</div>
             <br>

				<div class = "input_field">
				<label> Meter Constant Active: </label>
				    <input type="number" name="mcact" id="quantity">
				</div>
                <br>

		<div class = "input_field">
				<label> Meter Constant Reactive: </label>
				    <input type="number" name="" id="quantity">
				</div>
                    <br>

		<div class = "input_field">
				<label> Scaling Factor: </label>
				   <input type="number" name="sf" id="quantity">
				</div>
                    <br>
               
		<div class = "input_field">
				<label> Multification Factor: </label>
				   <input type="number" name="multifac" id="quantity">
				</div>
                    <br>

		<div class = "input_field">
				<label> Accuracy Class - Active: </label>
				    <input type="number" name="manu" id="quantity">
				</div>
                    <br>

		<div class = "input_field">
				<label> Accuracy Class - Reactive: </label>
				    <input type="number" name="acreact" id="quantity">
				</div>
                    <br>


		<div class = "input_field">
				<label> Year of Manufacture: </label>
				    <input type="date" name="manuyear" id="name">
				</div>
                    <br><br><br>


		<div class = "input_field">
		<label><b> Existing CT Serial Number: </b></label>
		</div>

		<div>
		   <div class = "input_field">
		   	<br>
				<label> R: </label>
                    <input type="text" name="manu" id="name">
				</div>
            <br>
            <div class = "input_field">
				<label> Y: </label>
                    <input type="text" name="manu" id="name">
				</div>
            <br>
            <div class = "input_field">
				<label> B: </label>
                    <input type="text" name="manu" id="name">
				</div>
            <br>


<script>
function myFunction() {
  var checkBox = document.getElementById("myCheck");
  var text = document.getElementById("text");
  if (checkBox.checked == true){
    text.style.display = "block";
  } else {
     text.style.display = "none";
  }
}
</script>

<label for="myCheck">Do you have two meters? &nbsp Yes</label>
<input type="checkbox" id="myCheck" onclick="myFunction()"> 
<div class = "form" id="text" style="display:none">
                 	<form id = "register1" method="post">
<br><br>
                 		<div class = "input_field">
					<label><b> Existing Meter Details 2: </b></label>
						</div>
				<div class = "input_field">
					<br><br><br><br>
				<label> Make: </label>
                    <input type="text" name="make" id="name">
				</div>
                <br>
                
                <div class = "input_field">
				<label> CEB Serial No: </label>
                    <input type="text" name="cebserial" id="name">
				</div>
                <br>
                        
                <div class = "input_field">
				<label> Manufacture Serial No: </label>
                    <input type="text" name="manu" id="name">
				</div>
                <br>
                        
                <div class = "input_field">
				<label> Meter CT Ratio: </label> 
                    <select name ="ctype" id="drop">
                    <option value="a"> </option>
                    <option value="a"> 200/5 </option>
                    <option value="a"> 400/5 </option>
                    <option value="a"> 800/5 </option>
                    <option value="a"> 1000/5 </option>
                    <option value="a"> Other... </option>
             </select>
            	</div>
             <br>

				<div class = "input_field">
				<label> Meter VT Ratio: </label> 
                    <select name ="vtype" id="drop">
                    <option value="a"> </option> 
                    <option value="a"> 1/1 </option>
                    <option value="a"> Other... </option>
             </select>
            	</div>
             <br>

				<div class = "input_field">
				<label> Meter Constant Active: </label>
				    <input type="number" name="mcact" id="quantity">
				</div>
                <br>

		<div class = "input_field">
				<label> Meter Constant Reactive: </label>
				    <input type="number" name="" id="quantity">
				</div>
                    <br>

		<div class = "input_field">
				<label> Scaling Factor: </label>
				   <input type="number" name="sf" id="quantity">
				</div>
                    <br>
               
		<div class = "input_field">
				<label> Multification Factor: </label>
				   <input type="number" name="multifac" id="quantity">
				</div>
                    <br>

		<div class = "input_field">
				<label> Accuracy Class - Active: </label>
				    <input type="number" name="manu" id="quantity">
				</div>
                    <br>

		<div class = "input_field">
				<label> Accuracy Class - Reactive: </label>
				    <input type="number" name="acreact" id="quantity">
				</div>
                    <br>


		<div class = "input_field">
				<label> Year of Manufacture: </label>
				    <input type="date" name="manuyear" id="name">
				</div>
                    <br><br>


		<div class = "input_field">
		<label><b> Existing CT Serial Number: </b></label>
		</div>

		<div>
		   <div class = "input_field">
		   	<br>
				<label> R: </label>
                    <input type="text" name="manu" id="name">
				</div>
            <br>
            <div class = "input_field">
				<label> Y: </label>
                    <input type="text" name="manu" id="name">
				</div>
            <br>
            <div class = "input_field">
				<label> B: </label>
                    <input type="text" name="manu" id="name">
				</div>
            <br>
</form>
</div>
            
            </div>
		</div>


			</form>   
            </div>
        </div>
    </div>
                </td>
               </tr>
</div>
</div>
</div>
 </table>			
  				
					
					<%@ include file="sections/footer.jsp"%>
					</div>
					</div>
					 </div>
					 </div>
				

	<%@ include file="sections/global_scripts.jsp"%>


</body>
</html>