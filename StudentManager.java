import java.util.ArrayList;
import java.util.Scanner;

class StudentManager {
    private ArrayList<Student> students;
    private Scanner scanner = new Scanner(System.in);
    
    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent() {
        System.out.println("Enter student ID: ");
        String id = scanner.next();
        System.out.println("Enter student name: ");
        String name = scanner.next();
        Student student = new Student(id, name);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n=== All Students ===");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void updateStudent() {
        System.out.println("Enter student ID: ");
        String id = scanner.next();
        scanner.nextLine();
        
        for (Student s : students) {
            if (s.getId().equals(id)) {
                System.out.println("Enter new name: ");
                String name = scanner.nextLine();
                Student updated = new Student(id, name);
                
                for (int g : s.getGrades()) {
                    updated.addGrade(g);
                }
                
                students.set(students.indexOf(s), updated);
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void addGradeToStudent() {
        System.out.println("Enter student ID: ");
        String id = scanner.next();
        
        for (Student s : students) {
            if (s.getId().equals(id)) {
                System.out.println("Enter grade: ");
                int grade = scanner.nextInt();
                s.addGrade(grade);
                System.out.println("Grade added successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void generateClassReport() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        double total = 0;
        int count = 0;
        int[] distribution = new int[5]; // A, B, C, D, F

        for (Student s : students) {
            double avg = s.getAverage();
            total += avg;
            count++;

            char grade = s.getLetterGrade();
            switch (grade) {
                case 'A': distribution[0]++; break;
                case 'B': distribution[1]++; break;
                case 'C': distribution[2]++; break;
                case 'D': distribution[3]++; break;
                case 'F': distribution[4]++; break;
            }
        }

        double classAverage = total / count;
        
        System.out.println("\n=== Class Report ===");
        System.out.println("Total Students: " + count);
        System.out.println("Class Average: " + String.format("%.2f", classAverage));
        System.out.println("Grade Distribution:");
        System.out.println("A: " + distribution[0] + " students");
        System.out.println("B: " + distribution[1] + " students");
        System.out.println("C: " + distribution[2] + " students");
        System.out.println("D: " + distribution[3] + " students");
        System.out.println("F: " + distribution[4] + " students");
    }

    public void generateStudentReport() {
        System.out.println("Enter student ID: ");
        String id = scanner.next();
        
        for (Student s : students) {
            if (s.getId().equals(id)) {
                System.out.println("\n=== Student Report ===");
                System.out.println("ID: " + s.getId());
                System.out.println("Name: " + s.getName());
                System.out.println("Grades: " + s.getGrades());
                System.out.println("Average: " + String.format("%.2f", s.getAverage()));
                System.out.println("Letter Grade: " + s.getLetterGrade());
                return;
            }
        }
        System.out.println("Student not found.");
    }
}