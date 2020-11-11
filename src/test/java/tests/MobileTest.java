package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.MobilePage;
import utilities.Util;

public class MobileTest extends BaseTest {
	
	
	

    @BeforeClass
    public void setUp() {
        nav = login.signInWith("santhosh271220@gmail.com", "thebest1227");
    }
    
   

    @Test
    public void verifyMobileNameOrder() {
          mob=nav.mobileLink(); 
         List<String>mobileName=mob.mobiledd();
         Boolean result=Util.isListAscendingOrder(mobileName);
         Assert.assertTrue(result);
    }
    
    @Test
    public void verifyMobilePrice() {
          mob=nav.mobileLink(); 
         Boolean result=mob.mobilePrice();
         Assert.assertTrue(result, "mobile price did not match");
          
  
    }
    
    @Test
    public void verifyQtyErrorMessage() {
          mob=nav.mobileLink(); 
         Boolean result=mob.qtyErrorMessageCheck();
         Assert.assertTrue(result, "mobile price did not match");
          
  
    }
    
    @Test
    public void compareMobile() {
          mob=nav.mobileLink(); 
        boolean result=mob.mobileAddToCompare();
        Assert.assertTrue(result, "Mobile comparison not working fine");

  
    }

/*    @Test
    public void filterByCategory() {

    }*/

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}


