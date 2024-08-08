package phan19.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import phan19.AbstractComponennts.Abstract;

public class page extends Abstract{

	WebDriver driver;
	public  page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	//FindBy la 1 annotation của Selenium để xác định cách tìm kiếm một phần tử web.
	//id="userEmail": Điều này chỉ định rằng Selenium sẽ tìm phần tử web dựa trên thuộc tính id với giá trị là userEmail.
	@FindBy(id="userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement userPassword;
	@FindBy(id="login")
	WebElement submit;
	//ktra tuong hop loogin that bai
	@FindBy(css=".toast-bottom-right.toast-container")
	WebElement erroMessage;
	//ham dang nhap 
	public productcatalog Login(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		productcatalog productctl = new productcatalog(driver);
		return productctl;
	}
	//mo duong dan 
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
		//driver.manage().window().maximize();
	}
	//lay thong bao khi login error
	public String getErrorMessage() {
		waiElementToAppear(erroMessage);
		return erroMessage.getText();
		
		
	}
	
}
