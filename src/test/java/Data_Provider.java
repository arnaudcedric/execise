import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by acedric on 06/06/2017.
 */
public class Data_Provider {

    private static WebDriver driver = null;
    private Data_Provider(){

    }

    @DataProvider(name = "getData")
    public Object[][] data(String driverName){
        if (driverName == "chrome") {
            driver = new ChromeDriver();
        }
        if (driver == null){
            driver = new ChromeDriver();
        }
        Object[][] data = new Object[2][3];
        data[0][0] = "1";
        data[0][1] = "2";
        data[0][2] = "chrome";

        data[1][0] = "3";
        data[1][1] = "4";
        data[1][2] = "chrome";

        return data;
    }



    @Test(dataProvider = "getData")
    public void sampleTest(String name1,String name2){

        System.out.println(name1 +" "+name2);

    }

}
