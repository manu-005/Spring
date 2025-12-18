<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Fill Details</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <script>
        function validateForm() {
            const fields = [
                "rName","rNo","loc","gstn","openDate",
                "type","landmark","email","oNo","oName"
            ];

            for (let field of fields) {
                const value = document.forms["storeForm"][field].value.trim();
                if (value === "") {
                    alert("All fields are required");
                    document.forms["storeForm"][field].focus();
                    return false;
                }
            }

            const email = document.forms["storeForm"]["email"].value;
            const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
            if (!email.match(emailPattern)) {
                alert("Enter a valid email address");
                return false;
            }

            const mobile = document.forms["storeForm"]["oNo"].value;
            if (mobile.length !== 10) {
                alert("Mobile number must be 10 digits");
                return false;
            }

            return true;
        }
    </script>
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
        <div class="navbar-nav ms-auto">
            <a class="nav-link" href="Form.jsp">Fill Form</a>
        </div>
    </div>
</nav>

<!-- Form Content -->
<div class="container mt-5 mb-5">
    <div class="card shadow">
        <div class="card-body">
            <h4 class="text-center mb-4">Fill Restaurant Details</h4>

            <form name="storeForm" action="addMyStore" method="post" onsubmit="return validateForm()">

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label class="form-label">Restaurant Name</label>
                        <input type="text" class="form-control" name="rName">
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Restaurant Number</label>
                        <input type="text" class="form-control" name="rNo">
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label class="form-label">Location</label>
                        <input type="text" class="form-control" name="loc">
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">GSTN Number</label>
                        <input type="text" class="form-control" name="gstn">
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label class="form-label">Opening Date</label>
                        <input type="date" class="form-control" name="openDate">
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Restaurant Type</label>
                        <input type="text" class="form-control" name="type">
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label class="form-label">Landmark</label>
                        <input type="text" class="form-control" name="landmark">
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Owner Email</label>
                        <input type="email" class="form-control" name="email">
                    </div>
                </div>

                <div class="row mb-4">
                    <div class="col-md-6">
                        <label class="form-label">Mobile Number</label>
                        <input type="number" class="form-control" name="oNo">
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Owner Name</label>
                        <input type="text" class="form-control" name="oName">
                    </div>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-success px-5">
                        ADD
                    </button>
                </div>

            </form>
        </div>
    </div>
</div>

<!-- Footer -->
<footer class="bg-dark text-white text-center py-2 fixed-bottom">
     2025 MyApp | All Rights Reserved
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
