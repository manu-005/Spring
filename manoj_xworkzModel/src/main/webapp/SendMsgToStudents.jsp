<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Send Message to All Students</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-success-subtle">

<!-- Navbar -->
<nav class="navbar navbar-expand-lg bg-success bg-opacity-25 shadow-sm">
    <div class="container-fluid">

        <div class="d-flex align-items-center">
            <img src="Logo.png" alt="Logo" height="45" class="me-4">

            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link fw-medium text-success-emphasis" href="#">Home</a></li>
                <li class="nav-item"><a class="nav-link fw-medium text-success-emphasis" href="#">About Us</a></li>
                <li class="nav-item"><a class="nav-link fw-medium text-success-emphasis" href="#">Contact Us</a></li>
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
                        <div class="card-body text-center">
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

<!-- Main Content -->
<div class="container my-5">
    <div class="row justify-content-center">
        <div class="col-md-8">

            <div class="card shadow-lg">
                <div class="card-header bg-success text-white text-center">
                    <h5 class="mb-0">Send Message to All Students</h5>
                </div>

                <div class="card-body">

                    <c:if test="${not empty successMsg}">
                        <div class="alert alert-success text-center fw-semibold">
                            ${successMsg}
                        </div>
                    </c:if>

                    <form action="sendingMsgToAllStudents" method="post">
                        <input type="hidden" name="batchId" value="${batchId}">

                        <div class="mb-3">
                            <label class="form-label fw-semibold">Enter Message</label>
                            <textarea name="message" class="form-control" rows="5"
                                      placeholder="Type your message to all students..." required></textarea>
                        </div>

                        <!-- Buttons Row -->
                        <div class="d-flex justify-content-between align-items-center">

                            <button type="submit" class="btn btn-success fw-semibold">
                                Send Message
                            </button>



                        </div>
                    </form>
  <form action="getAllStudentsInBatch" method="get" class="m-0">
                                <input type="hidden" name="batchId" value="${batchId}">
                                <button type="submit" class="btn btn-outline-success fw-semibold">
                                    ← Back to Student List
                                </button>
                            </form>
                </div>
            </div>

        </div>
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
