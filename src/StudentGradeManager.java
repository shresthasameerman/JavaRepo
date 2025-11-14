import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StudentGradeManager {

    private Map<Integer, Float> moduleMarks = new HashMap<Integer, Float>();
    private Map<Integer, String> studentEmails = new HashMap<Integer, String>();

    void addGrade(int studentID, float grade) {
        moduleMarks.put(studentID, grade);
    }

    void addStudent(int studentID, float grade, String email) {
        moduleMarks.put(studentID, grade);
        studentEmails.put(studentID, email);
    }

    Float getGrade(int studentID) {
        return moduleMarks.get(studentID);
    }

    String getEmail(int studentID) {
        return studentEmails.get(studentID);
    }

    void printAllGrades() {
        System.out.println("The student grades are as follows - ");
        for (Entry<Integer, Float> entry : moduleMarks.entrySet()) {
            Integer studentID = entry.getKey();
            Float grade = entry.getValue();
            System.out.println(studentID + " : " + grade);
        }
    }

    public static void main(String[] args) {
        StudentGradeManager students = new StudentGradeManager();
        students.addStudent(1, 3.6f, "student1@example.com");
        students.addStudent(2, 3.45f, "student2@example.com");

        students.printAllGrades();

        // show the email of the 2nd student using roll number 2
        System.out.println("Email of 2: " + students.getEmail(2));
    }
}
