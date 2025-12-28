<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login | Passport Services</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<!-- HEADER -->
<div class="bg-primary text-white text-center py-2 fw-bold">
    Passport Seva – Government of India
</div>

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-light bg-white border-bottom">
    <div class="container">
        <a class="navbar-brand fw-bold text-primary" href="#">Passport</a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Register</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- LOGIN FORM -->
<div class="container my-5">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card shadow-sm">
                <div class="card-body">

                    <h4 class="text-center text-primary fw-bold mb-3">
                        User Login
                    </h4>

                    <!-- MESSAGE -->
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger">${error}</div>
                    </c:if>

                    <c:if test="${not empty success}">
                        <div class="alert alert-success">${success}</div>
                    </c:if>



                    <form action="login" method="post" onsubmit="return validateLogin()">

                        <div class="mb-3">
                            <label class="form-label">Login ID / Email</label>
                            <input type="text" name="email" id="email" class="form-control">
                            <small class="text-danger" id="emailErr"></small>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Password</label>
                            <input type="password" name="password" id="password" class="form-control">
                            <small class="text-danger" id="passErr"></small>
                        </div>

                        <button class="btn btn-primary w-100">
                            Login
                        </button>

                    </form>

                    <div class="text-center mt-3">
                        <a href="#" class="text-decoration-none">Forgot Password?</a>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<!-- FOOTER -->
<footer class="bg-dark text-light text-center py-3 mt-5">
    © 2025 Passport Seva | Ministry of External Affairs
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- JS VALIDATION -->
<script>
function validateLogin() {

    let ok = true;
    document.getElementById("emailErr").innerHTML = "";
    document.getElementById("passErr").innerHTML = "";

    let email = document.getElementById("email").value.trim();
    let password = document.getElementById("password").value;

    if (email === "") {
        document.getElementById("emailErr").innerHTML = "Required";
        ok = false;
    }

    if (password === "") {
        document.getElementById("passErr").innerHTML = "Required";
        ok = false;
    }

    return ok;
}
</script>

</body>
</html>
