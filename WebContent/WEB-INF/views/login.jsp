<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form>
			<div id="logo-container"></div>
			<div style="margin-left: 400px; margin-top: 20px;">
				<label style="margin-right: 104px;">User Name</label> <input
					type="text" name="textfield" size="17" id="userName" />
			</div>

			<div style="margin-left: 410px; margin-top: 20px;">
				<label style="margin-right: 104px;">Password</label> <input
					type="text" name="textfield" size="17" id="password" />
			</div>

			<div style="margin-left: 585px; margin-top: 20px;">
				<input type="submit" value="Login" class="login_button" 
					onclick="javascript:validate()" />
			</div>

		</form>
	</div>
</body>
<script type="text/javascript">
	function validate() {
		if (document.getElementById("userName").value == "admin"
				&& document.getElementById("password").value == "admin") {
			alert("validation succeeded");
			location.href = "run.html";
		} else {
			alert("validation failed");
			location.href = "fail.html";
		}
	}
</script>
</html>