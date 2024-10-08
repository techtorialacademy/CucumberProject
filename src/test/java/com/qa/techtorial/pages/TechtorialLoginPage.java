package com.qa.techtorial.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class TechtorialLoginPage {

    public TechtorialLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h3[.='Log In']")
    WebElement header;

    @FindBy(css = "#email")
    WebElement email;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//button[@id='submit-login']")
    WebElement loginButton;
    @FindBy(css = ".invalid-feedback")
    WebElement message;
    public boolean isVisible(){
        return header.isDisplayed();
    }
    public void login(String email,String password){
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void messageAndColor(String expectedMessage,String expectedColor){
        Assert.assertEquals(expectedMessage,BrowserUtils.getText(message));
        Assert.assertEquals(expectedColor,message.getCssValue("color"));
    }
}
