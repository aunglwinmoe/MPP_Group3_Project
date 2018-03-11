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
	<h2>Add Vendor Data</h2>
	<form:form method="POST" action="/group3/saveVendor.html" class="col-sm-4">
		<div class="form-group row">
			<form:label path="id" class="col-sm-5 col-form-label">Vendor ID:</form:label>
			<div class="col-sm-7">
				<form:input path="id" value="${vendor.id}"
						readonly="true"  class="form-control"/>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="vendorName" class="col-sm-5 col-form-label">Vendor Name:</form:label>
			<div class="col-sm-7">
				<form:input path="vendorName" value="${vendor.vendorName}"  class="form-control"/>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="title" class="col-sm-5 col-form-label">Title:</form:label>
			<div class="col-sm-7">
				<select name="title" class="form-control">
						<option>Mr.</option>
						<option>Ms.</option>
				</select>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="ssn" class="col-sm-5 col-form-label">Vendor SSN:</form:label>
			<div class="col-sm-7">
				<form:input path="ssn" value="${vendor.ssn}" class="form-control"/>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="jobPosition" class="col-sm-5 col-form-label">Job Position:</form:label>
			<div class="col-sm-7">
				<form:input path="jobPosition" value="${vendor.jobPosition}"  class="form-control"/>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="phone" class="col-sm-5 col-form-label">Phone:</form:label>
			<div class="col-sm-7">
				<form:input path="phone" value="${vendor.phone}"  class="form-control"/>
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
</body>
</html>