package temporary;

import com.codeborne.selenide.WebDriverRunner;
import dp.pages.*;
import org.openqa.selenium.WebDriver;

public class PageInit {
    public AnyPage anyPage;
    public MainPageLoggedOut mainPageLoggedOut;
    public LoginTip loginTip;
    public MainPageLoggedIn mainPageLoggedIn;
    public SearchPage searchPage;
    public LoginPageStatic loginPageStatic;

    public PageInit(){
        anyPage = new AnyPage(WebDriverRunner.getWebDriver());
        mainPageLoggedOut = new MainPageLoggedOut(WebDriverRunner.getWebDriver());
        loginTip = new LoginTip(WebDriverRunner.getWebDriver());
        mainPageLoggedIn = new MainPageLoggedIn(WebDriverRunner.getWebDriver());
    }

    public PageInit(WebDriver driver){
        anyPage = new AnyPage(driver);
        mainPageLoggedOut = new MainPageLoggedOut(driver);
        loginTip = new LoginTip(driver);
        mainPageLoggedIn = new MainPageLoggedIn(driver);
        searchPage = new SearchPage(driver);
        loginPageStatic = new LoginPageStatic(driver);
    }
}
