package phan19.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import phan19.AbstractComponennts.Abstract;

public class ConfimatinPage extends Abstract{

	WebDriver driver;
	public ConfimatinPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//
	@FindBy(css = ".hero-primary")
	WebElement confirm;
	//
	public String veryftConfirm () {
		return confirm.getText();
		
		
	}
}
