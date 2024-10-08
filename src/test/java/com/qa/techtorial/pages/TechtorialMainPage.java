package com.qa.techtorial.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TechtorialMainPage {

    public TechtorialMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[.='Products']")
    WebElement productButton;


    public void clickProductButton(){
        productButton.click();
    }
}
