package com.example.quiz;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class QuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = getOrCreateQuiz(session);
        doPost(request, response); // Forwarding to doPost for handling logic
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Quiz quiz = getOrCreateQuiz(session);

        // Initialize request attributes with default values
        setDefaultRequestAttributes(request);

        String action = request.getParameter("action");
        if (quiz != null) {
            handleAction(action, quiz, request);
        }

        // Check if the quiz is over
        if (!quiz.hasMoreQuestions()) {
            handleQuizCompletion(request, response, session, quiz);
        } else {
            displayNextQuestion(request, response, quiz);
        }
    }

    // Helper method to either retrieve or create a new quiz
    private Quiz getOrCreateQuiz(HttpSession session) {
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        if (quiz == null) {
            quiz = new Quiz();
            session.setAttribute("quiz", quiz);
        }
        return quiz;
    }

    // Helper method to initialize request attributes
    private void setDefaultRequestAttributes(HttpServletRequest request) {
        request.setAttribute("hint", null);
        request.setAttribute("correctAnswer", null);
        request.setAttribute("error", null);
    }

    // Method to handle quiz actions (hint or submit)
    private void handleAction(String action, Quiz quiz, HttpServletRequest request) {
        if ("hint".equals(action)) {
            request.setAttribute("hint", quiz.getCurrentHint());
        } else if ("submit".equals(action)) {
            handleAnswerSubmission(quiz, request);
        }
    }

    // Method to handle the answer submission logic
    private void handleAnswerSubmission(Quiz quiz, HttpServletRequest request) {
        String answer = request.getParameter("answer");
        String ageStr = request.getParameter("age");

        try {
            int age = Integer.parseInt(ageStr);
            if (age < 4 || age > 100) {
                request.setAttribute("error", "Age must be between 4 and 100.");
            } else {
                request.setAttribute("age", age);
                int userAnswer = Integer.parseInt(answer);
                if (!quiz.checkAnswer(userAnswer)) {
                    request.setAttribute("correctAnswer", quiz.getCurrentAnswer());
                }
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Please enter a valid number.");
        }
    }

    // Method to handle quiz completion logic
    private void handleQuizCompletion(HttpServletRequest request, HttpServletResponse response,
                                      HttpSession session, Quiz quiz) throws ServletException, IOException {
        int score = quiz.getScore();
        request.setAttribute("score", score);
        request.setAttribute("finalScore", score);
        request.setAttribute("totalQuestions", SequenceDatabase.getSequenceCount());
        request.setAttribute("grade", determineGrade(score));

        request.getRequestDispatcher("/pages/result.jsp").forward(request, response);
        session.setAttribute("quiz", null);
    }

    // Method to determine grade based on score
    private String determineGrade(int score) {
        if (score >= 45) {
            return "A";
        } else if (score >= 35) {
            return "B";
        } else if (score >= 25) {
            return "C";
        } else {
            return "NC";
        }
    }

    // Method to display the next question in the quiz
    private void displayNextQuestion(HttpServletRequest request, HttpServletResponse response, Quiz quiz)
            throws ServletException, IOException {
        request.setAttribute("question", quiz.getCurrentQuestion());
        request.setAttribute("score", quiz.getScore());
        request.getRequestDispatcher("/pages/quiz.jsp").forward(request, response);
    }
}
