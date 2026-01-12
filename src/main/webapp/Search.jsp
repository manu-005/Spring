<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cloth Search</title>

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

<!-- ===== Search Form ===== -->
<div class="container mt-5">
    <h3 class="text-center mb-4">Search Cloth</h3>
${error}
    <form action="search"
          method="get"
          class="col-md-6 mx-auto">

        <div class="mb-3">
            <label class="form-label">Cloth Name</label>
            <input type="text"
                   name="clothName"
                   class="form-control"
                   placeholder="Enter cloth name">
        </div>

        <button type="submit" class="btn btn-primary w-100">Search</button>
    </form>
</div>



 <table class="table table-bordered table-hover text-center mt-4">
     <thead class="table-dark">
         <tr>
             <th>Cloth Name</th>
             <th>Brand</th>
             <th>Type</th>
             <th>Size</th>
             <th>Color</th>
             <th>Price (₹)</th>
             <th>Material</th>
             <th>Available</th>
         </tr>
     </thead>
     <tbody>
         <tr>
             <td>${list.clothName}</td>
             <td>${list.brand}</td>
             <td>${list.type}</td>
             <td>${list.size}</td>
             <td>${list.color}</td>
             <td>${list.price}</td>
             <td>${list.material}</td>
             <td>${list.available}</td>
         </tr>
     </tbody>
 </table>

<!-- ===== Footer ===== -->
<footer class="bg-dark text-white text-center p-3 fixed-bottom">
    © 2026 Cloth Store
</footer>

</body>
</html>
