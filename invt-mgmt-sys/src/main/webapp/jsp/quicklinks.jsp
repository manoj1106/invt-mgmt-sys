<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quick Links</title>
</head>
<body>
	<div class="box box-info">
    	<div class="box-header">
        	<i class="fa fa-hand-o-up"></i>
            <h3 class="box-title ng-binding">Quick links</h3>
        </div>
        <div class="box-body" ng-show="dashboardData.role == &#39;admin&#39;">
        	<div class="row" style="margin-bottom: 10px;">
	        	<div class="col-md-6"><a href="http://cr-house.com/apps/schoex/demo/#newsboard" class="btn btn-block btn-success ng-binding"> News Board </a></div>
	            <div class="col-md-6"><a href="http://cr-house.com/apps/schoex/demo/#events" class="btn btn-block btn-success ng-binding"> Events </a></div>
           	</div>
			<div class="row" style="margin-bottom: 10px;">
				<div class="col-md-6"><a href="http://cr-house.com/apps/schoex/demo/#classschedule" class="btn btn-block btn-success ng-binding"> Class Schedule </a></div>
				<div class="col-md-6"><a href="http://cr-house.com/apps/schoex/demo/#mailsms" class="btn btn-block btn-success ng-binding"> Mail / SMS</a></div>
			</div>
			<div class="row" style="margin-bottom: 10px;">
				<div class="col-md-6"><a href="http://cr-house.com/apps/schoex/demo/#staffAttendance" class="btn btn-block btn-success ng-binding"> Staff Attendance </a></div>
				<div class="col-md-6"><a href="http://cr-house.com/apps/schoex/demo/#attendance" class="btn btn-block btn-success ng-binding"> Attendance</a></div>
			</div>
			<div class="row" style="margin-bottom: 10px;">
				<div class="col-md-6"><a href="http://cr-house.com/apps/schoex/demo/#reports" class="btn btn-block btn-success ng-binding"> Reports </a></div>
				<div class="col-md-6"><a href="http://cr-house.com/apps/schoex/demo/#settings" class="btn btn-block btn-success ng-binding"> General Settings</a></div>
			</div>
          </div>
		  <div class="box-body ng-hide" ng-show="dashboardData.role == &#39;teacher&#39;">
		  	<div class="row" style="margin-bottom: 10px;">
				<div class="col-md-6"><a href="http://cr-house.com/apps/schoex/demo/#attendance" class="btn btn-block btn-success ng-binding"> Attendance </a></div>
				<div class="col-md-6"><a href="http://cr-house.com/apps/schoex/demo/#examsList" class="btn btn-block btn-success ng-binding"> Exams List </a></div>
			</div>
			<div class="row" style="margin-bottom: 10px;">
				<div class="col-md-6"><a href="http://cr-house.com/apps/schoex/demo/#assignments" class="btn btn-block btn-success ng-binding"> Assignments </a></div>
				<div class="col-md-6"><a href="http://cr-house.com/apps/schoex/demo/#onlineExams" class="btn btn-block btn-success ng-binding"> Online exams </a></div>
			</div>
		</div>
		<div class="box-body ng-hide" ng-show="dashboardData.role == &#39;student&#39;">
			<div class="row" style="margin-bottom: 10px;">
				<div class="col-md-6"><a href="http://cr-house.com/apps/schoex/demo/#classschedule" class="btn btn-block btn-success ng-binding"> Class Schedule </a></div>
				<div class="col-md-6"><a href="http://cr-house.com/apps/schoex/demo/#examsList" class="btn btn-block btn-success ng-binding"> Exams List </a></div>
			</div>
			<div class="row" style="margin-bottom: 10px;">
				<div class="col-md-4"><a href="http://cr-house.com/apps/schoex/demo/#assignments" class="btn btn-block btn-success ng-binding"> Assignments </a></div>
				<div class="col-md-4"><a href="http://cr-house.com/apps/schoex/demo/#onlineExams" class="btn btn-block btn-success ng-binding"> Online exams </a></div>
				<div class="col-md-4"><a href="http://cr-house.com/apps/schoex/demo/#attendanceStats" class="btn btn-block btn-success ng-binding"> Attendance </a></div>
			</div>
		</div>
		<div class="box-body ng-hide" ng-show="dashboardData.role == &#39;parent&#39;">
			<div class="row" style="margin-bottom: 10px;">
				<div class="col-md-4"><a href="http://cr-house.com/apps/schoex/demo/#students" class="btn btn-block btn-success ng-binding"> Students </a></div>
				<div class="col-md-4"><a href="http://cr-house.com/apps/schoex/demo/#examsList" class="btn btn-block btn-success ng-binding"> Exams List </a></div>
				<div class="col-md-4"><a href="http://cr-house.com/apps/schoex/demo/#attendanceStats" class="btn btn-block btn-success ng-binding"> Attendance </a></div>
			</div>
		</div>
    </div>
</body>
</html>