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
    <p class="text-center">Browse And shop your favorite clothes</p>
     <div class="container-fluid mt-3">
       <div class="row g-3">

         <div class="col-md-4">
           <div class="card text-center shadow">
             <div class="card-body">
               <h5 class="card-title">Search & Update</h5>
               <p class="card-text">Search record by ID and update details</p>
               <a href="SearchById.jsp" class="btn btn-primary">
                 Search By Id and Update
               </a>
             </div>
           </div>
         </div>

         <div class="col-md-4">
           <div class="card text-center shadow">
             <div class="card-body">
               <h5 class="card-title">More Actions</h5>
               <p class="card-text">Additional operations</p>
               <a href="SearchById.jsp" class="btn btn-secondary">

               </a>
             </div>
           </div>
         </div>

       </div>
     </div>

</div>

<!-- ===== Footer ===== -->
<footer class="bg-dark text-white text-center p-3 fixed-bottom">
    © 2026 Cloth Store | All Rights Reserved
</footer>

</body>
</html>
