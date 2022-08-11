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
<div style = "position:relative; bottom:100px;left:600px;  font-size:25px; "><a style = "color:red; text-decoration: none;" href = "/hospital_cre" >Add Hospitals </a></div>
    <div class="grid-container">
    
    <table>
    <thead>
    <tr class="header">
    <th>Hcode<div>Hcode</div></th>
    <th>Hospital Name<div>Hospital Name</div></th>
    <th>Hospital Address<div>Hospital Address</div></th>
    <th>Doctors<div>Doctors</div></th>
    <th>Count(Doctors)<div>Count(Doctors)</div></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hs}" var="elements">    
  <tr>
    <td>${elements.hcode}</td>
    <td>${elements.hospname}</td>
    <td>${elements.hospadd}</td>
    <td><a href = "/doctors/${elements.hcode}/">Doctors</a></td>
    <td>${elements.nodoctors}</td>
  </tr>
</c:forEach>
        </tbody>
    </table>
    </div>
    </div>

