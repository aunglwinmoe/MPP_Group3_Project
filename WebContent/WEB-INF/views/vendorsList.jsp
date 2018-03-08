<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Vendors</title>
<jsp:include page="menu.jsp" />
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>

<link rel="stylesheet" type="text/css" href="DataTables/datatables.css">

<script type="text/javascript" charset="utf8"
	src="DataTables/datatables.js"></script>
</head>
<body>
	<h1>List Vendors</h1>
	<a href="addVendor.html" class="btn btn-primary mb-2">Add More
		Vendor</a>

	<c:if test="${!empty vendors}">
		<table class="table table-bordered" id="vendorListTable">
			<thead>
				<tr>
					<th>Vendor ID</th>
					<th>Name</th>
					<th>Title</th>
					<th>SSN</th>
					<th>Job Position</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Address</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${vendors}" var="vendor">
					<tr>
						<td><c:out value="${vendor.id}" /></td>
						<td><c:out value="${vendor.vendorName}" /></td>
						<td><c:out value="${vendor.title}" /></td>
						<td><c:out value="${vendor.ssn}" /></td>
						<td><c:out value="${vendor.jobPosition}" /></td>
						<td><c:out value="${vendor.phone}" /></td>
						<td><c:out value="${vendor.email}" /></td>
						<td><c:out value="${vendor.address}" /></td>
						<td align="center"><a href="editVendor.html?id=${vendor.id}">Edit</a>
							| <a href="deleteVendor.html?id=${vendor.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
<script type="text/javascript">
	$(document).ready(
			function() {
				$('#vendorListTable').DataTable();

				var $submit = $("#submit_prog").hide(), $cbs = $(
						'input[name="prog"]').click(function() {
					$submit.toggle($cbs.is(":checked"));
				});

				$cball = $('input[name="checkall"]').click(function() {
					$submit.toggle($cball.is(":checked"));
				});

				$("#checkAll").change(
						function() {
							$("input:checkbox").prop('checked',
									$(this).prop("checked"));
						});
			});
</script>
</html>