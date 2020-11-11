package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.sikuli.script.FindFailed;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

import base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class OrdersPage extends BasePage{
	public WebDriver driver;
	
	private String billingRegion= "css=>select#billing:region_id";
	private String billingContinue="css=>div#billing-buttons-container > button > span > span";
	private String shippingContinue="css=>div#shipping-method-buttons-container > .button";
	private String checkMoneyOrder="css=>input#p_method_checkmo";
	private String paymentContinue="css=>div#payment-buttons-container > button > span > span";
	private String placeOrder="css=>div#review-buttons-container > button > span > span";
	private String OrderID="css=>.col-main > p:nth-of-type(1) > a";
	private String orderIDValue;
	private String MyOrders="css=>.col2-left-layout.main-container ul > li:nth-of-type(4) > a";
	private String ReorderLink="css=>.first.odd .link-reorder";
	

	
	private String printButton="xpath=>//*[@id='sidebar']//print-preview-button-strip//div/cr-button[1]";
	

	//Order details
	private String PendingValue="css=>.first.odd  em";
	private String ViewOrders="css=>.first.odd > .a-center.last.view > .nobr > a:nth-of-type(1)";
	private String orderIdOrders="css=>.first.odd > .number";

	
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	
	public ShoppingCartPage ClickReorder() throws InterruptedException, ParseException
	{
		elementClick(MyOrders,"MyOrders");
		elementClick(ReorderLink,"ReorderLink");
	return new ShoppingCartPage(driver);
	}

	public boolean orderProductWishlist() throws InterruptedException
	{

		elementClick(billingContinue,"billingContinue");
	 driver.switchTo().frame("flow_close_btn_iframe");
		 elementClick("css=>div#closeBtn","x button");
		 driver.switchTo().parentFrame();
		waitForElement(shippingContinue,20);
		elementClick(shippingContinue,"shippingContinue");
		waitForElement(checkMoneyOrder,20);
		elementClick(checkMoneyOrder,"checkMoneyOrder");
		elementClick(paymentContinue,"paymentContinue");
		elementClick(placeOrder,"placeOrder");
		Thread.sleep(2000);
		orderIDValue=getText(OrderID,"OrderID");
		if(orderIDValue!=null)
		{
			return true;
		}
		return false;
	}
	public void viewOrders() throws IOException, InterruptedException, AWTException, FindFailed
	{
	  String pending=getText(PendingValue,"PendingValue");
	  String orderIdOrdersValue=getText(orderIdOrders,"orderIdOrders");
	  elementClick(ViewOrders,"ViewOrders");
	}
	
	
	public void orderPdfDownload() throws IOException, InterruptedException, AWTException, FindFailed
	{
		elementClick(printButton,"Print");
		  Thread.sleep(10000);
		  Screen s = new Screen();
		Pattern image = new Pattern("D:\\Users\\asanth\\Pictures\\Sikulli\\saveDropdown.PNG");
		s.wait(image, 10);	
		s.click(image);	
		Pattern image1 = new Pattern("D:\\Users\\asanth\\Pictures\\Sikulli\\saveAsPDF.PNG");	
	    s.wait(image1, 10);	
		s.click(image1);
		Pattern image2 = new Pattern("D:\\Users\\asanth\\Pictures\\Sikulli\\save2.PNG");
	s.wait(image2, 10);	
		s.click(image2);	
		Pattern image3 = new Pattern("D:\\Users\\asanth\\Pictures\\Sikulli\\SaveFinal2.PNG");
		s.wait(image3, 10);		
			s.click(image3);
			s.click(image3);
			Assert.assertTrue(true);
			Thread.sleep(1000);
		}	 
	
}
