<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="menu.jsp" />
<title></title>
</head>
<body>
	<div class="container">
		<h3 class="page-title">Odometer</h3>
		<form:form method="POST" action="/group3/saveOdometer.html"
			class="col-sm-4">

			<form:hidden path="id" />

			<div class="form-group row">
				<form:label path="vehicleId" class="col-sm-5 col-form-label">Vehicle:</form:label>
				<div class="col-sm-7">
					<form:select path="vehicleId" class="form-control">
						<c:forEach items="${vehicles}" var="vehicle">
							<form:option value="${vehicle.id}">${vehicle.vehicleName}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>

			<div class="form-group row">
				<form:label path="odometerVal" class="col-sm-5 col-form-label">Odometer:</form:label>
				<div class="col-sm-7">
					<form:input path="odometerVal" value="${odometer.odometerVal}"
						class="form-control" />
				</div>
			</div>

			<div class="form-group row">
				<form:label path="date" class="col-sm-5 col-form-label">Date:</form:label>
				<div class="col-sm-7">
					<fmt:formatDate pattern="yyyy-MM-dd" value="${odometer.date}"
						var="odometerDate" />
					<form:input id="date" type="date" path="date"
						value="${odometerDate}" class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="status" class="col-sm-5 col-form-label">Status:</form:label>
				<div class="col-sm-7">
					<form:input path="status" value="${odometer.status}"
						class="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<form:label path="chkService" class="col-sm-5 col-form-label"></form:label>
				<div class="col-sm-7">
					<jstl:if test="${odometer.chkService}">
						<form:checkbox path="chkService" checked="checked" label="Service"
							disabled="true" />
					</jstl:if>
					<jstl:if test="${!odometer.chkService}">
						<form:checkbox path="chkService" label="Service" />
					</jstl:if>

				</div>
			</div>

			<center>
				<input type="submit" value="Save" class="btn btn-primary mb-2" />
			</center>

			<jsp:useBean id="odometer" class="edu.mum.group3.bean.OdometerBean">
				<jsp:setProperty name="odometer" property="status"
					value="${odometer.status}" />
			</jsp:useBean>

			<p>
				Student First Name:
				<jsp:getProperty name="odometer" property="status" />
			</p>

		</form:form>
	</div>





</body>
<script>
	function changeValueCheckbox(element) {
		if (element.checked) {
			element.value = 1;
		} else {
			element.value = 0;
		}
	}
</script>
</html>