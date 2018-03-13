<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Vehicle Model</title>
	<jsp:include page="menu.jsp" />
</head>
<body>
	<div class="container">
		<h3 class="page-title">Vehicle Model</h3>
		<a href="addModel.html" class="btn"><i class="fas fa-plus-circle"></i> New</a>
		
		<c:if test="${!empty models}">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Make</th>
						<th>Model name</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${models}" var="model">
						<tr>
							<td><c:out value="${model.modelName}"/></td>
							<td><c:out value="${model.makeName}"/></td>
							<td align="center">
								<a href="editModel.html?id=${model.id}" class="icon"><i class="fas fa-pencil-alt"></i></a> 
								<a href="deleteModel.html?id=${model.id}" class="icon"><i class="fas fa-trash-alt"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>