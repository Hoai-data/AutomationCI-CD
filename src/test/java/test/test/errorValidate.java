package test.test;

import org.testng.annotations.Test;



import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;



import h.testComponents.baseTest;
import phan19.pageobject.ChecoutPage;
import phan19.pageobject.ConfimatinPage;
import phan19.pageobject.cartPage;
import phan19.pageobject.page;
import phan19.pageobject.productcatalog;
import h.testComponents.retry;
public class errorValidate extends baseTest {


		@Test(groups = {"error"},retryAnalyzer = retry.class)
		public void loginerrorValidation() throws IOException{
		
			String nameProduct="ZARA COAT 3";
			
			productcatalog productctl =pagelan.Login("h@hoai.com","Thuhoai12@1");
			//co tinh de that bai khi xoa or de chup hinh canh bao 
			Assert.assertEquals("Incorrect email or password.", pagelan.getErrorMessage());
			
		}
		@Test
		public void productValidation() throws IOException{
		
			
			//page pagelan = lauchApplication();
			//pagelan.goTo();
			productcatalog productctl =pagelan.Login("h@hoai.com","Thuhoai12@");
			List<WebElement> products = productctl.getProductList();
		
			//them sp vo cart
			String nameProduct="ZARA COAT 3";
			productctl.addToCart(nameProduct);
			//xem gio hang 
			
			
			//ktra gio hang du hang da them 
			cartPage cartp = productctl.gotoCardpage();
			Boolean match =  cartp.checkProductDispaly("ZARA COAT 333");
			Assert.assertFalse(match);
			//checkout
			//
//			ChecoutPage checkout = cartp.gotocheckout();
//			checkout.selectCountry("India");
//			//
//			ConfimatinPage confirm = checkout.submitOrder();
//			String confirmMessage = confirm.veryftConfirm();
//			Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
//			
		}
	

}
