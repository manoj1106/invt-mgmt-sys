<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<section class="content-header ng-scope">
	  	<h1 class="ng-binding">
	  		<i class="fa fa-dashboard"></i>&nbsp;<span>Dashboard</span>
	  	</h1>
	</section>
	<section class="content ng-scope">
		<%@ include file="dashboard.jsp" %>
		<div class="row">
  			<section class="col-lg-7 connectedSortable">
    			<%@ include file="leaderboard.jsp" %>
    			<%@ include file="newsevents.jsp" %>
    			<%@ include file="quicklinks.jsp" %>
    			<div class="box box-warning ng-hide" ng-show="dashboardData.role == &#39;student&#39;">
		        	<div class="box-header">
		              <i class="fa fa-clock-o"></i>
		              <h3 class="box-title ng-binding">Attendance</h3>
		          	</div>
		          	<div class="box-body">
		              <table class="table table-bordered">
		                  <tbody><tr>
		                      <th class="ng-binding">Date</th>
		                      <th ng-show="dashboardData.attendanceModel==&#39;subject&#39;" class="ng-binding">Subject</th>
		                      <th class="ng-binding">Attendance</th>
		                  </tr>
		                  <!-- ngRepeat: (key,value) in dashboardData.studentAttendance -->
		                </tbody>
		              </table>
		          	</div>
		      	</div>
     			<div class="box box-warning ng-hide" ng-show="dashboardData.role == &#39;parent&#39;">
    				<div class="box-header">
       					<i class="fa fa-clock-o"></i>
          				<h3 class="box-title ng-binding">Attendance</h3>
    				</div>
          			<div class="box-body">
              		<!-- ngRepeat: (key, value) in dashboardData.studentAttendance -->
          			</div>
      			</div>
	  		</section>
			<section class="col-lg-5 connectedSortable">
				<%@ include file="calendar.jsp" %>
				<div ng-show="dashboardData.polls" class="box box-info rtlPage ng-hide">
					<div class="box-header">
				    	<i class="fa fa-tasks"></i>
				        <h3 class="box-title ng-binding"></h3>
				    </div>
				    <div class="box-body">
				    	<div class="form-group ng-hide" ng-show="dashboardData.polls.view == &#39;vote&#39;">
				        <!-- ngRepeat: value in dashboardData.polls.items -->
				    	</div>
				    	<div class="form-group ng-hide" ng-show="dashboardData.polls.view == &#39;results&#39;">
				    <!-- ngRepeat: value in dashboardData.polls.items -->
				    		<div class="text-center ng-binding">Total votes : </div>
				     	</div>
					</div>
				<!-- ngIf: !dashboardData.polls.voted -->
					<div ng-if="!dashboardData.polls.voted" class="box-footer clearfix ng-scope">
						<button type="button" class="pull-right btn btn-flat btn-info ng-binding ng-hide">Return</button>
						<button type="button" class="pull-right btn btn-flat btn-info ng-binding ng-hide">View Votes</button>
						<button type="button" class="pull-right btn btn-flat btn-info ng-binding ng-hide" disabled="disabled">Vote poll</button>
					</div><!-- end ngIf: !dashboardData.polls.voted -->
				</div>
 			</section>
		</div>
	</section>
</body>
</html>