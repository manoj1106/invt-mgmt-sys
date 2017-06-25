<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style type="text/css">@charset "UTF-8";[ng\:cloak],[ng-cloak],[data-ng-cloak],[x-ng-cloak],.ng-cloak,.x-ng-cloak,.ng-hide{display:none !important;}ng\:form{display:block;}.ng-animate-block-transitions{transition:0s all!important;-webkit-transition:0s all!important;}.ng-hide-add-active,.ng-hide-remove{display:block!important;}</style>
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<title>Index Page</title>
    	<!--<base href="http://cr-house.com/apps/schoex/demo/">--><base href=".">
    	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    	<script type="text/javascript" src="scripts/header.js"></script>
<title>Header Page</title>
</head>
<body onload="startDateTimeUpdate()">
	<%@ include file="utils/alertmessages.jsp" %>
	<!-- Main Header -->
	<header class="main-header">
		<!-- Logo -->
		<a href="#" class="logo">
			<!-- mini logo for sidebar mini 50x50 pixels -->
			<span class="logo-mini">Inventory Management System</span>
			<!-- logo for regular state and mobile devices -->
			<span class="logo-lg">Inventory Management System</span>
		</a>
			<!-- Header Navbar -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a class="sidebar-toggle" data-toggle="offcanvas" role="button">
					<span class="sr-only">Toggle navigation</span>
				</a>
				<!-- Navbar Right Menu -->
				<div class="navbar-custom-menu navbar-right">
					<ul class="nav navbar-nav">
						<!-- Messages: style can be found in dropdown.less-->
						<li class="dropdown user user-menu">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class=""></i>
								<span id="currentTimeUpdate">Current Time:</span>
							</a>
						</li>
						<li class="dropdown user user-menu">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="glyphicon glyphicon-arrow-up"></i>
								<span>Version - 1.0</span>
							</a>
						</li>
						<li class="dropdown messages-menu">
							<!-- Menu toggle button -->
						 	<a id="chgAcademicYear">
						 		<i class="fa fa-calendar-check-o"></i>
						 	</a>
						 </li>
						 <!-- User Account Menu -->
						 <li class="dropdown user user-menu">
						 	<!-- Menu Toggle Button -->
						 	<a href="" class="dropdown-toggle" data-toggle="dropdown">
						 		<!-- The user image in the navbar-->
						 		<img src="images/manoj_patel.gif" style="width:25px; height:25px;" class="user-image" alt="">
						 		<!-- hidden-xs hides the username on small devices so only the image appears. -->
						 		<span class="hidden-xs"></span>
						 	</a>
						 	<ul class="dropdown-menu">
						 		<!-- The user image in the menu -->
						 			<li class="user-header">
										<img src="images/manoj_patel.gif" style="width:90px; height:90px;" class="img-circle" alt="">
										<p>
											<small>User Name : </small>
											<small>User Role : </small>
											<small>Password Expired On : </small>
											<small>Last Login On :</small>
										</p>
									</li>
						 <!-- Menu Footer-->
						 <li class="user-footer">
						 <div class="col-xs-4 text-center">
						<a href="#">Change profile data</a>
						 </div>
						 <div class="col-xs-4 text-center">
						<a href="#">Change e-mail address</a>
						 </div>
						 <div class="col-xs-4 text-center">
						<a href="#">Change password</a>
						 </div>
						 </li>
						</ul>
						  </li>
						  <li class="dropdown user user-menu">
						 <a href="#" class="logout">
						 <i class="fa fa-fw fa-sign-out"></i>
						 <span>Logout</span>
						 </a>
						 <form id="logoutform" action="logout" method="get"></form>
						  </li>
						</ul>
						  </div>
		</nav>
	  </header>
</body>
</html>