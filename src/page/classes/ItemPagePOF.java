package page.classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ItemPagePOF {
	WebDriver driver;
	public static WebElement element = null;
	String quantityStr = "quantity";
	
	@FindBy(id="add-to-cart-button")
	static
	WebElement addToCart;
	
	@FindBy(id="quantity")
	static
	WebElement quantity;
	
	public ItemPagePOF (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	//ELEMENT OBJECT CREATION
	public WebElement quantityObj (WebDriver driver) {
		element = quantity;
		return element;
	}

	//ACTION METHODS
	public void clickAddToCart() {
		addToCart.click();
	}
	
	public void ifClickQuantityTwo(WebDriver driver) {
		if (driver.findElements(By.id(quantityStr)).size() != 0) {
			Select sel = new Select(quantity);
			sel.selectByValue("2");
			System.out.println("Quantity Drop Down found, selecting 2 for the amount");
		} else {
			System.out.println("Quantity Drop Down NOT found");
		}
	}
	
	public void quantityOptions() {
		Select sel = new Select(quantity);
		List<WebElement> options = sel.getOptions();
		int numberOfOptions = options.size();
		
		for (int i=0; i<numberOfOptions; i++){
			// print out each option inside the select drop down
			String optionName = options.get(i).getText();
			System.out.println(optionName);
			}	
		}
	
	//HELPER METHODS
	
	
}