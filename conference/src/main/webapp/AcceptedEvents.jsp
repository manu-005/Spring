%@ page language="java" contentType="text/html; charset=UTF-8"
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

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<!-- AOS -->
<link href="https://unpkg.com/aos@2.3.4/dist/aos.css" rel="stylesheet">

<!-- Fonts -->
<link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@400;600;700&family=DM+Sans:wght@300;400;500;600&display=swap" rel="stylesheet">

<style>
:root {
    --accent: #0059ff;
    --accent2: #00c6ff;
    --dark: #0b0f19;
    --light-bg: #f4f6fb;
    --card-bg: #ffffff;
    --text-dark: #131722;
    --text-mid: #3d4460;
    --text-light: #7a80a0;
    --border: #e2e6f0;
    --shadow: 0 8px 40px rgba(0,89,255,0.08);
    --shadow-hover: 0 20px 60px rgba(0,89,255,0.16);
}

*, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }

body {
    font-family: 'DM Sans', sans-serif;
    background: var(--light-bg);
    color: var(--text-dark);
    scroll-behavior: smooth;
    overflow-x: hidden;
}

/* ===== LOADER ===== */
#loader {
    position: fixed;
    width: 100%; height: 100%;
    background: #fff;
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 9999;
}
.loader-text {
    font-family: 'Cormorant Garamond', serif;
    font-size: 36px;
    font-weight: 700;
    background: linear-gradient(90deg, #0059ff, #00c6ff);
    -webkit-background-clip: text;
    color: transparent;
    letter-spacing: 2px;
}
.navbar-nav {
    margin-right: 0 !important;
}
/* ===== CURSOR GLOW ===== */
.cursor-glow {
    position: fixed;
    width: 500px; height: 500px;
    border-radius: 50%;
    pointer-events: none;
    background: radial-gradient(circle, rgba(0,89,255,0.07) 0%, transparent 70%);
    transform: translate(-50%, -50%);
    z-index: 0;
}

/* ===== NAVBAR ===== */
.navbar {
    backdrop-filter: blur(20px);
    background: #000 !important;
    transition: 0.4s;
    padding: 10px 0;
    border-bottom: 1px solid rgba(255,255,255,0.06);
}
.navbar.scrolled {
    background: #000 !important;
    box-shadow: 0 4px 30px rgba(0,0,0,0.5);
}
.nav-logo {
    max-height: 75px;
    width: auto;
    object-fit: contain;
}
.navbar-nav .nav-link {
    position: relative;
    font-weight: 500;
    margin-left: 5px;
    font-size: 16px;
    color: rgba(255,255,255,0.85) !important;
    transition: 0.3s;
}
.navbar-nav .nav-link {

    padding: 6px 10px;  /* tighter spacing */
}
.navbar-nav .nav-link::after {
    content: "";
    position: absolute;
    left: 0; bottom: -5px;
    width: 0%; height: 2px;
    background: linear-gradient(90deg, #0059ff, #00c6ff);
    transition: width 0.4s ease;
}
.navbar-nav .nav-link:hover::after { width: 100%; }
.navbar-nav .nav-link:hover { color: #00c6ff !important; }

.navbar .container {
    padding-left: 10px;   /* default is 15px */
    padding-right: 10px;
}
/* ===== HERO ===== */
.hero {
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    background: url('https://images.unsplash.com/photo-1521737604893-d14cc237f11d') center/cover no-repeat fixed;
    position: relative;
}
.hero::before {
    content: "";
    position: absolute;
    width: 100%; height: 100%;
    background: rgba(240, 246, 255, 0.72);
    top: 0; left: 0;
}
.hero-card {
    position: relative;
    background: rgba(255,255,255,0.65);
    backdrop-filter: blur(24px);
    -webkit-backdrop-filter: blur(24px);
    padding: 70px 80px;
    border-radius: 28px;
    box-shadow: 0 30px 80px rgba(0,89,255,0.15), 0 2px 0 rgba(255,255,255,0.9) inset;
    text-align: center;
    max-width: 820px;
    border: 1px solid rgba(255,255,255,0.8);
}
.hero-card h1 {
    font-family: 'Cormorant Garamond', serif;
    font-size: 64px;
    font-weight: 700;
    background: linear-gradient(135deg, #0059ff, #00c6ff);
    -webkit-background-clip: text;
    color: transparent;
    line-height: 1.15;
}
.hero-card p {
    font-size: 19px;
    color: var(--text-mid);
    margin-top: 14px;
}

/* ===== SECTIONS ===== */
section { padding: 110px 0; }
section:nth-child(even) { background: #eef1f9; }

section h2 {
    font-family: 'Cormorant Garamond', serif;
    font-size: 44px;
    font-weight: 700;
    color: var(--text-dark);
    margin-bottom: 10px;
}
section h2 span {
    background: linear-gradient(135deg, #0059ff, #00c6ff);
    -webkit-background-clip: text;
    color: transparent;
}

/* ===== GLASS / FEATURE CARDS ===== */
.glass {
    background: var(--card-bg);
    border: 1px solid var(--border);
    border-radius: 20px;
    transition: 0.4s;
    box-shadow: var(--shadow);
}
.glass:hover {
    transform: translateY(-10px);
    box-shadow: var(--shadow-hover);
    border-color: rgba(0,89,255,0.2);
}
.glass .icon-wrap {
    width: 56px; height: 56px;
    border-radius: 14px;
    background: linear-gradient(135deg, #0059ff22, #00c6ff22);
    display: flex; align-items: center; justify-content: center;
    margin: 0 auto 18px;
    font-size: 24px;
    color: var(--accent);
}
.glass h4 {
    font-family: 'Cormorant Garamond', serif;
    font-size: 22px;
    font-weight: 700;
    color: var(--text-dark);
    margin-bottom: 8px;
}
.glass p { color: var(--text-light); font-size: 15px; }

/* ===== EVENTS CARDS ===== */
.event-card {
    background: var(--card-bg);
    border: 1px solid var(--border);
    border-radius: 20px;
    padding: 32px;
    box-shadow: var(--shadow);
    transition: 0.4s;
    text-align: left;
}
.event-card:hover {
    transform: translateY(-8px);
    box-shadow: var(--shadow-hover);
    border-color: rgba(0,89,255,0.2);
}
.event-badge {
    display: inline-block;
    background: linear-gradient(135deg, #0059ff18, #00c6ff18);
    color: var(--accent);
    font-size: 12px;
    font-weight: 600;
    padding: 4px 14px;
    border-radius: 30px;
    margin-bottom: 14px;
    letter-spacing: 0.5px;
    text-transform: uppercase;
}
.event-card h4 {
    font-family: 'Cormorant Garamond', serif;
    font-size: 24px;
    font-weight: 700;
    color: var(--text-dark);
    margin-bottom: 8px;
}
.event-card p { color: var(--text-light); font-size: 15px; }
.event-card .event-meta {
    margin-top: 16px;
    font-size: 13px;
    color: var(--accent);
    font-weight: 500;
}
.event-card .event-meta i { margin-right: 6px; }

/* ===== REGISTER FORM ===== */
.glass-card {
    background: var(--card-bg);
    border: 1px solid var(--border);
    border-radius: 24px;
    padding: 48px 50px;
    box-shadow: var(--shadow);
}
.glass-card h3 {
    font-family: 'Cormorant Garamond', serif;
    font-size: 32px;
    font-weight: 700;
    color: var(--text-dark);
}

label {
    font-weight: 500;
    margin-bottom: 6px;
    font-size: 14px;
    color: var(--text-mid);
}
.form-control, .form-select {
    background: #f8f9fd;
    border: 1.5px solid var(--border);
    color: var(--text-dark);
    border-radius: 12px;
    padding: 12px 16px;
    font-size: 15px;
    transition: 0.3s;
}
.form-control::placeholder { color: #b0b8d0; }
.form-control:focus, .form-select:focus {
    background: #fff;
    border-color: var(--accent);
    box-shadow: 0 0 0 4px rgba(0,89,255,0.08);
    color: var(--text-dark);
    outline: none;
}
.form-select {
    color: var(--text-dark);
    appearance: auto;
}

/* ===== BUTTONS ===== */
.btn-glow {
    background: linear-gradient(135deg, #0059ff, #00c6ff);
    border: none;
    color: white;
    padding: 13px 34px;
    border-radius: 50px;
    font-weight: 600;
    font-size: 15px;
    transition: 0.4s;
    letter-spacing: 0.3px;
}
.btn-glow:hover {
    box-shadow: 0 8px 30px rgba(0,89,255,0.35);
    transform: scale(1.04) translateY(-2px);
    color: white;
}
.btn-modern {
    background: linear-gradient(135deg, #0059ff, #00c6ff);
    border: none;
    color: white;
    padding: 13px 44px;
    border-radius: 50px;
    font-weight: 600;
    font-size: 15px;
    transition: 0.3s ease;
    letter-spacing: 0.3px;
}
.btn-modern:hover {
    box-shadow: 0 8px 30px rgba(0,89,255,0.3);
    transform: translateY(-3px);
    color: white;
}

/* ===== CONTACT ===== */
#contact {
    background: linear-gradient(135deg, #f0f4ff, #e8f0ff);
}
#contact h2 { margin-bottom: 12px; }
#contact p { color: var(--text-mid); font-size: 17px; }
.contact-badge {
    display: inline-flex;
    align-items: center;
    gap: 10px;
    background: white;
    border: 1px solid var(--border);
    border-radius: 50px;
    padding: 10px 24px;
    font-size: 15px;
    color: var(--text-mid);
    box-shadow: var(--shadow);
    margin-top: 20px;
}
.contact-badge i { color: var(--accent); font-size: 18px; }

/* ===== FOOTER ===== */
footer {
    background: #000 !important;
    color: rgba(255,255,255,0.85);
    padding: 60px 0 0;
}
footer h4 {
    font-family: 'Cormorant Garamond', serif;
    font-size: 22px;
    font-weight: 700;
    color: #fff;
    margin-bottom: 14px;
}
footer h5 {
    font-size: 14px;
    font-weight: 600;
    text-transform: uppercase;
    letter-spacing: 1px;
    color: rgba(255,255,255,0.5);
    margin-bottom: 10px;
}
footer p { font-size: 14px; color: rgba(255,255,255,0.6); line-height: 1.8; }
footer a { color: rgba(255,255,255,0.55); text-decoration: none; transition: 0.3s; }
footer a:hover { color: #00c6ff; }
.footer-social a {
    width: 38px; height: 38px;
    border: 1px solid rgba(255,255,255,0.15);
    border-radius: 50%;
    display: flex; align-items: center; justify-content: center;
    font-size: 16px;
    transition: 0.3s;
}
.footer-social a:hover {
    background: linear-gradient(135deg, #0059ff, #00c6ff);
    border-color: transparent;
    color: white;
}
.footer-bottom {
    margin-top: 50px;
    padding: 18px 0;
    border-top: 1px solid rgba(255,255,255,0.08);
    text-align: center;
    font-size: 13px;
    color: rgba(255,255,255,0.35);
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
</style>
</head>

<body>

<div id="loader">
    <div class="loader-text">ConferoNexus</div>
</div>

<div class="cursor-glow"></div>

<!-- ===== NAVBAR ===== -->
<nav class="navbar navbar-expand-lg fixed-top">
<div class="container-fluid px-3">
        <a class="navbar-brand d-flex align-items-center" href="#home">
        <img src="images/logo.png" alt="Logo" class="nav-logo">
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

<!--   ===========main content ====== -->
<section class="main-section">
    <div class="container-fluid h-100">
        <div class="row h-100">

            <!-- LEFT SIDE -->
            <div class="col-md-3 left-panel">

                <form action="getAllEvents" method="get">
                 <button  class="menu-row" type="submit" class="btn btn-modern w-100">
                 All Events
                 </button>
                 </form>

                <form action="getAllDelegates" method="get">
                <button class="menu-row" type="submit" class="btn btn-modern w-100">
                All Delegates </button>
                </form>

                         <form action="getNewEvents" method="get">
                              <button  class="menu-row" type="submit" class="btn btn-modern w-100">
                              New Events
               </button>
               </form>

                <form action="acceptedEvents" method="get">
                              <button  class="menu-row" type="submit" class="btn btn-modern w-100">
                              Accepted Events </button>
                              </form>

                                    <form action="getAllHosters" method="get">
                                             <button  class="menu-row" type="submit" class="btn btn-modern w-100">
                                             Invited Events </button>
                                             </form>

                                              <form action="getAllHosters" method="get">
                                                            <button  class="menu-row" type="submit" class="btn btn-modern w-100">
                                                            Conference Hoster Details </button>
                                                            </form>



            </div>

            <!-- RIGHT SIDE -->
            <div class="col-md-9 right-panel">
                <div id="content">

<!-- EVENTS -->

<div class="container events-section">

<div class="row">

<c:forEach var="event" items="${acceptedEvents}">

<div class="col-md-6 event-col">

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
 <!-- Button at bottom right -->
   <div class="mt-auto text-end">
       <a href="sendConference?conferenceId=${event.conferenceId}"
          class="btn btn-primary btn-sm"
          onclick="event.stopPropagation();">
           Invite
       </a>

          <a href="viewDelegates?conferenceId=${event.conferenceId}"
             class="btn btn-primary btn-sm"
             onclick="event.stopPropagation();">
           View TPO Details
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
<!-- ===== FOOTER ===== -->
<section id="contact" style="background:black;">

<footer>
<div class="container">
    <div class="row g-4">
        <div class="col-md-4">
            <h4>ConferoNexus</h4>
            <p>Global Conference &amp; Event Management Platform. Connecting Speakers, Organizers and Attendees Worldwide.</p>
            <h5 class="mt-4">Follow Us</h5>
            <div class="d-flex gap-2 footer-social mt-2">
                <a href="#"><i class="bi bi-facebook"></i></a>
                <a href="#"><i class="bi bi-twitter-x"></i></a>
                <a href="#"><i class="bi bi-instagram"></i></a>
                <a href="#"><i class="bi bi-linkedin"></i></a>
            </div>
        </div>
        <div class="col-md-4">
            <h4>Head Office</h4>
            <p>
                1st Floor, ConferoNexus, 52nd Cross<br>
                5th Block Rajajinagar, Bengaluru<br>
                Karnataka, India – 560001
            </p>
            <h5 class="mt-3">Other Locations</h5>
            <p>Mumbai | Delhi | Hyderabad | Chennai</p>
        </div>
        <div class="col-md-4">
            <h4>Contact Us</h4>
            <p><i class="bi bi-telephone me-2" style="color:#00c6ff;"></i> +91 7019099371</p>
            <p><i class="bi bi-envelope me-2" style="color:#00c6ff;"></i> support@conferonexus.com</p>
            <p><i class="bi bi-globe me-2" style="color:#00c6ff;"></i> www.conferonexus.com</p>
        </div>
    </div>
</div>
<div class="footer-bottom">
    © 2026 ConferoNexus | All Rights Reserved
</div>
</footer>
</section>

<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://unpkg.com/aos@2.3.4/dist/aos.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vanilla-tilt@1.8.0/dist/vanilla-tilt.min.js"></script>

<script>
AOS.init({ duration: 1000, once: true });

window.addEventListener("load", () => {
    document.getElementById("loader").style.display = "none";
});

const glow = document.querySelector(".cursor-glow");
document.addEventListener("mousemove", (e) => {
    glow.style.left = e.clientX + "px";
    glow.style.top = e.clientY + "px";
});

window.addEventListener("scroll", () => {
    document.querySelector(".navbar").classList.toggle("scrolled", window.scrollY > 50);
});

VanillaTilt.init(document.querySelectorAll(".glass, .event-card"), {
    max: 10,
    speed: 400,
    glare: true,
    "max-glare": 0.08,
});
</script>

</body>
</html>