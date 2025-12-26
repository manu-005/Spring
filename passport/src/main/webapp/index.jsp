<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration | My Passport Services</title>

<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<!-- HEADER -->
<div class="bg-primary text-white text-center py-2 fw-bold">
    My Passport Services – Government of India
</div>

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-light bg-white border-bottom">
    <div class="container">
        <a class="navbar-brand fw-bold text-primary" href="#">MyPassport</a>

        <button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#nav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="nav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Register</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Login</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- CONTENT -->
<div class="container mt-5 mb-5">
    <div class="row justify-content-center">
        <div class="col-md-8">

            <div class="card shadow">
                <div class="card-header bg-primary text-white fw-bold">
                    User Registration Form
                </div>
${success}${error}
                <div class="card-body">
                    <form action="registerUser" method="post" onsubmit="return validateForm()">

                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label class="form-label">Given Name</label>
                                <input type="text" name="firstName" class="form-control" required>
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Surname</label>
                                <input type="text" name="lastName" class="form-control" required>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Date of Birth</label>
                            <input type="date" name="dob" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Login ID</label>
                            <input type="text" name="userName" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Email ID</label>
                            <input type="email" name="email" class="form-control" required>
                        </div>

                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label class="form-label">Password</label>
                                <input type="password" name="password" class="form-control" required>
                            </div>
                            <div class="col-md-6">
                                <label class="form-label">Confirm Password</label>
                                <input type="password" name="confirmPassword" class="form-control" required>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Hint Question</label>
                            <select name="hintQuestion" class="form-select" required>
                                <option value="">-- Select --</option>
                                <option>What is your birth city?</option>
                                <option>What is your favourite colour?</option>
                                <option>What is your mother's maiden name?</option>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Hint Answer</label>
                            <input type="text" name="hintAnswer" class="form-control" required>
                        </div>

                        <div class="text-center">
                            <button class="btn btn-primary px-5">Register</button>
                        </div>

                    </form>

                    <c:if test="${not empty error}">
                        <div class="text-danger text-center mt-3 fw-bold">
                            ${error}
                        </div>
                    </c:if>

                </div>
            </div>

        </div>
    </div>
</div>

<!-- FOOTER -->
<footer class="bg-dark text-light text-center py-3">
    © 2025 My Passport Services | Privacy Policy | Terms & Conditions
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- JavaScript Validation -->
<script>
function validateForm() {
    let pwd = document.getElementsByName("password")[0].value;
    let cpwd = document.getElementsByName("confirmPassword")[0].value;

    if (pwd.length < 6) {
        alert("Password must be at least 6 characters");
        return false;
    }
    if (pwd !== cpwd) {
        alert("Password and Confirm Password must match");
        return false;
    }
    return true;
}
</script>

</body>
</html>
