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
    
   
    
    
    
/* .collapsible {
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
 */
/* .content {
  padding: 0 18px;
  display: none;
  overflow: hidden;
  background-color: #f1f1f1;
}  
 */ 
 
/*  .content {
  padding: 0 18px;
  display: none;
  background-color: #f1f1f1;
}     
 */   .title{
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
<h2>- Maintenance Plan -</h2>
   
    </div>
					
					
  <form:form role="form" enctype="multipart/form-data" action="addPlanS" method="post" modelAttribute="SaveGeneral">
									 
  <br>
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
            <span class="details">Province:</span>
            <form:select path="objMntPlan.province" onchange="findArea()" class="form-control" id="cmbSelectProvince" name="cmbSelectProvince">
																   <form:option value="province">PROVINCE</form:option>
																   <form:options items="${SaveGeneral.provinceList}" /> 
																</form:select>
																</div>
          <div class="input-box">
            <span class="details">Area:</span>
            <form:select path="objMntPlan.area"  onchange="getCSC();getLine();" class="form-control" id="cmbSelectArea" name="cmbSelectArea">
																     <form:options items="${SaveGeneral.areaList}" />
																</form:select>
																													</div>
           <div class="input-box">
            <span class="details">Line:</span>
            <form:select  path="line.id" class="form-control" onchange="findLineDetails()" id="cmbSelectLineId" name="cmbSelectLineId">

																	<form:options items="${SaveGeneral.lineList}" />
																</form:select>																										</div>
           <div class="input-box">
            <span class="details">CSC:</span>
            <form:select path="objMntPlan.csc" class="form-control" id="cmbSelectCSC" name="cmbSelectCSC">
																
																</form:select></div>
			 <div class="input-box">
          													          
            <span class="details">Plan Year:</span>
            <form:select path="objMntPlan.year" class="form-control" id="cmbSelectYear" name="cmbSelectYear">
																<form:option value="2020">2020</form:option>
	
																 <form:option value="2021" >2021</form:option>
	<form:option value="2022" selected="selected">2022</form:option>
	
	<form:option value="2022" >2023</form:option>
	<form:option value="2024" >2024</form:option>
	<form:option value="2025" >2025</form:option>
	
	
	
																</form:select>
	</div>
	
			 <div class="input-box">
          													          
            <span class="details">Maintenance Type:</span>
            <form:select path="objMntPlan.planType" class="form-control" id="cmbSelectPlanType" name="cmbSelectPlanType">
																 <form:option value="HOT" selected="selected">Hot Line Maintenance</form:option>
	<form:option value="COLD" >Cold Line Maintenance</form:option>
	<form:option value="INSP" >Inspection</form:option>
	
																</form:select>
	</div>
	
	<div class="input-box">
          													          
            <span class="details">Responsible EE:</span>
            <form:select path="objMntPlan.eeName" class="form-control" id="cmbSelectEE" name="cmbSelectEE">
																  <form:options items="${SaveGeneral.eeList}" />
																</form:select>
																</div>
	<div class="input-box">
          													          
            <span class="details">Responsible ES:</span>
            <form:select path="objMntPlan.esName" class="form-control" id="cmbSelectES" name="cmbSelectES">
																  <form:options items="${SaveGeneral.esList}" />
																</form:select>
																													</div>
																													<div class="input-box">
          													          
            <span class="details">Length(Km):</span>
            <form:input path="objMntPlan.length" type="number" value ="0" min="0" step="0.01" class="form-control" id="txtLength" placeholder="Enter Length(Km)"/>
																																										</div>
	
	<div class="input-box">
          													          
            <span class="details">Number of Tower:</span>
            <form:input path="objMntPlan.nooftowers" type="number" value ="0" min="0" step="0.01" class="form-control" id="txtTower" placeholder="Enter Number of Tower"/>
																																																							</div>
	
			<div class="input-box">
          													          
            <span class="details">Number of Pole:</span>
            <form:input path="objMntPlan.noofpoles" type="number" value ="0" min="0" step="0.01" class="form-control" id="txtPole" placeholder="Enter Number of Poles"/>
			</div>
	<div class="input-box">
          													          
            <span class="details">Serial Number:</span>
            <form:input path="objMntPlan.serialNo" type="text" class="form-control" id="txtName" placeholder="Enter Serial Number"/>
																</div>
																<div class="input-box">
          													          
            <span class="details">From Date:</span>
            <form:input path="fromDate" type="date"  class="form-control" id="from"/>
																													</div>
	
	<div class="input-box">
          													          
            <span class="details">To Date:</span>
            <form:input path="toDate" type="date" class="form-control" id="to"/>
																													</div>
	
	<div class="input-box">
          													          
            <span class="details">Status:</span>
            <form:select
																path="objMntPlan.status" class="form-control" id="txtSampleSatisified">
																<form:option value="2" selected="selected">Active</form:option>
															<form:option value="3">In Active</form:option>
															</form:select>													</div>
														  
	
<%-- 	<div class="table-responsive" style="padding: 47px;">
                            <table class="table table-striped">
                            <thead>
																<tr>
																<th>Plan Year</th>
																	
																	<th>Province</th>
																	<th>Area</th>
																	<th>Length</th>
																	<th>No Of Poles</th>
																	<th>No Of Towers</th>
																	<th>Responsible EE</th>
																	<th>Responsible ES</th>
																	<th>Type</th>
																	<th>Form Date</th>
																	<th>To Date</th>
																	<th>Status</th>
																</tr>
															</thead>
																														 <tbody>

																<tr>
																	<td><form:label path="">line</form:label></td>

																	<td><form:checkboxes items="${model.listOfLines}"
																			path="selectedLines" /></td>
																	<td></td>
																</tr>


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
																
														<tr>
													<form:button type='button' class='btn btn-warning'
																onClick='javascript:editAll("${SaveGeneral.stringOfSupportIds}")'>Edit
																All</form:button>
<form:button type='button' class='btn btn-success'
																onClick='javascript:saveAll()'>Update All</form:button>
																
																														<!-- edited anushka 2019-01-02----------------------------------------------------------------------------------------->
																											</tr>
								
																
																
																
															</tbody>
															
															
															
															
                </table>
                </div> --%>
	
	
	
														           </div>
													<center>	           
														           <div class="user-details">
															
															<div class="input-box">
          						<input type="submit" Value="Add" class="btn btn-success" class="form-control"/>
																			          
            </div>
            </div>
           </center>
      </form:form>
      
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