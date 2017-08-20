#Another note cucumber dependency should be of the same version
#https://stackoverflow.com/questions/33999071/project-doesnt-recognize-cucumber-picocontainer-dependency
#  http://www.javaworld.com/article/2073352/core-java/simply-singleton.html
Feature: login feature
#  Scenario:
#    Given I navigate to login page
#    And I enter the username and password as admin
#    And I click login button
#    Then I should see the SIS logo
#  //    @Given("^I enter the admin and password as admin$")
#  //    public void I_enter_the_username_and_password_as_admin(String admin,String password) {
#  //        System.out.println(admin +" "+ password);
#  //    }

#  ===================================================================================================================
#admin and password are parameter that will be passed in the method implementation as arguments
#must pass arguments in method for the test to work
#  Scenario:
#    Given I navigate to login page
#    And I enter the "admin" and "password" as admin
#    And I click login button
#    Then I should see the SIS logo

#  @And("^I enter the \"([^\"]*)\" and \"([^\"]*)\" as admin$")
#  public void I_enter_the_username_and_password_as_admin(String admin,String password) {
#  System.out.println(admin +" "+ password);
#  }
#    ========================================================================================================

#  here you need to use datatable
  Scenario: login test
    Given I navigate to login page
    And I enter the following credentials
      | username | password |
      | Talla    | pepe0001 |
      | arnaud   | pepe0002 |
      | cedric   | pepe0003 |
      | ivo      | pepe0004 |
    And I click login button
    Then I should see the SIS logo

#  the below code is good but it print all the values at once problem with this is if you want to enter one value at the time you wont be able to
#List<List<String>> data = table.raw();
#  for (List data1: data) {
#  System.out.println(data1);
#  }
#
#  solution to the above issue create a class and loop through the value make sure the first row name are the same as your variable in the class see below
#
#  public class User{
#  private String username;
#  private String password;
#
#  public User(String username, String password) {
#  this.username = username;
#  this.password = password;
#  }
#  }
#
#  @And("^I enter the following credentials$")
#  public void I_enter_the_following_credentials(DataTable table)  {
#  the below code is in the method
#  List<User> users = new ArrayList<User>();
#  users = table.asList(User.class);
#  for (User user:users) {
#  System.out.println(user.username+" "+user.password);
#
#  }
#}

  Scenario Outline: login with correct credentials
    Given I navigate to login page
    And I enter <username> and <password>
    And I click login button
    Then I should see the SIS logo
    Examples:
      | username | password   |
      | Talla    | pepe0001   |
      | arnaud   | password_1 |
      | cedric   | password_2 |
      | ivo      | password_3 |