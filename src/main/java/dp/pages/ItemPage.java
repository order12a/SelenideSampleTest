package dp.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class ItemPage extends AnyPage{
    SelenideElement imageHolder = $(By.xpath("//div[contains(@class, 'image deposit-item')]//img"));
    SelenideElement addToCartIcon = $(By.xpath("//span[contains(@class, 'd_addToCart')]/span"));

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public boolean ensurePageLoaded(){
        imageHolder.waitUntil(Condition.visible, WAIT_SECONDS);
        return imageHolder.is(Condition.visible);
    }

    public void addToCart() {
        imageHolder.hover().find(By.xpath("//span[contains(@class, 'd_addToCart')]/span")).click();
    }
}
