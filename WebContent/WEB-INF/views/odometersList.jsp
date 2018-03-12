<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="menu.jsp" />
<title>Vehicle Management System</title>
</head>
<body>
	<h2 align="left">Odometers</h2>
	<a href="addOdometer.html" class="btn btn-primary mb-2">Create</a>

	<c:if test="${!empty odometers}">
		<table class="table table-bordered" id="odometerListTable">
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
						<td><c:out value="${odometer.vehicleId}" /></td>
						<td><c:out value="${odometer.odometerVal}" /></td>
						<td><c:out value="${odometer.date}" /></td>
						<td><c:out value="${odometer.status}" /></td>

						<td align="center"><a
							href="editOdometer.html?id=${odometer.id}">Edit</a> | <a
							href="deleteOdometer.html?id=${odometer.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#odometerListTable').DataTable();
	});
</script>
</html>