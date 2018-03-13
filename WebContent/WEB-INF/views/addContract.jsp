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
		<h3 class="page-title">Vehicle Contract</h3>
		<form:form method="POST" action="/group3/saveContract.html"
			class="col-sm-6 needs-validation" novalidate="true">

			<form:hidden path="id" />

			<div class="form-group row">
				<form:label path="vehicleId" class="col-sm-5 col-form-label">Vehicle:</form:label>
				<div class="col-sm-7">
					<form:select path="vehicleId" class="form-control" required="true">
						<c:forEach items="${vehicles}" var="vehicle">
							<option <c:if test="${vehicle.id eq contract.vehicleId}">selected</c:if> value="${vehicle.id}">${vehicle.vehicleName}</option>
						</c:forEach>
					</form:select>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please choose a Vehicle.</div>
				</div>
			</div>

			<div class="form-group row">
				<form:label path="contractTypeId" class="col-sm-5 col-form-label">Contract Type:</form:label>
				<div class="col-sm-7">
					<form:select path="contractTypeId" class="form-control">
						<c:forEach items="${contracttypes}" var="contracttype">
							<option <c:if test="${contracttype.id eq contract.contractTypeId}">selected</c:if> value="${contracttype.id}">${contracttype.contractTypeName}</option>
						</c:forEach>
					</form:select>
				</div>
			</div>

			<div class="form-group row">
				<form:label path="odometerAtCreation"
					class="col-sm-5 col-form-label">Odometer At Creation:</form:label>
				<div class="col-sm-7">
					<form:input path="odometerAtCreation"
						value="${contract.odometerAtCreation}" class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<form:label path="invoiceDate" class="col-sm-5 col-form-label">Invoice Date:</form:label>
				<div class="col-sm-7">
					<fmt:formatDate pattern="yyyy-MM-dd"
						value="${contract.invoiceDate}" var="invDate" />
					<form:input id="invoiceDate" type="date" path="invoiceDate"
						value="${invDate}" class="form-control" required="true"/>
						<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid Invoice Date.</div>
				</div>
			</div>

			<div class="form-group row">
				<form:label path="contractStartDate" class="col-sm-5 col-form-label">Contract Start Date:</form:label>
				<div class="col-sm-7">
					<fmt:formatDate pattern="yyyy-MM-dd"
						value="${contract.contractStartDate}" var="contractSDate" />
					<form:input id="contractStartDate" type="date"
						path="contractStartDate" value="${contractSDate}"
						class="form-control" required="true"/>
						<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid Contract Start Date.</div>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="contractExpDate" class="col-sm-5 col-form-label">Contract Expiration Date:</form:label>
				<div class="col-sm-7">
					<fmt:formatDate pattern="yyyy-MM-dd"
						value="${contract.contractExpDate}" var="contractExpirationDate" />
					<form:input id="contractExpDate" type="date" path="contractExpDate"
						value="${contractExpirationDate}" class="form-control" required="true"/>
						<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid Contract Expiration Date.</div>
				</div>
			</div>

			<div class="form-group row">
				<form:label path="contractorId" class="col-sm-5 col-form-label">Contractor:</form:label>
				<div class="col-sm-7">
					<form:input path="contractorId" value="${contract.contractorId}"
						class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="vendorId" class="col-sm-5 col-form-label">Vendor:</form:label>
				<div class="col-sm-7">
					<form:select path="vendorId" class="form-control" required="true">
						<c:forEach items="${vendors}" var="vendor">
							<option <c:if test="${vendor.id eq contract.vendorId}">selected</c:if> value="${vendor.id}">${vendor.vendorName}</option>
						</c:forEach>
					</form:select>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please choose a Vendor.</div>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="rentalCost" class="col-sm-5 col-form-label">Rental Fees:</form:label>
				<div class="col-sm-7">
					<form:input path="rentalCost" value="${contract.rentalCost}"
						class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="termsAndConditions"
					class="col-sm-5 col-form-label">Terms And Conditions:</form:label>
				<div class="col-sm-7">
					<form:textarea path="termsAndConditions"
						value="${contract.termsAndConditions}" class="form-control" />
				</div>
			</div>

			<center>
				<input type="submit" value="Save" class="btn btn-primary mb-2" />
			</center>
		</form:form>
	</div>
</body>
</html>