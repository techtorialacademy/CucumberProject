package com.qa.weborder.stepdefinitions;

import com.qa.weborder.pages.WebOrderLoginPage;
import com.qa.weborder.pages.WebOrderMainPage;
import com.qa.weborder.pages.WebOrderPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class WebOrderStepDef {

    WebDriver driver = DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage(driver);
    WebOrderMainPage webOrderMainPage = new WebOrderMainPage(driver);
    WebOrderPage webOrderPage = new WebOrderPage(driver);

    @Given("User provides username,password and click order button")
    public void user_provides_username_password_and_click_order_button() {
        webOrderLoginPage.login(ConfigReader.readProperty("weborder_username"),
                ConfigReader.readProperty("weborder_password"));
        webOrderMainPage.clickOrderButton();
    }

    @When("User enters the product information {string} and {string}")
    public void user_enters_the_product_information_and(String productName, String quantity) throws InterruptedException {
        webOrderPage.productInformation(productName, quantity);

    }

    @When("User enters the address information {string},{string},{string},{string},{string}")
    public void user_enters_the_address_information(String customerName, String street, String city, String state, String zipCode) {
        webOrderPage.addressInformation(customerName, street, city, state, zipCode);
    }

    @When("User enters the payment information {string},{string},{string} and click process button")
    public void user_enters_the_payment_information_and_click_process_button(String cardType, String cardNumber, String expireDate) {
        webOrderPage.paymentInformation(cardType,cardNumber,expireDate);
    }

    @Then("User validates {string}")
    public void user_validates(String expectedMessage) {
        Assert.assertEquals(expectedMessage,webOrderPage.message());
    }

    @Then("User validates all the information {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void user_validates_all_the_information(String name, String productName, String quantity, String street, String city, String state, String zipCode,
                                                   String cardType, String cardNumber, String expireDate) {
        webOrderMainPage.clickViewOrderButton();
        webOrderPage.validateOrderInformation(name,productName,quantity,street,city,state,zipCode,cardType,cardNumber,expireDate);
    }

    @When("User enters the product information")
    public void user_enters_the_product_information(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        Map<String,String> productInformation=dataTable.asMap();
        System.out.println(productInformation);//proof
        webOrderPage.productInformation(productInformation.get("productName"),productInformation.get("quantity"));
    }
    @When("User enters the address information")
    public void user_enters_the_address_information(io.cucumber.datatable.DataTable dataTable) {
    Map<String,String> allAddressInformation=dataTable.asMap();
    webOrderPage.addressInformation(allAddressInformation.get("name"),allAddressInformation.get("street"),
            allAddressInformation.get("city"),allAddressInformation.get("state"),allAddressInformation.get("zipCode"));
    }
    @When("User enters the payment information and click process button")
    public void user_enters_the_payment_information_and_click_process_button(io.cucumber.datatable.DataTable dataTable) {
        Map<String,String> allPaymentInformation=dataTable.asMap();
        webOrderPage.paymentInformation(allPaymentInformation.get("cardType"),allPaymentInformation.get("cardNumber"),
                allPaymentInformation.get("expireDate"));
    }
    @Then("User validates message")
    public void user_validates_message(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedMessage=dataTable.asList();
        Assert.assertEquals(expectedMessage.get(0),webOrderPage.message());
    }
}
