import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
//Guess number game

    public static void main(String[] args) {
        welcomePlayer();
        playTheGameLoop();
    }

    private static void welcomePlayer() {
        System.out.println("\n");
        System.out.println("Welcome to the Game!");
        System.out.println("Your task is to guess the number between 0 and 99 in 5 tries.");
    }

    private static void printTriesLeft(int numberOfTriesLeft) {
        if (numberOfTriesLeft > 0) {
            System.out.println("You have " + numberOfTriesLeft + " tries left.");
            System.out.println("Please try again");
        } else {
            System.out.println("This was your last try.");
        }
    }

    private static boolean checkTriesLeft(int numberOfTriesLeft) {
        return numberOfTriesLeft > 0;
    }

    private static void playTheGameLoop() {
        int numberToGuess = new Random().nextInt(100);
        int triesLeft = 5;

        Scanner scanner = new Scanner(System.in);
        boolean winner = false;

        while (checkTriesLeft(triesLeft)) {

            System.out.println("\n");
            System.out.println("Try to guess a number between 0 and 99");

            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number! Please stick to values between 0 and 99");
                scanner.next();
            }

            int attemptedNumber = scanner.nextInt();

            if (attemptedNumber >= 0 && attemptedNumber < 100) {
                triesLeft--;

                if (attemptedNumber > numberToGuess) {
                    System.out.println("Your number is GREATER than the one you are trying to guess");

                    if (checkTriesLeft(triesLeft)) {
                        printTriesLeft(triesLeft);
                        continue;
                    } else printTriesLeft(triesLeft);
                    break;
                }

                if (attemptedNumber < numberToGuess) {
                    System.out.println("Your number is LOWER than the one you are trying to guess");

                    if (checkTriesLeft(triesLeft)) {
                        printTriesLeft(triesLeft);
                        continue;
                    } else printTriesLeft(triesLeft);
                    break;
                }

                System.out.println("You guessed it!");
                winner = true;
                break;

            } else {
                System.out.println("Number incorrect. Please stick to values between 0 and 99");
            }
        }
        if (!winner) {
            System.out.println("Sorry you didn't guess the number, the answer was: " + numberToGuess);
        }
    }
}