package SeleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Wait {
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
	public void waitmetods()
	{
		WebElement element=driver.findElement(By.name("q"));
		driver.findElements(By.tagName("div"));
		//Explicitely wait
		WebDriverWait wait =  new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
		driver.findElements(By.tagName("a"));
		
		
				
	}
	
	@AfterTest
	public void Teardown()
	{
		//driver.close();
	}
	
	

}
