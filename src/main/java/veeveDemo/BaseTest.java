package veeveDemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utility.ReadJson;

public class BaseTest {
	
	/*
	 * Cucumber Runner class should be created with appropriate Cucumber Option Use
	 * Cucumber Hooks effectively○ Don’t pass cucumber Tags from Runner Class, Pass
	 * cucumber tags from testng.xml file and bind the tag to Runner Class during
	 * runtime
	 */
	
	//@BeforeTest
	public WebDriver init(String browserName)
	{
		WebDriver driver=null;
		String driverPath=null;
		  
		  ExtentReports extent = new ExtentReports();
		 // ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
		  ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
		  extent.attachReporter(spark);
		  
		String jsonPath = System.getProperty("user.dir")+"//testData.json";
		ReadJson testData = new ReadJson();
		HashMap<String,String> jsonProp = (HashMap<String, String>) testData.readJson(jsonPath);
		
		if(browserName.equals("Chrome"))
		{
		driver = new ChromeDriver();
		driverPath = System.getProperty("user.dir") + "//drivers//chromedriver.exe";
		// System Property for Chrome Driver
		System.setProperty("webdriver.chrome.driver", driverPath);
		}
		else if(browserName.equals("Firefox"))
		{
			driverPath = System.getProperty("user.dir") + "//drivers//geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",driverPath); // Setting system properties of FirefoxDriver
		    driver = new FirefoxDriver();
		}
		else
		{
			driverPath = System.getProperty("user.dir") + "//drivers//IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver",driverPath); // Setting system properties of FirefoxDriver
		    driver = new InternetExplorerDriver();
			
		}
		//driver.get((String) testData.readJson().get("url"));
		driver.get(jsonProp.get("url"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
		

	}

}