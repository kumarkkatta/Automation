package SeleniumPractice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Switchwindow2 
{
	WebDriver driver;	
	
	@BeforeTest
	public void initializingBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "G:/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().to("http://www.goibibo.com");
		System.out.println(driver.getTitle());
	}
	
	@Test(enabled=true, description="Multiple tabs handling")
	public void windowhandling() throws Exception
	{
		String parentwindow = driver.getWindowHandle();
		Set<String> windows= driver.getWindowHandles();
		WebElement flight= driver.findElement(By.xpath("//*[@href='/flights/']"));
		flight.click();
		
		WebElement cab= driver.findElement(By.xpath("//*[@href='/cars/']"));
		cab.click();
		Thread.sleep(5000);
		//System.out.println(driver.getTitle());
		WebElement hotel= driver.findElement(By.xpath("//*[@href='/hotels/']"));
		hotel.click();
		Thread.sleep(5000);
		//System.out.println(driver.getTitle());
		WebElement trains= driver.findElement(By.xpath("//*[@href='/trains/']"));
		trains.click();
		Thread.sleep(5000);
		//System.out.println(driver.getTitle());
		
		System.out.println("No of windows"+windows.size());
		
		
		
		SwitchtoWindow switchwindow = new SwitchtoWindow(driver);
		switchwindow.toTitle("Flight Tickets, Flights Booking at Lowest Airfare, Book Air Tickets-Goibibo");System.out.println(driver.getTitle());
		switchwindow.toTitle("Online Hotel Booking | Book Cheap, Budget and Luxury Hotels -Goibibo");System.out.println(driver.getTitle());
		switchwindow.toTitle("IRCTC Train Ticket Booking, Book Train Tickets, Indian Railways Train Enquiry & Reservation");System.out.println(driver.getTitle());
		switchwindow.toTitle("Cab Booking - Outstation cabs, Car Rental, Taxi & Cars Booking");System.out.println(driver.getTitle());
		
		
		
		driver.switchTo().window(parentwindow);
		System.out.println("Parent window title "+driver.getTitle());
		
		
		
		
	}
	
	
	@AfterTest(enabled=false)
	public void teardown()
	{
		driver.close();
	}

}
