<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Response</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card shadow p-4">

                <h5 class="text-center text-success mb-3">
                    Submit Your Response
                </h5>

<div class="alert alert-success text-center">
                        ${msg}
                    </div>
                <!-- ✅ Success message after submit -->
                <c:if test="${not empty successMsg}">
                    <div class="alert alert-success text-center">
                        ${msg}
                    </div>
                </c:if>

                <!-- ❌ Error message (optional) -->
                <c:if test="${not empty errorMsg}">
                    <div class="alert alert-danger text-center">
                        ${errorMsg}
                    </div>
                </c:if>



            </div>

        </div>
    </div>
</div>

</body>
</html>
