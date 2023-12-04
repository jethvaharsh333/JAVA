import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to number guessing game!");
        System.out.println("You will have 2 rounds.");
        System.out.println("In each round you can guess the number 7 times.");

        int lb = 1;
        int ub = 100;
        int numberOfAttempts = 7;
        int numberOfRounds = 2;
        int totalScore = 0;

        for (int round = 1; round <= numberOfRounds; round++) {
            int targetNumber = generateRandomNumber(lb, ub);
            int roundScore = playRound(targetNumber, numberOfAttempts);
            totalScore += roundScore;
            displayRoundResult(round, roundScore, totalScore);
        }

        System.out.println("\nGame over! Your total score is: " + totalScore);
        scanner.close();
    }

    static int generateRandomNumber(int lb, int ub) {
        return new Random().nextInt(ub - lb + 1) + lb;
    }

    static int playRound(int targetNumber, int numberOfAttempts) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        System.out.println("\nGuess the number between 1 and 100");

        while (attempts < numberOfAttempts) {
            System.out.print("Enter your guess: ");

            if (scanner.hasNextInt()) {
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("You guessed the correct number in " + attempts + " attempt.");
                    return numberOfAttempts - attempts + 1;
                } else if (userGuess < targetNumber) {
                    System.out.println("Try again! Hint: The number is higher.");
                } else {
                    System.out.println("Try again! Hint: The number is lower.");
                }
            } else {
                System.out.println("Invalid input.");
                scanner.next();
            }
        }

        System.out.println("Attempts over. The correct number was: " + targetNumber);
        return 0;
    }

    static void displayRoundResult(int round, int roundScore, int totalScore) {
        System.out.println("Round " + round + " Score: " + roundScore);
        System.out.println("Total Score: " + totalScore);
    }
}
