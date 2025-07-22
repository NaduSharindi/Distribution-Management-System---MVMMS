<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style type="text/css">
table, th, td {
	border: 0px solid black;
	align: left;
	text-align: left;
}

thead tr th { 
	        height: 30px;
	    line-height: 30px;
	    color:white;
	    background-color:#008ae6;
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
  background: #008ae6;
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

th:first-child {
  position: -webkit-sticky;
  position: sticky;
  left: 0;
  z-index: 2;
  
}
thead th:first-child,
tfoot th:first-child {
  z-index: 5;
}</style>

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
					url : "/MMS/piechart",
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(result) {
						
						var arrValues = [["Sensor","Temp",{"role":"style"}]];
						var value1;
						var value2
						for (var i = 0; i < result.length; i++) {
														
						}
						 var data = new google.visualization.DataTable();
					      data.addColumn('string', 'Task ID');
					      data.addColumn('string', 'Task Name');
					      data.addColumn('string', 'Resource');
					      data.addColumn('date', 'Start Date');
					      data.addColumn('date', 'End Date');
					      data.addColumn('number', 'Duration');
					      data.addColumn('number', 'Percent Complete');
					      data.addColumn('string', 'Dependencies');
					      data.addRows([
					                    ['2014Spring', 'Trincomalee', 'spring',
					                     new Date(2020, 1, 1), new Date(2020, 2, 20), null, 100, null],
					                    ['2014Summer', 'Nawalapitiya', 'summer',
					                     new Date(2020, 5, 21), new Date(2020, 8, 20), null, 100, null],
					                    ['2014Autumn', 'Matale', 'autumn',
					                     new Date(2020, 8, 21), new Date(2020, 11, 20), null, 100, null],
					                    ['2014Winter', 'Dambulla', 'winter',
					                     new Date(2020, 11, 21), new Date(2020, 2, 21), null, 100, null],
					                    ['2015Spring', 'Kandy City', 'spring',
					                     new Date(2020, 2, 22), new Date(2020, 5, 20), null, 50, null],
					                    ['2015Summer', 'Peradeniya', 'summer',
					                     new Date(2020, 5, 21), new Date(2020, 8, 20), null, 0, null],
					                    ['2015Autumn', 'Kalmunai', 'autumn',
					                     new Date(2020, 8, 21), new Date(2020, 11, 20), null, 0, null],
					                    ['2015Winter', 'Batticaloa', 'winter',
					                     new Date(2020, 11, 21), new Date(2020, 2, 21), null, 0, null],
					                    ['Football', 'Nuwaraeliya', 'sports',
					                     new Date(2020, 8, 4), new Date(2020, 1, 1), null, 100, null],
					                    ['Baseball', 'Kegalle', 'sports',
					                     new Date(2020, 2, 31), new Date(2020, 9, 20), null, 14, null],
					                    ['Basketball', 'Divulapitiya', 'sports',
					                     new Date(2020, 9, 28), new Date(2020, 5, 20), null, 86, null],
					                    ['Hockey', 'Negambo', 'sports',
					                     new Date(2020, 9, 8), new Date(2020, 5, 21), null, 89, null]
					                  ]);

					      var ganttoptions = {
					    	        height: 400,
					    	        gantt: {
					    	          trackHeight: 30
					    	        }
					    	      };
 
					    var ganttchart = new google.visualization.Gantt(document.getElementById('chart_div'));
					    ganttchart.draw(data, ganttoptions);
					}
				});
}
</script>




<html>
<head>
<%@ include file="sections/head.jsp"%>

<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&libraries=geometry">

</script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5quFsUs92n9cCa6kocQhKHVt7QhrkE3c&callback=myMap&libraries=geometry&libraries=drawing"></script>


<script type="text/javascript">
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
		enable(pid);
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
	function saveAll() {
		var len = arrayDataToSave.length
		alert('hiiiii ' + len);
		for (var count = 0; count < len; count++) {
			var pid = arrayDataToSave[count];

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
			var url = "/MMS/updateLine/" + pid + "/" + pcode + "/" + pname
					+ "/" + ptype + "/" + plegnth + "/" + parea + "/" + ppoles
					+ "/" + ptowers + "/" + pcomdate + "/" + pstatus + "/";

			alert('hiiiii' +url);

			$.ajax({
				type : "GET",
				url : url,
				success : function(response) {
					//alert("Line updated succesfully...");
					console.log(response);
					window.location.reload();
					disable(pid);
				}
			});
		}
		alert("Lines updated succesfully... ");
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

		var url = "/MMS/MarkasRead/" + emailid + "/" +"8"+"/";
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
		
		window.open("E:/MVMMS/Reports/INS-442.00-0001-2019-11-15-2-8-54-135.pdf");
		//$("#dialog").dialog();
        //$("#frame").attr("src", "E:/MVMMS/Reports/INS-442.00-0001-2019-11-15-2-8-54-135.pdf");
		//var x = document.getElementById("myNumber").value;
		/* var x = 5;
		var c="<img src='<c:url value="/resources/img/CEBImages/Tower1.png"/>'>";
		    
		  var arr = [];
		  for (var i = 0; i < x; i++) {
			 // alert(c);
			  arr.push(c);
		  
		  document.getElementById("demo").innerHTML = arr.join("");

		}
 */	}
	
	
function forwardRequest(id){
		
		//var strUser = userId.options[userId.selectedIndex].value;
		//if(strUser != "NONE"){
		var pname = document.getElementById("forwaded_" + id).value;
		//alert(pname);
			var strUser = "60041ES1";
			//alert(id);
		$.ajax({
			type : 'GET',
			url : "/MMS/sendRequestToArea/" +id+ "/"+ pname + "/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				alert("Succesfully forwarded...Email-SMS is succesfully sent to relevent Area Engineer ");
				window.location.reload();
				
			}
		});
		//}else{
			//alert("Please select the Electrical Superintendent");
			
		//}
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


function openPopupSubmit(id)
{
      
	alert(id);
	var url="downloadInterruptionReq?id="+id;
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
      
	alert(id);
	var url="downloadIntImgReq?id="+id+"&seq=1";
    var width = 1100;
    var height = 700;
    var left = parseInt((screen.availWidth/2) - (width/2));
    var top = parseInt((screen.availHeight/2) - (height/2));
    var windowFeatures = "width=" + width + ",height=" + height + 
    ",status,resizable,left=" + left + ",top=" + top +
    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
           
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
							data[0].towerNo+"</td></tr>"+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit(\"" + data[0].interruptionNo + "\")'>Letter</button></td>"+
							"<td><button type='button' id='myBtn'  onClick='openPopupSubmitImg1(\"" + data[0].interruptionNo + "\")'>IMG I</button></td>"+
							"<td><button type='button' id='myBtn'  onClick='openPopupSubmit(\"" + data[0].interruptionNo + "\")'>IMG II</button></td>"+
							"<td><button type='button' id='myBtn'  onClick='openPopupSubmit(\"" + data[0].interruptionNo + "\")'>IMG III</button></td>"+
							"<td><button type='button' id='myBtn'  onClick='openPopupSubmit(\"" + data[0].interruptionNo + "\")'>IMG IV</button></td>"+
							"<td><button type='button' id='myBtn'  onClick='openPopupSubmit(\"" + data[0].interruptionNo + "\")'>IMG V</button></td>"+
							"</tr> "+
							"<tr><td>Distance to next tower (m) :</td><td>"+
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
									<li class="active"><span>Maintenance Plan</span></li>
								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="main-box clearfix">
								<!-- <header class="main-box-header clearfix">
									<h2 class="pull-left">Unread Way Leave Status</h2>
								</header>
 -->
								<div class="main-box-body clearfix">
									<div class="table-responsive" class="table-scroll">
									<div class="table-scroll">
									
										 <div id="chart_div"></div>
									</div>

								</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="col-sm-12" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
									
					</div>
					
					
					<div id="dialog" style="display: none;">
    <div>
        <iframe id="frame"></iframe>
    </div>
</div>
					
					
					<div>
						<table class="table-responsive" align="center">
							<tbody style="text-align:center">
								<!-- edited 2 anushka open 2018-11-30 -->
<p id="demo"></p>
										
													<!-- edited 2 anushka close 2018-11-30 -->
							</tbody>
						</table>
					</div>
					

					<%@ include file="sections/footer.jsp"%>

				</div>
			</div>
		</div>
	</div>

	<%@ include file="sections/global_scripts.jsp"%>

</body>
</html>