package bases;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

public class WebdriverFactory {

    //TODO implement factory for webdriver

    public WebDriver getWebdriver(){

        return WebDriverRunner.getWebDriver();
    }
}
