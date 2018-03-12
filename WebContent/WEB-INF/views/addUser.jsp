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
		<h3 class="page-title">Create User</h3>
		<form:form method="POST" action="/group3/saveUser.html" class="col-sm-5">
			<form:input path="id" value="${user.id}" type="hidden"/>
			<div class="form-group row">
				<form:label path="firstName" class="col-sm-5 col-form-label">First Name:</form:label>
				<div class="col-sm-7">
					<form:input path="firstName" value="${user.firstName}"  class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="lastName" class="col-sm-5 col-form-label">Last Name:</form:label>
				<div class="col-sm-7">
					<form:input path="lastName" value="${user.lastName}"  class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="userName" class="col-sm-5 col-form-label">User Name:</form:label>
				<div class="col-sm-7">
					<form:input path="userName" value="${user.userName}"  class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="dateOfBirth" class="col-sm-5 col-form-label">Date of Birth:</form:label>
				<div class="col-sm-7">
					<form:input path="dateOfBirth" type="date" value="${user.dateOfBirth}"  class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="password" class="col-sm-5 col-form-label">Password:</form:label>
				<div class="col-sm-7">
					<form:input path="password" type="password" value="${user.password}"  class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="password1" class="col-sm-5 col-form-label">Confirm password:</form:label>
				<div class="col-sm-7">
					<form:input path="password1" type="password" class="form-control"/>
				</div>
			</div>
			<input type="submit" value="Submit" class="btn btn-primary mb-2"/>
		</form:form>
	</div>
</body>
</html>