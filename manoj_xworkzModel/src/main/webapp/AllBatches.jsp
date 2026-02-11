<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        /* Card Styling */
        .batch-card {
            border-radius: 18px;
            overflow: hidden;
            transition: all 0.3s ease;
            border: none;
            background: white;
        }

        .batch-card:hover {
            transform: translateY(-6px) scale(1.01);
            box-shadow: 0 12px 30px rgba(0, 0, 0, 0.15);
        }

        .batch-img-wrapper {
            position: relative;
            height: 170px;
            overflow: hidden;
        }

        .batch-img-wrapper img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            transition: transform 0.4s ease;
        }

        .batch-card:hover .batch-img-wrapper img {
            transform: scale(1.08);
        }

        .batch-img-overlay {
            position: absolute;
            inset: 0;
            background: linear-gradient(to bottom, rgba(0,0,0,0.15), rgba(0,0,0,0.55));
        }

        .batch-code-badge {
            position: absolute;
            bottom: 10px;
            left: 12px;
            background: rgba(25, 135, 84, 0.95);
            color: white;
            padding: 6px 12px;
            border-radius: 999px;
            font-size: 12px;
            font-weight: 600;
            letter-spacing: 0.5px;
        }

        .batch-body p {
            margin-bottom: 6px;
            font-size: 14px;
            color: #334155;
        }

        .batch-body strong {
            color: #14532d;
        }

        .batch-footer-btn {
            border-radius: 999px;
            padding: 6px 14px;
            font-size: 13px;
        }

        @media (max-width: 576px) {
            .batch-img-wrapper {
                height: 140px;
            }
        }
    </style>
</head>

<body class="bg-success-subtle">

<!-- Navbar -->
<nav class="navbar navbar-expand-lg bg-success bg-opacity-25 shadow-sm">
    <div class="container-fluid">
        <div class="d-flex align-items-center">
            <img src="Logo.png" alt="Logo" height="45" class="me-4">

            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link fw-medium text-success-emphasis" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fw-medium text-success-emphasis" href="#">About Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fw-medium text-success-emphasis" href="#">Contact Us</a>
                </li>
            </ul>
        </div>

        <div class="d-flex gap-2 align-items-start">
            <div class="dropdown">
                <button class="btn btn-outline-success dropdown-toggle" type="button" data-bs-toggle="dropdown">
                    Profile
                </button>

                <div class="dropdown-menu p-0 border-0 shadow" style="min-width: 300px;">
                    <div class="card">
                        <div class="card-header bg-success text-white text-center">
                            <strong>My Profile</strong>
                        </div>
                        <div class="card-body text-start">
                            <p><strong>First Name:</strong> ${user.getFName()}</p>
                            <p><strong>Last Name:</strong> ${user.getLName()}</p>
                            <p><strong>Age:</strong> ${user.getAge()}</p>
                            <p><strong>Gender:</strong> ${user.getGender()}</p>
                            <p><strong>Email:</strong> ${user.getEmail()}</p>
                            <p><strong>Mobile:</strong> ${user.getMobile()}</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="dropdown">
                <button class="btn btn-success dropdown-toggle" type="button" data-bs-toggle="dropdown">
                    Batch Details
                </button>

                <ul class="dropdown-menu dropdown-menu-end shadow">
                    <li>
                        <form action="addNewBatch" method="get">
                            <button type="submit" class="dropdown-item fw-medium">Add New Batch</button>
                        </form>
                    </li>
                    <li>
                        <form action="viewAllBatches" method="get">
                            <button type="submit" class="dropdown-item fw-medium">View Batch Details</button>
                        </form>
                    </li>
                </ul>
            </div>

            <form action="logOut" method="get">
                <button type="submit" class="btn btn-success">Log Out</button>
            </form>
        </div>
    </div>
</nav>

<!-- main content -->
<div class="container my-4">
    <div class="row g-4">

        <c:forEach items="${dto}" var="batch">

            <div class="col-lg-3 col-md-4 col-sm-6">
                <div class="card batch-card h-100">

                    <c:if test="${not empty batch.fileId}">
                        <div class="batch-img-wrapper">
                            <img src="fetchImage?fileId=${batch.fileId}" alt="Batch Logo">
                            <div class="batch-img-overlay"></div>
                            <div class="batch-code-badge">
                                ${batch.batchCode}
                            </div>
                        </div>
                    </c:if>

                    <div class="card-body batch-body">
                        <p><strong>Name:</strong> ${batch.batchName}</p>
                        <p><strong>Trainer:</strong> ${batch.trainerName}</p>
                        <p><strong>Start:</strong> ${batch.startDate}</p>
                        <p><strong>End:</strong> ${batch.endDate}</p>
                    </div>

                    <div class="card-footer bg-transparent border-0 d-flex justify-content-end">
                        <form action="getAllStudentsInBatch" method="get">
                            <input type="hidden" name="batchId" value="${batch.batchId}">
                            <button type="submit" class="btn btn-success batch-footer-btn">
                                View Students
                            </button>
                        </form>
                    </div>

                </div>
            </div>

        </c:forEach>

    </div>
</div>

<footer class="bg-success bg-opacity-25 text-center py-2">
    <small class="text-success-emphasis">
        © 2026 Your Company Name. All rights reserved.
    </small>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
