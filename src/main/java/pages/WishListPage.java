package pages;

import org.openqa.selenium.WebDriver;

import base.BasePage;

public class WishListPage extends BasePage{

	public WebDriver driver;
	public WishListPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	private String lgLCDWishList= "css=>li:nth-of-type(1) > .product-info  .add-to-links  .link-wishlist";
	private String goToWishList="css=>.block.block-wishlist > .block-content > .actions > a";
	private String shareWishlistInitial="css=>button[name='save_and_share'] > span > span";
	private String inputBox="css=>.input-box>textarea[name='emails']";
	private String shareWishlistFinal="css=>button[title='Share Wishlist'] > span > span";
	private String wishlistShareCheck="css=>ul  span";
	private String addToCart="css=>button[title='Add to Cart'] > span > span";
	
	public boolean shareWishlist()
	{
	  elementClick(shareWishlistInitial,"shareWishlistInitial");
	  sendData(inputBox,"santhosh271220@gmail.com","mail to share wishlist to");
	  elementClick(shareWishlistFinal,"shareWishlistFinal");
	  String message=getText(wishlistShareCheck,"Your Wishlist has been shared.");
	  boolean result=false;
	  if(message.equalsIgnoreCase("Your Wishlist has been shared."))
	  {
		  result=true;
	  }
	return result;
	 
	}
	
	public ShoppingCartPage AddtoCart()
	{
		elementClick(addToCart,"addToCart");
		return new ShoppingCartPage(driver);
	}
	
}
