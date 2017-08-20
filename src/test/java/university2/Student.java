package university2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acedric on 10/02/2017.
 */
public class Student {

    String studentName;
    int studentGrade;
    Score score;

    public Student(String studentName, int studentGrade, Score score) {
        this.studentName = studentName;
        this.studentGrade = studentGrade;
        this.score = score;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }

    List<Course> courses = new ArrayList<Course>();
    public void takeCourse(Course course){
        courses.add(course);
    }


}
