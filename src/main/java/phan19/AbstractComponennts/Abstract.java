package phan19.AbstractComponennts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import phan19.pageobject.OrderPage;
import phan19.pageobject.cartPage;

public class Abstract {

	WebDriver driver;
	public Abstract(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//
	@FindBy(css="[routerlink*='/dashboard/cart']")
	WebElement cartHead;
	//
	@FindBy(css="[routerlink*='/dashboard/myorders']")
	WebElement orderHead;
	//
	
	

	public void waiForToAppear(By findby) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
		
	}
	public void waiElementToAppear(WebElement findby) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findby));
		
	}
	public void waiForDissapear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	//toi trang gio hang 
	public cartPage gotoCardpage() {
//		cartHead.click();
//		cartPage cartp = new cartPage(driver);
//		return cartp;
		if (cartHead != null && cartHead.isDisplayed()) {
	        cartHead.click();
	    } else {
	        System.out.println("Cart head element is not initialized or not displayed.");
	    }
	    return new cartPage(driver);
		
	}
	public OrderPage gotoOrderPage() {
		orderHead.click();
		OrderPage order = new OrderPage(driver);
		return order;
		
	}
	
	
}
