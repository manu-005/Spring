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

<!-- FORM -->
<div class="container my-5">
    <div class="row justify-content-center">
        <div class="col-md-7">
            <div class="card shadow-sm">
                <div class="card-body">

                    <h3 class="text-center text-danger fw-bold mb-2">
                       Update Details
                    </h3>
                    <p class="text-center text-muted mb-4">
                        Manage donations, schedule appointments, and track history
                    </p>

                    <form action="<%= request.getContextPath() %>/update" method="post"
                          autocomplete="off" onsubmit="return validate()">

${success}${error}
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label class="form-label">First Name</label>
                                <input type="text" name="firstName" value="${updateDto.getFirstName()}" id="fn" class="form-control">
                                <small class="text-danger" id="fnErr"></small>
                            </div>

                            <div class="col-md-6 mb-3">
                                <label class="form-label">Last Name</label>
                                <input type="text" name="lastName" value="${updateDto.getLastName()}" id="ln" class="form-control">
                                <small class="text-danger" id="lnErr"></small>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Email Address</label>
                            <input type="email" name="email" id="em" value="${updateDto.getEmail()}" class="form-control">
                            <small class="text-danger" id="emErr"></small>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Date of Birth</label>
                            <input type="date" name="dob" id="dob" value="${updateDto.getDob()}" class="form-control">
                            <small class="text-danger" id="dobErr"></small>
                        </div>

                        <!-- USERNAME ADDED -->
                        <div class="mb-3">
                            <label class="form-label">Username</label>
                            <input type="text" name="userName" id="un" value="${updateDto.getUserName()}" class="form-control">
                            <small class="text-danger" id="unErr"></small>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Phone Number</label>
                            <input type="text" name="phone" id="ph" value="${updateDto.getPhone()}" class="form-control">
                            <small class="text-danger" id="phErr"></small>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">ZIP Code</label>
                            <input type="text" name="zipCode" id="zip" value="${updateDto.getZipCode()}" class="form-control">
                            <small class="text-danger" id="zipErr"></small>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Password</label>
                            <input type="password" name="password" id="pw" value="${updateDto.getPassword()}" class="form-control" >
                            <small class="text-danger" id="pwErr"></small>
                        </div>



                        <div class="form-check mb-3">
                            <input class="form-check-input" type="checkbox" id="terms">
                            <label class="form-check-label">
                                I agree to Terms & Privacy Policy
                            </label>
                            <br>
                            <small class="text-danger" id="tErr"></small>
                        </div>

                        <button class="btn btn-danger w-100">
                            Update Details
                        </button>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<!-- FOOTER -->
<footer class="bg-dark text-light text-center py-3 mt-5">
    © 2025 My Blood Bank | Privacy Policy | Terms of Use
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- JS VALIDATION -->
<script>
function validate() {
    let ok = true;
    document.querySelectorAll("small").forEach(e => e.innerHTML = "");

    if (!fn.value) { fnErr.innerHTML="Required"; ok=false; }
    if (!ln.value) { lnErr.innerHTML="Required"; ok=false; }
    if (!em.value) { emErr.innerHTML="Required"; ok=false; }
    if (!dob.value) { dobErr.innerHTML="Required"; ok=false; }
    if (!un.value) { unErr.innerHTML="Required"; ok=false; }

    if (!/^[0-9]{10}$/.test(ph.value)) {
        phErr.innerHTML="Enter valid 10-digit phone";
        ok=false;
    }

    if (!/^[0-9]{5,6}$/.test(zip.value)) {
        zipErr.innerHTML="Enter valid ZIP code";
        ok=false;
    }

    if (pw.value.length < 6) {
        pwErr.innerHTML="Min 6 characters";
        ok=false;
    }

    if (cpw.value === "") {
        cpwErr.innerHTML="Repeat password";
        ok=false;
    } else if (pw.value !== cpw.value) {
        cpwErr.innerHTML="Passwords do not match";
        ok=false;
    }

    if (!terms.checked) {
        tErr.innerHTML="Accept terms";
        ok=false;
    }

    return ok;
}
</script>

</body>
</html>
