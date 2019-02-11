package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDownPOF {
	WebDriver driver;
	public static WebElement element = null;
	
	@FindBy(xpath=".//li[@id='result_1']/div/div/div/div[2]/div[1]/div[1]/a/h2")
	static
	WebElement result1;
	
	@FindBy(id="result_2")
	static
	WebElement result2;

	public DropDownPOF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	//ACTION METHODS
	public void clickResult1(){
		result1.click();
	}
	
	public void clickResult2() {
		result2.click();
	}
	
}
