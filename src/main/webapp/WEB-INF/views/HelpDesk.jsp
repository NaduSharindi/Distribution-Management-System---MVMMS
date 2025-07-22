<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {box-sizing: border-box}
body {font-family: "Lato", sans-serif;
      background-image:url(elec.jpg);
      background-repeat: no-repeat;
      background-size: cover;
    
    
    }

/* Style the tab */
.tab {
  float: left;
  border: 1px solid maroon;
  background-color: #ffffff;
  opacity: 0.7;
  width: 25%;
  height: 780px;
}
    table, th, td {
  border: 1px solid black;
}

/* Style the buttons inside the tab */
.tab button {
  display: block;
  background-color: inherit;
  color: black;
  padding: 22px 16px;
  width: 100%;
  border: none;
  outline: none;
  text-align: left;
  cursor: pointer;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current "tab button" class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  float: left;
  background-color: #f1f1f1;
  padding: 0px 12px;
  border: 1px solid maroon;
  width: 75%;
  border-left: none;
  height: 780px;
    
    }
    .user-details .input-box2 input{
  height: 25px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
  
.user-details .input-box input{
  height: 45px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
.user-details .input-box input:focus,
.user-details .input-box input:valid{
  border-color: maroon;
  border-bottom-width: medium;
} 
 .user-details{
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  margin: 20px 0 12px 0;
}
    
    
    
    <!-- ------------ -->
    .container{
  width: 1000px;
  height: 1200px;
  padding: 25px 30px;
  border-radius: 5px;
  box-shadow: 0 5px 10px rgba(0,0,0,0.15);
}
    
.container .title{
  font-size: 20px;
  font-weight: 500;
  position: relative;
}
.container .title::before{
  content: "";
  position: absolute;
  left: 0;
  bottom: 0;
  height: 3px;
  width: 50px;
  border-radius: 5px;
  background: linear-gradient(135deg, #dfe302, #871b00);
}  
content form .user-details{
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  margin: 20px 0 12px 0;
}
form .user-details .input-box{
  margin-bottom: 15px;
  width: calc(100% / 2 - 20px);
}
    
form .input-box span.details{
  display: block;
  font-weight: 500;
  margin-bottom: 5px;
}
form .category{
   display: flex;
   width: 80%;
   margin: 14px 0 ;
   justify-content: space-between;
 }
.user-details .input-box2 select{
  height: 24px;
  width: 100%;
  outline: none;
  font-size: 15px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}  

.user-details .input-box select{
  height: 45px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
.user-details .input-box select:focus,
.user-details .input-box select:valid{
    
  border-bottom-width: medium;
}
    form .button input{
   height: 45px;
   width: 100px;
   border-radius: 5px;
   border: none;
   color: #fff;
   font-size: 18px;
   font-weight: 500;
   letter-spacing: 1px;
   cursor: pointer;
   transition: all 0.3s ease;
   background: linear-gradient(135deg, #871b00, #dfe302);
 }
 form .button input:hover{
  /* transform: scale(0.99); */
  background: linear-gradient(135deg, #dfe302, #871b00);
  }
    h2{
        margin: 15px;
        
    }
    
    img{
       flex-wrap: wrap; 
       margin-left: 130px;
        margin-top: 5px;
    }
    
    
    <!-- Half input -->
    
.user-details .input-box input{
  height: 45px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
.user-details .input-box2 input:focus,
.user-details .input-box2 input:valid{
  border-color: maroon;
  border-bottom-width: medium;
} 
form .input-box2 span.details{
  display: block;
  font-weight: 500;
  margin-bottom: 5px;
}
form .user-details .input-box2{
  margin-bottom: 15px;
  width: calc(100% / 2 - 20px);
} 
    
   
    
    .user-details .table input{
height: 27px;
  width: 100px;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
    }
    .user-details .table input:focus,
.user-details .table input:valid{
  border-color: maroon;
  border-bottom-width: medium;
} 
    
  .msgSuccess {
	color: green;
	font-family: "Verdana", Times, serif;
	font-size: 15px;
	font-weight: bold;
	text-align: center;
}

.msgError {
	color: red;
	font-family: "Verdana", Times, serif;
	font-size: 15px;
	font-weight: bold;
	text-align: center;
}
    
    

   
   

</style>
<script type="text/javascript">
function validateForm()
	{
		var jobNumber = document.getElementById("jobNumber").value;
		var exsistingCostCenter = document.getElementById("exsistingCostCenter").value;
		var newCostCenter = document.getElementById("newCostCenter").value;
		
		if (jobNumber === "")
			{
			alert("job Number may not be empty");
			event.preventDefault();
			return false;
		}else if (exsistingCostCenter === ""){
			alert("Exsisting CostCenter may not be empty");
			event.preventDefault();
			return false;
		}else if (newCostCenter === ""){
			alert("New CostCenter may not be empty");
			event.preventDefault();
			return false;
		}else{
			return true;
		}
		return true;
	
	}
	
function validateFormReopen()
{
	var jobNumber = document.getElementById("jobNumber1").value;
	var exsistingCostCenter = document.getElementById("exsistingCostCenter1").value;
	
	if (jobNumber === "")
		{
		alert("job Number may not be empty");
		event.preventDefault();
		return false;
	}else if (exsistingCostCenter === ""){
		alert("Exsisting CostCenter may not be empty");
		event.preventDefault();
		return false;
	}else{
		return true;
	}
	return true;

}

</script>
</head>
<body> 

  
<div class="tab">
    <!-- <img  src="logo.png" width="50" height="50">  -->
    <h2>HelpDesk</h2> 
    
  <button class="tablinks" onclick="openCity(event, 'London')" id="defaultOpen">Job Transfer</button>
  <button class="tablinks" onclick="openCity(event, 'London2')" id="defaultOpen">Job Reopen</button>
  
  <button class="tablinks" onclick="openCity(event, 'London1')" id="defaultOpen">Upload Progress</button>
  
</div> 

<div id="London" class="tabcontent">
    
<div class="container">
  <div class="title">Job Transfer</div>
    <div class="content">
      <form:form role="form" action="JobTransfer" method="post"  modelAttribute="JobTransfer">
			  <div class="user-details">
          <div class="input-box">
          
          <c:if test="${not empty JobTransfer.successMsg}">
										<tr>
										<td colspan="2" class="msgSuccess" align="center">
										
									<div class="msgSuccess">
										<c:out value="${JobTransfer.successMsg}"></c:out>
									</div>
								
						</tr>
					</c:if>
					
					<c:if test="${not empty JobTransfer.errorMsg}">
										<tr>
										<td colspan="2" class="msgError" align="center">
										
									<div class="msgError">
										<c:out value="${JobTransfer.errorMsg}"></c:out>
									</div>
								
						</tr>
					</c:if>
           
           
          							
										
										
            <span class="details">Job Number</span>
              
            <form:input path ="jobNumber" id ="jobNumber" type="text" placeholder="Enter Job Number" />
          </div>
          <div class="input-box">
            <span class="details">Existing Cost Center</span>
            <form:input path ="exsistingCostCenter" id = "exsistingCostCenter" type="text" placeholder="Enter Existing Cost Center" />
          </div>
          <div class="input-box">
            <span class="details">New Cost Center</span>
            <form:input path ="newCostCenter" id ="newCostCenter" type="text" placeholder="Enter New Cost Center" /> 
          </div>
                      
        </div>
          <div class="button">
           <form:input path ="" type="submit" value="Transfer" onclick="validateForm()"/>
          
        </div>
        </form:form>
      </div>
    </div> 
    
</div>

<div id="London2" class="tabcontent">
    
<div class="container">
  <div class="title">Job Reopen</div>
    <div class="content">
      <form:form role="form" action="JobReopen" method="post"  modelAttribute="JobTransfer">
			  <div class="user-details">
          <div class="input-box">
          
          <c:if test="${not empty JobTransfer.successMsg}">
										<tr>
										<td colspan="2" class="msgSuccess" align="center">
										
									<div class="msgSuccess">
										<c:out value="${JobTransfer.successMsg}"></c:out>
									</div>
								
						</tr>
					</c:if>
					
					<c:if test="${not empty JobTransfer.errorMsg}">
										<tr>
										<td colspan="2" class="msgError" align="center">
										
									<div class="msgError">
										<c:out value="${JobTransfer.errorMsg}"></c:out>
									</div>
								
						</tr>
					</c:if>
           
           
          							
										
										
            <span class="details">Job Number</span>
              
            <form:input path ="jobNumber" id ="jobNumber1" type="text" placeholder="Enter Job Number" />
          </div>
          
          <div class="input-box">
            <span class="details">Existing Cost Center</span>
            <form:input path ="exsistingCostCenter" id = "exsistingCostCenter1" type="text" placeholder="Enter Existing Cost Center" />
          </div>
          
                      
        </div>
          <div class="button">
           <form:input path ="" type="submit" value="Reopen" />
          
        </div>
        </form:form>
      </div>
    </div> 
    
</div>

 <div id="London1" class="tabcontent">
 
<div class="container">
  <div class="title">Upload Progress</div>
    <div class="content">
    
    <form:form  method="post" action="uploadProgeass" enctype="multipart/form-data" modelAttribute="JobTransfer">
																 <table class="table table-responsive" id="tblProvinces">
																<c:if test="${not empty JobTransfer.successMsg}">
										<tr>
										<td colspan="2" class="msgSuccess" align="center">
										
									<div class="msgSuccess">
										<c:out value="${JobTransfer.successMsg}"></c:out>
									</div>
								
						</tr>
					</c:if>
			
													     	    <tr>
																<td width="30%" style="text-align:left">
                												<label>File to upload:</label>
                												</td>
                												<td width="70%" style="text-align:left">
																<input  type="file" name="file">
																</td>
																    
        														</tr>
        														<tr>
        														
        														</tr>
        													  <%-- <tr>
        														
																<td width="30%" style="text-align:left">
                												<label>Name:</label>
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="" type="text" name="name"></form:input></td>
																    
        														</tr>  --%>
        														
        														<tr>
																<td width="30%" style="text-align:left">
                												<label>Press here to upload the file:</label>
                												</td>
                												<td width="70%" style="text-align:left">
																<input type="submit" value="Upload"> 
																    </td>
        														</tr>
        														
        														
                                                                        														
        														 </table>
        														</form:form>
        	
    
    
    
           </div>
    </div> 
    
   </div> 
   
     
 
<script>
function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>
   
 </body>
</html> 

