<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Contract Types</title>
<jsp:include page="menu.jsp" />
</head>
<body>
<h1 class="page-title">List Contract Types</h1>
<a href="addContractType.html" class="btn btn-primary mb-2">Create</a>

<c:if test="${!empty contractTypes}">
	<table class="table table-bordered">
		<tr>
			<th>Contract Type ID</th>
			<th>Contract Type Name</th>
			<th></th>
		</tr>

		<c:forEach items="${contractTypes}" var="contractType">
			<tr>
				<td><c:out value="${contractType.id}"/></td>
				<td><c:out value="${contractType.contractTypeName}"/></td>
				<td align="center"><a href="editContractType.html?id=${contractType.id}">Edit</a> | <a href="deleteContractType.html?id=${contractType.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>