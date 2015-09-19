package dp.pages;

import org.openqa.selenium.WebDriver;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;

public class AnyPage extends Page {
    public AnyPage(WebDriver driver) {
        super(driver);
    }

    SelenideElement livechatLink = $(".livechat-link");

    public void setPageLoadTimeout(int waitTimeInSeconds){
        driver.manage().timeouts().pageLoadTimeout(waitTimeInSeconds, TimeUnit.SECONDS);
    }

    public void setImplicitlyWaitTime(int waitTimeInSeconds){
        driver.manage().timeouts().implicitlyWait(waitTimeInSeconds, TimeUnit.SECONDS);
    }


    public boolean ensurePageLoaded(){
        waitForAjax(driver);
        waitElementLoadedAndVisible(livechatLink.toWebElement());
        return livechatLink.isDisplayed();
    }
}
