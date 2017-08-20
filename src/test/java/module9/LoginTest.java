package module9;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by acedric on 07/04/2017.
 */
public class LoginTest {


    @Test(dataProviderClass = Dataprovider_1.class,dataProvider = "getData")
    public void doLogin1(String username,String password,String password2){
        System.out.println(username+" "+ password+" "+ password2);
    }

    @Test(dataProviderClass = Dataprovider_1.class,dataProvider = "getData")
    public void doSomething1(String username,String password,String password2){
        System.out.println(username+" "+ password+" "+ password2);
    }

//    @DataProvider()
//    public Object[][] data(){
//
//        Object[][] data = new Object[3][3];
//
//        data[0][0]="u1";
//        data[0][1]="p1";
//        data[0][2]="p1";

//        data[1][0]="u2";
//        data[1][1]="p2";
//        data[1][2]="p2";
//
//        data[2][0]="u3";
//        data[2][1]="p3";
//        data[2][2]="p3";

//        return data;
//    }
    
}
