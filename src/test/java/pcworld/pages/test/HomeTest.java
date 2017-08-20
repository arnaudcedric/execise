package pcworld.pages.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pcworld.pages.LaunchPage;
import pcworld.pages.LoginPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by acedric on 16/05/2017.
 */
public class HomeTest {
//    @Test
//    public void testHome(){
//        System.setProperty("webdriver.gecko.driver","C:\\Workspace\\execise\\src\\test\\java\\pcworld\\pages\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//        LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);
//        LoginPage loginPage = launchPage.gotoLoginPAge();
//        loginPage.doLogin("admin","password");
//    }

    @FindBy(id = "save-btn")
    private WebElement savePricesButton;
    WebDriver driver;

@Test
public void test(){
    System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\execise\\src\\test\\java\\jooqexercise\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    driver.get("http://localhost:8090/SISTrader/traderUI/index");
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.id("loginButton_submit")).click();
    waitTillMeetingsAreLoaded(2);
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    getMeeting("Meeting 1");
    isMeetingsVisible();
    clickEvent("Meeting 1","15:04");
    enterPrices();
    isDerivativechecked("Betting Without Favourite");


}
    @AfterTest
    public void tearDown(){
    driver.quit();
}

        public Boolean isDerivativechecked(String derivativeName){
            Boolean isDerivativechecked = false;
            List<WebElement> elements = driver.findElements(By.xpath("//div[@class='markets-hdr panel-title']"));
            for (WebElement dm: elements){
                WebElement element = dm.findElement(By.xpath("//span[@class='market-title']"));
                String value = dm.findElement(By.tagName("input")).getCssValue("value");
                String dMName = element.getText();
                if (dMName.contains(derivativeName) && !element.isSelected()){
                    element.click();
                }else if (dMName.contains(derivativeName) && element.isSelected()){
                    isDerivativechecked = true;
                }
            }
                    return isDerivativechecked;
        }

        public WebElement getAllDerivativesMarket(String derivativeName){

            WebElement element = null;
            List<WebElement> Derivative_Market_row = driver.findElements(By.cssSelector("//div[@class='markets-hdr panel-title']"));
            for (WebElement dm: Derivative_Market_row){
                String dMName = dm.findElement(By.cssSelector(".market-title")).getText();
                if (dMName.contains(derivativeName)){
                    element = dm;
                    break;
                }
            }
                return element;
        }


//    public Boolean isDerivativeMarketChecked(String DerivativeMarketName){
//
//        Boolean isDerivativeMarketticked = null;
//        List<WebElement> checkedBoxs = driver.findElements(By.xpath("//div/div/div/label/input"));
//        List<WebElement> dMName = driver.findElements(By.xpath("//span[contains(text(),'"+DerivativeMarketName+"')]"));
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOfAllElements(checkedBoxs));
//        wait.until(ExpectedConditions.visibilityOfAllElements(dMName));
//
//        for (int i=0;i<checkedBoxs.size();i++) {
//            if (dMName.get(i).isSelected()) {
//                isDerivativeMarketticked = true;
//
//            }else {
//                isDerivativeMarketticked=false;
//            }
//            break;
//        }
//        return isDerivativeMarketticked;
//    }

    public void enterPrices(){
        List<WebElement> elements = driver.findElements(By.xpath("//table/tbody/tr/td[3]/span[@id]/input"));
//        for (int i=0;i<elements.size();i++){
//            elements.get(0).sendKeys("EVS");
//            driver.findElement(By.id("save-btn")).click();
//        }
        elements.get(0).clear();
        elements.get(0).sendKeys("7/1");
        elements.get(1).clear();
        elements.get(1).sendKeys("6/1");
        elements.get(2).clear();
        elements.get(2).sendKeys("5/1");
        elements.get(3).clear();
        elements.get(3).sendKeys("4/1");
        elements.get(4).clear();
        elements.get(4).sendKeys("3/1");
        elements.get(5).clear();
        elements.get(5).sendKeys("2/1");


        driver.findElement(By.id("save-btn")).click();

        List<WebElement> elements1 = driver.findElements(By.xpath("//div[@class='notification-message']"));
        if (elements1.size()>0) {
            WebElement element = elements1.get(elements1.size() - 1);
            System.out.println(element.getText());
        }else{
            System.out.println(elements1.get(0).getText());
        }


//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
/*elements.get(0).sendKeys("EVS");
        elements.get(1).sendKeys("2/1");
        elements.get(2).sendKeys("3/1");
        elements.get(3).sendKeys("4/1");
        elements.get(4).sendKeys("9");*/
    }



    public WebElement getMeeting(String meeting){

        List<WebElement> allMeetings = driver.findElements(By.xpath("//div[@class='meeting-wrapper']"));

        WebElement meetingsElements = null;
        WebDriverWait wait = new WebDriverWait(driver,25);

        wait.until(ExpectedConditions.visibilityOfAllElements(allMeetings));
        for (WebElement element : allMeetings){
            if (element.findElements(By.xpath("//a/span[contains(text(),'" + meeting +"')]")).size() > 0){
                meetingsElements = element;
                break;
            }
        }
        return meetingsElements;
    }

    public boolean isMeetingsVisible(){
        boolean meetingVisible = false;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement hideMeetingsButton = driver.findElement(By.id("burger-button"));
        wait.until(ExpectedConditions.visibilityOf(hideMeetingsButton));
        if(hideMeetingsButton.getAttribute("class").equalsIgnoreCase("open")){
            meetingVisible =  true;
        }
        return meetingVisible;
    }

    public WebElement getMeetingWebElement(String meeting){
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, 15);
        List<WebElement> allMeetings = driver.findElements(By.xpath("//div[@class='meeting-wrapper']"));
        wait.until(ExpectedConditions.visibilityOfAllElements(allMeetings));
        for(WebElement meetingElement : allMeetings){
            if(meetingElement.findElements(By.xpath(".//a/span[contains(text(),'" + meeting +"')]")).size() > 0){
                element = meetingElement;
                break;
            }
        }
        return element;
    }

//    public void navigateToEvent(String meeting, String event){
//        waitTillMeetingsAreLoaded(10);
//        WebElement hideMeetingsButton = driver.findElement(By.id("burger-button"));
//        if(!isMeetingsVisible()){
//            hideMeetingsButton.click();
//        }
//        WebElement meetingElement = getMeetingWebElement(meeting);
//        //WebElement meetingLink = getMeetingWebElement(meeting).findElement(By.xpath(".//a/span[contains(text(),'" + meeting +"')]"));
//        WebElement meetingLink = getMeetingWebElement(meeting).findElement(By.tagName("a"));
//        if (!Boolean.parseBoolean(meetingLink.getAttribute("aria-expanded"))){
//            meetingLink.click();
//        }
//
//        List<WebElement> events = meetingElement.findElements(By.cssSelector(".event-row"));
//        WebDriverWait wait = new WebDriverWait(driver,15);
//        wait.until(ExpectedConditions.visibilityOfAllElements(events));
//        for(WebElement eventElement : events){
//            if(eventElement.findElement(By.cssSelector(".meeting-index")).getText().equalsIgnoreCase(event)){
//                eventElement.click();
//                break;
//            }
//        }
//        wait.until(ExpectedConditions.visibilityOf(savePricesButton));
//    }

public void clickEvent(String meetingName , String eventTime)  {
    if(!isMeetingsVisible()){

        driver.findElement(By.id("burger-button")).click();
    }
    WebElement meeting = driver.findElement(By.xpath("//a/span[contains(text(),'" + meetingName + "')]"));
    if (!meeting.isSelected()){
        meeting.click();
    }

    driver.findElement(By.xpath("//div/label[contains(text(),'"+eventTime+"')]")).click();
}
    public void waitTillMeetingsAreLoaded(int seconds){
        //temporary hack, at times meeting are loaded after refresh
        List<WebElement> allMeetings = driver.findElements(By.xpath("//div[@class='meeting-wrapper']"));
        try {
            WebDriverWait wait = new WebDriverWait(driver,seconds);
            wait.until(ExpectedConditions.visibilityOfAllElements(allMeetings));
        } catch (Exception e){
            driver.navigate().refresh();
            waitTime(5);
        }

    }
    public void waitTime(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
