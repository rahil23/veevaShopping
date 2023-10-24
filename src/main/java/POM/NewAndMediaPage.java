package POM;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAndMediaPage extends BasePage {
	WebDriver driver;

	@FindBy(linkText = "...")
	WebElement threeDots;

	@FindBy(linkText = "News & Features")
	WebElement newsAndFeaturesLinks;

	@FindBy(xpath = "(//ul[starts-with(@class,\"ContentGrid_contentGridArticles\")])[2]/li")
	List<WebElement> videoLinkCount;

	@FindBy(xpath = "(//ul[starts-with(@class,\"ContentGrid_contentGridArticles\")])[2]/li[1]/div[1]/div[2]/div[2]/div/time/span")
	List<WebElement> videoLinkhrs;

	@FindBy(xpath = "(//ul[starts-with(@class,\"ContentGrid_contentGridArticles\")])[2]/li[1]/div/div[2]/div[2]/div[1]/time/span")
	WebElement getTime;

	@FindBy(xpath = "(//ul[starts-with(@class,'ContentGrid_contentGridArticles')])[2]/li[%d]/div/div[2]/div[2]/div/div[3]/div/div/time/span")
	List<WebElement> test;

	private int count;

	/***
	 * This is class constructor which is responsible for initializing webelements
	 * using PageFactory initElements defined in parent class constructor
	 */
	public NewAndMediaPage() {
		super();
		driver = initDriver();
	}

	/***
	 * This method is used t click on news and feature Link
	 * 
	 * @param driver
	 */
	public void clickNewsFeatures() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions action = new Actions(driver);
		action.moveToElement(threeDots).perform();
		newsAndFeaturesLinks.click();
	}


	/***
	 * This method is used to fetch all the video feeds present in News & Features
	 * Page
	 */
	public void getTime() {
		String testXpath = "(//ul[starts-with(@class,'ContentGrid_contentGridArticles')])[2]/li[%d]/div/div[2]/div[2]/div/div[3]/div/div/time/span";

		WebElement videoCliplnk = null;
		ArrayList<StringBuffer> ar = new ArrayList<StringBuffer>();
		int getLengthVideo = videoLinkCount.size();
		int temp = 2;
		System.out.println(getTime.getText());
		for (int i = 1; i <= getLengthVideo - 1; i++) {
			videoCliplnk = driver
					.findElement(By.xpath("(//ul[starts-with(@class,'ContentGrid_contentGridArticles')])[2]/li[" + temp
							+ "]/div/div[2]/div[2]/div/div[3]/div/div/time/span"));

			String videoLinkhrs = videoCliplnk.getText();
			count = getOldSince(videoLinkhrs, "d", 3);
			System.out.println(temp + "th index hrs are : " + videoLinkhrs);
			temp++;
		}
		System.out.println("The total number of video present as per filter of time and timeunit is" + count);
	}

	/***
	 * This Method is to get number of count of video/Feed according to passed Char
	 * and time Unit
	 * 
	 * @param timeAmount refers the how old content user want to fetch
	 * @param matchChar  refers the on what timeunit user want to fetch
	 * @param time
	 * @return count
	 */
	int getOldSince(String timeAmount, String matchChar, int time) {

		if (timeAmount.contains(matchChar)) {
			int size = timeAmount.length();
			String sb = timeAmount.substring(0, size - 1);

			if (Integer.parseInt(sb) >= time) {
				count++;
			}
		}
		return count;
	}

	/***
	 * This method refers the fetch umber of video counts present screen
	 */
	public void countVideoLnks() {
		int getLengthVideo = videoLinkCount.size();
		System.out.println("the count of video is : " + getLengthVideo);
	}
}
