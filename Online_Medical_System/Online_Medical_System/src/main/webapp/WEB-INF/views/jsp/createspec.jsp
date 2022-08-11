<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "navbar.jsp" %>
<head>
<meta charset="ISO-8859-1">
<link rel = "stylesheet" href = "css/medical_report.css">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action = "/spectz" modelAttribute = "specs" id = "form" class = "validate">
<div class="form-field">
    <label for="full-name">Health Issue</label>
    <input type="text" name="healthissue" id="full-name" placeholder="Issue" required />
  </div>
    
  
  <div class="form-field">
    <label for="full-name">Specalization</label>
    <input type="text" name="spealist" id="full-name" placeholder="Specalist" required />
  </div>
  
    <div class="form-field">
    <label for=""></label>
    <input type="submit" value="Add" />
  </div>
  
</form>
</body>