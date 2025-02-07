package Task001;

import java.util.Random;
import java.util.Scanner;

public class guessnumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minNum = 1;
        int maxNum = 100;
        int score = 0;

        System.out.println("Welcome to the Unique Number Guessing Game!");

        while (true) {
            System.out.println("Choose your difficulty level:");
            System.out.println("1. Easy (10 attempts)");
            System.out.println("2. Medium (7 attempts)");
            System.out.println("3. Hard (5 attempts)");
            System.out.print("Enter your choice (1/2/3): ");

            int attemptsLimit = 7; // Default is Medium
            if (scanner.hasNextInt()) {
                int difficulty = scanner.nextInt();
                switch (difficulty) {
                    case 1:
                        attemptsLimit = 10;
                        break;
                    case 2:
                        attemptsLimit = 7;
                        break;
                    case 3:
                        attemptsLimit = 5;
                        break;
                    default:
                        System.out.println("Invalid choice. Defaulting to Medium difficulty.");
                        attemptsLimit = 7;
                        break;
                }
            } else {
                System.out.println("Invalid input. Defaulting to Medium difficulty.");
                scanner.next(); // Clear invalid input
            }

            int targetNumber = random.nextInt(maxNum - minNum + 1) + minNum;
            int attempts = 0;
            System.out.println("\nI'm thinking of a number between " + minNum + " and " + maxNum + ". Can you guess it?");

            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear invalid input
                    continue;
                }
                int guess = scanner.nextInt();
                attempts++;

                if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score++;
                    break;
                }

                if (attempts < attemptsLimit) {
                    int remainingAttempts = attemptsLimit - attempts;
                    if (Math.abs(targetNumber - guess) <= 5) {
                        System.out.println("Hot! You're very close.");
                    } else if (Math.abs(targetNumber - guess) <= 10) {
                        System.out.println("Warm! You're getting closer.");
                    } else {
                        System.out.println("Cold! You're far off.");
                    }
                    System.out.println("You have " + remainingAttempts + " attempts left.");
                } else {
                    System.out.println("Sorry, you're out of attempts! The correct number was " + targetNumber + ".");
                }
            }

            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // Consume the leftover newline character
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Your final score is: " + score);
                break;
            }
        }
        scanner.close();
    }
}
