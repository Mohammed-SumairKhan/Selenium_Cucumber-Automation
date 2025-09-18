package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		  features = "src/test/resources/features/Search.feature",
		  glue = {"stepDefinations"},
		  plugin = {"pretty", "html:target/cucumber-report.html"},
		  tags = "@search",
		  monochrome = true
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
