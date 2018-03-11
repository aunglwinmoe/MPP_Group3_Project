<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="menu.jsp" />
<title></title>
</head>
<body>
	<h2>Add Vehicle Data</h2>
	<form:form method="POST" action="/group3/saveVehicle.html"
		class="col-sm-4">
		<div class="form-group row">
			<form:label path="id" class="col-sm-5 col-form-label">Vehicle ID:</form:label>
			<div class="col-sm-7">
				<form:input path="id" value="${vehicle.id}" readonly="true"
					class="form-control" />
			</div>
		</div>


		<div class="form-group row">
			<form:label path="vehicleName" class="col-sm-5 col-form-label">Vehicle Name:</form:label>
			<div class="col-sm-7">
				<form:input path="vehicleName" value="${vehicle.vehicleName}"
					class="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<form:label path="licensePlate" class="col-sm-5 col-form-label">licensePlate:</form:label>
			<div class="col-sm-7">
				<form:input path="licensePlate" value="${vehicle.licensePlate}"
					class="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<form:label path="chassisNumber" class="col-sm-5 col-form-label">Chassis Number:</form:label>
			<div class="col-sm-7">
				<form:input path="chassisNumber" value="${vehicle.chassisNumber}"
					class="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<form:label path="modelYear" class="col-sm-5 col-form-label">Model Year:</form:label>
			<div class="col-sm-7">
				<form:input path="modelYear" value="${vehicle.modelYear}"
					class="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<form:label path="lastOdometer" class="col-sm-5 col-form-label">Last Odometer:</form:label>
			<div class="col-sm-7">
				<form:input path="lastOdometer" value="${vehicle.lastOdometer}"
					class="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<form:label path="immatriculationDate"
				class="col-sm-5 col-form-label">Immatriculation Date:</form:label>
			<div class="col-sm-7">
				<form:input path="immatriculationDate"
					value="${vehicle.immatriculationDate}" class="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<form:label path="catalogVal" class="col-sm-5 col-form-label">Catalog Value:</form:label>
			<div class="col-sm-7">
				<form:input path="catalogVal" value="${vehicle.catalogVal}"
					class="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<form:label path="residualVal" class="col-sm-5 col-form-label">Residual Value:</form:label>
			<div class="col-sm-7">
				<form:input path="residualVal" value="${vehicle.residualVal}"
					class="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<form:label path="seatsNum" class="col-sm-5 col-form-label">Seats Number:</form:label>
			<div class="col-sm-7">
				<form:input path="seatsNum" value="${vehicle.seatsNum}"
					class="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<form:label path="doorsNum" class="col-sm-5 col-form-label">Doors Number:</form:label>
			<div class="col-sm-7">
				<form:input path="doorsNum" value="${vehicle.doorsNum}"
					class="form-control" />
			</div>
		</div>

		<div class="form-group row">
			<form:label path="color" class="col-sm-5 col-form-label">Color:</form:label>
			<div class="col-sm-7">
				<form:input path="color" value="${vehicle.color}"
					class="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<form:label path="transmission" class="col-sm-5 col-form-label">Transmission:</form:label>
			<div class="col-sm-7">
				<form:input path="transmission" value="${vehicle.transmission}"
					class="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<form:label path="fuelType" class="col-sm-5 col-form-label">Fuel Type:</form:label>
			<div class="col-sm-7">
				<form:input path="fuelType" value="${vehicle.fuelType}"
					class="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<form:label path="horsePower" class="col-sm-5 col-form-label">Horse Power:</form:label>
			<div class="col-sm-7">
				<form:input path="horsePower" value="${vehicle.horsePower}"
					class="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<form:label path="power" class="col-sm-5 col-form-label">Power:</form:label>
			<div class="col-sm-7">
				<form:input path="power" value="${vehicle.power}"
					class="form-control" />
			</div>
		</div>

		<center>
			<input type="submit" value="Save" class="btn btn-primary mb-2" />
		</center>

	</form:form>
</body>
</html>