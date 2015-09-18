package dp.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private static Logger LOG = Logger.getLogger(Page.class);

    public Page(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    //Try to avoid using it! as it will slow down tests and is Thread-unsafe if will run tests in parallel! Use implicit waits instead (e.g. waitForElementPresent etc...)!
    public void waitSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //wait wrapper to wait elements generating by js framework e.g. Backbone (pure webdriver implementation)
    public void waitElementLoadedAndVisible(WebElement element){
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }

    //wait wrapper to wait elements generating by js framework e.g. Backbone (pure webdriver implementation)
    public void waitElementLoadedAndClickable(WebElement element){
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }
}
