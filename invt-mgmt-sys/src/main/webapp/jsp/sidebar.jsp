<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sidebar Page</title>
</head>
<body>
	<!-- Left side column. contains the logo and sidebar -->
	  <c:set var="userrole" value="${userrole}"></c:set>
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar" style="height: auto;">
          <!-- Sidebar user panel (optional) -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="images/manoj_patel.gif" style="width:45px; height:45px;" class="img-circle" alt="Brittany Babotts">
            </div>
            <div class="pull-left info"><p></p></div>
          </div>
          <!-- Sidebar Menu -->
         
         <c:choose>
         	<c:when test="${not empty menues}">
         		<div>${menues}</div>
         	</c:when>
         	<c:otherwise>
         		<c:if test="${not empty userrole && userrole == 'SYSTEM_ADMIN'}">
	         		<ul class="sidebar-menu">
	          			<li><a class="aj" href="#" data-href="menuitemaccess/menuitemaccess"><i class="fa fa-cog fa-fw"></i><span>Menu Item Access</span></a></li>
	         		</ul>
         		</c:if>
         	</c:otherwise>
         </c:choose>
        </section>
        <!-- /.sidebar -->
      </aside>
</body>
</html>