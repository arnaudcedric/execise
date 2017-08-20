package jooqexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by acedric on 26/04/2017.
 */
public class Sample {
    @FindAll({@FindBy(xpath = "//div/div/div/div/a/span")})
    public List<WebElement> meetings;

    @FindBy(id = "burger-button")
    private WebElement hideMeetingsButton;

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\execise\\src\\test\\java\\jooqexercise\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://qa.data3.sis.tv:8080/SISTrader/traderUI/index");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("loginButton_submit")).click();
        navigateToEvent("Bath","1");
    }

//    public void navigateToEvent(String meeting, String event){
//        if(!isMeetingsVisible()){
//            hideMeetingsButton.click();
//        }
//        WebElement element = null;
//
//        for (WebElement meeeting1:meetings){
//            if (meeeting1.findElements(By.xpath(".//a/span[contains(text(),'" + meeting +"')]")).size() > 0);
//            meeeting1.click();
//        }

//div/div[2]/label[contains(text(),'1')]
    //div/div[2]/label[contains(@class,'meeting-index')]


//        WebElement meetingElement = getMeetingWebElement(meeting);
//        if (!Boolean.parseBoolean(meetingElement.getAttribute("aria-expanded"))){
//            meetingElement.click();
//        }
//    }
//    public void navigateToEvent(String meeting, String event){
//        if(!isMeetingsVisible()){
//            hideMeetingsButton.click();
//        }


    public void navigateToEvent(String meeting, String event){
        if(!isMeetingsVisible()){
            hideMeetingsButton.click();
        }

        WebElement meetingElement = getMeetingWebElement(meeting);
        WebElement meetingLink = getMeetingWebElement(meeting).findElement(By.xpath(".//a/span[contains(text(),'" + meeting +"')]"));
        if (!Boolean.parseBoolean(meetingLink.getAttribute("aria-expanded"))){

            meetingLink.click();
        }

        List<WebElement> events = meetingElement.findElements(By.cssSelector(".event-row"));
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfAllElements(events));
        for(WebElement eventElement : events){
            if(eventElement.findElement(By.cssSelector(".meeting-index")).getText().equalsIgnoreCase(event)){
                eventElement.click();
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#history-table tbody tr")));
    }

    private boolean isMeetingsVisible(){
        boolean meetingVisible = false;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(hideMeetingsButton));
        if(hideMeetingsButton.getAttribute("class").equalsIgnoreCase("open")){
            meetingVisible =  true;
        }
        return meetingVisible;
    }

    private WebElement getMeetingWebElement(String meeting){
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElements(meetings));
        for(WebElement meetingElement : meetings){
            if(meetingElement.findElements(By.xpath(".//a/span[contains(text(),'" + meeting +"')]")).size() > 0){
                element = meetingElement;
                break;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        System.out.println("\"\"");
    }
}




