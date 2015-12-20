package dp.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class PopupItemPage extends AnyPage{
    public PopupItemPage(WebDriver driver) {
        super(driver);
    }

    SelenideElement imageContainer = $(".image.deposit-item>div>img");
    SelenideElement popupItemCloseIcon = $(".close-cross-bicon.close-inline.white");
    SelenideElement downloadButton = $(".d-button-simple.d-xxl.d-red-color-button");
    SelenideElement addToCartIcon = $(".to-cart-bicon>span");
    SelenideElement addToFavoritesIcon = $(".lightbox-add>span");
    SelenideElement nextItemIcon = $(".circle-next-bicon.gray>i");
    SelenideElement previousItemIcon = $(".circle-prev-bicon.gray");

    public boolean ensurePageLoaded(){
        imageContainer.waitUntil(Condition.visible, 15);
        return imageContainer.isDisplayed();
    }

    public void clickDownloadButton(){
        downloadButton.shouldBe(Condition.visible).click();
    }

    public void addToCart(){
        imageContainer.hover().find(".lightbox-add>span").click();
    }

    public void addToFavorites(){
        imageContainer.hover();
        addToCartIcon.click();
    }
}
