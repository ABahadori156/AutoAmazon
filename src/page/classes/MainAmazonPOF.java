package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainAmazonPOF {
	WebDriver driver;
	public static WebElement element = null;
	
	
	@FindBy(id="twotabsearchtextbox")
	static
	WebElement searchBar;
	
	@FindBy(id="nav-link-accountList")
	static
	WebElement signInButton;
	
	@FindBy(id="nav-al-your-account")
	static
	WebElement account;
	
	@FindBy(xpath=".//div[@id='nav-search']/form/div[2]/div/input")
	static
	WebElement searchIcon;
	
	public MainAmazonPOF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//ELEMENT OBJECT CREATION
	public static WebElement searchBarObj (WebDriver driver) {
		element = searchBar;
		return element;
	}
	
	public static WebElement signInButtonObj (WebDriver driver) {
		element = signInButton;
		return element;
	}
	
	public static WebElement accountObj (WebDriver driver) {
		element = account;
		return element;
	}
	
	
	//ACTION METHODS
	public void fillSearchBar(String search) {
		searchBar.sendKeys(search + "\n");
	}
	
	public void clickSearch() {
		searchIcon.click();
	}
	
	public void clickSignIn() {
		signInButton.click();
	}
	
	

	
}
