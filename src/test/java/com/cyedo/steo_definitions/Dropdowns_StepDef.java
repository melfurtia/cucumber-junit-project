package com.cyedo.steo_definitions;

import com.cyedo.pages.DropdownsPage;
import com.cyedo.utility.BrowserUtils;
import com.cyedo.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Dropdowns_StepDef {

    DropdownsPage dropdownsPage = new DropdownsPage();
    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");

    }
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {

        List<String> actualOptionsAsString = BrowserUtils.dropdownOptionsAsString(dropdownsPage.monthDropdown);

        Assert.assertEquals(expectedMonths,actualOptionsAsString);






    }
}
