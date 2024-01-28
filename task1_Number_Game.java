package src.method;
import java.util.Random;
import java.util.Scanner;

public class  task1_Number_Game{

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();

	        System.out.println("Welcome to the Number Guessing Game!");

	        // Additional details
	        int maxRange = 100; // Maximum value for the generated number
	        int rounds = 0; // Number of rounds played
	        int totalAttempts = 0; // Total attempts across all rounds

	        // Game loop
	        do {
	            int targetNumber = random.nextInt(maxRange) + 1;
	            int userGuess;
	            int attempts = 0;

	            System.out.println("\nRound " + (rounds + 1) + ": Guess the number between 1 and " + maxRange);

	            // Guessing loop
	            do {
	                System.out.print("Enter your guess: ");
	                userGuess = scanner.nextInt();

	                // Check the user's guess
	                if (userGuess == targetNumber) {
	                    System.out.println("Congratulations! You guessed the correct number!");
	                } else if (userGuess < targetNumber) {
	                    System.out.println("Too low. Try again.");
	                } else {
	                    System.out.println("Too high. Try again.");
	                }

	                attempts++;

	            }
	            while (userGuess != targetNumber);

	            // Display result of the round
	            if (userGuess == targetNumber) {
	                System.out.println("You guessed the number in " + attempts + " attempts!");
	                totalAttempts += attempts;
	            } else {
	                System.out.println("Sorry, you couldn't guess the number. The correct number was: " + targetNumber);
	            }

	            // Ask the user if they want to play another round
	            System.out.print("Do you want to play another round? (yes/no): ");
	            String playAgain = scanner.next().toLowerCase();

	            if ("yes".equals(playAgain)) {
	                rounds++;
	            } else {
	                break;
	            }

	        } while (true);

	        // Display final score
	        System.out.println("\nGame Over!");
	        System.out.println("Total rounds played: " + (rounds + 1));
	        System.out.println("Total attempts: " + totalAttempts);

	        scanner.close();
    }
}
