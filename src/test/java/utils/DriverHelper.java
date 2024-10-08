package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class DriverHelper {

    //Singleton Pattern Design

    //You cannot create an object from this class(private)
    //We will apply Encapsulation

    private static WebDriver driver;

    private DriverHelper() {
    }

    ; //to not create an object from this class(Unique driver)

    public static WebDriver getDriver() {

        if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {

            switch (ConfigReader.readProperty("browser")) {

                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--window-size=1920,1080");

                    driver = new ChromeDriver(options);
                    System.out.println("THE DRIVER SETUP IS COMPLETED");
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().deleteAllCookies();
        }
        return driver;
    }
}
