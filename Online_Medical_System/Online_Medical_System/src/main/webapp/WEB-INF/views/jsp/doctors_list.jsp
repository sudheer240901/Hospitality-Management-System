<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <% String unme =(String) request.getSession().getAttribute("uname");
	if (unme ==null)
	{
		%>
	<jsp:forward page = "index.jsp" />

	<% 
	}
	%>
<%@ include file = "navbar.jsp" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="/css/list.css">
</head>
<body>
<div class="grid">
<div style = "position:relative; bottom:100px;left:600px;  font-size:25px; "><a style = "color:red; text-decoration: none;" href = "/creation" >Add Hospitals </a></div>
    <div class="grid-container">
    
    <table>
    <thead>
    <tr class="header">
    <th>Hcode<div>Hcode</div></th>
    <th>Hospital Name<div>Hospital Name</div></th>
    <th>Doctor Name<div>Doctor Name</div></th>
    <th>Specalist<div>Specalist</div></th>
    <th>Mail<div>Mail</div></th>
    <th>Patients<div>Patients</div></th>

    
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ds}" var="element">    
  <tr>
    <td>${element.hcode}</td>
   
    <td>${element.hospname}</td>
    <td>${element.doctor_name}</td>
    <td>${element.specalist}</td>
    <td>${element.mailed}</td>
    <td><a href = "/view_patients/${element.mailed}/">Patients</a></td>
  </tr>
</c:forEach>
        </tbody>
    </table>
    </div>
    </div>

