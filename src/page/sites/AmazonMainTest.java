package page.sites;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.classes.DropDownPOF;
import page.classes.ItemPagePOF;
import page.classes.MainAmazonPOF;
import page.classes.SignInPOF;

public class AmazonMainTest {
	private WebDriver driver;
	private String amazonURL;
	private Actions builder;
	private WebDriverWait wait;
	JavascriptExecutor executor;
	MainAmazonPOF mainAmazonPOF;
	SignInPOF signInPOF;
	DropDownPOF dropDownPOF;
	ItemPagePOF itemPagePOF;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver",
				"/Users/Bahadori/Desktop/Mobile Automation Testing/JAR Files/geckodriver");
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		driver = new FirefoxDriver(caps);
		builder = new Actions(driver);
		wait = new WebDriverWait(driver, 5);
		caps.setBrowserName("firefox");
		caps.setPlatform(Platform.MAC);

		mainAmazonPOF = new MainAmazonPOF(driver);
		signInPOF = new SignInPOF(driver);
		dropDownPOF = new DropDownPOF(driver);
		itemPagePOF = new ItemPagePOF(driver);
		amazonURL = "https://www.amazon.com";
		
		driver.get(amazonURL);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void aMainLogin() throws InterruptedException {
		System.out.println("Reached mainLogin test");
//		mainAmazonPOF.clickSignIn();
//		System.out.println("Clicked on Sign In");
		
	}
	
	// @Test
	public void bSignIn() throws InterruptedException {
		signInPOF.setEmail("pbahadori156@gmail.com");
		System.out.println("Entered in email 'pbahadori156@gmail.com");
		signInPOF.setPassword("Pashas2cool!");
		System.out.println("Set the user's password");
		signInPOF.clickSignInSubmit();
		System.out.println("Clicked on the Sign In button");
		Thread.sleep(3000);
		System.out.println("Sign in Test Passed!");
	}
	
	@Test
	public void cSearchItem() {
		mainAmazonPOF.fillSearchBar("Saga Frontier");
		System.out.println("Entered in 'Saga Fronter' to search");
		mainAmazonPOF.clickSearch();
		System.out.println("Clicked on Search");
		dropDownPOF.clickResult1();
		System.out.println("Clicked on second results on search page");
	}
	
	@Test
	public void dAddItem() {
		itemPagePOF.ifClickQuantityTwo(driver);
		itemPagePOF.clickAddToCart();
	}
	
	// @Test
	public void mainLogin2() throws InterruptedException {
		System.out.println("Reached mainLogin test");
		WebElement signInButton = mainAmazonPOF.signInButtonObj(driver);
		WebElement accounts = mainAmazonPOF.accountObj(driver);
		
		/*
		executor = (JavascriptExecutor)driver;
		executor.executeScript("accounts.click();", accounts);
		*/
		//I'M TRYING TO CLICK ON ACCOUNTS UNDER THE SIGN IN MENU - I HAVE TO HOVER OVER SIGN IN TO GET TO ACCOUNTS
		
	
		builder = new Actions(driver);
		builder.moveToElement(signInButton).build().perform();
		System.out.println("Hovering over Sign In Menu");
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-link-accountList")));
		System.out.println("Waiting to locate the Accounts Element");
		accounts.click();
		System.out.println("Accounts clicked!");
	
		
//		signInPOF.setEmail("xsagakenx@aol.com");
//		signInPOF.clickContinue();
//		signInPOF.setPassword("Amirpasha156!");
//		signInPOF.clickSignInSubmit();
		Thread.sleep(3000);
		
	}

	// @AfterClass
	public void quitSuite() {
		driver.quit();
		System.out.println("Shutting down the Driver");
	}

}
