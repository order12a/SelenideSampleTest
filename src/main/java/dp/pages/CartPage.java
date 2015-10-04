package dp.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class CartPage extends AnyPage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    SelenideElement pageHead = $(".page-head>h1");
    SelenideElement itemForm = $(".cart-item");
    SelenideElement clearCartButton = $(".clear-button");
    SelenideElement removePromptButton = $(".button.l.blue.notification-popup");
    SelenideElement cartEmptyIndicator = $(".cart-empty>p");

    public boolean ensurePageLoaded(){
        waitForAjaxResponse(15);
        pageHead.waitUntil(Condition.visible, 15);
        return pageHead.isDisplayed();
    }

    public void clearCart(){
        clearCartButton.shouldBe(Condition.visible).click();
        removePromptButton.shouldBe(Condition.visible).click();
        waitForAjaxResponse(15);
        cartEmptyIndicator.waitUntil(Condition.visible, 15);
    }
}
