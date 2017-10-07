package studentsGrades;

import java.util.Scanner;

public class Maine {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numOfStudents;
		float studentGrade;
		/*
		 * System.out.print("Enter number of students : "); int numOfStudents =
		 * input.nextInte();
		 */
		do { // input the students number
			System.out.print("Enter number of students : ");
			numOfStudents = input.nextInt();
			if (numOfStudents <= 0) {// if the students numbers is zero or less print error
				System.out.println("Error..... number of students canot be zero or less ");
			}

		} while (numOfStudents <= 0); // while the inputed student number is incorrect ask again

		/*
		 * while(numOfStudents>=0) {
		 * System.out.println("Error..... number of students cannot be zero or less ");
		 * System.out.println("enter number of students : "); int numOfStudents =
		 * input.nextInte(); }
		 */
		float[] students = new float[numOfStudents];// make an array of floats
		for (int index = 0; index < students.length; index++) {// ask for the students grades

			do {

				System.out.println(" enter the grade of student number " + (index + 1)); // ask for the student grade
				studentGrade = input.nextFloat();// input the student grade
				if (studentGrade < 0.0f || studentGrade > 100.0f) {// if the grade is incorrect print
					System.out.println("student grades mast be in rang of 0-100 ");
				}
			} while (studentGrade < 0.0f || studentGrade > 100.0f);// while the inputed grade is incorrect ask again
			students[index] = studentGrade; // put the grade in the array students
		}
		input.close();
		// the mathematical part
		float max;// the highest grade
		float min; // the lowest grade
		float avg = students[0]; // the average
		int studentNumHighGrade = 0; // the number of the student with the highest grade
		int studentNumLowGrade = 0; // the number of the student with the lowest grade

		max = students[0];// assume the first grade is the highest
		min = students[0];// assume the first grade is the lowest
		for (int index = 1; index < students.length; index++) {// start a for loop to find the highest lowest and the average of the grades 
			if (max < students[index]) {// find the highest 
				max = students[index];
				studentNumHighGrade = index + 1;
			}
			if (min > students[index]) {// find the lowest 
				min = students[index];
				studentNumLowGrade = index + 1;

			}
			avg += students[index]; // add the grades together
		}
		System.out.println("student number " + studentNumHighGrade + " have the highest grade whtch is " + max);// print the highest
		System.out.println("student number " + studentNumLowGrade + " have the lowest grade whtch is " + min);// print the lowest
		System.out.println("the average of the grades is " + (avg / numOfStudents));// print the average

	}
}
