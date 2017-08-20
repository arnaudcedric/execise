package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by acedric on 20/04/2017.
 */
public class Sample2 {

    WebDriver driver;

    @DataProvider
    public Object[][] testData(){
        Object[][] data = new Object[2][2];
        data[0][0] = "cedricarno@gmail.com";
        data[0][1] = "Cedric";

        data[0][0] = "cedricarno@gmail.com";
        data[0][1] = "Cedric";

        return data;
    }

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\execise\\src\\test\\java\\jooqexercise\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://gmail.com");
//        PageFactory.initElements(driver, this);
    }

    @Test(dataProvider = "testData")
    public void test(String name, String name2){

        driver.findElement(By.id("identifierId")).sendKeys(name);
    }

}
