package utility;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;

public class DriverFactory {

	// Initially Driver will have default value that is null
	public static WebDriver driver;
	String driverPath = null;
	public void launchBrowserAndWebSite(String browser) {
		String jsonPath = System.getProperty("user.dir")+"//testData.json";
		ReadData testData = new ReadData();
		HashMap<String,String> jsonProp = (HashMap<String, String>)  testData.readJson(jsonPath);
		  
		if (driver == null ) {
			if(browser.equals("Firefox"))
			{
			driverPath = System.getProperty("user.dir") + "//drivers//geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath); // Setting system properties of FirefoxDriver
			driver = new FirefoxDriver();
			}
			else if(driver.equals("Chrome"))
			{
				driverPath = System.getProperty("user.dir") + "//drivers//chromedriver.exe";
				// System Property for Chrome Driver
				System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();	
			}
			else {
				driverPath = System.getProperty("user.dir") + "//drivers//IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver",driverPath); // Setting system properties of FirefoxDriver
			    driver = new InternetExplorerDriver();
			}
			driver.get(jsonProp.get("url"));
			driver.manage().window().maximize();
		}
	}

	// Singleton Design Pattern
	public WebDriver getWebDriver(String browserName) {
		if (driver == null) {
			launchBrowserAndWebSite(browserName);
		}
		return driver;
	}

	/***
	 * This method s to closing the browser and killing the object
	 */
	public void closeBrowser() {
		if (null != driver) {
			driver.quit();
			driver = null;
			
		}
	}
}
