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
	<div class = container>
		<form id="form" class="validate">
        <h1 style = "position:relative; left:200px; bottom:30px; font-family:Serif; color:black;">Medical Report</h1>
	  <c:forEach items="${medi_rep}" var="element">  
	  <div class="form-field">
				<label for=""><h2 style = "font-family:Serif;">Medicine</h2></label> <input type="text"
					name="medicine" value = ${element.medid.medicine } id= "" style = "width: 300px;" placeholder="medicine" readonly required />
			</div>
	<div class="form-field">
		<h2 style = "position:relative; left:70px; font-family:Serif;"> Timings : </h2>
		<c:if test = "${element.time.morning != null}">
		<h2 style =  " position:relative; left:110px; font-family:Serif; color:rgb(187, 255, 0);"> &nbsp;<i class="fas fa-check-square"></i> Morning &nbsp;</h2>
		</c:if>
		<c:if test = "${element.time.afternoon != null}">
		<h2 style = "position:relative; left:110px; font-family:Serif;color:rgb(187, 255, 0); "> &nbsp;<i class="fas fa-check-square"></i> Afternoon &nbsp;</h2>
		</c:if>
		<c:if test = "${element.time.night != null}">
		</i><h2 style = "position:relative; left:110px; font-family:Serif;color:rgb(187, 255, 0);">&nbsp;<i class="fas fa-moon"></i> Night </h2>
		</c:if>
	</div>
	  </c:forEach>  
	  	
	  	</form>
</div>
</body>
