<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false" %>

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
        <a class="navbar-brand" href="#">Update Restaurant</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="index.jsp">Home</a>
                </li>

                <li class="nav-item">
                                    <a class="nav-link active" href="Form.jsp">Fill Form</a>
                                </li>

            <li class="nav-item">
             <a class="nav-link active" href="SearchByRestaurantName.jsp">Search By Restaurant Name</a>
               </li>
      <li class="nav-item">
                <a class="nav-link active" href="SearchByRestaurantNameAndLocation.jsp">Search By Restaurant Name And Location</a>
                  </li>

            </ul>
        </div>
    </div>
</nav>


<!-- Form Content -->
<div class="container mt-5 mb-5">
    <div class="card shadow">
        <div class="card-body">

        <h4 class="alert-heading text-success">${success}</h4>
        <h4 class="alert-heading text-danger" >${error}</h4>

          <h4 class="text-center mb-4">Update Restaurant Details</h4>

            <form name="update" action="<%= request.getContextPath() %>/update" method="POST">

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label class="form-label">Restaurant Name</label>
                        <input type="text" class="form-control"  value="${ res.getRName() }"  name="rName">
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Restaurant Number</label>
                        <input type="text" class="form-control" name="rNo" value="${ res.getRNo() }">
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label class="form-label">Location</label>
                        <input type="text" class="form-control" name="loc" value="${res.getLoc()}">
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">GSTN Number</label>
                        <input type="text" class="form-control" name="gstn" value="${res.getGstn()}">
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label class="form-label">Opening Date</label>
                        <input type="date" class="form-control" name="openDate" value="${res.getOpenDate()}">
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Restaurant Type</label>
                        <input type="text" class="form-control" name="type" value="${res.getType()}">
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label class="form-label">Landmark</label>
                        <input type="text" class="form-control"  value="${res.getLandmark()}" name="landmark" >
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Owner Email</label>
                        <input type="email" class="form-control" name="email" value="${res.getEmail()}">
                    </div>
                </div>

                <div class="row mb-4">
                    <div class="col-md-6">
                        <label class="form-label">Mobile Number</label>
                        <input type="number" class="form-control" name="oNo" value="${res.getONo()}" >
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Owner Name</label>
                        <input type="text" class="form-control" name="oName" value="${res.getOName()}" >
                    </div>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-success px-5">
                        Update
                    </button>
                </div>

            </form>
        </div>
    </div>
</div>



<!-- Footer -->
<footer class="bg-dark text-white text-center py-2 ">
    2025 MyApp | All Rights Reserved
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

