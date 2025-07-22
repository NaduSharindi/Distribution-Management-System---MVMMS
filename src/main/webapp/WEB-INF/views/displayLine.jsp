<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"-->
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>MV-MMS</title>
		<%@ include file="sections/headEdit.jsp" %>
		
		<style type="text/css">
			.form-control {
		    display: inline-block;
		    width: 100%;
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
		function LoadProvincesToEdit(pid)
		{
			if(document.getElementById("pstatus_"+pid).value == 0 || document.getElementById("pstatus_"+pid).value == 1 || document.getElementById("pstatus_"+pid).value == 4){
				alert("This item is sent for approving or active item or inactive item. You cann't edit this");
			}
			else{
				enable(pid);
			}
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

     	   alert('hiiiii' +url);
    	   
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
        
	</script>
</head>

<body>
<div id="theme-wrapper">
		<%@ include file="sections/header.jsp" %>
		
		<div id="page-wrapper" class="container">
			<div class="row">
				<%@ include file="sections/userLevels.jsp" %>
				<div id="content-wrapper">
					
					<div class="row">
								<div class="col-lg-12">
									
										<header class="main-box-header clearfix">
											<h2 class="pull-left">List of Lines</h2>
										</header>
										
										<div class="main-box-body clearfix">
											<div class="table-responsive" style="overflow-x:auto;">
                                              <table class="table table-responsive" id="tblAdmin">
                                              
                                              

                                                    <thead>
                                                <!--  <tr>
                                                    <td><input type="text" id="search" value=""></input></td>
                                                    <td><button type='button' class='btn btn-warning' onClick='LoadProvincesToEdit("${line.id}")'>Search</button></td>
                                                    </tr>-->
														<tr>
                                                                                                                
															<th class="text-center">Id</th>
															<th class="text-center">Code</th>
															<th class="text-center">Line Name</th>
															<th class="text-center">Line Type</th>
															<th class="text-center">Length</th>
															<th class="text-center">Area</th>
															<th class="text-center">No of Poles</th>
															<th class="text-center">No of Towers</th>
															<th class="text-center">COM Date</th>
															<th class="text-center">Status</th>
															<th class="text-center">Approval Level</th>
															<th class="text-center">Edit</th>
															<th class="text-center">Save</th>
															
														</tr>
													</thead>
													<tbody>
											           <c:forEach var="line" items="${line}" >
											                <tr>  
											                <td><input type="text" id="pid" value="${line.id}" class="form-control" disabled></td>
											                
											                 <td><input type="text" id="pcode_${line.id}" value="${line.code}" class="form-control" disabled></td>
											                 <td><input type="text" id="pname_${line.id}" value="${line.lineName}" class="form-control" disabled></td>
											                 <td><input type="text" id="ptype_${line.id}" value="${line.lineType}" class="form-control" disabled></td>
											                  <td><input type="text" id="plegnth_${line.id}" value="${line.length}" class="form-control" disabled></td>
											                 <td><input type="text" id="parea_${line.id}" value="${line.area}" class="form-control" disabled></td>
											                 <td><input type="text" id="ppoles_${line.id}" value="${line.noofpoles}" class="form-control" disabled></td>
											                  <td><input type="text" id="ptowers_${line.id}" value="${line.nooftowers}" class="form-control" disabled></td>
											                 <td><input type="text" id="pcomdate_${line.id}" value="${line.comdate }" class="form-control" disabled></td>
											                 
											                 <td><select id="pstatus_${line.id}" class="form-control" disabled>
											                	<c:choose>
											                		<c:when test="${line.status==0}">
											                			<option value="${line.status}" selected="selected">Pending</option>
											                		</c:when>
											                		
											                		<c:when test="${line.status==1}">
											                			<option value="${line.status}" selected="selected">Active</option>
											                		</c:when>
											                			
											                		<c:when test="${line.status==2}">
											                			<option value="${line.status}" selected="selected">In bulk</option>
											                			<option value="0">Send for Approval</option>
											                		</c:when>
											                		
											                		<c:when test="${line.status==4}">
											                			<option value="${line.status}" selected="selected">Inactive</option>
											                		</c:when>
											                		
											                		<c:otherwise>
											                			<option value="${line.status}" selected="selected">Rejected</option>
											                			<option value="0">Send for Approval</option>
											                			<option value="2">Keep in bulk</option>
											                		</c:otherwise>
											                	
											                	</c:choose>	
											                </select ></td> 
											                
											                
											                <td><select id="n14_${line.id}" class="form-control" disabled>
											                			<option value="" selected="selected"></option>
											                			<option value="ES1COMWPS2">ES1COMWPS2</option>
											                			<option value="ESPHM1">ESPHM1</option>
											                	</select>
											                </td> 
											                
											                 
											                <td><button type='button' class='btn btn-warning' onClick='LoadProvincesToEdit("${line.id}")'>Edit</button></td>
											                <td><button type='button' class='btn btn-success' onClick='javascript:save("${line.id}")'>Save</button></td>      
											                </tr>
											                
											            </c:forEach>
													</tbody>
												</table>
											
										</div>
										<header class="main-box-header clearfix">
											<button type="button" class="btn btn-info" onclick="window.location.href='addProvince'">Back</button>
										</header>
										
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