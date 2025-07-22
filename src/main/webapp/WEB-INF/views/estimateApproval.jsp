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
      var approveEstimateNo;
      
      var costcenterForList;
      
      

      
      function drawDashboardRefresh() {
    		
    		document.getElementById("btnApprove").disabled = true;
    		document.getElementById("txtReason").disabled = true;
    		document.getElementById("btnReject").disabled = true;
    		document.getElementById("btnViewMore").disabled = true;
    		
    		document.getElementById("btnViewPrint").disabled = true;
    		document.getElementById("btnRecommend").disabled = true;
    		
    		 var estimateNoGloble
    	      var costCenterNoGloble;
    	      var approveEstimateNo;
    	      
    	     
    		//alert("hii");
    	    	  $.ajax({
    	    			type : 'GET',
    	    			url : "/MMS/getApprovalListNew",
    	    			data : {},
    	    			contentType : "application/json; charset=utf-8",
    	    			success : function(result) {
    	    				var datavaluepie = new google.visualization.DataTable();
    	    				datavaluepie.addColumn('string', 'Ceb Branch Name');
    	    				datavaluepie.addColumn('number', 'Number of Estmate');
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
    	    		          'fontSize': 10,
    	    		          'options': {
    	    		            'filterColumnLabel': 'Ceb Branch Name',
    	    		            'filterColumnIndex': 0,
    	    		            'useFormattedValue': true,
    	    		            'ui': {

    	    		                'label': 'Ceb Branch Name',
    	    		                'allowTyping': false,
    	    		                'allowMultiple': false,
    	    		                'caption' : 'All Ceb Branch',
    	    		                'allowNone': true,
    	    		                'selectedValuesLayout': 'belowStacked'
    	    		            }
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
    	    			            'pieSliceText': 'value',
    	    			            'text-align' : 'left',
    	    			            'legend': 'right',
    	    			            'width': 1200,
    	    			            'page': 'enable',
    	    			            'pageSize': 10,
    	    			            'pagingSymbols': {
    	    			                'prev': 'prev',
    	    			                'next': 'next'
    	    			            },
    	    			            'pagingButtonsConfiguration': 'auto',
    	    			            'cssClassNames': {
    	      			              'tableCell': 'small-font'
    	      			            },
    	      			          'headerRow': 'italic-darkblue-font large-font bold-font',
    	      			        'tableRow': '',
    	      			        'oddTableRow': 'beige-background',
    	      			        'selectedTableRow': 'orange-background large-font',
    	      			        'hoverTableRow': '',
    	      			        'headerCell': 'gold-border',
    	      			        'tableCell': '',
    	      			        'rowNumberCell': 'underline-blue-font'
    	    			     
    	    			          }
    	    			        });
    	  		        
    	    		        dashboard.bind(donutRangeSlider2, table);
    	    		        dashboard.draw(datavaluepie);
    	    		        
      
    	    			}
    	    	  });
    	    	  
    	    	  
    	    	  
    	    	  $.ajax({
		    			type : 'GET',
		    			url : "/MMS/getApprovalListByCostCenter/" +costcenterForList+"/" ,
		    			data : {},
		    			contentType : "application/json; charset=utf-8",
		    			success : function(result) {
		    				
		    				
		    				 
                           
		    				
		    				document.getElementById("btnApprove").disabled = true;
		    				document.getElementById("txtReason").disabled = true;
		    				document.getElementById("btnReject").disabled = true;
		    				document.getElementById("btnViewMore").disabled = true;
		    				
		    				document.getElementById("btnViewPrint").disabled = true;
		    				document.getElementById("btnRecommend").disabled = true;
		    				
		    				
		    				
		    				var datavalue = new google.visualization.DataTable();
		    				//datavalue.addColumn('string', 'Approve');
		    				
		    				datavalue.addColumn('string', 'Estimate Number');
		    				//datavalue.addColumn('string', 'Approve');
		    				
		    				datavalue.addColumn('string', 'Dept Id');
		    				datavalue.addColumn('string', 'Description');
		    				datavalue.addColumn('string', 'Categary Code');
		    				datavalue.addColumn('string', 'Fund Source');
		    				datavalue.addColumn('number', 'Rebate for Material');
		    				datavalue.addColumn('number', 'Estimated  Capital  Cost');
		    				datavalue.addColumn('number', 'Consumer Payable  Cost');
		    				//datavalue.addColumn('string', 'User Level');
		    				
		    				datavalue.addColumn('boolean', 'Recommendation');
		    				datavalue.addColumn('boolean', 'Approval');
	 						
		    				
		    				
		    				for (var i = 0; i < result.length; i++) {
		    						var data = result[i];
		    						var reco;
		    						var approval;
	    		    				
		    						 if(${sessionScope.loggedUserRole=='DGM'}){
		    							 if(data[7]>50000000){
		    								 reco=true;
		    								 approval=false;
		    							 }else{
		    								 approval=true;
		    								 reco=false;
		    								 
		    							 }
	    		    					// alert('hii');
	    		    				 }else if(${sessionScope.loggedUserRole=='CE'}){
	    		    					 if(data[7]>25000000){
		    								 reco=true;
		    								 approval=false;
		    							 }else{
		    								 approval=true;
		    								 reco=false;
		    								 
		    							 }
	    		    					
	    		    				 }
		    						 
	    		    				 else if(${sessionScope.loggedUserRole=='EE'}){
	    		    					 if(data[7]>5000000){
		    								 reco=true;
		    								 approval=false;
		    							 }else{
		    								 approval=true;
		    								 reco=false;
		    								 
		    							 }
	    		    					
	    		    				 }else if(${sessionScope.loggedUserRole=='AGM'}){
	    		    						 approval=true;
		    								 reco=false;
		    							
	    		    				 }
	    		    				
		    						//datavalue.addRows([['<a href="LINK">Approve</a>'],[data[0], data[1],data[2]]]);
		    						//datavalue.addRows([[data[0],'<button>Approve</button>', data[1]]]);
		    						datavalue.addRows([[data[0],data[1],data[2],data[5],data[6],data[3],data[7],data[4],reco,approval]]);
				    				
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
		      		            'filterColumnLabel': 'Estimate Number',
		      		            'filterColumnIndex': 0,
		      		            'useFormattedValue': true,
		      		            'ui': {

		      		                'label': 'Estimate Number',
		      		                'allowTyping': false,
		      		                'allowMultiple': false,
		      		                'caption' : 'All Estimate Number',
		      		                'allowNone': true,
		      		                'selectedValuesLayout': 'belowStacked'
		      		            }
		      		        }

		    		        });

		    		        
		    		       /*  var table = new google.visualization.ChartWrapper({
		    			          'chartType': 'Table',
		    			          'containerId': 'estaprtabledetail_div',
		    			          'options': {
		    			            'width': 1200,
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
		    		        */
		    		        
		    		        var table = new google.visualization.ChartWrapper({
	    			          'chartType': 'Table',
	    			          'containerId': 'estaprtabledetail_div',
	    			          'options': {
	    			            'allowHtml': true,
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
		    		        
		    		        // table.getChart().hideColumns([1]);

		    		        // Establish dependencies, declaring that 'filter' drives 'pieChart',
		    		        // so that the pie chart will only display entries that are let through
		    		        // given the chosen slider range.
		    		        dashboard.bind(donutRangeSlider3, table);

		    		        // Draw the dashboard.
		    		        dashboard.draw(datavalue, {allowHtml: true});
		    			}
		    			 });
	  		        
      }
      

function drawDashboard() {
	
	document.getElementById("btnApprove").disabled = true;
	document.getElementById("txtReason").disabled = true;
	document.getElementById("btnReject").disabled = true;
	document.getElementById("btnViewMore").disabled = true;
	
	document.getElementById("btnViewPrint").disabled = true;
	document.getElementById("btnRecommend").disabled = true;
	
	
	//alert("hii");
    	  $.ajax({
    			type : 'GET',
    			url : "/MMS/getApprovalListNew",
    			data : {},
    			contentType : "application/json; charset=utf-8",
    			success : function(result) {
    				var datavaluepie = new google.visualization.DataTable();
    				datavaluepie.addColumn('string', 'Ceb Branch Name');
    				datavaluepie.addColumn('number', 'Number of Estmate');
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
    		          'fontSize': 10,
    		          'options': {
    		            'filterColumnLabel': 'Ceb Branch Name',
    		            'filterColumnIndex': 0,
    		            'useFormattedValue': true,
    		            'ui': {

    		                'label': 'Ceb Branch Name',
    		                'allowTyping': false,
    		                'allowMultiple': false,
    		                'caption' : 'All Ceb Branch',
    		                'allowNone': true,
    		                'selectedValuesLayout': 'belowStacked'
    		            }
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
    			            'pieSliceText': 'value',
    			            'text-align' : 'left',
    			            'legend': 'right',
    			            'width': 1200,
    			            'page': 'enable',
    			            'pageSize': 10,
    			            'pagingSymbols': {
    			                'prev': 'prev',
    			                'next': 'next'
    			            },
    			            'pagingButtonsConfiguration': 'auto',
    			            'cssClassNames': {
      			              'tableCell': 'small-font'
      			            },
      			          'headerRow': 'italic-darkblue-font large-font bold-font',
      			        'tableRow': '',
      			        'oddTableRow': 'beige-background',
      			        'selectedTableRow': 'orange-background large-font',
      			        'hoverTableRow': '',
      			        'headerCell': 'gold-border',
      			        'tableCell': '',
      			        'rowNumberCell': 'underline-blue-font'
    			     
    			          }
    			        });
  		        
    		        dashboard.bind(donutRangeSlider2, table);
    		        //dashboard.bind(donutRangeSlider2, pieChart);
    		        dashboard.draw(datavaluepie);
    		        
    		        /* var optionspie = {
     			             title: 'Estimate Approval Summary',
     			             is3D : true,
     			             pieSliceText: 'label',
     			             tooltip :  {showColorCode: true},
     					     'height' : 400
     			         };
     			     
     			     		     
     			    var chart = new google.visualization.PieChart(document.getElementById('pie_div1'));
     			    chart.draw(datavaluepie, optionspie);
     			     */
    		        
    		        google.visualization.events.addListener(table, 'select', selectHandler);
    		       // google.visualization.events.addListener(pieChart, 'select', selectHandlerPieChart);
      		        function selectHandler() {
    		          //alert("hiii");
    		          var selectedItem = table.getChart().getSelection();
    		          
    		          if (selectedItem) {
    		        	 // alert("hiii2");
    		        	 
    		        	 var row = selectedItem[0].row;

		          var value=table.getDataTable().getValue(row, 2); 
		          //var status=table.getDataTable().getValue(row,4);
					costcenterForList = value;
    		        	 
    		          //  var value = datavaluepie.getValue(selectedItem.row, 2);
    		           // alert('The user selected ' + value);
    		            
    		            $.ajax({
    		    			type : 'GET',
    		    			url : "/MMS/getApprovalListByCostCenter/" +value+"/" ,
    		    			data : {},
    		    			contentType : "application/json; charset=utf-8",
    		    			success : function(result) {
    		    				
    		    				document.getElementById("btnApprove").disabled = true;
    		    				document.getElementById("txtReason").disabled = true;
    		    				document.getElementById("btnReject").disabled = true;
    		    				document.getElementById("btnViewMore").disabled = true;
    		    				
    		    				document.getElementById("btnViewPrint").disabled = true;
    		    				document.getElementById("btnRecommend").disabled = true;
    		    				
    		    				
    		    				
    		    				var datavalue = new google.visualization.DataTable();
    		    				//datavalue.addColumn('string', 'Approve');
    		    				
    		    				datavalue.addColumn('string', 'Estimate Number');
    		    				//datavalue.addColumn('string', 'Approve');
    		    				
    		    				datavalue.addColumn('string', 'Dept Id');
    		    				datavalue.addColumn('string', 'Description');
    		    				datavalue.addColumn('string', 'Categary Code');
    		    				datavalue.addColumn('string', 'Fund Source');
    		    				datavalue.addColumn('number', 'Rebate for Material');
    		    				datavalue.addColumn('number', 'Estimated  Capital  Cost');
    		    				datavalue.addColumn('number', 'Consumer Payable  Cost');
    		    				//datavalue.addColumn('string', 'User Level');
    		    				
    		    				datavalue.addColumn('boolean', 'Recommendation');
    		    				datavalue.addColumn('boolean', 'Approval');
    	 						
    		    				
    		    				
    		    				for (var i = 0; i < result.length; i++) {
    		    						var data = result[i];
    		    						var reco;
    		    						var approval;
    	    		    				
    		    						 if(${sessionScope.loggedUserRole=='DGM'}){
    		    							 if(data[7]>50000000){
    		    								 reco=true;
    		    								 approval=false;
    		    							 }else{
    		    								 approval=true;
    		    								 reco=false;
    		    								 
    		    							 }
    	    		    					// alert('hii');
    	    		    				 }else if(${sessionScope.loggedUserRole=='CE'}){
    	    		    					 if(data[7]>25000000){
    		    								 reco=true;
    		    								 approval=false;
    		    							 }else{
    		    								 approval=true;
    		    								 reco=false;
    		    								 
    		    							 }
    	    		    					
    	    		    				 }
    		    						 
    	    		    				 else if(${sessionScope.loggedUserRole=='EE'}){
    	    		    					 if(data[7]>5000000){
    		    								 reco=true;
    		    								 approval=false;
    		    							 }else{
    		    								 approval=true;
    		    								 reco=false;
    		    								 
    		    							 }
    	    		    					
    	    		    				 }else if(${sessionScope.loggedUserRole=='AGM'}){
    	    		    						 approval=true;
    		    								 reco=false;
    		    							
    	    		    				 }
    	    		    				
    		    						//datavalue.addRows([['<a href="LINK">Approve</a>'],[data[0], data[1],data[2]]]);
    		    						//datavalue.addRows([[data[0],'<button>Approve</button>', data[1]]]);
    		    						datavalue.addRows([[data[0],data[1],data[2],data[5],data[6],data[3],data[7],data[4],reco,approval]]);
    				    				
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
    		      		            'filterColumnLabel': 'Estimate Number',
    		      		            'filterColumnIndex': 0,
    		      		            'useFormattedValue': true,
    		      		            'ui': {

    		      		                'label': 'Estimate Number',
    		      		                'allowTyping': false,
    		      		                'allowMultiple': false,
    		      		                'caption' : 'All Estimate Number',
    		      		                'allowNone': true,
    		      		                'selectedValuesLayout': 'belowStacked'
    		      		            }
    		      		        }

    		    		        });

    		    		        
    		    		       /*  var table = new google.visualization.ChartWrapper({
    		    			          'chartType': 'Table',
    		    			          'containerId': 'estaprtabledetail_div',
    		    			          'options': {
    		    			            'width': 1200,
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
    		    		        */
    		    		        
    		    		        var table = new google.visualization.ChartWrapper({
  		    			          'chartType': 'Table',
  		    			          'containerId': 'estaprtabledetail_div',
  		    			          'options': {
  		    			            'allowHtml': true,
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
    		    		        	  
    		    		        	// alert('hiiii');
    		    		        	 var row = selectedItem[0].row;
    		    		        	var estimateNo = table.getDataTable().getValue(row, 0);
     		    		            var costCenterNo = table.getDataTable().getValue(row, 1);
     		    		            estimateNoGloble = estimateNo;
     		    		            costCenterNoGloble = costCenterNo;
     		    		           document.getElementById("txtEstNo").value = estimateNo;
     		    		          document.getElementById("txtCostCenter").value = costCenterNo;
     		    		         document.getElementById("btnApprove").disabled = false;
     		    				document.getElementById("txtReason").disabled = false;
     		    				document.getElementById("btnReject").disabled = false;
     		    				document.getElementById("btnViewMore").disabled = false;
     		    				
     		    				document.getElementById("btnViewPrint").disabled = false;
     		    				document.getElementById("btnRecommend").disabled = false;
     		    				
     		    				
     		    				 //viewMore();
	     		    		        //viewPrint();
 		    		           
     		    		          
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
    		    		         }
    		    		         }
    		    		        google.visualization.events.addListener(table, 'select', selectHandler);
 

 
     		    		        
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
		return "Any Modification can  be done to the estimate";			 
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
		return "This estimate has rejected";		 
	case 30:
		return "This estimate has approved (PIV II can issue for this estimate)";			 
	case 33:
		return "PIV II Confirmed but Job number has not generated";			 
	case 22:
		return "to be Generated Job number";			 
	case 1:
		return "Job transfered to MITFIN for issue materials to the contractor";
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
		return "Other";
		 
	}

}

function viewMoreEmpty(){
	if(estimateNoGloble){
		$.ajax({
			type : 'GET',
			url : "/MMS/getEstimateDetailAll?estimateNo=xxx&deptid=xxx",
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

function refreashGrid(){
	//alert(costcenterForList);
    $.ajax({
    		    			type : 'GET',
    		    			url : "/MMS/getApprovalListByCostCenter/" +costcenterForList+"/" ,
    		    			data : {},
    		    			contentType : "application/json; charset=utf-8",
    		    			success : function(result) {
    		    				
    		    				
    		    				 
                                 
    		    				
    		    				document.getElementById("btnApprove").disabled = true;
    		    				document.getElementById("txtReason").disabled = true;
    		    				document.getElementById("btnReject").disabled = true;
    		    				document.getElementById("btnViewMore").disabled = true;
    		    				
    		    				document.getElementById("btnViewPrint").disabled = true;
    		    				document.getElementById("btnRecommend").disabled = true;
    		    				
    		    				
    		    				
    		    				var datavalue = new google.visualization.DataTable();
    		    				//datavalue.addColumn('string', 'Approve');
    		    				
    		    				datavalue.addColumn('string', 'Estimate Number');
    		    				//datavalue.addColumn('string', 'Approve');
    		    				
    		    				datavalue.addColumn('string', 'Dept Id');
    		    				datavalue.addColumn('string', 'Description');
    		    				datavalue.addColumn('string', 'Categary Code');
    		    				datavalue.addColumn('string', 'Fund Source');
    		    				datavalue.addColumn('number', 'Rebate for Material');
    		    				datavalue.addColumn('number', 'Estimated  Capital  Cost');
    		    				datavalue.addColumn('number', 'Consumer Payable  Cost');
    		    				//datavalue.addColumn('string', 'User Level');
    		    				
    		    				datavalue.addColumn('boolean', 'Recommendation');
    		    				datavalue.addColumn('boolean', 'Approval');
    	 						
    		    				
    		    				
    		    				for (var i = 0; i < result.length; i++) {
    		    						var data = result[i];
    		    						var reco;
    		    						var approval;
    	    		    				
    		    						 if(${sessionScope.loggedUserRole=='DGM'}){
    		    							 if(data[7]>50000000){
    		    								 reco=true;
    		    								 approval=false;
    		    							 }else{
    		    								 approval=true;
    		    								 reco=false;
    		    								 
    		    							 }
    	    		    					// alert('hii');
    	    		    				 }else if(${sessionScope.loggedUserRole=='CE'}){
    	    		    					 if(data[7]>25000000){
    		    								 reco=true;
    		    								 approval=false;
    		    							 }else{
    		    								 approval=true;
    		    								 reco=false;
    		    								 
    		    							 }
    	    		    					
    	    		    				 }
    		    						 
    	    		    				 else if(${sessionScope.loggedUserRole=='EE'}){
    	    		    					 if(data[7]>5000000){
    		    								 reco=true;
    		    								 approval=false;
    		    							 }else{
    		    								 approval=true;
    		    								 reco=false;
    		    								 
    		    							 }
    	    		    					
    	    		    				 }else if(${sessionScope.loggedUserRole=='AGM'}){
    	    		    						 approval=true;
    		    								 reco=false;
    		    							
    	    		    				 }
    	    		    				
    		    						//datavalue.addRows([['<a href="LINK">Approve</a>'],[data[0], data[1],data[2]]]);
    		    						//datavalue.addRows([[data[0],'<button>Approve</button>', data[1]]]);
    		    						datavalue.addRows([[data[0],data[1],data[2],data[5],data[6],data[3],data[7],data[4],reco,approval]]);
    				    				
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
    		      		            'filterColumnLabel': 'Estimate Number',
    		      		            'filterColumnIndex': 0,
    		      		            'useFormattedValue': true,
    		      		            'ui': {

    		      		                'label': 'Estimate Number',
    		      		                'allowTyping': false,
    		      		                'allowMultiple': false,
    		      		                'caption' : 'All Estimate Number',
    		      		                'allowNone': true,
    		      		                'selectedValuesLayout': 'belowStacked'
    		      		            }
    		      		        }

    		    		        });

    		    		        
    		    		       /*  var table = new google.visualization.ChartWrapper({
    		    			          'chartType': 'Table',
    		    			          'containerId': 'estaprtabledetail_div',
    		    			          'options': {
    		    			            'width': 1200,
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
    		    		        */
    		    		        
    		    		        var table = new google.visualization.ChartWrapper({
  		    			          'chartType': 'Table',
  		    			          'containerId': 'estaprtabledetail_div',
  		    			          'options': {
  		    			            'allowHtml': true,
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
    		    		        
    		    		        // table.getChart().hideColumns([1]);

    		    		        // Establish dependencies, declaring that 'filter' drives 'pieChart',
    		    		        // so that the pie chart will only display entries that are let through
    		    		        // given the chosen slider range.
    		    		        dashboard.bind(donutRangeSlider3, table);

    		    		        // Draw the dashboard.
    		    		        dashboard.draw(datavalue, {allowHtml: true});
    		    			}
    		    			});
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

function refresh(){
	//drawDashboard();
	drawDashboard();
	viewMoreEmpty();
	refreashGrid();
}


function approve(){
	  
	  //alert(approveEstimateNo);
	  //alert(estimateNoGloble);
	if(approveEstimateNo != estimateNoGloble){
	if(estimateNoGloble){
		
		var r = confirm("You are going to approve estimate number :" + estimateNoGloble);
		if (r == true) {
			$.ajax({
				type : 'GET',
				url : "/MMS/approveEstimate?estimateNo="+ estimateNoGloble +"&deptId="+costCenterNoGloble,
				data : {},
				contentType : "application/json",
				success : function(result) {
					//drawDashboard();
					//viewMoreEmpty();
					//refreashGrid();
					approveEstimateNo=estimateNoGloble;
					
					//alert("Successfully Approved");
					document.getElementById('txtEstNo').value = '';
					document.getElementById("btnApprove").disabled = true;
					document.getElementById("txtReason").disabled = true;
					document.getElementById("btnReject").disabled = true;
					document.getElementById("btnViewMore").disabled = true;
					
					document.getElementById("btnViewPrint").disabled = true;
					alert(result);
					
					//alert(result);	
					//drawDashboard();
					
					
				},
				error: function(jqxhr) {
		            alert(jqxhr.responseText); // @text = response error, it is will be errors: 324, 500, 404 or anythings else
		          }
				
		         
			});
			
			drawDashboard();
			viewMoreEmpty();
			refreashGrid();
			
			
		} else {
  			
		}
	}else{
		alert("Please select estimate number");
	}
	}else{
		alert("Estimate number is already approved");
	}
	
}


function recommend(){
	  
	if(approveEstimateNo != estimateNoGloble){
		if(estimateNoGloble){
			
			var r = confirm("You are going to recommend estimate number :" + estimateNoGloble);
			if (r == true) {
				$.ajax({
					type : 'GET',
					url : "/MMS/recommendEstimate?estimateNo="+ estimateNoGloble +"&deptId="+costCenterNoGloble,
					data : {},
					contentType : "application/json",
					success : function(result) {
						//drawDashboard();
						//viewMoreEmpty();
						//refreashGrid();
						approveEstimateNo=estimateNoGloble;
						
						//alert("Successfully Approved");
						document.getElementById('txtEstNo').value = '';
						document.getElementById("btnApprove").disabled = true;
						document.getElementById("txtReason").disabled = true;
						document.getElementById("btnReject").disabled = true;
						document.getElementById("btnViewMore").disabled = true;
						
						document.getElementById("btnViewPrint").disabled = true;
						alert(result);
						
						//alert(result);	
						//drawDashboard();
						
						
					},
					error: function(jqxhr) {
			            alert(jqxhr.responseText); // @text = response error, it is will be errors: 324, 500, 404 or anythings else
			          }
					
			         
				});
				
				drawDashboard();
				viewMoreEmpty();
				refreashGrid();
				
				
				
			} else {
	  			
			}
		}else{
			alert("Please select estimate number");
		}
		}else{
			alert("Estimate number is already recommended");
		}
	
}



function reject(){
	  
	  var empt = document.getElementById("txtReason").value;
	  if (empt === "Reject Reason")
		{
		alert("Reason may not be empty");
		event.preventDefault();
		return false;
	  }
	  if(approveEstimateNo != estimateNoGloble){
			
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
				approveEstimateNo=estimateNoGloble;
				
				//alert("Successfully Done");
				drawDashboard();
				viewMoreEmpty();
				refreashGrid();
			} else {
	  			
			}
		}else{
			alert("Please select estimate number");
		}
		}else{
			alert("Estimate number is already rejected");
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



					<!-- <div class="container">

						<div class="jumbotron">

							<div class="row ">
 -->

								
								<!-- <div class="col-sm-10" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
								</div>
 -->								
								<!-- <div class="col-sm-12" align="left">

									<div class="row">

										<div id="filter_div"></div>
      
									</div>
								</div>
 -->																 								
								
								<!-- <div class="col-sm-12" align="left">
																
								<div class="main-box clearfix">
								
								<div id="table-responsive" class="table-scroll">
									<div class="table-scroll">
										<table class="table table-responsive" id="tblProvinces">

<tr>
<td><input type="text" id ="txtEstNo" style="background-color:#FCA2A8;" Value="Estimate No to be Approved" class="form-control" disabled/></td>
<td><input type="hidden" id ="txtCostCenter" Value="Estimate No to be Approved" class="form-control" disabled/></td>

</tr>
<tr>
<td><input type="submit" id ="btnApprove" Value="Approve" class="btn btn-success" onClick="approve()"/></td>
<td><input type="text" id ="txtReason" Value="Reason" class="form-control"/></td>

<td><input type="submit" id ="btnReject" Value="Reject" class="btn btn-success" onClick="reject()" /></td>
<td><input type="submit" id ="btnViewMore" Value="View More" class="btn btn-warning" onClick="viewMore()" /></td>
<td><input type="submit" id ="btnViewPrint" Value="View Estimate Print Out" class="btn btn-success" onClick="viewPrint()" /></td>

</tr>
</table>
</div>
</div>
</div>
</div>
 -->

													
								
								
								

							<!-- </div>
						</div>
					</div>
 -->



<!-- <div class="container">


						<div class="row">
							<div class="col-lg-12">

								<div class="row">
									
									
										<div class="table-responsive" >
								<div class="wrimagecardNew1 wrimagecard-topimage">
						<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
													<div id="dashboard_div">
      Divs that will hold each control and chart
      <div id="pie_div1"></div>

												</div>
												
																					</div>
									</div>
									</div>
</div>
</div>
</div>
</div>
 -->




					<div class="container">
					
					
					<!-- <div class="row">


						<div class="col-lg-12">
							<div class="col-lg-9">
								<ol class="breadcrumb">
									<li class="active"><span>Estimate Approval Summary Details : Please select the CEB Branch</span></li>
									</ol>

								
							</div>

							
						</div>

					</div>
 -->					
					
					
					
					
					<div class="row">
							<div class="col-lg-12">
							
							

								<div class="row">
								
								<br>
								<div class="table-responsive" >
								<div class="wrimagecardNew1 wrimagecard-topimage">
								
								<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
													  						
													<div>Please select the ceb branch from the table</div>
														<br>
														<div id="filter_div2"></div>
    
												
												
													<div id="dashboard_div">
													<br>
      <!--Divs that will hold each control and chart-->
      <div id="estaprtable_div"></div>

												
												
											</div>
											</div>
										</div>
								
								
								
								
								
								
								
										
								<!-- <div id="dashboard_div">
      								<div id="filter_div2"></div>
												<br>
									<div id="estaprtable_div"></div>
      
								</div>
		 -->			</div>
					</div>
					</div>
					</div>
					</div>
						
														
								<br>
								
								
								<!-- <div class="feature-box">
								<p>Estimate Details : Please select the Estimate Number : </p>
								
								<div style="background-color: #FFFFFF;border: solid 1px black;height:60px;font-size:18px;color:black;">Estimate Approval Summary Details : Please select the CEB Branch</div>
								
          </div> -->
								<br>
					<div class="container">
					
					<!-- <div class="row">


						<div class="col-lg-12">
							<div class="col-lg-9">
								<ol class="breadcrumb">
									<li class="active"><span>Estimate Details : Please select the Estimate Number</span></li>
									</ol>

								
							</div>

							
						</div>

					</div>
 -->					

						<div class="row">
							<div class="col-lg-12">

								<div class="row">
								
								<div class="table-responsive" >
								<div class="wrimagecardNew2 wrimagecard-topimage">
								
								<div class="wrimagecard-topimage_header"
												style="background-color: #a1d0d0; border-radius: 5px;">
												<div>Please select the estimate number from the table</div>
												<br>
																									<div id="dashboard_div">
      <!--Divs that will hold each control and chart-->
      <div id="filter_div3"></div>
      <br>
      <div id="estaprtabledetail_div"></div>

												
												
											</div>
											
										</div>
										</div>
								
								
								
								
									<!-- <div id="dashboard_div">
									<div id="filter_div3"></div>
									<br>
      
      <div id="estaprtabledetail_div"></div>
      
      
<input type="text" id ="txtEstNo" style="background-color:#FCA2A8;" Value="Estimate Number to be Approved" class="form-control" disabled/>
<input type="hidden" id ="txtCostCenter" Value="Estimate No to be Approved" class="form-control" disabled/>
<input type="submit" id ="btnApprove" Value="Approve" class="btn btn-success" onClick="approve()" class="form-control"/>
<input type="text" id ="txtReason" Value="Reject Reason" class="form-control"/>
<input type="submit" id ="btnReject" Value="Reject" class="btn btn-success" onClick="reject()" class="form-control"/>
<input type="submit" id ="btnViewMore" Value="View More" class="btn btn-warning" onClick="viewMore()" />
<input type="submit" id ="btnViewPrint" Value="View Estimate Print Out" class="btn btn-success" onClick="viewPrint()" />


      

												</div>
 -->								</div>
								</div>
								</div>
								</div>
								</div>
								
								<div class="container">
								<div class="row">
								<div class="col-lg-12">
								<input type="text" id ="txtEstNo" style="background-color:#FCA2A8;" Value="Estimate Number to be Approved" class="form-control" disabled/>
   
								</div>
								<div class="col-lg-12">
								
								<div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
								<div class="input-group">
     <!-- <div class="input-group-prepend">
      <div class="input-group-text" id="btnGroupAddon">@
 </div>
    </div> -->
<input type="text" id ="txtReason" Value="Reject Reason" class="form-control"/>
<input type="hidden" id ="txtCostCenter" Value="Estimate No to be Approved" class="form-control" disabled/>

</div>
  <div class="btn-group mr-2" role="group" aria-label="First group">
    <div class="btn-group" role="group" aria-label="Basic example">
    <button id ="btnApprove" type="button" class="btn btn-secondary" onClick="approve()">Approve</button>
   <button id ="btnRecommend" type="button" class="btn btn-secondary" onClick="recommend()">Recommend</button>
   
   <button id ="btnReject" type="button" class="btn btn-secondary" onClick="reject()">Reject</button>
   <button type="button" id ="btnViewMore" class="btn btn-secondary" onClick="viewMore()">View More Details</button>
  <button type="button" id ="btnViewPrint" class="btn btn-secondary" onClick="viewPrint()">View Print Out</button>
  <button type="button" id ="btnViewPrint" class="btn btn-secondary" onClick="drawDashboard()">Refresh</button>
</div>
</div>
  
</div>
								
								
								
								<!-- <table class="table-responsive">
<tr>
<td><input type="text" id ="txtEstNo" style="background-color:#FCA2A8;" Value="Estimate Number to be Approved" class="form-control" disabled/>
</td>
</tr>
<tr>
<input type="hidden" id ="txtCostCenter" Value="Estimate No to be Approved" class="form-control" disabled/>




<td>
<input type="submit" id ="btnApprove" Value="Approve" class="btn btn-success" onClick="approve()"/></td>
<td><input type="text" id ="txtReason" Value="Reject Reason" class="form-control"/></td>

<td><input type="submit" id ="btnReject" Value="Reject" class="btn btn-success" onClick="reject()"/></td>
<td><input type="submit" id ="btnPrint" Value="View Print Out" class="btn btn-success" onClick="viewPrint()"/></td>
</tr>
</table>
 -->	</div>							
								
								
								
								
								
								</div>
					</div>
								
								<!-- <div class="row">
<div class="col-lg-11">
<div class="col-lg-9">
<input type="text" id ="txtEstNo" style="background-color:#FCA2A8;" Value="Estimate Number to be Approved" class="form-control" disabled/>
<input type="hidden" id ="txtCostCenter" Value="Estimate No to be Approved" class="form-control" disabled/>
</div>
</div>
</div>

<div class="row">
<div class="col-lg-11">
<div class="col-lg-9">
<input type="submit" id ="btnApprove" Value="Approve" class="btn btn-success" onClick="approve()" class="form-control"/>
</div>
</div>
</div>
<br>
<div class="row">
<div class="col-lg-11">
<div class="col-lg-9">
<input type="text" id ="txtReason" Value="Reject Reason" class="form-control"/>
</div>
</div>
</div>
<div class="row">
<div class="col-lg-11">
<div class="col-lg-9">
<input type="submit" id ="btnReject" Value="Reject" class="btn btn-success" onClick="reject()" class="form-control"/>
</div>
</div>
</div>
 -->								
								
								<br><br>
								
					<div class="container">
					
					

						<div class="row">
							<div class="col-lg-12">

								<div class="row">
								
								<div class="table-responsive" >

									<div id="dashboard_div">
									
									<div id="estdetail_div"></div>
<br>
<div id="filter_div8"></div>
									<br>
      								
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