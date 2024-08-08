package h.testComponents;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v125.network.model.SubresourceWebBundleInnerResponseError;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import phan19.pageobject.page;

public class baseTest {
	public WebDriver driver;

	public Properties prop;
	public page pagelan;
	
	public WebDriver initializeDriver() throws IOException {
		//propreties class
		
		 prop = new Properties();
		//tu dong lay duong dan 
		String file = (System.getProperty("user.dir")+"\\src\\main\\java\\phan20\\resources\\GlobalData.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		String browserName =  System.getProperty("browser") != null ? System.getProperty("browser") :prop.getProperty("browser");
		
		//String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		//String browserName =  prop.getProperty("browser");
		//
		 if(browserName.contains("chrome")) 
		//if(browserName.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			
			
			driver = new ChromeDriver(options);
			//full screen
			driver.manage().window().setSize(new Dimension(1440, 900));
			
		}//else if(browserName.equalsIgnoreCase("chrome"))
			else if (browserName.equalsIgnoreCase("firefox")){
			//firefox
				  WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			
		}//else if(browserName.equalsIgnoreCase("edge"))
			 else if (browserName.contains("edge")) {
			//edge
			//System.setProperty("webdriver.edge.driver", "edge.exe");
			 driver = new EdgeDriver();
		}
//		   if (driver == null) {
//	            initializeDriver();
//	        }
		 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		return driver;
		
	}
	//phuong thuc de lay du lieu json 
	public List<HashMap<String, String>> getJsondata(String filePath) throws IOException {
		//lay du lieu tu tep purcherOrder de gan vo 
		
		String jsonContendv =  FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
	//Kết quả là data sẽ là một danh sách chứa các HashMap, trong đó mỗi HashMap chứa các cặp khóa-giá trị kiểu String.
		ObjectMapper mapper =  new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContendv, new TypeReference<List<HashMap<String, String>>>() {
		});
	//
		return data;
	}
	//
	//groups = {"error"}
	@BeforeMethod(alwaysRun = true)
	public page lauchApplication() throws IOException {
		driver = initializeDriver();
		 pagelan = new page(driver);
		//goi ham mo duong dan 
		pagelan.goTo();
		return pagelan;
	}
//	@AfterMethod
//
//	public void tearDown() {
//		driver.close();
//	}
	
	// Chup anh ma hinh 
		public String getScreenshot(String testcaseName,WebDriver driver) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File  file = new File(System.getProperty("user.dir")+ "//reports//" + testcaseName+".pgn");
			FileUtils.copyFile(source, file);
			return System.getProperty("user.dir") +"//reports//" + testcaseName +".pgn";
			
		}
}
