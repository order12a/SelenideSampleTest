package dp.pages;

import com.codeborne.selenide.SelenideElement;
import dp.pages.components.LeftSearchPanelMinimized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage extends AnyPage{
    SelenideElement searchField = $("#d_search4");
    SelenideElement searchButton = $(".search-button");
    SelenideElement searchResultHolder = $(".item-image>img");
    List<SelenideElement> searchResultHolders = $$(".item-image>img");
    SelenideElement addToCartIcon = $(By.xpath("//span[@class='item-action']/span[@class='shopping-cart-button']"));
    SelenideElement clearFiltersLink = $(By.xpath("//div[@class='control-item clear-text-label active']/a"));
    SelenideElement contributorFilterIcon = $(".filter-item.contributor.active>span");

    LeftSearchPanelMinimized leftPanelSmall;

    public SearchPage(WebDriver driver) {
        super(driver);
        leftPanelSmall = new LeftSearchPanelMinimized(driver);
    }

    public boolean ensurePageLoaded(){
        super.ensurePageLoaded();
        return searchButton.shouldBe(visible).isDisplayed() && searchField.shouldBe(visible).isDisplayed();
    }

    public void searchByKeyword(String keyword){
        searchField.exists();
        searchField.clear();
        searchField.val(keyword);
        searchButton.shouldBe(visible).click();
    }

    public boolean isSearchResultDisplayed(){
        waitForAjax(driver);
        searchResultHolder.isDisplayed();
        return searchResultHolders.size() > 0;
    }

    public SelenideElement getTargetResultItem(int index){
        return $(By.xpath("(//span[contains(@class,'item-image')])[" + index + "]"));
    }

    public void clickAtResultItem(int index){
        getTargetResultItem(index).shouldBe(visible).click();
    }

    public void addToCart(int[] indexes){
        if (indexes.length > 0){
            for (int index: indexes){
                getTargetResultItem(index).hover().find(By.xpath("//span[@class='item-action']/span[@class='shopping-cart-button']")).shouldBe(visible).click();
                waitForAjax(driver);
            }
        }else {
            getTargetResultItem(1).hover().find(By.xpath("//span[@class='item-action']/span[@class='shopping-cart-button']")).shouldBe(visible).click();
        }
    }

    public void enableMaxResultFilterAtSmallPanel() {
        leftPanelSmall.getAccuracyIconSmall().click();
        leftPanelSmall.getSliderPoint().click();
        int sliderWidth = leftPanelSmall.getSliderLine().toWebElement().getSize().getWidth();
        Actions moveSlider = new Actions(driver).moveToElement(leftPanelSmall.getSliderPoint()).clickAndHold(leftPanelSmall.getSliderPoint()).moveByOffset(80, 0).release();
        moveSlider.build().perform();
        waitForAjaxResponse(15);
    }

    public void searchByContributorMinimized(String contributor) {
        leftPanelSmall.getContributorIconSmall().click();
        leftPanelSmall.getContributorField().val(contributor);
        leftPanelSmall.getApplyContributorButton().click();
    }

    public boolean checkContributorFilterPresent(String contributor) {
        return contributorFilterIcon.getText().equals(contributor);
    }

    public SearchPage clearFilters(){
        clearFiltersLink.click();
        ensurePageLoaded();
        return this;
    }

    public boolean hasSearchFieldKeyword(String searchRequest) {
        return searchField.getAttribute("value").equalsIgnoreCase(searchRequest);
    }
}
