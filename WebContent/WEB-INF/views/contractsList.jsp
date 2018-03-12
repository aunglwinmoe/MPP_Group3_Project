<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="menu.jsp" />
<title>Vehicle Management System</title>
</head>
<body>
	<br />
	<h2 align="left">Contracts</h2>
	<br />

	<a href="addContract.html" class="btn btn-primary mb-2">Create</a>

	<c:if test="${!empty contracts}">
		<table class="table table-bordered" id="contractListTable">
			<thead>
				<tr>
					<th>Contract Type</th>
					<th>Odometer At Creation</th>
					<th>Invoice Date</th>
					<th>Contract Start Date</th>
					<th>Contract Expiration Date</th>
					<th>Contractor</th>
					<th>Vendor</th>
					<th>Rental Fees</th>
					<th>Terms And Conditions</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${contracts}" var="contract">
					<tr>
						<td><c:out value="${contract.contractTypeId}" /></td>
						<td><c:out value="${contract.odometerAtCreation}" /></td>
						<td><c:out value="${contract.invoiceDate}" /></td>
						<td><c:out value="${contract.contractStartDate}" /></td>
						<td><c:out value="${contract.contractExpDate}" /></td>
						<td><c:out value="${contract.contractorId}" /></td>
						<td><c:out value="${contract.vendorId}" /></td>
						<td><c:out value="${contract.rentalCost}" /></td>
						<td><c:out value="${contract.termsAndConditions}" /></td>

						<td align="center"><a
							href="editContract.html?id=${contract.id}">Edit</a> | <a
							href="deleteContract.html?id=${contract.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#contractListTable').DataTable();
	});
</script>
</html>