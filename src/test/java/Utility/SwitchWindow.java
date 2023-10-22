package Utility;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SwitchWindow {
	
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
public void switchParent(WebDriver driver,String mainWindow)
{
driver.close();
	driver.switchTo().window(mainWindow);
}
}
