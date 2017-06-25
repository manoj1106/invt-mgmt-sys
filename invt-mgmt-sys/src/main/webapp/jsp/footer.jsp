<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Main Footer -->
    <footer class="main-footer">
      <strong>All Rights Reserved, Inventory Management System</strong> -  <a target="_BLANK" href="#">School Terms</a>
      <small>Developed and maintained by Manoj Patel</small>
    </footer>
    <div class="modal fade ng-scope" visible="chgAcYearModalShow"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button><h4 class="modal-title ng-binding"></h4></div><div class="modal-body" ng-transclude="">
        <div class="ng-scope">
            <select class="form-control ng-pristine ng-valid" id="selectedAcYear">
              <!-- ngRepeat: year in $root.dashboardData.academicYear --><!-- ngIf: year.isDefault == '0' --><option value="3" class="ng-binding ng-scope">2013 - 2014</option><!-- end ngIf: year.isDefault == '0' --><!-- end ngRepeat: year in $root.dashboardData.academicYear --><!-- ngIf: year.isDefault == '0' --><!-- end ngRepeat: year in $root.dashboardData.academicYear --><!-- ngIf: year.isDefault == '0' --><option ng-selected="year.id == &#39;6&#39;" ng-repeat="year in $root.dashboardData.academicYear" value="10" ng-if="year.isDefault == &#39;0&#39;" class="ng-binding ng-scope">2014 - 2015</option><!-- end ngIf: year.isDefault == '0' --><!-- end ngRepeat: year in $root.dashboardData.academicYear -->
              <!-- ngRepeat: year in $root.dashboardData.academicYear --><!-- ngIf: year.isDefault == '1' --><!-- end ngRepeat: year in $root.dashboardData.academicYear --><!-- ngIf: year.isDefault == '1' --><option ng-selected="year.id == &#39;6&#39;" ng-repeat="year in $root.dashboardData.academicYear" value="6" ng-if="year.isDefault == &#39;1&#39;" class="ng-binding ng-scope" selected="selected">2015-2016 - Default Year</option><!-- end ngIf: year.isDefault == '1' --><!-- end ngRepeat: year in $root.dashboardData.academicYear --><!-- ngIf: year.isDefault == '1' --><!-- end ngRepeat: year in $root.dashboardData.academicYear -->
            </select>
            <br>
            <a class="floatRTL btn btn-success btn-flat pull-right marginBottom15 ng-binding" ng-click="chgAcYear()">Change Year</a>
            <div class="clearfix"></div>
        </div>
    </div></div></div></div>
    <div ng-spinner-loader=""></div>

	<script src="scripts/plugins/jquery.min.js"></script>
	<script src="scripts/plugins/jquery-ui.min.js"></script>
	<script src="scripts/plugins/bootstrap.min.js"></script>
	<script src="scripts/plugins/intlTelInput.min.js"></script>
	<script src="scripts/plugins/app.js"></script>
	<script src="scripts/plugins/demo.js"></script>
	<!-- PNotify -->
	<script type="text/javascript" src="scripts/plugins/notify/pnotify.core.js"></script>
	<script type="text/javascript" src="scripts/plugins/notify/pnotify.buttons.js"></script>
	<script type="text/javascript" src="scripts/plugins/notify/pnotify.nonblock.js"></script>
	<script src="scripts/invtmgmtsys.js" type="text/javascript"></script>
	<script src="scripts/utils/invtmgmtsysutil.js"	type="text/javascript"></script>
	<script src="scripts/utils/constants.js" type="text/javascript"></script>
	<script src="scripts/datagrid.js" type="text/javascript"></script>
	<script src="scripts/plugins/validator/formvalidator.js"></script>
	<script src="scripts/autocomplete.js"></script>

	<div id="cboxOverlay" style="display: none;"></div>
	<div id="colorbox" class="" role="dialog" tabindex="-1" style="display: none;">
		<div id="cboxWrapper">
			<div>
				<div id="cboxTopLeft" style="float: left;"></div>
				<div id="cboxTopCenter" style="float: left;"></div>
				<div id="cboxTopRight" style="float: left;"></div>
			</div>
			<div style="clear: left;">
				<div id="cboxMiddleLeft" style="float: left;"></div>
				<div id="cboxContent" style="float: left;">
					<div id="cboxTitle" style="float: left;"></div>
					<div id="cboxCurrent" style="float: left;"></div>
						<button type="button" id="cboxPrevious"></button>
						<button type="button" id="cboxNext"></button>
						<button id="cboxSlideshow"></button>
					<div id="cboxLoadingOverlay" style="float: left;"></div>
					<div id="cboxLoadingGraphic" style="float: left;"></div>
				</div>
				<div id="cboxMiddleRight" style="float: left;"></div>
			</div>
			<div style="clear: left;">
				<div id="cboxBottomLeft" style="float: left;"></div>
				<div id="cboxBottomCenter" style="float: left;"></div>
				<div id="cboxBottomRight" style="float: left;"></div>
			</div>
		</div>
		<div style="position: absolute; width: 9999px; visibility: hidden; display: none; max-width: none;"></div>
	</div>
</body>
<script type="text/javascript">
	invtmgmtsysutil.hideLoader();
</script>
</html>