<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<!-- Header -->
<header class="bg-primary text-white text-center py-3">
    <h3 class="mb-0">Restaurant Management System</h3>
</header>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#">Add Restaurant</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="Form.jsp">Fill Form</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Content -->
<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-body text-center">
            <h5 class="card-title">Welcome</h5>
            <p class="card-text">
                Please click the button below to fill the form.
            </p>
            <a href="Form.jsp" class="btn btn-success">
                Fill Form
            </a>
        </div>
    </div>
</div>


<!-- Content -->
<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-body text-center">
            <h5 class="card-title">Search</h5>
            <p class="card-text">
                Please click the button below to check exist or not.
            </p>
            <a href="CheckExist.jsp" class="btn btn-success">
               Search
            </a>
        </div>
    </div>
</div>

<!-- Footer -->
<footer class="bg-dark text-white text-center py-2 fixed-bottom">
    © 2025 MyApp | All Rights Reserved
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
