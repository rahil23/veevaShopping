package veeveDemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utility.ReadJson;

public class BaseTest {
	
	public WebDriver driver;
	public  ExtentReports extent;

	@BeforeClass
	//public WebDriver init(String browserName)
	public void init()

	{
	
		String driverPath=null;
		  
		extent = new ExtentReports();
		 // ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
		  ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
		  extent.attachReporter(spark);
		  
		String jsonPath = System.getProperty("user.dir")+"//testData.json";
		ReadJson testData = new ReadJson();
		HashMap<String,String> jsonProp = (HashMap<String, String>) testData.readJson(jsonPath);
		
	
			driverPath = System.getProperty("user.dir") + "//drivers//geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",driverPath); // Setting system properties of FirefoxDriver
		    driver = new FirefoxDriver();
		
		//driver.get((String) testData.readJson().get("url"));
		driver.get(jsonProp.get("url"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		

	}
	
	@AfterClass
	public void finish()
	{
		extent.flush();
		driver.quit();
	}

}