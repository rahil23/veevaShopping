package testScript;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SampleTest2 {
  @Test
  public void f1() {
  }
  @Test
  public void f2() {
  }
  
  @Test
  public void f3() {
  }  @Test
  public void f4() {
  }
  @Test
  public void f5() {
  }
  @Test
  public void f6() {
  }
  
  @BeforeTest
  public void before()
  {
	  
	  ExtentReports extent = new ExtentReports();
	 // ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
	  ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
	  extent.attachReporter(spark);
  }
  @AfterTest
  public void after()
  {
	  
  }
}
