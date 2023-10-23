package testScript;

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

import POM.MenPagePOM;
import POM.NewAndMediaPOM;
import POM.TeamPOM;
import POM.WarriorsPOM;
import utility.SwitchWindow;
import utility.Xls_Reader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import veeveDemo.BaseTest;

public class NewsAndFeatures extends BaseTest {

	// public static void main(String[] args) throws IOException {
	// ExtentReports extent=null;

	// WebDriver driver;
	WarriorsPOM obj2;
	NewAndMediaPOM obj;

	// @Before
	@Test
	public void start() {

		Xls_Reader utility = new Xls_Reader();
	
		ExtentTest extentTest = extent
				.createTest(
						"Launch the browser and get count of video feeds which are posted since particular time period")
				.assignAuthor("Rahil");
		// }

		// @Given("User is on NBA Warrior Home Page")
		// void navigateWarriorClosePopup() {
		// driver=test.init("https://www.nba.com/warriors","Firefox");

		extentTest.log(Status.INFO, "Killing 2 popups");
		extentTest.log(Status.PASS, "Killing 2 popups");

		obj2 = new WarriorsPOM(driver);
		obj2.acceptWarriorDialog();
		Assert.assertEquals(driver.getTitle(), "Home | Golden State Warriors");
		// }

		// @When("User navigates to SHOP {string} section further user navigates to
		// {string} section")
		// public void navigateToNewsMedia()
		// {

		extentTest.log(Status.INFO, "Navigating to News&Media Features");
		extentTest.log(Status.PASS, "Clicked on News&Media from top menu using Actions class");

		obj = new NewAndMediaPOM(driver);
		obj.clickNewsFeatures(driver);
		Assert.assertEquals(driver.getTitle(), "News & Media | NBA.com");
		// }

		// public void countAllVideoFeed() {
		extentTest.log(Status.INFO, "Count the total number of Video feed links");
		extentTest.log(Status.PASS, "COunted all videos in video feed successfully");
		obj.countVideoLnks(); // }

		//// @Then("user has fetched the info like jacket title,jacket price and sellers
		//// headline")
		// public void countVideoBasedOnTime()
		// {

		extentTest.log(Status.INFO, "Count the total number of Video feed links");
		extentTest.log(Status.PASS, "COunted all videos in video feed successfully");

		obj.countVideoLnks();

		extentTest.log(Status.INFO, "Count the total number of video feed posted since particular/Requested time");
		extentTest.log(Status.PASS,
				"Successfully able to retreive the number of video according to requested time in config.properties");

		obj.getTime();
		
	

		// @Then("Store the info in excel")
		// public void prepareReport()
		// {
		// extent.flush();
	}

	/*
	 * @After public void closeBrowser() { driver.quit(); }
	 */
}
