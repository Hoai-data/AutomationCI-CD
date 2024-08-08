package phan19.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import phan19.AbstractComponennts.Abstract;

public class cartPage extends Abstract{

	WebDriver driver;
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//
	@FindBy(css=".cartSection h3")
	List<WebElement> cartTilte;
	//
	@FindBy(xpath ="//button[text()='Checkout']")
	WebElement checkout;
	//ktrra xme gio han co du sp da thm chua
		public Boolean checkProductDispaly(String nameProduct) {
			Boolean match =  cartTilte.stream().anyMatch(cart-> cart.getText().equalsIgnoreCase(nameProduct));
			return match;
		}
	//bam check out
		public ChecoutPage gotocheckout() {
			checkout.click();
			return new ChecoutPage(driver);

		}
		
}
