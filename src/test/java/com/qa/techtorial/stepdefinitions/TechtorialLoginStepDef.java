package com.qa.techtorial.stepdefinitions;

import com.qa.techtorial.pages.TechtorialLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class TechtorialLoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    TechtorialLoginPage techtorialLoginPage=new TechtorialLoginPage(driver);

    @Given("User validates the title is {string} from LoginPage")
    public void user_validates_the_title_is_from_login_page(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle());
    }

    @Given("User validates the log In is visible on the page")
    public void user_validates_the_log_in_is_visible_on_the_page() {
        Assert.assertTrue(techtorialLoginPage.isVisible());
    }

    @When("User provides username and password to the Sign In box")
    public void user_provides_username_and_password_to_the_sign_in_box() {
        techtorialLoginPage.login(ConfigReader.readProperty("email"),
                                  ConfigReader.readProperty("password"));
    }

    @Then("User validates the title is {string} from HomePage")
    public void user_validates_the_title_is_from_home_page(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle());
    }

    @When("User provides {string} and {string} to the Sign In Box")
    public void user_provides_and_to_the_sign_in_box(String email, String password) {
      techtorialLoginPage.login(email,password);
    }
    @Then("User validates {string} and color {string} from loginPage")
    public void user_validates_and_color_from_login_page(String message, String color) {
        techtorialLoginPage.messageAndColor(message,color);
    }
}
