package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WarriorsPOM {
	
	WebDriver driver;
	
	@FindBy(id="onetrust-accept-btn-handler")
	WebElement acceptCookieBtn;
	
	@FindBy(xpath="//div[@role='dialog']/div/div")
	WebElement warriorDialog;
	
	@FindBy(linkText="SHOP")
	WebElement shopLinkTxt;
	
	@FindBy(linkText="Men's")
	WebElement menLinktext;
	
	public WarriorsPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
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
	
	public void hoverClickWarriorMen(WebDriver driver)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.driver=driver;
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(shopLinkTxt).perform();
		
		menLinktext.click();	
		
	}

	

}
