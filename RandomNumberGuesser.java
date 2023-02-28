/* Class: CMSC203

Instructor:Grigorly
Description: This class generates a random integer between 0 and 100 and asks the user to guess repeatedly until they guess correctly.
Due: 02/27/2023
Platform/Compiler: Java 11, Eclipse
I pledge that I have completed the programming
assignment independently. I have not copied the code
from a student or any source. I have not given my code
to any student.
Student: godofredo adrian
*/
import java.util.Scanner;

public class RandomNumberGuesser {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int nextGuess;
		String nextGame;
		
		do {
			int randNum = RNG.rand();
			int lowGuess = 0, highGuess = 100, numGuesses = 1;
			
			System.out.println("This application generates a random integer between 0 and 100");
			System.out.println("and asks the user to guess repeatedly until they guess correctly.\n");
			System.out.print("Enter your first guess:\n");
			nextGuess = input.nextInt();
			
			while(nextGuess != randNum && numGuesses < 7) {
				if(nextGuess > randNum) {
					System.out.println("Your guess is too high");
					highGuess = nextGuess;
				} else {
					System.out.println("Your guess is too low");
					lowGuess = nextGuess;
				}
				System.out.println("Number of guesses is: " + numGuesses);
				System.out.print("Enter your next guess between " + lowGuess + " and " + highGuess + ":\n");
				nextGuess = input.nextInt();
				while(!RNG.inputValidation(nextGuess, lowGuess, highGuess)) {
					System.out.println("Your guess must be an integer between " + lowGuess + " and " + highGuess + ".");
					System.out.print("Enter your next guess between " + lowGuess + " and " + highGuess + ":\n");
					nextGuess = input.nextInt();
				}
				numGuesses++;
			}
			
			if(numGuesses < 7) {
				System.out.println("Congratulations, you guessed correctly");
			} else {
				System.out.println("You have exceeded the maximum number of guesses, 7.");
			}
			
			System.out.print("Try again? (yes or no)\n");
			nextGame = input.next().toLowerCase();
			while(!nextGame.equals("yes") && !nextGame.equals("no")) {
				System.out.println("Invalid input. Enter yes or no.");
				nextGame = input.next().toLowerCase();
			}
			
			if(nextGame.equals("no")) {
				System.out.println("Thanks for playing...");
			}
			
			RNG.resetCount();
			
		} while(nextGame.equals("yes"));
		
		input.close();
		
	}
}