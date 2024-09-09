<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quiz - The Number Quiz</title>
</head>
<body>
<h2>The Number Quiz</h2>
<p>Your current sore is <strong>${score}.</strong></p>
<p>Guess the next number in the sequence:</p>

<form action="quiz" method="post">
    <input type="hidden" name="action" value="submit">

    <!-- Display current question -->
    <p>Question: ${question}</p>

    <p>Your answer:
        <input type="text" name="answer" required>
    </p>

    <!-- Input for user's age -->
    <label for="age">Your Age:</label>
    <input type="text" id="age" name="age" value="${age != null ? age : ''}">
    <c:if test="${error != null}">
        <p style="color: red;">${error}</p>
    </c:if>

    <input type="submit" value="Submit">
</form>

<!-- Button to get a hint -->
<form action="quiz" method="post">
    <input type="hidden" name="action" value="hint">

    <!-- Display hint if available -->
    <c:if test="${hint != null}">
        <p>Hint: ${hint}</p>
    </c:if>

    <!-- Display correct answer if user has failed after 3 attempts -->
    <c:if test="${correctAnswer != null}">
        <p style="color: red;">Correct Answer: ${correctAnswer}</p>
    </c:if>

    <button type="submit">Hint</button>
</form>

</body>
</html>
