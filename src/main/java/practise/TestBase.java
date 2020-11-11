package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestBase {
	
	
	public static WebDriver driver;
	private JavascriptExecutor js;
	
	
	
	
	@BeforeSuite
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
			
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		

	}

	@Test(priority=1)
	public void doLogin(){
		
		
		driver.findElement(By.id("Email1")).sendKeys("trainer@way2automation.com");
		driver.findElement(By.id("next")).click();
		
	}
	
	@Test(priority=2)
	public void composeEmail(){
		
		Assert.fail("Error in composing Email");
		
	}
	
	@AfterSuite
	public void tearDown(){
		
		driver.quit();
		
	}
}
