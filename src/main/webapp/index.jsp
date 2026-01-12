<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cloth Store</title>

    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- ===== Header ===== -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">Cloth Store</a>

        <div class="d-flex">
            <a href="index.jsp" class="btn btn-outline-light me-2">Home</a>
            <a href="Search.jsp" class="btn btn-outline-light me-2">Search</a>
                        <a href="SearchById.jsp" class="btn btn-outline-light me-2">Search By Id</a>

            <a href="Registration.jsp" class="btn btn-outline-light">Registration</a>
        </div>
    </div>
</nav>

<!-- ===== Main Content ===== -->
<div class="container mt-5">
    <h2 class="text-center">Welcome to Cloth Store</h2>
    <p class="text-center">Browse and shop your favorite clothes</p>
</div>

<!-- ===== Footer ===== -->
<footer class="bg-dark text-white text-center p-3 fixed-bottom">
    © 2026 Cloth Store | All Rights Reserved
</footer>

</body>
</html>
