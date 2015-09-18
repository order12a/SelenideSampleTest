package dp.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class MainPageLoggedOut extends AnyPage{
    public MainPageLoggedOut(WebDriver driver) {
        super(driver);
    }

    SelenideElement loginButton = $(By.xpath("//a[contains(@class, 'd_html_tips')]"));

    public void clickLoginButton(){
        loginButton.isDisplayed();
        loginButton.click();
    }
}
