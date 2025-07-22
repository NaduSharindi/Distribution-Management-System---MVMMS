<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<%@ include file="sections/head.jsp" %>
		
		
		<style type="text/css">

div#map_container {
	width: 100%;
	height: 250px;
	border-radius: 5px;
}

.modal-title {
	margin: 0;
	line-height: 1.428571429;
	text-align: center;
}


.form-control {
	display: inline-block;
	width: -webkit-fill-available;
	height: 34px;
	font-size: 12px;
	color: #0f1893;
	border-color: #095f9f;
	background-color: #fff;
	font-weight: 800;
	border-radius: 4px;
}


.msgSuccess {
	color: green;
	font-family: "Verdana", Times, serif;
	font-size: 15px;
	font-weight: bold;
	text-align: left;
}

.msgError {
	color: red;
	font-family: "Verdana", Times, serif;
	font-size: 15px;
	font-weight: bold;
	text-align: left;
}

.closeBtn:hover {
  color: red;
  display:inline-block;
}


.fa-times-circle::before {

    content: "\f057";

}

.fa-lg {
    font-size: 1.33333333em;
    line-height: .75em;
    vertical-align: -15%;
}

.fa {
    display: inline-block;
    font: normal normal normal 14px/1 FontAwesome;
        font-size: 14px;
        line-height: 1;
    font-size: inherit;
    text-rendering: auto;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
}

.label-danger, .fc-event.label-danger {
    background-color: #e74c3c;
}
.label {
    border-radius: 3px;
    background-clip: padding-box;
    font-size: 0.875em;
    font-weight: 600;
}
.label-danger {
    background-color: #d9534f;
}
.label {
    display: inline;
    padding: .2em .6em .3em;
    font-size: 75%;
    font-weight: bold;
    line-height: 1;
    color: #fff;
    text-align: center;
    white-space: nowrap;
    vertical-align: baseline;
    border-radius: .25em;
}

.google-visualization-table-td {
text-align: center !important;
}


}




</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
google.charts.load('current', {'packages':['corechart', 'controls']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawDashboard);





function drawDashboard() {
    	  
	
    	  
    	  $.ajax({
  			type : 'GET',
  			url : "/MMS/getTrippingData",
  			data : {},
  			contentType : "application/json; charset=utf-8",
  			success : function(result) {
  				
  				var datavaluefortable = new google.visualization.DataTable();
				datavaluefortable.addColumn('string', 'Line Name');
				datavaluefortable.addColumn('string', 'Time-From');
				datavaluefortable.addColumn('string', 'Time-To');
				datavaluefortable.addColumn('string', 'Duration(Min)');
				datavaluefortable.addColumn('string', 'Type of Tripping');
				datavaluefortable.addColumn('string', 'Cause of Tripping');
				datavaluefortable.addColumn('string', 'Areas Effected');
				datavaluefortable.addColumn('number', 'No. of Effected Consumers');
				datavaluefortable.addColumn('string', 'Tripping Date');
				datavaluefortable.addColumn('number', 'Id');
				
				
				for (var i = 0; i < result.length; i++) {
						var data = result[i];
						//alert(data.fromtime);
						datavaluefortable.addRows([[data.lineid,data.fromtime,data.totime,data.duration,data.trippingType,data.reason,data.areaEffected,data.noOfConsumer,data.workingDate,data.trippingId]]);
				}
				
				
  				// Create a dashboard.
  		        var dashboard = new google.visualization.Dashboard(
  		            document.getElementById('dashboard_div'));

  		        // Create a range slider, passing some options
  		        var donutRangeSlider = new google.visualization.ControlWrapper({
  		          'controlType': 'CategoryFilter',
  		          'containerId': 'filter_div',
  		          'options': {
  		        	'filterColumnLabel': 'Tripping Date'
  		          }
  		        });
  		          		        
  		      var table = new google.visualization.ChartWrapper({
		          'chartType': 'Table',
		          'containerId': 'table_div',
		          'options': {
		            'width': 1000,
		            'height': 300,
		            'pieSliceText': 'value',
		            'legend': 'right'
		          }
		        });
  		    //table.setColumns([0,1,2,3,4]);
			

  		        // Establish dependencies, declaring that 'filter' drives 'pieChart',
  		        // so that the pie chart will only display entries that are let through
  		        // given the chosen slider range.
  		       
  		      dashboard.bind(donutRangeSlider, table);
  		      dashboard.draw(datavaluefortable);
  		      
  		    google.visualization.events.addListener(table, 'select', selectHandler);
  		    
  		     function selectHandler() {
	        	//alert("hiii");
	         var selectedItem = table.getChart().getSelection();
	         if(selectedItem){
	        	 var row = selectedItem[0].row;
	        	 var id = table.getDataTable().getValue(row, 9);

  		    	var r = confirm("You are going to inactive this record :" + id);
				if (r == true) {
				    $.ajax({
					type : 'GET',
					url : "/MMS/updateTrippingData?id="+id,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						
					}
				}); 
				drawDashboard();
				alert("Successfully Done!!");	
				
			} else {
	  			
			}
 	        
  			    
  			}
  		    }
  			}
   		});
    	  
}



</script>

		
		
			<script type="text/javascript">
				function validateForm() {
					clearErrorMessages();
					
				    try {
				    	 			    	 
				    	 if (validateEmpty("txtId") == false) {
		                     throw 1000;
		                 }
				    	 
				    	 if (validateEmpty("txtProvince") == false) {
		                     throw 1001;
		                 }
				    	 
				    	 if (validateEmpty("txtStatus") == false) {
		                     throw 1002;
		                 }
				    	 
				    	 enable();
	
				    	 return true;
						
					} catch (e) {
						if (e == 1000) {
		                    document.getElementById("spnId").innerHTML = "Province Id is Required !";
		                    ScrollToElement("spnId");
		                }
						
						if (e == 1001) {
		                    document.getElementById("spnProvince").innerHTML = "Province Name is Required !";
		                    ScrollToElement("spnProvince");
		                }
						
						if (e == 1002) {
		                    document.getElementById("spnStatus").innerHTML = "Province Status is Required !";
		                    ScrollToElement("spnStatus");
		                }
						
						return false;
					}
				}
				
				 function clearErrorMessages() {
		             document.getElementById('spnId').innerHTML = "";
		             document.getElementById('spnProvince').innerHTML = "";
		             document.getElementById('spnStatus').innerHTML = "";
		             
		         }
				 
				 function enable(){
					 document.getElementById("txtDeptId").disabled= false;
				 }
				 
				 
				 function showProvinces()
					{
							
							 $.ajax
				             ({
				                     type: 'GET',
				                     url: '/MMS/findAll/',
				                     data: {},
				                     contentType: "application/json; charset=utf-8",
				                     success: function(response) 
				                     {
				                    	 $("#tblProvinces > tbody:last").children().remove();
		
				                    	 //Insert item from the response
				                         for (var i = 0; i < response.length; i++) {
				                             var item = response[i];
		
				                             
				                             tr = $('<tr/>');
				                                tr.append("<td>" + item.id + "</td>"); 
				                                tr.append("<td>" + item.province + "</td>");
				                                tr.append("<td>" + item.deptId + "</td>");
				                               
				                                if(item.status==0){
				                                    tr.append("<td><span class='label label-warning'>Pending</span></td>"); 
				                                } else if(item.status==1){ 
				                                    tr.append("<td><span class='label label-success'>Active</span></td>"); 
				                                }
				                                else if(item.status==2){ 
				                                    tr.append("<td><span class='label label-default'>In bulk</span></td>"); 
				                                }
				                                else if(item.status==3){ 
				                                    tr.append("<td><span class='label label-danger'>Rejected</span></td>"); 
				                                }
				                                else if(item.status==4){ 
				                                	tr.append("<td><span class='label label-info'>Inactive</span></td>");  
				                                }
				                                //console.log(item);
		
				                                //Show "Edit" and "Delete" buttons
				                                //tr.append("<td>" + "<button type='button' class='btn btn-info' onClick='ConfirmActivate(" +item.id + ")'>Activate</button>" + "</td>");
		
				                                $('#tblProvinces').append(tr);
				                         }
				                         
				                         $('#tblProvinces').dataTable({
				                                'info': false,
				                                'pageLength': 10,
				                                retrieve: true
				                            });
				                     }
				              });				
					}
				 
					function parseTime(cTime)
					{
					  if (cTime == '') return null;
					  var d = new Date();
					  var time = cTime.match(/(\d+)(:(\d\d))?\s*(p?)/);
					  d.setHours( parseInt(time[1]) + ( ( parseInt(time[1]) < 12 && time[4] ) ? 12 : 0) );
					  d.setMinutes( parseInt(time[3]) || 0 );
					  d.setSeconds(0, 0);
					  return d;
					}
					function calculateDuration(){
						var cStart = document.getElementById("timeDuration").value;
						var cStop = document.getElementById("timeDuration2").value;
					
						if (cStart != "" && cStop != "") {
						    var tStart = parseTime(cStart);
						    var tStop = parseTime(cStop);
					
						    document.getElementById("duration").value=(tStop - tStart)/(1000*60);
						}
						else {
							document.getElementById("duration").value= "";
						}
					}
					
					
					function findArea() {
						var strUser = province.options[province.selectedIndex].value;
						
						$
								.ajax({
									type : 'GET',
									url : "/MMS/findAllAreaByProvinceNew/" + strUser,
									data : {},
									contentType : "application/json; charset=utf-8",
									success : function(data) {
										var slctSubcat = $('#area'), option = "<option value='NONE'>ALL</option>";
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

					function getLine() {
						var strUser = area.options[area.selectedIndex].value;
						
						$
								.ajax({
									type : 'GET',
									url : "/MMS/findLineByArea/" + strUser + "/",
									data : {},
									contentType : "application/json; charset=utf-8",
									success : function(data) {
										var slctSubcat = $('#line'), option = "<option value='NONE'>ALL</option>";
										slctSubcat.empty();
										for (var i = 0; i < data.length; i++) {
											option = option
													+ "<option value='"+data[i].id + "'>"
													+ data[i].lineName + "</option>";
										}
										slctSubcat.append(option);

											
									}
								});

					}
					
					function loadNetwork() {
						//alert('hiii');
						var map = new google.maps.Map(document.getElementById("map_container"), {
				          //center: new google.maps.LatLng(7.2665013,80.541458),
				          center: new google.maps.LatLng(7.873054,80.771797),
				          zoom: 12,
				          gestureHandling: 'greedy',
				          mapTypeId: google.maps.MapTypeId.ROADMAP
				        });
						
								var infoWindow = new google.maps.InfoWindow();
						var strArea = area.options[area.selectedIndex].value;
						var strLine = line.options[line.selectedIndex].value;
						var strProvince = province.options[province.selectedIndex].value;
						var bounds = new google.maps.LatLngBounds();
						$.ajax
				        ({
				                type: 'GET',
				                url: "/MMS/MapNewInt/" + strArea +"/" + strLine + "/" +strProvince,
				                 data: {},
				                contentType: "application/json; charset=utf-8",
				                success : function(json){

				                	
				                	
				                		for (var i = 0, length = json.length; i < length; i++) {
				        					var data = json[i],

				        					
				        						latLng = new google.maps.LatLng(data[0].gpsLatitude, data[0].gpsLongitude);
				         					bounds.extend(latLng);
				    						

				    						var image = {
				        						    url: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
				        						    // This marker is 20 pixels wide by 32 pixels high.
				        						    size: new google.maps.Size(20, 32),
				        						    // The origin for this image is (0, 0).
				        						    origin: new google.maps.Point(0, 0),
				        						    // The anchor for this image is the base of the flagpole at (0, 32).
				        						    anchor: new google.maps.Point(0, 32)
				        						  };
				        						  // Shapes define the clickable region of the icon. The type defines an HTML
				        						  // <area> element 'poly' which traces out a polygon as a series of X,Y points.
				        						  // The final coordinate closes the poly by connecting to the first coordinate.
				        						  var shape = {
				        						    coords: [1, 1, 1, 20, 18, 20, 18, 1],
				        						    type: 'poly'
				        						  };

												if(data[0].tapping > 0 ){


												if(data[0].supportType == 3){
													var marker = new google.maps.Marker({
					            						position: latLng,
					            						map: map,
					            						icon: 'http://labs.google.com/ridefinder/images/mm_20_yellow.png',
					            						title: "Click here to view details of Tower ID "+data[0].id,
					            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GB' }
					            					});
											  }else if(data[0].supportType == 4){
													var marker = new google.maps.Marker({
					            						position: latLng,
					            						map: map,
					            						icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
					            						title: "Click here to view details of Tower ID "+data[0].id,
					            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GSSB' }
					            					});
											  }else if(data[0].supportType == 7){
													var marker = new google.maps.Marker({
					            						position: latLng,
					            						map: map,
					            						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
					            						title: "Click here to view details of Tower ID "+data[0].id,
					            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'SW' }
					            					});
											  }else{
													var marker = new google.maps.Marker({
					            						position: latLng,
					            						map: map,
					            						icon: 'http://www.google.com/mapfiles/topbar.png',
					            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '9px', text: data[0].towerNo },
					            						title: "Click here to view details of Tower ID "+data[0].towerNo + " ID " + data[0].id
					            					});
											  }
											}else{


												if(data[0].supportType == 3){
													var marker = new google.maps.Marker({
					            						position: latLng,
					            						map: map,
					            						icon: 'http://labs.google.com/ridefinder/images/mm_20_yellow.png',
					            						title: "Click here to view details of Tower ID "+data[0].id,
					            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GB' }
					            					});
											  }else if(data[0].supportType == 4){
													var marker = new google.maps.Marker({
					            						position: latLng,
					            						map: map,
					            						icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
					            						title: "Click here to view details of Tower ID "+data[0].id,
					            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GSSB' }
					            					});
											  }else if(data[0].supportType == 7){
													var marker = new google.maps.Marker({
					            						position: latLng,
					            						map: map,
					            						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
					            						title: "Click here to view details of Tower ID "+data[0].id,
					            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'SW' }
					            					});
											  }else{
												  var marker = new google.maps.Marker({
						        						position: latLng,
						        						map: map,
						        						title: "Click here to view details of Tower ID "+data[0].towerNo + " ID " + data[0].id,
						        						icon: {
						        					          path: google.maps.SymbolPath.CIRCLE,
						        					          scale: 1
						        					    }
						        					});
											  }




												
				        						
				                		}
				        					var towerid = data[0].id;
				        					var lineid = data[0].lineId;
				        					var firstObj = json[i];
				        					var secondObj = json[i+1];

				        					
				        					if(secondObj){
				        					if(firstObj[0].lineId == secondObj[0].lineId){
				        						 var flightPlanCoordinates = [
				            					                              {lat: firstObj[0].gpsLatitude, lng: firstObj[0].gpsLongitude},
				            					                              {lat: secondObj[0].gpsLatitude, lng: secondObj[0].gpsLongitude}
				            					                              
				            					                            ];
				        						 var flightPath = new google.maps.Polyline({
						                              path: flightPlanCoordinates,
						                              geodesic: true,
						                              strokeColor: '#FF0000',
						                              strokeOpacity: 3.0,
						                              strokeWeight: 6
						                            });
				           						flightPath.setMap(map);

						                            
				            				}
				        					}
				        				        					// Creating a closure to retain the correct data, notice how I pass the current data in the loop into the closure (marker, data)
				        					(function(marker, data) {

				            					
												var supType;
												if(data[0].supportType == 1){
													supType = 'Tower';
												}else if(data[0].supportType == 2){
													supType = 'Pole';
												}else if(data[0].supportType == 3){
													supType = 'Gantry Bay';
												}else if(data[0].supportType == 4){
													supType = 'GSS Bay';
												}else if(data[0].supportType == 5){
													supType = 'Line Gantry';
												}else if(data[0].supportType == 6){
													supType = 'Lattice Pole';
												}else if(data[0].supportType == 7){
													supType = 'Switch';
												}else{
													supType = 'NONE';
												} 
												       						       
																				
												var lineid =data[0].towerNo;
												var towerNO =  data[0].towerNo;
												
												 var urll = 'http://localhost:9090/MMS/editCompletionData?towerNo='+data[0].id +'&test=test';
												 
												// var url2 = 'http://localhost:9090/MMS/editCompletionData?towerNo='+data[0].id +'&test=test';
													
												 var url = '<div id="content">'+
											      '<div id="siteNotice">'+
											      '</div>'+
											      '<p><a href='+urll+'>'+
											      'Add Completion Data'+
											      '</p>'+
											      '</div>'+
											      '</div>';

												
												var lineType;
												
												if(data[3].lineType == 1){
													lineType = 'Backbone';
												}else{
													lineType = 'Distributor';
												}
												
												
												var noOfCiur;
												
												if(data[0].noOfCircuits == 1){
													noOfCiur = 'Single';
												}else if (data[0].noOfCircuits == 2){
													noOfCiur = 'Double';
												}else{
													noOfCiur = 'Both';
												}
												
												
												var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr>"+
												"<tr><td><button type='button' id='myBtn'  onClick='viewFrom(\"" + data[0].towerNo + "\",\"" + data[0].tapping + "\",\"" + data[0].id + "\",\"" + data[0].mapId + "\",\"" + data[3].lineName + "\",\"" + data[3].id + "\")'>From</button></td><td><button type='button' id='myBtn'  onClick='viewTo(\"" + data[0].towerNo + "\",\"" + data[0].tapping + "\",\"" + data[0].id + "\",\"" + data[0].mapId + "\",\"" + data[3].lineName + "\",\"" + data[3].id + "\")'>To</button></td></tr> "+
												"<tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
												data[0].towerNo+"</td></tr><tr><td>Latitude :  </td><td>"+
												data[0].gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
												data[0].gpsLongitude+"</td></tr><tr><td>Line Name : </td><td>"+
												
												data[3].lineName+"</td></tr><tr><td>Line Length(km) : </td><td>"+
												
												data[3].length+"</td></tr><tr><td>Line Type : </td><td>"+
												
												lineType+"</td></tr><tr><td>No. of Towers : </td><td>"+
												
												data[3].nooftowers+"</td></tr><tr><td>No. of Poles : </td><td>"+
												
												data[3].noofpoles+"</td></tr><tr><td>Area : </td><td>"+
												
												data[5]+"</td></tr><tr><th>Technical Detail</th></tr>"+
												"</tr><tr><td>Support type :  </td><td>"+
												supType+"</td></tr>"+
												"<tr><td>Tower type :  </td><td>"+data[2]+"</td></tr>"+
												"<tr><td>Conductor Type :  </td><td>"+data[1]+"</td></tr>"+
												"<tr><td>No. of Circuits :  </td><td>"+noOfCiur+"</td></tr>"+
												"<tr><td>Tower Conf :  </td><td>"+								
												data[4]+"</td></tr>"+
												"<tr><td>Tappings :  </td><td>"+data[0].tapping+"</td></tr>"+
												 "<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
													/* "<tr><td>Last Maintenance Date :  </td><td></td></tr>"+
													 */"<tr><td><button type='button' id='myBtn' data-toggle=modal data-target=#myModal onClick='view(\"" + data[0].id + "\")'>View</button></td></tr> "+
													/* "<tr><td>Hot line maintenance details (ES validated maintenance work summary) :  </td><td></td></tr>"+
													"<tr><td>Cold line maintence details  (ES validated maintenance work summary) :  </td><td></td></tr>"+
													 */"</table></div>";

					
				        						google.maps.event.addListener(marker, "click", function(e) {

				        							infoWindow.setContent(insDetailTable+url);
				        									infoWindow.open(map, marker);
				        						});


				        					})(marker, data);

				        				}
				                		map.fitBounds(bounds);

				                		
				        				
				                }
				                
				         });
					}


					function validateForm()
					{
						var dateoftripping = document.getElementById("dateoftripping").value;
						var timeDuration = document.getElementById("timeDuration").value;
						var timeDuration2 = document.getElementById("timeDuration2").value;
						var trippingType = document.getElementById("tripingType").value;
						var causeoftripping = document.getElementById("causeoftripping").value;
						var areaEffected = document.getElementById("areaEffected").value;
						var noofconsumer = document.getElementById("noofconsumer").value;
						var strArea = area.options[area.selectedIndex].value;
						var strLine = line.options[line.selectedIndex].value;
						var strProvince = province.options[province.selectedIndex].value;
						
						
						if (dateoftripping === "")
							{
							alert("Date of tripping may not be empty");
							event.preventDefault();
							return false;
						} else if (timeDuration === ""){
							alert("Time Duration - From  may not be empty");
							event.preventDefault();
							return false;
						}else if (timeDuration2 === ""){
							alert("Time Duration -To may not be empty");
							event.preventDefault();
							return false;
						}else if (trippingType === ""){
							alert("Please select tripping type");
							event.preventDefault();
							return false;
						}else if (causeoftripping === ""){
							alert("Cause of Tripping may not be empty");
							event.preventDefault();
							return false;
						}else if (areaEffected === "NONE"){
							alert("Area Effected may not be empty");
							event.preventDefault();
							return false;
						}else if (noofconsumer === "NONE"){
							alert("No.Consumer may not be empty");
							event.preventDefault();
							return false;
						}else if (strLine === "-1"){
							alert("Line may not be empty");
							event.preventDefault();
							return false;
						}else if (strProvince === "NONE"){
							alert("Province may not be empty");
							event.preventDefault();
							return false;
						}else{
							return true;
						}
						return true;
					
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
						//getLocation();
						 if(!!navigator.geolocation) {
									//alert('Support');
														
									navigator.geolocation.getCurrentPosition(function(position) {
									var pos = {
							              lat: position.coords.latitude,
							              lng: position.coords.longitude
							        };
									map.setCenter(pos);
							        var marker = new google.maps.Marker({
										position: pos,
										map: map,
										icon: '<c:url value="/resources/img/CEBImages/mylocation.png"/>',
										title: "You are here !!!"
									});
							        });
								}
								else {
									//alert('No Support');
								}
						
						}
					
					
					function view(){
			      			
						var url="downloadFeederReport";
	  		    	    var width = 1100;
	  		    	    var height = 700;
	  		    	    var left = parseInt((screen.availWidth/2) - (width/2));
	  		    	    var top = parseInt((screen.availHeight/2) - (height/2));
	  		    	    var windowFeatures = "width=" + width + ",height=" + height + 
	  		    	    ",status,resizable,left=" + left + ",top=" + top +
	  		    	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	  		    	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
	 
			      		
			      		
			      	}
					
					function send(){
						var strProvince = province.options[province.selectedIndex].value;
						
						$.ajax({
							type : 'GET',
							url : "/MMS/sendNotificationTrriping?province="+strProvince,
							data : {},
							contentType : "application/json; charset=utf-8",
							success : function(data) {
								
							}
						}); 
						
						alert('Successfully Done');
					}
			          
			          


												
				 
				 
			</script>
			
<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&libraries=geometry">
</script>

<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap&libraries=geometry&libraries=drawing"></script>

			
			
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
				                                <li class="active"><span>Add Tripping</span></li>
				                            </ol>
				
				                            
				                        </div>
							                                    
										<%@ include file="sections/userDetails.jsp" %> 
									</div>
								</div>
								
								
								<div class="col-sm-12" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
									
					            </div>
					            <br><br>
					            <div class="col-sm-12" align="left">

										<div id="dashboard_div">
      <!--Divs that will hold each control and chart-->
      <div id="filter_div"></div>
      <div id="table_div"></div>

												</div>
												
												<div class="form-group">
<div class="pull-left">

<input type="button" Value="View Report" class="btn btn-success" onClick="view()"/>
<input type="button" Value="Send Notification" class="btn btn-success" onClick="send()"/>

</div>
</div>
												
																		
					            </div>
								<br><br>
					            
								
								
								
								
					
								<div class="row">
						<div class="col-lg-12">
							<div class="main-box clearfix">
								<div class="main-box-body clearfix">
									<div class="table-responsive">
										<table class="table table-responsive" id="tblProvinces">

											<thead>

											</thead>
											<tbody>
											<form:form method="post" role="form" modelAttribute="model" action="saveTripping" onsubmit="return validateForm()" id="reg">
													
													
													<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">Province</form:label></td>
															<td width="70%" style="text-align: left"><form:select id="province" path="glcompmobj.compId"
																onchange="findArea()"
																style="width:100%; background-color: #8187ff; border-radius: 5px;">
																
																<form:options items="${model.provinceList}" />
															</form:select></td>
													</tr>
													<tr>
															<td width="30%" style="text-align: left">
																<form:label path="">Area</form:label>
															</td>
															<td width="70%" style="text-align: left">
																<form:select id="area" path="gldeptobj.deptId" onchange="getLine()" style="width:100%; background-color: #94cb71; border-radius: 5px;">
																		<form:option value="NONE" label="AREA" />
																		<form:options items="${model.areaList}" />
																</form:select>
																<c:if test="${not empty model.error5}">
																		<div>
																			<span id="spnLocation" class="label label-danger">${model.error5}></span>
																		</div>
																</c:if>
															</td>
 													</tr>	
 													<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">Line</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="line" path="line.id" onchange="loadNetwork()"
																	style="width:100%; background-color: #8187ff; border-radius: 5px;">
																	<form:option value="-1" label="LINE" />
																	<form:options items="${model.lineList}" />
																</form:select></td>
													</tr>
													
													
													
													<tr>
															<td width="30%" style="text-align:left">
                												<form:label path="">Date</form:label>
                											</td>
                											<td width="70%" style="text-align:left">
	                											<label>
																	<form:input path="objTripping.workingDate" type="date" id="dateoftripping" class="form-control"/>
																		
																</label>
															</td>
													</tr>
													<tr>
															<td width="30%" style="text-align:left">
                												<form:label path="">Time Duration - From</form:label>
                											</td>
                											<td width="70%" style="text-align:left">
	                											<label>
																	<form:input path="objTripping.fromtime" type="time" id="timeDuration" placeholder="Time Duration of Work" class="form-control"/>
																		
																</label>
															</td>
													</tr>
													<tr>
															<td width="30%" style="text-align:left">
                												<form:label path="">Time Duration - To</form:label>
                											</td>
                											<td width="70%" style="text-align:left">
	                											<label>
																	<form:input path="objTripping.totime" type="time" id="timeDuration2" onchange="calculateDuration()" placeholder="Time Duration of Work" class="form-control"/>
																		
																</label>
															</td>
													</tr>
													<tr>
															<td width="30%" style="text-align:left">
                												<form:label path="">Duration(Min)</form:label>
                											</td>
                											<td width="70%" style="text-align:left">
	                											<label>
																	<form:input type="text" id="duration" path="objTripping.duration" rows="5" cols="60" placeholder="Duration(Min)" class="form-control"/>
																			
																</label>
															</td>
													</tr>
													<tr>
															<td width="30%" style="text-align:left">
                												<form:label path="">Type of Tripping </form:label>
                											</td>
                											<td width="70%" style="text-align:left">
	                											<label>
																	<form:select path="objTripping.trippingType" class="form-control" multiple="true" id="tripingType" name="cmbSelectFeederType">
										                        <form:option value="Earth Fault">Earth Fault</form:option>
													            <form:option value="Over Current">Over Current</form:option>
													            <form:option value="Under Frequency">Under Frequency</form:option>
																<form:option value="Manual">Manual</form:option>
																</form:select>		
																</label>
															</td>
													</tr>
													<tr>
															<td width="30%" style="text-align:left">
                												<form:label path="">Cause of Tripping</form:label>
                											</td>
                											<td width="70%" style="text-align:left">
	                											<label>
																	<form:textarea id="causeoftripping" path="objTripping.reason" rows="5" cols="60" placeholder="Cause of tripping" class="form-control"/>
																				
																</label>
															</td>
													</tr>
													<tr>
															<td width="30%" style="text-align:left">
                												<form:label path="">Areas Effected</form:label>
                											</td>
                											<td width="70%" style="text-align:left">
	                											<label>
																	<form:textarea path="objTripping.areaEffected" rows="5" cols="60" id="areaEffected" placeholder="Areas effected" class="form-control"/>
																				
																</label>
															</td>
													</tr>
													<tr>
															<td width="30%" style="text-align:left">
                												<form:label path="">No. of Effected Consumers</form:label>
                											</td>
                											<td width="70%" style="text-align:left">
	                											<label>
																	<form:input type="number" path="objTripping.noOfConsumer" rows="5" cols="60" id="noofconsumer" placeholder="No. of Effected consumers" class="form-control"/>
																				
																</label>
															</td>
													</tr>
													
													
													
													
													<tr>
													<td width="30%" style="text-align:left">
                									<form:input path ="" type="submit" Value="Add Tripping Info" class="btn btn-success" onclick="validateForm()"></form:input>
												    </td>
												    </tr>
											</form:form>
											</tbody>
										</table>
												
												
											
									</div>
								</div>
							</div>
						</div>
					</div>
									
											 					
								<%@ include file="sections/footer.jsp" %>

						</div>
					</div>
				</div>
			</div>
			
		<%@ include file="sections/global_scripts.jsp" %>
		
	</body>
</html>