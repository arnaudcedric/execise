package javatpoint;


import org.joda.time.LocalDate;
import org.testng.annotations.Test;

/**
 * Created by acedric on 03/05/2017.
 */
public class Student {

    @Test
    public void test(){
        LocalDate date = new LocalDate();
        System.out.println(date.toDate());
    }
}