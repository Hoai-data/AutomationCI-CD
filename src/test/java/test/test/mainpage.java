package test.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import phan19.pageobject.ChecoutPage;
import phan19.pageobject.ConfimatinPage;
import phan19.pageobject.cartPage;
import phan19.pageobject.page;
import phan19.pageobject.productcatalog;

public class mainpage {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//khoi tao trang page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		page pagelan = new page(driver);
		//goi ham mo duong dan 
		pagelan.goTo();
		//
		
		// goi ham login de chay 
	
		//pagelan.Login("h@hoai.com","Thuhoai12@");
		//lay san pham ra 
		productcatalog productctl =pagelan.Login("h@hoai.com","Thuhoai12@");
		List<WebElement> products = productctl.getProductList();
		//them sp vo cart
		String nameProduct="ZARA COAT 3";
		productctl.addToCart(nameProduct);
		//xem gio hang 
		
		
		//ktra gio hang du hang da them 
		cartPage cartp = productctl.gotoCardpage();
		Boolean match =  cartp.checkProductDispaly(nameProduct);
		Assert.assertTrue(match);
		//checkout
		//
		ChecoutPage checkout = cartp.gotocheckout();
		checkout.selectCountry("India");
		//
		ConfimatinPage confirm = checkout.submitOrder();
		String confirmMessage = confirm.veryftConfirm();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		
	
	}

}
