<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error - The Number Quiz</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            color: #333;
            text-align: center;
            padding: 50px;
        }

        .error-container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            display: inline-block;
        }

        .error-container h1 {
            font-size: 48px;
            color: #dc3545;
        }

        .error-container p {
            font-size: 18px;
        }

        .error-details {
            margin-top: 20px;
            color: #777;
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="error-container">
    <h1>Oops! Something went wrong.</h1>
    <p>We're sorry, but an unexpected error occurred while processing your request.</p>

    <!-- Display error details only if available -->
    <div class="error-details">
        <c:if test="${not empty exception}">
            <p>Error Details: ${exception.message}</p>
        </c:if>
    </div>

    <p><a href="/quiz-app">Return to Home</a></p>
</div>
</body>
</html>
