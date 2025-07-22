<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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







</style>

<html>

<head>
<!-- meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"-->
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>MV-MMS</title>
<%@ include file="sections/headEdit.jsp"%>

<style type="text/css">
.form-control {
	display: inline-block;
	width: -webkit-fill-available;
	height: 34px;
	font-size: 12px;
	color: #0f1893;
	border-color: #095f9f;
	background-color: #fff;
	font-weight: 800;
	border-radius: 4px;
}
</style>

<script type="text/javascript">
	//edit anushka 2019-01-02-------------------------------------------------------------------------------------------------------------
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
		document.getElementById("j10_" + pid).disabled = true;
		document.getElementById("k11_" + pid).disabled = true;
		document.getElementById("t12_" + pid).disabled = true;

		document.getElementById("c3_" + pid).disabled = true;
		document.getElementById("d4_" + pid).disabled = true;
		document.getElementById("e5_" + pid).disabled = true;
		document.getElementById("f6_" + pid).disabled = true;
		document.getElementById("g7_" + pid).disabled = true;
		document.getElementById("h8_" + pid).disabled = true;
		document.getElementById("i9_" + pid).disabled = true;
		document.getElementById("l12_" + pid).disabled = true;
		document.getElementById("m13_" + pid).disabled = true;
		//               document.getElementById( "t11_" + pid ).disabled = true;
		document.getElementById("pstatus_" + pid).disabled = true;
		document.getElementById("n14_" + pid).disabled = true;
		document.getElementById("m30_" + pid).disabled = true;
		document.getElementById( "res_" + pid ).disabled = true;
        document.getElementById( "fromsection_" + pid ).disabled = true;
        document.getElementById( "tosection_" + pid ).disabled = true;


		arrayDataToSave = [];
	}
	//------------------------------------------------------------------------------------------------------------------------------------

	function enable(pid) {
		document.getElementById("a1_" + pid).disabled = false;
		document.getElementById("j10_" + pid).disabled = false;
		document.getElementById("k11_" + pid).disabled = false;
		document.getElementById("t12_" + pid).disabled = false;

		document.getElementById("c3_" + pid).disabled = false;
		document.getElementById("d4_" + pid).disabled = false;
		document.getElementById("e5_" + pid).disabled = false;
		document.getElementById("f6_" + pid).disabled = false;
		document.getElementById("g7_" + pid).disabled = false;
		document.getElementById("h8_" + pid).disabled = false;
		document.getElementById("i9_" + pid).disabled = false;
		document.getElementById("l12_" + pid).disabled = false;
		document.getElementById("m13_" + pid).disabled = false;
		//                document.getElementById( "t11_" + pid ).disabled = false;
		document.getElementById("t12_" + pid).disabled = false;

		document.getElementById("pstatus_" + pid).disabled = false;
		document.getElementById("n14_" + pid).disabled = false;
		document.getElementById("m30_" + pid).disabled = false;
		document.getElementById( "res_" + pid ).disabled = false;
        document.getElementById( "fromsection_" + pid ).disabled = false;
        document.getElementById( "tosection_" + pid ).disabled = false;


	}

	//edit anushka 2019-01-02------------------------------------------------------------------------------------------------------------------------
	function saveAll() {
		var len = arrayDataToSave.length

		for (var count = 0; count < len; count++) {
			var pid = arrayDataToSave[count];

			var a = document.getElementById("a1_" + pid).value;
			var j = document.getElementById("j10_" + pid).value;
			var k = document.getElementById("k11_" + pid).value;
			var x = document.getElementById("t12_" + pid).value;
			var c = document.getElementById("c3_" + pid).value;
			c = c.replace(/\//g,'-');

			var d = document.getElementById("d4_" + pid).value;
			var e = document.getElementById("e5_" + pid).value;
			var f = document.getElementById("f6_" + pid).value;
			var g = document.getElementById("g7_" + pid).value;
			var h = document.getElementById("h8_" + pid).value;
			var i = document.getElementById("i9_" + pid).value;
			var l = document.getElementById("l12_" + pid).value;
			var m = document.getElementById("m13_" + pid).value;
			var t = document.getElementById("m30_" + pid).value;
			
			//alert(t);
			var status = document.getElementById("pstatus_" + pid).value;
			var resArea = document.getElementById( "res_" + pid ).value;
            var fromSec = document.getElementById( "fromsection_" + pid ).value;
            var toSec = document.getElementById( "tosection_" + pid ).value;
    
			var n = 'PHMR2ES1';
			/* var url = "/MMS/updateSupport/" + c + "/"+ a + "/" + pid + "/" + d + "/" + e
					+ "/" + f + "/" + g + "/" + h + "/" + i + "/" + j + "/" + k
					+ "/" + l + "/" + m + "/" + "0" + "/" + x + "/" + status
					+ "/" + n + "/" + resArea + "/" + fromSec + "/" + toSec;
			//alert(url);
 */
 /* @RequestMapping(value = "/updateSupportNew",method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void updateSupportNew(@RequestParam("c") String towerNo,@RequestParam("a") String sType,@RequestParam("id") String id,
			@RequestParam("d") String area,@RequestParam("e") String csc,@RequestParam("f") String cType,@RequestParam("g") String ecType,
			@RequestParam("h") String tType,@RequestParam("i") String tConfig,@RequestParam("j") String gpsLat,@RequestParam("k") String gpsLon,
			@RequestParam("l") String nofCir,@RequestParam("m") String bExten,@RequestParam("t") String tapping,@RequestParam("x") String mapId,
			@RequestParam("status") String status,@RequestParam("n") String appLevel,
			@RequestParam("res") String res,@RequestParam("from") String from,@RequestParam("to") String to) {
 */	
	 var url = "/MMS/updateSupportNew?c=" + c + "&a="+ a + "&id=" + pid + "&d=" + d + "&e=" + e
		+ "&f=" + f + "&g=" + g + "&h=" + h + "&i=" + i + "&j=" + j + "&k=" + k
		+ "&l=" + l + "&m=" + m + "&t=" + t + "&x=" + x + "&status=" + status
		+ "&n=" + n + "&res=" + resArea + "&from=" + fromSec + "&to=" + toSec;
	 
 
 
 /* var url = "/MMS/updateSupportNew?c=" +c+ "&id=" +pid+ "&mapId=" +x+ "&suptype=" +a+ "&gpslat=" +j+
 "&gpslon=" +k+ "&area=" +d+ "&csc=" +e+ "&ctype=" +f+ 
"&ectype=" +g+ "&towertype=" +h+ "&tconfig=" +i+ "&circuits=" +l+             
"&bextension=" +m+ "&tapping=" +tapping+ "&status=" +status+              
"&aplevel=" +n+ "&resarea=" +resArea+ "&secfrom=" +fromSec+ "&secto=" +toSec;

 */			$.ajax({
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
	//-----------------------------------------------------------------------------------------------------------------------------------------------

	function save(pid) {
		//alert("called");
		var a = document.getElementById("a1_" + pid).value;
		var j = document.getElementById("j10_" + pid).value;
		var k = document.getElementById("k11_" + pid).value;
		var x = document.getElementById("t12_" + pid).value;
		var c = document.getElementById("c3_" + pid).value;
		c = c.replace(/\//g,'-');

		var d = document.getElementById("d4_" + pid).value;
		var e = document.getElementById("e5_" + pid).value;
		var f = document.getElementById("f6_" + pid).value;
		var g = document.getElementById("g7_" + pid).value;
		var h = document.getElementById("h8_" + pid).value;
		var i = document.getElementById("i9_" + pid).value;
		var l = document.getElementById("l12_" + pid).value;
		var m = document.getElementById("m13_" + pid).value;
		var t = document.getElementById("m30_" + pid).value;
		//alert(t);
		
		//                var t = document.getElementById( "t11_" + pid ).value;
		// 

		var status = document.getElementById("pstatus_" + pid).value;
		// var n = document.getElementById("n14_"+pid).value;
		var resArea = document.getElementById( "res_" + pid ).value;
                var fromSec = document.getElementById( "fromsection_" + pid ).value;
                var toSec = document.getElementById( "tosection_" + pid ).value;
               
		var n = 'PHMR2ES1';
		// alert( "sType: " + a + " / id: " + pid + " / area: " + d + " / csc: " + e + " / cType: " + f + " / ecType: " + g + " / tType: " + h + " / tConfig: " + i + " / gpsLat: " + j + " / gpsLon: " + k + " / nofCir: " + l + " / bExten: " + m + " / tapping: " + t + " / mapId: " + x + " / status: " + status + " / appLevel: " + n );
		//alert( "sType: " + a + " / id: " + pid + " / area: " + d + " / csc: " + e + " / cType: " + f + " / ecType: " + g + " / tType: " + h + " / tConfig: " + i + " / gpsLat: " + j + " / gpsLon: " + k + " / nofCir: " + l + " / bExten: " + m + " / mapId: " + x + " / status: " + status + " / appLevel: " + n );
		//alert(url);
		/* var url = "/MMS/updateSupport/" + c + "/"+ a + "/" + pid + "/" + d + "/" + e
					+ "/" + f + "/" + g + "/" + h + "/" + i + "/" + j + "/" + k
					+ "/" + l + "/" + m + "/" + "0" + "/" + x + "/" + status
					+ "/" + n + "/" + resArea + "/" + fromSec + "/" + toSec;
 */
/*  var url = "/MMS/updateSupportNew?towerno=" +c+ "&id=" +pid+ "&mapId=" +x+ "&suptype=" +a+ "&gpslat=" +j+
 "&gpslon=" +k+ "&area=" +d+ "&csc=" +e+ "&ctype=" +f+ 
"&ectype=" +g+ "&towertype=" +h+ "&tconfig=" +i+ "&circuits=" +l+             
"&bextension=" +m+ "&tapping=" +tapping+ "&status=" +status+              
"&aplevel=" +n+ "&resarea=" +resArea+ "&secfrom=" +fromSec+ "&secto=" +toSec;
 */
		//alert(url);
 
 var url = "/MMS/updateSupportNew?c=" + c + "&a="+ a + "&id=" + pid + "&d=" + d + "&e=" + e
	+ "&f=" + f + "&g=" + g + "&h=" + h + "&i=" + i + "&j=" + j + "&k=" + k
	+ "&l=" + l + "&m=" + m + "&t=" + t + "&x=" + x + "&status=" + status
	+ "&n=" + n + "&res=" + resArea + "&from=" + fromSec + "&to=" + toSec;

 alert(url);
		/*    alert(a);
		   alert(b);
		   alert(c);
		   alert(d);
		   alert(e);
		   alert(f);
		   alert(g);
		   alert(h);
		   alert(i);
		   alert(j);
		   alert(k);
		   alert(l);
		   alert(m);
		   alert(n);
		   alert(pid);
		   alert(status); */

		//var url = "/MMS/updateSupport/" + x + "/" + pid + "/" + j + "/" + k + "/" + a + "/" + d + "/" + e + "/" + f + "/" + g + "/" + h + "/" + i + "/" + l + "/" + m + "/" + status + "/" + n;
		//var url = "/MMS/updateSupport/" + x + "/" + pid + "/" + j + "/" + k + "/" + a + "/" + d + "/" + e + "/" + f + "/" + g + "/" + h + "/" + i + "/" + l + "/" + m + "/" + t + "/" + status + "/" + n;
		//var url = "/MMS/MapIdUpdate/" + x + "/" + pid + "/" + j + "/" + k + "/" + a + "/" + d;
		// alert(url);
		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				alert("Support updated succesfully... " + response);
				console.log(response);
				window.location.reload();
				disable(pid);
			}
		});

	}

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
									+ "<option value='" + data[ i ].deptId + "'>"
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
						var slctSubcat = $('#line'), option = "<option value='-1'>ALL</option>";
						slctSubcat.empty();
						for (var i = 0; i < data.length; i++) {
							option = option
									+ "<option value='" + data[ i ].id + "'>"
									+ data[i].lineName + "</option>";
						}
						slctSubcat.append(option);

						//alert("response.towerNo" + data);	
					}
				});
	}
	
	function getSupport() {
		//var categoryId = $(this).val();
		//alert("hiii");
		var strUser = area.options[area.selectedIndex].value;
		var strLine = line.options[line.selectedIndex].value;
		
		//alert("hiiittt : "+strUser);
		//findAllAreaByProvinceNew

		$
				.ajax({
					type : 'GET',
					url : "/MMS/findSupportByArea/" + strUser + "/" + strLine,
					data : {},
					contentType : "application/json; charset=utf-8",
					success : function(data) {
						var slctSubcat = $('#support'), option = "<option value='-1'>ALL</option>";
						slctSubcat.empty();
						for (var i = 0; i < data.length; i++) {
							option = option
									+ "<option value='" + data[ i ].id + "'>"
									+ data[i].towerNo + "</option>";
						}
						slctSubcat.append(option);

						//alert("response.towerNo" + data);	
					}
				});
	}



	function sendForValidation() {

		var province = $('#province').find(":selected").attr("value");
		var area = $('#area').find(":selected").attr("value");
		var line = $('#line').find(":selected").attr("value");

		//alert("province: " + province + ",  area: " + area + "  ,line: " + line);

		var url = "/MMS/updateSupportStatus/" + province + "/" + area + "/"
				+ line;

		//alert("province: " + province + ",  area: " + area + "  ,line: " + line);
		$.ajax({
			type : "GET",
			url : url,
			success : function(response) {
				alert("Succesfully approved...");
				console.log(response);
				window.location.reload();
				//disable( id );
			}
		});
	}
	
	
	/* function viewImage()
	{
		
		getImage();
	
		/* var id = $('#support').find(":selected").attr("value");

		alert(id);
		var url="viewSupportImage?id="+id;
		
		var width = 1100;
	    var height = 700;
	    var left = parseInt((screen.availWidth/2) - (width/2));
	    var top = parseInt((screen.availHeight/2) - (height/2));
	    var windowFeatures = "width=" + width + ",height=" + height + 
	    ",status,resizable,left=" + left + ",top=" + top +
	    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
	    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
 */	           
	
 
	function getImage(){
		var id = $('#support').find(":selected").attr("value");
		var conceptCycleValue = $('#cycle').find(":selected").attr("value");
		var name = conceptCycleValue+'-'+id;
		
		//alert(name);
		//function show_image(src, width, height, alt) {
		    var img = document.getElementById("y");
		    img.src = 'viewSupportImage?id='+id +'&cycle='+conceptCycleValue;
		    img.width = 800;
		    img.height = 500;
		    img.alt = 'Support Image';
//alert(img.src);
		    // This next line will just add it to the <body> tag
		    //document.body.appendChild(img);
		//}
		
		    var div = document.getElementById("x");
		    
		    div.appendChild(img);
		
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
									<li class="active"><span>Edit Support </span></li>
								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="main-box clearfix">
								
								<div class="main-box-body clearfix">
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
								
								
									<div class="table-responsive">
										<table class="table table-responsive" id="tblProvinces">

											<thead>

											</thead>
											<tbody>
											
													
												<form:form method="post" enctype="multipart/form-data" action="uploadSupportImageS"
													modelAttribute="model">


													<!-- edited 1 anushka open 2018-11-30 -->
													<c:set var="userType"
														value="${sessionScope.loggedUserRole}" />
													<c:set var="supportid"
														value="${supportObj.id}" />
															
													<!-- edited 1 anushka close 2018-11-30 -->

														<tr>
															<td width="30%" style="text-align: left">Province</td>
															<td width="70%" style="text-align: left"><form:select
																	id="province" path="glcompmobj.compId"
																	onchange="findArea()"
																	style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.provinceList}" />
																</form:select></td>
														</tr>

														<tr>
															<td width="30%" style="text-align: left">Area</td>
															<td width="70%" style="text-align: left"><form:select
																	id="area" path="gldeptobj.deptId" onchange="getLine()"
																	style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.areaList}" />
																</form:select></td>
														</tr>

														<tr>
															<td width="30%" style="text-align: left">Line</td>
															<td width="70%" style="text-align: left"><form:select
																	id="line" path="line.id" onchange="getSupport()"
																	style="width:50%; background-color: #FFFFF; border-radius: 5px;">

																	<form:option value="-1" label="ALL" />
																	<form:options items="${model.lineList}" />
																</form:select></td>
														</tr>
														<tr>
															<td width="30%" style="text-align: left">Support</td>
															<td width="70%" style="text-align: left"><form:select
																	id="support" path="supportObj.id" onchange="getImage()"
																	style="width:50%; background-color: #FFFFF; border-radius: 5px;">

																	<form:option value="-1" label="ALL" />
																	<form:options items="${model.supportList}" />
																</form:select></td>
														</tr>
														<tr>
														
														<td width="30%" style="text-align: left">Cycle</td>
															<td width="70%" style="text-align: left"><form:select
																	id="cycle" path="cycleObj.id.cycleId" onchange="" style="width:50%; background-color: #FFFFF; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.cycleList}" />

																	
																</form:select></td>
														</tr>
														
														
<tr>
																<td width="30%" style="text-align:left">
                												File to upload
                												</td>
                												<td width="40%" style="text-align:left">
																<input  type="file" name="file1" id="file1"  onchange="show3()" class="form-control">
																</td>
																<td width="30%" style="text-align:left">
																	<span id="spnclosebtn3" style="display:none" class="fa fa-times-circle fa-lg closeBtn data-tooltip-position="bottom" title="remove" onclick="fileRemove3(); return false;">
																	</span>
																</td>
																    
        														</tr>
        														
														<tr>
															<td style="text-align: left"><input
																	class="btn btn-success" type="submit"
																	name="actionButton" value="Upload"></input></td>
																	<td style="text-align: left"><input
																	class="btn btn-success" type="button"
																	onclick="getImage()" value="View"></input></td>
														
														</tr>
														
													
												</form:form>

											</tbody>
										</table>
										<div id = "x" class="row">
					<img id ="y">
                    </div> 
										
									</div>
								</div>
							</div>
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
