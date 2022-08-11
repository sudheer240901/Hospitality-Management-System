<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/css/navbar.css">
<header>
  <nav>
    <h1 class="logo"><a href="" style = "text-decoration: none;">CREDI-HEALTH  </a></h1>
    <ul>
    <% String usname =(String) request.getSession().getAttribute("uname");
if (usname == null)
{
	%>
   <li><a href = "/">Home</a><li>
	<li><a href= "/Loginn" >Login</a></li>
 

<% 
}
else
{
%>
<li><a href = '/Logout'>Logout</a>
<% 
}
%>
   
      <li><a href="/Dash">Dashboard</a></li>
    </ul>
  </nav>
</header>

