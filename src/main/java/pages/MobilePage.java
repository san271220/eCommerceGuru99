package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BasePage;

public class MobilePage extends BasePage {
	
public MobilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
private String mobile_dd= "css=>.category-products > .toolbar > .sorter > .sort-by > select[title='Sort By']";
private String xperiamobilePriceOverview="xpath=>//div[@class='price-box']/span[@id='product-price-1']/span";
private String XperiaProductClick="xpath=>//img[@id='product-collection-image-1'][@alt='Xperia']";
private String xperiaPriceProduct="xpath=>//div[@class='price-box']/span[@id='product-price-1']/span";
private String productQty="css=>input#qty";
private String addToCart="css=>button[title='Add to Cart'] > span > span";
private String messages="css=>.messages span";
private String xperiaAddToCompare="css=>li:nth-of-type(1) > .product-info  .add-to-links  .link-compare";
private String iphoneAddToCompare="csss=>li:nth-of-type(2) > .product-info  .add-to-links  .link-compare";
private String xperiaCompareList="css=>.item.odd > .product-name > a";
private String iphoneCompareList="css=>.even.item.last > .product-name > a";
private String addToCompareButton="css=>button[title='Compare'] > span > span";
private String xperiaComparePopUP="css=>.product-name > a[title='Sony Xperia']";
private String iphoneComparePopUP="css=>.product-name > a[title='IPhone']";

List<String>mobiles=new ArrayList<String>();


public List<String> mobiledd() {
	selectOption(mobile_dd,"Name","Mobile dropdown selected");
		
	List<WebElement> MobileElementList=getElementList("xpath=>.//img[contains(@id,'product-collection-image')]", "MobileNameDropdown");
	
    System.out.println("The size of list is "+MobileElementList.size());
	for(int i=0;i<MobileElementList.size();i++)
	{
		  WebElement mobileElement=MobileElementList.get(i);
		  String name=mobileElement.getAttribute("alt");
		  System.out.println(name);
		  mobiles.add(name);
	}
	return mobiles;
}

public boolean mobilePrice()
{
	
	String mobilePriceOver=getText(xperiamobilePriceOverview,"mobile price overview");
	elementClick(XperiaProductClick,"Xperia product click");
	String mobilePriceProduct=getText(xperiaPriceProduct,"mobile price product");
	if(mobilePriceOver.equalsIgnoreCase(mobilePriceProduct))
	{
		return true;
	}
	return false;
	
}

public boolean qtyErrorMessageCheck()
{
	elementClick(XperiaProductClick,"Xperia product click");
	sendData(productQty,"1000","setting product Quantity");
	elementClick(addToCart,"addToCart");
	String errorText=getText(messages,"Error message for product Qty");
	if(errorText!=null)
	{
		return true;
	}
	return false;	
}

public boolean mobileAddToCompare()
{
	elementClick(xperiaAddToCompare,"xperiaAddToCompare");
	elementClick(iphoneAddToCompare,"iphoneAddToCompare");
	String xperiaCompareListValue=getText(xperiaCompareList,"Xperia compare List");
	String iphoneCompareListValue=getText(iphoneCompareList,"iphone compare List");
	boolean compareResult=false;
	boolean compareResultPopUp=false;
	if(xperiaCompareListValue.equalsIgnoreCase("SONY XPERIA")&&iphoneCompareListValue.equalsIgnoreCase("IPHONE"))
	{
		compareResult=true;
	}
	elementClick(addToCompareButton,"AddToCompareButton");
	String xperiaProductPopUp=getText(xperiaComparePopUP,"Xperia compare PopUp");
	String iphoneProductPopUp=getText(iphoneComparePopUP,"iphone compare Popup");
	if(xperiaProductPopUp.equalsIgnoreCase("SONY XPERIA")&&iphoneProductPopUp.equalsIgnoreCase("IPHONE"))
	{
		compareResultPopUp=true;
	}
	if(compareResult==true && compareResultPopUp==true)
	{
		return true;
	}
	return false;
	
}
}
