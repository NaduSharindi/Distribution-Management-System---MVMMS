<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style type="text/css">


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

#header-fixed {
    position: fixed;
    top: 0px; display:none;
    background-color:white;
}

.table-scroll {
  position: relative;
  width:100%;
  z-index: 1;
  margin: auto;
  overflow: auto;
  height: 350px;
}

.dtHorizontalVerticalExampleWrapper {
max-width: 600px;
margin: 0 auto;
}
#dtHorizontalVerticalExample th, td {
white-space: nowrap;
}
table.dataTable thead .sorting:after,
table.dataTable thead .sorting:before,
table.dataTable thead .sorting_asc:after,
table.dataTable thead .sorting_asc:before,
table.dataTable thead .sorting_asc_disabled:after,
table.dataTable thead .sorting_asc_disabled:before,
table.dataTable thead .sorting_desc:after,
table.dataTable thead .sorting_desc:before,
table.dataTable thead .sorting_desc_disabled:after,
table.dataTable thead .sorting_desc_disabled:before {
bottom: .5em;
}


</style>
<html>
<head>


 <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 -->
 
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
  
 
 <!-- <script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
  --> 
<%-- <script src="<c:url value="/resources/js/jquery.min.js"/>"></script>

 <script src="<c:url value="/resources/js/jquery.dataTables.min.js"/>"></script>
 --%> 
 
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<%@ include file="sections/head.jsp"%>
<%@ include file="sections/dashboardCSS.jsp"%>


<script>
/* $(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
 */
$(document).ready(function () {
	$('#dtHorizontalVerticalExample').DataTable({
	"scrollX": true,
	"scrollY": 200,
	});
	$('.dataTables_length').addClass('bs-select');
	});

</script>




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
				//alert(response);

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
		//alert('hiiiii ' + len);
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

			//alert('hiiiii' +url);

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

	function sendForValidation() {

		//var province = $( '#province' ).find( ":selected" ).attr( "value" );	
		var area = $('#area').find(":selected").attr("value");
		//var line = $( '#line' ).find( ":selected" ).attr( "value" );

		//alert("province: " + province + ",  area: " + area + "  ,line: " + line);

		var url = "/MMS/updateLineStatusNew/" + area + "/";
		//alert(url);
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
		  
		  
		  
		  /* function openPopupSubmitImg1(id)
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
		             
		  } */

	}
	
function forwardRequest(id){
		
		//var strUser = userIdES.options[userIdES.selectedIndex].value;
		var strUser = document.getElementById("userIdES").value;
		//alert(strUser);
		//if(strUser != "NONE"){
			//var strUser = "60041ES1";
			//alert(id);
		 $.ajax({
			type : 'GET',
			url : "/MMS/sendRequestToES/" + id + "/"+ strUser + "/",
			data : {},
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				alert("Succesfully forwarded...");
				window.location.reload();
				
			}
		});
		 //}else{
			//alert("Please select the Electrical Superintendent");
			
		//}
	}
	
function generateEstimate(id){
	//var strUser = userId.options[userId.selectedIndex].value;
	//alert(strUser);
	$.ajax({
		type : 'GET',
		url : "/MMS/saveInspectionEstimate/"+id+"/",
		data : {},
		contentType : "application/json; charset=utf-8",
		success : function(data) {
			alert("Succesfully Generated..." + data);
			window.location.reload();
			
		}
	});
	
}

function openPopupSubmitImg1(id)
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

function removeRequest(id){
	
	//var strUser = userId.options[userId.selectedIndex].value;
	//if(strUser != "NONE"){
	//var pname = document.getElementById("forwaded_" + id).value;
	//alert(pname);
		var strUser = "60041ES1";
		//alert(id);
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
	//}else{
		//alert("Please select the Electrical Superintendent");
		
	//}
}




	
</script>
</head>
<body>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
	
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
									<li class="active"><span>${submitType}</span></li>
								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>
					
					<!-- <div class="container">
					 --><div class="row">
						<div class="col-lg-12">
					
					<div class="table-responsive">
					<form:form method="post" action="displayLineNewS" modelAttribute="model">
    
 
  <!-- <h2>Filterable Table</h2>
  <p>Type something in the input field to search the table for first names, last names or emails:</p>  
   <input class="form-control" id="myInput" type="text" placeholder="Search..">-->
   
  <br>
  <table id="dtHorizontalVerticalExample" class="table table-striped table-bordered table-sm " cellspacing="0"
  width="100%">
  <thead>
  <tr>
    <td><c:choose>
																<c:when test="${sessionScope.loggedUserRole=='EE'}">
														
															Electrical Superintendent
															 </c:when>
															<c:when test="${sessionScope.loggedUserRole=='ES'}">
														
															Applicant
															</c:when>
														
															</c:choose>
														</td>
    <td>
																  
																 <c:choose>
																<c:when test="${sessionScope.loggedUserRole=='EE'}">
														
																  <form:select id="userIdES" path=""  class="form-control">
																	    <form:options items="${model.saList}"/>
																	 </form:select>
																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='ES'}">
														
																  <form:select id="userId" path="" class="form-control" >
																	    <form:options items="${model.appList}"/>
																	 </form:select>
																</c:when>
														
																</c:choose>
																 
								                               </td>								
														</tr>
      
    </table>
  
  <table id="dtHorizontalVerticalExample" class="table table-striped table-bordered table-sm " cellspacing="0"
  width="100%">
    <thead>
    <tr>
        <th class="text-center">Request No</th>
															<th class="text-center">Requesting Branch</th>
															<th class="text-center">Line Name</th>
															
															<th class="text-center">Requirement</th>
															<c:if test="${type=='INS'}">
															
															<th class="text-center">Requesting section/s to be inspected</th>
															</c:if>
															<th class="text-center">Date & Time </th>
															<!-- <th class="text-center">Time</th>
															 -->
      </tr>
    </thead>
    <tbody>
    <c:forEach var="email" items="${model.unReadInspectionReq}">
																<tr>
																<td>${email.approvalId}</td>
																<td>${email.referenceNo}</td>
																<td>${email.esName}</td>
																<c:if test="${type=='INS'}">
															
																<td>${email.req1}</td>
																</c:if>
																<td>${email.req2}</td>
																<td>${email.approvedDate} ${email.approvedTime}</td>
																
																<%-- <td style="text-align:center"><input style="text-align:center" type="date" id="" value="${email.approvedDate}" class="form-control" disabled></td>
																<td style="text-align:center"><input style="text-align:center" type="time" id="" value="${email.approvedTime}" class="form-control" disabled></td>
																 --%>    
																  
																  
																  		   
																   
																		
																  
																  
																  
																  
																 <%-- <td ><button type='button' class='btn btn-warning'
																			onClick='viewMore("${email.approvalId}")'>Images</button></td>
																 --%> 	<td><button type='button' class='btn btn-success' onClick='openPopupSubmitImg1("${email.approvalId}")'>Letter</button></td>															
			<c:choose>
																<c:when test="${sessionScope.loggedUserRole=='EE'}">
																	
																			<td><button type='button' class='btn btn-success'
																			onClick='forwardRequest("${email.approvalId}")'>Forward</button></td>
																	        <td><button type='button' class='btn btn-success'
																			onClick='removeRequest("${email.approvalId}")'>Remove</button></td>
																	
																</c:when>
																<c:when test="${sessionScope.loggedUserRole=='ES'}">
																	
																			<td><button type='button' class='btn btn-success'
																			onClick='generateEstimate("${email.approvalId}")'>Generate Estimate</button></td>
																																	</c:when>
																<c:otherwise>

																</c:otherwise>
															</c:choose>
																			
																			
																			
																			
																			
																			
																															</tr>

																			</c:forEach>
    
												
      
    </tbody>
    <tfoot>
    <tr>
        <th class="text-center">Request No</th>
															<th class="text-center">Requesting Branch</th>
															<th class="text-center">Line Name</th>
															
															<th class="text-center">Requirement</th>
															<c:if test="${type=='INS'}">
															
															<th class="text-center">Requesting section/s to be inspected</th>
															</c:if>
															<th class="text-center">Date & Time </th>
															<!-- <th class="text-center">Time</th>
															 -->
      </tr>
    </tfoot>
    
  </table>
  </form:form>
	
  </div>
  </div>
  <!-- </div>
   -->
 <!--  <p>Note that we start the search in tbody, to prevent filtering the table headers.</p>
 --></div>
					


					


					<%@ include file="sections/footer.jsp"%>

				</div>
			</div>
		</div>
	</div>

	<%@ include file="sections/global_scripts.jsp"%>

</body>
</html>