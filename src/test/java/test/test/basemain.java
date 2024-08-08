package test.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import h.testComponents.baseTest;
import phan19.pageobject.ChecoutPage;
import phan19.pageobject.ConfimatinPage;
import phan19.pageobject.OrderPage;
import phan19.pageobject.cartPage;
import phan19.pageobject.page;
import phan19.pageobject.productcatalog;


public class basemain extends baseTest {

	String nameProduct="ZARA COAT 3";
		
		//khi them du lieu bang objiect 
//		public void submitOrder(String email, String pass,String nameProduct) throws IOException{
//		
//			
//			//page pagelan = lauchApplication();
//			//pagelan.goTo();
//			productcatalog productctl =pagelan.Login(email,pass);
//			
//			List<WebElement> products = productctl.getProductList();
//		
//			//them sp vo cart
//			
//			productctl.addToCart(nameProduct);
//			//xem gio hang 
//			
//			
//			//ktra gio hang du hang da them 
//			cartPage cartp = productctl.gotoCardpage();
//			Boolean match =  cartp.checkProductDispaly(nameProduct);
//			Assert.assertTrue(match);
//			//checkout
//			//
//			ChecoutPage checkout = cartp.gotocheckout();
//			checkout.selectCountry("India");
//			//
//			ConfimatinPage confirm = checkout.submitOrder();
//			String confirmMessage = confirm.veryftConfirm();
//			Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
//			
//		}
		//KHI THEM DU LIEU BANG HASHMAP
	@Test(dataProvider = "getData",groups = {"Purchase"})
	public void submitOrder(HashMap<String, String> input) throws IOException{
		
			
			//page pagelan = lauchApplication();
			//pagelan.goTo();
			productcatalog productctl =pagelan.Login(input.get("email"),input.get("pass"));
			
			List<WebElement> products = productctl.getProductList();
		
			//them sp vo cart
			
			productctl.addToCart(input.get("nameProduct"));
			//xem gio hang 
			
			
			//ktra gio hang du hang da them 
			cartPage cartp = productctl.gotoCardpage();
			Boolean match =  cartp.checkProductDispaly(input.get("nameProduct"));
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
	
		//ktra xme co bao nhieu don dat sp zaza coast 3
		@Test(dependsOnMethods = "submitOrder")
		public void historyOrder() {
			//
		productcatalog productctl =pagelan.Login("h@hoai.com","Thuhoai12@");
		OrderPage oderpage = productctl.gotoOrderPage();
		Assert.assertTrue(oderpage.checkOrderDispaly(nameProduct)); 
		}
		//them du lieu bang data
		@DataProvider
		public Object[][] getData() throws IOException {
			//ccahs 2 : them du liu bang hashmap
//			HashMap<String, String> map = new HashMap<String, String>();
//			map.put("email","h@hoai.com" );
//			map.put("pass","Thuhoai12@");
//			map.put("nameProduct","ZARA COAT 3" );
//			HashMap<String, String> map1 = new HashMap<String, String>();
//			map1.put("email","hoai@hoai.com" );
//			map1.put("pass", "Thuhoai12");
//			map1.put("nameProduct","ADIDAS ORIGINAL" );
//			return new Object[][] {{map},{map1}};
			
			
			//cah 1 : cho du liu vo 1 objetc vaf goij ra dungf owr ham submitOrder, chayj thu ban purcher.xml
			//return new Object[][] {{"h@hoai.com","Thuhoai12@","ZARA COAT 3"},{"hoai@hoai.com","Thuhoai12","ADIDAS ORIGINAL"}};
			
			//CACH 3 : THEM DU LIEU BANG CACH THEM DU LIEU JSON 
			 List<HashMap<String, String>> data = getJsondata(System.getProperty("user.dir") +"\\src\\test\\java\\test\\data\\purcharseOrder.json");
			
			return new Object[][] {{data.get(0)},{data.get(1)}};
		}
		
	

}
