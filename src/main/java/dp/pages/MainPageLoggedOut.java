package dp.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class MainPageLoggedOut extends AnyPage{
    public MainPageLoggedOut(WebDriver driver) {
        super(driver);
    }

    SelenideElement banner = $(".series-element");
    SelenideElement loginButton = $(By.xpath("//a[contains(@class, 'd_html_tips')]"));
    SelenideElement searchField = $("#d_search2");
    SelenideElement searchButton = $(".search-button");

    public boolean ensurePageLoaded(){
        waitForAjax(driver);
        return banner.shouldBe(Condition.visible).isDisplayed();
    }

    public void clickLoginButton(){
        loginButton.waitUntil(Condition.visible, WAIT_SECONDS).click();
    }

    public void searchByKeyword(String searchRequest) {
        searchField.clear();
        searchField.val(searchRequest);
        searchButton.waitUntil(Condition.visible, WAIT_SECONDS).click();
    }

}
