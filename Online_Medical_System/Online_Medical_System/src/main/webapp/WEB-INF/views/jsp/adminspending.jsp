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
    <div class="grid-container">
    <table>
    <thead>
    <tr class="header">
    <th>Patient-Id<div>Patient-Id</div></th>
   
    <th>Date<div>Date</div></th>
    <th>Time<div>Time</div></th>
    <th>Symptoms<div>Symptoms</div></th>
    
    <th>Health Issue<div>Health Issue</div></th>
    <th>Consult Doctor<div>Consult Doctor</div></th>
    <th>Medical Report<div>Medical Report</div></th>
    <th>Status<div>Status</div></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${adpen}" var="element">    
  <tr>
    <td>${element.pid}</td>
   
    <td>${element.date}</td>
    <td>${element.time}</td>
    <td>${element.symptoms}</td>
    <td>${element.health_issue}</td>
    <td>${element.consultdoctor}</td>
    <td><a href = "/report/${element.pid}/">Reports</a></td>
    <td>${ element.status }</td>
    
  </tr>
</c:forEach>
        </tbody>
    </table>
    </div>
    </div>

