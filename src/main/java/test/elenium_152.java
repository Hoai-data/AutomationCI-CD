package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class elenium_152 {

	public static void main(String[] args) {
		// TODO Auto-generated method stube
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//mo trang 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		//login
		driver.findElement(By.id("userEmail")).sendKeys("h@hoai.com");
		driver.findElement(By.id("userPassword")).sendKeys("Thuhoai12@");
		driver.findElement(By.id("login")).click();
		//lay dnah sach sp  
		// tìm tất cả các phần tử trên trang web có class là .md-3 và lưu chúng vào danh sách products.
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class, 'mb-3')]"));
		//
		// sử dụng stream() để duyệt qua danh sách products. Đối với mỗi sản phẩm, nó tìm một phần tử con có thẻ <b> và so sánh văn bản của nó với "ZARA COAT 3".
		//Nếu tìm thấy sản phẩm phù hợp, nó sẽ chọn sản phẩm đầu tiên và lưu vào biến prod
		List<WebElement> a = (driver.findElements(By.cssSelector("b")));
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i).getText());
		}
	


		
		//Nếu biến prod không phải là null, đoạn mã tìm một nút trong phần tử prod (nút này có thể là một trong nhiều nút trong .card-body) và
		//nhấp vào nút đó. :last-of-type chọn nút cuối cùng trong số các nút.
		String nameProduct="ZARA COAT 3";
		WebElement prod = products.stream().filter(product->

		product.findElement(By.xpath(".//div[@class='card-body']//b")).getText().equals(nameProduct)).findFirst().orElse(null);

		prod.findElement(By.xpath(".//div[@class='card-body']/button[2]")).click();
		
		//doi cho thong ban succec xuat hien khi them hang vo gio  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		// cho bien mat 
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		//xem chi tiet chi tiet gioi hang  
		driver.findElement(By.cssSelector("[routerlink*='/dashboard/cart']")).click();
		//xem gio hang co du hang minh da them ko
		List<WebElement> carts =  driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match =  carts.stream().anyMatch(cart-> cart.getText().equalsIgnoreCase(nameProduct));
		Assert.assertTrue(match);
		//bam checkout
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		//chon quoc gia 
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		driver.findElement(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted'][2]")).click();
		//chon hoan thanh 
		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		//xac nhan lai thong bap  
		
		String message =  (driver.findElement(By.cssSelector(".hero-primary")).getText()); 
		
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
	
	}

}
