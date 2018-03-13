<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/design.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/datatables/datatables.css">
<script type="text/JavaScript" src="css/design.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
<script type="text/javascript" charset="utf8" src="css/datatables/datatables.js"></script>
<script type="text/javascript" charset="utf8" src="css/fontawesome/fontawesome-all.min.js"></script>
<script type="text/javascript" charset="utf8" src="css/bootstrap/js/bootstrap.min.js"></script>
<title>Vehicle Management System</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-md-center" style="margin-top:200px">
			<div class="login_logo"></div>
			<form:form method="POST" action="/group3/menu.html" class="col-sm-4">
				<div class="form-group row">
					<label class="col-sm-5 col-form-label">User Name:</label> 
					<div class="col-sm-7">
						<input type="text" name="textfield" size="17" class="form-control" required/>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-5 col-form-label">Password:</label>
					<div class="col-sm-7"> 
						<input type="password" name="textfield" size="17"  class="form-control" required/>
					</div>
				</div>
				<input type="submit" value="Login" class="btn btn-primary mb-2" onClick="document.location.href='index.html'" />
			</form:form>
		</div>
	</div>
</body>
</html>