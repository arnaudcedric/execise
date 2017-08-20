package module9;
import org.testng.annotations.Test;

/**
 * Created by acedric on 07/04/2017.
 */
public class SampleTest {
    @Test(priority = 1)
    public void login(){
        System.out.println("@Test login");
    }

    @Test(priority = 2, dependsOnMethods = "login")
    public void changeUsername(){
        System.out.println("@Test changeUsername");
    }

    @Test(priority = 3, dependsOnMethods = "changeUsername")
    public void changePassword(){
        System.out.println("@Test changePassword");
    }
}
