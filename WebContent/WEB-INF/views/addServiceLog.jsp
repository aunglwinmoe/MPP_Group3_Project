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
		<h3 class="page-title">Create Service Log</h3>
		<form:form method="POST" action="/group3/saveServiceLog.html">
			<div class="row">
				<form:input path="id" value="${serviceLog.id}" type="hidden"/>
				<div class="col-sm">
					<h5>Service Details</h5>
					<div class="form-group row">
						<form:label path="vehicleId" class="col-sm-5 col-form-label">Vehicle:</form:label>
						<div class="col-sm-7">
							<form:select path="vehicleId" class="form-control">
								<c:forEach items="${vehicles}" var="vehicle">
									<form:option value="${vehicle.id}">${vehicle.vehicleName}</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="form-group row">
						<form:label path="serviceTypeId" class="col-sm-5 col-form-label">Service Type:</form:label>
						<div class="col-sm-7">
							<form:select path="serviceTypeId" class="form-control">
								<c:forEach items="${serviceTypes}" var="serviceType">
									<form:option value="${serviceType.id}">${serviceType.serviceTypeName}</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="form-group row">
						<form:label path="totalPrice" class="col-sm-5 col-form-label">Total Price:</form:label>
						<div class="col-sm-7">
							<form:input path="totalPrice" value="${serviceLog.totalPrice}"
								class="form-control" />
						</div>
					</div>
				</div>
				<div class="col-sm">
					<h5>Odometer Details</h5>
					<div class="form-group row">
						<form:label path="odometerVal" class="col-sm-5 col-form-label">Odometer Value:</form:label>
						<div class="col-sm-7">
							<form:input path="odometerVal" value="${serviceLog.odometerVal}"
								class="form-control" />
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
							<form:input id="date" type="date" path="date"
							value="${serviceLogDate}" class="form-control" />
						</div>
					</div>
					<div class="form-group row">
						<form:label path="vendorId" class="col-sm-5 col-form-label">Vendor:</form:label>
						<div class="col-sm-7">
							<form:select path="vendorId" class="form-control">
								<c:forEach items="${vendors}" var="vendor">
									<form:option value="${vendor.id}">${vendor.vendorName}</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="form-group row">
						<form:label path="invoiceRef" class="col-sm-5 col-form-label">Invoice Reference:</form:label>
						<div class="col-sm-7">
							<form:input path="invoiceRef" value="${serviceLog.invoiceRef}"
								class="form-control" />
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