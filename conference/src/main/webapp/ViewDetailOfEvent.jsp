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

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

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
            padding-top: 70px;
        }

        /* NAVBAR */
        .navbar {
            background: #000 !important;
            padding: 2px 0;
            min-height: 55px;
        }

        .nav-logo {
            max-height: 45px;
        }

        .navbar-nav .nav-link {
            color: #fff !important;
            font-weight: 500;
        }

        /* EVENTS SECTION */
        .events-section {
            padding: 30px 0 50px;
        }

        .event-col {
            display: flex;
        }

        /* EVENT CARD */
        .event-card {
            background: var(--card-bg);
            border: 1px solid var(--border);
            border-radius: 20px;
            padding: 20px;
            box-shadow: var(--shadow);
            width: 100%;
            display: flex;
            flex-direction: column;
            cursor: pointer;
            transition: 0.3s ease;
        }

        .event-card:hover {
            transform: translateY(-5px);
        }

        .event-card img {
            border-radius: 14px;
        }

        .event-card h4 {
            font-size: 22px;
            font-weight: 700;
            margin-bottom: 10px;
        }

        .event-card p {
            color: #555;
            font-size: 14px;
            margin-bottom: 12px;
        }

        .btn-sm {
            border-radius: 10px;
            padding: 8px 14px;
        }

        /* MODAL */
        .modal-content {
            border-radius: 20px;
            overflow: hidden;
        }

        .modal-header {
            background: #000;
            color: #fff;
        }

        .modal-body img {
            border-radius: 12px;
        }

        /* FOOTER */
        footer {
            background: #000;
            color: #fff;
            padding: 60px 0 0;
            margin-top: 50px;
        }

        .footer-bottom {
            margin-top: 50px;
            padding: 18px 0;
            border-top: 1px solid rgba(255, 255, 255, 0.1);
            text-align: center;
            font-size: 13px;
            color: rgba(255, 255, 255, 0.4);
        }

.action-btn {
    font-size: 18px;
    padding: 10px 20px;
}
    </style>
</head>

<body>

    <!-- NAVBAR -->
    <nav class="navbar navbar-expand-lg fixed-top">
        <div class="container-fluid px-3">

            <a class="navbar-brand d-flex align-items-center" href="#">
                <img src="images/logo.png" class="nav-logo" alt="Logo">
            </a>

            <button class="navbar-toggler border-0"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navmenu"
                    aria-controls="navmenu"
                    aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navmenu">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Log Out</a>
                    </li>
                </ul>
            </div>

        </div>
    </nav>


<div class="container events-section mt-4">

    <c:choose>

        <c:when test="${not empty viewDetails}">

            <div class="card shadow-lg border-0 mb-5 rounded-4 overflow-hidden">

                <!-- Banner -->
                <img src="fetchBannerImages?conferenceId=${viewDetails.conferenceId}"
                     alt="Conference Banner"
                     class="img-fluid w-100"
                     style="height:320px; object-fit:cover;">

                <div class="card-body p-4">

                    <!-- Conference Title -->
                    <h2 class="fw-bold text-primary mb-3">
                        ${viewDetails.conferenceTitle}
                    </h2>

                    <!-- Description -->
                    <p class="text-muted fs-5">
                        ${viewDetails.conferenceDescription}
                    </p>

                    <!-- Details -->
                    <div class="row mt-4">
                        <div class="col-md-6 mb-3">
                            <p class="mb-2">
                                <strong>Date:</strong> ${viewDetails.date}
                            </p>

                            <p class="mb-2">
                                <strong>Time:</strong> ${viewDetails.time}
                            </p>

                            <p class="mb-2">
                                <strong>Mode:</strong> ${viewDetails.mode}
                            </p>
                        </div>

                        <div class="col-md-6 mb-3">
                            <p class="mb-2">
                                <strong>Venue / Meeting Link:</strong>
                                ${viewDetails.venueOrMeetingLink}
                            </p>
                        </div>
                    </div>

                    <!-- Promo Video -->
                    <div class="mt-4">
                        <h5 class="fw-bold mb-3">Promo Video</h5>

                        <video width="100%" controls class="rounded shadow-sm">
                            <source src="fetchPromoVideo?conferenceId=${viewDetails.conferenceId}"
                                    type="video/mp4">
                            Your browser does not support the video tag.
                        </video>
                    </div>

                    <!-- Response Form -->
                    <div class="mt-5 border-top pt-4">

                        <h4 class="fw-bold text-center mb-4">
                            Will you attend this conference?
                        </h4>

                        <form action="delegateResponse" method="post">

                            <input type="hidden"
                                   name="conferenceId"
                                   value="${viewDetails.conferenceId}">

                            <input type="hidden"
                                   name="delegatesEmail"
                                   value="${delegatesEmail}">

                            <div class="d-flex justify-content-center gap-5 mb-4">

                                <div class="form-check fs-5">
                                    <input class="form-check-input"
                                           type="radio"
                                           name="response"
                                           id="yes"
                                           value="true"
                                           required>

                                    <label class="form-check-label fw-semibold"
                                           for="yes">
                                        Yes
                                    </label>
                                </div>

                                <div class="form-check fs-5">
                                    <input class="form-check-input"
                                           type="radio"
                                           name="response"
                                           id="no"
                                           value="false">

                                    <label class="form-check-label fw-semibold"
                                           for="no">
                                        No
                                    </label>
                                </div>

                            </div>

                            <div class="text-center">
                                <button type="submit"
                                        class="btn btn-primary btn-lg px-5 rounded-pill">
                                    Confirm Response
                                </button>
                            </div>

                        </form>

                    </div>

                </div>
            </div>

        </c:when>

        <c:otherwise>

            <div class="text-center mt-5">
                <div class="card shadow border-0 p-5 rounded-4">
                    <h3 class="text-danger mb-3">
                        No Event Available
                    </h3>

                    <p class="text-muted fs-5 mb-0">
                        Please try again after some time.
                    </p>
                </div>
            </div>

        </c:otherwise>

    </c:choose>

</div>
    <!-- FOOTER -->
    <footer>
        <div class="container">
            <div class="row g-4">

                <div class="col-md-4">
                    <h4>ConferoNexus</h4>
                    <p>
                        Global Conference &amp; Event Management Platform connecting
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
                        <i class="bi bi-telephone"></i>
                        +91 7019099371
                    </p>

                    <p>
                        <i class="bi bi-envelope"></i>
                        support@conferonexus.com
                    </p>
                </div>

            </div>
        </div>

        <div class="footer-bottom">
            © 2026 ConferoNexus | All Rights Reserved
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

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