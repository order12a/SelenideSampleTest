package dp.pages.components;

import com.codeborne.selenide.Condition;
import dp.pages.Page;
import org.openqa.selenium.WebDriver;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LeftSearchPanel extends Page{
    public LeftSearchPanel(WebDriver driver) {
        super(driver);
    }


}
