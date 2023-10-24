package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import POM.NewAndMediaPage;
import POM.WarriorsPage;
import utility.SwitchWindow;
import utility.Xls_Reader;

public class NewsAndFeatures2 extends BaseTest {

	WebDriver driver;
	BaseTest bs;
	NewAndMediaPage obj;
	WarriorsPage obj2;
	ExtentTest extentTest;
	ExtentReports extent;
	ExtentSparkReporter spark;

	public NewsAndFeatures2() {
		// TODO Auto-generated constructor stub
		bs = new BaseTest();
		driver = bs.getWebDriver("Firefox");
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("extentReport.html");
		extent.attachReporter(spark);
	}

	/***
	 * This is test method to get the number of video feeds on basis of time period
	 */
	@Test
	public void user_is_on_nba_warrior_home_page() {
		extentTest = extent
				.createTest(
						"Launch the browser and get count of video feeds which are posted since particular time period")
				.assignAuthor("Rahil");

		extentTest.log(Status.INFO, "Starting the Test");

		BaseTest bs = new BaseTest();
		driver = bs.getWebDriver(read.fetchProperty("browserName"));
		obj2 = new WarriorsPage();
		Xls_Reader utility = new Xls_Reader();

		extentTest.log(Status.INFO, "CLosing two popups on warrier home page");
		obj2.acceptWarriorDialog();

		extentTest.log(Status.PASS, "verifying the warrior home page title");
		Assert.assertEquals(driver.getTitle(), "Home | Golden State Warriors");

		extentTest.log(Status.INFO, "Navigating to news and features page");
		obj = new NewAndMediaPage();

		extentTest.log(Status.INFO, "Navigating to news and features page");
		obj.clickNewsFeatures();

		extentTest.log(Status.INFO, "Verifying the title of news and feature page");
		Assert.assertEquals(driver.getTitle(), "News & Media | NBA.com");

		extentTest.log(Status.INFO, "Verifying the total count of video on Page");
		obj.countVideoLnks();

		extentTest.log(Status.INFO, "Verifying the total count of video as per timings requested");
		obj.getTime();

	}

}
