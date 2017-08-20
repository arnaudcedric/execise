package university2;

/**
 * Created by acedric on 06/06/2017.
 */
public class Course {

    Score score;

    private String courseName;
    private int courseGrade;

    public Course(Score score, String courseName, int courseGrade) {
        this.score = score;
        this.courseName = courseName;
        this.courseGrade = courseGrade;
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
