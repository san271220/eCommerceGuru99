package pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import base.BasePage;

import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import utilities.*;

public class NavigationPage extends BasePage {

	 private String Account = "xpath=>//*[@id='header']/div/div[2]/div/a/span[2]";
	 private String Login = "xpath=>//*[@id='header-account']/div/ul/li[6]/a";
	    public WebDriver driver;
	    private JavascriptExecutor js;
	    private String User_ID = "xpath=>//*[@id='top']/body/div/div/div[1]/div/p";
	    private String mobile_Link= "xpath=>//*[@id='nav']/ol/li[1]/a";
	    private String TvLink= "css=>.last.level0.nav-2 > .level0";
	    private String wishList= "css=>a[title^='My Wishlist']";
	    private String MyAccount="css=>div#header-account  ul  a[title='My Account']";
	    private String ReorderLink="css=>.first.odd .link-reorder";
	    private String MyOrders="css=>.col2-left-layout.main-container ul > li:nth-of-type(4) > a";
	    
    public NavigationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }
    @BeforeClass
    public void setUp() {
    	ExcelUtility.setExcelFile(Constants.EXCEL_FILE, "LoginTests");
    }
    
	@DataProvider(name = "verifyLogin")
    public Object[][] getVerifySearchCourseData(){
        Object[][] testData = ExcelUtility.getTestData("testLogin");
        return testData;
    }
    /***
     * Variables
     * URL
     * Title
     */


    /***
     * Methods
     */

    public MobilePage mobileLink() {
    	elementClick(mobile_Link, "Mobile Button");
    	return new MobilePage(driver);
    }
    public OrdersPage orderLink() {
    	elementClick(MyOrders, "Order Link");
    	return new OrdersPage(driver);
    }
    public ShoppingCartPage ReorderLink() {
    	elementClick(mobile_Link, "Mobile Button");
    	return new ShoppingCartPage(driver);
    }
    
    public TvPage ClickTvLink() {
    	elementClick(TvLink, "TV Button");
    	return new TvPage(driver);
    }
    
    public OrdersPage wishListLink() {
    	elementClick(Account, "Account Button");
    	elementClick(wishList, "wishList Button");
    	return new OrdersPage(driver);
    }
    public void myAccountLink() {
    	elementClick(Account, "Account Button");
    	elementClick(MyAccount, "MyAccount");
    }
    public void myCourses() {
        
    }

    public boolean isUserLoggedIn() {
        try {
            //List<WebElement> accountImage = getElementList(Manager_ID, "Manager ID");
        	        
            String expectedText=getText(User_ID, "User ID text");
           Boolean result=Util.verifyTextMatch("WELCOME, SANTHOSH A!",expectedText);
            if (result) {
  
                return true;
            } else {
                return false;
            }
        
        } catch (Exception e) {
            return false;
        }
      
    }

    public LoginPage login() {
    	//base.verifyTitle("Home");
    	boolean result=verifyTitle("Home page");
    	Assert.assertTrue(result);
    	elementClick(Account, "Account Button");
    	elementClick(Login, "Login");
        return new LoginPage(driver);
    }

    public void logout() {
        //elementClick(Manager_ID, "Manager_ID");
        
    }
}
