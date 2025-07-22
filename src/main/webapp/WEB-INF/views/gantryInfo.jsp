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
 

.user-details .input-box select{
  height: 45px;
  width: 100%;
  outline: none;
  font-size: 14px;
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
    
    
    
    
.user-details .input-box2 input{
  height: 27px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;

}
    
   
    
.user-details .table input{
height: 27px;
  width: 200px;
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
    
    
.user-details .table2 input{
height: 27px;
  width: 90px;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
    }
    .user-details .table2 input:focus,
.user-details .table input:valid{
  border-color: maroon;
  border-bottom-width: medium;
} 

   .user-details .table2 select{
  height: 27px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
.user-details .table2 select:focus,
.user-details .table2 select:valid{
    
  border-bottom-width: medium;
}
    
.user-details .table3 input{
height: 27px;
    position: fixed;
  width: 90px;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
    }
    .user-details .table3 input:focus,
.user-details .table input:valid{
  border-color: maroon;
  border-bottom-width: medium;
} 
.user-details[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}  
   
.user-details .input-box2 select{
  height: 27px;
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
    
    
    
    
.user-details .table4 input{
height: 27px;
  width: 90px;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
    }
    .user-details .table4 input:focus,
.user-details .table input:valid{
  border-color: maroon;
  border-bottom-width: medium;
} 

   .user-details .table4 select{
  height: 27px;
  width: 100%;
  outline: none;
  font-size: 16px;
  border-radius: 5px;
  padding-left: 15px;
  border: 1px solid #ccc;
  border-bottom-width: 2px;
  transition: all 0.3s ease;
}
.user-details .table4 select:focus,
.user-details .table4 select:valid{
    
  border-bottom-width: medium;
}    

form .button2 input{
   height: 45px;
   width: 250px;
   border-radius: 5px;
   margin-top: 10px;
   border: none;
   color: #fff;
   font-size: 18px;
   font-weight: 500;
   letter-spacing: 1px;
   cursor: pointer;
   transition: all 0.3s ease;
   background:#871b00;
 }

</style>

</head>
<body>
<div class="card">
            <div class="card-header">
                <ul class="nav nav-tabs card-header-tabs" role="tablist">
                    <li class="nav-item"><a class="nav-link active" id="item-1-1-tab" data-toggle="tab" role="tab" aria-controls="item-1-1" aria-selected="true" href="#item-1-1" >Gantry Details&gt;</a></li>
                    <!-- <li class="nav-item"><a class="nav-link" id="item-1-2-tab" data-toggle="tab" role="tab" aria-controls="item-1-2" aria-selected="false" href="#item-1-2">Approval History & Comments&gt;</a></li>
                    
                    <li class="nav-item"><a class="nav-link" id="item-1-3-tab" data-toggle="tab" role="tab" aria-controls="item-1-3" aria-selected="false" href="#item-1-3">Attachments&gt;</a></li>
 -->
                     </ul>
            </div>
            <form:form method="post" action=""	modelAttribute="model">
            
<div class="card-body">
                <div id="nav-tabContent" class="tab-content">
                 <div id="item-1-1" class="tab-pane fade show active" role="tabpanel" aria-labelledby="item-1-1-tab">
               <div class="table-responsive" style="padding: 47px;">
                            <table class="table">
                                <thead>
                                    <tr></tr>
                                </thead>
                                <tbody>
                                    <tr></tr>
                                    <tr>
                                        <td style="font-size: 24px; color: #BC576F;">Gantry Details<br></td>
                                        <td></td>
                                    </tr>
                                    <tr>
														<td>Gantry Name</td>
														<td> <form:input path="gantry.name" type="text" class="form-control" id="txtName" placeholder="Enter Gantry Name" />
	</td>
															</tr>
										<tr>
														<td>Gantry Code</td>
														<td> <form:input path="gantry.code" type="text" class="form-control" id="txtCode" placeholder="Enter Gantry Code" />
		</td>
															</tr>
							<tr>
														<td>Short circuit current capacity(kA)</td>
														<td> <form:input path="gantry.shortCctCurntCapacity" type="number" value ="0" min="0" step="0.01" class="form-control" id="txtshortcircit" placeholder="Enter short circit current capacity(kA)"/>
		</td>
															</tr>
			<tr>
														<td>Earth fault current capacity(kA)</td>
														<td> <form:input path="gantry.earthFaultCurntCapacity" type="number" value ="0" min="0" step="0.01" class="form-control" id="txtEarthfault" placeholder="Enter earth fault curent capacity(kA)"/>
		</td>
															</tr>
			<tr>
														<td>Date of Commissing</td>
														<td> <form:input path="gantry.dateOfComm" type="text" class="form-control" id="datepicker"/>
		</td>
															</tr>
			<tr>
														<td>Gantry Type</td>
														<td><form:select path="gantry.gantryType" class="form-control" id="cmbSelectGantryType" name="cmbSelectGantryType">
										                        <form:option value="1">Pole</form:option>
													            <form:option value="2">Structural</form:option>
																</form:select>
		</td>
															</tr>
															<tr>
														<td>Gantry Electrcial Type</td>
														<td><form:select path="gantry.gantryEleType" class="form-control" id="cmbSelectGantryEleType" name="cmbSelectGantryEleType">
										                        <form:option value="1">SBB</form:option>
													            <form:option value="2">DBB</form:option>
																</form:select>
		
		</td>
															</tr>
			<tr>
														<td>No of Bus bars</td>
														<td><form:input path="gantry.noBusBar" type="number" value ="0" min="0" class="form-control" id="txtNoBusBar" placeholder="Enter No Of Bus Bar"/>
		
		
		</td>
															</tr>
		<tr>
														<td>No of Bus sections</td>
														<td><form:input path="gantry.noBusSec" type="number" value ="0" min="0" class="form-control" id="txtNoBusSec" placeholder="Enter No Of Bus Sections"/>
		</td>
															</tr>
		<tr>
														<td>No of In bays</td>
														<td><form:input path="gantry.noInBays" type="number" value ="0" min="0" class="form-control" id="txtNoInBays" placeholder="Enter No Of In Bays"/>
		</td>
															</tr>
		<tr>
														<td>No of Out bays</td>
														<td><form:input path="gantry.noOutBays" type="number" value ="0" min="0" class="form-control" id="txtnoOutBays" placeholder="Enter No Of Out Bays"/>
		</td>
															</tr>
		<tr>
														<td>Total Land Area (ph)</td>
														<td> <form:input path="gantry.totalLandArea" type="number" value ="0" min="0" class="form-control" id="txttotalLandArea" placeholder="Total Land Area"/>
		</td>
															</tr>
		<tr>
														<td>No Of AutoRecloser</td>
														<td><form:input path="gantry.noAr" type="number" value ="0" min="0" class="form-control" id="txtnoOfAutoRecloser" placeholder="Enter No Of AutoRecloser"/>
		</td>
															</tr>
		<tr>
														<td>No Of LBS</td>
														<td><form:input path="gantry.noLbs" type="number" value ="0" min="0" class="form-control" id="txtnoOfLBS" placeholder="Enter No Of LBS"/>
		</td>
															</tr>
		<tr>
														<td>No Of ABS</td>
														<td><form:input path="gantry.noAbs" type="number" min="0" value ="0" class="form-control" id="txtnoOfABS" placeholder="Enter No Of ABS"/>
		</td>
															</tr>
		<tr>
														<td>No Of Surge Arrestors</td>
														<td><form:input path="gantry.noSa" type="number" min="0" value ="0" class="form-control" id="txtnoOfSurgeArrestors" placeholder="Enter No Of Surge Arrestors"/>
		</td>
															</tr>
		<tr>
														<td>No Of DDLO Links</td>
														<td> <form:input path="gantry.noDdloLinks" type="number" min="0" value ="0" class="form-control" id="txtnoOfLinks" placeholder="Enter No Of DDLO Links"/>
		</td>
															</tr>
			<tr>
														<td>No Of DDLO fuses</td>
														<td> <form:input path="gantry.noDdloFuses" type="number" min="0" value ="0" class="form-control" id="txtnoOfDDLOfuses" placeholder="Enter No Of DDLO fuses"/>
		</td>
															</tr>
		<tr>
														<td>No Of Incoming Feeders</td>
														<td><form:input path="gantry.noIncomingFeeder" type="number" min="0" value ="0" class="form-control" id="txtnoOfInFeeders" placeholder="Enter No Of Incomming Feeders"/>
		</td>
															</tr>
		<tr>
														<td>No Of Outgoing Feeders</td>
														<td><form:input path="gantry.noOutgoingFeeder" type="number" min="0" value ="0" class="form-control" id="txtnoOfOutFeeders" placeholder="Enter No Of Outgoing Feeders"/>
		</td>
															</tr>
		<tr>
														<td>GPS Latitude</td>
														<td><form:input path="gantry.gpsLatitude" type="number" value ="0" min="0" step="0.0000001" class="form-control" id="txtGPSLatitude" placeholder="Enter GPS Latitude"/>
		</td>
															</tr>
		<tr>
														<td>GPS Longitude</td>
														<td><form:input path="gantry.gpsLongitude" type="number" value ="0" min="0" step="0.0000001" class="form-control" id="txtGPSLongitude" placeholder="Enter GPS Longitude"/>
		</td>
															</tr>
		
														                </tbody>
                        </table>	
				
		
		
		
		
		
		
																
																
																
																
           												
									 
        
                        </div>  
                 
</div>  
    
</div>

   </div>
   </form:form>
    

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