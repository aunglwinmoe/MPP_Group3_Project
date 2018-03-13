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
		<h3 class="page-title">Create User</h3>
		<form:form method="POST" action="/group3/saveUser.html" class="col-sm-5 needs-validation" novalidate="true">
			<form:input path="id" value="${user.id}" type="hidden"/>
			<div class="form-group row">
				<form:label path="firstName" class="col-sm-5 col-form-label">First Name:</form:label>
				<div class="col-sm-7">
					<form:input path="firstName" value="${user.firstName}"  class="form-control" required="true"/>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid First Name.</div>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="lastName" class="col-sm-5 col-form-label">Last Name:</form:label>
				<div class="col-sm-7">
					<form:input path="lastName" value="${user.lastName}"  class="form-control" required="true"/>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid Last Name.</div>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="userName" class="col-sm-5 col-form-label">User Name:</form:label>
				<div class="col-sm-7">
					<form:input path="userName" value="${user.userName}"  class="form-control" required="true"/>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid User Name.</div>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="dateOfBirth" class="col-sm-5 col-form-label">Date of Birth:</form:label>
				<div class="col-sm-7">
					<fmt:formatDate pattern="yyyy-MM-dd" value="${user.dateOfBirth}" var="date" />
					<form:input id="dateOfBirth" type="date" path="dateOfBirth"
						value="${date}" class="form-control" required="true"/>
						<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid date.</div>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="password" class="col-sm-5 col-form-label">Password:</form:label>
				<div class="col-sm-7">
					<form:input path="password" id="inputPassword" type="password" value="${user.password}"  class="form-control" required="true"/>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid Password.</div>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-5 col-form-label">Confirm password:</label>
				<div class="col-sm-7">
					<input type="password" class="form-control" id="inputPasswordConfirm" required="true"/>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please retype your password.</div>
				</div>
			</div>
			<input type="submit" value="Save" class="btn btn-primary mb-2"/>
		</form:form>
	</div>
	<script>
	var password = document.getElementById("inputPassword"), confirm_password = document.getElementById("inputPasswordConfirm");

	function validatePassword(){
	  if(password.value != confirm_password.value) {
	    confirm_password.setCustomValidity("Passwords Don't Match");
	  } else {
	    confirm_password.setCustomValidity('');
	  }
	}

	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
	</script>
</body>
</html>