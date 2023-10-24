package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utility.DriverFactory;

public class BasePage extends DriverFactory {
	
	/***
	 * This method is responsible to get Existing or new drive instance from base Test Class
	 * @return
	 */
	public WebDriver initDriver()
	{
		return getWebDriver("Firefox");
		
	}
	
	/***
	 * This is existing class constructor to initialize the driver and page factory for all child classes
	 */
	public BasePage() {
		initDriver();
		PageFactory.initElements(driver, this);
	}

}
