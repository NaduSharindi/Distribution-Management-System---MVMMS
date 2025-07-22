<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<header class="navbar" id="header-navbar">
	<div class="container" style="position: fixed">
		<div class="clearfix">
			<button class="navbar-toggle" data-target=".navbar-ex1-collapse"
				data-toggle="collapse" type="button">
				<span class="sr-only">Toggle navigation</span> <span
					class="fa fa-bars"></span>
			</button>

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
								class="fa fa-bell"></i> <span class="num"
								style="color: red; font-weight: bold;">${countAll}</span>
						</a></li>
					</c:if>
					
						<li class="hidden-xxs"><a class="btn" href="WelcomePNG">
								<i class="fa fa-power-off"></i>
						</a></li>
					
				</ul>
			</div>
		</div>
	</div>
</header>