import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Add Grade to Student");
            System.out.println("5. Generate Class Report");
            System.out.println("6. Generate Student Report");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    manager.addStudent();
                    break;
                case 2:
                    manager.viewStudents();
                    break;
                case 3:
                    manager.updateStudent();
                    break;
                case 4:
                    manager.addGradeToStudent();
                    break;
                case 5:
                    manager.generateClassReport();
                    break;
                case 6:
                    manager.generateStudentReport();
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}