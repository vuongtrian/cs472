package com.example.quiz;

public class Quiz {
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int attempt = 0;

    // Get the current question from SequenceDatabase
    public String getCurrentQuestion() {
        return SequenceDatabase.fetchSequence(currentQuestionIndex);
    }

    public String getCurrentAnswer() {
        if (attempt == 0) {
            return Integer.toString(SequenceDatabase.fetchAnswer(currentQuestionIndex));
        }
        return null;
    }

    public String getCurrentHint() {
        return SequenceDatabase.fetchHint(currentQuestionIndex);
    }

    // Check the user's answer
    public boolean checkAnswer(int userAnswer) {
        int correctAnswer = SequenceDatabase.fetchAnswer(currentQuestionIndex);
        if (userAnswer == correctAnswer) {
            score += (attempt == 0) ? 10 : (attempt == 1) ? 5 : 2;
            currentQuestionIndex++;
            attempt = 0; // reset attempts for the next question
            return true;
        }
        attempt++;
        if (attempt >= 3) {
            attempt = 0;
            currentQuestionIndex++;
        }
        return false;
    }

    // Move to the next question
    public void nextQuestion() {
        currentQuestionIndex++;
    }

    // Check if there are more questions
    public boolean hasMoreQuestions() {
        return currentQuestionIndex < SequenceDatabase.getSequenceCount();
    }

    // Get the current score
    public int getScore() {
        return score;
    }
}
