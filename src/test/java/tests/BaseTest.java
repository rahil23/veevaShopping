package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utility.DriverFactory;
import utility.ReadData;

public class BaseTest extends DriverFactory {
	ReadData read = new ReadData();
	
	
	@BeforeTest
	public void initDriver()
	{
		getWebDriver(read.fetchProperty("browserName"));
	}
	


}
