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
	<form:form method="POST" action="/group3/saveVendor.html">
		<table>
			<tr>
				<td><form:label path="vendorId">Vendor ID:</form:label></td>
				<td><form:input path="vendorId" value="${vendor.vendorId}"
						readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="vendorName">Vendor Name:</form:label></td>
				<td><form:input path="vendorName" value="${vendor.vendorName}" /></td>
			</tr>
			<tr>
				<td><form:label path="ssn">Vendor SSN:</form:label></td>
				<td><form:input path="ssn" value="${vendor.ssn}" /></td>
			</tr>

			<tr>
				<td><form:label path="address">Vendor Address:</form:label></td>
				<td><form:input path="address" value="${vendor.address}" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" value="Male">Male
					<input type="radio" name="gender" value="Female">Female</td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><select name="gender"><option>Male</option>
						<option>Female</option></select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>