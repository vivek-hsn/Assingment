package assignment.pages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IphonePage {

	WebDriver driver;

	@FindBy(xpath = "//div/input[@id='twotabsearchtextbox']")
	WebElement searchBox;

	@FindBy(xpath = "//div/input[@type='submit']")
	WebElement searchBtn;

	@FindBy(xpath = "//div[@class='sg-row']//following::a/span[contains(text(),'iPhone XR (64GB) - Yellow')]")
	WebElement iphonelink;

	@FindBy(xpath = "//tr[td[text()='Price:']]//following-sibling::span[@id='priceblock_ourprice']")
	WebElement iphonePrice;

	// Flipkart elements
	@FindBy(xpath = "//div[@class='_3Njdz7']/button")
	WebElement flipkatCloseBtn;

	@FindBy(xpath = "//input[@title='Search for products, brands and more']")
	WebElement flipkartSearchBox;

	@FindBy(xpath = "//input[@title='Search for products, brands and more']//following::button")
	WebElement flipkartSearchBtn;

	@FindBy(xpath = "//div[text()='Apple iPhone XR (Yellow, 64 GB)']")
	WebElement fkItemName;
	
	@FindBy(xpath = "//span[text()='Apple iPhone XR (Yellow, 64 GB)']//following::div[contains(text(),'₹')][1]")
	WebElement fkItemPrice;
	
	

	public IphonePage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	public void searchIphone() throws InterruptedException {
		searchBox.clear();
		searchBox.sendKeys("iPhone XR (64GB) - Yellow");
		Thread.sleep(2000);
		searchBtn.click();
		Thread.sleep(3000);
	}

	public void clickOnLink() throws InterruptedException {

		iphonelink.click();
		Thread.sleep(3000);
	}

	public double getPrice() {
		String price = iphonePrice.getText();
		double totalPrice = Double.parseDouble(price.replaceAll("[^0-9\\.]+", ""));
		System.out.println(totalPrice);
		return totalPrice;
	}

	public void switchTab() {
		// Set<String> windows = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
	}

	public void fkCloseLoginPopup() throws InterruptedException {
		flipkatCloseBtn.click();
		Thread.sleep(2000);
	}

	public void fkSearchIphone() throws InterruptedException {
		flipkartSearchBox.clear();
		flipkartSearchBox.sendKeys("iPhone XR (64GB) - Yellow");
		Thread.sleep(2000);
		flipkartSearchBtn.click();
		Thread.sleep(3000);
	}

	public void fkClickOnItem() throws InterruptedException {

		fkItemName.click();
		Thread.sleep(3000);
	}
	
	public double fkItemPrice() {
		String price = fkItemPrice.getText();
		double totalPrice = Double.parseDouble(price.replaceAll("[^0-9]+", ""));
		System.out.println(totalPrice);
		return totalPrice;
	}

}