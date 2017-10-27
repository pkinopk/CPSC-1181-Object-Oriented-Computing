
//This game request a number between 1 and MAX_RANGE from the user, and after the number is chosen the game challenges the user with random multiplications questions based on the number picked by the user.

import java.util.Random;

import javax.swing.JOptionPane;

public class MultiplicationTables {

	public static final int MAX_RANGE = 12; // Max number determine the range of
											// number to be played
	public static final int NUM_QUESTIONS = 5; // Number of times the game will
												// execute before asking if the
												// user wants to play again
	public static int correct = 0; // Holds the number of correct answers
	public static int incorrect = 0; // Hold the number of incorrect answers

	public static void main(String[] args) {

		// Welcome message
		output("Hello, we are going o test your multiplication skills", "Welcome!", JOptionPane.PLAIN_MESSAGE);

		// Read input until valid
		int intValue = readNumber();
		// Make the input value to be always a int instead of string

		boolean wantToPlay = true;
		while (wantToPlay) {
			playGame(intValue);
			wantToPlay = checkIfUserWantsToPlay();
			if (wantToPlay)
				intValue = readNumber();
		}
		output("You got " + correct + " correct answers and " + incorrect + " incorrect answers.", "Thanks for playing",
				JOptionPane.PLAIN_MESSAGE);

	}

	// Reads a string from a graphical dialog box containing a custom message,
	// title and icon (msgType)
	public static String input(String msg, String title, int msgType) {
		return JOptionPane.showInputDialog(null, msg, title, msgType);
	}

	// Outputs a string in a graphical dialog box containing a custom message,
	// title and icon (msgType)
	public static void output(String msg, String title, int msgType) {
		JOptionPane.showMessageDialog(null, msg, title, msgType);
	}

	// Check if input is valid
	public static boolean isNumberInRange(String str, int min, int max) {

		try {
			int n = Integer.parseInt(str);
			if (n >= min && n <= max && isPositiveNumber(str))
				return true;
			else
				return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// Generates a random integer between 1 and range
	public static int getRandomInt(int range) {
		Random rnd = new Random();
		int i = rnd.nextInt(range) + 1;
		return i;
	}

	// Initiate the game
	public static void playGame(int intValue) {
		int answer;
		for (int i = 0; i < NUM_QUESTIONS; i++) {
			int beforeOrAfter = getRandomInt(2);
			int random = getRandomInt(MAX_RANGE);
			String str = "";
			if (beforeOrAfter == 1)
				str = "How much is " + random + " * " + intValue + "?";
			else
				str = "How much is " + intValue + " * " + random + "?";

			String strAnswer = input(str, "Please enter a number", 3);
			if (isNumberInRange(strAnswer, 0, Integer.MAX_VALUE)) {
				answer = Integer.parseInt(strAnswer);
			} else {
				answer = -1;
			}
			if (answer == random * intValue) {
				output("Correct", "You got it!", JOptionPane.INFORMATION_MESSAGE);
				correct++;
			} else {
				output("Incorrect, the right answer is: " + random * intValue, "Maybe next time",
						JOptionPane.ERROR_MESSAGE);
				incorrect++;
			}
		}
	}

	// Prompt user to check if they want to continue playing
	public static boolean checkIfUserWantsToPlay() {
		int check = (JOptionPane.showConfirmDialog(null, "Another round?", "Do you want to play again?",
				JOptionPane.YES_NO_OPTION));
		if (check == 0)
			return true;
		else
			return false;
	}

	// Reads a number from the user and ensure its a valid number
	public static int readNumber() {
		String inputValue = "0";
		while (!isNumberInRange(inputValue, 1, MAX_RANGE))
			inputValue = input("Enter a number between 1 and 12: ", "Please enter a number", 3);
		int intValue = Integer.parseInt(inputValue);
		return intValue;
	}

	// Check if a number is positive
	public static boolean isPositiveNumber(String str) {
		try {
			int n = Integer.parseInt(str);
			if (n >= 0)
				return true;
			else
				return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
