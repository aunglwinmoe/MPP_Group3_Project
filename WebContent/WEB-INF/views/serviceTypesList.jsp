<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Service Types</title>
<jsp:include page="menu.jsp" />
</head>
<body>
	<div class="container">
		<h3 class="page-title">Service Types</h3>
		<a href="addServiceType.html" class="btn btn-primary mb-2">Create</a>
		
		<c:if test="${!empty serviceTypes}">
			<table class="table table-hover">
				<thead>
					<tr>
						<!-- <th>Service Type ID</th> -->
						<th>Name</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${serviceTypes}" var="serviceType">
						<tr>
							<%-- <td><c:out value="${serviceType.id}"/></td> --%>
							<td><c:out value="${serviceType.serviceTypeName}"/></td>
							<td align="center">
								<a href="editServiceType.html?id=${serviceType.id}" class="icon"><i class="fas fa-pencil-alt"></i></a>
								<a href="deleteServiceType.html?id=${serviceType.id}" class="icon"><i class="fas fa-trash-alt"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>