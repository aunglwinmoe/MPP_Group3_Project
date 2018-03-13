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
	<div class="container" style="width: 100%; max-width: inherit">
		<h3 class="page-title">Vehicles</h3>
		<a href="addVehicle.html" class="btn"><i class="fas fa-plus-circle"></i> New</a>
		<c:if test="${!empty vehicles}">
			<table class="table table-hover" id="vehicleListTable">
				<thead>
					<tr>	
						<!-- <th>Vehicle ID</th>
				<th>Catalog Value</th>
				<th>Residual Value</th>
				<th>Transmission</th>
				-->

						<th>Vehicle Name</th>
						<th>Vehicle Model</th>
						<th>License Plate</th>
						<th>Chassis Number</th>
						<th>Model Year</th>
						<th>Last Odometer</th>
						<th>Immatriculation Date</th>
						<th>Seats Number</th>
						<th>Doors Number</th>
						<th>Color</th>

						<th>Fuel Type</th>
						<th>Horse Power</th>
						<th>Power</th>
						<th>Status</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${vehicles}" var="vehicle">
						<tr>
							<!-- <td><c:out value="${vehicle.id}" /></td>
					<td><c:out value="${vehicle.catalogVal}" /></td>
					<td><c:out value="${vehicle.residualVal}" /></td>
					<td><c:out value="${vehicle.transmission}" /></td>-->
							<td><c:out value="${vehicle.vehicleName}" /></td>
							<td><c:out value="${vehicle.modelName}" /></td>
							<td><c:out value="${vehicle.licensePlate}" /></td>
							<td><c:out value="${vehicle.chassisNumber}" /></td>
							<td><c:out value="${vehicle.modelYear}" /></td>
							<td><c:out value="${vehicle.lastOdometer}" /></td>
							<td><c:out value="${vehicle.immatriculationDate}" /></td>

							<td><c:out value="${vehicle.seatsNum}" /></td>
							<td><c:out value="${vehicle.doorsNum}" /></td>
							<td><c:out value="${vehicle.color}" /></td>
							<td><c:out value="${vehicle.fuelType}" /></td>
							<td><c:out value="${vehicle.horsePower}" /></td>
							<td><c:out value="${vehicle.power}" /></td>
							<td><c:out value="${vehicle.status}" /></td>
							<td align="center">
								<a href="editVehicle.html?id=${vehicle.id}" class="icon"><i class="fas fa-pencil-alt"></i></a>
								<a href="deleteVehicle.html?id=${vehicle.id}" class="icon"><i class="fas fa-trash-alt"></i></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#vehicleListTable').DataTable();
	});
</script>
</html>