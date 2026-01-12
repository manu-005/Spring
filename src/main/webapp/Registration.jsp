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

<!-- Cloth Registration Form -->
<div class="container mt-5 mb-5">
    <h3 class="text-center mb-4">Cloth Registration</h3>

    <form action="clothRegister" method="post" class="col-md-8 mx-auto">


${success}${error}

        <!-- Cloth Name -->
        <div class="mb-3">
            <label class="form-label">Cloth Name</label>
            <input type="text" name="clothName" class="form-control" required>
        </div>

        <!-- Brand -->
        <div class="mb-3">
            <label class="form-label">Brand</label>
            <input type="text" name="brand" class="form-control" required>
        </div>

        <!-- Type -->
        <div class="mb-3">
            <label class="form-label">Type</label>
            <input type="text" name="type" class="form-control" placeholder="Shirt / Pant / Saree">
        </div>

        <!-- Size -->
        <div class="mb-3">
            <label class="form-label">Size</label>
            <select name="size" class="form-select" required>
                <option value="">Select Size</option>
                <option>S</option>
                <option>M</option>
                <option>L</option>
                <option>XL</option>
                <option>XXL</option>
            </select>
        </div>

        <!-- Color -->
        <div class="mb-3">
            <label class="form-label">Color</label>
            <input type="text" name="color" class="form-control">
        </div>

        <!-- Price -->
        <div class="mb-3">
            <label class="form-label">Price (₹)</label>
            <input type="number" name="price" class="form-control" step="0.01" required>
        </div>

        <!-- Material -->
        <div class="mb-3">
            <label class="form-label">Material</label>
            <input type="text" name="material" class="form-control">
        </div>

        <!-- Availability -->
        <div class="mb-3 form-check">
            <input type="checkbox" name="available" class="form-check-input" value="true">
            <label class="form-check-label">Available</label>
        </div>

        <!-- Submit -->
        <button type="submit" class="btn btn-success w-100">Register Cloth</button>
    </form>
</div>

<!-- Footer -->
<footer class="bg-dark text-white text-center p-3 ">
    © 2026 Cloth Store
</footer>

</body>
</html>
