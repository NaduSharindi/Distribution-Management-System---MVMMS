<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- <style type="text/css">
table, th, td {
	border: 0px solid black;
	align: left;
	text-align: left;
}
</style>
 -->



<html>

<head>
<!-- meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"-->
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>MV-MMS</title>
<%@ include file="sections/headEdit.jsp"%>

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


/* .form-control {
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
 */

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

}




</style>
<!-- <script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&libraries=geometry">
 -->

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap&libraries=geometry&libraries=drawing"></script>


<script type="text/javascript">

var drawingManager;
var all_overlays = [];
var selectedShape;
var colors = ['#1E90FF', '#FF1493', '#32CD32', '#FF8C00', '#4B0082'];
var selectedColor;
var colorButtons = {};
var infoWindowNew = new google.maps.InfoWindow();


function clearSelection() {
	   if (selectedShape) {
	     selectedShape.setEditable(false);
	     selectedShape = null;
	   }
	 }

	 function setSelection(shape) {
	   clearSelection();
	   selectedShape = shape;
	   shape.setEditable(true);
	   selectColor(shape.get('fillColor') || shape.get('strokeColor'));
	 }

	 function deleteSelectedShape() {
	   if (selectedShape) {
	     selectedShape.setMap(null);
	   }
	 }

	 function deleteAllShape() {
	   for (var i = 0; i < all_overlays.length; i++) {
	     all_overlays[i].overlay.setMap(null);
	   }
	   all_overlays = [];
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
	 
	 
	 function validateForm() {
			clearErrorMessages();
			
		    try {
		    	 			    	 
		    	 if (validateEmpty("txtLocation") == false) {
                  throw 1000;
              }
		    	 
		    

		    	 return true;
				
			} catch (e) {
				if (e == 1000) {
                 ScrollToElement("spnLocation");
             }
				
			
				
				return false;
			}
		}
		
		 function clearErrorMessages() {
          document.getElementById('spnLocation').innerHTML = "";
         
          
      }
	 

	 function selectColor(color) {
	   selectedColor = color;
	   for (var i = 0; i < colors.length; ++i) {
	     var currColor = colors[i];
	     colorButtons[currColor].style.border = currColor == color ? '2px solid #789' : '2px solid #fff';
	   }

	   // Retrieves the current options from the drawing manager and replaces the
	   // stroke or fill color as appropriate.
	   var polylineOptions = drawingManager.get('polylineOptions');
	   polylineOptions.strokeColor = color;
	   drawingManager.set('polylineOptions', polylineOptions);

	   var rectangleOptions = drawingManager.get('rectangleOptions');
	   rectangleOptions.fillColor = color;
	   drawingManager.set('rectangleOptions', rectangleOptions);

	   var circleOptions = drawingManager.get('circleOptions');
	   circleOptions.fillColor = color;
	   drawingManager.set('circleOptions', circleOptions);

	   var polygonOptions = drawingManager.get('polygonOptions');
	   polygonOptions.fillColor = color;
	   drawingManager.set('polygonOptions', polygonOptions);
	 }

	 function setSelectedShapeColor(color) {
	   if (selectedShape) {
	     if (selectedShape.type == google.maps.drawing.OverlayType.POLYLINE) {
	       selectedShape.set('strokeColor', color);
	     } else {
	       selectedShape.set('fillColor', color);
	     }
	   }
	 }

	 function makeColorButton(color) {
	   var button = document.createElement('span');
	   button.className = 'color-button';
	   button.style.backgroundColor = color;
	   google.maps.event.addDomListener(button, 'click', function() {
	     selectColor(color);
	     setSelectedShapeColor(color);
	   });

	   return button;
	 }

	 function buildColorPalette() {
	   var colorPalette = document.getElementById('color-palette');
	   for (var i = 0; i < colors.length; ++i) {
	     var currColor = colors[i];
	     var colorButton = makeColorButton(currColor);
	     colorPalette.appendChild(colorButton);
	     colorButtons[currColor] = colorButton;
	   }
	   selectColor(colors[0]);
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
	
	/*  drawingManager = new google.maps.drawing.DrawingManager({
         drawingMode: google.maps.drawing.OverlayType.MARKER,
         drawingControl: true,
         drawingControlOptions: {
           position: google.maps.ControlPosition.TOP_CENTER,
           drawingModes: ['marker', 'circle', 'polygon', 'polyline', 'rectangle']
         },
         markerOptions: {icon: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png'},
         circleOptions: {
           fillColor: '#ffff00',
           fillOpacity: 1,
           strokeWeight: 5,
           clickable: false,
           editable: true,
           zIndex: 1
         }
       });
       drawingManager.setMap(map);
       
       google.maps.event.addListener(drawingManager, 'overlaycomplete', function(e) {
    	    all_overlays.push(e);
    	    if (e.type != google.maps.drawing.OverlayType.MARKER) {
    	    // Switch back to non-drawing mode after drawing a shape.
    	    drawingManager.setDrawingMode(null);
    	    // Add an event listener that selects the newly-drawn shape when the user
    	    // mouses down on it.
    	    var newShape = e.overlay;
    	    newShape.type = e.type;
    	    google.maps.event.addListener(newShape, 'click', function() {
    	      setSelection(newShape);
    	    });
    	    setSelection(newShape);
    	  }
    	});
       
 */       
       
       
       
 
}





	var checkBoxSelected = [];

	function addCheckedToArray(id) {
		var checkBox = document.getElementById("cb_" + id);
		if (checkBox.checked == true) {
			checkBoxSelected.push(id);
		} else {
			checkBoxSelected = arrayRemove(checkBoxSelected, id);
		}
		alert(checkBoxSelected);
	}

	function arrayRemove(arr, value) {

		return arr.filter(function(ele) {
			return ele != value;
		});

	}

	function goToEstimate() {

		var str = "";
		for (var i = 0; i < checkBoxSelected.length; i++) {
			if (i != 0) {
				str = str + "," + checkBoxSelected[i];
			} else {
				str = checkBoxSelected[0];
			}
		}
		alert(str);

		$.ajax({
			type : "GET",
			url : "/MMS/goToEstimate/" + str,
			success : function(response) {
				alert(response);
				console.log(response);
			}
		});
	}

	function ConfirmActivate(comid) {

		//alert("hiiii");
		$.ajax({

			type : 'GET',
			url : "/MMS/viewProvinceNew/" + comid,
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(response) {
				alert(response);

			}
		});
	}

	function showProvinces() {

		$
				.ajax({
					type : 'GET',
					url : '/MMS/findAllProvinces/',
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(response) {
						$("#tblProvinces > tbody:last").children().remove();

						//Insert item from the response
						for (var i = 0; i < response.length; i++) {
							var item = response[i];
							var comid = item.compId;

							tr = $('<tr/>');
							tr.append("<td> " + item.compNm + "</td>");
							tr
									.append("<td>"
											+ "<button type='button' class='btn btn-info' onClick=ConfirmActivate('"
											+ comid + "')>Go</button>"
											+ "</td>");

							$('#tblProvinces').append(tr);
						}

						$('#tblProvinces').dataTable({
							'info' : false,
							'pageLength' : 10,
							retrieve : true
						});
					}
				});
	}

	function findArea() {
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = province.options[province.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

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
									+ "<option value='" + data[ i ].deptId + "'>"
									+ data[i].deptNm + "</option>";
						}
						slctSubcat.append(option);

						//alert("response.towerNo" + data);	
					}
				});
	}

	function getLine() {
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = area.options[area.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$
				.ajax({
					type : 'GET',
					url : "/MMS/findLineByArea/" + strUser + "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#line'), option = "<option value='NONE'>ALL</option>" ;
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

	function ConfirmActivate(comid) {

		alert("hiiii");
		$.ajax({

			type : 'GET',
			url : "/MMS/viewProvinceNew/" + comid,
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(response) {
				alert(response);

			}
		});

	}

	function showProvinces() {

		$
				.ajax({
					type : 'GET',
					url : '/MMS/findAllProvinces/',
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(response) {
						$("#tblProvinces > tbody:last").children().remove();

						//Insert item from the response
						for (var i = 0; i < response.length; i++) {
							var item = response[i];
							var comid = item.compId;

							tr = $('<tr/>');
							tr.append("<td> " + item.compNm + "</td>");
							tr
									.append("<td>"
											+ "<button type='button' class='btn btn-info' onClick=ConfirmActivate('"
											+ comid + "')>Go</button>"
											+ "</td>");

							$('#tblProvinces').append(tr);
						}

						$('#tblProvinces').dataTable({
							'info' : false,
							'pageLength' : 10,
							retrieve : true
						});
					}
				});
	}

	function findArea() {
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = province.options[province.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

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

						//alert("response.towerNo" + data);	
					}
				});

	}

	function getLine() {
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = area.options[area.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

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
							var str = data[i].lineName + "(" + data[i].name + "-" + data[i].feederIdentification + "-" + data[i].feeder2 + ")";
							
							option = option
									+ "<option value='"+data[i].id + "'>"
									+ str +  "</option>";
						}
						slctSubcat.append(option);

						//alert("response.towerNo" + data);	
					}
				});

	}
	
	/* function viewFrom(towerNo,mapId){
		//alert(mapId);
		document.getElementById("from").value=towerNo;
		document.getElementById("mapId").value=mapId;
		
		
		
	}
	 */
	 var tap;
	 var frommapid;
	 
	 function viewFrom(towerNo,tapping,id,mapid,lineName,lineid){
		 document.getElementById("from").value=towerNo;
		 document.getElementById("fromtowerid").value=id;
		 document.getElementById("fromtowermapid").value=mapid;
		 frommapid = mapid;
		 // alert(lineName);
		 /*  if(tapping == 0){
			//document.getElementById("txtFOW").value=towerNo;
		 }else if (tapping == 1){
			// tap = towerNo + '-' + tapping +' Tapping';
			 tap = towerNo;
			 document.getElementById("txtFOW").value=towerNo + '-' + tapping +' Tapping'; 
		 }else {
			 //tap = towerNo + '-' + tapping +' Tappings';
			 tap=towerNo;
			 document.getElementById("txtFOW").value=towerNo + '-' + tapping +' Tappings';
		 }
		 */  
		 
		 
		// infoWindowNew.close();
	}
	 
	 
	 function isEmpty(str)
	 {
	     return (!str || 0 === str.length);
	 }
	 
	 function viewTo(towerNo,tapping,id,mapid,lineName,lineid){
		document.getElementById("to").value=towerNo;
		document.getElementById("totowerid").value=id;
		document.getElementById("totowermapid").value=mapid;
		//alert(lineName);
		
		var strArea = area.options[area.selectedIndex].value;
		var strLine = line.options[line.selectedIndex].value;
		var url = "/MMS/getTapping/" + strArea +"/"+strLine+"/"+frommapid+"/"+mapid+"/";
		//alert(url);
		var tappingStr ='';
		
		 $
				.ajax({
					type : 'GET',
					url : url,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						//alert(data);
						if(isEmpty(data)){
							document.getElementById("txtFOW").value='Line Electrical Maintenance of '+lineName+'\nAll tappings in the interrupted section need to be isolated & earthed from the network'; 
							
							
						}else{
							for (var i = 0; i < data.length; i++) {
								
								tappingStr += data[i].towerNo + ", ";
								
							}
							
							//alert("response.towerNo" + tappingStr);	
							document.getElementById("txtFOW").value='Line Electrical Maintenance of '+lineName+'\nTappings\n' +tappingStr  + '\nAbove mentioned tappings & all other tappings in the interrupted section need to be isolated & earthed from the network'; 
							
						}
						
						
					}
				});
 
		 
		/* if(tapping == 0){
			document.getElementById("txtFOW").value='Line Electrical Maintenance of '+lineName;
		 }else if (tapping == 1){
			 //tap = towerNo + '-' + tapping +' Tapping';
			 
			 //document.getElementById("txtFOW").value='Line Electrical Maintenance of '+lineName+'\nTappings\n1.' + tap + '\n2.'+ towerNo + '\n above mentioned tappings & all other tappings in the interrupted section need to be isolated from the network .'; 
			 
			 document.getElementById("txtFOW").value='Line Electrical Maintenance of '+lineName+'\nTappings\n' +tappingStr  + '\n above mentioned tappings & all other tappings in the interrupted section need to be isolated from the network .'; 
			 
		 }else {
			// tap = towerNo + '-' + tapping +' Tappings';
			 
			 document.getElementById("txtFOW").value='Line Electrical Maintenance of '+lineName+'\nTappings\n' + tappingStr + '\n above mentioned tappings & all other tappings in the interrupted section need to be isolated from the network .';
		 }
		 */
		 
		
		
		
		
		
	}
	 
	 /* function getDate(){
		    var today = new Date();

		document.getElementById("dateofwork").value = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + today.getDate()).slice(-2);


		}	
 */	
	function viewMapByMode(){
		var viewMode = mode.options[mode.selectedIndex].value;
		//alert(viewMode);
    	
		if(viewMode=='MAP'){
			loadMapWithoutMnt();
		}else if(viewMode=='NETWORK'){
			loadNetwork();
		}else{
			//loadNetwork();
		}
		
	}
	
	
	function viewMapByModeAE(){
		var viewMode = mode.options[mode.selectedIndex].value;
		//alert(viewMode);
    	
		if(viewMode=='MAP'){
			loadMapWithoutMntAE();
		}else if(viewMode=='NETWORK'){
			loadNetwork();
		}else{
			//loadNetwork();
		}
		
	}
	
	
	
	
	
	function loadMapWithoutMntAE() {
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
		
		//variables for get the move location
		
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + bounds );
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNewInt/" + strArea +"/" + strLine +"/"+strProvince,
                 data: {},
                contentType: "application/json; charset=utf-8",
                success : function(json){
                	//alert(json.length);
                	
                		for (var i = 0, length = json.length; i < length; i++) {
        					var data = json[i],
        						latLng = new google.maps.LatLng(data[0].gpsLatitude, data[0].gpsLongitude);
        						//alert('huuuuuuu');
        						//bounds.extend(latLng);
        						//alert('huuuuuuu4');
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
								  if(data[0].supportType == 1){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkere.png"/>',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id
    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
    	            					});
										 
									  }
								  else if(data[0].supportType == 2){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
    	            						icon: '<c:url value="/resources/img/CEBImages/polemarkere.png"/>',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id
    	            						//label: { color: '#5DADE2', fontWeight: 'bold', fontSize: '12px', text: 'P' }
    	            					});
									  }
								  else if(data[0].supportType == 3){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_yellow.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GB' }
    	            					});
								  }else if(data[0].supportType == 4){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GSSB' }
    	            					});
								  }else if(data[0].supportType == 5){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_green.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'LG' }
    	            					});
								  }else if(data[0].supportType == 6){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_blue.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'LP' }
    	            					});
								  }else if(data[0].supportType == 7){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'SW' }
    	            					});
								  }else{
										//alert("test13 : "+ data.area);
	            					var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	            						title: "Click here to view details of Tower ID "+data[0].id,
	            						label: { color: '#FAF8F8', fontWeight: 'bold', fontSize: '14px', text: '' }
	            					});
								  }
								  
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
							
        					//data.gpsLatitude, data.gpsLongitude
        					
        					// var flightPlanCoordinates = [
        					                       //       {lat: json[i].gpsLatitude, lng: json[i].gpsLongitude},
        					                       //       {lat: json[i+1].gpsLatitude, lng: json[i+1].gpsLongitude}
        					                              
        					                         //   ];
        					                          //  var flightPath = new google.maps.Polyline({
        					                             // path: flightPlanCoordinates,
        					                             // geodesic: true,
        					                              //strokeColor: '#FF0000',
        					                              //strokeOpacity: 1.0,
        					                             // strokeWeight: 2
        					                           // });

        					                           // flightPath.setMap(map);
        					
							
        				//var flightPlanCoordinates = [{lat: data.gpsLatitude , lng: data.gpsLongitude}];
        				//var point =latLng;
        				//flightPlanCoordinates.push(point); 
        				//var flightPath = new google.maps.Polyline({
        			   // path: flightPlanCoordinates,
        				        //  geodesic: true,
        				        //  strokeColor: '#FF0000',
        				         // strokeOpacity: 1.0,
        				         // strokeWeight: 2
        				       // });

        				      // flightPath.setMap(map);

        					// Creating a closure to retain the correct data, notice how I pass the current data in the loop into the closure (marker, data)
        					
        					
        					var firstObj = json[i];
	        				var secondObj = json[i+1]; 
	        				
        					
        					(function(marker, data) {

        						
	        					
							/*  if(firstObj[0].lineId == secondObj[0].lineId){
								//var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
        						var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
        						var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
   							 	var distance = calcDistance(p1, p2);
   							    totalLength = distance + distance;
   							 	alert("hiiii2" + totalLength );
   							 	//var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
   							 	//alert("hiiii2 : " + calcDistance(p1, p2));
   							 	/* function calcDistance(p1, p2){
   								  alert("hiiii5");
   								  return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
   							 	} 

		   							
   							 }  */

							/* function calcDistance(p1, p2){
   								if(firstObj[0].lineId == secondObj[0].lineId){
        							var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
        							var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
        						}
 								  //alert("hiiii5");
 								  return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
 							} */
//alert(i);
        						function calcDistance(){
        							//alert("hiiii2 : " + i + secondObj[0]);
            						//if(!secondObj[0]){
            						
            						if(secondObj){
       								if(firstObj[0].lineId == secondObj[0].lineId){
            							var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
            							var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
            							// return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
            							return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2)).toFixed(2);
                 						  
                						}
       								else{
           								return '0';
           								}
            						}else{
           								return '0';
       								}
     								  //alert("hiiii5");
     								  // }
     							}

            					
        						//alert("hiiii3 : " + i + calcDistance());	
								
//alert('' + data[0].supportType);
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
								       						       
								//var contentString = "<div style='float:left'><img src='<c:url value="/resources/img/CEBImages/Tower1.png"/>'></div>";
								//var genInformation ="<div style='float:right; padding: 10px;'><b></b><br/><b>Tower Number:  </b>"+
								//data[0].towerNo+"</br>"+"<b>Area : </b>"+
								//data[0].area+"</br>"+"<b>Support type : </b>"+
    							//supType+"</br>"+"<b>Latitude : </b>"+
    							//data[0].gpsLatitude+"</br>"+"<b>Longitude :</b>"+
    							//data[0].gpsLongitude+"</br></div>";

    							//var techDetail ="<div style='float:right; padding: 10px;'><b>Technical Detail </b><br/><br/><b>Conductor Type:  </b>"+
								//data[2]+"</br>"+"<b>Tappings : </b>"+
								//data[1].nooftappings+"</br>"+"<b>Tower type : </b>"+
								//data[3]+"</br></div>";

								//var insDetail ="<div style='float:right; padding: 10px;'><b>Inspection Detail </b><br/><br/><b>Conductor Type:  </b>"+
								//data[2]+"</br>"+"<b>Tappings : </b>"+
								//data[1].nooftappings+"</br>"+"<b>Tower type : </b>"+
								//data[3]+"</br></div>";
								
								var lineid =data[0].towerNo;
						/* 		var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
								data[0].towerNo+"</td></tr><tr><td>Distance to next tower (m) :</td><td>"+
								calcDistance()+"</td></tr><tr><td>Area : </td><td>"+
								
								data[0].area+"</td></tr><tr><td>Support type :  </td><td>"+
								supType+"</td></tr><tr><td>Tower Conf :  </td><td>"+
								data[5]+"</td></tr><tr><td>Latitude :  </td><td>"+
								data[0].gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data[0].gpsLongitude+"</td></tr><tr> </tr><tr><th>Technical Detail</th></tr>"+
								"<tr><td>Conductor Type :  </td><td>"+data[2]+"</td></tr>"+
								"<tr><td>Tappings :  </td><td>"+data[1].nooftappings+"</td></tr>"+
								"<tr><td>Tower type :  </td><td>"+data[3]+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Inspection Detail</th></tr>"+
								"<tr><td>Latest Inspection Date :  </td><td></td></tr>"+
								"<tr><td>Wayleaves :  </td><td>"+data[1].wayleavestatus+"</td></tr>"+
								"<tr><td>Base Concrete :  </td><td>"+data[1].baseconcretestatus+"</td></tr>"+
								"<tr><td>Conductor Status : </td><td>"+data[1].conductorstatus+"</td></tr>"+
								"<tr><td>Jumper Status :  </td><td>"+data[1].jumperstatus+"</td></tr>"+
								"<tr><td>Missing Parts :  </td><td>"+data[1].noofmissingparts+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td>Last Maintenance Date :  </td><td></td></tr>"+
								"<tr><td>Hot line maintenance details (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"<tr><td>Cold line maintence details  (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"</table></div>"; */


								/* var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
								data[0].towerNo+"</td></tr><tr><td>Distance to next tower (m) :</td><td>"+
								calcDistance()+"</td></tr><tr><td>Area : </td><td>"+
								
								data[0].area+"</td></tr><tr><td>Support type :  </td><td>"+
								supType+"</td></tr><tr><td>Tower Conf :  </td><td>"+
								data[5]+"</td></tr><tr><td>Latitude :  </td><td>"+
								data[0].gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data[0].gpsLongitude+"</td></tr><tr> </tr><tr><th>Technical Detail</th></tr>"+
								"<tr><td>Conductor Type :  </td><td>"+data[2]+"</td></tr>"+
								"<tr><td>Tappings :  </td><td>"+data[1]+"</td></tr>"+
								"<tr><td>Tower type :  </td><td>"+data[3]+"</td></tr>"+
							
								"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td>Last Maintenance Date :  </td><td></td></tr>"+
								"<tr><td>Hot line maintenance details (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"<tr><td>Cold line maintence details  (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"</table></div>"; */
								
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
								
								
								var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td>"+
								data[0].towerNo+"</td></tr><tr><td>Distance to next tower (m) :</td><td>"+
								calcDistance()+"</td></tr><tr><td>Latitude :  </td><td>"+
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
								"<tr><td>Tappings :</td><td>"+data[0].tapping+"</td></tr>"+
								/* "<tr><td><button type='button' onclick='window.location.href='addProvince''>Back</button></td></tr> "+
								 *//* "<tr><td><a href='<c:url value="/editCompletionData"> <c:param name='towerNo'>${towerNO}</c:param></c:url>'>Add Completion Data</a></td><td></td></tr>"+
								 */"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								/* "<tr><td>Last Maintenance Date :  </td><td></td></tr>"+
								 */"<tr><td><button type='button' id='myBtn' onClick='view(\"" + data[0].id + "\")'>View</button></td></tr> "+
								/* "<tr><td>Hot line maintenance details (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"<tr><td>Cold line maintence details  (ES validated maintenance work summary) :  </td><td></td></tr>"+
								 */"</table></div>";

								
								
								
								/* function showMore(id) {
					                  alert('my id is ' + id);
					            }
								 function showShops() {
								 var  content=document.createElement('div'),
					              button;
					              content.innerHTML='some text<br/>';
					              button=content.appendChild(document.createElement('input'));
					              button.type='button';
					              button.value='click me!'
					              google.maps.event.addDomListener(button,'click', function(){
					                                                                 showMore('1');})
								
								 }
	 */
        						google.maps.event.addListener(marker, "click", function(e) {
        							 

        							//infoWindow.setContent("<b>Tower Number:  </b>"+
        								//	data[0].towerNo+"</br>"+"<b>Area : </b>"+
        								//	data[0].area+"</br>"+"<b>Support type : </b>"+
	            						//	supType+"</br>"+"<b>Latitude : </b>"+
	            						//	data[0].gpsLatitude+"</br>"+"<b>Longitude :</b>"+
	            						//	data[0].gpsLongitude+"</br>"+"<b>Conductor Type :</b>"+
	            						//	conType+"</br>"+"<b>Tappings : </b>"+
	            							//data[1].nooftappings+"</br>"+"<b>Tower Type : </b>"+
	            							//data[0].towerType+"</br>"+"<b>Latest Inspection Data : </b>"+
	            							//data[0].towerType+"</br>"+"<b>WayLeaves: </b>"+
	            							//data[1].wayleavestatus+"</br>"+"<b>Base Concrete : </b>"+
	            							//data[1].baseconcretestatus+"</br>"+"<b>Conductor Status : </b>"+
	            							//data[1].conductorstatus+"</br>"+"<b>Jumper Status : </b>"+
	            							//data[1].jumperstatus+"</br>"+"<b>Missing Parts : </b>"+
	            							//data[1].noofmissingparts+
	            							
	            							
	            							//"</br>"+"" +contentString + insDetailTable );
	            							
	            							infoWindow.setContent(insDetailTable);
        									infoWindow.open(map, marker);
        						});


        					})(marker, data);

        				}

                		map.fitBounds(bounds);

                		
                		//var polyline = new GPolyline([
    					                       //       new GLatLng(7.3171376, 80.5608933),
    					                           //   new GLatLng(7.3205831, 80.5581145)],
    					                           //   "#ff0000", 50);
    					                         //   map.addOverlay(polyline);

        				
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
		
		/* drawingManager = new google.maps.drawing.DrawingManager({
	         drawingMode: google.maps.drawing.OverlayType.MARKER,
	         drawingControl: true,
	         drawingControlOptions: {
	           position: google.maps.ControlPosition.TOP_CENTER,
	           drawingModes: ['marker', 'circle', 'polygon', 'polyline', 'rectangle']
	         },
	         markerOptions: {icon: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png'},
	         circleOptions: {
	           fillColor: '#ffff00',
	           fillOpacity: 1,
	           strokeWeight: 5,
	           clickable: false,
	           editable: true,
	           zIndex: 1
	         }
	       });
	       drawingManager.setMap(map);
	       
	       google.maps.event.addListener(drawingManager, 'overlaycomplete', function(e) {
	    	    all_overlays.push(e);
	    	    if (e.type != google.maps.drawing.OverlayType.MARKER) {
	    	    // Switch back to non-drawing mode after drawing a shape.
	    	    drawingManager.setDrawingMode(null);
	    	    // Add an event listener that selects the newly-drawn shape when the user
	    	    // mouses down on it.
	    	    var newShape = e.overlay;
	    	    newShape.type = e.type;
	    	    google.maps.event.addListener(newShape, 'click', function() {
	    	      setSelection(newShape);
	    	    });
	    	    setSelection(newShape);
	    	  }
	    	});*/
	 
		
		
		

		var infoWindow = new google.maps.InfoWindow();
		var strArea = area.options[area.selectedIndex].value;
		var strLine = line.options[line.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + strArea + strLine );
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNewWOMNT/" + strArea +"/" + strLine + "/" +strProvince,
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

								//	var marker = new google.maps.Marker({
            					//	position: latLng,
            						//map: map,
            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
            						//marker.setIcon(zoomIcons[map.getZoom()]);
            						//icon: 'http://maps.google.com/mapfiles/ms/icons/purple-dot.png',
            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
            						//title: "Click here to view details of Tower ID "+data.towerNo
            					//});
							
							
								//alert("data.tapping : "+ data.tapping);
							if(data[0].tapping > 0 ){


								if(data[0].supportType == 3){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_yellow.png',
	            						//icon: {
    					         // path: google.maps.SymbolPath.CIRCLE,
    					         // scale: 1
    					   // },
	            						title: "Click here to view details of Tower ID "+data[0].id,
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GB' }
	            					});
							  }else if(data[0].supportType == 4){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
	            						//icon: {
    					         // path: google.maps.SymbolPath.CIRCLE,
    					         // scale: 1
    					   // },
	            						title: "Click here to view details of Tower ID "+data[0].id,
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GSSB' }
	            					});
							  }else if(data[0].supportType == 7){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
	            						//icon: {
    					         // path: google.maps.SymbolPath.CIRCLE,
    					         // scale: 1
    					   // },
	            						title: "Click here to view details of Tower ID "+data[0].id,
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'SW' }
	            					});
							  }else{
								//alert("data.tapping");
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
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
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_yellow.png',
	            						//icon: {
    					         // path: google.maps.SymbolPath.CIRCLE,
    					         // scale: 1
    					   // },
	            						title: "Click here to view details of Tower ID "+data[0].id,
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GB' }
	            					});
							  }else if(data[0].supportType == 4){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
	            						//icon: {
    					         // path: google.maps.SymbolPath.CIRCLE,
    					         // scale: 1
    					   // },
	            						title: "Click here to view details of Tower ID "+data[0].id,
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GSSB' }
	            					});
							  }else if(data[0].supportType == 7){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
	            						//icon: {
    					         // path: google.maps.SymbolPath.CIRCLE,
    					         // scale: 1
    					   // },
	            						title: "Click here to view details of Tower ID "+data[0].id,
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'SW' }
	            					});
							  }else{
								  var marker = new google.maps.Marker({
		        						position: latLng,
		        						map: map,
		        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
		        						//marker.setIcon(zoomIcons[map.getZoom()]);
		        						//icon: 'http://www.google.com/mapfiles/dsliderbarshadow.png',
		        						title: "Click here to view details of Tower ID "+data[0].towerNo + " ID " + data[0].id,
		        						icon: {
		        					          path: google.maps.SymbolPath.CIRCLE,
		        					          scale: 1
		        					    }
		        					});
							  }




								
        						
                		}
        					//data.gpsLatitude, data.gpsLongitude
        					//	alert('ID : ' + json[i].id +'next id: ' + json[i+1].id);
        					
        					var towerid = data[0].id;
        					var lineid = data[0].lineId;
        					//alert('towerid:' +towerid + 'line id: '+ lineid);
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
        					
        		

        					                            
							
        				//var flightPlanCoordinates = [{lat: data.gpsLatitude , lng: data.gpsLongitude}];
        				//var point =latLng;
        				//flightPlanCoordinates.push(point); 
        				//var flightPath = new google.maps.Polyline({
        			   // path: flightPlanCoordinates,
        				        //  geodesic: true,
        				        //  strokeColor: '#FF0000',
        				         // strokeOpacity: 1.0,
        				         // strokeWeight: 2
        				       // });

        				      // flightPath.setMap(map);

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
									
								/*  var url = '<div id="content">'+
							      '<div id="siteNotice">'+
							      '</div>'+
							      '<p><a href='+urll+'>'+
							      'Add Completion Data'+
							      '</p>'+
							      '</div>'+
							      '</div>';

 */								
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
								
								var str = data[3].lineName + "(" + data[3].name + "-" + data[3].feederIdentification + "-" + data[3].feeder2 + ")";
								
								var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr>"+
								"<tr><td><button type='button' id='myBtn'  onClick='viewFrom(\"" + data[0].towerNo + "\",\"" + data[0].tapping + "\",\"" + data[0].id + "\",\"" + data[0].mapId + "\",\"" + str + "\",\"" + data[3].id + "\")'>From</button></td><td><button type='button' id='myBtn'  onClick='viewTo(\"" + data[0].towerNo + "\",\"" + data[0].tapping + "\",\"" + data[0].id + "\",\"" + data[0].mapId + "\",\"" + str + "\",\"" + data[3].id + "\")'>To</button></td></tr> "+
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
								"</table></div>";

	
        						google.maps.event.addListener(marker, "click", function(e) {

        							infoWindow.setContent(insDetailTable);
        							infoWindow.open(map, marker);
        						});


        					})(marker, data);

        				}
                		map.fitBounds(bounds);

                		//var polyline = new GPolyline([
    					                       //       new GLatLng(7.3171376, 80.5608933),
    					                           //   new GLatLng(7.3205831, 80.5581145)],
    					                           //   "#ff0000", 50);
    					                         //   map.addOverlay(polyline);

        				
                }
                
         });
	}

	
	function loadMapWithoutMnt() {
		//alert('hiii');
		var map = new google.maps.Map(document.getElementById("map_container"), {
          //center: new google.maps.LatLng(7.2665013,80.541458),
          center: new google.maps.LatLng(7.873054,80.771797),
          zoom: 12,
          gestureHandling: 'greedy',
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });
		
		
		/* DrawingManager drawingManager = new google.maps.drawing.DrawingManager({
	         drawingMode: google.maps.drawing.OverlayType.MARKER,
	         drawingControl: true,
	         drawingControlOptions: {
	           position: google.maps.ControlPosition.TOP_CENTER,
	           drawingModes: ['marker', 'circle', 'polygon', 'polyline', 'rectangle']
	         },
	         markerOptions: {icon: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png'},
	         circleOptions: {
	           fillColor: '#ffff00',
	           fillOpacity: 1,
	           strokeWeight: 5,
	           clickable: false,
	           editable: true,
	           zIndex: 1
	         }
	       });
	       drawingManager.setMap(map);
	       
	        google.maps.event.addListener(drawingManager, 'overlaycomplete', function(e) {
	    	    all_overlays.push(e);
	    	    if (e.type != google.maps.drawing.OverlayType.MARKER) {
	    	    // Switch back to non-drawing mode after drawing a shape.
	    	    drawingManager.setDrawingMode(null);
	    	    // Add an event listener that selects the newly-drawn shape when the user
	    	    // mouses down on it.
	    	    var newShape = e.overlay;
	    	    newShape.type = e.type;
	    	    google.maps.event.addListener(newShape, 'click', function() {
	    	      setSelection(newShape);
	    	    });
	    	    setSelection(newShape);
	    	  }
	    	});
	 
		*/
		

		var infoWindow = new google.maps.InfoWindow();
		var strArea = area.options[area.selectedIndex].value;
		var strLine = line.options[line.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
		
		//variables for get the move location
		
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + bounds );
		$.ajax
        ({
        	type: 'GET',
            url: "/MMS/MapNewWOMNT/" + strArea +"/" + strLine + "/" +strProvince,
             data: {},
            contentType: "application/json; charset=utf-8",
            success : function(json){
            	//alert(json.length);
            	
            		for (var i = 0, length = json.length; i < length; i++) {
    					var data = json[i],
    						latLng = new google.maps.LatLng(data[0].gpsLatitude, data[0].gpsLongitude);
    						//alert('huuuuuuu');
        						bounds.extend(latLng);
        						//alert('huuuuuuu4');
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
        						  
        						  
        						  
        						  
        						  if(data[0].tapping == 0){
        						  
								  if(data[0].supportType == 1){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    	            						icon: '<c:url value="/resources/img/CEBImages/towermarkere.png"/>',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id
    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
    	            					});
										 
									  }
								  else if(data[0].supportType == 2){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
    	            						icon: '<c:url value="/resources/img/CEBImages/polemarkere.png"/>',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id
    	            						//label: { color: '#5DADE2', fontWeight: 'bold', fontSize: '12px', text: 'P' }
    	            					});
									  }
								  else if(data[0].supportType == 3){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_yellow.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GB' }
    	            					});
								  }else if(data[0].supportType == 4){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GSSB' }
    	            					});
								  }else if(data[0].supportType == 5){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_green.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'LG' }
    	            					});
								  }else if(data[0].supportType == 6){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_blue.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'LP' }
    	            					});
								  }else if(data[0].supportType == 7){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'SW' }
    	            					});
								  }else{
										//alert("test13 : "+ data.area);
	            					var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	            						title: "Click here to view details of Tower ID "+data[0].id,
	            						label: { color: '#FAF8F8', fontWeight: 'bold', fontSize: '14px', text: '' }
	            					});
								  }
        						  }else{
        							  var marker = new google.maps.Marker({
  	            						position: latLng,
  	            						map: map,
  	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
  	            						//marker.setIcon(zoomIcons[map.getZoom()]);
  	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
  	            						title: "Click here to view details of Tower ID "+data[0].id,
  	            						label: { color: '#FAF8F8', fontWeight: 'bold', fontSize: '14px', text: 'T' }
  	            					});
        						  }
								  
								  
								  
								   
								  
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
							
        					//data.gpsLatitude, data.gpsLongitude
        					
        					// var flightPlanCoordinates = [
        					                       //       {lat: json[i].gpsLatitude, lng: json[i].gpsLongitude},
        					                       //       {lat: json[i+1].gpsLatitude, lng: json[i+1].gpsLongitude}
        					                              
        					                         //   ];
        					                          //  var flightPath = new google.maps.Polyline({
        					                             // path: flightPlanCoordinates,
        					                             // geodesic: true,
        					                              //strokeColor: '#FF0000',
        					                              //strokeOpacity: 1.0,
        					                             // strokeWeight: 2
        					                           // });

        					                           // flightPath.setMap(map);
        					
							
        				//var flightPlanCoordinates = [{lat: data.gpsLatitude , lng: data.gpsLongitude}];
        				//var point =latLng;
        				//flightPlanCoordinates.push(point); 
        				//var flightPath = new google.maps.Polyline({
        			   // path: flightPlanCoordinates,
        				        //  geodesic: true,
        				        //  strokeColor: '#FF0000',
        				         // strokeOpacity: 1.0,
        				         // strokeWeight: 2
        				       // });

        				      // flightPath.setMap(map);

        					// Creating a closure to retain the correct data, notice how I pass the current data in the loop into the closure (marker, data)
        					
        					
        					var firstObj = json[i];
	        				var secondObj = json[i+1]; 
	        				
        					
        					(function(marker, data) {

        						
	        					
							/*  if(firstObj[0].lineId == secondObj[0].lineId){
								//var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
        						var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
        						var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
   							 	var distance = calcDistance(p1, p2);
   							    totalLength = distance + distance;
   							 	alert("hiiii2" + totalLength );
   							 	//var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
   							 	//alert("hiiii2 : " + calcDistance(p1, p2));
   							 	/* function calcDistance(p1, p2){
   								  alert("hiiii5");
   								  return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
   							 	} 

		   							
   							 }  */

							/* function calcDistance(p1, p2){
   								if(firstObj[0].lineId == secondObj[0].lineId){
        							var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
        							var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
        						}
 								  //alert("hiiii5");
 								  return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
 							} */
//alert(i);
        						function calcDistance(){
        							//alert("hiiii2 : " + i + secondObj[0]);
            						//if(!secondObj[0]){
            						
            						if(secondObj){
       								if(firstObj[0].lineId == secondObj[0].lineId){
            							var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
            							var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
            							// return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
            							return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2)).toFixed(2);
                 						  
                						}
       								else{
           								return '0';
           								}
            						}else{
           								return '0';
       								}
     								  //alert("hiiii5");
     								  // }
     							}

            					
        						//alert("hiiii3 : " + i + calcDistance());	
								
//alert('' + data[0].supportType);
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
								       						       
								//var contentString = "<div style='float:left'><img src='<c:url value="/resources/img/CEBImages/Tower1.png"/>'></div>";
								//var genInformation ="<div style='float:right; padding: 10px;'><b></b><br/><b>Tower Number:  </b>"+
								//data[0].towerNo+"</br>"+"<b>Area : </b>"+
								//data[0].area+"</br>"+"<b>Support type : </b>"+
    							//supType+"</br>"+"<b>Latitude : </b>"+
    							//data[0].gpsLatitude+"</br>"+"<b>Longitude :</b>"+
    							//data[0].gpsLongitude+"</br></div>";

    							//var techDetail ="<div style='float:right; padding: 10px;'><b>Technical Detail </b><br/><br/><b>Conductor Type:  </b>"+
								//data[2]+"</br>"+"<b>Tappings : </b>"+
								//data[1].nooftappings+"</br>"+"<b>Tower type : </b>"+
								//data[3]+"</br></div>";

								//var insDetail ="<div style='float:right; padding: 10px;'><b>Inspection Detail </b><br/><br/><b>Conductor Type:  </b>"+
								//data[2]+"</br>"+"<b>Tappings : </b>"+
								//data[1].nooftappings+"</br>"+"<b>Tower type : </b>"+
								//data[3]+"</br></div>";
								
								var lineid =data[0].towerNo;
						/* 		var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
								data[0].towerNo+"</td></tr><tr><td>Distance to next tower (m) :</td><td>"+
								calcDistance()+"</td></tr><tr><td>Area : </td><td>"+
								
								data[0].area+"</td></tr><tr><td>Support type :  </td><td>"+
								supType+"</td></tr><tr><td>Tower Conf :  </td><td>"+
								data[5]+"</td></tr><tr><td>Latitude :  </td><td>"+
								data[0].gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data[0].gpsLongitude+"</td></tr><tr> </tr><tr><th>Technical Detail</th></tr>"+
								"<tr><td>Conductor Type :  </td><td>"+data[2]+"</td></tr>"+
								"<tr><td>Tappings :  </td><td>"+data[1].nooftappings+"</td></tr>"+
								"<tr><td>Tower type :  </td><td>"+data[3]+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Inspection Detail</th></tr>"+
								"<tr><td>Latest Inspection Date :  </td><td></td></tr>"+
								"<tr><td>Wayleaves :  </td><td>"+data[1].wayleavestatus+"</td></tr>"+
								"<tr><td>Base Concrete :  </td><td>"+data[1].baseconcretestatus+"</td></tr>"+
								"<tr><td>Conductor Status : </td><td>"+data[1].conductorstatus+"</td></tr>"+
								"<tr><td>Jumper Status :  </td><td>"+data[1].jumperstatus+"</td></tr>"+
								"<tr><td>Missing Parts :  </td><td>"+data[1].noofmissingparts+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td>Last Maintenance Date :  </td><td></td></tr>"+
								"<tr><td>Hot line maintenance details (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"<tr><td>Cold line maintence details  (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"</table></div>"; */
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
								"<tr><td>Map ID :  </td><td>"+data[0].mapId+"</td></tr>"+
								
								 "<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
									/* "<tr><td>Last Maintenance Date :  </td><td></td></tr>"+
									 */"<tr><td><button type='button' id='myBtn' data-toggle=modal data-target=#myModal onClick='view(\"" + data[0].id + "\")'>View</button></td></tr> "+
									/* "<tr><td>Hot line maintenance details (ES validated maintenance work summary) :  </td><td></td></tr>"+
									"<tr><td>Cold line maintence details  (ES validated maintenance work summary) :  </td><td></td></tr>"+
									 */"</table></div>";


								/* function showMore(id) {
					                  alert('my id is ' + id);
					            }
								 function showShops() {
								 var  content=document.createElement('div'),
					              button;
					              content.innerHTML='some text<br/>';
					              button=content.appendChild(document.createElement('input'));
					              button.type='button';
					              button.value='click me!'
					              google.maps.event.addDomListener(button,'click', function(){
					                                                                 showMore('1');})
								
								 }
	 */
        						google.maps.event.addListener(marker, "click", function(e) {
        							 

        							//infoWindow.setContent("<b>Tower Number:  </b>"+
        								//	data[0].towerNo+"</br>"+"<b>Area : </b>"+
        								//	data[0].area+"</br>"+"<b>Support type : </b>"+
	            						//	supType+"</br>"+"<b>Latitude : </b>"+
	            						//	data[0].gpsLatitude+"</br>"+"<b>Longitude :</b>"+
	            						//	data[0].gpsLongitude+"</br>"+"<b>Conductor Type :</b>"+
	            						//	conType+"</br>"+"<b>Tappings : </b>"+
	            							//data[1].nooftappings+"</br>"+"<b>Tower Type : </b>"+
	            							//data[0].towerType+"</br>"+"<b>Latest Inspection Data : </b>"+
	            							//data[0].towerType+"</br>"+"<b>WayLeaves: </b>"+
	            							//data[1].wayleavestatus+"</br>"+"<b>Base Concrete : </b>"+
	            							//data[1].baseconcretestatus+"</br>"+"<b>Conductor Status : </b>"+
	            							//data[1].conductorstatus+"</br>"+"<b>Jumper Status : </b>"+
	            							//data[1].jumperstatus+"</br>"+"<b>Missing Parts : </b>"+
	            							//data[1].noofmissingparts+
	            							
	            							
	            							//"</br>"+"" +contentString + insDetailTable );
	            							
	            							infoWindow.setContent(insDetailTable+url);
        									infoWindow.open(map, marker);
        						});


        					})(marker, data);

        				}

                		map.fitBounds(bounds);

                		
                		//var polyline = new GPolyline([
    					                       //       new GLatLng(7.3171376, 80.5608933),
    					                           //   new GLatLng(7.3205831, 80.5581145)],
    					                           //   "#ff0000", 50);
    					                         //   map.addOverlay(polyline);

        				
                }
                
                
         });
		
	}
	
	
		
	
	function validateForm()
	{
		var empt = document.getElementById("from").value;
		var emptTo = document.getElementById("to").value;
		var dateofwork = document.getElementById("dateofwork").value;
		var timeDuration = document.getElementById("timeDuration").value;
		var timeDuration2 = document.getElementById("timeDuration2").value;
		var txtLocation = document.getElementById("txtLocation").value;
		var txtFOW = document.getElementById("txtFOW").value;
		var userIdEE = document.getElementById("userIdEE").value;
		var userIdEE = document.getElementById("userIdEE").value;
		var strArea = area.options[area.selectedIndex].value;
		var strLine = line.options[line.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
		
		
		if (empt === "")
			{
			alert("From may not be empty");
			event.preventDefault();
			return false;
		}else if (emptTo === ""){
			alert("To may not be empty");
			event.preventDefault();
			return false;
		}else if (dateofwork === ""){
			alert("Date of Work may not be empty");
			event.preventDefault();
			return false;
		}/* else if (timeDuration === ""){
			alert("Time Duration  may not be empty");
			event.preventDefault();
			return false;
		}else if (timeDuration2 === ""){
			alert("Time Duration may not be empty");
			event.preventDefault();
			return false;
		} */else if (txtLocation === ""){
			alert("Location may not be empty");
			event.preventDefault();
			return false;
		}else if (txtFOW === ""){
			alert("Field Work may not be empty");
			event.preventDefault();
			return false;
		}else if (strArea === "NONE"){
			alert("Area may not be empty");
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
	
	function disableLineName(){
		
		document.getElementById("lineName").disabled = true;
		//document.getElementById("from").disabled = true;
		//document.getElementById("to").disabled = true;
		
		
	}
	
	function enableLineName(){
		var viewMode = mode.options[mode.selectedIndex].value;
		//var strLine = line.options[line.selectedIndex].value;
		
		//alert(viewMode);
    	
		if(viewMode=='OTHER'){
			document.getElementById("lineName").disabled = false;
			//document.getElementById("from").disabled = false;
			//document.getElementById("to").disabled = false;
			
			document.getElementById("line").disabled = true;
			line.options[line.selectedIndex].value = '-2';
			document.getElementById("txtFOW").value='All tappings in the interrupted section need to be isolated & earthed from the network'; 
			document.getElementById("otherInterruption").value='OTHER';
			
		}else{
			document.getElementById("lineName").disabled = true;
			document.getElementById("line").disabled = false;
			document.getElementById("otherInterruption").value='NOTOTHER';
			//document.getElementById("from").disabled = true;
			//document.getElementById("to").disabled = true;
			
		}
		
	}


	
	
</script>
</head>

<body onload="myMap(new google.maps.LatLng(7.475214, 80.744077), 7);disableLineName();">
	<div id="theme-wrapper">

		<%@ include file="sections/header.jsp"%>

		<div id="page-wrapper" class="container">
			<div class="row">

				<%@ include file="sections/userLevels.jsp"%>

				<div id="content-wrapper">


					<div class="row">
						<div class="col-lg-12">

							<div class="col-lg-9">
								<ol class="breadcrumb">
									<li><a href="#">Home</a></li>
									<c:if test="${type == 'INS'}">
										<li class="active"><span>INSPECTION REQUEST</span></li>
									</c:if>
									<c:if test="${type == 'MNT'}">
										<li class="active"><span>MAINTENANCE REQUEST</span></li>
									</c:if>
									<c:if test="${type == 'INTERRUPTION'}">
										<li class="active"><span>INTERRUPTION REQUEST</span></li>
									</c:if>
									<c:if test="${type == 'INTERRUPTIONAE'}">
										<li class="active"><span>RESCHEDULE INTERRUPTION REQUEST</span></li>
									</c:if>
									
								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>
					<div>
    <!-- <button id="delete-button"  onclick="deleteSelectedShape()">Delete Selected Shape</button>
    <button id="delete-all-button"   onclick="deleteAllShape()">Delete All Shapes</button>
 -->  </div>
										

					<div class="row">
					
					<!-- <div class="col-sm-12" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
									
					</div>
 -->					
						<div class="col-lg-12">
							<div class="main-box clearfix">
								<div class="main-box-body clearfix">
									<!-- <div class="table-responsive">
									 -->	<table class="table table-responsive" id="tblProvinces">
											<tbody>
												<form:form method="post" enctype="multipart/form-data" action="goToInterruptionRequestS" modelAttribute="model" id="formGenerate">
													<c:set var="myVar" value="${model.mode}" />
													<form:hidden path="sauserm.userId" />
													<form:hidden path="mapId"  id = "mapId" />
													<form:hidden path="totowerid"  id = "totowerid" />
													<form:hidden path="fromtowerid"  id = "fromtowerid" />
													<form:hidden path="totowermapid"  id = "totowermapid" />
													<form:hidden path="fromtowermapid"  id = "fromtowermapid" />
													<form:hidden path="otherInterruption"  id = "otherInterruption" />
													
													<c:if test="${not empty model.message}">
														<tr>
														<td colspan="2" class="msgSuccess" align="center">
														
														<div class="msgSuccess">
															<c:out value="${model.message}"></c:out>
														</div>
														</tr>
													</c:if>
													<tr><div id="map_container"></div>
													</tr>
															<tr>
															<td style="text-align: left">View</td>
															<td style="text-align: left"><form:select id="mode" path="" onchange="enableLineName()" class="form-control">
																<form:option value="NETWORK" label="NETWORK VIEW" />
																<form:option value="OTHER" label="OTHER" />

															</form:select>
															</td>
															</tr>
														
															<tr>
															<td width="20%" style="text-align: left">Province</td>
																<td width="80%" style="text-align: left"><form:select id="province" path="glcompmobj.compId"
																	onchange="findArea()" class="form-control">
																	<form:option value="NONE" label="PROVINCE" />
																	
																	<form:options items="${model.provinceList}" />
																</form:select></td>
															
															</tr>
															<tr>
															<td width="20%" style="text-align: left">
																Area
															</td>
															<td width="80%" style="text-align: left">
																
																	<form:select id="area" path="gldeptobj.deptId" onchange="getLine()" class="form-control">
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
 															<c:if test="${type == 'INTERRUPTION'}">
										                    <tr>
															<td width="20%" style="text-align: left">Line</td>
															<td width="80%" style="text-align: left"><form:select
																	id="line" path="line.id" onchange="viewMapByMode()" class="form-control">
																	<form:option value="-1" label="LINE" />
																	<form:options items="${model.lineList}" />
																</form:select></td>
															</tr>
															</c:if>
															<c:if test="${type == 'INTERRUPTIONAE'}">
 															<tr>
															<td width="20%" style="text-align: left">Line</td>
															<td width="80%" style="text-align: left"><form:select
																	id="line" path="line.id" onchange="viewMapByModeAE();enableLineName();" class="form-control">
																	<form:option value="-1" label="LINE" />
																	<form:options items="${model.lineList}" />
																</form:select></td>
															</tr>
															<tr>
														
															<td width="20%" style="text-align: left">Interruption Request No</td>
															<td width="80%" style="text-align: left"><form:select
																	id="insRequest" path="intRequestObj.approvalId" onchange="" class="form-control">
																	<form:option value="NONE" label="Interruption Request No" />
																	<form:options items="${model.intRequest}" />
																</form:select></td>
															</tr>
														 	</c:if>
														 	<tr>
															<td width="20%" style="text-align:left">Line Name
                											</td>
                											<td width="80%" style="text-align:left">
	                											<label>
																	<form:input path="lineNameNew" type="text" id="lineName" placeholder="Enter Line Name" class="form-control"></form:input>
																		<c:if test="${not empty model.error6}">
																			<div>
																				<span id="spnDOW" class="label label-danger">${model.error6}</span>
																			</div>
																		</c:if>
																</label>
															</td>
															</tr>
														 
																
															<tr>
															<td width="20%" style="text-align:left">From
                											</td>
                											<td width="80%" style="text-align:left">
	                											<label>
																	<form:input path="from" type="text" id="from" placeholder="From" class="form-control"/>
																		<c:if test="${not empty model.error6}">
																			<div>
																				<span id="spnDOW" class="label label-danger">${model.error6}</span>
																			</div>
																		</c:if>
																</label>
															</td>
															</tr>
														
														<tr>
															<td width="20%" style="text-align:left">
                												To
                											</td>
                											<td width="80%" style="text-align:left">
	                											<label>
																	<form:input path="to" type="text" id="to" placeholder="To" class="form-control"/>
																		<c:if test="${not empty model.error7}">
																			<div>
																				<span id="spnDOW" class="label label-danger">${model.error7}</span>
																			</div>
																		</c:if>
																</label>
															</td>
															</tr>
														
														 <tr>
															<td width="20%" style="text-align:left">
                												Date of work
                											</td>
                											<td width="80%" style="text-align:left">
	                											<label>
																	<form:input path="dateOfWork" type="date" id="dateofwork" class="form-control"/>
																		<c:if test="${not empty model.error3}">
																			<div>
																				<span id="spnDOW" class="label label-danger">${model.error3}</span>
																			</div>
																		</c:if>
																</label>
															</td>
															</tr>
															<tr>
															<td width="20%" style="text-align:left">
                												Time Duration - From
                											</td>
                											<td width="80%" style="text-align:left">
                												<label>
																	<form:input path="timeDuration" type="time" id="timeDuration" value = "08:30" placeholder="Time Duration of Work" class="form-control"/>
																		<c:if test="${not empty model.error4}">
																			<div>
																				<span id="spnTD" class="label label-danger">${model.error4}</span>
																			</div>
																		</c:if>
																</label>
															</td>
															</tr>
															<tr>
															<td width="20%" style="text-align:left">
                												Time Duration - To 
                											</td>
                											
															<td width="80%" style="text-align:left">
                												<label>
																	<form:input path="timeDuration2" type="time" id="timeDuration2" value = "17:00" placeholder="Time Duration of Work" class="form-control"/>
																		<c:if test="${not empty model.error8}">
																			<div>
																				<span id="spnTD" class="label label-danger">${model.error8}</span>
																			</div>
																		</c:if>
																</label>
															</td>
														</tr>
        														
										
															<tr>
																 <td width="20%" style="text-align: left">
																 	Field Work
																 </td>
																 <td width="80%" style="text-align:left">
																	<label>
																		<form:textarea id="txtFOW" path="mailContent2" rows="5" cols="60" placeholder="Enter Field Work" class="form-control"/>
																			<c:if test="${not empty model.error2}">
																					<div>
																						<span id="spnFOW" class="label label-danger">${model.error2}</span>
																					</div>
																			</c:if>
																	</label>	
																</td>								
															</tr>
																 
																 
																 <tr>
															<td width="20%" style="text-align: left">Requested EE</td>
															<td width="80%" style="text-align: left"><form:select
																	id="userIdEE" path="sausermEE.userId" onchange=""  class="form-control">
																	
																	<form:options items="${model.eeList}" />
																</form:select></td>

														</tr>
																																<tr>
																<td width="20%" style="text-align:left">
                												File to upload:
                												</td>
                												<td width="50%" style="text-align:left">
																<input  type="file" name="file" id="file" onchange="show()" class="form-control">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove(); return false;">
																	</span>
																</td>
																
																    
        														</tr>
        														<tr>
																<td width="20%" style="text-align:left">
                												File to upload:
                												</td>
                												<td width="50%" style="text-align:left">
																<input  type="file" name="file1" id="file1" onchange="show1()" class="form-control">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn1" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove1(); return false;">
																	</span>
																</td>
																    
        														</tr>
        														
        														<tr>
																<td width="20%" style="text-align:left">
                												File to upload:
                												</td>
                												<td width="50%" style="text-align:left">
																<input  type="file" name="file2" id="file2" onchange="show2()" class="form-control">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn2" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove2(); return false;">
																	</span>
																</td>
																    
        														</tr>
        														
        														<tr>
																<td width="20%" style="text-align:left">
                												File to upload:
                												</td>
                												<td width="50%" style="text-align:left">
																<input  type="file" name="file3" id="file3"  onchange="show3()" class="form-control">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn3" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove3(); return false;">
																	</span>
																</td>
																    
        														</tr>
        														
        														<tr>
																<td width="20%" style="text-align:left">
                												File to upload:
                												</td>
                												<td width="50%" style="text-align:left">
																<input  type="file" name="file4" id="file4" onchange="show4()" class="form-control">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn4" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove4(); return false;">
																	</span>
																</td>
																    
        														</tr>
        														<tr>
															<td style="text-align: left"><a
																href="../MMS/GenerateReportTM?area=431&line=49"> <input
																	class="btn btn-success" type="submit"
																	name="actionButton" value="Generate" onclick="validateForm()"></input></a></td>
														</tr>
        														
															
														
													</form:form>
													</tbody>
												</table>
											
									<!-- </div> -->
								</div>
							</div>
						</div>
					</div>
					<%@ include file="sections/footer.jsp"%>

				</div>
			</div>
		</div>
	</div>

	<%@ include file="sections/global_scripts.jsp"%>


</body>

</html>
