package logic.ready;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import temporary.PageInit;
import util.LogHelper;


public class DriverBasedHelper extends LogHelper{
    protected PageInit pages;

    public DriverBasedHelper(){
        pages = new PageInit(WebDriverRunner.getWebDriver());
    }

    public DriverBasedHelper(WebDriver driver){
        pages = new PageInit(driver);
    }
}
