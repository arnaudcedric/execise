package pcworld.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by acedric on 16/05/2017.
 */
public class LaunchPage {
        WebDriver driver;
    public LaunchPage(WebDriver driver) {
        /*System.out.println("HERE");
        driver.get("http://google.com");*/
        this.driver = driver;
    }

    public LoginPage gotoLoginPAge(){
        driver.get("https://www.flipkart.com/");
        return PageFactory.initElements(driver,LoginPage.class);

    }
}
