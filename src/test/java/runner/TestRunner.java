package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "/src/test/resources/Features",
					glue  = {"testScript"},
					plugin = {"pretty","html:target/cucumber-reports","json:target/cucumber.json"},
					monochrome = true,
					publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	@DataProvider(parallel=true)
	public Object[][] scenario()
	{
		return super.scenarios();
	}
	

}
