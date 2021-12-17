package steps;

import base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class LoginStep extends BaseUtil {

    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() {
        System.out.println("Navigate to the login page");
        base.Driver.navigate().to("https://demosite.executeautomation.com");
    }

    @And("^I click on login button$")
    public void iClickOnLoginButton() {
        LoginPage page = new LoginPage(base.Driver);
        page.clickLogin();
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() {
        Assert.assertTrue("Initial is not displayed", base.Driver.findElement(By.id("Initial")).isDisplayed());
    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String userName, String password) {
        System.out.println("Username is: " + userName);
        System.out.println("Password is: " + password);
    }

    @And("^I enter the users email address as Email: ([^\"]*)$")
    public void iEnterTheUsersEmailAddressAsEmailAdmin(String email) {
        System.out.println("The email address is: " + email);
    }

    @And("^I enter the following details for login information$")
    public void iEnterTheFollowingDetailsForLoginInformation(DataTable table) {
        List<List<String>> data = table.asLists(String.class);
        String userName = data.get(0).get(1);
        String passWord = data.get(1).get(1);

        List<User> users = new ArrayList<>();
        users.add(new User(userName, passWord));

        LoginPage page = new LoginPage(base.Driver);

        for (User user : users) {
            page.login(user.username, user.password);
        }
    }

    public class User {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            username = userName;
            password = passWord;
        }
    }

}
