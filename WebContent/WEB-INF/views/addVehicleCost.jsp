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
		<h3 class="page-title">Vehicle Cost</h3>
		<form:form method="POST" action="/group3/saveVehicleCost.html"
			class="col-sm-4 needs-validation" novalidate="true">

			<form:hidden path="id" />
			<div class="form-group row">
				<form:label path="vehicleId" class="col-sm-5 col-form-label">Vehicle:</form:label>
				<div class="col-sm-7">
					<form:select path="vehicleId" class="form-control" required="true">
						<c:forEach items="${vehicles}" var="vehicle">
							<option <c:if test="${vehicle.id eq vehiclecost.vehicleId}">selected</c:if> value="${vehicle.id}">${vehicle.vehicleName}</option>
						</c:forEach>
					</form:select>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please choose a Vehicle.</div>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="vehicleId" class="col-sm-5 col-form-label">Service Type:</form:label>
				<div class="col-sm-7">
					<form:select path="serviceTypeId" class="form-control" required="true">
						<c:forEach items="${servicetypes}" var="servicetype">
							<option <c:if test="${servicetype.id eq vehiclecost.serviceTypeId}">selected</c:if> value="${servicetype.id}">${servicetype.serviceTypeName}</option>
						</c:forEach>
					</form:select>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please choose a Service Type.</div>
				</div>
			</div>

			<div class="form-group row">
				<form:label path="date" class="col-sm-5 col-form-label">Date:</form:label>
				<div class="col-sm-7">
					<fmt:formatDate pattern="yyyy-MM-dd" value="${vehiclecost.date}"
						var="vehiclecostDate" />
					<form:input id="date" type="date" path="date"
						value="${vehiclecostDate}" class="form-control" required="true"/>
						<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid Date.</div>
				</div>
			</div>


			<div class="form-group row">
				<form:label path="totalPrice" class="col-sm-5 col-form-label">Total Price:</form:label>
				<div class="col-sm-7">
					<form:input path="totalPrice" value="${vehiclecost.totalPrice}"
						class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<form:label path="costDesc" class="col-sm-5 col-form-label">Cost Description:</form:label>
				<div class="col-sm-7">
					<form:input path="costDesc" value="${vehiclecost.costDesc}"
						class="form-control" />
				</div>
			</div>

			<input type="submit" value="Save" class="btn btn-primary mb-2" />
		</form:form>
	</div>
</body>
</html>