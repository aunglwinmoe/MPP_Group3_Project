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
		<h3 class="page-title">Create Vendor</h3>
		<form:form method="POST" action="/group3/saveVendor.html" class="col-sm-4">
			<form:input path="id" value="${vendor.id}" type="hidden"/>
			<div class="form-group row">
				<form:label path="vendorName" class="col-sm-5 col-form-label">Vendor Name:</form:label>
				<div class="col-sm-7">
					<form:input path="vendorName" value="${vendor.vendorName}"  class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="title" class="col-sm-5 col-form-label">Title:</form:label>
				<div class="col-sm-7">
					<form:select path="title" class="form-control">
						<form:option value="Mr">Mr</form:option>
						<form:option value="Ms">Ms</form:option>
						<%-- <form:option value="Mrs">Mrs</form:option>
						<form:option value="Miss">Miss</form:option>
						<form:option value="Dr">Dr</form:option>
						<form:option value="Prof">Professor</form:option>
						<form:option value="Sir">Sir</form:option> --%>
					</form:select>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="ssn" class="col-sm-5 col-form-label">Vendor SSN:</form:label>
				<div class="col-sm-7">
					<form:input path="ssn" type="number" value="${vendor.ssn}" class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="phone" class="col-sm-5 col-form-label">Phone:</form:label>
				<div class="col-sm-7">
					<form:input path="phone" type="number" value="${vendor.phone}"  class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="email" class="col-sm-5 col-form-label">Email:</form:label>
				<div class="col-sm-7">
					<form:input path="email" value="${vendor.email}"  class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="address" class="col-sm-5 col-form-label">Vendor Address:</form:label>
				<div class="col-sm-7">
					<form:input path="address" value="${vendor.address}"  class="form-control"/>
				</div>
			</div>
			<input type="submit" value="Submit" class="btn btn-primary mb-2"/>
		</form:form>
	</div>
</body>
</html>