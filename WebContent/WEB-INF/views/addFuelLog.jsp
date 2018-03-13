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
		<h3 class="page-title">Fuel Log</h3>
		<form:form method="POST" action="/group3/saveFuelLog.html"
			class="col-sm-6 needs-validation" novalidate="true">

			<br />
			<form:hidden path="id" />
			<div class="form-group row">
				<form:label path="vehicleId" class="col-sm-5 col-form-label">Vehicle:</form:label>
				<div class="col-sm-7">
					<form:select path="vehicleId" class="form-control" required="true">
						<c:forEach items="${vehicles}" var="vehicle">
							<option <c:if test="${vehicle.id eq fuelLog.vehicleId}">selected</c:if> value="${vehicle.id}">${vehicle.vehicleName}</option>
						</c:forEach>
					</form:select>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please choose a Vehicle.</div>
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
					<fmt:formatDate pattern="yyyy-MM-dd" value="${fuelLog.date}"
						var="fuelLogDate" />
					<form:input id="date" type="date" path="date"
						value="${fuelLogDate}" class="form-control" required="true"/>
						<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid Date.</div>
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
					<form:select path="vendorId" class="form-control" required="true">
						<c:forEach items="${vendors}" var="vendor">
							<option <c:if test="${vendor.id eq fuelLog.vendorId}">selected</c:if> value="${vendor.id}">${vendor.vendorName}</option>
						</c:forEach>
					</form:select>
				</div>
			</div> 
			<center>
				<input type="submit" value="Save" class="btn btn-primary mb-2" />
			</center>
		</form:form>
	</div>
</body>
</html>