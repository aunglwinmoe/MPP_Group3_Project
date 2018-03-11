<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Contract Types</title>
<jsp:include page="menu.jsp" />
</head>
<body>
	<div class="container">
		<h3 class="page-title">Contract Types</h3>
		<a href="addContractType.html" class="btn btn-primary mb-2">Create</a>
	
		<c:if test="${!empty contractTypes}">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Name</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${contractTypes}" var="contractType">
						<tr>
							<%-- <td><c:out value="${contractType.id}"/></td> --%>
							<td><c:out value="${contractType.contractTypeName}"/></td>
							<td align="center">
								<a href="editContractType.html?id=${contractType.id}" class="icon"><i class="fas fa-pencil-alt"></i></a>
								<a href="deleteContractType.html?id=${contractType.id}" class="icon"><i class="fas fa-trash-alt"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>