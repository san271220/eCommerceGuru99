package pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

import base.BasePage;

public class ShoppingCartPage extends BasePage {
	public WebDriver driver;
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	
	private String checkOut="css=>.checkout-types.top  button[title='Proceed to Checkout'] > span > span";
	//For Reorder
	
		private String qtyUpdate="css=>.product-cart-actions > input[name^='cart']";
		private String updateButton="css=>.product-cart-actions > button[name='update_cart_action'] > span > span";
		private String subTotal="css=>.product-cart-total  .price";
		private String grandTotal="css=>tfoot > tr > td:nth-of-type(2)  .price";
		private String Print="css=>.link-print";
	
	public OrdersPage checkoutClick()
	{
		elementClick(checkOut,"checkOut");
		return new OrdersPage(driver);
	}
	public boolean Reorder()
	{
		String subtotalValueBeforeUpdate=getText(subTotal,"getting subtotal");
		sendData(qtyUpdate,"2","sending qty value to update button");
		elementClick(updateButton,"updateButton");
		String subtotalValueAfterUpdate=getText(subTotal,"getting subtotal");
		String qtyValue=getText(qtyUpdate,"getting qtyValue");
		String grandTotalValue=getText(grandTotal,"getting grandTotalValue");
		boolean ouput=false;
		if(grandTotalValue.equalsIgnoreCase(subtotalValueAfterUpdate))
		{
			ouput=true;
		}
	return ouput;
	}
	  
}

