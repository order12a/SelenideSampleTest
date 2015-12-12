package dp.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import dp.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class PasswordRecoveryPopup extends Page{

    public PasswordRecoveryPopup(WebDriver driver) {
        super(driver);
    }

    SelenideElement userNameFieldP = $(".d-input[name=username]");
    SelenideElement userEmailFieldP = $(".d-input[name=email]");
    SelenideElement sendResetLink = $(".button.l.blue.d-sendLink");
    SelenideElement promptOkButton = $(By.xpath("(//button[@class='button l blue'])[1]"));
    SelenideElement closePopupButton = $(By.xpath("//div[contains(@class, 'popup-close')]"));

    public void resetPasswordViaEmail(String email){
        userEmailFieldP.shouldBe(Condition.visible).val(email);
        clickResetLink();
        promptOkButton.shouldBe(Condition.visible).click();
    }

    public void resetPasswordViaUsername(String username){
        userNameFieldP.shouldBe(Condition.visible).val(username);
        clickResetLink();
        promptOkButton.shouldBe(Condition.visible).click();
    }

    public void clickResetLink(){
        sendResetLink.shouldBe(Condition.visible).click();
    }

    public boolean isPopupDisplayed(){
        return closePopupButton.isDisplayed();
    }

    public void closePopup(){
        closePopupButton.shouldBe(Condition.visible).click();
    }
}
