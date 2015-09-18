package temporary;

import com.codeborne.selenide.WebDriverRunner;
import dp.pages.AnyPage;
import dp.pages.LoginTip;
import dp.pages.MainPageLoggedOut;

public class PageInit {
    public AnyPage anyPage;
    public MainPageLoggedOut mainPageLoggedOut;
    public LoginTip loginTip;

    public PageInit(){
        anyPage = new AnyPage(WebDriverRunner.getWebDriver());
        mainPageLoggedOut = new MainPageLoggedOut(WebDriverRunner.getWebDriver());
        loginTip = new LoginTip(WebDriverRunner.getWebDriver());
    }
}
