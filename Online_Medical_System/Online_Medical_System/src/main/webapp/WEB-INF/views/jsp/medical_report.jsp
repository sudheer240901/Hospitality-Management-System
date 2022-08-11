<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="navbar.jsp"%>
<head>
<script src="https://kit.fontawesome.com/291b208b59.js" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/medical_report.css">
<title>Insert title here</title>
</head>
<body>
	<div class= "heads">Medical Report</div>
		<form id="form" class="validate">
	  <c:forEach items="${med}" var="element">  
	  <div class="form-field">
				<label for=""><h2 style = "font-family:Serif;">Medicine</h2></label> <input type="text" style = "color:black;" name="medicine" value = ${element.medid.medicine } id="" placeholder="medicine" readonly required />
			</div>
	<div class="form-field">
		<h2 style = "position:relative; left:70px; font-family:Serif;"> Timings : </h2>&nbsp;
		<c:if test = "${element.time.morning != null}">
		<h2 style =  " position:relative; left:110px; font-family:Serif; color:rgb(187, 255, 0);"> &nbsp;<i class="fas fa-check-square"></i> Morning &nbsp;</h2>
		</c:if>
		<c:if test = "${element.time.afternoon != null}">
		<h2 style =  " position:relative; left:110px; font-family:Serif; color:rgb(187, 255, 0);"> &nbsp;<i class="fas fa-check-square"></i> Afternoon &nbsp;</h2>
		</c:if>
		<c:if test = "${element.time.night != null}">
		<h2 style =  " position:relative; left:110px; font-family:Serif; color:rgb(187, 255, 0);"> &nbsp; <i class="fas fa-moon"></i>Night &nbsp;</h2>
		</c:if>
	</div>
	  </c:forEach>  
	  	
	  	</form>
	<form method="post" action="/medical_report/${pid}" method="post"
		id="form" class="validate">
		
			<div class="form-field">
				<label for="text-input">Medicine</label> <input type="text"
					name="medicine" id="text-input" placeholder="medicine" required />
			</div>

			<div class="form-field">
				<input type="checkbox" id="time1" name="time" value="morning">
				<label for="time1"> Morning </label><br> <input type="checkbox"
					id="time2" name="time" value="afternoon"> <label
					for="time2"> Afternoon </label><br> <input type="checkbox"
					id="time3" name="time" value="night"> <label for="time3">Night</label><br>
				<br>
			</div>
			<div class="form-field">
				<label for=""></label> <input type="submit" name="Add" value="Add" />
			</div>
			<div class="form-field">
				<label for=""></label> <input type="submit" name="Submit Medical record" value="Submit Medical record" />
			</div>
			
	</form>
</body>
