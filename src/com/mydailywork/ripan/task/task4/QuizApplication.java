package com.mydailywork.ripan.task.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class QuizApplication {
    private static final int TIME_LIMIT_SECONDS = 10; // Time limit for each question
    private static int score = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Question> questions = loadQuestions();
        for (Question question : questions) {
            askQuestion(scanner, question);
        }

        displayResults();
        scanner.close();
    }

    private static List<Question> loadQuestions() {
        List<Question> questions = new ArrayList<>();

        // Add questions here
        questions.add(new Question("What is the capital of France?", "A. Paris", "B. London", "C. Berlin", "D. Madrid", "A"));
        questions.add(new Question("Which planet is known as the Red Planet?", "A. Earth", "B. Venus", "C. Mars", "D. Jupiter", "C"));

        return questions;
    }

    private static void askQuestion(Scanner scanner, Question question) {
        System.out.println(question.getQuestion());
        System.out.println(question.getOptions());

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        final boolean[] answered = {false};

        // Start the timer
        executor.schedule(() -> {
            if (!answered[0]) {
                System.out.println("\nTime's up!");
                executor.shutdownNow();
            }
        }, TIME_LIMIT_SECONDS, TimeUnit.SECONDS);

        // Get user input
        String answer = "";
        System.out.print("Enter your answer: ");
        while (!answered[0]) {
            if (scanner.hasNextLine()) {
                answer = scanner.nextLine();
                answered[0] = true;
                executor.shutdownNow();
            }
        }

        // Check answer
        if (answer.equalsIgnoreCase(question.getCorrectAnswer())) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer was " + question.getCorrectAnswer());
        }
    }

    private static void displayResults() {
        System.out.println("\nQuiz Over!");
        System.out.println("Your final score is: " + score);
    }

    static class Question {
        private String question;
        private String optionA;
        private String optionB;
        private String optionC;
        private String optionD;
        private String correctAnswer;

        public Question(String question, String optionA, String optionB, String optionC, String optionD, String correctAnswer) {
            this.question = question;
            this.optionA = optionA;
            this.optionB = optionB;
            this.optionC = optionC;
            this.optionD = optionD;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestion() {
            return question;
        }

        public String getOptions() {
            return optionA + "\n" + optionB + "\n" + optionC + "\n" + optionD;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }
    }
}
