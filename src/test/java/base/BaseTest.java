package base;
import pages.*;
import utilities.Constants;
import utilities.ExcelUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    protected String baseURL;
    protected LoginPage login;
    protected NavigationPage nav;
    protected MobilePage mob;
    protected WishListPage wish;
    protected TvPage tv;
    protected OrdersPage order;
    protected ShoppingCartPage shop;
    /*protected SearchBarPage search;
    protected ResultsPage result;
    protected CategoryFilterPage category;*/
    

    @BeforeClass()

    @Parameters({"browser"})
    public void commonSetUp(String browser) {
    //	System. setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
    	
        driver = WebDriverFactory.getInstance().getDriver(browser);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        baseURL = "http://live.demoguru99.com/index.php/";
        
        driver.get(baseURL);
        driver.manage().window().maximize();
        nav = new NavigationPage(driver);
        login = nav.login();
    }

    @AfterClass
    public void commonTearDown() {
        driver.quit();
    }
}
