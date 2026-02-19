<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
    margin-left: 22px;
    font-size: 16px;
    color: rgba(255,255,255,0.85) !important;
    transition: 0.3s;
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

/* ===== DIVIDER ===== */
.section-divider {
    width: 60px; height: 3px;
    background: linear-gradient(90deg, #0059ff, #00c6ff);
    border-radius: 4px;
    margin: 14px auto 0;
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
<div class="container">
    <a class="navbar-brand d-flex align-items-center" href="#home">
        <img src="images/logo.png" alt="Logo" class="nav-logo">
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
        </ul>
    </div>
</div>
</nav>

<!-- ===== HERO ===== -->
<section id="home" class="hero">
    <div class="hero-card" data-aos="zoom-in">
        <h1>Where Visionaries Connect</h1>
        <p class="mt-2">Global Platform for Delegates &amp; Conference Hosts</p>
        <a href="#register" class="btn btn-glow mt-4">Get Started</a>
    </div>
</section>

<!-- ===== ABOUT ===== -->
<section id="about">
<div class="container">
    <div class="text-center mb-5" data-aos="fade-up">
        <h2>About <span>Us</span></h2>
        <div class="section-divider"></div>
        <p class="mt-3" style="color:var(--text-light); font-size:16px; max-width:520px; margin:14px auto 0;">Empowering conference hosts and delegates with world-class tools.</p>
    </div>
    <div class="row g-4">
        <div class="col-md-4" data-aos="flip-left">
            <div class="glass p-4 text-center">
                <div class="icon-wrap"><i class="bi bi-globe2"></i></div>
                <h4>Global Reach</h4>
                <p>Connect worldwide delegates and hosts seamlessly across all time zones.</p>
            </div>
        </div>
        <div class="col-md-4" data-aos="flip-left" data-aos-delay="100">
            <div class="glass p-4 text-center">
                <div class="icon-wrap"><i class="bi bi-cpu"></i></div>
                <h4>Smart Management</h4>
                <p>AI-powered event management tools for effortless organization.</p>
            </div>
        </div>
        <div class="col-md-4" data-aos="flip-left" data-aos-delay="200">
            <div class="glass p-4 text-center">
                <div class="icon-wrap"><i class="bi bi-shield-check"></i></div>
                <h4>Secure Platform</h4>
                <p>Enterprise-level data security protecting your events and attendees.</p>
            </div>
        </div>
    </div>
</div>
</section>

<!-- ===== EVENTS ===== -->
<section id="events">
<div class="container">
    <div class="text-center mb-5" data-aos="fade-up">
        <h2>Upcoming <span>Events</span></h2>
        <div class="section-divider"></div>
    </div>
    <div class="row g-4">
        <div class="col-md-4" data-aos="zoom-in">
            <div class="event-card">
                <div class="event-badge">Technology</div>
                <h4>Tech Summit 2026</h4>
                <p>Innovation &amp; leadership conference for global technology leaders.</p>
                <div class="event-meta">
                    <i class="bi bi-calendar3"></i>March 15, 2026 &nbsp;·&nbsp;
                    <i class="bi bi-geo-alt"></i>Bengaluru
                </div>
            </div>
        </div>
        <div class="col-md-4" data-aos="zoom-in" data-aos-delay="100">
            <div class="event-card">
                <div class="event-badge">Artificial Intelligence</div>
                <h4>AI Global Forum</h4>
                <p>Exploring the future of artificial intelligence and its global impact.</p>
                <div class="event-meta">
                    <i class="bi bi-calendar3"></i>April 22, 2026 &nbsp;·&nbsp;
                    <i class="bi bi-camera-video"></i>Online
                </div>
            </div>
        </div>
        <div class="col-md-4" data-aos="zoom-in" data-aos-delay="200">
            <div class="event-card">
                <div class="event-badge">Entrepreneurship</div>
                <h4>Startup Conclave</h4>
                <p>Empowering entrepreneurs and connecting innovators worldwide.</p>
                <div class="event-meta">
                    <i class="bi bi-calendar3"></i>May 10, 2026 &nbsp;·&nbsp;
                    <i class="bi bi-geo-alt"></i>Mumbai
                </div>
            </div>
        </div>
    </div>
</div>
</section>

<!-- ===== REGISTER ===== -->
<section id="register" style="background:#f0f4ff;">
<div class="container">
    <div class="text-center mb-5">
        <h2>Organizer <span>Registration</span></h2>
        <div class="section-divider"></div>
    </div>

    <div class="row justify-content-center">
        <div class="col-lg-8">
            <div class="glass-card">

                <h3 class="text-center mb-1">Conference Registration</h3>
                <p class="text-center mb-4 text-muted" style="font-size:14px;">
                    Fill in your details to register your conference on our platform.
                </p>
<!-- SUCCESS MESSAGE -->
<c:if test="${not empty successMsg}">
    <div class="alert alert-success alert-dismissible fade show shadow-sm"
         role="alert">
        <strong>✔ Success!</strong> ${successMsg}
        <button type="button"
                class="btn-close"
                data-bs-dismiss="alert">
        </button>
    </div>
</c:if>

<!-- ERROR MESSAGE -->
<c:if test="${not empty errorMsg}">
    <div class="alert alert-danger alert-dismissible fade show shadow-sm"
         role="alert">
        <strong>❌ Error!</strong> ${errorMsg}
        <button type="button"
                class="btn-close"
                data-bs-dismiss="alert">
        </button>
    </div>
</c:if>

                <!-- IMPORTANT -->
                <form action="organizerDetails"
                      method="post"
                      enctype="multipart/form-data">

                    <!-- Full Name -->
                    <div class="mb-3">
                        <label class="form-label">Full Name</label>
                        <input type="text"
                               class="form-control"
                               name="fullName"
                               required>
                    </div>

                    <!-- Email -->
                    <div class="mb-3">
                        <label class="form-label">Official Email</label>
                        <input type="email"
                               class="form-control"
                               name="officialEmail"
                               required>
                    </div>

                    <!-- Organization -->
                    <div class="mb-3">
                        <label class="form-label">Organization Name</label>
                        <input type="text"
                               class="form-control"
                               name="organizationName"
                               required>
                    </div>

                    <!-- Conference Title -->
                    <div class="mb-3">
                        <label class="form-label">Conference Title</label>
                        <input type="text"
                               class="form-control"
                               name="conferenceTitle"
                               required>
                    </div>

                    <!-- Description -->
                    <div class="mb-3">
                        <label class="form-label">Conference Description</label>
                        <textarea class="form-control"
                                  rows="3"
                                  name="conferenceDescription"
                                  required></textarea>
                    </div>

                    <!-- Date & Time -->
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label class="form-label">Date</label>
                            <input type="date"
                                   class="form-control"
                                   name="date"
                                   required>
                        </div>

                        <div class="col-md-6 mb-3">
                            <label class="form-label">Time</label>
                            <input type="time"
                                   class="form-control"
                                   name="time"
                                   required>
                        </div>
                    </div>

                    <!-- Mode -->
                    <div class="mb-3">
                        <label class="form-label">Mode</label>
                        <select class="form-select"
                                name="mode"
                                required>
                            <option value="">Select Mode</option>
                            <option value="Online">Online</option>
                            <option value="Offline">Offline</option>
                            <option value="Hybrid">Hybrid</option>
                        </select>
                    </div>

                    <!-- Venue / Link -->
                    <div class="mb-3">
                        <label class="form-label">Venue / Meeting Link</label>
                        <input type="text"
                               class="form-control"
                               name="venueOrMeetingLink"
                               required>
                    </div>

                    <!-- Banner -->
                    <div class="mb-3">
                        <label class="form-label">Upload Conference Banner</label>
                        <input type="file"
                               class="form-control"
                               name="conferenceBanner"
                               accept="image/*"
                               required>
                    </div>

                    <!-- Promo Video -->
                    <div class="mb-3">
                        <label class="form-label">Upload Promo Video</label>
                        <input type="file"
                               class="form-control"
                               name="promoVideo"
                               accept="video/*">
                    </div>

    <!-- Confirm check box -->
<div class="form-check mb-3">
    <input class="form-check-input"
           type="checkbox"
           name="confirmed"
           value="true"
           required>

    <label class="form-check-label">
        I confirm that the above details are correct
    </label>
</div>

                    <!-- Submit -->
                    <div class="text-center mt-4">
                        <button type="submit"
                                class="btn btn-modern text-white px-5">
                            Submit Conference
                        </button>
                    </div>

                </form>

            </div>
        </div>
    </div>
</div>
</section>


<!-- ===== CONTACT ===== -->
<section id="contact">
<div class="container text-center" data-aos="fade-up">
    <h2>Get in <span>Touch</span></h2>
    <div class="section-divider"></div>
    <p class="mt-3" style="color:var(--text-light);">We'd love to hear from you. Reach out anytime.</p>
    <div class="d-flex justify-content-center gap-3 flex-wrap mt-3">
        <div class="contact-badge">
            <i class="bi bi-envelope-fill"></i> support@conferonexus.com
        </div>
        <div class="contact-badge">
            <i class="bi bi-telephone-fill"></i> +91 7019099371
        </div>
    </div>
</div>
</section>

<!-- ===== FOOTER ===== -->
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