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
        margin: 0;
        padding-top: 110px;
    }

    /* Navbar */
    .navbar {
        background: #000 !important;
        padding: 5px 0;
    }

    .nav-logo {
        max-height: 80px;
    }

    .navbar-nav .nav-link {
        color: #fff !important;
        font-weight: 500;
    }

    /* Form Card */
    .invite-card {
        width: 100%;
        max-width: 450px;
        border-radius: 18px;
        overflow: hidden;
        border: none;
    }

    /* Footer */
    footer {
        background: #000;
        color: #fff;
        margin-top: 80px;
        padding: 60px 0 0;
    }

    .footer-bottom {
        margin-top: 50px;
        padding: 18px 0;
        border-top: 1px solid rgba(255,255,255,0.1);
        text-align: center;
        font-size: 13px;
        color: rgba(255,255,255,0.4);
    }

    /* Fixed Back & Next Buttons */
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
        padding: 12px 26px;
        border-radius: 50px;
        font-weight: 600;
        font-size: 15px;
        box-shadow: 0 8px 20px rgba(0,89,255,0.25);
        transition: 0.3s ease;
    }

    .btn-modern:hover {
        transform: translateY(-2px);
        color: #fff !important;
        box-shadow: 0 10px 24px rgba(0,89,255,0.35);
    }

    @media (max-width: 768px) {
        .fixed-back-btn {
            left: 10px;
            bottom: 15px;
        }

        .fixed-next-btn {
            right: 10px;
            bottom: 15px;
        }
    }
</style>

</head>

<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg fixed-top">
        <div class="container-fluid px-3">

            <a class="navbar-brand d-flex align-items-center" href="#">
                <img src="images/logo.png" class="nav-logo" alt="ConferoNexus Logo">
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
                        <a class="nav-link" href="#"></a>
                    </li>
                </ul>
            </div>

        </div>
    </nav>

<!-- MAIN CONTENT -->
<div class="container py-5">

    <div class="card border-0 shadow-lg rounded-4 overflow-hidden">

        <div class="card-header bg-dark text-white d-flex justify-content-between align-items-center py-3 px-4">
            <div>
                <h3 class="mb-1 fw-bold">Delegate Attendance Status</h3>
                <p class="mb-0 text-light small">
                    List of invited delegates and their response status
                </p>
            </div>

          <!--  <a href="javascript:history.back()"
               class="btn btn-outline-light rounded-pill px-4">
                <i class="bi bi-arrow-left me-2"></i>Back
            </a> -->
        </div>

        <div class="card-body p-4">

            <c:choose>

                <c:when test="${not empty availableDtoList}">

                    <div class="table-responsive">
                        <table class="table align-middle table-hover">

                            <thead class="table-dark">
                            <tr>
                                <th class="text-center" style="width:80px;">Sl No</th>
                                <th>Delegate Name</th>
                                <th>Email</th>
                                <th>Mobile No</th>
                                <th class="text-center" style="width:260px;">Status</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach var="delegate" items="${availableDtoList}" varStatus="loop">
                                <tr>
                                    <td class="text-center fw-bold">
                                        ${loop.index + 1}
                                    </td>

                                    <td class="fw-semibold">
                                        ${delegate.delegateName}
                                    </td>

                                    <td>
                                        ${delegate.delegateEmail}
                                    </td>

                                    <td>
                                        ${delegate.delegatesMobileNumber}
                                    </td>

                                    <td class="text-center" style="min-width:260px;">
                                        <c:choose>
                                            <c:when test="${delegate.delegateAvailability == true}">
                                                <span class="btn btn-success rounded-pill px-4 disabled">
                                                    Attend
                                                </span>
                                            </c:when>

                                            <c:when test="${delegate.delegateAvailability == false}">
                                                <span class="btn btn-danger rounded-pill px-4 disabled">
                                                    Not Attending
                                                </span>
                                            </c:when>

                                            <c:otherwise>
                                                <span class="btn btn-warning rounded-pill px-4 disabled text-dark">
                                                    Pending
                                                </span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>

                        </table>
                    </div>

                </c:when>
            </c:choose>

        </div>
    </div>

</div>


    <!-- Footer -->
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