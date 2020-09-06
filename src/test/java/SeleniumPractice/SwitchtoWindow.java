package SeleniumPractice;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class SwitchtoWindow {

	WebDriver driver;
	
	SwitchtoWindow(WebDriver driver)
	{
		this.driver=driver;		
	}
	
	public boolean toTitle(String title)
	{
		String parentwindow = driver.getWindowHandle();
		
		Set<String> windows = driver.getWindowHandles();
		
		for(String child : windows)
		{
			if(!parentwindow.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				if(driver.getTitle().equals(title))
				{
					return true;
				}
			driver.switchTo().window(parentwindow);
			}
				
		}
		return false;
	}
	
}
