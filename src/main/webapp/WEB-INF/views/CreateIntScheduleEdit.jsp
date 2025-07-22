<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- <style type="text/css">
table, th, td {
	border: 0px solid black;
	align: left;
	text-align: left;
}

thead tr th { 
	        height: 30px;
	    line-height: 30px;
	    color:gray;
	    background-color:#f1f3f7;
	}
	
	
	tbody { border-top: 0px solid black; }
	
	tbody td, thead th {
	    border-right: 0px solid black;
	}
	
	tbody td:last-child, thead th:last-child {
	    border-right: none;
	}
	
		
	/* tr:nth-child(even) {background-color: #E4DFDE;}
	 */
	
	div#map_container {
	width: 100%;
	height: 250px;
	border-radius: 5px;
}

	
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
.table-wrap {
  position: relative;
}
.table-scroll th{
padding: 5px 10px;
  border: 0px solid #000;
  background: #f1f3f7;
  vertical-align: top;
}
.table-scroll td {
  padding: 5px 10px;
  border: 0px solid #000;
  background: #f1f3f7;
  vertical-align: top;
}
.table-scroll thead th {
  
  position: -webkit-sticky;
  position: sticky;
  top: 0;
}
/* safari and ios need the tfoot itself to be position:sticky also */
.table-scroll tfoot,
.table-scroll tfoot th,
.table-scroll tfoot td {
  position: -webkit-sticky;
  position: sticky;
  bottom: 0;
  background: #666;
  color: #fff;
  z-index:4;
}

a:focus {
  background: red;
} /* testing links*/

/* th:first-child {
  position: -webkit-sticky;
  position: sticky;
  left: 0;
  z-index: 2;
  
}
 */thead th:first-child,
tfoot th:first-child {
  z-index: 5;
}

</style>
 -->
 
 <style type="text/css">
table, th, td {
	border: 0px solid black;
	align: left;
	text-align: left;
}

table, th, td {
	border: 0px solid black;
	align: left;
	text-align: left;
}


	.scroll {
	    border-spacing: 0;
	    border: 0px solid black;
	}

	.scroll tbody,
	.scroll thead { 
	display: block;
	width: 100%;
	}
	
	thead tr th { 
	    height: 30px;
	    line-height: 30px;
	    
	}
	
	.scroll tbody {
	    height: 250px;
	    overflow-y: auto;
	    overflow-x: hidden;
	}
	
	div#map_container {
	width: 100%;
	height: 250px;
	border-radius: 5px;
}
	
	tbody { border-top: 0px solid black; }
	
	tbody td, thead th {
	    border-right: 0px solid black;
	}
	
	tbody td:last-child, thead th:last-child {
	    border-right: none;
	}
	
	
	
	
	
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
.table-wrap {
  position: relative;
}
.table-scroll th,
.table-scroll td {
  padding: 5px 10px;
  border: 0px solid #000;
  background: #f1f3f7;
  vertical-align: top;
}
.table-scroll thead th {
  
  position: -webkit-sticky;
  position: sticky;
  top: 0;
}
/* safari and ios need the tfoot itself to be position:sticky also */
.table-scroll tfoot,
.table-scroll tfoot th,
.table-scroll tfoot td {
  position: -webkit-sticky;
  position: sticky;
  bottom: 0;
  background: #666;
  color: #fff;
  z-index:4;
}

a:focus {
  background: red;
} /* testing links*/

th:first-child {
  position: -webkit-sticky;
  position: sticky;
  left: 0;
  z-index: 2;
  
}
thead th:first-child,
tfoot th:first-child {
  z-index: 5;
Collapse
}







</style>
 
 
 
 <html>
<head>
<%@ include file="sections/head.jsp"%>
<%@ include file="sections/dashboardCSS.jsp"%>


<!-- <script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&libraries=geometry">
 -->

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap&libraries=geometry&libraries=drawing"></script>


<script type="text/javascript">


 /* var j = jQuery.noConflict();
j( function() {
    j("#datepicker").datepicker();
} ); */
 	//edited anushka 2019-01-08 ---------------------------------------------------------------------
	var arrayDataToSave = [];
	//---------------------------------------------------------------------------------------------------

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
							option = option
									+ "<option value='"+data[i].code + "'>"
									+ data[i].lineName + "</option>";
						}
						slctSubcat.append(option);

						//alert("response.towerNo" + data);	
					}
				});

	}
	function getAreas() {
		$.ajax({
			type : 'GET',
			url : '/MMS/findAllAreaNew/',
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(response) {
				//alert(response);
				$('#cmbSelectArea').empty();
				//Append "None" item
				$('#cmbSelectArea').append(
						$('<option>').text("<< Select Area >>").attr('value',
								""));

				//Insert item from the response
				for (var i = 0; i < response.length; i++) {
					var item = response[i];
					$('#cmbSelectArea').append(
							$('<option>').text(item.deptNm).attr('value',
									item.deptId));
				}
			}
		});
	}

	//edited anushka 2019-01-08 ----------------------------------------------------------------
	function LoadLinesToEdit(pid) {
		//if(document.getElementById("pstatus_"+pid).value == 0 || document.getElementById("pstatus_"+pid).value == 1 || document.getElementById("pstatus_"+pid).value == 4){
		//alert("This item is sent for approving or active item or inactive item. You cann't edit this");
		//}
		//else{
		//enable(pid);
		arrayDataToSave.push(pid);

		//}
	}

	function editAll(stringIDs) {

		alert("You are going to edit that all lines.. \n" + stringIDs);
		var arrayAllIds = stringIDs.split(",");

		var len = arrayAllIds.length

		for (var count = 0; count < len; count++) {
			LoadLinesToEdit(arrayAllIds[count]);
		}
		
		

	}

	function disable(pid) {
		document.getElementById("pcode_" + pid).disabled = true;
		document.getElementById("pname_" + pid).disabled = true;
		document.getElementById("ptype_" + pid).disabled = true;
		document.getElementById("plegnth_" + pid).disabled = true;
		document.getElementById("parea_" + pid).disabled = true;
		document.getElementById("ppoles_" + pid).disabled = true;
		document.getElementById("ptowers_" + pid).disabled = true;
		document.getElementById("pcomdate_" + pid).disabled = true;
		document.getElementById("pstatus_" + pid).disabled = true;

		arrayDataToSave = [];
	}

	//-------------------------------------------------------------------------------------------

	function enable(pid) {
		document.getElementById("pcode_" + pid).disabled = false;
		document.getElementById("pname_" + pid).disabled = false;
		document.getElementById("ptype_" + pid).disabled = false;
		document.getElementById("plegnth_" + pid).disabled = false;
		document.getElementById("parea_" + pid).disabled = false;
		document.getElementById("ppoles_" + pid).disabled = false;
		document.getElementById("ptowers_" + pid).disabled = false;
		document.getElementById("pcomdate_" + pid).disabled = false;
		document.getElementById("pstatus_" + pid).disabled = false;
	}

	//edited anushka 2019-01-08 -----------------------------------------------------------------------------------
	function saveAll(stringIDs) {
		//alert('hiiiii jjjjj');
		var arrayAllIds = stringIDs.split(",");
		//alert('hiiiii jjjjj 1' + stringIDs);
		
		var len = arrayAllIds.length
		var incharge = document.getElementById("inchargecc").value;
		//alert('hiiiii	7' +incharge);

		for (var count = 0; count < len; count++) {
			//alert('hiiiii jjjjj 1ttttt' + arrayAllIds[count]);
			var pid = arrayAllIds[count];
			//LoadLinesToEdit(arrayAllIds[count]);
			//arrayDataToSave.push(arrayAllIds[count]);
			
			var csc = document.getElementById("csc_" + pid).value;
			  //alert('hiiiii	1' +csc);
			var grid = document.getElementById("grid_" + pid).value;
			  //alert('hiiiii	2'+grid);
			var altsup = document.getElementById("altsup_" + pid).value;
			   //alert('hiiiii	3'+altsup);
			var remarks = document.getElementById("remarks_" + pid).value;
			   //alert('hiiiii	4'+remarks);
			var announcement = document.getElementById("announcement_" + pid).value;
			   //alert('hiiiii	5' +announcement);
			var action = document.getElementById("action_" + pid).value;
			//alert('hiiiii	6' +action);
			
			 
			var url = "/MMS/updateIntteruption?id="+pid+"&csc=" +csc+ "&grid="+grid+"&altsup="+altsup+"&remarks="+remarks+"&announcement="+action+"&incharge="+incharge;

			//alert('hiiiii' +url);

			$.ajax({
				type : "GET",
				url : url,
				success : function(response) {
					//alert("Line updated succesfully...");
					console.log(response);
					window.location.reload();
					//disable(pid);
				}
			});

			
			
			
		}
		
				alert("Interruption Schedule updated succesfully... ");
	}
	
	
	function sendForValidationAll(stringIDs) {
		//alert('hiiiii jjjjj');
		var arrayAllIds = stringIDs.split(",");
		//alert('hiiiii jjjjj 1' + stringIDs);
		
		var len = arrayAllIds.length
		var incharge = document.getElementById("inchargecc").value;
		//alert('hiiiii	7' +incharge);

		for (var count = 0; count < len; count++) {
			alert('hiiiii jjjjj 1ttttt' + arrayAllIds[count]);
			var pid = arrayAllIds[count];
			//LoadLinesToEdit(arrayAllIds[count]);
			//arrayDataToSave.push(arrayAllIds[count]);
			
			var csc = document.getElementById("csc_" + pid).value;
			//  alert('hiiiii	1' +csc);
			var grid = document.getElementById("grid_" + pid).value;
			  //alert('hiiiii	2'+grid);
			var altsup = document.getElementById("altsup_" + pid).value;
			   //alert('hiiiii	3'+altsup);
			var remarks = document.getElementById("remarks_" + pid).value;
			   //alert('hiiiii	4'+remarks);
			var announcement = document.getElementById("announcement_" + pid).value;
			   //alert('hiiiii	5' +announcement);
			var action = document.getElementById("action_" + pid).value;
			//alert('hiiiii	6' +action);
			
			 
			var url = "/MMS/sendForIntteruption?id="+pid+"&csc=" +csc+ "&grid="+grid+"&altsup="+altsup+"&remarks="+remarks+"&announcement="+action+"&incharge="+incharge;

			//alert('hiiiii' +url);

			$.ajax({
				type : "GET",
				url : url,
				success : function(response) {
					//alert("Line updated succesfully...");
					console.log(response);
					//window.location.reload();
					//disable(pid);
				}
			});

		}
		alert("Interruption Schedule is succesfully forward to " + incharge);
		window.location.reload();
	}
	
	
	
	
	
	
	
	//-------------------------------------------------------------------------------------------------------------

	function save(pid) {
		//  alert('hiiiii');
		var pcode = document.getElementById("pcode_" + pid).value;
		//   alert('hiiiii	1' +pcode);
		var pname = document.getElementById("pname_" + pid).value;
		//   alert('hiiiii	2'+pname);
		var ptype = document.getElementById("ptype_" + pid).value;
		//   alert('hiiiii	3'+ptype);
		var plegnth = document.getElementById("plegnth_" + pid).value;
		//   alert('hiiiii	4'+plegnth);
		var parea = document.getElementById("parea_" + pid).value;
		//   alert('hiiiii	5' +parea);
		var ppoles = document.getElementById("ppoles_" + pid).value;
		//  alert('hiiiii	6' +ppoles);
		var ptowers = document.getElementById("ptowers_" + pid).value;
		//   alert('hiiiii	7' +ptowers);
		var pcomdate = document.getElementById("pcomdate_" + pid).value;
		//   alert('hiiiii	8' +pcomdate);
		var pstatus = document.getElementById("pstatus_" + pid).value;
		//   alert('hiiiii	9' +pstatus);
		//   alert('hiiiii');
		var url = "/MMS/updateLine/" + pid + "/" + pcode + "/" + pname + "/"
				+ ptype + "/" + plegnth + "/" + parea + "/" + ppoles + "/"
				+ ptowers + "/" + pcomdate + "/" + pstatus + "/";

		// alert('hiiiii' +url);

		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				alert("Line updated succesfully...");
				console.log(response);
				window.location.reload();
				disable(pid);
			}
		});

	}

	function MarkasRead(emailid) {

		var url = "/MMS/MarkasRead/" + emailid + "/";
		//alert(url);
		//alert("province: " + province + ",  area: " + area + "  ,line: " + line);
		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				alert("Succesfully Mark as Read...");
				console.log(response);
				window.location.reload();
				//disable( id );
			}
		});
	}
	
	function viewMore(id) {
		//var x = document.getElementById("myNumber").value;
		var x = 5;
		
		var c="<img src='<c:url value="/resources/img/CEBImages/Tower1.png"/>'>";
		    
		  var arr = [];
		  for (var i = 0; i < x; i++) {
			 // alert(c);
			  arr.push(c);
		  
		  document.getElementById("demo").innerHTML = arr.join("");

		}
	}
	
	function confirmRequest(id){
		
		var permit_no = document.getElementById("permit_no_"+id).value;
		if (permit_no === ""){
			alert("Permit No may not be empty");
			event.preventDefault();
			return false;
		}else{
			//permit_no = permit_no.replace("/", "-");
			
		}
		
		
		var incharge_es = document.getElementById("incharge_es_"+id).value;
		if (incharge_es === ""){
			alert("Incharge Es may not be empty");
			event.preventDefault();
			return false;
		}
		var altsup = document.getElementById("altsup_"+id).value;
		if (altsup === ""){
			//alert("Alternative Supply Arrangement may not be empty");
			//event.preventDefault();
			//return false;
			altsup ="NONE";
		}else{
			//altsup = altsup.replace("/", "-");
		}
		
		var file = document.getElementById("file1_"+id).value;
		
		$.ajax({
				type : 'GET',
				url : "/MMS/confirmRequest?emailId=" +id+ "&permitNo="+permit_no +"&es="+incharge_es+"&altsup="+altsup,
				data : {},
				contentType : "application/json; charset=utf-8",
				success : function(data) {
					alert("Succesfully confirmed...Email-SMS is succesfully sent to PHM ");
					window.location.reload();
					
				}
			});
	}
	
	function actionTaken(id){
		//alert(id);
		var strAction = document.getElementById("action_" + id).value;
		//alert(strAction);
		if(strAction == 1){
			confirmRequest(id);
		}else if(strAction == 2){
			reScheduleRequest(id);
		}else{
			notConfirmRequest(id);
		}
		
		
	}
	
	
	function enableResheduleDate(id){
		//alert(id);
		var strAction = document.getElementById("action_" + id).value;
		//alert(strAction);
		if(strAction == 1){
			document.getElementById("datepicker1_" + id).disabled = true;
			
		}else if(strAction == 2){
			document.getElementById("datepicker1_" + id).disabled = false;
			
		}else{
			document.getElementById("datepicker1_" + id).disabled = true;
			
		}
		
	}


function forwardedToEsRequest(id){
	
	$.ajax({
		type : 'GET',
		url : "/MMS/forwardedToEsRequest/" +id+ "/",
		data : {},
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			alert("Succesfully confirmed...Email-SMS is succesfully sent to PHM ");
			window.location.reload();
			
		}
	});
}


function notConfirmRequest(id){
		
		$.ajax({
			type : 'GET',
			url : "/MMS/notConfirmRequest/" +id+ "/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				alert("Succesfully done...Email-SMS is succesfully sent to PHM ");
				window.location.reload();
				
			}
		});
		
}


function reScheduleRequest(id){
	
	var permit_no = document.getElementById("permit_no_"+id).value;
	if (permit_no === ""){
		alert("Permit No may not be empty");
		event.preventDefault();
		return false;
	}else{
		//permit_no = permit_no.replace("/", "-");
		
	}
	var incharge_es = document.getElementById("incharge_es_"+id).value;
	if (incharge_es === ""){
		alert("Incharge Es may not be empty");
		event.preventDefault();
		return false;
	}
	var altsup = document.getElementById("altsup_"+id).value;
	if (altsup === ""){
		//alert("Alternative Supply Arrangement may not be empty");
		//event.preventDefault();
		//return false;
		altsup = "NONE";
	}else{
		//altsup = altsup.replace("/", "-");
		
	}
	
	
	
	//alert('hiiii');
	var reScheduleDate = document.getElementById("datepicker1_"+id).value;
	if (reScheduleDate === ""){
		alert("ReSchedule Date may not be empty");
		event.preventDefault();
		return false;
	}
	
	//alert(reScheduleDate);
	
	//var permit_no = document.getElementById("permit_no_"+id).value;
	//alert(permit_no);
	
	//var incharge_es = document.getElementById("incharge_es_"+id).value;
	//alert(incharge_es);
	
	
	$.ajax({
		type : 'GET',
		url : "/MMS/reScheduleRequest?emailId=" +id+ "&reScheduledate=" +reScheduleDate+ "&permitNo=" +permit_no +"&es="+incharge_es+"&altsup="+altsup,
		data : {},
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			alert("Succesfully done...Email-SMS is succesfully sent to PHM ");
			window.location.reload();
			
		}
	});
	
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

function loadNetwork(id) {
	//alert('hiii');
	var map = new google.maps.Map(document.getElementById("map_container"), {
      //center: new google.maps.LatLng(7.2665013,80.541458),
      center: new google.maps.LatLng(7.873054,80.771797),
      zoom: 12,
      gestureHandling: 'greedy',
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });

	var infoWindow = new google.maps.InfoWindow();
	var strArea = document.getElementById("area_" + id).value;
	//alert(strArea);
	var strLine =document.getElementById("lineid_" + id).value;;
	//alert(strLine);
	
	var selectedValues = '';
	
	var strProvince = 'NONE';
	var bounds = new google.maps.LatLngBounds();
	//alert('hiii: ' + strArea + strLine );
	$.ajax
    ({
            type: 'GET',
            url: "/MMS/AEMapINTNew/" + strArea +"/" + strLine +"/",
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
							if(data[0].interruptedYes == 0){
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
							  if(data[0].interruptedYes == 0){
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

    						/* var supType;
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
							 */
    						
    						
								
							
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
															       						       
															var contentString = "<div style='float:right; padding: 10px;'><table id ='ss'><th>Line Info</th></tr><tr><td>Line Code : </td><td>"+
															data[4].code+"</td></tr><tr><td>Area : </td><td>"+
															data[4].area+"</td></tr><tr><td>Com Date :  </td><td>"+
															data[4].comdate+"</td></tr><tr><td>Length :  </td><td>"+
															data[4].length+"</td></tr><tr><td>Line Name :  </td><td>"+
															"<td><button type='button' onclick='window.location.href='downloadInterruptionReq?id=${data[4].interruptionNo}''>Letter</button></td>"+
															
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


function openPopupRec(id)
	{
	      
		//alert(id);
		var url="downloadRecommendationLetter?id="+id;
	    var width = 1100;
	    var height = 700;
	    var left = parseInt((screen.availWidth/2) - (width/2));
	    var top = parseInt((screen.availHeight/2) - (height/2));
	    var windowFeatures = "width=" + width + ",height=" + height + 
	    ",status,resizable,left=" + left + ",top=" + top +
	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
	           
	}
	
function viewReport(){
	//
	var selectedValues = $("#area").val();
	var from = document.getElementById("txtFrom").value;
	var to = document.getElementById("txtTo").value;
	//alert("hiii"+selectedValues + from + to );
	
	
	
	var url="downloadIntSumReportCC?area=" + selectedValues + "&from="+from+"&to="+to;
	    var width = 1100;
	    var height = 700;
	    var left = parseInt((screen.availWidth/2) - (width/2));
	    var top = parseInt((screen.availHeight/2) - (height/2));
	    var windowFeatures = "width=" + width + ",height=" + height + 
	    ",status,resizable,left=" + left + ",top=" + top +
	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
	    
	

}

function viewReportExcel(){
	//
	var selectedValues = $("#area").val();
	var from = document.getElementById("txtFrom").value;
	var to = document.getElementById("txtTo").value;
	//alert("hiii"+selectedValues + from + to );
	
	
	
	var url="downloadIntSumReportCCExcel?area=" + selectedValues + "&from="+from+"&to="+to;
	
	/* $.ajax({
		type : "GET",
		url : url,
		success : function(response) {
			//alert("Succesfully Mark as Read...");
			//console.log(response);
			//window.location.reload();
			//disable( id );
		}
	});
	 */ var width = 1100;
	    var height = 700;
	    var left = parseInt((screen.availWidth/2) - (width/2));
	    var top = parseInt((screen.availHeight/2) - (height/2));
	    var windowFeatures = "width=" + width + ",height=" + height + 
	    ",status,resizable,left=" + left + ",top=" + top +
	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
	     
	

}

function viewAddExcel(){
	//
	var selectedValues = $("#area").val();
	var from = document.getElementById("txtFrom").value;
	var to = document.getElementById("txtTo").value;
	//alert("hiii"+selectedValues + from + to );
	
	
	
	var url="downloadIntSumReportCCExcelAdd?area=" + selectedValues + "&from="+from+"&to="+to;
	
	/* $.ajax({
		type : "GET",
		url : url,
		success : function(response) {
			//alert("Succesfully Mark as Read...");
			//console.log(response);
			//window.location.reload();
			//disable( id );
		}
	});
	 */ var width = 1100;
	    var height = 700;
	    var left = parseInt((screen.availWidth/2) - (width/2));
	    var top = parseInt((screen.availHeight/2) - (height/2));
	    var windowFeatures = "width=" + width + ",height=" + height + 
	    ",status,resizable,left=" + left + ",top=" + top +
	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
	     
	

}


function myFunction() {
	  var x = document.getElementById("test");
	  var y = document.getElementById("test1");
	  
	  //var elem = document.getElementById("showBtn");
	  x.style.display = "block";
	  y.style.display = "block";
	  
	 /*  if (x.style.display === "none") {
	    x.style.display = "block";
	    
	  } else {
	    x.style.display = "none";
	  }
	  
	  if (y.style.display === "none") {
		    y.style.display = "block";
		    
		  } else {
		    y.style.display = "none";
		  }
	 */	 
	  
	    /* if (elem.value=="Hide Options") elem.value = "Show Options";
	    else elem.value = "Hide Options"; */
	}


function closeall() {
	 var x = document.getElementById("test");
	 x.style.display = "none";
	 var y = document.getElementById("test1");
	 y.style.display = "none";
  return;
}





	</script>
	
<!-- 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
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
	alert("hii");
	
		  $.ajax({
    			type : 'GET',
    			url : "/MMS/displayAllInsRequestAENewView?mode=INT",
    			data : {},
    			contentType : "application/json; charset=utf-8",
    			success : function(result) {
    				
    				var datavaluepie = new google.visualization.DataTable();
    				datavaluepie.addColumn('string', 'Interruption Request No');
    				datavaluepie.addColumn('string', 'Area');
    				datavaluepie.addColumn('string', 'Section to be interrupted');
    				datavaluepie.addColumn('string', 'Time Duration');
    				datavaluepie.addColumn('string', 'Responsible EE/');
    				datavaluepie.addColumn('string', 'Field Work');
    				
    				
    				for (var i = 0; i < result.length; i++) {
    						var data = result[i];
    						//datavaluepie.addRows([[data[1], data[0],data[2]]]);
    				}
    				
    				 
    			     // Create a dashboard.
    		        var dashboard = new google.visualization.Dashboard(
    		            document.getElementById('dashboard_div'));

    		        // Create a range slider, passing some options
    		        var donutRangeSlider2 = new google.visualization.ControlWrapper({
    		          'controlType': 'CategoryFilter',
    		          'containerId': 'filter_div2',
    		          'options': {
    		        	'filterColumnLabel': 'Interruption Request No'
    		          }
    		        });

    		        // Create a pie chart, passing some options
    		        /* var pieChart = new google.visualization.ChartWrapper({
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
    		         */
    		        var table = new google.visualization.ChartWrapper({
    			          'chartType': 'Table',
    			          'containerId': 'estaprtable_div',
    			          'options': {
    			            'width': 1000,
    			            'height': 300,
    			            'pieSliceText': 'value',
    			            'legend': 'right'
    			          }
    			        });
  		        
    		        dashboard.bind(donutRangeSlider2, table);
    		        //dashboard.bind(donutRangeSlider2, pieChart);
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
    		    				var datavalue = new google.visualization.DataTable();
    		    				//datavalue.addColumn('string', 'Approve');
    		    				
    		    				datavalue.addColumn('string', 'ESTIMATE NO');
    		    				//datavalue.addColumn('string', 'Approve');
    		    				
    		    				datavalue.addColumn('string', 'DEPI ID');
    		    				datavalue.addColumn('string', 'DESCRIPTION');
    		    				datavalue.addColumn('string', 'CATEGARY CODE');
    		    				datavalue.addColumn('string', 'FUND SOURCE');
    		    				datavalue.addColumn('number', 'REBATE FOR MATERIAL');
    		    				datavalue.addColumn('number', 'ESTIMATED  CAPITAL  COST');
    		    				
    		    				
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
    		    		        	'filterColumnLabel': 'ESTIMATE NO'
    		    		          }
    		    		        });

    		    		        
    		    		        var table = new google.visualization.ChartWrapper({
    		    			          'chartType': 'Table',
    		    			          'containerId': 'estaprtabledetail_div',
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
     		    		            
     		    		            
     		    		            var url="downloadEstimate?estimateNo="+estimateNo+"&costCenter="+costCenterNo;
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
    		    		        google.visualization.events.addListener(table, 'select', selectHandler);
 

 
     		    		        
    		    			}
    		    		});

    		            
    		            
    		            
    		            
    		            
    		          }
    		         }
    		        
    		        
  		        	}
    		});
 
 
 
 
       
}
	</script>
 
 -->	
	
</head>
<body onload="myMap(new google.maps.LatLng(7.475214, 80.744077), 7);">
	<div id="theme-wrapper">

		<%@ include file="sections/header.jsp"%>

		<div id="page-wrapper" class="container">
			<div class="row">

				<%@ include file="sections/userLevelsOther.jsp"%>

				<div id="content-wrapper">

					<div class="row">
						<div class="col-lg-12">
							<div class="col-lg-9">
								<ol class="breadcrumb">
									<li><a href="#">Home</a></li>
									<li class="active"><span>Edit ${submitType} Schedule</span></li>
								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
						
						   <!-- <div class="col-sm-12" align="left">

									<div class="row">

										<div id="filter_div2"></div>
      
									</div>
								</div>
													   
													   <div class="col-sm-12" align="left">

									<div id="dashboard_div">
      Divs that will hold each control and chart
      <div id="estaprtable_div"></div>

												</div>
								</div>
						
						
					</div>
 -->
					<div class="row">
						<div class="col-lg-12">
							<div class="main-box clearfix">
								<%-- <header class="main-box-header clearfix">
									<h2 class="pull-left">${submitType} Status</h2>
								</header>
 --%>
								<div class="main-box-body clearfix">
									<!-- <div class="table-responsive" class="table-scroll">
									<div class="table-scroll">
									 -->
										<table class="table table-responsive" id="tblProvinces">

											<thead>

											</thead>
											
																						
											<tbody>
												<form:form method="post" action="createIntScheduleEdit?mode=${province}&type=${type}"
													modelAttribute="model">
													<c:set var="mode" value="${model.mode}" />
													<c:set var="type" value="${model.type}" />
													
															<!-- <div class="col-sm-12" align="center"> -->
											<c:if test="${model.type !='SFVES'}">
													
													<!-- <div class="row"> -->
													
													
													 <table id="dtHorizontalVerticalExample" class="table table-striped table-bordered table-sm " cellspacing="0"
  width="100%">
  <thead>
  <tr>
    <td>Area</td>
    <td><form:select id="area" multiple="true" path="from" onchange="" style="width:100%;" class="form-control"><form:options items="${model.areaList}" /></form:select></td>								
 </tr>
 <tr>
    <td>From</td>
    <td> <form:input path="fromDate" type="date" class="form-control" id="txtFrom" placeholder="Date and Time" /></td>								
 </tr>
  <tr>
    <td>To</td>
    <td><form:input path="toDate" type="date" class="form-control"  id="txtTo" placeholder="Date and Time" /></td>								
 </tr>
 <tr>
    <td>Forward To</td>
    <td><form:select id="inchargecc" path="intRequestObj.inchargeEs" class="form-control"  style="background-color: #FFFFF; border-radius: 5px;"><form:options items="${model.saList}"/></form:select></td>								
 </tr>
 <tr>
    <td><button class="btn" type="submit" name="actionButton" class="form-control"><i class="fa fa-hand-o-right  green-bg"></i></button></td>
    								
 </tr>
 
      
    </table>
     </c:if>
													
													
													
													
													
													
													
													
													
													
													
													
													
																										
															
																<%-- <div class="col-lg-8" align="left">														
															<div class="drop-down-padding">
															<div>Area</div>											
													<form:select id="area" multiple="true" path="from" onchange="" style="width:100%;" class="form-control">
																			<form:options items="${model.areaList}" />
																</form:select>													
													</div>
													</div>
													</div>
													<br>
													<div class="row">
													<div class="col-lg-3 col-sm-6 col-xs-12">
													<div>
													<div>From</div>
											 <form:input
																	path="fromDate" type="date" class="form-control"
																	id="txtFrom" placeholder="Date and Time" /> 
</div>
</div>
														<div class="col-lg-3 col-sm-6 col-xs-12">
													<div><div>To</div><form:input
																	path="toDate" type="date" class="form-control"
																	id="txtTo" placeholder="Date and Time" /></div></div>
																	
														
														<div class="col-lg-3 col-sm-6 col-xs-12"><div class="drop-down-padding"><div>Forward To</div><form:select id="inchargecc" path="intRequestObj.inchargeEs" class="form-control"  style="background-color: #FFFFF; border-radius: 5px;">
																	    <form:options items="${model.saList}"/>
																	 </form:select></div></div>
																	 </div>
																	 </c:if>
																	</div>
		 --%>												 
														
														<%-- <tr>
															<td width="30%" style="text-align: left"><form:label
																	path="" for="txtLUTD">Action :
											</form:label></td>
															 <td style="text-align:left"> <select id="action_${email.approvalId}" class="form-control"  style="background-color: #94cb71; border-radius: 5px;">
																	      <option value="4">Recommend</option>
                                                                          <option value="5">Cancel</option>
                                                                         <!--  <option value="3">Not Recommend</option> -->
																</select>
																</td>
																
														</tr>
														 --%>
														<%--  <c:if test="${model.type !='SFVES'}">
													
														 <tr>
															<td width="30%" style="text-align: left"><input
																	class="btn btn-success" type="submit"
																	name="actionButton" value="Go"  class="form-control"></input></td>
																	
																
														</tr>
														</c:if>
													 --%>	
														</form:form>
														</tbody>
																						
										</table>
													
											         <br>
											         <div id = "test" class="table-responsive" class="table-scroll">
											         <div class="table-scroll">
											           <table class="table table-striped table-bordered table-sm " id="tblAdmin">
													   	<thead>
															<c:choose>
																<c:when test="${submitType=='Inspection'}">
																<tr>
															<th class="text-center">Inspection Request No</th>
															<th class="text-center">Area</th>
															
															<th class="text-center">Requirement</th>
															<th class="text-center">Requesting section/s to be inspected</th>
															
															<th class="text-center">Date </th>
															<th class="text-center">Time</th>
																<th></th>
																
															</tr>
														</c:when>
														<c:when test="${submitType=='Maintenance'}">
																<tr>
															<th class="text-center">Maintenance Request No</th>
															<th class="text-center">Area</th>
															
															<th class="text-center">Requirement</th>
															<th class="text-center">Requesting section/s to be maintained</th>
															
															<th class="text-center">Date </th>
															<th class="text-center">Time</th>
																<th></th>
																
															</tr>
														</c:when>
														<c:when test="${submitType=='WayLeave'}">
																<tr>
															<th class="text-center">WayLeave Request No</th>
															<th class="text-center">Area</th>
															
															<th class="text-center">Requirement</th>
															
															<th class="text-center">Date </th>
															<th class="text-center">Time</th>
																<th></th>
																
															</tr>
														</c:when>
														
														<c:when test="${submitType=='Interruption'}">
																<tr>
															<th class="text-center" class="form-control">Interruption Request No</th>
															<th class="text-center" class="form-control">Area</th>
															<th class="text-center" class="form-control">Generated Date & Time</th>
															<th class="text-center" class="form-control">Forwarded Date & Time</th>
															<th class="text-center" class="form-control">Approved Date & Time</th>
															<th class="text-center" class="form-control">Time Duration</th>
															<th class="text-center" class="form-control">Requested EE/ES</th>
															
														    <th class="text-center" class="form-control">Field Work</th>
														   <th class="text-center" class="form-control">Section to be interrupted</th>
														    
														    <!-- <th class="text-center">Location</th>
															 --><!-- <th class="text-center">Field Work</th> -->
															 <!-- <th class="text-center">Forward To</th>
															  --><!-- <th class="text-center">Attachment</th>
															 -->
															 <th class="text-center" class="form-control">Reschedule Date</th>
															
															 <th class="text-center" class="form-control">Permit Number</th>
															 
															 <th class="text-center" class="form-control">CSC</th>
															<th class="text-center" class="form-control">Grid</th>
															
															 <th class="text-center" class="form-control">Alternative Supply Arrangement</th>
															
															<th class="text-center" class="form-control">Remarks</th>
															<th class="text-center" class="form-control">Announcement</th>
															
															 <th class="text-center" class="form-control">Action</th>
															 <th></th>
															<!-- <th class="text-center">Incharge ES</th>
															 --><th></th>
															
															<th ></th>
																<th></th>
																<th></th>
																<th></th>
																<th></th>
																<th></th>
																<th></th>
																
																<th></th>
																
																<th></th>
																
																<th></th>
																
																
																
															</tr>
														</c:when>
														
														</c:choose>
														
														</thead>
														<tbody>
															<c:forEach var="email" items="${model.unReadInspectionReq}">
																<c:choose>
																<c:when test="${submitType=='Inspection'}">
														
																<tr>
																<td style="text-align:center"><input style="text-align:center" type="text" id="" value="${email.approvalId}"  class="form-control" disabled></td>
																<td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.referenceNo}</textarea></td>
																<td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.req1}</textarea></td>
																<td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.req2}</textarea></td>
																<td style="text-align:center"><input style="text-align:center" type="date" id="" value="${email.approvedDate}" class="form-control" disabled></td>
																<td style="text-align:center"><input style="text-align:center" type="time" id="" value="${email.approvedTime}" class="form-control" disabled></td>
																<td><button type='button' class='btn btn-warning' onclick="window.location.href='downloadInterruptionReq?id=${email.approvalId}'">Letter</button></td>
																
</tr>
</c:when>
<c:when test="${submitType=='Maintenance'}">
														
																<tr>
																<td style="text-align:center"><input style="text-align:center" type="text" id="" value="${email.approvalId}"  class="form-control" disabled></td>
																<td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.referenceNo}</textarea></td>
																<td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.req1}</textarea></td>
																<td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.req2}</textarea></td>
																<td style="text-align:center"><input style="text-align:center" type="date" id="" value="${email.approvedDate}" class="form-control" disabled></td>
																<td style="text-align:center"><input style="text-align:center" type="time" id="" value="${email.approvedTime}" class="form-control" disabled></td>
																<td><button type='button' class='btn btn-warning' onclick="window.location.href='downloadInterruptionReq?id=${email.approvalId}'">Letter</button></td>
																
</tr>
</c:when>
<c:when test="${submitType=='WayLeave'}">
														
																<tr>
																<td style="text-align:center"><input style="text-align:center" type="text" id="" value="${email.approvalId}"  class="form-control" disabled></td>
																<td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.referenceNo}</textarea></td>
																<td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.reason}</textarea></td>
																<td style="text-align:center"><input style="text-align:center" type="date" id="" value="${email.approvedDate}" class="form-control" disabled></td>
																<td style="text-align:center"><input style="text-align:center" type="time" id="" value="${email.approvedTime}" class="form-control" disabled></td>
																<td><button type='button' class='btn btn-warning' onclick="window.location.href='ViewProvincialScheduleAE?mode=VR'">Way Leave</button></td>
																<td><button type='button' class='btn btn-warning' onclick="window.location.href='ViewProvincialScheduleAE?mode=EWOP'">Electrical Works On Poles</button></td>
																<td><button type='button' class='btn btn-warning' onclick="window.location.href='ViewProvincialScheduleAE?mode=MPL'">Missing Parts</button></td>
																
</tr>
</c:when>

<c:when test="${submitType=='Interruption'}">
														
																<tr>
																<th style="text-align:center"><input style="text-align:center" type="text" id="" value="${email.approvalId}"  class="form-control" disabled></th>
																<td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.referenceNo}</textarea></td>
																<td style="text-align:center"><textarea rows="3" cols="60" class="form-control" disabled>${email.approvedDate} ${email.approvedTime}</textarea></td>
																<td style="text-align:center"><textarea rows="3" cols="60" class="form-control" disabled>${email.forwardDate} ${email.forwardedTime}</textarea></td>
																 <td style="text-align:center"><textarea rows="3" cols="60" class="form-control" disabled>${email.actionDate} ${email.actionTime}</textarea></td>
																
																<%-- <% String s = request.getParameter("txtFrom"); %>
																 <% String a = request.getParameter("datehidden");%>
																
																<%=s%>
																<%=a%>
																
																<% if (s > a) { %>
																<% } else { %>
																<% } %> --%>
																<c:choose>
 <c:when test="${email.toStatus=='80'}">
<td style="text-align:left ;background-color:#23cc45"><textarea rows="3" cols="60" class="form-control" disabled>${email.rescheduleDate} ${email.fromtime} ${email.totime}</textarea></td>

</c:when>
<c:otherwise>
<td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.timeduration}</textarea></td>
																
</c:otherwise>
 </c:choose>
 <%-- <td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.timeduration}</textarea></td>
 
 <td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.rescheduleDate} ${email.fromtime} ${email.totime}</textarea></td>
  --%>
 
																<td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.reason}</textarea></td>
																
																<%-- <td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.req1}</textarea></td>
																 --%><td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.req2}</textarea></td>
																 <td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.fromto}</textarea></td>
																
																<%-- <td style="text-align:center"><input style="text-align:center" type="date" id="datepicker1_${email.approvalId}"  class="form-control" disabled>${email.rescheduleDate}</input></td>
																 --%> 
																 <td style="text-align:center"><textarea rows="3" cols="60" class="form-control" disabled>${email.rescheduleDate}</textarea></td>
																<td style="text-align:center"><textarea rows="3" cols="60" class="form-control" disabled>${email.permitNo}</textarea></td>
																<td style="text-align:left"><textarea rows="3" cols="20" id="csc_${email.approvalId}" class="form-control">${email.csc}</textarea></td>
																<td style="text-align:left"><textarea rows="3" cols="20" id="grid_${email.approvalId}" class="form-control">${email.grid}</textarea></td>
																
																<td style="text-align:left"><textarea rows="3" cols="30" id="altsup_${email.approvalId}" class="form-control">${email.altSupArrangement}</textarea></td>
																
																<td style="text-align:left"><textarea rows="3" cols="30" id="remarks_${email.approvalId}" class="form-control">${email.remarks}</textarea></td>
																<td style="text-align:left"> <select id="announcement_${email.approvalId}" class="form-control"  style="background-color: #94cb71; border-radius: 5px;">
																	      <option value="1">Paper & Letter to Bulk Suppliers</option>
                                                                          <option value="2">News paper and SMS</option>
                                                                          <option value="3">SMS & Newspaper</option>
                                                                          
                                                                         <!--  <option value="3">Not Recommend</option> -->
																</select>
																</td>
																
																<td style="text-align:left"> <select id="action_${email.approvalId}" class="form-control"  style="background-color: #94cb71; border-radius: 5px;">
																	      <option value="4">Recommend</option>
                                                                          <option value="5">Cancel</option>
                                                                         <!--  <option value="3">Not Recommend</option> -->
																</select>
																</td>
															
																<%-- <td style="text-align:left"><input  type="file" name="file1" id="file1_${email.approvalId}" ></td>
																 --%>
																<td><button type='button' class='btn btn-info' onclick='actionTaken("${email.approvalId}")' class="form-control">OK</button></td>
																										
																 
																	 
																<%-- <td><button type='button' class='btn btn-warning' onclick="forwardedToEsRequest("${email.approvalId}")">Forwarded to ES</button></td>
																 --%><%-- <td><button type='button' class='btn btn-info' onclick='confirmRequest("${email.approvalId}")'>Recommend</button></td>
																<td><button type='button' class='btn btn-info' onclick='notConfirmRequest("${email.approvalId}")'>Not Recommend</button></td>
																<td><button type='button' class='btn btn-info' onclick='reScheduleRequest("${email.approvalId}")'>Reschedule</button></td>
																 --%><td><button type='button' class='btn btn-info' onclick='loadNetwork("${email.approvalId}")'>Network View</button></td>
																
																<td><button type='button' class='btn btn-info' onclick="window.location.href='downloadInterruptionReq?id=${email.approvalId}'">Request Letter</button></td>
																
																<td><button type='button' class='btn btn-success' onClick='openPopupRec("${email.approvalId}")'>Recommendation Letter</button></td>
																
																<c:if test="${email.filename1 != null}">
  																	<td><button type='button' class='btn btn-success' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'">Image 1</button></td>
																</c:if>
																<c:if test="${email.filename2 != null}">
  																	<td><button type='button' class='btn btn-success' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'">Image 2</button></td>
																</c:if>
																<c:if test="${email.filename3 != null}">
  																	<td><button type='button' class='btn btn-success' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'">Image 3</button></td>
																</c:if>
																<c:if test="${email.filename4 != null}">
  																	<td><button type='button' class='btn btn-success' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'">Image 4</button></td>
																</c:if>
																<c:if test="${email.filename5 != null}">
  																	<td><button type='button' class='btn btn-success' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'">Image 5</button></td>
  																	
																</c:if>
																<input style="text-align:center" type="hidden" id="datehidden" value="${email.actionDate}"  class="form-control" disabled></input>																
																<input style="text-align:center" type="hidden" id="area_${email.approvalId}" value="${email.areaCode}"  class="form-control" disabled>
																            <input style="text-align:center" type="hidden" id="lineid_${email.approvalId}" value="${email.lineid}"  class="form-control" disabled>
																
																	
												</tr>
</c:when>

</c:choose></c:forEach>
 </tbody>
 </table>
  </div>
  												
													
													
													
													
													
													<p id="demo"></p>
													

											
									<!-- </div>

								</div>
 -->								
 </div>
 </div>
							</div>
						</div>
					</div>
					<%-- <div id = "test1" class="col-sm-12" align="left">
<c:if test="${model.type =='EDIT'}">
 <input id="pivFormBtn" class="btn btn-success"
																			type="button" name="actionButton" onClick='javascript:saveAll("${model.stringOfLineIds}")' value="Update"></input>
																			</c:if>
																			<c:if test="${model.type =='SFVDEO'}">
 <input id="pivFormBtn" class="btn btn-success"
																			type="button" name="actionButton" onClick='javascript:sendForValidationAll("${model.stringOfLineIds}")' value="Send for Validation"></input>
																			</c:if>
																			<c:if test="${model.type =='SFVES'}">
 <input id="pivFormBtn" class="btn btn-success"
																			type="button" name="actionButton" onClick='javascript:sendForValidationAll("${model.stringOfLineIds}")' value="Send for Validation"></input>
																			</c:if>
																			
																			
												
																			
 
<input id="pivFormBtn" class="btn btn-success"
																			type="button" name="actionButton" onClick="viewReport()" value="View Interruption Summary Report"></input>
																		<input id="pivFormBtn" class="btn btn-success"
																			type="button" name="actionButton" onClick="viewReportExcel()" value="View Interruption Summary Report -Excel"></input>
																			<input id="pivFormBtn" class="btn btn-success"
																			type="button" name="actionButton" onClick="viewAddExcel()" value="View Interruption Advertisement -Excel"></input>
															
															
</div>
 --%>	
 
 <div class="btn-group mr-2" role="group" aria-label="First group">
    <div class="btn-group" role="group" aria-label="Basic example">
    <%-- <c:if test="${model.type =='EDIT'}">
    
    <button id ="btnApprove" type="button" class="btn btn-secondary" onClick='javascript:saveAll("${model.stringOfLineIds}")'>Update</button>
    </c:if>
    <c:if test="${model.type =='SFVDEO'}">
   <button id ="btnReject" type="button" class="btn btn-secondary" onClick='javascript:sendForValidationAll("${model.stringOfLineIds}")'>Send for Validation</button>
  </c:if>
  <c:if test="${model.type =='SFVES'}">
  <button type="button" id ="btnPrint" class="btn btn-secondary" onClick='javascript:sendForValidationAll("${model.stringOfLineIds}")'>Send for Validation</button>
</c:if> --%>
<button id ="btnUpdate" type="button" class="btn btn-secondary" onClick='javascript:saveAll("${model.stringOfLineIds}")'>Update</button>
<button id ="btnSendForValidation" type="button" class="btn btn-secondary" onClick='javascript:sendForValidationAll("${model.stringOfLineIds}")'>Send for Validation</button>
  
<button id="pivFormBtn1" class="btn btn-secondary" type="button" onClick="viewReport()" >View Interruption Summary Report</button>
<button id="pivFormBtn2" class="btn btn-secondary" type="button"  onClick="viewReportExcel()" >View Interruption Summary Report -Excel</button>
<button id="pivFormBtn3" class="btn btn-secondary" type="button"  onClick="viewAddExcel()" >View Interruption Advertisement -Excel</button>


</div>
</div>
 				
					
					
									<div class="row">

										<div id="map_container"></div>

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