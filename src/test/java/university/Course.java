package university;
/**
 * Created by acedric on 10/02/2017.
 */
public class Course {

    private String courseName;
    private int courseGrade;

    Course(String courseName,int courseGrade){
        this.courseName=courseName;
        this.courseGrade=courseGrade;
    }

    public void setCourseName(String course){
        this.courseName=course;
    }
    public String getCourseName(){
        return courseName;
    }
    public void setCourseGrade(int courseGrade){
        this.courseGrade=courseGrade;
    }
    public int getcourseGrade(){
        return courseGrade;
    }
}
