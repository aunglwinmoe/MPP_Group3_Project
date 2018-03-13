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
		<h3 class="page-title">Create Contract Type</h3>
		<form:form method="POST" action="/group3/saveContractType.html" class="col-sm-4 needs-validation" novalidate="true">
			<form:input path="id" value="${contractType.id}" type="hidden"/>
			<div class="form-group row">
				<form:label path="contractTypeName" class="col-sm-5 col-form-label">Name:</form:label>
				<div class="col-sm-7">
					<form:input path="contractTypeName" value="${contractType.contractTypeName}"  class="form-control" required="true"/>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid Contract Type.</div>
				</div>
			</div>
			<input type="submit" value="Submit" class="btn btn-primary mb-2"/>
		</form:form>
	</div>
</body>
</html>