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



/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 280px;
  top: 175px;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 10px;
  border: 1px solid #888;
  width: 25%;
  
}
.p1{
    font-size: 14px;
}

/* The Close Button */
.close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}


.filter .google-visualization-controls-categoryfilter-selected li {
  background-color: #e65100;
  border: 1px solid #ff9800;
  color: #ffffff;
  padding: 6px;
}

.filter .goog-link-button {
  cursor: pointer;
  float: right;
  margin-left: 4px;
}

.filter .google-visualization-controls-slider-horizontal {
  width: 800px;
}

/* .google-visualization-table-td {
text-align: center !important;
}

.google-visualization-table-th {
text-align: center !important;
}
 */
 
 /* Table view header */
.google-visualization-table-table .gradient,
.google-visualization-table-div-page .gradient {
	background: #F4F4F4 !important;
	color:#444444;
}

/* selected/hovered row in a TABLE view */
.google-visualization-table-tr-sel td,
.google-visualization-table-tr-over td {
	background-color: #ffd6cc!important;
}

/*** Configuration of FILTERS ***/

/** Labels of filters **/
.google-visualization-controls-label {
	color:#333;
}

/** StringFilter **/
.google-visualization-controls-stringfilter INPUT {
	border:1px solid #d9d9d9!important;
	color:#222;
}
.google-visualization-controls-stringfilter INPUT:hover {
	border:1px solid #b9b9b9;
	border-top:1px solid #a0a0a0;
}
.google-visualization-controls-stringfilter INPUT:focus {
	border:1px solid #4d90fe;
}

/** CategoryFilter **/
.google-visualization-controls-categoryfilter .charts-menu-button,
.google-visualization-controls-categoryfilter .charts-menu-button.charts-menu-button-hover,
.google-visualization-controls-categoryfilter .charts-menu-button.charts-menu-button-active {
	color:#444;
	border:1px solid rgba(0,0,0,0.1);
	background:none;
	background:#f5f5f5;
}
.google-visualization-controls-categoryfilter LI{
	background-color:#D2D8E6!important;
}

/* CategoryFilter & csvFilter hovered item in the dropdown */
.charts-menuitem-highlight {
	background-color:#FFFFCC!important;
	border-color:#FFFFCC!important;
}

/** NumberRangeFilter **/
/* slider thumbs */
.google-visualization-controls-slider-horizontal .google-visualization-controls-slider-thumb,
.google-visualization-controls-slider-vertical .google-visualization-controls-slider-thumb {
	background-color: #6D6E6E;
	border: 1px solid #444444;
}
/* label showing the current thumb value */
.google-visualization-controls-rangefilter-thumblabel {
	color:#444444!important;
}
 
.google-visualization-controls-label {
	color:#333;
}
#sidebar{
	width:80%!important;
	margin-left:0px!important;
}


.google-visualization-table-td {
text-align: left !important;
}

.filter .google-visualization-controls-categoryfilter-selected li {
  background-color: #e65100;
  border: 1px solid #ff9800;
  color: #ffffff;
  padding: 6px;
}

.filter .google-visualization-controls-categoryfilter{
height: 100%;
 width: 100%;
}

.google-visualization-controls-label {
	color:#333;
	
}


.filter .goog-link-button {
  cursor: pointer;
  float: right;
  margin-left: 4px;
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


.small-font {
  font-size: 14px;
  height: 40px;
}

.small-font1 {
  font-size: 12px;
  height: 50px;
}

.orange-background {
   background-color: orange;
  }

 .orchid-background {
  background-color: orchid;
 }

.beige-background {
 background-color: beige;
  }


 .filter .google-visualization-controls-categoryfilter-selected li {
  background-color: #e65100;
  border: 1px solid #ff9800;
  color: #ffffff;
  padding: 6px;
}

.filter .goog-link-button {
  cursor: pointer;
  float: right;
  margin-left: 4px;
}

.filter .google-visualization-controls-slider-horizontal {
  width: 800px;
}

/* .google-visualization-table-td {
text-align: center !important;
}

.google-visualization-table-th {
text-align: center !important;
}
 */
 
 /* Table view header */
.google-visualization-table-table .gradient,
.google-visualization-table-div-page .gradient {
	background: #F4F4F4 !important;
	color:#444444;
}

/* selected/hovered row in a TABLE view */
.google-visualization-table-tr-sel td,
.google-visualization-table-tr-over td {
	background-color: #ffd6cc!important;
}

/*** Configuration of FILTERS ***/

/** Labels of filters **/
.google-visualization-controls-label {
	color:#333;
}

/** StringFilter **/
.google-visualization-controls-stringfilter INPUT {
	border:1px solid #d9d9d9!important;
	color:#222;
}
.google-visualization-controls-stringfilter INPUT:hover {
	border:1px solid #b9b9b9;
	border-top:1px solid #a0a0a0;
}
.google-visualization-controls-stringfilter INPUT:focus {
	border:1px solid #4d90fe;
}

/** CategoryFilter **/
.google-visualization-controls-categoryfilter .charts-menu-button,
.google-visualization-controls-categoryfilter .charts-menu-button.charts-menu-button-hover,
.google-visualization-controls-categoryfilter .charts-menu-button.charts-menu-button-active {
	color:#444;
	border:1px solid rgba(0,0,0,0.1);
	background:none;
	background:#f5f5f5;
}
.google-visualization-controls-categoryfilter LI{
	background-color:#D2D8E6!important;
}

/* CategoryFilter & csvFilter hovered item in the dropdown */
.charts-menuitem-highlight {
	background-color:#FFFFCC!important;
	border-color:#FFFFCC!important;
}

/** NumberRangeFilter **/
/* slider thumbs */
.google-visualization-controls-slider-horizontal .google-visualization-controls-slider-thumb,
.google-visualization-controls-slider-vertical .google-visualization-controls-slider-thumb {
	background-color: #6D6E6E;
	border: 1px solid #444444;
}
/* label showing the current thumb value */
.google-visualization-controls-rangefilter-thumblabel {
	color:#444444!important;
}
 
.google-visualization-controls-label {
	color:#333;
	
}

 






</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
google.charts.load('current', {'packages':['corechart', 'controls']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawDashboard);



var estimateNoGloble;
var costCenterNoGloble;
var done;


function drawDashboard() {
	
	/* document.getElementById("btnApprove").disabled = true;
	document.getElementById("txtReason").disabled = true;
	document.getElementById("btnReject").disabled = true;
	document.getElementById("btnViewMore").disabled = true;
	
	document.getElementById("btnViewPrint").disabled = true;
	 */
    	 /*  $.ajax({
    			type : 'GET',
    			url : "/MMS/getApprovalListNew",
    			data : {},
    			contentType : "application/json; charset=utf-8",
    			success : function(result) {
    				var datavaluepie = new google.visualization.DataTable();
    				datavaluepie.addColumn('string', 'Unit Name');
    				datavaluepie.addColumn('number', 'No.');
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
    		        dashboard.bind(donutRangeSlider2, pieChart);
    		        dashboard.draw(datavaluepie);
    		        
    		        google.visualization.events.addListener(table, 'select', selectHandler);
      		        function selectHandler() {
    		          //alert("hiii");
    		          var selectedItem = table.getChart().getSelection();
    		          
    		          if (selectedItem) {
    		        	 // alert("hiii2");
    		        	 
    		        	 var row = selectedItem[0].row;

		          var value=table.getDataTable().getValue(row, 2); 
		          //var status=table.getDataTable().getValue(row,4);

    		        	 
    		          //  var value = datavaluepie.getValue(selectedItem.row, 2);
    		           // alert('The user selected ' + value);
    		            
    		            $.ajax({
    		    			type : 'GET',
    		    			url : "/MMS/getApprovalListByCostCenter/" +value+"/" ,
    		    			data : {},
    		    			contentType : "application/json; charset=utf-8",
    		    			success : function(result) {
    		    				
    		    				document.getElementById("btnApprove").disabled = false;
    		    				document.getElementById("txtReason").disabled = false;
    		    				document.getElementById("btnReject").disabled = false;
    		    				document.getElementById("btnViewMore").disabled = false;
    		    				
    		    				document.getElementById("btnViewPrint").disabled = false;
    		    				
    		    				
    		    				var datavalue = new google.visualization.DataTable();
    		    				//datavalue.addColumn('string', 'Approve');
    		    				
    		    				datavalue.addColumn('string', 'Estimate No');
    		    				//datavalue.addColumn('string', 'Approve');
    		    				
    		    				datavalue.addColumn('string', 'Dept Id');
    		    				datavalue.addColumn('string', 'Description');
    		    				datavalue.addColumn('string', 'Categary Code');
    		    				datavalue.addColumn('string', 'Fund Source');
    		    				datavalue.addColumn('number', 'Rebate for Material');
    		    				datavalue.addColumn('number', 'Estimated  Capital  Cost');
    		    				
    		    				
    		    				for (var i = 0; i < result.length; i++) {
    		    						var data = result[i];
    		    						//datavalue.addRows([['<a href="LINK">Approve</a>'],[data[0], data[1],data[2]]]);
    		    						//datavalue.addRows([[data[0],'<button>Approve</button>', data[1]]]);
    		    						datavalue.addRows([[data[0],data[1],data[2],data[5],data[6],data[3],data[4]]]);
    				    				
    		    				}
    		    				datavalue.setColumnProperty(1, {allowHtml: true});
    		    				
    		    				
    		    				 
    		    			     // Create a dashboard.
    		    		        var dashboard = new google.visualization.Dashboard(
    		    		            document.getElementById('dashboard_div'));

    		    		        // Create a range slider, passing some options
    		    		        var donutRangeSlider3 = new google.visualization.ControlWrapper({
    		    		          'controlType': 'CategoryFilter',
    		    		          'containerId': 'filter_div3',
    		    		          'options': {
    		    		        	'filterColumnLabel': 'Estimate No'
    		    		          }
    		    		        });

    		    		        
    		    		        var table = new google.visualization.ChartWrapper({
    		    			          'chartType': 'Table',
    		    			          'containerId': 'estaprtabledetail_div',
    		    			          'options': {
    		    			            'width': 1500,
    		    			            'height': 300,
    		    			            'allowHtml': true,
    		    			            'pieSliceText': 'value',
    		    			            'legend': 'right',
    		    			            'series': {
    		    			                '1': {
    		    			                    // set the color to change to
    		    			                    'color': '#d04200',
    		    			                    // don't show this in the legend
    		    			                    'visibleInLegend': false
    		    			                }
    		    			            }
    		    			            
    		    			          }
    		    			        });
    		    		       // table.getChart().hideColumns([1]);

    		    		        // Establish dependencies, declaring that 'filter' drives 'pieChart',
    		    		        // so that the pie chart will only display entries that are let through
    		    		        // given the chosen slider range.
    		    		        dashboard.bind(donutRangeSlider3, table);

    		    		        // Draw the dashboard.
    		    		        dashboard.draw(datavalue, {allowHtml: true});
    		    		        
    		    		        
    		    		        
    		    		        // The select handler. Call the chart's getSelection() method
    		    		        function selectHandler() {
    		    		        	//alert("hiii");
    		    		         var selectedItem = table.getChart().getSelection();
    		    		         if(selectedItem){
    		    		        	  
    		    		        	 
    		    		        	 var row = selectedItem[0].row;
    		    		        	var estimateNo = table.getDataTable().getValue(row, 0);
     		    		            var costCenterNo = table.getDataTable().getValue(row, 1);
     		    		            estimateNoGloble = estimateNo;
     		    		            costCenterNoGloble = costCenterNo;
     		    		           document.getElementById("txtEstNo").value = estimateNo;
     		    		          document.getElementById("txtCostCenter").value = costCenterNo;
         		    				
     		    		          
     		    		            /* var url="downloadEstimate?estimateNo="+estimateNo+"&costCenter="+costCenterNo;
     		    		    	    var width = 1100;
     		    		    	    var height = 700;
     		    		    	    var left = parseInt((screen.availWidth/2) - (width/2));
     		    		    	    var top = parseInt((screen.availHeight/2) - (height/2));
     		    		    	    var windowFeatures = "width=" + width + ",height=" + height + 
     		    		    	    ",status,resizable,left=" + left + ",top=" + top +
     		    		    	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
     		    		    	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
     		    		    	     */
    		    		        /*  }
    		    		         }
    		    		        google.visualization.events.addListener(table, 'select', selectHandler);
 

 
     		    		        
    		    			}
    		    		});

    		            
    		            
    		            
    		            
    		            
    		          }
    		         }
    		        
    		        
  		        	}
    		});
 */ 
 
 
 
  $.ajax({
		type : 'GET',
		url : "/MMS/getGantryAll",
		data : {},
		contentType : "application/json; charset=utf-8",
		success : function(result) {
			var datavaluepie = new google.visualization.DataTable();
			datavaluepie.addColumn('string', 'Province');
			datavaluepie.addColumn('number', 'Number of Substations');
			datavaluepie.addColumn('string', 'Name');
			
			
			for (var i = 0; i < result.length; i++) {
					var data = result[i];
					//var str = searchStatus(data[3]);
					datavaluepie.addRows([[data[2], data[0],data[1]]]);
			}
			
			 
		     // Create a dashboard.
	        var dashboard = new google.visualization.Dashboard(
	            document.getElementById('dashboard_div'));

	        // Create a range slider, passing some options
	        var donutRangeSlider2 = new google.visualization.ControlWrapper({
	         
	        'controlType': 'CategoryFilter',
	          'containerId': 'filter_div6',
	          'fontSize': 10,
	          'options': {
	            'filterColumnLabel': 'Province',
	            'useFormattedValue': true,
	            'ui': {

	                'label': 'Province',
	                'allowTyping': false,
	                'allowMultiple': false,
	                'caption' : 'All Province',
	                'allowNone': true,
	                'selectedValuesLayout': 'belowStacked'
	            }
	        }
	        });


	        

	       /*   // Create a pie chart, passing some options
	        var pieChart = new google.visualization.ChartWrapper({
	          'chartType': 'ColumnChart',
	          'containerId': 'status_div',
	          'options': {
	            'height': 400,
	            'width': 1200,
	            'is3D': true,
	            'pieSliceText': 'value',
	            'legend': 'right'
	          }
	        });
	        */  
	       var table = new google.visualization.ChartWrapper({
		         
	    	   'chartType': 'Table',
		          'containerId': 'statustable_div',
		          'options': {
		            'allowHtml': true,
		            'width': 1200,
			          
		            'pieSliceText': 'value',
		            'legend': 'right',
		          'page': 'enable',
	            'pageSize': 10,
	            'pagingSymbols': {
	                'prev': 'prev',
	                'next': 'next'
	            },
	            'pagingButtonsConfiguration': 'auto',
	          'cssClassNames': {
	              'tableCell': 'small-font'
	            }
	     
		            
		          }
		        });
	        //table.setColumns([0,1]);
	        
       
	        dashboard.bind(donutRangeSlider2, table);
	        //dashboard.bind(donutRangeSlider2, pieChart);
	        dashboard.draw(datavaluepie);
	        
	        
	        google.visualization.events.addListener(table, 'select', selectHandler);
	        function selectHandler() {
	        	
	        	
	          //alert("hiii");
	          
	          
	          var selectedItem = table.getChart().getSelection();
	          	          
	          if (selectedItem) {
	        	  
	        	  var row = selectedItem[0].row;

		          var province=table.getDataTable().getValue(row, 0); 
		          //var status=table.getDataTable().getValue(row,4);
 
	        	  
	        	//alert("hiii2" + province);
	        	// var deptId = table.getChart().getDataTable().getValue(selectedItem.row, 3);
	        	// var status = table.getChart().getDataTable().getValue(selectedItem.row, 4);
		            
	            //var deptId = datavaluepie.getValue(selectedItem.row, 3);
	            //var status = datavaluepie.getValue(selectedItem.row, 4);
		           
	         //  alert('The user selected ' + deptId + "eeee"+status);
	            
	            $.ajax({
	    			type : 'GET',
	    			url : "/MMS/getGantryByProvince?province="+province,
	    			data : {},
	    			contentType : "application/json; charset=utf-8",
	    			success : function(result) {
	    				var datavalue = new google.visualization.DataTable();
	    				//datavalue.addColumn('string', 'Approve');
	    				
	    				datavalue.addColumn('string', 'Area Name');
    		    				//datavalue.addColumn('string', 'Approve');
    		    				
    		    				datavalue.addColumn('number', 'Number of Substation');
    		    				datavalue.addColumn('string', 'Area Code');
    		    				for (var i = 0; i < result.length; i++) {
	    						var data = result[i];
	    						//datavalue.addRows([['< href="LINK">Approve</a>'],[data[0], data[1],data[2]]]);
	    						//datavalue.addRows([[data[0],'<button>Approve</button>', data[1]]]);
	    						//datavalue.addRows([[data[0],data[1]]]);
	    						datavalue.addRows([[data[1],data[0],data[2]]]);
    				    		
			    				
	    				}
	    				datavalue.setColumnProperty(1, {allowHtml: true});
	    				
	    				
	    				 
	    			     // Create a dashboard.
	    		        var dashboard = new google.visualization.Dashboard(
	    		            document.getElementById('dashboard_div'));

	    		        // Create a range slider, passing some options
	    		        var donutRangeSlider3 = new google.visualization.ControlWrapper({
	    		          
	    		        
	    		        'controlType': 'CategoryFilter',
	    		          'containerId': 'filter_div7',
	    		          'fontSize': 10,
	    		          'options': {
	    		            'filterColumnLabel': 'Area Name',
	    		            'useFormattedValue': true,
	    		            'ui': {

	    		                'label': 'Area Name',
	    		                'allowTyping': false,
	    		                'allowMultiple': false,
	    		                'caption' : 'All Area',
	    		                'allowNone': true,
	    		                'selectedValuesLayout': 'belowStacked'
	    		            }
	    		        }
	    		        });


	    		        
	    		        var table = new google.visualization.ChartWrapper({
	    			          'chartType': 'Table',
    			          'containerId': 'eststatusdetail_div',
    			          'options': {
    			            'allowHtml': true,
    			            'pieSliceText': 'value',
    			            'width': 1200,
    			            'legend': 'right',
    			          'page': 'enable',
			            'pageSize': 10,
			            'pagingSymbols': {
			                'prev': 'prev',
			                'next': 'next'
			            },
			            'pagingButtonsConfiguration': 'auto',
			          'cssClassNames': {
			              'tableCell': 'small-font'
			            }
			     
    			            
    			          }
    			        });
	    		 
	    		        
	    		        
	    		       // table.getChart().hideColumns([1]);

	    		        // Establish dependencies, declaring that 'filter' drives 'pieChart',
	    		        // so that the pie chart will only display entries that are let through
	    		        // given the chosen slider range.
	    		        dashboard.bind(donutRangeSlider3, table);

	    		        // Draw the dashboard.
	    		        dashboard.draw(datavalue, {allowHtml: true});
	    		        
	    		        
	    		        
	    		        // The select handler. Call the chart's getSelection() method
	    		        google.visualization.events.addListener(table, 'select', selectHandler);

	    		        function selectHandler() {
	    		        	//alert("hiii");
	    		         var selectedItem = table.getChart().getSelection();
	    		         if(selectedItem){
	    		        	 
	    		        	 var row = selectedItem[0].row;

	    			          //var deptId=table.getDataTable().getValue(row, 3); 

	    		        	var area = table.getDataTable().getValue(row, 2);
	    		        	
	    		        	//alert(area);
	    		        	 $.ajax({
	    		    			type : 'GET',
	    		    			url : "/MMS/findGantryByAreaNewView?area="+area,
	    		    			data : {},
	    		    			contentType : "application/json; charset=utf-8",
	    		    			success : function(result) {
	    		    				var datavalue = new google.visualization.DataTable();
	    		    				//datavalue.addColumn('string', 'Approve');
	    		    				
	    		    				datavalue.addColumn('string', 'Substation Name');
	    	    		    				//datavalue.addColumn('string', 'Approve');
	    	    		    				
	    	    		    				datavalue.addColumn('string', 'Substation Code');
	    	    		    				datavalue.addColumn('number', 'Id');
	    	    		    				
	    	    		    				for (var i = 0; i < result.length; i++) {
	    		    						var data = result[i];
	    		    						//datavalue.addRows([['< href="LINK">Approve</a>'],[data[0], data[1],data[2]]]);
	    		    						//datavalue.addRows([[data[0],'<button>Approve</button>', data[1]]]);
	    		    						//datavalue.addRows([[data[0],data[1]]]);
	    		    						datavalue.addRows([[data.name,data.code,data.id]]);
	    	    				    		
	    				    				
	    		    				}
	    		    				datavalue.setColumnProperty(1, {allowHtml: true});
	    		    				
	    		    				
	    		    				 
	    		    			     // Create a dashboard.
	    		    		        var dashboard = new google.visualization.Dashboard(
	    		    		            document.getElementById('dashboard_div'));

	    		    		        // Create a range slider, passing some options
	    		    		        var donutRangeSlider3 = new google.visualization.ControlWrapper({
	    		    		          
	    		    		        
	    		    		        'controlType': 'CategoryFilter',
	    		    		          'containerId': 'filter_div8',
	    		    		          'fontSize': 10,
	    		    		          'options': {
	    		    		            'filterColumnLabel': 'Substation Name',
	    		    		            'useFormattedValue': true,
	    		    		            'ui': {

	    		    		                'label': 'Substation Name',
	    		    		                'allowTyping': false,
	    		    		                'allowMultiple': false,
	    		    		                'caption' : 'All Substation',
	    		    		                'allowNone': true,
	    		    		                'selectedValuesLayout': 'belowStacked'
	    		    		            }
	    		    		        }
	    		    		        });


	    		    		        
	    		    		        var table = new google.visualization.ChartWrapper({
	    		    			          'chartType': 'Table',
	    	    			          'containerId': 'substation_div',
	    	    			          'options': {
	    	    			            'allowHtml': true,
	    	    			            'pieSliceText': 'value',
	    	    			            'width': 1200,
	    	    			            'legend': 'right',
	    	    			          'page': 'enable',
	    				            'pageSize': 10,
	    				            'pagingSymbols': {
	    				                'prev': 'prev',
	    				                'next': 'next'
	    				            },
	    				            'pagingButtonsConfiguration': 'auto',
	    				          'cssClassNames': {
	    				              'tableCell': 'small-font'
	    				            }
	    				     
	    	    			            
	    	    			          }
	    	    			        });
	    		    		 
	    		    		        
	    		    		        
	    		    		       // table.getChart().hideColumns([1]);

	    		    		        // Establish dependencies, declaring that 'filter' drives 'pieChart',
	    		    		        // so that the pie chart will only display entries that are let through
	    		    		        // given the chosen slider range.
	    		    		        dashboard.bind(donutRangeSlider3, table);

	    		    		        // Draw the dashboard.
	    		    		        dashboard.draw(datavalue, {allowHtml: true});
	    		    		        
	    		    		        
	    		    		        
	    		    		        
	    		    		         google.visualization.events.addListener(table, 'select', selectHandler);

	    		    		        function selectHandler() {
	    		    		        	//alert("hiii");
	    		    		         var selectedItem = table.getChart().getSelection();
	    		    		         if(selectedItem){
	    		    		        	 
	    		    		        	 var row = selectedItem[0].row;

	    		    			          //var deptId=table.getDataTable().getValue(row, 3); 

	    		    		        	var id = table.getDataTable().getValue(row, 2);
	    		    		        	
	    		    		        	
	    		    		        	var url="downloadSingleLineDiagram?id=" +id ;
	    		    		    	       var width = 1100;
	    			    		    	    var height = 700;
	    			    		    	    var left = parseInt((screen.availWidth/2) - (width/2));
	    			    		    	    var top = parseInt((screen.availHeight/2) - (height/2));
	    			    		    	    var windowFeatures = "width=" + width + ",height=" + height + 
	    			    		    	    ",status,resizable,left=" + left + ",top=" + top +
	    			    		    	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	    			    		    	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
	    			    		    	   
	    		    		        	
	    		    		        	
	    		    		        	
	    		    		        	
	    		    		         }
	    		    		        }
 	    		    		        
	    		    		        
	    		    		        
	    		    		        
	    		    		        

	    		        	
	    		    			}
	    		    			
	    		        	 });
     		    		 
	    		        	
	    		        	
	    		        	
	    		        	
	    		        	
	    		        	
	    		        	
	    		        	
	    		        	
	    		        	
	    		        	
	    		        	
	    		            /* var costCenterNo = table.getDataTable().getValue(row, 1);
	    		            estimateNoGloble = estimateNo;
	    		            costCenterNoGloble = costCenterNo;
	    		            
	    		             
	    		            var url="downloadEstimate?estimateNo="+estimateNo+"&costCenter="+costCenterNo;
	    		    	    var width = 1100;
	    		    	    var height = 700;
	    		    	    var left = parseInt((screen.availWidth/2) - (width/2));
	    		    	    var top = parseInt((screen.availHeight/2) - (height/2));
	    		    	    var windowFeatures = "width=" + width + ",height=" + height + 
	    		    	    ",status,resizable,left=" + left + ",top=" + top +
	    		    	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	    		    	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
	    		    	     */ 
	    		        }
     		         }
	    		        


	    		        
	    			}
	    		});
 
	            
	            
	            
	            
	            
	          }
	         }
	        
	        
       	}
	});
 
      
}
          
          
          

          
          
          function searchStatus(key){
        	  switch (key) {
      		case 75:
      			return "Modify";			 
      		case 23:
      			return "Saved Estimate";			 
      		case 44:
      			return "To be Approved by ES";	
      		case 45:
      			return "To be Approved by EA";	
      		case 46:
      			return "To be Approved by EE";
      		case 47:
      			return "To be Approved by CE";	
      		case 48:
      			return "To be Approved by DGM";	
      		case 49:
      			return "To be Approved by AGM";	
      		case 31:
      			return "Rejected";		 
      		case 30:
      			return "This estimate has approved (PIV II can issue for this estimate)";			 
      		case 33:
      			return "PIV II Confirmed but Job number has not generated";			 
      		case 22:
      			return "Pending at Accounts Branch";			 
      		case 1:
      			return "Ongoing Job";
      		case 5:
      			return "This job is to be revised";
      		case 25:
      			return "Any Modification can  be done to the revised estimate";
      		case 55:
      			return "Job revised. Revised Estimate to be Approved by ES";
      		case 50:
      			return "To be Recommend by Planning CE";
      		case 51:
      			return "To be Recommend by Commercial CE";
      		case 56:
      			return "Job revised. Revised Estimate to be Approved by EA";
      		case 57:
      			return "Job revised. Revised Estimate to be Approved by EE";
      		case 61:
      			return "Job revised. Revised Estimate to be Approved by CE";	
      		case 58:
      			return "Job revised. Revised Estimate to be Approved by DGM";
      		case 59:
      			return "Job revised. Revised Estimate to be Approved by AGM";
      		case 60:
      			return "This job has approved";
      		case 41:
      			return "This job has rejected";
      		case 4:
      			return "Soft Closed Job";
      		case 3:
      			return "Hard Closed Job";
      		case 6:
      			return "Exported Job";
      		case 80:
      			return "This estimate has opened through SPS System !!!!";

      		default:
      			return "Cancelled";
      			 
      		}

          }
          
          
          
          function viewMore(){
        		if(estimateNoGloble){
        			$.ajax({
		    			type : 'GET',
		    			url : "/MMS/getEstimateDetailAll?estimateNo=" +estimateNoGloble+"&deptid="+costCenterNoGloble,
		    			data : {},
		    			contentType : "application/json; charset=utf-8",
		    			success : function(result) {
		    				
		    				var datavalue = new google.visualization.DataTable();
		    				//datavalue.addColumn('string', 'Approve');
		    				
		    				datavalue.addColumn('string', 'Code');
		    				//datavalue.addColumn('string', 'Approve');
		    				
		    				datavalue.addColumn('string', 'Unit');
		    				datavalue.addColumn('number', 'Quantity');
		    				datavalue.addColumn('number', 'Unit Cost');
		    				datavalue.addColumn('number', 'Estimate Cost');
		    				
		    				
		    				for (var i = 0; i < result.length; i++) {
		    						var data = result[i];
		    						//datavalue.addRows([['<a href="LINK">Approve</a>'],[data[0], data[1],data[2]]]);
		    						//datavalue.addRows([[data[0],'<button>Approve</button>', data[1]]]);
		    						datavalue.addRows([[data[0],data[2],data[3],data[5],data[4]]]);
				    				
		    				}
		    				datavalue.setColumnProperty(1, {allowHtml: true});
		    				
		    				
		    				 
		    			     // Create a dashboard.
		    		        var dashboard = new google.visualization.Dashboard(
		    		            document.getElementById('dashboard_div'));

		    		        // Create a range slider, passing some options
		    		        var donutRangeSlider3 = new google.visualization.ControlWrapper({
		    		          'controlType': 'CategoryFilter',
		    		          'containerId': 'filter_div8',
		    		          'options': {
		    		        	'filterColumnLabel': 'Code'
		    		          }
		    		        });

		    		        
		    		        var table = new google.visualization.ChartWrapper({
		    			          'chartType': 'Table',
		    			          'containerId': 'estdetail_div',
		    			          'options': {
		    			            'width': 1000,
		    			            'height': 300,
		    			            'allowHtml': true,
		    			            'pieSliceText': 'value',
		    			            'legend': 'right',
		    			            'series': {
		    			                '1': {
		    			                    // set the color to change to
		    			                    'color': '#d04200',
		    			                    // don't show this in the legend
		    			                    'visibleInLegend': false
		    			                }
		    			            }
		    			            
		    			          }
		    			        });
		    		       // table.getChart().hideColumns([1]);

		    		        // Establish dependencies, declaring that 'filter' drives 'pieChart',
		    		        // so that the pie chart will only display entries that are let through
		    		        // given the chosen slider range.
		    		        dashboard.bind(donutRangeSlider3, table);

		    		        // Draw the dashboard.
		    		        dashboard.draw(datavalue, {allowHtml: true});
		    		        
		    			}
        			});
        			
        		}else{
        			alert("Please select estimate number");
        		}
        		
        	}
          
          function viewPrint(){
      		if(estimateNoGloble){
      			 var url="downloadEstimate?estimateNo="+estimateNoGloble+"&costCenter="+costCenterNoGloble;
		    	    var width = 1100;
		    	    var height = 700;
		    	    var left = parseInt((screen.availWidth/2) - (width/2));
		    	    var top = parseInt((screen.availHeight/2) - (height/2));
		    	    var windowFeatures = "width=" + width + ",height=" + height + 
		    	    ",status,resizable,left=" + left + ",top=" + top +
		    	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
		    	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
		    	   
      			
      			
      		}else{
      			alert("Please select estimate number");
      		}
      		
      	}


          
          
          function approve(){
        	  
        	  
        	  
      		if(estimateNoGloble){
      			
      			var r = confirm("You are going to approve estimate number :" + estimateNoGloble);
      			if (r == true) {
      				$.ajax({
      					type : 'GET',
      					url : "/MMS/approveEstimate?estimateNo="+ estimateNoGloble +"&deptId="+costCenterNoGloble,
      					data : {},
      					contentType : "application/json; charset=utf-8",
      					success : function(result) {
      						alert(result);	
      						drawDashboard();
      	      				
      						
      					}
      				});
      				
      				alert("Successfully Done");
					drawDashboard();

      				
      				
      			} else {
      	  			
      			}
      		}else{
      			alert("Please select estimate number");
      		}
      		
      	}
          
          
          function reject(){
        	  
        	  var empt = document.getElementById("txtReason").value;
      		  if (empt === "Reason")
      			{
      			alert("Reason may not be empty");
      			event.preventDefault();
      			return false;
      		  }
        	  if(estimateNoGloble){
        			
        			var r = confirm("You are going to reject estimate number :" + estimateNoGloble);
        			if (r == true) {
        				$.ajax({
        					type : 'GET',
        					url : "/MMS/rejectEstimate?estimateNo="+ estimateNoGloble +"&deptId="+costCenterNoGloble+"&reason="+empt,
        					data : {},
        					contentType : "application/json; charset=utf-8",
        					success : function(result) {
        						alert(result);
        						drawDashboard();
                				
        					}
        				});
        				
        				alert("Successfully Done");
						drawDashboard();

        				
        			} else {
        	  			
        			}
        		}else{
        			alert("Please select estimate number");
        		}
        		
        	}
      	





</script>





</head>

<body>
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



					


					<div class="container">


						<div class="row">
							<div class="col-lg-12">

								<div class="row">
								
																
								 
 								
								
																
  <div class="col-sm-12" align="center">

									
										
									
										<div class="wrimagecardNew1 wrimagecard-topimage">
										
								<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
												<div id="filter_div6"></div>
      <br>
      <div>Please select the province from the table</div>
													<div id="dashboard_div">
      <!--Divs that will hold each control and chart-->
      
      <div id="statustable_div"></div>

												</div>
												<br>
												
											</div>
											
										</div>
									
</div>
 
<br>
<div class="col-sm-12" align="center">
										<div class="wrimagecardNew1 wrimagecard-topimage">
										
								<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
												<div id="filter_div7"></div>
      <br>
       <div>Please select the area from the table</div>
	
													<div id="dashboard_div">
      
      <div id="eststatusdetail_div"></div>

												</div>
												<br>
												
											</div>
											
										</div>
									</div>
									
									<br>
<div class="col-sm-12" align="center">
										<div class="wrimagecardNew1 wrimagecard-topimage">
										
								<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
												<div id="filter_div8"></div>
      <br>
       <div>Please select the substation name from the table,you can view the single line diagram</div>
	
													<div id="dashboard_div">
      
      <div id="substation_div"></div>

												</div>
												<br>
												
											</div>
											
										</div>
									</div>
									
 
 

									
								

<%-- 									<div class="col-lg-4 col-sm-6 col-xs-12">
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


																			<tr>
																			
																				<td>
																				<div class="dropdown" style="width: 100%; height: 30px;">
																				<!-- <button class="dropbtn" style="width: 100%; height: 25px;  background-color:#d6e3c1;">Lines</button>-->
																				<strong>Lines</strong>
																				<div class="dropdown-content">
																				<c:if test="${province =='CP'}">
																				<a href="viewLineSummary?id=CP&dd=DISTRIBUTION DIVISION 2&province=CENTRAL PROVINCE">CP</a>
																				</c:if>
																				<c:if test="${province =='EP'}">
																				<a href="viewLineSummary?id=EP&dd=DISTRIBUTION DIVISION 2&province=EASTERN PROVINCE">EP</a>
																				</c:if>
																				<c:if test="${province =='WPN'}">
																				<a href="viewLineSummary?id=WPN&dd=DISTRIBUTION DIVISION 2&province=WESTERN PROVINCE NORTH">WPN</a>
																				</c:if>
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
									</div> --%>

<%-- 									<div class="col-lg-4 col-sm-6 col-xs-12">
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
																	<a href="viewTMnewApprove">Tower Maintenance</a> <a
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
									</div> --%>

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
																<a href="ViewProvincialSchedule?mode=EWOP">Electrical
																	Works on Poles</a>
															</button>

														</div>


													</tr>
													<br> <br>

													<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">
																<a href="ViewProvincialSchedule?mode=VR">Vegitation Schedule</a>
															</button>

														</div>

													</tr>
													<br> <br>
													<tr>

														<div class="dropdown" style="width: 100%; height: 50px;">
															<button class="dropbtn">
																<a href="ViewProvincialSchedule?mode=MPL">Missing
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
									</div> --%>




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
		

	
	
	
</body>
</html>