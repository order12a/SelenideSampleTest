package logic.ready;

import com.codeborne.selenide.WebDriverRunner;
import temporary.PageInit;
import util.LogHelper;


public class DriverBasedHelper extends LogHelper{
    protected PageInit pages;

    public DriverBasedHelper(){
        pages = new PageInit(WebDriverRunner.getWebDriver());
    }

}
