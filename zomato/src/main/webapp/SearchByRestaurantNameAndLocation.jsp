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
        <a class="navbar-brand" href="#">Add Restaurant</a>

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

<form action="searchByNameAndLoc" method="get">

    <div class="col-md-6">
        <label class="form-label">Search By Restaurant Name and Location </label>
        <input type="text" class="form-control" name="searchByRestaurantName" placeHolder="Enter Restaurant Name">
         <input type="text" class="form-control" name="searchByRestaurantLocation" placeHolder="Enter Restaurant Location">
    </div>

    <div class="text-center mt-3">
        <button type="submit" class="btn btn-success px-5">Search</button>
    </div>

    <div class="mt-3 text-danger fw-bold"> </div>

<table class="table table-bordered table-striped table-hover">
    <tbody>
        <tr>
            <th>Restaurant Name</th>
             <th>Restaurant Number</th>
              <th>Location</th>
                  <th>GST Number</th>
                    <th>Opening Date</th>
                     <th>Type</th>
                           <th>Landmark</th>
                             <th>Email</th>
                               <th>Owner Number</th>
                                         <th>Owner Name</th>
                                             <th>Action</th>

        </tr>
        <tr>
              <td>${dto.getRName()}</td>
            <td >${dto.getRNo()} </td>
             <td>${dto.getLoc()}</td>
                  <td>${dto.getGstn()} </td>
                     <td> ${dto.getOpenDate()}</td>
                        <td>${dto.getType()} </td>
                          <td>${dto.getLandmark()} </td>
                            <td>${dto.getEmail()}</td>
         <td>${dto.getONo()} </td>
       <td>${dto.getOName()}</td>
       <td>

     <div class="text-center mt-3 btn-danger px-3 ">
       <button      class="btn btn- px-3"> <a href="edit/${dto.getRName()}" > Edit</a></button>
           </div>

       </td>
        </tr>
    </tbody>
</table>





</form>



<!-- Footer -->
<footer class="bg-dark text-white text-center py-2 ">
    2025 MyApp | All Rights Reserved
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

