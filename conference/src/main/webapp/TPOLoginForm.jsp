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

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

    <style>
        :root {
            --accent: #0059ff;
            --light-bg: #f4f6fb;
            --card-bg: #ffffff;
            --border: #e2e6f0;
            --shadow: 0 8px 40px rgba(0, 89, 255, 0.08);
        }

        body {
            font-family: 'DM Sans', sans-serif;
            background: var(--light-bg);
        }

        /* NAVBAR */
        .navbar {
            background: #000 !important;
            padding: 10px 0;
        }

        .nav-logo {
            max-height: 75px;
        }

        .navbar-nav .nav-link {
            color: white !important;
            font-weight: 500;
        }

        /* EVENT CARD */
        .event-card {
            background: var(--card-bg);
            border: 1px solid var(--border);
            border-radius: 20px;
            padding: 20px;
            box-shadow: var(--shadow);
        }

        /* FOOTER */
        footer {
            background: #000;
            color: white;
            padding: 60px 0 0;
        }

        .footer-bottom {
            margin-top: 50px;
            padding: 18px 0;
            border-top: 1px solid rgba(255, 255, 255, 0.1);
            text-align: center;
            font-size: 13px;
            color: rgba(255, 255, 255, 0.4);
        }
    </style>
</head>

<body>

    <!-- ✅ YOUR SAME NAVBAR -->
    <nav class="navbar navbar-expand-lg fixed-top">
        <div class="container-fluid px-3">
            <a class="navbar-brand d-flex align-items-center" href="#">
                <img src="images/logo.png" class="nav-logo">
            </a>

            <button class="navbar-toggler border-0"
                    data-bs-toggle="collapse"
                    data-bs-target="#navmenu">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navmenu">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#home">Home</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- ✅ YOUR Main content -->

<!-- ✅ YOUR Main content -->

<div class="container d-flex justify-content-center align-items-center"
     style="min-height:100vh; background:#f5f7fb;">

    <div class="card shadow-lg border-0"
         style="width:450px; border-radius:24px; overflow:hidden;">

        <div class="card-header text-center text-white"
             style="background:linear-gradient(135deg,#0059ff,#3f7bff); padding:30px;">
            <h3 class="mb-2 fw-bold">TPO Login</h3>
            <p class="mb-0" style="font-size:14px;">
                Login securely using your email and OTP
            </p>
        </div>

        <div class="card-body p-4">

            <!-- Step 1 : Get OTP -->
            <form action="getOtp" method="post">
                <div class="mb-4">
                    <label class="form-label fw-semibold mb-2">Email ID</label>

                    <div class="input-group input-group-lg">
                        <span class="input-group-text bg-white border-end-0">
                            <i class="bi bi-envelope text-primary"></i>
                        </span>

                        <input type="email"
                               name="email"
                               value="${email}"
                               class="form-control border-start-0"
                               placeholder="Enter your email address"
                               disabled>
                    </div>
                </div>

                <div class="d-grid mb-3">
                    <button type="submit"
                            class="btn btn-primary btn-lg"
                            style="border-radius:12px;">
                        <i class="bi bi-send me-2"></i>Get OTP
                    </button>
                </div>
            </form>

            <!-- Success / Error Message -->
            <c:if test="${not empty successMsg}">
                <div class="alert alert-success text-center">
                    ${successMsg}
                </div>
            </c:if>

            <c:if test="${not empty errorMsg}">
                <div class="alert alert-danger text-center">
                    ${errorMsg}
                </div>
            </c:if>

            <!-- Step 2 : OTP Field appears after backend sets successMsg -->
            <c:if test="${not empty successMsg}">
                <form action="verifyOTP" method="post">

                    <input type="hidden" name="email" value="${email}">

                    <div class="mb-4 mt-4">
                        <label class="form-label fw-semibold mb-2">Enter OTP</label>

                        <div class="input-group input-group-lg">
                            <span class="input-group-text bg-white border-end-0">
                                <i class="bi bi-shield-lock text-success"></i>
                            </span>

                            <input type="text"
                                   name="otp"
                                   maxlength="6"
                                   class="form-control border-start-0"
                                   placeholder="Enter 6-digit OTP"
                                   required>
                        </div>
                    </div>

                    <div class="d-grid">
                        <button type="submit"
                                class="btn btn-success btn-lg"
                                style="border-radius:12px;">
                            <i class="bi bi-check-circle me-2"></i>Submit
                        </button>
                    </div>
                </form>
            </c:if>

        </div>
    </div>
</div>
    <!-- ✅ YOUR SAME FOOTER -->
    <footer>
        <div class="container">
            <div class="row g-4">

                <div class="col-md-4">
                    <h4>ConferoNexus</h4>
                    <p>
                        Global Conference & Event Management Platform connecting
                        organizers and attendees worldwide.
                    </p>
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
                    <p>
                        <i class="bi bi-telephone"></i> +91 7019099371
                    </p>
                    <p>
                        <i class="bi bi-envelope"></i> support@conferonexus.com
                    </p>
                </div>

            </div>
        </div>

        <div class="footer-bottom">
            © 2026 ConferoNexus | All Rights Reserved
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <!-- ✅ FIXED SCRIPT  -->
    <script>
        function selectAll(source) {
            let checkboxes = document.getElementsByName('emails');

            for (let i = 0; i < checkboxes.length; i++) {
                checkboxes[i].checked = source.checked;
            }
        }
    </script>

</body>
</html>