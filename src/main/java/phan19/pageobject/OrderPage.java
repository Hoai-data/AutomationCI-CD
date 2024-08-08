package phan19.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import phan19.AbstractComponennts.Abstract;

public class OrderPage extends Abstract{

	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//
	@FindBy(xpath ="//td[text()='ZARA COAT 3']")
	List<WebElement> productnames;
	//
	
	//ktrra xme gio han co du sp da thm chua
		public Boolean checkOrderDispaly(String nameProduct) {
			Boolean match =  productnames.stream().anyMatch(cart-> cart.getText().equalsIgnoreCase(nameProduct));
			return match;
		}
	
		
}
