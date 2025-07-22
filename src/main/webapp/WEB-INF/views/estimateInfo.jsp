<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<title>MV - MMS</title>

<style>
* {box-sizing: border-box}
body {font-family: "Open Sans", sans-serif;
      font-weight: normal;
      text-align: center;
      background-color:white;
      background-repeat: no-repeat;
      background-size: cover;
    
    
    
    }

/* Style the tab */

    table, th, td {
  border: 1px solid black;
}

/* Style the buttons inside the tab */

*/

/* Change background color of buttons on hover */

/* Create an active/current "tab button" class */
.tab button.active {
  background-color: white;
}

/* Style the tab content */
.tabcontent {
  float: left;
  background-color: white;
  padding: 0px 12px;
  border: 3px solid maroon;
  width: 100%;
  height: 100%;
  opacity: 0.7;
  color: white;
  
    
    }
    .user-details .input-box2 input{
  height: 25px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid maroon;
  background-color:#FEE8E4;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
  
.user-details .input-box input{
  height: 45px;
  width: 85%;
  outline: none;
  font-size: 16px;
  color: black;
  border-radius: 5px;
  padding-left: 15px;
  background-color:#FEE8E4;
  border: 1px solid maroon;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
.user-details .input-box input:focus,
.user-details .input-box input:valid{
  border-color: maroon;
  border-width: inherit;
  border-bottom-width: medium;
} 

.user-details .input-box2 textarea{
  height: 25px;
  width: 85%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid maroon;
  background-color:#FEE8E4;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
  
.user-details .input-box textarea{
  height: 80px;
  width: 100%;
  outline: none;
  font-size: 16px;
  color: black;
  border-radius: 5px;
  padding-left: 15px;
  background-color:#FEE8E4;
  border: 1px solid maroon;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
.user-details .input-box textarea:focus,
.user-details .input-box textarea:valid{
  border-color: maroon;
  border-width: inherit;
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
    margin-top: 2%;
  margin-left: 43%;
  font-size: 20px;
  font-weight: bold;
  font-color: black;
  
  position: relative;
}
.container .title::before{
  content: "";
  position: absolute;
  left: 0;
  bottom: 0;
  height: 3px;
  width: 75px;
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
  font-weight: bold;
  color: black;
  
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
  width: 85%;
  outline: none;
 color: black;
  font-size: 15px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid maroon;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}  

.user-details .input-box select{
  height: 45px;
  width: 100%;
    color: black;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid maroon;
  background-color: white;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
.user-details .input-box select:focus,
.user-details .input-box select:valid{
    border-color: maroon;
  border-width: inherit;
  border-bottom-width: medium;
}
form .button input{
   height: 45px;
   margin-left: 70%;
   width: 150px;
   border-radius: 5px;
   border-color: maroon;
   color: #fff;
   font-size: 18px;
   font-weight: 500;
   letter-spacing: 1px;
   cursor: pointer;
   transition: all 0.3s ease;
   background: linear-gradient(135deg, white, #871b00);
 }
 form .button input:hover{
  /* transform: scale(0.99); */
  background: linear-gradient(135deg, #871b00, white);
  border-bottom-width: 5px;
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
  border-width: inherit;
  border-bottom-width: medium;
} 
form .input-box2 span.details{
  display: block;
  font-weight: bold;
  margin-bottom: 5px;
  color: black;
  
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
   .container .form{
        margin-left:75px;
        
    }
    
    
    

#customers {
  font-family: serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}
#customers tr:nth-child(odd){background-color: white;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #9f0e31;
  color: white;
}

   .heading{
  background-color: #9f0e31;
  color: white;
}
   

</style>

</head>
<body>
<div class="card">
            <div class="card-header">
                <ul class="nav nav-tabs card-header-tabs" role="tablist">
                    <li class="nav-item"><a class="nav-link active" id="item-1-1-tab" data-toggle="tab" role="tab" aria-controls="item-1-1" aria-selected="true" href="#item-1-1" >Estimate Details&gt;</a></li>
                    <li class="nav-item"><a class="nav-link" id="item-1-2-tab" data-toggle="tab" role="tab" aria-controls="item-1-2" aria-selected="false" href="#item-1-2">Approval History & Comments&gt;</a></li>
                    
                    <li class="nav-item"><a class="nav-link" id="item-1-3-tab" data-toggle="tab" role="tab" aria-controls="item-1-3" aria-selected="false" href="#item-1-3">Attachments&gt;</a></li>

                     </ul>
            </div>
<div class="card-body">
                <div id="nav-tabContent" class="tab-content">

                    <div id="item-1-1" class="tab-pane fade show active" role="tabpanel" aria-labelledby="item-1-1-tab">

<div id="Information2" class="tabcontent">
    
 <div class="container">
    <!-- <div class="title">Estimate Details</div>
     --><div class="content">
      <form:form method="post" action=""	modelAttribute="model">
	    <div class="user-details" >   
          <div class="input-box">
            <span  class="details"  >Estimate Number: </span>
             <form:input style = "text-align: center" path="pcesthttModel.estimateNo" />
          </div>
          <div class="input-box">
            <span  class="details">Cost Center: </span>
             <form:input style = "text-align: center" path="pcesthttModel.deptId" />
          </div>
          <div class="input-box">
            <span  class="details">Estimate Date: </span>
             <form:input style = "text-align: center" path="pcesthttModel.etimateDt" />
          </div>
          <div class="input-box">
            <span  class="details">Estimate categoty: </span>
             <form:input style = "text-align: center" path="pcesthttModel.catCd" />
          </div>
          <div class="input-box">
            <span class="details">Fund Source: </span>
             <form:input style = "text-align: center" path="pcesthttModel.fundSource" />
          </div>
          <div class="input-box">
            <span class="details">Fund ID: </span>
             <form:input style = "text-align: center" path="pcesthttModel.fundId" />
          </div>
          <div class="input-box">
            <span  class="details">Rebate: </span>
             <form:input  style = "text-align: center" path="pcesthttModel.partialAmt" />
          </div>
          <div class="input-box">
            <span class="details">Total Cost: </span>
             <form:input style = "text-align: center" path="pcesthttModel.stdCost" />
          </div>
          
          
          <div class="input-box">
            <span class="details">Description: </span>
             <form:textarea style = "text-align: center" path="pcesthttModel.descr" />
          </div>
                 
                
                <div class="table-responsive">
  <!--Table-->
  <table id="customers" class="table table-striped">

    <!--Table head-->
    <thead>
      <tr style="width:2%" class="heading"> 
                <th>Resource Code</th>  
            
            <th>Resource Name</th>  
             <th>UOM</th>  
            
            <th>Unit Price</th>  
            <th>Estimated Quantity</th>
            
            <th>Estimated Cost</th>
            <th>Rebate Quantity</th>
             <th>Rebate Cost</th>
           <th>Reusable Quantity</th>
           <th>Off Charge Quantity</th>
           
           </tr></thead>  
        <tbody> 
        
        <c:set var="count" value="0" scope="page" />
																
															<c:forEach var="job" items="${model.listPcestdttModel}"  varStatus="status">
															
																<tr>
																<td>${job.resCd}</td> 
											                 	<td>${job.resName}</td> 
											                 	<td>${job.uom}</td>
																
																<td>${job.unitPrice}</td>
																<td>${job.estimateQty}</td>
																<td>${job.estimateCost}</td>
																 <td>${job.rebateQty}</td>
																 <td>${job.rebateCost}</td>
																<td>${job.reusableQty}</td>
																<td>${job.offChargeQty}</td> 
																
																	
																
																									</tr>
									</c:forEach>
		</tbody>
    <!--Table body-->
  </table>
  <!--Table-->
</div>
		
                
                </div>    
          
        </form:form>
        


        
         </div>
    </div>
  </div>
  </div>
   <div id="item-1-2" class="tab-pane fade show active" role="tabpanel" aria-labelledby="item-1-2-tab">
  <div class="table-responsive">
  <!--Table-->
  <table id="customers" class="table table-striped">

    <!--Table head-->
    <thead>
      <tr style="width:2%" class="heading"> 
                <th>Resource Code</th>  
            
            <th>Resource Name</th>  
             <th>UOM</th>  
            
            <th>Unit Price</th>  
            <th>Estimated Quantity</th>
            
            <th>Estimated Cost</th>
            <th>Rebate Quantity</th>
             <th>Rebate Cost</th>
           <th>Reusable Quantity</th>
           <th>Off Charge Quantity</th>
           
           </tr></thead>  
        <tbody> 
        
        <c:set var="count" value="0" scope="page" />
																
															<c:forEach var="job" items="${model.listPcestdttModel}"  varStatus="status">
															
																<tr>
																<td>${job.resCd}</td> 
											                 	<td>${job.resName}</td> 
											                 	<td>${job.uom}</td>
																
																<td>${job.unitPrice}</td>
																<td>${job.estimateQty}</td>
																<td>${job.estimateCost}</td>
																 <td>${job.rebateQty}</td>
																 <td>${job.rebateCost}</td>
																<td>${job.reusableQty}</td>
																<td>${job.offChargeQty}</td> 
																
																	
																
																									</tr>
									</c:forEach>
		</tbody>
    <!--Table body-->
  </table>
  <!--Table-->
</div>
  
  </div>
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