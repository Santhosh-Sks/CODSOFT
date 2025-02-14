package Task002;

import java.util.Scanner;

public class gradecalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid number of subjects: ");
            scanner.next();
        }
        int numSubjects = scanner.nextInt();

        int totalMarks = 0;
        int highestMarks = Integer.MIN_VALUE;
        int lowestMarks = Integer.MAX_VALUE;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a valid mark: ");
                scanner.next();
            }
            int marks = scanner.nextInt();
            while (marks < 0 || marks > 100) {
                System.out.print("Marks should be between 0 and 100. Enter again: ");
                marks = scanner.nextInt();
            }
            totalMarks += marks;
            if (marks > highestMarks) highestMarks = marks;
            if (marks < lowestMarks) lowestMarks = marks;
        }

        double averagePercentage = (double) totalMarks / numSubjects;
        char grade = calculateGrade(averagePercentage);

        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Highest Marks: " + highestMarks);
        System.out.println("Lowest Marks: " + lowestMarks);

        scanner.close();
    }

    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
