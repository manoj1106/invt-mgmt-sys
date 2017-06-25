<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<fmt:setBundle basename="AlertMessages" var="alert" />
</head>
<body>
</body>
	<script type="text/javascript">
		var msg = {
			systemError : '<fmt:message key='systemError' bundle='${alert}'/>',
			provideRole : '<fmt:message key='provideRole' bundle='${alert}'/>',
			provideShopId : '<fmt:message key='provideShopId' bundle='${alert}'/>',
			defaultMenuRemoval : '<fmt:message key='defaultMenuRemoval' bundle='${alert}'/>',
			defaultMenuItemNotAdded : '<fmt:message key='defaultMenuItemNotAdded' bundle='${alert}'/>'
		};
	</script>
</html>