package dp.pages;

import org.openqa.selenium.WebDriver;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AnyPage extends Page {
    public AnyPage(WebDriver driver) {
        super(driver);
    }

    SelenideElement livechatLink = $(".livechat-link");

    public boolean ensurePageLoaded(){
        waitForAjax(driver);
        waitElementLoadedAndVisible(livechatLink.toWebElement());
        return livechatLink.isDisplayed();
    }
}