package h.stepDefinitions;
//de su dung cucumber, 
//theem co pon: cucumber-java ; cucumber-testng
//vo help->clipse market ->h=gox cucumber->nhaans instal 
//tao file cucumber

import java.io.IOException;
import java.util.List;

//import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import h.testComponents.baseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import phan19.pageobject.ChecoutPage;
import phan19.pageobject.ConfimatinPage;
import phan19.pageobject.cartPage;
import phan19.pageobject.page;
import phan19.pageobject.productcatalog;

public class StepDefinitionlmpl extends baseTest {
	//khai bao page
	public page landingPage;
	productcatalog productctl;
	ConfimatinPage confirm;
	
	
	@Given("I landed on ecomerce page")
	public void I_landed_on_ecomerce_page() throws IOException {
		//CODE
		//mo trinh duet: goi method lauchApplication trong class baseTest thuc thi 
		//vi ham do tra ve 1 trang nen phai goi trang ra
		landingPage =  lauchApplication();
	}
	//login
	//dat (.+) co nghia la : dat bat ki ki tu nao no khong quan tam 
	@Given("^Login in with username (.+) and password (.+)$")
	public void login_in_with_username_and_password(String username, String password) {
		 productctl =pagelan.Login(username,password);
		
		
	}
	//them sp
	@When("^I add products (.+) from cart$")
	public void i_add_products_from_cart(String productName) throws InterruptedException{
		List<WebElement> products = productctl.getProductList();
		
		//them sp vo cart
		productctl.addToCart(productName);
	}
	//chckout
	@When("^Checkout(.+) and submit the order$")
	public void checkout_and_submit_the_order(String productName) {
		//ktra gio hang du hang da them 
		cartPage cartp = productctl.gotoCardpage();
		Boolean match =  cartp.checkProductDispaly(productName);
		//Assert.assertTrue(match);
		//checkout
		//
		ChecoutPage checkout = cartp.gotocheckout();
		checkout.selectCountry("india");
		//
		 confirm = checkout.submitOrder();
	}
	//xac nhan kq
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_ConfirmationPage(String string) throws InterruptedException {
		
		String confirmMessage = confirm.veryftConfirm();
		//Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		 // Assert.assertEquals(confirmMessage, string, "Thông báo xác nhận không khớp!");
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		//driver.close();
		
	}
	@Then("^\"([^\"]*)\" message is displayed$")
	public void message_is_displayed(String string) throws Throwable {
		Assert.assertEquals(string, landingPage.getErrorMessage());
	}
	

}
