package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WarriorsPage extends BasePage {
	
	WebDriver driver;
	
	@FindBy(id="onetrust-accept-btn-handler")
	WebElement acceptCookieBtn;
	
	@FindBy(xpath="//div[@role='dialog']/div/div")
	WebElement warriorDialog;
	
	@FindBy(linkText="SHOP")
	WebElement shopLinkTxt;
	
	@FindBy(linkText="Men's")
	WebElement menLinktext;
	
	/***
	 * This is class constructor which is responsible for initializing webelements
	 * using PageFactory initElements defined in parent class constructor
	 */
	public WarriorsPage()
	{
		super();
		driver = initDriver();
	}
	
	/***
	 * This method is responsible to close the popup opens up at warrior home page 
	 */
	public void acceptWarriorDialog()
	{
		
		if(warriorDialog.isEnabled())
		{
		warriorDialog.click();
		}
		if(acceptCookieBtn.isEnabled())
		{
			acceptCookieBtn.click();
		}
	}
	
	/***
	 * This method is to navigate to men's section
	 */
	public void hoverClickWarriorMen()
	{
	
		Actions action = new Actions(driver);
		action.moveToElement(shopLinkTxt).perform();
		menLinktext.click();	
		
	}

	

}
