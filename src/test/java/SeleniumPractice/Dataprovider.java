package SeleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {
	
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
	
	@Test(dataProvider="wordpressdata")
	public void wordpresslogin(String username, String password)
	{
		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.id("wp-submit")).click();
		WebElement Errormsg=driver.findElement(By.id("login_error"));	
		System.out.println("THe Error messages are "+Errormsg.getText());
	}
	

	@DataProvider(name = "wordpressdata")
	public Object[][] passdata()
	{
		Object[][] data =new Object[3][2];
		data[0][0]="demo1";
		data[0][1]="demo1";
		data[1][0]="demo2";
		data[1][1]="demo2";
		data[2][0]="demo3";
		data[2][1]="demo3";		
		return data;
	}
}
