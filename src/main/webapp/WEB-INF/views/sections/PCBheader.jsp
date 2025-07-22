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

					<%-- <c:if test="${countAll !='0'}">
						<div class="dropdown">
							<li class="hidden-xxs"><a class="btn" href=""> <i
									class="fa fa-bell" style="color: white"></i> <span class="num"
									style="color: red; font-weight: bold;">${countAll}</span>
							</a></li>
							<div class="dropdown-content">

								<c:if test="${countLine =='0'}">
									<a href="displayAllLines">Approve Lines</a>
								</c:if>
								<c:if test="${countLine !='0'}">
									<a href="displayAllLines">Approve Lines (<span class="num"
										style="color: red; font-weight: bold;">${countLine}</span>)
									</a>
								</c:if>

								<c:if test="${countSupport =='0'}">
									<a href="displayAllSupports">Approve Supports</a>
								</c:if>
								<c:if test="${countSupport !='0'}">
									<a href="displayAllSupports">Approve Supports (<span
										class="num" style="color: red; font-weight: bold;">${countSupport}</span>)
									</a>
								</c:if>

								<c:if test="${countMnt =='0'}">
									<a href="displayAllMnt">Approve Mnt</a>
								</c:if>
								<c:if test="${countMnt !='0'}">
									<a href="displayAllMnt">Approve Mnt (<span class="num"
										style="color: red; font-weight: bold;">${countMnt}</span>)
									</a>
								</c:if>

							</div>
						</div>
					</c:if> --%>

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

					

					<li class="hidden-xxs"><a class="btn" href="WelcomePCB"> <i
							class="fa fa-power-off"></i>
					</a></li>

				</ul>
			</div>
		</div>
	</div>
</header>