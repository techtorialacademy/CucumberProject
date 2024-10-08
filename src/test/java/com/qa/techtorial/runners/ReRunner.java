package com.qa.techtorial.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) //IT RUNS ONLY FAILURES
@CucumberOptions(
        features = "@target/uiFailedTests.txt", //provide the location of only failures
        glue = "com/qa/techtorial/stepdefinitions", //source root of step definitions
        tags = "@regression",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)
public class ReRunner {
}
