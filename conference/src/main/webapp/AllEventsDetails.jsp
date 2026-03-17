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


<!-- EVENTS -->

<div class="container events-section">

<div class="row">

<c:forEach var="event" items="${allEvents}">

<div class="col-md-6 event-col">

<div class="event-card"
data-bs-toggle="modal"
data-bs-target="#eventModal${event.conferenceId}">

<button class="share-btn"
onclick="event.stopPropagation(); shareEvent('${event.conferenceTitle}')">

<i class="bi bi-share"></i>

</button>
<img src="fetchBannerImages?bannerPath=${event.bannerPath}"
class="img-fluid mb-3"
style="height:220px;width:100%;object-fit:cover;">
${event.bannerPath}
<h4>${event.conferenceTitle}</h4>

<p>${event.conferenceDescription}</p>

<p>

<b>Date:</b> ${event.date}<br>
<b>Time:</b> ${event.time}<br>
<b>Mode:</b> ${event.mode}

</p>

</div>

</div>


<!-- MODAL -->

<div class="modal fade"
id="eventModal${event.conferenceId}"
tabindex="-1">

<div class="modal-dialog modal-lg">

<div class="modal-content">

<div class="modal-header">

<h5 class="modal-title">${event.conferenceTitle}</h5>

<button type="button"
class="btn-close"
data-bs-dismiss="modal"></button>

</div>

<div class="modal-body">

<img src="fetchBannerImage?bannerPath=${event.bannerPath}"
class="img-fluid mb-3">

<p>${event.conferenceDescription}</p>

<p>

<b>Date:</b> ${event.date}<br>
<b>Time:</b> ${event.time}<br>
<b>Mode:</b> ${event.mode}<br>
<b>Venue:</b> ${event.venueOrMeetingLink}

</p>

<video width="100%" controls>

<source src="getVideo/${event.conferenceId}" type="video/mp4">

</video>

</div>

</div>

</div>

</div>

</c:forEach>

</div>

</div>


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