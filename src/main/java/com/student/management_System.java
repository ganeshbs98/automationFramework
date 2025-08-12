package com.student;

import java.util.Scanner;


public class management_System {
    public static String studentName[] = new String[100];
    public static int stduentAge[] = new int[100];
    public static double marksObatinedInEnglish[] = new double[100];
    public static double marksObatinedInScience[] = new double[100];
    public static double marksObatinedInMaths[] = new double[100];
    public static String Grade[] = new String[100];
    public static int RollNumberOfStudent[] = new int[100];
    public static Scanner scanner = new Scanner(System.in);
    public static int index = 0;

    public static void main(String[] args) {
        int option = 0;

        while (true) {
            System.out.println("1. add student details");
            System.out.println("2. Print student details");
            System.out.println("3. Print all student details");
            System.out.println("4. exit");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    printStudentDetails();
                    break;
                case 3:
                    printAllStudentDetails();
                    break;
                case 4:
                    exit();
                    break;
            }
        }

    }

    private static void exit() {
        System.out.println("exiting the application");
        System.exit(0);
    }

    private static void printAllStudentDetails() {
        for (int i = 0; i <=index; i++) {
            System.out.println("====================================");
            System.out.println("Name  " + studentName[i]);
            System.out.println("age - " + stduentAge[i]);
            System.out.println("Roll No - " + RollNumberOfStudent[i]);
            System.out.println("mark in englisg - " + marksObatinedInEnglish[i]);
            System.out.println("mark in science - " + marksObatinedInScience[i]);
            System.out.println("mark in maths - " + marksObatinedInMaths[i]);
            System.out.println("Grade - " + Grade[i]);
            System.out.println("====================================");
        }
    }

    private static void printStudentDetails() {
        System.out.println("enter the Student index ");
        int userindex = scanner.nextInt();
        System.out.println("Name  " + studentName[userindex]);
        System.out.println("age - " + stduentAge[userindex]);
        System.out.println("Roll No - " + RollNumberOfStudent[userindex]);
        System.out.println("mark in englisg - " + marksObatinedInEnglish[userindex]);
        System.out.println("mark in science - " + marksObatinedInScience[userindex]);
        System.out.println("mark in maths - " + marksObatinedInMaths[userindex]);
        System.out.println("Grade - " + Grade[userindex]);

    }


    public static void addStudent() {
        System.out.println("Enter the student name");
        studentName[index] = scanner.next();
        System.out.println("Enter the age");
        stduentAge[index] = scanner.nextInt();
        System.out.println("Enter Roll no");
        RollNumberOfStudent[index] = scanner.nextInt();
        System.out.println("Enter the English marks");
        marksObatinedInEnglish[index] = scanner.nextDouble();
        System.out.println("Enter the Science marks");
        marksObatinedInScience[index] = scanner.nextDouble();
        System.out.println("Enter the maths marks");
        marksObatinedInMaths[index] = scanner.nextDouble();
        double totalmarksObatined = marksObatinedInEnglish[index] + marksObatinedInScience[index] + marksObatinedInScience[index];
        double percentage = totalmarksObatined / 3.0;

        if (percentage >= 95) {
            Grade[index] = "A+";
        } else if (percentage >= 90) {
            Grade[index] = "A";

        } else if (percentage >= 85) {
            Grade[index] = "B+";

        } else if (percentage >= 80) {
            Grade[index] = "B";

        } else if (percentage >= 75) {
            Grade[index] = "C+";

        } else if (percentage >= 70) {
            Grade[index] = "C";

        } else if (percentage >= 65) {
            Grade[index] = "D";

        } else {
            Grade[index] = "F";
        }
        index++;
    }
}
