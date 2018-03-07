<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Vendors</title>
<jsp:include page="menu.jsp" />
</head>
<body>
<h1>List Vendors</h1>
<h3><a href="add.html">Add More Vendor</a></h3>

<c:if test="${!empty vendors}">
	<table align="left" border="1">
		<tr>
			<th>Vendor ID</th>
			<th>Vendor Name</th>
			<th>Vendor SSN</th>
			<th>Vendor Address</th>
		</tr>

		<c:forEach items="${vendors}" var="vendor">
			<tr>
				<td><c:out value="${vendor.id}"/></td>
				<td><c:out value="${vendor.name}"/></td>
				<td><c:out value="${vendor.ssn}"/></td>
				<td><c:out value="${vendor.address}"/></td>
				<td align="center"><a href="editVendor.html?id=${vendor.id}">Edit</a> | <a href="deleteVendor.html?id=${vendor.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>