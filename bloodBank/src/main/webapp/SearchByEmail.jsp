<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false" %>
 <%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create My Account | My Blood Bank</title>

<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<!-- HEADER -->
<div class="bg-danger text-white text-center py-2 fw-bold">
    My Blood Bank – Blood Donation Services
</div>

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-light bg-white border-bottom">
    <div class="container">
        <a class="navbar-brand fw-bold text-danger" href="#">MyBloodBank</a>

        <button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#nav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="nav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="#">Donate Blood</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Find a Camp</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Sign In</a></li>
            </ul>
        </div>
    </div>
</nav>


<!-- SEARCH -->
<div class="container mb-4">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <form action="searchAccountByEmail" method="get" class="row g-2">
                <div class="col-md-8">
                    <input type="email" name="searchEmail" class="form-control"
                           placeholder="Search by email" required>
                </div>
                <div class="col-md-4">
                    <button class="btn btn-danger w-100">Search</button>
                </div>
            </form>
        </div>
    </div>

${delete}${notdelete}


</div><!-- RESULT TABLE -->
      <div class="container mb-5">
          <div class="row justify-content-center">
              <div class="col-md-10">

                  <c:if test="${not empty dto}">
                      <table class="table table-bordered table-striped text-center">
                          <thead class="table-danger">
                              <tr>
                                  <th>ID</th>
                                  <th>First Name</th>
                                  <th>Last Name</th>
                                  <th>Email</th>
                                  <th>DOB</th>
                                  <th>Username</th>
                                  <th>Phone</th>
                                  <th>ZIP</th>
                                  <th>Action</th>
                                  <th>Action</th>
                              </tr>
                          </thead>
                          <tbody>
                              <tr>
                                  <td>${dto.donorAccountId}</td>
                                  <td>${dto.firstName}</td>
                                  <td>${dto.lastName}</td>
                                  <td>${dto.email}</td>
                                  <td>${dto.dob}</td>
                                  <td>${dto.userName}</td>
                                  <td>${dto.phone}</td>
                                  <td>${dto.zipCode}</td>
                                  <td><a href="edit/${dto.donorAccountId}">Edit</a></td>
  <td><a href="delete/${dto.donorAccountId}">Delete</a></td>
                              </tr>
                          </tbody>
                      </table>
                  </c:if>

                  <c:if test="${empty dto}">
                      <div class="text-center text-danger fw-bold">
                          ${error}
                      </div>
                  </c:if>

              </div>
          </div>
      </div>

<!-- FOOTER -->
<footer class="bg-dark text-light text-center py-3 mt-5">
    © 2025 My Blood Bank | Privacy Policy | Terms of Use
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
