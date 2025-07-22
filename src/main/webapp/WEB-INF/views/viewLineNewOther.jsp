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
<%@ include file="sections/head.jsp"%>

<script type="text/javascript">
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
	function getAreas()
	{			
			 $.ajax
             ({
                     type: 'GET',
                     url: '/MMS/findAllAreaNew/',
                     data: {},
                     contentType: "application/json; charset=utf-8",
                     success: function(response) 
                     {
                    	 //alert(response);
                    	 $('#cmbSelectArea').empty();
                         //Append "None" item
                         $('#cmbSelectArea').append($('<option>').text("<< Select Area >>").attr('value', ""));

                         //Insert item from the response
                         for (var i = 0; i < response.length; i++) {
                             var item = response[i];
                             $('#cmbSelectArea').append($('<option>').text(item.deptNm).attr('value', item.deptId));
                         }
                     }
              });		
	}

	
	function LoadProvincesToEdit(pid)
	{
		//if(document.getElementById("pstatus_"+pid).value == 0 || document.getElementById("pstatus_"+pid).value == 1 || document.getElementById("pstatus_"+pid).value == 4){
			//alert("This item is sent for approving or active item or inactive item. You cann't edit this");
		//}
		//else{
			enable(pid);
		//}
	}
	
    function disable(pid)
    {
        document.getElementById("pcode_"+pid).disabled = true;
        document.getElementById("pname_"+pid).disabled = true;
        document.getElementById("ptype_"+pid).disabled = true;
        document.getElementById("plegnth_"+pid).disabled = true;
        document.getElementById("parea_"+pid).disabled = true;
        document.getElementById("ppoles_"+pid).disabled = true;
        document.getElementById("ptowers_"+pid).disabled = true;
        document.getElementById("pcomdate_"+pid).disabled = true;
		document.getElementById("pstatus_"+pid).disabled = true;
    }
    function enable(pid)
    {
    	document.getElementById("pcode_"+pid).disabled = false;
        document.getElementById("pname_"+pid).disabled = false;
        document.getElementById("ptype_"+pid).disabled = false;
        document.getElementById("plegnth_"+pid).disabled = false;
        document.getElementById("parea_"+pid).disabled = false;
        document.getElementById("ppoles_"+pid).disabled = false;
        document.getElementById("ptowers_"+pid).disabled = false;
        document.getElementById("pcomdate_"+pid).disabled = false;
		document.getElementById("pstatus_"+pid).disabled = false;
    }
    
   function save(pid) 
    {
     //  alert('hiiiii');
	   var pcode = document.getElementById("pcode_"+pid).value;
	//   alert('hiiiii	1' +pcode);
	   var pname = document.getElementById("pname_"+pid).value;
	//   alert('hiiiii	2'+pname);
	   var ptype = document.getElementById("ptype_"+pid).value;
	//   alert('hiiiii	3'+ptype);
	   var plegnth = document.getElementById("plegnth_"+pid).value;
	//   alert('hiiiii	4'+plegnth);
	   var parea = document.getElementById("parea_"+pid).value;
	//   alert('hiiiii	5' +parea);
	   var ppoles = document.getElementById("ppoles_"+pid).value;
	 //  alert('hiiiii	6' +ppoles);
	   var ptowers = document.getElementById("ptowers_"+pid).value;
	//   alert('hiiiii	7' +ptowers);
	   var pcomdate = document.getElementById("pcomdate_"+pid).value;
	//   alert('hiiiii	8' +pcomdate);
	   var pstatus = document.getElementById("pstatus_"+pid).value;
	//   alert('hiiiii	9' +pstatus);
	//   alert('hiiiii');
	   var url = "/MMS/updateLine/"+pid+"/"+pcode+"/"+pname+"/"+ptype+"/"+plegnth+"/"+parea+"/"+ppoles+"/"+ptowers+"/"+pcomdate+"/"+pstatus+"/";

 	  // alert('hiiiii' +url);
	   
        $.ajax({
        	type: "GET",
            url : url,
            success : function(response) {
                alert("Line updated succesfully...");
                console.log(response);
                window.location.reload();
                disable(pid);
            }
        });

		
	}

   function sendForValidation()
   {
      
		//var province = $( '#province' ).find( ":selected" ).attr( "value" );	
       var area = $( '#area' ).find( ":selected" ).attr( "value" );
		//var line = $( '#line' ).find( ":selected" ).attr( "value" );
		
		//alert("province: " + province + ",  area: " + area + "  ,line: " + line);
		
       var url = "/MMS/updateLineStatusNew/"+ area +"/";
		alert(url);
		//alert("province: " + province + ",  area: " + area + "  ,line: " + line);
       $.ajax( {
           type: "GET",
           url: url,
           success: function ( response )
           {
               alert( "Succesfully approved..." );
               console.log( response );
               window.location.reload();
               //disable( id );
           }
       } );
   }

	
</script>
</head>
<body>
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
									<li class="active"><span>View Line </span></li>
								</ol>
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="main-box clearfix">
								<header class="main-box-header clearfix">
																	</header>

								<div class="main-box-body clearfix">
									<div class="table-responsive">
										<table class="table table-responsive" id="tblProvinces">

											<thead>

											</thead>
											<tbody>
												<form:form method="post" action="viewLineNewSOther"
													modelAttribute="model">
													<table class="table table-responsive" id="tblProvinces">

														<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">PROVINCE</form:label></td>
															<td width="50%" style="text-align: left"><form:select
																	id="province" path="glcompmobj.compId"
																	onchange="findArea()"
																	style="width:50%; background-color: #8187ff; border-radius: 5px;">
																	<form:options items="${model.provinceList}" />
																</form:select></td>

														</tr>
														<tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">AREA</form:label></td>
															<td width="50%" style="text-align: left"><form:select
																	id="area" path="gldeptobj.deptId" onchange="getLine()" style="width:50%; background-color: #94cb71; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.areaList}" />
																</form:select></td>

														</tr>
														<%-- <tr>
															<td width="30%" style="text-align: left"><form:label
																	path="">LINE</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="line" path="line.code" onchange="">

																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.lineList}" />
																</form:select></td>
														</tr> --%>
														<tr>
															<td style="text-align: left"><a
																href=""> <input
																	class="btn btn-info" type="submit"
																	name="actionButton" value="GO"></input></a></td>
														
														
														</tr>
													</table>
													<div id="table-scroll" class="table-scroll"> 
                                                        <table class="main-table" id="tblAdmin">

                                                    <thead>
														<tr>
                                                             <th class="text-center">Code</th>
															
                                                             <th class="text-center">ID</th>                                                         
															<th class="text-center">Line Name</th>
															<th class="text-center">Line Type</th>
															<th class="text-center">Length</th>
															<th class="text-center">Area</th>
															<th class="text-center">No of Poles</th>
															<th class="text-center">No of Towers</th>
															<th class="text-center">COM Date</th>
															<th class="text-center">Status</th>
															<th class="text-center"></th>
                                                            <th class="text-center"></th>
															
														</tr>
													</thead>
													<tbody>
											           <c:forEach var="line" items="${model.lineListEdit}" >
						  <tr>  
											                
											                 <th><input type="text" id="pcode_${line.id}" value="${line.code}" class="form-control" disabled></th>
											                
											                <td><input type="text" id="pid" value="${line.id}" class="form-control" disabled></td>
											                
											                 <td><input type="text" id="pname_${line.id}" value="${line.lineName}" class="form-control" disabled></td>
											                 <%-- <td><select id="ptype_${line.id}" class="form-control" disabled>
											                 <c:choose>
											                		<c:when test="${line.lineType==1}">
											                			<option value="${line.lineType}" selected="selected">Backbone</option>
											                			<option value="2">Distributor</option>
											                		</c:when>
											                		<c:otherwise>
											                			<option value="${line.lineType}" selected="selected">Distributor</option>
											                			<option value="1">Backbone</option>
											                			
											                		</c:otherwise>
											                	
											                	</c:choose>	
											                </select ></td>  --%>
											                
											                <td><select id="ptype_${line.id}"
																		class="form-control" disabled>

																			<c:forEach var="linetype" items="${model.linetype}">

																				<c:choose>
																					<c:when
																						test="${linetype.id != line.lineType}">
																						<option value="${linetype.id}">${linetype.lineType}</option>
																					</c:when>
																				</c:choose>

																			</c:forEach>

																			<c:forEach var="linetype" items="${model.linetype}">
																				<c:choose>
																					<c:when
																						test="${linetype.id == line.lineType}">
																						<option value="${linetype.id}" selected="selected">${linetype.lineType}</option>
																					</c:when>
																				</c:choose>
																			</c:forEach>
																	</select></td>
											
											                  <td><input type="text" id="plegnth_${line.id}" value="${line.length}" class="form-control" disabled></td>
											                 <td><input type="text" id="parea_${line.id}" value="${line.area}" class="form-control" disabled></td>
											                 <td><input type="text" id="ppoles_${line.id}" value="${line.noofpoles}" class="form-control" disabled></td>
											                  <td><input type="text" id="ptowers_${line.id}" value="${line.nooftowers}" class="form-control" disabled></td>
											                 <td><input type="text" id="pcomdate_${line.id}" value="${line.comdate }" class="form-control" disabled></td>
											                 
											                 <td><select id="pstatus_${line.id}" class="form-control" disabled>
											                	 <c:choose>
                                                                                    <c:when test="${line.status==2}">
                                                                                        <option value="${line.status}"
                                                                                            selected="selected">In Bulk</option>
                                                                                             <option value="3">Send for Validation</option>
                                                                                             <option value="0">Inactive</option>
                                                                                    </c:when>

                                                                                    <c:when test="${line.status==1}">
                                                                                        <option value="${line.status}"
                                                                                            selected="selected">Approve</option>
                                                                                             <option value="4">Send for Approval</option>
                                                                                    		<option value="0">Inactive</option>
                                                                                    </c:when>

                                                                                    <c:when test="${line.status==0}">
                                                                                          <option value="${line.status}"
                                                                                            selected="selected">Inactive</option>
                                                                                            <option value="0">Inactive</option>
                                                                                             <option value="2">Keep In Bulk</option>
                                                                                    </c:when>
                                                                                    <c:when test="${line.status==3}">
                                                                                          <option value="${line.status}"
                                                                                            selected="selected">Pending Approval - ES</option>
                                                                                            <option value="0">Inactive</option>
                                                                                             <option value="2">Keep In Bulk</option>
                                                                                    </c:when>
                                                                                    <c:when test="${line.status==4}">
                                                                                          <option value="${line.status}"
                                                                                            selected="selected">Pending Approval - EE</option>
                                                                                            <option value="0">Inactive</option>
                                                                                             <option value="2">Keep In Bulk</option>
                                                                                    </c:when>


                                                                                    <c:otherwise>
                                                                                        <option value="${line.status}"
                                                                                            selected="selected">Not Allowed</option>
                                                                                      
                                                                                    </c:otherwise>


                                                                                </c:choose>
                                                                                

											                </select ></td> 
											                
											                
											                <td><select id="n14_${line.id}" class="form-control" disabled>
											                			<option value="" selected="selected"></option>
											                			<option value="ES1COMWPS2">ES1COMWPS2</option>
											                			<option value="ESPHM1">ESPHM1</option>
											                	</select>
											                </td> 
											                
											                 
											              <%--   <td><button type='button' class='btn btn-warning' onClick='LoadProvincesToEdit("${line.id}")'>Edit</button></td>
											                <td><button type='button' class='btn btn-success' onClick='javascript:save("${line.id}")'>Save</button></td>      
											                 --%></tr>
											                
											            </c:forEach>
													</tbody>
												</table>
												</div>
													                          <tr>

                                                            <td colspan="2">
                                                                <c:if test="${userType =='DEO'}">

                                                                </c:if> <input type="hidden" name="actionButton" value="" />
                                                                <%-- <c:choose>
                                                                    <c:when test="${sessionScope.loggedUserRole=='DEO'}">
                                                                        <input id="pivFormBtn" class="btn btn-success"
                                                                            type="submit" name="actionButton" value="Send For Validation" onclick="sendForValidation()"></input>

                                                                    </c:when>
                                                                    <c:when test="${sessionScope.loggedUserRole=='EE'}">
                                                                        <input id="pivFormBtn" class="btn btn-success"
                                                                            type="submit" name="actionButton" value="Approve" onclick="sendForValidation()"></input>

                                                                    </c:when>
                                                                    <c:when test="${sessionScope.loggedUserRole=='ES'}">
                                                                        <input id="pivFormBtn" class="btn btn-success"
                                                                            type="submit" name="actionButton" value="Send For Approval" onclick="sendForValidation()"></input>

                                                                    </c:when>
                                                                    <c:otherwise>

                                                                    </c:otherwise>
                                                                </c:choose> --%>
                                                            </td>
                                                        </tr>
													
													
                                                       
													
													
												</form:form>

											</tbody>
										</table>
										
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