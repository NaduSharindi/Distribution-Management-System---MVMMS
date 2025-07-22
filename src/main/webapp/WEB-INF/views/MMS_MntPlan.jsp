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

.table-scroll {
  position: relative;
  width:100%;
  z-index: 1;
  margin: auto;
  overflow: auto;
  height: 350px;
}

.table-scroll table {
  width: 100%;
  min-width: 1280px;
  margin: auto;
  border-collapse: separate;
  border-spacing: 0;
}

div#map_container {
	width: 100%;
	height: 500px;
	border-radius: 5px;
}






* {box-sizing: border-box}
body {font-family: "Lato", sans-serif;
      font-weight: ;
      
      background-image:url(powerplant.jpg);
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
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  float: left;
  background-color: black;
  padding: 0px 12px;
  border: 3px solid maroon;
  width: 100%;
  height: 900px;
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
  background-color:white;
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
  background-color:white;
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
  font-weight: 500;
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
  width: 85%;
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
   .container .form{
        margin-left:75px;
        
    }
    











  </style>
  
  
	<script>
	var j = jQuery.noConflict();
    j( function() {
        j("#datepicker").datepicker();
    } );
    
    var j = jQuery.noConflict();
    j( function() {
        j("#datepicker1").datepicker();
    } );
	
	 
	  </script>
	  
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	  
	<script type="text/javascript">
	
	
	
	
	//Load the Visualization API and the piechart package.
	google.charts.load('current', {'packages':['gantt']});
	// Set a callback to run when the Google Visualization API is loaded.
	google.charts.setOnLoadCallback(drawChart);
	// Callback that creates and populates a data table,
	// instantiates the pie chart, passes in the data and
	// draws it.
	function drawChart() {
	    // Create the data table.
	     $.ajax({
						type : 'GET',
						url : "/MMS/getPlanDetails",
						data : {},
						contentType : "application/json; charset=utf-8",
						success : function(result) {
							var dataTable = new google.visualization.DataTable();
							dataTable.addColumn('string', 'Task Id');
							dataTable.addColumn('string', 'Area');
							dataTable.addColumn('string', 'Type');
							//dataTable.addColumn('string', 'Province');
						    
							dataTable.addColumn('date', 'Start Date');
							dataTable.addColumn('date', 'End Date');
							//dataTable.addColumn('number', 'Length');
							
							dataTable.addColumn('number', 'Number of Towers');
							dataTable.addColumn('number', 'Number of Poles');
							dataTable.addColumn('string', 'Responsible EE');
								 
							
						     
							 for (var i = 0; i < result.length; i++) {
								var data = result[i];
								//alert(data.province);
								var d;
								var t;
								if(data.fromDate){
								 	d = new Date(data.fromDate);
								}
								if(data.toDate){
								 	t = new Date(data.toDate);
								}
								
								//var areaName = searchAreaName(data.area);
								dataTable.addRows([[data.id.toString(), data.area,data.planType ,d, t,data.nooftowers,data.noofpoles, data.eeName]]);
										
										
							} 
							
						      var ganttoptions = {
						    	        height: 400,
						    	        gantt: {
						    	          trackHeight: 30
						    	        }
						    	      };
	 
						    var ganttchart = new google.visualization.Gantt(document.getElementById('chart_div'));
						    ganttchart.draw(dataTable, ganttoptions);
						}
					});
	}
	
	
	/* function searchAreaName(String key){
	  	  switch (key) {
			case "471.00":
				return "Dambulla";
			case "474.00":
				return "Hasalaka";	 
			
			case "434.00":
				return "Kandy City";
			case "470.00":
				return "Galagedara";	
			case "435.00":
				return "Katugasthota";	
			case "431.00":
				return "Nawalapility";
			case "472.00":
				return "Mawanella";
			case "437.00":
				return "Kundasale";	
			case "433.00":
				return "Peradeniya";
			
			case "439.00":
				return "Kegalle";
			
			case "436.00":
				return "Matale";			 
			
			case "556.00":
				return "Ginigathhena";
			
			case "432.00":
				return "Nuwara Eliya";
				
					default:
				return key;
				 
			}

	    }
 */	
			
	function getLine() {
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = area.options[area.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$.ajax({
					type : 'GET',
					url : "/MMS/findLineByArea/" + strUser + "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#line'), option = "<option value='NONE'>ALL</option>";
						slctSubcat.empty();
						for (var i = 0; i < data.length; i++) {
							option = option
									+ "<option value='" + data[ i ].code + "'>"
									+ data[i].lineName + "</option>";
						}
						slctSubcat.append(option);

						//alert("response.towerNo" + data);	
					}
				});
	}

	
	
	
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
						var slctSubcat = $('#cmbSelectLineId'), option = "<option value='-1'>LINE</option>";
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
         
         
         function findLineDetails() {
      		
      		var strLine = cmbSelectLineId.options[cmbSelectLineId.selectedIndex].value;
      		

      		$.ajax({
      					type : 'GET',
      					url : "/MMS/getLineObject?lineid=" + strLine,
      					data : {},
      					contentType : "application/json; charset=utf-8",
      					success : function(data) {
      						document.getElementById("txtLength").value = data.length;
      						document.getElementById("txtTower").value= data.nooftowers;
      						document.getElementById("txtPole").value= data.noofpoles;
      						
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
		
		
		
		
		var arrayDataToSave = [];

		function LoadSupportToEdit(pid) {
			// if ( document.getElementById( "pstatus_" + pid ).value == 0 || document.getElementById( "pstatus_" + pid ).value == 1 || document.getElementById( "pstatus_" + pid ).value == 4 )
			// {
			// alert( "This item is sent for approving or active item or inactive item. You cann't edit this" );
			// }
			// else
			// {
			enable(pid);

			arrayDataToSave.push(pid);

			// }
		}

		function editAll(stringIDs) {

			//alert("You are going to edit that all supports.. \n" + stringIDs);
			var arrayAllIds = stringIDs.split(",");

			var len = arrayAllIds.length

			for (var count = 0; count < len; count++) {
				LoadSupportToEdit(arrayAllIds[count]);
			}

		}

		function disable(pid) {
			document.getElementById("a1_" + pid).disabled = true;
	 		document.getElementById("a2_" + pid).disabled = true;
	 				document.getElementById("a3_" + pid).disabled = true;
	 				document.getElementById("a4_" + pid).disabled = true;

			document.getElementById("a5_" + pid).disabled = true;
			document.getElementById("a6_" + pid).disabled = true;
			document.getElementById("a7_" + pid).disabled = true;
			document.getElementById("a8_" + pid).disabled = true;
			document.getElementById("a9_" + pid).disabled = true;
			document.getElementById("a10_" + pid).disabled = true;
			document.getElementById("a11_" + pid).disabled = true;
			document.getElementById("a12_" + pid).disabled = true;
			/*document.getElementById("m13_" + pid).disabled = true;
			//               document.getElementById( "t11_" + pid ).disabled = true;
			document.getElementById("pstatus_" + pid).disabled = true;
			document.getElementById("n14_" + pid).disabled = true;
 */
			arrayDataToSave = [];
		}
		//------------------------------------------------------------------------------------------------------------------------------------

		function enable(pid) {
			document.getElementById("a1_" + pid).disabled = false;
			 document.getElementById("a2_" + pid).disabled = false;
			 document.getElementById("a3_" + pid).disabled = false;
			 document.getElementById("a4_" + pid).disabled = false;

			document.getElementById("a5_" + pid).disabled = false;
			document.getElementById("a6_" + pid).disabled = false;
			document.getElementById("a7_" + pid).disabled = false;
			document.getElementById("a8_" + pid).disabled = false;
			document.getElementById("a9_" + pid).disabled = false;
			document.getElementById("a10_" + pid).disabled = false;
			document.getElementById("a11_" + pid).disabled = false;
			document.getElementById("a12_" + pid).disabled = false;
			/*document.getElementById("m13_" + pid).disabled = false;
			//                document.getElementById( "t11_" + pid ).disabled = false;
			document.getElementById("t12_" + pid).disabled = false;

			document.getElementById("pstatus_" + pid).disabled = false;
			document.getElementById("n14_" + pid).disabled = false;
 */
		}

		//edited anushka 2019-01-02------------------------------------------------------------------------------------------------------------------------
		function saveAll() {
			var len = arrayDataToSave.length

			for (var count = 0; count < len; count++) {
				var pid = arrayDataToSave[count];

				var a = document.getElementById("a1_" + pid).value;
				 var j = document.getElementById("a2_" + pid).value;
				 var k = document.getElementById("a3_" + pid).value;
				 var x = document.getElementById("a4_" + pid).value;
				var c = document.getElementById("a5_" + pid).value;
				var d = document.getElementById("a6_" + pid).value;
				var e = document.getElementById("a7_" + pid).value;
				var f = document.getElementById("a8_" + pid).value;
				var g = document.getElementById("a9_" + pid).value;
				var h = document.getElementById("a10_" + pid).value;
				var i = document.getElementById("a11_" + pid).value;
				var l = document.getElementById("a12_" + pid).value;
				/*var m = document.getElementById("m13_" + pid).value;

				var status = document.getElementById("pstatus_" + pid).value;
				var n = 'PHMR2ES1';
				var url = "/MMS/updateSupport/" + c + "/" + a + "/" + pid + "/" + d
						+ "/" + e + "/" + f + "/" + g + "/" + h + "/" + i + "/" + j
						+ "/" + k + "/" + l + "/" + m + "/" + "0" + "/" + x + "/"
						+ status + "/" + n;
 */
				$.ajax({
					type : "GET",
					url : url,
					success : function(response) {
						//alert("Support updated succesfully... id: "+ pid + response);
						console.log(response);
						window.location.reload();
						disable(pid);
					}
				});
			}
			alert("Supports updated succesfully... ");
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
                                <li class="active"><span>Add Plan Details</span></li>
                            </ol>

                          
                        </div>
			                                    
						<%@ include file="sections/userDetails.jsp" %> 
					</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="main-box">

								<div class="main-box-body clearfix">
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
									 <form:form role="form" enctype="multipart/form-data" action="addPlanS" method="post" modelAttribute="SaveGeneral">
										                        
																<!-- <table class="table table-responsive" id="tblProvinces">
																<tbody> -->
			<%-- div class="user-details" >   
          <div class="input-box">
           <span placeholder="Province" class="details">Province </span>
           <form:select path="objMntPlan.province" onchange="findArea()" id="cmbSelectProvince" name="cmbSelectProvince">
																   <form:option value="province">PROVINCE</form:option>
																   <form:options items="${SaveGeneral.provinceList}" /> 
																</form:select>
																
          </div>
          </div> --%>
																
			                                              		<tr>
                												<td width="30%" style="text-align:left">
                												Province
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="objMntPlan.province" onchange="findArea()" class="form-control" id="cmbSelectProvince" name="cmbSelectProvince">
																   <form:option value="province">PROVINCE</form:option>
																   <form:options items="${SaveGeneral.provinceList}" /> 
																</form:select>
																<span id="spnSelectProvince" class="label label-danger"></span>
																</td>
																</tr>
																<tr>
                												<td width="30%" style="text-align:left">
                												Area
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="objMntPlan.area"  onchange="getCSC();getLine();" class="form-control" id="cmbSelectArea" name="cmbSelectArea">
																     <form:options items="${SaveGeneral.areaList}" />
																</form:select>
																<span id="spnSelectArea" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
															    <td width="30%" style="text-align: left">Line</td>
															    <td width="70%" style="text-align: left"><form:select  path="line.id" class="form-control" onchange="findLineDetails()" id="cmbSelectLineId" name="cmbSelectLineId">

																	<form:options items="${SaveGeneral.lineList}" />
																</form:select></td>
														        </tr>

																
																
																<tr>
                												<td width="30%" style="text-align:left">
                												CSC
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="objMntPlan.csc" class="form-control" id="cmbSelectCSC" name="cmbSelectCSC">
																
																</form:select>
																<span id="spnSelectCSC" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Plan Year
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="objMntPlan.year" class="form-control" id="cmbSelectYear" name="cmbSelectYear">
																<form:option value="2020" selected="selected">2020</form:option>
	
																 <form:option value="2021" >2021</form:option>
	<form:option value="2022" >2022</form:option>
	
	<form:option value="2022" >2023</form:option>
	<form:option value="2024" >2024</form:option>
	<form:option value="2025" >2025</form:option>
	
	
	
																</form:select>
																<span id="spnSelectCSC" class="label label-danger"></span>
																</td>
																</tr>
																
																<tr>
                												<td width="30%" style="text-align:left">
                												Maintenance Type
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="objMntPlan.planType" class="form-control" id="cmbSelectPlanType" name="cmbSelectPlanType">
																 <form:option value="HOT" selected="selected">Hot Line Maintenance</form:option>
	<form:option value="COLD" >Cold Line Maintenance</form:option>
	<form:option value="INSP" >Inspection</form:option>
	
																</form:select>
																<span id="spnSelectCSC" class="label label-danger"></span>
																</td>
																</tr>
																
	
																<tr>
                												<td width="30%" style="text-align:left">
                												Responsible EE
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="objMntPlan.eeName" class="form-control" id="cmbSelectEE" name="cmbSelectEE">
																  <form:options items="${SaveGeneral.eeList}" />
																</form:select>
																<span id="spnSelectCSC" class="label label-danger"></span>
																</td>
																</tr>
	<tr>
                												<td width="30%" style="text-align:left">
                												Responsible ES
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="objMntPlan.esName" class="form-control" id="cmbSelectES" name="cmbSelectES">
																  <form:options items="${SaveGeneral.esList}" />
																</form:select>
																<span id="spnSelectCSC" class="label label-danger"></span>
																</td>
																</tr>
	
	
																
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
																<tr>
																
                												<td width="30%" style="text-align:left">
                												Length(Km)
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="objMntPlan.length" type="number" value ="0" min="0" step="0.01" class="form-control" id="txtLength" placeholder="Enter Length(Km)"/>
																<span id="spnEarthfault" class="label label-danger"></span>
																</td>    
        														</tr>
        														<tr>
																
                												<td width="30%" style="text-align:left">
                												Number of Tower
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="objMntPlan.nooftowers" type="number" value ="0" min="0" step="0.01" class="form-control" id="txtTower" placeholder="Enter Number of Tower"/>
																<span id="spnEarthfault" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														<tr>
																
                												<td width="30%" style="text-align:left">
                												Number of Pole
                												</td>
                												<td width="70%" style="text-align:left">
                												<form:input path="objMntPlan.noofpoles" type="number" value ="0" min="0" step="0.01" class="form-control" id="txtPole" placeholder="Enter Number of Poles"/>
																<span id="spnEarthfault" class="label label-danger"></span>
																</td>    
        														</tr>
        														
        														
					                                     		<tr>
                												<td width="30%" style="text-align:left">
                												Serial Number
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="objMntPlan.serialNo" type="text" class="form-control" id="txtName" placeholder="Enter Serial Number"/>
																<span id="spnGantryName" class="label label-danger"></span>
																</td>
																</tr>
															
																
																
																<tr>
                												<td width="30%" style="text-align:left">
                												From Date 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="fromDate" type="date"  class="form-control" id="from"/>
																<span id="spnDate" class="label label-danger"></span>
																
																</td>
																</tr>
												<tr>
                												<td width="30%" style="text-align:left">
                												To Date 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="toDate" type="date" class="form-control" id="to"/>
																<span id="spnDate" class="label label-danger"></span>
																
																</td>
																</tr>
												<tr>
														<td width="30%" style="text-align: left">Status</td>
													    <td width="70%" style="text-align: left"><form:select
																path="objMntPlan.status" class="form-control" id="txtSampleSatisified">
																<form:option value="2" selected="selected">Active</form:option>
															<form:option value="3">In Active</form:option>
															</form:select> <span id="spnSampleSatisified" class="label label-danger"></span></td>
															
														</tr>
                              									
        														<!--         														<tr>
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
        														 -->
        														
			                     								<!-- </tbody>	
																</table>
																 -->
										
										<div class="form-group">
											<div class="pull-left">
											
												<input type="submit" Value="Add" class="btn btn-success" class="form-control"/>
												
										
											</div>
										</div>
										
										<div id="table-scroll" class="table-scroll"> 
                                                    
										<table class="table table-striped table-bordered table-sm " id="tblAdmin">
															 <thead>
															<tr>
															<td>List of Details</td>
															</tr>
															
																<tr>
																<th class="text-center">Plan Year</th>
																	
																	<th class="text-center">Province</th>
																	<th class="text-center">Area</th>
																	<th class="text-center">Length</th>
																	<th class="text-center">No Of Poles</th>
																	<th class="text-center">No Of Towers</th>
																	<th class="text-center">Responsible EE</th>
																	<th class="text-center">Responsible ES</th>
																	<th class="text-center">Type</th>
																	<th class="text-center">Form Date</th>
																	<th class="text-center">To Date</th>
																	<th class="text-center">Status</th>
																</tr>
															</thead>
															 <tbody>

																<%-- <tr>
																	<td><form:label path="">line</form:label></td>

																	<td><form:checkboxes items="${model.listOfLines}"
																			path="selectedLines" /></td>
																	<td></td>
																</tr> --%>


																<c:forEach var="plan" items="${SaveGeneral.objMntPlanList}">
																	<tr>
																	
																	<td><input type="text" id="a3_${plan.id}"
																			value="${plan.year}" class="form-control"
																			disabled></td>
																	
																	
																	<td><select id="a1_${plan.id}"
																		class="form-control" disabled>

																			<c:forEach var="province" items="${SaveGeneral.glcompm}">

																				<c:choose>
																					<c:when test="${province.compId != plan.province}">
																						<option value="${province.compId}">${province.compNm}</option>
																					</c:when>
																				</c:choose>

																			</c:forEach>

																			<c:forEach var="province" items="${SaveGeneral.glcompm}">
																				<c:choose>
																					<c:when test="${province.compId == plan.province}">
																						<option value="${province.compId}" selected="selected">${province.compNm}</option>
																					</c:when>
																				</c:choose>
																			</c:forEach>
																	</select></td>
																	
																	
																	
																	 	<td><input type="text" id="a2_${plan.id}"
																			value="${plan.area}" class="form-control" disabled></td>
																	 		<td><input type="text" id="a4_${plan.id}"
																			value="${plan.length}" class="form-control" disabled></td>
																	 	<td><input type="text" id="a5_${plan.id}"
																			value="${plan.noofpoles}" class="form-control"
																			disabled></td>
																		<td><input type="text" id="a6_${plan.id}"
																			value="${plan.nooftowers}" class="form-control"
																			disabled></td> 
																			
																			
																			<td><select id="a7_${plan.id}"
																		class="form-control" disabled>

																			<c:forEach var="ee" items="${SaveGeneral.listEE}">

																				<c:choose>
																					<c:when test="${ee.userId != plan.eeName}">
																						<option value="${ee.userId}">${ee.userNm}</option>
																					</c:when>
																				</c:choose>

																			</c:forEach>

																			<c:forEach var="ee" items="${SaveGeneral.listEE}">
																				<c:choose>
																					<c:when test="${ee.userId == plan.eeName}">
																						<option value="${ee.userId}" selected="selected">${ee.userNm}</option>
																					</c:when>
																				</c:choose>
																			</c:forEach>
																	</select></td>
																	<td><select id="a8_${plan.id}"
																		class="form-control" disabled>

																			<c:forEach var="es" items="${SaveGeneral.listES}">

																				<c:choose>
																					<c:when test="${es.userId != plan.esName}">
																						<option value="${es.userId}">${es.userNm}</option>
																					</c:when>
																				</c:choose>

																			</c:forEach>

																			<c:forEach var="es" items="${SaveGeneral.listES}">
																				<c:choose>
																					<c:when test="${es.userId == plan.esName}">
																						<option value="${es.userId}" selected="selected">${es.userNm}</option>
																					</c:when>
																				</c:choose>
																			</c:forEach>
																	</select></td>
																			
																<td><select id="a9_${plan.id}"
																		class="form-control" disabled>

																			<c:choose>
																				<c:when test="${plan.planType=='COLD'}">
																					<option value="${plan.planType}"
																						selected="selected">Cold Lne Maintenance</option>
																					<option value="HOT">Hot Line Maintenance</option>
																					<option value="INSP">Inspection</option>
																					
																				</c:when>

																				<c:when test="${plan.planType=='HOT'}">
																					<option value="${plan.planType}"
																						selected="selected">Hot Lne Maintenance</option>
																					<option value="COLD">Cold Line Maintenance</option>
																					<option value="INSP">Inspection</option>
																					
																				</c:when>

																				<c:when test="${plan.planType=='INSP'}">
																					<option value="${plan.planType}"
																						selected="selected">Inspection</option>
																					<option value="COLD">Cold Line Maintenance</option>
																					<option value="HOT">Hot Line Maintenance</option>
																					
																				</c:when>

																				
																				<c:otherwise>
																					<option value="COLD">Cold Line Maintenance</option>
																					<option value="HOT">Hot Line Maintenance</option>
																					<option value="INSP">Inspection</option>
																					
																				</c:otherwise>

																			</c:choose>
																	</select></td>
																			
																	 	<td><input type="date" id="a10_${plan.id}" class="form-control" disabled></input>${plan.fromDate}</td> 
																	 		
																		 <td><input type="date" id="a11_${plan.id}"
																			 class="form-control"
																			disabled></input>${plan.toDate}</td> 
																	 	 
																			<td><select id="a12_${plan.id}"
																		class="form-control" disabled>
<c:if test="${plan.status=='2'}">
																				
																					<option value="${plan.status}"
																						selected="selected">Active</option>
																					<option value="3">Inactive</option>
																					
																				</c:if>
																				<c:if test="${plan.status=='3'}">
																				
																					<option value="${plan.status}"
																						selected="selected">Inactive</option>
																					<option value="2">Active</option>
																					
																				</c:if>
																				
																	</select></td>
																			
																			
																	</tr>
																</c:forEach>
															</tbody>
														</table>
														
														</div>
														
														<div>
						<table class="table table-striped table-bordered table-sm " align="center">
							<tbody style="text-align:center">
								<!-- edited 2 anushka open 2018-11-30 -->
													<tr>
													<form:button type='button' class='btn btn-warning'
																onClick='javascript:editAll("${SaveGeneral.stringOfSupportIds}")'>Edit
																All</form:button>
<form:button type='button' class='btn btn-success'
																onClick='javascript:saveAll()'>Update All</form:button>
																
																														<!-- edited anushka 2019-01-02----------------------------------------------------------------------------------------->
																											</tr>
													<!-- edited 2 anushka close 2018-11-30 -->
							</tbody>
						</table>
					</div>
														
										
							<div class="row">
						<div class="col-lg-12">
							<div class="main-box clearfix">
								<!-- <header class="main-box-header clearfix">
									<h2 class="pull-left">Unread Way Leave Status</h2>
								</header>
 -->
								<div class="main-box-body clearfix">
									<div class="table-responsive" class="table-scroll">
									<div class="table-scroll">
									
										 <div id="chart_div"></div>
									</div>

								</div>
								</div>
							</div>
						</div>
					</div>
										
										<!-- <div class="col-sm-12" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
								</div>
										
 -->
									</form:form>
								</div>
							</div>
						</div>

					</div>

					

						</div>
					</div>
				</div>
			</div>
			<%@ include file="sections/footer.jsp" %>
		<%@ include file="sections/global_scripts.jsp" %>
</body>
</html>