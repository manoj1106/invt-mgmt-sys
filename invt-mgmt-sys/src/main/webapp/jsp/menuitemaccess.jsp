<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	 <meta name="_csrf" content="${_csrf.token}"/>
 	 <!-- default header name is X-CSRF-TOKERN -->
 	 <meta name="_csrf_header" content="${_csrf.headerName}"/>
	<fmt:setBundle basename="LabelMessages" var="label" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><fmt:message	key="MenuItemAccess" bundle="${label}" /></title>
	<fmt:setLocale value="en" />
	<link href="css/invtmgmtsyscss/menuitemaccess.css" rel="stylesheet" type="text/css">	
	<link href="css/plugins/flat.css" rel="stylesheet" type="text/css">
</head>
<body>
	<section class="content-header ng-scope">
	  	<h1 class="ng-binding">
	  		<i class="fa fa-cog fa-fw"></i>&nbsp;<span><fmt:message	key="MenuItemAccess" bundle="${label}" /></span>
	  	</h1>
	</section>
	<section class="content ng-scope">
		<form action="#." class="form-horizontal form-label-left" method="post">
		<section class="col-lg-12 connectedSortable">
			<div class="row">
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="item form-group">
						<label class="control-label col-md-6 col-sm-3 col-xs-12"
							for="role"> <fmt:message key="Roles"
								bundle="${label}" /> <span class="required mandat">*</span>
						</label>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="item form-group">
						<label class="control-label col-md-6 col-sm-3 col-xs-12"
							for="shopName"> <fmt:message key="ShopName"
								bundle="${label}" /> <span class="required mandat">*</span>
						</label>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="item form-group">
						<label class="control-label col-md-6 col-sm-3 col-xs-12"
							for="shopId"> <fmt:message key="ShopId"
								bundle="${label}" /> <span class="required mandat">*</span>
						</label>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="item form-group">
						<div class="col-md-12 col-sm-6 col-xs-12">
							<select class="form-control col-md-7 col-xs-12" name="role" id="role">
								<option value="select"><fmt:message key="select" bundle="${label}" /></option>
								<c:forEach var="role" items="${roles}">
									<option value="${role}">${role}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="item form-group">
						<div class="col-md-12 col-sm-6 col-xs-12">
							<input id="shopName" class="form-control col-md-7 col-xs-12 autocomplete" autocompleteText="school_name" name="schoolName" 
								placeholder="<fmt:message key="TypeThreeCharacter" bundle="${label}" />" type="text">
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="item form-group">
						<div class="col-md-12 col-sm-6 col-xs-12">
							<input id="shopId" class="form-control col-md-7 col-xs-12" name="schId" 
								placeholder="<fmt:message key="TypeThreeCharacter" bundle="${label}" />" type="text">
						</div>
					</div>
				</div>
			</div>
			</section>
			<section class="col-lg-12 connectedSortable">
			<div class="row">
				<div class="col-md-6 col-sm-6 col-xs-12">
					<section class="col-lg-12 connectedSortable">
						<div class="box box-danger">
							<div class="box-header">
								<i class="fa fa-trophy"></i>
								<h3 class="box-title ng-binding"><fmt:message key="AllMenues" bundle="${label}" /></h3>
							</div>
							<div class="box-body">
								<div class="menuitemdiv"></div>
							</div>
						</div>
					</section>
				</div>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<section class="col-lg-12 connectedSortable">
						<div class="box box-danger">
							<div class="box-header">
								<i class="fa fa-trophy"></i>
								<h3 class="box-title ng-binding"><fmt:message key="AllowedMenues" bundle="${label}" /></h3>
							</div>
							<div class="box-body">
								<div class="row">
									<div class="col-md-8 col-sm-6 col-xs-12">
										<div class="allowedmenuitemdiv"></div>
									</div>
									<div class="col-md-4 col-sm-6 col-xs-12">
										<div class="row">
											<div class="col-md-12 col-sm-6 col-xs-12">
												<input value="<fmt:message key="Save" bundle="${label}"/>" type="button" id="savemenuitems" class="savemenuitems btn btn-block btn-success ng-binding" onclick="javascript:saveMenuItems()"/>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12 col-sm-6 col-xs-12">
												<input type="button" value="<fmt:message key="RemoveItem" bundle="${label}"/>" class="removemenuitems btn btn-block btn-danger ng-binding" disabled onclick="removeSelectedMenu()">
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
				</div>
			</div>
			</section>
		</form>
	</section>
</body>
<script src="scripts/menuitemaccess.js"></script>
</html>