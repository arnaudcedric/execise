package module9;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by acedric on 07/04/2017.
 */
public class RegTest {

    SoftAssert sa = new SoftAssert();

    @Test
    public void doRegistrationTest(){
        String x = "yyyy";
        String a = "yyyy";
//        Assert.assertEquals(x,a);

//        Assert.assertTrue(x==a,"This will not work");
        sa.assertEquals(x,a);
        sa.assertEquals("a","a");


        sa.assertAll();
    }
    // critical functions error stop/failure use Assert class in TestNg
    // non critical - failure - continue - softAssert
}
