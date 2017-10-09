package palindrome;

import java.util.Scanner;

/**
 * A Palindrome is a sequence of characters which reads the same backward as
 * forward. Examples: anna, civic, kayak, level, madam,... We will consider only
 * numbers that can be called Palindrome. For example: 1001, 242, 99988999,...
 * The program will ask the user to enter a number (int), between 0 and
 * 1,000,000,000. It will check the input and proceed only when the input is
 * finally correct. If the input is NOT a Palindrome it will print a suitable
 * message and finish. Else, it will print the following (see examples next): 1:
 * the length of the number 2: the first part of the Palindrome with spaces
 * between the characters 3: the second part of the Palindrome with spaces
 * between the characters NOTES: 1. You must use ONLY things we learned
 * (don'tdepend on string manipulations for example) 2. Leading zeros don't
 * count. For example, 00100 is NOT a Palindrome because the real number is 100
 *
 * Examples: 1. Input: 13531 Output: size = 5 First part = 1 3 5 (with a space
 * between each 2 characters) Second part = 5 3 1 (with a space between each 2
 * characters) 2. Input: 98433489 Output: size = 8 First part = 9 8 4 3 (with a
 * space between each 2 characters) Second part = 3 4 8 9 (with a space between
 * each 2 characters)
 */

public class Palindrome {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number :");
		int number = input.nextInt();
		boolean numberNotCorrect = true;
		while (numberNotCorrect && (number < 0 || number > 1000000000)) {// Check if the number is correct else ask the
																			// user to enter anther number
			System.out.println("Error(number most be in range of 0-1000000000 ) . Enter anther number ");
			number = input.nextInt();
		}
		input.close();// closing the input
		int testNumber = number; // a number for finding the length of the inputed number
		int counter = 1;// a counter for counting the length starting at 1 because the smallest digit is
						// 1

		while ((testNumber / 10) != 0) {// counting the length

			testNumber = testNumber / 10;
			counter++;
		}

		int copiedNumberToArray = number;
		byte[] arrayNumber = new byte[counter];// initialize an array to pot in it the numbers digits
		for (int index = arrayNumber.length - 1; index >= 0; index--) {// a loop that pots the number digits in the
																		// array
			if ((copiedNumberToArray / 10) != 0) {// copy the digits except the last digit into the array
				arrayNumber[index] = (byte) (copiedNumberToArray % 10);
				copiedNumberToArray = copiedNumberToArray / 10;
			} else {// copy the last digit into the array
				arrayNumber[index] = (byte) (copiedNumberToArray % 10);
			}
		}

		int halfOfArrayLength = (arrayNumber.length - 1) / 2;// calculate the Midpoint the array initialize a pointer to
																// the first half
		int secondHalfOfArray = ((arrayNumber.length - 1) / 2) + ((arrayNumber.length - 1) % 2);// initialize a pointer
																								// to the second half

		// is the number a palindrome number
		int firstHalfOfTheArray = halfOfArrayLength;
		int secondHalfOfTheArray = secondHalfOfArray;

		int counterForTestIfTheNumberIsPalindrome = 0;
		while (firstHalfOfTheArray >= 0 && secondHalfOfTheArray < arrayNumber.length) {
			if (arrayNumber[firstHalfOfTheArray] == arrayNumber[secondHalfOfTheArray]) {
				counterForTestIfTheNumberIsPalindrome++;
			}
			firstHalfOfTheArray--;
			secondHalfOfTheArray++;
		}

		if ((counterForTestIfTheNumberIsPalindrome * 2) - ((arrayNumber.length) % 2) == arrayNumber.length) {
			System.out.println("size = " + counter);
			System.out.print("First part = ");
			for (int index = 0; index <= halfOfArrayLength; index++) {

				System.out.print(arrayNumber[index] + " ");
			}
			System.out.println();
			System.out.print("second part = ");
			for (int i = secondHalfOfArray; i < arrayNumber.length; i++) {

				System.out.print(arrayNumber[i] + " ");
			}
		} else {
			System.out.println("the number you enterd is not a palindrome number :) ");
		}

	}

}
