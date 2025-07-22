<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@ include file="sections/head.jsp" %>
	
	<script type="text/javascript">
	
	function showLines()
			{
		var area = $('#cmbSelectArea').find(":selected").attr("value");
		 alert('area'+area);
      	 
					
					 $.ajax
		             ({
		                     type: 'GET',
		                     url: '/MMS/findLineByAreaStatus/' +area +'/3',
		                     data: {},
		                     contentType: "application/json; charset=utf-8",
		                     success: function(response) 
		                     {
		                    	 $("#tblAreas > tbody:last").children().remove();

		                    	 //Insert item from the response
		                         for (var i = 0; i < response.length; i++) {
		                             var item = response[i];
		                             var lineType;
		                             if(item.lineType == "1"){
		                            	 lineType = "Backbone";			                             
			                         }else if(item.lineType == "2"){
			                        	 lineType = "Distributor";
				                     }
		                             
		                             tr = $('<tr/>');
		                             
		                             	tr.append("<td> <input type=text id=code"+item.id+"  value="+item.code+" disabled ></input></td>");
		                             	tr.append("<td> <input type=text id=lineName"+item.id+"  value="+item.lineName+" disabled ></input></td>");
		                             	tr.append("<td> <input type=text id=lineType"+item.id+"  value="+item.lineType+" disabled ></input></td>");
		                              	tr.append("<td> <input type=text id=length"+item.id+"  value="+item.length+" disabled ></input></td>");
		                             	tr.append("<td> <input type=text id=area"+item.id+"  value="+item.area+" disabled ></input></td>");
		               					tr.append("<td> <input type=text id=noofpoles"+item.id+"  value="+item.noofpoles+" disabled ></input></td>");
		                           
		                            	tr.append("<td> <input type=text id=nooftowers"+item.id+"  value="+item.nooftowers+" disabled ></input></td>");
		                             	tr.append("<td> <input type=text id=comdate"+item.id+"  value="+item.comdate+" disabled ></input></td>");
		                             	//tr.append("<td> <input type=text id=status"+item.id+"  value="+item.status+" disabled ></input></td>");
		                                tr.append("<td> <select id=status"+item.id+" disabled >"
		                                		+"<option value="+item.status+" selected=selected>Pending</option>"
					                		    +"<option value='4' >Send for Approval</option>"
					                		    +"</select></td>");
		                                
		                              //  tr.append("<td>" + item.approvalLevel + "</td>");
		                                tr.append("<td><button type='button' class='btn btn-warning' onClick='enable("+item.id+")'>Edit</button></td>");
		                                tr.append("<td><button type='button' class='btn btn-success' onClick='save("+item.id+")'>Save</button></td>");
		                                
		                                //console.log(item);

		                                //Show "Edit" and "Delete" buttons
		                                //tr.append("<td>" + "<button type='button' class='btn btn-info' onClick='ConfirmActivate(" +item.id + ")'>Activate</button>" + "</td>");

		                                $('#tblAreas').append(tr);
		                         }
		                         
		                         $('#tblAreas').dataTable({
		                                'info': false,
		                                'pageLength': 10,
		                                retrieve: true
		                            });
		                     }
		              });
				
			} 
	
	
	function showlineHome()
	{
		alert('hiiii');
       	 $.ajax
             ({
                     type: 'GET',
                     url: "/MMS/findAllLineHome/",
                     data: {},
                     contentType: "application/json; charset=utf-8",
                     success: function(response) 
                     {
						//alert(response);
                         $("#tblAreas > tbody:last").children().remove();
                         //Insert item from the response
                         var count = 0;
                         countResponseData = response.length;
                         for (var i = 0; i < response.length; i++) {
                             var item = response[i];
                             count = count + 1;
                             alert(item);
                             tr = $('<tr/>');
                            	//tr.append("<td> <input type=text id=code"+item.id+"  value="+item.code+" disabled ></input></td>");
                                tr.append("<td>" + item.code + "</td>");
		                        tr.append("<td >" + item.lineName + "</td>"); 
		                        tr.append("<td>" + lineType + "</td>");
		                        tr.append("<td>" + item.length + "</td>");
		                        tr.append("<td>" + item.area + "</td>");
		                        tr.append("<td>" + item.noofpoles + "</td>");
		                        tr.append("<td>" + item.nooftowers + "</td>");
		                        tr.append("<td>" + item.comdate + "</td>");
		                        tr.append("<td><button type='button' class='btn btn-warning' onClick='enable("+item.id+")'>Edit</button>&nbsp;<button type='button'class='btn btn-success' onClick='save("+item.id+")'>Save</button></td>");
		                                
		                        tr.append("<td> <input type=text id=code"+item.id+"  value="+item.code+" disabled ></input></td>");
	                               
                                
                               /*  if(item[0].status==0){
                                    tr.append("<td><span class='label label-warning'>Pending</span></td>"); 
                                } else if(item[0].status==1){ 
                                    tr.append("<td><span class='label label-success'>Active</span></td>"); 
                              }
                            else if(item[0].status==2){ 
                              tr.append("<td><span class='label label-default'>In bulk</span></td>"); 
                             }
                              else if(item[0].status==3){ 
                               tr.append("<td><span class='label label-danger'>Rejected</span></td>"); 
                              }
                              else if(item[0].status==4){ 
                                 tr.append("<td><span class='label label-info'>Inactive</span></td>"); 
                              }
                                 */
								//tr.append("<td>" + item[0].approvalLevel + "</td>");
                                
                              // tr.append("<td><button type='button' class='btn btn-warning' onClick='enable("+item[0].id.id+")'>Edit</button>&nbsp;<button type='button' class='btn btn-success' onClick='save("+item[0].id.id+")'>Save</button></td>");
                                
                                
                                /* console.log(item);

                                Show "Edit" and "Delete" buttons
                                tr.append("<td>" + "<button type='button' class='btn btn-info' onClick='ConfirmActivate(" +item.id + ")'>Activate</button>" + "</td>");
*/
                                $('#tblAreas').append(tr); 
                         }

                     }
              });
		
	}

	function enable(id){
		alert(id);
		document.getElementById("code"+id).disabled = false;
		document.getElementById("lineName"+id).disabled = false;
		document.getElementById("lineType"+id).disabled = false;
		document.getElementById("length"+id).disabled = false;
		document.getElementById("area"+id).disabled = false;
		document.getElementById("noofpoles"+id).disabled = false;
		document.getElementById("nooftowers"+id).disabled = false;
		document.getElementById("comdate"+id).disabled = false;
		document.getElementById("status"+id).disabled = false;
	}


	function sendForValidation() 
    {
    
		var area = $('#cmbSelectArea').find(":selected").attr("value");
	    var url = "/MMS/updateLineStatuses/"+area+"/3";
         $.ajax({
        	type: "GET",
            url : url,
            success : function(response) {
                alert("Line sent for valication succesfully...");
                console.log(response);
                window.location.reload();
                disable(id);
            }
        });

		
	}

	
	function save(id) 
    {
      // alert('hiiiii');
       
	   var code = document.getElementById("code"+id).value;
	 //  alert('hiiiii	1' +code);
	   var lineName = document.getElementById("lineName"+id).value;
	 //  alert('hiiiii	2'+lineName);
	   var lineType = document.getElementById("lineType"+id).value;
	 //  alert('hiiiii	3'+lineType);
	   var length = document.getElementById("length"+id).value;
	//   alert('hiiiii	4'+length);
	   var area = document.getElementById("area"+id).value;
	//   alert('hiiiii	5' +area);
	   var noofpoles = document.getElementById("noofpoles"+id).value;
	//   alert('hiiiii	6' +noofpoles);
	   var nooftowers = document.getElementById("nooftowers"+id).value;
	 //  alert('hiiiii	7' +nooftowers);
	   var comdate = document.getElementById("comdate"+id).value;
	//   alert('hiiiii	8' +comdate);
	   var status = document.getElementById("status"+id).value;
	//   alert('hiiiii	9' +status);
	//   alert('hiiiii'); 
	   var url = "/MMS/updateLine/"+id+"/"+code+"/"+lineName+"/"+lineType+"/"+length+"/"+area+"/"+noofpoles+"/"+nooftowers+"/"+comdate+"/"+status+"/";

 	 //  alert('hiiiii' +url);
	   
        $.ajax({
        	type: "GET",
            url : url,
            success : function(response) {
                alert("Line updated succesfully...");
                console.log(response);
                //window.location.reload();
                disable(id);
            }
        });

		
	}
function disable(id){
		//alert(id);
		document.getElementById("code"+id).disabled = true;
		document.getElementById("lineName"+id).disabled = true;
		document.getElementById("lineType"+id).disabled = true;
		document.getElementById("length"+id).disabled = true;
		document.getElementById("area"+id).disabled = true;
		document.getElementById("noofpoles"+id).disabled = true;
		document.getElementById("nooftowers"+id).disabled = true;
		document.getElementById("comdate"+id).disabled = true;
		document.getElementById("status"+id).disabled = true;
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

	
		
	</script>

</head>
<body onload="getAreas();">
<div id="theme-wrapper">
	<%@ include file="sections/header.jsp" %>
	
		<div id="page-wrapper" class="container">
			<div class="row">
				<%@ include file="sections/userLevels.jsp" %>
				
				<div id="content-wrapper">
				
				<div class="row">
				<div class="col-lg-12">		                                    
                        <div class="col-lg-9">
                            <ol class="breadcrumb">
                                <li><a href="#">Home</a></li>
                                <li class="active"><span>Line</span></li>
                            </ol>
                        </div>
			                                    
						<%@ include file="sections/userDetails.jsp" %> 
					</div>
					</div>
					
					<div class="row">
								<div class="col-lg-12">
									<div class="main-box clearfix">
									
										
										<div class="main-box-body clearfix">
											<div class="table-responsive">
                                              <table class="table table-responsive" id="tblAreas">

                                                    <thead>
                                                   
															<!-- 	<tr>
                												<td width="30%" style="text-align:left">
                												Province
                												</td>
                												<td width="70%" style="text-align:left">
																<select class="form-control" id="cmbSelectProvince" name="cmbSelectProvince"  onchange="findArea">
										
											</select>
											<span id="spnSelectLine" class="label label-danger"></span></td>
																</tr>	-->
									<tr>
                												<td width="30%" style="text-align:left">
                												Area
                												</td>
                												<td width="70%" style="text-align:left">
																<select class="form-control" id="cmbSelectArea" name="cmbSelectArea"  onchange="showLines()">
										
											</select>
											<span id="spnSelectArea" class="label label-danger"></span></td>
																</tr>	
								<!-- 	<tr>
                												<td width="30%" style="text-align:left">
                												Line 
                												</td>
                												<td width="70%" style="text-align:left">
																<select class="form-control" id="cmbSelectLine" name="cmbSelectLine"  onchange="selectLineByArea()">
										
											</select>
											<span id="spnSelectLine" class="label label-danger"></span></td>
																</tr>	-->
																
									
									
														<tr>                                                             
															                                                        
															<th class="text-center">Code</th>
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
														
													</tbody>
												</table>
											</div>
											
											<header class="main-box-header clearfix">
												<button type="button" class="btn btn-info" onclick="sendForValidation()">Send for Approval</button>
												</header>
										
										</div>
									</div>
								</div>
							</div>
					

					<%@ include file="sections/footer.jsp" %>

						</div>
					</div>
				</div>
			</div>
			
		<%@ include file="sections/global_scripts.jsp" %>
	
	
</body>
</html>