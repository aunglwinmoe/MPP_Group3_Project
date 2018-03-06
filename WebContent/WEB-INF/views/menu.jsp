<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<h1 align="center">Vehicle Management System</h1>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Vehicle Management System</title>

<link rel="stylesheet" type="text/css" href="css/design.css">
<script language="JavaScript" type="text/JavaScript" src="css/design.js"></script>
</head>
<body>
	<div class="topnav" id="myTopnav">

		<div class="dropdown">
			<button class="dropbtn">
				Vehicles <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="vehicles.html">Vehicles</a> <a href="odometers.html">Vehicles Odometer</a> <a
					href="#">Vehicle Costs</a> <a href="#">Vehicle Contracts</a>
			</div>
		</div>

		<div class="dropdown">
			<button class="dropbtn">
				Logs <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="#">Vehicle Fuel Logs</a> <a href="#">Vehicles Services
					Logs</a>
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">
				Registration <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="vendors.html">Vendors</a> <a href="#">Users </a>
			</div>
		</div>

		<div class="dropdown">
			<button class="dropbtn">
				Configuration <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="#">Vehicle Model</a> <a href="#">Vehicle Brand/Make</a> <a
					href="#">Service Types</a><a href="#">Contract Type</a>
			</div>
		</div>

		<div class="dropdown">
			<button class="dropbtn">
				Reporting <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="#">Accident Report</a> <a href="#">Vehicle Costs</a>
			</div>
		</div>

		<a href="#mapping">Vehicle Unit Mapping</a> <a
			href="javascript:void(0);" class="icon" onclick="myFunction()">&#9776;</a>
	</div>

	
</body>
</html>