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
<form method="post" action="/hospital" modelAttribute = "hosp" method = "post" id="form" class="validate">
<div>Add Hospital</div>
<div class="form-field">
    <label for="full-name">Hospital Code</label>
    <input type="text" name="hcode" id="full-name" placeholder="hospital code" required />
  </div>
<div class="form-field">
    <label for="full-name">Hospital Name</label>
    <input type="text" name="hospname" id="full-name" placeholder="Hospital Name" required />
  </div>

  <div class="form-field">
   <label for="text-input">Hospital Address</label>
   <input type="text" name="hospadd" id="full-name" placeholder="Hospital Address" required />
  </div>
  
  <div class="form-field">
    <label for="">No of doctors</label>
    <input type="number" name="nodoctors" id="" placeholder="no-of-doctors" required />
  </div>
  <div class="form-field">
    <label for=""></label>
    <input type="submit" value="Add Hospital" />
  </div>
</form>
</body>
