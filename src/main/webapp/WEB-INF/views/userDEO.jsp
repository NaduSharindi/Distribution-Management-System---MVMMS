<div id="nav-col"
	style="height: 500px; position: fixed; overflow-y: auto;">
	<section id="col-left" class="col-left-nano">
		<div id="col-left-inner" class="col-left-nano-content">
			<div id="user-left-box" class="clearfix hidden-sm hidden-xs">
				<img alt="" src="<c:url value="/resources/img/samples/user.png"/>" />
				<div class="user-box">
					<span class="name">
						<p>
							<strong>Welcome <br /> ${sessionScope.userNameUser}
							</strong>
						</p>
					</span> <span class="status"> <button class="blinkbutton" onclick="viewUserRegister()"> <i
								class="fa fa-user"></i> 
						</button> Online
					</span>
				</div>
			</div>
			<div class="collapse navbar-collapse navbar-ex1-collapse"
				id="sidebar-nav">
				<ul class="nav nav-pills nav-stacked">
					<li><a href="dashboard"> <i class="fa fa-dashboard"></i> <span>Dashboard</span>
							<!--<span class="label label-info label-circle pull-right">28</span>-->
					</a></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="fa fa-pencil-square-o"></i> <span>Add
								Administrative Units</span> <i
							class="fa fa-chevron-circle-right drop-icon"></i>
					</a>
						<ul class="submenu">
							<li><a href="addProvince">Province </a></li>

							<li><a href="addArea">Area </a></li>

							<li><a href="addCSC">CSC </a></li>
						</ul></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="fa fa-sliders"></i> <span>Line Master Data</span> <i
							class="fa fa-chevron-circle-right drop-icon"></i>
					</a>
						<ul class="submenu">

							<li><a href="addLineType">Line type </a></li>

							<li><a href="addSupportType">Support type </a></li>

							<li><a href="addConductorType">Conductor type </a></li>

							<li><a href="addEarthConType">Earth Conductor type
							</a></li>

							<li><a href="addInsulatorType">Insulator type </a></li>

							<li><a href="addTowerConfig">Tower Configuration </a></li>

							<li><a href="addTowerInsulator">Tower Insulator </a></li>

							<li><a href="addStatusType">Status Type </a></li>

							<li><a href="addStatus">Status </a></li>

						</ul></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="fa fa-tasks"></i> <span>Line & Support</span> <i
							class="fa fa-chevron-circle-right drop-icon"></i>
					</a>
						<ul class="submenu">

							<li><a href="#" class="dropdown-toggle"> <i
									class="fa fa-pencil-square"></i> <span>Line</span> <i
									class="fa fa-chevron-circle-right drop-icon"></i>
							</a>
								<ul class="submenu">
									<li><a href="addLine"> Add </a></li>
									<li><a href="displayLineNew"> Edit </a></li>
								</ul></li>


							<li><a href="#" class="dropdown-toggle"> <i
									class="fa fa-pencil-square"></i> <span>Support</span> <i
									class="fa fa-chevron-circle-right drop-icon"></i>
							</a>
								<ul class="submenu">
									<li><a href="addSupport"> Add </a></li>
									<li><a href="displaySupportNew"> Edit </a></li>
								</ul></li>


						</ul></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="fa fa-pencil-square"></i> <span>Maintenance Data</span> <i
							class="fa fa-chevron-circle-right drop-icon"></i>
					</a>
						<ul class="submenu">
							<li><a href="#" class="dropdown-toggle"> <i
									class="fa fa-pencil-square"></i> <span>Tower Maintenance</span>
									<i class="fa fa-chevron-circle-right drop-icon"></i>
							</a>
								<ul class="submenu">
									<li><a href="towerMaintenance"> Add </a></li>
									<li>
										<!-- 	<a href="editTowerMaintenance">--> <a href="editTMnew">

											Edit </a>
									</li>


									<li><a href="viewTMnewApprove"> View </a></li>


								</ul></li>

							<li><a href="insulatorMaintenance"> Insulator
									Maintenance </a></li>
						</ul></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="fa fa-retweet"></i> <span>View Line & Support</span> <i
							class="fa fa-chevron-circle-right drop-icon"></i>
					</a>
						<ul class="submenu">
							<li><a href="viewLineNew">Line </a></li>

							<li><a href="viewSupportNew">Support </a></li>
						</ul></li>

<li>
						
						<a href="#" class="dropdown-toggle">
							<i class="fa fa-retweet"></i>
							<span>Download APK</span>
							<i class="fa fa-chevron-circle-right drop-icon"></i>
						</a>
						<ul class="submenu">
							<li>
								<a href="downloadAPK">
									Download
								</a>
							</li>
						  
								
						</ul>
						
						
					</li>	
					

						<li>
						
						<a href="#" class="dropdown-toggle">
							<i class="fa fa-retweet"></i>
							<span>Upload</span>
							<i class="fa fa-chevron-circle-right drop-icon"></i>
						</a>
						<ul class="submenu">
							<li>
								<a href="uploadFormLine">
									Line
								</a>
							</li>
						  <li>
								<a href="upSupport">
									Support
								</a>
							</li> 
					<li>
								<a href="upMNT">
									Maintenance
								</a>
							</li> 
						
						
						<li>
						
						<a href="#" class="dropdown-toggle">
							<i class="fa fa-retweet"></i>
							<span>Update Tapping</span>
							<i class="fa fa-chevron-circle-right drop-icon"></i>
						</a>
						<ul class="submenu">
							<li>
								<a href="displaySupportTapping">
									Tapping
								</a>
							</li>
						  
						
								
						</ul>
						
						
					</li>
					
					
					<!-- <li>
						
						<a href="#" class="dropdown-toggle">
							<i class="fa fa-retweet"></i>
							<span>Completion Data</span>
							<i class="fa fa-chevron-circle-right drop-icon"></i>
						</a>
						<ul class="submenu">
							<li>
								<a href="mntCompletion">
									Add
								</a>
							</li>
						  <li>
								<a href="">
									Edit
								</a>
							</li> 
					<li>
								<a href="">
									Send for Validation
								</a>
							</li> 
						
								
						</ul>
						
						
					</li> -->

					<!-- <li>
						<a href="MMS_Map">
							<i class="fa fa-map-marker"></i>
							<span>View Map</span>
						</a>
					</li>
					
					<li>
						<a href="GenerateReportNew">
							<i class="fa fa-table"></i>
							<span>Reports</span>
						</a>
					</li>-->

				</ul>
			</div>

		</div>
	</section>
</div>