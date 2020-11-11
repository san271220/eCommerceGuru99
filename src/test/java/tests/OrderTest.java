package tests;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.OrdersPage;

public class OrderTest extends BaseTest {
	@BeforeClass
    public void setUp() {
        nav = login.signInWith("santhosh271220@gmail.com", "thebest1227");
    }
	
	  @Test(enabled=false)
	    public void verifyOrder() throws InterruptedException {
		      tv=nav.ClickTvLink(); 
              wish=tv.addToWishList();
              shop=wish.AddtoCart();
	          order=shop.checkoutClick();
	          boolean result=order.orderProductWishlist();
	          Assert.assertTrue(result, "shareWishListFailed");
	       
	    }
	  
	  @Test(enabled=false)
	    public void verifyOrderPDF() throws InterruptedException, IOException, AWTException, FindFailed {
		      order=nav.orderLink();
		      order.viewOrders();
		      order.orderPdfDownload();
	    }
	  
	  @Test(enabled=true)
	    public void verifyReorder() throws InterruptedException, IOException, AWTException, FindFailed, ParseException {
              nav.myAccountLink();
		      order=nav.orderLink();
		      shop=order.ClickReorder();
		      boolean result=shop.Reorder();
		      Assert.assertTrue(result);
		      order=shop.checkoutClick();
		      boolean result2=order.orderProductWishlist();
		      Assert.assertTrue(result2);
	    }
	  

	
	  
	  @AfterClass
	    public void tearDown() {
	        //driver.quit();
	    }
}
