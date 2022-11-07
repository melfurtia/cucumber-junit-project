package com.cyedo.pages;

import com.cyedo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {

    public WebTableLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "username")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement inputPassowrd;

    @FindBy(xpath = "//button[@class='btn btn-primary login__submit']")
    public WebElement loginButton;


    /**
     *
     * @param username
     * @param password
     */
    public void login(String username,String password){
        inputUsername.sendKeys(username);
        inputPassowrd.sendKeys(password);
        loginButton.click();


    }

}
