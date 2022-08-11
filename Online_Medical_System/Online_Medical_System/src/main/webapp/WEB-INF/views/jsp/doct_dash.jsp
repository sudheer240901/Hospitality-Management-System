<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String uname = (String) request.getSession().getAttribute("uname");
if (uname == null) {
%>
<jsp:forward page="index.jsp" />

<%
}
%>

<%@ include file="navbar.jsp" %>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/welcome.css">
<title>Insert title here</title>
</head>
<body>
<body>
	<div style = "padding:30px;"class="container">

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
<img src="/img/doctor-appointment-logo.jpg"></img>
<a href = "/view_patients/${uname}"><h2 style  = "color:blue;">View-Patients</h2></a>
</div>
</svg>
				
			</div>

	
			<div class="tile w1x1" id="hallway">
				<svg class="icosvg" xmlns="http://www.w3.org/2000/svg" width="48px"
					height="48px" viewBox="0 0 48 48">
<rect width="48" height="48" fill-opacity="0" />
<div>
<img src="/img/doctor-appointment-logo.jpg"></img>
<a href = "/adminpeending"><h2 style  = "color:blue;">Pending Appointments</h2></a>
</div>
</svg>
			</div>
			<div class="tile w1x1" id="hallway">
				<svg class="icosvg" xmlns="http://www.w3.org/2000/svg" width="48px"
					height="48px" viewBox="0 0 48 48">
<rect width="48" height="48" fill-opacity="0" />
<div>
<img src="/img/doctor-appointment-logo.jpg"></img>
<a href = "/Logout"><h2 style  = "color:blue;">Logout</h2></a>
</div>
</svg>
			</div>
		</div>
</body>

</body>
</html>