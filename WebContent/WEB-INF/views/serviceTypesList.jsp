<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Service Types</title>
<jsp:include page="menu.jsp" />
</head>
<body>
<h1 class="page-title">List Service Types</h1>
<a href="addServiceType.html" class="btn btn-primary mb-2">Create</a>

<c:if test="${!empty serviceTypes}">
	<table class="table table-bordered">
		<tr>
			<th>Service Type ID</th>
			<th>Service Type Name</th>
			<th></th>
		</tr>

		<c:forEach items="${serviceTypes}" var="serviceType">
			<tr>
				<td><c:out value="${serviceType.id}"/></td>
				<td><c:out value="${serviceType.serviceTypeName}"/></td>
				<td align="center"><a href="editServiceType.html?id=${serviceType.id}">Edit</a> | <a href="deleteServiceType.html?id=${serviceType.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>