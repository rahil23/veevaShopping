package testScript;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import POM.MenPagePOM;
import POM.NewAndMediaPOM;
import POM.TeamPOM;
import POM.WarriorsPOM;
import Utility.SwitchWindow;
import Utility.Xls_Reader;
import io.cucumber.java.en.Given;
import veeveDemo.BaseTest;

public class NewsAndFeatures extends BaseTest {
	
	//public static void main(String[] args) throws IOException {
		

	@Test
	public void test1()
	{
		WebDriver driver;
		BaseTest test = new BaseTest();
		driver=test.init("Chrome");
		ExtentReports extent=null;
		
		Xls_Reader utility = new Xls_Reader();
		//extentTest.log(Status.INFO,"login to browser");
		ExtentTest extentTest = extent.createTest("Launch the browser and get count of video feeds which are posted since particular time period").assignAuthor("Rahil");
		//driver=test.init("https://www.nba.com/warriors","Firefox");
		extentTest.log(Status.INFO,"Killing 2 popups");
		extentTest.log (Status.PASS,"Killing 2 popups");
		
		WarriorsPOM obj2 = new WarriorsPOM(driver); 
		  obj2.acceptWarriorDialog();
		
		  extentTest.log(Status.INFO,"Navigating to News&Media Features");
		  extentTest.log (Status.PASS,"Clicked on News&Media from top menu using Actions class");
		NewAndMediaPOM obj = new NewAndMediaPOM(driver); 
		  obj.clickNewsFeatures(driver);
	
		  extentTest.log(Status.INFO,"Count the total number of Video feed links");
		  extentTest.log(Status.PASS,"COunted all videos in video feed successfully");
		  obj.countVideoLnks();
		  
		  extentTest.log(Status.INFO,"Count the total number of video feed posted since particular/Requested time");
		  extentTest.log(Status.PASS,"Successfully able to retreive the number of video according to requested time in config.properties");
		  obj.getTime();
		
		 extent.flush();
		driver.quit();
		
		

}
}
