package pages;

import org.openqa.selenium.WebDriver;

import base.BasePage;

public class TvPage extends BasePage{

	public WebDriver driver;
	private String lgLCDWishList= "css=>li:nth-of-type(1) > .product-info  .add-to-links  .link-wishlist";
	
	public TvPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
	}
	
	
	
	public WishListPage addToWishList(){
	  elementClick(lgLCDWishList,"lgLCD product click");
	  return new WishListPage(driver);
	}


}
