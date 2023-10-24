package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import POM.MenPage;
import POM.WarriorsPage;
import utility.SwitchWindow;
import utility.Xls_Reader;

public class WarriorTests extends BaseTest {
	WebDriver driver;
	BaseTest bs;
	ExtentTest extentTest;
	ExtentReports extent;
	ExtentSparkReporter spark;

	/***
	 * This is constructor initializing the driver and calling the base test method to start session
	 */
	public WarriorTests() {
		 bs = new BaseTest();
		driver=bs.getWebDriver("Firefox");
		extent = new ExtentReports();
		  spark = new ExtentSparkReporter("extentReport.html");
		  extent.attachReporter(spark);
	}
	
	
	/***
	 * This test case is responsible of fetching number of men's jacket
	 * 
	 * @throws IOException
	 */
	@Test
	public void fetchJacketsInfo() throws IOException {
		Xls_Reader utility = new Xls_Reader();
	  extentTest = extent
				.createTest(
						"Launch the browser and get count of video feeds which are posted since particular time period")
				.assignAuthor("Rahil");
	
	  extentTest.log(Status.INFO, "Killing 2 popups");
		extentTest.log(Status.PASS, "Killing 2 popups");
		WarriorsPage obj = new WarriorsPage();
		obj.acceptWarriorDialog();

		extentTest.log(Status.PASS, "Navigating to Men's jacket section");
		obj.hoverClickWarriorMen();

		String mainwindow = driver.getWindowHandle();
		SwitchWindow sw = new SwitchWindow();
		sw.switchChildWindow(driver, mainwindow);
		System.out.println(driver.getTitle());

		MenPage menPom = new MenPage();

		extentTest.log(Status.PASS, "fetching all the jacket's title, price and sellers tagline");
		List<ArrayList<String>> records = menPom.hoverClickWarriorMen();

		extentTest.log(Status.PASS, "Writing the results into excel file");
		try {
			utility.writeExcel(records);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		extentTest.log(Status.PASS, "closing the current window and moving to child window");
		sw.switchParent(driver, mainwindow)	;

		extentTest.log(Status.PASS, "Flushing all the info to report");
		extent.flush();
		
		extentTest.log(Status.PASS, "Closing the bwrowser");
		bs.closeBrowser();
	}
	
}

