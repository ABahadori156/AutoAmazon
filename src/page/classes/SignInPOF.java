package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPOF {
	WebDriver driver;
	public static WebElement element = null;
	
	@FindBy(id="ap_email")
	static
	WebElement emailField;
	
	@FindBy(id="continue")
	static
	WebElement continueButton;
	
	@FindBy(id="ap_password")
	static
	WebElement passwordField;
	
	@FindBy(id="signInSubmit")
	static
	WebElement signInButton;
	
	//Initializes POF - method has to be the same name as the public class SignInPOF
	public SignInPOF(WebDriver driver) {
		this.driver = driver;
		//Use of init method in Page Factory. This initElements will initiate all the above elements 
		//So all the elements above are initialized as objects ready to use
		PageFactory.initElements(driver, this);
	}
	
	
	
	//ELEMENT OBJECT CREATION
	public static WebElement emailAddressObj (WebDriver driver) {
		element = emailField;
		return element;
	}
	
	public static WebElement continueButtonObj (WebDriver driver) {
		element = continueButton;
		return element;
	}
	
	public static WebElement passwordObj (WebDriver driver) {
		element = passwordField;
		return element;
	}
	
	public static WebElement signInObj (WebDriver driver) {
		element = signInButton;
		return element;
	}
	
	
	
	// ACTION METHODS
	public void clickContinue() {
		continueButton.click();
	}
	
	public void clickSignInSubmit() {
		signInButton.click();
	}
	
	public void setEmail(String email) {
		emailField.clear();
		emailField.sendKeys(email);
	}
	
	public void setPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	
	
}
