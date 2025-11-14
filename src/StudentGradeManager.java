
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
public class StudentGradeManager {

    /**
     * A map which maps from a key (student ID) to a value (module grade)
     */
    private Map<String, Float> moduleMarks = new HashMap<String, Float>();

    /**
     * Adds a student ID and associated grade
     * @param studentID
     * @param grade
     */
    void addGrade(String studentID, float grade) {

        moduleMarks.put(studentID, grade);
    }
    /**
     * Gets the grade associated with the given student
     * @param studentID
     * @return the student's grade
     */
    float getGrade(String studentID) {

        return moduleMarks.get(studentID);
    }

    void printAllGrades() {

        System.out.println("The student grades are as follows - ");

        for(Entry<String, Float> entry : moduleMarks.entrySet()) {

            String studentID = entry.getKey();    // get the key
            float grade = entry.getValue();    // get the associated value

            System.out.println(studentID + " : " + grade);
        }

    }

    public static void main(String[] args){
        StudentGradeManager students=new StudentGradeManager();
        students.addGrade("1A",3.6f);
        students.addGrade("2b",3.45f);



        students.printAllGrades();

        System.out.println(students.getGrade("1A"));

    }
}