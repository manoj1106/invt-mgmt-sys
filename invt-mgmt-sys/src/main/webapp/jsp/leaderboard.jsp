<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leader Board</title>
</head>
<body>
	<div class="row">
		<div class="col-lg-6 connectedSortable">
			<div class="box box-danger">
				<div class="box-header">
					<i class="fa fa-trophy"></i>
					<h3 class="box-title ng-binding">Student's leaderboard</h3>
				</div>
				<div class="box-body">
					<ul class="users-list clearfix">
						<!-- ngRepeat: student in dashboardData.studentLeaderBoard -->
						<li ng-repeat="student in dashboardData.studentLeaderBoard"
							class="ng-scope"><img alt="Alice Bean"
							class="user-image img-circle" style="width: 35px; height: 35px;"
							src="images/14"> <a class="users-list-name ng-binding">Alice
								Bean</a> <span class="users-list-date ng-binding">High marks</span>
						</li>
						<!-- end ngRepeat: student in dashboardData.studentLeaderBoard -->
						<li ng-repeat="student in dashboardData.studentLeaderBoard"
							class="ng-scope"><img alt="Elaine Beange"
							class="user-image img-circle" style="width: 35px; height: 35px;"
							src="images/15"> <a class="users-list-name ng-binding">Elaine
								Beange</a> <span class="users-list-date ng-binding">Helping
								other students</span></li>
						<!-- end ngRepeat: student in dashboardData.studentLeaderBoard -->
					</ul>
				</div>
			</div>
		</div>
		<div class="col-lg-6 connectedSortable">
			<div class="box box-danger">
				<div class="box-header">
					<i class="fa fa-trophy"></i>
					<h3 class="box-title ng-binding">Teacher's leaderboard</h3>
				</div>
				<div class="box-body">
					<ul class="users-list clearfix">
						<!-- ngRepeat: student in dashboardData.teacherLeaderBoard -->
						<li ng-repeat="student in dashboardData.teacherLeaderBoard"
							class="ng-scope"><img alt="Patsy Brix-Nielsen"
							class="user-image img-circle" style="width: 35px; height: 35px;"
							src="images/10"> <a class="users-list-name ng-binding">Patsy
								Brix-Nielsen</a> <span class="users-list-date ng-binding">Productive</span>
						</li>
						<!-- end ngRepeat: student in dashboardData.teacherLeaderBoard -->
						<li ng-repeat="student in dashboardData.teacherLeaderBoard"
							class="ng-scope"><img alt="Huguette Corriveau"
							class="user-image img-circle" style="width: 35px; height: 35px;"
							src="images/13"> <a class="users-list-name ng-binding">Huguette
								Corriveau</a> <span class="users-list-date ng-binding">High
								Attitiude</span></li>
						<!-- end ngRepeat: student in dashboardData.teacherLeaderBoard -->
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>