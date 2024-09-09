package com.example.quiz;


public class SequenceDatabase {
    private static final String[] SEQUENCES = {
            "3, 1, 4, 1, 5",  // Next: 9 (π sequence)
            "1, 1, 2, 3, 5",  // Next: 8 (Fibonacci sequence)
            "1, 2, 4, 8, 16",   // Next: 32 (Powers of 2)
            "1, 4, 9, 16, 25",   // Next: 36 (Squares)
            "2, 3, 5, 7, 11"  // Next: 13 (Primes)
    };

    private static final int[] ANSWERS = {9, 8, 32, 36, 13};
    private static final String[] HINTS = {"9", "8", "32", "36", "13"};

    // Retrieve a sequence by index
    public static String fetchSequence(int index) {
        return index >= 0 && index < SEQUENCES.length ? SEQUENCES[index] : null;
    }

    // Retrieve the correct answer by index
    public static int fetchAnswer(int index) {
        return index >= 0 && index < ANSWERS.length ? ANSWERS[index] : -1;
    }

    public static String fetchHint(int index) {
        return index >= 0 && index < HINTS.length ? HINTS[index] : null;
    }

    // Get the total number of sequences
    public static int getSequenceCount() {
        return SEQUENCES.length;
    }
}
