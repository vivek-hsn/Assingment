package assignment.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import assignment.pages.IphonePage;

public class iPhonePrice {
	
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
	public void checkPriceAmazon() throws InterruptedException{
		
		driver.get("https://www.amazon.in/");
		
		IphonePage pricePage = new IphonePage(driver);
		pricePage.searchIphone();
		pricePage.clickOnLink();
		pricePage.switchTab();
		double amazonPrice = pricePage.getPrice();
		driver.close();
		pricePage.switchTab();
		
		driver.get("https://www.flipkart.com/");
		pricePage.fkCloseLoginPopup();
		pricePage.fkSearchIphone();
		pricePage.fkClickOnItem();
		pricePage.switchTab();
		double fkprice = pricePage.fkItemPrice();
		
		if(amazonPrice < fkprice){
			System.out.println("Iphone Yellow 64GB is less in Amazon website and price is " +amazonPrice);
		}
		else{
			System.out.println("Iphone Yellow 64GB is less in FlipKart website and price is " +fkprice);
		}
		
		driver.quit();
		
	}

}
