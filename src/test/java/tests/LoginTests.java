package tests;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.*;

public class LoginTests extends BaseTest {
	
	@DataProvider(name = "verifyLogin")
    public Object[][] getVerifySearchCourseData(){
        Object[][] testData = ExcelUtility.getTestData("testLogin");
        return testData;
    }

    @BeforeClass
    public void setUp() {
    	ExcelUtility.setExcelFile(Constants.EXCEL_FILE, "LoginTests");
    }

  /*  @AfterMethod
    public void afterMethod() {
        System.out.println("****** After Method ******");
        if (nav.isUserLoggedIn()) {
            nav.logout();
            nav.login();
        }
    }*/



    @Test(dataProvider = "verifyLogin")
    public void testLogin(Hashtable<String, String> data) {
        nav = login.signInWith(data.get("uid"),data.get("password"));
       boolean result = nav.isUserLoggedIn();
        Assert.assertTrue(result);
    }

    @Test(enabled = false)
    public void testInvalidLogin() {
        nav = login.signInWith("santhosh271220@gmail.com", "thebest1227");
        boolean result = nav.isUserLoggedIn();
        Assert.assertFalse(result);
    }
}