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
	<div class="container">
		<h3 class="page-title">Vehicle Costs</h3>
		<a href="addVehicleCost.html" class="btn btn-primary mb-2">Create</a>
		<button onclick="myFunction()">Print this page</button>

		<c:if test="${!empty vehiclecosts}">
			<table class="table table-hover" id="vehicleCostListTable">
				<thead>
					<tr>
						<th>Vehicle</th>
						<th>Type</th>
						<th>Date</th>
						<th>Total Price</th>
						<th>Cost Description</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${vehiclecosts}" var="vehiclecost">
						<tr>
							<td><c:out value="${vehiclecost.vehicleName}" /></td>

							<td><c:out value="${vehiclecost.serviceTypeName}" /></td>
							<td><c:out value="${vehiclecost.date}" /></td>
							<td><c:out value="${vehiclecost.totalPrice}" /></td>
							<td><c:out value="${vehiclecost.costDesc}" /></td>

							<td align="center"><a
								href="editOdometer.html?id=${vehiclecost.id}">Edit</a> | <a
								href="deleteOdometer.html?id=${vehiclecost.id}">Delete</a></td>
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
	$(document).ready(function() {
		$('#vehicleCostListTable').DataTable();
	});
</script>
</html>