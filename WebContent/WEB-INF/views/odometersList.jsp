<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="menu.jsp" />
<title>Vehicle Management System</title>
</head>
<body>
	<div class="container">
		<h3 class="page-title">Odometers</h3>
		<a href="addOdometer.html" class="btn btn-primary mb-2">Create</a>
		<!-- <button onclick="myFunction()">Print this page</button>-->

		<c:if test="${!empty odometers}">
			<table class="table table-hover" id="odometerListTable">
				<thead>
					<tr>
						<th>Vehicle</th>
						<th>Odometer</th>
						<th>Date</th>
						<th>Status</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${odometers}" var="odometer">
						<tr>
							<td><c:out value="${odometer.vehicleName}" /></td>
							<td><c:out value="${odometer.odometerVal}" /></td>
							<td><c:out value="${fn:substring(odometer.date, 0, 10)}" /></td>
							<td><c:out value="${odometer.status}" /></td>

							<td align="center">
								<a href="editOdometer.html?id=${odometer.id}" class="icon"><i class="fas fa-pencil-alt"></i></a>
								<a href="deleteOdometer.html?id=${odometer.id}" class="icon"><i class="fas fa-trash-alt"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
<script type="text/javascript">
	function myFunction() {
		window.print();
	}
</script>
</html>