package cucumberstepdef;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import cucumberBase.BaseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.List;

/**
 * Created by acedric on 31/05/2017.
 */
public class loginStep extends BaseUtil {

    private BaseUtil base;

    public loginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to login page$")
    public void I_navigate_to_login_page()  {
        System.out.println(" I_navigate_to_login_page ");
    }
//
//    @Given("^I enter the admin and password as admin$")
//    public void I_enter_the_username_and_password_as_admin(String admin,String password) {
//        System.out.println(admin +" "+ password);
//    }
//    @Given("^I enter the \"([^\"]*)\" and \"([^\"]*)\" as admin$")
//    public void I_enter_the_username_and_password_as_admin(String admin,String password) {
//        System.out.println(admin +" "+ password);
//    }
@And("^I enter the following credentials$")
public void I_enter_the_following_credentials(List<User> users)  {
    // Express the Regexp above with the code you wish you had
    // For automatic conversion, change DataTable to List<YourType>

//    List<List<String>> data = table.raw();
//    for (List data1: data) {
//        System.out.println(data1.get(1) +" "+ data1.get(1));
//    }
//    Iterator<String> iterator = table.iterator();
//    while (iterator.hasNext()){
//        System.out.println(iterator.next());
//    }


//    users = table.asList(User.class);
    for (User user:users) {
        System.out.println(user.getUsername()+" "+user.getPassword());

    }


    System.out.println("===================================");
}
    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String username, String password)  {

        System.out.println(" username : " + username);
        System.out.println(" password : " + password);
    }

    @And("^I click login button$")
    public void I_click_login_button()  {
        System.out.println(" I_click_login_button ");
    }

    @Then("^I should see the SIS logo$")
    public void I_should_see_the_SIS_logo()  {
        System.out.println( base.stepInfo );
    }



    public class User{


        private String username;
        private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }
}
