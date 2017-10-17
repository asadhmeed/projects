package rotationCheck;

import java.util.Scanner;

public class RotationCheck {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("welcome..");
		System.out.println("Totation Check");
		System.out.print("enter the first number : ");
		int firstNumber = input.nextInt();

		while (firstNumber < 0 || firstNumber > 1000000000) {
			System.out.print("error enter number between 0 and 1000000000 : ");
			firstNumber = input.nextInt();
			System.out.println();
		}
		System.out.print("enter the second number :");
		int secondNumber = input.nextInt();

		while (secondNumber < 0 || secondNumber > 1000000000) {
			System.out.print("error enter number between 0 and 1000000000 : ");
			secondNumber = input.nextInt();
			System.out.println();
		}

		int firstNumberDigitCount = 0;
		int secondNumberDigitCount = 0;
		int tempFirstNumber = firstNumber;
		int tempSecondNumber = secondNumber;
		while (tempFirstNumber != 0 && tempSecondNumber != 0) {
			if (tempFirstNumber % 10 != 0) {
				firstNumberDigitCount++;
				tempFirstNumber = tempFirstNumber / 10;
			}
			if (tempSecondNumber % 10 != 0) {
				secondNumberDigitCount++;
				tempSecondNumber = tempSecondNumber / 10;
			}

		}
		// System.out.println(firstNumberDigitCount);
		// System.out.println(secondNumberDigitCount);

		if (firstNumberDigitCount == secondNumberDigitCount) {
			byte[] firstNumberArray = new byte[firstNumberDigitCount];
			byte[] secondNumberArray = new byte[secondNumberDigitCount];
			tempFirstNumber = firstNumber;
			tempSecondNumber = secondNumber;
			for (int i = (firstNumberDigitCount - 1); i >= 0; i--) {
				firstNumberArray[i] = (byte) (tempFirstNumber % 10);
				tempFirstNumber /= 10;
				secondNumberArray[i] = (byte) (tempSecondNumber % 10);
				tempSecondNumber /= 10;
			}
			/*
			 * for (byte b : firstNumberArray) { System.out.println(b); } for (byte b :
			 * secondNumberArray) { System.out.println(b); }
			 */
			int numberOfRotation = 0;
			int numberOfEqualDigits = 0;
			boolean numbersAreIdenticals = false;
			boolean stop = false;
			while (stop == false) {
				byte tempDigit = firstNumberArray[firstNumberArray.length - 1];
				for (int j = 0; j < secondNumberArray.length; j++) {
					if (firstNumberArray[j] == secondNumberArray[j]) {
						numberOfEqualDigits++;
					}
				}
				if (numberOfEqualDigits != secondNumberArray.length) {// test if the numbers that the user entered are
																		// not identical
					for (int i = secondNumberArray.length - 1; i > 0; i--) {
						firstNumberArray[i] = firstNumberArray[i - 1];
					}
					firstNumberArray[0] = tempDigit;
					numberOfRotation++;
					tempFirstNumber = 0;
					for (int index = 0; index < secondNumberArray.length; index++) {
						if (firstNumberArray[index] == secondNumberArray[index]) {
							numberOfEqualDigits++;
						}
					}
					if (numberOfEqualDigits == firstNumberArray.length) {
						numbersAreIdenticals = true;
						stop = true;
					}
					if (numberOfRotation == firstNumberArray.length && numbersAreIdenticals == false) {
						stop = true;
					}
				} else {
					System.out.println("the numbers are identical ");
					stop = true;
					numbersAreIdenticals = true;
				}
			}

			if (numbersAreIdenticals) {
				System.out.println("The number " + firstNumber + " can be rotated " + numberOfRotation
						+ " time(s) to get the number " + secondNumber);
			}
			if (numbersAreIdenticals == false) {
				System.out.println("We cannot get from " + firstNumber + " to " + secondNumber
						+ " by performing any number of rotations ");
			}

		} else {
			System.out.println("error the tow numbers that you entered dont have the same number of digits ");
		}
	}
}
