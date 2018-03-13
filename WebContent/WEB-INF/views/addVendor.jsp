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
		<form:form method="POST" action="/group3/saveVendor.html" class="col-sm-5 needs-validation" novalidate="true">
			<form:input path="id" value="${vendor.id}" type="hidden"/>
			<div class="form-group row">
				<form:label path="vendorName" class="col-sm-5 col-form-label">Vendor Name:</form:label>
				<div class="col-sm-7">
					<form:input path="vendorName" value="${vendor.vendorName}"  class="form-control" required="true"/>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid Vendor Name.</div>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="title" class="col-sm-5 col-form-label">Title:</form:label>
				<div class="col-sm-7">
					<form:select path="title" class="form-control" required="true">
						<option <c:if test="${title}=='Mr'">selected</c:if> value="Mr">Mr</option>
						<option <c:if test="${title}=='Ms'">selected</c:if>value="Ms">Ms</option>
					</form:select>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid Make name.</div>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="ssn" class="col-sm-5 col-form-label">Vendor SSN:</form:label>
				<div class="col-sm-7">
					<form:input path="ssn" value="${vendor.ssn}" pattern="\d{10}" class="form-control" required="true"/>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid Vendor SSN.</div>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="phone" class="col-sm-5 col-form-label">Phone number:</form:label>
				<div class="col-sm-7">
					<form:input path="phone" value="${vendor.phone}" pattern="\d{10}" class="form-control" required="true"/>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid Phone number.</div>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="email" class="col-sm-5 col-form-label">Email:</form:label>
				<div class="col-sm-7">
					<form:input path="email" value="${vendor.email}" type="email" class="form-control" required="true"/>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid Email.</div>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="address" class="col-sm-5 col-form-label">Vendor Address:</form:label>
				<div class="col-sm-7">
					<form:input path="address" value="${vendor.address}" class="form-control" required="true"></form:input>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid Vendor Address.</div>
				</div>
			</div>
			<input type="submit" value="Submit" class="btn btn-primary mb-2"/>
		</form:form>
	</div>
</body>
</html>