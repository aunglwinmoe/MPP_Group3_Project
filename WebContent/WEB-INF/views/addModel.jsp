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
		<h3 class="page-title">Create Vehicle Model</h3>
		<form:form method="POST" action="/group3/saveModel.html" class="col-sm-4">
			<form:input path="id" value="${model.id}" type="hidden"/>
			<div class="form-group row">
				<form:label path="modelName" class="col-sm-5 col-form-label">Model name:</form:label>
				<div class="col-sm-7">
					<form:input path="modelName" value="${model.modelName}"  class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<form:label path="modelName" class="col-sm-5 col-form-label">Make:</form:label>
				<div class="col-sm-7">
					<form:select path="modelName" class="form-control">
						<c:forEach items="${makes}" var="make">
							<form:option value="${make.id}">${make.makeName}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<input type="submit" value="Submit" class="btn btn-primary mb-2"/>
		</form:form>
	</div>
</body>
</html>