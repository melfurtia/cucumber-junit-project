package com.cyedo.steo_definitions;

import com.cyedo.pages.BasePage;
import com.cyedo.pages.ViewAllOrderPage;
import com.cyedo.pages.WebTableLoginPage;
import com.cyedo.pages.WebTableOrderPage;
import com.cyedo.utility.BrowserUtils;
import com.cyedo.utility.ConfigurationReader;
import com.cyedo.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebTableOrder_StepDefs {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    BasePage basePage = new BasePage();
    WebTableOrderPage webTableOrderPageb = new WebTableOrderPage();
    ViewAllOrderPage viewAllOrderPage = new ViewAllOrderPage();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        webTableLoginPage.login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
        basePage.orderButtonNavItem.click();
    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select select = new Select(webTableOrderPageb.productTypeDropdown);
        select.selectByVisibleText(string);

    }
    @When("user enters quantity {int}")
    public void user_enters_quantity(Integer int1) {
        webTableOrderPageb.inputQuantity.clear();
        webTableOrderPageb.inputQuantity.sendKeys(int1+"");

    }
    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {
        webTableOrderPageb.inputName.sendKeys(string);

    }
    @When("user enters street {string}")
    public void user_enters_street(String string) {
        webTableOrderPageb.inputStreet.sendKeys(string);

    }
    @When("user enters city {string}")
    public void user_enters_city(String string) {
        webTableOrderPageb.inputCity.sendKeys(string);

    }
    @When("user enters state {string}")
    public void user_enters_state(String string) {
        webTableOrderPageb.inputState.sendKeys(string);

    }
    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        webTableOrderPageb.inputZip.sendKeys(string);

    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String string) {
        BrowserUtils.clickRadioButton(webTableOrderPageb.cardType,string);

    }
    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        webTableOrderPageb.inputCardNo.sendKeys(string);

    }
    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        webTableOrderPageb.inputCardExp.sendKeys(string);

    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
        webTableOrderPageb.processOrderButton.click();

    }
    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expectedCustomerName) {

        String actualCustomerName = viewAllOrderPage.newCustomerCell.getText();
        Assert.assertEquals(expectedCustomerName,actualCustomerName);

    }
}
