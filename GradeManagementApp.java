import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GradeManagementApp {
    public static void main(String[] args) { // Fixed: Added missing opening brace
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. View Student Report"); // Fixed: outprintln -> out.println
            System.out.println("4. View Class Statistics");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = safeInputInt(scanner);

            switch (choice) { // Fixed: Added missing opening brace
                case 1:
                    System.out.print("Enter student ID: ");
                    String id = scanner.next();
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    Student student = new Student(id, name);
                    students.add(student);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.next();
                    Student foundStudent = findStudentById(students, studentId);
                    if (foundStudent != null) {
                        System.out.print("Enter grade: ");
                        int grade = safeInputInt(scanner);
                        foundStudent.addGrade(grade);
                        System.out.println("Grade added successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    String reportId = scanner.next();
                    Student reportStudent = findStudentById(students, reportId);
                    if (reportStudent != null) {
                        reportStudent.displayReport();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    printStatistics(students);
                    break;

                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again."); // Fixed: Invaild -> Invalid
                    break;
            } // Fixed: Proper closing of switch statement
        }

        scanner.close();
    }

    // Fixed: Moved methods inside class and fixed logic
    public static Student findStudentById(ArrayList<Student> students, String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null; // Fixed: moved return statement outside loop
    }

    public static int safeInputInt(Scanner scanner) { // Fixed: method name and structure
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer:"); // Fixed: Invaild -> Invalid
                scanner.next(); // consume invalid input
            }
        }
    }

    public static void printStatistics(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        int total = 0; // Fixed: declared variables
        int count = 0;
        int highest = Integer.MIN_VALUE; // Fixed: Interger -> Integer
        int lowest = Integer.MAX_VALUE;
        int[] distribution = new int[5]; // for A,B,C,D,F

        for (Student s : students) { // Fixed: Students -> Student
            for (int g : s.getGrades()) {
                total += g;
                count++;
                if (g > highest) highest = g;
                if (g < lowest) lowest = g;

                if (g >= 90) distribution[0]++;
                else if (g >= 80) distribution[1]++;
                else if (g >= 70) distribution[2]++;
                else if (g >= 60) distribution[3]++;
                else distribution[4]++;
            }
        }

        if (count == 0) {
            System.out.println("No grades found.");
            return;
        }

        System.out.println("\n--- Class Statistics ---");
        System.out.println("Average Grade: " + String.format("%.2f", (double) total / count));
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.println("Grade Distribution:");
        System.out.println("A: " + distribution[0]);
        System.out.println("B: " + distribution[1]);
        System.out.println("C: " + distribution[2]);
        System.out.println("D: " + distribution[3]);
        System.out.println("F: " + distribution[4]);
    }
}