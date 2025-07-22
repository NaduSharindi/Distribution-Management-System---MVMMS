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

.dropdown-content1 {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
	width: 100%;
	text-align: right;
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

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
//Load the Visualization API and the piechart package.

//google.charts.load('current', {'packages':['corechart']});
//google.charts.setOnLoadCallback(drawChart);

google.charts.load('current', {'packages':['corechart', 'controls']});
google.charts.setOnLoadCallback(drawDashboard);


function drawDashboard() {
	  
	 var strArea = area.options[area.selectedIndex].value;
	 var strDiv = divison.options[divison.selectedIndex].value;
	 var strProvince = province.options[province.selectedIndex].value;
	
    	  
    	  $.ajax({
  			type : 'GET',
  			url : "/MMS/divisionalSummaryDPA/" + strDiv +"/" +strProvince+ "/" +strArea+ "/",
			data : {},
  			contentType : "application/json; charset=utf-8",
  			success : function(result) {
  				
  				var datavalue = new google.visualization.DataTable();
				datavalue.addColumn('string', 'Name');
				datavalue.addColumn('number', 'No. Transformer');
				
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
  		        	'filterColumnLabel': 'No. Transformer'
  		          }
  		        });
  		        

  		        // Create a pie chart, passing some options
  		        var pieChart = new google.visualization.ChartWrapper({
  		          'chartType': 'PieChart',
  		          'containerId': 'piechart_values',
  		          'options': {
  		            'height': 400,
  		            'pieSliceText': 'value',
  		            'legend': 'right'
  		          }
  		        });
  		        
  		       var table = new google.visualization.ChartWrapper({
		          'chartType': 'Table',
		          'containerId': 'table_div',
		          'options': {
		            'height': 400,
		            'pieSliceText': 'value',
		            'legend': 'right'
		          }
		        });
 
  		    var bar = new google.visualization.ChartWrapper({
		          'chartType': 'ColumnChart',
		          'containerId': 'barchart_values',
		          'options': {
		            'pieSliceText': 'value',
		            'legend': 'right'
		          }
		        });


  		        
  		      

  		        // Establish dependencies, declaring that 'filter' drives 'pieChart',
  		        // so that the pie chart will only display entries that are let through
  		        // given the chosen slider range.
  		        dashboard.bind(donutRangeSlider, pieChart);
  		      dashboard.bind(donutRangeSlider, table);
  		    dashboard.bind(donutRangeSlider, bar);
		     
  		        // Draw the dashboard.
  		        dashboard.draw(datavalue);
  		      //dashboard.draw(datavaluefortable);
		        
  			    
  			}
  		});
    	  
    	  
    	  
    	  
    	  
    	  $.ajax({
    			type : 'GET',
    			url : "/MMS/getSummaryTransformerOilDPA/" + strDiv +"/" +strProvince+ "/" +strArea+ "/",
    			data : {},
    			contentType : "application/json; charset=utf-8",
    			success : function(result) {
    				
    				var datavalue = new google.visualization.DataTable();
    				datavalue.addColumn('string', 'Name');
    				datavalue.addColumn('number', 'Weight Transformer(kg) ');
    				datavalue.addColumn('number', 'oilWeight(kg)');
    				
    				for (var i = 0; i < result.length; i++) {
    						var data = result[i];
    						datavalue.addRows([[data[3], data[1],data[2]]]);
    				}
    				 
    			    
    				 
    			     // Create a dashboard.
    		        var dashboard = new google.visualization.Dashboard(
    		            document.getElementById('dashboard_div'));

    		        // Create a range slider, passing some options
    		        var donutRangeSlider = new google.visualization.ControlWrapper({
    		          'controlType': 'CategoryFilter',
    		          'containerId': 'filter_div5',
    		          'options': {
    		        	'filterColumnLabel': 'Name'
    		          }
    		        });
    		        

    		        
    		       var table = new google.visualization.ChartWrapper({
  		          'chartType': 'Table',
  		          'containerId': 'tablechart_valuesoil',
  		          'options': {
  		            'height': 400,
  		            'pieSliceText': 'value',
  		            'legend': 'right'
  		          }
  		        });
   
    		    

    		        
    		      

    		        // Establish dependencies, declaring that 'filter' drives 'pieChart',
    		        // so that the pie chart will only display entries that are let through
    		        // given the chosen slider range.
    		        dashboard.bind(donutRangeSlider, table);
    		   
    		        // Draw the dashboard.
    		        dashboard.draw(datavalue);
    		      //dashboard.draw(datavaluefortable);
  		        
    			    
    			}
    		});

    	  
    	  
    	   /* $.ajax({
  			type : 'GET',
  			url : "/PCB/divisionalSummary",
  			data : {},
  			contentType : "application/json; charset=utf-8",
  			success : function(result) {
  				var datavalue = new google.visualization.DataTable();
  				datavalue.addColumn('string', 'Name');
  				datavalue.addColumn('number', 'No. Transformer');
  				
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
  		        	'filterColumnLabel': 'No. Transformer'
  		          }
  		        });
  		        

  		        // Create a pie chart, passing some options
  		        var pieChart = new google.visualization.ChartWrapper({
  		          'chartType': 'PieChart',
  		          'containerId': 'piechart_valuesisland',
  		          'options': {
  		            'width': 230,
  		            'height': 210,
  		            'pieSliceText': 'value',
  		            'legend': 'right'
  		          }
  		        });
 
  		      dashboard.bind(donutRangeSlider, pieChart);
  		      dashboard.draw(datavalue);
		        
  			    
  			    
  			}
  		});
    	   
    	   
    	   
 */     	  
 $.ajax({
		type : 'GET',
		url : "/MMS/getSummaryTransformerOilDPA/" + strDiv +"/" +strProvince+ "/" +strArea+ "/",
		data : {},
		contentType : "application/json; charset=utf-8",
		success : function(result) {
			var datavalue = new google.visualization.DataTable();
			datavalue.addColumn('string', 'Name');
			datavalue.addColumn('number', 'Weight Transformer(kg) ');
			datavalue.addColumn('number', 'oilWeight(kg)');
			
			for (var i = 0; i < result.length; i++) {
					var data = result[i];
					datavalue.addRows([[data[3], data[1],data[2]]]);
			}
			 
		     var options = {
		             title: 'Oil Volume % of Contamination',
		             is3D : true,
		             pieSliceText: 'label',
		             tooltip :  {showColorCode: true},
				     'height' : 400
		         };
		     
		     		     
		    var chart = new google.visualization.ColumnChart(document.getElementById('piechart_valuesoil'));
		    chart.draw(datavalue, options);
		    
		  
		    
		}
	});

    	  $.ajax({
    			type : 'GET',
    			url : "/MMS/divisionalSummary",
      			data : {},
    			contentType : "application/json; charset=utf-8",
    			success : function(result) {
    				var datavalue = new google.visualization.DataTable();
    				datavalue.addColumn('string', 'Name');
    				datavalue.addColumn('number', 'Count');
    				
    				for (var i = 0; i < result.length; i++) {
    						var data = result[i];
    						datavalue.addRows([[data[1], data[0]]]);
    				}
    				 
    			     var options = {
    			             title: 'Sampled No. of Transformers -Island Result',
    			             is3D : true,
    			             pieSliceText: 'label',
    			             tooltip :  {showColorCode: true},
    					     'height' : 400
    			         };
    			     
    			    var chart = new google.visualization.PieChart(document.getElementById('piechart_valuesisland'));
    			    chart.draw(datavalue, options);
    			    
    			    
    			    
    			}
    		});
        
    	  
    	  
    	  
    	  $.ajax({
  			type : 'GET',
  			url : "/MMS/divisionalSummarySampleDPA/" + strDiv +"/" +strProvince+ "/" +strArea+ "/",
  			data : {},
  			contentType : "application/json; charset=utf-8",
  			success : function(result) {
  				var datavalue = new google.visualization.DataTable();
  				datavalue.addColumn('string', 'Name');
  				datavalue.addColumn('number', 'Count');
  				
  				for (var i = 0; i < result.length; i++) {
  						var data = result[i];
  						datavalue.addRows([[data[1], data[0]]]);
  				}
  				 
  			     var options = {
  			             title: 'Sampled No. of Transformers',
  			             is3D : true,
  			             pieSliceText: 'label',
  			             tooltip :  {showColorCode: true},
  					     'height' : 400
  			         };
  			     
  			    var chart = new google.visualization.PieChart(document.getElementById('piechart_valuestwo'));
  			   
  			    chart.draw(datavalue, options);
  			    
  			    
  			    
  			}
  		});
      
    	  
    	  
    	 /*  $.ajax({
  			type : 'GET',
  			url : "/PCB/divisionalSummarySampleDPA/" + strDiv +"/" +strProvince+ "/" +strArea+ "/",
  			data : {},
  			contentType : "application/json; charset=utf-8",
  			success : function(result) {
  				var datavalue = new google.visualization.DataTable();
  				datavalue.addColumn('string', 'Name');
  				datavalue.addColumn('number', 'No. Transformer');
  				
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
  		        	'filterColumnLabel': 'No. Transformer'
  		          }
  		        });
  		        

  		        // Create a pie chart, passing some options
  		        var pieChart = new google.visualization.ChartWrapper({
  		          'chartType': 'PieChart',
  		          'containerId': 'piechart_valuestwo',
  		          'options': {
  		            'width': 230,
  		            'height': 210,
  		            'pieSliceText': 'value',
  		            'legend': 'right'
  		          }
  		        });
 
  		      dashboard.bind(donutRangeSlider, pieChart);
  		      dashboard.draw(datavalue);

  			    
  			    
  			    
  			}
  		});
 */    	  
    	  
    	  $.ajax({
  			type : 'GET',
  			url : "/MMS/getSummaryTransformerScreeningDPA/" + strDiv +"/" +strProvince+ "/" +strArea+ "/",
  			data : {},
  			contentType : "application/json; charset=utf-8",
  			success : function(result) {
  				var datavalue = new google.visualization.DataTable();
  				datavalue.addColumn('string', 'Name');
  				datavalue.addColumn('number', 'Count');
  				
  				for (var i = 0; i < result.length; i++) {
  						var data = result[i];
  						datavalue.addRows([[data[1], data[0]]]);
  				}
  				 
  			     var options = {
  			             title: 'Screening Test (+)Ve Transformers',
  			             is3D : true,
  			             pieSliceText: 'label',
  			             tooltip :  {showColorCode: true},
  					     'height' : 400
  			         };
  			     
  			    var chart = new google.visualization.PieChart(document.getElementById('piechart_valuesthree'));
  			    chart.draw(datavalue, options);
  			    
  			    
  			    
  			}
  		});
      
    	  
    	  
    	  /* $.ajax({
  			type : 'GET',
  			url : "/PCB/getSummaryTransformerScreeningDPA/" + strDiv +"/" +strProvince+ "/" +strArea+ "/",
  			data : {},
  			contentType : "application/json; charset=utf-8",
  			success : function(result) {
  				var datavalue = new google.visualization.DataTable();
  				datavalue.addColumn('string', 'Name');
  				datavalue.addColumn('number', 'No. Transformer');
  				
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
  		        	'filterColumnLabel': 'No. Transformer'
  		          }
  		        });
  		        

  		        // Create a pie chart, passing some options
  		        var pieChart = new google.visualization.ChartWrapper({
  		          'chartType': 'PieChart',
  		          'containerId': 'piechart_valuesthree',
  		          'options': {
  		            'width': 230,
  		            'height': 210,
  		            'pieSliceText': 'value',
  		            'legend': 'right'
  		          }
  		        });
 
  		      dashboard.bind(donutRangeSlider, pieChart);
  		      dashboard.draw(datavalue);
 
  				}
  		});
 */       
/*        $.ajax({
  			type : 'GET',
  			url : "/PCB/divisionalSummaryItiPositive",
  			data : {},
  			contentType : "application/json; charset=utf-8",
  			success : function(result) {
  				var datavalue = new google.visualization.DataTable();
  				datavalue.addColumn('string', 'Name');
  				datavalue.addColumn('number', 'No. Transformer');
  				
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
  		        	'filterColumnLabel': 'No. Transformer'
  		          }
  		        });
  		        

  		        // Create a pie chart, passing some options
  		        var pieChart = new google.visualization.ChartWrapper({
  		          'chartType': 'PieChart',
  		          'containerId': 'piechart_valuesfour',
  		          'options': {
  		            'width': 230,
  		            'height': 210,
  		            'pieSliceText': 'value',
  		            'legend': 'right'
  		          }
  		        });
 
  		      dashboard.bind(donutRangeSlider, pieChart);
  		      dashboard.draw(datavalue);

  			}
  		}); */

    	  
    	  
    	  
       $.ajax({
			type : 'GET',
			url : "/MMS/divisionalSummaryItiPositive",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				var datavalue = new google.visualization.DataTable();
				datavalue.addColumn('string', 'Name');
				datavalue.addColumn('number', 'Count');
				
				for (var i = 0; i < result.length; i++) {
						var data = result[i];
						datavalue.addRows([[data[1], data[0]]]);
				}
				 
			     var options = {
			             title: 'Numbers Confirmed by ITI',
			             is3D : true,
			             pieSliceText: 'label',
			             tooltip :  {showColorCode: true},
					     'height' : 400
			         };
			     
			    var chart = new google.visualization.PieChart(document.getElementById('piechart_valuesfour'));
			    chart.draw(datavalue, options);
			    
			    
			    
			}
		});

      
    	  
    	  
    	  

} 





function drawChart() {
    // Create the data table.
    
     var strArea = area.options[area.selectedIndex].value;
		var strDiv = divison.options[divison.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
	//alert("area"+strArea+"area");
	//alert("div"+strDiv+"div");
	//alert("pro"+strProvince+"pro");
    
     $.ajax({
					type : 'GET',
					url : "/MMS/divisionalSummaryDPA/" + strDiv +"/" +strProvince+ "/" +strArea+ "/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(result) {
						var datavalue = new google.visualization.DataTable();
						datavalue.addColumn('string', 'Name');
						datavalue.addColumn('number', 'Count');
						
						for (var i = 0; i < result.length; i++) {
								var data = result[i];
								datavalue.addRows([[data[1], data[0]]]);
								   
								
								
								
						}
						 
					     var options = {
					             title: 'Transformer Inventory',
					             is3D : true,
					             pieSliceText: 'label',
					             tooltip :  {showColorCode: true}
							     
					         };
					     
					      var baroptions = {
					    	        title: "Transformer Inventory",
					    	        bar: {groupWidth: "95%"},
					    	        legend: { position: "none" },
					    	      };
					    

var columnoptions = {
						            title: "Transformer Inventory",
						            bar: {groupWidth: "95%"},
						            legend: { position: "none" },
						          }; 
 
					    var chart = new google.visualization.PieChart(document.getElementById('piechart_values'));
					    chart.draw(datavalue, options);
					     var barchart = new google.visualization.BarChart(document.getElementById("barchart_values"));
					    var columnchart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
					    columnchart.draw(datavalue, columnoptions);
					    barchart.draw(datavalue, baroptions);
 
					    
					    
					}
				});
    
    
     $.ajax({
			type : 'GET',
			url : "/MMS/divisionalSummarySampleDPA/" + strDiv +"/" +strProvince+ "/" +strArea+ "/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				var datavalue = new google.visualization.DataTable();
				datavalue.addColumn('string', 'Name');
				datavalue.addColumn('number', 'Count');
				
				for (var i = 0; i < result.length; i++) {
						var data = result[i];
						datavalue.addRows([[data[1], data[0]]]);
				}
				 
			     var options = {
			             title: 'Sampled No. of Transformers',
			             is3D : true,
			             pieSliceText: 'label',
			             tooltip :  {showColorCode: true},
					     'width' : 230,
					     'height' : 210
			         };
			     
			    var chart = new google.visualization.PieChart(document.getElementById('piechart_valuestwo'));
			    chart.draw(datavalue, options);
			    
			    
			    
			}
		});
     
     $.ajax({
			type : 'GET',
			url : "/MMS/getSummaryTransformerScreeningDPA/" + strDiv +"/" +strProvince+ "/" +strArea+ "/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				var datavalue = new google.visualization.DataTable();
				datavalue.addColumn('string', 'Name');
				datavalue.addColumn('number', 'Count');
				
				for (var i = 0; i < result.length; i++) {
						var data = result[i];
						datavalue.addRows([[data[1], data[0]]]);
				}
				 
			     var options = {
			             title: 'Screening Test (+)Ve Transformers',
			             is3D : true,
			             pieSliceText: 'label',
			             tooltip :  {showColorCode: true},
					     'width' : 230,
					     'height' : 210
			         };
			     
			    var chart = new google.visualization.PieChart(document.getElementById('piechart_valuesthree'));
			    chart.draw(datavalue, options);
			    
			    
			    
			}
		});
     
     $.ajax({
			type : 'GET',
			url : "/MMS/divisionalSummaryItiPositive",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				var datavalue = new google.visualization.DataTable();
				datavalue.addColumn('string', 'Name');
				datavalue.addColumn('number', 'Count');
				
				for (var i = 0; i < result.length; i++) {
						var data = result[i];
						datavalue.addRows([[data[1], data[0]]]);
				}
				 
			     var options = {
			             title: 'Numbers Confirmed by ITI',
			             is3D : true,
			             pieSliceText: 'label',
			             tooltip :  {showColorCode: true},
					     'width' : 230,
					     'height' : 210
			         };
			     
			    var chart = new google.visualization.PieChart(document.getElementById('piechart_valuesfour'));
			    chart.draw(datavalue, options);
			    
			    
			    
			}
		});



    
}


function DivSummary(){
	//alert('hiiii');
	
	var strArea = area.options[area.selectedIndex].value;
	var strDiv = divison.options[divison.selectedIndex].value;
	var strProvince = province.options[province.selectedIndex].value;
   // alert('hiii1');
	
	var url="downloadDivisionalSummary?mode=DS1&division="+strDiv+"&province="+strProvince+"&area="+strArea;
	    var width = 1100;
	    var height = 700;
	    var left = parseInt((screen.availWidth/2) - (width/2));
	    var top = parseInt((screen.availHeight/2) - (height/2));
	    var windowFeatures = "width=" + width + ",height=" + height + 
	    ",status,resizable,left=" + left + ",top=" + top +
	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");

}

function DivSummary1(){
	var strArea = area.options[area.selectedIndex].value;
	var strDiv = divison.options[divison.selectedIndex].value;
	var strProvince = province.options[province.selectedIndex].value;

	
	var url="downloadDivisionalSummary?mode=DS2&division="+strDiv+"&province="+strProvince+"&area="+strArea;
	    var width = 1100;
	    var height = 700;
	    var left = parseInt((screen.availWidth/2) - (width/2));
	    var top = parseInt((screen.availHeight/2) - (height/2));
	    var windowFeatures = "width=" + width + ",height=" + height + 
	    ",status,resizable,left=" + left + ",top=" + top +
	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");

}
function DivSummary2(){
	var strArea = area.options[area.selectedIndex].value;
	var strDiv = divison.options[divison.selectedIndex].value;
	var strProvince = province.options[province.selectedIndex].value;


	
	var url="downloadDivisionalSummary?mode=DS3&division="+strDiv+"&province="+strProvince+"&area="+strArea;
	    var width = 1100;
	    var height = 700;
	    var left = parseInt((screen.availWidth/2) - (width/2));
	    var top = parseInt((screen.availHeight/2) - (height/2));
	    var windowFeatures = "width=" + width + ",height=" + height + 
	    ",status,resizable,left=" + left + ",top=" + top +
	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");

}

function DivSummary3(){
	var strArea = area.options[area.selectedIndex].value;
	var strDiv = divison.options[divison.selectedIndex].value;
	var strProvince = province.options[province.selectedIndex].value;


	
	var url="downloadDivisionalSummary?mode=DS4&division="+strDiv+"&province="+strProvince+"&area="+strArea;
	    var width = 1100;
	    var height = 700;
	    var left = parseInt((screen.availWidth/2) - (width/2));
	    var top = parseInt((screen.availHeight/2) - (height/2));
	    var windowFeatures = "width=" + width + ",height=" + height + 
	    ",status,resizable,left=" + left + ",top=" + top +
	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");

}







</script>




<!-- <script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c">
	
</script>
 -->
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap"></script>

<script type="text/javascript">
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
             
             
             //document.getElementById("txtGpsLatitude").value = position.coords.latitude;
             //document.getElementById("txtGpsLongitude").value = position.coords.longitude;
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
			//drawDashboard();
		}else{
			loadNetwork();
		}
		
	}

	function loadMap() {
		//alert('hiiiloadMap');
		var map = new google.maps.Map(document.getElementById("map_container"), {
          //center: new google.maps.LatLng(7.2665013,80.541458),
          center: new google.maps.LatLng(7.873054,80.771797),
          zoom: 12,
          gestureHandling: 'greedy',
          mapTypeId: google.maps.MapTypeId.ROADMAP
        });

		var infoWindow = new google.maps.InfoWindow();
		var strArea = area.options[area.selectedIndex].value;
		var strDiv = divison.options[divison.selectedIndex].value;
		var strProvince = province.options[province.selectedIndex].value;
		
		//variables for get the move location
		//alert('hiii: ' + strDiv + strProvince +strArea );
		
		var bounds = new google.maps.LatLngBounds();
		//alert('hiii: ' + bounds );
		$.ajax
        ({
                type: 'GET',
                url: "/MMS/MapNewPCB/" + strDiv +"/" +strProvince+ "/" +strArea+ "/",
                data: {},
                contentType: "application/json; charset=utf-8",
                success : function(json){
                	//alert(json.length);
                	
                		for (var i = 0, length = json.length; i < length; i++) {
        					var data = json[i],
        					
        					//if(data[1].gpsLatitude !== null) {
        						//if( data[1].gpsLatitude !== ''){
                			
        						latLng = new google.maps.LatLng(data[1].gpsLatitude, data[1].gpsLongitude);
        						//alert('huuuuuuu'+ data[1].gpsLatitude);
        						//if(data[1].gpsLatitude !== null){
        							//if( data[1].gpsLatitude !== ''){
        								//if( data[1].gpsLatitude !== 0){
        						bounds.extend(latLng);
        						//}
        						//}
        						//}
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
								  /* if(data[0].supportType == 1){
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
										*/
								  if(data[2].pcbTestDataAroclor > 50){
										var marker = new google.maps.Marker({
    	            						position: latLng,
    	            						map: map,
    	            						icon: '<c:url value="/resources/img/CEBImages/trred.png"/>',
    	            						
    	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
    	            					});
								  }else{
										//alert("test13 : "+ data.area);
	            			 			var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
	            						//marker.setIcon(zoomIcons[map.getZoom()]);
	            						//icon: 'http://labs.google.com/ridefinder/images/mm_20_green.png'
	            						icon: '<c:url value="/resources/img/CEBImages/trgreen.png"/>'
    	            						
	            						//title: "Click here to view details of Tower ID "+data.equipmentId,
	            						//label: { color: '#FAF8F8', fontWeight: 'bold', fontSize: '14px', text: '' }
	            					});
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
							/* 	var supType;
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
								"</table></div>";
 */								

	
        						google.maps.event.addListener(marker, "click", function(e) {

            						

        							infoWindow.setContent("<b>Tr number:  </b>"+
        								data[0].referenceNo+"</br>"+"<b>Location Description:</b>"+
        								"<br><button type='button' id='myBtn'  onClick='viewEstimate(\"" + data[0].referenceNo + "\")'>More Info</button> "+
    									
        								data[1].locationDescription+"</br>"+
	            						"</br>"+"<b>Serial Number : </b>"+
	            						data[0].serialNo+"</br>"+"<b>kVA Rating :</b>"+
	            						data[0].capacity+"</br>");
	            							
	            							//infoWindow.setContent(data[0].referenceNo);
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
        					//}
                		//}
                
                
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
                url: "/MMS/MapNew/" + strArea +"/" + strLine +"/"+strProvince,
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
							if(data[1].nooftappings > 0 ){

								//alert("data.tapping");
								var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
            						//marker.setIcon(zoomIcons[map.getZoom()]);
            						icon: 'http://www.google.com/mapfiles/topbar.png',
            						title: "Click here to view details of Tower ID "+data[0].towerNo + " ID " + data[0].id
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
        					          scale: 0
        					    }
        					});
                		}
        					//data.gpsLatitude, data.gpsLongitude
        					//	alert('ID : ' + json[i].id +'next id: ' + json[i+1].id);
        					
        					var towerid = data[0].id;
        					var lineid = data[0].lineId;
        					//alert('towerid:' +towerid + 'line id: '+ lineid);
        					var firstObj = json[i];
        					var secondObj = json[i+1];

        					if(firstObj[0].lineId == secondObj[0].lineId){
        						 var flightPlanCoordinates = [
            					                              {lat: firstObj[0].gpsLatitude, lng: firstObj[0].gpsLongitude},
            					                              {lat: secondObj[0].gpsLatitude, lng: secondObj[0].gpsLongitude}
            					                              
            					                            ];
        						 var flightPath = new google.maps.Polyline({
		                              path: flightPlanCoordinates,
		                              geodesic: true,
		                              strokeColor: '#FF0000',
		                              strokeOpacity: 1.0,
		                              strokeWeight: 2
		                            });
           						flightPath.setMap(map);

		                            
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
									
								
var lineType;
if(data[4].lineType ==1){
lineType ='Backbone';
}else{
lineType ='Distributors';
}
        						var supType;
								if(data[0].supportType == 1){
									supType = 'Tower';
								}else if(data[0].supportType == 2){
									supType = 'Pole';
								}else if(data[0].supportType == 3){
									supType = 'Gantry Bay';
								}else{
									supType = 'GSS Bay';
								} 
								 var conType;
								 if(data.conductorType == 1){
									 conType = 'TDL';
								 }else if(data.conductorType == 2){
									 conType = 'Racoon';
								 }else if(data.conductorType == 3){
									 conType = 'ELM';
								 }else if(data.conductorType == 4){
									 conType = 'Tiger';
								 }else if(data.conductorType == 5){
									 conType = 'Dog';
								 }else if(data.conductorType == 6){
									 conType = 'Lynx';
								 }else if(data.conductorType == 7){
									 conType = 'COPPER';
								 }else if(data.conductorType == 8){
									 conType = 'Catmion coper';
								 }else if(data.conductorType == 9){
									 conType = 'Coyote';
								 }else{
									 conType = 'Other';
								 }
								       						       
								var contentString = "<div style='float:right; padding: 10px;'><table id ='ss'><tr><div style='float:left'><img src='<c:url value="/resources/img/CEBImages/line.png"/>'></div><tr><th>Line Info</th></tr><tr><td>Line Code : </td><td>"+
								data[4].code+"</td></tr><tr><td>Area : </td><td>"+
								data[4].area+"</td></tr><tr><td>Com Date :  </td><td>"+
								data[4].comdate+"</td></tr><tr><td>Length :  </td><td>"+
								data[4].length+"</td></tr><tr><td>Line Name :  </td><td>"+
								data[4].lineName+"</td></tr>"+
								"<tr><td>Line Type :  </td><td>"+lineType+"</td></tr>"+
								"<tr><td>No of Poles :  </td><td>"+data[4].noofpoles+"</td></tr>"+
								"<tr><td>No of Towers :  </td><td>"+data[4].nooftowers+"</td></tr>"+
								"</tr><tr><th>Tapping Info</th></tr><tr><td>Tower Number : </td><td>"+
								data[0].towerNo+"</td></tr><tr><td>Area : </td><td>"+
								data[0].area+"</td></tr><tr><td>Support type :  </td><td>"+
								supType+"</td></tr><tr><td>Latitude :  </td><td>"+
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
								"<tr><td><a href='<c:url value="/addSupportNew?id=49"/>'>Add New Support</a></td><td></td></tr>"+
								
								"</table></div>";

	
        						google.maps.event.addListener(marker, "click", function(e) {

        							infoWindow.setContent(contentString);
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
						var slctSubcat = $('#line'), option = "<option value='NONE'>LINE</option>";
						slctSubcat.empty();
						for (var i = 0; i < data.length; i++) {
							option = option
									+ "<option value='"+data[i].code + "'>"
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
		/* if(strUser == "DD1"){
			strUser = "DISCO1";
		}else if(strUser == "DD2"){
			strUser = "DISCO2";
		}
		 *///alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$.ajax({
					type : 'GET',
					url : "/MMS/findAllAreaByProvinceNew/" + strUser,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#area'), option = "<option value='NONE'>AREA</option><option value='ST'>STORES</option>";
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

	function findProvinceByDivision() {
		//var categoryId = $(this).val();
	//	alert("hiii");
		var division = divison.options[divison.selectedIndex].value;
		/* if(division == "DD1"){
			division = "DISCO1";
		}else if(division == "DD2"){
			division = "DISCO2";
		}else if(division == "DD3"){
			division = "DISCO3";
		}
		else if(division == "DD4"){
			division = "DISCO4";
		}
		 */
		
		//alert(division);
		
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$.ajax({
					type : 'GET',
					url : "/MMS/findAllProvincsPCB/" + division+"/",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#province'), option = "<option value='NONE'>PROVINCE</option>";
						slctSubcat.empty();
						for (var i = 0; i < data.length; i++) {
							option = option
									+ "<option value='"+data[i].compId + "'>"
									+ data[i].compNm + "</option>";
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
	function viewEstimate(estimateNo){
   	 var url="ViewTransformerData?referenceNo="+estimateNo;
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



					<div class="container">

						<div class="jumbotron">

							<div class="row ">

<!-- <div class="col-sm-12" align="left">
									<div class="row">
									
									

										<input id ='showBtn' type='button' class='btn btn-success' value='Show Options' onClick='myFunction()'></input>

									</div>
								</div>
 -->							

								<div  class="col-sm-12" align="left">
									<div class="row">
										<form:form method="post" action="viewSupportByProvince"
											modelAttribute="model">

											<div class="col-lg-12">

												<%-- <div class="row">
													<div class="drop-down-padding">
														<div class="col-xs-12" align="right">
															<form:select id="province" path="glcompmobj.compId"
																onchange="findArea()"
																style="width:100%; background-color: #FFFFF; border-radius: 5px;">
																<form:option value="NONE" label="PROVINCE" />
																<form:options items="${model.provinceList}" />
															</form:select>
														</div>
													</div>
												</div>
 --%>
												<div class="row">
													<div class="drop-down-padding">
														<div class="col-xs-12" align="right">
															<form:select id="divison" path="pcbEquipment.divison"
																onchange="findProvinceByDivision();drawDashboard();"
																style="width:100%; background-color: #FFFFF; border-radius: 5px;">
																 <form:option value="NONE" label="DIVISION" />
																 <form:options items="${model.divList}" />
															</form:select>
														</div>
													</div>
												</div>
												
												<div class="row">
													<div class="drop-down-padding">
														<div class="col-xs-12" align="right">
															<form:select id="province" path="pcbEquipment.branch"
																onchange="findArea();drawDashboard();"
																style="width:100%; background-color: #FFFFF; border-radius: 5px;">
																<form:option value="NONE" label="PROVINCE" />
																 <form:options items="${model.provinceList}" />
															</form:select>
														</div>
													</div>
												</div>
												
												
												
												<div class="row">
													<div class="drop-down-padding">
														<div class="col-xs-12" align="right">
															<form:select id="area" path="pcbEquipment.unit"
																onchange=""
																style="width:100%; background-color: #FFFFF; border-radius: 5px;">
																<form:option value="NONE" label="AREA" />
																
																<form:option value="ST" label="STORES" />
																 <form:options items="${model.areaList}" />
															</form:select>
														</div>
													</div>
												</div>

												<%-- <div class="row">
													<div class="drop-down-padding">
														<div class="col-xs-12" align="right">
															<form:select id="line" path="line.code" onchange=""
																style="width:100%; background-color: #dac698; border-radius: 5px;">
																<form:option value="NONE" label="LINE" />
																<form:options items="${model.lineList}" />
															</form:select>
														</div>
													</div>
												</div>
 --%>
												<div class="row">
													<div class="drop-down-padding">
														<div class="col-xs-12" align="right">
															<form:select id="mode" path="" onchange=""
																style="width:100%; background-color: #FFFFF; border-radius: 5px;">
																<form:option value="MAP" label="MAP VIEW" />
																<%-- <form:option value="NETWORK" label="NETWORK VIEW" />
 --%>
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
											</div>
											
											
										</form:form>

										

									</div>
								</div>

								<div class="col-sm-12" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
								</div>
								
								
								
															<div class="col-lg-12">

								<div class="row">
								
								<br>
								<div class="wrimagecardNew1 wrimagecard-topimage">
								
								<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
												<h4 align="center">
													  						
															<span >Distribution Transformer Summary</span>
														
														
												</h4>
													<div id="dashboard_div">
      												<!--Divs that will hold each control and chart-->
      												<div align="center" id="filter_div"></div>
      												<div id="piechart_values"></div>
      												<br>
													<div align="center" id="table_div"></div>
													<br>
													<div id="barchart_values"></div>

												</div>
												
											
											
										
								</div>
								</div>
					</div>
					</div>
					
						<div class="col-lg-12">

								<div class="row">
								
								<br>
								<div class="wrimagecardNew1 wrimagecard-topimage">
								
								<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
													<div id="dashboard_div">
      												<!--Divs that will hold each control and chart-->
      												<div id="filter_div"></div>
      												<div id="piechart_valuesisland"></div>
      												<br>
													<!-- <div id="table_div"></div>
													<br>
													<div id="barchart_values"></div>
 -->
												</div>
												
											
											
								</div>
								</div>
					</div>
					</div>
					
					<div class="col-lg-12">

								<div class="row">
								
								<br>
								<div class="wrimagecardNew1 wrimagecard-topimage">
								
								<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
													<div id="dashboard_div">
      												<!--Divs that will hold each control and chart-->
      												<div id="filter_div"></div>
      												<div id="piechart_valuestwo"></div>
      												<br>
													<!-- <div id="table_div"></div>
													<br>
													<div id="barchart_values"></div>
 -->
												</div>
												
											
											
										</div>
								</div>
					</div>
					</div>
					
					<div class="col-lg-12">

								<div class="row">
								
								<br>
								<div class="wrimagecardNew1 wrimagecard-topimage">
								
								<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
													<div id="dashboard_div">
      												<!--Divs that will hold each control and chart-->
      												<div id="filter_div"></div>
      												<div id="piechart_valuesthree"></div>
      												<br>
													<!-- <div id="table_div"></div>
													<br>
													<div id="barchart_values"></div>
 -->
												</div>
												
											
											
										</div>
								</div>
					</div>
					</div>
					
					<div class="col-lg-12">

								<div class="row">
								
								<br>
								<div class="wrimagecardNew1 wrimagecard-topimage">
								
								<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
													<div id="dashboard_div">
      												<!--Divs that will hold each control and chart-->
      												<div id="filter_div"></div>
      												<div id="piechart_valuesfour"></div>
      												<br>
													<!-- <div id="table_div"></div>
													<br>
													<div id="barchart_values"></div>
 -->
												</div>
												
											
											</div>
								</div>
								</div>
					</div>
					
					<div class="col-lg-12">

								<div class="row">
								
								<br>
								<div class="wrimagecardNew1 wrimagecard-topimage">
								
								<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
												<h4 align="center" >
													  						
															<span>Contamination Weight</span>
														
														
												</h4>
													<div id="dashboard_div">
      												<!--Divs that will hold each control and chart-->
      												<div id="filter_div5"></div>
      												<div align="center" id="tablechart_valuesoil"></div>
      												<br>
													<!-- <div id="table_div"></div>
													<br>
													<div id="barchart_values"></div>
 -->
												</div>
												
											
											
										</div>
								</div>
					</div>
					</div>
					
					<div class="col-lg-12">

								<div class="row">
								
								<br>
								<div class="wrimagecardNew1 wrimagecard-topimage">
								
								<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
													<div id="dashboard_div">
      												<!--Divs that will hold each control and chart-->
      												<div align="center" id="filter_div5"></div>
      												<div id="piechart_valuesoil"></div>
      												<br>
													<div id="tablechart_valuesoil"></div>
													<br>
													
												</div>
												
											
											
										</div>
								</div>
					</div>
					</div>
					
					
					
					
					
					
					
					
					
					
								
								
					<%-- 			 <div class="col-sm-12" align="left">

									<div class="row">

										<div id="filter_div"></div>
      
									</div>
								</div>
								<div class="col-sm-12" align="left">

									<div class="row">

										<div id="filter_div5"></div>
      
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
															<strong>Transformer Inventory</strong>
														</center>
												</h4>




												<div style="height: 220px">
												<div id="dashboard_div">
												
<div id="piechart_values"></div>
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
															<strong>Transformer Inventory</strong>
														</center>
												</h4>




												<div style="height: 220px">
												<div id="dashboard_div">
												
<div id="table_div"></div>
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
															<strong>Transformer Inventory</strong>
														</center>
												</h4>




												<div style="height: 220px">
												<div id="dashboard_div">
												
<div id="barchart_values"></div>
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
															<strong>Island Result</strong>
														</center>
												</h4>




												<div style="height: 220px">
												<div id="dashboard_div">
											
<div id="piechart_valuesisland"></div>
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
															<strong>Sampled No. of Tran.</strong>
														</center>
												</h4>




												<div style="height: 220px">
												<div id="dashboard_div">
											
<div id="piechart_valuestwo"></div>
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
															<strong>Screening Test (+)Ve Tran.</strong>
														</center>
												</h4>




												<div style="height: 220px">
												<div id="dashboard_div">
						
<div id="piechart_valuesthree"></div>
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
															<strong>Numbers Confirmed by ITI</strong>
														</center>
												</h4>




												<div style="height: 220px">
												<div id="dashboard_div">
						
<div id="piechart_valuesfour"></div>
					</div>							</div>





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
															<strong>Contamination Weight</strong>
														</center>
												</h4>




												<div style="height: 220px">
												<div id="dashboard_div">
						
<div id="piechart_valuesoil"></div>
					</div>							</div>





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
															<strong>Contamination Weight</strong>
														</center>
												</h4>




												<div style="height: 220px">
												<div id="dashboard_div">
						
<div id="tablechart_valuesoil"></div>
					</div>							</div>





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
															<strong>Manage Equipment Data</strong>
														</center>
												</h4>
												
													<div style="height: 220px">
													<h4>
														<strong><br></strong>
													</h4>

													<tr>
													<!-- <div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">Tower Lines</button>
															<div class="dropdown-content">
																<a href="viewTowerLine?mode=PELT">Line Type</a> 
																<a href="viewTowerLine?mode=PECONT">Conductor Type</a> 
																<a href="viewTowerLine?mode=PECIRT">Circuit Type</a> 
																
															</div>
														</div>
														
														
													 -->
													 <div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn"><a href="addEquipment">Add Equipment Info</a></button>
															
														</div>
													 </tr>
													<br> <br>
													
													<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn"><a href="editEquipment">Edit Equipment Info</a></button>
															
														</div>

													</tr>
													<br> <br>
<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn"><a href="addInformationReatedSample">Manage
									Equipment Info</a></button>
															
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
															<strong>Upload Equipment Data</strong>
														</center>
												</h4>
												
													<div style="height: 220px">
													<h4>
														<strong><br></strong>
													</h4>

													<tr>
														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn"><a href="uploadEquipment">Upload
									Equipment Info</a></button>
															
														</div>
														

													</tr>
													

												</div>
												
												
											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div> --%>
									
								
								
								
								
								
								
								
<%-- 								
								
																	<div class="col-lg-4 col-sm-6 col-xs-12">
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
													<!-- <div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">Tower Lines</button>
															<div class="dropdown-content">
																<a href="viewTowerLine?mode=PELT">Line Type</a> 
																<a href="viewTowerLine?mode=PECONT">Conductor Type</a> 
																<a href="viewTowerLine?mode=PECIRT">Circuit Type</a> 
																
															</div>
														</div>
														
														
													 -->
													 <div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn"><a href="viewReportsPCB?mode=IOTI">Inventory of Trans. I</a></button>
															
														</div>
													 </tr>
													<br> <br>
													
													<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn"><a href="viewReportsPCB?mode=IOTII">Inventory of Trans. II</a></button>
															
														</div>

													</tr>
													<br> <br>
<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn"><a href="viewReportsPCB?mode=IOTIII">Inventory of Trans. III</a></button>
															
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
															<strong>Reports</strong>
														</center>
												</h4>
												
													<div style="height: 220px">
													<h4>
														<strong><br></strong>
													</h4>

													<tr>
													<!-- <div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">Tower Lines</button>
															<div class="dropdown-content">
																<a href="viewTowerLine?mode=PELT">Line Type</a> 
																<a href="viewTowerLine?mode=PECONT">Conductor Type</a> 
																<a href="viewTowerLine?mode=PECIRT">Circuit Type</a> 
																
															</div>
														</div>
														
														
													 -->
													 <div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn"><a href="viewReportsPCB?mode=IOTIIV">Inventory of Trans. IV</a></button>
															
														</div>
													 </tr>
													<br> <br>
													
													<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn"><a href="viewReportsPCB?mode=IOTIV">Inventory of Trans. V</a></button>
															
														</div>

													</tr>
													<br> <br>
													
													<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn" onClick="DivSummary3()">Stores Report</button>
															
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
															<strong>Summary Reports</strong>
														</center>
												</h4>
												
													<div style="height: 220px">
													<h4>
														<strong><br></strong>
													</h4>

													<tr>
													<!-- <div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">Tower Lines</button>
															<div class="dropdown-content">
																<a href="viewTowerLine?mode=PELT">Line Type</a> 
																<a href="viewTowerLine?mode=PECONT">Conductor Type</a> 
																<a href="viewTowerLine?mode=PECIRT">Circuit Type</a> 
																
															</div>
														</div>
														
														
													 -->
													 <div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn" onClick="DivSummary()">Summary Reports</button>
															
														</div>
													 </tr>
													<br> <br>
													
													<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn" onClick="DivSummary1()">Divisional Report</button>
															
														</div>

													</tr>
													<br> <br>
													
													<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn" onClick="DivSummary2()">Provincial Report</button>
															
														</div>

													</tr>
													
																										

												</div>
												
												
											</div>
											<div class="wrimagecard-topimage_title">
												<div class="pull-right badge" id="WrControls"></div>
											</div>
										</div>
									</div> --%>
							</div>
						</div>
					</div>


				</div>
			</div>
		</div>
	</div>
	<%@ include file="sections/footer.jsp"%>
	<%@ include file="sections/global_scripts.jsp"%>
</body>
</html>