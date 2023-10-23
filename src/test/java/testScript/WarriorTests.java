package testScript;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import POM.MenPagePOM;
import POM.TeamPOM;
import POM.WarriorsPOM;
import utility.SwitchWindow;
import utility.Xls_Reader;
import veeveDemo.BaseTest;

public class WarriorTests extends BaseTest {

	/***
	 * This test case is responsible of fetching number of men's jacket
	 * 
	 * @throws IOException
	 */
	
	@Test
	public void fetchJacketsInfo() throws IOException {
		Xls_Reader utility = new Xls_Reader();
	
		WarriorsPOM obj = new WarriorsPOM(driver);
		obj.acceptWarriorDialog();

		obj.hoverClickWarriorMen(driver);

		String mainwindow = driver.getWindowHandle();
		SwitchWindow sw = new SwitchWindow();
		sw.switchChildWindow(driver, mainwindow);
		System.out.println(driver.getTitle());

		MenPagePOM menPom = new MenPagePOM(driver);

		List<ArrayList<String>> records = menPom.hoverClickWarriorMen(driver);

		try {
			utility.writeExcel(records);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sw.switchParent(driver, mainwindow);

		driver.quit();

	}
}
