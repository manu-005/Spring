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
       .fixed-back-btn,
       .fixed-next-btn {
           position: fixed;
           bottom: 20px;
           z-index: 9999;
       }

       .fixed-back-btn {
           left: 20px;
       }

       .fixed-next-btn {
           right: 20px;
       }

       .btn-modern {
           background: linear-gradient(135deg, #0059ff, #00c6ff);
           border: none;
           color: #fff !important;
           border-radius: 50px;
           padding: 16px 34px;
           font-size: 18px;
           font-weight: 700;
           box-shadow: 0 10px 25px rgba(0,89,255,0.35);
           transition: all 0.3s ease;
       }

       .btn-modern:hover {
           color: #fff !important;
           transform: translateY(-3px);
           box-shadow: 0 14px 30px rgba(0,89,255,0.45);
       }

       @media (max-width: 768px) {
           .fixed-back-btn {
               left: 10px;
               bottom: 12px;
           }

           .fixed-next-btn {
               right: 10px;
               bottom: 12px;
           }

           .btn-modern {
               padding: 13px 24px;
               font-size: 15px;
           }
       }
.action-btn {
    font-size: 18px;
    padding: 10px 20px;
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
                    <li class="nav-item">
                        <a class="nav-link" href="#about">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#events">Events</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#register">Register</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#contact">Contact</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="adminLoginForm">Admin Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- ✅ MAIN CONTENT -->
    <div class="container" style="margin-top:120px; margin-bottom:80px;">
        <div class="event-card">

            <!-- 🔥 BIG BANNER -->
            <img src="fetchBannerImages?conferenceId=${conference.conferenceId}"
                 class="img-fluid mb-4"
                 style="height:400px;width:100%;object-fit:cover;cursor:pointer;"
                 data-bs-toggle="modal"
                 data-bs-target="#imageModal">

            <h2>${conference.conferenceTitle}</h2>

            <p>${conference.conferenceDescription}</p>

            <p>
                <b>Date:</b> ${conference.date}<br>
                <b>Time:</b> ${conference.time}<br>
                <b>Mode:</b> ${conference.mode}<br>
                <b>Venue:</b> ${conference.venueOrMeetingLink}
            </p>

            <!-- 🔥 PROMO VIDEO -->
            <div class="mb-4">
                <video width="100%" height="400" controls style="border-radius:12px;">
                    <source src="fetchPromoVideo?conferenceId=${conference.conferenceId}" type="video/mp4">
                </video>
            </div>

            <hr>

            <!-- ✅ SELECT ALL -->
            <label>
                <input type="checkbox" onclick="selectAll(this)">
                <b>Select All Delegates</b>
            </label>

            <!-- FORM -->
            <form action="shareConference" method="post">
                <input type="hidden" name="conferenceId" value="${conference.conferenceId}" />

                <!-- ✅ FIXED LOOP -->
                <div class="mt-3">
                    <c:forEach var="email" items="${emailList}">
                        <div class="form-check">
                            <input class="form-check-input"
                                   type="checkbox"
                                   name="emails"
                                   value="${email}">
                            <label class="form-check-label">${email}</label>
                        </div>
                    </c:forEach>
                </div>

                <br>

                <div class="text-end">
                    <button type="submit" class="btn btn-success">
                        Share Event
                    </button>
                </div>
            </form>

        </div>
    </div>

    <!-- 🔥 IMAGE MODAL (FULL VIEW) -->
    <div class="modal fade" id="imageModal">
        <div class="modal-dialog modal-lg modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-body p-0">
                    <img src="fetchBannerImages?conferenceId=${conference.conferenceId}"
                         class="img-fluid w-100">
                </div>
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

    <!-- ✅ FIXED SCRIPT -->
    <script>
        function selectAll(source) {
            let checkboxes = document.getElementsByName('emails');

            for (let i = 0; i < checkboxes.length; i++) {
                checkboxes[i].checked = source.checked;
            }
        }
    </script>


<div class="fixed-back-btn">
    <button type="button" class="btn btn-modern" onclick="history.back()">
        <i class="bi bi-arrow-left"></i> Back
    </button>
</div>

<div class="fixed-next-btn">
    <button type="button" class="btn btn-modern" onclick="history.forward()">
        Next <i class="bi bi-arrow-right"></i>
    </button>
</div>
</body>
</html>