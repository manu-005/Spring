<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-success-subtle">

<!-- Main Content -->
<div class="container d-flex justify-content-center align-items-center" style="min-height: 75vh;">
    <div class="card shadow p-4" style="width: 100%; max-width: 600px;">
        <h4 class="text-center text-success mb-3">Send Your Response</h4>

        <form action="submitStudentResponse" method="post">
      <input type="hidden"  name="studentEmail"  value="${email}">
            <div class="mb-3">
                <label class="form-label fw-medium">Your Message</label>
                <textarea name="responseText"
                          class="form-control"
                          rows="5"
                          placeholder="Type your response here..."
                          required></textarea>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-success px-4">
                    Send Response
                </button>
            </div>
        </form>
    </div>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
