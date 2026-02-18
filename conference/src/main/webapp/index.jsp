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
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;800&display=swap" rel="stylesheet">


<style>

body{
    font-family:'Poppins',sans-serif;
    background:#0b0f19;
    color:white;
    scroll-behavior:smooth;
    overflow-x:hidden;
}

/* Loader */
#loader{
    position:fixed;
    width:100%;
    height:100%;
    background:#000;
    display:flex;
    justify-content:center;
    align-items:center;
    z-index:9999;
}
.loader-text{
    font-size:30px;
    font-weight:800;
    background:linear-gradient(90deg,#00f0ff,#ff00c8);
    -webkit-background-clip:text;
    color:transparent;
}

/* ================= NAVBAR ================= */

.navbar{
    backdrop-filter:blur(15px);
    background:black;
    transition:0.4s;
    padding:9px 0;
}

.navbar.scrolled{
    background:black;
}

.nav-logo{
    max-height:85px;
    width:auto;
    object-fit:contain;
}

.navbar-nav .nav-link{
    position:relative;
    font-weight:500;
    margin-left:25px;
    font-size:18px;
    transition:0.3s;
}

.navbar-nav .nav-link::after{
    content:"";
    position:absolute;
    left:0;
    bottom:-6px;
    width:0%;
    height:2px;
    background:linear-gradient(90deg,#00f0ff,#ff00c8);
    transition:width 0.4s ease;
}
.navbar-nav .nav-link:hover::after{
    width:100%;
}
.navbar-nav .nav-link:hover{
    color:#00f0ff !important;
}

/* ================= HERO ================= */

.hero{
    height:100vh;
    display:flex;
    align-items:center;
    justify-content:center;
    background:url('https://images.unsplash.com/photo-1521737604893-d14cc237f11d') center/cover no-repeat fixed;
    position:relative;
}

/* Dark overlay */
.hero::before{
    content:"";
    position:absolute;
    width:100%;
    height:100%;
background: rgba(135, 206, 250, 0.6);
    top:0;
    left:0;
}

/* Transparent Glass Card */
.hero-card{
    position:relative;
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(20px);
    padding:60px 70px;
    border-radius:25px;
    box-shadow:0 20px 50px rgba(0,0,0,0.6);
    text-align:center;
    max-width:800px;
}

.hero-card h1{
    font-size:60px;
    font-weight:800;
    background:linear-gradient(90deg,#00f0ff,#ff00c8);
    -webkit-background-clip:text;
    color:transparent;
}

.hero-card p{
    font-size:20px;
    color:#ddd;
}

/* ================= CARDS ================= */

.glass{
    background:rgba(255,255,255,0.08);
    backdrop-filter:blur(15px);
    border-radius:20px;
    transition:0.4s;
}
.glass:hover{
    transform:translateY(-10px);
}

/* ================= MOUSE GLOW ================= */

.cursor-glow{
    position:fixed;
    width:400px;
    height:400px;
    border-radius:50%;
    pointer-events:none;
    background: radial-gradient(circle, rgba(0,240,255,0.35) 0%, transparent 70%);
    transform: translate(-50%, -50%);
    z-index:-1;
}

/* Sections */
section{
    padding:120px 0;
}
section:nth-child(even){
    background:#111827;
}

/* Buttons */
.btn-glow{
    background:linear-gradient(90deg,#00f0ff,#ff00c8);
    border:none;
    color:white;
    padding:12px 30px;
    border-radius:30px;
    transition:0.4s;
}
.btn-glow:hover{
    box-shadow:0 0 20px #00f0ff;
    transform:scale(1.05);
}

/* Footer */
footer{
    background:#000;
    padding:40px;
    text-align:center;
}

</style>
</head>

<body>

<div id="loader">
    <div class="loader-text">ConferoNexus</div>
</div>

<div class="cursor-glow"></div>

<!-- ================= NAVBAR ================= -->

<nav class="navbar navbar-expand-lg navbar-dark fixed-top">
<div class="container">

<a class="navbar-brand d-flex align-items-center" href="#home">
    <img src="images/logo.png" alt="Logo" class="nav-logo">
</a>

<button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navmenu">
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

<!-- ================= HERO ================= -->

<section id="home" class="hero">
    <div class="hero-card" data-aos="zoom-in">
        <h1>Where Visionaries Connect</h1>
        <p class="mt-3">Global Platform for Delegates & Conference Hosts</p>
        <a href="#register" class="btn btn-glow mt-4">Get Started</a>
    </div>
</section>

<!-- ================= ABOUT ================= -->

<section id="about">
<div class="container">
<h2 class="text-center mb-5" data-aos="fade-up">About</h2>
<div class="row">
<div class="col-md-4" data-aos="flip-left">
<div class="glass p-4 text-center">
<h4>Global Reach</h4>
<p>Connect worldwide delegates and hosts.</p>
</div>
</div>
<div class="col-md-4" data-aos="flip-left">
<div class="glass p-4 text-center">
<h4>Smart Management</h4>
<p>AI-powered event management tools.</p>
</div>
</div>
<div class="col-md-4" data-aos="flip-left">
<div class="glass p-4 text-center">
<h4>Secure Platform</h4>
<p>Enterprise-level data security.</p>
</div>
</div>
</div>
</div>
</section>

<!-- ================= EVENTS ================= -->

<section id="events">
<div class="container text-center">
<h2 data-aos="fade-up">Upcoming Events</h2>
<div class="row mt-5">
<div class="col-md-4" data-aos="zoom-in">
<div class="glass p-4">
<h4>Tech Summit 2026</h4>
<p>Innovation & leadership conference.</p>
</div>
</div>
<div class="col-md-4" data-aos="zoom-in">
<div class="glass p-4">
<h4>AI Global Forum</h4>
<p>Future of artificial intelligence.</p>
</div>
</div>
<div class="col-md-4" data-aos="zoom-in">
<div class="glass p-4">
<h4>Startup Conclave</h4>
<p>Empowering entrepreneurs worldwide.</p>
</div>
</div>
</div>
</div>
</section>

<!-- ================= REGISTER ================= -->

<section id="register">
<div class="container text-center" data-aos="fade-up">
<h2>Register</h2>
<form class="mt-4">
<input type="text" class="form-control mb-3" placeholder="Full Name">
<input type="email" class="form-control mb-3" placeholder="Email">
<select class="form-control mb-3">
<option>Select Role</option>
<option>Delegate</option>
<option>Host</option>
</select>
<button class="btn btn-glow">Submit</button>
</form>
</div>
</section>

<!-- ================= CONTACT ================= -->

<section id="contact">
<div class="container text-center" data-aos="fade-up">
<h2>Contact</h2>
<p>Email: support@conferonexus.com</p>
</div>
</section>

<footer class="footer bg-dark text-light pt-5">

    <div class="container">
        <div class="row g-4">

            <!-- Column 1 -->
            <div class="col-md-4">
                <h4 class="fw-bold">ConferoNexus</h4>
                <p>
                    Global Conference & Event Management Platform.
                    Connecting Speakers, Organizers and Attendees Worldwide.
                </p>

                <h5 class="mt-3">Follow Us</h5>
                <div class="d-flex gap-3 fs-5">
                    <a href="#" class="text-light"><i class="bi bi-facebook"></i></a>
                    <a href="#" class="text-light"><i class="bi bi-twitter-x"></i></a>
                    <a href="#" class="text-light"><i class="bi bi-instagram"></i></a>
                    <a href="#" class="text-light"><i class="bi bi-linkedin"></i></a>
                </div>
            </div>

            <!-- Column 2 -->
            <div class="col-md-4">
                <h4 class="fw-bold">Head Office</h4>
                <p>
                    1th Floor, ConferoNexus, 52nd Cross <br>
                    5th Block Rajajinagar, Bengaluru <br>
                    Karnataka, India – 560001
                </p>

                <h5 class="mt-3">Other Locations</h5>
                <p>
                    Mumbai | Delhi | Hyderabad | Chennai
                </p>
            </div>

            <!-- Column 3 -->
            <div class="col-md-4">
                <h4 class="fw-bold">Contact Us</h4>
                <p><i class="bi bi-telephone me-2"></i> +91 7019099371</p>
                <p><i class="bi bi-envelope me-2"></i> support@conferonexus.com</p>
                <p><i class="bi bi-globe me-2"></i> www.conferonexus.com</p>
            </div>

        </div>
    </div>

    <!-- Bottom -->
    <div class="text-center mt-4 py-3 border-top border-secondary">
        <p class="mb-0"> © 2026 ConferoNexus | All Rights Reserved</p>
    </div>

</footer>


<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://unpkg.com/aos@2.3.4/dist/aos.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vanilla-tilt@1.8.0/dist/vanilla-tilt.min.js"></script>

<script>
AOS.init({duration:1000,once:true});

window.addEventListener("load",()=>{
document.getElementById("loader").style.display="none";
});

const glow=document.querySelector(".cursor-glow");
document.addEventListener("mousemove",(e)=>{
glow.style.left=e.clientX+"px";
glow.style.top=e.clientY+"px";
});

window.addEventListener("scroll",()=>{
document.querySelector(".navbar").classList.toggle("scrolled",window.scrollY>50);
});

VanillaTilt.init(document.querySelectorAll(".glass"),{
max:15,
speed:400,
glare:true,
"max-glare":0.3,
});
</script>

</body>
</html>
