package SeleniumPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Datadriven {
	
	WebDriver driver;
	@BeforeTest
	public void initialization()
	{
		System.setProperty("webdriver.chrome.driver", "G:/Drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://demosite.center/wordpress/wp-login.php");
	}
	@Test
	public void datadriven() throws Exception
	{
		File f = new File ("C:\\Users\\kiran\\workspace\\Automation\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(f); 
		
		//XSSFWorkbook wb = new XSSFWorkbook(fis);
	}
	

}
