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
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">

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
/*woh*/

/* Style the tab */
.tab {
  float: left;
  border: 1px solid maroon;
  background-color: #ffffff;
  opacity: 0.7;
  width: 25%;
  height: 800px;
}
    table, th, td {
  border: 1px solid black;
}
    table2, th, td {
  border: 1px solid black;
}

/* Style the buttons inside the tab */
.tab button {
  display: block;
  background-color: inherit;
  color: black;
  padding: 22px 16px;
  width: 100%;
  border: none;
  outline: none;
  text-align: left;
  cursor: pointer;
  transition: 0.3s;
  font-size: 16px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current "tab button" class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  float: left;
  background-color: #f1f1f1;
  padding: 0px 12px;
  border: 1px solid maroon;
  width: 75%;
  border-left: none;
  height: 940px;
    
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
    
   
    
    
    
.collapsible {
  background:linear-gradient(135deg, #dfe302, #871b00); 
  opacity: 0.8;
  color: white;
  cursor: pointer;
  padding: 18px;
  width: 100%;
  border-width:1px;
  border-color:aliceblue;
  outline: none;
  font-size: 15px;
}

.active, .collapsible:hover {
  background-color: #555;
}

.content {
  padding: 0 18px;
  display: none;
  overflow: hidden;
  background-color: #f1f1f1;
}  
    
   .title{
        background-color: maroon;
        height: 50px;
    }   
   h2{
        color: yellow;
        margin-top:10px;
        margin-left: 430px
    }
    .button3{
        margin-left: 520px;
        margin-top: 5px;
        width:100px;
        height:50px ;
        border-radius: 10px;
        background:linear-gradient(135deg, maroon, #fff);
        font-family: sans-serif;
        font-size: 20px;
        color: aliceblue;
       
    }
    .button3:hover {
  background: linear-gradient(135deg, #fff,maroon );
}


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

html, body {
    max-width: 100%;
    overflow-x: hidden;
}


div.main{
  margin: 20px 10px -100px 10px;
}

#drop{
  padding: 2px 20px;
  cursor: pointer;
  font-size: 12px;
  color: #595656;
}

/*.input_field{
  margin-left: 460px;
}*/

.button {
  border: none;
  color: white;
  padding: 14px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}







td{
  font-size: 13.5px;
}

th{
  font-size: 14px;
}

h4{
  padding-left: 79px;
  font-size: 18px;
  margin-top: 50px;
}

#mainnw2{
	margin: 150px;
}

div.register{
	background-color: rgba(0,0,0,0.5);
	width: 100%;
	font-size: 16px;
	border-radius: 10px;
}

.heading{
  background-color: #9f0e31;
  color: white;
}

form#register{
	margin: 80px;
}

label{
	font-size: 13px;
}


.wrapper .form .input_field{
	margin-bottom: 10px;
	display: flex;
	align-items: center;
}

.wrapper .form .input_field label{
	width: 170px;
}


input#name{
	width: 250px;
	outline: 0;
	padding: 3px;
}

input#name2{
  width: 50px;

  border-radius: 3px;
  outline: 0;
  padding: 3px;
  background-color: #fff;
}

#btn{
	width: 75px;
	padding: 1px 8px;
	font-size: 13px;
	background-color: #9c9797;
	color: black;
	cursor: pointer;
}

input#btn:hover{
	background-color: black;
	font-size: 13px;
  color: white;
}

.up{
	position: relative;
	bottom: 62px;
}

.upnew{
	position: relative;
	bottom: 58px;
}

.button1{
  height: 10px;
  position: relative;
  margin-left: 20px;
}

.center {
  margin: 0;
  position: absolute;
  top: -1100%;
  left: 20%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-20%, -130%);
}

 .rowt1 {
        transition: all .2s ease-in;
        cursor: pointer;
        font-size: 10px;
    }

  .rowt {
        transition: all .2s ease-in;
        cursor: pointer;
        font-size: 10px;
    }


	#headert {
        background-color: #16a085;
        color: #fff;
    }
    
    .rowt:hover {
        background-color: #f5f5f5;
        transform: scale(1.02);
    }

     .rowt1:hover {
        background-color: #f5f5f5;
        transform: scale(1.02);
    }
    
    @media only screen and (max-width: 768px) {
        table {
            width: 90%;
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



var estimateNoGloble;
var costCenterNoGloble;

function requestType(key){
	  switch (key) {
	case "MNTREQ":
		return "Maintenance Request ";			 
	case "INTREQ":
		return "Interruption Request";			 
	case "INSREQ":
		return "Inspection Request";	
	default:
		return "Other";
		 
	}

}

function searchStatus(key){
	  switch (key) {
		case "20":
			return "Removed";			 
		case "6":
			return "Pending";			 
		case "95":
			return "Forwarded";	
		case "96":
			return "Recommend";	
		case "97":
			return "Not Recommend";
		case "99":
			return "Forwarded to ES";
		case "98":
			return "Estimate Generated";
		default:
			return "Other";
			 
		

    }
}




function drawDashboard() {
	 // alert("hii");
   	  $.ajax({
			type : 'GET',
			url : "/MMS/ActionOnInIntReq?mode=INT",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				var datavaluepie = new google.visualization.DataTable();
				datavaluepie.addColumn('string', 'Interruption No');
				datavaluepie.addColumn('string', 'Area');
				datavaluepie.addColumn('string', 'Section to be Interrupted');
				datavaluepie.addColumn('string', 'Time Duration');
				datavaluepie.addColumn('string', 'Requested EE/ES');
				datavaluepie.addColumn('string', 'Field work');
				//var jsonData = JSON.parse(result);
				 for (var i = 0; i < result.length; i++) {
						var data = result[i];
						//var type = requestType(data[1]);
						datavaluepie.addRows([[data.approvalId,data.referenceNo,data.fromto,data.timeduration,data.reason,data.req2]]);
				}
				 
				 
			     // Create a dashboard.
		        var dashboard = new google.visualization.Dashboard(
		            document.getElementById('dashboard_div'));

		        // Create a range slider, passing some options
		        var donutRangeSlider2 = new google.visualization.ControlWrapper({
		          'controlType': 'CategoryFilter',
		          'containerId': 'filter_div2',
		          'options': {
		        	'filterColumnLabel': 'Interruption No'
		          }
		        });
		        
		        
		        

		        
		        var table = new google.visualization.ChartWrapper({
			          'chartType': 'Table',
			          'containerId': 'psaprtable_div',
			          'options': {
			            'width': 1300,
			            'height': 300,
			            'pieSliceText': 'value',
			            'legend': 'right'
			          }
			        });
		        
		        
		        dashboard.bind(donutRangeSlider2, table);
		        
		        dashboard.draw(datavaluepie);
		       // google.visualization.events.addListener(chart, 'ready', selectHandler);

		        google.visualization.events.addListener(table, 'select', selectHandler);
 		        function selectHandler() {
		          //alert("hiii");
		          var selectedItem = table.getChart().getSelection();
		          
		          if (selectedItem) {
		        	 // alert("hiii2");
		             var row = selectedItem[0].row;
   		         	 var type = table.getDataTable().getValue(row, 0);
   		         	document.getElementById("txtEstNo").value = type;
   		           // table.getChart().setSelection([{row: row}]);
   		    	     		   		        

 		   		}
 		   		 		             
		         }
		        }
		        
		        		});

	  
	  

	  
	      
     }
     
function viewLetter(){
	
	var intNo = document.getElementById("txtEstNo").value;
		if(intNo !="Request No to be Forwarded"){
			 var url="downloadInterruptionReq?id="+intNo;
    	    var width = 1100;
    	    var height = 700;
    	    var left = parseInt((screen.availWidth/2) - (width/2));
    	    var top = parseInt((screen.availHeight/2) - (height/2));
    	    var windowFeatures = "width=" + width + ",height=" + height + 
    	    ",status,resizable,left=" + left + ",top=" + top +
    	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
    	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
    	   
			
			
		}else{
			alert("Please select the Interruption Request Number");
		}
		
	}
	
function forwardRequest(){
	
	var pname = document.getElementById("forwaded").value;
	var approvedNo = document.getElementById("txtApproved").value;
	
	//alert(pname);
	var strUser = "60041ES1";
		
		var id = document.getElementById("txtEstNo").value;
		//alert(id);
		if(!approvedNo){
			
		if(id !="Request No to be Forwarded"){
			
		 $.ajax({
			type : 'GET',
			url : "/MMS/sendRequestToArea/" +id+ "/"+ pname + "/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				document.getElementById("txtApproved").value = id;
				
				alert("Succesfully forwarded...Email-SMS is succesfully sent to relevent Area Engineer ");
				drawDashboard();
				
			}
		});
	 	}else{
			alert("Please select the Interruption Request Number");
		}
		}else{
			alert("You have already forwarded this Interruption Request");
		}
}


function removeRequest(id){

	var pname = document.getElementById("forwaded").value;
	var approvedNo = document.getElementById("txtApproved").value;
	var strUser = "60041ES1";
		
		var id = document.getElementById("txtEstNo").value;
		if(!approvedNo){
		if(id !="Request No to be Forwarded"){
			 $.ajax({
			type : 'GET',
			url : "/MMS/removeRequest/" +id +"/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				document.getElementById("txtApproved").value = id;
				alert("Succesfully removed...");
				drawDashboard();
				
			}
		}); 
		}else{
			alert("Please select the Interruption Request Number");
		}
		
		}else{
			alert("You have already removed this Interruption Request");
		}
		
}


     
     
     

</script>








<!-- <script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&libraries=geometry">
	
</script>
 -->
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
		}else{
			loadNetwork();
		}
		
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
                url: "/MMS/MapNewProvince/" + strArea +"/" + strLine + "/" +strProvince,
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
        						  
        						  
        						 
        						  if(data[1].noofmissingparts<=2){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Green.png"/>',
                  						title: "Click here to view details of Tower No "+data[0].towerNo + "Weightage :" + data[1].noofmissingparts,
                  						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
                  					});
      								
             						 }
             						 else if(data[1].noofmissingparts<=5){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Blue.png"/>',
                  						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + data[1].noofmissingparts,
                  						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
                  					});
      								
             						 }
             						
             						 else if(data[1].noofmissingparts<=8){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Orange.png"/>',
                  						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + data[1].noofmissingparts,
                  						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
                  					});
      								
             						 }
             						 else{
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/Way_Red.png"/>',
                  						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + data[1].noofmissingparts,
                  						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
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
                url: "/MMS/MapNewProvince/" + strArea +"/" + strLine + "/" +strProvince,
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
        						  
        						  
        						  if(data[1].conductorstatus.indexOf('Good')== 0){
       							   	   var countGood = 0;
       							       count = count + countGood;
       							       //alert(count);
       						  	  }
        						  if(data[1].conductorstatus.indexOf('Ground clearance not enough')== 0){
      							   	   var countGood = 2;
      							       count = count + countGood;
      							       //alert(count);
      						  	  }
        						  if(data[1].conductorstatus.indexOf('Damaged')== 0){
     							   	   var countGood = 3;
     							       count = count + countGood;
     							       //alert(count);
     						  	  }
        						  if(data[1].conductorstatus.indexOf('Danger')== 0){
    							   	   var countGood = 4;
    							       count = count + countGood;
    							       //alert(count);
    						  	  }
        						  if((data[1].conductorstatus.indexOf('Good')== -1) && (data[1].conductorstatus.indexOf('Danger')== -1) && (data[1].conductorstatus.indexOf('Damaged')== -1) && (data[1].conductorstatus.indexOf('Ground clearance not enough')== -1) ){
   							   	   var countGood = 1;
   							       count = count + countGood;
   							       //alert(count);
   						  	      } 
        						  
        						  
        						  
        						  if(count<=1){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Green.png"/>',
                  						title: "Click here to view details of Tower No "+data[0].towerNo + "Weightage :" + count,
                  						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
                  					});
      								
             						 }
             						 else if(count<=3){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Blue.png"/>',
                  						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
                  						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
                  					});
      								
             						 }
             						
             						 else if(count<=5){
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Orange.png"/>',
                  						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
                  						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
                  					});
      								
             						 }
             						 else{
             							var marker = new google.maps.Marker({
                  						position: latLng,
                  						map: map,
                  						icon: '<c:url value="/resources/img/CEBImages/Way_Red.png"/>',
                  						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
                  						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
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
                url: "/MMS/MapNewProvince/" + strArea +"/" + strLine + "/" +strProvince,
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
            						title: "Click here to view details of Tower No "+data[0].towerNo + "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }
       						 else if(count<=5){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Blue.png"/>',
            						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }
       						
       						 else if(count<=8){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Orange.png"/>',
            						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }
       						 else{
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/Way_Red.png"/>',
            						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
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
                url: "/MMS/MapNewProvince/" + strArea +"/" + strLine + "/" +strProvince,
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
        						  
        						  
        						  if(data[1].wayleavestatus.indexOf('GOOD')== 0){
        							   var countGood = 0;
        							   count = countGood;
        							   //alert(count);
        						  }
        						  if(data[1].wayleavestatus.indexOf('Good')== 0){
       							   	   var countGood = 0;
       							       count = count + countGood;
       							       //alert(count);
       						  	  }
        						  if(data[1].wayleavestatus.indexOf('ARROUND')== 0){
      							   	   var countGood = 1;
      							       count = count + countGood;
      							       //alert(count);
      						  	  }
        						  if(data[1].wayleavestatus.indexOf('Along')== 0){
     							   	   var countGood = 2;
     							       count = count + countGood;
     							       //alert(count);
     						  	  }
        						  if(data[1].wayleavestatus.indexOf('ALONG')== 0){
    							   	   var countGood = 2;
    							       count = count + countGood;
    							       //alert(count);
    						  	  }
        						  if(data[1].wayleavestatus.indexOf('Close')== 0){
   							   	   var countGood = 3;
   							       count = count + countGood;
   							       //alert(count);
   						  	      }
        						  if(data[1].wayleavestatus.indexOf('CLOSE')== 0){
      							   	   var countGood = 3;
      							       count = count + countGood;
      							       //alert(count);
      						  	  }
        						  if(data[1].wayleavestatus.indexOf('DANGER')== 0){
     							   	   var countGood = 4;
     							       count = count + countGood;
     							       //alert(count);
     						  	  }
        						  if(data[1].wayleavestatus.indexOf('TOUCH')== 0){
     							   	   var countGood = 5;
     							       count = count + countGood;
     							       //alert(count);
     						  	  }
        						  if(data[1].wayleavestatus.indexOf('Tough')== 0){
    							   	   var countGood = 5;
    							       count = count + countGood;
    							       //alert(count);
    						  	  }
      						 
      						 
       						 if(count<=2){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Green.png"/>',
            						title: "Click here to view details of Tower No "+data[0].towerNo + "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }
       						 else if(count<=5){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Blue.png"/>',
            						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }
       						
       						 else if(count<=8){
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Orange.png"/>',
            						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }
       						 else{
       							var marker = new google.maps.Marker({
            						position: latLng,
            						map: map,
            						icon: '<c:url value="/resources/img/CEBImages/Way_Red.png"/>',
            						title: "Click here to view details of Tower No "+data[0].towerNo+ "Weightage :" + count,
            						label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].towerNo }
            					});
								
       						 }
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
									
								 /* var url = '<div id="content">'+
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

	


	
	
	function moveCam(moveLatLng, map){
		if(moveLatLng == null){
			alert("Are you sure?" + moveLatLng);
		}else{
			
		}
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
	            						title: "Click here to view details of Tower No "+data.towerNo
	            						
	            					});
									 
								  }
							  else if(data.supportType == 2){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						icon: '<c:url value="/resources/img/CEBImages/polemarkere.png"/>',
	            						title: "Click here to view details of Tower No "+data.towerNo
	            						});
								  }
							  else if(data.supportType == 3){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_yellow.png',
	            						title: "Click here to view details of Tower No "+data.towerNo
	            						
	            					});
							  }else if(data[0].supportType == 4){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_purple.png',
	            						title: "Click here to view details of Tower No "+data.towerNo
	            						            					});
							  }else if(data[0].supportType == 5){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            					    icon: 'http://labs.google.com/ridefinder/images/mm_20_green.png',
	            						title: "Click here to view details of Tower No "+data.towerNo
	            						
	            					});
							  }else if(data[0].supportType == 6){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_blue.png',
	            						title: "Click here to view details of Tower No "+data.towerNo
	            						
	            					});
							  }else if(data[0].supportType == 7){
									var marker = new google.maps.Marker({
	            						position: latLng,
	            						map: map,
	            						icon: 'http://labs.google.com/ridefinder/images/mm_20_orange.png',
	            						title: "Click here to view details of Tower No "+data.towerNo
	            						
	            					});
							  }else{
									
	        					var marker = new google.maps.Marker({
	        						position: latLng,
	        						map: map,
	        						icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
	        						title: "Click here to view details of Tower No "+data.towerNo
	        						
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
                url: "/MMS/MapNewOther/" + strArea +"/" + strLine +"/"+strProvince,
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
		        						title: "Click here to view details of Tower No "+data[0].towerNo + " ID " + data[0].id,
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
		                              strokeOpacity: 2.0,
		                              strokeWeight: 4
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
	
	 function approve(){
   		if(estimateNoGloble){
   			
   			var r = confirm("You are going to approve document number :" + estimateNoGloble);
   			if (r == true) {
   				$.ajax({
   					type : 'GET',
   					url : "/MMS/approvePSData?docno="+ estimateNoGloble,
   					data : {},
   					contentType : "application/json; charset=utf-8",
   					success : function(data) {
   						//drawDashboard();
   						
   					}
   				});
   				//
   				drawDashboard();
   				alert("Successfully Done!!");	
   				//drawDashboard();
   				
   			} else {
   	  			
   			}
   		}else{
   			alert("Please select estimate number");
   		}
   		
   	}
       
       
       function reject(){
     		if(estimateNoGloble){
     			
     			var r = confirm("You are going to approve estimate number :" + estimateNoGloble);
     			if (r == true) {
     				$.ajax({
     					type : 'GET',
     					url : "/MMS/rejectEstimate?estimateNo="+ estimateNoGloble +"&deptId="+costCenterNoGloble,
     					data : {},
     					contentType : "application/json; charset=utf-8",
     					success : function(data) {
     						//drawDashboard();
     						
     					}
     				});
     				//
     				drawDashboardRefreash();
     				alert("Successfully Done!!");	
     				//drawDashboard();
     				
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
						<div class="col-lg-12">
							<div class="col-lg-9">
								<ol class="breadcrumb">
									<li><a href="#">Home</a></li>
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
<div class="title">
<h2>- Meter Testing Report -</h2>
   
    </div>
   
<button type="button" class="collapsible">Meter Master Data</button>
 <div class="content">
  <form:form method="post" action="MeterTRS"	modelAttribute="model">
												      <div class="user-details">
        <div class="input-box">
            <span class="details">Order Card Number:</span>
            <form:select id="ordercard" path="meter.approvalId" onchange="this.form.submit()">
           <form:option value="NONE">Please select....</form:option>
			<form:options items="${model.orderList}" />
															</form:select>   
           </div>
           </div>
      </form:form>
      
	<form:form method="post" enctype="multipart/form-data" action="MeterTRSave"	modelAttribute="model">
						 <div class="user-details">
						  <div class="input-box">
            <span class="details">Order Card Number:</span>
              <form:input type="text" path="meter.approvalId" id ="ordercard" placeholder="Auto Get data from relevant order card?"/>
            </div>
         
          <div class="input-box">
            <span class="details">Area:</span>
            <form:select id="area" path="meter.areaCode"
																onchange="getCSC();getSinNumber();" >
																<form:option value="NONE">Please select....</form:option>
																	
																<form:options items="${model.areaList}" />
															</form:select></div>
          <div class="input-box">
            <span class="details">CSC</span>
           <form:select id="csc" path="meter.csc"
																onchange="" >
																<form:options items="${model.cscList}" />
															</form:select></div>
															 
              <div class="input-box">
         
             <span class="details">Account No</span>          
            <form:input path="meter.totower" id ="accountnumber" /></div>
         <div class="input-box2">
            <span class="details">T/F Size:</span>          
            <select class ="drop-down">
                <option value="Bulk">Bulk</option>
                <option value="BUlk+Dist">BUlk+Dist</option>
                <option value="v">Distribution</option>
                <option value="BBB" >
                <input type="number" placeholder="kVA" required></option> 
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Demand: </span>          
            <form:input path="meter.filename5" id ="demand" /></div>
          <div class="input-box">
            <span class="details">SIN No </span>
           <form:select id="sinnumber" path="meter.filename4" onchange="getSinLocation()" >
		   <form:option value="NONE">Please select....</form:option>
			<form:options items="${model.sinList}" />
			</form:select> </div>
            <div class="input-box">
            <span class="details">Consumer Name </span>
             <form:input path="meter.fromto" id ="locationsin" /></div>
         
            <div class="input-box">
            <span class="details">Consumer Address</span>
          <form:input path="meter.fromto" id ="locationsin" /></div>
            
            <div class="input-box">
            <span class="details">Tariff</span>
            <form:input path="meter.filename2" id ="tariff" /></div>
            <div class="input-box">
            <span class="details">Telephone No</span>
            <form:input path="meter.filename3" id ="contact" /></div>
            <div class="input-box">
            <span class="details">Capacitor Bank Availablity:</span>
            <select class ="drop-down">
                <option value="AAA">Yes</option>
                <option value="BBB"> No</option>
                 
            </select> 
            </div>
            <div class="input-box">
            <span class="details">Backup Generator Availablity:</span>
            <select class ="drop-down">
                <option value="AAA">Yes</option>
                <option value="BBB"> No</option>
                 
            </select> 
            </div>
            <div class="input-box2">
            <span class="details">Capacity</span>
            <input type="text" placeholder="kVA" required>
            <input type="text" placeholder="kW" required>
            </div>
            <div class="input-box">
            <span class="details">Testing Unit</span>
            <select class ="drop-down">
                <option value="EM">Eenrgy Management</option>
                <option value="EP">Energy Purchase</option>
                 <option value="ML">Meter Lab</option>
                <option value="AR">Area</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Connection Type</span>
            <select class ="drop-down">
            <option value="AAA">Please select</option>
                
                <option value="MHP">MHP</option>
                <option value="HST">HS</option>
                 <option value="LTB">LT Bulk</option>
                <option value="30A">3 ph 30A</option>
                <option value="60A">3 ph 60A</option>
                <option value="BBB">1 ph</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Test Type </span>
            <select class ="drop-down">
                 <option value="AAA">New meter Installation- Solar Net Plus</option>
                 <option value="AAA">Harmonic Test - Bulk</option>
                <option value="AAA">Routine</option>
                <option value="BBB">New connection</option>
                 <option value="BBB">Capacity Augment</option>
                <option value="BBB">Meter change</option>
                <option value="BBB">AEE Request</option>
                <option value="BBB">Audit</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Report Number</span>
            <input type="text" placeholder="Auto generated though system:" required>
          </div>
            <div class="input-box">
            <span class="details">D & T of Last MD</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
          
            
            
        </div>
          
        </form:form>
</div>
    
 
    
    
  <%--   <button type="button" class="collapsible">Data related to meter - testing</button>
<div class="content">
  <form action="#">
          <div class="user-details" >   
          <div class="input-box">
            <span class="details">Testing Unit</span>
            <select class ="drop-down">
                <option value="EM">Eenrgy Management</option>
                <option value="EP">Energy Purchase</option>
                 <option value="ML">Meter Lab</option>
                <option value="AR">Area</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Connection Type</span>
            <select class ="drop-down">
                <option value="MHP">MHP</option>
                <option value="HST">HS</option>
                 <option value="LTB">LT Bulk</option>
                <option value="30A">3 ph 30A</option>
                <option value="60A">3 ph 60A</option>
                <option value="BBB">1 ph</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Test Type </span>
            <select class ="drop-down">
                 <option value="AAA">New meter Installation- Solar Net Plus</option>
                 <option value="AAA">Harmonic Test - Bulk</option>
                <option value="AAA">Routine</option>
                <option value="BBB">New connection</option>
                 <option value="BBB">Capacity Augment</option>
                <option value="BBB">Meter change</option>
                <option value="BBB">AEE Request</option>
                <option value="BBB">Audit</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Report Number</span>
            <input type="text" placeholder="Auto generated though system:" required>
          </div>
            <div class="input-box">
            <span class="details">D & T of Last MD</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
              
        </div>
          
        </form>
</div>
    
 --%>
    
    
    
<button type="button" class="collapsible">Meter Information - Existing</button>
<div class="content">
  <form action="#">
          <div class="user-details" >   
          <div class="input-box">
            <span class="details">Meter Type</span>
            <select class ="drop-down">
                <option value="AAA">PPM</option>
                <option value="BBB">Elect</option>
                 <option value="BBB">Mech</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Scaling Factor</span>
            <input type="text" placeholder="____________________"  required>
          </div>
           <div class="input-box">
            <span class="details">Make</span>
            <select class ="drop-down">
                <option value="AAA">Iskra</option>
                <option value="BBB">Edmi</option>
                 <option value="BBB">Secure</option>
                <option value="BBB">Hexin</option>
                 <option value="BBB">Holly</option>
                 <option value="BBB">Bluester</option>
                 <option value="BBB">Other</option>
            </select> 
          </div>
          <div class="input-box2">
            <span class="details">Multification Factor</span>
            <div><input type="text" placeholder="Calculated"  required>
              <input type="text" placeholder="As per bill"  required></div> 
          </div>
          <div class="input-box">
            <span class="details">CEB Serial No</span>
             <input type="number" placeholder="Enter serial No"  required>
          </div>
          <div class="input-box">
            <span class="details">Manufacture Serial No</span>
            <input type="number" placeholder="Enter  Manufacture Serial number" required>
          </div>
          <div class="input-box">
            <span class="details">Meter Constant Reactive</span>
            <input type="number" placeholder="Enter number" required>
          </div>
           <div class="input-box">
            <span class="details">Scaling Factor</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Multification Factor</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box2">
            <span class="details">Accuracy Class</span>
           <div><input type="text" placeholder="Active"  required>
              <input type="text" placeholder="Reactive"  required></div>
          </div>
          <div class="input-box">
            <span class="details">Meter VT Ratio</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Year of Manufacture</span>
            <input type="year" placeholder="Enter manufacture year" required>
          </div>
             <div class="input-box">
            <span class="details">Meter Constant:Active</span>
            <input type="year" placeholder="Active" required>
          </div>
            <div class="input-box">
            <span class="details">Meter Constant:Reactive</span>
            <input type="year" placeholder="Reactive" required>
          </div>
         
              
        </div>
          
        </form>
</div>
    
    
<button type="button" class="collapsible">Meter Information - New</button>
<div class="content">
  <form action="#">
      
      <div class="button2">
          <input type="submit" value="Load Existing Meter Detail">
        </div>
      
          <div class="user-details" >   
          <div class="input-box">
            <span class="details">Meter Type</span>
            <select class ="drop-down">
                <option value="AAA">PPM</option>
                <option value="BBB">Elect</option>
                 <option value="BBB">Mech</option>
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Scaling Factor</span>
            <input type="text" placeholder="____________________"  required>
          </div>
          <div class="input-box">
            <span class="details">Make</span>
            <select class ="drop-down">
                <option value="AAA">Iskra</option>
                <option value="BBB">Edmi</option>
                 <option value="BBB">Secure</option>
                <option value="BBB">Hexin</option>
                 <option value="BBB">Holly</option>
                 <option value="BBB">Bluester</option>
                 <option value="BBB">Other</option>
            </select> 
          </div>
          <div class="input-box2">
            <span class="details">Multification Factor</span>
            <div><input type="text" placeholder="Calculated"  required>
              <input type="text" placeholder="As per bill"  required></div> 
          </div>
          <div class="input-box">
            <span class="details">CEB Serial No</span>
             <input type="number" placeholder="Enter serial No"  required>
          </div>
          <div class="input-box">
            <span class="details">Manufacture Serial No</span>
            <input type="number" placeholder="Enter  Manufacture Serial number" required>
          </div>
          <div class="input-box">
            <span class="details">Meter CT Ratio</span>
            <select class ="drop-down">
                <option value="AAA"></option>
                
            </select> 
          </div>
           <div class="input-box">
            <span class="details">Scaling Factor</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Multification Factor</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box2">
            <span class="details">Accuracy Class</span>
           <div><input type="text" placeholder="Active"  required>
              <input type="text" placeholder="Reactive"  required></div>
          </div>
          <div class="input-box">
            <span class="details">Meter VT Ratio</span>
            <input type="number" placeholder="Enter number" required>
          </div>
          <div class="input-box">
            <span class="details">Year of Manufacture</span>
            <input type="year" placeholder="Enter manufacture year" required>
          </div>
             <div class="input-box">
            <span class="details">Meter Constant:Active</span>
            <input type="year" placeholder="Active" required>
          </div>
            <div class="input-box">
            <span class="details">Meter Constant:Reactive</span>
            <input type="year" placeholder="Reactive" required>
          </div>
         
              
        </div>
          
        </form>
</div>

    
    


<button type="button" class="collapsible">Meter Readings Import Existing:</button>
<div class="content">
    <div class ="ct">
   <form action="#">
    <div class="user-details">
          <div class="input-box2">
            <span class="details">Act.Total(kWh/Mwh)</span>         
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">MD in kVA/MVA</span>
            <input type="year" placeholder="_____________________" required>
          </div>
         
        <div class="input-box2">
            <span class="details">Act.Rate 1(kWh/Mwh)</span>           
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
   
        <div class="input-box">
            <span class="details">History 1 kVA</span>
            <input type="year" placeholder="_____________________" required>
          </div>
       
       
          <div class="input-box2">
            <span class="details">Act.Rate 2(kWh/Mwh)</span>         
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">D & T of Last MD</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
       <div class="input-box2">
            <span class="details">Act.Rate 3(kWh/Mwh)</span>        
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">Last Billing Reset</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
        <div class="input-box2">
             <span class="details">Re.Total(kVarh/MVarh)</span>         
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
               
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Time</span>
            <label>Actual</label>
            <input type="text" placeholder="Actual" required>
            <label>Meter</label>
            <input type="text" placeholder="Meter" required>
            </div>
       
       <div class="input-box2">
            <span class="details">Re.Rate 1(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Date</span>
            <label>Actual</label>
            <input type="text" placeholder="Actual" required>
            <label>Meter</label>
            <input type="text" placeholder="Meter" required>
            </div>
         <div class="input-box2">
            <span class="details">Re.Rate 2(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Re.Rate 3(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
       
       
        </div>
          
        </form>
    </div>
</div>

    <button type="button" class="collapsible">Meter Readings Export Existing:</button>
<div class="content">
    <div class ="ct">
   <form action="#">
    <div class="user-details">
          <div class="input-box2">
            <span class="details">Act.Total(kWh/Mwh)</span>         
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">MD in kVA/MVA</span>
            <input type="year" placeholder="_____________________" required>
          </div>
         
        <div class="input-box2">
            <span class="details">Act.Rate 1(kWh/Mwh)</span>           
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
   
        <div class="input-box">
            <span class="details">History 1 kVA</span>
            <input type="year" placeholder="_____________________" required>
          </div>
       
       
          <div class="input-box2">
            <span class="details">Act.Rate 2(kWh/Mwh)</span>         
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">D & T of Last MD</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
       <div class="input-box2">
            <span class="details">Act.Rate 3(kWh/Mwh)</span>        
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">Last Billing Reset</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
        <div class="input-box2">
             <span class="details">Re.Total(kVarh/MVarh)</span>         
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
               
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Time</span>
            <label>Actual</label>
            <input type="text" placeholder="Actual" required>
            <label>Meter</label>
            <input type="text" placeholder="Meter" required>
            </div>
       
       <div class="input-box2">
            <span class="details">Re.Rate 1(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Date</span>
            <label>Actual</label>
            <input type="text" placeholder="Actual" required>
            <label>Meter</label>
            <input type="text" placeholder="Meter" required>
            </div>
         <div class="input-box2">
            <span class="details">Re.Rate 2(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Re.Rate 3(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
       
       
        </div>
          
        </form>
    </div>
</div>
    
 <button type="button" class="collapsible">Meter Readings Import New:</button>
<div class="content">
    <div class ="ct">
   <form action="#">
    <div class="user-details">
          <div class="input-box2">
            <span class="details">Act.Total(kWh/Mwh)</span>          
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option> 
            </select> 
          </div>
        <div class="input-box">
            <span class="details">MD in kVA/MVA</span>
            <input type="year" placeholder="_____________________" required>
          </div>
          
        <div class="input-box2">
            <span class="details">Act.Rate 1(kWh/Mwh)</span>            
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option> 
            </select> 
          </div>
    
        <div class="input-box">
            <span class="details">History 1 kVA</span>
            <input type="year" placeholder="_____________________" required>
          </div>
        
        
          <div class="input-box2">
            <span class="details">Act.Rate 2(kWh/Mwh)</span>          
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option> 
            </select> 
          </div>
        <div class="input-box">
            <span class="details">D & T of Last MD</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
       <div class="input-box2">
            <span class="details">Act.Rate 3(kWh/Mwh)</span>         
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option> 
            </select> 
          </div>
        <div class="input-box">
            <span class="details">Last Billing Reset</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
        <div class="input-box2">
             <span class="details">Re.Total(kVarh/MVarh)</span>          
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
                
            </select> 
          </div>
        <div class="input-box2">
            <span class="details">Time</span>
            <label>Actual</label>
            <input type="text" placeholder="Actual" required>
            <label>Meter</label>
            <input type="text" placeholder="Meter" required>
            </div>
        
       <div class="input-box2">
            <span class="details">Re.Rate 1(kVarh/MVarh)</span>         
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option> 
            </select> 
          </div>
        <div class="input-box2">
            <span class="details">Date</span>
            <label>Actual</label>
            <input type="text" placeholder="Actual" required>
            <label>Meter</label>
            <input type="text" placeholder="Meter" required>
            </div>
         <div class="input-box2">
            <span class="details">Re.Rate 2(kVarh/MVarh)</span>         
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option> 
            </select> 
          </div>
        <div class="input-box2">
            <span class="details">Re.Rate 3(kVarh/MVarh)</span>         
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option> 
            </select> 
          </div>
        
        
        </div>
          
        </form>
    </div>
</div>
<button type="button" class="collapsible">Meter Readings Export New:</button>
<div class="content">
    <div class ="ct">
   <form action="#">
    <div class="user-details">
          <div class="input-box2">
            <span class="details">Act.Total(kWh/Mwh)</span>         
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">MD in kVA/MVA</span>
            <input type="year" placeholder="_____________________" required>
          </div>
         
        <div class="input-box2">
            <span class="details">Act.Rate 1(kWh/Mwh)</span>           
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
   
        <div class="input-box">
            <span class="details">History 1 kVA</span>
            <input type="year" placeholder="_____________________" required>
          </div>
       
       
          <div class="input-box2">
            <span class="details">Act.Rate 2(kWh/Mwh)</span>         
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">D & T of Last MD</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
       <div class="input-box2">
            <span class="details">Act.Rate 3(kWh/Mwh)</span>        
            <select class ="drop-down">
                <option value="AAA">kWh</option>
                <option value="BBB"> MWh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box">
            <span class="details">Last Billing Reset</span>
            <input type="datetime-local" id="modify-time" name="modify-time" value="2021-07-05T14:30" min="2018-06-07T00:00" max="2025-06-14T00:00">
          </div>
        <div class="input-box2">
             <span class="details">Re.Total(kVarh/MVarh)</span>         
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
               
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Time</span>
            <label>Actual</label>
            <input type="text" placeholder="Actual" required>
            <label>Meter</label>
            <input type="text" placeholder="Meter" required>
            </div>
       
       <div class="input-box2">
            <span class="details">Re.Rate 1(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Date</span>
            <label>Actual</label>
            <input type="text" placeholder="Actual" required>
            <label>Meter</label>
            <input type="text" placeholder="Meter" required>
            </div>
         <div class="input-box2">
            <span class="details">Re.Rate 2(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
        <div class="input-box2">
            <span class="details">Re.Rate 3(kVarh/MVarh)</span>        
            <select class ="drop-down">
                <option value="AAA">kVarh</option>
                <option value="BBB"> MVarh</option>
                <option value="BBB" ><input type="number" placeholder="" required></option>
            </select>
          </div>
       
       
        </div>
          
        </form>
    </div>
</div>   
    
    


    

<button type="button" class="collapsible">Meter Wiring & Testing(Before Correction):</button>
<div class="content">
  <form action="#">
        <div class="user-details">
          
          <div class="input-box">
            <span class="details">Phase Sequance</span>
            <select class ="drop-down">
                <option value="volvo">For</option>
                <option value="saab">Rev</option>
                 <option value="opel">Inv</option>
                    
            </select>
          </div>
          <div class="input-box">
            <span class="details">Phase Association</span>
            <select class ="drop-down">
                <option value="volvo">Ok</option>
                <option value="saab">Wrong</option>
                 
            </select>
          </div>
            
            
            
            
            
            
          <div class="input-box2">
            <span class="details">Color Code</span>         
            <select class ="drop-down">
                <option value="AAA">Ok </option>
                <option value="BBB"> Not Ok</option>
                <option value="BBB" ><input type="text" placeholder="(____/____/____)" required></option> 
            </select> 
          </div>
            
            
            
          <div class="input-box">
            <span class="details">Wire Size & Type</span>
            <select class ="drop-down">
                <option value="volvo">Ok</option>
                <option value="saab">Not Ok</option>
                 
            </select>
          </div>
          <div class="input-box">
            <span class="details">Terminal Lugs available </span>
            <select class ="drop-down">
                <option value="volvo">Yes</option>
                <option value="saab">No</option>
                 
            </select>
          </div> 
          <div class="input-box">
            <span class="details">Properly & Neatly done</span>
            <select class ="drop-down">
                <option value="volvo">Yes</option>
                <option value="saab">No</option>
                 
            </select>
          </div>
        </div>  
          
        </form>
</div>
    

<button type="button" class="collapsible">Meter Testing (Before Correction):</button>
<div class="content">
  <form action="#">
<div class="user-details">   
<div name="Meter Testing (After Correction) ">     
<table class = "table2" name = "main">
  <tr>
    <th rowspan="2">Ph</th>
    <th colspan="2">Voltage</th>
    <th colspan="2">Current</th>
    <th rowspan="2">Power Factor</th>
    
  </tr>
  <tr>
    <th >PPM</th>
    <th>TI</th>
    <th>PPM</th>
    <th>TI</th>
    
    
  </tr>
  <tr>
     <th >L 1</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
    
    
    
  </tr>
  <tr>
     <th >L 2</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
    
  </tr>
     <tr>
     <th >L 3</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
    
  </tr>
    
  <div class="content">
  <form action="#">
<div class="user-details">   
<div name="Meter Testing (After Correction) ">     

    </div>
    
    <div name ="Meter Testing (After Correction)2 ">
        <br><br>
    <table class = "table2" name = "main">
  <tr>
    <th rowspan="2"></th>
    <th colspan="3">Active (kWh)</th>
    <th colspan="3">Reactive (kVArh)</th>
    <th colspan="3">Overall Test</th>
    
  </tr>
  <tr>
    <th >1</th>
    <th>2</th>
    <th>3</th>
      <th>1</th>
     <th>2</th>
    <th>3</th>
     <th>1</th>
    <th>2</th>
     <th>3</th>
   
    
  </tr>
  <tr>
     <th >No.of Pulse</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
   <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    
  </tr>
  <tr>
     <th >Avg. % error</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
   <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    
    
  </tr>
</table>
        </div>
      
<div class="register-(dail)-test">
<br> 
<table class = "table2" name ="register(dail)test">
  
  <tr>
     <th colspan="2">Register (Dail) Test</th>
   
    
     
   
    
  </tr>
  <tr>
     <th >Final Reading (Y) </th>
    <td><input type="text" placeholder="" required></td>
    
     
    
    
  </tr>
    <tr>
     <th >Initial Reading (X) </th>
    <td><input type="text" placeholder="" required></td>
    
    
    
  </tr>
     <tr>
     <th>Y - Xl</th>
    <td><input type="text" placeholder="" required></td>
    
    
    
  </tr>
     
     <tr>
     <th>Test .... %error</th>
    <td><input type="text" placeholder="" required></td>
    
    
    
  </tr>
  <br><br>  
</table>
        </div>
<div name="load-Condition">
    
<div name="load-Condition">
    <br><br><br>
    <table class = "table2" name ="Load-Condition">
    
  <tr>
     <th colspan="2">Load Condition</th>
    <td><input type="text" placeholder="Active :" required></td>
    <th><input type="text" placeholder="Reactive :" required></th>
     <th><input type="text" placeholder="Dial Test :" required></th>
     
 
  </tr>    
</table>
    
    </div>      
        
    </div>
   
        </div>
          
        </form>
</div>
    
    

<button type="button" class="collapsible">Meter Wiring (After Correction)</button>
<div class="content">
  <form action="#">
        <div class="user-details">
          
          <div class="input-box">
            <span class="details">Phase Sequance</span>
            <select class ="drop-down">
                <option value="volvo">For</option>
                <option value="saab">Rev</option>
                 <option value="opel">Inv</option>
                    
            </select>
          </div>
          <div class="input-box">
            <span class="details">Phase Association</span>
            <select class ="drop-down">
                <option value="volvo">Ok</option>
                <option value="saab">Wrong</option>
                 
            </select>
          </div>
            
            
            
            
            
            
          <div class="input-box2">
            <span class="details">Color Code</span>
            <select class ="drop-down">
                <option value="AAA">Ok </option>
                <option value="BBB"> Not Ok</option>
                <option value="BBB" ><input type="text" placeholder="(____/____/____)" required></option> 
            </select> 
          </div>
            
            
            
          <div class="input-box">
            <span class="details">Wire Size & Type</span>
            <select class ="drop-down">
                <option value="volvo">Ok</option>
                <option value="saab">Not Ok</option>
                 
            </select>
          </div>
          <div class="input-box">
            <span class="details">Terminal Lugs available </span>
            <select class ="drop-down">
                <option value="volvo">Yes</option>
                <option value="saab">No</option>
                 
            </select>
          </div> 
          <div class="input-box">
            <span class="details">Properly & Neatly done</span>
            <select class ="drop-down">
                <option value="volvo">Yes</option>
                <option value="saab">No</option>
                 
            </select>
          </div>
        </div>
          
          
        </form>
</div>
    
    
<button type="button" class="collapsible">Meter Testing (After Correction)</button>
<div class="content">
  <form action="#">
<div class="user-details">   
<div name="Meter Testing (After Correction) ">     
<table class = "table2" name = "main">
  <tr>
    <th rowspan="2">Ph</th>
    <th colspan="2">Voltage (V)</th>
    <th colspan="3">Current (l)</th>
    <th colspan="2">Power Factor</th>
    
  </tr>
  <tr>
    <th >PPM</th>
    <th>TI</th>
      
    <th>PPM</th>
    <th>TI</th>
    <th>Primary</th>
    <div class="row">
    <td><input type="text" placeholder="" required></td>
        </div>
  </tr>
  <tr>
     <th >L 1</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
    
     
    
  </tr>
  <tr>
     <th >L 2</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
    
   
    
    
  </tr>
 <tr>
     <th >L 3</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
  
  </tr>
    
    
  
</table>
    </div>
    
    <div name ="Meter Testing (After Correction)2 ">
        <br><br>
    <table class = "table2" name = "main">
  <tr>
    <th rowspan="2"></th>
    <th colspan="3">Active (kWh)</th>
    <th colspan="3">Reactive (kVArh)</th>
    <th colspan="3">Overall Test</th>
    
  </tr>
  <tr>
    <th >1</th>
    <th>2</th>
    <th>3</th>
      <th>1</th>
     <th>2</th>
    <th>3</th>
     <th>1</th>
    <th>2</th>
     <th>3</th>
   
    
  </tr>
  <tr>
     <th >No.of Pulse</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
   <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    
  </tr>
  <tr>
     <th >Avg. % error</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
   <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    
    
  </tr>
</table>
        </div>
    
    
    
    
    
    
    
    
    
    
    
        
       
<div class="register-(dail)-test">
<br> 
<table class = "table2" name ="register(dail)test">
  
  <tr>
     <th colspan="2">Register (Dail) Test</th>
   
    
     
   
    
  </tr>
  <tr>
     <th >Final Reading (Y) </th>
    <td><input type="text" placeholder="" required></td>
    
     
    
    
  </tr>
    <tr>
     <th >Initial Reading (X) </th>
    <td><input type="text" placeholder="" required></td>
    
    
    
  </tr>
     <tr>
     <th>Y - Xl</th>
    <td><input type="text" placeholder="" required></td>
    
    
    
  </tr>
     
     <tr>
     <th>Test .... %error</th>
    <td><input type="text" placeholder="" required></td>
    
    
    
  </tr>
  

  <br><br>  
</table>
        </div>
<div name="load-Condition">
    <br><br><br>
    <table class = "table2" name ="Load-Condition">
 

  
  <tr>
     <th colspan="2">Load Condition</th>
    <td><input type="text" placeholder="Active :" required></td>
    <th><input type="text" placeholder="Reactive :" required></th>
     <th><input type="text" placeholder="Dial Test :" required></th>
     
 
  </tr>    
</table>
    
    </div>
   
        </div>
         
        </form>
</div>

    
    
    
    
    

<button type="button" class="collapsible">CT Serial and Sealing data</button>
    <div class="content">
<form action="#">
        <div class="user-details">
            
       
            
            
<table class = "table">
  <tr>
    <th colspan="2"></th>
    <th colspan="2">Old</th>
    <th colspan="2">New</th>
    
  </tr>
  <tr>
    <th colspan="2"  rowspan="2">Meter Seal</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    
    
  </tr>
  <tr>
     <td ><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     
   
    
  </tr>
  <tr>
     <th colspan="2">Terminal Cover</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
      <td><input type="text" placeholder="" required></td>
    
    
  </tr>
    <tr>
     <th colspan="2">MD Button</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
      <td><input type="text" placeholder="" required></td>
    
    
  </tr>
     <tr>
     <th colspan="2">Enclosure/Small Window</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
      <td><input type="text" placeholder="" required></td>
    
    
  </tr>
  <tr>
     <th rowspan="3">CT Serial</th>
    <th>R</th>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
      <td><input type="text" placeholder="" required></td> 
      
    
  </tr>
  <tr>
     <th>Y</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
      <td><input type="text" placeholder="" required></td>
    
  </tr>
    <tr>
     <th>B</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
       <td><input type="text" placeholder="" required></td>
   
    
  </tr>
      <tr>
     <th colspan="2">Cubicle</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
    
  </tr>
</table>
            
        </div>
          
        </form>
</div>
    

<button type="button" class="collapsible">Test Instrument Details:</button>
<div class="content">
  <form action="#">
          <div class="user-details" >   
          <div class="input-box">
            <span class="details">Make:</span>
            <input type="text" placeholder="____________________"  required> 
          </div>
          <div class="input-box">
            <span class="details">Serial No:</span>
            <input type="number" placeholder="Enter Serial No"  required>
          </div>
          <div class="input-box">
            <span class="details">Accuracy CL:</span>
            <input type="text" placeholder="Enter number"  required>
          </div>
          <div class="input-box">
            <span class="details">Last Calibration Date:</span>
            <div><input type="date" placeholder="Calculated"  required>
              </div> 
          </div>
         
         
              
        </div>
          
        </form>
</div>

    



<button type="button" class="collapsible">CT Ratio Test</button>
<div class="content">
<form action="#">
    <div class="user-details">  
        <span class="details">CT Ratio</span>
       <input type="text" placeholder="" required> 

        <span class="details">CT Accuracy Class</span>
       <input type="text" placeholder="" required>
        <br>
<table class = "table2">
  <tr>
    <th></th>
    <th colspan="3">CT of Phase A</th>
    <th colspan="3">CT of Phase B</th>
    <th colspan="3">CT of Phase C</th>
    
  </tr>
  <tr>
    <th >Phase</th>
    <th>1</th>
    <th>2</th>
    <th>3</th>
    <th>1</th>
    <th>2</th>
    <th>3</th>
    <th>1</th>
    <th>2</th>
    <th>3</th>
    
  </tr>
  <tr>
     <th >Primary Current/A</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
   <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    
  </tr>
  <tr>
     <th >Secondary Current/A</th>
    <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td>
   <td><input type="text" placeholder="" required></td>
    <td><input type="text" placeholder="" required></td>
     <td><input type="text" placeholder="" required></td> 
  </tr>
     <tr>
   <th>P1,S2 Direction</th>
   <td colspan="3">          
            <select class ="drop-down">
                <option value="Ok">Ok</option>
                <option value="Wrong"> Wrong</option>
            </select></td>
    <td colspan="3"><select class ="drop-down">
                <option value="Ok">Ok</option>
                <option value="Wrong"> Wrong</option>
            </select></td>
   <td colspan="3"><select class ="drop-down">
                <option value="Ok">Ok</option>
                <option value="Wrong"> Wrong</option>
            </select></td> 
  </tr>
  <tr>
     <th>S1,S2 Direction</th>
    <td colspan="3"><select class ="drop-down">
                <option value="Ok">Ok</option>
                <option value="Wrong"> Wrong</option>
            </select></td>
    <td colspan="3"><select class ="drop-down">
                <option value="Ok">Ok</option>
                <option value="Wrong"> Wrong</option>
            </select></td>
   <td colspan="3"><select class ="drop-down">
                <option value="Ok">Ok</option>
                <option value="Wrong"> Wrong</option>
            </select></td>
     
      
    
  </tr>

</table>  
        
        </div>
          
        </form>
</div>


<button type="button" class="collapsible">RMR and Enclosure data</button>
    <div class="content">
 <form action="#">
        <h3>RMR Facility</h3>  
        <div class="user-details">
          <div class="input-box">
            <span class="details">Moderm Serial No:</span>
            <input type="text" placeholder="" required>
          </div>
          <div class="input-box">
            <span class="details">Moderm LED</span>
            <select class ="drop-down">
                <option value="volvo">Blinking</option>
                <option value="saab">Continous ON</option>
                <option value="saab">OFF</option>
                 
            </select>
          </div>
          <div class="input-box">
            <span class="details">Signal Level:</span>
            <select class ="drop-down">
                <option value="AAA">Ok </option>
                <option value="BBB"> Poer</option>
                <option value="BBB" >No CC3</option> 
            </select> 
          </div>
          <div class="input-box">
            <span class="details">Phone No</span>
             <input type="number" placeholder="" required>
          </div>
          <div class="input-box">
            <span class="details">Sim No </span>
            <input type="number" placeholder="" required>
          </div> 
          <div class="input-box">
            <span class="details">Condition:Antena</span>
            <select class ="drop-down">
                <option value="volvo">Ok</option>
                <option value="saab">Not Ok</option>
              </select>
          </div>
          <div class="input-box">
            <span class="details">Condition:Data Cable</span>
            <select class ="drop-down">
                <option value="volvo">Ok</option>
                <option value="saab">Not Ok</option>
              </select>
          </div>
          </div>
            </form>
        <form action="#">
            <h3>Enclosure</h3>
         <div class="user-details">
            
         <div class="input-box">
            <span class="details">Available</span>
            <select class ="drop-down">
                <option value="volvo">Yes</option>
                <option value="saab">No</option>
              </select>
          </div>
            <div class="input-box">
            <span class="details">Properly Fixed</span>
            <select class ="drop-down">
                <option value="volvo">Yes</option>
                <option value="saab">No</option>
              </select>
          </div> 
            <div class="input-box">
            <span class="details">Condition</span>
            <select class ="drop-down">
                <option value="volvo">Good</option>
                <option value="saab">Moderater</option>
                <option value="saab">Not Good</option>
                
              </select>
          </div> 
            <div class="input-box">
            <span class="details">CT Location</span>
            <select class ="drop-down">
                <option value="volvo">CT Outside</option>
                <option value="saab">Inside</option>
              </select>
          </div>
             <div class="input-box">
            <span class="details">Earthing</span>
            <select class ="drop-down">
                <option value="volvo">Yes</option>
                <option value="saab">No</option>
              </select>
          </div>
            </div>
            
            
        </form>
</div>


<button type="button" class="collapsible">Availability Service Providers</button>
<div class="content">
   <form action="#">
    <div class="user-details">
        
   
        
<table class = "table">
  
  <tr>
     <th >Dailog</th>
    <td><select class ="drop-down">
                <option value="volvo">No Coverage</option>
                <option value="saab">Low</option>
                <option value="saab">Moderate</option>
                <option value="saab">High</option>
              </select></td>
    
     
   
    
  </tr>
   <tr>
     <th >Mobitel</th>
    <td><select class ="drop-down">
                <option value="volvo">No Coverage</option>
                <option value="saab">Low</option>
                <option value="saab">Moderate</option>
                <option value="saab">High</option>
              </select></td>
    
     
   
    
  </tr>
     <tr>
     <th >Etisala</th>
    <td><select class ="drop-down">
                <option value="volvo">No Coverage</option>
                <option value="saab">Low</option>
                <option value="saab">Moderate</option>
                <option value="saab">High</option>
              </select></td>
    
     
   
    
  </tr>
      <tr>
     <th >Airtel</th>
    <td><select class ="drop-down">
                <option value="volvo">No Coverage</option>
                <option value="saab">Low</option>
                <option value="saab">Moderate</option>
                <option value="saab">High</option>
              </select></td>
    
     
   
    
  </tr>
     
      <tr>
     <th >Hutch</th>
    <td><select class ="drop-down">
                <option value="volvo">No Coverage</option>
                <option value="saab">Low</option>
                <option value="saab">Moderate</option>
                <option value="saab">High</option>
              </select></td>
    
     
   
    
  </tr>


    
</table>
        
        
        
        
        
        
        
        </div>
          
        </form>
         <form action="#">
            <h3>Main Wiring</h3>
         <div class="user-details">
            
         <div class="input-box">
            <span class="details">MCCB</span>
            <input type="text" placeholder="" required>
          </div>
            <div class="input-box">
            <span class="details">Cable Size</span>
            <input type="text" placeholder="" required>
          </div> 
            <div class="input-box">
            <span class="details">Condition</span>
            <select class ="drop-down">
                <option value="volvo">Good</option>
                <option value="saab">Moderater</option>
                <option value="saab">Not Good</option>
                
              </select>
          </div> 
        </div>    
        </form>
</div>
    
    


    


    



    

<button type="button" class="collapsible">Cubicle:</button>
<div class="content">
  <form action="#">
        <div class="user-details">
          
          <div class="input-box">
            <span class="details">Door availability</span>
            <select class ="drop-down">
                <option value="AAA">Yes </option>
                <option value="BBB"> No</option>
                 
            </select> 
          </div>
            
            
            
          <div class="input-box">
            <span class="details">Cleanliness</span>
            <select class ="drop-down">
                <option value="volvo">Good</option>
                <option value="saab">Moderate </option>
                <option value="volvo">Not Good</option>
                 
            </select>
          </div>
          <div class="input-box">
            <span class="details">Door Condition </span>
            <select class ="drop-down">
                <option value="volvo">Good</option>
                <option value="saab">Moderate </option>
                <option value="volvo">Not Good</option>
                 
            </select>
          </div> 
          <div class="input-box">
            <span class="details">Access to Cubicle</span>
            <select class ="drop-down">
                <option value="volvo">Ok</option>
                <option value="saab">Not Ok</option>
                 
            </select>
          </div>
            
        </div>
          
          
          
        </form>
        
</div>
    
<button type="button" class="collapsible">Test Report Conclusion - Es</button>
<div class="content">
  <form action="#">
        <div class="user-details">
          
          <div class="input-box">
            <span class="details">Action Taken(Changes Done)</span>
              <textarea id="w3review" name="w3review" rows="4" cols="50"></textarea>
          </div>
         <div class="input-box">
            <span class="details">Present Condition</span>
              <textarea id="w3review" name="w3review" rows="4" cols="50"></textarea>
          </div>
          <div class="input-box">
            <span class="details">Remarks</span>
            <textarea id="w3review" name="w3review" rows="4" cols="50"></textarea>
          </div>
          <div class="input-box">
            <span class="details">Tested By</span>
            <textarea id="w3review" name="w3review" rows="4" cols="50"></textarea> 
          </div>
          <div class="input-box">
            <span class="details">Test Date</span>
            <input type="text" placeholder="" required>
          </div>
        </div>
          
          
          
        </form>
        
</div> 
    
<button type="button" class="collapsible"> EE recommendation </button>
<div class="content">
  <form action="#">
        <div class="user-details">
          
         <div class="input-box">
            <span class="details">Note</span>
              <textarea id="w3review" name="w3review" rows="4" cols="50"></textarea>
          </div>
        <div>
           <div class="user-details">
              <div class="input-box">
            <span class="details">Date</span>
              <input type="date" placeholder="" required>
          </div>
               <div class="input-box">
            <span class="details">Signature</span>
              <input type="text" placeholder="---------------------" required>
          </div>
              
              </div>
          </div>
        </div>
        </form>
    
        
</div> 

    
    
   
          <input type="submit" class="button3" value="Submit">

</div>
					</div>






				</div>
			</div>
		</div>
	</div>
	<%@ include file="sections/footer.jsp"%>
	<%@ include file="sections/global_scripts.jsp"%>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
      <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
      
      
      <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
      <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
	
      <script>
           $('#myTable').DataTable();
      </script>
		<script>
var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}
</script>

	
	
	
</body>
</html>