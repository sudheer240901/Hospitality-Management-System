<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="TemplateMo">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <title>Home Page</title>

    <!-- Additional CSS Files -->
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="/css/font-awesome.css">

    <link rel="stylesheet" href="/css/templatemo-lava.css">

    <link rel="stylesheet" href="/css/owl-carousel.css">

</head>

<body>

    
    <!-- ***** Header Area Start ***** -->
    <header class="header-area header-sticky">
        <br>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav class="main-nav" >
                        
                        
                        <a href="/signup" class="logo">
                        <img style = "width:80px; height:80px; background-position: left top;" src="/img/features-icon-1.jpg" alt="">
                            CREDI-HEALTH    
                        </a>
                        <!-- ***** Logo End ***** -->
                        <!-- ***** Menu Start ***** -->
                        <ul class="nav" >
                            <li class="scroll-to-section"><a href="#welcome" class="menu-item">Home</a></li>
                            <li class="scroll-to-section"><a href="#about" class="menu-item">About</a></li>
                            <li class="scroll-to-section"><a href="#testimonials" class="menu-item">Hospitals</a></li>
                            <li class="scroll-to-section"><a href="#testimonials" class="menu-item">Doctors</a></li>
                            <li ><a href="#contactus" >Contact</a></li>
                            <li ><a href="/signup" >SignIn</a></li>
        
                        </ul>
                        <a class='menu-trigger'>
                            <span>Menu</span>
                        </a>
                        <!-- ***** Menu End ***** -->
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ***** Header Area End ***** -->


    <!-- ***** Welcome Area Start ***** -->
    <div class="welcome-area" id="welcome">

        <!-- ***** Header Text Start ***** -->
        <div class="header-text">
            <div class="container">
                <div class="row">
                    <div class="left-text col-lg-6 col-md-12 col-sm-12 col-xs-12"
                        data-scroll-reveal="enter left move 30px over 0.6s after 0.4s">
                        <h1><em>YOUR MOST TRUSTED HEALTH PARTNER </em></h1>
                        <p>Our Team of medical experts are there for you in every step of the way,
                            from finding right doctor and hospital  to book appointments,
                            from providing verified information to any kind of medical assistance in b/w.
                        </p>
                    
                    
                        <a href= "/Loginn" class="main-button-slider">Make an Appointment </a>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-12 col-xs-12" style = "position:relative; top:150px; left:50px;"
                    data-scroll-reveal="enter bottom move 30px over 0.6s after 0.4s">
                    <div class="features-item">
                        <div class="features-icon">
                            
                            <img src="assets/images/servs1.png" alt="">
                            <h4>Emergency</h4>
                            <p> Users Who Need Emergency Appointments Use Our Provided Service </p>
                            <form action = "/Emergency" modelAttribute = "emer" method = "post">
                            <label style = "color:pink;">Name</label>

                            <input  type = "text" name = "name" >
                            <br>
                            
                            <label style = "color:pink;"> Email&nbsp;</label>
                            <input type = "mail" name = "mail">
                            <br>

                            <input style = "margin-left:30px;"type = "submit" value = "Emergency">
                            </form>
                            
                        </div>
                    </div>
                </div>
                    
                </div>
            </div>
        </div>
        
        <!-- ***** Header Text End ***** -->
    </div>
    <!-- ***** Welcome Area End ***** -->

    <!-- ***** Features Big Item Start ***** -->
    <section class="section" id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6 col-sm-12 col-xs-12"
                    data-scroll-reveal="enter left move 30px over 0.6s after 0.4s">
                    <div class="features-item">
                        <div class="features-icon">
                            
                           
                            <h4>Online Appointment</h4>
                            <p>Get ALI Time Support For Emergency.</p>
                            <a href= "/Loginn" class="main-button">
                                Make an Appointment
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12 col-xs-12"
                    data-scroll-reveal="enter bottom move 30px over 0.6s after 0.4s">
                    <div class="features-item">
                        <div class="features-icon">
                            
                            
                            <h4>Services</h4>
                            <p>Curabitur pulvinar vel odio sed sagittis. Nam maximus ex diam, nec consectetur diam.</p>
                            <a href="#testimonials" class="main-button">
                                More Detail
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-12 col-xs-12"
                    data-scroll-reveal="enter right move 30px over 0.6s after 0.4s">
                    <div class="features-item">
                        <div class="features-icon">
                            
                            
                            <h4>About us</h4>
                            <p>Curabitur pulvinar vel odio sed sagittis. Nam maximus ex diam, nec consectetur diam.</p>
                            <a href="#testimonials" class="main-button">
                                More Detail
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ***** Features Big Item End ***** -->

    
    <!-- jQuery -->
    <script src="/js/jquery-2.1.0.min.js"></script>
    <!-- Bootstrap -->
    <script src="/js/popper.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <!-- Plugins -->
    <script src="/js/owl-carousel.js"></script>
    <script src="/js/scrollreveal.min.js"></script>
    <script src="/js/waypoints.min.js"></script>
    <script src="/js/jquery.counterup.min.js"></script>
    <script src="/js/imgfix.min.js"></script>
    <!-- Global Init -->
    <script src="/js/custom.js"></script>
</body>
</html>