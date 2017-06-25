<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News Events</title>
</head>
<body>
	<div class="box box-warning">
		<div class="box-header">
			<i class="fa fa-clock-o"></i>
			<h3 class="box-title ng-binding">News &amp; Events</h3>
		</div>
		<div class="box-body">
			<ul class="todo-list">
				<!-- ngRepeat: item in dashboardData.newsEvents -->
				<li ng-repeat="item in dashboardData.newsEvents" class="ng-scope">
					<small class="label label-danger ng-binding">news</small> <!-- ngIf: item.type == 'news' -->
					<span ng-if="item.type == &#39;news&#39;" class="text ng-scope">
						<a href="#"	class="ng-binding">Review of student support officers</a>
					</span>
				<!-- end ngIf: item.type == 'news' --> <!-- ngIf: item.type == 'event' -->
				</li>
				<!-- end ngRepeat: item in dashboardData.newsEvents -->
				<li ng-repeat="item in dashboardData.newsEvents" class="ng-scope">
					<small class="label label-danger ng-binding">news</small> <!-- ngIf: item.type == 'news' -->
					<span ng-if="item.type == &#39;news&#39;" class="text ng-scope">
						<a href="#"	class="ng-binding">Inner Sydney high school community consultation</a>
					</span>
					<!-- end ngIf: item.type == 'news' --> 
					<!-- ngIf: item.type == 'event' -->
				</li>
				<!-- end ngRepeat: item in dashboardData.newsEvents -->
				<li ng-repeat="item in dashboardData.newsEvents" class="ng-scope">
					<small class="label label-danger ng-binding">event</small> <!-- ngIf: item.type == 'news' -->
					<!-- ngIf: item.type == 'event' --> 
					<span ng-if="item.type == &#39;event&#39;" class="text ng-scope">
						<a href="#" class="ng-binding">Education Week</a>
					</span>
					<!-- end ngIf: item.type == 'event' -->
				</li>
				<!-- end ngRepeat: item in dashboardData.newsEvents -->
				<li ng-repeat="item in dashboardData.newsEvents" class="ng-scope">
					<small class="label label-danger ng-binding">event</small> <!-- ngIf: item.type == 'news' -->
					<!-- ngIf: item.type == 'event' -->
					<span ng-if="item.type == &#39;event&#39;" class="text ng-scope">
						<a href="#" class="ng-binding">Artexpress Exhibitionws</a>
					</span> <!-- end ngIf: item.type == 'event' -->
				</li>
				<!-- end ngRepeat: item in dashboardData.newsEvents -->
			</ul>
		</div>
	</div>
</body>
</html>