<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<head>

<style>
.blinkbutton {
        background-color: #1c87c9;
        -webkit-border-radius: 60px;
        border-radius: 60px;
        border: none;
        color: #eeeeee;
        cursor: pointer;
        display: inline-block;
        font-family: sans-serif;
        font-size: 20px;
        padding: 10px 10px;
        text-align: center;
        text-decoration: none;
      }
      @keyframes glowing {
        0% {
          background-color: #2ba805;
          box-shadow: 0 0 5px #2ba805;
        }
        50% {
          background-color: #49e819;
          box-shadow: 0 0 20px #49e819;
        }
        100% {
          background-color: #2ba805;
          box-shadow: 0 0 5px #2ba805;
        }
      }
      .blinkbutton {
        animation: glowing 1300ms infinite;
      }










</style>


<script type="text/javascript">
function userRegister(estimateNo,costCenterNo){
	 var url="UserRegistration";
	 var width = 1100;
	    var height = 700;
	var left = parseInt((screen.availWidth/2) - (width/2));
    var top = parseInt((screen.availHeight/2) - (height/2));
    var windowFeatures = "width=" + width + ",height=" + height + 
    ",status,resizable,left=" + left + ",top=" + top +
    "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
    window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
    //myWindow.document.write("<p>This is 'MsgWindow'. I am 200px wide and 100px tall!</p>");
} 


function viewUserRegister(){
	 var url="ViewUserInfo";
	 var width = 1100;
	    var height = 700;
	    var left = parseInt((screen.availWidth/2) - (width/2));
   var top = parseInt((screen.availHeight/2) - (height/2));
   var windowFeatures = "width=" + width + ",height=" + height + 
   ",status,resizable,left=" + left + ",top=" + top +
   "screenX=" + left + ",screenY=" + top + ",scrollbars=yes";
   window.open(url, "subWind", windowFeatures, "POS");//window.open(url,"_blank","directories=no, status=no,width=1000, height=700,top=50,left=50", "scrollbars=1");
   //myWindow.document.write("<p>This is 'MsgWindow'. I am 200px wide and 100px tall!</p>");
} 


</script>


<style>


.dropdown {
  position: static;
  display: inline;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #3e8e41;}

.blinkbutton {
        background-color: #1c87c9;
        -webkit-border-radius: 60px;
        border-radius: 60px;
        border: none;
        color: #eeeeee;
        cursor: pointer;
        display: inline-block;
        font-family: sans-serif;
        font-size: 20px;
        padding: 10px 10px;
        text-align: center;
        text-decoration: none;
      }
      @keyframes glowing {
        0% {
          background-color: #2ba805;
          box-shadow: 0 0 5px #2ba805;
        }
        50% {
          background-color: #49e819;
          box-shadow: 0 0 20px #49e819;
        }
        100% {
          background-color: #2ba805;
          box-shadow: 0 0 5px #2ba805;
        }
      }
      .blinkbutton {
        animation: glowing 1300ms infinite;
      }










</style>


</head>


<header class="navbar" id="header-navbar">
	<div class="container" style="position: fixed">
		<div class="clearfix">
			<button class="navbar-toggle" data-target=".navbar-ex1-collapse" style="left: 0;position: absolute;"
				data-toggle="collapse" type="button">
				<span class="sr-only">Toggle navigation</span> <span
					class="fa fa-bars"></span>
			</button>
			<!-- <button class="navbar-toggle" data-target=".navbar-ex1-collapse" style="left: 0;position: absolute;"
				data-toggle="collapse" type="button">
				<span class="sr-only">Toggle navigation</span> <span
					class="fa fa-bars"></span>
			</button>
			 -->
			 <!-- <div class='page-header'>
  <div class='btn-toolbar pull-right'>
    <div class='btn-group'>
      <button type='button' class='btn btn-primary'>Button Text</button>
    </div>
  </div>
  <h2>Header Text</h2>
</div> -->
			 

			<div
				class="nav-no-collapse navbar-left pull-left hidden-sm hidden-xs">
				<ul class="nav navbar-nav pull-left">
					<li><a class="btn" id="make-small-nav"> <i
							class="fa fa-bars"></i>
					</a></li>
				</ul>
			</div>
			
			

			<div class="nav-no-collapse pull-right" id="header-nav">
				<ul class="nav navbar-nav pull-right">
				<!-- <li class="hidden-xxs"><button class="blinkbutton" onclick="userRegister()"> <i
								class="fa fa-user"></i> 
						</button></li>
				 -->		
						
				 
				
				<li class="hidden-xxs"><a class="btn" href="RequestCalender"> <i
								class="fa fa-calendar"></i> 
						</a></li>

					<li class="mobile-search"><a class="btn"> <i
							class="fa fa-search"></i>
					</a>

						<div class="drowdown-search">
							<form role="search">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Search...">
									<i class="fa fa-search nav-search-icon"></i>
								</div>
							</form>
						</div></li>

					<c:if test="${countAll =='0'}">
						<li class="hidden-xxs"><a class="btn" href=""> <i
								class="fa fa-bell"></i> 
						</a></li>
					</c:if>
					
					<c:if test="${countAll !='0'}">
						<li class="hidden-xxs"><a class="btn" href=""> <i
								class="fa fa-bell"></i> <span class="badge" 
								>${countAll}</span>
						</a>
						 <div class="dropdown-content">
                    <!--  <a href="#">Line</a>
                     --> <a href="displayAllLines">Line(<span class="num" style="color:red; font-weight:bold;">${countLine}</span>)</a>
                        <a href="displayAllSupports">Support(<span class="num" style="color:red; font-weight:bold;">${countSupport}</span>)</a>
                            <a href="displayAllMnt">Maintenance Data(<span class="num" style="color:red; font-weight:bold;">${countMnt}</span>)</a>
                                                                                            
                     <!-- <a href="#">Support</a>
                        <a href="#">Maintenance Data</a>
                      -->   
                                                            
                        
                         </div>
                       
                      
						
						
						
						
						
						</li>
						
						
						<!-- <a href="#" class="notification">
  <span>Inbox</span>
  <span class="badge">3</span>
</a> -->
						
						
						
					</c:if>
					<c:choose>
					<c:when test="${sessionScope.deptId.equals('490.60')}">
					<li class="hidden-xxs">
					<a class="btn" href="WelcomeEM">
						<i class="fa fa-power-off"></i>
					</a>
				</li>
	</c:when>
	<c:when test="${sessionScope.deptId.equals('550.80')}">
					<li class="hidden-xxs">
					<a class="btn" href="WelcomeEM">
						<i class="fa fa-power-off"></i>
					</a>
				</li>
	</c:when>
	<c:otherwise>
		<li class="hidden-xxs">
					<a class="btn" href="WelcomeMMS">
						<i class="fa fa-power-off"></i>
					</a>
				</li>
	</c:otherwise>	
		
</c:choose> 
			<!-- <li class="hidden-xxs">
					<a class="btn" href="WelcomeMMS">
						<i class="fa fa-power-off"></i>
					</a>
				</li>		
			 -->		
						
				</ul>
			</div>
		</div>
	</div>
</header>