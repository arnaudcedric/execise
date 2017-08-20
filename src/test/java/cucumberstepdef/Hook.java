package cucumberstepdef;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumberBase.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hook extends BaseUtil{
    //dependency injection create a private variable
    private BaseUtil base;
    WebDriver driver;
//    use below code if you only want one instance of chrome
//    private static WebDriver driver = null;
//    private Hook(){
//
//    }
//            if (driver == null){
//            driver = new ChromeDriver();
//        }

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initialiseTest(){
        System.out.println("Open browse");
        base.stepInfo= "frefox";
        System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\execise\\src\\test\\java\\jooqexercise\\chromedriver.exe");
        driver = new ChromeDriver();
//        if (driver == null){
//            driver = new ChromeDriver();
//        }

        driver.manage().window().maximize();
        driver.navigate().to("https://google.com");

    }

    // scenario from cucumberAPI
    @After
    public void closeBrose(Scenario scenario){

        System.out.println("close browse");
        driver.quit();

    }
}
