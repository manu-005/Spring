<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Responses</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-success-subtle">
<!-- Navbar -->
<nav class="navbar navbar-expand-lg bg-success bg-opacity-25 shadow-sm">
    <div class="container-fluid">

        <!-- Left: Logo + Nav -->
        <div class="d-flex align-items-center">
            <img src="Logo.png" alt="Logo" height="45" class="me-4">
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link fw-medium text-success-emphasis" href="#">Home</a></li>
                <li class="nav-item"><a class="nav-link fw-medium text-success-emphasis" href="#">About Us</a></li>
                <li class="nav-item"><a class="nav-link fw-medium text-success-emphasis" href="#">Contact Us</a></li>
            </ul>
        </div>

        <!-- Right -->
        <div class="d-flex gap-2 align-items-start">
            <form action="getAllStudentsInBatch" method="get">
                <input type="hidden" name="batchId" value="${batchId}">
                <button type="submit" class="btn btn-outline-success">
                    Back to Student List
                </button>
            </form>

            <form action="logOut" method="get">
                <button type="submit" class="btn btn-success">
                    Log Out
                </button>
            </form>
        </div>
    </div>
</nav>

<!-- Main Content -->
<div class="container my-5">

    <div class="card shadow-lg">

        <div class="card-header bg-success text-white text-center">
            <h5 class="mb-0">Student Responses</h5>
        </div>

        <div class="card-body">

            <!-- Success / Info Message -->
            <c:if test="${not empty successMsg}">
                <div class="alert alert-success text-center fw-semibold">
                    ${successMsg}
                </div>
            </c:if>

            <div class="table-responsive">
                <table class="table table-bordered table-hover align-middle text-center">

                    <thead class="table-success">
                    <tr>
                        <th>Student Name</th>
                        <th>Email</th>
                        <th>Response</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${responses}" var="res">
                        <tr>
                            <td>${res.studentName}</td>
                            <td>${res.email}</td>
                            <td class="text-start">${res.response}</td>
                        </tr>
                    </c:forEach>

                    <c:if test="${empty responses}">
                        <tr>
                            <td colspan="3" class="text-muted text-center">
                                No responses received yet
                            </td>
                        </tr>
                    </c:if>
                    </tbody>

                </table>
            </div>

        </div>
    </div>

</div>

<!-- Footer -->
<footer class="bg-success bg-opacity-25 text-center py-2 ">
    <small class="text-success-emphasis">
        © 2026 Your Company Name. All rights reserved.
    </small>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
