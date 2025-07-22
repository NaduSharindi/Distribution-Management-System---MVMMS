<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>

#newst td,th{
  font-size: 10px;
}

div#map_container {
	width: 100%;
	height: 250px;
	border-radius: 5px;
}

.table-condensed{
  font-size: 15px;
  border: 1px solid black;
  border-collapse: collapse;
}

.btn {
  background-color: #EAC117; /* Blue background */
  border: 2px solid #EAC117; /* Remove borders */
  color: white; /* White text */
  padding: 12px 16px; /* Some padding */
  font-size: 16px; /* Set a font size */
  cursor: pointer; /* Mouse pointer on hover */
  width:20px;
}

#dtable table{
width: 50%;
}

#myInput {
  background-image: url('/css/searchicon.png');
  background-repeat: no-repeat;
  width: 100%;
  font-size: 14px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}
#newyu td,th{
  font-size: 8px;
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
		var r = confirm("You are going to forward the interruption request number :" + id);
		if (r == true) {
		    $.ajax({
				type : 'GET',
				url : "/MMS/sendRequestToArea/" +id+ "/"+ pname + "/",
				data : {},
				contentType : "application/json; charset=utf-8",
				success : function(data) {
					alert("Succesfully forwarded...Email-SMS is succesfully sent to relevent branch ");
					window.location.reload();
					
				}
			});
			}else{
			//alert("Please select the Electrical Superintendent");
			
		}
	}
	
	
function removeRequest(id){
	
	//var strUser = userId.options[userId.selectedIndex].value;
	//if(strUser != "NONE"){
	//var pname = document.getElementById("forwaded_" + id).value;
	//alert(pname);
		var strUser = "60041ES1";
		//alert(id);
		var r = confirm("You are going to remove the interruption request number :" + id);
		if (r == true) {
		
			$.ajax({
				type : 'GET',
				url : "/MMS/removeRequest/" +id +"/",
				data : {},
				contentType : "application/json; charset=utf-8",
				success : function(data) {
					alert("Succesfully removed...");
					window.location.reload();
					
				}
			});
			}else{
		//alert("Please select the Electrical Superintendent");
		
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
      
	//alert(id);
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
      
	//alert(id);
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

function openPopupSubmitImg2(id)
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

function openPopupSubmitImg3(id)
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
function openPopupSubmitImg4(id)
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


function openPopupSubmitImg5(id)
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
	//var strArea = document.getElementById("area_" + id).value;
	//alert(strArea);
	//var strLine =document.getElementById("lineid_" + id).value;;
	//alert(strLine);
	
	var selectedValues = '';
	
	var strProvince = 'NONE';
	var bounds = new google.maps.LatLngBounds();
	//alert('hiii: ' + strArea + strLine );
	$.ajax
    ({
            type: 'GET',
            url: "/MMS/NetWorkView?id=" +id ,
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
						
						
							if(data[0].interruptionNo){
								
							
    						  if(data[0].interruptedYes == 0){
  								var marker = new google.maps.Marker({
              						position: latLng,
              						map: map,
              						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
              						//marker.setIcon(zoomIcons[map.getZoom()]);
              						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Blue.png"/>',
              						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].interruptedDate +'-'+data[0].interruptionNo },
              						title: "Pending : "+data[0].towerNo + " INT NO :" + data[0].interruptionNo
              					});
  							}else if(data[0].interruptedYes == 1){
  								var marker = new google.maps.Marker({
              						position: latLng,
              						map: map,
              						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
              						//marker.setIcon(zoomIcons[map.getZoom()]);
              						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Green.png"/>',
              						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].interruptedDate +'-'+data[0].interruptionNo },
              						title: "Recommended : "+data[0].towerNo + " INT NO :" + data[0].interruptionNo
              					});
  							}else if(data[0].interruptedYes == 3){
  								var marker = new google.maps.Marker({
              						position: latLng,
              						map: map,
              						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
              						//marker.setIcon(zoomIcons[map.getZoom()]);
              						icon: '<c:url value="/resources/img/CEBImages/GolfClub_Circle_Orange.png"/>',
              						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].interruptedDate +'-'+data[0].interruptionNo },
              						title: "Past : "+data[0].towerNo + " INT NO :" + data[0].interruptionNo
              					});
  							}else{
  								var marker = new google.maps.Marker({
              						position: latLng,
              						map: map,
              						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
              						//marker.setIcon(zoomIcons[map.getZoom()]);
              						icon: {
		        					          path: google.maps.SymbolPath.CIRCLE,
		        					          scale: 1
		        					    },
            						title: "Click here to view details of Tower ID "+data[0].towerNo + " ID " + data[0].id
              					});
  						  }
							}
							
							else{
  								var marker = new google.maps.Marker({
              						position: latLng,
              						map: map,
              						//zoomIcons = [null, icon1, icon2];  // No such thing as zoom level 0. A global variable or define within object.
              						//marker.setIcon(zoomIcons[map.getZoom()]);
              						icon: {
		        					          path: google.maps.SymbolPath.CIRCLE,
		        					          scale: 1
		        					    },
            						title: "Click here to view details of Tower ID "+data[0].towerNo + " ID " + data[0].id
              					});
  						  }
							//alert("data.tapping : "+ data.tapping);
						/* if(data[0].tapping > 0 ){


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
            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].interruptedDate +'-'+data[0].interruptionNo },
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
	            						//label: { color: '#EF5E57', fontWeight: 'bold', fontSize: '12px', text: data[0].interruptedDate +'-'+data[0].interruptionNo },
	            						title: "Click here to view details of Tower ID "+data[0].towerNo + " INT NO" + data[0].interruptionNo
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




							
    						
            		}
 */    					//data.gpsLatitude, data.gpsLongitude
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
							
							
							var contentString = "<div style='float:right; padding: 10px;'><table id ='ss'><th>Line Info</th><tr><td>Line Code : </td><td>"+
							data[4].code+"</td></tr><tr><td>Area : </td><td>"+
							data[4].area+"</td></tr>"+
							"<tr><td><button type='button' id='myBtn'  onClick='openPopupSubmit(\"" + data[0].interruptionNo + "\")'>Letter</button></td></tr>"+
							"<tr><td>Com Date :  </td><td>"+
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


function netWorkNew(id)
{
      
	//alert(id);
	var url="InterruptionView?id="+id;
    var width = 1100;
    var height = 700;
    var left = parseInt((screen.availWidth/2) - (width/2));
    var top = parseInt((screen.availHeight/2) - (height/2));
    var windowFeatures = "width=" + width + ",height=" + height + 
    ",status,resizable,left=" + left + ",top=" + top +
    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
           
}


function openPopupSubmit(id)
	{
	      
		//alert(id);
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
									<li class="active"><span>${submitType} Status</span></li>
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
									
										<table class="table table-responsive" id="tblProvinces">

											<thead>

											</thead>
											<tbody>
												<form:form method="post" action=""
													modelAttribute="model">
													<c:set var="myVar" value="${model.mode}" />
													
<div id="newst">
													<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for Request No.." title="Type in a name2">
  
  <script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("tblAdmin");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>
	<div id="dtable">												
                                                     
													   <table id="tblAdmin" class="table table-striped table-bordered table-condensed " style="width:25%">

														<thead>
														
														<c:choose>
																<c:when test="${submitType=='Inspection'}">
																<tr>
															<th class="th-sm" style = "background-color:DarkGrey">Inspection Request No</th>
															<th class="th-sm" style = "background-color:DarkGrey">Area</th>
															
															<th class="th-sm" style = "background-color:DarkGrey">Requirement</th>
															<th class="th-sm" style = "background-color:DarkGrey">Requesting section/s to be inspected</th>
															
															<th class="th-sm" style = "background-color:DarkGrey">Date </th>
															<th class="th-sm" style = "background-color:DarkGrey">Time</th>
																<th class="th-sm" style = "background-color:DarkGrey"></th>
																
															</tr>
														</c:when>
														<c:when test="${submitType=='Maintenance'}">
																<tr>
															<th class="text-center">Maintenance Request No</th>
															<th class="text-center">Area</th>
															<th class="text-center">Line Name</th>
															
															<th class="text-center">Requirement</th>
															
															<th class="text-center">Date </th>
															<th class="text-center">Time</th>
																<th></th>
																
															</tr>
														</c:when>
														<c:when test="${submitType=='Interruption'}">
																<tr>
																
															<th class="th-sm" style = "background-color:DarkGrey">Request No</th>
															<th class="th-sm" style = "background-color:DarkGrey">Area</th>
															<th class="th-sm" style = "background-color:DarkGrey">Created Date & Time </th>
															<th class="th-sm" style = "background-color:DarkGrey">Section to be interrupted</th>
														    <th class="th-sm" style = "background-color:DarkGrey">Time Duration</th>
															<th class="th-sm" style = "background-color:DarkGrey">Field Work</th>
															<th class="th-sm" style = "background-color:DarkGrey">Forward To</th>
															<th class="th-sm" style = "background-color:DarkGrey">Forward Request</th>
															<th class="th-sm" style = "background-color:DarkGrey">Discard Request</th>
															<th class="th-sm" style = "background-color:DarkGrey">Network View</th>
															<th class="th-sm" style = "background-color:DarkGrey">Request Letter</th>
															<th class="th-sm" style = "background-color:DarkGrey">Image</th>
															
															
																
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
																<td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.systemBy}</textarea></td>
																<td style="text-align:left"><textarea rows="3" cols="60" class="form-control" disabled>${email.req2}</textarea></td>
																<td style="text-align:center"><input style="text-align:center" type="date" id="" value="${email.approvedDate}" class="form-control" disabled></td>
																<td style="text-align:center"><input style="text-align:center" type="time" id="" value="${email.approvedTime}" class="form-control" disabled></td>
																<td><button type='button' class='btn btn-warning' onclick="window.location.href='downloadInterruptionReq?id=${email.approvalId}'">Letter</button></td>
																
</tr>
</c:when>
<c:when test="${submitType=='Interruption'}">
														
																<tr>
																
																<td>${email.approvalId}</td>
																<td>${email.referenceNo}</td>
																<td>${email.approvedDate} ${email.approvedTime}</td>
																<td>${email.fromto}</td>
																<td>${email.timeduration}</td>
															
														        <td>${email.req2}</td>
																<td style="text-align:left"> <select id="forwaded_${email.approvalId}" style="background-color: #94cb71; border-radius: 5px;">
																	      <option value="1">Area Engineer</option>
                                                                          <option value="2">Planning CE</option>
                                                                          <option value="3">Control Center</option>
                                                                                      
																	 </select></td>
																	 <c:if test="${sessionScope.loggedUserRole =='EE'}">
																<td><button type='button' class='btn'
																			title='Forward' onClick='forwardRequest("${email.approvalId}")'><i class="glyphicon glyphicon-share-alt"></i></button></td>
																			<td><button type='button' class='btn'
																			title='Remove' onClick='removeRequest("${email.approvalId}")'><i class="glyphicon glyphicon-remove"></i></button></td>
																
																 <td><button type='button' class='btn' title='Network View' onclick='loadNetwork("${email.approvalId}")'><i class="glyphicon glyphicon-globe"></i></button></td>
																 
																<%--  <td><button type='button' class='btn' title='Network View' onclick='netWorkNew("${email.approvalId}")'><i class="glyphicon glyphicon-globe"></i></button></td>
																 --%> 
																<td><button type='button' class='btn' title='Letter View' onClick='openPopupSubmit("${email.approvalId}")'><i class="glyphicon glyphicon-envelope"></i></button></td>
																
  																	<c:if test="${email.filename1 != null}">
  																	<td><button type='button' class='btn' title='Image' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'"><i class="glyphicon glyphicon-picture"></i></button></td>
																</c:if>
																
																<c:if test="${email.filename2 != null}">
  																	<button type='button' class='btn' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'"><i class="glyphicon glyphicon-picture"></i></button>
																</c:if>
																<c:if test="${email.filename3 != null}">
  																	<button type='button' class='btn' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'"><i class="glyphicon glyphicon-picture"></i></button>
																</c:if>
																<c:if test="${email.filename4 != null}">
  																	<button type='button' class='btn' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'"><i class="glyphicon glyphicon-picture"></i></button>
																</c:if>
																<c:if test="${email.filename5 != null}">
  																	<button type='button' class='btn' onclick="window.location.href='downloadIntImgReq?id=${email.filename1}&seq=1'"><i class="glyphicon glyphicon-picture"></i></button>
																</c:if>
																
																
																
																</c:if>
																
																<%-- <td><button type='button' class='btn btn-success' onclick="window.location.href='downloadInterruptionReq?id=${email.approvalId}'">Letter</button></td>
																<td><button type='button' class='btn btn-warning' onclick="window.location.href='downloadInterruptionReq?id=${email.approvalId}'">I-1</button></td>
																
																<c:if test="${sessionScope.loggedUserRole =='EE'}">
																<td><button type='button' class='btn btn-warning'
																			onClick='forwardRequest("${email.approvalId}")'>Forward Request</button></td>
																			<td><button type='button' class='btn btn-success'
																			onClick='removeRequest("${email.approvalId}")'>Remove Request</button></td>
																
																<td><button type='button' class='btn btn-warning'
																			onClick='openPopupSubmitImg1("${email.approvalId}")'>IMG-1</button></td>
																<td><button type='button' class='btn btn-warning'
																			onClick='openPopupSubmitImg2("${email.approvalId}")'>IMG-2</button></td>
																<td><button type='button' class='btn btn-warning'
																			onClick='openPopupSubmitImg3("${email.approvalId}")'>IMG-3</button></td>
																			<td><button type='button' class='btn btn-warning'
																			onClick='openPopupSubmitImg4("${email.approvalId}")'>IMG-4</button></td>
																			<td><button type='button' class='btn btn-warning'
																			onClick='openPopupSubmitImg5("${email.approvalId}")'>IMG-5</button></td>
																			
																			<input style="text-align:center" type="hidden" id="area_${email.approvalId}" value="${email.areaCode}"  class="form-control" disabled>
																            <input style="text-align:center" type="hidden" id="lineid_${email.approvalId}" value="${email.lineid}"  class="form-control" disabled>
																
																
																
																	
												</c:if> --%>
</tr>
</c:when>

</c:choose></c:forEach>
 </tbody>
 </table>
  <div id="map_container"></div>
  
 </div>
</div>
 												</form:form>

											</tbody>
										</table>

									</div>

								</div>
								</div>
							</div>
						</div>
					</div>
				
				
					
					 
					<!-- <div class="col-sm-12" align="left">

									<div class="row">

										<div id="map_container"></div>

									</div>
									
					</div>
 --> 					
					
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