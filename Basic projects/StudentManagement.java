import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    double marks;

    Student(String name, int rollNo, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentManagement {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Delete Student by Roll No");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: deleteStudent(); break;
                case 4: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid Choice!");
            }
        } while (choice != 4);
    }

    static void addStudent() {
        System.out.print("Enter name: ");
        sc.nextLine(); // consume leftover newline
        String name = sc.nextLine();
        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();
        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();
        students.add(new Student(name, rollNo, marks));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    static void deleteStudent() {
        System.out.print("Enter roll number to delete: ");
        int rollNo = sc.nextInt();
        boolean removed = students.removeIf(s -> s.rollNo == rollNo);
        if (removed)
            System.out.println("Student removed successfully.");
        else
            System.out.println("Student not found.");
    }
}
