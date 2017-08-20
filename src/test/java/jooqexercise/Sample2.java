package jooqexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by acedric on 27/04/2017.
 */
public class Sample2 {

    WebDriver driver;

    @Test
    public void test()throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\execise\\src\\test\\java\\jooqexercise\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://qa.data3.sis.tv:8080/SISTrader/traderUI/index");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("loginButton_submit")).click();
        clickevent("Huntingdon", "17:15");
        getRunnerNameStatus("La Bague Au Roi");
//        Thread.sleep(3000);
//        enterPrice("Azari","1/100");
//        Thread.sleep(3000);
//        navigatePriceType("Board Price");


    }
    public boolean displayMeeting(){
        WebElement meetingDisplayButton = driver.findElement(By.id("burger-button"));
        meetingDisplayButton.click();
        if (meetingDisplayButton.getAttribute("class").equalsIgnoreCase("open")){
            return true;
        }else {
            return false;
        }
    }

    public void clickevent(String meetingName , String eventTime) throws InterruptedException {
        if(!displayMeeting()){
            Thread.sleep(2000);
            driver.findElement(By.id("burger-button")).click();
        }
        WebElement meeting = driver.findElement(By.xpath("//a/span[contains(text(),'"+meetingName+"')]"));
        Thread.sleep(2000);
        if (!meeting.isDisplayed()){
            meeting.click();
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div/label[contains(text(),'"+eventTime+"')]")).click();
    }
    public void enterPrice(String runnerName,String runnerPrice){

        WebElement elements = driver.findElement(By.xpath("//td[contains(text(),'"+ runnerName+"')]"));
        System.out.println(elements.getText());
        WebElement element = driver.findElement(By.xpath("//tr/td[3]/span/input"));
        element.clear();
        element.sendKeys(runnerPrice);
    }

    public void navigatePriceType(String pricetype) throws InterruptedException {

        Actions act = new Actions(driver);

        WebElement moveToButton = driver.findElement(By.id("bg-nested-dropdown"));
        moveToButton.click();

        Thread.sleep(3000);
        if (pricetype.equalsIgnoreCase("Early Price")){
            WebElement earlyPrice = driver.findElement(By.id("early-price"));
            act.click(earlyPrice).perform();

        }else if (pricetype.equalsIgnoreCase("Board Price")){
            moveToButton.click();
            WebElement earlyPrice = driver.findElement(By.id("early-price"));
            moveToButton.click();
            act.click(earlyPrice).perform();
            Thread.sleep(1000);
            moveToButton.click();
            WebElement boardPrice = driver.findElement(By.id("board-price"));
            act.click(boardPrice).perform();
        }
    }
    public void clickSaveButton(){
        driver.findElement(By.id("save-btn")).click();
    }

    public void getRunnerNameStatus(String runnerName) {

        List<WebElement> runnerNameElement = driver.findElements(By.xpath(".//*[@id='history-table']/tbody/tr/td[1]"));

        WebElement priceInputField = driver.findElement(By.xpath("//tbody/tr/td[3]/span/input"));

        if (priceInputField.getAttribute("value").equalsIgnoreCase("-")) {
                    System.out.println(runnerName + " : is a nonRunner");
        }else {
            System.out.println(runnerName + " : is a runner");
        }
    }
}
