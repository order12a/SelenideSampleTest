package dp.pages;

import com.codeborne.selenide.WebDriverRunner;
import dp.pages.*;
import org.openqa.selenium.WebDriver;

public class PageManager {
    public AnyPage anyPage;
    public MainPageLoggedOut mainPageLoggedOut;
    public LoginTip loginTip;
    public MainPageLoggedIn mainPageLoggedIn;
    public SearchPage searchPage;
    public LoginPageStatic loginPageStatic;
    public CartPage cartPage;
    public PopupItemPage popupItemPage;

    public PageManager(){
        anyPage = new AnyPage(WebDriverRunner.getWebDriver());
        mainPageLoggedOut = new MainPageLoggedOut(WebDriverRunner.getWebDriver());
        loginTip = new LoginTip(WebDriverRunner.getWebDriver());
        mainPageLoggedIn = new MainPageLoggedIn(WebDriverRunner.getWebDriver());
    }

    public PageManager(WebDriver driver){
        anyPage = new AnyPage(driver);
        mainPageLoggedOut = new MainPageLoggedOut(driver);
        loginTip = new LoginTip(driver);
        mainPageLoggedIn = new MainPageLoggedIn(driver);
        searchPage = new SearchPage(driver);
        loginPageStatic = new LoginPageStatic(driver);
        cartPage = new CartPage(driver);
        popupItemPage = new PopupItemPage(driver);
    }
}
