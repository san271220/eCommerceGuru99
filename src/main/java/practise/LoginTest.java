package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	private String loginLink=".//ul[@class='nav navbar-nav navbar-right']//a[@href='/sign_in']";
	private String Email=".//input[@id='user_email']";
	private String password=".//input[@id='user_password']";
	private String loginButton=".//input[@type='submit']";

	public static void sendData(WebDriver driver,String xpathValue,int timeout,String value)
	{
	WebElement textBox=driver.findElement(By.xpath(xpathValue));
	new WebDriverWait(driver,timeout).
	until(ExpectedConditions.visibilityOf(textBox));
	textBox.sendKeys(value);
	}
	
	public static void elementClick(WebDriver driver,String xpathValue,int timeout)
	{
	WebElement element=driver.findElement(By.xpath(xpathValue));
	new WebDriverWait(driver,timeout).
	until(ExpectedConditions.elementToBeClickable(element));
    element.click();
	}
	
	@Test
	 public void testLogin()
	{
		System. setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
	      driver = new ChromeDriver();
	      driver.get("https://letskodeit.teachable.com/");
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      elementClick(driver,loginLink,5);
	      sendData(driver,Email,5,"san271220@gmail.com");
	      sendData(driver,password,5,"san271220@gmail.com");
	      elementClick(driver,loginButton,5);
	      
	}
	
	
	
}
