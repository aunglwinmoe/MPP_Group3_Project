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
	<div class="container">
		<h3 class="page-title">Fuel Log</h3>
		<form:form method="POST" action="/group3/saveFuelLog.html"
			class="col-sm-4">

			<br />
			<form:hidden path="id" />
			<div class="form-group row">
				<form:label path="vehicleId" class="col-sm-5 col-form-label">Vehicle:</form:label>
				<div class="col-sm-7">
					<form:input path="vehicleId" value="${fuelLog.vehicleId}"
						class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="liter" class="col-sm-5 col-form-label">Liter:</form:label>
				<div class="col-sm-7">
					<form:input path="liter" value="${fuelLog.liter}"
						class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<form:label path="pricePerLiter" class="col-sm-5 col-form-label">Price Per Liter:</form:label>
				<div class="col-sm-7">
					<form:input path="pricePerLiter" value="${fuelLog.pricePerLiter}"
						class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="totalPrice" class="col-sm-5 col-form-label">Total Price:</form:label>
				<div class="col-sm-7">
					<form:input path="totalPrice" value="${fuelLog.totalPrice}"
						class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="date" class="col-sm-5 col-form-label">Date:</form:label>
				<div class="col-sm-7">
					<form:input path="date" value="${fuelLog.date}"
						class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="invoiceReference" class="col-sm-5 col-form-label">Invoice Reference:</form:label>
				<div class="col-sm-7">
					<form:input path="invoiceReference"
						value="${fuelLog.invoiceReference}" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="otherInfo" class="col-sm-5 col-form-label">Other Info:</form:label>
				<div class="col-sm-7">
					<form:input path="otherInfo" value="${fuelLog.otherInfo}"
						class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="vendorId" class="col-sm-5 col-form-label">Vendor:</form:label>
				<div class="col-sm-7">
					<form:input path="vendorId" value="${fuelLog.vendorId}"
						class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="purchaserId" class="col-sm-5 col-form-label">Purchaser:</form:label>
				<div class="col-sm-7">
					<form:input path="purchaserId" value="${fuelLog.purchaserId}"
						class="form-control" />
				</div>
			</div>
			<center>
				<input type="submit" value="Save" class="btn btn-primary mb-2" />
			</center>
		</form:form>
	</div>
</body>
</html>