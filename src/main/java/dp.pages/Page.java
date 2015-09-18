package dp.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.codeborne.selenide.WebDriverRunner;

public abstract class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private static Logger LOG = Logger.getLogger(Page.class);

    public Page(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
}
