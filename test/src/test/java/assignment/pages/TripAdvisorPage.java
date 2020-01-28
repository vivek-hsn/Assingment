package assignment.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripAdvisorPage {
	
	WebDriver driver;

	@FindBy(xpath = "//input[@type='search' and @title='Search']")
	WebElement searchBox;

	@FindBy(xpath = "//button[@type='submit' and @title='Search']")
	WebElement searchBtn;
	
	@FindBy(xpath = "(//div[@class='result-title']/span)[1]")
	WebElement firstResult;
	
	
	
	public TripAdvisorPage(WebDriver driver) {
		this.driver = driver;

		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}
	
	public void search() throws InterruptedException{
		
		searchBox.click();
		Thread.sleep(2000);
		searchBox.sendKeys("Club Mahindra");
		Thread.sleep(1000);
		searchBtn.click();
		Thread.sleep(2000);
		
	}
	
	public void clickOnFirstLink() throws InterruptedException{
		firstResult.click();
		Thread.sleep(2000);
		
	}
	
	public void switchTab() {
		// Set<String> windows = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
	}
	
	

}
