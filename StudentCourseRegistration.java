
import java.util.Scanner;

class Student {
    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

   
    Student(String name, int roll, double score, String course, int credits) {
        studentName = name;
        rollNumber = roll;
        marks = score;
        courseName = course;
        courseCredits = credits;
    }


    double calculateFee() {
        return courseCredits * 1500;
    }

    
    boolean checkEligibility() {
        if (marks >= 50) {
            return true;
        } else {
            return false;
        }
    }

    
    double calculateScholarship() {
        double rate;

        if (marks >= 85) {
            rate = 0.20;
        } else if (marks >= 70) {
            rate = 0.10;
        } else {
            rate = 0;
        }

        return calculateFee() * rate;
    }

    
    double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

   
    void displayDetails() {
        System.out.println("\n========== REGISTRATION DETAILS ==========");
        System.out.println("Student Name   : " + studentName);
        System.out.println("Roll Number    : " + rollNumber);
        System.out.println("Marks          : " + marks);
        System.out.println("Course Name    : " + courseName);
        System.out.println("Course Credits : " + courseCredits);
        System.out.println("Eligibility    : Eligible");
        System.out.println("Course Fee     : Rs. " + calculateFee());
        System.out.println("Scholarship    : Rs. " + calculateScholarship());
        System.out.println("Final Fee      : Rs. " + calculateFinalFee());
        System.out.println("==========================================");
    }
}

public class StudentCourseRegistration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();

        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter course name: ");
        String course = sc.nextLine();

        System.out.print("Enter course credits: ");
        int credits = sc.nextInt();

       
        Student student = new Student(
            name, roll, marks, course, credits
        );

        
        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("\nRegistration Failed!");
            System.out.println("Student is not eligible.");
            System.out.println("Minimum required marks: 50");
        }

        sc.close();
    }
}
