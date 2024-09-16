<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ct" uri="http://example.com/tags" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Beer Recommendations</title>
    <style>
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            font-family: Arial, sans-serif;
        }
        .beer-list {
            list-style-type: none;
            padding-left: 0;
        }
        .beer-list li {
            margin: 5px 0;
            font-size: 16px;
            color: #333;
        }
        .date-time {
            margin-top: 20px;
            font-size: 14px;
            color: #888;
        }
        .back-button {
            margin-top: 20px;
            display: inline-block;
            padding: 10px 20px;
            background-color: #007BFF;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
        }
        .back-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Beer Recommendations</h2>

    <ul class="beer-list">
        <!-- Display beer styles from the request attribute -->
        <c:forEach var="style" items="${styles}">
            <li>Try: ${style}</li>
        </c:forEach>
    </ul>

    <!-- Display current date and time -->
    <div class="date-time">
        <ct:currentDateTime color="red" size="12px" />
    </div>

    <!-- Back to selection link -->
    <div>
        <a href="selectBeer.jsp" class="back-button">Back to Selection</a>
    </div>
</div>
</body>
</html>
