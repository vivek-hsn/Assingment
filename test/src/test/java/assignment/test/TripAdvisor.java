package assignment.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TripAdvisor {
	
String driverPath = "E:\\Vikranth Frnd\\test\\src\\test\\resource\\drivers\\chromedriver.exe";
	
	WebDriver driver;
	 
	
	@BeforeTest
	public void setup(){
		 
		System.setProperty("webdriver.chrome.driver", driverPath);
	        
	    driver = new ChromeDriver();

	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();

	}
	
	@Test
	public void submitReview(){
		
	}

}
