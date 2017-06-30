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
	<fmt:setLocale value="en" />
	<title><fmt:message	key="userregistration" bundle="${label}" /></title>
</head>
<body>
	<section class="content-header">
		<h1>
			<i class="fa fa-user"></i>&nbsp;<span><fmt:message	key="userregistration" bundle="${label}" /></span>
		</h1>
	</section>
	<section class="content-header min-height">
		<div class="row">
			<div class="col-lg-12 connectedSortable">
				<div class="box box-primary">
					<div class="box-header">
						<div class="row">
							<div class="col-md-12 col-sm-6 col-xs-12">
								<span>All fields mark with&nbsp;(<span class="mandat">&nbsp;*&nbsp;</span>) are mantatory.</span>
							</div>
						</div>
					</div>
					<div class="box-body">
						<form id="userDataForm">
							<div class="row">
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<label class="control-label col-md-6 col-sm-3 col-xs-12" for="firstName">
											<fmt:message key="firstname" bundle="${label}" /><span class="required mandat">&nbsp;*</span>
										</label>
									</div>
								</div>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<label class="control-label col-md-6 col-sm-3 col-xs-12" for="middleName">
											<fmt:message key="middlename" bundle="${label}" />
										</label>
									</div>
								</div>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<label class="control-label col-md-6 col-sm-3 col-xs-12" for="lastName">
											<fmt:message key="lastname" bundle="${label}" /><span class="required mandat">&nbsp;*</span>
										</label>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<div class="col-md-12 col-sm-6 col-xs-12">
											<input id="firstName" class="form-control col-md-7 col-xs-12 required" name="firstName" 
												placeholder="<fmt:message key="firstname" bundle="${label}" />" type="text">
										</div>
									</div>
								</div>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<div class="col-md-12 col-sm-6 col-xs-12">
											<input id="middleName" class="form-control col-md-7 col-xs-12" name="middleName" 
												placeholder="<fmt:message key="middlename" bundle="${label}" />" type="text">
										</div>
									</div>
								</div>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<div class="col-md-12 col-sm-6 col-xs-12">
											<input id="lastName" class="form-control col-md-7 col-xs-12 required" name="lastName" 
												placeholder="<fmt:message key="lastname" bundle="${label}" />" type="text">
										</div>
									</div>
								</div>
							</div>
							
							<div class="row padding-top-1per">
								<div class="col-md-12 col-sm-6 col-xs-12">
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<label class="control-label col-md-6 col-sm-3 col-xs-12" for="shopName">
											<fmt:message key="shopname" bundle="${label}" /><span class="required mandat">&nbsp;*</span>
										</label>
									</div>
								</div>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<label class="control-label col-md-6 col-sm-3 col-xs-12" for="role">
											<fmt:message key="role" bundle="${label}" /><span class="required mandat">&nbsp;*</span>
										</label>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<div class="col-md-12 col-sm-6 col-xs-12">
											<input id="shopName" class="form-control col-md-7 col-xs-12 required" name="shopName" 
												placeholder="<fmt:message key="shopname" bundle="${label}" />" type="text">
											<input id="shopId" class="form-control col-md-7 col-xs-12" name="shopId" type="hidden">
										</div>
									</div>
								</div>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<div class="col-md-12 col-sm-6 col-xs-12">
											<input id="role" class="form-control col-md-7 col-xs-12 required" name="role" 
												placeholder="<fmt:message key="role" bundle="${label}" />" type="text">
											<input id="roleId" class="form-control col-md-7 col-xs-12" name="roleId" type="hidden">
										</div>
									</div>
								</div>
							</div>
							
							<div class="row padding-top-1per">
								<div class="col-md-12 col-sm-6 col-xs-12">
								</div>
							</div>
						
							<div class="row">
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<label class="control-label col-md-6 col-sm-3 col-xs-12" for="addressLine1">
											<fmt:message key="addressline1" bundle="${label}" /><span class="required mandat">&nbsp;*</span>
										</label>
									</div>
								</div>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<label class="control-label col-md-6 col-sm-3 col-xs-12" for="addressLine2">
											<fmt:message key="addressline2" bundle="${label}" />
										</label>
									</div>
								</div>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<label class="control-label col-md-6 col-sm-3 col-xs-12" for="town">
											<fmt:message key="town" bundle="${label}" /><span class="required mandat">&nbsp;*</span>
										</label>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<div class="col-md-12 col-sm-6 col-xs-12">
											<input id="addressLine1" class="form-control col-md-7 col-xs-12 required" name="addressLine1" 
												placeholder="<fmt:message key="addressline1" bundle="${label}" />" type="text">
										</div>
									</div>
								</div>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<div class="col-md-12 col-sm-6 col-xs-12">
											<input id="addressLine2" class="form-control col-md-7 col-xs-12" name="addressLine2" 
												placeholder="<fmt:message key="addressline2" bundle="${label}" />" type="text">
										</div>
									</div>
								</div>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<div class="col-md-12 col-sm-6 col-xs-12">
											<input id="town" class="form-control col-md-7 col-xs-12 required" name="town" 
												placeholder="<fmt:message key="town" bundle="${label}" />" type="text">
										</div>
									</div>
								</div>
							</div>
							
							<div class="row padding-top-1per">
								<div class="col-md-12 col-sm-6 col-xs-12">
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<label class="control-label col-md-6 col-sm-3 col-xs-12" for="pincode">
											<fmt:message key="pincode" bundle="${label}" /><span class="required mandat">&nbsp;*</span>
										</label>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<div class="col-md-12 col-sm-6 col-xs-12">
											<input id="pincode" class="form-control col-md-7 col-xs-12 required" name="pincode" 
												placeholder="<fmt:message key="pincode" bundle="${label}" />" type="text">
										</div>
									</div>
								</div>
							</div>
							
							<div class="row padding-top-1per">
								<div class="col-md-12 col-sm-6 col-xs-12">
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<label class="control-label col-md-6 col-sm-3 col-xs-12" for="country">
											<fmt:message key="country" bundle="${label}" /><span class="required mandat">&nbsp;*</span>
										</label>
									</div>
								</div>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<label class="control-label col-md-6 col-sm-3 col-xs-12" for="state">
											<fmt:message key="state" bundle="${label}" /><span class="required mandat">&nbsp;*</span>
										</label>
									</div>
								</div>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<label class="control-label col-md-6 col-sm-3 col-xs-12" for="city">
											<fmt:message key="city" bundle="${label}" /><span class="required mandat">&nbsp;*</span>
										</label>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<div class="col-md-12 col-sm-6 col-xs-12">									
											<select class="form-control col-md-7 col-xs-12 required" name="country" id="country">
												<option value="select"><fmt:message key="select" bundle="${label}" /></option>
												<c:forEach var="country" items="${countries}">
													<option value="${country}">${country}</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<div class="col-md-12 col-sm-6 col-xs-12">
											<select class="form-control col-md-7 col-xs-12 required" name="state" id="state" disabled>
												<option value="select"><fmt:message key="select" bundle="${label}" /></option>											
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<div class="col-md-12 col-sm-6 col-xs-12">
											<select class="form-control col-md-7 col-xs-12 required" name="city" id="city" disabled>
												<option value="select"><fmt:message key="select" bundle="${label}" /></option>											
											</select>
										</div>
									</div>
								</div>
							</div>
							
							<div class="row padding-top-1per">
								<div class="col-md-12 col-sm-6 col-xs-12">
								</div>
							</div>
							
							<div class="row padding-top-1per">
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<div class="col-md-12 col-sm-6 col-xs-12">
											<input value="Save" type="button" id="saveUserData" class="btn btn-block btn-primary"/>
										</div>
									</div>
								</div>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<div class="col-md-12 col-sm-6 col-xs-12">
											<input type="hidden" name="isActive" id="isActive" value="true"/>
										</div>
									</div>
								</div>
								<div class="col-md-4 col-sm-6 col-xs-12">
									<div class="item form-group">
										<div class="col-md-12 col-sm-6 col-xs-12">
										</div>
									</div>
								</div>
							</div>
						</form>					
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
<script src="scripts/userregistration.js"></script>
</html>