<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 
<%@ include file = "navbar.jsp" %>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
</head>

<body>

    <section>
      <div class="container">
        <div class="user signinBx">
          <div class="imgBx"><img src="img/seth.jpg" alt="" /></div>
          <div class="formBx">
            <form action="/Loginn" method = "post" >
              <h2>Sign In</h2>
              <input type="text" name="mail" placeholder="Username" />
              <input type="password" name="password" placeholder="Password" />
              <input type="submit"  value="Login" />
              <p class="signup">
                Don't have an account ?
                <a href="#" onclick="toggleForm();">Sign Up.</a>
              </p>
            </form>
          </div>
        </div>
        <div class="user signupBx">
          <div class="formBx">
            <form action="/Registering" modelAttribute="pat" method = "post" >
              <h2 >Create an account</h2>
              <input type="text" name="name"  placeholder="Username" />
              <input type="text" name="mobile" placeholder="Phone Number" />
              <input type="email" name="mail" placeholder="Email" />
              <input type="password" name="password" placeholder="Create Password" />
              <div class="gender-details" name = "gender">
                <input type="radio" name="gender" value = "Male" id="dot-1">
                <input type="radio" name="gender" value = "Female" id="dot-2">
                
                
                <div class="category">
                  <label for="dot-1">
                  <span class="dot one"></span>
                  <span class="gender">Male</span>
                </label>
                <label for="dot-2">
                  <span class="dot two"></span>
                  <span class="gender">Female</span>
                </label>
                
                </div>
              </div>
              <div class="input-box">
                
                <input type="number" name = "age" placeholder="Enter your Age" required>
              </div>
              <input type="text" name="address" placeholder="Address" />
              <input type="submit"  value="Sign Up" />
              <p class="signup">
                Already have an account ?
                <a href="#" onclick="toggleForm();">Sign in.</a>
              </p>
            </form>
          </div>
          <div class="imgBx"><img src="img/seth2.jpg" alt="" /></div>
        </div>
      </div>
    </section>
  </body>

  <script>
      const toggleForm = () => {
  const container = document.querySelector('.container');
  container.classList.toggle('active');
};
  </script>
</html>