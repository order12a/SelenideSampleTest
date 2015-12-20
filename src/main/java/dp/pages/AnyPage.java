package dp.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnyPage extends Page {
    public AnyPage(WebDriver driver) {
        super(driver);
    }

    SelenideElement livechatLink = $(".livechat-link");
    SelenideElement cartCounter = $(".shopping-cart-counter.counter-label");

    public boolean ensurePageLoaded(){
        waitForAjax(driver);
        waitElementLoadedAndVisible(livechatLink.toWebElement());
        return livechatLink.isDisplayed();
    }

    public boolean isCartIndexIncreased(){
        cartCounter.waitUntil(visible, WAINT_SECONDS);
        return cartCounter.getAttribute("data-value").length() > 0;
    }
}
