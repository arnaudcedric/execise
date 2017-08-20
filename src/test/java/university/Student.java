package university;

/**
 * Created by acedric on 10/02/2017.
 */
public class Student {

    private String studentName;
    public int studentGrade;
    private int add;
    Course[] courses = new Course[2];

    public Student(String studentName,int studentGrade){
        this.studentName=studentName;
        this.studentGrade=studentGrade;

    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }
    public int getstudentGrade() {
        return studentGrade;
    }
    public void takeCourse(Course course) {

        courses[add] = course;
        add++;
    }
    public int findStudentAverageScore(){
        int total=0;
        for (int i=0; i<courses.length;i++){
            total=total+courses[i].getcourseGrade();
        }
        return total/courses.length;
    }
    public void setStudentGrade(Course course,int grade){
        for (int i = 0; i <courses.length ; i++) {

            if (course.getCourseName() == courses[i].getCourseName()){
                courses[i].setCourseGrade(grade);
            }
        }
    }
}
