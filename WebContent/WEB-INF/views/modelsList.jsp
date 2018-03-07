<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Models</title>
<jsp:include page="menu.jsp" />
</head>
<body>
<h1 class="page-title">List Models</h1>
<a href="addModel.html" class="btn btn-primary mb-2">Create</a>

<c:if test="${!empty models}">
	<table class="table table-bordered">
		<tr>
			<th>Model ID</th>
			<th>Model Name</th>
			<th></th>
		</tr>

		<c:forEach items="${models}" var="model">
			<tr>
				<td><c:out value="${model.modelId}"/></td>
				<td><c:out value="${model.modelName}"/></td>
				<td align="center"><a href="editModel.html?id=${model.modelId}">Edit</a> | <a href="deleteModel.html?id=${model.modelId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>