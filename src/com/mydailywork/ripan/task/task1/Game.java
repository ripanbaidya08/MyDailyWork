package com.mydailywork.ripan.task.task1;

public class Game {

    // this method will generate the random number..
    public int getRandomNumber(int min, int max) {
        if (min < max) {
            return (int) (Math.random() * (max - min + 1) + min);
        }
        return 0;
    }

    // compare the gueesed number with the generated target number..
    public String compare(int guess, int randomNumber) {
        if (guess == randomNumber) {
            return "correct";
        } else if(guess > randomNumber) {
            return "too high";
        } else {
            System.out.println("too low");
            return "too low";
        }
    }
}
