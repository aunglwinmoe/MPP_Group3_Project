<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="menu.jsp" />
<title></title>
</head>
<body>
	<div class="container">
		<h3 class="page-title">Create Service Log</h3>
		<form:form method="POST" action="/group3/saveServiceLog.html" class="needs-validation" novalidate="true">
			<div class="row">
				<form:input path="id" value="${serviceLog.id}" type="hidden"/>
				<div class="col-sm">
					<h5>Service Details</h5>
					<div class="form-group row">
						<form:label path="vehicleId" class="col-sm-5 col-form-label">Vehicle:</form:label>
						<div class="col-sm-7">
							<form:select path="vehicleId" class="form-control" required="true">
								<c:forEach items="${vehicles}" var="vehicle">
									<option <c:if test="${serviceLog.vehicleId eq vehicle.id}">selected</c:if> value="${vehicle.id}">${vehicle.vehicleName}</option>
								</c:forEach>
							</form:select>
							<div class="valid-feedback">Looks good!</div>
				    		<div class="invalid-feedback">Please choose a Vehicle.</div>
						</div>
					</div>
					<div class="form-group row">
						<form:label path="serviceTypeId" class="col-sm-5 col-form-label">Service Type:</form:label>
						<div class="col-sm-7">
							<form:select path="serviceTypeId" class="form-control" required="true">
								<c:forEach items="${serviceTypes}" var="serviceType">
									<option <c:if test="${serviceLog.serviceTypeId eq serviceType.id}">selected</c:if> value="${serviceType.id}">${serviceType.serviceTypeName}</option>
								</c:forEach>
							</form:select>
							<div class="valid-feedback">Looks good!</div>
				    		<div class="invalid-feedback">Please choose a Service Type.</div>
						</div>
					</div>
					<div class="form-group row">
						<form:label path="totalPrice" class="col-sm-5 col-form-label">Total Price:</form:label>
						<div class="col-sm-7">
							<form:input path="totalPrice" value="${serviceLog.totalPrice}" class="form-control" required="true"/>
							<div class="valid-feedback">Looks good!</div>
				    		<div class="invalid-feedback">Please enter a valid Total Price.</div>
						</div>
					</div>
				</div>
				<div class="col-sm">
					<h5>Odometer Details</h5>
					<div class="form-group row">
						<form:label path="odometerVal" class="col-sm-5 col-form-label">Odometer Value:</form:label>
						<div class="col-sm-7">
							<form:input path="odometerVal" value="${serviceLog.odometerVal}"
								class="form-control" required="true"/>
							<div class="valid-feedback">Looks good!</div>
				    		<div class="invalid-feedback">Please enter a valid Odometer Value.</div>	
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm">
					<h5>Additional Details</h5>
					<div class="form-group row">
						<form:label path="date" class="col-sm-5 col-form-label">Date:</form:label>
						<div class="col-sm-7">
							<fmt:formatDate pattern="yyyy-MM-dd" value="${serviceLog.date}"
								var="serviceLogDate" />
							<form:input id="date" type="date" path="date" value="${serviceLogDate}" class="form-control" required="true"/>
							<div class="valid-feedback">Looks good!</div>
				    		<div class="invalid-feedback">Please enter a Date.</div>
						</div>
					</div>
					<div class="form-group row">
						<form:label path="vendorId" class="col-sm-5 col-form-label">Vendor:</form:label>
						<div class="col-sm-7">
							<form:select path="vendorId" class="form-control" required="true">
								<c:forEach items="${vendors}" var="vendor">
									<option <c:if test="${serviceLog.vendorId eq vendor.id}">selected</c:if> value="${vendor.id}">${vendor.vendorName}</option>
								</c:forEach>
							</form:select>
							<div class="valid-feedback">Looks good!</div>
				    		<div class="invalid-feedback">Please choose a Vendor.</div>
						</div>
					</div>
					<div class="form-group row">
						<form:label path="invoiceRef" class="col-sm-5 col-form-label">Invoice Reference:</form:label>
						<div class="col-sm-7">
							<form:input path="invoiceRef" value="${serviceLog.invoiceRef}"
								class="form-control" required="true"/>
							<div class="valid-feedback">Looks good!</div>
				    		<div class="invalid-feedback">Please enter a valid Invoice Reference.</div>
						</div>
					</div>
				</div>
				<div class="col-sm"></div>
			</div>
			<input type="submit" value="Submit" class="btn btn-primary mb-2"/>
		</form:form>
	</div>
</body>
</html>