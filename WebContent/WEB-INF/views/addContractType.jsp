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
	<h2>Add Contract Type Data</h2>
	<form:form method="POST" action="/group3/saveContractType.html" class="col-sm-4">
		<div class="form-group row">
			<form:label path="id" class="col-sm-5 col-form-label">Contract Type ID:</form:label>
			<div class="col-sm-7">
				<form:input path="id" value="${contractType.id}"
						readonly="true" class="form-control"/>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="contractTypeName" class="col-sm-5 col-form-label">Contract Type Name:</form:label>
			<div class="col-sm-7">
				<form:input path="contractTypeName" value="${contractType.contractTypeName}"  class="form-control"/>
			</div>
		</div>
		<input type="submit" value="Submit" class="btn btn-primary mb-2"/>
	</form:form>
</body>
</html>