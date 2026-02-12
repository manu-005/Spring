<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

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

            <div class="card p-4 shadow">
                <h5 class="text-center text-success mb-3">Submit Your Response</h5>

                <!-- ✅ Success Message -->
                <c:if test="${not empty successMsg}">
                    <div class="alert alert-success text-center">
                        ${successMsg}
                    </div>
                </c:if>

                <form action="submitStudentResponse" method="post">
                    <input type="hidden" name="studentEmail" value="${email}" />

                    <div class="mb-3">
                        <label class="form-label">Your Response</label>
                        <textarea name="response"
                                  class="form-control"
                                  rows="4"
                                  placeholder="Type your response here..."
                                  required></textarea>
                    </div>

                    <button type="submit" class="btn btn-success w-100">
                        Submit Response
                    </button>
                </form>
${email}
            </div>

        </div>
    </div>
</div>

</body>
</html>
