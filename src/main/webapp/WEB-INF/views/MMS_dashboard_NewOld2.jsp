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


div#map {
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

.google-visualization-table-td {
text-align: center !important;
}

.container{
	max-width: 100%;
	overflow-x: hidden;
	
    
}


/* Style the dropdown content (hidden by default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

/* Style the links inside the dropdown */
.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

/* Add a dark background on topnav links and the dropdown button on hover */
.topnav a:hover, .dropdown:hover .dropbtn {
  background-color: #555;
  color: white;
}

/* Add a grey background to dropdown links on hover */
.dropdown-content a:hover {
  background-color: #ddd;
  color: black;
}

/* Show the dropdown menu when the user moves the mouse over the dropdown button */
.dropdown:hover .dropdown-content {
  display: block;
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

/* .container2 {
  margin: 0;
  max-width: 1920px;
  width: 100%;
}
 */


.map-container-3{
overflow:hidden;
padding-bottom:56.25%;
position:relative;
height:0;
}
.map-container-3 iframe{
left:0;
top:0;
height:100%;
width:100%;
position:absolute;
}

.infographic-box .headline {
  display: block;
  font-size: 0.8em;
  font-weight: 300;
  text-align: right;
}

   
/* html, body {
    max-width: 100%;
    }
 */ 


</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
//Load the Visualization API and the piechart package.
//google.charts.load('current', {'packages':['corechart']});
//google.charts.setOnLoadCallback(drawChart);
google.charts.load('current', {'packages':['corechart', 'controls']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawDashboard);


//google.load('visualization', '1.0', {
//    'packages' : [ 'corechart' ]
//});
//google.charts.load('current', {'packages':['gantt']});
// Set a callback to run when the Google Visualization API is loaded.
//google.setOnLoadCallback(drawChart);
//google.charts.setOnLoadCallback(drawChart);
// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.



function drawDashboard() {
    	  
	var strArea = area.options[area.selectedIndex].value;
	var strLine = 'NONE';
	var strProvince = province.options[province.selectedIndex].value;
	var strDiv='NONEA'
    	  
    	  /* $.ajax({
  			type : 'GET',
  			url : "/MMS/lineSummary/" + strProvince +"/" + strArea + "/" +strLine,
  			data : {},
  			contentType : "application/json; charset=utf-8",
  			success : function(result) {
  				
  				var datavaluefortable = new google.visualization.DataTable();
				datavaluefortable.addColumn('string', 'Province');
				
				datavaluefortable.addColumn('number', 'No. Lines');
				datavaluefortable.addColumn('number', 'Line Length(km)');
				datavaluefortable.addColumn('number', 'Total Towers');
				datavaluefortable.addColumn('number', 'Total Poles');
				
				
				for (var i = 0; i < result.length; i++) {
						var data = result[i];
						datavaluefortable.addRows([[data[4],data[0], data[1], data[2], data[3]]]);
				}
				
				/* if(strProvince==='PROVINCE'){
					alert('hoo');
				}
				 */
			/*	var datavalueforbar = new google.visualization.DataTable();
				datavalueforbar.addColumn('string', 'Province');
				
				//datavalueforbar.addColumn('number', 'No. Lines');
				//datavalueforbar.addColumn('number', 'Line Length(km)');
				datavalueforbar.addColumn('number', 'Total Towers');
				datavalueforbar.addColumn('number', 'Total Poles');
				
				
				for (var i = 0; i < result.length; i++) {
						var data = result[i];
						datavalueforbar.addRows([[data[4],data[2], data[3]]]);
				}
				
				
  				var datavalue = new google.visualization.DataTable();
  				datavalue.addColumn('string', 'Province');
  				datavalue.addColumn('number', 'No. Lines');
  				
  				for (var i = 0; i < result.length; i++) {
  						var data = result[i];
  						datavalue.addRows([[data[4], data[0]]]);
  				}
  				
  				 
  			     // Create a dashboard.
  		        var dashboard = new google.visualization.Dashboard(
  		            document.getElementById('dashboard_div'));
  			     
  		        var dashboardtable = new google.visualization.Dashboard(
    		            document.getElementById('dashboard_div2'));

  		        var dashboardbar = new google.visualization.Dashboard(
    		            document.getElementById('dashboard_div1'));

  		    

  		        // Create a range slider, passing some options
  		        var donutRangeSlider = new google.visualization.ControlWrapper({
  		          'controlType': 'CategoryFilter',
  		          'containerId': 'filter_div',
  		          'options': {
  		        	'filterColumnLabel': 'Province'
  		          }
  		        });
 */  		        

  		        // Create a pie chart, passing some options
  		        /* var pieChart = new google.visualization.ChartWrapper({
  		          'chartType': 'PieChart',
  		          'containerId': 'chart_div',
  		          'options': {
  		            'width': 230,
  		            'height': 210,
  		            'is3D' : true,
  		            'pieSliceText': 'value',
  		            'legend': 'right'
  		          }
  		        });
  		         */
  		     /*  var table = new google.visualization.ChartWrapper({
  		    	  'chartType': 'Table',
		          'containerId': 'table_div',
		          'options': {
		            'width': 230,
		            'height': 210,
		            'pieSliceText': 'value',
		            'legend': 'right'
		          }
		        });
 
  		    var bar = new google.visualization.ChartWrapper({
  		    	  'chartType': 'Bar',
		          'containerId': 'bar_div',
		          'options': {
		        	  'title': 'Details of the Tower Lines',
		        	  'width': 1200,
			            'height': 400,
			            
		            'pieSliceText': 'value',
		            'legend': 'right'
		          }
		        });
 */

  		        
  		      

  		        // Establish dependencies, declaring that 'filter' drives 'pieChart',
  		        // so that the pie chart will only display entries that are let through
  		        // given the chosen slider range.
  		        /* dashboard.bind(donutRangeSlider, pieChart);
  		        dashboard.draw(datavalue);
 */
  		        /*  dashboardtable.bind(donutRangeSlider, table);
  		        dashboardtable.draw(datavaluefortable);
    		    
  		        dashboardbar.bind(donutRangeSlider, bar);
  		        dashboardbar.draw(datavalueforbar);
		        
  		        // Draw the dashboard.
  		        
  			    
  			}
  		}); */
    	  
    	  
    	  
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

  	  
  	  
  	 $.ajax({
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
    	  

      
          }

</script>



<!-- <script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&libraries=geometry">
	
</script>
 -->
<script 
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap&libraries=geometry"></script>

<script type="text/javascript">

var latitude;
var longitude;

function getLoc(){
	
	//alert("hhhhhhh");
	$.ajax({
		type : 'GET',
		url : "http://ip-api.com/json",
		data : {},
		//contentType : "application/json; charset=utf-8",
		success : function(data) {
			//alert("response.lat" + data.lat + "lon"+data.lon );	
			latitude = data.lat;
			longitude = data.lon;
		}
	});

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
		
		
		/*  var infoWindow = new google.maps.InfoWindow;
		//alert("hhhhhhh");
		$.ajax({
			type : 'GET',
			url : "http://ip-api.com/json/119.235.8.0",
			data : {},
			//contentType : "application/json; charset=utf-8",
			success : function(data) {
				//alert("response.lat" + data.lat + "lon"+data.lon );
				
				var pos = {
			               lat: data.lat,
			               lng: data.lon
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
			}
		});
		 */
 		
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
				
 		 var infoWindow = new google.maps.InfoWindow;
				handlePermission();

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
	       
 	
 /* var apiGeolocationSuccess = function(position) {
	    alert("API geolocation success!\n\nlat = " + position.coords.latitude + "\nlng = " + position.coords.longitude);
	};

	var tryAPIGeolocation = function() {
	    jQuery.post( "https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyDCa1LUe1vOczX1hO_iGYgyo8p_jYuGOPU", function(success) {
	        apiGeolocationSuccess({coords: {latitude: success.location.lat, longitude: success.location.lng}});
	  })
	  .fail(function(err) {
	    alert("API Geolocation error! \n\n"+err);
	  });
	};

	var browserGeolocationSuccess = function(position) {
	    alert("Browser geolocation success!\n\nlat = " + position.coords.latitude + "\nlng = " + position.coords.longitude);
	};

	var browserGeolocationFail = function(error) {
	  switch (error.code) {
	    case error.TIMEOUT:
	    	
	    	if(error.message.indexOf("Only secure origins are allowed") == 0) {
		        tryAPIGeolocation();
		      }
	    	break;
	    case error.PERMISSION_DENIED:
	      if(error.message.indexOf("Only secure origins are allowed") == 0) {
	        tryAPIGeolocation();
	      }
	      break;
	    case error.POSITION_UNAVAILABLE:
	      //alert("Browser geolocation error !\n\nPosition unavailable.");
	      if(error.message.indexOf("Only secure origins are allowed") == 0) {
    			tryAPIGeolocation();
		  } else {
    			alert("Browser geolocation error !\n\nPosition unavailable.");
		  }
	      break;
	  }
	};

	var tryGeolocation = function() {
	  if (navigator.geolocation) {
	    navigator.geolocation.getCurrentPosition(
	        browserGeolocationSuccess,
	      browserGeolocationFail,
	      {maximumAge: 50000, timeout: 20000, enableHighAccuracy: true});
	  }
	};

	tryGeolocation();
 */	
 

	}

	function viewMapByMode(){
		var viewMode = mode.options[mode.selectedIndex].value;
		//alert(viewMode);
    	
		if(viewMode=='MAP'){
			loadMap();
		}else if(viewMode=='MAP2'){
			loadMapWithoutMnt();
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
		}else if(viewMode=='INTVIEW'){
			loadIntView();
		}else if(viewMode=='GANTRY'){
			loadGantryNew();
		}else{
			//getLoc();
			loadNetwork();
		}
		
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
									"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit2(\"" + data.id + "\")'>Single Line Diagram 2</button></td></tr> "+
									
									/* "<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit(\"" + data.id + "\")'>Single Line Diagram</button></td></tr> "+
									 *//* "<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmitImg1(\"" + data.id + "\")'>DOC II</button></td></tr>"+
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

	
	
	
	function loadTransformer() {
		var map = new google.maps.Map(document.getElementById("map_container"), {
          center: new google.maps.LatLng(7.873054,80.771797),
          zoom: 12,
          gestureHandling: 'greedy',
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });

		var infoWindow = new google.maps.InfoWindow();
		var strArea = area.options[area.selectedIndex].value;
		var strDiv = divison.options[divison.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
		
		var bounds = new google.maps.LatLngBounds();
		$.ajax
        ({
                type: 'GET',
                url: "/PCB/MapNewPCB/" + strArea+ "/",
                data: {},
                contentType: "application/json; charset=utf-8",
                success : function(json){
                	for (var i = 0, length = json.length; i < length; i++) {
        					var data = json[i],
        						latLng = new google.maps.LatLng(data[1].gpsLatitude, data[1].gpsLongitude);
        						bounds.extend(latLng);
        						var image = {
        						    url: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
        						    size: new google.maps.Size(20, 32),
        						    origin: new google.maps.Point(0, 0),
        						    anchor: new google.maps.Point(0, 32)
        						  };
        						  var shape = {
        						    coords: [1, 1, 1, 20, 18, 20, 18, 1],
        						    type: 'poly'
        						  };
								 if(data[2].pcbTestDataAroclor > 50){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    	            					});
								  }else{
										var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_green.png'
	            						});
								 }
							
        					(function(marker, data) {
	        						google.maps.event.addListener(marker, "click", function(e) {
                                    infoWindow.setContent("<b>Tr number:  </b>"+
        								data[0].referenceNo+"</br>"+"<b>Location Description:</b>"+
        								data[1].locationDescription+"</br>"+"<b>SIN number : </b>"+
	            						data[0].referenceNo+"</br>"+"<b>Serial Number : </b>"+
	            						data[0].serialNo+"</br>"+"<b>kVA Rating :</b>"+
	            						data[0].capacity+"</br>");
	            						infoWindow.open(map, marker);
        						});


        					})(marker, data);

        				}

                		map.fitBounds(bounds);
                }
                
                
         });
		
		
		
		
		
		
	}
	
	
	 function initMapNew(lat,lng) {
		var map = new google.maps.Map(document.getElementById("map-container-google-2"));/* , {
		   // center: { lat: lat, lng: lng },
		   //center: new google.maps.LatLng(lat,lng),
          
		    //zoom: 18,
		    //mapTypeId: "satellite",
		  });
		  map.setTilt(45);
		   */
		  latLng = new google.maps.LatLng(lat, lng);
			
		  
		  var marker = new google.maps.Marker({
				position: latLng,
				map: map,
				//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
				//marker.setIcon(zoomIcons[map.getZoom()]);
				//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
				icon: '<c:url value="/resources/img/CEBImages/towermarkere.png"/>'
				//icon: {
       // path: google.maps.SymbolPath.CIRCLE,
       // scale: 1
 // },
				//title: "Click here to view details of Tower ID "+data[0].id
				//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
			});
		
		  
		  
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
		
		//var selectedValues = $("#line").val();

		//variables for get the move location
		
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + bounds );
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNewWayAna/" + strArea +"/" + strLine + "/" +strProvince,
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
        						  
        						  var count = 0;
        						  if(data[1]){
        						  if(data[1].wayleavestatus.includes('GOOD')){
        							  count = 0;
        							   //count = count + countGood;
        							  // alert(count);
        						  }
        						  if(data[1].wayleavestatus.includes('Good')){
        							  count = 0;
       							       //count = count + countGood;
       							       //alert(count);
       						  	  }else if(data[1].wayleavestatus.includes('ARROUND')){
      							   	   //var countGood = 1;
      							       count = count + 6;
      							      // alert(count);
      						  	  }else  if(data[1].wayleavestatus.includes('AROUND')){
     							   	   //var countGood = 1;
     							       count = count + 6;
     							      // alert(count);
     						  	  }else if(data[1].wayleavestatus.includes('Along')){
     							   	   //var countGood = 2;
     							       count = count + 6;
     							      // alert(count);
     						  	  }else if(data[1].wayleavestatus.includes('ALONG')){
    							   	   //var countGood = 2;
    							       count = count + 2;
    							      // alert(count);
    						  	  }if(data[1].wayleavestatus.includes('Close')){
   							   	  // var countGood = 3;
   							       count = count + 9;
   							       //alert(count);
   						  	      }if(data[1].wayleavestatus.includes('CLOSE')){
      							   	   //var countGood = 3;
      							       count = count + 9;
      							      // alert(count);
      						  	  }if(data[1].wayleavestatus.includes('DANGER')){
     							   	   //var countGood = 4;
     							       count = count + 9;
     							       
     							      // alert(count);
     						  	  }if(data[1].wayleavestatus.includes('TOUCH')){
     							   	  // var countGood = 5;
     							       count = count + 9;
     							      // alert(count);
     						  	  }if(data[1].wayleavestatus.includes('Tough')){
    							   	   //var countGood = 5;
    							       count = count +5;
    							      // alert(count);
    						  	  }
        						  }
        						  /* if ((data[1].wayleavestatus.indexOf('GOOD')== 0) && (data[1].wayleavestatus.indexOf('ARROUND')== 0) ){
    						  		count = 1;
    						  	  } if ((data[1].wayleavestatus.indexOf('GOOD')== 0) && (data[1].wayleavestatus.indexOf('ALONG')== 0) ){
    						  		count = 2;
    						  	  } */
        						  
      						 //alert("total : " + data[0].towerNo +" : " + count);
      						 
       						 if(count<=2){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						//icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Green.png"/>',
            						icon: {
		        					          path: google.maps.SymbolPath.CIRCLE,
		        					          scale: 1
		        					    },
            						title: "Click here to view details of Tower ID "+data[0].id + "Weightage :" + count
            						
            					});
								
       						 }
       						 /* else if(count<=5){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Blue.png"/>',
            						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + count
            						
            					});
								
       						 } */
       						
       						 else if(count<=8){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Orange.png"/>',
            						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + count
            						
            					});
								
       						 }
       						 else{
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/int.png"/>',
            						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + count
            						
            					});
								
       						 }
    						  	  
       						// count = 0;
    						  	  
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
								var insDetailTable ='';
								if(data[1]){
								insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
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
								"<tr><td>Latest Inspection Date :  </td><td>"+data[1].insDate+"</td></tr>"+
								"<tr><td>Wayleaves :  </td><td>"+data[1].wayleavestatus+"</td></tr>"+
								"<tr><td>Base Concrete :  </td><td>"+data[1].baseconcretestatus+"</td></tr>"+
								"<tr><td>Conductor Status : </td><td>"+data[1].conductorstatus+"</td></tr>"+
								"<tr><td>Jumper Status :  </td><td>"+data[1].jumperstatus+"</td></tr>"+
								"<tr><td>Missing Parts :  </td><td>"+data[1].noofmissingparts+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td><button type='button' id='myBtn' data-toggle=modal data-target=#myModal onClick='view(\"" + data[0].id + "\")'>View</button></td></tr> "+
								"</table></div>";
								
								}
	
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
	
	
	function loadMapConductor() {
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
                url: "/MMS/MapNewWayAna/" + strArea +"/" + strLine + "/" +strProvince,
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
        						  
        						  
 var count = 0;
        						  
        						  
        						  if(data[1].conductorstatus.includes('Good')){
       							   	   var countGood = 0;
       							       count = count + countGood;
       							       //alert(count);
       						  	  }
        						  if(data[1].conductorstatus.includes('Ground clearance not enough')){
      							   	   var countGood = 2;
      							       count = count + countGood;
      							       //alert(count);
      						  	  }
        						  if(data[1].conductorstatus.includes('Damaged')){
     							   	   var countGood = 3;
     							       count = count + countGood;
     							       //alert(count);
     						  	  }
        						  if(data[1].conductorstatus.includes('Danger')){
    							   	   var countGood = 4;
    							       count = count + countGood;
    							       //alert(count);
    						  	  }
        						  if((!data[1].conductorstatus.includes('Good')) && (!data[1].conductorstatus.includes('Danger')) && (!data[1].conductorstatus.includes('Damaged')) && (!data[1].conductorstatus.includes('Ground clearance not enough')) ){
   							   	   var countGood = 1;
   							       count = count + countGood;
   							       //alert(count);
   						  	      } 
        						  
        						  
        						  
        						  if(count<=1){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Green.png"/>',
                  						title: "Click here to view details of Tower ID "+data[0].id + "Weightage :" + count
                  						});
      								
             						 }
             						 else if(count<=3){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Blue.png"/>',
                  						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + count
                  						});
      								
             						 }
             						
             						 else if(count<=5){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Orange.png"/>',
                  						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + count
                  						
                  					});
      								
             						 }
             						 else{
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/int.png"/>',
                  						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + count
                  						
                  					});
      								
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
								"<tr><td>Latest Inspection Date :  </td><td>"+data[1].insDate+"</td></tr>"+
								"<tr><td>Wayleaves :  </td><td>"+data[1].wayleavestatus+"</td></tr>"+
								"<tr><td>Base Concrete :  </td><td>"+data[1].baseconcretestatus+"</td></tr>"+
								"<tr><td>Conductor Status : </td><td>"+data[1].conductorstatus+"</td></tr>"+
								"<tr><td>Jumper Status :  </td><td>"+data[1].jumperstatus+"</td></tr>"+
								"<tr><td>Missing Parts :  </td><td>"+data[1].noofmissingparts+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td><button type='button' id='myBtn' data-toggle=modal data-target=#myModal onClick='view(\"" + data[0].id + "\")'>View</button></td></tr> "+
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

	
	function loadMapJumper() {
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
                url: "/MMS/MapNew/" + strArea +"/" + strLine + "/" +strProvince,
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
        						  
        						  
        						 
        						  
        						  
								  if(data[1].jumperstatus == 'GOOD'){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_green.png',
    	            						//icon: '<c:url value="/resources/img/CEBImages/towermarkere.png"/>',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id
    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
    	            					});
										 
									  }
								  
								  else if(data[1].jumperstatus == 'Good'){
										var marker = new google.maps.Marker({
  	            						position: latLng,
  	            						map: map,
  	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
  	            						//marker.setIcon(zoomIcons[map.getZoom()]);
  	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_green.png',
  	            						//icon: '<c:url value="/resources/img/CEBImages/towermarkere.png"/>',
  	            						//icon: {
      					         // path: google.maps.SymbolPath.CIRCLE,
      					         // scale: 1
      					   // },
  	            						title: "Click here to view details of Tower ID "+data[0].id
  	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'T' }
  	            					});
										 
									  }
								  
								    else if(data[1].jumperstatus == 'DAMAGE'){
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
								  }
								  else if(data[1].jumperstatus == 'COVERED'){
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
  	            						
  	            					});
								  }
								  
								  else if(data[1].jumperstatus == 'BACKFILLING'){
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
    	            						
    	            					});
								  }else if(data[1].jumperstatus == 'CORRODED'){
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
    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'GSSB' }
    	            					});
								  }else if(data[1].jumperstatus == 'DANGER'){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'LG' }
    	            					});
								  }else if(data[1].jumperstatus == 'Danger'){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
    	            						//marker.setIcon(zoomIcons[map.getZoom()]);
    	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    	            						//icon: {
        					         // path: google.maps.SymbolPath.CIRCLE,
        					         // scale: 1
        					   // },
    	            						title: "Click here to view details of Tower ID "+data[0].id,
    	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: 'LG' }
    	            					});
								  }/* else if(data[0].supportType == 6){
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
								  } */else{
										//alert("test13 : "+ data.area);
	            					var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_blue.png',
	            						title: "Click here to view details of Tower ID "+data[0].id,
	            						//label: { color: '#FAF8F8', fontWeight: 'bold', fontSize: '14px', text: '' }
	            					});
								  }
								  
								  
								  
								  
								  
								 
								  
								  
								  
								  //alert("hhhhh4444");
								  
								  
								  
								 /*  if(!!navigator.geolocation) {
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
								"<tr><td>Latest Inspection Date :  </td><td>"+data[1].insDate+"</td></tr>"+
								"<tr><td>Wayleaves :  </td><td>"+data[1].wayleavestatus+"</td></tr>"+
								"<tr><td>Base Concrete :  </td><td>"+data[1].baseconcretestatus+"</td></tr>"+
								"<tr><td>Conductor Status : </td><td>"+data[1].conductorstatus+"</td></tr>"+
								"<tr><td>Jumper Status :  </td><td>"+data[1].jumperstatus+"</td></tr>"+
								"<tr><td>Missing Parts :  </td><td>"+data[1].noofmissingparts+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td><button type='button' id='myBtn' data-toggle=modal data-target=#myModal onClick='view(\"" + data[0].id + "\")'>View</button></td></tr> "+
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
                		
                		
                		//alert("hiiiiiiii");
                		  

                		map.fitBounds(bounds);

                		
                		//var polyline = new GPolyline([
    					                       //       new GLatLng(7.3171376, 80.5608933),
    					                           //   new GLatLng(7.3205831, 80.5581145)],
    					                           //   "#ff0000", 50);
    					                         //   map.addOverlay(polyline);

        				
                }
                
                
         });
		
	}

	
	
	function loadMapMissing() {
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
                url: "/MMS/MapNew/" + strArea +"/" + strLine + "/" +strProvince,
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
        						  
        						  
        						 if(data[1]){
        						  if(data[1].noofmissingparts == 0){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						//icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Green.png"/>',
                  						icon: {
		        					          path: google.maps.SymbolPath.CIRCLE,
		        					          scale: 1
		        					    },
		        					    title: "Click here to view details of Tower ID "+data[0].id + "Weightage :" + data[1].noofmissingparts
                  						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo 
                  							//}
                  					});
      								
             						 }
             						 else if(data[1].noofmissingparts<=4){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Orange.png"/>',
                  						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + data[1].noofmissingparts
                  						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo
                  							//}
                  					});
      								
             						 }
             						
             						/*  else if(data[1].noofmissingparts<=8){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Orange.png"/>',
                  						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + data[1].noofmissingparts,
                  						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
                  					});
      								
             						 }
             						 */ else{
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/int.png"/>',
                  						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + data[1].noofmissingparts
                  						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo
                  						//	}
                  					});
      								
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
								"<tr><td>Latest Inspection Date :  </td><td>"+data[1].insDate+"</td></tr>"+
								"<tr><td>Wayleaves :  </td><td>"+data[1].wayleavestatus+"</td></tr>"+
								"<tr><td>Base Concrete :  </td><td>"+data[1].baseconcretestatus+"</td></tr>"+
								"<tr><td>Conductor Status : </td><td>"+data[1].conductorstatus+"</td></tr>"+
								"<tr><td>Jumper Status :  </td><td>"+data[1].jumperstatus+"</td></tr>"+
								"<tr><td>Missing Parts :  </td><td>"+data[1].noofmissingparts+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td><button type='button' id='myBtn' data-toggle=modal data-target=#myModal onClick='view(\"" + data[0].id + "\")'>View</button></td></tr> "+
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

	
	
	
	function loadMapBaseCon() {
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
                url: "/MMS/MapNew/" + strArea +"/" + strLine + "/" +strProvince,
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
        						  
        						  
        					var count = 0;
        					 if(data[1].baseconcretestatus.indexOf('GOOD')== 0){
       							   var countGood = 0;
       							   count = countGood;
       							   //alert(count);
       						  }
       						  if(data[1].baseconcretestatus.indexOf('Good')== 0){
      							   	   var countGood = 0;
      							       count = count + countGood;
      							       //alert(count);
      						  	  }
       						  if(data[1].baseconcretestatus.indexOf('BACKFILLING')== 0){
     							   	   var countGood = 1;
     							       count = count + countGood;
     							       //alert(count);
     						  	  }
       						  if(data[1].baseconcretestatus.indexOf('CORRODED')== 0){
    							   	   var countGood = 2;
    							       count = count + countGood;
    							       //alert(count);
    						  	  }
       						  if(data[1].baseconcretestatus.indexOf('M_DAMAGE')== 0){
   							   	   var countGood = 2;
   							       count = count + countGood;
   							       //alert(count);
   						  	  }
       						  if(data[1].baseconcretestatus.indexOf('COVERED')== 0){
  							   	   var countGood = 3;
  							       count = count + countGood;
  							       //alert(count);
  						  	      }
       						  if(data[1].baseconcretestatus.indexOf('WATER_LODGE')== 0){
     							   	   var countGood = 3;
     							       count = count + countGood;
     							       //alert(count);
     						  	  }
       						  if(data[1].baseconcretestatus.indexOf('DANGER')== 0){
    							   	   var countGood = 4;
    							       count = count + countGood;
    							       //alert(count);
    						  	  }
       						  
       						  
       						if(count<=2){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Green.png"/>',
            						title: "Click here to view details of Tower ID "+data[0].id + "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }
       						 else if(count<=5){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Blue.png"/>',
            						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }
       						
       						 else if(count<=8){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Orange.png"/>',
            						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }
       						 else{
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/int.png"/>',
            						title: "Click here to view details of Tower ID "+data[0].id+ "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }






       						  
       						  
       						  
       						  
       						  
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
								"<tr><td>Latest Inspection Date :  </td><td>"+data[1].insDate+"</td></tr>"+
								"<tr><td>Wayleaves :  </td><td>"+data[1].wayleavestatus+"</td></tr>"+
								"<tr><td>Base Concrete :  </td><td>"+data[1].baseconcretestatus+"</td></tr>"+
								"<tr><td>Conductor Status : </td><td>"+data[1].conductorstatus+"</td></tr>"+
								"<tr><td>Jumper Status :  </td><td>"+data[1].jumperstatus+"</td></tr>"+
								"<tr><td>Missing Parts :  </td><td>"+data[1].noofmissingparts+"</td></tr>"+
								"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
								"<tr><td><button type='button' id='myBtn' data-toggle=modal data-target=#myModal onClick='view(\"" + data[0].id + "\")'>View</button></td></tr> "+
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


	

	function loadMapWithoutMnt() {
		//alert('hiii');
		var map = new google.maps.Map(document.getElementById("map_container"), {
          //center: new google.maps.LatLng(7.2665013,80.541458),
          center: new google.maps.LatLng(7.873054,80.771797),
          zoom: 20,
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
            url: "/MMS/MapNewWOMNT/" + strArea +"/" + selectedValues + "/" +strProvince,
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
    	            						icon: 'http://labs.google.com/ridefinder/images/polemarkereb.png',
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
								 */ "<tr><td><button type='button' id='myBtn' data-toggle=modal data-target=#myModal onClick='view(\"" + data[0].id + "\")'>View</button></td></tr> "+ 
								/* "<tr><td>Hot line maintenance details (ES validated maintenance work summary) :  </td><td></td></tr>"+
								"<tr><td>Cold line maintence details  (ES validated maintenance work summary) :  </td><td></td></tr>"+
								 */
								/*  "<tr><td><button type='button' id='myBtn'  onClick='initMapNew(\"" + data[0].gpsLatitude + "\",\"" + data[0].gpsLongitude + "\")'>Close View</button></td></tr> "+
								 */	
								 
								 "</table></div>";

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
							 */"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit2(\"" + data.id + "\")'>Single Line Diagram</button></td></tr> "+
							
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
	
	
	
	function loadFeederNew(id){
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
    						icon: '<c:url value="/resources/img/CEBImages/incominglbs.png"/>',
    						
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
        						icon: '<c:url value="/resources/img/CEBImages/outgoingright.png"/>',
    						
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
    						icon: '<c:url value="/resources/img/CEBImages/outgoingright.png"/>',
    						
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
        						icon: '<c:url value="/resources/img/CEBImages/outgoingright.png"/>',
        						
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
        						icon: '<c:url value="/resources/img/CEBImages/outgoingright.png"/>',
        						
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
        						icon: '<c:url value="/resources/img/CEBImages/incomingleft.png"/>',
    						
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

	
	/* fuction calculateRoute(){
		var request =  {
	              origin: p1,
	              destination: curLoc,
	              travelMode: 'DRIVING'
	            };
		directionsService.route(request,function(result,status{
			if (status === 'OK') {
                directionsRenderer.setDirections(result);
              } else {
                window.alert('Directions request failed due to ' + status);
              }
		});
	}
	 */
	/* function calculateAndDisplayRoute(directionsService, directionsRenderer) {
        directionsService.route(
            {
              origin: p1,
              destination: curLoc,
              travelMode: 'DRIVING'
            },
            function(response, status) {
              if (status === 'OK') {
                directionsRenderer.setDirections(response);
              } else {
                window.alert('Directions request failed due to ' + status);
              }
            });
      }
  */


	


	
	
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
		var selectedValues = $("#line").val();
		
		var strProvince = province.options[province.selectedIndex].value;
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + strArea + strLine );
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNewWOMNT/" + strArea +"/" + selectedValues +"/"+strProvince,
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
								if(data[0].interruptedYes == 1){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: '<c:url value="/resources/img/CEBImages/int.png"/>',
	            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].interruptedDate +'-'+data[0].interruptionNo },
	            						title: "Click here to view details of Tower ID "+data[0].towerNo + " INT NO" + data[0].interruptionNo
	            					});
								}else{
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						icon: 'http://www.google.com/mapfiles/topbar.png',
	            						title: "Click here to view details of Tower ID "+data[0].towerNo + " ID " + data[0].id
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
        						 /* var flightPath = new google.maps.Polyline({
		                              path: flightPlanCoordinates,
		                              geodesic: true,
		                              strokeColor: '#FF0000',
		                              strokeOpacity: 2.0,
		                              strokeWeight: 4
		                            });
           						flightPath.setMap(map); */
           						
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
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit2(\"" + data.id + "\")'>Single Line Diagram</button></td></tr> "+
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
     					
     					loadGantryLoc(data.id,bounds,map);
	
     					 
     			}
				map.fitBounds(bounds);
			}
		});
		
		
/* 		$.ajax({
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
     					
     					     					 
     					 
     					

     					 
     			}
				map.fitBounds(bounds);
			}
		}); */


	}
	
	function loadGantryLoc(id,bounds,map){
		$.ajax({
			type : 'GET',
			url : "/MMS/getGantryLoc/" + id + "/",
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
							//icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
							//title: "Point ID "+data.id.pointId + " EntBy " + data.entBy
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
				map.fitBounds(bounds);
			}
		});

	}


	function getLine() {
		//var categoryId = $(this).val();
		//alert("hiii");
		//getLoc();
		var strUser = area.options[area.selectedIndex].value;
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$.ajax({
					type : 'GET',
					url : "/MMS/findLineByArea/" + strUser + "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#line'), option = "<option value='NONE' selected='selected'>All Lines</option>";
						//var slctSubcat;
						
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
		//alert(id);	
		
		var strUser = id;
		//var strUser = 3550;
		//3550
		

		$.ajax({
					type : 'GET',
					url : "/MMS/getLatestMaintenance/" + strUser,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						
		
						 
						 var y = document.getElementById("fungussets");
						 var z = document.getElementById("flashoversets");
						 var w = document.getElementById("wpinsets");
						 var v = document.getElementById("endfittingsets");
						 var a = document.getElementById("jumperstatus");
						 var b = document.getElementById("conductorcondition");
						 var c = document.getElementById("earthconductorcondition");
						 var d = document.getElementById("missingmembers");
						 var e = document.getElementById("anticlimbingstatus");
						 var f = document.getElementById("legpaintingrequirement");
						 var g = document.getElementById("baseconcretestatus");
						 var h = document.getElementById("wayleavestatus");
						 var i = document.getElementById("specialobservations");
						 var j = document.getElementById("maintenanceattention");
						 var k = document.getElementById("hotlinepossibility");
						 	
						 	
						 	
						 	if (y.innerHTML === "fungussets") { 
				                y.innerHTML = data.fungussetno; 
				            }
						 	
						 	if (z.innerHTML === "flashoversets") { 
				                z.innerHTML = data.nofflashoversets; 
				            }
						 	
						 	if (w.innerHTML === "wpinsets") { 
				                w.innerHTML = data.wpinset; 
				            }
						 	
						 	if (v.innerHTML === "endfittingsets") { 
				                v.innerHTML = data.endfittingset; 
				            }
						 	
						 	if (a.innerHTML === "jumperstatus") { 
				                a.innerHTML = data.jumperstatus; 
				            }
						 	
						 	if (b.innerHTML === "conductorcondition") { 
				                b.innerHTML = data.conductorstatus; 
				            }
						 	
						 	if (c.innerHTML === "earthconductorcondition") { 
				                c.innerHTML = data.earthconductorstatus; 
				            }
						 	
						 	if (d.innerHTML === "missingmembers") { 
				                d.innerHTML = data.noofmissingparts; 
				           }
						 	
						 	if (e.innerHTML === "anticlimbingstatus") { 
				                e.innerHTML = data.anticlimbingstatus; 
				            }
						 	
				            if(f.innerHTML === "legpaintingrequirement"){
				               f.innerHTML = data.legPainting;
				            }
				            
				            if(g.innerHTML === "baseconcretestatus"){
				               g.innerHTML = data.baseconcretestatus;
				            }
				            
				            if(h.innerHTML === "wayleavestatus"){
				               h.innerHTML = data.wayleavestatus;
				            }
				            
				            if(i.innerHTML === "specialobservations"){
				               i.innerHTML = data.comments;
				            }
				            
				            if(j.innerHTML === "maintenanceattention"){
				               j.innerHTML = data.attentionstatus;
				            }
				            
				            if(k.innerHTML === "hotlinepossibility"){
				               k.innerHTML = data.hotpossible;
				               
				               if(data.hotpossible == 1){
				            	   k.innerHTML = "Possible";
				               }
				            	   else{
				            		   k.innerHTML = "Impossible";
				               }
				            }
				            
						
						 
										
				
						
						}
				});

		
		
	}
	

	 
	 

function getGantryByAreaLine()
	
	{     		
         var strArea = area.options[area.selectedIndex].value;
         var strLine = line.options[line.selectedIndex].value;
        // alert(strArea+" "+strLine);	
		   $.ajax
             ({
                     type: 'GET',
                     url: "/MMS/findGantryByAreaLine/"+strArea+"/"+strLine+"/",
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


function viewTowerByTowerNo() {
	
	//alert("gantryloc");
	var map = new google.maps.Map(document.getElementById("map_container"), {
          //center: new google.maps.LatLng(7.2665013,80.541458),
          center: new google.maps.LatLng(7.873054,80.771797),
          zoom: 12,
          gestureHandling: 'greedy',
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });
	
	var search = document.getElementById("search").value;
	var infoWindow = new google.maps.InfoWindow();
	
	//var strGantry = gantry.options[gantry.selectedIndex].value;
	//alert(search);
	var bounds = new google.maps.LatLngBounds();
	$.ajax({
				type : 'GET',
				url : "/MMS/getTower/" + search + "/",
				data : {},
				contentType : "application/json; charset=utf-8",
				success : function(data) {
					 //alert("success");
					 		//alert(data.gpsLatitude+"data    "+data.gpsLongitude);
							latLng = new google.maps.LatLng(data.gpsLatitude, data.gpsLongitude);
         					bounds.extend(latLng);
         					
         					if(data.supportType == 1){
								var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/towermarkere.png"/>',
            						title: "Click here to view details of Tower ID "+data.id
            						
            					});
								 
							  }
						  else if(data.supportType == 2){
								var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/polemarkere.png"/>',
            						title: "Click here to view details of Tower ID "+data.id
            						});
							  }
						  else if(data.supportType == 3){
								var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: 'http://labs.google.com/ridefinder/images/mm_20_yellow.png',
            						title: "Click here to view details of Tower ID "+data.id
            						
            					});
						  }else if(data[0].supportType == 4){
								var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
            						title: "Click here to view details of Tower ID "+data.id
            						            					});
						  }else if(data[0].supportType == 5){
								var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            					    icon: 'http://labs.google.com/ridefinder/images/mm_20_green.png',
            						title: "Click here to view details of Tower ID "+data.id
            						
            					});
						  }else if(data[0].supportType == 6){
								var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: 'http://labs.google.com/ridefinder/images/mm_20_blue.png',
            						title: "Click here to view details of Tower ID "+data.id
            						
            					});
						  }else if(data[0].supportType == 7){
								var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
            						title: "Click here to view details of Tower ID "+data.id
            						
            					});
						  }else{
								
        					var marker = new google.maps.Marker({
        						position: latLng,
        						map: map,
        						icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
        						title: "Click here to view details of Tower ID "+data.id
        						
        					});
						  }
         					
         					var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='ss'><tr></tr><tr><th>General Info</th></tr><tr><td>Tower Number : </td><td>"+
							data.towerNo+"</td></tr><tr><td>Latitude :  </td><td>"+
							data.gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
							data.gpsLongitude+"</td></tr>"+
							"<tr><td>Tappings :</td><td>"+data.tapping+"</td></tr>"+
							"<tr><th></th> </tr><tr><th>Maintenance Detail</th></tr>"+
							"<tr><td><button type='button' id='myBtn' data-toggle=modal data-target=#myModal onClick='view(\"" + data.id + "\")'>View</button></td></tr> "+
							"</table></div>";
							
							google.maps.event.addListener(marker, "click", function(e) {

    							infoWindow.setContent(insDetailTable);
								infoWindow.open(map, marker);
    						});

	
         					       			
					map.fitBounds(bounds);
				}
			});

}



function loadmvPole(){
	alert("loadmvPole");
	var map = new google.maps.Map(document.getElementById("map_container"), {
          //center: new google.maps.LatLng(7.2665013,80.541458),
          center: new google.maps.LatLng(7.873054,80.771797),
          zoom: 12,
          gestureHandling: 'greedy',
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });
	
	
	var strArea = area.options[area.selectedIndex].value;
    //alert("loadmvPole");
    var infoWindow = new google.maps.InfoWindow();
	var bounds = new google.maps.LatLngBounds();
	$.ajax({
				type : 'GET',
				url : "/MMS/findMvPoleByArea/" + strArea + "/",
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
        						title: "ID "+data.id + " PoleNo " + data.poleNo
        					});
         					
         					(function(marker, data) {

								var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='mvpolemodel'><tr></tr><tr><th>MV Pole Info</th></tr><tr><td>Pole Number : </td><td>"+
								data.poleNo+"</td></tr><tr><td>Latitude :</td><td>"+
								data.gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data.gpsLongitude+"</td></tr><tr><td>Pole Height :  </td><td>"+
								data.poleHeight+"</td></tr><tr><td>Pole Type : </td><td>"+
								data.poleType+"</td></tr><tr><td>Working Load : </td><td>"+
								data.workingLoad+"</td></tr><tr><td>HV LV Combine Run : </td><td>"+
								data.hvLvCombineRun+"</td></tr><tr><td>No of 33KV Circuits : </td><td>"+
								data.noOf33Kvcircuits+"</td></tr><tr><td>No of 11KV Circuits : </td><td>"+
								data.noOf11Kvcircuits+"</td></tr><tr><td>No of LV cct : </td><td>"+
								
								data.noOfLvCct+"</td></tr><tr><td>33 KV Conductor cct - 1 :  </td><td>"+
								data.kv33ConductorCct1+"</td></tr><tr><td>33 KV Conductor cct - 2 : </td><td>"+
								data.kv33ConductorCct2+"</td></tr><tr><td>33 KV Conductor cct - 3 : </td><td>"+
								data.kv33ConductorCct3+"</td></tr><tr><td>11 KV Conductor cct - 1 : </td><td>"+
								data.kv11ConductorCct1+"</td></tr><tr><td>11 KV Conductor cct - 2 : </td><td>"+
								data.kv11ConductorCct2+"</td></tr><tr><td>11 KV Conductor cct - 3 : </td><td>"+
								data.kv11ConductorCct3+"</td></tr><tr><td>LV Conductor Type : </td><td>"+
								
								data.lvConductorType+"</td></tr><tr><td>Pin / Shackle :  </td><td>"+
								data.pinShackle+"</td></tr><tr><td>Street Light : </td><td>"+
								data.streetLight+"</td></tr><tr><td>No of Stay : </td><td>"+
								data.stay+"</td></tr><tr><td>No of Strut : </td><td>"+
								data.strut+"</td></tr><tr><td>Cross Arm : </td><td>"+
								data.crossArm+"</td></tr><tr><td>Earth Conductor : </td><td>"+
								data.earthConductor+"</td></tr><tr><td>Line End : </td><td>"+
								
								data.lineEnd+"</td></tr><tr><td>33 KV CCT 1 ph 1 :  </td><td>"+
								data.kv33Cct1Ph1+"</td></tr><tr><td>33 KV CCT 1 ph 2 : </td><td>"+
								data.kv33Cct1Ph2+"</td></tr><tr><td>33 KV CCT 1 ph 3 : </td><td>"+
								data.kv33Cct1Ph3+"</td></tr><tr><td>33 KV CCT 2 ph 1 : </td><td>"+
								data.kv33Cct2Ph1+"</td></tr><tr><td>33 KV CCT 2 ph 2 : </td><td>"+
								data.kv33Cct2Ph2+"</td></tr><tr><td>33 KV CCT 2 ph 3 : </td><td>"+
								data.kv33Cct2Ph3+"</td></tr><tr><td>33 KV CCT 3 ph 1 : </td><td>"+
								data.kv33Cct3Ph1+"</td></tr><tr><td>33 KV CCT 3 ph 2 : </td><td>"+
								data.kv33Cct3Ph2+"</td></tr><tr><td>33 KV CCT 3 ph 3 : </td><td>"+
								
								data.kv33Cct3Ph3+"</td></tr><tr><td>MV Switch : </td><td>"+
								data.mvSwitch+"</td></tr><tr><td>Transformer Type : </td><td>"+
								data.transformerType+"</td></tr><tr><td>Transformer Capacity : </td><td>"+
							    data.transformerCapacity+"</td></tr><tr><td></td><td>"+
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
function loadlvPole(){
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
				url : "/MMS/findPoleByArea/" + strArea + "/",
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
        						title: "ID "+data.id + " PoleNo " + data.poleNo
        					});
         					(function(marker, data) {

								var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr><tr><th>LV Pole Info</th></tr><tr><td>Pole Number : </td><td>"+
								data.poleNo+"</td></tr><tr><td>Pole Type :</td><td>"+
								data.poleType+"</td></tr><tr><td>Latitude :  </td><td>"+
								data.gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data.gpsLongitude+"</td></tr><tr><td>No of Stay : </td><td>"+
								
								data.stay+"</td></tr><tr><td>No of Strut : </td><td>"+
								data.strut+"</td></tr><tr><td>Conductor Type : </td><td>"+
								data.conductorType+"</td></tr><tr><td>No of Consumers 1ph : </td><td>"+
								data.noOfConsumers1ph+"</td></tr><tr><td>No of Consumers 3ph : </td><td>"+
					            data.noOfConsumers3ph+"</td></tr><tr><td></td><td>"+
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


function loadIntView(){
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
				url : "/MMS/findPoleByArea/" + strArea + "/",
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
        						title: "ID "+data.id + " PoleNo " + data.poleNo
        					});
         					(function(marker, data) {

								var insDetailTable ="<div style='float:right; padding: 10px;'><table id ='lvpolemodel'><tr></tr><tr><th>LV Pole Info</th></tr><tr><td>Pole Number : </td><td>"+
								data.poleNo+"</td></tr><tr><td>Pole Type :</td><td>"+
								data.poleType+"</td></tr><tr><td>Latitude :  </td><td>"+
								data.gpsLatitude+"</td></tr><tr><td>Longitude :  </td><td>"+
								data.gpsLongitude+"</td></tr><tr><td>No of Stay : </td><td>"+
								
								data.stay+"</td></tr><tr><td>No of Strut : </td><td>"+
								data.strut+"</td></tr><tr><td>Conductor Type : </td><td>"+
								data.conductorType+"</td></tr><tr><td>No of Consumers 1ph : </td><td>"+
								data.noOfConsumers1ph+"</td></tr><tr><td>No of Consumers 3ph : </td><td>"+
					            data.noOfConsumers3ph+"</td></tr><tr><td></td><td>"+
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

<body onload="myMap(new google.maps.LatLng(7.475214, 80.744077), 7);closeall();">
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


										<c:if
													test="${sessionScope.loggedUserRole =='EE' || sessionScope.loggedUserRole =='CE' || sessionScope.loggedUserRole =='AGM'}">
													
										<div class="row">
                            <div class="col-lg-12">                                                                                                   
                                        <div class="row">                                           
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square-o  yellow-bg"></i>
                                                            <span class="headline">Interruption Request</span>
                                                            <span class="headline">
                                                                <a href="displayAllINSReq?mode=INT"><span class="num" style="color:red; font-weight:bold;">${IntReq}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-sliders  black-bg"></i>
                                                            <span class="headline">Inspection Request</span>
                                                            <span class="headline">
                                                                <a href="breakDownMNT?mode=INS"><span class="num" style="color:red; font-weight:bold;">${InsReq}</span></span></a>
                                                                                                                       </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline">Maintenance Request</span>
                                                            <span class="headline">
                                                                <a href="breakDownMNT?mode=MNT"><span class="num" style="color:red; font-weight:bold;">${MntReq}</span></span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <%-- <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-hand-o-right  green-bg"></i>
                                                            <span class="headline">Tower Line Approval</span>
                                                            <span class="headline">
                                                                <a href="displayAllLines"><span class="num" style="color:red; font-weight:bold;">${countLine}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            --%>
                                            
                                             <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  green-bg"></i>
                                                            <span class="headline">Estimate Approval</span>
                                                            <span class="headline">
                                                                <a href="estimateApproval">Approval</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <%--  <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline">Tower Line Approval</span>
                                                            <span class="headline">
                                                                <a href="displayAllLines"><span class="num" style="color:red; font-weight:bold;">${countLine}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                           <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  green-bg"></i>
                                                            <span class="headline">Supports Approval</span>
                                                            <span class="headline">
                                                                <a href="displayAllSupports"><span class="num" style="color:red; font-weight:bold;">${countSupport}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline">Maintenance Data Approval</span>
                                                            <span class="headline">
                                                                <a href="displayAllMnt"><span class="num" style="color:red; font-weight:bold;">${countMnt}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                             --%> 
                                        </div>
                                        
                                </div>

                            </div>
                            
                                                        
                            
                            </c:if>
                            
                            
                            <c:if
													test="${sessionScope.loggedUserRole =='ES'}">
													
										<div class="row">
										<div class="col-lg-10">
										<div class="col-lg-10" align="left">
										                                                                                                   
                             <input id ='showBtn' type='button' class='btn btn-success' value='Show Options' onClick='myFunction()'></input>
                             </div>
                             <div  id = "test" class="col-sm-10" align="center">
									<div class="row">
										<form:form method="post" action="viewSupportByProvince"
											modelAttribute="model">

											<div class="col-lg-8" align="center">

												<div class="row">
												
											<div class="drop-down-padding">
     
     
															<form:select id="province" path="glcompmobj.compId"
																onchange="findArea();drawDashboard();" style="width:100%; background-color: #FFFFFF; border-radius: 5px;">
																<form:option value="NONE" label="Province" />
																
																<form:options items="${model.provinceList}" />
															</form:select>
														
																										
												</div>
												
												<div class="drop-down-padding">
														
															<form:select id="area" path="gldeptobj.deptId"
																onchange="getLine();drawDashboard();" 
																style="width:100%; background-color: #FFFFFF; border-radius: 5px;">
																<form:option value="NONE" label="Area" />
																<form:options items="${model.areaList}" />
															</form:select>
																											</div>
												
												
													<div class="drop-down-padding">
														
															<form:select multiple="true" id="line" path="line.code" onchange=""
																style="width:100%; background-color: #FFFFFF; overflow:scroll; border-radius: 5px;">
																<form:option value="NONE" label="All Lines" selected="selected"/>
																 <form:options items="${model.lineList}" />
															</form:select>
														
													
												</div>
												
												<div class="drop-down-padding">
														
															<form:select id="mode" path="" onchange=""
																style="width:100%; background-color: #FFFFFF; border-radius: 5px;">
																<%-- <form:option value="MAP" label="MAP VIEW" />
																 --%><form:option value="MAP2" label="Map View" />
																<form:option value="NETWORK" label="Network View" />
																<form:option value="WAYLEAVE" label="Wayleave Status" />
<%-- <form:option value="BASECON" label="Base Concrete Status" />
<form:option value="CONDUCTOR" label="Conductor Status" />
<form:option value="JUMPER" label="Jumper Status" />
 --%><form:option value="MISSING" label="Missing Part Status" />
 <form:option value="GANTRY" label="Substations View" />
<%-- <form:option value="TRANSFOMER" label="Transformer" />
 --%><form:option value="MVPOLE" label="Mv Pole View" />
<form:option value="LVPOLE" label="Lv Pole View" />
<%-- <form:option value="INTVIEW" label="Interruption View" />
 --%>
 </form:select></div>
 
 <div align="right" style="padding-right: 10px">									
															<form:button type ="button" class="btn btn-success" style="width:30%; border-radius: 5px;" onClick='viewMapByMode()'>View</form:button>
														</div>
															
												
		
                             </div>
                             </div>
                             </form:form>
                             </div>
                             </div>
                             
                             </div>
										
										<div class="col-lg-10">                                                                                                   
                             
                             
                             
                             
                             
                             
                             
                             
                             
                             
										<div id="map_container"></div>
										</div>
										
                             <div class="col-lg-2">                                                                                                   
                                        <div class="row"> 
                                                <div class="col-2"> 
                                                                          
                                            <!-- <div class="col-lg-3 col-sm-6 col-xs-12">
                                             -->        <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square-o  yellow-bg"></i>
                                                            <span class="headline">Interruption Request</span>
                                                            <span class="headline">
                                                                <a href="goToInterruptionRequest?mode=INTERRUPTION">Create</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                             <div class="col-2"> 
                                               
                                           <!--  <div class="col-lg-3 col-sm-6 col-xs-12">
                                            -->         <div class="main-box infographic-box">
                                                            <i class="fa fa-sliders  black-bg"></i>
                                                            <span class="headline">Inspection Request</span>
                                                            <span class="headline">
                                                                <a href="breakDownMNT?mode=INS"><span class="num" style="color:red; font-weight:bold;">${InsReq}</span></span></a>
                                                                                                                       </span>
                                                    </div>
                                            </div>
                                             <div class="col-2"> 
                                               
                                            <!-- <div class="col-lg-3 col-sm-6 col-xs-12">
                                             -->        <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline">Maintenance Request</span>
                                                            <span class="headline">
                                                                <a href="breakDownMNT?mode=MNT"><span class="num" style="color:red; font-weight:bold;">${MntReq}</span></span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                             <div class="col-2"> 
                                               
                                             <!-- <div class="col-lg-3 col-sm-6 col-xs-12">
                                              -->       <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline">Tower Line Validation</span>
                                                            <span class="headline">
                                                                <a href="displayAllLines"><span class="num" style="color:red; font-weight:bold;">${countLine}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                             <div class="col-2"> 
                                               
                                           <!-- <div class="col-lg-3 col-sm-6 col-xs-12">
                                            -->         <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline">Supports Validation</span>
                                                            <span class="headline">
                                                                <a href="displayAllSupports"><span class="num" style="color:red; font-weight:bold;">${countSupport}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            <div class="col-2">
                                            <!-- <div class="col-lg-3 col-sm-6 col-xs-12">
                                             -->        <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline">Maintenance Data Validation</span>
                                                            <span class="headline">
                                                                <a href="displayAllMnt"><span class="num" style="color:red; font-weight:bold;">${countMnt}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                           
                                           
                                            
                                            <%-- <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-hand-o-right  green-bg"></i>
                                                            <span class="headline">Tower Line Approval</span>
                                                            <span class="headline">
                                                                <a href="displayAllLines"><span class="num" style="color:red; font-weight:bold;">${countLine}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            --%>
                                            
                                            <!--  <div class="col-lg-3 col-sm-6 col-xs-12">
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
													test="${sessionScope.loggedUserRole =='DEO'}">
													
										<div class="row">
                            <div class="col-lg-12">                                                                                                   
                                        <div class="row">                                           
                                            <%-- <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square-o  yellow-bg"></i>
                                                            <span class="headline">Interruption Request</span>
                                                            <span class="headline">
                                                                <a href="goToInterruptionRequest?mode=INTERRUPTION">Create</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-sliders  black-bg"></i>
                                                            <span class="headline">Inspection Request</span>
                                                            <span class="headline">
                                                                <a href="breakDownMNT?mode=INS"><span class="num" style="color:red; font-weight:bold;">${InsReq}</span></span></a>
                                                                                                                       </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline">Maintenance Request</span>
                                                            <span class="headline">
                                                                <a href="breakDownMNT?mode=MNT"><span class="num" style="color:red; font-weight:bold;">${MntReq}</span></span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                             --%> <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline">Tower Line Validation</span>
                                                            <span class="headline">
                                                                <a href="displayAllLines"><span class="num" style="color:red; font-weight:bold;">${countLine}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                           <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline">Supports Validation</span>
                                                            <span class="headline">
                                                                <a href="displayAllSupports"><span class="num" style="color:red; font-weight:bold;">${countSupport}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline">Maintenance Data Validation</span>
                                                            <span class="headline">
                                                                <a href="displayAllMnt"><span class="num" style="color:red; font-weight:bold;">${countMnt}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                           
                                           
                                            
                                            <%-- <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-hand-o-right  green-bg"></i>
                                                            <span class="headline">Tower Line Approval</span>
                                                            <span class="headline">
                                                                <a href="displayAllLines"><span class="num" style="color:red; font-weight:bold;">${countLine}</span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            --%>
                                            
                                            <!--  <div class="col-lg-3 col-sm-6 col-xs-12">
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
                            
                            
                            
                            
                            
                            
                            <br>
 
                            
                            
                            										                            
                            
                                                        										<%-- <c:if
													test="${sessionScope.loggedUserRole =='ES'}">
													
										<div class="row">
                            <div class="col-lg-12">                                                                                                   
                                        <div class="row">                                           
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-pencil-square-o  yellow-bg"></i>
                                                            <span class="headline">Interruption Request</span>
                                                            <span class="headline">
                                                                <a href="goToInterruptionRequest?mode=INTERRUPTION">Create</a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-sliders  black-bg"></i>
                                                            <span class="headline">Inspection Request</span>
                                                            <span class="headline">
                                                                <a href="breakDownMNT?mode=INS"><span class="num" style="color:red; font-weight:bold;">${InsReq}</span></span></a>
                                                           
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                                    <div class="main-box infographic-box">
                                                            <i class="fa fa-tasks  purple-bg"></i>
                                                            <span class="headline">Maintenance Request</span>
                                                            <span class="headline">
                                                                <a href="breakDownMNT?mode=MNT"><span class="num" style="color:red; font-weight:bold;">${MntReq}</span></span></a>
                                                            </span>
                                                    </div>
                                            </div>
                                            
                                            <!-- <div class="col-lg-3 col-sm-6 col-xs-12">
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
 --%>                            
                            										                            
                            
                     <%--  <div class="row">


						<div class="col-lg-12">
							<div class="col-lg-9">
								<ol class="breadcrumb">
									<li><a href="#">Map View</a></li>
									</ol>

								
							</div>

							<%@ include file="sections/userDetails.jsp"%>

						</div>

					</div>
                            
 --%>                            
					<div class="container">

						<div class="jumbotron">

							<div class="row ">
<!-- The Modal -->
                         <!-- <div id="myModal" class="modal">



	

                              Modal content
                              <div class="modal-content">
                             <span class="close">&times;</span>
                                <label>Maintenance Details</label><br>
                               <p1>Fungus Sets:<label id="fungussets">fungussets</label></p1><br>
                                <p1>Flash Over Sets:<label id="flashoversets">flashoversets</label></p1><br>
                                <p1>W Pin Sets:<label id="wpinsets">wpinsets</label></p1><br>
                                <p1>End Fitting Sets:<label id="endfittingsets">endfittingsets</label></p1><br>
                                <p1>Jumper Status:<label id="jumperstatus">jumperstatus</label></p1><br>
                                <p1>Conductor Condition:<label id="conductorcondition">conductorcondition</label></p1><br>
                                <p1>Earth Conductor Condition:<label id="earthconductorcondition">earthconductorcondition</label></p1><br>
                                <p1>Missing Members:<label id="missingmembers">missingmembers</label></p1><br>
                                <p1>Anti Climbing Status:<label id="anticlimbingstatus">anticlimbingstatus</label></p1><br>
                                <p1>Leg Painting Requirement:<label id="legpaintingrequirement">legpaintingrequirement</label></p1><br>
                                <p1>Base Concrete Status:<label id="baseconcretestatus">baseconcretestatus</label></p1><br>
                                <p1>Way leave status:<label id="wayleavestatus">wayleavestatus</label></p1><br>
                                <p1>Special Observations:<label id="specialobservations">specialobservations</label></p1><br>
                                <p1>Maintenance Attention:<label id="maintenanceattention">maintenanceattention</label></p1><br>
                                <p1>Hot Line Possibility:<label id="hotlinepossibility">hotlinepossibility</label></p1><br>
                                 
                             </div>

                        </div>
 -->

<div class="col-sm-12" align="left">
									<div class="row">
									
									

										<input id ='showBtn' type='button' class='btn btn-success' value='Show Options' onClick='myFunction()'></input>

									</div>
								</div>



								<div  id = "test" class="col-sm-10" align="center">
									<div class="row">
										<form:form method="post" action="viewSupportByProvince"
											modelAttribute="model">

											<div class="col-lg-8" align="center">

												<div class="row">
												
	<%-- 											<div class="dropdown">
    <button class="dropbtn">Province
      											
				
	
      
      
    </button>
    <div class="dropdown-content">
    <select id="province" class="form-control" disabled>
		<c:forEach var="province" items="${model.glcompm}">
					<option value="${province.compId}" selected="selected">${province.compNm}</option>
		</c:forEach>
	 </select> 
    
     <c:forEach var="province" items="${model.glcompm}">
		<label class="radio-inline">
																
     <form:radiobutton path="" value="${province.compId}" id="province" style="width:100%;"/>${province.compNm}
     </label>
		</c:forEach>														
     </div> --%>												
                                                    
     <div class="drop-down-padding">
     
     
															<form:select id="province" path="glcompmobj.compId"
																onchange="findArea();drawDashboard();" style="width:100%; background-color: #FFFFFF; border-radius: 5px;">
																<form:option value="NONE" label="Province" />
																
																<form:options items="${model.provinceList}" />
															</form:select>
														
																										
												</div>
												<!-- </div> -->

												
													<div class="drop-down-padding">
														
															<form:select id="area" path="gldeptobj.deptId"
																onchange="getLine();drawDashboard();" 
																style="width:100%; background-color: #FFFFFF; border-radius: 5px;">
																<form:option value="NONE" label="Area" />
																<form:options items="${model.areaList}" />
															</form:select>
																											</div>
												
												
													<div class="drop-down-padding">
														
															<form:select multiple="true" id="line" path="line.code" onchange=""
																style="width:100%; background-color: #FFFFFF; overflow:scroll; border-radius: 5px;">
																<form:option value="NONE" label="All Lines" selected="selected"/>
																 <form:options items="${model.lineList}" />
															</form:select>
														
													
												</div>
												
												
												<!-- <div class="row"> -->
												
												
													<div class="drop-down-padding">
														
															<form:select id="mode" path="" onchange=""
																style="width:100%; background-color: #FFFFFF; border-radius: 5px;">
																<%-- <form:option value="MAP" label="MAP VIEW" />
																 --%><form:option value="MAP2" label="Map View" />
																<form:option value="NETWORK" label="Network View" />
																<form:option value="WAYLEAVE" label="Wayleave Status" />
<%-- <form:option value="BASECON" label="Base Concrete Status" />
<form:option value="CONDUCTOR" label="Conductor Status" />
<form:option value="JUMPER" label="Jumper Status" />
 --%><form:option value="MISSING" label="Missing Part Status" />
 <form:option value="GANTRY" label="Substations View" />
<%-- <form:option value="TRANSFOMER" label="Transformer" />
 --%><form:option value="MVPOLE" label="Mv Pole View" />
<form:option value="LVPOLE" label="Lv Pole View" />
<%-- <form:option value="INTVIEW" label="Interruption View" />
 --%>

<%-- <div class="row">
													<div class="drop-down-padding">
														<div class="col-xs-12" align="right">
															<form:select multiple="true" id="line" path="cycleObj.id.cycleId" onchange=""
																style="width:100%; background-color: #dac698; overflow:scroll; border-radius: 5px;">
																<form:option value="NONE" label="CYCLE" />
																 <form:options items="${model.cycleList}" />

															</form:select>
														</div>
													</div>
												</div>
 --%>												


															</form:select>
														
													</div>
												 

															<div align="right" style="padding-right: 10px">									
															<form:button type ="button" class="btn btn-success" style="width:30%; border-radius: 5px;" onClick='viewMapByMode()'>View</form:button>
														</div>
															
															<!-- <button type='button' class='btn btn-success'
																onClick='viewMapByMode()'>View</button> -->
														
													
												
												<br><br>
												
												
												<%-- <div class="row">
													<div class="drop-down-padding">
														<div align="right" style="padding-right: 10px">
															<form:input style="width:100%; background-color: #FFFFFF; border-radius: 5px;" path="" type='text' id='search' placeholder='Enter Tower Number' class="form-control"/>
														</div>
													</div>
												</div>
												 --%>
												
												<%-- <div class="row">
													<div class="drop-down-padding">
														<div align="right" class="dropdown" style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														
														<form:button type ="button" class="btn btn-success" style="width:100%; border-radius: 5px;" onClick='viewTowerByTowerNo()'>Search</form:button>
															<!-- <button type='button' class='btn btn-success'
																onClick='viewTowerByTowerNo()'>Search</button> -->
														</div>
													</div>
												</div> --%>
												
											<br><br>
												
												<%-- <%-- <c:if
													test="${sessionScope.loggedUserRole =='EE' || sessionScope.loggedUserRole =='CE' || sessionScope.loggedUserRole =='DGM'|| sessionScope.loggedUserRole =='AGM'}">
													<div align="right" class="dropdown" style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<form:button type ="button" class="btn btn-success" style="width:100%; border-radius: 5px;">Approve(<span class="num" style="color:red; font-weight:bold;">${countAll}</span>)</form:button>
														 
														 <div class="dropdown-content">
														
															<c:if test="${countLine =='0'}"><a href="displayAllLines">Approve Lines</a></c:if>
															<c:if test="${countLine !='0'}"><a href="displayAllLines">Approve Lines (<span class="num" style="color:red; font-weight:bold;">${countLine}</span>)</a></c:if>
															
															<c:if test="${countSupport =='0'}"><a href="displayAllSupports">Approve Supports</a></c:if>
															<c:if test="${countSupport !='0'}"><a href="displayAllSupports">Approve Supports (<span class="num" style="color:red; font-weight:bold;">${countSupport}</span>)</a></c:if>
															
															<c:if test="${countMnt =='0'}"><a href="displayAllMnt">Approve Mnt</a></c:if>
															<c:if test="${countMnt !='0'}"><a href="displayAllMnt">Approve Mnt (<span class="num" style="color:red; font-weight:bold;">${countMnt}</span>)</a> </c:if>
															
															<c:if test="${unReadEmail =='0'}"><a href="displayAllUnReadMsg">UnRead Way Leave Status</a></c:if>
															<c:if test="${unReadEmail !='0'}"><a href="displayAllUnReadMsg">UnRead Way Leave Status (<span class="num" style="color:red; font-weight:bold;">${unReadEmail}</span>)</a> </c:if>
															
															
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
													<div align="right" class="dropdown" style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<form:button type ="button" class="btn btn-success" style="width:100%; border-radius: 5px;">Validation(<span class="num" style="color:red; font-weight:bold;">${countAll}</span>)</form:button>
														<div class="dropdown-content">
														
															<c:if test="${countLine =='0'}"><a href="displayAllLines">Send Lines For Approval</a></c:if>
															<c:if test="${countLine !='0'}"><a href="displayAllLines">Send Lines For Approval (<span class="num" style="color:red; font-weight:bold;">${countLine}</span>)</a></c:if>
															
															<c:if test="${countSupport =='0'}"><a href="displayAllSupports">Send Supports For Approval</a></c:if>
															<c:if test="${countSupport !='0'}"><a href="displayAllSupports">Send Supports For Approval (<span class="num" style="color:red; font-weight:bold;">${countSupport}</span>)</a></c:if>
															
															<c:if test="${countMnt =='0'}"><a href="displayAllMnt">Send Mnt For Approval</a></c:if>
															<c:if test="${countMnt !='0'}"><a href="displayAllMnt">Send Mnt For Approval (<span class="num" style="color:red; font-weight:bold;">${countMnt}</span>)</a> </c:if>
															
														</div>
													</div>
													<br><br>
												
													
													<div align="right" class="dropdown" style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<form:button type ="button" class="btn btn-success" style="width:100%; border-radius: 5px;">Status(<span class="num" style="color:red; font-weight:bold;">${IntReq}</span>)</form:button>
														<div class="dropdown-content">
														    <c:if test="${IntReq =='0'}"><a href="displayAllINSReq?mode=INT">Interruption Request</a></c:if>
															<c:if test="${IntReq !='0'}"><a href="displayAllINSReq?mode=INT">Interruption Request (<span class="num" style="color:red; font-weight:bold;">${IntReq}</span>)</a> </c:if>
															
															
														</div>
													</div>
													
													
													
													
												</c:if>
												<c:if test="${sessionScope.loggedUserRole =='DEO'}">
													<div align="right" class="dropdown" style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<form:button type ="button" class="btn btn-success" style="width:100%; border-radius: 5px;">Validation(<span class="num" style="color:red; font-weight:bold;">${countAll}</span>)</form:button>
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
													<div align="right" class="dropdown" style="width: 100%; height: 30px; padding-right: 10px; padding-left: 10px; padding-top: 10px;padding-bottom: 10px; border-radius: 5px;">
														<form:button type ="button" class="btn btn-success" style="width:100%; border-radius: 5px;">Status(<span class="num" style="color:red; font-weight:bold;">${countAllReq}</span>)</form:button>
														<div class="dropdown-content">
														
															
															<c:if test="${unReadEmail =='0'}"><a href="displayAllUnReadMsg">UnRead Way Leave Status</a></c:if>
															<c:if test="${unReadEmail !='0'}"><a href="displayAllUnReadMsg">UnRead Way Leave Status (<span class="num" style="color:red; font-weight:bold;">${unReadEmail}</span>)</a> </c:if>
															
															<c:if test="${InsReq =='0'}"><a href="breakDownMNT?mode=INS">Inspection Request</a></c:if>
															<c:if test="${InsReq !='0'}"><a href="breakDownMNT?mode=INS">Inspection Request (<span class="num" style="color:red; font-weight:bold;">${InsReq}</span>)</a> </c:if>
															
															<c:if test="${MntReq =='0'}"><a href="breakDownMNT?mode=MNT">Maintenance Request</a></c:if>
															<c:if test="${MntReq !='0'}"><a href="breakDownMNT?mode=MNT">Maintenance Request (<span class="num" style="color:red; font-weight:bold;">${MntReq}</span>)</a> </c:if>
															
															<c:if test="${IntReq =='0'}"><a href="forwardRequestInt">Forward Interruption Request</a></c:if>
															<c:if test="${IntReq !='0'}"><a href="forwardRequestInt">Forward Interruption Request (<span class="num" style="color:red; font-weight:bold;">${IntReq}</span>)</a> </c:if>
															
															 <c:if test="${IntReq =='0'}"><a href="displayAllINSReq?mode=INT">Forward Interruption Request</a></c:if>
															<c:if test="${IntReq !='0'}"><a href="displayAllINSReq?mode=INT">Forward Interruption Request (<span class="num" style="color:red; font-weight:bold;">${IntReq}</span>)</a> </c:if>
															 
															<a href="RequestCalender">Interruption Request Calender</a>
															
															<a href="estimateStatus">Estimate Status</a>
															
															
															
														</div>
													</div>
												</c:if>
 --%>												 
												
												
												
												

											</div>
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
 --%>										<br>
										<!-- --------------------------------------------------------------------------------------------------------- -->

									</div>
								</div>
								
																

								<div class="col-sm-12" align="left">
									<div class="row">
									
									

										<div id="map_container"></div>

									</div>
								</div>
								
								<br>
								
								<!-- <div id="feeder" class="col-sm-12" align="left">
									<div class="row">
									
									

										<div id="map_container2"></div>

									</div>
								</div>
 -->								
								<!--  <div class="col-sm-12" align="left">
									<div class="row">
									
									Google map
<div id="map-container-google-3" class="z-depth-1-half map-container-3">
  <iframe src="https://maps.google.com/maps?q=srilanka&t=k&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0"
    style="border:0" allowfullscreen></iframe>
</div>					
									

										<div id="map"></div>

									</div>
								</div>
 -->			
 
 								
																
								
								<br><br>
								 <!-- <div class="col-sm-12" align="left">

									<div class="row">

										<div id="filter_div"></div>
      
									</div>
								</div>
 --> 							<!-- 	<div class="col-sm-12" align="left">

									<div class="row">

										<div id="filter_div2"></div>
      
									</div>
								</div>
								<div class="col-sm-12" align="left">

									<div class="row">

										<div id="filter_div3"></div>
      
									</div>
								</div>
 -->								

							</div>
						</div>
					</div>


<br>
<c:if test="${sessionScope.deptId == '600.41'}">
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
                    </c:if> 
                    
                    
                    <c:if test="${sessionScope.deptId != '600.41'}">
                             <div class="container" align="left">


						<div class="row">
							<div class="col-lg-12">
							<div class="row">
						
								
					
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
					</div>
					</div>
					</div>
                    </c:if>       


                           <!--  <div class="container" align="left">


						<div class="row">
							<div class="col-lg-12">
					
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
					</div>
					</div>
 -->

<br><br>
					<div class="container">


						<div class="row">
							<div class="col-lg-12">

								<div class="row">
								
								<%-- <div class="col-lg-4 col-sm-6 col-xs-12">
										 <div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: rgba(0, 255, 0, 0.3); border-radius: 5px;">
												<center>
													<i class="fa fa-info-circle" style="color: #008080"></i>
												</center>
												<h4>
													<center>
															<strong>Divisional Summary</strong>
														</center>
												</h4>
 



												 <div style="height: 220px"> 
<div id="dashboard_div">
      <!--Divs that will hold each control and chart-->
      <div id="chart_div"></div>
												 </div> 





											 </div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div> 
									</div>
									</div>
 --%>								 <%-- <div class="col-lg-4 col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: rgba(0, 255, 0, 0.3); border-radius: 5px;">
												<center>
													<i class="fa fa-info-circle" style="color: #008080"></i>
												</center>
												<h4>
													<center>
															<strong>Divisional Summary</strong>
														</center>
												</h4>




												<div style="height: 220px">
<div id="dashboard_div2">
      <!--Divs that will hold each control and chart-->
      										
<div id="table_div"></div>
</div>
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
												style="background-color: rgba(0, 255, 0, 0.3); border-radius: 5px;">
												<center>
													<i class="fa fa-info-circle" style="color: #008080"></i>
												</center>
												<h4>
													<center>
															<strong>Divisional Summary</strong>
														</center>
												</h4>




												<div style="height: 220px">
<div id="dashboard_div1">
      <!--Divs that will hold each control and chart-->
      										
<div id="bar_div"></div>
</div>

												</div>





											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div>
 --%>									

									 <div class="col-lg-4 col-sm-6 col-xs-12">
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
													<h4>
														<strong> <br> </strong>
													</h4>

													<div style="overflow-x: auto;">
														<div class="card card-plain">
															<div class="card-body">
																<div class="table-responsive">
																	<table class="table table-hover"
																		style="border: 2px solid #809c79; background-color: #d6e3c1; width: 100%;">

																		<c:set var="count" value="0" scope="page" />
																		<c:forEach var="summary" items="${model.summaryList}"
																			varStatus="status">

<c:if test="${sessionScope.deptId == '600.41'}">
								
																			<tr>
																			
																				<td>
																				<div class="dropdown" style="width: 100%; height: 30px;">
																				<!-- <button class="dropbtn" style="width: 100%; height: 25px;  background-color:#d6e3c1;">Lines</button>-->
																				<strong>Lines</strong>
																				<div class="dropdown-content">
																				<a href="viewLineSummary?id=CP&dd=DISTRIBUTION DIVISION 2&province=CENTRAL PROVINCE">CP</a>
																				<a href="viewLineSummary?id=EP&dd=DISTRIBUTION DIVISION 2&province=EASTERN PROVINCE">EP</a>
																				<a href="viewLineSummary?id=WPN&dd=DISTRIBUTION DIVISION 2&province=WESTERN PROVINCE NORTH">WPN</a>
																				<!-- <a href="viewLineSummary?id=UVA&dd=DISTRIBUTION DIVISION 3&province=UVA PROVINCE">UVA</a>
																				<a href="viewLineSummary?id=SAB&dd=DISTRIBUTION DIVISION 3&province=SABARAGAMUWA PROVINCE">SAB</a>
																				<a href="viewLineSummary?id=WPSII&dd=DISTRIBUTION DIVISION 3&province=WESTERN PROVINCE SOUTH II">WPS II</a>
																				 -->
																				</div>
																				
																				</div>
																				
																				
																				<!-- <strong><a href="viewLineSummary?id=CP&dd=DISTRIBUTION DIVISION 2&province=CENTRAL PROVINCE">Lines</a></strong>--></td>
																				<td><strong>${summary[0]}</strong></td>

																			</tr>
																			<tr>
																				<td><strong>Line length</strong></td>
																				<td><strong>${summary[1]}</strong></td>

																			</tr>
																			<tr>
																				<td><strong>Towers</strong></td>
																				<td><strong>${summary[2]}</strong></td>
																			</tr>
																			<tr>
																				<td><strong>Poles</strong></td>
																				<td><strong>${summary[3]}</strong></td>
																			</tr>
																			</c:if>
<c:if test="${sessionScope.deptId == '596.00'}">
								
																			<tr>
																			
																				<td>
																				<div class="dropdown" style="width: 100%; height: 30px;">
																				<!-- <button class="dropbtn" style="width: 100%; height: 25px;  background-color:#d6e3c1;">Lines</button>-->
																				<strong>Lines</strong>
																				<div class="dropdown-content">
																				<a href="viewLineSummary?id=NWP&dd=DISTRIBUTION DIVISION 1&province=NORTH WESTERN PROVINCE">NWP</a>
																				<a href="viewLineSummary?id=NWP2&dd=DISTRIBUTION DIVISION 1&province=NORTH WESTERN PROVINCE 2">NWP 2</a>
																				
																				<a href="viewLineSummary?id=NP&dd=DISTRIBUTION DIVISION 1&province=NORTHERN PROVINCE">NP</a>
																				<a href="viewLineSummary?id=NCP&dd=DISTRIBUTION DIVISION 1&province=NORTH CENTRAL PROVINCE">NCP</a>
																				<a href="viewLineSummary?id=CC&dd=DISTRIBUTION DIVISION 1&province=COLOMBO CITY">CC</a>
																				
																				<!-- <a href="viewLineSummary?id=UVA&dd=DISTRIBUTION DIVISION 3&province=UVA PROVINCE">UVA</a>
																				<a href="viewLineSummary?id=SAB&dd=DISTRIBUTION DIVISION 3&province=SABARAGAMUWA PROVINCE">SAB</a>
																				<a href="viewLineSummary?id=WPSII&dd=DISTRIBUTION DIVISION 3&province=WESTERN PROVINCE SOUTH II">WPS II</a>
																				 -->
																				</div>
																				
																				</div>
																				
																				
																				<!-- <strong><a href="viewLineSummary?id=CP&dd=DISTRIBUTION DIVISION 2&province=CENTRAL PROVINCE">Lines</a></strong>--></td>
																				<td><strong>${summary[0]}</strong></td>

																			</tr>
																			<tr>
																				<td><strong>Line length</strong></td>
																				<td><strong>${summary[1]}</strong></td>

																			</tr>
																			<tr>
																				<td><strong>Towers</strong></td>
																				<td><strong>${summary[2]}</strong></td>
																			</tr>
																			<tr>
																				<td><strong>Poles</strong></td>
																				<td><strong>${summary[3]}</strong></td>
																			</tr>
																			</c:if>
																			
																			
																			<c:if test="${sessionScope.deptId == '972.30'}">
								
																			<tr>
																			
																				<td>
																				<div class="dropdown" style="width: 100%; height: 30px;">
																				<!-- <button class="dropbtn" style="width: 100%; height: 25px;  background-color:#d6e3c1;">Lines</button>-->
																				<strong>Lines</strong>
																				<div class="dropdown-content">
																				<a href="viewLineSummary?id=SP&dd=DISTRIBUTION DIVISION 4&province=SOUTHERN PROVINCE">SP</a>
																				<a href="viewLineSummary?id=SP2&dd=DISTRIBUTION DIVISION 4&province=SOUTHERN PROVINCE 2">NP</a>
																				<a href="viewLineSummary?id=WPS1&dd=DISTRIBUTION DIVISION 4&province=WESTERN NORTH PROVINCE I">WPS I</a>
																				<!-- <a href="viewLineSummary?id=CC&dd=DISTRIBUTION DIVISION 1&province=COLOMBO CITY">CC</a>
																				 -->
																				<!-- <a href="viewLineSummary?id=UVA&dd=DISTRIBUTION DIVISION 3&province=UVA PROVINCE">UVA</a>
																				<a href="viewLineSummary?id=SAB&dd=DISTRIBUTION DIVISION 3&province=SABARAGAMUWA PROVINCE">SAB</a>
																				<a href="viewLineSummary?id=WPSII&dd=DISTRIBUTION DIVISION 3&province=WESTERN PROVINCE SOUTH II">WPS II</a>
																				 -->
																				</div>
																				
																				</div>
																				
																				
																				<!-- <strong><a href="viewLineSummary?id=CP&dd=DISTRIBUTION DIVISION 2&province=CENTRAL PROVINCE">Lines</a></strong>--></td>
																				<td><strong>${summary[0]}</strong></td>

																			</tr>
																			<tr>
																				<td><strong>Line length</strong></td>
																				<td><strong>${summary[1]}</strong></td>

																			</tr>
																			<tr>
																				<td><strong>Towers</strong></td>
																				<td><strong>${summary[2]}</strong></td>
																			</tr>
																			<tr>
																				<td><strong>Poles</strong></td>
																				<td><strong>${summary[3]}</strong></td>
																			</tr>
																			</c:if>
																			
																			<c:if test="${sessionScope.deptId == '780.00'}">
								
																			<tr>
																			
																				<td>
																				<div class="dropdown" style="width: 100%; height: 30px;">
																				<!-- <button class="dropbtn" style="width: 100%; height: 25px;  background-color:#d6e3c1;">Lines</button>-->
																				<strong>Lines</strong>
																				<div class="dropdown-content">
																				<a href="viewLineSummary?id=UVAP&dd=DISTRIBUTION DIVISION 3&province=UVA PROVINCE">UVAP</a>
																				<a href="viewLineSummary?id=WPSII&dd=DISTRIBUTION DIVISION 3&province=WESTERN PROVINCE SOUTH - II">WPSII</a>
																				<a href="viewLineSummary?id=SABP&dd=DISTRIBUTION DIVISION 3&province=SABARAGAMUWA PROVINCE">SABP</a>
																				
																				<!-- <a href="viewLineSummary?id=UVA&dd=DISTRIBUTION DIVISION 3&province=UVA PROVINCE">UVA</a>
																				<a href="viewLineSummary?id=SAB&dd=DISTRIBUTION DIVISION 3&province=SABARAGAMUWA PROVINCE">SAB</a>
																				<a href="viewLineSummary?id=WPSII&dd=DISTRIBUTION DIVISION 3&province=WESTERN PROVINCE SOUTH II">WPS II</a>
																				 -->
																				</div>
																				
																				</div>
																				
																				
																				<!-- <strong><a href="viewLineSummary?id=CP&dd=DISTRIBUTION DIVISION 2&province=CENTRAL PROVINCE">Lines</a></strong>--></td>
																				<td><strong>${summary[0]}</strong></td>

																			</tr>
																			<tr>
																				<td><strong>Line length</strong></td>
																				<td><strong>${summary[1]}</strong></td>

																			</tr>
																			<tr>
																				<td><strong>Towers</strong></td>
																				<td><strong>${summary[2]}</strong></td>
																			</tr>
																			<tr>
																				<td><strong>Poles</strong></td>
																				<td><strong>${summary[3]}</strong></td>
																			</tr>
																			</c:if>
																			

																		</c:forEach>
																	</table>
																</div>
															</div>
														</div>
													</div>
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
													<i class="fa fa-info-circle" style="color: #008080"></i>
												</center>
												<h4>
													<center>
															<strong>Master Information</strong>
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
																		href="viewEarthConTypes">View Earth Conductor type</a>
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
																	<a href="viewLineNew">View Line</a> <a href="viewSupportNew">View
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
																	<a href="viewTMnewApprove">Tower Maintenance</a>
																	 <a href="#">Insulator Maintenance</a>
																	<a href="downloadAPK">Download APK</a>
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

									<div class="col-lg-4 col-sm-6 col-xs-12">
										<div class="wrimagecard wrimagecard-topimage">
											<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
												<center>
													<i class="fa fa-cogs" style="color: #008080"></i>
												</center>
												<h4>
													<center>
															<strong>Maintenance Planning </strong>
														</center>
												</h4>
												
												<div style="height: 220px">
													<h4>
														<strong><br></strong>
													</h4>

													<tr>
													<c:if test="${sessionScope.loggedUserRole =='EE' || sessionScope.loggedUserRole =='CE' || sessionScope.loggedUserRole =='AGM'}">
														<div class="dropdown " style="width: 100%; height: 50px;">
															<button class="dropbtn">Approve Data</button>
															<div class="dropdown-content">
																<a href="displayLineNew">Line</a> 
																<a href="displaySupportNew">Support</a> 
																<a href="editTMnew">Maintenance Data</a>
																
																<a href="mntCompletion">Completion Data</a>
																<a href="addCycle">Manage Cycle</a>
																<a href="downloadPlan">Maintenance Plan 2020</a>
																
															</div>
														</div>
														</c:if>
														<c:if test="${sessionScope.loggedUserRole =='ES'}">
														<div class="dropdown " style="width: 100%; height: 50px;">
															<button class="dropbtn">Validate Data</button>
															<div class="dropdown-content">
																<a href="displayLineNew">Line</a> 
																<a href="displaySupportNew">Support</a> 
																<a href="editTMnew">Maintenance Data</a>
																<a href="mntCompletion">Completion Data </a>
																<a href="downloadPlan">Maintenance Plan 2020</a>
																
															</div>
														</div>
														</c:if>
														<c:if test="${sessionScope.loggedUserRole =='DEO'}">
														<div class="dropdown " style="width: 100%; height: 50px;">
															<button class="dropbtn">Send for Validation</button>
															<div class="dropdown-content">
																<a href="displayLineNew">Line</a> 
																<a href="displaySupportNew">Support</a> 
																<a href="editTMnew">Maintenance Data</a>
																</div>
														</div>
														</c:if>
													</tr>
													<br> <br>
													
													<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">Work Estimates</button>
															<div class="dropdown-content">
																<a href="goToViewInsEstimate">Inspection Estimate</a> 
																<a href="goToViewInsEstimateHOT">HotLine Maintenance Estimate</a> 
																<a href="goToViewInsEstimateCOLD">Cold Line Estimate</a>
															</div>
														</div>

													</tr>
													<br> <br>

													<tr>
													
														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">History Analysis</button>
															<div class="dropdown-content">
																<a href="ViewScheduleAndReport?mode=HAR">Cycle Wise Data Storage 1</a> 
																<a href="ViewScheduleAndReport?mode=HAR2">Cycle Wise Data Storage 2</a> 
																
																	<a href="">Tower Line Failure Rates</a>
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

<c:if test="${sessionScope.loggedUserRole =='ES' || sessionScope.loggedUserRole =='EE' || sessionScope.loggedUserRole =='CE' || sessionScope.loggedUserRole =='AGM'}">
													
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
																<a href="breakDownMNT?mode=INS">Forward Inspection Request</a> 
																<a href="viewAllInspectionMntRequest?mode=INS">View Inspection Request Status</a> 
																
															</div>
														</div>
														
													</tr>
													<br> <br>
													<tr>
													
														<div class="dropdown " style="width: 100%; height: 50px;">
															<button class="dropbtn">Maintenance Request</button>
															<div class="dropdown-content">
																<a href="breakDownMNT?mode=MNT">Forward Maintenance Request</a> 
																<a href="viewAllInspectionMntRequest?mode=MNT">View Maintenance Request Status</a> 
																
															</div>
														</div>
														
													</tr>
													<br> <br>
													
													<tr>
													
													<div class="dropdown " style="width: 100%; height: 50px;">
															<button class="dropbtn">Interruption Request</button>
															<div class="dropdown-content">
															<c:if test="${sessionScope.loggedUserRole =='EE'}">
															
																<a href="displayAllINSReq?mode=INT">Forward Request</a> 
																<a href="viewAllInspectionMntRequest?mode=INT">View Interruption Request Status</a> 
																<a href="ViewScheduleAndReport?mode=INTSUM">Interruption Request Summary Report</a> 
															<a href="RequestStatus">Request Status</a>
								
															</c:if>	
															<c:if test="${sessionScope.loggedUserRole =='ES'}">
															
																<a href="goToInterruptionRequest?mode=INTERRUPTION">Generate Interruption Request</a> 
																<a href="viewAllInspectionMntRequest?mode=INT">View Interruption Request Status</a> 
															<a href="RequestStatus">Request Status</a>
								
															</c:if>	
															
															</div>
														</div>
														
													
													

														
													</tr>
													<br> <br>

													<!-- <tr>
													
														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">PTW Request</button>
															<div class="dropdown-content">
																<a href="#">Area</a> 
																	<a href="#">Line</a>
															</div>
														</div>

													</tr>
 -->
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
																<a href="downloadIntSum">Interruption Request Summary Report</a> 
																<a href="#">Inspection History Report</a> 
																<a href="estimateSPSReport">SPS Report</a> 
																
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
																<a href="ViewPESummaryReport?mode=PECIRCONT">Circuit/Conductor Type</a> 
																
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
								</div>
							</div>
						</div>
					</div>



				</div>
			</div>
		</div>
	</div>
	<%@ include file="sections/footer.jsp"%>
	<%@ include file="sections/global_scripts.jsp"%>
	
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModal" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h4 class="modal-title" id="myModalLabel">View Tower Maintenance Data</h4>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">×</span>
		        </button>
		      </div>
		       <div class="modal-content">
                                <label>Maintenance Details</label><br>
                                <p1>Fungus Sets:<label id="fungussets">fungussets</label></p1><br>
                                <p1>Flash Over Sets:<label id="flashoversets">flashoversets</label></p1><br>
                                <p1>W Pin Sets:<label id="wpinsets">wpinsets</label></p1><br>
                                <p1>End Fitting Sets:<label id="endfittingsets">endfittingsets</label></p1><br>
                                <p1>Jumper Status:<label id="jumperstatus">jumperstatus</label></p1><br>
                                <p1>Conductor Condition:<label id="conductorcondition">conductorcondition</label></p1><br>
                                <p1>Earth Conductor Condition:<label id="earthconductorcondition">earthconductorcondition</label></p1><br>
                                <p1>Missing Members:<label id="missingmembers">missingmembers</label></p1><br>
                                <p1>Anti Climbing Status:<label id="anticlimbingstatus">anticlimbingstatus</label></p1><br>
                                <p1>Leg Painting Requirement:<label id="legpaintingrequirement">legpaintingrequirement</label></p1><br>
                                <p1>Base Concrete Status:<label id="baseconcretestatus">baseconcretestatus</label></p1><br>
                                <p1>Way leave status:<label id="wayleavestatus">wayleavestatus</label></p1><br>
                                <p1>Special Observations:<label id="specialobservations">specialobservations</label></p1><br>
                                <p1>Maintenance Attention:<label id="maintenanceattention">maintenanceattention</label></p1><br>
                                <p1>Hot Line Possibility:<label id="hotlinepossibility">hotlinepossibility</label></p1><br>
                                
                             </div>

		      <div class="modal-footer">
		        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		  </div>
		</div>

		

	
	
	
	
</body>
</html>