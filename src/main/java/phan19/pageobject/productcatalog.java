package phan19.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import phan19.AbstractComponennts.Abstract;

public class productcatalog extends Abstract {

	WebDriver driver;
	public  productcatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//lay dnah sach cacs san pham 
	@FindBy(css=".mb-3")
	List<WebElement> products;
	//
	@FindBy(css=".ng-animating")
	WebElement todisapear;
	//
	

	By productBy = By.cssSelector(".mb-3");
	By addtocart = By.xpath(".//div[@class='card-body']/button[2]");
	By toMessage = By.cssSelector("#toast-container");
	By cart = By.cssSelector("[routerlink*='/dashboard/cart']");
	
	//
	public List<WebElement> getProductList () {
//		waiForToAppear(productBy);
//		return products;
		 waiForToAppear(productBy);
		    System.out.println("Number of products found: " + products.size());
		    return products;
		
	}
	//lay san pham theo ten 
	public WebElement getProductByName(String nameProduct) {
		WebElement prod = products.stream().filter(product->

		product.findElement(By.xpath(".//div[@class='card-body']//b")).getText().equals(nameProduct)).findFirst().orElse(null);
		return prod;
	}
	//them gio hang 
	public void addToCart(String nameProduct) {
//		WebElement prod = getProductByName(nameProduct);
//		prod.findElement(addtocart).click();
//		waiForToAppear(toMessage);
//		
//		waiForDissapear(todisapear);
		WebElement prod = getProductByName(nameProduct);
	    if (prod != null) {
	        prod.findElement(addtocart).click();
	        waiForToAppear(toMessage);
	        waiForDissapear(todisapear);
	    } else {
	        System.out.println("Cannot add to cart, product not found: " + nameProduct);
	    }
	}
	
	
}
