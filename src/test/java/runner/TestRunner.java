package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features/",
					glue  = {"testScript"},
					plugin = {"html:target/cucumber-reports.html"},
					monochrome = true,
					publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	/*
	 * @DataProvider(parallel=true) public Object[][] scenario() { return
	 * super.scenarios(); }
	 */
	

}
