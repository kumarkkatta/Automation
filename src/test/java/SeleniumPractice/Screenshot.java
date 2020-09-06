package SeleniumPractice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Screenshot {
	
	
	WebDriver driver;
	@BeforeTest
	public void initialisingBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "G:/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Implicitely wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}
	
	@Test
	public void waitmetods() throws Exception
	{
		WebElement element=driver.findElement(By.name("q"));
		driver.findElements(By.tagName("div"));
		//Explicitely wait
		WebDriverWait wait =  new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
		driver.findElements(By.tagName("a"));
		takesscreenshot("Screenshot1");
					
	}
	
	
	public void takesscreenshot(String filename) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File("C:/Users/kiran/workspace/Automation/FailedScreenshots/"+filename+".jpeg"));
		
	}
	
	
	@AfterTest
	public void Teardown()
	{
		//driver.close();
	}
	

}
