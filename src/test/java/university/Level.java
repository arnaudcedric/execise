package university;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acedric on 10/02/2017.
 */
public class Level {

    //Student[] students = new Student[2];
    List<Student> students = new ArrayList<Student>();
    private int add;

    public void addStudent(Student student){

        students.add(student);
    }

    public Student findworseStudent(){

        Student worseStudent=null;
        for (Student student : students) {
            if (student != null) {
                if (worseStudent == null) {
                    worseStudent = student;
                } else if (worseStudent.findStudentAverageScore() > student.findStudentAverageScore()) {
                    worseStudent = student;
                }
            }
        }



//        for(Student student : students){
//            if(worseStudent == null){
//                worseStudent = student;
//            } else if (worseStudent.getstudentGrade() > student.getstudentGrade()){
//                worseStudent = student;
//            }
//        }
        return worseStudent;
    }
//    public Student findBestStudent(){
//        Student bestStudent = null;
//        for (int i=0;i <students.length; i++) {
//            if (students[i] != null) {
//                if (bestStudent == null) {
//                    bestStudent = students[i];
//                } else if (bestStudent.findStudentAverageScore() < students[i].findStudentAverageScore()) {
//                    bestStudent = students[i];
//                }
//            }
//        }
//        return bestStudent;
//    }

}
