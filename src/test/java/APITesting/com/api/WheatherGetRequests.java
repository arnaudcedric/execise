package APITesting.com.api;

import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;
/**
 * Created by acedric on 19/04/2017.
 */
public class WheatherGetRequests {

    //    simple get request to get weather by city name
    /*@Test
    public void test_01(){

        Response resp = when().
        get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=673c5650a20311041c26d61291b186a");
        System.out.println(resp.getStatusCode());
        Assert.assertEquals(resp.getStatusCode(),200);

    }*/
    /*@Test
    public void test_01() {

        Response resp =
                given().
                param("q","london").
                param("appid","673c5650a20311041c26d61291b186ae").
                when().
                get("http://api.openweathermap.org/data/2.5/weather");
        System.out.println(resp.getStatusCode());
        Assert.assertEquals(resp.getStatusCode(), 200);
    }*/
//    @Test
//    public void test_01() {
//        int[]  code = {200,201,202,203};
//        code[0] = 200;
//        code[1] = 201;
//
//                given().
//                        param("q","london").
//                        param("appid","673c5650a20311041c26d61291b186ae").
//                        when().
//                        get("http://api.openweathermap.org/data/2.5/weather").
//                        then().
//                        assertThat().statusCode(code[1]);
//
//    }
    @Test
    public void test_01() {
        int[]  code = {200,201,202,203};
        code[0] = 200;
        code[1] = 201;
        Response resp =
        given().
                param("q","london").
                param("appid","673c5650a20311041c26d61291b186ae").
                when().
                get("http://api.openweathermap.org/data/2.5/weather");
        System.out.println(resp.asString());

    }

}