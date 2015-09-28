package dp.pages.components;

import com.codeborne.selenide.SelenideElement;
import dp.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.present;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LeftSearchPanelMinimized extends Page{
    public LeftSearchPanelMinimized(WebDriver driver) {
        super(driver);
    }

    SelenideElement showLeftMenuBtn = $(".lines-menu-bicon");
    SelenideElement accuracyIconSmall = $(".advanced-search-icon.accuracy");
    SelenideElement categoryIconSmall = $(".advanced-search-icon.category");
    SelenideElement contributorIconSmall = $(".advanced-search-icon.contributor");
    SelenideElement excludeIconSmall = $(".advanced-search-icon.exclude");
    SelenideElement orientationIconSmall = $(".advanced-search-icon.orientation");
    SelenideElement editorialIconSamll = $(".advanced-search-icon.editorial");
    SelenideElement peopleIconSmall = $(".advanced-search-icon.people");
    SelenideElement sizeIconSmall = $(".advanced-search-icon.size");
    SelenideElement colorIconSmall = $(".advanced-search-icon.color");

    SelenideElement sliderLine = $(By.xpath("//div[contains(@class,'ui-slider-inside')]"));
    SelenideElement sliderPoint = $(By.xpath("//span[contains(@class,'ui-slider-handle')]"));

    public SelenideElement getAccuracyIconSmall() {
        return accuracyIconSmall.shouldBe(visible);
    }

    public SelenideElement getShowLeftMenuBtn() {
        return showLeftMenuBtn.shouldBe(visible);
    }

    public SelenideElement getCategoryIconSmall() {
        return categoryIconSmall.shouldBe(visible);
    }

    public SelenideElement getContributorIconSmall() {
        return contributorIconSmall.shouldBe(visible);
    }

    public SelenideElement getExcludeIconSmall() {
        return excludeIconSmall.shouldBe(visible);
    }

    public SelenideElement getOrientationIconSmall() {
        return orientationIconSmall.shouldBe(visible);
    }

    public SelenideElement getEditorialIconSamll() {
        return editorialIconSamll.shouldBe(visible);
    }

    public SelenideElement getPeopleIconSmall() {
        return peopleIconSmall.shouldBe(visible);
    }

    public SelenideElement getSizeIconSmall() {
        return sizeIconSmall.shouldBe(visible);
    }

    public SelenideElement getColorIconSmall() {
        return colorIconSmall.shouldBe(visible);
    }

    public SelenideElement getSliderLine() {
        return sliderLine.should(present);
    }

    public SelenideElement getSliderPoint() {
        return sliderPoint.shouldBe(present);
    }

}
