package temporary.init;

import com.codeborne.selenide.WebDriverRunner;
import dp.pages.AnyPage;


public class PageInit {
    public AnyPage anyPage;

    public PageInit(){
        anyPage = new AnyPage(WebDriverRunner.getWebDriver());
    }
}
