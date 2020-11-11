package pages;

import base.BasePage;
import utilities.Util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /***
     * Variables
     * Locators
     * URL
     */
    public WebDriver driver;
   
    private String UserID = "xpath=>.//*[@id='email']";
    private String PASSWORD_FIELD = "xpath=>.//*[@id='pass']";
    private String LOG_IN_BUTTON = "xpath=>.//*[@id='send2']/span/span";

    /***
     * Methods
     */

    public NavigationPage signInWith(String uid, String password) {

        sendData(UserID, uid, "User ID Field");
        sendData(PASSWORD_FIELD, password, "Password Field");
        elementClick(LOG_IN_BUTTON, "Login Button");
        return new NavigationPage(driver);
    }
}
