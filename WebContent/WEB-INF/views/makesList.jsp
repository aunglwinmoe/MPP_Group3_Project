<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Makes</title>
<jsp:include page="menu.jsp" />
</head>
<body>
	<div class="container">
		<h3 class="page-title">Model make of Vehicle</h3>
		<a href="addMake.html" class="btn btn-primary mb-2">Create</a>
		
		<c:if test="${!empty makes}">
			<table class="table table-hover" id="makeListTable">
				<thead>
					<tr>
						<!-- <th>Make ID</th> -->
						<th>Make</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${makes}" var="make">
						<tr>
							<%-- <td><c:out value="${make.id}"/></td> --%>
							<td><c:out value="${make.makeName}"/></td>
							<td align="center">
								<a href="editMake.html?id=${make.id}" class="icon"><i class="fas fa-pencil-alt"></i></a> 
								<a href="deleteMake.html?id=${make.id}" class="icon"><i class="fas fa-trash-alt"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>