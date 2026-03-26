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


/* FULL HEIGHT FIX */
html, body {
    height: 100%;
}

/* MAIN SECTION FULL SCREEN */
.main-section {
    height: 100vh;
    padding-top: 100px; /* navbar space */
}

/* REMOVE GAP */
.row.h-100 {
    margin: 0;
}

/* LEFT PANEL */
.left-panel {
    border: 2px solid var(--border);
    border-radius: 12px;
    padding: 15px;
    height: 100%;
    background: white;
}

/* RIGHT PANEL */
.right-panel {
    border: 2px solid var(--border);
    border-radius: 12px;
    padding: 20px;
    height: 100%;
    background: white;
    overflow-y: auto;
}

/* BUTTON STYLE */
.menu-row {
    width: 100%;
    padding: 15px;
    margin-bottom: 10px;

    border: 1px solid var(--border);
    border-radius: 10px;

    background: white;
    font-size: 16px;
    font-weight: 600;
    text-align: left;

    transition: 0.3s;
}

.menu-row:hover {
    background: linear-gradient(135deg, #0059ff, #00c6ff);
    color: white;
    transform: translateX(5px);
}

/* ===== NEW ADDITIONS (DO NOT REMOVE OLD CSS) ===== */

.left-panel {
    border: 2px solid var(--border);
    border-radius: 12px;
    padding: 15px;
    height: 100%;
    background: white;

    display: flex;
    flex-direction: column;
    gap: 10px;
}

.right-panel {
    border: 2px solid var(--border);
    border-radius: 12px;
    padding: 20px;
    height: 100%;
    background: white;
    overflow-y: auto;
}

.menu-row {
    width: 100%;
    padding: 15px;
    border: 1px solid var(--border);
    border-radius: 10px;
    background: white;
    font-size: 16px;
    font-weight: 600;
    text-align: left;
    transition: 0.3s;
}

.menu-row:hover {
    background: linear-gradient(135deg, #0059ff, #00c6ff);
    color: white;
    transform: translateX(5px);
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
  <!--    <li class="nav-item"><a class="nav-link" href="#home">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="#about">About</a></li>
            <li class="nav-item"><a class="nav-link" href="#events">Events</a></li>
            <li class="nav-item"><a class="nav-link" href="#register">Register</a></li>
            <li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li> -->
              <li class="nav-item"><a class="nav-link" href="index.jsp">Log out</a></li>

</ul>

</div>
</div>
</nav>



<!-- ===== TOAST NOTIFICATIONS ===== -->
<div class="toast-container position-fixed top-9 end-0 p-3" style="z-index: 1100">

    <!-- ✅ Success Toast -->
    <c:if test="${not empty acceptMessage}">
        <div class="toast align-items-center text-bg-success border-0 show" role="alert">
            <div class="d-flex">
                <div class="toast-body">
                    ${acceptMessage}
                </div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto"
                        data-bs-dismiss="toast"></button>
            </div>
        </div>
    </c:if>

     <c:if test="${not empty declineMessage}">
            <div class="toast align-items-center text-bg-success border-0 show" role="alert">
                <div class="d-flex">
                    <div class="toast-body">
                        ${declineMessage}
                    </div>
                    <button type="button" class="btn-close btn-close-white me-2 m-auto"
                            data-bs-dismiss="toast"></button>
                </div>
            </div>
        </c:if>

    <!-- ❌ Error Toast -->
    <c:if test="${not empty errorMessage}">
        <div class="toast align-items-center text-bg-danger border-0 show" role="alert">
            <div class="d-flex">
                <div class="toast-body">
                    ${errorMessage}
                </div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto"
                        data-bs-dismiss="toast"></button>
            </div>
        </div>
    </c:if>

</div>

<!-- ===== MAIN CONTENT ===== -->
<section class="main-section">
    <div class="container-fluid h-100">
        <div class="row h-100">

            <!-- LEFT SIDE -->
            <div class="col-md-3 left-panel">

                <form action="getAllEvents" method="get">
                    <button type="submit" class="menu-row w-100">
                        All Events
                    </button>
                </form>

                <form action="getAllDelegates" method="get">
                    <button type="submit" class="menu-row w-100">
                        All Delegates
                    </button>
                </form>

                <form action="getNewEvents" method="get">
                    <button type="submit" class="menu-row w-100">
                        New Events
                    </button>
                </form>

                <form action="getNewEvents" method="get">
                    <button type="submit" class="menu-row w-100">
                        Accepted Events
                    </button>
                </form>

                <form action="getAllHosters" method="get">
                    <button type="submit" class="menu-row w-100">
                        Invited Events
                    </button>
                </form>

                <form action="getAllHosters" method="get">
                    <button type="submit" class="menu-row w-100">
                        Conference Hoster Details
                    </button>
                </form>

            </div>

            <!-- RIGHT SIDE -->
            <div class="col-md-9 right-panel">
                <div id="content">
                    <div class="events-section px-2">

                        <div class="row g-4">

                            <c:forEach var="event" items="${newEvents}">

                                <div class="col-md-6">

                                    <div class="event-card"
                                         data-bs-toggle="modal"
                                         data-bs-target="#eventModal${event.conferenceId}">

                                        <img src="fetchBannerImages?conferenceId=${event.conferenceId}"
                                             class="img-fluid mb-3"
                                             style="height:220px;width:100%;object-fit:cover;">

                                        <h4>${event.conferenceTitle}</h4>

                                        <p>${event.conferenceDescription}</p>

                                        <p>
                                            <b>Date:</b> ${event.date}<br>
                                            <b>Time:</b> ${event.time}<br>
                                            <b>Mode:</b> ${event.mode}
                                        </p>

                                        <!-- BUTTONS -->
                                        <div class="mt-auto text-end">
                                            <a href="acceptEvent?conferenceId=${event.conferenceId}"
                                               class="btn btn-primary btn-sm"
                                               onclick="event.stopPropagation();">
                                              Accept
                                            </a>

                                            <a href="declineEvent?conferenceId=${event.conferenceId}"
                                               class="btn btn-primary btn-sm"
                                               onclick="event.stopPropagation();">
                                              Decline
                                            </a>
                                        </div>

                                    </div>
                                </div>
                           </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

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