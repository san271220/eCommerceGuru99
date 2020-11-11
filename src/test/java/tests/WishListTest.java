package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.Util;

public class WishListTest extends BaseTest {
	 @BeforeClass
	    public void setUp() {
	        nav = login.signInWith("santhosh271220@gmail.com", "thebest1227");
	    }
	    
	   

	    @Test
	    public void verifyMobileNameOrder() {
	          tv=nav.ClickTvLink(); 
	          wish=tv.addToWishList();
	          boolean result=wish.shareWishlist();
	          Assert.assertTrue(result, "shareWishListFailed");
	       
	    }
	    
	    @AfterClass
	    public void tearDown() {
	        //driver.quit();
	    }
}
