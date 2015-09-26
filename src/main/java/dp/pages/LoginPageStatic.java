package dp.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import dp.pages.components.PassworRecoveryPopup;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;

public class LoginPageStatic extends AnyPage implements PassworRecoveryPopup{
    public LoginPageStatic(WebDriver driver) {
        super(driver);
    }

    SelenideElement usernameField = $(".d_placeholder[name=username]:first-child");
    SelenideElement passwordField = $(".d_placeholder[name=password]:first-child");
    SelenideElement logInButton = $(".d-button-simple[type=submit]");
    SelenideElement passwordRecoveryLink = $(".d_password_reset[data-action=password-recovery]");


    public boolean ensurePageLoaded(){
        waitForAjaxResponse(15);
        return logInButton.shouldBe(Condition.visible).isDisplayed();
    }

    public void recoverPasswordByEmail(String email){
        passwordRecoveryLink.shouldBe(Condition.visible).click();
        isPopupDisplayed();
        resetPasswordViaEmail(email);
    }

    public void recoverPasswordByUsername(String username){
        passwordRecoveryLink.shouldBe(Condition.visible).click();
        isPopupDisplayed();
        resetPasswordViaUsername(username);
    }

    public void login(String username, String password){
        usernameField.val(username);
        passwordField.val(password);
        waitForAjax(driver);
        logInButton.click();
    }
}
