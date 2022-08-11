<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "navbar.jsp" %>
<%@page isELIgnored="false" %>
<% String uuname =(String) request.getSession().getAttribute("uname");
if (uuname ==null)
{
%>
<jsp:forward page = "index.jsp" />
<% 
}
%>
<head>
<meta charset="ISO-8859-1">
<link rel = "stylesheet" href = "css/doctor_creation.css">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/app_request" modelAttribute = "appo" method = "post" id="form" class="validate">
<div class ="left" >
<img src="img/appoints.jpg"></img>
</div>
<div class = "right">
<div style = "color:blue ;position:relative;left:190px; bottom:30px; font-size:25px;">Doctor Appointment</div>
<div class="form-field">
     <label for="text-input">Hospital</label>
    <select style = "width:350px;" id="text-input" name="hospname">
    						<c:forEach items="${hosps}" var="element">  
	                   	   <option value=${ element }>${ element }</option>
	                   	   </c:forEach>
	                   	  
						</select>
  </div>
<div class="form-field">
    <label for="full-name">Appointment Date</label>
    <input type="Date" name="date" min="2022-01-01" max="2023-01-31" id="full-name"  required />
  </div>
  <div class="form-field">
    <label for="full-name">Time</label>
    <input type="time" name="time" id="full-name" required />
  </div>
  
  <div class="form-field">
     <label for="text-input">Symptoms</label>
    <input type="text" name="symptoms"  id="text-input" placeholder="subject" required />
  </div>
  <div class="form-field">
     <label for="text-input">Health Issue</label>
    <select style = "width:330px;" id="text-input" name="health_issue">
    						<c:forEach items="${ss}" var="element">  
	                   	   <option value=${ element.spealist }>${ element.healthissue }</option>
	                   	   </c:forEach>
	                   	  
						</select>
  </div>
  
  <div class="form-field">
    <label for=""></label>
    <input type="submit" name = "Next" value="Next" />
  </div>
  </div>
</form>

</body>



</html>