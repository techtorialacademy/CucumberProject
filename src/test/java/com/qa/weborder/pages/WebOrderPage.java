package com.qa.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class WebOrderPage {

    public WebOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement productName;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement customerName;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox4")
    WebElement state;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zipCode;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_0")
    WebElement cardTypeVisa;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_1")
    WebElement cardTypeMasterCard;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_2")
    WebElement cardTypeAmericanExpress;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumber;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expireDate;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;

    @FindBy(xpath = "//strong")
    WebElement message;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td")
    List<WebElement> allInformation;

    public void productInformation(String productName, String quantity) throws InterruptedException {
        BrowserUtils.selectBy(this.productName, productName, "text");
        Thread.sleep(1000);
        this.quantity.clear();
        Thread.sleep(2000);
        this.quantity.sendKeys(quantity);
    }

    public void addressInformation(String customerName, String street, String city, String state, String zipCode) {
        this.customerName.sendKeys(customerName);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zipCode.sendKeys(zipCode);
    }

    public void paymentInformation(String cardType, String cardNumber, String expireDate) {
        cardType = cardType.toLowerCase();
        switch (cardType) {
            case "visa":
                cardTypeVisa.click();
                break;
            case "mastercard":
                cardTypeMasterCard.click();
                break;
            case "american express":
                cardTypeAmericanExpress.click();
                break;
            default:
                cardTypeVisa.click();
        }
        this.cardNumber.sendKeys(cardNumber);
        this.expireDate.sendKeys(expireDate);
        processButton.click();
    }

    public String message() {
        return BrowserUtils.getText(message);
    }

    public void validateOrderInformation(String name, String productName, String quantity, String street, String city, String state, String zipCode,
                                         String cardType, String cardNumber, String expireDate) {

        //PLEASE DO NOT LOSE THIS CODE
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);

        List<String> expectedInformation = Arrays.asList(name, productName, quantity, currentDate, street, city, state, zipCode, cardType, cardNumber, expireDate);

        for (int i = 1; i < allInformation.size() - 1; i++) {
            Assert.assertEquals(expectedInformation.get(i - 1), BrowserUtils.getText(allInformation.get(i)));
        }
    }


}
