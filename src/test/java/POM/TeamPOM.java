package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.SwitchWindow;

public class TeamPOM {
	
	WebDriver driver;
	
	@FindBy(id="onetrust-accept-btn-handler")
	WebElement acceptCookieBtn;
	
	@FindBy(linkText="Teams")
	WebElement teamLinkTxt;
	
	//@FindBy()
	
	@FindBy(linkText="Boston Celtics")
	WebElement bostonCelticsTicket;
	
	public TeamPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void acceptPage()
	{
		acceptCookieBtn.click();
	}
	
	public void hoverCLickTeam(String teamName,WebDriver driver)
	{
		this.driver=driver;
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(teamLinkTxt).perform();
		
		
		WebElement team= driver.findElement(By.linkText(teamName));
		team.click();
		
		
		
	}

}
