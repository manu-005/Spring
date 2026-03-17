<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ConferoNexus | Global Conference Platform</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<link href="https://unpkg.com/aos@2.3.4/dist/aos.css" rel="stylesheet">

<link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@400;600;700&family=DM+Sans:wght@300;400;500;600&display=swap" rel="stylesheet">

<style>

:root {
    --accent:#0059ff;
    --accent2:#00c6ff;
    --dark:#0b0f19;
    --light-bg:#f4f6fb;
    --card-bg:#ffffff;
    --text-dark:#131722;
    --text-mid:#3d4460;
    --text-light:#7a80a0;
    --border:#e2e6f0;
    --shadow:0 8px 40px rgba(0,89,255,0.08);
}

body{
font-family:'DM Sans',sans-serif;
background:var(--light-bg);
color:var(--text-dark);
}

/* NAVBAR */

.navbar{
background:#000 !important;
padding:10px 0;
}

.nav-logo{
max-height:75px;
}

.navbar-nav .nav-link{
color:white !important;
font-weight:500;
}

/* EVENT CARD */

.event-card{
background:var(--card-bg);
border:1px solid var(--border);
border-radius:20px;
padding:20px;
box-shadow:var(--shadow);
cursor:pointer;
transition:0.15s;
position:relative;
height:100%;
}

.event-card:hover{
filter:brightness(1.08);
border-color:#0059ff;
}

.event-card img{
border-radius:12px;
}

.share-btn{
position:absolute;
top:12px;
right:12px;
border:none;
background:white;
border-radius:50%;
width:36px;
height:36px;
display:flex;
align-items:center;
justify-content:center;
box-shadow:0 3px 10px rgba(0,0,0,0.15);
}

/* SPACE BETWEEN CARDS */

.events-section{
margin-top:150px;
margin-bottom:120px;
}

.event-col{
margin-bottom:40px;
}

/* FOOTER */

footer{
background:#000;
color:white;
padding:60px 0 0;
}

footer h4{
font-family:'Cormorant Garamond',serif;
font-weight:700;
}

footer p{
color:rgba(255,255,255,0.6);
}

.footer-bottom{
margin-top:50px;
padding:18px 0;
border-top:1px solid rgba(255,255,255,0.1);
text-align:center;
font-size:13px;
color:rgba(255,255,255,0.4);
}

</style>
</head>

<body>

<!-- NAVBAR -->

<nav class="navbar navbar-expand-lg fixed-top">

<div class="container-fluid px-3">

<a class="navbar-brand d-flex align-items-center" href="#">
<img src="images/logo.png" class="nav-logo">
</a>

<button class="navbar-toggler border-0" data-bs-toggle="collapse" data-bs-target="#navmenu">
<span class="navbar-toggler-icon"></span>
</button>

<div class="collapse navbar-collapse" id="navmenu">

<ul class="navbar-nav ms-auto">

<li class="nav-item"><a class="nav-link" href="#home">Home</a></li>
<li class="nav-item"><a class="nav-link" href="#about">About</a></li>
<li class="nav-item"><a class="nav-link" href="#events">Events</a></li>
<li class="nav-item"><a class="nav-link" href="#register">Register</a></li>
<li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li>
<li class="nav-item"><a class="nav-link" href="adminLoginForm">Admin Login</a></li>

</ul>

</div>
</div>
</nav>


<div class="container" style="margin-top:100px; margin-bottom:80px;">

    <div class="event-card">

        <!-- BIG BANNER -->
               <img src="fetchBannerImages?conferenceId=${conference.conferenceId}"
                    class="img-fluid mb-4"
                    style="height:400px;width:100%;object-fit:cover;cursor:pointer;"
                    data-bs-toggle="modal"
                    data-bs-target="#imageModal">

        <!-- Title -->
        <h2>${conference.conferenceTitle}</h2>

        <!-- Description -->
        <p>${conference.conferenceDescription}</p>

        <!-- Details -->
        <p>
            <b>Date:</b> ${conference.date}<br>
            <b>Time:</b> ${conference.time}<br>
            <b>Mode:</b> ${conference.mode}<br>
            <b>Venue:</b> ${conference.venueOrMeetingLink}
        </p>



        <!-- promo VIDEO -->
        <div class="mb-4">
            <video width="100%" height="400" controls style="border-radius:12px;">
                <source src="fetchPromoVideo?conferenceId=${conference.conferenceId}" type="video/mp4">
            </video>
        </div>

        <hr>

        <!-- SELECT ALL -->
        <label>
            <input type="checkbox" onclick="selectAll(this)"> <b>Select All Delegates</b>
        </label>

        <!-- FORM -->
        <form action="shareConference" method="post">

            <input type="hidden" name="conferenceId" value="${conference.conferenceId}"/>

            <!-- Delegates -->
            <div class="mt-3">
                <c:forEach var="d" items="${conference.delegates}">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" name="emails" value="${d.delegatesEmail}">
                        <label class="form-check-label">
                            ${d.delegatesEmail}
                        </label>
                    </div>
                </c:forEach>
            </div>

            <br>

            <!-- Share Button -->
            <div class="text-end">
                <button type="submit" class="btn btn-success">
                    Share Event
                </button>
            </div>

        </form>

    </div>

</div>

<!-- FOOTER -->
<!-- FOOTER -->

<footer>

<div class="container">

<div class="row g-4">

<div class="col-md-4">

<h4>ConferoNexus</h4>

<p>Global Conference & Event Management Platform connecting organizers and attendees worldwide.</p>

</div>

<div class="col-md-4">

<h4>Head Office</h4>

<p>

1st Floor, ConferoNexus<br>
Rajajinagar, Bengaluru<br>
India – 560001

</p>

</div>

<div class="col-md-4">

<h4>Contact</h4>

<p><i class="bi bi-telephone"></i> +91 7019099371</p>
<p><i class="bi bi-envelope"></i> support@conferonexus.com</p>

</div>

</div>

</div>

<div class="footer-bottom">

© 2026 ConferoNexus | All Rights Reserved

</div>

</footer>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<script>

function shareEvent(title){

const url = window.location.href;

if(navigator.share){
navigator.share({
title:title,
url:url
});
}else{
navigator.clipboard.writeText(url);
alert("Event link copied");
}

}

</script>

</body>
</html>