<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file= "navbar.jsp" %>

<head>
<link rel="stylesheet" href="css/welcome.css">
</head>
<div class="mess">
	<h1>${ docts }</h1>
</div>
<body>

	<div class="container">

		<div class="overview">
			<div class="tile w1x3 inner-2x">
				<span>
					<h1>Welcome to medicine home,</h1>
					<h1 class="accent-text">${uname}</h1>
				</span>
				<div class="inner-2x">
					<span class="center"> </span>

				</div>
			</div>
			<div class="tile w1x1" id="livingroom">
				<svg class="icosvg" xmlns="http://www.w3.org/2000/svg" width="48px"
					height="48px" viewBox="0 0 48 48">
<rect width="48" height="48" fill-opacity="0" />
<div>
<img src="img/doctor-appointment-logo.jpg"></img>
<a href = "/doc_reg"><h2 style  = "color:blue;">Add Doctors</h2></a>
</div>
</svg>
				
			</div>

			<div class="tile w1x1" id="livingroom">
				<svg class="icosvg" xmlns="http://www.w3.org/2000/svg" width="48px"
					height="48px" viewBox="0 0 48 48">
<rect width="48" height="48" fill-opacity="0" />
<div>
<img src="img/doctor-appointment-logo.jpg"></img>
<a href = "/creaspec"><h2 style  = "color:blue;">Manage Specalization</h2></a>
</div>
</svg>
			</div>
			<div class="tile w1x1" id="hallway">
				<svg class="icosvg" xmlns="http://www.w3.org/2000/svg" width="48px"
					height="48px" viewBox="0 0 48 48">
<rect width="48" height="48" fill-opacity="0" />
<div>
	<img src="img/doctor-appointment-logo.jpg"></img>
	<a href = "/hospital_list"><h2 style  = "color:blue;">Manage Hospitals</h2></a>
</div>
</svg>
			</div>
			<div class="tile w1x1" id="hallway">
				<svg class="icosvg" xmlns="http://www.w3.org/2000/svg" width="48px"
					height="48px" viewBox="0 0 48 48">
<rect width="48" height="48" fill-opacity="0" />
<div>
<img src="/img/doctor-appointment-logo.jpg"></img>
<a href = "/adminpennding"><h2 style  = "color:blue;">Pending Appointments</h2></a>
</div>
</svg>
			</div>
		</div>
</body>
</html>