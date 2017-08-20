package jooqexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by acedric on 27/04/2017.
 */
public class SampleTest {
    @FindAll({@FindBy(xpath = "//div/div/div/div/a/span")})
    public List<WebElement> meetings;

    @FindBy(id = "burger-button")
    WebElement meetingDisplayButton;

    WebDriver driver ;

    public SampleTest(WebDriver driver){
        this.driver = driver;
    }

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\execise\\src\\test\\java\\jooqexercise\\chromedriver.exe");
        driver = new ChromeDriver();
//        PageFactory.initElements(driver, this);
    }
//    @Test
//    public void test() throws InterruptedException {
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.get("http://qa.data3.sis.tv:8080/SISTrader/traderUI/index");
//        driver.findElement(By.id("username")).sendKeys("admin");
//        driver.findElement(By.id("password")).sendKeys("password");
//        driver.findElement(By.id("loginButton_submit")).click();
//        navigateToMeeting("Bath","1");
//    }
    public Boolean isMeetingsDisplayed(){

        WebElement element = driver.findElement(By.id("burger-button"));
        System.out.println(element.getText());
        if(element.getAttribute("class").equalsIgnoreCase("open")){
            return true;
        } else{
            return false;
        }

    }
    public WebElement getMeetings(String meetingsName){
        WebElement meetingElement = null;
        WebDriverWait webdriverwait = new WebDriverWait(driver, 4000);
        webdriverwait.until(ExpectedConditions.visibilityOfAllElements(this.meetings));
        for (WebElement webelement: this.meetings ) {
            if(webelement.findElements(By.xpath(".//a/span[contains(text(),'" + meetingsName +"')]")).size() > 0){
                meetingElement = webelement;
            }
        }
        return meetingElement;
    }

    public void navigateToMeeting(String meetingName,String eventName){
        if (!isMeetingsDisplayed()){
            meetingDisplayButton.click();
        }
        WebElement meetingElement = getMeetings(meetingName);
        WebElement meetingLink = getMeetings(meetingName).findElement(By.xpath(".//a/span[contains(text(),'" + meetingName +"')]"));
        if (!Boolean.parseBoolean(meetingLink.getAttribute("aria-expanded"))){
            meetingLink.click();
        }
        List<WebElement> events = meetingElement.findElements(By.cssSelector(".event-row"));
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfAllElements(events));
        for(WebElement eventElement : events){
            if(eventElement.findElement(By.cssSelector(".meeting-index")).getText().equalsIgnoreCase(eventName)){
                eventElement.click();
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#history-table tbody tr")));
    }
}

