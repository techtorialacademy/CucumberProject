package com.qa.weborder.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
     features = "src/test/resources/features",//content Root
     glue = "com/qa/weborder/stepdefinitions",//source Root
     dryRun = false,
     tags ="@regressionWebOrder",
     plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTest.txt",
     "json:target/cucumber-reports/cucumber.json"}
)

public class WebOrderRunner {
}
