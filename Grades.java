import java.util.Scanner;

/**
 * Write a program that will compute some statistics about students grades.
 * It will ask the user to enter the number of students.
 * Then, the program will ask the user to enter the grades one by one.
 * The range of each grade is an integer between 0 and 100.
 * Make sure to use an array where the type is the closest to this range (hint: don't use an array of "int"'s).
 * If the user enters a number which is not in range, the program will ask him to enter a new grade.
 * Once the user entered all the grades, the program will print:
 * 1. The highest grade and its index (something like: the student #10 got the highest grade and it's 98).
 * 2. The lowest grade and its index (something like: the student #3 got the lowest grade and it's 13).
 * 3. The average of the grades
 */
public class Grades {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfStudents;
        byte studentGrade;
		/*
		 * System.out.print("Enter number of students : "); int numOfStudents =
		 * input.nextInte();
		 */

        do { // input the students number
            // AMEED: Good usage of "do-while" loop although we didn't learn that

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

        byte[] students = new byte[numOfStudents];// make an array of floats
        // AMEED: the grades can only be integers. The best type would be an array of "byte"'s

        for (int index = 0; index < students.length; index++) {// ask for the students grades

            do {

                System.out.println(" enter the grade of student number " + (index + 1)); // ask for the student grade
                studentGrade = input.nextByte();// input the student grade
                if (studentGrade <(byte) 0 || studentGrade >(byte) 100) {// if the grade is incorrect print
                    System.out.println("student grades mast be in rang of 0-100 ");
                }
            } while (studentGrade < (byte)0 || studentGrade >(byte)100);// while the inputed grade is incorrect ask again
            students[index] = studentGrade; // put the grade in the array students
        }
        input.close();
        // AMEED: Great ! closing the input was a good idea :)

        // the mathematical part
        byte max;// the highest grade
        byte min; // the lowest grade
        int sum = students[0]; // the average
        // AMEED: throughout the whole program it's used as the sum and not the average - you should change its name

        int studentNumHighGrade = 0; // the number of the student with the highest grade
        int studentNumLowGrade = 0; // the number of the student with the lowest grade

        max = students[0];// assume the first grade is the highest
        min = students[0];// assume the first grade is the lowest
        for (int index = 1; index < students.length; index++) {// start a for loop to find the highest lowest and the average of the grades
            // AMEED: You started from index 1 -- very good

            if (max < students[index]) {// find the highest
                max = students[index];
                studentNumHighGrade = index + 1;
            }
            if (min > students[index]) {// find the lowest
                min = students[index];
                studentNumLowGrade = index + 1;

            }
            sum += students[index]; // add the grades together
        }
        System.out.println("student number " + studentNumHighGrade + " have the highest grade whtch is " + max);// print the highest
        System.out.println("student number " + studentNumLowGrade + " have the lowest grade whtch is " + min);// print the lowest
        System.out.println("the average of the grades is " + (sum / numOfStudents));// print the average

    }

    /**
     * AMEED:
     * Great job, excellent documentation
     */
}
    