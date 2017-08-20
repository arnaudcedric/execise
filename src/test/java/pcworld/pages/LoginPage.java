package pcworld.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pcworld.pages.session.LandingPage;

/**
 * Created by acedric on 16/05/2017.
 */
public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage doLogin(String uName, String pWord){

        boolean loginsuccess=true;
        return PageFactory.initElements(driver, LandingPage.class);

    }
}
