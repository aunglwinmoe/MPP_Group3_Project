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
		<h3 class="page-title">Create model make of Vehicle</h3>
		<form:form method="POST" action="/group3/saveMake.html" class="col-sm-4 needs-validation" novalidate="true">
			<form:input path="id" value="${make.id}" type="hidden"/>		
			<div class="form-group row">
				<form:label path="makeName" class="col-sm-5 col-form-label">Make:</form:label>
				<div class="col-sm-7">
					<form:input path="makeName" value="${make.makeName}"  class="form-control" required="true"/>
					<div class="valid-feedback">Looks good!</div>
				    <div class="invalid-feedback">Please enter a valid Make name.</div>
				</div>
			</div>
			<input type="submit" value="Save" class="btn btn-primary mb-2"/>
		</form:form>
	</div>
</body>
</html>