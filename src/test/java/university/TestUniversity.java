package university;

/**
 * Created by acedric on 10/02/2017.
 */
public class TestUniversity {
    public static void main(String[] args) {

        Course math = new Course("math",90);
        Course math1 = new Course("math1",1);
        Student cedric = new Student("cedric",90);
        Student cedric1 = new Student("cedric1",1);
        Level l1 = new Level();

        l1.addStudent(cedric);
        l1.addStudent(cedric1);

        cedric.takeCourse(math);
        cedric1.takeCourse(math);


//        cedric.setStudentGrade(math,90);
//        cedric1.setStudentGrade(math,1);

        System.out.println(l1.findworseStudent().getStudentName());
//        System.out.println(l1.findBestStudent().getStudentName());

     //   function in student class that will take object of course




    }
}
