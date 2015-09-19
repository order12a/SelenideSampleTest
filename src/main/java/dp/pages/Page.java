package dp.pages;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private static Logger LOG = LogManager.getLogger(Page.class);

    public Page(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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

    /*
    * This method is used to wait for getting response from all Ajax requests
    */

    public void waitForAjaxResponse(int timeoutSeconds){
        if (driver instanceof JavascriptExecutor) {
            JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
            for (int i = 0; i < timeoutSeconds; i++) {
                Long numberOfConnections = (Long) jsDriver.executeScript("return jQuery.active");
                if (numberOfConnections instanceof Long) {
                    LOG.debug("Number of active jQuery Ajax calls is <" + numberOfConnections + ">");
                    if (numberOfConnections == 0)
                        break;
                }
            }
        } else {
            LOG.info("Web Driver: <" + driver + "> can't execute JavaScript");
        }
    }

    /*
     * wait for Ajax using JS finished
     */

    public void waitForJavaScriptResponse(int timeoutSeconds){
        if(driver instanceof JavascriptExecutor && timeoutSeconds > 0){
            JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
            for (int i = 0; i < timeoutSeconds; i++){
                Long jsConnections = (Long) jsDriver.executeScript("return (xmlhttp.readyState >= 2 && xmlhttp.status == 200)");
                if(jsConnections instanceof Long){
                    LOG.debug("Number of active jQuery Ajax calls is <" + jsConnections + ">");
                    if (jsConnections == 0)
                        break;
                }
            }
        }else{
            LOG.info("Web Driver: <" + driver + "> can't execute JavaScript");
        }
    }

    /*
     * Wait for Ajax another implementation
     */

    public static void waitForAjax(WebDriver driver) {
        new WebDriverWait(driver, 180).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
    }
}
