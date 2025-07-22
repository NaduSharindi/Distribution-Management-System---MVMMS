<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<%@ include file="sections/head.jsp"%>
<%@ include file="sections/dashboardCSS.jsp"%>

<!-- meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"-->
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<!-- bootstrap -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap/bootstrap.min.css"/>" />

<!-- RTL support - for demo only -->
<script src="<c:url value="/resources/js/demo-rtl.js"/>">
	
</script>
<!-- 
	If you need RTL support just include here RTL CSS file <link rel="stylesheet" type="text/css" href="css/libs/bootstrap-rtl.min.css" />
	And add "rtl" class to <body> element - e.g. <body class="rtl"> 
	-->

<!-- libraries -->
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

<!-- Favicon -->
<link type="image/x-icon" href="favicon.png" rel="shortcut icon" />

<!-- google font libraries -->
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700,300|Titillium+Web:200,300,400'
	rel='stylesheet' type='text/css'>

<style type="text/css">



div#map_container {
	width: 100%;
	height: 500px;
	border-radius: 5px;
}

div#map_container2 {
	width: 100%;
	height: 500px;
	border-radius: 5px;
}


.modal-title {
	margin: 0;
	line-height: 1.428571429;
	text-align: center;
}


.dropbtn1 {
	background-color: #eee;
	color: black;
	padding: 16px;
	font-size: 16px;
	border: none;
	width: 100%;
	height: 40px;
}

.dropbtn {
	background-color: #eee;
	color: black;
	padding: 16px;
	font-size: 16px;
	border: none;
	width: 100%;
	height: 50px;
	
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
	width: 100%;
	text-align: left;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #66CDAA;
}

#theme-wrapper {
  box-shadow: 0 0 53px 0 rgba(0, 0, 0, 0.55);
  width: 100%;
}

#page-wrapper {
  background-color: #2c3e50;
}

.container {
  margin: 0;
  width: 100%;
}


.infographic-box .headline {
  display: block;
  font-size: 0.8em;
  font-weight: 300;
  text-align: right;
}



</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
//Load the Visualization API and the piechart package.
   google.charts.load('current', {'packages':['corechart', 'controls']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawDashboard);

      // Callback that creates and populates a data table,
      // instantiates a dashboard, a range slider and a pie chart,
      // passes in the data and draws it.
      function drawDashboard() {
    	  
    	  
    	  $.ajax({
  			type : 'GET',
  			url : "/MMS/getSummaryGantry",
  			data : {},
  			contentType : "application/json; charset=utf-8",
  			success : function(result) {
  				var datavalue = new google.visualization.DataTable();
  				datavalue.addColumn('string', 'Name');
  				datavalue.addColumn('number', 'Gantry');
  				
  				for (var i = 0; i < result.length; i++) {
  						var data = result[i];
  						datavalue.addRows([[data[1], data[0]]]);
  				}
  				 
  			     // Create a dashboard.
  		        var dashboard = new google.visualization.Dashboard(
  		            document.getElementById('dashboard_div'));

  		        // Create a range slider, passing some options
  		        var donutRangeSlider = new google.visualization.ControlWrapper({
  		          'controlType': 'NumberRangeFilter',
  		          'containerId': 'filter_div',
  		          'options': {
  		        	'filterColumnLabel': 'Gantry'
  		          }
  		        });

  		        // Create a pie chart, passing some options
  		        var pieChart = new google.visualization.ChartWrapper({
  		          'chartType': 'PieChart',
  		          'containerId': 'chart_div',
  		          'options': {
  		            'width': 230,
  		            'height': 210,
  		            'pieSliceText': 'value',
  		            'legend': 'right'
  		          }
  		        });

  		        // Establish dependencies, declaring that 'filter' drives 'pieChart',
  		        // so that the pie chart will only display entries that are let through
  		        // given the chosen slider range.
  		        dashboard.bind(donutRangeSlider, pieChart);

  		        // Draw the dashboard.
  		        dashboard.draw(datavalue);
  		        
  		        
  		        
  		      var optionspie = {
			             title: 'Substation Summary',
			             is3D : true,
			             pieSliceText: 'label',
			             tooltip :  {showColorCode: true},
					     'height' : 400
			         };
			
				 
				 var chart = new google.visualization.PieChart(document.getElementById('pie_div1'));
			    chart.draw(datavalue, optionspie);
			

  			    
  			    
  			}
  		});
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  var strArea = area.options[area.selectedIndex].value;
    		var strLine = 'NONE';
    		var strProvince = province.options[province.selectedIndex].value;
    		var strDiv='NONEA';
    		
    		$.ajax({
    				type : 'GET',
    				url : "/MMS/MapNewSummaryOther/" + strArea +"/" + strLine + "/" +strProvince +"/" +strDiv,
    				data : {},
    				contentType : "application/json; charset=utf-8",
    				success : function(result) {
    					
    					var datavaluefortable = new google.visualization.DataTable();
    				datavaluefortable.addColumn('string', 'Name');
    				
    				datavaluefortable.addColumn('number', 'Tower');
    				datavaluefortable.addColumn('number', 'Pole');
    				datavaluefortable.addColumn('number', 'Gantry Bay');
    				datavaluefortable.addColumn('number', 'GSS Bay');
    				datavaluefortable.addColumn('number', 'Line Gantry');
    				datavaluefortable.addColumn('number', 'Lattice Pole');
    				datavaluefortable.addColumn('number', 'Switch');
    				
    				
    				for (var i = 0; i < result.length; i++) {
    						var data = result[i];
    						//alert(data[3]);
    						datavaluefortable.addRows([[data[3],data[4], data[5], data[6], data[7], data[8], data[9], data[10]]]);
    						
    				}
    							 
    				     var options = {
    				             title: 'Number of Equipment in Tower Line',
    				             is3D : true,
    				             pieSliceText: 'label',
    				             tooltip :  {showColorCode: true},
    						     'height' : 400
    				         };
    				     
    				     		     
    				    var chart = new google.visualization.ColumnChart(document.getElementById('bar_div1'));
    				    chart.draw(datavaluefortable, options);
    				    
    				  
    				    
    				}
    			});
    		
    	  
    	  
    	  /* $.ajax({
    			type : 'GET',
    			url : "/MMS/getApprovalListNew",
    			data : {},
    			contentType : "application/json; charset=utf-8",
    			success : function(result) {
    				var datavaluepie = new google.visualization.DataTable();
    				datavaluepie.addColumn('string', 'Unit Name');
    				datavaluepie.addColumn('number', 'No. Estimate');
    				datavaluepie.addColumn('string', 'Dept Id');
    				
    				for (var i = 0; i < result.length; i++) {
    						var data = result[i];
    						datavaluepie.addRows([[data[1], data[0],data[2]]]);
    				}
    				
    				 
    			     // Create a dashboard.
    		        var dashboard = new google.visualization.Dashboard(
    		            document.getElementById('dashboard_div'));

    		        // Create a range slider, passing some options
    		        var donutRangeSlider2 = new google.visualization.ControlWrapper({
    		          'controlType': 'CategoryFilter',
    		          'containerId': 'filter_div2',
    		          'options': {
    		        	'filterColumnLabel': 'Unit Name'
    		          }
    		        });

    		        // Create a pie chart, passing some options
    		        var pieChart = new google.visualization.ChartWrapper({
    		          'chartType': 'PieChart',
    		          'containerId': 'estapr_div',
    		          'options': {
    		            'width': 230,
    		            'height': 210,
    		            'is3D': true,
    		            'pieSliceText': 'value',
    		            'legend': 'right'
    		          }
    		        });
    		        
    		        dashboard.bind(donutRangeSlider2, pieChart);
    		        dashboard.draw(datavaluepie);
  		        	}
    		});
 */
    	  
    	  
    	 /* $.ajax({
  			type : 'GET',
  			url : "/MMS/getApprovalListNew",
  			data : {},
  			contentType : "application/json; charset=utf-8",
  			success : function(result) {
  				var datavaluetable = new google.visualization.DataTable();
  				datavaluetable.addColumn('number', 'No. Estimate');
  				datavaluetable.addColumn('string', 'Unit Name');
  				datavaluetable.addColumn('string', 'Dept Id');
  				
  				for (var i = 0; i < result.length; i++) {
  						var data = result[i];
  						datavaluetable.addRows([[data[0], data[1],data[2]]]);
  				}
  				
  				// Create a dashboard.
  		        var dashboard = new google.visualization.Dashboard(
  		            document.getElementById('dashboard_div'));

  		        // Create a range slider, passing some options
  		        var donutRangeSlider2 = new google.visualization.ControlWrapper({
  		          'controlType': 'CategoryFilter',
  		          'containerId': 'filter_div2',
  		          'options': {
  		        	'filterColumnLabel': 'Unit Name'
  		          }
  		        });

  		        
  		        var table = new google.visualization.ChartWrapper({
  			          'chartType': 'Table',
  			          'containerId': 'estaprtable_div',
  			          'options': {
  			            'width': 230,
  			            'height': 210,
  			            'pieSliceText': 'value',
  			            'legend': 'right'
  			          }
  			        });
  		        
  		        dashboard.bind(donutRangeSlider2, table);
  		        dashboard.draw(datavaluetable);
  		        
  		        // Draw the dashboard.
  		         
  		        google.visualization.events.addListener(table, 'select', selectHandler);
  		        function selectHandler() {
  		          //alert("hiii");
  		          var selectedItem = table.getChart().getSelection()[0];
  		          
  		          if (selectedItem) {
  		        	 // alert("hiii2");
  		            var value = datavaluetable.getValue(selectedItem.row, 2);
  		           // alert('The user selected ' + value);
  		            
  		            $.ajax({
  		    			type : 'GET',
  		    			url : "/MMS/getApprovalListByCostCenter/" +value+"/" ,
  		    			data : {},
  		    			contentType : "application/json; charset=utf-8",
  		    			success : function(result) {
  		    				var datavalue = new google.visualization.DataTable();
  		    				datavalue.addColumn('string', 'Estimate No');
  		    				datavalue.addColumn('string', 'Description');
  		    				datavalue.addColumn('string', 'Dept Id');
  		    				
  		    				for (var i = 0; i < result.length; i++) {
  		    						var data = result[i];
  		    						datavalue.addRows([[data[0], data[1],data[2]]]);
  		    				}
  		    				 
  		    			     // Create a dashboard.
  		    		        var dashboard = new google.visualization.Dashboard(
  		    		            document.getElementById('dashboard_div'));

  		    		        // Create a range slider, passing some options
  		    		        var donutRangeSlider3 = new google.visualization.ControlWrapper({
  		    		          'controlType': 'CategoryFilter',
  		    		          'containerId': 'filter_div3',
  		    		          'options': {
  		    		        	'filterColumnLabel': 'Description'
  		    		          }
  		    		        });

  		    		        
  		    		        var table = new google.visualization.ChartWrapper({
  		    			          'chartType': 'Table',
  		    			          'containerId': 'estaprtabledetail_div',
  		    			          'options': {
  		    			            'width': 230,
  		    			            'height': 210,
  		    			            'pieSliceText': 'value',
  		    			            'legend': 'right'
  		    			          }
  		    			        });


  		    		        // Establish dependencies, declaring that 'filter' drives 'pieChart',
  		    		        // so that the pie chart will only display entries that are let through
  		    		        // given the chosen slider range.
  		    		        dashboard.bind(donutRangeSlider3, table);

  		    		        // Draw the dashboard.
  		    		        dashboard.draw(datavalue);
  		    		        
  		    		        // The select handler. Call the chart's getSelection() method
  		    		        function selectHandler() {
  		    		        	//alert("hiii");
  		    		          var selectedItem = table.getChart().getSelection()[0];
  		    		          
  		    		          if (selectedItem) {
  		    		        	//  alert("hiii2");
  		    		            var estimateNo = datavalue.getValue(selectedItem.row, 0);
  		    		            var costCenterNo = datavalue.getValue(selectedItem.row, 2);
  		    		            
  		    		            //alert('This will open the pdf file later ' + estimateNo + " : " + costCenterNo);
  		    		           // alert('costCenterNo ' + costCenterNo);
  		    		            
  		    		             
  		    		            var url="downloadEstimate?estimateNo="+estimateNo+"&costCenter="+costCenterNo;
  		    		    	    var width = 1100;
  		    		    	    var height = 700;
  		    		    	    var left = parseInt((screen.availWidth/2) - (width/2));
  		    		    	    var top = parseInt((screen.availHeight/2) - (height/2));
  		    		    	    var windowFeatures = "width=" + width + ",height=" + height + 
  		    		    	    ",status,resizable,left=" + left + ",top=" + top +
  		    		    	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
  		    		    	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
  		    		    	    //myWindow.document.write("<p>This is 'MsgWindow'. I am 200px wide and 100px tall!</p>");

  		    		          }
  		    		        }
  		    		        google.visualization.events.addListener(table, 'select', selectHandler);


  		    		        
  		    			}
  		    		});

  		            
  		            
  		            
  		            
  		          }
  		         }


  			    
  			    
  			}
  		});
 */
    	  
    	  
    	  
    	/*   $.ajax({
    			type : 'GET',
    			url : "/MMS/getApprovalList",
    			data : {},
    			contentType : "application/json; charset=utf-8",
    			success : function(result) {
    				var datavalue = new google.visualization.DataTable();
    				datavalue.addColumn('string', 'Name');
    				datavalue.addColumn('number', 'No. Estimate');
    				
    				for (var i = 0; i < result.length; i++) {
    						var data = result[i];
    						datavalue.addRows([[data[1], data[0]]]);
    				}
    				 
    			     // Create a dashboard.
    		        var dashboard = new google.visualization.Dashboard(
    		            document.getElementById('dashboard_div'));

    		        // Create a range slider, passing some options
    		        var donutRangeSlider = new google.visualization.ControlWrapper({
    		          'controlType': 'NumberRangeFilter',
    		          'containerId': 'filter_div',
    		          'options': {
    		        	'filterColumnLabel': 'No. Estimate'
    		          }
    		        });

    		        // Create a pie chart, passing some options
    		        var pieChart = new google.visualization.ChartWrapper({
    		          'chartType': 'PieChart',
    		          'containerId': 'estapr_div',
    		          'options': {
    		            'width': 230,
    		            'height': 210,
    		            'is3D': true,
    		            'pieSliceText': 'value',
    		            'legend': 'right'
    		          }
    		        });
    		        
    		        var table = new google.visualization.ChartWrapper({
    			          'chartType': 'Table',
    			          'containerId': 'estaprtable_div',
    			          'options': {
    			            'width': 230,
    			            'height': 210,
    			            'pieSliceText': 'value',
    			            'legend': 'right'
    			          }
    			        });


    		        // Establish dependencies, declaring that 'filter' drives 'pieChart',
    		        // so that the pie chart will only display entries that are let through
    		        // given the chosen slider range.
    		        dashboard.bind(donutRangeSlider, pieChart);
    		        dashboard.bind(donutRangeSlider, table);

    		        // Draw the dashboard.
    		        dashboard.draw(datavalue);

    			    
    			    
    			}
    		});
    	  
 */    	  
    	  
    	  
    	  
      
          }

</script>    


<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&libraries=geometry">
	
</script>

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap&libraries=geometry"></script>

<script type="text/javascript">





function showLocation(position) {
   var latitude = position.coords.latitude;
   var longitude = position.coords.longitude;
   alert("Latitude : " + latitude + " Longitude: " + longitude);
}

function errorHandler(err) {
   if(err.code == 1) {
      alert("Error: Access is denied!");
   } else if( err.code == 2) {
      alert("Error: Position is unavailable!");
   }
}
	
function getLocation() {

   if(navigator.geolocation) {
      
      // timeout at 60000 milliseconds (60 seconds)
      var options = {timeout:60000};
      navigator.geolocation.getCurrentPosition(showLocation, errorHandler, options);
   } else {
      alert("Sorry, browser does not support geolocation!");
   }
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
		/**  if(!!navigator.geolocation) {
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
				} */
				
				
				  /* const rectangle = new google.maps.Rectangle();
				  map.addListener("zoom_changed", () => {
				    // Get the current bounds, which reflect the bounds before the zoom.
				    rectangle.setOptions({
				      strokeColor: "#FF0000",
				      strokeOpacity: 0.8,
				      strokeWeight: 2,
				      fillColor: "#FF0000",
				      fillOpacity: 0.35,
				      map,
				      bounds: map.getBounds(),
				    });
				  });
 */
				
				
				
 		var infoWindow = new google.maps.InfoWindow;

	       if (navigator.geolocation) {
	           navigator.geolocation.getCurrentPosition(function(position) {
	             var pos = {
	               lat: position.coords.latitude,
	               lng: position.coords.longitude
	             };

	             infoWindow.setPosition(pos);
	             infoWindow.setContent('Location found.');
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
		

	}

	function viewMapByMode(){
		var viewMode = mode.options[mode.selectedIndex].value;
		//alert(viewMode);
    	
		if(viewMode=='MAP'){
			loadMap();
		}else if(viewMode=='MAP2'){
			loadMapWithoutMntNew();
		}else if(viewMode=='WAYLEAVE'){
			loadMap();
		}else if(viewMode=='BASECON'){
			loadMapBaseCon();
		}else if(viewMode=='CONDUCTOR'){
			loadMapConductor();
		}else if(viewMode=='JUMPER'){
			loadMapJumper();
		}else if(viewMode=='MISSING'){
			loadMapMissing();
		}else if(viewMode=='TRANSFOMER'){
			loadTransformer();
		}else if(viewMode=='MVPOLE'){
			loadmvPole();
		}else if(viewMode=='LVPOLE'){
			loadlvPole();
		}else if(viewMode=='GANTRY'){
			loadGantryNew();
		}else{
			//getLoc();
			loadNetwork();
		}
		
	}
	
	function loadMap() {
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
                url: "/MMS/MapNewOther/" + strArea +"/" + strLine + "/" +strProvince,
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
        					(function(marker, data) {
									
								
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
								var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
								data[0].towerNo+"</td></tr><tr><td>Area : </td><td>"+
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
								"<tr><td><a href=# class=btn btn-lg btn-success data-toggle=modal data-target=#basicModal>Click to view Tower</br> Maintenance Data</a></tr>"								
								"<tr><td><a href='<c:url value="/addSupportNew?id=49"/>'>Add New Support</a></td><td></td></tr>"+
								"</table></div>";
								

	
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

                		//map.fitBounds(bounds);

                		
                		//var polyline = new GPolyline([
    					                       //       new GLatLng(7.3171376, 80.5608933),
    					                           //   new GLatLng(7.3205831, 80.5581145)],
    					                           //   "#ff0000", 50);
    					                         //   map.addOverlay(polyline);

        				
                }
                
                
         });
		
	}

	

function loadMapWithoutMnt() {
		
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
		var selectedValues = $("#line").val();
		var strProvince = province.options[province.selectedIndex].value;
		
		//variables for get the move location
		
		var bounds = new google.maps.LatLngBounds();
		$.ajax
        ({
        	type: 'GET',
            url: "/MMS/MapNewWOMNTGANTRY/" + strArea +"/" + selectedValues + "/" +strProvince,
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
        						  
        						/*  //alert(data[6].id);
        						  if(data[6]){
        						       latLng1 = new google.maps.LatLng(data[6].gpsLatitude, data[6].gpsLongitude);
        						       var marker = new google.maps.Marker({
                     						position: latLng1,
                     						map: map,
                     						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
                     						//marker.setIcon(zoomIcons[map.getZoom()]);
                     						icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
                     						title: "Gantry ID "+data[6].id + " Code " + data[6].code
                     					});
               						
        						       bounds.extend(latLng1);
         	         					
        						  }
        						  
  	         					  
        						 */  
        						  
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
    	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
										
									}
							
        				
        					var firstObj = json[i];
	        				var secondObj = json[i+1]; 
	        				
        					
        					(function(marker, data) {

        						
	        					
							

        						function calcDistance(){
        							
            						
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
     								 
     							}

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
								}else if(data[0].supportType == 8){
									supType = 'MV Pole';
								}else if(data[0].supportType == 9){
									supType = 'LV Pole';
								}else{
									supType = 'NONE';
								} 
								       						       
								
								var lineid =data[0].towerNo;
					
								var towerNO =  data[0].towerNo;
								
		    					var urll = 'http://localhost:9090/MMS/editCompletionData?towerNo='+data[0].id +'&test=test';
								 
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
								
								
								var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
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
								*/
									 "<tr><td><button type='button' id='myBtnGantry' data-toggle=modal data-target=#myModalGantry onClick='viewGantry(\"" + data[0].gantryId + "\")'>Gantry</button></td></tr> "+
											
								
								 "<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								/* "<tr><td>Last Maintenance Date :  </td><td></td></tr>"+
								 */"<tr><td><button type='button' id='myBtn' data-toggle=modal data-target=#myModal onClick='view(\"" + data[0].id + "\")'>View</button></td></tr> "+
								/* "<tr><td>Hot line maintenance details (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"<tr><td>Cold line maintence details  (ES validated maintenance work summary) :  </td><td></td></tr>"+
								 */"</table></div>";
								 
								 
								 
								/*  var insGantryDetailTable ="<div style='float:right; padding: 10px;'><table id ='gantry'><tr></tr><tr><th>General Info</th></tr><tr><td>Gantry Name : </td><td>"+
									data[6].name+"</td></tr><tr><td> Gantry Code:</td><td>"+
									data[6].code+"</td></tr><tr><td>Short circuit current capacity(kA) :  </td><td>"+
									data[6].shortCctCurntCapacity+"</td></tr><tr><td>Earth fault current capacity(kA) :  </td><td>"+
									data[6].earthFaultCurntCapacity+"</td></tr><tr><td>Date of Commissing : </td><td>"+
									data[6].dateOfComm+"</td></tr><tr><td>Gantry Type : </td><td>"+
									data[6].gantryType+"</td></tr><tr><td>Gantry Electrcial Type : </td><td>"+
									data[6].gantryEleType+"</td></tr><tr><td>No of Bus bars : </td><td>"+
									data[6].noBusBar+"</td></tr><tr><td>No of Bus sections : </td><td>"+
									data[6].noBusSec+"</td></tr><tr><td>No of In bays : </td><td>"+
									data[6].noInBays+"<tr><td>No of Out bays :  </td><td>"+
									data[6].noOutBays+"</td></tr><tr><td>Total Land Area :  </td><td>"+
									data[6].totalLandArea+"</td></tr><tr><td>No Of AutoRecloser :  </td><td>"+
									data[6].noAr+"</td></tr><tr><td>No Of LBS :  </td><td>"+
									data[6].noLbs+"</td></tr><tr><td>No Of ABS :</td><td>"+
									data[6].noAbs+"</td></tr><tr><td>No Of Surge Arrestors :  </td><td>"+
									data[6].noSa+"</td></tr><tr><td>No Of DDLO Links :  </td><td>"+
									data[6].noDdloLinks+"</td></tr><tr><td>No Of DDLO fuses :  </td><td>"+
									data[6].noDdloFuses+"</td></tr><tr><td>No Of Incoming Feeders :  </td><td>"+
									data[6].noIncomingFeeder+"</td></tr><tr><td>No Of Outgoing Feeders :</td><td>"+
									data[6].noOutgoingFeeder+"</td></tr><tr><td>GPS Latitude :  </td><td>"+
									data[6].gpsLatitude+"</td></tr><tr><td>GPS Longitude :</td><td>"+
									data[6].gpsLongitude+"</td></tr></table></div>";
 */
								
        						 google.maps.event.addListener(marker, "click", function(e) {
        							     
        								        
	            					      
	            					     	infoWindow.setContent(insDetailTable);
	            					       
	            							
        									infoWindow.open(map, marker);
        						});
								
        					})(marker, data);

        				}

                		map.fitBounds(bounds);

                		
                		
                }
                
                
         });
		
		
		 $.ajax({
			type : 'GET',
			url : "/MMS/findGantryByAreaNewAll/" + strProvince + "/" + strArea +"/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(json) {
				 //alert("success");
				 for (var i = 0, length = json.length; i < length; i++) {
						var data = json[i];
						
						//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
						latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
     					bounds.extend(latLng);
     					
     					var marker = new google.maps.Marker({
    						position: latLng,
    						map: map,
    						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    						//marker.setIcon(zoomIcons[map.getZoom()]);
    						icon: '<c:url value="/resources/img/CEBImages/gantry_blue.png"/>',
    						title: "ID "+data.id 
    					});
     					
var noOfCiur;
						
     					
     					(function(marker, data) {
     						
     						var eleType;
							if(data.gantryEleType == 1){
								eleType = 'SBB';
							}else {
								eleType = 'DBB';
							}
							
							var noOfSec = data.noOutBays / 2 ;
							
							var two ="2";
							var three ="3";
							var four = "4";
							var five = "5";
							
							var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
							"<tr><th>Gantry Info</th></tr>"+
							/* "<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit(\"" + data.id + "\")'>Single Line Diagram</button></td></tr> "+
							 */ "<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit2(\"" + data.id + "\")'>Single Line Diagram 2</button></td></tr> "+
							 "<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit3(\"" + data.id + "\")'>Single Line Diagram with ID</button></td></tr> "+
								
							 /*"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg1(\"" + data.id + "\")'>DOC II</button></td></tr>"+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg2(\"" + data.id + "\")'>DOC III</button></td></tr>"+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg3(\"" + data.id + "\")'>DOC IV</button></td></tr>"+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg4(\"" + data.id + "\")'>DOC V</button></td></tr>"+
							 */
							"<tr><td><button type='button' id='myBtn'  onClick='loadFeederNew(\"" + data.id + "\")'>Feeder Diagram</button></td></tr> "+
							
							"<tr><td>Name : </td><td>"+
							data.name+"</td></tr><tr><td>Code :</td><td>"+
							data.code+"</td></tr><tr><td>Electrical Type :  </td><td>"+
							eleType+"</td></tr><tr><td>No of sections :  </td><td>"+
							noOfSec+"</td></tr>"+
							"<tr><td><button type='button' id='myBtnGantry' data-toggle=modal data-target=#myModalGantry onClick='viewGantry(\"" + data.id + "\")'>More Info</button></td></tr> "+
							
							"</table></div>";


    						google.maps.event.addListener(marker, "click", function(e) {

    							infoWindow.setContent(insDetailTable);
								infoWindow.open(map, marker);
    						});


    					})(marker, data);
     					
     					
     					 
     			}
				map.fitBounds(bounds);
			}
		});
 
		
		
		
		
		
	}
	
	
function loadMapWithoutMntNew() {
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
	//alert(strLine);
	var selectedValues = $("#line").val();
	//alert(selectedValues);
	
	var strProvince = province.options[province.selectedIndex].value;
	
	//variables for get the move location
	var distance = 0;
	var bounds = new google.maps.LatLngBounds();
	//alert('hiii: ' + bounds );
	$.ajax
    ({
    	type: 'GET',
        url: "/MMS/MapNewWOMNTGANTRY/" + strArea +"/" + selectedValues + "/" +strProvince,
         data: {},
        contentType: "application/json; charset=utf-8",
        success : function(json){
        	//alert(json.length);
        	
        		for (var i = 0, length = json.length; i < length; i++) {
					var data = json[i],
						latLng = new google.maps.LatLng(data[0].gpsLatitude, data[0].gpsLongitude);
						//alert('huuuuuuu' + latLng);
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
	            						title: "Click here to view details of Tower No "+data[0].towerNo
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
	            						title: "Click here to view details of Tower No "+data[0].towerNo
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
	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
	            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
            						title: "Click here to view details of Tower No "+data[0].towerNo,
            						label: { color: '#FAF8F8', fontWeight: 'bold', fontSize: '14px', text: '' }
            					});
							  }
							  
							  var curLoc;

							  if(!!navigator.geolocation) {
								  
									//alert('Support');
									
									
														
									navigator.geolocation.getCurrentPosition(function(position) {
									var pos = {
							              lat: position.coords.latitude,
							              lng: position.coords.longitude
							        };
									curLoc = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
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
        				
        				if(secondObj){
								if(firstObj[0].lineId == secondObj[0].lineId){
    							var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
    							var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
    							var dis = (google.maps.geometry.spherical.computeDistanceBetween(p1, p2)).toFixed(2); 
    							distance += parseFloat(dis);
    							
								}
        				}
        				
        				
    					
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
    						
    						
    						  function calcTotalDistance(){
    							 return distance;
    							   
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
							
							
							var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
							data[0].towerNo+"</td></tr><tr><td>Line Length (m) :</td><td>"+
							calcTotalDistance()+"</td></tr><tr><td>Distance to next tower (m) :</td><td>"+
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
    							/* var p1 = new google.maps.LatLng(data[0].gpsLatitude, data[0].gpsLongitude);
    							
    							var directionsService = new google.maps.DirectionsService();
    							var directionsRenderer = new google.maps.DirectionsRenderer();
    							directionsRenderer.setMap(map);
    							var request =  {
    						              origin: curLoc,
    						              destination: p1,
    						              travelMode: 'DRIVING'
    						            };
    							directionsService.route(request,function(result,status){
    								if (status === 'OK') {
    					                directionsRenderer.setDirections(result);
    					              } else {
    					                window.alert('Directions request failed due to ' + status);
    					              }
    							});
*/
    						      	
    							
        						//var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
        							
    							
            							
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
	
	 $.ajax({
			type : 'GET',
			url : "/MMS/findGantryByAreaNewAll/" + strProvince + "/" + strArea +"/" ,
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(json) {
				 //alert("success");
				 for (var i = 0, length = json.length; i < length; i++) {
						var data = json[i];
						
						//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
						latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
  					bounds.extend(latLng);
  					
  					var marker = new google.maps.Marker({
 						position: latLng,
 						map: map,
 						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
 						//marker.setIcon(zoomIcons[map.getZoom()]);
 						icon: '<c:url value="/resources/img/CEBImages/gantry_blue.png"/>',
 						title: "ID "+data.id 
 					});
  					
var noOfCiur;
						
  					
  					(function(marker, data) {
  						
  						var eleType;
							if(data.gantryEleType == 1){
								eleType = 'SBB';
							}else {
								eleType = 'DBB';
							}
							
							var noOfSec = data.noOutBays / 2 ;
							
							var two ="2";
							var three ="3";
							var four = "4";
							var five = "5";
							
							var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
							"<tr><th>Gantry Info</th></tr>"+
							
							/* "<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit(\"" + data.id + "\")'>Single Line Diagram</button></td></tr> "+
							 */"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit2(\"" + data.id + "\")'>Single Line Diagram 2</button></td></tr> "+
							 "<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit3(\"" + data.id + "\")'>Single Line Diagram with ID</button></td></tr> "+
								
							/* "<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg1(\"" + data.id + "\")'>DOC II</button></td></tr>"+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg2(\"" + data.id + "\")'>DOC III</button></td></tr>"+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg3(\"" + data.id + "\")'>DOC IV</button></td></tr>"+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg4(\"" + data.id + "\")'>DOC V</button></td></tr>"+
							 */
							"<tr><td><button type='button' id='myBtn'  onClick='loadFeederNew(\"" + data.id + "\")'>Feeder Diagram</button></td></tr> "+
							
							"<tr><td>Name : </td><td>"+
							data.name+"</td></tr><tr><td>Code :</td><td>"+
							data.code+"</td></tr><tr><td>Electrical Type :  </td><td>"+
							eleType+"</td></tr><tr><td>No of sections :  </td><td>"+
							noOfSec+"</td></tr>"+
							"<tr><td><button type='button' id='myBtnGantry' data-toggle=modal data-target=#myModalGantry onClick='viewGantry(\"" + data.id + "\")'>More Info</button></td></tr> "+
							
							"</table></div>";


 						google.maps.event.addListener(marker, "click", function(e) {

 							infoWindow.setContent(insDetailTable);
								infoWindow.open(map, marker);
 						});


 					})(marker, data);
  					
  					
  					 
  			}
				map.fitBounds(bounds);
			}
		});
	
	
	
	
	
	
	
	
}



	


	
	
	function moveCam(moveLatLng, map){
		if(moveLatLng == null){
			alert("Are you sure?" + moveLatLng);
		}else{
			
		}
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
		//alert('hiii: ' + strArea + strLine );
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNewWOMNTGANTRY/" + strArea +"/" + strLine +"/"+strProvince,
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
            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
            						title: "Click here to view details of Tower No "+data[0].towerNo,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'SW' }
            					});
						  }else{
							//alert("data.tapping");
							if(data[0].interruptedYes == 1){
								var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
            						//marker.setIcon(zoomIcons[map.getZoom()]);
            						icon: '<c:url value="/resources/img/CEBImages/int.png"/>',
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].interruptedDate +'-'+data[0].interruptionNo },
            						title: "Click here to view details of Tower No "+data[0].towerNo + " INT NO" + data[0].interruptionNo
            					});
							}else{
								var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
            						//marker.setIcon(zoomIcons[map.getZoom()]);
            						icon: 'http://www.google.com/mapfiles/topbar.png',
            						title: "Click here to view details of Tower No "+data[0].towerNo + " ID " + data[0].id
            					});
						  }
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
            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
            						title: "Click here to view details of Tower No "+data[0].towerNo,
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
            						title: "Click here to view details of Tower No "+data[0].towerNo,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'SW' }
            					});
						  }else{
							  var marker = new google.maps.Marker({
	        						position: latLng,
	        						map: map,
	        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	        						//marker.setIcon(zoomIcons[map.getZoom()]);
	        						//icon: 'http://www.google.com/mapfiles/dsliderbarshadow.png',
	        						title: "Click here to view details of Tower No "+data[0].towerNo,
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
    						
       						/* //if (firstObj[0].noOfCircuits == 2){
       							var flightPath1 = new google.maps.Polyline({
    	                              path: flightPlanCoordinates,
    	                              geodesic: true,
    	                              strokeColor: '#ba2ba2',
    	                              strokeOpacity: 2.0,
    	                              strokeWeight: 4
    	                            });
         							flightPath1.setMap(map);
           						
       						}
       						 */
       						if(data[3].circuitType == 2){
       							
       							var flightPath1 = new google.maps.Polyline({
  	                              path: flightPlanCoordinates,
  	                              geodesic: true,
  	                              strokeColor: '#ba2ba2',
  	                              strokeOpacity: 2.0,
  	                              strokeWeight: 4
  	                            });
       							flightPath1.setMap(map);
         						
       							
       						}else if(data[3].circuitType == 1){
       							
       							var flightPath1 = new google.maps.Polyline({
    	                              path: flightPlanCoordinates,
    	                              geodesic: true,
    	                              strokeColor: '#2bbd46',
    	                              strokeOpacity: 2.0,
    	                              strokeWeight: 4
    	                            });
         							flightPath1.setMap(map);
           						
       							
       						}else{
       						 var flightPath = new google.maps.Polyline({
	                              path: flightPlanCoordinates,
	                              geodesic: true,
	                              strokeColor: '#FF0000',
	                              strokeOpacity: 2.0,
	                              strokeWeight: 4
	                            });
      						flightPath.setMap(map);
      						
       						}
							 
       						
       						
       						/* if(data[0].noOfCircuits == 1){
								noOfCiur = 'Single';
							}else if (data[0].noOfCircuits == 2){
								noOfCiur = 'Double';
							}else{
								noOfCiur = 'Both';
							}
							 */
       						

	                            
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


    						/* if(firstObj[0].lineId == secondObj[0].lineId){

    							var p1 = new google.maps.LatLng(firstObj[0].gpsLatitude, firstObj[0].gpsLongitude);
    							alert("hiiii2");
    							var p2 = new google.maps.LatLng(secondObj[0].gpsLatitude, secondObj[0].gpsLongitude);
    							alert("hiiii2 : " + calcDistance(p1, p2));
    							function calcDistance(p1, p2){
    								  alert("hiiii5");
    								  return (google.maps.geometry.spherical.computeDistanceBetween(p1, p2) / 1000).toFixed(2);
    							}
    							
    						} */
    						
    						
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
							
							
							var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
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
							"<tr><td>Last Maintenance Date :  </td><td></td></tr>"+
							"<tr><td>Hot line maintenance details (ES validated maintenance work summary) :  </td><td></td></tr>"+
							"<tr><td>Cold line maintence details  (ES validated maintenance work summary) :  </td><td></td></tr>"+
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
	
	$.ajax({
		type : 'GET',
		url : "/MMS/findGantryByAreaNewAll/" + strProvince + "/" + strArea +"/" ,
		data : {},
		contentType : "application/json; charset=utf-8",
		success : function(json) {
			 //alert("success");
			 for (var i = 0, length = json.length; i < length; i++) {
					var data = json[i];
					
					
					
					
					//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
					latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
 					bounds.extend(latLng);
 					
 					var marker = new google.maps.Marker({
						position: latLng,
						map: map,
						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
						//marker.setIcon(zoomIcons[map.getZoom()]);
						icon: '<c:url value="/resources/img/CEBImages/gantry_blue.png"/>',
						title: "ID "+data.id,
						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data.name }
					
					});
 					
var noOfCiur;
					
 					
 					(function(marker, data) {
 						
 						var eleType;
						if(data.gantryEleType == 1){
							eleType = 'SBB';
						}else {
							eleType = 'DBB';
						}
						
						var noOfSec = data.noOutBays / 2 ;
						
						var two ="2";
						var three ="3";
						var four = "4";
						var five = "5";
						
						var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
						"<tr><th>Gantry Info</th></tr>"+
						"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit2(\"" + data.id + "\")'>Single Line Diagram 2</button></td></tr> "+
						
						/* "<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit(\"" + data.id + "\")'>Single Line Diagram</button></td></tr> "+
						 */ "<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit3(\"" + data.id + "\")'>Single Line Diagram with ID</button></td></tr> "+
							
						/* "<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg1(\"" + data.id + "\")'>DOC II</button></td></tr>"+
						"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg2(\"" + data.id + "\")'>DOC III</button></td></tr>"+
						"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg3(\"" + data.id + "\")'>DOC IV</button></td></tr>"+
						"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg4(\"" + data.id + "\")'>DOC V</button></td></tr>"+
						 */
						"<tr><td><button type='button' id='myBtn'  onClick='loadFeederNew(\"" + data.id + "\")'>Feeder Diagram</button></td></tr> "+
						
						"<tr><td>Name : </td><td>"+
						data.name+"</td></tr><tr><td>Code :</td><td>"+
						data.code+"</td></tr><tr><td>Electrical Type :  </td><td>"+
						eleType+"</td></tr><tr><td>No of sections :  </td><td>"+
						noOfSec+"</td></tr>"+
						"<tr><td><button type='button' id='myBtnGantry' data-toggle=modal data-target=#myModalGantry onClick='viewGantry(\"" + data.id + "\")'>More Info</button></td></tr> "+
						
						"</table></div>";


						google.maps.event.addListener(marker, "click", function(e) {

							infoWindow.setContent(insDetailTable);
							infoWindow.open(map, marker);
						});


					})(marker, data);
 					
 					
 					
 					
 					loadGantryLoc(data,bounds,map);
 					 
 			}
			map.fitBounds(bounds);
		}
	});
	
	/* if(data[0].feederIdentification){
		 $.ajax({
		type : 'GET',
		url : "/MMS/getFeederIdentification1?id="+strArea,
		data : {},
		contentType : "application/json; charset=utf-8",
		success : function(json) {
			
			
		}
	});
	 
	
		
	}
	 *//* $.ajax({
		type : 'GET',
		url : "/MMS/getFeederIdentification1?id="+strArea,
		data : {},
		contentType : "application/json; charset=utf-8",
		success : function(json) {
		}
	});
	 */
	
	 /* $.ajax({
		type : 'GET',
		url : "/MMS/findFeederByArea?area="+strArea,
		data : {},
		contentType : "application/json; charset=utf-8",
		success : function(json) {
			 //alert("success");
			 for (var i = 0, length = json.length; i < length; i++) {
					var data = json[i];
					
					//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
					latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
 					bounds.extend(latLng);
 					if(data.typeInOut ==1){
 						
 					var marker = new google.maps.Marker({
						position: latLng,
						map: map,
						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
						//marker.setIcon(zoomIcons[map.getZoom()]);
						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
						
						title: "Name "+data.name + " Code " + data.code
					});
 					}else{
 						var marker = new google.maps.Marker({
    						position: latLng,
    						map: map,
    						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    						//marker.setIcon(zoomIcons[map.getZoom()]);
    						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
    						icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    						
    						title: "Name "+data.name + " Code " + data.code
    					});
     						
 						
 					}
 					
					
 					
 					(function(marker, data) {
 						
 						
 						var feederType;
 						if(data.feederType ==1){
 							feederType = "Overhead";
 						}else{
 							feederType = "Underground";
 						}
 						
 						var inOutType;
 						if(data.typeInOut ==1){
 							inOutType = "Incoming";
 						}else{
 							inOutType = "Outgoing";
 						}
 						
 						
 						var conType;
						 if(data.conductor == 1){
							 conType = 'TDL';
						 }else if(data.conductor == 2){
							 conType = 'RACOON';
						 }else if(data.conductor == 3){
							 conType = 'ELM';
						 }else if(data.conductor == 4){
							 conType = 'TIGER';
						 }else if(data.conductor == 5){
							 conType = 'DOG';
						 }else if(data.conductor == 6){
							 conType = 'LYNX';
						 }else if(data.conductor == 7){
							 conType = 'COPPER';
						 }else if(data.conductor == 8){
							 conType = 'CADMIUM COPPER';
						 }else if(data.conductor == 9){
							 conType = 'COYOTE';
						 }else if(data.conductor == 10){
							 conType = 'MVABC150sqmm';
						 }
						 else{
							 conType = 'Other';
						 }
						
						var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
						"<tr><th>Feeder Info</th></tr>"+
						"<tr><td>Name : </td><td>"+
						data.name+"</td></tr><tr><td>Code :</td><td>"+
						data.code+"</td></tr><tr><td>In / Out :  </td><td>"+
						inOutType+"</td></tr><tr><td>Conductor Type :  </td><td>"+
						conType+"</td></tr><tr><td>No of ABS :  </td><td>"+
						data.noAbs+"</td></tr><tr><td>No of Auto Recloser :  </td><td>"+
						data.noAr+"</td></tr><tr><td>No of DDLO :  </td><td>"+
						data.noDdlo+"</td></tr><tr><td>No of LBS :  </td><td>"+
						data.noLbs+"</td></tr><tr><td>No of Surge Arrestors :  </td><td>"+
						data.noSa+"</td></tr><tr><td>Feeder Type :  </td><td>"+
						
						feederType+"</td></tr>"+
						
						"</table></div>";


						google.maps.event.addListener(marker, "click", function(e) {

							infoWindow.setContent(insDetailTable);
							infoWindow.open(map, marker);
							//infoWindow = new google.maps.InfoWindow({position: e.latLng});
					          //infoWindow.setContent(e.latLng.toString());
					          //infoWindow.open(map);
							
							
						});
						
						


					})(marker, data);
 					
 					     					 
 					 
 					/* google.maps.event.addListener(infoWindow, 'domready', function (mapsMouseEvent) {
 				    	
 				    	var inputValue,button;
 				    	inputValue = document.getElementById('feederobj').value;
						if(document.getElementById('myBtn')){
							button = document.getElementById('myBtn');
				            button.focus();
				            button.onclick = function () {
				                
				                // Call deleteMarker function
				                saveFeederLoc1(inputValue);
				            };
						}
						
 				    	
 		                
 				    }); */
 				    

 					 
 		/*	 }
			map.fitBounds(bounds);
		}
	});
 */ 	 
	
	
}
	
	
	function getIncomingFeederLoc(id){
		
		
	}
	
	function loadGantryLoc(data,bounds,map){
		
		var datagantry = data;
		$.ajax({
			type : 'GET',
			url : "/MMS/getGantryLoc/" + datagantry.id + "/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(json) {
				
					
				 //alert("success");
				 for (var i = 0, length = json.length; i < length; i++) {
						var data = json[i];
						
						//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
						latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
	 					bounds.extend(latLng);
	 					
	 					var marker = new google.maps.Marker({
							position: latLng,
							map: map,
							icon: {
        					         path: google.maps.SymbolPath.CIRCLE,
        					         scale: 1
        					    }
							
							
						});
	 					
	 					var firstObj = json[i];
	 					var secondObj = json[i+1];
	                    
	 					var first =json[0];
	 					var last = json[json.length-1];
	 					
	 					 if(secondObj){
	 					   		var flightPlanCoordinates = [
	 					             {lat: firstObj.gpsLatitude, lng: firstObj.gpsLongitude},
	 					             {lat: secondObj.gpsLatitude, lng: secondObj.gpsLongitude}
	 					                              ];
	 					   		
	 					   
	 					        var flightPath = new google.maps.Polyline({
	 							                   path: flightPlanCoordinates,
	 							                   geodesic: true,
	 					                           strokeColor: '#FF0000',
	 			   	                               strokeOpacity: 2.0,
	 				                               strokeWeight: 4
	 				                            });
				           						flightPath.setMap(map);
				           						
				           			var firstlastCoordinates = [
			         			         					      {lat: first.gpsLatitude, lng: first.gpsLongitude},
			         			         					      {lat: last.gpsLatitude, lng: last.gpsLongitude}
			         					                       ];
				           						
				           			var firstlastPath = new google.maps.Polyline({
							                   path: firstlastCoordinates,
							                   geodesic: true,
					                           strokeColor: '#FF0000',
			   	                               strokeOpacity: 2.0,
				                               strokeWeight: 4
				                            });
				           		       firstlastPath.setMap(map);

	 							                            
	 			 } 
	 			}
				 
				 /* //alert(datagantry.gpsLatitude);
				 latLng = new google.maps.LatLng(datagantry.gpsLatitude, datagantry.gpsLongitude);
					bounds.extend(latLng);
					
					var marker = new google.maps.Marker({
						position: latLng,
						map: map,
						icon: {
 					         path: google.maps.SymbolPath.CIRCLE,
 					         scale: 2
 					    }
						
						
					});
				 */	
				map.fitBounds(bounds);
			}
		});
		
		
		

	}

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
						var slctSubcat = $('#line'), option = "<option value='NONE' selected='selected'>LINE</option>";
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

	function findArea() {
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = province.options[province.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$.ajax({
					type : 'GET',
					url : "/MMS/findAllAreaByProvinceNew/" + strUser,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#area'), option = "<option value='NONE'>AREA</option>";
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

	// the smooth zoom function
	function smoothZoom(map, max, cnt) {
		if (cnt >= max) {
			return;
		} else {
			z = google.maps.event.addListener(map, 'zoom_changed', function(
					event) {
				google.maps.event.removeListener(z);
				smoothZoom(map, max, cnt + 1);
			});
			setTimeout(function() {
				map.setZoom(cnt)
			}, 80); // 80ms is what I found to work well on my system -- it might not work well on all systems
		}
	}
	
	function view(id){	
		
	     var strUser = id;
			
				$.ajax({
						type : 'GET',
						url : "/MMS/getLatestMaintenance/" + strUser,
						data : {},
						contentType : "application/json; charset=utf-8",
						success : function(data) {
							
			
							 var x = document.getElementById("anticlimbingstatus");
							 var y = document.getElementById("attentionstatus");
							 var z = document.getElementById("conductorstatus");
							 var w = document.getElementById("earthconductorstatus");
							 var v = document.getElementById("wayleavestatus");
							 
				              
					            if (x.innerHTML === "anticlimbingstatus") { 
					                x.innerHTML = data.anticlimbingstatus; 
					            }
					            if(y.innerHTML === "attentionstatus"){
					            	y.innerHTML = data.attentionstatus;
					            }
					            if(z.innerHTML === "conductorstatus"){
					            	z.innerHTML = data.conductorstatus;
					            }
					            if(w.innerHTML === "earthconductorstatus"){
					            	w.innerHTML = data.earthconductorstatus;
					            }
					            if(v.innerHTML === "wayleavestatus"){
					            	v.innerHTML = data.wayleavestatus;
					            }
					            
							
							 
							// Get the modal
							 var modal = document.getElementById("myModal");
							 modal.style.display = "block";
							 // Get the button that opens the modal
							 var btn = document.getElementById("myBtn");

							 // Get the <span> element that closes the modal
							 var span = document.getElementsByClassName("close")[0];

							 // When the user clicks the button, open the modal 
							 btn.onclick = function() {
							   modal.style.display = "block";
							   //alert("success");
							 }

							 // When the user clicks on <span> (x), close the modal
							 span.onclick = function() {
							   modal.style.display = "none";
							 }

							 // When the user clicks anywhere outside of the modal, close it
							 window.onclick = function(event) {
							   if (event.target == modal) {
							     modal.style.display = "none";
							   }
							 }				
						}
					});
		}
	
	

	function getGantryByAreaLine()
		
		{     		
	         var strArea = area.options[area.selectedIndex].value;
	        // var strLine = line.options[line.selectedIndex].value;
	        // alert(strArea+" "+strLine);	
			   $.ajax
	             ({
	                     type: 'GET',
	                     url: "/MMS/findGantryByArea/"+strArea+"/",
	                     data: {},
	                     contentType: "application/json; charset=utf-8",
	                     success: function(response) 
	                     {   
	                         var slctSubcat = $('#gantry'), option = "<option value='NONE'>GANTRY</option>";
	     						slctSubcat.empty();
	     						for (var i = 0; i < response.length; i++) {
		                         var item = response[i];
	     							option = option
	     									+ "<option value='"+item.id + "'>"
	     									+ item.code + "</option>";
	     						}
	     						slctSubcat.append(option);
	                         
	                     }
	              });		
			 
			
		}
	
	
	function getFeederByGantryId()

	{			
	var strGantry = gantry.options[gantry.selectedIndex].value;
	//alert(strGantry);
			
		   $.ajax
	         ({
	                 type: 'GET',
	                 url: "/MMS/findFeederByGantryId/"+strGantry+"/",
	                 data: {},
	                 contentType: "application/json; charset=utf-8",
	                 success: function(response) 
	                 {   
	                     var slctSubcat = $('#feeder'), option = "<option value='NONE'>FEEDER</option>";
	 						slctSubcat.empty();
	 						for (var i = 0; i < response.length; i++) {
	                         var item = response[i];
	 							option = option
	 									+ "<option value='"+item.id.feederId + "'>"
	 									+ item.id.feederId + item.name + "</option>";
	 						}
	 						slctSubcat.append(option);
	                     
	                 }
	          });		
		 
		
	}


		
		
		
	function loadgantry() {
		
		//alert("gantryloc");
		var map = new google.maps.Map(document.getElementById("map_container"), {
	          //center: new google.maps.LatLng(7.2665013,80.541458),
	          center: new google.maps.LatLng(7.873054,80.771797),
	          zoom: 12,
	          gestureHandling: 'greedy',
	          mapTypeId: google.maps.MapTypeId.ROADMAP
	        });
		
		
		var strGantry = gantry.options[gantry.selectedIndex].value;
		//alert(strGantry);
		var bounds = new google.maps.LatLngBounds();
		$.ajax({
					type : 'GET',
					url : "/MMS/getGantryLoc/" + strGantry + "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(json) {
						 //alert("success");
						 for (var i = 0, length = json.length; i < length; i++) {
								var data = json[i];
								
								//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
								latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
	         					bounds.extend(latLng);
	         					
	         					var marker = new google.maps.Marker({
	        						position: latLng,
	        						map: map,
	        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	        						//marker.setIcon(zoomIcons[map.getZoom()]);
	        						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
	        						title: "Point ID "+data.id.pointId + " EntBy " + data.entBy
	        					});
	         					
	         					var firstObj = json[i];
	         					var secondObj = json[i+1];
	                            
	         					var first =json[0];
	         					var last = json[json.length-1];
	         					
	         					 if(secondObj){
	         					   		var flightPlanCoordinates = [
	         					             {lat: firstObj.gpsLatitude, lng: firstObj.gpsLongitude},
	         					             {lat: secondObj.gpsLatitude, lng: secondObj.gpsLongitude}
	         					                              ];
	         					   		
	         					   
	         					        var flightPath = new google.maps.Polyline({
	         							                   path: flightPlanCoordinates,
	         							                   geodesic: true,
	         					                           strokeColor: '#FF0000',
	         			   	                               strokeOpacity: 2.0,
	         				                               strokeWeight: 4
	         				                            });
	     			           						flightPath.setMap(map);
	     			           						
	     			           			var firstlastCoordinates = [
	     		         			         					      {lat: first.gpsLatitude, lng: first.gpsLongitude},
	     		         			         					      {lat: last.gpsLatitude, lng: last.gpsLongitude}
	     		         					                       ];
	     			           						
	     			           			var firstlastPath = new google.maps.Polyline({
	   							                   path: firstlastCoordinates,
	   							                   geodesic: true,
	   					                           strokeColor: '#FF0000',
	   			   	                               strokeOpacity: 2.0,
	   				                               strokeWeight: 4
	   				                            });
	     			           		       firstlastPath.setMap(map);

	         							                            
	         			 } 
	         			}
						map.fitBounds(bounds);
					}
				});

	}
	
	
	function viewGantry(id){
		//alert(id);	
		var strUser = parseInt(id);
		//var strUser = id;
		//var strUser = 3550;
		//3550
		

		$.ajax({
					type : 'GET',
					url : "/MMS/getGantry/"+strUser,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						 //alert(data[0].code);
		
						 
						 var y = document.getElementById("gantrycode");
						 var z = document.getElementById("short_circuit");
						 var w = document.getElementById("earth_fault");
						 var v = document.getElementById("DateofCommissing");
						 var a = document.getElementById("Gantry_Type");
						 var b = document.getElementById("Gantry_Electrcial_Type");
						 var c = document.getElementById("No_of_Bus_bars");
						 var d = document.getElementById("No_of_Bus_sections");
						 var e = document.getElementById("No_of_In_bays");
						 var f = document.getElementById("No_of_Out_bays");
						 var g = document.getElementById("Total_Land_Area");
						 var h = document.getElementById("No_Of_AutoRecloser");
						 var i = document.getElementById("No_Of_LBS");
						 var j = document.getElementById("No_Of_ABS");
						 var k = document.getElementById("No_Of_Surge_Arrestors");
						 var l = document.getElementById("No_Of_DDLO_Links");
						 var m = document.getElementById("No_Of_DDLO_fuses");
						 var n = document.getElementById("No_Of_Incoming_Feeders");
						 var o = document.getElementById("No_Of_Outgoing_Feeders");
						 var p = document.getElementById("GPS_Latitude");
						 var q = document.getElementById("GPS_Longitude");
						 var r = document.getElementById("gantryname");	
						 	
						 	
						 	if (y.innerHTML === "gantrycode") { 
				                y.innerHTML = data[0].code; 
				            }
						 	
						 	if (z.innerHTML === "short_circuit") { 
				                z.innerHTML = data[0].shortCctCurntCapacity; 
				            }
						 	
						 	if (w.innerHTML === "earth_fault") { 
				                w.innerHTML = data[0].earthFaultCurntCapacity; 
				            }
						 	
						 	if (v.innerHTML === "DateofCommissing") { 
				                v.innerHTML = data[0].dateOfComm; 
				            }
						 	
						 	if (a.innerHTML === "Gantry_Type") { 
				                a.innerHTML = data[0].gantryType; 
				            }
						 	
						 	if (b.innerHTML === "Gantry_Electrcial_Type") { 
				                b.innerHTML = data[0].gantryEleType; 
				            }
						 	
						 	if (c.innerHTML === "No_of_Bus_bars") { 
				                c.innerHTML = data[0].noBusBar; 
				            }
						 	
						 	if (d.innerHTML === "No_of_Bus_sections") { 
				                d.innerHTML = data[0].noBusSec; 
				           }
						 	
						 	if (e.innerHTML === "No_of_In_bays") { 
				                e.innerHTML = data[0].noInBays; 
				            }
						 	
				            if(f.innerHTML === "No_of_Out_bays"){
				               f.innerHTML = data[0].noOutBays;
				            }
				            
				            if(g.innerHTML === "Total_Land_Area"){
				               g.innerHTML = data[0].totalLandArea;
				            }
				            
				            if(h.innerHTML === "No_Of_AutoRecloser"){
				               h.innerHTML = data[0].noAr;
				            }
				            
				            if(i.innerHTML === "No_Of_LBS"){
				               i.innerHTML = data[0].noLbs;
				            }
				            
				            if(j.innerHTML === "No_Of_ABS"){
				               j.innerHTML = data[0].noAbs;
				            }
				            
				            if(k.innerHTML === "No_Of_Surge_Arrestors"){
				               k.innerHTML = data[0].noSa;
				               
				            }
				            if(l.innerHTML === "No_Of_DDLO_Links"){
					           l.innerHTML = data[0].noDdloLinks;
					        }
					            
					        if(m.innerHTML === "No_Of_DDLO_fuses"){
					           m.innerHTML = data[0].noDdloFuses;
					        }
					            
					        if(n.innerHTML === "No_Of_Incoming_Feeders"){
					           n.innerHTML = data[0].noIncomingFeeder;
					        }
					            
					        if(o.innerHTML === "No_Of_Outgoing_Feeders"){
					           o.innerHTML = data[0].noOutgoingFeeder;
					        }
					        if(p.innerHTML === "GPS_Latitude"){
					           p.innerHTML = data[0].gpsLatitude;
					        }
					            
					        if(q.innerHTML === "GPS_Longitude"){
					           q.innerHTML = data[0].gpsLongitude;
					        }
					        
					        if(r.innerHTML === "gantryname"){
						       r.innerHTML = data[0].name;
						    }
				            
					        
										 
				
						
						}
				});

	}
	
	
	function loadGantryNew(){
		//alert("gantryloc");
		var map = new google.maps.Map(document.getElementById("map_container"), {
	          //center: new google.maps.LatLng(7.2665013,80.541458),
	          center: new google.maps.LatLng(7.873054,80.771797),
	          zoom: 12,
	          gestureHandling: 'greedy',
	          mapTypeId: google.maps.MapTypeId.ROADMAP
	        });
		
		
		//var strArea = area.options[area.selectedIndex].value;
		var strArea = area.options[area.selectedIndex].value;
		//var strLine = line.options[line.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
		
		
		
	    //alert("loadlvPole");
	    var infoWindow = new google.maps.InfoWindow();
		var bounds = new google.maps.LatLngBounds();
		$.ajax({
					type : 'GET',
					url : "/MMS/findGantryByAreaNewAll/" + strProvince + "/" + strArea +"/" ,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(json) {
						 //alert("success");
						 for (var i = 0, length = json.length; i < length; i++) {
								var data = json[i];
								
								//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
								latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
	         					bounds.extend(latLng);
	         					
	         					var marker = new google.maps.Marker({
	        						position: latLng,
	        						map: map,
	        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	        						//marker.setIcon(zoomIcons[map.getZoom()]);
	        						icon: '<c:url value="/resources/img/CEBImages/gantry_blue.png"/>',
            						title: "Name : "+data.gantryname ,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data.name }
	        					});
	         					
var noOfCiur;
								
	         					
	         					(function(marker, data) {
	         						
	         						var eleType;
									if(data.gantryEleType == 1){
										eleType = 'SBB';
									}else {
										eleType = 'DBB';
									}
									
									var noOfSec = data.noOutBays / 2 ;
									
									var two ="2";
									var three ="3";
									var four = "4";
									var five = "5";
									
									var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
									"<tr><th>Gantry Info</th></tr>"+
									"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit2(\"" + data.id + "\")'>Single Line Diagram 2</button></td></tr> "+
									
									/* "<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit(\"" + data.id + "\")'>Single Line Diagram</button></td></tr> "+
									 */ "<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit3(\"" + data.id + "\")'>Single Line Diagram with ID</button></td></tr> "+
										
									/* "<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg1(\"" + data.id + "\")'>DOC II</button></td></tr>"+
									"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg2(\"" + data.id + "\")'>DOC III</button></td></tr>"+
									"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg3(\"" + data.id + "\")'>DOC IV</button></td></tr>"+
									"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg4(\"" + data.id + "\")'>DOC V</button></td></tr>"+
									 */
									"<tr><td><button type='button' id='myBtn'  onClick='loadFeederNew(\"" + data.id + "\")'>Feeder Diagram</button></td></tr> "+
									
									"<tr><td>Name : </td><td>"+
									data.name+"</td></tr><tr><td>Code :</td><td>"+
									data.code+"</td></tr><tr><td>Electrical Type :  </td><td>"+
									eleType+"</td></tr><tr><td>No of sections :  </td><td>"+
									noOfSec+"</td></tr>"+
									"<tr><td><button type='button' id='myBtnGantry' data-toggle=modal data-target=#myModalGantry onClick='viewGantry(\"" + data.id + "\")'>More Info</button></td></tr> "+
									
									"</table></div>";

		
	        						google.maps.event.addListener(marker, "click", function(e) {

	        							infoWindow.setContent(insDetailTable);
										infoWindow.open(map, marker);
	        						});


	        					})(marker, data);
	         					
	         					
	         					 
	         			}
						map.fitBounds(bounds);
					}
				});
		
	}
	
	
	
	
	
	
	function loadFeederNewArea(area){
		//alert("gantryloc");
		var map = new google.maps.Map(document.getElementById("map_container"), {
	          //center: new google.maps.LatLng(7.2665013,80.541458),
	          center: new google.maps.LatLng(7.873054,80.771797),
	          zoom: 12,
	          gestureHandling: 'greedy',
	          mapTypeId: google.maps.MapTypeId.ROADMAP
	        });
		
		
		var strArea = area.options[area.selectedIndex].value;
	    //alert("loadlvPole");
	    var infoWindow = new google.maps.InfoWindow();
		var bounds = new google.maps.LatLngBounds();
		$.ajax({
					type : 'GET',
					url : "/MMS/findFeederByArea?area="+strArea,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(json) {
						 //alert("success");
						 for (var i = 0, length = json.length; i < length; i++) {
								var data = json[i];
								
								//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
								latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
	         					bounds.extend(latLng);
	         					if(data.typeInOut ==1){
	         						
	         					var marker = new google.maps.Marker({
	        						position: latLng,
	        						map: map,
	        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	        						//marker.setIcon(zoomIcons[map.getZoom()]);
	        						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
	        						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
	        						
            						title: "Name "+data.name + " Code " + data.code
	        					});
	         					}else{
	         						var marker = new google.maps.Marker({
		        						position: latLng,
		        						map: map,
		        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
		        						//marker.setIcon(zoomIcons[map.getZoom()]);
		        						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
		        						icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
		        						
	            						title: "Name "+data.name + " Code " + data.code
		        					});
		         						
	         						
	         					}
	         					
								
	         					
	         					(function(marker, data) {
	         						
	         						
	         						var feederType;
	         						if(data.feederType ==1){
	         							feederType = "Overhead";
	         						}else{
	         							feederType = "Underground";
	         						}
	         						
	         						var inOutType;
	         						if(data.typeInOut ==1){
	         							inOutType = "Incoming";
	         						}else{
	         							inOutType = "Outgoing";
	         						}
	         						
	         						
	         						var conType;
									 if(data.conductor == 1){
										 conType = 'TDL';
									 }else if(data.conductor == 2){
										 conType = 'RACOON';
									 }else if(data.conductor == 3){
										 conType = 'ELM';
									 }else if(data.conductor == 4){
										 conType = 'TIGER';
									 }else if(data.conductor == 5){
										 conType = 'DOG';
									 }else if(data.conductor == 6){
										 conType = 'LYNX';
									 }else if(data.conductor == 7){
										 conType = 'COPPER';
									 }else if(data.conductor == 8){
										 conType = 'CADMIUM COPPER';
									 }else if(data.conductor == 9){
										 conType = 'COYOTE';
									 }else if(data.conductor == 10){
										 conType = 'MVABC150sqmm';
									 }
									 else{
										 conType = 'Other';
									 }
									
									var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
									"<tr><th>Feeder Info</th></tr>"+
									"<tr><td>Name : </td><td>"+
									data.name+"</td></tr><tr><td>Code :</td><td>"+
									data.code+"</td></tr><tr><td>In / Out :  </td><td>"+
									inOutType+"</td></tr><tr><td>Conductor Type :  </td><td>"+
									conType+"</td></tr><tr><td>No of ABS :  </td><td>"+
									data.noAbs+"</td></tr><tr><td>No of Auto Recloser :  </td><td>"+
									data.noAr+"</td></tr><tr><td>No of DDLO :  </td><td>"+
									data.noDdlo+"</td></tr><tr><td>No of LBS :  </td><td>"+
									data.noLbs+"</td></tr><tr><td>No of Surge Arrestors :  </td><td>"+
									data.noSa+"</td></tr><tr><td>Feeder Type :  </td><td>"+
									
									feederType+"</td></tr>"+
									
									"</table></div>";

		
	        						google.maps.event.addListener(marker, "click", function(e) {

	        							infoWindow.setContent(insDetailTable);
										infoWindow.open(map, marker);
	        							//infoWindow = new google.maps.InfoWindow({position: e.latLng});
	        					          //infoWindow.setContent(e.latLng.toString());
	        					          //infoWindow.open(map);
										
										
	        						});
	        						
	        						


	        					})(marker, data);
	         					
	         					 map.addListener('click', function(mapsMouseEvent) {
	         				          // Close the current InfoWindow.
	         				          infoWindow.close();
	         				          
	         				         var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
	         				       /*  "<tr><td><button type='button' id='myBtn'  onClick='saveFeederLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'>Save Feeder Location</button></td></tr> "+
	         				        */"<tr><td><input type='text' id='feederobj'></input></td></tr>"+
	         				       "<tr><td><input type='button' id='myBtn'  onClick='saveFeederLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'>Save Feeder Location</button></td></tr> "+
	         				      "<tr><td><input type='button' id='myBtn'  onClick='saveSwitchLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'>Save Switch Location</button></td></tr> "+
	         				     "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc1(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 1</button></td></tr> "+
	         				    "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc2(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 2</button></td></tr> "+
	         				   "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc3(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 3</button></td></tr> "+
	         				  "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc4(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 4</button></td></tr> "+
	         				   
	         				    "<tr><td><input type='button' id='myBtn'  onClick='viewFeederId(\"" + id + "\")'>View Feeder ID</button></td></tr> "+
	         				  "<tr><td><input type='button' id='myBtn'  onClick='viewSwitchId(\"" + id + "\")'>View Switch ID</button></td></tr> "+
	         				   
	         				       /*  "<tr><td><input type='button' id='myBtn'>Save Feeder Location</input></td></tr> "+
	         				      */
	         				        "</table></div>";


	         				          // Create a new InfoWindow.
	         				          infoWindow = new google.maps.InfoWindow({position: mapsMouseEvent.latLng});
	         				          infoWindow.setContent(insDetailTable);
	         				          infoWindow.open(map);
	         				        });
	         					 
	         					 
	         					/* google.maps.event.addListener(infoWindow, 'domready', function (mapsMouseEvent) {
	         				    	
	         				    	var inputValue,button;
	         				    	inputValue = document.getElementById('feederobj').value;
									if(document.getElementById('myBtn')){
										button = document.getElementById('myBtn');
							            button.focus();
							            button.onclick = function () {
							                
							                // Call deleteMarker function
							                saveFeederLoc1(inputValue);
							            };
									}
									
	         				    	
	         		                
	         				    }); */
	         				    

	         					 
	         			}
						map.fitBounds(bounds);
					}
				});
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	function loadFeederNew(id){
		//alert("gantryloc");
		var map = new google.maps.Map(document.getElementById("map_container2"), {
	          //center: new google.maps.LatLng(7.2665013,80.541458),
	          center: new google.maps.LatLng(7.873054,80.771797),
	          zoom: 12,
	          gestureHandling: 'greedy',
	          mapTypeId: google.maps.MapTypeId.ROADMAP
	        });
		
		
		var strArea = area.options[area.selectedIndex].value;
	    //alert("loadlvPole");
	    var infoWindow = new google.maps.InfoWindow();
		var bounds = new google.maps.LatLngBounds();
		$.ajax({
					type : 'GET',
					url : "/MMS/findIncomingFeeder/" + id +"/1/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(json) {
						 //alert("success");
						 for (var i = 0, length = json.length; i < length; i++) {
								var data = json[i];
								
								//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
								latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
	         					bounds.extend(latLng);
	         					if(data.typeInOut ==1){
	         						
	         					var marker = new google.maps.Marker({
	        						position: latLng,
	        						map: map,
	        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	        						//marker.setIcon(zoomIcons[map.getZoom()]);
	        						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
	        						//icon: 'http://labs.google.com/ridefinder/images/incominglbs.png',
	        						/* icon: '<c:url value="/resources/img/CEBImages/arrow edge (4).png"/>',
	        						 */
	        						 
	        						 icon: {
	        					          path: google.maps.SymbolPath.CIRCLE,
	        					          scale: 1
	        					    },
   						
            						title: " tesr "+data.name + " Code " + data.code
	        					});
	         					}else{
	         						var marker = new google.maps.Marker({
		        						position: latLng,
		        						map: map,
		        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
		        						//marker.setIcon(zoomIcons[map.getZoom()]);
		        						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
		        						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
		        						icon: '<c:url value="/resources/img/CEBImages/arrowleftuotgoing.png"/>',
	        						
	            						title: "Name "+data.name + " Code " + data.code
		        					});
		         						
	         						
	         					}
	         					
								
	         					
	         					(function(marker, data) {
	         						
	         						
	         						var feederType;
	         						if(data.feederType ==1){
	         							feederType = "Overhead";
	         						}else{
	         							feederType = "Underground";
	         						}
	         						
	         						var inOutType;
	         						if(data.typeInOut ==1){
	         							inOutType = "Incoming";
	         						}else{
	         							inOutType = "Outgoing";
	         						}
	         						
	         						
	         						var conType;
									 if(data.conductor == 1){
										 conType = 'TDL';
									 }else if(data.conductor == 2){
										 conType = 'RACOON';
									 }else if(data.conductor == 3){
										 conType = 'ELM';
									 }else if(data.conductor == 4){
										 conType = 'TIGER';
									 }else if(data.conductor == 5){
										 conType = 'DOG';
									 }else if(data.conductor == 6){
										 conType = 'LYNX';
									 }else if(data.conductor == 7){
										 conType = 'COPPER';
									 }else if(data.conductor == 8){
										 conType = 'CADMIUM COPPER';
									 }else if(data.conductor == 9){
										 conType = 'COYOTE';
									 }else if(data.conductor == 10){
										 conType = 'MVABC150sqmm';
									 }
									 else{
										 conType = 'Other';
									 }
									
									var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
									"<tr><th>Feeder Info</th></tr>"+
									"<tr><td>Name : </td><td>"+
									data.name+"</td></tr><tr><td>Code :</td><td>"+
									data.code+"</td></tr><tr><td>In / Out :  </td><td>"+
									inOutType+"</td></tr><tr><td>Conductor Type :  </td><td>"+
									conType+"</td></tr><tr><td>No of ABS :  </td><td>"+
									data.noAbs+"</td></tr><tr><td>No of Auto Recloser :  </td><td>"+
									data.noAr+"</td></tr><tr><td>No of DDLO :  </td><td>"+
									data.noDdlo+"</td></tr><tr><td>No of LBS :  </td><td>"+
									data.noLbs+"</td></tr><tr><td>No of Surge Arrestors :  </td><td>"+
									data.noSa+"</td></tr><tr><td>Feeder Type :  </td><td>"+
									
									feederType+"</td></tr>"+
									
									"</table></div>";

		
	        						google.maps.event.addListener(marker, "click", function(e) {

	        							infoWindow.setContent(insDetailTable);
										infoWindow.open(map, marker);
	        							//infoWindow = new google.maps.InfoWindow({position: e.latLng});
	        					          //infoWindow.setContent(e.latLng.toString());
	        					          //infoWindow.open(map);
										
										
	        						});
	        						
	        						


	        					})(marker, data);
	         					
	         					 map.addListener('click', function(mapsMouseEvent) {
	         				          // Close the current InfoWindow.
	         				          infoWindow.close();
	         				          
	         				         var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
	         				       /*  "<tr><td><button type='button' id='myBtn'  onClick='saveFeederLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'>Save Feeder Location</button></td></tr> "+
	         				        */"<tr><td><input type='text' id='feederobj'></input></td></tr>"+
	         				       "<tr><td><input type='button' id='myBtn'  onClick='saveFeederLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'>Save Feeder Location</button></td></tr> "+
	         				      "<tr><td><input type='button' id='myBtn'  onClick='saveSwitchLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'>Save Switch Location</button></td></tr> "+
	         				     "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc1(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 1</button></td></tr> "+
		         				    "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc2(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 2</button></td></tr> "+
		         				   "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc3(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 3</button></td></tr> "+
		         				  "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc4(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 4</button></td></tr> "+
		         				   "<tr><td><input type='button' id='myBtn'  onClick='viewFeederId(\"" + id + "\")'>View Feeder ID</button></td></tr> "+
	         				  "<tr><td><input type='button' id='myBtn'  onClick='viewSwitchId(\"" + id + "\")'>View Switch ID</button></td></tr> "+
	         				   
	         				       /*  "<tr><td><input type='button' id='myBtn'>Save Feeder Location</input></td></tr> "+
	         				      */
	         				        "</table></div>";


	         				          // Create a new InfoWindow.
	         				          infoWindow = new google.maps.InfoWindow({position: mapsMouseEvent.latLng});
	         				          infoWindow.setContent(insDetailTable);
	         				          infoWindow.open(map);
	         				        });
	         					 
	         					 
	         					/* google.maps.event.addListener(infoWindow, 'domready', function (mapsMouseEvent) {
	         				    	
	         				    	var inputValue,button;
	         				    	inputValue = document.getElementById('feederobj').value;
									if(document.getElementById('myBtn')){
										button = document.getElementById('myBtn');
							            button.focus();
							            button.onclick = function () {
							                
							                // Call deleteMarker function
							                saveFeederLoc1(inputValue);
							            };
									}
									
	         				    	
	         		                
	         				    }); */
	         				    
	         					loadFeederNewSupport(data,map,bounds,infoWindow);
	         					 
	         			}
						map.fitBounds(bounds);
					}
				});
		
		
		
		
		
		
		
		
		
		
		
		$.ajax({
			type : 'GET',
			url : "/MMS/findIncomingFeeder/" + id +"/2/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(json) {
				 //alert("success");
				 for (var i = 0, length = json.length; i < length; i++) {
						var data = json[i];
						
						//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
						latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
     					bounds.extend(latLng);
     					if(data.mapId ==1){
     						
     					var marker = new google.maps.Marker({
    						position: latLng,
    						map: map,
    						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    						//marker.setIcon(zoomIcons[map.getZoom()]);
    						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
    						//icon: 'http://labs.google.com/ridefinder/images/incominglbs.png',
    						/* icon: '<c:url value="/resources/img/CEBImages/arrow edge (1).png"/>',
    						 */
    						 icon: {
   					          path: google.maps.SymbolPath.CIRCLE,
   					          scale: 1
   					    },
					
    						title: " tesr "+data.name + " Code " + data.code
    					});
     					}
     					else if(data.mapId ==2){
     						
         					var marker = new google.maps.Marker({
        						position: latLng,
        						map: map,
        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
        						//marker.setIcon(zoomIcons[map.getZoom()]);
        						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
        						//icon: 'http://labs.google.com/ridefinder/images/incominglbs.png',
        						/* icon: '<c:url value="/resources/img/CEBImages/arrow edge (1).png"/>',
        						 */
        						 icon: {
       					          path: google.maps.SymbolPath.CIRCLE,
       					          scale: 1
       					    },
						
        						title: " tesr "+data.name + " Code " + data.code
        					});
         					}
else if(data.mapId ==3){
     						
         					var marker = new google.maps.Marker({
        						position: latLng,
        						map: map,
        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
        						//marker.setIcon(zoomIcons[map.getZoom()]);
        						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
        						//icon: 'http://labs.google.com/ridefinder/images/incominglbs.png',
        						/* icon: '<c:url value="/resources/img/CEBImages/arrow edge (1).png"/>',
        						 */
        						 icon: {
       					          path: google.maps.SymbolPath.CIRCLE,
       					          scale: 1
       					    },
						
        						title: " tesr "+data.name + " Code " + data.code
        					});
         					}
     					
     					else{
     						var marker = new google.maps.Marker({
        						position: latLng,
        						map: map,
        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
        						//marker.setIcon(zoomIcons[map.getZoom()]);
        						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
        						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
        						/* icon: '<c:url value="/resources/img/CEBImages/arrow edge (3).png"/>',
    						 */
    						 icon: {
   					          path: google.maps.SymbolPath.CIRCLE,
   					          scale: 1
   					    },
					
        						title: "Name "+data.name + " Code " + data.code
        					});
         						
     						
     					}
     					
						
     					
     					(function(marker, data) {
     						
     						
     						var feederType;
     						if(data.feederType ==1){
     							feederType = "Overhead";
     						}else{
     							feederType = "Underground";
     						}
     						
     						var inOutType;
     						if(data.typeInOut ==1){
     							inOutType = "Incoming";
     						}else{
     							inOutType = "Outgoing";
     						}
     						
     						
     						var conType;
							 if(data.conductor == 1){
								 conType = 'TDL';
							 }else if(data.conductor == 2){
								 conType = 'RACOON';
							 }else if(data.conductor == 3){
								 conType = 'ELM';
							 }else if(data.conductor == 4){
								 conType = 'TIGER';
							 }else if(data.conductor == 5){
								 conType = 'DOG';
							 }else if(data.conductor == 6){
								 conType = 'LYNX';
							 }else if(data.conductor == 7){
								 conType = 'COPPER';
							 }else if(data.conductor == 8){
								 conType = 'CADMIUM COPPER';
							 }else if(data.conductor == 9){
								 conType = 'COYOTE';
							 }else if(data.conductor == 10){
								 conType = 'MVABC150sqmm';
							 }
							 else{
								 conType = 'Other';
							 }
							
							var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
							"<tr><th>Feeder Info</th></tr>"+
							"<tr><td>Name : </td><td>"+
							data.name+"</td></tr><tr><td>Code :</td><td>"+
							data.code+"</td></tr><tr><td>In / Out :  </td><td>"+
							inOutType+"</td></tr><tr><td>Conductor Type :  </td><td>"+
							conType+"</td></tr><tr><td>No of ABS :  </td><td>"+
							data.noAbs+"</td></tr><tr><td>No of Auto Recloser :  </td><td>"+
							data.noAr+"</td></tr><tr><td>No of DDLO :  </td><td>"+
							data.noDdlo+"</td></tr><tr><td>No of LBS :  </td><td>"+
							data.noLbs+"</td></tr><tr><td>No of Surge Arrestors :  </td><td>"+
							data.noSa+"</td></tr><tr><td>Feeder Type :  </td><td>"+
							
							feederType+"</td></tr>"+
							
							"</table></div>";


    						google.maps.event.addListener(marker, "click", function(e) {

    							infoWindow.setContent(insDetailTable);
								infoWindow.open(map, marker);
    							//infoWindow = new google.maps.InfoWindow({position: e.latLng});
    					          //infoWindow.setContent(e.latLng.toString());
    					          //infoWindow.open(map);
								
								
    						});
    						
    						


    					})(marker, data);
     					
     					 map.addListener('click', function(mapsMouseEvent) {
     				          // Close the current InfoWindow.
     				          infoWindow.close();
     				          
     				         var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
     				       /*  "<tr><td><button type='button' id='myBtn'  onClick='saveFeederLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'>Save Feeder Location</button></td></tr> "+
     				        */"<tr><td><input type='text' id='feederobj'></input></td></tr>"+
     				       "<tr><td><input type='button' id='myBtn'  onClick='saveFeederLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'>Save Feeder Location</button></td></tr> "+
     				      "<tr><td><input type='button' id='myBtn'  onClick='saveSwitchLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'>Save Switch Location</button></td></tr> "+
     				     "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc1(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 1</button></td></tr> "+
         				    "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc2(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 2</button></td></tr> "+
         				   "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc3(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 3</button></td></tr> "+
         				  "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc4(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 4</button></td></tr> "+
         				   "<tr><td><input type='button' id='myBtn'  onClick='viewFeederId(\"" + id + "\")'>View Feeder ID</button></td></tr> "+
     				  "<tr><td><input type='button' id='myBtn'  onClick='viewSwitchId(\"" + id + "\")'>View Switch ID</button></td></tr> "+
     				   
     				       /*  "<tr><td><input type='button' id='myBtn'>Save Feeder Location</input></td></tr> "+
     				      */
     				        "</table></div>";


     				          // Create a new InfoWindow.
     				          infoWindow = new google.maps.InfoWindow({position: mapsMouseEvent.latLng});
     				          infoWindow.setContent(insDetailTable);
     				          infoWindow.open(map);
     				        });
     					 
     					 
     					/* google.maps.event.addListener(infoWindow, 'domready', function (mapsMouseEvent) {
     				    	
     				    	var inputValue,button;
     				    	inputValue = document.getElementById('feederobj').value;
							if(document.getElementById('myBtn')){
								button = document.getElementById('myBtn');
					            button.focus();
					            button.onclick = function () {
					                
					                // Call deleteMarker function
					                saveFeederLoc1(inputValue);
					            };
							}
							
     				    	
     		                
     				    }); */
     				    

     					 
     			}
				map.fitBounds(bounds);
			}
		});
		 
		
		/* $.ajax({
			type : 'GET',
			url : "/MMS/findSwitchByGantryId/" + id +"/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(json) {
				 //alert("success");
				 for (var i = 0, length = json.length; i < length; i++) {
						var data = json[i];
						
						//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
						latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
     					bounds.extend(latLng);
     					if(data.switchType ==1){
     						
     					var marker = new google.maps.Marker({
    						position: latLng,
    						map: map,
    						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    						//marker.setIcon(zoomIcons[map.getZoom()]);
    						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
    						//icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
    						icon: '<c:url value="/resources/img/CEBImages/Capture4.png"/>',
        						
    						title: "Name "+data.switchName + " Code " + data.switchCode
    					});
     					}else if(data.switchType ==2){
     						var marker = new google.maps.Marker({
        						position: latLng,
        						map: map,
        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
        						//marker.setIcon(zoomIcons[map.getZoom()]);
        						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
        						//icon: 'http://labs.google.com/ridefinder/images/Capture1.png',
        						icon: '<c:url value="/resources/img/CEBImages/Capture1.png"/>',
        						
        						title: "Name "+data.switchName + " Code " + data.switchCode
        					});
         					
     						
     					}else if(data.switchType ==3){
     						var marker = new google.maps.Marker({
        						position: latLng,
        						map: map,
        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
        						//marker.setIcon(zoomIcons[map.getZoom()]);
        						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
        						//icon: 'http://labs.google.com/ridefinder/images/mm_20_green.png',
        						icon: '<c:url value="/resources/img/CEBImages/Capture.png"/>',
        						
        						title: "Name "+data.switchName + " Code " + data.switchCode
        					});
         					
     						
     					}
     					
     					
     					else{
     						var marker = new google.maps.Marker({
        						position: latLng,
        						map: map,
        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
        						//marker.setIcon(zoomIcons[map.getZoom()]);
        						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
        						//icon: 'http://labs.google.com/ridefinder/images/mm_20_yellow.png',
        						icon: '<c:url value="/resources/img/CEBImages/Capture3.png"/>',
        						
        						
        						title: "Name "+data.switchName + " Code " + data.switchCode
        					});
         						
     						
     					}
     					
						
     					
     					(function(marker, data) {
     						
     						
     						var switchTypeName;
     						if(data.switchType ==1){
     							switchTypeName = "Auto Recloser";
     						}else if(data.switchType ==2){
     							switchTypeName = "LBS";
     						}else if(data.switchType ==3){
     							switchTypeName = "ABS";
     						}else{
     							switchTypeName = "DDLO";
     						}
     						
     						
							var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
							"<tr><th>Switch Info</th></tr>"+
							"<tr><td>Name : </td><td>"+
							data.switchName+"</td></tr><tr><td>Code :</td><td>"+
							data.switchCode+"</td></tr><tr><td>Type :  </td><td>"+
							switchTypeName+"</td></tr>"+
							
							"</table></div>";


    						google.maps.event.addListener(marker, "click", function(e) {

    							infoWindow.setContent(insDetailTable);
								infoWindow.open(map, marker);
    							
								
    						});
    						
    						


    					})(marker, data);
     					
     				}
				map.fitBounds(bounds);
			}
		});
 */		
		
		
		
		 $.ajax({
			type : 'GET',
			url : "/MMS/getGantryLoc/" + id +"/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(json) {
				 //alert("success");
				 for (var i = 0, length = json.length; i < length; i++) {
						var data = json[i];
						
						//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
						latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
     					bounds.extend(latLng);
     						 var marker = new google.maps.Marker({
        						position: latLng,
        						map: map,
        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
        						//marker.setIcon(zoomIcons[map.getZoom()]);
        						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
        						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png'
        						icon: {
		        					          path: google.maps.SymbolPath.CIRCLE,
		        					          scale: 1
		        					    }
        						
        					});
     						 
     						
     						/* var firstObj = json[i];
        					var secondObj = json[i+1];
                            if(secondObj){
        						 var flightPlanCoordinates = [
            					                              {lat: firstObj.gpsLatitude, lng: firstObj.gpsLongitude},
            					                              {lat: secondObj.gpsLatitude, lng: secondObj.gpsLongitude}
            					                              
            					                            ];
        						 var flightPath = new google.maps.Polyline({
		                              path: flightPlanCoordinates,
		                              geodesic: true,
		                              strokeColor: '#FF0000',
		                              strokeOpacity: 2.0,
		                              strokeWeight: 4
		                            });
           						flightPath.setMap(map);
 */
		                
 
     	 					var firstObj = json[i];
     	 					var secondObj = json[i+1];
     	                    
     	 					var first =json[0];
     	 					var last = json[json.length-1];
     	 					
     	 					 if(secondObj){
     	 					   		var flightPlanCoordinates = [
     	 					             {lat: firstObj.gpsLatitude, lng: firstObj.gpsLongitude},
     	 					             {lat: secondObj.gpsLatitude, lng: secondObj.gpsLongitude}
     	 					                              ];
     	 					   		
     	 					   
     	 					        var flightPath = new google.maps.Polyline({
     	 							                   path: flightPlanCoordinates,
     	 							                   geodesic: true,
     	 					                           strokeColor: '#FF0000',
     	 			   	                               strokeOpacity: 2.0,
     	 				                               strokeWeight: 4
     	 				                            });
     				           						flightPath.setMap(map);
     				           						
     				           			var firstlastCoordinates = [
     			         			         					      {lat: first.gpsLatitude, lng: first.gpsLongitude},
     			         			         					      {lat: last.gpsLatitude, lng: last.gpsLongitude}
     			         					                       ];
     				           						
     				           			var firstlastPath = new google.maps.Polyline({
     							                   path: firstlastCoordinates,
     							                   geodesic: true,
     					                           strokeColor: '#FF0000',
     			   	                               strokeOpacity: 2.0,
     				                               strokeWeight: 4
     				                            });
     				           		       firstlastPath.setMap(map);

     	 							                            
     	 			 
 
 
 
            				
                		}

         						
     					(function(marker, data) {
     						
     						
     						
							var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
							"<tr><th>Bus Bar Info</th></tr>"+
							"</table></div>";


    						google.maps.event.addListener(marker, "click", function(e) {

    							infoWindow.setContent(insDetailTable);
								infoWindow.open(map, marker);
    							
								
    						});
    						
    						


    					})(marker, data);
     					
     				}
				map.fitBounds(bounds);
			}
		});
 

		
	}
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	function loadFeederNewObject(data){
		alert("gantryloc" + data.id);
		var map = new google.maps.Map(document.getElementById("map_container2"), {
	          //center: new google.maps.LatLng(7.2665013,80.541458),
	          center: new google.maps.LatLng(7.873054,80.771797),
	          zoom: 12,
	          gestureHandling: 'greedy',
	          mapTypeId: google.maps.MapTypeId.ROADMAP
	        });
		
		
		var strArea = area.options[area.selectedIndex].value;
	    //alert("loadlvPole");
	    var infoWindow = new google.maps.InfoWindow();
		var bounds = new google.maps.LatLngBounds();
		$.ajax({
					type : 'GET',
					url : "/MMS/findIncomingFeeder/" + data.id +"/1/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(json) {
						 //alert("success");
						 for (var i = 0, length = json.length; i < length; i++) {
								var data = json[i];
								
								//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
								latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
	         					bounds.extend(latLng);
	         					if(data.typeInOut ==1){
	         						
	         					var marker = new google.maps.Marker({
	        						position: latLng,
	        						map: map,
	        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	        						//marker.setIcon(zoomIcons[map.getZoom()]);
	        						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
	        						//icon: 'http://labs.google.com/ridefinder/images/incominglbs.png',
	        						/* icon: '<c:url value="/resources/img/CEBImages/arrow edge (4).png"/>',
	        						 */
	        						 
	        						 icon: {
	        					          path: google.maps.SymbolPath.CIRCLE,
	        					          scale: 1
	        					    },
   						
            						title: " tesr "+data.name + " Code " + data.code
	        					});
	         					}else{
	         						var marker = new google.maps.Marker({
		        						position: latLng,
		        						map: map,
		        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
		        						//marker.setIcon(zoomIcons[map.getZoom()]);
		        						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
		        						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
		        						icon: '<c:url value="/resources/img/CEBImages/arrowleftuotgoing.png"/>',
	        						
	            						title: "Name "+data.name + " Code " + data.code
		        					});
		         						
	         						
	         					}
	         					
								
	         					
	         					(function(marker, data) {
	         						
	         						
	         						var feederType;
	         						if(data.feederType ==1){
	         							feederType = "Overhead";
	         						}else{
	         							feederType = "Underground";
	         						}
	         						
	         						var inOutType;
	         						if(data.typeInOut ==1){
	         							inOutType = "Incoming";
	         						}else{
	         							inOutType = "Outgoing";
	         						}
	         						
	         						
	         						var conType;
									 if(data.conductor == 1){
										 conType = 'TDL';
									 }else if(data.conductor == 2){
										 conType = 'RACOON';
									 }else if(data.conductor == 3){
										 conType = 'ELM';
									 }else if(data.conductor == 4){
										 conType = 'TIGER';
									 }else if(data.conductor == 5){
										 conType = 'DOG';
									 }else if(data.conductor == 6){
										 conType = 'LYNX';
									 }else if(data.conductor == 7){
										 conType = 'COPPER';
									 }else if(data.conductor == 8){
										 conType = 'CADMIUM COPPER';
									 }else if(data.conductor == 9){
										 conType = 'COYOTE';
									 }else if(data.conductor == 10){
										 conType = 'MVABC150sqmm';
									 }
									 else{
										 conType = 'Other';
									 }
									
									var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
									"<tr><th>Feeder Info</th></tr>"+
									"<tr><td>Name : </td><td>"+
									data.name+"</td></tr><tr><td>Code :</td><td>"+
									data.code+"</td></tr><tr><td>In / Out :  </td><td>"+
									inOutType+"</td></tr><tr><td>Conductor Type :  </td><td>"+
									conType+"</td></tr><tr><td>No of ABS :  </td><td>"+
									data.noAbs+"</td></tr><tr><td>No of Auto Recloser :  </td><td>"+
									data.noAr+"</td></tr><tr><td>No of DDLO :  </td><td>"+
									data.noDdlo+"</td></tr><tr><td>No of LBS :  </td><td>"+
									data.noLbs+"</td></tr><tr><td>No of Surge Arrestors :  </td><td>"+
									data.noSa+"</td></tr><tr><td>Feeder Type :  </td><td>"+
									
									feederType+"</td></tr>"+
									
									"</table></div>";

		
	        						google.maps.event.addListener(marker, "click", function(e) {

	        							infoWindow.setContent(insDetailTable);
										infoWindow.open(map, marker);
	        							//infoWindow = new google.maps.InfoWindow({position: e.latLng});
	        					          //infoWindow.setContent(e.latLng.toString());
	        					          //infoWindow.open(map);
										
										
	        						});
	        						
	        						


	        					})(marker, data);
	         					
	         					 map.addListener('click', function(mapsMouseEvent) {
	         				          // Close the current InfoWindow.
	         				          infoWindow.close();
	         				          
	         				         var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
	         				       /*  "<tr><td><button type='button' id='myBtn'  onClick='saveFeederLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'>Save Feeder Location</button></td></tr> "+
	         				        */"<tr><td><input type='text' id='feederobj'></input></td></tr>"+
	         				       "<tr><td><input type='button' id='myBtn'  onClick='saveFeederLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'>Save Feeder Location</button></td></tr> "+
	         				      "<tr><td><input type='button' id='myBtn'  onClick='saveSwitchLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'>Save Switch Location</button></td></tr> "+
	         				     "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc1(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 1</button></td></tr> "+
		         				    "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc2(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 2</button></td></tr> "+
		         				   "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc3(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 3</button></td></tr> "+
		         				  "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc4(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 4</button></td></tr> "+
		         				   "<tr><td><input type='button' id='myBtn'  onClick='viewFeederId(\"" + id + "\")'>View Feeder ID</button></td></tr> "+
	         				  "<tr><td><input type='button' id='myBtn'  onClick='viewSwitchId(\"" + id + "\")'>View Switch ID</button></td></tr> "+
	         				   
	         				       /*  "<tr><td><input type='button' id='myBtn'>Save Feeder Location</input></td></tr> "+
	         				      */
	         				        "</table></div>";


	         				          // Create a new InfoWindow.
	         				          infoWindow = new google.maps.InfoWindow({position: mapsMouseEvent.latLng});
	         				          infoWindow.setContent(insDetailTable);
	         				          infoWindow.open(map);
	         				        });
	         					 
	         					 
	         					/* google.maps.event.addListener(infoWindow, 'domready', function (mapsMouseEvent) {
	         				    	
	         				    	var inputValue,button;
	         				    	inputValue = document.getElementById('feederobj').value;
									if(document.getElementById('myBtn')){
										button = document.getElementById('myBtn');
							            button.focus();
							            button.onclick = function () {
							                
							                // Call deleteMarker function
							                saveFeederLoc1(inputValue);
							            };
									}
									
	         				    	
	         		                
	         				    }); */
	         				    
	         					loadFeederNewSupport(data,map,bounds,infoWindow);
	         					 
	         			}
						map.fitBounds(bounds);
					}
				});
		
		
		
		
		
		
		
		
		
		
		
		$.ajax({
			type : 'GET',
			url : "/MMS/findIncomingFeeder/" + data.id +"/2/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(json) {
				 //alert("success");
				 for (var i = 0, length = json.length; i < length; i++) {
						var data = json[i];
						
						//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
						latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
     					bounds.extend(latLng);
     					if(data.mapId ==1){
     						
     					var marker = new google.maps.Marker({
    						position: latLng,
    						map: map,
    						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    						//marker.setIcon(zoomIcons[map.getZoom()]);
    						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
    						//icon: 'http://labs.google.com/ridefinder/images/incominglbs.png',
    						/* icon: '<c:url value="/resources/img/CEBImages/arrow edge (1).png"/>',
    						 */
    						 icon: {
   					          path: google.maps.SymbolPath.CIRCLE,
   					          scale: 1
   					    },
					
    						title: " tesr "+data.name + " Code " + data.code
    					});
     					}
     					else if(data.mapId ==2){
     						
         					var marker = new google.maps.Marker({
        						position: latLng,
        						map: map,
        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
        						//marker.setIcon(zoomIcons[map.getZoom()]);
        						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
        						//icon: 'http://labs.google.com/ridefinder/images/incominglbs.png',
        						/* icon: '<c:url value="/resources/img/CEBImages/arrow edge (1).png"/>',
        						 */
        						 icon: {
       					          path: google.maps.SymbolPath.CIRCLE,
       					          scale: 1
       					    },
						
        						title: " tesr "+data.name + " Code " + data.code
        					});
         					}
else if(data.mapId ==3){
     						
         					var marker = new google.maps.Marker({
        						position: latLng,
        						map: map,
        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
        						//marker.setIcon(zoomIcons[map.getZoom()]);
        						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
        						//icon: 'http://labs.google.com/ridefinder/images/incominglbs.png',
        						/* icon: '<c:url value="/resources/img/CEBImages/arrow edge (1).png"/>',
        						 */
        						 icon: {
       					          path: google.maps.SymbolPath.CIRCLE,
       					          scale: 1
       					    },
						
        						title: " tesr "+data.name + " Code " + data.code
        					});
         					}
     					
     					else{
     						var marker = new google.maps.Marker({
        						position: latLng,
        						map: map,
        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
        						//marker.setIcon(zoomIcons[map.getZoom()]);
        						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
        						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
        						/* icon: '<c:url value="/resources/img/CEBImages/arrow edge (3).png"/>',
    						 */
    						 icon: {
   					          path: google.maps.SymbolPath.CIRCLE,
   					          scale: 1
   					    },
					
        						title: "Name "+data.name + " Code " + data.code
        					});
         						
     						
     					}
     					
						
     					
     					(function(marker, data) {
     						
     						
     						var feederType;
     						if(data.feederType ==1){
     							feederType = "Overhead";
     						}else{
     							feederType = "Underground";
     						}
     						
     						var inOutType;
     						if(data.typeInOut ==1){
     							inOutType = "Incoming";
     						}else{
     							inOutType = "Outgoing";
     						}
     						
     						
     						var conType;
							 if(data.conductor == 1){
								 conType = 'TDL';
							 }else if(data.conductor == 2){
								 conType = 'RACOON';
							 }else if(data.conductor == 3){
								 conType = 'ELM';
							 }else if(data.conductor == 4){
								 conType = 'TIGER';
							 }else if(data.conductor == 5){
								 conType = 'DOG';
							 }else if(data.conductor == 6){
								 conType = 'LYNX';
							 }else if(data.conductor == 7){
								 conType = 'COPPER';
							 }else if(data.conductor == 8){
								 conType = 'CADMIUM COPPER';
							 }else if(data.conductor == 9){
								 conType = 'COYOTE';
							 }else if(data.conductor == 10){
								 conType = 'MVABC150sqmm';
							 }
							 else{
								 conType = 'Other';
							 }
							
							var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
							"<tr><th>Feeder Info</th></tr>"+
							"<tr><td>Name : </td><td>"+
							data.name+"</td></tr><tr><td>Code :</td><td>"+
							data.code+"</td></tr><tr><td>In / Out :  </td><td>"+
							inOutType+"</td></tr><tr><td>Conductor Type :  </td><td>"+
							conType+"</td></tr><tr><td>No of ABS :  </td><td>"+
							data.noAbs+"</td></tr><tr><td>No of Auto Recloser :  </td><td>"+
							data.noAr+"</td></tr><tr><td>No of DDLO :  </td><td>"+
							data.noDdlo+"</td></tr><tr><td>No of LBS :  </td><td>"+
							data.noLbs+"</td></tr><tr><td>No of Surge Arrestors :  </td><td>"+
							data.noSa+"</td></tr><tr><td>Feeder Type :  </td><td>"+
							
							feederType+"</td></tr>"+
							
							"</table></div>";


    						google.maps.event.addListener(marker, "click", function(e) {

    							infoWindow.setContent(insDetailTable);
								infoWindow.open(map, marker);
    							//infoWindow = new google.maps.InfoWindow({position: e.latLng});
    					          //infoWindow.setContent(e.latLng.toString());
    					          //infoWindow.open(map);
								
								
    						});
    						
    						


    					})(marker, data);
     					
     					 map.addListener('click', function(mapsMouseEvent) {
     				          // Close the current InfoWindow.
     				          infoWindow.close();
     				          
     				         var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
     				       /*  "<tr><td><button type='button' id='myBtn'  onClick='saveFeederLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'>Save Feeder Location</button></td></tr> "+
     				        */"<tr><td><input type='text' id='feederobj'></input></td></tr>"+
     				       "<tr><td><input type='button' id='myBtn'  onClick='saveFeederLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'>Save Feeder Location</button></td></tr> "+
     				      "<tr><td><input type='button' id='myBtn'  onClick='saveSwitchLoc(\"" + mapsMouseEvent.latLng.toString() + "\")'>Save Switch Location</button></td></tr> "+
     				     "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc1(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 1</button></td></tr> "+
         				    "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc2(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 2</button></td></tr> "+
         				   "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc3(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 3</button></td></tr> "+
         				  "<tr><td><input type='button' id='myBtn'  onClick='saveBusBarLoc4(\"" + mapsMouseEvent.latLng.toString() + "\")'>Gantry Location 4</button></td></tr> "+
         				   "<tr><td><input type='button' id='myBtn'  onClick='viewFeederId(\"" + id + "\")'>View Feeder ID</button></td></tr> "+
     				  "<tr><td><input type='button' id='myBtn'  onClick='viewSwitchId(\"" + id + "\")'>View Switch ID</button></td></tr> "+
     				   
     				       /*  "<tr><td><input type='button' id='myBtn'>Save Feeder Location</input></td></tr> "+
     				      */
     				        "</table></div>";


     				          // Create a new InfoWindow.
     				          infoWindow = new google.maps.InfoWindow({position: mapsMouseEvent.latLng});
     				          infoWindow.setContent(insDetailTable);
     				          infoWindow.open(map);
     				        });
     					 
     					 
     					/* google.maps.event.addListener(infoWindow, 'domready', function (mapsMouseEvent) {
     				    	
     				    	var inputValue,button;
     				    	inputValue = document.getElementById('feederobj').value;
							if(document.getElementById('myBtn')){
								button = document.getElementById('myBtn');
					            button.focus();
					            button.onclick = function () {
					                
					                // Call deleteMarker function
					                saveFeederLoc1(inputValue);
					            };
							}
							
     				    	
     		                
     				    }); */
     				    

     					 
     			}
				map.fitBounds(bounds);
			}
		});
		 
		
				
		
		 $.ajax({
			type : 'GET',
			url : "/MMS/getGantryLoc/" + data.id +"/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(json) {
				 //alert("success");
				 for (var i = 0, length = json.length; i < length; i++) {
						var data = json[i];
						
						//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
						latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
     					bounds.extend(latLng);
     						 var marker = new google.maps.Marker({
        						position: latLng,
        						map: map,
        						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
        						//marker.setIcon(zoomIcons[map.getZoom()]);
        						//icon: '<c:url value="/resources/img/CEBImages/gantrynew.png"/>',
        						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png'
        						icon: {
		        					          path: google.maps.SymbolPath.CIRCLE,
		        					          scale: 1
		        					    }
        						
        					});
     						 
     						
     						/* var firstObj = json[i];
        					var secondObj = json[i+1];
                            if(secondObj){
        						 var flightPlanCoordinates = [
            					                              {lat: firstObj.gpsLatitude, lng: firstObj.gpsLongitude},
            					                              {lat: secondObj.gpsLatitude, lng: secondObj.gpsLongitude}
            					                              
            					                            ];
        						 var flightPath = new google.maps.Polyline({
		                              path: flightPlanCoordinates,
		                              geodesic: true,
		                              strokeColor: '#FF0000',
		                              strokeOpacity: 2.0,
		                              strokeWeight: 4
		                            });
           						flightPath.setMap(map);
 */
		                
 
     	 					var firstObj = json[i];
     	 					var secondObj = json[i+1];
     	                    
     	 					var first =json[0];
     	 					var last = json[json.length-1];
     	 					
     	 					 if(secondObj){
     	 					   		var flightPlanCoordinates = [
     	 					             {lat: firstObj.gpsLatitude, lng: firstObj.gpsLongitude},
     	 					             {lat: secondObj.gpsLatitude, lng: secondObj.gpsLongitude}
     	 					                              ];
     	 					   		
     	 					   
     	 					        var flightPath = new google.maps.Polyline({
     	 							                   path: flightPlanCoordinates,
     	 							                   geodesic: true,
     	 					                           strokeColor: '#FF0000',
     	 			   	                               strokeOpacity: 2.0,
     	 				                               strokeWeight: 4
     	 				                            });
     				           						flightPath.setMap(map);
     				           						
     				           			var firstlastCoordinates = [
     			         			         					      {lat: first.gpsLatitude, lng: first.gpsLongitude},
     			         			         					      {lat: last.gpsLatitude, lng: last.gpsLongitude}
     			         					                       ];
     				           						
     				           			var firstlastPath = new google.maps.Polyline({
     							                   path: firstlastCoordinates,
     							                   geodesic: true,
     					                           strokeColor: '#FF0000',
     			   	                               strokeOpacity: 2.0,
     				                               strokeWeight: 4
     				                            });
     				           		       firstlastPath.setMap(map);

     	 							                            
     	 			 
 
 
 
            				
                		}

         						
     					(function(marker, data) {
     						
     						
     						
							var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
							"<tr><th>Bus Bar Info</th></tr>"+
							"</table></div>";


    						google.maps.event.addListener(marker, "click", function(e) {

    							infoWindow.setContent(insDetailTable);
								infoWindow.open(map, marker);
    							
								
    						});
    						
    						


    					})(marker, data);
     					
     				}
				map.fitBounds(bounds);
			}
		});
 

		
	}

		 
		 
	function loadFeederNewSupport(feederObj,map,bounds,infoWindow){
		//alert("feederObj : "+ feederObj.);
		
		 $.ajax({
			type : 'GET',
			url : "/MMS/getFeederIdentification1?feederId=" + feederObj.id.feederId,
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(json) {
				//alert("dd : " +json.gpsLatitude );
			var data = json;
				 //alert("success");
				 if(json.gpsLatitude){
						latLng = new google.maps.LatLng(json.gpsLatitude, json.gpsLongitude);
     					bounds.extend(latLng);
     						 var marker = new google.maps.Marker({
        						position: latLng,
        						map: map,
        						icon: {
		        					          path: google.maps.SymbolPath.CIRCLE,
		        					          scale: 1
		        					    }
        						
        					});
     						 
     						  const lineSymbol = {
     								    path: google.maps.SymbolPath.FORWARD_CLOSED_ARROW,
     								  };
     						 
     						
     						var firstObj = json;
     	 					var secondObj = feederObj;
     	                    
     	 					//var first =json[0];
     	 					//var last = json[json.length-1];
     	 					
     	 					 if(secondObj){
     	 					   		/* var flightPlanCoordinates = [
     	 					             {lat: firstObj.gpsLatitude, lng: firstObj.gpsLongitude},
     	 					             {lat: secondObj.gpsLatitude, lng: secondObj.gpsLongitude}
     	 					                              ];
     	 					   		
     	 					   
     	 					        var flightPath = new google.maps.Polyline({
     	 							                   path: flightPlanCoordinates,
     	 							                   geodesic: true,
     	 					                           strokeColor: '#FF0000',
     	 			   	                               strokeOpacity: 2.0,
     	 				                               strokeWeight: 4
     	 				                            });
     				           						flightPath.setMap(map);
     				           	 */					
     				           			/* var firstlastCoordinates = [
     			         			         					      {lat: first.gpsLatitude, lng: first.gpsLongitude},
     			         			         					      {lat: last.gpsLatitude, lng: last.gpsLongitude}
     			         					                       ];
     				           						
     				           			var firstlastPath = new google.maps.Polyline({
     							                   path: firstlastCoordinates,
     							                   geodesic: true,
     					                           strokeColor: '#FF0000',
     			   	                               strokeOpacity: 2.0,
     				                               strokeWeight: 4
     				                            });
     				           		       firstlastPath.setMap(map);
 */
     	 							                            
     	 			 
     	 						// Create the polyline and add the symbol via the 'icons' property.
     	 					  const line = new google.maps.Polyline({
     	 					    path: [
     	 					      { lat: firstObj.gpsLatitude, lng: firstObj.gpsLongitude },
     	 					      { lat: secondObj.gpsLatitude, lng: secondObj.gpsLongitude },
     	 					    ],
     	 					    icons: [
     	 					      {
     	 					        icon: lineSymbol,
     	 					        offset: "100%",
     	 					      },
     	 					    ],
     	 					    map: map,
     	 					  });

 
     	 					animateCircle(line);

            				
                		}

         						
     					(function(marker, data) {
     						
     						
     						
							var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
							"<tr><th>Tower Info</th></tr>"+
							"</table></div>";


    						google.maps.event.addListener(marker, "click", function(e) {

    							infoWindow.setContent(insDetailTable);
								infoWindow.open(map, marker);
    							
								
    						});
    						
    						


    					})(marker, data);
     					
     				
				map.fitBounds(bounds);
			}
			}
		});
		 
		 
		 $.ajax({
				type : 'GET',
				url : "/MMS/getFeederIdentification2?feederId=" + feederObj.id.feederId,
				data : {},
				contentType : "application/json; charset=utf-8",
				success : function(json) {
					//alert("dd : " +json.gpsLatitude );
				var data = json;
					 //alert("success");
					 if(json.gpsLatitude){
							latLng = new google.maps.LatLng(json.gpsLatitude, json.gpsLongitude);
	     					bounds.extend(latLng);
	     						 var marker = new google.maps.Marker({
	        						position: latLng,
	        						map: map,
	        						icon: {
			        					          path: google.maps.SymbolPath.CIRCLE,
			        					          scale: 1
			        					    }
	        						
	        					});
	     						 
	     						 const lineSymbol = {
	     								    path: google.maps.SymbolPath.FORWARD_CLOSED_ARROW,
	     								  };
	     						
	     						var firstObj = json;
	     	 					var secondObj = feederObj;
	     	                    
	     	 					//var first =json[0];
	     	 					//var last = json[json.length-1];
	     	 					
	     	 					 if(secondObj){
	     	 					   		/* var flightPlanCoordinates = [
	     	 					             {lat: firstObj.gpsLatitude, lng: firstObj.gpsLongitude},
	     	 					             {lat: secondObj.gpsLatitude, lng: secondObj.gpsLongitude}
	     	 					                              ];
	     	 					   		
	     	 					   
	     	 					        var flightPath = new google.maps.Polyline({
	     	 							                   path: flightPlanCoordinates,
	     	 							                   geodesic: true,
	     	 					                           strokeColor: '#FF0000',
	     	 			   	                               strokeOpacity: 2.0,
	     	 				                               strokeWeight: 4
	     	 				                            });
	     				           						flightPath.setMap(map);
	     				           	 */					
	     				           			/* var firstlastCoordinates = [
	     			         			         					      {lat: first.gpsLatitude, lng: first.gpsLongitude},
	     			         			         					      {lat: last.gpsLatitude, lng: last.gpsLongitude}
	     			         					                       ];
	     				           						
	     				           			var firstlastPath = new google.maps.Polyline({
	     							                   path: firstlastCoordinates,
	     							                   geodesic: true,
	     					                           strokeColor: '#FF0000',
	     			   	                               strokeOpacity: 2.0,
	     				                               strokeWeight: 4
	     				                            });
	     				           		       firstlastPath.setMap(map);
	 */
	     	 							                            
	     	 			 
	 
	     	 						 const line = new google.maps.Polyline({
	          	 					    path: [
	          	 					      { lat: firstObj.gpsLatitude, lng: firstObj.gpsLongitude },
	          	 					      { lat: secondObj.gpsLatitude, lng: secondObj.gpsLongitude },
	          	 					    ],
	          	 					    icons: [
	          	 					      {
	          	 					        icon: lineSymbol,
	          	 					        offset: "100%",
	          	 					      },
	          	 					    ],
	          	 					    map: map,
	          	 					  });


	 
	            				
	                		}

	         						
	     					(function(marker, data) {
	     						
	     						
	     						
								var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr>"+
								"<tr><th>Tower Info</th></tr>"+
								"</table></div>";


	    						google.maps.event.addListener(marker, "click", function(e) {

	    							infoWindow.setContent(insDetailTable);
									infoWindow.open(map, marker);
	    							
									
	    						});
	    						
	    						


	    					})(marker, data);
	     					
	     				
					map.fitBounds(bounds);
				}
				}
			});

 

		
	}
	
	function animateCircle(line) {
		  var count = 0;
		  var listener = window.setInterval(function() {
		    count = (count + 1) % 200;

		    var icons = line.get('icons');
		    icons[0].offset = (count / 2) + '%';
		    line.set('icons', icons);
		    if (count == 199) clearInterval(listener);
		  }, 20);
		} 

	
	function openPopupSubmit2(id)
	{
	       
		
		var url="downloadSingleLineDiagram?id=" +id ;
	    
		
		//var url='<c:url value="/resources/img/CEBImages/Gampaha Gantry.pdf"/>';
	       var width = 1100;
	           var height = 700;
	           var left = parseInt((screen.availWidth/2) - (width/2));
	           var top = parseInt((screen.availHeight/2) - (height/2));
	           var windowFeatures = "width=" + width + ",height=" + height + 
	        ",status,resizable,left=" + left + ",top=" + top +
	        "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	       window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
	       
	}
	
	
	function openPopupSubmit3(id)
	{
	       
		
		var url="downloadSingleLineDiagramWithId?id=" +id ;
	    
		
		//var url='<c:url value="/resources/img/CEBImages/Gampaha Gantry.pdf"/>';
	       var width = 1100;
	           var height = 700;
	           var left = parseInt((screen.availWidth/2) - (width/2));
	           var top = parseInt((screen.availHeight/2) - (height/2));
	           var windowFeatures = "width=" + width + ",height=" + height + 
	        ",status,resizable,left=" + left + ",top=" + top +
	        "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	       window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
	       
	}
	
	
	
	function openPopupSubmit()
	{
	       var url='<c:url value="/resources/img/CEBImages/Gampaha Gantry.pdf"/>';
	       var width = 1100;
	           var height = 700;
	           var left = parseInt((screen.availWidth/2) - (width/2));
	           var top = parseInt((screen.availHeight/2) - (height/2));
	           var windowFeatures = "width=" + width + ",height=" + height + 
	        ",status,resizable,left=" + left + ",top=" + top +
	        "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	       window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
	       
	}
	
	function viewFeederId(id){
		var url = "/MMS/findFeederByGantryIdStatus/" + id +"/1/";
	   // alert(url);
        var str ='';

        $.ajax({
	      type : "GET",
	      url : url,
	      success : function(json) {
	    	 
		  for (var i = 0, length = json.length; i < length; i++) {
			  str += "Feeder Id : "+json[i].id.feederId +" Gantry Id : " + json[i].id.gantryId +" Name : "+json[i].name + " Code :"+ json[i].code +"\n";
			  
	      }
		  alert(str);
	     }
         });
		  
	}
	
	function viewSwitchId(id){
		var url = "/MMS/findSwitchByGantryId/" + id +"/";
	   // alert(url);
        var str ='';

        $.ajax({
	      type : "GET",
	      url : url,
	      success : function(json) {
	      for (var i = 0, length = json.length; i < length; i++) {
			  str += "Switch Id : "+json[i].id.switchId +" Feeder Id : "+json[i].id.feederId +" Gantry Id : " + json[i].id.gantryId +" Name : "+json[i].switchName + " Code :"+ json[i].switchCode +"\n";
			  
	      }
		  alert(str);
	     }
         });
		  
	}

	
	function openPopupSubmit(id)
	{
	      
		//alert(id);
		var url="downloadSLDGantry?id="+id;
	    var width = 1100;
	    var height = 700;
	    var left = parseInt((screen.availWidth/2) - (width/2));
	    var top = parseInt((screen.availHeight/2) - (height/2));
	    var windowFeatures = "width=" + width + ",height=" + height + 
	    ",status,resizable,left=" + left + ",top=" + top +
	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
	           
	}
	
	
	function openPopupSubmitImg1(id)
	{
	      
		//alert(id);
		var url="downloadIntImgReq?id="+id+"&seq=2";
	    var width = 1100;
	    var height = 700;
	    var left = parseInt((screen.availWidth/2) - (width/2));
	    var top = parseInt((screen.availHeight/2) - (height/2));
	    var windowFeatures = "width=" + width + ",height=" + height + 
	    ",status,resizable,left=" + left + ",top=" + top +
	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
	           
	}
	
	function openPopupSubmitImg2(id)
	{
	      
		//alert(id);
		var url="downloadIntImgReq?id="+id+"&seq=3";
	    var width = 1100;
	    var height = 700;
	    var left = parseInt((screen.availWidth/2) - (width/2));
	    var top = parseInt((screen.availHeight/2) - (height/2));
	    var windowFeatures = "width=" + width + ",height=" + height + 
	    ",status,resizable,left=" + left + ",top=" + top +
	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
	           
	}
	
	function openPopupSubmitImg3(id)
	{
	      
		//alert(id);
		var url="downloadIntImgReq?id="+id+"&seq=4";
	    var width = 1100;
	    var height = 700;
	    var left = parseInt((screen.availWidth/2) - (width/2));
	    var top = parseInt((screen.availHeight/2) - (height/2));
	    var windowFeatures = "width=" + width + ",height=" + height + 
	    ",status,resizable,left=" + left + ",top=" + top +
	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
	           
	}
	
	function openPopupSubmitImg4(id)
	{
	      
		//alert(id);
		var url="downloadIntImgReq?id="+id+"&seq=5";
	    var width = 1100;
	    var height = 700;
	    var left = parseInt((screen.availWidth/2) - (width/2));
	    var top = parseInt((screen.availHeight/2) - (height/2));
	    var windowFeatures = "width=" + width + ",height=" + height + 
	    ",status,resizable,left=" + left + ",top=" + top +
	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
	           
	}
	
	function saveFeederLoc(id){
		//var strFeeder = feeder.options[feeder.selectedIndex].value;
		
		//alert(strFeeder);
		 var y = document.getElementById("feederobj").value;
		//alert(y);			
		//alert(id);
		var n = id.indexOf(",");
		var length = id.length;
		var latitude = id.substring(1, n);
		var longitude = id.substring(n+1, length-1);
		
		//alert(latitude);
		////alert(longitude);
		
		var url = "/MMS/updateFeederNew/" + y + "/" +longitude+"/"+ latitude + "/";
        //alert(url);

$.ajax({
	type : "GET",
	url : url,
	success : function(response) {
		alert("feeder updated succesfully...");
		console.log(response);
		//window.location.reload();
		//disable(pid);
	}
});

		
		
		
		
	}

	
	function saveSwitchLoc(id){
		//var strFeeder = feeder.options[feeder.selectedIndex].value;
		
		//alert(strFeeder);
		 var y = document.getElementById("feederobj").value;
		//alert(y);			
		//alert(id);
		var n = id.indexOf(",");
		var length = id.length;
		var latitude = id.substring(1, n);
		var longitude = id.substring(n+1, length-1);
		
		//alert(latitude);
		////alert(longitude);
		
		var url = "/MMS/updateSwitchNew/" + y + "/" +longitude+"/"+ latitude + "/";
        //alert(url);

$.ajax({
	type : "GET",
	url : url,
	success : function(response) {
		alert("Switch updated succesfully...");
		console.log(response);
		//window.location.reload();
		//disable(pid);
	}
});

		
		
		
		
	}
	
	
	
	
	
	
	
	function saveBusBarLoc1(id){
		//var strFeeder = feeder.options[feeder.selectedIndex].value;
		
		//alert(strFeeder);
		 var y = document.getElementById("feederobj").value;
		//alert(y);			
		//alert(id);
		var n = id.indexOf(",");
		var length = id.length;
		var latitude = id.substring(1, n);
		var longitude = id.substring(n+1, length-1);
		
		//alert(latitude);
		////alert(longitude);
		
		var url = "/MMS/updateBusBarLoc1New/" + y + "/" +longitude+"/"+ latitude + "/1";
        //alert(url);

$.ajax({
	type : "GET",
	url : url,
	success : function(response) {
		alert("Gantry location 1 updated succesfully...");
		console.log(response);
		//window.location.reload();
		//disable(pid);
	}
});

		
		
		
		
	}

	function saveBusBarLoc2(id){
		//var strFeeder = feeder.options[feeder.selectedIndex].value;
		
		//alert(strFeeder);
		 var y = document.getElementById("feederobj").value;
		//alert(y);			
		//alert(id);
		var n = id.indexOf(",");
		var length = id.length;
		var latitude = id.substring(1, n);
		var longitude = id.substring(n+1, length-1);
		
		//alert(latitude);
		////alert(longitude);
		
		var url = "/MMS/updateBusBarLoc1New/" + y + "/" +longitude+"/"+ latitude + "/2";
        //alert(url);

$.ajax({
	type : "GET",
	url : url,
	success : function(response) {
		alert("Gantry location 2 updated succesfully...");
		console.log(response);
		//window.location.reload();
		//disable(pid);
	}
});
	}
		
function saveBusBarLoc3(id){
	//var strFeeder = feeder.options[feeder.selectedIndex].value;
	
	//alert(strFeeder);
	 var y = document.getElementById("feederobj").value;
	//alert(y);			
	//alert(id);
	var n = id.indexOf(",");
	var length = id.length;
	var latitude = id.substring(1, n);
	var longitude = id.substring(n+1, length-1);
	
	//alert(latitude);
	////alert(longitude);
	
	var url = "/MMS/updateBusBarLoc1New/" + y + "/" +longitude+"/"+ latitude + "/3";
    //alert(url);

$.ajax({
type : "GET",
url : url,
success : function(response) {
	alert("Gantry location 3 updated succesfully...");
	console.log(response);
	//window.location.reload();
	//disable(pid);
}
});

	
	
	
	
}

function saveBusBarLoc4(id){
	//var strFeeder = feeder.options[feeder.selectedIndex].value;
	
	//alert(strFeeder);
	 var y = document.getElementById("feederobj").value;
	//alert(y);			
	//alert(id);
	var n = id.indexOf(",");
	var length = id.length;
	var latitude = id.substring(1, n);
	var longitude = id.substring(n+1, length-1);
	
	//alert(latitude);
	////alert(longitude);
	
	var url = "/MMS/updateBusBarLoc1New/" + y + "/" +longitude+"/"+ latitude + "/4";
    //alert(url);

$.ajax({
type : "GET",
url : url,
success : function(response) {
	alert("Gantry location 4 updated succesfully...");
	console.log(response);
	//window.location.reload();
	//disable(pid);
}
});

	
	
	
	
}

	
		
		
	
	
	function myFunction() {
		  var x = document.getElementById("test");
		  var elem = document.getElementById("showBtn");
		  
		  if (x.style.display === "none") {
		    x.style.display = "block";
		    
		  } else {
		    x.style.display = "none";
		  }
		  
		    if (elem.value=="Hide Options") elem.value = "Show Options";
		    else elem.value = "Hide Options";
		}


	function closeall() {
		 var x = document.getElementById("test");
		 x.style.display = "none";
	    return;
	}


	
	






	
	
</script>

</head>

<body onload="myMap(new google.maps.LatLng(7.475214, 80.744077), 7);">
	<div id="theme-wrapper">
		<%@ include file="sections/header.jsp"%>

		<div id="page-wrapper" class="container">
			<div class="row">

				<%@ include file="sections/userLevels.jsp"%>

				<div id="content-wrapper">
					<div class="row">
<!-- The Modal -->
                         <div id="myModal" class="modal">



	

                              <!-- Modal content -->
                              <div class="modal-content">
                             <span class="close">&times;</span>
                                <label>Maintenance Details</label><br>
                                <p1>Anticlimbing status : <label id="anticlimbingstatus">anticlimbingstatus</label></p1><br>
                                <p1>Attention status : <label id="attentionstatus">attentionstatus</label></p1><br>
                                <p1>Conductor status : <label id="conductorstatus">conductorstatus</label></p1><br>
                                <p1>Earth conductor status : <label id="earthconductorstatus">earthconductorstatus</label></p1><br>
                                <p1>Way leave status : <label id="wayleavestatus">wayleavestatus</label></p1><br>
                                
                             </div>

                        </div>


						<div class="col-lg-12">
							<div class="col-lg-9">
								<ol class="breadcrumb">
									<li><a href="#">Home</a></li>
									<li class="active"><span>Dashboard</span></li>
								</ol>

								
							</div>

							<%@ include file="sections/userDetails.jsp"%>

						</div>

					</div>

					<link rel="stylesheet"
						href="https://use.fontawesome.com/releases/v5.0.10/css/all.css"
						integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg"
						crossorigin="anonymous">


<%-- <c:if
													test="${sessionScope.loggedUserRole =='CE'}">
													  <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  green-bg"></i>
                                                            <span class="headline">Estimate Approval</span>
                                                            <span class="headline">
                                                                <a href="estApprovalNew"><span class="num" style="color:red; font-weight:bold;">${countEstApprove}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  green-bg"></i>
                                                            <span class="headline">Estimate -Forward to next next level</span>
                                                            <span class="headline">
                                                                <a href="estApprovalNewRecommend"><span class="num" style="color:red; font-weight:bold;">${countEstApprove}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                             
                                             <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  yellow-bg"></i>
                                                            <span class="headline">Revise Job Approval</span>
                                                            <span class="headline">
                                                                <a href="reviseApprovalNewAE"><span class="num" style="color:red; font-weight:bold;">${countRevEstApprove}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                             <div class="col-sm-4">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square-o  yellow-bg"></i>
                                                            <span class="headline">Estimate - Deallocate the Responsible EE</span>
                                                            <span class="headline">
                                                                <a href="estApprovalNewESDA">De-Allocate</a>
                                                                                                                       </span>
                                                    
                                                            
                                                    </div>
                                            </div>
                                            
</c:if> --%>

<c:if
													test="${sessionScope.loggedUserRole =='EE'}">
													
										<div class="row">
                            <div class="col-lg-12">                                                                                                   
                                        <div class="row">                                           
                                            <div class="col-sm-2">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square-o  yellow-bg"></i>
                                                            <span class="headline">Interruption Request</span>
                                                            <span class="headline">
                                                                <a href="displayAllINSReq?mode=INT"><span class="num" style="color:red; font-weight:bold;">${IntReq}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-sm-2">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-sliders  black-bg"></i>
                                                            <span class="headline">Inspection Request</span>
                                                            <span class="headline">
                                                                <a href="breakDownMNT?mode=INS"><span class="num" style="color:red; font-weight:bold;">${InsReq}</span></span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-sm-2">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline">Maintenance Request</span>
                                                            <span class="headline">
                                                                <a href="breakDownMNT?mode=MNT"><span class="num" style="color:red; font-weight:bold;">${MntReq}</span></span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                             <div class="col-sm-2">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square-o  yellow-bg"></i>
                                                            <span class="headline">Gantry Approval</span>
                                                            <span class="headline">
                                                                <a href="displayAllGantry"><span class="num" style="color:red; font-weight:bold;">${countGantry}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            <div class="col-sm-2">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-hand-o-right  green-bg"></i>
                                                            <span class="headline">Feeder Approval</span>
                                                            <span class="headline">
                                                                <a href="displayAllFeeder"><span class="num" style="color:red; font-weight:bold;">${countFeeder}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                           
                                           <div class="col-sm-2">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square-o  yellow-bg"></i>
                                                            <span class="headline">Switch Approval</span>
                                                            <span class="headline">
                                                                <a href="displayAllSwitch"><span class="num" style="color:red; font-weight:bold;">${countSwitch}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                           
                                            
                                            <!-- <div class="col-sm-2">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  green-bg"></i>
                                                            <span class="headline">Estimate Approval</span>
                                                            <span class="headline">
                                                                <a href="estimateApproval">Approval</a>
                                                            </span>
                                                    </div>
                                            </div>
                                             -->   
                                        </div>
                                        
                                </div>

                            </div>
                            </c:if>
                            
                            
                            <c:if
													test="${sessionScope.loggedUserRole =='ES'}">
													
										<div class="row">
                            <div class="col-lg-12">                                                                                                   
                                        <div class="row">                                           
                                            <div class="col-sm-2">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square-o  yellow-bg"></i>
                                                            <span class="headline">Interruption Request</span>
                                                            <span class="headline">
                                                                <a href="displayAllINSReq?mode=INT">Create</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-sm-2">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-sliders  black-bg"></i>
                                                            <span class="headline">Inspection Request</span>
                                                            <span class="headline">
                                                                <a href="breakDownMNT?mode=INS"><span class="num" style="color:red; font-weight:bold;">${InsReq}</span></span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-sm-2">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline">Maintenance Request</span>
                                                            <span class="headline">
                                                                <a href="breakDownMNT?mode=MNT"><span class="num" style="color:red; font-weight:bold;">${MntReq}</span></span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                             <div class="col-sm-2">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square-o  yellow-bg"></i>
                                                            <span class="headline">Gantry Approval</span>
                                                            <span class="headline">
                                                                <a href="displayAllGantry"><span class="num" style="color:red; font-weight:bold;">${countGantry}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            <div class="col-sm-2">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-hand-o-right  green-bg"></i>
                                                            <span class="headline">Feeder Approval</span>
                                                            <span class="headline">
                                                                <a href="displayAllFeeder"><span class="num" style="color:red; font-weight:bold;">${countFeeder}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                           
                                           <div class="col-sm-2">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square-o  yellow-bg"></i>
                                                            <span class="headline">Switch Approval</span>
                                                            <span class="headline">
                                                                <a href="displayAllSwitch"><span class="num" style="color:red; font-weight:bold;">${countSwitch}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                           
                                               
                                        </div>
                                        
                                </div>

                            </div>
                            </c:if>
                            
                            
                             <c:if
													test="${sessionScope.loggedUserRole =='DEO'}">
													
										<div class="row">
                            <div class="col-lg-12">                                                                                                   
                                        <div class="row">                                           
                                            
                                             <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square-o  yellow-bg"></i>
                                                            <span class="headline">Gantry Validation</span>
                                                            <span class="headline">
                                                                <a href="displayAllGantry"><span class="num" style="color:red; font-weight:bold;">${countGantry}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-hand-o-right  green-bg"></i>
                                                            <span class="headline">Feeder Validation</span>
                                                            <span class="headline">
                                                                <a href="displayAllFeeder"><span class="num" style="color:red; font-weight:bold;">${countFeeder}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                           
                                           <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square-o  yellow-bg"></i>
                                                            <span class="headline">Switch Validation</span>
                                                            <span class="headline">
                                                                <a href="displayAllSwitch"><span class="num" style="color:red; font-weight:bold;">${countSwitch}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                           
                                               
                                        </div>
                                        
                                </div>

                            </div>
                            </c:if>
                            
                            
   
                          <br>  
                            

					<div class="container">

						<div class="jumbotron">

							<div class="row ">


<!-- <div class="col-sm-12" align="left">
									<div class="row">
									
									

										<input id ='showBtn' type='button' class='btn btn-success' value='Show Options' onClick='myFunction()'></input>

									</div>
								</div>
 -->

								<div id ="test" class="col-sm-12" align="left">
									<div class="row">
										<form:form method="post" action="viewSupportByProvince"
											modelAttribute="model">

											<div class="col-lg-12">

												<div class="row">
													<div class="drop-down-padding">
														<div class="col-xs-12" align="right">
															<form:select id="province" path="glcompmobj.compId"
																onchange="findArea()"
																style="width:100%; background-color: #FFFFFF; border-radius: 5px;">
																<form:option value="NONE" label="PROVINCE" />
																<form:options items="${model.provinceList}" />
															</form:select>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="drop-down-padding">
														<div class="col-xs-12" align="right">
															<form:select id="area" path="gldeptobj.deptId"
																onchange="getLine();getGantryByAreaLine()"
																style="width:100%; background-color: #FFFFFF; border-radius: 5px;">
																<form:option value="NONE" label="AREA" />
																<form:options items="${model.areaList}" />
															</form:select>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="drop-down-padding">
														<div class="col-xs-12" align="right">
															<form:select multiple="true" id="line" path="line.code" onchange=""
																style="width:100%; background-color: #FFFFFF; overflow:scroll; border-radius: 5px;">
																<form:option value="NONE" label="LINE" selected="selected"/>
																 <form:options items="${model.lineList}" />
															</form:select>
														</div>
													</div>
												</div>
												
												<div class="row">
										          <div class="drop-down-padding">
														<div class="col-xs-12" align="right">
															<form:select multiple="true" id="gantry" path="" onchange="getFeederByGantryId()"
																style="width:100%; background-color: #FFFFFF; overflow:scroll; border-radius: 5px;">
																<form:option value="NONE" label="GANTRY" />
																 
															</form:select>
														</div>
													</div>
												</div>
												<div class="row">
										          <div class="drop-down-padding">
														<div class="col-xs-12" align="right">
															<form:select multiple="true" id="feeder" path="feeder.id.feederId" onchange=""
																style="width:100%; background-color: #FFFFFF; overflow:scroll; border-radius: 5px;">
																<form:option value="NONE" label="FEEDER" />
																
															</form:select>
														</div>
													</div>
												</div>
												
												

												<div class="row">
													<div class="drop-down-padding">
														<div class="col-xs-12" align="right">
															<form:select id="mode" path="" onchange=""
																style="width:100%; background-color: #FFFFFF; border-radius: 5px;">
																<%-- <form:option value="MAP" label="MAP VIEW" />
																<form:option value="GANTRY" label="GANTRY VIEW" />
																
																 <form:option value="GANTRY" label="GANTRY VIEW" />
																 --%>
																 <form:option value="GANTRY" label="GANTRY VIEW" />
																 
																 <form:option value="MAP2" label="MAP VIEW" />
																<form:option value="NETWORK" label="NETWORK VIEW" />
															</form:select>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="drop-down-padding">
														<div align="right" style="padding-right: 10px">
															<button type='button' class='btn btn-success'
																onClick='viewMapByMode()'>View</button>
														</div>
													</div>
												</div>
												
												
												<%-- <c:if
													test="${sessionScope.loggedUserRole =='ES' || sessionScope.loggedUserRole =='DEO' || sessionScope.loggedUserRole ==''}">
													<div align="right" class="dropdown" style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<form:button type ="button" class="btn btn-success" style="width:100%; border-radius: 5px;">Send for Validation(<span class="num" style="color:red; font-weight:bold;">${countAll}</span>)</form:button>
														<div class="dropdown-content">
														
															<c:if test="${countGantry =='0'}"><a href="displayAllGantry">Send Gantry For Validation</a></c:if>
															<c:if test="${countGantry !='0'}"><a href="displayAllGantry">Send Gantry For Validation (<span class="num" style="color:red; font-weight:bold;">${countGantry}</span>)</a></c:if>
															
															<c:if test="${countFeeder =='0'}"><a href="displayAllFeeder">Send Feeders For Validation</a></c:if>
															<c:if test="${countFeeder !='0'}"><a href="displayAllFeeder">Send Feeders For Validation (<span class="num" style="color:red; font-weight:bold;">${countFeeder}</span>)</a></c:if>
															
															<c:if test="${countSwitch =='0'}"><a href="displayAllSwitch">Send Switch For Validation</a></c:if>
															<c:if test="${countSwitch !='0'}"><a href="displayAllSwitch">Send Switch For Validation (<span class="num" style="color:red; font-weight:bold;">${countSwitch}</span>)</a> </c:if>
															
															
															
															
															
															
														</div>
													</div>
													</c:if>
												 --%>	<br>
													<%-- <c:if
													test="${sessionScope.loggedUserRole =='EE' || sessionScope.loggedUserRole =='CE' || sessionScope.loggedUserRole =='DGM' || sessionScope.loggedUserRole =='AGM'}">
													<div align="right" class="dropdown" style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<form:button type ="button" class="btn btn-success" style="width:100%; border-radius: 5px;">Approve(<span class="num" style="color:red; font-weight:bold;">${countAll}</span>)</form:button>
														<div class="dropdown-content">
														
															<c:if test="${countGantry =='0'}"><a href="displayAllGantry">Approve Gantry </a></c:if>
															<c:if test="${countGantry !='0'}"><a href="displayAllGantry">Approve Gantry (<span class="num" style="color:red; font-weight:bold;">${countGantry}</span>)</a></c:if>
															
															<c:if test="${countFeeder =='0'}"><a href="displayAllFeeder">Approve Feeders</a></c:if>
															<c:if test="${countFeeder !='0'}"><a href="displayAllFeeder">Approve Feeders(<span class="num" style="color:red; font-weight:bold;">${countFeeder}</span>)</a></c:if>
															
															<c:if test="${countSwitch =='0'}"><a href="displayAllSwitch">Approve Switch</a></c:if>
															<c:if test="${countSwitch !='0'}"><a href="displayAllSwitch">Approve Switch(<span class="num" style="color:red; font-weight:bold;">${countSwitch}</span>)</a> </c:if>
															
															<c:if test="${countEstApprove =='0'}"><a href="estimateApproval">Estimate Approve</a></c:if>
															<c:if test="${countEstApprove !='0'}"><a href="estimateApproval">Estimate Approve (<span class="num" style="color:red; font-weight:bold;">${countEstApprove}</span>)</a></c:if>
															
															<c:if test="${countStdEstApprove =='0'}"><a href="estimateStdApproval">Commercial/Planning Approve</a></c:if>
															<c:if test="${countStdEstApprove !='0'}"><a href="estimateStdApproval">Commercial/Planning Approve (<span class="num" style="color:red; font-weight:bold;">${countStdEstApprove}</span>)</a></c:if>
															
															<c:if test="${countJobApprove =='0'}"><a href="displayAllMnt">Job Revise Approve</a></c:if>
															<c:if test="${countJobApprove !='0'}"><a href="displayAllMnt">Job Revise Approve (<span class="num" style="color:red; font-weight:bold;">${countJobApprove}</span>)</a> </c:if>
															
															
															<c:if test="${countPSApprove =='0'}"><a href="estimatePSApproval">PaySlip Approve</a></c:if>
															<c:if test="${countPSApprove !='0'}"><a href="estimatePSApproval">PaySlip Approve (<span class="num" style="color:red; font-weight:bold;">${countPSApprove}</span>)</a> </c:if>
															
															<c:if test="${countIVApprove =='0'}"><a href="estimateIVApproval">Inventory Approve</a></c:if>
															<c:if test="${countIVApprove !='0'}"><a href="estimateIVApproval">Inventory Approve (<span class="num" style="color:red; font-weight:bold;">${countIVApprove}</span>)</a> </c:if>
															
															<c:if test="${countRQApprove =='0'}"><a href="estimateRQApproval">Requisitions Approve</a></c:if>
															<c:if test="${countRQApprove !='0'}"><a href="estimateRQApproval">Requisitions Approve (<span class="num" style="color:red; font-weight:bold;">${countRQApprove}</span>)</a> </c:if>
															
															
															
														</div>
													</div>
													</c:if>
												 --%>
												
												
												<%-- <c:if
													test="${sessionScope.loggedUserRole =='EE' || sessionScope.loggedUserRole =='CE' || sessionScope.loggedUserRole =='AGM'}">
													<div class="dropdown "
														style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<button class="dropbtn" style=" height: 40px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px;background-color: #F1948A; border-radius: 5px;">Approve(<span class="num" style="color:red; font-weight:bold;">${countAll}</span>)</button>
														<div class="dropdown-content">
														
															<c:if test="${countLine =='0'}"><a href="displayAllLines">Approve Lines</a></c:if>
															<c:if test="${countLine !='0'}"><a href="displayAllLines">Approve Lines (<span class="num" style="color:red; font-weight:bold;">${countLine}</span>)</a></c:if>
															
															<c:if test="${countSupport =='0'}"><a href="displayAllSupports">Approve Supports</a></c:if>
															<c:if test="${countSupport !='0'}"><a href="displayAllSupports">Approve Supports (<span class="num" style="color:red; font-weight:bold;">${countSupport}</span>)</a></c:if>
															
															<c:if test="${countMnt =='0'}"><a href="displayAllMnt">Approve Mnt</a></c:if>
															<c:if test="${countMnt !='0'}"><a href="displayAllMnt">Approve Mnt (<span class="num" style="color:red; font-weight:bold;">${countMnt}</span>)</a> </c:if>
															
															<c:if test="${unReadEmail =='0'}"><a href="displayAllUnReadMsg">UnRead Way Leave Status</a></c:if>
															<c:if test="${unReadEmail !='0'}"><a href="displayAllUnReadMsg">UnRead Way Leave Status (<span class="num" style="color:red; font-weight:bold;">${unReadEmail}</span>)</a> </c:if>
															
															
															
															
															
														</div>
													</div>
													<!-- <div class="row">
													<div class="dropdown "
														style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<div class="dropdown-content">
														</div>
													</div>
													</div>
													<div class="row">
													<div class="dropdown "
														style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<div class="dropdown-content">
														</div>
													</div>
													</div>
													 -->
													
													
													<div class="dropdown "
														style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<button class="dropbtn" style=" height: 40px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px;background-color: #F1948A; border-radius: 5px;">Status(<span class="num" style="color:red; font-weight:bold;">${countAllReq}</span>)</button>
														<div class="dropdown-content">
														
															
															<c:if test="${unReadEmail =='0'}"><a href="displayAllUnReadMsg">UnRead Way Leave Status</a></c:if>
															<c:if test="${unReadEmail !='0'}"><a href="displayAllUnReadMsg">UnRead Way Leave Status (<span class="num" style="color:red; font-weight:bold;">${unReadEmail}</span>)</a> </c:if>
															
															<c:if test="${InsReq =='0'}"><a href="displayAllINSReq">Inspection Request</a></c:if>
															<c:if test="${InsReq !='0'}"><a href="displayAllINSReq">Inspection Request (<span class="num" style="color:red; font-weight:bold;">${InsReq}</span>)</a> </c:if>
															
															<c:if test="${MntReq =='0'}"><a href="displayAllMNTReq">Maintenance Request</a></c:if>
															<c:if test="${MntReq !='0'}"><a href="displayAllMNTReq">Maintenance Request (<span class="num" style="color:red; font-weight:bold;">${MntReq}</span>)</a> </c:if>
															
															
															
														</div>
													</div>
												</c:if>
												<c:if test="${sessionScope.loggedUserRole =='ES'}">
													<div class="dropdown "
														style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<button class="dropbtn" style=" height: 40px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px;background-color: #F1948A; border-radius: 5px;">Validation</button>
														<div class="dropdown-content">
														
															<c:if test="${countLine =='0'}"><a href="displayAllLines">Send Lines For Approval</a></c:if>
															<c:if test="${countLine !='0'}"><a href="displayAllLines">Send Lines For Approval (<span class="num" style="color:red; font-weight:bold;">${countLine}</span>)</a></c:if>
															
															<c:if test="${countSupport =='0'}"><a href="displayAllSupports">Send Supports For Approval</a></c:if>
															<c:if test="${countSupport !='0'}"><a href="displayAllSupports">Send Supports For Approval (<span class="num" style="color:red; font-weight:bold;">${countSupport}</span>)</a></c:if>
															
															<c:if test="${countMnt =='0'}"><a href="displayAllMnt">Send Mnt For Approval</a></c:if>
															<c:if test="${countMnt !='0'}"><a href="displayAllMnt">Send Mnt For Approval (<span class="num" style="color:red; font-weight:bold;">${countMnt}</span>)</a> </c:if>
															
														</div>
													</div>
												</c:if>
												<c:if test="${sessionScope.loggedUserRole =='DEO'}">
													<div class="dropdown "
														style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<button class="dropbtn" style=" height: 40px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px;background-color: #F1948A; border-radius: 5px;">Validation</button>
														<div class="dropdown-content">
														
															<c:if test="${countLine =='0'}"><a href="displayAllLines">Send Lines For Validation</a></c:if>
															<c:if test="${countLine !='0'}"><a href="displayAllLines">Send Lines For Validation (<span class="num" style="color:red; font-weight:bold;">${countLine}</span>)</a></c:if>
															
															<c:if test="${countSupport =='0'}"><a href="displayAllSupports">Send Supports For Validation</a></c:if>
															<c:if test="${countSupport !='0'}"><a href="displayAllSupports">Send Supports For Validation (<span class="num" style="color:red; font-weight:bold;">${countSupport}</span>)</a></c:if>
															
															<c:if test="${countMnt =='0'}"><a href="displayAllMnt">Send Mnt For Validation</a></c:if>
															<c:if test="${countMnt !='0'}"><a href="displayAllMnt">Send Mnt For Validation (<span class="num" style="color:red; font-weight:bold;">${countMnt}</span>)</a> </c:if>
															
														</div>
													</div>
												</c:if>
												<br><br>
												<c:if
													test="${sessionScope.loggedUserRole =='EE' || sessionScope.loggedUserRole =='CE' || sessionScope.loggedUserRole =='AGM'}">
													<div class="dropdown "
														style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<button class="dropbtn" style=" height: 40px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px;background-color: #F1948A; border-radius: 5px;">Status(<span class="num" style="color:red; font-weight:bold;">${countAllReq}</span>)</button>
														<div class="dropdown-content">
														
															
															<c:if test="${unReadEmail =='0'}"><a href="displayAllUnReadMsg">UnRead Way Leave Status</a></c:if>
															<c:if test="${unReadEmail !='0'}"><a href="displayAllUnReadMsg">UnRead Way Leave Status (<span class="num" style="color:red; font-weight:bold;">${unReadEmail}</span>)</a> </c:if>
															
															<c:if test="${InsReq =='0'}"><a href="displayAllINSReq">Inspection Request</a></c:if>
															<c:if test="${InsReq !='0'}"><a href="displayAllINSReq">Inspection Request (<span class="num" style="color:red; font-weight:bold;">${InsReq}</span>)</a> </c:if>
															
															<c:if test="${MntReq =='0'}"><a href="displayAllMNTReq">Maintenance Request</a></c:if>
															<c:if test="${MntReq !='0'}"><a href="displayAllMNTReq">Maintenance Request (<span class="num" style="color:red; font-weight:bold;">${MntReq}</span>)</a> </c:if>
															
															
															
														</div>
													</div>
												</c:if>
											 --%>	
											</tr>
											
												
												
												
												
												
												
												
												

											</div>
											
											
										</form:form>
																<!-- edited anushka 2019-01-11 -------------------------------------------------------------- -->
										<%-- <table>
											<tr>
												<c:if
													test="${sessionScope.loggedUserRole =='EE' || sessionScope.loggedUserRole =='CE' || sessionScope.loggedUserRole =='AGM'}">
													<div class="dropdown "
														style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<button class="dropbtn" style=" height: 40px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px;background-color: #F1948A; border-radius: 5px;">Approve(<span class="num" style="color:red; font-weight:bold;">${countAll}</span>)</button>
														<div class="dropdown-content">
														
															<c:if test="${countLine =='0'}"><a href="displayAllLines">Approve Lines</a></c:if>
															<c:if test="${countLine !='0'}"><a href="displayAllLines">Approve Lines (<span class="num" style="color:red; font-weight:bold;">${countLine}</span>)</a></c:if>
															
															<c:if test="${countSupport =='0'}"><a href="displayAllSupports">Approve Supports</a></c:if>
															<c:if test="${countSupport !='0'}"><a href="displayAllSupports">Approve Supports (<span class="num" style="color:red; font-weight:bold;">${countSupport}</span>)</a></c:if>
															
															<c:if test="${countMnt =='0'}"><a href="displayAllMnt">Approve Mnt</a></c:if>
															<c:if test="${countMnt !='0'}"><a href="displayAllMnt">Approve Mnt (<span class="num" style="color:red; font-weight:bold;">${countMnt}</span>)</a> </c:if>
															
															<c:if test="${unReadEmail =='0'}"><a href="displayAllUnReadMsg">UnRead Way Leave Status</a></c:if>
															<c:if test="${unReadEmail !='0'}"><a href="displayAllUnReadMsg">UnRead Way Leave Status (<span class="num" style="color:red; font-weight:bold;">${unReadEmail}</span>)</a> </c:if>
															
															
															
															
															
														</div>
													</div>
													<!-- <div class="row">
													<div class="dropdown "
														style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<div class="dropdown-content">
														</div>
													</div>
													</div>
													<div class="row">
													<div class="dropdown "
														style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<div class="dropdown-content">
														</div>
													</div>
													</div>
													 -->
													
													
													<div class="dropdown "
														style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<button class="dropbtn" style=" height: 40px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px;background-color: #F1948A; border-radius: 5px;">Status(<span class="num" style="color:red; font-weight:bold;">${countAllReq}</span>)</button>
														<div class="dropdown-content">
														
															
															<c:if test="${unReadEmail =='0'}"><a href="displayAllUnReadMsg">UnRead Way Leave Status</a></c:if>
															<c:if test="${unReadEmail !='0'}"><a href="displayAllUnReadMsg">UnRead Way Leave Status (<span class="num" style="color:red; font-weight:bold;">${unReadEmail}</span>)</a> </c:if>
															
															<c:if test="${InsReq =='0'}"><a href="displayAllINSReq">Inspection Request</a></c:if>
															<c:if test="${InsReq !='0'}"><a href="displayAllINSReq">Inspection Request (<span class="num" style="color:red; font-weight:bold;">${InsReq}</span>)</a> </c:if>
															
															<c:if test="${MntReq =='0'}"><a href="displayAllMNTReq">Maintenance Request</a></c:if>
															<c:if test="${MntReq !='0'}"><a href="displayAllMNTReq">Maintenance Request (<span class="num" style="color:red; font-weight:bold;">${MntReq}</span>)</a> </c:if>
															
															
															
														</div>
													</div>
												</c:if>
												<c:if test="${sessionScope.loggedUserRole =='ES'}">
													<div class="dropdown "
														style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<button class="dropbtn" style=" height: 40px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px;background-color: #F1948A; border-radius: 5px;">Validation</button>
														<div class="dropdown-content">
														
															<c:if test="${countLine =='0'}"><a href="displayAllLines">Send Lines For Approval</a></c:if>
															<c:if test="${countLine !='0'}"><a href="displayAllLines">Send Lines For Approval (<span class="num" style="color:red; font-weight:bold;">${countLine}</span>)</a></c:if>
															
															<c:if test="${countSupport =='0'}"><a href="displayAllSupports">Send Supports For Approval</a></c:if>
															<c:if test="${countSupport !='0'}"><a href="displayAllSupports">Send Supports For Approval (<span class="num" style="color:red; font-weight:bold;">${countSupport}</span>)</a></c:if>
															
															<c:if test="${countMnt =='0'}"><a href="displayAllMnt">Send Mnt For Approval</a></c:if>
															<c:if test="${countMnt !='0'}"><a href="displayAllMnt">Send Mnt For Approval (<span class="num" style="color:red; font-weight:bold;">${countMnt}</span>)</a> </c:if>
															
														</div>
													</div>
												</c:if>
												<c:if test="${sessionScope.loggedUserRole =='DEO'}">
													<div class="dropdown "
														style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<button class="dropbtn" style=" height: 40px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px;background-color: #F1948A; border-radius: 5px;">Validation</button>
														<div class="dropdown-content">
														
															<c:if test="${countLine =='0'}"><a href="displayAllLines">Send Lines For Validation</a></c:if>
															<c:if test="${countLine !='0'}"><a href="displayAllLines">Send Lines For Validation (<span class="num" style="color:red; font-weight:bold;">${countLine}</span>)</a></c:if>
															
															<c:if test="${countSupport =='0'}"><a href="displayAllSupports">Send Supports For Validation</a></c:if>
															<c:if test="${countSupport !='0'}"><a href="displayAllSupports">Send Supports For Validation (<span class="num" style="color:red; font-weight:bold;">${countSupport}</span>)</a></c:if>
															
															<c:if test="${countMnt =='0'}"><a href="displayAllMnt">Send Mnt For Validation</a></c:if>
															<c:if test="${countMnt !='0'}"><a href="displayAllMnt">Send Mnt For Validation (<span class="num" style="color:red; font-weight:bold;">${countMnt}</span>)</a> </c:if>
															
														</div>
													</div>
												</c:if>
											
											</tr>
											<tr>
											</tr>
											<tr>
											</tr>
											<tr>
												<c:if
													test="${sessionScope.loggedUserRole =='EE' || sessionScope.loggedUserRole =='CE' || sessionScope.loggedUserRole =='AGM'}">
													<div class="dropdown "
														style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<button class="dropbtn" style=" height: 40px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px;background-color: #F1948A; border-radius: 5px;">Status(<span class="num" style="color:red; font-weight:bold;">${countAllReq}</span>)</button>
														<div class="dropdown-content">
														
															
															<c:if test="${unReadEmail =='0'}"><a href="displayAllUnReadMsg">UnRead Way Leave Status</a></c:if>
															<c:if test="${unReadEmail !='0'}"><a href="displayAllUnReadMsg">UnRead Way Leave Status (<span class="num" style="color:red; font-weight:bold;">${unReadEmail}</span>)</a> </c:if>
															
															<c:if test="${InsReq =='0'}"><a href="displayAllINSReq">Inspection Request</a></c:if>
															<c:if test="${InsReq !='0'}"><a href="displayAllINSReq">Inspection Request (<span class="num" style="color:red; font-weight:bold;">${InsReq}</span>)</a> </c:if>
															
															<c:if test="${MntReq =='0'}"><a href="displayAllMNTReq">Maintenance Request</a></c:if>
															<c:if test="${MntReq !='0'}"><a href="displayAllMNTReq">Maintenance Request (<span class="num" style="color:red; font-weight:bold;">${MntReq}</span>)</a> </c:if>
															
															
															
														</div>
													</div>
												</c:if>
												
											</tr>
											
											
										</table>
 --%>										<br><br>
										<!-- --------------------------------------------------------------------------------------------------------- -->

									</div>
								</div>
<br><br>
								<div class="col-sm-12" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
								</div>
								
								<div class="col-sm-12" align="left">

									<div class="row">

										<div id="map_container2"></div>

									</div>
								</div>
								
								
								<!-- <div class="col-sm-12" align="left">

									<div class="row">

										<div id="filter_div"></div>
      
									</div>
								</div>
 -->								<!-- <div class="col-sm-12" align="left">

									<div class="row">

										<div id="filter_div2"></div>
      
									</div>
								</div>
 -->								<!-- <div class="col-sm-12" align="left">

									<div class="row">

										<div id="filter_div3"></div>
      
									</div>
								</div>
								
 -->

<!-- <div class="col-sm-12" align="left">

									<div class="row">

										   <div id="dashboard_div">
      Divs that will hold each control and chart
      <div id="filter_div"></div>
      <div id="chart_div"></div>
    </div>
  
									</div>
								</div>
 -->
							</div>
						</div>
					</div>
 
 <br>
                             
                            
                            
                                                        <div class="container" align="left">


						<div class="row">
							<div class="col-lg-12">
							<div class="row">
								
								<div class="col-sm-6 col-xs-12">
								
					
					<div class="table-responsive" >
								<div class="wrimagecardNew1 wrimagecard-topimage">
										
								<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
													<div id="dashboard_div">
      												<div id="bar_div1"></div>
      												
																								</div>
												
										</div>	
											
										</div>
								
								</div>
	
					</div>
					
					<div class="col-sm-6 col-xs-12">
								
					
					<div class="table-responsive" >
								<div class="wrimagecardNew1 wrimagecard-topimage">
										
								<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
													<div id="dashboard_div">
      												<div id="pie_div1"></div>
      												
																								</div>
												
										</div>	
											
										</div>
								
								</div>
	
					</div>
	
					</div>
					</div>
					</div>
					</div>
                            
                         


					<div class="container">


						<div class="row">
							<div class="col-lg-12">

								<div class="row">
								
								<%-- 	<div class="col-lg-4 col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
												<center>
													<i class="fa fa-cubes" style="color: #008080"></i>
												</center>
												<h4>
													  						
															<strong>Divisional Information </strong>
																				
														
												</h4>
												<div style="height: 220px">
													<div id="dashboard_div">
      <!--Divs that will hold each control and chart-->
      <div id="filter_div"></div>
      <div id="chart_div"></div>

												</div>
												
											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div>
</div>
 --%>									<%-- <div class="col-lg-4 col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: rgba(0, 255, 0, 0.3); border-radius: 5px;">
												<center>
													<i class="fa fa-info-circle" style="color: #008080"></i>
												</center>
												<h4>
													<center>
															<strong>Asset Information</strong>
														</center>
												</h4>




												<div style="height: 220px">
													<h4>
														<strong> <br></strong>
													</h4>
													<table>
														<tr>

															<div class="dropdown " style="width: 100%; height: 50px;">
																<button class="dropbtn">View Line Master Data</button>
																<div class="dropdown-content">
																	<a href="viewLinetypes">View Line type</a> <a
																		href="viewSupporttypes">View Support type</a> <a
																		href="viewConTypes">View Conductor type</a> <a
																		href="viewEarthConTypes">View Earth type</a>
																	<a href="viewInsulators">View Insulator type</a> <a
																		href="viewTowerConfigs">View Tower Configuration</a> <a
																		href="viewTowerInsulators">View Tower Insulator></a>
																</div>
															</div>
														</tr>
														<br>
														<br>
														<tr>


															<div class="dropdown" style="width: 100%; height: 50px;">
																<button class="dropbtn">View Line & Support</button>
																<div class="dropdown-content">
																	<a href="viewLineNewOther">View Line</a> <a href="viewSupportNewOther">View
																		Support</a> 
																</div>
															</div>

														</tr>
														<br>
														<br>
														<tr>
															<div class="dropdown" style="width: 100%; height: 50px;">
																<button class="dropbtn">View Maintenance Data</button>
																<div class="dropdown-content">
																	<a href="viewTMnewApproveOther">Tower Maintenance</a> <a
																		href="#">Insulator Maintenance</a>
																</div>


															</div>

														</tr>
													</table>
												</div>





											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div>
 --%>
<%-- <div class="col-lg-4 col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
												<center>
													<i class="fa fa-window-restore" style="color: #008080"></i>
												</center>
												<h4>
													<center>
														<strong>Provincial Schedule</strong>
													</center>
												</h4>
												<div style="height: 220px">
													<h4>
														<strong><br></strong>
													</h4>

													<!-- edit anushka 2019-01-09 ------------------------------------------------------------- -->
													<tr>
														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">
																<a href="ViewProvincialScheduleOther?mode=EWOP">Electrical
																	Works on Poles</a>
															</button>

														</div>


													</tr>
													<br> <br>

													<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">
																<a href="ViewProvincialScheduleOther?mode=VR">Vegetation Schedule</a>
															</button>

														</div>

													</tr>
													<br> <br>
													<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">
																<a href="ViewProvincialScheduleOther?mode=MPL">Missing
																	Parts Schedule</a>
															</button>

														</div>

													</tr>
													<!-- --------------------------------------------------------------------------------- -->

												</div>




											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div>
									
 --%>									
									
									
									
									
<%-- 									<div class="col-lg-4 col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: rgba(0, 255, 0, 0.3); border-radius: 5px;">
												<center>
													<i class="fa fa-info-circle" style="color: #008080"></i>
												</center>
												<h4>
													<center>
															<strong>Approval</strong>
														</center>
												</h4>




												<div style="height: 220px">
													<h4>
														<strong> <br></strong>
													</h4>
													<table>
														<tr>

															<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">
																<a href="estimateApproval">Estimate Approval(<span class="num" style="color:red; font-weight:bold;">${countEstApprove}</span>)</a>
															</button>

														</div>

														</tr>
														<br>
														<br>
														<tr>


															<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">
																<a href="estimateStdApproval">Std. Estimate Approval(<span class="num" style="color:red; font-weight:bold;">${countStdEstApprove}</span>)</a>
															</button>

														</div>


														</tr>
														<br>
														<br>
														<tr>
															<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">
																<a href="estimateStdApproval">Job Approval</a>
															</button>

														</div>

														</tr>
													</table>
												</div>





											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div> --%>
									
									


<%-- <div class="col-lg-4 col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: rgba(0, 255, 0, 0.3); border-radius: 5px;">
												<center>
													<i class="fa fa-list-alt" style="color: #008080"></i>
												</center>
												<h4>
													<center>
															<strong>P&E Summary</strong>
														</center>
												</h4>
												
													<div style="height: 220px">
													<h4>
														<strong><br></strong>
													</h4>

													<tr>
													<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">Tower Lines</button>
															<div class="dropdown-content">
																<a href="ViewPESummaryReportOther?mode=PELT">Line Type</a> 
																<a href="ViewPESummaryReportOther?mode=PECONT">Conductor Type</a> 
																<a href="ViewPESummaryReportOther?mode=PECIRT">Circuit Type</a> 
																<a href="ViewPESummaryReportOther?mode=PECIRCONT">Circuit/Conductor Type</a> 
															
															</div>
														</div>
														
														
													</tr>
													<br> <br>
													
													<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn"><a href="#">Gantries</a></button>
															
														</div>


													</tr>
													<br> <br>
<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn"><a href="#">Switches</a></button>
															
														</div>

													</tr>
													

												</div>
												
												
											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div> --%>
									
<%-- 								<div class="col-lg-4 col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: rgba(0, 255, 0, 0.3); border-radius: 5px;">
												<center>
													<i class="fa fa-list-alt" style="color: #008080"></i>
												</center>
												<h4>
													<center>
															<strong>Reports</strong>
														</center>
												</h4>
												
													<div style="height: 220px">
													<h4>
														<strong><br></strong>
													</h4>

													<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn"><a href="estimateSPSReport">SPS Reports</a></button>
															
														</div>

													</tr>
													

												</div>
												
												
											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div> --%>	
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									<%-- <div class="col-lg-4 col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
												<center>
													<i class="fa fa-cubes" style="color: #008080"></i>
												</center>
												<h4>
													  						
															<strong>Estimate Approval Info</strong>
																				
														
												</h4>
												<div style="height: 220px">
													<div id="dashboard_div">
      <!--Divs that will hold each control and chart-->
      <div id="estapr_div"></div>

												</div>
												
											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div>
</div>

<div class="col-lg-4 col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
												<center>
													<i class="fa fa-cubes" style="color: #008080"></i>
												</center>
												<h4>
													  						
															<strong>Estimate Approval Info</strong>
																				
														
												</h4>
												<div style="height: 220px">
													<div id="dashboard_div">
      <!--Divs that will hold each control and chart-->
      <div id="estaprtable_div"></div>

												</div>
												
											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div>
</div>
 --%>								

								
									
									
									
									
									
									




<%-- <c:if test="${sessionScope.loggedUserRole =='ES' || sessionScope.loggedUserRole =='EE' || sessionScope.loggedUserRole =='CE' || sessionScope.loggedUserRole =='AGM'}">
													
									<div class="col-lg-4 col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: rgba(0, 255, 0, 0.3); border-radius: 5px;">
												<center>
													<i class="fa fa-user-plus" style="color: #008080"></i>
												</center>
												
												<h4>
													<center>
															<strong>Activity Request </strong>
														</center>
												</h4>
												
												<div style="height: 220px">
													<h4>
														<strong><br></strong>
													</h4>

													<tr>
													
														<div class="dropdown " style="width: 100%; height: 50px;">
															<button class="dropbtn">Inspection Request</button>
															<div class="dropdown-content">
																<a href="#">Area</a> 
																<a href="#">Line</a> 
																
															</div>
														</div>
														
													</tr>
													<br> <br>
													
													<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">Interuption Request</button>
															<div class="dropdown-content">
																<a href="goToInterruptionRequest?mode=INTERRUPTION&error=">Area</a> 
																<a href="#">Line</a> 
																
															</div>
														</div>

													</tr>
													<br> <br>

													<tr>
													
														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">PTW Request</button>
															<div class="dropdown-content">
																<a href="#">Area</a> 
																	<a href="#">Line</a>
															</div>
														</div>

													</tr>

												</div>
</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div>
								

									<div class="col-lg-4 col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
												<center>
													<i class="fa fa-window-restore" style="color: #008080"></i>
												</center>
												<h4>
													<center>
															<strong>Schedules and Reports</strong>
														</center>
												</h4>
													<div style="height: 220px">
													<h4>
														<strong><br></strong>
													</h4>

													<tr>
													<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">PHM Branch schedule</button>
															<div class="dropdown-content">
																<a href="ViewScheduleAndReport?mode=HOTLINE">Hot Line Maintenance</a> 
																<a href="ViewScheduleAndReport?mode=TTWT">Tension Tower without Tapping</a> 
																<a href="ViewScheduleAndReport?mode=CLE">Cold Line Electrical</a> 
																<a href="ViewScheduleAndReport?mode=CLC">Cold Line Civil</a> 
																<a href="ViewScheduleAndReport?mode=MW">Miscellaneous Works </a> 
																
															</div>
														</div>
														
														
													</tr>
													<br> <br>
													
													<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">Provincial Schedule</button>
															<div class="dropdown-content">
																<a href="ViewScheduleAndReport?mode=EWOP">Electrical Works on Poles</a> 
																<a href="ViewScheduleAndReport?mode=VR">Vegetation Schedule</a> 
																<a href="ViewScheduleAndReport?mode=MPL">Missing Parts Schedule</a>
															</div>
														</div>

													</tr>
													<br> <br>
<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">Reports</button>
															<div class="dropdown-content">
																<a href="ViewScheduleAndReport?mode=TP">Tapping Detail Report</a> 
																<a href="#">Inspection History Report</a> 
																
															</div>
														</div>

													</tr>
													

												</div>
												
												
												
												
											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div>

									<div class="col-lg-4 col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: rgba(0, 255, 0, 0.3); border-radius: 5px;">
												<center>
													<i class="fa fa-list-alt" style="color: #008080"></i>
												</center>
												<h4>
													<center>
															<strong>P&E Summary</strong>
														</center>
												</h4>
												
													<div style="height: 220px">
													<h4>
														<strong><br></strong>
													</h4>

													<tr>
													<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">Tower Lines</button>
															<div class="dropdown-content">
																<a href="ViewPESummaryReport?mode=PELT">Line Type</a> 
																<a href="ViewPESummaryReport?mode=PECONT">Conductor Type</a> 
																<a href="ViewPESummaryReport?mode=PECIRT">Circuit Type</a> 
																
															</div>
														</div>
														
														
													</tr>
													<br> <br>
													
													<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn"><a href="#">Gantries</a></button>
															
														</div>

													</tr>
													<br> <br>
<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn"><a href="#">Switches</a></button>
															
														</div>

													</tr>
													

												</div>
												
												
											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div>
	</c:if>
 --%>								</div>
							</div>
						</div>
					</div>



				</div>
			</div>
		</div>
	</div>
	<%@ include file="sections/footer.jsp"%>
	<%@ include file="sections/global_scripts.jsp"%>
	
	<div class="modal fade" id="basicModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h4 class="modal-title" id="myModalLabel">View Tower Maintenance Data</h4>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">×</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <h6><b>Visit ID</b> : 002</h6>
		        <h6><b>Tower ID</b> : 002A</h6>
		        <h6><b>Dept ID</b> : 501.00</h6>
		        <h6><b>Tappings</b> : 04</h6>
		        <h6><b>Missing Parts</b> : 06</h6>
		        <h6><b>Flash Over Sets</b> : 04</h6>
		        <h6><b>Way leaving Status</b> : Good</h6>
		        <h6><b>Base Concrete Status</b> : Bad</h6>
		        <h6><b>Anti Climbing Status</b> : Lost</h6>
		        <h6><b>Conductor Condition</b> : Danger</h6>
		        <h6><b>Jumper Condition</b> : Good</h6>
		        <h6><b>Earth Conductor Condition</b> : Damage</h6>
		        <h6><b>Maintenance Attention</b> : Urgent</h6>
		        <h6><b>Funguss Set No</b> : 07</h6>
		        <h6><b>WPIN set</b> : 02</h6>
		        <h6><b>End Fitting set</b> : 08</h6>
		        <h6><b>Special Observations</b> : No Observations</h6>
		        <h6><b>LUTD</b> : 2018-03-06T09:23</h6>
		        <h6><b>Maintenance Date</b> : 2018-03-06</h6>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
		

	<div class="modal fade" id="myModalGantry" tabindex="-1" role="dialog" aria-labelledby="myModalGantry" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h4 class="modal-title" id="myModalGantryLabel">View Gantry Data</h4>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">×</span>
		        </button>
		      </div>
		       <div class="modal-content">
                                <label>Gantry Details</label><br>
                                <p1>Gantry Name:<label id="gantryname">gantryname</label></p1><br>
                                <p1>Gantry Code:<label id="gantrycode">gantrycode</label></p1><br>
                                <p1>Short circuit current capacity(kA):<label id="short_circuit">short_circuit</label></p1><br>
                                <p1>Earth fault current capacity(kA) :<label id="earth_fault">earth_fault</label></p1><br>
                                <p1>Date of Commissing:<label id="DateofCommissing">DateofCommissing</label></p1><br>
                                <p1>Gantry Type:<label id="Gantry_Type">Gantry_Type</label></p1><br>
                                <p1>Gantry Electrcial Type:<label id="Gantry_Electrcial_Type">Gantry_Electrcial_Type</label></p1><br>
                                <p1>No of Bus bars:<label id="No_of_Bus_bars">No_of_Bus_bars</label></p1><br>
                                <p1>No of Bus sections:<label id="No_of_Bus_sections">No_of_Bus_sections</label></p1><br>
                                <p1>No of In bays:<label id="No_of_In_bays">No_of_In_bays</label></p1><br>
                                <p1>No of Out bays:<label id="No_of_Out_bays">No_of_Out_bays</label></p1><br>
                                <p1>Total Land Area:<label id="Total_Land_Area">Total_Land_Area</label></p1><br>
                                <p1>No Of AutoRecloser:<label id="No_Of_AutoRecloser">No_Of_AutoRecloser</label></p1><br>
                                <p1>No Of LBS:<label id="No_Of_LBS">No_Of_LBS</label></p1><br>
                                <p1>No Of ABS:<label id="No_Of_ABS">No_Of_ABS</label></p1><br>
                                <p1>No Of Surge Arrestors:<label id="No_Of_Surge_Arrestors">No_Of_Surge_Arrestors</label></p1><br>
                                <p1>No Of DDLO Links:<label id="No_Of_DDLO_Links">No_Of_DDLO_Links</label></p1><br>
                                <p1>No Of DDLO fuses:<label id="No_Of_DDLO_fuses">No_Of_DDLO_fuses</label></p1><br>
                                <p1>No Of Incoming Feeders:<label id="No_Of_Incoming_Feeders">No_Of_Incoming_Feeders</label></p1><br>
                                <p1>No Of Outgoing Feeders:<label id="No_Of_Outgoing_Feeders">No_Of_Outgoing_Feeders</label></p1><br>
                                <p1>GPS Latitude:<label id="GPS_Latitude">GPS_Latitude</label></p1><br>
                                <p1>GPS Longitude:<label id="GPS_Longitude">GPS_Longitude</label></p1><br>
                                
                             </div>

		      <div class="modal-footer">
		        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>
	
	
</body>
</html>