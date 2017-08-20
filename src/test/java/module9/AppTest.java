package module9;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

/**
 * Created by acedric on 07/04/2017.
 */
public class AppTest {

    SoftAssert sa;
    @BeforeClass
    public void beforeclass(){
        System.out.println("BeforeClass");
    }
    @Test
    public void doLogin(){
        System.out.println("doLogin");

    }
    @Test
    public void enterusername(){
        System.out.println("enterusername");
    }
    @BeforeMethod
    public void beforemethod(){
        System.out.println("BeforeMethod");
    }
    @AfterMethod
    public void Aftermethod(){
        System.out.println("BeforeMethod");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest");
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite");
    }
    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("BeforeSuite");
    }


}
