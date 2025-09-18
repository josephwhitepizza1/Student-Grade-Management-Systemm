import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Class to represent a student
class Student {
    private String id;
    private String name;
    private ArrayList<Integer> grades;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverage() {
        if (grades.size() == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public char getLetterGrade() {
        double avg = getAverage();
        if (avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 60) return 'D';
        else return 'F';
    }

    public void displayReport() {
        System.out.println("ID: " + id + " | Name: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + getAverage());
        System.out.println("Letter Grade: " + getLetterGrade());
    }

    @Override
    public String toString() {
        return "Student{ID='" + id + "', Name='" + name + "', Average=" + String.format("%.2f", getAverage()) + ", Grade=" + getLetterGrade() + "}";
    }
}