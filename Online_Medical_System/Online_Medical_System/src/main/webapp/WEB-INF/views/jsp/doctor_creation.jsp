<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "navbar.jsp" %>
<head>
<meta charset="ISO-8859-1">
<link rel = "stylesheet" href = "css/medical_report.css">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/creation" modelAttribute = "doct" method = "post" id="form" class="validate">
<div>Doctor Registration</div>
<div class="form-field">
    <label for="full-name">Full Name</label>
    <input type="text" name="doctor_name" id="full-name" placeholder="Doct Name" required />
  </div>
    
  
  <div class="form-field">
   <label for="text-input">Health Issue</label>
    <select style = "width = 150px;" id="text-input" name="specalist" >
    						<c:forEach items="${ss}" var="element">  
	                   	   <option value=${ element.spealist }>${ element.spealist }</option>
	                   	   </c:forEach>
	 </select>
  </div>
  
  <div class="form-field">
    <label for="email-input">mail To : </label>
    <input type="email" name="mailed" id="email-input" placeholder="example@gmail.com" required />
  </div>
  <div class="form-field">
     <label for="text-input">mail Subject</label>
    <input type="text" name="mail_subject" id="text-input" placeholder="subject" required />
  </div>
  <div class="form-field">
     <label for="text-input">mail Content</label>
    <input type="text" name="mail_content" id="text-input" placeholder="subject" required />
  </div>
  
  <div class="form-field">
    <label for=""></label>
    <input type="submit" value="Add Doctor" />
  </div>
</form>
</body>
