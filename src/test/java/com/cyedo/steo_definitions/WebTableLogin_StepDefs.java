package com.cyedo.steo_definitions;

import com.cyedo.pages.WebTableLoginPage;
import com.cyedo.utility.ConfigurationReader;
import com.cyedo.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class WebTableLogin_StepDefs {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();

    @Given("user is on the login page of web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

    }
    @When("user enters username {string}")
    public void user_enters_username(String userName) {
        webTableLoginPage.inputUsername.sendKeys(userName);

    }
    @When("user enters password {string}")
    public void user_enters_password(String passowrd) {
        webTableLoginPage.inputPassowrd.sendKeys(passowrd);

    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        webTableLoginPage.loginButton.click();

    }
    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("orders"));

    }

    @When("user enters username {string} password {string} and logins")
    public void userEntersUsernamePasswordAndLogins(String userName, String passowrd) {
      //  webTableLoginPage.inputUsername.sendKeys(userName);
      //  webTableLoginPage.inputPassowrd.sendKeys(passowrd);
     //   webTableLoginPage.loginButton.click();

        webTableLoginPage.login(userName,passowrd);

    }

    @When("user enters below credentials")
    public void userEntersBelowCredentials(Map<String,String> credentials) {
     //   webTableLoginPage.inputUsername.sendKeys(credentials.get("username "));
    //    webTableLoginPage.inputPassowrd.sendKeys(credentials.get("password"));
    //    webTableLoginPage.loginButton.click();

        webTableLoginPage.login(credentials.get("username"),credentials.get("password"));

    }
}
