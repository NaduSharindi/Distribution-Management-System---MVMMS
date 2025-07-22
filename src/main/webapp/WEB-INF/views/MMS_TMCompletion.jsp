<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%@ include file="sections/head.jsp" %>
	
	<style type="text/css">
		.mybtn{
			background-color: #e74c3c;
			padding: 1px 4px;
			display: inline-block;
			text-align: center;
			font-weight: 600;
			touch-action: manipulation;
			background-image: none;
			white-space: nowrap;
			font-size: 10px;
			float: right;
		}
	
	</style>
	<script type="text/javascript">

		function enable(){
			 document.getElementById("txtDeptId").disabled= false;
		 }
		
		function changeWayLeaving()
		{			
			 if (document.getElementById("cmbwayLeaving").value == "") 			 
			 {				 
				$('#otherWayLeaving').val("");
				document.getElementById("otherWayLeaving").style.visibility='visible';
				document.getElementById("cmbwayLeaving").disabled=true;
			    document.getElementById("btn1").style.visibility='visible';			        
		 	 } 
			 
			 else {
		        document.getElementById("cmbwayLeaving").disable=false;
			 }
		}
		
		function unchangeWayLeaving(){
			$('#otherWayLeaving').val("");
			document.getElementById("otherWayLeaving").style.visibility='hidden';
			document.getElementById("btn1").style.visibility='hidden';
			document.getElementById("cmbwayLeaving").disabled=false;
			document.getElementById("cmbwayLeaving").selectedIndex = 0;
		}
		
		
		
		function changeBaseConcrete()
		{	
			 if (document.getElementById("cmbbaseConcrete").value == "") 			 
			 {				 
				$('#otherbaseConcrete').val("");
				document.getElementById("otherbaseConcrete").style.visibility='visible';
				document.getElementById("cmbbaseConcrete").disabled=true;
			    document.getElementById("btn2").style.visibility='visible';			        
		 	 } 
			 
			 else {
		        document.getElementById("cmbbaseConcrete").disable=false;
			 }
		}
		
		function unchangeBaseConcrete(){
			$('#otherbaseConcrete').val("");
			document.getElementById("otherbaseConcrete").style.visibility='hidden';
			document.getElementById("btn2").style.visibility='hidden';
			document.getElementById("cmbbaseConcrete").disabled=false;
			document.getElementById("cmbbaseConcrete").selectedIndex = 0;
		}
		
		
		
		function changeAntiClimbing()
		{	
			 if (document.getElementById("cmbAntiClimbing").value == "") 			 
			 {				 
				$('#otherAntiClimbing').val("");
				document.getElementById("otherAntiClimbing").style.visibility='visible';
				document.getElementById("cmbAntiClimbing").disabled=true;
			    document.getElementById("btn3").style.visibility='visible';			        
		 	 } 
			 
			 else {
		        document.getElementById("cmbAntiClimbing").disable=false;
			 }
		}
		
		function unchangeAntiClimbing(){
			$('#otherAntiClimbing').val("");
			document.getElementById("otherAntiClimbing").style.visibility='hidden';
			document.getElementById("btn3").style.visibility='hidden';
			document.getElementById("cmbAntiClimbing").disabled=false;
			document.getElementById("cmbAntiClimbing").selectedIndex = 0;
		}
		
		
		
		function changeConductorCondition()
		{	
			
			 if (document.getElementById("cmbConductorCondition").value == "") 			 
			 {				 
				$('#otherConductorCondition').val("");
				document.getElementById("otherConductorCondition").style.visibility='visible';
				document.getElementById("cmbConductorCondition").disabled=true;
			    document.getElementById("btn4").style.visibility='visible';			        
		 	 } 
			 
			 else {
		        document.getElementById("cmbConductorCondition").disable=false;
			 }
		}
		
		function unchangeConductorCondition(){
			$('#otherConductorCondition').val("");
			document.getElementById("otherConductorCondition").style.visibility='hidden';
			document.getElementById("btn4").style.visibility='hidden';
			document.getElementById("cmbConductorCondition").disabled=false;
			document.getElementById("cmbConductorCondition").selectedIndex = 0;
		}
		
		
		function changeEarthConductorCondition()
		{	
			
			 if (document.getElementById("cmbEarthConductorCondition").value == "") 			 
			 {				 
				$('#otherEarthConductorCondition').val("");
				document.getElementById("otherEarthConductorCondition").style.visibility='visible';
				document.getElementById("cmbEarthConductorCondition").disabled=true;
			    document.getElementById("btn5").style.visibility='visible';			        
		 	 } 
			 
			 else {
		        document.getElementById("cmbEarthConductorCondition").disable=false;
			 }
		}
		
		function unchangeEarthConductorCondition(){
			$('#otherEarthConductorCondition').val("");
			document.getElementById("otherEarthConductorCondition").style.visibility='hidden';
			document.getElementById("btn5").style.visibility='hidden';
			document.getElementById("cmbEarthConductorCondition").disabled=false;
			document.getElementById("cmbEarthConductorCondition").selectedIndex = 0;
		}
		
		
		function changeJumperCondition()
		{	
			
			 if (document.getElementById("cmbJumperCondition").value == "") 			 
			 {				 
				$('#otherJumperCondition').val("");
				document.getElementById("otherJumperCondition").style.visibility='visible';
				document.getElementById("cmbJumperCondition").disabled=true;
			    document.getElementById("btn6").style.visibility='visible';			        
		 	 } 
			 
			 else {
		        document.getElementById("cmbJumperCondition").disable=false;
			 }
		}
		
		function unchangeJumperCondition(){
			$('#otherJumperCondition').val("");
			document.getElementById("otherJumperCondition").style.visibility='hidden';
			document.getElementById("btn6").style.visibility='hidden';
			document.getElementById("cmbJumperCondition").disabled=false;
			document.getElementById("cmbJumperCondition").selectedIndex = 0;
		}
		
		
		function changeswitchdev1()
		{	
			
			 if (document.getElementById("cmbswitchdev1").value == "") 			 
			 {				 
				$('#otherswitchdev1').val("");
				document.getElementById("otherswitchdev1").style.visibility='visible';
				document.getElementById("cmbswitchdev1").disabled=true;
			    document.getElementById("btn7").style.visibility='visible';			        
		 	 } 
			 
			 else {
		        document.getElementById("cmbswitchdev1").disable=false;
			 }
		}
		
		function unchangeswitchdev1(){
			$('#otherswitchdev1').val("");
			document.getElementById("otherswitchdev1").style.visibility='hidden';
			document.getElementById("btn7").style.visibility='hidden';
			document.getElementById("cmbswitchdev1").disabled=false;
			document.getElementById("cmbswitchdev1").selectedIndex = 0;
		}
		
		function changeswitchdev2()
		{	
			
			 if (document.getElementById("cmbswitchdev2").value == "") 			 
			 {				 
				$('#otherswitchdev2').val("");
				document.getElementById("otherswitchdev2").style.visibility='visible';
				document.getElementById("cmbswitchdev2").disabled=true;
			    document.getElementById("btn8").style.visibility='visible';			        
		 	 } 
			 
			 else {
		        document.getElementById("cmbswitchdev2").disable=false;
			 }
		}
		
		function unchangeswitchdev2(){
			$('#otherswitchdev2').val("");
			document.getElementById("otherswitchdev2").style.visibility='hidden';
			document.getElementById("btn8").style.visibility='hidden';
			document.getElementById("cmbswitchdev2").disabled=false;
			document.getElementById("cmbswitchdev2").selectedIndex = 0;
		}

		
		function changeswitchdev3()
		{	
			
			 if (document.getElementById("cmbswitchdev3").value == "") 			 
			 {				 
				$('#otherswitchdev3').val("");
				document.getElementById("otherswitchdev3").style.visibility='visible';
				document.getElementById("cmbswitchdev3").disabled=true;
			    document.getElementById("btn9").style.visibility='visible';			        
		 	 } 
			 
			 else {
		        document.getElementById("cmbswitchdev3").disable=false;
			 }
		}
		
		function unchangeswitchdev1(){
			$('#otherswitchdev3').val("");
			document.getElementById("otherswitchdev3").style.visibility='hidden';
			document.getElementById("btn9").style.visibility='hidden';
			document.getElementById("cmbswitchdev3").disabled=false;
			document.getElementById("cmbswitchdev3").selectedIndex = 0;
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
	                        <div class="col-lg-9">
	                            <ol class="breadcrumb">
	                                <li><a href="#">Home</a></li>
	                                <li class="active"><span>Maintenance Completion</span></li>
	                            </ol>
	
	                            <h1>Maintenance Completion</h1>
	                        </div>
				                                    
							<%@ include file="sections/userDetails.jsp" %> 
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="main-box">

								<div class="main-box-body clearfix">
							
									
									
									<form:form method="post" role="form" modelAttribute="model" action="MMS_Completion" onsubmit="return enable()" id="reg">
									 
										 <table class="table table-responsive" id="tblProvinces">
										  <tbody>
										
 																<%-- <tr>
														
														
														<td width="30%" style="text-align: left"><form:label
																	path="">CYCLE</form:label></td>
															<td width="70%" style="text-align: left"><form:select
																	id="cycle" path="cycleObj.id.cycleId" onchange="" style="width:50%; background-color: #94cb71; border-radius: 5px;">
																	<form:option value="NONE" label="ALL" />
																	<form:options items="${model.cycleList}" />

																	
																</form:select></td>
														</tr>
 --%>									
        														 <%--  <tr>
										  
										  
                												<td width="30%" style="text-align:left">
                											Tower No
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="id.towerid" type="text"  id="txtTowerId" placeholder="Enter Tower ID" />
																
																</td>
																    
        														</tr>
        														
        														 <tr>
										 
										
                												<td width="30%" style="text-align:left">
                												Department ID 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="deptid" type="text" id="txtDeptId" placeholder="Enter Dept ID" />
																<span id="spnDeptId" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														
        														
        														
        														
        														
        														
        														
        														
        														
        														
        														 <tr>
        															<td width="30%" style="text-align:left">
                												Tappings 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="nooftappings" type="number"  id="numTappings" placeholder="Enter No: of Tappings"/>
																<span id="spnTappings" class="label label-danger"></span>
																</td>
																</tr>
																
																
																 <tr>
        															<td width="30%" style="text-align:left">
                												No of Pinpoles1
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="pinpole1" type="number"  id="numpinpole1" placeholder="Enter No: of Pinploes"/>
																<span id="spnpinpole1" class="label label-danger"></span>
																</td>
																
																 </tr>
																 <tr>
																<td width="30%" style="text-align:left">
                												Select Switching Device	</td>				
                												<td width="70%" style="text-align:left">
																<form:select path="switchdev1"  name="cmbswitchdev1" id="cmbswitchdev1" onchange="changeswitchdev1()">
													<form:option value="" selected="selected"> << SELECT >> </form:option>
													<form:option value="LBS"> LBS </form:option>
													<form:option value="ABS"> ABS </form:option>
													<form:option value="DDLO"> DDLO </form:option>
													<form:option value="AR"> AR </form:option>
													<form:option value="None"> None </form:option>
													<form:option value="Not Visible"> Not Visible </form:option>
													<form:option value=""> Other </form:option>
												</form:select>
												<span id="spncmbswitchdev1" class="label label-danger"></span>	
													 <label>
											<button type="button" id="btn7" class="mybtn" onclick="unchangeswitchdev1()" style="visibility:hidden;">X</button>
											<form:input path="switchdev1" type="text" id="otherswitchdev1" name="otherswitchdev1" style="visibility:hidden;"/>
											</label>		
																
																</td>
																    
        														</tr>
        														
        														 <tr>
        															<td width="30%" style="text-align:left">
                												No of Pinpoles2
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="pinpole2" type="number"  id="numpinpole1" placeholder="Enter No: of Pinploes"/>
																<span id="spnpinpole2" class="label label-danger"></span>
																</td>
																
																 </tr>
																 <tr>
																<td width="30%" style="text-align:left">
                												Select Switching Device	</td>				
                												<td width="70%" style="text-align:left">
																<form:select path="switchdev2"  name="cmbswitchdev2" id="cmbswitchdev2" onchange="changeswitchdev2()">
													<form:option value="" selected="selected"> << SELECT >> </form:option>
													<form:option value="LBS"> LBS </form:option>
													<form:option value="ABS"> ABS </form:option>
													<form:option value="DDLO"> DDLO </form:option>
													<form:option value="AR"> AR </form:option>
													<form:option value="None"> None </form:option>
													<form:option value="Not Visible"> Not Visible </form:option>
													<form:option value=""> Other </form:option>
												</form:select>
												<span id="spncmbswitchdev2" class="label label-danger"></span>	
																 <label>
											<button type="button" id="btn8" class="mybtn" onclick="unchangeswitchdev2()" style="visibility:hidden;">X</button>
											<form:input path="switchdev2" type="text" id="otherswitchdev2" name="otherswitchdev2" style="visibility:hidden;"/>
											</label>
																</td>
																    
        														</tr>
        														
        														
        														 <tr>
        															<td width="30%" style="text-align:left">
                												No of Pinpoles3
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="pinpole3" type="number"  id="numpinpole3" placeholder="Enter No: of Pinploes"/>
																<span id="spnpinpole3" class="label label-danger"></span>
																</td>
																
																 </tr>
																 <tr>
																<td width="30%" style="text-align:left">
                												Select Switching Device	</td>				
                												<td width="70%" style="text-align:left">
																<form:select path="switchdev3"  name="cmbswitchdev3" id="cmbswitchdev3" onchange="changeswitchdev3()">
													<form:option value="" selected="selected"> << SELECT >> </form:option>
													<form:option value="LBS"> LBS </form:option>
													<form:option value="ABS"> ABS </form:option>
													<form:option value="DDLO"> DDLO </form:option>
													<form:option value="AR"> AR </form:option>
													<form:option value="None"> None </form:option>
													<form:option value="Not Visible"> Not Visible </form:option>
													<form:option value=""> Other </form:option>
												</form:select>
												<span id="spncmbswitchdev3" class="label label-danger"></span>	
																
															 <label>
											<button type="button" id="btn9" class="mybtn" onclick="unchangeswitchdev3()" style="visibility:hidden;">X</button>
											<form:input path="switchdev3" type="text" id="otherswitchdev3" name="otherswitchdev3" style="visibility:hidden;"/>
											</label>																</td>
																    
        														</tr>
        														
        														 <tr>
        															<td width="30%" style="text-align:left">
                												Missing parts 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="noofmissingparts" type="number"  id="numMissingParts" placeholder="Enter No: of missing parts"/>
																<span id="spnMissingParts" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														 <tr>
        															<td width="30%" style="text-align:left">
                												Flash over sets 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="nofflashoversets" type="number"  id="numflashOverSets" placeholder="Enter No: of flash over sets"/>
																<span id="spnflashOverSets" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														 <tr>
																<td width="30%" style="text-align:left">
                												Way leaving Status 	</td>				
                												<td width="70%" style="text-align:left">
																<form:select path="wayleavestatus"  name="cmbwayLeaving" id="cmbwayLeaving" onchange="changeWayLeaving()">
													<form:option value="" selected="selected"> << SELECT >> </form:option>
													<form:option value="Good"> Good </form:option>
													<form:option value="Touch"> Touch </form:option>
													<form:option value="Danger"> Danger </form:option>
													<form:option value="Close"> Close </form:option>
													<form:option value="Around"> Around </form:option>
													<form:option value="Along"> Along </form:option>
													<form:option value=""> Other </form:option>
												</form:select>
												<span id="spncmbwayLeaving" class="label label-danger"></span>	
																
																<label>
											<button type="button" id="btn1" class="mybtn" onclick="unchangeWayLeaving()" style="visibility:hidden;">X</button>
											<form:input path="wayleavestatus" type="text" id="otherWayLeaving" name="otherWayLeaving" class="form-control" style="visibility:hidden;"/>
											</label>
																</td>
																    
        														</tr>
        														
        														 <tr>
        															<td width="30%" style="text-align:left">
        															Base Concrete Status 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="baseconcretestatus"  name="cmbbaseConcrete" id="cmbbaseConcrete" onchange="changeBaseConcrete()">
													<form:option value="" selected="selected"> << SELECT >> </form:option>
													<form:option value="Good"> Good </form:option>
													<form:option value="Bad"> Bad </form:option>
													<form:option value="Danger"> Danger </form:option>
													<form:option value=""> Other </form:option>
												</form:select>
												<span id="spncmbbaseConcrete" class="label label-danger"></span>
												<label>
											<button type="button" id="btn2" class="mybtn" onclick="unchangeBaseConcrete()" style="visibility:hidden;">X</button>
											<form:input path="baseconcretestatus" type="text" id="otherbaseConcrete" name="otherbaseConcrete" class="form-control" style="visibility:hidden;"/>
											
											</label>
																</td>
																    
        														</tr>
										
                											
									
														 <tr>
										 
										
                												<td width="30%" style="text-align:left">
                												Anti climbing Status 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="anticlimbingstatus" name="cmbAntiClimbing" id="cmbAntiClimbing" onchange="changeAntiClimbing()">
													<form:option value="" selected="selected"> << SELECT >> </form:option>
													<form:option value="Good"> Good </form:option>
													<form:option value="Corroded"> Corroded </form:option>
													<form:option value="Lost"> Lost </form:option>
													<form:option value=""> Other </form:option>
												</form:select>
												<span id="spncmbAntiClimbing" class="label label-danger"></span>
											<label>
											<button type="button" id="btn3" class="mybtn" onclick="unchangeAntiClimbing()" style="visibility:hidden;">X</button>
											<form:input path="anticlimbingstatus" type="text" id="otherAntiClimbing" name="otherAntiClimbing" class="form-control" style="visibility:hidden;"/>
											
											</label>
																</td>
																    
        														</tr>
									
										
										 <tr>
        															<td width="30%" style="text-align:left">
                												Conductor Condition
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="conductorstatus"  name="cmbConductorCondition" id="cmbConductorCondition" onchange="changeConductorCondition()">
													<form:option value="" selected="selected"> << SELECT >> </form:option>
													<form:option value="Good"> Good </form:option>
													<form:option value="Damage"> Damage </form:option>
													<form:option value="Danger"> Danger </form:option>
													<form:option value=""> Other </form:option>
												</form:select>
												<span id="spncmbConductorCondition" class="label label-danger"></span>
											<label>
											<button type="button" id="btn4" class="mybtn" onclick="unchangeConductorCondition()" style="visibility:hidden;">X</button>
											<form:input path="conductorstatus" type="text" id="otherConductorCondition" name="otherConductorCondition" class="form-control" style="visibility:hidden;"/>
											
											</label>
																</td>
																    
        														</tr>
        														
        														
        														 <tr>
        															<td width="30%" style="text-align:left">
                											Jumper Status 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="jumperstatus"  name="cmbJumperCondition" id="cmbJumperCondition" onchange="changeJumperCondition()">
													<form:option value="" selected="selected"> << SELECT >> </form:option>
													<form:option value="Good"> Good </form:option>
													<form:option value="Damage"> Damage </form:option>
													<form:option value="Danger"> Danger </form:option>
													<form:option value="None"> None </form:option>
													<form:option value=""> Other </form:option>
												</form:select>
												<span id="spnJumperCondition" class="label label-danger"></span>
											<label>
											<button type="button" id="btn6" class="mybtn" onclick="unchangeJumperCondition()" style="visibility:hidden;">X</button>
											<form:input path="jumperstatus" type="text" id="otherJumperCondition" name="otherJumperCondition" class="form-control" style="visibility:hidden;"/>
											
											</label>
																</td>
																    
        														</tr>
        														
        														
        														
        														 <tr>
        															<td width="30%" style="text-align:left">
                												Earth Conductor Condition 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="earthconductorstatus"  name="cmbEarthConductorCondition" id="cmbEarthConductorCondition" onchange="changeEarthConductorCondition()">
													<form:option value="" selected="selected"> << SELECT >> </form:option>
													<form:option value="Good"> Good </form:option>
													<form:option value="Damage"> Damage </form:option>
													<form:option value="Danger"> Danger </form:option>
													<form:option value=""> Other </form:option>
												</form:select>
												<span id="spnEarthConductorCondition" class="label label-danger"></span>
											<label>
											<button type="button" id="btn5" class="mybtn" onclick="unchangeEarthConductorCondition()" style="visibility:hidden;">X</button>
											<form:input path="earthconductorstatus" type="text" id="otherEarthConductorCondition" name="otherEarthConductorCondition" class="form-control" style="visibility:hidden;"/>
											
											</label>
																</td>
																    
        														</tr>
										
										
									 <tr>
        															<td width="30%" style="text-align:left">
        															Maintenance attention 
                												
                												</td>
                												<td width="70%" style="text-align:left">
																<form:select path="attentionstatus" name="cmbMaintainaceAttention" id="cmbMaintainaceAttention">
													<form:option value="" selected="selected"> << SELECT >> </form:option>
													<form:option value="Urgent"> Urgent </form:option>
													<form:option value="Not Urgent"> Not Urgent </form:option>
												</form:select>
												<span id="spnMaintainaceAttention" class="label label-danger"></span>
																</td>
																    
        														</tr>
        															
									
										
        														 <tr>
										 
										
                												<td width="30%" style="text-align:left">
                												Funguss Set No 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="fungussetno" type="text"  id="txtFunguss" placeholder="Enter Funguss set number"/>
											<span id="spnFunguss" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														 <tr>
										 
										
                												<td width="30%" style="text-align:left">
                												WPIN Set 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="wpinset" type="text" id="txtWPIN" placeholder="Enter WPIN set"/>
											<span id="spnWPIN" class="label label-danger"></span>
																</td>
																    
        														</tr>
											 <tr>
										 
										
                												<td width="30%" style="text-align:left">
                												End Fitting Set 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input type="text" path="endfittingset" id="txtEndFitting" placeholder="Enter End Fitting set"/>
											<span id="spnEndFitting" class="label label-danger"></span>
																</td>
																    
        														</tr>
									
										 <tr>
															<td width="30%" style="text-align:left">
                											Special observations
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="towerspecial" type="text" id="txtSpecialObservations" placeholder="Comments"/>
											<span id="spnSpecialObservations" class="label label-danger"></span>
																</td>
																    
        														</tr>
									
										 <tr>
															<td width="30%" style="text-align:left">
                											LUTD 
                												</td>
                												<td width="70%" style="text-align:left">
																<form:input path="ludt" type="datetime-local" id="txtLUTD" placeholder="LUTD Date and Time"/>
											<span id="spnLUTD" class="label label-danger"></span>
																</td>
																    
        														</tr>
										
										 <tr>
															<td width="30%" style="text-align:left">
                											Maintenance Date
                												<td width="70%" style="text-align:left">
																<form:input path="maintenancedate" type="date"  id="txtMaintenanceDate" placeholder="Set Maintenance Date"/>
											<span id="spnMaintenanceDate" class="label label-danger"></span>
																</td>
																    
        														</tr>
        														  <tr>
															<td width="30%" style="text-align:left">
                											Status 
                												<td width="70%" style="text-align:left">
																<form:select path="status"  id="txtStatus" placeholder="Enter Status">
												<form:option value="" selected="selected"> << SELECT >> </form:option>
												<form:option value="0">Send for Approval</form:option>
												<form:option value="2">Keep in Bulk</form:option>
											</form:select>										
											<span id="spnStatus" class="label label-danger"></span>
																</td>
																    
        														</tr> 
										 <tr>
															<td width="30%" style="text-align:left">
                											Approval Level
                												<td width="70%" style="text-align:left">
																
											<form:select path="approvalLevel"  id="cmbapprovalLevel">
													<form:option value="ES1COMWPS2" selected="selected"> ES1COMWPS2 </form:option>
													<form:option value="ESPHM1"> ESPHM1 </form:option>
												</form:select>
												<span id="spnTowerType" class="label label-danger"></span>
																</td>
																    
        														</tr>
 --%>										
        														
										 </tbody>
										</table>
										
									<div class="form-group">
											<div class="pull-left">
												<input type="submit" Value="Add Completion Data" class="btn btn-success" />
												<button type="button" class="btn btn-warning" onclick="window.location.href='editMaintenance'">Edit</button>
											</div>
									
								</div>
									</form:form>
									
									
							</div>
						</div>

					</div>

					<%@ include file="sections/footer.jsp" %>

						</div>
					</div>
				</div>
			</div>
			</div>
		<%@ include file="sections/global_scripts.jsp" %>
		
	</body>
</html>