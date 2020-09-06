package SeleniumPractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sendkeys {
	
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
	public void sendkeysmethod() throws AWTException
	{
		
		WebElement element=driver.findElement(By.name("q"));
		element.sendKeys("Selenium");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='Java seleniium'", element);
		element.clear();
		
		Actions act = new Actions(driver);
		act.sendKeys("Pen testing").build().perform();
		element.clear();
		//JavaScript
		js.executeScript("document.getElementById('tsf').value='Ethical hacking'");
		
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_J);
		robot.keyRelease(KeyEvent.VK_J);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
				
	}
	
	@AfterTest
	public void Teardown()
	{
		//driver.close();
	}
	
	

}
