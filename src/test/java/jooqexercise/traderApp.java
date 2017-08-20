package jooqexercise;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
/**
 * Created by acedric on 29/04/2017.
 */
public class traderApp {
    WebDriver driver;
    @Test
    public void test()throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\execise\\src\\test\\java\\jooqexercise\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("http://qa.data3.sis.tv:8080/SISTrader/traderUI/index");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("loginButton_submit")).click();
        isMeetingDisplay();
        System.out.println("--------");
        getMeetings("Nottingham","14:10");
        getNumberOfNonrunner("Aquadabra");



    }


    public Boolean isMeetingDisplay(){
        Boolean meetingVisible = false;
        WebElement meetingVisibleButton = driver.findElement(By.id("burger-button"));
        WebDriverWait wait = new WebDriverWait(driver,1);
        wait.until(ExpectedConditions.visibilityOf(meetingVisibleButton));
        if (meetingVisibleButton.getAttribute("class").equalsIgnoreCase("open")){
            meetingVisible = true;
            if (meetingVisible == true){
                meetingVisibleButton.click();
            }
        }
            return meetingVisible;
    }

    public WebElement getAllMeeting(String meeting){

        List<WebElement> sideBarMeeting = driver.findElements(By.id("sidebar-wrapper"));
        WebElement meetingElement = null;
        WebDriverWait wait = new WebDriverWait(driver,1);
        wait.until(ExpectedConditions.visibilityOfAllElements(sideBarMeeting));
        for (WebElement elements : sideBarMeeting) {
            if (driver.findElements(By.xpath("//a/span[contains(text(),'" + meeting +"')]")).size() > 0){
                elements = meetingElement;
            }
        }
            return meetingElement;

    }

    public void getMeetings(String meetingName ,String eventTime) throws InterruptedException {
        if(!isMeetingDisplay()){
//            Thread.sleep(1000);
            driver.findElement(By.id("burger-button")).click();
        }
        WebElement meeting = driver.findElement(By.xpath("//a/span[contains(text(),'"+meetingName+"')]"));
//        Thread.sleep(1000);
//        WebElement meeting1 = driver.findElement(By.xpath("//div/a[@aria-expanded='true']/span[contains(text(),'"+meetingName+"')]"));
        WebDriverWait wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.visibilityOf(meeting));
        if (!meeting.isDisplayed()){
            meeting.click();
        }else {

        }

//        List<WebElement> events = driver.findElements(By.xpath("//div[@class='event-row']"));
//        List<WebElement> events = driver.findElements(By.xpath("//div/label[@class='meeting-index']"));
//        WebElement events1 = driver.findElement(By.xpath("//div/label[@class='meeting-time']"));
        WebElement events = driver.findElement(By.xpath("//label[contains(text(),'"+eventTime+"')]"));

        String text = events.getText();
        if (text.equalsIgnoreCase(eventTime)){
                System.out.println(text);
                events.click();

            }
//        wait.until(ExpectedConditions.visibilityOfAllElements(events));
//        for (WebElement eventElement:events ) {
//            if (eventElement.findElement(By.xpath("//label[@class='meeting-index']")).getText().equalsIgnoreCase(eventNumber)){
//                eventElement.click();
//                break;
//            }
//        }
    }

    public void click(String event){
        List<WebElement> events = driver.findElements(By.xpath("//div[@class='event-row']"));
        WebDriverWait wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.visibilityOfAllElements(events));
    }


    public void getNumberOfNonrunner(String runnerName){


        List<WebElement> runnerNames = driver.findElements(By.xpath("//*[@id='history-table']/tbody/tr/td[1]"));
        List<WebElement> priceInput = driver.findElements(By.xpath("//tbody/tr/td[3]/span/input"));
        List<WebElement> elements = driver.findElements(By.xpath("//tbody/tr/td[1]/span"));

        for (int i = 0; i < runnerNames.size() ; i++) {
            if (runnerNames.get(i).getAttribute("title").equalsIgnoreCase(runnerName)
                    && elements.get(i).getAttribute("class").equalsIgnoreCase("has-error glyphicon glyphicon-exclamation-sign")
                    && priceInput.get(i).getAttribute("value").equalsIgnoreCase("-")){
                System.out.println("non-Runner");
                break;
            }
        }

//        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='history-table']/tbody/tr[5]/td"));
//        for (int i = 0; i <elements.size() ; i++) {
//            System.out.println(elements.get(i).getText());
//        }

    }

//    public void navigatePriceType(String pricetype) throws InterruptedException {
//
//        Actions act = new Actions(driver);
//
//        WebElement moveToButton = driver.findElement(By.id("bg-nested-dropdown"));
//        moveToButton.click();
//
//        Thread.sleep(3000);
//        if (pricetype.equalsIgnoreCase("Early Price")){
//            WebElement earlyPrice = driver.findElement(By.id("early-price"));
//            act.click(earlyPrice).perform();
//
//        }else if (pricetype.equalsIgnoreCase("Board Price")){
//            moveToButton.click();
//            WebElement earlyPrice = driver.findElement(By.id("early-price"));
//            moveToButton.click();
//            act.click(earlyPrice).perform();
//            Thread.sleep(1000);
//            moveToButton.click();
//            WebElement boardPrice = driver.findElement(By.id("board-price"));
//            act.click(boardPrice).perform();
//        }
//    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
