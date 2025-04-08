import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalGames = 0;
        int gamesWon = 0;
        int gamesLost = 0;

        boolean playAgain = true;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        while (playAgain) {
            System.out.println("\nChoose Difficulty Level:");
            System.out.println("1. Easy (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard (1-200, 5 attempts)");
            System.out.print("Enter your choice (1-3): ");
            int choice = sc.nextInt();

            int maxRange = 100;
            int maxAttempts = 7;

            switch (choice) {
                case 1:
                    maxRange = 50;
                    maxAttempts = 10;
                    break;
                case 2:
                    maxRange = 100;
                    maxAttempts = 7;
                    break;
                case 3:
                    maxRange = 200;
                    maxAttempts = 5;
                    break;
                default:
                    System.out.println("Invalid choice! Defaulting to Medium.");
            }

            int randomNumber = rand.nextInt(maxRange) + 1;
            int userGuess;
            int attempts = 0;
            boolean isGuessed = false;

            System.out.println("\n🎮 Game Started! You have " + maxAttempts + " attempts to guess a number between 1 and " + maxRange);

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                userGuess = sc.nextInt();
                attempts++;

                if (userGuess < randomNumber) {
                    System.out.println("Too low!");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                    isGuessed = true;
                    break;
                }
            }

            totalGames++;
            if (isGuessed) {
                gamesWon++;
            } else {
                gamesLost++;
                System.out.println("❌ Out of attempts! The number was: " + randomNumber);
            }

            // Ask if user wants to play again
            System.out.print("\nDo you want to play again? (yes/no): ");
            sc.nextLine(); // clear buffer
            String response = sc.nextLine().trim().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
            }
        }

        // Final score summary
        System.out.println("\n📊 Game Summary:");
        System.out.println("Total Games Played: " + totalGames);
        System.out.println("Games Won: " + gamesWon);
        System.out.println("Games Lost: " + gamesLost);
        System.out.println("Thanks for playing, 👋");

        sc.close();
    }
}
