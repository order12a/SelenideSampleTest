package dp.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import dp.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class LoginTip extends Page {
    public LoginTip(WebDriver driver){
        super(driver);
    }

    SelenideElement usernameField = $(By.name("username"));
    SelenideElement passwordField = $(By.name("password"));
    SelenideElement logInButton = $(By.xpath("//form/input[@type='submit']"));

    public void login(String login, String password){
        usernameField.shouldBe(Condition.visible);
        usernameField.setValue(login);
        passwordField.val(password);
        logInButton.shouldBe(Condition.enabled);
        logInButton.click();
    }
}
