package dp.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
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
    SelenideElement cartCounter = $(".shopping-cart-counter");
    SelenideElement itemIcon = $(".deposit-item");

    public boolean ensurePageLoaded(){
        waitForAjaxResponse(15);
        pageHead.waitUntil(Condition.visible, WAIT_SECONDS);
        return pageHead.isDisplayed();
    }

    public void clearCart(){
        clearCartButton.shouldBe(Condition.visible).click();
        removePromptButton.shouldBe(Condition.visible).click();
        waitForAjaxResponse(15);
        cartEmptyIndicator.waitUntil(Condition.visible, WAIT_SECONDS);
    }

    public String getCounterOfItems(){
        if(cartCounter.isDisplayed()){
            cartCounter.waitUntil(Condition.visible, WAIT_SECONDS);
            return cartCounter.getText();
        }else if(cartCounter.exists()){
            cartCounter.waitUntil(Condition.present, WAIT_SECONDS);
            return cartCounter.getText();
        }else {
            throw new ElementNotFound(cartCounter.toString(), Condition.present);
        }
    }

    public String getItemId() {
        itemIcon.shouldBe(Condition.visible);
        return itemIcon.getAttribute("data-id");
    }
}
