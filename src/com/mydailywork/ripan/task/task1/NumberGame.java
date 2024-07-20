package com.mydailywork.ripan.task.task1;

import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {

        boolean playAgain = true ;
        int numberOfAttempts = 3 ;
        int lowRange = 0, highRange = 100;
        Scanner scan = new Scanner(System.in);

        while(playAgain) {
            Game game = new Game();
            int targetNumber = game.getRandomNumber(lowRange, highRange);
            int attemptsLeft = numberOfAttempts;

            while(attemptsLeft > 0) {
                System.out.println("+++++ Welcome to the Number Game. +++++ ");
                System.out.println("You have " + attemptsLeft + " attempts left. Guess the number..");

                System.out.print("Enter your guess: ");
                int guess = scan.nextInt();
                String result = game.compare(guess, targetNumber);

                if(result.equalsIgnoreCase("correct")){
                    System.out.println("Guessed Number is "+guess+" and "+" Target Number is "+targetNumber);
                    System.out.println("Congratulations! You guessed the number.");
                    break;
                }else if(result.equalsIgnoreCase("too high")){
                    System.out.println("Guessed Number is "+guess+" and "+" Target Number is "+targetNumber);
                    System.out.println("Too high. Try again.");
                    attemptsLeft--;
                }else {
                    System.out.println("Guessed Number is "+guess+" and "+" Target Number is "+targetNumber);
                    System.out.println("Too low. Try again.");
                    attemptsLeft--;
                }
                if(attemptsLeft == 0){
                    System.out.println("You have no more attempts. The number was " + targetNumber);
                }
            }

            System.out.println("Do you want to play again? (yes/no)");
            String answer = scan.next();
            playAgain = answer.equalsIgnoreCase("yes");
        }
    }
}
