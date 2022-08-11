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
<form   action="/app_requestss/"  method = "post" enctype="multipart/form-data" id="form" class="validate">
div class ="left" >
<img src="img/appoints.jpg"></img>
</div>
<div class = "right">
<div style = "color:blue ;position:relative;left:190px; bottom:30px; font-size:25px;">Doctor Appointment</div>
<div class="form-field">
     <label for="text-input">Hospital </label>
    <select  style = "width:330px;" id="text-input" required readonly disable>
	                   	   <option value=${ app.hospname }>${ app.hospname }</option> 
	</select>
  </div>
<div class="form-field">
    <label for="full-name">Date </label>
    <input  id="full-name" value = ${ app.date } readonly disable required />
  </div>
  <div class="form-field">
    <label for="full-name">Time </label>
    <input value = ${ app.time } id="full-name" required  readonly disable />
  </div>
  
  <div class="form-field">
     <label for="text-input">symptoms</label>
    <input   id="text-input" value= ${ app.symptoms } required readonly disable/>
  </div>
  <div class="form-field">
     <label for="text-input">Health Issue</label>
    <select style = "width:330px;" id="text-input" readonly disable readonly >
    	<option value=${ app.health_issue }>${ app.health_issue }</option>
	</select>
  </div>
 <div class="form-field">
     <label for="text-input">Doctor</label>
     
    <select id="text-input" name = "consultdoctor" >
    						<c:forEach items="${dl}" var="element">  
	                   	   <option value= ${ element.mailed }>${ element.doctor_name }</option>
	                   	   </c:forEach>
						</select>
  </div>
  <div class="form-field">
    <label for="full-name">Patient report</label>
    <input type="file" name="file" id="full-name"  />
  </div>

  <div class="form-field">
    <label for=""></label>
    <input type="submit" name = "Book" value="Book" />
  </div>
  </div>
</form>
</body>
</html>