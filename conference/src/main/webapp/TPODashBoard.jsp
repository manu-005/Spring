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
            min-height: 75px;
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

.fixed-back-btn, .fixed-next-btn {
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

.fixed-back-btn .btn,
.fixed-next-btn .btn {
    border-radius: 50px;
    padding: 12px 22px;
    box-shadow: 0 8px 20px rgba(0,89,255,0.25);
}

.fixed-back-btn .btn:hover,
.fixed-next-btn .btn:hover {
    transform: scale(1.05);
}

@media (max-width: 768px) {
    .fixed-back-btn,
    .fixed-next-btn {
        top: auto;
        bottom: 20px;
        transform: none;
    }

    .fixed-back-btn {
        left: 10px;
    }

    .fixed-next-btn {
        right: 10px;
    }
}
.action-btn {
    font-size: 18px;
    padding: 10px 20px;
}

.profile-circle {
    width: 42px;
    height: 42px;
    border-radius: 50%;
    background: #fff;
    color: #000;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 30px;
    font-weight: 700;
    margin-left: 15px;
    text-transform: uppercase;
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
                        <a class="nav-link" href="tpoLogOut">Log Out</a>
                    </li>

                    <c:set var="firstLetter" value="${topEmail.substring(0,1)}" />

                     <li class="nav-item">
                                <div class="profile-circle">
                                    ${firstLetter}
                                </div>
                     </li>

                </ul>
            </div>

        </div>
    </nav>

    <!-- MAIN CONTENT -->
    <div class="container events-section">
        <div class="row g-4">

            <c:forEach var="event" items="${tpoDTOList}">

                <div class="col-md-6 event-col">

                    <div class="event-card"
                         data-bs-toggle="modal"
                         data-bs-target="#eventModal${event.conferenceId}">

                        <img src="fetchBannerImages?conferenceId=${event.conferenceId}"
                             alt="Conference Banner"
                             class="img-fluid mb-3"
                             style="height:220px; width:100%; object-fit:cover;">

                        <h4>${event.conferenceTitle}</h4>

                        <p>${event.conferenceDescription}</p>

                        <p>
                            <strong>Date:</strong> ${event.date}<br>
                            <strong>Time:</strong> ${event.time}<br>
                            <strong>Mode:</strong> ${event.mode}
                        </p>

                        <div class="mt-auto text-end">

                            <a href="inviteDelegates?conferenceId=${event.conferenceId}"
                               class="btn btn-primary btn-sm me-2"
                               onclick="event.stopPropagation();">
                                Invite Delegate
                            </a>

                            <a href="inviteByExcelSheet?conferenceId=${event.conferenceId}"
                               class="btn btn-primary btn-sm me-2"
                               onclick="event.stopPropagation();">
                                Invite More Delegates
                            </a>

                            <a href="viewTPODelegates?conferenceId=${event.conferenceId}"
                               class="btn btn-outline-primary btn-sm"
                               onclick="event.stopPropagation();">
                                View Delegates Details
                            </a>

                          <!--  <a href="viewDelegates?conferenceId=${event.conferenceId}"
                                class="btn btn-outline-primary btn-sm"
                                onclick="event.stopPropagation();">
                                View Delegates Details
                            </a> -->

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