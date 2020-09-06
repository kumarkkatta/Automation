package Amazon.Automation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Example1 {
	
	WebDriver driver;
	
  @Test
  public void method1() 
  {
	  driver.get("http://www.google.com");
	  driver.findElement(By.name("q")).sendKeys("Selenium");
  }
  @BeforeTest
  public void beforeTest() 
  {	 
	  System.setProperty("webdriver.chrome.driver", "G:/Drivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();	  
  }

  @AfterTest
  public void afterTest() 
  {
	  //driver.close();
  }

}
