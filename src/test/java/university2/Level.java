package university2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acedric on 06/06/2017.
 */
public class Level {


    List<Student> students = new ArrayList<Student>();
    public void addStudentToLevel(Student student){
        students.add(student);
    }

    public Student findworseStudent(){

        Student worseStudent=null;
//        for (int i = 0; i <students.length ; i++) {
//            if (students[i] != null) {
//                if (worseStudent == null) {
//                    worseStudent = students[i];
//                } else if (worseStudent.findStudentAverageScore() > students[i].findStudentAverageScore()) {
//                    worseStudent = students[i];
//                }
//            }
//        }



        for(Student student : students){
            if(worseStudent == null){
                worseStudent = student;
            } else if (worseStudent.getStudentGrade() > student.getStudentGrade()){
                worseStudent = student;
            }
        }
        return worseStudent;
    }

}
