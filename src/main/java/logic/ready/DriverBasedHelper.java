package logic.ready;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import dp.pages.PageManager;
import util.LogHelper;


public class DriverBasedHelper extends LogHelper{
    protected PageManager pages;

    public DriverBasedHelper(){
        pages = new PageManager(WebDriverRunner.getWebDriver());
    }

    public DriverBasedHelper(WebDriver driver){
        pages = new PageManager(driver);
    }
}
