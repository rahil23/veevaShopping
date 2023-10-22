package POM;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenPagePOM {

	WebDriver driver;

	@FindBy(id = "onetrust-accept-btn-handler")
	WebElement acceptCookieBtn;

	@FindBy(xpath = "//div[@role='dialog']/div/div")
	WebElement warriorDialog;

	@FindBy(linkText = "Jackets")
	WebElement jacketsLinkTxt;

	@FindBy(linkText = "MEN")
	WebElement menLinktext;

	@FindBy(xpath = "//div[@class='product-grid-top-area']//parent::div//div[2]/div[1]/div/div/div/div/a/img")
	WebElement jacketTitle;

	@FindBy(xpath = "//div[@class='product-grid-top-area']//parent::div//div[2]/div[1]/div/div[2]/div/div/div/div/span/span/span/span")
	WebElement jacketPrice;

	@FindBy(xpath = "//div[@class='product-grid-top-area']//parent::div//div[2]/div[1]/div[1]/div[2]/div[4]/div//span")
	List<WebElement> jacketTagLine1;

	@FindBy(xpath = "//li[@class='next-page']/a/i")
	WebElement nxtPageArrow;

	@FindBy(xpath = "//div[@class='product-grid-top-area']//parent::div//div[2]//div[@class='column']")
	List<WebElement> totalNoOfElement;

	@FindBy(xpath = "//i[@class='previous page']")
	WebElement isPreviousEnable;

	@FindBy(xpath = "//li[@class='show-for-large']/a")
	WebElement pageNoJacket;
	
	@FindBy(xpath = "(//i[contains(@class,'icon-close-alt')])[2]")
	WebElement popup;
	
	public MenPagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void acceptWarriorDialog() {
		if (acceptCookieBtn.isEnabled()) {
			acceptCookieBtn.click();
		}
		if (warriorDialog.isEnabled()) {
			warriorDialog.click();
		}

	}

	public List<ArrayList<String>> hoverClickWarriorMen(WebDriver driver) {
		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
if(popup.isEnabled())
{
		popup.click();
}
		this.driver = driver;

		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(menLinktext).perform();

		jacketsLinkTxt.click();

		List<String> jacketTitle = new ArrayList<String>();
		List<String> jacketPrices = new ArrayList<String>();
		List<String> jacketSellersMessage = new ArrayList<String>();
		List<ArrayList<String>> recordsList = new ArrayList();

		int PageSize = Integer.parseInt(pageNoJacket.getText());
		int count = 0;

		int noOfElement = totalNoOfElement.size();
		System.out.println(noOfElement);

		for (int i = 1; i <= noOfElement; i++) {
			WebElement title = driver.findElement(By.xpath(
					"//div[@class='product-grid-top-area']//parent::div//div[2]/div[" + i + "]/div/div[2]/div[2]"));
			jacketTitle.add(title.getText());
			System.out.println("Jacket Title" + i + "-->" + jacketTitle.get(count));
			WebElement prices = driver
					.findElement(By.xpath("//div[@class='product-grid-top-area']//parent::div//div[2]/div[" + i
							+ "]/div/div[2]/div/div/div/div/span/span/span/span"));
			jacketPrices.add(prices.getText());
			System.out.println("JPrice" + i + "-->" + jacketPrices.get(count));
			String attributeName = driver
					.findElement(By.xpath(
							"//div[@class='product-grid-top-area']//parent::div//div[2]/div[" + i + "]/div[1]/div[2]"))
					.getAttribute("class");
			System.out.println(attributeName);
			List<WebElement> checkSellerMessage = driver.findElements(By.xpath(
					"//div[@class='product-grid-top-area']//parent::div//div[2]/div[" + i + "]/div[1]/div[2]/div"));
			if (checkSellerMessage.size() > 3) {
				List<WebElement> sellersMessage = driver
						.findElements(By.xpath("//div[@class='product-grid-top-area']//parent::div//div[2]/div[" + i
								+ "]/div[1]/div[2]/div[4]/div//span"));
				jacketSellersMessage.add(sellersMessage.get(0).getText());
				System.out.println("JSellerMessage" + i + "-->" + jacketSellersMessage.get(count));
			} else {
				jacketSellersMessage.add("");
				System.out.println("JSellerMessage" + i + "-->" + jacketSellersMessage.get(count));
			}
			List<String> eachRecords = new ArrayList();
			eachRecords.add(jacketTitle.get(count));
			eachRecords.add(jacketPrices.get(count));
			eachRecords.add(jacketSellersMessage.get(count));
			recordsList.add((ArrayList<String>) eachRecords);
			count++;

		}
		System.out.println("hi");
		return recordsList;

	}

}
