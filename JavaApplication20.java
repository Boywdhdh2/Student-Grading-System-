/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication20;

/**
 *
 * @author Administrator
 */
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    String id;
    double[] grades;
    double average;
    String remark;

    public Student(String name, String id, double[] grades) {
        this.name = name;
        this.id = id;
        this.grades = grades;
        computeAverage();
        computeRemark();
    }

    private void computeAverage() {
        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        average = sum / grades.length;
    }

    private void computeRemark() {
        if (average >= 90)
            remark = "Excellent";
        else if (average >= 80)
            remark = "Very Good";
        else if (average >= 70)
            remark = "Good";
        else if (average >= 60)
            remark = "Needs Improvement";
        else
            remark = "Fail";
    }
}

public class JavaApplication20 {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = getIntInput("Enter choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);
    }

    static void displayMenu() {
        System.out.println("\nGRADING SYSTEM SMCBI");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Exit");
    }

    static void addStudent() {
        scanner.nextLine(); // clear buffer

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        double[] grades = new double[3];
        for (int i = 0; i < 3; i++) {
            grades[i] = getGradeInput("Enter grade for subject " + (i + 1) + ": ");
        }

        students.add(new Student(name, id, grades));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n-----------------------------------------------------");
        System.out.printf("%-10s %-18s %-10s %-15s%n",
                "ID", "Name", "Average", "Remark");
        System.out.println("-----------------------------------------------------");

        for (Student s : students) {
            System.out.printf("%-10s %-18s %-10.2f %-15s%n",
                    s.id, s.name, s.average, s.remark);
        }

        System.out.println("-----------------------------------------------------");
    }

    static double getGradeInput(String message) {
        double grade;
        do {
            System.out.print(message);
            grade = scanner.nextDouble();
            if (grade < 0 || grade > 100) {
                System.out.println("Invalid grade! Must be between 0 and 100.");
            }
        } while (grade < 0 || grade > 100);
        return grade;
    }

    static int getIntInput(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}


