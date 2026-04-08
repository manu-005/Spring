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
            max-height: 65px;
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

   <!-- Invite Delegate Form -->
   <div class="container d-flex justify-content-center align-items-center">
       <div class="card shadow-lg invite-card">

           <div class="card-header text-center text-white"
                style="background: linear-gradient(135deg, #0d6efd, #4a8cff); padding: 22px;">
               <h3 class="mb-1 fw-bold">Invite Delegate</h3>
               <p class="mb-0">Send event invitation to delegate</p>
           </div>

           <div class="card-body p-4">

               <!-- Success Message -->
               <c:if test="${not empty successMessage}">
                   <div class="alert alert-success text-center">
                       ${successMessage}
                   </div>
               </c:if>

               <form action="sendDelegateInvitation" method="post">

                   <!-- Delegate Name -->
                   <div class="mb-3">
                       <label class="form-label fw-semibold">Delegate Name</label>

                       <input type="text"
                              name="delegateName"
                              class="form-control"
                              placeholder="Enter delegate name"
                              value="${delegateDTO.delegateName}">

                       <c:if test="${not empty delegateNameError}">
                           <small class="text-danger">
                               ${delegateNameError}
                           </small>
                       </c:if>
                   </div>

                   <!-- Delegate Email -->
                   <div class="mb-3">
                       <label class="form-label fw-semibold">Email ID</label>

                       <input type="email"
                              name="delegateEmail"
                              class="form-control"
                              placeholder="Enter delegate email"
                              value="${delegateDTO.delegateEmail}">

                       <c:if test="${not empty delegateEmailError}">
                           <small class="text-danger">
                               ${delegateEmailError}
                           </small>
                       </c:if>
                   </div>

                   <!-- Mobile Number -->
                   <div class="mb-3">
                       <label class="form-label fw-semibold">Mobile Number</label>

                       <input type="number"
                              name="delegatesMobileNumber"
                              class="form-control"
                              placeholder="Enter delegate mobile number"
                              value="${delegateDTO.delegatesMobileNumber}">

                       <c:if test="${not empty delegatesMobileNumberError}">
                           <small class="text-danger">
                               ${delegatesMobileNumberError}
                           </small>
                       </c:if>
                   </div>

                   <!-- Organization Name -->
                   <div class="mb-4">
                       <label class="form-label fw-semibold">Delegate Organization Name</label>

                       <input type="text"
                              name="delegatesOrganizationName"
                              class="form-control"
                              placeholder="Enter delegate organization name"
                              value="${delegateDTO.delegatesOrganizationName}">

                       <c:if test="${not empty delegatesOrganizationNameError}">
                           <small class="text-danger">
                               ${delegatesOrganizationNameError}
                           </small>
                       </c:if>
                   </div>

                   <div class="d-grid">
                       <button type="submit"
                               class="btn btn-primary btn-lg"
                               style="border-radius: 12px;">
                           Send Invitation
                       </button>
                   </div>

               </form>
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

</body>
</html>