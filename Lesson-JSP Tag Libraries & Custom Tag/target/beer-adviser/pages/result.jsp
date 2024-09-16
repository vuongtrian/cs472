<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ct" uri="http://example.com/tags" %>
<html>
<head>
    <title>Beer Recommendations</title>
    <style>
        /* Basic page styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            width: 100%;
            text-align: center;
        }

        h2 {
            color: #2c3e50;
            margin-bottom: 20px;
        }

        .beer-list {
            list-style-type: none;
            padding: 0;
        }

        .beer-list li {
            background-color: #eee;
            margin: 10px 0;
            padding: 10px;
            border-radius: 5px;
        }

        .date-time {
            color: red;
            font-size: 12px;
            margin-top: 20px;
        }

        .back-button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #3498db;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .back-button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Beer Recommendations</h2>

        <div>
            <ul class="beer-list">
                <!-- Display beer styles from the request attribute -->
                <c:forEach var="style" items="${styles}">
                    <li>Try: ${style}</li>
                </c:forEach>
            </ul>
        </div>

        <!-- Display current date and time -->
        <div class="date-time">
            <ct:currentDateTime color="red" size="12px" />
        </div>

        <!-- Back to selection link -->
        <div>
            <a href="pages/selectBeer.jsp" class="back-button">Back to Selection</a>
        </div>
    </div>
</body>
</html>