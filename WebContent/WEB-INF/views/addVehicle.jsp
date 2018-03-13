<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="menu.jsp" />
<title></title>
</head>
<body>
	<div class="container">
		<h3 class="page-title">Vehicle</h3>
		<form:form method="POST" action="/group3/saveVehicle.html" class=" needs-validation" novalidate="true">
			<div class="row">
				<form:hidden path="id" />
				<div class="col-sm">


					<div class="form-group row">
						<form:label path="vehicleName" class="col-sm-5 col-form-label">Vehicle Name:</form:label>
						<div class="col-sm-7">
							<form:input path="vehicleName" value="${vehicle.vehicleName}"
<<<<<<< HEAD
								class="form-control" readonly="true" />
=======
								class="form-control" required="true"/>
							<div class="valid-feedback">Looks good!</div>
				    		<div class="invalid-feedback">Please enter a valid Vehicle name.</div>
						</div>
					</div>
					<div class="form-group row">
						<form:label path="vehicleName" class="col-sm-5 col-form-label">Vehicle Model:</form:label>
						<div class="col-sm-7">
							<form:select path="modelId" class="form-control" required="true">
								<c:forEach items="${models}" var="model">
									<option <c:if test="${model.id eq vehicle.modelId}">selected</c:if> value="${model.id}">${model.modelName}</option>
								</c:forEach>
							</form:select>
							<div class="valid-feedback">Looks good!</div>
				    		<div class="invalid-feedback">Please choose a Vehicle Model.</div>
>>>>>>> 2372f41de2e7cf8a4f80f8a80886293c99dd724b
						</div>
					</div>

					<div class="form-group row">
						<form:label path="licensePlate" class="col-sm-5 col-form-label">License Plate:</form:label>
						<div class="col-sm-7">
							<form:input path="licensePlate" value="${vehicle.licensePlate}"
<<<<<<< HEAD
								class="form-control" required="true" />
=======
								class="form-control" required="true" pattern="^[A-Z]{3}[0-9]{3}" placeholder="e.g ABC123"/>
								<div class="valid-feedback">Looks good!</div>
				    		<div class="invalid-feedback">Please enter a valid License Plate.</div>
>>>>>>> 2372f41de2e7cf8a4f80f8a80886293c99dd724b
						</div>
					</div>
					<div class="form-group row">
						<form:label path="chassisNumber" class="col-sm-5 col-form-label">Chassis Number:</form:label>
						<div class="col-sm-7">
							<form:input path="chassisNumber" value="${vehicle.chassisNumber}"
								class="form-control" required="true" />
						</div>
					</div>
					<div class="form-group row">
						<form:label path="modelYear" class="col-sm-5 col-form-label">Model Year:</form:label>
						<div class="col-sm-7">
							<form:input path="modelYear" value="${vehicle.modelYear}"
								class="form-control" required="true" />
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
							<fmt:formatDate pattern="yyyy-MM-dd"
								value="${vehicle.immatriculationDate}" var="immatriculationDate" />
							<form:input id="date" type="date" path="immatriculationDate"
								value="${immatriculationDate}" class="form-control" />
						</div>
					</div>

					<div class="form-group row">
						<form:label path="catalogVal" class="col-sm-5 col-form-label">Catalog Value:</form:label>
						<div class="col-sm-7">
							<form:input path="catalogVal" value="${vehicle.catalogVal}"
								class="form-control" />
						</div>
					</div>
				</div>
				<div class="col-sm">
					<div class="form-group row">
						<form:label path="residualVal" class="col-sm-5 col-form-label">Residual Value:</form:label>
						<div class="col-sm-7">
							<form:input path="residualVal" value="${vehicle.residualVal}"
								class="form-control" />
						</div>
					</div>
<<<<<<< HEAD

					<div class="form-group row">
						<form:label path="limitedOdometer" class="col-sm-5 col-form-label">Odometer Limit:</form:label>
						<div class="col-sm-7">
							<form:input path="limitedOdometer"
								value="${vehicle.limitedOdometer}" class="form-control"
								required="true" />
						</div>
					</div>
				</div>
				<div class="col-sm">
=======
>>>>>>> 2372f41de2e7cf8a4f80f8a80886293c99dd724b
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
					<div class="form-group row">
						<form:label path="status" class="col-sm-5 col-form-label">Status:</form:label>
						<div class="col-sm-7">
							<form:select path="status" class="form-control" required="true"
								multiple="false">
								<option <c:if test="${status}=='On Sold'">selected</c:if>
									value="On Sold">On Sold</option>
								<option <c:if test="${status}=='On Rent'">selected</c:if>
									value="On Rent">On Rent</option>
							</form:select>
						</div>
					</div>
				</div>
			</div>

			<center>
				<input type="submit" value="Save" class="btn btn-primary mb-2" />
			</center>

		</form:form>
	</div>
</body>
</html>