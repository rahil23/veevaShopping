package utility;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SwitchWindow {
	
	/***
	 * This method is responsible to switch to child window
	 * @param driver pass driver reference
	 * @param mainWindow pass main window reference
	 */
	public void switchChildWindow(WebDriver driver,String mainWindow)
	{
	Set<String> s1 = driver.getWindowHandles();
    Iterator<String> i1 = s1.iterator();
    
    while (i1.hasNext()) {
        String ChildWindow = i1.next();
            if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
            driver.switchTo().window(ChildWindow);
           
        }
    }    

}
	/***
	 * This method is for closing the current window and switch to parent window
	 * @param driver pass driver refrence
	 * @param mainWindow pass mainwindow refrence
	 */
public void switchParent(WebDriver driver,String mainWindow)
{
driver.close();
	driver.switchTo().window(mainWindow);
}
}
