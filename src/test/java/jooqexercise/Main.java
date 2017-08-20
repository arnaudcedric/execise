package jooqexercise;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by acedric on 20/04/2017.
 */
public class Main {

    WebDriver driver ;
    @BeforeClass
    public void setUp(){
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
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        System.out.println((String)jse.executeScript("document.readyState"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("meeting-wrapper")));
        clickMeeting();
        enterPrice("Permian","10/1");


        ////button[@id='save-btn']
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='save-btn']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//div[@class='notification-message']")).getText());
        driver.quit();
    }
    private void clickMeeting(){
        if(!isMeetingsVisible()){
            driver.findElement(By.id("burger-button")).click();
        }
        WebElement meeting = driver.findElement(By.xpath("//a/span[contains(text(),'Bath')]"));
        System.out.println(meeting.getAttribute("aria-expanded"));

        if(!Boolean.parseBoolean(meeting.getAttribute("aria-expanded"))){
            meeting.click();
        }
//        if (!Boolean.parseBoolean(meeting.getAttribute("aria-expanded"))){
//            meeting.click();
//        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div/label[contains(text(),'15:30')]")).click();

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private boolean isMeetingsVisible(){
        WebElement element = driver.findElement(By.id("burger-button"));
        System.out.println(element.getText());
        if(element.getAttribute("class").equalsIgnoreCase("open")){
            return true;
        } else{
            return false;
        }
    }

    public void enterPrice(String runnerName, String price){
        getRunnerRowByTitle(runnerName).findElement(By.cssSelector("td:nth-of-type(3) input")).clear();
        getRunnerRowByTitle(runnerName).findElement(By.cssSelector("td:nth-of-type(3) input")).sendKeys(price);
    }
    public WebElement getRunnerRowByTitle(String runnerName){
        WebElement element = null;
        List<WebElement> rows =  driver.findElements(By.cssSelector("div#race-table table#history-table tbody tr"));
        for(WebElement row : rows){
            String name = row.findElement(By.cssSelector("td:nth-of-type(1)")).getText();
            if (name.contains(runnerName)) {
                element = row;
                break;
            }
        }
        return element;
    }
//    public  ExpectedCondition<Boolean> waitTillMeetingsAreLoaded(){
//        return new ExpectedCondition<Boolean>() {
//
//            @Override
//            public Boolean apply(WebDriver input) {
//                return driver.findElements(By.cssSelector("meeting-wrapper")).size() > 0;
//            }

    @AfterClass
    public void after(){
        driver.quit();
    }
}
