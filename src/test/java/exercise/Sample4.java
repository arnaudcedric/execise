package exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by acedric on 12/05/2017.
 */
public class Sample4  {

    private static WebDriver driver = null;
    private Sample4(){

    }


    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\execise\\src\\test\\java\\jooqexercise\\chromedriver.exe");

        if (driver == null){
            driver = new ChromeDriver();
        }
    }
}
