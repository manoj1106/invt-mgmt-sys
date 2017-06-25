<html>
<head>
	<meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style type="text/css">@charset "UTF-8";[ng\:cloak],[ng-cloak],[data-ng-cloak],[x-ng-cloak],.ng-cloak,.x-ng-cloak,.ng-hide{display:none !important;}ng\:form{display:block;}.ng-animate-block-transitions{transition:0s all!important;-webkit-transition:0s all!important;}.ng-hide-add-active,.ng-hide-remove{display:block!important;}</style>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Index Page</title>
    <base href=".">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link href="css/plugins/bootstrap.min.css" rel="stylesheet">
    <link href="css/plugins/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/plugins/admin.lte.min.css" rel="stylesheet" type="text/css">
    <link href="css/plugins/jquery.gritter.css" rel="stylesheet" type="text/css">
    <link href="css/plugins/fullcalendar.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/plugins/all.skins.min.css">
    <link rel="stylesheet" href="css/plugins/intlTelInput.css">
    <link href="css/plugins/schoolmanagement.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="css/plugins/jquery-ui.min.css">
    <link href="css/plugins/custom.css" rel="stylesheet" type="text/css">
    <link href="css/invtmgmtsyscss/common.css" rel="stylesheet" type="text/css">
  	<style>.cke{visibility:hidden;}</style>
 </head>
<body class="skin-blue sidebar-mini ng-scope">
	<div class="wrapper">
      	<%@ include file="header.jsp" %>
		<%@ include file="sidebar.jsp" %>      
      	<!-- ngView:  -->
      	<div id="parentDBArea" class="content-wrapper ng-scope" style="min-height: 1209px;">
      		<%@ include file="dashboardcontent.jsp" %>
		</div>
		<div id="myModal" class="modal fade ng-scope in" visible="chgAcYearModalShow" aria-hidden="false" style="display: none; padding-right: 17px;">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span>x</span></button>
						<h4 class="modal-title ng-binding">Change Year</h4>
					</div>
					<div class="modal-body" ng-transclude="">
				        <div class="ng-scope">
				            <select class="form-control ng-pristine ng-valid" id="selectedAcYear" ng-model="dashboardData.selectedAcYear">
				              <!-- ngRepeat: year in $root.dashboardData.academicYear --><!-- ngIf: year.isDefault == '0' --><option ng-selected="year.id == '6'" ng-repeat="year in $root.dashboardData.academicYear" value="3" ng-if="year.isDefault == '0'" class="ng-binding ng-scope">2013 - 2014</option><!-- end ngIf: year.isDefault == '0' --><!-- end ngRepeat: year in $root.dashboardData.academicYear --><!-- ngIf: year.isDefault == '0' --><!-- end ngRepeat: year in $root.dashboardData.academicYear --><!-- ngIf: year.isDefault == '0' --><option ng-selected="year.id == '6'" ng-repeat="year in $root.dashboardData.academicYear" value="10" ng-if="year.isDefault == '0'" class="ng-binding ng-scope">2014 - 2015</option><!-- end ngIf: year.isDefault == '0' --><!-- end ngRepeat: year in $root.dashboardData.academicYear -->
				              <!-- ngRepeat: year in $root.dashboardData.academicYear --><!-- ngIf: year.isDefault == '1' --><!-- end ngRepeat: year in $root.dashboardData.academicYear --><!-- ngIf: year.isDefault == '1' --><option ng-selected="year.id == '6'" ng-repeat="year in $root.dashboardData.academicYear" value="6" ng-if="year.isDefault == '1'" class="ng-binding ng-scope" selected="selected">2015-2016 - Default Year</option><!-- end ngIf: year.isDefault == '1' --><!-- end ngRepeat: year in $root.dashboardData.academicYear --><!-- ngIf: year.isDefault == '1' --><!-- end ngRepeat: year in $root.dashboardData.academicYear -->
				            </select>
				            <br>
				            <a class="floatRTL btn btn-success btn-flat pull-right marginBottom15 ng-binding" ng-click="chgAcYear()">Change Year</a>
				            <div class="clearfix"></div>
				        </div>
				    </div>
				</div>
			</div>
		</div>
	    <div id="overlay" style="display: none;">
	    	<div class="loading">
	    		<div class="dot"></div>
	    		<div class="dot2"></div>
	    	</div>
	    </div>
      	
    	<div class="control-sidebar-bg" style="position: fixed; height: auto;"></div>
	</div>
    <%@ include file="footer.jsp" %>
</body>
</html>