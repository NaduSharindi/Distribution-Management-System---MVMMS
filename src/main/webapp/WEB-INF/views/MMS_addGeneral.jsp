<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@ include file="sections/head.jsp" %>
  
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  <script 
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap&libraries=geometry"></script>
  
  <style type="text/css">
.title{
        background-color: maroon;
        height: 50px;
    }   
   h2{
        color: yellow;
        text-align: center;
        margin-top:10px;
        margin-left: 430px
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


div#map_container {
	width: 100%;
	height: 500px;
	border-radius: 5px;
}
  </style>
  
  
	<script>
	var j = jQuery.noConflict();
    j( function() {
        j("#datepicker").datepicker();
    } );
	 
	  </script>
	<script type="text/javascript">
	
	function handlePermission() {
		//alert('hiiii');
		  navigator.permissions.query({name:'geolocation'}).then(function(result) {
		    if (result.state == 'granted') {
		    	//alert('hiiii 1');
		    	
		      report(result.state);
		      geoBtn.style.display = 'none';
		    } else if (result.state == 'prompt') {
		    	//alert('hiiii 2');
		    	
		      report(result.state);
		      geoBtn.style.display = 'none';
		      navigator.geolocation.getCurrentPosition(revealPosition,positionDenied,geoSettings);
		    } else if (result.state == 'denied') {
		    	//alert('hiiii 3');
		    	
		      report(result.state);
		      geoBtn.style.display = 'inline';
		    }
		    result.onchange = function() {
		      report(result.state);
		    }
		  });
		}

		function report(state) {
		  console.log('Permission ' + state);
		}
		
		function saveFeederLoc(id){
			//var strFeeder = feeder.options[feeder.selectedIndex].value;
			
			//alert(strFeeder);
			// var y = document.getElementById("feederobj").value;
			//alert(y);			
			//alert(id);
			var n = id.indexOf(",");
			var length = id.length;
			var latitude = id.substring(1, n);
			var longitude = id.substring(n+1, length-1);
			
			//value = parseFloat(value).toFixed(2);
			latitude = parseFloat(latitude).toFixed(6);

			longitude = parseFloat(longitude).toFixed(6);

			
		    document.getElementById("txtGPSLatitude").value = latitude;
            document.getElementById("txtGPSLongitude").value = longitude;
          
		    
		}



	
	function myMap(LatLng, zoom) {
		var map = new google.maps.Map(document.getElementById("map_container"),
				{
					//center: new google.maps.LatLng(7.2665013,80.541458),
					center : LatLng,
					zoom : zoom,
					gestureHandling : 'greedy',
					mapTypeId : google.maps.MapTypeId.ROADMAP
				});
		
		
				
			 var infoWindow = new google.maps.InfoWindow;
				handlePermission();

	       if (navigator.geolocation) {
	           navigator.geolocation.getCurrentPosition(function(position) {
	             var pos = {
	               lat: position.coords.latitude,
	               lng: position.coords.longitude
	             };
	             
	             
	            latitude = parseFloat(position.coords.latitude).toFixed(6);

	 			longitude = parseFloat(position.coords.longitude).toFixed(6);

	             
	             document.getElementById("txtGPSLatitude").value = latitude;
	             document.getElementById("txtGPSLongitude").value = longitude;
	             infoWindow.setPosition(pos);
	             infoWindow.setContent('Location found.' + position.coords.latitude + " " + position.coords.longitude);
	             infoWindow.open(map);
	             map.setCenter(pos);
	             var marker = new google.maps.Marker({
						position: pos,
						map: map,
						icon: '<c:url value="/resources/img/CEBImages/mylocation.png"/>',
						title: "You are here !!!"
					});
			        
	             
	             
	             
	           }, function() {
	             handleLocationError(true, infoWindow, map.getCenter());
	           });
	         } else {
	           // Browser doesn't support Geolocation
	           handleLocationError(false, infoWindow, map.getCenter());
	         }
	      // }

	       function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	         infoWindow.setPosition(pos);
	         infoWindow.setContent(browserHasGeolocation ?
	                               'Error: The Geolocation service failed.' :
	                               'Error: Your browser doesn\'t support geolocation.');
	         infoWindow.open(map);
	       } 
	       
	       map.addListener('click', function(mapsMouseEvent) {
		          // Close the current InfoWindow.
		          infoWindow.close();
		          
		         var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
		       "<tr><td><input type='button' id='myBtn' value='Get Location' onClick='saveFeederLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'></button></td></tr> "+
		           "</table></div>";


		          // Create a new InfoWindow.
		          infoWindow = new google.maps.InfoWindow({position: mapsMouseEvent.latLng});
		          infoWindow.setContent(insDetailTable);
		          infoWindow.open(map);
		        });


	       



	}

	
	//File Remove function
	 function fileRemove() {
			document.getElementById("file").value = "";
			document.getElementById("spnclosebtn").style.display="none";
		   
	 }
	 
	 function fileRemove1() {
			 document.getElementById("file1").value = "";
			 document.getElementById("spnclosebtn1").style.display="none";
		   
	 }
	 
	 function fileRemove2() {
			 document.getElementById("file2").value = "";
			 document.getElementById("spnclosebtn2").style.display="none";
		   
	 }
	 
	 function fileRemove3() {
			 document.getElementById("file3").value = "";
			 document.getElementById("spnclosebtn3").style.display="none";
		   
	 }
	 
	 function fileRemove4() {
			 document.getElementById("file4").value = "";
			 document.getElementById("spnclosebtn4").style.display="none";
		   
	 }
	 
	 
	 //show close button
	 function show() {
		 if (file != null) {
			 document.getElementById("spnclosebtn").style.display="inline";
		 }
	 }
	 
	 function show1() {
		 if (file1 != null) {
			 document.getElementById("spnclosebtn1").style.display="inline";
		 }
	 }
	 
	 function show2() {
		 if (file3 != null) {
			 document.getElementById("spnclosebtn2").style.display="inline";
		 }
	 }
	 
	 function show3() {
		 if (file3 != null) {
			 document.getElementById("spnclosebtn3").style.display="inline";
		 }
	 }
	 
	 function show4() {
		 if (file4 != null) {
			 document.getElementById("spnclosebtn4").style.display="inline";
		 }
	 }

	
	
	  
function getLine() {
		
		var strUser = cmbSelectArea.options[cmbSelectArea.selectedIndex].value;
		

		$.ajax({
					type : 'GET',
					url : "/MMS/findLineByArea/" + strUser + "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#cmbSelectLineId'), option = "<option value='NONE'>LINE</option>";
						slctSubcat.empty();
						for (var i = 0; i < data.length; i++) {
							option = option
									+ "<option value='"+data[i].id + "'>"
									+ data[i].lineName + "</option>";
						}
						slctSubcat.append(option);

						//alert("response.towerNo" + data);	
					}
				});

	}
	
function getCSC()

{			
		
	var strUser = cmbSelectArea.options[cmbSelectArea.selectedIndex].value;
	//alert(strUser);	
	   $.ajax
         ({
                 type: 'GET',
                 url: "/MMS/findAllCSCByArea/" + strUser + "/",
                 data: {},
                 contentType: "application/json; charset=utf-8",
                 success: function(response) 
                 {   //alert("success");
                	 $('#cmbSelectCSC').empty();
                     //Insert item from the response
                     for (var i = 0; i < response.length; i++) {
                         var item = response[i];
                         $('#cmbSelectCSC').append($('<option>').text(item.deptNm).attr('value', item.deptId));
                     }
                 }
          });		
	 
	
}
	
	
	  
	
		
		
         function findArea() {
     		
     		var strUser = cmbSelectProvince.options[cmbSelectProvince.selectedIndex].value;
     		

     		$.ajax({
     					type : 'GET',
     					url : "/MMS/findAllAreaByProvinceNew/" + strUser,
     					data : {},
     					contentType : "application/json; charset=utf-8",
     					success : function(data) {
     						var slctSubcat = $('#cmbSelectArea'), option = "<option value='NONE'>AREA</option>";
     						slctSubcat.empty();
     						for (var i = 0; i < data.length; i++) {
     							option = option
     									+ "<option value='"+data[i].deptId + "'>"
     									+ data[i].deptNm + "</option>";
     						}
     						slctSubcat.append(option);

     						
     					}
     				});

     	}
		
		
		function getConductorTypes()
		{			
				 $.ajax
	             ({
	                     type: 'GET',
	                     url: '/MMS/findActiveConductorTypes/',
	                     data: {},
	                     contentType: "application/json; charset=utf-8",
	                     success: function(response) 
	                     {
	                    	 $('#cmbSelectConductorType').empty();
	                         //Append "None" item
	                         /* $('#cmbSelectConductorType').append($('<option>').text("<< Select Conductor Type >>").attr('value', ""));
	 */
	                         //Insert item from the response
	                         for (var i = 0; i < response.length; i++) {
	                             var item = response[i];
	                             $('#cmbSelectConductorType').append($('<option>').text(item.type).attr('value', item.id));
	                         }
	                     }
	              });		
		}
		
		
		
		
		function validateFormNew()
		{
			var empt = document.getElementById("txtCode").value;
			var emptTo = document.getElementById("txtName").value;
			var mailContent2 = document.getElementById("datepicker").value;
			
			
			if (empt === "")
			{
				alert("Code may not be empty");
				event.preventDefault();
				return false;
			}else if (emptTo === ""){
				alert("Name may not be empty");
				event.preventDefault();
				return false;
			}else if (mailContent2 === ""){
				alert("Date of Commissing may not be empty");
				event.preventDefault();
				return false;
			} else{
				return true;
			}
			return true;
		
		}

		
		
	
		 
		
	</script>
</head>
<body onload="myMap(new google.maps.LatLng(7.475214, 80.744077), 7);">
<div id="theme-wrapper">
		<%@ include file="sections/header.jsp" %>
		
		<div id="page-wrapper" class="container">
			<div class="row">
				<%@ include file="sections/userLevels.jsp" %>
				
				<div id="content-wrapper">
				
				<div class="row">
				<div class="col-lg-12">		                                    
                        <div class="col-lg-9">
                            <ol class="breadcrumb">
                                <li><a href="#">Home</a></li>
                                <li class="active"><span>Add General Details</span></li>
                            </ol>

                          
                        </div>
			                                    
						<%@ include file="sections/userDetails.jsp" %> 
					</div>
					</div>
 <div class="container">
			<div class="title">
<h2>- Add Gantry General Details -</h2>
   
    </div>
	
					<!-- <div class="row">
						<div class="col-lg-12">
							<div class="main-box">

								<div class="main-box-body clearfix"> -->
								      
									 <form:form role="form" enctype="multipart/form-data" action="MMSaddGeneral" method="post" modelAttribute="SaveGeneral">
										                   
										                   <c:if test="${SUCCESS_MESSAGE != null}">
                                      <div class="alert alert-success" id="success-alert">
                                       <strong>Success! </strong>${SUCCESS_MESSAGE}
                                    </div>
                                    </c:if>
                                    <script>
                                    
                                    setTimeout(function() {
                                        $('#success-alert').fadeOut('fast');
                                    }, 5000);
                                   
                                    </script>
                                    	                    
                                    
                                    
										                   <div class="user-details">
        <div class="input-box">
            <span class="details">Province</span>
           <form:select path="gantry.province" onchange="findArea()" class="form-control" id="cmbSelectProvince" name="cmbSelectProvince">
																   <form:option value="province">Province</form:option>
																   <form:options items="${SaveGeneral.provinceList}" /> 
																</form:select>
																</div>
		<div class="input-box">
            <span class="details">Area</span>
          <form:select path="gantry.area"  onchange="getCSC();" class="form-control" id="cmbSelectArea" name="cmbSelectArea">
																     <form:options items="${SaveGeneral.areaList}" />
																</form:select>
																													</div>
		<div class="input-box">
            <span class="details">CSC</span>
          <form:select path="gantry.csc" class="form-control" id="cmbSelectCSC" name="cmbSelectCSC">
																
																</form:select>
		</div>
		
		<div class="input-box">
            <span class="details">Gantry Name</span>
          <form:input path="gantry.name" type="text" class="form-control" id="txtName" placeholder="Enter Gantry Name" />
																													
																
		</div>
		
		<div class="input-box">
            <span class="details">Gantry Code</span>
         <form:input path="gantry.code" type="text" class="form-control" id="txtCode" placeholder="Enter Gantry Code" />
																																											
																
		</div>
		
		<div class="input-box">
            <span class="details">Short circuit current capacity(kA)</span>
         <form:input path="gantry.shortCctCurntCapacity" type="number" value ="0" min="0" step="0.01" class="form-control" id="txtshortcircit" placeholder="Enter short circit current capacity(kA)"/>
																																																									
																
		</div>
		<div class="input-box">
            <span class="details">Earth fault current capacity(kA)</span>
         <form:input path="gantry.earthFaultCurntCapacity" type="number" value ="0" min="0" step="0.01" class="form-control" id="txtEarthfault" placeholder="Enter earth fault curent capacity(kA)"/>
																																																																					
																
		</div>
		<div class="input-box">
            <span class="details">Date of Commissing</span>
         <form:input path="gantry.dateOfComm" type="text" class="form-control" id="datepicker"/>
																																																																							
																
		</div>
		<div class="input-box">
            <span class="details">Gantry Type</span>
         <form:select path="gantry.gantryType" class="form-control" id="cmbSelectGantryType" name="cmbSelectGantryType">
										                        <form:option value="1">Pole</form:option>
													            <form:option value="2">Structural</form:option>
																</form:select>
																																																																																					
																
		</div>
		<div class="input-box">
            <span class="details">Gantry Electrcial Type</span>
         <form:select path="gantry.gantryEleType" class="form-control" id="cmbSelectGantryEleType" name="cmbSelectGantryEleType">
										                        <form:option value="1">SBB</form:option>
													            <form:option value="2">DBB</form:option>
																</form:select>
																																																																																																			
																
		</div>
		<div class="input-box">
            <span class="details">No of Bus bars</span>
         <form:input path="gantry.noBusBar" type="number" value ="0" min="0" class="form-control" id="txtNoBusBar" placeholder="Enter No Of Bus Bar"/>
																																																																																																															
																
		</div>
		<div class="input-box">
            <span class="details">No of Bus sections</span>
         <form:input path="gantry.noBusSec" type="number" value ="0" min="0" class="form-control" id="txtNoBusSec" placeholder="Enter No Of Bus Sections"/>
																																																																																																																											
																
		</div>
		<div class="input-box">
            <span class="details">No of In bays</span>
         <form:input path="gantry.noInBays" type="number" value ="0" min="0" class="form-control" id="txtNoInBays" placeholder="Enter No Of In Bays"/>
																																																																																																																																							
																
		</div>
		<div class="input-box">
            <span class="details">No of Out bays</span>
         <form:input path="gantry.noOutBays" type="number" value ="0" min="0" class="form-control" id="txtnoOutBays" placeholder="Enter No Of Out Bays"/>
																																																																																																																																																			
																
		</div>
		<div class="input-box">
            <span class="details">Total Land Area (ph)</span>
         <form:input path="gantry.totalLandArea" type="number" value ="0" min="0" class="form-control" id="txttotalLandArea" placeholder="Total Land Area"/>
																																																																																																																																																															
																
		</div>
		<div class="input-box">
            <span class="details">No Of AutoRecloser</span>
         <form:input path="gantry.noAr" type="number" value ="0" min="0" class="form-control" id="txtnoOfAutoRecloser" placeholder="Enter No Of AutoRecloser"/>
																																																																																																																																																																											
																
		</div>
		<div class="input-box">
            <span class="details">No Of LBS</span>
         <form:input path="gantry.noLbs" type="number" value ="0" min="0" class="form-control" id="txtnoOfLBS" placeholder="Enter No Of LBS"/>
																																																																																																																																																																																							
																
		</div>
		<div class="input-box">
            <span class="details">No Of ABS</span>
         <form:input path="gantry.noAbs" type="number" min="0" value ="0" class="form-control" id="txtnoOfABS" placeholder="Enter No Of ABS"/>
																																																																																																																																																																																																			
																
		</div>
		<div class="input-box">
            <span class="details">No Of Surge Arrestors</span>
         <form:input path="gantry.noSa" type="number" min="0" value ="0" class="form-control" id="txtnoOfSurgeArrestors" placeholder="Enter No Of Surge Arrestors"/>
																																																																																																																																																																																																															
																
		</div>
		<div class="input-box">
            <span class="details">No Of DDLO Links</span>
         <form:input path="gantry.noDdloLinks" type="number" min="0" value ="0" class="form-control" id="txtnoOfLinks" placeholder="Enter No Of DDLO Links"/>
																																																																																																																																																																																																																											
																
		</div>
		<div class="input-box">
            <span class="details">No Of DDLO fuses</span>
         <form:input path="gantry.noDdloFuses" type="number" min="0" value ="0" class="form-control" id="txtnoOfDDLOfuses" placeholder="Enter No Of DDLO fuses"/>
																																																																																																																																																																																																																																							
																
		</div>
		<div class="input-box">
            <span class="details">No Of Incoming Feeders</span>
         <form:input path="gantry.noIncomingFeeder" type="number" min="0" value ="0" class="form-control" id="txtnoOfInFeeders" placeholder="Enter No Of Incomming Feeders"/>
																																																																																																																																																																																																																																																			
																
		</div>
		<div class="input-box">
            <span class="details">No Of Outgoing Feeders</span>
         <form:input path="gantry.noOutgoingFeeder" type="number" min="0" value ="0" class="form-control" id="txtnoOfOutFeeders" placeholder="Enter No Of Outgoing Feeders"/>
																																																																																																																																																																																																																																																															
																
		</div>
		<div class="input-box">
            <span class="details">GPS Latitude</span>
        <form:input path="gantry.gpsLatitude" type="number" value ="0" min="0" step="0.0000001" class="form-control" id="txtGPSLatitude" placeholder="Enter GPS Latitude"/>
																																																																																																																																																																																																																																																																											
																
		</div>
		<div class="input-box">
            <span class="details">GPS Longitude</span>
        <form:input path="gantry.gpsLongitude" type="number" value ="0" min="0" step="0.0000001" class="form-control" id="txtGPSLongitude" placeholder="Enter GPS Longitude"/>
																																																																																																																																																																																																																																																																																							
																
		</div>
 		<div class="input-box">
            <span class="details">Single Line Diagram</span>
        <input  type="file" name="file" id="file"  onchange="show()" class="form-control">
																																																																																																																																																																																																																																																																																																					
																
		</div>
		<div class="input-box">
            <span class="details">File to upload</span>
        <input  type="file" name="file1" id="file1"  onchange="show1()" class="form-control">
																																																																																																																																																																																																																																																																																																																			
																
		</div>
		<div class="input-box">
            <span class="details">File to upload</span>
        <input  type="file" name="file2" id="file2"  onchange="show2()" class="form-control">
																																																																																																																																																																																																																																																																																																																																	
																
		</div>
		<div class="input-box">
            <span class="details">File to upload</span>
        <input  type="file" name="file3" id="file3"  onchange="show3()" class="form-control">
																																																																																																																																																																																																																																																																																																																																															
																
		</div>
		<div class="input-box">
            <span class="details">File to upload</span>
        <input  type="file" name="file4" id="file4" onchange="show4()" class="form-control">
																																																																																																																																																																																																																																																																																																																																																													
																
		</div> 
		
		
		
		
		
		
		
		
																
																
																
																
           </div>     
																<table class="table table-responsive" id="tblProvinces">
			                                              		<tbody>
			                                              		
			                                              		 
			                                              		
			                                              		
			                                              		
			                                              		
			                                              		<%-- <tr>
                												<td width="30%" style="text-align:left">
                												Province
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.province" onchange="findArea()" class="form-control" id="cmbSelectProvince" name="cmbSelectProvince">
																   <form:option value="province">PROVINCE</form:option>
																   <form:options items="${SaveGeneral.provinceList}" /> 
																</form:select>
																<span id="spnSelectProvince" class="label label-danger"></span>
																</td>
																</tr>
																 --%><%-- <tr>
                												<td width="30%" style="text-align:left">
                												Area
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.area"  onchange="getCSC();" class="form-control" id="cmbSelectArea" name="cmbSelectArea">
																     <form:options items="${SaveGeneral.areaList}" />
																</form:select>
																<span id="spnSelectArea" class="label label-danger"></span>
																</td>
																</tr> --%>
																
																<%-- <tr>
                												<td width="30%" style="text-align:left">
                												CSC
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.csc" class="form-control" id="cmbSelectCSC" name="cmbSelectCSC">
																
																</form:select>
																<span id="spnSelectCSC" class="label label-danger"></span>
																</td>
																</tr>
																 --%>
																<%-- <tr>
                												<td width="30%" style="text-align:left">
                												Line
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.lineId" class="form-control" id="cmbSelectLineId" name="cmbSelectLineId">
																      <form:options items="${SaveGeneral.lineList}" />
																</form:select>
																<span id="spnSelectLineId" class="label label-danger"></span>
																</td>
																</tr> --%>
																
					                                     		<%-- <tr>
                												<td width="30%" style="text-align:left">
                												Gantry Name
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="gantry.name" type="text" class="form-control" id="txtName" placeholder="Enter Gantry Name"/>
																<span id="spnGantryName" class="label label-danger"></span>
																</td>
																</tr>
															
															 --%>	
																
																<%-- <tr>
                												<td width="30%" style="text-align:left">
                												Gantry Code
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="gantry.code" type="text" class="form-control" id="txtCode" placeholder="Enter Gantry Code" />
																<span id="spnGantryCode" class="label label-danger"></span>
																</td>
																</tr>
																 --%>
																<%-- <tr>
                												<td width="30%" style="text-align:left">
                												Short circuit current capacity(kA)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.shortCctCurntCapacity" type="number" value ="0" min="0" step="0.01" class="form-control" id="txtshortcircit" placeholder="Enter short circit current capacity(kA)"/>
																<span id="spnShortcircit" class="label label-danger"></span>
																</td>    
        														</tr>
        														 --%><%-- <tr>
        														
                												<td width="30%" style="text-align:left">
                												Earth fault current capacity(kA)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.earthFaultCurntCapacity" type="number" value ="0" min="0" step="0.01" class="form-control" id="txtEarthfault" placeholder="Enter earth fault curent capacity(kA)"/>
																<span id="spnEarthfault" class="label label-danger"></span>
																</td>    
        														</tr>
        														
																<tr>
                												<td width="30%" style="text-align:left">
                												Date of Commissing 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="gantry.dateOfComm" type="text" class="form-control" id="datepicker"/>
																<span id="spnDate" class="label label-danger"></span>
																
																</td>
																</tr>
												
                              									
        														<tr>
        														<td width="30%" style="text-align:left">
                												Gantry Type 
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.gantryType" class="form-control" id="cmbSelectGantryType" name="cmbSelectGantryType">
										                        <form:option value="1">Pole</form:option>
													            <form:option value="2">Structural</form:option>
																</form:select>
																<span id="spnGantryType" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
        														<td width="30%" style="text-align:left">
                												Gantry Electrcial Type 
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="gantry.gantryEleType" class="form-control" id="cmbSelectGantryEleType" name="cmbSelectGantryEleType">
										                        <form:option value="1">SBB</form:option>
													            <form:option value="2">DBB</form:option>
																</form:select>
																<span id="spnGantryEleType" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												No of Bus bars
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noBusBar" type="number" value ="0" min="0" class="form-control" id="txtNoBusBar" placeholder="Enter No Of Bus Bar"/>
																<span id="spnNoBusBar" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No of Bus sections
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noBusSec" type="number" value ="0" min="0" class="form-control" id="txtNoBusSec" placeholder="Enter No Of Bus Sections"/>
																<span id="spnNoBusSec" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No of In bays
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noInBays" type="number" value ="0" min="0" class="form-control" id="txtNoInBays" placeholder="Enter No Of In Bays"/>
																<span id="spnNoInBays" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No of Out bays
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noOutBays" type="number" value ="0" min="0" class="form-control" id="txtnoOutBays" placeholder="Enter No Of Out Bays"/>
																<span id="spnNoOutBays" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												Total Land Area (ph)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.totalLandArea" type="number" value ="0" min="0" class="form-control" id="txttotalLandArea" placeholder="Total Land Area"/>
																<span id="spntotalLandArea" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of AutoRecloser
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noAr" type="number" value ="0" min="0" class="form-control" id="txtnoOfAutoRecloser" placeholder="Enter No Of AutoRecloser"/>
																<span id="spnNoOfAutoRecloser" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of LBS
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noLbs" type="number" value ="0" min="0" class="form-control" id="txtnoOfLBS" placeholder="Enter No Of LBS"/>
																<span id="spnNoOfLBS" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of ABS
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noAbs" type="number" min="0" value ="0" class="form-control" id="txtnoOfABS" placeholder="Enter No Of ABS"/>
																<span id="spnNoOfABS" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of Surge Arrestors
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noSa" type="number" min="0" value ="0" class="form-control" id="txtnoOfSurgeArrestors" placeholder="Enter No Of Surge Arrestors"/>
																<span id="spnNoOfSurgeArrestors" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of DDLO Links
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noDdloLinks" type="number" min="0" value ="0" class="form-control" id="txtnoOfLinks" placeholder="Enter No Of DDLO Links"/>
																<span id="spnNoOfLinks" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of DDLO fuses
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noDdloFuses" type="number" min="0" value ="0" class="form-control" id="txtnoOfDDLOfuses" placeholder="Enter No Of DDLO fuses"/>
																<span id="spnNoOfDDLOfuses" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of Incoming Feeders
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noIncomingFeeder" type="number" min="0" value ="0" class="form-control" id="txtnoOfInFeeders" placeholder="Enter No Of Incomming Feeders"/>
																<span id="spnNoOfInFeeders" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												No Of Outgoing Feeders
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.noOutgoingFeeder" type="number" min="0" value ="0" class="form-control" id="txtnoOfOutFeeders" placeholder="Enter No Of Outgoing Feeders"/>
																<span id="spnNoOfOutFeeders" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												GPS Latitude
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.gpsLatitude" type="number" value ="0" min="0" step="0.0000001" class="form-control" id="txtGPSLatitude" placeholder="Enter GPS Latitude"/>
																<span id="spnGPSLatitude" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
                												<td width="30%" style="text-align:left">
                												GPS Longitude
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="gantry.gpsLongitude" type="number" value ="0" min="0" step="0.0000001" class="form-control" id="txtGPSLongitude" placeholder="Enter GPS Longitude"/>
																<span id="spnGPSLongitude" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
																<td width="30%" style="text-align:left">
                												Single Line Diagram
                												</td>
                												<td width="40%" style="text-align:left">
																<input  type="file" name="file" id="file"  onchange="show()" class="form-control">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove(); return false;">
																	</span>
																</td>
																
																    
        														</tr>
        														<tr>
																<td width="30%" style="text-align:left">
                												File to upload
                												</td>
                												<td width="40%" style="text-align:left">
																<input  type="file" name="file1" id="file1"  onchange="show1()" class="form-control">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn1" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove1(); return false;">
																	</span>
																</td>
																    
        														</tr>
        														
        														<tr>
																<td width="30%" style="text-align:left">
                												File to upload
                												</td>
                												<td width="40%" style="text-align:left">
																<input  type="file" name="file2" id="file2"  onchange="show2()" class="form-control">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn2" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove2(); return false;">
																	</span>
																</td>
																    
        														</tr>
        														
        														<tr>
																<td width="30%" style="text-align:left">
                												File to upload
                												</td>
                												<td width="40%" style="text-align:left">
																<input  type="file" name="file3" id="file3"  onchange="show3()" class="form-control">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn3" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove3(); return false;">
																	</span>
																</td>
																    
        														</tr>
        														
        														<tr>
																<td width="30%" style="text-align:left">
                												File to upload
                												</td>
                												<td width="40%" style="text-align:left">
																<input  type="file" name="file4" id="file4" onchange="show4()" class="form-control">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn4" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove4(); return false;">
																	</span>
																</td>
																    
        														</tr>
        			 --%>											
        														
			                     								</tbody>	
																</table>
					
																
										
										<div class="form-group">
											<div class="pull-left">
											
												<input type="submit" Value="Add" class="btn btn-success" onclick = "validateFormNew()" class="form-control"/>
												
										
											</div>
										</div>
										
										<div class="col-sm-12" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
								</div>
										

									</form:form>
								</div>
							</div>
						</div>

					</div>

					

						</div>
					<!-- </div>
				</div>
			</div> -->
			<%@ include file="sections/footer.jsp" %>
		<%@ include file="sections/global_scripts.jsp" %>
</body>
</html>