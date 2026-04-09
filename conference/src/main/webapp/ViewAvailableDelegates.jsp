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

            <a href="javascript:history.back()"
               class="btn btn-outline-light rounded-pill px-4">
                <i class="bi bi-arrow-left me-2"></i>Back
            </a>
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
                                <th class="text-center" style="width:180px;">Status</th>
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

                                    <td class="text-center">
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

</body>
</html>